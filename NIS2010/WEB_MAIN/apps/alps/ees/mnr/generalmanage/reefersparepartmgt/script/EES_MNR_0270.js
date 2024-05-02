	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0270.js 
	 *@FileTitle : Spare Part VSL Inventory Code
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
	 * @class ees_mnr_0270 : ees_mnr_0270 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0270() {
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
	
	var comboListVndr;
	var comboListMdlNm;
	var comboListTpCd;
	
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
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_close" :
				self.close();
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
					
					var HeadTitle1 = "|PRT Seq|Seq|Maker|Model|Type|The Last Price|Current Price|Remarks|Ver.|Create Date";
					var headCount = ComCountHeadTitle(HeadTitle1);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
			
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
			
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
		            
		            //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++,		dtHiddenStatus,			20,			daCenter,		true,     "ibflag");		                                   
		            InitDataProperty(0, cnt++,		dtHidden,				0,			daCenter,		true,     "spr_prt_seq",		false,		"",         dfNone,     	0,          false,      false);             
		            InitDataProperty(0, cnt++,		dtData,					40,			daCenter,		true,     "spr_prt_dp_seq",		false,		"",         dfNone,     	0,          true,       true);
		            InitDataProperty(0, cnt++,		dtCombo,				370,		daLeft,			true,     "spr_prt_vndr_seq",	false,		"",      	dfNone,			0,			false,		true);
		            InitDataProperty(0, cnt++,		dtCombo,				150,		daLeft,			true,     "spr_ut_mdl_nm",		false,		"",         dfNone,     	0,          false,      true);
		            InitDataProperty(0, cnt++,		dtCombo,				50,			daCenter,		true,     "spr_prt_tp_cd",		false,		"",         dfNone,     	0,          false,       true);
		            InitDataProperty(0, cnt++,		dtData,					100,		daRight,		true,     "spr_prt_lst_amt",	false,		"",         dfNumber,     	0,          false,      false);
		            InitDataProperty(0, cnt++,		dtData,					100,		daRight,		true,     "spr_prt_crnt_amt",	false,		"",         dfNumber,     	0,          true,      true);           
		            InitDataProperty(0, cnt++,		dtData,					150,		daCenter,		true,     "spr_prt_rmk",		false,		"",         dfNone,     	0,          true,      true);
		            InitDataProperty(0, cnt++,		dtHidden,				40,			daCenter,		true,     "spr_prt_ver_seq",	false,		"",         dfNone,     	0,          false,      false);		            
		            InitDataProperty(0, cnt++,		dtHidden,				40,			daCenter,		true,     "cre_dt",				false,		"",         dfNone,     	0,          false,      false);
		            
					InitDataCombo (0, "spr_prt_tp_cd", " |A|B", "N|A|B");
					
				}// end of with
				
				break;
	
		}// end of switch
	}
	
	
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObject = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}		
			
		//조회 콤보 및 sheet 콤보 데이터 설정
		doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObjects[0]); //Maker
		doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObjects[1]); //Model
				
		//로딩시 그리드 데이터 조회
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {			
		
			case IBSEARCH:      //조회
				sheetObj.RemoveAll();

				formObj.f_cmd.value = SEARCH; 
				
				var sXml   = sheetObj.GetSearchXml("EES_MNR_0270GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
							
				break;		
			
		}
		
	}
	
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {		
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {            					
	        case IBSEARCH_ASYNC01 :
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
				//MakeComboObject(formObj.spr_prt_vndr_seq, comboListVndr, 1, 0); //조회 조건 maker 콤보
				
				setGridCombo(sheetObj, comboListVndr, "spr_prt_vndr_seq"); //그리드  maker 콤보
				
				break;
	        case IBSEARCH_ASYNC02 :
	        	comboListMdlNm = "";
	        	//공통콤보 정보를 가져온다.    
				var sCondition = new Array ( 
					new Array("MnrGenCd","CD00096", "COMMON")
				)

				comboListMdlNm = MnrComSearchCombo(sheetObjects[0],sCondition);
				//MakeComboObject(formObj.spr_ut_mdl_nm, comboListMdlNm[0], 1, 0); //조회 조건 model 콤보
				
				setGridCombo(sheetObj, comboListMdlNm[0], "spr_ut_mdl_nm"); //그리드  model 콤보
    		
	        	break;
        }
		
        sheetObj.WaitImageVisible = true;
     }
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		return true;
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

    /**
     * sheet1 OnSearchEnd 이벤트 처리  
     * @param sheetObj
     * @param ErrMsg
     * @return
     */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {    	
    	var formObject = document.form;
    	
    	// 현재 버전 번호 및 최근 생성 일자 추출
    	var prevDt;
    	var nextDt;
    	var maxDt = "";
    	var verSeq = "";
    	if((sheetObjects[0].Rows - sheetObjects[0].HeaderRows) > 0) {
	    	for(var i=sheetObjects[0].HeaderRows; i<sheetObjects[0].Rows; i++) {	
	    		for(var j=i+1; j<sheetObjects[0].Rows; j++) {
	    			prevDt = parseInt(ComReplaceStr(sheetObjects[0].CellValue(i,"cre_dt"),"-",""),10);
	    			nextDt = parseInt(ComReplaceStr(sheetObjects[0].CellValue(j,"cre_dt"),"-",""),10);
	    			
	    			if(prevDt <=  nextDt) {
	    				maxDt = nextDt;
	    				verSeq = sheetObjects[0].CellValue(j,"spr_prt_ver_seq");
	    			}
	    		}
	    	}
	    	
	    	if(maxDt != "") { //조홰된 데이터가 있을 때
		    	maxDt = maxDt.toString();
		    	
		    	formObject.txt_ver.value = verSeq;
		    	formObject.txt_cre_dt.value = maxDt.substr(0,4) + "-" + maxDt.substr(4,2) + "-" + maxDt.substr(6,2);
	    	}
    	}
    	

    }	
