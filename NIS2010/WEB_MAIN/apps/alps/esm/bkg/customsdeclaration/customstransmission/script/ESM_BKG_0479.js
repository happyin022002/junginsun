/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0479.js
 *@FileTitle : ESM_BKG-0479
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.05
 *@LastModifier : 조원주
 *@LastVersion : 1.0
 * 2012.03.05 조원주
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
 * @class ESM_BKG-0479 : ESM_BKG-0479 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0479() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";
var chkFlg ="N";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function skd_delt_flg_cofing(gubun) {
	if(gubun){
		sheetObjects[0].InitDataProperty(0, 15, dtCombo, 70, daCenterTop, true, "skd_delt_flg", 		false, "", dfNone, 0, true, true);
		sheetObjects[0].InitDataCombo(0, "skd_delt_flg",  "Y|N",  "Y|N");
	}else{
		sheetObjects[0].InitDataProperty(0, 15, dtData, 70, daCenterTop, true, "skd_delt_flg", 		false, "", dfNone, 0, false, false);
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

			case "btn_Retrieve":
			
				skd_delt_flg_cofing(false);
			
				chkFlg="Y";
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				ComBtnDisable("btn_Add");
				break;
				
			case "btn_RouteRetrieve":
				
				skd_delt_flg_cofing(false);
				
				chkFlg="N";
				doActionIBSheet(sheetObject1, formObject, SEARCH01);
				ComBtnEnable("btn_Add");
				break;
	
			case "btn_New":
			
				skd_delt_flg_cofing(false);
			
				doActionIBSheet(sheetObject1, formObject, IBCLEAR);
				ComBtnEnable("btn_Add");
				break;
						
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
	
			case "btn_Trans":
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				break;
				
			//case "btn_receive":
				//doActionIBSheet(sheetObject1, formObject, SEARCH02);
				//break;
				

			case "btn_Add":
			
				skd_delt_flg_cofing(false);
			
				ComBtnDisable("btn_Trans");
				//ComBtnEnable("btn_Trans");
				sheetObject1.DataInsert(-1);
				 sheetObject1.CellValue2(sheetObject1.LastRow,"edi_snd_ofc_cd")=formObject.usrOfc.value;
				 sheetObject1.CellValue2(sheetObject1.LastRow,"edi_snd_usr_id")=formObject.usrId.value;
				 //sheetObject1.CellValue2(,"ibflag") = "I";
				 
				 break;

			case "btn_Delete":
				//ComRowHideDelete(sheetObject1,"del_chk");
				for(i=1; i<sheetObjects[0].Rows ; i++) {
					if(sheetObjects[0].CellValue(i,"del_chk")=="1"){
				     // sheetObjects1.CellValue2(i,"ibflag") = "D";
				      sheetObjects[0].RowHidden(i)= true;		//2.행 숨기기
				      sheetObjects[0].RowStatus(i)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
					}
				}
				break;

   	        case "from_Calendar": // From 달력버튼
            	var cal = new ComCalendar();
            	cal.select(formObject.in_bat_skd_prd_fm_dt, 'yyyy-MM-dd');
   	            break;
   	            
   	        case "to_Calendar": // From 달력버튼
            	var cal = new ComCalendar();
            	cal.select(formObject.in_bat_skd_prd_to_dt, 'yyyy-MM-dd');
   	            break;
				
   	        case "from_to_calendar": // From 달력버튼
            	var cal = new ComCalendarFromTo();
            	cal.select(formObject.in_bat_skd_prd_fm_dt, formObject.in_bat_skd_prd_to_dt, 'yyyy-MM-dd');
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
* @param sheet_obj IBSheet Object
*/
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	//formObj.in_vvd_cd.focus();
	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
	ComBtnDisable("btn_Trans");
}

/** 
 * initControl()
 */ 
function initControl() {
	 DATE_SEPARATOR = "-";
	axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
	axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
	axon_event.addListenerForm('deactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('focus', 'obj_activate', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);		
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 */ 
function obj_keypress(){
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    	 	
    window.defaultStatus = obj.dataformat;
    	 
    switch(obj.dataformat) {
		case "uppernum":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "upper":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
        case "ymd":
        	ComKeyOnlyNumber(event.srcElement);
            break;
        case "float":
        	ComKeyOnlyNumber(event.srcElement, ".");
            break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement, ".");
    }
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 */ 
function obj_keyup(){
	obj = event.srcElement;
	var formObj = document.form;
	//VOP_OPF_0063 참조
}     

///**
// * Form 내의 Object Deactivate 이벤트시 처리.
// * 
// * @return void
// */        
//function obj_deactivate(){
//	obj = event.srcElement;
//	var formObj = document.form;
//	//VOP_OPF_0063 참조
//}
 
 	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
    	
	    	case "in_bat_skd_prd_fm_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "in_bat_skd_prd_to_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    		
    		default:
    			break;
    			//ComAddSeparator(event.srcElement);
    			//ComChkObjValid(event.srcElement);
    	}
    }
 

//업무 자바스크립트 OnFocus 이벤트 처리
function obj_activate() {
   	//마스크 구분자 없애기
   	switch(event.srcElement.name){ 	    	
   		case "in_bat_skd_prd_fm_dt":
   			ComClearSeparator(event.srcElement);
   			break;
   		case "in_bat_skd_prd_to_dt":
   			ComClearSeparator(event.srcElement);
   		default:
   			break;
   	}
}

/** 	
 * 업무 자바스크립트 Onblur 이벤트 처리  <br>
 */    
function obj_blur(){
	obj = event.srcElement;
	var formObj = document.form;

	switch(obj.name) {

		case "in_bat_skd_prd_fm_dt":
			if( formObj.in_bat_skd_prd_fm_dt.value != ""){
                if(!ComChkObjValid(obj)){
                	setObjValue("in_bat_skd_prd_fm_dt", "");
                	setFocus("in_bat_skd_prd_fm_dt");
                    return false;
                }
            }
			break;
			
		case "in_bat_skd_prd_to_dt":
			if( formObj.in_bat_skd_prd_to_dt.value != ""){
                if(!ComChkObjValid(obj)){
                	setObjValue("in_bat_skd_prd_to_dt", "");
                	setFocus("in_bat_skd_prd_to_dt");
                    return false;
                }
            }
			break;

	}
}     

/**
 * Get Object Value
 */
function getObjValue(name) {
	return ComGetObjValue(eval("document.form."+name));
}
 
/**
* Set Object Value
*/
function setObjValue(name, value) {
	ComSetObjValue(eval("document.form."+name), value);
}
 
/**
 * Move Focus in Object
 */
function setFocus(name) {
 	ComSetFocus(eval("document.form."+name));
 	eval("document.form."+name).select();
}

 /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 412;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Flag|Seq.|Chk|VVD|Voyage No|POL|CY code|POR|CY code|Othr Ntfy|Create Date|Period|Period|Office|User ID|Delete Flg|Save Flg|vsl_pre_pst_cd|vsl_seq|be_pol_yd_cd|be_por_yd_cd|chk_vsl_flg";
			var HeadTitle2 = "Flag|Seq.|Chk|VVD|Voyage No|POL|CY code|POR|CY code|Othr Ntfy|Create Date|ETA-14\n(YYMMDD)|ETA\n(YYMMDD)|Office|User ID|Delete Flg|Save Flg|vsl_pre_pst_cd|vsl_seq|be_pol_yd_cd|be_por_yd_cd|chk_vsl_flg";
			var headCount = ComCountHeadTitle(HeadTitle2);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "ibflag", false);
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenterTop, true, "seq");
			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "del_chk",	false,		"",  	dfNone,			0,		true,	true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "vvd_cd", 	true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "jp_tml_vsl_no", 	false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 75, daCenterTop, true, "pol_cd", true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtComboEdit, 80, daCenterTop, true, "pol_yd_cd", 		true, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 75, daCenterTop, true, "por_cd", true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtComboEdit, 75, daCenterTop, true, "por_yd_cd", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtComboEdit, 70, daCenterTop, true, "otr_ntfy_yd_cd", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "create_dt", 			false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bat_skd_prd_fm_dt", 			false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "bat_skd_prd_to_dt", 			false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenterTop, true, "edi_snd_ofc_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenterTop, true, "edi_snd_usr_id", 		false, "", dfNone, 0, false, false);
			
			//**중요!!skd_delt_flg 항목 위에 새로운 항목 추가시에 위의 이 함수 "skd_delt_flg_cofing"에 콤보의 칼럼 위치 +1 시켜줄것!!!!!!!!!!!!!!!
			InitDataProperty(0, cnt++, dtData, 70, daCenterTop, true, "skd_delt_flg", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenterTop, true, "save_flg", 		false, "", dfNone, 0, false, false);//dtHidden
			InitDataProperty(0, cnt++, dtHidden, 70, daCenterTop, true, "vsl_pre_pst_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenterTop, true, "vsl_seq", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenterTop, true, "be_pol_yd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenterTop, true, "be_por_yd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenterTop, true, "chk_vsl_flg", 		false, "", dfNone, 0, false, false);
			
			CountPosition = 2;
			InitUserFormat2(0, "bat_skd_prd_fm_dt",  "####-##-##", "-|:");
			InitUserFormat2(0, "bat_skd_prd_to_dt",  "####-##-##", "-|:");
			InitUserFormat2(0, "create_dt",  "####-##-##", "-|:");
			
			InitDataValid(0, "pol_cd", vtEngUpOnly);
			InitDataValid(0, "por_cd", vtEngUpOnly);
			InitDataValid(0, "vvd_cd", vtEngUpOther,"0123456789");
			
			//InitDataCombo(0, "skd_delt_flg",  "Y|N",  "Y|N");
			
			SelectHighLight = false;
			SelectionMode = smSelectionCol;
		}
		break;
	}
}

