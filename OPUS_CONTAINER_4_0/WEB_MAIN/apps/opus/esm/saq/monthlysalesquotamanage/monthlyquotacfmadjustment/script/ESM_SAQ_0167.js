/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0167.js
*@FileTitle  : Office Add(Quota Edit) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends 
     * @class ESM_SAQ_0167 : business script for ESM_SAQ_0167
     */
var sheetObjects=new Array();
var comObjects=new Array();
var comboCnt=0;
var sheetCnt=0;
var comboAll=true;
var errorCheck=false;
var isParentRefresh=false;
var pWindow="";
var rtnValue = "CANCEL";


//Event handler processing by button click event */
document.onclick=processButtonClick;

//Event handler processing by button name */
function processButtonClick(){
	/*******************************************************/
	var sheetObj1=sheetObjects[0];
	var sheetObj2=sheetObjects[1];
	var formObj=document.form;
	
	
	try {
		var srcName=ComGetEvent("name");
		var srcObj=window.event.srcElement;
		if(ComGetBtnDisable(srcName)){
			return false;
		}
//		if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
		switch(srcName) {
		    case "btn_officeadd":		    	
//		        sheetObj1.Redraw = false;
		        //if (validationData(sheetObj1) == false) return;		        
		        errorCheck=false;		        
		        doActionIBSheet(sheetObj2,formObj,IBSEARCH_ASYNC01);
//		        sheetObj1.Redraw = true;
		        break;
			case "btn_save":
				rtnValue = "OK";
			    doActionIBSheet(sheetObj1,formObj,IBSAVE);
			    break;
			case "btn_close":
				ComPopUpReturnValue(rtnValue);
				//ComClosePopup();
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage(){
    var sheetObj=sheetObjects[0];
	var formObj=document.form;
    pWindow=window.dialogArguments;
    if(!pWindow) pWindow=parent;
    pWindow.isParentRefresh=false;
	for(var i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    if(formObj.add_tp_cd.value == "L"){
        document.getElementById("new_rlane").style.display="inline";
        document.getElementById("popup_title").innerHTML="<span>Lane Add</span>";
    }
    setSelect_box(formObj.sub_trd_cd);
    if(formObj.param_rlane_cd.value != ""){
        setSelect_box(formObj.rlane_cd);
        setSelect_box(formObj.rhq_cd);
    }
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}	

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var add_tp_cd=document.form.add_tp_cd.value;
    var cnt=0;
    switch(sheetNo) {
		case 1:
		    with(sheetObj){
	       
			      var HeadTitle="|Del|Month|Week|Trade|Lane|Lane|VVD|Office|vsl_cd|skd_voy_no|skd_dir_cd|Bound|Sub Trade|Rhq|Aq|ioc_cd|vvd_seq|lst_lodg_port_etd_dt|bsa_capa|Add Type";
		
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mon",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"week",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:(add_tp_cd == "L"?1:0 ),  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:(add_tp_cd == "L"?0:1 ),  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"new_rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rgn_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"aq_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bsa_capa",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"add_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			      SetEditable(1);
			      SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
	            }
			break;
			
		case 2:
		    with(sheetObj){
			      var HeadTitle="|Del|Month|Week|Trade|Lane|Lane|VVD|Office|vsl_cd|skd_voy_no|skd_dir_cd|Bound|Sub Trade|Rhq|Aq|ioc_cd|vvd_seq|lst_lodg_port_etd_dt|bsa_capa|Add Type";
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mon",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"week",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"new_rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rgn_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"aq_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bsa_capa",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"add_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
	            }
			break;
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
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj){
	comObjects[comboCnt++]=combo_obj;
}

// select box setting
function setSelect_box(obj) {
    var formObj=document.form;
    var objName=obj.name;
    if(objName == "") objName=obj.id;
    
    if(objName == "sub_trd_cd"){
        if(formObj.param_rlane_cd.value == ""){
            var params="rlse_ver_no=" + formObj.mqtaRlseVerNo.value
                        + "&bse_year="   + formObj.bse_yr.value
                        + "&bse_qtr_cd=" + formObj.bse_qtr_cd.value
                        + "&trd_cd="     + formObj.trd_cd.value
                        + "&dir_cd="     + formObj.dir_cd.value;
            getSelectCodeList(obj, "SaqCfmTgtSubTrd", params, true, new Option('', ''));
        } else {
            var params="&trd_cd="   + formObj.trd_cd.value
                        + "&dir_cd="   + formObj.dir_cd.value
                        + "&rlane_cd=" + formObj.param_rlane_cd.value;
            getSelectCodeList(obj, "SaqMdmSubTrd", params, true);
        }
    }
    
    if(objName == "rlane_cd"){
        optionRemoveAll(obj);
        if(formObj.sub_trd_cd.value != "") {
            var params="rlse_ver_no="     + formObj.mqtaRlseVerNo.value
                        + "&bse_year="       + formObj.bse_yr.value
                        + "&bse_qtr_cd="     + formObj.bse_qtr_cd.value
                        + "&trd_cd="         + formObj.trd_cd.value
                        + "&dir_cd="         + formObj.dir_cd.value
                        + "&sub_trd_cd="     + formObj.sub_trd_cd.value
                        + "&param_rlane_cd=" + formObj.param_rlane_cd.value;
//            if(formObj.add_tp_cd.value == "L"){
                //getSelectCodeList(obj, "LaneBoundSwitchRlane", params, true, new Option('', ''));
//            } else if(formObj.param_rlane_cd.value == ""){
	              getSelectCodeList(obj, "SaqCfmTgtLane", params, true, new Option('', ''));
//            } else {
//                getSelectCodeList(obj, "SaqCfmTgtLane", params, true);
//            }
        }
    }
    
    if(objName == "rhq_cd"){
        optionRemoveAll(obj);
        if(formObj.rlane_cd.value != "") {
            var params="&bse_year="   + formObj.bse_yr.value
                        + "&bse_qtr_cd=" + formObj.bse_qtr_cd.value
                        + "&qta_tgt_cd=" + formObj.qtaTgtCd.value
                        + "&trd_cd="     + formObj.trd_cd.value
                        + "&dir_cd="     + formObj.dir_cd.value
                        + "&rlane_cd="   + formObj.rlane_cd.value;
            getSelectCodeList(obj, "SaqCfmTgtRhq", params, true, new Option('', ''));
        }
    }
    
    if(objName == "aq_cd" ){
        optionRemoveAll(obj);
        if(formObj.rhq_cd.value != "") {
            var params="rlse_ver_no=" + formObj.mqtaRlseVerNo.value
                        + "&bse_year="   + formObj.bse_yr.value
                        + "&bse_qtr_cd=" + formObj.bse_qtr_cd.value
                        + "&qta_tgt_cd=" + formObj.qtaTgtCd.value
                        + "&trd_cd="     + formObj.trd_cd.value
                        + "&dir_cd="     + formObj.dir_cd.value
                        + "&rlane_cd="   + formObj.rlane_cd.value
                        + "&sub_trd_cd=" + formObj.sub_trd_cd.value
                        + "&rhq_cd="     + formObj.rhq_cd.value
                        + "&app_tp_cd="  + formObj.add_tp_cd.value;
            getSelectCodeList(obj, "SaqArea", params, true, new Option('', ''));
            objName="rgn_ofc_combo";
        }
    }
    
    if(objName == "rgn_ofc_combo"){
        optionRemoveOffice();
        if(formObj.rhq_cd.value != "") {
            var params="rlse_ver_no=" + formObj.mqtaRlseVerNo.value
                        + "&bse_year="   + formObj.bse_yr.value
                        + "&bse_qtr_cd=" + formObj.bse_qtr_cd.value
                        + "&qta_tgt_cd=" + formObj.qtaTgtCd.value
                        + "&trd_cd="     + formObj.trd_cd.value
                        + "&dir_cd="     + formObj.dir_cd.value
                        + "&rlane_cd="   + formObj.rlane_cd.value
                        + "&sub_trd_cd=" + formObj.sub_trd_cd.value
                        + "&rhq_cd="     + formObj.rhq_cd.value
                        + "&aq_cd="      + formObj.aq_cd.value
                        + "&app_tp_cd="  + formObj.add_tp_cd.value;
            var rtn=getCodeList("SaqOffice", params);
            initData_Office(rtn[0].split("|"), rtn[1].split("|"));
            checkData_office();
        }
    }
}

function initData_Office(codes, names){
    var cnt=0;
    with(rgn_ofc_combo){
        RemoveAll();
        SetTitle("Office");
		SetColWidth(0, "100");
		SetColAlign(0, "left");
        //no support[check again]CLT ShowCol=0;
        SetMultiSelect(1);
        SetDropHeight(190);
        if(codes == undefined || codes == null){
        	return;
        }
        if(codes.length > 2){
    		InsertItem(-1, "ALL", "");
        }
    	var selectCode="";
	    for(var i=0 ; i < codes.length - 1 ; i++){
	    	var txt=names[i].split("~");
	    	if(txt[1] == "1"){
	    		selectCode=codes[i];
	    	}
	    	InsertItem(-1, codes[i], codes[i]);
	    }
	    if(selectCode != ""){
	    	Code=selectCode;
	    }
	    else{
	    	Index=0;
	    }
		SetEnable((GetItemCount() > 1));
		SetEnable(!(Index > 1));
    }
}

function rgn_ofc_combo_OnCheckClick(comboObj, index, code) { 
	SaqAllChkMultiCombo(comboObj,index);    
}

//function rgn_ofc_combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
//    var checkRow=comboObj.GetSelectIndex();
//    var arrRow=checkRow.split(",");
//    var index="";
//    if(comboAll && arrRow[0] != 0){           // unchecked all
//        comboAll=false;
//        comboObj.SetSelectIndex("-1",false);
//    } else if(!comboAll && arrRow[0] == 0){   // checked all
//        comboAll=true;
//        for(i=0;i<comboObj.GetItemCount();i++){
//            index=index + "," + i;
//        }
//        comboObj.SetSelectIndex(index,false);
//    } else if(comboAll && comboObj.GetItemCount() != arrRow.length){       // ALL checkbox를 check에서 uncheck로 변경한 경우
//        comboAll=false;
//        comboObj.SetSelectIndex(checkRow.substring(2, checkRow.length));
//    } 
//    
//}

function optionRemoveAll(obj) {
    var formObj=document.form;
    var objName="";
    while(1){
        objName=obj.name;
        var opts=obj.options;
        
    	for (i=(opts == null ? 0 : opts.length); i >= 0; i--) {
    		opts.remove(i);
        }
        
        if(objName == "sub_trd_cd")    obj=formObj.rlane_cd;
        else if(objName == "rlane_cd") obj=formObj.rhq_cd;
        else if(objName == "rhq_cd")   obj=formObj.aq_cd;
        else break;
    }
    optionRemoveOffice();
}

function optionRemoveOffice(){
    rgn_ofc_combo.RemoveAll();
    comboAll=false;
}

// hadling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      // 조회   
			formObj.f_cmd.value=SEARCHLIST;
 			sheetObj.DoSearch("ESM_SAQ_0167GS.do", saqFormString(formObj) );
			break;
			
		case IBSAVE:   
		    if (!chkDupRow(sheetObj)) {
                ComShowCodeMessage("COM131302", "[Month][Week][Trade][Lane][VVD][OFC]");    // {?msg1} is duplicated.
                return;
            }
            
		    formObj.f_cmd.value=MODIFY01;
	        sheetObj.DoSave("ESM_SAQ_0167GS.do", saqFormString(formObj), "ibflag", false);
		    break;
		    
		case IBSEARCH_ASYNC01:  // Row Add
			if(!validateForm(sheetObj, formObj, sAction)){
            	break;
            }
            
			formObj.f_cmd.value=SEARCHLIST01;			
		    var checkRow=rgn_ofc_combo.GetSelectText();		    
		    var arrRow=checkRow.split(",");		
		    
//		    if(arrRow[0] == "ALL"){		    	
//          	arrRow=checkRow.substring(4, checkRow.length).split(",");
//          }	
            	    
            for(n=0; n < arrRow.length; n++){	        
		    	if(arrRow[n] != "ALL"){	
			        formObj.rgnOfcCd.value=arrRow[n];		        
	 		        sheetObj.DoSearch("ESM_SAQ_0167GS.do", saqFormString(formObj) );
			        if(errorCheck) break;
		        }
		    }
		    break;
	}
}

/**
 * duplication check
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */
function chkDupRow(sheetObj) { 
	var strSheet = "";
	//for (var i = 0; i < sheetObj.RowCount()+1; i++) {
//		strSheet += ":::::"+ i + "::" + sheetObj.GetCellValue(i, "mon")+ "::" + sheetObj.GetCellValue(i, "week")+ "::" + sheetObj.GetCellValue(i, "trd_cd")+ "::" + sheetObj.GetCellValue(i, "rlane_cd")+ "::" + sheetObj.GetCellValue(i, "new_rlane_cd")+ "::" + sheetObj.GetCellValue(i, "vvd")+ "::" + sheetObj.GetCellValue(i, "rgn_ofc_cd")+"\n";
//	}  
    		
    var dupRow = sheetObj.ColValueDup("delt_flg|mon|week|trd_cd|new_rlane_cd|vvd|rgn_ofc_cd");
    
    if (dupRow > 0) {
    	return false;
    } else {
    	return true;
    }
}
    
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){	
	switch(sAction){
		case IBSEARCH_ASYNC01:	
			var addTpCd = formObj.add_tp_cd.value;		
			var nRlaneCd = formObj.newRlaneCd.value;	
			var checkRow=rgn_ofc_combo.GetSelectText();		   
			
			if(addTpCd == 'L' && nRlaneCd == ''){
				ComShowMessage(getMsg("SAQ90126", "New Lane"));
		    	return false;
			}
		    
		    if(checkRow.length == 0){		    	 
		    	ComShowMessage(getMsg("SAQ90126", "Office"));
		    	return false;
		    } 
		    
			break;
	}
	return true;
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){	
    if(sheetObj.GetEtcData("status") == "OK"){
        pWindow.isParentRefresh=true;
        var formObj=document.form;
        setSelect_box(rgn_ofc_combo);
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    if(sheetObj.GetEtcData("status") == "OK"){        
        if(sheetObj.RowCount()> 0) {
            copyData();
        } else {
            ComShowMessage(getMsg("SAQ99999", "There is no data to search."));
        }
    } else {
        errorCheck=true;
    }
}

// copy sheet2 --> sheet1
function copyData(){
    var sheetObj1=sheetObjects[0];
	var sheetObj2=sheetObjects[1];
    var rowCnt1=sheetObj1.RowCount("");
    var rowCnt2=sheetObj2.RowCount("R");
    var nCnt = 0;
    
    for(i=1; i < rowCnt2+1; i++){
    	
    	var strMon = sheetObj2.GetCellValue(i, "mon");
    	var strWeek = sheetObj2.GetCellValue(i, "week");
    	var strTrdCd = sheetObj2.GetCellValue(i, "trd_cd");
    	var strVvd = sheetObj2.GetCellValue(i, "vvd");
    	var strRgnOfcCd = sheetObj2.GetCellValue(i, "rgn_ofc_cd");    
    	var strNRlaneCd = sheetObj2.GetCellValue(i, "new_rlane_cd");
    	
    	for(j=1; j < rowCnt1+1; j++){
    		//Row Add 시 이미 존재하는 경우 추가 되지 않도록
    		if(sheetObj1.GetCellValue(j, "mon") == strMon && sheetObj1.GetCellValue(j, "week") == strWeek && sheetObj1.GetCellValue(j, "trd_cd") == strTrdCd && sheetObj1.GetCellValue(j, "vvd") == strVvd && sheetObj1.GetCellValue(j, "rgn_ofc_cd") == strRgnOfcCd && sheetObj1.GetCellValue(j, "new_rlane_cd") == strNRlaneCd){
    			nCnt++;
    			break;
    		} 
    	}
    	
    	if(nCnt == 0){
    		var insertRow=sheetObj1.DataInsert(-1);       
	        sheetObj1.SetCellValue(insertRow, "mon",sheetObj2.GetCellValue(i, "mon"));
	        sheetObj1.SetCellValue(insertRow, "week",sheetObj2.GetCellValue(i, "week"));
	        sheetObj1.SetCellValue(insertRow, "trd_cd",sheetObj2.GetCellValue(i, "trd_cd"));
	        sheetObj1.SetCellValue(insertRow, "vvd",sheetObj2.GetCellValue(i, "vvd"));
	        sheetObj1.SetCellValue(insertRow, "rgn_ofc_cd",sheetObj2.GetCellValue(i, "rgn_ofc_cd"));
	        sheetObj1.SetCellValue(insertRow, "vsl_cd",sheetObj2.GetCellValue(i, "vsl_cd"));
	        sheetObj1.SetCellValue(insertRow, "skd_voy_no",sheetObj2.GetCellValue(i, "skd_voy_no"));
	        sheetObj1.SetCellValue(insertRow, "skd_dir_cd",sheetObj2.GetCellValue(i, "skd_dir_cd"));
	        sheetObj1.SetCellValue(insertRow, "dir_cd",sheetObj2.GetCellValue(i, "dir_cd"));
	        sheetObj1.SetCellValue(insertRow, "sub_trd_cd",sheetObj2.GetCellValue(i, "sub_trd_cd"));
	        sheetObj1.SetCellValue(insertRow, "rlane_cd",sheetObj2.GetCellValue(i, "rlane_cd"));
	        sheetObj1.SetCellValue(insertRow, "new_rlane_cd",sheetObj2.GetCellValue(i, "new_rlane_cd"));
	        sheetObj1.SetCellValue(insertRow, "rhq_cd",sheetObj2.GetCellValue(i, "rhq_cd"));
	        sheetObj1.SetCellValue(insertRow, "aq_cd",sheetObj2.GetCellValue(i, "aq_cd"));
	        sheetObj1.SetCellValue(insertRow, "ioc_cd",sheetObj2.GetCellValue(i, "ioc_cd"));
	        sheetObj1.SetCellValue(insertRow, "vvd_seq",sheetObj2.GetCellValue(i, "vvd_seq"));
	        sheetObj1.SetCellValue(insertRow, "lst_lodg_port_etd_dt",sheetObj2.GetCellValue(i, "lst_lodg_port_etd_dt"));
	        sheetObj1.SetCellValue(insertRow, "bsa_capa",sheetObj2.GetCellValue(i, "bsa_capa"));
	        sheetObj1.SetCellValue(insertRow, "add_tp_cd",sheetObj2.GetCellValue(i, "add_tp_cd"));	                
    	}    	
    	nCnt = 0;
    }    
}

function validationData(sheetObj){
    var formObj=document.form;
    var sub_trd_cd=formObj.sub_trd_cd.value;
    var rlane_cd=formObj.rlane_cd.value;
    var new_rlane_cd=formObj.newRlaneCd.value;
    var rhq_cd=formObj.rhq_cd.value;
    var aq_cd=formObj.aq_cd.value;
    
    if(formObj.add_tp_cd.value == "L" && formObj.newRlaneCd.value == ""){
        ComShowMessage(getMsg("SAQ90126", "New Lane"));
        formObj.newRlaneCd.focus();
        return false;
    }
    
    if(rgn_ofc_combo.GetSelectIndex()== -1){
        ComShowMessage(getMsg("SAQ90126", "Office"));
        return false;
    }
    
    var sheetObj=sheetObjects[0];
    var rowCnt=sheetObj.RowCount();
    
    // delete row in case of status=I, 
    for(i=rowCnt+1; i > 0; i--){
    	if(   sheetObj.GetCellValue(i, "ibflag")       == "I"
    		&& sheetObj.GetCellValue(i, "sub_trd_cd")   == sub_trd_cd
    		&& sheetObj.GetCellValue(i, "rlane_cd")     == rlane_cd
    		&& sheetObj.GetCellValue(i, "new_rlane_cd") == new_rlane_cd
    		&& sheetObj.GetCellValue(i, "rhq_cd")       == rhq_cd
    		&& sheetObj.GetCellValue(i, "aq_cd")        == aq_cd       ) {
    		            sheetObj.RowDelete(i, false);
    	}        
    }
    return true;
}

function checkData_office(){
    var formObj    = document.form;
    var sub_trd_cd = formObj.sub_trd_cd.value;
    var rlane_cd   = formObj.rlane_cd.value;
    var rhq_cd     = formObj.rhq_cd.value;
    var aq_cd      = formObj.aq_cd.value;
    
    if(formObj.add_tp_cd.value == "L"){
        rlane_cd=formObj.newRlaneCd.value;
    }
    var checkVal  = "";
    var checkText = "";
    var sheetObj  = sheetObjects[0];
    var rowCnt    = sheetObj.RowCount();
    var cnt=1;
    for(i=1;i < rowCnt+1;i++){
    	if(   sheetObj.GetCellValue(i, "ibflag")     == "I"
    		&& sheetObj.GetCellValue(i, "sub_trd_cd") == sub_trd_cd
    		&& sheetObj.GetCellValue(i, "rlane_cd")   == rlane_cd
    		&& sheetObj.GetCellValue(i, "rhq_cd")     == rhq_cd
    		&& sheetObj.GetCellValue(i, "aq_cd")      == aq_cd       ) {
    		if(checkVal != sheetObj.GetCellValue(i, "rgn_ofc_cd")){
    		checkVal=sheetObj.GetCellValue(i, "rgn_ofc_cd");
    		                checkText=checkText + "," + checkVal;
    		                cnt++;
    		}
    	}        
    }
    if(rgn_ofc_combo.GetItemCount() == cnt) {
        var index="";
        comboAll=true;
        for(i=0;i<rgn_ofc_combo.GetItemCount();i++){
            index=index + "|" + i;
        }
        rgn_ofc_combo.SetSelectIndex(index);
    } else if(checkText != "") {
        rgn_ofc_combo.SetSelectText(checkText.substring(1, checkText.length));
        comboAll=false;
    }
}

// to upper
function Capital_Change(obj){
    var text=obj.value;
    var str="";
    for(i=0;i<text.length;i++){
        str += text.charAt(i).toUpperCase();
    }
    obj.value=str;
}

function obj_keypress() {
	switch (ComGetEvent("dataformat")) {
	case "int":
		// 숫자만입력하기
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "float":
		// 숫자+"."입력하기
		ComKeyOnlyNumber(ComGetEvent(), ".");
		break;
	case "eng":
		// 영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		// 영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(ComGetEvent());
	}
}
