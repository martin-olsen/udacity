object Quiz4 extends App {
  Seq(
    (LAVector(-7.579, -7.88), LAVector(22.737, 23.64)),
    (LAVector(-2.029, 9.97, 4.172), LAVector(-9.231, -6.639, -7.245)),
    (LAVector(-2.328, -7.284, -1.214), LAVector(-1.821, 1.072, -2.94)),
    (LAVector(2.118, 4.827), LAVector(0, 0))
  ).foreach{case (v1, v2) => println(s"${v1.parallelTo(v2)}, ${v1.orthogonalTo(v2)}")}
}