/**
* Sheet관련 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	
		case IBCREATE:      //콤보 데이터 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0479GS.do", FormQueryString(formObj));
				var arrCombo;
				arrCombo = ComXml2ComboString(sXml,"val","name");
				sheetObj.InitDataCombo(0, "pol_yd_cd", " |"+arrCombo[0], " |"+arrCombo[0]	,"", "", 0);
				sheetObj.InitDataCombo(0, "por_yd_cd", " |"+arrCombo[0], " |"+arrCombo[0],"", "", 0);
				sheetObj.InitDataCombo(0, "otr_ntfy_yd_cd", " |"+arrCombo[0], " |"+arrCombo[0],"", "", 0);
				break;
		
		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				//ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH;
			
	        	//var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0479GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchXml(sXml);
				}
				
				ComOpenWait(false);
			}	
			break;
			
		case SEARCH01:      //BKG Route 조회
		
		if(validateForm(sheetObj,formObj,sAction)){
			//ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH01;
		
        	//var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0479GS.do", sParam);
			if(sXml.length>0){ 
				sheetObj.LoadSearchXml(sXml);
			}
			for(i=1; i<sheetObj.Rows ; i++) {
				sheetObj.CellValue2(i,"ibflag") = "I";
			}
			ComOpenWait(false);
		}	
		break;

		case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = MULTI;
				
				//한진 해운 배이면 VVD에서 Voyage no 가져와 셋팅 
				for(i=1; i<= sheetObjects[0].Rows ; i++) {
				if(sheetObjects[0].CellValue(i,"del_chk") == 1 &&sheetObjects[0].CellValue(i,"jp_tml_vsl_no") == "" && sheetObjects[0].CellValue(i,"chk_vsl_flg")=="Y"){
					sheetObjects[0].CellValue(i,"jp_tml_vsl_no") = sheetObjects[0].CellValue(i,"vvd_cd").substring (4,9);
				}
				}
				
				//chk 된것만 저장 및 업데이트 
				//chk 되고 IBflg가 UP나 Insert인 것들
				var sParamSheet = sheetObjects[0].GetSaveString(false, true, 2	);

		        //var sParamSheet = sheetObjects[0].GetSaveString(true);
				for(i=1; i<sheetObjects[0].Rows ; i++) {
				if(sheetObjects[0].CellValue(i,"por_yd_cd")==null){
					sheetObjects[0].CellValue2(i,"por_yd_cd")=" ";
				}
				}
				
		        var sParam =  FormQueryString(formObj)+ "&" +ComSetPrifix(sParamSheet, "");
		        var sXml = sheetObj.GetSaveXml("ESM_BKG_0479GS.do", sParam);
		        
		        sheetObjects[0].LoadSaveXml(sXml);
				  var resultStr = ComGetEtcData(sXml, "resultStr");
				  var chkVslFlg = ComGetEtcData(sXml, "chkVslFlg");
				  
//				  if(chkVslFlg=="N"){
//				  for(i=1; i<sheetObjects[0].Rows ; i++) {
//				 
//					  if( sheetObjects[0].CellValue(i,"skd_voy_no")== null){
//						  
//						  ComShowCodeMessage("other vsl plz input the voyage no");
//					  return;
//				  }
//				  }
//				  }
				  
				  var flg = ComGetEtcData(sXml, "flg");
				
					if(resultStr=="N"){
						ComShowCodeMessage('BKG00651',"BKG ROUTE");
						return;
					}
					
					//2012.06.20
					if(flg=="Y"){
						ComShowCodeMessage('BKG03056',"Mandantory value(VVD, POL, POL CY, POR, POR CY)");
					   return;
					}
					
					var sav = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			     	   if(sav == "S"  ){
			     		  ComShowCodeMessage("COM130102", "Data");
			     		  if(formObj.in_vvd_cd.value!="" && formObj.in_vvd_cd.value!= null){
			     			  skd_delt_flg_cofing(false);
							  chkFlg="Y";
							  ComBtnDisable("btn_Add");
							  doActionIBSheet(sheetObj, formObj, IBSEARCH);// SKD 재조회
			     		      
			     		  }
			       	   }else{
			        		ComShowCodeMessage("COM132103", "Data");
			        	}
				
				
			}	
			break;
			
		case MULTI01:        //전송
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = MULTI01;
			//sheetObj.DoSave("ESM_BKG_0479GS.do", FormQueryString(formObj), -1, false);
			
			//한진 해운 배이면 VVD에서 Voyage no 가져와 셋팅 
			for(i=1; i<= sheetObjects[0].Rows ; i++) {
			if(sheetObjects[0].CellValue(i,"del_chk") == 1 &&sheetObjects[0].CellValue(i,"jp_tml_vsl_no") == ""&& sheetObjects[0].CellValue(i,"chk_vsl_flg")=="Y"){
				sheetObjects[0].CellValue(i,"jp_tml_vsl_no") = sheetObjects[0].CellValue(i,"vvd_cd").substring (4,9);
			}
			}
			
			for(i=1; i<= sheetObjects[0].Rows ; i++) {
				if(sheetObjects[0].CellValue(i,"del_chk") == 1 && sheetObjects[0].CellValue(i,"skd_delt_flg")=="Y"){
					ComShowCodeMessage("BKG02119", i-1); 
					return;
				}
				}
			
			var sParamSheet = sheetObjects[0].GetSaveString(false, true, 2	);
	        //var sParamSheet = sheetObjects[0].GetSaveString(true);
	        var sParam =  FormQueryString(formObj)+ "&" +ComSetPrifix(sParamSheet, "");
	        var sXml = sheetObj.GetSaveXml("ESM_BKG_0479GS.do", sParam);
	        sheetObjects[0].LoadSaveXml(sXml);
		}	
		break;

		case IBCLEAR:
			formObj.reset();
			sheetObj.RemoveAll();
			formObj.in_vvd_cd.focus();
			break;
			
		//case SEARCH02:
			//formObj.f_cmd.value = SEARCH02;
			//var sParam =  FormQueryString(formObj)+ "&" +ComSetPrifix(sParamSheet, "");
	        //var sXml = sheetObj.GetSaveXml("ESM_BKG_0479GS.do", sParam);
			//break;
	}
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  * @param sheetObj Sheet
  * @param formObj form객체
  * @param sAction 작업처리코드
  */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			
			var fmDtObj = form.in_bat_skd_prd_fm_dt;
	 		var toDtObj = form.in_bat_skd_prd_to_dt;
	 		var fmDtValue = fmDtObj.value.replace(/-/g, "");
	 		var toDtValue = toDtObj.value.replace(/-/g, "");
	 		
