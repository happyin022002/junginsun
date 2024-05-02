/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0045.js
*@FileTitle : Rail Transit Report
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-28 Seong-mun Kang
* 1.0 최초생성
* 2011.07.25 손은주 [CHM-201112118-01]	Rail Transit Report의 Remark Column 이원화 및 활성화 요청.
* 2011.08.25 김영철 [CHM-201112973-01]	 RTR Column내, Origin & Interchange DT의 CLM 수신 로직 변경 요청
* 2011.09.29 김영철 [CHM-201113507-01]	 특정 Column 위치조정 기능 추가
* 2011.10.26 김영철 []	 Origin In-Gate 값 변경이 없는 경우에는 Validation 을 하지 않도록 함.
* 2012.03.12 채창호 [CHM-201216647-01] Rail Transit Report 상에, Empty Cargo 조회 보완요청
* 2012.03.29 박찬민 [CHM-201216948] 개발-Rail Transit Report상의 일부항목 변경 및 보완
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var focusField = "" ;

// 공통전역변수 
var PageNo =1 ;
var PageNo2 =1 ;
var comboObjects = new Array();
var comboCnt = 0 ;

var excelLoader = "I" ; // 조회 시: inactive, 엑셀 업로드 시: active
  
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObj = sheetObjects[0];
	 var sheetObj2 = sheetObjects[1];
	 /*******************************************************/
	 var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
				
			case "btn_save" :
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
				
			case "btn_new":
				sheetObj.RemoveAll();
				sheetObj2.RemoveAll();
				formObj.reset();
				excelLoader = "I" ; // inactive
				break;

	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
				
	  		case "btn_uploadexcel":
	  			sheetObj.RemoveAll();
	  			
    	    	doActionIBSheet(sheetObj, formObj, IBLOADEXCEL);
    	        break;
				
			case "btn_downcsv":
			    doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01); 
			    break;	
				
	  		case "btn_bkginfo":
	  			openESD_SCE_0915(sheetObj) ;
				break;

	  		case "btn_clm":
		  		goESD_SCE_0044(sheetObj) ;
				break;
				
			case "btn_calendar":
				//if(!isEmpty(formObj.date_kind)){
				if(formObj.date_kind.value != null && formObj.date_kind.value != ''){
					var cal = new ComCalendarFromTo();
	  			cal.displayType = "date";
					cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
				}
				else{
					ComShowCodeMessage("COM12113", "date") ;
					formObj.date_kind.focus() ;
				}
				break ;
			case "btns_multiinput" :
				    openESD_SCE_0048();
				break ;

			case "btn_bkg_ofc" :

				var selofc_cd = formObj.bkg_ofc_cd.value;
				var newWin = window.showModalDialog("ESD_SCE_0910.do?sel_ofc_cd="+selofc_cd, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:410px;dialogHeight:400px");
				break;
			default:
			break;	


		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(E);
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
 * IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//html컨트롤 이벤트초기화
	initControl();
	
	if(document.form.openMode.value == 'smmy'){
		searchSummaryList();
	}
 	//IBMultiCombo초기화
    for(var c=0; c<comboObjects.length; c++){
        initCombo(comboObjects[c], c+1);
    }
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
		case "cntr_tpsz":
			with(comboObj) {
			comboObj.DropHeight=400;
			comboObj.MultiSelect = true;
			comboObj.MultiSeparator=",";
			comboObj.UseEdit = false;
			InsertItem(0,  "ALL",  "");

			var arrText = s_cntr_tp_szCode.split("|");
			for (var j = 0; j < arrText.length; j++) {
				InsertItem(j+1, arrText[j], arrText[j]);
			}
			comboObj.index = 0;
        	}
			break;  
	}
}
 
