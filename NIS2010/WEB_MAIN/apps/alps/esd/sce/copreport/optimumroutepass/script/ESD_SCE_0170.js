/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0170.js
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------------------------------------------------------
* History
* 2013.04.29 조인영 [CHM-201323843] [SCE] Optimum Route Pass의 조회 조건 및 칼럼 추가
* 2013.07.09 조인영 [CHM-201325044] [TRS] Optimum Route Pass에 Alternative Optimum 관련 보완
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0170 : esd_sce_0170 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_sce_0170() {
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
var globalCheck = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
						
					case "btn_new":
						fn_reset();
						break;

		   	        case "from_to_calendar": // From 달력버튼
	                	var cal = new ComCalendarFromTo();
	                	cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
		   	            break;

					case "btns_office": //M CNTR
						if( validation_check() ) {
							var ofc_cd = formObject.input_office.value;
							ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
						}  
						break;

					case "btn_detail":
						if(sheetObject1.SelectRow >= sheetObject1.HeaderRows){
							var iCheckRow = sheetObject1.CheckedRows("sheet1_del_chk");
							if(iCheckRow <= 0){
								ComShowCodeMessage("COM12177");
								return false;
							}else{
					    		make_detail_info(sheetObject1);
					    		formObject.f_cmd.value = "";
								var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
					    		ComPostOpenWindow("/hanjin/ESD_SCE_0171.do", "ESD_SCE_0171", myOption);	
							}
						}else{
							ComShowCodeMessage("COM12177");
						}
						break;

					case "btn_down_excel":
						sheetObject1.SpeedDown2Excel(-1);
						break;
						
					case "btns_frmnode": //FromNode Popup창
						openHireYardPopup('getFromNode');
						break;

					case "btns_dorloc": //DoorLocation Popup창
						openHireYardPopup('getDorLoc');
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
     * Combo Object를 배열로 등록
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }
		
    	//From Date 날짜 세팅
    	set_from_date();
    	
		initControl();
    }

    //From Date 날짜 세팅
    function set_from_date(){
    	var formObj = document.form;
    	var vNowDate = formObj.now_date.value;
    	var vlastDay = formObj.last_day.value;
    	formObj.from_date.value = ComGetDateAdd(vNowDate, "M", 0).substr(0, 8)+"01";
    	formObj.to_date.value = vlastDay.substr(0,4)+"-"+vlastDay.substr(4,2)+"-"+vlastDay.substr(6,2); 
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */
	function initCombo(comboObj, comboNo) {
		var i=0;
		//가져온 행을 배열로 반든다.
		var arrRow = f_trsp_crr_mod_cdCode.split("|");
   	    switch(comboObj.id) {
			case "bnd_cd":
				with(comboObj) {
					comboObj.DropHeight=125;
					InsertItem(i++,  "IN",  "I");
					InsertItem(i++,  "OUT",  "O");
					InsertItem(i++,  "IN+OUT",  "A");
					comboObj.Text = "IN";
	        	}
				break;  

			case "trsp_mod_cd":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					//comboObj.BackColor = "#CCFFFD";
					//comboObj.Code = "";
					InsertItem(i++,  "ALL",  "ALL");
					for (j=0; j<arrRow.length; j++){
						InsertItem(i++,  arrRow[j],  arrRow[j]);
					}
					comboObj.Text = "ALL";
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
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 386;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag|All|Seq.|W/O OFFICE|B/D|Transmode|Total No. of S/O|Non-Pass S/O|Non-Pass Ratio|Transmode Discrepancy|Transmode Discrepancy|Route Discrepancy|Route Discrepancy|No Optimum IRG|No Optimum IRG|Others|Others|Pass S/O|Alt. Pass S/O|grp_no|qry_ofc_cd|qry_trsp_mod_cd|cpy_no|from_date|to_date|dscr_rsn_map";
					var HeadTitle2 = "Flag|All|Seq.|W/O OFFICE|B/D|Transmode|Total No. of S/O|Non-Pass S/O|Non-Pass Ratio|No. of S/O|Ratio|No. of S/O|Ratio|No. of S/O|Ratio|No. of S/O|Ratio|Pass S/O|Alt. Pass S/O|grp_no|qry_ofc_cd|qry_trsp_mod_cd|cpy_no|from_date|to_date|dscr_rsn_map";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,30,daCenter,false,prefix+"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	30, daCenter,	true,	prefix+"del_chk",		false, "", dfNone, 0, true,	true);
					InitDataProperty(0, cnt++, dtDataSeq, 	50,	daCenter,	true,	prefix+"", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	    daCenter,	true,	prefix+"wo_cre_ofc_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	40,		daCenter,	true,	prefix+"trsp_bnd_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,		daCenter,	true,	prefix+"trsp_mod_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daRight,	true,	prefix+"tot_so_cnt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  100,	daRight,	true,	prefix+"non_pass_cnt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  90,	    daRight,	true,	prefix+"non_pass_ratio", 		false, "", dfNone, 0, false, false);

					InitDataProperty(0, cnt++, dtData,  70,	daRight,	true,	prefix+"non_pass_t_cnt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  80,	daRight,	true,	prefix+"non_pass_t_ratio", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  70,	daRight,	true,	prefix+"non_pass_r_cnt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  80,	daRight,	true,	prefix+"non_pass_r_ratio", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  70,	daRight,	true,	prefix+"non_pass_n_cnt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  80,	daRight,	true,	prefix+"non_pass_n_ratio", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  70,	daRight,	true,	prefix+"non_pass_o_cnt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,  80,	daRight,	true,	prefix+"non_pass_o_ratio", 		false, "", dfNone, 0, false, false);

					InitDataProperty(0, cnt++, dtData, 	100,	daRight,	true,	prefix+"pass_cnt", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daRight,	true,	prefix+"alt_pass_cnt", 	false, "", dfNone, 0, false, false);

					InitDataProperty(0, cnt++, dtHidden,80,		daCenter,	true,	prefix+"grp_no", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,4000,	daCenter,	true,	prefix+"qry_ofc_cd", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,200,	daCenter,	true,	prefix+"qry_trsp_mod_cd", 	false, "", dfNone, 0, false, false);
//					InitDataProperty(0, cnt++, dtHidden,60,		daCenter,	true,	prefix+"incl_sub_ofc_flg", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 64, 	daCenter,	true,	prefix+"cpy_no", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,  110,	daRight,	true,	prefix+"in_from_date", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,  110,	daRight,	true,	prefix+"in_to_date", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,  110,	daRight,	true,	prefix+"dscr_rsn_map", 	false, "", dfNone, 0, false, false);
					
					CellFontColor(0, prefix+"non_pass_cnt")     = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_ratio")   = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_t_cnt")   = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_t_ratio") = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_r_cnt")   = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_r_ratio") = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_n_cnt")   = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_n_ratio") = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_o_cnt")   = RgbColor(200,0,0);
					CellFontColor(0, prefix+"non_pass_o_ratio") = RgbColor(200,0,0);

					CellFontColor(1, prefix+"non_pass_t_cnt")   = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_t_ratio") = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_r_cnt")   = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_r_ratio") = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_n_cnt")   = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_n_ratio") = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_o_cnt")   = RgbColor(200,0,0);
					CellFontColor(1, prefix+"non_pass_o_ratio") = RgbColor(200,0,0);
					}
				break;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					
					if(document.search_fm_yard.Code != '' || formObj.search_fm_loc.value != '') {
						formObj.from_node.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
					}else{
						formObj.from_node.value = '';
					}
					if(document.search_door_yard.Code != '' || formObj.search_door_loc.value != '') {
						formObj.door_node.value = formObj.search_door_loc.value+document.search_door_yard.Code;
					}else{
						formObj.door_node.value = '';
					}
					
					var arr = new Array("sheet1_", "");
		        	var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr);
					var sXml = sheetObj.GetSearchXml("ESD_SCE_0170GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
				}	
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
				if(isNull(formObj.from_date.value)){
					ComShowCodeMessage("COM130201", "From to Date");
					formObj.from_date.focus();
					return false;
		      	}else if(isNull(formObj.to_date.value)){
					ComShowCodeMessage("COM130201", "From to Date");
					formObj.to_date.focus();
					return false;
		      	}else if(isNull(formObj.input_office.value)){
					ComShowCodeMessage("COM130201", "W/O Issue Office Code");
					formObj.input_office.focus();
					return false;
		      	}
				
				var days_between = ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value);

				if(days_between < 0){
					ComAlertFocus(formObj.to_date, ComGetMsg("COM132002"));
					return false;
				}
				
				if(!sceMonthsBetweenCheck(formObj.from_date.value, formObj.to_date.value, 3, '-')) {
					ComAlertFocus(formObj.to_date, ComGetMsg("SCE90060"));
					return false;
				}
				
