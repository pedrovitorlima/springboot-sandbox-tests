<h1>Readme</h1>
<p>
  This project shows different ways to use unit tests with a Spring stack. 
  For example, how to test the web layer (controllers) and how to configure and use Mocks (with Mockito).
</p>

<h2>Web Layer</h2>
<p>
  Using <code>WebLayerController</code> as web layer</code>:
</p>
<ul>
  <li><code>WebLayerControllerTest</code> shows how to load the Spring Context with a web container (like Tomcat) and make web requests;</li>
  <li><code>WebLayerControllerTestWithMock_OnlyOneController</code> shows how to load only the (entire) web layer and perform tests;</li>
  <li><code>WebLayerControllerTestWithMock</code> shows how to load only one controller in web layer and dependencies, before performing tests.</li>
</ul>

<h2>Using Mocks and Mockito</h2>
<p>
  Take a look at <code>MockitoService</code>, <code>MockitoServiceTestConfiguration</code> and <code>MockitoServiceTest</code>.
</p>
<p>
  In Configuration class we define a Mock of our Service as a bean with the same name, but load it only when the "test" profile was active. 
  Also, in test class, we active this profile and use the mock through Sprint's DI and @Autowired.
  We can create this mock in execution time too, inside the test class, with <code>Mock.mock(MockitoService.class)</code>.
</p>
