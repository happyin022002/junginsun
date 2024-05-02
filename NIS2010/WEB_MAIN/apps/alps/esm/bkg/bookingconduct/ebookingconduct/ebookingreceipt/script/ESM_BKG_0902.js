/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0902.js
*@FileTitle : e-Booking & S/I Reject
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.06 전용진 
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class esm_bkg_0902 : esm_bkg_0902 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0902() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var iterator = "|$$|";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case IBCLEAR:
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
	
				case "btn_OK":
					if (document.form.bkg_upld_sts_cd.value == "M"){
						if ( formObject.reject_reason_cd.value == '' || formObject.reject_reason_cd.value == null ) {
							ComShowCodeMessage('BKG00625');
							formObject.reject_reason_cd.focus();
							return;
						}
						opener.addValueNo(formObject.reject_reason.value, formObject.reject_reason_cd.value);
	         	    	self.close();
					} else {
		    			if(ComGetObjValue(formObject.cntc_eml) != ""){
		    				emlArr = ComGetObjValue(formObject.cntc_eml).split(";");
		    				for(var i = 0; i < emlArr.length; i++){
		    					if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
			    					ComShowCodeMessage("BKG40021" , emlArr[i]);
			    					ComSetFocus(formObject.cntc_eml);
			    					return false;
		    					}
		    				}
			            }
            		}
					if(document.form.bkg_upld_sts_cd.value == "R"){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
					} else if (document.form.bkg_upld_sts_cd.value == "P") {
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
					} 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
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

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        initControl();
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
           case 1:
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|cntr_prt_flg|cntr_wgt|cntr_cfm_flg|pagerows|ibflag|po_no|cntr_no|cntr_tpsz_cd|wgt_ut_cd|meas_qty|pck_qty|cntr_seal_no|pck_tp_cd|meas_ut_cd|";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,30,	daCenter, true,	"ibflag");
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_prt_flg",	false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_wgt",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_cfm_flg",	false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pagerows",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "ibflag",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "po_no",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_no",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_tpsz_cd",	false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "wgt_ut_cd",	false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "meas_qty",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pck_qty",		false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_seal_no",	false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pck_tp_cd",	false,		"",		dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "meas_ut_cd",	false,		"",		dfNone,			0,		true,		true);
                    CountPosition = 0;
			}
			break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
		case IBCLEAR:      //조회
			// 모달창인 경우는 window 객체로부터 opener를 획득
			if(!opener)
				opener = window.dialogArguments;

