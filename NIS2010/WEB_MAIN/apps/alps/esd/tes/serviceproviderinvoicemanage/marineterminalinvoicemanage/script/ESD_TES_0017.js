﻿/**=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0017.js
*@FileTitle : Marine Terminal Invoice
*Open Issues :
*Change history :  
*@LastModifyDate : 2009.08.17
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.01.08 
* 1.0 최초 생성
* 2011.08.17 박정일 [E-mail요청] [TES] special character, characterSet problem
* 2012.02.27 박성호 [CHM-201216241]미국 서부지역 조직 변경 관련 PHXSCG의 조회권한 확대 보완사항 테스트
* 2015-03-05 김영신 [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
* 2015-04-09 김영신 [CHM-201534988] EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F
=========================================================*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;

var tot_page = 1; //ATB 에서 전체 페이지 수를 나타내는 변수

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var io_hidden = ''
	
var auth_ofc_main_hidden_xml = ''; //ofc_cd 별 권한 체크시  vvd_hidden에 문제가 생김

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject  = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];//main_hidden
	     var vvd_hidden       = sheetObjects[4];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

				// eBilling - B
				case "btn_EDIinvoiceview":
					var url_str = 'ESD_TES_1001Popup.screen';
					url_str += '?tml_so_ofc_cty_cd='+document.form.tml_so_ofc_cty_cd.value;
					url_str += '&tml_so_seq='+document.form.tml_so_seq.value;
					window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
					break;
				// eBilling - E

				case "btn_retrieve":
					// eBilling - B
					//document.all.EDILayer01.style.display = "none";
					//document.form.edi_flg.value = '';
					// eBilling - E
				    var tmp_inv_no = formObject.inv_no.value;
        	        var tmp_vndr_seq = formObject.vndr_seq.value;
        	        var tmp_vndr_nm = formObject.vndr_seq_name.value;
        	        
        	        //alert("after"+sheetObjects[3].CellValue(1, 'inv_no'));
        	        
        	        if(tmp_inv_no == null || tmp_inv_no == ''){
        	            if(tmp_vndr_seq == null || tmp_vndr_seq == ''){
        	                ComShowCodeMessage('TES21501'); //showErrMessage('Pleas Input Invoice No & Vendor Code!');
        	                return;
        	            }else{
        	                ComShowCodeMessage('TES21502'); //showErrMessage('Please Input Invoice No!');
        	                return;
        	            }
        	        }else{
        	            if(tmp_vndr_seq == null || tmp_vndr_seq == ''){
        	                ComShowCodeMessage('TES21503'); //showErrMessage('Please Input Vendor Code!');
        	                return;
        	            }
        	        }
        	        if(tmp_vndr_seq.length < 6){
        	            ComShowCodeMessage('TES21504'); //showErrMessage('Invaid Vendor Code!');
        	            formObject.vndr_seq.value ='';
        	            formObject.vndr_seq_name.value = '';
        	            //init();
        	            formObject.vndr_seq.focus();
        	            return;
        	        }
        	        /*             
				    formObject.reset();
   	        sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            sheetObject2.RemoveAll();
    	            sheetObject3.RemoveAll();*/
    	            
    	            formObject.inv_no.value = tmp_inv_no;
        	        formObject.vndr_seq.value = tmp_vndr_seq;
        	        formObject.vndr_seq_name.value = tmp_vndr_nm;
        	        
				    doActionIBSheet_main_hidden(sheetObject3,formObject,IBSEARCH);
				    
				    if(sheetObject3.RowCount<1){
                        ComShowCodeMessage('TES21505',tmp_inv_no,tmp_vndr_seq);//'No Data for\n\nInv No:'+tmp_inv_no+'  &  VNDR Code:'+tmp_vndr_seq
                        return false;
                    }
				    
        	        break;
        	        
                case "btn_new":
					// eBilling - B
					//document.all.EDILayer01.style.display = "none";
					//document.form.edi_flg.value = '';
					// eBilling - E
                    sheetObject.RemoveAll();
                    sheetObject1.RemoveAll();
                    sheetObject2.RemoveAll();
    	            formObject.reset();
    	            formObject.inv_no.focus();
                    break;

                case "btn_vndr":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_0C1";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3);

                         // radio PopUp
                         if(chkStr == "1,0") {
                        	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVender', dispaly);
                        } else {
                             ComShowCodeMessage('TES21906'); //showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                             return;
                        }
          	         break;

				case "btns_remarks":
				if(formObject.tml_so_seq.value==null ||formObject.tml_so_seq.value==''){
                        return false;
                    }
					ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 'popup_remarks', 300,150, true);
					break;

				case "btng_back":
				if(formObject.tml_so_seq.value==null ||formObject.tml_so_seq.value==''){
                        return false;
                    }
				    if(vvd_hidden.FindText('vvd', formObject.vvd.value+io_hidden) == vvd_hidden.HeaderRows){
                        ComShowCodeMessage('TES21022'); //showErrMessage('첫번째 페이지 입니다.');
                        return false;
                    }else{
                        findPage(-1);
                    }

					break;

				case "btng_next":
				if(formObject.tml_so_seq.value==null ||formObject.tml_so_seq.value==''){
                        return false;
                    }
				    if(vvd_hidden.FindText('vvd', formObject.vvd.value+io_hidden) == vvd_hidden.RowCount){
                        ComShowCodeMessage('TES21023'); //showErrMessage('마지막 페이지 입니다.');
                        return false;
                    }else{
                        findPage(1);
                    }
					break;

				case "btng_totalamount":
				if(formObject.tml_so_seq.value==null ||formObject.tml_so_seq.value==''){
                        return false;
                    }
				   var url_str = "ESD_TES_9040Pop.screen";
				   window.showModalDialog(url_str, window, "dialogWidth:510px; dialogHeight:410px; help:no; status:no; resizable:yes;");
				   break;
				   
				case "btn_pre_inquiry_cond":
					var url_str = 'ESD_TES_0013.do';
					url_str += '?pgmNo=ESD_TES_0013';
					url_str += '&pre_cond_inv_no='+document.form.pre_cond_inv_no.value;
					url_str += '&pre_cond_inv_date_type='+document.form.pre_cond_inv_date_type.value;
					url_str += '&pre_cond_fm_prd_dt='+document.form.pre_cond_fm_prd_dt.value;
					url_str += '&pre_cond_to_prd_dt='+document.form.pre_cond_to_prd_dt.value;
					url_str += '&pre_cond_yd_cd='+document.form.pre_cond_yd_cd.value;
					url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
					url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
					url_str += '&pre_cond_inv_ofc_cd='+document.form.pre_cond_inv_ofc_cd.value;
					url_str += '&pre_cond_tml_inv_sts_cd='+document.form.pre_cond_tml_inv_sts_cd.value;
					url_str += '&pre_cond_csr_no='+document.form.pre_cond_csr_no.value;
					url_str += '&pre_cond_csr_status='+document.form.pre_cond_csr_status.value;
					url_str += '&pre_cond_tml_inv_rjct_sts_cd='+document.form.pre_cond_tml_inv_rjct_sts_cd.value;
					location.href = url_str;
					break;
				
				case "btng_costcodedescshow":
					document.all.CostCodeDescShow.style.display = "none";
					document.all.CostCodeDescHide.style.display = "inline";	
			        sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = false;	//show
					break;
				
				case "btng_costcodedeschide":
					document.all.CostCodeDescShow.style.display = "inline";
					document.all.CostCodeDescHide.style.display = "none";
					sheetObjects[2].ColHidden("lgs_cost_abbr_nm") = true;	//hide
					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //showErrMessage("지금은 사용하실 수가 없습니다 ");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 김은진
	 * @version 2015.01.13
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     * 
     */
    function loadPage() {
    	
    	// IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);   //khlee-시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];//main_hidden
        var sheetObject4 = sheetObjects[4];//containerlist_hidden
        var sheetObject5 = sheetObjects[5];//accmulated_hidden
        var sheetObject6 = sheetObjects[6];//costcalc_hidden
        var formObject = document.form;
        
        if(!ComIsNull(formObject.inv_no_tmp.value)){
         // [TES] special character, characterSet problem
            formObject.inv_no.value = formObject.inv_no_tmp.value;
            formObject.vndr_seq.value = vndr_seq;
            chkInput(formObject.vndr_seq);

            doActionIBSheet_main_hidden(sheetObject3,formObject,IBSEARCH);

        }
        
        document.all.CostCodeDescHide.style.display = "inline";
        
        //India Info Display
    	if(ida_ofc_cd == 'Y'){
    		document.all.IndiaLayer01.style.display = "inline";
    		document.all.IndiaLayer02.style.display = "inline";
    		
    	} else {
    		document.all.IndiaLayer01.style.display = "none";
    		document.all.IndiaLayer02.style.display = "none";
    		
    	}
    }
    
    /**
	* IBCOMBO 초기화. <br>
	**/
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "vvd_bnd_combo":
				var i=0;
				with(comboObj) {
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
                    SetColWidth("90|30|30");
				}
				break;
		}
	} 


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheet_obj) sheet object
     * @param(sheetNo) sheetNo
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(16) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "SEQ|Page|CNTR No.|Type\r\nSize|F/M|I/O|DG|Working\nDate|IPC|Lane|T/S|R/D Term|BKG_NO|Verify Result|Remarks";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,   30,    daCenter,  true,      "",                 false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,   100,    daCenter,  false,     "page",             false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,     "cntr_no",          false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "cntr_tpsz_cd",     false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "cntr_sty_cd",      false,          "",      dfNone,      0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "io_bnd_cd",        false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "dcgo_clss_cd",     false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "wrk_dt",           false,          "",      dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "ioc_cd",           false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "lane_cd",          false,          "",      dfNone,      0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,     "locl_ts_ind_cd",   false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "rcvde_term_ind_cd",false,          "",      dfNone,      0,     true,       true);
               		// Container가 Full 인 경우에 Bkg_no || Bkg_no_split 컬럼을 보여준다. ( 4342. 01. 13 - 이경한 과장 요청 )
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,     "bkg_no_con"   ,    false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "dscr_ind_cd",      false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "cntr_rmk",         false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  false,     "vvd",              false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  false,     "atb_dt",           false,          "",      dfNone,      0,     false,       false);
               }
                break;
             case 2:      //t2sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(17) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Page|Seq.|Discrepancy Type|CNTR No.|Type\r\nSize|F/M|I/O|DG|Working\nDate|IPC|Lane|T/S|R/D Term|BKG NO|Remarks";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]


                    //page는 잠깐 추가
                    InitDataProperty(0, cnt++ , dtHidden,   110,   daLeft,    true,    "page",                false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtSeq,     30,    daCenter,  false,    "",                    false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,   110,   daCenter,    true,    "dscr_ind_cd",          false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,    100,   daLeft,    false,    "cntr_no",             false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    65,    daCenter,  false,    "cntr_tpsz_cd",        false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData,    35,    daCenter,  false,    "cntr_sty_cd",         false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    35,    daCenter,  false,    "io_bnd_cd",           false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  false,    "dcgo_clss_cd",        false,          "",       dfNone,    0,     true,        true);
					InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "wrk_dt",              false,          "",       dfDateYmd, 0,     true,        true);
                    InitDataProperty(0, cnt++ , dtData,    35,    daCenter,  false,    "ioc_cd",              false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData,    35,    daCenter,  false,    "lane_cd",             false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    35,    daCenter,  false,    "locl_ts_ind_cd",      false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    57,    daCenter,  false,    "rcvde_term_ind_cd",   false,          "",       dfNone,    0,     false,       false);
               		// Container가 Full 인 경우에 Bkg_no || Bkg_no_split 컬럼을 보여준다. ( 4342. 01. 13 - 이경한 과장 요청 )
                    InitDataProperty(0, cnt++ , dtData,   100,    daCenter,  false,     "bkg_no_con"     ,    false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  false,    "cntr_rmk",            false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,  50,    daCenter,  false,    "vvd",              false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,  50,    daCenter,  false,    "atb_dt",              false,          "",       dfNone,    0,     false,       false);

                    InitDataCombo(0 , "dscr_ind_cd", "Discrepancy by Detail Data|Duplicate|SMLS List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date", "DD|DP|HO|PD|NH|DB|DF");
			}
                break;
			 case 3:      //t3sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(17) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(ida_ofc_cd == 'Y'){
                    	InitRowInfo( 2, 1, 9, 100);
                    } else {
                    	InitRowInfo( 1, 1, 9, 100);
                    }

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(37, 2, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                     // 컬럼 헤더 타이틀 변경 ( T/S => Mode ) - 2009-04-15 자체
                    var HeadTitle = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Type\r\nSize|I/O|DG|Reefer|Applied\nDate|IPC|Mode|Lane|Vol.\nTier|Calculated\r\nVol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|Carrier|3rd Party";
                    
                    if(ida_ofc_cd == 'Y'){
                        var HeadTitle1 = "Calculated Type|Cost Code|Cost Code Desc.|HSN/SAC|Goods/\nServices|Type\r\nSize|I/O|DG|Reefer|Applied\nDate|IPC|Mode|Lane|Vol.\nTier|Calculated\r\nVol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|Carrier|3rd Party";
                    	
                    }
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    if(ida_ofc_cd == 'Y'){
                    	InitHeadRow(1, HeadTitle1, true);
                    } 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCombo,  150,    daLeft,    true,     "calc_tp_cd",       false,         "",        dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,    70,    daLeft,    true,    "lgs_cost_cd",      false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,   220,    daLeft,    true,    "lgs_cost_abbr_nm", false,          "",       dfNone,    0,     true,       true);
                    
                    if(ida_ofc_cd == 'Y'){
                    	InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,     "ida_sac_cd"           ,       false,          "",       dfNone,    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCombo,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     true,       true);
                    } else {
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_sac_cd"           ,       false,          "",       dfNone,    0,     false,       false);
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     false,       false);
                    }
                    InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "cntr_tpsz_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  true,    "io_bnd_cd",        false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,    "dcgo_ind_cd",      false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,    "rc_flg",           false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "tml_wrk_dy_cd",    false,          "",      dfDateYmd,  0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,    "ioc_cd",           false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,    "tml_trns_mod_cd",  false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,    "lane_cd",          false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,  true,    "tier",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "calc_vol_qty",     false,          "",       dfNone,    0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtPopup,   80,    daCenter,  true,    "rvis_vol_qty",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    40,    daCenter,  true,    "vol_tr_ut_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,  true,    "ctrt_rt",          false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,  true,    "curr_cd",          false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,  true,    "inv_xch_rt",       false,          "",       dfFloat,   5,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "rf_mntr_dys",      false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    60,    daCenter,  true,    "inv_amt",          false,          "",       dfFloat,   2,     true,       true);
                    
                    if(ida_ofc_cd == 'Y'){
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_gst_rto"          ,       false,          "",       dfFloat,   2,     false,      false);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_gst_amt"          ,       false,          "",       dfFloat,   2,     false,      false);
	                } else {
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_gst_rto"         ,       false,          "",       dfFloat,   2,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_gst_amt"         ,       false,          "",       dfFloat,   2,     false,       true);  
                    }
                    
                    InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "calc_rmk",         false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  true,    "tml_crr_cd",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtPopup,   40,    daCenter,  true,    "n3pty_flg",        false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,  70,    daCenter,  true,    "tml_so_dtl_seq",   false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,  30,    daCenter,  true,    "edi_so_dtl_id",    false,          "",       dfNone,    0,     false,      true);

                    initDataCombo(0,"calc_tp_cd","Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
                    if(ida_ofc_cd == 'Y'){
                    	InitDataCombo(0 , "ida_pay_tp_cd"	     , "Goods|Services", "G|S");
                    }
			}
                break;

             case 4:      //main_hidden init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(47, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
                    var HeadTitle = "|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
								+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
								+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|vndr_nm|err_inv_no|whld_tax_amt|edi_flg|rtro_tml_inv_flg|ap_rvs_cng_flg|"
								+"dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";

