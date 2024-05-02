/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0502.js
*@FileTitle : Korea Transmit History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.08 손윤석
* 1.0 Creation
* 2011.11.15 변종건[CHM-201114372-01] 한국지역 적하목록 사전 제출 관련 SYS보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * JSDOC 을 위한 함수 정의
 */
function esm_bkg_0502()
{
	this.processButtonClick		= processButtonClick;
	this.funcChangeSearchOption	= funcChangeSearchOption;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.initCombo				= initCombo;
	this.combo1_OnChange		= combo1_OnChange;
	this.combo2_OnChange		= combo2_OnChange;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
	this.setComboObject			= setComboObject;
	this.toggleSendUnsend		= toggleSendUnsend;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick()
{
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var comboObject1 = comboObjects[0];
	var comboObject2 = comboObjects[1];
	
	
	/*******************************************************/
	var formObject = document.form;

	try 
	{
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) 
		{
            case "btn_retrieve":
            	sheetObject1.Redraw = false;
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            	toggleSendUnsend();
            	sheetObject1.Redraw = true;
                break; 

            case "btn_new":
				// 폼 초기화
				sheetObject1.RemoveAll();
				funcChangSearchOption(formObject, "VVD");
				comboObject1.Code = '5CD';
				comboObject2.Code = 'D';
				formObject.in_sub_cd.value='';
				formObject.in_bl_no.value='';
				formObject.in_vsl_cd.value='';
            	formObject.in_pol_cd.value='';
            	formObject.in_pod_cd.value='';
            	formObject.in_ofc_cd.value='';
            	formObject.in_usr_id.value='';
            	formObject.in_date_op.value='SEND_DATE';
            	formObject.in_snd_dt_s.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
            	formObject.in_snd_dt_e.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
            	funcChangSearchOption(formObject, "DATE");
                break;  
                 
            case "btn_view":            	
            	var Row = sheetObject1.selectRow;
            	if (Row > 0) {
	            	var param = "msg_loc_tp_id="+sheetObject1.CellValue(Row, "a_msg_log_tp_id");
	            		param = param + "&snd_dt="+sheetObject1.CellValue(Row, "a_snd_dt_dd")
	            		      + " "+ComGetMaskedValue(sheetObject1.CellValue(Row, "a_snd_dt_tt"),"hms")
	            		      + "&ofc_cd="+sheetObject1.CellValue(Row, "a_ofc_cd")
	            		      + "&mf_snd_seq="+sheetObject1.CellValue(Row, "mf_snd_seq")
	            		      + "&pgmNo=ESM_BKG_0989";
	            	ComOpenWindow("ESM_BKG_0989.do?"+param, "ESM_BKG_0989", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=660,height=520");
            	}
                break;
            case "rad_vvd_op":
            	if( formObject.combo1.Code != "5VD" ){
            		funcChangSearchOption(formObject, "VVD");
            	}
            	break;
            case "rad_bl_op":
            	if( formObject.combo1.Code != "5VD" ){
            		funcChangSearchOption(formObject, "BL");
            	}
            	break;
            case "rad_sub_op":
            	if( formObject.combo1.Code != "5VD" ){
            		funcChangSearchOption(formObject, "SUB");
            	}
            	break;
            case "rad_date_op":
            	funcChangSearchOption(formObject, "DATE");
            	break;
            case "btn_calendar1":
    			var cal = new ComCalendarFromTo(); 
    			funcChangSearchOption(formObject, "DATE");
    			cal.select(formObject.in_snd_dt_s,formObject.in_snd_dt_e, 'yyyy-MM-dd'); 
    			break;
            case "view_send_unsend":
            	// SEND, UNSEND 필터링
            	sheetObject1.Redraw = false;
            	sheetObject1.ShowWait
            	toggleSendUnsend();
            	sheetObject1.Redraw = true;
            	break;
            	
        } 
	}
	catch(e) 
	{
		if( e == "[object Error]") 
		{
			ComShowMessage(OBJECT_ERROR);
		} 
		else 
		{
			ComShowMessage(e);
		}
	}
}

/**
 * 검색조건을 설정한다.
 * @param op
 * @return
 */
function funcChangSearchOption(formObj, op)
{
	if(op == "VVD")
	{
		formObj.rad_vvd_op.checked 		= true;
		formObj.rad_bl_op.checked 		= false;
		formObj.rad_sub_op.checked 		= false;
		formObj.rad_date_op.checked 	= false;

		formObj.in_vsl_cd.className 	= "input1";
		formObj.in_bl_no.className 		= "input2";
		formObj.in_sub_cd.className 	= "input2";
		formObj.in_snd_dt_s.className 	= "input2";
		formObj.in_snd_dt_e.className 	= "input2";
		
		formObj.in_vsl_cd.disabled 		= false;
		formObj.in_bl_no.disabled 		= true;
		formObj.in_sub_cd.disabled 		= true;
		formObj.in_snd_dt_s.disabled 	= true;
		formObj.in_snd_dt_e.disabled 	= true;
		formObj.in_date_op.disabled 	= true;
		formObj.in_vsl_cd.value 		= "";
		formObj.in_vsl_cd.focus();
	}
	else if(op == "BL")
	{
		formObj.rad_vvd_op.checked 		= false;
		formObj.rad_bl_op.checked 		= true;
		formObj.rad_sub_op.checked 		= false;
		formObj.rad_date_op.checked 	= false;

		formObj.in_vsl_cd.className 	= "input2";
		formObj.in_bl_no.className 		= "input1";
		formObj.in_sub_cd.className 	= "input2";
		formObj.in_snd_dt_s.className 	= "input2";
		formObj.in_snd_dt_e.className 	= "input2";
		
		formObj.in_vsl_cd.disabled 		= true;
		formObj.in_bl_no.disabled 		= false;
		formObj.in_sub_cd.disabled 		= true;
		formObj.in_snd_dt_s.disabled 	= true;
		formObj.in_snd_dt_e.disabled 	= true;
		formObj.in_date_op.disabled 	= true;
		formObj.in_bl_no.value			= "";
		formObj.in_bl_no.focus();
	}
	else if(op == "SUB")
	{
		formObj.rad_vvd_op.checked 		= false;
		formObj.rad_bl_op.checked 		= false;
		formObj.rad_sub_op.checked 		= true;
		formObj.rad_date_op.checked 	= false;

		formObj.in_vsl_cd.className 	= "input2";
		formObj.in_bl_no.className 		= "input2";
		formObj.in_sub_cd.className 	= "input1";
		formObj.in_snd_dt_s.className 	= "input2";
		formObj.in_snd_dt_e.className 	= "input2";
		
		formObj.in_vsl_cd.disabled 		= true;
		formObj.in_bl_no.disabled 		= true;
		formObj.in_sub_cd.disabled 		= false;
		formObj.in_snd_dt_s.disabled 	= true;
		formObj.in_snd_dt_e.disabled 	= true;
		formObj.in_date_op.disabled 	= true;
		formObj.in_sub_cd.value			= "";
		formObj.in_sub_cd.focus();
	}
	else if(op == "DATE")
	{
		formObj.rad_vvd_op.checked 		= false;
		formObj.rad_bl_op.checked 		= false;
		formObj.rad_sub_op.checked 		= false;
		formObj.rad_date_op.checked 	= true;

		formObj.in_vsl_cd.className 	= "input2";
		formObj.in_bl_no.className 		= "input2";
		formObj.in_sub_cd.className 	= "input2";
		formObj.in_snd_dt_s.className 	= "input1";
		formObj.in_snd_dt_e.className 	= "input1";
		
		formObj.in_vsl_cd.disabled 		= true;
		formObj.in_bl_no.disabled 		= true;
		formObj.in_sub_cd.disabled 		= true;
		formObj.in_snd_dt_s.disabled 	= false;
		formObj.in_snd_dt_e.disabled 	= false;
		if( comboObjects[0].Code != '5VD' ){
			formObj.in_date_op.disabled 	= false;
		}
		formObj.in_snd_dt_s.focus();
	}
		
	formObj.p_search_option.value = op;
}


/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++] = sheet_obj;
}



