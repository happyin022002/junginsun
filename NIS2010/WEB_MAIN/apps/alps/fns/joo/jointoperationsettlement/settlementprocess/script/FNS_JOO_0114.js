/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0114.js
 *@FileTitle : -	Multi Creation & Change  PopUp
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.22
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2016.01.22 민정호
 * 1.0 Creation
 * -----------------------------------------------------------
 * History
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
 * @class FNS_JOO_0114 : FNS_JOO_0114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0114() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject        	= setSheetObject;
    this.loadPage              		= loadPage;
    this.initSheet             		= initSheet;        
	this.initControl 					= initControl;        
    this.doActionIBSheet       	= doActionIBSheet;
    this.validateForm				= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gRefresh = true;

var prefix="";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_close":
				window.close();
				break;
				
            case "btn_new":
            	comboObjects[0].Index2 = -1;
            	comboObjects[1].Index2 = -1;
            	comboObjects[2].Index2 = -1;
            	            
            	var formObject = document.form;            	
            	formObject.reset();
            	sheetObjects[0].RemoveAll();
            	
                break;
				
			case "btn_save":				
                doActionIBSheet(sheetObjects[0],formObj, IBSAVE);				
				break;				
				
			case "btn_target":	
				fnTaget(sheetObjects[0],formObj, IBSAVE);
				break;				

			case "btn_downexcel":
    			sheetObj.Down2Excel(-1);				
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
 function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
 }    
 
 function sheet1_OnLoadFinish(sheetObj) {
     doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
     document.form.rlane_cd.focus();
 }     
 
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
    // IBMultiCombo초기화
    for(var k=0; k<comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }   	
    
	var arr1d = gTrdLaneCrr.split("|");
	gTrdLaneCrrArr = arr1d;
	for (var i=0; i< arr1d.length; i++){
		var arr2d = arr1d[i];
		gTrdLaneCrrArr[i] = arr2d.split(",");
	}
	
	initControl();     
}

