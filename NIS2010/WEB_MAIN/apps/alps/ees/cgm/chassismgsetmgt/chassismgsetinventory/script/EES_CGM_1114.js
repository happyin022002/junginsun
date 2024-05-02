/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cgm_1114.js
 *@FileTitle : Factor Adjustment by Location
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.27
 *@LastModifier : 조재성
 *@LastVersion : 1.0
 * 2009.08.27 조재성
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
 * @class ees_cgm_1114 : ees_cgm_1114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1114() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * @param 없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */ 
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
                	if(validateForm(sheetObject,formObject,IBSEARCH) != false){
                		sheetObject.RemoveAll();
                		doActionIBSheet(sheetObject, formObject, IBSEARCH);
                	}
			break;

        case "btn_New":
	        initControl();
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;
			
		case "btns_scc_cd":
	                var tmp = "SCC";
	            	if(tmp == "RCC"){
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);
	            	} else if(tmp == "LCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);	            		
	            	} else if(tmp == "SCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocationSCC", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocationSCC", "0,1,1,1,1,1,1", true, false);	            		
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
 * IBSheet Object를 배열로 등록 <br>
 * @param  {object} sheet_obj	필수
 * @return 없음
 * @author 조재성
 * @version 2009.08.24
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        // 시작 환경 설정 함수 이름 변경
    	ComConfigSheet (sheetObjects[i] );
    	initSheet(sheetObjects[i],i+1);
        // 마지막 환경 설정 함수 추가
    	ComEndConfigSheet(sheetObjects[i]);
    }
}

/**
 * Sheet 로딩 후 기본 설정 및 초기화 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.10.20
 */     
    function sheet1_OnLoadFinish(sheetObj) {
        var formObject = document.form;    	
        sheetObj.WaitImageVisible = false;
	 
      	// axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change' , 'scc_cd'); 
        axon_event.addListener('keyup', 'enterFire', 'scc_cd');
        axon_event.addListenerForm('keyup', 'obj_keyup', form);
        axon_event.addListenerForm('focusout', 'obj_focusout',form);
        
        initControl();
        
        sheetObj.WaitImageVisible = true; 
    }

/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function initControl(){
    var formObj = document.form;
    var sheetObj1 = sheetObjects[0];

    //Form Object 초기화
    with(formObj){
    	scc_cd.value = "";
    	
    	// MultiCombo 초기화
    	for(var i=0; i<comboObjects.length; i++){
    		comboObjects[i].Text2 = "";
    	}
    }
	// Sheet Object 초기화
	sheetObj1.RemoveAll();

	// 초기값 설정
	
	newCreate();
	
}


/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 조재성
 * @version 2009.08.24	
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    var sheetID = sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 462;
                //전체 너비 설정
                SheetWidth = 200;

                //Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle = "|ESP Calculator Factor|20'|40'|45'|R5|scc_cd|esp_adj_knd_cd";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                InitDataProperty(0,	cnt++,	dtData,			250,	daLeft,		true,	"esp_calc_factor",		false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daRight,	true,	"cntr_20ft_adj_val",	false,	"",	dfFloat,	2,	true,	false,	5);
                InitDataProperty(0,	cnt++,	dtData,			100,	daRight,	true,	"cntr_40ft_adj_val",	false,	"",	dfFloat,	2,	true,	false,	5);
                InitDataProperty(0,	cnt++,	dtData,			100,	daRight,	true,	"cntr_45ft_adj_val",	false,	"",	dfFloat,	2,	true,	false,	5);

                InitDataProperty(0,	cnt++,	dtData,			80,		daRight,	true,	"cntr_r5_adj_val",		false,	"",	dfFloat,	2,	true,	false,	5);
                InitDataProperty(0,	cnt++,	dtHidden,		100,	daCenter,	true,	"scc_cd",				false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		true,	"esp_adj_knd_cd",		false,	"",	dfNone,		0,	false,	false);

                EditableColorDiff = false;
            }
            //값 입력 조건 제한(음수, 소숫점, 숫자)
            //sheetObj.InitDataValid(0, "cntr_20ft_adj_val", vtNumericOther, "-.");
            //sheetObj.InitDataValid(0, "cntr_40ft_adj_val", vtNumericOther, "-.");
            //sheetObj.InitDataValid(0, "cntr_45ft_adj_val", vtNumericOther, "-.");
            //sheetObj.InitDataValid(0, "cntr_r5_adj_val",   vtNumericOther, "-.");
            
            //mySheet.InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], 
            //                          [DataFormat], [PointCount], [EditLen])  

            break;
    }
}

