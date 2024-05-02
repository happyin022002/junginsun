/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3501.js
*@FileTitle  : Tariff General Information Creation &amp; Amendment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_PRI_3501 : business script for ESM_PRI_3501  
     */
 /*   function ESM_PRI_3501() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initCombo=initCombo;
    	this.doActionIBSheet=doActionIBSheet;
    	this.validateForm=validateForm;
    }*/

	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var supressConfirm=false;
	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     */
	function processButtonClick(){
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch (srcName) {
				case "btn_new":
					ComOpenWait(true);
					doActionIBSheet(sheetObjects[0],formObject,IBCREATE);
					document.form.tariff_cd_text.focus();
					ComOpenWait(false);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
				case "btn_amend":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY01);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY02);
					break;
				case "btn_request":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY03);
					break;
				case "btn_approve":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY04);
					break;
				case "btn_cancel":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY06);
					break;
				case "btn_publish":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY05);
					break;
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
					break;
				case "btn_rowdelete1":
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
					break;
				case "btn_amend1":
					doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
					break;
				case "btn_amendcancel1":
					doActionIBSheet(sheetObjects[1],formObject,COMMAND03);
					break;
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[2],formObject,IBINSERT);
					break;
				case "btn_rowdelete2":
					doActionIBSheet(sheetObjects[2],formObject,IBDELETE);
					break;
				case "btn_amend2":
					doActionIBSheet(sheetObjects[2],formObject,COMMAND02);
					break;
				case "btn_amendcancel2":
					doActionIBSheet(sheetObjects[2],formObject,COMMAND03);
					break;
	            case "btns_calendar1": 
	            	var cal=new ComCalendar();                
	                cal.select(document.form.eff_dt, 'yyyy-MM-dd');
	                break; 
	            case "btns_calendar2": 
	            	var cal=new ComCalendar();                
	                cal.select(document.form.exp_dt, 'yyyy-MM-dd');
	                break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
     * registering IBMulti Combo Object as array <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */      
    function setComboObject(combo_obj){
	        comboObjects[comboCnt++]=combo_obj;
	    }
   /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        //initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initControl();
   	 	var formObj=document.form;
   	 	document.form.tariff_cd_text.focus();
        if (formObj.trf_no.value != "") {
           doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
           tariff_cd.value=formObj.trf_pfx_cd.value + "-" + formObj.trf_no.value;
           comboObjects[0].SetSelectText(tariff_cd.value);
           doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
       } else {
    	   doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
       }
        
	}
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":
				with(sheetObj){
					var HeadTitle="|TRF_PFX_CD|TRF_NO|TRF_NM|TRF_ORZ_NM|TRF_ORZ_TP_NM|AMDT_SEQ|TRF_BZC_STS_CD|TRF_BZC_STS_NM|EFF_DT|EXP_DT|PUB_DT|CRE_DT|UPD_DT|"
					  +"RQST_OFC_CD|CRE_USR_ID|APRO_OFC_CD|TRF_BZC_TP_CD|TRF_BZC_WGT|TRF_BZC_WGT_UT_CD|TRF_BZC_VOL_QTY|TRF_BZC_VOL_UT_CD|CURR_CD|"
					  +"PUB_CNTC_PSON_NM|PUB_OFC_ADDR|PUB_OFC_PHN_NO|PUB_OFC_CTY_NM|PUB_OFC_STE_CD|PUB_OFC_ZIP_CD|PUB_OFC_CNT_NM|PUB_OFC_FAX_NO|PRE_PUB_DT|TRF_INLND_FLG|ROUT_UPD_DT|APRO_USR_FLG";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_orz_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_orz_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_wgt_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_vol_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_cntc_pson_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_cty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_ste_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_zip_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pub_ofc_fax_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pre_pub_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rout_upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"apro_usr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetWaitImageVisible(0);
				}
              	break;
         	case "sheet2":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|TRF_PFX_CD|TRF_NO|AMDT_SEQ|ORG_DEST_TP_CD|TRF_BZC_ROUT_PNT_SEQ|TRF_BZC_ROUT_PNT_TP_CD|Origin|Origin Description|N1ST_CMNC_AMDT_SEQ|Source|UPD_DT";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_rout_pnt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, InputCaseSensitive: 1, AcceptKeys: "E" },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					//Assembly 테스트에서 시트 높이를 높게 해달라고 요청한 사항임.
					//자동 사이즈 조정을 하게 되면 화면에 맞게 사이즈가 줄어들어
					//시트가 작아짐.
					SetSheetHeight(200);
					SetEditable(1);
					SetImageList(0,"img/btns_search_off.gif");
					SetImageList(1,"img/btns_search.gif");
					SetWaitImageVisible(0);
					SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
					SetShowButtonImage(2);
				}
              	break;
         	case "sheet3":
				with(sheetObj){    
					var HeadTitle="|Sel.|Seq.|TRF_PFX_CD|TRF_NO|AMDT_SEQ|ORG_DEST_TP_CD|TRF_BZC_ROUT_PNT_SEQ|TRF_BZC_ROUT_PNT_TP_CD|Destination|Destination Description|N1ST_CMNC_AMDT_SEQ|Source|UPD_DT";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_rout_pnt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_rout_pnt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trf_bzc_rout_pnt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, InputCaseSensitive: 1, AcceptKeys: "E" },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cnt_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					//Assembly 테스트에서 시트 높이를 높게 해달라고 요청한 사항임.
					//자동 사이즈 조정을 하게 되면 화면에 맞게 사이즈가 줄어들어
					//시트가 작아짐.
					SetSheetHeight(200);
					SetEditable(1);
					SetImageList(0,"img/btns_search_off.gif");
					SetImageList(1,"img/btns_search.gif");
					SetWaitImageVisible(0);
					SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
					SetShowButtonImage(2);
				}
              	break;
     	}
	}
