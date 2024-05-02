/*=========================================================
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1604.js
*@FileTitle : EU DG Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/22 
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job	*/
//common global variables

var sheetObjects = new Array();
var sheetCnt = 0;

//Event handler processing by button click event
document.onclick = processButtonClick;

//Event handler processing by button click event */
function processButtonClick() {
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");        
        switch (srcName) {
            case "btn_print":                
                if (!validateForm(formObject, srcName)) return;
                doActionIBSheet(sheetObjects[0], formObject, IBSEARCH)
                break;
            case "btn_email":
            	if (!validateForm(formObject, srcName)) return;
            	if (!ComShowCodeConfirm("BKG01081")) {		//"Do you want to send email ?"			
					return false;
				}          
                doActionIBSheet(sheetObjects[0], formObject, "EMAIL")
                break;
        } // end switch
    } catch (e) {
        ComShowMessage(e);
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {

    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
}

/**
 * loading HTML Control event<br>
 */
function initControl() {
    var formObject = document.form;
    axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');
}

function ufRetrieveByEnterKey() {
    if (13 != event.keyCode) return;
    document.getElementById("btn_retrieve").fireEvent("onclick");
}


/**
 * setting sheet initial values and header
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    var sheetID = sheetObj.id;
    switch (sheetNo) {
        case 1:
            cnt=0;
		    with(sheetObj){				        
			     //no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			     var HeadTitle1="|||No|CNTR No.|CNTR Type|B/L No.|G.Weight|N.Weight|Proper Shipping Name|HAZ.Contents|CLS(Sub)|POL|POD|UN No.|PG|FP|EMS|M/P|MPA|Emergency Tel|P.I.C|Cargo Operator|Q'ty & Package Type|Inner Package Details|Stowage|Limited Quantity(Y/N)";
			     var headCount=ComCountHeadTitle(HeadTitle1);

			     SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1} );

			     var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			     var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			     InitHeaders(headers, info);

			     var cols = [ 
						{Type:"Text",      Hidden:1, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cd" },
						{Type:"Text",      Hidden:1, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pol_name" },
						{Type:"Text",      Hidden:1, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pod_name" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"no" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"cntr_no" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"bl_no" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"g_weight" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"n_weight" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"proper_shipping_name" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"hzd_desc" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"cls_sub" },
					    {Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pol_cd" },
					    {Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pod_cd" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"un_no" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pg" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"fp" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"ems1" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"mp" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"mpa" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"emergency_tel" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pic" },
						{Type:"Text",      Hidden:0, Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cgo_opr_cd" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"qty_package_type" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"inner_package_detail" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"stowage" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"imdg_lmt_qty_flg" }
			            ];				      
			      SetWaitImageVisible(0);
			     InitColumns(cols);	
			     SetEditable(1);				      
			     SetSheetHeight(100);
			    }
	            break;	
        case 2:
            cnt=0;
		    with(sheetObj){				        
			     var HeadTitle2="Ports of Discharge Classes Summary";
			     var headCount=ComCountHeadTitle(HeadTitle2);
   
			     SetConfig( { SearchMode:2,  MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

			     var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:5 };
			     var headers = [ { Text:HeadTitle2, Align:"Center"} ];
			     InitHeaders(headers, info);

			     var cols = [ 
			            {Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"pod_cd"   },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_14" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_21" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_22" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_30" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_41" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_42" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_43" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_51" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_52" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_61" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_80" },
						{Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"class_90" },
						{Type:"Text",      Hidden:0, Width:90,    Align:"Left",    ColMerge:0,   SaveName:"total_bookings" },
			            ];		
			     
			     InitColumns(cols);	
			     SetEditable(1);				      
			     SetSheetHeight(100);

			    }
	            break;	
    }
}


/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj, formObject, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
        	var strLstType = formObject.elements["list_type"].value;   
        	
        	if(strLstType == "BE" ){
        		formObject.f_cmd.value = SEARCH01;
            	sheetObj.DoSearch("ESM_BKG_1604GS.do", FormQueryString(formObject));        	
        	}else if(strLstType == "SE"){
        		formObject.f_cmd.value = SEARCH02;
        		sheetObjects[1].DoSearch("ESM_BKG_1604GS.do", FormQueryString(formObject));
        		
        	}else {
        		rdOpen(sheetObj, formObject);
        	}            
            break;
            
        case "EMAIL":
            formObject.f_cmd.value=MULTI01;	
            var rtnVal = paramSetting();		
			var params=FormQueryString(formObject);		
			
 			sXml=sheetObj.GetSaveData("ESM_BKG_1604GS.do", params);		
 			sheetObj.LoadSaveData(sXml);	
            break;
    }
}



function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
	if (sheetObj.GetEtcData("SuccessYn") == "Y") {		
		ComShowCodeMessage('BKG06082'); //"Send E-mail/Fax Successfully!"			
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {	
	sheetObj.Down2Excel({FileName : "EU_DG_Manifest_On Board Excel", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1});
}

function sheet2_OnSaveEnd(sheetObj, ErrMsg) {	
	if (sheetObj.GetEtcData("SuccessYn") == "Y") {		
		ComShowCodeMessage('BKG06082'); //"Send E-mail/Fax Successfully!"			
	}
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {	
	sheetObj.Down2Excel({FileName : "EU_DG_Manifest_Summary", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 3, Merge: 1, DownHeader:false, WordWrap:0 });
}

/**
 * handling process for input validation
 */
function validateForm(formObject, srcName) {
    switch (srcName) {
            case "btn_print":              
			    with(formObject) {
			        for (var i = 0; i < formObject.elements.length; i++) {
			            if ("text" == formObject.elements[i].type) {
			                if (null != formObject.elements[i].getAttribute("required") && ComIsNull(formObject.elements[i])) {
			                    returnValidate("NULL", formObject.elements[i]);
			                    return false;
			                }
			                if (!ComIsNull(formObject.elements[i].value)) {
			                    if (null != formObject.elements[i].getAttribute("minlength") && 1 == ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("minlength"))) {
			                        returnValidate("MIN", formObject.elements[i]);
			                        return false;
			                    }
			                    if (null != formObject.elements[i].getAttribute("maxlength") && 0 == ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("maxlength"))) {
			                        returnValidate("MAX", formObject.elements[i]);
			                        return false;
			                    }
			                }
			            }
			        }
			        if (!ComChkValid(formObject, false)) return false;
			    }
	     		break;
	     		
     		case "btn_email":
     			with(formObject) {
			    	for (var i = 0; i < formObject.elements.length; i++) {
			            if ("text" == formObject.elements[i].type) {
			                if (null != formObject.elements[i].getAttribute("required") && ComIsNull(formObject.elements[i])) {
			                    returnValidate("NULL", formObject.elements[i]);
			                    return false;
			                }
			                if (!ComIsNull(formObject.elements[i].value)) {
			                    if (null != formObject.elements[i].getAttribute("minlength") && 1 == ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("minlength"))) {
			                        returnValidate("MIN", formObject.elements[i]);
			                        return false;
			                    }
			                    if (null != formObject.elements[i].getAttribute("maxlength") && 0 == ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("maxlength"))) {
			                        returnValidate("MAX", formObject.elements[i]);
			                        return false;
			                    }
			                }
			            }
			        }
			        if (!ComChkValid(formObject, false)) return false;
			    	
			    	
			    	if(formObject.email.value.length == 0) {
			    		ComSetFocus(formObject.email);
			    		ComShowCodeMessage("BKG00404", "email", "email"); //"{?msg1} is mandatory. Please enter {?msg2}."			    		
			    		return false;
			    	}   
			    }
			    break;			   
    }
    return true;
}


