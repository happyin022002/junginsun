/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0030.js
*@FileTitle : Target VVD 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 박수훈
*@LastVersion : 1.0
=========================================================
* History
* 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
* 변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
* 2009.05.14 배진환 N200905120702 setPeriod 변경
* 2009.09.04 박수훈 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.03.04 이행지 CHM-201002932 chkValidSearch메소드 수정-Week,Month체크시 해당부분만 체크하도록
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2011.02.10 최성민 Ticket ID:CHM-201108533-01 Search Validation 수정 및 소스정리
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
=========================================================
*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
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
     * @class ESM_COA_0030 : ESM_COA_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0030() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.chkValidSearch  		= chkValidSearch;
    	this.validateForm 			= validateForm;
    }

    
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;

    var sheet_height = 20; // sheet의 height

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_SkdInquiry":
                    var vsl_cd  = "";
                    var classId = "COM_ENS_0B1";
                    var param = "";

                    if(sheetObject.SelectRow > 1){
                        vsl_cd = ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "vsl_cd")) + ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "skd_voy_no")) + ComTrim(sheetObject.CellValue(sheetObject.SelectRow, "dir_cd"));
                    }else{
                        //[COM12113] : VVD 를(을) 선택하세요.
                    	ComShowCodeMessage("COM12113","VVD","");
                        return false;
                    }
                    param = '?vvd_cd='+vsl_cd+'&classId='+classId;
                    ComOpenPopup('/hanjin/COM_ENS_0B1.do'+param, 630, 380, '', '0,0,1,1,1,1,1,1,1,1', false);
					break;

				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;
    
    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
    				break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
                       
		document.form.f_year.focus();
	}

	
   /**
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 최성민
    * @version 2011.01.25
	*/ 
	function initCombo(comboObj, comboId) {
		switch(comboObj.id) {
	     	case "f_trd_cd":
	     		with(comboObj) {
	     			DropHeight = 300;	            	
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 3;
	     			UseAutoComplete = false;
	     			ValidChar(2, 0);	//영문대문자
	     			InsertItem(0, 'All' ,'');
	     			Index = 0;
	     		}
	     		break;
	     	case "f_rlane_cd":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 5;
	     			UseAutoComplete = false;
	     			ValidChar(2, 1);	//영문대문자+숫자
	     			InsertItem(0, 'All' ,'');
	     			Index = 0;
	     		}
	     		break;	 
	     	case "f_slan_cd":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 3;
	     			UseAutoComplete = false;
	     			ValidChar(2, 1);	//영문대문자+숫자
	     			InsertItem(0, 'All' ,'');
	     			Index = 0;
	     		}
	     		break;	      
	     	case "f_dir_cd":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 1;
	     			UseAutoComplete = false;
	     			ValidChar(2, 0);	//영문만 입력
	     			InsertItem(0, 'All' ,'');
	     			Index = 0;
	     		}
	     		break;   
	     	case "f_ioc_cd":
	     		with(comboObj) {
	     			DropHeight = 300;
	     			MultiSelect = false;
	     			MaxSelect = 1;
	     			MaxLength = 1;
	     			UseAutoComplete = false;
	     			ValidChar(2, 0);	//영문만 입력
	     			InsertItem(0, 'All' ,'');
	     			Index = 0;
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
		var formObj = document.form;

		switch(sheetNo) {
			case 1:      //sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;						//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);		//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;									//전체Merge 종류 [선택, Default msNone]
					Editable = false;										//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(21, 9, 0, true);							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);		// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle0 = "BSA\nFLAG|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Weekly|Weekly|Monthly\nStatus" ;
					var HeadTitle1 = "BSA\nFLAG|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Port|ETD|S.Lane\n 1st Port ETD|Status|Auto/Mnl|Monthly\nStatus" ;
					InitHeadRow(0, HeadTitle0,true);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1,false);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtCheckBox,	40,		daCenter,		true,		"bsa_zr_flg");
					InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,		true,		"",					false,		"",		dfNone,	 	0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,		true,		"cost_yrmon",		false,		"",		dfDateYm,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,		true,		"sls_yrmon",		false,		"",		dfDateYm,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,		true,		"cost_wk",			false,		"",		dfNone,		0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,	    50,		daCenter,		true,		"trd_cd",			false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,	    70,		daCenter,		true,		"sub_trd_cd",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,	    50,		daCenter,		true,		"slan_cd",			false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,	    50,		daCenter,		true,		"rlane_cd",			false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,	    40,		daCenter,		true,		"vsl_lane_tp_cd",	false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,		true,		"vsl_cd",			false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,		50,		daCenter,		true,		"skd_voy_no",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,  	40,		daCenter,		true,		"dir_cd",			false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,  	40,		daCenter,		true,		"ioc_cd",			false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,	    60,		daCenter,		true,		"lst_lodg_port_cd",	false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0,	cnt++,	dtData,	   120,     daCenter,		true,		"lst_lodg_port_etd_dt",false,	"",		dfUserFormat2,0,	false,	true);
					InitDataProperty(0,	cnt++,	dtData,	   120,	    daCenter,		true,		"n1st_lodg_port_etd_dt",false,	"",		dfUserFormat2,0,	false,	true);
					InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,		true,		"wky_tgt_flg",		false,		"",		dfEngUpKey,	0,		false,	true);
					InitDataProperty(0,	cnt++,	dtCombo,	80,		daCenter,		true,		"wky_mnl_flg",		false,		"",		dfEngUpKey,	0,		true,	true);
					InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,		true,		"mon_tgt_flg",		false,		"",		dfEngUpKey,	0,		false,	true);
					InitDataProperty(0,	cnt++,	dtHidden,	70,		daCenter,		true,		"delt_flg",		    false,		"",		dfEngUpKey,	0,		false,	false);

                    HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(sheet_height) ;
					InitUserFormat2(0, "lst_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );
					InitUserFormat2(0, "n1st_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );
					InitDataCombo(0, "wky_mnl_flg", " |Pre_Manual|Fix_Auto|Fix_Manual", " |P|A|M");
					
					WaitImageVisible = false;
				}
				break;

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
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
    		case IBCLEAR:          //조회	        	
				ComOpenWait(true);
				var sXml = document.form.sXml.value; 	
				
				
				var arrXml = sXml.split("|$$|");
				
				formObj.f_year.value = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        				
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        
		        if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "name");
				//if (arrXml.length > 1)
				//	ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "name");
				//if (arrXml.length > 2)
				//	ComXml2ComboItem(arrXml[2], formObj.f_slan_cd, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_dir_cd, "code", "name");
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_ioc_cd, "code", "name");
				
				document.form.sXml.value="";
				ComOpenWait(false);
				break;
	
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon.value, 2, '0');
				if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = ComLpad(formObj.f_to_mon.value, 2, '0');
				if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = ComLpad(formObj.f_fm_wk.value, 2, '0');
				if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = ComLpad(formObj.f_to_wk.value, 2, '0');
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_COA_0030GS.do", coaFormQueryString(formObj));
				ComOpenWait(false);
				break;
				
				
			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;

		}
	}
    	
	/**
	 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
	 */
	function f_trd_cd_OnChange(obj,value,text) {
		var formObj = document.form;		
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST01;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0030GS.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_slan_cd, "code", "name");
		formObj.f_rlane_cd.Index = 0;
		formObj.f_slan_cd.Index = 0;
		
	}
	
	/**
     * month, week가 변경되었을때 Period를 변경한다.
     */
	function setPeriod(obj){
		ComCoaSetPeriod(obj);
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
   	 * @author 최성민
   	 * @version 2011.02.07
     */
	function validateForm(sheetObj,formObj,sAction){		
		switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if(!chkValidSearch()) {
	 				return false;
	 			}
	  		 break;	  	
		}	   
		return true;
	}	
 	
    /**
     * 검색시 필수입력사항 체크  <br>
     * <br><b>Example :</b>
     * <pre>
     *     chkValidSearch()
     * </pre>
     * @returns 없음
   	 * @author 최성민
   	 * @version 2011.02.07
     */
	function chkValidSearch(){
		var formObj = document.form;
		var checkFlg = true;

 		with(formObj){
 			if (f_year.value == "") {
 				ComShowCodeMessage("COM12114", "Year");
 			    f_year.focus();
 			    checkFlg = false;
 			} else if(!ComIsDate(f_year, "yyyy")){
  		    	ComShowCodeMessage("COA10009","Year","YYYY");
 			    f_year.focus();
 			    checkFlg = false;
  		    } else if (f_chkprd[0].checked){	     			
     			if (f_fm_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     			    f_fm_wk.focus();
     			    checkFlg = false;
     			} else if (f_to_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_fm_wk)){
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('COA10009','Week','WW');
     				f_fm_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_to_wk)) {
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('COA10009','Week','WW');
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if (f_fm_wk.value > f_to_wk.value) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("COA10011","Week","From","To");
     			    f_to_wk.focus();
     			    checkFlg = false;
     			}
 			} else if (f_chkprd[1].checked){
     			if (f_fm_mon.value == ""){
     				ComShowCodeMessage("COM12114", "Month")
     			    f_fm_mon.focus();
     			    checkFlg = false;
     			} else if (f_to_mon.value == ""){
     				ComShowCodeMessage("COM12114", "Month")
     			    f_to_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_fm_mon)){
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('COA10009','Month','MM');
     				f_fm_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_to_mon)) {
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('COA10009','Month','MM');
     				f_to_mon.focus();
     			    checkFlg = false;
     			} else if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("COA10011","Month","From","To");
     			    f_to_mon.focus();
     			    checkFlg = false;
     			}			
 			}	
 		}
 		return checkFlg;
	}