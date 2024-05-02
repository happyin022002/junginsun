/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2028.js
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
    function ESM_PRI_2028() {
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
	var stdOriginCode = "";
	var stdDestCode = "";	
	
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
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], formObject, IBINSERT);
				break;
	
			case "btn_copy":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], formObject, IBCOPYROW);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], formObject, IBDELETE);
				break;
				
			case "btn_amend":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSEARCH_ASYNC11);
				break;

			case "btn_amendcancel":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSEARCH_ASYNC12);
				break;
	
			case "btn_accept":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSEARCH_ASYNC13);
				break;
	
			case "btn_acceptcancel":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSEARCH_ASYNC14);
				break;
	
			case "btn_ok":
				if(!checkGroupNo()){
					return false;
				}
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
	
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSAVE);
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
                EnterBehavior = "tab";

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
                EnterBehavior = "tab";

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
                EnterBehavior = "tab";

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
				InitDataProperty(0, cnt++, dtData, 240, daLeft, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
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
                EnterBehavior = "tab";

			}
			break;
			
		case 5: // sheet5 init
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
				
				var HeadTitle = "|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Loc Group|Term|Base Port|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord||||||||||||||||||";
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
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "group_no", false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "rcv_de_term_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtComboEdit, 75, daCenter,  	false,  "bse_port_def_cd",     	true,  	"", dfEngUpKey, 	0,  true,   true,	5);
				InitDataProperty(0, cnt++, dtCombo, 85, daCenter, false, "prc_trsp_mod_cd", true, "", dfNone, 0, true, true);
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
                
                InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"base_port_list");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"optm_trsp_mod_flg");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_rout_cmb_tp_cd");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_rt_use_sts_cd");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_gline_upd_dt");
				
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, true, true);

                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);
                
				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
				InitDataValid(0,  "bse_port_def_cd",	vtEngUpOther, "1234567890");
                ShowButtonImage = 2;
                EnterBehavior = "tab";

			}
			break;
			
		case 6: // sheet6 init
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
				
				var HeadTitle = "|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Loc Group|Term|Base Port|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord||||||||||||||||||";
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
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "group_no", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "rcv_de_term_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtComboEdit, 75, daCenter,  	false,  "bse_port_def_cd",     	true,  	"", dfEngUpKey, 	0,  true,   true,	5);
				InitDataProperty(0, cnt++, dtCombo, 85, daCenter, false, "prc_trsp_mod_cd", true, "", dfNone, 0, true, true);
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
                
                InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"base_port_list");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"optm_trsp_mod_flg");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_rout_cmb_tp_cd");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_rt_use_sts_cd");
				InitDataProperty(0, cnt++, dtHidden, 		30, daCenter,  false,  	"fic_gline_upd_dt");
				
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, true, true);

                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);
                                
	
				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");	// 영대문자,숫자만 입력
				InitDataValid(0,  "bse_port_def_cd",	vtEngUpOther, "1234567890");
                ShowButtonImage = 2;
                EnterBehavior = "tab";

			}
			break;
			
		case 7: // sheet7 서버통신용
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
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
				
				var HeadTitle = "1|2";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, false, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "data");
                EnterBehavior = "tab";
				
			}
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
    function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
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
    function sheet6_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
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
	function sheet5_OnChange(sheetObj, Row, Col, Value) {
		sheet_OnChange(sheetObj, Row, Col, Value);
//		sheet_PostOnChange(sheetObj, Row, Col, Value);
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
	function sheet6_OnChange(sheetObj, Row, Col, Value) {
		sheet_OnChange(sheetObj, Row, Col, Value);
//		sheet_PostOnChange(sheetObj, Row, Col, Value);
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
		var sender = sheetObjects[6];
		
		if (colName == "rout_pnt_loc_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + formObj.org_dest_tp_cd.value;
				//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
 					//최종 조회 성공 했다. 이 정보를 바탕으로 'CY 인지 다시 판단을 한다.
 					if( !validateCYPortLocation( sheetObj, Row, Value,"L") ){
 						sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = " ";
 						sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
 			    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
 					}
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
				//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
 					//최종 조회 성공 했다. 이 정보를 바탕으로 'CY 인지 다시 판단을 한다.
 					if( !validateCYPortLocation( sheetObj, Row, Value,"G") ){
 						sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = " ";
 						sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
 			    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
 					}
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
		var sender = sheetObjects[6];
		
		if (colName == "rout_via_port_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
				//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
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
				//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
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
	function sheet_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var sender = sheetObjects[6];
        var checkStr = funcChkTypeStatus() ;

		if (colName == "rout_pnt_loc_def_cd") {
			
			initFicRoute(sheetObj, Row, Col);
			
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + formObj.org_dest_tp_cd.value;
				//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
 					if( !validateCYPortLocation( sheetObj, Row, Value,"L") ){
 						sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
 			    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
 					} 					
				} else {
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else  {
		        // LOCATION GROUP은 IHC가 포함된 곳에는 들어 갈수 없다.
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
	    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);	            	
            	return false;
	  
			}  
		} else if (colName == "rout_pnt_loc_tp_cd") {
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
    		sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = "";
    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		} else if (colName == "rcv_de_term_cd") {
			if( !validateCYPortLocation( sheetObj, Row, sheetObj.CellValue(Row, "rout_pnt_loc_def_cd"),"L") ){
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
	    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			} 				
			initFicRoute(sheetObj, Row, Col);
			formObj.rout_tgt_row.value = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
		} else if (colName == "bse_port_def_cd") {
	        // LOCATION GROUP은 IHC가 포함된 곳에는 들어 갈수 없다.
            if( Value.length != 5 && ComTrim(Value).length != 0){
 	    		sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
 				initFicRoute(sheetObj, Row, Col); 	    		
	    		sheetObj.SelectCell(Row, "bse_port_def_cd", false);	     
            	return;
            }
			if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && !checkBasePort(sheetObj, Row, Value)) { //point와 비교
				 return;
			}
			initFicRoute(sheetObj, Row, Col);
			checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
			formObj.rout_tgt_row.value = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
		} else if (colName == "prc_trsp_mod_cd") {
			//initFicRoute(sheetObj, Row, Col);
			formObj.rout_tgt_row.value = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
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
					sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = rtnVal.cd;
					sheetObj.CellValue(Row, "rout_pnt_loc_def_nm") = rtnVal.nm;
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
	function sheet5_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_pnt_loc_def_cd") {
			if (sheetObj.CellEditable(Row, "rout_pnt_loc_def_cd")) {
	            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=L&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd") + "&org_dest_cd=" + formObj.org_dest_tp_cd.value;
	            
				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
				if (rtnVal != null){
					sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = rtnVal.cd;
					sheetObj.CellValue(Row, "rout_pnt_loc_def_nm") = rtnVal.nm;
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
					sheetObj.CellValue(Row, "rout_via_port_def_cd") = rtnVal.cd;
					sheetObj.CellValue(Row, "rout_via_port_def_nm") = rtnVal.nm;
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
	function sheet6_OnPopupClick(sheetObj, Row, Col) {
		sheet5_OnPopupClick(sheetObj, Row, Col);
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
            	switch (sAction) {
    			
	    	        case IBSEARCH_ASYNC06:
	    	        case IBSEARCH_ASYNC07:
	    	        case IBSEARCH_ASYNC08: 
	    	        	break;
	    	        default :
	    	        	ComOpenWait(true);
            	}
            	
            }
            
            var sender = sheetObjects[6];

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
					//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
					var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
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
	            //var sXml = sheetObj.GetSaveXml("ESM_PRI_2025GS.do", sParam);
	            var sXml = sender.GetSaveXml("ESM_PRI_2028GS.do", sParam);
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
	    
	            //var sXml = sheetObj.GetSaveXml("ESM_PRI_2025GS.do", sParam);
	            var sXml = sender.GetSaveXml("ESM_PRI_2028GS.do", sParam);
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
	            
	            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	            // VIA를 변경한다.
		        var checkPnt = 0;
		        var checkStr = funcChkTypeStatus() ;
	            if( checkStr != "X"  ){
            		if( checkStr == "O" ){
            			checkPnt = 4;
            		}else if ( checkStr == "D" ){
            			checkPnt = 5;
            		}
	            	
	            	var pntSheet = sheetObjects[checkPnt];
	            	var viaSheet = sheetObjects[checkPnt-3];//origin via, 또는 dest via
	            	if( pntSheet.IsDataModified ){
	            		//1. 유효한 via가 달라 졌는지 확인한다.
	            		//1.1 먼저 distinct한 base port code를 모은다.
	        			 
	         			// 현재 입력된 POINT의 유효한 BASE PORT를 모았다.
	         			var basePortLocCdList = getPortLocationList(pntSheet ,"bse_port_def_cd");
	         			
	         			// VIA의 유효 PORT를 모은다.
	         			var viaPortLocCdList =  getPortLocationList(viaSheet ,"rout_via_port_def_cd");
	         			var strBasePortCd = basePortLocCdList.join("|");
	         			var strViaPortCd = viaPortLocCdList.join("|");
//alert("strBasePortCd="+strBasePortCd)
//alert("strViaPortCd="+strViaPortCd)
	            		//2. 만약 유효한 via가 달라졌다면 via를 모두 삭제 또는 삭제 amend를 하고 new로 via를 insert한다.
	         			if( strBasePortCd != strViaPortCd ){
	         				//alert("모두 삭제 후 다시 넣어야 한다.");
	         				deleteAndInsertVia(viaSheet, basePortLocCdList );
	         			}
	            	}
	
	            	
	            }
	            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	        
	            var idx = 0;
	            for (var a = 0; a <= 3; a++) {
	            	var tpColNm;
	            	var defColNm;
	            	idx = a;
	            	
	            	if (idx == 0 || idx == 3) {
	            		tpColNm = "rout_pnt_loc_tp_cd";
	            		defColNm = "rout_pnt_loc_def_cd";
	            	} else if (idx == 1 || idx == 2) {
	            		tpColNm = "rout_via_port_tp_cd";
	            		defColNm = "rout_via_port_def_cd";
	            	}
	            	
	            	var sheetObj = null;
	            	var ficRtTpCd = document.form.fic_rt_tp_cd.value;
	    		    var svcScpCd = document.form.svc_scp_cd.value;
	    		    
	    		    if(idx == 0 && ("A"==ficRtTpCd && "AEE"==svcScpCd)){
	    		    	idx = 4;
	    		    }else if(idx == 3 && ("A"==ficRtTpCd && "AEW"==svcScpCd)){
	    		    	idx = 5;
	    		    }
	    		    
	    		    sheetObj = sheetObjects[idx];
	            	
		            for (var i = sheetObjects[idx].HeaderRows; sheetObjects[idx].RowCount > 0 && i <= sheetObjects[idx].LastRow; i++) {
		            	if (sheetObjects[idx].CellValue(i, "n1st_ord_ref") == "" || sheetObjects[idx].CellValue(i, "n2nd_ord_ref") == "") {
		            		var n1stOrdRef;
		            		if (sheetObjects[idx].CellValue(i, tpColNm) == "G") {
		            			n1stOrdRef = 1;
		            		} else if (sheetObjects[idx].CellValue(i, tpColNm) == "L") {
		            			n1stOrdRef = 2;
		            		} else {
		            			n1stOrdRef = 99;
		            		}
		            		sheetObjects[idx].CellValue2(i, "n1st_ord_ref") =  n1stOrdRef;
		            		sheetObjects[idx].CellValue2(i, "n2nd_ord_ref") = sheetObjects[idx].CellValue(i, defColNm);
		            	}
		            }
		            
		            //소트시 테이블이 다르기때문에 분류함.
		            if(idx == 0 || idx == 3 || idx == 4 || idx == 5) {
		            	sheetObjects[idx].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
		            } else if (idx == 1 || idx == 2) {
		            	sheetObjects[idx].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
		            }
		            
					var sXml = ComPriSheet2Xml(sheetObjects[idx]);
  					dialogArguments.setSheetXml(sXml, a + 6);
	            }
	            
         
	            window.returnValue = "O";
	            window.close();
	            
				if (exTransaction) {
					dialogArguments.restylingPagePostTr();
				}
	            
	            break; 
	            
			case IBCLEAR: // 로딩시 코드조회
				var sXml_Origin_Pri = ""; //이건 기본으로 조회 해야함. -CD02070
				var sXml_Dest_Pri = ""; //이건 기본으로 조회 해야함. - CD02071
				//공통 - type
				sheetObjects[0].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);		
				sheetObjects[1].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[2].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[3].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[4].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[5].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			
				//공통 term
				formObj.f_cmd.value = SEARCH19;
				//sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				
		     	var ficRtTpCd = document.form.fic_rt_tp_cd.value;
			    var svcScpCd = document.form.svc_scp_cd.value;

			    //이건 CY Only인지 IHC인지에 따라 표준코드를 다르게 조회 한다. CY : CD03076 , IHC : CD03078 
			    //이건 CY Only인지 IHC인지에 따라 표준코드를 다르게 조회 한다.   CY : CD03075 , IHC : CD03077
				if(ficRtTpCd == "A") {
					if(svcScpCd == 'AEE') {
						stdOriginCode = "CD02070";//"CD03078";정석환 과장님 요청으로 CY를 다시 포함 시킴(원복)
						stdDestCode = "CD02071";						
					} else if(svcScpCd == 'AEW') {
						stdOriginCode = "CD02070";
						stdDestCode = "CD02071";//"CD03077";정석환 과장님 요청으로 CY를 다시 포함 시킴(원복)		
					}
				}else{
					if(svcScpCd == 'AEE') {
						stdOriginCode = "CD03076";
						stdDestCode = "CD02071";						
					} else if(svcScpCd == 'AEW') {
						stdOriginCode = "CD02070";
						stdDestCode = "CD03075";		
					}
				}
				sXml_Origin_Pri = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd="+stdOriginCode);
				sXml_Dest_Pri = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd="+stdDestCode);
				
				setIBCombo(sheetObjects[0], sXml_Origin_Pri, "rcv_de_term_cd", false, 0, "Y");
				setIBCombo(sheetObjects[4], sXml_Origin_Pri, "rcv_de_term_cd", true, 0);
				//sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObjects[3], sXml_Dest_Pri, "rcv_de_term_cd", false, 0, "Y");
				setIBCombo(sheetObjects[5], sXml_Dest_Pri, "rcv_de_term_cd", true, 0);
				
				//공통 trans mode
				formObj.f_cmd.value = SEARCH19;
				//sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);				
				setIBCombo(sheetObjects[4], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[5], sXml, "prc_trsp_mod_cd", true, 0);
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
 	            var ficRtTpCd = document.form.fic_rt_tp_cd.value;
	            var svcScpCd = document.form.svc_scp_cd.value;
	            var sheetObj = null;
	            
	            if("A" == ficRtTpCd && "AEE"==svcScpCd){
	            	sheetObj = sheetObjects[4]; // 신규 로직을 위한 grid
	            	//신규 로직에 의해서 GROUP CODE와 RATE등을 읽어 들인다.
	            }else{
	            	sheetObj = sheetObjects[0]; // 기존 grid
	            }
	            sheetObj.LoadSearchXml(sXml6);
	            sheetObj.ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObj, -1);
	            if("A"==ficRtTpCd && "AEE"==svcScpCd){
	            	//신규 로직에 의해서 GROUP CODE와 RATE등을 읽어 들인다.
	            	var cnt = sheetObj.HeaderRows ;
	            	var rowCnt = sheetObj.RowCount ;
	            	for(var idx = cnt ; idx < cnt+rowCnt ; idx++){
		    			formObj.rout_tgt_row.value = idx;
		    			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
	            	}
	            } 	            
	            
	            var sXml7 = dialogArguments.getSheetXml(7);
	            sheetObjects[1].LoadSearchXml(sXml7);
	            sheetObjects[1].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[1], -1);
	            
	            var sXml8 = dialogArguments.getSheetXml(8);
	            sheetObjects[2].LoadSearchXml(sXml8);
	            sheetObjects[2].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[2], -1);
	            
	            var sXml9 = dialogArguments.getSheetXml(9);
	            if("A"==ficRtTpCd && "AEW"==svcScpCd){
	            	sheetObj = sheetObjects[5]; // 신규 로직을 위한 grid	            	
	            }else{
	            	sheetObj = sheetObjects[3]; // 기존 grid
	            }
	            sheetObj.LoadSearchXml(sXml9);
	            sheetObj.ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObj, -1);
	            
	            if("A"==ficRtTpCd && "AEW"==svcScpCd){
	            	//신규 로직에 의해서 GROUP CODE와 RATE등을 읽어 들인다.
	            	var cnt = sheetObj.HeaderRows ;
	            	var rowCnt = sheetObj.RowCount ;
	            	for(var idx = cnt ; idx < cnt+rowCnt ; idx++){
		    			formObj.rout_tgt_row.value = idx;
		    			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
	            	}
	            } 
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
			        var checkStr = funcChkTypeStatus() ;
			        // ihc logic이 있는 쪽은 default로 Door로 한다.
		            if( checkStr == "O" && sheetObj.id == "sheet5"  ){
		            	sheetObj.CellValue2(idx, "rcv_de_term_cd") = "D";
		            }else if( checkStr == "D" && sheetObj.id == "sheet6"  ){
			            sheetObj.CellValue2(idx, "rcv_de_term_cd") = "D";
		            }else{
		            	sheetObj.CellValue2(idx, "rcv_de_term_cd") = "Y";
		            }
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
				
			case IBSEARCH_ASYNC06: //Search FIC Route
				formObj.f_cmd.value = SEARCH01;
				var Row = formObj.rout_tgt_row.value;
				var sParam = FormQueryString(formObj);
				sParam += "&svc_scp_cd=" + sheetObj.CellValue(Row, "svc_scp_cd") +
				          "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") +
				          "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd") +
				          "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") +
				          "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd") +
				          "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
				//var sXml = sheetObj.getSearchXml("ESM_PRI_2025GS.do", sParam);
				var sXml = sender.getSearchXml("ESM_PRI_2028GS.do", sParam);
				var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
 				sender.LoadSearchXml(sXml);
				if (sender.EtcData(ComWebKey.Trans_Result_Key) == "F") { //서버오류
		            disableButton("btn_ok");					
				}else{
					enableButton("btn_ok");
				}				
				
				if(arr!=null && arr.length>0){
					sheetObj.CellComboItem(Row, "bse_port_def_cd", " |"+arr[0], " |"+arr[1]); 
				}
				break;
				
			case IBSEARCH_ASYNC07: //Search FIC Route
				if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
				formObj.f_cmd.value = SEARCH01;
				var Row = formObj.rout_tgt_row.value;
				var sParam = FormQueryString(formObj);
				sParam += "&svc_scp_cd=" + sheetObj.CellValue(Row, "svc_scp_cd") +
		          "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") +
		          "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd") +
		          "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") +
