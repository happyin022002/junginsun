/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2209.js
 *@FileTitle : Asset inquiry by Year
 *Open Issues :
 *Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : NK Jin-Ho
*@LastVersion : 1.0
* 2011.05.242 NK Jin-Ho
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
 * @class EES_CGM_2209 : EES_CGM_2209 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CGM_2209() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var head_cntr_tpsz_cd ="";
var tot_cntr_tpsz_cd ="";

var IBSEARCH01  = 29;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
	     	case "btns_calendar1": //달력버튼
	     		var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.fm_prd1, 'yyyy-MM');           	 
				break;
	 	 	
	     	case "btns_calendar2": //달력버튼
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.to_prd1, 'yyyy-MM');  
			 	break;  		
					
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
	
			case "btn_new":
			    objectClear();
			    ComResetAll();		
			    loc_tp_cd_change();		    
				document.getElementById("loc_cd").className = "input2";					
				formObject.loc_cd.readOnly = true;
				formObject.ComOpenPopupWithTargetLoc.Enable = false;  		    
				break;
	
			case "btn_downexcel":
				sheetObject1.Down2Excel(-1);
				break;
	
			case "ComOpenPopupWithTargetLoc":
				var tmp = formObject.loc_tp_cd.value;
				if(tmp == "RCC")
				{
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"rcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
				}else if(tmp == "LCC")
				{
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"lcc_cd:loc_cd", "0,0,1,1,1,1,1", true);
				}else if(tmp == "SCC")
				{
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 470,"scc_cd:loc_cd", "0,0,1,1,1,1,1", true);
				}
			break;
			
			case "btn_detail":
	            // 버튼이 활성화 되어있을때만 기능
	            if (ComIsBtnEnable(srcName)) {
	                ComOpenWindowCenter("/hanjin/EES_CGM_2210.do?" +
	                        "mnfr_yr=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "mft_dt") +
	                        "&fm_prd=" + ComGetObjValue(form.fm_prd) +
	                        "&to_prd=" + ComGetObjValue(form.to_prd) +                        
	                        "&cntr_tpsz_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "cntr_tpsz_cd") +
	                        "&lstm_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "lstm_cd") +
	                        "&cntr_pfx_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "cntr_pfx_cd") +
	                        "&fm_ser_no=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "fm_ser_no") +
	                        "&to_ser_no=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "to_ser_no") +
	                        "&mftr_vndr_seq=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "mftr_vndr_seq") +
	                        "&loc_tp_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "loc_tp_cd") +
	                        "&loc_cd=" + sheetObject1.Cellvalue(sheetObject1.SelectRow , "loc_cd"), "EES_CGM_1154", 800, 340);  	                
	            	
	            }			
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
 
	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
	    comboObjects[comboCnt++] = combo_obj;
	} 

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() { 	
		//IBSheet 초기화하기
		for(var i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}	
		
		initControl();		
	}

	/**
	 * sheet1에서 LoadFinish이벤트를 처리한다.
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){  	    	
	        initCombo(comboObjects[k],k+1);
	    }	  
		  
	    comboObjects[1].UseAutoComplete = true;
	    
		ComBtnDisable("btn_downexcel");
		ComBtnDisable("btn_detail");	
	} 
 
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: // t1sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 400;
	
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
	
				var HeadTitle1 = "|MNFR Year|TP/SZ|Term|Contract Q'ty|SLD|TLL|DON|SCR|Current Asset|LST|SBO|LSO|DIO|Current Active";
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(21, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "Status");
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "mft_dt",		false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cntr_tpsz_cd",  false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "lstm_cd",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  true, "ctrt_qty",	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "sld_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "tll_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "don_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "scr_qty", 	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daRight,  true, "aset_qty",	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "lst_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "sbo_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "lso_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 55, daRight, true, "dio_qty",  	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daRight, true, "act_qty",	false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cntr_pfx_cd",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "fm_ser_no",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "to_ser_no",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "mftr_vndr_seq",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "loc_tp_cd",	false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "loc_cd",	false, "", dfNone, 0, true, true);						
			}
			break;
	
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
		case IBSEARCH01:
			formObj.f_cmd.value = SEARCH04;
			formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"comboList");
			var arrStr = sStr.split("@");
			var arrTpSzCd ="";
			
			for (var i = 0; i < arrStr.length;i++ ) {
				var TpSzCd = arrStr[i].split("|");
				if (i == arrStr.length -1){
					arrTpSzCd = arrTpSzCd+TpSzCd[0];
				}else{
					arrTpSzCd = arrTpSzCd+TpSzCd[0]+",";
				}
	       }
		  
			var arrTpSz = arrTpSzCd.split(",");
	        with (form.cntr_tpsz_cd) {
		       	 MultiSelect = true;
		         MultiSeparator = ",";
		       	 DropHeight = 270;
		       	 InsertItem(0 , 'ALL','ALL'); 
		       	 for ( var i=1; i<=arrTpSz.length; i++) {
				        	 InsertItem(i, arrTpSz[i-1], arrTpSz[i-1]);
		       	 }
		       	Text ='ALL';
	        } 
	        
	        break;
	        
		case IBSEARCH: //조회
			if (validateForm(sheetObj, formObj, sAction)){
				form.fm_prd.value = ComReplaceStr(ComGetObjValue(form.fm_prd1), "-", "");
				form.to_prd.value = ComReplaceStr(ComGetObjValue(form.to_prd1), "-", "");
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_CGM_2209GS.do", FormQueryString(formObj));
				ComOpenWait(false);			
			}
			break;
			
	    case IBSEARCH_ASYNC01:     
			formObj.f_cmd.value = SEARCH05;
			var xmlStr = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
		    var chk = xmlStr.indexOf("ERROR");
			if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
			    sheetObj.LoadSearchXml(xmlStr);
			    return;
		    }
			var sStr = ComGetEtcData(xmlStr, "comboList");
			var arrStr = sStr.split("@");
			MakeComboObject(formObj.mftr_vndr_seq, arrStr, 1, 0);      			
			break;
	    case IBSEARCH_ASYNC05:	// Location 조회
			formObj.f_cmd.value = SEARCH17;
			var location = formObj.loc_tp_cd.value;
			
			if(location == "RCC")
			{
				formObj.eq_orz_cht_chktype.value = "RCC";
				formObj.eq_orz_cht_rcc_cd.value = formObj.loc_cd.value;
			}else if(location == "LCC")
			{
				formObj.eq_orz_cht_chktype.value = "LCC";
				formObj.eq_orz_cht_lcc_cd.value = formObj.loc_cd.value;
			}else if(location == "SCC")
			{
				formObj.eq_orz_cht_chktype.value = "SCC";
				formObj.eq_orz_cht_scc_cd.value = formObj.loc_cd.value;
			}else
			{
				formObj.eq_orz_cht_chktype.value = "";
				formObj.eq_orz_cht_scc_cd.value = "";
			}
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
				// 데이터 건수
		    var dataCount = ComGetTotalRows(sXml);
		    if(dataCount==0){
		    	ComShowCodeMessage('CGM10009','location cd');
		   		formObj.loc_cd.value = "";
		    }
		    formObj.loc_cd.focus(); //validation후 focus는 location으로 가게 만든다. 
		    break;	
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			 switch(sAction) {
			 	case IBSEARCH:		
					if(loc_tp_cd.value != 'ALL'){
						if(loc_cd.value == ''){
								ComShowCodeMessage('CGM10004','loc_cd');
								loc_cd.focus();								
								return false;
						}
						
					    if(loc_cd.value.trim().length > 0){
						   if(loc_cd.value.trim().length < 5){
							   ComShowCodeMessage('CGM20042','loc_cd');
							   loc_cd.focus();	        				   
							   return false;
						   }
					    }																
					}
					break;
			 }
		}
	
		return true;
	}	
	
	//======================================================
	// Axon 이벤트 처리
	function initControl() {
		var formObj = document.form;
		
		axon_event.addListenerFormat('beforedeactivate',    'obj_blur',     form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
		axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- 키 눌렸을때  
		axon_event.addListener("change", "range_change1","fm_ser_no");
		axon_event.addListener("change", "range_change2","to_ser_no");	
		axon_event.addListener('click',  'check_cntr_tpsz_cd_check', 'chk_cntr_tpsz_cd', '');	//TP/SZ 체크박스 체크 이벤트 처리
		axon_event.addListener('change', 'cntr_tpsz_cd_change', 'cntr_tpsz_cd', '');			//TP/SZ 변경시 이벤트 처리
	    axon_event.addListener('change', 'loc_tp_cd_change' , 'loc_tp_cd');	
	    axon_event.addListener('change', 'loc_cd_change' , 'loc_cd');	
		
	}

	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "fm_prd1"){
	   		ComAddSeparator(formObj.fm_prd1, "ym");
	    }
	    if (event.srcElement.name == "to_prd1"){
	   		ComAddSeparator(formObj.to_prd1, "ym");
	    }    
	}

	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_focus(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "fm_prd1"){		
	    	ComClearSeparator(formObj.fm_prd1, "ym");
	    	ComSetFocus(formObj.fm_prd1);
	    }	
	    if (event.srcElement.name == "to_prd1"){		
	    	ComClearSeparator(formObj.to_prd1, "ym");
	    	ComSetFocus(formObj.to_prd1);
	    }    
	}

	function obj_keypress(){    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "ym":
	            if(obj.name=="fm_prd1") ComKeyOnlyNumber(this, "-");
	            if(obj.name=="to_prd1") ComKeyOnlyNumber(this, "-");            
	            break;
	        case "engup":
	        	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	        case "int":
	        	ComKeyOnlyNumber(this);
	        	break;            
	    }        
	}

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObject = document.form;   
	
	    switch(comboNo) {  		
		  case 1:		
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH01);
			break;
			
		  case 2:
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
			break;			
	     } 
	}   

	/**
	* range_change
	*/  
	function range_change1(){
		var formObj = document.form;
		var fm_ser_no = formObj.fm_ser_no.value.trim();

		formObj.range_count.value = '';

		if(formObj.fm_ser_no.value.trim().length > 0){
			if(formObj.fm_ser_no.value.trim().length != 6){
				ComShowCodeMessage("CGM20043", formObj.fm_ser_no.value.trim());
				ComSetFocus(formObj.fm_ser_no);
				return;
			}

			if(!ComIsNumber(fm_ser_no)){
				ComShowCodeMessage("CGM20042", formObj.fm_ser_no.value.trim());
				ComSetFocus(formObj.fm_ser_no);
				return;
			}
		}

		getRangeCount();
	}
	
	function range_change2(){
		var formObj = document.form;

		formObj.range_count.value = '';

		if(formObj.to_ser_no.value.trim().length > 0){
			if(formObj.to_ser_no.value.trim().length != 6){
				ComShowCodeMessage("CGM20043", formObj.to_ser_no.value.trim());
				ComSetFocus(formObj.to_ser_no);
				return;
			}
		}

		if(formObj.to_ser_no.value.trim().length > 0){
			if(!ComIsNumber(formObj.to_ser_no)){
				ComShowCodeMessage("CGM20042", formObj.to_ser_no.value.trim());
				ComSetFocus(formObj.to_ser_no);
				return;
			}
		}
		getRangeCount();
	}

	function getRangeCount(){

		var formObj = document.form;
		var fm_no = formObj.fm_ser_no.value.trim();
		var to_no = formObj.to_ser_no.value.trim();

		if(formObj.fm_ser_no.value.trim().length != 6) return;
		if(formObj.to_ser_no.value.trim().length != 6) return;

		var change_count = String(to_no - fm_no + 1);
		formObj.range_count.value = commastring(change_count);

		if(eval(formObj.range_count.value.replaceStr(",","")) < 1){
			ComShowCodeMessage("CGM20044");
			ComSetFocus(formObj.to_ser_no);
			return;
		}
	}	
	
   /**
   * TP/SZ 체크박스 체크 이벤트 처리
   * TP/SZ 체크박스 체크시 전체체크,전체해재 기능
   */
   function check_cntr_tpsz_cd_check() {
       var formObject = document.form;
       if ( formObject.chk_cntr_tpsz_cd.checked ) {
    	   comboObjects[0].Code = tot_cntr_tpsz_cd.replaceStr("|", ",");
       } else {
    	   comboObjects[0].Code = "";
       }
   }
    
   function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
   } 
    
   /**
   * TP/SZ 변경시 이벤트 처리
   * 전체리스트에서 하나라도 체크 해제 되어 있으면 전체체크박스 해제, 전체가 체크되어 있어야 전체체크박스선택
   */          
   function cntr_tpsz_cd_change(comboObj,value,text) {
       var real_cntr_tpsz_cd = tot_cntr_tpsz_cd.replaceStr("|", ",").split(",")
       var cntr_tpsz_cd  = comboObjects[0].Code.split(",");
       if ( real_cntr_tpsz_cd.length !=cntr_tpsz_cd.length) {
    	   document.form.chk_cntr_tpsz_cd.checked = false;
       } else {
    	   document.form.chk_cntr_tpsz_cd.checked = true;
       }       
       
	   	if(  0 <= value.indexOf("ALL") ){
			var strLstmCd =  value.split(",");        	
			document.form.chk_cntr_tpsz_cd.value = ""; 		    
		}else{
			var strTpszCd =  value.replaceStr("|", ",").split(",");
			document.form.chk_cntr_tpsz_cd.value = strTpszCd;
			var sTpSz = document.form.chk_cntr_tpsz_cd.value;                         
		}        
    }  	
	
  	/**
 	 * 콤보 오브젝트 생성(Spec No * Type/Size)
 	 */
 	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
 		cmbObj.RemoveAll();
 		cmbObj.InsertItem(0, "", "");
 		cmbObj.SetColAlign("center|left");
 		for (var i=0; i<arrStr.length; i++) {
 			var arrCode = arrStr[i].split("|");
 			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
 		}
 		cmbObj.Index2 = "" ;
 	}     
 		 	 	 
 	/**
 	 * 기본 오브젝트 초기화 
 	 */
 	function objectClear(){
 		var formObj = document.form;
 		var sheetObj  = sheetObjects[0];

 		// 데이타 초기화
 		sheetObj.RemoveAll();
 		// 화면 초기화
 		formObj.reset();
 	} 	 
 	 
 	function sheet1_OnSearchEnd(){
 		var sheetObj  = sheetObjects[0];
 		
 		if(sheetObj.RowCount > 0){
 			ComBtnEnable("btn_downexcel");
 			ComBtnEnable("btn_detail");	 		
 		}else{
 			ComBtnDisable("btn_downexcel");
 			ComBtnDisable("btn_detail");	 			
 		}
 	}
 	
   /** 
   * Object 의 change 이벤트에 대한 처리  <br>
   * @param  없음
   * @return 없음
   * @author 최민회
   * @version 2009.05.20
   */  
   function loc_tp_cd_change(){
   	   var formObj = document.form;
   	   var sheetObj = sheetObjects[0]; 
   	   obj = event.srcElement;
   	   switch(obj.name){
   	       case "loc_tp_cd":
   		        if(formObj.loc_tp_cd.value == 'ALL'){    			   
   			        formObj.ComOpenPopupWithTargetLoc.Enable = false;
   			        formObj.loc_cd.value = '';
   		            formObj.loc_cd.readOnly = true;
			        document.getElementById("loc_cd").className = "input2";    		       
   		        }else{
   		            formObj.loc_cd.readOnly = false;    			   
   			        formObj.ComOpenPopupWithTargetLoc.Enable = true;    		
			        document.getElementById("loc_cd").className = "input";    			   
   		        }
   		   break;
   	    }   
   }   	
    
   /** 
   * Object 의 change 이벤트에 대한 처리  <br>
   * @param  없음
   * @return 없음
   * @author 최민회
   * @version 2009.05.20
   */  
   function loc_cd_change(){
   	   var formObj = document.form;
   	   var sheetObj = sheetObjects[0]; 
   	   obj = event.srcElement;
   	   
	   	if ( ComTrim(obj.value) != "" ) {
			 if(formObj.loc_tp_cd.value == "RCC" || formObj.loc_tp_cd.value == "LCC" || formObj.loc_tp_cd.value == "SCC"){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
			}
		}
   } 
   /**
   * obj_keyup
   */   
   function obj_keyup() {
        var obj      = event.srcElement;
		var vKeyCode = event.keyCode;
		var formObj  = document.form;

		switch (obj.name) {
			case "fm_ser_no": 
		  		if (formObj.fm_ser_no.value.length == 6) {
		  			if (vKeyCode != 8 && vKeyCode != 46 && vKeyCode != 32 && 
		  				vKeyCode != 37 && vKeyCode != 38 && vKeyCode != 39 && vKeyCode != 40){
						ComSetFocus(formObj.to_ser_no);
		  			}
		  		}
		  		break;
			case "to_ser_no": 
		  		if (formObj.to_ser_no.value.length == 6) {
		  			if (vKeyCode != 8 && vKeyCode != 46 && vKeyCode != 32 && 
		  				vKeyCode != 37 && vKeyCode != 38 && vKeyCode != 39 && vKeyCode != 40){
						ComSetFocus(formObj.range_count);
		  			}
		  		}
		  		break;

		}
	}
   
   /**
   * 천단위 , 추가
   */   
   function commastring(fvalue){  //  , 추가 //
       fvaluenum=fvalue.length; 
       if(fvaluenum>3){
           comma=Math.ceil(fvaluenum/3)-1;
           substart = 0;

           for(x=comma; x>=0; x--){
               sublast = fvaluenum-(x*3);
     
               val=fvalue.substring(substart, sublast);
               substart = sublast;

    

               if(x==comma) vall = val + ',';
               else if(x==0) vall = vall + val;
               else vall = vall + val + ',';
           }
           return vall;
       } else {
           return fvalue;
       }
   }
   
/* 개발자 작업  끝 */