/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESS_MNR_0249.jsp
*@FileTitle : DV - Leased Unit
*Open Issues :	ALPS MNR-Total-DV 화면에서 E-Mail 및 Domain관리를 통하여 직접 DV를 문의
*Change history :
*@LastModifyDate : 2011.03.29
*@LastModifier : 김영오
*@LastVersion : 1.0
 * History
 * 2011.04.28 김영오 [CHM-201108634-01] 중복된 eq_no체크
 * 2011.05.02 김영오 [CHM-201108634-01] 삭제 falg값 셋팅 추가 sheetObj.RowStatus(row)= "D";
=========================================================*/
	/****************************************************************************************
				  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
									[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
									기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	  
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class ees_mnr_0249 : ees_mnr_0249 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0249() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
		this.eqNoChkForm 			= eqNoChkForm;
		this.comRowHideDeleteProc   = comRowHideDeleteProc;
	}
	
	/* 개발자 작업	*/
	
	//공통전역변수
	
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
         
         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_New":
					doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
					break;		
								
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
				
				case "btn_Send":					
					//하단 그리드에 사용자가 입력한 메일 주소 셋팅
					var emalAdd = "";
					for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
						if(sheetObjects[1].CellValue(i, "send_yn") == "Y") {
							emalAdd += sheetObjects[1].CellValue(i, "mnr_prnr_eml") +"; ";	
							
							if(sheetObjects[1].CellValue(i, "mnr_prnr_eml") == "") {
								formObject.com_recipient.value = "";
							} else {
								formObject.com_recipient.value = emalAdd;
							}
						}
					}
					
					doActionIBSheet(sheetObjects[0], formObject, COMMAND20);
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
										
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
					break;
					
				case "btn_delete":
					if(sheetObjects[0].FindCheckedRow("del_chk") == ""){ 
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;             	   
					}
					if(ComShowCodeConfirm("MNR00026")){
						comRowHideDeleteProc(sheetObjects[0], "del_chk");
						calReq=0;
					}
					break;
									
				case "btn_RowAdd2":
					doActionIBSheet(sheetObjects[1], formObject,COMMAND01);
					break;
					
				case "btn_RowDel2":
					if(sheetObjects[1].FindCheckedRow("del_chk") == ""){ 
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;             	   
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObjects[1], "del_chk");
						calReq=0;
					}
					break;
					
				case "btn_DownExcel":
					sheetObjects[0].SpeedDown2Excel();
					break;
					
				case "btn_DownExce2l":
					sheetObjects[1].SpeedDown2Excel();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	 MnrWaitControl(true);
    	 initControl();
        for(i=0;i<sheetObjects.length;i++)
        {
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
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
				style.height = 200;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet =  msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 14, 100);
				
				var HeadTitle1 = "|Sel|Seq|Lessor|TelNo.|PIC|E-Mail|Remark(s)||||||";
													
				var headCount = ComCountHeadTitle(HeadTitle1);									
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
				   
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "";
				InitDataProperty(0, cnt++,  dtHiddenStatus,		0,		daCenter,	true,	prefix+	"ibflag");
				InitDataProperty(0, cnt++,  dtRadioCheck,       30,     daCenter,   true,  	prefix+	"del_chk");
				
				InitDataProperty(0, cnt++,  dtDataSeq,	   		40,		daCenter,	true,		    "Seq");
				InitDataValid(   0, cnt,  	vtEngUpOther, "0123456789");
				InitDataProperty(0,	cnt++,	dtPopup,			250,	daLeft,		true,	prefix+	"mnr_cntc_prnr_nm",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,				100,	daLeft,		true,	prefix+ "phn_no",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,				100,	daLeft,		true,	prefix+	"mnr_prnr_addr",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,				150,	daLeft,		true,	prefix+	"mnr_prnr_eml",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,		        100,	daLeft,		true,	prefix+	"mnr_prnr_rmk",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	prefix+	"vndr_seq",			false,	"",	dfNone,		0,	true,	true);
				
				InitDataProperty(0,	cnt++,	dtHidden,			150,	daCenter,	true,	prefix+	"eq_no",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	prefix+	"conn_no",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	prefix+	"manu_dt",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	prefix+	"dv_cur",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	prefix+	"dv_value",			false,	"",	dfFloat,	2,	true,	true, 13);
								
				ShowButtonImage = 2;   
			}
			break;
            case 2: 
        		with(sheetObj) {
					// 높이 설정
					style.height = 200;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel.|Seq|EQ Type|EQ No|Send|Lessor|PIC|E-Mail||||";					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);


					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	50,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,	"seq_no");
					
					InitDataProperty(0, cnt++ , dtCombo,		180,	daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"rqst_eq_no",		true,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"send_yn",			false,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"mnr_cntc_prnr_nm",	false,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"mnr_prnr_addr",	false,	"",	dfNone,        0,		true,		true);

					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,	"mnr_prnr_eml",		false,	"",	dfEngUpKey,    0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daCenter,	true,	"conn_no",			false,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daCenter,	true,	"dv_cur",			false,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daCenter,	true,	"manu_dt",			false,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daCenter,	true,	"dv_value",			false,	"",	dfNone,        0,		true,		true);
					
					InitDataValid(0, "rqst_eq_no", vtEngUpOther,"0123456789");
					InitDataCombo(0, "eq_knd_cd",      "Container|Chassis|M.G.Set", "U|Z|G");
					InitDataCombo(0, "send_yn",       "Y|N", "Y|N");
				}
				break;
        }
    }

  	function initControl() {       
  		//Axon 이벤트 처리1. 이벤트catch  
  		var formObject = document.form;       
  		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
  		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
  		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 			//- 변경될때.
  	}
					
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
  	
  	//Axon 이벤트 처리2. 이벤트처리함수   
  	function obj_deactivate(){      
  		ComChkObjValid(event.srcElement); 
  	} 
  	
  	function obj_activate(){   
  		ComClearSeparator(event.srcElement);
  	}        
  	
  	function obj_change(){	     
  		var obj      = event.srcElement; 
  		var formObj  = document.form; 
  		var sheetObj = sheetObjects[0]; 
  	
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "empty":   
  				break;   
  			}       
  		} 
  	}    
  		
  	function obj_keypress(){   
  		obj = event.srcElement;    
  		keys = event.keyCode;
  		if(obj.dataformat == null) return; 
  		window.defaultStatus = obj.dataformat;
  		var formObj  = document.form; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "empty":   
  				break;   
  			}       
  		}				 			              
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
	
	//저장 후 성공여부 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") {
				//////////////////////////////////////////////////////////////////////
				//수정, 저장 후 재조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("EES_MNR_0249GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				for(var i = 0; i < arrXml.length; i++){ 
					sheetObjects[0].LoadSearchXml(arrXml[i]);
				}
				//////////////////////////////////////////////////////////////////////
				
				ComShowCodeMessage("MNR00009", "DV Leased Unit");
				formObj.vsl_cd.value="";
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
	}	   	

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCLEAR:  //NEW  
				MnrWaitControl(true);
				 
				sheetObj.ColBackColor("mnr_cntc_prnr_nm") 			= sheetObj.RgbColor(240,240,240);		
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				
				MnrWaitControl(false);        
				break;
				
			//조회
        	case IBSEARCH:      
				formObj.f_cmd.value = SEARCH;
                if(validateForm(sheetObj,formObj,sAction)) {
					//조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0249GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					for(var i = 0; i < arrXml.length; i++){ 
						sheetObjects[0].LoadSearchXml(arrXml[i]);
					}
					retrieveClick = 1;
			    }
				sheetObj.ColBackColor("mnr_cntc_prnr_nm") 			= sheetObj.RgbColor(240,240,240);
                break;		

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
				formObj.f_cmd.value = MULTI;
			
				var aryPrefix = new Array("sheet1_");
				var sParam = ComGetSaveString(sheetObjects, true, true);
				
				sParam += "&" + FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(aryPrefix);
			
				var sXml = sheetObj.GetSaveXml("EES_MNR_0249GS.do", sParam);
			
				sheetObjects[0].LoadSaveXml(sXml);				
				break;

			case IBINSERT:      // 입력
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				var row = sheetObj.DataInsert(-1);
				MnrWaitControl(false);
                break;
				
			case COMMAND01:     // Grid Row Add
				with(sheetObj) {
					if(sheetObjects[0].FindCheckedRow("del_chk") == "") {
						
					} else {
						//상단 그리드 정보를 하단 그리드의 새로 추가되는 로우에 정보 추가
						for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++) {
							if(sheetObjects[0].CellValue(i, "del_chk") == "1") {
								MnrWaitControl(true);
								var row = sheetObj.DataInsert(-1);	//row add
								sheetObjects[1].CellValue(sheetObjects[1].LastRow,"mnr_cntc_prnr_nm") = sheetObjects[0].CellValue(i, "mnr_cntc_prnr_nm");								
								sheetObjects[1].CellValue(sheetObjects[1].LastRow,"mnr_prnr_addr") = sheetObjects[0].CellValue(i, "mnr_prnr_addr");
								sheetObjects[1].CellValue(sheetObjects[1].LastRow,"mnr_prnr_eml") = sheetObjects[0].CellValue(i, "mnr_prnr_eml");
								MnrWaitControl(false);								
							}
						}
					}
				}
			break;
			
			case COMMAND20:     // Mail Send
				with(sheetObj) {
					if(!eqNoChkForm(sheetObj,formObj,sAction))return;
					
					if(sheetObjects[1].FindCheckedRow("send_yn") == "Y") {
						//ComShowMessage(MessageText("UserMsg13"));
					} else {
						
						
						// EQ_NO중복체크
						var Row = sheetObjects[1].ColValueDup("rqst_eq_no",false);
						if(Row>0){
							ComShowCodeMessage("MNR00006",(Row) + " row ");
							sheetObjects[1].SelectCell(Row, "rqst_eq_no", true);  
							return false;
						}
						
						
						var contents = "";
						contents += "Dear Sir / Madam																					 <br>";
						contents += "                                                                                                    <br>";
						contents += "Please kindly advise us your DV quote for the unit below.                                           <br>";
						contents += "                                                                                                    <br>";
						contents += "<table width=100% border=2 style='border-collapse: collapse; background-color: white; color: #272727;'>      <br>";
						contents += "	<tr style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'>   <br>";
						contents += "		<td>Container Numner</td>                                                                    <br>";
						contents += "		<td>Manufacture Date</td>                                                                    <br>";
						contents += "		<td>Currency</td>                                                                            <br>";
						contents += "		<td>D/V</td>                                                                 			     <br>"
						contents += "	</tr>                                                                                            <br>";
						
						for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
							if(sheetObjects[1].CellValue(i, "send_yn") == "Y") {
								contents += "	<tr>                                                                        			 <br>";
								contents += "		<td align=center>"+ sheetObjects[1].CellValue(i, "rqst_eq_no")  +"</td>              <br>";
								contents += "		<td align=center>"+ sheetObjects[1].CellValue(i, "manu_dt")  +"</td>                 <br>";
								contents += "		<td align=center>"+ sheetObjects[1].CellValue(i, "dv_cur")   +"</td>                 <br>";								
								contents += "		<td align=right>"+ sheetObjects[1].CellValue(i, "dv_value")  +"</td>                 <br>";
								contents += "	</tr>                                                                                    <br>";
							}
						}
						
						contents += "</table>                                                                                            <br>";
						contents += "Please note that this is not a total loss declaration. 				     						 <br>";
						contents += "                                                                                                    <br>";
						contents += "					Thank you in advance.<br>";
						
						formObj.com_subject.value = "DV quote request from SM LINE";
			    		formObj.com_content.value = contents;
						ComSendMailModal();	//공통 MAIL 팝업 호출
					}
				}
			break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			//저장(확정)시
			if(sAction==IBSAVE)
			{
				//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
				var rCnt=sheetObj.RowCount;
				if(rCnt<=0)
				{
					//ComShowCodeMessage("MNR00072");
					return false;             	   
				}
	
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
				{						
					//Lessor 빈값에 대한 체크를 수행 한다.
					var strSel =ComTrimAll(sheetObj.CellValue(i, "mnr_cntc_prnr_nm")," ");
					var strSelCd =ComTrimAll(sheetObj.CellValue(i, "vndr_seq")," ");
					if(strSel=="")
					{
						ComShowCodeMessage("MNR00172","Lessor");
						sheetObj.SelectCell(i, "mnr_cntc_prnr_nm",true);
						return false; 
					}
									
					//Tel No 빈값에 대한 체크를 수행 한다.
					var strPhnNo =ComTrimAll(sheetObj.CellValue(i, "phn_no")," ");
					if(strPhnNo=="")
					{
						ComShowCodeMessage("MNR00172","Tel No");
						sheetObj.SelectCell(i, "phn_no",true);
						return false; 
					}
			
					//PIC 빈값에 대한 체크를 수행 한다.
					var strPic =ComTrimAll(sheetObj.CellValue(i, "mnr_prnr_addr")," ");
					if(strPic=="")
					{
						ComShowCodeMessage("MNR00172","PIC");
						sheetObj.SelectCell(i, "mnr_prnr_addr",true);
						return false; 
					}
					
					//e-mail 존재에 대한 체크를 수행 한다.    
					var strEmail =ComTrimAll(sheetObj.CellValue(i, "mnr_prnr_eml")," ");
					if(strEmail=="")
					{
						ComShowCodeMessage("MNR00172","e-mail");
						sheetObj.SelectCell(i, "mnr_prnr_eml",true);
						return false; 
					}
					 
					//Remark 존재에 대한 체크를 수행 한다.    
					var strRemark =ComTrimAll(sheetObj.CellValue(i, "mnr_prnr_rmk")," ");
					if(strRemark=="")
					{
						//차후 필요하면 주석만 해제...
						//ComShowCodeMessage("MNR00172","Remark");
						//sheetObj.SelectCell(i, "mnr_prnr_rmk",true);
						//return false; 
					}			
				}
				if(!ComShowCodeConfirm("MNR00160")){return false;} //저장의사 확인
			}
		
			//조회시
			else if(sAction==IBSEARCH)
			{
				var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
				if(sRow != "") // sheet 수정내용 있음
				{                               	
					if(!ComShowCodeConfirm("MNR00007"))
					{
						return false;
					}
				}
			}
		}
		return true;
    }
	
	/**
	 * Lessor 검색 팝업
	 * @param {Object} sheetObj
	 * @param {Object} Row
	 * @param {Object} Col
	 * @param {Object} Value
	 */
	function sheet1_OnPopupClick(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "mnr_cntc_prnr_nm"){
			var vndrSeq =ComTrimAll(sheetObj.CellValue(Row, "mnr_cntc_prnr_nm")," ");
			if(vndrSeq=="")
			{
				MnrWaitControl(true);
				ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
				MnrWaitControl(false);
			}
		}
	}
		
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */		
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form; 	    
		if ( aryPopupData.length > 0 ) {			
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"vndr_seq") = ComLpad(aryPopupData[0][2],6,"0");	//Lessor Code
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"mnr_cntc_prnr_nm") = aryPopupData[0][4];			//Lessor
		}			
	}
	
	/**
	 * IBSheet의 특정 컬럼을 기준으로 체크된 행을 모두 숨기면서 트랜잭션 상태를 삭제 상태("D")로 변경한다. <br>
	 * col인자는 기능을 처리할 기준이 되는 체크컬럼 Index로 반드시 체크박스형태(dtCheckBox, dtDelCheck, dtDummyCheck, dtRadioCheck) 이어야 한다. <br>
	 * 삭제 상태로 숨겨진 행은 실제로 서버에 전달되지 않으므로 나중에 DoSave함수를 이용하여 서버에 전달하도록 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComRowHideDelete(sheetObj, "sel");	//"sel"컬럼이 체크된 행을 숨기고 삭제상태로 만든다.
     * <pre>
     * </pre>
     * @param {ibsheet} 	sheetObj    필수,IBSheet Object
     * @param {int,string} 	col    		필수,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @param {bool} 	isMsg    		선택,삭제처리할 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @returns int<br>
     *          -1 : 숨기기삭제 실패한 경우<br>
     *          그외  : 숨기기삭제 성공한 경우 처리된 행의 개수로 0개 이상의 값을 리턴한다.<br>
	 */
	function comRowHideDeleteProc(sheetObj, col, isMsg) {
   	    if (isMsg==undefined || isMsg==null) isMsg = true;
		var org_col = col;
		//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
		col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		
		//컬럼 인자의 유효성 확인하기
		if (col< 0 || col > sheetObj.LastCol) {
			ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
			return -1;
		}
		
		//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
		var sRow = sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		
		//가져온 행을 배열로 만들기 
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

		//기준컬럼의 DataType이 dtRadioCheck이면 그냥 숨기기만하고, dtRadioCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
		if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtRadioCheck) {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
				sheetObj.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}
		} else {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
				sheetObj.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}
		}
		
		sheetObj.RedrawSum = true;		//합계 계산하기		
		return arrRow.length-1;
	}
	
	/** 
	 * 	셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 DV_CUR, MANU_DT, DV_VALUE 값을 재설정한다.
	 *     Payer Type 을 변경함에 따라 Payer Code와 Payer Name을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				//중복인지 체크 
				var chkRow = sheetObj.ColValueDup("rqst_eq_no");
				if(chkRow > 0 && sheetObj.RowStatus(chkRow) != "D"){	
					ComShowCodeMessage("MNR00006",sheetObj.CellValue(Row,"rqst_eq_no"));
					sheetObj.CellValue2(Row, "rqst_eq_no")=""; 
					sheetObj.SelectCell(Row, "rqst_eq_no", true);       
					return false;    
				//DV에 존재 하는 EQ인지 체크 
				} else {		
					var chkFlag = false;
					for(var j = sheetObjects[1].HeaderRows; j <= sheetObjects[1].LastRow; j++) {	
						if(sheetObjects[1].RowStatus(j) != "D" && (sheetObjects[1].CellValue(j,"rqst_eq_no") == sheetObj.CellValue(Row,"rqst_eq_no"))){  
							//DV에 존재 하는 EQ이면 true
							chkFlag = true;		
						}				      
					}			
								
					if(!chkFlag){					
						ComShowCodeMessage("MNR00339");
						sheetObj.CellValue2(Row, "rqst_eq_no")="";	 	
						sheetObj.SelectCell(Row, "rqst_eq_no", true);			
						return false;			
					} 			
				}	
				setEqNoInfo(sheetObj,Row,Col);
			}
		}
	}	
	
	/** 
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 DV_CUR, MANU_DT, DV_VALUE 값을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
		}
	}
	
	/**
	 * EQ No 값을 변경함에 따라 DV_CUR, MANU_DT, DV_VALUE 값을 재설정한다.
	 *  
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		//EQ_TYPE 선택유무 체크 
		var eqKndCd = sheetObj.CellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){	
			ComShowCodeMessage("MNR00119"); 
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			return;	   	 
		} 
		//EQ No 존재유무 체크
		var rqstEqNo 		= sheetObj.CellValue(Row, "rqst_eq_no");
		var totalLossDate	= ComGetNowInfo("ymd");
		var retArray = MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);      
		if(retArray == null){ 	          
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");          				
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			return; 	     	          
		} 
		//EQ No 관련 항목 조회
		var formObj = document.form;
		var sCostType = "";
		if(eqKndCd == "U"){
			sCostType = "MRDRRC";	
		} else if(eqKndCd == "G"){
			sCostType = "MRGSRC";		
		} else {
			sCostType = "MRZSRC";   
		}	   	 	
		var sXml = MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml); 
		if(retArr == null){    
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");  
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		
		//var eqTpszCd 	= retArr[0][31];	//TP/SZ
		//var lstmCd	= retArr[0][19];	//Term
		//var ydCd		= retArr[0][18];	//Yard
		var dvCur		= retArr[0][3];		//DV_CUR
		var manuDt		= retArr[0][7];		//MANU_DT
		var dpcValAmt	= retArr[0][10];	//DV_VALUE
				
		sheetObjects[1].CellValue(sheetObjects[1].LastRow,"dv_cur")   = dvCur;
		sheetObjects[1].CellValue(sheetObjects[1].LastRow,"manu_dt")  = manuDt;
		
		if (dpcValAmt == "" || dpcValAmt == null) {
			sheetObjects[1].CellValue(sheetObjects[1].LastRow,"dv_value") = "0.00";		
		}else {
			sheetObjects[1].CellValue(sheetObjects[1].LastRow,"dv_value") = dpcValAmt;		
		}
		
		
	}
	
	/**
	 * EQ No 존재하지 않을 때, 관련정보 삭제
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.CellValue2(Row,"manu_dt") = ""; 		//MANU_DT
		sheetObj.CellValue2(Row,"dv_cur") = ""; 		//DV_CUR
		sheetObj.CellValue2(Row,"dv_value") = ""; 		//DV_VALUE
	}
	
	/**
	 * 
	 */
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		with(sheetObj) {
			var colname = ColSaveName(NewCol);
			if((colname == 'del_chk') && (OldRow !=NewRow)) {
				sheetObjects[1].RemoveAll();	//하단 그리드 초기화
			}
		}
	}
	
    /**
     * EQ No 필수입력 체크
     */
    function eqNoChkForm(sheetObj,formObj,sAction){
		with(formObj){
			//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
			var rCnt=sheetObjects[1].RowCount;
			if(rCnt<=0)
			{
				return false;             	   
			}

			for(var i=sheetObjects[1].HeaderRows ;i<=sheetObjects[1].LastRow;i++)
			{	
				//EQ No 존재에 대한 체크를 수행 한다.    
				var strEmail =ComTrimAll(sheetObjects[1].CellValue(i, "rqst_eq_no")," ");
				if(strEmail=="")
				{
					ComShowCodeMessage("MNR00172","EQ No");
					sheetObjects[1].SelectCell(i, "rqst_eq_no",true);
					return false; 
				}
			}			
		}
		return true;
    }
	
	
	
	
	
	
	
	//(sheetObj.ColSaveName(OldCol) == "del_chk")
	
	
	
	/*
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
			if(colname == 'del_chk') {
				sheetObjects[1].RemoveAll();	//하단 그리드 초기화
			} 	
		}
	}
	*/
	/*
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){	
		//(OldRow !=NewRow) && 
		//if(colname == 'del_chk') {
		if((sheetObj.ColSaveName(NewCol) == "del_chk") || (sheetObj.ColSaveName(OldCol) == "del_chk")){
			if (OldRow !=NewRow){
				sheetObjects[1].RemoveAll();	//하단 그리드 초기화
			}
		}
	}
	
	*/
	
	
	
	