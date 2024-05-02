/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoCgm.js
*@FileTitle  : UI common function Script
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	if(msgs == undefined){
		msgs = new Array();
	}
//*************** CGM START ***************//
msgs['CGM00002']='{?msg1} update/creation was saved successfully.';
msgs['CGM00003']='Data was saved successfully.';
msgs['CGM00005']='Do you want to delete {?msg1}';
msgs['CGM00006']='{?msg1} was deleted successfully.';
msgs['CGM10003']='{?msg1} is valid.';
msgs['CGM10004']='Mandatory field is missing. Please enter({?msg1}).';
msgs['CGM10005']='Please check the Verify Result.';
msgs['CGM10007']='Please check the Status.';
msgs['CGM10008']='Please select a row.';
msgs['CGM10009']='Please check the {?msg1}';
msgs['CGM10011']='Period exceeds maximum duration [2 years].';
msgs['CGM10012']='There is no data to search.';
msgs['CGM10013']='To-Be Pool is the same as Current Pool.';
msgs['CGM10014']='Office Code and Yard Code do not match. Please check again.';
msgs['CGM10016']='Please select a valid column.';
msgs['CGM10017']='{?msg1} is duplicated.';
msgs['CGM10018']='{?msg1} is duplicated. {?msg1}';
msgs['CGM10019']='Please input less number than {?msg1}';
msgs['CGM10020']='Year-Month option is invalid.';
msgs['CGM10021']='Selected Lessors do not match. Please check again.';
msgs['CGM10025']='Invoice No. [{?msg1}] is not found in the imported invoice file.';
msgs['CGM10026']='Please save the Lessor Only data first.';
msgs['CGM10027']='Please input negative amount.';
msgs['CGM10028']='Office does not match. Please check again.';
msgs['CGM10029']='Term does not match. Please check again.';
msgs['CGM10030']='Agreement No. and Reference No. do not match. Please check again.';
msgs['CGM10031']='Chassis Alias No. is duplicated. [{?msg1}]';
msgs['CGM10033']="The Model No. cannnot be deleted since it's still effective";
msgs['CGM10035']='After-Agreement No. is the same as Current-Agreement No.';
msgs['CGM10039']='Movement Reason does not match with Chassis In/Out Status. Please check again.';
msgs['CGM10040']='The equipment is already in Attached status.';
msgs['CGM10041']='Currency code is invalid. [{?msg1}]';
msgs['CGM10042']='To-date must be greater than From-date.';
msgs['CGM10044']='{?msg1}  lacks or exceeds field length.';
msgs['CGM10045']='The equipment is already in Detached status.';
msgs['CGM10047']='Data was changed. Do you want to save it?';
msgs['CGM10049']='Invoice Reference No. [{?msg1}] is not found in the imported invoice file.';
msgs['CGM10050']='RCV Date cannot be earlier than Issue Date.';
msgs['CGM10051']='Do you want to delete the {?msg1}?';
msgs['CGM10052']="You can't delete the Specification No. with registered Equipment.";
msgs['CGM10055']="Found Date cannot be earlier than Lost/TLL Date.";
msgs['CGM10056']="Lost Date cannot be earlier than the last Status.";
msgs['CGM10057']="Lost Date cannot be earlier than the last Status or Movement.";
msgs['CGM10058']="Lost/Found Date cannot be later than the Current Date.";
msgs['CGM10059']="Inputted Event Date cannot be later than the Current Date.";
msgs['CGM10060']="Inputted Event Date cannot be earlier than the last Event Date. ([{?msg1}])";
msgs['CGM10062']="On-Hire Date cannot be later than the Current Date.";
msgs['CGM10063']="Yard Code and current Location do not match. Please check again.";
msgs['CGM10064']="Only the last row can be deleted.";
msgs['CGM10065']="You can't input Own Chassis {?msg1} for Leased Chassis On-Hire.";
msgs['CGM10066']="You can't input Leased Chassis {?msg1} for Own Chassis On-Hire.";
msgs['CGM10067']="You can't input Leased M.G.Set {?msg1} for Own M.G.Set On-Hire.";
msgs['CGM10068']="You can't input Own M.G.Set {?msg1} for Leased M.G.Set On-Hire.";
msgs['CGM10069']="Off-Hire Date cannot be later than the Current Date.";
msgs['CGM10070']="You can't delete the Type/Size with registered Equipment. Please contact system manager for any change.";
msgs['CGM10072']="Please check the Agreement Effective Date [{msg1} ~ {msg1}]. !";
msgs['CGM10073']="Inputted Agreement [{msg1}] has no Rental Rate for the Chassis/M.G.Set Type/Size [{msg1}].";
msgs['CGM10074']="From-Date does not match. Please check again.";
msgs['CGM10075']="Inputted On-Hire Month has Charge-Creation History. Please check the On-Hire Date again /or/ cancel the Charge-Creation History if necessary.";
msgs['CGM10076']="The Inputted Chassis No. is not registered or not active! Do you want to save?";
msgs['CGM10077']="The Inputted M.G. Set No. is not registered or not active.";
msgs['CGM10078']="Inputted Chassis/M.G.Set is attached to another Container.";
msgs['CGM10079']="Please save the date first.";
msgs['CGM10080']="Please input remarks for the change.";
msgs['CGM10081']="Please check the attached file. Attached file should be CSV,XLS,ZIP.";
msgs['CGM10082']="Attached file exceeds maximum size [50MB].";
msgs['CGM10083']="You can't delete a file in process.";
msgs['CGM10084']="Please check input date/time.";
msgs['CGM10085']="Do you want to fix the actual amount?";
msgs['CGM10086']='Please enter a valid date format: YYYY';
msgs['CGM20003']='Equipment is not found.';
msgs['CGM20004']='Chassis/M.G.Set No. [{?msg1}] is duplicated.';
msgs['CGM20007']="Agreement No. ({?msg1}) doesn't exist. ";
msgs['CGM20010']='Type/Size [{?msg1}] is duplicated. ';
msgs['CGM20011']='Specification [{?msg1}] is duplicated.';
msgs['CGM20014']='Selected Pool Code is assigned to other Agreement No. [{?msg1}].';
msgs['CGM20015']='Please check the current status [{?msg1}].';
msgs['CGM20016']="You can't delete the Agreement with registered Equipment.";
msgs['CGM20023']='[{?msg1}] doesn\'t exist.';
msgs['CGM20024']='Reference No. and OWN Agreement No. do not match. Please check again.';
msgs['CGM20025']='The Invoice No. already exists.';
msgs['CGM20026']='You cannot change or delete Agreement Version()()with Charge-Creation History. Please check Rate Effective Date of the Versionagain. ';
msgs['CGM20028']='Detach Container Not Found!';
msgs['CGM20029']='Inputted Container is attached to another Chassis.';
msgs['CGM20030']='Chassis and Container Type/Size do not match. Please check again.';
msgs['CGM20031']='Unexpected system error took place during data processing. Please try again later.';
msgs['CGM20032']='OPUS system error took place. Please contact system manager.';
msgs['CGM20034']="You can't correct or delete the data created 180 days ago.";
msgs['CGM20035']=' Inputted Container/Chassis is attached to another M.G.Set [{?msg1}].';
msgs['CGM20036']='Unexpected system error took place during data processing. (check the file size.(5MB))';
msgs['CGM20037']='BackEndJob Request Fail!';
msgs['CGM20038']='It was already created. Please check it again.';
msgs['CGM20039'] = "This Invoice No was already created. Please check it again.";
msgs['CGM20040'] = "Please Select agreement first.";
msgs['CGM20041'] = "Please Insert Tax Rate(%) for VAT Tax.";
msgs['CGM20042'] = "Please Insert Tax Amount for Withholding Tax.";
msgs['CGM20043'] = "There is no invoice data in the coincidence tab. Please check the audit result.";
msgs['CGM20044'] = "You can not attach UMG M.G Set without chassis.";
msgs['CGM20045'] = '{?msg1} label is still in use. Are you sure to delete the label?';  
msgs['CGM20046'] = 'There are duplicate value of RU Label Type and Value.\n';
msgs['CGM20047'] = 'There is no selected marking. Please check again.\n';
msgs['CGM20048'] = 'Please enter the Equipment No.\n'
msgs['CGM20049'] = 'RU Label Value of "{?msg1}" is duplicated. Please check again.';
msgs['CGM20050'] = 'You can only input either Container or Chassis.';