//				if(days_between > 92){
//					ComAlertFocus(formObj.to_date, ComGetMsg("SCE90060"));
//					return false;
//				}
				
				break;
		}
        return true;
    }

    /* initControl() */
    function initControl() {
 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
    	axon_event.addListenerFormat('focus', 'obj_activate', form);
    	axon_event.addListenerForm ('blur', 'obj_blur', form);
    }
    
    //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
       	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
           
       	switch(event.srcElement.name){ 	    	
       		case "from_date":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       		case "to_date":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       	}
    }

    /** 
     * 업무 자바스크립트 Onblur 이벤트 처리  <br>
     */    
    function obj_blur(){
    	obj = event.srcElement;
    	var formObj = document.form;

    	switch(obj.name) {
    		case "slan_cd":
    			if( formObj.slan_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("slan_cd");
    					return false;
    				}
    			}
    			break; 

			case "from_date":
    			if( formObj.from_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("from_date", "");
                    	setFocus("from_date");
                    	return false;
                    }
                }
    			break;
    		case "to_date":
    			if( formObj.to_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("to_date", "");
                    	setFocus("to_date");
                    	return false;
                    }
                }
    			break;
    	}
    }

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		globalCheck = 0;
		for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
			if(sheetObj.CellValue(i, "sheet1_wo_cre_ofc_cd") == "ALL" ){
				sheetObj.CellEditable(i, "sheet1_del_chk") = false;
			}else{
				sheetObj.CellEditable(i, "sheet1_del_chk") = true;
			}
			
			if(sheetObj.CellValue(i, "sheet1_wo_cre_ofc_cd") == "ALL" 
				&& sheetObj.CellValue(i, "sheet1_trsp_mod_cd") == "ALL" ){
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(166,163,240);
				sheetObj.CellFont("FontBold", i,1,i,15) = true;
			} else if(sheetObj.CellValue(i, "sheet1_wo_cre_ofc_cd") == "ALL" ) {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(211,216,250);
			} else if(sheetObj.CellValue(i, "sheet1_trsp_mod_cd") == "ALL" ) {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(235,235,235);
				sheetObj.CellFont("FontBold", i,1,i,15) = true;
			} else {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(248,248,248);
			}
		}
		sheetObj.ColFontColor("sheet1_non_pass_cnt")     = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_ratio")   = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_t_cnt")   = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_t_ratio") = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_r_cnt")   = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_r_ratio") = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_n_cnt")   = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_n_ratio") = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_o_cnt")   = sheetObj.RgbColor(200,0,0);
		sheetObj.ColFontColor("sheet1_non_pass_o_ratio") = sheetObj.RgbColor(200,0,0);
	}
	
	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var formObj = document.form;
		var row = sheetObj.MouseRow;
		var col = sheetObj.MouseCol;
		var ofcAll = 'ALL';
		var trspALL = 'ALL';
		if ((row == 0 || row == 1) && col == 1) {
			if(globalCheck == 0) { globalCheck = 1;}
			else {globalCheck = 0;}

			if (sheetObj.RowCount > 0) {
				trspALL = sheetObj.CellValue(sheetObj.HeaderRows, "sheet1_qry_trsp_mod_cd");
			}
			if (globalCheck == 1) {
				for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
					if(sheetObj.CellValue(i, "sheet1_wo_cre_ofc_cd") == ofcAll 
						&& sheetObj.CellValue(i, "sheet1_trsp_mod_cd") == trspALL ){
						sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
					} else if(sheetObj.CellValue(i, "sheet1_wo_cre_ofc_cd") ==ofcAll ) {
						sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
					} else if(sheetObj.CellValue(i, "sheet1_qry_trsp_mod_cd") == trspALL ) {
						sheetObj.CellValue2(i, "sheet1_del_chk") = 1;
					} else {
						sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
					}
				}
			} else {
				for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
					sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
				}
			}
		}
	}
	
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){
		var formObj = document.form;
		//if( sheetObj.CellValue(Row, "sheet1_wo_cre_ofc_cd") == "ALL"){
			ComSetObjValue(formObj.sel_wo_cre_ofc_cd, sheetObj.CellValue(Row, "sheet1_wo_cre_ofc_cd"));
			ComSetObjValue(formObj.sel_from_date, sheetObj.CellValue(Row, "sheet1_in_from_date"));
			ComSetObjValue(formObj.sel_to_date, sheetObj.CellValue(Row, "sheet1_in_to_date"));
//			ComSetObjValue(formObj.sel_incl_sub_ofc_flg, sheetObj.CellValue(Row, "sheet1_incl_sub_ofc_flg"));
	
//			formObj.sel_ofc_cd.value = sheetObj.CellValue(Row, "sheet1_qry_ofc_cd");
	        ComSetObjValue(formObj.sel_ofc_cd, sheetObj.CellValue(Row, "sheet1_qry_ofc_cd"));
			ComSetObjValue(formObj.sel_bnd_cd, sheetObj.CellValue(Row, "sheet1_trsp_bnd_cd"));
			ComSetObjValue(formObj.sel_trsp_mod_cd, sheetObj.CellValue(Row, "sheet1_qry_trsp_mod_cd"));
			ComSetObjValue(formObj.sel_dscr_rsn_map, sheetObj.CellValue(Row, "sheet1_dscr_rsn_map"));

			ComSetObjValue(formObj.sel_op_tp, "SINGLE"); // single row double click
    		formObj.f_cmd.value = "";
			var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
    		ComPostOpenWindow("/hanjin/ESD_SCE_0171.do", "ESD_SCE_0171", myOption);	
		//}
	}
	
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	var sName = sheetObj.ColSaveName(Col);
    	if (sName == "sheet1_del_chk" && sheetObj.CellValue(Row, "sheet1_wo_cre_ofc_cd") != "ALL") {
			
			var sel = sheetObj.FindText("sheet1_grp_no", sheetObj.CellValue(Row, "sheet1_trsp_mod_cd"));
			var fastRow = sheetObj.FindText("sheet1_grp_no", sheetObj.CellValue(Row, "sheet1_grp_no"));
				
			if( sheetObj.CellValue(Row, "sheet1_trsp_mod_cd") == "ALL"){
				for(var i=fastRow ; i<=sheetObj.RowCount ; i++){
					if( sheetObj.CellValue(fastRow, "sheet1_grp_no") == sheetObj.CellValue(i, "sheet1_grp_no") && Row != i){
						sheetObj.CellValue(i, "sheet1_del_chk") = 0;
					}	
				}	
			}else{
				for(var i=fastRow ; i<=sheetObj.RowCount ; i++){
					if( sheetObj.CellValue(fastRow, "sheet1_grp_no") == sheetObj.CellValue(i, "sheet1_grp_no") &&  sheetObj.CellValue(i, "sheet1_trsp_mod_cd") == "ALL"){
						sheetObj.CellValue(i, "sheet1_del_chk") = 0;
					}	
				}	
			}
    	}
    }
    

	 /**
	 * make_detail_info :: detail에 전달할 정보를 생성하는 Event
	 */
	function make_detail_info(sheetObj) {
		var formObj = document.form;
		
		with(sheetObj) {
			var vDelCheck = FindCheckedRow("sheet1_del_chk").split("|");
			var vOfcCd = "";
			var vBndCd = "";
			var vTrspModCd = "";
			var vComma = "";
			var vDscrRsnMap = "";

			for(var i=0; i<vDelCheck.length; i++) {
				if(vDelCheck[i] != "") {
					if(i!=0){ vComma = "#"; };
					vBndCd += vComma + CellValue(vDelCheck[i], "sheet1_trsp_bnd_cd"); 
					vTrspModCd += vComma + CellValue(vDelCheck[i], "sheet1_qry_trsp_mod_cd");
					vOfcCd += vComma + CellValue(vDelCheck[i], "sheet1_qry_ofc_cd");
					vDscrRsnMap += CellValue(vDelCheck[i], "sheet1_dscr_rsn_map");
				}
			}

			ComSetObjValue(formObj.sel_wo_cre_ofc_cd, "");
			ComSetObjValue(formObj.sel_from_date, sheetObj.CellValue(vDelCheck[0], "sheet1_in_from_date"));
			ComSetObjValue(formObj.sel_to_date, sheetObj.CellValue(vDelCheck[0], "sheet1_in_to_date"));
//			ComSetObjValue(formObj.sel_incl_sub_ofc_flg, sheetObj.CellValue(vDelCheck[0], "sheet1_incl_sub_ofc_flg"));

            ComSetObjValue(formObj.sel_ofc_cd, vOfcCd);
			ComSetObjValue(formObj.sel_bnd_cd, vBndCd);
			ComSetObjValue(formObj.sel_trsp_mod_cd, vTrspModCd);
			ComSetObjValue(formObj.sel_dscr_rsn_map, vDscrRsnMap);
			
			ComSetObjValue(formObj.sel_op_tp, "MULTI"); // multi row select and go detail
		}
	}


    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
     	}
    }    

	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    	eval("document.form."+name).select();
    }

	/**
	* 화면 폼입력값에 Null Check
	*/
	function isNull(itemValue){
	   if(itemValue==null || itemValue=="" || itemValue=="undefined"){
	   	return true;
	   }
	   else{
	   	return false;
	   }
	}
	
	function trsp_mod_cd_OnCheckClick(comboObj, index, code) {
		if( code == "ALL" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value = obj;
}
	
//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}
	
//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text

	if(doc_office.checked == true){
		document.form.incl_sub_ofc_flg.value="Y";
	}else{
		document.form.incl_sub_ofc_flg.value="N";
	}
	
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.input_office.value = "";
		ComShowCodeMessage("SCE90061");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value = document.form.old_ofc_cd.value;
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value = "";
		ComShowCodeMessage("SCE90061");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowCodeMessage("SCE90062");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowCodeMessage("SCE90062");
			return false;
		}
	}
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //Master sheet
	document.search_fm_yard.RemoveAll();
	document.search_door_yard.RemoveAll();
	formObject.reset();

}	

