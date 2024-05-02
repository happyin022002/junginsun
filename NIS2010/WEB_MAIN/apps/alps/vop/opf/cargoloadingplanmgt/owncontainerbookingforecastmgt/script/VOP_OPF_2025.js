/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_OPF_2025.js
 *@FileTitle : CBF Weight Group Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 * 1.0 Creation
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    function vop_opf_2025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
		this.sheet1_OnChange        = sheet1_OnChange;    	
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
				case "btn_Retrieve":
	
				   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
					
			 	   break;
			 	 
				case "btn_Close":
					self.close();
					break;   
					
			
		        		
				case "btn_Save":
					
					   doActionIBSheet(sheetObjects[0],document.form,IBSAVE);	
						
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
         
     	var formObj = document.form;
        initControl();
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }
    

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl(){
    	 axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리    	 
         axon_event.addListenerFormat('focus',     'obj_activate',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
         axon_event.addListenerFormat('keypress',  'obj_keypress',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
         axon_event.addListenerFormat('blur',	  'obj_blur',	    form); 
         axon_event.addListenerForm  ("keyup",    'obj_keyup',      form);
         
     	axon_event.addListener  ('keypress', 'eng_keypress', 'slan_cd'); //Code 입력 시 영문 대문자만 입력하기
     	axon_event.addListener  ('change', 'change_event', 'slan_cd');   //Input Box 이벤트
     	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
     }
          
      /**
       * OnBlur
       */
      function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
      }     

     /**
      * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
      **/
     function obj_activate(){
         ComClearSeparator(event.srcElement);
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
        	//높이 설정
				style.height = 230;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);
                
				var HeadTitle  = "|SEQ|Weight Group|20'|40'|40H|45'||||||";

				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			 	InitHeadRow(0, HeadTitle, true);
				
				//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	 "ibflag");
				InitDataProperty(0, cnt++, dtDataSeq, 	    40, 	daCenter, 	true, 	 "seq"			     	,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++, dtData, 			140, 	daLeft, 	true, 	 "nm"				    ,false	,""		,dfNone	     ,0	 ,false	  ,false	);
				InitDataProperty(0, cnt++, dtData, 			110, 	daRight, 	true, 	 "f_20_qty"	  	        ,false	,""		,dfNone	     ,0	 ,true	  ,true	    );
				InitDataProperty(0, cnt++, dtData, 		    110, 	daRight, 	true, 	 "f_40_qty"		        ,false	,""		,dfNone	     ,0	 ,true	  ,true	    );
				InitDataProperty(0, cnt++ ,dtData,          110,    daRight,    true,    "f_40h_qty"            ,false  ,""     ,dfNone      ,0  ,true    ,true    );
				InitDataProperty(0, cnt++ ,dtData,          110,    daRight,    true,    "f_45_qty"             ,false  ,""     ,dfNone      ,0  ,true    ,true    );
				InitDataProperty(0, cnt++ ,dtHidden,        50,     daCenter,   true,    "cntr_wgt_grp_cd"      ,false  ,""     ,dfNone      ,0  ,true    ,true    );
				InitDataProperty(0, cnt++ ,dtHidden,        50,     daCenter,   true,    "vvd"                  ,false  ,""     ,dfNone      ,0  ,false   ,false    );
				InitDataProperty(0, cnt++ ,dtHidden,        50,     daCenter,   true,    "yd_cd"                ,false  ,""     ,dfNone      ,0  ,false   ,false    );
				InitDataProperty(0, cnt++ ,dtHidden,        50,     daCenter,   true,    "crr_cd"               ,false  ,""     ,dfNone      ,0  ,false   ,false    );
				InitDataProperty(0, cnt++ ,dtHidden,        50,     daCenter,   true,    "pod_cd"               ,false  ,""     ,dfNone      ,0  ,false   ,false    );		
				InitDataProperty(0, cnt++ ,dtHidden,        50,     daCenter,   true,    "blck_stwg_cd"         ,false  ,""     ,dfNone      ,0  ,false   ,false    );
				
				InitDataValid(0,  "f_20_qty",  vtNumericOnly);
				InitDataValid(0,  "f_40_qty",  vtNumericOnly);
				InitDataValid(0,  "f_40h_qty", vtNumericOnly);
				InitDataValid(0,  "f_45_qty",  vtNumericOnly);
				
       
         }
         break;
             
        
      }
   }

   
   // Sheet관련 프로세스 처리
   function doActionIBSheet(sheetObj,formObj,sAction) {
	   sheetObj.ShowDebugMsg = false;
      // var sheetObject1 = sheetObjects[0];
	
     switch(sAction) {
       case IBSEARCH:        //조회
         // if(validateForm(sheetObj,formObj,sAction)){
       
        	  sheetObj.WaitImageVisible=false;
			  ComOpenWait(true);        			  
			  formObj.f_cmd.value = SEARCH01;

			  sheetObj.DoSearch("VOP_OPF_2025GS.do", FormQueryString(formObj));

			  ComOpenWait(false);
        //  }
       break;
       
      case IBSAVE:	
    	    sParam = ComGetSaveString(sheetObjects);
	 		sheetObj.Redraw = false;
			formObj.f_cmd.value = MULTI;	

			sParam += "&" + FormQueryString(formObj);	 			
			sheetObj.DoSave("VOP_OPF_2025GS.do", sParam, -1, false);
			
			doActionIBSheet(sheetObj, formObj, IBSEARCH); 
			sheetObj.Redraw = true;
			break;
     
      }
   }
   

	
     /**
      * Sheet1 OnSearchEnd Event 처리
      * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
      */
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		with(sheetObj)
		  {
  	    	sheetObj.RowEditable(7) = false;
  	    	sheetObj.RowEditable(8) = false;

  			var formObj = document.form;
  			var sum1    = formObj.bkg_20_qty.value;
  			var sum2    = formObj.bkg_40_qty.value;
  			var sum3    = formObj.bkg_40h_qty.value;
  			var sum4    = formObj.bkg_45_qty.value;
  			
  	   	    var qty1 = CellValue(7,"f_20_qty");
  		    var qty2 = CellValue(7,"f_40_qty");
  		    var qty3 = CellValue(7,"f_40h_qty");
  	    	var qty4 = CellValue(7,"f_45_qty");
		  
  	      if(sum1 =="0") sum1 ="";
  	      if(sum2 =="0") sum2 ="";
  	      if(sum3 =="0") sum3 ="";
  	      if(sum4 =="0") sum4 ="";
      
  		  if(sum1!=qty1) {CellBackColor(7,"f_20_qty")  = RgbColor(255, 255, 0);}
  	  	  if(sum2!=qty2) {CellBackColor(7,"f_40_qty")  = RgbColor(255, 255, 0);}
  	  	  if(sum3!=qty3) {CellBackColor(7,"f_40h_qty") = RgbColor(255, 255, 0);}
  	  	  if(sum4!=qty4) {CellBackColor(7,"f_45_qty")  = RgbColor(255, 255, 0);}  
		  }
  		} 
  	
	/* 개발자 작업  끝 */