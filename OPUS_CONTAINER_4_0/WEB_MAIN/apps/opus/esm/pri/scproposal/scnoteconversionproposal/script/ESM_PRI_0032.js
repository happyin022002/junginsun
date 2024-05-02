/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0032.js
*@FileTitle  : S/C Special Note Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0032 : business script for ESM_PRI_0032
     */
 // Common Global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	//Visible item list in combo
	var sChgCdVisiable="";
	/* Opening check when loading
	 * -. prohibiting from retrieving by blocking Selectcell() when loading at first time because of retrieving selected row's conversion data on parent window
	 * -. SelectCell() function is called earlier than OnsearchEnd()
	 */
	var openSheet1YN=false;
	var openSheet2YN=false;
	var openSheet3YN=false;
	/* checking sheet when loading
	 * -. It needs to call from onSearchEnd() because SelectCell() function is returned when loading window at first time
	 * -. prohibiting from retrieving by blocking Selectcell() when loading at first time because of retrieving selected row's conversion data on parent window
	 */ 
	var runSheet1YN=false;
	var runSheet2YN=false;   
	var isFiredNested=false;
	//Setting returned data to array after saving main screen because of saving conversion by contents
	var array=new Array();
	//Setting array size
	var arrayCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0003_10
	
	/**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_copy":
					if(validateForm(sheetObject3,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND01);
					}
					break;
				case "btn_paste":
					if(validateForm(sheetObject3,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND02);
					}
					break;
				case "btn_rowadd":
					if(validateForm(sheetObject3,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
					}
					break;
				case "btn_rowcopy":
					if(validateForm(sheetObject3,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
					}
					break;
				case "btn_delete":
					if(validateForm(sheetObject3,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
					}
					break;
				case "btn_retrieve":
					if(validateForm(sheetObject3,formObject,IBSEARCH_ASYNC01)) {
						doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC01);
					}
					break;
				case "btn_save":
					if(validateForm(sheetObject3,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject3,formObject,IBSAVE);
					}
					break;
				case "btn_close":
					ComPopUpReturnValue(array);
					break;

				case "btn_autoword":
					var sheetObj = sheetObjects[2];
					if(sheetObj.RowCount() > 0) {
						var sPreNote = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt");
						var sAutoNote = makeAutoNote(sheetObj, chargeRuleCdComboText, chargeRuleCdComboValue, sPreNote);
						var sNoteCtntLen = ComGetLenByByte(sAutoNote);
						if(sNoteCtntLen != undefined && sNoteCtntLen > 4000){
							ComShowCodeMessage("PRI00307", "Content(4000)");
			 				return false;
						}
						formObject.note_ctnt.value = sAutoNote;
						sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt", sAutoNote);				
						
					}
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
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj Mandatory IBSheet Object
	* @return N/A
	* @author 
	* @version 2009.10.28
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	* registering IBCombo Object as list<br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj Mandatory IBCombo Object
	* @return N/A
	* @author 
	* @version 2009.10.28
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return N/A
    * @author 
    * @version 2009.05.17
    */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
   	 	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;
   	 
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    initControl();
	    //C/TYPE CODE
	    ComPriTextCode2ComboItem(multRuleApplChgTpCdComboValue, multRuleApplChgTpCdComboText, getComboObject(comboObjects, 'note_chg_tp_cd') ,"|","\t" );
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
     * Catching events for Axon event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2015.12.02
     */ 	    
     function initControl() {
    	 axon_event.addListener('change', 'note_ctnt_OnChange', 'note_ctnt');
     }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":
         		with (sheetObj) {
               
	                var HeadTitle="Seq.|Item|Title|1|2|3|4|5|6|7|8|9";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                       {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dp_fix_flg" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(102);
	                SetCountPosition(0);
	                SetWaitImageVisible(0);
	                SetColProperty("note_clss_cd", {ComboText:noteClssSdComboText, ComboCode:noteClssSdComboValue} );
         		}
            	break;
         	case "sheet2":
            	 with (sheetObj) {
                
	                var HeadTitle="|Seq.|Surcharge|Content|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,  EditLen:4000},
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_seq" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_hdr_seq" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt" },
				                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(102);
	                SetCountPosition(0);//HidingTotal
	                SetWaitImageVisible(0);
//	                SetColHidden("chg_cd",1);
	                SetAutoRowHeight(0);

            	 }
                 break;
         	case "sheet3":
         		with (sheetObj) {
	                var HeadTitle1="|Sel.|T|Code|Application|Actual\nEffective Date|Actual\nExpiration Date|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
	                "|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
	                "|Receiving\nTerm|Delivery\nTerm|Lane|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
	                "|Pay Term|Type|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition" +
	                "|S/C Condition|S/C Condition|Updated Date|Updated Staff" +
	                "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33";
	                var HeadTitle2="|Sel.|T|Code|Application|Actual\nEffective Date|Actual\nExpiration Date|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
	                "|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
	                "|Receiving\nTerm|Delivery\nTerm|Lane|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
	                "|Pay Term|Type|Rate\nIndicator|Per|Cargo\nType|Commodity|Origin|Origin Via|Dest. Via|Dest.|Receiving\nTerm|Delivery\nTerm|Updated Date|Updated Staff" +
	                "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5,FrozenCol:6, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                            { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
	                       {Type:"Combo",     Hidden:0, Width:15,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                    KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                    KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	                       {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_scg_grp_cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_org_trsp_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dest_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	                       {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     	     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                       {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                           {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_io_ga_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                       {Type:"PopupEdit", Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_act_cust_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"N|E",	InputCaseSensitive:1 },
	                       {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_usa_svc_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_mst_hbl_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rule_appl_chg_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gen_spcl_rt_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conv_rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"conv_cmdt_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"conv_org_loc_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"conv_org_via_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"conv_dest_via_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"conv_dest_loc_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usr_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_act_cust_seq" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_act_cust_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_cmdt_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_org_loc_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_org_via_loc_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_dest_via_loc_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_dest_loc_tp_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_org_loc_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_org_via_loc_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_dest_via_loc_cnt_cd" },
	                       {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_dest_loc_cnt_cd" } ];
	                 
                	InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(240);
	                SetImageList(0,"img/btns_calendar.gif");
	                SetWaitImageVisible(0);
	                
	                SetColProperty("chg_rule_tp_cd", {ComboText:"|R|S", ComboCode:"|R|C"} );
	                SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
	                SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
	                SetColProperty("rule_appl_chg_tp_cd", {ComboText:ruleApplChgTpCdComboText, ComboCode:ruleApplChgTpCdComboValue} );
	                SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
	                SetColProperty("bkg_prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
	                SetColProperty("rt_op_cd", {ComboText:rtOpCdComboText, ComboCode:rtOpCdComboValue} );
	                SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
	                SetColProperty("bkg_usa_svc_mod_cd", {ComboText:bkgUsaSvcModCdComboText, ComboCode:bkgUsaSvcModCdComboValue} );
	                SetColProperty("bkg_rcv_term_cd", {ComboText:bkgRcvTermCdComboText, ComboCode:bkgRcvTermCdComboValue} );
	                SetColProperty("bkg_de_term_cd", {ComboText:bkgDeTermCdComboText, ComboCode:bkgDeTermCdComboValue} );
	                SetColProperty("conv_prc_cgo_tp_cd", {ComboText:convPrcCgoTpCdComboText, ComboCode:convPrcCgoTpCdComboValue} );
	                SetColProperty("bkg_org_trsp_mod_cd", {ComboText:bkgOrgTrspModCdComboText, ComboCode:bkgOrgTrspModCdComboValue} );
	                SetColProperty("bkg_dest_trsp_mod_cd", {ComboText:bkgDestTrspModCdComboText, ComboCode:bkgDestTrspModCdComboValue} );
	                SetColProperty("bkg_mst_hbl_tp_cd", {ComboText:bkgMstHblTpCdText, ComboCode:bkgMstHblTpCdValue} );
	                SetColProperty("gen_spcl_rt_tp_cd", {ComboText:genSpclRtTpCdComboText, ComboCode:genSpclRtTpCdComboValue} );
	                SetColProperty("conv_prc_rcv_term_cd", {ComboText:convPrcRcvTermCdComboText, ComboCode:convPrcRcvTermCdComboValue} );
	                SetColProperty("conv_prc_de_term_cd", {ComboText:convPrcDeTermCdComboText, ComboCode:convPrcDeTermCdComboValue} );
	                SetColProperty("bkg_rat_ut_cd", {ComboText:bkgRatUtCdComboText, ComboCode:bkgRatUtCdComboValue} );
	                SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
	                SetColProperty("conv_rat_ut_cd", {ComboText:convRatUtCdComboText, ComboCode:convRatUtCdComboValue} );
	                SetColProperty("bkg_scg_grp_cmdt_cd", {ComboText:bkgScgGrpCmdtCdComboText, ComboCode:bkgScgGrpCmdtCdComboValue} );
	                SetColProperty("chg_rule_def_cd", {ComboText:chargeRuleCdComboText, ComboCode:chargeRuleCdComboValue} );
	                SetColProperty("bkg_io_ga_cd", {ComboText:bkgIoGaCdComboText, ComboCode:bkgIoGaCdComboValue} );
	                SetColProperty("bkg_cnl_tz_cd", {ComboText:bkgCnlTzCdComboText, ComboCode:bkgCnlTzCdComboValue} );
	                SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
	                sChgCdVisiable=chargeRuleCdComboText;	//초기로딩값 세팅
	                SetShowButtonImage(2);

         		}
              	break;
     	}
	}
   /**
    * setting intial combo value <br>
    * adding case as numbers of counting combos<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
    * @param {int} comboNo Mandatory IBMultiCombo's sequence
    * @return N/A
    * @author 
    * @version 2009.07.15
    */  
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "note_chg_tp_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            }
	            break;
	    }
	}
   /**
    * Calling function in case of clicking Special Note's MASTER SHEET<br>
    * Retrieving detail by MASTER SHEET's row <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetM Mandatory IBSheet Object
    * @param {ibsheet} sheetD Mandatory IBSheet Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.07.15
    */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		if (!isFiredNested && (!openSheet2YN || OldRow != NewRow)) {  
			//Disable to select DEM/DET in CONVERSION
			if(sheetM.GetCellValue(NewRow, "note_clss_cd") =="D") {
				ComShowCodeMessage("PRI00313");
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				return -1;
			} else {
//no support[implemented common]CLT 				changeSelectBackColor4Master(sheetM, document.form);
				//Activating surcharge item in case of selecting surcharge
				if(sheetM.GetCellValue(NewRow,"note_clss_cd") == "S") {
					sheetD.SetColHidden("chg_cd",0);
				} else {
					sheetD.SetColHidden("chg_cd",1);
				}
				formObj.note_seq.value=sheetM.GetCellValue(NewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}
   /**
    * Calling function in case of clicking Special Note's DETAIL SHEET<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetM Mandatory IBSheet Object
    * @param {ibsheet} sheetD Mandatory IBSheet Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.07.15
    */ 
	function doRowChangeConversion(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		if (!openSheet3YN || OldRow != NewRow) {    	
			formObj.note_seq.value=sheetM.GetCellValue(NewRow, "note_seq");
			formObj.note_ctnt_seq.value=sheetM.GetCellValue(NewRow, "note_ctnt_seq");
			formObj.note_conv_mapg_id.value=sheetM.GetCellValue(NewRow, "note_conv_mapg_id");
			doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
		}
	}
	/**
    * Calling function in case of OnSelectCell event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.07.15
    */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if(openSheet1YN) {	
			runSheet1YN=true;
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
		}
	}
   /**
    * Calling function in case of OnSelectCell event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.07.15
    */ 
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if(openSheet2YN) {
			runSheet2YN=true;
			formObj.note_ctnt.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt");
			doRowChangeConversion(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
		}
		if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
		buttonControl();
	}
  /**
   * Handling Sheet's process <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj Mandatory IBSheet Object
   * @param {form} formObj Mandatory html form object
   * @param {int} sAction Mandatory ,process constant variable
   * @return N/A
   * @author 
   * @version 2009.05.22
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {
				case IBSEARCH: 
	  				ComOpenWait(true);
	  			//Getting parent data when loading screen
					var sXml=opener.getSheetXml(0);
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					break;
				case IBSEARCHAPPEND: 
	  				ComOpenWait(true);
					if(openSheet2YN) {
						formObj.f_cmd.value=SEARCH02;
 						sheetObj.DoSearch("ESM_PRI_0003_10GS.do", FormQueryString(formObj) );
					} else {
						//Getting parent data when loading screen
						var sXml=opener.getSheetXml(1);
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}				
					break;
	 			case IBSEARCH_ASYNC01: //
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			////////////////////////////////////////////////////////////////////////////////
					//In case of no code in Rule,Charge code list in saved ,
					//Setting code combo for Sheet
		 			formObj.f_cmd.value=SEARCH03;
 	  				var sXml=sheetObj.GetSearchData("ESM_PRI_0032GS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
					if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
//						sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sNm ,sCd, ComboCode:"",""} );
						sheetObj.InitDataCombo(0,"chg_rule_def_cd", sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
					}
					sheetObj.LoadSearchData(sXml,{Sync:1} );
	 				break;
	 			case IBSAVE: // 저장  	
		  			if((ComShowCodeConfirm("PRI00001")) ) {
		  				if(sheetObj.IsDataModified()) {
			  				ComOpenWait(true);
				  			formObj.f_cmd.value=MULTI01;
				  			formObj.note_conv_mapg_id.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id");
							var sParam=FormQueryString(formObj);
			  				var sParamSheet=sheetObj.GetSaveString();
			  				if (sParamSheet != "") {
			  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
			  				}
 			  				var sXml=sheetObj.GetSaveData("ESM_PRI_0032GS.do", sParam);
			  				sheetObj.LoadSaveData(sXml);
		  				} else {
			  				ComOpenWait(true);
		  					formObj.f_cmd.value=MODIFY;
		  					formObj.note_conv_mapg_id.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id");
 				  			var sXml=sheetObj.GetSaveData("ESM_PRI_0032GS.do", FormQueryString(formObj));
 				  			sheetObj.LoadSaveData(sXml);
		  				}
		  			//Setting Main's Conversion Flag
						var obj=new Object();
						if(sheetObj.RowCount()> 0){
							obj.note_conv_flg="1";
							obj.master_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_seq");
							obj.detail_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt_seq");
							obj.amdt_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq");
							obj.cnote=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt");
							obj.note_chg_tp_cd=comboObjects[0].GetSelectCode();
						} else {
							obj.note_conv_flg="0";
							obj.master_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_seq");
							obj.detail_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt_seq");
							obj.amdt_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq");
							obj.cnote="";
							obj.note_chg_tp_cd=comboObjects[0].GetSelectCode();
						}
						array[arrayCnt]=obj;
						arrayCnt++;
						
						//2015.06.08
						ComPopUpReturnValue(array);
						
						//2015.06.22
						opener.doSaveNote();
		  			}
	 				break;
	 			case IBINSERT: // Row Add
	 				
	 				var rowcnt = formObj.txt_rowcnt.value;
					if(rowcnt == undefined || rowcnt == "") {
						rowcnt = 1;
					} else if (rowcnt == 0) {
						return;
					} else if (rowcnt > 20) {
						return;
					}
					
					for(var i = 0; i < rowcnt; i++) {
	 				
						var idx=sheetObj.DataInsert();
						sheetObj.SetCellValue(idx, "exp_dt",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"exp_dt"),0);
						sheetObj.SetCellValue(idx, "eff_dt",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"eff_dt"),0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
						sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
						sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
						sheetObj.SetCellValue(idx, "note_conv_mapg_id",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id"),0);
						sheetObj.SetCellValue(idx, "note_conv_tp_cd","P",0);//Proposal Special Note
						sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
						if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"note_clss_cd") == "G") {
							sheetObj.SetCellValue(idx, "chg_rule_tp_cd","C",0);//CHARGE
							sheetObj.SetCellValue(idx, "chg_rule_def_cd","GRI",0);
				 			sheetObj.SetCellValue(idx, "note_conv_chg_cd","GRI",0);
						} else if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"note_clss_cd") == "S") {
							sheetObj.SetCellValue(idx, "chg_rule_tp_cd","C",0);//CHARGE
							sheetObj.SetCellValue(idx, "chg_rule_def_cd",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "chg_cd"),0);
							sheetObj.SetCellValue(idx, "note_conv_chg_cd",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "chg_cd"),0);
						}
						sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
						//In case of existing default value in code
						defaultColumnValidation(sheetObj, idx, "chg_rule_def_cd", sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
						//Editable
						disableColumnValidation(sheetObj, idx, "chg_rule_def_cd", sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					
					}

					
	 				break;
				case IBDELETE: // Delete
					var iCheckRow=sheetObj.FindCheckedRow("chk");
					if(iCheckRow == ""){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}
					iCheckRow=sheetObj.FindCheckedRow("chk");
					if(iCheckRow != "") {
						deleteRowCheck(sheetObj, "chk");
					}
					break;
				case IBCOPYROW:
					copySheetData(sheetObj);
					break;
				case COMMAND01: //COPY
					var iCheckRow=sheetObj.FindCheckedRow("chk");
					if((ComShowCodeConfirm("PRI00012")) ) {
						if(iCheckRow != "") {
							comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
						}
		  				ComOpenWait(true);
						formObj.f_cmd.value=MULTI02;
						var sParam=FormQueryString(formObj);
		  				var sParamSheet=sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		  				}
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0032GS.do", sParam);
						//sheetObj.CheckAll2("chk") = "0";
 		  				sheetObj.LoadSaveData(sXml);
					}
					break;
				case COMMAND02: //PASTE
					if((ComShowCodeConfirm("PRI00016")) ) {
		  				ComOpenWait(true);
						// NOTE CONVERSION RULE
						var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
						var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
						formObj.f_cmd.value=SEARCH04;
 						var sXml=sheetObj.GetSearchData("ESM_PRI_0032GS.do", FormQueryString(formObj));
						var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd"); 
				      	if(arrData != null && arrData.length > 0) {
				      		for(var i=0; i<arrData.length; i++){						
								if (sCd.indexOf(arrData[i][0]) < 0) {
									sCd += "|" + arrData[i][0];
									sNm += "|" + arrData[i][0];
								}
							}					
//							sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sNm ,sCd, ComboCode:"",""} );
				      		sheetObj.InitDataCombo(0,"chg_rule_def_cd", sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
				      		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
				      		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
				      		var arrRow=ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
				      		if(arrRow != null && arrRow.length > 0) {  
				      			for(var i=0; i<arrRow.length; i++) {
					      			sheetObj.SetRowStatus(arrRow[i],"I");
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_seq",maxSeq + i,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_mapg_id",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id"),0);
					      			sheetObj.SetCellValue(arrRow[i], "svc_scp_cd",formObj.svc_scp_cd.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "prop_no",formObj.prop_no.value,0);
									sheetObj.SetCellValue(arrRow[i], "amdt_seq",formObj.amdt_seq.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_tp_cd","P",0);//Proposal Special Note
				      			}
				      		}	
				      	} else {
				      		ComShowCodeMessage("PRI00328");
				      	}
					}
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
    /**
     * Calling function in case of Onchange Event <br>
     * Showing description when selecting Multi ComboBox <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.06.25
     */   
 	function sheet3_OnChange(sheetObj, Row, Col, Value) {
     	var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		switch(colName)
     	{
     		case "chg_rule_tp_cd":
     			var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
     	 		if(Value == "C" && chgRuleDefCd == "ADD") {
     	 			//CHARGE
     	 			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","C",0);
     	 			sheetObj.SetCellValue(Row, "note_conv_chg_cd",chgRuleDefCd,0);
     	 			sheetObj.SetCellValue(Row, "note_conv_rule_cd","",0);
     	 		} else if(Value == "R" && chgRuleDefCd == "ADD") {
     	 			//RULE
     	 			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","R",0);
     	 			sheetObj.SetCellValue(Row, "note_conv_rule_cd",chgRuleDefCd,0);
     	 			sheetObj.SetCellValue(Row, "note_conv_chg_cd","",0);
     	 		}
				defaultColumnValidation(sheetObj, Row, "chg_rule_def_cd", chgRuleDefCd);
				disableColumnValidation(sheetObj, Row, "chg_rule_def_cd", chgRuleDefCd);	
				break;
 			case "chg_rule_def_cd":		
 				if (Value != null && Value != "" && Value.length == 3) {
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"chg_rule_def_cd",Value,0);
 					
 					//Handling default data
 					defaultColumnValidation(sheetObj, Row, Col, Value);
 					//Setting column disable 
 					disableColumnValidation(sheetObj, Row, Col, Value);
 					var sCode=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
 					var sText=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
 					if (sCode.indexOf(Value) < 0) {
 						formObj.f_cmd.value=COMMAND09;
  						sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
 						var arrData=ComPriXml2Array(sXml, "cd|nm");
 						if (arrData != null && arrData.length > 0) {
 							sCode += "|" + Value;
 							sText += "|" + Value;
// 							sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText ,sCode, ComboCode:"",""} );
 							sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
 							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value); 							
 						} else {
 							sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
 						}
 					}
 					insertChargeRuleType(sheetObj, Row);
 				} else {
 					sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
 				}
 				// Rule & Charge Code color
 				//setChargeRuleColor(sheetObj, Row);
 				break;
 			case "eff_dt":	
 				var effDt=ComGetDateAdd(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "eff_dt"), "D", 0, "");
 				var expDt=ComGetDateAdd(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "exp_dt"), "D", 0, "");
		 		if(returnCreationTypeCode()) {
		 			return true;
		 		}
		 		if(sheetObj.GetCellValue(Row, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
				if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				break;
 			case "exp_dt":	
 				var effDt=ComGetDateAdd(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "eff_dt"), "D", 0, "");
 				var expDt=ComGetDateAdd(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "exp_dt"), "D", 0, "");
		 		if(returnCreationTypeCode()) {
		 			return true;
		 		}
		 		if(sheetObj.GetCellValue(Row, "exp_dt") > expDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
				if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
 				break;
			case "bkg_prc_cgo_tp_cd": 	
				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
				if(chgRuleDefCd == "APP"){
					if(Value != "DG") {
						ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
						sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
					}
				}
				if(Value == "DG") {
					sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
				} else {
					sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
					sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
				}
				break;	
 			case "bkg_cmdt_def_cd":	
 				if (Value.length == 5) { //Group Commodity
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
 					
 					var propNo=formObj.prop_no.value;
 					var amdtSeq=formObj.amdt_seq.value;
 					var svcScpCd=formObj.svc_scp_cd.value;
 					formObj.f_cmd.value=SEARCH10;
 					formObj.cd.value=Value;
 					sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
 					var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 					if(arrData[1] != ""){
 						sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd",Value,0);
 						sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd",'G',0);
 					} else {
 						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
 						sheetObj.SetCellValue(Row,"bkg_cmdt_tp_cd","",0);
 						sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 					}
 				} else if (Value.length == 6) {
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
 					
	    			formObj.f_cmd.value=SEARCH08;
	    			formObj.cd.value=ComLpad(Value, 6, "0");
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != "") {
  						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
						sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","C",0);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
  					}
 				} else {
 					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
 					sheetObj.SetCellValue(Row,"bkg_cmdt_tp_cd","",0);
 					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 				}
 	    		break;
 			case "bkg_por_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_por_def_cd",Value,0);
					var sOriDesGbCd="O";
	    			//2015.05.14 validation----------------------
    	    		if(!checkLocation(sheetObj, Row, Value, "bkg_por_def_cd", "bkg_por_tp_cd", "bkg_por_def_cd", sOriDesGbCd)) {
    	    			return;
    	    		}
	    			//-------------------------------------------
 	    				  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
   					sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_por_def_cd") ;
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",0);
 	    		break;	
 			case "bkg_pol_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_pol_def_cd",Value,0);
					var sOriDesGbCd="O";
	    			//2015.05.14 validation----------------------
    	    		if(!checkLocation(sheetObj, Row, Value, "bkg_pol_def_cd", "bkg_pol_def_cd", "bkg_pol_def_cd", sOriDesGbCd)) {
    	    			return;
    	    		}
	    			//-------------------------------------------	  				
 	    		}else{	 
   					sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
   					sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_pol_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",0);
 	    		break;	
 			case "bkg_pod_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_pod_def_cd",Value,0);
 	    			
	    			var sOriDesGbCd="D";
	    			//2015.05.14 validation----------------------
    	    		if(!checkLocation(sheetObj, Row, Value, "bkg_pod_def_cd", "bkg_pod_tp_cd", "bkg_pod_def_cd", sOriDesGbCd)) {
    	    			return;
    	    		}
	    			//-------------------------------------------
	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
   					sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_pod_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",0);
 	    		break;	
 			case "bkg_del_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_del_def_cd",Value,0);
 	    			
	    			var sOriDesGbCd="D";
	    			//2015.05.14 validation----------------------
    	    		if(!checkLocation(sheetObj, Row, Value, "bkg_del_def_cd", "bkg_del_tp_cd", "bkg_del_def_cd", sOriDesGbCd)) {
    	    			return;
    	    		}
	    			//-------------------------------------------
	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
   					sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_del_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",0);
 	    		break;	
 			case "rt_appl_tp_cd":	
				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
				var chgRuleTpCd=sheetObj.GetCellValue(Row, "chg_rule_tp_cd");
				var rtOpCd=sheetObj.GetCellValue(Row, "rt_op_cd");
 				if(Value == "A" || Value == "F") {
 					sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
 					sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 					sheetObj.SetCellEditable(Row, "rt_op_cd",1);
					sheetObj.SetCellEditable(Row, "curr_cd",1);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 				} else {
 					sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 					sheetObj.SetCellValue(Row, "curr_cd","",0);
 					sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 					sheetObj.SetCellEditable(Row, "curr_cd",0);
 					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 				}
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 					&& chgRuleDefCd != "ADD" ) {
 					if( Value == "F") {
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 					}
 					if( Value == "A") {
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 					}
 				} else if(chgRuleDefCd == "ADD" && chgRuleTpCd == "C") {
 					if( Value == "F") {
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 					}
 					if( Value == "A") {
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 					}
 	    		} else if((chgRuleDefCd == "ADD" && chgRuleTpCd == "R") || chgRuleDefCd == "ARB") {
 	    			if (Value == "I" || Value == "A"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 	    			} else if (Value == "S" || Value == "N"){
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 					} else {
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",1);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 						sheetObj.SetCellValue(Row, "curr_cd","USD",0);
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 					}
 	    		} else if(chgRuleDefCd == "NOT") {
 	    			if (Value != "I" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 	    			}
 	    		} else if(chgRuleDefCd == "APP") {
 	    			if (Value != "S" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 	    			}
 	    		} else if(chgRuleDefCd == "TYP") {
 	    			if (Value == "A"){ 	    	    				
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 						sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 	    			} else if (Value == "N"){ 	    	    				
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 	    			}
 	    		}
 	    		break;
 			case "rt_op_cd":
 				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 				var chgRuleTpCd=sheetObj.GetCellValue(Row, "chg_rule_tp_cd");
 				var rtApplTpCd=sheetObj.GetCellValue(Row, "rt_appl_tp_cd");
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "RAC" && chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT"
 	 				&& chgRuleDefCd != "ADD") {
 					if( rtApplTpCd == "F") {
 			    		if(Value == ">" || Value == "<" ) {
 			    			ComShowCodeMessage("PRI00326");
 			    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 			    			sheetObj.SelectCell(Row, "rt_op_cd");
 			    		}
 		    		}
 				} else if(chgRuleDefCd == "ADD" &&chgRuleTpCd == "C") {
 					if( rtApplTpCd == "F") {
 			    		if(Value == ">" || Value == "<" ) {
 			    			ComShowCodeMessage("PRI00326");
 			    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 			    			sheetObj.SelectCell(Row, "rt_op_cd");
 			    		}
 		    		}
 				} else if(chgRuleDefCd == "RAR") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 				} else if(chgRuleDefCd == "RAP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		} else if(chgRuleDefCd == "DOR") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		} else if(chgRuleDefCd == "TYP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		}
 	    		break;	
 			case "conv_cmdt_def_cd":	
 				if (Value.length == 5) { //Group Commodity
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"conv_cmdt_def_cd",Value,0);
 					
 					var propNo=formObj.prop_no.value;
					var amdtSeq=formObj.amdt_seq.value;
					var svcScpCd=formObj.svc_scp_cd.value;
 					formObj.f_cmd.value=SEARCH10;
 					formObj.cd.value=Value;
  					sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
 					var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 					if(arrData[1] != ""){
 						sheetObj.SetCellValue(Row, "conv_cmdt_def_cd",Value,0);
 						sheetObj.SetCellValue(Row, "conv_cmdt_tp_cd",'G',0);
 					} else {
 						sheetObj.SetCellValue(Row,"conv_cmdt_def_cd","",0);
 						sheetObj.SetCellValue(Row,"conv_cmdt_tp_cd","",0);
 						sheetObj.SelectCell(Row,"conv_cmdt_def_cd");
 					} 					
 				} else if (Value.length == 6) {
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"conv_cmdt_def_cd",Value,0);
 					
 					formObj.f_cmd.value=SEARCH08;
	    			formObj.cd.value=ComLpad(Value, 6, "0");
	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"conv_cmdt_def_cd",Value,0);
						sheetObj.SetCellValue(Row, "conv_cmdt_tp_cd","C",0);
  					}else{
	  					sheetObj.SetCellValue(Row,"conv_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"conv_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"conv_cmdt_def_cd");
  					}  					
 				} else {
 					sheetObj.SetCellValue(Row,"conv_cmdt_def_cd","",0);
 					sheetObj.SetCellValue(Row,"conv_cmdt_tp_cd","",0);
 					sheetObj.SelectCell(Row,"conv_cmdt_def_cd");
 				}
 	    		break;
 			case "conv_org_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"conv_org_loc_def_cd",Value,0);
	    			
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"conv_org_loc_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "conv_org_loc_def_cd",arrData[0],0);
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.SetCellValue(Row,"conv_org_loc_def_cd","",0);
 	  					sheetObj.SetCellValue(Row,"conv_org_loc_tp_cd","",0);
 	  					sheetObj.SelectCell(Row,"conv_org_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "conv_org_loc_def_cd","",0);
   					sheetObj.SetCellValue(Row, "conv_org_loc_tp_cd","",0);
   					sheetObj.SelectCell(Row, "conv_org_loc_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"conv_org_loc_def_cd",0);
 	    		break;	
 			case "conv_org_via_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"conv_org_via_loc_def_cd",Value,0);
 	    			
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"conv_org_via_loc_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "conv_org_via_loc_def_cd",arrData[0],0);
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.SetCellValue(Row,"conv_org_via_loc_def_cd","",0);
 	  					sheetObj.SetCellValue(Row,"conv_org_via_loc_tp_cd","",0);
 	  					sheetObj.SelectCell(Row,"conv_org_via_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "conv_org_via_loc_def_cd","",0);
   					sheetObj.SetCellValue(Row, "conv_org_via_loc_tp_cd","",0);
   					sheetObj.SelectCell(Row, "conv_org_via_loc_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"conv_org_via_loc_def_cd",0);
 	    		break;	
 			case "conv_dest_via_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"conv_dest_via_loc_def_cd",Value,0);
 	    			
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"conv_dest_via_loc_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "conv_dest_via_loc_def_cd",arrData[0],0);
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.SetCellValue(Row,"conv_dest_via_loc_def_cd","",0);
 	  					sheetObj.SetCellValue(Row,"conv_dest_via_loc_tp_cd","",0);
 	  					sheetObj.SelectCell(Row,"conv_dest_via_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "conv_dest_via_loc_def_cd","",0);
   					sheetObj.SetCellValue(Row, "conv_dest_via_loc_tp_cd","",0);
   					sheetObj.SelectCell(Row, "conv_dest_via_loc_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"conv_dest_via_loc_def_cd",0);
 	    		break;	
 			case "conv_dest_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			
 	    			Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"conv_dest_loc_def_cd",Value,0);
 	    			
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"conv_dest_loc_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "conv_dest_loc_def_cd",arrData[0],0);
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.SetCellValue(Row,"conv_dest_loc_def_cd","",0);
 	  					sheetObj.SetCellValue(Row,"conv_dest_loc_tp_cd","",0);
 	  					sheetObj.SelectCell(Row,"conv_dest_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "conv_dest_loc_def_cd","",0);
   					sheetObj.SetCellValue(Row, "conv_dest_loc_tp_cd","",0);
   					sheetObj.SelectCell(Row, "conv_dest_loc_def_cd");
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"conv_dest_loc_def_cd",0);
 	    		break;	
 			case "bkg_ts_port_def_cd":	    		
 	    		if (Value.length == 5){
 	    			
 	    			Value=Value.toUpperCase();
 	    			sheetObj.SetCellValue(Row,"bkg_ts_port_def_cd",Value,0);
 	    			
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"bkg_ts_port_def_cd",Value,0);
						sheetObj.SetCellValue(Row,"bkg_ts_port_tp_cd","L",0);
						//Deactivating direct call in case of existing data in T/S PORT
 						sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd",arrData[0],0);
 						sheetObj.SetCellValue(Row,"bkg_ts_port_tp_cd","L",0);
 						//Deactivating direct call in case of existing data in T/S PORT
 						sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
   					}else{
 	  					sheetObj.SetCellValue(Row,"bkg_ts_port_def_cd","",0);
 	  					sheetObj.SetCellValue(Row,"bkg_ts_port_tp_cd","",0);
 	  					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
 	  					sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
   					sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
   					sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"bkg_ts_port_def_cd",0);
 	    		break;	
 			case "bkg_dir_call_flg":
 	    		if (Value == "Y"){
 	    			sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
 	    			sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
 	    			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
 	    		} else {
 	    			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
 	    		}
 	    		break;	
 			case "bkg_slan_cd":
 				if (Value.length == 3){
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_slan_cd",Value,0);
 					
 	    			formObj.f_cmd.value=COMMAND26;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "bkg_slan_cd",arrData[0],0);
   					}else{
 	  					sheetObj.SetCellValue(Row,"bkg_slan_cd","",0);
 	  					sheetObj.SelectCell(Row,"bkg_slan_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_slan_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_slan_cd");
 	    		}
 	    		break;
 			case "bkg_vvd_cd":
 				if (Value.length == 9){
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_vvd_cd",Value,0);
	    			
 					var vslCd=Value.substring(0,4);
 					var skdVoyNo=Value.substring(4,8);
 					var skdDirCd=Value.substring(8,9);
 	    			var sParam="f_cmd="+COMMAND27;
 	    			sParam += "&cd="+vslCd;
 	    			sParam += "&etc1="+skdVoyNo;
 	    			sParam += "&etc2="+skdDirCd;
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if (arrData != null && arrData.length > 0) {
 	  					sheetObj.SetCellValue(Row, "bkg_vvd_cd",arrData[0],0);
 						sheetObj.SetCellValue(Row, "bkg_vsl_cd",vslCd,0);
 						sheetObj.SetCellValue(Row, "bkg_skd_voy_no",skdVoyNo,0);
 						sheetObj.SetCellValue(Row, "bkg_skd_dir_cd",skdDirCd,0);
   					}else{
 						sheetObj.SetCellValue(Row, "bkg_vvd_cd","",0);
 						sheetObj.SetCellValue(Row, "bkg_vsl_cd","",0);
 						sheetObj.SetCellValue(Row, "bkg_skd_voy_no","",0);
 						sheetObj.SetCellValue(Row, "bkg_skd_dir_cd","",0);
   						sheetObj.SelectCell(Row, "bkg_vvd_cd");
   					}
 	    		} else{	
 	    			sheetObj.SetCellValue(Row, "bkg_vvd_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_vsl_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_skd_voy_no","",0);
					sheetObj.SetCellValue(Row, "bkg_skd_dir_cd","",0);
 	    			sheetObj.SelectCell(Row, "bkg_vvd_cd");
 	    		}
 	    		break;
 			case "bkg_act_cust_def_cd": 				
 				if (Value.length > 2){
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_act_cust_def_cd",Value,0);
 					
 					var bkgActCustCntCd=Value.substring(0,2);
 					var bkgActCustSeq=Value.substring(2, 8);
 					if(ComIsAlphabet(bkgActCustCntCd) && ComIsNumber(bkgActCustSeq)){
 						formObj.f_cmd.value=SEARCH01; 	    			
 	 	    			var sParam=FormQueryString(formObj)+"&nmd_cust_flg=Y";
 	 	    			sParam += "&cust_cnt_cd="+bkgActCustCntCd;
 	 	    			sParam += "&cust_seq="+bkgActCustSeq;
 	   	  				var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", sParam);
 	   	  				var arrData=ComPriXml2Array(sXml, "cust_cnt_cd|cust_seq");
 	   	  				if (arrData != null && arrData.length > 0){
 							sheetObj.SetCellValue(Row,"bkg_act_cust_def_cd",bkgActCustCntCd + bkgActCustSeq,0);
 							sheetObj.SetCellValue(Row, "bkg_act_cust_cnt_cd",bkgActCustCntCd,0);
 							sheetObj.SetCellValue(Row, "bkg_act_cust_seq",bkgActCustSeq,0);
 						}else{
 							sheetObj.SetCellValue(Row, "bkg_act_cust_def_cd","",0);
 							sheetObj.SetCellValue(Row, "bkg_act_cust_cnt_cd","",0);
 							sheetObj.SetCellValue(Row, "bkg_act_cust_seq","",0);
 							sheetObj.SelectCell(Row, "bkg_act_cust_def_cd");
 						}
 					}else{
 						sheetObj.SetCellValue(Row, "bkg_act_cust_def_cd","",0);
 						sheetObj.SetCellValue(Row, "bkg_act_cust_cnt_cd","",0);
 						sheetObj.SetCellValue(Row, "bkg_act_cust_seq","",0);
 						sheetObj.SelectCell(Row, "bkg_act_cust_def_cd");
 					}
 				} else {
 					sheetObj.SetCellValue(Row, "bkg_act_cust_def_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_act_cust_cnt_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_act_cust_seq","",0);
					sheetObj.SelectCell(Row, "bkg_act_cust_def_cd");
 				}
 	    		break; 	 
 			case "bkg_imdg_clss_cd":
 				if (Value.length > 0){
 					
 					Value=Value.toUpperCase();
	    			sheetObj.SetCellValue(Row,"bkg_imdg_clss_cd",Value,0);
 					
 	    			formObj.f_cmd.value=COMMAND30;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd",arrData[0],0);
   					}else{
 	  					sheetObj.SetCellValue(Row,"bkg_imdg_clss_cd","",0);
 	  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
 	    		}
 	    		break;
 			case "curr_cd":
 				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 				var chgRuleTpCd=sheetObj.GetCellValue(Row, "chg_rule_tp_cd");
 				if(chgRuleDefCd == "ARB" || (chgRuleDefCd == "ADD" && chgRuleTpCd == "R")){
	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
	 					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
	 					sheetObj.SelectCell(Row, "curr_cd");
	 	    		}
 				}
 	    		break;
     	}
 	}
 	
 	/**
	 * check location
	 * @param sheetObj 		: object of ibsheet
	 * @param rowIdx 		: row index of ibsheet
	 * @param Value        : Cell Value
	 * @param initLocCol 	: column name of ibsheet
	 * @param initLocTpCol : location type cd
	 * @param selColName   : when cell value is not passed by check location, select initLocCol
	 * @param sOriDesGbCd  : Origin or Destination (O or D)
	 * @returns true/false
	 */
 	function checkLocation(sheetObj, Row, Value, initLocCol, initLocTpCol, selColName, sOriDesGbCd) {
		var result = "true";
		
		var sSvcScpCd = sheetObj.GetCellValue(Row, "svc_scp_cd");
		var sPropNo = sheetObj.GetCellValue(Row, "prop_no");
		var sAmdtSeq = sheetObj.GetCellValue(Row, "amdt_seq");
		
		if (Value.length == 2 || Value.length == 3){
    		var sLocType = sheetObj.GetCellValue(Row,initLocTpCol);
			var sParam="f_cmd="+COMMAND32+"&svc_scp_cd="+sSvcScpCd+"&cd="+Value+"&etc1="+sLocType+"&etc2="+sOriDesGbCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm");
			if(arrData == null || arrData.length <= 0) {
				if(Value.length == 2) {
					ComShowCodeMessage("PRI01139", "Country");
				} else if(Value.length == 3) {
					ComShowCodeMessage("PRI01139", "Region");
				}
			    initLocation(sheetObj, Row, initLocCol, initLocTpCol, selColName );
				return false;
			} else {
				sheetObj.SetCellValue(Row, initLocCol, Value, 0);
				var colIdx = sheetObj.SaveNameCol(initLocCol);
				getLocationTypeCode(sheetObj, Row, colIdx, Value.length);
			}
		} else if (Value.length == 4){ 
			var sParam="f_cmd="+COMMAND24+"&cd="+Value;
			sParam += "&etc1=" + PRI_SP_SCP;
			sParam += "&svc_scp_cd=" + sSvcScpCd;
			sParam += "&prop_no=" + sPropNo;
			sParam += "&amdt_seq=" + sAmdtSeq;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");			
			if (arrData == undefined || arrData == null || arrData.length == 0) {
				ComShowCodeMessage("PRI01139", "Group Location");
				initLocation(sheetObj, Row, initLocCol, initLocTpCol, selColName );
				return false;	
			} else {
				sheetObj.SetCellValue(Row, initLocCol, Value, 0);
				var colIdx = sheetObj.SaveNameCol(initLocCol);
				getLocationTypeCode(sheetObj, Row, colIdx, Value.length);
			}
			
		} else if (Value.length == 5){
			var sParam="f_cmd="+COMMAND31+"&svc_scp_cd="+sSvcScpCd+"&cd="+Value+"&etc1="+sOriDesGbCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
			if (arrData == undefined || arrData == null || arrData.length == 0) {
				ComShowCodeMessage("PRI01137");
				initLocation(sheetObj, Row, initLocCol, initLocTpCol, selColName );
				return false;	
			} else {
				sheetObj.SetCellValue(Row, initLocCol, Value, 0);
				var colIdx = sheetObj.SaveNameCol(initLocCol);
				getLocationTypeCode(sheetObj, Row, colIdx, Value.length);
			}
		}
		
		return result;
	}
	
	/**
	 * init value for location
	 * @param sheetObj 		: object of ibsheet
	 * @param rowIdx 		: row index of ibsheet
	 * @param initLocCol 	: column name of ibsheet
	 * @param initLocTpCol : location type cd
	 * @param selColName   : when cell value is not passed by check location, select initLocCol
	 */
	function initLocation(sheetObj, rowIdx, initLocCol, initLocTpCol, selColName) {
		sheetObj.SetCellValue(rowIdx,initLocCol,"",0);
		sheetObj.SetCellValue(rowIdx,initLocTpCol,"",0);
		sheetObj.SelectCell(rowIdx,selColName);
	}
 	
  	/**
  	 * Setting route's type code when iputting data on ROUTE<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @param {int} Len Mandatory ,Cell's Value Length
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.15
  	 */ 
     function getLocationTypeCode(sheetObj, Row, Col, Len) {
     	var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		switch(colName)
     	{
 			case "bkg_por_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","G",0);
 		    	}
 		    	break;
 			case "bkg_pol_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","G",0);
 		    	} 
 		    	break;
 			case "bkg_pod_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","G",0);
 		    	} 
 		    	break;
 			case "bkg_del_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","G",0);
 		    	} 
 		    	break;
 			case "conv_org_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "conv_org_loc_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "conv_org_loc_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "conv_org_loc_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "conv_org_loc_tp_cd","G",0);
 		    	}
 		    	break;
 			case "conv_org_via_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "conv_org_via_loc_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "conv_org_via_loc_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "conv_org_via_loc_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "conv_org_via_loc_tp_cd","G",0);
 		    	}
 		    	break;
 			case "conv_dest_via_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_via_loc_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_via_loc_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_via_loc_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_via_loc_tp_cd","G",0);
 		    	} 
 		    	break;
 			case "conv_dest_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_loc_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_loc_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_loc_tp_cd","R",0);
 		    	}  else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "conv_dest_loc_tp_cd","G",0);
 		    	}
 		    	break;
     	}
     }
  	/**
  	 * Duration's Validation function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.15
  	 */
     function checkDuration(sheetObj) {
 		var formObj=document.form;
 		var rowCount=sheetObj.RowCount();
 		var effDt=ComGetDateAdd(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "eff_dt"), "D", 0, "");
 		var expDt=ComGetDateAdd(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "exp_dt"), "D", 0, "");
 		//이행데이터이면 (I) validation 하지 않는다.
 		if(returnCreationTypeCode()) {
 			return true;
 		}
 		if(rowCount > 0){
 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 				if (sheetObj.GetRowStatus(i) == "D") {
					continue;
				}
 				if(sheetObj.GetCellValue(i, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
 					sheetObj.SelectCell(i, "eff_dt");
 					return false;
 				}
 				if(sheetObj.GetCellValue(i, "eff_dt") > sheetObj.GetCellValue(i, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
 					sheetObj.SetCellValue(i, "exp_dt",expDt,0);
 					sheetObj.SelectCell(i, "eff_dt");
 					return false;
 				}
				if(sheetObj.GetCellValue(i, "exp_dt") > expDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(i, "exp_dt",expDt,0);
 					sheetObj.SelectCell(i, "exp_dt");
 					return false;
 				}
 			}
 		}
 		return true;
     }
     /**
      * handling process for input validation <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *     }
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {form} formObj Mandatory html form object
      * @param {int} sAction Mandatory ,process constant variable
      * @returns bool <br>
      *          true  : Valid<br>
      *          false : Invalid
      * @author 
      * @version 2009.04.17
      */
 	function validateForm(sheetObj, formObj, sAction) {
 		switch (sAction) {
   		case IBSAVE:
   			if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
				return false;
			}
   			if(!checkDuration(sheetObj)) {
   				return false;
   			}
   			//NOTE_CTNT : check length
   			if (sheetObjects[1].IsDataModified()) {
   				for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
   					if(sheetObjects[1].GetRowStatus(i) == "I" || sheetObjects[1].GetRowStatus(i) == "U") {
   						var sNoteCtnt = sheetObjects[1].GetCellValue(i, "note_ctnt");
   						var sNoteCtntLen = ComGetLenByByte(sNoteCtnt);
   						if(sNoteCtntLen != undefined && sNoteCtntLen > 4000){
   							ComShowCodeMessage("PRI00307", "Content(4000)");
   							sheetObjects[1].SelectCell(i, "note_ctnt");
   			 				return false;
   						}
   					}
   				}
   			}
	   		for(var i = sheetObj.HeaderRows(); getValidRowCount(sheetObj) > 0 && i <= sheetObj.LastRow(); i++) {
	   			if(sheetObj.GetRowStatus(i) == "D") {
	  	 			continue;
	  	 		}
	   			if(!checkMandatoryValidation(sheetObj, i)) {
	   				return false;
	   			}
	   			var minCgoWgt = sheetObj.GetCellValue(i, "bkg_min_cgo_wgt");
				var maxCgoWgt = sheetObj.GetCellValue(i, "bkg_max_cgo_wgt");
				if(sheetObj.GetRowStatus(i) != "D" && minCgoWgt != "" && minCgoWgt > 999.999) {
					ComShowCodeMessage("PRI00336", 'Weight(Ton<=)', '999.999');
					sheetObj.SelectCell(i, "bkg_min_cgo_wgt");
					return false;
				}
				if(sheetObj.GetRowStatus(i) != "D" && maxCgoWgt != "" && maxCgoWgt > 999.999) {

					ComShowCodeMessage("PRI00336", 'Weight(<Ton)', '999.999');
					sheetObj.SelectCell(i, "bkg_max_cgo_wgt");
					return false;
				}
	   		}
   			if (sheetObj.IsDataModified()) {
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
					if(sheetObj.GetCellValue(i, "bkg_vvd_cd") != ""  && sheetObj.GetCellValue(i, "bkg_vvd_cd").length != 9 && sheetObj.GetRowStatus(i) != "D") {
		 				sheetObj.SelectCell(i, "bkg_vvd_cd");
		 				ComShowCodeMessage("PRI01065", "VVD", "9");
		 				return false;
		 			}
		 		}
				if(!validateDupCheck(sheetObj)) {
					 return false;
				}
			}
 			break;
   		case IBCOPYROW:
   			/*
   			if(!checkDuration(sheetObj)) {
   				return false;
   			}
   			*/
   			if(sheetObj.RowCount()> 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
   			}
 			break;
   		case IBINSERT:
   			if(sheetObj.RowCount()> 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
   			}
 			break;	  			
 		case COMMAND01:
 			var iCheckRow=sheetObj.FindCheckedRow("chk");
 			if(iCheckRow == "") {
 				ComShowCodeMessage("PRI00327");
 				return false;
 			}
 			break;
 		case COMMAND02:
 			break;
 		}
 		return true;
 	}
 	/**
 	 * function to check duplication of  SHEET's  ROWs <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * validateDupCheck(sheetObj)
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	 * @return boolean
 	 * @author 
 	 * @version 2009.05.20
 	 */  
 	function validateDupCheck(sheetObj) {
 		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|chg_rule_tp_cd|rule_appl_chg_tp_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
 		 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_scg_grp_cmdt_cd|bkg_usa_svc_mod_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_org_trsp_mod_cd" +
 		 		"|bkg_pod_def_cd|bkg_dest_trsp_mod_cd|bkg_del_def_cd|bkg_rcv_term_cd|bkg_de_term_cd" +
 		 		"|bkg_slan_cd|bkg_vvd_cd|bkg_soc_flg|bkg_act_cust_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_dir_call_flg|bkg_mst_hbl_tp_cd|gen_spcl_rt_tp_cd|bkg_ts_port_def_cd" +
 		 		"|bkg_por_tp_cd|bkg_pol_tp_cd|bkg_pod_tp_cd|bkg_del_tp_cd|bkg_esvc_tp_cd|bkg_io_ga_cd|bkg_cnl_tz_cd", false, true);
 		if (rowM != "") {
 			var rowDup=rowM.replace("|", ","); 			
 			//all duplicated row
 			var rowArr=rowDup.split(",");
 			var dupValue="";
 			var temValue="";						
 			var firstEffDt="";
 			var firstExpDt="";						
 			var SecondEffDt="";
 			var SecondExpDt="";
 			var hrows=sheetObj.HeaderRows();
 			for(var i=0; i<rowArr.length; i++) {
				dupValue=sheetObj.GetCellValue(rowArr[i], "chg_rule_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "chg_rule_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "rule_appl_chg_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rat_ut_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_imdg_clss_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_cmdt_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_scg_grp_cmdt_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_usa_svc_mod_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_por_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pol_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_org_trsp_mod_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pod_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_dest_trsp_mod_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_del_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rcv_term_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_de_term_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_slan_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_vvd_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_soc_flg");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_act_cust_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_min_cgo_wgt");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_max_cgo_wgt");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_dir_call_flg");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_mst_hbl_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "gen_spcl_rt_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_ts_port_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_por_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pol_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pod_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_del_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_esvc_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_io_ga_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_cnl_tz_cd");
 				for(var j=0; j<rowArr.length; j++) {
					temValue=sheetObj.GetCellValue(rowArr[j], "chg_rule_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "chg_rule_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "rule_appl_chg_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rat_ut_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_prc_cgo_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_imdg_clss_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_cmdt_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_scg_grp_cmdt_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_usa_svc_mod_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_por_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pol_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_org_trsp_mod_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pod_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_dest_trsp_mod_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_del_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rcv_term_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_de_term_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_slan_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_vvd_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_soc_flg");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_act_cust_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_min_cgo_wgt");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_max_cgo_wgt");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_dir_call_flg");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_mst_hbl_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "gen_spcl_rt_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_ts_port_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_por_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pol_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pod_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_del_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_esvc_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_io_ga_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_cnl_tz_cd");
 					if(i != j) {
	 					if(dupValue == temValue) {
							firstEffDt=sheetObj.GetCellValue(rowArr[i], "eff_dt");
							firstExpDt=sheetObj.GetCellValue(rowArr[i], "exp_dt");
							SecondEffDt=sheetObj.GetCellValue(rowArr[j], "eff_dt");
							SecondExpDt=sheetObj.GetCellValue(rowArr[j], "exp_dt");
	 						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	 							ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j])+1-hrows);
	 						     return false;
	 			 			}
	 			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	 			 				ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j])+1-hrows);
	 						     return false;
	 			 			}
	 					} //if
 					} //if
 				} //for
 			} //for
 		} //if
 		return true;
 	}
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
		var sLgcyIfFlg=formObj.lgcy_if_flg.value;
		if (errMsg == "") {
			openSheet1YN=true; 
			if(!runSheet1YN) {
				sheetObj.SelectCell(formObj.master_seq.value, 1);
			}
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if(sheetObj.GetCellValue(i,"amdt_seq") > 0) {
					if(sheetObj.GetCellValue(i,"src_info_cd") == 'AD' && sLgcyIfFlg != "Y") {
 						sheetObj.SetCellFont("FontStrike", i, "seq", i, sheetObj.LastCol(),1);
 						sheetObj.SetCellFont("FontColor", i, "seq", i, sheetObj.LastCol(),"#FF0000");
					} else if((sheetObj.GetCellValue(i,"src_info_cd") == 'AM' || sheetObj.GetCellValue(i,"src_info_cd") == 'NW') && sLgcyIfFlg != "Y") {
 						sheetObj.SetCellFont("FontColor", i, "seq", i, sheetObj.LastCol(),"#FF0000");
					}
				}			
			}
