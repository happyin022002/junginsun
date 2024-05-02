/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0206.js
*@FileTitle  : VOP_PSO_0206.js
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/31
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class Service Provider Help : business script for Service Provider Help
 */
function VOP_PSO_0206() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// public variable
var sheetObjects=new Array();
// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var gXml="";	//Retrieving
var afterSearch=false;	//Retrieving
var sheetObjects=new Array();
var sheetCnt=0;
var usrOfcCd="";/*office cd of SSO user */
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_RowAdd":
				f_AddRow();
				break;
			case "btn_Delete":
				//var selectRow = eval(sheetObject1.SelectRow);
				//sheetObject1.RowDelete( selectRow, false );
				//Deleting Checked Row
				for( var i=sheetObject1.LastRow(); i>=sheetObject1.HeaderRows(); i-- ) {
					if(sheetObject1.GetCellValue(i, "hiddencheck") == 1){
						sheetObject1.RowDelete( i, false );
					}
				}
				setFirstRow();
				break;
			case "btn1_Close":
				ComClosePopup(); 
				break;
			case "btn1_OK":		//Save and Select code
				var aryPrefix=new Array( "sheet1_");
				formObject.f_cmd.value=MULTI;
				if(!validateForm(sheetObjects[0], formObject, IBSAVE)) return;
				var sParam=ComGetSaveString(sheetObjects, true, true);	//Transmitting all rows
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObject) + "&origin=1&" + ComGetPrefixParam(aryPrefix);	//origin: created by current screen : 1, by 0007 : 2
		
				var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0206GS.do", sParam);
				var retVal=ComGetEtcData(sXml, "new_condition");
				var resultMsg=ComPsoGetMessageFromXml(sXml);
				if(resultMsg != ""){
					ComShowMessage(resultMsg);
					return;
				}
				ComPopUpReturnValue(retVal);
//				window.returnValue=retVal;
				ComClosePopup(); 
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
	
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "sheet1":
	    with(sheetObj){
			SetColProperty(prefix+"obj_value", {ComboText:"Y|N", ComboCode:"Y|N"} );
		        
		      var HeadTitle1="||Condition|Object|UOM|Comparison Operator|Value|Condition ID|Condition DES|||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1, ComboMaxHeight:120 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition" },
		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_no", KeyField:1 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"operator",    KeyField:1 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_value",   KeyField:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"condid" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"conddes" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_name" },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"line_num" },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		            SetCountPosition(0);
		            SetShowButtonImage(1);
		            SetSheetHeight(102);
		      }

		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieving
			var prefix="sheet1_";
			var aryPrefix=new Array( "sheet1_");
			formObj.f_cmd.value=SEARCHLIST01;
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			param=param + "&types=" + "0206"; 			
			gXml=sheetObj.GetSearchData("VOP_PSO_0206GS.do", param );
			//Condition
			var comboItems=ComGetEtcData(gXml, "operator");
			var comboItems1="";
			var comboItems2="";
			if ( !comboItems.length ) {
				var comboItem=comboItems.split(",");
				comboItems1=comboItem[0];
				comboItems2=comboItem[1]; 		
			} else {
				comboItems=comboItems.split("|");
				for (var i=0 ; i < comboItems.length ; i++) {
					var comboItem=comboItems[i].split(",");
					if( i == 0 ){
						comboItems1=comboItem[0];
						comboItems2=comboItem[1]; 
					} else {
						comboItems1=comboItems1 + "|" +comboItem[0];
						comboItems2=comboItems2 + "|" +comboItem[1]; 
					}	
				}   		
			}
			sheetObj.SetColProperty(aryPrefix[0]+"condition", {ComboText:comboItems2, ComboCode:comboItems1} );
			//Object
			//(PSO_OBJ_CD, PSO_OBJ_CD_DSP, PSO_MEAS_UT_CD, PSO_MEAS_UT_CD_DSP, OBJ_LIST_NO)
			comboItems1="";	//Code -> OBJ_LIST_NO
			comboItems2="";	//Text -> 
			comboItems=ComGetEtcData(gXml, "objlist").split("|");
			for (var i=0 ; i < comboItems.length ; i++) {
				var comboItem=comboItems[i].split(",");
				comboItems1 += "|" +comboItem[4];
				comboItems2 += "|" +comboItem[1] + "\t" + comboItem[3];
			}   		
			sheetObj.SetColProperty(aryPrefix[0]+"obj_list_no", {ComboText:comboItems2, ComboCode:comboItems1} );
			//Comparison Operator
			comboItems=ComGetEtcData(gXml, "complist");
			comboItems1="";
			comboItems2="";
			if ( !comboItems.length ) {
				var comboItem=comboItems.split(",");
				comboItems1=comboItem[0];
				comboItems2=comboItem[0]+"\t"+comboItem[1]; 		
			} else {
				comboItems=comboItems.split("|");
				for (var i=0 ; i < comboItems.length ; i++) {
					var comboItem=comboItems[i].split(",");
					if( i == 0 ){
						comboItems1=comboItem[0];
						comboItems2=comboItem[0]+"\t"+comboItem[1]; 
					} else {
						comboItems1=comboItems1 + "|" +comboItem[0];
						comboItems2=comboItems2 + "|" +comboItem[0]+"\t"+comboItem[1]; 
					}	
				}   		
			}
			sheetObj.SetColProperty(aryPrefix[0]+"operator", {ComboText:comboItems2, ComboCode:comboItems1} );
			//Retrieving
			if(document.form.cond_no.value != ""){
				sheetObj.LoadSearchData(gXml,{Sync:1} );
				for(j=0; j<sheetObj.RowCount(); j++){
					sheet1_OnChange(sheetObj, j+1, sheetObj.SaveNameCol("sheet1_obj_list_no"));		//
					sheet1_OnChange(sheetObj, j+1, sheetObj.SaveNameCol("sheet1_operator"));	//for formatting
				}
				setFirstRow();
			} else{	//Add Row
				f_AddRow();
			}
			afterSearch=true;
		break; 
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
			case IBSAVE:
				//
				for(i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
					if(i != sheetObj.HeaderRows()){
						if(sheetObj.GetCellValue(i, "sheet1_condition") == ""){
							sheetObj.SelectCell(i, "sheet1_condition");
							ComShowCodeMessage('PSO00003', "[Condition]");
							return false;
						}
					}
				}
			break;
		}
	}
	return true;
}
/**
 * when screen loading
 */

