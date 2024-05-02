/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_0130_02.js
*@FileTitle : Charge Summary Report - Detail View
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
* 2013.06.20 송호진 [CHM-201324516] DownExcel 에서 Hidden 되어있는 것들만 빼도록 수정 - SpeedDown2Excel 의 첫번째 인자를 -1 로 하면 ColHidden 을 통해 속성을 변경해도 포함되지 않는 것 같음
*                                 BKG 기준 건수 25,000 건 이상의 경우 메시지 ( PRI01146 ) 을 표시 하도록 수정         
* 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용     
* 2014.02.26 전윤주 [CHM-201429075] Charge Summary Report_Detail view 조회 기능 추가                                                                                                                                                                                                                                                                                                                                                                                
=========================================================*/                                                                                                                                                                                                                                                                                                                                                                                                             
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_PRI_0130_02 : ESM_PRI_0130_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_0130_02() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.initControl        = initControl		 ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnDblClick  = sheet1_OnDblClick  ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];
     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

    	    case "btn_Retrieve":
    	    	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);   
    	        break;

    	    case "btn_Downexcel":
    	    	//sheetObject.SpeedDown2Excel(-1, false, false);
    	    	//Hidden 되어있는 것들만 빼도록 수정 
    	    	//SpeedDown2Excel 의 첫번째 인자를 -1 로 하면 ColHidden 을 통해 속성을 변경해도 포함되지 않는 것 같음 2013.06.20 송호진
    	    	var lastCol = sheetObject.LastCol;
    	    	var hiddenColList = "";
    	    	var hiddenColCount = 0;
    	    	for ( var i=0; i<=lastCol; i++){
    	    		if ( sheetObject.ColHidden(i) ) {
    	    			if ( hiddenColCount == 0 ) {
    	    				hiddenColList = hiddenColList + sheetObject.ColSaveName(i);
    	    			} else if ( hiddenColCount > 0 ) {
    	    				hiddenColList = hiddenColList + "|" + sheetObject.ColSaveName(i);
    	    			}
    	    			hiddenColCount++;
    	    		}
    	    	}
    	    		
    	    	sheetObject.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, hiddenColList );
    	        break;

    	    case "btn_New":
    	    	doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);   
    	        break;
    	        
    	    case "btn_BLinquiry":
    	    	if(sheetObject.RowCount > 0){
    	    		var selcRow = sheetObject.SelectRow;
    	    		if(sheetObject.CellValue(selcRow, "bkg_count")*1 <= 10000){
						var chg_cd = sheetObject.CellValue(selcRow, "chg_cd");
						var svc_scp_cd = sheetObject.CellValue(selcRow, "svc_scp_cd");
						var rhq_cd = sheetObject.CellValue(selcRow, "rhq_cd");
						var bkg_ofc_cd = sheetObject.CellValue(selcRow, "bkg_ofc_cd");
						var por_cd = sheetObject.CellValue(selcRow, "por_cd");
						var pol_cd = sheetObject.CellValue(selcRow, "pol_cd");
						var pod_cd = sheetObject.CellValue(selcRow, "pod_cd");
						var del_cd = sheetObject.CellValue(selcRow, "del_cd");
						var cgo_cate_cd = sheetObject.CellValue(selcRow, "cgo_cate_cd");
						if(sheetObject.CellValue(selcRow, "per_cd") == "Other"){
							var per_cd = "OT";
						}else{
							var per_cd = sheetObject.CellValue(selcRow, "per_cd");
						}
						var f_year = formObject.f_year.value;
						var f_fm_wk = formObject.f_fm_wk.value;
						var f_to_wk = formObject.f_to_wk.value;
						var f_sls_mon = formObject.f_sls_mon.value;
						var f_fm_mon = formObject.f_fm_mon.value;
						var f_to_mon = formObject.f_to_mon.value;
						var start_dt = formObject.start_dt.value;
						var end_dt = formObject.end_dt.value;
						
	        	    	var sParam = "chg_cd="+chg_cd+"&svc_scp_cd="+svc_scp_cd+"&rhq_cd="+rhq_cd+"&bkg_ofc_cd="+bkg_ofc_cd+"&por_cd="+por_cd+"&pol_cd="+pol_cd
	        	    				+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&cgo_cate_cd="+cgo_cate_cd+"&per_cd="+per_cd
	        	    				+"&f_year="+f_year+"&f_fm_wk="+f_fm_wk+"&f_to_wk="+f_to_wk+"&f_sls_mon="+f_sls_mon+"&f_fm_mon="+f_fm_mon
	        	    				+"&f_to_mon="+f_to_mon+"&start_dt="+start_dt+"&end_dt="+end_dt+"&ui_id=ESM_PRI_0130_02";
	        	    	var sUrl = "/hanjin/ESM_PRI_0131.do?"+sParam;
	        	    	ComPriOpenWindowCenter(sUrl, "ESM_PRI_0131", 1000, 600, true);
    	    		}else{
    	    			ComShowCodeMessage("PRI01145");
    	    		}	
    	    	}else{
    	    		ComShowCodeMessage("PRI00011");
    	    	}
    	        break;
    	        
    	    case "btn_BLinquiryexcel":
    	    	if(sheetObject.RowCount > 0){
    	    		var selcRow = sheetObject.SelectRow;
    	    		if(sheetObject.CellValue(selcRow, "bkg_count")*1 <= 25000){
    	    			doActionIBSheet(sheetObjects[0],formObject,IBCREATE);
    	    		}else{
    	    			ComShowCodeMessage("PRI01146");
    	    		}	
    	    	}else{
    	    		ComShowCodeMessage("PRI00011");
    	    	}	
    	        break;
    	        
    	    case "btn_bkg_ofc_cd":
    	    	ComOpenPopup('/hanjin/COM_ENS_071.do', 800, 470, 'getOfc', "1,0,1,1,1,1,1,1", true);
				break;
				
    	    case "btn_por_cd":
            case "btn_pol_cd":
            case "btn_pod_cd":
            case "btn_del_cd":
                var sUrl = "/hanjin/ESM_PRI_4026.do?";
                sUrl += "location_cmd=L";
                var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 300, true);
                if (rtnVal != null){
                    if(srcName == "btn_por_cd") {
                        form.por_cd.value = rtnVal.cd;
                    }else if(srcName == "btn_pol_cd"){
                        form.pol_cd.value = rtnVal.cd;
                    }else if(srcName == "btn_pod_cd"){
                        form.pod_cd.value = rtnVal.cd;
                    }else if(srcName == "btn_del_cd"){
                        form.del_cd.value = rtnVal.cd;
                    }
                }
                break;
				
    	    case "btn_Calendar1":
    	    	var cal = new ComCalendar();
				cal.select(formObject.start_dt, 'yyyy-MM-dd');
    	        break;
    	        
    	    case "btn_Calendar2":
    	    	var cal = new ComCalendar();
				cal.select(formObject.end_dt, 'yyyy-MM-dd');
    	        break;    
    	        
    	    case "cgo_cate_cd_multi":
                CheckBox_OnClick(formObject.cgo_cate_cd_multi, formObject.cgo_cate_cd);
                break;
                
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

