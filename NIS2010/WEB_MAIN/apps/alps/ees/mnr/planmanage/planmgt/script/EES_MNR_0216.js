	/*=========================================================
	*Copyright(c) 2009 CyberLogitec
	*@FileName : EES_MNR_0216.js
	*@FileTitle : M&R Guideline & Information
	*Open Issues :
	*Change history :
	*@LastModifyDate : 2009.06.08
	*@LastModifier : 함형석
	*@LastVersion : 1.0
	* 2009.06.08 함형석
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
	 * @class ees_mnr_0216 : ees_mnr_0216 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0216() {
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
	
	var comboObjects = new Array();
	var comboCnt = 0;
 	//쉬트 클릭시 상태를 저장 
	var sheetClicks = new Array(0,0,0);
	//조회 클릭시 상태를 저장
	var retrieveClick = 0;

	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)
	var strMnrOfficeLevel="";

	var uploadObjects = new Array();
	var uploadCnt = 0;
	var chksave=false;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

   

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;   	 							
				case "btn_New":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					if(chksave==true)doActionIBSheet(sheetObject,formObject,IBSEARCH);	
					break;		
				case "btn_RowAdd":	
                    doActionIBSheet(sheetObject, formObject, IBINSERT);        
                    break; 	
				case "btn_RowDelete":
                    doActionIBSheet(sheetObject, formObject, IBDELETE);        
                    break; 		 						
				default:
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
		MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i + 1);
 			ComEndConfigSheet(sheetObjects[i]);
        }
    	//IBMultiCombo초기화
  	    for(var k = 0; k < comboObjects.length; k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }	    	 	
		
		var formObj = document.form;	
 		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
        ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");  		
    }
	
	
 	function initUpload(uploadObj, uploadNo) {
 	   uploadObj.Files = "";
 	}
 	
    /**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
  	    switch(comboNo) {  
  	    	case 1: 
  	            with (comboObj) { 
  			        SetColAlign("left");        
  			        SetColWidth("75")   
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
		var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                     // 높이 설정
                     style.height = 342;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

 					 var HeadTitle1 = "|Sel|Seq.|Guideline Type|Guideline Title|File Name|Link|Attach User|Attach Office|Attach Date";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	 	"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,    	daCenter,  	false,   	"del_check",     	false,      "",     dfNone,			0,		true,		true);               
 					InitDataProperty(0, cnt++ , dtDataSeq,    	30,    	daCenter,  	true,    	"Seq",     			false,      "",     dfNone);
                    InitDataProperty(0, cnt++ , dtCombo,		110,	daLeft,		false,		"mnr_grp_tp_cd", 	true,		"",		dfNone,			0,		true,		true);
 					InitDataProperty(0, cnt++ , dtData,			350,	daLeft,		false,		"mnr_gline_nm", 	true,		"",		dfNone,			0,		true,		true, 100);
					InitDataProperty(0, cnt++ , dtPopup,      	160,    daLeft,  	false,    	"org_file_nm",     	true,       "",     dfNone,      	0,     	true,		true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,    	"file_dw",   		false,      "",     dfNone,      	0,     	false,		true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,		"upd_usr_id", 		false,		"",		dfNone,			0,		false,		false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,		"upd_ofc_cd", 		false,		"",		dfNone,			0,		false,		false);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"upd_dt", 			false,		"",		dfDateYmd,		0,		false,		false);
 					
 					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,	   	"mnr_gline_seq",	false,		"",		dfNone,			0,		false,		false);
 					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,	   	"file_seq",	   		false,		"",		dfNone,			0,		false,		false);
 					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,	   	"file_dtl_seq",	   	false,		"",		dfNone,			0,		false,		false);
 					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,	   	"file_path_nm",	   	false,		"",		dfNone,			0,		false,		false);
 					
					CountPosition = 0;
					
 					ImageList(0)= "/hanjin/img/ico_attach.gif";
 					
 					ShowButtonImage = 1;
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
 	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
 	 */	
    function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj; 
  	}
	 //페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록
 	function setUploadObject(uploadObj){
 	   uploadObjects[uploadCnt++] = uploadObj;
 	}

	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}   
	
 	/**
      * 파일 선택하기 <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {ibsheet} Row     	sheetObj의 선택된 Row
      * @param {ibsheet} Col     	sheetObj의 선택된 Col
      **/
 	function sheet1_OnPopupClick(sheetObj,Row,Col){
    	var upObj = uploadObjects[0];        	
 		var fileName = sheetObj.OpenFileDialog("파일선택");
 		if(fileName.indexOf("\\") !=-1) {
 			sheetObj.CellValue2(Row, "org_file_nm")= fileName;     			
 			upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
     		var ret = upObj.AddFile(fileName);     			     			
     		fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
 			sheetObj.CellValue2(Row, Col)= fileName;		 		
			sheetObj.CellValue2(Row, 'file_dw')= '1';
 			var file_seq = sheetObj.CellValue(Row, 'file_seq');
			var file_dtl_seq = sheetObj.CellValue(Row, 'file_dtl_seq');
			if(file_dtl_seq=="") file_dtl_seq="1";
			var ibflag='U';
			if(file_seq=="") ibflag='I'; // 최초 저장시 ibflag을 I로 Setting				     			
 			var sParam = "f_cmd="+COMMAND01;
 			sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code				
 			sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
 			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
 			sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
 			sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   			
			upObj.ExtendParam = sParam;

			var sXml = upObj.DoUpload(true);				
			sheetObj.CellValue2(Row, "file_seq")= ComGetEtcData(sXml,"seqValue");
 		}
 	}       
	
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/
	function sheet1_OnClick(sheetObj,Row,Col,Value){
	  
	    if (sheetObj.ColSaveName(Col)!="file_dw" || sheetObj.RowStatus(Row)=="I")return;
		if(sheetObj.CellText(Row, "file_path_nm") == "") return;
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "file_path_nm");
		return;
	}
		
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
     function doActionIBSheet(sheetObj,formObj,sAction) {

         switch(sAction) {
           case IBCLEAR:
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
	        	//콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();	
				}
				//콤보데이타 조회
				var sCondition = new Array (      
					new Array("MnrGenCd","CD00006", "COMMON")
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//콤보데이타 및 쉬트콤보데이타에 값을 세팅함        
				var sheetComboText = "";  
				var sheetComboCode = "";
				var sheetComboDefault = "";		
										
				formObj.mnr_grp_tp_cd.InsertItem(0, 'ALL' ,'ALL'); 
				if(comboList[0] != null){
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.mnr_grp_tp_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);

						var tempText = comboList[0][j].split("|");    								  
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";	
						if(j ==0){
							sheetComboDefault = tempText[0];      	
						}  								
					}           	
				}
				formObj.mnr_grp_tp_cd.Code = "ALL";  
				    
				        
				//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다. 
				if (sheetComboText != "")         
			        sheetComboText = sheetComboText.substr(0, sheetComboText.length - 1);   
				if (sheetComboCode != "")
			        sheetComboCode = sheetComboCode.substr(0, sheetComboCode.length - 1);					  	  	
				sheetObj.InitDataCombo (0, "mnr_grp_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault);  
				
				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
					sheetClicks[i] = 0;
	            }    
				//조회버튼 클릭 초기화 	
				retrieveClick = 0;
				sheetObj.WaitImageVisible = true;
				
				//GET OFFICE LVL
				MnrOfficeLevel(currOfcCd,rhqOfcCd);		
					
				MnrWaitControl(false);	
				
				//SET BTN AUTH
				if(strMnrOfficeLevel=="L1" || strMnrOfficeLevel=="L2"){
					ComBtnEnable("btn_Save");					
				} else {
					ComBtnDisable("btn_Save");				
				}   	
        	   break;
           case IBSEARCH:      //조회
				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
					sheetClicks[i] = 0;
	            }    
			
				sheetObj.WaitImageVisible = true;
           
	            if(validateForm(sheetObj,formObj,sAction)){  
					if(sheetObj.id =="sheet1"){       
						formObj.f_cmd.value = SEARCH; 
	        			sheetObj.DoSearch4Post("EES_MNR_0216GS.do",FormQueryString(formObj));	
					}         
				}        
               break;
			case IBINSERT:  // ROWADD                   
				var Row = sheetObj.DataInsert(-1); 
	      		break; 
			
			case IBDELETE:  // ROWDELETE   
	        	if(sheetObj.FindCheckedRow("del_check") != ""){
					ComRowHideDelete(sheetObj,"del_check"); 
				} else {                        
					ComShowCodeMessage("MNR00150");     	   
				}              		         
				break;	 		
	 		case IBSAVE:        //저장		 		
  				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;         
					chksave=sheetObj.DoSave("EES_MNR_0216GS.do", FormQueryString(formObj),-1,false);    		 				
				}  					    
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
		 	if(sAction==IBSAVE) {
			 	for (var i=1; i<=sheetObjects[0].RowCount; i++){
					if(sheetObjects[0].RowStatus(i)=="D"){
						var ret = ComShowConfirm(ComGetMsg("MNR00216"));
						return ret;
					}
				}	
			}
         }	
         return true;
     }	

	/* 개발자 작업  끝 */