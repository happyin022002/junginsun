/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0025.js
*@FileTitle : Land Inventory With CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2009.06.08 신자영
* 1.0 Creation
* =======================================================
* 2010.08.26 남궁진호  Ticket ID : CHM-201005612-01
*   Booking Inquiry Link 수정  ESM_BKG_0079 -> ESM_BKG_0079_Q
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
				    //document.form.view_flg[0].checked = true;
				    //view_flg_click(); 
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
				case "btn_bkginq":

					if ( sheetObjects[0].rowCount != 0 ) {
						var full_flg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"bkg_cgo_tp_cd");
						if (full_flg == 'P'){
							ComOpenWindowCenter("/hanjin/ESM_BKG_9425.do?" +
									"bkg_no="+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"bkg_no") + "&" +
									"pop_mode=1"
									,"ESM_BKG_9425", 1005, 650);
						}else{ //2010.08.26 Link 수정 및 Popup Size수정 
							ComOpenWindowCenter("/hanjin/ESM_BKG_0079_Q.do?" +
									"bkg_no="+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"bkg_no") + "&" +
									"pop_mode=1"
									,"ESM_BKG_0079_Q", 1005, 680);						
						}
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
				case "btns_search":		//Office Code
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 755, 435, "ofc_cd:sales_ofc_cd", "1,0,1,1,1,1,1,1", true);

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
     	//axon_event.addListener('click', 'view_flg_click', 'view_flg');						//view 변경시 이벤트 처리
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
			case "over_free_days":
				ComKeyOnlyNumber(event.srcElement);// 알파벳 대문자,숫자만 입력허용
				break;
			case "sales_ofc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
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
	 * Location  beforedeactivate YYYY-MM 포멧 처리
	 */	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
		obj = event.srcElement;
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
/*    	if ( document.form.view_flg[1].checked ) {
    		document.form.ts_cntr_behind.readOnly = false;
    		document.form.ts_cntr_behind.disabled = false;
    		document.form.ts_cntr_behind.className = "input";
    		
    		document.form.view_customer.checked = true;
    		document.form.view_commodity.checked = true;
    	} else {
*/
    		document.form.ts_cntr_behind.readOnly = false;
    		document.form.ts_cntr_behind.disabled = false;
    		document.form.ts_cntr_behind.checked = false;
    		document.form.ts_cntr_behind.className = "input2";
    		document.form.next_vvd.disabled = true;
    		document.form.next_vvd.className = "input2";
    		document.form.next_vvd.value = "";    		
    		
    		document.form.view_customer.checked = false;
    		document.form.view_commodity.checked = false;
