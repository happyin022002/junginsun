/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FNS_INV_0137.js
*@FileTitle : Customer Inquiry by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.24 임옥영
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
     * @class FNS_INV_0137 : FNS_INV_0137 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0137() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
//    	this.sheet1_OnClick         = sheet1_OnClick;
//    	this.sheet1_OnChange        = sheet1_OnChange;
    }
    
   	/* 개발자 작업	*/
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;

	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			
			
				case "btn_RowDelete": doActionIBSheet(sheetObject1,formObject,IBDELETE); break;
				case "btn_Retrieve":
					//
					if(sheetObject1.ROWCOUNT>0) 
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					break;
		
				case "btn_New":
					//조회조건 초기화	
					for(i=0;i<500;i++){sheetObject1.CellValue2(i, "bl_no1") = "";}
					if(sheetObject2.ROWCOUNT>0)sheetObject2.RemoveAll();
                    //formObject.reset();
					break;
				
				case "btn_Import":
					if(sheetObject2.ROWCOUNT>0) sheetObject2.RemoveAll();
					sheetObject1.RemoveAll();//초기화
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				
				case "btn_DownExcel"://sheet2 다운로드
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}


    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
     }

	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		switch(sheetNo) {
			
			case 1:      //sheet1 inityy	
						with (sheetObj) {
							//높이 설정
							style.height = 440;
							//전체 너비 설정
							SheetWidth =  mainTable1.clientWidth;
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msNone;
			
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
							var HeadTitle = "Del|BL No";
			
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo( 1, 1, 500, 500);
			
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
			
							//해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false, false);
			
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle, false);
			
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							//InitDataProperty(0, cnt++ , dtData,  10,   daCenter,  false,  "seq",		false,    "",    dfNone, 	0,    true,      true);
							InitDataProperty(0, cnt++ , dtCheckBox,     30,   daCenter,  false,   "ck",	false,    "",    dfNone, 	0,    true,      true);
							InitDataProperty(0, cnt++ , dtData,           90,   daCenter,  false,   "bl_no1", false,    "",    dfNone,   0,    true,      true);
							sheetObj.Rows = 501;
							WaitImageVisible=false;
							CountPosition = 4;
						}
					break;
						
		case 2:      //sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 440;
					//전체 너비 설정
					SheetWidth =  mainTable2.clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					var HeadTitle = "No.|BL No|SC No|RFA No|SHPR Code|SHPR Name1|SHPR Name2|CNEE Code|CNEE Name1|CNEE Name2|Notify Code|Notify Name1|Notify Name2|F/Forwarder Code|F/Forwarder Name1|F/Forwarder Name2";
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 500, 500);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,  false,  "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          35,     daCenter,  true,   "no",      		false,    "",    dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,    		90,   	daCenter,  true,   "bl_no",			false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  true,   "sc_no",			false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  true,   "rfa_no",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		60,   	daCenter,  true,   "s_cust",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "s_nm1",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "s_nm2",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		60,   	daCenter,  true,   "c_cust",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "c_nm1",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "c_nm2",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		60,   	daCenter,  true,   "n_cust",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "n_nm1",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "n_nm2",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		60,   	daCenter,  true,   "f_cust",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "f_nm1",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		100,   	daLeft,  true,   "f_nm2",		false,    "",    dfNone, 		0,     true,       true);
					WaitImageVisible=false;
	                CountPosition = 4;
				}
			break;
			
		}
	}


  	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	}

	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {	
		
		case IBDELETE:
				if(availableDelCheck(sheetObj)){
					if(ComShowCodeConfirm("INV00028")){
						for(i=1;i<=500;i++){
						    if(sheetObj.CellValue(i, "ck") == "1" ){
						    	sheetObj.CellValue2(i, "bl_no1") = "";
						    	sheetObj.CellValue2(i, "ck") = "0";
					    	 }
						}
					}
				}
				break;	
		
		case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCHLIST;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
				var bl_nos = "";
				var tmp = "";

					for(i=1;i<=500;i++){	
						if(i == sheetObjects[0].LastRow) bl_nos += sheetObjects[0].CellValue(i, "bl_no1");
						else  bl_nos += sheetObjects[0].CellValue(i, "bl_no1") + ",";
				}
				formObj.bl_nos.value = bl_nos;//bl_nos 세팅
                
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				//sheetObj.DoSearch4Post("FNS_INV_0137GS.do");
				var sXml = sheetObj.GetSearchXml("FNS_INV_0137GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
                ComOpenWait(false);
                break;
            	
            	
			case IBLOADEXCEL:		//엑셀 업로드
				sheetObjects[0].LoadExcel(-1, 1, "", -1, 502, "");		
				if(sheetObjects[0].ROWCount > 500) {//업로드된 데이터가 500개가 넘으면 에러
					for(i=1;i<=sheetObjects[0].ROWCount;i++) sheetObj.CellValue2(i, "bl_no1") = "";//데이터 초기화
					
					sheetObjects[0].RowDelete(sheetObjects[0].ROWCount, false);//마지막행 지우기
					ComShowCodeMessage('INV00172');
				} else if(sheetObjects[0].ROWCount < 500){//업로드된 데이터가 500개가 안되면 나머지 채워줌
					sheetObj.Redraw=false;
					for( i=sheetObjects[0].ROWCount;i <500;i++) sheetObjects[0].DataInsert(-1);
					sheetObj.Redraw=true;
				}
				//
				sheetObjects[0].SelectCell(1, 1, true);
				//SelectBackColor 

					
 			break;
 			
 			case IBDOWNEXCEL:		//엑셀 다운로드
 				sheetObj.Down2Excel(0, false, false, true);
 				break;
 			
         }
     }

	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
     function validateForm(sheetObj,formObj,sAction){
    	 /*
       	with(sheetObj){
      		if(sheetObj.FindText("value", "\'", 1, 2) == -1){
      			ComShowCodeMessage(''INV00028'');
      			return false;
      		}
      	}*/        
      	return true;
	 }
     
 	/** 
 	 * ChekBox 값이 하나라도 체크되어 있는지 확인 <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param  {IBSheet} sheetObj : 시트오브젝트  
 	 * @return true, false
 	 * @see #
 	 * @author 임옥영
 	 * @version 2013.09.23
 	 */
     function availableDelCheck(sheetObj){
			var hasDel = false;
			
			for(i=1; i<=500; i++){
				if(sheetObj.CellValue(i, "ck") == "1") {
					hasDel = true; 
					break;
				}
			}
			return hasDel;
     }
     
     
/* 개발자 작업  끝 */