//	function resizeSheet(){ ComResizeSheet(sheetObjects[2], 32); ComResizeSheet(sheetObjects[1], 32); }
    /**
     * initializing Combo, Combo items  <br>
     */        
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {     
	    	case "tariff_cd":
	            with(comboObj) {
	                //UseEdit = true;
	                //BackColor = "cyan";
	                SetDropHeight(200);
	                SetMultiSelect(0);
	                SetMaxSelect(1);
	                SetUseAutoComplete(1);
	                SetMaxLength(8);
	                ValidChar(2,3);
	            }
	            break;
            case "apro_ofc_cd":
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(6);
                }
                break;
            case "trf_bzc_tp_cd":
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(2);
                }
                break; 
            case "trf_bzc_wgt_ut_cd":
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
//                    MaxLength = 6;
                }
                break; 
            case "trf_bzc_vol_ut_cd":
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
//                    MaxLength = 6;
                }
                break;
            case "curr_cd":
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                    ValidChar(2);
                }
                break;
        }
    }
    /**
     * handling Axon event<br>
     */ 	    
     function initControl() {
        //handling Axon event          
        //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    	axon_event.addListenerForm('change', 'obj_change', document.form);
        //axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);                      
        //axon_event.addListenerFormat ('blur', 'obj_OnBlur', document.form);
    	$("#eff_dt").on("blur",obj_change);
    	$("#exp_dt").on("blur",obj_change);
    	
     }
     /**
      * handling OnBeforeActivate events <br>
      */   
      function obj_activate() {
          var srcName=ComGetEvent("name");
          ComClearSeparator (event.srcElement);
      }
     /**
      * handling Onbeforedeactivate events <br>
      */   
     // function obj_deactivate() {
      function obj_change() {
          var formObj=document.form;
          var sheetObj=sheetObjects[0];   
          var eleName=ComGetEvent("name");
    	  if(chkIsNaH(eleName)){
    		  document.getElementById(eleName).value="";
      		  return false;
    	  }
          switch(eleName){
              case "trf_pfx_cd":    
                  break;
              case "trf_no":     
                  break;
              case "trf_nm":
                  break;          
              case "trf_orz_nm":
                  break;
              case "trf_orz_tp_nm":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;          
              case "amdt_seq":
                  break;      
              case "trf_bzc_sts_cd": 
                  break;
              case "cre_dt":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "eff_dt":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;              
              case "exp_dt":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;
              case "pub_dt":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "rqst_ofc_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;              
              case "cre_usr_id":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "apro_ofc_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "trf_bzc_tp_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "trf_bzc_wgt":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;              
              case "trf_bzc_wgt_ut_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "trf_bzc_vol_qty":
            	  if(ComChkObjValid(event.srcElement))
            		  com_change_sheet( sheetObj, eleName );
                  break;
              case "trf_bzc_vol_ut_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;              
              case "curr_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_cntc_pson_nm":
          		  ComChkObjValid(event.srcElement)
          		  com_change_sheet( sheetObj, eleName );
                  break;
              case "pub_ofc_addr":
          		  com_change_sheet( sheetObj, eleName );
          		  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_phn_no":
              	//number check
              	if(chkIsNaN(eleName, "-")){
              		formObj.pub_ofc_phn_no.value="";
              		formObj.pub_ofc_phn_no.focus();
              		return false;
              	}else{
            	  com_change_sheet( sheetObj, eleName );
              	}
                  break;              
              case "pub_ofc_cty_nm":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_ste_cd":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_zip_cd":
          		  com_change_sheet( sheetObj, eleName );
//                  ComChkObjValid(event.srcElement);
                  break;              
              case "pub_ofc_cnt_nm":
            	  com_change_sheet( sheetObj, eleName );
                  ComChkObjValid(event.srcElement);
                  break;
              case "pub_ofc_fax_no":
              	//number check
              	if(chkIsNaN(eleName, "-")){
              		formObj.pub_ofc_fax_no.value="";
              		formObj.pub_ofc_fax_no.focus();
              		return false;
              	}else{
            	  com_change_sheet( sheetObj, eleName );
              	}
//                  ComChkObjValid(event.srcElement);
                  break;
              default:
                  ComChkObjValid(event.srcElement);       
          }
      }
      /**
       * handling OnKeyPress events <br>
       */     
     function obj_keypress() {
         switch (event.srcElement.dataformat) {
         	case "float":
         		ComKeyOnlyNumber(event.srcElement, ".");
         		break;
         	case "eng":
         		ComKeyOnlyAlphabet("upper");
         		break;
         	case "num"://only zip code
         		ComKeyOnlyAlphabet("num");
                break;
         	case "ymd":
         		ComKeyOnlyNumber(event.srcElement, "-");
         		break;
         	case "tel":
         		ComKeyOnlyNumber(event.srcElement, "-");
         		break;
         	default:
         }
     }
  /**
   * Handling sheet process <br>
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {
	 			case IBSEARCH: // retrieve
	 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
	 					return false;
	                }
	  				ComOpenWait(true); //->waiting->start
		 			formObj.f_cmd.value=SEARCH01;
		 			var param="f_cmd="       +formObj.f_cmd.value
		 					  + "&trf_pfx_cd=" +formObj.trf_pfx_cd.value
		 					  + "&trf_no="     +formObj.trf_no.value;
		 			
		 			var sXml=sheetObj.GetSearchData("ESM_PRI_3501GS.do", param);
	  				var arrXml=sXml.split("|$$|");
	  				if (arrXml.length > 0) {
	  					sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
	  					if(formObj.trf_bzc_sts_cd.value == "") formObj.trf_bzc_sts_cd.value="Initial";
	  					if (arrXml.length > 1){
                        	sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	  					}
	  					if (arrXml.length > 2){
                        	sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
	  					}
	  				}
	  				
	  				ComOpenWait(false); //->waiting->End
	  		  		
	  				formControl(sheetObj, formObj);
	  				
	  		 		if(formObj.trf_pfx_cd.value == "") buttonControl(""); 
	  		 		else buttonControl(sheetObj.GetCellValue(1,"trf_bzc_sts_cd"));
	  				
	  				
	 				break;
	            case IBSEARCH_ASYNC01: 
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }
	    	        comboObjects[0].RemoveAll();
	    	        comboObjects[1].RemoveAll();
	    	        comboObjects[2].RemoveAll();
	    	        comboObjects[3].RemoveAll();
	    	        comboObjects[4].RemoveAll();
	    	        comboObjects[5].RemoveAll();
	    	        //Tariff No
	    	        ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
	    	        //Approval Office
	    	        ComPriTextCode2ComboItem(aproOfcCdComboValue, aproOfcCdComboText, getComboObject(comboObjects, 'apro_ofc_cd') ,"|","\t" );
	    			//Tariff Type
	    	        ComPriTextCode2ComboItem(trfBzcTpCdComboValue, trfBzcTpCdComboText, getComboObject(comboObjects, 'trf_bzc_tp_cd') ,"|","\t" );
	    	        //Weight Ton Unit
	    	        ComPriTextCode2ComboItem(trfBzcWgtUtCdComboValue, trfBzcWgtUtCdComboText, getComboObject(comboObjects, 'trf_bzc_wgt_ut_cd') ,"|","\t" );    	        
	    	        //Volume Ton Unit
	    	        ComPriTextCode2ComboItem(trfBzcVolUtCdComboValue, trfBzcVolUtCdComboText, getComboObject(comboObjects, 'trf_bzc_vol_ut_cd') ,"|","\t" );
	    	        //Currency
	    	        ComPriTextCode2ComboItem(currCdComboValue, currCdComboText, getComboObject(comboObjects, 'curr_cd') ,"|","\t" );
	                break;
	 			case IBCREATE: // New
	                if (!validateForm(sheetObjects[0],document.form,sAction)) {
	                    return false;
	                }
	                ComOpenWait(true); //->waiting->start
	                clearAllForms();
	                sheetObjects[0].RemoveAll();
	                sheetObjects[1].RemoveAll();
	                sheetObjects[2].RemoveAll();
	                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	                sheetObjects[0].DataInsert();
	                var sheetObj=sheetObjects[0];
//	                var formObj = document.form;
//	                sheetObj.CellValue2(1,"amdt_seq")= "0";
	                sheetObj.SetCellValue(1,"trf_bzc_sts_cd","I",0);
	                sheetObj.SetCellValue(1,"rqst_ofc_cd",formObj.strofc_cd.value,0);
	                sheetObj.SetCellValue(1,"cre_usr_id",formObj.strusr_id.value,0);
	                sheet1_OnSearchEnd(sheetObj);
	  		 		if(formObj.trf_pfx_cd.value == "") buttonControl(""); 
	  		 		else buttonControl(sheetObj.GetCellValue(1,"trf_bzc_sts_cd"));
	  		 		ComOpenWait(false); //->waiting->End
	                formDisableControl();
                    formObj.tariff_cd.focus();
					break;
				case IBSAVE: // Save
					if (!validateForm(sheetObjects[0],document.form,sAction)) {
					    return false;
					}
					if (!supressConfirm && !ComPriConfirmSave()) {
					    return false;
					}
					ComOpenWait(true); //->waiting->start
					formObj.f_cmd.value=MULTI01;
					var sParam="";
					if(formObj.hid_amdt_seq.value == ""){
						sheetObjects[0].SetRowStatus(1,"I");
					}
					var sParamSheet1=sheetObjects[0].GetSaveString(true);
					if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
					    return;
					}                
					if (sParamSheet1 != "") {         	
						sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
					var sParamSheet2=sheetObjects[1].GetSaveString(true);
					if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
					    return;
					}                
					if (sParamSheet2 != "") {
					    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					var sParamSheet3=sheetObjects[2].GetSaveString(true);
					if (sheetObjects[2].IsDataModified()&& sParamSheet3 == "") {
					    return;
					}                
					if (sParamSheet3 != "") {
					    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
					}
					sParam += "&f_cmd=" + formObj.f_cmd.value;
					var sXml=sheetObjects[0].GetSaveData("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml); 
					sheetObjects[1].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml);
					sheetObjects[2].LoadSaveData(sXml);
			        if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" ){
			        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			        	ComOpenWait(false); //->waiting->End
						return true;
			        }else{
			        	ComOpenWait(false); //->waiting->End
						return false;
			        }
					break;
				case MODIFY01: // Amend
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var param = "?trf_pfx_cd="+formObj.trf_pfx_cd.value + "&trf_no="     +formObj.trf_no.value;
					var sUrl="ESM_PRI_3518_POP.do" + param;
					ComOpenPopup(sUrl, 650, 240, 'callback3518','1,0,1,1,1,1,1,1', true);
					
					break;
				case MODIFY02: // Delete
					if (!validateForm(sheetObjects[0],document.form,sAction)) {
					    return false;
					}
					//save checking message
					if (!ComPriConfirmDelete()) {
					    return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY02;
					var sParam="f_cmd="       +formObj.f_cmd.value
					           + "&trf_pfx_cd=" +formObj.trf_pfx_cd.value
 					           + "&trf_no="     +formObj.trf_no.value
 					           + "&amdt_seq="   +formObj.amdt_seq.value;
					var sXml=sheetObj.GetSaveData("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" ){
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        }
					ComOpenWait(false);
					break;
				case MODIFY03: // Request
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
		 				if (ComShowCodeConfirm("PRI00006")) {
		 					supressConfirm=true;
							var rslt=doActionIBSheet(sheetObj,document.form,IBSAVE);
							supressConfirm=false;
						}
		   				if (!rslt) {
		   					return false;
		   				}
					}
					if (!ComShowCodeConfirm("PRI06001")) {
						return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY03;
					sheetObjects[0].SetCellValue(1,"trf_bzc_sts_cd","Q",0);
					var sParamSheet1=sheetObjects[0].GetSaveString(true);
					var sParam=sParamSheet1 + "&f_cmd=" + formObj.f_cmd.value;
					var sXml=sheetObj.GetSaveData("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" )
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        else sheetObjects[0].SetRowStatus(1,"R");
					ComOpenWait(false);
					break;
				case MODIFY04: // Approve
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!ComShowCodeConfirm("PRI06002")) {
						return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY04;
					sheetObjects[0].SetCellValue(1,"trf_bzc_sts_cd","A",0);
					var sParamSheet1=sheetObjects[0].GetSaveString(true);
					var sParam=sParamSheet1 + "&f_cmd=" + formObj.f_cmd.value;
					var sXml=sheetObj.GetSaveData("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" )
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        else sheetObjects[0].SetRowStatus(1,"R");
					ComOpenWait(false);
					break;
				case MODIFY05: // Publish
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					var sUrl="/opuscntr/ESM_PRI_3505.do";
					ComOpenPopup(sUrl,  600, 290, 'callback3505','1,0', true);
					break;
				case MODIFY06: // Cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!ComShowCodeConfirm("PRI00015")) {
						return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY06;
					if(sheetObjects[0].GetCellValue(1,"trf_bzc_sts_cd")=="Q"){
						sheetObjects[0].SetCellValue(1,"trf_bzc_sts_cd","I");
					}else if(sheetObjects[0].GetCellValue(1,"trf_bzc_sts_cd")=="A"){
						sheetObjects[0].SetCellValue(1,"trf_bzc_sts_cd","Q");
					}
					else if(sheetObjects[0].GetCellValue(1,"trf_bzc_sts_cd")=="I"){
						sheetObjects[0].SetCellValue(1,"trf_bzc_sts_cd","F");
					}
					var sParamSheet1=sheetObjects[0].GetSaveString(true);
					var sParam=sParamSheet1 + "&f_cmd=" + formObj.f_cmd.value;
					var sXml=sheetObj.GetSaveData("ESM_PRI_3501GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" )
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        else sheetObjects[0].SetRowStatus(1,"R");
			        ComOpenWait(false);
					break;
	 			case IBINSERT: // Row Add
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				var amdt_seq=formObj.amdt_seq.value;
	 				var idx=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value,0);
					sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value,0);
					sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
					if(sheetObj==sheetObjects[1]) sheetObj.SetCellValue(idx, "org_dest_tp_cd","O",0);
					if(sheetObj==sheetObjects[2]) sheetObj.SetCellValue(idx, "org_dest_tp_cd","D",0);
					sheetObj.SetCellValue(idx, "trf_bzc_rout_pnt_tp_cd","C",0);
					sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
					sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
					if(amdt_seq != 0) sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
					buttonControlBottom();
					sheetObj.SelectCell(idx, "trf_bzc_rout_pnt_def_cd");
	 				break;
	 			case IBDELETE: // Delete
	 				var amdt_seq=formObj.amdt_seq.value;
					var sel_row=sheetObj.GetSelectRow();
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length==0) sheetObj.SetCellValue(sel_row, "chk","1",0);
					chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					for(i=0 ; i<chkArr.length ; i++){
						if(amdt_seq == sheetObj.GetCellValue(chkArr[i], "amdt_seq") && amdt_seq == sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")
								&& (sheetObj.GetCellValue(chkArr[i], "src_info_cd") == "AM" || sheetObj.GetCellValue(chkArr[i], "src_info_cd") == "AD")){
							ComShowCodeMessage("PRI01002");//Please check valid row
							return false;
						}
					}
					var tRow=0;
					for(i=0 ; i<chkArr.length ; i++){
						if(sheetObj.GetCellValue(parseInt(chkArr[i])+tRow, "n1st_cmnc_amdt_seq")!= amdt_seq){
							setSheetAmendRow(sheetObj,formObj,parseInt(chkArr[i])+tRow,"AD");
							tRow++;
						}
					}
					deleteRowCheck(sheetObj, "chk");
					//under button control
					//buttonControlBottom();
					//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case COMMAND02: // Amend
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length > 0){
						if(chkArr.length > 1) ComShowCodeMessage("PRI00310");
						else setSheetAmendRow(sheetObj,formObj,chkArr[0],"AM");
					} else setSheetAmendRow(sheetObj,formObj,"","AM");
					//under button control
					buttonControlBottom();
					sheetObj.SelectCell(sheetObj.GetSelectRow(), "trf_bzc_rout_pnt_def_cd");
					break;
				case COMMAND03: // Amend Cancel
					var sel_row=sheetObj.GetSelectRow();
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length > 0){
						if(chkArr.length > 1) ComShowCodeMessage("PRI00310");
						else setSheetAmendRow(sheetObj,formObj,chkArr[0],"");
					} else setSheetAmendRow(sheetObj,formObj,"","");
	 				sheetObj.SelectCell(sel_row-1, "trf_bzc_rout_pnt_def_cd");
	 				//under button control
					buttonControlBottom();
					break;
	 		}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e.message);
 			}
 		}finally {
 			 ComOpenWait(false);
 		}
 	}
 	
 	function callback3505(rtnVal){
 		if(rtnVal) {
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		}
 	}
     /**
     * checking validation process of inputed form data <br>
     */
 	function validateForm(sheetObj, formObj, sAction) {
 		switch (sAction) {
 		case IBSEARCH: // retrieve
			if (ComIsEmpty(comboObjects[0].GetSelectText())) {
				ComPriInputValueFailed("select","Tariff Code",comboObjects[0]);
				document.form.tariff_cd_text.focus();
				return false;
			}
			break;
        case IBCREATE: // New
            if(sheetObjects[0].IsDataModified()||sheetObjects[1].IsDataModified()||sheetObjects[2].IsDataModified()){
                return ComPriClearChange;
            }
            break;
  		case IBINSERT: // Row Add
	  		if(formObj.tariff_cd.value == "" || formObj.amdt_seq.value == "") {
				return false;
			}
  			break;
  		case IBDELETE: // Delete  	
  			if(formObj.tariff_cd.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			}
  			break;
        case IBSAVE: // Save
            var formObj=document.form;
//	        if(!ComChkValid(document.form)){
//	        	return false;
//	        }
            //checking combo mandatory 
            if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                ComShowCodeMessage('PRI00316','Tariff Code'); 
                comboObjects[0].focus();
                return false;
            }
            if (formObj.eff_dt.value == ""){
            	ComShowCodeMessage('PRI00316','Effective Date'); 
            	formObj.eff_dt.focus();
                return false;
            }
            if (!ComChkObjValid(formObj.eff_dt)){ 
            	formObj.eff_dt.focus();
                return false;
            }
            if (ComIsEmpty(comboObjects[1].GetSelectText())) {
                ComShowCodeMessage('PRI00316','Approval Office');   
                comboObjects[1].Focus();
                return false;
            }
            if (ComIsEmpty(comboObjects[2].GetSelectText())) {
                ComShowCodeMessage('PRI00316','Tariff Type');   
                comboObjects[2].Focus();
                return false;
            }
        	if (formObj.trf_bzc_wgt.value == ""){
            	ComShowCodeMessage('PRI00316','Weight Ton'); 
            	formObj.trf_bzc_wgt.focus();
                return false;
        	}
        	if (!ComChkObjValid(formObj.trf_bzc_wgt)){
            	formObj.trf_bzc_wgt.focus();
                return false;
        	}
            if (ComIsEmpty(comboObjects[3].GetSelectText())) {
                ComShowCodeMessage('PRI00316','Weight Ton Unit');   
                comboObjects[3].Focus();
                return false;
            }
        	if (formObj.trf_bzc_vol_qty.value == ""){
            	ComShowCodeMessage('PRI00316','Volume Ton'); 
            	formObj.trf_bzc_vol_qty.focus();
                return false;
        	}
        	if (!ComChkObjValid(formObj.trf_bzc_vol_qty)){
            	formObj.trf_bzc_vol_qty.focus();
                return false;
        	}
            if (ComIsEmpty(comboObjects[4].GetSelectText())) {
                ComShowCodeMessage('PRI00316','Volume Ton Unit');   
                comboObjects[4].Focus();
                return false;
            }
            if (ComIsEmpty(comboObjects[5].GetSelectText())) {
                ComShowCodeMessage('PRI00316','Currency');   
                comboObjects[5].Focus();
                return false;
            }
        	if (formObj.pub_cntc_pson_nm.value == ""){
            	ComShowCodeMessage('PRI00316','Contact');
            	formObj.pub_cntc_pson_nm.focus();
                return false;
        	}
        	if (formObj.pub_ofc_addr.value == ""){
            	ComShowCodeMessage('PRI00316','Address'); 
            	formObj.pub_ofc_addr.focus();
                return false;
        	}
        	if (formObj.pub_ofc_phn_no.value == ""){
            	ComShowCodeMessage('PRI00316','Phone'); 
            	formObj.pub_ofc_phn_no.focus();
                return false;
        	}
        	if (formObj.pub_ofc_cty_nm.value == ""){
            	ComShowCodeMessage('PRI00316','City'); 
            	formObj.pub_ofc_cty_nm.focus();
                return false;
        	}
//        	if (formObj.pub_ofc_ste_cd.value == ""){
//            	ComShowCodeMessage('PRI00316','State'); 
//            	formObj.pub_ofc_ste_cd.focus();
//                return false;
//        	}
//        	if (formObj.pub_ofc_zip_cd.value == ""){
//            	ComShowCodeMessage('PRI00316','Zip Code'); 
//            	formObj.pub_ofc_zip_cd.focus();
//                return false;
//        	}
        	if (formObj.pub_ofc_cnt_nm.value == ""){
            	ComShowCodeMessage('PRI00316','Country'); 
            	formObj.pub_ofc_cnt_nm.focus();
                return false;
        	}
//        	if (formObj.pub_ofc_fax_no.value == ""){
//            	ComShowCodeMessage('PRI00316','Fax'); 
//            	formObj.pub_ofc_fax_no.focus();
//                return false;
//        	}
        	var effDt=sheetObjects[0].GetCellValue(1, "eff_dt");
        	var expDt=sheetObjects[0].GetCellValue(1, "exp_dt");
            if (effDt != "" && expDt != ""){
            	if(effDt>expDt){
            		ComShowCodeMessage('PRI00346');
            		return false;
            	}
            }
            var sCol="trf_bzc_rout_pnt_def_cd";//n1st_cmnc_amdt_seq
            var amdtSeq=formObj.amdt_seq.value;
            var sParamSheet2=sheetObjects[1].GetSaveString(true);
            if(sheetObjects[1].IsDataModified()&& sParamSheet2 == "") return false;
            var dupIdx1=ComPriAmendDupCheck(sheetObjects[1], sCol, amdtSeq)
            if(dupIdx1 != -1){
            	ComShowCodeMessage("PRI00342", "Tariff Scope Origin");
            	sheetObjects[1].SelectCell(dupIdx1, sCol);
            	return false;
            }
            var sParamSheet3=sheetObjects[2].GetSaveString(true);
            if(sheetObjects[2].IsDataModified()&& sParamSheet3 == "") return false;
            var dupIdx2=ComPriAmendDupCheck(sheetObjects[2], sCol, amdtSeq)
            if(dupIdx2 != -1){
            	ComShowCodeMessage("PRI00342", "Tariff Scope Destination");
            	sheetObjects[2].SelectCell(dupIdx2, sCol);
            	return false;
            }
            
            if(!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()){
                ComShowCodeMessage('PRI00301'); //There is no data to save.
                return false;
            }
	        /////////////////////////////////////////////////////////////////////
	        // update date chekcing : Main
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date chekcing : Tariff Scope
	        checkTpCd="CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            break;
 		case MODIFY02: // Delete
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
	        /////////////////////////////////////////////////////////////////////
	        // update date checking
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date checking : Tariff Scope
	        checkTpCd="CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
 			break;
 		case MODIFY03: // Request
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
 			var effDt=sheetObjects[0].GetCellValue(1, "eff_dt");
 			var expDt=sheetObjects[0].GetCellValue(1, "exp_dt");
            if (effDt != "" && expDt != ""){
            	if(effDt>expDt){
            		ComShowCodeMessage('PRI00346');
            		return false;
            	}
            }
	        /////////////////////////////////////////////////////////////////////
	        // update date checking
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date checking : Tariff Scope
	        checkTpCd="CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
 			break;
 		case MODIFY04: // Approve
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
	        /////////////////////////////////////////////////////////////////////
	        // update date checking
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date checking : Tariff Scope
	        checkTpCd="CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
			break;
 		case MODIFY06: // Cancel
// 			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) { 
// 				ComShowCodeMessage("PRI01057");
//			    return false;
//			}
	        /////////////////////////////////////////////////////////////////////
	        // update date checking
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        // update date checking : Tariff Scope
	        checkTpCd="CHECK3";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
			break;
 		}
 		return true;
 	}
 	
 	function callback3518(rtnVal){
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	}
 	