//    	}
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
	* view_vvd click 이벤트 처리
	* Load VVD, Disc VVD, POL ETD 정보 view or unview	
	*/	
    function view_vvd_click() {
    	if ( document.form.view_vvd.checked ) {
    		sheetObjects[0].ColHidden("load_vvd") = false;
    		sheetObjects[0].ColHidden("disc_vvd") = false;
    		sheetObjects[0].ColHidden("pol_etd") = false;
    	} else {
    		sheetObjects[0].ColHidden("load_vvd") = true;
    		sheetObjects[0].ColHidden("disc_vvd") = true;
    		sheetObjects[0].ColHidden("pol_etd") = true;
    	}
    }
    
    /**
	* view_customer click 이벤트 처리
	* shpr cnee 정보 view or unview	
	*/	
    function view_customer_click() {
    	if ( document.form.view_customer.checked ) {
    		sheetObjects[0].ColHidden("shpr") = false;
    		sheetObjects[0].ColHidden("cnee") = false;
    	} else {
    		sheetObjects[0].ColHidden("shpr") = true;
    		sheetObjects[0].ColHidden("cnee") = true;
    	}
    }
	    
    /**
	* view_commodity_click click 이벤트 처리 
	* rep_cmdt_nm 정보 view or unview	
	*/	
    function view_commodity_click() {
    	if ( document.form.view_commodity.checked ) {
    		sheetObjects[0].ColHidden("rep_cmdt_nm") = false;
    	} else {
    		sheetObjects[0].ColHidden("rep_cmdt_nm") = true;
    	}
    }
    
    /**
	* view_salesrep_click click 이벤트 처리 
	* rep_cmdt_nm 정보 view or unview	
	*/	
    function view_salesrep_click() {
    	if ( document.form.view_salesrep.checked ) {
    		sheetObjects[0].ColHidden("ob_srep_cd") = false;
    	} else {
    		sheetObjects[0].ColHidden("ob_srep_cd") = true;
    	}
    }

    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,headTitle) {

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
                    InitRowInfo(1, 1, 25, 100);

                    if (headTitle==null || headTitle =="") {
                        headTitle = "Seq.|Sub Loc.|Yard|CNTR No.|TP/SZ|MVMT|F/M|Event Date|S.Days|F.Days|R/D Term|BKG No.|B/L No.|POR|DEL|";
                        headTitle += "Disc VVD|Load VVD|POL ETD|SC/RFA No|"     
                        headTitle += "SHPR|CNEE|CMDT|DMG|Sales OFC|Sales Rep.|UC|MT";
                    }
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
                    InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,  	true,	"cnmv_sts_cd",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				30,   	daCenter,  	true,	"full_flg",     			false,	"",	dfNone);
                	InitDataProperty(0, cnt++ , dtData,				70,   	daCenter,  	true,	"cnmv_dt",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				50,   	daRight,  	true,	"stay_days",     			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,				50,   	daRight,  	true,	"free_days",     			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,				60,   	daCenter,  	true,	"de_term_cd",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				90,   	daCenter,  	true,	"bkg_no",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				90,   	daCenter,  	true,	"bl_no",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				50,   	daCenter,  	true,	"por_cd",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				50,   	daCenter,  	true,	"del_cd",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				75,   	daCenter,  	true,	"disc_vvd",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				75,   	daCenter,  	true,	"load_vvd",     			false,	"",	dfNone); 
                    InitDataProperty(0, cnt++ , dtData,				70,   	daCenter,  	true,	"pol_etd",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				100,   	daCenter,  	true,	"sc_rfa_no",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				100,   	daLeft,  	true,	"shpr",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				100,   	daLeft,  	true,	"cnee",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				200,   	daLeft,  	true,	"rep_cmdt_nm",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				50,   	daCenter,  	true,	"dmg_flg",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				70,   	daCenter,  	true,	"ob_sls_ofc_cd",     		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				70,   	daCenter,  	true,	"ob_srep_cd",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				40,   	daCenter,  	true,	"uclm_ls_flg",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,			50,   	daCenter,  	false,	"bkg_cgo_tp_cd",     		false,	"",	dfNone);
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
	 	
        var strPolEtc = '';
 		if (document.form.ts_cntr_behind.checked && (document.form.next_vvd.value == '' || document.form.next_vvd.value != '') ) {
 			strPolEtc = 'POL ATD';
 		} else if ( !document.form.ts_cntr_behind.checked && document.form.next_vvd.value == '' ) {
 			strPolEtc = 'POL ETD';
 		}
        if (headTitle==null || headTitle =="") {
            headTitle = "Seq.|Sub Loc.|Yard|CNTR No.|TP/SZ|MVMT|F/M|Event Date|S.Days|F.Days|R/D Term|BKG No.|B/L No.|POR|DEL|";
            headTitle += "Disc VVD|Load VVD|"+strPolEtc+"|SC/RFA No|"     
            headTitle += "SHPR|CNEE|CMDT|DMG|Sales OFC|Sales Rep.|UC|MT";
        }

	 	sheetObj.Redraw = false;
	 	sheetObj.RemoveAll();
	 	sheetObj.Reset();
	 	initSheet(sheetObjects[0],1,headTitle);
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
	            setHeadData(sheetObj);	  // t/s check에 따른 header변경
	            view_vvd_click();
	            view_customer_click();
	            view_commodity_click(); 
	            view_salesrep_click(); 
	            
	  	        formObj.f_cmd.value = SEARCH;
	  	        sheetObj.SpeedOption = "NOPROGRESSTICK, NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT, NOMERGEROW, NOTRIM, NOTDTAG, NOCOMBO,NOFORMAT";
	  	        if ( formObj.speed.checked ) {
			        sheetObj.DoSearch4Fx("EES_CIM_0025GS.do",FormQueryString(formObj));
	  	        } else {
			        sheetObj.DoSearch("EES_CIM_0025GS.do",FormQueryString(formObj));
	  	        }
	            ComOpenWait(false); 
	            break;
	       	case IBSEARCH01:      //공통조회
	       		sheetObj.WaitImageVisible = false;
	           	form.f_cmd.value = SEARCH01;
	            //향후 변경 예정 25로 바꾸어야 함
	           	var sXml = sheetObj.GetSearchXml("EES_CIM_0025GS.do" , FormQueryString(form));
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
				var sXml = sheetObj.GetSearchXml("EES_CIM_0025GS.do",FormQueryString(formObj));
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
    	  	var formObject = document.form;
    	  	if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
    	  		formObject.loc_cd.focus();
     	        return false;
     	    } else {
	    	  	if(formObject.loc_type_code.value != "" && formObject.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	
	    	  	return true;
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