function initControl() {
	formObj = document.form;
	axon_event.addListenerForm('activate', 'obj_activate', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('change', 'obj_change', form); 		
	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
	axon_event.addListenerForm('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
}
    
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	 var formObject = document.form;
	 for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet(sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         initControl(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
	 
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	
	initIBComboItem();
	parent.loadTabPage();
	chkWM("W");
	doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
}

/**
 * IBCOMBO를 초기화하는 function <br>
*/
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
 		case "chg_cd_multi":
			with (comboObj) {
				DropHeight = 200;
				MultiSelect = true;
				UseAutoComplete = true;
			}
			break;
			
 		case "svc_scp_cd_multi":
			with (comboObj) {
				DropHeight = 200;
				MultiSelect = true;
				UseAutoComplete = true;
			}
			break;
			
 		case "rhq_cd":
			with (comboObj) {
				BackColor = "white";
				DropHeight = 200;
				MultiSelect = false;
				MaxSelect = 1;
				UseAutoComplete = true;
			}
			break;	
			
 		case "per_cd_multi":
			with (comboObj) {
				BackColor = "white";
				DropHeight = 200;
				MultiSelect = true;
				UseCode = true;
				InsertItem(0,"20","20");
				InsertItem(1,"40","40");
				InsertItem(2,"45","45");
				InsertItem(3,"BL","BL");
				InsertItem(4,"BX","BX");
				InsertItem(5,"Other","OT");
			}
			break;		
     }
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 350;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
				
				var HeadTitle = "FLAG|Charge\nCode|Mandatory\nRating|Scope|RHQ|Booking OFC|POR|POL|POD|DEL|PER|Cargo Type|Tariff Total|Rating Total|Collection Ratio(%)|BKG Count";
				
				var headCount = ComCountHeadTitle(HeadTitle);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				          
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,			90,	 	daCenter,	true,	"chg_cd",      		false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"mdtr_cd",          false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"svc_scp_cd",       false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"rhq_cd",           false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	"bkg_ofc_cd",     	false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"por_cd",     	  	false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"pol_cd",         	false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"pod_cd",         	false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"del_cd",         	false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"per_cd",      		false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"cgo_cate_cd",  	false,  "",   dfNone,   0);
				InitDataProperty(0, cnt++ , dtData,			120,	daRight,	true,	"trf_usd_chg_amt",  false,  "",   dfFloat, 2);
				InitDataProperty(0, cnt++ , dtData,			120,	daRight,	true,	"rat_usd_chg_amt",  false,  "",   dfFloat, 2);
				InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,	"clt_ratio",        false,  "",   dfFloat, 1);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"bkg_count",        false,  "",   dfNone);
				CountPosition  = 0 ;
				ShowButtonImage = 1;	
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

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    var formObj = document.form;
    var headCnt = sheetObj.HeaderRows;
    sheetObj.ColHidden("rhq_cd") = true;
    sheetObj.ColHidden("bkg_ofc_cd") = true;
    sheetObj.ColHidden("por_cd") = true;
    sheetObj.ColHidden("pol_cd") = true;
    sheetObj.ColHidden("pod_cd") = true;
    sheetObj.ColHidden("del_cd") = true;
    sheetObj.ColHidden("per_cd") = true;
    sheetObj.ColHidden("cgo_cate_cd") = true;
    sheetObj.ColHidden("mdtr_cd") = false;
    
    for(var i=headCnt; i<=sheetObj.LastRow; i++){
    	if(sheetObj.CellValue(i, "rhq_cd") != "" ){
			sheetObj.ColHidden("rhq_cd") = false;
		}
		if(sheetObj.CellValue(i, "bkg_ofc_cd") != "" ){
			sheetObj.ColHidden("bkg_ofc_cd") = false;
		}
		if(sheetObj.CellValue(i, "por_cd") != "" ){
			sheetObj.ColHidden("por_cd") = false;
		}
		if(sheetObj.CellValue(i, "pol_cd") != "" ){
			sheetObj.ColHidden("pol_cd") = false;
		}
		if(sheetObj.CellValue(i, "pod_cd") != "" ){
			sheetObj.ColHidden("pod_cd") = false;
		}
		if(sheetObj.CellValue(i, "del_cd") != "" ){
			sheetObj.ColHidden("del_cd") = false;
		}
		if(sheetObj.CellValue(i, "per_cd") != "" ){
			sheetObj.ColHidden("per_cd") = false;
		}
		if(sheetObj.CellValue(i, "cgo_cate_cd") != "" ){
			sheetObj.ColHidden("cgo_cate_cd") = false;
		}
    }
}
    
