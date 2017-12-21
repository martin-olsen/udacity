case class Vector(coordinates: Double*) {
  private def assertSameDimensions(vector: Vector): Unit = {
    if (vector.coordinates.size != coordinates.size) {
      throw new IllegalArgumentException("Vector must have same number of dimensions")
    }
  }
  def +(vector: Vector): Vector = {
    assertSameDimensions(vector)
    new Vector(coordinates.zip(vector.coordinates).map{case (i1, i2) => i1 + i2}: _*)
  }

  def -(vector: Vector): Vector = {
    assertSameDimensions(vector)
    new Vector(coordinates.zip(vector.coordinates).map{case (i1, i2) => i1 - i2}: _*)
  }

  def *(d: Double): Vector = {
    new Vector(coordinates.map(_ * d): _*)
  }

  def *:(d: Double): Vector = {
    * (d)
  }

  override def toString: String = s"Vector(${coordinates.mkString(", ")})"
}

object Vector extends App {
  println(Vector(8.218, -9.341) + Vector(-1.129, 2.111))
  println(Vector(7.119, 8.215) - Vector(-8.223, 0.878))
  println(Vector(1.671, -1.012, -0.318) * 7.41)
  println(7.41 *: Vector(1.671, -1.012, -0.318))
}
