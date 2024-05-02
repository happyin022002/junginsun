/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0379.js
*@FileTitle : TES Auto Audit - On-Dock Rail charge Audit Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-14 Jong-Ock Kim
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class ESD_EAS_0379 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0379() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		/******************************************************/
		var formObject = document.form;
	    var objs = document.all.item("tabLayer");
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_down_excel":
				sheetObject.SpeedDown2Excel(true);
				break;
				
            case "btn_close":
				window.close();
				break;

            case "btn_inv_detail" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openInvDetail();
       			}else{
					ComShowCodeMessage("COM12177");
				}
       			break;

            case "btn_history" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openHistory();
       			}else{
					ComShowCodeMessage("COM12177");
				}
       			break;

            case "btn_agreement" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openAgreement();
       			}else{
					ComShowCodeMessage("COM12177");
				}
       			break;

            case "btn_eac_transfer" :
   				openEacTransfer(sheetObject);
       			break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
			} else {
				ComShowMessage(e);
			}
		}
	}	

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			ComConfigSheetEas(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
	
		var formObject = document.form;
		var sheetObject = sheetObjects[0];
		formObject.s_expn_aud_sts_cd.Enable = false;  // Audit Result 비활성화
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	 
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObj = document.form;
		switch(comboObj.id) {  
			case "s_expn_aud_sts_cd":
				with (comboObj) { 
					getEasIbComboList(comboObj, s_expn_aud_sts_cdCode, s_expn_aud_sts_cdText , "");
					formObj.s_expn_aud_sts_cd.Code = formObj.expn_aud_sts_cd.value;
				}
			break;
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;
		switch(sheetNo) {
			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(14);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					var HeadTitleCM= "|Sel.|Seq.|Cal.\nType|Cost\nCode|Type/\nSize|Applied\nDate|DG|Cal.\nVol|Rvis.\nVol|UOM|Rate|Agmt\nCurr.|Exch.\nRate|Inv.\nAmount|Remark|3rd\nParty|Verify\nResult|EAC\nI/F";
					var HeadTitleHD= "|tml_inv_tp_cd|yd_cd|vndr_seq|inv_no|inv_ofc_cd|inv_cfm_dt|expn_aud_seq|agmt_no|agmt_ver_no|lgs_cost_full_nm";
					var HeadTitle  = HeadTitleCM + HeadTitleHD;

					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	10,		daCenter,	false,	"ibflag",	false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
	                InitDataProperty(0, cnt++, dtRadioCheck,30,	 daCenter,	true,	"chk");
	                InitDataProperty(0, cnt++, dtDataSeq,	40,	 daCenter,	true,	"seq");
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"calc_tp_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"lgs_cost_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"cntr_tpsz_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"tml_wrk_dy_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"dcgo_ind_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	50,	daRight,	true,	"calc_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	50,	daRight,	true,	"rvis_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"vol_tr_ut_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"ctrt_rt",			false,          "",       dfFloatOrg,    2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"curr_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,	daRight,	true,	"inv_xch_rt",		false,          "",       dfFloatOrg,    2,     false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	100,daRight,	true,	"inv_amt",			false,          "",       dfFloatOrg,    2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daLeft,		true,	"calc_rmk",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50, daCenter,	true,	"n3pty_flg",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"dscr_ctnt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		30,	daCenter,	true,	"eac_flg",			false,          "",       dfNone,    0,     false,       true);
					
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"tml_inv_tp_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"yd_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"vndr_seq",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"inv_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"inv_ofc_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"inv_cfm_dt",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"expn_aud_seq",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"agmt_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"agmt_ver_no",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtHidden,	90,	daCenter,	true,	"lgs_cost_full_nm",		false,          "",       dfNone,    0,     false,       true);
					
					//dtHidden
					CountPosition = 0 ;
					HeadRowHeight = 30;
					ToolTipOption = "balloon:true; width:320; backcolor:#ffffff; forecolor:#14358B; icon:0;";
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
//				formObj.f_cmd.value = SEARCHLIST01;
//				sheetObj.DoSearch("ESD_EAS_0379GS.do", EasFrmQryString(formObj));
				
				formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0379GS2.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				for(var i = 0; i<arrXml.length; i++){ 
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
				break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
		ComSetObjValue(formObj.inv_ttl_amt, sheetObj.SumText(0, "inv_amt"));
 	}
	
    function sheet1_OnDblClick(sheetObj, Row, Col){
    	openInvDetail();
    }
	
	function openInvDetail(){
		var formObj = document.form;
		var sUrl = "";
		sUrl = "/hanjin/ESD_TES_0068.do";
		var sParam = "?s_eas_flg=Y"
	+"&vndr_seq="+ComGetObjValue(formObj.s_vndr_seq)
	+"&inv_no="+ComGetObjValue(formObj.s_inv_no)			
	;	
		sUrl += sParam;
		ComOpenPopup(sUrl, 1020, 760, "", "0,0", true, false, "", "", "", "Detail");
	}
	
	function openHistory(){
		var formObj = document.form;
		var sUrl = "";
		sUrl = "/hanjin/ESD_EAS_0380.do";
		var sParam = "?"
	+"s_yd_cd="+ComGetObjValue(formObj.s_yd_cd)
	+"&s_vndr_seq="+ComGetObjValue(formObj.s_vndr_seq)
	+"&s_inv_ofc_cd="+ComGetObjValue(formObj.s_inv_ofc_cd)
	;	
		sUrl += sParam;
		ComOpenPopup(sUrl, 940, 640, "", "0,0", true, false, "", "", "", "Detail");
	}

	function openAgreement(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var sUrl = "";
		sUrl = "/hanjin/ESD_TES_0040.do";
		var sParam = "?s_eas_flg=Y"
	+"&agmt_no="+sheetObj.CellValue(sheetObj.SelectRow, "agmt_no")
	+"&agmt_ver_no="+sheetObj.CellValue(sheetObj.SelectRow, "agmt_ver_no")
	;	
		sUrl += sParam;
		ComOpenPopup(sUrl, 1020, 640, "", "0,0", true, false, "", "", "", "Detail");
	}
	
	function openEacTransfer(sheetObj){
		var formObj = document.form;
		var sRow = sheetObj.FindCheckedRow("chk"); 			
		var arrRow = sRow.split("|");
		
		//  EAC Interfce 대상으로 선택된 Row 가 없을 경우. Error
		if (arrRow.length == 1) {
			ComShowCodeMessage("COM12189");
		}else{
			
			var	expn_aud_sts_cd = ComGetObjValue(formObj.expn_aud_sts_cd);
			if (expn_aud_sts_cd == "A" || expn_aud_sts_cd == "E" ) {
				//Coincidence, Potential EAC 일 경우만 EAC로 I/F 가능
			}else{
				ComShowCodeMessage('EAS90108');
				return;
			}
			
			var sUrl = "";
			sUrl = "/hanjin/ESD_EAS_0224.do";
			var sParam = "?"
				+ "p_sys_div_cd=TES"
				+ "&p_sys_if_cd=TES"
				+ "&p_if_inv_cfm_dt="+ComGetObjValue(formObj.inv_cfm_dt)
				+ "&p_if_expn_aud_seq="+ComGetObjValue(formObj.expn_aud_seq)
				+ "&p_if_calc_tp_cd="+sheetObj.CellValue(sheetObj.SelectRow, "calc_tp_cd")
				+ "&p_if_lgs_cost_cd="+sheetObj.CellValue(sheetObj.SelectRow, "lgs_cost_cd")
				+ "&p_if_cntr_tpsz_cd="+sheetObj.CellValue(sheetObj.SelectRow, "cntr_tpsz_cd")
				+ "&p_if_sto_cntr_sz_nm="
				+ "&p_if_io_bnd_cd="
				+ "&p_if_dcgo_flg="+sheetObj.CellValue(sheetObj.SelectRow, "dcgo_ind_cd")
				+ "&p_if_rc_flg="
				+ "&p_if_tml_wrk_dy_cd="+sheetObj.CellValue(sheetObj.SelectRow, "tml_wrk_dy_cd")
				+ "&p_if_fp_calc_prd_cd="
				+ "&p_if_inv_no="+sheetObj.CellValue(sheetObj.SelectRow, "inv_no")
				+ "&p_if_inv_vndr_seq="+sheetObj.CellValue(sheetObj.SelectRow, "inv_vndr_seq")
				+ "&p_ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow, "inv_ofc_cd")
				+ "&p_vndr_seq="+sheetObj.CellValue(sheetObj.SelectRow, "vndr_seq")
				+ "&p_inv_no="+sheetObj.CellValue(sheetObj.SelectRow, "inv_no")
				+ "&p_cost_cd="+sheetObj.CellValue(sheetObj.SelectRow, "lgs_cost_cd")
				+ "&p_cur_cd="+sheetObj.CellValue(sheetObj.SelectRow, "curr_cd")
				+ "&p_inv_amt="+sheetObj.CellValue(sheetObj.SelectRow, "inv_amt")
				+ "&p_inv_amt="+sheetObj.CellValue(sheetObj.SelectRow, "inv_amt")
				+ "&p_inv_iss_dt="+ComGetObjValue(formObj.iss_dt)
				;
			sUrl += sParam;
			ComOpenPopup(sUrl, 1020, 640, "", "0,0", true, false, "", "", "", "Detail");			
		}
	}

	/**
	 * EAC transfer 팝업호출 및 저장 후 eac_no 선택한 Row에 셋팅.
	 */		
	function fn_setEacNo(eac_no){
		var sheetObj = sheetObjects[0];
		if (eac_no.length == 14) {
			sheetObj.CellValue(sheetObj.SelectRow, "eac_flg") = "Y";
		}
	}
	
	/**
	 * CostCode Name ToolTip
	 * 
	 * @param sheetObj
	 * @param buttonValue
	 * @param shiftValue
	 * @param x_pos
	 * @param y_pos
	 */	
	function sheet1_OnMouseMove(sheetObj, buttonValue, shiftValue, x_pos, y_pos)
	{
		sheetToolTip(sheetObj, "lgs_cost_cd", "lgs_cost_full_nm");
	}
	