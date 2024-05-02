/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1060.jsp
*@FileTitle : MTY Rail Arrival Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
* 2011.07.25 나상보 [CHM-201112443] [EQR]  MTY Rail Arrival Detail 화면에 Down Excel 기능 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */

    /**
     * @extends 
     * @class EES_EQR_1060 : EES_EQR_1060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1060() {
    	this.processButtonClick		= processButtonClick;
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
	
	var sheetObject = null;
	var sheetRow    = 0 ;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	var formObject = null;
	var srcName = null;
	
	var opener = window.dialogArguments;
	
	/**
	 * 설  명 : 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <b>Example : </b>
	 * <pre>
	 *    processButtonClick()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function processButtonClick(){
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {

			case "btn_close":
                self.close();
                break;
                
			case "btn_downexcel":
				sheetObject.Down2Excel(-1, false, false, true);
				break;
			
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("EQR90004"); //ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);  //ComShowMessage(e);
			}
		}
	}
	
	/**
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage() {
		sheetObject = sheetObjects[0];    /* 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 */
		formObject = document.form;
		
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);  //khlee-시작 환경 설정 함수 이름 변경
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);  //khlee-마지막 환경 설정 함수 추가
		}
		
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
		
        initControl();
	}
	
	/**
	 * 설  명 :  시트 초기설정값, 헤더 정의 <br>
	 *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj,sheetNo,tpszValue)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
	 * @param {String}	tpszValue  - Container Tpsz
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 1, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					var HeadTitle = "CNTR No.|MVMT Status";
										
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,      200,    daCenter, true,    "eq_no"       ,       false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter, true,    "mvmt_sts_cd"       ,       false,          "",       dfNone,       0,     false,       false);
					
					HeadRowHeight= 20;
//					CountPosition = 0;
					SelectHighLight = false;
					ExtendLastCol = false;
				}
				break;
		}
	}
	
	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {	
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:
				var sXml = opener.setPopUpXml();
				sheetObj.LoadSearchXml(sXml);			
				break;

		}
	}
	
	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param  {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * 설  명 : 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     validateForm(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
		
		}
		return true;
	}
	
	/**
	 * 설  명 :페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initControl() {
		axon_event.addListenerForm	('blur',			'form_blur',			formObject);
		axon_event.addListenerFormat('keyup',			'form_keyup',			form);
		axon_event.addListenerForm	('change',			'form_change',			formObject);
		axon_event.addListenerFormat('beforedeactivate','obj_beforedeactivate',	form);
		axon_event.addListenerFormat('beforeactivate',	'obj_beforeactivate',	form);
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	 
	/**
	 * 설  명 : 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObj, errMsg)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {String}	errMsg  - 조회 후 메시지
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
//		 var dest1 = formObject.dest1.value;
//		 var dest2 = formObject.dest2.value;
//		 var tpsz = formObject.tpsz.value;
//		 var etaDt = formObject.eta_dt.value;
//		 with(sheetObj){
//			 for(var i = 1; i <= LastRow; i++){
//				 if(dest1 != "G.Total" && dest1 != "Total" && dest1 != CellValue(i, "dest1")){
//					 RowHidden(i) = true;
//				 }else if(dest2 != "G.Total" && dest2 != "Total" && dest2 != CellValue(i, "dest2")){
//					 RowHidden(i) = true;
//				 }else if(tpsz != "G.Total" && tpsz != "Total" && tpsz != CellValue(i, "tpsz")){
//					 RowHidden(i) = true;
//				 }else if(etaDt != CellValue(i, "eta_dt")){
//					 RowHidden(i) = true;
//				 }				 
//			 }
//		 }
	}
	
	
	 
	/* 개발자 작업  끝 */