//no support[implemented common]CLT 			changeSelectBackColor4Master(sheetObj, document.form);
		}	
	}
   	/**
   	 * calling function in case of OnSearchEnd event <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 
   	 * </pre>
   	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
   	 * @param {string} ErrMsg Mandatory from server
   	 * @return N/A
   	 * @author 
   	 * @version 2009.05.20
   	 */ 
   	function sheet2_OnSearchEnd(sheetObj, errMsg){
   		var formObj=document.form;
   		var sAmdtSeq=formObj.amdt_seq.value;
		var sLgcyIfFlg=formObj.lgcy_if_flg.value;
   		if (errMsg == "") {
   		//Hiding previous amended seq
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if(sheetObj.GetCellValue(i, "amdt_seq") != sAmdtSeq) {
 					sheetObj.SetCellFont("FontStrike", i, "seq", i, sheetObj.LastCol(),1);
				}
				if(formObj.amdt_seq.value > 0 && sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == sAmdtSeq && sLgcyIfFlg != "Y") {
 					sheetObj.SetCellFont("FontColor", i, "seq", i, sheetObj.LastCol(),"#FF0000");
				}
				if (sheetObj.GetRowHidden(i)){
					sheetObj.SetRowHidden(i,1);
				}
			}
   			openSheet2YN=true;
   			if(!runSheet2YN) {
   				runSheet2YN=true;
   				formObj.note_ctnt.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt");
   				doActionIBSheet(sheet3, document.form, IBSEARCH_ASYNC01);
   				sheetObj.SelectCell(formObj.detail_seq.value, 1);
   			}
   		}
   	} 	 
 	/**
 	 * calling function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	 * @param {string} ErrMsg Mandatory from server
 	 * @return N/A
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function sheet3_OnSearchEnd(sheetObj, errMsg){ 		
 		if(errMsg == "") {
	 		var formObj=document.form;
	 		var amdtSeq=formObj.amdt_seq.value;
	 		var propStsCd=formObj.prop_sts_cd.value;
	 		var convCfmFlg=formObj.conv_cfm_flg.value;
	 		var ofcAuthYn=formObj.ofc_auth_yn.value;
	 		var currAmdtSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq");
	 		var currSrcInfoCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "src_info_cd");
	 		var n1st = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq");
	 		// C/TYPE SET
	 		comboObjects[0].SetSelectCode(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_chg_tp_cd"),false);
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if(convCfmFlg == "Y" && propStsCd != "F" && ofcAuthYn == "Y" && currAmdtSeq == amdtSeq && currSrcInfoCd != "AD"
					&& currAmdtSeq == n1st) {
					disableColumnValidation(sheetObj, i, "chg_rule_def_cd", sheetObj.GetCellValue(i,"chg_rule_def_cd"));
				} else {
					sheetObj.SetRowEditable(i,0);
				}
				//SEtting color in case of state code on Route
		 		setStateColor(sheetObj, i);
		 		//SEtting color in case of Rule Code on Route 
		 		//setChargeRuleColor(sheetObj, i);
			}
	 		openSheet3YN=true;
 		}
 	}
  	/**
  	 * SEtting color in case of state code on Route<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object 의 Row Index
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.09
  	 */
 	function setStateColor(sheetObj, Row) {
 		// State color
 		var pinkColor="#FFC0CB";
 		if(sheetObj.GetCellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_loc_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_via_loc_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_via_loc_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_loc_def_cd",pinkColor);
 		} 		
 	}
  	/**
  	 * SEtting color in case of Rule Code on Route  <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object 의 Row Index
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code color
 		var sCodeColor="#FFC8C8";
 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "ADD" ) { 			
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
 		} else if(chgRuleDefCd == "ADD" && chgRuleTpCd == "C") {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
 		} else {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",sCodeColor);
 		} 
 	}
	 /**
     * Calling function in case of OnClick event <br>
     * Calling calendar DIV <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value Mandatory
     * @return N/A
     * @author 
     * @version 2009.06.18
     */
      function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
  	    var colname=sheetObj.ColSaveName(Col);
  	    var formObj=document.form;
  	    //2015.05.21 f_cmd init (when popup open, do not send f_cmd)
	    formObj.f_cmd.value = "";
       	switch(colname)
       	{
   	    	case "eff_dt":
   	    		cal=new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
   	    		break;
   	    	case "exp_dt":
   	    		cal=new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
   	    		break;
   	    	case "bkg_cmdt_def_cd":
   	    		var sUrl="/opuscntr/ESM_PRI_4027.do?"
   	   	    		sUrl += "commodity_cmd=CG";
   	   	    		sUrl += "&grp_cd="+PRI_SP_SCP;
   	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
   	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
   	   	    	ComOpenPopup(sUrl, 700, 345, "Callback_findBkgCmdtDefCd", "1,0", true);

   	  			break;
   	    	case "bkg_por_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findBkgPorDefCd", "1,0", true);

   				break;
   	    	case "bkg_pol_def_cd":
 	  			var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findBkgPolDefCd", "1,0", true);

   				break;
   	    	case "bkg_pod_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findBkgPodDefCd", "1,0", true);

   				break;
   	    	case "bkg_del_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findBkgDelDefCd", "1,0", true);

   				break;
   	    	case "conv_cmdt_def_cd":
   	    		var sUrl="/opuscntr/ESM_PRI_4027.do?"
   	   	    		sUrl += "commodity_cmd=CG";
   	   	    		sUrl += "&grp_cd="+PRI_SP_SCP;
   	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
   	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
   	   	    		ComOpenPopup(sUrl, 700, 345, "Callback_findConvCmdtDefCd", "1,0", true);

   	  			break;
   	    	case "conv_org_loc_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findConvOrgLocDefCd", "1,0", true);
		
   				break;
   	    	case "conv_org_via_loc_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findConvOrgViaLocDefCd", "1,0", true);


   				break;
   	    	case "conv_dest_via_loc_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findConvDestViaLocDefCd", "1,0", true);

   				break;
   	    	case "conv_dest_loc_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			sUrl += "&prop_no="+formObj.prop_no.value;
 	  			sUrl += "&amdt_seq="+formObj.amdt_seq.value;
 	  			sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			ComOpenPopup(sUrl, 700, 310, "Callback_findConvDestLocDefCd", "1,0", true);

   				break;
   	    	case "bkg_ts_port_def_cd":	
   				var sUrl="/opuscntr/ESM_PRI_4026.do?";
   				var sParam="&location_cmd=L";
