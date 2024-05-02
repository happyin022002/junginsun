/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : com_csr_0001.js
*@FileTitle : CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.01 함대성
* 1.0 Creation 
* -------------------------------------------------------
* history
* 2011.05.02 김영철 [CHM-201110531-01] PKGBB의 SUB-OFC에서 PORT S/O로 전표 생성시 CSR OFC CODE를 PKGBB로 변경하여 ERP I/F 요청
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
     * @class com_csr_0001 : com_csr_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function com_csr_0001() {
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

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    //New button click시에 IBCombo들의 change이벤트를 타지 못하도록 하기 위함
    var gNew = false;
    var gCurRow = 0;
    var prefix = "sheet1_";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var cal = new ComCalendar();
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch (srcName) {

			case "btns_vndr":
				var param = '';
				ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 450, '2:vndr_seq|4:vndr_nm', '1,0,1,1,1', true);
				break;

    		case "btn_retrieve":
    			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			break;

			case "btns_calendar1": //달력버튼
				var cal = new ComCalendar();
	         	cal.select(formObject.inv_cfm_dt, 'yyyy-MM-dd');
	        break; 

    		case "btn_new":
    			sheetObject1.RemoveAll();
    			//setDate();
    			document.form.vndr_seq.value = "";
    			document.form.vndr_nm.value = "";
    		break;

    		case "btn_save":
    			doActionIBSheet(sheetObject1, formObject, IBSAVE);
    		break;

    		case "btn_downExcel":
    			sheetObject1.Down2Excel();
    		break;
    		
			case "btn_detail":
				/* 2008-11-17 : 부산의 요청에 의해 자동 조회 기능 추가를 위해 조회기능의 function화 */
				retrieve_detail();
				break;
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('CSR90002');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    /*
    function inv_cfm_dt_keypress(){ 
      	ComKeyOnlyNumber(event.srcElement);
    }
      
	  //inv_cfm_dt 변경시 조회 
	  function inv_cfm_dt_onblur(){
	  	
	  	var formObject = document.form;
	
		if (formObject.inv_cfm_dt.value ==null || formObject.inv_cfm_dt.value ==""){
			
			ComShowMessage("Input a Confirmed Date.");
			ComSetFocus(formObject.inv_cfm_dt);
			
			return false;
		} 
	          
	  }
	*/
  	function setDate(){
  		var today=new Date();
  		var y = today.getFullYear().toString();
  		var m = today.getMonth()+1;
  		var d = today.getDate();

  		if(m<10){
  			m = "0"+m;
  		}
  		if(d<10){
  			d = "0"+d;
  		}
  		document.form.inv_cfm_dt.value = y+"-"+m+"-"+d; 
 	}
  	
  	function getElementValue(formObject, eleTp, eleNm) {

  		var element;
  		var numOfEle = formObject.elements.length;
  		for (var i = 0; i < numOfEle; i++){
  			if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
  				if (formObject.elements[i].checked == true){
  					var ele_value = formObject.elements[i].value;
  					break;
  				}
  			}
  		}

  		return ele_value;
  	}
  	
	function retrieve_detail(){ 
		/* 2008-11-17 : 부산의 요청에 의해 자동 조회 기능 추가 */
		if(sheetObjects[0].SelectRow ==0){
			//showErrMessage(getMsg('CSR25017'))
			return false;	
		}
		if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 0) == "" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 1) =="" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 2) =="" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 3) ==""){ 
			//showErrMessage(getMsg('CSR25017'))
			return false;
		}
		document.form.inv_sub_sys_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix+"inv_sub_sys_cd");
		
		var inv_cfm_dt 			= document.form.inv_cfm_dt.value;
		var vndr_seq  			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"vndr_no");
		var vndr_seq_name 		= encodeURI(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"vndr_seq_name"));
		var cnt_inv 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"cnt_inv");
		var curr_cd 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"inv_curr_cd");
		var total_amt 			= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"total_amt");
		var iss_dt 				= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"inv_iss_dt");
		var rcv_dt 				= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"inv_rcv_dt");
		var gen_pay_term_cd		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"gen_pay_term_cd"); 
		var gen_pay_term_desc	= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"gen_pay_term_desc");  
		var payment_due_dt		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"payment_due_dt");
		var pay_term_tp_cd		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"pay_term_tp_cd");
		//2009-11-23
		var pso_trns_slp_ctnt	= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"pso_trns_slp_ctnt");
		
		//var pay_group_cd 		= getElementValue(document.form, 'radio', 'pay_group_cd');
		var cost_ofc_cd	 		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"cost_ofc_cd");  
		var inv_sub_sys_cd      = document.form.inv_sub_sys_cd.value;