//vvd와 period 둘 중에 하나로 검색하기 위한 validation
//			if (formObj.in_bat_skd_prd_fm_dt.value==""&&formObj.in_bat_skd_prd_to_dt.value=="") {
//				if( formObj.in_vvd_cd.value == "" ){
//					ComShowCodeMessage('BKG02111');
//					formObj.in_vvd_cd.focus();
//					return false;
//				}
//			}else {
//				if (formObj.in_bat_skd_prd_fm_dt.value!="" && formObj.in_bat_skd_prd_to_dt.value=="") {
//					ComShowCodeMessage('BKG02111');
//					formObj.in_vvd_cd.focus();
//					return false;
//				}else if (formObj.in_bat_skd_prd_fm_dt.value=="" && formObj.in_bat_skd_prd_to_dt.value!="") {
//					ComShowCodeMessage('BKG02111');
//					formObj.in_vvd_cd.focus();
//					return false;
//				}
//			}
			
			if( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
				 ComShowCodeMessage("BKG95026", "From Date", "To Date");
				 ComSetFocus(fmDtObj);
				 return false;
	 		}
	 		
 			var fromAddDays = ComGetDateAdd(fmDtValue, "D", 364, "", true);
 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
 				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
 				ComSetFocus(fmDtObj);
 				return false;
 			}
 			
 			
 			if( formObj.in_bat_skd_prd_fm_dt.value==""&&formObj.in_bat_skd_prd_to_dt.value==""&&formObj.in_vvd_cd.value == ""&&formObj.in_pol_cd.value == ""&&formObj.in_edi_snd_usr_id.value == "") {
 				ComShowCodeMessage("BKG02113"); // "Please input VVD or POL or Period or User ID."
 				
 				return false;
 			}

			return true;
			break;
			
		case SEARCH01:
			if (formObj.in_vvd_cd.value == ""||formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00754');
				formObj.in_vvd_cd.focus();
				return false;
			}
			if(formObj.in_pol_cd.value == ""){
				ComShowCodeMessage('BKG00209');
				formObj.in_pol_cd.focus();
				return false;
			}
			
			return true;
			break;
			
		case MULTI01:
			//모두 체크가 안되었으면 (0 이면)
			var iCheckRow = sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage('BKG02108');//coBKG 추가   "Please click the Check Box which you want to transmit"
			   return;
			}
			
			//타사 배인 경우 voyage no 항목을 작성하게 한다.
			for(i=2; i<sheetObjects[0].Rows ; i++) {
            if(sheetObjects[0].CellValue(i,"del_chk") == 1 &&sheetObjects[0].CellValue(i,"jp_tml_vsl_no") == "" &&  sheetObjects[0].CellValue(i,"chk_vsl_flg")=="N"){
            	ComShowCodeMessage('BKG02115');// "Please input Voyage number."
        		sheetObjects[0].SelectCell(i,"jp_tml_vsl_no");

        	return;
        	}
			}
			
			return true;
			break;
			
		case IBSAVE:
			//모두 체크가 안되었으면 (0 이면)
			var iCheckRow = sheetObj.CheckedRows("del_chk");
			if(iCheckRow <= 0){
				ComShowCodeMessage('BKG02109');//coBKG 추가   "Please click the Check Box which you want to save"
			   return;
			}


			for(i=2; i<sheetObjects[0].Rows ; i++) {
            if(sheetObjects[0].CellValue(i,"bat_skd_prd_fm_dt") > sheetObjects[0].CellValue(i,"bat_skd_prd_to_dt")){
            	 ComShowCodeMessage(	"BKG95026", "From Date", "To Date");
            	return;
             }
            //타사 배인 경우 voyage no 항목을 작성하게 한다.
            if(sheetObjects[0].CellValue(i,"del_chk") == 1 &&sheetObjects[0].CellValue(i,"jp_tml_vsl_no") == "" &&  sheetObjects[0].CellValue(i,"chk_vsl_flg")=="N"){
            	ComShowCodeMessage('BKG02115');// "Please input Voyage number."
        		sheetObjects[0].SelectCell(i,"jp_tml_vsl_no");

        	return;
        	}
            
			}
			return true;
			break;
	}
}
  
  /**
   * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event 처리 <br>
   * 
   * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
   * @param {string}  ErrMsg   선택,에러 메시지
   * @return 없슴
   */
  function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   if(chkFlg=="Y"){
			for(i=1; i<sheetObjects[0].Rows ; i++) {
		    	
				//if (sheetObjects[0].CellValue(i,"save_flg")=="Y") {
		    		ComBtnEnable("btn_Trans");
		    		 //sheet1_OnClick(sheetObj, nRow, sheetObj.SaveNameCol("radio"), 1); 	 
		        //}
	         }
	  }else{
		  ComBtnDisable("btn_Trans");
	  }
	   
	   for(i=1; i<sheetObjects[0].Rows ; i++) {
			if(sheetObj.CellValue(i, "skd_delt_flg") == "Y") {
				sheetObj.RowBackColor(i) =  sheetObj.RgbColor(255,192,192);
			}	
		}
	   
	   for(i=1; i<sheetObjects[0].Rows ; i++) {
			if(sheetObj.CellValue(i, "chk_vsl_flg") == "Y" && sheetObj.CellValue(i, "jp_tml_vsl_no") == "") {
				sheetObjects[0].CellValue(i,"jp_tml_vsl_no") = sheetObjects[0].CellValue(i,"vvd_cd").substring (4,9);
			}	
		}
	   
	   }     
	   
	  
	  
	  /** 
       * sheet1 search end 시 호출되는 이벤트핸들러 <br>
       * <br><b>Example :</b>
       * <pre>
       * </pre>
       * @param  {IBSheet} sheetObj : 시트오브젝트  
       * @param  {String} ErrMsg 
       * @see #
       * @author 이승준
       * @version 2009.10.16
       */
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
     
	    		var formObj = document.form;
	    		