// grobal var about Common Code Type 
var COM_CD_TYPE_CD01948="CD01948";	// Lease Term
var COM_CD_TYPE_CD02117="CD02117";	// Location
var COM_CD_TYPE_CD01940="CD01940";	// TYPE/SIZE
var COM_CD_TYPE_CD01946="CD01946";	// REASON
var COM_CD_TYPE_CD01863="CD01863";	// REASON
var COM_CD_TYPE_CD02355="CD02355";	// OPTION
// Comon Validation Result Value
var COM_VALIDATION_TRUE="TRUE";
var COM_VALIDATION_FALSE="FALSE";
var EQ_KND_CD_CHASSIS="Z";
var EQ_KND_CD_MGSET="G";
var BTN_ENABLE="btn1";
var BTN_DISABLE="btn1_1";
/**
 * IBSheet GetSearchXmlfunction  XML data <br>
 * make string type to push IBSheet Combo <-.(&quot;|&quot; string)<br>
 * Return array : 0 - Code string, 1st - Text string.
 * <b>Example :</b>
 *
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // retrieve result 35
 * var arrData = ComXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
 *
 * </pre>
 *
 * @param {string} xmlStr mandatory, IBSheet -> xml string.
 * @param {string} codeCol mandatory, Combo Code column name.
 * @param {string} textCol mandatory, Combo Text column name. ( '|')
 * @param {string} separator 
 * @return array   Code string, Text string array.
 * @author 
 * @version2
 */