function returnValidate(mode, obj) {
    switch (mode) {
        case "NULL":
            var msg1 = msg2 = "";
            switch (ComGetEvent("name")) {
                case "vvd_cd":
                    msg1 = "\"VVD & POL / POD\"", "\"VVD\"";
                    msg2 = "\"VVD\"";
                    break;
                case "vvd_pol":
                    msg1 = "\"VVD & POL / POD\"", "\"VVD\"";
                    msg2 = "\"POL\"";
                    break;
                case "vvd_pod":
                    msg1 = "\"VVD & POL / POD\"", "\"VVD\"";
                    msg2 = "\"POD\"";
                    break;
            }
            if ("" != msg1 && "" != msg2) {
                ComShowCodeMessage("COM12130", msg1, msg2); //Please enter {?msg2} of {?msg1}.
            } else {
                ComShowCodeMessage("BKG08020"); //Invalid data (NULL)
            }
            break;
        case "MAX":
            switch (ComGetEvent("name")) {
                case "vvd_cd":
                    ComShowCodeMessage("BKG00710"); //Length of VVD is INCORRECT!
                    break;
                case "vvd_pol":
                    ComShowCodeMessage("BKG00711"); //Length of POL is INCORRECT!
                    break;
                case "vvd_pod":
                    ComShowCodeMessage("BKG00712"); //Length of POD is INCORRECT!
                    break;
                default:
                    ComShowCodeMessage("BKG00381"); //Incorrect Data Length
            }
            break;
        case "MIN":
            switch (ComGetEvent("name")) {
                case "vvd_cd":
                    ComShowCodeMessage("BKG00710"); //Length of VVD is INCORRECT!
                    break;
                case "vvd_pol":
                    ComShowCodeMessage("BKG00711"); //Length of POL is INCORRECT!
                    break;
                case "vvd_pod":
                    ComShowCodeMessage("BKG00712"); //Length of POD is INCORRECT!
                    break;
                default:
                    ComShowCodeMessage("BKG00381"); //Incorrect Data Length
            }
            break;
    }
    ComSetFocus(obj);
}


