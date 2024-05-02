/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0018.js
*@FileTitle : Land Inventory With CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.06.08 김종준
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.07.11 신자영 [CHM-201112083-01] Land Inventory With CNTR List 화면의 POL, POD 컬럼 추가 요청
* 2012.02.08 신자영 [CHM-201216058-01] [CIM] Land Inventory with cntr list 기능 보완
* 2012.02.27 신자영 [CHM-201216476-01] LAND INVENTORY / LANDINVENTORY WITH CNTR LIST 기능 수정
* 2013.11.25 이영두 [CHM-201327634-01] [CIM] DG 조회 옵션 추가 요청
=========================================================*/

	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0 ;
	
	var head_cntr_tpsz_cd ="";
	var headTitle ="";
	var tot_cnmv_sts_cd ="";
	var tot_lstm_cd ="";
	
	var IBSEARCH01  = 29;
	var IBSEARCH02  = 30;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	     var shtCnt = 0;
	     var sheetObject = sheetObjects[shtCnt++];
	              
	     /*******************************************************/
	     var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":
					sheetObjects[0].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
		        case "btn_new":
		        	formObject.reset();
					comboObjects[0].Code = '';
					comboObjects[1].Code = '';
					comboObjects[2].Code = '';
					sheetObjects[0].RemoveAll();
				    document.form.view_flg[0].checked = true;
				    view_flg_click(); 
				    setHeadData(sheetObjects[0])
				    document.form.loc_cd.focus();
			    
					break;
				case "btn_loc_cd":	//Location 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_type_code.value;
		            loc_cd = formObject.loc_cd.value;
		            if ( formObject.loc_type_code.value != '0' ) {	
						if ( formObject.loc_type_code.value == '5' ) {	//yard
							var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 800, 480, "3:loc_cd", "1,0,1,1,1,1,1", true);
		           		} else {
		        			var loc_code = "";
		        			
		        			if ( form.loc_type_code.value == "1" )  {
		        				loc_code = "rcc_cd";
		        			} else if ( form.loc_type_code.value == "2" ) {
		        				loc_code = "lcc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code = "ecc_cd";
		        			} else if ( form.loc_type_code.value == "4" ) {
		        				loc_code = "scc_cd";
		        			}
							var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);		           		
		           		}
		            }
					break;
				case "btn_movement":

					if ( sheetObjects[0].rowCount != 0 ) {
		                var cnmv_dt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cnmv_dt");
		                ComOpenWindowCenter("/hanjin/EES_CTM_0408.do?" +
		                                    "p_cntrno=" 	+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no").substring(0,10) + "&" +
		                                    "check_digit=" 	+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no").substring(10,11) + "&" +
		                                    "ctnr_tpsz_cd=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_tpsz_cd") + "&" +
		                                    "p_date1=" 		+ ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
		                                    "p_date2=" 		+ ComGetDateAdd(cnmv_dt, "M", 0, "-", true) + "&" +
		                                    "pop_mode=1"
		                                    ,"EES_CTM_0408", 1020, 682);						
					}
					break;
				case "btn_master":
					if ( sheetObjects[0].rowCount != 0 ) {
						var cntr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no");
						var cntr_no_len =cntr_no.length;
						if ( cntr_no_len > 10 ) {
							cntr_no = cntr_no.substring(0,10);
						} 
						ComOpenPopup("/hanjin/EES_MST_0019.do?cntr_no="+cntr_no+"&popup_mode=Y",1100, 690, "", "1,0,1,1,1,1,1,1", true);
					}
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;
		        case "btn_print":
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
     * Location by loc_cd 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        formObject.loc_cd.value = aryPopupData[0][3] 
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
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
      
    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();     	
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
        document.form.loc_cd.focus();
    } 
    
    /**
     * Period,HEAD,TPSZ 데이타 가져오기
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBSEARCH01); //Period,HEAD,TPSZ 데이타 가져오기
    	ComSetFocus(document.form.loc_cd);
    }
    
    /**
     * MVMT Status 생성
     */    
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        //MVMT Status
        var arr_cnmv_sts_cd = cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm = cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd = arr_cnmv_sts_cd;
        with (form.cnmv_sts_cd) {
        	MultiSelect = true;
            MultiSeparator = ",";
            DropHeight = 320;
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }
    
    /**
     * 초기 이벤트 등록
     */
	function initControl() {
     	axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', 'next_vvd');			//cntr_no keyup 이벤트 처리
     	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd', '');					//LOC_CD keyup 이벤트 처리
     	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     	axon_event.addListener('click', 'view_flg_click', 'view_flg');						//view 변경시 이벤트 처리
     	axon_event.addListener('click', 'ts_cntr_behind_click', 'ts_cntr_behind');			//EQ-wise,BKG-wise   변경시 이벤트 처리
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);					//알파벳 대문자,숫자만 입력허용
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');	//Location by 변경시 이벤트 처리
	
	}

	/**
     * TP/SZ 클릭 이벤트 처리
    */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
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
     * MVMT Status  클릭 이벤트 등록
    */
    function cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
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
     * Lease Term  클릭 이벤트 등록
    */    
    function lstm_cd_OnCheckClick(comboObj, index, code) {
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
    * Location by 변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
    function loc_type_code_onchange() {
        var formObject = document.form;
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }
	
	/**
     * 키이벤트 등록
    */  
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "over_stay_days":
				ComKeyOnlyNumber(event.srcElement);// 알파벳 대문자,숫자만 입력허용
				break;
			case "froms":
				// 숫자만 + "-"만 입력허용
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "tos":
				// 숫자만 + "-"만 입력허용
				ComKeyOnlyNumber(event.srcElement);
				break;
		}
	}

    /**
     * Location  beforeactivate 이벤트 처리
     * Location  beforeactivate -없애기
     */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	/**
	 * Location  beforedeactivate 이벤트 처리
	 * Location  beforedeactivate YYYY 포멧 처리
	 */	
	function obj_deactivate() {
		var f = document.getElementById("froms");
		var t = document.getElementById("tos");
		sVal1 = f.value.replace(/\/|\-|\./g, "");
		sVal2 = t.value.replace(/\/|\-|\./g, "");

		switch (event.srcElement.name) {
		case "froms":
			if (ComChkObjValid(event.srcElement, false)) {
				if (f.getAttribute("dataformat") == "yyyy") {
					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							if (event.srcElement.name == "tos") {
								event.srcElement.value = "";
								ComShowCodeMessage("CIM29046");
								enterSwitch = false;
								t.focus();
								t.select();
								return false;
							} else {
								event.srcElement.value = "";
								ComShowCodeMessage("CIM29046");
								enterSwitch = false;
								f.focus();
								f.select();
								return false;
							}
						} 
						enterSwitch = true;
					}
				} 
			} else {
				if (f.getAttribute("dataformat") == "yyyy") {
					if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'froms') {

						enterSwitch = false;
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYY");
						event.srcElement.focus();
						event.srcElement.select();
						return false;
					}
				} 
			}
			break;
		case "tos":
			if (ComChkObjValid(event.srcElement, false)) {
				if (t.getAttribute("dataformat") == "yyyy") {
					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							if (event.srcElement.name == "tos") {
								event.srcElement.value = "";
								ComShowCodeMessage("CIM29046");
								enterSwitch = false;
								t.focus();
								t.select();
								return false;
							} else {
								event.srcElement.value = "";
								ComShowCodeMessage("CIM29046");
								enterSwitch = false;
								f.focus();
								f.select();
								return false;
							}
						} 
						enterSwitch = true;
					}
				} 
			} else {
				if (t.getAttribute("dataformat") == "yyyy") {
					if (sVal2.length > 0 && !ComIsDate(sVal2) && event.srcElement.name == 'tos') {

						enterSwitch = false;
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYY");
						event.srcElement.focus();
						event.srcElement.select();
						return false;
					}
				}
			}

			break;
		}
		return true;
	}
	
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}

	
    /**
	* view_flg keyup 이벤트 처리
	* view_flg keyup시 대분자로 처리
	*/
    function view_flg_click() {
    	if ( document.form.view_flg[1].checked ) {
    		document.form.ts_cntr_behind.readOnly = false;
    		document.form.ts_cntr_behind.disabled = false;
    		document.form.ts_cntr_behind.className = "input";
    		
    		document.form.view_customer.checked = true;
    		document.form.view_commodity.checked = true;
    		
    		document.form.froms.value="";
    		document.form.tos.value="";
    		
    		div_eq.style.display = "none";
    		div_bkg.style.display = "";
    	} else {
    		document.form.ts_cntr_behind.readOnly = true;
    		document.form.ts_cntr_behind.disabled = true;
    		document.form.ts_cntr_behind.checked = false;
    		document.form.ts_cntr_behind.className = "input2";
    		document.form.next_vvd.disabled = true;
    		document.form.next_vvd.className = "input2";
    		document.form.next_vvd.value = "";    		
    		
    		document.form.view_customer.checked = false;
    		document.form.view_commodity.checked = false;
    		div_eq.style.display = "";
    		div_bkg.style.display = "none";
    	}
    }
    
    /**
	* view_flg keyup 이벤트 처리
	* view_flg keyup시 대분자로 처리
	*/
    function ts_cntr_behind_click() {
    	if ( document.form.ts_cntr_behind.checked ) {
    		document.form.next_vvd.disabled = false;
    		document.form.next_vvd.className = "input";
    		document.form.next_vvd.readOnly = false;
    	} else {
    		document.form.next_vvd.disabled = true;
    		document.form.next_vvd.readOnly = true;
    		document.form.next_vvd.className = "input2";
    		document.form.next_vvd.value = "";
    	}
    }
    
    /**
	* LOC_CD keyup 이벤트 처리
	* LOC_CD keyup시 대분자로 처리
	*/
    function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        if ( formObject.loc_type_code.value == '5' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",7);
	        	    formObject.loc_cd.value = formObject.loc_cd.value.substring(0,7).toUpperCase();
	        	    if ( formObject.loc_cd.value.length == 7 ) {
	        	    	ComSetFocus(document.form.full_flg);
	        	    }
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
	      	   if ( formObject.loc_cd.value.length == 5 ) {
	    		   ComSetFocus(document.form.full_flg);
	    	   }
	        }
        }
    }
	
    
    /**
    * cntr_no keyup 이벤트 처리
    * cntr_no keyup시 대분자로 처리
    */
    function cntr_no_onkeyUp() {
        var formObject = document.form;
        formObject.cntr_no.value = formObject.cntr_no.value.toUpperCase();
        formObject.next_vvd.value = formObject.next_vvd.value.toUpperCase();
    }

    /**
	* view_customer click 이벤트 처리
	* shpr cnee ntfy 정보 view or unview	
	*/	
    function view_customer_click() {
    	if ( document.form.view_customer.checked ) {
    		sheetObjects[0].ColHidden("shpr") = false;
    		sheetObjects[0].ColHidden("cnee") = false;
    		sheetObjects[0].ColHidden("ntfy") = false;
    	} else {
    		sheetObjects[0].ColHidden("shpr") = true;
    		sheetObjects[0].ColHidden("cnee") = true;
    		sheetObjects[0].ColHidden("ntfy") = true;
    	}
    }
    
    /**
	* view_commodity_click click 이벤트 처리 
	* rep_cmdt_nm, mk_desc 정보 view or unview	
	*/	
    function view_commodity_click() {
    	if ( document.form.view_commodity.checked ) {
    		sheetObjects[0].ColHidden("rep_cmdt_nm") = false;
    		sheetObjects[0].ColHidden("mk_desc") = false;
    	} else {
    		sheetObjects[0].ColHidden("rep_cmdt_nm") = true;
    		sheetObjects[0].ColHidden("mk_desc") = true;
    	}
    }

    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,headTitle,viewFlag) {

        var cnt = 0;
        switch(sheetNo) {
        	case 1:      //sheet1 init
        		with (sheetObj) {
                    // 높이 설정
        			style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 26, 100);
                    if (headTitle==null || headTitle =="") {
                    	viewFlag = 'eq';
                        headTitle  = "Seq.|Sub Loc.|Yard|CNTR No.|TP/SZ|Term|AGMT No.|MVMT|F/M|Event Date|S.Days|R/D Term|BKG No.|B/L No.|SHPR|";
                        headTitle += "CNEE|NTFY|Off Hire|Off Hire|DMG|HRT|HBT|HBQ|DP|IM|UC|PF|DG|PSA Group|CMDT|CMDT(Customs)|Lessor|M/Date";
                    }
                    headTitle  += "|ydnm";
                    
                    var headCount = ComCountHeadTitle(headTitle);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle, true);
                    sheetObj.FrozenCols = 4;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,			40,		daRight,	true,	"Seq",						false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,	"sub_loc_cd",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,	"crnt_yd_cd",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				80,   	daCenter,	true,	"cntr_no",   				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,	true,	"cntr_tpsz_cd",     		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,  	true,	"lstm_cd",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				70,   	daCenter,  	true,	"agmt_no",      			false,	"",	dfNone);

                    InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,  	true,	"cnmv_sts_cd",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				30,   	daCenter,  	true,	"full_flg",     			false,	"",	dfNone);

                	InitDataProperty(0, cnt++ , dtData,				70,   	daCenter,  	true,	"cnmv_dt",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				50,   	daRight,  	true,	"stay_days",     			false,	"",	dfNullInteger);
                    if ( viewFlag == 'eq') {
                    	if ( eval(document.form.over_stay_days.value) > 0 ) {
		                    InitDataProperty(0, cnt++ , dtData,			45, 	daRight,	false,	"ft_dys",					false,	"",	dfNullInteger,			0,		false,	true);
		                    InitDataProperty(0, cnt++ , dtData,			70, 	daCenter,	false,	"ft_end_dt",	 			false,	"",	dfDateYmd,				0,		false,	true);
		                    InitDataProperty(0, cnt++ , dtData,			60, 	daRight,	false,	"act_dys",					false,	"",	dfNullInteger,			0,		false,	true);
                    	}
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"de_term_cd",     			false,	"",	dfNone);
                    }
                    
                    InitDataProperty(0, cnt++ , dtData,				90,   	daCenter,  	true,	"bkg_no",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				90,   	daCenter,  	true,	"bl_no",     				false,	"",	dfNone);
                    if ( viewFlag == 'bkg') {
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"por_cd",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"pol_cd",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"pod_cd",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"del_cd",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"lane1",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			75,   	daCenter,  	true,	"vvd",     					false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"lane2",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			75,   	daCenter,  	true,	"next_vvd",     			false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			70,   	daCenter,  	true,	"pol_etd",     				false,	"",	dfNone);
                    }
                    InitDataProperty(0, cnt++ , dtData,				100,   	daLeft,  	true,	"shpr",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				100,   	daLeft,  	true,	"cnee",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				100,   	daLeft,  	true,	"ntfy",     				false,	"",	dfNone);
                    if ( viewFlag == 'bkg') {
                    	InitDataProperty(0, cnt++ , dtData,			100,   	daCenter,  	true,	"sc_rfa_no",     			false,	"",	dfNone);
                    }
                    if ( viewFlag == 'eq') {
                    	InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"off_hire",     			false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			50,   	daCenter,  	true,	"dmg_flg",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			45,   	daCenter,  	true,	"cntr_hngr_rck_cd",     	false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			45,   	daCenter,  	true,	"mnr_hngr_bar_tp_cd",     	false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			40,   	daRight,  	true,	"cntr_hngr_bar_atch_knt",	false,	"",	dfNullInteger);
	                    InitDataProperty(0, cnt++ , dtData,			40,   	daCenter,  	true,	"disp_flg",     			false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			40,   	daCenter,  	true,	"imdt_ext_flg",     		false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			40,   	daCenter,  	true,	"uclm_ls_flg",     			false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			40,   	daCenter,  	true,	"plst_flr_flg",     		false,	"",	dfNone);
                    }
                    if ( viewFlag == 'bkg') {
                    	InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"de_term_cd",     			false,	"",	dfNone);
                    	InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"rf_tp_cd",     			false,	"",	dfNone);
                    }
                    
                    InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,  	true,	"dg_flg",     			    false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				65,   	daCenter,  	true,	"psa_no",     			    false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				200,   	daLeft,  	true,	"rep_cmdt_nm",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				200,   	daLeft,  	true,	"mk_desc",    				false,	"",	dfNone);
                    if ( viewFlag == 'bkg') {
                    	InitDataProperty(0, cnt++ , dtData,			70,   	daCenter,  	true,	"ob_sls_ofc_cd",     		false,	"",	dfNone);
                    }
                    if ( viewFlag == 'eq') {
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"lessor",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			80,   	daCenter,  	true,	"mft_dt",     				false,	"",	dfDateYmd);
                    }
                    if ( viewFlag == 'bkg') {
                    	if ( document.form.loc_cd.value.substring(0,2) == 'US' ) {
		                    InitDataProperty(0, cnt++ , dtData,			80,   	daCenter,  	true,	"pkup_no",     				false,	"",	dfDateYmd);
		                    InitDataProperty(0, cnt++ , dtData,			40,   	daCenter,  	true,	"frt_clt_flg",     			false,	"",	dfDateYmd);
		                    InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"obl_rdem_flg",     		false,	"",	dfDateYmd);
		                    InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"cstms_clr_flg",     		false,	"",	dfDateYmd);
		                    InitDataProperty(0, cnt++ , dtData,			70,   	daCenter,  	true,	"dty_free_dt",     			false,	"",	dfNone);
                    	}
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daRight,  	true,	"gwgt",     				false,	"",	dfNullInteger);
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daRight,  	true,	"pwgt",     				false,	"",	dfNullInteger);
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daRight,  	true,	"twgt",     				false,	"",	dfNullInteger);
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daRight,  	true,	"bwgt",     				false,	"",	dfNullInteger);
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"lessor",     				false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			80,   	daCenter,  	true,	"mft_dt",     				false,	"",	dfDateYmd);
             
	                    // cnmv_sts_cd = 'ID' 인 경우만 SP Code, SP Name, Phone No, E-Mail 항목 보여줌
	                    InitDataProperty(0, cnt++ , dtData,			60,   	daCenter,  	true,	"vndr_seq",     			false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			100,   	daLeft,  	true,	"vndr_lgl_eng_nm",     		false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			120,   	daCenter,  	true,	"phn_no",     			    false,	"",	dfNone);
	                    InitDataProperty(0, cnt++ , dtData,			150,   	daLeft,  	true,	"vndr_eml",     			false,	"",	dfNone);
                    }
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	"yd_nm",				false,	"",			dfNone,			0);
               }
               break;
        }
    }
    
    /**
     * 시트 헤더 세팅
     * EQ-wise,BKG-wise에 체크 여부에 따른 헤더부분 변경
     */
    function setHeadData(sheetObj) {
	 	var headTitle ="";
	 	var viewFlag = "";
	 	var subLoc = "";
	 	if ( document.form.loc_type_code.value == '1') {
	 		subLoc = "LCC";
	 	} else if  ( document.form.loc_type_code.value == '2') {
	 		subLoc = "SCC";
	 	} else if  ( document.form.loc_type_code.value == '3') {
	 		subLoc = "SCC";
	 	} else if  ( document.form.loc_type_code.value == '4') {
	 		subLoc = "SCC";
	 	} else if  ( document.form.loc_type_code.value == '5') {
	 		subLoc = "SCC";
	 	}
	 	if ( document.form.view_flg[0].checked == true ) {	  //EQ-wise
            headTitle  = "Seq.|"+subLoc+"|Yard|CNTR No.|TP/SZ|Term|AGMT No.|MVMT|F/M|Event Date|S.Days";
            if ( eval(document.form.over_stay_days.value) > 0 ) {
            	headTitle += "|F.Days|End Date|Act S.Ds";
            }
            headTitle += "|R/D Term|BKG No.|B/L No.|SHPR|";
            headTitle += "CNEE|NTFY|Off Hire|DMG|HRT|HBT|HBQ|DP|IM|UC|PF|DG|PSA Group|CMDT|CMDT(Customs)|Lessor|M/Date";
		 	viewFlag ="eq";
	 	} else {	  //BKG-wise
	 		var strPolEtc = '';
	 		if (document.form.ts_cntr_behind.checked && (document.form.next_vvd.value == '' || document.form.next_vvd.value != '') ) {
	 			strPolEtc = 'POL ATD';
	 		} else if ( !document.form.ts_cntr_behind.checked && document.form.next_vvd.value == '' ) {
	 			strPolEtc = 'POL ETD';
	 		}
            headTitle  = "Seq.|"+subLoc+"|Yard|CNTR No.|TP/SZ|Term|AGMT No.|MVMT|F/M|Event Date|S.Days|BKG No.|B/L No.|POR|POL|POD|DEL|Lane|Disc VVD|Lane|Load VVD|"+strPolEtc+"|SHPR|";
            headTitle += "CNEE|NTFY|SC/RFA No.|R/D Term|RF TP|DG|PSA Group|CMDT|CMDT(Customs)|Sales OFC";
            if ( document.form.loc_cd.value.substring(0,2) == 'US' ) {
            	headTitle += "|IT No.|F|O|C|LFD";
            }
            headTitle += "|G.WGT|P.WGT|T.WGT|B.WGT|Lessor|M/Date";
            
            // cnmv_sts_cd = 'ID' 인 경우만 SP Code, SP Name, Phone No, E-Mail 항목 보여줌
            headTitle += "|SP Code|SP Name|Phone No|E-Mail";

            
		 	viewFlag ="bkg";
	 	}
	 	sheetObj.Redraw = false;
	 	sheetObj.RemoveAll();
	 	sheetObj.Reset();
	 	initSheet(sheetObjects[0],1,headTitle,viewFlag);
	 	sheetObj.Redraw = true;                    
    }
    
    /**
     * Sheet관련 프로세스 처리
     */    
    function doActionIBSheet(sheetObj, formObj, sAction, cnmv_sts_cd , cnmv_sts_nm) {
//        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {

	      	case IBSEARCH:      //조회
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 
	            formObj.cnt_cd.value = formObj.loc_cd.value.substring(0,2);	  //미주 구분자
	            setHeadData(sheetObj);	  //EQ-wise,BKG-wise에 체크 여부에 따른 헤더부분 변경
	            view_customer_click();
	            view_commodity_click(); 
	            
	            // cnmv_sts_cd = 'ID' 인 경우만 SP Code, SP Name, Phone No, E-Mail 항목 보여줌
	            if (formObj.cnmv_sts_cd.text == 'ID') {
	            	sheetObj.ColHidden("vndr_seq")        = false;
	            	sheetObj.ColHidden("vndr_lgl_eng_nm") = false;
	            	sheetObj.ColHidden("phn_no")          = false;
	            	sheetObj.ColHidden("vndr_eml")        = false;
	            }
	            else {
	            	sheetObj.ColHidden("vndr_seq")        = true;
	            	sheetObj.ColHidden("vndr_lgl_eng_nm") = true;
	            	sheetObj.ColHidden("phn_no")          = true;
	            	sheetObj.ColHidden("vndr_eml")        = true;      	
	            }
            
	  	        formObj.f_cmd.value = SEARCH;
	  	        sheetObj.SpeedOption = "NOPROGRESSTICK, NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT, NOMERGEROW, NOTRIM, NOTDTAG, NOCOMBO,NOFORMAT";
	  	        
	  	        if ( formObj.speed.checked ) {
			        sheetObj.DoSearch4Fx("EES_CIM_0018GS.do",FormQueryString(formObj));
	  	        } else {
			        sheetObj.DoSearch("EES_CIM_0018GS.do",FormQueryString(formObj));
	  	        }
	            ComOpenWait(false); 
	            break;
	       	case IBSEARCH01:      //공통조회
	       		sheetObj.WaitImageVisible = false;
	           	form.f_cmd.value = SEARCH01;
	           	var sXml = sheetObj.GetSearchXml("EES_CIM_0018GS.do" , FormQueryString(form));
	           
	           	//TP/SZ 조회
	           	var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   
	           
	           	head_cntr_tpsz_cd = cntr_tpsz_cd;
	           	document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd;
	           	var strCntrTpszCd  = cntr_tpsz_cd.split("|");
	  
	           	with (form.cntr_tpsz_cd) {
	          	 	MultiSelect = true;
	          	 	MultiSeparator = ",";
	          	 	DropHeight = 330;
	          	 	InsertItem(0 , 'ALL','');
	          	 	for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
	          	 		InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
	          	 	}
	           	}                  
	
			 	//Lease Term
			 	var sLeaseTermNm = ComGetEtcData(sXml,"lease_term_nm");
			 	var sLeaseTermCd = ComGetEtcData(sXml,"lease_term_cd");
			 	
			 	var arrLeaseTermNm = sLeaseTermNm.split("|");
			 	var arrLeaseTermCd = sLeaseTermCd.split("|");
			 	tot_lstm_cd = arrLeaseTermCd;
	          
			 	with (form.lstm_cd) {
			 		MultiSelect = true;
			 		MultiSeparator = ",";
			 		DropHeight = 320;
			 		InsertItem(0 , 'ALL','');
			 		for ( var i=1; i<=arrLeaseTermCd.length; i++) {
			 			InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
			 		}
			 	}                     

			 	break;
			case IBSEARCH02: //location focusOut
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel = "S";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel = "Y";
				}
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0018GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM29013");
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
	
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.full_flg);
					return false;
				}
		
				break;			 	
	   		case IBDOWNEXCEL:      // 입력
	   			sheetObj.SpeedDown2Excel(-1);      //숨겨진 데이터는 제외하고 내려 받기
	   			break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		var sVal1 = formObj.froms.value.replace(/\/|\-|\./g, "");
    		var sVal2 = formObj.tos.value.replace(/\/|\-|\./g, "");
    	  	if ( doActionIBSheet(sheetObjects[0], formObj, IBSEARCH02) ) {	//Location 유효성체크
    	  		formObject.loc_cd.focus();
     	        return false;
     	    } else {
	    	  	if(formObj.loc_type_code.value != "" && formObj.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObj.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
     	    }
    	  	
    	  	if(sVal1 == "" && !sVal2 == ""){
				ComShowCodeMessage("CIM30022","M/Date From Year");
				formObj.froms.focus();
				formObj.froms.select();
				return false;
				
			}else if(sVal1 != "" && sVal2 == ""){
				ComShowCodeMessage("CIM30022","M/Date To Year");
				formObj.tos.focus();
				formObj.tos.select();
				return false;
			}
    	}
    	return true;
    }
    
    /**
     * 화면 조회 종료후 프로세스 처리
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		sheetObj.SelectHighLight = false;
	}
	
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    
    /**
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */

    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        if(sheetObj.RowCount > 0){
        	//마우스 위치를 행과 컬럼과 값 가져오기
            var Row = sheetObj.MouseRow;
            var Col = sheetObj.MouseCol;

            if(Row > 0 && Col == 2){
            	var sText = sheetObj.CellValue(Row,"yd_nm");
            	if(sText != ""){
            		sheetObj.MouseToolTipText = sText;
            		sheetObj.MousePointer = "Hand";
            	}else{
            		sheetObj.MouseToolTipText = "";
            		sheetObj.MousePointer = "Default";
            	}
            }else{
        		sheetObj.MouseToolTipText = "";
            	sheetObj.MousePointer = "Default";	
            }
        }    
    }