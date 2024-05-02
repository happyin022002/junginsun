/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0019.js
*@FileTitle : VSL SKD Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.28 Jung Jinwoo
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2015.09.04 이병훈	[CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
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
	 * @class vop_vsk_0019 : vop_vsk_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_vsk_0019() {
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
	
	// Color 전역변수
	var glbBrthFontColor = null;
	var glbDepFontColor = null;
	
	// 현재 포커스를 가지고 있는 객체명 변수
	var focusObj = null;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_retrieve":
				case "btn_retrieve_pop":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
					
				case "btn_vvd_search":
					var vslCd = formObject.vsl_cd.value;
                	var sUrl = "";
                	
                	if(vslCd == ""){
                		sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + vslCd + "&inc_del_vsl_pop=Y";
                		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
                		ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
                	}
					break;
				
				case "btn_print":
					callRDOpen(sheetObject1, formObject);
					break;
				
				case "btn_test":
				case "btn_test_pop":
//					var vsl_cd = formObject.vsl_cd.value;
//					var skd_voy_no = formObject.skd_voy_no.value;
//					var skd_dir_cd = formObject.skd_dir_cd.value;
//					
//					sUrl = "/hanjin/VOP_VSK_0019.do?vsl_cd="+vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd;
//					ComOpenPopup(sUrl, 1024, 630, "", "0,0", false);
//					formObject.skd_rmk.value = "retyuiop";
					break;
					
				case "btn_close":
					self.close();
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('VSK00011');
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
        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        
        // Color Setting...
        glbBrthFontColor = sheetObjects[0].RgbColor(255, 0, 0);
        glbDepFontColor = sheetObjects[0].RgbColor(0, 0, 255);
        
        initFormMake(sheetObjects[0], document.form);
        
        document.form.vsl_cd.focus();
    }


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 360;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, true, true, false, false)

					var HeadTitle = "|Seq|DIR|Port|TMNL\nCode|P/F SKD|P/F SKD|Change\nStatus|Port Status|ETA|ETB|ETD|Remark(s)" +
							"|CreateUserID|CreateDate|UpdateUserID|UpdateDate|SKD_CNG_STS_CD";
					var HeadTitle2 = "|Seq|DIR|Port|TMNL\nCode|ETB|ETD|Change\nStatus|Port Status|ETA|ETB|ETD|Remark(s)" +
							"|CreateUserID|CreateDate|UpdateUserID|UpdateDate|SKD_CNG_STS_CD";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);


					//데이터속성    [ROW, 	COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"Status");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"Seq",							false,	"",		dfNone,				0,			true,		true,		-1,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"skd_dir_cd",			false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"vps_port_cd",			false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"tml_cd",				false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,		prefix+"etb_dy_cd",				false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,		prefix+"etd_dy_cd",				false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"skd_cng_sts_desc",		false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"port_skd_sts_desc",		false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			115,	daCenter,	true,		prefix+"vps_eta_dt",			false,	"",		dfUserFormat2,		0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			115,	daCenter,	true,		prefix+"vps_etb_dt",			false,	"",		dfUserFormat2,		0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			115,	daCenter,	true,		prefix+"vps_etd_dt",			false,	"",		dfUserFormat2,		0,			false,		true,		-1,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			45,		daLeft,		true,		prefix+"win_rmk",				false,	"",		dfNone,				0,			false,		true,		-1,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"cre_usr_id",			false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"cre_dt",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"upd_usr_id",			false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"upd_dt",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"skd_cng_sts_cd",		false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vps_rmk",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"port_skd_sts_cd",		false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"yd_nm",				false,	"",		dfNone,				0,			false,		true);

					InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
				}
				break;
				
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)){
					doActionSearch(sheetObj, formObj);
				}
				break;
				
			case SEARCH01:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0019GS.do", sParam);
					
					return sXml;
				}
				break;

		}
	}



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
    	switch(sAction) {

			case IBSEARCH:      //조회
				
//				if(ComIsNull(formObj.vsl_cd.value) || ComIsNull(formObj.skd_voy_no.value) || ComIsNull(formObj.skd_dir_cd.value)){
//					ComShowCodeMessage('VSK00027', "Direction Code");
//					return false;
//				}
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				}
				break;
    	}
    	
        with(formObj){
//	            if (!isNumber(formObj.iPage)) {
//	                return false;
//	            }
        }

        return true;
    }
    
    /**
     * 해당 목록을 조회
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionSearch(sheetObj, formObj){
    	var prefix = sheetObj.id + "_";
    	
    	formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0019GS.do", sParam);
		ComOpenWait(false);
		
		sheetObj.Redraw = false;
		sheetObj.LoadSearchXml(sXml);
		
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		for(var i=headCnt; i<=totCnt; i++) {
			// Skip 한 Port 는 안보이게.
    		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S"){
    			fontColorChangeBySkip(sheetObj, i);
    		}else if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "B"){
    			sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbBrthFontColor;
    			sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbBrthFontColor;
    			sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbBrthFontColor;
    		}else if(sheetObj.CellValue(i, prefix+"port_skd_sts_cd") == "D"){
    			sheetObj.CellFontColor(i, prefix+"vps_eta_dt") = glbDepFontColor;
    			sheetObj.CellFontColor(i, prefix+"vps_etb_dt") = glbDepFontColor;
    			sheetObj.CellFontColor(i, prefix+"vps_etd_dt") = glbDepFontColor;
    		}
		}
		sheetObj.Redraw = true;
		
		var vslSlanCd = ComGetEtcData(sXml, "vsl_slan_cd");
		if(vslSlanCd != null && vslSlanCd != undefined){
			formObj.vsl_slan_cd.value = vslSlanCd;
		}
		var skdRmk = ComGetEtcData(sXml, "skd_rmk");
		if(VskIsNotNull(skdRmk)){
			formObj.skd_rmk.value = skdRmk;
		}else{
			formObj.skd_rmk.value = "";
		}
		setFormData(sheetObj, 2, 1);
    }

	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	function sheet1_OnClick(sheetObj, Row, Col) {
		if(Row > 1 && Col > 0){
			setFormData(sheetObj, Row, Col);

			var prefix = sheetObj.id + "_";
			var formObj = document.form;
			var headCnt = sheetObj.HeaderRows;
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"win_rmk"){
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, prefix+"vps_rmk"));
//				if(sheetObj.RowEditable(Row) == false){
					sUrl = sUrl + "&readonly=true";
//				}
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
//				if(rVal || rVal == ""){
//					sheetObj.CellValue2(Row, prefix+"vps_rmk") = rVal;
//					sheetObj.CellValue2(Row, prefix+"win_rmk") = rVal.replace(/\n/g, "").replace(/\r/g, "");
//				}
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */

    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm('change', 'obj_change', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    	axon_event.addListenerForm('keydown', 'obj_keydown', form);
    	axon_event.addListenerForm('focus', 'obj_focus', form);
	}
    
	function obj_change(){
		var formObj = document.form;
	    var sheetObj = sheetObjects[0];
	    
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	
	            case "vsl_cd":
	            	codeChangedRemove(sheetObj, formObj);
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		formObj.skd_voy_no.focus();
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	                
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function obj_keypress(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {    
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break; 
				
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(document.form.skd_voy_no);
				break;

		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
		}
	}
	
	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    	}
				break;
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    	}
				break;

		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.vsl_slan_cd.focus();
