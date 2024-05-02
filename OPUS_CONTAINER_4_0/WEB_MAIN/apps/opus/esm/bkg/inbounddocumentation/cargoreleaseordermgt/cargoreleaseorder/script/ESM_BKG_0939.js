/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0939.js
*@FileTitle  : India Cargo Release Order list Inquery
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @extends
 * @class esm_bkg_0131 : esm_bkg_0964 business script.
 */
/* Developer Work  */
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
     var sheetObject =sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
                break;
//            case "btn_DownExcelWeeklyReport":
            case "btn_DownExcelDoRlseList0":  
            	if(sheetObjects[0].GetCellValue(4, "monthly") == 0){ return;}
            	sheetObjects[0].Down2Excel({ HiddenColumn:1,SheetDesign:1, Merge:1,AutoSizeColumn:1});
            break;
            case "btn_DownExcelDoRlseList1":
            	sheetObjects[1].Down2Excel({ HiddenColumn:1,SheetDesign:1, Merge:1,AutoSizeColumn:1});
            break;
            case "btn_CargoRelease":
                fnMoveToFullCntrRelease(sheetObjects[1]);
            break;
            case "btn_evnt_dt":
//				formObject.rd_flag[0].checked=true;
//				fnSetUpUIByRdFlag();
                var cal=new ComCalendarFromTo();
                cal.select(formObject.evnt_dt_fm, formObject.evnt_dt_to, 'yyyy-MM-dd');
                break;
            case "btn_evnt_dt_ym":
				formObject.rd_flag[1].checked=true;
				fnSetUpUIByRdFlag();
                var cal=new ComCalendar();
                cal.setDisplayType('month');
                cal.select(formObject.evnt_dt_ym, 'yyyy-MM');
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
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source<br>
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
	var formObj=document.form;
	fnInSetComboBox(formObj.dmdt_pay_tp_cd, gDmdtCode, gDmdtValue, "|", "", "ALL", true, "");
	for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	 fnSetUpUIByRdFlag();
    initControl();
}
/**
 * Initialization handling.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function initControl() {
    axon_event.addListenerForm('click', 'objClick', form );
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    var formObj=document.form;
    form.evnt_ofc_cd.value=strOfcCd;
    
    ComBtnDisable("btn_DownExcelDoRlseList0");
    ComBtnDisable("btn_DownExcelDoRlseList1");
}
/**
 * form object click event handling.<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function objClick() {
    var objName=event.srcElement.name;
    var formObj=document.form;
    switch(objName) {
        case "rd_flag":
            fnSetUpUIByRdFlag();
            break;
        case "evnt_dt_fm":
        	formObj.rd_flag[0].checked=true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_to":
        	formObj.rd_flag[0].checked=true;
        	fnSetUpUIByRdFlag();
        	break;
        case "evnt_dt_ym":
        	formObj.rd_flag[1].checked=true;
        	fnSetUpUIByRdFlag();
        	break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[1]);
}

/**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 * @version 2009.10.01
 */