/**
 * 공통 Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}
	
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
		
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}

/*
 * 외부 콤보박스의 리스트 가져오기
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;

	for (var i = 0; i < lvobj.length; i++) {
		var oneChar = lvobj.charAt(i)
		if (oneChar != "") {
			if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" )    ){
			}else {
				charval ="N";
				break;
			}
		} else {
			charval ="N";
			break;
		}
	}
	if(charval!="Y") {
		var errMessage = ComGetMsg('COM12130','Location','Node Code','');  
		ComShowMessage(errMessage);
		obj.value = "";
		obj.focus();
		return false;
	}
	if( lvobj == "" ) {
		obj.value = "";
		if(obj.name == 'search_fm_loc') yard_obj = document.search_fm_yard;
		else if(obj.name == 'search_door_loc') yard_obj = document.search_door_yard;

		var locValue = obj.value;
		if(ComTrim(locValue) == ''){
			yard_obj.RemoveAll();
			return;
		}
	}else{
		if( sep == 'F' ) {
			getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else if( sep == 'D' ){
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		}else{
		}
		comObj.focus();
	}
}

/**
 * yard list를 combo에 설정한다.
 * @param comboObj - 설정될 combo객체
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardCombo(comboObj, sheetObj, formObject, value)
{
	var yardList = getYardList(sheetObj, formObject, value);
	var yardArray = new Array();
	yardArray = yardList.split("|");
	comboObj.RemoveAll();
	for(var i=0; i<yardArray.length; i++)
	{
		comboObj.InsertItem(i, yardArray[i], yardArray[i]);
	}
	return yardList;
}

/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardList(sheetObj, formObject, value)
{
    sheetObj.WaitImageVisible  = false;
	formObject.f_cmd.value = SEARCH01;
	var queryString = "searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
    sheetObj.WaitImageVisible  = true;
	return sheetObj.EtcData('nod');
}
/**
 * yard list를 combo에 설정한다.
 * @param comboObj - 설정될 combo객체
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getZoneCombo(comboObj, sheetObj, formObject, value)
{
	var zoneList = getZoneList(sheetObj, formObject, value);
	var zoneArray = new Array();
	zoneArray = zoneList.split("|");
	comboObj.RemoveAll();
	for(var i=0; i<zoneArray.length; i++)
	{
		comboObj.InsertItem(i, zoneArray[i], zoneArray[i]);
	}
	return zoneList;
}
/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getZoneList(sheetObj, formObject, value)
{
    sheetObj.WaitImageVisible  = false;
	formObject.f_cmd.value = SEARCH01;
	var queryString = "isZone=Y&searchStr="+value+"&"+TrsFrmQryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
    sheetObj.WaitImageVisible  = true;
	return sheetObj.EtcData('nod');
}
function TrsFrmQryString(form) {

    if (typeof form != "object" || form.tagName != "FORM") {
        alert("Error : Please contact the administrator\n" + "Detail : Parameter of TrsFrmQryString Function is not a FORM Tag.");
        return "";
    }

    var name = new Array(form.elements.length);
    var value = new Array(form.elements.length);
    var j = 0;
    var plain_text="";

    //사용가능한 컨트롤을 배열로 생성한다.
    len = form.elements.length;
    for (i = 0; i < len; i++) {
      //클래스 아이디로 제품을 구분함-아래는 HTMl제품
      if(form.elements[i].classid==undefined){
    	  //전송전에 폼의 마스크를 제거한다.
//    	  ComClearSeparator(form.elements[i]);
      switch (form.elements[i].type) {
        case "button":
        case "reset":
        case "submit":
          break;
        case "radio":
        case "checkbox":
                    if (form.elements[i].checked == true) {
                        name[j] = form.elements[i].name;
                        value[j] = form.elements[i].value;
                        j++;
                    }
                    break;
            case "select-one":
                    name[j] = form.elements[i].name;
                    var ind = form.elements[i].selectedIndex;
                    if(ind >= 0) {
                        if (form.elements[i].options[ind].value != '')
                            value[j] = form.elements[i].options[ind].value;
                        else
                            value[j] = '';
                    } else {
                        value[j] = "";
                    }
                    j++;
                    break;
            case "select-multiple":
                    name[j] = form.elements[i].name;
                    var llen = form.elements[i].length;
                    var increased = 0;
                    for( k = 0; k < llen; k++) {
                        if (form.elements[i].options[k].selected) {
                            name[j] = form.elements[i].name;
                            if (form.elements[i].options[k].value != '')
                                value[j] = form.elements[i].options[k].value;
                            else
                                value[j] = '';
                            j++;
                            increased++;
                        }
                    }
                    if(increased > 0) {
                        j--;
                    } else {
                        value[j] = "";
                    }
                    j++;
                    break;
                default :
                    if(form.elements[i].value.length >0 ) {
                    	name[j] = form.elements[i].name;
                    	value[j] = form.elements[i].value;
                    	
                    	j++;
                    }
        }
	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//      ComAddSeparator(form.elements[i]);
    //IB에서 제공하는 컨트롤의 값을 조합한다.
    }else{
      switch(form.elements[i].classid){
        case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                value[j] = form.elements[i].Value;
                j++;
          break;
        case CLSID_IBMCOMBO: // IBMultiCombo 경우
          name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
          		if(form.elements[i].UseCode)
          			value[j] = form.elements[i].Code;
          		else
          			value[j] = form.elements[i].Text;
                j++;
                break;
      }
    }
    }

    // QueryString을 조합한다.
    //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
    //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
    var webBrowserName = navigator.appName;
    var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                        navigator.appVersion.indexOf("MSIE") + 8)

    if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
        }
    } else {
        var tmpUrlEncodeSheet    = document.getElementById("TrsFrmQryString");

        if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
        {
            //인코딩을 위해 숨겨진IBSheet를 만든다.
            var sTag = ComGetSheetObjectTag("TrsFrmQryString");
            form.insertAdjacentHTML('afterEnd', sTag);
        }

        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + TrsFrmQryString.UrlEncoding(value[i]) + "&";
        }
    }


  //마지막에 &를 없애기 위함
  if (plain_text != "")
    plain_text = plain_text.substr(0, plain_text.length -1);
    return plain_text;
}
	/* 개발자 작업  끝 */