//		    		document.getElementById("btn_retrieve").focus();
		    	}
				break;
		}
	}
	
	function obj_keydown(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		if(focusObj=="vsl_cd"){
			var ctrl = event.ctrlKey;
			var code = event.keyCode;
			if(ctrl && code == 86){ 
				var clipData = window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData = clipData.toUpperCase();
					formObj.vsl_cd.value = clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value = clipData.substring(4, 8);
						formObj.skd_dir_cd.value = clipData.substring(8, 9);
					}
				}
				event.returnValue = false;
			}
		}
	}
	
	function obj_focus(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		if(eleObj.name){
			focusObj = eleObj.name;
		}else{
			focusObj = "";
		}
	}
	
	/**
	 * 최초 화면 Open 시 Main과 Pop-up 에 따른 Form Setting.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function initFormMake(sheetObj, formObj){
		var popMode = formObj.pop_mode.value;
		
		if(popMode == "Y"){
			//Pop-up Mode
			document.getElementById("top_table").className = "popup";
			document.getElementById("top_tr").style.display = "block";
			document.getElementById("top_td").className = "top";
			document.getElementById("pop_layer").style.display = "block";
			
			var titleName = "Vessel Schedule Inquiry by V.V.D(Pop-up)";
			var titleHtml = "<table width='100%' border='0'>" +
					"<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'>&nbsp;"+titleName+"</td></tr>" +
					"</table>";
			document.getElementById("main_title").innerHTML = titleHtml;
			
			if(ComIsNull(formObj.vsl_cd.value) || ComIsNull(formObj.skd_voy_no.value) || ComIsNull(formObj.skd_dir_cd.value)){
				// Logic Null
			}else{
				doActionSearch(sheetObj, formObj);
			}
			
			formObj.vsl_cd.className = "input2";
			formObj.vsl_cd.readOnly = true;
			formObj.skd_voy_no.className = "input2";
			formObj.skd_voy_no.readOnly = true;
			formObj.skd_dir_cd.className = "input2";
			formObj.skd_dir_cd.readOnly = true;
			
		}
		else{
			//Main Mode
			document.getElementById("top_tr").style.display = "none";
			document.getElementById("main_layer").style.display = "block";
			
//			var titleHtml = "<table width='100%' border='0' cellpadding='0' cellspacing='0' class='title'>" +
//					"<tr><td class='history'><img src='img/icon_history_dot.gif' align='absmiddle'><span id='navigation'></span></td></tr>" +
//					"<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'><span id='title'></span></td></tr>" +
//					"</table>";
		}
		
		
	}
	
	/**
	 * 선택한 Row의 데이타를 해당 Form에 Setting.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setFormData(sheetObj, Row, Col){
    	var formObj = document.form;
    	var prefix = sheetObj.id + "_";
    	
    	formObj.cre_usr_id.value = sheetObj.CellValue(Row, prefix+"cre_usr_id");
    	formObj.cre_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"cre_dt"));
    	formObj.upd_usr_id.value = sheetObj.CellValue(Row, prefix+"upd_usr_id");
    	formObj.upd_dt.value = VskReplaceUserDate(sheetObj.CellValue(Row, prefix+"upd_dt"));
    }
    
    /**
	 * Skip 상태인 Row의 Font Color Setting.
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix = sheetObj.id + "_";
		
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"skd_dir_cd");
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_port_cd");
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"tml_cd");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"etb_dy_cd");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"etd_dy_cd");
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"skd_cng_sts_desc");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"port_skd_sts_desc");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_rmk");
	}
	
	/**
	 * Sheet 의 Font Color 를 Back Color 로 변경.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetFontToBackColor(sheetObj, Row, Col){
//		sheetObj.CellFontColor(Row, Col) = sheetObj.CellBackColor(Row, Col);
		sheetObj.CellFontColor(Row, Col) = sheetObj.RgbColor(255, 255, 255);
	}
	
    function codeChangedRemove(sheetObj, formObj){
    	formObj.skd_voy_no.value = "";
    	formObj.skd_dir_cd.value = "";
    	formObj.vsl_slan_cd.value = "";
    	formObj.cre_dt.value = "";
    	formObj.cre_usr_id.value = "";
    	formObj.upd_dt.value = "";
    	formObj.upd_usr_id.value = "";
    	formObj.skd_rmk.value = "";
    	
    	sheetObj.RemoveAll();
    }
    
    function getVslCdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value = rtnDatas[1];
				}
			}
    	}
    }

	function getVvdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value = rtnDatas[2];
					document.form.skd_dir_cd.value = rtnDatas[3];
				}
			}
    	}
    }
    
    /**
     * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
    		
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
		
		var chkVslCd = ComGetEtcData(sXml, "vsl_chk");
		
		if(chkVslCd == "Y"){
    		//MDM_VSL_CNTR 에 Vessel Code가 존재
    		return true;
    	}else{
    		sheetObj.LoadSearchXml(sXml);
    		formObj.vsl_cd.value = "";
    		return false;
    	}
	}
	
	/**
	 * RD Viewer 호출.
	 * 
	 * @param formObj
	 * @return
	 */
	function callRDOpen(sheetObj, formObj){
		var rdParam = setQueryStr(sheetObj, formObj);
		
		if(VskIsNull(rdParam)){
			return;
		}else{
			formObj.com_mrdPath.value      = "apps/alps/vop/vsk/scheduleplanningoperation/vesselschedulemgt/report/VOP_VSK_0019.mrd";
		    formObj.com_mrdArguments.value = rdParam;
		    formObj.com_mrdBodyTitle.value = "Vessel Schedule by VVD Report";
			formObj.com_mrdSaveDialogFileName.value = "Vessel Schedule by VVD Report";
			
			var sFeatures = "dialogWidth:980px;dialogHeight:690px;status:no";
		    
			ComOpenRDPopupModal(sFeatures);
		}
	}
	
	/**
	 * RD 에 넘어갈 Parameter Setting.
	 * 
	 * @param formObj
	 * @return
	 */
	function setQueryStr(sheetObj, formObj){
		var qryStr = "";
		if(sheetObj.RowCount < 1){
			qryStr = "";
		}else{
			qryStr += "/rv vsl_cd[" + formObj.vsl_cd.value + "]";
			qryStr += " skd_voy_no[" + formObj.skd_voy_no.value + "]";
			qryStr += " skd_dir_cd[" + formObj.skd_dir_cd.value + "]";
//			qryStr += " vps_port_cd[" + formObj.loc_cd.value + "]";
//			qryStr += " clpt_ind_seq[" + formObj.clpt_ind_seq.value + "]";
			qryStr += " this_time[" + VskRdPrintDate() + "]";
		}
		
        return qryStr;
	}
	
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        if(sheetObj.RowCount > 0){
        	//마우스 위치를 행과 컬럼과 값 가져오기
            var Row = sheetObj.MouseRow;
            var Col = sheetObj.MouseCol;
            var prefix = sheetObj.id+"_";
            
            if (Row > 1 && Col == 4) {
        		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, prefix+"yd_nm");
        		sheetObj.MousePointer = "Hand";
            } else {
        		sheetObj.MouseToolTipText = "";
            	sheetObj.MousePointer = "Default";	
            }
        }
    }
    
	/* 개발자 작업  끝 */