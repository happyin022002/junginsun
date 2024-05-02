/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0303.js
*@FileTitle : Handling Costs
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
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
     * @class CPS_CNI_0303 : CPS_CNI_0303 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0303() {
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
   	var prefix = "sheet_";
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");
					//alert(srcName);
            switch(srcName) {
                case "btn_Retrieve":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
	             	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	             	formObject.dw_clm_no.disabled = true;
                    break; 

                case "btn_New":
	             	if(!CoCniInitConfirm(sheetObject1)) return;
					ComResetAll();
	             	formObject.dw_clm_no.disabled = false;
                    break; 

                case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break; 

                case "cal_from_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.from_dt, 'yyyy-MM-dd');
                    break; 

                case "btn_Row_Add":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var row = sheetObject1.DataInsert(-1);
					sheetObject1.CellValue(row, prefix+"dw_clm_no") = formObject.dw_clm_no.value;
					sheetObject1.CellImage(row, prefix+"inv_rmk") = 0;
					break;

                case "btn_Row_Insert":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					var row = sheetObject1.DataInsert();
					sheetObject1.CellValue(row, prefix+"dw_clm_no") = formObject.dw_clm_no.value;
					sheetObject1.CellImage(row, prefix+"inv_rmk") = 0;
                    break; 

                case "btn_Row_Copy":
	          		if(sheetObject1.SelectRow > 0) {
	          			var selRow = sheetObject1.SelectRow;
						var row = sheetObject1.DataInsert();
	                    sheetObject1.Copy2SheetCol(sheetObject1,"","",selRow,selRow,2);
                	}
                    break; 

                case "btn_Row_Delete":
					if(ComCniCheckBoxCheckYn(sheetObject1, prefix+"DelChk")) { 
						ComRowHideDelete(sheetObject1, prefix+"DelChk"); 
					}
                    break;

				case "btn_DownExcel":
					var strColSkipList = prefix + "ibflag|" + prefix + "DelChk|" + prefix + "cost_seq|" + prefix + "seq_no";
					sheetObject1.SpeedDown2Excel(0,false,false,'','',false,false,'',false, strColSkipList);
                    break; 
                break;

				case "btn_LoadExcel":
	          		if(!validateForm(sheetObject1,formObject,IBSEARCH)) return;
					sheetObject1.LoadExcel(-1)
                    break; 
                break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
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
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;

        //html컨트롤 이벤트초기화
        initControl();
        
        //권한
        setRollBtnCtlDwc(form.hdlr_usr_id.value, "btn_Save,btn_Row_Add,btn_Row_Insert,btn_Row_Copy,btn_Row_Delete,btn_LoadExcel");

    }

    /**
     * Sheet의 Load가 끝났을때 발생되는 이벤트
     */
    function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
		initMiscCode(sheetObj);   
		
		if (form.dw_clm_no.value != '') {
			doActionIBSheet(sheetObj,document.form,IBSEARCH);
		}
		sheetObj.WaitImageVisible = true; 
    } 

	/**
	* 콤보 Miscellaneous 코드값 가져오기
    * @param {ibsheet} sheetObj    IBSheet Object
	*/
    function initMiscCode(sheetObj) {
		sheetObj.WaitImageVisible = false;
      
		//MISCELLANEOUS 코드 정보를 가져온다
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH, "ComCd");

		sheetObj.WaitImageVisible = true; 
    } 
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 							//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        
        axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('keyup', 'obj_keyup' , "dw_clm_no");							//- Case No.가 모두 입력됐을때 keyup 이벤트 발생시

    }

 	//focus in
 	function obj_activate(){
 		obj = event.srcElement;
 		//readonly 일때 데이터 포맷 변경되는 것  방지
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

        ComChkObjValid(event.srcElement);
    	
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.name){
	        case "dw_clm_no":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 Case No.가 모두 입력됐을때 조회한다. <br>
     **/
    function obj_keyup(){

    	switch(event.srcElement.name){
	        case "dw_clm_no":
	        	var keyValue = event.keyCode;
	        	//대문자와 숫자인 경우만 실행
	        	if ((keyValue >= 65 && keyValue <= 90) || (keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105)) {
		        	if (event.srcElement.value.trim().length == 11) {
		            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		        	} 
	        	}
	            break;
    	}
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

		           // 높이 설정
					style.height = 380;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Sel.|Seq.|Type|Payee|Payee|Description|Inv. Date|Invoiced Amount|Currency|R.O.E|USD Amount|Paid Date|Remark(s)|";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(16, 7, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,  prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,   false,  prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtDataSeq,    	50,    	daCenter,  	true,   prefix + "Seq");
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	prefix + "clm_cost_tp_cd",	true,   "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		220,	daCenter,	true,	prefix + "clm_pty_no");
					InitDataProperty(0, cnt++ , dtPopup,		220,	daLeft,		true,	prefix + "clm_pty_nm",		true,	"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		true,	prefix + "cost_desc",		true,   "",				dfNone,		0,			true,		true, 500);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix + "inv_dt",			true,	"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daRight,	true,	prefix + "inv_amt",			true,   "",				dfFloat,	2,			true,		true, 18);
					InitDataProperty(0, cnt++ , dtPopupEdit,	70,		daCenter,	true,	prefix + "locl_curr_cd",	true,	"",				dfEngUpKey,	0,			true,		true, 3, true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	110,	daRight,	true,	prefix + "inv_xch_rt",		false,  "",				dfFloat,	5,			true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		110,	daRight,	true,	prefix + "inv_usd_amt",		false,  "Round(|"+prefix +"inv_amt|/|"+prefix +"inv_xch_rt|,2)",		dfFloat,		2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix + "pay_dt",			false,	"",				dfDateYmd,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtImageText,	350,	daLeft,		true,	prefix + "inv_rmk",			false,  "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	prefix + "cost_seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	prefix + "seq_no",			false,	"|"+prefix +"Seq|");

					InitDataValid(0, prefix + "locl_curr_cd", vtEngUpOnly);
					
					DataLinkMouse(prefix + "clm_pty_nm") = true;
					DataLinkMouse(prefix + "locl_curr_cd") = true;
					DataLinkMouse(prefix + "inv_xch_rt") = true;
					DataLinkMouse(prefix + "inv_rmk") = true;

					ImageList(0) = "img/btns_note.gif";
					InitDataImage(0, prefix + "inv_rmk", daRight);
					ShowButtonImage = 2;
					
					AutoRowHeight = false;//메모장을 이용해 줄바뀜이 되어 내용이 길어져도 Row의 높이가 늘어나지 않게 함.
		          }
		          break;

        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {

        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = SEARCH;
	        	
	        	var aryPrefix = new Array("sheet_");
	
	   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0303GS.do" , FormQueryString(formObj) +"&" + ComGetPrefixParam(aryPrefix));
	   			sheetObj.LoadSearchXml(sXml);
	   			
	   			ComEtcDataToForm2(formObj, sheetObj, "", true);
	   			
	   		    //권한
	   	        setRollBtnCtlDwc(form.hdlr_usr_id.value, "btn_Save,btn_Row_Add,btn_Row_Insert,btn_Row_Copy,btn_Row_Delete,btn_LoadExcel");

			break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			
	 			formObj.f_cmd.value = MULTI;
	 			
	        	var aryPrefix = new Array("sheet_");
				var arrSheets = new Array(sheetObj);
				var sParam = ComGetSaveString(arrSheets, true);
				
				//필수 입력과 같은 확인이 이루어짐
				if (!sheetObj.IsDataModified || sParam == "") return;

	 			var sXml = sheetObj.GetSaveXml("CPS_CNI_0303GS.do", FormQueryString(formObj) +"&" + sParam +"&" + ComGetPrefixParam(aryPrefix), true); 
	   			var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	   			sheetObj.LoadSaveXml(sXml);

				if (result == 'F') {

					var errMsg = GetXMLData(sXml, "MESSAGE");
					
					var strLen = errMsg.length;
					var errType = '';
					var findRow = 0;
					var strPos = 0;
					for (ii=0; ii<strLen; ii++) {
						
						strPos = ii+5;
						if (strPos > strLen) {
							strPos = strLen;
						}
						if (errMsg.substring(ii,strPos) == "Payee") {
							errType = "P";
						}

						strPos = ii+8;
						if (strPos > strLen) {
							strPos = strLen;
						}
						if (errMsg.substring(ii,strPos) == "Currency") {
							errType = "C";
						}
						
						strPos = ii+2;
						if (strPos > strLen) {
							strPos = strLen;
						}
						if (errMsg.substring(ii,strPos) == "No") {
							findRow = parseFloat(errMsg.substring(ii+6,ii+10).trim());
							exit;
						}
					
					}	

					if (errType == "P") {

		 				sheetObj.SelectCell(findRow, prefix + "clm_pty_nm");
		 				
					} if (errType == "C") {

		 				sheetObj.SelectCell(findRow, prefix + "locl_curr_cd");

					}
				}
	 			
                break;

			case IBROWSEARCH: 

				if (Col == "ComCd") {//코드 조회
					
					CoCniGetCombo(formObj, sheetObj, "GRID", "26",prefix + "clm_cost_tp_cd", prefix + "clm_cost_tp_cdText");

				} else if (Col == prefix + "locl_curr_cd") {//Currency

		   			var sXml = sheetObj.GetSearchXml("CPS_CNI_0301GS.do" , "&f_cmd="+SEARCH04+"&curr_cd="+sheetObj.CellValue(Row,Col));

		   			var result = ComGetEtcData(sXml, "curr_cd");

		   			if(typeof result == "undefined" || result == "" ) {
						ComShowMessage(ComGetEtcData(sXml, "errMsg"));
						sheetObj.CellValue2(Row,Col) = "";
		 				sheetObj.SelectCell(Row, Col);
						return;
					}
				
				}
					
					
			break;
        }
    }

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	var popupRow = 0;
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
	{
	
		if (sheetObj.ColSaveName(Col) == prefix + "clm_pty_nm") {
			popupRow = Row;
			popupMainCodeInquiry();
		
		} else if (sheetObj.ColSaveName(Col) == prefix + "locl_curr_cd") {
			ComOpenPopup("COM_ENS_N13.do", 500, 400, "setCurrencyCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_N13");
		
		} else if (sheetObj.ColSaveName(Col) == prefix + "inv_xch_rt") {
			//환율 팝업 클릭시 금액, 통화, 날짜 등 다른 세개의 필드도 모두 입력되었는지 체크
	
	       	if (!chkFields(Row, "ROE")) return;

			popupRow = Row;
       		var currCd = sheetObjects[0].CellValue(Row, prefix + "locl_curr_cd");
       		var yrMon = sheetObjects[0].CellValue(Row, prefix + "inv_dt");
			popupRateOfExchange(currCd, yrMon);
		}

		
	}
	
     /**
      * IBSheet Object에서 Cell을 클릭시
      */         
    function sheet1_OnClick(sheetObj, Row, Col, value) {
 		if (sheetObj.ColSaveName(Col) == prefix + "inv_rmk") {
			ComShowMemoPad(sheetObj, Row, Col, false, 400, 400, 4000);
		}
 	} 
        
     /**
      * Remark Image Setting
      */         
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			for (var i = 1 ; i <= sheetObj.LastRow; i ++)
 	 		{ 
 				CellImage(i, prefix + "inv_rmk") = 0;
 	 		}
 		}
 	} 

    /**
     * R.O.E popup에서 선택시 Currency, Exchange Rate를 세팅한다.
     */
    function setCurrencyROE(xchRtVo) {

		sheetObjects[0].CellValue2(popupRow, prefix + "locl_curr_cd") = xchRtVo.curr_cd;
		sheetObjects[0].CellValue2(popupRow, prefix + "inv_xch_rt") = xchRtVo.usd_locl_xch_rt;
    	
    }

	/**
	* Currency 입력부분.<br>
	* @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	*/
	function setCurrencyCd(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].CellValue2(Row, Col) = aryPopupData[0][3];
	}

    /**
     * Party popup에서 선택시 Party Name을 세팅한다.
     */
    function setMainCodeInquiry(partyVo) {

		sheetObjects[0].CellValue2(popupRow, prefix + "clm_pty_no") = partyVo.clm_pty_no;
		sheetObjects[0].CellValue2(popupRow, prefix + "clm_pty_nm") = partyVo.pty_nm;
    	
    }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value) {

 			if (sheetObj.ColSaveName(Col) == prefix + "locl_curr_cd") {
 				
 				if (Value == 'USD') {
					sheetObj.CellValue(Row, prefix + "inv_xch_rt") = 1;
 				} else {
	        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, sheetObj.ColSaveName(Col), Row);
 				}

 			}
 	}		

     /**
      * IBSheet Object에서 셀에 포커스가 있는 상태에서 키보드를 누르거나, Edit 상태에서 키보드를 누른 경우 Event가 발생한다
      */
 	function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode,Shift) {

		if (KeyCode ==13 && sheetObj.ColSaveName(Col) == prefix + "inv_rmk") {
			//ComShowMemoPad(sheetObj, Row, Col, false, 400, 400, 4000);
		}
 	}		

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        with(formObj){

			if (!ComChkValid(formObj)) return false;

        	if (sAction == IBSAVE) {
        		
				var sRow = sheetObj.FindStatusRow("U|I");

				//받은 결과를 배열로 생성한다.
				var arrRow = sRow.split(";");
				for (idx=0; idx<arrRow.length-1; idx++) { 
					if (!chkFields(arrRow[idx], "SAVE")) return; 
				}
        		
        	}
        
        }

        return true;
    }

    /**
     * 금액, 통화, 날짜, 환율이 입력되었는지 체크
     */
    function chkFields(Row, flag) {
    	
    	var sheetObj = sheetObjects[0];
    	
       	if (ComIsNull(sheetObj.CellValue(Row, prefix + "inv_dt"))) {
			ComShowCodeMessage('CNI09028',"Inv. Date");
			sheetObj.SelectCell(Row, prefix + "inv_dt");
			return false;
    	} 
    	if (ComIsNull(sheetObj.CellValue(Row, prefix + "inv_amt")) || sheetObj.CellValue(Row, prefix + "inv_amt") == 0) {
			ComShowCodeMessage('CNI09028',"Invoiced Amount");
			sheetObj.SelectCell(Row, prefix + "inv_amt");
			return false;
       	} 
       	if (ComIsNull(sheetObj.CellValue(Row, prefix + "locl_curr_cd"))) {
			ComShowCodeMessage('CNI09028',"Currency");
			sheetObj.SelectCell(Row, prefix + "locl_curr_cd");
			return false;
       	} 

		//Save클릭시 환율도 입력되었는지 체크
    	if (flag == "SAVE") {
    		if (ComIsNull(sheetObj.CellValue(Row, prefix + "inv_xch_rt")) || parseFloat(ComReplaceStr(sheetObj.CellValue(Row, prefix + "inv_xch_rt"),",","")) == 0) {
				ComShowCodeMessage('CNI09028',"R.O.E");
				sheetObj.SelectCell(Row, prefix + "inv_xch_rt");
				return false;
			}	
       	}
       	
       	return true; 
		    	
	}
	
    /**
     * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
     * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
     * @param {string} dataNode  파싱할 항목
     * @return {string} xmlValue
     **/
  	function GetXMLData(xmlStr, dataNode) {
  		
  		var xmlData = '';

        try {
            /* XML Parsing */
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async = "false";
            xmlDoc.loadXML(xmlStr);
			/* get message */
            xmlData = xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text
        } catch(err) {
            xmlData = '';
        }
        
		return xmlData;
  	}
    
	/* 개발자 작업  끝 */