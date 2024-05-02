/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_S028.js	 	
 *@FileTitle : M&R Repair Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.24	
 *@LastModifier : 박명신	
 *@LastVersion : 1.0
 * 2009.09.24 박명신
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
 * @class EES_MNR_S028 : EES_MNR_S028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */ 
function EES_MNR_S028() {
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

var tpmWoType = "";

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
			cal.select(formObject.fm_est_dt, formObject.to_est_dt, 'yyyy-MM-dd');
			break;
				
		case "btn_Print":	
			if(sheetObjects[1].RowCount == 0){ 
				ComShowCodeMessage("MNR00310"); 			
			} else {
				//있다면  RD 호출
				if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != '' && sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq") != ''){
					var mnr_ord_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq");    
					var mnr_ord_ofc_cty_cd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd");
					var user_nm = formObject.user_nm.value;    
					var rdParam = '/rv mnr_ord_ofc_cty_cd['+ mnr_ord_ofc_cty_cd +'] mnr_ord_seq[' + mnr_ord_seq + '] user_nm[' + user_nm + ']';
					if(formObject.wo_type.Code == 'SPL'){ 
						formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0183.mrd';
						formObject.com_mrdBodyTitle.value = "Simple Work Order";
					} else if(formObject.wo_type.Code == "EXT"){
						formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0187.mrd';
						formObject.com_mrdBodyTitle.value = "Extra Work Order";
					} else if(formObject.wo_type.Code == "RFS"){
						formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0231.mrd';
						formObject.com_mrdBodyTitle.value = "Reefer Spare Part Work Order";					
					} else {  	
						formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd';
						formObject.com_mrdBodyTitle.value = "Repair Work Order";
					} 				
					formObject.com_mrdArguments.value =	rdParam;
					ComOpenRDPopup();
				} else {		
					var eqno 	= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no");
					var seq 	= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_seq"); 
					var verNo 	= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_ver_no");
												  	  
					formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd';
					var rdParam = '/rv rqst_eq_no[' + eqno + '] rpr_rqst_seq[' + seq + '] rpr_rqst_ver_no[' + verNo + '] is_tpb[N]';
					formObject.com_mrdArguments.value =	rdParam;
					formObject.com_mrdBodyTitle.value = "Repair Estimate";
					ComOpenRDPopup();
				}					
			}	
			break; 
			
		case "btn_New": 
			doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
			break;
			
		case "btn_DownExcel": 
			sheetObjects[1].SpeedDown2Excel(-1);	 
			break;		

		case "btn_Retrieve": 
			doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
			break;
		
		case "btn_Detail":	 
			if(sheetObjects[1].RowCount == 0){ 
				ComShowCodeMessage("MNR00309");			
			} else {
				//견적서 팝업 호출 
				if(formObject.wo_type.Code == 'EST'){ 
					if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no")) != ''){
						var rqstEqNo = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no");    
						var rprRqstSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_seq");
						var rprRqstVerNo = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_ver_no");    
						var eqKndCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"eq_knd_cd"); 
						 									
						ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
					}    			
				} else {
					//work order 팝업호출    
					var mnrOrdOfcCtyCd= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd");    
					var mnrOrdSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq");	
					var costOfcCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"cost_ofc_cd");	
					             		 			 	
					retArray = MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);      
					if(retArray == null){                   
						ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);       				
						return;       
					}  
	 				  	 	
					if(formObject.wo_type.Code == 'SPL'){ 
						if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != ''
							&& MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq")) != ''){
							ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 670, '', '0,0', true);   
						}   
					} else if(formObject.wo_type.Code == 'EXT'){ 
						if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != ''
							&& MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq")) != ''){
							ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 530, '', '0,0', true);   
						}    
					} else if(formObject.wo_type.Code == 'RFS'){ 
						if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != ''
							&& MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq")) != ''){
							ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 500, '', '0,0', true);   
						}    
					}
				}  
			}	
			break;
			
			//멀티입력
		case "eq_no_multi1":  
			rep_Multiful_inquiry("rqst_eq_no"); 
			break;	

			//멀티입력
		case "eq_no_multi2": 
			if(formObject.wo_type.Code == 'EST'){ 
				rep_Multiful_inquiry("rqst_ref_no"); 
			}      
			break; 	

			//멀티입력
		case "eq_no_multi3": 
			rep_Multiful_inquiry("wo_no"); 
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	MnrWaitControl(true);
	
	initControl();
	
	for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i + 1);
        //khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    
	for(var k=0;k<comboObjects.length;k++){ 
		initCombo(comboObjects[k],k + 1);   
	} 	   
	
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetObj.id) { 
	case "sheet1": 		
		with (sheetObj) {
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		}		 

	case "sheet2":      // sheet1 init
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
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(26	, 0, 0, true);	 
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)

			var HeadTitle1 = "|Sel.|Seq.|Service Provider|EQ No.|T/S|Est Date|Estimate No.|Curr|Est Amount|System Verify Result|DMG Flag|TPB|W/O No|W/O Issue DT|W/O Send Method|Send Dt|Invoice No|Invoice Amount|Status|Remark(s)";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++,  dtHiddenStatus,	0,    	daCenter,  	false,  "ibflag"); 
			InitDataProperty(0, cnt++ , dtHidden,		40,   	daCenter,	true,	"del_chk");		
			InitDataProperty(0, cnt++ , dtSeq,       	30,		daCenter,  	false,  "Seq",     			false,  "",	dfNone , 		-1,	false,	false,	-1,	false,	false);
			InitDataProperty(0,	cnt++,	dtHidden,		160,	daLeft,		false,	"vndr_nm",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"rqst_eq_no",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,	false,	"eq_tpsz_cd",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			75,		daCenter,	false,	"est_dt",			false,	"",	dfDateYmd,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			115,	daCenter,	false,	"rqst_ref_no",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,	 		40,		daCenter,  	false,	"curr_cd",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			80,		daRight,	false,	"total_amt",		false,	"",	dfNullFloat,	2,	false,	false);
			InitDataProperty(0,	cnt++,	dtCombo,	 	140,	daLeft,    	false,	"mnr_vrfy_tp_cd",	false,	"",	dfNone,			0,	false,	false);	
			InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"dmg_flag",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			35,		daCenter,	false,	"n3pty_flg",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			80,		daLeft,		false,	"wo_no",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			85,		daCenter,	false,	"iss_dt",			false,	"",	dfDateYmd,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtCombo,	 	120,	daLeft,    	false,	"trsm_mod_cd",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"mnr_ord_snd_dt",	false,	"",	dfDateYmd,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"inv_no",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			95,		daCenter,	false,	"inv_amt",			false,	"",	dfNullFloat,	2,	false,	false);
			InitDataProperty(0,	cnt++,	dtCombo,	 	130,	daLeft,    	false,	"status",			false,	"",	dfNone,			0,	false,	false);	
			InitDataProperty(0,	cnt++,	dtCombo,	 	150,	daLeft,    	false,	"ord_hdr_rmk",		false,	"",	dfNone,			0,	false,	false);	

			//MNR_RPR_RQST_HDR	키값  rqst_eq_no	rpr_rqst_seq  rpr_rqst_ver_no	
			InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rpr_rqst_seq",    	false,	"",	dfNone,	0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rpr_rqst_ver_no", 	false,  "", dfNone, 0,  true,   true);
			//W/O키값 
			InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_ord_ofc_cty_cd",	false,  "", dfNone, 0,  true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_ord_seq", 		false,  "", dfNone, 0,  true,   true);
			InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "eq_knd_cd", 			false,  "", dfNone, 0,  true,   true);
		}		
		break;
	}
}

