(ns rich4clojure.easy.problem-061
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Map Construction =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [core-functions]
;; 
;; Write a function which takes a vector of keys and a
;; vector of values and constructs a map from them.

(def restricted [zipmap])

(def __ (fn [a b]
  (second (reduce
           (fn [[r res] n]
             (if (or (empty? r) (empty? n))
               (reduced [nil res])
               [(rest r)
                (assoc res (first r) n)]))
           [a {}]  b))))

(tests
 (__ [:a :b :c] [1 2 3]) := {:a 1, :b 2, :c 3}
 (__ [1 2 3 4] ["one" "two" "three"]) := {1 "one", 2 "two", 3 "three"}
 (__ [:foo :bar] ["foo" "bar" "baz"]) := {:foo "foo", :bar "bar"})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/e9ba5a581234d1bddbae5caa2e51aa51