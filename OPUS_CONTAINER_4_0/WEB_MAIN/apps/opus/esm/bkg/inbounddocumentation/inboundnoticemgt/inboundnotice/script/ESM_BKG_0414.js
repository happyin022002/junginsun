/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0414.js
*@FileTitle  : Pick-Up Notice Sent History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================**/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class esm_bkg_0414 : business script for esm_bkg_0414
	 */
	/*function esm_bkg_0414() {
	    this.processButtonClick     = tprocessButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;
	    this.initControl            = initControl;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.setTabObject           = setTabObject;
	    this.validateForm           = validateForm;
	    this.obj_keypress           = obj_keypress;
	    this.setComboObject         = setComboObject;
	}*/
	
	
	//Common global variable

	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheetNames=new Array("sheet1", "sheet2");
	var sheetInits=new Array(   false,    false);
	var PageNo = 1;
	
	//Event handler processing by button click event  */
	document.onclick=processButtonClick;
	
	/**
	 * Event handler processing by button name<br>
	 */
	function processButtonClick(){
	    var sheetObject1=sheetObjects[0];
	    var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    if (!ComIsBtnEnable(srcName)){ return; }
	    switch(srcName) {
		    case "btn_snd_dt":
		        var cal=new ComCalendarFromTo();
			    formObject.sch_tp[0].checked=true;
			    fnToggleSchTp("D", formObject);
			    cal.select(formObject.snd_dt_fm, formObject.snd_dt_to, 'yyyy-MM-dd');
		 	    break;
	        case "btn_Retrieve":
	            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	            break;
	        case "btn_DownExcel":
	        	if(sheetObject1.RowCount() < 1){//no data
	        		ComShowCodeMessage("COM132501");
	        	}else{
	        		doActionIBSheet(sheet2,formObject,IBDOWNEXCEL,"","");
	        	}
	        	break;
	        case "btn_PkupSend":
	        	fnMoveToPkupSend(sheetObjects[0], formObject);
	        	break;
	        case "btn_Print":
	        	fnPrintSheet(sheetObjects[0]);
	        	break;
	        case "btn_MasterData":
	        	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC10);
	        	break;
	        case "btn_UsIor":
	        	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC11);
	        	break;
	        case "btn_Close":
	        	ComClosePopup();
	        	break;
	    } // end switch
	}
	/**
	 * registering IBSheet Object as list<br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source<br>
	 * @param {Object} sheet_obj 
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet<br>
	 * implementing onLoad event handler in body tag<br>
	 * adding first-served functions after loading screen<br>
	 */
	function loadPage() {
		var formObj=document.form;
		fnInSetComboBox(formObj.mvmt_cd, evtCode, evtValue, "|", "", "ALL", true, "");
	    for(i=0;i<sheetNames.length;i++){
	    	//if(sheetNames[i] == "sheet1") {
	    		sheetInit(i);
	        //}
	    }
	    initControl();
	    if (parAutoSearchFlg == "Y") {
	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    }
	}
	/**
	 * initialize sheet
	 * @param {int} idx 
	 */
	function sheetInit(idx) {
		if (sheetInits[idx] == false) {
	        ComConfigSheet (sheetObjects[idx] );
	        initSheet(sheetObjects[idx],idx+1);
	        ComEndConfigSheet(sheetObjects[idx]);
	        sheetInits[idx]=true;
	    }
	}
	/**
	 * registering initial event 
	 */
	function initControl() {
	    axon_event.addListenerForm('click', 'objClick', form );
	    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	    axon_event.addListenerForm('change', 'objChange', form );
	    //axon_event.addListenerForm ('keypress', 'objKeyPress', form);
	    var formObj=document.form;
	    formObj.ofc_cd.value=strOfc_cd;  // default office - login office
	    // handling calendar  (from is 3 weeks ago, to is today)
	    formObj.snd_dt_to.value=ComGetNowInfo('ymd','-');
	    formObj.snd_dt_fm.value=ComGetDateAdd(null, 'd', -6, '-');
	    if (strCnt_cd== null || strCnt_cd != "US") {
		    ComBtnDisable("btn_PrePickup");
		    ComBtnDisable("btn_PreHold");
	    }
	    /* PARAMETER VARIABLE INIT */
	    if (parSchTp != "") {
	    	for (var idx=0; idx < formObj.sch_tp.length; idx ++ ) {
	    		if (formObj.sch_tp[idx].value == parSchTp) {
	    			formObj.sch_tp[idx].checked=true;
	    			break;
	    		}
	    	}
	    }
	    if (parBlNo != "") {
	    	formObj.bl_no.value=parBlNo;
	    }
	    var schTp="";
	    for (var idx=0; idx < formObj.sch_tp.length; idx++) {
		    if (formObj.sch_tp[idx].checked == true) {
			    schTp=formObj.sch_tp[idx].value;
			    break;
		    }
	    }
	    if (schTp == "") {
		    formObj.sch_tp[1].checked=true;
		    schTp=formObj.sch_tp[1].value;
	    }
	    fnToggleSchTp(schTp, formObj);
	}
	/**
	 * setting sheet initial values and header<br>
	 * param : sheetObj, sheetNo<br>
	 * adding case as numbers of counting sheets<br>
	 * @param {Object} sheetObj
	 * @param {int} sheetNo
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
	        case "sheet1":
	            with(sheetObj){		            
		          //no support[check again]CLT 	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		          var HeadTitle1="|Seq.|B/L No.|Container No.|Type|MVMT|Update Date|F|O|C|Pick No|Verify|Sent Result|Sent Result|Fax/E-mail Address|Sent RQST|Final Sent|TP|||Code|Customer|Send\nOFC|Send ID|User Name|||";
	
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
	
		          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibFlag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ntc_knd_cd_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"edi_322_mvmt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"pkup_ntc_evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"obl_clt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntc_fax_no_eml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_rqst_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",                 KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:215,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"usr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ntc_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"snd_gdt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);	
		          SetEditable(1);
		          SetWaitImageVisible(0);
		          //SetColProperty("pkup_ntc_evnt_dt", {Format:"####-##-####:##"} );
		          SetAutoRowHeight(0);
		          SetSheetHeight(460);
	        }
	        break;  
	        case "sheet2":
	            with(sheetObj){			            
			          var HeadTitle1="Seq.|B/L No.|Container No.|Type|MVMT|Update Date|F|O|C|Pick No|Verify|Sent Result|Sent Result|Fax/E-mail Address|Sent RQST|Final Sent|TP|Code|Customer|Send\nOFC|Send ID|User Name";
		
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ntc_knd_cd_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"edi_322_mvmt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"pkup_ntc_evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"obl_clt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntc_fax_no_eml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_rqst_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",                 KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:215,  Align:"Center",  ColMerge:1,   SaveName:"cust_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"usr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			           
			          InitColumns(cols);		
			          SetEditable(1);
			          //SetColProperty("pkup_ntc_evnt_dt", {Format:"####-##-####:##"} );
				      SetVisible(false);
				      SetSheetHeight(460);
	                }	            
	        	break;
			}
	}
	/**
	 * handling sheet process<br><br>
	 * @param {Object} sheetObj
	 * @param {Object} formObj
	 * @param {int} sAction
	 * @param {String} CondParam
	 * @param {int} PageNo
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
	    switch(sAction) {
	        case IBSEARCH:      
	            if (validateForm(sheetObj, formObj, sAction) == false) break;
	        	ComOpenWait(true);
	            formObj.f_cmd.value=SEARCH;
	            pageNo = 1;
	            sheetObj.DoSearch("ESM_BKG_0414GS.do", FormQueryString(formObj)+"&mtch_chk_flg=N&page_no=" + pageNo, {Sync:2} ); // *****           
	            break;
	        case IBSEARCHAPPEND:
	        	ComOpenWait(true);
	        	sheetObj.DoSearch("ESM_BKG_0414GS.do", CondParam + "&mtch_chk_flg=N&page_no=" + pageNo, {Append:true}); // *****      
	            break;
	        case IBDOWNEXCEL: 
	            if (validateForm(sheetObj, formObj, sAction) == false) break;
	        	formObj.f_cmd.value=SEARCH;
		        ComOpenWait(true);
		    	//sheetInit(1);     // 정의되지 않았다는 에러 메시지 있었음
		    	sheetObj.DoSearch("ESM_BKG_0414GS.do" , FormQueryString(formObj)  + "&excel_flg=Y");
	            break;
	        case IBSEARCH_ASYNC10:
	        	if (sheetObj.RowCount()== 0) {
	     	    	ComShowCodeMessage("BKG00395"); 
	    	        break;
	    	    }
	     	    var sRowStr=sheetObj.GetSelectionRows("/");
	        	var arr=sRowStr.split("/");
	           	if (arr.length > 1) {
	        		ComShowCodeMessage("BKG40075");
	        		break;
	        	}
	        	var param="&autoSearchFlg=Y" + "&cust_cnt_cd=" + sheetObj.GetCellValue(arr[0], "cust_cnt_cd") + "&cust_seq=" + ComLpad(sheetObj.GetCellValue(arr[0], "cust_seq"),6,"0");
	        	ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240&popYn=Y' + param, 1024, 670, "", "none", true);
	        	break;
	        case IBSEARCH_ASYNC11:
	        	var param="&eq_ofc_cd=" + formObj.usr_ofc_cd.value;
				ComOpenWindowCenter('/opuscntr/ESD_SCE_0056_POP.do?pgmNo=ESD_SCE_0056&popYn=Y'+param, "ESM_BKG_0056", 1040, 650, false);	        	
	        	break;
	    }
	}
	/**
	 * handling process for input validation<br>
	 * @param {Object} sheetObj
	 * @param {Object} formObj
	 * @param {int} sAction
	 * @return boolean
	 */
	function validateForm(sheetObj,formObj,sAction){
	    var formObj=document.form;
	    switch (sAction){
	        case IBSEARCH:
	            if(!ComChkValid(formObj)) return false;
	            // maximum조회기간이 3개월
	            if(formObj.sch_tp[0].checked && !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value, 3))
				{
	            	ComShowCodeMessage("BKG40013", "3");
	        		ComSetFocus(formObj.snd_dt_to);
	        		return false;
	            }
	            break;
	        case IBDOWNEXCEL:
	            if(!ComChkValid(formObj)) return false;
	            // maximum search period is 3 months
	            if(formObj.sch_tp[0].checked && !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value, 3))
				{
	            	ComShowCodeMessage("BKG40013", "3");
	        		ComSetFocus(formObj.snd_dt_to);
	        		return false;
	            }
	        	break;
	    }
	    return true;
	}
	/**
	 * handler after retrieving sheet
	 * setting color of send Fail data<br>
	 * setting Tooltip of Global Date<br>
	 * @param {Object} sheetObj
	 * @param {String} errStr
	 */
	function sheet1_OnSearchEnd(sheetObj, errXml) {
		ComOpenWait(false);
		var startRow=1;
	    var maxRow=sheetObj.LastRow();
	    if (sheetObj.RowCount()< 0) {return;}
	    if (maxRow < 100) {
	        startRow=1;
	    } else if ((maxRow%100.0) == 0 ) {
	        startRow=maxRow - 200 ;
	        if (startRow < 1) {
	            startRow=1;
	        }
	    } else {
	        startRow=maxRow - ((maxRow - 1.0)%200.0);
	    }
	    var vColorRed="#FF0000"; 
	    var vColorBlue="#0000FF";
	    var vColorPink="#FF00C0";
	    var rsltCd="";
	    for (var idx=startRow; idx <= maxRow; idx ++) {
			with (sheetObj) {
				rsltCd=GetCellValue(idx, "bkg_ntc_snd_rslt_cd");
			    if (rsltCd == "F") { // Red
			    	SetCellFontColor(idx,"bkg_ntc_snd_rslt_cd",vColorRed); // *****
					SetCellFontColor(idx,"bkg_ntc_snd_rslt_ctnt",vColorRed); // *****
					SetCellFontColor(idx,"ntc_fax_no_eml",vColorRed); // *****
			    } else if (rsltCd == "S" ) { // blue
			    	SetCellFontColor(idx,"bkg_ntc_snd_rslt_cd",vColorBlue); // *****
			    	SetCellFontColor(idx,"bkg_ntc_snd_rslt_ctnt",vColorBlue); // *****
			    	SetCellFontColor(idx,"ntc_fax_no_eml",vColorBlue); // *****
			    } else { // pink
			    	SetCellFontColor(idx,"bkg_ntc_snd_rslt_cd",vColorPink); // *****
			    	SetCellFontColor(idx,"bkg_ntc_snd_rslt_ctnt",vColorPink); // *****
			    	SetCellFontColor(idx,"ntc_fax_no_eml",vColorPink); // *****
			    }
			    //sheetObj.SetToolTipText(idx, "snd_dt",sheetObj.GetCellValue(idx, "snd_gdt"));
			}
	    }
	}
	    /**
	     * handling Sheet1 double click
	     * @param {ibsheet} sheetObj
	     * @param {int}     Row     
	     * @param {int}     Col     
	     */
	    function sheet1_OnDblClick(sheetObj,Row,Col) {
	       	with(sheetObj) {
	       		switch (ColSaveName(Col)) {
	       		case "cust_nm":
	       	        if(sheetObj.GetRowHeight(Row) == 20){
	       	            sheetObj.SetRowHeight(Row,0);
	       	        } else {
	       	            sheetObj.SetRowHeight(Row,20);
	       	        }
	       			break;
	       		}
	       	}    	
	    }
	/**
	 * handler when Excel search end Excel<br>
	 * @param {Object} sheetObj
	 * @param {String} errStr
	 */
	function sheet2_OnSearchEnd(sheetObj, errXml) {
		sheetObj.Down2Excel(); // *****
		ComOpenWait(false);
	}
	/**
	 * define attribute of element when sch_tp change.<br>
	 * @param {String} vSchTp
	 * @param {Object} formObj
	 */
	function fnToggleSchTp (vSchTp, formObj) {
	    if (vSchTp=="D") {
	        document.getElementsByName("snd_dt_fm")[0].setAttribute("required", true);
	        document.getElementsByName("snd_dt_to")[0].setAttribute("required", true);
	        document.getElementsByName("bl_no")[0].removeAttribute("required");
	        document.getElementsByName("cntr_no")[0].removeAttribute("required");
	    } else if (vSchTp=="B") {
	        document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
	        document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
	        document.getElementsByName("bl_no")[0].setAttribute("required", true);
	        document.getElementsByName("cntr_no")[0].removeAttribute("required");
	    } else if (vSchTp == "C") {
	        document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
	        document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
	        document.getElementsByName("bl_no")[0].removeAttribute("required");
	        document.getElementsByName("cntr_no")[0].setAttribute("required", true);
	    }
	}
	/**
	 * handling click event<br>
	 */
	function objClick() {
	   var objName=event.srcElement.name;
	   var formObj=document.form;
	   switch(objName) {
	       case "sch_tp":
	           var vSchTp="";
	           for (var i=0; i<formObj.sch_tp.length; i++) {
	               if (formObj.sch_tp[i].checked) {
	                   vSchTp=formObj.sch_tp[i].value;
	               }
	           }
	           formObj.sch_tp.value=vSchTp;
	           fnToggleSchTp(vSchTp, formObj);
	           break;
	       case "snd_dt_fm":
	    	   formObj.sch_tp[0].checked=true;
	    	   fnToggleSchTp("D", formObj);
	    	   break;
	       case "snd_dt_to":
	    	   formObj.sch_tp[0].checked=true;
	    	   fnToggleSchTp("D", formObj);
	    	   break;
	       case "bl_no":
	    	   formObj.sch_tp[1].checked=true;
	    	   fnToggleSchTp("B", formObj);
	    	   break;
	       case "cntr_no":
	    	   formObj.sch_tp[2].checked=true;
	    	   fnToggleSchTp("C", formObj);
	    	   break;
	   }
	}
	/**
	 * handling OnKeyPress event<br>
	 */
	function objKeyPress() {
	    var objName=ComGetEvent("name");
	    var formObj=document.form;
	    switch(objName) {
	    	case "vvd":
	    		ComKeyOnlyAlphabet('uppernum');
	    		break;
	    	case "pod_cd":
	    		ComKeyOnlyAlphabet('upper');
	    		break;
	    	case "del_cd":
	    		ComKeyOnlyAlphabet('upper');
	    		break;
	    	case "bl_no":
	    		ComKeyOnlyAlphabet('uppernum');
	    		break;
	    	case "cntr_no":
	    		ComKeyOnlyAlphabet('uppernum');
	    		break;
	    	case "ofc_cd":
	    		ComKeyOnlyAlphabet('upper');
	    		break;
	    	case "snd_dt_fm":
	    		obj_KeyPress(ComGetEvent());
	    		break;
	    	case "snd_dt_to":
	    		obj_KeyPress(ComGetEvent());
	    		break;
	    }
	}
	/**
	 * handling click event
	 */
	function objChange() {
	   var objName=ComGetEvent("name");
	   var formObj=document.form;
	   switch(objName) {
	       case "ntc_knd_auto_cd":
	    	   // CheckBox Disable in case of Manual
	    	   if (formObj.ntc_knd_auto_cd[2].selected == true
	    			   && formObj.ntc_knd_auto_cd[2].value == "M") {
	    		   formObj.ntc_knd_fc_flg.disabled=true;
	    		   formObj.ntc_knd_wo_flg.disabled=true;
	    	   } else {
	    		   formObj.ntc_knd_fc_flg.disabled=false;
	    		   formObj.ntc_knd_wo_flg.disabled=false;
	    	   }
	    	   break;
	   }
	}
	/**
	 * handling Sheet Click Event<br>
	 * show Pick-Up number in case of FOC Clear<br>
	 * @param {Object} sheetObj 
	 * @param {int} PageNo
	 * @param {int} OnePageRows
	 */
	function sheet1_OnClick(sheetObj, row, col) {
	   var colName=sheetObj.ColSaveName(col);
	   var dtValue=sheetObj.GetCellValue(row,col);
	   switch(colName) {
	       case "pic_no_view":
		   if (sheetObj.GetCellValue(row, "foc_flg") == "Y") {
				if (sheetObj.GetCellValue(row,"pkup_no") == "" ) {
	    			   sheetObj.SetCellValue(row, "pkup_no_view" ,"- N/A -",0);
	    		} else {
	    			sheetObj.SetCellValue(row, "pkup_no_view" ,sheetObj.GetCellValue(row,"pkup_no"),0);
	    		}
		   }
	   break;
	   }
	}
	/**
	 * screen change to Pickup Send<br>
	 * @param {Object} sheetObj
	 * @param {Object} formObj
	 */
	function fnMoveToPkupSend(sheetObj, formObj) {
	     var blNo="";
		 var sRowStr=sheetObj.GetSelectionRows("|");
	     if (sRowStr != "0" ) {   
		     var sRowArr=sRowStr.split("|");
		     if(sRowArr.length > 1){
		         ComShowCodeMessage("BKG00362");
		         return;
		     }	
		     if(sRowArr.length == 1) {
		    	 blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");
		     }
	     }
	     var param="&schTp=B" + "&bl_no=" + blNo;
		 ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1066_POP.do?pgmNo=ESM_BKG_1066&mainPage=false' + param, 1024, 690, "", "none", true);
	}
	/**
	 * printing selected row<br>
	 * @param {Object} sheetObj
	 */
	function fnPrintSheet(sheetObj) {
	    var prtSheet=sheetObject1;
	    if(prtSheet.LastRow()== 0) { return ; }
	    var sRowStr=sheetObj.GetSelectionRows("|");
	    if (sRowStr == "0" ) { return ; }
	    var sRowArr=sRowStr.split("|");
	     prtSheet.RemoveAll();
	    for (var idx=0; idx <sRowArr.length; idx++) {
	        fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
	    }
	    prtSheet.DoPrint();
	}

	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
	    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++PageNo);
	}
	
	function sheet2_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
	    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++PageNo);
	}