/////////////////////// Sheet Event (S) ///////////////////////
 	/**
 	 * calling function when occurring OnSearchEnd Event <br>
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		
 		var formObj=document.form;

// 		ComOpenWait(false); //->waiting->End
//		formControl(sheetObj, formObj);
// 		if(formObj.trf_pfx_cd.value == "") {
// 			buttonControl(""); 
// 		} else {
// 			buttonControl(sheetObj.GetCellValue(1,"trf_bzc_sts_cd"));
// 		}
 		
 		formObj.hid_amdt_seq.value=sheetObj.GetCellValue(1, "amdt_seq");
 		if(formObj.hid_amdt_seq.value == ""){
            sheetObj.SetCellValue(1,"amdt_seq","0",0);
            sheetObj.SetCellValue(1,"trf_bzc_sts_cd","I",0);
            sheetObj.SetCellValue(1,"rqst_ofc_cd",formObj.strofc_cd.value,0);
            sheetObj.SetCellValue(1,"cre_usr_id",formObj.strusr_id.value,0);
 		}
		formObj.trf_nm.value=sheetObj.GetCellValue(1, "trf_nm");
		formObj.trf_orz_nm.value=sheetObj.GetCellValue(1, "trf_orz_nm");
		formObj.trf_orz_tp_nm.value=sheetObj.GetCellValue(1, "trf_orz_tp_nm");
		formObj.amdt_seq.value=sheetObj.GetCellValue(1, "amdt_seq");
		formObj.trf_bzc_sts_cd.value=sheetObj.GetCellValue(1, "trf_bzc_sts_nm");
		formObj.trf_inlnd_flg.value=sheetObj.GetCellValue(1, "trf_inlnd_flg");
		formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "cre_dt"), "ymd");
		formObj.eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "eff_dt"), "ymd");
		formObj.exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "exp_dt"), "ymd");
		formObj.pub_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "pub_dt"), "ymd");
		formObj.rqst_ofc_cd.value=sheetObj.GetCellValue(1, "rqst_ofc_cd");
		formObj.cre_usr_id.value=sheetObj.GetCellValue(1, "cre_usr_id");
		formObj.trf_bzc_wgt.value=sheetObj.GetCellText(1, "trf_bzc_wgt");
 		formObj.trf_bzc_vol_qty.value=sheetObj.GetCellText(1, "trf_bzc_vol_qty");
 		
		if(sheetObj.GetCellValue(1, "apro_ofc_cd") == "") {
			comboObjects[1].SetSelectCode(-1,false);
		} else {
			comboObjects[1].SetSelectCode(sheetObj.GetCellValue(1, "apro_ofc_cd"),false);
		}
		if(sheetObj.GetCellValue(1, "trf_bzc_tp_cd") == "") {
			comboObjects[2].SetSelectCode(-1,false);
		} else {
			comboObjects[2].SetSelectCode(sheetObj.GetCellValue(1, "trf_bzc_tp_cd"),false);
		}
 		if(sheetObj.GetCellValue(1, "trf_bzc_wgt_ut_cd") == "") {
			comboObjects[3].SetSelectCode(-1,false);
		} else {
			comboObjects[3].SetSelectCode(sheetObj.GetCellValue(1, "trf_bzc_wgt_ut_cd"),false);
		}
 		if(sheetObj.GetCellValue(1, "trf_bzc_vol_ut_cd") == "") {
			comboObjects[4].SetSelectCode(-1,false);
		} else {
			comboObjects[4].SetSelectCode(sheetObj.GetCellValue(1, "trf_bzc_vol_ut_cd"),false);
		}
 		if(sheetObj.GetCellValue(1, "curr_cd") == "") {
			comboObjects[5].SetSelectCode(-1,false);
		} else {
			comboObjects[5].SetSelectCode(sheetObj.GetCellValue(1, "curr_cd"),false);
		}
		
		formObj.pub_cntc_pson_nm.value=sheetObj.GetCellValue(1, "pub_cntc_pson_nm");
		formObj.pub_ofc_addr.value=sheetObj.GetCellValue(1, "pub_ofc_addr");
		formObj.pub_ofc_phn_no.value=sheetObj.GetCellValue(1, "pub_ofc_phn_no");
		formObj.pub_ofc_cty_nm.value=sheetObj.GetCellValue(1, "pub_ofc_cty_nm");
		formObj.pub_ofc_ste_cd.value=sheetObj.GetCellValue(1, "pub_ofc_ste_cd");
		formObj.pub_ofc_zip_cd.value=sheetObj.GetCellValue(1, "pub_ofc_zip_cd");
		formObj.pub_ofc_cnt_nm.value=sheetObj.GetCellValue(1, "pub_ofc_cnt_nm");
		formObj.pub_ofc_fax_no.value=sheetObj.GetCellValue(1, "pub_ofc_fax_no");
 	}
 	/**
 	 * calling function when occurring OnSearchEnd Event <br>
 	 */
 	function sheet2_OnSearchEnd(sheetObj, errMsg){
 		manageGetCellEditable(sheetObj);
 	}
 	/**
 	 * calling function when occurring OnSearchEnd Event <br>
 	 */
 	function sheet3_OnSearchEnd(sheetObj, errMsg){
 		manageGetCellEditable(sheetObj);
 	}
 	function SheetObject(sheet, row, col, rtnVal){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 		this.rtnVal = rtnVal;
 	}
 	var _tmp_sheetObject;
 	
 	function callback4026(rtnVal){
 		if (rtnVal != null){
 			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col,rtnVal.cd,0);
 			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col + 1,rtnVal.nm,0);
		}
 	}
 	
	 /**
     * calling function when occurring OnPopupClick Event <br>
     */
     function sheet2_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var colname=sheetObj.ColSaveName(Col);
      	switch(colname)
      	{
  	    	case "trf_bzc_rout_pnt_def_cd":
  	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
	  			sUrl += "location_cmd=C";
	  			ComOpenPopup(sUrl, 700, 310, 'callback4026','1,0', true);
	  			_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
  				break;
      	}
     }
	 /**
      * calling function when occurring OnPopupClick Event <br>
      */
      function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
  	    var colname=sheetObj.ColSaveName(Col);
       	switch(colname)
       	{
   	    	case "trf_bzc_rout_pnt_def_cd":
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "location_cmd=C";
 	  			ComOpenPopup(sUrl, 700, 310, 'callback4026','1,0', true);
 	  			_tmp_sheetObject = new SheetObject(sheetObj, Row, Col); 	  			
   				break;
       	}
      }
      /**
       * calling function when occurring OnChange Event <br>
       * when selecting multi comboBox, showing description <br>
       */  	
		  function sheet2_OnChange(sheetObj, Row, Col, Value){
         	var colname=sheetObj.ColSaveName(Col);
         	switch(colname)
         	{
     	    	case "trf_bzc_rout_pnt_def_cd":
     	    		if (Value.length==2){ 
     	    			var param="f_cmd="       +SEARCH07
	 					          + "&cd=" +sheetObj.GetCellValue(Row,Col);
	 					var sXml=sheetObj.GetSearchData("PRICommonGS.do", param);
	   	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	  	
	 					if (arrData[1] != ""){
	 						sheetObj.SetCellValue(Row,"cnt_nm",arrData[1],0);
	 					}else{
	 						locationCellClear(sheetObj,Row);
	 					}
     	    		}else{
    	    			locationCellClear(sheetObj,Row);
    	    		}
     	    		break; 	    		
         	}
         }
	  /**
	   * calling function when occurring OnChange Event <br>
	   * when selecting multi comboBox, showing description <br>
	   */  	
	  function sheet3_OnChange(sheetObj, Row, Col, Value){
	 	var colname=sheetObj.ColSaveName(Col);
	 	switch(colname)
	 	{
		case "trf_bzc_rout_pnt_def_cd":
			if (Value.length==2){  
				var param="f_cmd="       +SEARCH07
				          + "&cd=" +sheetObj.GetCellValue(Row,Col)
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	  	
				if (arrData[1] != ""){
					sheetObj.SetCellValue(Row,"cnt_nm",arrData[1],0);
				}else{
					locationCellClear(sheetObj,Row);
				}
			}else{
				locationCellClear(sheetObj,Row);
			}
			break; 	     		
	 	}
	 }
     /**
      * calling function when occurring OnSelectCell Event <br>
      * when clicking, setting background yellow in case of modified Scope(Text Color : RED)<br>
      */  
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	if(OldRow != NewRow){
    		//under button control
			buttonControlBottom();
    	}
    }
    /**
     * calling function when occurring OnSelectCell Event <br>
     * when clicking, setting background yellow in case of modified Scope(Text Color : RED)<br>
     */  
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if(OldRow != NewRow){			
			//under button control
			buttonControlBottom();
		}
    }