// Sheet관련 프로세스 처리 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {	

	case IBSEARCH:      //목록조회    
		if(validateForm(sheetObj,formObj,sAction)){    
			formObj.f_cmd.value = SEARCH;  
			if(formObj.temp_tpb_only.checked){
				formObj.tpb_only.value = "Y"; 
			} else {
				formObj.tpb_only.value = "N";  
			}  
			var sParam = FormQueryString(formObj);
			 
			sheetObj.DoSearch4Post("EES_MNR_S028GS.do",sParam); 
		} 	        
		break; 
		
	case IBCLEAR:      // 초기화 
		MnrWaitControl(true);
		sheetObj.WaitImageVisible=false;
		//START 
		formObj.reset(); 
		//콤보 초기화	  
		for(var i = 0; i < comboObjects.length;i++){ 
			comboObjects[i].Code = "-1"; 
			comboObjects[i].RemoveAll();	 	       
		}	
					 	
		var sCondition = new Array (		 		 
			//MultiCombo  
			new Array("MnrGenCd","CD00020", "COMMON"),
			new Array("MnrGenCd","","CUSTOM9"),
			//쉬트 콤보 
			new Array("MnrGenCd","CD00082", "COMMON"),    	
			new Array("MnrGenCd","CD00004", "COMMON"), 
			new Array("MnrGenCd","CD00016", "COMMON")  	    
		)		 			
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
								
		//*** W/O Type		
		var comboDefValue = ""; 	
		if(comboList[0] != null){ 	       
			for(var j = 0; j < comboList[0].length;j++){ 
				var tempText = comboList[0][j].split("|");  
				formObj.wo_type.InsertItem(j, tempText[1] ,tempText[0]);
				if(j == 0){	 	
					comboDefValue = tempText[0];  
				}	  	 		 
			}     			  	    
		}  		
		formObj.wo_type.Code = comboDefValue; 
				
		//*** EQ_TYPE	
		if(comboList[1] != null){	
			formObj.eq_knd_cd.InsertItem(0, 'ALL' ,'ALL');        
			for(var j = 1; j < comboList[1].length + 1;j++){ 
				var tempText = comboList[1][j - 1].split("|");	  
				formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
			}				    
		} 
		formObj.eq_knd_cd.Code = 'ALL';   	
											
		var sheetComboText = "";  
		var sheetComboCode = "";
		var sheetComboDefault = new Array();
									
		var comboSaveNames = new Array(); 
		comboSaveNames[0] = "status";
		comboSaveNames[1] = "mnr_vrfy_tp_cd"; 
		comboSaveNames[2] = "trsm_mod_cd";          
			      
		for(var i = 2; i < comboList.length;i++){
		 	if(comboList[i] != null){
					
				sheetComboText = ""; 
				sheetComboCode = "";	
				sheetComboDefault = ""; 
				   
		 		for(var j = 0; j < comboList[i].length;j++){ 
					var tempText = comboList[i][j].split("|");    
					 
					sheetComboText +=  tempText[1] + "|";  
					sheetComboCode +=  tempText[0] + "|";  
					if(j == 0){
						sheetComboDefault[i - 2] = tempText[0];           	
					} 		   
				}		
					
				sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
		     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  	
					
				sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 2], sheetComboText, sheetComboCode ,sheetComboDefault[i - 2]); 
			}				      
		}
						
		//기본 초기값 
		formObj.vndr_seq.value   =  strVndrSeq;
		formObj.fm_est_dt.value  = 	ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
		formObj.to_est_dt.value  = 	ComGetNowInfo("ymd");  
		//END 
		sheetObj.WaitImageVisible=true; 
		MnrWaitControl(false);  
		break;
	}
}