/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() 
{
	var form = document.form;
    for(i=0;i<sheetObjects.length;i++)
    {
    	//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }

    funcChangSearchOption(document.form, "VVD");
    
    axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    
    // 날짜 셋팅
    form.in_snd_dt_s.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
    form.in_snd_dt_e.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
    
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) 
{
	var cnt = 0;
	switch(sheetNo) 
	{
	case 1:      //sheet1 init
		with (sheetObj) 
		{

			// 높이 설정
			style.height =380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			var HeadTitle = "Seq.|MSG|Receiver ID|Receiver|Corr.Code|Send Date|Send Date|VVD|POL|POD|Office|B/L No.|Submit No.|B/L Count|40FT|20FT|User ID|Type|Cancel type|Cancel Reson|Cancel Desc.||";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDataSeq,  40,  daCenter,  true,   "seq", 				false,  "",  dfNone, 	0, 	   false, 	   false, 0, false, false);
			InitDataProperty(0, cnt++ , dtData,  	50,  daCenter,  false,  "a_msg_log_tp_id", 	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,  	85,  daLeft,    false,  "a_mf_rcvr_usr_id",	false,  "",  dfNone,  	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	75,  daCenter,  false,  "a_receiver", 		false,  "",  dfDateYmd,	0,     true,       true);										
			InitDataProperty(0, cnt++ , dtData,  	75,  daCenter,  false,  "a_corr_cd1",      	false,  "",  dfTimeHms,	0,     true,       true);										
			InitDataProperty(0, cnt++ , dtData,  	75,  daCenter,  false,  "a_snd_dt_dd",     	false,  "",  dfDateYmd,	0,     true,       true);										
			InitDataProperty(0, cnt++ , dtData,  	75,  daCenter,  false,  "a_snd_dt_tt",     	false,  "",  dfTimeHms,	0,     true,       true);										
			InitDataProperty(0, cnt++ , dtData,  	95,  daCenter,  false,  "a_vvd_cd",    	  	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,  	70,  daCenter,  false,  "a_pol_cd",   	  	false,  "",  dfNone,  	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	70,  daCenter,  false,  "a_pod_cd",   	  	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	60,  daCenter,  false,  "a_ofc_cd",    		false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	90,  daCenter,  false,  "a_bl_no",   	  	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,    140,  daCenter,  false,  "a_submit_no",    	false,  "",  dfNone,   	0,     true,       true);                    
			InitDataProperty(0, cnt++ , dtData,  	80,  daCenter,  false,  "a_bl_knt",   	  	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,  	50,  daCenter,  false,  "a_fld_40ft",   	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	50,  daCenter,  false,  "a_fld_20ft",   	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	80,  daCenter,  false,  "a_trsm_usr_id",   	false,  "",  dfNone,   	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	60,  daCenter,  false,  "a_ks_type",   	  	false,  "",  dfNone,  	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 	80,  daCenter,  false,  "trsm_cxl_tp_cd",   false,  "",  dfNone,  	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,    100,  daCenter,  false,  "trsm_cxl_rsn_cd",  false,  "",  dfNone,  	0,     true,       true);
			InitDataProperty(0, cnt++ , dtData,    100,  daCenter,  false,  "trsm_cxl_desc",   	false,  "",  dfNone,  	0,     true,       true);
			InitDataProperty(0, cnt++ , dtHidden,	75,  daCenter,  false,  "if_sended",  		false,  "",  dfTimeHms,	0,     true,       true);
			InitDataProperty(0, cnt++ , dtHidden,	75,  daCenter,  false,  "mf_snd_seq",  		false,  "",  dfTimeHms,	0,     true,       true);

			CountPosition = 0;
		}
		break;
	}
}
     
