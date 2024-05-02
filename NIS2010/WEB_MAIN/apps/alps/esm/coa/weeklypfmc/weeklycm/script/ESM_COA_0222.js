/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_COA_0222.jsp
*@FileTitle : DEL Credit Ratio by Port-Pair(Backhaul Promotion Target Route)
*Open Issues :
*Change history : 2014.07.29 백형인 최초 생성
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================
* History
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
	 * @class ESM_COA_0016 : ESM_COA_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_COA_0222() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.sheet1_OnClick         = sheet1_OnClick;
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet2_OnSearchEnd     = sheet2_OnSearchEnd();
		this.doActionIBSheet 		= doActionIBSheet;
		this.openWindowCredit   	= openWindowCredit;
		this.openWindowFromECC   	= openWindowFromECC;
		this.setCheckBoxRow     	= setCheckBoxRow;
	  	this.changeRcc      	    = changeRcc;
	  	this.changeLcc      	    = changeLcc;
	    this.setPeriod              = setPeriod;	  	
	}

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var excel_load_yn ="N";
/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

	/*
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
  function processButtonClick(){
         /*
         	**** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****
         	*/
         var sheetObject = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];


         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_DownExcel":
        	        doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
        	        break;
        	        

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
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
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

        loadingMode = false;
		ComSetFocus(document.form.f_cost_yrmon);
		
		initControl();
    }

    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 CATCH 한다. <br>
     */
    function initControl() {
        //Axon 이벤트 처리1. 이벤트 catch
        axon_event.addListenerForm('blur', 'obj_blur', form); 
        axon_event.addListenerForm('focus', 'obj_focus', form);
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
				//sheet1 init
				with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(20) ;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]				
				MergeSheet = msPrevColumnMerge; //msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;				
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 10, 100);										
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);					
				var HeadTitle  = "cnt_cd|Country|POR ECC|D2|D4|D5" ;
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);									

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,  0,      daCenter,  true,    "cnt_cd",         false, 		"", 	  dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    150,    daLeft,    true,    "cnt_nm",         false, 		"", 	  dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    80,	   daCenter,  true,    "por_ecc_cd",     false, 		"", 	  dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    70,     daCenter,  true,    "tpsz_d2",        false,         "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    70,     daCenter,  true,    "tpsz_d4",        false,         "",       dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    70,     daCenter,  true,    "tpsz_d5",        false,         "",       dfNone,       	0,     false,      false);

//				InitDataCombo(0, "cntr_org_dest_cd", "OP|DEL", "O|D");
//				
//				CellBackColor(1,"imbal_amt") = RgbColor(222, 251, 248);   // ENIS
//				CellBackColor(1,"mb_amt") = CellBackColor(1,"imbal_amt") ;
//				CellBackColor(1,"eq_repo_cr_rto") = CellBackColor(1,"imbal_amt") ;
//				InitDataValid(0, "ecc_cd", vtEngUpOnly);	//대문자만
				CountPosition  = 0 ;

				
				}
				break;
			case 2:
				//sheet2 init
				with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(20) ;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]				
				MergeSheet = msPrevColumnMerge; //msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;				
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 10, 100);										
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);					
				var HeadTitle  = "cnt_cd|Country|DEL ECC|D2|D4|D5" ;
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);									

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,  0,      daCenter,  true,    "cnt_cd",         false, 		"", 	  dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    150,    daLeft,    true,    "cnt_nm",         false, 		"", 	  dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    80,	   daCenter,  true,    "del_ecc_cd",     false, 		"", 	  dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    70,     daCenter,  true,    "tpsz_d2",        false,         "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    70,     daCenter,  true,    "tpsz_d4",        false,         "",       dfNone,    		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,    70,     daCenter,  true,    "tpsz_d5",        false,         "",       dfNone,       	0,     false,      false);

//				InitDataCombo(0, "cntr_org_dest_cd", "OP|DEL", "O|D");
//				
//				CellBackColor(1,"imbal_amt") = RgbColor(222, 251, 248);   // ENIS
//				CellBackColor(1,"mb_amt") = CellBackColor(1,"imbal_amt") ;
//				CellBackColor(1,"eq_repo_cr_rto") = CellBackColor(1,"imbal_amt") ;
//				InitDataValid(0, "ecc_cd", vtEngUpOnly);	//대문자만
				CountPosition  = 0 ;

				}
				break;
        }
    }


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:          //조회

				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
    			// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			formObj.f_cmd.value = SEARCH;
//    			sheetObj.DoSearch4Post("ESM_COA_0222GS.do", coaFormQueryString(formObj));
                var sXml = sheetObj.GetSearchXml("ESM_COA_0222GS.do" , FormQueryString(formObj));
                
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
                if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);     			
    			ComOpenWait(false);
				break;


			case IBDOWNEXCEL:        //엑셀 다운로드
				var excelType = selectDownExcelMethod(sheetObjects[0]);
				switch (excelType) {
					case "AY":
						sheetObjects[0].Down2Excel(0, false, false, true);
						sheetObjects[1].Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObjects[0].Down2Excel(-1, false, false, true);
						sheetObjects[1].Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObjects[0].SpeedDown2Excel(0, false, false);
						sheetObjects[1].SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObjects[0].SpeedDown2Excel(-1, false, false);
						sheetObjects[1].SpeedDown2Excel(-1, false, false);
						break;
				}

				break;
			
				
		}
	}
	
 	/**
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * format 및 validation 확인 <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 원종규
     * @version 2012.11.12
     */
  	function obj_blur() { 
   	  
  	 switch(event.srcElement.name) { 
  	 
  	 	case "f_cost_yrmon":
  	    	document.form.cost_yrmon.value=event.srcElement.value;  
	   		if(!ComAddSeparator(event.srcElement)) return false;   		
	   		setPeriod(event.srcElement);	   		
	   		break;	
  	 }   	 
  	}
     
	/**
  * OnFocus 이벤트 발생시 호출되는 function <br>
  * <br><b>Example :</b>
  * <pre>
  *	
  * </pre>
  * @return 없음
  * @author 원종규
  * @version 2012.11.12
  */
	function obj_focus() {
		
		switch(event.srcElement.name) {
		
			case "f_cost_yrmon":
		   		ComClearSeparator(event.srcElement,'','-');  
		   		event.srcElement.select();
		   		break;
		   		
		} 
	}      	
	
	function fnClick(){}

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
        ComCoaSetPeriod2(obj);
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  
        	if (f_cost_yrmon.value == ""){
    			ComShowCodeMessage("COM12114", "Year Month")
    			f_cost_yrmon.focus();
    			return false;
        	}
        	
            if(!ComChkObjValid(f_cost_yrmon, null, null, "ym")) {
            	return false;
            }
        }

        return true;
    }

	



