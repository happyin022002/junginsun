/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2022.js
*@FileTitle : RFA Proposal Creation - Rate (Commodity Note)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.08.24 박성수
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.05.25 이행지 [CHM-201111048-01] ALPS Error 처리- Commodity Note null 입력금지, 4000Byte 이상 입력금지
* 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가
* 2015.04.02 송호진 [CHM-201535140] S/C Note conversion에 중복 체크 로직 수정요청 - validateDupCheck 상의 로직 오류 수정 
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
    function ESM_PRI_2022() {
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
    var eventToken = false;
    
    var sChgCdVisiable = "";
	
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
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
	
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
				doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
				break;
				
			case "btn_amend":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC11);
				break;

			case "btn_amendcancel":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC12);
				break;
	
			case "btn_accept":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC13);
				break;
	
			case "btn_acceptcancel":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC14);
				break;
	
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
	
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
			
			case "btn_rowadd3":
				if(validateFormConversion(sheetObject3,formObject,COMMAND10)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND10);
				}
				break;
				
			case "btn_copy":
				if(validateFormConversion(sheetObject3,formObject,COMMAND11)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND11);
				}
				break;
				
			case "btn_paste":
				if(validateFormConversion(sheetObject3,formObject,COMMAND12)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND12);
				}
				break;
				
			case "btn_rowadd3":
				if(validateFormConversion(sheetObject3,formObject,IBINSERT)) {
					doActionIBSheet(sheetObject3,formObject,IBINSERT);
				}
				break;
				
			case "btn_rowcopy":
				if(validateFormConversion(sheetObject3,formObject,IBCOPYROW)) {
					doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
				}
				break;
				
			case "btn_delete3":
				if(validateFormConversion(sheetObject3,formObject,COMMAND13)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND13);
				}
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
		
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListener('change', 'ta_note_ctnt_OnChange', 'ta_note_ctnt');
		
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
        	enableButton("btn_delete");
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
        	
        	enableButton("btn_copy");
        	enableButton("btn_paste");
        	enableButton("btn_rowadd3");
        	enableButton("btn_rowcopy");
        	enableButton("btn_delete3");
        	
        	sheetObjects[2].Editable = true;
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_delete");
    		disableButton("btn_amend");
    		disableButton("btn_amendcancel");
    		
    		disableButton("btn_copy");
    		disableButton("btn_paste");
    		disableButton("btn_rowadd3");
    		disableButton("btn_rowcopy");
    		disableButton("btn_delete3");
    		
    		sheetObjects[2].Editable = false;
    	}
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_accept");
        	enableButton("btn_acceptcancel");
    	} else {
            disableButton("btn_accept");
            disableButton("btn_acceptcancel");
    	}
    	
    	if ((!bIsReqUsr && !bIsAproUsr) || dialogArguments.isCMDTGroupDeleted()) {
    		for (i = 1; i < sheetObjects.length; i++) {
    			sheetObjects[i].Editable = false;
    		}
    	}
		
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        eventToken = true;
	}
	
	/**
	 * Onbeforedeactivate  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_deactivate(){
		if (ComChkObjValid(window.event.srcElement)) {
			var srcName = window.event.srcElement.getAttribute("name");


			
			return true;
		} else {
			return false;
		}
	}
	 
	/**
	 * note의 내용에 변경이 생기면  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 송민석
	 * @version 2010.06.18
	 */
	function ta_note_ctnt_OnChange(){
		 var strNote = document.form.ta_note_ctnt.value;
		 if(strNote.trim() == ""){
			 if( strNote.length >= 0 ){
				 document.form.ta_note_ctnt.value = "";
			 }
			 ComShowCodeMessage("PRI00316","Commodity Note");
		 } else {
			 if(ComGetLenByByte(document.form.ta_note_ctnt) > 4000){
				 ComShowMessage("characters long");
			 } else {
				 sheetObjects[1].CellValue(sheetObjects[1].SelectRow , "note_ctnt") = document.form.ta_note_ctnt.value;
		         sheetObjects[1].CellValue(sheetObjects[1].SelectRow , "note_ctnt_tooltip") = document.form.ta_note_ctnt.value;
			 }
		 }
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
        case 1:  // Grid 1
            with (sheetObj) {
                // 높이 설정
                style.height = 102;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Commodity Group|Actual Customer|1|2|3|4";
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
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 450, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
        		InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ac_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);

                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
            }
            break;
		
		case 2: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 62;
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
				
				var HeadTitle = "|Sel.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|cmdt_note_seq|Content|Conversion|Conversion|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|prev_note_conv_mapg_id";
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
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_note_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 470, daLeft, false, "note_ctnt", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "note_conv_mapg_id", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCheckBox, 75, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false, -1, false, true, "", false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prev_note_conv_mapg_id", false, "", dfNone, 0, false, false);
	
                ShowButtonImage = 2;
                CountPosition = 0;
                AutoRowHeight = false;
                ColHidden("chk") = true;

			}
			break;
			
        case 3:      //t1sheet1 init
     		with (sheetObj) {
                // 높이 설정
                style.height = 170; 
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle = "|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
                     	"|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type" +
                		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 6, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
                InitDataProperty(0, cnt++ , dtDummyCheck,     	40,   daCenter,  true,	"chk");
                InitDataProperty(0, cnt++ , dtComboEdit,	   	50,   daCenter,  true,	"chg_rule_def_cd",			true,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtPopupEditFormat,	85,   daCenter,  true,	"eff_dt",  					true,	"",	dfDateYmd,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtPopupEditFormat,	85,   daCenter,  true,	"exp_dt",     				true,	"",	dfDateYmd, 		 	0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,    		75,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,  	    	40,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,        	35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,         	75,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		2,     true,       true,	9);
                InitDataProperty(0, cnt++ , dtCombo,      		75,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtCombo,   			35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,  			35,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
                InitDataProperty(0, cnt++ , dtPopupEdit,  		50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
                InitDataProperty(0, cnt++ , dtPopupEdit,		60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtPopupEdit,		85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
                InitDataProperty(0, cnt++ , dtCombo,			35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
                InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
                
                InitDataProperty(0, cnt++ , dtPopupEdit,    	65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                InitDataProperty(0, cnt++ , dtCombo,			150,  daCenter,  true,	"bkg_esvc_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtPopupEdit,    	80,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     true,       true,	7);
                InitDataProperty(0, cnt++ , dtPopupEdit,    	70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
                InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
                InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
                InitDataProperty(0, cnt++ , dtCombo,			45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCombo,   	 		55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"svc_scp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"prop_no");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");    
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_cmdt_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_tp_cd");
                
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_vsl_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_voy_no");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_dir_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");

                /////////////////////////////////////////////////////////////////////////////////////////
                //STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_cnt_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_cnt_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_cnt_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_cnt_cd");
                  
                
                InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");										
                InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
                InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);            
                InitDataCombo(0, "bkg_prc_cgo_tp_cd", bkgPrcCgoTpCdComboText, bkgPrcCgoTpCdComboValue);
                InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
                InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
                InitDataCombo(0, "bkg_hngr_bar_tp_cd", bkgHngrBarTpCdComboText, bkgHngrBarTpCdComboValue);            
                InitDataCombo(0, "bkg_rat_ut_cd", bkgRatUtCdComboText, bkgRatUtCdComboValue);
                InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);            
                InitDataCombo(0, "chg_rule_def_cd", chargeRuleCdComboText,chargeRuleCdComboValue);
                InitDataCombo(0, "bkg_esvc_tp_cd", bkgEsvcTpCdComboText, bkgEsvcTpCdComboValue);    
                
                sChgCdVisiable = chargeRuleCdComboText;	//초기로딩값 세팅
                
                InitDataValid(0, "chg_rule_def_cd", 		vtEngUpOnly);
                InitDataValid(0, "bkg_imdg_clss_cd", 		vtNumericOther, "."); 
				InitDataValid(0, "bkg_cmdt_def_cd", 		vtEngUpOther, "1234567890");
				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
				InitDataValid(0, "bkg_por_def_cd", 			vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_pol_def_cd", 			vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_pod_def_cd", 			vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_del_def_cd", 			vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_ts_port_def_cd", 		vtEngUpOther, "1234567890");
				
				InitDataValid(0, "bkg_slan_cd", 			vtEngUpOnly);
				InitDataValid(0, "bkg_vvd_cd", 				vtEngUpOther, "1234567890");
				InitDataValid(0, "bkg_yd_cd", 				vtEngUpOther, "1234567890"); // 영문대문자와 숫자만 입력

				 
		 		ShowButtonImage = 2;	// Edit 가능할때 팝업 이미지 표시
		 		CountPosition = 0;		// Total 숨김
		 		ImageList(0) = "img/btns_calendar.gif";
		 		PopupButtonImage(0, "eff_dt") = 0;
		 		PopupButtonImage(0, "exp_dt") = 0;
    		}
         	break;

	
		}
	}
	
	var isRowBack = false;
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
		var formObj = document.form;
		
		if (OldRow != NewRow) {
			if (isRowBack) {
				isRowBack = false;
				return;
			}
			
            if (!validateForm(sheetObjects[1], document.form, IBSAVE)) {
            	isRowBack = true;
            	sheetObj.SelectCell(OldRow, OldCol, false);
                return false;
            }
			
			var cmdtHdrSeq = sheetObj.CellValue(NewRow, "cmdt_hdr_seq");
			formObj.cmdt_hdr_seq.value = cmdtHdrSeq;
			
			ComPriSheetFilter(sheetObjects[1], "cmdt_hdr_seq", cmdtHdrSeq, true);
			sheet2_OnSelectCell(sheetObjects[1], -1, -1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol);
		}
		
		sheetObjects[1].Redraw = true;
		sheetObjects[2].Redraw = true;
		
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
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;
		
		if (OldRow != NewRow) {
			var noteCtnt = sheetObj.SelectRow <= 0 || sheetObj.RowStatus(sheetObj.SelectRow) == "D" || sheetObj.RowHidden(sheetObj.SelectRow) ? "" : sheetObj.CellValue(NewRow, "note_ctnt");
			var noteConvMapgId = sheetObj.SelectRow <= 0 || sheetObj.RowStatus(sheetObj.SelectRow) == "D" || sheetObj.RowHidden(sheetObj.SelectRow) ? "XXX" : sheetObj.CellValue(NewRow, "note_conv_mapg_id");
			
			ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", noteConvMapgId);
			
			formObj.ta_note_ctnt.value = noteCtnt;
			if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I"
				&& sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") == formObj.amdt_seq.value
				&& sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
				&& sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") != "AD"
				&& sheetObj.RowHidden(sheetObj.SelectRow) != true) {
				document.form.ta_note_ctnt.readOnly = false;
				sheetObjects[2].Editable = true;
				for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {	
					if(sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") == "AM") {
		 				sheetObjects[2].CellEditable(i, "chg_rule_def_cd") = false;
		 			} else {
		 				sheetObjects[2].CellEditable(i, "chg_rule_def_cd") = true;
		 			}
					
		 			disableColumnValidation(sheetObjects[2], i, 2, sheetObjects[2].CellValue(i,"chg_rule_def_cd"));

	      			// State 색 구분
	      			setStateColor(sheetObjects[2], i);
	      			// Rule & Charge Code 색 구분
	      			//setChargeRuleColor(sheetObjects[2], i);
		 		}
				
			} else {
				document.form.ta_note_ctnt.readOnly = true;
				sheetObjects[2].Editable = false;
			}
			
			buttonControlConv();
		}
		
		changeSelectBackColor4Rate(sheetObj);
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
	        	
	        	var idx = dialogArguments.doRowAmend(sheetObj, "AM");
	        	
	        	sheetObj.CellValue2(idx - 1, "note_conv_mapg_id") = sheetObj.CellValue(idx - 1, "prev_note_conv_mapg_id");
	        	sheetObj.RowStatus(idx - 1) = "R";
	        	
	        	for (var i = sheetObjects[2].LastRow; sheetObjects[2].RowCount > 0 && i >= sheetObjects[2].HeaderRows; i--) {
	        		if (sheetObjects[2].RowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].CellValue(i, "note_conv_rule_cd") == "APP") {
	        			continue;
	        		}
	        		
	        		if (sheetObjects[2].CellValue(i, "note_conv_mapg_id") == sheetObj.CellValue(idx, "note_conv_mapg_id")) {
	        			if (sheetObjects[2].CellValue(i, "exp_dt") < formObj.eff_dt.value) {
	        				sheetObjects[2].RowHidden(i) = true;
	        				sheetObjects[2].RowStatus(i) = "D";
	        			}
	        			
	        			if (sheetObjects[2].CellValue(i, "eff_dt") > formObj.exp_dt.value) {
	        				sheetObjects[2].RowHidden(i) = true;
	        				sheetObjects[2].RowStatus(i) = "D";
	        			}
	        		}
	        	}
	        
	        	for (var i = sheetObjects[2].LastRow; sheetObjects[2].RowCount > 0 && i >= sheetObjects[2].HeaderRows; i--) {
	        		if (sheetObjects[2].RowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].CellValue(i, "note_conv_mapg_id") == sheetObj.CellValue(idx, "note_conv_mapg_id")) {
	        			if (sheetObjects[2].CellValue(i, "eff_dt") < formObj.eff_dt.value) {
	        				sheetObjects[2].CellValue2(i, "eff_dt") = formObj.eff_dt.value;
	        			}
	        			
	        			if (sheetObjects[2].CellValue(i, "exp_dt") > formObj.exp_dt.value) {
	        				sheetObjects[2].CellValue2(i, "exp_dt") = formObj.exp_dt.value;
	        			}
	        		}
	        	}
	        	        	
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	        	
	        	sheet2_OnSelectCell(sheetObj, idx - 1, sheetObj.SelectCol, idx, sheetObj.SelectCol);
	
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
	        	
	        	var newNoteConvMapgId = sheetObj.CellValue(sheetObj.SelectRow, "note_conv_mapg_id");
	        	var prevNoteConvMapgId = sheetObj.CellValue(sheetObj.SelectRow - 1, "note_conv_mapg_id");
	        	
	        	var idx = dialogArguments.doRowAmendCancel(sheetObj);
	        	
	        	sheetObj.CellValue2(idx, "note_conv_mapg_id") = newNoteConvMapgId;
	        	for (var i = sheetObjects[2].LastRow; sheetObjects[2].RowCount > 0 && i >= sheetObjects[2].HeaderRows; i--) {
	        		if (sheetObjects[2].RowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].CellValue(i, "note_conv_mapg_id") == newNoteConvMapgId) {
	    				sheetObjects[2].RowHidden(i) = true;
	    				sheetObjects[2].RowStatus(i) = "D";
	        		}
	        	}
	        	for (var i = sheetObjects[2].LastRow; sheetObjects[2].RowCount > 0 && i >= sheetObjects[2].HeaderRows; i--) {
	        		if (sheetObjects[2].RowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].CellValue(i, "note_conv_mapg_id") == prevNoteConvMapgId) {
	        			sheetObjects[2].SelectCell(i, 0);
	        			var copiedIdx = sheetObjects[2].DataCopy();
	        			
	        			sheetObjects[2].CellValue2(copiedIdx, "note_conv_mapg_id") = newNoteConvMapgId;
	        			sheetObjects[2].CellValue2(copiedIdx, "amdt_seq") = formObj.amdt_seq.value; 
	        		
	        			// 2009-12-02
	        			// 2010-08-04
	        			//NOTE에 이전SEQ의 MAIN-DURATION 정보를 가지고 있어야 한다.
	        			if (sheetObjects[2].CellValue(copiedIdx, "exp_dt") == formObj.before_exp_dt.value) {
	        				sheetObjects[2].CellValue2(copiedIdx, "exp_dt") = formObj.exp_dt.value;
	        			}
	        		}
	        	}
	        	
	        	setSheetStyle(sheetObj, idx);
	        	sheetObj.SelectRow = idx;
	        	
	        	sheet2_OnSelectCell(sheetObj, idx - 1, sheetObj.SelectCol, idx, sheetObj.SelectCol);
	
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
	            sParam += "&" + sSheetParam;
	    
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2022GS.do", sParam);
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
	            sParam += "&" + sSheetParam;
	    
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2022GS.do", sParam);
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
	            
	            /* Start - Conversion Validation - validateForm()에서 이동한 이유: 저장시에만 체크하도록 수정 */
		     	var amdtSeq	= formObj.amdt_seq.value;
				if (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") == amdtSeq) {
					if (!checkDuration(sheetObjects[2])) {
		   				return false;
		   			}
				}
			
	   			//FOCUS가 ROW이동될때마다 체크하는 방식을 SAVE할때 체크하는걸로 수정 - 잘못된 데이터가 이행될 경우가 존재하기 때문임.
	   			for(var i = sheetObjects[2].HeaderRows; getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow; i++) {
	   				if(!sheetObjects[2].RowHidden(i)) {
		   				if(!checkMandatoryValidation(sheetObjects[2], i)) {
		 					return false;
		 				}
	   				}
	   			}
	   			/* End  - Conversion Validation - validateForm()에서 이동한 이유: 저장시에만 체크하도록 수정 */
	   			
	        	sheetObj.ColumnSort("cmdt_hdr_seq|cmdt_note_seq|amdt_seq", "ASC", "ASC|ASC|ASC", true);
	        	
	        	var sXml = "";
	        	
				sXml = ComPriSheet2Xml(sheetObjects[1]);
				dialogArguments.setSheetXml(sXml, 5);
				
				sXml = ComPriSheet2Xml(sheetObjects[2]);
				dialogArguments.setSheetXml(sXml, 14);
							
	            window.returnValue = "O";
	            window.close();
	            
				if (exTransaction) {
					dialogArguments.restylingPagePostTr();
				}
	            
	            break; 
	             
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            var sXml = "";
	            
	            sheetObjects[2].Redraw = false;
	            // NOTE CONVERSION RULE
				var sCd = sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Code");
				var sNm = sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Text");
				
				sXml = dialogArguments.getSheetXml(14);
				var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");			
				if (arrData != null && arrData.length > 0) {
					for(var i=0; i<arrData.length; i++){						
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}					
					sheetObjects[2].InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
				}			
				sheetObjects[2].LoadSearchXml(sXml);
				
				
				for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
			    	if (sheetObjects[2].RowStatus(i) == "D") {
			    		sheetObjects[2].RowHidden(i) = true;
			    	}
				}
		        
		     	// S/I 컬럼은 Scope을 TPW, ACW로 제한
		     	if(document.form.svc_scp_cd.value == 'TPW' || document.form.svc_scp_cd.value == 'ACW'){
		     		sheetObjects[2].ColHidden("bkg_esvc_tp_cd") = false;
		     	}else{
		     		sheetObjects[2].ColHidden("bkg_esvc_tp_cd") = true;
		     	}
				            
				sheetObjects[1].Redraw = false;
				sXml = dialogArguments.getSheetXml(5);
				sheetObjects[1].LoadSearchXml(sXml);
				sheetObjects[1].ColumnSort("cmdt_hdr_seq|cmdt_note_seq|amdt_seq", "ASC", "ASC|ASC|ASC", true);
				setSheetStyle(sheetObjects[1], -1);
													
				
				sXml = dialogArguments.getSheetXml(0);
				sheetObjects[0].LoadSearchXml(sXml);
				setHdrLineStyle(sheetObjects[0]);
				
				sheetObjects[0].SelectRow = formObj.select_row.value;
				sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol);
				
	         	break; 	
		
			case IBINSERT: // 입력
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
			
	            formObj.f_cmd.value = COMMAND38;
	            var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid = ComGetEtcData(sXml, "SYS_GUID");
	            if (sysGuid == null || sysGuid.length < 16) {
	            	return false;
	            }
	            
		        var idx = sheetObj.DataInsert();
	 			
	            sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
	            sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
	            sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	            sheetObj.CellValue(idx, "cmdt_hdr_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");
	            sheetObj.CellValue(idx, "cmdt_note_seq") = parseInt(ComPriGetMax(sheetObj, "cmdt_note_seq"))+ 1;
	            
	            sheetObj.CellValue(idx, "note_conv_mapg_id") = sysGuid;
	            
	            sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
	            sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
	            sheetObj.CellValue(idx, "src_info_cd") = "NW";
	            sheetObj.CellValue(idx, "src_info_nm") = "New";
	            sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
	            sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
	            sheetObj.CellValue(idx, "exp_dt") = formObj.exp_dt.value;
	            
	            setSheetStyle(sheetObj, idx);
	            
	            sheet2_OnSelectCell(sheetObj, idx - 1, sheetObj.SelectCol, idx, sheetObj.SelectCol);
	            
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
	            	for (var j = sheetObjects[2].LastRow; sheetObjects[2].RowCount > 0 && j >= sheetObjects[2].HeaderRows; j--) {
	            		if (sheetObjects[2].RowStatus(j) == "D") {
	            			continue;
	            		}
	            		if (sheetObjects[2].CellValue(j, "note_conv_mapg_id") == sheetObj.CellValue(arrCheckedRows[i], "note_conv_mapg_id")) {
	        				sheetObjects[2].RowHidden(j) = true;
	        				sheetObjects[2].RowStatus(j) = "D";
	            		}
	            	}
	            	
	            	if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SelectRow = arrCheckedRows[i];
	               		sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";
	                	
	               		var idx = dialogArguments.doRowAmend(sheetObj, "AD");
	               		
	                	sheetObj.CellValue2(idx - 1, "note_conv_mapg_id") = sheetObj.CellValue(idx, "prev_note_conv_mapg_id");
	                	sheetObj.RowStatus(idx - 1) = "R";
	                	
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	            	} else {
	            		sheetObj.RowHidden(arrCheckedRows[i]) = true;
	            		sheetObj.RowStatus(arrCheckedRows[i]) = "D";
	            	}
	        	}
	        	
	        	sheet2_OnSelectCell(sheetObj, -1, sheetObj.SelectCol, idx, sheetObj.SelectCol);
				
				break;
			
				
			case COMMAND10: //insert
				var idx = sheetObj.DataInsert();	 			
				sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;						
				sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
				sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
				sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue2(idx, "note_conv_mapg_id") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
				sheetObj.CellValue2(idx, "note_conv_tp_cd") = "C";
				sheetObj.CellValue2(idx, "note_conv_seq") = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;					
				sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
				
				sheetObj.Editable = true;
				//Code 에 Default 값이 존재할경우 적용
				defaultColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
				//Editable를 세팅한다.
				disableColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
				updateNoteConvChecked();
				
				
				break;
				
			
			case COMMAND11: //COPY
				var iCheckRow = sheetObj.FindCheckedRow("chk");			
				//HIDDEN 처리된 데이터는 삭제에서 제외시킨다.
				var arrRow = iCheckRow.split("|");			
				for (var idx=0; idx<arrRow.length-1; idx++){ 
					if(sheetObj.RowHidden(arrRow[idx])) {
						var rowStatus = sheetObj.RowStatus(arrRow[idx]);
						sheetObj.CellValue2(arrRow[idx], "chk") = "0";
						sheetObj.RowStatus(arrRow[idx]) = rowStatus;
					}
				}
			
				//카피하시겠습니까?
				if((ComShowCodeConfirm("PRI00012")) ) {
					if(iCheckRow != "") {
						comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
					}
					
					formObj.f_cmd.value = MULTI12;
					sheetObj.DoSave("ESM_PRI_2022GS.do", FormQueryString(formObj), -1, false);	
					//sheetObj.CheckAll2("chk") = "0";
				}			
				break;
			
			case COMMAND12: //PASTE			
				//붙여넣기 하시겠습니까?
				if((ComShowCodeConfirm("PRI00016")) ) {
					// NOTE CONVERSION RULE
					var sCd = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			//////////////////////////////////////////////////////////////					
					formObj.f_cmd.value = SEARCH14;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_2022GS.do", FormQueryString(formObj));				
					var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd"); 
			      	
			      	if(arrData != null && arrData.length > 0) {
			      		//콤보리스트에 추가후 InitDataCombo 호출
			      		for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.InitDataCombo(0,2, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
						//////////////////////////////////////						
			      		sheetObj.LoadSearchXml(sXml, true);
			      				    
			      		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
			      		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
			      		var arrRow = ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
			      		
			      		if(arrRow != null && arrRow.length > 0) {  
			      			
			      			for(var i=0; i<arrRow.length; i++) {
				      			sheetObj.RowStatus(arrRow[i])                       = "I";
				      			sheetObj.CellValue2(arrRow[i], "note_conv_seq") 	= maxSeq + i;
				      			sheetObj.CellValue2(arrRow[i], "note_conv_mapg_id") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
				      			sheetObj.CellValue2(arrRow[i], "svc_scp_cd") 		= formObj.svc_scp_cd.value;
				      			sheetObj.CellValue2(arrRow[i], "prop_no") 			= formObj.prop_no.value;
								sheetObj.CellValue2(arrRow[i], "amdt_seq") 			= formObj.amdt_seq.value;
								
				      			sheetObj.CellValue2(arrRow[i], "note_conv_tp_cd") 	= "C";
				      			//sheetObj.CellValue2(arrRow[i], "exp_dt") 			= formObj.exp_dt.value;						
								//sheetObj.CellValue2(arrRow[i], "eff_dt") 			= formObj.eff_dt.value;								
			      			}
			      		}
			      		  		
			      	} else {
			      		ComShowCodeMessage("PRI00328");
			      	}
				}
				
				updateNoteConvChecked();
		      	
				break;
		
			case IBCOPYROW:
				copySheetData(sheetObj);
				
				updateNoteConvChecked();
				break;
			
			case COMMAND13: // Delete		
				var iCheckRow = sheetObj.FindCheckedRow("chk");
				if(iCheckRow == ""){
					sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
				}
				iCheckRow = sheetObj.FindCheckedRow("chk");	
				
				//HIDDEN 처리된 데이터는 삭제에서 제외시킨다.
				var arrRow = iCheckRow.split("|");			
				for (var idx=0; idx<arrRow.length-1; idx++){ 
					if(sheetObj.RowHidden(arrRow[idx])) {
						var rowStatus = sheetObj.RowStatus(arrRow[idx]);
						sheetObj.CellValue2(arrRow[idx], "chk") = "0";
						sheetObj.RowStatus(arrRow[idx]) = rowStatus;
					}
				}
				
				if(iCheckRow != "") {
					deleteRowCheck(sheetObj, "chk");
				}
				
				updateNoteConvChecked();
				
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
            if (sheetObj.IsDataModified && sheetObj.GetSaveString(false, false) == "") {
                return false;
            }
        
			/* CONVERSION - START */
	        if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
	            return false;
	        }	
	        
	        /* 
	     	var amdtSeq	= formObj.amdt_seq.value;
			if (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") == amdtSeq) {
				if (!checkDuration(sheetObjects[2])) {
	   				return false;
	   			}
			}
		
   			//FOCUS가 ROW이동될때마다 체크하는 방식을 SAVE할때 체크하는걸로 수정 - 잘못된 데이터가 이행될 경우가 존재하기 때문임.
   			for(var i = sheetObjects[2].HeaderRows; getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow; i++) {
   				if(!sheetObjects[2].RowHidden(i)) {
	   				if(!checkMandatoryValidation(sheetObjects[2], i)) {
	 					return false;
	 				}
   				}
   			}
   			*/
			
			if (sheetObjects[2].IsDataModified) {
				for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {	 			
		 			if(sheetObjects[2].CellValue(i, "bkg_vvd_cd") != ""  && sheetObjects[2].CellValue(i, "bkg_vvd_cd").length != 9 && sheetObjects[2].RowStatus(i) != "D") {
		 				sheetObjects[2].SelectCell(i, "bkg_vvd_cd");
		 				ComShowCodeMessage("PRI01065", "VVD", "9");
		 				return false;
		 			}
		 		}
				
				//중복체크
				if (!validateDupCheck(sheetObjects[2])) {
					 return false;
				}
			}

			/* CONVERSION - END */

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
        	
        	var cmdtHdrSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                if (sheetObj.CellValue(i, "amdt_seq") == formObj.amdt_seq.value
                		&& sheetObj.CellValue(i, "cmdt_hdr_seq") == cmdtHdrSeq
                		&& sheetObj.RowStatus(i) != "D") {
                    return false;
                }
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
    
    function updateNoteConvChecked() {
    	var noteConvMapgId = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_mapg_id");
    	var prevRowStatus = sheetObjects[1].RowStatus(sheetObjects[1].SelectRow);
    	
    	for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
    		if (sheetObjects[2].CellValue(i, "note_conv_mapg_id") == noteConvMapgId && sheetObjects[2].RowStatus(i) != "D") {
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_mapg_id_chk") = "1";
    			sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) = prevRowStatus;
    			return;
    		}
    	}
    	
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_mapg_id_chk") = "0";
		sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) = prevRowStatus;
		return;
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
    	if (sheetObj.RowCount <= 0) {
    		return;
    	}
    	
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
	        	document.form.ta_note_ctnt.readOnly = false;
		} else {
        	document.form.ta_note_ctnt.readOnly = true;
		}
    	
    	if (sheetObj.CellValue(idx, "amdt_seq") == document.form.amdt_seq.value) {
    		// true
    	} else {
    		// false
    	}
    }

    function setHdrLineStyle(sheetObj) {
		for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if (sheetObj.RowStatus(i) == "D") {
				sheetObj.RowHidden(i) = true;
			}
			
	    	if (document.form.amdt_seq.value == "0") {
	    		continue;
	    	}
			
			if (parseInt(sheetObj.CellValue(i, "nd_cnt")) == 0) {
				sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = true;
			} else {
				sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = false;
			}
			if (parseInt(sheetObj.CellValue(i, "na_cnt")) > 0) {
				sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
			} else {
				sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
			}
		}
    }
      
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
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
 	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
	
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
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
	function sheet3_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
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
	function validateFormConversion(sheetObj, formObj, sAction) {
		 
		switch (sAction) { 		
	   		case IBCOPYROW:
	   			if(!checkDuration(sheetObj)) {
	   				return false;
	   			}
	   			
	   			if(sheetObj.RowCount > 0) {
	   				//mandatory check
	 				if(!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
	 					return false;
	 				}
	   			}
	 			break;
	 			
	   		case COMMAND10:
	   			if(sheetObj.RowCount > 0) {
	   				//mandatory check
	 				if(!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
	 					return false;
	 				}
	   			}
	 			break;	  			
	 	
	 		case COMMAND11:
	 			var iCheckRow = sheetObj.FindCheckedRow("chk");
	 			
	 			if(iCheckRow == "") {
	 				ComShowCodeMessage("PRI00327");
	 				return false;
	 			}	 							
	 			break;
	 			
	 		case COMMAND12:
	 							
	 			break;
		}

		return true;
	}
	 
 	/**
 	 * SHEET ROW 중복체크를 하는 FUNCTION <br>
 	 * 모든 항목이 같고 EFF_DT와 EXP_DT가 중첩이 발생할경우에 중복체크를 한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * validateDupCheck(sheetObj)
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @return boolean
 	 * @author 최성민
 	 * @version 2009.05.20
 	 */ 
 	function validateDupCheck(sheetObj) {
 		
 		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
			 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd" +
			 		"|bkg_slan_cd|bkg_vvd_cd|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd|note_conv_mapg_id", false, true);
 		
 		if (rowM != "") {
 			// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
 			// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
 			var rowDupKeyList = rowM.split("|");
 			
 			//var rowDup = rowM.replace("|", ","); 			
 			//중복되는 모든ROW
 			//var rowArr = rowDup.split(",");
 			
 			var rowArr = rowDupKeyList[0].split(",");
 			var rowObj = rowDupKeyList[1].split(",");
 			
 			var dupValue = "";
 			var temValue = "";						
 			var firstEffDt = "";
 			var firstExpDt = "";						
 			var SecondEffDt = "";
 			var SecondExpDt = "";
			var hrows = sheetObj.HeaderRows;
 			
 			for(var i=0; i<rowArr.length; i++) {
 				if (sheetObj.RowHidden(rowArr[i])) {
 					continue;
 				}
 				dupValue  = sheetObj.CellValue(rowArr[i], "chg_rule_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_rat_ut_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_imdg_clss_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_cmdt_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pod_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_del_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_por_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pol_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_slan_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_vvd_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_soc_flg");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_dir_call_flg");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_ts_port_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_min_cgo_wgt");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_max_cgo_wgt");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_hngr_bar_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "note_conv_mapg_id");
 				
 				for(var j=0; j<rowObj.length; j++) {
 	 				if (sheetObj.RowHidden(rowObj[j])) {
 	 					continue;
 	 				}
 					temValue  = sheetObj.CellValue(rowObj[j], "chg_rule_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_rat_ut_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_prc_cgo_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_imdg_clss_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_cmdt_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pod_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_del_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_por_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pol_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_slan_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_vvd_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_soc_flg");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_dir_call_flg");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_ts_port_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_min_cgo_wgt");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_max_cgo_wgt");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_hngr_bar_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "note_conv_mapg_id");
 					
 					//if(i != j) {
	  					if(dupValue == temValue) {
	  						firstEffDt = sheetObj.CellValue(rowArr[i], "eff_dt");
	  						firstExpDt = sheetObj.CellValue(rowArr[i], "exp_dt");
	  						
	  						SecondEffDt = sheetObj.CellValue(rowObj[j], "eff_dt");
	  						SecondExpDt = sheetObj.CellValue(rowObj[j], "exp_dt");
	  						
	  						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	  							ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	  						     return false;
	  			 			}
	  			 			
	  			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	  			 				ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	  						     return false;
	  			 			}
	  						
	  					} //if
 					//} //if
 				} //for
 				
 			} //for
 			
 		} //if
 		
 		return true;
 	}
 	 
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 최성민
     * @version 2009.06.25
     */  
 	function sheet3_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
 		switch(colName)
     	{
 			case "chg_rule_def_cd":		
 				
 				if (Value != null && Value != "" && Value.length == 3) {
 					//DEFAULT 데이터처리
 					defaultColumnValidation(sheetObj, Row, Col, Value);
 					//컬럼 disable 처리
 					disableColumnValidation(sheetObj, Row, Col, Value);
 					
 					var sCode = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
 					var sText = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");

 					if (sCode.indexOf(Value) < 0) {
 						formObj.f_cmd.value = COMMAND09;
 						sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
 						
 						var arrData = ComPriXml2Array(sXml, "cd|nm");
 						if (arrData != null && arrData.length > 0) {
 							sCode += "|" + Value;
 							sText += "|" + Value;
 							sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
 							
 							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
 						} else {
 							sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
 						}
 					}
 					
 					insertChargeRuleType(sheetObj, Row);
 				} else {
 					sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
 				}

 				// Rule & Charge Code 색 구분
 				//setChargeRuleColor(sheetObj, Row);
 				break;
 				
 				
 			case "eff_dt":	
 				var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
 				var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
 				
 				if(sheetObj.CellValue(Row, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.CellValue2(Row, "eff_dt") = effDt;
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				
 				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.CellValue2(Row, "eff_dt") = effDt;
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				break;
 				
 			case "exp_dt":	
 				var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
 				var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
 				
 				if(sheetObj.CellValue(Row, "exp_dt") > expDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.CellValue2(Row, "exp_dt") = expDt;
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
 				
 				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.CellValue2(Row, "exp_dt") = expDt;
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
 				break;
 				
			case "bkg_prc_cgo_tp_cd": 	
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				
				if(chgRuleDefCd == "APP"){
					if(Value != "DG") {
						ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
						sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") = "";
					}
				}
				
				if(Value == "DG") {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = true;
				} else {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = false;
					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
				}
				break;	
				
 			case "bkg_cmdt_def_cd":	
 				
 				if (Value.length == 5) { //Group Commodity
 					var propNo = formObj.prop_no.value;
 					var amdtSeq = formObj.amdt_seq.value;
 					var svcScpCd = formObj.svc_scp_cd.value;

 					formObj.f_cmd.value = SEARCH10;
 					formObj.cd.value = Value;
 					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=rpscp");
 					var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 				
 					if(arrData[1] != ""){
 						sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") = Value;
 						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = 'G';
 					} else {
 						sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
 						sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
 						sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 					}

 				} else if (Value.length == 6) {
 	    			formObj.f_cmd.value = SEARCH08;
 	    			//COMMODITY CODE 앞에 '0'문자로 채움
 	    			formObj.cd.value = ComLpad(Value, 6, "0");
 	    			
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
  					if (arrData[1] != "") {
  						sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = Value;
  						//6자리일경우 COMMODITY CODE임
 						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "C";
  					}else{
 	  					sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = "";
 	  					sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
  					}
 				} else {
 					sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
 					sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
 					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 				}
 				
 	    		break;
 	    		
 			case "bkg_por_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_RP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_por_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_por_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_por_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_por_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_por_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_por_def_cd") ; 				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_pol_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_RP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_pol_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_pol_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_pol_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_pol_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_pol_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_pol_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_pod_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_RP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_pod_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_pod_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_pod_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_pod_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_pod_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_pod_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_del_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_RP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_del_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_del_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_del_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_del_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_del_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_del_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
 	    		break;	
 	    		
 			case "rt_appl_tp_cd":	
 				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 				var rtOpCd = 	sheetObj.CellValue(Row, "rt_op_cd");

 				if(Value == "A" || Value == "F") {
 					sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 					sheetObj.CellValue2(Row, "curr_cd") 		= "USD";
 					sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
 					sheetObj.CellEditable(Row, "rt_op_cd")		= true;
					sheetObj.CellEditable(Row, "curr_cd")		= true;
					sheetObj.CellEditable(Row, "frt_rt_amt")	= true;
 				} else {
 					sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 					sheetObj.CellValue2(Row, "curr_cd") 		= "";
 					sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 					sheetObj.CellEditable(Row, "rt_op_cd")		= false;
 					sheetObj.CellEditable(Row, "curr_cd") 		= false;
 					sheetObj.CellEditable(Row, "frt_rt_amt")	= false;
 				}
 				
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 					&& chgRuleDefCd != "RAC" ) {
 		    		 					
 					if( Value == "F") {
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellEditable(Row, "rt_op_cd") 	= false;
 					}
 					
 					if( Value == "A") {
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellEditable(Row, "curr_cd") 	= false;
 					}
 					
 	    		} else if(chgRuleDefCd == "ADD" || chgRuleDefCd == "ARB") {
 	    			if (Value == "I" || Value == "A"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 	    				sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 						
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			} else if (Value == "S" || Value == "N"){
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 					} else {
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= true;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 						sheetObj.CellValue2(Row, "curr_cd") 	= "USD";
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
 					}
 	    		} else if(chgRuleDefCd == "NOT") {
 	    			if (Value != "I" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "I";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "APP") {
 	    			if (Value != "S" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 						sheetObj.CellValue2(Row, "curr_cd") 		= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "TYP") {
 	    			
 	    			if (Value == "A"){ 	    	    				
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 						sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 	    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 	    			} else if (Value == "N"){ 	    	    				
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 	    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 	    			}
 	    		}
 				
 	    		break;
 	    		
 			case "rt_op_cd":
 				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 				var rtApplTpCd = 	sheetObj.CellValue(Row, "rt_appl_tp_cd");
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
 										
 					if( rtApplTpCd == "F") {
 			    		if(Value == ">" || Value == "<" ) {
 			    			ComShowCodeMessage("PRI00326");
 			    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 			    			sheetObj.SelectCell(Row, "rt_op_cd");
 			    		}
 		    		}
 				} else if(chgRuleDefCd == "RAR") {
 					if(Value == ">" || Value == "<" ) {
 		    			ComShowCodeMessage("PRI00326");
 		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 		    			sheetObj.SelectCell(Row, "rt_op_cd");
 		    		}
 				} else if(chgRuleDefCd == "RAP") {
 					if(Value == ">" || Value == "<" ) {
 		    			ComShowCodeMessage("PRI00326");
 		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 		    			sheetObj.SelectCell(Row, "rt_op_cd");
 		    		}
 	    		} else if(chgRuleDefCd == "DOR") {
 					if(Value == ">" || Value == "<" ) {
 		    			ComShowCodeMessage("PRI00326");
 		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 		    			sheetObj.SelectCell(Row, "rt_op_cd");
 		    		}
 	    		} else if(chgRuleDefCd == "TYP") {
 					if(Value == ">" || Value == "<" ) {
 		    			ComShowCodeMessage("PRI00326");
 		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 		    			sheetObj.SelectCell(Row, "rt_op_cd");
 		    		}
 	    		}
 	    		break;	
 	    		    		    		
 			case "bkg_ts_port_def_cd":	    		
 	    		if (Value.length == 5){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_RP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = arrData[0];
 						sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "L";
 						 						
 						//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
 						sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
 						
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_ts_port_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
 	  					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");  	
   					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
 	    		}
 	    	
 	    		sheetObj.CellBackColor(Row,"bkg_ts_port_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_dir_call_flg":
 	    		if (Value == "Y"){
 	    			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
 	    			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
 	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
 	    		} else {
 	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
 	    		}
 	    		break;	
 	    		
 			case "bkg_slan_cd":
 				if (Value.length == 3){
 	    			formObj.f_cmd.value = COMMAND26;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_slan_cd") = arrData[0];
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_slan_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_slan_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_slan_cd");  				
 	    		}
 	    		break;
 	    		
 			case "bkg_vvd_cd":
 				if (Value.length == 9){
 					
 					var vslCd 		= Value.substring(0,4);
 					var skdVoyNo 	= Value.substring(4,8);
 					var skdDirCd 	= Value.substring(8,9);
 							
 	    			var sParam = "f_cmd="+COMMAND27;
 	    			sParam += "&cd="+vslCd;
 	    			sParam += "&etc1="+skdVoyNo;
 	    			sParam += "&etc2="+skdDirCd;
 	  
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 	  					sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= arrData[0];
 						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= vslCd;
 						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= skdVoyNo;
 						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= skdDirCd;
 						
   					}else{
 						sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
 						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
 						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
 						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
   						sheetObj.SelectCell(Row, "bkg_vvd_cd");
 	  					
   					}
 	    		} else{	
 	    			sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
 					sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
 					sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
 					sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
 	    			sheetObj.SelectCell(Row, "bkg_vvd_cd");	
  						
 	    		}
 	    		break;
 	    		
 			case "bkg_imdg_clss_cd":
 				if (Value.length > 0){
 	    			formObj.f_cmd.value = COMMAND30;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = arrData[0];
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_imdg_clss_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");  				
 	    		}
 	    		break;
 	    		
 			case "curr_cd":
 				var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
 				if(chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD"){
 	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
 	 	    			
 	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
 	 					sheetObj.CellValue2(Row, "curr_cd") = "USD";
 	 					sheetObj.SelectCell(Row, "curr_cd");
 	 	    		}
 				}
 	    		break;
     	}
 		
 	}
 	
 	 /**
      * OnClick 이벤트 발생시 호출되는 function <br>
      * 달력 DIV를 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
      * @return 없음
      * @author 최성민
      * @version 2009.06.18
      */
      function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
  	    var colname = sheetObj.ColSaveName(Col);
  	    var formObj = document.form;
  	    var pinkColor = sheetObj.RgbColor(255,192,203);
  	    
       	switch(colname)
       	{
   	    	case "eff_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
   	    		break;
   	    	case "exp_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
   	    		break;
   	    		
   	    	case "bkg_cmdt_def_cd":
   	    		var sUrl = "/hanjin/ESM_PRI_4027.do?"
   	   	    		sUrl += "commodity_cmd=CG";
   	   	    		sUrl += "&grp_cd="+PRI_RP_SCP;
   	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
   	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
   	   	    	
   	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
   	  			if (rtnVal != null){
   	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;	
   	  				//6자리일경우 COMMODITY CODE임
   	  				sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = rtnVal.tp;
   	  			}
   	  			break;
   	  			
   	    	case "bkg_por_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_por_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_por_tp_cd") = rtnVal.tp;
 	  				
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_por_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_pol_def_cd":
 	  			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_pol_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_pol_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_pod_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_pod_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_pod_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_del_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_del_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_del_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_del_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				  				
   	    	case "bkg_ts_port_def_cd":	
   				var sUrl = "/hanjin/ESM_PRI_4026.do?";
   				var sParam = "&location_cmd=L";
   					
   				var rtnVal = ComPriOpenWindowCenter(sUrl+sParam, "ESM_PRI_4026", 700, 325, true);
   				if (rtnVal != null){
   					sheetObj.CellValue2(Row, Col) = rtnVal.cd;
   					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = rtnVal.tp;			
   				}
   				break;	
   				
   	    	case "bkg_slan_cd":	
   				var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);
   					
   				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
   				if (rtnVal != null){
   					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
   				}
   				break;		
   				
   	    	case "bkg_vvd_cd":	
   				var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);
   					
   				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
   				if (rtnVal != null){
   					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
   					sheetObj.SelectCell(Row, Col);
   				}
   				break;	

  	    	case "bkg_yd_cd":
  				var bkgYdCd = sheetObj.CellValue(Row, Col);
  				var display = '0,0,1,1,1,1,1,1,1,1,1,1';
  				var param = '?mode=yard&node_cd='+bkgYdCd;
  				//공통사용 팝업 호출
  				ComPriOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'callBackTerminalCode', display, true);
  				break;
       	}    	 

      } 
      
      
   	/**
   	 * Terminal Code 조회 popup 화면이 닫힐때 호출되는 function <br>
   	 * popup에서 내려받은 코드를 보여준다. <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {String} locTp 필수 location 구분코드(사용않음)
   	 * @param {array} rArray 코드값 array
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.04.23
   	 */
   	function callBackTerminalCode(rowArray){
   		 var colArray = rowArray[0];
   	     if(rowArray != null) {
   	    	 sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "bkg_yd_cd") = colArray[3];
   	     } else {
   	    	 sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "bkg_yd_cd") = "";
   	     }
   	}
   	
  	/**
       * bkg_yd_cd 의 validation check function <br>
       * <br><b>Example :</b>
       * <pre>
       *    checkTerminalCode(sheetObj, Row, Value);
       * </pre>
       * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
       * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
       * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
       * @return 없음
       * @author 최성민
       * @version 2010.04.23
       */ 
  	function checkTerminalCode(sheetObj, Row, Value) {
  		if(ComIsNull(Value)) {
  			return;
  		}
  		var formObj = document.form;
  		if (Value.length == 7) {
  			formObj.f_cmd.value = SEARCH;
  			var sXml = sheetObjects[0].GetSearchXml("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
  			var arrDesc = ComPriXml2Array(sXml, "yd_cd");
  			
  			if(arrDesc == null || arrDesc.length < 1) {
  				sheetObj.CellValue2(Row, "bkg_yd_cd") = "";
  			}
  		} else {
  			sheetObj.CellValue2(Row, "bkg_yd_cd") = "";
  		}
  	}

 
 	/**
 	 * ROUTE의 항목에 데이터 입력시 해당하는 ROUTE의 TYPE CODE를 세팅하는 FUNCTION <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} Len 필수 이벤트가 발생한 해당 셀의 Value Length
 	 * @return 없음
 	 * @author 최성민
 	 * @version 2009.07.15
 	 */ 
    function getLocationTypeCode(sheetObj, Row, Col, Len) {
    	var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		switch(colName)
    	{
			case "bkg_por_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "G";
		    	}
		    	break;
		    	
			case "bkg_pol_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "G";
		    	} 
		    	break;

			case "bkg_pod_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "G";
		    	} 
		    	break;
		    	
			case "bkg_del_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "L";
		    	} else if(Len == 2) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "C";
		    	} else if(Len == 3) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "R";
		    	} else if(Len == 4) {
		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "G";
		    	} 
		    	break;		    
    	}
    	
    }

	/**
	 * Duration 의 Validation function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 최성민
	 * @version 2009.07.15
	 */ 
    function checkDuration(sheetObj) {
		var formObj = document.form;
		
		for (var a = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && a <= sheetObjects[1].LastRow; a++) {
			if (sheetObjects[1].RowHidden(a) == true) {
				continue;
			}
			if (sheetObjects[1].CellValue(a, "amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			if (sheetObjects[1].CellValue(a, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			
			var noteConvMapgId = sheetObjects[1].CellValue(a, "note_conv_mapg_id");
			
			for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "note_conv_mapg_id") == noteConvMapgId) {
					if (sheetObj.RowStatus(i) == "D") {
						continue;
					}
					
					if (sheetObj.CellValue(i, "eff_dt") < formObj.eff_dt.value) {
						ComShowCodeMessage("PRI08016");
						sheetObj.SelectCell(i, "eff_dt", false);
						return false;
					}
					
					if (sheetObj.CellValue(i, "eff_dt") > sheetObj.CellValue(i, "exp_dt")) {
						ComShowCodeMessage("PRI00306");
						sheetObj.SelectCell(i, "eff_dt", false);
						return false;
					}
					
					if (sheetObj.CellValue(i, "exp_dt") > formObj.exp_dt.value) {
						ComShowCodeMessage("PRI08016");
						sheetObj.SelectCell(i, "exp_dt", false);
						return false;
					}
				}
			}
		}
		
		return true;
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
 		var pinkColor = sheetObj.RgbColor(255,192,203);
 		
		if(sheetObj.CellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
 		}
		
		if(sheetObj.CellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
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
 		var sCodeColor = sheetObj.RgbColor(255,200,200);
 		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
	 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
 		} else {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
 		} 
 	}
	      
      /**
       * CODE항목 선택시 CODE값에 따라 수정가능한 항목을 체크하는 function <br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
       * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
       * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */           
      function disableColumnValidation(sheetObj, Row, Col, Value) {
    	
    	initColumnEditable(sheetObj, Row, Col, Value);
    	
 		switch(Value)
     	{
     		case "APP":	
     			sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= false;
     			//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= false;
     			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
     			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= false;
     			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= false;
				break;
				
     		case "NOT":	
     			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
				break;
					
     		case "RAS":	
     			
     			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
				break;
					
 			case "ARB":	
 				//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;

				if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				}
 				break;
 				
 			case "ADD":
 				//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;

				if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				}
 				break;
 				
 			case "TYP":
 				//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;				
 				break;
 				
 			case "RAR":
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				break;
 				
 			case "RAP":
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				break;
 				
 			case "DOR":
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;				
 				break;
 				
 			default:  //SURCHARGE 												
		    	if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
				}
 				break;
     	}
  	}
       
       /**
        * SHEET에 보이는 항목들을 EDITABLE 초기화하는 function <br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditable(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
        * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
        * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
        * @return 없음
        * @author 최성민
        * @version 2009.07.02
        */           
       function initColumnEditable(sheetObj, Row, Col, Value) { 
        	
    	   	sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= true;
	   	   	sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= true;
	   	   	sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= true;
				
	   	   	if(sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
	   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd")		= true;
	   	   	} else {
	   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") 		= false;
	   	   	}
			sheetObj.CellEditable(Row, "rt_op_cd") 					= true;
			sheetObj.CellEditable(Row, "curr_cd") 					= true;
			sheetObj.CellEditable(Row, "frt_rt_amt") 				= true;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= true;
			
			sheetObj.CellEditable(Row, "bkg_slan_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_vvd_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_soc_flg") 				= true;
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 		= true;
			
			if(sheetObj.CellValue(Row, "bkg_ts_port_def_cd") != "") {
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= false;
			} else {
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= true;
			}
			
			if(sheetObj.CellValue(Row, "bkg_dir_call_flg") == "Y") {
				sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= false;
			} else {
				sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= true;
			}	

			sheetObj.CellEditable(Row, "bkg_yd_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_esvc_tp_cd") 			= true;
        }
        
        /**
         * CODE항목 선택시 CODE TYPE에 따라 필수 컬럼을 체크하는 function <br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *	checkMandatoryValidation(sheetObj, Row);
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
         * @return 없음
         * @author 최성민
         * @version 2009.07.02
         */ 	
      	function checkMandatoryValidation(sheetObj, Row) {
        	if (!eventToken) {
        		return true;
        	}
        	 
      		var rowCount = sheetObj.RowCount; 		
      		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
      		
     		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
     			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
     			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
     			
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
     				ComShowCodeMessage("PRI00316","Application");
     				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
     				return false;
     			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
     			//} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
         				//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 필수입력항목 지정.(7/21)
     	 			ComShowCodeMessage("PRI00316","Amount");
     				sheetObj.SelectCell(Row, "frt_rt_amt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") { 			
    	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
    	 			// BKG SOURCE부분의 PER를 필수 입력 항목 변경 요청 - 2009.11.09
    				if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A"){
    					ComShowCodeMessage("PRI00316","Per");
    	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
    	 				return false;
    				}
     			}
     		} else if (chgRuleDefCd == "APP") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
     				ComShowCodeMessage("PRI00316","Application");
     				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
     				return false;
     			} 
     		} else if (chgRuleDefCd == "NOT") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
     				ComShowCodeMessage("PRI00316","Application");
     				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
     				return false;
     			}  			
     		} else if (chgRuleDefCd == "RAS") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
     				ComShowCodeMessage("PRI00316","Cal.");
     				sheetObj.SelectCell(Row, "rt_op_cd");
     				return false;
     			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001) {
     				ComShowCodeMessage("PRI00316","Amount");
     				sheetObj.SelectCell(Row, "frt_rt_amt");
     				return false;
     			} 
     		} else if (chgRuleDefCd == "ARB") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
     				ComShowCodeMessage("PRI00316","Application");
     				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
     				return false;
     			}
     		} else if (chgRuleDefCd == "ADD") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
     				ComShowCodeMessage("PRI00316","Application");
     				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
     				return false;
     			}
     		} else if (chgRuleDefCd == "TYP") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
	 				ComShowCodeMessage("PRI00316","Application");
	 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
	 				return false;
	 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
     				ComShowCodeMessage("PRI00316","Cal.");
     				sheetObj.SelectCell(Row, "rt_op_cd");
     				return false;
     			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
     				ComShowCodeMessage("PRI00316","Amount");
     				sheetObj.SelectCell(Row, "frt_rt_amt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "" && sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
     				ComShowCodeMessage("PRI00325","Per","Cargo Type");
     				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
     				return false;
     			}
     		} else if (chgRuleDefCd == "RAR") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
     				ComShowCodeMessage("PRI00316","Cal.");
     				sheetObj.SelectCell(Row, "rt_op_cd");
     				return false;
     			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
     				ComShowCodeMessage("PRI00316","Amount");
     				sheetObj.SelectCell(Row, "frt_rt_amt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "bkg_por_def_cd") == "" && sheetObj.CellValue(Row, "bkg_pol_def_cd") == "" 
     				 && sheetObj.CellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.CellValue(Row, "bkg_del_def_cd") == "") {
     				//POR, POL,POD,DEL중 1개이상 입력 				 				
     				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
     				sheetObj.SelectCell(Row, "bkg_por_def_cd");
     				return false;
     			}
     		} else if (chgRuleDefCd == "RAP") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
     				ComShowCodeMessage("PRI00316","Cal.");
     				sheetObj.SelectCell(Row, "rt_op_cd");
     				return false;
     			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
     				ComShowCodeMessage("PRI00316","Amount");
     				sheetObj.SelectCell(Row, "frt_rt_amt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "bkg_cmdt_def_cd") == "") {
     				ComShowCodeMessage("PRI00316","Commodity");
     				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
     				return false;
     			}
     		} else if (chgRuleDefCd == "DOR") {
     			if(sheetObj.CellValue(Row, "eff_dt") == "") {
     				ComShowCodeMessage("PRI00316","Effective Date");
     				sheetObj.SelectCell(Row, "eff_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
     				ComShowCodeMessage("PRI00316","Expiration Date");
     				sheetObj.SelectCell(Row, "exp_dt");
     				return false;
     			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
     				ComShowCodeMessage("PRI00316","Cal.");
     				sheetObj.SelectCell(Row, "rt_op_cd");
     				return false;
     			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
     				ComShowCodeMessage("PRI00316","Amount");
     				sheetObj.SelectCell(Row, "frt_rt_amt");
     				return false;
     			}
     		} 

     		return true;
      	}
      	
         /**
          * CODE항목 선택시 CODE TYPE에 따라 컬럼항목 DEFAULT 처리하는 function <br>
          * 
          * <br><b>Example :</b>
          * <pre>
          *	defaultColumnValidation(sheetObj, Row, Col, Value);
          * </pre>
          * @param {ibsheet} sheetObj 필수 IBSheet Object
          * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
          * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
          * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
          * @return 없음
          * @author 최성민
          * @version 2009.07.02
          */ 	
      	function defaultColumnValidation(sheetObj, Row, Col, Value) {
     	 	
        	initColumnValue(sheetObj, Row);
        	  
     		switch(Value)
         	{	
     			case "TYP":
     				sheetObj.CellValue2(Row, "curr_cd") 			= "";
     				sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 		= "D4";
     				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "A";	
     				break;
     				
     			case "NOT":
     				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "I";			
     				break;
     			
     			case "RAS":
     				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				break;
     				
     			case "RAR":
     				sheetObj.CellValue2(Row, "curr_cd") 			= "";
     				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				break;
     				
     			case "RAP":
     				sheetObj.CellValue2(Row, "curr_cd") 			= "";
     				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				break;
     				
     			case "DOR":
     				sheetObj.CellValue2(Row, "curr_cd") 			= "";
     				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				break;
     				
     			case "ARB":
     				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
     				//sheetObj.CellValue2(Row, "curr_cd") 			= "USD";
     				//sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				//sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				break;
     				
     			case "ADD":
     				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
     				//sheetObj.CellValue2(Row, "curr_cd") 			= "USD";
     				//sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
     				//sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
     				break;
     				
     			default:
     				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
     				break;
     				
         	}
      	}
          
      /**
       * 데이터를 초기화하는 function <br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	initColumnValue(sheetObj, Row);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */ 	
       	function initColumnValue(sheetObj, Row) {
      	 		
         	  sheetObj.CellValue2(Row, "rt_appl_tp_cd") 				= "";
         	  sheetObj.CellValue2(Row, "rt_op_cd") 						= "";
         	  sheetObj.CellValue2(Row, "curr_cd") 						= "";
         	  sheetObj.CellValue2(Row, "frt_rt_amt") 					= "";
         	  sheetObj.CellValue2(Row, "pay_term_cd") 					= "";
         	  sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") 			= "";
         	  sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_por_tp_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_por_def_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_pol_tp_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_pol_def_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_pod_tp_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_pod_def_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_del_tp_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_del_def_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_slan_cd") 					= "";
         	  sheetObj.CellValue2(Row, "bkg_vsl_cd") 					= "";
         	  sheetObj.CellValue2(Row, "bkg_skd_voy_no") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_skd_dir_cd") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_soc_flg") 					= "";
         	  sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") 			= "";
         	  sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") 			= "";
         	  sheetObj.CellValue2(Row, "bkg_dir_call_flg") 				= "";
         	 
         	  sheetObj.CellValue2(Row, "bkg_vvd_cd") 					= "";

          	  sheetObj.CellValue2(Row, "bkg_hngr_bar_tp_cd") 			= "";
          	  sheetObj.CellValue2(Row, "bkg_min_cgo_wgt") 				= "";
          	  sheetObj.CellValue2(Row, "bkg_max_cgo_wgt") 				= "";
         	  sheetObj.CellValue2(Row, "bkg_yd_cd") 					= "";
         	  sheetObj.CellValue2(Row, "bkg_esvc_tp_cd") 				= "";
       	}
      	
    	
        /**
         * SHEET ROW를 멀티 복사하는 function <br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *	copySheetData(sheetObj);
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @return 없음
         * @author 최성민
         * @version 2010.03.23
         */	
     	function copySheetData(sheetObj) {
    	    
      		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
      		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
      		var sCheckRow = sheetObj.FindCheckedRow("chk");
    		if(sCheckRow == ""){
    			sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
    		}
    		sCheckRow = sheetObj.FindCheckedRow("chk");	
    		
     		var aCheckArr = ComRtrim(sCheckRow, '|').split("|");
     		
     		if(aCheckArr != null && aCheckArr.length > 0) {
     			for(var i=aCheckArr.length-1; i>=0; i--) {
     				sheetObj.SelectRow = aCheckArr[i];
     				var idx = sheetObj.DataCopy();
          			sheetObj.CellValue2(idx, "note_conv_seq") 	= maxSeq;      	
          			sheetObj.CellValue2(idx, "chk") = 0;

          			// State 색 구분
          			setStateColor(sheetObj, idx);
          			// Rule & Charge Code 색 구분
          			//setChargeRuleColor(sheetObj, idx);
          			    
          			maxSeq++;
     			}
     		}
     	}
     	
     	/**
          * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
          * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
          * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
          * <br><b>Example :</b>
          * <pre>
          *	insertChargeRuleType(sheetObj);
          * </pre>
          * @param {ibsheet} sheetObj 필수 IBSheet Object
          * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
          * @return 없음
          * @author 최성민
          * @version 2009.07.02
          */	
     	function insertChargeRuleType(sheetObj, Row) {
     		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
     		
     		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
     			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
     			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
     			
     			//CHARGE
     			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
     			sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
     			sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
     		} else {
     			//RULE
     			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
     			sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
     			sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
     		}
     	}

      /**
        * SYS_GUID()값을 리턴하는 function <br>
        * <br><b>Example :</b>
        * <pre>
        * 
        * </pre>
        * @param 없음
        * @return sValue EtcData
        * @author 최성민
        * @version 2009.08.13
        */       
        function getSYSGUID() {
        	var formObj = document.form;
        	formObj.f_cmd.value = COMMAND38;
    		var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
    		var sValue = ComGetEtcData(sXml,"SYS_GUID");
    		return sValue;
        }	
              
     /**
      * 버튼 권한 컨트롤 function <br>
      * 버튼을 제어한다. <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControlConv()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 최성민
      * @version 2009.04.17
      */
	function buttonControlConv(){
		var formObj = document.form;
  		var req_usr_flg = formObj.is_req_usr.value;
  		var apro_usr_flg = formObj.is_apro_usr.value; 
  		var expDt 	= formObj.exp_dt.value;
  		var effDt	= formObj.eff_dt.value;
      	var amdtSeq	= formObj.amdt_seq.value;
      	var sts = formObj.prc_prop_sts_cd.value;
      	
      	

  		try{
  			switch(sts) {
  				case 'I':   // Initial
  					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
  						var masterRow = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");
  						var detailRow = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cmdt_hdr_seq");
  						
  						if( (masterRow != detailRow)
  								|| sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq") != amdtSeq 
  								|| sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "src_info_cd") == "AD"
  								|| sheetObjects[1].RowHidden(sheetObjects[1].SelectRow) == true
  								|| (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq")  == amdtSeq
  										&& sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "eff_dt")!= effDt)) {
  								disableButton("btn_copy");
  								disableButton("btn_paste");
  								disableButton("btn_rowadd3");
  								disableButton("btn_rowcopy");
  								disableButton("btn_delete3");
  						} else {
  								enableButton("btn_copy");
  								enableButton("btn_paste");
  								enableButton("btn_rowadd3");
  								enableButton("btn_rowcopy");
  								enableButton("btn_delete3");
  						}
  					}				
  					break;  				
  			}	
  			
  		} catch (e) {
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
   
	