/**
 * 콤보 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch(comboObj.id) {
	case "combo1":
		with (comboObj) {
			SetColAlign("center|center|left");
			SetColWidth("40|40|300");
			DropHeight = 400;
			ShowCol = 1;
			SetTitle("SEQ|MSG|Message Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, cnt+"|5CD|수출 적하목록 상세사항 (CUSMAN)", "5CD");
			InsertItem(cnt ++, cnt+"|5IB|수입 적하목록 상세사항 (CUSMAN)", "5IB");
			InsertItem(cnt ++, cnt+"|5ID|하선신고서 (CUSAGD)",			"5ID");
			InsertItem(cnt ++, cnt+"|5LK|하선신고 정정 (CUSDMR)", 	"5LK");
			InsertItem(cnt ++, cnt+"|SCA|수출 적하목록 정정 (CUSMOD)", 	"SCA");
			InsertItem(cnt ++, cnt+"|5LI|수입 적하목록 정정 (IFTMOD)", 	"5LI");
			InsertItem(cnt ++, cnt+"|6TC|외항 위험물알람표 (DGMNFT)", 		"6TC");
			InsertItem(cnt ++, cnt+"|6TA|외항 위험물반입신고서 (CARDGN)",	"6TA");
			InsertItem(cnt ++, cnt+"|6SJ|화물반출정정신고 (MACAMD)", 		"6SJ");
			InsertItem(cnt ++, cnt+"|6SK|화물반입정정신고 (MACAMD)", 		"6SK");
			InsertItem(cnt ++, cnt+"|5VD|적하목록 취하신청서 송신 (PORTAL)", 		"5VD");
			Code = "5CD";
		}
		break;
	case "combo2":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|100");
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "A|미주 LOCAL", "A");
			InsertItem(cnt ++, "B|아/구주 LOCAL", "B");
			InsertItem(cnt ++, "C|T/S", "C");
			InsertItem(cnt ++, "D|A+B+C+M", "D");
			InsertItem(cnt ++, "E|운항정보 Only", "E");
			InsertItem(cnt ++, "M|eMpty Local", "M");
			
			Code = "D";
		}
		break;    	            
	}
}

/**
 * 콤보1 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo1_OnChange(comboObj,value,text) {
	var form = document.form;
	form.in_msg_type.value = value;
	if (value=="5CD") {
		objEnable();
		if(comboObjects[1].GetCount() == 3){
			comboObjects[1].DeleteItem("E");
			comboObjects[1].DeleteItem(" ");
			comboObjects[1].DeleteItem("M");
			initCombo(comboObjects[1], 2);
		}
		
		comboObjects[1].Enable=true;
		comboObjects[1].Code= 'D';
	// InYoung
	}else if (value=="5IB"||value=="5ID"||value=="6SJ"||value=="6SK"){
		objEnable();
		comboObjects[1].DeleteItem("A");
		comboObjects[1].DeleteItem("B");
		comboObjects[1].DeleteItem("C");
		comboObjects[1].DeleteItem("D");
		if(comboObjects[1].getCount() == 2){
			comboObjects[1].InsertItem(-1, " | ", " ");
			
		}
		comboObjects[1].Code= 'E';
		comboObjects[1].Enable=true;
	}else if( value == "5VD" ){
		sheetObjects[0].RemoveAll();
		document.form.reset();
		form.in_msg_type.value = value;
		
		funcChangSearchOption(document.form, "DATE");
		document.form.in_date_op.value='SEND_DATE';
		document.form.in_snd_dt_s.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
		document.form.in_snd_dt_e.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
    	comboObjects[0].Code = '5VD';

		document.form.rad_vvd_op.disabled = true;
		document.form.rad_bl_op.disabled = true;
		document.form.rad_sub_op.disabled = true;
		document.form.in_date_op.disabled = true;
		
		comboObjects[1].Code = "D";
		document.form.combo2.enable = false;
		document.form.in_pol_cd.disabled = true;
		document.form.in_pol_cd.className = "input2";
		document.form.in_pod_cd.disabled = true;
		document.form.in_pod_cd.className = "input2";
		document.form.in_ofc_cd.disabled = true;
		document.form.in_ofc_cd.className = "input2";
		document.form.in_usr_id.disabled = true;
		document.form.in_usr_id.className = "input2";
		
		for( var idx=0;idx<document.form.view_send_unsend.length;idx++ ){
			document.form.view_send_unsend[idx].disabled = true;
		}
		
		sheetObjects[0].ColHidden("trsm_cxl_tp_cd") = false;
		sheetObjects[0].ColHidden("trsm_cxl_rsn_cd") = false;
		sheetObjects[0].ColHidden("trsm_cxl_desc") = false;
		
	} else {
		objEnable();
		comboObjects[1].Code2= '';
		form.in_ks_type.value= '';
		comboObjects[1].Enable=false;
	}
}
/**
 * 콤보2 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo2_OnChange(comboObj,value,text) {
	var form = document.form;
	form.in_ks_type.value = value;
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) 
{
	switch(sAction) 
	{
	case IBSEARCH:      //조회
	if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0502GS.do", FormQueryString(formObj));
		formObj.in_snd_dt_s.value = ComGetMaskedValue(formObj.in_snd_dt_s.value, "ymd");
		formObj.in_snd_dt_e.value = ComGetMaskedValue(formObj.in_snd_dt_e.value, "ymd");
		ComOpenWait(false);
	}	             		
	break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		formObj.in_snd_dt_s.value = ComGetUnMaskedValue(formObj.in_snd_dt_s.value, "ymd"); 
		formObj.in_snd_dt_e.value = ComGetUnMaskedValue(formObj.in_snd_dt_e.value, "ymd");
		// 선택값에 따른 필수 입력값 체크
		switch(formObj.p_search_option.value) {
		case "VVD":
			if (formObj.in_vsl_cd.value.length < 9) {
				ComShowCodeMessage('BKG00115');
				formObj.in_vsl_cd.focus();
				return false;
			}
			break;
		case "BL":
			if (formObj.in_bl_no.value.length < 12) {
				ComShowCodeMessage('BKG00266');
				formObj.in_bl_no.focus();
				return false;
			}
			break;
		case "SUB":
			if (formObj.in_sub_cd.value.length < 19) {
				ComShowCodeMessage("COM130201", "Sub.No");
				formObj.in_sub_cd.focus();
				return false;
			}
			break;
		case "SEND_DATE":
		case "ETA":
		case "ETD":
		case "DATE":
			if (formObj.in_snd_dt_s.value.length < 8) {
				ComShowCodeMessage('BKG00341');
				formObj.in_snd_dt_s.focus();
				return false;
			}
			if (formObj.in_snd_dt_e.value.length < 8) {
				ComShowCodeMessage('BKG00341');
				formObj.in_snd_dt_e.focus();
				return false;
			}
			formObj.p_search_option.value = formObj.in_date_op.value;
			break;
		}
	}

	return true;
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * SEND, UNSEND 전환
 * @return
 */