//		          "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd") +
		          "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
				//var sXml = sheetObj.getSearchXml("ESM_PRI_2025GS.do", sParam);
				var sXml = sender.getSearchXml("ESM_PRI_2028GS.do", sParam);
 				var saveName = "base_port_list|prc_trsp_mod_cd";
				var saveNameArr = saveName.split("|");
				
				var arrDesc = ComPriXml2Array(sXml, saveName);
 				sender.LoadSearchXml(sXml);
				if (sender.EtcData(ComWebKey.Trans_Result_Key) == "F") { //서버오류
		            disableButton("btn_ok");					
				}else{
					enableButton("btn_ok");
				}
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObj.CellValue2(Row, "base_port_list") = arrDesc[0][0];
					sheetObj.CellValue(Row, "prc_trsp_mod_cd") = arrDesc[0][1];
				}
				break;
				
			case IBSEARCH_ASYNC08: //Search FIC Route
//				if(!validateForm(sheetObj,formObj,sAction)) {
//	     			ComOpenWait(false);
//	     			return false;
//	     		}
				formObj.f_cmd.value = SEARCH01;
				var Row = formObj.rout_tgt_row.value;
				var sParam = FormQueryString(formObj);
				var preRowStatus = sheetObj.RowStatus(Row);
 
				sParam += "&svc_scp_cd=" + sheetObj.CellValue(Row, "svc_scp_cd") +
		          "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") +
		          "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd") +
		          "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") +
		          "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd") +
		          "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");

 				//var sXml = sheetObj.getSearchXml("ESM_PRI_2025GS.do", sParam);
				var sXml = sender.getSearchXml("ESM_PRI_2028GS.do", sParam);
				
				var saveName = "fic_rt_use_sts_cd";
				var saveNameArr = saveName.split("|");
				var arrDesc = ComPriXml2Array(sXml, saveName);
				
 				sender.LoadSearchXml(sXml);
				if (sender.EtcData(ComWebKey.Trans_Result_Key) == "F") { //서버오류
		            disableButton("btn_ok");					
				}else{
					enableButton("btn_ok");
				}				
				
				if (arrDesc != null && arrDesc.length > 0) {
					var data = arrDesc[0][0].split("|");
					sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = data[0];
					sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = data[1];
					sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = data[2];
					sheetObj.CellValue2(Row, "group_no") = ComTrim(data[3]);
					if(data[4]){
						sheetObj.CellValue2(Row, "dr_20ft_amt") = data[4].trim();
					}
					if(data[5]){
						sheetObj.CellValue2(Row, "rf_20ft_amt") = data[5].trim();
					}
					if(data[6]){
						sheetObj.CellValue2(Row, "dg_20ft_amt") = data[6].trim();
					}
					if(data[7]){
						sheetObj.CellValue2(Row, "dr_40ft_amt") = data[7].trim();
					}
					if(data[8]){
						sheetObj.CellValue2(Row, "rf_40ft_amt") = data[8].trim();
					}
					if(data[9]){
						sheetObj.CellValue2(Row, "dg_40ft_amt") = data[9].trim();
					}
					if(data[10]){					
						sheetObj.CellValue2(Row, "locl_curr_cd") = data[10];
					}
					if(data[11]){					
						sheetObj.CellValue2(Row, "dr_locl_20ft_amt") = data[11].trim();
					}
					if(data[12]){					
						sheetObj.CellValue2(Row, "rf_locl_20ft_amt") = data[12].trim();
					}
					if(data[13]){					
						sheetObj.CellValue2(Row, "dg_locl_20ft_amt") = data[13].trim();
					}
					if(data[14]){					
						sheetObj.CellValue2(Row, "dr_locl_40ft_amt") = data[14].trim();
					}
					if(data[15]){					
						sheetObj.CellValue2(Row, "rf_locl_40ft_amt") = data[15].trim();
					}
					if(data[16]){					
						sheetObj.CellValue2(Row, "dg_locl_40ft_amt") = data[16].trim();
					}										
					 				
				}
 				sheetObj.RowStatus(Row) = preRowStatus;
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
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4" ) {
        		dupRow = ComPriAmendDupCheck(sheetObj, "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd", formObj.amdt_seq.value);
        	}else if ( sheetObj.id == "sheet5" || sheetObj.id == "sheet6") {
            	dupRow = ComPriAmendDupCheck(sheetObj, "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|bse_port_def_cd|prc_trsp_mod_cd", formObj.amdt_seq.value);
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
        case IBSEARCH_ASYNC07:
			var Row = sheetObj.SelectRow;
			if(sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == "" ||
					sheetObj.CellValue(Row, "rcv_de_term_cd") == "" ||
					sheetObj.CellValue(Row, "bse_port_def_cd") == ""){
				//ComShowCodeMessage("PRI01001");
				return false;
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
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4" || sheetObj.id == "sheet5" || sheetObj.id == "sheet6" ) {
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_tp_cd") = true;
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_def_cd") = true;
	        	sheetObj.CellEditable(idx, "rcv_de_term_cd") = true;
	        	sheetObj.CellEditable(idx, "prc_trsp_mod_cd") = true;
	        	if(sheetObj.id == "sheet5" || sheetObj.id == "sheet6" ){
		        	sheetObj.CellEditable(idx, "bse_port_def_cd") = true;
	        	}
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.CellEditable(idx, "rout_via_port_tp_cd") = true;
	        	sheetObj.CellEditable(idx, "rout_via_port_def_cd") = true;
        	}
		} else {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4" || sheetObj.id == "sheet5" || sheetObj.id == "sheet6" ) {
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_tp_cd") = false;
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_def_cd") = false;
	        	sheetObj.CellEditable(idx, "rcv_de_term_cd") = false;
	        	sheetObj.CellEditable(idx, "prc_trsp_mod_cd") = false;
	        	if(sheetObj.id == "sheet5" || sheetObj.id == "sheet6" ){
		        	sheetObj.CellEditable(idx, "bse_port_def_cd") = false;
	        	}	        	
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.CellEditable(idx, "rout_via_port_tp_cd") = false;
	        	sheetObj.CellEditable(idx, "rout_via_port_def_cd") = false;
        	}
		}
    }
    
	function rtPntOnClick() {
		var curIndex = parseInt(getRtPnt());
		var curIndex2 = parseInt(getRtPntNew());
 		if (beforeIndex != curIndex2) {
			if (beforeIndex >= 0 && !validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
				var tmpIndex = beforeIndex;
				if(beforeIndex==5){
					tmpIndex = 3;
				}else if(beforeIndex==4){
					tmpIndex = 0;
				} 
				document.form.rt_pnt[tmpIndex].checked = true;
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
		    
 		    var ficRtTpCd = document.form.fic_rt_tp_cd.value;
		    var svcScpCd = document.form.svc_scp_cd.value;
 
		    
		    objs[curIndex2].style.display = "inline";
		    if (beforeIndex >= 0) {
				objs[beforeIndex].style.display = "none";
		    }
			
		    beforeIndex = curIndex2;
		}
	}
	
    function getRtPnt() {
        for (var i = 0; i < document.form.rt_pnt.length; i++) {
            if (document.form.rt_pnt[i].checked) {
                return document.form.rt_pnt[i].value;
            }
        }
    }
    
    function getRtPntNew() {
    	var rtPnt = -1;
        for (var i = 0; i < document.form.rt_pnt.length; i++) {
            if (document.form.rt_pnt[i].checked) {
                rtPnt = document.form.rt_pnt[i].value;
                break;
            }
        }
        
        var ficRtTpCd = document.form.fic_rt_tp_cd.value;
	    var svcScpCd = document.form.svc_scp_cd.value;
	    
	    if(rtPnt==0 && "A"==ficRtTpCd && "AEE"==svcScpCd){
	    	rtPnt = 4;
	    }else if(rtPnt==3 && "A"==ficRtTpCd && "AEW"==svcScpCd){
	    	rtPnt = 5;
	    }
	    return rtPnt;
    }
    
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
	 * Change가 발생한 Row를 초기화 한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	 * @return 없음
	 * @author 김재연
	 * @version 2009.05.19
	 */ 
    function initFicRoute(sheetObj, Row, Col) {
    	var formObj = document.form;
    	var amdt_seq = formObj.amdt_seq.value;
    	
    	sheetObj.Redraw = false;
		var saveName = sheetObj.ColSaveName(Col);
		switch(saveName){
			
			case "rout_pnt_loc_def_cd":
				//term은 reset 대상에서 제외 됐다.
				//sheetObj.CellValue(Row, "rcv_de_term_cd") = "";
 				sheetObj.CellComboItem(Row, "bse_port_def_cd", " ", " ");
				formObj.rout_tgt_row.value = Row;
				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);				
				break;
			case "rcv_de_term_cd":
				sheetObj.CellComboItem(Row, "bse_port_def_cd", " ", " ");
				break;
			case "bse_port_def_cd":
				sheetObj.CellValue2(Row, "prc_trsp_mod_cd") = "";
				sheetObj.CellValue2(Row, "rat_ut_cd") = "";
//				sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
				sheetObj.CellValue2(Row, "prop_frt_rt_amt") = "";
				sheetObj.CellValue2(Row, "fic_gline_rt_amt") = "";
				sheetObj.CellValue2(Row, "diff_with_gl") = "";
				sheetObj.CellValue2(Row, "base_port_list") = "";
				sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = "";
				sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = "";
				sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = "";
				sheetObj.CellValue2(Row, "fic_gline_upd_dt") = "";
				sheetObj.CellValue2(Row, "group_no") = "";
				sheetObj.CellValue2(Row, "dr_20ft_amt") = "";
				sheetObj.CellValue2(Row, "rf_20ft_amt") = "";
				sheetObj.CellValue2(Row, "dg_20ft_amt") = "";
				sheetObj.CellValue2(Row, "dr_40ft_amt") = "";
				sheetObj.CellValue2(Row, "rf_40ft_amt") = "";
				sheetObj.CellValue2(Row, "dg_40ft_amt") = "";
				
				sheetObj.CellValue2(Row, "locl_curr_cd") = "";
				sheetObj.CellValue2(Row, "dr_locl_20ft_amt") = "";
				sheetObj.CellValue2(Row, "rf_locl_20ft_amt") = "";
				sheetObj.CellValue2(Row, "dg_locl_20ft_amt") = "";
				sheetObj.CellValue2(Row, "dr_locl_40ft_amt") = "";
				sheetObj.CellValue2(Row, "rf_locl_40ft_amt") = "";
				sheetObj.CellValue2(Row, "dg_locl_40ft_amt") = "";
				
				break;
		}
		sheetObj.Redraw = true;
    }
    
    /**
     * bse_port_def_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function checkBasePort(sheetObj, Row, Value) {
		if (sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") != "" && sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	
	/**
     * location code 유효성 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		
		var formObj = document.form;
		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
		var sender = sheetObjects[6];
		
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value = SEARCH05; 	    			
			//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + locCd);
			var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + locCd);
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = arrDesc[0][1];
//					sheetObj.SelectCell(Row, "rcv_de_term_cd");
				}
			} else {	
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = "";
				}
//				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
			formObj.f_cmd.value = COMMAND24;
			var sParam = FormQueryString(formObj) + "&cd=" + locCd;
			sParam += "&etc1="+PRI_RP_SCP;
			//var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var sXml = sender.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "G";
			} else {
				sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
//				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			if (cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = "";
			}
//			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	
	/**
     * location code 를 리셋하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.CellValue2(Row, cellTpCdNm) = "";
		sheetObj.CellValue2(Row, cellDefCdNm) = "";
	}
	
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.05.20
     */
	function sheet5_OnSearchEnd(sheetObj, errMsg)  {
		var sRow = sheetObj.HeaderRows;
		var eRow = sRow + sheetObj.RowCount;
		for(var i=sRow; i < eRow; i++){
			// base port list 구성
			var bsePortDefCd = sheetObj.CellValue(i, "bse_port_def_cd");
			var basePortList = sheetObj.CellValue(i, "base_port_list");
			var preStatus = sheetObj.RowStatus(i);
			
			if(basePortList!="" && (bsePortDefCd != basePortList)){
				sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + basePortList,  " |" + basePortList);
			} else {
				sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + bsePortDefCd,  " |" + bsePortDefCd);
			}
			sheetObj.CellValue2(i, "bse_port_def_cd") = bsePortDefCd;
			sheetObj.RowStatus(i) = preStatus;

		}
		
	}
	
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.05.20
     */
	function sheet6_OnSearchEnd(sheetObj, errMsg)  {
		
		var sRow = sheetObj.HeaderRows;
		var eRow = sRow + sheetObj.RowCount;
		
		for(var i=sRow; i<eRow; i++){
			// base port list 구성
			var prcTrspModCd = sheetObj.CellValue(i, "prc_trsp_mod_cd");
			var bsePortDefCd = sheetObj.CellValue(i, "bse_port_def_cd");
			var basePortList = sheetObj.CellValue(i, "base_port_list");
			var preStatus = sheetObj.RowStatus(i);
			if(basePortList!="" && (bsePortDefCd != basePortList)){
				sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + basePortList,  " |" + basePortList);
			}else{
				sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + bsePortDefCd,  " |" + bsePortDefCd);
			}
			sheetObj.CellValue2(i, "prc_trsp_mod_cd") = prcTrspModCd;
			sheetObj.CellValue2(i, "bse_port_def_cd") = bsePortDefCd;
			
			sheetObj.RowStatus(i) = preStatus;
		}
	}
	
	/**
     * OK Button Click 이벤트 발생시 호출되는 function <br>
     * <br><b>Example : checkGroupNo()</b>
     * <pre>
     * 
     * </pre>
     * @return boolean
     * @author 김재연
     * @version 2009.05.20
     */
	function checkGroupNo(){
		
		var x = 0;
		
		var sheetObj = null;
		if(sheetObjects[4].IsDataModified){
			sheetObj = sheetObjects[4];
		}else if(sheetObjects[5].IsDataModified){
			sheetObj = sheetObjects[5];
		}else{
			return true;
		}

		var sRow = 0;
		var eRow = 0;
		var check = true;
		if(sheetObj.IsDataModified){
			
			sRow = sheetObj.HeaderRows;
			eRow = sRow + sheetObj.RowCount;
			

			var preGroupNo ="";
			var currGroupNo ="";
			var checkCnt = 0;
			var amdtSeq = document.form.amdt_seq.value;
			for(var i=sRow; i<eRow; i++){
	            if (sheetObj.RowStatus(i) == "D" || sheetObj.CellValue(i, "amdt_seq") != amdtSeq
	                    || sheetObj.CellValue(i, "src_info_cd") == "AD") {
	                continue;
	            }
				if( checkCnt == 0 ){
					currGroupNo = ComTrim(sheetObj.CellValue(i, "group_no"));
				}else{
					currGroupNo = ComTrim(sheetObj.CellValue(i, "group_no"));
					//N/A는 오직 1개만 갖을수 있다.
					if( currGroupNo == "N/A" && checkCnt != 0  ){
						check = false;
						break;					
					}
					if(preGroupNo != currGroupNo ){
						check = false;
						break;	
					}
				}
				preGroupNo = currGroupNo;
				checkCnt++;
				 
			}
		}
		if(!check){
			ComShowCodeMessage("PRI00308", "check", "the location group no.");
		}
		return check;
	}
 
    function getPortLocationList(pntSheet, colName){
		var sRow = pntSheet.HeaderRows;
		var eRow = sRow + pntSheet.RowCount;

		var basePortLocCdList = [];

		var checkCnt = 0;
		var amdtSeq = document.form.amdt_seq.value;
		for(var i=sRow; i<eRow; i++){
            if (pntSheet.RowStatus(i) == "D" || pntSheet.CellValue(i, "amdt_seq") != amdtSeq
                    || pntSheet.CellValue(i, "src_info_cd") == "AD") {
                continue;
            }
            if( checkCnt != 0 ){
            	var strBasePortCd = basePortLocCdList.join("|");
            	//같은 것이 있다면 건너 뛴다.
            	if( strBasePortCd.indexOf(pntSheet.CellValue(i, colName)) >=0){
            		continue;
            	}
            }
            basePortLocCdList[ checkCnt ] = pntSheet.CellValue(i, colName);
			checkCnt++;
		}
		// 현재 입력된 POINT의 유효한 BASE PORT를 모았다.
		basePortLocCdList = basePortLocCdList.sort();    
		return basePortLocCdList;
    }
    
    function deleteAndInsertVia(viaSheet, viaPortLocCdList ){
    	var formObj = document.form;
    	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
            return false;
        }
    	if (formObj.prc_prop_sts_cd.value != "I") {
    		return false;
    	}
    	if (dialogArguments.isCMDTGroupDeleted()) {
    		return false;
    	}
    	//모든 데이터 삭제를 위한 check
    	viaSheet.CheckAll2("chk") = 1;
    	var sCheckedRows = viaSheet.FindCheckedRow("chk");
    	var arrCheckedRows = new Array();
    	if (sCheckedRows != "") {
    		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	    	cancelAllAmend(viaSheet );
	    	deleteAllAmend(viaSheet);
	    	//deleteRowCheck(viaSheet, "chk");
    	}


    	//삭제 완료
    	// insert해야 한다.
		/////////////////////////////////////////////////
    	var prePntViaType = curPntViaType;
    	var preOrgDestType = curOrgDestType;
    	
		var chkType = funcChkTypeStatus() ;
		if (chkType == "O") {
			curPntViaType = "V";
		    curOrgDestType = "O";
		} else if (chkType == "D") {
			curPntViaType = "V";
		    curOrgDestType = "D";
		}else{
			alert("Error Distinct Via")
		}
 		document.form.org_dest_tp_cd.value = curOrgDestType;
		document.form.pnt_via_tp_cd.value = curPntViaType;
 		///////////////////////////////////////////////////
    	
    	var viaLeng = viaPortLocCdList.length;
    	viaSheet.SelectRow = viaSheet.LastRow ;
    	 
    	
		//alert("삽입갯수"+viaLeng)

    	for (var i = 0 ; i < viaLeng; i++) {
    		//alert("시작한다.")
    		doActionIBSheet(viaSheet, formObj, IBINSERT);
    		//alert("action종료")
    		var selRow = viaSheet.SelectRow;
    		
    		viaSheet.CellValue(selRow, "rout_via_port_def_cd" )  = viaPortLocCdList[i];
    	}
    	curPntViaType = prePntViaType;
    	curOrgDestType = preOrgDestType;

    }
    
	/**
	 * Type과 Service Scope에 따른 리턴
	 * 
	 */
	function funcChkTypeStatus() {
     	var ficRtTpCd = document.form.fic_rt_tp_cd.value;
	    var svcScpCd = document.form.svc_scp_cd.value;

		var rsltVal = 'X';
		if(ficRtTpCd == "A") {
			if(svcScpCd == 'AEE') {
				rsltVal = 'O';
			} else if(svcScpCd == 'AEW') {
				rsltVal = 'D';
			}
		} 
		return rsltVal;
	}    
	 
	/**
	 *  CY 에 따른 Location 입력 가능 여부를 check한다.
	 * 
	 */
	function validateCYPortLocation( sheetObj, row, value , locType) {
		 var formObj = document.form;
		 var ficRtTpCd = formObj.fic_rt_tp_cd.value;
		 var svcScpCd = formObj.svc_scp_cd.value;
		 
		// ihc 운임
		if(ficRtTpCd == "A") {
			if( (svcScpCd == 'AEE' && sheetObj.id=="sheet5" ) || (svcScpCd == 'AEW' && sheetObj.id=="sheet6" ) ) {
				//Origin쪽에 location은 CY Location이 아닌 것만 입력 가능 한데 door는 모두 입력 가능 한다. POINT
				if( sheetObj.CellValue(row, "rcv_de_term_cd") != "D" ) { // door term은 CY도 들어 갈수 있다.
					// 서버에 조회 시도
					//alert("CY가 들어 갈수 없다.");
					if( !searchCYPortLocation( sheetObj, row, value , locType, ficRtTpCd) ){				
						return false;
					}
				}
			} 
		}else if( (svcScpCd == 'AEW' && sheetObj.id=="sheet4") || (svcScpCd == 'AEE' && sheetObj.id=="sheet1")  ) {
			//먼저 call port flag가 'Y'인지 검사를 해서 'Y'가 아니라면 못들어 간다.			
			// Dest 쪽에  Y만 들어 갈수 있다
			//먼저 call port flag가 'Y'인지 검사를 해서 'Y'가 아니라면 못들어 간다.
			//alert("CY만 들어 갈수 있다.1");
			if( !searchCYPortLocation( sheetObj, row, value , locType, ficRtTpCd)){	
				return false;
			}
		}
		
		return true;
	}
	 
	
	function searchCYPortLocation( sheetObj, row, value , locType, ficRtTpCd){
		//먼저 call port flag가 'Y'인지 검사를 해서 'Y'가 아니라면 못들어 간다.
		var formObj = document.form;

		formObj.f_cmd.value = SEARCH02;
		var sender = sheetObjects[6];
		var sParam = FormQueryString(formObj);		
		var loc_cd = sheetObj.CellValue(row, "rout_pnt_loc_def_cd");
		sParam += "&loc_type_cd="+locType+"&loc_cd=" + loc_cd;
		
		//var sXml = sheetObj.getSearchXml("ESM_PRI_2025GS.do", sParam);
		var sXml = sender.getSearchXml("ESM_PRI_2028GS.do", sParam);
		var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
		var arrDesc = ComPriXml2Array(sXml, "loc_cd|call_port_flg");
		if(arrDesc!=null && arrDesc.length>0){
			if( ficRtTpCd == "A"){
				//alert("있으면 안돼");
				var locCd = arrDesc[0][0];
				var callPortFlg = arrDesc[0][1];
				if (callPortFlg == "Y" && locCd != "ESBIO" && locCd != "DKAAR" && locCd != "DKFRC" ) {
					ComShowCodeMessage("PRI07020" );
					return false;
				}	
			}else{
				var flg = false;
				for (var i = 0; i < arrDesc.length; i++) {
					var locCd = arrDesc[i][0];
					var callPortFlg = arrDesc[i][1];

					if (callPortFlg == "N") {
						ComShowCodeMessage("PRI07013" );
						flg = true;
						break;
					}
				}
				if( flg ){
					//alert("이어야만해.");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 선택된 Row에 대해 Amend Cancel 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function doRowAmendCancel(sheetObj) {
   	var idx  = sheetObj.SelectRow;
		var prevIdx = idx - 1;
		
		if (sheetObj.CellValue(idx, "ibflag") != "I") {
			if (document.form.dur_dup_flg.value == "Y") {
				sheetObj.CellValue2(prevIdx, "exp_dt") = document.form.exp_dt.value;
			}
			sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value;
			// 이 부분은 Amend와 Amend Cancel을 반복할 경우, 저장이 안되는 경우를 위한 코드.
			// 이는 IBSheet에서 Amend Cancel시  다시 원복된 값이 조회당시 값과 같다고 인식해서 row의 status를 R로 인식하는 문제. 
			if (sheetObj.CellSearchValue(idx, "amdt_seq") != unescape("%00")) {
				sheetObj.RowStatus(prevIdx) = "U";
			}
		}
		sheetObj.RowDelete(idx, false);
		
		return prevIdx;
   }
	/**
	 * 선택된 Row에 대해 Amend or Amend Delete 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
   function doRowAmend(sheetObj, sAction) {
		var idx = sheetObj.DataCopy();
		var prevIdx = idx - 1;
		
		sheetObj.CellValue2(idx, "eff_dt") = document.form.eff_dt.value;
		sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = document.form.amdt_seq.value;
		sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
		sheetObj.CellValue2(idx, "prc_prog_sts_nm") = "Initial";
		sheetObj.CellValue2(idx, "src_info_cd") = sAction;
		if (sAction == "AM") {
			sheetObj.CellValue2(idx, "src_info_nm") = "Amend";
		} else if (sAction == "AD") {
			sheetObj.CellValue2(idx, "src_info_nm") = "Delete";
		}
		
		if (document.form.dur_dup_flg.value == "Y") {
			sheetObj.CellValue2(prevIdx, "exp_dt") = document.form.pre_exp_dt.value;
		}
		sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.pre_amdt_seq.value;
		
		sheetObj.RowStatus(prevIdx) = "R";
		sheetObj.RowStatus(idx) = "U";
		
		return idx;
   }
	function cancelAllAmend(delSheetObj ){
		var formObj = document.form;
 		// 기존 Amend를 모두 Cancel한다.
		if (formObj.amdt_seq.value != "0") {
         	for (var i = delSheetObj.HeaderRows; delSheetObj.RowCount > 0 && i <= delSheetObj.LastRow; i++) {
         		// Sheet4~6중 CMDT Group의 체크된 항목과 같은 CMDT_HDR_SEQ를 가진 항목들은 기존 Amend를 Cancel처리한다.
        		if (delSheetObj.CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
        			delSheetObj.SelectRow = i + 1;
        			
        			var newNoteConvMapgId = "";
        			var prevNoteConvMapgId = "";
                 	// Amend Cancel
                	var prevIdx = doRowAmendCancel(delSheetObj);
        		}
        	}
		}		
	}
     
	function deleteAllAmend(delSheetObj){
		var formObj = document.form;
    	// 새로 Amend Delete 또는 Delete한다.
    	for (var i = delSheetObj.LastRow; delSheetObj.RowCount > 0 && i >= delSheetObj.HeaderRows; i--) {
    		// Amend Delete
        	if (delSheetObj.CellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		delSheetObj.SelectRow = i;
        		delSheetObj.CellValue2(delSheetObj.SelectRow, "chk") = "0";
            	
           		var idx = doRowAmend(delSheetObj, "AD");
           	// Row Delete
        	} else if (delSheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
        			&& (delSheetObj.CellValue(i, "src_info_cd") == "NW"
        				|| delSheetObj.CellValue(i, "src_info_cd") == "GC"
        				|| delSheetObj.CellValue(i, "src_info_cd") == "GM"
        				|| delSheetObj.CellValue(i, "src_info_cd") == "PC"
        				|| delSheetObj.CellValue(i, "src_info_cd") == "PM")) {
                //delSheetObj.RowDelete(i, false);
                delSheetObj.RowStatus(i) = "D";
        	}
    	}		
	}
     