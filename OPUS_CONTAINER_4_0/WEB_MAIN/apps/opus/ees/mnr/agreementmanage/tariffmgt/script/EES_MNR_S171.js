/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESS_MNR_S171.js
*@FileTitle  : MNR Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/* 개발자 작업	*/
/* ********* General Functions ************* */
	// 공통전역변수
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
                    doActionIBSheet(sheetObject,document.form,IBSEARCH);
                    break;
				case "btn_New":
                    doActionIBSheet(sheetObject,document.form,IBCLEAR);
                    break;
				//Calendar From PopUP
				case "eff_dt_fr_cal":
					var cal=new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObject.eff_dt_fr, 'yyyy');
	                break;
				//Calendar To PopUP
				case "eff_dt_to_cal":
					var cal=new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObject.eff_dt_to, 'yyyy');
	                break;
            	case "btn_DownExcel":
                    doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
                    break;
            	case "btn_TariffDetailInfo":
				    var selectedRow=sheetObject.GetSelectRow();
					if(selectedRow < 0) {return;}
					var trfNo=sheetObject.GetCellValue(selectedRow, "trf_no");
					var iWidth=1015;
					var iHeight=670;
		            var leftpos=(window.screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
		            var toppos=(window.screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
					ComOpenWindow('/opuscntr/EES_MNR_0215.do?trf_no='+trfNo,  '',"status=no, resizable=yes, scrollbars=no, width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos);
                    break;
			} // end switch
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
		//IBSheet초기화
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+ 1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon이벤트 초기화
		initControl();
		//화면 초기화 이벤트
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
	    	case 2: 
	            with (comboObj) { 
	    		SetColAlign(0, "left");
				   SetDropHeight(160);
		        }
	            break;
	     } 
	}
  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                var HeadTitle1="|Seq.|Tariff No.|Agreement No|EQ Type|Service Provider|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Apro No|Apro User|Apro Date|Request Date|Status|Status Date|Remark(s)";
                var HeadTitle2="|Seq.|Tariff No.|Agreement No|EQ Type|Service Provider|Dry|Reefer Box|Reefer Unit|S/Dry|Chassis|MG Set|Total Ratio|Apro No|Apro User|Apro Date|Request Date|Status|Status Date|Remark(s)";
                var headCount=ComCountHeadTitle(HeadTitle1);
                (headCount+ 1, 0, 0, true);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                    {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trf_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"dry",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"reefer_box",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"reefer_unit",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"special_dry",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"chassis",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"genset",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"total_ratio",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"apro_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Date",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_trf_sts_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSelectionMode(smSelectionRow);
                SetShowButtonImage(2);
                SetSheetHeight(400);
				}
		        break;
        }
    }
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	   // axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); //- 포커스 나갈때
	   // axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); //- 포커스 들어갈때
	   // axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	//- 키입력 할때
    }
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj; 
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
			case "yyyy":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//초기화
			case IBCLEAR:
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
				//쉬트 초기화
	    		sheetObjects[0].RemoveAll();
	        	//조건부 콤보데이타 초기화
				for(var i=0; i < comboObjects.length;i++){
					if(i!=1) {
						comboObjects[i].RemoveAll(); //AGMT Combo 제외
					}
				}
				//Combo 조회
				var sCondition=new Array (
					new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
					new Array("MnrGenCd","SELHO","CUSTOM9")  	//EQ Type
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition); 
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						var cnt=0;
						for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");
							//Status
							if(i==0) {
								if(tempText[0]!="SD" && tempText[0]!="HD") {
									cbTariffStatus.InsertItem(cnt++, tempText[1] ,tempText[0]);
								}  
							//EQ Type
							} else if(i==1) {
								cbEqType.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				cbTariffStatus.InsertItem(0, "ALL" ,"A" );
				cbEqType.InsertItem(0, "ALL" ,"A" );
				//콤보초기값 설정
				cbEqType.SetSelectCode("A");//EQ Type
				cbTariffStatus.SetSelectCode("A");//Tariff Status
				//콤보이외의 값 설정
				formObj.vndr_seq.value=ComLpad(strVndrSeq,6,"0");
				formObj.vndr_nm.value=strVndrNm;
				formObj.eff_dt_to.value=ComGetNowInfo("yy");
				formObj.eff_dt_fr.value=ComGetNowInfo("yy") - 1;
				//초기 포커스
				//document.form.cbEqType.focus();
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			//조회
            case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH;
					//조회조건 설정
					formObj.eq_knd_cd.value=ComGetObjValue(cbEqType);			//EQ Type
					formObj.mnr_trf_sts_cd.value=ComGetObjValue(cbTariffStatus);	//Tariff Status
					//조회
					var sXml=sheetObj.GetSearchData("EES_MNR_S171GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
                break;
            //Down Excel
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
				break;
			default:
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
				//Effective Period
				var effDtFr=formObj.eff_dt_fr.value;
				var effDtTo=formObj.eff_dt_to.value;
				var effDtFrLen=effDtFr.length;
				var effDtToLen=effDtTo.length;
				if((effDtFrLen==0 && effDtToLen!=0) || (effDtFrLen!=0 && effDtToLen==0)) {
					ComShowCodeMessage("MNR00162");
					formObj.eff_dt_fr.focus();
					return false;
				}
				if(effDtTo - effDtFr < 0){
					ComShowCodeMessage("MNR00162");
					formObj.eff_dt_fr.focus();
					return false;
				}
				//조회 의사확인
				if(sheetObjects[0].IsDataModified()) {
					if(!ComShowCodeConfirm("MNR00007")) {return false;}
				}
			} 
        }
        return true;
    }
/* 개발자 작업	*/
