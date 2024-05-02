/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0215.js
*@FileTitle : MNR Local Tariff Creation & Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.07.02 WanGyu Kim
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
     * @class ees_mnr_0215 : ees_mnr_0215 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0215() {
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
/* ********* General Functions ************* */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var comboValue = "";
	var comboListGrid =new Array();
	//탭메뉴를 가지고 있는 배열
	var tabList = new Array();
	var uTab = new Array();  
	var gTab = new Array(); 
	var zTab = new Array(); 


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject7 = sheetObjects[0];  //hidden sheet
        
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];
        var sheetObject4 = sheetObjects[4];
        var sheetObject5 = sheetObjects[5];
        var sheetObject6 = sheetObjects[6];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;

				case "btn_Close":
					window.close();
					break;
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
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }

		//hidden sheet 로 인해 i=1 시작함
        for(i=1;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
			
            initSheet(sheetObjects[i]);
        	
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
    	setTabName();
    	doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	   
	    switch(comboNo) {
	    	case 1: 
	    	case 3: 
	            with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
		        }
	            break;
	    	case 2: 
	            with (comboObj) { 
			        SetColAlign("left|left");        
			        SetColWidth("25|75")   
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
			var cnt  = 0 ;   
			for(var j = 0; j < disPlayArray.length;j++){
				InsertTab( cnt++ , disPlayArray[j] , -1 );           	
		   	}
		} 
    }
	
  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj) {
        var cnt = 0;
		var sheetid = sheetObj.id;
		switch(sheetid) {
            case "t1sheet1":
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
			case "t6sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 362;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);

					var HeadTitle1 = "|Seq.||Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Material|Component Group|Remark(s)";
                	var HeadTitle2 = "|Seq.||Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Material|Component Group|Remark(s)";
              
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+ 4, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,	 	30,		daCenter,	true,	"Seq");
	                InitDataProperty(0, cnt++ , dtHidden,  		0,		daRight,	true,	"cost_grp_cd");
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	"eq_cmpo_cd",		false,	"",	dfNone,			0,	false,	false,	3,	true);
	                InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"eq_rpr_cd",		false,	"",	dfNone,			0,	false,	false,	2,	true);
	                InitDataProperty(0, cnt++ , dtData,  		50,		daCenter,	true,	"trf_div_cd",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,  		200,	daLeft,		true,	"dtl_desc",			false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtCombo,  		90,		daLeft,		true,	"mnr_rng_tp_cd",	false,	"",	dfNone, 		0,	false,	false);
	                InitDataProperty(0, cnt++ , dtCombo,  		60,		daLeft,		true,	"vol_tp_cd",		false,	"",	dfNone, 		0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,  		40,		daRight,	true,	"rpr_qty",			false,	"",	dfNullInteger, 	0,	false,	false,	6,	false);
	                InitDataProperty(0, cnt++ , dtData,  		85, 	daRight,	true,	"rpr_sz_no",		false,	"",	dfNullInteger, 	0,	false,	false,	10,	false);
	                InitDataProperty(0, cnt++ , dtData,  		50,		daRight,	true,	"fm_rng_sz_no",		false,	"",	dfNullInteger,	0,	false,	false,	8,	false);
	                InitDataProperty(0, cnt++ , dtData,  		60,		daRight,	true,	"to_rng_sz_no",		false,	"",	dfNullInteger,	0,	false,	false,	8,	false);
	                InitDataProperty(0, cnt++ , dtData,  		65,		daRight,	true,	"rpr_lbr_hrs",		false,	"",	dfFloat, 		2,	false,	false,	6,	false);
	                InitDataProperty(0, cnt++ , dtHidden,  		113,	daRight,	true,	"mtrl_reco_amt",	false,	"",	dfFloat, 		2,	false,	false,	18,	false);
	                InitDataProperty(0, cnt++ , dtData,  		60,		daRight,	true,	"mtrl_cost_amt",	false,	"",	dfNullFloat, 	2,	false,	false,	18,	false);
	                InitDataProperty(0, cnt++ , dtData,  		110,	daLeft,		true,	"eq_cmpo_up_cd",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,  		83,		daLeft,		true,	"dtl_rmk",			false,	"",	dfNone,			0,	false,	false);
	                //Hidden데이터
	                InitDataProperty(0, cnt++ , dtHidden,  		50,		daLeft,		true,	"trf_no");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"trf_dtl_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"inch_size");
	                InitDataProperty(0, cnt++ , dtHidden,  		30,		daRight,	true,	"cm_size");
					
					MultiSelection = false;
					ShowButtonImage = 2;
					CountPosition = 0;
                }
                break;
			
			default:
				break;
        }
    }

	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj; 
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
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/** 
	 * COMBO 변경 이벤트
	 * EQ Type 변경시 탭 재설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo2_OnChange(comboObj,Index_Code, Text){
		//EQ Type
		comboValue = comboObj.Code;
		
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
	}   

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
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
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
	   	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//초기화
			case IBCLEAR:
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);
				
	        	//조건부 콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();	
				}
				//콤보데이타 조회(UnitOfMass, Currency)
				var sCondition = new Array (
					new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
					new Array("MnrGenCd","SELHO","CUSTOM9"),  	//EQ Type
					new Array("MnrGenCd","CD00010", "COMMON"), 	//UnitOfMass
					new Array("MdmCurrency","", "COMMON"),		//Currency
					new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
					new Array("MnrGenCd","CD00013", "COMMON")	//Type
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				var sheetComboText 		= "";  
				var sheetComboCode 		= "";
				var sheetComboDefault	= "";
				//쉬트 콤보 SAVE_NAME
				var comboSaveNames = new Array();
				comboSaveNames[0] = "mnr_rng_tp_cd";  
				comboSaveNames[1] = "vol_tp_cd"; 
				
				//조건부 콤보데이타에 값을 세팅함        
				for(var i=0; i<comboList.length ; i++){
					if(comboList[i] != null){
						//쉬트콤보별 초기화
						sheetComboText = "";
						sheetComboCode = "";
						sheetComboCodeText = "";
						sheetComboDefault = ""; 

						//Display[CODE_NAME]:Status,EQ Type,UnitOfMass 
						if(i==0 || i==1 || i==2) {
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");    
								//Status
								if(i==0) {
									formObj.combo1.InsertItem(j, tempText[1] ,tempText[0]);
								//EQ Type
								} else if(i==1){
									formObj.combo2.InsertItem(j, tempText[1] ,tempText[0]);
								//UnitOfMass
								} else if(i==2) {
									formObj.combo3.InsertItem(j, tempText[1] ,tempText[0]);
								}
							}
						//Display[CODE]:Currency
						} else if(i==3){
							for(var j = 0; j < comboList[i].length;j++){ 
								formObj.combo4.InsertItem(j, comboList[i][j] ,j);
							}
						//쉬트콤보 설정
						} else if (i==4||i==5) {
							for(var j = 0; j < comboList[i].length;j++){
								var tempText = comboList[i][j].split("|");    
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
								if(j ==0){
									sheetComboDefault = tempText[0];      	
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
				
				//EQ Type,Currency 콤보 활성화 설정
				comboObjects[0].Enable = false;	//Status
				comboObjects[1].Enable = false;	//EQ Type
				comboObjects[2].Enable = false;	//UnitOfMass
				comboObjects[3].Enable = false;	//Currency
				
				//Search
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
				
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;

                break;
				
			//조회
            case IBSEARCH:
				sheetObj.WaitImageVisible = true;
				formObj.f_cmd.value = SEARCH;      
                if(validateForm(sheetObj,formObj,sAction)) {
					//다중조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0014GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					//Header
					var arrResult = MnrXmlToArray(arrXml[0]);
					if(arrResult != null){
						formObj.eff_dt.value 			= arrResult[0][6];  //계약 시작일
						formObj.rqst_ofc_cd.value		= arrResult[0][4];	//Tariff Office
						formObj.vndr_seq.value			= arrResult[0][1];	//S/Provider Code
						formObj.cre_dt.value 			= arrResult[0][9];  //생성 일자
						formObj.cre_usr_id.value 		= arrResult[0][14]; //생성 User ID
						formObj.mnr_trf_rmk.value 		= arrResult[0][18]; //Remark(s)
						if(arrResult[0][1] != "") {
							doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01); //S/Provider Name
						}
						formObj.combo4.Text = arrResult[0][7];  	//Currency
						formObj.combo1.Code = arrResult[0][23];		//Tariff Status Code
						formObj.combo2.Code = arrResult[0][24];  	//EQ Type(U:CONTAINER,Z:CHASSIS,G:GENSET) 
						formObj.combo3.Code = arrResult[0][10];  	//Unit Of Mass (CMT:CM, INC:inch)
						
					} else {
						ComShowCodeMessage("MNR00204");
						return;
					}
					//0 vndr_seq|1 vndr_nm|2 agmt_no|3 rqst_ofc_cd|4 pagerows|5 eff_dt|6 curr_cd|7 ibflag|8 cre_dt|9 mnr_meas_ut_cd|10 upd_usr_id|11 apro_ofc_cd|12 cre_usr_id|13 mnr_trf_sts_dt|14 mnr_trf_knd_cd|15 sts_ref_no|16 mnr_trf_rmk|17 trf_no|18 cre_usr_nm|19 eq_knd_nm|20 mnr_inp_tp_cd|21 mnr_trf_sts_cd|22 eq_knd_cd|23 upd_dt|24 pre_trf_no|
					//vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no
					//MnrXmlToArrayDebug('vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no');
					
					//Detail
					var eqTypeCd = arrResult[0][24];
					if(eqTypeCd=="U") {
						for(var i = 1; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchXml(arrXml[i]);
						}
						setTabSelect(); //탭선택
					} 
					else if (eqTypeCd=="Z") {
						sheetObjects[1].LoadSearchXml(arrXml[5]);
					}
					else if (eqTypeCd=="G") {
						sheetObjects[1].LoadSearchXml(arrXml[6]);
					}
				}
                break;

			//조회(sevice provider No. 입력시)
			case IBSEARCH_ASYNC01:	
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Service Provider Detail Information  
					var sXml = MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");  
							 
					if(ComGetEtcData(sXml, "vndr_seq") != ""){ 
						//Vender nm 세팅		
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));  
						
					} else {       
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_nm, ""); 
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}   
				}	
				break; 		
			
            //Down Excel
			case IBDOWNEXCEL:
				var eqTypeCd = comboValue;
				if(eqTypeCd=="U"){
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount > 0){
							//sheetObjects[i].Down2Excel4FreeForm(-1,true);
							sheetObjects[i].SpeedDown2Excel(-1,true);
						}
					}
				
				} else {
					//sheetObj.Down2Excel(-1); 
					sheetObj.SpeedDown2Excel(-1); 
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
			if(sAction==IBSEARCH){
			}
        }
        return true;
    }

/* ********* User Functions ************* */
	/**
	 * 그리드 존재유무
	 */
	function checkIsDetailRow(){
		var cnt = 0;
		for (var i=1; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount > 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}

		return true;
	}
	
	/**
	 * Volume Type 콤보값에 따라 Q'ty와 Size/Square의 값을 재설정한다.
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
		var volTpCd = sheetObj.CellValue(Row, "vol_tp_cd");  //Volume Type
		//Q'ty
		if(volTpCd=='Q'){
			///////////////////////////////////////////////////////////////////////////
	    	//(2009-09-03): QTY / Size의 에 대하여 Size/Square Section을 입력 할수 있도록 처리
			///////////////////////////////////////////////////////////////////////////

			//sheetObj.CellValue2(Row, "fm_rng_sz_no")	= "";
			//sheetObj.CellValue2(Row, "to_rng_sz_no")	= "";
			sheetObj.CellValue2(Row, "rpr_sz_no")		= "";
		//Size/Square
		} else {
			sheetObj.CellValue2(Row, "rpr_qty")			= "";
		}
	}

	/** 
	 * 조회 성공시 처리함.
	 */
	function doAfterSearch() {
		for(var i=1; i<sheetObjects.length; i++) {
			for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++){
				setEditableByVolumeType(sheetObjects[i],j);	
			}
		}
	}

	/**
	 * 탭명 조회 설정
	 */
	function setTabName() {
		var sCondition = new Array (
			new Array("MnrGenCd","CC", "CUSTOM3")  //탭명조회
		)
		tabList = MnrComSearchCombo(sheetObjects[1],sCondition);
		
		var uCnt = 0;
		var gCnt = 0;
		var zCnt = 0;

		for(var i = 0; i < tabList[0].length;i++){
			var tempText = tabList[0][i].split("|");
			if(tempText[0] == "U"){    
				uTab[uCnt++] = tempText[1]; 					
			} 	
			if(tempText[0] == "Z"){  
				zTab[zCnt++] = tempText[1];      		
			}  
			if(tempText[0] == "G"){   
				gTab[gCnt++] = tempText[1];		
			} 	
		}
	}

	/**
	 * 쉬트 콤보 데이티 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj) {
		//쉬트 콤보데이타 조회
		var sCondition = new Array (      
			new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
			new Array("MnrGenCd","CD00013", "COMMON")//,	//Type
		)             
		comboListGrid = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 콤보데이타에 값을 세팅함 
		var sheetComboText = "";  
		var sheetComboCode = "";
		var sheetComboDefault = "";
		//쉬트 콤보 SAVE_NAME
		var comboSaveNames = new Array();
		comboSaveNames[0] = "mnr_rng_tp_cd";  
		comboSaveNames[1] = "vol_tp_cd"; 
		
		for(var i = 0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//쉬트콤보별 초기화
				sheetComboText = "";
				sheetComboCode = "";
				sheetComboCodeText = "";
				sheetComboDefault = ""; 
				   
		 		for(var j = 0; j < comboListGrid[i].length;j++){ 
					var tempText = comboListGrid[i][j].split("|");    
					 
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){
						sheetComboDefault = tempText[0];      	
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
	        sheetComboText = sheetComboText.substr(0, sheetComboText.length - 1);	
		}
		if (sheetComboCode != "") {
	        sheetComboCode = sheetComboCode.substr(0, sheetComboCode.length - 1);
		}
		//모든 쉬트를 초기화 	 
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll(); 
        }
	}

	/**
	 * 조회후 4개의 탭중 값이 존재하는 탭을 선택하여 보여줌
	 * @return
	 */
	function setTabSelect(){
		for (var i=1; i<=4; i++) {
			var rowCnt = sheetObjects[i].RowCount;
			if(rowCnt>0) {
				tabObjects[0].SelectedIndex = (i-1);
				return;
			}
		}
	}    
	
/* 개발자 작업	*/		