/*                    var HeadTitle = "|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
                    								+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
                    								+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|hld_flg|edi_flg";
*/
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCdtHiddenStatusDATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,     30  ,  daCenter,  false,    "ibflag"			   ,	 false,          "",       dfNone,         0,    false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,  daCenter,  false,    "sts"			       ,	 false,          "",       dfNone,         0,    false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_so_ofc_cty_cd"  ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_so_seq"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_ofc_cd"         ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "cost_ofc_cd"        ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_no"             ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "vndr_seq"           ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "yd_cd"              ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "yd_nm"              ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "curr_cd"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ttl_inv_amt"        ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "vat_amt"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ttl_calc_amt"       ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "fm_prd_dt"  	       ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "hld_flg"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "hld_rmk"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "to_prd_dt"          ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_tp_cd"      ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_cost_grp_cd"    ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_calc_ind_cd"    ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "sto_dys_ind_cd"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "iss_dt"             ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "rcv_dt"             ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "eff_dt"             ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "pay_due_dt"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "pay_flg"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_sts_cd"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_sts_nm"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_rjct_sts_cd",     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_cfm_dt"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_agmt_ofc_cty_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_agmt_seq"       ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_agmt_ver_no"    ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_rjct_rmk"       ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "vndr_nm"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "err_inv_no"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "whld_tax_amt"       ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "edi_flg"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "rtro_tml_inv_flg"   ,     false,          "",       dfNone,         0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ap_rvs_cng_flg"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "file_chk"            ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "dbt_note_no"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_cgst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_sgst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_igst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_ugst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    
                    style.height = GetSheetHeight(3) ;
						}
                break;


           case 5:      //vvd_hidden init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND|ATB_DT|VVD_TYPE|CRE_DT|VVD_AMOUNT|VVD|VVD_1|VVD_CALL_YD_IND_SEQ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus, 100,    daCenter,  false,   "vvd_ibflag",                false,          "",       dfNone,    0,     false,      true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_ofc_cty_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_seq",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_vvd_list_seq",   false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_vsl_cd",                false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_skd_voy_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_skd_dir_cd",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_io_bnd_cd",             false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_atb_dt",                false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_type",                  false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "cre_dt",                    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_amt",                   false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd",                       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_1",                     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_call_yd_ind_seq",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtHidden,  100,    daCenter,  true,    "vvd_clpt_ind_seq",          false,          "",       dfNone,    0,     true,       true);

                    style.height = GetSheetHeight(4) ;

               }
                break;
           case 6:      //sheet_accumulate Vol. init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "ibflg|pay_vol_qty|accm_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,      100,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,  true,     "pay_vol_qty",	 false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,  true,     "accm_seq"   ,	 false,          "",       dfNone,    0,     true,       true);

                    style.height = GetSheetHeight(3) ;

               }
               break;


            case 7:      //total_amt init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);


                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "vvd|io_bnd_cd|cost_cd|inv_amt";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  false,    "vvd"            ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  false,    "io_bnd_cd"      ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  false,    "sum_basis"	    ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "lgs_cost_cd"    ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "inv_amt"        ,       false,          "",       dfFloat,   2,     false,       false);
                    	}
                break;

        }
    }

    /**
     * main_hidden sheet에  Coincidency, Discrepancy값을 모두 가져와 담아준다.
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet_main_hidden(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg = false;

        switch(sAction){
            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCH;
            
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0017GS.do", tesFrmQryStr(formObj));
				var arrXml = searchXml.split("|$$|"); 
	            sheetObjects[3].LoadSearchXml(arrXml[0]);
	            //권한체크시 vvd_hidden onsearch end 를 먼저타게 됨으로서 발생함
	            auth_ofc_main_hidden_xml = arrXml[1];
//	            sheetObjects[4].LoadSearchXml(arrXml[1]);
	            
	            searchXml=null; arrXml[0]=null; arrXml[1]=null;
				
               /* 
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_0017GS.do", FormQueryString(formObj));
	            sheetObj.LoadSearchXml(searchXml,true);
	            var sxml0 = sheetObj.EtcData("sxml0");
	            var sxml1 = sheetObj.EtcData("sxml1");
	            sheetObj.RemoveEtcData();
	            sheetObjects[3].LoadSearchXml(sxml0);
	            sheetObjects[4].LoadSearchXml(sxml1);
	            searchXml=null; sxml0=null; sxml1=null;          
	            */
               
                break;
            case IBSAVE:        //저장
                break;
        }
    }




    /**main_hidden Sheet의 data를 form으로 보내주고,
    * MarineTerminal Invoice일 경우 Container List를 조회하는 함수를 호출한다.
    * @param sheetObj
    * */
    function main_hidden_OnSearchEnd(sheetObj){
        var formObj = document.form;
        
		if(isMRInvoice(sheetObj)==false){
		    return false;
		}
        
        if(sheetObj.RowCount == 1){
            if(isMarineTerminalINV()== false){
                ComShowCodeMessage('TES21508'); //showErrMessage("Marine Terminal Type Invoice가 아닙니다.");
                return false;
            }else{
            	formObj.no_ofc_cd.value = sheetObjects[3].CellValue(1,'inv_ofc_cd');
            	formObj.no_yd_cd.value  = sheetObjects[3].CellValue(1,'yd_cd');

            	mainHidden2Form(sheetObj, formObj);
            	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
            	
            }
        }
        
    }
    
  

    /**
     * main_hidden Sheet의 tml_inv_tp_cd의 값을 검사하여
     * Marine Termianal Invoice인지 확인하여 맞다면 true, 아니라면 false값을 리턴한다.
     */
    function isMarineTerminalINV(){
        var sheetObject = sheetObjects[3];
        if(sheetObject.CellValue(1,"tml_inv_tp_cd") =="TM"){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Marine Terminal Invoice인지 확인
     * @param {ibsheet}	sheetObj	sheet object	 
     */
    function isMRInvoice(sheetObj){
        if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "ON"){
            ComShowMessage(ComGetMsg('TES21029')); //ComShowMessage("On-dock Rail Invoice 와 중복됩니다.");
            setInitComponent("N");
            return false;
        }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "OF"){
            ComShowMessage(ComGetMsg('TES21030')); //ComShowMessage("Off Dock Cy Invoice 와 중복됩니다.");
            setInitComponent("N");
            return false;
        }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "ST"){
            ComShowMessage(ComGetMsg('TES21031')); //ComShowMessage("Marine Terminal Storage Invoice 와 중복됩니다.");
            setInitComponent("N");
            return false;
        }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "TM"){
            return true;
		}
    }


    
    /**
     * containerlist_hidden Sheet에 Coincidency, Discrepancy값을 모두 가져와 담아준다.
     * @param sheetObj
     * @param formObj
     * @param sAction
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case(IBSEARCH):
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0017GS.do", tesFrmQryStr(formObj));
                
				var arrXml = searchXml.split("|$$|"); 
	            sheetObjects[0].LoadSearchXml(arrXml[0]);
	            sheetObjects[1].LoadSearchXml(arrXml[1]);
	            sheetObjects[2].LoadSearchXml(arrXml[2]);
	            sheetObjects[5].LoadSearchXml(arrXml[3]);
	            sheetObjects[6].LoadSearchXml(arrXml[4]);
	            searchXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null; arrXml[3]=null; arrXml[4]=null;
                break;
                
  /*              
                sheetObj.LoadSearchXml(searchXml,true);
            	var sxml0 = sheetObj.EtcData("sxml0");
            	var sxml1 = sheetObj.EtcData("sxml1");
            	var sxml2 = sheetObj.EtcData("sxml2");
            	var sxml3 = sheetObj.EtcData("sxml3");
            	var sxml4 = sheetObj.EtcData("sxml4");

            	sheetObj.RemoveEtcData();
            	sheetObjects[0].LoadSearchXml(sxml0);
            	sheetObjects[1].LoadSearchXml(sxml1);
            	sheetObjects[2].LoadSearchXml(sxml2);
            	sheetObjects[5].LoadSearchXml(sxml3);
            	sheetObjects[6].LoadSearchXml(sxml4);
            	searchXml=null; sxml0=null; sxml1=null; sxml2=null; sxml3=null; sxml4=null;
                break;
*/
        }
    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param tab_obj
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     * @param(tab_obj)
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Coincidence" , -1 );
                    InsertTab( cnt++ , "Discrepancy" , -1 );
                    InsertTab( cnt++ , "Cost Calculation" , -1 );
                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * @param(tabObj)
     * @param(nItem)
     */
    function tab1_OnChange(tabObj , nItem)
    {


        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;

    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

    function t3sheet1_OnPopupClick (sheetObj, row, col)    {
        var formObj = document.form;
        if (sheetObj.ColSaveName(col) == "n3pty_flg"){
			var url_str = "ESD_TES_9252Pop.screen";
            url_str = url_str + "?tml_so_ofc_cty_cd="+formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + "&tml_so_seq="+formObj.tml_so_seq.value;
            url_str = url_str + "&tml_so_dtl_seq="+sheetObj.CellValue(row,"tml_so_dtl_seq");
            url_str = url_str + "&inv_no="+formObj.inv_no.value;
            url_str = url_str + "&curr_cd="+formObj.curr_cd.value;
            window.showModalDialog(url_str, window, "dialogWidth:800px; dialogHeight:450px; help:no; status:no; resizable:yes;");
        } else if (sheetObj.ColSaveName(col) == "rvis_vol_qty"){
            if(sheetObj.CellValue(row, "lgs_cost_cd") == 'SVXXJO'){
			    ComShowCodeMessage('TES40021'); //showErrMessage("SVXJO의 경우 Revised Vol. Popup을 사용할 수 없습니다.");
			    return false;
			}

			if (sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="A"){
			    var url_str = "ESD_TES_9072Pop.screen";
					url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
					url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
					url_str += "&vndr_seq="				+formObj.vndr_seq.value;
					url_str += "&yd_cd="				+formObj.yd_cd.value;
					url_str += "&vvd="				    +formObj.vvd.value;
					url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
					url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
					url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
					url_str += "&dcgo_ind_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
					url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
					url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd");
					url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
					url_str += "&tml_trns_mod_cd="		+sheetObj.CellValue(row,"tml_trns_mod_cd");
					url_str += "&cal_vol="				+sheetObj.CellValue(row,"calc_vol_qty");
					url_str += "&fm_tr_vol_val="		+sheetObj.CellValue(row,"fm_tr_vol_val");
					url_str += "&to_tr_vol_val="		+sheetObj.CellValue(row,"to_tr_vol_val");
					url_str += "&rvis_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
					url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
					url_str += "&calc_tp_cd="           +sheetObj.CellValue(row,"calc_tp_cd");
					url_str += "&cntr_sty_cd="          +sheetObj.CellValue(row,"cntr_sty_cd");
					url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(row,"tml_so_dtl_seq");
					url_str += "&ctrt_rt="              +sheetObj.CellValue(row,"ctrt_rt");
					url_str += "&opener_row="			+row;
				window.showModalDialog(url_str, window, "dialogWidth:440px; dialogHeight:450px; help:no; status:no; resizable:yes;");
			} else if(sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="M") {
				if (sheetObj.CellValue(row,'lgs_cost_cd') == "SVRHCD" || sheetObj.CellValue(row,'lgs_cost_cd')=="SVRHCC" ){
					var url_str = "ESD_TES_9191Pop.screen";
    					url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
    					url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
    					url_str += "&tml_so_dtl_seq="		+sheetObj.CellValue(row,"tml_so_dtl_seq");
    					url_str += "&vvd="				    +formObj.vvd.value;
    					url_str += "&yd_cd="				+formObj.yd_cd.value;
    					url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
    					url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
    					url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
    					url_str += "&dcgo_clss_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
    					url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
    					url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd");
    					url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
    					url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
    					url_str += "&rh_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
    					url_str += "&opener_row="			+row;
    					url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(row,"edi_so_dtl_id");
						window.showModalDialog(url_str, window, "dialogWidth:420px; dialogHeight:420px; help:no; status:no; resizable:yes;");
				} else{
					var url_str = "ESD_TES_9072Pop.screen";
						url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
						url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
						url_str += "&vndr_seq="				+formObj.vndr_seq.value;
						url_str += "&yd_cd="				+formObj.yd_cd.value;
						url_str += "&vvd="				    +formObj.vvd.value;
						url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
						url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
						url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
						url_str += "&dcgo_clss_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
						url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
						url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd");
						url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
						url_str += "&tml_trns_mod_cd="		+sheetObj.CellValue(row,"tml_trns_mod_cd");
						url_str += "&cal_vol="				+sheetObj.CellValue(row,"calc_vol_qty");
						url_str += "&fm_tr_vol_val="		+sheetObj.CellValue(row,"fm_tr_vol_val");
						url_str += "&to_tr_vol_val="		+sheetObj.CellValue(row,"to_tr_vol_val");
						url_str += "&rvis_div="				+'N';
						url_str += "&rvis_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
						url_str +="&calc_tp_cd="            +sheetObj.CellValue(row,"calc_tp_cd");
						url_str += "&opener_row="			+row;
    					url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(row,"tml_so_dtl_seq");
    					url_str += "&ctrt_rt="              +sheetObj.CellValue(row,"ctrt_rt");
    					url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(row,"edi_so_dtl_id");
						window.showModalDialog(url_str, window, "dialogWidth:440px; dialogHeight:450px; help:no; status:no; resizable:yes;");
				}
			}

        }
    }

    /**
	 * 입력값의 길이를 확인하고, 입력받은 VNDR Seq가 6자리가되면
	 * 해당 VNDR Seq의 존재여부를 확인하고 VNDR Name을 화면에 보여주는 함수를 호출한다.
	 * @param(obj) input text 객체
	 */
	function chkInput(obj) {
	//	showErrMessage('strleng: '+getStrLen(obj.value));
		if (obj.maxLength < tes_getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
		validateVndrSeq();
	}

     /**
	 * 입력된 vndr_seq값을 Validation하는 함수
	 *
	 */
	function validateVndrSeq() {
		var formObj = document.form;
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}

		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}

		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}

	function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.ida_gst_rgst_ste.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.ida_gst_rgst_no.value = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
					formObj.ida_ste_cd.value = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
					formObj.ida_ste_nm.value = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
				formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
			formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

		}
	}



	/**
     * Vendor Help 화면에서 선택한 벤더를 작업화면으로 보내준다.
     * @param(rowArray) 
     */
    function getVender(rowArray) {
    	var colArray = rowArray[0];
    	//document.all.vndr_seq.value = colArray[2].substr(2,6);
    	document.all.vndr_seq.value = colArray[6];
    	document.all.vndr_seq_name.value = colArray[4];
    	
    	var idaGstRgstSte = colArray[10];
		if(idaGstRgstSte == 'R'){
			document.all.ida_gst_rgst_ste.value = "Registered";
		} else if(idaGstRgstSte == 'U') {
			document.all.ida_gst_rgst_ste.value = "Unregistered";
		} else if(idaGstRgstSte == 'C') {
			document.all.ida_gst_rgst_ste.value = "Composite";
		}
		
		document.all.ida_gst_rgst_no.value=colArray[11];
		document.all.ida_ste_cd.value=colArray[12];
		document.all.ida_ste_nm.value=colArray[13];
    }
    




    /**
     * vvd_hidden 조회된 값을 form에 보여주는 기능
     * @param(sheetObj) sheet object 
     */
    function vvd_hidden_OnSearchEnd(sheetObj){
        var formObj = document.form;

        //retrieve 버튼 클릭시
        if(sheetObj.RowCount > 0 && ComIsNull(formObj.vvd.value) && ComIsNull(formObj.atb_dt.value)){

            if(formObj.vvd.value == '' && sheetObj.CellValue(1, 'vvd_atb_dt') != '' && formObj.tml_so_seq.value !=''){
                formObj.vvd.value = sheetObj.CellValue(1,"vvd_vsl_cd")+sheetObj.CellValue(1,"vvd_skd_voy_no")+sheetObj.CellValue(1,"vvd_skd_dir_cd");
                formObj.io_bnd_cd.value = sheetObj.CellValue(1,"vvd_io_bnd_cd");
                formObj.atb_dt.value = sheetObj.CellValue(1,"vvd_atb_dt");
                io_hidden = sheetObj.CellValue(1,"vvd_io_bnd_cd");
                formObj.call_yd_ind_seq.value = sheetObj.CellValue(1,"vvd_call_yd_ind_seq");
                formObj.clpt_ind_seq.value = sheetObj.CellValue(1,"vvd_clpt_ind_seq");
            }
        }

        if(sheetObj.RowCount > 0 && formObj.tml_so_seq.value !=''){
            formObj.page.value = sheetObj.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.value+formObj.clpt_ind_seq.value) +' / '+sheetObj.RowCount;
        }else{
            formObj.page.value = '';
        }
    }



    /**
     * t1sheet1 Search 시 CNRT SUMMARY 기능 및
     * discrepancy tab에서 이동한 데이타에 한해 discrepancy tab으로 이동 가능하도록 초기화
     * @param(sheetObj) sheet Object 
     */
    function t1sheet1_OnSearchEnd(sheetObj){
        var formObj = document.form;

        formObj.sht_01_ttl.value	= 0;
        formObj.sht_01_full.value	= 0;
        formObj.sht_01_mt.value		= 0;
        formObj.sht_01_ts_same_yard.value = 0;
        formObj.sht_01_D2.value = 0;
        formObj.sht_01_D2.value = 0;
        formObj.sht_01_D4.value = 0;
        formObj.sht_01_D5.value = 0;
        formObj.sht_01_D7.value = 0;
        formObj.sht_01_D8.value = 0;
        formObj.sht_01_D9.value = 0;
        formObj.sht_01_DW.value = 0;
        formObj.sht_01_DX.value = 0;
        formObj.sht_01_R2.value = 0;
        formObj.sht_01_R4.value = 0;
        formObj.sht_01_R5.value = 0;
        formObj.sht_01_R7.value = 0;
        formObj.sht_01_R8.value = 0;
        formObj.sht_01_R9.value = 0;
        formObj.sht_01_F2.value = 0;
        formObj.sht_01_F4.value = 0;
        formObj.sht_01_F5.value = 0;
        formObj.sht_01_O2.value = 0;
        formObj.sht_01_O4.value = 0;
        formObj.sht_01_O5.value = 0;
        formObj.sht_01_O7.value = 0;
        formObj.sht_01_S2.value = 0;
        formObj.sht_01_S4.value = 0;
        formObj.sht_01_T2.value = 0;
        formObj.sht_01_T4.value = 0;
        formObj.sht_01_A2.value = 0;
        formObj.sht_01_A4.value = 0;
        formObj.sht_01_A5.value = 0;
        formObj.sht_01_P2.value = 0;
        formObj.sht_01_P4.value = 0;
        //formObj.sht_01_Z2.value = 0;
        //formObj.sht_01_Z4.value = 0;
        formObj.sht_01_C2.value = 0;
        formObj.sht_01_C4.value = 0;

        formObj.sht_01_ttl.value = sheetObjects[0].RowCount;

        for(var i=1; i<=sheetObj.RowCount; i++){

            with(formObj){
                if(sheetObj.CellValue(i,"cntr_sty_cd")=='F'){
                    sht_01_full.value++;
                }else if(sheetObj.CellValue(i,"cntr_sty_cd")=='M'){
                    sht_01_mt.value++;
                }

                if(sheetObj.CellValue(i,"sam_locl_ts_ind_cd")=='T'){
                    sht_01_ts_same_yard.value++;
                }
                eval('sht_01_'+sheetObj.CellValue(i,"cntr_tpsz_cd")).value++;
            }
        }
        setTooltip(sheetObj,'cntr_rmk');

        for(var i= sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i,'dscr_ind_cd')=='CO'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Coincidence';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='HO'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'SML List only';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='HD'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'SML List double';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='NH'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Not in SML source';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='DB'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Double billing';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='DD'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Discrepancy by detail data';
			}
        }
    }

    function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg){
		setTooltip(t2sheet1,'cntr_rmk');
	}

	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		setTooltip(sheetObj,'calc_rmk');

		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			// 변환문자를 특수 문자로 치환. (2010-04-23)
        	sheetObj.CellValue2(i, "calc_rmk") = ComToString( sheetObj.CellValue(i, "calc_rmk") );
			
           if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='WD'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Week day';
			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='SA'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Saturday';
			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='SU'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Sunday';
			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='HO'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Holiday';
			}

			if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='C'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Container';
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='T'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'TEU';
    		    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='B'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'BOX';
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='M'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Move';
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='G'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Gang/Hour';
    		// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
    		} else if (sheetObj.CellValue(i, 'vol_tr_ut_cd') == 'W'){
    			sheetObj.ToolTipText(i, 'vol_tr_ut_cd') = 'Ton';
    		}
        }
    }


    function accm_hidden_OnSearchEnd(sheetObj){
	    var formObj = document.form;
	    if(sheetObj.RowCount>0){
	        formObj.pay_vol_qty.value = tes_addComma(sheetObj.CellValue(1, 'pay_vol_qty'));
	    }
	}


	function total_hidden_OnSearchEnd(sheetObj){
	    ShowCalculatedAmountByVVD();
	}

	/**
	 * 현재 화면(현재 VVD)의 Cost Calculation 탭의 Invoice Amount 의 합을 구해서
	 * form.vvd_inv_amt.value에 값을 보여줌
	 */
	function ShowCalculatedAmountByVVD(){
	    var sheetObj = sheetObjects[2];
        var tot_hidden = sheetObjects[6];
        var formObj = document.form;
	    var total_amt = 0;
        var curr_amt = 0;

        for(var i=tot_hidden.HeaderRows; i<tot_hidden.HeaderRows+tot_hidden.RowCount; i++){
            if((tot_hidden.CellValue(i,'vvd')+tot_hidden.CellValue(i,'io_bnd_cd'))!=(formObj.vvd.value+formObj.io_bnd_cd.value)){
                total_amt = Math.round(total_amt*100)/100 + Math.round(tot_hidden.CellValue(i,'inv_amt')*100)/100;
            }
        }
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            curr_amt = Math.round(curr_amt*100)/100 + Math.round(sheetObj.CellValue(i,'inv_amt')*100)/100;
        }
        curr_amt = Math.round(curr_amt*100)/100;
        total_amt = Math.round((total_amt + curr_amt)*100)/100;
        formObj.vvd_inv_amt.value = tes_chkAmtFmt(curr_amt, formObj.curr_cd.Code);
        formObj.tot_inv_amt.value = tes_chkAmtFmt(total_amt, formObj.curr_cd.Code);
	}


	function vvd_bnd_combo_OnChange(comboObj, code, text){
		
		var formObj = document.form;
		var vvd_hidden = sheetObjects[4];
		
		var idx = 1;
		if(code != null && code != -1) {
			idx = vvd_hidden.FindText('vvd', code);
		}
		
		formObj.vvd.value = vvd_hidden.CellValue(idx,'vvd').substring(0,9);
        formObj.io_bnd_cd.value = vvd_hidden.CellValue(idx,'vvd_io_bnd_cd');
        io_hidden = vvd_hidden.CellValue(idx,'vvd_io_bnd_cd');
        formObj.atb_dt.value = vvd_hidden.CellValue(idx,'vvd_atb_dt');
        formObj.call_yd_ind_seq.value = vvd_hidden.CellValue(idx,"vvd_call_yd_ind_seq");
        formObj.clpt_ind_seq.value = vvd_hidden.CellValue(idx,'vvd_clpt_ind_seq');
        formObj.page.value = idx +' / '+vvd_hidden.RowCount;

        doActionIBSheet(sheetObjects[4],formObj,IBSEARCH);
	}
	