//   				var rtnVal=ComPriOpenWindowCenter(sUrl+sParam, "ESM_PRI_4026", 700, 325, true);
   				ComOpenPopup(sUrl, 700, 310, "Callback_findBkgTsPortDefCd", "1,0", true);
   				break;	
   	    	case "bkg_slan_cd":	
   				var sUrl="/opuscntr/ESM_PRI_4012.do?";
   				ComOpenPopup(sUrl, 480, 380,"Callback_findBkgSlanCd", "1,0", true);
   				
   				break;		
   	    	case "bkg_vvd_cd":	
   				var sUrl="/opuscntr/ESM_PRI_4013.do?";
   				ComOpenPopup(sUrl, 415, 380, "Callback_findBkgVvdCd", "1,0", true);
   				
   				break;	
   	    	case "bkg_act_cust_def_cd":
   	    		var cust_cnt_cd="";
   	    		var cust_seq="";
   	    		if(sheetObj.GetCellValue(Row, Col).length > 2 && sheetObj.GetCellValue(Row, Col).length <= 8) {
   	    			cust_cnt_cd=sheetObj.GetCellValue(Row, Col).substring(0,2);
   	    			cust_seq=sheetObj.GetCellValue(Row, Col).substring(2,8);
   	    		}
 	  	  		var sUrl="/opuscntr/ESM_PRI_4014_POP.do?is_popup=true&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
 	  	  		ComOpenPopup(sUrl, 640, 465, "Callback_findBkgActCustDefCd", "none", true);
   	    		break;
       	}    	 
      }   
      

	  function Callback_findBkgCmdtDefCd(rtnVal) {    
		  var sheetObj=sheet3;
		  if (rtnVal != null){
			  sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
				//it's commodity code in case of 6 digits
			  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_cmdt_tp_cd",rtnVal.tp,0);
		  }
	  }
	  
	  
	  function Callback_findBkgPorDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
			    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_por_tp_cd",rtnVal.tp,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_por_def_cd",rtnVal.cd,1);
				
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_por_cnt_cd",rtnVal.cnt_cd,0);
	  				sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_por_def_cd",pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_por_def_cd",0);
				}
			}
		}
	  
	  function Callback_findBkgPolDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
			if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pol_tp_cd",rtnVal.tp,0);
  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pol_def_cd",rtnVal.cd,1);
  				
  				// Pink as background color in case of State
  				if(rtnVal.tp == "T"){
	 	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pol_cnt_cd",rtnVal.cnt_cd,0);
  					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pol_def_cd", pinkColor);
  				} else {
  					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pol_def_cd", 0);
  				}
			}
	  }
	  
	  function Callback_findBkgPodDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
			    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pod_tp_cd",rtnVal.tp,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pod_def_cd",rtnVal.cd,1);
				
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pod_cnt_cd",rtnVal.cnt_cd,0);
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pod_def_cd", pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pod_def_cd", 0);
				}
			}
	  }
	  
	  function Callback_findBkgDelDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
			    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_del_tp_cd",rtnVal.tp,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_del_def_cd",rtnVal.cd,1);
				
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_del_cnt_cd",rtnVal.cnt_cd,0);
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_del_def_cd", pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_del_def_cd", 0);
				}
			}
	  }
	  
	  function Callback_findConvCmdtDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
				//it's commodity code in case of 6 digits
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_cmdt_tp_cd",rtnVal.tp,0);
			}
	  }
	  
	  function Callback_findConvOrgLocDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_org_loc_def_cd",rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_org_loc_tp_cd",rtnVal.tp,0);
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_org_loc_cnt_cd",rtnVal.cnt_cd,0);
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_org_loc_def_cd", pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_org_loc_def_cd", 0);
				}
			} 	 
	  }
	  
	  function Callback_findConvOrgViaLocDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_org_via_loc_def_cd",rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_org_via_loc_tp_cd",rtnVal.tp,0);
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_org_via_loc_cnt_cd",rtnVal.cnt_cd,0);
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_org_via_loc_def_cd", pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_org_via_loc_def_cd", 0);
				}
			}
	  }
	  
	  function Callback_findConvDestViaLocDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_dest_via_loc_def_cd",rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_dest_via_loc_tp_cd",rtnVal.tp,0);
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_dest_via_loc_cnt_cd",rtnVal.cnt_cd,0);
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_dest_via_loc_def_cd", pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_dest_via_loc_def_cd", 0);
				}
			}
	  }
	  function Callback_findConvDestLocDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  var pinkColor="#FFC0CB";
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_dest_loc_def_cd",rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_dest_loc_tp_cd",rtnVal.tp,0);
				// Pink as background color in case of State
				if(rtnVal.tp == "T"){
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "conv_dest_loc_cnt_cd",rtnVal.cnt_cd,0);
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_dest_loc_def_cd", pinkColor);
				} else {
					sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"conv_dest_loc_def_cd", 0);
				}
			}
	  }
	  function Callback_findBkgTsPortDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_ts_port_tp_cd",rtnVal.tp,0);
			}
	  }
	  function Callback_findBkgSlanCd(rtnVal) {
		  var sheetObj=sheet3;
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.toString(),0);
		  }
	  }
	  function Callback_findBkgVvdCd(rtnVal) {
		  var sheetObj=sheet3;
		  if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.toString(),0);
				sheetObj.SelectCell(sheetObj.GetSelectRow(), sheetObj.GetSelectCol());	
		  }
	  }
	  function Callback_findBkgActCustDefCd(rtnVal) {
		  var sheetObj=sheet3;
		  if (rtnVal != null){
 				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.custCntCd + ComLpad(rtnVal.custSeq, 6, "0"),0);
 				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_act_cust_cnt_cd",rtnVal.custCntCd,0);
 				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_act_cust_seq",rtnVal.custSeq,0);
 		  }
	  }
	  
      /**
       * Checking which item is changable according to selected code<br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {int} Row Mandatory OnClick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index
       * @param {str} Value Mandatory
       * @return N/A
       * @author 
       * @version 2009.07.02
       */ 		
      function sheet3_OnSaveEnd(sheetObj, ErrMsg)  {
		  sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_chg_tp_cd",comboObjects[0].GetSelectCode(),0);
		  //ComPopUpReturnValue(array);
      }
      /**
       * Checking which item is changable according to selected code<br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {int} Row Mandatory OnClick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index
       * @param {str} Value Mandatory
       * @return N/A
       * @author 
       * @version 2009.07.02
       */            
      function disableColumnValidation(sheetObj, Row, Col, Value) {
    	initColumnEditable(sheetObj, Row, Col, Value);
 		switch(Value)
     	{
     		case "APP":	
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",0);
     			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
     			sheetObj.SetCellEditable(Row, "curr_cd",0);
     			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
     			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_scg_grp_cmdt_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_usa_svc_mod_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_por_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_org_trsp_mod_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_dest_trsp_mod_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_del_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_de_term_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_io_ga_cd",0);
				sheetObj.SetCellEditable(Row, "gen_spcl_rt_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
				break;
     		case "NOT":	
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
     			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
     			sheetObj.SetCellEditable(Row, "curr_cd",0);
     			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
     			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
				break;
     		case "RAS":	
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
     			sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
     			sheetObj.SetCellEditable(Row, "curr_cd",0);
     			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
     			sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
				break;
 			case "ARB":	
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.SetCellEditable(Row, "curr_cd",0);
				}				
 				break;
 			case "ADD":
 				if(sheetObj.GetCellValue(Row, "chg_rule_tp_cd") == "R") {
	 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
	 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
	 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
					sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
					sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
					sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
					sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
					sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
					sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
					sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
					sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
					sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
					if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
							|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
					} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
						sheetObj.SetCellEditable(Row, "curr_cd",0);
					}
 				} else {								
 					sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
 					sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
 					if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
 						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
 							|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 					} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 					} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 					}
 				}
 				break;
 			case "TYP":
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
 				break;
 			case "RAR":
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
 				break;
 			case "RAP":
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
 				break;
 			case "DOR":
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
 				break;
 			case "RAC":	
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
				break;
 			default:  //SURCHARGE 
				sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.SetCellEditable(Row, "curr_cd",0);
				}
 				break;
     	}
  	}
      /**
       * Initializing editable for visible item on sheet<br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	initColumnEditable(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {int} Row Mandatory OnClick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index
       * @param {str} Value Mandatory
       * @return N/A
       * @author 
       * @version 2009.07.02
       */            
       function initColumnEditable(sheetObj, Row, Col, Value) {  
			sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",1);
    	   	sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",1);
	   	   	sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",1);
	   	   	sheetObj.SetCellEditable(Row, "bkg_prc_cgo_tp_cd",1);
	   	   	sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",1);
	   	   	if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
	   	   		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
	   	   	} else {
	   	   		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
	   	   	}
			sheetObj.SetCellEditable(Row, "rt_op_cd",1);
			sheetObj.SetCellEditable(Row, "curr_cd",1);
			sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
			sheetObj.SetCellEditable(Row, "pay_term_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_scg_grp_cmdt_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_usa_svc_mod_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_por_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_org_trsp_mod_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_dest_trsp_mod_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_del_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_rcv_term_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_de_term_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_slan_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_vvd_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_soc_flg",1);
			sheetObj.SetCellEditable(Row, "bkg_act_cust_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
			if(sheetObj.GetCellValue(Row, "bkg_ts_port_def_cd") != "") {
				sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
			} else {
				sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
			}
			if(sheetObj.GetCellValue(Row, "bkg_dir_call_flg") == "Y") {
				sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
			} else {
				sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
			}
			sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",1);
			sheetObj.SetCellEditable(Row, "gen_spcl_rt_tp_cd",1);
			sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",1);
			sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",1);
			sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",1);
			sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",1);
			sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",1);
			sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",1);
			sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",1);
			sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",1);
			sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_io_ga_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_cnl_tz_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_esvc_tp_cd",1);
   	}
       /**
        * Initializing editable to false for visible item on sheet<br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditableFalse(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj Mandatory IBSheet Object
        * @param {int} Row Mandatory OnClick ,Cell's Row Index
        * @param {int} Col Mandatory OnClick ,Cell's Column Index
        * @param {str} Value Mandatory
        * @return N/A
        * @author 
        * @version 2010.03.03
        */            
       function initColumnEditableFalse(sheetObj, Row, Col, Value) {
           	sheetObj.SetCellEditable(Row, "chk",0);
           	sheetObj.SetCellEditable(Row, "chg_rule_tp_cd",0);
           	sheetObj.SetCellEditable(Row, "chg_rule_def_cd",0);
           	sheetObj.SetCellEditable(Row, "eff_dt",0);
           	sheetObj.SetCellEditable(Row, "exp_dt",0);
    	   	sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
	   	   	sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",0);
	   	   	sheetObj.SetCellEditable(Row, "bkg_prc_cgo_tp_cd",0);
	   	   	sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
	   	   	sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_scg_grp_cmdt_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_usa_svc_mod_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_por_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_org_trsp_mod_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_dest_trsp_mod_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_del_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_rcv_term_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_de_term_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_slan_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_vvd_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_soc_flg",0);
			sheetObj.SetCellEditable(Row, "bkg_act_cust_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_mst_hbl_tp_cd",0);
			sheetObj.SetCellEditable(Row, "gen_spcl_rt_tp_cd",0);
			sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
			sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
			sheetObj.SetCellEditable(Row, "conv_cmdt_def_cd",0);
			sheetObj.SetCellEditable(Row, "conv_org_loc_def_cd",0);
			sheetObj.SetCellEditable(Row, "conv_org_via_loc_def_cd",0);
			sheetObj.SetCellEditable(Row, "conv_dest_via_loc_def_cd",0);
			sheetObj.SetCellEditable(Row, "conv_dest_loc_def_cd",0);
			sheetObj.SetCellEditable(Row, "conv_prc_rcv_term_cd",0);
			sheetObj.SetCellEditable(Row, "conv_prc_de_term_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_io_ga_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_cnl_tz_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_esvc_tp_cd",0);
   	}       
       /**
        *Checking mandatory column according to selected code type<br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	checkMandatoryValidation(sheetObj, Row);
        * </pre>
        * @param {ibsheet} sheetObj Mandatory IBSheet Object
        * @param {int} Row Mandatory OnClick ,Cell's Row Index
        * @return N/A
        * @author 
        * @version 2009.07.02
        */ 		
  	function checkMandatoryValidation(sheetObj, Row) {
  		var RowCount=sheetObj.RowCount();
  		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
  		var chgRuleTpCd=sheetObj.GetCellValue(Row, "chg_rule_tp_cd");
  		if(chgRuleTpCd == "" && chgRuleDefCd != "") {
  			ComShowCodeMessage("PRI00316","Code Type");
			sheetObj.SelectCell(Row, "chg_rule_tp_cd");
			return false;
  		}
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "ADD") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "curr_cd") == "") {
 				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F"){
					ComShowCodeMessage("PRI00316","Currency");
	 				sheetObj.SelectCell(Row, "curr_cd");
	 				return false;
				}
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") != "0" && sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F") {
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 Mandatory입력항목 지정.(7/21)	
// 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F")) {
// 				ComShowCodeMessage("PRI00316","Amount");
// 				sheetObj.SelectCell(Row, "frt_rt_amt");
// 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
 			// In case of fixed amount or adjust in case of SURCHARGE CODE
 				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			}
 		} else if (chgRuleDefCd == "APP") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "NOT") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}		
 		} else if (chgRuleDefCd == "RAS") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001) {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "ARB") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ADD" && chgRuleTpCd == "R") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ADD" && chgRuleTpCd == "C") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "curr_cd") == "") {
 				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F"){
					ComShowCodeMessage("PRI00316","Currency");
	 				sheetObj.SelectCell(Row, "curr_cd");
	 				return false;
				}
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") != "0" && sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F") {
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
 			// In case of fixed amount or adjust in case of SURCHARGE CODE
 				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			}
 		} else if (chgRuleDefCd == "TYP") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
 				ComShowCodeMessage("PRI00316","Per");
 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rule_appl_chg_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Type");
 				sheetObj.SelectCell(Row, "rule_appl_chg_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "conv_rat_ut_cd") == "") {
 				ComShowCodeMessage("PRI00316","Per (in S/C)"); 
 				sheetObj.SelectCell(Row, "conv_rat_ut_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAR") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_por_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_pol_def_cd") == ""
 				&& sheetObj.GetCellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_del_def_cd") == "") {
 				//mandatory input - POR or POL or POD or DEL		 					 				
 				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
 				sheetObj.SelectCell(Row, "bkg_por_def_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "conv_org_loc_def_cd") == "" && sheetObj.GetCellValue(Row, "conv_org_via_loc_def_cd") == ""
 				&& sheetObj.GetCellValue(Row, "conv_dest_via_loc_def_cd") == "" && sheetObj.GetCellValue(Row, "conv_dest_loc_def_cd") == "") {
 				//mandatory input - Origin or Origin Via or Dest Via or Dest		 				 				
 				ComShowCodeMessage("PRI01052","Origin, Origin Via, Dest Via, Dest");
 				sheetObj.SelectCell(Row, "conv_org_loc_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAP") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_cmdt_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_scg_grp_cmdt_cd") == "") {
 				ComShowCodeMessage("PRI00334","Commodity","GRI Commodity");
 				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "conv_cmdt_def_cd") == "") {
 				ComShowCodeMessage("PRI00316","Commodity (in S/C)");
 				sheetObj.SelectCell(Row, "conv_cmdt_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "DOR") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rcv_term_cd") == "" && sheetObj.GetCellValue(Row, "bkg_de_term_cd") == "") {
 				ComShowCodeMessage("PRI00334","Receiving Term","Delivery Term");
 				sheetObj.SelectCell(Row, "bkg_rcv_term_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "conv_prc_rcv_term_cd") == "" && sheetObj.GetCellValue(Row, "conv_prc_de_term_cd") == "") {
 				ComShowCodeMessage("PRI00334","Receiving Term (in S/C)","Delivery Term (in S/C)");
 				sheetObj.SelectCell(Row, "conv_prc_rcv_term_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAC") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cargo Type");
 				sheetObj.SelectCell(Row, "bkg_prc_cgo_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "conv_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cargo Type (in S/C)"); 
 				sheetObj.SelectCell(Row, "conv_prc_cgo_tp_cd");
 				return false;
 			}
 		}
 		return true;
  	}
    /**
     * Function to validate Default column<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	defaultColumnValidation(sheetObj, Row, Col, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index
     * @param {str} Value Mandatory 
     * @return N/A
     * @author 
     * @version 2009.07.02
     */ 	
  	function defaultColumnValidation(sheetObj, Row, Col, Value) {
    	initColumnValue(sheetObj, Row);
 		switch(Value)
     	{	
 			case "TYP":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","D4",0);
 				sheetObj.SetCellValue(Row, "conv_rat_ut_cd","D4",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				sheetObj.SetCellValue(Row, "rule_appl_chg_tp_cd","O",0);
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 				break;
 			case "NOT":
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
 				break;
 			case "RAS":
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "RAR":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "RAP":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "DOR":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "ARB":
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
 			case "ADD":
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
 			case "RAC":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			default:
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
     	}
  	}
    /**
     * Initializing column value<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	initColumnValue(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @return N/A
     * @author 
     * @version 2009.07.02
     */	
   	function initColumnValue(sheetObj, Row) {
     	  sheetObj.SetCellValue(Row, "rule_appl_chg_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "rt_appl_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "rt_op_cd","",0);
     	  sheetObj.SetCellValue(Row, "curr_cd","",0);
     	  sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
     	  sheetObj.SetCellValue(Row, "pay_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "gen_spcl_rt_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_scg_grp_cmdt_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_usa_svc_mod_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_org_trsp_mod_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_dest_trsp_mod_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_rcv_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_de_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_slan_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_vsl_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_skd_voy_no","",0);
     	  sheetObj.SetCellValue(Row, "bkg_skd_dir_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_soc_flg","",0);
     	  sheetObj.SetCellValue(Row, "bkg_act_cust_cnt_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_act_cust_seq","",0);
     	  sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_min_cgo_wgt","",0);
     	  sheetObj.SetCellValue(Row, "bkg_max_cgo_wgt","",0);
     	  sheetObj.SetCellValue(Row, "bkg_dir_call_flg","",0);
     	  sheetObj.SetCellValue(Row, "bkg_mst_hbl_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_rat_ut_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_prc_cgo_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_cmdt_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_cmdt_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_org_loc_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_org_loc_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_org_via_loc_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_org_via_loc_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_dest_via_loc_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_dest_via_loc_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_dest_loc_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_dest_loc_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_prc_rcv_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_prc_de_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_vvd_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_act_cust_def_cd","",0);
	 	  sheetObj.SetCellValue(Row, "bkg_io_ga_cd","",0);
	 	  sheetObj.SetCellValue(Row, "bkg_cnl_tz_cd","",0);
	 	  sheetObj.SetCellValue(Row, "bkg_esvc_tp_cd","",0);
   	}
    /**
     * Multi-copying sheet's row<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copySheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return 
     * @author 
     * @version 
     */	
 	function copySheetData(sheetObj) {
  		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
  		var sCheckRow=sheetObj.FindCheckedRow("chk");
		if(sCheckRow == ""){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
		}
		sCheckRow=sheetObj.FindCheckedRow("chk");
 		var aCheckArr=ComRtrim(sCheckRow, '|').split("|");
 		if(aCheckArr != null && aCheckArr.length > 0) {
 			for(var i=aCheckArr.length-1; i>=0; i--) {
 				sheetObj.SetSelectRow(aCheckArr[i]);
 				var idx=sheetObj.DataCopy();
      			sheetObj.SetCellValue(idx, "note_conv_seq",maxSeq,0);
      			sheetObj.SetCellValue(idx, "chk",0,0);
      			// State color
      			setStateColor(sheetObj, idx);
      			// Rule & Charge Code color
      			//setChargeRuleColor(sheetObj, idx);
      			maxSeq++;
 			}
 		}
 	}
 	/**
      * Seperated function according to charge rule type when selecting CODE COMBO 
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} Row Mandatory OnClick
      * @return 
      * @author 
      * @version 
      */	
 	function insertChargeRuleType(sheetObj, Row) {
 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 		var chgRuleTpCd=sheetObj.GetCellValue(Row, "chg_rule_tp_cd");
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "ADD") {
 			//CHARGE
 			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","C",0);
 			sheetObj.SetCellValue(Row, "note_conv_chg_cd",chgRuleDefCd,0);
 			sheetObj.SetCellValue(Row, "note_conv_rule_cd","",0);
 		} else {
 			//RULE
 			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","R",0);
 			sheetObj.SetCellValue(Row, "note_conv_rule_cd",chgRuleDefCd,0);
 			sheetObj.SetCellValue(Row, "note_conv_chg_cd","",0);
 		}
 	}
   	 /**
       * Returning if proposal data is legacy <br>
       * <br><b>Example :</b>
       * <pre>
       *	returnCreationTypeCode();
       * </pre>
       * @param 
       * @return 
       * @author 
       * @version 
       */
      function returnCreationTypeCode() {
    		var formObj=document.form;
     		var prcPropCreTpCd=formObj.prc_prop_cre_tp_cd.value;
     		if(prcPropCreTpCd == "I"){
     			//CHLOE : 해당 로직은 필요에 따라 true or false를 골라야 할듯 함
	  			return false;
     		} else {
     			return false;
     		}
      }
	/**
    * Controlling button authority <br>
    * <br><b>Example :</b>
    * <pre>
    * buttonControl()
    * </pre>
    * @param 
    * @return 
    * @author
    * @version
    */
 	function buttonControl(){
 		var formObj=document.form;
 		var amdtSeq=formObj.amdt_seq.value;
 		var propStsCd=formObj.prop_sts_cd.value;
 		var convCfmFlg=formObj.conv_cfm_flg.value;
 		var ofcAuthYn=formObj.ofc_auth_yn.value;
		//ofcAuthYn = "Y";
 		//propStsCd = "Q";
		try{	
			/* Condition to activate button
			 * 1. In case of checking Conversion check of History screen as "previous seq"
			 * 2. In case of not filed status of main
			 * 3. In case selected note content row's amdt_seq is same with current amdt_seq
			 * 4. In case of no Amend Delete 
			 */
			if(convCfmFlg == "Y" && propStsCd != "F" && ofcAuthYn == "Y"
				&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq") == amdtSeq
				&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "src_info_cd") != "AD"
				&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") == amdtSeq ) {
				ComBtnEnable("btn_copy");
				ComBtnEnable("btn_paste");
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowcopy");
				ComBtnEnable("btn_delete");
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_autoword");
				$("#note_ctnt").attr("readonly", false);
			} else {
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_autoword");
				$("#note_ctnt").attr("readonly", true);
			}
		} catch (e) {}
	}

 	/**
     * Event in case of modifying Note value<br>
     * <br><b>Example :</b>
     * <pre>
     *    note_ctnt_OnChange();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2015.12.02
     */  
     function note_ctnt_OnChange(){
    	 var formObject = document.form;
    	 var sAutoNote = formObject.note_ctnt.value;
	     sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt", sAutoNote);
     }