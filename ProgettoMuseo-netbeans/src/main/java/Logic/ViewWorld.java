/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.RenderingAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TransparencyAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author S_Ale AKA S0Ale
 * Questa classe rappresenta il mondo 3D che verrà visualizzato.
 */
public class ViewWorld {
    
    private BranchGroup scene;
    private SimpleUniverse universe;
    
    public ViewWorld(Canvas3D canvas){
        scene = createScene(0);
        
        SimpleUniverse universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(scene);
    }
    
    private BranchGroup createScene(int i){
        float eyeOffset = 0.03F;
        
        BranchGroup objRoot = new BranchGroup();
        try{
            ObjectFile obj = new ObjectFile();
        
            Transform3D myTransform3D = new Transform3D();
            myTransform3D.setTranslation(new Vector3f(+0.0f,-0.15f,-3.6f));
            TransformGroup objTrans = new TransformGroup(myTransform3D);
            objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            Transform3D t = new Transform3D();
            TransformGroup tg = new TransformGroup(t);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            objTrans.addChild(tg);
            obj.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
            System.out.println( "About to load" );

            //Scene s = obj.load(getClass().getResource("/aereo.obj"));
            Scene s = obj.load(new URL("http://localhost/Handgun_obj.obj"));
            System.out.println( "Daje" );
            Transform3D myTrans = new Transform3D();
            myTrans.setTranslation(new Vector3f(eyeOffset, -eyeOffset, 0F));
            TransformGroup mytg = new TransformGroup(myTrans);
            tg.addChild(mytg);

            Hashtable table = s.getNamedObjects(); 
            for (Enumeration e = table.keys() ; e.hasMoreElements() ;) {
                Object key = e.nextElement();
                System.out.println(key);
                Object obj2 = table.get(key);
                System.out.println(obj.getClass().getName());
                Shape3D shape  = (Shape3D)obj2;
                Appearance ap = new Appearance();
                Color3f grey = new Color3f(0.6f, 0.6f, 0.6f);
                Color3f white = new Color3f(1f, 1f, 1f);
                Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
                ap.setMaterial(new Material(grey, black, grey, white, 5f));
                float transparencyValue = 0.5f;
                TransparencyAttributes t_attr =
                    new TransparencyAttributes(
                    TransparencyAttributes.BLENDED,
                    transparencyValue,
                    TransparencyAttributes.BLEND_SRC_ALPHA,
                    TransparencyAttributes.BLEND_ONE);
                ap.setTransparencyAttributes( t_attr );
                ap.setRenderingAttributes( new RenderingAttributes() );
                shape.setAppearance(ap);
                mytg.addChild(new Shape3D(shape.getGeometry(),ap));
            }
            System.out.println( "Finished Loading" );
            BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
            Color3f light1Color = new Color3f(.9f, 0.9f, 0.9f);
            Vector3f light1Direction  = new Vector3f(4.0f, -7.0f, -12.0f);
            DirectionalLight light1
            = new DirectionalLight(light1Color, light1Direction);
            light1.setInfluencingBounds(bounds);
            objTrans.addChild(light1);

            Color3f ambientColor = new Color3f(1.0f, .4f, 0.3f);
            AmbientLight ambientLightNode = new AmbientLight(ambientColor);
            ambientLightNode.setInfluencingBounds(bounds);
            objTrans.addChild(ambientLightNode);
            
            MouseRotate behavior = new MouseRotate();
	    behavior.setTransformGroup(tg);
	    objTrans.addChild(behavior);
	    MouseTranslate behavior3 = new MouseTranslate();
	    behavior3.setTransformGroup(tg);
	    objTrans.addChild(behavior3);
	    behavior3.setSchedulingBounds(bounds);
	    
	    KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(tg);
		keyNavBeh.setSchedulingBounds(new BoundingSphere(
			new Point3d(),1000.0));
		objTrans.addChild(keyNavBeh);
		
	    behavior.setSchedulingBounds(bounds);
            
            objRoot.addChild(objTrans);
        }catch(Throwable t){
            t.printStackTrace();
        }
        return objRoot;
    }
}
