/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EES_LSE_0107.js
 *@FileTitle : EQ interchange Request
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.12
 *@LastModifier : 길정권
 *@LastVersion : 1.0
 * 2015.05.12 길정권
 * 1.0 Creation
 * 
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
     * @class EES_LSE_0107 : EES_LSE_0107 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0107() {
    	this.processButtonClick = processButtonClick;
    	this.setSheetObject     = setSheetObject;
    	this.setComboObject     = setComboObject;
    	this.loadPage           = loadPage;
    	this.initSheet          = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet    = doActionIBSheet;
    	this.setTabObject       = setTabObject;
    	this.validateForm       = validateForm;
    	this.obj_change         = obj_change;
    	this.obj_keypress       = obj_keypress;
    	this.validateForm       = validateForm;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo1_OnBlur 			= combo1_OnBlur;
    	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
    }

    /* 개발자 작업	*/
  //공통전역변수
  var sheetObjects = new Array();
  var sheetCnt = 0;

  //Combo Object Array
  var comboObjects = new Array();
  var comboCnt = 0;

  var comboPosition  = "";

  //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  function initControl() {
  	var formObj = document.form;
  	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
  	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
  	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
  	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
  	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
  	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
  }

  // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  function processButtonClick(){
  	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  	var sheetObject1 = sheetObjects[0];
  	/*******************************************************/
  	var formObject = document.form;

  	try {
  		var srcObj  = window.event.srcElement;
  		var srcName = window.event.srcElement.getAttribute("name");

  		switch(srcName) {

  		case "btn_Retrieve":
  			if ( srcObj.style.filter == "" ) {
  				sheetObject1.RemoveAll();
  				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			}
  			break;
  		case "btn_Save":
  			if ( srcObj.style.filter == "" ) {
  			    doActionIBSheet(sheetObjects[0], document.form,IBSAVE);
  			}
			ComBtnEnable("btn_Retrieve");
			
  			break;
  		case "btn_New":
  			sheetObject1.RemoveAll();
  			formObject.lstm_cd[0].selected = true;

  			formObject.reset();
  			
			formObject.combo_req_no.value = "";

			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
		        comboObjects[0].CheckIndex(i)=false;
			}
			comboObjects[0].CheckIndex(0) = true;
			comboObjects[1].RemoveAll(); 
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_Retrieve");
			
			ComEnableObject(formObject.lstm_cd, true);
			ComEnableObject(formObject.vndr_seq, true);
			ComEnableObject(formObject.loc_fm, true);
			ComEnableObject(formObject.btns_search3, true);
			ComEnableObject(formObject.btns_search2, true);
			ComEnableObject(formObject.loc_grp, true);
			
			formObject.lstm_cd.className = "input1";
			formObject.vndr_seq.className = "input1";
			formObject.loc_fm.className = "input1";
  			break;
		case "btn_Add":
			var tpsz_arr = formObject.tpsz_cd.value.split(",");
			if(formObject.loc_to.value == ""){
				ComShowCodeMessage("LSE01046");
				ComSetFocus(formObject.loc_to);
				break;
			}
			if(formObject.tpsz_cd.value == ""){
				ComShowCodeMessage("LSE01015");
				ComSetFocus(formObject.tpsz_cd);
				break;
			}
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Retrieve");
			ComEnableObject(formObject.lstm_cd, true);
			ComEnableObject(formObject.vndr_seq, true);
			ComEnableObject(formObject.loc_fm, true);
			ComEnableObject(formObject.btns_search3, true);
			ComEnableObject(formObject.btns_search2, true);
			//comboObjects[1].RemoveAll();
            creation_check = "";
			
			if(sheetObject1.RowCount > 0){
				if(sheetObject1.CellValue(1,"lstm_cd") != ""){

					
					for(var i=0; i<=sheetObject1.RowCount; i++){
						if(formObject.loc_to.value == sheetObject1.CellText(i, "loc_to")){
							for(var j=0; j<tpsz_arr.length; j++){
								if(tpsz_arr[j].split(",") == sheetObject1.CellText(i, "tpsz_cd")){
									creation_check = "Y";
								}
							}
						}
					}
					
					
					if (creation_check == "Y"){
						//if(ComShowConfirm("Are you want to delete all and add a new Data?")) {
						if(ComShowConfirm("You should try to create duplication record. Will You go on ?")) {
							sheetObject1.RemoveAll();
						}else{
							//for(var i = 1 ; i <= sheetObject1.RowCount; i++ ){
							//if(sheetObject1.CellValue(i,"lstm_cd")=="") sheetObject1.RowDelete(i, false);
							//if(sheetObject1.CellValue(1,"lstm_cd")=="") sheetObject1.RemoveAll();
							//}
							formObject.loc_grp[2].selected = true;
							formObject.loc_to.value = "";
													
				            for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
						        comboObjects[0].CheckIndex(i)=false;
							}
							comboObjects[0].Text ="";
							ComBtnDisable("btn_Save");
							ComBtnEnable("btn_Retrieve");
							break;
						}
					}
				
				
				}else{
					if(sheetObject1.CellValue(1,"lstm_cd")=="") sheetObject1.RemoveAll();
				}
			}
			
			if ( ComIsBtnEnable(srcName) ) {
	  			//sheetObject1.RemoveAll();
					for(var i=0; i<tpsz_arr.length; i++){
						var rowIdx = sheetObject1.DataInsert(-1);
						//sheetObject1.CellComboItem(rowIdx, "vndr_seq", " ", " ");
						sheetObject1.CellValue(rowIdx, "vndr_seq")			= formObject.vndr_seq.value;
						sheetObject1.CellValue(rowIdx, "vndr_abbr_nm")		= formObject.vndr_nm.value;
						sheetObject1.CellValue(rowIdx, "loc_fm")			= formObject.loc_fm.value;
						sheetObject1.CellValue(rowIdx, "loc_to")			= formObject.loc_to.value;
						sheetObject1.CellValue(rowIdx, "tpsz_cd")			= tpsz_arr[i].split(",");
						sheetObject1.CellValue(rowIdx, "loc_grp")			= formObject.loc_grp.value;
						sheetObject1.CellValue(rowIdx, "lstm_cd")			= formObject.lstm_cd.value;
						
			  	    	if(formObject.loc_grp.value == "ECC"){
			  	    		sheetObject1.CellEditable(rowIdx, "del_cost") = true;
			  	    		sheetObject1.CellEditable(rowIdx, "sbi_cost") = true;
			  	    	}else{
			  	    		sheetObject1.CellEditable(rowIdx, "del_cost") = true;
			  	    		sheetObject1.CellEditable(rowIdx, "sbi_cost") = true;
			  	    	}
			  	    	sheetObject1.WaitImageVisible = false;
						var param = "f_cmd="+SEARCH02+"&loc_fm="+formObject.loc_fm.value+"&loc_to="+formObject.loc_to.value+"&lstm_cd="+formObject.lstm_cd.value+"&tpsz_cd="+tpsz_arr[i].split(",") +"&loc_grp="+formObject.loc_grp.value;
						var sXml = sheetObject1.GetSearchXml("EES_LSE_0107GS3.do", param);
						sheetObject1.WaitImageVisible = true;
						if ( sXml != "" ) {
							if(formObject.lstm_cd.value == "OF"){
								sheetObject1.CellValue(rowIdx,  "por_cost")	= ComGetEtcData(sXml, "por_cost");
								sheetObject1.CellValue(rowIdx,  "del_cost")	= ComGetEtcData(sXml, "del_cost");
				  	    	}else{
				  	    		sheetObject1.CellValue(rowIdx,   "sbo_cost") = ComGetEtcData(sXml, "sbo_cost");
				  	    		sheetObject1.CellValue(rowIdx,   "sbi_cost") = ComGetEtcData(sXml, "sbi_cost");
				  	    	}
						}
						
		  	    	}
					ComEnableObject(formObject.lstm_cd, false);
					ComEnableObject(formObject.vndr_seq, false);
					ComEnableObject(formObject.loc_fm, false);
					ComEnableObject(formObject.btns_search3, false);
					ComEnableObject(formObject.btns_search2, false);
					ComEnableObject(formObject.loc_grp, false);
				
			}
			break;

		case "btn_Delete":
			if ( ComIsBtnEnable(srcName) ) {
				ComRowHideDelete(sheetObject1, "del_chk");
			} else {
				ComSetFocus(formObj.lstm_cd);
			}
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC02);
			break;

  		case "btns_search2":     // lessor
  			if ( srcObj.style.filter == "" ) {
  				openPopup("2");
  			}
  			break;
  		case "btns_search3":     // Location
  			if ( srcObj.style.filter == "" ) {
  				openPopup("3");
  			}
  			break;
  		case "btns_search4":     // Location
  			if ( srcObj.style.filter == "" ) {
  				openPopup("4");
  			}
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

  /**
  * IBMultiCombo Object를 배열로 등록
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

  		//khlee-시작 환경 설정 함수 이름 변경
  		ComConfigSheet (sheetObjects[i] );

  		initSheet(sheetObjects[i],i+1);
  		//khlee-마지막 환경 설정 함수 추가
  		ComEndConfigSheet(sheetObjects[i]);
  	}

  	initControl();

  	/* IBMultiCombo 초기화 */
  	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
  		initCombo(comboObjects[k], k+1);
  	}
  }

  function sheet1_OnLoadFinish(){
  	/* IBMulti Combo Item Setting */
  	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);

	ComBtnDisable("btn_Save");
  	comboObjects[0].CheckIndex(0) = true;

	sheetObjects[0].ColHidden("sbo_cost") = true;
	sheetObjects[0].ColHidden("sbi_cost") = true;
	sheetObjects[0].ColHidden("gto_amt") = true;

  }
  /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
  function initSheet(sheetObj,sheetNo) {

  	var cnt = 0;
  	var sheetid = sheetObj.id;

  	switch(sheetid) {
  	case "sheet1":
  		with (sheetObj) {

  			// 높이 설정
  			style.height = 398;
  			//전체 너비 설정
  			SheetWidth = 984;//mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
		    MergeSheet = msPrevColumnMerge + msHeaderOnly;
 			//MergeSheet = msHeaderOnly;
 			//전체Edit 허용 여부 [선택, Default false]
  			Editable = true;
 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo( 1, 1, 15, 100);
			var HeadTitle = "| |Req No|SML is|SP Code|Lessor|From|POR\nSaving|SBO\nSaving|T/Size|Vol|DiV|To|DEL\nSaving|SBI\nSaving|Free Days|PUC|GTO|Add Cost|PCR Credit|Total\nSaving|";
  			
  			var headCount   = ComCountHeadTitle(HeadTitle);
  			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  			InitColumnInfo(headCount, 0, 0, true);

  			// 해더에서 처리할 수 있는 각종 기능을 설정한다
  			InitHeadMode(true, true, true, true, false,false)

  			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  			InitHeadRow(0, HeadTitle , true);
  			//ttl_of = "|por_cost| + |del_cost| - |puc_amt| - |add_cost| + |pcr_credit|";

  			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	true,	"del_chk");
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"req_no",			false,	"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"lstm_cd",			true,	"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"vndr_seq",			true,	"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,daLeft,		true,	"vndr_abbr_nm",		false,	"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			75,	daCenter,	true,	"loc_fm",			true,	"",	dfNone,	0,	false,		false);					
			InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"por_cost",			false,	"",	dfFloat,	2,	true,		true);					
			InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"sbo_cost",			false,	"",	dfFloat,	2,	true,		true);					
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"tpsz_cd",			true,	"",	dfNone,	0,	false,		false);
			
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"rqst_qty",			false,	"",	dfInteger,	0,	true,		true, 4);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"loc_grp",			true,	"",	dfNone,	0,	false,		false);

			InitDataProperty(0, cnt++ , dtData,			75,	daCenter,	true,	"loc_to",			true,	"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"del_cost",			false,	"",	dfFloat,	2,	false,		false, 6);					
			InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"sbi_cost",			false,	"",	dfFloat,	2,	false,		false, 6);					
			InitDataProperty(0, cnt++ , dtData,			65,	daRight,	true,	"free_day",			false,	"",	dfInteger,	0,	true,		true, 3);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	"puc_amt",			false,	"",	dfInteger,	0,	true,		true, 4);
			InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,	"gto_amt",			false,	"",	dfInteger,	0,	true,		true, 4);

			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"add_cost",			false,	"",	dfInteger,	0,	true,		true, 4);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"pcr_credit",		false,	"",	dfInteger,	0,	true,		true, 4);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"ttl_sav",			false,	"",	dfFloat,	2,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,	daRight,	true,	"req_seq",			false,	"",	dfNone,	0,	false,		false);

  			SelectBackColor = LSE_SELECT_BACK_COLOR;
 			//FrozenCols = 5;

  		}
  		break;

  	}
  }

  //Sheet관련 프로세스 처리
  function doActionIBSheet(sheetObj,formObj,sAction) {

  	switch(sAction) {
	  	case IBSEARCH:      //조회
		  	if(validateForm(sheetObj,formObj,sAction)){
		  		if (sheetObj.id == "sheet1"){
		  			formObj.f_cmd.value = SEARCH;

		  			sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
		  			sheetObj.DoSearch("EES_LSE_0107GS.do",FormQueryString(formObj));

		  			for(var i = 1 ; i <= sheetObj.lastRow; i++){
						sheetObj.CellValue2(i, "vndr_abbr_nm")		= formObj.vndr_nm.value;
			  	    	if(formObj.loc_grp.value == "ECC"){
			  	    		sheetObj.CellEditable(i, "del_cost") = true;
			  	    		sheetObj.CellEditable(i, "sbi_cost") = true;
			  	    	}else{
			  	    		sheetObj.CellEditable(i, "del_cost") = true;
			  	    		sheetObj.CellEditable(i, "sbi_cost") = true;
			  	    	}
						ComBtnEnable("btn_Save");
		  			}
		  			ComOpenWait(false);
		  		}
		  	}
		  	break;

	  	case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				if ( sheetObj.id == "sheet1") {
					comboPosition = "";
					formObj.f_cmd.value = MULTI;
					var sParam = sheetObj.GetSaveString();
					sParam += "&" + FormQueryString(formObj);
					ComOpenWait(true);
					var sXml   = sheetObj.GetSaveXml("EES_LSE_0107GS.do", sParam);
					ComOpenWait(false);
					if(ComGetEtcData(sXml, "req_no") != ""){
						comboObjects[1].InsertItem (0, ComGetEtcData(sXml, "req_no"),ComGetEtcData(sXml, "req_no")) ;
						comboObjects[1].Code = ComGetEtcData(sXml, "req_no");
						comboPosition = ComGetEtcData(sXml, "req_no");
					}
				    sheetObj.LoadSaveXml(sXml);
				}
			}
			break;		
			
		case IBSEARCH_ASYNC03:
	  		/* Lease Term Form Combo Item Setting */
	  		ComSetObjValue(formObj.f_cmd, SEARCH02);
	  		sheetObj.WaitImageVisible = false;
	  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

	  		if ( sXml != "" ) {
	  			//comboObjects[0].InsertItem(0 , 'ALL','ALL');
	  			comboObjects[0].InsertItem(0 , '','');
	  			LseComXml2ComboItem(sXml, comboObjects[0], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	  		}
	  		//vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");
        	vOrcCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");

	  		break;

	  	case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
		  	if ( validateForm(sheetObj, formObj, sAction) ) {
		  		var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		  		sheetObj.WaitImageVisible = false;
		  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);

		  		if ( sXml != "" ) {
		  			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
		  				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
		  				//ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
		  				ComSetFocus(formObj.vndr_nm);
		  			} else {
		  				ComShowCodeMessage("LSE01019");
		  				formObj.vndr_seq.value = "";
		  				formObj.vndr_nm.value  = "";
		  				ComSetFocus(formObj.vndr_seq);
		  			}
		  		} else {
		  			ComShowCodeMessage("LSE01019");
		  			formObj.vndr_seq.value = "";
		  			formObj.vndr_nm.value  = "";
		  			ComSetFocus(formObj.vndr_seq);
		  		}
		  	}
		  	break;
		  	
	  	case IBSEARCH_ASYNC01: // Location 조회
	  	    if(validateForm(sheetObj,formObj,sAction)) {
	  	    	//if ( sheetObj.id == "sheet1") {
	  	    		var vLocTp = formObj.loc_grp.value ;
	  	    		if(vLocTp != 'CN'){
	  	    		     var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp+"&loc_cd="+ComGetObjValue(formObj.loc_to);
	  	    		}else {
	  	    		     var param = "f_cmd="+SEARCH10+"&loc_tp="+ vLocTp+"&loc_cd="+ComGetObjValue(formObj.loc_to); 
	  	    		}

	  	    		sheetObj.WaitImageVisible = false;
	  	    		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
	  	    		sheetObj.WaitImageVisible = true;
	  	      
	  	    		if ( sXml != "" ) {
	  	    			if(vLocTp != 'CN'){
		  	    			if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
		  	    				if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
		  	    					var vLocCd = "";
		  	    					switch (vLocTp) {
		  	    					case "RCC":
		  	    						vLocCd = ComGetEtcData(sXml, "rcc_cd");
		  	    						break;
		  	    					case "LCC":
		  	    						vLocCd = ComGetEtcData(sXml, "lcc_cd");
		  	    						break;
		  	    					case "SCC":
		  	    						vLocCd = ComGetEtcData(sXml, "scc_cd");
		  	    						break;
		  	    					case "ECC":
		  	    						vLocCd = ComGetEtcData(sXml, "ecc_cd");
		  	    						break;
		  	    					}
		  	    					formObj.loc_to.value = vLocCd;
		  	    					//if(formObj.port_cd.className == "input1") {
		  	    					//	ComSetNextFocus(formObj.loc_cd);
		  	    					//} else {
		  	    						ComSetFocus(formObj.tpsz_cd);
		  	    					//}
		  	    				} else {
		  	    					ComShowCodeMessage("LSE01037");
		  	    					formObj.loc_to.value = "";
		  	    					ComSetFocus(formObj.loc_to);
		  	    				}
		  	    			} else {
		  	    				var errMsg = LseComGetErrMsg(sXml);
		  	    				if ( errMsg != "" ) ComShowMessage(errMsg);		  	    				
			  	    			formObj.loc_to.value = "";
			  	    			ComSetFocus(formObj.loc_to);
		  	    			}
	  	    			}else{
	  	    			   if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
	  	    				   if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
	  	    					   var vLocCd = "";
	  	    					   switch (vLocTp) {
	  	    					   case "CN":
	  	    						   vLocCd = ComGetEtcData(sXml, "loc_cd");
	  	    						   break;
	  	    					   }
	  	    		  
	  	    					   formObj.loc_to.value = vLocCd;
	  	    					   if(formObj.loc_to.className == "input1") {
	  	    						   ComSetNextFocus(formObj.loc_to);
	  	    					   } else {
	  	    						   ComSetFocus(comboObjects[0]);
	  	    					   }
	  	    				   }else {
	  	    					   ComShowCodeMessage("LSE01037");
	  	    					   formObj.loc_to.value = "";
	  	    					   ComSetFocus(formObj.loc_to);
	  	    				   }
	  	    		       	} else {
	  	    		       		var errMsg = LseComGetErrMsg(sXml);
	  	    		       		if ( errMsg != "" ) ComShowMessage(errMsg);
	  	    		       		formObj.loc_to.value = "";
	  	    		       		ComSetFocus(formObj.loc_to);
	  	    		       	}
	  	    		      }	  	    				
  					}
	  	    	//}
	  	    }
	  	    break;
	  	   
	  	    
		case IBSEARCH_ASYNC02:      //REQ_NO List 조회
			var vLstmCd  = formObj.lstm_cd.value;
			var vVndrSeq = formObj.vndr_seq.value;
			var vLocfm   = formObj.loc_fm.value;
			comboObjects[1].RemoveAll();
			
			if(vLstmCd != "" && vVndrSeq != "" && vLocfm != ""){
				formObj.f_cmd.value = SEARCH01;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_0107GS2.do", FormQueryString(formObj));
				sheetObj.WaitImageVisible = true;
				if ( sXml != "" ) {
					ComXml2ComboItem(sXml, comboObjects[1], "req_no", "req_no");
				}
			}
			break;
		case IBSEARCH_ASYNC05:	// Location 조회
			if(validateForm(sheetObj,formObj,sAction)) {
				if ( sheetObj.id == "sheet1") {
					var vLocTp = "ECC";
					var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp +"&loc_cd="+ComGetObjValue(formObj.loc_fm);
					sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
				sheetObj.WaitImageVisible = true;

				if ( sXml != "" ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
						if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
							var vLocCd = "";
							switch (vLocTp) {
								case "RCC":
									vLocCd = ComGetEtcData(sXml, "rcc_cd");
									break;

								case "LCC":
									vLocCd = ComGetEtcData(sXml, "lcc_cd");
									break;

								case "SCC":
									vLocCd = ComGetEtcData(sXml, "scc_cd");
									break;
								case "ECC":
									vLocCd = ComGetEtcData(sXml, "ecc_cd");
									break;
							}

							formObj.loc_fm.value = vLocCd;
							if(formObj.loc_fm.className == "input1") {
								ComSetNextFocus(formObj.loc_fm);
							} else {
								ComSetFocus(comboObjects[0]);
							}
						} else {
							ComShowCodeMessage("LSE01037");
							formObj.loc_fm.value = "";
							ComSetFocus(formObj.loc_fm);
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						formObj.loc_fm.value = "";
						ComSetFocus(formObj.loc_fm);
					}
				}
			}
		}
	break;	
		
  	}
  }

  /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
  function validateForm(sheetObj,formObj,sAction){
  	with(sheetObj){
  		with(formObj){
  			switch(sAction) {
  			case IBSEARCH:
	  			if(document.form.lstm_cd.value != ""){
	  				var vndrseq = formObj.vndr_seq.value;
	  				var locfm = formObj.loc_fm.value;
	  				if ( vndrseq == ""  || locfm == "") {
	  					ComShowCodeMessage("LSE01070");
	  					ComSetFocus(formObj.vndr_seq);
	  					return false;
	  				}
	  			}
	  			break;
  			
  			case IBSAVE:
  			    if(sheetObj.RowCount <= 0){
  			    	ComShowCodeMessage("LSE01048");
  			    	return false;
  			    }else{
  			    	//if(sheetObj.CheckedRows("del_chk") <= 0){
  			    	//	ComShowCodeMessage("LSE01045");
  			    	//	return false;
  			    	//저장시 Dupe Check
  					for(var i = 1; i <= sheetObj.RowCount ; i++){
  						for (var j=i +1; j <= sheetObj.RowCount ; j++){
  							if(sheetObj.CellValue(i, "lstm_cd") == sheetObj.CellValue(j, "lstm_cd") &&
  								sheetObj.CellValue(i, "vndr_seq") == sheetObj.CellValue(j, "vndr_seq") &&
  								sheetObj.CellValue(i, "loc_fm") == sheetObj.CellValue(j, "loc_fm") &&
  								sheetObj.CellValue(i, "loc_to") == sheetObj.CellValue(j, "loc_to") &&
  								sheetObj.CellValue(i, "loc_grp") == sheetObj.CellValue(j, "loc_grp") &&
  								sheetObj.CellValue(i, "tpsz_cd") == sheetObj.CellValue(j, "tpsz_cd") &&
  								sheetObj.CellValue(i, "ibflag") == "I"){
  								ComShowCodeMessage("LSE01005", "one(or more)");
  								return false;
  							}
  						}
  					}
  			    }
  			    break;

  			}
  		}
  	}
  	return true;
  }


  /**
  * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
  */
  function obj_blur(){
  	var obj = event.srcElement;
  	switch(obj.name){

  	case "vndr_seq":
  		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
  			document.form.vndr_nm.value = "";
  		}
		ComSetFocus(formObj.loc_fm);
		//formObj.loc_fm.focus();
  		break;
  	default:
  		//Validation 전체 체크(길이,format,최대,최소 등등)
  		break;
  	}
  }

  /**
  * 콤보 초기설정값, 헤더 정의
  * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
  function initCombo(comboObj, comboNo) {
  	switch(comboObj.id) {
  	case "combo1":
  		with(comboObj) {
  			DropHeight = 200;
  			MultiSelect = true;
  			//MaxSelect = 1;
  			MultiSeparator = ",";
  			Style = 0;
  			UseAutoComplete = true;
  			//영문(대)+특수문자,숫자 - TP/SZ
  			ValidChar(2,3);
  		}
  		break;
  	}
  }

  /**
   * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
   * @return
   */
  function combo1_OnCheckClick(comboObj, index, code) {
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


  /**
   * combo1_OnBlur
   */
  function combo1_OnBlur(comboObj, Index_Code, Text) {
  	var formObj = document.form;
  	if( comboObj.CheckIndex(0)){
  		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
  			comboObj.CheckIndex(i) = false;
  		}
  		formObj.tpsz_cd.value = "";
  	}else if(comboObj.Text == ""){
  		comboObj.CheckIndex(0) = true;
  		formObj.tpsz_cd.value = "";
  	}else{
  	    formObj.tpsz_cd.value = ComGetObjValue(comboObj);
  	}
  }


  /**
   * combo1_OnKeyDown
   */
  function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
      with(comboObj) {
          if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
              comboObj.Text = "";
  		  }else if(KeyCode == 13){
 		      sheetObjects[0].RemoveAll();
 			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  }
  	  }
  }


  /**
  * Pop-up Open 부분<br>
  * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
  * @param object 대상 Object
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  */
  function openPopup(type, Row, Col) {
  	var formObj = document.form;
  	switch(type){
	  	case "2":
	  		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	  		break;
	 
	  	case "3":
	        var sTargetObjList = "";
	    	
            sTargetObjList = "ecc_cd:loc_fm";
            ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430, sTargetObjList, "1,0,1,1,1,1,1,1", true);
	  		break;

	  	case "4":
	  	
	        var sTargetObjList = "";
	
	        if(formObj.loc_grp.value == "CN")
	            sTargetObjList = "cnt_cd:loc_to";
            else
	            sTargetObjList = formObj.loc_grp.value.toLowerCase()+"_cd:loc_to";
            ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430, sTargetObjList, "1,0,1,1,1,1,1,1", true);
	  		break;
	
  	}
  }

  /**
  * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
  * @param {arry} returnedValues Pop-up 화면의 Return value array
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  * @param 대상IBSheet의 Sheet Array index
  */
  function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
  	var sheetObj = sheetObjects[SheetIdx];
  	var formObj  = document.form;
  	if ( aryPopupData.length > 0 ) {
  		formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
  		formObj.vndr_nm.value  = aryPopupData[0][4];
  		//formObj.abbr_nm.value  = aryPopupData[0][5];
  	}
  }

  /**
  * HTML Control의 Value가 변경되었을 경우 처리한다.
  */
  function obj_change(){
  	var obj      = event.srcElement;
  	var formObj  = document.form;

  	switch(obj.name) {

  	case "vndr_seq":
  		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
  		}
  		break;
  	case "loc_fm":  //Location Code
  	    if ( ComTrim(obj.value) != "" ) {
  	    	var strLocCd = formObj.loc_fm.value;
  	    	if(strLocCd.length == 5){
  	            doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05); // Location
  	            doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02); // REQ No
  	    	}
  	    }
  	    break;
   	    
  	case "loc_to":  //Location Code
  	   if ( ComTrim(obj.value) != "" ) {
  		  var strLocCd = formObj.loc_to.value;
  	    	if(strLocCd.length == 5){ 
  	            doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  	    	}
  	    }
  	    break;
 
  	case "loc_grp":  //Location Code
  	    if ( ComTrim(obj.value) != "" ) {
  	    	for(var i=0; i<= sheetObjects[0].lastRow; i++){
	  	    	if(obj.value == "ECC"){
	  	  			sheetObjects[0].CellEditable(i, "del_cost") = true;
	  	  			sheetObjects[0].CellEditable(i, "sbi_cost") = true;
	  	    	}else{
	  	  			sheetObjects[0].CellEditable(i, "del_cost") = true;
	  	  			sheetObjects[0].CellEditable(i, "sbi_cost") = true;
	  	    	}
  	    	}
  	    	formObj.loc_to.value ="";
  	    }
  	    break;
  	case "lstm_cd":		//Location Code

  		//formObj.vndr_seq.value    = "";

  		if(formObj.lstm_cd.value == "OF"){
  			sheetObjects[0].ColHidden("por_cost") = false;
  			sheetObjects[0].ColHidden("sbo_cost") = true;
  			sheetObjects[0].ColHidden("del_cost") = false;
  			sheetObjects[0].ColHidden("sbi_cost") = true;
  			sheetObjects[0].ColHidden("puc_amt") = false;
  			sheetObjects[0].ColHidden("gto_amt") = true;

  			//formObj.cost_st_month.focus();
  		}else if(formObj.lstm_cd.value == "SO"){
  			sheetObjects[0].ColHidden("por_cost") = true;
  			sheetObjects[0].ColHidden("sbo_cost") = false;
  			sheetObjects[0].ColHidden("del_cost") = true;
  			sheetObjects[0].ColHidden("sbi_cost") = false;
  			sheetObjects[0].ColHidden("puc_amt") = true;
  			sheetObjects[0].ColHidden("gto_amt") = false;

  			//formObj.invoice_st_month.focus();
  		}

  		break;
  	}
  }
  /**
  * HTML Control의 키보드 이벤트 방 포멧처리 한다.
  */
  function obj_keypress() {
  	var obj = event.srcElement;
  	switch(obj.dataformat) {
  	case "ymd":
  	case "ym":
  	case "hms":
  	case "hm":
  	case "jumin":
  	case "saupja":
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
  		//if(obj.name == "loc_fm") {
    	//	ComKeyOnlyAlphabet('uppernum');
    	//}else{
    	//	ComKeyOnlyAlphabet('upper');
    	//} 
  		
  		ComKeyOnlyAlphabet('upper');
   		//ComKeyOnlyAlphabet('uppernum');
  		break;
  	case "engdn":
  		ComKeyOnlyAlphabet('lower');
  		break;
  	default:
  		ComKeyOnlyNumber(obj);
  	break;
  	}
  }

