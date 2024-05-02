/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1112.js
*@FileTitle : Utilization Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.13 조재성
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class EES_CGM_1112 : EES_CGM_1112 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1112() {
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
var comboCnt = 0;
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */ 
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];

         /*******************************************************/
        var formObject = document.form;

        try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                	if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
                		
                		sheetObject1.RemoveAll();
                		sheetObject2.RemoveAll();
                		sheetObject3.RemoveAll();
                		sheetObject4.RemoveAll();
                		
                		formObject.inven20.value = "";
                		formObject.inven40.value = "";
                		formObject.inven45.value = "";
                		
                		formObject.avail20.value = "";
                		formObject.avail40.value = "";
                		formObject.avail45.value = "";
                			
                		formObject.assigned20.value = "";
                		formObject.assigned40.value = "";
                		formObject.assigned45.value = "";
                		
                		formObject.usage20.value = "";
                		formObject.usage40.value = "";
                		formObject.usage45.value = "";
                		
                		formObject.util20.value = "";
                		formObject.util40.value = "";
                		formObject.util45.value = "";
                		
                		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                	}
                	// chungpa 20100511 search후 scc조건 reset되는 문제점 fix. start
            		//기존 formObject.crnt_loc_cd.focus(); //조회후 focus는 location으로 가게 만든다.     
                	if(formObject.scc_cd.Text != '')
                	{
                		formObject.scc_cd.focus(); //조회후 location에 포커스가 있으면 재 검색할때 SCC검색조건이 모두 RESET되기 때문에 focus는 SCC로 가게 만든다. 단 ENTER 키 Search기능은 유지.
                	}else
                	{
                		formObject.crnt_loc_cd.focus(); //조회후 focus는 location으로 가게 만든다.
                	}
                	// chungpa 20100511 search후 scc조건 reset되는 문제점 fix. end
                break;
		        case "btn_new":
	                initControl();
	                doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC10); // SCC를 재구성해준다. 
	                break; 
								
		        case "btn_downexcel":
	                doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
	                
					sheetObject3.SpeedDown2Excel(-1,true);
					sheetObject1.SpeedDown2Excel(-1,true);
					sheetObject2.SpeedDown2Excel(-1,true);
					sheetObject4.SpeedDown2Excel(-1,true);
					 
	                break;
	            case "btns_crnt_loc_cd":	// Location Popup
		        	var tmp = "LCC";
		            if(tmp == "RCC"){
		            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		            	ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
		            	//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
		            } else if(tmp == "LCC") {
		            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		            	ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
		            	//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
		            } else if(tmp == "SCC") {
		            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		            	ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
		            	//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
		            }
	                break;
	            case "btns_crnt_scc_cd":	// Location Popup
		        	var tmp = "SCC";
		            if(tmp == "RCC"){
		            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
		            	//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocationSCC", "1,0,1,1,1,1,1", true, false);
		            	ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);
		            } else if(tmp == "LCC") {
		            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
		            	//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocationSCC", "1,0,1,1,1,1,1", true, false);
		            	ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);	            		
		            } else if(tmp == "SCC") {
	            		if(formObject.crnt_loc_cd.value == '')
	            		{
	            			//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
	            			//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocationSCC", "1,0,1,1,1,1,1", true, false);
	            			ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);
	            		}else
	            		{
	            			var lccArea = "?lcc_cd="+formObject.crnt_loc_cd.value;
	            			//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
	            			//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocationSCC", "1,0,1,1,1,1,1", true, false);
	            			ComOpenPopup('/hanjin/COM_ENS_051.do'+lccArea, 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);
	            		}
		            }
		            break;       
	            case "btns_Calendar2" :		// Agreement Date (To Date)
	            	//var cal = new ComCalendar();
					var cal = new ComCalendarFromTo();
	            	//cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
		    		cal.select(formObject.inq_fm_dys,  formObject.inq_to_dys,  'yyyy-MM-dd');
		    		//cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheet_obj	필수
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
			
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
       		//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
       		//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    }

     /**
     * Sheet 로딩 후 기본 설정 및 초기화 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.10.20
     */     
    function sheet1_OnLoadFinish(sheetObj) {
        var formObject = document.form;    	
        sheetObj.WaitImageVisible = false;
	 
      	// axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
      	//axon_event.addListener('change', 'obj_change' , 'scc_cd'); 멀티콤보로 바뀌면 이벤트를 이걸로 등록하면 안된다.   
      	axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
      	//axon_event.addListener('keyup', 'enterFire', 'scc_cd'); 멀티콤보로 바뀌면 이벤트를 이걸로 등록하면 안된다.
      	axon_event.addListener('keyup', 'enterFire', 'inq_fm_dys');
      	axon_event.addListener('keyup', 'enterFire', 'inq_to_dys');
      	axon_event.addListenerForm('keyup', 'obj_keyup', form);
   	    axon_event.addListenerForm('focusout', 'obj_focusout',form);
   	    
     	// Multi Combo 초기화
     	//chungpa 20091016 scc_cd to multicombo
     	comboObjects[comboCnt++] = document.scc_cd;

      	for(var k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k]);
        }
      	/*
     	//chungpa 20091016 scc_cd to multicombo
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
     	*/
    	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	 
        initControl();
      	        
        sheetObj.WaitImageVisible = true; 
    }

      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  없음
       * @return 없음
       * @author 조재성
       * @version 2009.08.13
       */
     function initControl(){
      	 var formObj = document.form;
      	 var sheetObj1 = sheetObjects[0];
         var sheetObj2 = sheetObjects[1];
         var sheetObj3 = sheetObjects[2];
         var sheetObj4 = sheetObjects[3];
      	 
      	 // Form Object 초기화
      	 with(formObj){
      	     crnt_loc_cd.value = "";
      	     scc_cd.value = "";
             inq_fm_dys.value = "";
             inq_to_dys.value = "";
             
             inven20.value = "";
             inven40.value = "";
             inven45.value = "";
             
             avail20.value = "";
             avail40.value = "";
             avail45.value = "";
             
             assigned20.value = "";
             assigned40.value = "";
             assigned45.value = "";
    		
             usage20.value = "";
             usage40.value = "";
             usage45.value = "";
    		
             util20.value = "";
             util40.value = "";
             util45.value = "";             
         }
      	 
      	 // Sheet Object 초기화
      	 sheetObj1.RemoveAll();
         sheetObj2.RemoveAll();
         sheetObj3.RemoveAll();
         sheetObj4.RemoveAll();
    	 
         formObj.crnt_loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다.
     }

  /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * @param  {object} sheetObj	필수	 Sheet Object
      * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 조재성
      * @version 2009.08.13
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
	var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);
                    
                    var HeadTitle = "||20'|40'|45'";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) 
                     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  	 false,   "HidStatus");
                    InitDataProperty(0, cnt++ , dtData,  		195,   daCenter,  	 false,   "cnmv_sts_cd",		false,	"",	dfNone,			0,     false,       true);
                    InitDataProperty(0, cnt++ , dtAutoSum,   	150,   daRight,  	 false,   "chss_20ft_vol_qty",  false,  "",	dfNullInteger,	0,     false,       true);
					InitDataProperty(0, cnt++ , dtAutoSum,  	150,   daRight,      false,   "chss_40ft_vol_qty",  false,	"",	dfNullInteger,	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtAutoSum,    	100,   daRight, 	 false,   "chss_45ft_vol_qty",  false,  "",	dfNullInteger,	0,     false,       true);
 
                    CountPosition = 0;
                    
                    EditableColorDiff = false;
               }
                break;


            case "sheet2":      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 140;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);
                    
                    var HeadTitle = "||20'|40'|45'";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) 
                     
                     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,	daCenter,	false,   "HidStatus");
                    InitDataProperty(0, cnt++ , dtData,  		195,	daCenter,	false,   "cnmv_sts_cd",			false,	"",		dfNone,   		0,     false,       true);
                    InitDataProperty(0, cnt++ , dtAutoSum,   	150,	daRight,	false,   "chss_20ft_vol_qty",   false,  "",		dfNullInteger,  0,     false,       true);
                    InitDataProperty(0, cnt++ , dtAutoSum,  	150,	daRight,	false,   "chss_40ft_vol_qty",   false,  "",		dfNullInteger,  0,     false,       true);
                    InitDataProperty(0, cnt++ , dtAutoSum,    	100,	daRight,	false,   "chss_45ft_vol_qty",   false,  "",		dfNullInteger,  0,     false,       true);

                    CountPosition = 0;

                    EditableColorDiff = false;
               }
                break; 

            case "sheet3":      //sheet3 init

	         	with (sheetObj) {
	            	
	            	// 높이 설정
	                style.height = 140;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 6, 100);
	                
	                var HeadTitle = "||20'|40'|45'";
	                var headCount = ComCountHeadTitle(HeadTitle);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false) 
	                 
	                 
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,  30,	daCenter,	false,   "HidStatus");
	                InitDataProperty(0, cnt++ , dtData,  		195,	daCenter,	false,   "cnmv_sts_cd",			false,	"",		dfNone,   		0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,   		150,	daRight,	false,   "chss_20ft_vol_qty",   false,  "",		dfNullInteger,  0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,  		150,	daRight,	false,   "chss_40ft_vol_qty",   false,  "",		dfNullInteger,  0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,   	 	100,	daRight,	false,   "chss_45ft_vol_qty",   false,  "",		dfNullInteger,  0,     true,       true);
	
	                CountPosition = 0;
	
	                EditableColorDiff = false;
	           	}
                break;
            case "sheet4":      //sheet3 init

	         	with (sheetObj) {
	            	
	            	// 높이 설정
	                style.height = 140;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 6, 100);
	                
	                var HeadTitle = "||20'|40'|45'";
	                var headCount = ComCountHeadTitle(HeadTitle);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false) 
	                 
	                 
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,  30,	daCenter,	false,   "HidStatus");
	                InitDataProperty(0, cnt++ , dtData,  		195,	daCenter,	false,   "cnmv_sts_cd",			false,	"",		dfNone,   	0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,   		150,	daRight,	false,   "chss_20ft_vol_qty",   false,  "",		dfNumber,  	0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,  		150,	daRight,	false,   "chss_40ft_vol_qty",   false,  "",		dfNumber,  	0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,    		100,	daRight,	false,   "chss_45ft_vol_qty",   false,  "",		dfNumber,  	0,     true,       true);
	
	                CountPosition = 0;
	
	                EditableColorDiff = false;
	           	}
            break;                
                
        }
    }

   /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 조재성
     * @version 2009.07.30
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
         	case IBSEARCH:      //조회
 	        	// Form Object 값 설정
         		formObj.f_cmd.value = SEARCH;
	 			// 조회실행
	 			if(validateForm(sheetObj,formObj,sAction))
	 			{
			 		sheetObj.WaitImageVisible=false;
			 		ComOpenWait(true);
	 				
	 				var sXml = sheetObj.GetSearchXml("EES_CGM_1112GS.do" , FormQueryString(formObj));
	 				var arrXml = sXml.split("|$$|");
	 				if(arrXml.length>0)sheetObjects[0].LoadSearchXml(arrXml[0]);
	 				if(arrXml.length>1)sheetObjects[1].LoadSearchXml(arrXml[1]);
	 				if(arrXml.length>2)sheetObjects[2].LoadSearchXml(arrXml[2]);
	 				if(arrXml.length>3)sheetObjects[3].LoadSearchXml(arrXml[3]);

			 		ComOpenWait(false);
	 				
	 				//chassis inventory fill
	 				if(sheetObjects[2].RowCount > 0)
	 				{
	 					formObj.inven20.value = sheetObjects[2].CellText(1,"chss_20ft_vol_qty");
	 					formObj.inven40.value = sheetObjects[2].CellText(1,"chss_40ft_vol_qty");
	 					formObj.inven45.value = sheetObjects[2].CellText(1,"chss_45ft_vol_qty");
	 				}
	 				if(sheetObjects[3].RowCount == 3)
	 				{
	 					sheetObjects[3].DataInsert(4);
	 					sheetObjects[3].CellValue(4,"cnmv_sts_cd") = "Utilization(%)";
	 					var tFlo = parseFloat(sheetObjects[3].CellValue(3,"chss_20ft_vol_qty"))
							/	parseFloat(sheetObjects[3].CellValue(2,"chss_20ft_vol_qty")) * 100;
	 					sheetObjects[3].CellValue(4,"chss_20ft_vol_qty") =	returnFloat(tFlo);
	
	 					var tFlo = parseFloat(sheetObjects[3].CellValue(3,"chss_40ft_vol_qty"))
						/	parseFloat(sheetObjects[3].CellValue(2,"chss_40ft_vol_qty")) * 100;
	 					sheetObjects[3].CellValue(4,"chss_40ft_vol_qty") =	returnFloat(tFlo);
	 					
	 					var tFlo = parseFloat(sheetObjects[3].CellValue(3,"chss_45ft_vol_qty"))
						/	parseFloat(sheetObjects[3].CellValue(2,"chss_45ft_vol_qty")) * 100;
	 					sheetObjects[3].cellValue(4,"chss_45ft_vol_qty") =	returnFloat(tFlo);
	 				}
	 				
	 				//Available Chassis는 수동으로 계산한다. START
	 				var invt20 = sheetObjects[2].CellValue(1,"chss_20ft_vol_qty");
	 				var invt40 = sheetObjects[2].CellValue(1,"chss_40ft_vol_qty");
	 				var invt45 = sheetObjects[2].CellValue(1,"chss_45ft_vol_qty");
	 				if(invt20=="")invt20 = 0;
	 				if(invt40=="")invt40 = 0;
	 				if(invt45=="")invt45 = 0;
	 				var weel20= sheetObjects[0].SumValue(0,"chss_20ft_vol_qty");
	 				var weel40= sheetObjects[0].SumValue(0,"chss_40ft_vol_qty");
	 				var weel45= sheetObjects[0].SumValue(0,"chss_45ft_vol_qty");
	 				if( weel20=="")weel20 = 0;
	 				if( weel40=="")weel40 = 0;
	 				if( weel45=="")weel45 = 0;
	 				//alert("invt20:"+invt20+ " invt40:"+invt40+ " invt45:"+invt45);
	 				//alert("weel20:"+weel20+ " weel40:"+weel40+ " weel45:"+weel45);
	 				sheetObjects[3].CellValue(1,"chss_20ft_vol_qty") = invt20 - weel20;
	 				sheetObjects[3].CellValue(1,"chss_40ft_vol_qty") = invt40 - weel40;
	 				sheetObjects[3].CellValue(1,"chss_45ft_vol_qty") = invt45 - weel45;
	 				//alert(sheetObjects[0].CellValue(sheetObjects[0].rowCount+1,1));
	 				formObj.avail20.value		= sheetObjects[3].CellText(1,"chss_20ft_vol_qty");
	 				formObj.avail40.value		= sheetObjects[3].CellText(1,"chss_40ft_vol_qty");
	 				formObj.avail45.value		= sheetObjects[3].CellText(1,"chss_45ft_vol_qty");
	 				//Available Chassis는 수동으로 계산한다. END
	 				
	 				formObj.assigned20.value	= sheetObjects[3].CellText(2,"chss_20ft_vol_qty");
	 				formObj.assigned40.value	= sheetObjects[3].CellText(2,"chss_40ft_vol_qty");
	 				formObj.assigned45.value	= sheetObjects[3].CellText(2,"chss_45ft_vol_qty");
	 				
	 				formObj.usage20.value 		= sheetObjects[3].CellText(3,"chss_20ft_vol_qty");
	 				formObj.usage40.value 		= sheetObjects[3].CellText(3,"chss_40ft_vol_qty");
	 				formObj.usage45.value 		= sheetObjects[3].CellText(3,"chss_45ft_vol_qty");
	 				
            		formObj.util20.value		= sheetObjects[3].CellText(4,"chss_20ft_vol_qty") + "%";
            		formObj.util40.value		= sheetObjects[3].CellText(4,"chss_40ft_vol_qty") + "%";
            		formObj.util45.value		= sheetObjects[3].CellText(4,"chss_45ft_vol_qty") + "%";
            		
	 			}
	 			break;

	  	    case IBSEARCH_ASYNC08:
	  	       	//formObj.f_cmd.value = SEARCH;
	  	       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
	  	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
		   		formObj.f_cmd.value = SEARCH17;
		    	var location = "LCC";
		    	if(location == "RCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "RCC";
		    		formObj.eq_orz_cht_rcc_cd.value = formObj.crnt_loc_cd.value;
		    	}else if(location == "LCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "LCC";
		    		formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
		    	}else if(location == "SCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "SCC";
		    		formObj.eq_orz_cht_scc_cd.value = formObj.crnt_loc_cd.value;
		    	}else
		    	{
		    		formObj.eq_orz_cht_chktype.value = "";
		    		formObj.eq_orz_cht_scc_cd.value = "";
		    	}
	     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	     		
	  	   		// 데이터 건수
	  	        var dataCount = ComGetTotalRows(sXml);
	  	        if(dataCount==0){
	  	        	ComShowCodeMessage('CGM10009','location cd');
	  		   		formObj.crnt_loc_cd.value = "";
	  	        }else
	  	        {
    	        	/*
	  	        	//LCC가 정확히 체크된후
	  	        	//SCC를 다시한번 체크하여 LCC산하의 SCC인지 확인한다. 
	  	        	//만약 LCC산하의 SCC가 아니라면,SCC는 초기화된다. 
	  	        	if(formObj.scc_cd.value != ''){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC09);
	    	 		}*/
	    	 		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10); // SCC를 재구성해준다. 
	  	        }
	  	        
	  	        
	  	        // chungpa 20100414 keyup->focusout start	
	  	        //formObj.crnt_loc_cd.focus(); //validation후 focus는 location으로 가게 만든다.
	  	        // chungpa 20100414 keyup->focusout end	
	  	   		break;	
	  	    case IBSEARCH_ASYNC09:
	  	       	//formObj.f_cmd.value = SEARCH;
	  	       	//formObj.loc_cd.value = formObj.scc_cd.value;			//   ( location)
	  	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	  	       	var sXml;
	  	    	if(formObj.crnt_loc_cd.value == '') // scc_cd 단독체크
	  	    	{
			   		formObj.f_cmd.value = SEARCH17;
			    	var location = "SCC";
			    	if(location == "RCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value = "RCC";
			    		formObj.eq_orz_cht_rcc_cd.value = formObj.scc_cd.value;
			    	}else if(location == "LCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value = "LCC";
			    		formObj.eq_orz_cht_lcc_cd.value = formObj.scc_cd.value;
			    	}else if(location == "SCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value = "SCC";
			    		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
			    	}else
			    	{
			    		formObj.eq_orz_cht_chktype.value = "";
			    		formObj.eq_orz_cht_scc_cd.value = "";
			    	}
		     		sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	  	    	}else // LCC산하의 SCC체크 
	  	    	{
			   		formObj.f_cmd.value = SEARCH17;
			    	var location = "LCCSCC";
			    	if(location == "LCCSCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value = "LCCSCC";
			    		formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
			    		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
			    	}else
			    	{
			    		formObj.eq_orz_cht_chktype.value = "";
			    		formObj.eq_orz_cht_lcc_cd.value = "";
			    		formObj.eq_orz_cht_scc_cd.value = "";
			    	}
		     		sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));	  	    		
	  	    	}

	  	   		// 데이터 건수
	  	        var dataCount = ComGetTotalRows(sXml);
	  	        if(dataCount==0){
	  	        	ComShowCodeMessage('CGM10009','location cd');
	  		   		formObj.scc_cd.value = "";
	  		   		formObj.scc_cd.focus();
	  	        }
	  	   		break;	

        	case IBSEARCH_ASYNC10:
		       	formObj.f_cmd.value = SEARCH17;
		       	
		       	formObj.eq_orz_cht_us_flag.value = 'Y';		// US만 설정(SCC_CD가 많기 때문에 설정함.
		       	if(formObj.crnt_loc_cd.value == '') // SCC 단독체크
		       	{
		       		formObj.eq_orz_cht_chktype.value = "SCC";
		       		formObj.eq_orz_cht_scc_cd.value = "%%";
		       	}else //LCCSCC체크
		       	{
		       		formObj.eq_orz_cht_chktype.value = "LCCSCC";
		       		formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
		       		formObj.eq_orz_cht_scc_cd.value = "%%";
		       	}
		   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		var sStr = ComGetEtcData(sXml,"comboList");    			
		   		var arrStr = sStr.split("@");
		  		makeComboObject(formObj.scc_cd, arrStr, 0, 0, 0);
		  		document.scc_cd.DeleteItem(0);
		  		
		  		formObj.eq_orz_cht_us_flag.value = '';		// US만 설정 해제.
		  		
        		break;


         	case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;
				
        	case IBRESET:
        		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
        		break;				
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 조재성
     * @version 2009.08.10
     */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction){
    			case IBSEARCH:
    				//if(crnt_loc_cd.value == '' && scc_cd.value == '' ){
    				if(crnt_loc_cd.value == '' && scc_cd.Code == ''){
    					ComShowCodeMessage('CGM10004','Location');
    					crnt_loc_cd.focus();
    					return false;
    				} 

    				if(crnt_loc_cd.value != ''){
    					if(crnt_loc_cd.value.length != 5) // Location 자리수 고정 size=5
    					{
    						ComShowCodeMessage('CGM10044','LCC(5)');
    						crnt_loc_cd.focus();
    						return false;
    					}
    				}
                                /*
    				if(scc_cd.value != ''){
    					if(scc_cd.value.length != 5) // Location 자리수 고정 size=5
    					{
    						ComShowCodeMessage('CGM10044','SCC(5)');
    						scc_cd.focus();
    						return false;
    					}
    				}*/

     		 		if(inq_fm_dys.value == ''){
            				ComShowCodeMessage('CGM10004','Period ');
            				inq_fm_dys.focus();
            				
            				return false;
            			}	
     		 		if(inq_to_dys.value == ''){
            				ComShowCodeMessage('CGM10004','Period ');
            				inq_to_dys.focus();
            				
            				return false;
            			}
     		 		 var dt_str = ComReplaceStr(document.form.inq_fm_dys.value,"-","");
         			 var dt_end = ComReplaceStr(document.form.inq_to_dys.value,"-","");
     	        	
   
     	    		if(dt_str != '' && dt_end != ''){
     	    			if(dt_end < dt_str){
     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
     	    				inq_fm_dys.value='';
     	    				
     	    				inq_fm_dys.focus();
     	    				return false;
     	    			}
     	    		}

 			  		var startDt = new Date();
		    		var endDt = new Date();
		    		endDt.setFullYear(parseInt(dt_end.substring(0,4)));
		    		endDt.setMonth(parseInt(dt_end.substring(4,6)-'00'));
		    		endDt.setDate(parseInt(dt_end.substring(6,8)-'00'));
		    			    		
		    		startDt.setFullYear(parseInt(dt_str.substring(0,4)));
		    		startDt.setMonth(parseInt(dt_str.substring(4,6)-'00'));
		    		startDt.setDate(parseInt(dt_str.substring(6,8)-'00'));
		    		
		    		//ComDebug("  END getYear:"+ endDt.getYear()+ " getMonth:"+ endDt.getMonth() +  " getDate:"+ endDt.getDate());
		    		//ComDebug("  START getYear:"+ startDt.getYear()+ " getMonth:"+ startDt.getMonth() +  " getDate:"+ startDt.getDate());
			 		var resultDt1 = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));
			 		//alert("resultDtl: " + resultDt1);
			 		if(resultDt1 > 365*2) //2년보다 검색기간이 길면 오류
			 		{	
			 			ComShowCodeMessage('CGM10011');
			 			inq_fm_dys.value = "";
			 			inq_to_dys.value = "";
			 			inq_fm_dys.focus();
			 			return false
			 		}
			 		
    				break;
                }
    	}
        return true;
    }

    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */   
    function callBackLocation(aryPopupData, row, col, sheetIdx){
         	 
        var formObj = document.form;
        var location = "LCC";
        var crntLocCd = "";
        var i = 0;
        
        for(i = 0; i < aryPopupData.length; i++){
        	if(location == 'RCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][11];
        	} else if(location == 'LCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][10];
        	} else if(location == 'SCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][8];
        	}
         		
        	if(i < aryPopupData.length - 1){
        		crntLocCd = crntLocCd + ",";
         	}
        }
         	 
        formObj.crnt_loc_cd.value = crntLocCd;
         	 
    }

    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */   
    function callBackLocationSCC(aryPopupData, row, col, sheetIdx){
         	 
        var formObj = document.form;
        var location = "SCC";
        var crntLocCd = "";
        var i = 0;
        
        for(i = 0; i < aryPopupData.length; i++){
        	if(location == 'RCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][11];
        	} else if(location == 'LCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][10];
        	} else if(location == 'SCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][8];
        	}
         		
        	if(i < aryPopupData.length - 1){
        		crntLocCd = crntLocCd + ",";
         	}
        }
         	 
        formObj.scc_cd.value = crntLocCd;
         	 
    }
    /**
     * Sheet1 의 OnChangeSum 이벤트처리 <br>
     * @param  {object} sheetObj	필수 Sheet Object
     * @param  {String} Row		필수 String
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */ 	
	function sheet1_OnChangeSum(sheetObj, Row )
	{
		with(sheetObj)
		{
			//SumText(0,"Seq") = "";
			//SumText(0,"location") = "Grand Total";
			
			//CellAlign(Row, "location") = daCenter;
		}
	} 

    /**
     * Sheet1 의 OnSearchEnd 이벤트처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} ErrMsg		필수 String
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */ 	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
 
		//sheetObj.ShowSubSum("location", "3|4|5|6",-1, false, false, -1,"Seq=;location=Sub Total");
	
	}

     /** 
      * Object 의 deactivate 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */
      function domFunFocusDel(a)
      {
      	var formObj = document.form;
        	 obj = event.srcElement;
        	if(obj.name=="evnt_dt_str"  ){
     			
        		document.form.evnt_dt_str.value = ComReplaceStr(document.form.evnt_dt_str.value,"-","");
            }
          if(obj.name=="evnt_dt_end"  ){
     			
          		document.form.evnt_dt_end.value = ComReplaceStr(document.form.evnt_dt_end.value,"-","");
           }
      	
         //ComShowMessage("domFunFocusDel");
      }

     /** 
      * Object 의 activate 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.13
      */
     function obj_activate(){
       	ComClearSeparator(event.srcElement);
     } 

     /** 
      * Object 의 deactivate 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.07.31
      */
     function obj_deactivate(){
     	 var formObj = document.form;
     	 obj = event.srcElement;

     	 if(obj.name=="inq_fm_dys"  ){
         			
     		 with(formObj){
  	        			
     			 var creDtFr = ComReplaceStr(inq_fm_dys.value,"-","");
  	        }
  	        	
  	        ComChkObjValid(event.srcElement);
         }
       	if(obj.name=="inq_to_dys"  ){
  			
    		 with(formObj){
  	        			
    			 var creDtFr = ComReplaceStr(inq_to_dys.value,"-","");
  	        }
  	        	
  	        ComChkObjValid(event.srcElement);
        }
         	
     }	

     /** 
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.13
      */ 
     function obj_keypress(){
       	obj = event.srcElement;
       	if(obj.dataformat == null) return;
       	 	
       	window.defaultStatus = obj.dataformat;
       	 
       	switch(obj.dataformat) {
       	 	case "ym": case "ymd":
       	 		ComKeyOnlyNumber(obj);
       	 		break;
       	 	case "int":
       	 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
       	 		else ComKeyOnlyNumber(obj);
       	        break;
       	 	case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;    
       	    case "eng":
      	    	if(obj.name=="vndr_seq") 
      	    		ComKeyOnlyNumber(obj,",");
      	    	else 
      	    		ComKeyOnlyAlphabet();
       	        break;
       	    case "engup":
      	        if(obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="scc_cd") ComKeyOnlyAlphabet('upper',"44");//ComKeyOnlyAlphabet('uppernum',"44");
      	        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    case "engdn":
       	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
       	        else ComKeyOnlyAlphabet('lower');
       	        break;
       	}
     } 
     
     /** 
      * Object 의 change 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.13
      */  
     function obj_change(){
     	 var formObj = document.form;
     	 var sheetObj = sheetObjects[0]; 

     }

   /** 
     * Object 의 obj_focusout 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 최민회
     * @version 2009.05.20
     */  
    function obj_focusout(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 
     	 switch(obj.name)
     	 { 
    	    // chungpa 20100414 keyup->focusout start	  	 		 
		 	case "crnt_loc_cd":
			    var crnt_loc_cd;
			    crnt_loc_cd = formObj.crnt_loc_cd.value;
		    	if (crnt_loc_cd.length == 5) {
		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    		
		    	}
		    	break;	 	

		    // chungpa 20100414 keyup->focusout end
     	 }
       
    }

     /** 
      * Combo Object 초기화  <br>
      * @param  {object} comboObj	필수 Combo Object
      * @return 없음
      * @author 조재성
      * @version 2009.08.13
      */ 
     function initCombo(comboObj) {
     	switch(comboObj.id) {
 	    	case "location":
 	 	 		var cnt=0;
 	  	        with(comboObj) {
 	  	        	Code = "";
 	  	            Text = "";
 	  	            DropHeight = 100;
 	  	            MultiSelect = false;
 	  	            MaxSelect = 1;	    
 	  	            UseCode = true;
 	  	            Enable = true;
 	  	            comboObj.UseAutoComplete = true;
 	  	        }
 	  	        
 	  	        break;
  	        //chungpa 20091016 scc_cd to multicombo
 	    	case "scc_cd":
 	 	 		var cnt=0;
 	  	        with(comboObj) {
 	  	        	Code = "";
 	  	            Text = "";
 	  	            DropHeight = 300;
 	  	            MultiSelect = true; 
 	  	            MaxSelect = 100;	    
 	  	            UseCode = true;
 	  	            Enable = true;
 	  	            
 		        	ValidChar(2,2);         // 영어 대문자, 특수(',')
 		            IMEMode = 0;            // 영문
 		            MaxLength = 100;         // 100자까지 입력 	  
 		            comboObj.UseAutoComplete = true;
 	  	        }
 	  	    break;
     	}
     }   

     /** 
      * Combo Object 에 값을 추가하는 처리 <br>
      * @param  {object} cmbObj	필수 Combo Object
      * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
      * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
      * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
      * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
      * @return 없음
      * @author 김창식
      * @version 2009.07.16
      */ 
     function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
     	cmbObj.RemoveAll();
     	
     	if(opt == 0) {
     		for (var i = 0; i < arrStr.length;i++ ) {
     			var arrCode = arrStr[i].split("|");
         		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
             }
     	} else if(opt == 1){
     		cmbObj.InsertItem(0,"","");
     		for (var i = 0; i < arrStr.length;i++ ) {
     			var arrCode = arrStr[i].split("|");
         		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
             }
     	}
     	
     	cmbObj.Index2 = "" ;
     }  
 	
    /**
     * float값을 유효숫자(2자리)만큼 잘라내는 함수
     * @param	{text}	sVal	필수		숫자 텍스트 데이터
     * @return	{float} rVal			변환된 float데이터 
     */
    function returnFloat(sVal)
    {
    	var comp;
    	/* 바로 float값이 들어오기 때문에 텍스트 처리하지 않는다. 
    	if(strAllTrim(sVal)=="")
    		comp=0;
    	else
    		comp=parseFloat(sVal);
		comp = parseInt(comp*100)/100;    		
    	*/
    	comp = parseInt(sVal*100)/100;
    	return comp;
    }
    
     /** 
     * 기본조건 입력 후 ENTER키 적용 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.14
     */ 
     function enterFire() {
  	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
       if(event.keyCode == 13)
  	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
  	   }
    }    