/**  
 * IBCombo Object를 배열로 등록
 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj){	     
	comboObjects[comboCnt++] = combo_obj;  
} 

/**   
 * Combo 기본 설정    
 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */     
function initCombo (comboObj, comboNo) {   
	var formObject = document.form

	switch(comboNo) {      
	default :   
		with (comboObj) { 
		SetColAlign("left");	         
		DropHeight = 200;	 	     
	}   	   
	break;	 	
	} 		
} 

/** 
 * rep_Multiful_inquiry의 리턴처리 메서드
 * @param	{Array}		rowArray	반환되는 Array
 * @param	{String}	return_val	반환되는 form element명
 */
function getMnr_Multi(rowArray,ret_val) { 
	var formObj = document.form; 	 
	var tempText = "";       
	//초기화     
	eval("document.form." + ret_val + ".value = '';"); 

	for(var i=0; i < rowArray.length; i++) {     
		tempText +=  rowArray[i] + ',';      
	}     
	//마지막에 ,를 없애기 위함      
	tempText = MnrDelLastDelim(tempText);		

	eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
} 

function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj = document.form;       
		if(formObj.wo_type.Code == 'EST'){  
			if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"rqst_eq_no")) != ''){
				//있다면 팝업호출 
				var rqstEqNo = sheetObjects[1].CellValue(Row,"rqst_eq_no");    
				var rprRqstSeq = sheetObjects[1].CellValue(Row,"rpr_rqst_seq");
				var rprRqstVerNo = sheetObjects[1].CellValue(Row,"rpr_rqst_ver_no");    
				var eqKndCd = sheetObjects[1].CellValue(Row,"eq_knd_cd"); 
																		
				ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
			}  		 			
		} else { 
			//work order 팝업호출    
			var mnrOrdOfcCtyCd= sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd");    
			var mnrOrdSeq = sheetObjects[1].CellValue(Row,"mnr_ord_seq");	
			 		  
			retArray = MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);
			 				 	  			
			if(retArray == null){                   
				ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);       				
				return;       
			} 
			  	 	 
			if(formObj.wo_type.Code == 'SPL'){ 
				if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 670, '', '0,0', true);   
				}    
			}else if(formObj.wo_type.Code == 'EXT'){ 
				if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 530, '', '0,0', true);   
				}     
			}else if(formObj.wo_type.Code == 'RFS'){ 
				if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 500, '', '0,0', true);   
				}    
			}
		}  	
	}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){ 	       
		switch(sAction) { 	 
		case IBSEARCH:
			if (!ComChkValid(formObj)) return false;

			var arrWoNo = formObj.wo_no.value.split(",");
			if(arrWoNo!=""){
				for(i=0;i<arrWoNo.length;i++){
					if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
						ComShowCodeMessage("MNR00010","W/O No");
						return false;
					}
				}
			}
			break;	
		}   
	}
	return true;
}