function initControl() {
	axon_event.addListener('blur',		'obj_blur',		'fm_dt', 'to_dt'); //- 포커스 나갈때
	axon_event.addListener('focus',		'obj_focus',	'fm_dt', 'to_dt'); //- 포커스 들어갈때
	axon_event.addListener('keypress',	'obj_keypress',	'fm_dt', 'to_dt'); //- 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * HTML Control Foucs in
 */
function obj_focus(){
	var obj = event.srcElement;
	ComClearSeparator(obj);
    
	//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
	//if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
}
 
//포커스가 나갈 때
function obj_blur(){
	//입력Validation 확인하기 + 마스크구분자 넣기
	var obj = event.srcElement;
	ComChkObjValid(obj);
}

//업무 자바스크립트 OnKeyPress 이벤트 처리
function obj_keypress() {
 	 switch(event.srcElement.dataformat){
      	/*
      	case "engup":
		    	// 영문대+숫자 
      		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
      	case "engup2":
		    	// 영문대+숫자+예외문자
      		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
      	case "int":
 	        //숫자 만입력하기
 	        ComKeyOnlyNumber(event.srcElement);
 	        break;*/
      	default:
         	// 숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
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
		case 1:	  //IBSheet1 init
			with (sheetObj) {
			
				SheetWidth = mainTable.clientWidth;

				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly;

				Editable = true;

				InitRowInfo( 1, 1, 9, document.form.row_size.value);


				InitColumnInfo(93, 3, 0, true);

				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " |ibflag|SEQ|Container|T/S|F/M|Bound|VVD|BKG|B/L|S/C|S/O Creation Date|W/O Issue Date|Rail Road|Trucker|Origin|DEST|HOT|F|O|Customs Clearance|C Date|Customer Location|Customs Clearance Location|POL/POD|POR/DEL|Vessel Discharge|Hold|Hold Release Date|Terminal Dwell|Departure|Origin Description|Origin In-Gate|Origin Dwell|Departure|Origin Departure|Interchange Arrival Description|Interchange Arrival|Interchange Dwell I|Departure|Changed Description|Interchanged|Interchange Dwell II|Departure|Interchange Departure|DEST Description|DEST Arrival|DEST Dwell I|Departure|DEST Available|DEST Dwell II|Departure|DEST Out-Gate|Run Time|Transit Time|Current Location|State|Event Date|Current Dwell|Train No|Flat Car No|Seal No|Average Interchange Point|RR ETA at Interchange Point|1st ETA at Interchange Point|2nd ETA at  Interchange Point|Average Interchange Dwell|1st ETD at  Interchange Point|2nd ETD at  Interchange Point|Average Run Time|RR ETA at Dest|1st ETA at DEST|2nd ETA at DEST|Diff|Shipper|Consignee|Notify|Last Remark|Current Remark|S/O No.|r_temp|r_bkg_no|r_bkg_no_split|r_cntr_no|S/O No.|S/O No.|org_gate_in_upd_flg|cop_no|CLM Status|CLM Location|CLM ST|CLM Date" ;
				
				InitHeadRow(0, HeadTitle, true);

				InitDataProperty(0, cnt++ , dtCheckBox,  20,	daCenter,  true,		"chk",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtStatus,     30,	daCenter,  true,		"ibflag",			    false,		  "",	   dfNone,   	0,			true,	   true);
				InitDataProperty(0, cnt++ , dtSeq,		 30,	daLeft,  	 true,	"",	 false,		  "",	   dfNone,   	0,	 true,	   true);                    //SEQ
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"eq_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Container               
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"eq_tpsz_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //T/S                  
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"cgo_tp_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //F/M  
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"trsp_bnd_cd",		false,		  "",	   dfNone,	 	0,	 false,	   false);                //Bound
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"vvd_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //VVD        
				InitDataProperty(0, cnt++ , dtData,	  130,	daCenter,  true,	"bkg_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //BKG
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"mst_bl_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //B/L
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"sc_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //S/C
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"cre_date",	 false,		  "",	   dfNone,  	0,	 false,	   false);                //S/O Creation Date
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"swo_iss_date",	 false,		  "",	   dfNone,  	0,	 false,	   false);                //W/O Issue Date
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	"usa_edi_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Rail Road
				//Trucker
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"wo_vndr_seq",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Trucker
				
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"fm_nod_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Origin
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"to_nod_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //DEST

				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"bkg_hot_de_flg",	false,		  "",	   dfNone,	 	0,	 false,	   false);                //HOT
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"frt_clt_flg",	 	false,		  "",	   dfNone,	 	0,	 false,	   false);            //CARGO RELEASE FREIGHT PAYMENT INDICATOR FLAG				
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"obl_rdem_flg",	 	false,		  "",	   dfNone,	 	0,	 false,	   false);            //CARGO RELEASE ORIGINAL B/L RECOVERY INDICATOR FLAG
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"cstms_clr_cd",	 	false,		  "",	   dfNone,	 	0,	 false,	   false);            //Customs Clearance
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"c_date",	 		false,		  "",	   dfNone,	 	0,	 false,	   false);                //C Date
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"ib_ipi_locl_ind_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Customer Location
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  true,	"ibd_cstms_clr_loc_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);             //Customs Clearance Location 
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"nod_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //POR/DEL
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"nod_cd1",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //POL/POD 
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"vd_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Vessel Discharge    
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  true,	"hld_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Hold
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"hld_rmk",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Hold Release Date 
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"tml_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //Terminal Dwell
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"tml_dep_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Departure

				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"org_splc_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Origin Description
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"org_gate_in_date",	 false,		  "",	   dfUserFormat2,	 	0,	 true,	   true);                //Origin In-Gate
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"org_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //Origin Dwell 
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	"org_dep_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Departure  
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"org_gate_out_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Origin Departure  
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  true,	"itchg_arr_splc_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Interchange Arrival Description
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"chg_arr_in_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Interchange Arrival
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"itchg_n1st_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //Interchange Dwell I
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"itchg_n1st_dep_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Departure
				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"itchg_splc_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Changed Description
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"chg_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Interchanged

				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"itchg_n2nd_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //Interchange Dwell II
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"itchg_n2nd_dep_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Departure
				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"chg_out_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Interchange Departure
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"dest_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //DEST Description 
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"dest_in_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //DEST Arrival
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"dest_n1st_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //DEST Dwell I
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"dest_n1st_dep_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Departure 
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"dest_avail_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //DEST Available
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"dest_n2nd_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //DEST Dwell II
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"dest_n2nd_dep_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Departure
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"dest_out_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //DEST Out-Gate 

				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  false,	"rail_run_tm_hrs",	 false,		  "",	   dfNumber,	 	0,	 false,	   false);                //Run Time
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  false,	"rail_tztm_hrs",	 false,		  "",	   dfNumber,	 	0,	 false,	   false);                //Transit Time
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  false,	"arr_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Current Location 
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  false,	"arr_ste_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //State
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  false,	"evnt_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Event Date
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  false,	"crnt_dwll_tm_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //Current Dwell
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  false,	"trn_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Train No
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  false,	"fcar_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Flat Car No    
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  false,	"cntr_seal_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Seal No  
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"itchg_hrs",	 false,		  "",	   dfNumber,	 	0,	 false,	   false);                //Average Interchange Point
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"rail_co_itchg_pnt_eta_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //RR ETA at Interchange Point
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"rail_itchg_n1st_eta_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //1st ETA at Interchange Point
 
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"rail_itchg_n2nd_eta_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //2nd ETA at Interchange Point  
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"dwll_hrs",	 false,		  "",	   dfFloat,	 	0,	 false,	   false);                //Average Interchange Dwell 
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"rail_itchg_n1st_etd_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //1st ETD at Interchange Point
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  false,	"rail_itchg_n2nd_etd_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //2nd ETD at Interchange Point
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  false,	"avg_tz_hrs",	 false,		  "",	   dfNumber,	 	0,	 false,	   false);                //Average Run Time
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  false,	"r_rail_co_dest_pnt_eta_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //RR ETA at Dest
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  false,	"rail_dest_n1st_eta_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //1st ETA at DEST
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  false,	"rail_dest_n2nd_eta_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //2nd ETA at DEST
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  false,	"tztm_diff_hrs",	 false,		  "",	   dfNumber,	 	0,	 false,	   false);                //Diff  

				InitDataProperty(0, cnt++ , dtData,	  150,	daCenter,  false,	"shpr_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Shipper  
				InitDataProperty(0, cnt++ , dtData,	  200,	daCenter,  false,	"cnee_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Consignee
				InitDataProperty(0, cnt++ , dtData,	  150,	daCenter,  false,	"ntfy_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Notify
				InitDataProperty(0, cnt++ , dtData,	  300,	daCenter,  false,	"pre_dwll_rmk",	 false,		  "",	   dfNone,	 	0,	 false,	   false);                //Last Remark
				InitDataProperty(0, cnt++ , dtData,	  300,	daCenter,  false,	"crnt_dwll_rmk",	 false,		  "",	   dfNone,	 	0,	 true,	   true, 2000, false);                //Current Remark
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"so_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);  			  //S/O No.
    
				InitDataProperty(0, cnt++ , dtHidden,			150,    daCenter,  true,	"r_temp",	        false,			"",		dfNone,		0,			false,		false,		11);
				InitDataProperty(0, cnt++ , dtHidden,			120,    daCenter,  true,	"r_bkg_no",			false,			"",		dfNone,		0,			false,		false,		11);
				InitDataProperty(0, cnt++ , dtHidden,			 30,    daCenter,  true,	"r_bkg_no_split",	false,			"",		dfNone,		0, 			false,		false,		 2);
				InitDataProperty(0, cnt++ , dtHidden,			150,    daCenter,  true,	"r_cntr_no",	    false,			"",		dfNone,		0,			false,		false,		11);
				InitDataProperty(0, cnt++ , dtHidden,			80,    daCenter,  true,	"trsp_so_ofc_cty_cd",	        false,			"",		dfNone,		0,			false,		false,		11);
				InitDataProperty(0, cnt++ , dtHidden,			100,    daCenter,  true,	"trsp_so_seq",	        false,			"",		dfNone,		0,			false,		false,		11);
				InitDataProperty(0, cnt++ , dtHidden,			50,     daCenter,  true,	"org_gate_in_upd_flg",	    false,			"",		dfNone,		0,			false,		false,		11);
				InitDataProperty(0, cnt++ , dtHidden,			50,     daCenter,  true,	"cop_no",	    false,			"",		dfNone,		0,			false,		false,		11);
				
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"clm_crnt_sts",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail CLM State
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"clm_loc",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail CLM Location
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"clm_state",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail State
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"clm_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail CLM Date
				
				
				InitDataProperty(0, cnt++ , dtHidden,	   120,	daCenter,  true,	"org_gate_in_date_old",	 false,		  "",	   dfUserFormat2,	 	0,	 true,	   true);                //Origin In-Gate
				
				InitUserFormat2(0, "org_gate_in_date" , "####-##-## ##:##", "-|:" );
				InitUserFormat2(0, "org_gate_in_date_old" , "####-##-## ##:##", "-|:" );

				ColHidden(1)=true; // ibflag hidden
				style.height = GetSheetHeight(12) ;
				ToolTipText(0,'rail_tztm_hrs') = "I/B : Vessel Discharge ~ DEST Available\nO/B: Origin In-Gate ~ DEST Out-Gate";


			   }
				break;
		case 2:      //sheet2 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "STS|CNTR NO|BKG No|BKG NO SPLIT|BL|VVD|POL POD|ORIGIN|DEST|SC NO|CUST CNT CD|CUST SEQ" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성   [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  		  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",			false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daCenter,  true,	"r_cntr_no",	    false,			"",		dfNone,		0,			true,		true,		11);
				InitDataProperty(0, cnt++ , dtData,			120,    daLeft,    true,	"r_bkg_no",			false,			"",		dfNone,		0,			true,		true,		11);
				InitDataProperty(0, cnt++ , dtData,			 30,    daLeft,    true,	"r_bkg_no_split",	false,			"",		dfNone,		0, 			true,		true,		 2);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_bl_no",		false,			"",		dfNone,		0,			true,		true,		12);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_vvd",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_polpod",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_origin",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_dest",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_scno",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_cust_cnt_cd",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			100,    daLeft,    true,	"r_cust_seq",		false,			"",		dfNone,		0,			true,		true,		9);				
																												
								
				InitDataValid(0, 1, vtEngOther, "1234567890") ;
				InitDataValid(0, 2, vtEngOther, "1234567890") ;
				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				InitDataValid(0, 4, vtEngOther, "1234567890") ;
				InitDataValid(0, 5, vtEngOther, "1234567890") ;								
				InitDataValid(0, 6, vtEngOther, "1234567890") ;
				InitDataValid(0, 7, vtEngOther, "1234567890") ;
				InitDataValid(0, 8, vtEngOther, "1234567890") ;
				InitDataValid(0, 9, vtEngOther, "1234567890") ;								
				InitDataValid(0, 10, vtEngOther, "1234567890") ;												
				InitDataValid(0, 11, vtEngOther, "1234567890") ;				

				style.height = GetSheetHeight(12) ;
			}
			break;
		}
	}

