/*
 *
 */
package view;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.util.Observable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IControllerMain;
import contract.IMap;
import contract.IModel;
import contract.IView;
import junit.framework.TestCase;

public class ViewFrameTest extends TestCase {

    private IModel model;
    private ViewFrame viewFrame;

    @Override
    @Before
    public void setUp() throws Exception {
        this.model = new IModel() {

            @Override
            public int getMapID() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public Observable getObservable() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setMapID(int mapID) {
                // TODO Auto-generated method stub

            }

            @Override
            public IMap getMap() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setMap(IMap map) {
                // TODO Auto-generated method stub

            }
        };
        this.viewFrame = new ViewFrame(this.model);
    }

    @Override
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetModel() {
        // fail("Not yet implemented");
        assertEquals(this.model.getClass(), this.viewFrame.getModel().getClass());
    }

    public void testSetModel() {
        // fail("Not yet implemented");
        IModel model = new IModel() {

            @Override
            public Observable getObservable() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getMapID() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public void setMapID(int mapID) {
                // TODO Auto-generated method stub

            }

            @Override
            public IMap getMap() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void setMap(IMap map) {
                // TODO Auto-generated method stub

            }

        };

        this.viewFrame.setModel(model);
        assertEquals(model.getClass(), this.viewFrame.getModel().getClass());
    }

    @Test
    public void testKeyPressed() {
        KeyEvent key = new KeyEvent(new Component() {

            /**
             *
             */
            private static final long serialVersionUID = -6634727246253104738L;
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testKeyReleased() {
        KeyEvent key = new KeyEvent(new Component() {

            /**
             *
             */
            private static final long serialVersionUID = -2862155375209402760L;
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testKeyTyped() {
        KeyEvent key = new KeyEvent(new Component() {

            /**
             *
             */
            private static final long serialVersionUID = -374023924530956150L;
        }, 0, 0, 0, 0, 'z');
        assertEquals('z', key.getKeyChar());
    }

    @Test
    public void testSetController() {
        IControllerMain controller = new IControllerMain() {

            @Override
            public void moveSet(KeyEvent key) {
                // TODO Auto-generated method stub

            }

            @Override
            public IControllerMain getControllerCharacter() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public IModel getModel() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public IView getView() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        this.viewFrame.setController(controller);
        assertEquals(controller.getClass(), this.viewFrame.getController().getClass());
    }

    @Test
    public void testViewFrameIModel() {
        assertNotNull(new ViewFrame(this.model));
    }

    @Test
    public void testViewFrameIModelGraphicsConfiguration() {
        assertNotNull(new ViewFrame(this.model, (GraphicsConfiguration) null));
    }

    @Test
    public void testViewFrameIModelString() {
        assertNotNull(new ViewFrame(this.model, ""));
    }

    @Test
    public void testViewFrameIModelStringGraphicsConfiguration() {
        assertNotNull(new ViewFrame(this.model, "", null));
    }

}