/**
 * Sheet관련 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: // 조회
		    if(validateForm(sheetObj,formObj,sAction))
		    {
                //ComShowCodeMessage("CGM20031");
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1114GS.do" , FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
		    }
		break;

       	case IBSAVE: //저장
 			formObj.f_cmd.value = MULTI;
       	
 			if(sheetObj.DoSave("EES_CGM_1114GS.do", FormQueryString(formObj)))
 			{
 				ComShowCodeMessage("CGM00003"); 
 			}
            break;

        case IBSEARCH_ASYNC09:
    	    //formObj.f_cmd.value = SEARCH;
    	    //formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
    	    //var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value = SEARCH17;
	    	formObj.eq_orz_cht_chktype.value = "SCC";
	    	formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
    	    // 데이터 건수
    	    var dataCount = ComGetTotalRows(sXml);
    	    if(dataCount==0){
    	        ComShowCodeMessage('CGM10009','location cd');
    	        sheetObj.removeAll();
    	        formObj.scc_cd.value = "";
    	        // chungpa 20100414 keyup->focusout start	
    	        formObj.scc_cd.focus();
        	    // chungpa 20100414 keyup->focusout end    	        
    	    }
    	    // chungpa 20100414 keyup->focusout start	
	        //formObj.scc_cd.focus();
    	    // chungpa 20100414 keyup->focusout end	
    	    break;	
        case IBSEARCH_ASYNC10: // no popup for Enter Key
    	    //formObj.f_cmd.value = SEARCH;
    	    //formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
    	    //var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value = SEARCH17;
	    	formObj.eq_orz_cht_chktype.value = "SCC";
	    	formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
    	    // 데이터 건수
    	    var dataCount = ComGetTotalRows(sXml);
    	    if(dataCount==0){
    	    	sheetObj.removeAll();
    	    	formObj.scc_cd.value = "";
    	    	formObj.scc_cd.focus();
    	    }
    	    break;	    	    

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {object} formObj	필수 Form Object
 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
 * @author 조재성
 * @version 2009.07.21
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
    		switch(sAction){
    			case IBSEARCH:
    				if(scc_cd.value == ''){
    					ComShowCodeMessage('CGM10004','Location');
    					scc_cd.focus();
    					return false;
    				}else if(scc_cd.value.length != 5){
    						ComShowCodeMessage('CGM10044','SCC(5)');
    						scc_cd.focus();
    						return false;
    				}
                    break;
                }
	}
	return true;
}

/**
 * 콜백 함수. <br>
 * @param  {Array} aryPopupData	필수	 Array Object
 * @param  {Int} row				필수 선택한 Row
 * @param  {Int} col				필수 선택한 Column
 * @param  {Int} sheetIdx			필수 Sheet Index
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */   
function callBackLocationSCC(aryPopupData, row, col, sheetIdx){
     	 
    var formObj = document.form;
    var location = "SCC";
    var crntLocCd = "";
    var i = 0;
    
    for(i = 0; i < aryPopupData.length; i++){
    	if(location == 'RCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][11];
    	} else if(location == 'LCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][10];
    	} else if(location == 'SCC'){
    		crntLocCd = crntLocCd + aryPopupData[i][8];
    	}
     		
    	if(i < aryPopupData.length - 1){
    		crntLocCd = crntLocCd + ",";
     	}
    }
     	 
    formObj.scc_cd.value = crntLocCd;
     	 
}