function inputDataToForm() {
	form.fmNodCd.value = document.all.fm_nod_cd.value;
	form.toNodCd.value = document.all.to_nod_cd.value;
	form.bkgNo.value = document.all.bkg_no.value;
	form.blNo.value = document.all.bl_no.value;
	form.eqNo.value = document.all.eq_no.value;
	form.vvdCd.value = document.all.vvd.value;
	form.dwellKind.value = document.all.dwell_kind.value;
	form.dwellTime.value = document.all.dwell_time.value;
	form.tDep.value = document.all.t_dep.value;
	form.oDep.value = document.all.o_dep.value;
	form.railcompVal.value = document.all.railcomp.value;
	form.bkgOfcCd.value = document.all.bkg_ofc_cd.value;
	form.custCntSeq.value = document.all.cust_cnt_seq.value;
	form.podPol.value = document.all.pod_pol.value;
	form.scNo.value = document.all.sc_no.value;
	form.cstmsAcptFlg.value = document.all.cstms_acpt_flg.value;
	form.customerLoc.value = document.all.customer_loc.value;
}	

function doActionIBSheet(sheetObj,formObj,sAction, loc) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:
			excelLoader = "I" ; // inactive
			inputDataToForm();	  
				if(loc=="multi_input"){
					var formObj = document.form;
					formObj.f_cmd.value = MULTI ;
					formObj.loc.value = "multi_input" ;
					var sXml = sheetObj.GetSearchXml("ESD_SCE_0045GS.do", SceFrmQryString(formObj) + "&" + sheetObjects[1].GetSaveString() + "&" + "cur_page=" + PageNo2, true);
					sheetObj.LoadSearchXml(sXml);
				  	formObj.totcnt.value = ComGetEtcData(sXml, "totcnt");
				  	sheetObj.TotalRows = formObj.totcnt.value;
				}	        
				else if(loc!="multi_input" && validateForm(sheetObj,formObj,sAction)){//처음 조회 버튼 클릭시
	         		formObj.f_cmd.value = SEARCH02 ;
	         		formObj.loc.value = "single_input" ;
			  		var sXml = sheetObj.GetSearchXml("ESD_SCE_0045GS.do", SceFrmQryString(formObj) + "&" + "cur_page=" + PageNo, true);
			  		sheetObj.LoadSearchXml(sXml);
				  	formObj.totcnt.value = ComGetEtcData(sXml, "totcnt");
				  	sheetObj.TotalRows = formObj.totcnt.value;
				}
				
				break;

		case IBSAVE:
			
			var empty_count = 0;
			for(var i = 1 ; i <= sheetObj.RowCount ; i++){
				var txt_so_no = sheetObj.CellValue(i, "so_no");
				if(ComIsEmpty(txt_so_no)){
					ComShowMessage("S/O No. is mandatory column/value for uploading excel.");
					sheetObj.SelectCell(1, "so_no", false);
					empty_count += 1;
				    break;
				}
		    }
			
			if(empty_count > 0) break;
			
			if(excelLoader == "I"){
			    formObj.f_cmd.value = MODIFY;
                if(validateForm(sheetObj,formObj,sAction))
                {
                	sheetObj.DoSave("ESD_SCE_0045GS.do", SceFrmQryString(formObj), "chk");
                }
			}else if(excelLoader == "A"){
				
				formObj.f_cmd.value = MODIFY02;
				sheetObj.DoSave("ESD_SCE_0045GS.do", SceFrmQryString(formObj), "chk");
				for(var i = 1 ; i <= sheetObj.RowCount ; i++){
						sheetObj.CellValue(i,"chk") = "N";
						sheetObj.RowStatus(i) = "R";
						sheetObj.CellBackColor(i,"crnt_dwll_rmk") = sheetObj.RgbColor(255, 255, 255);
					
				}
			}
                
	         break;
	          
		case IBDOWNEXCEL:		// excel down
			sheetObj.SpeedDown2Excel(-1); //, false, false, '', '', false, false, '', false, "chk"
			
			break;
			
		case IBLOADEXCEL:
			sheetObj.LoadExcel();
			ComOpenWait(true);
			
			var empty_count = 0;
			for(var i = 1 ; i <= sheetObj.RowCount ; i++){
				var txt_so_no = sheetObj.CellValue(i, "so_no");
				if(ComIsEmpty(txt_so_no)){
					sheetObj.CellBackColor(i,"so_no") = sheetObj.RgbColor(255, 229, 204);
					sheetObj.ToolTipText(i,"so_no") = "S/O No. is mandatory column/value for uploading excel.";
					empty_count += 1;
				}
		    }
			
			if(empty_count > 0){
				ComShowMessage("S/O No. is mandatory column/value for uploading excel.");
				sheetObj.SelectCell(1, "so_no", false);
			}
			
			excelLoader = "A"; // active
			
			for(var i = 1 ; i <= sheetObj.RowCount ; i++){
				var txt_dwll_rmk = sheetObj.CellValue(i, "crnt_dwll_rmk");
				if(!ComIsEmpty(txt_dwll_rmk)){
					sheetObj.CellValue(i,"chk") = "Y";
					sheetObj.RowStatus(i) = "U";
					sheetObj.CellBackColor(i,"crnt_dwll_rmk") = sheetObj.RgbColor(255, 255, 0);
				}
			}
			
			ComOpenWait(false);
			break;	
			
		case IBSEARCH_ASYNC01:      // csv down

            sheetObj.Down2Text("", ",", "0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70", "", "","",true,true,true);      
            
		    break;
		}
	}



