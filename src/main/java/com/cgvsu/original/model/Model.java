package com.cgvsu.original.model;

import com.cgvsu.original.vector.Vector2f;
import com.cgvsu.original.vector.Vector3f;

import java.util.*;

public class Model {

    public final ArrayList<Vector3f> vertices = new ArrayList<>();
    public final ArrayList<Vector2f> textureVertices = new ArrayList<>();
    public final ArrayList<Vector3f> normals = new ArrayList<>();
    public final ArrayList<Polygon> polygons = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return vertices.equals(model.vertices)
                && textureVertices.equals(model.textureVertices)
                && normals.equals(model.normals)
                && polygons.equals(model.polygons);
    }

}
