/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0054.js
*@FileTitle  : Commodity Note Conversion - Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0054 : business script for ESM_PRI_0054 
     */
	// global variables
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
	var sChgCdVisiable="";
	var openSheet1YN=false;
	var openSheet2YN=false;
	var openSheet3YN=false;
	var runSheet1YN=false;
	var runSheet2YN=false;   
	var isFiredNested=false;
	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0092
	
	/**
     * Event handler processing by button name  <br>
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
				case "btn_retrieve":
					if(validateForm(sheetObject3,formObject,IBSEARCH_ASYNC01)) {
						doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC01);
					}
					break;
				case "btn_close":
					ComClosePopup(); 
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
	* registering IBCombo Object as list <br>
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
		 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    //initializing IBMultiCombo
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    ComPriTextCode2ComboItem(multRuleApplChgTpCdComboValue, multRuleApplChgTpCdComboText, getComboObject(comboObjects, 'note_chg_tp_cd') ,"|","\t" );
 	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                 
               var HeadTitle="Seq.|Commodity Group|Actual Customer";
               HeadTitle +=  "|1|2|3|4|5";
               var headCount=ComCountHeadTitle(HeadTitle);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                      {Type:"Text",      Hidden:0,  Width:680,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq" },
                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd" },
                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" } ];
                
               InitColumns(cols);

               SetEditable(0);
               SetWaitImageVisible(0);
               SetSheetHeight(120);
                     }


                 break;
         	case "sheet2":
         	      with(sheetObj){
                
             var HeadTitle="Seq.|Item|Surcharge|Content";
             HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
             var headCount=ComCountHeadTitle(HeadTitle);

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" } ];
              
             InitColumns(cols);

             SetEditable(0);
             SetWaitImageVisible(0);
             SetColProperty("note_clss_cd", {ComboText:noteClssSdComboText, ComboCode:noteClssSdComboValue} );
             SetSheetHeight(100);
             }


                break;
         	case "sheet3":
         	    with(sheetObj){
               
              var HeadTitle1="|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
              "|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
              "|Receiving\nTerm|Delivery\nTerm|Lane|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
              "|Pay Term|Type|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition" +
              "|S/C Condition|S/C Condition|Updated Date|Updated Staff" +
              "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26";
              var HeadTitle2="|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
              "|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
              "|Receiving\nTerm|Delivery\nTerm|Lane|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
              "|Pay Term|Type|Rate\nIndicator|Per|Cargo\nType|Commodity|Origin|Origin Via|Dest. Via|Dest.|Receiving\nTerm|Delivery\nTerm|Updated Date|Updated Staff" +
              "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5,FrozenCol: 6, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, };
              var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_scg_grp_cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_org_trsp_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dest_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                     {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     	   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_io_ga_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_act_cust_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_usa_svc_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_mst_hbl_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rule_appl_chg_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gen_spcl_rt_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conv_rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"conv_cmdt_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_org_loc_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_org_via_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_dest_via_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_dest_loc_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usr_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
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
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"conv_dest_loc_tp_cd" } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetImageList(0,"img/btns_calendar.gif");
              SetWaitImageVisible(0);
              SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
              SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
              SetColProperty("rule_appl_chg_tp_cd", {ComboText:ruleApplChgTpCdComboText, ComboCode:ruleApplChgTpCdComboValue} );
              SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
              SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
              SetColProperty("bkg_usa_svc_mod_cd", {ComboText:bkgUsaSvcModCdComboText, ComboCode:bkgUsaSvcModCdComboValue} );
              SetColProperty("bkg_rcv_term_cd", {ComboText:bkgRcvTermCdComboText, ComboCode:bkgRcvTermCdComboValue} );
              SetColProperty("bkg_de_term_cd", {ComboText:bkgDeTermCdComboText, ComboCode:bkgDeTermCdComboValue} );
              SetColProperty("bkg_scg_grp_cmdt_cd", {ComboText:bkgScgGrpCmdtCdComboText, ComboCode:bkgScgGrpCmdtCdComboValue} );
              SetColProperty("bkg_org_trsp_mod_cd", {ComboText:bkgOrgTrspModCdComboText, ComboCode:bkgOrgTrspModCdComboValue} );
              SetColProperty("bkg_dest_trsp_mod_cd", {ComboText:bkgDestTrspModCdComboText, ComboCode:bkgDestTrspModCdComboValue} );
              SetColProperty("bkg_mst_hbl_tp_cd", {ComboText:bkgMstHblTpCdText, ComboCode:bkgMstHblTpCdValue} );
              SetColProperty("conv_prc_rcv_term_cd", {ComboText:convPrcRcvTermCdComboText, ComboCode:convPrcRcvTermCdComboValue} );
              SetColProperty("conv_prc_de_term_cd", {ComboText:convPrcDeTermCdComboText, ComboCode:convPrcDeTermCdComboValue} );
              SetColProperty("bkg_io_ga_cd", {ComboText:bkgIoGaCdComboText, ComboCode:bkgIoGaCdComboValue} );
              SetColProperty("bkg_cnl_tz_cd", {ComboText:bkgCnlTzCdComboText, ComboCode:bkgCnlTzCdComboValue} );
              SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
              SetShowButtonImage(2);
              SetSheetHeight(170);
              
              }


             	break;
     	}
	}
   /**
    * initializing IBCOMBO <br>
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "note_chg_tp_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetEnable(0);
	            }
	            break;
	    }
	}
   /**
    * calling function when clicking Special Note's MASTER SHEET <br>
    * retrieving datail by MASTER SHEET's ROW <br>
    */ 
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		if (!openSheet2YN || OldRow != NewRow) {  
			formObj.cmdt_hdr_seq.value=sheetM.GetCellValue(NewRow, "cmdt_hdr_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}
   /**
    * calling function when clicking Special Note's DETAIL SHEET <br>
    * retrieving  CONVERSION by DETAIL SHEET's ROW <br>
    */ 
	function doRowChangeConversion(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		if (!isFiredNested && (!openSheet3YN || OldRow != NewRow)) {    
			if(sheetM.GetCellValue(NewRow, "note_clss_cd") =="D") {
				ComShowCodeMessage("PRI00313");
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				return -1;
			} else {			
				formObj.cmdt_hdr_seq.value=sheetM.GetCellValue(NewRow, "cmdt_hdr_seq");
				formObj.cmdt_note_seq.value=sheetM.GetCellValue(NewRow, "cmdt_note_seq");
				formObj.note_conv_mapg_id.value=sheetM.GetCellValue(NewRow, "note_conv_mapg_id");
				doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
			}
		}
	}
	/**
    * calling function when occurring OnSelectCell Event <br>
    * retrieving again when selecting different row <br>
    */ 
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if(openSheet1YN) {
			runSheet1YN=true;
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
		}
	}
   /**
    * calling function when occurring OnSelectCell Event <br>
    * retrieving again when selecting different row <br>
    */ 
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if(openSheet2YN) {	
			runSheet2YN=true;
			formObj.note_ctnt.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt");
			doRowChangeConversion(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
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
	  				ComOpenWait(true);
					var sArr=opener.getSheetXml(0);
					var sXml=sArr[0];
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					break;
				case IBSEARCHAPPEND: // retrieve
	  				ComOpenWait(true);
					if(openSheet2YN) {
						formObj.f_cmd.value=SEARCH02;
 						sheetObj.DoSearch("ESM_PRI_0054GS.do", FormQueryString(formObj) );
					} else {
						var sArr=opener.getSheetXml(0);
						var sXml=sArr[1];
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}				
					break;
	 			case IBSEARCH_ASYNC01: // retrieve
	  				ComOpenWait(true);
		 			formObj.f_cmd.value=SEARCH03;
 					var sXml=sheetObj.GetSearchData("ESM_PRI_0054GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
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
     * checking validation process of inputed form data <br>
     */
		function validateForm(sheetObj, formObj, sAction) {
			switch (sAction) {
			case IBSEARCH:
				break;
			}
			return true;
		}
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
		if (errMsg == "") {
			openSheet1YN=true; 
			if(!runSheet1YN) {
				sheetObj.SelectCell(formObj.master_seq.value, 1);
			}
		}	
	}
		/**
		 * calling function when occurring OnSearchEnd Event <br>
		 */ 
		function sheet2_OnSearchEnd(sheetObj, errMsg){
			var formObj=document.form;
			if (errMsg == "") {
				openSheet2YN=true;
				if(!runSheet2YN) {
			  		sheetObj.SelectCell(formObj.detail_seq.value, 1);
				}
			}
		} 	 
		/**
		 * calling function when occurring OnSearchEnd Event <br>
		 */ 
		function sheet3_OnSearchEnd(sheetObj, errMsg){
			if(errMsg == "") {
	 		// C/TYPE SET
				comboObjects[0].SetSelectCode(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_chg_tp_cd"),false);
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			 		setStateColor(sheetObj, i);
				}
		 		openSheet3YN=true;
			}
		}
	  	/**
	  	 * setting color in case of state code in Route <br>
	  	 */ 
	 	function setStateColor(sheetObj, Row) {
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
	  	 * setting color function in case of Code is Rule code <br>
	  	 */ 
	 	function setChargeRuleColor(sheetObj, Row) {
	 		var sCodeColor="#FFC8C8";
	 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
	 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
	 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
	 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
	 			&& chgRuleDefCd != "RAC" ) {
	 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
	 		} else {
	 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",sCodeColor);
	 		} 
	 	}
