/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0408.js
 *@FileTitle  : P/MIB Generate
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/03
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview business script for ESM_BKG-0408
 * @author CLT
 */
/**
 * @extends
 * @class ESM_BKG-0408 : ESM_BKG-0408 
 */
function esm_bkg_0408() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
/* Start of developer's work*/
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1SelRow=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		/*******************************************************/
		var formObject=document.form;
		if (tabObjects[0].selectedIndex == 0) {
			sheetObj=sheetObjects[0];
		}
		else if (tabObjects[0].selectedIndex == 1) {
			sheetObj=sheetObjects[1];
		}
    	try {
    		var srcName=ComGetEvent("name");
    		if (srcName == "" || srcName == undefined) return false;
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
                case "btn_Mi_History":
                	//ComOpenWindow2("ESM_BKG_0819.do?pgmNo=ESM_BKG_0819", "ESM_BKG_0819", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,window.clientWidth,window.clientHeight");
    				sUrl="ESM_BKG_0819.do?";
    				sParam="";
    				ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0819", 1000, 590, false);
                    break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    break;
				case "btn_DownExcel1":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
                    break;	
				case "btn_DownExcel2":
					doActionIBSheet(sheetObjects[2], document.form, COMMAND01);
                    break;
				case "btn_PMibAssign":
					doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
                    break;
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI02);
					break;
				case "btn_EntryTypeSetUp":
					//ComOpenWindow2("ESM_BKG_0540.do?pgmNo=ESM_BKG_0540", "ESM_BKG_0540", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,window.clientWidth,window.clientHeight");
    				sUrl="ESM_BKG_0540_POP.do?";
    				sParam="pgmNo=ESM_BKG_0540";
    				ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0540", 1000, 680, false);
					break;
				case "btn_Bl_Inquiry1":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND02);
                    break;	
				case "btn_Bl_Inquiry2":
					doActionIBSheet(sheetObjects[2], document.form, COMMAND02);
                    break;	
				case "btn_Cntr_Inquiry1":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND03);
                    break;	
				case "btn_Cntr_Inquiry2":
					doActionIBSheet(sheetObjects[2], document.form, COMMAND03);
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
		}
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
        
//        sheet1_OnLoadFinish(sheetObjects[0]);
        
        doActionIBSheet(sheetObjects[0], document.form, COMMAND20);
        document.form.vvd.focus();
    }
	/**
	 *  event after loading screen
	 * @param sheetObj
	 * @return
	 */
