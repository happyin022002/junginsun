/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0040.js
*@FileTitle : Terminal Agreement Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009-08-13 yOng hO lEE
* 1.0 Creation
* 
* 2009-04-15 [R200904150003] : 컬럼 데이타 변경 ( T/S => Mode ) -  자체
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_TES_0040 : ESD_TES_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_0040() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.doActionIBSheet1 		= doActionIBSheet1;
    	this.doActionIBSheet2 		= doActionIBSheet2;
    	this.setTabObject 			= setTabObject;
    }
    
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;


/**
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 **/
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 **/
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var tabObj = tabObjects;	

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					var tmp_agmt_no;
					var tmp_agmt_ver_no;
					var flag = true;
					tmp_agmt_no = formObject.tml_agmt_ofc_cty_cd.value;
					tmp_agmt_ver_no = formObject.tml_agmt_ver_no.value;
					if(ComIsNull(tmp_agmt_no) && ComIsNull(tmp_agmt_ver_no)){
						ComShowCodeMessage('TES50301'); // Insert Agreement No & Agreement Version Information!');
						flag = false;
						return false;
					}else if(tmp_agmt_no==undefined || tmp_agmt_no=='' || tmp_agmt_no==null){
						ComShowCodeMessage('TES50302');	// Insert Agreement No!');
						flag = false;
						return false;
					}else if(tmp_agmt_no.length != 8){
						ComShowCodeMessage('TES50303');	// Insert Correct Agreement No!');
						flag = false;
						return false;
					}else if(tmp_agmt_ver_no==undefined || tmp_agmt_ver_no=='' || tmp_agmt_ver_no==null){
						ComShowCodeMessage('TES50304');	// Insert Agreement Version Information!');
						flag = false;
						return false;
					}else if(tmp_agmt_ver_no.length != 5){
						ComShowCodeMessage('TES50305');	// Insert Correct Agreement Version Information!');
						flag = false;
						return false;
					}
					if(flag){
						sheetObject.RemoveAll();
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						formObject.reset();
						formObject.tml_agmt_ofc_cty_cd.value = tmp_agmt_no;
						formObject.tml_agmt_ver_no.value = tmp_agmt_ver_no;
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					}
					break;


				case "btn_new":
					formObject.reset();
					formObject.tml_agmt_ofc_cty_cd.value='';
					formObject.tml_agmt_ver_no.value='';
					
					formObject.no_ofc_cd.value='';
					formObject.no_yd_cd.value='';
					formObject.auth_ofc_cd.value='';
					formObject.cre_ofc_cd.value='';
					
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					break;

				//sheet의 내용을 excel파일로 다운로드
				case "btng_downexcel":
					var tab;
					tab = formObject.tab1.selectedindex;
					//-------------------Excel Download 결재로직 START--------------------------
 		   	    	/*
 		   	    	 * [CHM-201538739]Excel down 사전 결재 진행건 (시범적용) 2015-12-16
 		   	    	 * 모듈명과 화면명 각 모듈에 맞게 하드코딩
 		   	    	 */
					var authSubSysCd = "TES";
	 		   	    var authPgmNo = "ESD_TES_0040";
	 		   	    
 		   	    	chkXlsBtnPrmtBF(authSubSysCd, authPgmNo, sheetObject);//ETC용 sheet이므로 아무렇게나 넣으셔도 됩니다.
 		   	    	
 		   	    	if(xlsDlRstrActFlg == "N"){
 		   	    		/*
 		   	    		 * 기존 액셀 Download 소스
 		   	    		 */
	 		   	    	if(tab == 0){
							if(sheetObject.RowCount == 0){
								ComShowCodeMessage("TES50306");	// No data at the Terminal Rate List");
								return;
							}else{
								doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
							}
						}else{
							if(sheetObject1.RowCount == 0){
								ComShowCodeMessage("TES50307");	// No data at the Storate Rate List");
								return;
							}else{
								doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
							}
						}
 		   	    	}else if(xlsDlRstrActFlg == "Y"){
	 		   	    		if(authAproStsCd == "C" && !(authAproRqstNo==null || authAproRqstNo==undefined || authAproRqstNo==""|| authAproRqstNo.length != 30)){
	 		   	    			/*
	 	 		   	    		 * 기존 액셀 Download 소스
	 	 		   	    		 */
		 		   	    		if(tab == 0){
									if(sheetObject.RowCount == 0){
										ComShowCodeMessage("TES50306");	// No data at the Terminal Rate List");
										return;
									}else{
										doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
									}
								}else{
									if(sheetObject1.RowCount == 0){
										ComShowCodeMessage("TES50307");	// No data at the Storate Rate List");
										return;
									}else{
										doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
									}
								}
	 		   	    		}else if(authAproStsCd == "P"){
	 		   	    			//ComShowMessage("The approval for Excel Download is in progress\n[Rqst No.:"+authAproRqstNo+"]");
	 		   	    			ComShowMessage(ComGetMsg('AUTH00001', authAproRqstNo));
	 		   	    		}else{
	 		   	    			var param = "?sub_sys_cd="+authSubSysCd+"&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no="+authPgmNo;
	 		   	    			chkXlsDnPopup(param); //결재창 Popup
	 		   	    		}
 		   	    	}else{
 		   	    		ComShowMessage(ComGetMsg('AUTH00002'));
 		   	    	}
 		   	    	//-------------------Excel Download 결재로직 END--------------------------
					break;

				// Agreement 수정 화면으로 이동 ( Contract Office Code 만 존재, Creation Office Code 가 없어 비교후 alert 못함)
				case "btng_adjustmentscreen":
					var agmt_no = formObject.tml_agmt_ofc_cty_cd.value;
					var agmt_ver_no = formObject.tml_agmt_ver_no.value;

					if(ComIsNull(agmt_no) && ComIsNull(agmt_ver_no)){
						ComShowCodeMessage('TES50301');	// Insert Agreement No & Agreement Version Information!');
						return;
					}else  if(!validate_agmt_no()){
						return;
					}else if(!validate_agmt_ver()){
						return;
					}
					location.href="ESD_TES_0034.do?pgmNo=ESD_TES_0034&tml_agmt_ofc_cty_cd="+agmt_no+"&tml_agmt_ver_no="+agmt_ver_no;
					break;


				case "btng_print":
					//-------------------Auth Print 결재로직 START--------------------------
 		   	    	/*
 		   	    	 * [CHM-201538739]Excel down 사전 결재 진행건 (시범적용) 2015-12-16
 		   	    	 * 모듈명과 화면명 각 모듈에 맞게 하드코딩
 		   	    	 */
	 		   		var authSubSysCd = "TES";
	 		   	    var authPgmNo = "ESD_TES_0040";
 		   	    	
 		   	    	chkXlsBtnPrmtBF(authSubSysCd, authPgmNo, sheetObject);//ETC용 sheet이므로 아무렇게나 넣으셔도 됩니다.
 		   	    	if(xlsDlRstrActFlg == "N"){
 		   	    		/*
 		   	    		 * 기존 액셀 Download 소스
 		   	    		 */
 		   	    		printInvoiceSummary();
 		   	    	}else if(xlsDlRstrActFlg == "Y"){
	 		   	    		if(authAproStsCd == "C" && !(authAproRqstNo==null || authAproRqstNo==undefined || authAproRqstNo==""|| authAproRqstNo.length != 30)){
	 		   	    			/*
	 	 		   	    		 * 기존 액셀 Download 소스
	 	 		   	    		 */
	 		   	    			printInvoiceSummary();
	 		   	    		}else if(authAproStsCd == "P"){
	 		   	    			//ComShowMessage("The approval for Excel Download is in progress\n[Rqst No.:"+authAproRqstNo+"]");
	 		   	    			ComShowMessage(ComGetMsg('AUTH00001', authAproRqstNo));
	 		   	    		}else{
	 		   	    			var param = "?sub_sys_cd="+authSubSysCd+"&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no="+authPgmNo;
	 		   	    			chkXlsDnPopup(param); //결재창 Popup
	 		   	    		}
 		   	    	}else{
 		   	    		ComShowMessage(ComGetMsg('AUTH00002'));
 		   	    	}
 		   	    	//-------------------Auth Print 결재로직 END--------------------------

					break;
					
				case "btn_pre_inquiry_cond":
					var url_str = 'ESD_TES_0039.do';
					url_str += '?pgmNo=ESD_TES_0039';
					url_str += '&pre_cond_yd_cd='+document.form.pre_cond_yd_cd.value;
					url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
					url_str += '&pre_cond_eff_agmt='+document.form.pre_cond_eff_agmt.value;
					url_str += '&pre_cond_eff_on='+document.form.pre_cond_eff_on.value;
					url_str += '&pre_cond_ctrt_ofc_cd='+document.form.pre_cond_ctrt_ofc_cd.value;
					url_str += '&pre_cond_delt_flg='+document.form.pre_cond_delt_flg.value;
					url_str += '&pre_cond_tml_agmt_sts_cd='+document.form.pre_cond_tml_agmt_sts_cd.value;
					url_str += '&pre_cond_cre_ofc_cd2='+document.form.pre_cond_cre_ofc_cd2.value;
					location.href = url_str;
				break;

				case "btng_costcodedescshow":
					document.all.CostCodeDescShow01.style.display = "none";
					document.all.CostCodeDescShow02.style.display = "none";
					document.all.CostCodeDescHide01.style.display = "inline";	
					document.all.CostCodeDescHide02.style.display = "inline";	
			        sheetObjects[0].ColHidden("lgs_cost_abbr_nm") = false;	//show
			        sheetObjects[1].ColHidden("lgs_cost_abbr_nm") = false;	//show
					break;
				
				case "btng_costcodedeschide":
					document.all.CostCodeDescShow01.style.display = "inline";
					document.all.CostCodeDescShow02.style.display = "inline";
					document.all.CostCodeDescHide01.style.display = "none";
					document.all.CostCodeDescHide02.style.display = "none";
					sheetObjects[0].ColHidden("lgs_cost_abbr_nm") = true;	//hide
					sheetObjects[1].ColHidden("lgs_cost_abbr_nm") = true;	//hide
					break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
				ComShowMessage(e);
			}
		}
	}


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * 
     * @param {ibsheet}		sheet_obj  	Sheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var formObject = document.form;
        
        if(!ComIsNull(agmt_no)){
            formObject.tml_agmt_ofc_cty_cd.value = agmt_no;
            formObject.tml_agmt_ver_no.value = agmt_ver_no;
            doActionIBSheet(sheetObject2,formObject,IBSEARCH);
        }

        document.all.CostCodeDescHide01.style.display = "inline";
        document.all.CostCodeDescHide02.style.display = "inline";
        
    }


	/**
	 * 시트 초기설정값, 헤더 정의
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * 
	 * @param {ibsheet}  	sheetObj	IBSheet Object
	 * @param {int,string}	sheetNo  	Sheet Object 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;

		switch(sheetNo) {

			case 1:   //t1sheet1 init
				with (sheetObj) {

                    //전체 너비 설정
					SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1 , 5, 100);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                	// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(AHC D - 2016-01-11)
                    var HeadTitle0 = "Cost Code|Cost Code Desc.|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "Applied Date|Applied Date|Applied Date|Applied Date|Lane|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|"
                    + "Tier Vol.|Tier Vol.|OT\nShift|THC|Volume \nUOM|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|"
                    + "Remark|agmt_dtl_rmk";

                    var HeadTitle1 = "Cost Code|Cost Code Desc.|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "WD|Sat|Sun|H/D|Lane|None|Same for all DG|Same for all DG|"
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "Fr|To|OT\nShift|THC|Volume \nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Remark|agmt_dtl_rmk";

                    var HeadTitle2 = "Cost Code|Cost Code Desc.|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "WD|Sat|Sun|H/D|Lane|None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "Fr|To|OT\nShift|THC|Volume \nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Remark|agmt_dtl_rmk";

					var headCount = ComCountHeadTitle(HeadTitle0);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(70, 2, 0, true);
//					InitColumnInfo(headCount, 2, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE,          SAVENAME,       KEYFIELD,   CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "lgs_cost_cd",            false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       220,  daCenter,  true,    "lgs_cost_abbr_nm",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "auto_calc_flg",          false,          "",       dfNone,   		0,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",                false,          "",       dfNone,   		0,     false,      false);
                    // thrp_lgs_cost_flg에서 thrp_lgs_cost_cd 로 변경 ( 데이타가 잘못 보여지고 있었음.) - 2009-04-15
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,     "thrp_lgs_cost_cd",      false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "io_bnd_cd",              false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "ioc_cd",                 false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "tml_trns_mod_cd",        false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "wkdy_flg",               false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "sat_flg",                false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "sun_flg",                false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "hol_flg",                false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "lane_cd",                false,          "",       dfNone,   		0,     false,      false);
                    //[CHM-201539189]DG(NONE) 숨김처리 2016-01-04 AHC D
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    "dg_none",                false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "same_dg_none",           false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "same_dg",                false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "sep_dg_none",            false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n1st_clss_flg",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n2nd_clss_flg",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n3rd_clss_flg",     false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n4th_clss_flg",     false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n5th_clss_flg",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n6th_clss_flg",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n7th_clss_flg",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n8th_clss_flg",     false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dcgo_n9th_clss_flg",     false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "fm_tr_vol_val",          false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "to_tr_vol_val",          false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "tml_ovt_shft_cd",        false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "thc_tp_cd",              false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "tml_agmt_vol_ut_cd",     false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "d2",                     false,          "",       dfFloat,   	2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "d4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "d5",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "d7",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "d8",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "d9",                     false,          "",       dfFloat,   	2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "dw",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "dx",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "r2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "r4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "r5",                     false,          "",       dfFloat,   	2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "r7",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "r8",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "r9",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "f2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "f4",                     false,          "",       dfFloat,   	2,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "f5",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "o2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "o4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "o5",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "o7",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "s2",                     false,          "",       dfFloat,   	2,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "s4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "t2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "t4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "a2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "a4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "a5",                     false,          "",       dfFloat,   	2,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "p2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "p4",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "c2",                     false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "c4",                     false,          "",       dfFloat,   	2,     false,      false);                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "teu_rate",               false,          "",       dfFloat,       2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "box_rate",               false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "move_rate",              false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "gang_hour_rate",         false,          "",       dfFloat,   	2,     false,      false);
                    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(AHC D - 2016-01-11)
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "ton_rate",              false,          "",       dfFloat,   	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtPopup,      70,    daRight ,  true,    "remark",                 false,          "",       dfNone,   		0,      true,       true);

                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    "agmt_dtl_rmk",     	   false,          "",       dfNone,   		0,     false,      false);
                    
		            RangeBackColor(1, 7, 1, 12) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 13, 2, 25) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 25, 1, 57) = RgbColor(222, 251, 248);   // ENIS

		            // ALPS IBSheetConfig 변경(삭제)으로 주석처리. 2009-08-14
//		            CellBackColor(0,0) = SubHeaderColor ;
//		            CellBackColor(0,2) = SubHeaderColor ;
//		            CellBackColor(0,4) = SubHeaderColor ;
//		            CellBackColor(0,6) = SubHeaderColor ;
//		            CellBackColor(0,11) = SubHeaderColor ;
//		            CellBackColor(0,25) = SubHeaderColor ;
//		            CellBackColor(0,28) = SubHeaderColor ;
//		            CellBackColor(0,54) = SubHeaderColor ;
//		            CellBackColor(0,56) = SubHeaderColor ;


                    HeadRowHeight  = 21;
                    HeadRowHeight  = 20;

                    style.height=GetSheetHeight(15);
                }
                break;

             case 2:   //t2sheet1 init
                with (sheetObj) {

                    style.height=GetSheetHeight(16);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                	// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(AHC D - 2016-01-11)
                    var HeadTitle0 = "Cost Code|Cost Code Desc.|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|"
                    + "Exclude Date|Exclude Date|Exclude Date|"
                    + "DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|"
                    + "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Remark";

                    var HeadTitle1 = "Cost Code|Cost Code Desc.|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "None|Same for all DG|Same for all DG|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "SA|SU|Ho|"
                    + "None|Same for all DG|Same for all DG|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "From|To|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Remark";

                    var HeadTitle2 = "Cost Code|Cost Code Desc.|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "SA|SU|Ho|"
                    + "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "From|To|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Remark";

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1 , 5, 100);

//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(111, 2, 0, true);

//					var headCount = ComCountHeadTitle(HeadTitle0);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//					InitColumnInfo(headCount, 2, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE,    SAVENAME,             KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "lgs_cost_cd",          false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       220,  daCenter,  true,    "lgs_cost_abbr_nm",   false,          "",       dfNone,   		0,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "curr_cd",              false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "tml_sto_agmt_tp_cd",   false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "cmnc_hrmnt",           false,          "",       dfTimeHm,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "ft_dys",               false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "io_bnd_cd",            false,          "",       dfNone,          0,     false,      false);
                    //[CHM-201539189]DG(NONE) 숨김처리 2016-01-04 AHC D
                    InitDataProperty(0, cnt++ , dtHidden,     1,     daCenter,  true,    "dg_none_fd",           false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "same_dg_none_fd",      false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "same_dg_fd",           false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "sep_dg_none_fd",       false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n1st_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n2nd_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n3rd_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n4th_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n5th_clss_flg_fd",false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n6th_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n7th_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n8th_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n9th_clss_flg_fd",false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "sat_flg_fd",           false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "sun_flg_fd",           false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "hol_flg_fd",           false,          "",       dfNone,   		0,     false,      false);
                    //[CHM-201539189]DG(NONE) 숨김처리 2016-01-04 AHC D
                    InitDataProperty(0, cnt++ , dtHidden,     1,     daCenter,  true,    "dg_none_r",            false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "same_dg_none_r",       false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "same_dg_r",            false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "sep_dg_none_r",        false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n1st_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n2nd_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n3rd_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n4th_clss_flg_r", false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n5th_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n6th_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n7th_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n8th_clss_flg_r", false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       20,    daCenter,  true,    "dcgo_n9th_clss_flg_r", false,          "",       dfNone,          0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "fm_tr_dys",            false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "to_tr_dys",            false,          "",       dfNone,   		0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "fp_calc_prd_cd",     	 false,          "",       dfNone,   		0,     false,      false, 6);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "fp_teu_qty",           false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       65,    daCenter,  true,    "tml_agmt_vol_ut_cd",   false,          "",       dfNone,   		0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d4_fd",                false,          "",       dfInteger,       0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d5_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d7_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d8_fd",                false,          "",       dfInteger,   	0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d9_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dw_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dx_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r4_fd",                false,          "",       dfInteger,   	0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r5_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r7_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r8_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r9_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "f2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "f4_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "f5_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o4_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o5_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o7_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "s2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "s4_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "t2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "t4_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "a2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "a4_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "a5_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "p2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "p4_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "c2_fd",                false,          "",       dfInteger,   	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "c4_fd",                false,          "",       dfInteger,   	0,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d5_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d7_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d8_r",                 false,          "",       dfFloat,   		2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "d9_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dw_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "dx_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r4_r",                 false,          "",       dfFloat,   		2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r5_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r7_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r8_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "r9_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "f2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "f4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "f5_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o5_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "o7_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "s2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "s4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "t2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "t4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "a2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "a4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "a5_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "p2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "p4_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "c2_r",                 false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,    "c4_r",                 false,          "",       dfFloat,   		2,     false,      false);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "teu_rate",             false,          "",       dfFloat,         2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "box_rate",             false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "move_rate",            false,          "",       dfFloat,   		2,     false,      false);
                    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(AHC D - 2016-01-11)
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "ton_rate",            false,          "",       dfFloat,   		2,     false,      false);
                    InitDataProperty(0, cnt++ , dtPopup ,     70,    daRight ,  true,    "remark",               false,          "",       dfNone,   		0,      true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    "agmt_dtl_rmk",     	 false,          "",       dfNone,   		0,     false,      false);

		            CellBackColor(1,7) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 8, 2, 21) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 20, 1, 23) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 24, 2, 35) = RgbColor(222, 251, 248);   // ENIS
		            RangeBackColor(1, 36, 2, 90) = RgbColor(222, 251, 248);   // ENIS

		            // ALPS IBSheetConfig 변경(삭제)으로 주석처리. 2009-08-14
//		            CellBackColor(0,0) = SubHeaderColor ;
//		            CellBackColor(0,2) = SubHeaderColor ;
//		            CellBackColor(0,4) = SubHeaderColor ;
//		            CellBackColor(0,20) = SubHeaderColor ;
//		            CellBackColor(0,36) = SubHeaderColor ;
//		            CellBackColor(0,39) = SubHeaderColor ;
//		            CellBackColor(0,65) = SubHeaderColor ;
//		            CellBackColor(0,91) = SubHeaderColor ;
//		            CellBackColor(0,93) = SubHeaderColor ;


                    HeadRowHeight  =21;
                    HeadRowHeight  =20;
                    style.height=GetSheetHeight(15);

                }
                break;
            case 3:   //main_hidden
                with (sheetObj) {
                    style.height=GetSheetHeight(5);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "Yard Code|Contract Office|Vendor Code|Vendor Name|Effective From DT|Creation Date|Update Date|Auto Extension|Effective To Dt|Creation User|Update User|Yard Name|AGMT approval Date|agmt confirm date|agmt confirm flag|agmt_doc_no|agmt_doc_desc|agmt_doc_eff_fm_dt|agmt_doc_eff_to_dt";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "yd_cd",         false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "ctrt_ofc_cd",   false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "cre_ofc_cd",    false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "vndr_seq",      false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "vndr_abbr_nm",  false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "eff_fm_dt",     false,          "",       dfDateYmd,      0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "cre_dt",        false,          "",       dfDateYmd,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "upd_dt",        false,          "",       dfDateYmd,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "auto_xtd_flg",  false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "eff_to_dt",     false,          "",       dfDateYmd,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "cre_usr_id",    false,          "",       dfNone,         0,     true,      true);

					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "upd_usr_id",    false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "yd_nm",         false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  false,    "agmt_apro_dt",         false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,		90,		daLeft,			true, "agmt_cfm_dt",				false,          "",       dfNone,   	0,     true,      true);
                    // AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27) 
                    InitDataProperty(0, cnt++ , dtData,		90,		daLeft,			true, "agmt_cfm_flg",				false,          "",       dfNone,   	0,     true,      true);
                    
                    // 비용지급 전표 결재 기능 - 3차 GW LINK 삭제 (4347-09-25) 
                    InitDataProperty(0, cnt++ , dtData,		90,		daLeft,			true, "agmt_doc_no",				false,          "",       dfNone,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,		90,		daLeft,			true, "agmt_doc_desc",				false,          "",       dfNone,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,		90,		daLeft,			true, "agmt_doc_eff_fm_dt",		false,          "",       dfNone,   	0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,		90,		daLeft,			true, "agmt_doc_eff_to_dt",		false,          "",       dfNone,   	0,     true,      true);

				}
                break;
        }
    }



	/**
     * Sheet Cell PopupClick Event 처리
     * Terminal Rate List Tab
     * 
     * @param {sheetObj}  	Sheet Object
     * @param {row}  		Row No
     * @param {col}  		Column No
     */
	function t1sheet1_OnPopupClick(sheetObj , row , col )
	{
		var formObj = document.form;
		var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";

		var myWin = window.open('', "popagmtcrermk3", myOption);
		myWin.focus();
		
		formObj.pop_cost_cd.value  = sheetObjects[0].CellValue(row, "lgs_cost_cd");
		formObj.pop_sheetObj.value = "t1sheet1";
		formObj.pop_row.value      = row;
		formObj.pop_agmt_rmk.value = sheetObjects[0].CellValue(row, "agmt_dtl_rmk");
		formObj.pop_mode.value     = "inquiry"
		formObj.action			   = 'ESD_TES_9080.screen';
		formObj.target			   = 'popagmtcrermk3';
		
		formObj.submit();
    }
	
	/**
     * Sheet Cell PopupClick Event 처리
     * Storage Rate List Tab
     * 
     * @param {sheetObj}  	Sheet Object
     * @param {row}  		Row No
     * @param {col}  		Column No
     */
	function t2sheet1_OnPopupClick(sheetObj , row , col )
	{
		var formObj = document.form;
		var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";

		var myWin = window.open('', "popagmtcrermk4", myOption);
		myWin.focus();
		
		formObj.pop_cost_cd.value  = sheetObjects[1].CellValue(row, "lgs_cost_cd");
		formObj.pop_sheetObj.value = "t2sheet1";
		formObj.pop_row.value      = row;
		formObj.pop_agmt_rmk.value = sheetObjects[1].CellValue(row, "agmt_dtl_rmk");
		formObj.pop_mode.value     = "inquiry"
		formObj.action			   = 'ESD_TES_9080.screen';
		formObj.target			   = 'popagmtcrermk4';
		
		formObj.submit();
    }
	
    /**
     * Sheet관련 프로세스 처리
     * Header 정보 임시 보관용
     * 
     * @param {ibsheet}		sheetObj  	IBSheet Object
     * @param {Obejct}		formObj  	Form Object
     * @param {String}		sAction  	Action Command
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			case IBSEARCH:      //조회

				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TES_0040GS.do",tesFrmQryStr(formObj));
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1, true);
				break;
		}
	}

	/**
     * Sheet관련 프로세스 처리
     * Terminal Rate List, Storage Rate List Tab
     * 
     * @param {sheetObj}  	Sheet Object
     * @param {formObj}  	Form Object
     * @param {sAction}  	Action Command
     */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESD_TES_0040_02GS.do", tesFrmQryStr(formObj));

				var arrXml = sXml.split("|$$|"); 
    			
				for (var i=0; arrXml!=null && i<arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}

				sheetObj.removeEtcData();

				sXml	= null;
				arrXml	= null;

				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.SpeedDown2Excel(-1);
				break;
		}
	}


    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * 
     * @param {ibtab}		tab_obj  	Tab Object
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     * 
     * @param {ibtab}		tabobj  	Tab Object
     * @param {int,string}	tabNo		Tab No
     */    
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Terminal Rate List" , -1 );
                    InsertTab( cnt++ , "Storage Rate List" , -1 );

                }
             break;

         }
    }

    /**
     * 영문과 숫자만.
     * 
     * @param {Object}		obj  	Object
     */    
    function isApNum(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj, "n")){
			obj.value = '';
		}
	}

    /**
     * 숫자, '.'만..
     * 
     * @param {Object}		obj  	Object
     */    
	function isNumPod(obj){
		//숫자, '.'만..
		if (!ComIsNumber(obj,".")){
			obj.value = '';
		}
	}


    /**
     * 숫자만..
     * 
     * @param {Object}		obj  	Object
     */    
	function isNum(obj){
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}

    /**
     * 숫자만..
     * 
     * @param {Object}		obj  	Object
     * @param {string}		val  	Value
     */    
	function isNum2(val,obj){
	    if(!ComIsNumber(val)){
	       obj.value = '';
	    }
	}

    /**
     * 영문만..
     * 
     * @param {Object}	obj  	Object
     */    
	function isAlpha(obj){
	    if(ComIsAlphabet(obj)){
	        obj.value='';
	    }
	}


	//Agreement Version입력시 2자리 입력후 자동으로 '.'입력해줌
	//앞의 2자리와 뒤의 두자리에 숫자만 입력 가능
    /**
     * 날짜 기간 더하기.
     * 
     * @param {Object}		obj  	Object
     */    
	function addPeriod(obj){
	   var tmp_agmt_ver='';
	    if(getStrLen(obj.value)<=2){
	        if(event.keyCode != 8 ) isNum(obj);
	    }
	    if(getStrLen(obj.value) == 4){
	        var tmp = obj.value.substr(3,1);
	        if(tmp=='.'){
	            tmp_agmt_ver = obj.value.substr(0,3);
	            obj.value = tmp_agmt_ver;

	        }
	    }
	    if(getStrLen(obj.value) >4 ){
	        var tmp = obj.value.substr(3,2);
	        if(event.keyCode != 8 ) isNum2(tmp,obj);
	    }

	    if(getStrLen(obj.value)==3){
	        var tmp = obj.value.substr(2,1);
	        if(tmp != '.'){
	           if(event.keyCode != 8 ) obj.value = '';
	        }
	    }


   	    if(getStrLen(obj.value) == 2){
 	       if(event.keyCode != 8  ){
 	           tmp_agmt_ver = obj.value;
    	       obj.value=tmp_agmt_ver + '.';
    	    }
	    }
	}

    /**
     * Input Value Check
     * 
     * @param {Object}		obj  	Object
     */    
	function chkInput(obj) {
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}

    /**
     * 한글 및 영문 str의 길이를 구함..
     * 
     * @param {string}		src  	Source
     */    
	function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}

    /**
     * Agreement No Check.
     * 
     * @param {Object}	obj  	Object
     */    
	function chkAgmtNo(obj){
         if (!checkAgmtFormat(obj.value)){

        	 ComShowCodeMessage('TES50305');	// ComShowMessage('잘못된 Agreement No. 포맷입니다. 다시 입력하세요');
             obj.value='';
             obj.select();
             return false;
         }
	}

	
    /**
     * Agreement No Format Check 
     * 
     * @param {Object}		obj  	Object
     */    
	function checkAgmtFormat(dt){
	    var date_regexp = "^([A-Za-z]{3}\\d{5})$";
	    if (dt.search(date_regexp) != -1){
	        return true;
	    } else {
			return false;
		}
	}

    /**
     * Agreement Ver No Check..
     * 
     * @param {Object}		obj  	Object
     */    
	function chkAgmtVer(obj){
	    if(!checkAgmtVerFormat(obj.value)){
	    	ComShowCodeMessage('TES50305');	// ComShowMessage('잘못된 Agreement Ver. 포맷입니다. 다시 입력하세요!');
	        obj.value='';
	        obj.focus();
	        return false;
	    }
	}

    /**
     * Agreement Ver No Check.
     * 
     * @param {Object}		obj  	Object
     */    
	function checkAgmtVerFormat(dt){
	    var ver_regexp = "^(\\d{2}(\\.\\d{2}))$";
	    if(dt.search(ver_regexp) != -1){
	        return true;
	    }else{
	        return false;
	    }
	}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * 
     * @param {Object|	obj  	Object
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
     * Agreement No 유효성 검증.
     * 
     * @param {Object}		obj  	Object
     */
	function validate_agmt_no(){
		var formObj = document.form;
		if(ComIsNull(formObj.tml_agmt_ofc_cty_cd.value)){
			ComShowCodeMessage('TES50304');	// ComShowMessage("Insert Agreement No.!");
			obj.focus();
			return false;
		}
		//AgmtNo. 입력포맷 체크
		if (!checkAgmtFormat(formObj.tml_agmt_ofc_cty_cd.value)){
			ComShowCodeMessage('TES50305');	// ComShowMessage('잘못된 Agreement No. 포맷입니다. 다시 입력하세요');
			formObj.tml_agmt_ofc_cty_cd.value='';
			//obj.select();
			formObj.tml_agmt_ofc_cty_cd.focus();
			return false;
		}
         return true;
    }

    /**
     * Agreement Ver No 유효성 검증.
     * 
     * @param {Object}		obj  	Object
     */    
    function validate_agmt_ver(){
        var formObj = document.form;
        if(ComIsNull(formObj.tml_agmt_ver_no.value)){
        	ComShowMessage('TES50304');	//"Insert Agreement Version Information!");
           return false;
        }
        //입력한 AgmtNo.의 길이 체크
        if (formObj.tml_agmt_ver_no.maxLength < getStrLen(formObj.tml_agmt_ver_no.value))
		{
		    ComShowCodeMessage('TES50305');	// ComShowMessage('Error : Agreement No Length')
			formObj.tml_agmt_ver_no.value = '';
			formObj.tml_agmt_ver_no.focus();
			return false;
		}
		if(!checkAgmtVerFormat(formObj.tml_agmt_ver_no.value)){
			ComShowCodeMessage('TES50305');	// ComShowMessage('잘못된 Agreement Ver. 포맷입니다. 다시 입력하세요!');
	        formObj.tml_agmt_ver_no.value='';
	        formObj.tml_agmt_ver_no.focus();
	        return false;
	    }

		return true;

    }



    /**
     * btn_retrieve 이벤트 실행시 main_hidden Sheet에 있는 조회 결과를 화면에 보여준다.
     * Form Object Value 설정
     * 
     * @param {ibsheet}		main_hidden		IBSheet Object
     * @param {string}		ErrMsg		  	Error Message
     */
    function main_hidden_OnSearchEnd(main_hidden, ErrMsg){
        var formObj = document.form;
        if(main_hidden.RowCount==1){
        	formObj.no_ofc_cd.value = sheetObjects[2].CellValue(1,'cre_ofc_cd');
        	formObj.no_yd_cd.value  = sheetObjects[2].CellValue(1,'yd_cd');
        	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
        }
    }

    /**
     * btn_retrieve 이벤트 실행시 Terminal Rate List Sheet에 있는 조회 결과를 화면에 보여준다.
     * tml_trns_mod_cd 값 설정
     * 
     * @param {sheetObj}	Sheet Object
     */
    function t1sheet1_OnSearchEnd(sheetObj){
    	 for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows+sheetObj.RowCount; i++) {
             if(sheetObj.CellValue(i,'tml_trns_mod_cd') == 'S'){
                 sheetObj.ToolTipText(i,'tml_trns_mod_cd') = 'Same';
             } else if(sheetObj.CellValue(i,'tml_trns_mod_cd') == 'T'){
                 sheetObj.ToolTipText(i,'tml_trns_mod_cd') = 'Truck';
             } else if(sheetObj.CellValue(i,'tml_trns_mod_cd') == 'R'){
                 sheetObj.ToolTipText(i,'tml_trns_mod_cd') = 'Rail';
             } else if(sheetObj.CellValue(i,'tml_trns_mod_cd') == 'B'){
                 sheetObj.ToolTipText(i,'tml_trns_mod_cd') = 'Barge';
             } else if(sheetObj.CellValue(i,'tml_trns_mod_cd') == 'F'){
                 sheetObj.ToolTipText(i,'tml_trns_mod_cd') = 'Feeder';
             } else if(sheetObj.CellValue(i,'tml_trns_mod_cd') == 'V'){
                 sheetObj.ToolTipText(i,'tml_trns_mod_cd') = 'Mother';
             }
         }

    }


    /**
     * btn_retrieve 이벤트 실행시 Stroage Rate List Sheet 에 있는 조회 결과를 화면에 보여준다.
     * tml_sto_agmt_tp_cd 값 설정
     * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     */
    function t2sheet1_OnSearchEnd(sheetObj){
		 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	         if(sheetObj.CellValue(i,'tml_sto_agmt_tp_cd') == 'FD'){
	             sheetObj.ToolTipText(i,'tml_sto_agmt_tp_cd') = 'Free Day';
	         } else if(sheetObj.CellValue(i,'tml_sto_agmt_tp_cd') == 'FP'){
	             sheetObj.ToolTipText(i,'tml_sto_agmt_tp_cd') = 'Free Pool';
	         }
	     }
    }


    /**
     * 값 설정.
     * 
     * @param {object}	obj  	Object
     */    
    function setValue(obj){
        ComShowMessage(obj.value)
 		obj.value = obj.value;
    }


    /**
     * Invoice Summary List Report Print.
     * 
     * @param {object}	obj  	Object
     */    
    function printInvoiceSummary(){
	    var fromObj  = new Array();
	    var rdObj    = new Array();
	    var paramObj = new Array();
	    fromObj[0] = document.form;
	    rdObj[0] = sheetObjects[2]; //main_hidden
	    rdObj[1] = sheetObjects[0]; //Terminal Rate
	    rdObj[2] = sheetObjects[1]; //Storage Rate
	    //RD로 보내기 위한 설정
	    paramObj[0] = "1";
	    paramObj[1] = "";
	    paramObj[2] = "N";
	    paramObj[3] = RD_path+"apps/alps/esd/tes/serviceprovideragreementmanage/terminalagreementmanage/report/ESD_TES_0804.mrd";
	    paramObj[4] = rdObj;
	    paramObj[5] = fromObj;
	    rdObjModaless(RdReport, paramObj, 1000, 700);
	}

	/** setFormValue()
	 * 
	 * @return
	 */
	function setFormValue() {
		if (document.form.auth_ofc_cd.value.trim() == "Y") {
			var formObj = document.form;
			
			formObj.yd_cd.value			= sheetObjects[2].CellValue(1,'yd_cd');
			formObj.ctrt_ofc_cd.value		= sheetObjects[2].CellValue(1,'ctrt_ofc_cd');
			formObj.vndr_seq.value		= sheetObjects[2].CellValue(1,'vndr_seq');
			formObj.vndr_abbr_nm.value	= sheetObjects[2].CellValue(1,'vndr_abbr_nm');
			formObj.eff_fm_dt.value		= sheetObjects[2].CellValue(1,'eff_fm_dt');
			formObj.cre_dt.value			= sheetObjects[2].CellValue(1,'cre_dt');
			formObj.upd_dt.value			= sheetObjects[2].CellValue(1,'upd_dt');
			formObj.auto_xtd_flg.value		= sheetObjects[2].CellValue(1,'auto_xtd_flg');
			formObj.eff_to_dt.value			= sheetObjects[2].CellValue(1,'eff_to_dt');
			formObj.cre_usr_id.value		= sheetObjects[2].CellValue(1,'cre_usr_id');
			formObj.upd_usr_id.value		= sheetObjects[2].CellValue(1,'upd_usr_id');
			formObj.no_cre_ofc_cd.value	= sheetObjects[2].CellValue(1,'cre_ofc_cd');
			
			formObj.agmt_apro_dt.value	= sheetObjects[2].CellValue(1,'agmt_apro_dt');
			// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27) 
//			formObject.agmt_cfm_flg.value	= sheetObjects[2].CellValue(1, "agmt_cfm_flg");
			// 비용지급 전표 결재 기능 - 3차  (4347-10-06)
			formObj.agmt_doc_no.value	= sheetObjects[2].CellValue(1, "agmt_doc_no");
			formObj.agmt_doc_desc.value	= sheetObjects[2].CellValue(1, "agmt_doc_desc");
//			formObj.agmt_doc_eff_fm_dt.value	= sheetObjects[2].CellValue(1, "agmt_doc_eff_fm_dt");
//			formObj.agmt_doc_eff_to_dt.value	= sheetObjects[2].CellValue(1, "agmt_doc_eff_to_dt");
			
			
			doActionIBSheet2(sheetObjects[0],document.form, IBSEARCH);
			
			/** 2015-03-04 : [CHM-201533697]detail화면에서 to Summary 버튼 클릭시 이전 화면 검색 결과 유지되도록 설정   **/
			try {
				 for (var i = 0; i < formObj.elements.length; i++){
					 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
					     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
					 {
						 with (formObj) {
							 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
								 document.all.PreInquiryCondLayer01.style.display = "inline";
								 break;
							 }
						 }
					 }
				 }
			 } catch(e){}
			 
     	}else{
	    	ComShowMessage(ComGetMsg('TES50202'));
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
	    }		
		
     }
     