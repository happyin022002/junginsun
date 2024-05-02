/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0125.js
*@FileTitle : Damage History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
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
     * @class EES_MNR_0125 : EES_MNR_0125 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0125() {
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
								doActionIBSheet(sheetObject,formObject,IBSEARCH);
								break;   
						case "btn_new":          
								doActionIBSheet(sheetObject,formObject,IBCLEAR);
								break;      
						case "btn_DownExcel":
								sheetObject.SpeedDown2Excel(-1);     
								break;
						case "btns_calendar": 
								var cal = new ComCalendarFromTo();       
 								cal.select(form.from_date,  form.to_date,  'yyyy-MM-dd'); 
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
		MnrWaitControl(true);
								
		initControl();		    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);

        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Date|Office|Yard|Flag Type|Method|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,0 );
					InitDataProperty(0, cnt++ , dtDataSeq,40,    	daCenter );
					InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "mnr_flg_inp_dt",     false,          "",      dfDateYmd    ,		0,			false,		false);   
					InitDataProperty(0, cnt++ , dtData,		 100,	daCenter,	true,		"cre_ofc_cd",					false,	"",		dfNone,				0,			false,		false);  
					InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "mnr_flg_yd_cd",     false,          "",      dfNone      ,		0,			false,		false);   
					
					InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  false,     "mnr_sts_flg",     false,          "",      dfNone     ,		0,			false,		false);   
					InitDataProperty(0, cnt++ , dtCombo,	 100,	daCenter,	true,		"mnr_flg_inp_tp_cd",					false,	"",		dfNone,				0,			false,		false);     
					InitDataProperty(0, cnt++ , dtData,      150,   daLeft,    false,     "mnr_flg_rmk",     false,          "",      dfNone     ,		0,			false,		false);
				    				                      
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
					
					//SPP는 cre_ofc_cd를 감춤  
					if(workApp == "SPP"){ 
						ColHidden("cre_ofc_cd") = true;
					}
				}
	         		break;

        }
    }

  // Sheet관련 프로세스 처리 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false; 
        switch(sAction) {   
			case IBSEARCH:      //조회
					if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value = SEARCH01;    
	     				sheetObj.DoSearch4Post("EES_MNR_0125GS.do",FormQueryString(formObj));	 	
					}                         
			break;          
			   
			case IBCLEAR:      //초기화  
				MnrWaitControl(true);
                sheetObj.WaitImageVisible=false;
							
				formObj.reset();
				formObj.from_date.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_date.value = ComGetNowInfo("ymd");
					
				sheetObj.RemoveAll();	 
				
				//콤보데이타 조회
					var sCondition = new Array ( 
					 	new Array("MnrGenCd","CD00005", "COMMON") 
					)                   
							         
					//콤보데이타에 값을 세팅함 
					var sheetComboText = "";  
					var sheetComboCode = "";
					var sheetComboDefault = "";  
					     
					var comboList = MnrComSearchCombo(sheetObj,sCondition); 
					for(var i = 0; i < comboList.length;i++){ 
					 	if(comboList[i] != null){     
					 		for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");    
								  
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								            
								if(j ==0){
									sheetComboDefault = tempText[0];      	
								}  
							}           
						}                             
					 }          
					        
					//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다. 
					if (sheetComboText != "")         
				        sheetComboText = sheetComboText.substr(0, sheetComboText.length - 1);   
					if (sheetComboCode != "")
				        sheetComboCode = sheetComboCode.substr(0, sheetComboCode.length - 1);
					  	  	
					sheetObj.InitDataCombo (0, "mnr_flg_inp_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault);
					sheetObj.WaitImageVisible=true;
                    MnrWaitControl(false);    
			break;           

        }  
    }      
 
  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){   
			if(sAction==IBSEARCH) {      
				if (!ComChkValid(formObj)) return false;       
			}        	           
        }      
        return true; 
    }

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
				ComKeyOnlyAlphabet('uppernum');         
	            break; 
	    }         
	}
	/* 개발자 작업  끝 */