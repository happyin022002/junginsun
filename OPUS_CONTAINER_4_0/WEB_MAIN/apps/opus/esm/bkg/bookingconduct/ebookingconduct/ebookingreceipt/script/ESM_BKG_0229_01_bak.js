
   //function changeCmdtDesc(obj) {
//   	var formObj = document.form;
//   	formObj.cmdt_cd.value = obj.value;
//   	formObj.f_cmd.value = SEARCH01;
   //
//   	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_01GS.do", FormQueryString(formObj));
//   	var cmdtDesc = ComGetEtcData(sXml, "cmdt_desc");
//   	if (cmdtDesc == 'null' || cmdtDesc == '') {
//   		cmdtDesc = "";
//   	}
   //
//   	var objSeq = (obj.name).split("__");
//   	formObj.cmdt_desc.value = cmdtDesc;
   //}
    


   //ajax 예제
   //function createXmlHttpObj() {
//   	var xmlHttp = null;
   //	
//   	try {
//   		xmlHttp = new XMLHttpRequest();
//   	} catch (e) {
//   		var listOfMsXml = ["MSXML2.XMLHTTP.5.0",
//   		                   "MSXML2.XMLHTTP.4.0",
//   		                   "MSXML2.XMLHTTP.3.0",
//   		                   "MSXML2.XMLHTTP",
//   		                   "Microsoft.XMLHTTP"];
//   		for (var i = 0; i < listOfMsXml.length; i++) {
//   			xmlHttp = new ActiveXObject(listOfMsXml[i]);
//   			if (xmlHttp) break;
//   		}
//   	}
//   	return xmlHttp;
   //}
    /*		var ds = new DataStore(arrXml[0]);
//    		for (var i = 0; i < ds.RowCount; i++) {
//    			for (var j = 0; j < ds.ColCount; j++) {
//    				aler""t("rows[" + i + "][" + j + "]=[" + ds.getItem(i, j) + "]");
//    			}
//    		}*/

   //function DataStore(txt) {
////   	ale""rt(txt);
   //	
//   	var xml = loadXMLString(txt);
   //   var xmlRoot = xmlDoc.documentElement;
   //   var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
   //   var colOrders = dataNode.getAttribute("COLORDER").split("|");
   //   var colSeparator = dataNode.getAttribute("COLSEPARATOR");
   //   
   //   this.xml = xml;
   //   this.colOrders = colOrders;
   //   var colCount = colOrders.length;
   //   this.ColCount = colCount - 1;
   //   this.colSeparator = colSeparator;
   //
   ////   ale""rt("COLORDER:" + colOrders);
   ////   ale""rt("COLSEPARATOR:" + colSeparator);
   //   
   //   var trNodes = dataNode.childNodes;
   //   var rows = new Array();
   //   var rowCount = rows.length;
   //   this.RowCount = rowCount;
   //   for(var i = 0; i < trNodes.length; i++){
//      	rows[i] = trNodes[i].firstChild.nodeValue.split(colSeparator);
   //   }
   //   this.rows = rows;
   //   
   //   this.getItem = getItem;
   //   this.setItem = setItem;
   //	
   //}
   //
   //function getItem(row, col) {
//   	if (typeof col == "string") { //this.rows[row][col] == undefined) {
//   		for (var i = 0; i < this.ColCount; i++) {
//   			if (this.colOrders[i] == col) {
//   				return this.rows[row][i];
//   			}
//   		}
//   		return undefined;
//   	}
//   	else {
//   		return this.rows[row][col];
//   	}
   //}
   //
   //function setItem(row, col, value) {
//   	if (typeof col == "string") {
//   	//if (this.rows[row][col] == undefined) {
//   		for (var i = 0; i < this.ColCount; i++) {
//   			if (this.colOrders[i] == col) {
//   				this.rows[row][i] = value;
//   			}
//   		}
//   	}
//   	else {
//   		this.rows[row][col] = value;
//   	}
   //}

   //function loadXMLString(txt)
   //{
//   	if (window.DOMParser) {
//   		parser=new DOMParser();
//   		xmlDoc=parser.parseFromString(txt,"text/xml");
//   	}
//   	else { // Internet Explorer
//   		xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//   		xmlDoc.async="false";
//   		xmlDoc.loadXML(txt);
//   	}
//   	return xmlDoc;
   //}
    
   // function searchNupdateRoutNm(locCd,elem) {
//   	var xmlHttp = createXmlHttpObj();
//   	var url = "ESM_Booking_UtilGS.do";
//   	url = url + "?f_cmd=" + SEARCHLIST17 + "&input_text=" + escape(locCd);;
   //	
//   	xmlHttp.open("GET", url, true);
//   	xmlHttp.onreadystatechange = function() { updateRoutNm(xmlHttp, elem);}
//   	xmlHttp.send(null);
   //
//   	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
//   		var response = xmlHttp.responseText;
   //
//   		// 결과를 parameter로 받은 elem.value에 넣음
//   		// 즉, 각 Route Name Field에 값을 변경
//   		elem.value = ComGetEtcData(response, "output_text");
//   		
//   		updateRoutStyle(elem);
//   	}
   //}
   //
   //function updateRoutNm(xmlHttp, elem) {
//   	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
//   		var response = xmlHttp.responseText;
   //
//   		// 결과를 parameter로 받은 elem.value에 넣음
//   		// 즉, 각 Route Name Field에 값을 변경
//   		elem.value = ComGetEtcData(response, "output_text");
//   		
//   		updateRoutStyle(elem);
//   	}
   //}

   //function searchUsrDfltSet(usrId) {
//   	var queryString = "f_cmd=" + SEARCH + "&usr_id=" + escape(usrId);
//   	var xmlHttp = createXmlHttpObj();
   //	
//   	xmlHttp.open("GET", "ESM_BKG_0154GS.do?" + queryString, false);
//   	xmlHttp.send(null);
   //
//   	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
//   		var response = xmlHttp.responseText;
//   		return response;
//   	} else {
//   		return "";
//   	}
   //}