import static org.junit.Assert.*; 

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

import org.junit.Test; 


public class UnitTests { 
    private static int passed = 0; 
     
    @Test 
    public void testEntity() { 
        Entity.setEntity(10); 
        assertEquals(10,Entity.bloodstream.length); 
        assertNotEquals(0,++passed); 
    }     
     
    @Test 
    public void testBacteria1() { 
        Bacteria b = new Bacteria(Strength.MEDIUM); 
        assertEquals(Strength.MEDIUM,b.getStrength()); 
        assertEquals("bacteria",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed); 
    }     
     
    @Test 
    public void testBacteria2() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA()); 
         
        b.touchNeighbor(null); 
        assertNotEquals(0,++passed);         
    }     

    @Test 
    public void testBacteria3() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Cytokine neighbor = new Cytokine(); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testBacteria4() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Entity[] targets = {}; 
        Lymphocyte neighbor = new Lymphocyte("medium",targets); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBacteria5() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Entity[] targets = {}; 
        Macrophage neighbor = new Macrophage("medium",targets); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBacteria6() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Entity[] targets = {}; 
        Neutrophil neighbor = new Neutrophil("medium",targets,false); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBacteria7() { 
        Entity.setEntity(5); 
        Bacteria b = new Bacteria(Strength.DEAD); 
        Virus neighbor = new Virus(Strength.MEDIUM); 
        b.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
         
        b.setStrength(Strength.LOW); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[0].getDNA());         

        b.setStrength(Strength.MEDIUM); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[1].getDNA());         
         
        b.setStrength(Strength.HIGH); 
        b.touchNeighbor(neighbor);         
        assertEquals("bacteria",Entity.bloodstream[2].getDNA());     
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testCytokine0() { 
        Cytokine b = new Cytokine(); 
        assertEquals(Strength.DEAD,b.getStrength()); 
        assertEquals("cytokine",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine1(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
         
        c.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testCytokine2(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Cytokine neighbor = new Cytokine(); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine3(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Entity[] targets = {};         
        Lymphocyte neighbor = new Lymphocyte("medium",targets); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine4(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Entity[] targets = {};         
        Macrophage neighbor = new Macrophage("medium",targets); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine5(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Virus neighbor = new Virus(Strength.HIGH); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testCytokine6(){ 
        Entity.setEntity(5);         
        Cytokine c = new Cytokine(); 
        Entity[] targets = {};         
        Neutrophil neighbor = new Neutrophil("medium",targets,false); 
        c.touchNeighbor(neighbor); 
        assertEquals(null,Entity.bloodstream[0]); 
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertEquals(Strength.DEAD,c.getStrength());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage0() { 
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage b = new Macrophage("medium",targets); 
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("macrophage",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testMacrophage1(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
         
        m.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage2(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Virus neighbor = new Virus(Strength.HIGH); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage3(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testMacrophage4(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
        neighbor.setStrength(Strength.LOW); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage5(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
         
        for (int i = 0; i < 99; i++){ 
            neighbor.setStrength(Strength.LOW); 
            m.touchNeighbor(neighbor); 
        } 
        assertEquals(Strength.HIGH,m.getStrength()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testMacrophage6(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
         
        for (int i = 0; i < 105; i++){ 
            neighbor.setStrength(Strength.LOW); 
            m.touchNeighbor(neighbor); 
        } 
        assertEquals(Strength.DEAD,m.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testMacrophage7(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};             
        Macrophage m = new Macrophage("medium",targets); 
        Neutrophil neighbor = new Neutrophil("large",targets,false); 
        neighbor.setStrength(Strength.LOW); 
        m.setStrength(Strength.DEAD); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor); 
        m.touchNeighbor(neighbor);         
        assertEquals(Strength.LOW,neighbor.getStrength()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil0() { 
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil b = new Neutrophil("medium",targets,false);     
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("neutrophil",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }         
     
    @Test 
    public void testNeutrophil1(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,false);         
        Cytokine neighbor = new Cytokine(); 
        n.setStrength(Strength.LOW); 
        n.touchNeighbor(neighbor); 
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertEquals(Strength.LOW,n.getStrength());     
         
        n.touchNeighbor(null);     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil2(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Cytokine neighbor = new Cytokine(); 
        n.setStrength(Strength.LOW);         
        n.touchNeighbor(neighbor); 
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertEquals(Strength.MEDIUM,n.getStrength());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil3(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Virus neighbor = new Virus(Strength.HIGH);     
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(Strength.HIGH,n.getStrength());     
        assertEquals("cytokine",Entity.bloodstream[0].getDNA()); 
        assertEquals("cytokine",Entity.bloodstream[1].getDNA()); 
        assertEquals("cytokine",Entity.bloodstream[2].getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil4(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Virus neighbor = new Virus(Strength.HIGH);     
        n.setDNA("virus"); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
        assertNotEquals(Strength.HIGH,n.getStrength());     
        assertEquals("virus",Entity.bloodstream[0].getDNA()); 
        assertEquals("virus",Entity.bloodstream[1].getDNA()); 
        assertEquals("virus",Entity.bloodstream[2].getDNA());         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNeutrophil5(){ 
        Entity.setEntity(5);         
        Entity[] targets = {new Bacteria(Strength.HIGH)};     
        Neutrophil n = new Neutrophil("medium",targets,true);         
        Virus neighbor = new Virus(Strength.HIGH);     
        n.setDNA("virus"); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor); 
        n.touchNeighbor(neighbor);         
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
        assertEquals(Strength.HIGH,n.getStrength());     
        assertEquals(null,Entity.bloodstream[0]);         
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testVirus0() { 
        Virus b = new Virus(Strength.HIGH);     
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("virus",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testVirus1(){         
        Virus v = new Virus(Strength.HIGH);     
        Bacteria neighbor = new Bacteria(Strength.HIGH); 
        v.touchNeighbor(neighbor);     
        assertEquals(Strength.HIGH,neighbor.getStrength()); 
         
        v.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testVirus2(){         
        Virus v = new Virus(Strength.HIGH);     
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil neighbor = new Neutrophil("medium",targets,true);     
        v.touchNeighbor(neighbor);     
        assertEquals("virus",neighbor.getDNA()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testVirus3(){         
        Virus v = new Virus(Strength.DEAD);     
        Entity[] targets = {new Virus(Strength.HIGH)};     
        Neutrophil neighbor = new Neutrophil("medium",targets,true);     
        v.touchNeighbor(neighbor);     
        assertEquals("neutrophil",neighbor.getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testLymphocyte0() { 
        Entity[] targets = {new Virus(Strength.HIGH)};             
        Lymphocyte b = new Lymphocyte("small",targets);     
        assertEquals(Strength.HIGH,b.getStrength()); 
        assertEquals("lymphocyte",b.getDNA());     
        b.setStrength(Strength.HIGH); 
        assertEquals(Strength.HIGH,b.getStrength());     
        b.kill(); 
        assertEquals(Strength.DEAD,b.getStrength());     
        b.setDNA("staph"); 
        assertEquals("staph",b.getDNA()); 
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testLymphocyte1(){         
        Entity[] targets = {new Virus(Strength.HIGH)};             
        Lymphocyte l = new Lymphocyte("small",targets);     
        Virus neighbor = new Virus(Strength.HIGH);     
        l.touchNeighbor(neighbor);         
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor); 
        l.touchNeighbor(neighbor);         
        l.touchNeighbor(neighbor);         
        assertEquals(Strength.DEAD,neighbor.getStrength()); 
         
        l.touchNeighbor(null);         
        assertNotEquals(0,++passed);         
    }     
  
} 
