/*=========================================================

*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0061.js
*@FileTitle : Inquiry By BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 이중환
*@LastVersion : 1.1
* 2009.08.28 송호진
* 1.0 Creation
* History :
* 2008.03.26 PEJ   N200803190021 MAS inquiry by BKG 화면 및 excel down 변경 요청  
*                     Excel Down 시에 상위 비용 그룹 아래 하위 비용 계정에 대해 앞에 "-" 표시 
*                     화면상에도 그룹 합계인 부분은 색깔을 넣어 중복 비용으로 보지 않도록 변경
* 2008.11.24 박상희 N200811060006 Weight 추가
* 2008.12.17 박상희 N200812100006 Inquiry by BKG 화면 수정 : R.Mon/S.Mon 모두 보여줌, Misc OP Rev 추가
* 2009.03.10 김태윤 CSR No.N200903040144 Remark 팝업 추가.
* 2009.03.12   박상희 N200903040144 BKG(abc/stp) 화면 팝업 시 openWindow() 사용하도록 수정			
* 2009.09.08 송호진 ALPS F/W 적용
* 2009.12.31 윤진영 CHM-200901869 MAS_BKG_COST_ACT_GRP_SMRY SRC Detail과 ABC/STP 테이블 6개월 유지를 위한 INDEX 추가
*            MAS_BKG_COST_SRC_DTL,MAS_BKG_SVC_TRNS_PRC 해당 Summary TABLE Summary로직을 BATCH PROCESS에 추가
*    		 Inquiry By Booking Report 수정
* 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> masFormQueryString 변경
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2011.12.30 최윤성 [CHM-201115391-01] [MAS] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - avg_lvl_chk 추가 하여 값에 따라 색상 및 Bold 처리
* 2012.03.12 김종준 [CHM-201216637-01] Inquiry by BKG 화면에 Bill Type Indicator 추가 
* 2013.11.11 김수정 [CHM-201327408] [MAS] Inquiry By Booking MT OP/RTN 정보 추가
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
     * @class ESM_MAS_0061 : ESM_MAS_0061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0061() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
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

    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_costdetail":
    					if(sheetObject.RowCount>2 && sheetObject.SelectRow == 2){ //route no가 두개 이상인경우 All 선택
    						ComShowMessage(ComGetMsg("MAS10032"));

    				    } else {
    						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
    					}
    					break;

    				case "bu_zoom_in":
    					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheetObject2.RowCount+3);
    					div_zoom_in.style.display = "none";
    					div_zoom_out.style.display = "inline";
    					if ( popup_flag == "N"){
    						parent.syncHeight();
    					}
    					break;

    				case "bu_zoom_out":
    					sheetObject2.style.height = sheetObject2.GetSheetHeight(8);
    					div_zoom_in.style.display = "inline";
    					div_zoom_out.style.display = "none";	
    					if ( popup_flag == "N" ){
    						parent.syncHeight();
    					}
    					break;
    				
    				case "btns_remarks":
    					btng_remarks_OnClick(sheetObject1);
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
    	* Sheet 기본 설정 및 초기화
    	* body 태그의 onLoad 이벤트핸들러 구현
    	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	*/
    	function loadPage() {
    		var title = "";
    		var formObject = document.form;
    		
    		loadingMode = true; 
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		for(k=0;k<comboObjects.length;k++){
	            initCombo(comboObjects[k], k+1);
	        }
    		
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1, title);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}		
    		getProLev();

			if (formObject.s_pro_vw.value !=null&&formObject.s_pro_vw.value !=""){
				setRetrieveAction()		    
			}		
			ComSetFocus(formObject.f_bkg_no);
			loadingMode = false;
    	}
    	 /**
	     * 멀티콤보 처리
	     * - Tab 기본 설정
	     * - 탭의 항목을 설정한다.
	     */
	    function initCombo (comboObj, comboNo) {
	    	with (comboObj) {
	   	    	switch(comboObj.id) {
		    		case "f_cntr_tpsz_cd":
		    	    	IMEMode = 0;
		    	    	ValidChar(2, 1);
		    	    	MaxLength = 4;
		    	    	break;
		    	}
	        	DropHeight = 300;
	        	Index = 0;
	        }
	    } 
	    
    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo, title) {

    		var cnt = 0;
    		var colCnt = 0;
    		var colTotNum = 0;
    		var aryTitle = new Array();
    		var t1 = "";
    		if (title != ""){
    			t1 = title;
    			aryTitle = title.split("|");
    		}
    		switch(sheetNo) {
    			case 1:		//sheet1 init
    				with (sheetObj) {

    					SheetWidth = mainTable1.clientWidth;
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msHeaderOnly;
    					Editable = false;
    					InitRowInfo(2, 1, 9, 100);
    					InitColumnInfo(45, 0, 0, true);
    					InitHeadMode(false, false, false, true, false, false);

    					var HeadTitle = "H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|" +
    						"Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|T/Time";
    					var HeadTitle1 = "H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|H|Route No|MT OP Loc|MT OP ECC|POR|Inter Change|POL|Lane|1st T/S|Lane|2nd T/S|Lane|3rd T/S|Lane|POD|Inter Change|DEL|MT RTN Loc|MT RTN ECC|(day)" ;

    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, false);
                        //1~10
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "pctl_no");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "bkg_no");
    					//InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "bkg_no_split");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "sls_ofc_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "shipper");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "ioc_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "rlane_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "vvd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "bkg_de_term_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "bkg_rcv_term_cd");
    					//11~20
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "rep_cmdt_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "shpr_nm");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "clt_ofc_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "spcl_dg_cgo_flg");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "spcl_bb_cgo_flg");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "spcl_awk_cgo_flg");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "spcl_rc_flg");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "soc_flg");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "bkg_cgo_tp_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "cost_yrmon");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "sls_yrmon");
    					//21~24
    					InitDataProperty(0, cnt++, dtHidden,	50,	daCenter, true, "bkg_sts_cd");
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "cost_wk");
    					InitDataProperty(0, cnt++, dtHidden,	50, daRight,  true, "bkg_cgo_wgt",  false, "", dfFloatOrg, 2, false, false);
    					InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "bkg_wgt_tp_cd");
    					InitDataProperty(0, cnt++, dtHidden,	140,daCenter, true, "cost_rout_no");
    					InitDataProperty(0, cnt++, dtHidden,	140,daCenter, true, "rt_bl_tp_nm");
    						
    					InitDataProperty(0, cnt++, dtData,	100, daCenter, true, "cost_rout_no2");
    					InitDataProperty(0, cnt++, dtData,	70,  daCenter, true, "mty_pkup_loc");
    					InitDataProperty(0, cnt++, dtData,	70,  daCenter, true, "mty_pkup_ecc");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "por_cd");
    					InitDataProperty(0, cnt++, dtData,	120, daCenter, true, "ob_itchg_ctnt");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "pol_cd");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "n1st_rlane_cd");
    					InitDataProperty(0, cnt++, dtData,	100, daCenter, true, "n1st_ts_port_cd");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "n2nd_rlane_cd");
    					InitDataProperty(0, cnt++, dtData,	100, daCenter, true, "n2nd_ts_port_cd");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "n3rd_rlane_cd");
    					InitDataProperty(0, cnt++, dtData,	100, daCenter, true, "n3rd_ts_port_cd");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "n4rd_rlane_cd");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "pod_cd");
    					InitDataProperty(0, cnt++, dtData,	120, daCenter, true, "ib_itchg_ctnt");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "del_cd");
    					InitDataProperty(0, cnt++, dtData,	70,  daCenter, true, "mty_rtn_loc");
    					InitDataProperty(0, cnt++, dtData,	70,  daCenter, true, "mty_rtn_ecc");
    					InitDataProperty(0, cnt++, dtData,	50,  daCenter, true, "hrs",			false, "", dfInteger, 0, true, true);

    					RangeBackColor(1, 27, 1, 39) = RgbColor(222, 251, 248);

    					HeadRowHeight	= 10;
    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(6) ;
    				}
    				break;
    			case 2:		//sheet2 init
    				with (sheetObj) {
    					var tot = "";
    					var colWidth1 = 0;
    					if (t1 != ""){
    						colCnt = aryTitle.length;
    						colTotNum = colCnt + 2;
    						t1 = t1 + '|';
    					} else {
    						colTotNum = 2;
    					}

    					SheetWidth = mainTable1.clientWidth;
    					if (colTotNum == 2) {
    						colWidth1 = 140;
    					} else {
    						colWidth1 = SheetWidth / colTotNum;
    					}

    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msNone;
    					Editable = false;
    					InitRowInfo(1, 1, 9, 100);
    					InitColumnInfo(colTotNum, 1, 0, true);
    					InitHeadMode(false, false, false, true, false, false);
    					var HeadTitle = "TP/SZ|"+t1+"Total" ;
    					InitHeadRow(0, HeadTitle, false);

    					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cntr_tpsz_cd");
    					if (t1 != "") {
    						for (var i=0; i<colCnt ; i++) {
    							InitDataProperty(0, cnt++, dtData,	80, daRight, true, aryTitle[i], false, "", dfNullFloatOrg, 2);
    						}
    					}
    					InitDataProperty(0, cnt++, dtData, 90, daRight, false, "b0", false, tot, dfNullFloat, 2);

    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(10) ;	
    					
    					
    				}
    				break;
    			case 3:		//sheet3 init
    				with (sheetObj) {
    					SheetWidth = mainTable3.clientWidth;
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msPrevColumnMerge;//msHeaderOnly; //msAll;
    					Editable = false;
    					InitRowInfo(2, 1, 9, 100);
    					InitColumnInfo(10, 0, 0, true);
    					InitHeadMode(false, false, false, true, false,false);

    					var HeadTitle  = "Node/Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Feeder Term|Feeder Term|Amount|avg_lvl_chk" ;
    					var HeadTitle1 = "Node/Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Rev_Term|Del_Term|Amount|avg_lvl_chk" ;
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, false);

    					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"nod_cd");
    					InitDataProperty(0, cnt++, dtData,		130,	daCenter,	true,	"grp");
    					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"dw_nod_cd");
    					InitDataProperty(0, cnt++, dtData,		130,	daCenter,	true,	"dw_grp");
    					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"tree_col");  // sheet 에서 보여줄 정보
    					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"dw_tree_col"); // excel down 시 보여줄 정보

    					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_rcv_term_cd");
    					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_de_term_cd");
    					InitDataProperty(0, cnt++ ,dtAutoSum,	80,		daRight,	true,	"amt",		false,	"",		dfNullFloatOrg,	2);
    					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"avg_lvl_chk");

    					RangeBackColor(1, 6, 1, 7) = RgbColor(222, 251, 248);

    					InitTreeInfo("tree_col", "", RgbColor(0,0,255), false);
    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(8) ;
    					ColHidden("nod_cd")    = false;
    					ColHidden("grp")       = false;
    					ColHidden("tree_col")  = false;
    					ColHidden("dw_nod_cd") = true;
    					ColHidden("dw_grp")    = true;
    					ColHidden("dw_tree_col") = true;
    					
    				}
    				break;
    		}
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
    	* IBSheet Object를 배열로 등록
    	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	* 배열은 소스 상단에 정의
    	*/
    	function setSheetObject(sheet_obj){
    		sheetObjects[sheetCnt++] = sheet_obj;
    	}
    	
        /*화면이 로드 되면서 바로 retrieve 되도록 */
    	function setRetrieveAction(){
    		sheetObject = sheetObjects[0];
    		formObj = document.form;
    		formObj.f_cmd.value = SEARCHLIST01;		

    		doActionIBSheet(sheetObject,formObj,IBSEARCH);
    	
    	}   
    		
    	/**
    	*	화면
    	*/
    	function chgOption() {
    		var formObj = document.form;
    		var sheetObject3 = sheetObjects[2];
    		//doActionIBSheet(sheetObject3,formObj,IBSEARCH);
    		formObj.f_cmd.value = SEARCHLIST03;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
    		sheetObject3.DoSearch4Post("ESM_MAS_0061GS2.do", masFormQueryString(formObj));
    	}
    	/**
    	* hidden값 변경<br>
    	*
    	*/
    	function changeViewColumn(sObj, vId){
    		if ( vId == "1" ){//뒷부분	hidden
    			//sObj.ColHidden("a5") = true;
    			//sObj.ColHidden("a6") = false;
    		} else if ( vId == "2") {//앞부분 hidden
    			//sObj.ColHidden("a5") = false;
    			//sObj.ColHidden("a6") = true;
    		}
    	}

    	/**
    	* 검색시 필수입력사항 체크
    	*/
    	function colView(){
    		var formObject = document.form;
    		doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
    	}

    	
        /**
    	변수 받기
    	*/	
         function getProLev() {
             var formObj = document.form;
             if (formObj.s_pro_vw.value==null||formObj.s_pro_vw.value==""){
//               ComSetObjValue(formObj.f_pro_vw,"P");
             } else {   
            	 ComSetObjValue(formObj.f_pro_vw,formObj.s_pro_vw.value); 
             }
             if (formObj.s_pro_lvl.value==null||formObj.s_pro_lvl.value==""){
//                ComSetObjValue(formObj.f_pro_lvl,"C");             
             } else {
            	 ComSetObjValue(formObj.f_pro_lvl,formObj.s_pro_lvl.value);  
             }
             
           //Profit Level 에 OP 권한 확인
             ComMasOpCheckOfcCd(formObj.f_pro_lvl, ComGetObjValue(formObj.f_usr_lgn_ofc_cd));
         }
         
    	// Inquiry by BKG(ABC/STP) 팝업
    	function openABCSTPinquiry(sheetObj,formObj,sAction) {
    		if(!validateForm(sheetObj,formObj,sAction)) return false;
    		strUrl = "ESM_MAS_0156POP.do";
    		strUrl += "?f_bkg_no="+getIbComboObjValue(formObj.f_bkg_no);
    		strUrl += "&f_pro_vw="+getIbComboObjValue(formObj.f_pro_vw);
    		strUrl += "&f_pro_lvl="+getIbComboObjValue(formObj.f_pro_lvl);
            strUrl += "&pgmNo=ESM_MAS_0156";
    		    		
    		ComOpenWindow(strUrl, '_ABCSTP', "width=1200,height=800,menubar=0,status=1,scrollbars=1,resizable=1" );

    	}
    	
    	/**
    	* Remark 버튼을 클릭하여 조회한다
    	*/
    	function btng_remarks_OnClick(sheetObj){
    		
        	var sheetObj = sheetObjects[0];
        	var vParam = "";
        	if(sheetObjects[0].RowCount > 0)
        	vParam = "sheet1_por="+sheetObj.CellValue(sheetObj.SelectRow, "por_cd")
        	+"&sheet1_pol="+sheetObj.CellValue(sheetObj.SelectRow, "pol_cd")
        	+"&sheet1_pod="+sheetObj.CellValue(sheetObj.SelectRow, "pod_cd")
        	+"&sheet1_del="+sheetObj.CellValue(sheetObj.SelectRow, "del_cd")+"&";    		
    		
        	//document.form.f_cmd.value = SEARCHLIST01;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
        	ComOpenWindow2('ESM_MAS_0170.do?' 
        	+ vParam + masFormQueryString(document.form), '_RMK', 'width=780,height=680,menubar=0,status=0,scrollbars=1,resizable=1');
    	}
    	
    	/**
    	 * Profit View 변경시  컬럼을변경
    	 */
    	function f_pro_vw_OnChange(obj, code) {
    		if (loadingMode == true)
    			return;
    		if (code == "R") {
    			if (document.form.f_pro_lvl.GetCount () == 2) {
    				document.form.f_pro_lvl.DeleteItem("O");
    				document.form.f_pro_lvl.Code = "C";
				}
    		} else {
    			if (document.form.f_pro_lvl.GetCount () == 1) {
    				document.form.f_pro_lvl.InsertItem(-1, "OP", "O");
				}
    		}
    		
    		//Profit Level 에 OP 권한 확인
            ComMasOpCheckOfcCd(document.form.f_pro_lvl, ComGetObjValue(document.form.f_usr_lgn_ofc_cd));
    	}
    	
    	/**
    	* sheet1조회후 상단 정보 세팅
    	*/
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg){

    		if(sheetObj.RowCount("R") != 0){
        		var fObj = document.form;
        		fObj.f_bkg_split.value = sheetObj.CellValue(2, "bkg_no"); 
        		fObj.f_ofc.value = sheetObj.CellValue(2, "sls_ofc_cd");
        		fObj.f_shipper.value = sheetObj.CellValue(2, "shipper");
        		fObj.f_ioc.value = sheetObj.CellValue(2, "ioc_cd");
        		fObj.f_rlane.value = sheetObj.CellValue(2, "rlane_cd");
        		fObj.f_vvd.value = sheetObj.CellValue(2, "vvd");
        		fObj.f_dterm.value = sheetObj.CellValue(2, "bkg_de_term_cd");
        		fObj.f_rterm.value = sheetObj.CellValue(2, "bkg_rcv_term_cd");
        		fObj.f_rcmdt.value = sheetObj.CellValue(2, "rep_cmdt_cd");
        		fObj.f_cost_yrmon.value = sheetObj.CellValue(2, "cost_yrmon");
        		fObj.f_sls_yrmon.value = sheetObj.CellValue(2, "sls_yrmon");
        		fObj.f_cost_wk.value = sheetObj.CellValue(2, "cost_wk");
        		fObj.f_clt_ofc_cd.value = sheetObj.CellValue(2, "clt_ofc_cd");
        		//fObj.f_taa_no.value = sheetObj.CellValue(2, "taa_no");
        		if(sheetObj.CellValue(2, "spcl_dg_cgo_flg") == 'Y' || sheetObj.CellValue(2, "spcl_dg_cgo_flg") == '1') fObj.f_spcl_dg.checked = true;
        		else fObj.f_spcl_dg.checked = false;
        		if(sheetObj.CellValue(2, "spcl_bb_cgo_flg") == 'Y' || sheetObj.CellValue(2, "spcl_bb_cgo_flg") == '1') fObj.f_spcl_bb.checked = true;
        		else fObj.f_spcl_bb.checked = false;
        		if(sheetObj.CellValue(2, "spcl_awk_cgo_flg") == 'Y' || sheetObj.CellValue(2, "spcl_awk_cgo_flg") == '1') fObj.f_spcl_ak.checked = true;
        		else fObj.f_spcl_ak.checked = false;
        		if(sheetObj.CellValue(2, "spcl_rc_flg") == 'Y' || sheetObj.CellValue(2, "spcl_rc_flg") == '1') fObj.f_spcl_rf.checked = true;
        		else fObj.f_spcl_rf.checked = false;
        		if(sheetObj.CellValue(2, "soc_flg") == 'Y' || sheetObj.CellValue(2, "soc_flg") == '1') fObj.f_soc_flg.checked = true;
        		else fObj.f_soc_flg.checked = false;
        		if(sheetObj.CellValue(2, "bkg_cgo_tp_cd") == 'R' || sheetObj.CellValue(2, "bkg_cgo_tp_cd") == '1') fObj.f_mt_rev.checked = true;
        		else fObj.f_mt_rev.checked = false;
        		fObj.f_bkg_cgo_wgt.value = sheetObj.CellValue(2, "bkg_cgo_wgt");
        		fObj.f_bkg_wgt_tp_cd.value = sheetObj.CellValue(2, "bkg_wgt_tp_cd");
        		fObj.bkg_sts.value = sheetObj.CellValue(2, "bkg_sts_cd");
        		ComChkObjValid(fObj.f_bkg_cgo_wgt);
        		document.getElementById("div_shipper").innerHTML = sheetObj.CellValue(2, "shpr_nm");
        		fObj.rt_bl_tp_nm.value = sheetObj.CellValue(2, "rt_bl_tp_nm");
    		} else {//폼 리셋
        		document.form.reset();
    		}
    	}

    	/**
    	*	화면
    	*/
    	function sheet1_OnDblClick(sheetObj , row, col , value) {
    		// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
    		var formObj = document.form;
    		var sheetObject2 = sheetObjects[1];

    		//sheetObject2.ShowDebugMsg = false;
    		formObj.f_cmd.value = SEARCHLIST02;
    		formObj.f_rout_no.value = sheetObj.CellValue(row, "cost_rout_no");
    		formObj.f_pctl_no.value = sheetObj.CellValue(row, "pctl_no");
    		
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
    		var sXml = sheetObject2.GetSearchXml("ESM_MAS_0061GS2.do", masFormQueryString(formObj));

    		var header = searchEtcData("header", sXml);
            if(header != ""){
                // header 정보 초기화
                //-------------------------
            	sheetObject2.Redraw = false;
            	sheetObject2.RemoveAll();
            	sheetObject2.Reset();
                initSheet(sheetObject2, 2, header);
                sheetObject2.Redraw = true;
                // data를 로딩한다.
                //-------------------------
                sheetObject2.LoadSearchXml(sXml);
                // Form Data setting
                //-------------------------
            }
    		//sheet3 초기화
    		sheetObjects[2].removeAll();
    		ComOpenWait(false);
    	}

    	/**
    	* sheet2조회후 Total데이터 계산
    	*/
    	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    		//total값 세팅
    		var Col = sheetObj.SaveNameCol("b0");
    		var totalLoad = 0.00;
    		var totalRev = 0.00;
    		var totalMisc = 0.00;
    		var totalDem = 0.00;
    		var totalCm = 0.00;
    		var totalGRpb = 0.00;	//G.RPB 추가 [CHM-201432263] 
    		var totalCMPB = 0.00;	//CMPB 추가 [CHM-201432263]
    		var totalOp = 0.00;
    		var totalOpExInt = 0.00;

    		for(var k=1 ; k < Col; k++) {
    			totalLoad += parseFloat(sheetObj.CellValue(1, k));	//Load(BOX)
    			totalRev  += parseFloat(sheetObj.CellValue(2, k));	//G.Rev, G.RPB->G.Rev Per Box
    			totalGRpb += parseFloat(sheetObj.CellValue(4, k));	//G.RPB [CHM-201432263] 추가
    			totalMisc += parseFloat(sheetObj.CellValue(5, k));	//Misc OP Rev
    			totalDem  += parseFloat(sheetObj.CellValue(6, k));	//DEM/DET
    			totalCm   += parseFloat(sheetObj.CellValue(7, k));	//CM, CM Per Box
    			totalCMPB   += parseFloat(sheetObj.CellValue(9, k));	//CMPB [CHM-201432263] 추가
    			totalOp   += parseFloat(sheetObj.CellValue(10, k));	// OP
    			totalOpExInt   += parseFloat(sheetObj.CellValue(11, k));	// OP(EX. Interest)
    		}

    		sheetObj.CellValue2(1,Col) = totalLoad;	//Load(BOX)
    		sheetObj.CellValue2(2,Col) = totalRev;	//G.Rev, G.Rev Per Box
    		sheetObj.CellValue2(4,Col) = totalGRpb;	//G.RPB 추가
    		sheetObj.CellValue2(5,Col) = totalMisc;	//Misc OP Rev
    		sheetObj.CellValue2(6,Col) = totalDem;	//DEM/DET
    		sheetObj.CellValue2(7,Col) = totalCm;	//CM, CM Per Box
    		sheetObj.CellValue2(9,Col) = totalCMPB;	//CMPB 추가
    		sheetObj.CellValue2(10,Col) = totalOp;	// OP
    		sheetObj.CellValue2(11,Col) = totalOpExInt;	// OP(EX. Interest)

    		//G.RPB(G.Rev Per Box), CM Per Box 값 세팅
    		sheetObj.CellValue2(3,Col) = totalRev/totalLoad;
    		sheetObj.CellValue2(8,Col) = totalCm/totalLoad;
    		sheetObj.CellValue2(12,Col) = totalOp/totalLoad;	// OP Per Box
    		