function toggleSendUnsend()
{
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	for(var i=1; i <= sheetObj.RowCount; i++) {
		// SEND 체크시
		if (formObj.view_send_unsend[1].checked) {
			if (sheetObj.CellValue(i, "if_sended")=="Send")  
				sheetObj.RowHidden(i)=false;
			else
				sheetObj.RowHidden(i)=true;
		}else if (formObj.view_send_unsend[2].checked) {
			// UNSEND 체크시
			if (sheetObj.CellValue(i, "if_sended")!="Send")  
				sheetObj.RowHidden(i)=false;
			else
				sheetObj.RowHidden(i)=true;
		}else {
			// All Check 시
			sheetObj.RowHidden(i)=false;
		}
	}
}
 
function objEnable(){
	document.form.rad_vvd_op.disabled = false;
	document.form.rad_bl_op.disabled = false;
	document.form.rad_sub_op.disabled = false;
	document.form.in_date_op.disabled = false;
	
	comboObjects[1].Code = "D";
	document.form.combo2.enable = true;
	document.form.in_pol_cd.disabled = false;
	document.form.in_pol_cd.className = "input";
	document.form.in_pod_cd.disabled = false;
	document.form.in_pod_cd.className = "input";
	document.form.in_ofc_cd.disabled = false;
	document.form.in_ofc_cd.className = "input";
	document.form.in_usr_id.disabled = false;
	document.form.in_usr_id.className = "input";
	
	for( var idx=0;idx<document.form.view_send_unsend.length;idx++ ){
		document.form.view_send_unsend[idx].disabled = false;
	}
	
	sheetObjects[0].ColHidden("trsm_cxl_tp_cd") = true;
	sheetObjects[0].ColHidden("trsm_cxl_rsn_cd") = true;
	sheetObjects[0].ColHidden("trsm_cxl_desc") = true;
}