function sheetNullReturn(obj) {
    if (obj == "-1") {
        return "";
    } else {
        return obj;
    }

}

//open rd 
function rdOpen(rdObject, formObject) {    
    var strPath = "apps/opus/esm/bkg/terminaldocumentation/specialmanifest/report/ESM_BKG_1604.mrd"; 
    var strTitle = "Dangerous Cargo Manifest";    
    var vslCd = " vslCd[" + formObject.elements["vvd_cd"].value.substring(0, 4) + "]";
    var skdVoyNo = " skdVoyNo[" + formObject.elements["vvd_cd"].value.substring(4, 8) + "]";
    var skdDirCd = " skdDirCd[" + formObject.elements["vvd_cd"].value.substring(8, 9) + "]";
    var agntName =" agntName["+formObject.elements["agnt_name"].value+"]";
    var mstName =" mstName["+formObject.elements["mst_name"].value+"]";    
    
    var txtType = ""; //" txtType[" + formObject.elements["list_type"].text + "]";
    
    var where = " where[]";    
    var strType = formObject.elements["list_type"].value;    
    var strSQL = "";
	
	var type = formObject.elements["list_type"];
	var strTypeNm = type.options[type.selectedIndex].text;   
	        
    if(strType == "L"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD ='L'";
    	txtType = " txtType[Load]";
    } else if(strType == "D"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD ='D'";
    	txtType = " txtType[Discharge]";
    } else if(strType == "T"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD ='T'";
    	txtType = " txtType[Transit]";
    } else if(strType == "B"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')";
    	txtType = " txtType[On Board]";
    } else if(strType == "BE"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')";
    	txtType = " txtType[On Board Excel]";
    } else if(strType == "SE"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')";
    	txtType = " txtType[Summary Excel]";
    }
    
    var polCd = formObject.elements["pol_cd"].value;
    var podCd = formObject.elements["pod_cd"].value;
    var crrCd = formObject.elements["crr_cd"].value;
    
    if(polCd.length > 0 && strType == "L" ){
    	strSQL += " AND EUR_DG.POL_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "D"){
    	strSQL += " AND EUR_DG.POL_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "T"){
    	strSQL += " AND EUR_DG.PORT_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "BE"){
    	strSQL += " AND EUR_DG.PORT_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "SE"){
    	strSQL += " AND EUR_DG.PORT_CD = '"+polCd+"'";  
    }
    
    if(podCd.length > 0){
    	strSQL += " AND EUR_DG.POD_CD = '"+podCd+"'"; 
    }
    
    if(crrCd.length > 0){
    	strSQL += " AND EUR_DG.CGO_OPR_CD = '"+crrCd+"'"; 
    }
    
    where = " where["+ strSQL + "]";    
    
    //alert(where+"\n"+vslCd+"\n"+skdVoyNo+"\n"+skdDirCd+"\n"+agntName+"\n"+mstName+"\n"+txtType);
        
    var rvParam = " /rv" + where + vslCd + skdVoyNo + skdDirCd + agntName + mstName + txtType;    
	
    formObject.elements["com_mrdPath"].value = strPath;
    formObject.elements["com_mrdArguments"].value = rvParam;
    formObject.elements["com_mrdTitle"].value = strTitle;
    formObject.elements["com_listType"].value = strTypeNm;
    formObject.elements["com_mrdBodyTitle"].value = "<span style='color:red'>" + strTitle + "</span>";
    formObject.elements["com_mrdSaveDialogFileName"].value = formObject.elements["vvd_cd"].value;
    ComOpenRDPopup("width=1024, height=660");
}