function obj_change(){
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
    switch(srcName) {
        case "f_year":
        	if(formObj.f_year.value != ""){
        		//Year 형식 체크
            	if(formObj.f_year.value.length != 4){
					ComShowCodeMessage("COM12187", "YYYY");
            		formObj.f_year.value = "";
            	}else{
            		var sXml1= doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
        			var period = ComGetEtcData(sXml1, "period");
        			document.getElementById("div_period").innerHTML = "("+period+")";
            	}	
			}	
               
        	break;
    	
        case "start_dt":
        	if(formObj.start_dt.value != ""){
            	formObj.start_dt.value = ComGetMaskedValue(formObj.start_dt.value, "ymd");
            	if(formObj.end_dt.value != ""){
            		if(!checkPeriod(formObj.start_dt, formObj.end_dt)){
    					ComShowCodeMessage("COM12133", "End date", "start date", "later");
    					formObj.end_dt.value = "";
    					formObj.end_dt.focus();
    					return false;
            		}	
            	}
        	}	
               
        	break;
        	
        case "end_dt":
            if(formObj.end_dt.value != ""){
            	formObj.end_dt.value = ComGetMaskedValue(formObj.end_dt.value, "ymd");
            	if(formObj.start_dt.value != ""){
            		if(!checkPeriod(formObj.start_dt, formObj.end_dt)){
    					ComShowCodeMessage("COM12133", "End date", "start date", "later");
    					formObj.end_dt.value = "";
    					formObj.end_dt.focus();
    					return false;
            		}	
            	}
        	}
            
            break;
        	
        case "f_fm_wk":
        	if(formObj.f_fm_wk.value != ""){
        		//Week 형식 체크
            	var ret = ComIsWeek(formObj.f_fm_wk.value);
            	if(!ret){
					ComShowCodeMessage("COM12187", "WW");
            		formObj.f_fm_wk.value = "";
            	}else{
            		formObj.f_fm_wk.value = ComLpad(formObj.f_fm_wk.value, 2, '0');
            		if(formObj.f_to_wk.value != ""){
            			//To Week가 From Week 보다 큰지 체크
            			if (formObj.f_fm_wk.value > formObj.f_to_wk.value) {
            				ComShowCodeMessage("COM12133", "To week", "from week", "later");
            				formObj.f_to_wk.value = "";
            				formObj.f_to_wk.focus();
            			}else if(formObj.f_year.value != ""){
            				var sXml1= doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
                			var period = ComGetEtcData(sXml1, "period");
                			document.getElementById("div_period").innerHTML = "("+period+")";
            			}	
            		}
            	}
        	}
        	break;
        	
        case "f_to_wk":
        	if(formObj.f_to_wk.value != ""){
        		//Week 형식 체크
            	var ret = ComIsWeek(formObj.f_to_wk.value);
            	if(!ret){
					ComShowCodeMessage("COM12187", "WW");
            		formObj.f_to_wk.value = "";
            	}else{
            		formObj.f_to_wk.value = ComLpad(formObj.f_to_wk.value, 2, '0');
            		if(formObj.f_fm_wk.value != ""){
            			//To Week가 From Week 보다 큰지 체크
            			if (formObj.f_fm_wk.value > formObj.f_to_wk.value) {
            				ComShowCodeMessage("COM12133", "To week", "from week", "later");
            				formObj.f_to_wk.value = "";
            				formObj.f_to_wk.focus();
            			}else if(formObj.f_year.value != ""){
            				var sXml1= doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
                			var period = ComGetEtcData(sXml1, "period");
                			document.getElementById("div_period").innerHTML = "("+period+")"; 
            			}    
            		}
            	}
        	}
        	break;
        
        case "f_fm_mon":
        	if(formObj.f_fm_mon.value != ""){
        		//Month 형식 체크
            	var ret = ComIsMonth(formObj.f_fm_mon.value);
            	if(!ret){
            		ComShowCodeMessage("COM12187", "MM");
            		formObj.f_fm_mon.value = "";
            	}else{
            		formObj.f_fm_mon.value = ComLpad(formObj.f_fm_mon.value, 2, '0');
            		if(formObj.f_to_mon.value != ""){
            			//To Month가 From Month 보다 큰지 체크
            			if (formObj.f_fm_mon.value > formObj.f_to_mon.value) {
            				ComShowCodeMessage("COM12133", "To month", "from month", "later");
            				formObj.f_to_mon.value = "";
            				formObj.f_to_mon.focus();
            			}else if(formObj.f_year.value != ""){
            				var sXml1= doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
                			var period = ComGetEtcData(sXml1, "period");
                			document.getElementById("div_period").innerHTML = "("+period+")"; 
            			}    
            		}
            	}
        	}
        	break;
        	
        case "f_to_mon":
        	if(formObj.f_to_mon.value != ""){
        		//Month 형식 체크
            	var ret = ComIsMonth(formObj.f_to_mon.value);
            	if(!ret){
            		ComShowCodeMessage("COM12187", "MM");
            		formObj.f_to_mon.value = "";
            	}else{
            		formObj.f_to_mon.value = ComLpad(formObj.f_to_mon.value, 2, '0');
            		if(formObj.f_fm_mon.value != ""){
            			//To Month가 From Month 보다 큰지 체크
            			if (formObj.f_fm_mon.value > formObj.f_to_mon.value) {
            				ComShowCodeMessage("COM12133", "To month", "from month", "later");
            				formObj.f_to_mon.value = "";
            				formObj.f_to_mon.focus();
            			}else if(formObj.f_year.value != ""){
            				var sXml1= doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
                			var period = ComGetEtcData(sXml1, "period");
                			document.getElementById("div_period").innerHTML = "("+period+")"; 
            			}    
            		}
            	}
        	}
        	break;
        	
        case "f_sls_mon":
        	if(formObj.f_sls_mon.value != ""){
            	var ret = ComIsMonth(formObj.f_sls_mon.value);
            	if(!ret){
            		ComShowCodeMessage("COM12187", "MM");
            		formObj.f_sls_mon.value = "";
            	}else{
            		formObj.f_sls_mon.value = ComLpad(formObj.f_sls_mon.value, 2, '0');
            		formObj.f_to_mon.value = formObj.f_sls_mon.value;
            		formObj.f_fm_mon.value = formObj.f_sls_mon.value;
            		var sXml1= doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
            		var period = ComGetEtcData(sXml1, "period");
            		if(period == "~"){
            			document.getElementById("div_period").innerHTML = "(INVALID PERIOD)"; 
            		}else{
	        			document.getElementById("div_period").innerHTML = "("+period+")";
            		}
            	}
            	formObj.f_to_mon.value = "";
        		formObj.f_fm_mon.value = "";
        	}
        	break;
        	
    } // end switch
}
    
