<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${bean.name}! you are like ${bean.likes}</h1>
  <p>Our latest product:
  <a href=""></a>!
  <#if bean.name=="Xiao Fen!!"> YES </#if>
  <#if (100 > 400) >
  	YES 
  <#elseif (200 <300) >
  	NO
  <#else>
  	OTHERS
  </#if>
  
  <table>
  	<#list list as l>
  		<tr>
  			<td>${l}</td>
  		</tr>
  	</#list>
  </table>
  <#list list >
  	  <ul>
			<#items as ls_ >
				<li>${ls_}<#sep>and</#sep>
			</#items>
  	  </ul>
  </#list>

</body>
</html>