//	function findPage(dir){
//        var vvd_hidden = sheetObjects[4];
//        var formObj = document.form;
//        var page = vvd_hidden.FindText('vvd', formObj.vvd.value+io_hidden);
//
//        page = page + eval(dir);
//
//        formObj.vvd.value = vvd_hidden.CellValue(page,'vvd').substring(0,9);
//        formObj.io_bnd_cd.value = vvd_hidden.CellValue(page,'vvd_io_bnd_cd');
//        io_hidden = vvd_hidden.CellValue(page,'vvd_io_bnd_cd');
//        formObj.atb_dt.value = vvd_hidden.CellValue(page,'vvd_atb_dt');
//        formObj.page.value = page +' / '+vvd_hidden.RowCount;
//
//        doActionIBSheet(sheetObjects[4],formObj,IBSEARCH);
//    }

    function reSize(){
		var div01 = document.all.SearchLayer01.style.display ;
		var div02 = document.all.SearchLayer02.style.display ;
		var obj = event.srcElement;
		if ( div01 == "inline" ){
			obj.src = "/hanjin/img/bu_prev01.gif";
			document.all.SearchLayer01.style.display = "none" ;
			document.all.SearchLayer02.style.display = "none" ;
		} else {
			obj.src = "/hanjin/img/bu_next01.gif";
			document.all.SearchLayer01.style.display = "inline" ;
			document.all.SearchLayer02.style.display = "inline" ;
		}
	}
    
    function setFormValue(){
    	var formObject = document.form;
		
		var checkInv = "N";
		var checkVndr = "N";
		
		if(formObject.inv_no_tmp.value == sheetObjects[3].CellValue(1, 'inv_no'))checkInv = "Y";
		if(vndr_seq == tes_lpad(sheetObjects[3].CellValue(1, 'vndr_seq'),6,'0'))checkVndr = "Y";
		
    	if(document.form.auth_ofc_cd.value.trim()=="Y"){
         	
            formObject.tml_so_ofc_cty_cd.value = sheetObjects[3].CellValue(1,'tml_so_ofc_cty_cd');
            formObject.tml_so_seq.value = sheetObjects[3].CellValue(1,'tml_so_seq');
            formObject.inv_ofc_cd.value = sheetObjects[3].CellValue(1,'inv_ofc_cd');
            formObject.cost_ofc_cd.value = sheetObjects[3].CellValue(1,'cost_ofc_cd');
            formObject.yd_cd.value = sheetObjects[3].CellValue(1,'yd_cd');
            formObject.yd_nm.value = sheetObjects[3].CellValue(1,'yd_nm');
            formObject.curr_cd.value = sheetObjects[3].CellValue(1,'curr_cd');
            formObject.hld_flg.value = sheetObjects[3].CellValue(1,'hld_flg');
            formObject.hld_rmk.value = sheetObjects[3].CellValue(1,'hld_rmk');
            formObject.iss_dt.value = sheetObjects[3].CellValue(1,'iss_dt');
            formObject.rcv_dt.value = sheetObjects[3].CellValue(1,'rcv_dt');
            formObject.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[3].CellValue(1,'ttl_inv_amt'));
            formObject.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[3].CellValue(1,'whld_tax_amt'));
            formObject.vat_amt.value = tes_chkAmtFmt(sheetObjects[3].CellValue(1,'vat_amt'));
            formObject.pay_due_dt.value = sheetObjects[3].CellValue(1,'pay_due_dt');

            if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'R'){
                formObject.tml_inv_sts_cd.value = 'Received';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'C'){
                formObject.tml_inv_sts_cd.value = 'Confirmed';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'P'){
                formObject.tml_inv_sts_cd.value = 'AP Interfaced';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'A'){
                formObject.tml_inv_sts_cd.value = 'Approval Request';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'D'){
                formObject.tml_inv_sts_cd.value = 'Paid';
            }

            if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'NL'){
                formObject.tml_inv_rjct_sts_cd.value = 'Normal';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RJ'){
                formObject.tml_inv_rjct_sts_cd.value = 'Rejected';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RL'){
                formObject.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
            }
            
            if(sheetObjects[3].CellValue(1,'edi_flg') == 'Y'){
                //document.all.EDILayer01.style.display = "inline";
            	formObject.edi_flg.value = 'Y';
            }else{
                //document.all.EDILayer01.style.display = "none";
            	formObject.edi_flg.value = '';
            }

            //Amount 에 관련된 값은 ####.## 형식으로 값을 보여주기위해 tesCommon의 tes_chkAmtFmtObj를 이용한다.