function obj_blur(){
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var ofcList = "";
	switch(srcName) {   	
 		case "bkg_ofc_cd_multi":
 			chkOfcCdValid();
 			break;
 	}
}
    
/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+"영문대문자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+"영문대소"입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
		
		default:
	}
}
      
/**
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	
		case IBCLEAR: 
			sheetObj.RemoveAll();
			formObj.reset();
			formObj.chg_cd_multi.text = "";
			formObj.svc_scp_cd_multi.text = "";
			formObj.rhq_cd.text = "";
			formObj.per_cd_multi.text = "";
			chkWM("W");
			break;	

		case IBSEARCH:      //조회
			if (!validateForm(sheetObj,formObj,sAction)) {
	            return false;
	        }
			try {
				formObj.jb_id.value = "";
				sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                setParam(formObj);
                formObj.f_cmd.value = COMMAND01;
                formObj.f_excel.value = "N";
                var sParam = FormQueryString(formObj);
                var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_02GS.do", sParam);
                var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                if (backendJobKey.length > 0) {
                	
                    formObj.jb_id.value = backendJobKey;
                    sheetObj.RequestTimeOut = 10000;
                    timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
                }else{
                    ComOpenWait(false);
                }
            }catch(e){
                ComOpenWait(false);
            }
			break;
			
		case IBCREATE:      // File DownLoad 상태조회
	        if (!validateForm(sheetObj,formObj,sAction)) {
	            return false;
	        }
	    
	    	try {
	    		formObj.jb_id.value = "";
		        sheetObj.WaitImageVisible = false;
		        ComOpenWait(true);
		        formObj.f_cmd.value = COMMAND01;
		        formObj.f_excel.value = "Y";
		        var selcRow = sheetObj.SelectRow;
		        var chg_cd = sheetObj.CellValue(selcRow, "chg_cd");
				var svc_scp_cd = sheetObj.CellValue(selcRow, "svc_scp_cd");
				var rhq_cd = sheetObj.CellValue(selcRow, "rhq_cd");
				var bkg_ofc_cd = sheetObj.CellValue(selcRow, "bkg_ofc_cd");
				var por_cd = sheetObj.CellValue(selcRow, "por_cd");
				var pol_cd = sheetObj.CellValue(selcRow, "pol_cd");
				var pod_cd = sheetObj.CellValue(selcRow, "pod_cd");
				var del_cd = sheetObj.CellValue(selcRow, "del_cd");
				var cgo_cate_cd = sheetObj.CellValue(selcRow, "cgo_cate_cd");
				if(sheetObj.CellValue(selcRow, "per_cd") == "Other"){
					var per_cd = "OT";
				}else{
					var per_cd = sheetObj.CellValue(selcRow, "per_cd");
				}
				var f_year = formObj.f_year.value;
				var f_fm_wk = formObj.f_fm_wk.value;
				var f_to_wk = formObj.f_to_wk.value;
				var f_sls_mon = formObj.f_sls_mon.value;
				var f_fm_mon = formObj.f_fm_mon.value;
				var f_to_mon = formObj.f_to_mon.value;
				var start_dt = formObj.start_dt.value;
				var end_dt = formObj.end_dt.value;
				var f_cmd = formObj.f_cmd.value;
				var jb_id = formObj.jb_id.value;
				var f_excel = formObj.f_excel.value;
				
    	    	var sParam = "f_cmd="+f_cmd+"&jb_id="+jb_id+"&f_excel="+f_excel+"&chg_cd="+chg_cd+"&svc_scp_cd="+svc_scp_cd+"&rhq_cd="+rhq_cd+"&bkg_ofc_cd="+bkg_ofc_cd+"&por_cd="+por_cd+"&pol_cd="+pol_cd
    	    				+"&pod_cd="+pod_cd+"&del_cd="+del_cd+"&cgo_cate_cd="+cgo_cate_cd+"&per_cd="+per_cd
    	    				+"&f_year="+f_year+"&f_fm_wk="+f_fm_wk+"&f_to_wk="+f_to_wk+"&f_sls_mon="+f_sls_mon+"&f_fm_mon="+f_fm_mon
    	    				+"&f_to_mon="+f_to_mon+"&start_dt="+start_dt+"&end_dt="+end_dt+"&ui_id=ESM_PRI_0130_02";
		    	var sXml = sheetObj.GetSearchXml("ESM_PRI_0131GS.do", sParam);
		        var backEndJobKey = ComGetEtcData(sXml, "BackEndJobKey");
		        if (backEndJobKey.length > 0) {
		            formObj.jb_id.value = backEndJobKey;
	                sheetObj.RequestTimeOut = 10000;
	                timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
		        }else{
	                ComOpenWait(false);
	            }
	    	}catch(e){
	            ComOpenWait(false);
	        }    
	        break;	
        
		case SEARCH01:      //Charge Code 조회
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_01GS.do", sParam);
			ComPriXml2ComboItem(sXml, formObj.chg_cd_multi, "chg_cd", "chg_cd|chg_nm");
			
			break;
		
		case SEARCH02:      //입력한 B.OFC 유효성 검사
			formObj.f_cmd.value = SEARCH02;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_01GS.do", sParam);
			return sXml;
			
			break;
			
		case SEARCH03:      //WEEK 조회
			formObj.f_cmd.value = SEARCH03;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_01GS.do", sParam);
			return sXml;
			
			break;	
			
		case SEARCH05:      //기간을 리턴한다.
			formObj.f_cmd.value = SEARCH05;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_01GS.do", sParam);
			return sXml;
			
			break;		
	}
}

   /**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	 with(formObj){
         if (f_chkprd[0].checked && f_year.value == "" || f_chkprd[1].checked && f_year.value == "") {
        	// [COM12114] : Year 를(을) 확인하세요.
        	 ComShowMessage(ComGetMsg("COM12114", "Year"));
        	 f_year.focus();
             return false;
         }
         
        if(f_chkprd[0].checked && f_fm_wk.value == ""  || f_chkprd[0].checked && f_to_wk.value == ""){
        	// [COM12114] : Week 를(을) 확인하세요.
		    ComShowMessage(ComGetMsg("COM12114", "Week"));
		    f_fm_wk.focus();
		    return false;
		} 
		if(f_chkprd[1].checked && f_fm_mon.value == "" || f_chkprd[1].checked && f_to_mon.value == ""){
			// [COM12114] : Month 를(을) 확인하세요.
		    ComShowMessage(ComGetMsg("COM12114", "Month"));
		    f_fm_mon.focus();
		    return false;
		}
		if(f_chkprd[2].checked && start_dt.value == "" || f_chkprd[2].checked && end_dt.value == ""){
			// [COM12114] : Period 를(을) 확인하세요.
		    ComShowMessage(ComGetMsg("COM12114", "Period"));
		    start_dt.focus();
		    return false;
		}
		
		if(!checkPeriod(start_dt, end_dt)){
			ComShowCodeMessage("COM12133", "End date", "start date", "later");
			end_dt.value = "";
			end_dt.focus();
			return false;
		}
		
		if(chg_cd_multi.text == "" ){
		    ComShowMessage(ComGetMsg("PRI00316", "Charge Code"));
		    formObj.chg_cd_multi.focus();
		    return false;
		}
		
		if(svc_scp_cd_multi.text == "" ){
		    ComShowMessage(ComGetMsg("PRI00316", "Scope"));
		    formObj.svc_scp_cd_multi.focus();
		    return false;
		}
		
		if(!chkOfcCdValid()){
			return false;
		}
     }
    return true;
}
    
/**
  * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
  */