function sheet1_OnLoadFinish(sheetObj){
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
}
/**
* IBSheet OnAfterEdit Event
*/
function sheet1_OnAfterEdit(sheetObj,Row,Col) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "obj_list_no" :	
			var arrComboText=sheetObj.GetComboInfo(Row, Col, "Text").split("|");
			var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			if(idx == -1){
				return;
			}
			sheetObj.SetCellValue(Row, prefix + "uom",arrComboText[idx].split("\t")[1],0);
			break;
		case prefix + "operator" :
			var uom=sheetObj.GetCellValue(Row, prefix + "uom");
			var opt=sheetObj.GetCellValue(Row, Col);
			var code=ComTrim(f_GetValueFromXMLData(gXml, Row, prefix+"obj_value"), "'");
			sheetObj.SetCellValue(Row, prefix+"obj_value","",0);
			if("FLAG" == uom){
				if( opt != "=" && opt != "!=") return;
				
				sheetObj.InitCellProperty(Row, prefix+"obj_value",{ Type:"Combo",Align:"Center"} );
				sheetObj.CellComboItem(Row,prefix+"obj_value", {ComboText:"Y|N", ComboCode:"Y|N"} );
				if(!afterSearch){
					sheetObj.SetCellValue(Row, prefix+"obj_value",code,0);
				} else{
				}
			}else{							
				sheetObj.InitCellProperty(Row, prefix+"obj_value", { Type:"Text",Align:"Center",Format:"Float"} );
				if(!afterSearch){
					sheetObj.SetCellValue(Row, prefix+"obj_value",code,0);
				} else{
					sheetObj.SetCellValue(Row, prefix+"obj_value","",0);
				}
				
			}
			/*if( opt == "=" || opt == "!="){		//Combo ('Y' or 'N')				
				sheetObj.InitCellProperty(Row, prefix+"obj_value",{ Type:"Combo",Align:"Center"} );
				sheetObj.CellComboItem(Row,prefix+"obj_value", {ComboText:"Y|N", ComboCode:"Y|N"} );
				if(!afterSearch){
					sheetObj.SetCellValue(Row, prefix+"obj_value",code,0);
				} else{
				}
			} else{				
				sheetObj.InitCellProperty(Row, prefix+"obj_value", { Type:"Text",Align:"Center",Format:"Float"} );
				if(!afterSearch){
					sheetObj.SetCellValue(Row, prefix+"obj_value",code,0);
				} else{
					sheetObj.SetCellValue(Row, prefix+"obj_value","",0);
				}
			}*/
			break;
	}
}
/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var turl="/opuscntr/VOP_PSO_0209.do?formcond=2";
	ComOpenPopup( turl, 900, 500, 'setCondition', '0,0', true, false, Row, Col, 0);
}
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet1_";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case "hiddencheck" :
ComSyncAllCheck(sheetObj, Col, sheetObj.GetCellValue(Row, "hiddencheck"));
		break;
	}
}
function setCondition(aryPopupData, row, col, sheetIdx){
	var sheetObject=sheetObjects[sheetIdx];
	var prefix="sheet"+(sheetIdx+1)+"_";
	sheetObject.SetCellValue(row,prefix+"condid",aryPopupData[0][1],0);
	sheetObject.SetCellValue(row,prefix+"conddes",aryPopupData[0][2],0);
}
function setFirstRow(){
	if(sheetObjects[0].LastRow()>= sheetObjects[0].HeaderRows()){	//Rows exist
		//sheetObjects[0].InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen])  		
		sheetObjects[0].InitCellProperty(sheetObjects[0].HeaderRows(), "sheet1_condition",{ Type:"Data"} );
		sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "sheet1_condition","");
		sheetObjects[0].SetCellEditable(sheetObjects[0].HeaderRows(), "sheet1_condition",0);
	}	
}
function f_AddRow(){
	var formObject=document.form;
	if( sheetObjects[0].RowCount()> 0 ) {
if( sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), "sheet1_obj_list_no") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), "sheet1_obj_list_no" , true);
			return;
} else if( sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), "sheet1_uom") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), "sheet1_uom" , true);
			return;
} else if (sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), "sheet1_operator") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), "sheet1_operator" , true);
			return;						
} else if (sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), "sheet1_obj_value") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), "sheet1_obj_value" , true);
			return;						
		}	
	}
	sheetObjects[0].DataInsert(-1);
	var selectRow=eval(sheetObjects[0].GetSelectRow());
	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), "sheet1_line_num",eval(sheetObjects[0].LastRow())*10,0);
	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), "sheet1_seq",formObject.seq.value,0);
	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), "sheet1_condition","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), "sheet1_operator","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), "sheet1_obj_value","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), "sheet1_obj_list_no","",0);
	setFirstRow();	
}
/**
* Getting data from Xml.
*/
function f_GetValueFromXMLData(xmlStr, cRow, savename)  {
	if (xmlStr == null || xmlStr == ""  ) {
		return;
	}
	if (savename  == null || savename == ""  ) {
		return;
	}
	try {
//		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//		xmlDoc.loadXML(xmlStr);
		var xmlDoc=ComGetXmlDoc(xmlStr)
		if (xmlDoc == null) return;
		var xmlRoot=xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return "";
		}
		var TOTAL_ROWS=eval( dataNode.getAttribute("TOTAL") );
		if( TOTAL_ROWS == "0" ){
			return "";
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		var arrText=savename.split("|");
		for (var i=0; i < colArr.length; i++) {
			for (var j=0; j < arrText.length; j++) {
				if ( colArr[i] == arrText[j] && colArr[i] != "" ) {
					colListIdx[j]=i;
				}
			}
		}
		if(  cRow   >  TOTAL_ROWS ){
			return "";
		}
//		var arrData=dataChildNodes[cRow-1].firstChild.nodeValue.split(sep);
		var arrData=dataChildNodes[cRow-1].nodeValue.split(sep);
		var trData="";
		for (var j=0; j < colListIdx.length; j++) {
			if( j < colListIdx.length-1){
				trData += arrData[colListIdx[j]]+"|";
			}else{
				trData += arrData[colListIdx[j]];   
			}
		}
		return trData;
	} catch (err) {
		ComFuncErrMsg(err.message);
	}               
} 
/**
 * Getting MESSAGE from sXml
 * @param sXml
 * @return Sring MESSAGE
 * @author jkc
 */
function ComPsoGetMessageFromXml(sXml){
    if ( sXml == null  || sXml == "" ) return;
    try {
    	var xmlDoc=ComGetXmlDoc(sXml)
		if (xmlDoc == null) return;
//        var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
//        xmlDoc.loadXML(sXml);
        var xmlRoot=xmlDoc.documentElement;
        if(xmlRoot == null) return;
        var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) return "";
//        return msgNode.firstChild.nodeValue;
        return msgNode.nodeValue;
    } catch(err) { ComFuncErrMsg(err.message); }
} 