/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 * @param comboObj
 * @param comboIndex Number
 */
 function initCombo(comboObj, comboNo ) {

	 var formObj = document.form;
	 
    switch(comboObj.id) {
		case "re_divr_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 7;
		}
		var comboItems = "Rev,R|Exp,E";
		UF_addComboItem(comboObj, comboItems.split("|"));
//		comboObj.Text2 = "ALL";
		break;
		
//	case "jo_crr_cd":
//		with (comboObj) {
//			MultiSelect = false;
//			UseAutoComplete = true;
//			SetColAlign("left");
//			SetColWidth("30");
//			DropHeight = 160;
//			ValidChar(2, 0);//영문대문자만 입력가능
//			MaxLength = 3;
//		}
//		var comboItems = ("ALL, |"+gCrrCd+"|HJS,HJS").split("|");
//		UF_addComboItem(comboObj, comboItems);			
//		comboObj.Text2 = "ALL";
//		break;

	case "trd_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = (gTrdCd).split("|");
		UF_addComboItem(comboObj, comboItems);
//		comboObj.Text2 = "ALL";
		break;

	case "rlane_cd":
		with (comboObj) {
			MultiSelect = true;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("50");
			DropHeight = 160;
			ValidChar(2, 1);//영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
			
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH16;
		sheetObj.WaitImageVisible = false;
//		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1="+formObj.jo_crr_cd.Code);
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1=");		
        ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
//        comboObj.InsertItem(0, "ALL", " ");
//        comboObj.Index2 = 0;			
		break;		
    }
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
 	//** Date 구분자 **/
 	DATE_SEPARATOR = "-";
 	var formObj = document.form;
 	
	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate'    ,  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'      ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress'        , 'obj_keypress'      , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup'           , 'obj_keyup'         ,  formObj);
	axon_event.addListenerFormat('click'           , 'obj_onclick'       , 	formObj);
	axon_event.addListenerForm("Click","obj_Click", document.form);
	
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'          , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'         , formObj);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress'        , 'obj_keypress'      , formObj);
	 
	axon_event.addListenerForm  ('keydown'         , 'ComKeyEnter'       , formObj);
	axon_event.addListenerForm  ('keyup'           , 'fnObjKeyUp'        , formObj );
	axon_event.addListenerForm  ('keypress'        , 'fnObjKeyPress'     , formObj );
	
    axon_event.addListener      ('click',   'fnChkClick', "all_flg");	
 }
 
 //Axon 이벤트 처리2. 이벤트처리함수          
 function obj_deactivate() {
 	ComChkObjValid(event.srcElement);    	
 }
 
 function obj_activate() {	 
 	ComClearSeparator(event.srcElement);    	
 }
 
 function obj_keypress(){
 }
 
 function obj_keyup() {	 
 	ComKeyEnter('lengthnextfocus');
 }

 function fnChkClick(){
	var strAll1 = "";
	var strAll2 = "";
  	  	
	comboObjects[2].Index2 = -1;
	
	if (document.form.all_flg.checked){	  	 
		 	strAll1 = comboObjects[2].GetIndexText(0,0);
			for(var i=1; i<comboObjects[2].GetCount(); i++){
				strAll2 = strAll2 + "," +comboObjects[2].GetIndexText(i,0); 					
			}
			strRlaneList  = strAll1 + strAll2;				
			comboObjects[2].Code2 = strRlaneList;					  	 
	}  	
 }
 
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 300;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "STS|Seq.|Trade|Lane|Carrier|Rev/Exp|Settlement Item|Office|PIC";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus      ,30, daCenter,  true, prefix+"ibflag"  );			
			InitDataProperty(0, cnt++, dtHidden        , 60,   daCenter, true, prefix + "seq" 	    		, false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix + "trd_cd" 			, true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix + "rlane_cd"     	, true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix + "crr_cd"    		, true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix + "re_divr_cd"  	, true, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtHidden     , 150, daCenter, true, prefix + "jo_stl_itm_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden     , 150, daCenter, true, prefix + "ofc_cd"  		, false, "", dfNone, 0, false, true);			
			InitDataProperty(0, cnt++, dtData        , 200, daCenter, true, prefix + "pic" 				, false, "", dfNone, 0, true, true);	

			CountPosition = 0;

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {
        case IBSEARCH:      //조회
            if (!validateForm(sheetObj,formObj,sAction)) {
                return;
            }            
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0113GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml, false); //Append X			
			break;

        case IBSAVE:        //저장
            if(!validateForm(sheetObj,formObj,sAction)){ return;}
            
            fnTaget(sheetObj, formObj, sAction);
            
/*            
			var arrCrrCd = new Array();																	
			var crrCd1 = formObj.crr_cd1.value;
			var crrCd2 = formObj.crr_cd2.value;
			var crrCd3 = formObj.crr_cd3.value;
			var crrCd4 = formObj.crr_cd4.value;
			var crrCd5 = formObj.crr_cd5.value;
			var crrCd6 = formObj.crr_cd6.value;
			var crrCd7 = formObj.crr_cd7.value;
			
            if (crrCd1.length == 3){ 
            	arrCrrCd.push(crrCd1);
            }
            if (crrCd2.length == 3){ 
            	arrCrrCd.push(crrCd2);
            }
            if (crrCd3.length == 3){ 
            	arrCrrCd.push(crrCd3);
            }
            if (crrCd4.length == 3){ 
            	arrCrrCd.push(crrCd4);
            }
            if (crrCd5.length == 3){ 
            	arrCrrCd.push(crrCd5);
            }
            if (crrCd6.length == 3){ 
            	arrCrrCd.push(crrCd6);
            }
            if (crrCd7.length == 3){ 
            	arrCrrCd.push(crrCd7);
            }
			    			    					
			var strRlaneList = comboObjects[2].Code;				
			var w = 0;
			var i = 0;
			var lane = "";
			
            var comboList = strRlaneList.split(',');				
			var laneLength = comboList.length;
			var crrLength = arrCrrCd.length;
			var k = 0;
            
			sheetObjects[0].RemoveAll();
			
			for (w=0; w<laneLength*crrLength; w++) {                
    			sheetObjects[0].DataInsert(-1);
    			
    			lane = comboList[parseInt(w/crrLength)];	    			
    			k = parseInt(w%crrLength);	    			
    			crr = arrCrrCd[k];
    			
				sheetObjects[0].CellValue2(w+1,"trd_cd") = comboObjects[1].Code; 
				sheetObjects[0].CellValue2(w+1,"rlane_cd") = lane;
				sheetObjects[0].CellValue2(w+1,"crr_cd") = crr;
				sheetObjects[0].CellValue2(w+1,"re_divr_cd") = comboObjects[0].Code;
				sheetObjects[0].CellValue2(w+1,"pic") =	 formObj.pic.value;
            }												
*/            
            if( !ComShowCodeConfirm("JOO00046") ){
                return false;
            }			
			
            sheetObj.WaitImageVisible=false;
            ComOpenWait(true);
            formObj.f_cmd.value = MULTI;
            try{                        	
                var sXml =   sheetObj.GetSaveXml("FNS_JOO_0114GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj));
               	sheetObj.LoadSaveXml( sXml );
            }finally{
            	ComOpenWait(false);
            }
            break;				
    }
}


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         switch(sAction){
                 case IBSEARCH:
                     break;
                 case IBSAVE:                                    	 
                    if(comboObjects[0].Text == ''){
    	    			ComShowCodeMessage('JOO00115','Rev/Exp');
    	    			return false;    	    			
                    }
                    if(comboObjects[1].Text == ''){
    	    			ComShowCodeMessage('JOO00115','Trade');
    	    			return false;    	    			
                    }
                    if(comboObjects[2].Text == ''){
                    	if (!document.form.all_flg.checked){
                    		ComShowCodeMessage('JOO00115','Lane');
                    		return false;
                    	}
                    }     				
     				
     				var arrCrrCd = new Array();																	
    				var crrCd1 = formObj.crr_cd1.value;
    				var crrCd2 = formObj.crr_cd2.value;
    				var crrCd3 = formObj.crr_cd3.value;
    				var crrCd4 = formObj.crr_cd4.value;
    				var crrCd5 = formObj.crr_cd5.value;
    				var crrCd6 = formObj.crr_cd6.value;
    				var crrCd7 = formObj.crr_cd7.value;
    				
    	            if (crrCd1.length == 3){ 
    	            	arrCrrCd.push(crrCd1);
    	            }
    	            if (crrCd2.length == 3){ 
    	            	arrCrrCd.push(crrCd2);
    	            }
    	            if (crrCd3.length == 3){ 
    	            	arrCrrCd.push(crrCd3);
    	            }
    	            if (crrCd4.length == 3){ 
    	            	arrCrrCd.push(crrCd4);
    	            }
    	            if (crrCd5.length == 3){ 
    	            	arrCrrCd.push(crrCd5);
    	            }
    	            if (crrCd6.length == 3){ 
    	            	arrCrrCd.push(crrCd6);
    	            }
    	            if (crrCd7.length == 3){ 
    	            	arrCrrCd.push(crrCd7);
    	            }
    				
    	            if(arrCrrCd.length < 1){
    					ComShowCodeMessage('JOO00116','Carrier');
    					return false;					
    	            }
    				
    	    		if (formObj.pic.value == null || formObj.pic.value == ""){	    			
    	    			ComShowCodeMessage('JOO00116','Pic');
    	    			return false;
    	    		}                                                            
                    break; 
                     
         }
         return true;
     }
                         
     /**
      * NEW 버튼 처리 
      * @param    void
      * @return   void
      */
     function UF_reset() {
     	var formObj = document.form;
     	    	
     	sheetObjects[0].RemoveAll();
     	comboObjects[0].Index2 = 0;
     	comboObjects[1].Index2 = 0;
     	comboObjects[2].Index2 = 0;
     }         
     
     /**
      * 화면 Reset
      */      
     function reset_all(){	 
     	var formObject = document.form;
 		formObject.sheet1.RemoveEtcData();
 		formObject.sheet1.RemoveAll();	
     }         
          
  	//TRADE 변경시 LANE 변경
  	function trd_cd_OnChange(comboObj, Code, Text){
  		var formObj = document.form;
  		formObj.rlane_cd.Index2 = -1;
  		formObj.rlane_cd.RemoveAll();
  		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[2] ,"rlane_cd");
  		formObj.trd_cd.focus(); 	
  	}          
  	
	//조회조건필드인 Lane SVC Type 데이터 조회
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
	    sheetObj.ShowDebugMsg = false;	
	    switch(sAction) {	
	       case IBSEARCH: //TRADE
				if (sComboObj.id == "trd_cd"){
					//콤보필드를 초기화시킨다.
					sComboObj.RemoveAll();
					formObj.f_cmd.value = SEARCH15;
					sheetObj.WaitImageVisible = false;
//					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.jo_crr_cd.Code+"&super_cd2=");
					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1=&super_cd2=");					
	                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
//					sComboObj.InsertItem(0, "ALL", " ");
//					sComboObj.Index2 = 0;
	    	   }else if (sComboObj.id == "rlane_cd") {
					//콤보필드를 초기화시킨다.
					sComboObj.RemoveAll();
								
					formObj.f_cmd.value = SEARCH16;
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1=");
					var comboItems = (ComGetEtcData(sXml, "rlane_cd")).split("|");
					addComboItem(comboObjects[2],comboItems);
//					sComboObj.Index2 = 0;
				}
				break;
	    }
	} 	  	
	
	// 저장 대상 생성
	function fnTaget(sheetObj, formObj, sAction){				
        if(!validateForm(sheetObj,formObj,sAction)){ return;}
        
		var arrCrrCd = new Array();																	
		var crrCd1 = formObj.crr_cd1.value;
		var crrCd2 = formObj.crr_cd2.value;
		var crrCd3 = formObj.crr_cd3.value;
		var crrCd4 = formObj.crr_cd4.value;
		var crrCd5 = formObj.crr_cd5.value;
		var crrCd6 = formObj.crr_cd6.value;
		var crrCd7 = formObj.crr_cd7.value;
		
        if (crrCd1.length == 3){ 
        	arrCrrCd.push(crrCd1);
        }
        if (crrCd2.length == 3){ 
        	arrCrrCd.push(crrCd2);
        }
        if (crrCd3.length == 3){ 
        	arrCrrCd.push(crrCd3);
        }
        if (crrCd4.length == 3){ 
        	arrCrrCd.push(crrCd4);
        }
        if (crrCd5.length == 3){ 
        	arrCrrCd.push(crrCd5);
        }
        if (crrCd6.length == 3){ 
        	arrCrrCd.push(crrCd6);
        }
        if (crrCd7.length == 3){ 
        	arrCrrCd.push(crrCd7);
        }
		    			    					
		var strRlaneList = comboObjects[2].Code;
		var w = 0;
		var i = 0;
		var lane = "";
		
        var comboList = strRlaneList.split(',');				
		var laneLength = comboList.length;
		var crrLength = arrCrrCd.length;
		var k = 0;
        
		sheetObjects[0].RemoveAll();
		
		for (w=0; w<laneLength*crrLength; w++) {                
			sheetObjects[0].DataInsert(-1);
			
			lane = comboList[parseInt(w/crrLength)];	    			
			k = parseInt(w%crrLength);	    			
			crr = arrCrrCd[k];
			
			sheetObjects[0].CellValue2(w+1,"trd_cd") = comboObjects[1].Code; 
			sheetObjects[0].CellValue2(w+1,"rlane_cd") = lane;
			sheetObjects[0].CellValue2(w+1,"crr_cd") = crr;
			sheetObjects[0].CellValue2(w+1,"re_divr_cd") = comboObjects[0].Code;
			sheetObjects[0].CellValue2(w+1,"pic") =	 formObj.pic.value;
        }														
	}
	
/* 개발자 작업  끝 */