function initIBComboItem() {
	  ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText,getComboObject(comboObjects, 'svc_scp_cd_multi'), "|", "\t" );
	  ComPriTextCode2ComboItem(rhqComboValue,rhqComboText, getComboObject(comboObjects, 'rhq_cd'), "|", "\t" );
}
     
 /**
 * Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
 */
function chkWM(param1) {
	if (param1 == 'W') {
		document.all.div_year.style.display = "inline";
		document.all.div_week.style.display = "inline";
		document.all.div_month.style.display = "none";
		document.all.div_appl.style.display = "none";
		document.all.div_period.style.display = "inline";
		setPeriod("W");
	} else if(param1 == 'M') {
		document.all.div_year.style.display = "inline";
		document.all.div_week.style.display = "none";
		document.all.div_month.style.display = "inline";
		document.all.div_appl.style.display = "none";
		document.all.div_period.style.display = "inline";
		setPeriod("M");
	} else if(param1 == 'A') {
		document.all.div_year.style.display = "none";
		document.all.div_week.style.display = "none";
		document.all.div_month.style.display = "none";
		document.all.div_appl.style.display = "inline";
		document.all.div_period.style.display = "none";
		setPeriod("A");
	} 
}
     
/**
* month, week가 변경되었을때 Period를 변경한다.
*/
function setPeriod(param){
	var formObject = document.form;
	if(param == "A"){
		formObject.f_year.value = "";
		formObject.f_fm_wk.value = "";
		formObject.f_to_wk.value = "";
		formObject.f_sls_mon.value = "";
		formObject.f_fm_mon.value = "";
	    formObject.f_to_mon.value = "";
	    formObject.start_dt.value = "";
	    formObject.end_dt.value = "";
		formObject.start_dt.value = ComGetNowInfo();
	    formObject.end_dt.value = ComGetNowInfo();
	}else if(param == "W"){
		formObject.f_year.value = "";
		formObject.f_fm_wk.value = "";
		formObject.f_to_wk.value = "";
		formObject.f_sls_mon.value = "";
		formObject.f_fm_mon.value = "";
	    formObject.f_to_mon.value = "";
	    formObject.start_dt.value = "";
	    formObject.end_dt.value = "";
	    
		formObject.f_year.value = ComGetNowInfo("yy");
		var sXml = doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
		var	prevWeek = ComGetEtcData(sXml, "prevWeek");
		formObject.f_fm_wk.value = prevWeek;
		formObject.f_to_wk.value = prevWeek;
		
		var sXml1= doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
		var period = ComGetEtcData(sXml1, "period");
		document.getElementById("div_period").innerHTML = "("+period+")"; 
	}else if(param == "M"){
		formObject.f_year.value = "";
		formObject.f_fm_wk.value = "";
		formObject.f_to_wk.value = "";
		formObject.f_sls_mon.value = "";
		formObject.f_fm_mon.value = "";
	    formObject.f_to_mon.value = "";
	    formObject.start_dt.value = "";
	    formObject.end_dt.value = "";
	    
		formObject.f_year.value = ComGetNowInfo("yy");
		formObject.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
	    formObject.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		var sXml= doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
		var period = ComGetEtcData(sXml, "period");
		document.getElementById("div_period").innerHTML = "("+period+")"; 
	}
}
    