//    		if(getIbComboObjValue(document.form.f_pro_lvl) == "C"){
//    		 sheetObj.RowHidden(6) = true;
//    		}
    	}

    	/**
    	트리 접기
    	*/
    	function sheet3_OnSearchEnd(sheetObj, errMessge) {
    		//sheetObj.ShowSubSum( "grp", "cost", 0);
    		sheetObj.ShowTreeLevel(0, 1);
    		
    		// NOD, LOC를 제외한 평균단가로 추정된 비용에 대해 파란색 글씨 및 진하게 표시
//            var s_row = 1;
//            
//            while(s_row > 0){
//            	s_row = sheetObj.FindText("avg_lvl_chk", "Y", s_row);
//            	
//            	if(s_row == -1) {
//            		break;
//            	}
//            	
//            	sheetObj.CellFont("FontBold", s_row, 0, s_row, "avg_lvl_chk") = true;
//            	sheetObj.RowFontColor(s_row) = sheetObj.RgbColor(0,0,255);
//            	s_row = s_row + 1;
//            }
    	}
    	
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    			case IBCLEAR: //조회
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0061GS.do", masFormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					formObj.f_ofc_cd.value = ComGetEtcData(arrXml[0], "ofc_cd"); 
			        formObj.f_ofc_lvl.value = ComGetEtcData(arrXml[0], "ofc_lvl"); 
					
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
					if (arrXml.length > 1)
						ComXml2ComboItem(arrXml[1], formObj.f_pro_lvl, "code", "name");
					if (arrXml.length > 2)
						ComXml2ComboItem(arrXml[2], formObj.f_cntr_tpsz_cd, "code", "code");
					ComOpenWait(false);
					break;
    			case IBSEARCH:		//조회
    				if(validateForm(sheetObj,formObj,sAction))
    				{
    					if ( sheetObj.id == "sheet1" ) {
    						// 업무처리중 버튼사용 금지 처리
    						sheetObj.WaitImageVisible = false;
    						ComOpenWait(true);
    						formObj.f_cmd.value = SEARCHLIST01;
    		                //20100414 이중환, FormQueryString -> masFormQueryString 변경
    						sheetObj.DoSearch4Post("ESM_MAS_0061GS.do", masFormQueryString(formObj));
    					    // Form Data setting
    						//------------------------------------
    						ComEtcDataToForm(formObj, sheetObj);
    						
    						sheetObj.RemoveEtcData();
    						//------------------------------------
    						
    						sheetObjects[1].removeAll();
    						sheetObjects[2].removeAll();
    						ComOpenWait(false);
    					}
    					else if ( sheetObj.id == "sheet2" ) {
    						// 업무처리중 버튼사용 금지 처리
    						sheetObj.WaitImageVisible = false;
    						ComOpenWait(true);
    						formObj.f_cmd.value = SEARCHLIST02;
    						formObj.f_pctl_no.value = sheetObjects[1].cellValue(1, "pctl_no");
    		                //20100414 이중환, FormQueryString -> masFormQueryString 변경
    						var sXml = sheetObj.GetSearchXml("ESM_MAS_0061GS2.do", masFormQueryString(formObj));
    						
    			    		var header = searchEtcData("header", sXml);
    			            if(header != ""){
    			                // header 정보 초기화
    			                //-------------------------
    			            	sheetObj.Redraw = false;
    			            	sheetObj.RemoveAll();
    			            	sheetObj.Reset();
    			                initSheet(sheetObj, 2, header);
    			                sheetObj.Redraw = true;
    			                // data를 로딩한다.
    			                //-------------------------
    			                sheetObj.LoadSearchXml(sXml);
    			                //-------------------------
    			            }
    			            ComOpenWait(false);
    					}
    					else if ( sheetObj.id == "sheet3" ) {
    						// 업무처리중 버튼사용 금지 처리
    						sheetObj.WaitImageVisible = false;
    						ComOpenWait(true);
    						formObj.f_cmd.value = SEARCHLIST03;
    		                //20100414 이중환, FormQueryString -> masFormQueryString 변경
    						sheetObj.DoSearch4Post("ESM_MAS_0061GS2.do", masFormQueryString(formObj));
    						ComOpenWait(false);
    					}
    				}

    				break;

    			case IBSAVE:		//저장
    				break;

    			case IBINSERT:		// 입력
    				sheetObj.DataInsert();
    				break;

    			case IBCOPYROW:		//행 복사
    				sheetObj.DataCopy();
    				break;

    			case IBDOWNEXCEL:		//엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				sheetObjects[2].ColHidden("nod_cd") = true;
    				sheetObjects[2].ColHidden("grp") = true;			
    				sheetObjects[2].ColHidden("tree_col") = true;		
    				sheetObjects[2].ColHidden("dw_nod_cd") = false;
    				sheetObjects[2].ColHidden("dw_grp") = false;
    				sheetObjects[2].ColHidden("dw_tree_col") = false;
    				sheetObjects[2].ShowTreeLevel(-1);		
    				switch (excelType) {
    					case "AY":
    						sheetObjects[0].Down2Excel(-1, false, false, true);
    						sheetObjects[1].Down2Excel(0, true, false, true);
    						sheetObjects[2].Down2Excel(-1, true, false, true);
    						break;
    					case "DY":
    						sheetObjects[0].Down2Excel(-1, false, false, true);
    						sheetObjects[1].Down2Excel(-1, true, false, true);
    						sheetObjects[2].Down2Excel(-1, true, false, true);
    						break;
    					case "AN":
    						sheetObjects[0].SpeedDown2Excel(-1, false, false);
    						sheetObjects[1].SpeedDown2Excel(0, true, false);
    						sheetObjects[2].SpeedDown2Excel(-1, true, false);
    						break;
    					case "DN":
    						sheetObjects[0].SpeedDown2Excel(-1, false, false);
    						sheetObjects[1].SpeedDown2Excel(-1, true, false);
    						sheetObjects[2].SpeedDown2Excel(-1, true, false);
    						break;
    				}
    				sheetObjects[2].ColHidden("nod_cd") = false;
    				sheetObjects[2].ColHidden("grp") = false;				
    				sheetObjects[2].ColHidden("tree_col") = false;	
    				sheetObjects[2].ColHidden("dw_nod_cd") = true;
    				sheetObjects[2].ColHidden("dw_grp") = true;
    				sheetObjects[2].ColHidden("dw_tree_col") = true;
    				sheetObjects[2].ShowTreeLevel(0,1);
    				break;

    			case IBLOADEXCEL:		//엑셀 업로드
    				sheetObj.LoadExcel();
    				break;

    		}
    	}
    	
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			if (f_bkg_no.value == "") {
    				ComAlertFocus(f_bkg_no, ComGetMsg("MAS10002", "bkg_no", ""));
    				return false;
    			}
    		}

    		return true;
    	}

    	function getIbComboObjValue(obj){
    	  	if (ComGetObjValue(obj) == "All" ){
    	  		return "";
    	  	}
    	  	return ComGetObjValue(obj);
    	 } 
	/* 개발자 작업  끝 */