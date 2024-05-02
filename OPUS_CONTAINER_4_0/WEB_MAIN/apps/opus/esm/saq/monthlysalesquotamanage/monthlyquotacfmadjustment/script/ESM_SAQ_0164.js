/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0164.js
*@FileTitle  : VVD Mapping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends
     * @class ESM_SAQ_0164 : business script for ESM_SAQ_0164
     */
var sheetObjects=new Array();
var comObjects=new Array();
var sheetCnt=0;
var comboCnt=0;
var saveFlag=0;
var saveCnt=0;
var saveStatus="Save";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /*******************************************************/
         var sheetObject=sheetObjects[1];
         var sheetObject1=sheetObjects[0];
         var formObject=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
                 case "btn_retrieve":
                     saveFlag=0;
                     formObject.change_type.value="M";
                     formObject.change_status.value="MON/WEEK Change";
                     formObject.change_mode[0].checked=true;
                     doActionIBSheet(sheetObject,formObject,IBSEARCH);
                     break;
                 case "btn_save":
                     saveCnt=0;
                     saveStatus="Save";
                     if(formObject.change_mode[0].checked) {
                         saveFlag=0;
                         formObject.change_type.value="M";
                         formObject.change_status.value="MON/WEEK Change";
                     }
                     if(formObject.change_mode[1].checked) {
                         saveFlag=6;
                         formObject.change_type.value="S";
                         formObject.change_status.value="Optional Change";
                     }
                     doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;
                 case "btn_downexcel":
                	 if(sheetObject1.RowCount() < 1){//no data
                			ComShowCodeMessage("COM132501");
                		}else{
                			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                		}
                     break;
                 case "change_mode" : //Change Mode Radio Button Click
                     changeMode();
                     break;
             } // end switch
         } catch(e) {
             if( e == "[object Error]") {
                 //ComShowMessage(OBJECT_ERROR);
            	 ComShowCodeMessage("COM12111");
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	optionSetting();
		var sheetResizeFull=true;
        for(i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
       	var formObj=document.form;
        formObj.bound.selectedIndex=1;
       	setRlseYearMonthObject(formObj.year, formObj.quarter);
       	changeButtonStatus();
       	setTrade();
       	changeVersion();
       	changeQtrWeek();
       	changeMode();
        formObj.lane.selectedIndex=0;
       	formObj.trade.selectedIndex=1;
       	changeRlane()
        if(isDevMode){
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
            case 1:     //sheet2 init
                with(sheetObj){
		              SetConfig( { SearchMode:0, MergeSheet:1, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

		              var HeadTitle1="Seq|Trade|Bound|SubTrade|Lane|Previous|Previous|Previous|Previous|Previous|Updated|Updated|Updated|Updated|VVD Copy|Applied VVD|Org|Org|Org|Org|Org|Group|Group|Group|||||||||||||||";
		              var HeadTitle2="Seq|Trade|Bound|SubTrade|Lane|Group|Month|Week|VVD|Supply|Month|Week|VVD|Supply|VVD Copy|Applied VVD|uarter|Week|VVD|Supply|Supply|Group|Group|MAX|BSE YR|Quarter|V|V|D|TGT YR|LLP|Ioc|VVD SEQ|Status|SEQ|Key||Match Flg";
		              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"p_group",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"p_bse_mon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"p_bse_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"p_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"p_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"u_bse_mon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"u_bse_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"u_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"u_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Popup",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_copy",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Popup",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"applied_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Int",       Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"v_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Int",       Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fnl_bsa_capa",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sprt_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bsa_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"grp_max",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tgt_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vvd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"status",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gseq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"key",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"week_key",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                           {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"match_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];

		              InitColumns(cols);
		              SetEditable(1);
		              SetWaitImageVisible(0);
//		              SetSheetHeight(493);
		              resizeSheet();
		              SetFocusEditMode(default_edit_mode);
		              SetImageList(0,ICO_FILTER);
		              SetCellImage(0, "rlane_cd",0);
		              SetCellImage(1, "p_fnl_bsa_capa",0);
//		              SetRangeBackColor(1, 5, 1, 37,"#777777"); //두번째 타이틀 색상변경
              }
               break;
            case 2:      //sheet1 init
                with(sheetObj){
		             var strGrp1="A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z";
		             var strGrp2="";
		             var HeadTitle="Trade|Bound|SubTrade|Lane|Group|Year|Month|Week|VVD|Supply| Supply ||Group|Group| Group | Group |Group|Group|Remarks|Disable|BSE YR|Quarter|V| V |D|LLP|ioc|VVD SEQ|Flg|Key|SEQ";
		             SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tgt_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"v_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fnl_bsa_capa",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"row_sel",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"e_sprt_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"e_bsa_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sprt_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bsa_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"b_sprt_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"b_bsa_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"key",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"week_key",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
                      for(var i=1 ; i <= 99 ; i++){
                    	  	strGrp2 += "|"+(i<10?"0":"")+i;
                      	}

		             InitColumns(cols);
		             SetEditable(1);
		             SetWaitImageVisible(0);
		             SetSheetHeight(400);
		             SetFocusEditMode(default_edit_mode);
		             SetColProperty("e_sprt_grp_cd", {ComboText:strGrp1, ComboCode:strGrp1} );
		             SetColProperty("e_bsa_grp_cd", {ComboText:strGrp2, ComboCode:strGrp2} );
             }


                break;
        }
    }
    
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0],50);
	}
	
    var searchCond="";
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	break;
                }
                ComOpenWait(true);
            	sheetObjects[0].ReDraw=false;
				formObj.f_cmd.value=SEARCHLIST;
                searchCond=saqFormString(formObj);
                var rtn=sheetObj.GetSearchData("ESM_SAQ_0164GS.do", searchCond);
                var xmls=rtn.split("+");
                sheetObjects[1].LoadSearchData(xmls[0],{Sync:1} );
                sheetObjects[0].LoadSearchData(xmls[1],{Sync:1} );
                var rowCount=sheetObjects[1].RowCount();
                var srow1=sheetObjects[1].HeaderRows();
                var erow1=rowCount + srow1;
                var row1=srow1;
                var srow2=sheetObjects[0].HeaderRows();
                var erow2=sheetObjects[0].RowCount()+ srow2;
                var row2=srow2;
                var oldLane="";
                var lane="";
                var bsaArr=null;
                var bsa_max=-1;
                var week1="";
                var week2="";
                var grayColor="#E1E1E1";
                var redColor="#FFC8C8";
        		var vvd1="";
        		var vvd2="";
    			var bsa1="";
    			var bsa2="";
    			var frow=0;
    			var isNew=false;
    			var laneMax=new Array();
                var btn_flg="Y";
    			diffenentCount=0;
                for(row1=srow1 ; row1 < erow1 ; row1++){
                	row2=sheetObjects[0].FindText("key", sheetObjects[1].GetCellValue(row1, "key"));
                	if(row2 > 0){
						sheetObjects[0].SetCellValue(row2, "p_group",sheetObjects[1].GetCellValue(row1, "group"),0);
						sheetObjects[0].SetCellValue(row2, "p_bse_mon",sheetObjects[1].GetCellValue(row1, "bse_mon"),0);
						sheetObjects[0].SetCellValue(row2, "p_bse_wk",sheetObjects[1].GetCellValue(row1, "bse_wk"),0);
						sheetObjects[0].SetCellValue(row2, "p_vvd",sheetObjects[1].GetCellValue(row1, "vvd"),0);
						sheetObjects[0].SetCellValue(row2, "p_fnl_bsa_capa",sheetObjects[1].GetCellValue(row1, "v_fnl_bsa_capa"),0);
						sheetObjects[0].SetCellValue(row2, "lst_lodg_port_etd_dt",sheetObjects[1].GetCellValue(row1, "lst_lodg_port_etd_dt"),0);
						sheetObjects[0].SetCellValue(row2, "key",sheetObjects[1].GetCellValue(row1, "key"),0);
						sheetObjects[0].SetCellValue(row2, "week_key",sheetObjects[1].GetCellValue(row1, "week_key"),0);
						sheetObjects[0].SetCellValue(row2, "gseq",sheetObjects[1].GetCellValue(row1, "seq"),0);
						sheetObjects[0].SetCellValue(row2, "status","R",0);
                	}else{
						row2=sheetObjects[0].DataInsert(-1);
						sheetObjects[0].SetCellValue(row2, "trd_cd",sheetObjects[1].GetCellValue(row1, "trd_cd"),0);
						sheetObjects[0].SetCellValue(row2, "dir_cd",sheetObjects[1].GetCellValue(row1, "dir_cd"),0);
						sheetObjects[0].SetCellValue(row2, "sub_trd_cd",sheetObjects[1].GetCellValue(row1, "sub_trd_cd"),0);
						sheetObjects[0].SetCellValue(row2, "rlane_cd",sheetObjects[1].GetCellValue(row1, "rlane_cd"),0);
						sheetObjects[0].SetCellValue(row2, "p_group",sheetObjects[1].GetCellValue(row1, "group"),0);
						sheetObjects[0].SetCellValue(row2, "p_bse_mon",sheetObjects[1].GetCellValue(row1, "bse_mon"),0);
						sheetObjects[0].SetCellValue(row2, "p_bse_wk",sheetObjects[1].GetCellValue(row1, "bse_wk"),0);
						sheetObjects[0].SetCellValue(row2, "p_vvd",sheetObjects[1].GetCellValue(row1, "vvd"),0);
						sheetObjects[0].SetCellValue(row2, "p_fnl_bsa_capa",sheetObjects[1].GetCellValue(row1, "v_fnl_bsa_capa"),0);
						sheetObjects[0].SetCellValue(row2, "lst_lodg_port_etd_dt",sheetObjects[1].GetCellValue(row1, "lst_lodg_port_etd_dt"),0);
						sheetObjects[0].SetCellValue(row2, "key",sheetObjects[1].GetCellValue(row1, "key"),0);
						sheetObjects[0].SetCellValue(row2, "week_key",sheetObjects[1].GetCellValue(row1, "week_key"),0);
						sheetObjects[0].SetCellValue(row2, "gseq",sheetObjects[1].GetCellValue(row1, "seq"),0);
						sheetObjects[0].SetCellValue(row2, "bse_yr",sheetObjects[1].GetCellValue(row1, "bse_yr"),0);
						sheetObjects[0].SetCellValue(row2, "bse_qtr_cd",sheetObjects[1].GetCellValue(row1, "bse_qtr_cd"),0);
						sheetObjects[0].SetCellValue(row2, "vsl_cd",sheetObjects[1].GetCellValue(row1, "vsl_cd"),0);
						sheetObjects[0].SetCellValue(row2, "skd_voy_no",sheetObjects[1].GetCellValue(row1, "skd_voy_no"),0);
						sheetObjects[0].SetCellValue(row2, "skd_dir_cd",sheetObjects[1].GetCellValue(row1, "skd_dir_cd"),0);
						sheetObjects[0].SetCellValue(row2, "status","D",0);
                	}
					checkDifference(row2, grayColor, redColor);
                }
                frow=0;
                while((frow=sheetObjects[0].FindText("status", "I", frow+1)) > 0){
                	checkDifference(frow, grayColor, redColor);
                }
                processMixStatus(sheetObjects[0],sheetObjects[1]);
//                sheetObjects[0].ColumnSort("trd_cd|dir_cd|sub_trd_cd|rlane_cd|week_key|lst_lodg_port_etd_dt","ASC","",true);
				row2=0;
				oldLane="";
                while((row2=sheetObjects[0].FindText("bsa_grp_cd", "00", row2 + 1)) > 0){
                	lane=sheetObjects[0].GetCellValue(row2, "rlane_cd");
                	var bsa=sheetObjects[0].GetCellValue(row2, "fnl_bsa_capa");
                	if(lane != oldLane){
                		bsaArr=new Array();
                		bsa_max=sheetObjects[0].GetCellValue(row2, "grp_max")*1;
                	}
                	var status=sheetObjects[0].GetCellValue(row2, "status");
                	if(status == "I" || status == "U"){
	                	if(bsaArr[bsa] == undefined){
	                		bsa_max += 1;
	                		bsaArr[bsa]=bsa_max;
	                	}
	                	var grp=(bsaArr[bsa]<10?"0":"") + bsaArr[bsa];
	                	sheetObjects[0].SetCellValue(row2, "bsa_grp_cd",grp);
                	}
                	oldLane=lane;
	            }
	            ////////////////////////////////////////////////////////
	            // reset group number
	            if(!isNew){
//	                log("isNew ")
    	            reGrouping();
	            }
	            ////////////////////////////////////////////////////////
               	sheetObjects[1].SetTopRow(0);
               	sheetObjects[0].SetTopRow(0);
               	sheetObjects[1].SetSelectRow(1);
               	sheetObjects[0].SetSelectRow(2);
                setMatch_flg(sheetObjects[0]);
            	sheetObjects[0].ReDraw=true;
            	// change status
	           	sheetSearchEnd(btn_flg);
	           	setMappingCode();
                break;
          	case IBSAVE:        //save
             	if(!validateForm(sheetObj, formObj, sAction)) {
             	    return false;
             	}
             	saveFlag++;
	            formObj.f_cmd.value=MULTI;
	            var formString = saqFormString(formObj);
	            sheetObj.DoAllSave("ESM_SAQ_0164GS.do",{ Param:formString, Sync:1 });
//	            sheet2_SaveEnd(sheetObj);
	            break;
            case IBDOWNEXCEL:        //excel download
            	selectDownExcelMethod(sheetObj);
                break;
        }
    }
    /**
     * Down Excel 팝업창 이후 값을 받아서 타입을 리턴함
     *
     * excelType
     * AY - 전체 데이터를 Format 적용해서 down 받는 경우
     * DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
     * AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
     * DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
     */
   	function callBackExcelMethod(excelType){
		var sheetObj = sheetObjects[0];
		DownExcel(sheetObj, excelType);
	}

    function sheet2_OnSaveEnd(sheetObj){
         if(sheetObj.GetEtcData("status") == "OK"){
             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         } else if(sheetObj.GetEtcData("status") == "Error"){
             saveStatus=sheetObj.GetEtcData("status");
         }
    }
    function setMappingCode(){
        sheetObj=sheetObjects[0];
        formObject=document.form;
        change_mode=formObject.change_mode;
        for(i=0; i<change_mode.length;i++){
            if(change_mode[i].checked) {
                code=change_mode[i].value;
                break;
            }
        }
        if(code == "B" && saveFlag == 1 && saveStatus == "Save"){
            formObject.change_type.value="V";
            formObject.change_status.value="VVD Change";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(code == "B" && saveFlag == 2 && saveStatus == "Save"){
            formObject.change_type.value="B";
            formObject.change_status.value="BSA Change";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(code == "B" && saveFlag == 3 && saveStatus == "Save"){
            formObject.change_type.value="D";
            formObject.change_status.value="Delete VVD";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(code == "B" && saveFlag == 4 && saveStatus == "Save"){
            formObject.change_type.value="N";
            formObject.change_status.value="VVD Add";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(code == "B" && saveFlag == 5 && saveStatus == "Save"){
            formObject.change_type.value="P";
            formObject.change_status.value="Quarterly Check";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(code == "S" && saveFlag == 6 && saveStatus == "Save"){
            formObject.change_type.value="S";
            formObject.change_status.value="Optional Change";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(code == "S" && saveFlag == 7 && saveStatus == "Save"){
            formObject.change_type.value="P";
            formObject.change_status.value="Quarterly Check";
            doActionIBSheet(sheetObj,formObject,IBSAVE);
        } else if(saveCnt == 0 && (saveFlag == 6 || saveFlag == 8) && saveStatus == "Save"){
            saveCnt++;
            formObject.change_mode[1].disabled=false;
            ComShowMessage(getMsg("SAQ99999", "Saved Successfully"));
        }
    }
    
	function setTrade() {
		var params="ofcCd=" + document.form.ofcCd.value;
		getSelectCodeList(document.form.trade, "SaqMonthlyQuotaTrd", params, true,  new Option('', ''));
	}
	function changeQtrWeek() {
		var formObj=document.form;
		var params="year=" + formObj.year.value +  "&quarter=" + formObj.quarter.value;
		getSelectCodeList(formObj.fmBseWk, "QtrWeek", params, true,  new Option('', ''));
		formObj.fmBseWk.selectedIndex=0;
		getSelectCodeList(formObj.toBseWk, "QtrWeek", params, true,  new Option('', ''));
		formObj.toBseWk.selectedIndex=0;
	}
    function processMixStatus(sheetObj1,sheetObj2){
	    var row1=0;
	    var week_row=0;
	    var week_key="";
	    var sts="";
	    while((row1=sheetObj1.FindText("status","D", row1 + 1)) > 0){
	    	week_key=sheetObj1.GetCellValue(row1,"week_key");
//	        log("week_key="+week_key)
            while((week_row=sheetObj1.FindText("week_key",week_key,week_row+1)) > 0 ){
            	sts=sheetObj1.GetCellValue(week_row,"status");
                if( sts == "I"){
                    copyDeleteToInsert(sheetObj1,week_row,row1);
                    sheetObj1.SetCellValue(week_row,"status","M",0);
                    sheetObj1.RowDelete(row1,false);
                    row1--;
                    break;
                }
//                log("week_row="+week_row+",sts="+sts);
            }
	    }
    }
    function copyDeleteToInsert(sheetObj1,row1,row2){
		sheetObj1.SetCellValue(row1, "p_group",sheetObj1.GetCellValue(row2, "p_group"),0);
		sheetObj1.SetCellValue(row1, "p_bse_mon",sheetObj1.GetCellValue(row2, "p_bse_mon"),0);
		sheetObj1.SetCellValue(row1, "p_bse_wk",sheetObj1.GetCellValue(row2, "p_bse_wk"),0);
		sheetObj1.SetCellValue(row1, "p_vvd",sheetObj1.GetCellValue(row2, "p_vvd"),0);
		sheetObj1.SetCellValue(row1, "p_fnl_bsa_capa",sheetObj1.GetCellValue(row2, "p_fnl_bsa_capa"),0);
		sheetObj1.SetCellValue(row1, "gseq",sheetObj1.GetCellValue(row2, "gseq"),0);
		sheetObj1.SetCellValue(row1, "vvd_seq",sheetObj1.GetCellValue(row2, "vvd_seq"),0);
    }
    function replaceParams( params,paramName,paramValue ){
        var idx1=params.indexOf(paramName+"=");
        var idx2=params.indexOf("&",idx1);
        if( idx2 < 0 ){
            idx2=params.length;
        }
        var v=paramName.length+1;
        var startStr=params.substring(0,idx1+v);
        var endStr=params.substring(idx2,params.length);
        var value=startStr + paramValue + endStr;
        return value;
    }
    function reGrouping(){
        var row2=0;
        while((row2=sheetObjects[0].FindText("grp_max", "00", row2 + 1)) > 0){
//            log("row2="+row2);
			var lane=sheetObjects[0].GetCellValue(row2, "rlane_cd");
			var bsa=sheetObjects[0].GetCellValue(row2, "fnl_bsa_capa");
			var gseq=sheetObjects[0].GetCellValue(row2, "gseq");
        	var oldLane;
        	if(lane != oldLane){
        		var bsaArr=new Array();
        		var bsa_max=sheetObjects[0].GetCellValue(row2, "grp_max")*1;
        	}
        	var status=sheetObjects[0].GetCellValue(row2, "status");
        	//if(status == "R"){
        	   	var r=sheetObjects[1].FindText("seq", gseq);
        	   	if( sheetObjects[1].GetCellValue(r, "sprt_grp_cd") == "A" ){
        	   		bsa=sheetObjects[1].GetCellValue(r, "fnl_bsa_capa");
                	if(bsaArr[bsa] == undefined){
                		bsa_max += 1;
                		bsaArr[bsa]=bsa_max;
                	}
                	var grp=(bsaArr[bsa]<10?"0":"") + bsaArr[bsa];
//                	log("r=========>"+r+",gseq="+gseq+",bsa="+bsa+",grp="+grp+",bsaArr[bsa]="+bsaArr[bsa]);
            	    sheetObjects[0].SetCellValue(row2, "bsa_grp_cd",grp);
                	sheetObjects[1].SetCellValue(r, "bsa_grp_cd",grp,0);
                	sheetObjects[1].SetCellValue(r, "e_bsa_grp_cd",grp,0);
                	sheetObjects[1].SetCellValue(r, "b_bsa_grp_cd",grp,0);
                	sheetObjects[1].SetCellValue(r, "group","A"+ grp,0);
            	}
        	//}
        	oldLane=lane;
        }
    }
    function copyInfoToGroup(row1, row2){
		sheetObjects[1].SetCellValue(row1, "trd_cd",sheetObjects[0].GetCellValue(row2, "trd_cd"),0);
		sheetObjects[1].SetCellValue(row1, "dir_cd",sheetObjects[0].GetCellValue(row2, "dir_cd"),0);
		sheetObjects[1].SetCellValue(row1, "sub_trd_cd",sheetObjects[0].GetCellValue(row2, "sub_trd_cd"),0);
		sheetObjects[1].SetCellValue(row1, "rlane_cd",sheetObjects[0].GetCellValue(row2, "rlane_cd"),0);
		sheetObjects[1].SetCellValue(row1, "group",sheetObjects[0].GetCellValue(row2, "sprt_grp_cd")+sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "tgt_yr",sheetObjects[0].GetCellValue(row2, "tgt_yr"),0);
		sheetObjects[1].SetCellValue(row1, "bse_mon",sheetObjects[0].GetCellValue(row2, "bse_mon"),0);
		sheetObjects[1].SetCellValue(row1, "bse_wk",sheetObjects[0].GetCellValue(row2, "bse_wk"),0);
		sheetObjects[1].SetCellValue(row1, "vvd",sheetObjects[0].GetCellValue(row2, "vvd"),0);
		sheetObjects[1].SetCellValue(row1, "v_fnl_bsa_capa",sheetObjects[0].GetCellValue(row2, "v_fnl_bsa_capa"),0);
		sheetObjects[1].SetCellValue(row1, "fnl_bsa_capa",sheetObjects[0].GetCellValue(row2, "fnl_bsa_capa"),0);
		sheetObjects[1].SetCellValue(row1, "e_sprt_grp_cd",sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "e_bsa_grp_cd",sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "sprt_grp_cd",sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "bsa_grp_cd",sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "b_sprt_grp_cd",sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "b_bsa_grp_cd",sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"),0);
		sheetObjects[1].SetCellValue(row1, "bse_yr",sheetObjects[0].GetCellValue(row2, "bse_yr"),0);
		sheetObjects[1].SetCellValue(row1, "bse_qtr_cd",sheetObjects[0].GetCellValue(row2, "bse_qtr_cd"),0);
		sheetObjects[1].SetCellValue(row1, "vsl_cd",sheetObjects[0].GetCellValue(row2, "vsl_cd"),0);
		sheetObjects[1].SetCellValue(row1, "skd_voy_no",sheetObjects[0].GetCellValue(row2, "skd_voy_no"),0);
		sheetObjects[1].SetCellValue(row1, "skd_dir_cd",sheetObjects[0].GetCellValue(row2, "skd_dir_cd"),0);
		sheetObjects[1].SetCellValue(row1, "lst_lodg_port_etd_dt",sheetObjects[0].GetCellValue(row2, "lst_lodg_port_etd_dt"),0);
		sheetObjects[1].SetCellValue(row1, "ioc_cd",sheetObjects[0].GetCellValue(row2, "ioc_cd"),0);
		sheetObjects[1].SetCellValue(row1, "vvd_seq",sheetObjects[0].GetCellValue(row2, "vvd_seq"),0);
		sheetObjects[1].SetCellValue(row1, "key",sheetObjects[0].GetCellValue(row2, "key"),0);
		sheetObjects[1].SetCellValue(row1, "week_key",sheetObjects[0].GetCellValue(row2, "week_key"),0);
    }
	var diffenentCount=0;
	function checkDifference(row, grayColor, redColor){
		var vvd1=sheetObjects[0].GetCellValue(row, "p_vvd");
		var vvd2=sheetObjects[0].GetCellValue(row, "vvd");
		if(vvd1 == vvd2){
			var bsa1=sheetObjects[0].GetCellValue(row, "p_fnl_bsa_capa");
			var bsa2=sheetObjects[0].GetCellValue(row, "v_fnl_bsa_capa");
			if(bsa1 != bsa2){
				sheetObjects[0].SetRangeBackColor(row, 5, row, 13,grayColor);
				sheetObjects[0].SetRangeBackColor(row, 13, row, 13,redColor);
				sheetObjects[0].SetCellValue(row, "u_bse_mon",sheetObjects[0].GetCellValue(row, "bse_mon"),0);
				sheetObjects[0].SetCellValue(row, "u_bse_wk",sheetObjects[0].GetCellValue(row, "bse_wk"),0);
				sheetObjects[0].SetCellValue(row, "u_vvd",sheetObjects[0].GetCellValue(row, "vvd"),0);
				sheetObjects[0].SetCellValue(row, "u_fnl_bsa_capa",sheetObjects[0].GetCellValue(row, "v_fnl_bsa_capa"),0);
				if(sheetObjects[0].GetCellValue(row, "status")=="R"){
        			sheetObjects[0].SetCellValue(row, "status","U",0);
        		}
        		diffenentCount += 1;
			}
		} else {
			sheetObjects[0].SetRangeBackColor(row, 5, row, 13,grayColor);
			sheetObjects[0].SetRangeBackColor(row, 12, row, 12,redColor);
			sheetObjects[0].SetCellValue(row, "u_bse_mon",sheetObjects[0].GetCellValue(row, "bse_mon"),0);
			sheetObjects[0].SetCellValue(row, "u_bse_wk",sheetObjects[0].GetCellValue(row, "bse_wk"),0);
			sheetObjects[0].SetCellValue(row, "u_vvd",sheetObjects[0].GetCellValue(row, "vvd"),0);
			sheetObjects[0].SetCellValue(row, "u_fnl_bsa_capa",sheetObjects[0].GetCellValue(row, "v_fnl_bsa_capa"),0);
			if(sheetObjects[0].GetCellValue(row, "status")=="R"){
    			sheetObjects[0].SetCellValue(row, "status","U",0);
    		}
    		diffenentCount += 1;
		}
	}
    function setMatch_flg(sheetObj) {
        var str="";
        var rowCnt=sheetObj.RowCount();
        for(var i=2; i < rowCnt+2; i++) {
        	str=sheetObj.GetCellValue(i, "status");
            if(str == "R")
                sheetObj.SetCellValue(i, "match_flg","Y",0);
            else if(str == "D")
                sheetObj.SetCellValue(i, "match_flg","D",0);
            else
                sheetObj.SetCellValue(i, "match_flg","N",0);
        }
        sheetObj.SetRangeBackColor(1, 0, rowCnt+1, 4,"#FFFFFF");
    }
    function sheet2_OnPopupClick(sheetObj, row, col) {
        var col_name=sheetObj.ColSaveName(col);
        if ( col_name == "vvd_copy" || col_name == "applied_vvd" ) {
            var formObj=document.form;
            var width=800;
            var height=650;
            var callback="setPopup_vvd";
            var params="mqtaRlseVerNo=" + getParam(searchCond,"mqtaRlseVerNo")
                        + "&year="       + getParam(searchCond,"year")
                        + "&quarter="    + getParam(searchCond,"quarter")
                        + "&trade="      + getParam(searchCond,"trade")
                        + "&bound="      + getParam(searchCond,"bound")
                        + "&rlane="      + formObj.lane.value;
                        //+ "&rlane="      + sheetObj.GetCellValue(row, "rlane_cd");          
            
            ComOpenPopup("/opuscntr/ESM_SAQ_0166.do?" + params, width, height, callback, "1,0", true);
    	}
    }
    function setPopup_vvd(rtn){
        var sheetObj=sheetObjects[0];
        var row=sheetObj.GetSelectRow();
        var col=sheetObj.GetSelectCol();
        sheetObj.SetCellValue(row, col,rtn[0][5]);
        if(col == 14) sheetObj.SetCellValue(row, 15,"");
        else sheetObj.SetCellValue(row, 14,"");
    }
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction){
			case IBSEARCH:
				if(formObj.trade.value == ""){
					ComShowMessage(getMsg("SAQ90126", "Trade"));
					formObj.trade.Focus();
					return false;
				}
				if(formObj.bound.value == ""){
					ComShowMessage(getMsg("SAQ90126", "Bound"));
					formObj.bound.Focus();
					return false;
				}
				if(formObj.mqtaRlseVerNo.value == ""){
					ComShowMessage(getMsg("SAQ90126", "Release Version"));
					return false;
				}
				if( (formObj.fmBseWk.value != '' && formObj.toBseWk.value != '') &&
						formObj.fmBseWk.value > formObj.toBseWk.value						){
					ComShowMessage(getMsg("SAQ90123", "From Week", "To Week"));
					return false;
				}
				break;
		}
		return true;
	}
	function openFilterPopup( sheetObj,button,shift,x,y,idx ){
	    with(sheetObj){
	        var row=MouseRow();
	        var col=MouseCol();
	        var popupWidth=200;
	        var popupHeight=200;
	        if( row < HeaderRows()&& row > -1 ){
	            var colName=ColSaveName(col);
	            var html=null;
	            var objName="";
	            if( colName == "rlane_cd"){
	                objName="LANE_"+idx;
	                popupWidth=300;
	            }else if(( idx==1 && colName == "p_fnl_bsa_capa" ) || (idx==2 && colName == "v_fnl_bsa_capa")){
	                objName="BSA_"+idx;
	            }
//	            log("x="+x+",y="+y)
                var divObj=document.getElementById("DIV__"+objName+"__DIV");
                var evtobj=window.event? window.event : e
                var tempX = event.clientX + document.body.scrollLeft;
                var tempY = event.clientY + document.body.scrollTop;
                
                openDynamicDragPopup(divObj,tempX,tempY,popupWidth,popupHeight,sheetObj);
	        }
	    } // end with
	}
	/**
	 * popup open in case of click the sheet header
	 */
	function sheet2_OnMouseDown(sheetObj,button,shift,x,y){
        openFilterPopup( sheetObj,button,shift,x,y,1 );
	}
    function sheetSearchEnd(sts){
    	 ComOpenWait(false);
        changeButtonStatus(sts);
        //Filter Pop-up Create Function call
		reloadLANEFilter();
		reloadBSAFilter();
    }
    function reloadDestoyFilter(){
        var obj=eval("BSA2_INPUT");
        if( obj.length  != undefined ){
            for(var i=0 ; i < obj.length ; i++){
                if( obj[i].checked == false ){
                    obj[i].checked=true;
                }
            }
        }else{
            if( obj.checked == false ){
                obj[i].checked=true;
            }
        }
        processPopupOK("BSA_2","BSA2_INPUT");
    }
    function reloadBSAFilter(){
        var data=getFilterBSAData(sheetObjects[0],"p_fnl_bsa_capa","ASC");
		initCheckListDragPopup(data, "BSA_1", "BSA1_INPUT", "BSA", "Select", "sheetName='sheet2' colName='p_fnl_bsa_capa' ", true);
    }
    function reloadLANEFilter(){
        var data=getFilterLANEData(sheetObjects[0]);
 		initCheckListDragPopup2(data, "LANE_1", "LANE1_INPUT", "Sub Trade", "Lane", "Select", "sheetName='sheet2' colName='rlane_cd' ", true);
    }
    function processPreCheck(sheetObj,row,colName){
        if( sheetObj == sheetObjects[0]){
            return true;
        }else if (sheetObj == sheetObjects[1]){
        	if( sheetObj.GetRowStatus(row)  == "D"){
                return false;
            }else{
                return true;
            }
        }
    }
    function getFilterBSAData(sheetObj,colName,order){
        var dataObj=processSortValue(sheetObj,colName,order);
        var data="";
        var arrData=dataObj.arrData;
        for(var i=0 ; i < arrData.length; i++){
            data += display_Money(""+arrData[i])+"|";
        }
        if( dataObj.hasNullData == true){
            data="|"+data;
        }
        return data;
    }
    function getFilterLANEData(sheetObj){
        var data="";
		var sRow=0;
		var rRow=0;
		var arr=new Array();
		arr[0]=sheetObj.GetCellValue(3,"sub_trd_cd");
		arr[arr[0]]=new Array();
		arr[arr[0]][0]=sheetObj.GetCellValue(3,"rlane_cd");
		var sName="";
		var rName="";
		for(i=2;i<sheetObj.RowCount();i++){
			sName=sheetObj.GetCellValue(i,"sub_trd_cd");
			rName=sheetObj.GetCellValue(i,"rlane_cd");
			if(arr[sRow]!=sName){
				rRow=0;
				sRow++;
				arr[sRow]=sName;
				arr[sName]=new Array();
				arr[sName][0]=rName;
			}
			if(arr[sName][rRow]!= rName){
				rRow++;
				arr[sName][rRow]=rName;
			}
		}
		for(i=0;i<arr.length;i++){
			if (i!=0){
				data += "&";
			}
			data += arr[i]+";";
			for(j=0;j<arr[arr[i]].length;j++){
				data += arr[arr[i]][j]+"|";
				rRow++;
			}
		}
        return data;
    }
    function processSortValue(sheetObj,colName,order){
        var end=sheetObj.LastRow();
        var vl="";
        var data="|";
        var len=0;
        var returnData=new Object();
        returnData.arrData=new Array();
        returnData.hasNullData=false;
        for(var i=sheetObj.HeaderRows(); i < end ; i++){
        	vl=sheetObj.GetCellValue(i,colName);
            if( processPreCheck(sheetObj,i,colName) == true && data.indexOf("|"+vl+"|") < 0 && vl != ""){
                data += vl +"|";
            }else if( vl == "" ){
                returnData.hasNullData=true;
            }
        }
        if( data.length > 1){
            data=data.substring(1,data.length-1);
            var arrData=data.split("|");
            returnData.arrData=processSortData(arrData,0,arrData.length-1);
        }
        return returnData;
    }
    function processSortData(arrData,left,right,txt){
        var pivot=parseInt(arrData[left]);
//        log(txt+"=START=pivot="+pivot+",left="+left+",right="+right);
//        log(txt+"=START=arrData="+arrData);
        var goLeft=left;
        var goRight=right+1;
        if( right < left ){
            return arrData;
        }
        while(goLeft <= goRight){
            do{
                goLeft++;
            } while( goLeft < arrData.length && parseInt(arrData[goLeft]) < pivot );
            do{
                goRight--;
            } while( goRight >= 0 && parseInt(arrData[goRight]) > pivot );
            if( goLeft < goRight ){
                var tmp=arrData[goLeft] ;
                arrData[goLeft]=arrData[goRight];
                arrData[goRight]=tmp;
//                log("swap1 : left="+goLeft+"("+tmp+"),right="+goRight +"("+arrData[goLeft]+") ");
            }
        }
        if( goRight < left || goRight > right ){
            return arrData;
        }
        var tmp=parseInt(arrData[goRight]) ; //pivot data
        arrData[goRight]=arrData[left];
        arrData[left]=tmp;
//        log("swap2 : left="+goLeft+"("+arrData[left]+"),right="+goRight+"("+tmp+")");
//        log(txt+"=END=arrData="+arrData);
//        log(txt+"=END=pivot="+pivot+",left="+left+",goRight="+goRight);
        arrData=processSortData(arrData,goRight+1,right,"RIGHT"); //retrieving only right side
        arrData=processSortData(arrData,left,goRight-1,"LEFT"); //retrieving only left side
        return arrData;
    }
    function disableAllButton() {
    	ComBtnDisable("btn_save");
    	ComBtnDisable("btn_downexcel");
    }
    function changeButtonStatus(sts){
        disableAllButton();
        if( sts == "Y" ){ // Save만 가능
        	ComBtnEnable("btn_save");
        	ComBtnEnable("btn_downexcel");
        }
    }
    function year_OnChange(obj){
		changeVersion();
		changeQtrWeek();
		changeModeStatus();
	}
	function quarter_OnChange(obj){
		changeVersion();
		changeQtrWeek();
		changeModeStatus();
	}
	function changeVersion() {
        var obj=document.form;
        if (obj.year.value == '' || obj.quarter.value == '') return;
		var params="year="     + obj.year.value
					+ "&quarter=" + obj.quarter.value;
		var rtn=getCodeList("SaqMonthlyQuotaRlseVersion", params);
		obj.mqtaRlseVerNo.value=rtn[1].substring(0,6);
	}
    function changeMode() {
        var formObj=document.form;
        var changeModeObj=formObj.change_mode;
        var changeStatus=formObj.change_status;
	    if(changeModeObj[0].checked) {
	        changeStatus.value="MON/WEEK Change";
	    } else {
	        changeStatus.value="Optional Change";
	    }
    }
    function changeModeStatus() {
        disableAllButton();
        var formObject=document.form;
        saveFlag=0;
        formObject.change_type.value="M";
        formObject.change_status.value="MON/WEEK Change";
        formObject.change_mode[0].checked=true;
        formObject.change_mode[1].disabled=true;
		changeRlane();
    }
    function changeRlane() {
        var formObj=document.form;
        var objRlane=formObj.lane;
		var params="&mqta_rlse_ver_no="     + document.form.mqtaRlseVerNo.value
                   + "&trd_cd=" + document.form.trade.value
                   + "&dir_cd=" + document.form.bound.value
                   + "&bse_qtr_cd=" + document.form.quarter.value
                   + "&bse_yr=" + document.form.year.value;
        getSelectCodeList(objRlane, "CoaSaqRlane", params, true, new Option('', ''));
    }
    function getParam(params, paramName){
        var idx1=params.indexOf(paramName+"=");
        if( idx1 < 0 ){
            return "";
        }
        var idx2=params.indexOf("&",idx1);
        if( idx2 < 0 ){
            idx2=params.length;
        }
        var v=paramName.length+1;
        var value=params.substring(idx1+v,idx2);
        return value;
	}
function processPopupOK(objName,inputObjName,html){
//	log("processPopupOK() call : objName=" + objName + " inputObjName=" + inputObjName);
    var divObj=eval(objName);
    var inputObj=eval(inputObjName);
    var inputObjects=new Array();
    var idx=objName.split("_")[1];
    if( idx == "1"){
        inputObjects[0]=parseCheckBoxStr(eval("LANE1_INPUT"),true,"  :true|");
        inputObjects[1]=parseCheckBoxStr(eval("BSA1_INPUT"),true,"  :true|");
    }else{
        inputObjects[0]=parseCheckBoxStr(eval("LANE2_INPUT"),true,"  :true|");
        inputObjects[1]=parseCheckBoxStr(eval("BSA2_INPUT"),true,"  :true|");
    }
    if( inputObj.length != undefined ){
        for(var i=0 ; i < inputObj.length ; i++){
            processHideRow(divObj,inputObj[i],inputObjects,idx);
        }
    }else{
        processHideRow(divObj,inputObj,inputObjects,idx);
    }
}
function parseCheckBoxStr(obj, isAll,option ){
    var str="";
    if( isAll == undefined){
        isAll=true;
    }
    if( option == undefined){
        option="";
    }
    if( obj.length  != undefined  ){
        for(var i=0 ; i < obj.length ; i++){
            if( isAll == false ){
                if( obj[i].checked ){
                    str += obj[i].value+":"+ obj[i].checked+ "|";
                }
            }else{
                str += obj[i].value+":"+ obj[i].checked+ "|";
            }
        }
    }else{
        if( isAll == false ){
            if( obj.checked ){
                str += obj.value+":"+ obj.checked+ "|";
            }
        }else{
            str += obj.value+":"+ obj.checked+ "|";
        }
    }
    str += option;
//    log("parseCheckBoxStr call : obj=" + obj.id + " return str=" + str);
    return str;
}
function processHideRow(divObj,inputObj,inputObjects,idx){
	// Loading 후 처음 Filter를 사용할때 oldValue를 인식하지 못하여 undefined가 나와서 이렬경우 True를 설정해 주었음
	if (inputObj.oldValue == undefined) inputObj.oldValue = true;
    if( (inputObj.checked && (inputObj.oldValue == "false"|| inputObj.oldValue == false)) 
     ||(!inputObj.checked && (inputObj.oldValue == "true" || inputObj.oldValue == true)) ){
        var sheetObj=document.getElementById(divObj.getAttribute('sheetName'));   //divObj.sheetName ==> divObj.getAttribute('sheetName')
        var colName=divObj.getAttribute('colName'); //colName ==> divObj.getAttribute('colName')
        var cols=new Array();
        var values=new Array();
        //show.
        if( inputObj.checked == true){
            cols[0]=colName;
            values[0]=inputObj.value;
            var filterCnt=processFilterSheet0164(sheetObjects[0],cols,values,inputObjects,true,idx);  //sheetObj ==> sheetObjects[0]
        //hide.
        }else if( inputObj.checked == false){
            cols[0]=colName;
            values[0]=inputObj.value;
            var filterCnt=processFilterSheet0164(sheetObjects[0],cols,values,inputObjects ,false,idx);  //sheetObj ==> sheetObjects[0]
        }
        inputObj.oldValue=inputObj.checked;
    }
}
function processFilterSheet0164(sheetObj,cols, oriValues,inputObjects, isDisplay ,idx){
//    log("processFilterSheet0164 : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
//    log("processFilterSheet0164 : cols.length=" + cols.length);
    var filterCnt=0;
//    sheetObj.ReDraw=false;
    var selRow=0;
    var flg ;
    
    var findId = 0;
    var findText = "";
    
    // 대상 Row를 찾는다.
    for(j=0; j<cols.length; j++){
   	 while(findId!= -1){
   		 findId = sheetObj.FindText(cols[j], oriValues[j], findId);
   		 if (findId >= 0){
   			 findText += findId + "|";
   			 findId++;
   		 }
   	 }
    }
    
    // 대상 Row를 일괄 False 시키거나 True 일 경우는 다른 필터를 참조하여 Hidden 여부를 결정한다.
    if(findText != "") {
   	 if (isDisplay == true) {
   		 var findText1 = "";
   		 var findText2 = "";
   		 var arrText   = findText.split("|");
   		 
   		 for(var k=0; k<arrText.length; k++){
   			 // 모든 필터가 True이면 활성화, 하나라도 False면 비활성화
   			 if( filterValidation(sheetObj, arrText[k], cols, inputObjects,idx) ){
   				 findText1 += arrText[k]+"|"; // 활성화
                } else {
               	 findText2 += arrText[k]+"|"; // 비활성화
                }
   		 }
   		 // 다른 필터가 모두 체크되어 있을 경우(활성화)
   		 if (findText1 != "") {
   			 sheetObj.SetRowHidden(findText1,!isDisplay);
   		 }
   		 // 다른 필터가 체크되지 않은 것이 있을 경우(비활성화)
   		 if (findText2 != "") {
   			 sheetObj.SetRowHidden(findText2, isDisplay);
   		 }
   		 
   	 } else {
   		 // 일괄 Hidden 시킴(비활성화)
   		 sheetObj.SetRowHidden(findText, !isDisplay);
   	 }
    }
    
//    for(var i=0 ; i <= sheetObj.LastRow(); i++){
//        flg=false;
//        for(var j=0 ; j < cols.length ; j++ ){
//            selRow=sheetObj.FindText(cols[j],oriValues[j],selRow);
//            //log("processFilterSheet0164 : sheetObj.FindText("+cols[j]+","+oriValues[j]+","+selRow+") =" + selRow);
//            if( selRow < 0 ){
//                break;
//            }
//        }
//        if( selRow >= 0 ){
//            i=selRow;
//            selRow++;
//            //log("processFilterSheet01642 : sheetObj.CellValue(i,cols[(j)])="+ sheetObj.CellValue(i,cols[(0)]) +",  oriValues[j] = "+ oriValues[0].replace(',',''));
//            for(var j=0 ; j < cols.length ; j++ ){
//                if(oriValues[j] != sheetObj.GetCellText(i,cols[(j)])  ){
//                    flg=true;
//                    break;
//                }
//            }
//            //log("processFilterSheet01643 : flg ="+ flg);
//            if(flg == false){
//                if( isDisplay == true){
//                    if( filterValidation(sheetObj,i,cols,inputObjects,idx) ){
//                        sheetObj.SetRowHidden(i,!isDisplay);
//                    }
//                }else{
//                   sheetObj.SetRowHidden(i,!isDisplay);
//                }
//            }
//        }else{
//            break;
//        }
//    }
//    sheetObj.ReDraw=true;
    return filterCnt;
}
/**
 * filter validation
 * @param sheetObj
 * @param row
 * @param cols
 * @param inputObjects
 * @param idx
 * @returns {Boolean}
 */
function filterValidation(sheetObj,row,cols,inputObjects,idx){
    var retValue=false;
    var bsa_capa="";
    if( idx == 1 ){
        bsa_capa="p_fnl_bsa_capa";
    }else{
        bsa_capa="v_fnl_bsa_capa";
    }
    if( cols[0] == "rlane_cd" ){
        if(  inputObjects[1].indexOf( (sheetObj.GetCellText(row,bsa_capa)+":true|")) >=0
            && processPreCheck(sheetObj,row,cols[0] ) == true
         ){
            retValue=true;
        }
    }else if( cols[0] == bsa_capa ){
        if( inputObjects[0].indexOf( (sheetObj.GetCellText(row,"rlane_cd")+":true|")) >=0
            && processPreCheck(sheetObj,row,cols[0] ) == true ) {
            retValue=true;
        }
    }
//    log("filterValidation] cols=" + cols + " retValue=" + retValue);
    return retValue;
}
/**
 * filter validation
 * @param sheetObj
 * @param row
 * @param edit
 * @returns {Boolean}
 */
function filterValidation2(sheetObj,row,edit){
    var retValue=false;
    var bsa_capa="";
    var inputObjects=new Array();
    if( sheetObj == sheetObjects[0] ){
        inputObjects[0]=parseCheckBoxStr(eval("LANE1_INPUT"), true,"  :true|");
        inputObjects[1]=parseCheckBoxStr(eval("BSA1_INPUT") , true,"  :true|");
        bsa_capa="p_fnl_bsa_capa";
    }else{
        inputObjects[0]=parseCheckBoxStr(eval("LANE2_INPUT"), true,"  :true|");
        inputObjects[1]=parseCheckBoxStr(eval("BSA2_INPUT") , true,"  :true|");
        bsa_capa="v_fnl_bsa_capa";
    }
    if( edit == false){
        if(  inputObjects[1].indexOf( (sheetObj.GetCellText(row,bsa_capa)+":true|")) >=0
            && inputObjects[0].indexOf( (sheetObj.GetCellText(row,"rlane_cd")+":true|")) >= 0 ){
            retValue=true;
        }
    }else{
        retValue=true;
    }
    if(retValue == false){
//log(sheetObj.GetCellValue(row,bsa_capa) +","+sheetObj.GetCellValue(row,"rlane_cd") )
    }
    //log("filterValidation2] cols=" + cols + " retValue = " + retValue);
    return retValue;
}
function optionSetting() {
	SaqSearchOptionYear("year");
	SaqSearchOptionQuarter("quarter");
	SaqSearchOptionBound("bound");
}
