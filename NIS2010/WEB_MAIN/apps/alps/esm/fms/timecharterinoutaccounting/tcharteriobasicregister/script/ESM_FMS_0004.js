/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0004.js
*@FileTitle : Vendor Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.15 윤세영
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
     * @class Vendor Code : Vendor Code 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0004() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
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
					doActionIBSheet(sheetObject,formObject,IBSAVE);
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
					sheetObject.Cellvalue(row, "flet_ownr_tp_cd") = '';
					sheetObject.SelectCell(row, "vndr_seq");
					
                break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert();
					sheetObject.Cellvalue(row, "flet_ownr_tp_cd") = '';
					sheetObject.SelectCell(row, "vndr_seq");
					
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

        //html컨트롤 이벤트초기화
        initControl();
    }
     

    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "flet_ownr_tp_cd");
		
		sheetObj.WaitImageVisible = true;   
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

        axon_event.addListener  ('keypress', 'obj_keypress' , 'vndr_seq');			//- Vendor Code 입력 시 숫자만 입력하기

        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "flet_ownr_tp_cd");
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
					InitColumnInfo(12, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					//var HeadTitle = "|Sel|Seq|Vendor Code|Chartering Company Name|Head Ownership Name|Head Ownership Name|Owner Type|Korea Tax Required";
					var HeadTitle = "|Sel|Seq|Vendor Code|Chartering Company Name|Head Ownership Name|Head Ownership Name|Owner Type|Customer Code|Customer Code|Chartered Company Name|Korea Tax Required";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	 40,    daCenter,   false,   "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,    		 40,    daCenter,  	true,    "Seq");
					InitDataProperty(0, cnt++ , dtPopupEdit,   	 105,   daCenter,  	false,   "vndr_seq",   					true,          "",      dfUserFormat,   	0,     false,       true, 6);
					InitDataProperty(0, cnt++ , dtData,   		 315,   daLeft,  	false,   "vndr_lgl_eng_nm",     		false,          "",     dfNone,      		0,     false,       false);

	                InitDataProperty(0, cnt++ , dtHidden,  		 0,    	daCenter,  	true,    "flet_mgmt_ownr_vndr_seq");
					InitDataProperty(0, cnt++ , dtPopup,   		 240,   daLeft,  	false,   "ownr_nm",  					true,          "",      dfNone,  			0,     true,       	true);
					InitDataProperty(0, cnt++ , dtCombo,   		 85,   	daCenter,  	false,   "flet_ownr_tp_cd",     		false,          "",     dfNone,  			0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtData,   		 40,    daCenter,  	true,   "cust_cnt_cd",     		        false,          "",     dfEngUpKey,      	0,     true,       true, 2);
					InitDataProperty(0, cnt++ , dtPopupEdit,   	 80,    daCenter,  	true,   "cust_seq",   					false,          "",      dfUserFormat,   	0,     true,       true, 6);
					InitDataProperty(0, cnt++ , dtData,   		 290,   daLeft,  	false,   "cust_lgl_eng_nm",     		false,          "",     dfNone,      		0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtData,   		 90,    daCenter,  	false,   "tax_required",     	 		false,          "",     dfNone,     		0,     false,       false);
				
					ShowButtonImage = 2;										
 										
					InitUserFormat(0, "vndr_seq", "######", "" );
					InitUserFormat(0, "cust_seq", "######", "" );
					
    				SelectBackColor = RgbColor(219,245,219);
    				
    				SelectionMode = smSelectionRow;
					
					DataLinkMouse("vndr_seq") = true;
					DataLinkMouse("ownr_nm") = true;
					DataLinkMouse("cust_seq") = true;

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
        	   	sheetObj.DoSearch("ESM_FMS_0004GS.do", FormQueryString(formObj));
        	   
                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0004GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //조회	

				if (Col == "flet_ownr_tp_cd") {//Owner Type
					
					formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0006GS.do" , FormQueryString(formObj));
		
		   			var comboCode = ComGetEtcData(sXml, "comboCode");
		   			var comboText = ComGetEtcData(sXml, "comboText");

		   			if(typeof comboCode == "undefined") {
		   				
	    				comboCode = "";
	    				comboText = "";

	    			}

	    			setMakeCombo(sheetObj, comboText, comboCode, Col);

				} else if (Col == "cust_seq") {//Vendor/Customer code 직접 입력시

					formObj.f_cmd.value = SEARCH01;
					
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0070GS.do" , FormQueryString(formObj)+"&cond_flag=CM&cd_cnt="+sheetObj.CellValue(Row,"cust_cnt_cd")+"&cd_seq="+sheetObj.CellValue(Row,Col));
		
	    			setVendorCustomerName(sheetObj, sXml, Row, Col);

				}  else if (Col == "vndr_seq") {//Vendor/Customer code 직접 입력시

					formObj.f_cmd.value = SEARCH01;
					
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0070GS.do" , FormQueryString(formObj)+"&cond_flag=VM&cd_cnt=&cd_seq="+sheetObj.CellValue(Row,Col));
		
	    			setVendorName(sheetObj, sXml, Row, Col);

				}		

        }
    }

    
    /**
     * Type Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  comboCode   Type 의 코드값
     * @param {int}  	col   		column index
     **/
    function setMakeCombo(sheetObj, comboText, comboCode, Col) {
    	if(comboText != "" ) {
    		var typeText = comboText.substring(0,comboText.length-1);
    		var typeCode = comboCode.substring(0,comboCode.length-1);
        	
        	sheetObj.InitDataCombo(0, Col, typeText, typeCode);
    	}
    }
    
    /**
     * Customer 정보를 세팅한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  comboCode   Type 의 코드값
     * @param {int}  	col   		column index
     **/
    function setVendorCustomerName(sheetObj, sXml, Row, Col) {
    	if (sXml != "" ) {
			if (ComGetEtcData(sXml, "cdName") != undefined) {
				
				sheetObj.CellValue(Row,"cust_lgl_eng_nm") = ComGetEtcData(sXml, "cdName");

	    	} else {
				
				sheetObj.CellValue2(Row,"cust_seq") = '';
				sheetObj.CellValue2(Row,"cust_lgl_eng_nm") = '';
				ComShowCodeMessage('FMS01335');
				sheetObj.SelectCell(Row, Col);
	    	}
	    }		
    }
	   
    /**
     * Vendor 정보를 세팅한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  comboCode   Type 의 코드값
     * @param {int}  	col   		column index
     **/
    function setVendorName(sheetObj, sXml, Row, Col) {
    	if (sXml != "" ) {
			if (ComGetEtcData(sXml, "cdName") != undefined) {
				
				sheetObj.CellValue(Row,"vndr_lgl_eng_nm") = ComGetEtcData(sXml, "cdName");
				
				if (ComGetEtcData(sXml, "cdCnt") == 'KR') {
					sheetObj.CellValue2(Row,"tax_required") = 'Mandatory';
				} else {
					sheetObj.CellValue(Row,"tax_required") = '';
				}	

	    	} else {
				
				sheetObj.CellValue2(Row,"vndr_seq") = '';
				sheetObj.CellValue2(Row,"vndr_lgl_eng_nm") = '';
				sheetObj.CellValue2(Row,"tax_required") = '';
				ComShowCodeMessage('FMS01334');
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
			if (sheetObj.ColSaveName(Col) == "cust_seq") {														
				ComOpenPopup("ESM_FMS_0070.do?condFlag=CP", 520, 432, "setCustomrCode", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0070");													
			} else if (sheetObj.ColSaveName(Col) == "ownr_nm") {														
				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setOwnerName", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0083");													
			} else if (sheetObj.ColSaveName(Col) == "vndr_seq") {														
				ComOpenPopup("ESM_FMS_0070.do?condFlag=VP", 520, 432, "setVendorCode", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0070");													
			}														
																	
		}
 	

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value)																
		{															
																
			if (sheetObj.ColSaveName(Col) == "vndr_seq") {														
																	
				sheetObj.CellValue(Row,"vndr_lgl_eng_nm") = '';													
				sheetObj.CellValue(Row,"tax_required") = '';													
	    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vndr_seq", Row);															
																
			}														
																	
			if (sheetObj.ColSaveName(Col) == "cust_cnt_cd" || sheetObj.ColSaveName(Col) == "cust_seq") {														
																	
				if (sheetObj.CellValue(Row,"cust_cnt_cd") != '' && sheetObj.CellValue(Row,"cust_seq") != '') {													
					sheetObj.CellValue(Row,"cust_lgl_eng_nm") = '';
	        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "cust_seq", Row);														
				}													
																
			}														
																	
		}
 	
	/**
	 * Vendor Code 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVendorCode(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][5];
		sheetObjects[0].CellValue2(Row,"vndr_lgl_eng_nm") = aryPopupData[0][3];
		if (aryPopupData[0][4] == 'KR') {
			sheetObjects[0].CellValue2(Row,"tax_required") = 'Mandatory';
		} else {
			sheetObjects[0].CellValue2(Row,"tax_required") = '';
		}	
	}

	/**																
	 * Customr Code 입력부분.<br>																
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx																
	 */																
	function setCustomrCode(aryPopupData, Row, Col, sheetIdx){																
		sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][5];															
		sheetObjects[0].CellValue2(Row,"cust_lgl_eng_nm") = aryPopupData[0][3];															
		sheetObjects[0].CellValue2(Row,"cust_cnt_cd") = aryPopupData[0][4];	
	}
    
	/**
	 * Owner Name 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setOwnerName(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][4];
		sheetObjects[0].CellValue2(Row,"flet_mgmt_ownr_vndr_seq") = aryPopupData[0][3];
		sheetObjects[0].CellValue2(Row,"flet_ownr_tp_cd") = aryPopupData[0][5];
	}

	/* 개발자 작업  끝 */