/**
* HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
*/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){
	case "lstm_cd":
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value = "";
			//document.form.abbr_nm.value = "";
		}
		break;
		
  	case "loc_fm":  //Location Code
        doActionIBSheet(sheetObjects[0], document.form , IBSEARCH_ASYNC02); // REQ No
		break;
				
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
		break;
	}
}

/**
* sheet1_OnSaveEnd
* 그리드 저장후 이벤트 처리
* 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObject = document.form;
	if ( ErrMsg == "" ) {
		ComShowCodeMessage("LSE10001");
		ComBtnDisable("btn_Save");
		ComEnableObject(formObject.lstm_cd, true);
		ComEnableObject(formObject.vndr_seq, true);
		ComEnableObject(formObject.loc_fm, true);
		ComEnableObject(formObject.btns_search2, true);
		ComEnableObject(formObject.btns_search3, true);
		ComEnableObject(formObject.loc_grp, true);
		
		formObject.lstm_cd.className = "input1";
		formObject.vndr_seq.className = "input1";
		formObject.loc_fm.className = "input1";
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		comboObjects[1].Code = comboPosition; 
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	} else {
		ComShowMessage(ErrMsg);
	}
	

}

  /**
  * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
  */
  function obj_focus(){
  	var obj  = event.srcElement;
  	if( obj.readOnly ) {
  		ComSetNextFocus(obj);
  	} else {
  		//마스크구분자 없애기
  		ComClearSeparator(event.srcElement);
  	}
  }
  /**
  * Key-Down Event 처리
  */
  function obj_keydown() {
  	var obj      = event.srcElement;
  	var vKeyCode = event.keyCode;
  	var formObj  = document.form;
  	var srcObj  = window.event.srcElement;
  	if ( vKeyCode == 13 ) {
  		switch(obj.name) {
  		    case "aaa":
//  		  		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
//  		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
//  		  		}
//  		  		break;
  		    case "loc_fm":
  			    if ( srcObj.style.filter == "" ) {
  				    //sheetObjects[0].RemoveAll();
  				    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
  			    }
  		  		break;
  		    default :
  			    if ( srcObj.style.filter == "" ) {
  				    //sheetObjects[0].RemoveAll();
  				//    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			    }
		  		break;
  	    }
  	}
  }
  
  /**
   * sheet1_OnChange
   * 그리드 변경시 이벤트 처리
   */
  function sheet1_OnChange(sheetObj,Row, Col, Value){
  	var formObj  = document.form;
  	var sName = sheetObj.ColSaveName(Col);
  	
  	var obj_val = parseFloat(Value);
  	var por = parseFloat(sheetObj.CellValue(Row, "por_cost"));
  	var del = parseFloat(sheetObj.CellValue(Row, "del_cost"));
  	var sbo = parseFloat(sheetObj.CellValue(Row, "sbo_cost"));
  	var sbi = parseFloat(sheetObj.CellValue(Row, "sbi_cost"));
  	var pcr = parseFloat(sheetObj.CellValue(Row, "pcr_credit"));
  	var puc = parseFloat(sheetObj.CellValue(Row, "puc_amt"));
  	var gto = parseFloat(sheetObj.CellValue(Row, "gto_amt"));
  	var add = parseFloat(sheetObj.CellValue(Row, "add_cost"));

  	if(formObj.lstm_cd.value == "OF")
		sheetObj.CellValue2(Row, "ttl_sav") = por + del - puc - add + pcr ;
  	else
		sheetObj.CellValue2(Row, "ttl_sav") = sbo + sbi - gto - add + pcr ;

  }  
  /* 개발자 작업  끝 */