var leftHeaders= [{Text:"General|Extension|Examination", Align:"Left"}];
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetId=sheetObj.id;
    switch(sheetId) {
        case "sheet2":
            with (sheetObj) {
	            
	            var HeadTitle1="No.|Type|B/L No|Container No|POD|DEL|D/O No|Release Date|Release Office|Staff ID";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_pay_tp_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"do_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                   {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"evnt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	            SetSheetHeight(282);
	            SetEditable(0);
	            SetWaitImageVisible(0);
	            

        }
        break;
         case "sheet1":
            with (sheetObj) {
	        	 var HeadTitle1="|1ST Week|2ND Week|3Rd Week|4th Week|5th Week|Monthly";
	        	 var headCount=ComCountHeadTitle(HeadTitle1);
	
	        	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	        	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	 InitHeaders(headers, info);
	        	 InitHeadColumn(leftHeaders,sheetObj);
	        	 
	        	 var cols = [ {Type:"Text",      Hidden:0, Width:142,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_pay_tp_cd_desc" },
	        	              {Type:"AutoSum",      Hidden:0, Width:142,  Align:"Center",  ColMerge:1,   SaveName:"first_wk",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"AutoSum",      Hidden:0, Width:142,  Align:"Center",  ColMerge:1,   SaveName:"second_wk",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"AutoSum",      Hidden:0, Width:142,  Align:"Center",  ColMerge:1,   SaveName:"third_wk",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"AutoSum",      Hidden:0, Width:142,  Align:"Center",  ColMerge:1,   SaveName:"forth_wk",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"AutoSum",      Hidden:0, Width:142,  Align:"Center",  ColMerge:1,   SaveName:"fifth_wk",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	              {Type:"AutoSum",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"monthly",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        	  
	        	 InitColumns(cols);
	        	 SetSheetHeight(132);
	        	 SetCountPosition(0);
	        	 SetEditable(0);
	        	 SetWaitImageVisible(0);

        }
        break;
    }
}
/**
 * handling sheet process<br>
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
    switch(sAction) {
      case IBSEARCH:      //Retrieve
             if(!validateForm(sheetObj,formObj,sAction)) {return;}
             if(formObj.rd_flag[0].checked == true) {
             	if (!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value, formObj.evnt_dt_to.value, 1, "-")) {
             		// only less than {?msg1}-month periods allowed
             		ComShowCodeMessage("BKG40013", "1");
             		return;
             	}
             }
             formObj.f_cmd.value=SEARCH;
             ComOpenWait(true);
             var sXml=sheetObj.GetSearchData("ESM_BKG_0939GS.do" , FormQueryString(formObj),"page_no=1", false);
             var sXmlArr=sXml.split("|$$|");
             sheetObjects[0].LoadSearchData(sXmlArr[0],{Sync:1} );
             sheetObjects[1].LoadSearchData(sXmlArr[1],{Sync:1} );
             
             ComOpenWait(false);
             
             var sheet0Rlt = ComGetSelectSingleNode(sXmlArr[0], "TOTAL");
             var sheet1Rlt = ComGetSelectSingleNode(sXmlArr[1], "TOTAL");
             
             if(sheet0Rlt > 0) {
             	ComBtnEnable("btn_DownExcelDoRlseList0");
             }
             else {
            	 ComBtnDisable("btn_DownExcelDoRlseList0");
             }
             
             if(sheet1Rlt > 0) {
             	ComBtnEnable("btn_DownExcelDoRlseList1");
             }
             else {
            	 ComBtnDisable("btn_DownExcelDoRlseList1");
             }
          break;
    }
}


/**
 * handling process for input validation<br>
 */
function validateForm(sheetObj,formObj,sAction){
    if(!ComChkValid(formObj)) return false;
    return true;
}
/**
 * Search End Event Handling.<br>
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    var row=sheetObj.LastRow()+1;
    for(var col=1; col<=sheetObj.LastCol(); col++) {
        sheetObj.SetCellValue(row,col,sheetObj.ComputeSum("|" + col +"|"));
    }
    with (sheetObj) {
        if (RowCount()> 0) {
            ReDraw=false;
            SetCellText(LastRow(), "dmdt_pay_tp_cd_desc" ,"TOTAL");
            ReDraw=true;
        }else{
            InitHeadColumn(leftHeaders, sheetObj);
        }
    }
}

/**
 * change search creteria depending on the radio button radio.<br>
 */
function fnSetUpUIByRdFlag() {
    var formObj=document.form;
    with(formObj) {
        if(rd_flag[0].checked == true) { // F
            document.getElementsByName("evnt_dt_fm")[0].setAttribute("required", true);
            document.getElementsByName("evnt_dt_to")[0].setAttribute("required", true);
            document.getElementsByName("evnt_dt_ym")[0].removeAttribute("required");
        } else {
            document.getElementsByName("evnt_dt_fm")[0].removeAttribute("required");
            document.getElementsByName("evnt_dt_to")[0].removeAttribute("required");
            document.getElementsByName("evnt_dt_ym")[0].setAttribute("required", true);
        }
    }
}        
/**
 * Full Release Container screen move.<br>
 */
function fnMoveToFullCntrRelease(sheetObj) {
	var goUrl="/opuscntr/ESM_BKG_0680_POP.do?";
    var param="mainPage=false&pgmNo=ESM_BKG_0680";
    
    if(sheetObj.GetTotalRows() > 0) {
	    var sRowStr=sheetObj.GetSelectionRows("|");
	    var sRowArr=sRowStr.split("|");
	    
	    if(sRowArr.length > 1){
	        ComShowCodeMessage("BKG00362");
	        return;
	    }
	    var blNo="";
	    if (sRowStr != "0" ) {
	    	blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");
	    }
	    
	    if (blNo != "") {
	        param += "&bkg_no=" + blNo;
	    }
    }
//    location.href=goUrl + param;
	ComOpenWindowCenter(goUrl + param,"ESM_BKG_0680",1150,700,false);//팝업    
}
/* Developer Work End */
