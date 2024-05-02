/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0023.js
 *@FileTitle : [CPS_CNI_0023] Prevention
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0023] Prevention
 * @extends
 * @class Prevention 대상 검색 및 금액 입력화면
 */
function cps_cni_0023() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}



// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;


// html form
var frm = null;
// Main Code Inquiry 팝업 타입
var type = "";

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


/*
 * IBCombo Object를 배열에 등록
 * @param comboObj
 */
function setComboObject(comboObj){
	comboObjects[comboCnt++] = comboObj;
}  
// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage(year) {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
    
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //Form 이벤트 등록
    initControl();
    
    var sXml = frm.sXml.value;
	setComboBox(frm.clm_prve_div_cd , sXml ,"G");
	
	
	var clmPrveNo = frm.clm_prve_no.value;
	ComBtnDisable("btn1_File_Upload");	
	if (!ComIsNull(clmPrveNo)) {
		doActionIBSheet(SEARCHLIST01);		
	} 
	
	var usrId = frm.usr_id.value;
	setRollBtnCtlPrevention(usrId, "btn1_save,btn1_File_Upload");
	
	//초기 focus();
	frm.clm_prve_div_cd.focus();
	
}


/**
* Form 이벤트 등록
*/
function initControl() {
	
	axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
	axon_event.addListener('keyup', 'keypressClmPrveNo', 'clm_prve_no');
	axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}


/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
**/
function initCombo(comboObj) {
	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
		//comboObj.LineColor = "#ffffff";
		comboObj.BackColor = "#CCFFFD"; 
	}
	  
} 



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
    	    //Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		     break;
		}
	}
}



  
// ===================================================================================
// Private function
// ===================================================================================


// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "btn1_Retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);			
			}
			break;
		case "btn1_save":
			if (ComChkValid(frm)) {
				if (ComIsNull(frm.clm_prve_no.value)) {
					doActionIBSheet(ADD);
				} else {
					doActionIBSheet(MODIFY);
				}							
			}
			break;
		case "btn1_close":
			self.close();
			break;
		case "btn1_File_Upload":
			var clmPrveNo = frm.clm_prve_no.value;
			if (!ComIsNull(clmPrveNo)) {
				popupFileUpload("002301",clmPrveNo);
			} 
			break;
		case "btn1_Print":
			var clmPrveNo = frm.clm_prve_no.value;
			if (!ComIsNull(clmPrveNo)) {
				doActionIBSheet(PRINT);
			} 
			break;			
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		ComResetAll();
	    		frm.clm_prve_div_cd.value = "G";
	    		frm.clm_prve_no.value = "";
	    		frm.clm_prve_div_cd.focus();
	    	}	    	
	    	
	        break;				
	}

}


/**
 * HTML Control KeyPress 이벤트 호출
 */
function keypressClmPrveNo() {
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "clm_prve_no":
    	if (obj.value.length == 10) {
    		//doActionIBSheet(SEARCHLIST01);
    		focusOut();
    	}
    	break;
	}
}
  
  
  
//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj = event.srcElement;
   if(obj.dataformat == null) return;
   window.defaultStatus = obj.dataformat;
   switch(obj.name) {
       case "clm_prve_no":
       	ComKeyOnlyAlphabet('uppernum');
    	break;          	
            
   }
}
  
  /**
   * HTML Control Foucs in
   */
  function obj_activate(){
      ComClearSeparator(event.srcElement);    
  }
  
  /**
   * HTML Control Focus out
   **/
  function obj_deactivate() {
  	switch (event.srcElement.name) {  	  		
  	case "eff_dt":  		
  		ComChkObjValid(event.srcElement);
  		break;
  	}
  }  
  
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value = SEARCHLIST01;
		var sXml = sheet1.GetSearchXml("CPS_CNI_0023GS.do", FormQueryString(frm));
		
		var list = SheetXml2ListMap(sXml);
		
		if (list.length > 0) {
			var vo = list[0];
			
			frm.clm_prve_no.value = vo["clm_prve_no"];
			frm.clm_prve_div_cd.value = vo["clm_prve_div_cd"];			
			var effDt = vo["eff_dt"];
			frm.eff_dt.value = fmDate(vo["eff_dt"]);
			
			
			var expDt = vo["exp_dt"];			
			var effYyyy = effDt.substring(0,4);
			var expYyyy = expDt.substring(0,4);
			
			var diff = parseInt(expYyyy , 10) -  parseInt(effYyyy , 10) ;
			
			if (diff == 1) {
				frm.exp_dt.value = "1";
			} else if(diff == 3) {
				frm.exp_dt.value = "3";
			} else if(diff == 5) {
				frm.exp_dt.value = "5";
			} else if(diff == 10) {
				frm.exp_dt.value = "10";
			} else {
				frm.exp_dt.value = "P";
			}
			
			
			
			
			frm.cre_ofc_cd.value           = vo["cre_ofc_cd"];
			frm.clm_prve_subj_nm.value     = vo["clm_prve_subj_nm"];
			frm.clm_prve_desc.value        = vo["clm_prve_desc"];			
			frm.cre_usr_id.value           = vo["cre_usr_id"];			
			frm.clm_area_cd.value          = vo["clm_area_cd"];
			
			
		}
			
		var clmPrveNo = frm.clm_prve_no.value;
		
		if (!ComIsNull(clmPrveNo)) {
			ComBtnEnable("btn1_File_Upload");
		} else {
			ComBtnDisable("btn1_File_Upload");
		}
		
	} else if (sAction == ADD) {
		
		frm.f_cmd.value = ADD;
		
				
		var sXml = sheet1.GetSearchXml("CPS_CNI_0023GS.do", FormQueryString(frm));
		
		sheet1.LoadSearchXml(sXml);
		
		var clmPrveNo = ComGetEtcData( sXml, "clm_prve_no");
		
		frm.clm_prve_no.value = clmPrveNo;
		
		doActionIBSheet(SEARCHLIST01);
		
	} else if (sAction == MODIFY) {
		
		frm.f_cmd.value = MODIFY;
		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0023GS.do", FormQueryString(frm));
		
		sheet1.LoadSearchXml(sXml);
		
		doActionIBSheet(SEARCHLIST01);
		
	} else if (sAction == PRINT) {		
		frm.f_cmd.value = PRINT;		
		
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0093.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]";
		var rpaper = "/rpaper [A4]";
		
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		
		var rv =  "";
		frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value = "Prevention-Print";		
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaim/prevention/report/CPS_CNI_0093.mrd";
		//var feature = "resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	} 
}