//			alert(opener.name);
			if (opener.name == "main") { // ESM_BKG_0228에서 open한 경우
				var openerFormObj = opener.document.form;
			} else { // ESM_BKG_0229에서 open한 경우
				var openerFormObj = opener.document.frames("t1frame").form;
			}
			
			if(formObj.bkg_upld_sts_cd.value != "M" ){
				replaceReasonText("{?rqst_no}", formObj.rqst_no.value);
				replaceReasonText("{?bkg_no}" , formObj.bkg_no.value);
				replaceReasonText("{?v1}"     , openerFormObj.vvd2.value);
				replaceReasonText("{?v2}"     , openerFormObj.vsl_nm2.value);
				replaceReasonText("{?por1}"   , openerFormObj.bkg_por_cd2.value);
				replaceReasonText("{?por2}"   , openerFormObj.por_nm2.value);
				replaceReasonText("{?pol1}"   , openerFormObj.bkg_pol_cd2.value);
				replaceReasonText("{?pol2}"   , openerFormObj.pol_nm2.value);
				replaceReasonText("{?pod1}"   , openerFormObj.bkg_pod_cd2.value);
				replaceReasonText("{?pod2}"   , openerFormObj.pod_nm2.value);
				replaceReasonText("{?del1}"   , openerFormObj.bkg_del_cd2.value);
				replaceReasonText("{?del2}"   , openerFormObj.del_nm2.value);
			}
			break;

		case IBSEARCH_ASYNC01: // reject
			if ( ComGetObjValue(formObj.eml_snd_yn) == 'Y') {				
				if ( formObj.cntc_eml.value == '' || formObj.cntc_eml.value == null ) {
					ComShowCodeMessage('BKG00366');
					formObj.cntc_eml.focus();
					return;
				}
			}
			if ( formObj.reject_reason_cd.value == '' || formObj.reject_reason_cd.value == null ) {
				ComShowCodeMessage('BKG00625');
				formObj.reject_reason_cd.focus();
				return;
			}
			
			var sVal = getArgValue(formObj.reject_reason);
			if ( formObj.reject_reason_cd.value == '0' && sVal.indexOf('Request No :') - sVal.indexOf('Reason for Decline :') < 27){
				ComShowCodeMessage('BKG02226');
				formObj.reject_reason.focus();
				return;
			}
			
			if ( formObj.eml_snd_yn[0].checked ) {
				formObj.eml_snd_yn.value = "Y";
			} else formObj.eml_snd_yn.value = "N";
			formObj.f_cmd.value = MODIFY;
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0902GS.do", FormQueryString(formObj));

			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				if(formObj.eml_snd_yn.value == "Y"){
					ComShowCodeMessage('BKG00497');
					window.close();
				} else {
					ComShowCodeMessage('BKG00166');
					window.close();
				}
			} else {
				sheetObj.LoadSaveXml(sXml);
			}
			break;
			
    	case IBSEARCH_ASYNC02: // pending
    		if ( ComGetObjValue(formObj.eml_snd_yn) == 'Y') {				
				if ( formObj.cntc_eml.value == '' || formObj.cntc_eml.value == null ) {
					ComShowCodeMessage('BKG00366');
					formObj.cntc_eml.focus();
					return;
				}
			}
			if ( formObj.reject_reason_cd.value == '' || formObj.reject_reason_cd.value == null ) {
				ComShowCodeMessage('BKG00625');
				formObj.reject_reason_cd.focus();
				return;
			}
			if ( formObj.eml_snd_yn[0].checked ) {
				formObj.eml_snd_yn.value = "Y";
			} else formObj.eml_snd_yn.value = "N";

			formObj.f_cmd.value = MODIFY02;
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0902GS.do", FormQueryString(formObj));
//			formObj.f_cmd.value = MODIFY;
//			var sXml = sheetObj.GetSaveXml("ESM_BKG_0902GS.do", FormQueryString(formObj));

			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				if(formObj.eml_snd_yn.value == "Y"){
					ComShowCodeMessage('BKG00497');
					window.close();
				} else {
					ComShowCodeMessage('BKG00166');
					window.close();
				}
			} else {
				sheetObj.LoadSearchXml(sXml);
			}
    		break;
        }
    }

    function initControl() {
    	var formObject = document.form;
    	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
    }

	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "int":
	            //숫자만입력하기
	            ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
        	case "saupja":
	            //숫자 + "+-."
	            ComKeyOnlyNumber(event.srcElement, "+-.");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	            break;
	    }
	}

	function changeReason(){
	   	var formObj = document.form;
	   	var obj = formObj.reject_reason_cd;
		var msg = formObj.reject_reason.value;
		var idx1 = "";
		if(formObj.bkg_upld_sts_cd.value == "R" || formObj.bkg_upld_sts_cd.value == "M" ){
			idx1 = formObj.reject_reason.value.indexOf("Reason for Decline : ");
		} else {
			idx1 = formObj.reject_reason.value.indexOf("Reason for Pending : ");
		}
		var idx2 = 0;
		for (var i=idx1;i<msg.length;i++) {
			var ch = msg.charAt(i);
			if (ch == "\n") {
				idx2 = i;
				break;
			}
		}
		var msg2 = formObj.reject_reason.value.substring(idx1, idx2);
		var dpReason = obj.options[obj.selectedIndex].text;
		
		// Manual Input 의 경우엔 내용을 셋팅하지 않음.
		if (dpReason == "Manual Input"){
			dpReason = "";
		}
		if(formObj.bkg_upld_sts_cd.value == "R" || formObj.bkg_upld_sts_cd.value == "M"){
			msg = ComReplaceStr(msg, msg2, "Reason for Decline : "+dpReason);
		} else {
			msg = ComReplaceStr(msg, msg2, "Reason for Pending : "+dpReason);
		}
		formObj.reject_reason.value = msg;
	}

	function replaceReasonText(dst, rep){
		var formObj = document.form;
		var msg = formObj.reject_reason.value;
   		msg = ComReplaceStr(msg, dst, rep);
		formObj.reject_reason.value = msg;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
        return true;
    }