(ns tutorials.core
  (:require [cljsjs.babylon]
            [goog.dom :as dom]))

(enable-console-print!)

(defn createScene [canvas]
  (let [engine (js/BABYLON.Engine. canvas true)
        scene (js/BABYLON.Scene. engine)
        camera (js/BABYLON.FreeCamera. "camera1" (js/BABYLON.Vector3. 0 5 -10) scene)
        light (js/BABYLON.HemisphericLight. "light1" (js/BABYLON.Vector3. 0 1 0) scene)
        sphere (.CreateSphere js/BABYLON.Mesh "sphere1" 16 2 scene)
        ground (.CreateGround js/BABYLON.Mesh "ground1" 6 6 2 scene)]
    (.setTarget camera (.Zero js/BABYLON.Vector3))
    (.attachControl camera canvas false)
    (set! (-> sphere .-position .-y) 1)
    (.addEventListener js/window "resize" #(.resize engine))
    (.runRenderLoop engine #(.render scene))))

#_(createScene (dom/getElement "renderCanvas"))

(defn createScene [canvas]
  (let [engine (js/BABYLON.Engine. canvas true)
        scene (js/BABYLON.Scene. engine)
        camera (js/BABYLON.FreeCamera. "camera1" (js/BABYLON.Vector3. 0 5 -30) scene)
        light (js/BABYLON.HemisphericLight. "light1" (js/BABYLON.Vector3. 0 1 0) scene)
        box (.CreateBox js/BABYLON.Mesh "box1" 6 scene)
        sphere (.CreateSphere js/BABYLON.Mesh "sphere1" 16 2 scene)
        plane (.CreatePlane js/BABYLON.Mesh "plane1" 5 scene)
        disc (.CreateDisc js/BABYLON.Mesh "disc1" 3 30 scene)
        cylinder (.CreateCylinder js/BABYLON.Mesh "cylinder1" 3 3 3 6 1 scene)
        torus (.CreateTorus js/BABYLON.Mesh "torus1" 5 1 10 scene)
        knot (.CreateTorusKnot js/BABYLON.Mesh "knot1" 2 0.5 128 64 2 3 scene)
        mesh-lines (.CreateLines js/BABYLON.Mesh "lines1" (clj->js
                                                            [(js/BABYLON.Vector3. -10 0 0)
                                                             (js/BABYLON.Vector3. 10 0 0)
                                                             (js/BABYLON.Vector3. 0 0 -10)
                                                             (js/BABYLON.Vector3. 0 0 10)])  scene)
        ]
    (.setTarget camera (.Zero js/BABYLON.Vector3))
    (.attachControl camera canvas false)
    (set! (-> sphere .-position .-x) 5)
    (set! (-> disc .-position .-x) -7)
    (set! (-> plane .-position .-y) 6)
    (set! (-> box .-position .-y) -6)
    (set! (-> cylinder .-position .-x) -12)
    (set! (-> torus .-position .-x) 10)
    (set! (-> knot .-position .-x) 17)
    (set! (-> mesh-lines .-position .-y) 12)
    (.addEventListener js/window "resize" #(.resize engine))
    (.runRenderLoop engine #(.render scene))))

(createScene (dom/getElement "renderCanvasTwo"))

