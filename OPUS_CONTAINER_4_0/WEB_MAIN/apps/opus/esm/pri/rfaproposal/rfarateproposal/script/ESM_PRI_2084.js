/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2084.js
*@FileTitle  : Amendment History - Rate (Commodity Note)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */
    /**
     * @extends 
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var sChgCdVisiable="";
    var opener;
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
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
	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
   	 	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;

		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
        case 1:  // Grid 1
            with(sheetObj){
            
          var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Commodity Group|Actual Customer|1|2|3|4";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:450,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ac_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);

          SetEditable(0);
          SetEllipsis(1);
                SetShowButtonImage(0);
                SetSheetHeight(102);
          }


            break;
		case 2: // sheet1 init
		    with(sheetObj){
	        
	      var HeadTitle="|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|cmdt_note_seq|Content|Conversion|Conversion|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User";
	      var headCount=ComCountHeadTitle(HeadTitle);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:365,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:40,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:1, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
	      SetSheetHeight(100);
	      SetCountPosition(0);
	      }


			break;
        case 3:      //t1sheet1 init
            with(sheetObj){
           
          var HeadTitle="|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
          "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
          "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:5 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                 {Type:"Combo",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                 {Type:"Combo",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                 {Type:"Combo",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" } ];
           
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
          SetSheetHeight(200);
          }


         	break;
		}
	}
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		 
		
		
		if (OldRow != NewRow) {
			
			ComOpenWait(true);
			
			setTimeout(function(){
				var sRow = sheetObjects[1].HeaderRows();
				var eRow = sheetObjects[1].LastRow();
				var cmdtHdrSeq=sheetObj.GetCellValue(NewRow, "cmdt_hdr_seq");
				formObj.cmdt_hdr_seq.value=cmdtHdrSeq;
				formObj.ta_note_ctnt.value="";
				
				if(sheetObjects[1].RowCount()> 0){
					var selectedRow = sRow;
					for (var i=sRow; i <= eRow; i++) {
						if (sheetObjects[1].GetCellValue(i, "cmdt_hdr_seq") == cmdtHdrSeq && sheetObjects[1].GetRowStatus(i) != "D") {
							sheetObjects[1].SetRowHidden(i,0);
							if (sheetObjects[1].GetCellValue(i, "amdt_seq") == formObj.amdt_seq.value) {
								selectedRow = i;
							}
						} else {
							sheetObjects[1].SetRowHidden(i,1);
						}
					}
					
					sheetObjects[1].SetSelectRow(selectedRow);
					formObj.ta_note_ctnt.value=sheetObjects[1].GetCellValue(selectedRow, "note_ctnt");
					var noteConvMapgId = sheetObjects[1].GetCellValue(selectedRow, "note_conv_mapg_id");
					ComPriSheetFiltering(sheetObjects[2], "note_conv_mapg_id", noteConvMapgId, true, sheetObj);
					sheetObjects[2].SetCountFormat("["+getTotalCountExceptHidden(sheetObjects[2])+"]");
					
					
				} else {
					ComPriSheetFiltering(sheetObjects[2], "note_conv_mapg_id", "X");
				}
				ComOpenWait(false);
			}, 100);
			
		}
		sheetObjects[2].RenderSheet(1);
		
		
		
		
		
	}
	
	/**
     * IBSheet의 row들을 주어진 값과 일치하는 row만 보이도록 필터링 한다. <br>
     * 필터링 후 필터된 row중 첫번째 row를 select해 준다. <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 키 데이터. "|"로 연결한다.
     * @param {boolean} bSelectLast
     * @param {object} sheetObj 필수, IBSheet Object.
     * @return 없음
     * @author 박성수
     * @version 2009.04.22
     */
    function ComPriSheetFiltering(sheetObj, sCol, sValue, bSelectLast, sObj) {
        if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return;
        }
        var arrCol=sCol.split("|");
        var arrValue=sValue.split("|");
        var firstRow=-1;
        if(bSelectLast == undefined){
        	bSelectLast = true;
        }
        
        
        var sRow = sheetObj.HeaderRows();
		var eRow = sheetObj.LastRow();
        for (var i=sRow; i<=eRow; i++) {
        	if (sheetObj.GetRowStatus(i) == "D")  continue;
            var doHide=0;
            for (var j=0; j < arrCol.length; j++) {
            	if (sheetObj.GetCellValue(i, arrCol[j]) != arrValue[j]) {
                    doHide=1;
                    break;
                }
            }
            if (doHide==0 && (bSelectLast || firstRow == -1))  firstRow=i;
            sheetObj.SetRowHidden(i,doHide);
            
            if(sObj.id == "sheet2"){
            	setStateColor(sheetObjects[2], i);
            }
        }

        if (firstRow > 0) {
            sheetObj.SetSelectRow(firstRow);
        }
    }
	
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if (OldRow != NewRow) {
			var sRow = sheetObjects[2].HeaderRows();
			var eRow = sheetObjects[2].LastRow();
			formObj.ta_note_ctnt.value=sheetObj.GetCellValue(NewRow, "note_ctnt");
			ComPriSheetFiltering(sheetObjects[2], "note_conv_mapg_id", sheetObjects[1].GetCellValue(NewRow, "note_conv_mapg_id"), true, sheetObj);
		}
		
	}
	
    
    /**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Combining string to be displayed at location detail information box on Route Group Grid. Dest. Point
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} Code
	 * @param {string} Msg
	 * @param {string} StCode
	 * @param {string} StMsg
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	sheetObjects[2].SetCountFormat("["+getTotalCountExceptHidden(sheetObjects[2])+"]");
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

        	var objEvt = ComGetEvent();
        	if (window.event == null || window.event.srcElement == null || $(objEvt).attr('suppressWait')!= "Y") {
        		setTimeout(function(){ ComOpenWait(true); },1);	
        	}
			
        	sheetObj.ShowDebugMsg(false);
			switch (sAction) {		
			case IBSEARCH: // parent sheet에서 조회
	            
				setTimeout(function(){
				
						if (!validateForm(sheetObj,document.form,sAction)) {
			            	ComOpenWait(false);
			                return false;
			            }
			            
			            var sXml="";
		
						sXml=opener.getSheetXml(14);
						sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		
						sXml=opener.getSheetXml(5);
						sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
		
						setSheetStyle(sheetObjects[1], -1);
						sXml=opener.getSheetXml(0);
						sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
						setHdrLineStyle(sheetObjects[0]);
						sheetObjects[0].SetSelectRow(formObj.select_row.value);
						sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol());
						sheetObjects[2].SetCountFormat("["+getTotalCountExceptHidden(sheetObjects[2])+"]");
						
						ComOpenWait(false); 
						
				
				},1000);
	           
				
				
	         	break; 	
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
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
    function setHdrLineStyle(sheetObj) {
    	if (document.form.amdt_seq.value == "0") {
    		return true;
    	}
		for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetRowStatus(i) == "D") {
				sheetObj.SetRowHidden(i,1);
			}
			if (parseInt(sheetObj.GetCellValue(i, "nd_cnt")) == 0) {
 				sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(),1);
			} else {
 				sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(),0);
			}
			if (parseInt(sheetObj.GetCellValue(i, "na_cnt")) > 0) {
 				sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
			} else {
 				sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#000000");
			}
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
 	
 	
 	function getTotalCountExceptHidden(sheetObj){
 		var result = 0;
 		
 		var sRowIdx = sheetObj.HeaderRows();
 		var eRowIdx = sheetObj.LastRow();
 		var totRowCnt = sheetObj.RowCount();
 		var hidRowCnt = 0;
 		if(totRowCnt > 0){
 			for(var i = sRowIdx; i <= eRowIdx; i++){
 				var isHidden = sheetObj.GetRowHidden(i);
 				if(isHidden == 1){
 					hidRowCnt++;
 				}
 			}
 			
 			result = totRowCnt - hidRowCnt;
 		}

 		return result;
 	}
