/*=========================================================
 * History
 * 2008.02.27 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
 *    변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
 * 2009.09.14 남궁진호 CSR No.CHM-200900987 -initSheet D3 Type코드 추가
 * 2009.10.09 남궁진호 ALPS 전환   1.0 Creation
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
     * @class ESM_BSA_0143 : ESM_BSA_0143 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0143() {
    	this.processButtonClick		= processButtonClick;
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
    var loadingMode = false;


    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /*
    * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
    */
    function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			
				case "btn_close":
					window.close();
					break;
			
				case "btn_downexcel":
					//sheetObject.DataInsert();
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
			
				case "bu_zoom_in":
					if(sheetObject.RowCount > 15){
						sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.RowCount + 3);
						div_zoom_out.style.display = "inline";
						div_zoom_in.style.display = "none";
						parent.syncHeight();
					}
					break;
			
			    case "bu_zoom_out":
			    	if(sheetObject.RowCount > 15){
			    		sheetObject.style.height = sheetObject.GetSheetHeight(15+3);
			    		div_zoom_in.style.display = "inline";
			    		div_zoom_out.style.display = "none";
			    		parent.syncHeight();
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
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	 
	/**
	 * 설  명 : IBCombo Object를 배열로 등록 <br>
	 *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *          배열은 소스 상단에 정의<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setComboObject(combo_obj)
	 * </pre>
	 * @param {object}	combo_obj - Combo Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){
		    //khlee-시작 환경 설정 함수 이름 변경
		    ComConfigSheet(sheetObjects[i]);
		    initSheet(sheetObjects[i],i+1);
		    //khlee-마지막 환경 설정 함수 추가
		    ComEndConfigSheet(sheetObjects[i]);
	    }
	    
	    // 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    /**
	 * 설  명 :  Combo 기본 설정 및 초기화 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadCombo()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadCombo() {
		var formObj = document.form;
		var sXml = formObj.sXml.value;

		var arrXml = sXml.split("|$$|");
		comboXml = arrXml;

		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
		if (arrXml.length > 3)
			ComXml2ComboItem(arrXml[3], formObj.cobIOC, "code", "code");
		document.form.sXml.value="";
	}

    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {
	    var cnt = 0;
	
	    switch(sheetNo) {
		    case 1:      //sheet1 init
			    with (sheetObj) {
				    //SheetWidth = mainTable.clientWidth;                             //전체 너비 설정
				    //SheetWidth = "580";                             //전체 너비 설정
				    style.height = GetSheetHeight(20) ;
				    SheetWidth = mainTable.clientWidth;	
				
				    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				    MergeSheet = msHeaderOnly;                                      //전체Merge 종류 [선택, Default msNone]
				    Editable = false;                                                //전체Edit 허용 여부 [선택, Default false]
				    InitRowInfo( 2, 1, 9, 100);                                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				    InitColumnInfo(21, 12, 0, true);                                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				    InitHeadMode(false, false, false, true, false,false);             // 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				    var HeadTitle = "YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|BSA CAPA.|Carrier|BSA|"
				    			  +	"Weight\nPer TEU|TTL\nWeight|RF|D2|D3|D4|D5|D7" ;
				    var HeadTitle1 = "YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|BSA CAPA.|Carrier|BSA|"
				    			   + "Weight\nPer TEU|TTL\nWeight|RF|D2|D3|D4|D5|D7" ;
				
				    InitHeadRow(0, HeadTitle, true);                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				    InitHeadRow(1, HeadTitle1, true);                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				
				    //데이터속성	[ROW,	COL,	DATATYPE,	WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK,	SAVESTATUS,	FORMATFIX]
				    InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	"cost_yrwk",				false,	"",	dfDateYm,	0);
				    InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"trd_cd",					false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"sub_trd_cd",				false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"slan_cd",					false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"rlane_cd",					false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"vsl_lane_tp_cd",			false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"vsl_cd",					false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		40,	daCenter,	true,	"skd_voy_no",				false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		40,	daCenter,	true,	"skd_dir_cd",				false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtData,		40,	daCenter,	true,	"vop_cd",					false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	70,	daRight,	true,	"bsa_capa",					false,	"",	dfInteger,	0);
				
				    InitDataProperty(0,	cnt++,	dtData,	60,	daCenter,	true,	"crr_cd",					false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"bsa",						false,	"",	dfNone,		0);
				    //InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"free_add_teu_capa	",		false,	"",	dfNone,		0);
				    //InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"free_add_wgt	",			false,	"",	dfNone,		0); 					
				    //InitDataProperty(0,	cnt++,	dtAutoAvg,	60,	daRight,	true,	"n2nd_fnl_hjs_bsa_capa	",	false,	"",	dfNone,		0);
				    //InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,	true,	"spc_otr_swap_flg	",		false,	"",	dfNone,		0);
				    //InitDataProperty(0,	cnt++,	dtAutoSum,	50,	daRight,	true,	"spc_ctrl_slt_capa	",		false,	"",	dfNone,		0);
				
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"weight_teu",				false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"weight_ttl",				false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"rf",						false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"d2",						false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"d3",						false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"d4",						false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"d5",						false,	"",	dfNone,		0);
				    InitDataProperty(0,	cnt++,	dtAutoSum,	60,	daRight,	true,	"d7",						false,	"",	dfNone,		0);
				
				    CountPosition  = 0 ;
				    RangeBackColor(1, 13, 1, 14) = RgbColor(222, 251, 248);
			
			    }
			    break;
	   	}
    }
    
    /**
	 * 설  명 :  Combo 기본 설정 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initCombo(comboObj,comboNo)
	 * </pre>
	 * @param {object}	comboObj - Combo Object
	 * @param {Number}	comboNo  - Combo Number
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
 	function initCombo (comboObj, comboNo) {
 		with (comboObj) {
 			DropHeight = 300;
 			comboObj.InsertItem(0, 'All' ,''); 
 			Index = 0;
 		}
 	}

    /**
    * Sheet관련 프로세스 처리
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	
	    switch(sAction) {
		    case IBSEARCH:      //조회
			    if(!validateForm(sheetObj,formObj,sAction))return false;
			    formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch4Post("ESM_BSA_0143GS.do", bsaFormString(formObj,getParam2('ESM_BSA_0143')));
			    break;
			    case IBDOWNEXCEL:        //엑셀 다운로드
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
		    // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
		    if (chkPrd[1].checked && txtFmMonth.value != "" && txtToMonth.value != "") {
			    if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
					ComAlertFocus(txtToMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
					return false;
			    }
		    }
		    if (chkPrd[0].checked && txtFmWeek.value != "" && txtToWeek.value != "") {
		    	if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
		    		ComAlertFocus(txtToWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
		    		return false;
		    	}
		    }
	    }
	    return true;
    }


    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var param = "";
         var gubun = "";
         var fm_mon ="";
         var to_mon ="";
         var fm_wk ="";
         var to_wk ="";
	
	    if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
	    	if(obj.name == "txtToMonth" ){
	    		formObj.txtFmMonth.value = "";
	    	} else if (obj.name == "txtToWeek"){
		    	formObj.txtFmWeek.value = "";
	    	}
		    return false;
	    } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
	    	if(obj.name == "txtFmMonth") return false;
	    	if(obj.name == "txtFmWeek") return false;
	    }
	
	    if(chkValidSearch()){
	    	if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value != ""){
	    		gubun = "5";
	    	} else if(formObj.txtFmMonth.value == "" && formObj.txtFmWeek.value != "") {
	    		gubun = "4";
	    	} else if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value == "") {
	    		gubun = "3";
	    	}
	    	formObj.param2.value = formObj.txtYear.value;

            if(formObj.chkPrd[0].checked){
                fm_mon = "";
                to_mon = "";
                fm_wk = formObj.txtFmWeek.value;
                to_wk = formObj.txtToWeek.value;
            } else {
                fm_mon = formObj.txtFmMonth.value;
                to_mon = formObj.txtToMonth.value;
                fm_wk = "";
                to_wk = "";
            }

            param = param+"f_cmd="+SEARCHLIST02;
			param = param+"&gubun="+gubun;
			param = param+"&fm_mon="+fm_mon;
			param = param+"&to_mon="+to_mon;
			param = param+"&fm_wk="+fm_wk;
			param = param+"&to_wk="+to_wk;
			param = param+"&year="+eval(formObj.txtYear.value);
			param = param+"&code=period";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			var period = GetEtcDataForExceptional(sXml, "period", "0");
			document.getElementById("div_period").innerHTML = "<div id=\"div_period\">("+ period +")</div>";
	    }
    }

    /**
    * ifram을 이용하여 R.Lane 표시
    */
    function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
    }


    /**
    * 검색시 필수입력사항 체크
    */
    function chkValidSearch(){
    	var formObj = document.form;

    	with(formObj){
    		if (txtYear.value == "") {
    			ComShowMessage(ComGetMsg("COM12114", "Year", ""));
    			txtYear.focus();
    			return false;
    		}
    		if (txtFmMonth.value != "" && txtToMonth.value == "") {
    			ComShowMessage(ComGetMsg("COM12114", "month", ""))
    			txtToMonth.focus();
    			return false;
    		}
    		if (txtFmMonth.value == "" && txtToMonth.value != "") {
    			ComShowMessage(ComGetMsg("COM12114", "month", ""));
    			txtFmMonth.focus();
    			return false;
    		}
//        			if (txtFmMonth.value != "" && txtToMonth.value != "") { 
//        			    if(txtFmMonth.value > txtToMonth.value){
//        			        ComShowMessage(ComGetMsg("COM12133","from Month"," to Month","작은값"));
//        			        txtFmMonth.value = "";
//        			        txtToMonth.value = "";
//        			        txtFmMonth.focus();
//        			        return false;
//        			    }
//        			}

    		if (txtFmWeek.value != "" && txtToWeek.value == ""){
    			ComShowMessage(ComGetMsg("COM12114", "week", ""));
    			txtToWeek.focus();
    			return false;
    		}
    		if (txtFmWeek.value == "" && txtToWeek.value != ""){
    			ComShowMessage(ComGetMsg("COM12114", "week", ""));
    			txtFmWeek.focus();
    			return false;
    		}
    		if(txtFmMonth.value == "" && txtFmWeek.value == ""){
    			//ComShowMessage(ComGetMsg("COM12138", "month", "week"));
    			return false;
    		}

    		if(!isValidYear(txtYear,false,true)) return false;
    		if(!isValidMonth(txtFmMonth,false,true)) return false;
    		if(!isValidMonth(txtToMonth,false,true)) return false;
    		if(!isValidWeek(txtFmWeek,false,true)) return false;
    		if(!isValidWeek(txtToWeek,false,true)) return false;
    	}
    	return true;
    }

	/* 개발자 작업  끝 */