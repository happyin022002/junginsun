/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0110.js
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.25 강동윤
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
     * @class ESM_BKG_0110 : ESM_BKG_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0110() {
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
 
 var comboObjects = new Array();
 var combo1 = null;
 var comboCnt = 0;
 
 var tabItem 	= 0;

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

     function setComboObject(combo_obj){
    	 comboObjects[comboCnt++] = combo_obj;
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
         
         initCombo(document.form.ca_knd);
         
         initControl();
         
         document.form.cho_from_dt.value = getCalculatedDate(0,-1,0,"-");
 		 document.form.cho_to_dt.value   = getCalculatedDate(0,0,0,"-"); 
 		 
 		 setDisable("0");
 		 
 		 for (var i = 0 ; i < document.form.ca_rsn_cd.length ; i++){
 			 
 			 document.form.ca_rsn_cd[i].checked = false;
 		 }
 		 
 		 doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
     }
      
        /**
       * 조회조건 입력할 때 처리
       */
      function obj_KeyUp() {
 	     var formObject = document.form;
 	     var srcName = window.event.srcElement.getAttribute("name");
 	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	     var srcValue = window.event.srcElement.getAttribute("value");
 	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
 	     	ComSetNextFocus();
 	     }
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
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리
          //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
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
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

	 /**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj) {
      	comboObj.MultiSelect = true;
      	comboObj.UseCode = true;
      	//comboObj.LineColor = "#ffffff";
      	//comboObj.SetColAlign("left|left");
      	comboObj.MultiSeparator = ",";
      	comboObj.DropHeight = 150;
      	
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
 				case "sheet1":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 320;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(21, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Booking Office|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Total B/L|Total C/A|Ratio";
                     var HeadTitle2 = "|Booking Office|A|B|C|D|E|F|G|H|I|J|K|M|C|G|A|R|Total B/L|Total C/A|Ratio";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    daCenter,  true,    "ibflag");
                     InitDataProperty(0, cnt++ , dtData,      		95,    daCenter,  true,    "bkg_ofc_cd", false,          "",      dfNone,      		 0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   		40,    daCenter,  false,   "kind_a", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_b", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_c", 	 false,          "",      dfNullInteger,   0,     false,       true);
                                                                                                                                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_d", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_e", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_f", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_g", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_h", 	 false,          "",      dfNullInteger,   0,     false,       true);
                                                                                                                                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_i", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_j", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_k", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_m", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_c", 	 false,          "",      dfNullInteger,   0,     false,       true);
                                                                                                                                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_g", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_a", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_r", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	80,    daCenter,  true,    "tot_bl",	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	80,    daCenter,  true,    "tot_ca",	 false,          "",      dfNullInteger,   0,     false,       true);

                     InitDataProperty(0, cnt++ , dtAutoSum,       	70,    daCenter,  true,    "ratio", 	 false,          "",      dfNullFloat, 		 2,     false,       true);


 										//CountPosition = 0;

                }
                 break;

 				case "sheet2":      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 320;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(21, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Customer|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Total B/L|Total C/A|Ratio";
                     var HeadTitle2 = "|Customer|A|B|C|D|E|F|G|H|I|J|K|M|C|G|A|O|Total B/L|Total C/A|Ratio";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    daCenter,  true,    "ibflag");
                     InitDataProperty(0, cnt++ , dtData,      		200,   daLeft,    true,    "cust_nm",	 false,          "",      dfNone,      		 0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,   		40,    daCenter,  false,   "kind_a", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_b", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_c", 	 false,          "",      dfNullInteger,   0,     false,       true);
                                                                                                                                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_d", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_e", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_f", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_g", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_h", 	 false,          "",      dfNullInteger,   0,     false,       true);
                                                                                                                                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_i", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_j", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "kind_k", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_m", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_c", 	 false,          "",      dfNullInteger,   0,     false,       true);
                                                                                                                                     
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_g", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_a", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	40,    daCenter,  false,   "rea_r", 	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	80,    daCenter,  true,    "tot_bl",	 false,          "",      dfNullInteger,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtAutoSum,       	80,    daCenter,  true,    "tot_ca",	 false,          "",      dfNullInteger,   0,     false,       true);

                     InitDataProperty(0, cnt++ , dtAutoSum,       	80,    daCenter,  true,    "ratio", 	 false,          "",      dfNullFloat, 		 2,     false,       true);


 										//CountPosition = 2;

                }
                 break;
         }
     }
      
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

  		       case "btn_Retrieve":
  		    	  
  		    	  if (tabItem == 0){
 						
  		    		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
  		    	  }else{
 					
  		    		  doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
  		    	  }
                break;

  		       case "btn_new":
  		    	   ComResetAll();
  		    	   changeTab("0");
  		    	   //sheetObject1.RemoveAll();
  		    	   //sheetObject2.RemoveAll();
               break;
                 
  		       case "btn_excel":
  		    	   sheetObject1.SpeedDown2Excel(-1);
  		    	   if (tabItem == 0){
						
  		    		   sheetObject1.SpeedDown2Excel(-1); 
  		    	   }else{
					
  		    		   sheetObject2.SpeedDown2Excel(-1);
  		    	   }
               break;
                
  		       case "btn_print":
  								alert(srcName);
               break;
                
  		       case "btn_calendar":
 	  	           var cal = new ComCalendar();
 	  	           cal.setDisplayType('month');
 	  	           cal.select(formObject.cho_from_dt, 'yyyy-MM');

   			   break;
   			   
  		       case "btn_calendar1":
  		    	 
 	  	           var cal = new ComCalendarFromTo();
	               cal.select(formObject.cho_from_dt, formObject.cho_to_dt, 'yyyy-MM-dd');
 	  	           
  			   break;
   			   
  		       case "btn_calendar2":
 		    	   var cal = new ComCalendarFromTo();
  	               cal.select(formObject.bl_obrd_from_dt, formObject.bl_obrd_to_dt, 'yyyy-MM-dd');
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
 							sheetObj.RemoveAll();
 				
 							sheetObj.WaitImageVisible = false;
 							ComOpenWait(true);
 				
	 						formObj.f_cmd.value = SEARCH;   
	 						sheetObj.DoSearch("ESM_BKG_0110GS.do",FormQueryString(formObj));
	 						
	 						ComOpenWait(false);	
 						
 						break;
 						
 						case COMMAND01:      // INIT
 						
	 						formObj.f_cmd.value = INIT;   
		   	        	    
 							var sXml = sheetObj.GetSearchXml("ESM_BKG_0110GS.do", FormQueryString(formObj));
 							
 							//ComXml2ComboItem(sXml, formObj.ca_knd, "val", "val|name");
 							ComBkgXml2ComboItem(sXml, formObj.ca_knd, "val", "name");
 							
 							//comboObjects[0].Text2 = "A,B,C,D,E,F,G,H,I,J,K";
	 						
 						break;

         }
     }

     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }


     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "By Office" , -1 );
                     InsertTab( cnt++ , "By Customer" , -1 );

                 }
                 break;
         
         }
     }


     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs = document.all.item("tabLayer");

         objs[nItem].style.display = "Inline";
         objs[beforetab].style.display = "none";
         
         tabItem = nItem;
	    
         if (nItem == 0){
        	 
        	 document.form.tab_tp[1].checked = true;
         }else{
        	 
        	 document.form.tab_tp[0].checked = true;
         }
         
         setDisable(nItem);

         //--------------- 요기가 중요 --------------------------//
         objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab= nItem;
     } 

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             
        	 if (cho_from_dt.value == '' || cho_to_dt.value == ''){
        		 
        		 ComShowCodeMessage("BKG00499");//Period are mandatory items.
        		 cho_from_dt.focus();
        		 return false;
        	 }
        	 
        	 if (ComGetDaysBetween(cho_from_dt.value, cho_to_dt.value) > 31){
        		 
        		 ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
        		 cho_to_dt.focus();
        		 return false;
        	 }
        	 
        	 var reason = "";
        	 
        	 var idx = 0;
        	 
        	 for (var i = 0 ; i < ca_rsn_cd.length ; i++){
        		 
        		 if (ca_rsn_cd[i].checked == true){
        			 
        			 if (idx == 0){
        				 
        				 reason = ca_rsn_cd[i].value;
        			 }else{
        				 
        				 reason = reason + "," + ca_rsn_cd[i].value;
        			 }
        			 
        			 idx++;
        		 }
        	 }
        	 
        	 rea_val.value = reason;
         }

         return true;
     }
     
      /**
       * change tab
       */
     function changeTab(nItem){
    	 
    	 tabObjects[0].SelectedIndex = nItem;
    	 
    	 setDisable(nItem);
     }
     
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
  	{
  		with(sheetObj)
  		{
  			var lastTot = CellValue(LastRow, LastCol);
  			
  			CellValue2(LastRow, LastCol) = lastTot / RowCount;  			  		
  		}
  	}
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
  	{
  		with(sheetObj)
  		{
  			var lastTot = CellValue(LastRow, LastCol);
  			
  			CellValue2(LastRow, LastCol) = lastTot / RowCount;
  		}
  	}
  	
  	// Revenue Setting
  	function changeRat(idx){
  		
  		formObj = document.form;
  		
  		if (idx == 0){
  			
  			if (formObj.rat_flg[0].checked == true){
	  			
  				formObj.rat_flg[0].checked = true;
	  			formObj.rat_flg[1].checked = false;
  			}
  		}else{
  			if (formObj.rat_flg[1].checked == true){
	  			
  				formObj.rat_flg[0].checked = false;
	  			formObj.rat_flg[1].checked = true;
  			}
  		}
  	}
  	
  	function setDisable(nItem){
  		
  		var formObj = document.form;
  		
  		if (nItem == "0"){
  			
  			formObj.cust_tp[0].disabled = true;
  			formObj.cust_tp[1].disabled = true;
  			formObj.cust_nm.disabled = true;
  			formObj.cust_nm.style.background = "#E8EFF9";
  			
  			//formObj.bkg_ofc_cd.disabled = false;
  			//formObj.bkg_ofc_cd.style.background = "#FFFFFF";     
  		}else{
  			
  			formObj.cust_tp[0].disabled = false;
  			formObj.cust_tp[1].disabled = false;
  			formObj.cust_nm.disabled = false;
  			formObj.cust_nm.style.background = "#FFFFFF";
  			
  			//formObj.bkg_ofc_cd.disabled = true;
  			//formObj.bkg_ofc_cd.style.background = "#E8EFF9";   
  		}
  	}
      
     /**
      * 날짜 계산 함수
      */
     function getCalculatedDate(iYear,iMonth,iDay,seperator)
     {
     	//현재 날짜 객체를 얻어옴
     	var gdCurDate = new Date();
     	
     	//현재 날짜에 날짜 계산
     	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
     	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
     	gdCurDate.setDate(gdCurDate.getDate() + iDay);
     	
     	//실제 사용할 연,월,일 변수 받기
     	var giYear = gdCurDate.getFullYear();
     	var giMonth = gdCurDate.getMonth()+1;
     	var giDay = gdCurDate.getDate();

     	//월,일의 자릿수를 2자리로 맞춘다.
     	giMonth = "0" + giMonth;
     	giMonth = giMonth.substring(giMonth.length-2,giMonth.length);
     	giDay   = "0" + giDay;
     	giDay   = giDay.substring(giDay.length-2,giDay.length);
     	//alert(giYear + seperator + giMonth + seperator + giDay);
     	//display 형태 맞추기
     	return giYear + seperator + giMonth + seperator + giDay;	
     }
    
     
	/* 개발자 작업  끝 */