function ComCgmXml2ComboString(xmlStr, codeCol, textCol, separator) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;

		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var textColList=textCol.split("|");
		var textIdx=0;
		var colListIdx=Array();
		var textListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			for(var k=0; k < textColList.length; k++){
				if (colArr[i] == textColList[k]) {
					textListIdx[textIdx]=i;
					textIdx=textIdx + 1;
				}
			}
		}
		var sCode="";
		var sText="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			sCode += arrData[colListIdx[0]];
			for(var m=0; m < textListIdx.length; m++){
				sText += arrData[textListIdx[m]];
				if (m != textListIdx.length - 1) {
					sText += separator;
				}
			}
			if (i != dataChildNodes.length - 2) {
				sCode += "|";
				sText += "|";
			}
		}
		rtnArr.push(sCode);
		rtnArr.push(sText);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}
function ComCgmNullToBlank(sStr){
	if( sStr==null || sStr=='null' || sStr=='undefined' || sStr==undefined || typeof sStr=='undefined'){
		return '';
	} else {
		return sStr;
	}
}
function ComCgmNullToZero(sStr){
	if( sStr==null || sStr=='null' || sStr=='' || sStr=='undefined' || sStr==undefined || typeof sStr == 'undefined'){
		return '0';
	} else {
		return sStr;
	}
}
function ComCgmMakeMultiCombo(cmbObj, sCode, sText, sOpt){
	var arrCode=sCode.split("|");
	var arrText=sText.split("|");
	cmbObj.RemoveAll();
	if(sOpt==0){
		for(var i=0; i<arrCode.length; i++){
			cmbObj.InsertItem(i, arrText[i], arrCode[i]);
		}
	} else {
		cmbObj.InsertItem(0,"","");
		for(var i=0; i<arrCode.length; i++){
			cmbObj.InsertItem(i+1, arrText[i], arrCode[i]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
}

function ComCgmSetObjectValue(obj,val) {
	try {
        switch( obj.type ) {
            case "select-one" :
                 obj.selectedIndex='0';
            case "radio" :
            case "checkbox" :
            	 if(val==undefined){
            		 obj.checked=true;
            	 } else {
            		 obj.checked=val;
            	 }
                 break;
            case "text" :
            case "password" :
            case "hidden" :
            	 if(val==undefined){
            		 obj.value="";
            	 } else {
            		 obj.value=val;
            	 }
                 break;
            default:
        } // end switch
    } catch(err) { ComFuncErrMsg(err.message); }
}
function ComCgmEnableObject(obj, bEnable, sStyle)
{
   try {
   	   //disabled나 readOnly 설정하기
       switch( obj.type ) {
           case "password" :
           case "text" :
           case "textarea":
        	   obj.readOnly = !bEnable;
               break;
           default:
               obj.disabled = !bEnable;
       }

		//설정에 따라 css 처리하기
       switch( obj.type ) {
           case "select-one" :
           case "text" :
               if (bEnable){
            	   if(sStyle == undefined){
            		   obj.className = "input";    //흰색바탕
            	   } else {
            		   obj.className = sStyle;
            	   }
               } else {
            	   if(sStyle == undefined){
            		   obj.className = "input2";   //회색바탕
            	   } else {
            		   obj.className = sStyle;
            	   }
               }
               break;

           case "textarea":
               if (bEnable){
            	   if(sStyle == undefined){
            		   obj.className = "textarea";
            	   } else {
            		   obj.className = sStyle;
            	   }
               } else {
            	   if(sStyle == undefined){
            		   obj.className = "textarea2";
            	   } else {
            		   obj.className = sStyle;
            	   }
               }
               break;

			default :
               if (obj.tagName=="IMG") {
                   if (bEnable){
                       obj.style.cursor = "hand";
                       obj.style.filter="";
                   } else {
                       obj.style.cursor = "default";
                       obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                   }
               }
       }

   } catch(err) { ComFuncErrMsg(err.message); }
}
/**
* Action button enable/disable check. <br>
* @param  {String} srcName	mandatory
* @return  true/false
* @author 
* @version 
*/
function ComCgmIsActionButtonEnable (srcName){
	return !ComGetBtnDisable(srcName);
	 /*var btnObj=document.getElementById(srcName);
	 if(btnObj.className == BTN_ENABLE){
		 return true;
	 } else {
		 return false;
	 }*/
}
/**
* Action button enable/disable check. <br>
* @param  sheetObj	mandatory
* @param  TrimComma	mandatory
* @param  Status	mandatory
* @author 
* @version 
*/
function ComCgmGetAllSaveText(sheetObj,TrimComma,Status){
	if (TrimComma==undefined || TrimComma==null) TrimComma=false;
	if (Status==undefined || Status==null) Status="ibflag";
	var arrSave=new Array();
	for(var i=0 ; i <= sheetObj.LastCol();i++){
		arrSave[i]=sheetObj.ColSaveName(i);
	}
	var str=sheetObj.GetRangeText(sheetObj.HeaderRows(),0,sheetObj.LastRow(),sheetObj.LastCol(),"|","^");
	if(TrimComma) str=str.replace(/\,/gi, "");
	var arrStr=str.split("^");
	for(var i=0; i<arrStr.length; i++ ){
		var arrCol=arrStr[i].split("|");
		for(var j=0 in arrCol){
			if(arrSave[j] == Status){
				switch(arrCol[j]) {
					case "INS": arrCol[j]="I"; break;
					case "UPD": arrCol[j]="U"; break;
					case "DEL": arrCol[j]="D"; break;
					default:    arrCol[j]="R"; break;
				}
			}
			arrCol[j]=arrSave[j]+"="+arrCol[j];
		}
		arrStr[i]=arrCol.join("&");
	}
	return  arrStr.join("&");
}
/**
* money format return. (ex:11,222,333.00) <br>
* @param  amount	mandatory		
* @param  pointLen	mandatory	
* @param  Status	mandatory
* @author 
* @version 
*/
function ComCgmAmountFormat(amount, pointLen){
	var amount=ComReplaceStr(String(ComRound(amount,2)),',','');
	if(amount.indexOf('.') == -1){
		amount += ".";
	}
	amount += "00";
	var pointIdx=amount.indexOf('.');
	amount=amount.substring(0, pointIdx) + "." + amount.substring(pointIdx + 1, pointIdx + pointLen + 1);
	amount=ComAddComma(amount);
	return amount;
}
/**
* make data to retrieveXML type. <br>
* <br><b>Example :</b>
* <pre>
*     sXml = ComMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
* </pre>
* @param {ibsheet} 	sheet_obj   mandatory,IBSheet Object ID
* @param {bool}    	allSave     mandatory,full of sheet make xml string [true/false]
* @param {int,string}	col     	mandatory,index or SaveName[check box type]
* @param {string}  	saveColName mandatory,SaveName("|")
* @param {bool}    	bRowDel     select,row deleting or not, default=false
* @return string,Sheet data retrieveXML string
*/
function ComCgmMakeSearchXml(sheet_obj, col, saveColName, bRowDel)  {
    try {
    	if ((!sheet_obj) || (!sheet_obj.IBSheetVersion)){
            ComShowMessage("ComMakeSearchXml function sheet_obj entry in not IBSheet.");
            return "";
        }
        var allXml="";
        var sColSep="^|^";
        var sColOrder="";
        if (saveColName!=undefined && saveColName != null && saveColName!="") {
            sColOrder=" COLORDER='" + saveColName + "' ";
        }
        allXml="<?xml version='1.0'  ?>\n"
               + "<SHEET>\n"
                  allXml += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
            if(col != ""){
                var findRows=sheet_obj.FindCheckedRow(col);
                if(findRows != ""){
                    var arrRow=findRows.split("|");
                    var arrCol=saveColName.split("|");
                    var aryTR=new Array(arrRow.length);
                    var aryTD=new Array(arrCol.length);
                    for(var ir=0; ir<arrRow.length; ir++){
                        for(var ic=0; ic<arrCol.length; ic++){
                            if(arrCol[ic]=='ibflag'){
                            	aryTD[ic]="I";
                            } else {
                            	aryTD[ic]=String(sheet_obj.GetCellValue(arrRow[ir], arrCol[ic]));
                            }
                        }
                        aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                    }
                    if (bRowDel) {
                    	sheet_obj.RowDelete(findRows,false);
                    }
                    allXml += aryTR.join("\n");
                }
            }
        allXml += "  </DATA>\n"
               +  "</SHEET>";
        return allXml;
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
* make data to retrieveXML type. <br>
* <br><b>Example :</b>
* <pre>
*     sXml = ComMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
* </pre>
* @param {ibsheet} 	sheet_obj   mandatory,IBSheet Object ID
* @param {bool}    	allSave     mandatory,full of sheet make xml string [true/false]
* @param {int,string}	col     	mandatory,index or SaveName[check box type]
* @param {string}  	saveColName mandatory,SaveName("|")
* @param {bool}    	bRowDel     select,row deleting or not, default=false
* @return string,Sheet data retrieveXML string
*/
function ComCgmMakeSearchXml2(sheet_obj, col, saveColName, bRowDel, status)
{
    try {
    	if ((!sheet_obj) || (!sheet_obj.IBSheetVersion)) {
            ComShowMessage("ComMakeSearchXml function sheet_obj entry in not IBSheet.");
            return "";
        }
        var allXml="";
        var sColSep="^|^";
        var sColOrder="";
        if (saveColName!=undefined && saveColName != null && saveColName!="")
        {
            sColOrder=" COLORDER='" + saveColName + "' ";
        }
        allXml="<?xml version='1.0'  ?>\n"
               + "<SHEET>\n"
                  allXml += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
            if(col != "")
            {
                var findRows=sheet_obj.FindCheckedRow(col);
                if(findRows != "")
                {
                    var arrRow=findRows.split("|");
                    var arrCol=saveColName.split("|");
                    var aryTR=new Array(arrRow.length);
                    var aryTD=new Array(arrCol.length);
                    var sDelRow = "";
                    for(var ir=0; ir<arrRow.length; ir++)
                    {
                    	if(sheet_obj.GetCellValue(arrRow[ir],"lse_chg_aud_sts_cd")==status
                        ||(sheet_obj.GetCellValue(arrRow[ir],"lse_chg_aud_sts_cd")=="" && status == "I"))

                    	{
                    		sDelRow += (arrRow[ir] + "|");
	                        for(var ic=0; ic<arrCol.length; ic++)
	                        {
	                            if(arrCol[ic]=='ibflag')
	                            {
	                            	aryTD[ic]="U";
	                            } else
	                            {
									if(sheet_obj.GetCellValue(arrRow[ir], arrCol[ic]) != null)
									aryTD[ic]=String(sheet_obj.GetCellValue(arrRow[ir], arrCol[ic]));
	                            	else
	                            		aryTD[ic]="";
	                            }
	                        }
	                        aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                    	}
                    }
                    if (bRowDel)
                    {
                    	if (sDelRow!="") sDelRow = ComLtrim(sDelRow, "|");
                    	sheet_obj.RowDelete(sDelRow,false);
                    }
                    allXml += aryTR.join("\n");
                }
            }
        allXml += "  </DATA>\n"
               +  "</SHEET>";
        return allXml;
    } catch(err) { ComFuncErrMsg(err.message); }
}
//--------------------------------------------------------
// about sheet... for Default Operation.
//-------------------------------------------------------
/**
* Vo List -> array[array[name]] format return
* @param {xml} xmlStr retrieve result (SC setRsVoList , setRsVo call)
*/
function ComCgmXml2ListMap(xmlStr) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}
	try {
		
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		if (total == 0) {
			return rtnArr;
		}
		var dataChileNodes=dataNode.childNodes;
		if (dataChileNodes == null) {
			return rtnArr;
		}
		var cnt = 0;
		for ( var i=0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChileNodes[i].firstChild.nodeValue.split(sep);
			var subDataArr=new Array();
			for ( var j=0; j < arrData.length; j++) {
				subDataArr[colArr[j]]=arrData[j];
			}
			rtnArr[cnt]=(subDataArr);
			cnt++;
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}
/**
* get value from Xml
*/
function DomXml2String(xmlStr, colName) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (colName == null || colName == "") {
		return;
	}
	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;

		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == colName) {
				colListIdx[0]=i;
			}
		}
		var sName= "";
		var cnt=0;
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			sName = arrData[colListIdx[0]];
			break;
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return sName;
}


function CgmMakeRound(num, cnt){
	var powCnt = Math.pow(10, cnt);
	return (Math.round(num*powCnt)/powCnt).toFixed(cnt);
}

function CGMcheckInvoiceNo(sheetObj,inv_no,vndr_seq,ref_pk,mdl_cd){
	var sParam = "f_cmd="+SEARCH09;

	sParam = sParam + "&mdl_cd="+mdl_cd;

	sParam = sParam + "&inv_no="+inv_no;

	sParam = sParam + "&vndr_seq="+vndr_seq;
	sParam = sParam + "&ref_pk="+lpad(ref_pk,15,"0"); 
	
	sheetObj.SetWaitImageVisible(0);
	var sXml = sheetObj.GetSearchData("FINCommonGS.do" , sParam);
	sheetObj.SetWaitImageVisible(1);
	
	var message = ComGetSelectSingleNode(sXml , "MESSAGE");
	var arrResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	if (arrResult == "F") {
		showErrorMsg(sXml);
		if(message.indexOf("CSR10005") > -1){
			return "DUP"; //INV_NO
		}else{
			return null;
		}
	} else {
		return null;
	}
}

function lpad(str, num, chr) {    
    if (! str || ! chr || str.length >= num) {
        return str;
    }
 
    var max = num - str.length;
    for (var i = 0; i < max; i++) {
        str = chr + str;
    }
 
    return str;
}

function CGMXmlToArray(xmlStr) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	try {
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;
        if (xmlRoot == null)  return;

		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var retStr="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			rtnArr.push(arrData);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}

function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "ALL", "ALL");
	for (var i = 0; i < arrStr.length; i++) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i + 1, arrCode[txtCol], arrCode[codeCol]);
	}
	cmbObj.SetSelectIndex("", false);
}

/**
 * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
 * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
 * @returns string <br>
 */
function ComToHtml2(obj){
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var str = getArgValue(obj);

        str = str.replace(/&/gi, "@amp;");
        return str;
    } catch(err) { ComFuncErrMsg(err.message); }
}
