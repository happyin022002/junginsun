/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S011.js
*@FileTitle  : MNR Local Tariff Creation & Verify 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
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
     * @class ees_mnr_S011 : ees_mnr_S011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업	*/
/* ********* General Functions ************* */
	// 공통전역변수
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="";
	var saveType=0;  //0:save, 1:request, 2:Delete
	var searchType=0; //0:search, 1:load excel, 2:default search
	var comboListGrid=new Array();
	var sSaveRtnXml="";
	//탭메뉴를 가지고 있는 배열
	var tabList=new Array();
	var uTab=new Array();  
	var gTab=new Array(); 
	var zTab=new Array(); 
	var initflag=false;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject7=sheetObjects[0];  //hidden sheet
        var sheetObject1=sheetObjects[1];
        var sheetObject2=sheetObjects[2];
        var sheetObject3=sheetObjects[3];
        var sheetObject4=sheetObjects[4];
        var sheetObject5=sheetObjects[5];
        var sheetObject6=sheetObjects[6];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject2,document.form,IBCLEAR,1);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject3,document.form,IBSAVE);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;
				case "btn_Request":
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
					break;
				case "btn_Copy":
					doActionIBSheet(sheetObject1,document.form,"COPY");
					break;
                //Tafiff No. PopUp
				case "trf_no_popup":
				    ComOpenPopup('/opuscntr/EES_MNR_0188.do?mnr_trf_knd_cd=LCL&vndr_seq='+strVndrSeq, 1000, 540, 'setEES_MNR_0188', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					break;
                //Eff.from Calendar
				case "eff_dt_cal": 
					var status=combo1.GetSelectCode();
					if(status!="HA" && status!="HR" && status!="SR") {
						var cal=new ComCalendar();
						cal.select(formObject.eff_dt, 'yyyy-MM-dd');
					}
					break;
				/** Dry All (S) **/
				case "btn_t1LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t1DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				/** Dry All (E) **/
				/** Reefer Box (S) **/
				case "btn_t2LoadExcel":
					doActionIBSheet(sheetObject2,formObject,IBLOADEXCEL);
					break;
				case "btn_t2DownExcel":
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					break;
				/** Reefer Box (E) **/
				/** Reefer Unit (S) **/
				case "btn_t3LoadExcel":
					doActionIBSheet(sheetObject3,formObject,IBLOADEXCEL);
					break;
				case "btn_t3DownExcel":
					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					break;
				/** Reefer Unit (E) **/
				/** Special Dry (S) **/
				case "btn_t4LoadExcel":
					doActionIBSheet(sheetObject4,formObject,IBLOADEXCEL);
					break;
				case "btn_t4DownExcel":
					doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
					break;
				/** Special Dry (E) **/
				/** Chassis (S) **/
				case "btn_t1LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t1DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				/** Chassis (E) **/
				/** MG Set (S) **/
				case "btn_t1LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t1DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				/** MG Set (E) **/
			}
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e); 
    		} else {
				ComFuncErrMsg(e); 
    		}
    	}
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);
        //IBMultiCombo초기화
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 	   for(var k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[0].SetSelectedIndex(0);
		}
		//hidden sheet 로 인해 i=1 시작함
        for(i=1;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i]);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon이벤트 초기화
		initControl();
		initflag=true;
		//tab명 조회 설정
		setTabName();
//		resizeSheet();
		//화면 초기화 이벤트
		doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,0);
		initflag=false;
		//set Focus
		document.form.search_trf_no.focus();
