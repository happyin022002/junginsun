// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var IBSEARCH02  = 30;
var IBSEARCH03  = 31;
//var IBSAVE02    = 32;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 var sheetObject2 = sheetObjects[2];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
                case "cnt_btn":
                    	         
                	with(formObject)
                	{                	        
                	    //var v_cnt_cd = cnt_cd.value;
                	    var classId = "ESM_AGT_0044";
            		    var param = '?classId='+classId;
            		    var v_display = "1,0,1,1,1,1,1,1,1,1";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		    	//2011.11.01 이정수 - 팝업 사이즈 확인
            		    	ComOpenPopup('/hanjin/ESM_AGT_0044.do' + param, 780, 540, 'getESM_AGT_001_1', v_display, true);
            		    }else {
            			    showErrMessage("팝업을 띄우기display속성 정보가 부족합니다.");
            			    return;
            		    }
                	}
                	
                	if(formObject.vndr_cnt_cd.value != ""){
                	    sheetObjects[0].Visible = true ;
                	    sheetObject.RemoveAll();
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
    					formObject.current.value = "";
    					formObject.total.value = "";
                	    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    	doActionIBSheet(sheetObject1,formObject,IBSEARCH02);
                    	//Version Control에 리스트가 있으면 맨위의 행의 값을 가지고 Definition & Compensation를 조회한다.
                    	if(sheetObject1.CellValue(2,"agn_agmt_ver_seq") != ""){
                    	   formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                    	   doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
                    	   formObject.current.value = formObject.agn_agmt_ver_seq.value;
                           formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                    	}
                	}
                	
                	
                	break;
                	
				case "btn_retrieve":
					//doActionIBSheet(sheetObject1,formObject,IBSEARCH02);
					doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
					break;

				case "btn_new":
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					formObject.reset();
					break;
				case "col_hidden":
					doActionIBSheet(sheetObject2,formObject,COMMAND04);
					break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(ac_tp_cd, ac_tp_text) {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1,ac_tp_cd,ac_tp_text);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);			
		}
		sheetObjects[0].Visible = false ;
	}

   /**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo,ac_tp_cd,ac_tp_text) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					//style.height = GetSheetHeight(6) ;
					style.height = 25;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true, false);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "agmt_ofc_cd",     false,          "",       dfNone,          0,     false,       false);

					CountPosition = 0 ;
                    RowHidden( 0 ) = true ;
				}
				break;
			case 2:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 130;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 3 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|VER|Period|Period|Exchange\nRate|Office\nCharacter|Remarks|Update\nDate|Del";
					var HeadTitle1 = "Del.|STS|VER|From|To|Exchange\nRate|Office\nCharacter|Remarks|Update\nDate|Del";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
 
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     false,       false);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",     false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,        30,    daCenter,   true,    "agn_agmt_ver_seq",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fm_eff_dt",     true,          "",       dfDateYmd,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "to_eff_dt",     true,          "",       dfDateYmd,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,   true,    "xch_rt_div_lvl",     true,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,     150,    daCenter,   true,    "ofc_chr_lvl",     true,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,   true,    "agn_agmt_rmk",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "upd_dt",     false,          "",       dfDateYmd,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "delt_flg",     false,          "",       dfNone,          0,     false,       false);
					CountPosition  = 0;

					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0, "xch_rt_div_lvl" , " VVD|Monthly|Daily", " 1|2|3");
					InitDataCombo (0, "ofc_chr_lvl" , "Agent|Joint Venture|Subsidiary(CN)|BKG Agent(CN)|Stand-alone Company|Branch Office|Regional Head Quarter", " 1|2|3|4|5|6|7");
					RangeBackColor(1,2,1,6) = RgbColor(222, 251, 248);   // ENIS
                    InitDataValid(0, "agn_agmt_rmk", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //한글빼고 입력

					HeadRowHeight = 20 ;
					HeadRowHeight = 21 ;
                    
			   }
				break;
            
			case 3:      //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 3, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(34, 6 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|No.|Bound|Account|TP/SZ|Status|Amount|Amount|Subject AMT|Base|%|Deduct for Net|Deduct for Net|Deduct for Net|Deduct for Net|Deduct for Net|POR|POL|POD|DEL|Customer|S/C #|RFA #|S/C OFC|RFA OFC|BKG\nOFC|Sales\nOFC|PPD at|CCT at|3rd Party\nat|Lane|Vessel|Local\nCharge";
					var HeadTitle1= "Del.|STS|No.|Bound|Account|TP/SZ|Status|CUR|AMT|Subject AMT|Base|%|Charge|Haulage|Haulage|Feederage|Feederage|POR|POL|POD|DEL|Customer|S/C #|RFA #|S/C OFC|RFA OFC|BKG\nOFC|Sales\nOFC|PPD at|CCT at|3rd Party\nat|Lane|Vessel|Local\nCharge";
					var HeadTitle2= "Del.|STS|No.|Bound|Account|TP/SZ|Status|CUR|AMT|Subject AMT|Base|%|Charge|ORG|DEST|ORG|DEST|POR|POL|POD|DEL|Customer|S/C #|RFA #|S/C OFC|RFA OFC|BKG\nOFC|Sales\nOFC|PPD at|CCT at|3rd Party\nat|Lane|Vessel";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,    "ibflag",     false,          "",       dfNone,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   true,    "",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "io_bnd_cd",   false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "ac_tp_cd",   true,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopup,  50,    daCenter,   true,    "cntr_inp_term_cd",  false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,   true,    "full_mty_cd",   false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,   true,    "curr_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,    true,    "fx_comm_amt",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "comm_pay_term_cd",   true,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "grs_net_div_cd",   true,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_comm_rt",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "chg_ddct_inp_cd",  false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "hlg_ddct_org_flg",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "hlg_ddct_dest_flg",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "fdrg_ddct_org_flg",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "fdrg_ddct_dest_flg",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_por_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_pol_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_pod_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_del_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  70,    daCenter,   true,    "cust_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "sc_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  65,    daCenter,   true,    "rfa_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  70,    daCenter,   true,    "sc_ofc_inp_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "rfa_ofc_inp_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_ofc_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "sls_ofc_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_ppd_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_clt_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  70,    daCenter,   true,    "bkg_n3rd_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "lane_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "vsl_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					
       				//hidden 추가
       				InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "agn_seq",     true,          "",       dfNone,          0,     true,       true);	
					CountPosition  = 0;

					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0, "io_bnd_cd" , "Out|In", "O|I");
					//InitDataCombo (0, "ac_tp_cd" , "Common|Brokerage|CHF|T/S|T/R|SOC|Cross", "G|K|H|S|R|O|C");
					InitDataCombo (0, "ac_tp_cd" , ac_tp_text, ac_tp_cd);
					InitDataCombo (0, "full_mty_cd" , "Full|Empty", "F|M");
					InitDataCombo (0, "curr_cd" , "USD|JPY|AUD", "USD|JPY|AUD");
					InitDataCombo (0, "comm_pay_term_cd" , "TTL|PPD|CCT", "T|P|C");
					InitDataCombo (0, "grs_net_div_cd" , "Net|Gross", "N|G");
					
					RangeBackColor(1,5,2,17) = RgbColor(222, 251, 248);   // ENIS

					HeadRowHeight = 20 ;
					HeadRowHeight = 21 ;
					
					InitDataValid(0, "fx_comm_amt", vtNumericOther, ".");//숫자와 . 입력되도록 설정
					InitDataValid(0, "bkg_comm_rt", vtNumericOther, ".");//숫자와 . 입력되도록 설정
					
					sheetObj.ColHidden("cust_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_inp_term_cd") = true;
    				sheetObj.ColHidden("rfa_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_ofc_inp_cd") = true;
    				sheetObj.ColHidden("rfa_ofc_inp_cd") = true;
    				sheetObj.ColHidden("bkg_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("sls_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_ppd_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_clt_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_n3rd_inp_term_cd") = true;
    				sheetObj.ColHidden("lane_inp_term_cd") = true;
    				sheetObj.ColHidden("vsl_inp_term_cd") = true;

			   }
				break;
			
		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH01;
    			sheetObj.DoSearch4Post("ESM_AGT_0045GS.do", agtQryStr(formObj));				
				break;
		   case IBSEARCH02:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH02;
    			sheetObj.DoSearch4Post("ESM_AGT_0045GS2.do", agtQryStr(formObj));				
				break;
		   case IBSEARCH03:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH03;
    			sheetObj.DoSearch4Post("ESM_AGT_0045GS3.do", agtQryStr(formObj));				
				break;
		   case COMMAND04:
		        if(formObj.mFlag.value == "0"){
		            sheetObj.ColHidden("cust_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_inp_term_cd") = true;
    				sheetObj.ColHidden("rfa_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_ofc_inp_cd") = true;
    				sheetObj.ColHidden("rfa_ofc_inp_cd") = true;
    				sheetObj.ColHidden("bkg_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("sls_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_ppd_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_clt_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_n3rd_inp_term_cd") = true;
    				sheetObj.ColHidden("lane_inp_term_cd") = true;
    				sheetObj.ColHidden("vsl_inp_term_cd") = true;
		        }else{
		            sheetObj.ColHidden("cust_inp_term_cd") = false;
    				sheetObj.ColHidden("sc_inp_term_cd") = false;
    				sheetObj.ColHidden("rfa_inp_term_cd") = false;
    				sheetObj.ColHidden("sc_ofc_inp_cd") = false;
    				sheetObj.ColHidden("rfa_ofc_inp_cd") = false;
    				sheetObj.ColHidden("bkg_ofc_inp_term_cd") = false;
    				sheetObj.ColHidden("sls_ofc_inp_term_cd") = false;
    				sheetObj.ColHidden("bkg_ppd_inp_term_cd") = false;
    				sheetObj.ColHidden("bkg_clt_inp_term_cd") = false;
    				sheetObj.ColHidden("bkg_n3rd_inp_term_cd") = false;
    				sheetObj.ColHidden("lane_inp_term_cd") = false;
    				sheetObj.ColHidden("vsl_inp_term_cd") = false;
		        }
		        				
				break;

		}
	}
    
    function sheet2_OnDblClick(sheetObj, row, col, value) {
   		var sheetObject1 = sheetObjects[1];
   		var sheetObject2 = sheetObjects[2];
        var formObject = document.form;
        if(sheetObject1.CellValue(row,"ibflag") == "R"){
            formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(row,"agn_agmt_ver_seq");
            doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
            formObject.current.value = formObject.agn_agmt_ver_seq.value;
            formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
        }
    }  

    // dtPopupEdit 로 처리 할 경우 팝업오픈 처리
    
    function sheet3_OnPopupClick(sheetObj, row, col)
    {
        var formObject = document.form;
        var vndr_cnt_cd = formObject.vndr_cnt_cd.value;
        var vndr_seq = formObject.vndr_seq.value;
        var agmt_ofc_cty_cd = formObject.agmt_ofc_cty_cd.value;
        var agn_agmt_seq = formObject.agn_agmt_seq.value;
        var agmt_ofc_cd = formObject.agmt_ofc_cd.value;
        var agn_agmt_ver_seq = formObject.agn_agmt_ver_seq.value;
        
    	if ( sheetObj.ColSaveName(col) == "chg_ddct_inp_cd" ){
    		//진행중 표시 팝업 
//    		window.open("apps/alps/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//팝업 처리로직
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	       	   
    	   var dispaly = "0,1,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0005";
    	   var sheet = "4";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&sheet='+sheet+'&classId='+classId+'&pageType=Inquiry';
    	   var chkStr = dispaly.substring(0,3) ; 
    	        
    	   if(chkStr == "0,1") {
    	        // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    		   ComOpenPopup('/hanjin/ESM_AGT_0005.do' + param, 760, 438, 'getESM_AGT_005_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "cntr_inp_term_cd" ){
    		//진행중 표시 팝업 
//    		window.open("apps/alps/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//팝업 처리로직
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   
    	   var dispaly = "0,1,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0004";
    	   var sheet = "3";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&sheet='+sheet+'&classId='+classId+'&pageType=Inquiry';
    	   var chkStr = dispaly.substring(0,3) ;         

    	   if(chkStr == "0,1") {
    	        // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    		   ComOpenPopup('ESM_AGT_0004.do' + param, 610, 480, 'getESM_AGT_004_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "bkg_por_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_pol_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_pod_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_del_inp_term_cd" ){
    		//진행중 표시 팝업 
//    		window.open("apps/alps/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//팝업 처리로직
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var rout_ref_div_cd = "";
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   
    	   if(sheetObj.ColSaveName(col) == "bkg_por_inp_term_cd"){
    	       rout_ref_div_cd = "PORL";
    	   }else if(sheetObj.ColSaveName(col) == "bkg_pol_inp_term_cd"){
    	       rout_ref_div_cd = "POLL";
    	   }else if(sheetObj.ColSaveName(col) == "bkg_pod_inp_term_cd"){
    	       rout_ref_div_cd = "PODL";
    	   }else if(sheetObj.ColSaveName(col) == "bkg_del_inp_term_cd"){
    	       rout_ref_div_cd = "DELL";
    	   }
    	   
    	   var dispaly = "0,1,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0006";
    	   var sheet = "5";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&rout_ref_div_cd='+rout_ref_div_cd+'&sheet='+sheet+'&classId='+classId+'&pageType=Inquiry';
    	   var chkStr = dispaly.substring(0,3) ;         
    	        
    	  if(chkStr == "0,1") {
    	        // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    		  ComOpenPopup('ESM_AGT_0006.do' + param, 900, 480, 'getESM_AGT_006_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "sc_inp_term_cd" || sheetObj.ColSaveName(col) == "rfa_inp_term_cd" || sheetObj.ColSaveName(col) == "sc_ofc_inp_cd" || sheetObj.ColSaveName(col) == "rfa_ofc_inp_cd" || sheetObj.ColSaveName(col) == "lane_inp_term_cd" || sheetObj.ColSaveName(col) == "vsl_inp_term_cd" ){
    		//진행중 표시 팝업 
//    		window.open("apps/alps/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//팝업 처리로직
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   var otr_ref_div_cd = "";
    	   
    	   if(sheetObj.ColSaveName(col) == "sc_inp_term_cd"){
    	       otr_ref_div_cd = "SCNO";
    	   }else if(sheetObj.ColSaveName(col) == "rfa_inp_term_cd"){
    	       otr_ref_div_cd = "RFAN";
    	   }else if(sheetObj.ColSaveName(col) == "sc_ofc_inp_cd"){
    	       otr_ref_div_cd = "SCOF";
    	   }else if(sheetObj.ColSaveName(col) == "rfa_ofc_inp_cd"){
    	       otr_ref_div_cd = "RFAO";
    	   }else if(sheetObj.ColSaveName(col) == "lane_inp_term_cd"){
    	       otr_ref_div_cd = "LANE";
    	   }else if(sheetObj.ColSaveName(col) == "vsl_inp_term_cd"){
    	       otr_ref_div_cd = "VSSL";
    	   }
    	   
    	   var dispaly = "1,0,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0037";
    	   var sheet = "6";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&otr_ref_div_cd='+otr_ref_div_cd+'&sheet='+sheet+'&classId='+classId+'&pageType=Inquiry';
    	   var chkStr = dispaly.substring(0,3) ;         
    	        
    	  if(chkStr == "1,0") {
//    		  alert(param);
    	        // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    	       	ComOpenPopup('ESM_AGT_0037.do' + param, 300, 310, 'getESM_AGT_037_2', dispaly, true, false,row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "cust_inp_term_cd"){
    		//진행중 표시 팝업 
//    		window.open("apps/alps/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//팝업 처리로직
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
           var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   
    	   var dispaly = "0,1,1,1,1,1,1,1,1,1";    // Row PopUp
    	   var classId = "COM_ENS_041";
    	   var sheet = "1";
    	   var param = '?sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;         
    	   var showVal = sheetObj.CellValue(row, "cust_inp_term_cd");
    	       
    	  if(chkStr == "0,1") {
    	        //if(showVal != "" || showVal != null || showVal != "*"){
    	        //    showErrMessage(getMsg('AGT10007','Customer',showVal));
    	        //}
    	        // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    		  ComOpenPopup('COM_ENS_041.do' + param, 770, 470, 'getCOM_ENS_041_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "bkg_ofc_inp_term_cd" || sheetObj.ColSaveName(col) == "sls_ofc_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_ppd_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_clt_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_n3rd_inp_term_cd"){
    		//진행중 표시 팝업 
//    		window.open("apps/alps/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//팝업 처리로직
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
           var agn_seq = sheetObj.CellValue(row, "agn_seq");
     	   
    	   var dispaly = "0,1,1,1,1,1,1,1,1,1";    // Row PopUp
    	   var classId = "COM_ENS_071";
    	   var sheet = "1";
    	   var param = '?sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;
    	   var showVal = "";
    	            
    	   if(sheetObj.ColSaveName(col) == "bkg_ofc_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_ofc_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "sls_ofc_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "sls_ofc_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "bkg_ppd_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_ppd_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "bkg_clt_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_clt_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "bkg_n3rd_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_n3rd_inp_term_cd");
    	   }  
    	   if(chkStr == "0,1") {
    	       //if(showVal != "" || showVal != null || showVal != "*"){
    	       //    showErrMessage(getMsg('AGT10007',sheetObj.ColSaveName(col),showVal));
    	       //}
    	       // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
    		   ComOpenPopup('COM_ENS_071.do' + param, 770, 430, 'getCOM_ENS_071_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}

    }

    /**
	 *  팝업에서 Radio로 단일 선택을 한경우..
	 */
	function getESM_AGT_001_1(rowArray) {
	    var formObject = document.form;
	    
		var colArray = rowArray[0];
		formObject.vndr_cnt_cd.value = colArray[5];
		formObject.vndr_seq.value = colArray[6];
		formObject.agmt_ofc_cty_cd.value = colArray[3];
		formObject.agn_agmt_seq.value = colArray[4];
		formObject.agmt_ofc_cd.value = colArray[7];
	}
	
	/**
	 * F.Forwarder(Customer) : 팝업에서 Radio로 단일 선택을 한경우..
	 */
	function getESM_AGT_004_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
		for(var i = 0; i<arrayLen; i++){
		    cellVal = cellVal + rowArray[i][3] + ",";
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, col) = cellVal;
	}
	
	/**
     * COM_ENS_041 : 팝업에서 Check로 멀티 선택을 한경우..
     */
    function getCOM_ENS_041_2(rowArray, row, col) {
     	
    	var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    var colArray;
	    for(var i = 0; i<arrayLen; i++){
	        colArray = rowArray[i];
		    cellVal = cellVal + colArray[3] + ",";		    
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, col) = cellVal;
    }
    
    /**
     * COM_ENS_071 : 팝업에서 Check로 멀티 선택을 한경우..
     */
    function getCOM_ENS_071_2(rowArray, row, col) {
     	
    	var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    var colArray;
	    for(var i = 0; i<arrayLen; i++){
	        colArray = rowArray[i];
		    cellVal = cellVal + colArray[3] + ",";		    
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, col) = cellVal;
    }
	
	/**
	 * ESM_AGT_005 : 팝업에서 Check 로 멀티 선택을 한경우..
	 */
	function getESM_AGT_005_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = rowArray[0];
		sheetObj.CellValue(row, col) = cellVal;
	}
	
	/**
	 * ESM_AGT_006 : 팝업에서 Check 로 멀티 선택을 한경우..
	 */
	function getESM_AGT_006_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = rowArray[0];
		sheetObj.CellValue(row, col) = cellVal;
	}
	
	/**
	 * ESM_AGT_037 : 팝업에서 Check 로 멀티 선택을 한경우..
	 */
	function getESM_AGT_037_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    for(var i = 0; i<arrayLen; i++){
		    cellVal = cellVal + rowArray[i] + ",";		    
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, col) = cellVal;
	}


   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		
		switch(sAction) {
		}
		return true;
	}
	
