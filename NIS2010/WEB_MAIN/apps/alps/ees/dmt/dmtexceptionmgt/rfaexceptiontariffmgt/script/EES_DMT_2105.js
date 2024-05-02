/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2105.js
*@FileTitle : DAR History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.24 이성훈
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
     * @class DEM/DET Adjustment Request - After Booking Request 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2105() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
	// 공통전역변수
	var sheetObjects 	= new Array();
	var sheetCnt 		= 0;
	

	var RFA_NO 			= "rfa_no";
	var APRO_OFC 		= "apro_ofc_cd";
	var DAR_NO 			= "rfa_expt_dar_no";
	var MAPG_SEQ 		= "rfa_expt_mapg_seq";
	var VER_SEQ 		= "rfa_expt_ver_seq";
	var APRO_NO 		= "rfa_expt_apro_no";
	var STATUS 			= "dmdt_expt_rqst_sts_desc";
	var REQ_OFC 		= "req_ofc_cd";
	var REQ_USR_NM 		= "req_usr_nm";
	var REQ_DT 			= "req_dt";
	var APVL_OFC 		= "apvl_ofc_cd";
	var APVL_USR_NM 	= "apvl_usr_nm";
	var APVL_DT 		= "apvl_dt";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick 	= processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
				case "btn_Copy":
					doActionCopy();
					break;
	
				case "btn_Close":
					doActionClose();
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
    	var formObj = document.form;
    	
        for (i = 0 ; i < sheetObjects.length ; i++) {

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
		//화면 Load 시 특정필드들을 비활성화 시킨다.
		initDisableControls();
        
        //Copy 버튼의 초기화(2003 번 화면의 Status 가 Empty 이거나  Temp.Saved 일 경우에만  활성화가 된다.)
		if (ComGetObjValue(formObj.is_copy) == "Y")
        	ComBtnEnable("btn_Copy");
        else
        	ComBtnDisable("btn_Copy");        
        
        doActionRetrieve();        
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 262;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Sel.|RFA No.|APVL\nOffice|DAR No.|Ver.|Approval No.|Status|Request Office|Request Office|Request Office|Approval Office|Approval Office|Approval Office";
					var HeadTitle2 = "|Seq.|Sel.|RFA No.|APVL\nOffice|DAR No.|Ver.|Approval No.|Status|Office|Name|Date|Office|Name|Date";
					var headCount = ComCountHeadTitle(HeadTitle1) + 1;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    	daCenter,  		true,     		"Status");
                    InitDataProperty(0, cnt++ , dtSeq,    		 30,    	daCenter,  		true,     		"Seq");
                    InitDataProperty(0, cnt++ , dtRadioCheck,    30,		daCenter,		true,	  		"SEL",					false,		"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,		true,			RFA_NO,					false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,		true,			APRO_OFC,				false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			110,		daCenter,		true,			DAR_NO,					false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			 30,		daCenter,		true,			VER_SEQ,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			110,		daCenter,		true,			APRO_NO,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,		daCenter,		true,			STATUS,					false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,		true,			REQ_OFC,				false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			125,		daLeft,			true,			REQ_USR_NM,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			 65,		daCenter,		true,			REQ_DT,					false,		"",		dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,		true,			APVL_OFC,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			125,		daLeft,			true,			APVL_USR_NM,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			 65,		daCenter,		true,			APVL_DT,				false,		"",		dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  	      0,		daCenter,		true,			MAPG_SEQ,				false,		"",		dfNone,			0,	false,	false);
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(REQ_OFC);
					
					CountPosition = 0;
            	}
                break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
	        	//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        		with(formObj) {
        			if (searchType[0].checked == true) {
        				ComSetObjValue(f_cmd, 	SEARCH);	
        			}
        			else {
        				ComSetObjValue(f_cmd, 	SEARCH01);
        			}
        			ComSetObjValue(rfa_no, 	ComGetObjValue(rFANo));
        			ComSetObjValue(cust_cd, ComGetObjValue(custCd));
     			}
        	
        		//2.조회수행전 그리드에 기존에 조회된  결과가 있다면 지워준다.
        		sheetObj.RemoveAll();
        	
        		//2.조회조건으로 조회실행
        		//*********************************************************************************
        		ComOpenWait(true);
        		sheetObj.WaitImageVisible = false;
        		//*********************************************************************************
        		
				sheetObj.DoSearch("EES_DMT_2105GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				break;
        }
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
       with(formObj){
       }

       return true;
    }
    
 	/**
	 * DAR 에 등록된 데이터 조회하는 동작을 정의하는 함수
	 */	     
    function doActionRetrieve() {
   	    var formObj 	= document.form;
   	    var sheetObj 	= sheetObjects[0];
   	
   	    doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }   
    
   	/**
   	 * DAR History 중 선택된 항목을 복사하는 동작을 정의하는 함수
   	 */	     
     function doActionCopy() {
    	var formObj 	= document.form;   		 
     	var sheetObj 	= sheetObjects[0];
     	var opener 		= window.dialogArguments;

     	//APVL OFC 가 선택되지 않았다면 알림창을 띄운다.
     	if (ComTrim(opener.document.form.approvalOfcCd.value) == "") {
     		ComShowCodeMessage("DMT00140", "APVL OFC");
     		return;
     	}
     	
     	//Row 미선택후 copy 클릭시 "Pls select one row" Alert창 띄워 알림
     	with(sheetObj) {
     		var checkCnt = 0;
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (CellValue(row, "SEL") == 1) {
     				checkCnt++;
     			}
     		}
     	}
     	if (checkCnt == 0) {
     		ComShowCodeMessage("DMT00178");
     		return;
     	}
     	
    	//2003 화면에 Data가 있을 경우에만 Alert창 추가
    	if (ComParseInt(ComGetObjValue(formObj.rowcount)) > 0) {
    		if (!ComShowCodeConfirm("DMT00177")) return;
    	}
    	
     	with(sheetObj) {
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (CellValue(row, "SEL") == 1) {
     				
     				var paramsArray = new Array();
     				paramsArray[0] = CellValue(row, DAR_NO);
     				paramsArray[1] = CellValue(row, MAPG_SEQ);
     				paramsArray[2] = CellValue(row, VER_SEQ);
     				
    				//Copy시 화면상에 조회된 Proposal No., Version과 동일할 경우 Copy 하지 못하도록 막는다.
    				if (	paramsArray[0] == ComGetObjValue(formObj.dar_no) 
    					&& 	paramsArray[2] == ComGetObjValue(formObj.ver_seq)	) {
    					
    					ComShowCodeMessage("DMT01121");
    					return;
    				}
     				
     				opener.copyDARHistory(paramsArray);
     				window.close();
     			}
     		}
     	}
 	} 	
      
  	/**
  	 * DAR History 팝업화면을 닫는 동작을 정의하는 함수
  	 */	     
     function doActionClose() {
    	 window.close();
     }
  	 
   	/**
   	 * 화면 Load 시 특정컨트롤들을 비활성화 함수
   	 */	
  	 function initDisableControls(flag) {
  		 var formObj = document.form;
  		 
		 with(formObj) {
			 ComEnableManyObjects(false, rFANo, custCd, custNm);
			 
			 rFANo.className 	= "input2";
			 custCd.className 	= "input2";
			 custNm.className 	= "input2";
		 }
  	 }