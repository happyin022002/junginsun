/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0592.js
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.25 김기종
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
     * @class esm_bkg_0592 : esm_bkg_0592 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0592() {
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
          var sheetObject = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;

 				case "btn_New":
 					sheetObject.RemoveAll();
 					ComResetAll();
 					break;
 				
 				case "btn_RowAdd":
 					doActionIBSheet(sheetObject, formObject, IBINSERT);  
 					break;
 					
 				case "btn_Delete":
 					sheetObject.CellValue2(sheetObject.SelectRow, "ibflag") = "D";
 					sheetObject.RowHidden(sheetObject.SelectRow)  = true;
 					
 					//ComRowHideDelete(sheetObject, "del_chk");
 					break;
 				
 				case "btn_Save":
 					//if (sheetObjects[0].IsDataModified ) {
					 var rowM = sheetObjects[0].ColValueDup("usr_id");
					 if (rowM >= 0) {
						 ComShowCodeMessage("BKG00827", "Sheet", rowM);
					     return false;
				    }	    		
 					//}
 					doActionIBSheet(sheetObject, formObject, IBSAVE);  
 					break;
 				case "btn_excel":
 					sheetObject.SpeedDown2Excel();
 					//sheetObject.Down2Excel();
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
         //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
 						style.height = 440;
 						//전체 너비 설정
 						SheetWidth = mainTable.clientWidth;
 						
 						//Host정보 설정[필수][HostIp, Port, PagePath]
 						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 						
 						//전체Merge 종류 [선택, Default msNone]
 						MergeSheet = msPrevColumnMerge;
 						
 						//전체Edit 허용 여부 [선택, Default false]
 						Editable = true;
 						
 						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 						InitRowInfo(1, 1, 3, 100);
 						
 						var HeadTitle = "||Doc ID|Name|Doc Group|Doc Position|Doc Part|Creation Date|Update Date|Update User";
 						var headCount = ComCountHeadTitle(HeadTitle);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);
 						
 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);
 						
 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle, true);
 						
 						//데이터속성    [ROW, 		COL,  	DATATYPE,   		WIDTH, DATAALIGN, 	COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0, 	cnt++ , dtHiddenStatus,		30,		daCenter,	true,	  "ibflag");
 						InitDataProperty(0,		cnt++,	dtHidden  	,		27, 	daCenter,	false,	"del_chk",      false,	"",	dfNone,		0,		true);                    
 						InitDataProperty(0,		cnt++ , dtData,				120,	daCenter,	false,	"usr_id",			true,		"",		dfNone,			0,		false,		true);
 						InitDataProperty(0,		cnt++ , dtData,				120,	daCenter,	false,	"usr_nm",			false,		"",		dfNone,			0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtCombo,			120,	daCenter,	false,	"dpcs_wrk_grp_cd",	true,		"",		dfNone,			0,		true,		true);
 						InitDataProperty(0,		cnt++ , dtCombo,			150,	daCenter,	false,	"dpcs_psn_cd",		true,		"",		dfNone,			0,		true,		true);
 						InitDataProperty(0,		cnt++ , dtCombo,			80,		daCenter,	false,	"dpcs_wrk_prt_cd",	true,		"",		dfNone,			0,		true,		true);
 						InitDataProperty(0,		cnt++ , dtData,				140,	daCenter,	false,	"cre_dt",			false,		"",		dfDateYmd,		0,		false,		true);
 						
 						InitDataProperty(0,		cnt++ , dtData,				140,	daCenter,	false,	"upd_dt",			false,		"",		dfDateYmd,		0,		false,		true);
 						InitDataProperty(0,		cnt++ , dtData,				160,	daCenter,	false,	"upd_usr_id",		false,		"",		dfNone,			0,		false,		true);
 						
 						FocusEditMode = -1;
 						//SelectionMode = smSelectionCol;
 						/*USER WORKING GROUP ==> 'S': Front Office FAX S/R BKG no. Match & Transfer, B/L Issue 담당,  
 												'I' : Doc Center INPUT 담당,  
 												'R' : Doc Center RATE 담당,  
 												'A' : Doc Center AUDIT 담당,  
 												'U' : Super User(ALL 기능담당 가능)*/
 						
 						/*CD01602
 						  USER POSITION ==> 'M': Manager, 
 										  'C' : Clerk 
						  CD01603	
						WORKING PART  ==> 담당 Part(일본지역/서남아지역/구주지역)(JP,PK,NL)
								-->담당 Part Code 일본지역 : JP, 서남아지역 : PK, 구주지역 : NL
						  
						  CD01604
						WORKING SERVER ==> 담당 Part Server ID (Routing에 사용)
								-->담당 Part Server ID (Routing에 사용) KOR, SWA, EUR
						*/
 	                   // InitDataCombo(0, "dpcs_wrk_grp_cd", " |Input|Rate|Audit|Super", " |I|R|A|U");
 						/*InitDataCombo(0, "Group", "F/OFC|Input|Rate|Audit|Super", "1|2|3|4|5");
 						InitDataCombo(0, "Position", "Clerk|Manage", "1|2");
 						InitDataCombo(0, "DocPart", "PK|JP|NL|DE", "1|2|3|4");*/
 	                    
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
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0592GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.dpcs_wrk_grp_cd, "val", "name");
				formObj.dpcs_wrk_grp_cd.InsertItem(0, 'All',' ');
				formObj.dpcs_wrk_grp_cd.index = 0;
				
				if (arrXml.length > 2) 
					setIBCombo(sheetObj, arrXml[2], "dpcs_wrk_grp_cd", true, "", "","","name");
				if (arrXml.length > 1) 
					setIBCombo(sheetObj, arrXml[1], "dpcs_wrk_prt_cd", true, "", "","","val");
				if (arrXml.length > 0) 
					setIBCombo(sheetObj, arrXml[0], "dpcs_psn_cd", true	, "", "","","name");
					
				sheetObj.DataAutoTrim = true;	
				
        	   break;
           case IBSEARCH:      //조회
 	          if(validateForm(sheetObj,formObj,sAction))
 	        	  if(!formObj.usr_id.value==""){
 	        		 formObj.usr_id.value = formObj.usr_id.value.toUpperCase();
 	        	  }
 	        	 formObj.f_cmd.value = SEARCH;
 	          	 sheetObj.DoSearch("ESM_BKG_0592GS.do", FormQueryString(formObj)
 					+ "&" + ComGetPrefixParam(""));
          
                 break;

 			case IBSAVE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)){
                    
	 				if(!chkDuplicate()) return;
	 				
 					
	 				formObj.f_cmd.value = MULTI;
	  				sheetObj.DoSave("ESM_BKG_0592GS.do", FormQueryString(formObj));
	  				sheet1_OnSearchEnd(sheetObj, "");
	  				
	 			}

                 break;
 			case IBDELETE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)){
	 				formObj.f_cmd.value = MULTI;
	  				sheetObj.DoSave("ESM_BKG_0592GS.do", FormQueryString(formObj));
	 			}

                 break;     
 			case IBINSERT:      // 입력
				//신규행 추가
 				//sheetObj.DataInsert(-1);
 				sheetObj.DataInsert(-1);
 				//sheetObj.CellValue2(sheetObj.LastRow,"usr_id") = ComGetObjValue(formObj.strUsr_id);
 				sheetObj.CellValue2(sheetObj.LastRow ,"upd_usr_id") = ComGetObjValue(formObj.strUsr_id);
 				sheetObj.CellValue2(sheetObj.LastRow ,"cre_dt") = ComGetNowInfo();
 				sheetObj.CellValue2(sheetObj.LastRow ,"upd_dt") = ComGetNowInfo();
 				sheetObj.SelectCell(sheetObj.LastRow ,"usr_id");
 				
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
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		/*with(sheetObj){
 			  for (i=1; i<= LastRow; i++) {
 				  if (sheetObj.CellValue(i,"dpcs_wrk_grp_cd") != ""){
					  CellEditable(i,"usr_id") = false;
					  //CellEditable(i,"dpcs_wrk_grp_cd") = false;
 				  }
 			  }
 		}*/
 	}
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	 
 	 	 if (ErrMsg == "") {
  	 		ComBkgSaveCompleted();  //서버메세지 처리
  	 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		 } 	 	
      }
     
     function chkDuplicate(){
    	 var formObj = document.form;
    	 var cnt = sheetObjects[0].RowCount;
    	 var sheetObj = sheetObjects[0];
    	 for (var ix = 1; ix <= cnt; ix++ ){
    		 var usr_id = sheetObj.CellValue(ix,"usr_id");
    		 if (sheetObj.RowStatus(ix) == "I" || sheetObj.RowStatus(ix) == "U"){
	    		 if(ComIsNull(usr_id) != true){
	    			 var findRow = sheetObj.FindText("usr_id",usr_id,0,2,false);
	    			 if(findRow > 0 && findRow != ix){
	    				 ComShowCodeMessage('BKG00827');
	    			 	 sheetObj.SelectCell(ix, "usr_id");   			 	 
	    			 	 return false ;
	    			 }
	    		 }
    		 }
    	 }
    	 return true;
     }
     
	/* 개발자 작업  끝 */