/** 
 * Object 의 activate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
} 

/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */
function obj_deactivate(){
	var formObj = document.form;
 	obj = event.srcElement;

 	//if(obj.name=="disp_fm_dys"  ){
 }	

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */ 
function obj_keypress(){
   	obj = event.srcElement;
   	if(obj.dataformat == null) return;
   	 	
   	window.defaultStatus = obj.dataformat;
   	 
   	switch(obj.dataformat) {
   	 	case "ym": case "ymd":
 		ComKeyOnlyNumber(obj);
 		break;
 	case "int":
 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
 		else ComKeyOnlyNumber(obj);
        break;
 	case "float":
        ComKeyOnlyNumber(obj, "-.");
        break;    
    case "eng":
    	if(obj.name=="vndr_seq") 
    		ComKeyOnlyNumber(obj,",");
    	else 
    		ComKeyOnlyAlphabet();
        break;
    case "engup":
        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
        else ComKeyOnlyAlphabet('upper');
        break;
    case "engdn":
        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
        else ComKeyOnlyAlphabet('lower');
   	        break;
   	}
} 

/** 
 * Object 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.27
 */  
function obj_change(){
    var formObj = document.form;
 	var sheetObj = sheetObjects[0]; 
 	obj = event.srcElement;
 	switch(obj.name){
	 	case "scc_cd":
	 		break;
    }   
}

 /** 
  * Object 의 obj_focusout 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2010.04.14
  */  
 function obj_focusout(){
 	 var formObj = document.form;
 	 var sheetObj = sheetObjects[0];
 	 obj = event.srcElement;
 	 
  	 switch(obj.name)
  	 { 
 	    	// chungpa 20100414 keyup->focusout start	  	 		 
		 	case "scc_cd":
			    var scc_cd;
			    scc_cd = formObj.scc_cd.value;
		    	if (scc_cd.length == 5) {
		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC09);
		    		if (scc_cd.length == 5) {
		    			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    		}
		    	}
		    	break;	 	

		    // chungpa 20100414 keyup->focusout end
  	 }
    
 }
 
/**
 * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
 * @author 조재성 / update select sheet 1
 * @version 2009.08.13
 */   
var sheet1_click_val = "";
function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    var sheetObj2 = sheetObjects[1];
  	var formObject = document.form;
  	
  	sheet1_click_val = sheetObj.CellValue(Row,Col);
  	//sheetObj.SelectCell(Row, Col);
	//alert("sheet1_OnClick>>>>" + Row + " : "+ Col);
  	//alert(sheet1_click_val);
	
 }
 
/**
 * Sheet1 의 cell을 edit 할 경우 <br>
 * @author 조재성
 * @version 2009.08.12
 */   
function sheet1_OnChange(sheetObj, Row, Col)
{
    var formObject = document.form;
    
    /* chungpa 20091026 모든 grid 에 계산 로직 삭제. 모두 수기 입력 처리
    with(sheetObj)
    {
		//alert("OnChange>>>>"+ Row + ":"+ Col + ": "+ RowCount + "CURR:"+ CellValue(Row,Col)+ "  Before:"+sheet1_click_val);
		if(CellValue(Row,Col) == '')
		{
			CellValue2(Row,Col) = sheet1_click_val;
			return;
		}
		
		switch (Row) {
			case 1:
			case 2:
			case 3:
			case 4:
				CellValue2(Row,Col) = parseFloat(CellValue(Row,Col))+ parseFloat(sheet1_click_val);
			break;
			
			case 5:
			case 6:
			case 7:
			case 8:
				if(sheet1_click_val == '0') // 0이면 곱연산이 항상 안먹기 때문에, 입력값을 최초 한번 받아준다. 
				{
					CellValue2(Row,Col) = returnFloat(parseFloat(CellValue(Row,Col)));
				}else
				{
					CellValue2(Row,Col) = returnFloat(parseFloat(CellValue(Row,Col)) * parseFloat(sheet1_click_val));
				}
			break;
		}
    }
    */
    
    /* 
     * chungpa 20091026 factor 4개 칼럼들은, max 100 까지만 입력되도록 수정
     */
    with(sheetObj)
    {
		switch (Row) {
			case 1:
			case 2:
			case 3:
			case 4:
			break;
			
			case 5:
			case 6:
			case 7:
			case 8:
				CellValue2(Row,Col) = Math.abs(CellValue(Row,Col))
				if(parseFloat(CellValue(Row,Col)) > 100)
				{
					CellValue2(Row,Col) = 100;
				}
			break;
		}
    }
}  
 /**
  * float값을 유효숫자(2자리)만큼 잘라내는 함수
  * @param	{text}	sVal	필수		숫자 텍스트 데이터
  * @return	{float} rVal			변환된 float데이터 
  * @authro 조재성 
  * @version 20090827
  */