function checkPeriod(fromDate, toDate){
	var fmDt = ComReplaceStr(fromDate.value, "-", "");
	var toDt = ComReplaceStr(toDate.value, "-", "");
	if(ComChkPeriod(fmDt, toDt) < 1){
		return false;
	}else{
		return true;
	}
}
      
function getOfc(rowArray) {
	var formObj = document.form;
	var colArray = rowArray[0];
	if( formObj.bkg_ofc_cd_multi.value != ""){
		formObj.bkg_ofc_cd_multi.value = formObj.bkg_ofc_cd_multi.value + "," + colArray[3];
	} else{
		formObj.bkg_ofc_cd_multi.value = colArray[3];
	}
	formObj.bkg_ofc_cd_multi.focus();
}
    
function chkOfcCdValid(){
	var formObj = document.form;
	if(formObj.bkg_ofc_cd_multi.value != ""){
		formObj.ofc_cd.value = formObj.bkg_ofc_cd_multi.value;
		var sXml = doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
		ofcList = ComGetEtcData(sXml, "ofcList");
		if(ofcList != ""){
			ComShowCodeMessage("PRI01144", ofcList, "office");
			return false;
		}
	}
	return true;
}  
      
function setParam(formObj){
	formObj.bkg_ofc_cd.value = "";
	formObj.chg_cd.value = "";
	formObj.svc_scp_cd.value = "";
	formObj.per_cd.value = "";
	if(formObj.bkg_ofc_cd_multi.value != ""){
		var bkg_ofc_cd_arr = formObj.bkg_ofc_cd_multi.value.split(",");
		formObj.bkg_ofc_cd.value = "'"+(ComReplaceStr(bkg_ofc_cd_arr.toString(), ",", "', '"))+"'";
	}
	if(formObj.chg_cd_multi.text != ""){
		var chg_cd_arr = formObj.chg_cd_multi.text.split(",");
		formObj.chg_cd.value = "'"+(ComReplaceStr(chg_cd_arr.toString(), ",", "', '"))+"'";
	}
	if(formObj.svc_scp_cd_multi.text != ""){
		var svc_scp_cd_arr = formObj.svc_scp_cd_multi.text.split(",");
		formObj.svc_scp_cd.value = "'"+(ComReplaceStr(svc_scp_cd_arr.toString(), ",", "', '"))+"'";
	}
	if(formObj.per_cd_multi.Code != ""){
		var per_cd_arr = formObj.per_cd_multi.Code.split(",");
		formObj.per_cd.value = "'"+(ComReplaceStr(per_cd_arr.toString(), ",", "', '"))+"'";
	}
}