/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
 	 	case "crnt_loc_cd":
		   // chungpa 20100414 keyup->focusout start
		   ComKeyEnter('lengthnextfocus');  
    		
	       /*
 	 	   //chungpa 20100114 enter combo error fix start
 	 	   if(event.keyCode == 13)
 	  	   {
 	 	       return;
 	  	   }	
 	 	   //chungpa 20100114 enter combo error fix end
 	 	   
	 		var crntLocCd = ComTrimAll(formObj.crnt_loc_cd.value);
	   		var arrCrntLocCd = crntLocCd.split(",");
	   		
	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntLocCd[i] == ''){
	 			
	 				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10); // SCC를 재구성해준다. 
	 			
	 				ComShowCodeMessage('CGM10009','Location');
	 				formObj.crnt_loc_cd.value = "";
	 				ComSetFocus(formObj.crnt_loc_cd);
	 				break;
	 			}else{
	    	 		//if(formObj.crnt_loc_cd.value != ''){
	    	 		if(formObj.crnt_loc_cd.value.length == 5){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
	    	 		}
	 			}
	   		}
	   		*/
	 		// chungpa 20100414 keyup->focusout end
	 		break;
	 	case "scc_cd":
 	 	   //chungpa 20100114 enter combo error fix start
 	 	   if(event.keyCode == 13)
 	  	   {
 	 	       return;
 	  	   }	
 	 	   //chungpa 20100114 enter combo error fix end
 	 	   
	 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
	   		if( formObj.scc_cd.value.search(',') > 0 || (formObj.scc_cd.value == '')) // 다중 scc_cd code(,로 연결됨)이면 검사하지 않는다. 
	   		{
	   			break;
	   		}    	 		
	   		var arrCrntLocCd = crntLocCd.split(",");
	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntLocCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Location');
	 				formObj.scc_cd.value = "";
	 				ComSetFocus(formObj.scc_cd);
	 				break;
	 			}else{
	    	 		//if(formObj.scc_cd.value != ''){
	    	 		if(formObj.scc_cd.value.length == 5){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC09);
	    	 		}
	 			}
	   		}
	 		break;
    	 }
}      
	/* 개발자 작업  끝 */