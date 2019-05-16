
https://github.com/googlesamples/android-architecture-components/issues/29
https://issuetracker.google.com/issues/64988610


we want to get rid of all that setter logic, that kind of sucks - findviewbyId really is lousy

why should you use DataBinding ?

it gives you type safe.
compiled time verified replacement to the standard findViewById


Two way data binding
Two-way Data Binding is a technique of binding your objects to your XML layouts so that both the
object can send data to the layout, and the layout can send data to the object.
<EditText android:text="@={user.name}"

Inverse binding method