function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	
	if(ErrMsg == ''){
		ComShowCodeMessage("COM130102", "Data");
		
		if(excelLoader == "I"){
			formObj.f_cmd.value = SEARCH02 ;
	 		var sXml = sheetObj.GetSearchXml("ESD_SCE_0045GS.do", SceFrmQryString(formObj) + "&" + "cur_page=" + PageNo, true);
			sheetObj.LoadSearchXml(sXml);
			formObj.totcnt.value = ComGetEtcData(sXml, "totcnt");
			sheetObj.TotalRows = formObj.totcnt.value;
		}
	}
}

  

/** 
   * Origin in-gate가 'EN" Movement 일 경우 Origin in-gate_dt를 빨간색으로 조회
  */
  function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        var rowCount  = sheetObj.RowCount;
		var routFlag = '';

		for(i=0+parseInt(sheetObj.HeaderRows);i<rowCount+parseInt(sheetObj.HeaderRows);i++){
			routFlag = sheetObj.CellValue(i, "org_gate_in_upd_flg");
		
			if(routFlag=='Y' ){
				sheetObj.CellFontColor(i, "org_gate_in_date")  = sheetObj.RgbColor(255,0, 0);
			} 
		}		
    }
        
   /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
function validateForm(sheetObj,formObj,sAction){
	var result = true ;
	
	switch (sAction) {
		case IBSEARCH:
			// ?? ?? ??
			if(!chkEssItems(formObj)){
				result = false ;
			}
			// ????
			break;

        case IBSAVE:
        	
        	if(!chkEssItems(formObj)){
				result = false ;
			}
        	
	    	for(var i = 0 ; i < sheetObj.CheckedRows(0) ; i++){
	    		chkrow = sheetObj.FindCheckedRow(0).split('|')[i];
	    		var txt = sheetObj.CellValue(chkrow, "org_gate_in_date");
	    		var org_gate_in_date_old = sheetObj.CellValue(chkrow, "org_gate_in_date_old");
	    		var vd_date = sheetObj.CellValue(chkrow, "vd_date");
	    		var org_gate_out_date = sheetObj.CellValue(chkrow, "org_gate_out_date");

	    		if(!ComIsEmpty(txt) && txt != org_gate_in_date_old && excelLoader == "I"){
		    		if(!ComIsEmpty(vd_date)){
		    			if(!ComIsEmpty(org_gate_out_date)){
				    		if(parseInt(ComTrimAll(txt, " ", "-", ":")) < parseInt(ComTrimAll(vd_date, " ", "-", ":")) || parseInt(ComTrimAll(org_gate_out_date, " ", "-", ":")) < parseInt(ComTrimAll(txt, " ", "-", ":"))){
						        ComShowMessage("'Origin In-Gate' Date should be later than 'Vessel Discharge' Date \n but earlier than 'Origin Departure' Date at the same time") ;
						        result = false ;
				    		}
		    			}else{
		    				if(parseInt(ComTrimAll(vd_date, " ", "-", ":")) > parseInt(ComTrimAll(txt, " ", "-", ":"))){
						        ComShowMessage("'Origin In-Gate' Date should be later than 'Vessel Discharge' Date \n but earlier than 'Origin Departure' Date at the same time") ;
						        result = false ;	    					
		    				}
		    			}
		    		}else{
		    			result = false ;
		    		}
		    		if(!ComIsDateTime(txt, "ymd", "hm")){
				        ComShowMessage("Please enter correct date.\n\n Format : YYYY-MM-DD HH24:MI") ;
				        result = false ;
				    }
	    		}
	   		}
			break;
	
		default:
		
			break;
	}

	return result ;
}

