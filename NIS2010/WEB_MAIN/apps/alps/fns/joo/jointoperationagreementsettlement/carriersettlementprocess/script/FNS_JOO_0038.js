/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0038.js
*@FileTitle : Summary of Monthly Clearance Status by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
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
     * @class FNS_JOO_0038 : FNS_JOO_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0038() {
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
 var prefix = "sheet_1";
 var comboObjects = new Array();
 var comboCnt = 0; 
 
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
                	 if(formObject.summarydetail_radio[0].checked == true){
                		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	 }else{
                		 doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
                	 }
                	 
                     break;
                 
                 case "btn1_New":
                	 if(formObject.summarydetail_radio[0].checked == true){
                         doActionIBSheet(sheetObjects[0],document.form,IBRESET);
                	 }else{
                		 doActionIBSheet(sheetObjects[2],document.form,IBRESET);
                	 }
                     break;

                 case "btn1_Down_Excel":
                     var paramObj = new Object();

                	 if(formObject.summarydetail_radio[0].checked == true){
                         var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
                         sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );
                         //sheetObjects[0].SpeedDown2Excel(-1); 
                	 }else{
                         var url = ComJooGetPgmTitle(sheetObjects[2], paramObj);  
                         sheetObjects[2].SpeedDown2Excel(-1, false,false, "", url );
                         //sheetObjects[0].SpeedDown2Excel(-1); 
                	 }
                     
                     break;

                 case "btn1_Print":
 
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
    	axon_event.addListener('click', 'click_usdamount_chk2', 'usdamount_chk2');
		axon_event.addListener('click',   'fnDocClick', 'summarydetail_radio');
         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
         }            
         initControl();
    	axon_event.addListener('click', 'click_usdamount_chk2', 'usdamount_chk2');
		document.form.usdamount_chk2.checked = true;
		document.form.usdamount_chk.value = "0" ;
		
		// summary가 체크되어 있도록 함.
		axon_event.addListener('click', 'fnDocClick', 'summarydetail_radio');
		document.form.summarydetail_radio[0].checked = true;
	    document.form.summarydetail.value = "S" ;
	    
     }
     
     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
     }  

     function sheet3_OnLoadFinish(sheetObj) {
    	 
         doActionIBSheet(sheetObjects[2],document.form, IBCLEAR);
     }  
     
	  /**
	   * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	   * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	   * @param {ibsheet} sheetObj    IBSheet Object
	   * @param {int}     sheetNo     sheetObjects 배열에서 순번
	   **/
	  function initControl() {
	
	      var formObject = document.form;
	 
	      axon_event.addListenerForm ('keydown', 'ComKeyEnter',  formObject); //formObject);
	      axon_event.addListenerForm ('keypress', 'fnObjKeyPress', formObject );           
	      
	  }      

      
       /**
        * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
        * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
        **/
       function setComboObject(combo_obj){
          comboObjects[comboCnt++] = combo_obj;
       }
       
       /**
        * Combo 기본 설정
        * Combo의 항목을 설정한다.
        */
       function initCombo(comboObj, comboNo) {
             
         switch(comboObj.id) {
             case "jo_crr_cd":  
                 with (comboObj) { 
                     MultiSelect = false; 
                     UseAutoComplete = true;    
                     SetColAlign("left");        
                     SetColWidth("60");
                     DropHeight = 160;
                     ValidChar(2,0);
                     MaxLength = 3;
                  }  
                  break;          
                  
             case "jo_stl_itm_cd":
                 with(comboObj) {
                     MultiSelect = false; 
                     UseAutoComplete = true;    
                     SetColAlign("left");        
                     SetColWidth("60");
                     DropHeight = 160;
                     ValidChar(2,2);
                     MaxLength = 3;
                 }
                 break;  
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
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 430;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle1 = "|VSL|VOY|Dir.|Fin.\nDir.|Account\nMonth|Combined\nNo|Carrier|Lane|Item|Cur.|Revenue|Expense|CSR No.";
					 var headCount = ComCountHeadTitle(HeadTitle1);
				 
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [	ROW,  COL,   DATATYPE,      WIDTH, DATAALIGN,     COLMERGE,    SAVENAME,           KEYFIELD, CALCULOGIC,   DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,       true,      "Status");
                     InitDataProperty(0, cnt++ , dtData,         75,    daCenter,       true,      "vsl_cd",             false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_voy_no",         false,      "",         dfDateYm,       0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_dir_cd",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         80,    daCenter,       true,      "rev_dir_cd",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "acct_yrmon",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         90,    daCenter,       true,      "stl_cmb_seq",        false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_crr_cd2",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "rlane_cd" ,          false,      "",         dfNone,         0,          true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_stl_itm_cd2",     false,      "",         dfNone,         0,          true,       true);                     
					 InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "locl_curr_cd",       false,      "",         dfNone,         0,          true,       true);                     

                     InitDataProperty(0, cnt++ , dtData,     	100,    daRight,        true,      "r_stl_locl_amt",     false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,     	100,    daRight,        true,      "e_stl_locl_amt",     false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,        140,    daCenter,       true,      "csr_no",             false,      "",         dfNone,         0,          true,       true);
				 }
                 break;
            
			case 2:      // sheet2 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 430;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(13, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Vsl.|Voy.|Dir|Fin.Dir.|Month|Combined No|Carrier|Lane|Item|Cur.|Revenue|Expense|CSR No.";
                     InitColumnInfo( ComCountHeadTitle(HeadTitle), 0, 0, true);
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [	 ROW, COL,   DATATYPE,      WIDTH,  DATAALIGN,    COLMERGE,   SAVENAME,       	   KEYFIELD, CALCULOGIC,   DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,       true,      "Status");
                     InitDataProperty(0, cnt++ , dtData,         75,    daCenter,       true,      "vsl_cd",             false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_voy_no",         false,      "",         dfDateYm,       0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_dir_cd",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         80,    daCenter,       true,      "rev_dir_cd",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "acct_yrmon",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         90,    daCenter,       true,      "stl_cmb_seq",        false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_crr_cd2",         false,      "",         dfNone,         0,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "rlane_cd" ,          false,      "",         dfNone,         0,          true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_stl_itm_cd2",     false,      "",         dfNone,         0,          true,       true);                     
					 InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "locl_curr_cd",       false,      "",         dfNone,         0,          true,       true);                     

                     InitDataProperty(0, cnt++ , dtData,     	100,    daRight,        true,      "r_stl_locl_amt",     false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,     	100,    daRight,        true,      "e_stl_locl_amt",     false,      "",         dfFloat,        2,          true,       true);
                     InitDataProperty(0, cnt++ , dtData,        140,    daCenter,       true,      "csr_no",             false,      "",         dfNone,         0,          true,       true);
				 }
                 break;
			case 3:      // sheet3 init
                with (sheetObj) {
	                // 높이 설정
	                style.height = 430;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 2, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	                
	                var HeadTitle1 = "|VSL|VOY|Dir.|Fin.\nDir.|Account\nMonth|Combined\nNo|Carrier|Lane|Item|Cur.|Revenue|Revenue|Revenue|Expense|Expense|Expense|CSR No.";
	                var HeadTitle2 = "|VSL|VOY|Dir.|Fin.\nDir.|Account\nMonth|Combined\nNo|Carrier|Lane|Item|Cur.|TEU|Price|Amount|TEU|Price|Amount|CSR No.";
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                
	                
	                //데이터속성    	   [ROW, COL,    DATATYPE,     WIDTH,  DATAALIGN,    COLMERGE,    SAVENAME,           	  KEYFIELD, CALCULOGIC,   DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,       true,      "Status");
	                InitDataProperty(0, cnt++ , dtData,         75,    daCenter,       true,      "vsl_cd",             	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_voy_no",         	false,      "",         dfDateYm,       0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_dir_cd",         	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         80,    daCenter,       true,      "rev_dir_cd",         	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "acct_yrmon",         	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         90,    daCenter,       true,      "stl_cmb_seq",        	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_crr_cd2",         	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "rlane_cd" ,          	false,      "",         dfNone,         0,          true,       true);
	                
	                InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_stl_itm_cd2",     	false,      "",         dfNone,         0,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "locl_curr_cd",       	false,      "",         dfNone,         0,          true,       true);
	
	                InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "r_stl_locl_amt_teu",     false,      "",         dfNone,    	2,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "r_stl_locl_amt_price",   false,      "",         dfNone,    	2,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,     	100,   daRight,        true,      "r_stl_locl_amt",     	false,      "",         dfFloat,   		2,          true,       true);
	                    
	                InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "e_stl_locl_amt_teu",     false,      "",         dfNone,    	2,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "e_stl_locl_amt_price",   false,      "",         dfNone,    	2,          true,       true);
	                InitDataProperty(0, cnt++ , dtData,     	100,   daRight,        true,      "e_stl_locl_amt",     	false,      "",         dfFloat,   		2,          true,       true);
	
	                InitDataProperty(0, cnt++ , dtData,        	140,   daCenter,       true,      "csr_no",             	false,      "",         dfNone,         0,          true,       true);
				}
                break;
            case 4:      // sheet4 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 430;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
                    
                    var HeadTitle1 = "|VSL|VOY|Dir.|Fin.\nDir.|Account\nMonth|Combined\nNo|Carrier|Lane|Item|Cur.|Revenue|Revenue|Revenue|Expense|Expense|Expense|CSR No.";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //InitColumnInfo(HeadTitle1.split("|").length-1, 0, 0, true);
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    	   [ROW, COL,    DATATYPE,     WIDTH,  DATAALIGN,    COLMERGE,    SAVENAME,           	  KEYFIELD, CALCULOGIC,   DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,       true,      "Status");
                    InitDataProperty(0, cnt++ , dtData,         75,    daCenter,       true,      "vsl_cd",             	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_voy_no",         	false,      "",         dfDateYm,       0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "skd_dir_cd",         	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,       true,      "rev_dir_cd",         	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,       true,      "acct_yrmon",         	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,       true,      "stl_cmb_seq",        	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_crr_cd2",         	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "rlane_cd" ,          	false,      "",         dfNone,         0,          true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "jo_stl_itm_cd2",     	false,      "",         dfNone,         0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,       true,      "locl_curr_cd",       	false,      "",         dfNone,         0,          true,       true);

                    InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "r_stl_locl_amt_teu",     false,      "",         dfNullFloat,   	0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "r_stl_locl_amt_price",   false,      "",         dfNullFloat,   	0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,     	100,   daRight,        true,      "r_stl_locl_amt",     	false,      "",         dfNullFloat,    2,          true,       true);
	                    
                    InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "e_stl_locl_amt_teu",     false,      "",         dfNullFloat,    0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,     	60,    daRight,        true,      "e_stl_locl_amt_price",   false,      "",         dfNullFloat,    0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,     	100,   daRight,        true,      "e_stl_locl_amt",     	false,      "",         dfNullFloat,    2,          true,       true);

                    InitDataProperty(0, cnt++ , dtData,        	140,   daCenter,       true,      "csr_no",             	false,      "",         dfNone,         0,          true,       true);
				 }
                break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
                if( !validateForm(sheetObj,formObj,sAction) ){return;}
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
                formObj.f_cmd.value = SEARCHLIST01;            
                var param =  FormQueryString(formObj);  
                
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                sheetObj.LoadSearchXml(sXml);
				
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0038GS.do" , SaveStr + "&" + FormQueryString(formObj));
    			var arrXml = sXml.split("|$$|");	
				
				if (arrXml.length > 0) {
					if(formObj.summarydetail_radio[0].checked == true){
						sheetObjects[0].LoadSearchXml(arrXml[0]);
						sheetObjects[1].LoadSearchXml(arrXml[1]);
					}else{
						sheetObjects[2].LoadSearchXml(arrXml[0]);
						sheetObjects[3].LoadSearchXml(arrXml[1]);
					}
 	   	  		}
                ComOpenWait(false);
				 
                 break;
                     
             case IBCLEAR:      //Open  
                  formObj.f_cmd.value = SEARCH01;            
  
                  var param =  FormQueryString(formObj);
                  var sXml   =  sheetObj.GetSearchXml("FNS_JOO_0038GS.do", param);
 
                  var aXml   = sXml.split("|$$|");
                  
	              ComXml2ComboItem( aXml[0], formObj.jo_crr_cd   , "code","code" );
	              ComXml2ComboItem( aXml[1], formObj.jo_stl_itm_cd, "code","code" );          
                  
                  formObj.vvd.focus();
                  
                  break;
                  
             case IBRESET:      //Open  
                  fnBtnNew();                   
                  break;      
         }
     }

     /**
     * NEW 버튼 처리 
     * @param    void
     * @return   void
     */    
     function fnBtnNew(){
         
         var formObj = document.form;
         formObj.vvd.value           = "";
         formObj.jo_crr_cd.Text2     = "";
         formObj.jo_stl_itm_cd.Text2 = "";
		 formObj.usdamount_chk2.checked = true;
 
         if( sheetObjects[0].RowCount > 0) {
             sheetObjects[0].RemoveAll();
         }
         if( sheetObjects[2].RowCount > 0) {
             sheetObjects[2].RemoveAll();
         }
     }   
       /**
        * <pre>
        *    form Element의 KeyPress Event 발생시 처리.
        *    
        * </pre>
        * @return
        */
       function fnObjKeyPress(){
           var obj = event.srcElement;
           var formObj = document.form;
           switch (obj.name){
                  case    'vvd':
                         ComKeyOnlyAlphabet('uppernum');
                         break;
           }
       }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
 
         with(formObj){
             switch ( sAction ){
                  case IBSEARCH :
                       if (!ComChkValid(formObj)) return false;

                       if( vvd.value  == "") {
                           ComShowCodeMessage('JOO00039');     
                           return false;
                       }
//                       if( jo_crr_cd.Code == "") {
//                           ComShowCodeMessage('JOO00008');   
//                           jo_crr_cd.focus();
//                           return false;
//                       }                       
//                       
//                       if( jo_stl_itm_cd.Code == "") {
//                           ComShowCodeMessage('JOO00113');
//                           jo_stl_itm_cd.focus();
//                           return false;
//                       }                      
                       break;
             }
         }

         return true;
     }

	function click_usdamount_chk2(){
		if (document.form.usdamount_chk2.checked){
			document.form.usdamount_chk.value = "0" ;
			sheetObjects[0].RemoveAll();
			sheetObjects[2].RemoveAll();
		}else{
			document.form.usdamount_chk.value = "" ;
			sheetObjects[0].RemoveAll();
			sheetObjects[2].RemoveAll();
		}
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
			{
				//ShowSubSum("vsl_cd", "11|12", -1, false, false,-1, "jo_crr_cd=Sub-Total");
			}
	}
	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
			{
				//ShowSubSum("vsl_cd", "11|12", -1, false, false,-1, "jo_crr_cd=Sub-Total");
			}
	}
	
	function click_usdamount_chk2(){
		if (document.form.usdamount_chk2.checked){
			document.form.usdamount_chk.value = "0" ;
		}else{
			document.form.usdamount_chk.value = "" ;
		}
	}

	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			//var formObj = document.form;
			//alert("sheetObj.LastRow=>"+sheetObj.LastRow);
			for(i=sheetObj.LastRow; i > 0 ; i--){
				var addRow = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].cellValue(addRow,"vsl_cd") = "TOTAL";
				sheetObjects[0].cellValue(addRow,"locl_curr_cd") = sheetObjects[1].CellValue(i, "locl_curr_cd");	
				sheetObjects[0].cellValue(addRow,"r_stl_locl_amt") = sheetObjects[1].CellValue(i, "r_stl_locl_amt");	
				sheetObjects[0].cellValue(addRow,"e_stl_locl_amt") = sheetObjects[1].CellValue(i, "e_stl_locl_amt");				
				sheetObjects[0].RowBackColor(addRow) = sheetObj.RgbColor(247,225,236);	//색상설정
				sheetObjects[0].CellFont("FontBold", addRow, "vsl_cd") = true;			//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "locl_curr_cd") = true;	//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "r_stl_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "e_stl_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[0].cellValue(addRow+1,"vsl_cd") = "";
				
				
				if ((sheetObjects[1].CellValue(i, "vsl_cd") == '') && (sheetObjects[1].CellValue(i, "locl_curr_cd") == '')) {
					sheetObjects[0].RemoveAll();
				}
			}
					
			for(i=sheetObjects[0].LastRow; i > 0 ; i--){
				if (sheetObjects[0].CellValue(i, "acct_yrmon") == "TOTAL") {
					
				} else {
					sheetObjects[0].CellValue(i, "Seq") = i;
				}
				if (document.form.usdamount_chk2.checked){
					sheetObjects[0].CellValue(i+1, "locl_curr_cd") = "USD";
				}
			}
		}
	}
	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			//var formObj = document.form;
			//alert("sheetObjects[3].LastRow=>"+sheetObjects[3].LastRow);
			
			for(i=sheetObj.LastRow; i > 0 ; i--){
				var addRow = sheetObjects[2].DataInsert(-1);
				
				sheetObjects[2].cellValue(addRow,"vsl_cd") = "TOTAL";
				sheetObjects[2].cellValue(addRow,"locl_curr_cd") = sheetObjects[3].CellValue(i, "locl_curr_cd");	

				sheetObjects[2].cellValue(addRow,"r_stl_locl_amt") = sheetObjects[3].CellValue(i, "r_stl_locl_amt");
				sheetObjects[2].cellValue(addRow,"e_stl_locl_amt") = sheetObjects[3].CellValue(i, "e_stl_locl_amt");
				sheetObjects[2].RowBackColor(addRow) = sheetObj.RgbColor(247,225,236);	//색상설정
				sheetObjects[2].CellFont("FontBold", addRow, "vsl_cd") = true;			//글자체 굵기설정
				sheetObjects[2].CellFont("FontBold", addRow, "locl_curr_cd") = true;	//글자체 굵기설정
				sheetObjects[2].CellFont("FontBold", addRow, "r_stl_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[2].CellFont("FontBold", addRow, "e_stl_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[2].cellValue(addRow+1,"vsl_cd") = "";
				
				if ((sheetObjects[3].CellValue(i, "vsl_cd") == '') && (sheetObjects[3].CellValue(i, "locl_curr_cd") == '')) {
					sheetObjects[2].RemoveAll();
				}
				
			}

			for(i=sheetObjects[2].LastRow; i > 0 ; i--){
				if (sheetObjects[2].CellValue(i, "acct_yrmon") == "TOTAL") {
					
				} else {
					sheetObjects[2].CellValue(i, "Seq") = i;
				}
				if (document.form.usdamount_chk2.checked){
					sheetObjects[2].CellValue(i+1, "locl_curr_cd") = "USD";
				}
			}
		}
	}

     /**
     * 년월 NAVI 처리 이벤트 
     * @param void
     * @return void
     */
     function fnDocClick(){
         var obj = event.srcElement;
         var formObj = document.form;
         var doc = document.all;
         switch (obj.name){
             case "summarydetail_radio":
            	 if(formObj.summarydetail_radio[0].checked == true){
            		 sheetObjects[0].RemoveAll();
            		 sheetObjects[1].RemoveAll();
            		 formObj.summarydetail.value = "S";
                     doc.sheet_acct_detail1.style.display = "";
                     doc.sheet_acct_detail3.style.display  = "none";
                 }else if(formObj.summarydetail_radio[1].checked == true){
            		 sheetObjects[2].RemoveAll();
            		 sheetObjects[3].RemoveAll();
            		 formObj.summarydetail.value = "D";
                     doc.sheet_acct_detail1.style.display = "none";
                     doc.sheet_acct_detail3.style.display  = "";
                 }else{
            		 sheetObjects[0].RemoveAll();
            		 sheetObjects[1].RemoveAll();
            		 formObj.summarydetail.value = "S";
                     doc.sheet_acct_detail1.style.display = "";
                     doc.sheet_acct_detail3.style.display  = "none";
                 }
                 break;
         }
     }
	
	/* 개발자 작업  끝 */