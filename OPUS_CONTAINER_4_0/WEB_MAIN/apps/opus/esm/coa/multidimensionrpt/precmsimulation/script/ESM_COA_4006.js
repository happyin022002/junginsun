/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4006.js
*@FileTitle  : (CMTX)Route Cost Inqiury 
*@author     : CLT
*@version    : 1.0
*@since      : 2015/03/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
/* Developer's task */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var sheet_height=300; // sheet height

/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    /*******************************************************/
    var formObject=document.form;
    try { 
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheet1,formObject,IBSEARCH);
                break;
			case "btn_downexcel":				
				doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
				break;                
            case "btns_remarks":
                btng_remarks_OnClick(sheet1);
                break;  
			case "bu_zoom_in":
                if ( sheetObjects[0].RowCount() < 1 ) return;
                sheetObjects[0].SetSheetHeight( sheetObjects[0].GetSheetHeight(sheet_height) * 2 );
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
				break;
			case "bu_zoom_out":
                if ( sheetObjects[0].RowCount() < 1 ) return;
                sheetObjects[0].SetSheetHeight( 350 );
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
				break;	
            case "btn_Close":
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
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen.
*/
function loadPage() {
    var formObject=document.form;
    loadingMode=true;
    if(popup_flag=="N") {
//    	doActionIBSheet(sheet1,document.form,IBCLEAR);
//        for(k=0;k<comboObjects.length;k++){
//            initCombo(comboObjects[k], k+1);
//        }
    }
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    } 
    if (formObject.f_pctl_no.value !=null && formObject.f_pctl_no.value !=""){
        setRetrieveAction();
    }       
    ComSetFocus(formObject.f_pctl_no);
    loadingMode=false;
}
 /**
  * Multi-combo handling
        * initializing Tab
        * setting Tab items
 */
