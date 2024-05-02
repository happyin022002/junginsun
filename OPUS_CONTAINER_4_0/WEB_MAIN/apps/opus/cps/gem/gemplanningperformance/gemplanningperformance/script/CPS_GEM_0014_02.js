/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : cps_gem_0014_02.js
*@FileTitle : [CPS_GEM-0014_02] Request Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.23 박창준
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
     * @author CLT
     */

    /**
     * @extends 
     * @class cps_gem_0014_02 : cps_gem_0014_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function cps_gem_0014_02() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	this.sheet1_OnClick = sheet1_OnClick;
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
 				case "btn1_Close":
 					window.close();
 					break;
 				case "btn1_DownExcel":
 					if (sheet1.RowCount <= 0 ) {
 						// 조회된 건수가 없습니다.
 						ComCodeMsgByNoRelatedData();
 						return;
 					} else {
 						var skiprow = "";
 						for(var i = 6 ; i <= sheet1.LastRow; i+=6)
 							skiprow += i+"|";
 						sheet1.Down2Excel(1,false,false,true,"","apps/opus/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0014_02.xml",false,false,"Request Information",false,"",skiprow);
 					}
 					break;
 				case "btn1_Retrieve":
 					doActionIBSheet(IBSEARCH);
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
    	 
    	 frm = document.form;
    	 sheet1 = sheetObjects[0];
    	 
         for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
         }	

         // 초기Data조회
 		 doActionIBSheet(IBSEARCH);
         
     }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 350;
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 6, 15, 100);

 					var HeadTitle1 = " |RQST NO|From (INI & ADD, TRS)|From (INI & ADD, TRS)|From (INI & ADD, TRS)|From (INI & ADD, TRS)|TO(TRS)|TO(TRS)|TO(TRS)|TO(TRS)";
 					
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     

                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					//InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"hdnStatus");
 					
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");
 					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		true,		"gen_expn_rqst_no",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,			true,		"field_one",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		"fm_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"field_two",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"fm_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,			true,		"field_tree",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		"to_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"field_four",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"to_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					
 					cnt = 0;
 					InitDataProperty(1, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");
 					InitDataProperty(1, cnt++ , dtData,			130,	daCenter,		true,		"gen_expn_rqst_no",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			80,		daLeft,			true,		"field_one",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			70,		daCenter,		true,		"fm_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			80,		daCenter,		true,		"field_two",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			80,		daCenter,		true,		"fm_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			80,		daLeft,			true,		"field_tree",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			70,		daCenter,		true,		"to_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			80,		daCenter,		true,		"field_four",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(1, cnt++ , dtData,			80,		daCenter,		true,		"to_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					
 					cnt = 0;
 					InitDataProperty(2, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");
 					InitDataProperty(2, cnt++ , dtData,			130,	daCenter,		true,		"gen_expn_rqst_no",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			80,		daLeft,			true,		"field_one",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			70,		daCenter,		true,		"fm_ofc_cd", 			false,		"",			dfNullInteger,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			80,		daCenter,		true,		"field_two",			false,		"",			dfNullInteger,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			80,		daCenter,		true,		"fm_gen_expn_cd",		false,		"",			dfNullInteger,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			80,		daLeft,			true,		"field_tree",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			70,		daCenter,		true,		"to_ofc_cd", 			false,		"",			dfNullInteger,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			80,		daCenter,		true,		"field_four",			false,		"",			dfNullInteger,		0, false, false);
 					InitDataProperty(2, cnt++ , dtData,			80,		daCenter,		true,		"to_gen_expn_cd",		false,		"",			dfNullInteger,		0, false, false);
 					
 					cnt = 0;
 					InitDataProperty(3, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");
 					InitDataProperty(3, cnt++ , dtData,			130,	daCenter,		true,		"gen_expn_rqst_no",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			80,		daLeft,			true,		"field_one",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			70,		daCenter,		true,		"fm_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			80,		daCenter,		true,		"field_two",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			80,		daCenter,		true,		"fm_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			80,		daLeft,			true,		"field_tree",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			70,		daCenter,		true,		"to_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			80,		daCenter,		true,		"field_four",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(3, cnt++ , dtData,			80,		daCenter,		true,		"to_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					
 					cnt = 0;
 					InitDataProperty(4, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");
 					InitDataProperty(4, cnt++ , dtData,			130,	daCenter,		true,		"gen_expn_rqst_no4",	false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtData,			80,		daLeft,			true,		"field_one4",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtImageText,	70,		daLeft,			true,		"fm_gen_expn_itm_desc", false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtData,			80,		daLeft,			true,		"field_two4",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtData,			80,		daLeft,			true,		"fm_gen_expn_itm_desc1",false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtData,			80,		daLeft,			true,		"field_tree4",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtImageText,	70,		daLeft,			true,		"to_gen_expn_itm_desc", false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtData,			80,		daLeft,			true,		"field_four4",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(4, cnt++ , dtData,			80,		daLeft,			true,		"to_gen_expn_itm_desc1",false,		"",			dfNone,		0, false, false);
 					
 					cnt = 0;
 					InitDataProperty(5, cnt++ , dtHiddenStatus,	0,		daCenter,		true,		"ibflag");
 					InitDataProperty(5, cnt++ , dtImageText,	130,	daCenter,		true,		"gen_expn_rqst_no",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			80,		daLeft,			true,		"field_one",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			70,		daCenter,		true,		"fm_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			80,		daCenter,		true,		"field_two",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			80,		daCenter,		true,		"fm_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			80,		daLeft,			true,		"field_tree",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			70,		daCenter,		true,		"to_ofc_cd", 			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			80,		daCenter,		true,		"field_four",			false,		"",			dfNone,		0, false, false);
 					InitDataProperty(5, cnt++ , dtData,			80,		daCenter,		true,		"to_gen_expn_cd",		false,		"",			dfNone,		0, false, false);
 					
 					SetSortDialog(false);
 					DataRowMerge(0) = true;
    				DataRowMerge(1) = true;
    				DataRowMerge(2) = true;
    				DataRowMerge(3) = true;
    				DataRowMerge(4) = true;
    				DataRowMerge(5) = true;
    				
    				ImageList(0) = "img/btns_inquiry.gif";
    				
 				}
 				break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sAction) {
        // sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 			case IBSEARCH:      //조회
 				
 				frm.f_cmd.value = SEARCH;
				
	  			var sXml = sheet1.GetSearchXml("CPS_GEM_0014_02GS.do", FormQueryString(frm));
      			
      			var arrXml = sXml.split("|$$|");
      			
	  			if (arrXml.length > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  			}
	  			
	  			// Row Color 지정
	  			var preCurrCd = ""; 
	  			var nextCurrCd = "";	  			
	  			var cnt = 1;
	  			var rowdiv = 0;
	  			
	  			for(var i = 1; i<=sheet1.SearchRows ;i++) {

	  				for(var j=1 ; j <= 6; j++) {
  						if (i % 2 == 0) {
  							sheet1.RowBackColor(cnt) = sheet1.RgbColor(235,235,235); 							
  						} else {
  							sheet1.RowBackColor(cnt) = sheet1.RgbColor(255,255,255);
  						}
  						cnt++;
  					}
	  				
				}
	  			
	  			for(var i = 1; i<=sheet1.RowCount ;i++) {
	  				
  					if (i % 6 == 0) {					
  						sheet1.CellImage(i-1,3) = 0;	
  						sheet1.CellImage(i-1,7) = 0;
  					} 
  						
				}

 				break;
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
     
  	//===================================================================================
  	//Sheet 이벤트 처리
  	//===================================================================================
  	/**
  	 * 셀을 클릭했을때 발생하는 이벤트 <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {ibsheet} row     	sheetObj의 선택된 Row
  	 * @param {ibsheet} col     	sheetObj의 선택된 Col
  	 **/
  	function sheet1_OnClick(sheetObj, row, col, value) {
  		if ((row+1) % 6 == 0) {
  	         if (sheetObj.ColSaveName(col) == "fm_ofc_cd" || sheetObj.ColSaveName(col) == "field_two" || sheetObj.ColSaveName(col) == "fm_gen_expn_cd" || sheetObj.ColSaveName(col) == "to_ofc_cd" || sheetObj.ColSaveName(col) == "field_four" || sheetObj.ColSaveName(col) == "to_gen_expn_cd") {	 
  	 			//ComShowMemoPad(sheetObj);
  	        	//ComShowMemoPad(sheetObj, [row=SelectRow], [col=SelectCol], [bReadOnly=false], [iWidth=200], [iHeight=200])
  	 			ComShowMemoPad(sheetObj, null, null, true, 250 );
  	 		}
  		}
  		
  	}

	/* 개발자 작업  끝 */