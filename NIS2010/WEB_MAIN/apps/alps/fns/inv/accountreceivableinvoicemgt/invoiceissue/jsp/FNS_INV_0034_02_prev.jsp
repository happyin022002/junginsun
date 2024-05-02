<%

String viewFlag = request.getParameter("view_flag");
String title = "";

if (viewFlag.equals("I")) { 
	title = "Invoice Issue Preview";
} else if (viewFlag.equals("L")) {
	title = "Letter Wording Entry Preview";
} else if (viewFlag.equals("S")) {
	//0036 page pop
	title = "Invoice Issue Preview";	
} else if (viewFlag.equals("K")) {
	//0039 page pop
	title = "Invoice Issue Preview";
}

%>

<html>
<head>
<title><%=title%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
</head>

<script language="javascript" >
    var rdObjects = new Array();
    var rdCnt = 0;
    
    document.onclick = processButtonClick;
    
    function setupPage(){  
	    initRdConfig(rdObjects[0]);
	    window.setTimeout("invPreview(rdObjects[0])", 1000);	 
	    //invPreview(rdObjects[0]);   
    }    

   	function initRdConfig(rdObject){
   	    var Rdviewer = rdObject;
   	    var formObject = document.form;
   	    var viewFlag = formObject.view_flag.value ;

   	    Rdviewer.style.width = 780;
   	    Rdviewer.style.height = 610;
   	    //Rdviewer.DisableToolbar(0);   //Save As 
   	    if (viewFlag == "K") {
   	   		//Rdviewer.DisableToolbar(1); //Print
   	    	Rdviewer.DisableToolbar(2);
   	    	//Rdviewer.DisableToolbar(13);
   	    } else {
   	     	Rdviewer.DisableToolbar(1);
   	 	    Rdviewer.DisableToolbar(2);
   	 	    Rdviewer.DisableToolbar(13);
   	    }

   	    Rdviewer.DisableToolbar(3);
   	    Rdviewer.DisableToolbar(17);
   	    Rdviewer.DisableToolbar(15);
   	    Rdviewer.DisableToolbar(16);   	    
   	    
   	    Rdviewer.AutoAdjust = true;
   	    Rdviewer.ViewShowMode(0);

   		Rdviewer.setbackgroundcolor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);  
   		
   		var date = new Date();   
   		var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        var dd = date.getDate() > 10 ? date.getDate() : "0"+date.getDate();
        var mm = date.getMonth();
        var yy = date.getYear();       
   		var fileName = "SML INV_"+dd+months[mm]+yy;
   		
   		
   		Rdviewer.SetSaveDialog ("C:\\", fileName, 5);
   			
   	}   	
   	
   	function invPreview(rdObject) {

        var Rdviewer = rdObject;
		var rdFiles =  opener.document.form.com_mrdPath.value; 
		var rdParam = opener.document.form.com_mrdArguments.value;	

		var arrStr = rdFiles.split("|");	
		var arrStr2 = rdParam.split("|");
		//Rdviewer.SetAppendReport(1);
		for (var i = 0; i < arrStr.length-1;i++ ) {	
			Rdviewer.FileOpen(RD_path + "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/" + arrStr[i], RDServer + arrStr2[i] + "/rpagenuminit [1] /riprnmargin /rwait ");			
			//Rdviewer.FileOpen("http://localhost:7902/hanjin/" + "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/" + arrStr[i], RDServer + arrStr2[i] + "/rpagenuminit [1] /riprnmargin /rwait ");
			Rdviewer.SetAppendReport(1);
		}
		Rdviewer.SetAppendReport(0);
	}	
	
	function FNS_INV_0036_02_prev() {
		this.processButtonClick		= processButtonClick;		
	}
	
	function processButtonClick(){
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_paperissue":
                	opener.getPreviewIssue();
                	self.close();
                break;
                case "btn_close":
                	self.close();
                break;
		        	
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
	
</script>
    
<body onLoad="setupPage();"> 

<form name="form">

<input type="hidden" name="view_flag"  value="<%=viewFlag%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!-- : ( Title ) (S) -->
	<table width="100%" border="0" align="center">
	<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title%></td></tr>
	</table>
	<!-- : ( Title ) (E) -->

<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<%
if(viewFlag.equals("S")){
%>
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
					<tr><td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_paperissue">Issue</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<%
}
%>			
</form>			
</body>
</html>

