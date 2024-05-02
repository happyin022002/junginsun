/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0017.js
*@FileTitle : Daily Berth Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class LRS Creation : LRS Creation
     */
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//	var glbYdNmArr = null;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];   //t1sheet1
        var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            if (!ComIsBtnEnable(srcName)) return;  
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject, formObj, IBSAVE);
					break;
				case "btn_group":
					var sUrl="/opuscntr/VOP_VSK_0228.do";
					ComOpenPopup(sUrl, 600, 430, "getGrpVal", "0,0", true);
					//setLaneGrpNmCombo();
					break;
				case "btn_send_gwmail":
					doActionIBSheet(sheetObject, formObj, COMMAND03);
					break;
				case "btn_send_mail":
					doActionIBSheet(sheetObject, formObj, COMMAND04);
					break;
				case "btn_send_edi":
					/*
					 * Transmit if PORT CODE start with KR, and YARD CODE is not KRPUSY0
					 */
					doActionIBSheet(sheetObject, formObj, MULTI02);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
					break;
				case "btn_port":
					doActionIBSheet(sheetObject, formObj, COMMAND01);
					break;
				case "btn_lane":
					doActionIBSheet(sheetObject, formObj, COMMAND02);
					break;
				case "btn_period":
					var cal=new ComCalendarFromTo();
					cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
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
     * POP Callback 함수 
     */
    function getGrpVal( rtnVal ){
    	setLaneGrpNmCombo();
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
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
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
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
        initControl();
        setDirectionCombo();
        setLaneGrpCombo();
        //      document.form.fm_dt.value = ComGetDateAdd(null, "M", -1);
        //		document.form.to_dt.value = ComGetNowInfo();
        document.form.fm_dt.value=ComGetNowInfo();
        document.form.to_dt.value=ComGetDateAdd(null, "D", 7);
		document.form.vps_port_cd.focus();
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
	              var HeadTitle="|CHK|Lane|VVD|TMNL|TMNL|Coastal SKD|Coastal SKD|Coastal SKD|Updated|Updated|TMNL Using Code|TMNL Using Code|Cargo Vol.|Cargo Vol.|Cargo Working Time|Cargo Working Time|Free Time|Remark(s)" +
	              "|UVI No.|PLISM TRS Code|PLISM TRS Code|PLISM TRS Code";
	              var HeadTitle1="|CHK|Lane|VVD|Code|Pier No.|ETA|ETB|ETD|ID|Date|VSL|Voy. No|I/B|O/B|COMM Date|COMP Date|Free Time|Remark(s)" +
	              "|UVI No.|TMNL|VSL|Voy. No";
	              SetConfig( { SearchMode:2, FrozenCol:SaveNameCol(prefix+"yd_cd"), MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:50,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                      {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      //{Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"skd_brth_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",      KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",      KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt_txt",      KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                      {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                      {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_cgo_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                      {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_cgo_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"crn_wrk_cmnc_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"crn_wrk_cmpl_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"free_tm_dt",      KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"win_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uq_vsl_id_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_vsl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                      //{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                          {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skd_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"call_yd_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_etb_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"init_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"init_etb_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"init_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no_upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no_upd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ft_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"crn_wrk_cmnc_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"crn_wrk_cmpl_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"phs_io_rsn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"phs_io_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"init_skd_inp_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_inp_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"noon_rpt_inp_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rpt_inp_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_inp_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"prt_chk_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_snd_knt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_rsn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_rsn_offr_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ttl_dlay_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_act_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_act_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sea_buf_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_buf_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_buf_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_wrk_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lnk_dist",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_eta_dy",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"colnpf_etb_dyame",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_etd_dy",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"nxt_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"nxt_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                              {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
                              ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetColHidden(prefix+"uq_vsl_id_no",1);
	              SetColHidden(prefix+"plism_yd_cd",1);
	              SetColHidden(prefix+"plism_vsl_cd",1);
	              SetColHidden(prefix+"plism_voy_no",1);
	              SetRangeBackColor(1, 3, 1, 23,"#555555");
	              FrozenCols=SaveNameCol(prefix+"yd_cd");
	              resizeSheet();
              }
               break;
        }
    }
	/**
   	 * setting combo initial values and header 
   	 * param : comboObj, comboNo
   	 * adding case as numbers of counting combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {
   	    	case "yd_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(1);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "35");
					SetColWidth(1, "360");
  					SetDropHeight(160);
   		    	}
   	    		break;
	    	case "skd_dir_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "40");
  					SetDropHeight(160);
   		    	}
   	    		break;
	    	case "lane_grp":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "100");
  					SetDropHeight(160);
   		    	}
	    		break;
	    	case "lane_grp_nm":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "60");
  					SetDropHeight(160);
   		    	}
	    		break;
   	    }
   	}
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					if (sheetObj.id == "sheet1"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}
				break;
			case SEARCH01:      //Yard Code Retrieve
				formObj.f_cmd.value=SEARCH01;
		    	var prefix=sheetObj.id + "_";
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var sXml=sheetObj.GetSearchData("VOP_VSK_0017GS.do", sParam);
				return sXml;
				break;
			case SEARCH02:      //Direction Retrieve
				formObj.f_cmd.value=SEARCH02;
		    	var prefix=sheetObj.id + "_";
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var sXml=sheetObj.GetSearchData("VOP_VSK_0017GS.do", sParam);
				return sXml;
				break;
			case SEARCH03:      //UserLaneGroup Retrieve
				formObj.f_cmd.value=SEARCH03;
		    	var prefix=sheetObj.id + "_";
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				var sXml=sheetObj.GetSearchData("VOP_VSK_0017GS.do", sParam);
				return sXml;
				break;
			case IBSAVE:        //save
				saveStatusControl(sheetObj);
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj);//, false,true,-1);
					if (sParam == "") {ComShowCodeMessage("COM130503");return;} //수정됨. 2014.09.18 김성욱 수정
					sParam += "&" + FormQueryString(formObj);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSaveData("VOP_VSK_0017GS.do", sParam);
//					ComOpenWait(false);
//					sheetObj.LoadSaveData(sXml);
					
					var nodeText =  ComGetSelectSingleNode(sXml, "TR-ALL");
					if(nodeText == "OK"){
						ComShowCodeMessage("COM130102", "Data"); // Data Saved Successfully!!
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					} else {
						sheetObj.LoadSaveData(sXml);
					}
					ComOpenWait(false);
				}
				break;
			case MULTI02:        //EDI transmit
				if(validateForm(sheetObj,formObj,sAction)){
					if(ComShowCodeConfirm("VSK01020")){
						var usrInfo="N";
						if(ComShowCodeConfirm("VSK00090")){
							usrInfo="Y";
						}
						var prefix=sheetObj.id + "_";
						var headCnt=sheetObj.HeaderRows();
						var rowCnt=sheetObj.RowCount();
						var totalCnt=headCnt+rowCnt;
						for(var i=headCnt; i<totalCnt; i++){
							if(sheetObj.GetCellValue(i,prefix+"del_chk") == "1"){
//								sheetObj.CellValue(i,prefix+"ibflag") = "U";
								sheetObj.SetRowStatus(i,"U");
							}
						}
						formObj.f_cmd.value=MULTI02;
						formObj.usrInfo.value=usrInfo;
						var SaveStr=ComGetSaveString(sheetObjects);
						var sXml=sheetObj.GetSaveData("VOP_VSK_0017GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSaveData(sXml);
					}
				}
				break;
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
				}
				break;
			case COMMAND01:        //Port Pop-up
				sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
				ComOpenPopup(sUrl, 800, 550, "returnPortHelp", "0,0", true);
                break;
			case COMMAND02:        //Lane Pop-up
				sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.slan_cd.value;
				ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
                break;
			case COMMAND03:        //GW MAIL Transmit
				sendGroupwareMail(sheetObj, formObj);
                break;
			case COMMAND04:
				sendMail(sheetObj, formObj);
				break;
			case SEARCH06:	// Lane Code Check
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH03;
				var sParam="f_cmd=" + formObj.f_cmd.value + 
							"&vsl_slan_cd=" + formObj.slan_cd.value;
				var sXml=sheetObj.GetSearchData("VOP_VSK_0053GS.do", sParam);
				
				ComOpenWait(false);
				return sXml;
			default:
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=sheetObj.LastRow();
		var checkCnt=0;
    	switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(ComIsNull(formObj.vps_port_cd.value)){
					ComShowCodeMessage('VSK00027', "Port Code");
					formObj.vps_port_cd.focus();
					return false;
				} else if(ComIsNull(formObj.fm_dt.value)){
					ComShowCodeMessage('VSK00027', "From date");
					formObj.fm_dt.focus();
					return false;
				} else if(ComIsNull(formObj.to_dt.value)){
					ComShowCodeMessage('VSK00027', "To date");
					formObj.to_dt.focus();
					return false;
				}
				// Check period(in 1 month).
				if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
					ComShowCodeMessage("VSK00105", "1 month");
					return false;
				}
				break;
			case SEARCH01:      //Yard Code Retrieve
				if(ComIsNull(formObj.vps_port_cd.value)){
					if (getComboObject("yd_cd").GetItemCount() > 0) {
						getComboObject("yd_cd").RemoveAll();
					}
					return false;
				}else if(formObj.vps_port_cd.value.length < 5){
					ComShowCodeMessage('VSK00021', "Port:"+formObj.vps_port_cd.value);
					formObj.vps_port_cd.value="";
					formObj.loc_cd.value="";
					
					if (getComboObject("yd_cd").GetItemCount() > 0) {
						getComboObject("yd_cd").RemoveAll();
					}
					
					formObj.vps_port_cd.focus();
					return false;
				}
				break;
			case IBSAVE:      	//save
				if(totCnt > headCnt){
					for(var i=headCnt; i<=totCnt; i++){
						if(sheetObj.GetRowStatus(i) == "U"){
							//Checking ETA date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//Checking ETB date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//Checking ETD date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							if ((sheetObj.GetCellValue(i, prefix+"free_tm_dt")).length > 1 ) {
								if( VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"free_tm_dt")) == false){
									//ComShowCodeMessage( "VSK01018", "Free Time" );
									sheetObj.SelectCell(i, prefix+"free_tm_dt");
									return false;
								}
							}	
							if((sheetObj.GetCellValue(i, prefix+"tml_vsl_cd")).length > 4 ) {
								ComShowCodeMessage( "VSK01019", "Terminal VSL" );
								sheetObj.SelectCell(i, prefix+"tml_vsl_cd");
								return false;
							} 
							if((sheetObj.GetCellValue(i, prefix+"tml_voy_no")).length > 7 ) {
								ComShowCodeMessage( "VSK01019", "Terminal Voy. No" );
								sheetObj.SelectCell(i, prefix+"tml_voy_no");
								return false;
							} 
							if((sheetObj.GetCellValue(i, prefix+"ib_cgo_qty")).length > 6 ) {
								ComShowCodeMessage( "VSK01019", "I/B Cargo Vol." );
								sheetObj.SelectCell(i, prefix+"ib_cgo_qty");
								return false;
							} 
							if((sheetObj.GetCellValue(i, prefix+"ob_cgo_qty")).length > 6 ) {
								ComShowCodeMessage( "VSK01019", "O/B Cargo Vol." );
								sheetObj.SelectCell(i, prefix+"ob_cgo_qty");
								return false;
							} 
							if((sheetObj.GetCellValue(i, prefix+"win_rmk")).length > 4000 ) {
								ComShowCodeMessage( "VSK01019", "Remark(s)" );
								return false;
							} 
							//ETA < ETB < ETD
							if(sheetObj.GetCellValue(i, prefix+"vps_eta_dt") >= sheetObj.GetCellValue(i, prefix+"vps_etb_dt")){
								ComShowCodeMessage("VSK00098", i-headCnt+1, sheetObj.GetCellValue(i, prefix+"vvd"));
								sheetObj.SelectCell(i, prefix+"vps_etb_dt");
								return false;
							} else {
								if(sheetObj.GetCellValue(i, prefix+"vps_etb_dt") >= sheetObj.GetCellValue(i, prefix+"vps_etd_dt")){
									ComShowCodeMessage("VSK00098", i-headCnt+1, sheetObj.GetCellValue(i, prefix+"vvd"));
									sheetObj.SelectCell(i, prefix+"vps_etd_dt");
									return false;
								}
							}
						}
					} // end for
				}
				break;
			case MULTI02:      	//EAI Transmit
				if(ComIsNull(formObj.vps_port_cd.value)){
					ComShowCodeMessage('VSK00027', "Port Code");
					formObj.vps_port_cd.focus();
					return false;
				}
				if(rowCnt < 1){
					ComShowCodeMessage('VSK00043');
					return false;
				}
				for(var i=headCnt; i<=totCnt; i++){
					if(sheetObj.GetCellValue(i,prefix+"del_chk") == "1"){
						//Check
						checkCnt++;
						//ETA < ETB < ETD
						if(sheetObj.GetCellValue(i, prefix+"vps_eta_dt") >= sheetObj.GetCellValue(i, prefix+"vps_etb_dt")){
							ComShowCodeMessage("VSK00098", i+1, sheetObj.GetCellValue(i, prefix+"vvd"));
							sheetObj.SelectCell(i, prefix+"vps_etb_dt");
							return false;
						} else {
							if(sheetObj.GetCellValue(i, prefix+"vps_etb_dt") >= sheetObj.GetCellValue(i, prefix+"vps_etd_dt")){
								ComShowCodeMessage("VSK00098", i+1, sheetObj.GetCellValue(i, prefix+"vvd"));
								sheetObj.SelectCell(i, prefix+"vps_etd_dt");
								return false;
							}
						}
					}
				}
				if(checkCnt == 0){
					ComShowCodeMessage('VSK00020');
					return false;
				}
				break;			
    	}
        return true;
    }
    /**
     * Retrieve
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionSearch(sheetObj, formObj, sAction){
    	formObj.f_cmd.value=SEARCH;
    	var prefix=sheetObj.id + "_";
		var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0017GS.do", sParam);
		ComOpenWait(false);
		showSheetData(sheetObj, formObj, sXml);
		//initButton();
		//All Check Initializing
		sheetObj.CheckAll(prefix+"del_chk",0);
    }
    /**
     * process after retrieve.
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=0;
		if(sXml != null){
			var dataNode =""
			var rootNode=VskGetXmlRootNode(sXml);
//			var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
			
			if(dataNode){
				var totValue=dataNode;
				if(totValue > 0){
					sheetObj.RenderSheet(0);
					
					var ydCds=" |"+ComGetEtcData(sXml, "yd_cd");
					var ydNms=" |"+ComGetEtcData(sXml, "yd_nm");
					var ydTxts="";
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						var ydCdArr=ydCds.split("|");
						var ydNmArr=ydNms.split("|");
						var ydCnt=ydCdArr.length;
						ydTxts=ydCdArr[0] + "\t" + ydNmArr[0];
						for(var i=1; i<ydCnt; i++){
							ydTxts=ydTxts + "|" + ydCdArr[i] + "\t" + ydNmArr[i];
						}
						sheetObj.SetColProperty(prefix+"yd_cd", {ComboText:ydTxts, ComboCode:ydCds} );
						sheetObj.SetColProperty(prefix+"plism_yd_cd", {ComboText:ydTxts, ComboCode:ydCds} );
					}
					sheetObj.LoadSearchData(sXml,{Sync:0} );

					sheetObj.RenderSheet(1);
				}else{
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					formObj.vps_port_cd.focus();
					formObj.vps_port_cd.select();
				}
			}
		}
    }
    /**
     * RMK POPUP CALL BACK 함수 
     * @param sheetObj
     * @param Row
     * @param Col
     * @returns
     */
    function getRmkVal( rtnVal ){
    	var sheetObj = sheetObjects[0];
    	var prefix=sheetObj.id + "_";
    	var formObj=document.form;
    	var Row = sheetObj.GetSelectRow();
    	
    	if( rtnVal != null || rtnVal != ""  ){
    		sheetObj.SetCellValue(Row, prefix+"vps_rmk",rtnVal,0);
			sheetObj.SetCellValue(Row, prefix+"win_rmk",rtnVal.replace(/\n/g, "").replace(/\r/g, ""),0);
    	}
    	
    }
    
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
    function sheet1_OnClick(sheetObj, Row, Col) {
		var prefix=sheetObj.id + "_";
		var formObj=document.form;
		var headCnt=sheetObj.HeaderRows();
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"win_rmk"){
				var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.GetCellValue(Row, prefix+"vps_rmk");
					//var sUrl = "/opuscntr/VOP_VSK_0218.do?remarks=" + sheetObj.CellValue(Row, prefix+"vps_rmk");
				if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
					sUrl=sUrl + "&readonly=true";
				}
				ComOpenPopup(sUrl, 342, 370, "getRmkVal", "0,0", true);
					/*
					if(rVal || rVal == ""){
						sheetObj.SetCellValue(Row, prefix+"vps_rmk",rVal,0);
						sheetObj.SetCellValue(Row, prefix+"win_rmk",rVal.replace(/\n/g, "").replace(/\r/g, ""),0);
					}
					*/
//				}
			}
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var headCnt=sheetObj.HeaderRows();
		var formObj=document.form;
		var prefix=sheetObj.id + "_";
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"yd_cd"){
//				var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
//				sheetObj.CellValue2(Row, prefix+"yd_nm") = glbYdNmArr[idx];
			}else if(colName == prefix+"ib_cgo_qty" || colName == prefix+"ob_cgo_qty"){
				var ibCgoQty=sheetObj.GetCellValue(Row, prefix+"ib_cgo_qty");
				var obCgoQty=sheetObj.GetCellValue(Row, prefix+"ob_cgo_qty");
				sheetObj.SetCellValue(Row, prefix+"cgo_ttl",Number(ibCgoQty) + Number(obCgoQty),0);
//			}else if(colName == prefix+"del_chk"){
//				alert(sheetObj.CellValue(Row, prefix+"ibflag"));
			}else if(colName == prefix+"vps_eta_dt"							// ETA, ETB, ETD change
					|| colName == prefix+"vps_etb_dt"
					|| colName == prefix+"vps_etd_dt"){
				//Checking ETA, ETB, ETD date format
				if(VskIsDateValid(sheetObj, Row, Col) == false){
					return false;
				}
			}
		}
	}
	/**
	 * process after sheet1 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var prefix=sheetObj.id + "_";
		for (var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ )
		{
			if(sheetObj.GetCellValue(i, prefix+"bfr_act_flg") == "X"){
    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"vps_etd_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"skd_brth_no",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_voy_no",0);
    			sheetObj.SetCellEditable(i, prefix+"ib_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"ob_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"free_tm_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_voy_no",0);
    			SetRangeBackColor(1, 5, 1, 9,"#555555");
			} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "A"){
    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"skd_brth_no",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_voy_no",0);
    			sheetObj.SetCellEditable(i, prefix+"ib_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"ob_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"free_tm_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_voy_no",0);
    			SetRangeBackColor(1, 5, 1, 7,"#555555");
			} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "B") {
    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"skd_brth_no",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_voy_no",0);
    			sheetObj.SetCellEditable(i, prefix+"ib_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"ob_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"free_tm_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_voy_no",0);
    			SetRangeBackColor(1, 5, 1, 8,"#555555");
			} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "D") {
    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"vps_etd_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"skd_brth_no",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"tml_voy_no",0);
    			sheetObj.SetCellEditable(i, prefix+"ib_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"ob_cgo_qty",0);
    			sheetObj.SetCellEditable(i, prefix+"free_tm_dt",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_yd_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_vsl_cd",0);
    			sheetObj.SetCellEditable(i, prefix+"plism_voy_no",0);
    			SetRangeBackColor(1, 5, 1, 9,"#555555");
    		}
		}
	}
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	function lane_grp_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if(newCode == "L"){
			document.all.item("div_lane").style.display="inline";
			document.all.item("div_grp").style.display="none";
		}else if(newCode == "G"){
			document.all.item("div_grp").style.display="inline";
			document.all.item("div_lane").style.display="none";
			setLaneGrpNmCombo();
		}
	}
	function yd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var sheetObj=sheetObjects[0];
		sheetObj.RemoveAll();
	}
	function yd_cd_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			var sheetObj=sheetObjects[0];
			var formObj=document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	function skd_dir_cd_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			var sheetObj=sheetObjects[0];
			var formObj=document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	function lane_grp_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			var sheetObj=sheetObjects[0];
			var formObj=document.form;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form); 	
	}

	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
		try {
			var eleObj = ComGetEvent();
			var srcName= ComGetEvent("name");
	        switch(srcName) {
	            case "vps_port_cd":
	            	
	            	if (formObj.vps_port_cd.value.length == 0) return;
	            	formObj.loc_cd.value=formObj.vps_port_cd.value;
	            	if(validateForm(sheetObj, formObj, SEARCH01)){
		            	var sXml=doActionIBSheet(sheetObj,formObj,SEARCH01);
		            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.vps_port_cd.value="";
							//userHideColumnControl(sheetObj);
							formObj.vps_port_cd.focus();
						}else{
							//userHideColumnControl(sheetObj);
							setYdCdCombo(sXml);
							formObj.yd_cd.focus();
						}
	            	}else{
	            		//userHideColumnControl(sheetObj);
	            		formObj.vps_port_cd.focus();
	            	}
	            	sheetObj.RemoveAll();
	            	break;
	            case "slan_cd":
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
					var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
		  		  	
					if(vslSlanNm == ""){
						ComShowCodeMessage('VSK00021', formObj.slan_cd.value);
						formObj.slan_cd.value = "";
						formObj.slan_cd.focus();
					}
					break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * after [Port] Button Click, calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value=rtnDatas;
					formObj.loc_cd.value=rtnDatas;
					sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.vps_port_cd.value="";
					//	formObj.vps_port_cd.focus();
					}else{
						setYdCdCombo(sXml);
						sheetObj.RemoveAll();
					//	formObj.yd_cd.focus();
					}
				}
			}
		}
	}
	/**
	 * After [Lane Code] Button Click, calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */	
	function returnLaneCdHelp(rVal){
		var formObj=document.form;
		
		var rtnObjs  = rVal[0]
		if(rtnObjs){
				if(rtnObjs.length > 0){
					formObj.slan_cd.value=rtnObjs[1];
				}
		}
	}
	
	/**
	 * Hidden Col Setting...
	 * 
	 * @param sheetObj
	 * @param Col
	 * @param colName
	 * @return
	 */
	function setHiddenInitDataProperty(sheetObj, Col, colName){
		var prefix=sheetObj.id+"_";
		with (sheetObj) {
			//data property    [	ROW, 	COL,  	DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, 	Col, 	dtHidden,				0,		daCenter,	true,		prefix+colName,		false,		"",			dfNone,			0,			false,		false);
		}
	}
	/**
	 * Setting Direction Combo
	 * @return
	 */
	function setDirectionCombo(){
		var sheetObj=sheetObjects[0];
		var prefix=sheetObj.id + "_";
    	var sXml=doActionIBSheet(sheetObj, document.form, SEARCH02);
    	var sDirCd="ALL|"+ComGetEtcData(sXml, "direction_cd");
    	var dirCdArr=sDirCd.split("|");
    	appendMultiComboItem(getComboObject("skd_dir_cd"), dirCdArr, dirCdArr, "ALL");
	}
	/**
	 * Setting Lane Code(LaneGrp) Combo
	 * @return
	 */
	function setLaneGrpCombo(){
		var txtArr=new Array();
		txtArr[0]="Lane";
		txtArr[1]="Group";
		var cdArr=new Array();
		cdArr[0]="L";
		cdArr[1]="G";
		appendMultiComboItem(getComboObject("lane_grp"), cdArr, txtArr, "L");
	}
	/**
	 * Setting Lane Grp Nm Code(LaneGrpNm) Combo
	 * @return
	 */
	function setLaneGrpNmCombo(){
		var sheetObj=sheetObjects[0];
		var prefix=sheetObj.id + "_";
    	var sXml=doActionIBSheet(sheetObj, document.form, SEARCH03);
    	var usrLaneGrp=ComGetEtcData(sXml, "usr_lane_grp");
		if(usrLaneGrp != null && usrLaneGrp != undefined && usrLaneGrp != ""){
			var cdArr=usrLaneGrp.split("|");
			var firstCd="";
			if(cdArr != null && cdArr != undefined && cdArr.length > 0){
				firstCd=cdArr[0];
			}
			appendMultiComboItem(getComboObject("lane_grp_nm"), cdArr, cdArr, firstCd);
		}else{
			ComShowCodeMessage("VSK00043");
			getComboObject("lane_grp_nm").RemoveAll();
		}
	}
	/**
	 * Setting Yard Code Combo
	 * @param sXml
	 * @return
	 */
	function setYdCdCombo(sXml){
		var ydKind=ComGetEtcData(sXml, "yd_kind");
		var ydCode=ComGetEtcData(sXml, "yd_cd");
		var ydNm=ComGetEtcData(sXml, "yd_nm");
		var ydTxt=new Array();
		if(ydKind != null && ydKind != undefined && ydKind != ""){
			var ydKindArr=ydKind.split("|");
			var ydCodeArr=ydCode.split("|");
			var ydNmArr=ydNm.split("|");
			var ydCnt=ydKindArr.length;
			ydTxt[0]=ydKindArr[0] + "|" + ydNmArr[0];
			for(var i=1; i<ydCnt; i++){
				ydTxt[i]=ydKindArr[i] + "|" + ydNmArr[i];
			}
			appendMultiComboItem(getComboObject("yd_cd"), ydCodeArr, ydTxt, "");
		}
	}
	/**
	 * Adding item to Mutil Combo
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
		comboObj.RemoveAll();
    	for(var i=0; i<optionCds.length; i++) {
			comboObj.InsertItem(i, optionTxts[i], optionCds[i]);
		}
		comboObj.SetSelectCode(selCode,false);
	}
    /**
     * Returning comboObject with combo id
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt=comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].options.id== comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	return null;
    }
	/**
     * Handling as Port Code
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			formObj.loc_cd.value="";
		}
		return false;
    }
    /**
     * Transmitting Mail
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendGroupwareMail(sheetObj, formObj){
//    	if(sheetObj.SearchRows()==0){
    	if(!checkSelection(sheetObj)){
    		ComShowCodeMessage('VSK00010');
     		return false;
     	}
    	var title="Port Schedule[" + formObj.vps_port_cd.value + "]";
    	formObj.gw_subject.value=title;
    	var contents=getGWMailTextContents(sheetObj, formObj); 
//    			"<BODY>\n" +
//		    	"<TABLE width=100% cellspacing='0' cellpadding='0' >" +
//		    	"<TR align=center face='Courier New'>" +
//		    	"<TD><font size=6 face='Times New Roman'><b>Port Schedule</b></TD>" +
//		    	"</TR>"
//    			"</TABLE>\n" +
//    			"<TABLE style='font-family:arial;font-size:10pt;' border=1>\n" +
//    			setEmailContents(sheetObj) +
//    			"</TABLE>\n" +
//    			"</BODY>";
    	formObj.gw_contents.value=contents;
//    	alert(formObj.gw_contents.value);
    	ComOpenGroupwareMail(sheetObj, formObj);
    }
    /**
     * Transmitting Mail
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendMail(sheetObj, formObj){
//     	if(sheetObj.SearchRows()==0){
    	if(!checkSelection(sheetObj)){
    		ComShowCodeMessage('VSK00010');
    		return false;
    	}
    	var title="Port Schedule[" + formObj.vps_port_cd.value + "]";
    	var contents=getGWMailTextContents(sheetObj, formObj); 
    	formObj.com_subject.value=title;
    	formObj.com_content.value=contents;
//    	ComSendMail(false);
    	sendMailModal();
    	
    }
    
    /**
     * Mail의 Popup 을 띄운다.(from CoMail.js)
     * @fileoverview mail 관련 함수가 정의되어 있다.
     * @author 
     * @return 없음
     */
    function sendMailModal() {
//    	var vFeatures="status=no, width=" + 770 + ", height=" + 680 + ", left=" + (screen.width -770) / 2;
    	var vFeatures="status=no, resizable=yes, width=" + 980 + ", height=" + 680 + ", left=" + (screen.width -980) / 2;
  	    ComPostOpenWindow("/opuscntr/syscommon/common/mail/jsp/COM_MAIL_COMMON_POPUP_MODALESS.jsp", "mail", vFeatures);
    }
    
    /**
     * Changing data of Groupware(Mail) to Text type
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWMailTextContents(sheetObj, formObj){
    	var contents="<BODY>\n";
    	contents=contents + "<div style='font-size: 20px;font-family: Consolas' align='center'>\n";
    	contents=contents + "Port Schedule\n";
    	contents=contents + "</div><BR>\n";
    	contents=contents + "<div style='font-size: 14px;font-family: Consolas'>\n";
    	contents=contents + getGWMailTextDetailContents(sheetObj);
    	contents=contents + "</div><BR>\n";
    	contents=contents + "<div style='font-size: 16px;font-family: Arial'>\n";
    	contents=contents + "Remark\n";
    	contents=contents + "</div></BODY>";
    	return contents;
    }
    /**
     * Returning data of Groupware(Mail) as Text type
     * 
     * @param sheetObj
     * @return
     */
    function getGWMailTextDetailContents(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var totCnt=sheetObj.LastRow();
    	var rowCnt=sheetObj.RowCount();
    	var contents="";
    	var idx=0;
    	if(rowCnt > 0){
//			Seq		Lane	VVD		P/F		ETA		ETB		ETD		Pier	(CCT)	Cargo Vol(I/B O/B).		TMNL Voy	Next Port(ETA)
    		contents=contents + ComRpad("Seq" , 4 , "&nbsp;");
    		contents=contents + ComRpad("Lane", 9 , "&nbsp;");
    		contents=contents + ComRpad("VVD" , 14, "&nbsp;");
//    		contents=contents + ComRpad("P/F", 8, "&nbsp;");
    		contents=contents + ComRpad("ETA" , 18, "&nbsp;");
    		contents=contents + ComRpad("ETB" , 18, "&nbsp;");
    		contents=contents + ComRpad("ETD" , 12, "&nbsp;");
//    		contents = contents + ComRpad("I/B", 5, "&nbsp;");
//    		contents = contents + ComRpad("O/B", 5, "&nbsp;");
//    		contents = contents + ComRpad("Next Port ETA", 25, "&nbsp;");
//    		contents=contents + "Pier";
    		contents=contents + "Terminal";
    		contents=contents + "<BR>\n";
//    		contents=contents + ComRpad("-", 130, "-");
    		contents=contents + ComRpad("-", 114, "-");
    		contents=contents + "<BR>\n";
    		for(var i=headCnt; i<=totCnt; i++){
    			if(sheetObj.GetCellValue(i, prefix+"del_chk")){
    				idx++;
//	    			Seq		Lane	VVD		P/F		ETA		ETB		ETD		Pier	(CCT)	Cargo Vol(I/B O/B).		TMNL Voy	Next Port(ETA)
	    			contents=contents + ComRpad(idx, 4, "&nbsp;");
					contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"slan_cd"), 6, "&nbsp;");
					contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"vsl_cd"), 4, "&nbsp;");
					contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"skd_voy_no"), 1, "&nbsp;");
					contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"skd_dir_cd"), 3, "&nbsp;");