//            tes_chkAmtFmtObj(formObject.ttl_inv_amt);
//            tes_chkAmtFmtObj(formObject.vat_amt);
            
			sheetObjects[4].LoadSearchXml(auth_ofc_main_hidden_xml);
			ComXml2ComboItem(auth_ofc_main_hidden_xml, formObject.vvd_bnd_combo, "vvd", "vvd_1|vvd_io_bnd_cd|vvd_call_yd_ind_seq");
			formObject.vvd_bnd_combo.Index = 0;
			
			auth_ofc_main_hidden_xml = null;
		    if(isMarineTerminalINV()==true){
		    	doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
		    }
			
     	}else if(formObject.flag.value == "Y" && checkInv == 'Y' && checkVndr == 'Y'){
     		
     		formObject.tml_so_ofc_cty_cd.value = sheetObjects[3].CellValue(1,'tml_so_ofc_cty_cd');
            formObject.tml_so_seq.value = sheetObjects[3].CellValue(1,'tml_so_seq');
            formObject.inv_ofc_cd.value = sheetObjects[3].CellValue(1,'inv_ofc_cd');
            formObject.cost_ofc_cd.value = sheetObjects[3].CellValue(1,'cost_ofc_cd');
            formObject.yd_cd.value = sheetObjects[3].CellValue(1,'yd_cd');
            formObject.yd_nm.value = sheetObjects[3].CellValue(1,'yd_nm');
            formObject.curr_cd.value = sheetObjects[3].CellValue(1,'curr_cd');
            formObject.hld_flg.value = sheetObjects[3].CellValue(1,'hld_flg');
            formObject.hld_rmk.value = sheetObjects[3].CellValue(1,'hld_rmk');
            formObject.iss_dt.value = sheetObjects[3].CellValue(1,'iss_dt');
            formObject.rcv_dt.value = sheetObjects[3].CellValue(1,'rcv_dt');
            formObject.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[3].CellValue(1,'ttl_inv_amt'));
            formObject.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[3].CellValue(1,'whld_tax_amt'));
            formObject.vat_amt.value = tes_chkAmtFmt(sheetObjects[3].CellValue(1,'vat_amt'));
            formObject.pay_due_dt.value = sheetObjects[3].CellValue(1,'pay_due_dt');

            if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'R'){
                formObject.tml_inv_sts_cd.value = 'Received';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'C'){
                formObject.tml_inv_sts_cd.value = 'Confirmed';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'P'){
                formObject.tml_inv_sts_cd.value = 'AP Interfaced';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'A'){
                formObject.tml_inv_sts_cd.value = 'Approval Request';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_sts_cd') == 'D'){
                formObject.tml_inv_sts_cd.value = 'Paid';
            }

            if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'NL'){
                formObject.tml_inv_rjct_sts_cd.value = 'Normal';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RJ'){
                formObject.tml_inv_rjct_sts_cd.value = 'Rejected';
            }else if(sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') == 'RL'){
                formObject.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
            }
			
            if(sheetObjects[3].CellValue(1,'edi_flg') == 'Y'){
                //document.all.EDILayer01.style.display = "inline";
            	formObject.edi_flg.value = 'Y';
            }else{
                //document.all.EDILayer01.style.display = "none";
            	formObject.edi_flg.value = '';
            }
			

            //Amount 에 관련된 값은 ####.## 형식으로 값을 보여주기위해 tesCommon의 tes_chkAmtFmtObj를 이용한다.