function resetCombo3(type,formObj){ 
	formObj.status_cd.removeAll(); 
	formObj.status_cd.DropHeight = 200;
	
	var sCondition = new Array ( 
			new Array("MnrGenCd","CD00082", "COMMON")
	)	

	var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 

	if(comboList[0] != null){ 	
		formObj.status_cd.InsertItem(0,"ALL","ALL");   
		if(type == "EST"){    
			for(var j = 0; j < comboList[0].length;j++){ 
				var tempText = comboList[0][j].split("|");
				formObj.status_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);  	
			}        			  	    
		} else {
			var tempCnt = 1;
			for(var j = 0; j < comboList[0].length;j++){  
				var tempText = comboList[0][j].split("|");    
				if(tempText[0].substring(0,1) != 'H' && tempText[0].substring(0,1) != 'S'){  
					formObj.status_cd.InsertItem(tempCnt, tempText[1] ,tempText[0]);    
					tempCnt++;  
				} 
			}   	         			  	    
		}
		formObj.status_cd.Code = "ALL";  
	}
}	

//콤보 이벤트  					
function wo_type_OnChange(comboObj,Index_Code, Text){ 
	var formObj  = document.form;		 		         
	sheetObjects[1].RemoveAll(); 
	
	resetCombo3(comboObj.Code,formObj);   
	if(comboObj.Code == 'EST'){ 	
		sheetObjects[1].ReturnColumnPos();
		sheetObjects[1].ColHidden("rqst_eq_no") = false; 		
		sheetObjects[1].ColHidden("eq_tpsz_cd") = false; 		
		sheetObjects[1].ColHidden("est_dt") = false; 		
		sheetObjects[1].ColHidden("rqst_ref_no") = false; 		
		sheetObjects[1].ColHidden("curr_cd") = false; 		
		sheetObjects[1].ColHidden("total_amt") = false; 		
		sheetObjects[1].ColHidden("mnr_vrfy_tp_cd") = false; 		
		sheetObjects[1].ColHidden("dmg_flag") = false; 		
		sheetObjects[1].ColHidden("n3pty_flg") = false;
			
		ComSetObjValue(formObj.rqst_ref_no,""); 	
		MnrFormSetReadOnly(formObj,false,"rqst_ref_no");  	
	} else {           
		sheetObjects[1].ColHidden("rqst_eq_no") = true; 		
		sheetObjects[1].ColHidden("eq_tpsz_cd") = true; 		
		sheetObjects[1].ColHidden("est_dt") = true; 		
		sheetObjects[1].ColHidden("rqst_ref_no") = true; 		
		//sheetObjects[1].ColHidden("curr_cd") = true; 		
		sheetObjects[1].ColHidden("total_amt") = true; 		
		sheetObjects[1].ColHidden("mnr_vrfy_tp_cd") = true; 		
		sheetObjects[1].ColHidden("dmg_flag") = true; 		
		sheetObjects[1].ColHidden("n3pty_flg") = true; 

		ComSetObjValue(formObj.rqst_ref_no,"");  
		MnrFormSetReadOnly(formObj,true,"rqst_ref_no");  	
		
		//wo_type변경시  Curr컬럼 이동
		if(tpmWoType == 'EST'){
			sheetObjects[1].MoveColumnPos("curr_cd", "inv_no");
		}		
	}  
	tpmWoType = comboObj.Code; 
}    

function initControl() {        
	//Axon 이벤트 처리1. 이벤트catch  
	var formObject = document.form;       
	axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
}             

//Axon 이벤트 처리2. 이벤트처리함수   
function obj_deactivate(){      
	ComChkObjValid(event.srcElement); 
} 

function obj_activate(){   
	ComClearSeparator(event.srcElement);
}        

function obj_keypress(){   
	obj = event.srcElement;    
	if(obj.dataformat == null) return; 
	window.defaultStatus = obj.dataformat;

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
		ComKeyOnlyAlphabet('uppernum','44');	
		break; 
	}         
}
/* 개발자 작업  끝 */