function chkEssItems(formObj){
	var result = true ;
	
	if((formObj.date_kind.value == ""||formObj.fm_dt.value == ""||formObj.to_dt.value == "") && (formObj.bkg_no.value == "") && (formObj.bl_no.value == "") && (formObj.eq_no.value == "") && (formObj.vvd.value == "")) {
	  ComShowCodeMessage("SCE90030") ;
		formObj.date_kind.focus() ;
		result = false ;
	}

	
	return result  ;
}

function chkDateKind(formObj){
	var result = true ;
	if(!isEmpty(formObj.date_kind)){
		if(!isDate(formObj.fm_dt)){
			ComShowCodeMessage("SCE90003","Date");
			formObj.fm_dt.focus() ;
			result = false ;
		}
		else if(!isDate(formObj.to_dt)){
			ComShowCodeMessage("SCE90003","Date");
			formObj.to_dt.focus() ;
			result = false ;
		}
	}
	
	return result ;
}

function chgDateKind(val){
	var formObj = document.form ;
	if(val==""){
		formObj.fm_dt.value    = "" ;
		formObj.to_dt.value    = "" ;
		formObj.fm_dt.readOnly = true ;	
		formObj.to_dt.readOnly = true ;	
	}
	else{
		formObj.fm_dt.readOnly = false ;	
		formObj.to_dt.readOnly = false ;	
	}
}
 