//            tes_chkAmtFmtObj(formObject.ttl_inv_amt);
//            tes_chkAmtFmtObj(formObject.vat_amt);
            
			sheetObjects[4].LoadSearchXml(auth_ofc_main_hidden_xml);
			ComXml2ComboItem(auth_ofc_main_hidden_xml, formObject.vvd_bnd_combo, "vvd", "vvd_1|vvd_io_bnd_cd|vvd_call_yd_ind_seq");
			formObject.vvd_bnd_combo.Index = 0;
			
			auth_ofc_main_hidden_xml = null;
		    if(isMarineTerminalINV()==true){
		    	doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
		    }
     		
     	}else{
     		ComShowMessage(ComGetMsg('TES21051'));
     		document.form.auth_ofc_cd.value = "";
            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
     	}
    	
    	//[CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
    	try {
			 for (var i = 0; i < formObject.elements.length; i++){
				 if (formObject.elements[i].name != null && formObject.elements[i].name.trim() != '' && 
						 formObject.elements[i].name.substring(0,9) == 'pre_cond_')
				 {
					 with (formObject) {
						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
							 document.all.PreInquiryCondLayer01.style.display = "inline";
							 break;
						 }
					 }
				 }
			 }
		 } catch(e){}
     	
     }    
    
    
	/**
	 *  Grid에서 Vender Pop으로 값을 가져오는 함수
	 *  @param(rowArray) 로우배열
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		//ComShowMessage(colArray);
		document.all.vndr_seq.value = colArray[2];
		document.all.vndr_seq_nm.value = colArray[4];
		
		var idaGstRgstSte = colArray[10];
		if(idaGstRgstSte == 'R'){
			document.all.ida_gst_rgst_ste.value = "Registered";
		} else if(idaGstRgstSte == 'U') {
			document.all.ida_gst_rgst_ste.value = "Unregistered";
		} else if(idaGstRgstSte == 'C') {
			document.all.ida_gst_rgst_ste.value = "Composite";
		}
		
		document.all.ida_gst_rgst_no.value=colArray[11];
		document.all.ida_ste_cd.value=colArray[12];
		document.all.ida_ste_nm.value=colArray[13];
	}
	
	  /**
     * main_hidden Sheet의 data를 form으로 Copy
     * @param {ibsheet}	sheetObj	sheetObj
     * @param {form}	formObj		formObj
     */
    function mainHidden2Form(sheetObj, formObj){//alert("start mainHidden2Form");
        
        //India GST Amount
        formObj.dbt_note_no.value			= sheetObj.CellValue(1, 'dbt_note_no' );
        formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_cgst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_sgst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_igst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_ugst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        
        formObj.ttl_inv_amt.value			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ttl_inv_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.vat_amt.value			    = tes_chkAmtFmt(sheetObj.CellValue(1, 'vat_amt'     ),sheetObj.CellValue(1,'curr_cd'));
        formObj.whld_tax_amt.value			= tes_chkAmtFmt(sheetObj.CellValue(1, 'whld_tax_amt'),sheetObj.CellValue(1,'curr_cd'));

        if (sheetObj.CellValue(1, 'ap_rvs_cng_flg')=='Y') {
        	formObj.ap_rvs_cng_flg.checked = true;
        } else {
        	formObj.ap_rvs_cng_flg.checked = false;
        }
        
        if (sheetObj.CellValue(1, 'rtro_tml_inv_flg')=='Y') {
        	formObj.rtro_tml_inv_flg.checked = true;
        } else {
        	formObj.rtro_tml_inv_flg.checked = false;
        }
    }


    
	/** invoice 코드 체크
	 * 
	 * @return
	 */
	function validateErrInvNo() {
		var formObj = document.form;

		formObj.err_inv_no.value = formObj.err_inv_no.value.trim();
		if (formObj.err_inv_no.value!=null && formObj.err_inv_no.value.trim()!=''){
			tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
		}
	}
	
	/** invoice 코드 체크
	 * 
	 * @return
	 */
	function checkValidErrInvNo(){
		var formObj = document.form;

		if (formObj.is_valid_err_inv_no.value!=undefined && formObj.is_valid_err_inv_no.value!=null && formObj.is_valid_err_inv_no.value.trim()=='Y'){
		    sheetObjects[3].CellValue(1,'err_inv_no') = formObj.err_inv_no.value;
			//ComShowMessage('ERR_INV_NO 오케바리');
		} else {
			formObj.is_valid_err_inv_no.value = '';
			ComShowMessage(ComGetMsg('TES40058','ERR INV.NO')); //ComShowMessage('존재하지 않는 ERR INV.NO입니다.');
		}
	}
	
	/** 엔터키 코드 체크 함
	 * 
	 * @param {String} funcNm	function name
	 * @return
	 */
	function enterCheck(funcNm){
        var formObj = document.form;
		if (funcNm==undefined || funcNm==null || funcNm.trim()==''){return false;}
		if (event.keyCode == 13){retrieveAll();}
	}
	
	
	//================================= Invoice No 관련 함수 시작 =============================================
    /**
	 * 입력된 Invoice No가 기 존재하는 중복된 것이 아닌지 확인하는 함수
	 */
	function validateInvDupChk() {
		var formObj = document.form;
		if (formObj.inv_no.value==null || formObj.inv_no.value.trim()==''){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			return false;
		}
		
		if ((formObj.inv_no_hidden.value==null || formObj.inv_no_hidden.value.trim()=='') || formObj.inv_no.value.trim()!=formObj.inv_no_hidden.value.trim()){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
		}
	}	
	
	/**
	 *  Inv_no Dup Validation 함수
	 */
	function checkInvDup(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_dup_inv_no.value!=undefined && formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value.trim()!=''){
			tmp = formObj.is_dup_inv_no.value;
			if (tmp.length > 0){
				formObj.is_dup_inv_no.value = (tmp!=undefined&&tmp!=null?tmp:'');
				if (formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value == 'Y'){
					//formObj.is_dup_inv_no.value = '';
					//formObj.inv_no_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No. is duplicated. Plz, change to another Invoice No.');
				}
			}
		}
	}
//================================= Invoice No 관련 함수 끝 =================================================
	
