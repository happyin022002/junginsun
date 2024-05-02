/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0021.js
*@FileTitle : (S.China) Charge for Tax Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
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
     * @class FNS_INV_0021 : FNS_INV_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0021() {
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

                 case "btn_add":
                	 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                     break;

 		        case "btn_copy":
 		        	 var index = sheetObjects[0].DataCopy();
 		        	getCodeNum(index);
 		        	chgCdChk();
                     break;

                 case "btn_delete":
                	 if(!validateForm(sheetObjects[0],formObject,IBDELETE)) {
         				return false;
         			}
 					var delNum = ComRowHideDelete(sheetObjects[0], "DelChk");
                     break;

 		        case "btn_save":
 		        	doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                     break;

 		        case "btn_retrive":
 		        	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                     break;

                 case "btn_new":
                	 ComResetAll();
                	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	//office 콤보조회
                     break;

 		        case "btn_downExcel":
 		        	 sheetObjects[0].SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|DelChk|ar_ofc_cd");
 		        	//sheetObjects[0].Down2Excel(0, false, false, true, "", "", false, false, "", false, "|ibflag|DelChk|ar_ofc_cd");
                     //sheetObject.Down2Excel();
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

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }         
     }

     /** 
    	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object        
         * @return 없음
         * @see #
         * @author 한동훈
         * @version 2009.10.19
         */  	
    	function sheet_OnLoadFinish(sheetObj){
    		sheetObj.WaitImageVisible = false; 
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	//office 콤보조회
            ComSetFocus(form.ofc_cd2);
            initControl();
    		sheetObj.WaitImageVisible = true;
    	}
    	
    	/** 
      * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
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
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
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
             case 1:      //t1sheet1 init
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
                     InitRowInfo( 1, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel|CHG NO|Charge|Charge Name|Remark(s)|ar_ofc_cd";
                     
                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  "ibflag");
 					 InitDataProperty(0, cnt++, dtDummyCheck, 	40,		daCenter, 	false,	"DelChk");
                     InitDataProperty(0, cnt++ , dtData,    90,    daCenter,  true,    "tax_chg_no",     		true,          "",      dfNone,  0,     false,          false);
                     InitDataProperty(0, cnt++ , dtData,    170,    daCenter,  true,    "tax_chg_cd",     		true,          "",      dfNone,  0,     true,          true,      20);
                     InitDataProperty(0, cnt++ , dtData,    200,    daLeft,  true,    "tax_chg_locl_nm",     	true,          "",      dfNone,  0,     true,          true,      50);

                     InitDataProperty(0, cnt++ , dtData,    250,    daLeft,  true,    "chg_desc",     		false,          "",      dfNone,  0,     true,          true,      100);
                     InitDataProperty(0, cnt++ , dtHidden,    150,    daCenter,  true,    "ar_ofc_cd",     		false,          "",      dfNone,  0,     true,          true,      50);
                     
                     InitDataValid(0,    "tax_chg_cd",   vtEngUpOnly);
                     //InitDataValid(0,    "tax_chg_cd",   vtEngOther, "0123456789");
                }
                 break;

  

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH_ASYNC10: //SalesCustomer Office 조회
	      		//office 코드 세팅         	
	      		ComboObject_OfcCd(sheetObj, formObj, formObj.ofc_cd2,'N');
	      		break;
            case IBSEARCH:      //조회
            	if(validateForm(sheetObj,formObj,sAction) == false) return false;  	
            	formObj.ofc_cd.value = formObj.ofc_cd2.text;
         		formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("FNS_INV_0021GS.do", FormQueryString(formObj));
                 break;
 			 case IBSAVE:        //저장
 				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(sheetObj.RowCount == 0) return;
				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects);
				if (sheetObj.IsDataModified && sParam == "") return; 
				
                sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0021GS.do", sParam );
				sheetObj.LoadSaveXml(SaveXml);
                 break;

 			case IBINSERT:      // 입력
 				var sheetIdx = sheetObj.DataInsert(-1);
 				getCodeNum(sheetIdx);
				sheetObj.CellText(sheetIdx,"ar_ofc_cd") = formObj.ofc_cd2.text;
                 break;
         }
     }
     
     function getCodeNum(sheetIdx){
    	 var tax_chg_no = sheetObjects[0].RowCount;
    	 var val = "0";
    	 var max_val = "0";
    	 for (var i=1; i<=sheetObjects[0].RowCount; i++) {
    		 val = sheetObjects[0].CellValue(i,"tax_chg_no");
    		 if(val == "") val = "0";
    		 if(max_val == "") max_val = "0";
    		 //alert(val+"::"+max_val);
    		 if(val >= max_val){
    			 max_val = sheetObjects[0].CellValue(i,"tax_chg_no");
    		 }
    	 }
    	 max_val = Number(max_val)+1;
    	 sheetObjects[0].CellValue(sheetIdx,"tax_chg_no") = zeroInsert(max_val);
    	 sheetObjects[0].CellValue(sheetIdx,"tax_chg_cd") = "";
     }
     
     function zeroInsert(str){
    	 var newStr = '';
    	 str = str+"";
    	 if(str.length < 3){
    	  for(var i=0;i<3-str.length;i++){
    	   newStr = newStr + '0'
    	  }
    	  newStr = newStr + str;
    	 }else{
    	  newStr = str;
    	 }
    	 return newStr;
    	}

     function sheet_OnChange(sheetObj, Row, Col){

		if (sheetObj.ColSaveName(Col) == "tax_chg_cd") {
			chgCdChk();
		}   		
   	}
     
     function chgCdChk(){
		var chk_Val = "";
		var chk_num = 0;
		var selRow = sheetObjects[0].SelectRow;
		var Val = sheetObjects[0].cellValue(selRow, "tax_chg_cd");
		for (var i=1; i<=sheetObjects[0].RowCount; i++) {
			chk_Val = sheetObjects[0].cellValue(i, "tax_chg_cd");
			if(Val == chk_Val){
				chk_num = chk_num + 1;
			}
		}
		if(chk_num >= 2){
			ComShowCodeMessage('INV00052');
			sheetObjects[0].SelectCell(selRow, "tax_chg_cd");
			//sheetObjects[0].cellValue(selRow, "tax_chg_cd") = "";	
			return false;
		}
     }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	     	case IBSEARCH: //조회				
				if (formObj.ofc_cd2.text == "") {
	      		ComShowCodeMessage('INV00004');
	      		ComSetFocus(form.ofc_cd2);
					return false;
				}				
				break;
	     	case IBDELETE:
				if (sheetObj.CheckedRows("DelChk") == 0) {
					ComShowMessage(msgs["INV00025"]);
					return false;
				} else if (sheetObj.CheckedRows("DelChk") > 0) {
					if(!ComShowCodeConfirm("INV00028")) return;
				}
				break;	
    	 }	
         return true;
     }

    

	/* 개발자 작업  끝 */