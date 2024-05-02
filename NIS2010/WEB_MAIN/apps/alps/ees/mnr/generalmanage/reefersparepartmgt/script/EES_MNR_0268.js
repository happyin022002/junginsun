	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0268.js 
	 *@FileTitle : Spare Part VSL Inventory Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2014.12.02
	 *@LastModifier : 차상영
	 *@LastVersion : 1.0
	 * 2014.12.02 차상영
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
	 * @class ees_mnr_0268 : ees_mnr_0268 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0268() {
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
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
		
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
				case "btn_calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
					break;
	            case "btn_lane_cd":
	 				ComOpenPopup("ESM_FMS_0036.do", 620, 430, "setFromLaneCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0036");
	 				break;
	            case "btn_vessel":
					ComOpenPopup("COM_ENS_0A1.do", 620, 450, 'getCOM_ENS_0A1_1', '0,0', true);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
					break;	
				case "btn_detail" :
					var checkedRow = sheetObjects[0].FindCheckedRow("sel_chk");
					if(checkedRow == "") {
						ComShowCodeMessage("MNR00165","Checked Row"); //'{?msg1} doesn\'t exist, Please check again.';						
					}
					else {						
						var sp = checkedRow.split("|");						
						ComOpenPopup("EES_MNR_0269.do?spr_prt_invt_no=" + sheetObjects[0].CellValue(sp[0], "spr_prt_invt_no") + "&spr_prt_invt_ver_seq=" + sheetObjects[0].CellValue(sp[0], "spr_prt_invt_ver_seq"), 1030, 690, '', '0,0', true);
					}
					
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
	
	function setComboObject(combo_obj){    
		comboObjects[comboCnt++] = combo_obj;  
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
			
					// 높이 설정
					style.height = 422;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
			
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
			
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
			
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
			
					var HeadTitle1 = "|SEL.|Seq.|Inventory No.|Created Date|Inventory Ver";
					var headCount = ComCountHeadTitle(HeadTitle1);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
			
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
			
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
			
			
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,0,		daCenter,	true,	"ibflag"); 	    	
		 			InitDataProperty(0, cnt++, dtRadioCheck,        40,  daCenter,   true, 	"sel_chk");
		 	    	
					InitDataProperty(0, cnt++ , dtDataSeq,	   	50,			daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtData,	   		500,	    daCenter,	true,	"spr_prt_invt_no",		false,	"",		dfNone,		0,  false,		false);
					InitDataProperty(0, cnt++ , dtData,		   	100,		daCenter,	false,	"cre_dt",				false,	"",		dfNone,		0,	false,		false);	
					InitDataProperty(0, cnt++ , dtHidden,		100,		daCenter,	false,	"spr_prt_invt_ver_seq",				false,	"",		dfNone,		0,	false,		false);
				}
				break;
		
		}
	}
	
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObject = document.form;
		
		for(i=0;i<sheetObjects.length;i++)
		{
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
				
		//콤보 초기화 
		for(var k=0;k<comboObjects.length;k++){ 
			initCombo(comboObjects[k], k+1);  
		}
			
		doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObjects[1]); //Maker		
	}
	
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form;
	    
	    switch(comboNo) {     
		  case 1: 
			   with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;				        
					DropHeight = 160;      
					
					var cnt=0;
					InsertItem(cnt++, "ALL", " ");
					InsertItem(cnt++, " ", "N");
					InsertItem(cnt++, "A", "A");	
					InsertItem(cnt++, "B", "B");
			   }			   
			   
			   break;   
		  case 2: 
			   with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;				  
					SetColAlign("center");        
					SetColWidth("70|350");         
					DropHeight = 180; 
			   }			   
			   
			   break; 
		  
		 } 
	}
	

	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {		
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {            					
	        case IBSEARCH_ASYNC01 ://Sheet Combo 데이타 담아오기
	        	comboListVndr = "";
		 		formObj.f_cmd.value = SEARCH01;
		 		var xmlStr = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
			    var chk = xmlStr.indexOf("ERROR");
				if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(xmlStr);
				   return;
			    }  		
				var sStr = ComGetEtcData(xmlStr, "comboList");
				comboListVndr = sStr.split("@");
				MakeComboObject(formObj.spr_prt_vndr_seq, comboListVndr, 1, 0);
				
				//setGridCombo(sheetObj, comboListVndr, "spr_prt_vndr_seq");
				
				break;
	        
        }
		
        sheetObj.WaitImageVisible = true;
     }
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) 
		{		
			case IBSEARCH:   
				sheetObj.RemoveAll();
				
				formObj.f_cmd.value = SEARCH; 
				
				var sXml   = sheetObj.GetSearchXml("EES_MNR_0268GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);		
				break;		
	
		}
	}
		
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(sheetObj){
			
		}
	
		return true;
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {		
	
	}     
	
	function sheet1_OnDblClick(sheetObj,Row,Col){
		
	}    
	
	/**
	 * Lane Code 팝업창에서 선택한 Lane Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setFromLaneCd(aryPopupData){
        form.lane_cd.value = aryPopupData[0][3];
	}

	function getCOM_ENS_0A1_1(rowArray) {
        var colArray = rowArray[0];
        document.all.vsl_cd.value = colArray[3];
   }	
	
	/**
     * 콤보 오브젝트 생성(Spec No * Type/Size)
     */
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
    	 cmbObj.RemoveAll();
		 cmbObj.InsertItem(0, "", "");
		
		 for (var i=0; i<arrStr.length; i++) {
		    var arrCode = arrStr[i].split("|");

			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		 }
		 
		 //Maker 콤보시 General(999999) 항목 추가 설정
		 cmbObj.InsertItem(cmbObj.GetCount(), "999999" + '|' + "General", "999999");
		 
		 cmbObj.Index2 = "" ;
    }	
    
	/**
	 * 그리드내 Combo 생성
	 */
    function setGridCombo(sheetObj, comboList, targetColumnNm){
    	
		var sheetComboCode = " |"; 
		var sheetComboText = " |"; 
		var sheetComboDefault = " |";   
		
		if(comboList != null) { 	   
			for(var j = 0; j < comboList.length;j++){ 
				var tempText = comboList[j].split("|");
								
				sheetComboCode +=  tempText[0] + "|";    
				//sheetComboText +=  tempText[0] + "\t" + tempText[1] + "|"; 
				sheetComboText +=  tempText[0] + " - " + tempText[1] + "|"; 				
			}	
			
			//Maker 콤보시 General(999999) 항목 추가 설정
			if(targetColumnNm == "spr_prt_vndr_seq") {
				sheetComboCode += "999999";
				sheetComboText += "999999 - General";
			}
			
			sheetObj.InitDataCombo(0, targetColumnNm, sheetComboText, sheetComboCode, sheetComboDefault, sheetComboDefault); 				    
		}
	}
    