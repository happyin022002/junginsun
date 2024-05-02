/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0008.js
*@FileTitle  : Route Cost (PA/RA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "btn_Retrieve":
                if(formObject.conditionType[1].checked) {//from-to
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                } else {//Move to por-del product window
                }
                break;
            case "bu_zoom_in":
                if(sheetObject.RowCount()>25){
                    sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheetObject.RowCount()));
                    div_zoom_out.style.display="inline";
                    div_zoom_in.style.display="none";
                    //parent.syncHeight();
                }
                break;
            case "bu_zoom_out":
                if(sheetObject.RowCount()>25){
                    sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, 20));
                    div_zoom_in.style.display="inline";
                    div_zoom_out.style.display="none";
                    //parent.syncHeight();
                }
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // handling multi-combo object
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    ComSetFocus(document.form.f_from);
    changeConditionType('1');
    //Setting current date
    document.form.f_cost_yrmon.value=ComGetNowInfo("ym");
}
/**
 * Function to initialize the IBCOMBO <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} comboObj mandatory IBMultiCombo Object
 * @param {int} comboNo mandatory  The order of the IBMultiCombo
 * @return nothing     
 */ 
function initCombo(comboObj, comboId) {
     switch(comboObj.options.id) {
        case "f_act_grp_cd":
            with(comboObj) {
                SetDropHeight(300);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(30);
                SetUseAutoComplete(1);
	            ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
                SetSelectIndex("0", false);
            }
            break;
        case "f_cntr_tpsz_cd":
            with(comboObj) {
                SetDropHeight(300);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(3);
                SetUseAutoComplete(1);
	            ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
                SetSelectIndex("0", false);
            }
            break;
        case "f_cost_loc_grp_cd":
            with(comboObj) {
                SetDropHeight(300);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(4);
                SetUseAutoComplete(1);
	            ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
                SetSelectIndex("4", false);
//                DeleteItem(5);				//20160303.DEL : 요청
//                DeleteItem(2);
            }
            break;   
    }
}           

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:	//sheet2 init
		    with(sheetObj){
		        var HeadTitle="From|To|A/G|Cost Element/Cost Code|Ctrt/Avg|Curr.|Cost|Location\nHierarchy|lvl" ;
		        
		//        SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
				SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );
		        
		        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        
		        var cols = [{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lnk_fm_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lnk_to_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"grp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		//                    {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   TreeCol:1 },
		                    {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                    {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                    {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cost",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                    {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loc_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		        			{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lvl" } ];
		        
		        InitColumns(cols);
		        
		        SetEditable(0);//Editkind[optional,Defaultfalse]
		        SetCountPosition(0);
		        SetWaitImageVisible(0);
		//        SetSheetHeight(430);
				resizeSheet();
		        //InitTreeInfo(3, "", "#0000FFNAN";
		      }
		    break;
		    
		case 2:	//sheet2 init
		    with(sheetObj){
		        var HeadTitle="From|To|A/G|Cost Element/Cost Code|Ctrt/Avg|Curr.|Cost|Location\nHierarchy|lvl" ;
		        
		//        SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
				SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );
		        
		        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        
		        var cols = [{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lnk_fm_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lnk_to_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"grp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		//                    {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   TreeCol:1 },
		                    {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                    {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                    {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cost",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		                    {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loc_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		        			{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lvl" } ];
		        
		        InitColumns(cols);
		        
//		        SetEditable(0);//Editkind[optional,Defaultfalse]
//		        SetCountPosition(0);
//		        SetWaitImageVisible(0);
		        SetSheetHeight(430);
//				resizeSheet();
		        //InitTreeInfo(3, "", "#0000FFNAN";
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
    comboObjects[comboCnt++]=combo_obj;
}
function sheet1_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);   

	for (i=1;i<=sheetObj.RowCount();i++) {
		if (sheetObj.GetCellValue(i,"lvl") == "1") {
			sheetObj.SetCellValue(i,"cost_nm", "+ " + sheetObj.GetCellValue(i,"cost_nm"));
		} else if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
			sheetObj.SetCellValue(i,"cost_nm", "  └ " + sheetObj.GetCellValue(i,"cost_nm"));
			sheetObj.SetRowHidden(i,1);
		}
	}
//	sheetObj.ShowTreeLevel(0, 1);
    sheetObj.SetSumText(0,0, "TOTAL");
	sheetObj.SetDataMerge();
}
function sheet2_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);   

	for (i=1;i<=sheetObj.RowCount();i++) {
		if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
			sheetObj.SetCellValue(i,"cost_nm", "  - " + sheetObj.GetCellValue(i,"cost_nm"));
			sheetObj.SetRowHidden(i,1);
		}
	}
//	sheetObj.ShowTreeLevel(0, 1);
    sheetObj.SetSumText(0,0, "TOTAL");
	sheetObj.SetDataMerge();
}

// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:                   
            ComOpenWait(true);
            var sXml=formObj.sXml.value;                    
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                ComXml2ComboItem(arrXml[0], f_cost_loc_grp_cd, "code", "name");
            }
            if (arrXml.length > 1) {
                ComXml2ComboItem(arrXml[1], f_cntr_tpsz_cd, "code", "code");
            }
            if (arrXml.length > 2) {
                ComXml2ComboItem(arrXml[2], f_act_grp_cd, "code", "name");
                comboObjects[2].InsertItem(0, 'All','All');
            }
            ComSetObjValue(formObj.sXml, "");
            ComOpenWait(false);
            break;
        case IBSEARCH:      //Inquiry

            if(validateForm(sheetObj,formObj,sAction)) {
                // Prohibit button click when a business transaction is processing 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
//                sheetObj.ShowSubSum([{StdCol:"grp", SumCols:"cost"}]);
                
                sheetObj.DoSearch("ESM_COA_0008GS.do",coaFormQueryString(formObj) );
                sheetObjects[1].DoSearch("ESM_COA_0008GS.do",coaFormQueryString(formObj) );
            }
            break;
        case IBDOWNEXCEL:           // excel down
            var excelType=selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType){
    var sheetObj = sheetObjects[1];
    switch (excelType) {
	    case "AY":
	        sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	        break;
	    case "AN":
	    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	break;
	    case "DY":
	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	    case "DN":
	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	}            
}

/**
* Handling process for form object input validation
*/
function validateForm(sheetObj,formObj,sAction){
    var rt=false;
    with(formObj){
        if(formObj.conditionType[1].checked){       //Select Port ToFR Inland conditions
            if(formObj.f_from.value == "") {
                ComShowCodeMessage('COA10002', 'From');
                ComSetFocus(formObj.f_from);
            } 
            else if(formObj.f_to.value == "") {
                ComShowCodeMessage('COA10002', 'To');
                ComSetFocus(formObj.f_to);
            } 
            else if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
                ComShowCodeMessage('COM12180');
            } 
            else {
                rt=true;
            }
        }
    }
    return rt;
}
/**
        * window move
*/
function changeConditionType(v){
    var frm=document.form;
    if(v == '1'){//Port To/FR Inland
        div_coa.style.display="inline";
   } else if(v == '0'){//Org To
        window.open("/opuscntr/ESD_PRD_0020.do?pgmNo=ESD_PRD_0020","");
        sheetObjects[0].SetEditable(0);
    }
}
/**
* Open the common popup of the location code
*/
function openLocationCode(funtionNm){
    if(document.form.conditionType[0].checked){//Open popup in case of org-to, getF_por, getF_del   
        if(funtionNm == "getF_por" || funtionNm == "getF_del")
            ComOpenPopup('/opuscntr/COM_ENS_051.do', 800, 490,  funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
    } else {//Open popup in case of port, getF_from, getF_to
        if(funtionNm == "getF_from" || funtionNm == "getF_to")
        ComOpenPopup('/opuscntr/COM_ENS_051.do', 800, 490,  funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
}
function getF_from(rowArray) {
    var colArray=rowArray[0];
    document.form.f_from.value=colArray[3];
    document.form.f_to.focus();
}
function getF_to(rowArray) {
    var colArray=rowArray[0];
    document.form.f_to.value=colArray[3];
    document.form.f_cost_yrmon.focus();
}
/**
 * Deactivate Activity Group Combo when the Empty selected
 */
function hideActGrpCombo(){
    var frm=document.form;
    f_act_grp_cd.SetSelectIndex("0", false);			//20150602.ADD
    f_act_grp_cd.SetEnable(0);
}
/**
 * Activate Activity Group Combo when the Full selected
 */
function showActGrpCombo(){
    var frm=document.form;
    f_act_grp_cd.SetEnable(1);
}

function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
	case "cost_nm":
		var mark=sheetObj.GetCellValue(row, "lvl");
		var status=sheetObj.GetRowStatus(row);
		if(mark == "3"){
			var startRow = row + 1;
			var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
			sheetObj.SetCellValue(row,"cost_nm", "+"+sheetObj.GetCellValue(row,"cost_nm").substr(1));
			sheetObj.SetCellValue(row,"lvl", "1");
			for(;startRow <= endRow;startRow++){
				sheetObj.SetRowHidden(startRow,1);
			}
		}
		else if(mark == "1"){
			var startRow = row + 1;
			var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
			sheetObj.SetCellValue(row,"cost_nm", "-"+sheetObj.GetCellValue(row,"cost_nm").substr(1));
			sheetObj.SetCellValue(row, "lvl", "3");
			for(;startRow <= endRow;startRow++){
				sheetObj.SetRowHidden(startRow,0);
			}
		}
		sheetObj.SetDataMerge();
		break;
	}
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
