/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1180.js
*@FileTitle : E-BKG Handling Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.06.10 문동선
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
     * @class esm_bkg_1180 : esm_bkg_1180 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1180() {
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
 
 var maxCtrl = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

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
         
         if(!(document.form.screenName.value.indexOf("Q") < 0)){
        	 sheetObjects[0].Editable = false;
        	 sheetObjects[0].ColHidden("Del") = true;
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
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener('keydown', 'ComKeyEnter', 'form');          
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "engnum":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet('num');
	            break;    
	        default:
	            //숫자만입력하기(정수,날짜,시간)
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
 				var sheetID = sheetObj.id;
 				switch(sheetID) {

 					case "sheet1":
 							with (sheetObj) {
 								
 								// 높이 설정
 								style.height = 380;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;

 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msNone;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;

 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(1, 1, 3, 100);
 								
 								var HeadTitle1 = "|Sel.|Seq.|BKG OFC|POL|CMDT Desc.|Date|User ID|bkg_hndl_ofc_seq";

 								var headCount = ComCountHeadTitle(HeadTitle1);

 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(9, 0, 0, true);

 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);

 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			0,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtDelCheck,				40,		daCenter,		true,		"Del",				false,		"",		dfNone,					0,		true,	true);
 								InitDataProperty(0,		cnt++ , dtSeq,					40,		daCenter,		true,		"Seq",				false,		"",		dfNone,					0,		false,	false); 								
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"hndl_ofc_cd",		true,		"",		dfNone,					0,		true,	true, 6);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"pol_cd",		    false,		"",		dfNone,					0,		true,	true, 5);
 								InitDataProperty(0,		cnt++ , dtData,					400,	daLeft,			true,		"cmdt_nm",			false,		"",		dfNone,					0,		true,	true, 100);
 								InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		true,		"upd_dt",			false,		"",		dfNone,					0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,		true,		"upd_usr_id",		false,		"",		dfNone,					0,		false,	false);
 								InitDataProperty(0,		cnt++ , dtHidden,				0,		daCenter,		true,		"bkg_hndl_ofc_seq",	false,		"",		dfNone,					0,		false,	false);
 								
 								InitDataValid(0, 	"hndl_ofc_cd", vtEngUpOther,"");
 								InitDataValid(0, 	"pol_cd", vtEngUpOther,"");
 						}
 						break;
 					

 			}
 	}
      
      
   // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
      function processButtonClick(){
           /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		         var sheetObject1 = sheetObjects[0];
           /*******************************************************/
           var formObject = document.form;

      	try {
      		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
				
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;
				
				case "btn_add":
					 addRow();
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
      
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //조회
 						if(!validateForm(sheetObj,formObj,sAction)) return; 						 					
 					 	
 						formObj.f_cmd.value = SEARCH; 
 						
 						sheetObj.WaitImageVisible = false;
 						ComOpenWait(true);
 						
 						searchXml = sheetObj.GetSearchXml("ESM_BKG_1180GS.do" , FormQueryString(formObj)); 						 					
 						
 						sheetObjects[0].LoadSaveXml(searchXml);
 						
 					break;
 					
 					case IBSAVE:        //저장
 						if(!validateForm(sheetObj,formObj,sAction)) return;
 						
 						formObj.f_cmd.value = MULTI;   
 						
	 					sheetObj.WaitImageVisible = false;
 						ComOpenWait(true);
 						
 						var sParam = "&f_cmd=" + MULTI + "&" + ComGetPrefixParam("");
 		                sheetObj.DoSave("ESM_BKG_1180GS.do", sParam);
 		                
 		                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		                
 					break;
 					
 					case IBDELETE:      // 삭제
 						ComRowHideDelete(sheetObj, "Del");
 					
 					break;
 					
         }
         
         ComOpenWait(false);
     }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
				case IBSAVE:
					if (! sheetObj.IsDataModified){
						ComShowCodeMessage('BKG00989');
						return false; //There is no updated data to save.
					}
					for (var i = sheetObj.HeaderRows ; i < sheetObj.RowCount +1 ; i++){
						if(sheetObj.CellValue(i,"ibflag") == "I" || sheetObj.CellValue(i,"ibflag") == "U"){
							if (sheetObj.CellValue(i, "hndl_ofc_cd") == ''){
								ComShowCodeMessage("BKG00104", "BKG OFC");//Mandatory item is missing. Please enter ({?msg1})
								return false;
							}
							if (sheetObj.CellValue(i, "pol_cd") == '' && sheetObj.CellValue(i, "cmdt_nm") == ''){
								ComShowCodeMessage("BKG00104", "POL or CMDT Desc.");//Mandatory item is missing. Please enter ({?msg1})
								return false;
							}
						}
					}
					break;
			}
		}
		return true;	
	}
     
    /**
     * 셀변경후  이벤트 처리
     */ 
     function sheet1_OnChange(sheetObj, Row, Col, Value) {
      	       	   
    	   with (sheetObj) {
    		   
    		 var formObj = document.form;
    		 
    		 // pol_cd 나 cmdt_nm 이 입력되면 반대 칸을 지운다
    		 if(ColSaveName(Col) == "pol_cd"){
    			 if(Value.length > 0){
    				 CellValue2(Row,"cmdt_nm") = "";
    			 }
    		 }else if(ColSaveName(Col) == "cmdt_nm"){
    			 if(Value.length > 0){
    				 CellValue2(Row,"pol_cd") = "";
    			 }
    		 }
      		 
      	 }
     }  
       
      
    /**
     * 로우추가이벤트 처리 
     */  
     function addRow(){
    		 sheetObjects[0].DataInsert(-1);
    		 sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, 3, true, ''); 
     }

	/* 개발자 작업  끝 */