//		formObj.bundle_radio[2].checked
		if (document.form.inv_sub_sys_cd.value == "PSO" ){
			if (document.form.asanogb[0].checked){
				document.form.asa_gubun.value = "";
			} else {
				document.form.asa_gubun.value = "O";
			}
		} else {
			document.form.asa_gubun.value = "O";
		}
		document.form.cost_ofc_cd.value = cost_ofc_cd;
		form.f_cmd.value = SEARCH01;
        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0001GS.do" , FormQueryString(form)); 
        //so_if_cd 구분자 
        var so_if_cd = ComGetEtcData(sXml,"so_if_cd");
        
        var ap_ofc_cd = ComGetEtcData(sXml,"ap_ofc_cd"); 
        
        /*
        if(so_if_cd == 'O'){	//ASA
        	document.form.asanogb[0].checked  = false;
    		document.form.asanogb[1].checked  = true;
        	asaNoGb 			= getElementValue(document.form, 'radio', 'asanogb');
        }else{ //A/P
        	document.form.asanogb[0].checked  = true;
    		document.form.asanogb[1].checked  = false;
        	asaNoGb 			= 'A/P';
        }
		*/
        asaNoGb 			= getElementValue(document.form, 'radio', 'asanogb');
       
		var detailUrl = "COM_CSR_0002.do?MENU=Y&pgmNo=COM_CSR_0002" +
						"&inv_cfm_dt="+inv_cfm_dt+
						"&vndr_seq="+vndr_seq+
						"&vndr_seq_name="+vndr_seq_name+
						"&cnt_inv="+cnt_inv+
						"&curr_cd="+curr_cd+
						"&total_amt="+total_amt+
						"&iss_dt="+iss_dt+
						"&rcv_dt="+rcv_dt+
						"&gen_pay_term_cd="+gen_pay_term_cd+
						"&gen_pay_term_desc="+gen_pay_term_desc+
						"&payment_due_dt="+payment_due_dt+
						"&pay_term_tp_cd="+pay_term_tp_cd+
						"&cost_ofc_cd="+cost_ofc_cd+
						"&apOfcCd="+ap_ofc_cd+
						"&asanogb="+asaNoGb+
						"&inv_sub_sys_cd="+inv_sub_sys_cd+
						"&pso_trns_slp_ctnt="+pso_trns_slp_ctnt;
		
		location.href = detailUrl;
		
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
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
     	
    	//  I/F  radio check 가져요기 
        form.f_cmd.value = SEARCH01;
    	sheetObjects[0].WaitImageVisible = false;
        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0001GS.do" , FormQueryString(form)); 
        //so_if_cd 구분자 
        var so_if_cd = ComGetEtcData(sXml,"so_if_cd");
        
        if(so_if_cd == 'O'){
        	document.form.asanogb[0].checked  = false;
        	document.form.asanogb[1].checked  = true;
        }else{ 
        	document.form.asanogb[0].checked  = true;
        	document.form.asanogb[1].checked  = false;
        }
        
        /**
        # 2017-04-28
		Invoice Office 혹은 Cost Office가 아래의 특정 Office에 해당되는 경우에는 CSR I/F type을 (시스템이 자동으로 ‘To ASA’ 지정 후) User가 ‘To AP’로 변경 가능
		Sub Sys Code : PSO 인 경우에만
		Office : DLCSC, NBOSC, TAOSC, XMNSC
        */
        var inv_ofc_cd = document.form.inv_ofc_cd.value;
        if (document.form.inv_sub_sys_cd.value == "PSO" ){
        	if(inv_ofc_cd=='DLCSC' || inv_ofc_cd=='NBOSC' || inv_ofc_cd=='TAOSC' || inv_ofc_cd=='XMNSC'){
    			document.form.asanogb[0].disabled = false;			
    			document.form.asanogb[1].disabled = false;
    			document.form.asanogb[1].checked = true;
    		}        	
        }
        
     	initControl();
     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
     
     function sheet1_OnLoadFinish(sheetObj) {
         //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
      }

    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
 	function initControl() {
 	    //Axon 이벤트 처리1. 이벤트catch
 		var formObject = document.form;
 	    //axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 	    //axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
 		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
 		
     }

 	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}
	    } else {
			switch(obj.name) {
	    		case "vndr_seq":
	        		formObj.vndr_nm.value = "";
				   	break;
			}
		}
	}
  
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;

	    switch(obj.dataformat) {
	        case "saupja":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet(); break;
	        case "engup":
	            if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else if(obj.name=="inv_cfm_dt"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	        case "engdn":
				//포멧 처리를 하지 않기 위해
				if(obj.name == "phn_no" || obj.name == "fax_no"){
					ComKeyOnlyNumber(obj, "-");
				}	else if(obj.name=="mnr_prnr_eml") {
					MnrKeyOnlyAlphabet('lowereml');
				} 	else {
					ComKeyOnlyAlphabet('lower');
				}
	            break;
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
    	        case 1:      //sheet1 init
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
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|Cost Office|S/P Code|S/P Name|No of Invoice|Invoice Currency|Total Amount" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

	                //데이터속성    [ROW, COL, DATATYPE,WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,			false,    "",							false,			"",			dfNone,			0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    prefix+"cost_ofc_cd",			false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    prefix+"vndr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		300,	daLeft,				false,    prefix+"vndr_seq_name",		false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		80,		daCenter,			false,    prefix+"cnt_inv",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		130,	daCenter,			false,    prefix+"inv_curr_cd",			false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 		80,		daRight,			false,    prefix+"total_amt",			false,			"",			dfNullFloat,	2,			false,			false	); 
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"inv_iss_dt",			false,			"",			dfNone,			0,			false,			false	); 
					
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"inv_rcv_dt",			false,			"",			dfNone,			0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"gen_pay_term_cd",		false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"gen_pay_term_desc",	false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"pay_term_tp_cd",		false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"inv_sub_sys_cd",		false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"payment_due_dt",		false,			"",			dfNone,			0,			false,			false	);
					//2009-11-23
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daCenter,			false,    prefix+"pso_trns_slp_ctnt",	false,			"",			dfNone,			0,			false,			false	);
    	        }
    	            break;
    	    }
    	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){

    			formObj.f_cmd.value = SEARCH;
    			//var sXml = sheetObj.GetSearchXml("COM_CSR_0001.do", FormQueryString(formObj));
    			sheetObj.DoSearch("COM_CSR_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix)); 

    			//var arrXml = sXml.split("|$$|");
    			//sheetObj.LoadSearchXml(arrXml[0]);
    		}
    	break;

		case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
		if ( validateForm(sheetObj, formObj, sAction) ) {
			//Service Provider Detail Information
			var sXml = CsrGetRepairPartner(sheetObj,formObj.vndr_seq.value);
			
			if(ComGetEtcData(sXml, "vndr_seq") != 'null'){
				//Vender nm 세팅
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
			} else {
				ComShowCodeMessage("COM12114", "Service Provider");
				ComSetObjValue(formObj.vndr_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}
		}
		break;

    	}
    }

    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
  // combo object 초기화
     function initCombo(comboObj, comboNo, crrCombo) {
         var formObject = document.form

         switch(comboNo) {
         	case 1:
                with (comboObj) {
     				MultiSelect = false;
     				UseAutoComplete = true;
     				SetColAlign("left|left");
     				SetColWidth("0|30");
      				DropHeight = 160;
      		    }
                 var comboItems = crrCombo.split("|");
                 addComboItem(comboObj, comboItems);
      			break;

         	case 2:
                 with (comboObj) {
      				MultiSelect = false;
      				UseAutoComplete = true;
      				SetColAlign("left|left");
      				SetColWidth("0|30");
       				DropHeight = 160;
       		    }
       			break;

         	case 3:
                 with (comboObj) {
      				MultiSelect = false;
      				UseAutoComplete = true;
      				SetColAlign("left|left");
      				SetColWidth("0|30");
       				DropHeight = 160;
       		    }
       			break;
         }
     }

    // 조회조건필드인 Lane SVC Type 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH: //TRADE


    	        break;
        }
    }


    /**
     * 콤보필드에 데이터를 추가해준다.
     */
    function addComboItem(comboObj,comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(",");
    		comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
    	}
    }

    //R/E변경시
    function from_dt_OnChange(idx_cd, text){
    	if (gNew) return;
    	sheetObjects[0].RemoveAll();
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
           with(formObj){
         	switch(sAction) {
 				case IBSAVE:
 					break;
 				//버젼업
 				case IBCREATE:
 					break;
 				//IBSEARCHAPPEND 삭제임 변수 부족
 				case IBSEARCHAPPEND:
 					break;
 				case IBSEARCH:
         			break;

 				case IBSEARCH_ASYNC01:
         			if( ComGetObjText(formObj.vndr_seq) == "" ) {
         				ComShowCodeMessage("CSR00172","Service Provider Seq ");
         				ComSetFocus(formObj.vndr_seq);
         				return false;
         			}
         			break;
 			}
 		}
         return true;
     }

 	function sheet_OnDblClick (sheetObj, row, col){
		//retrieve_detail(sheetObj);	
	} 
 	
 	function sheet_OnClick (sheetObj, row, col){ 
 		/*
 		 * 2010.08.26 로그인한 유저의 ofc_cd로 그대로 둔다.
		var cost_ofc_cd	 		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"cost_ofc_cd");  //혼돈되서 변수명 재정의
		var inv_sub_sys_cd      = document.form.inv_sub_sys_cd.value;
		
		document.form.asa_gubun.value = "O";
		document.form.cost_ofc_cd.value = cost_ofc_cd;
		form.f_cmd.value = SEARCH01;
        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0001GS.do" , FormQueryString(form)); 
        //so_if_cd 구분자 
        var so_if_cd = ComGetEtcData(sXml,"so_if_cd");
        
        if(so_if_cd == 'O'){	//ASA
        	document.form.asanogb[0].checked  = false;
    		document.form.asanogb[1].checked  = true;
        	asaNoGb 			= getElementValue(document.form, 'radio', 'asanogb');
        }else{ //A/P
        	document.form.asanogb[0].checked  = true;
    		document.form.asanogb[1].checked  = false;
        	asaNoGb 			= 'A/P';
        }
        */
	}
     
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    }

 	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
 		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    }

    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
    	var sName = sheetObj.ColSaveName(Col);

    	var Value = sheetObj.EditValue;
    	//4자리 치면 NEXT로 이동
    	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
    		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
    	}

    	//4자리 치면 NEXT로 이동
    	if (sName == prefix+"skd_voy_no" && Value.length==4){
    		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
    	}
    }

    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var sName = sheetObj.ColSaveName(Col);
    	var formObj = document.form;
    	gCurRow = Row;
    	
    	/*
    	if (sName == prefix+"vsl_cd" || sName==prefix+"skd_voy_no" || sName==prefix+"skd_dir_cd" || sName==prefix+"rev_dir_cd"){
    		var vvd  = sheetObj.CellValue(Row, prefix+"vsl_cd");
    		vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
    		vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
    		vvd += sheetObj.CellValue(Row, prefix+"rev_dir_cd");

    		if (vvd.length == 10){
    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    		}
    	}*/
    }

	/* 개발자 작업  끝 */