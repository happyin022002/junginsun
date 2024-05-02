	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0054.js 
	 *@FileTitle : M&R Vessel Reefer Spare Part Purchase W/O Creation
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.07
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 *   2009.09.07 권영법
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
	 * @class ees_mnr_0054 : ees_mnr_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0054() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var costDtlCode = "";
	var costDtlDesc = "";
	var OrgCostType = "";
	var nowLoad = 0;
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	
	//Calculate 요청
	var calReq = 0;
	
	//삭제 calculate 계산
	var calDel = "";
	
	var OrgVndrSeq = "";
	var OrgCostCd = "";
	var sprPrtSplDt=""; //Supply Date 날짜변경시 사용
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick; 
	
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject1= sheetObjects[1];
	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
			case "btn_WONo":
				ComOpenPopup("EES_MNR_0211.do", 720, 380, 'setPopUpParam_EES_MNR_0211', '0,0', true);
				break;
			case "btn_Detail":
				ComOpenPopup("EES_MNR_0194.do", 950, 420, 'setPopUpParam_EES_MNR_0194', '0,0', true);
				break;		
			case "btn_calendar":
				sprPrtSplDt=formObject.spr_prt_spl_dt.value;
				var cal = new ComCalendar();  
				cal.setEndFunction("spr_prt_spl_dt_CalendarSetFunction");
				cal.select(formObject.spr_prt_spl_dt, 'yyyy-MM-dd'); 
                break;				         				
			
			case "btn_add":
				doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
				break;
	
			case "btn_delete":
				if(sheetObjects[0].FindCheckedRow("del_chk") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "del_chk");
					
					calReq=0;
				}
	
				break;
	
			case "btn_downExcel":
				sheetObjects[0].SpeedDown2Excel(-1);
				break;
	
			case "btn_loadExcel":
				if(formObject.combo_vndr_seq.Index == "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");    
					ComSetFocus(formObject.combo_vndr_seq);     
					return false;
				}
	
				if(formObject.combo_cost_cd.Index == "-1"){
					ComShowCodeMessage("MNR00205");     
					ComSetFocus(formObject.combo_cost_cd);    
					return false;
				}
				ComOpenPopup("/hanjin/EES_MNR_0219.do", 698, 535, 'setPopUpParam_EES_MNR_0219', '1,0', true); 
	
				break;
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_W/O_Creation":
				//MEXBA-MEXSC 변경에 따른 신규 데이타 생성 막음
				if(currOfcCd == "MEXBA"){
					ComShowCodeMessage("MNR00357");		
					break; 
				}		
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;                    
			case "btn_W/O_Send":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break; 	
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCHAPPEND);
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
	
	//part NO
	function setPopUpParam_EES_MNR_0214(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";	
		var arr = str.split('|');
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"sheet1_spr_prt_nm")= arr[3];
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"sheet1_spr_prt_no")= arr[4];
		sheetObjects[0].SelectCell(sheetObjects[0].SelectRow,"sheet1_rpr_qty",true);

	} 	
	
	function setPopUpParam_EES_MNR_0211(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";	
		var arr = str.split(',');
	
		formObj.mnr_ord_seq.value = arr[4];
	
		if(formObj.mnr_ord_seq.value.length > 3){
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		}
	} 
    
	function setPopUpParam_EES_MNR_0194(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";	
		var arr = str.split(',');
	
		formObj.mnr_ord_seq.value = arr[5];
	
		if(formObj.mnr_ord_seq.value.length > 3){
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		}
	} 
	function spr_prt_spl_dt_CalendarSetFunction()
	{
		var formObj=document.form;
		if(formObj.spr_prt_spl_dt.value.length>=8 && sprPrtSplDt !=""){

			if(formObj.eff_dt.value.length <10)
			{
				formObj.spr_prt_spl_dt.value=formObj.spr_prt_spl_dt.value.substring(0,4)
				+"-"+formObj.spr_prt_spl_dt.value.substring(4,6)
				+"-"+formObj.spr_prt_spl_dt.value.substring(6,8);
			}
			
			if(sprPrtSplDt != formObj.spr_prt_spl_dt.value)
			{
				ComBtnDisable("btn_W/O_Send");
				ComBtnEnable("btn_W/O_Creation");
			}
		}
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
		
		initCombo();
		combo_spr_prt_spl_tp_cd_Initialize();
		sheet1_spr_prt_ut_tp_nm_Initialize();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	
	function initControl() {       
		//Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
		axon_event.addListener('change',	 'obj_change1',	'ord_hdr_rmk'); //- 변경될때.
	}             
	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
		ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
		ComClearSeparator(event.srcElement);
	}   
 
	
	function obj_change()
	{	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{      
			case "mnr_ord_seq":   
				var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail=strMnrOrdSeqAll.substring(3);
				if(!ComIsNumber(strMnrOrdSeqTail))
				{	
					formObj.mnr_ord_seq.value =strMnrOrdSeqAll.substring(0,3);
				}
	
				doActionIBSheet(sheetObj, formObj , IBSEARCH);
				break;  
  			case "vsl_vvd":
  				if(formObj.vsl_vvd.value!="")
  				{
  					ComBtnDisable("btn_W/O_Send");
  					ComBtnEnable("btn_W/O_Creation");
  					checkVesselInfo(sheetObj,formObj.vsl_vvd.value);
  				}
  				break;  
  			case "spr_prt_spl_dt":
				ComBtnDisable("btn_W/O_Send");
				ComBtnEnable("btn_W/O_Creation");
  				break; 
			}       
		} 
	}    
	function obj_change1(){	
		var formObj = document.form;
		for(var i=sheetObjects[0].HeaderRows ;i<=sheetObjects[0].LastRow;i++)
		{

			var intPayInvSeq=sheetObjects[0].CellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )  
			{
				ComShowCodeMessage("MNR00229"); 
			
				formObj.ord_hdr_rmk.value=formObj.ord_hdr_rmk_org.value;
				return false;
			}
		}	
		
		ComBtnDisable("btn_W/O_Send");
		ComBtnEnable("btn_W/O_Creation");

	}
	function obj_keypress(){   
		obj = event.srcElement;    
		keys = event.keyCode;

		if(obj.dataformat == null) return; 
		window.defaultStatus = obj.dataformat;
		var formObj  = document.form; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
			case "mnr_ord_seq":   
				var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail="";
				if(strMnrOrdSeqAll=="NEW")
				{ 	
					formObj.mnr_ord_seq.value="";
				}	
				if(strMnrOrdSeqAll.length > 3)
				{	 	
					if(keys==13)
					{	
						ComSetFocus(formObj.combo_vndr_seq);
					}	
				}		
				break;   
			case "vsl_vvd":   
  				var strVslCdAll=formObj.vsl_vvd.value;
  				if(strVslCdAll.length >= 9)
  				{	 	
  					if(keys==13)
  					{
  						checkVesselInfo(sheetObj,strVslCdAll);
  					}	
					
  				}	
				break; 
			}       
		}				 			              
		switch(obj.dataformat) {   
        case "ymd":
        case "ym":
        case "hms":
        case "hm": 
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
			ComKeyOnlyAlphabet('uppernum');           
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
	
		switch(sheetNo) {
		case 1:      // sheet1 init
		with (sheetObj) 
		{
			// 높이 설정
			style.height = 140;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
	
			var HeadTitle1 = "|Sel|Seq.|Unit Type|Part No.|Part Name|Description|Q'ty|Unit Cost|Total|Remark(s)|cost_cd";
	
			var headCount = ComCountHeadTitle(HeadTitle1);									
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+	"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,     daCenter,   true,           "del_chk",			false,	"", dfNone,		0, 	true,  true);
			InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		    "Seq");
			InitDataProperty(0,	cnt++,	dtCombo,	 	110,  	daLeft,		true,	prefix+	"spr_prt_ut_tp_nm",	false,	"",	dfNone,		0,	true,	true);
			InitDataValid(   0, cnt,  	vtEngUpOther, 	"0123456789-");  
			InitDataProperty(0,	cnt++,	dtPopupEdit,  	150,  	daLeft,		true,	prefix+	"spr_prt_no",		false,	"",	dfEngUpKey,	0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		 	200,  	daLeft,		true,	prefix+	"spr_prt_nm",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,	    	200,    daLeft,		true,	prefix+	"mnr_expn_dtl_nm",	false,	"",	dfNone,		0,	true,	true, 100);
				
			InitDataProperty(0,	cnt++,	dtData,        	80,		daCenter,	true,	prefix+	"rpr_qty",			false,	"",	dfInteger,	0,	true,	true, 6);
			InitDataProperty(0,	cnt++,	dtData,		   	70,		daRight,	true,	prefix+	"spr_prt_uc_amt",	false,	"",	dfFloat,	2,	true,	true, 13);
			InitDataProperty(0,	cnt++,	dtAutoSum,	   	70,		daRight,	true,	prefix+	"cost_amt",			false,	"",	dfFloat,	2,	false,	false,13);
			InitDataProperty(0,	cnt++,	dtData,		   	30,		daLeft,		true,	prefix+	"ord_dtl_rmk",		false,	"",	dfNone,		0,	true,	true, 4000);
			InitDataProperty(0, cnt++ , dtHidden,	 	120,	daCenter,	true,	prefix+ "cost_cd",			false,	"",	dfNone,	    0,	true,	true);

			ShowButtonImage = 1;
		}
		break;


		case 2:      // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			var HeadTitle1 = "MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"                                                                                                                                                                                                 
				+ "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"                                                                                                                                                                                                 
				+ "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"                                                                                                                                                                                              
				+ "|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
			var headCount = ComCountHeadTitle(HeadTitle1);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet2_";

			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_ofc_cty_cd",	false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                   
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_seq",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"eq_knd_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                            
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_grp_tp_cd",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                        
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_wo_tp_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                         
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cost_cd",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                              
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"trsm_mod_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_ofc_cty_cd",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                      
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_seq",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                             
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_ver_no",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"curr_cd",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                              
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_agmt_amt",			false,	"",		dfFloat,	2,	true,true);                                                                                                                                                                                                                                         
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_wrk_amt",			false,	"",		dfFloat,	2,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"inv_amt",				false,	"",		dfFloat,	2,	true,true);                                                                                                                                                                                                                                              
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"ord_iss_ofc_cd",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                       
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_snd_dt",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                       
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cost_ofc_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"vndr_seq",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                             
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_tp_cd",	false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                    
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"vsl_cd",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                               
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"skd_voy_no",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"skd_dir_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_brth_dt",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                      
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_yd_cd",	false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                    
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_dt",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                       
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"ord_hdr_rmk",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_inp_dt",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cre_usr_id",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cre_dt",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                               
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"upd_usr_id",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"upd_dt",				false,	"",		dfNone,		0,	true,true);   

			SelectionMode   = smSelectionRow;    
			SelectHighLight = true;            
			SelectFontBold  = false;          
			SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
			
			CountPosition = 0;
		}
		break;
		case 3: 
			with (sheetObj) {
				//Host정보 설정[필수][HostIp, Port, PagePath]
				                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			}	 
			break;
		}
	}
	
	
	/**
	* 멀티 콤보 초기화 
	* @return
	*/
	function initCombo() {
	
		var formObject = document.form
		with (formObject.combo_vndr_seq) {
			MultiSeparator = "|";
			SetTitle("S/P Name|S/P Code|AGMT No|Office Code|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code"); 
			SetColAlign("left|left|center|center|left|center|left|left|left");   
			SetColWidth("180|70|75|85|70|148|110|135|0");                        
			DropHeight = 160;        
		}  	 
		with (formObject.combo_eq_knd_cd) {
	
			MultiSeparator = "|";
			SetTitle("Code|Name");
	
			//MultiSelect = false;
			SetColAlign("left|left");
			SetColWidth("90|180");
			DropHeight = 160;
	
			Enable = false;
		}
		with (formObject.combo_spr_prt_spl_tp_cd) {
			
 			MultiSeparator = "|";
 			SetColAlign("left");
 			SetColWidth("80");
 			DropHeight = 160;
 			
 			Enable = true;
		}

		//combo_eq_knd_cd_Initialize();
		//combo_spr_prt_spl_tp_cd_Initialize();
	}
	
	
	function checkVesselInfo(sheetObj,vsl_cd){
		var formObj = document.form;
		var sXml = MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr =  MnrXmlToArray(sXml); 
		//0vsl_eng_nm|1 ibflag|2 skd_dir_cd| 3 skd_voy_no|4 pagerows|5 vsl_slan_cd|6 vsl_cd|
		MnrWaitControl(false);
		if(retArr != null){  
			var strVslVvd=formObj.vsl_vvd.value;
			formObj.vsl_cd2.value=strVslVvd.substring(0,4);
			ComSetFocus(formObj.spr_prt_spl_dt);
		} else {	  
			ComShowCodeMessage("MNR00101");
			formObj.vsl_vvd.value="";
			ComSetFocus(formObj.vsl_vvd);
		}	

		calReq=0;
	}	
	
	function combo_vndr_seq_Initialize(){
		var formObj = document.form;
		var sXml = MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
		var arrResult = MnrXmlToArray(sXml);	
	
		if(arrResult != null){	 	     
			for(var i = 0; i < arrResult.length;i ++){
				var tempComboText = arrResult[i][8]       //8 vndr_nm|
				                 + "|" + arrResult[i][1]  //1 vndr_seq|
				                 + "|" + arrResult[i][9]  //9 agmt_no|
				     			 + "|" + arrResult[i][30]  //29 agmt_ofc_cd|
				                 + "|" + arrResult[i][3]   //3eq_type_name|
				                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  //  13 eff_dt - 15 exp_dt|
				                 + "|" + arrResult[i][2] //2 agmt_ref_no| 
				                 + "|" + arrResult[i][25]   //25 trf_no|
				                 + "|" + arrResult[i][14] //14 curr_cd|
				                 + "^" + arrResult[i][12]   //12 agmt_ver_no|
	                             + "^" + arrResult[i][28]   //28eq_knd_cd|
				                  ;				

				formObj.combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]); 

			}				 						
		} else {		
			ComShowCodeMessage("MNR00056");         
		} 	  
	}      
	
	function combo_vndr_seq_OnChange(indexCode, Text){
		var formObj = document.form;
		for(var i=sheetObjects[0].HeaderRows ;i<=sheetObjects[0].LastRow;i++)
		{
	
			var intPayInvSeq=sheetObjects[0].CellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )  
			{
				ComShowCodeMessage("MNR00229"); 
				formObj.combo_vndr_seq.Code2=OrgVndrSeq;
				return false;
			}
		}	
	
		var strEtc =formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  8 );
		var spltEtc =strEtc.split("^");
		formObj.pic_eng_nm.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 0 );
		formObj.curr_cd.value =  spltEtc[0];
		var strAgmtNo =formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  2 ); 
		if(strAgmtNo.length > 3)
		{
			formObj.agmt_ofc_cty_cd.value=strAgmtNo.substring(0,3); 
			formObj.agmt_seq.value=strAgmtNo.substring(3); 
		}
		var strAgmtVerNo=spltEtc[1];
		if ( ComIsNumber(strAgmtVerNo))
		{
			formObj.agmt_ver_no.value= strAgmtVerNo;
		}
		var arr = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  5 ).split("~");
		var tmpEffFrom = "";
		var tmpEffTo   = "";
		
		if(arr==""){
			tmpEffFrom = "";
			tmpEffTo   = "";
		}else{
			tmpEffFrom = arr[0];
			tmpEffTo   = arr[1];
		}	
		formObj.eff_dt.value = tmpEffFrom.trim();
		formObj.exp_dt.value = tmpEffTo.trim();
	
		formObj.combo_eq_knd_cd.Code2 =  spltEtc[2];
		if((sheetObjects[0].RowCount) > 0  && nowLoad == 0){
	
			if(ComShowCodeConfirm("MNR00080")){ 
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
			}
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}     
	
	
	function combo_eq_knd_cd_Initialize(){
		var formObj = document.form;
		formObj.combo_eq_knd_cd.Code2="-1";
		formObj.combo_eq_knd_cd.RemoveAll();
	
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd","CD00002", "COMMON") //EQ Type	
		);
		
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						formObj.combo_eq_knd_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
					}
				}
				if(i ==0)
				{	
					formObj.combo_eq_knd_cd.Code = "";     	
				}
			}
		}
	}  
	
	//Supply To ComboBox
	function combo_spr_prt_spl_tp_cd_Initialize(){
		var formObj = document.form;
		formObj.combo_spr_prt_spl_tp_cd.Code2="-1";
		formObj.combo_spr_prt_spl_tp_cd.RemoveAll();
		
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd","CD00037", "COMMON") //Supply To	
		);
		
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						formObj.combo_spr_prt_spl_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				if(i ==0)
				{	
					formObj.combo_spr_prt_spl_tp_cd.Code = "";     	
				}
			}
		}
	}      
	
	//Supply To ComboBox
	function combo_spr_prt_spl_tp_cd_OnChange(indexCode, Text){
		var formObj = document.form;

		if((sheetObjects[0].RowCount) > 0  && nowLoad == 0){
			ComShowCodeMessage("MNR00080") 
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		}
				
		if(Text=="V")
		{
			ComEnableObject(formObj.vsl_vvd,true);

		}else if(Text=="Y")
		{
			formObj.vsl_vvd.value="";
			ComEnableObject(formObj.vsl_vvd,false);
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}      
		
	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBCLEAR:
			MnrWaitControl(true);
			formObj.f_gubuns.value = "";
			formObj.mnr_ord_seq.value="NEW";
	
			formObj.showDate.value = ComGetNowInfo();
	
			formObj.cost_ofc_cd.value = currOfcCd;
			formObj.pic_eng_nm.value="";
			formObj.eff_dt.value = "";
			formObj.exp_dt.value = "";
			formObj.spr_prt_spl_dt.value =ComGetNowInfo()
			formObj.curr_cd.value = "";
			
			formObj.vsl_vvd.value = "";	
			ComEnableObject(formObj.vsl_vvd,true);
			
			formObj.vsl_cd.value = "";	
			formObj.vsl_cd2.value = "";	
			
			formObj.spr_prt_spl_yd_cd2.value = "";	
			formObj.spr_prt_spl_dt2.value = "";
			formObj.pic_eng_nm2.value = "";
			formObj.combo_vndr_seq.Code2="-1";
			formObj.combo_vndr_seq.RemoveAll();
			//formObj.combo_spr_prt_spl_tp_cd.Code2="-1";
			formObj.combo_spr_prt_spl_tp_cd.Code2="V";
			formObj.ord_hdr_rmk.value="";
			combo_vndr_seq_Initialize ();
			combo_eq_knd_cd_Initialize();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
							
			MnrWaitControl(false);
			ComBtnDisable("btn_W/O_Send");
			break;
	 
		case IBINSERT:
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			var row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(row, "sheet1_spr_prt_ut_tp_nm") = "";
			sheetObj.CellValue2(row, "sheet1_cost_cd") = "MRRUSP";
			sheetObj.SelectCell(row, "sheet1_spr_prt_ut_tp_nm",true);
			calReq=0;
			MnrWaitControl(false);
	
			break;
		case IBSEARCH:      //조회
	
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad = 1;
			formObj.f_gubuns.value = "";
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value = SEARCH; 
			var sParam = "";
			var aryPrefix = new Array("sheet1_", "sheet2_");
		
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0054GS.do", sParam);
			arrDataSearchDbXml = sXml.split("|$$|");
		
			for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
				if(i==0 )continue;
				sheetObjects[i].Redraw = false;
				if (i > 0) {
					sheetObjects[i].WaitImageVisible = false;
				}
				sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
				sheetObjects[i].Redraw = true;
			}   		 	   
			break;
	
		case IBSAVE:        //저장
			if(nowLoad != 0) return;
			MnrWaitControl(true);
			if(!validateForm(sheetObj,formObj,sAction))
			{
				nowLoad=0;
				MnrWaitControl(false);
				return;
			}
			nowLoad=1;
			formObj.vndr_seq.value=formObj.combo_vndr_seq.Code;
			formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Code;
			formObj.spr_prt_spl_tp_cd.value=formObj.combo_spr_prt_spl_tp_cd.Code;
	
			var strVslVvd=formObj.vsl_vvd.value;  //vsl_vvd
			formObj.vsl_cd.value=strVslVvd.substring(0,4);
			formObj.skd_voy_no.value=strVslVvd.substring(4,8);
			formObj.skd_dir_cd.value=strVslVvd.substring(8);
	
		
			formObj.f_cmd.value = MULTI;
		
			var aryPrefix = new Array("sheet1_");
			var sParam = ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				return false;
			}
		
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
		
			var sXml = sheetObj.GetSaveXml("EES_MNR_0054GS.do", sParam);
		
			sheetObjects[0].LoadSaveXml(sXml);
			var f_gubuns=formObj.f_gubuns.value;
		
			if(MnrComGetErrMsg(sXml) == null && f_gubuns==""){
				var mnrOrdSeq = ComGetEtcData(sXml, "mnr_ord_seq");	
				formObj.mnr_ord_seq.value=mnrOrdSeq;
				doActionIBSheet(sheetObj,formObj,IBSEARCH)
		
			}else{
				formObj.f_gubuns.value = "";
			}
		
			break;
	
		case IBSEARCHAPPEND:        //삭제
	
		if(!validateForm(sheetObj,formObj,sAction))return false;
		if(!ComShowCodeConfirm("MNR00026"))
		{
			return false;
		}	
	
		MnrWaitControl(true);
	
		formObj.f_cmd.value = REMOVE;
		formObj.vndr_seq.value=formObj.combo_vndr_seq.Code;
		formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Code;
	
	
		var aryPrefix = new Array("sheet1_");
		var sParam = ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
			return false;
	
		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);
	
		var sXml = sheetObj.GetSaveXml("EES_MNR_0054GS.do", sParam);
	
		sheetObjects[0].LoadSaveXml(sXml);
	
		if(MnrComGetErrMsg(sXml) == null){
			var mnrOrdSeq = ComGetEtcData(sXml, "mnr_ord_seq");	
			doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	
	
		}
		break;				
	
		case IBDOWNEXCEL:
			sheetObj.SpeedDown2Excel(-1);
			break;
	
		case COMMAND01:     //W/O Doc Send
		// ComOpenPopup("EES_MNR_0036.do", 720, 380, 'setDocSendParam', '0,0', true);
		/*    선택된 Grid Detail의 정보중 Work Order 정보를 Array로 PopUp으로 전달 한다.
		          [입력항목]
		          Preview Type, Service Provider Code, Work Order Number[Array]
		*/
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
	
		if(strMnrOrdSeq!="" && strMnrOrdSeq!="NEW" )
		{
			ComOpenPopup("EES_MNR_0036.do?wo_no="+strMnrOrdSeq, 900, 600, 'setDocSendParam', '0,1', true);
		}
	
		break;
	
		}
	
	}
	
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if(nowLoad != 0) return;
		if (sheetObj.ColSaveName(Col) != "sheet1_spr_prt_no") return;

		//2. 해당 Unit Type 빈값일 경우
		var strCostDtlCD =ComTrimAll(sheetObj.CellValue(Row, "sheet1_spr_prt_ut_tp_nm")," ");
		if(strCostDtlCD=="")
		{
			ComShowCodeMessage("MNR00036","Unit Type");
			sheetObj.SelectCell(Row, "sheet1_spr_prt_ut_tp_nm",	true);
			return; 
		}
		ComOpenPopup("EES_MNR_0214.do", 700, 450, 'setPopUpParam_EES_MNR_0214', '0,0', true);
	}   

	
	function sheet1_OnChange(sheetObj,Row, Col, Value)
	{
		if(nowLoad == 0)
		{
			ComBtnEnable("btn_W/O_Creation");
			ComBtnDisable("btn_W/O_Send");
			if(sheetObj.ColSaveName(Col) == "sheet1_rpr_qty")
			{
	
				sheet1_rpr_qty_OnChange(sheetObj,Row, Col, Value);

			}else if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_uc_amt")
			{
				sheet1_spr_prt_uc_amt_OnChange(sheetObj,Row, Col, Value);
			}else if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_no")
			{
				sheet1_spr_prt_no_OnChange(sheetObj,Row, Col, Value);
			}
		}

		if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_ut_tp_nm")
		{
			if(Value=="HC"){
				sheetObj.CellEditable(Row,"sheet1_spr_prt_no") = false;
				sheetObj.CellEditable(Row,"sheet1_mnr_expn_dtl_nm") = true;
				sheetObj.SelectCell(Row, "sheet1_mnr_expn_dtl_nm",true);
				sheetObj.CellValue2(Row,"sheet1_spr_prt_no")="";
				sheetObj.CellValue2(Row,"sheet1_spr_prt_nm")="";
			}else{
				sheetObj.CellEditable(Row,"sheet1_spr_prt_no") = true;
				sheetObj.CellEditable(Row,"sheet1_mnr_expn_dtl_nm") = false;
				sheetObj.CellValue2(Row,"sheet1_mnr_expn_dtl_nm")="";	
			}
		}
	}    
	
	function sheet1_rpr_qty_OnChange(sheetObj,Row, Col, Value){
		var bzcAmt =  MnrNullToZero(sheetObjects[0].CellValue(Row, "sheet1_spr_prt_uc_amt"));
		var qty = MnrNullToZero(sheetObjects[0].CellValue(Row, "sheet1_rpr_qty"));
		sheetObjects[0].CellValue(Row, "sheet1_cost_amt") = parseFloat(bzcAmt) * parseFloat(qty);
	}
	
	function sheet1_spr_prt_uc_amt_OnChange(sheetObj,Row, Col, Value){
		var bzcAmt =  MnrNullToZero(sheetObjects[0].CellValue(Row, "sheet1_spr_prt_uc_amt"));
		var qty = MnrNullToZero(sheetObjects[0].CellValue(Row, "sheet1_rpr_qty"));
		sheetObjects[0].CellValue(Row, "sheet1_cost_amt") = parseFloat(bzcAmt) * parseFloat(qty);
	}
	
	/**
	 * 그리드 파트넘버(PART NO) 입력값에 대한 고유성검증 프로세스 처리
	 */
	function sheet1_spr_prt_no_OnChange(sheetObj,Row, Col, Value){


				
		if(nowLoad !=0)return;
		nowLoad=1;
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH; 
		formObj.spr_prt_no.value=sheetObj.CellValue(Row,"sheet1_spr_prt_no");
		if(formObj.spr_prt_no.value=="")return;
		var sParam = "";
		var aryPrefix = new Array("sheet4_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	
		var sXml   = sheetObjects[1].GetSearchXml("EES_MNR_0137GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");
		var retArr =  MnrXmlToArray(sXml); 

		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {

			var Slength=arrDataSearchDbXml[i].indexOf("TOTAL='");
			var intSize=arrDataSearchDbXml[i].substring(Slength + 7,Slength + 8);
		}   
		
		formObj.f_cmd.value = ""; 
		
		if(intSize<=0)
		{
			ComShowCodeMessage("MNR00165",formObj.spr_prt_no.value,"Part No.");

			sheetObj.CellValue(Row,"sheet1_spr_prt_no")="";
			nowLoad=0;
			sheetObj.SelectCell(Row,"sheet1_spr_prt_no",true);
	
		}else{
			sheetObj.CellFont("FontBold", Row, "sheet1_spr_prt_ut_tp_nm") = false;
			sheetObj.CellFont("FontBold", Row, "sheet1_spr_prt_no") = false;
			sheetObj.CellFont("FontBold", Row - 1, "sheet1_spr_prt_ut_tp_nm") = false;
			sheetObj.CellFont("FontBold", Row - 1, "sheet1_spr_prt_no") = false;
			sheetObj.CellFont("FontBold", Row + 1, "sheet1_spr_prt_ut_tp_nm") = false;
			sheetObj.CellFont("FontBold", Row + 1, "sheet1_spr_prt_no") = false;
			sheetObj.CellValue(Row,"sheet1_spr_prt_nm")=retArr[0][4];
			nowLoad=0;
			sheetObj.SelectCell(Row,"sheet1_rpr_qty",true);
		}
		

	}	
	
	function sheet1_spr_prt_ut_tp_nm_Initialize(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd","CD00009", "COMMON") //SHEET UNIT Type
		);
		costDtlCode = "";
		costDtlDesc = "";
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						costDtlCode = costDtlCode + tempText[0] + "|";
						costDtlDesc = costDtlDesc + tempText[1] + "|";
					}
				}
				if(i==0)
				{
					costDtlCode = costDtlCode.substring(0, costDtlCode.length - 1);
					costDtlDesc = costDtlDesc.substring(0, costDtlDesc.length - 1);
					sheetObjects[0].InitDataCombo(0, "sheet1_spr_prt_ut_tp_nm", costDtlDesc, costDtlCode, costDtlCode.substring(0,costDtlCode.indexOf("|")) );
				}
			}
		}
	}          
	
	function sheet1_spr_prt_ut_tp_nm_AND_spr_prt_no_UniqueCheck()
	{
		var sSprPrtUtTpNm="";  
		var sSprPrtNo=""; 
		var chkOk=false;
		sheetObj=sheetObjects[0];
		sheetObj.ColumnSort("sheet1_spr_prt_ut_tp_nm|sheet1_spr_prt_no", "ASC");
		for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
		{
			if(sheetObj.RowStatus(i)=="D") continue;
			var checkEqNo=sheetObj.CellValue(i, "sheet1_spr_prt_no"); 
			if(checkEqNo=="") continue;
			sheetObj.CellFont("FontBold", i, "sheet1_spr_prt_no") = false;
			if(chkOk==false)
			{

				sSprPrtUtTpNm=sheetObj.CellValue(i, "sheet1_spr_prt_ut_tp_nm");  
				sSprPrtNo=sheetObj.CellValue(i, "sheet1_spr_prt_no"); 
				chkOk=true;
				continue;
			}else{
				if(sSprPrtUtTpNm ==sheetObj.CellValue(i, "sheet1_spr_prt_ut_tp_nm")
						&& sSprPrtNo ==sheetObj.CellValue(i, "sheet1_spr_prt_no")
				)
				{
					var sSeq=sheetObj.CellValue(i, "Seq");
					sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq)- 1, "sheet1_spr_prt_ut_tp_nm") = true;
					sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq)- 1, "sheet1_spr_prt_no") = true;
					sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq), "sheet1_spr_prt_ut_tp_nm") = true;
					sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq), "sheet1_spr_prt_no") = true;

					ComShowCodeMessage("MNR00006","Unit Type and Part No");
					sheetObj.SelectCell(sheetObj.FindText("Seq",sSeq), "sheet1_spr_prt_no",true);
				
					return false;

				}else
				{
					sSprPrtUtTpNm=sheetObj.CellValue(i, "sheet1_spr_prt_ut_tp_nm");  
					sSprPrtNo=sheetObj.CellValue(i, "sheet1_spr_prt_no"); 
				} 
			}
		}
		sheetObj.ColumnSort("Seq", "ASC"); //정렬 초기화
		return true;
	}
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
				if(strMnrOrdSeq=="" || strMnrOrdSeq=="NEW" )
				{
					ComShowCodeMessage("MNR00073");
	
				}else{
					ComShowCodeMessage("MNR00222");
				}
			} else { 
				ComShowCodeMessage("MNR00074",ErrMsg);
			}
		}else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "") { 
				ComShowCodeMessage("MNR00082",ErrMsg);
			} else { 
				ComShowCodeMessage("MNR00027",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
	}	 

	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		if(sheetObj.RowCount>0){
	    	for(i=sheetObj.LastRow - 1; i > 0 ; i--){
				if(sheetObj.CellValue(i,"sheet1_spr_prt_ut_tp_nm") == "HC"){
					sheetObj.CellEditable(i,"sheet1_spr_prt_no") = false;
					sheetObj.CellEditable(i,"sheet1_mnr_expn_dtl_nm") = true;
					sheetObj.CellValue2(i,"sheet1_spr_prt_no")="";
					sheetObj.CellValue2(i,"sheet1_spr_prt_nm")="";
				}else{
					sheetObj.CellEditable(i,"sheet1_spr_prt_no") = true;
					sheetObj.CellEditable(i,"sheet1_mnr_expn_dtl_nm") = false;
					sheetObj.CellValue2(i,"sheet1_mnr_expn_dtl_nm")="";					
				}
			}
		}
	}	
	
	function sheet2_OnSearchEnd(sheetObj, errMsg)
	{
		var formObj = document.form;
		var prefix = "sheet2_";
		if(sheetObj.RowCount <=0)
		{
			doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");  
			ComShowCodeMessage("MNR00005", "W/O No.");  
	
			ComSetFocus(formObj.mnr_ord_seq); 
			nowLoad = 0;
			return false;
	
		}

		formObj.combo_vndr_seq.UseCode = false;
		var agree_no = sheetObjects[1].CellValue(1, prefix+ "agmt_ofc_cty_cd")
		               + ComLpad(sheetObjects[1].CellValue(1, prefix+ "agmt_seq"),6,"0");
		formObj.combo_vndr_seq.Index = formObj.combo_vndr_seq.FindIndex(agree_no,2);
		formObj.combo_vndr_seq.UseCode = true;
				
		formObj.combo_spr_prt_spl_tp_cd.Code=sheetObjects[1].CellValue(1, prefix+ "spr_prt_spl_tp_cd");
	
		OrgVndrSeq = formObj.combo_vndr_seq.Code;
		formObj.pic_eng_nm.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 0 );
		formObj.combo_eq_knd_cd.Code2 = sheetObjects[1].CellValue(1, prefix+ "eq_knd_cd");
		formObj.curr_cd.value   = sheetObjects[1].CellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[1].CellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[1].CellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[1].CellValue(1, prefix+ "agmt_ver_no");
		formObj.showDate.value=sheetObjects[1].CellValue(1, prefix+ "cre_dt");
		formObj.ord_hdr_rmk.value=sheetObjects[1].CellValue(1, prefix+ "ord_hdr_rmk");
	
		formObj.vsl_cd.value=sheetObjects[1].CellValue(1, prefix+ "vsl_cd");
		formObj.vsl_cd2.value=sheetObjects[1].CellValue(1, prefix+ "vsl_cd");
		
		formObj.spr_prt_spl_yd_cd2.value=sheetObjects[1].CellValue(1, prefix+ "spr_prt_spl_yd_cd");
		
		formObj.spr_prt_spl_dt.value=sheetObjects[1].CellValue(1, prefix+ "spr_prt_spl_dt");
		formObj.spr_prt_spl_dt2.value=sheetObjects[1].CellValue(1, prefix+ "spr_prt_spl_dt");
		
		formObj.vsl_vvd.value=sheetObjects[1].CellValue(1, prefix+ "vsl_cd")
		                      +sheetObjects[1].CellValue(1, prefix+ "skd_voy_no")
		                      +sheetObjects[1].CellValue(1, prefix+ "skd_dir_cd")
		                      ;
	
		for ( var i = 0; i < arrDataSearchDbXml.length; i++)
		{
			if(i>0)break;
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}     		 

		formObj.pic_eng_nm2.value=formObj.pic_eng_nm.value;
		nowLoad=0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
			
	}	
		
	/**
	* IBTab Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	
	}
	
	/**
	* Tab 기본 설정
	* 탭의 항목을 설정한다.
	*/
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
	
	
			}
			break;
	
		}
	}
	
	/**
	* Tab 클릭시 이벤트 관련
	* 선택한 탭의 요소가 활성화 된다.
	*/
	function tab1_OnChange(tabObj , nItem)
	{
	
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		//------------------------------------------------------//
		beforetab= nItem;
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			//추가시
			if(sAction==IBINSERT)
			{
				if(formObj.combo_vndr_seq.Index == "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");    
					ComSetFocus(formObj.combo_vndr_seq);     
					return false;
				}
				if(formObj.combo_spr_prt_spl_tp_cd.Index == "-1"){
					ComShowCodeMessage("MNR00036","Supply To");    
					ComSetFocus(formObj.combo_spr_prt_spl_tp_cd);     
					return false;
				}
				var strVslVvd=formObj.vsl_vvd.value;  //vsl_vvd
				if(formObj.combo_spr_prt_spl_tp_cd.Code == "V" && (strVslVvd.length <9)){
	
					ComShowCodeMessage("MNR00172","VVD Code");   
					ComSetFocus(formObj.vsl_vvd);     

					return false;

										
				}

				var strSprPrtSplDt=formObj.spr_prt_spl_dt.value
				if(strSprPrtSplDt < 8 ){
					ComShowCodeMessage("MNR00036","Supply Date");    
					ComSetFocus(formObj.spr_prt_spl_dt);     
					return false;
				}
				
				else
				{
					if(sheetObj.CellValue(1, "Seq")=="0" )
					{
						sheetObj.RemoveAll();
					}else
					{

						if(sheetObj.LastRow==1) return true;
						
						//2. 해당 Unit Type 빈값일 경우
						var strCostDtlCD =ComTrimAll(sheetObj.CellValue(sheetObj.LastRow - 1, "sheet1_spr_prt_ut_tp_nm")," ");
					
						if(strCostDtlCD=="")
						{
							ComShowCodeMessage("MNR00036","Unit Type");
							sheetObj.SelectCell(sheetObj.LastRow - 1, "sheet1_spr_prt_ut_tp_nm",true);
							return false; 
						}

						//3. Part No를 Mandatory에 대한 체크를 수행 한다.
						var strUnitType = sheetObj.CellValue(sheetObj.LastRow - 1, "sheet1_spr_prt_ut_tp_nm")
						var strEqNo =ComTrimAll(sheetObj.CellValue(sheetObj.LastRow - 1, "sheet1_spr_prt_no")," ");
						if(strEqNo=="" && strUnitType!="HC")
						{
							ComShowCodeMessage("MNR00172","Part No");
							sheetObj.SelectCell(sheetObj.LastRow - 1, "sheet1_spr_prt_no",true);
							return false; 
						}		
					}
				}
			}
			//조회시
			else if(sAction==IBSEARCH)
			{
				var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
				if(sRow != "") // sheet 수정내용 있음
				{                               	
					if(!ComShowCodeConfirm("MNR00007"))
					{
						return false;
					}
				}
	
				if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
				{
					ComShowCodeMessage("MNR00172",'W/O No');   
					ComSetFocus(formObj.mnr_ord_seq);
	
					return false;
				}
	
	
	
				var strMnrOrdSeq=formObj.mnr_ord_seq.value;
				if(strMnrOrdSeq.length > 3)
				{
					strMnrOrdSeq=strMnrOrdSeq.substring(3);
					if(!ComIsNumber(strMnrOrdSeq))
					{
	
						ComShowCodeMessage("MNR00003");
						ComSetObjValue(formObj.mnr_ord_seq, "");  
						ComSetFocus(formObj.mnr_ord_seq);  
						return false;
					}
				}else{
	
					ComShowCodeMessage("MNR00003");
					ComSetObjValue(formObj.mnr_ord_seq, "");  
					ComSetFocus(formObj.mnr_ord_seq);  
					return false;
				}		
			}
			//저장(확정)시
			else if(sAction==IBSAVE) {
				if(formObj.combo_vndr_seq.Index == "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");    
					ComSetFocus(formObj.combo_vndr_seq);     
					return false;
				}
				if(formObj.combo_spr_prt_spl_tp_cd.Index == "-1"){
					ComShowCodeMessage("MNR00036","Supply To");    
					ComSetFocus(formObj.combo_spr_prt_spl_tp_cd);     
					return false;
				}
								
				var strSprPrtSplDt=formObj.spr_prt_spl_dt.value
				if(strSprPrtSplDt < 8 ){
					ComShowCodeMessage("MNR00036","Supply Date");    
					ComSetFocus(formObj.spr_prt_spl_dt);     
					return false;
				}
				//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
				var rCnt=sheetObj.RowCount;
				if(rCnt<=0)
				{
					//a[미선택][MNR00072] - Work Order를 생성할 Data를 선택하라는 메시지 표시
					ComShowCodeMessage("MNR00072");
	
					return false;             	   
	
				}
	
				var strVslVvd = formObj.vsl_vvd.value;  //vsl_vvd
				if(formObj.combo_spr_prt_spl_tp_cd.Code == "V" && (strVslVvd.length <9 )){
	
					ComShowCodeMessage("MNR00172","VVD Code");   
					ComSetFocus(formObj.vsl_vvd);     

					return false;

										
				}
				
				for(var i = sheetObj.HeaderRows ;i<=sheetObj.LastRow - 1;i++) 
				{
					//2. 해당 Unit Type 빈값일 경우
					var strCostDtlCD =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_prt_ut_tp_nm")," ");
				
					if(strCostDtlCD=="")
					{
						ComShowCodeMessage("MNR00036","Unit Type");
						sheetObj.SelectCell(i, "sheet1_spr_prt_ut_tp_nm",true);
						return false; 
					}

					//3. Part No를 Mandatory에 대한 체크를 수행 한다.
					var strUnitType = sheetObj.CellValue(i, "sheet1_spr_prt_ut_tp_nm")
					var strEqNo =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_prt_no")," ");
					if(strEqNo=="" && strUnitType!="HC")
					{
						ComShowCodeMessage("MNR00172","Part No");
						sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
						return false; 
					}		
					//4. 해당 Amount 빈값일 경우
					var strCostAmt =ComTrimAll(sheetObj.CellValue(i, "sheet1_cost_amt")," ");
					if(strCostAmt=="0")
					{
						ComShowCodeMessage("MNR00175","Amount");
						sheetObj.SelectCell(i, "sheet1_spr_prt_uc_amt",true);
						return false; 
					}  			
				}
	
				if(!sheet1_spr_prt_ut_tp_nm_AND_spr_prt_no_UniqueCheck())
				{
					return false; 
				}
			}
	
	
			//삭제시
			else if (sAction==IBSEARCHAPPEND) {
				//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
				var rCnt=sheetObjects[0].RowCount;
				if(rCnt<=0)
				{
					//a[미선택][MNR00072] - Work Order를 생성할 Data를 선택하라는 메시지 표시
					ComShowCodeMessage("MNR00081");
					return false;             	   
				}
	
				var strMnrOrdSeq=formObj.mnr_ord_seq.value;
				if(strMnrOrdSeq.length > 3)
				{
					strMnrOrdSeq=strMnrOrdSeq.substring(3);
	
					if(!ComIsNumber(strMnrOrdSeq))
					{
						ComShowCodeMessage("MNR00081");
	
						return false;
					}
				}else{
					ComShowCodeMessage("MNR00081");
					return false;
				}
	
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
				{
					var intPayInvSeq=sheetObj.CellValue(i,"sheet1_pay_inv_seq");
					if(intPayInvSeq =="") intPayInvSeq=0;
					if(parseInt(intPayInvSeq) > 0 )  
					{
						ComShowCodeMessage("MNR00229"); 
	
						return false;
					}
				}
			}		
			//복사시
			else if (sAction=="COPY") {
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
			}
			//행 삭제시
			else if (sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_chk") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
			}
			//행 복사시
			else if (sAction==IBCOPYROW) {
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//Tariff상태값 체크
				if(!checkTariffStatus()) {return false;}
			}
		}
		return true;
	}