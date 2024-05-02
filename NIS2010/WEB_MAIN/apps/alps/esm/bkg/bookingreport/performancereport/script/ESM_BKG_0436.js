/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0436.js
*@FileTitle : Search Doc. User
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2011.12.01 금병주
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
     * @class esm_bkg_0436 : esm_bkg_0436 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0436() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick		= sheet1_OnDblClick;
    	this.sheet1_OnClick			= sheet1_OnClick;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var rowsPerPage = 50;

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
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
 				case "btn_select":
 					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
 					break
 				case "btn_close":
 					window.close();
 					break;
 				
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
      	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
      }
      
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 var formObject = document.form;
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
 						MergeSheet = msPrevColumnMerge;
 						
 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = true;
 						
 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 7, rowsPerPage);
 						
 						var HeadTitle = "Sel|Doc ID|Name|Doc Group|Doc Position|Doc Part";
 						var headCount = ComCountHeadTitle(HeadTitle);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);
 						
 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);
 						
 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle, false);
 						
 						//데이터속성    [ROW, 		COL,  	DATATYPE,   		WIDTH, DATAALIGN, 	COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0,		cnt++ , dtRadioCheck,	  	40,		daCenter,	false,	"sel");                      
 						InitDataProperty(0,		cnt++ , dtData,				100,	daCenter,	false,	"usr_id",			true,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtData,				120,	daCenter,	false,	"usr_nm",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtCombo,			100,	daCenter,	false,	"dpcs_wrk_grp_cd",	false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtCombo,			100,	daCenter,	false,	"dpcs_psn_cd",		false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtCombo,			70,		daCenter,	false,	"dpcs_wrk_prt_cd",	false,		"",		dfNone,			0,		false,		false);
 						 
 						CountPosition = 0; 
 				}
 				break;


 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
	   
	   sheetObj.ShowDebugMsg = false;
	   switch(sAction) {
		   case IBCLEAR: // 화면 로딩시 코드 조회
		   		formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0436GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				if(arrXml.length > 3){
					ComXml2ComboItem(arrXml[3], formObj.rgn_ofc_cd, "val", "name");
					formObj.rgn_ofc_cd.InsertItem(0, 'All',' ');
					formObj.rgn_ofc_cd.Code = ComGetObjValue(formObj.ui_rgn_ofc_cd);
				}
				
				if (arrXml.length > 2){
					ComXml2ComboItem(arrXml[2], formObj.dpcs_wrk_grp_cd, "val", "name");
					formObj.dpcs_wrk_grp_cd.InsertItem(0, 'All',' ');
					formObj.dpcs_wrk_grp_cd.Code = ComGetObjValue(formObj.ui_grp_cd);
				}
				
				if (arrXml.length > 2) 
					setIBCombo(sheetObj, arrXml[2], "dpcs_wrk_grp_cd", true, "", "","",0);
				if (arrXml.length > 1) 
					setIBCombo(sheetObj, arrXml[1], "dpcs_wrk_prt_cd", true, "", "","",0);
				if (arrXml.length > 0) 
					setIBCombo(sheetObj, arrXml[0], "dpcs_psn_cd", true	, "", "","",0);
				 
				sheetObj.DataAutoTrim = true;
				break;
	       case IBSEARCH: // Doc. User 조회
	       		formObj.f_cmd.value = SEARCH; 
         	 	sheetObj.DoSearch("ESM_BKG_0436GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
         	 	break;
         	 
	       case COMMAND01:
	    	   	if(validateForm(sheetObj,formObj,sAction)){
	    	   		doSave(sheetObj,formObj,opener.form.change_usr_id)
	    	   		window.close();
	    	   	}
	    	   	break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {
	  		case COMMAND01:
	  			var checkedRows = sheetObj.FindCheckedRow("sel");
	  			var arrRow = checkedRows.split("|");
	  			var selectRow = arrRow[0];
	  			if(selectRow == ''){
	  				ComShowCodeMessage('BKG08040');
	  				return false;
	  			}
	  	 	}
          return true;
     }
      
      function doSave(sheetObj,formObj,sTarget){
    	  var checkedRows = sheetObj.FindCheckedRow("sel");
    	  var arrRow = checkedRows.split("|");
    	  var selectRow = arrRow[0];
		
    	  sTarget.value = sheetObj.CellValue(selectRow, "usr_id");
      }
      
      
      function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
    	  var formObj = document.form;
    	  doSave(sheetObj,formObj,opener.form.change_usr_id);
    	  window.close();		
      }	
      
      function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
			sheetObj.CellValue(rowIdx, "sel") = 1;
      }	   
	/* 개발자 작업  끝 */