function chgDwell(val){
	var formObj = document.form ;
	if(val==""){
		formObj.dwell_time.value    = "" ;
		formObj.dwell_time.disabled = true ;
	}
	else{
		formObj.dwell_time.disabled = false ;
	}
}

function openESD_SCE_0048(){
	ComOpenPopup('ESD_SCE_0048.do', 710, 450, '', getCommPopDisplay('false')) ;
}

function getESD_SCE_0048(docObj0, docObj1, docObj2, docObj3){
    var sheetObj = sheetObjects[4];
    sheetObjects[0] = docObj0;
    sheetObjects[1] = docObj1;
    sheetObjects[2] = docObj2;
    sheetObjects[3] = docObj3;
    var sheetObj91 = sheetObjects[0];
    var sheetObj92 = sheetObjects[1];
    var sheetObj93 = sheetObjects[2];
    var sheetObj94 = sheetObjects[3];
    
    var sheetObj95 = sheetObjects[4];
    var sheetObj96 = sheetObjects[5];
    var sheetObj97 = sheetObjects[6];
    var sheetObj98 = sheetObjects[7];
    var sheetObj99 = sheetObjects[8];        
    
    for(var i=0; i<sheetObj91.RowCount; i++){
        if(sheetObj91.CellValue(i, "r_remark")=="Clear") sheetObj.CellValue2(i, "r_cntr_no") = sheetObj91.CellValue(i, "r_cntr_no") ;
    }         
    for(var j=0; j<sheetObj92.RowCount; j++){ 
        if(sheetObj92.CellValue(j, "r_remark")=="Clear"){ 
            sheetObj.CellValue2(j, "r_bkg_no") = sheetObj92.CellValue(j, "r_bkg_no") ;
        }
    }         
    for(var k=0; k<sheetObj93.RowCount; k++){ 
        if(sheetObj93.CellValue(k, "r_remark")=="Clear") sheetObj.CellValue2(k, "r_bl_no") = sheetObj93.CellValue(k, "r_bl_no") ;
    }         
    for(var l=1; l<sheetObj94.RowCount; l++){ 
        if(sheetObj94.CellValue(l, "r_remark")=="Clear") sheetObj.CellValue2(l, "r_vvd") = sheetObj94.CellValue(l, "r_vvd") ;
    }   
    
    for(var m=1; m<sheetObj95.RowCount; m++){ 
        if(sheetObj95.CellValue(m, "r_remark")=="Clear") sheetObj.CellValue2(m, "r_polpod") = sheetObj95.CellValue(m, "r_polpod") ;
    }   
    for(var n=1; n<sheetObj96.RowCount; n++){ 
        if(sheetObj96.CellValue(n, "r_remark")=="Clear") sheetObj.CellValue2(n, "r_origin") = sheetObj96.CellValue(n, "r_origin") ;
    }   
    for(var o=1; o<sheetObj97.RowCount; o++){ 
        if(sheetObj97.CellValue(o, "r_remark")=="Clear") sheetObj.CellValue2(o, "r_dest") = sheetObj97.CellValue(o, "r_dest") ;
    }         
    for(var p=1; p<sheetObj98.RowCount; p++){ 
        if(sheetObj98.CellValue(p, "r_remark")=="Clear") sheetObj.CellValue2(p, "r_scno") = sheetObj98.CellValue(p, "r_scno") ;
    }         
    for(var q=1; q<sheetObj99.RowCount; q++){ 
		if(sheetObj99.CellValue(q, "r_remark")=="Clear") 
            sheetObj.CellValue2(q, "r_cust_cnt_cd") = sheetObj99.CellValue(q, "r_custcd");
            sheetObj.CellValue2(q, "r_cust_seq") = sheetObj99.CellValue(q, "r_custcd").substring(2);
        
    }                 

    if(sheetObj91.RowCount>0||sheetObj92.RowCount>0||sheetObj93.RowCount>0||sheetObj94.RowCount>0
    		||sheetObj95.RowCount>0||sheetObj96.RowCount>0||sheetObj97.RowCount>0||sheetObj98.RowCount>0||sheetObj99.RowCount>0){
    	doActionIBSheet(sheetObj,document.form,IBSEARCH,"multi_input");
    }
}

