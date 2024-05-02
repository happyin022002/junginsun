/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2025.js
*@FileTitle : RFA Proposal Creation - Rate (Route Point)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.10 박성수
* 1.0 Creation
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
    function ESM_PRI_2025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업 */

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var bIsReqUsr = false;
    var bIsAproUsr = false;
    
    var exTransaction = false;
    
    var beforeIndex = -1;
    
    var curPntViaType = "";
    var curOrgDestType = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
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
	
		var sheetObject1 = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
			
			case "btn_add":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBINSERT);
				break;
	
			case "btn_copy":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBCOPYROW);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBDELETE);
				break;
				
			case "btn_amend":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC11);
				break;

			case "btn_amendcancel":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC12);
				break;
	
			case "btn_accept":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC13);
				break;
	
			case "btn_acceptcancel":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC14);
				break;
	
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
	
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
				
			case "rt_pnt":
				rtPntOnClick();
				break;
	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
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
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
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
	
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		bIsReqUsr = document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr = document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
		
        if (document.form.amdt_seq.value == "0") {
        	hiddenButton("btn_amend");
        	hiddenButton("btn_amendcancel");
        } else {
        	showButton("btn_amend");
        	showButton("btn_amendcancel");
        }
        
    	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        	enableButton("btn_add");
        	enableButton("btn_copy");
        	enableButton("btn_delete");
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_copy");
    		disableButton("btn_delete");
    		disableButton("btn_amend");
    		disableButton("btn_amendcancel");
    	}
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_accept");
        	enableButton("btn_acceptcancel");
    	} else {
            disableButton("btn_accept");
            disableButton("btn_acceptcancel");
    	}
    	
    	if ((!bIsReqUsr && !bIsAproUsr) || dialogArguments.isCMDTGroupDeleted()) {
    		for (i = 0; i < sheetObjects.length; i++) {
    			sheetObjects[i].Editable = false;
    		}
    	}
		
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        
        if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "P") {
        	document.form.rt_pnt[0].checked = true;
        } else if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "V") {
        	document.form.rt_pnt[1].checked = true;
        } else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "V") {
        	document.form.rt_pnt[2].checked = true;
        } else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "P") {
        	document.form.rt_pnt[3].checked = true;
        }
        rtPntOnClick();
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
	
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 240, daLeft, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "rcv_de_term_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 75, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
	
				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");	// 영대문자,숫자만 입력
                ShowButtonImage = 2;

			}
			break;
			
		case 2: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 370, daLeft, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
	
				InitDataValid(0, "rout_via_port_def_cd", vtEngUpOther, "0123456789");	// 영대문자,숫자만 입력
                ShowButtonImage = 2;

			}
			break;
			
		case 3: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 370, daLeft, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
	
				InitDataValid(0, "rout_via_port_def_cd", vtEngUpOther, "0123456789");	// 영대문자,숫자만 입력
                ShowButtonImage = 2;

			}
			break;
			
		case 4: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "rcv_de_term_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 75, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
	
				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");	// 영대문자,숫자만 입력
                ShowButtonImage = 2;

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
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
    function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
    }
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_pnt_loc_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + formObj.org_dest_tp_cd.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + formObj.org_dest_tp_cd.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
	    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
	    		
	    		//ComShowCodeMessage("PRI00314", "4 or 5");
	    		return false;
			}
		} else if (colName == "rout_pnt_loc_tp_cd") {
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_via_port_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "L";
 					sheetObj.CellValue2(Row, "rout_via_port_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		    		
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "G";
 					sheetObj.CellValue2(Row, "rout_via_port_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		    		
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
	    		sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
	    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
	    		
	    		//ComShowCodeMessage("PRI00314", "4 or 5");
	    		return false;
			}
		} else if (colName == "rout_via_port_tp_cd") {
			sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
    		sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		sheet2_OnChange(sheetObj, Row, Col, Value)
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		sheet1_OnChange(sheetObj, Row, Col, Value)
	}
	
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
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
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_pnt_loc_def_cd") {
			if (sheetObj.CellEditable(Row, "rout_pnt_loc_def_cd")) {
	            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd") + "&org_dest_cd=" + formObj.org_dest_tp_cd.value;
	            
				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
				if (rtnVal != null){
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = rtnVal.cd;
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = rtnVal.nm;
					if (rtnVal.cd.length == 4) {
						sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
					} else if (rtnVal.cd.length == 5) {
						sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
					}
				}
			}
		}
	}
	
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
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
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_via_port_def_cd") {
			if (sheetObj.CellEditable(Row, "rout_via_port_def_cd")) {
	            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_via_port_tp_cd");

				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
				if (rtnVal != null){
					sheetObj.CellValue2(Row, "rout_via_port_def_cd") = rtnVal.cd;
					sheetObj.CellValue2(Row, "rout_via_port_def_nm") = rtnVal.nm;
					if (rtnVal.cd.length == 4) {
						sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "G";
					} else if (rtnVal.cd.length == 5) {
						sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "L";
					}
				}
			}
		}
	}
	
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
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
	function sheet3_OnPopupClick(sheetObj, Row, Col) {
		sheet2_OnPopupClick(sheetObj, Row, Col);
	}
	
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
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
	function sheet4_OnPopupClick(sheetObj, Row, Col) {
		sheet1_OnPopupClick(sheetObj, Row, Col);
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
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }

	        sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			
	        case IBSEARCH_ASYNC11: // Amend
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            var checkedCnt = sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SelectRow = curRow;
	        		sheetObj.CellValue2(curRow, "chk") = "0";
	        	}
	        	
	        	if (dialogArguments.isRouteGroupDeleted()) {
	        		dialogArguments.reloadSw = true;
	        	}
	        	
	        	var idx = dialogArguments.doRowAmend(sheetObj, "AM");
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	        	            
	            break;
	        case IBSEARCH_ASYNC12: // Amend Cancel
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            var checkedCnt = sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SelectRow = curRow;
	        		sheetObj.CellValue2(curRow, "chk") = "0";
	        	}
	        	
	    		var oldRow = sheetObj.SelectRow - 1;
	    		var tpColNm = "";
	    		var defColNm = "";
	        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        		tpColNm = "rout_pnt_loc_tp_cd";
	        		defColNm = "rout_pnt_loc_def_cd";
	        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        		tpColNm = "rout_via_port_tp_cd";
	        		defColNm = "rout_via_port_def_cd";
	        	}
	    		
	    		if (sheetObj.CellValue(oldRow, tpColNm) == "G") {
	    			var oldGrpCd = sheetObj.CellValue(oldRow, defColNm);
	    			
					formObj.f_cmd.value = SEARCH11;
					var param = "&cd=" + oldGrpCd + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
					var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
					var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
					if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
						ComShowCodeMessage("PRI01127", "LOC Group");
						return false;
					}
	    		}
	    		
	        	if (dialogArguments.isRouteGroupDeleted()) {
	        		dialogArguments.reloadSw = true;
	        	}
	        	
	        	var idx = dialogArguments.doRowAmendCancel(sheetObj);
	        	setSheetStyle(sheetObj, idx);
	            
	            break;
	        case IBSEARCH_ASYNC13: // Accept
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI00008")) {
	            	return false;
	            }
	            
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	           
	            var sCheckedRows = sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	        	for (var i = 0; i < arrCheckedRows.length; i++) {
	        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "A";
	        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Accepted";
	        	}
	            
	            formObj.f_cmd.value = MODIFY01;
	            var sParam = FormQueryString(formObj);
	    		var sSheetParam = sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + ComPriSetPrifix(sSheetParam, sheetObj.id + "_");
	    
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2025GS.do", sParam);
	            sheetObj.LoadSaveXml(sXml, false, "chk");
	            
	            sheetObj.CheckAll2("chk") = 0;
	            setSheetStyle(sheetObj, -1);
	            
	            exTransaction = true;
	            dialogArguments.updateSummary();
	            
	            ComShowCodeMessage("PRI00108");
	            break;
	        case IBSEARCH_ASYNC14: // Accept Cancel
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI00009")) {
	            	return false;
	            }
	            
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	            
	            var sCheckedRows = sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	        	for (var i = 0; i < arrCheckedRows.length; i++) {
	        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "I";
	        		sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Initial";
	        	}
	            
	            formObj.f_cmd.value = MODIFY02;
	            var sParam = FormQueryString(formObj);
	    		var sSheetParam = sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + ComPriSetPrifix(sSheetParam, sheetObj.id + "_");
	    
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2025GS.do", sParam);
	            sheetObj.LoadSaveXml(sXml, false, "chk");
	            
	            sheetObj.CheckAll2("chk") = 0;
	            setSheetStyle(sheetObj, -1);
	            
	            exTransaction = true;
	            dialogArguments.updateSummary();
	            
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            for (var a = 0; a <= 3; a++) {
	            	var tpColNm;
	            	var defColNm;
	            	if (a == 0 || a == 3) {
	            		tpColNm = "rout_pnt_loc_tp_cd";
	            		defColNm = "rout_pnt_loc_def_cd";
	            	} else if (a == 1 || a == 2) {
	            		tpColNm = "rout_via_port_tp_cd";
	            		defColNm = "rout_via_port_def_cd";
	            	}
	            	
		            for (var i = sheetObjects[a].HeaderRows; sheetObjects[a].RowCount > 0 && i <= sheetObjects[a].LastRow; i++) {
		            	if (sheetObjects[a].CellValue(i, "n1st_ord_ref") == "" || sheetObjects[a].CellValue(i, "n2nd_ord_ref") == "") {
		            		var n1stOrdRef;
		            		if (sheetObjects[a].CellValue(i, tpColNm) == "G") {
		            			n1stOrdRef = 1;
		            		} else if (sheetObjects[a].CellValue(i, tpColNm) == "L") {
		            			n1stOrdRef = 2;
		            		} else {
		            			n1stOrdRef = 99;
		            		}
		            		sheetObjects[a].CellValue2(i, "n1st_ord_ref") =  n1stOrdRef;
		            		sheetObjects[a].CellValue2(i, "n2nd_ord_ref") = sheetObjects[a].CellValue(i, defColNm);
		            	}
		            }
		            
		            //소트시 테이블이 다르기때문에 분류함.
		            if(a == 0 || a == 3) {
		            	sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
		            } else if (a == 1 || a == 2) {
		            	sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
		            }
		            
					var sXml = ComPriSheet2Xml(sheetObjects[a]);
					dialogArguments.setSheetXml(sXml, a + 6);
	            }
         
	            window.returnValue = "O";
	            window.close();
	            
				if (exTransaction) {
					dialogArguments.restylingPagePostTr();
				}
	            
	            break; 
	            
			case IBCLEAR: // 로딩시 코드조회
				var sXml = "";
	 			
				//공통 - type
				sheetObjects[0].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);		
				sheetObjects[1].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[2].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[3].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			
				//공통 term
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", false, 0, "Y");
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", false, 0, "Y");
				
				//공통 trans mode
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);
		
				break;
				
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            /*
	            for (var a = 0; a <= 3; a++) {
					var sXml = dialogArguments.getSheetXml(a + 6);
					sheetObjects[a].LoadSearchXml(sXml);
					
					sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|cmdt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
					
					setSheetStyle(sheetObjects[a], -1);
	            }
	            */
	            
	            //ORIGIN, DESTINATION 에는 TERM항목이 필수로 존재하기 때문에 정렬에 포함해야 함
	            var sXml6 = dialogArguments.getSheetXml(6);
	            sheetObjects[0].LoadSearchXml(sXml6);
	            sheetObjects[0].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[0], -1);
	            
	            var sXml7 = dialogArguments.getSheetXml(7);
	            sheetObjects[1].LoadSearchXml(sXml7);
	            sheetObjects[1].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[1], -1);
	            
	            var sXml8 = dialogArguments.getSheetXml(8);
	            sheetObjects[2].LoadSearchXml(sXml8);
	            sheetObjects[2].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[2], -1);
	            
	            var sXml9 = dialogArguments.getSheetXml(9);
	            sheetObjects[3].LoadSearchXml(sXml9);
	            sheetObjects[3].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[3], -1);
	            
	         	break; 	
		
			case IBINSERT: // 입력
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
			
	        	if (dialogArguments.isRouteGroupDeleted()) {
	        		dialogArguments.reloadSw = true;
	        	}
	            
		        var idx = sheetObj.DataInsert();
	 			
	            sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
	            sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
	            sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	            sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
	            sheetObj.CellValue(idx, "org_dest_tp_cd") = curOrgDestType;
	            sheetObj.CellValue(idx, "rout_seq") = formObj.rout_seq.value;
	            if (curPntViaType == "P") {
	            	sheetObj.CellValue(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1;
	            } else if (curPntViaType == "V") {
	            	sheetObj.CellValue(idx, "rout_via_seq") = parseInt(ComPriGetMax(sheetObj, "rout_via_seq"))+ 1;
	            }
	            
	            sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
	            sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
	            sheetObj.CellValue(idx, "src_info_cd") = "NW";
	            sheetObj.CellValue(idx, "src_info_nm") = "New";
	            sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
	            sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	            sheetObj.CellValue(idx, "exp_dt") = formObj.exp_dt.value;
	            
	            setSheetStyle(sheetObj, idx);
	            
	            if (curPntViaType == "P") {
	            	sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SelectCell(idx, "rout_via_port_def_cd", false);
	            }
			
				break;
				
			case IBCOPYROW: // 행 복사
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
			
	        	if (dialogArguments.isRouteGroupDeleted()) {
	        		dialogArguments.reloadSw = true;
	        	}
	            
		        var idx = sheetObj.DataCopy();
	 			
	            if (curPntViaType == "P") {
	            	sheetObj.CellValue(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1;
	            } else if (curPntViaType == "V") {
	            	sheetObj.CellValue(idx, "rout_via_seq") = parseInt(ComPriGetMax(sheetObj, "rout_via_seq"))+ 1;
	            }
	            
	            sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
	            sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
	            sheetObj.CellValue(idx, "src_info_cd") = "NW";
	            sheetObj.CellValue(idx, "src_info_nm") = "New";
	            sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
	            sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	            sheetObj.CellValue(idx, "exp_dt") = formObj.exp_dt.value;
	            
	            setSheetStyle(sheetObj, idx);
	            
	            if (curPntViaType == "P") {
	            	sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SelectCell(idx, "rout_via_port_def_cd", false);
	            }
			
				break;
		
			case IBDELETE: // 삭제
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	            
	        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
	        	var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	        	for (var i = arrCheckedRows.length - 1; i >= 0; i--) {
	            	if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SelectRow = arrCheckedRows[i];
	               		sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";
	                	
	               		var idx = dialogArguments.doRowAmend(sheetObj, "AD");
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	            	}
	        	}
	        	deleteRowCheck(sheetObj, "chk");
				
				break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
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
        case IBSEARCH_ASYNC11: // Amend
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (dialogArguments.isCMDTGroupDeleted()) {
        		return false;
        	}
        	
        	var checkedCnt = sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow = -1;
        	if (checkedCnt == 1) {
        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow = sheetObj.SelectRow;
        	}
        	
        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01011");
        		return false;
        	}
        	
            return true;
            break;
            
        case IBSEARCH_ASYNC12: // Amend Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (dialogArguments.isCMDTGroupDeleted()) {
        		return false;
        	}
        	
        	var checkedCnt = sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow = -1;
        	if (checkedCnt == 1) {
        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow = sheetObj.SelectRow;
        	}
        	
        	if (sheetObj.CellValue(curRow, "src_info_cd") != "AM" && sheetObj.CellValue(curRow, "src_info_cd") != "AD") {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01012");
        		return false;
        	}
        	
            return true;
            break;
            
        case IBSEARCH_ASYNC13: // Accept
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	
        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows = new Array();
        	if (sCheckedRows == "") {
        		arrCheckedRows.push(sheetObj.SelectRow);
        	} else { 
        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i = 0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
        		}
            	if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
				if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
        	
            return true;
            break;
            
        case IBSEARCH_ASYNC14: // Accept Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	
        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows = new Array();
        	if (sCheckedRows == "") {
        		arrCheckedRows.push(sheetObj.SelectRow);
        	} else { 
        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i = 0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A") {
					ComShowCodeMessage("PRI01038");
					return false;
        		}
				if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
        	
            return true;
            break;
            
        case IBSEARCH: // 조회
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
    
        case IBSAVE: // 저장
        	if (!validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
        		return false;
        	}

        	/*
            if (getAmendValidRowCount(sheetObjects[0], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Origin");
                return false;
            }
            if (formObj.svc_scp_cd.value == "TPE"
            	&& getAmendValidRowCount(sheetObjects[1], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Origin Via");
                return false;
            }
            if (formObj.svc_scp_cd.value == "TPE"
            	&& getAmendValidRowCount(sheetObjects[2], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Destination Via");
                return false;
            }
            if (getAmendValidRowCount(sheetObjects[3], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Destination");
                return false;
            }
            */
        	
            return true;
            break;
            
        case IBSEARCH_ASYNC15: // 라디오버튼 이동시 Validation
            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
                return false;
            }

        	var dupRow = -1;
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
        		dupRow = ComPriAmendDupCheck(sheetObj, "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd", formObj.amdt_seq.value);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
        		dupRow = ComPriAmendDupCheck(sheetObj, "rout_via_port_tp_cd|rout_via_port_def_cd", formObj.amdt_seq.value);
        	}
        	if (dupRow >= 0) {
        		sheetObj.SelectRow = dupRow;
				ComShowCodeMessage("PRI00302");
				return false;
        	}
        	
            return true;
            break;
    
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (dialogArguments.isCMDTGroupDeleted()) {
        		return false;
        	}
        	
        	if (sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
            
            return true;
            break;
            
        case IBCOPYROW: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (dialogArguments.isCMDTGroupDeleted()) {
        		return false;
        	}
        	
            if (sheetObj.RowCount <= 0 || sheetObj.SelectRow <= 0) {
                return false;
            }
        	if (sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
            
            return true;
            break;
    
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (dialogArguments.isCMDTGroupDeleted()) {
        		return false;
        	}
        	
        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows = new Array();
        	if (sCheckedRows == "") {
        		arrCheckedRows.push(sheetObj.SelectRow);
        	} else { 
        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
				if (sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "NW"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GM"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PM"
					&& sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
        	
        	return true;
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
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	dialogArguments.setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	dialogArguments.setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }

	/**
	 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
    		&& sheetObj.CellValue(idx, "src_info_cd") != "AD") {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_tp_cd") = true;
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_def_cd") = true;
	        	sheetObj.CellEditable(idx, "rcv_de_term_cd") = true;
	        	sheetObj.CellEditable(idx, "prc_trsp_mod_cd") = true;
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.CellEditable(idx, "rout_via_port_tp_cd") = true;
	        	sheetObj.CellEditable(idx, "rout_via_port_def_cd") = true;
        	}
		} else {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_tp_cd") = false;
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_def_cd") = false;
	        	sheetObj.CellEditable(idx, "rcv_de_term_cd") = false;
	        	sheetObj.CellEditable(idx, "prc_trsp_mod_cd") = false;
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.CellEditable(idx, "rout_via_port_tp_cd") = false;
	        	sheetObj.CellEditable(idx, "rout_via_port_def_cd") = false;
        	}
		}
    }
    
	function rtPntOnClick() {
		var curIndex = parseInt(getRtPnt());
		
		if (beforeIndex != curIndex) {
			if (beforeIndex >= 0 && !validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
				document.form.rt_pnt[beforeIndex].checked = true;
				return false;
			}
			
			if (curIndex == 0) {
				curPntViaType = "P";
			    curOrgDestType = "O";
			} else if (curIndex == 1) {
				curPntViaType = "V";
			    curOrgDestType = "O";
			} else if (curIndex == 2) {
				curPntViaType = "V";
			    curOrgDestType = "D";
			} else if (curIndex == 3) {
				curPntViaType = "P";
			    curOrgDestType = "D";
			}
			
			document.form.org_dest_tp_cd.value = curOrgDestType;
			document.form.pnt_via_tp_cd.value = curPntViaType;
			
		    var objs = document.all.item("sheetLayer");
		    
		    document.form.rt_pnt[curIndex].focus();
		    objs[curIndex].style.display = "inline";
		    if (beforeIndex >= 0) {
				objs[beforeIndex].style.display = "none";
		    }
			
		    beforeIndex = curIndex;
		}
	}
	
    function getRtPnt() {
        for (var i = 0; i < document.form.rt_pnt.length; i++) {
            if (document.form.rt_pnt[i].checked) {
                return document.form.rt_pnt[i].value;
            }
        }
    }