function initCombo (comboObj, comboNo) {
     with (comboObj) {
        SetDropHeight(300);        
    }
} 
/**
        * setting sheet initial values and header
        * param : sheetObj, sheetNo
        * adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
    switch(sheetNo) {
        case 1:     //sheet1 init
            with(sheetObj){
                var HeadTitle="Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Feeder Term|Feeder Term|EPP A Amount|EPP A Amount|EPP A Amount|EPP A Amount|EPP B Amount|EPP B Amount|EPP B Amount|EPP B Amount|20_flg|40_flg|45_flg|45_2_flg|lvl" ;
                var HeadTitle1="Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Rev_Term|Del_Term";
                var HeadTitle2="|"+document.form.f_eq_tp_cd.value+"2|"+document.form.f_eq_tp_cd.value+"4|"+document.form.f_eq_tp_cd.value+"5|"+document.form.f_eq_tp_cd.value+"7|"+document.form.f_eq_tp_cd.value+"2|"+document.form.f_eq_tp_cd.value+"4|"+document.form.f_eq_tp_cd.value+"5|"+document.form.f_eq_tp_cd.value+"7|20_flg|40_flg|45_flg|45_2_flg|lvl";
                HeadTitle1 = HeadTitle1+HeadTitle2;
                
                
//                var HeadTitle1="Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Rev_Term|Del_Term|20'|40'|45'|20'|40'|45'|lvl" ;
                
//                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
				SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"nod_cd" },
                            {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"grp" },
                            {Type:"Text",     Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"dw_nod_cd" },
                            {Type:"Text",     Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"dw_grp" },
                            {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"tree_col" , TreeCol:1 },
                            {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"dw_tree_col" },
                            {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"wtr_rcv_term_cd" },
                            {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"wtr_de_term_cd" },
                            //20150616.MOD
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt20_a", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt40_a", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt45_a", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt45_2_a", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt20_b", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt40_b", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt45_b", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Float",    Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"amt45_2_b", KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2 },
                            {Type:"Text",     Hidden:1, Width:80,    Align:"Center",   ColMerge:1,   SaveName:"mis_avg_flg_20" },
                            {Type:"Text",     Hidden:1, Width:80,    Align:"Center",   ColMerge:1,   SaveName:"mis_avg_flg_40" },
                            {Type:"Text",     Hidden:1, Width:80,    Align:"Center",   ColMerge:1,   SaveName:"mis_avg_flg_45" },
                            {Type:"Text",     Hidden:1, Width:80,    Align:"Center",   ColMerge:1,   SaveName:"mis_avg_flg_45_2" },
                            {Type:"Text",     Hidden:1, Width:80,    Align:"Center",   ColMerge:1,   SaveName:"lvl" }];
                                                                   
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                //SetRangeBackColor(1, 6, 1, 7,"#DEFBF8");
                //InitTreeInfo("tree_col", "", "#0000FFNAN");
                SetSheetHeight(340);
                SetColHidden("nod_cd",0);
                SetColHidden("grp",0);
                SetColHidden("tree_col",0);
                SetColHidden("dw_nod_cd",1);
                SetColHidden("dw_grp",1);
                SetColHidden("dw_tree_col",1);
                if(document.form.f_eq_tp_cd.value == "R"){
                	SetColHidden("amt40_a",1);
                	SetColHidden("amt40_b",1);
                }else if(document.form.f_eq_tp_cd.value == "F"||document.form.f_eq_tp_cd.value == "O"){
                	SetColHidden("amt45_2_a",1);
                	SetColHidden("amt45_2_b",1);
                }else if(document.form.f_eq_tp_cd.value == "T"){
                	SetColHidden("amt45_2_a",1);
                	SetColHidden("amt45_2_b",1);
                	SetColHidden("amt45_a",1);
                	SetColHidden("amt45_b",1);
                }
            }
            break;
        
        //20150616.ADD
		case 2:
			with(sheetObj) {

		        var HeadTitle1="STS|Charge\nCode|Amount(USD)|Amount(USD)|Amount(USD)|Amount(USD)|Apply|PCTL NO|LVL|LVL2|SEQ";
		        var HeadTitle2="STS|Charge\nCode|2|4|5|7|Apply|PCTL NO|LVL|LVL2|SEQ";

		        SetConfig( { SearchMode:2, MergeSheet:5, Page:30, DataRowMerge:0 } );
  		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
  		        var headers = [ { Text:HeadTitle1, Align:"Center"},
								{ Text:HeadTitle2, Align:"Center"} ];

		        InitHeaders(headers, info);

		        var cols = [ {Type:"Status",    Hidden:0,   Width:40,   Align:"Center", ColMerge:0, SaveName:"ibflag" },
		                     {Type:"Text",		Hidden:0,	Width:80,   Align:"Center",	ColMerge:0,	SaveName:"chg_cd",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d20",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d40",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d45",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
			                 {Type:"Float",		Hidden:0,	Width:100,  Align:"Right",	ColMerge:0,	SaveName:"d70",			KeyField:0,	CalcLogic:"",	Format:"float",	PointCount:2,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"CheckBox",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:0,	SaveName:"apply",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"Text",		Hidden:1,	Width:80,   Align:"Center",	ColMerge:0,	SaveName:"pctl_no",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"Text",	    Hidden:0,	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"lvl",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"Text",	    Hidden:0,	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"lvl2",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
  			                 {Type:"Text",	    Hidden:0,	Width:50,	Align:"Center",	ColMerge:0,	SaveName:"pc",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 }

  			               ];

	      	    InitColumns(cols);
    		    SetEditable(1);
                SetWaitImageVisible(0);
                SetSheetHeight(200);
                SetHeaderRowHeight(12);
                SetCountPosition(0);
            }

			break;                

    }
}
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
} 
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
*/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/*To retrieve when the screen is loaded */
function setRetrieveAction(){
    formObj=document.form;
    
    //20150616.ADD
	sheetObjects[1].RemoveAll();
	var sXml=ComPriSheet2Xml(opener.sheet2);
	sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
	
	var Row = sheetObjects[1].DataInsert(-1);
	sheetObjects[1].SetCellValue(Row, "chg_cd", "Ocean Freight");
	sheetObjects[1].SetCellValue(Row, "d20", (opener.document.form.f_rv_20.value==""? 0 : opener.document.form.f_rv_20.value));
	sheetObjects[1].SetCellValue(Row, "d40", (opener.document.form.f_rv_40.value==""? 0 : opener.document.form.f_rv_40.value));
	sheetObjects[1].SetCellValue(Row, "d45", (opener.document.form.f_rv_45.value==""? 0 : opener.document.form.f_rv_45.value));
	sheetObjects[1].SetCellValue(Row, "d70", (opener.document.form.f_rv_70.value==""? 0 : opener.document.form.f_rv_70.value));
	sheetObjects[1].SetCellValue(Row, "pctl_no", formObj.f_pctl_no.value);	
	sheetObjects[1].SetCellValue(Row, "apply", 1);
	
	for ( var i = sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
		//20150617.ADD : pctl 같은것만..
		if(sheetObj.GetCellValue(i, "pctl_no") != formObj.f_pctl_no.value){
			sheetObjects[1].SetCellValue(i, "apply", 0);
		}
		if(sheetObj.GetCellValue(i, "chg_cd") == "Ocean Freight"){
			sheetObjects[1].SetCellValue(i, "lvl", 0);
			sheetObjects[1].SetCellValue(i, "lvl2", 1);
			sheetObjects[1].SetCellValue(i, "pc", 0);
		} else {
			sheetObjects[1].SetCellValue(i, "lvl", 0);
			sheetObjects[1].SetCellValue(i, "lvl2", 0);
			sheetObjects[1].SetCellValue(i, "pc", i);
		}
		if(sheetObj.GetCellValue(i, "apply") == 1){
			sheetObjects[1].SetCellValue(i, "ibflag","I");
		}
	}
	
    doActionIBSheet(sheet1,formObj,IBSEARCH);
}   
/**
 * It is retrieved by clicking the remark button
 */