/////////////////////// Sheet Event (E) ///////////////////////
/////////////////////// Combo Event (S) ///////////////////////
   	/**
   	 * event handler when changing seleted item in IBMulti Combo<br>
   	 */
   	function tariff_cd_OnChange(comboObj, OldInd, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
   		var formObj=document.form;
   		var arrText=NewTxt.split("|");
   		if (arrText != null && arrText.length > 0) { 
   			formObj.trf_nm.value=comboObj.GetText(NewCod, 1);
			var arr=NewCod.split("-");				
			formObj.trf_pfx_cd.value=arr[0];
			formObj.trf_no.value=arr[1];
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		}
   	}
   	/**
   	 * calling event when focus out<br>
   	 */   	
//   	function tariff_cd_OnBlur(comboObj) {
//   		var formObj=document.form;
//   		var code=comboObj.GetSelectCode();//comboObj.FindItem(comboObj.GetSelectCode(), 0);
//   		if (code != null && code != "" && code != "-1") {
//   	   		var arr=code.split("-");				
//   			formObj.trf_pfx_cd.value=arr[0];
//   			formObj.trf_no.value=arr[1];
//   			var text=comboObj.GetText(code, 1);
//   			if (text != null && text != "" && text != formObj.trf_nm.value) {
//   				formObj.trf_nm.value=comboObj.GetText(code, 1);
//   	 			//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   	 			
//   			}
//   		}
//   	}
    /**
     * event handler when changing seleted item in IBMulti Combo<br>
     * setting the changed data by using com_change_sheet() function <br>
     */     
    function apro_ofc_cd_OnChange(comboObj, OldInd, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=NewTxt.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.apro_ofc_cd.value=comboObj.GetText(NewCod, 1);
    	}
        com_change_sheet( sheetObj, "apro_ofc_cd" );
    }
    /**
     * event handler when changing seleted item in IBMulti Combo<br>
     * setting the changed data by using com_change_sheet() function <br>
     */     
    function trf_bzc_tp_cd_OnChange(comboObj, OldInd, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=NewTxt.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.trf_bzc_tp_cd.value=comboObj.GetText(NewCod, 1);
    	}
        com_change_sheet( sheetObj, "trf_bzc_tp_cd" );
    }
    /**
     * event handler when changing seleted item in IBMulti Combo<br>
     * setting the changed data by using com_change_sheet() function <br>
     */     
    function trf_bzc_wgt_ut_cd_OnChange(comboObj, OldInd, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=NewTxt.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.trf_bzc_wgt_ut_cd.value=comboObj.GetText(NewCod, 1);
    	}
        com_change_sheet( sheetObj, "trf_bzc_wgt_ut_cd" );
    }
    /**
     * event handler when changing seleted item in IBMulti Combo<br>
     * setting the changed data by using com_change_sheet() function <br>
     */     
    function trf_bzc_vol_ut_cd_OnChange(comboObj, OldInd, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=NewTxt.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.trf_bzc_vol_ut_cd.value=comboObj.GetText(NewCod, 1);
    	}
        com_change_sheet( sheetObj, "trf_bzc_vol_ut_cd" );
    }
    /**
     * event handler when changing seleted item in IBMulti Combo<br>
     * setting the changed data by using com_change_sheet() function <br>
     */     
    function curr_cd_OnChange(comboObj, OldInd, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=NewTxt.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.curr_cd.value=comboObj.GetText(NewCod, 1);
    	}
        com_change_sheet( sheetObj, "curr_cd" );
    }