function paramSetting() {        
	var formObject = document.form;
    var strPath = "ESM_BKG_1604.mrd"; 
    var strTitle = "Dangerous Cargo Manifest";    
    var vslCd = " vslCd[" + formObject.elements["vvd_cd"].value.substring(0, 4) + "]";
    var skdVoyNo = " skdVoyNo[" + formObject.elements["vvd_cd"].value.substring(4, 8) + "]";
    var skdDirCd = " skdDirCd[" + formObject.elements["vvd_cd"].value.substring(8, 9) + "]";
    var agntName =" agntName["+formObject.elements["agnt_name"].value+"]";
    var mstName =" mstName["+formObject.elements["mst_name"].value+"]";    
    
    var txtType = ""; 
    
    var where = " where[]";    
    var strType = formObject.elements["list_type"].value;    
    var strSQL = "";
	
	var type = formObject.elements["list_type"];
	var strTypeNm = type.options[type.selectedIndex].text;   
	        
    if(strType == "L"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD ='L'";
    	txtType = " txtType[Load]";
    } else if(strType == "D"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD ='D'";
    	txtType = " txtType[Discharge]";
    } else if(strType == "T"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD ='T'";
    	txtType = " txtType[Transit]";
    } else if(strType == "B"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')";
    	txtType = " txtType[On Board]";
    } else if(strType == "BE"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')";
    	txtType = " txtType[On Board Excel]";
    } else if(strType == "SE"){
    	strSQL +=" AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')";
    	txtType = " txtType[Summary Excel]";
    }
    
    var polCd = formObject.elements["pol_cd"].value;
    var podCd = formObject.elements["pod_cd"].value;
    var crrCd = formObject.elements["crr_cd"].value;
    
    if(polCd.length > 0 && strType == "L" ){
    	strSQL += " AND EUR_DG.POL_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "D"){
    	strSQL += " AND EUR_DG.POL_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "T"){
    	strSQL += " AND EUR_DG.PORT_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "BE"){
    	strSQL += " AND EUR_DG.PORT_CD = '"+polCd+"'";
    }else if(polCd.length > 0 && strType == "SE"){
    	strSQL += " AND EUR_DG.PORT_CD = '"+polCd+"'";  
    }
    
    if(podCd.length > 0){
    	strSQL += " AND EUR_DG.POD_CD = '"+podCd+"'"; 
    }
    
    if(crrCd.length > 0){
    	strSQL += " AND EUR_DG.CGO_OPR_CD = '"+crrCd+"'"; 
    }
    
    where = " where["+ strSQL + "]";    
    //alert(where+"\n"+vslCd+"\n"+skdVoyNo+"\n"+skdDirCd+"\n"+agntName+"\n"+mstName+"\n"+txtType);
        
    var rvParam = " /rv" + where + vslCd + skdVoyNo + skdDirCd + agntName + mstName + txtType;   
     
    formObject.elements["mrd_path"].value = strPath;
    formObject.elements["mrd_arguments"].value = rvParam;
    formObject.elements["mrd_title"].value = strTitle;
    formObject.elements["list_nm"].value = strTypeNm;
    formObject.elements["mrd_body_title"].value = "<span style='color:red'>" + strTitle + "</span>";
    formObject.elements["mrd_file_name"].value = formObject.elements["vvd_cd"].value;
}