/** 
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다. <br>
 */ 
function getBackEndJobStatus() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
    try {
    	if (formObj.f_excel.value == "Y") {
    		formObj.f_cmd.value = SEARCH;
    		var f_cmd = formObj.f_cmd.value;
			var jb_id = formObj.jb_id.value;
			var f_excel = formObj.f_excel.value;
			var sParam = "f_cmd="+f_cmd+"&jb_id="+jb_id+"&f_excel="+f_excel;
	        var sXml = sheetObj.GetSearchXml("ESM_PRI_0131GS.do", sParam);
	        var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	        if (jobState == "3") {
	            formObj.f_cmd.value = COMMAND02;
	            var f_cmd = formObj.f_cmd.value;
				var jb_id = formObj.jb_id.value;
				var f_excel = formObj.f_excel.value;
				var sParam = "f_cmd="+f_cmd+"&jb_id="+jb_id+"&f_excel="+f_excel;
                document.location.href = "ESM_PRI_0131DL.do?" + sParam;
                document.onreadystatechange = function() {
                    if (document.readyState == "interactive") {
                        ComOpenWait(false);
                    }
                }
                clearInterval(timer);
	        } else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
	            ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
	            clearInterval(timer);	
	            ComOpenWait(false);	
	        } else if (jobState == "5") {
	            ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
	            clearInterval(timer);
	            ComOpenWait(false);	
	        }
    	}else{
    		formObj.f_cmd.value = SEARCH;
            var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_02GS.do", FormQueryString(formObj));
            var jobState = ComGetEtcData(sXml, "jb_sts_flg");
            if (jobState == "3") {
        		getBackEndJobLoadFile();
                clearInterval(timer);
            } else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
                ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
                clearInterval(timer);	
                ComOpenWait(false);	
            } else if (jobState == "5") {
                ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
                clearInterval(timer);
                ComOpenWait(false);	
            }
    	}
    }catch(e){
        ComOpenWait(false);
    }
}

