/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0122.js
*@FileTitle : Damage Flagging/Unflagging
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation 
* -----------------------------------------------------------------------------
* History
* 2012.11.20  조경완 [CHM-201221414-01] [MNR] Damage Flagging/Unflagging [EES_MNR_0122, EES_MNR_S122] OOME 해결을 위한 Validation Script 추가
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
     * @class EES_MNR_0122 : EES_MNR_0122 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0122() {
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

//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
var uTpSz = new Array();    
var gTpSz = new Array();  
var zTpSz = new Array();          

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

                case "btn_retrive":     
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break; 
 
		        case "btn_new": 
                    doActionIBSheet(sheetObject,formObject,IBCLEAR); 
                    break;
 
		        case "btn_save":      
                    doActionIBSheet(sheetObject,formObject,IBSAVE); 
                    break;    

		        case "btn_downExcel":         
					sheetObject.SpeedDown2Excel(-1);       
                    break; 
					  
		        case "btns_popup":                 
                    ComOpenPopup('/hanjin/COM_ENS_061.do', 766, 450, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;                
 			    	   
		        case "btn_loadExcel": 
					  allSheetClr();               
					  ComOpenPopup('/hanjin/EES_MNR_0139.do?eq_type=' + formObject.eq_knd_cd.Code, 798, 511, 'getEES_MNR_0139', '1,0,1,1,1,1,1,1,1,1,1,1', false); 
                    break;                 
  				 	
		        case "btns_req_multy2":           
                    rep_Multiful_inquiry("eq_tpsz_cd");         
                    break;     
				  	  
		        case "btns_calendar":        
                    var cal = new ComCalendar();     
	                cal.select(formObject.mnr_dmg_flg_dt, 'yyyy-MM-dd');
	                break;  
				
				//멀티입력
				case "eq_no_multi": 
				    rep_Multiful_inquiry("eq_list"); 
					break; 	 
   				 
            } // end switch  
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e); 
    		} else {
    			ComFuncErrMsg(e);  
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
		MnrWaitControl(true); 
   		initControl();   	
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경 
            ComConfigSheet (sheetObjects[i] ); 
            initSheet(sheetObjects[i],i + 1);
        	//khlee-마지막 환경 설정 함수 추가 
            ComEndConfigSheet(sheetObjects[i]); 
        }      
				
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1); 
	    }
				        
		for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }
			
		setTpSzArray(sheetObjects[0]);    		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
 	    
	function setTpSzArray(sheetObj){ 
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
			 
		if(arrXml != null){          
		    for(var i = 0; i < arrXml.length; i++){   
				if(i == 0){	       
					uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
				} else if(i == 1){	  
					zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");  
				} else if(i == 2){	    
					gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
				}	  	 
		    }  	 
		}				
	} 	
	
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){      
    	comboObjects[comboCnt++] = combo_obj;  
	}      
	  
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    //var cnt  = 0 ; 
	    var formObject = document.form;        
	      
	    switch(comboNo) {    
	          case 1: 		
			  case 2:	 	
	           with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
		       }      	
	           break; 
					  	 
			   case 3:	 
			   with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("230");  
					DropHeight = 200;
					ValidChar(2,3);   
			   }    
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
                    style.height = 422;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);   

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);  
  						
                    var HeadTitle = "|Seq.|Flag|EQ Type|EQ No.|TP/SZ|Yard|Flag Date|Over Days|Remark(s)";
   
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					 	
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		50,	daCenter,	false,	"ibflag"); 
                    InitDataProperty(0, cnt++ , dtDataSeq,    		40, daCenter,  	true,   "Seq",     					false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtCheckBox,    		50, daCenter,  	true,   "mnr_dmg_flg",     			false,  "", dfNone);
					InitDataProperty(0, cnt++ , dtCombo,      		60, daCenter,  	false,  "eq_knd_cd",     			false,  "", dfNone,		0,	false,	false);   
                    InitDataProperty(0, cnt++ , dtData,      		80, daCenter,  	false,  "eq_no",     				true,   "", dfNone,		0,	false,	false);   
                    InitDataProperty(0, cnt++ , dtData,      		40, daCenter,  	false,  "eq_tpsz_cd",     			false,  "", dfNone,		0,	false,	false);   
   
                    InitDataProperty(0, cnt++ , dtData,      		60, daCenter,  	false,  "mnr_dmg_flg_yd_cd",     	true,   "", dfNone,		0,	true,	true,	7,	true);        
                    InitDataProperty(0, cnt++ , dtPopupEditFormat,	80, daCenter,  	false,  "mnr_dmg_flg_dt",     		true,   "", dfDateYmd,	0,	true,	true);         
                    InitDataProperty(0, cnt++ , dtData,      		65, daCenter,  	false,  "mnr_dmg_flg_dt_over_day",	false,  "DateDiff(d, |7|," + ComGetNowInfo("ymd") + ") + 1",	dfNone,	0,	false,	false);   
                    InitDataProperty(0, cnt++ , dtData,      		90, daLeft,  	false,  "mnr_sts_rmk",     			false,  "", dfNone,		0,	true,	true,	4000);                
					   	  
					InitDataValid(0,  "mnr_dmg_flg_yd_cd", vtEngUpOther,"0123456789");      		   
					PopupImage  =  "/hanjin/img/btns_calendar.gif";
            		ShowButtonImage = 2;              	   
				  	        	              
					//로우한개씩 선택          
					MultiSelection = false;     
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트 함       
					SelectHighLight = true;         
					//선택시 볼드체 변경 안함           
					SelectFontBold = false;  
					//SELECT 로우 배경색             
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);    
					CountPosition = 2;            
               }         
                break;  

  					
             case 2:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 62;  
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                   
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 3, 11);             
                  
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);  

                    var HeadTitle = "상태"; 
                  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false, true);   

                    var Title1 = 90;
                    var Title2 = 90
                    var  MANU = 80;
                    var  Owner = 50; 

                    //1
                    var drCnt = 0;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    MANU,    daCenter,  false,    "MANU",  false,     "",      dfDateYmd,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Owner,    daLeft,  false,    "Owner",  false,     "",      dfNone,        0,          false,        false);

                    //2
                    drCnt++;
                    cnt = 0;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(1, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    MANU,    daCenter,  false,    "Lease",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Owner,    daLeft,  false,    "Disposal",  false,     "",      dfNone,        0,          false,        false);

                    //3
                    drCnt++;
                    cnt = 0;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    MANU,    daCenter,  false,    "Off",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Owner,    daLeft,  false,    "Imm",  false,     "",      dfNone,        0,          false,        false);
 
                    CountPosition = 0;  
                    DataRowHeight = 10; 
                    SelectFontBold = false;
                    ScrollBar  = 0;
					SelectHighLight = false;

                    shtClear(sheetObj);
               }
                break;


              case 3:      //t1sheet1 init
                with (sheetObj) {

                        // 높이 설정
                    style.height = 65; 
                    //전체 너비 설정   
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                  
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 3, 9);  
                  
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    var HeadTitle = "상태";
                  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true, true);

                    var Title1 = 90;
                    var Title2 = 90
                    var  TYPE = 80;
                    var  Status = 50;

                    //1
                    var drCnt = 0;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    TYPE,    daCenter,  false,    "TYPE",  false,     "",      dfDateYmd,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Status,    daLeft,  false,    "Status",  false,     "",      dfNone,        0,          false,        false);

                    //2
                    drCnt++;
                    cnt = 0;
					  
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(1, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    TYPE,    daCenter,  false,    "Yard",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Status,    daLeft,  false,    "Date",  false,     "",      dfDateYmd,        0,          false,        false);

                    //3     
                    drCnt++;
                    cnt = 0;
              			  
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(1, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    TYPE,    daLeft,  false,    "Provider",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    Status,    daLeft,  false,    "Cost",  false,     "",      dfNone,        0,          false,        false);
					    	   
                    CountPosition = 0;
                    DataRowHeight = 10; 
                    SelectFontBold = false; 
                    ScrollBar  = 0; 
					SelectHighLight = false;
   
                    DataRowMerge(2) = true;
                    DataRowMerge(3) = true;
  
                    shtClear(sheetObj);
               }    
                break;

              case 4:      //t1sheet1 init
                with (sheetObj) {

                     // 높이 설정
                    style.height = 30;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                  
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9);
                  
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);
	
                    var HeadTitle = "상태";
                  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false, true);
 					  
                    var Title1 = 90;
                    var  Title2 = 90;
                    var MVSTS = 80;
                    var  MVSTDT = 50;
 					  
                    //1     
                    var drCnt = 0; 
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(drCnt, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "Status");
                    InitDataProperty(drCnt, cnt++ , dtData,    Title1,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    MVSTS,    daCenter,  false,    "STS",  false,     "",      dfNone,        0,          false,        false);
      				InitDataProperty(drCnt, cnt++ , dtData,    Title2,    daCenter,  false,    "",  false,     "",      dfNone,        0,          false,        false);
                    InitDataProperty(drCnt, cnt++ , dtData,    MVSTDT,    daCenter,  false,    "Date",  false,     "",      dfDateYmd,        0,          false,        false);
                    
                    CountPosition = 0;
                    DataRowHeight = 10;      
                    SelectFontBold = false; 
                    ScrollBar  = 0; 
					SelectHighLight = false;  
  
                    shtClear(sheetObj);
               }
                break;

             case 5:      //sheet5 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 255;
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
  					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);
					 	
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					  
                    var HeadTitle = "|Seq.|Yard|Date|Flag|Method|Remark(s)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
  
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,0 );
                    InitDataProperty(0, cnt++ , dtDataSeq,	 40,    daCenter );
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "mnr_flg_yd_cd",     false,          "",      dfNone      ,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  false,     "mnr_flg_inp_dt",     false,          "",      dfDateYmd    ,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "mnr_sts_flg",     false,          "",      dfNone     ,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtCombo,     60,    daCenter,  false,     "mnr_flg_inp_tp_cd",     false,          "",      dfNone     ,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      80,    daLeft,  false,     "mnr_flg_rmk",     false,          "",      dfNone     ,		0,			false,		false);   
								   	            
					InitDataValid(0,  "mnr_flg_yd_cd", vtEngUpOther,"0123456789");             
					//로우한개씩 선택        
					MultiSelection = false;   
					SelectionMode = smSelectionRow; 
					//선택시 하이라이트 함       
					SelectHighLight = true;  
					//선택시 볼드체 변경 안함           
					SelectFontBold = false;  
					//SELECT 로우 배경색             
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);    
					CountPosition = 0;           
               }
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        
        switch(sAction) {
    
           case IBSEARCH:      //조회   
                 if(validateForm(sheetObj,formObj,sAction)){
				 	allSheetClr();  
				 	if(sheetObj.id =="sheet1"){       
						formObj.f_cmd.value = SEARCH;     
						//2012.11.14 조경완 [CHM-201221414-01] server단 validation logic 추가
         				var sXml = sheetObj.GetSearchXml("EES_MNR_0122GS.do", FormQueryString(formObj));
         				var validFlg = ComGetEtcData(sXml, "validFlg");
         				
         				if(validFlg == "N"){
         					ComShowCodeMessage("MNR00223");
         				}else{
         					sheetObj.LoadSearchXml(sXml);
         				}
					}         
				  }        
                break; 	
  
			 case IBSAVE:        //저장   
	              if(validateForm(sheetObj,formObj,sAction)){ 
				  	formObj.f_cmd.value = MULTI;                                                                  
					sheetObj.DoSave("EES_MNR_0122GS.do", FormQueryString(formObj),-1,false);	 	
				  }   
                break;
			
			case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화
                    MnrWaitControl(true);
                    sheetObj.WaitImageVisible=false;

					formObj.reset(); 
					//초기값 세팅   
					formObj.mnr_flg_tp_cd.value = coMnrFlgDamageTypeCd;   
					
					//IBMultiCombo 콤보 초기화   
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].Code = "-1"; 
						comboObjects[i].RemoveAll(); 	
					} 
					 					    
					//쉬트 콤보를 설정하기 위한 변수 
					var sheetComboText = "";  
					var sheetComboCode = "";
					var sheetComboDefault = "";  
							
					var sCondition = new Array ( 
					    new Array("MnrGenCd","","CUSTOM9"),
						new Array("MnrGenCd","CD00005", "COMMON") 
					)	         
						   
					var comboList = MnrComSearchCombo(sheetObj,sCondition); 
					
					//IBMultiCombo-EQ_TYPE 세팅
					if(comboList[0] != null){
						for(var j = 0; j < comboList[0].length;j++){ 
							var tempText = comboList[0][j].split("|");  
							
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							    	
							formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
							if(j == 0){      
								formObj.eq_knd_cd.Code = tempText[0]; 
								sheetComboDefault = tempText[0];       
							}   
						}  	
					}	
					
					//sheetObjects[0] eq_knd_cd 세팅
					sheetComboText = MnrDelLastDelim(sheetComboText);		
					sheetComboCode = MnrDelLastDelim(sheetComboCode);  			  
					sheetObj.InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode,sheetComboDefault); 
					 	
					//IBMultiCombo-flag_type 세팅  
					formObj.flag_type.InsertItem(0, "ALL" ,"ALL");     
					formObj.flag_type.InsertItem(1, "Flagged" ,"Y");   
					formObj.flag_type.InsertItem(2, "Unflagged" ,"N");   
					formObj.flag_type.Code = "ALL";   					
					
					//sheetObjects[4] mnr_flg_inp_tp_cd 세팅
					sheetComboText = "";     
					sheetComboCode = "";   
					sheetComboDefault = "";      
					  
					if(comboList[1] != null){     
				 		for(var j = 0; j < comboList[1].length;j++){ 
							var tempText = comboList[1][j].split("|");    
							  
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
						     	         
							if(j ==0){
								sheetComboDefault = tempText[0];       	
							}  
						}          
					}                             
							       
					//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다.
					sheetComboText = MnrDelLastDelim(sheetComboText);		
					sheetComboCode = MnrDelLastDelim(sheetComboCode);  
					  							  
					sheetObjects[4].InitDataCombo (0, "mnr_flg_inp_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault); 
					 	               
	      	   		allSheetClr();  
					sheetObj.WaitImageVisible = true;
                    MnrWaitControl(false);       
				break; 
			//2012.11.14 조경완 [CHM-201221414-01] Yard Code validation logic 추가
			case IBSEARCH_ASYNC01:	//조회(YARD 입력시 벨리데이션 )
				if ( validateForm(sheetObj, formObj, sAction) ) {  
						var checkYard = formObj.mnr_dmg_flg_yd_cd.value; 
								
						var retArray = MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);      
						if(retArray == null){        
							ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
							ComSetObjValue(formObj.mnr_dmg_flg_yd_cd, "");  	    
							ComSetFocus(formObj.mnr_dmg_flg_yd_cd);                   
						} else {    
							return;    
						}   	 
				}		
				break; 	  
        }      
		     
    }
	
	function allSheetClr(){   
		//쉬트 초기화        
		for(i=0;i<sheetObjects.length;i++){
			shtClear(sheetObjects[i]);      			
		}  
	}
		
	/**
     * 히스토리 테이블 조회 
     */  
	function doActionIBSheet2(sheetObj,formObj,sAction) {
           
        switch(sAction) {
    	 	         
           case IBSEARCH:      //조회   
			    if(sheetObj.id =="sheet5"){          
					formObj.f_cmd.value = SEARCH01;   
					sheetObj.WaitImageVisible = false;                         
     				sheetObj.DoSearch4Post("EES_MNR_0122GS.do",FormQueryString(formObj));	 	
					sheetObj.WaitImageVisible = true;    
				} 		       
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

                }
             break;

         } 
    }      
	  
	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	form); //- 변경될때.
	}              
		   
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}       
	    
	function obj_keypress(){   
	    obj = event.srcElement;   
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
			              
	    switch(obj.dataformat) { 
	        case "ymd":   
	        case "int":    
				ComKeyOnlyNumber(obj);
	            break; 
	        case "float":  
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":  
	            ComKeyOnlyAlphabet();
				break; 
	        case "engup":    
				if(obj.name == "mnr_dmg_flg_yd_cd")     
					ComKeyOnlyAlphabet('uppernum');     
				else 
					ComKeyOnlyAlphabet('uppernum','44');
	            break; 
	    }         
	}
	
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {       
				case "mnr_dmg_flg_yd_cd":  
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01); 
				   	break;   	
			}       
	    }	
	}    
	
	//eq_tpsz_cd 멀티콤보 클릭 이벤트
	function eq_tpsz_cd_OnCheckClick(comboObj, index, code) { 
		MnrAllChkMultiCombo(comboObj,index);   		  
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

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){ 
			if(sAction==IBSEARCH) {	      
				if (!ComChkValid(formObj)) return false; 
				//2012.11.15 조경완 [CHM-201221414-01]	 - ComTrim function 을 통해 공백이 입력되는 케이스도 validate 								
				if(ComTrim(ComGetObjValue(formObj.mnr_dmg_flg_yd_cd)) == "" && ComTrim(ComGetObjValue(formObj.eq_list)) == ""){
					ComShowCodeMessage("MNR00223");	    
					return false;							
				}      
			}   else if(sAction==IBSAVE){ 
				//저장의사 확인
				if(!ComShowCodeConfirm("MNR00160","")){return false;}
			}      	           
        }      
        return true; 
    }
	
	 
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form; 
		        
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")       
    	 	formObj.mnr_dmg_flg_yd_cd.value = aryPopupData[0][3];                                  
    }
	
	/**
	 * getEES_MNR_139 의 값을 받은 함수  
	 * @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE 	  	
	 * @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	 */
	function getEES_MNR_139(rArray,ret_val){
    	 var formObj = document.form;    
		 var firstSelect = 0;    
		 formObj.eq_knd_cd.Code = ret_val[0];   
    	 var mnr_dmg_flg = "0";       
		 if(ret_val[1] == "Y"){
		 	mnr_dmg_flg = "1";   	
		 } else {   
		 	mnr_dmg_flg = "0";                   
		 }
		 for(var i = 0;i <  rArray.length;i++){    
		 	 var Row = sheetObjects[0].DataInsert(-1);  
			 if(i == 0)  
			 	 firstSelect = Row;    
			 sheetObjects[0].CellValue2(Row,"eq_knd_cd") = formObj.eq_knd_cd.Code; 	
			 sheetObjects[0].CellValue2(Row,"mnr_dmg_flg") = mnr_dmg_flg;	
			 sheetObjects[0].CellValue2(Row,"eq_no") = rArray[i][0]; 	
			 sheetObjects[0].CellValue2(Row,"mnr_dmg_flg_yd_cd") = rArray[i][1];
			 sheetObjects[0].CellValue2(Row,"mnr_dmg_flg_dt") = rArray[i][2]; 	
			 sheetObjects[0].CellValue2(Row,"eq_tpsz_cd") = rArray[i][3];   	
		 }           
		        
		 //엑셀 로딩하고 초기 조회            
		 if(firstSelect != 0) {
		 	sheetObjects[0].SelectCell(firstSelect, "eq_no");   
			      
		 	var keyvalue = sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,"eq_no"); 
			var formObj = document.form;  
			formObj.eq_no.value = keyvalue;                 
		    // Detail 조회하기                 
		    doActionIBSheet2(sheetObjects[4], formObj, IBSEARCH);	    		 		
		 }                 
    }    
	
	/**  
	 * eq_knd_cd 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){ 
		var formObj = document.form; 
		var comboValue = comboObj.Code; 		   
		 			
		formObj.eq_tpsz_cd.RemoveAll();
		var selTpSz = new Array();
		if(comboValue == "U"){
			selTpSz = uTpSz;  	
		} else if(comboValue == "G"){
			selTpSz = gTpSz; 
		} else {
			selTpSz = zTpSz;   
		}     	
		//디폴트로 올삽입		  
		formObj.eq_tpsz_cd.InsertItem(0,"ALL","ALL");  		
		for(var i = 1;i < (selTpSz.length + 1);i++){            
			formObj.eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
		}	               
	}     
	
	/**  
	 * flag_type 체인지 이벤트       
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function flag_type_OnChange(comboObj,Index_Code, Text){
		var formobj = document.form;
		if(comboObj.Code == "N"){ 
			ComSetObjValue(formobj.mnr_dmg_flg_dt_over_day,"");
			MnrFormSetReadOnly(formobj,true,"mnr_dmg_flg_dt_over_day");
		} else {
			ComSetObjValue(formobj.mnr_dmg_flg_dt_over_day,"");
			MnrFormSetReadOnly(formobj,false,"mnr_dmg_flg_dt_over_day");  
		}		
	}  

	function sheet1_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "mnr_dmg_flg_dt") return;
        var cal = new ComCalendarGrid();       
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');  
    }   
	
	//조회후 디테일 조회 
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		var formObj = document.form;    
		
		if (sheetObj.SearchRows == 0) return;    
		   
		var sEqNo = sheetObj.CellValue(sheetObj.SelectRow ,"eq_no");     
	    var sEqType = formObj.eq_knd_cd.Code;                     
	    var sTotalLossDate = sheetObj.CellValue(sheetObj.SelectRow ,"mnr_dmg_flg_dt"); 
		 
		// History Detail 조회하기        
		formObj.eq_no.value = sEqNo;                  
	    doActionIBSheet2(sheetObjects[4], formObj, IBSEARCH);
			
		// Eq 상세 정보 조회하기    
		shtSetData(sheetObj,sEqType,sEqNo,sTotalLossDate);  
	}    
	
	//저장후 결과메세지 표시  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {         
			ComShowCodeMessage("MNR00023",'');    
		} else {    
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}          
	}      
	    
	function sheet1_OnDblClick(sheetObj,Row,Col){    
		var formObj = document.form;           
		//수정가능 데이타는 조회를 태우지 않는다.  
		if(Col != 6 && Col != 7 && Col != 9){       
			var sEqNo = sheetObj.CellValue(Row ,"eq_no");     
		    var sEqType = formObj.eq_knd_cd.Code;              
		    var sTotalLossDate = sheetObj.CellValue(Row ,"mnr_dmg_flg_dt"); 
			    
			// History Detail 조회하기           
			formObj.eq_no.value = sEqNo;                      
		    doActionIBSheet2(sheetObjects[4], formObj, IBSEARCH);  
			       
			// Eq 상세 정보 조회하기     
			shtSetData(sheetObj,sEqType,sEqNo,sTotalLossDate); 		 			
		}             
	}   
	
	//야드 벨리데이션 체크 
	function sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var retArray =  null;       
		if(sheetObj.ColSaveName(Col) == "mnr_dmg_flg_yd_cd"){         
			var checkYard = sheetObj.CellValue(Row ,Col); 
			                   
		    retArray = MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);      
			if(retArray == null){        
				ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
				sheetObj.CellValue2(Row ,Col) = "";  
				sheetObj.SelectCell(Row ,Col);                  
			} else { 	  
				return;    
			}  	 
		} else if(sheetObj.ColSaveName(Col) == "mnr_dmg_flg"){ 
			sheetObj.CellValue2(Row ,"mnr_dmg_flg_dt") = ComGetNowInfo("ymd"); 	
		}    	
	}

   // 프리폼스타일의 쉬트에 데이타를 삽입  
   function shtSetData(sheetObj,sEqType,sEqNo,sTotalLossDate){
   	    var formObj = document.form;
   		var sCostType = ""; 
		if(formObj.eq_knd_cd.Code == "U"){	
			sCostType = "MRDRRC";	 	
		} else if(formObj.eq_knd_cd.Code == "G"){
			sCostType = "MRGSRC";     		
		} else {
			sCostType = "MRZSRC"; 	  
		}		 
		var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType); 
		var retArr =  MnrXmlToArray(sXml);
						    
	 	//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){          
				//첫번째 시트 데이타 삽입  
				with(sheetObjects[1]){    
					var cnt = 1;                      
	                CellValue2(cnt,2) = retArr[0][7];          CellValue2(cnt,4) = retArr[0][16];      //manu_dt,lessor_nm     
	                cnt++;
	                CellValue2(cnt,2) = retArr[0][19];       CellValue2(cnt,4) = retArr[0][14];       //lstm_cd,dsp_flag 
	                cnt++; 
	                CellValue2(cnt,2) = retArr[0][12];        CellValue2(cnt,4) = retArr[0][0];		  //off_hire,imm_ext 
				}  
						     
				with(sheetObjects[2]){  
					var cnt = 1;   
					CellText(cnt,2) = retArr[0][30];          CellText(cnt,4) = retArr[0][23];     //rpr_type,status       
	                cnt++;
	                CellText(cnt,2) = retArr[0][4];          CellText(cnt,4) = retArr[0][32];     //rpr_yd,rpr_dt     
	                cnt++;       
					if(retArr[0][5] != null && retArr[0][5] != ""){ 
						CellText(cnt,2) = retArr[0][5];    //sp_name     retArr[0][5]   
						CellText(cnt,3) = retArr[0][5];    //sp_name     retArr[0][5]   
						CellText(cnt,4) = retArr[0][5];    //sp_name     retArr[0][5]   
					}    
					RowMerge(cnt) = true;           
				}               
			      	   
				with(sheetObjects[3]){  
					var cnt = 1;             
                    CellText(cnt,2) = retArr[0][13]; //mvmt_cd    
                    CellText(cnt,4) = retArr[0][2];  //mvmt_dt   	            
				}      
				         
		}		   	
   }
   	
   // 프리폼스타일의 타이틀및 디자인 설정
    function shtClear(sheetObj)
    {
           var shtID = sheetObj.id;

           switch(shtID) 
           {
		   			case "sheet1":
					
						with(sheetObj)
                        {
						 	RemoveAll();
						}	 
					break;
					    
                    case "sheet2":
                        
                        with(sheetObj)
                        {
                            RemoveAll(); 
                            var Row = DataInsert(-1);
                            var cnt = 1;                    
                            CellValue2(cnt,1) = "M/facture DT";         CellValue2(cnt,3) = "Owner/Lessor";           
                            cnt++;
                            CellValue2(cnt,1) = "Lease Term";         CellValue2(cnt,3) = "Disposal Flag";         
                            cnt++;
                            CellValue2(cnt,1) = "Off-Hire";         CellValue2(cnt,3) = "Imm.Exit";      
                            var titleColor = sheetObj.RgbColor(232,239,249);
                            ColBackColor(1) = titleColor;  
                            ColBackColor(3) = titleColor;  
                            CellFont ("FontBold", 1, 1, LastRow , 1) = true ;
                            CellFont ("FontBold", 1, 3, LastRow , 3) = true ;
                         }   
                    break;

                    case "sheet3": 
                  
                        with(sheetObj)
                        {
                            RemoveAll();    
                            DataInsert(-1);   
                                                
                            var cnt = 1;    
                            CellText(cnt,1) = "Repair Type";         CellText(cnt,3) = "Status";           
                            cnt++;
                            CellText(cnt,1) = "Repair Yard";         CellText(cnt,3) = "Repair Date";         
                            cnt++;
                            CellText(cnt,1) = "S/Provider";          CellText(cnt,2) = " ";		 CellText(cnt,3) = " ";		CellText(cnt,4) = " ";     
							RowMerge(cnt) = true;            
							               
                            var titleColor = sheetObj.RgbColor(232,239,249);
                            ColBackColor(1) = titleColor;   
                            ColBackColor(3) = titleColor;     
							
							      
    							    
                            CellFont ("FontBold", 1, 1, LastRow , 1) = true ;
                            CellFont ("FontBold", 1, 3, LastRow , 3) = true ;
                         }
                    break; 

                  case "sheet4":
                  
                        with(sheetObj)
                        {	
                            RemoveAll();
                            DataInsert(-1);
                            var cnt = 1; 
                            CellText(cnt,1) = "MVMT STS";	CellText(cnt,3) = "MVMT Date";                   
								  
                            var titleColor = sheetObj.RgbColor(232,239,249); 
                            ColBackColor(1) = titleColor;  
                            ColBackColor(3) = titleColor;   

                            CellFont ("FontBold", 1, 1, LastRow , 1) = true ;
                            CellFont ("FontBold", 1, 3, LastRow , 3) = true ;
                        
                         } 
                    break;
						 
				 case "sheet5":
					  
						with(sheetObj)
                        {  
						 	RemoveAll();
						}	 
					break;	
					
           }
		   sheetObj.Redraw;     
    }
	
	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getMnr_Multi(rowArray,ret_val) {
		var formObj = document.form;  
		var tempText = ""; 	
		//초기화	   
		formObj.eq_list.value = ''; 	
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ','; 	  
		}       
		//마지막에 ,를 없애기 위함     
		tempText = MnrDelLastDelim(tempText);	 
					 	    
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
	}   
	/* 개발자 작업  끝 */