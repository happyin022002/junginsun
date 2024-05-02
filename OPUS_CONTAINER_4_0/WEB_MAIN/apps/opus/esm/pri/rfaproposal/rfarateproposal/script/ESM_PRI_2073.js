/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2073.js
*@FileTitle  : RFA Proposal Inquiry - Rate (Route Note)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var sChgCdVisiable="";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){	       
		      var HeadTitle="|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|rout_note_seq|Content|Conversion|Conversion|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   HeaderCheck:0, EditLen:-1 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetShowButtonImage(0);
		      SetAutoRowHeight(0);
		      SetSheetHeight(120);
	      }
		    break;
        case 2:      //t1sheet1 init
            with(sheetObj){
		          var HeadTitle="|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
		          "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
		          "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          (headCount, 5, 0, true);
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Date",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Date",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
			                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
			                 {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
			                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" } ];
			           
		          InitColumns(cols);
		          SetEditable(0);
		          SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
		          SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
		          SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
		          SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
		          SetColProperty("bkg_hngr_bar_tp_cd", {ComboText:bkgHngrBarTpCdComboText, ComboCode:bkgHngrBarTpCdComboValue} );
		          SetColProperty("bkg_cnl_tz_cd", {ComboText:bkgCnlTzCdComboText, ComboCode:bkgCnlTzCdComboValue} );
		          SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
		          SetShowButtonImage(0);// Edit 가능할때 팝업 이미지 표시
		          SetSheetHeight(240);
          }


	     	break;
		}
	}
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if (OldRow != NewRow) {
			formObj.ta_note_ctnt.value=sheetObj.GetCellValue(NewRow, "note_ctnt");
			ComPriSheetFilter(sheetObjects[1], "note_conv_mapg_id", sheetObjects[0].GetCellValue(NewRow, "note_conv_mapg_id"));
			for (var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
      			// State 색 구분
      			setStateColor(sheetObjects[1], i);
      			// Rule & Charge Code 색 구분
      			//setChargeRuleColor(sheetObjects[1], i);
	 		}
		}
	}
	

	/**
     * Calling Function in case of OnSearchEnd event <br>
     * <pre>
     * 	sheet1_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     */ 
     function sheet1_OnSearchEnd(sheetObj, Code, errMsg){
    	 var formObj = document.form;
    	 if(Code == 0) {
    		 if(sheetObj.RowCount() == 0){
    			 sheetObjects[1].RemoveAll();
    		 }
    	 }
     }
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
	            if (window.event == null || ComGetEvent() == null || $(ComGetEvent()).attr('suppressWait') != "Y") {
	                ComOpenWait(true);
	            }
			sheetObj.ShowDebugMsg(false);
			var opener = window.dialogArguments;
			if (!opener) opener=window.opener;
			 if (!opener) opener = parent;
			switch (sAction) {                         
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var sXml="";
				sXml=opener.getSheetXml(15);
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				sXml=opener.getSheetXml(11);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.ColumnSort("rout_note_seq|amdt_seq", "ASC", "ASC|ASC", true);
				//setSheetStyle(sheetObj, -1);
	         	break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
        	ComOpenWait(false);
        }
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         로직처리;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // 조회
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }
	/**
	 * Sheet에서 조회 후, 색상이나 Strike등의 스타일을 처리하는 함수.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetStyle(sheetObj, idx) {
    	var opener = window.dialogArguments;
		 if (!opener) opener = parent;
    	if (sheetObj.RowCount()<= 0) {
    		return;
    	}
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	opener.setLineStyle(sheetObj, i);
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
        }
    }
  	/**
  	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State 색 구분
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
  	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code 색 구분
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
