<%
String popupurl = request.getParameter("gwUrl");// + param;
//popupurl = "/hanjin/gwProxy3.jsp?gwUrl=" + popupurl
%>
<html>
<head>
<script>

document.domain="smlines.com";
	var ww = window.open('<%=popupurl%>','popGw2','width=1000px, height=1000px, location=0, status=0, resizable=1');
//var returnGwLink = function(assetcd, documentTitle){

//window.onbeforeunload = confirmExit;
function confirmExit() {
//	domainreset.src="/hanjin/gwProxy3.jsp"
//	alert("nn"); 

}

function returnGwLink(assetcd, documentTitle, value1, value2){
//	alert("assetcd=" + assetcd);
 
var message = assetcd + "," + documentTitle;
if (value1 != undefined) message =  message + "," + value1;
if (value2 != undefined)  message =  message + "," + value2;
//alert("documentTitle=" + documentTitle);
//alert("opener=" + parent.document.location);

//parent.postMessage(assetcd, "*");
//opener.postMessage(message, "*");

//IE10,11 support
//receiveMessage(message);
document.all.gwData.value=message;

}

function receiveMessage(message)
{
	try {
		//alert("message=" + message);
		//parent.postMessage(message, document.domain);
		//parent.postMessage(message, "hanjin.com");
		/*var urldata ="gwProxy2.jsp?message="+message;
			ifrm = document.createElement("IFRAME");
			ifrm.setAttribute("src", urldata);
			ifrm.setAttribute("id", "gwrequest2");
			ifrm.style.width = 0+"px";
			ifrm.style.height = 0+"px";
			document.body.appendChild(ifrm);
*/

			parent.postMessage(message, "*");
	} catch(e) {
		alert(e.message);
	}
}


function postToParentScreen(message) {
	try {
                //parent.postMessage(message, document.domain);
                //parent.postMessage(message, "a.roh.com");
                parent.postMessage(message, "*");
        } catch(e) {
                alert(e.message);
        }
}

</script>
</head>
<body  marginHeight=0 marginWidth=0>
<input type="hidden" name="gwData" onpropertychange="javascript:postToParentScreen(this.value);">
<IFRAME id='gwrequest3' src='' frameborder=0 marginwidth=0 marginheight=0 scrolling=no  margintop=0  marginleft=0  width="100%" height="100%"  style='position:absolute;' />
<IFRAME id='domainreset' src='' frameborder=0 marginHeight=0 marginWidth=0 width="0" height="0" style='position:absolute;location=0;status=0;resizable=1;display=none;' />
</body>
</html>
