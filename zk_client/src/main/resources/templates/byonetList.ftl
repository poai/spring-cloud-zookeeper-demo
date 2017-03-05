<html>
<head>
  <title>卡点列表</title>
</head>
<body>
  <p>Our latest product:
  
  <table>
  	<tr>
  		<th>KKID</th>
  		<th>KKMC</th>
  		<th>X</th>
  		<th>Y</th>
  	</tr>
  	<#list byonets as byonet>
  		<tr>
  			<td>${byonet.kkid}</td>
  			<td>${byonet.kkmc}</td>
  			<td>${byonet.x}</td>
  			<td>${x.y}</td>
  		</tr>
  	</#list>
  </table>
</body>
</html>