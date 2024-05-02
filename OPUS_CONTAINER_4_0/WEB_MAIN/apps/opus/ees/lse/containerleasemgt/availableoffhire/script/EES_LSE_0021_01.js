/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0021_01.js
*@FileTitle  : Off-Hire CNTR List - Send to E-mail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
//	var opener=window.dialogArguments;
//	if (!opener)  opener=window.opener;  //이 코드 추가할것
//	if (!opener) opener=parent; //이 코드 추가할것
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
        var formObj=document.form;
    	try {
			var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_send":
                    doSendMail();
                	break;
                case "btn_attach":
                    doFileUpload();
                	break;
				case "btn_close":
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheet1_OnLoadFinish(sheet1);
    }
	/**
	 * calling event after Load-Finish
	 */
 	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Axon Control Setting*/
		initControl();
		var vSaveNames="ibflag|scc_cd|vndr_seq|agmt_cty_cd|agmt_seq|lstm_cd|cntr_tpsz_cd|cntr_no|mty_rtn_yd_cd|off_hire_yard|"
					   + "off_hire_due_date|full_flg|mvmt_sts_cd|cnmv_dt|onh_yd_cd|onh_dt|min_onh_dys|used_days|onh_free_dys|"
					   + "mnr_cost|bkg_no|bl_no|pol_cd|pod_cd|del_cd|evnt_ofc_cd|pol_etd_dt|pod_eta_dt|vvd_cd";
		var sXml=ComMakeSearchXml(opener.sheetObjects[0], false, "del_chk",vSaveNames, false);
		sheetObj.LoadSearchData(sXml,{Sync:0} );
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		//do nothing
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
					var HeadTitle1="||Lessor|AGMT No.|AGMT No.|Lease\nTerm|TP/SZ|CNTR No.|Yard|Off-Hire\nYard|Off-Hire\nDue Date|MT/Full|MVMT\nState|MVMT\nDate|On-Hire\nYard|On-Hire\nDate|Min On-Hire\nDays|Used\nDays|Free\nDays|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|R.Office|ETD-DT|ETA-DT|VVD";
					var headCount=ComCountHeadTitle(HeadTitle1);
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:11, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"off_hire_yard",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"off_hire_due_date",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"onh_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"min_onh_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"used_days",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"onh_free_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pod_eta_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					
					InitColumns(cols);
					SetVisible(false);
					SetEditable(1);
					SetCountFormat("[SELECTDATAROW / TOTALROWS]");
				}
			break;
        }
    }
	/**
     * handling after saving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
    	ComOpenWait(false);
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		ComClosePopup(); 
    		opener.sendFlag=true;
    		opener.callbackSendMail(500);
    	}
    }
	/**
	 * sending E-Mail
	 */
	function doSendMail(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(ComChkValid(formObj, true)){
			if(ComIsEmailAddr(formObj.recipient.value) == false) {
				ComShowCodeMessage("LSE01108");
				ComSetFocus(formObj.recipient);
			} else {
				ComOpenWait(true, "tabLayer");
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("EES_LSE_0021GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false, "tabLayer");
			}
		}
	}
	/**
	 * handling process for file
	 */
	function doFileUpload(){
		var formObj=document.form;
		var before=formObj.fileKey.value;
		var returnValue=openUpload(formObj.siteConfig.value);
		if(returnValue == null){
			returnValue="";
		} else if(before == "") {
			returnValue=returnValue;
		} else{
			returnValue=";"+returnValue;
		}
		formObj.fileKey.value=before+returnValue;
	}
	/* end of developer job */