function getCenterXY(w, h){
    	
	var height = screen.availHeight ; 
	var width = screen.availWidth ; 
	
	var leftpos = width/2 - w/2; 
	var toppos = height/2 - h/2; 
	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;
	
	return "left=" + leftpos + ", top=" + toppos ;
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
    if (sheetObj.RowCount >= OnePageRow && eval(formObj.totcnt.value) > sheetObj.RowCount){    
    	
    	if(formObj.openMode.value=='smmy'){
    		var opener_obj = window.opener;
    		var opener_form = opener_obj.document.form;
    		var opener_sheetObj = opener_obj.sheetObjects[0];
    		var opnener_xml = opener_sheetObj.GetSaveString(false, false, 'chk');

    		opener_form.f_cmd.value = SEARCH11;
    		sheetObj.DoSearch("ESD_SCE_0045GS.do", opnener_xml + '&'+ SceFrmQryString(opener_form)+"&cur_page="+PageNo );
    	}else{
	    	selectVal = SceFrmQryString(formObj);
	    	sheetObj.DoSearch4Post("ESD_SCE_0045GS.do", selectVal, "cur_page=" + PageNo, true);
    	}
    	sheetObj.TotalRows = formObj.totcnt.value;
    }	
}

function sheet2_OnScrollNext(sheetObj,CondParam, PageNo2, OnePageRow){
	var formObj = document.form ;
    if (sheetObj.RowCount >= OnePageRow && eval(formObj.totcnt.value) > sheetObj.RowCount){    
    	selectVal = SceFrmQryString(formObj);
    	sheetObj.DoSearch4Post("ESD_SCE_0045GS.do", selectVal, "cur_page=" + PageNo2, true);
    }	
}

function openESD_SCE_0915(sheetObj){
		var row = sheetObj.SelectRow;
		
  	if(row < 0){
  		ComShowCodeMessage("SCE90018");
  		return ;
  	}
  	
    var bkgNo      = sheetObj.CellValue(row, "bkg_no") ;
    var copNo      = sheetObj.CellValue(row, "cop_no") ;
    
    newForm  = "<form name='form1' method='post'>" ;
    newForm += "  <input type='hidden' name='bkg_no'       value='" + bkgNo + "'>" ;
    newForm += "  <input type='hidden' name='cop_no'       value='" + copNo + "'>" ;
    newForm += "</form>"
    document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
    var paramUrl = "bkg_no="+bkgNo+"&cop_no="+copNo;
    var newWin = window.showModalDialog("ESD_SCE_0915.do?"+paramUrl, "bkg_info_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:380px");
    
}

function goESD_SCE_0044(sheetObj){
	var row = sheetObj.SelectRow  ;
	
	if(row < 0){
			ComShowCodeMessage("SCE90018");
  		return ;
  	}
	
		//var cntrNO      = sheetObj.CellValue(row, "r_cntr_no") ;
    var cntrNO      = sheetObj.CellValue(row, "eq_no") ;
    var tpszCd      = sheetObj.CellValue(row, "eq_tpsz_cd") ;
	
  	newForm  = "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='cntr_no' value='" + cntrNO + "'>" ;
		newForm += "  <input type='hidden' name='tpsz_cd' value='" + tpszCd + "'>" ;
    newForm += "</form>"
		
		document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
    var paramUrl = "cntr_no="+cntrNO+"&tpsz_cd="+tpszCd;
    var newWin = window.showModalDialog("ESD_SCE_0044.do?"+paramUrl, "clm_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px");
}