function btng_remarks_OnClick(sheetObj){
    document.form.f_cmd.value=SEARCHLIST01;
    ComOpenWindow('ESM_COA_4007.do?'+coaFormQueryString(document.form),'Route Cost Detail', 'width=1200,height=660,menubar=0,status=1,scrollbars=1,resizable=1');
//    ComOpenWindowCenter('ESM_COA_4007.do?' + coaFormQueryString(document.form), 'ESM_COA_4007', 1000, 660, false );
}
/**
Folding tree level
*/
function sheet1_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    
	for (i=1;i<=sheetObj.RowCount()+2;i++) {
		if (sheetObj.GetCellValue(i,"lvl") == "1") {
			sheetObj.SetCellValue(i,"tree_col", "+ " + sheetObj.GetCellValue(i,"tree_col"));
		} else if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
			sheetObj.SetCellValue(i,"tree_col", "  └ " + sheetObj.GetCellValue(i,"tree_col"));
			sheetObj.SetRowHidden(i,1);
		}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_20")=="1"){
    		sheetObj.SetCellFontColor(i, "amt20_a","#FF0000");
    		sheetObj.SetCellFontColor(i, "amt20_b","#FF0000");
    	}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_40")=="1"){
    		sheetObj.SetCellFontColor(i, "amt40_a","#FF0000");
    		sheetObj.SetCellFontColor(i, "amt40_b","#FF0000");
    	}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_45")=="1"){
    		sheetObj.SetCellFontColor(i, "amt45_a","#FF0000");
    		sheetObj.SetCellFontColor(i, "amt45_b","#FF0000");
    	}
		if(sheetObj.GetCellValue(i,"mis_avg_flg_45_2")=="1"){
    		sheetObj.SetCellFontColor(i, "amt45_2_a","#FF0000");
    		sheetObj.SetCellFontColor(i, "amt45_2_b","#FF0000");
    	}
	}
    
	sheetObj.ShowTreeLevel(1, 1);
//    sheetObj.SetSumText(0, "TOTAL");
	sheetObj.SetDataMerge();
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
//	    case IBCLEAR: //Inquiry
//	        sheetObj.SetWaitImageVisible(0);
//	        ComOpenWait(true);
//	            formObj.f_cmd.value=INIT;
//	            var sXml=sheetObj.GetSearchData("ESM_COA_4006GS.do", coaFormQueryString(formObj)); 
//	            var arrXml=sXml.split("|$$|");
//	            if (arrXml.length > 0) 
//	                ComXml2ComboItem(arrXml[0], f_pro_lvl, "code", "name");	  
//	            
//	            f_type_cd.InsertItem(0, "EPP A", "A");
//	            f_type_cd.InsertItem(1, "EPP B", "B");
//	            f_type_cd.SetSelectIndex(0);	            	
//	            ComOpenWait(false);
//	        break;    
        case IBSEARCH:      //Inquiry
        	if(!validateForm(sheetObj,formObj,sAction)) return false;
        	formObj.f_cmd.value=SEARCH01;        	
            var sParam = sheetObjects[1].GetSaveString(1);
            sParam = sParam + "&" + FormQueryString(formObj);
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);            
            setTimeout( function () {    
                sheetObj.DoSearch("ESM_COA_4006GS2.do", sParam ,{Sync:1} );
                ComOpenWait(false);
            }, 100);
            break;
            
        case IBDOWNEXCEL:
    		if(sheetObj.RowCount() < 1){//no data	
    			ComShowCodeMessage("COM132501");
    		}else{	
    			sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
    		}
        	break;
    }
}

/**
* Handling process for form object input validation
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if (f_pctl_no.value == "") {
            ComAlertFocus(f_pctl_no, ComGetMsg("COA10002", "pctl_no", ""));
            return false;
        }
    }
    return true;
}

function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
	case "tree_col":
		var mark=sheetObj.GetCellValue(row, "lvl");
		var status=sheetObj.GetRowStatus(row);
		if(mark == "3"){
			var startRow = row + 1;
			var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
			sheetObj.SetCellValue(row,"tree_col", "+"+sheetObj.GetCellValue(row,"tree_col").substr(1));
			sheetObj.SetCellValue(row,"lvl","1");
			for(;startRow <= endRow;startRow++){
				sheetObj.SetRowHidden(startRow,1);
			}
		}
		else if(mark == "1"){
			var startRow = row + 1;
			var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
			sheetObj.SetCellValue(row,"tree_col", "-"+sheetObj.GetCellValue(row,"tree_col").substr(1));
			sheetObj.SetCellValue(row, "lvl", "3");
			for(;startRow <= endRow;startRow++){
				sheetObj.SetRowHidden(startRow,0);
			}
		}
		sheetObj.SetDataMerge();
		break;
	}
}


/* Developer's task ends */
