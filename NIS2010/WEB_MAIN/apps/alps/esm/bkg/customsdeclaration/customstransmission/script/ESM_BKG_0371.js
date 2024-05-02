/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0371.js
*@FileTitle : MRN Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.02 박상훈
* 1.0 Creation
* 1.3 2015.11.11 [CHM-201538768]2015.11월 선박 울산 기항 으로 MRN_undefined 설정 요청  
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0371()
{
	this.processButtonClick		= processButtonClick;
	this.processKeyUp			= processKeyUp;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initControl			= initControl;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0; 

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

document.onkeyup = processKeyUp;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			formObject.mode.value='SEARCH';
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_new":
			formObject.reset();
//			formObject.mrn1.value = ComGetNowInfo("yy").substring(2,4);
			sheetObject.RemoveAll();
			formClear();
			break;							

		case "btn_save":
			
			
				if(document.getElementsByName("rad_kind")[0].checked ){
					//alert("command01");
					formObject.mode.value = 'COMMAND01';
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
				}else{
					formObject.mode.value='MULTI';
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				}
				
				 
				break;	
				
		case "btn_delete":
			formObject.mode.value='REMOVE';
			doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
			break;

		case "btn_downexcel":
			sheetObject.Down2Excel(-1, false, false, true, "", "", false, false, "", true, "Sel");
			break;
		
		case "btn_calendar1":
			var radkind = ComGetObjValue(formObject.elements["rad_kind"]);
			if(radkind == "eta") {
				var cal = new ComCalendar();
				cal.select(formObject.from_dt, 'yyyy-MM-dd');
			}
			break;
			
		case "btn_calendar2":
			var radkind = ComGetObjValue(formObject.elements["rad_kind"]);
			if(radkind == "eta") {
				var cal = new ComCalendar();
				cal.select(formObject.to_dt, 'yyyy-MM-dd');
			}
			
			break;
			
		case "rad_kind":
			
			var radkind = ComGetObjValue(window.event.srcElement);
				
			if(radkind=="vvd"){
	//			formObject.rad_eta.checked = false;
	//			formObject.rad_vvd.checked = true;
				formObject.from_dt.disabled=true;
				formObject.to_dt.disabled=true;
				formObject.from_dt.className="input2";
				formObject.to_dt.className="input2";
				
				formObject.vvd1.className="input1";
				formObject.from_dt.value = "";
				formObject.to_dt.value = "";
				
				formObject.vvd1.disabled=false;
				formObject.from_dt.disabled=true;
				formObject.to_dt.disabled=true;
				
			}else{
				
	//			formObject.rad_eta.checked = true;
	//			formObject.rad_vvd.checked = false;
				
				formObject.from_dt.disabled=false;
				formObject.to_dt.disabled=false;
				formObject.from_dt.className="input1";
				formObject.to_dt.className="input1";
				
				formObject.vvd1.className="input2";
				formObject.vvd1.value = "";
				formObject.vvd1.disabled=true;
				formObject.from_dt.disabled=false;
				formObject.to_dt.disabled=false;
				
			}
				
				
			break;
			
		case "btn_automrn":
			
			var start_num = 0;
			var k = 0;
			var h = 0;
			
			if(formObject.start_num.value == "")
			{ 
				formObject.start_num.focus();
				ComShowCodeMessage('COM130201', 'Start Number');
				return;
			}
			
			start_num = ComLtrim(formObject.start_num.value, "0");
			if(start_num == "") start_num = 0;
			
			for(var i = 1; i <= sheetObject.RowCount; i++) {
				if( sheetObject.CellValue(i,1) != '1' ){					
					sheetObject.CellValue(i, 2) = "";
				}
			}
			
			for(var i = 1; i <= sheetObject.RowCount; i++) {				
				if( sheetObject.CellValue(i,1) == '1' ){
					var arg;
					var bnd = formObject.io_bnd_cd.value;
					var port = formObject.port_cd.value;
					var type = formObject.sel_type.value;
					
					if(bnd == 'I'){  //Inbound인 경우
						if (port == 'KRPUS') 
							{
								if(type == '0'){
									if(parseInt(start_num)+parseInt(k) <= 999) { 
										   arg = '0'
						            } else { 
						            	   arg = 'H'; 
									       h =  999;
									}
								}else if(type == 'H'){
									arg = 'H';
								}
									
							}

						if (port == 'KRKAN') arg = '1';
						if (port == 'KRINC') arg = 'I';
						if (port == 'KRPYT') arg = 'P';
						if (port == 'KRPTK') arg = 'P';
						if (port == 'KRGIN') arg = 'K';
						if (port == 'KRUSN') arg = 'U'; // 2015.11 추가
						
					}else{ //Outbound인 경우
						if (port == 'KRPUS') 
						{
							if(type == 'E'){
								if(parseInt(start_num)+parseInt(k) <= 999) { 
									   arg = 'E'
					            } else { 
					            	   arg = 'F'; 
					            	   h =  999;
								}
							}else if(type == 'F'){
								arg = 'F';
							}
								
						}
						if (port == 'KRKAN') arg = 'G'
						if (port == 'KRINC') arg = '7'
						if (port == 'KRPYT') arg = '8'
						if (port == 'KRPTK') arg = '8'						
						if (port == 'KRGIN') arg = '9'						
						if (port == 'KRUSN') arg = 'S' // 2015.11.11 추가
					}
					
					if(bnd == 'I'){ 
						var cnt = parseInt(start_num)+ parseInt(k) - parseInt(h);					
						var mrnno = sheetObject.CellValue(i, 9).substring(2,4)+'SMLM'+arg+ ComLpad(cnt, 3, 0);
						sheetObject.CellValue(i, 2) = mrnno;
					}else{
						var cnt = parseInt(start_num)+ parseInt(k) - parseInt(h);					
						var mrnno = sheetObject.CellValue(i, 10).substring(2,4)+'SMLM'+arg+ ComLpad(cnt, 3, 0);
						sheetObject.CellValue(i, 2) = mrnno;
					}
					
//					var cnt = parseInt(start_num)+ parseInt(k) - parseInt(h);					
//					var mrnno = ComGetNowInfo("yy").substring(2,4)+'SMLM'+arg+ ComLpad(cnt, 3, 0);
//					sheetObject.CellValue(i, 2) = mrnno;
					
					if(cnt == 999 && arg != 'E' && arg != '0') 
					{
						    ComShowMessage("Please Check MRN No. It can't be assigned over 999!");
							return
					}
					k++;
				}
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

function formClear(){
	
	var formObject = document.form;
	
		formObject.rad_kind.value = "vvd";
		formObject.from_dt.disabled=true;
		formObject.to_dt.disabled=true;
		formObject.from_dt.className="input2";
		formObject.to_dt.className="input2";
		
		formObject.vvd1.className="input1";
		formObject.from_dt.value = "";
		formObject.to_dt.value = "";
		
		formObject.vvd1.disabled=false;
		formObject.from_dt.disabled=true;
		formObject.to_dt.disabled=true;
		
		ComShowObject(formObject.start_num, false);
		ComShowObject(formObject.sel_type, false);
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_automrn");
}

/**
 * 키 입력 처리
 * @return
 */
function processKeyUp() {
	try 
	{
		var form = document.form;
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "port_cd":
			if (form.port_cd.value.length > 5) form.vvd1.focus();
			break;
		case "vvd1":
			if (form.vvd1.value.length > 9) form.from_dt.focus();
			break;
		}
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
	
	formClear();
	
//	axon_event.addListenerFormat('keypress', 'obj_KeyPress', form);
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
	// MRN NO 초기값 설정
	//document.form.mrn1.value = ComGetNowInfo("yy").substring(2,4);	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObject = document.form;
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
    axon_event.addListenerFormat('keypress',         'obj_KeyPress',    formObject); //- 키보드 입력할때
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
}


 function checkList(){
	 var sheetObject = sheetObjects[0];

	 for(var i = 1; i <= sheetObject.RowCount; i++) {	
		 if( sheetObject.CellValue(i,1) == '1' && sheetObject.CellValue(i, 2) == '' ){
			 ComShowMessage('Please uncheck empty MRN No.');
			 return false;
		 }
	 }
	 return true;
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
		style.height = 400;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(11, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)

		var HeadTitle1 = "|Sel.|MRN|MRN|Port|Bound|Lane|VVD|Call Sign|ETA|ETD";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     	daCenter, 		 true,     "ibflag");
		InitDataProperty(0, cnt++ , dtCheckBox,  	60,     daCenter, 		 true,     "Sel");
		InitDataProperty(0, cnt++ , dtData,    		140,    daCenter, 		 true,     "mrn_no",      	false,       "",      dfEngUpKey,   0,     true,		true, 10); 
		InitDataProperty(0, cnt++ , dtData,  		30,    	daCenter, 		 true,     "mrn_chk_no",   	false,       "",      dfNone,      	0,     false,		false, 1);
		InitDataProperty(0, cnt++ , dtData,  		95,     daCenter, 		 true,     "port_cd",  		false,       "",      dfNone,      	0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,    		60,    daCenter, 		 true,     "io_bnd_cd",		false,       "",      dfNone,      	0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,    		75,     daCenter, 		 true,     "lane",   		false,       "",      dfNone,  		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,    		145,    daCenter, 		 true,     "vvd",   		false,       "",      dfNone,  		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,  		100,    daCenter, 		 true,     "call_sgn_no",   false,       "",      dfNone,     	0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,    		135,    daCenter, 		 true,     "vps_eta_dt",    false,       "",      dfDateYmd,  	0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,  		135,     daCenter, 		 true,     "vps_etd_dt",  	false,       "",      dfDateYmd,   	0,     false,		false);
		
	}
	break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
//			if (!ComChkValid(formObj)) return false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.RemoveAll();
			sheetObj.DoSearch("ESM_BKG_0371GS.do", FormQueryString(formObj));
			
			if(formObj.mrn_yn.value == 'Y')
				{
					ComBtnDisable("btn_automrn");
//					formObj.start_num.className ="input2";
//					formObj.start_num.readOnly =true;
//					formObj.start_num.value ="";
					ComShowObject(formObj.start_num, false);
					ComShowObject(formObj.sel_type, false);
					ComBtnDisable("btn_save");
					ComBtnEnable("btn_delete");	
					
				}else{
					if(formObj.crr_cd.value == 'H')
					{	
							ComBtnEnable("btn_automrn");	
							ComShowObject(formObj.start_num, true);
							ComShowObject(formObj.sel_type, true);
//							formObj.start_num.className ="input1";
//							formObj.start_num.value ="";
//							formObj.start_num.readOnly =false;
							var in_select = document.getElementById("sel_type");
							if(form.io_bnd_cd.value == "O"){
								// option 항목을 삭제
								for(var i=0; i<in_select.childNodes.length; i++){
									if(in_select.childNodes[i].nodeName == "OPTION"){
										in_select.childNodes[i].removeNode();
									}
								}
													
								// Outbound용 option 항목을 추가
								var optionList = ["E","F"];
								var valueList  = ["E","F"];
								for(var i=0; i<optionList.length; i++){
									in_select.options[i] =new Option(optionList[i], valueList[i]);
								}
								
								formObj.sel_type.value='E';
								formObj.sel_type.className = "input";
								formObj.sel_type.disabled = false;
							}else{
								// option 항목을 삭제
								for(var i=0; i<in_select.childNodes.length; i++){
									if(in_select.childNodes[i].nodeName == "OPTION"){
										in_select.childNodes[i].removeNode();
									}
								}
								
								// Inbound용 option 항목을 추가
								var optionList = ["0","H"];
								var valueList  = ["0","H"];
								for(var i=0; i<optionList.length; i++){
									in_select.options[i] =new Option(optionList[i], valueList[i]);
								}
								
								formObj.sel_type.value='0';
								formObj.sel_type.className = "input";
								formObj.sel_type.disabled = false;
								
							}
						}else
						{
							ComBtnDisable("btn_automrn");	
							ComShowObject(formObj.start_num, false);
							ComShowObject(formObj.sel_type, false);
//							formObj.start_num.className ="input2";
//							formObj.start_num.readOnly =true;
							
						}
					ComBtnEnable("btn_save");	
					ComBtnDisable("btn_delete");
				}
			
//			formObj.mrn4.value='';
//			if (formObj.mrn3.value.length > 3) formObj.mrn4.value = sheetObj.EtcData('mrn4');
//			// ETA ETD 초기화
//			formObj.vvd1_stdt.value ='';
//			formObj.vvd1_enddt.value ='';
//			formObj.vvd2_stdt.value ='';
//			formObj.vvd2_enddt.value ='';
			
//			sheetObj.Editable = false;
			
			for(var i=0; i <=sheetObj.RowCount; i++) {
				if(form.mrn_yn.value == "Y") {
					sheetObj.CellEditable(i, "mrn_no") = false;
				} else {
					sheetObj.CellEditable(i, "mrn_no") = true;
				}
			}
			ComOpenWait(false);
		}
		break;

	case IBSAVE:        //저장
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			if(validateForm(sheetObj,formObj,sAction)) {
				if (!checkList()) return false;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_BKG_0371GS.do", FormQueryString(formObj), -1, false);	
				ComEtcDataToForm(formObj, sheetObj);
				// ETA, ETD 임시저장
//				var vvd1_stdt = formObj.vvd1_stdt.value;  
//				var vvd2_stdt = formObj.vvd2_stdt.value;  
//				var vvd1_enddt = formObj.vvd1_enddt.value;  
//				var vvd2_enddt = formObj.vvd2_enddt.value; 
				// 2017.04.14 iylee SAVE 후 MRN NO로 조회되게 함.
				formObj.mrn_yn.value='Y';
				formObj.mode.value='SEARCH';
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				// ETA, ETD 복구
//				formObj.vvd1_stdt.value  = vvd1_stdt;
//				formObj.vvd2_stdt.value  = vvd2_stdt;
//				formObj.vvd1_enddt.value = vvd1_enddt;
//				formObj.vvd2_enddt.value = vvd2_enddt;
				ComOpenWait(false);
			}
		}
		break;

	case IBDELETE:      // 삭제
		if(ComShowCodeConfirm('BKG95003', 'delete')){   // Do you want to ...?
			if(validateForm(sheetObj,formObj,sAction)) {
				if (!checkList()) return false;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESM_BKG_0371GS.do", FormQueryString(formObj), -1, false);
				for(var i=1; i <=sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, "Sel")==1) sheetObj.RowHidden(i) = true;
				}
				ComOpenWait(false);
			}
		}
		break;
		
	case COMMAND01: 
		formObj.f_cmd.value = COMMAND01;
	//	alert (ComGetSaveString(sheetObj)+"&"+FormQueryString(formObj));	
		
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0371GS.do",ComGetSaveString(sheetObj)+"&"+FormQueryString(formObj));	
		
		var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	    	
		var result = ComGetEtcData(sXml,"mrnCheck");	
		
		if(State == "S"){
			if (result == "NEW MRN"){		
			formObj.mode.value = MULTI;
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					}
			else if (result == "DUPLICATED"){
				ComShowCodeMessage('BKG01118'); 
			}
			else 		{
					var cutResult = result.split('|');
					if(	ComShowCodeConfirm('BKG06171',cutResult[0],cutResult[1],cutResult[2]))  {
						formObj.mode.value = MULTI;
						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						}
					else
						break;
			}
				 		
		}else{
   	 	      ComShowMessage(ComResultMessage(sXml));
   	 	 } 
		break;

	}
		
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		
		var radkind = ComGetObjValue(formObj.elements["rad_kind"]);
		// SAVE 시
		if (formObj.mode.value=='MULTI') {
//			if (formObj.mrn1.value.length < 2) {
//				ComShowCodeMessage('BKG00689');
//				formObj.mrn1.focus();
//				return false;
//			}
//			if (formObj.mrn2.value.length < 4) {
//				ComShowCodeMessage('BKG00689');
//				formObj.mrn2.focus();
//				return false;
//			}
//			if (formObj.mrn3.value.length < 4) {
//				ComShowCodeMessage('BKG00689');
//				formObj.mrn3.focus();
//				return false;
//			}
//			if (formObj.vvd1.value.length < 9) {
//				ComShowCodeMessage('BKG00115');
//				formObj.vvd1.focus();
//				return false;
//			}
			}
		if (formObj.port_cd.value.length < 5) {
			ComShowCodeMessage('BKG00424');
			formObj.port_cd.focus();
			return false;
		}
		if(radkind=="vvd") {
			if (formObj.vvd1.value.length < 9) {
				ComShowCodeMessage('COM130201', 'VVD');
				formObj.vvd1.focus();
				return false;
			}
		}
		
		if(radkind=="eta") {
			if (formObj.from_dt.value.length < 10) {
				ComShowCodeMessage('COM130201', 'ETA From Date');
				formObj.from_dt.focus();
				return false;
			}
			if (formObj.to_dt.value.length < 10) {
				ComShowCodeMessage('COM130201', 'ETA To Date');
				formObj.to_dt.focus();
				return false;
			}
			if(ComChkPeriod(formObj.from_dt.value, formObj.to_dt.value)< 1) {
				ComShowCodeMessage('COM12133', "ETA To Date", "ETA From Date", "later");
				return false;
			}
			
			if( ComGetDaysBetween(formObj.from_dt.value, formObj.to_dt.value) > 90){
				ComShowMessage("Date exceeds maximum duration (90 days)");
//			ComShowCodeMessage('BKG08257', "3");
				return false;
			} 
		}
		
	}
	return true;
}