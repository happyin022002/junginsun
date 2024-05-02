/*=========================================================
*Copyright(c) 2017 Hiplus Card
*@FileName : ESM_PRI_0037.js
*@FileTitle : Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.09.26 송민석
* 1.0 Creation
* 2013.12.03 전윤주 [SRM-201340798] amend 시 해당 proposal의 status 체크 로직 추가
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
     * @class ESM_PRI_0037 : ESM_PRI_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0037() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sysdate = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
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
					var rtn = doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					if(rtn){
						window.returnValue = true;
						close();	
					}
					break;
					
				case "btn_close":
					window.returnValue = false;
					close();
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
    * @author 공백진
    * @version 2009.04.17
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
    * @author 공백진
    * @version 2009.04.17
    */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}		
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
		initControl();
		var formObj = document.form;

	}
    
    
    /**
    * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	    
    function initControl() {
           //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
       axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
       axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);       
    }
    
    
    /**
    * OnBeforeActivate   event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }  
   
   
   /**
    * Onbeforedeactivate  event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function obj_deactivate() {
        var eleName = event.srcElement.name;
        switch(eleName){           	
            default:
                ComChkObjValid(event.srcElement);       
        }
        
    }       
   
   
    
    /**
    * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
   function sheet1_OnLoadFinish(sheetObj) {   
  	 	sheetObj.WaitImageVisible = false;   
  	 	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
        sheetObj.WaitImageVisible = true;  
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
    * @author 공백진
    * @version 2009.04.17
    */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 60;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 100);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|SC No|Prop No|Amend No.|Eff Dt|Exp Dt|Amend Effective Date||";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "sc_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "amdt_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, false, false);					
					InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, true, false);
                    InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "pre_eff_dt", true, "", dfNone, 0, true, false);
                    InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "exp_dt", true, "", dfNone, 0, true, false);

					ShowButtonImage = 2;
		
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
    * @author 공백진
    * @version 2009.04.17
    */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
    	try{
			sheetObj.ShowDebugMsg = false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);		
			switch (sAction) {
				case IBSEARCH: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value = SEARCH01;
						sheetObj.DoSearch("ESM_PRI_0037GS.do" , FormQueryString(formObj));
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
			
				case IBSAVE: // 저장
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var rValue = checkProposalStatus(); // 이전 회차 amend가 Filed 상태가 아니면 amend 하지 못함
            		if (rValue !="Y"){
            			ComShowCodeMessage("PRI01034");
            			return false;
            		}
					
					formObj.f_cmd.value = MULTI01;
//					sheetObj.CellValue(1,"ibflag")="I";
					sheetObj.RowStatus(1) = "I";
					var sParam = FormQueryString(formObj);
					    sParam += "&" + sheetObjects[0].GetSaveString();
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0037GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
	
					ComPriSaveCompleted();
					return true;
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
	    	sheetObj.WaitImageVisible = true;
	    }		
	}
	
	/**
     * Amend 시 해당 Proposal 의 MAX seq.가 filed 상태가 아니면 amend 할 수 없다. [SRM-201340798]<br>
     * 데이터 확인 요청 받은 후 URL을 직접쳐서 amend 창을 열었을 경우 validation이 되지 않아 추가함
     * <br><b>Example :</b>
     * <pre>
     *		checkProposalStatus();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Amend 가능<br>
     *          N : Amend 불가능.<br>
     * @author 전윤주
     * @version 2013.12.03
     */ 
    function checkProposalStatus(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var rValue = "N";
        formObj.f_cmd.value = SEARCH02;
        var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no");
        sParam += "&" + FormQueryString(formObj);
        
        var sXml = sheetObj.GetSearchXml("ESM_PRI_0037GS.do" , sParam);
        var arrData = ComPriXml2Array(sXml, "etc1");         
        if (arrData !=null && arrData.length > 0){
       	 if (arrData[0][0] == "Q"){//request이면
           	 rValue ="Y";
            }
        }
        return rValue;       
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
    * @return bool <br>
    *          true  : 폼입력값이 유효할 경우<br>
    *          false : 폼입력값이 유효하지 않을 경우
    * @author 공백진
    * @version 2009.04.17
    */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
	
		case IBSAVE: // 저장

 
			var sEffDt = sheetObj.CellValue(1,"pre_eff_dt") ;
	         var sExpDt = sheetObj.CellValue(1,"exp_dt") ;

 			
 
			var value  = sheetObjects[0].CellValue(1,"eff_dt");
			if(sEffDt>=value||sExpDt<value){
				ComShowCodeMessage("PRI01018","["+sEffDt+"]","["+sExpDt+"]");				
				sheetObj.CellValue2(1,"eff_dt") = sEffDt;
				sheetObj.SelectCell(1,"eff_dt", true);
				return false;
			}
			return true;
			break;
		}
	}
		
    /**
    * OnSearchEnd 이벤트 발생시 호출되는 function <br>
    * sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    * 	sheet1_OnSearchEnd(sheetObj, errMsg)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
    * @return 없음
    * @author 공백진
    * @version 2009.05.20
    */ 	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_eff_dt"),"ymd");
		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_exp_dt"),"ymd");
		sheetObj.SelectCell(1,"eff_dt", true); 
		sysdate = sheetObj.CellValue(1,"eff_dt"); 

	}
	
    /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Amend Date validation 처리를 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var sEffDt = sheetObj.CellValue(1,"pre_eff_dt") ;
        var sExpDt = sheetObj.CellValue(1,"exp_dt") ;

       
		if(sEffDt>=Value||sExpDt<Value){
			ComShowCodeMessage("PRI01018","["+sEffDt+"]","["+sExpDt+"]");
			sheetObj.CellValue2(1,"eff_dt") = sysdate;
			sheetObj.SelectCell(1,"eff_dt", true); 			
			return;
		}
		
	}
	/* 개발자 작업  끝 */