//		combo2.SetSelectIndex(-1);
    }
  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1: 
	    	case 3: 
	            with (comboObj) { 
	    		SetColAlign(0, "left");
				   SetDropHeight(160);
		        }
	            break;
	    	case 2: 
	            with (comboObj) { 
	    		SetColAlign(0, "left");
	    		SetColAlign(1, "left");
	    		SetColWidth(0, "25");
	    		SetColWidth(1, "75");
		        }
	            break;
	     } 
	}
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , disPlayArray) {
        with (tabObj) {
			RemoveAll();
			var cnt=0 ;   
			for(var j=0; j < disPlayArray.length;j++){
				InsertItem( disPlayArray[j] , "");
		   	}
		} 
        tabObj.SetSelectedIndex(0);
    }
  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj) {
        var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
            case "t1sheet1":
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
			case "t6sheet1":
                with (sheetObj) {
			        var HeadTitle1="|Seq.||Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Material|Component Group|Remark(s)";
			        var HeadTitle2="|Seq.||Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Material|Component Group|Remark(s)";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			               {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
			               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			               {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
			               {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			               {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			               {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			               {Type:"Text",      Hidden:1, Width:113,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
			               {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mtrl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			               {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
			               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
			               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"std_trf_no" } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetSelectionMode(smSelectionFree);
			        SetShowButtonImage(2);
			        SetRangeBackColor(1, 1, 1, 12,"#555555");
			        SetSheetHeight(362);
                }
            break;
        }
    }
    
    function resizeSheet(){
    	for (i=0; i<sheetObjects.length; i++){
    		ComResizeSheet(sheetObjects[i], 75);
    	}
    }
    
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); //- 포커스 나갈때
//	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); //- 포커스 들어갈때
//	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);	//- 변경될때
    }
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj; 
 	}
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/** 
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum','45');//"-"
				}          
	            break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change(){     
		var obj=event.srcElement; 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
	    		case "vndr_seq":  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;  
			}       
	    } else {
			switch(ComGetEvent("name")) {     
	    		case "vndr_seq":  
	        		formObj.vndr_nm.value="";
				   	break;  	
			}  		
		}
	} 
	/** 
	 * COMBO 변경 이벤트
	 * EQ Type 변경시 탭 재설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		//시트에 값이 존재하는지 여부
		var cnt=0;
		for (var i=1; i<sheetObjects.length; i++){
			cnt += sheetObjects[i].RowCount();
		}
		if(cnt>0) {
			//변경의사 확인
			if(!ComShowCodeConfirm("MNR00192")) {
				comboObj.SetSelectCode(comboValue,false);
				return;
			}
			//모든 쉬트를 초기화 	 
		    for(i=1;i<sheetObjects.length;i++){
		    	sheetObjects[i].RemoveAll();
            }
			//시트콤보 재조회 설정
			setSheetCombo(sheetObjects[1]);
		}
		//EQ Type
		comboValue=comboObj.GetSelectCode();
		//Tab재설정,sheetCombo재조회
		if(comboValue=="U") {
			initTab(tabObjects[0],uTab);  
			setSheetCombo(sheetObjects[1]);
		} else if(comboValue=="Z") {
			initTab(tabObjects[0],zTab);  
			setSheetCombo(sheetObjects[1]);
		} else if(comboValue=="G") {
			initTab(tabObjects[0],gTab);  
			setSheetCombo(sheetObjects[1]);
		}
		//only process After DefaultSearch
		if(searchType==2) {
			//default search
			searchDefault(sheetObjects[1]);
		}
		//EQ TYPE 별로 디폴트값을 조회해온후 세팅       
		var defUnitOfMeasure=MnrDefaultUnitOfMeasure(sheetObjects[1],comboObj.GetSelectCode());
		combo3.SetSelectCode(defUnitOfMeasure,false);//UnitOfMass
	}   
	/** 
	 * COMBO 변경 이벤트
	 *     Unit Of Measure 를 inch/cm 로 변경하면 Size/Square 값 재설정
	 *     
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		if(initflag == false){
			var mnrMeasUtCd=Index_Code;
			if(mnrMeasUtCd == "INC") {
				for (var i=1; i<sheetObjects.length; i++){
					for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
						var volTpCd=sheetObjects[i].GetCellValue(j, "vol_tp_cd");
						if(volTpCd != "Q") {
							var inchSize=sheetObjects[i].GetCellValue(j, "inch_size");
							var inchFm=sheetObjects[i].GetCellValue(j, "inch_fm");
							var inchTo=sheetObjects[i].GetCellValue(j, "inch_to");
							sheetObjects[i].SetCellValue(j, "rpr_sz_no",inchSize);
							sheetObjects[i].SetCellValue(j, "fm_rng_sz_no",inchFm);
							sheetObjects[i].SetCellValue(j, "to_rng_sz_no",inchTo);
						}
					}
				}
			} else if(mnrMeasUtCd == "CMT"){
				for (var i=1; i<sheetObjects.length; i++){
					for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
						var volTpCd=sheetObjects[i].GetCellValue(j, "vol_tp_cd");
						if(volTpCd != "Q") {
							var cmSize=sheetObjects[i].GetCellValue(j, "cm_size");
							var cmFm=sheetObjects[i].GetCellValue(j, "cm_fm");
							var cmTo=sheetObjects[i].GetCellValue(j, "cm_to");
							sheetObjects[i].SetCellValue(j, "rpr_sz_no",cmSize);
							sheetObjects[i].SetCellValue(j, "fm_rng_sz_no",cmFm);
							sheetObjects[i].SetCellValue(j, "to_rng_sz_no",cmTo);
						}
					}
				}
			} else {
				ComShowCodeMessage("MNR00010", "Unit Of Measure");
			}
		}
	}
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	//objs[beforetab].style.display="none";
    	for(var i = 0; i<objs.length; i++){
    		if(i != nItem){
    			objs[i].style.display="none";
    			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		}
    	}
    	beforetab=nItem;
//    	resizeSheet();
    }
	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * 조회후 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			//0:save, 1:request, 2:Delete
			if(saveType==0) {
				ComShowCodeMessage("MNR00023");
			} else if (saveType==1) {
				ComShowCodeMessage("MNR00034");
			} else if (saveType==2) {
				ComShowCodeMessage("MNR00020");
			}
			doAfterSave();
		} 
		else { 
		    //Server Message와 중복으로 인한 주석처리
			//ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
	}     
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
	   	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			//초기화
			case IBCLEAR:
				//버튼 ,프로그레스바 설정
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(true);
	    		// 모든 쉬트를 초기화
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		//최초 로딩시에만 값조회
				if(sActionIdx==0) {				
		        	//조건부 콤보데이타 초기화
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}
					//조건부 콤보데이타 조회(UnitOfMass, Currency)
					var sCondition=new Array (
						new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
						new Array("MnrGenCd","SELHO","CUSTOM9"),  	//EQ Type
						new Array("MdmCurrency","", "COMMON"),		//Currency
						new Array("MnrGenCd","CD00010", "COMMON"), 	//UnitOfMass
						new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
						new Array("MnrGenCd","CD00013", "COMMON")	//Type
					)             
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					var sheetComboText="";  
					var sheetComboCode="";
					var sheetComboDefault="";
					//쉬트 콤보 SAVE_NAME
					var comboSaveNames=new Array();
					comboSaveNames[0]="mnr_rng_tp_cd_view";  
					comboSaveNames[1]="vol_tp_cd_view"; 
					//조건부 콤보데이타에 값을 세팅함        
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText="";
							sheetComboCode="";
							sheetComboCodeText="";
							sheetComboDefault=""; 
							//Display[CODE_NAME]:Status,UnitOfMass 
							if(i==0 || i==1 || i==3) {
								for(var j=0; j < comboList[i].length;j++){ 
									var tempText=comboList[i][j].split("|");    
									//Status
									if(i==0) {
										combo1.InsertItem(j, tempText[1] ,tempText[0]);
									//EQ Type
									} else if(i==1) {
										combo2.InsertItem(j, tempText[1] ,tempText[0]);
									//UnitOfMass
									} else if(i==3){
										combo3.InsertItem(j, tempText[1] ,tempText[0]);
									}
								}
							//Display[CODE]:Currency
							} else if(i==2){
								for(var j=0; j < comboList[i].length;j++){ 
									combo4.InsertItem(j, comboList[i][j] ,j);
								}
							//쉬트콤보 설정
							} else if (i==4||i==5) {
								for(var j=0; j < comboList[i].length;j++){
									var tempText=comboList[i][j].split("|");    
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
									if(j ==0){
										sheetComboDefault=tempText[0];      	
									} 
								}
							}
							//탭별 쉬트 콤보 설정
							for(var k=1; k<sheetObjects.length; k++) {
								if(i==4||i==5) {
									sheetObjects[k].InitDataCombo (0, comboSaveNames[i-4], sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							}
						}
					}
				}
				//vendor 의 default Currency 세팅함
				formObj.vndr_seq.value=ComLpad(strVndrSeq,6,"0");
				formObj.vndr_nm.value=strVndrNm;
				var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
				var vndrSeq=ComGetEtcData(sXml, "vndr_seq");
				if(vndrSeq != "" && vndrSeq != null && vndrSeq != "undefined"){ 
					//Vender nm 세팅		
					//ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm")); 
					//Currency 세팅
					combo4.SetSelectText(ComGetEtcData(sXml, "pay_curr_cd"));
				} else {       
					ComShowCodeMessage("MNR00005", "Service Provider");              
					ComSetObjValue(formObj.vndr_nm, ""); 
					ComSetObjValue(formObj.vndr_seq, "");
					combo4.SetSelectText("USD");
				}				
				//콤보초기값 설정
				combo1.SetSelectCode("");//Status
				combo2.SetSelectCode("U");//EQ Type
				//EQ TYPE 별로 디폴트값을 조회해온후 세팅   
				var defUnitOfMeasure=MnrDefaultUnitOfMeasure(sheetObj,combo2.GetSelectCode());
				combo3.SetSelectCode(defUnitOfMeasure);//UnitOfMass
				//콤보이외의 조회조건값 초기화
				if(sheetObj.id == 't1sheet1') {	//Tariff No Road
					formObj.search_trf_no.value=""; 
				} else {						//Tariff No New/Copy
					formObj.search_trf_no.value="NEW"; 
				}
				formObj.trf_no.value="NEW"; 				//Tariff No for Save
				formObj.search_trf_no.readOnly=false;				//Tariff No ReadOnly
				formObj.search_trf_no.className="input1";				//Tariff No Class
				formObj.eff_dt.value=ComGetNowInfo("ymd");	//Eff.from 
				formObj.eff_dt.readOnly=false;				//Eff.from
				formObj.eff_dt.className="input1";				//Eff.from
				formObj.cre_dt.value=ComGetNowInfo("ymd");	//Creation Date
				formObj.mnr_trf_sts_cd.value="";					//Tariff Status 
				formObj.mnr_trf_rmk.value="";					//Remark(s)
				formObj.std_trf_no.value="";					//Standard Tariff No
				//EQ Type,Currency 콤보 활성화 설정
				combo1.SetEnable(0);//Status
				combo2.SetEnable(1);//EQ Type
				combo3.SetEnable(1);//Unit Of Measue
				combo4.SetEnable(1);//Cur
				//Default Search////////
				searchDefault(sheetObj);
				////////////////////////
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				//Button 활성화 설정  
				setButtonEnDisable();
				sheetObj.SetWaitImageVisible(0);
                break;
			//조회
            case IBSEARCH:
            	sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;      
                if(validateForm(sheetObj,formObj,sAction)) {
					//다중조회
                	var sXml=sheetObj.GetSearchData("EES_MNR_0014GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					//Header
					var arrResult=MnrXmlToArray(arrXml[0]);
					if(arrResult != null){
						formObj.trf_no.value=arrResult[0][19];	//triff No    
						formObj.eff_dt.value=arrResult[0][6];  //계약 시작일
						formObj.rqst_ofc_cd.value=arrResult[0][4];	//Tariff Office
						formObj.vndr_seq.value=arrResult[0][1];	//S/Provider Code
						formObj.vndr_nm.value=arrResult[0][2];	//S/Provider Name
						formObj.cre_dt.value=arrResult[0][9];  //생성 일자
						formObj.cre_usr_id.value=arrResult[0][14]; //생성 User ID
						formObj.vndr_seq.value=arrResult[0][1];  //Vendor Sequence
						if(arrResult[0][1] != "") {
							doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
						}
						formObj.mnr_trf_sts_cd.value=arrResult[0][23]; //Tariff Status Code
						formObj.mnr_trf_rmk.value=arrResult[0][18]; //Remark(s)
						combo4.SetSelectText(arrResult[0][7]);//Currency
						combo1.SetSelectCode(arrResult[0][23]);//Tariff Status Code
						combo2.SetSelectCode(arrResult[0][24]);//EQ Type(U:CONTAINER,Z:CHASSIS,G:GENSET)
						combo3.SetSelectCode(arrResult[0][10]);//Unit Of Mass (CMT:CM, INC:inch)
						setButtonEnDisable();  //Button GetEnable()설정
					} else {
						ComShowCodeMessage("MNR00204");
						doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,1);
						formObj.search_trf_no.focus();
						return;
					}
					//0 vndr_seq|1 vndr_nm|2 agmt_no|3 rqst_ofc_cd|4 pagerows|5 eff_dt|6 curr_cd|7 ibflag|8 cre_dt|9 mnr_meas_ut_cd|10 upd_usr_id|11 apro_ofc_cd|12 cre_usr_id|13 mnr_trf_sts_dt|14 mnr_trf_knd_cd|15 sts_ref_no|16 mnr_trf_rmk|17 trf_no|18 cre_usr_nm|19 eq_knd_nm|20 mnr_inp_tp_cd|21 mnr_trf_sts_cd|22 eq_knd_cd|23 upd_dt|24 pre_trf_no|
					//vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no
					//MnrXmlToArrayDebug('vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no');
					//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no
					//Detail
					var eqTypeCd=arrResult[0][24];
					searchType=0;
					if(eqTypeCd=="U") {
						for(var i=1; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						setTabSelect(); //탭선택
					} 
					else if (eqTypeCd=="Z") {
						sheetObjects[1].LoadSearchData(arrXml[5],{Sync:1} );
					}
					else if (eqTypeCd=="G") {
						sheetObjects[1].LoadSearchData(arrXml[6],{Sync:1} );
					}
				}
                break;
			//조회(sevice provider No. 입력시)
			case IBSEARCH_ASYNC01:	
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Service Provider Detail Information  
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");  
					var vndrSeq=ComGetEtcData(sXml, "vndr_seq");
					if(vndrSeq != "" && vndrSeq != null && vndrSeq != "undefined"){ 
						//Vender nm 세팅		
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						//Currency 세팅
						combo4.SetSelectText(ComGetEtcData(sXml, "pay_curr_cd"));
					} else {       
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_nm, ""); 
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}   
				}	
				break; 		
			//저장
            case IBSAVE:
                if(validateForm(sheetObj,formObj,sAction)) {
                	sheetObj.SetWaitImageVisible(1);
                	formObj.f_cmd.value=MULTI;
					//set Combo or Hidden Value;
					formObj.mnr_trf_sts_cd.value=combo1.GetSelectCode();  	//Status
					formObj.eq_knd_cd.value=combo2.GetSelectCode();  	//EQ Type
					formObj.eq_knd_nm.value=combo2.GetSelectText();  	//EQ Type Name
					formObj.mnr_meas_ut_cd.value=combo3.GetSelectCode();  	//Unit Of Mass
					formObj.curr_cd.value=combo4.GetSelectText();  	//Currency
					formObj.mnr_trf_knd_cd.value="LCL";  				 	//Tariff 종류 표시(STD:Standard Tariff, LCL:Local Tariff)
					var rqstOfcCd=formObj.rqst_ofc_cd.value;
					var preOfcCd=rqstOfcCd.trim().substring(0,3);
					formObj.pre_trf_no.value=preOfcCd+"("+comboValue+")-L-";	//Tariff_No의 prefix
					//Tariff Status Code  (SS:Save[SPP],SR:Request[SPP],SD:Delete[SPP],HR:Request,HS:Save,HJ:Reject,HD:Delete,HE:Expired,HA:Approval)
					//Save
					if(sheetObj.id == 't1sheet1') {  
						formObj.mnr_trf_sts_cd.value="SS";
						saveType=0;  
					} 
					//Request
					else if (sheetObj.id == 't2sheet1') {
						formObj.mnr_trf_sts_cd.value="SR";
						setRowStausByConfirm();	//저장이벤트 발생을 위한 상태변경
						saveType=1;
					}
					//Delete
					else {
						formObj.mnr_trf_sts_cd.value="SD";
						setRowStausByConfirm();	//저장이벤트 발생을 위한 상태변경
						saveType=2;
					}
					//2009-12-24:속도향상을 위해 형식변경
					//var sParam = ComGetSaveString(sheetObjects);
					var sParam="";
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount()> 0) {
							sParam=sParam + "&" +	MnrGetAllSaveText(sheetObjects[i], true, "ibflag");
						}
					}
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
					//Tariff No 를 return 받는다.
				    sSaveRtnXml=sheetObjects[1].GetSaveData("EES_MNR_0014GS.do", sParam);
				    sheetObjects[1].LoadSaveData(sSaveRtnXml);  //저장 성공확인 메세지를 위한 Load
				    sheetObj.SetWaitImageVisible(0);
				}
                break;
			//복사 
			case "COPY":
				if(validateForm(sheetObj,formObj,sAction)) {
					//조건부 값 초기화
					formObj.trf_no.value="NEW"; 				//trf_no for save
					formObj.search_trf_no.value="NEW";				//trf_no for search
					formObj.search_trf_no.className="input1";				//trf_no for search
					formObj.search_trf_no.readOnly=false;				//trf_no for search
					formObj.eff_dt.value=ComGetNowInfo("ymd"); //Eff.from
					formObj.eff_dt.readOnly=false; 				//Eff.from
					formObj.eff_dt.className="input1"; 			//Eff.from
					formObj.mnr_trf_sts_cd.value="";					//Status
					formObj.rqst_ofc_cd.value=currOfcCd;			//Tariff Office
					formObj.cre_usr_id.value=usrId;				//Creation User
					formObj.cre_dt.value=ComGetNowInfo("ymd");	//Creation Date
					combo4.SetEnable(1);//Cur
					combo1.SetSelectCode("");//Status
					combo2.SetEnable(0);//EQ Type
					combo3.SetEnable(1);//Unit Of Measure
					//조회부 시트상태값,trf_no 변경
					setRowStausByCopy(formObj);
					//Button Enable 설정  
					setButtonEnDisable();    
				}
				break;
            //Load Excel
			case IBLOADEXCEL:
				if(validateForm(sheetObj,formObj,sAction)) {
					var eqTypeCd=combo2.GetSelectCode(); 		//EQ Type
					var stdTrfNo=formObj.std_trf_no.value;	//Standard Tariff No
//					ComOpenPopup('/opuscntr/EES_MNR_0190.do?eqTypeCd='+eqTypeCd+"&programId=ees_mnr_0011"+"&stdTrfNo="+stdTrfNo, 1020, 591, 'setEES_MNR_190', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					ComOpenPopup('/opuscntr/EES_MNR_0190.do?eqTypeCd='+eqTypeCd+"&programId=ees_mnr_0011"+"&stdTrfNo="+stdTrfNo, 1020, 591, 'setEES_MNR_190', 'none', true);
					searchType=1;
				}   
				break;
            //Down Excel
			case IBDOWNEXCEL:
				var eqTypeCd=comboValue;
				if(eqTypeCd=="U"){
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount()> 0){
							//sheetObjects[i].Down2Excel4FreeForm(1,true);
							sheetObjects[i].Down2Excel({ HiddenColumn:1});
						}
					}
				} else {
					//sheetObj.Down2Excel(-1); 
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
				}
				break;
        }
    }
  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			//조회시
			if(sAction==IBSEARCH){
				//Dataformat
				if (!ComChkValid(formObj)) {return false;}
			}
			//저장(요청,삭제)시
			else if(sAction==IBSAVE) {
				//Tariff상태값 체크
				if(!checkTariffStatus()) {return false;}
				//저장시 필수
				if(!checkMandatory(formObj.eff_dt)) {return false;}
				if(!checkMandatory(formObj.vndr_seq)) {return false;}
				//그리드 존재유무 
				if(!checkIsDetailRow()) {return false;}
  				//Delete버튼 클릭시
				if(sheetObj.id == 't3sheet1'){
					var trfNo=document.form.trf_no.value
					if(trfNo=="NEW"){
						ComShowCodeMessage("MNR00199");
						return false;
					}
					if(!ComShowCodeConfirm("MNR00026")){return false}
				}
				//Request버튼 클릭시
				if(sheetObj.id == 't2sheet1'){
					var trfNo=document.form.trf_no.value
					if(trfNo=="NEW"){
						ComShowCodeMessage("MNR00199");
						return false;
					}
					//Eff.from,Currency 확인 및 Material 값 존재유무 확인
					if(!checkMaterial()) { return false;}
				}
				//Save 버튼 클릭시
				if(sheetObj.id == 't1sheet1') {
					//Eff.from,Currency 확인 및 Material 값 존재유무 확인
					if(!checkMaterial()) { return false;}
				}
			}
			//복사시
			else if (sAction=="COPY") {
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
/* ********* User Functions ************* */
	/**
	 * EES_MNR_0188 Popup의 값을 받은 함수      
	 */
	function setEES_MNR_0188(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form; 
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
    	 	formObj.search_trf_no.value=aryPopupData[0][3];
		 }
		 doActionIBSheet(sheetObjects[1],formObj,IBSEARCH); 
	}      
    /**
     * 저장시 필수 체크
     * @param	{Element}	obj	체크할 Form Element
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(obj)) {  
		    ComShowCodeMessage("MNR00003");
		    obj.focus();
		    return false;
		}
		return true;
	}
	/**
	 * 저장시 그리드 존재유무
	 */
	function checkIsDetailRow(){
		var cnt=0;
		for (var i=1; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		return true;
	}
	/**
	 * Confirm/Delete버튼 클릭시 저장이벤트를 강제 발생시키기 위해 
	 * 존재하는 최초의 1개의 Row상태값만을 'U'로 변경시킴
	 */
	function setRowStausByConfirm(){
		for (var i=1; i<sheetObjects.length; i++) {
			//데이터가 존재하는 시트인 경우만  
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					if(sheetObjects[i].GetRowStatus(j)== "R") {
					    sheetObjects[i].SetRowStatus(j,"U");
						return;
					}
				}
			}
		}
	}
	/**
	 * Copy버튼 클릭시 그리드의 모든 Row의 상태값을 'I'로 변경시키고 trf_no값 초기화시킴
	 * @param	{Form}		formObj		폼오브젝트
	 */
	function setRowStausByCopy(formObj){
		for (var i=1; i<sheetObjects.length; i++) {
			//데이터가 존재하는 시트인 경우만  
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					if(sheetObjects[i].GetRowStatus(j)!= "D") {
					    sheetObjects[i].SetRowStatus(j,"I");
						sheetObjects[i].SetCellValue(j, "trf_no",formObj.trf_no.value,0);
					}
				}
			}
		}
	}
	/**
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
    	var volTpCd=sheetObj.GetCellValue(Row, "vol_tp_cd");  //Volume Type
		//Q'ty
		if(volTpCd=='Q'){
			sheetObj.SetCellValue(Row, "rpr_sz_no","",0);
		//Size/Square
		} else {
			sheetObj.SetCellValue(Row, "rpr_qty","",0);
		}
	}
	/** 
	 * 조회 성공시 처리함.
	 */
	function doAfterSearch() {
		var formObject=document.form;
		//search
		if(searchType==0) {
			formObject.search_trf_no.readOnly=true;		//Tariff No ReadOnly
			formObject.search_trf_no.className="input2";	//Tariff No Class
			combo2.SetEnable(0);//EQ_Type Edit설정
			//Status(Tariff Approval)
			var status=combo1.GetSelectCode();
			if(status=="HA"||status=="HR"||status=="SR") {
				formObject.eff_dt.readOnly=true;		//Eff.from
				formObject.eff_dt.className="input2";	//Eff.from
				combo4.SetEnable(0);//Curr
				combo3.SetEnable(0);//Unit Of Measure
			} else {
				formObject.eff_dt.readOnly=false;	//Eff.from
				formObject.eff_dt.className="input1";	//Eff.from
				combo4.SetEnable(1);//Curr
				combo3.SetEnable(1);//Unit Of Measure
			}
		}
		//load 
		else if (searchType==1) {
			var trfNo=formObject.trf_no.value;
			if(trfNo=="" || trfNo==null || trfNo=="NEW") {
				setSheetStatus("I");
			} else {
				setSheetStatus("U");
			}
		}
		//default search
		else if (searchType==2) {
			setSheetStatus("I");
			setStdTrfNo();
		}
	}
	/** 
	 * 저장 성공시 처리함.
	 * 삭제저장:초기화, 저장/확정저장:재조회
	 */
	function doAfterSave() {
		//삭제후 초기화
		if(saveType==2) {
			doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,1);
		}  
		//저장,요청후 재조회 
        else {
			var arrResult=MnrXmlToArray(sSaveRtnXml);
			document.form.search_trf_no.value=arrResult[0][19];
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
		saveType=0;
	}
	/**
	 * setEES_MNR_190 의 값을 받은 함수  
	 * @param Array[]	rArray				리턴받은 데이터
	 */
	function setEES_MNR_190(rArray){
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		//handling in popup.
		sheetObjects[1].LoadSearchData(rArray[0],{Sync:1} );
		sheetObjects[2].LoadSearchData(rArray[1],{Sync:1} );
		sheetObjects[3].LoadSearchData(rArray[2],{Sync:1} );
		sheetObjects[4].LoadSearchData(rArray[3],{Sync:1} );
    }    
	/** 
	 * 상태에 따라 버튼을 활성/비활성화 시킴
	 * 상태값이 요청인 경우 비활성화 시키는 버튼
	 * (Delete, Save, Confirm, LoadExcel) 
	 */
    function setButtonEnDisable() {
		var mnrTrfStsCd=document.form.mnr_trf_sts_cd.value;  //Tariff Status
		//HA:Approval, HR:Request
		if(mnrTrfStsCd=="HA" || mnrTrfStsCd=="SR" || mnrTrfStsCd=="HR"  ){
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Request");
			ComBtnDisable("btn_t1LoadExcel");
			ComBtnDisable("btn_t2LoadExcel");
			ComBtnDisable("btn_t3LoadExcel");
			ComBtnDisable("btn_t4LoadExcel");
		} else {
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Request");
			ComBtnEnable("btn_t1LoadExcel");
			ComBtnEnable("btn_t2LoadExcel");
			ComBtnEnable("btn_t3LoadExcel");
			ComBtnEnable("btn_t4LoadExcel");
		}
	}
	/**
	 * Tariff 상태값을 체크하여 요청인 경우 false를 
	 * 그외의 경우는 true를 리턴한다.
	 * @return  {Boolean}    true/false
	 */
	function checkTariffStatus() {
		var mnrTrfStsCd=document.form.mnr_trf_sts_cd.value; //mnr_trf_sts_cd
		if(mnrTrfStsCd=="SR"){
			ComShowCodeMessage("MNR00190","Tariff");
			return false;
		}
		return true;
	}
	/**
	 * 탭명 조회 설정
	 */
	function setTabName() {
		var sCondition=new Array (
			new Array("MnrGenCd","CC", "CUSTOM3")  //탭명조회
		)
		tabList=MnrComSearchCombo(sheetObjects[1],sCondition);
		var uCnt=0;
		var gCnt=0;
		var zCnt=0;
		for(var i=0; i < tabList[0].length;i++){
			var tempText=tabList[0][i].split("|");
			if(tempText[0] == "U"){    
				uTab[uCnt++]=tempText[1]; 					
			} 	
			if(tempText[0] == "Z"){  
				zTab[zCnt++]=tempText[1];      		
			}  
			if(tempText[0] == "G"){   
				gTab[gCnt++]=tempText[1];		
			} 	
		}
	}
	/**
	 * 쉬트 콤보 데이티 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj) {
		//쉬트 콤보데이타 조회
		var sCondition=new Array (      
			new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
			new Array("MnrGenCd","CD00013", "COMMON")	//Type
		)             
		comboListGrid=MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 콤보데이타에 값을 세팅함 
		var sheetComboText="";  
		var sheetComboCode="";
		var sheetComboDefault="";
		//쉬트 콤보 SAVE_NAME
		var comboSaveNames=new Array();
		comboSaveNames[0]="mnr_rng_tp_cd_view";  
		comboSaveNames[1]="vol_tp_cd_view"; 
		for(var i=0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//쉬트콤보별 초기화
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
				sheetComboDefault=""; 
		 		for(var j=0; j < comboListGrid[i].length;j++){ 
					var tempText=comboListGrid[i][j].split("|");    
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){
						sheetComboDefault=tempText[0];      	
					}  
				}
				//탭별 쉬트 콤보 설정
				for(var k=1; k<sheetObjects.length; k++) {
					sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault); 
				}
			}    
		}       
		//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다.
		if (sheetComboText != "") {
	        sheetComboText=sheetComboText.substr(0, sheetComboText.length - 1);	
		}
		if (sheetComboCode != "") {
	        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length - 1);
		}
		//모든 쉬트를 초기화 	 
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll();
        }
	}
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;   
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=aryPopupData[0][2];
			formObj.vndr_nm.value=aryPopupData[0][4];
			var sXml=MnrGetPartner(sheetObjects[0],formObj.vndr_seq.value,"RPR");
			if(ComGetEtcData(sXml, "vndr_seq") != null){ 
				//Vender nm 세팅		
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));  
				//Curr 세팅 	
				combo4.SetSelectText(ComGetEtcData(sXml, "pay_curr_cd"));
			} else {	       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_nm, "");  
				ComSetObjValue(formObj.vndr_seq, ""); 
				ComSetFocus(formObj.vndr_seq); 	
			}   	
		}
	}
	/**
	 * DEFAULT 데이터 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
    function searchDefault(sheetObj) {
		//Default Search
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH; 
		formObj.eq_knd_cd.value=comboValue; 
		//다중조회
		var sXml=sheetObj.GetSearchData("EES_MNR_S011GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		//Detail
		var eqTypeCd=comboValue;
		searchType=2;
		if(eqTypeCd=="U") {
			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
		} 
		else if (eqTypeCd=="Z") {
			sheetObjects[1].LoadSearchData(arrXml[4],{Sync:1} );
		}
		else if (eqTypeCd=="G") {
			sheetObjects[1].LoadSearchData(arrXml[5],{Sync:1} );
		}
	}
    /**
     * 저장전 Material 값이 존재하는지 체크하고
     * Eff.from 과 Currency 확인 메시지 띄움.
     * @return
     */
    function checkMaterial() {
    	for (var i=1; i<sheetObjects.length; i++){
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					var mtrlCostAmt=sheetObjects[i].GetCellValue(j, "mtrl_cost_amt");
					if(mtrlCostAmt == "" || mtrlCostAmt == null) {
						//Currency와 Eff.From을 확인하여 주시기 바랍니다.\nMaterial Cost를 입력하지 않은 항목이 있습니다. 그래도 진행하시겠습니까?
						if(!ComShowCodeConfirm("MNR00278")){ 
							sheetObjects[i].SelectCell(j, "mtrl_cost_amt");
							return false
						} else {
							return true;
						}
					}
				}
			}
	    }
		//Currency와 Eff.From을 정확하게 입력하였습니까?
		if(!ComShowCodeConfirm("MNR00278")){ 
			return false
		}else {
			return true;
		}    	
    }
    /**
     * Sheet 의 상태값을 설정한다. 
     * @param status
     * @return
     */
    function setSheetStatus(status) {
		for(var i=1; i<sheetObjects.length; i++) {
			for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++){
				sheetObjects[i].SetRowStatus(j,status);
			}
		}
    }
	/**
	 * 조회후 4개의 탭중 값이 존재하는 탭을 선택하여 보여줌
	 * @return
	 */
	function setTabSelect(){
		for (var i=1; i<=4; i++) {
			var rowCnt=sheetObjects[i].RowCount();
			if(rowCnt>0) {
				tabObjects[0].SetSelectedIndex((i-1));
				return;
			}
		}
	}    
	/**
	 * Default 조회시 Standard Tariff No 를 조회하여 폼값에 입력한다.
	 * @return
	 */
	function setStdTrfNo() {
		for (var i=1; i<=4; i++) {
			var rowCnt=sheetObjects[i].RowCount();
			if(rowCnt>0) {
				var stdTrfNo=sheetObjects[i].GetCellValue(sheetObjects[i].HeaderRows(), "std_trf_no");
				document.form.std_trf_no.value=stdTrfNo;
				return;
			}
		}
	}
/* 개발자 작업	*/
