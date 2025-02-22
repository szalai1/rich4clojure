(ns rich4clojure.easy.problem-095
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = To Tree, or not to Tree =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [trees]
;; 
;; Write a predicate which checks whether or not a given
;; sequence represents a binary tree. Each node in the
;; tree must have a value, a left child, and a right
;; child.


(def __ (fn check-btree [t]
          (if (nil? t) true
              (if (or (not (sequential? t))
                      (not= 3 (count t))) false
                  (let [[v l r] t
                        lt (check-btree l)
                        rt (check-btree r)]
                    (and lt rt))))))

(comment
  
  )

(tests
  (__ '(:a (:b nil nil) nil)) :=
   true
  (__ '(:a (:b nil nil))) :=
   false
  (__ [1 nil [2 [3 nil nil] [4 nil nil]]]) :=
   true
  (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]]) :=
   false
  (__ [1 [2 [3 [4 nil nil] nil] nil] nil]) :=
   true
  (__ [1 [2 [3 [4 false nil] nil] nil] nil]) :=
   false
  (__ '(:a nil ())) :=
   false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/abc33dae1f190ae44f2ebd6d5aeec567