//					contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"pf_etb_dy"), 4, "&nbsp;");
//					contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"pf_etd_dy"), 4, "&nbsp;");
	    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_eta_dt"), 18, "&nbsp;");
	    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_etb_dt"), 18, "&nbsp;");
	    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_etd_dt"), 18, "&nbsp;");
	    			contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"yd_nm"), 20, "&nbsp;");
//	    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"ib_cgo_qty"), 5, "&nbsp;");
//	    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"ob_cgo_qty"), 5, "&nbsp;");
//	    			contents = contents + ComRpad(sheetObj.CellText(i, prefix+"nxt_port_cd"), 6, "&nbsp;");
//	    			contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"nxt_eta_dt"), "ymdhm"), 19, "&nbsp;");
	    			contents=contents + sheetObj.GetCellText(i, prefix+"skd_brth_no");
	    			contents=contents + "<BR>\n";
    			}
    		}// end for
//    		contents=contents + ComRpad("-", 130, "-");
    		contents=contents + ComRpad("-", 114, "-");
    		contents=contents + "<BR>\n";
    	}
    	return contents;
    }
    /**
     * Returning data of Mail as HTML type
     * @param sheetObj
     * @return
     */
    function setEmailContents(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var lastRow=sheetObj.LastRow();
    	var lastCol=sheetObj.LastCol();
    	var contents="";
    	if(rowCnt > 0){
    		for(var i=0; i<=lastRow; i++){
    			if(i < headCnt){
    				//Header Setting.
//    				contents = contents + "	<TR bgcolor='#B5B5FF'>\n";
    				contents=contents + "	<TR>\n";
    			}else{
    				//Body Setting.
    				contents=contents + "	<TR>\n";
    			}
    			for(var j=0; j<=lastCol; j++){
    				if(sheetObj.GetColHidden(j) == false){
    					if(i == 0 && sheetObj.id == "sheet1"){
    						//Header Setting.
    						if(sheetObj.GetCellValue(i, j) == sheetObj.GetCellValue(i+1, j)){
    							contents=contents + "		<TD rowspan=2>" + sheetObj.GetCellValue(i, j) + "</TD>\n";
    						}else{
    							contents=contents + "		<TD>" + sheetObj.GetCellValue(i, j) + "</TD>\n";
    						}
    					}else if(i == 1 && sheetObj.id == "sheet1"){
    						//Header Setting.
    						if(sheetObj.GetCellValue(i, j) != sheetObj.GetCellValue(i-1, j)){
    							contents=contents + "		<TD>" + sheetObj.GetCellValue(i, j) + "</TD>\n";
    						}
    					}else{
    						//Body Setting.
	    					var cellValue="";
	    					if(sheetObj.GetCellValue(i, j) == ""){
	    						cellValue="&nbsp;";
	    					}else{
	    						if(sheetObj.ColSaveName(j) == prefix+"vps_eta_dt"
	    								|| sheetObj.ColSaveName(j) == prefix+"vps_etb_dt"
	    								|| sheetObj.ColSaveName(j) == prefix+"vps_etd_dt"){
	    							if(sheetObj.GetCellValue(i, j) != "" && sheetObj.GetCellValue(i, j).length == 12){
	    								cellValue=ComGetMaskedValue(sheetObj.GetCellValue(i, j), "ymdhm");
	    							}else{
	    								cellValue=sheetObj.GetCellValue(i, j);
	    							}
	    						}else{
	    							cellValue=sheetObj.GetCellValue(i, j);
	    						}
	    					}
	    					contents=contents + "		<TD>" + cellValue + "</TD>\n";
    					}
    				}
    			}
				contents=contents + "	</TR>\n";
    		}
    	}
    	return contents;
    }
    /**
     * in case port with KR input, Showing Plism Column
     * 
     * @param sheetObj
     * @return
     */
    function userHideColumnControl(sheetObj){
    	var prefix=sheetObj.id + "_";
		var formObj=document.form;
		if(formObj.vps_port_cd.value.substring(0, 2) == "KR"){
			sheetObj.SetColHidden(prefix+"uq_vsl_id_no",1);
			sheetObj.SetColHidden(prefix+"plism_yd_cd",0);
			sheetObj.SetColHidden(prefix+"plism_vsl_cd",0);
			sheetObj.SetColHidden(prefix+"plism_voy_no",0);
			sheetObj.SetColHidden(prefix+"free_tm_dt",0); //2014.09.18 김성욱수정 (Hotfix 198)
			
		}else if(formObj.vps_port_cd.value.indexOf("GB") == 0){
			sheetObj.SetColHidden(prefix+"uq_vsl_id_no",0);
			sheetObj.SetColHidden(prefix+"plism_yd_cd",1);
			sheetObj.SetColHidden(prefix+"plism_vsl_cd",1);
			sheetObj.SetColHidden(prefix+"plism_voy_no",1);
			sheetObj.SetColHidden(prefix+"free_tm_dt",1);  //2014.09.18 김성욱수정 (Hotfix 198)
		}else{
			sheetObj.SetColHidden(prefix+"uq_vsl_id_no",1);
			sheetObj.SetColHidden(prefix+"plism_yd_cd",1);
			sheetObj.SetColHidden(prefix+"plism_vsl_cd",1);
			sheetObj.SetColHidden(prefix+"plism_voy_no",1);
			sheetObj.SetColHidden(prefix+"free_tm_dt",1);  //2014.09.18 김성욱수정 (Hotfix 198)
		}
    }
    /**
     * Setting status for blocking Actual Data Update
     * 
     * @param sheetObj
     * @return
     */
    function saveStatusControl(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var totRow=sheetObj.LastRow();
    	if(rowCnt > 0){
    		for(var i=headCnt; i<=totRow; i++){
				if(sheetObj.GetCellValue(i, prefix+"bfr_act_flg") == "X"
				|| sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "D"){
				if(sheetObj.GetRowStatus(i) != "R"){
    					sheetObj.SetRowStatus(i,"R");
    				}
    			}
    		}
    	}
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    /**
     * Check selection
     * @param sheetObj
     * @return boolean
     */
    function checkSelection(sheetObj){
    	var check=false;
    	var prefix=sheetObj.id + "_";
    	var dataRows=sheetObj.RowCount();
    	for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+dataRows; Row++){
    		if(sheetObj.GetCellValue(Row, prefix+"del_chk")){
    			check=true;
    			break;
    		}
    	}
    	return check;
    }