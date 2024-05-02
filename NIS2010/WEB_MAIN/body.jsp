<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">

<SCRIPT LANGUAGE="javascript">
var pgmNo="";
//var param="";

function pgmNoChk(){
	
	
	if (pgmNo=='VOP,OPF,M001') alert('The menu of terminal operation (TOR creation, Port time Performance, Cargo handling Performance and Terminal Productivity) has been dually running in "Terminal Operation and Operation&PFMC", but the releated menu of terminal operation will be completely transfered to Terminal Operation moudle by May15, 2012. So, from now on, we suggest you to use the TOR moudle for your terminal operation jobs.');
	
	
	}
	
	function moduleMainPage(){
		var module = parent.location.toString();
		
		if( module != null && module != '' )
		{
			var js_path = "apps/alps";			
			if( 
				(module.split('?').length == 2 ) && 
				( module.split('?')[1].split('=').length == 2 )
			)
			{
				var param = module.split('?')[1].split('=')[1].split('_');
				//apps/enis/esm/agt/agtaudit/agtaudit/jsp/ESM_AGT_010.js
				//document.myform.pgmNo.value=param;
				pgmNo=param;
				for( var i=0; i<param.length-1; i++)
				{
					js_path += 	"/" + param[i].toLowerCase();
					//alert( js_path + "/Co" + param[i].charAt(0) + param[i].substr(1).toLowerCase());
					parent.axon_assembler.include(js_path + "/Co" + param[i].charAt(0) + 
							param[i].substr(1).toLowerCase());
				}
			}
		}
				
		if(module.indexOf("ESM_BKG_M001") > -1 || module.indexOf("ESD_PRD_M001") > -1 || 
			module.indexOf("ESD_SCE_M001") > -1 || module.indexOf("ESD_TES_M001") > -1 || 
			module.indexOf("ESD_TRS_M001") > -1 || module.indexOf("FNS_INV_M001") > -1 || 
			module.indexOf("EES_CTM_M001") > -1 || module.indexOf("ESD_EAS_M001") > -1 || 
			module.indexOf("ESD_TPB_M001") > -1 || module.indexOf("ESM_RAS_M001") > -1 || 
			module.indexOf("ESM_MAS_M001") > -1 || 
			module.indexOf("EES_DMT_M001") > -1|| module.indexOf("ESD_TOR_M001") > -1){
			
			document.write('<img src="/hanjin/img/sub_1.jpg" width="970" height="490" alt="" border="0">');
			
		}else if(module.indexOf("ESM_SAQ_M001") > -1 || module.indexOf("ESM_SPC_M001") > -1 || 
			module.indexOf("ESM_PRI_M001") > -1 || module.indexOf("ESM_COA_M001") > -1 || 
			module.indexOf("ESM_BSA_M001") > -1 || module.indexOf("ESM_SQM_M001") > -1){
			
			document.write('<img src="/hanjin/img/sub_2.jpg" width="970" height="490" alt="" border="0">');
			
		}else if(module.indexOf("EES_EQR_M001") > -1 || module.indexOf("EES_MST_M001") > -1 || 
			module.indexOf("EES_CIM_M001") > -1 || module.indexOf("EES_CGM_M001") > -1 || 
			module.indexOf("EES_CGM_M019") > -1 || module.indexOf("EES_LSE_M001") > -1 || 
			module.indexOf("EES_MNR_M001") > -1 || module.indexOf("EES_DOD_M001") > -1){
			
			document.write('<img src="/hanjin/img/sub_3.jpg" width="970" height="490" alt="" border="0">');
			
		}else if(module.indexOf("VOP_OPF_M001") > -1 || module.indexOf("VOP_PSO_M001") > -1 || 
			module.indexOf("VOP_SCG_M001") > -1 || module.indexOf("VOP_VSK_M001") > -1 ||
			module.indexOf("VOP_FCM_M001") > -1){
			
			document.write('<img src="/hanjin/img/sub_4.jpg" width="970" height="490" alt="" border="0">');
			
		}else if(module.indexOf("CPS_CNI_M001") > -1 || module.indexOf("CPS_GEM_M001") > -1 || 
			module.indexOf("ESD_SPE_M001") > -1 || module.indexOf("ESM_FMS_M001") > -1 || 
			module.indexOf("ESM_AGT_M001") > -1 || module.indexOf("FNS_JOO_M001") > -1 ||
			module.indexOf("ESD_LEA_M001") > -1 || 
			module.indexOf("FNS_TOT_M001") > -1 || module.indexOf("ESM_BIS_M001") > -1){
			
			document.write('<img src="/hanjin/img/sub_5.jpg" width="970" height="490" alt="" border="0">');
			
		}else if(module.indexOf("BCM_000_M000") > -1){
			document.write('<img src="/hanjin/img/sub_7.jpg" width="970" height="490" alt="" border="0">');
		}else{
			document.write('<img src="/hanjin/img/sub_6.jpg" width="970" height="490" alt="" border="0">');
		}
		 
		//setTimeout(alert("111111"),5000); 
		//if(pgmNo=='VOP,OPF,M001') alert('The menu of terminal operation (TOR creation, Port time Performance, Cargo handling Performance and Terminal Productivity) has been dually running in "Terminal Operation and Operation&PFMC", but the releated menu of terminal operation will be completely transfered to Terminal Operation moudle by May15, 2012. So, from now on, we suggest you to use the TOR moudle for your terminal operation jobs.');
	}
	
	

</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="myform">
<input type="hidden" name="pgmNo" value="">
</form>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td style="height:45;"></td></tr>
		<tr>
			<td align="center" valign="middle">
			<table width="970" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<SCRIPT LANGUAGE="javascript">
						moduleMainPage();
						//2012.06.12
						//TOROPF POPUP MSG
						//setTimeout("pgmNoChk()", 1000); 
	     				
						</SCRIPT>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</body>
</html>