/////////////////////// Combo Event (E) ///////////////////////
 	/**
 	 * setting all button disable<br>
 	 */
 	function allButtonDisable() {
 		ComBtnDisable("btn_new");
 		ComBtnDisable("btn_retrieve");
 		ComBtnDisable("btn_amend");
 		ComBtnDisable("btn_save");
 		ComBtnDisable("btn_delete");
 		ComBtnDisable("btn_request");
 		ComBtnDisable("btn_approve");
 		ComBtnDisable("btn_publish");
 		ComBtnDisable("btn_cancel");
 		ComBtnDisable("btn_rowadd1");
 		ComBtnDisable("btn_rowdelete1");
 		ComBtnDisable("btn_amend1");
 		ComBtnDisable("btn_amendcancel1");
 		ComBtnDisable("btn_rowadd2");
 		ComBtnDisable("btn_rowdelete2");
 		ComBtnDisable("btn_amend2");
 		ComBtnDisable("btn_amendcancel2");
 	}
 	/**
 	 * setting all button enable by screen status <br>
 	 */
 	function buttonControl(mode) {
 		allButtonDisable();
 		var formObj=document.form;
 		var amdtNo=formObj.hid_amdt_seq.value;
 		var effDt=formObj.eff_dt.value;
 		var loginOfcCd=formObj.strofc_cd.value;
 		var reqOfcCd=sheetObjects[0].GetCellValue(1, "rqst_ofc_cd");
// 		var aproOfcCd  = sheetObjects[0].CellValue(1, "apro_ofc_cd");
 		var aproFlg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
 		switch (mode) {
 		case "":	
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			break;
 		case "I":	
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			if(loginOfcCd == reqOfcCd){
	 			ComBtnEnable("btn_save");
	 			if(effDt!=""){
		 			ComBtnEnable("btn_request");
					if(amdtNo == 0){
						ComBtnEnable("btn_delete");
					}else{
						ComBtnEnable("btn_cancel");
					}
	 			}
				buttonControlBottom();
 			}
 			break;
 		case "Q":	// Request
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
// 			
// 			if(loginOfcCd == aproOfcCd){
//	 			ComBtnEnable("btn_approve");
//	 			ComBtnEnable("btn_cancel");
// 			} else if(loginOfcCd == reqOfcCd){
//	 			ComBtnEnable("btn_cancel");
// 			}
 			if(aproFlg == "Y"){
	 			ComBtnEnable("btn_approve");
	 			ComBtnEnable("btn_cancel");
 			}
 			if(loginOfcCd == reqOfcCd)
	 			ComBtnEnable("btn_cancel");
 			break;
 		case "A":	// Approve
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_publish");
// 			if(loginOfcCd == aproOfcCd){
//	 			ComBtnEnable("btn_cancel");
// 			}
 			if(aproFlg == "Y")
 				ComBtnEnable("btn_cancel");
 			break;
 		case "F":	// Publish
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_amend");
 			break;
 		}
 	}
 	/**
 	 * setting button enable by lower sheet row data <br>
 	 */
 	function buttonControlBottom(){
 		var loginOfcCd=document.form.strofc_cd.value;
 		var reqOfcCd=sheetObjects[0].GetCellValue(1, "rqst_ofc_cd");
 		if(sheetObjects[0].GetCellValue(1,"trf_bzc_sts_cd") != "I") return;
 		if(loginOfcCd != reqOfcCd) return;
 		
 		var amdtNo=document.form.hid_amdt_seq.value;
 		var sheet1=sheetObjects[1];
 		var rowCnt1=sheet1.RowCount();
		var amdtSeq1=sheet1.GetCellValue(sheet1.GetSelectRow(), "amdt_seq");
		var n1stSeq1=sheet1.GetCellValue(sheet1.GetSelectRow(), "n1st_cmnc_amdt_seq");
		var srcInfoCd1=sheet1.GetCellValue(sheet1.GetSelectRow(), "src_info_cd");
 		var sheet2=sheetObjects[2];
 		var rowCnt2=sheet2.RowCount();
		var amdtSeq2=sheet2.GetCellValue(sheet2.GetSelectRow(), "amdt_seq");
		var n1stSeq2=sheet2.GetCellValue(sheet2.GetSelectRow(), "n1st_cmnc_amdt_seq");
		var srcInfoCd2=sheet2.GetCellValue(sheet2.GetSelectRow(), "src_info_cd");
 		ComBtnDisable("btn_rowadd1");
 		ComBtnDisable("btn_rowdelete1");
 		ComBtnDisable("btn_amend1");
 		ComBtnDisable("btn_amendcancel1");
 		ComBtnDisable("btn_rowadd2");
 		ComBtnDisable("btn_rowdelete2");
 		ComBtnDisable("btn_amend2");
 		ComBtnDisable("btn_amendcancel2");
		// Tariff Scope Origin Sheet
		if(rowCnt1 == 0 || amdtSeq1 == amdtNo || amdtNo == 0) {
			ComBtnEnable("btn_rowadd1");
			ComBtnEnable("btn_rowdelete1");
		}
		if(amdtSeq1 != n1stSeq1 && amdtNo == amdtSeq1 && (srcInfoCd1 == "AM" || srcInfoCd1 == "NW") ){
			ComBtnEnable("btn_amend1");
		} else if(amdtSeq1 == n1stSeq1 && amdtNo == amdtSeq1 && (srcInfoCd1 == "AM" || srcInfoCd1 == "AD")) {
			ComBtnEnable("btn_amendcancel1");
			ComBtnDisable("btn_rowdelete1");
		}
		// Tariff Scope Destination Sheet
		if(rowCnt2 == 0 || amdtSeq2 == amdtNo || amdtNo == 0) {
			ComBtnEnable("btn_rowadd2");
			ComBtnEnable("btn_rowdelete2");
		}
		if(amdtSeq2 != n1stSeq2 && amdtNo == amdtSeq2 && (srcInfoCd2 == "AM" || srcInfoCd2 == "NW") ){
			ComBtnEnable("btn_amend2");
		} else if(amdtSeq2 == n1stSeq2 && amdtNo == amdtSeq2 && (srcInfoCd2 == "AM" || srcInfoCd2 == "AD")) {
			ComBtnEnable("btn_amendcancel2");
			ComBtnDisable("btn_rowdelete2");
		}
 	}
    /**
     * setting inputting form Disable/Enable <br>
     */ 
 	function formControl(sheetObj, formObj){
 		
 		var loginOfcCd=formObj.strofc_cd.value;
 		var reqOfcCd=sheetObjects[0].GetCellValue(1, "rqst_ofc_cd");
 		
 		if(formObj.hid_amdt_seq.value == "" || sheetObj.GetCellValue(1,"trf_bzc_sts_cd") == "I"){
			if(loginOfcCd == reqOfcCd) {
				formEnableControl(); //Enable
			} else formDisableControl(); //Disable
 		} else {
			//Disable
	 		formDisableControl();
		}
 	}
    /**
     * setting inputting form all Disable <br>
     */  
     function formDisableControl(){
         var formObj=document.form;
         var sheetObj1=sheetObjects[1];
         var sheetObj2=sheetObjects[2];
         formObj.eff_dt.readOnly=true;
         formObj.exp_dt.readOnly=true;
         comboObjects[1].SetEnable(0);
         comboObjects[2].SetEnable(0);
         formObj.trf_bzc_wgt.readOnly=true;
         comboObjects[3].SetEnable(0);
         formObj.trf_bzc_vol_qty.readOnly=true;
         comboObjects[4].SetEnable(0);
         comboObjects[5].SetEnable(0);
         formObj.pub_cntc_pson_nm.readOnly=true;
         formObj.pub_ofc_addr.readOnly=true;
         formObj.pub_ofc_phn_no.readOnly=true;
         formObj.pub_ofc_cty_nm.readOnly=true;
         formObj.pub_ofc_ste_cd.readOnly=true;
         formObj.pub_ofc_zip_cd.readOnly=true;
         formObj.pub_ofc_cnt_nm.readOnly=true;
         formObj.pub_ofc_fax_no.readOnly=true;
         ComEnableObject(formObj.btns_calendar1, false);
         ComEnableObject(formObj.btns_calendar2, false);
         formObj.eff_dt.className="input2";
         formObj.trf_bzc_wgt.className="input2";
         formObj.trf_bzc_vol_qty.className="input2";
         formObj.pub_cntc_pson_nm.className="input2";
         formObj.pub_ofc_addr.className="input2";
         formObj.pub_ofc_phn_no.className="input2";
         formObj.pub_ofc_cty_nm.className="input2";
         formObj.pub_ofc_cnt_nm.className="input2";
         formObj.exp_dt.className="input2";
         formObj.pub_ofc_ste_cd.className="input2";
         formObj.pub_ofc_zip_cd.className="input2";
         formObj.pub_ofc_fax_no.className="input2";
     }
     /**
      * setting inputting form all Enable <br>
      */  
      function formEnableControl(){
    	  formDisableControl();
          var formObj=document.form;
          
          if(formObj.hid_amdt_seq.value == "" || formObj.hid_amdt_seq.value == 0){
        	  formObj.eff_dt.readOnly=false;
        	  ComEnableObject(formObj.btns_calendar1, true);
        	  formObj.eff_dt.className="input1";
        	  comboObjects[2].SetEnable(1);
          }
          formObj.exp_dt.readOnly=false;
          comboObjects[1].SetEnable(1);
          formObj.trf_bzc_wgt.readOnly=false;
          comboObjects[3].SetEnable(1);
          formObj.trf_bzc_vol_qty.readOnly=false;
          comboObjects[4].SetEnable(1);
          comboObjects[5].SetEnable(1);
          formObj.pub_cntc_pson_nm.readOnly=false;
          formObj.pub_ofc_addr.readOnly=false;
          formObj.pub_ofc_phn_no.readOnly=false;
          formObj.pub_ofc_cty_nm.readOnly=false;
          formObj.pub_ofc_ste_cd.readOnly=false;
          formObj.pub_ofc_zip_cd.readOnly=false;
          formObj.pub_ofc_cnt_nm.readOnly=false;
          formObj.pub_ofc_fax_no.readOnly=false;
          ComEnableObject(formObj.btns_calendar2, true);
          
          formObj.trf_bzc_wgt.className="input1";
          formObj.trf_bzc_vol_qty.className="input1";
          formObj.pub_cntc_pson_nm.className="input1";
          formObj.pub_ofc_addr.className="input1";
          formObj.pub_ofc_phn_no.className="input1";
          formObj.pub_ofc_cty_nm.className="input1";
          formObj.pub_ofc_cnt_nm.className="input1";
          formObj.exp_dt.className="input";
          formObj.pub_ofc_ste_cd.className="input";
          formObj.pub_ofc_zip_cd.className="input";
          formObj.pub_ofc_fax_no.className="input";
      }
      /**
       * setting image button activation <br>
       */ 
     function btnImgEnable(obj, gb) {
//         if(obj.constructor == String){
//             obj=document.getElementsByName(obj)[0];        
//         }
//         var btnStyle=obj.style;
         if (gb){
             //obj.SetEnable(1);
             ComBtnEnable(obj);
             //btnStyle.cursor="hand";
             //btnStyle.filter="";
             //obj.disabled=false;
         } else {
             //obj.SetEnable(0);
        	 ComBtnDisable(obj);
             //btnStyle.cursor="auto";
             //btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
             //obj.disabled=true;
         }
     }
    /**
     * initialiaing IBMulti Combo Object and all items on screen<br>
     */  
     function clearAllForms(){
         var formObj=document.form;
         comboObjects[0].SetSelectIndex(-1);
         formObj.trf_pfx_cd.value="";
         formObj.trf_no.value="";
         formObj.trf_nm.value="";
         formObj.trf_orz_nm.value="";
         formObj.trf_orz_tp_nm.value="";
         formObj.amdt_seq.value="";
         formObj.trf_bzc_sts_cd.value="";
         formObj.trf_inlnd_flg.value="";
         formObj.eff_dt.value="";
         formObj.exp_dt.value="";
         formObj.pub_dt.value="";
         formObj.cre_dt.value="";
         comboObjects[1].SetSelectIndex(-1);
         formObj.cre_usr_id.value="";
         formObj.apro_ofc_cd.value="";
         comboObjects[2].SetSelectIndex(-1);
         formObj.trf_bzc_wgt.value="";
         comboObjects[3].SetSelectIndex(-1);
         formObj.trf_bzc_vol_qty.value="";
         comboObjects[4].SetSelectIndex(-1);
         comboObjects[5].SetSelectIndex(-1);
         formObj.pub_cntc_pson_nm.value="";
         formObj.pub_ofc_addr.value="";
         formObj.pub_ofc_phn_no.value="";
         formObj.pub_ofc_cty_nm.value="";
         formObj.pub_ofc_ste_cd.value="";
         formObj.pub_ofc_zip_cd.value="";
         formObj.pub_ofc_cnt_nm.value="";
         formObj.pub_ofc_fax_no.value="";
     }
   /**
    * setting changed data on the hidden sheet, when changing Html Object's value<br>
    */  
    function com_change_sheet( sheetObj, colNm ){
    	var formObj=document.form;
        var eleValue="";
        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                case "eff_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "exp_dt":
                	eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "trf_bzc_wgt":
                	//appying format and number check
                	if(!setFormat(colNm)) return;
                	eleValue=formObj.trf_bzc_wgt.value;
                    break;
                case "trf_bzc_vol_qty":
                	//appying format and number check
                	if(!setFormat(colNm)) return;
                	eleValue=formObj.trf_bzc_vol_qty.value;
                    break;
                case "pub_ofc_phn_no":
                	eleValue=formObj.pub_ofc_phn_no.value;
                	break;
                case "pub_ofc_fax_no":
                	eleValue=formObj.pub_ofc_fax_no.value;
                	break;
                default:
                    eleValue=document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.SetCellValue(1,colNm,eleValue);
        }else{
            sheetObj.SetCellValue(1,colNm,document.getElementById(colNm).GetSelectCode());
        }
    }
	/**
	 * control SHEET's CELL editable authority <br>
	 */
	 function manageGetCellEditable(sheetObj) {
		 //sheetObj.headCheck(0, 1)=false;
		 var formObj=document.form;
		 var trf_bzc_sts_cd=formObj.trf_bzc_sts_cd.value;
		 var amdt_seq=formObj.amdt_seq.value;
	 	 var loginOfcCd=formObj.strofc_cd.value;
	 	 var reqOfcCd=sheetObjects[0].GetCellValue(1, "rqst_ofc_cd");
		 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
			 if(sheetObj.GetCellValue(i,"amdt_seq") != amdt_seq){
				 sheetObj.SetCellFont("FontStrike", i, "seq", i, sheetObj.LastCol(),true);
				 sheetObj.SetRowEditable(i,0);
			 }
			 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq && amdt_seq > 0){
				 sheetObj.SetCellFont("FontColor", i, "seq", i, sheetObj.LastCol(),"#FF0000");
				 sheetObj.SetRowEditable(i,1);
			 }
			 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdt_seq){
				 sheetObj.SetCellEditable(i,"trf_bzc_rout_pnt_def_cd",0);
			 }else{
				 if(sheetObj.GetCellValue(i,"src_info_cd")=="AM") sheetObj.GetCellEditable(i,"trf_bzc_rout_pnt_def_cd",1);
			     else if(sheetObj.GetCellValue(i,"src_info_cd")=="AD") sheetObj.GetCellEditable(i,"trf_bzc_rout_pnt_def_cd",0);
			 }
			 if(trf_bzc_sts_cd != "Initial"){
				 sheetObj.SetCellEditable(i,"trf_bzc_rout_pnt_def_cd",0);
				 sheetObj.SetCellEditable(i,"chk",0);
			 }
			 if(loginOfcCd != reqOfcCd){
				 sheetObj.SetCellEditable(i,"trf_bzc_rout_pnt_def_cd",0);
				 sheetObj.SetCellEditable(i,"chk",0);
			 }
		 }
	 }
    /**
     * setting sheet's specific cell with blank <br>
     */  	    
  	function locationCellClear(sheetObj,Row){
    	sheetObj.SetCellValue(Row,"trf_bzc_rout_pnt_def_cd","",0);
  		sheetObj.SetCellValue(Row,"cnt_nm","",0);
  		sheetObj.SelectCell(Row,"trf_bzc_rout_pnt_def_cd");
  	}
    /**
     * setting row by Delete, Amend, Amend Cancel Event<br>
     */  
  	function setSheetAmendRow(sheetObj,formObj,row,srcInfo){
		var amdt_seq=formObj.amdt_seq.value;
		var sel_row="";
		if(row=="") sel_row=sheetObj.GetSelectRow();
		else sel_row=row;
		//Delete
		if(srcInfo=="AD"){
			if(sheetObj.GetCellValue(sel_row,"amdt_seq")!=amdt_seq
					||(sheetObj.GetCellValue(sel_row,"n1st_cmnc_amdt_seq")==amdt_seq
							&& (sheetObj.GetCellValue(sel_row,"src_info_cd")=="AM" || sheetObj.GetCellValue(sel_row,"src_info_cd")=="AD")))
			{
				ComShowCodeMessage("PRI01002");//Please check valid row
				return false;
			}
		}
		//Amend
		if(srcInfo=="AM"){
			if(sheetObj.GetCellValue(sel_row,"amdt_seq")!= amdt_seq
					|| sheetObj.GetCellValue(sel_row,"n1st_cmnc_amdt_seq")== amdt_seq)
			{
	            ComShowCodeMessage("PRI00313");
	            return false;
	        }
		}
		//Amend Cancel
		if(srcInfo==""){
			if(sheetObj.GetCellValue(sel_row,"n1st_cmnc_amdt_seq")!= amdt_seq ||
					(sheetObj.GetCellValue(sel_row,"src_info_cd")!="AD"&&sheetObj.GetCellValue(sel_row,"src_info_cd")!="AM"))
			{
                ComShowCodeMessage("PRI00313");
                return false;
			}
		}
        sheetObj.SetCellValue(sel_row, "chk",0,0);
        sheetObj.SetHeaderCheck(0, 1, false);
		//Amend Cancel
		if(srcInfo==""){
			var bf_row=sel_row-1;
			//new row
			sheetObj.RowDelete(sel_row, false);
			//existed row
			sheetObj.SetRowStatus(bf_row,"U");
			sheetObj.SetCellValue(bf_row,"amdt_seq",amdt_seq,0);
			sheetObj.SetCellFont("FontStrike", bf_row, 1, bf_row, sheetObj.LastCol(), false);
			sheetObj.SetRowEditable(bf_row,1);
		}else{
			if(sheetObj.GetCellValue(sel_row, "n1st_cmnc_amdt_seq")!= amdt_seq){
		        sheetObj.SetSelectRow(sel_row);
		        var idx=sheetObj.DataCopy();     // new row
		        var idx2=idx-1;                  // existed row
		        //newrow
		        sheetObj.SetCellValue(idx, "src_info_cd",srcInfo,0);
		        sheetObj.SetCellValue(idx,"n1st_cmnc_amdt_seq",amdt_seq,0);
		        sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
		        sheetObj.SetRowStatus(idx,"U");
		        if(srcInfo=="AM") sheetObj.SetCellEditable(idx,"trf_bzc_rout_pnt_def_cd",1);
		        else if(srcInfo=="AD") sheetObj.SetCellEditable(idx,"trf_bzc_rout_pnt_def_cd",0);
		        //existedrow
		        sheetObj.SetCellValue(idx2,"amdt_seq",amdt_seq-1,0);
		        sheetObj.SetCellFont("FontStrike", idx2, 1, idx2, sheetObj.LastCol(),true);
		        sheetObj.SetRowStatus(idx2,"R");
		        sheetObj.SetCellEditable(idx2,"trf_bzc_rout_pnt_def_cd",0);
		        sheetObj.SetRowEditable(idx2,0);
			}else{
				if(srcInfo=="AD"){
					sheetObj.SetRowStatus(sel_row,"D");
					sheetObj.SetRowHidden(sel_row,1);
				}
			}
		}
  	}
    /**
    * checking data to prohibit modifying same S/C before processing amend, request <BR>
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
    	var returnValue=false;
        /////////////////////////////////////////////////////////////////////
        // update date checking
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam="f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC&page_name=Tariff General Information"
				+ "&key1="  + checkSheetObj.GetCellValue(1, "trf_pfx_cd")
				+ "&key2="  + checkSheetObj.GetCellValue(1, "trf_no")
				+ "&key3="  + checkSheetObj.GetCellValue(1, "amdt_seq")
				+ "&upd_dt="+ checkSheetObj.GetCellValue(1, "upd_dt");
	        var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   case "CHECK2" : //amend
		   var amdt_seq=parseInt(checkSheetObj.GetCellValue(1, "amdt_seq"));
	   		//checking existence of next seq
	   		amdt_seq++;
	        var checkParam="f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC&page_name=Tariff General Information"
	        	+ "&key1="  + checkSheetObj.GetCellValue(1, "trf_pfx_cd")
	        	+ "&key2="  + checkSheetObj.GetCellValue(1, "trf_no")
	                       + "&key3="  + amdt_seq
	                       + "&upd_dt="+ checkSheetObj.GetCellValue(1, "upd_dt");
	        var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   case "CHECK3" : //tariff scope
	        var checkParam="f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC_ROUT_PNT&page_name=Tariff General Information"
				+ "&key1="  + checkSheetObj.GetCellValue(1, "trf_pfx_cd")
				+ "&key2="  + checkSheetObj.GetCellValue(1, "trf_no")
				+ "&key3="  + checkSheetObj.GetCellValue(1, "amdt_seq")
				+ "&upd_dt="+ checkSheetObj.GetCellValue(1, "rout_upd_dt");
	        var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
     /**
      * in case of number, setting 999.999 type and return true <br>
      * not number, setting "" and return false 
      */   
     function setFormat(eleName){
         var eleVal=document.getElementById(eleName).value;
         if(chkIsNaN(eleName, "")) {
//        	 document.getElementById(eleName).value = "";
        	 return false;
         }else {
	         var eleValArr=eleVal.split(".");
	         if(eleVal != ""){
	        	 if(eleValArr.length > 1){
	        		 if(eleValArr[1].length == 1){
	        			 eleVal=eleVal + "00";
	        		 }else if(eleValArr[1].length == 2){
	        			 eleVal=eleVal + "0";
	        		 }
	        	 }else{
	        		 eleVal=eleVal + ".000";
	        	 }
	         }
         	document.getElementById(eleName).value=eleVal;
         	return true;
         }
     }
     /**
      * checking number or not<br>
      */  
     function chkIsNaN(eleName, char){
    	 var eleVal=document.getElementById(eleName).value;
    	 var flg=false;
    	 var eleValArr;
    	 if(char == ""){
    		 flg=isNaN(ComGetUnMaskedValue(eleVal, "float"));
    	 } else{
    		 eleValArr=eleVal.split(char);
    		 for(i=0 ; i<eleValArr.length ; i++){
    			 if(isNaN(eleValArr[i])) return true;
    		 }
    	 }
    	 return flg;
     }
     /**
      * checking korean<br>
      */  
     function chkIsNaH(eleName){
    	 var eleVal=document.getElementById(eleName).value;
    	 var cnt=0;
    	 for(i=0 ; i<eleVal.length ; i++){
    		 if(eleVal.charCodeAt(i) >= 0 && eleVal.charCodeAt(i) <= 127){
    			 //
    		 }else{
    			 cnt++;
    		 }
    	 }
    	 if(cnt>0) return true;
    	 else return false;
     }
	/**
	 * getting Sheet Data in XML type <br>
	 */
   function getSheetXml() { 
	   var sheetObj=sheetObjects[0];       
	   sXml=ComPriSheet2Xml(sheetObj);
	   return sXml;
   }
	/**
	 * when clicking upper Code Creation Text, open Code Creation screen<br>
	 */   
   function goCodeCreation(){
		var pgmNo="ESM_PRI_3502";
		var pgmUrl="/opuscntr/ESM_PRI_3502.do"
//		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
//		var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo;
//		var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
//		var winObj=window.open("/opuscntr/ESM_PRI_3502_POP.do?parentPgmNo=" + parentPgmNo + src, "", sFeatures); 
		ComOpenPopup("ESM_PRI_3502_POP.do?is_popup=true", 1000, 700, "", "1,0", true);
   }