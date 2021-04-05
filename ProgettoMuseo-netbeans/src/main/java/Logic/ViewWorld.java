/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.net.URL;
import java.util.Enumeration;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.RenderingAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author S_Ale AKA S0Ale
 * Questa classe rappresenta il mondo 3D che verrà visualizzato.
 */
public class ViewWorld {
    
    private Canvas3D cv;
    
    private BranchGroup scene;
    private SimpleUniverse universe;
    
    public ViewWorld(Canvas3D canvas){
        this.cv = canvas;
        scene = createScene(0);
        
        universe = new SimpleUniverse(cv);
        universe.getViewingPlatform().setNominalViewingTransform();
        
        OrbitBehavior orbit = new OrbitBehavior(cv, OrbitBehavior.REVERSE_ALL);
        orbit.setZoomFactor(-1d);
        orbit.setRotateEnable(false);
        
        Background background = new Background(new Color3f(.1f, .1f, .1f));
        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(sphere);
        scene.addChild(background);
        
        BoundingSphere defaultBounds = new BoundingSphere(new Point3d(0, 0, 0), 100d);
        orbit.setSchedulingBounds(defaultBounds);
        universe.getViewingPlatform().setViewPlatformBehavior(orbit);
        
        universe.addBranchGraph(scene);
    }
    
    public void stop(){
        cv.stopRenderer();
    }
    
    public void start(){
        cv.startRenderer();
    }
    
    private BranchGroup createScene(int i){
        float eyeOffset = 0.01F;
        
        BranchGroup objRoot = new BranchGroup();
        try{
            ObjectFile obj = new ObjectFile();
        
            Transform3D myTransform3D = new Transform3D();
            myTransform3D.setTranslation(new Vector3f(0f,0f,-2f));
            TransformGroup objTrans = new TransformGroup(myTransform3D);
            objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            Transform3D t = new Transform3D();
            TransformGroup tg = new TransformGroup(t);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            objTrans.addChild(tg);
            obj.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);

            //Scene s = obj.load(getClass().getResource("/aereo.obj"));
            Scene s = obj.load(new URL("http://localhost/Katana.obj"));
            Transform3D myTrans = new Transform3D();
            myTrans.setTranslation(new Vector3f(eyeOffset, -eyeOffset, 0F));
            TransformGroup mytg = new TransformGroup(myTrans);
            tg.addChild(mytg);

            var table = s.getNamedObjects(); 
            for (Enumeration e = table.keys(); e.hasMoreElements() ;) {
                Object key = e.nextElement();
                Object obj2 = table.get(key);
                Shape3D shape  = (Shape3D)obj2;
                Appearance ap = new Appearance(); 
                Color3f grey = new Color3f(.4f, .4f, .4f);
                Color3f white = new Color3f(.8f, .8f, .8f);
                Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
                
                ap.setMaterial(new Material(grey, black, grey, white, 10f));
                ap.setRenderingAttributes( new RenderingAttributes() );
                shape.setAppearance(ap);
                mytg.addChild(new Shape3D(shape.getGeometry(),ap));
            }
            BoundingSphere bounds = new BoundingSphere(new Point3d(-6f,3f,0.0), 100.0);
            Color3f light1Color = new Color3f(.9f, 0.9f, 0.9f);
            Vector3f light1Direction  = new Vector3f(4.0f, -7.0f, -12.0f);
            
            DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
            light1.setInfluencingBounds(bounds);
            objTrans.addChild(light1);

            Color3f ambientColor = new Color3f(.8f, .8f, 0.8f);
            AmbientLight ambientLightNode = new AmbientLight(ambientColor);
            ambientLightNode.setInfluencingBounds(bounds);
            objTrans.addChild(ambientLightNode);
            
            MouseRotate behavior = new MouseRotate();
            behavior.setFactor(.009f);
	    behavior.setTransformGroup(tg);
	    objTrans.addChild(behavior);
	    MouseTranslate behavior3 = new MouseTranslate();
	    behavior3.setTransformGroup(tg);
	    objTrans.addChild(behavior3);
	    behavior3.setSchedulingBounds(bounds);
            
            behavior.setSchedulingBounds(bounds);
            
            objRoot.addChild(objTrans);
        }catch(Throwable t){
            t.printStackTrace();
        }
        return objRoot;
    }
}