function returnFloat(sVal)
{
	var comp;
 	/* 바로 float값이 들어오기 때문에 텍스트 처리하지 않는다. 
 	if(strAllTrim(sVal)=="")
 		comp=0;
 	else
 		comp=parseFloat(sVal);
		comp = parseInt(comp*100)/100;    		
 	*/
 	comp = parseInt(sVal*100)/100;
    return comp;
}
  
/** 
 * 기본조건 입력 후 ENTER키 적용 <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.08.14
 */ 
   function enterFire() {
	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }else
		   {
			   sheetObj.RemoveAll();
		   }
	   }
	 	 
   }    

/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
	 	case "scc_cd":
			// chungpa 20100414 keyup->focusout start
			ComKeyEnter('lengthnextfocus');  
			
			/*
	 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
	   		if( formObj.scc_cd.value.search(',') > 0 || (formObj.scc_cd.value == '')) // 다중 scc_cd code(,로 연결됨)이면 검사하지 않는다. 
	   		{
	   			break;
	   		}    	 		
	   		var arrCrntLocCd = crntLocCd.split(",");
	   		for(var i = 0; i < arrCrntLocCd.length; i++){
	   		// 입력오류 체크 (예> ,,)
	 			if(arrCrntLocCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Location');
	 				formObj.scc_cd.value = "";
	 				ComSetFocus(formObj.scc_cd);
	 				break;
	 			}else{
	    	 		    //if(formObj.scc_cd.value != ''){
                                    if(formObj.scc_cd.value.length == 5){
	    	 		    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC09);
	    	 		    }
	 			}
	   		}
	   		*/
			// chungpa 20100414 keyup->focusout end
	 		break;
    	 }
}   

/**
 * sheet 초기 폼 생성.
 * @authro 조재성 
 * @version 20090923
 */ 
function newCreate() {
	var sheetObject = sheetObjects[0]; 
	with(sheetObject){
		// 그리드를  데이타 초기화
		RemoveAll();
		
		//8개 행 생성
		for(i=1; i<9; i++){
			DataInsert(-1);
		}
		
		
		/*
		 * 'A', 'Import Turn Time Adjustment'
	                           , 'B', 'Export Turn Time Adjustment'
	                           , 'C', 'Empty Turn Time Adjustment'
	                           , 'D', 'Domestic Turn Time Adjustment'
	                           , 'E', 'Maintenance and Repair Factor'
	                           , 'F', 'Sales Volume Increase Factor'
	                           , 'G', 'Utilization Factor'
	                           , 'H', 'Other Factor'
		 */
		// 생성된 각 행에 명칭 부여
		CellValue2(1, 1) = "Import Turn Time Adjustment (day)";
		CellValue2(2, 1) = "Export Turn Time Adjustment (day)";
		CellValue2(3, 1) = "Empty Turn Time Adjustment (day)";
		CellValue2(4, 1) = "Domestic Turn Time Adjustment (day)";
		CellValue2(5, 1) = "Maintenance and Repair Factor(%)";
		CellValue2(6, 1) = "Sales Volume Increase Factor(%)";
		CellValue2(7, 1) = "Utilization Factor(%)";
		CellValue2(8, 1) = "Other Factor(%)";
		
		// 컬럼 값 셋팅
		for(j=1; j<9; j++){
			for(k=2; k<6; k++){
				CellValue2(j, k) = "0";
			}
		}
		
		// scc_cd 생성
		for(l=1; l<9; l++){
			CellValue(l, "scc_cd") = "";//document.forms[0].scc_cd.value;
		}
		
		// esp_ajd_knd_cd 생성
		CellValue2(1, 7) = "A";
		CellValue2(2, 7) = "B";
		CellValue2(3, 7) = "C";
		CellValue2(4, 7) = "D";
		CellValue2(5, 7) = "E";
		CellValue2(6, 7) = "F";
		CellValue2(7, 7) = "G";
		CellValue2(8, 7) = "H";
		
		// 셀 Editable 시키기. // 로딩한 후에 editing이 가능하다.
		for(m=1; m<9; m++){
			for(n=2; n<6; n++){
				CellEditable(m, n) = false;
			}
		}
	}
}
/* 개발자 작업 끝 */