function rtn_office_code(obj) {
	document.form.bkg_ofc_cd.value = obj;
}

function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.bkg_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.bkg_ofc_cd.value = "";
		ComShowMessage("Please input the 'Occurred Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH11+"&sel_ofc_cd="+prm_office;

		createHttpRequest();

		request.open("GET", url, false);

		request.onreadystatechange = subCntorlOffice;

		request.send(null);
	} else {
		document.form.bkg_ofc_cd.value = prm_office;
	}
	
}

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

function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var subXml = null;
			var text_ofc = "";
			
			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");
				text_ofc = text_ofc+val+",";
			}
			
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}else{
				document.form.bkg_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
			}
		}

	}

}

function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}

function sheet1_OnDblClick(sheetObj, row, col, value) {
	var newForm = "" ;
	
	if( sheetObj.ColSaveName(col) == "rail_co_itchg_pnt_eta_dt" || sheetObj.ColSaveName(col) == "r_rail_co_dest_pnt_eta_dt") {
		newForm += "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='eta_tp' value='" + (sheetObj.ColSaveName(col) == "rail_co_itchg_pnt_eta_dt"? "RR ETA at Interchange":"RR ETA at DEST") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no' value='" + sheetObj.CellValue(row, "eq_no") + "'>" ;
		if (sheetObj.ColSaveName(col) == "rail_co_itchg_pnt_eta_dt") {
			var eta_dt = sheetObj.CellValue(row, "rail_co_itchg_pnt_eta_dt");
			newForm += "  <input type='hidden' name='eta_yr' value='" + eta_dt.substring(0,4) + "'>" ;
		} else if (sheetObj.ColSaveName(col) == "r_rail_co_dest_pnt_eta_dt") {
			var r_eta_dt = sheetObj.CellValue(row, "r_rail_co_dest_pnt_eta_dt");
			newForm += "  <input type='hidden' name='eta_yr' value='" + r_eta_dt.substring(0,4) + "'>" ;
		}
		newForm += "</form>" ;

		document.all.new_form.innerHTML = newForm ;
    var formObj = document.form1 ;
    var paramUrl = "cntr_no="+formObj.cntr_no.value+"&eta_yr="+formObj.eta_yr.value+"&eta_tp="+formObj.eta_tp.value;
    var newWin = window.showModalDialog("ESD_SCE_0107.do?"+paramUrl, "Rail_ETA", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:495px;dialogHeight:390px");
	}
	
}	

/**
* sheet cell value 변경시 발생하는 이벤트
**/
function sheet1_OnChange(sheetObj, row, col, value){

	var colName = sheetObj.ColSaveName(col);
	if (colName == "org_gate_in_date") {
		sheetObj.CellValue(row,"chk") = 1; // 값이 변경된 Row Checked..
	}else if( colName == "crnt_dwll_rmk"){
		sheetObj.cellValue(row, "chk") = 1;
	}

}

//BKG_NO, BL_NO, CNTR_NO 입력 받는 메소드(POP UP 에서 호출한다.) 2012.03.29 박찬민 [CHM-201216948] 개발-Rail Transit Report상의 일부항목 변경 및 보완
function openAddPaste(dist){
	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
}

function addValueNo(dist, multi_value){
	var multis = multi_value.split('\n');

	multi_value = '';
	for(var i = 0 ; i < multis.length ; i++){
		if(multis[i] != ''){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
	}
	if(multi_value != ''){
		document.getElementById(dist).value = multi_value;
	}
}

function chgBound(val){
	var formObj = document.form;
	if (val =="M" || val== ""){
		formObj.trsp_bnd_cd.value="";
	}else if (val ="F"){
		formObj.trsp_bnd_cd.value="I";
	}
}

function searchSummaryList(){
	
	var sheetObj = sheetObjects[0];
	var opener_obj = window.opener;
	var opener_form = opener_obj.document.form;
	var opener_sheetObj = opener_obj.sheetObjects[0];
	var opnener_xml = opener_sheetObj.GetSaveString(false, false, 'chk');
	
	var parentScNo = document.form.parentScNo.value;

	opener_form.f_cmd.value = SEARCH11;
	//sheetObj.DoSearch("ESD_SCE_0045GS.do", opnener_xml + '&'+ SceFrmQryString(opener_form)+"&cur_page="+PageNo );
	sheetObj.DoSearch("ESD_SCE_0045GS.do", opnener_xml + '&'+ SceFrmQryString(opener_form)+"&cur_page="+PageNo+"&parentScNo="+parentScNo );
	
  	document.form.totcnt.value = sheetObj.EtcData("totcnt");
  	sheetObj.TotalRows = document.form.totcnt.value;
}

function cntr_tpsz_OnCheckClick(comboObj, index, code) {
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
