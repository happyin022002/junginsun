/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0047.jsp
*@FileTitle : RDR Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.21
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2010.03.03 임옥영
* 1.0 Creation
* ---------------------------------------------------------------
* History
* 2013.11.21 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
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
     * @class VOP_OPF_0047 : VOP_OPF_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0047() {
    	this.processButtonClick = tprocessButtonClick;
    	this.setSheetObject = setSheetObject;
    	this.loadPage = loadPage;
    	this.initSheet = initSheet;
    	this.initControl = initControl;
    	this.doActionIBSheet = doActionIBSheet;
    	this.setTabObject = setTabObject;
    	this.validateForm = validateForm;
    }
    
    /* 개발자 작업	*/

  //공통전역변수
  var sheetObjects = new Array();
  var sheetCnt = 0;
  
  var comboObjects = new Array();
  var comboCnt = 0;
  
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  //버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  function processButtonClick() {
  	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  	var sheetObj = sheetObjects[0];

  	/*******************************************************/
  	var formObj = document.form;

  	try {
  		var srcName = window.event.srcElement.getAttribute("name");
  		switch (srcName) {

  			case "btn_retrieve":
  				doActionIBSheet(sheetObj, formObj, IBSEARCH);
  				break;
  			case "btn_new":
  				doActionIBSheet(sheetObj, formObj, IBCLEAR);
              	break;
  			case "btn_downexcel":
  				var skipCols = "ibflag|vsl_cd|voy_no|dir_cd|vps_dt";
  				sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", true, skipCols, "", false, false, "");
  				break;
  	
  			case "btns_slan":
  				ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+formObj.slan_cd.value, 420, 480, "slan_cd_pop_event", "0,0", true);
  				break;
  				
  	        case "btns_period": // From 달력버튼
  	        	var cal = new ComCalendarFromTo();
  	        	cal.endFunction = "cal_end_func";
  	        	cal.select(formObj.fr_dt, formObj.to_dt, 'yyyy-MM-dd');
  	            break;
  	            
            case "vsl_cd_pop":
        		var sUrl = "";
            	var vsl_cd = formObj.vsl_cd.value;     	
            	if(isNull(vsl_cd)){
            		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
            		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
            	}else{            		
            		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
            		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
            		setRegion();
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
   * Calendar From To 선택 후 호출하는 함수
   */
  function cal_end_func(){
  	sheetObjects[0].RemoveAll();
  }

  /**
   * slan_cd Data PopUp Value 입력 함수.
   */
  function slan_cd_pop_event(aryPopupData) {
  	document.form.slan_cd.value = aryPopupData[0][1];
  	document.form.slan_nm.value = aryPopupData[0][2];
  }
  /**
 	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
 	 * @param {arry} rtnObjs
 	 */
 	function setCallBackVSL(aryPopupData) {
		document.form.vsl_cd.value = aryPopupData[0][1];
		//ComSetFocus(document.form.voy_no);
		document.form.voy_no.focus();
 	} 
 	
  /**
 	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
 	 * @param {arry} obj
 	 */
 	function setCallBackVVD(aryPopupData) {
		document.form.voy_no.value = aryPopupData[0][2];
		document.form.dir_cd.value = aryPopupData[0][3];
		//ComSetFocus(document.form.region);
//		document.form.region.focus();
 	}

    function setRegion(){
    	var formObj = document.form;
    	sheetObjects[0].WaitImageVisible = false;
    	
		formObj.f_cmd.value = SEARCH01;
		var comboXml = sheetObjects[0].GetSearchXml("VOP_OPF_0047GS.do" , FormQueryString(formObj));
		// Region Combo Data Set..
    	var regionList = ComGetEtcData(comboXml, "regionList");
    	if(regionList==null || regionList.length<1){	

    	}else{
    		comboObjects[0].Enable = true;
    		setComboItem2(comboObjects[0], regionList);
    		dataList = regionList.split("|");
    		if(dataList.length == 1){
    			formObj.region.Index = 0;
    		}
    	}
		
//	    // Region Combo의 값이 단건일 경우 자동 조회
//	    if(regionList != null && regionList.length >= 1){
//	    	if(dataList.length == 1){
//	    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
//	    	}
//	    }
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
  
  /**
   * Combo 기본 설정
   * Combo의 항목을 설정한다.
   */
  function initCombo(comboObj) {
  	with(comboObj) {
  		switch(id) {
	    		case "region":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|120")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2,0);
	            	//MaxLength = 5;
		            break;
		    }
  		}
	}

  /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
  function loadPage() {
  	for (i = 0; i < sheetObjects.length; i++) {
  		ComConfigSheet(sheetObjects[i]);
  		initSheet(sheetObjects[i], i + 1);
  		ComEndConfigSheet(sheetObjects[i]);
  	}

	//Combo 초기화
 	for(var m=0; m<comboObjects.length; m++){
     	initCombo(comboObjects[m]);
    }
	var formObj = document.form;
    formObj.fr_dt.value = frDt;
    formObj.to_dt.value = toDt;
    setRegion();
  	initControl();
  	document.form.vsl_cd.focus();
  	
  	}
  /**
  * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  * @param {ibsheet} sheetObj    IBSheet Object
  * @param {int}     sheetNo     sheetObjects 배열에서 순번
  **/
  function initControl() {
  	//** Date 구분자 **/
  	DATE_SEPARATOR = "-";
  	var formObj = document.form;
  	
   //Axon 이벤트 처리1. 이벤트catch
  	axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
  	axon_event.addListenerFormat('beforeactivate'  	, 'obj_activate'  	, formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
  	axon_event.addListenerFormat('blur',     'blur_event',     formObj);
   	//Code 입력 시 영문대문자만 or 숫자만 입력하기
 	axon_event.addListener('keypress', 'obj_keypress', 'vsl_cd'	, 'voy_no', 'dir_cd', 'fr_week_no', 'to_week_no', 'fr_dt', 'to_dt' );
 	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'voy_no', 'dir_cd', 'slan_cd');
 	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 	axon_event.addListener('change' , 'change_event', 'vsl_cd' , 'voy_no', 'slan_cd');
 	axon_event.addListener('blur'  , 'blur_event', 'dir_cd');
 	axon_event.addListener('focus' , 'focus_event', 'vsl_cd', 'voy_no', 'dir_cd');
  	
  }

  /**
   * OnBlur
   */
  function obj_deactivate(){
  	ComChkObjValid(event.srcElement, false);
  }

	
  /**
  * OnFocus
  */
  function obj_activate(){
  	ComClearSeparator(event.srcElement);
	var srcName = event.srcElement.name;
	switch(srcName){
		case "vsl_cd":
		case "voy_no":
		case "dir_cd":
		case "fr_dt":
		case "to_dt":
		case "fr_week_no":
		case "to_week_no":
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			event.srcElement.select();
			break;
	}
	
  }

  /**
   * OnKeyPress
   */
  function obj_keypress(){
  	var src = window.event.srcElement.getAttribute("name");
  	var formObj = document.form;

  	if (src == "slan_cd"){
  		ComKeyOnlyAlphabet('uppernum');        
  	} else if (src == "fr_week_no" || src == "to_week_no"){
  		ComKeyOnlyNumber(this, '');
  		formObj.fr_dt.value = "";
  		formObj.to_dt.value = "";
  		
  	} else if (src == "fr_dt" || src == "to_dt"){  		
  		ComKeyOnlyNumber(this, '');
  		formObj.fr_week_no.value = "";
  		formObj.to_week_no.value = "";
  		
  	} else if(event.srcElement.name=="vsl_cd"){
    	//문자/숫자만 입력가능.
    	 ComKeyOnlyAlphabet('uppernum');
     }else if(event.srcElement.name=="voy_no"){
    	//숫자만 입력가능.
      	ComKeyOnlyNumber(event.srcElement);
     } else{
    	//영대문자만 입력가능.
      	ComKeyOnlyAlphabet('upper');
     } 
  	
  	ComKeyEnter();
  }

  /**
  * Form KeyUp
  */
  function obj_keyup(){
	ComKeyEnter('lengthnextfocus');
  	obj = event.srcElement;
  	var formObj = document.form;

  	switch (obj.name) {
  	case "slan_cd":
  		if (formObj.slan_cd.value.length == 0) {
  			sheetObjects[0].RemoveAll();
  	        formObj.slan_nm.value="";
  			
  		}else if (formObj.slan_cd.value.length == 3) {
  			slan_cd_keyup();
  		}
  		break;
	  case 'vsl_cd':
	      var objMaxLength = obj.getAttribute("maxLength");
	
	      if (ComChkLen(obj.value, objMaxLength) == 2) {
	          ComSetNextFocus(obj);
	      }

	      ComClearObject(formObj.voy_no);
	      ComClearObject(formObj.dir_cd);
	      
	      formObj.region.Code2 = "";
	      
	      break;
	      
	case 'voy_no':
	      var objMaxLength = obj.getAttribute("maxLength");
	      if (ComChkLen(obj.value, objMaxLength) == 2) {
	          ComSetNextFocus(obj);
	      }
	      ComClearObject(formObj.dir_cd);
	      ComClearObject(formObj.slan_cd);
	      ComClearObject(formObj.slan_nm);
	      formObj.region.Code2 = "";
	      
	      break;
	      
	case 'dir_cd':
	      formObj.region.Code2 = "";
	      ComClearObject(formObj.slan_cd);
	      ComClearObject(formObj.slan_nm);
	      break;

	}
	// Focus 이동..
	ComKeyEnter('LengthNextFocus');
  }
  
    /**
     * HTML Control의 onfocus이벤트에서 블럭설정. <br>
     **/
    function focus_event(){
 
        event.srcElement.select();
    }
    
    /**
     * HTML Control의 change이벤트에서 특정 폼 reset설정. <br>
     **/
    function change_event(){   	
    	var elementObj = event.srcElement;
    	var formObj = document.form; 
    	   	
    	if(elementObj.name=="vsl_cd"){
    		formObj.voy_no.value = "";
    		formObj.dir_cd.value = "";
    		formObj.vsl_eng_nm.value = "";
    		setRegion();
    	} else if(elementObj.name == "voy_no")      {
    		formObj.dir_cd.value = "";
    		setRegion();
        } else if(elementObj.name == "slan_cd") {
        	formObj.slan_nm.value = "";
        	if(formObj.slan_cd.value.length==3) slan_cd_keyup();
    		
        }

    }
     
    /**
     * HTML Control의 blur이벤트에서 특정 폼 Validation 체크. <br>
     **/
    function blur_event(){
    	var elementObj = event.srcElement;
    	var formObj = document.form; 
    	
		
		switch(elementObj.name){
		case "dir_cd":
		case "fr_dt": 
		case "to_dt":
		case "fr_week_no":
		case "to_week_no":
			ComChkObjValid(elementObj);
			break;
		}
		
    	
    	if(elementObj.name=="dir_cd" 
    		&& !isNull(formObj.vsl_cd.value)
    		&& !isNull(formObj.voy_no.value)
    		&& !isNull(formObj.dir_cd.value))    	{
    		sheetObjects[0].WaitImageVisible = false;
		
			formObj.f_cmd.value = SEARCH06;
			formObj.skd_voy_no.value = formObj.voy_no.value;
			formObj.skd_dir_cd.value = formObj.dir_cd.value;
			
			var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));
			var vvdData = ComOpfXml2Array(sXml, "vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
			if(vvdData == null) {
				ComShowCodeMessage("COM132201", "Data");
				formObj.vsl_cd.value = "";
				formObj.vsl_eng_nm.value = "";
        		formObj.voy_no.value = "";
        		formObj.dir_cd.value = "";
                formObj.region.Code2 = "";
                formObj.slan_cd.value = "";
                formObj.slan_nm.value = "";               
                
        		formObj.vsl_cd.focus();
        		return false;
			} else {
				if(vvdData.length > 1) {
	    			ComShowCodeMessage("COM132201", "Data");
					formObj.vsl_cd.value = "";
					formObj.vsl_eng_nm.value = "";
					formObj.voy_no.value = "";
					formObj.dir_cd.value = "";
                    formObj.region.Code2 = "";
                    formObj.slan_cd.value = "";
                    formObj.slan_nm.value = "";

					formObj.vsl_cd.focus();
					return false;
				} else {
					setRegion();
					var dt = vvdData[0];
                    if(vvdData[0].length>3) formObj.vsl_eng_nm.value = vvdData[0][3];
                    if(vvdData[0].length>4) formObj.slan_cd.value = vvdData[0][4];
                    if(vvdData[0].length>5) formObj.slan_nm.value = vvdData[0][5];
                    formObj.region.focus();
					return true;
				}
			}
    	}
    }

    
    
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 420;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(3, 1, 10, 100);

				var HeadTitle1  = "|WEEK|REGION|LANE||||VVD|OPERATOR|ALLOCATION|ALLOCATION|HC/45' Adjustment|HC/45' Adjustment|HC/45' Adjustment|HC/45' Adjustment|HC/45' Adjustment|HC/45' Adjustment|Void|POL|POD||Full|Full|Full|Full|Full|Full|Full|Empty|Empty|Empty|Empty|Empty|Empty|Empty|Total TEU\n(Full)|Total TEU\n(Empty)|Dead Slot\n(TEU)|Grand Total\n(TEU)|Total\nWeight";
				var HeadTitle2  = "|WEEK|REGION|LANE||||VVD|OPERATOR|TEU|TON|20 HC|20 HC|40 HC|40 HC|45|45|(AK/BB)|POL|POD||20|2H|40|4H|45|Sub TTL|Weight\n(tons)|20|2H|40|4H|45|Sub TTL\n|Weight\n(tons)|Total TEU\n(Full)|Total TEU\n(Empty)|Dead Slot\n(TEU)|Grand Total\n(TEU)|Total\nWeight";
				var HeadTitle3  = "|WEEK|REGION|LANE||||VVD|OPERATOR|TEU|TON|BSA\n(T)|Add\nSlot\n(T)|BSA\n(F)|Add\nSlot\n(T)|BSA\n(F)|Add\nSlot\n(T)|Add\nSlot\n (T)|POL|POD||20|2H|40|4H|45|Sub TTL|Weight\n(tons)|20|2H|40|4H|45|Sub TTL\n|Weight\n(tons)|Total TEU\n(Full)|Total TEU\n(Empty)|Dead Slot\n(TEU)|Grand Total\n(TEU)|Total\nWeight";
				
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1 , true);
				InitHeadRow(1, HeadTitle2 , true);
				InitHeadRow(2, HeadTitle3 , true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, false,	"ibflag");
				InitDataProperty(0, cnt++, dtData    ,  		60, daCenter, true,	"week_no",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		60, daCenter, true,	"region",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		60, daCenter, true,	"lane",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtHidden ,  		60, daCenter, true,	"vsl_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtHidden ,  		60, daCenter, true,	"voy_no",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtHidden ,  		60, daCenter, true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0, cnt++, dtData    ,  		80, daCenter, true,	"vvd",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		70, daCenter, true,	"opr_cd",	false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0, cnt++, dtData    ,  		75, daRight, true,	"tot_alloc",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		75, daRight, true,	"tot_wgt",	false,	"",	dfNumber,	0,	false,	false);
				
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"hc20_qty",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"add_20",	false,	"",	dfNumber,	0,	false,	false);
				
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"hc40_qty",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"add_40",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"bsa_45",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"add_45",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"add_akbb",	false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daCenter, true,	"pol",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daCenter, true,	"pod",			false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0, cnt++, dtHidden ,  		50, daCenter, true,	"vps_dt",	false,	"",	dfNone,	0,	false,	false);
//				InitDataProperty(0, cnt++, dtHidden ,  		50, daCenter, true,	"week_no",	false,	"",	dfNone,	0,	false,	false);
	
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"f_20",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"f_2h",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"f_40",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"f_4h",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"f_45",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		60, daRight, true,	"f_qty",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		80, daRight, true,	"f_weight",	false,	"",	dfNumber,	0,	false,	false);
				
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_20",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_2h",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_40",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_4h",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_45",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_qty",		false,	"",	dfNumber,	0,	false,	false);
				InitDataProperty(0, cnt++, dtData    ,  		50, daRight, true,	"e_weight",	false,	"",	dfNumber,	0,	false,	false)
				InitDataProperty(0, cnt++, dtData    ,  		70, daRight, true,	"f_total_teu",	false,	"",	dfNumber,	0,	false,	false)
				InitDataProperty(0, cnt++, dtData    ,  		70, daRight, true,	"e_total_teu",	false,	"",	dfNumber,	0,	false,	false)
				InitDataProperty(0, cnt++, dtData    ,  		70, daRight, true,	"dead_slot",	false,	"",	dfNumber,	0,	false,	false)
				InitDataProperty(0, cnt++, dtData    ,  		80, daRight, true,	"grand_total",	false,	"",	dfNumber,	0,	false,	false)
				InitDataProperty(0, cnt++, dtData    ,  		5, daRight, true,	"t_weight",	false,	"",	dfNumber,	0,	false,	false)
				
				WaitImageVisible=false;
			}
			break;
		}
	}

	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		if (validateForm(sheetObj, formObj, sAction)) {
			switch (sAction) {
				case IBSEARCH: //조회
					formObj.f_cmd.value = SEARCH;
					sheetObjects[0].WaitImageVisible=false;
					sheetObj.Redraw = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0047GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml,false);
					ComOpenWait(false);
					sheetObj.Redraw = true;
					break;
				case IBCLEAR:
					formObj.reset();
		 			sheetObj.RemoveAll();
//	                ComClearObject(formObj.vsl_cd);
//	                ComClearObject(formObj.voy_no);
//	                ComClearObject(formObj.dir_cd);
//	                ComClearObject(formObj.vsl_nm);
//	                ComClearObject(formObj.fr_week_no);
//	                ComClearObject(formObj.to_week_no);
	                formObj.fr_dt.value = frDt;
	                formObj.to_dt.value = toDt;
	                setRegion();
	              	document.form.vsl_cd.focus();
	              	break;
			}
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var rt = true;
		switch (sAction) {
			case IBSEARCH: //조회
				
				var fdt = formObj.fr_dt.value;
				var tdt = formObj.to_dt.value;	
				var fwk = formObj.fr_week_no.value;
				var twk = formObj.to_week_no.value;
				if(isNull(formObj.vsl_cd.value) && isNull(formObj.slan_cd.value) && formObj.region.Index < 0){
					ComShowCodeMessage("OPF50009", "VVD, Region or Lane");
					formObj.vsl_cd.focus();
					rt =  false;
				} else if(isNull(fwk) && isNull(twk) && isNull(fdt) && isNull(tdt)){		
					ComShowCodeMessage("OPF50009", "Week or Duration");
					formObj.fr_week_no.focus();
					rt =  false;
				} else if(!isNull(fwk) && !isNull(twk)){
					if((parseInt(ComTrimAll(twk, "-")) - parseInt(ComTrimAll(fwk, "-"))) < 0){
						ComShowCodeMessage("OPF50040");
						formObj.to_week_no.value = "";
						formObj.to_week_no.focus();
						rt =  false;
					} else if((parseInt(ComTrimAll(twk, "-")) - parseInt(ComTrimAll(fwk, "-"))) > 15) {
						ComShowCodeMessage("OPF50022", "Week", "15 Weeks");
						formObj.to_week_no.value = "";
						formObj.to_week_no.focus();
						rt =  false;
					}
				} else if(!isNull(fdt) && !isNull(tdt)){
					if((parseInt(ComTrimAll(tdt, "-")) - parseInt(ComTrimAll(fdt, "-"))) < 0){
						ComShowCodeMessage("OPF50039");
						formObj.to_dt.value = "";
						formObj.to_dt.focus();
						rt =  false;
					} else if(ComGetDaysBetween(tdt, ComGetDateAdd(fdt, "M", 3, ""))<0){
						ComShowCodeMessage("OPF50022", "Duration", "3 Months");
						formObj.fr_dt.focus();
						rt =  false;
					}
				} else if(isNull(fwk) && !isNull(twk)) {
					ComShowCodeMessage("OPF50009", "Week");
					formObj.fr_week_no.focus();
					rt =  false;
				} else if(!isNull(fwk) && isNull(twk)){
					ComShowCodeMessage("OPF50009", "Week");
					formObj.to_week_no.focus();
					rt =  false;
				} else if(isNull(fdt) && !isNull(tdt)) {//from이 없는 경우
					ComShowCodeMessage("OPF50009", "Duration");
					formObj.fr_dt.focus();
					rt =  false;
				} else if(!isNull(fdt) && isNull(tdt)){//to가 없는 경우
					ComShowCodeMessage("OPF50009", "Duration");
					formObj.to_dt.focus();
					rt =  false;
				} 
			break;
		}
		return rt;
	}

	/**
	 * 조회가 끝난 다음
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			if(RowCount > 0) {
				if(!document.form.gubun[1].checked) { 
					ColHidden(prefix+"vvd_cd") = false;
					for(var i = HeaderRows ; i <= LastRow ; i++) {
						if(CellValue(i, prefix+"slan_cd") == "S.Avg") {
							CellFont("FontBold", i, prefix+"slan_cd") = true;
							CellAlign(i, prefix+"slan_cd") = daLeft;
							for(var j = SaveNameCol(prefix+"slan_cd") ; j <= LastCol ; j++) {
								CellBackColor(i, j) = RgbColor(232, 231, 236);
							}
						}
					}
				}else {
					ColHidden(prefix+"vvd_cd") = true;
				}
			}
		}
	}
	
    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
    	}
    	if(dataList.length>1 && isNull(comboObj.GetText(0, 0))) {
    		comboObj.InsertItem(0, '', '');
    	}

    }
    
    /**
     * LANE COde Key-In시 3자리 완료했을 때 호출하는 함수
     */
    function slan_cd_keyup(){
    	var formObj = document.form;
    	sheetObjects[0].WaitImageVisible=false;

    	formObj.f_cmd.value = COMMAND12;
    	var lanXml = sheetObjects[0].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
    	
    	var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");

    	if(ComTrim(strLanCdDesc) == ""){
    		ComAlertFocus(formObj.slan_cd, ComGetMsg("OPF50004", "'Lane Code'"));
    		formObj.slan_cd.value = "";
    		formObj.slan_nm.value = "";
    	}else{
    		formObj.slan_nm.value = strLanCdDesc;
    		ComKeyEnter('lengthnextfocus');
    	}	
    }
 	/* 개발자 작업  끝 */