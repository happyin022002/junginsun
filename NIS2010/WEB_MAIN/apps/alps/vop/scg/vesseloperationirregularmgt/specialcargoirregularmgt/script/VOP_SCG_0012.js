-/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0012.js
*@FileTitle : SPCL CGO Irregular List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.16 김현욱
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
     * @class vop_scg_0012 : vop_scg_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0012() {
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
    
    // 업무 자바스크립트 OnKeyPress 이벤트 Catch
    function initControl() {
        // Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
        axon_event.addListenerFormat ('focus',    'obj_activate',   form);
        axon_event.addListenerFormat ('blur', 	  'obj_deactivate', form);
        axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   form);
        axon_event.addListenerForm   ("keyup",    'obj_keyup',      form);
    }
    
    // 업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break; 
    	}
    }  
    
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
    	// 마스크 구분자 없애기
    	ComClearSeparator (event.srcElement);
    }

    // 업무 자바스크립트 OnBlur 이벤트 처리
    function obj_deactivate() {
    	with(event.srcElement) {
    		if(value != '' && (name == 'irr_occr_from_dt' || name == 'irr_occr_to_dt')) {
		    	// 하나의 컨트롤의 Validation을 확인 + 마스크 구분자 더하기
		    	var rslt = ComChkObjValid(event.srcElement, false, true, true);
		    	if(!rslt) {
		    		ComShowMessage(ComGetMsg('COM12134', caption));
		    		value = "";
		    		focus();
		    		select();
		    	}
    		}
    	}
    }
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	obj_nextfocus(event.srcElement);
    }  
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		with(event.srcElement) {
        		if(name == 'irr_occr_from_dt') {
        			if(event.keyCode >= 48 && event.keyCode <=57 ) ComSetNextFocus(obj);
        		} else if(name == 'irr_occr_to_dt') {
        			obj.blur();
        		}
    		}
    	}
    }
    
    // 업무 자바스크립트 Lane OnKeyDown 이벤트 처리
    function vsl_slan_cd_OnKeyDown(comboObj, KeyCode, Shift) {
    	//영문대문자 입력하기
    	comboObj.Text = comboObj.Text.toUpperCase();
    }  
    
    // 업무 자바스크립트 Class OnChange 이벤트 처리
    function imdg_clss_cd_OnChange(comboObj, Index_Code, Text) {
    	//Class Comp Combo 조회
    	initCombo(comboObjects[6], 7, document.form);
    }  

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var prefix = "sheet1_";
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var loadCt = 0;
    
    // Dangerous Goods 와 Awkward Cargo 와 관련된 항목들
    var dgStr = "|imdg_un_no|imdg_un_no_seq|imdg_clss_cd";	//Dangerous Goods
    var acStr = "|spcl_cgo_cate_cd|dim_len|dim_wdt|dim_hgt|por_cd|pol_cd|pod_cd|del_cd|s_cust_nm|c_cust_nm";	//Awkward Cargo
    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
         
         var sheetObj = sheetObjects[0];
         
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObj,formObj,IBCLEAR);
					break;
					
				case "btn_DownExcel":
                    var paramObj = new Object();
                    paramObj.title = "SPCL CGO Irregular List";
                    var url = ComScgGetPgmTitle(sheetObj, paramObj);  
                    sheetObj.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
					