//	 	 		var startRow1 = sheet1.HeaderRows;
//	 			var endRow1 = sheet1.HeaderRows + sheet1.RowCount;
	    		
	 			for(i=1; i<sheetObjects[0].Rows ; i++) {
	 	 			if(sheetObj.CellValue(i, "skd_delt_flg") == "Y") {
	 	 				sheetObj.RowBackColor(i) =  sheetObj.RgbColor(255,192,192);
	 	 			}	
	 	 		}
	 			 doActionIBSheet(sheetObj, formObj, IBSEARCH);
 
				
	 			
  	}
	  
   /*
   **
   * Sheet관련 컬럼 onClick 엑션 이벤트 처리 
   */
 /* function sheet1_OnClick(sheetObject, Row, Col, Value) {
  	//var target_cntr = sheetObject.CellValue(Row, "c_cntr_no");
//  	var colName = sheetObj.ColSaveName(Col);
//	if (colName == "check"){
  	var cnt = sheet1.RowCount;
  	for (var ix = 1; ix <= cnt; ix++) {
  		if (sheet1.RowStatus(ix) == 'D') {
  		} else if (sheet1.CellValue(ix, "cntr_no") == target_cntr) {
  			sheet1.RowHidden(ix) = false;
  		} else {
  			sheet1.CheckAll2("check") = 0;
  			sheet1.RowHidden(ix) = true;
  		}
  	}
  }*/
/* 개발자 작업 끝 */