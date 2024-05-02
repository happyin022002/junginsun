/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3018.js
*@FileTitle : Publication Date Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.11.30 박성수
* 1.0 Creation
* =========================================================
* History
* 2016.06.17  [CHM-201642005] TRI Amendment & Creation 상에서 Publish 버튼 클릭 후 30초가 지나도 서비스 가능하도록 시스템 개발 
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
    function ESM_PRI_3018() {
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
			
			case "btn_ok":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
	
			case "btn_close":
				window.close();
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
		
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
    	
		document.form.pub_dt.focus();
	}
	
	/**
	 * OnKeyPress event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_keypress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/**
	 * OnBeforeActivate   event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_activate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 박성수
	 * @version 2009.04.17
	 */
	function obj_activate() {
		var formObject = document.form;
	    var srcName = event.srcElement.getAttribute("name");
	    
	    if (srcName == "pub_dt") {
	    	ComClearSeparator (event.srcElement);
	    }
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
	function obj_deactivate() {
		ComChkObjValid(event.srcElement);
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
		var sheetID = sheetObj.id;
		switch (sheetID) {
		
		case "sheet1":
			with (sheetObj) {
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle = "status";
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				
				Visible = false;
			}
			break;
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
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
			switch (sAction) {
			
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI01032", "Publish")) { //'Do you want to proceed {?msg1}?';
	                return false;
	            }
	            
	            formObj.f_cmd.value = MODIFY13;
	            var sParam = FormQueryString(formObj) + "&" + ComPriSetPrifix(dialogArguments.sheetObjects[0].GetSaveString(false, true, "chk"), "sheet1_");
	            
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_3018GS.do", sParam);
	            //[start backend job]-------------------------------------------------------------
	            ComOpenWait(true);
            	jobKey = ComGetEtcData(sXml, "JOB_KEY");
	            
            	if (sXml.indexOf("ERROR") >= 0) {
            		sheetObjects[0].LoadSaveXml(sXml);
            	} else if (jobKey == null || jobKey == "" || jobKey == undefined || jobKey.length <= 0) {
            		ComShowCodeMessage("PRI00201"); //'Problem occurred while saving data.';
        			return false;
            	} else {
        			setTimeout(getBackEndJobStatus, 2000);
        		}
            	//[end backend job]-------------------------------------------------------------
            	//기존 소스
//	            sheetObjects[0].LoadSaveXml(sXml);
//	            dialogArguments.reloadRate4PublishAll(formObj.pub_dt.value);
//	            ComShowCodeMessage("PRI05007"); //msgs['PRI05007'] = 'TRI published successfully.';
	            
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
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *      Webmail 전송 후 전송 완료되면 완료 메세지 출력
     * </pre>
     * 
     * @return 없음
     */
    function getBackEndJobStatus() {
    	var form = document.form;
    	var jobStatus = null;
    	form.f_cmd.value = SEARCHLIST18;
    	var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
    	jobStatus = ComGetEtcData(sXml, "JB_STS_FLG");
    	
    	if (jobStatus == "3") {
    		ComShowCodeMessage("PRI05007"); //msgs['PRI05007'] = 'TRI published successfully.';
    		ComOpenWait(false);
    		dialogArguments.reloadRate4PublishAll(form.pub_dt.value);
            window.close();
    	} else if (jobStatus == "4") { // BackEndJob을 실패 하였습니다.
    		ComShowCodeMessage("PRI00201");	//msgs['PRI00201'] = 'Problem occurred while saving data.';
    		ComOpenWait(false);
    	} else {
    		// [CHM-201641607]구주 지역 RFA Creation 화면의 Rate 화면 로딩 관련
    		setTimeout(getBackEndJobStatus, 2000);
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

        case IBSAVE: // 저장
        	
			if (formObj.pub_dt.value == "") {
				ComShowCodeMessage('PRI00316', '[New Publication Date]');
				return false;
			}
			
            var sCheckedRows = dialogArguments.sheetObjects[0].FindCheckedRow("chk");
            var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	for (var i = 0; i < arrCheckedRows.length; i++) {
        		var amdt_seq = dialogArguments.sheetObjects[0].CellValue(arrCheckedRows[i], "amdt_seq");
        		var lastPubDt= ComGetMaskedValue(dialogArguments.sheetObjects[0].CellValue(arrCheckedRows[i], "last_pub_dt"), "ymd");
        		var expDt= ComGetMaskedValue(dialogArguments.sheetObjects[0].CellValue(arrCheckedRows[i], "exp_dt"), "ymd");
        		
    			if (lastPubDt != "" && lastPubDt >= formObj.pub_dt.value) {
    				ComShowCodeMessage('PRI00321', '[New Publication Date]', '[Last Publication Date]');
    				return false;
    			}
    			
    			if (formObj.pub_dt.value >= expDt) {
    				ComShowCodeMessage('PRI00347');
    				return false;
    			}
    			
                if (amdt_seq == "0") {
    	            if (sheetObj.EvalDateDiff("D", formObj.pub_dt.value, expDt) < 29) {
    	            	ComShowCodeMessage("PRI05013");
                        return false;
    	            }
                }
        	}
        	
        	return true;
            break;
            
        }
    }
    
