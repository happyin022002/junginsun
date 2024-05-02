/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0224.js
*@FileTitle : Hanger Bar Inventory History Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.12 함형석
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
     * @class ees_mnr_0224 : ees_mnr_0224 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0224() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;    

var initLoader = 0;

var regionalHQ = "";
var nowLoad = 0;

// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)
var strMnrOfficeLevel="";

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
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_calendar": 
					var cal = new ComCalendarFromTo();       
 					cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd'); 
					break;    		
				case "btn_Close":
					self.close();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		initControl()
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);		
    }

    /**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form
	    switch(comboNo) {    
	        case 1: 
	           	with (comboObj) { 
				//MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
				//SetColWidth("100|150");        
			   	DropHeight = 160;  
				UseAutoComplete = true;
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
                    style.height = 300;
                    
                    SheetWidth = mainTable.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    MergeSheet = msHeaderOnly;
                    Editable = false;

					var HeadTitle1 = "|Seq|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|G.TTL|Remark(s)|Update\nDate";
                    var HeadTitle2 = "|Seq|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Sound         |Damage        |Missing    |Disposal   |G.TTL|Remark(s)|Update\nDate";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 10, 100);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
                    InitHeadMode(true, true, true, true, false,false);
	
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //   dtComboEdit [ROW, COL,  DATATYPE,              WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     	   40,	    daCenter,	   	false,	    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,                     30,      daCenter,    	true,       "Seq"); 
					InitDataProperty(0, cnt++ , dtData,					   80,	    daCenter,	   	true,		"ar_hd_qtr_ofc_cd",			true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,				       70,	    daCenter,	   	true,		"ofc_cd",			    	true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,				   80,	    daCenter,		true,		"mnr_hngr_bar_tp_cd",		true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					   90,		daRight,		true,	    "rcvr_qty",					false,	"",		dfInteger,	        0,			true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					   90,		daRight,		true,	    "pur_qty",					false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					   90,		daRight,		true,	    "csm_qty",					false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					   105,		daRight,		true,	    "act_invt_qty",				false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					   80,		daRight,		true,	    "mnr_hngr_dmg_qty",			false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					   80,		daRight,		true,	    "mnr_lost_hngr_qty",		false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					   80,		daRight,		true,	    "mnr_disp_hngr_qty",		false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					   90,		daRight,		true,	    "invt_qty",					false,	"",		dfInteger,	        0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,					   140,		daLeft,	    	true,	    "invt_rmk",					false,	"",		dfNone,	        	0,			false,		false, 4000);
					InitDataProperty(0, cnt++ , dtData,					   90,		daLeft,	    	true,	    "upd_dt",					false,	"",		dfNone,	        	0,			false,		false);
						
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					
			   }
         break;
        }
    }

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
	}    

	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        

	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
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
	            ComKeyOnlyNumber(obj, ".");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup": 
	        	ComKeyOnlyAlphabet('uppernum','45');   
	        break;	  
	    }
	} 	
			
   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @param errMsg
    * @return
    */
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(sheetObjects[0].RowCount>0){
	    	 for(i=sheetObjects[0].LastRow; i > 1 ; i--){
				  sheetObj.CellValue2(i,  "pieces") = sheetObj.CellValue(i, "act_invt_qty") - sheetObj.CellValue(i, "invt_qty");
	    	 }
		}	 
     }

  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){       
						formObj.f_cmd.value = SEARCH; 
		        		sheetObj.DoSearch4Post("EES_MNR_0224GS.do",FormQueryString(formObj));	
					}  
				}	
                break;
			case IBCLEAR:        //초기화
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				if(initLoader == 0){
	
					//콤보 초기화 
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();       
					}   

					//공통콤보 정보를 가져온다.  
					var sCondition = new Array (
						new Array("MnrGenCd","CD00022", "COMMON")  //Hanger Bar Type 
					);			                                       
					var comboList = MnrComSearchCombo(sheetObj,sCondition);   
					
					//콤보 설정
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
							}
							//Hanger Bar Type 
							if(i==0) {
								sheetObjects[0].InitDataCombo(0, "mnr_hngr_bar_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
							}						
						}
					}
					initLoader = 1;	
				}
				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  

				form.from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "m", -3);
				form.to_dt.value = ComGetNowInfo();
		
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
                break;

        }
    }
		
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){

        }
		return true;
	}

	/* 개발자 작업  끝 */