//    function sheet1_OnLoadFinish(sheetObj) {
//		var formObj=document.form;
//		// searching authority to modify hub
//   		doActionIBSheet(sheetObjects[0], formObj, COMMAND20);
//        document.form.vvd.focus();
//	 }

     /**
      * handling in case of inserting searching condition  
      */
     function obj_KeyUp() {
	     var formObject=document.form;
	     var srcName=ComGetEvent("name");
	     var srcMaxLength=ComGetEvent("maxlength");
	     var srcValue=ComGetEvent("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
     /**
      * Dynamic loading the event of  HTML Control in the page <br>
      * initializing IBSheet Object when this function is called from {@link #loadPage} <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 
      */
     function initControl() {
     	//** Date divider **/
     	DATE_SEPARATOR="-";
     	var formObject=document.form;
     	//Axon event 1. event catch
         //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- out of focus
         //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus in
         //axon_event.addListenerFormat('keypress',       'obj_KeyPress2',    formObject); //- keyboard
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//         axon_event.addListener('click', 'chkClick', 'form'); 
         //axon_event.addListener('change', 'chkClick', 'form');
         //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
     }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
				with(sheetObj){
					var HeadTitle1="|Sel.|Seq.|HUB|DEL|Customs|In-bond Type|P/MIB NO.|Total B/L|In-Bond B/L|Local Clearance|||";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="sheet1_";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0} );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibd_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibd_trsp_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"total_bl_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inbond_bl_cnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"local_bl_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lcl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(150);
					SetEditable(1);
					SetCountPosition(0);
		        }
                break;
            case 2:      //sheet2 init
				with(sheetObj){
            		var HeadTitle1 = "|Sel.|Seq.|B/L No.|DEL|L.USA|HUB|Entry\nType|In-bond\nType|P/MIB No.|TOTAL\nPackage|C|Customs|R/D\nTerm|R/D\nTerm|Consignee/Notify|Consignee/Notify|||||||||" ;
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
					 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"usa_lst_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hub_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_clr_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibd_trsp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibd_trsp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dspo_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lcl_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_tp_cd_chg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibd_trsp_tp_cd_chg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_usa",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_entry",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_tp",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_hub",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					     
					InitColumns(cols);
					SetSheetHeight(290);
					SetEditable(1);
					SetColProperty(prefix+"ibd_trsp_tp_cd", {ComboText:"61(IT)|62(T&E)|63(IE)", ComboCode:"61|62|63"} );
					SetColProperty(prefix+"cstms_clr_tp_cd", {ComboText:"P/MIB|Local", ComboCode:"I|L"} );
					SetCountPosition(0);
//					InitDataValid(0, prefix +"usa_lst_loc_cd", vtEngUpOther," ");
				}
                break;
            case 3:      //sheet3 init
				with(sheetObj){
					var HeadTitle1="|Sel.|Seq.|B/L No.|DEL|L.USA|HUB|Entry\nType|In-bond\nType|P/MIB No.|TOTAL\nPackage|C|Customs|R/D\nTerm|R/D\nTerm|Consignee/Notify|Consignee/Notify|||||||||" ;
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
					 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"usa_lst_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hub_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_clr_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibd_trsp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibd_trsp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dspo_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lcl_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_tp_cd_chg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibd_trsp_tp_cd_chg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_usa",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_entry",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_tp",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"old_hub",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(290);
					SetEditable(1);
					SetColProperty(prefix+"ibd_trsp_tp_cd", {ComboText:"61(IT)|62(T&E)|63(IE)", ComboCode:"61|62|63"} );
					SetColProperty(prefix+"cstms_clr_tp_cd", {ComboText:"P/MIB|Local", ComboCode:"I|L"} );
//					InitDataValid(0, prefix +"usa_lst_loc_cd", vtEngUpOther," ");
				}
                break;
            case 4:      //sheet4 init
				with(sheetObj){
					var HeadTitle1="||HUB|DEL|P/MIB NO.||";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="";
					SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hub",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"del",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pmib_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(100);
					SetEditable(1);
		        }
            break;
        }
    }
  // handling of Sheet 
    function doActionIBSheet(sheetObj,formObj,sAction,row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case COMMAND20:
	        	formObj.f_cmd.value=INIT;
	        	var sXml=sheetObj.GetSearchData("ESM_BKG_0408GS.do", FormQueryString(formObj));
				var hubModifyYn=ComGetEtcData(sXml, "hubModifyYn");
				var cstmsModifyYn = ComGetEtcData(sXml, "cstmsModifyYn");
				
				//alert("hubModifyYn : " + hubModifyYn);
				formObj.hubModifyYn.value=hubModifyYn;
				formObj.cstmsModifyYn.value = cstmsModifyYn;
				
				break;
	        case IBSEARCH:      
		  		if (validateForm(sheetObj, formObj, sAction))
		  		{
		  			formObj.f_cmd.value=SEARCH;	  			
		  			sheetObj.DoSearch("ESM_BKG_0408GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		  		}
		  		break;
	    	case SEARCH01:      // searching Double Click
	    		var sheetObject2=sheetObjects[1];
	    		formObj.f_cmd.value=SEARCH01;
	    		sheet1SelRow=row;
	    		formObj.h_vvd.value=sheetObj.GetCellValue(row, "sheet1_vvd");
	    		formObj.h_pod.value=sheetObj.GetCellValue(row, "sheet1_pod_cd");
	    		formObj.h_hub.value=sheetObj.GetCellValue(row, "sheet1_hub_loc_cd");
	    		formObj.h_del.value=sheetObj.GetCellValue(row, "sheet1_del_cd");
	    		formObj.h_cstms.value=sheetObj.GetCellValue(row, "sheet1_cstms_loc_cd");
	    		//sheetObjects[1].DoSearch("ESM_BKG_0408GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_"));
	    		var sXml=sheetObj.GetSearchData("ESM_BKG_0408GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if(arrXml.length > 0)
					sheetObjects[1].LoadSearchData(arrXml[0],{Sync:0} );
				if(arrXml.length > 1)
					sheetObjects[2].LoadSearchData(arrXml[1],{Sync:0} );
				var sheet2RowCnt=sheetObjects[1].RowCount();
				var sheet2RowCnt2=sheetObjects[2].RowCount();
				var hubModifyYn=formObj.hubModifyYn.value;
				var cstmsModifyYn = formObj.cstmsModifyYn.value;
				//alert("hubModifyYn : " + hubModifyYn);
				for(var i=1; i <= sheet2RowCnt; i++) { //  setting GetEditable()to hub field
					if(hubModifyYn == "Y") {
						sheetObjects[1].SetCellEditable(i, "hub_loc_cd",1);
					} else {
						sheetObjects[1].SetCellEditable(i, "hub_loc_cd",0);
					}
					
					if(cstmsModifyYn == "Y") {
						sheetObjects[1].SetCellEditable(i, "cstms_loc_cd", 1);
					} else {
						sheetObjects[1].SetCellEditable(i, "cstms_loc_cd", 0);
					}
					
				}
				for(var i=1; i <= sheet2RowCnt2; i++) { //  setting GetEditable()to hub field
					if(hubModifyYn == "Y") {
						sheetObjects[2].SetCellEditable(i, "hub_loc_cd",1);
					} else {
						sheetObjects[2].SetCellEditable(i, "hub_loc_cd",0);
					}
					
					if(cstmsModifyYn == "Y") {
						sheetObjects[2].SetCellEditable(i, "cstms_loc_cd", 1);
					} else {
						sheetObjects[2].SetCellEditable(i, "cstms_loc_cd", 0);
					}
					
					
				}
	    		break;
	    	case SEARCH02:      // PMIB NO Assign
		    	if (validateForm(sheetObj, formObj, sAction))
		  		{
		    		var sheetObject2=sheetObjects[1];	    		
		    		var sParam=ComGetSaveString(sheetObj) + "&f_cmd=" + SEARCH02+"&"+ComGetSaveString(sheetObjects[1]);
		    		//BKG00672 Are you sure to Assign?
		    		if (!ComShowCodeConfirm("BKG00672")) 
		    			return;
		    		var topSheetSelectedRow=sheetObj.GetSelectRow();
		    		var sXml=sheetObj.GetSearchData("ESM_BKG_0408GS.do", sParam);
					var s4=sheetObjects[3];
					s4.LoadSearchData(sXml,{Sync:1} );
					if(s4.RowCount()> 0){
						ComShowCodeMessage('BKG06022');
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						sheetObj.SetSelectRow(topSheetSelectedRow);
						doActionIBSheet(sheetObj, document.form, SEARCH01, topSheetSelectedRow);
					}
		  		}
	    		break;
	        case IBSAVE:        
	          	if(validateForm(sheetObj,formObj,sAction)){
		    		formObj.f_cmd.value=MULTI;
		    		//var sParam = ComGetSaveString(sheetObj) + 
		    		var sParam="&f_cmd=" + MULTI+"&"+ComGetSaveString(sheetObjects[1])+ "&" +ComGetSaveString(sheetObjects[2]);
	    			
		    		var sXml=sheetObj.GetSaveData("ESM_BKG_0408GS.do", sParam);
					//sheetObj.LoadSaveXml(sXml);
	    			var state=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	    			
	    			if(state == "S") {
						ComShowCodeMessage('BKG06022');
						doActionIBSheet(sheetObj, document.form, IBSEARCH);
						var topSheetSelectedRow=sheetObj.GetSelectRow();
						doActionIBSheet(sheetObj, document.form, SEARCH01, topSheetSelectedRow);
	    			} else {
	    				ComShowCodeMessage('BKG00167');
	    			}

	          	}
	            break;
	        case COMMAND01:        //EXCEL DOWN 1, 2
		      	if(validateForm(sheetObj,formObj,sAction)){
		      		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		      	}
		        break;
	        case MULTI02:      // Transmit.
		        if(validateForm(sheetObj,formObj,sAction)){
		    		formObj.f_cmd.value=MULTI02;
		    		var sParam="&f_cmd=" + MULTI02+"&"+ComGetSaveString(sheetObjects[0])+ "&" +ComGetSaveString(sheetObjects[1]);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true,true);
					var sXml=sheetObj.GetSaveData("ESM_BKG_0408GS.do", sParam);
		    		if (ComBkgErrMessage(sheetObj, sXml)) {
			    		var key=ComGetEtcData(sXml, "KEY");
						intervalId=setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		    		} else {
		    			ComOpenWait(false);
		    		}
		      	}
	        	break;
	        case COMMAND02:        //B/L Inquiry
		      	if(validateForm(sheetObj,formObj,sAction)){
		      		var selRow=sheetObj.GetSelectRow();
		      		var bl_no=sheetObj.GetCellValue(selRow, "bl_no");
		      		var param="bl_no="+bl_no; 
//		      		ComOpenWindowCenter("ESM_BKG_0034.do?pgmNo=ESM_BKG_0034-03&"+param, "ESM_BKG_0034", 1024, 660, true);
		      		ComOpenWindowCenter("ESM_BKG_0034_POP.do?pgmNo=ESM_BKG_0034-03&"+param, "ESM_BKG_0034", 1250, 700, false);
		      	}
	        	break;
	        case COMMAND03:        //CNTR Inquiry
		      	if(validateForm(sheetObj,formObj, COMMAND02)){
		      		var selRow=sheetObj.GetSelectRow();
		      		var bl_no=sheetObj.GetCellValue(selRow, "bl_no");
		      		var param="bl_no="+bl_no; 
//	        		ComOpenWindow2("ESM_BKG_0036.do?pgmNo=ESM_BKG_0036&"+param, "ESM_BKG_0036", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no,width=836,height=500");
//	        		ComOpenWindowCenter("ESM_BKG_0036.do?pgmNo=ESM_BKG_0036&"+param, "ESM_BKG_0036", 836, 540, true, 0)
	        		ComOpenWindowCenter("ESM_BKG_0036.do?pgmNo=ESM_BKG_0036&"+param, "ESM_BKG_0036", 850, 600);
		      	}
	        	break;
        }
    }
    /**
     *  searching result of BackEndJob .
     */
    function doActionValidationResult(sheetObj, sKey) {
    	var sXml=sheetObj.GetSearchData("ESM_BKG_0408GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    	// finishing in case of error
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// showing success message
    		ComShowCodeMessage('BKG00101');
    		doActionIBSheet(sheetObj, document.form, SEARCH01, sheet1SelRow);	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		// error
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// showing error message
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }
     /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * setting Tab 
     * setting item of Tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "In-Bond B/L" , "");
                    InsertItem( "Local Clearance" , "");
                }
             break;
         }
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
			case SEARCH02:
				var ibd_trsp_no="";
				var chked=0;
				var prefix="sheet1_";
				for(var i=1; i < sheetObj.RowCount()+1; i++){
					if(sheetObj.GetCellValue(i, prefix+"chk") == 1){
						ibd_trsp_no=sheetObj.GetCellValue(i, prefix+"ibd_trsp_no");
						if(ibd_trsp_no != ""){
							ComShowCodeMessage("BKG01110"); //P/MIB No. already exist.
							return false;
						}
						if(sheetObj.GetCellValue(i, prefix+"inbond_bl_cnt") == "" ||
						sheetObj.GetCellValue(i, prefix+"inbond_bl_cnt") == " "){
							ComShowCodeMessage("BKG01111"); //Only In-Bond B/L can be assigned.
							return false;
						}
						chked++;
					}
				}
				for(var i=1; i < sheetObjects[1].RowCount()+1; i++){
					if(sheetObjects[1].GetCellValue(i, "chk") == 1){
						ibd_trsp_no=sheetObjects[1].GetCellValue(i, "ibd_trsp_no");
						if(ibd_trsp_no != ""){
							ComShowCodeMessage("BKG01110"); //P/MIB No. already exist.
							return false;
						}
						if(sheetObjects[1].GetCellValue(i, "hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //there is no information about HUB City
							return false;
						}
						chked++;
					}
				}
				for(var i=1; i < sheetObjects[2].RowCount()+1; i++){
					if(sheetObjects[2].GetCellValue(i, "chk") == 1){
						ComShowCodeMessage("BKG01111"); //Only In-Bond B/L can be assigned.
						return false;
					}
				}
				if(chked == 0){
					ComShowCodeMessage("BKG00249"); //No Selected Row
					return false;
				}
				return true;
				break;	
			case IBSAVE:
				var ibd_trsp_no="";
				var chked=0;
				var prefix="";
				var localChangeCnt=0;
				for(var i=1; i < sheetObjects[1].RowCount()+1; i++){
					if(sheetObjects[1].GetRowStatus(i) == "U"){
						if(sheetObjects[1].GetCellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //there is no information about HUB City
							return false;
						}
						if(sheetObjects[1].GetCellValue(i, prefix+"ibd_trsp_tp_cd") == "62" ||
								sheetObjects[1].GetCellValue(i, prefix+"ibd_trsp_tp_cd") == "63")
						{
							if(sheetObjects[1].GetCellValue(i, prefix+"usa_lst_loc_cd") == ""){
								ComShowCodeMessage("BKG00229"); //Missing Last USA
								return false;
							}
						}
						if(sheetObjects[1].GetCellValue(i, "cstms_clr_tp_cd_chg") == "Y" &&
								sheetObjects[1].GetCellValue(i, "cstms_clr_tp_cd") == "L")
						{
							localChangeCnt++;
						}
						chked++;
					}
				}
				for(var i=1; i < sheetObjects[2].RowCount()+1; i++){
					if(sheetObjects[2].GetRowStatus(i) == "U"){
						if(sheetObjects[2].GetCellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //there is no information about HUB City
							return false;
						}
						if(sheetObjects[2].GetCellValue(i, prefix+"ibd_trsp_tp_cd") == "62" ||
								sheetObjects[2].GetCellValue(i, prefix+"ibd_trsp_tp_cd") == "63")
						{
							if(sheetObjects[2].GetCellValue(i, prefix+"usa_lst_loc_cd") == ""){
								ComShowCodeMessage("BKG00229"); //Missing Last USA
								return false;
							}
						}
						if(sheetObjects[2].GetCellValue(i, "cstms_clr_tp_cd_chg") == "Y" &&
								sheetObjects[2].GetCellValue(i, "cstms_clr_tp_cd") == "L")
						{
							if(! ComShowCodeConfirm("BKG01108")) return false;
						}
						chked++;
					}
				}
				if(localChangeCnt > 0){
					if(! ComShowCodeConfirm("BKG01108")) return false;
				}
				if (sheetObjects[1].IsDataModified()== false){
					if (sheetObjects[2].IsDataModified()== false){
						ComShowCodeMessage("BKG00233"); //there is no history to change					
						return false;
					}
				}
				return true;
				break;	
			case COMMAND01:
				if(sheetObj.RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				return true;
				break;	
			case MULTI02:
				var ibd_trsp_no="";
				var chked=0;
				var prefix="sheet1_";
				for(var i=1; i < sheetObj.RowCount()+1; i++){
					if(sheetObj.GetCellValue(i, prefix+"chk") == 1){
						if(sheetObjects[1].GetCellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //there is no information about HUB City
							return false;
						}
						chked++;
					}
				}
				prefix="";
				for(var i=1; i < sheetObjects[1].RowCount()+1; i++){
					if(sheetObjects[1].GetCellValue(i, prefix+"chk") == 1){
						if(sheetObjects[1].GetCellValue(i, prefix+"hub_loc_cd") == "" ){
							ComShowCodeMessage("BKG00228"); //there is no information about HUB City
							return false;
						}
						if(sheetObjects[1].GetCellValue(i, prefix+"ibd_trsp_tp_cd") == "62" ||
								sheetObjects[1].GetCellValue(i, prefix+"ibd_trsp_tp_cd") == "63")
						{
							if(sheetObjects[1].GetCellValue(i, prefix+"usa_lst_loc_cd") == ""){
								ComShowCodeMessage("BKG00229"); //Missing Last USA
								return false;
							}
						}
						// length check, if the result is not 2, then alert it.
						if(ComChkLen(sheetObjects[1].GetCellValue(i, prefix+"ibd_trsp_no"), 11) != 2){
							ComShowCodeMessage("BKG01068"); // Missing P/MIB Type
							return false;
						}
						chked++;
					}
				}
				var chked2=0;
				for(var i=1; i < sheetObjects[2].RowCount()+1; i++){
					if(sheetObjects[2].GetCellValue(i, prefix+"chk") == 1){
						chked2++;
					}
				}
				if(chked == 0 && chked2 > 0){
					ComShowCodeMessage("BKG06089"); //Can't transmit in case of local b/l.
					return false;
				}
				if(chked == 0){
					ComShowCodeMessage("BKG00149"); //please select B/L
					return false;
				}
				return true;
				break;		
			case COMMAND02:
				if(sheetObj.RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				return true;
				break;
        }
        return true;
    }
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			for (var i=1; i <= LastRow(); i ++)
			{
				if ("Y" == GetCellValue(i, "sheet1_lcl_flg"))
					SetCellFontColor(i, "sheet1_ibd_trsp_no","#FF0000");// font is red
				if(eval(GetCellValue(i, "sheet1_local_bl_cnt")) > 0)
					SetCellFontColor(i, "sheet1_local_bl_cnt","#FF0000");// font is red
			}
			
			if (sheetObj.RowCount()> 0) {
				sheetObj.SetSumText("sheet1_seq","TOTAL");
				sheetObj.SetCellAlign(sheetObj.LastRow(), "sheet1_seq","Center");
			}

			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
		}
	}
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj)
		{
			for (var i=1; i <= LastRow(); i ++)
			{
				if ("Y" == GetCellValue(i, "lcl_flg"))
					//CellFontColor(i, "ibd_trsp_no") = "#FF0000";		// font is red
					SetCellFontColor(i, "bl_no","#FF0000");// font is red
			}
		}
	}
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		with(sheetObj)
		{
			for (var i=1; i <= LastRow(); i ++)
			{
				if ("Y" == GetCellValue(i, "lcl_flg"))
					//CellFontColor(i, "ibd_trsp_no") = "#FF0000";		// font is red
					SetCellFontColor(i, "bl_no","#FF0000");// font is red
			}
		}
	}
	function sheet1_OnDblClick(SheetObj, Row, Col){
		doActionIBSheet(SheetObj,document.form, SEARCH01, Row);
	}
	/**
	 * setting data format and searching by enter key 
	 * @author .
	*/
	function obj_KeyPress2(){
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var srcName=ComGetEvent("name");
		var srcValue=ComGetEvent("value");
		switch(ComGetEvent("dataformat")) {
	   	case "ymd":
	   		ComKeyOnlyNumber(ComGetEvent());
	   		if (srcValue.length == 4) {
	   			ComGetEvent("value")=srcValue.substring(0,4) + "-"
	   		}
	   		if (srcValue.length == 7) {
	   			ComGetEvent("value")=srcValue.substring(0,7) + "-"
	   		}
	       	break;
	   	case "ymdhm":
	   		ComKeyOnlyNumber(ComGetEvent());
	   		if (srcValue.length == 4) {
	   			document.form.elements[srcName].value=srcValue.substring(0,4) + "-"
	   		}
	   		if (srcValue.length == 7) {
	   			document.form.elements[srcName].value=srcValue.substring(0,7) + "-"
	   		}
	   		if (srcValue.length == 10) {
	   			document.form.elements[srcName].value=srcValue.substring(0,10) + " "
	   		}
	   		if (srcValue.length == 13) {
	   			document.form.elements[srcName].value=srcValue.substring(0,13) + ":"
	   		}
	       	break;
	   	case "ym":
	   	case "yw":
	   	case "jumin":
	   	case "saupja":	//number + "-"
	   		ComKeyOnlyNumber(ComGetEvent(), "-"); break;
	   	case "hms":
	   	case "hm":		//number + ":"
	   		ComKeyOnlyNumber(ComGetEvent(), ":"); 
	       	if (srcValue.length == 2) {
	       		ComGetEvent("value")=srcValue.substring(0,2) + ":"
	   		}
	   		break;
	   	case "yy":		//number + "0"
	   		ComKeyOnlyNumber(ComGetEvent(), "0"); break;
	       case "int":		//number
	           ComKeyOnlyNumber(ComGetEvent());	break;
	       case "float":	//number+"."
	           ComKeyOnlyNumber(ComGetEvent(), "."); break;
	       case "eng":		//alphabet + number
	       	// alphabet upper case
	           ComKeyOnlyAlphabet('uppernum'); break;  
	       case "engup":	//alphabet upper case
	           ComKeyOnlyAlphabet('upper'); break;
	       case "engdn":	//alphabet lower case
	           ComKeyOnlyAlphabet('upper'); break;
	       case "engupspace": //alphabet upper case + Space
	           if(event.keyCode != 32) {
	           	ComKeyOnlyAlphabet('uppernum');
	           }
	       	break;
	       case "etc": // all character is valid, but alphabet is upper case
		        if(keyValue >= 97 && keyValue <= 122) {//alphabet lower case
	               event.keyCode=keyValue + 65 - 97;
	           }
	       	break;
	       default: 		//alphabet  + number
	       	ComKeyOnlyAlphabet('uppernum'); break;
	   }
	}
	var curRow=1;
	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var iCol=sheetObj.SaveNameCol("sheet1_chk");
		if(iCol == sheetObj.MouseCol()){
			if (Shift == "1" ) {
				for (var i=curRow; i<=sheetObj.MouseRow()-1; i++) {
					sheetObj.SetCellValue(i, "sheet1_chk","1",0);
				}
			}
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var iCol=sheetObj.SaveNameCol("sheet1_chk");
		if((sheetObj.MouseRow()== 0 && Col == iCol && Row == sheetObj.RowCount())
			||
		   (sheetObj.MouseRow()!= 0 && Col == iCol)	)
		{
			if(Value == 1){
				if(sheetObjects[1].RowCount()> 0)
					sheetObjects[1].CheckAll("chk",0,1);
				if(sheetObjects[2].RowCount()> 0)
					sheetObjects[2].CheckAll("chk",0,1);
			}
		}
	}
	var t1curRow=1;
	function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var iCol=sheetObj.SaveNameCol("chk");
		if(iCol == sheetObj.MouseCol()){
			if (Shift == "1") {
				for (var i=t1curRow; i<=sheetObj.MouseRow()-1; i++) {
					sheetObj.SetCellValue(i, "chk","1",0);
				}
			}
		}
	}
	function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
		var iCol=sheetObj.SaveNameCol("chk");
		if(iCol == Col){
			t1curRow=Row;
			/*
			if(Value == 0){
				if(sheetObjects[0].RowCount()> 0)
					sheetObjects[0].CheckAll("sheet1_chk",0,1);
			}
			*/
		}
	}
	var t2curRow=1;
	function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var iCol=sheetObj.SaveNameCol("chk");
		if(iCol == sheetObj.MouseCol()){
			if (Shift == "1") {
				for (var i=t2curRow; i<=sheetObj.MouseRow()-1; i++) {
					sheetObj.SetCellValue(i, "chk","1",0);
				}
			}
		}
	}
	function t2sheet1_OnClick(sheetObj, Row, Col, Value) {
		var iCol=sheetObj.SaveNameCol("chk");
		if(iCol == Col){
			t2curRow=Row;
			/*
			if(Value == 0){
				if(sheetObjects[0].RowCount()> 0)
					sheetObjects[0].CheckAll("sheet1_chk",0,1);
			}
			*/
		}
	}
	/**
	 * In-Bond B/L tab - sheet data changing event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		// Entry Type changing  Flag Setting
		var iCol=sheetObj.SaveNameCol("cstms_clr_tp_cd");
		if(Col == iCol){
			if(sheetObj.GetCellValue(Row, "cstms_clr_tp_cd_chg") == ""){
				sheetObj.SetCellValue(Row, "cstms_clr_tp_cd_chg","Y");
			}else{
				sheetObj.SetCellValue(Row, "cstms_clr_tp_cd_chg","");
			}
		}
		// In-bond Type changing Flag Setting
		iCol=sheetObj.SaveNameCol("ibd_trsp_tp_cd");
		if(Col == iCol){
			if(sheetObj.GetCellValue(Row, "ibd_trsp_tp_cd_chg") == ""){
				sheetObj.SetCellValue(Row, "ibd_trsp_tp_cd_chg","Y");
			}else{
				sheetObj.SetCellValue(Row, "ibd_trsp_tp_cd_chg","");
			}
		}
		iCol=sheetObj.SaveNameCol("chk");
		if((sheetObj.MouseRow()== 0 && Col == iCol && Row == sheetObj.RowCount())
			||
		   (sheetObj.MouseRow()!= 0 && Col == iCol)	)
		{
			if(Value == 1){
				if(sheetObjects[0].RowCount()> 0)
					sheetObjects[0].CheckAll("sheet1_chk",0,1);
			}
		}
	}
	/**
	 * Local Clearance tab - sheet data changing event
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
		// Entry Type changing Flag Setting
		var iCol=sheetObj.SaveNameCol("cstms_clr_tp_cd");
		if(Col == iCol){
			if(sheetObj.GetCellValue(Row, "cstms_clr_tp_cd_chg") == "")
				sheetObj.SetCellValue(Row, "cstms_clr_tp_cd_chg","Y");
			else
				sheetObj.SetCellValue(Row, "cstms_clr_tp_cd_chg","");
		}
		
		if(sheetObj.GetCellValue(Row, "cstms_clr_tp_cd") == "I"){
			sheetObj.SetCellValue(Row, "cstms_loc_cd", sheetObj.GetCellValue(Row, "hub_loc_cd"));
		}
		
		// In-bond Type changing Flag Setting
		iCol=sheetObj.SaveNameCol("ibd_trsp_tp_cd");
		if(Col == iCol){
			if(sheetObj.GetCellValue(Row, "ibd_trsp_tp_cd_chg") == ""){
				sheetObj.SetCellValue(Row, "ibd_trsp_tp_cd_chg","Y");
			}else{
				sheetObj.SetCellValue(Row, "ibd_trsp_tp_cd_chg","");
			}
		}
		iCol=sheetObj.SaveNameCol("chk");
		if((sheetObj.MouseRow()== 0 && Col == iCol && Row == sheetObj.RowCount())
			||
		   (sheetObj.MouseRow()!= 0 && Col == iCol)	)
		{
			if(Value == 1){
				if(sheetObjects[0].RowCount()> 0)
					sheetObjects[0].CheckAll("sheet1_chk",0,1);
			}
		}
	}
/* Start of developer's work*/