//					sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"SPCL CGO Irregular List",false);
					break;
					
				case "irr_spcl_cgo_cate_cd":
					setOptionInfo(sheetObj, formObj, false);	//Option에 따라 
					break;	
					
				case "btn_calendar":					
					var cal = new ComCalendarFromTo();
		            cal.select(formObj.irr_occr_from_dt, formObj.irr_occr_to_dt, "yyyy-MM-dd");	//날짜 선택 달력열기   	
   	                break;
				case "btn_Close": case "btn_Close2":
                    window.close();
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
    function loadPage(comboItems) {
    	
    	//Sheet 초기화
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet (sheetObjects[i] );	
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);	
        }
        
        //Combo 초기화
        var elseCt = 0;
        for(var k=0;k<comboObjects.length;k++){
        	//Irregulars Type, AWK Type 외
            if(k != 4 && k != 8) { 
            	addComboItem(comboObjects[k], comboItems[elseCt], comboItems[elseCt]);
            	elseCt++;
            }
        }
        
        //Listener 등록
        initControl();
        
        // 마스크 구분자 더하기
    	controlMask("irr_occr_from_dt|irr_occr_to_dt", true);
    	
    	//Pre Condition & Pop
        if(preConds.pop_mode == 'Y' && preConds.imdg_un_no != '') {
       	 	//Set condition's values
	        document.all.imdg_un_no.Code   = preConds.imdg_un_no;
       	 	
       	 	searchList(sheetObjects[0], document.form);
        }
    	
    }
     
    function sheet1_OnLoadFinish(sheetObj) {	
    	//Combo 초기화
    	var elseCt = 0;
    	for(var k=0;k<comboObjects.length;k++){
    		//Irregulars Type, AWK Type
    		if(k==4 || k==8) initCombo(comboObjects[k],k+1,document.form);
    	}
    	searchUseVopScg0012ToPopup();
    	
    	//Pre Condition & Pop
    	if(preConds.pop_mode == 'Y' && preConds.imdg_un_no != '') {   	 	
       	 	searchList(sheetObj, document.form);
        }
    }
    
    /**
     * SPCL CGO Irregular Inquery 화면 팝업 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col,Value) {	
		var sParam = Array();
		sParam[0] = "vsl_cd="+sheetObj.CellValue(Row, prefix+"vsl_cd");
		sParam[1] = "skd_voy_no="+sheetObj.CellValue(Row, prefix+"skd_voy_no");
		sParam[2] = "skd_dir_cd="+sheetObj.CellValue(Row, prefix+"skd_dir_cd");
		sParam[3] = "spcl_cgo_irr_seq="+sheetObj.CellValue(Row, prefix+"spcl_cgo_irr_seq");
		sParam[4] = "ofc_cd="+sheetObj.CellValue(Row, prefix+"ofc_cd");
		
        ComOpenWindowCenter("VOP_SCG_0075.do?"+sParam.join("&"), "winDtl", "1040", "700", true, "yes");
		
		return;
	}
    
    /**
     * 마스크 구분자 변환하기
     * param : objStr ==> 오브젝트('cd1|cd2'), sFlg ==> true:Add, false:Remove
     */	
    function controlMask(objStr, sFlg) {
    	var objStr = objStr.split("|");
    	for (var i = 0; i<objStr.length; i++){
    		if(sFlg) ComAddSeparator (eval("document.form."+objStr[i]));   
    		else ComClearSeparator (eval("document.form."+objStr[i]));   
        }	
    }
    
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo, formObj) {
    	
    	switch(comboObj.id) {
	        case "spcl_cgo_irr_tp_cd":
	            with(comboObj) {
	            	SetTitle("Name|Code|Description");
	            	SetColWidth("100|50|200");
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;	   
	    }
    	
        switch(comboNo) {  
        	case 1: 
        		//Lane Combo 조회
        		searchCombo(SEARCH01, "VOP_SCG_0012GS.do", "vsl_slan_cd", "vsl_slan_cd", "vsl_slan_cd");
     			break; 
        	case 2: 
        		//Vessel Combo 조회
        		searchCombo(SEARCH02, "VOP_SCG_0012GS.do", "vsl_cd", "vsl_cd", "vsl_cd");
     			break;
        	case 3: 
        		//VSL OPR Combo 조회
        		searchCombo(SEARCH03, "VOP_SCG_0012GS.do", "vsl_opr_tp_cd", "crr_cd", "crr_cd");
     			break;
        	case 4: 
        		//CGO OPR Combo 조회
        		searchCombo(SEARCH04, "VOP_SCG_0012GS.do", "cgo_opr_cd", "crr_cd", "crr_cd");
     			break;
        	case 5: 
        		//Irregulars Type Combo 조회
        		searchIrregularType();
     			break;
        	case 6: 
        		//Class Combo 조회
        		searchCombo(SEARCH05, "VOP_SCG_0012GS.do", "imdg_clss_cd", "imdg_clss_cd", "imdg_clss_cd");
     			break;
        	case 7: 
        		//Class Comp Combo 조회
        		var sOption = getObjValue("imdg_clss_cd");
         	    searchCombo(SEARCH06, "VOP_SCG_0012GS.do", "imdg_comp_grp_cd", "imdg_comp_grp_cd", "imdg_comp_grp_cd", "imdg_clss_cd="+sOption);
     			break;
        	case 8: 
        		//UN No. Combo 조회
        		searchCombo(SEARCH07, "VOP_SCG_0012GS.do", "imdg_un_no", "imdg_un_no", "imdg_un_no");
     			break;
        	case 9: 
        		//AWK Type Combo 채우기
        		addComboItem(comboObj, "AK|RF|BB", "Awkward|Reefer|Break-Bulk");
     			break;
        	case 10: 
        		//POR Combo 조회
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "por_cd", "loc_cd", "loc_cd","loc_tp_cd=POR");
     			break;
        	case 11: 
        		//POL Combo 조회
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "pol_cd", "loc_cd", "loc_cd","loc_tp_cd=POL");
     			break;
        	case 12: 
        		//POD Combo 조회
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "pod_cd", "loc_cd", "loc_cd","loc_tp_cd=POD");
     			break;
        	case 13: 
        		//DEL Combo 조회
        		searchCombo(SEARCH08, "VOP_SCG_0012GS.do", "del_cd", "loc_cd", "loc_cd","loc_tp_cd=DEL");
     			break;
     	} 
    }
    
    /**
     * Combo 채우기
     */	
    function addComboItem(comboObj, itemValStr, itemTxtStr) {
    	var itemValArr = itemValStr.split("|");
        var itemTxtArr = itemTxtStr.split("|");
    	for (var i = 0; i<itemValArr.length; i++){
    		comboObj.InsertItem(i, itemTxtArr[i], itemValArr[i]);    	
        }	
    }
     /**
      * 
      * <pre>
      *    VOP_SCG_0012를 Main으로 사용하기.
      * </pre>
      *
      * @param void   
      * @return void
      * @author jang kang cheol
      */
    function searchUseVopScg0012ToPopup(){
        var formObj = document.form;
        var docAll = document.all;
        var imdg_un_no = formObj.pImdg_un_no.value; 
 
        if( imdg_un_no != "" ){
                 formObj.imdg_un_no.Code2 = imdg_un_no;
                 if(formObj.imdg_un_no.Index > -1){
                     docAll.btn_Retrieve.fireEvent('onclick');
                 }
        }
    }
    /**
     * Combo 조회
     */
    function searchCombo(searchType, url, combId, combCd, combNm, etcParam) {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	//sheetObj.Redraw = false;
    	formObj.f_cmd.value = searchType;
 	   	var sXml = sheetObj.GetSearchXml(url, FormQueryString(formObj)+"&"+etcParam); 	   	
 	    
 	   	//Combo 채우기
 	    ComXml2ComboItem(sXml, eval("document.form."+combId), combCd, combNm);
 	    //sheetObj.Redraw = true;
    }
    
    /**
     * Irregulars Type Combo 조회
     */	
    function searchIrregularType() {
    	var sOption = getObjValue("irr_spcl_cgo_cate_cd");
    	var sParam;
	 	   
		if(sOption == 'DG') sParam = "dg_flg=Y";
		else if(sOption == 'AC') sParam = "awk_flg=Y";
		
 	    searchCombo(SEARCH04, "SCG_COM_INTERNALGS.do", "spcl_cgo_irr_tp_cd", "spcl_cgo_irr_tp_cd", "spcl_cgo_irr_tp_nm|spcl_cgo_irr_tp_cd|spcl_cgo_irr_tp_desc", sParam);
 	     	    
 	   return sOption;
    }
    
    /** 
  	 * Option의 변경에 따라 UI변경
  	 */ 
  	function setOptionInfo(sheetObj, formObj, forceYn) {  
  		
  		var sOption = searchIrregularType();	//Irregulars Type Combo 조회
  		var sOrslt = false;
  		
  		if(sOption == 'DG' || sOption == '') sOrslt = true;
  		
  		for (var i = 5; i<13; i++){  	
  			if(!forceYn) {
	  			if(i == 8 && sOption != '') comboObjects[i].Enable = !sOrslt;
	  			else comboObjects[i].Enable = sOrslt;
  			} else {
  				comboObjects[i].Enable = true;
  			}
  			
  			comboObjects[i].Index = "";
        }
  		
  		var saveName;
  		for(var colIdx = 1; colIdx<=sheetObj.LastCol-5; colIdx++) {
  			if (sheetObj.ColHidden(colIdx)) sheetObj.ColHidden(colIdx) = false;
  			
  			saveName = sheetObj.ColSaveName(colIdx);
  			saveName = saveName.substring(7,saveName.length);
  			if(sOption == 'DG') {
  				if(acStr.indexOf(saveName) != -1) sheetObj.ColHidden(colIdx) = true;
  			} else if(sOption == 'AC') {
  				if(dgStr.indexOf(saveName) != -1) sheetObj.ColHidden(colIdx) = true;
  			}
  			
  			//초기화
  			sheetObj.RemoveAll();
  				
  		}
  	}
    
    /**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
               with (sheetObj) {
                    // 높이 설정
                    style.height = 370;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 13, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle1 = "Date|VVD CD|Lane|VSL OPR|Type|BKG Ref. No.|Cgo OPR|CNTR No.|TP/SZ|CGO Type|CGO Seq.|UN No./Seq.|UN No./Seq.|Class|Weight(kg)|Weight(kg)|Dimension(cm)|Dimension(cm)|Dimension(cm)|POR|POL|POD|Delivery|Shipper|Consignee|||||";
                    var HeadTitle2 = "Date|VVD CD|Lane|VSL OPR|Type|BKG Ref. No.|Cgo OPR|CNTR No.|TP/SZ|CGO Type|CGO Seq.|UN No.|Seq.|Class|Gross|Net|L|W|H|POR|POL|POD|Delivery|Shipper|Consignee|||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,		    70,	    daCenter,	true,		prefix+"irr_occr_dt",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    90,	    daCenter,	true,		prefix+"vvd_cd",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    50,	    daCenter,	true,		prefix+"vsl_slan_cd",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    55,	    daCenter,	true,		prefix+"vsl_opr_tp_cd",			false,           "",      dfNone, 			0,     true,       true);
					                                                    
					InitDataProperty(0, cnt++ , dtData,		    80,    daCenter,	true,		prefix+"spcl_cgo_irr_tp_nm",	false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    80,     daCenter,	true,		prefix+"bkg_no",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"cgo_opr_cd",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    80,	    daCenter,	true,		prefix+"cntr_no",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"cntr_tpsz_cd",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"spcl_cgo_cate_cd",		false,           "",      dfNone, 			0,     true,       true);
					                                                                
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"cgo_seq",	            false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    75,	    daCenter,	true,		prefix+"imdg_un_no",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    40,	    daCenter,	true,		prefix+"imdg_un_no_seq",		false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"imdg_clss_cd",			false,           "",      dfNone, 			0,     true,       true);
					                                                                
					InitDataProperty(0, cnt++ , dtData,		    70,	    daRight,	false,		prefix+"awk_cgo_grs_wgt",		false,           "",      dfFloat, 			3,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    70,	    daRight,	false,		prefix+"awk_cgo_net_wgt",		false,           "",      dfFloat, 			3,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    70,	    daRight,	false,		prefix+"dim_len",				false,           "",      dfFloat, 			2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    70,	    daRight,	false,		prefix+"dim_wdt",				false,           "",      dfFloat, 			2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    70,	    daRight,	false,		prefix+"dim_hgt",				false,           "",      dfFloat, 			2,     true,       true);
					                                                                
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"por_cd",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"pol_cd",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"pod_cd",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	    daCenter,	true,		prefix+"del_cd",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    200,    daCenter,	true,		prefix+"s_cust_nm",				false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    200,    daCenter,	true,		prefix+"c_cust_nm",				false,           "",      dfNone, 			0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefix+"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefix+"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefix+"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefix+"spcl_cgo_irr_seq");
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefix+"ofc_cd");

					DataLinkMouse = true;
               }
               break;
        }
        
        return true;
    }
     
    /**
     * Search after loading all of objects
     */
    function searchList(sheetObj, formObj) {
    	loadCt++;
     	if(loadCt == 2) doActionIBSheet(sheetObj,formObj,IBSEARCH); 
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회

        		if(!validateForm(sheetObj,formObj,sAction)) return true;

        		formObj.f_cmd.value = SEARCH;		
        	   
        		//마스크 구분자 제거하기
           	   	controlMask("irr_occr_from_dt|irr_occr_to_dt", false);
        	   
           	   	sheetObj.DoSearch("VOP_SCG_0012GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));	
        	   
           	   	//마스크 구분자 더하기
           	   	controlMask("irr_occr_from_dt|irr_occr_to_dt", true);

           	   	break;

        	case IBCLEAR:      
        		ComResetAll();
	        	//마스크 구분자 더하기
	           	controlMask("irr_occr_from_dt|irr_occr_to_dt", true);
	           	//Combo 활성
	           	setOptionInfo(sheetObj, formObj, true);
        		   
	           	break;

        	case IBINSERT:      // 입력
        		break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(!ComChkValid(formObj, true, false, false)) 
    		return false;

        return true;
    }

	/* 개발자 작업  끝 */