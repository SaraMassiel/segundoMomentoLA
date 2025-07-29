# 🛒 Gestión de Productos en Inventario

Este proyecto en Java permite gestionar un inventario de productos, incluyendo control de productos perecederos y no perecederos. Se ejecuta en consola e incluye funcionalidades básicas como agregar, mostrar, modificar y eliminar productos.

---

## 📦 Características principales

✅ Registro de productos con:
- Código único
- Nombre
- Precio
- Fecha de ingreso
- Indicador de si es perecedero
- Fecha de vencimiento (si aplica)

🔄 Funcionalidades:
- Agregar productos 🆕
- Mostrar todos los productos 📋
- Modificar productos 🛠️
- Eliminar productos ❌
- Eliminación automática de productos perecederos vencidos hace más de 3 días ⏳

---

## 🧠 Lógica destacada

🗑️ **Eliminación automática de vencidos:**  
Cada vez que se muestra el menú, el sistema elimina los productos perecederos que hayan vencido hace más de 3 días a partir de la fecha actual.

```java
if (perecederos.get(i) && hoy.isAfter(fechasVencimiento.get(i).plusDays(3))) {
    // Se elimina el producto vencido
}


---

## 💻 Requisitos

- ☕ Java 8 o superior
- 🖥️ Consola / Terminal

---

## 🚀 ¿Cómo ejecutar?

1. **Clona o descarga** este repositorio.
2. Abre una terminal y compila los archivos:

```bash
javac Producto.java MenuSimple.java