/** 
* BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital) <br>
*/ 
function getBackEndJobLoadFile() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	try {
		formObj.f_cmd.value = SEARCHLIST;
		var sXml = sheetObj.GetSearchXml("ESM_PRI_0130_02GS.do", FormQueryString(form));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);	
	}catch(e){
		ComOpenWait(false);		
	}
}
    
/**
 * Form의 CheckBox를 클릭했을때 체크된 값만 지정된 Hidden input에 setting
 * @param {object} Form Element CheckBox Object 필수
 * @param {object} Form Element Hidden Object 필수
 * @param {int} startRowIdx 선택, Start Row Index
 * @return 없음.
 */
function CheckBox_OnClick(cgo_cate_cd_multi, cgo_cate_cd, startRowIdx) {
	var tempArray = new Array();
	if (startRowIdx == undefined || startRowIdx == null || startRowIdx == "") startRowIdx = 0;
	for (var i=startRowIdx; i<cgo_cate_cd_multi.length; i++) {
		if (cgo_cate_cd_multi[i].checked) {
			tempArray[tempArray.length] = cgo_cate_cd_multi[i].value;
		}
	}
	// form의 input에 setting
	if (tempArray.length > 0) {
		cgo_cate_cd.value = "'"+(ComReplaceStr(tempArray.toString(), ",", "', '"))+"'";
	} else {
		cgo_cate_cd.value = "";
	}
} 
      