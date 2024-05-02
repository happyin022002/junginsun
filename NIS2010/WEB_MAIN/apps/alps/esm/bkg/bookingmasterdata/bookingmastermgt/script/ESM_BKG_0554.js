/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0554.js
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.20 김기종
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
     * @class esm_bkg_0554 : esm_bkg_0554 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0554() {
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
            switch(srcName) {
		            case "btn_retrieve":
		            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
    				case "btn_save":
    					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;
    				case "btn_new":
    					sheetObjects[0].RemoveAll();
    					ComResetAll();
    					ComSetObjValue(formObject.ibflag,"I");
					break;	
					case "btn_del":
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;	
					case "btn_inquiry":
						//Country Code(1번)값을 가지고 UI_BKG-0345로 이동 버튼
						//document.location.href = "nis2010Main.screen?pgmNo=" + pgmNo;
						//ComOpenWindow2("ESM_BKG_0345.do?pgmNo=ESM_BKG_0345&cnt_cd="+formObject.cnt_cd.value,"ESM_BKG_0345", "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=1024,height=520");
					    
						document.location.href = "/hanjin/ESM_BKG_0345.do?pgmNo=ESM_BKG_0345&cnt_cd="+formObject.cnt_cd.value;
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

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
    	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	
    	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    function initSheet(sheetObj,sheetNo) {
   	 var cnt = 0;
       switch(sheetNo) {
           case 1:   //sheet1 init
               with (sheetObj) {
                   //Host정보 설정[필수][HostIp, Port, PagePath]
                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
                   
                   // 높이 설정
                   style.height = 0;
                   
	                //전체Merge 종류 [선택, Default msNone]
	       			MergeSheet = msNone;
	
	       			//전체Edit 허용 여부 [선택, Default false]
	       			Editable = true;
	       			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	       			InitRowInfo(1, 1, 15, 100);
	       			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	       			InitColumnInfo(11, 0, 0, true);
	
	       			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	       			InitHeadMode(true, true, false, true, false, false)
	       			var HeadTitle1 = " |";
	
	       			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	       			InitHeadRow(0, HeadTitle1, true);
	       			/*
	       			cnt_cd		varchar2(2)		n	국가별 Code 두자리		
	       			wh_cd		varchar2(5)		n	보세구역(창고)의 등록 코드	
	       			wh_nm		varchar2(500)	y	보세구역(창고)의 이름	
	       			wh_addr		varchar2(500)	y	보세구역(창고)의 주소	
	       			loc_cd		varchar2(5)		y	보세구역(창고)의 장소 Code(5자리)와 장소명	
	       			cstms_cd	varchar2(10)	y	보세구역 설령 특허 번호(세관에서 승인을 준 번호)	
	       			phn_no		varchar2(20)	y	보세구역(창고)의 전화번호	
	       			fax_no		varchar2(20)	y	보세구역(창고)의 Fax 번호	
	       			pson_nm		varchar2(50)	y	보세구역(창고)의 담당자		
	       			diff_rmk	varchar2(4000)	y	특이사항 기록 컬럼
	       			*/
	       			
	       			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	       			InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "ibflag");
	   				InitDataProperty(0, cnt++ , dtSeq,         40,    daCenter,  false,   "Seq");
	   				
               }
               break;
       }
   }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

    		case IBSEARCH:      //조회
    			if(validateSearchForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					var SaveXml=sheetObj.DoSearch("ESM_BKG_0554GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam(""));
    			}
                break;
                
    		case IBDELETE:       //삭제
    			if(validateForm(sheetObj,formObj,sAction)) {
    				
    				if (ComShowCodeConfirm("BKG00535") == false) return;
    				
    				formObj.f_cmd.value = MULTI;
    				//행 삭제 FLAG처리
					sheetObj.CellValue2(1, "ibflag") = "D";
					ComSetObjValue(formObj.ibflag,"D");
    				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0554GS.do", FormQueryString(formObj));
    				sheetObj.LoadSaveXml(SaveXml);
    			}
                break;    
    		case IBSAVE:        //저장
    			if(validateForm(sheetObj,formObj,sAction)) {
    				formObj.f_cmd.value = MULTI;
    				
    				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0554GS.do", FormQueryString(formObj));
    				sheetObj.LoadSaveXml(SaveXml);
    			}
                break;
    		case IBRESET:      //location 조회
    			
    			formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0554GS.do", FormQueryString(formObj));
				
				if (ComGetEtcData(sXml,"loc_nm") == undefined){
					
					ComShowCodeMessage('BKG00061',formObj.loc_cd.value);
					formObj.loc_cd.value="";
					formObj.loc_nm.value="";
					formObj.loc_cd.focus();
				}else{
					formObj.loc_nm.value= ComGetEtcData(sXml,"loc_nm");
        		}
    			
				break;
                
        }
    }
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	var cnt_cd  = formObj.cnt_cd.value;
    	var wh_cd  = formObj.wh_cd.value;
    	
	 	 if (ErrMsg == "") {
	 		if (ComGetObjValue(formObj.ibflag) == "D"){
	 			ComShowCodeMessage('BKG00593');
	 			ComSetObjValue(formObj.ibflag,"I");
	 			ComResetAll();
	 			formObj.cnt_cd.value	=	cnt_cd;
				formObj.wh_cd.value		=	wh_cd;
	 		}else{
	 			sheetObj.CellValue2(1, "ibflag") = "U";
	 			ComSetObjValue(formObj.ibflag,"U");
	 			ComBkgSaveCompleted();  //서버메세지 처리
	 		}
	 		
 	 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		 } 	 	
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	var cnt_cd  = formObj.cnt_cd.value;
    	var wh_cd  = formObj.wh_cd.value;
		with (sheetObj) {
			
			if (RowCount("R") == 0){
				sheetObj.RemoveEtcData();
				sheetObj.CellValue2(1, "ibflag") = "I";
				IBS_EtcDataToForm(formObj, sheetObj);
				ComSetObjValue(formObj.ibflag,"I");
				formObj.cnt_cd.value	=	cnt_cd;
				formObj.wh_cd.value		=	wh_cd;
				ComShowCodeMessage('BKG00095');
			}else{
				sheetObj.CellValue2(1, "ibflag") = "U";
				IBS_EtcDataToForm(formObj, sheetObj);
				ComSetObjValue(formObj.ibflag,"U");
			}
		}
	}
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateSearchForm(sheetObj, formObj,sAction){
    	if (formObj.cnt_cd.value == ""){
    		ComShowCodeMessage('BKG00626', 'Country Code');
    		formObj.cnt_cd.focus();
    		return false;
    	}
    	if (formObj.wh_cd.value == ""){
    		ComShowCodeMessage('BKG00626', 'Warehouse Abbr. Code');
    		formObj.wh_cd.focus();
    		return false;
    	}
        return true;
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj,sAction){
    	if (!ComChkValid(formObj)) return false;
        return true;
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
     **/
    function obj_deactivate() {
    	var formObj = document.form;
    	switch (event.srcElement.getAttribute("name")) {
    	case "loc_cd":
    		if (event.srcElement.value != ''){
    			doActionIBSheet(sheetObjects[0],document.form,IBRESET);
    		}else{
    			formObj.loc_nm.value= "";
    		}
    		break;
    	
    	default:
    		break;
    	}
    }
	/* 개발자 작업  끝 */