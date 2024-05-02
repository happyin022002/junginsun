/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0069.js
*@FileTitle : Item Detail Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.20 윤세영
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
     * @class Item Detail Management : Item Detail Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0069() {
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
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

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

            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					
					ComResetAll();
                break;

				case "btn_save":
				
					if (!checkDupAcctItem(sheetObject)) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
                	}
                break;

				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                break;
	
				case "btn_print":
					alert("btn_print");
                break;

				case "btn_add":
					
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "acct_itm_nm");
					
                break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert();
					sheetObject.SelectCell(row, "acct_itm_nm");
					
					break;

				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
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
    * Save 버튼 클릭시 중복 체크
    */
	function checkDupAcctItem(sheetObject) {
		
		var sRow = sheetObject.FindStatusRow("I|U");
		var arrow = sRow.split(";");
		
		var len = arrow.length - 1;
		
		for (i=0; i<len; i++) {

			var findrow = sheetObject.FindText("acct_itm_nm", sheetObject.CellValue(arrow[i], "acct_itm_nm"), 0, -1, false);

			if (findrow > 0) {

				if (findrow == arrow[i]) {
					findrow = sheetObject.FindText("acct_itm_nm", sheetObject.CellValue(arrow[i], "acct_itm_nm"), findrow+1, -1, false);
				}	
			
				if (findrow > 0) {
					ComShowCodeMessage('FMS01340', arrow[i], findrow);
					sheetObject.SelectCell(arrow[i], "acct_itm_nm");
					return true;
				}
			}		
		}	

		return false;

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
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "/";
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리

        axon_event.addListener  ('keypress', 'obj_keypress' , 'acct_cd');			//- Vendor Code 입력 시 숫자만 입력하기

    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

					// 높이 설정
					style.height = 420;
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
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(6, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle = "|Sel|Seq||Item Name|Account Code";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	 40,    daCenter,   false,   "DelChk");
					InitDataProperty(0, cnt++ , dtDataSeq,    	 40,    daCenter,  	true,    "Seq");
	                InitDataProperty(0, cnt++ , dtHidden,  		 0,    	daCenter,  	true,    "acct_itm_seq");
					InitDataProperty(0, cnt++ , dtData,   		 550,   daLeft,  	false,   "acct_itm_nm",     		true,          "",     dfNone,      		0,     true,       true, 150);
					InitDataProperty(0, cnt++ , dtPopupEdit,   	 120,   daCenter,  	false,   "acct_cd",   				true,          "",     dfUserFormat2,   			0,     false,       true, 6);
					ShowButtonImage = 2;										
 										
					InitUserFormat2(0, "acct_cd", "######", "" );
					
    				SelectBackColor = RgbColor(219,245,219);
    				
    				SelectionMode = smSelectionRow;
					
					DataLinkMouse("acct_cd") = true;

                }
                break;

         }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
        		formObj.f_cmd.value = SEARCH;
        	   	sheetObj.DoSearch("ESM_FMS_0069GS.do", FormQueryString(formObj));
        	   
                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0069GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //조회	

	    		if (Col == "acct_cd") {//Account code 직접 입력시

					formObj.f_cmd.value = SEARCH01;
					
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0069GS.do" , FormQueryString(formObj)+"&acct_cd="+sheetObj.CellValue(Row,Col));
		
	    			setAccountName(sheetObj, sXml, Row, Col);

				}

        }
    }


    /**
     * Account 코드를 체크한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  comboCode   Type 의 코드값
     * @param {int}  	col   		column index
     **/
    function setAccountName(sheetObj, sXml, Row, Col) {
    	if (sXml != "" ) {
			if (ComGetEtcData(sXml, "cdName") != undefined) {
				

	    	} else {
				
				sheetObj.CellValue2(Row,"acct_cd") = '';
				ComShowCodeMessage('FMS01336');
				sheetObj.SelectCell(Row, Col);
	    	}
	    }		
    }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		//alert(ErrMsg);
	}	

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
 		{
 		
 			if (sheetObj.ColSaveName(Col) == "acct_cd") {
 				ComOpenPopup("ESM_FMS_0080.do", 520, 400, "setAccountCode", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0080");
 			}
 			
 		}

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value)
 		{

 			if (sheetObj.ColSaveName(Col) == "acct_cd") {
 				
        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "acct_cd", Row);

 			}
 			
 		}
    
	/**
	 * Account Code 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setAccountCode(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][3];
	}

	/* 개발자 작업  끝 */