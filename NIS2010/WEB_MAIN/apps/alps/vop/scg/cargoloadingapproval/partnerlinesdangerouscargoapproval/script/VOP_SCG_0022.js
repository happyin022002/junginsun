/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0022.js
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
* 2012.01.11 김민아 [CHM-201115273-01] [VOP-SCG] SPCL CGO APVL for Partner Lines - AWK 보완
* 2012.02.08 서석진 [CHM-201215699-01] 로딩속도개선,화면에 보여질필요없는 컬럽 hidden처리
* 2012.05.29 이준범 [선처리] SPCL CGO APVL for Partner Lines 화면 수정
* 1) searchETADt() 파라미터 추가  - clpt_ind_seq
* 2) Sheet 헤더명 변경 ( CNTR -> CNTR Q’ty , Seq. -> Seq. (CNTR Q’ty) )
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
     * @class vop_scg_0022 : vop_scg_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0022() {
    	this.processButtonClick      = processButtonClick;
    	this.obj_blur                = obj_blur;
    	this.obj_keypress            = obj_keypress;
    	this.obj_keyup               = obj_keyup;
    	this.obj_nextfocus           = obj_nextfocus;
    	this.obj_change              = obj_change;
    	this.t1sheet1_OnLoadFinish   = t1sheet1_OnLoadFinish;
    	this.t2sheet1_OnLoadFinish   = t2sheet1_OnLoadFinish;
    	this.tab1_OnChange           = tab1_OnChange;
    	this.rgn_shp_opr_cd_OnChange = rgn_shp_opr_cd_OnChange;
    	this.t2sheet1_OnPopupClick   = t2sheet1_OnPopupClick;
    	this.t2sheet1_OnKeyUp        = t2sheet1_OnKeyUp;
    	this.t2sheet1_OnAfterEdit    = t2sheet1_OnAfterEdit;
    	this.t2sheet1_OnChange       = t2sheet1_OnChange;
    	this.t1sheet1_OnDblClick     = t1sheet1_OnDblClick;
    	this.t1sheet1_OnSearchEnd    = t1sheet1_OnSearchEnd;
    	this.t2sheet1_OnSearchEnd    = t2sheet1_OnSearchEnd;
    	this.t1sheet1_OnSelectMenu   = t1sheet1_OnSelectMenu;
    	this.t2sheet1_OnSelectMenu   = t2sheet1_OnSelectMenu;
    	this.t1sheet1_OnSelectCell   = t1sheet1_OnSelectCell;
    	this.t2sheet1_OnSelectCell   = t2sheet1_OnSelectCell;
    	this.initControl             = initControl;
    	this.loadPage                = loadPage;
    	this.initSheet               = initSheet;
    	this.initTab                 = initTab;
    	this.initCombo               = initCombo;
    	this.resetTab1               = resetTab1;
    	this.resetTab2               = resetTab2;
    	this.setSheetObject          = setSheetObject;
    	this.setTabObject            = setTabObject;
    	this.setComboObject          = setComboObject;
    	this.setVslEngNm             = setVslEngNm;
    	this.setVslLane              = setVslLane;
    	this.setCallBackVSL          = setCallBackVSL;
    	this.setCallBackVVD          = setCallBackVVD;
    	this.setSheetCallBackVSL     = setSheetCallBackVSL;
    	this.setSheetCallBackVVD     = setSheetCallBackVVD;
    	this.setSheetCallBackOPR     = setSheetCallBackOPR;
    	this.setPolCombo             = setPolCombo;
    	this.setPodCombo             = setPodCombo;
    	this.setETADt                = setETADt;
    	this.setTPSZCombo            = setTPSZCombo;
    	this.setAuthStat             = setAuthStat;
    	this.setAppDetlObj           = setAppDetlObj;
    	this.getAppDetlObj           = getAppDetlObj;
    	this.setSyncValMerge         = setSyncValMerge;
    	this.setRqstSeq              = setRqstSeq;
    	this.getSaveParam            = getSaveParam;
    	this.setResultPop            = setResultPop;
    	this.doPopDetails            = doPopDetails;
    	this.doMakeBookInfo          = doMakeBookInfo;
    	this.makeSearchXml           = makeSearchXml;
    	this.doActionIBSheet         = doActionIBSheet;
    	this.doActionIBCombo         = doActionIBCombo;
    	this.searchVVDRelInfo        = searchVVDRelInfo;
    	this.searchCarrierInfo       = searchCarrierInfo;
    	this.searchPolCd             = searchPolCd;
    	this.searchPodCd             = searchPodCd;
    	this.searchETADt             = searchETADt;
    	this.searchTPSZ              = searchTPSZ;
    	this.searchList              = searchList;
    	this.sendReqMail             = sendReqMail;
    	this.searchCarrierCheck      = searchCarrierCheck;
    	this.quitWaitImg             = quitWaitImg;
    	this.validateForm            = validateForm;
    }
    
   	/* 개발자 작업	*/

    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Define global variables
    //////////////////////////////////////////////////////////////////////////////////////////    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var comboObjects = new Array();
	var comboCnt = 0;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var prefixs = new Array("t1sheet1_","t2sheet1_");  
    
    var dupChkList = null;
    
    var g_sheet_id = "";
    var g_vsl_cd = "";
    var g_skd_voy_no = "";
    var g_skd_dir_cd = "";
    
    var rso_cd = "";
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Define global variables
    //////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Received event from form of UI
    //////////////////////////////////////////////////////////////////////////////////////////    

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        
    	var sheetObjT1 = sheetObjects[0];
        var sheetObjT2 = sheetObjects[1];
        
        var comboObj = comboObjects[0];
        var tabObj = tabObjects[0];

        /*******************************************************/
        var formObj = document.form;
        var msg = "";

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
                    doActionIBSheet(sheetObjT1,formObj,IBSEARCH);
                    break;

                case "btn_new":
                	if(!validateForm(sheetObjects[ComGetObjValue(formObj.tabSelectedIdx)],formObj,IBCLEAR)) return;
                	
                	ComResetAll();
                	
                	//var initSelTxt = comboObj.FindIndex("ASR", 0);
            		//comboObj.Text = initSelTxt;
            		
            		ComSetFocus(formObj.rgn_shp_opr_cd);
                	
                	resetTab1(sheetObjT1);                	
                	resetTab2(sheetObjT2);
                	formObj.rgn_shp_opr_cd.Code = formObj.u_rso.value;
                	
                    break;

                case "btn_save":
                	
                	var sheetIdx = tabObj.SelectedIndex;
                	doActionIBSheet(sheetObjects[sheetIdx],formObj,IBSAVE);
                    break;
                    
                case "btn_VVDpop":
					//VVD 선택팝업 열기					
					var vsl_cd = ComGetObjValue(formObj.vsl_cd);
                	var sUrl = "";
                	
                	if(vsl_cd == ""){
                		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
                	}
					break;
					
                case "btn_Carrier":
                	ComOpenPopupWithTarget('/hanjin/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 450, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
                	
                	break;
                case "btn_Calendar":
                	var cal = new ComCalendarFromTo();                	
                	cal.select(formObj.from_eta_dt, formObj.to_eta_dt, 'yyyy-MM-dd');
	 				break;
                /*** Tab DG (S) **/ 
                case "btn_Pol":
                	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0043.do?port_cd='+ComGetObjValue(document.form.pol_cd), 428, 520, "loc_cd:pol_cd", "0,0,1,1", true);
	 				break; 	
					
                case "btn_details":
                	doPopDetails(sheetObjT1, sheetObjT1.SelectRow);
                	break;
                	
                case "btn_t1add":
                	var lastSeqNo = sheetObjT1.CellValue(sheetObjT1.LastRow, prefixs[0]+"seqNo");
                	sheetObjT1.DataInsert(-1,0);							//마지막행에 생성[Sheet1]
                	
                	//초기화 항목
		        	var row = sheetObjT1.selectRow;
		        	sheetObjT1.CellValue2(row, prefixs[0]+"vsl_cd")      = ComGetObjValue(document.form.vsl_cd);
		        	sheetObjT1.CellValue2(row, prefixs[0]+"skd_voy_no")  = ComGetObjValue(document.form.skd_voy_no);
		        	sheetObjT1.CellValue2(row, prefixs[0]+"skd_dir_cd")  = ComGetObjValue(document.form.skd_dir_cd);
		        	sheetObjT1.CellValue2(row, prefixs[0]+"crr_cd")      = ComGetObjValue(document.form.crr_cd);
		        	sheetObjT1.CellValue2(row, prefixs[0]+"slan_cd")     = ComGetObjValue(document.form.slan_cd);
		        	//sheetObjT1.CellValue2(row, prefixs[0]+"cgo_rqst_dt") = ComGetNowInfo();
		        	//sheetObjT1.CellValue2(row, prefixs[0]+"auth_dt")     = ComGetNowInfo();
		        	sheetObjT1.CellValue2(row, prefixs[0]+"cgo_opr_cd")     = ComGetObjValue(document.form.cgo_opr_cd);//2016.08.26
		        	sheetObjT1.CellValue2(row, prefixs[0]+"bkg_ref_no")  = "";
		        	sheetObjT1.CellValue2(row, prefixs[0]+"auth_sts_cd") = "R";
		        	sheetObjT1.CellValue2(row, prefixs[0]+"apro_ref_no") = "";
		        	sheetObjT1.CellValue2(row, prefixs[0]+"spcl_cgo_rqst_seq") = "";
		        	
                	//POL Combo 생성
 	    			searchPolCd(sheetObjT1, sheetObjT1.selectRow, ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd));
                			        	
		        	if(isNaN(lastSeqNo)) {
		        		lastSeqNo = 1;
		        	} else {
		        		lastSeqNo = parseInt(lastSeqNo) + 1;
		        	}
		        	sheetObjT1.CellValue2(row, prefixs[0]+"seqNo") = lastSeqNo;
		        	sheetObjT1.CellValue2(row, prefixs[0]+"mrn_polut_flg") = "N";
		        	sheetObjT1.CellValue2(row, prefixs[0]+"imdg_lmt_qty_flg") = "N";
		        	sheetObjT1.CellValue2(row, prefixs[0]+"imdg_expt_qty_flg") = "N";
		        	
		        	
		        	sheetObjT1.SelectCell(sheetObjT1.selectRow, prefixs[0]+"bkg_ref_no");
		        	
		        	setAuthStat(sheetObjT1, row);
                	break;

		        case "btn_t1copy":	
		        	var selectedColNum = sheetObjT1.SelectCol;
		        	var spclCntrSeqColNum = sheetObjT1.SaveNameCol ( prefixs[0] + "spcl_cntr_seq");
		        	var spclCgoSeqColNum = sheetObjT1.SaveNameCol ( prefixs[0] + "spcl_cgo_seq");

		        	if(sheetObjT1.RowCount != 0) {  
			        	sheetObjT1.DataCopy();	//선택행아래 복사[Sheet1]
			        	
			        	//초기화 항목
			        	var row = sheetObjT1.selectRow;
			        	sheetObjT1.CellValue2(row, prefixs[0]+"cgo_rqst_dt") = "" //ComGetNowInfo();
			        	sheetObjT1.CellValue2(row, prefixs[0]+"auth_dt")     = "" //ComGetNowInfo();
			        	sheetObjT1.CellValue2(row, prefixs[0]+"auth_sts_cd") = "R";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"apro_ref_no") = "";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"spcl_cgo_rqst_seq") = "";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"apro_ref_no")       = "";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"seqNo")             = "";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"del_chk")           = "0";
			        	
			        	//POL Combo 생성
	 	    			searchPolCd(sheetObjT1, sheetObjT1.selectRow, ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd));
			        	
			        	setAuthStat(sheetObjT1, row);		        	
			        	
			        	//선택 Booking의 아래로 이동
			        	var curRowNo = sheetObjT1.CellValue(row-1, prefixs[0]+"seqNo");
			        	var moveRowIdx = sheetObjT1.LastRow;
			        	if(row != moveRowIdx) {
			        		moveRowIdx = sheetObjT1.FindText(sheetObjT1.SaveNameCol(prefixs[0]+"seqNo"), parseInt(curRowNo)+1);
				        	if(moveRowIdx == -1) {
				        		moveRowIdx = sheetObjT1.LastRow+1;
				        	}
			        	
				        	if(row != parseInt(moveRowIdx)-1) sheetObjT1.DataMove(moveRowIdx);
			        	}
			        	
			        	var startSeqNo = parseInt(sheetObjT1.CellValue(sheetObjT1.selectRow-1,prefixs[0]+"seqNo"));
			        	var currSeqNo = "0";
			        	var befoSeqNo = "0";
			        	for(var rowIdx=sheetObjT1.selectRow; rowIdx<=sheetObjT1.LastRow; rowIdx++) {
			        		currSeqNo = sheetObjT1.CellValue(rowIdx,prefixs[0]+"seqNo");
			        		if(currSeqNo != befoSeqNo) sheetObjT1.CellValue2(rowIdx,prefixs[0]+"seqNo") = ++startSeqNo;
			        		else sheetObjT1.CellValue2(rowIdx,prefixs[0]+"seqNo") = startSeqNo;
			        		befoSeqNo = currSeqNo;
			        	}
			        	
			        	sheetObjT1.CellValue2(row, prefixs[0]+"mrn_polut_flg") = "N";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"imdg_lmt_qty_flg") = "N";
			        	sheetObjT1.CellValue2(row, prefixs[0]+"imdg_expt_qty_flg") = "N";

			        	if ( selectedColNum == spclCntrSeqColNum || selectedColNum == spclCgoSeqColNum ) {
				        	if ( selectedColNum == sheetObjT1.SaveNameCol ( prefixs[0] + "spcl_cntr_seq")) {
				        		sheetObjT1.CellValue2 ( row, prefixs[0] + "spcl_cntr_seq" ) = getMaxCntrCgoSeq ( sheetObjT1, row, 1 ) ;
				        		sheetObjT1.CellValue2 ( row, prefixs[0] + "spcl_cgo_seq"  ) = "1";
				        	} else if ( selectedColNum == sheetObjT1.SaveNameCol ( prefixs[0] + "spcl_cgo_seq" ) ) {
				        		sheetObjT1.CellValue2 ( row, prefixs[0] + "spcl_cgo_seq"  ) = getMaxCntrCgoSeq ( sheetObjT1, row, 2 ) ;
				        	} 
				        	
							sheetObjT1.CellValue2(row, prefixs[0]+"cntr_tpsz_cd"			) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"imdg_un_no"				) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"imdg_un_no_seq"			) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"imdg_clss_cd"			) = "";

							sheetObjT1.CellValue2(row, prefixs[0]+"imdg_subs_rsk_lbl_cd"	) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"out_n1st_imdg_pck_qty"	) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"out_n1st_imdg_pck_cd"	) = "";

							sheetObjT1.CellValue2(row, prefixs[0]+"imdg_pck_grp_cd"			) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"imdg_expt_qty_flg"		) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"flsh_pnt_cdo_temp"		) = "";

							sheetObjT1.CellValue2(row, prefixs[0]+"grs_wgt"					) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"net_wgt"					) = "";
							sheetObjT1.CellValue2(row, prefixs[0]+"psa_no"					) = "";
				        	
				        	sheetObjT1.SelectCell(sheetObjT1.selectRow, prefixs[0]+"cntr_tpsz_cd");
			        	} else {
				        	//sheetObjT1.CellValue2(row, prefixs[0]+"bkg_ref_no")  = "";
				        	sheetObjT1.CellValue2(row, prefixs[0]+"spcl_cntr_seq")     = "1";
				        	sheetObjT1.CellValue2(row, prefixs[0]+"spcl_cgo_seq")      = "1";
				        	
				        	sheetObjT1.SelectCell(sheetObjT1.selectRow, prefixs[0]+"bkg_ref_no");
			        	}
			        	// Approval 되어있는 Row 를 DataCopy 할 경우 CellEditable 속성이 같이 복사 되는 것 같음.
			        	// 새로 생성된 Row 의 Editable 속성을 풀어 줘야 함.
 	    				DelChkOnlyEnable ( sheetObjT1, row, true );

		        	}
		        	
                    break;

                case "btn_t1delete":                	
                	ComRowHideDelete(sheetObjT1, prefixs[0]+"del_chk");
                	
                	var selRow = sheetObjT1.SelectRow;
                	if(selRow != -1) {
                		var rowHidden = sheetObjT1.RowHidden(selRow);
                		if(rowHidden) ComBtnDisable("btn_details");
                	} else {
                		ComBtnDisable("btn_details");
                	}
                    break;

                case "btn_t1downExcel":
                    var paramObj = new Object();
                    paramObj.title = "SPCL CGO APVL for Partner Lines - DG";
                    var url = ComScgGetPgmTitle(sheetObjT1, paramObj);  
                    sheetObjT1.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
                	
                    break;
                case "btn_t1loadExcel":
                    
                    sheetObjects[3].LoadExcel(0, 1, "", 6);
                    copyExcelData ( sheetObjects[3], sheetObjT1 );
                    break;

                /*** Tab DG (E) **/    

                /*** Tab Awkward (S) **/   

                case "btn_t2retrive":
                    doActionIBSheet(sheetObjT1,formObj,IBSEARCH);
                    break;

                case "btn_t2new":
                	sheetObjT2.RemoveAll();
                    break;
                    
                case "btn_t2add":
                	sheetObjT2.DataInsert(-1,0);							//마지막행에 생성[Sheet1]
                	
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"vsl_cd")     = ComGetObjValue(formObj.vsl_cd);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"skd_voy_no") = ComGetObjValue(formObj.skd_voy_no);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"skd_dir_cd") = ComGetObjValue(formObj.skd_dir_cd);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"slan_cd")    = ComGetObjValue(formObj.slan_cd);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"crr_cd")     = ComGetObjValue(formObj.crr_cd);
                	
                	//POL Combo 생성
 	    			searchPolCd(sheetObjT2, sheetObjT2.selectRow, ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd));
                	
                	sheetObjT2.SelectCell(sheetObjT2.selectRow, prefixs[1]+"bkg_ref_no");
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"cgo_rqst_dt") = ComGetNowInfo();
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"auth_dt")     = ComGetNowInfo();
                	
                	setAuthStat(sheetObjT2, sheetObjT2.selectRow);
                	
                    break;
                    
                case "btn_t2insert":                	
                	sheetObjT2.DataInsert();								//선택행아래 생성[Sheet1]
                	
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"vsl_cd")     = ComGetObjValue(formObj.vsl_cd);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"skd_voy_no") = ComGetObjValue(formObj.skd_voy_no);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"skd_dir_cd") = ComGetObjValue(formObj.skd_dir_cd);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"slan_cd")    = ComGetObjValue(formObj.slan_cd);
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"crr_cd")     = ComGetObjValue(formObj.crr_cd);
                	
                	//POL Combo 생성
 	    			searchPolCd(sheetObjT2, sheetObjT2.selectRow, ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd));
                	
                	sheetObjT2.SelectCell(sheetObjT2.selectRow, prefixs[1]+"bkg_ref_no");
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"cgo_rqst_dt") = "" //ComGetNowInfo();
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"auth_dt")     = "" //ComGetNowInfo();
                	
                	setAuthStat(sheetObjT2, sheetObjT2.selectRow);
                	
               	 	break;

		        case "btn_t2copy":
		        	sheetObjT2.DataCopy();									//선택행아래 복사[Sheet1]
		        	sheetObjT2.SelectCell(sheetObjT2.selectRow, prefixs[1]+"vsl_cd");
		        	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"cgo_rqst_dt") = "" //ComGetNowInfo();
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"auth_dt")     = "" //ComGetNowInfo();
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"auth_sts_cd") = "R";
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"apro_ref_no") = "";
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"spcl_cgo_rqst_seq")  = "";
		        	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"del_chk") = "0";
		        	
                	//2012.01.06 4)BKG Ref.No. Copy
		        	//sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"bkg_ref_no")  = "";
		        	
                	//2012.01.06 4)Seq 자동 증가
		        	var comp1 = sheetObjT2.CellValue(sheetObjT2.selectRow, prefixs[1]+"bkg_ref_no");
		        	var comp2 = sheetObjT2.CellValue(sheetObjT2.selectRow, prefixs[1]+"cgo_opr_cd");
		        	var comp3 = sheetObjT2.CellValue(sheetObjT2.selectRow, prefixs[1]+"pol_cd");
		        	var comp4 = sheetObjT2.CellValue(sheetObjT2.selectRow, prefixs[1]+"pod_cd");
		        	var maxSeq = 0;
		        	
		        	for(var fndIdx=sheetObjT2.HeaderRows ; fndIdx<=sheetObjT2.LastRow ;  fndIdx++){
		        		if(sheetObjT2.selectRow != fndIdx){
		        			if(comp1 == sheetObjT2.CellValue(fndIdx, prefixs[1]+"bkg_ref_no") && 
		        			   comp2 == sheetObjT2.CellValue(fndIdx, prefixs[1]+"cgo_opr_cd") && 
		        			   comp3 == sheetObjT2.CellValue(fndIdx, prefixs[1]+"pol_cd") && 
		        			   comp4 == sheetObjT2.CellValue(fndIdx, prefixs[1]+"pod_cd")
		        			){
		        				if(maxSeq < sheetObjT2.CellValue(fndIdx, prefixs[1]+"spcl_cntr_seq"))
		        					maxSeq = sheetObjT2.CellValue(fndIdx, prefixs[1]+"spcl_cntr_seq");
		        			}
		        		}
		        	}
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"spcl_cntr_seq") = parseInt(maxSeq)+1;
                	sheetObjT2.CellValue2(sheetObjT2.selectRow, prefixs[1]+"spcl_cgo_seq")  = sheetObjT2.CellValue(sheetObjT2.selectRow, prefixs[1]+"spcl_cntr_seq")  
                	
                	//POL Combo 생성
 	    			searchPolCd(sheetObjT2, sheetObjT2.selectRow, ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd));
                	
 	    			sheetObjT2.SelectCell(sheetObjT2.selectRow, prefixs[1]+"bkg_ref_no");
                	for ( var checkCell = 0; checkCell <= sheetObjT2.LastCol; checkCell++) {
                		if(sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"apro_ref_no" 
                		   && sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"slan_cd"
                		   && sheetObjT2.ColSaveName(checkCell) != prefixs[1]+"eta_dt") 
                			sheetObjT2.CellEditable(sheetObjT2.selectRow, checkCell) = true;
	    			}
                	
                	setAuthStat(sheetObjT2, sheetObjT2.selectRow);
                	
                    break;

                case "btn_t2delete":
                	ComRowHideDelete(sheetObjT2, prefixs[1]+"del_chk");
                    break;
                    
                case "btn_mail":
                	sendReqMail(sheetObjT2, sheetObjT2.selectRow, formObj);
                    break;

                case "btn_t2downExcel":
                    var paramObj = new Object();
                    paramObj.title = "SPCL CGO APVL for Partner Lines - Awkward";
                    var url = ComScgGetPgmTitle(sheetObjT2, paramObj);  
                    sheetObjT2.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
                    break;

                /*** Tab Awkward (E) **/  

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    // 업무 자바스크립트 OnBlur 이벤트 처리
    var beforeActiveObj = null;
    function obj_blur() {    	
		pastEventNum = 0;
    	var formObj = document.form;
    	with(event.srcElement) {
	    	switch(name){ 
		    	case "skd_dir_cd":	     
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
		    			searchVVDRelInfo(ComGetObjValue(formObj.vsl_cd), ComGetObjValue(formObj.skd_voy_no), ComGetObjValue(formObj.skd_dir_cd), "form", "");	//Vessell Name 조회
		    		}
		    		break;
		    	case "cgo_opr_cd":	
		    		if(document.activeElement.id != 'cgo_opr_cd' && beforeActiveObj != document.activeElement.id) {	//Object Tag의 onFocus시 Form Element의 onBlur 중복수행 방지를 위해
		        		beforeActiveObj = document.activeElement.id;
		    			searchCarrierCheck(event.srcElement);	//Carrier Check
		    		}
		        	break;
	    	}
    	}
    	beforeActiveObj = null;
    }

    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "vsl_cd":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	    	        	//숫자입력하기
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	//영문대문자 입력하기
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "cgo_opr_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
    	    	}
    	    	break;
    	    default:
    	    	//공통기준:영문, 숫자만을 인식
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
    }  
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var formObj = document.form;
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		ComSetNextFocus(obj);
    		
    		if(obj.name == 'vsl_cd') formObj.skd_voy_no.select();
    		else if(obj.name == 'skd_voy_no') formObj.skd_dir_cd.select();
    	}
    }
    
    // 업무 자바스크립트 OnChange 이벤트 처리
    function obj_change() {
    	var formObj = document.form;
    	with(event.srcElement) {
	    	switch(name){
		    	case "vsl_cd":		
		    		ComSetObjValue(formObj.skd_voy_no, "");
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
	    			ComSetObjValue(formObj.crr_cd, "");
	    			ComSetObjValue(formObj.slan_cd, "");
	    			ComSetObjValue(formObj.slan_nm, "");
	    			
	    			sheetObjects[0].RemoveAll();
	    			sheetObjects[1].RemoveAll();
	    			resetTab1(sheetObjects[0]);
	    			resetTab2(sheetObjects[1]);
		        	break;
		    	case "skd_voy_no":		
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
	    			ComSetObjValue(formObj.crr_cd, "");
	    			ComSetObjValue(formObj.slan_cd, "");
	    			ComSetObjValue(formObj.slan_nm, "");
	    			
	    			sheetObjects[0].RemoveAll();
	    			sheetObjects[1].RemoveAll();
	    			resetTab1(sheetObjects[0]);
	    			resetTab2(sheetObjects[1]);
		        	break;
		    	case "skd_dir_cd":	    			
	    			ComSetObjValue(formObj.vsl_eng_nm, "");
	    			ComSetObjValue(formObj.crr_cd, "");
	    			ComSetObjValue(formObj.slan_cd, "");
	    			ComSetObjValue(formObj.slan_nm, "");
	    			
	    			sheetObjects[0].RemoveAll();
	    			sheetObjects[1].RemoveAll();
	    			resetTab1(sheetObjects[0]);
	    			resetTab2(sheetObjects[1]);
		        	break;
	    	}
    	}
    } 
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Received event from form of UI
    //////////////////////////////////////////////////////////////////////////////////////////       
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Received event from sheet of UI
    //////////////////////////////////////////////////////////////////////////////////////////       
    
    function t1sheet1_OnLoadFinish(sheetObj) {	 
    	searchTPSZ(sheetObj);
    	resetTab1(sheetObj);
    	
    	tabObjects[0].SelectedIndex = 1;
    	tabObjects[0].SelectedIndex = 0;
    	
    	doActionIBCombo(comboObjects[0],1);
    }
    
    function t2sheet1_OnLoadFinish(sheetObj) {
    	searchTPSZ(sheetObj); 	
    	resetTab2(sheetObj);
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
    	var formObj = document.form;
    	
    	var tabSelectedIdx = ComGetObjValue(formObj.tabSelectedIdx);
    	
    	//validateForm(sheetObjects[tabSelectedIdx],formObj,IBCLEAR);	//DG, Awkward 동시저장으로 변경으로 하여 기능 삭제처리
        
    	var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;	
    	
    	ComSetObjValue(formObj.tabSelectedIdx, nItem);
    }
    
    /**
     * Combo 선택시 이벤트 관련
     * 포커스 이동
     */
    function rgn_shp_opr_cd_OnChange(comboObj , Index_Code, Text) {
        if(Text != '') ComSetFocus(document.form.vsl_cd);
        sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		resetTab1(sheetObjects[0]);
		resetTab2(sheetObjects[1]);
    }
    /**
     * t1sheet1 Popup Click Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * 
     */
    function t1sheet1_OnPopupClick(sheetObj, Row, Col) {
		with(sheetObj) { 
			switch (sheetObj.ColSaveName(Col)) {
//				case prefixs[0]+"skd_dir_cd" :
//					//VVD 선택팝업 열기					
//					var vsl_cd = CellValue(Row, prefixs[0]+"vsl_cd");
//		        	var sUrl = "";
//		        	
//		        	if(vsl_cd == ""){
//		        		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
//		        		ComOpenPopup(sUrl, 463, 480, "setSheetCallBackVSL", "0,0", true, false, Row, Col, 1);
//		        	}else{
//		        		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
//		        		ComOpenPopup(sUrl, 335, 385, "setSheetCallBackVVD", "0,0", true, false, Row, Col, 1);
//		        	}
//		        	break;
		        	
				case prefixs[0]+"cgo_opr_cd" :
					ComOpenPopup('/hanjin/COM_ENS_0N1.do?crr_cd='+CellValue(Row, prefixs[0]+"cgo_opr_cd"), 423, 450, "setSheetCallBackOPR", '0,0,1,1,1', true, false, Row, Col, 0);
					break;
	
			
						
//				case prefixs[0]+"cgo_rqst_dt" : case prefixs[0]+"auth_dt" :
//					var cal = new ComCalendarGrid();
//				    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
//				    break;			    
//			    
			}
 		}
 	}
    
    
    /**
     * t2sheet1 Popup Click Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * 
     */
    function t2sheet1_OnPopupClick(sheetObj, Row, Col) {
		with(sheetObj) { 
			switch (sheetObj.ColSaveName(Col)) {
				case prefixs[1]+"skd_dir_cd" :
					//VVD 선택팝업 열기					
					var vsl_cd = CellValue(Row, prefixs[1]+"vsl_cd");
		        	var sUrl = "";
		        	
		        	if(vsl_cd == ""){
		        		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
		        		ComOpenPopup(sUrl, 463, 480, "setSheetCallBackVSL", "0,0", true, false, Row, Col, 1);
		        	}else{
		        		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
		        		ComOpenPopup(sUrl, 335, 385, "setSheetCallBackVVD", "0,0", true, false, Row, Col, 1);
		        	}
		        	break;
		        	
				case prefixs[1]+"cgo_opr_cd" :
					ComOpenPopup('/hanjin/COM_ENS_0N1.do?crr_cd='+CellValue(Row, prefixs[1]+"cgo_opr_cd"), 423, 450, "setSheetCallBackOPR", '0,0,1,1,1', true, false, Row, Col, 1);
					break;
					
				case prefixs[1]+"cgo_rqst_dt" : case prefixs[1]+"auth_dt" :
					var cal = new ComCalendarGrid();
				    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
				    break;			    
			    
			}
 		}
 	}
    
    /**
     * t2sheet1 OnKeyUp Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * 
     */
    function t2sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		with(sheetObj) { 
			var len = sheetObj.EditValue.length;
			if(sheetObj.ColSaveName(Col) == prefixs[1]+"vsl_cd") { 
				if(len == 4) sheetObj.SelectCell(Row, prefixs[1]+"skd_voy_no");
			} else if(sheetObj.ColSaveName(Col) == prefixs[1]+"skd_voy_no") { 
				if(len == 4) sheetObj.SelectCell(Row, prefixs[1]+"skd_dir_cd");
			} else if(sheetObj.ColSaveName(Col) == prefixs[1]+"skd_dir_cd") { 
				if(len == 1) {
					searchVVDRelInfo(sheetObj.CellValue(Row, prefixs[1]+"vsl_cd"), sheetObj.CellValue(Row, prefixs[1]+"skd_voy_no"), sheetObj.EditValue, "t2Sheet1", Row);
				}
			}
 		}
 	} 
    
    /**
     * t2sheet1 OnAfterEdit Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet1_OnAfterEdit(sheetObj, Row, Col)  {
    	if(sheetObj.ColSaveName(Col) == prefixs[1]+"cgo_opr_cd") {
    		//if(sheetObj.EditValue != '') searchCarrierInfo(sheetObj, Row, sheetObj.EditValue);	//SelectCell 기능 미작동으로 삭제, OnChange로 대체
    	}
    }
    /**
     * t1sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var idx_value = Value;
    	if(lockKey) {
	    	with(sheetObj) { 
	    		switch (ColSaveName(Col)) {
					case prefixs[0]+"pol_cd" :
						// CellComboItem 에 의해서 발생한 ( 예상 ) Onchange Event 에 의한 abnormal 방지를 위한 부분 
						if ( ( Value == null || Value.trim() == "" ) && CellValue(Row, Col).trim() == "" ) {
							return;
						}
						setSyncValMerge(sheetObj, Row, Col, Value);

						CellValue2 ( Row, sheetObj.SaveNameCol(prefixs[0]+"pol_clpt_ind_seq" ) ) = Value.substring(5);
						setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[0]+"pol_clpt_ind_seq"), Value.substring(5) );
					    if(ComTrim(Value) != '') {
							searchETADt(sheetObj, Row, CellValue(Row, prefixs[0]+"vsl_cd"), CellValue(Row, prefixs[0]+"skd_voy_no"), CellValue(Row, prefixs[0]+"skd_dir_cd"), Value, CellValue(Row, prefixs[0]+"pol_clpt_ind_seq"));
							searchPodCd(sheetObj, Row, CellValue(Row, prefixs[0]+"vsl_cd"), CellValue(Row, prefixs[0]+"skd_voy_no"), CellValue(Row, prefixs[0]+"skd_dir_cd"), Value);
							sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[0]+"pod_cd")) = "";
							sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[0]+"pod_clpt_ind_seq")) = "";
							
							//수정일 경우 Merge Cell Sync
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[0]+"eta_dt"), CellValue(Row, prefixs[0]+"eta_dt"));
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[0]+"pod_cd"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[0]+"pod_clpt_ind_seq"), "");
							
						} else {
							CellValue2(Row, prefixs[0]+"eta_dt") = "";
							sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[0]+"pod_cd"), "", "", 0);				     		
				     		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[0]+"pod_cd")) = "";
				     		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[0]+"pod_clpt_ind_seq")) = "";
				     		
							//수정일 경우 Merge Cell Sync
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[0]+"eta_dt"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[0]+"pod_cd"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[0]+"pod_clpt_ind_seq"), "");
						
						}
											
						break;
					case prefixs[0]+"pod_cd" :
						// CellComboItem 에 의해서 발생한 ( 예상 ) Onchange Event 에 의한 abnormal 방지를 위한 부분 
						if ( ( Value == null || Value.trim() == "" ) && CellValue(Row, Col).trim() == "" ) {
							return;
						}
						//수정일 경우 Merge Cell Sync
						setSyncValMerge(sheetObj, Row, Col, Value);
						CellValue2 ( Row, sheetObj.SaveNameCol(prefixs[0]+"pod_clpt_ind_seq" ) ) = Value.substring(5);
						setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[0]+"pod_clpt_ind_seq"), Value.substring(5) );
					    
						break;
					case prefixs[0]+"spcl_cntr_seq" :
						var cgo_seq = CellValue(Row,prefixs[0]+"spcl_cgo_seq");
						if ( cgo_seq == '' || cgo_seq == null ) {
							CellValue2(Row, prefixs[0]+"spcl_cgo_seq") = 1;
						}
							
						break;
					case prefixs[0]+"cgo_opr_cd" :
						if(EditValue != '') searchCarrierInfo(sheetObj, Row, EditValue);
							
						break;
					case prefixs[0]+"imdg_un_no" :
						if(EditValue != '') searchImdgUnNoSeq(sheetObj, Row, EditValue);
							
						break;
					case prefixs[0]+"imdg_un_no_seq" :
						if(EditValue != '') searchClassSubRiskPG(sheetObj, Row, sheetObj.CellValue ( Row, prefixs[0]+"imdg_un_no" ), sheetObj.CellValue ( Row, prefixs[0]+"imdg_un_no_seq" ));
							
						break;
/*						
					case prefixs[0]+"out_n1st_imdg_pck_cd" :
						if(EditValue != '') searchClassSubRiskPG(sheetObj, Row, sheetObj.CellValue ( Row, prefixs[0]+"out_n1st_imdg_pck_cd" ) );
							
						break;
*/						
						
		    		 case prefixs[0]+"auth_sts_cd":
		    			 if (Value == "A") {
		    				 var bkgRefNo       = CellValue(Row, prefixs[0]+"bkg_ref_no");
		    				 var spclCgoRqstSeq = CellValue(Row, prefixs[0]+"spcl_cgo_rqst_seq");
		    				 for (var i = 2; i <= LastRow; i ++)
		    	    		 {
		    	    			 if (bkgRefNo == CellValue(i, prefixs[0]+"bkg_ref_no") && spclCgoRqstSeq == CellValue(i, prefixs[0]+"spcl_cgo_rqst_seq") ) {
		    	    				 CellValue2(i, prefixs[0]+"auth_sts_cd") = "Y";
		    	    			 }
		    	    		 }
		    			 }
		    			 break;
	    		}
	    		setAuthStat(sheetObj, Row);
	    		
	    	}
    	}
    }
     
    
    /**
     * t2sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    	if(lockKey) {
	    	with(sheetObj) { 
	    		switch (ColSaveName(Col)) {
					case prefixs[1]+"pol_cd" :
						// CellComboItem 에 의해서 발생한 ( 예상 ) Onchange Event 에 의한 abnormal 방지를 위한 부분 
						if ( ( Value == null || Value.trim() == "" ) && CellValue(Row, Col).trim() == "" ) {
							return;
						}
						//수정일 경우 Merge Cell Sync
						setSyncValMerge(sheetObj, Row, Col, Value);
						
						CellValue2 ( Row, sheetObj.SaveNameCol(prefixs[1]+"pol_clpt_ind_seq" ) ) = Value.substring(5);
						setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[1]+"pol_clpt_ind_seq"), Value.substring(5) );
					    if(ComTrim(Value) != '') {
							searchETADt(sheetObj, Row, CellValue(Row, prefixs[1]+"vsl_cd"), CellValue(Row, prefixs[1]+"skd_voy_no"), CellValue(Row, prefixs[1]+"skd_dir_cd"), Value, CellValue(Row, prefixs[1]+"pol_clpt_ind_seq"));
							searchPodCd(sheetObj, Row, CellValue(Row, prefixs[1]+"vsl_cd"), CellValue(Row, prefixs[1]+"skd_voy_no"), CellValue(Row, prefixs[1]+"skd_dir_cd"), Value);
							sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd")) = "";
							sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_clpt_ind_seq")) = "";
							
							//수정일 경우 Merge Cell Sync
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"eta_dt"), CellValue(Row, prefixs[1]+"eta_dt"));
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"pod_cd"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"pod_clpt_ind_seq"), "");
						} else {
							CellValue2(Row, prefixs[1]+"eta_dt") = "";
							sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd"), "", "", 0);				     		
				     		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_cd")) = "";
				     		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[1]+"pod_clpt_ind_seq")) = "";
				     		
							//수정일 경우 Merge Cell Sync
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"eta_dt"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"pod_cd"), "");
							setSyncValMerge(sheetObj, Row, SaveNameCol(prefixs[1]+"pod_clpt_ind_seq"), "");
						}
											
						break;
					case prefixs[1]+"pod_cd" :
						// CellComboItem 에 의해서 발생한 ( 예상 ) Onchange Event 에 의한 abnormal 방지를 위한 부분 
						if ( ( Value == null || Value.trim() == "" ) && CellValue(Row, Col).trim() == "" ) {
							return;
						}
						//수정일 경우 Merge Cell Sync
						setSyncValMerge(sheetObj, Row, Col, Value);
						CellValue2 ( Row, sheetObj.SaveNameCol(prefixs[1]+"pod_clpt_ind_seq" ) ) = Value.substring(5);
						setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[1]+"pod_clpt_ind_seq"), Value.substring(5) );
						break;
					case prefixs[1]+"spcl_cntr_seq" :
						CellValue2(Row, prefixs[1]+"spcl_cgo_seq") = EditValue;
							
						break;
					case prefixs[1]+"cgo_opr_cd" :
						if(EditValue != '') searchCarrierInfo(sheetObj, Row, EditValue);
							
						break;
	    		}
	    		setAuthStat(sheetObj, Row);
	    	}
    	}
    }
     
    /**
     * Dangerous CGO Application Details for Partner Lines 화면 팝업 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
 	function t1sheet1_OnDblClick(sheetObj,Row,Col,Value){
 		if( sheetObj.CellValue ( Row, prefixs[0]+"ibflag") == "I" || sheetObj.CellValue ( Row, prefixs[0]+"ibflag" )=="U" ) {
 			ComShowMessage( "There is data changed. Please save it first" );
 			return;
 		}
 		if(sheetObj.ColSaveName(Col) != prefixs[0]+"del_chk") doPopDetails(sheetObj, Row);		
 		return;
 	}
     
 	
 	
	function t1sheet1_OnClick(sheetObj,Row,Col,Value){
 	
 		if(sheetObj.ColSaveName(Col) == prefixs[0]+"apro_ref_no") doPopUpAprn(sheetObj, Row, 'sheet1');		
 		return;
 	}
     
	function t2sheet1_OnClick(sheetObj,Row,Col,Value){
		
		if(sheetObj.ColSaveName(Col) == prefixs[1]+"apro_ref_no") doPopUpAprn(sheetObj, Row, 'sheet2');		
  	 	 return;
 	}
 			   
				
    /**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.Enable = true;
    	ComBtnsEnable(true);
     	
     	ComBtnEnable("btn_t1add");
     	ComBtnEnable("btn_t1copy");
     	ComBtnEnable("btn_t1delete");
     	ComBtnEnable("btn_t1downExcel");
     	ComBtnEnable("btn_t1loadExcel");
    	 
     	//조회된 건이 있을 경우에만 수행
     	if(sheetObj.RowCount != 0) {     		
 	    	with (sheetObj) {   
 	    		var seqNo = 0;
 	    		var pol_cd, pod_cd, vsl_cd, skd_voy_no, skd_dir_cd, sts_cd, imdg_un_no;
 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
 	    		//for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) { 	    
 	    		for (var checkRow = LastRow; checkRow >= HeaderRows; checkRow--) {
 	    			
 	    			pol_cd = CellValue(checkRow, prefixs[0]+"pol_cd");
 	    			pod_cd = CellValue(checkRow, prefixs[0]+"pod_cd");
 	    			
 	    			vsl_cd = CellValue(checkRow, prefixs[0]+"vsl_cd");
 	    			skd_voy_no = CellValue(checkRow, prefixs[0]+"skd_voy_no");
 	    			skd_dir_cd = CellValue(checkRow, prefixs[0]+"skd_dir_cd");
 	    			imdg_un_no = CellValue(checkRow, prefixs[0]+"imdg_un_no");
	    				    			
 	    			//POL Combo 생성
 	    			if(searchPolCd(sheetObj, checkRow, vsl_cd, skd_voy_no, skd_dir_cd)) {    			
 	    				CellValue2(checkRow, prefixs[0]+"pol_cd") = pol_cd;
 	    			}
 	    			
 	    			//POD Combo 생성
 	    			searchPodCd(sheetObj, checkRow, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd);
 	    			CellValue2(checkRow, prefixs[0]+"pod_cd") = pod_cd;
 	    			
 	    			//IMDG UN NO SEQ Combo 생성
 	    			//searchImdgUnNoSeq ( sheetObj, checkRow, imdg_un_no );
 	    			
 	    			setAuthStat(sheetObj, checkRow);
 	    			
 	    			rqstSeq1 = CellValue(checkRow, prefixs[0]+"spcl_cgo_rqst_seq");
 	    			if(rqstSeq1 != rqstSeq2) seqNo++;
 	    				
 	    			CellValue2(checkRow, prefixs[0]+"seqNo") = seqNo;
 	    			
 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			var auth_sts_cd = CellValue(checkRow, prefixs[0]+"auth_sts_cd");
 	    			if(auth_sts_cd == 'Y' || auth_sts_cd == 'N' ){ 
 	    				// RowHidden(checkRow) = true;	//Total Count와 Select Row 의 문제로 인하여 RowDelete로 대체
 	    				// RowDelete(checkRow, false);
 	    				//RowEditable(checkRow) = false;
 	    				DelChkOnlyEnable ( sheetObj, checkRow, false );
 	    			} else {
 	    				RowStatus(checkRow) = "R";
 	    				//IMDG UN NO SEQ Combo 생성
 	 	    			searchImdgUnNoSeq ( sheetObj, checkRow, imdg_un_no );
 	    				//RowEditable(checkRow) = true;
 	    			}
 	    			
 	    			CellEditable(checkRow, prefixs[0]+"auth_sts_cd"					) = true;
 	    		}
 	    		
 	    		for (var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) { 	
 	    			CellValue2(checkRow, prefixs[0]+"seqNo") = parseInt(seqNo)+1-parseInt(CellValue(checkRow, prefixs[0]+"seqNo"));
 	    			RowStatus(checkRow) = "R";
 	    		}
 	    	}
     	} else {
     		ComBtnDisable("btn_details");
     	}
     	
     	quitWaitImg(1);
    }

    /**
     * sheetObjects[3] 으로 Import 된 Data 를 sheet 에 맞게끔 옮겨놓기
     * param : sheetOrg ==> Import Data Sheet, sheetDst ==> 대상 Sheet
     * 
     */
    function copyExcelData(sheetOrg, sheetDst ) {
    	
    	var orgDataCnt = sheetOrg.RowCount;
    	
     	if(orgDataCnt > 0) {

	    	var seq_no, bkg_ref_no, cgo_opr_cd, pol_cd, pol_clpt_ind_seq, eta_dt, pod_cd, pod_clpt_ind_seq;
	    	var auth_sts_cd, apro_ref_no, spcl_cntr_seq, spcl_cgo_seq, cntr_tpsz_cd;
	    	var imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_subs_rsk_lbl_cd, out_n1st_imdg_pck_qty, out_n1st_imdg_pck_cd, mrn_polut_flg;
	    	var imdg_pck_grp_cd, imdg_lmt_qty_flg, imdg_expt_qty_flg, flsh_pnt_cdo_temp, grs_wgt, net_wgt, psa_no, cgo_rqst_dt, auth_dt;
	     		
    		var vsl_cd     = ComGetObjValue(document.form.vsl_cd);
    		var skd_voy_no = ComGetObjValue(document.form.skd_voy_no);
    		var skd_dir_cd = ComGetObjValue(document.form.skd_dir_cd);
    		var crr_cd     = ComGetObjValue(document.form.crr_cd);
    		var slan_cd    = ComGetObjValue(document.form.slan_cd);
     		
     		for ( var orow = 0;  orow < orgDataCnt; orow++ ) {
     			
     			with(sheetOrg) {
					seq_no                  = CellValue(orow+2, "seqNo");
					bkg_ref_no              = CellValue(orow+2, "bkg_ref_no");
					cgo_opr_cd              = CellValue(orow+2, "cgo_opr_cd");
					pol_cd                  = CellValue(orow+2, "pol_cd");
					pol_clpt_ind_seq        = CellValue(orow+2, "pol_clpt_ind_seq");
					eta_dt                  = CellValue(orow+2, "eta_dt");
					pod_cd                  = CellValue(orow+2, "pod_cd");
					pod_clpt_ind_seq        = CellValue(orow+2, "pod_clpt_ind_seq");
					auth_sts_cd             = CellValue(orow+2, "auth_sts_cd");
					apro_ref_no             = CellValue(orow+2, "apro_ref_no");
					spcl_cntr_seq           = CellValue(orow+2, "spcl_cntr_seq");
					spcl_cgo_seq            = CellValue(orow+2, "spcl_cgo_seq");
					cntr_tpsz_cd            = CellValue(orow+2, "cntr_tpsz_cd");
					imdg_un_no              = CellValue(orow+2, "imdg_un_no");
					imdg_un_no_seq          = CellValue(orow+2, "imdg_un_no_seq");
					imdg_clss_cd            = CellValue(orow+2, "imdg_clss_cd");
					imdg_subs_rsk_lbl_cd    = CellValue(orow+2, "imdg_subs_rsk_lbl_cd");
					out_n1st_imdg_pck_qty   = CellValue(orow+2, "out_n1st_imdg_pck_qty");
					out_n1st_imdg_pck_cd    = CellValue(orow+2, "out_n1st_imdg_pck_cd");
					mrn_polut_flg           = CellValue(orow+2, "mrn_polut_flg");
					imdg_pck_grp_cd         = CellValue(orow+2, "imdg_pck_grp_cd");
					imdg_lmt_qty_flg        = CellValue(orow+2, "imdg_lmt_qty_flg");
					imdg_expt_qty_flg       = CellValue(orow+2, "imdg_expt_qty_flg");
					flsh_pnt_cdo_temp       = CellValue(orow+2, "flsh_pnt_cdo_temp");
					grs_wgt                 = CellValue(orow+2, "grs_wgt");
					net_wgt                 = CellValue(orow+2, "net_wgt");
					psa_no                  = CellValue(orow+2, "psa_no");
					cgo_rqst_dt             = CellValue(orow+2, "cgo_rqst_dt");
					auth_dt                 = CellValue(orow+2, "auth_dt");
     			}
     		
	     		var row = sheetDst.DataInsert ( -1, 0 );
	     		
	     		with (sheetDst) {   
	     			var lastSeqNo;
	     			var seqNo = 0;
	     			var rqstSeq1 = -1, rqstSeq2 = -1;
 	    			
 	    			//lastSeqNo = CellValue(row - 1, prefixs[0]+"seqNo");
 	    			lastSeqNo = ComScgGetMax ( sheetDst, prefixs[0]+"seqNo");
                	
                	//초기화 항목
                	CellValue2(row, prefixs[0]+"vsl_cd")      = vsl_cd;
		        	CellValue2(row, prefixs[0]+"skd_voy_no")  = skd_voy_no;
		        	CellValue2(row, prefixs[0]+"skd_dir_cd")  = skd_dir_cd;
		        	CellValue2(row, prefixs[0]+"crr_cd")      = crr_cd;
		        	CellValue2(row, prefixs[0]+"slan_cd")     = slan_cd;
		        	CellValue2(row, prefixs[0]+"cgo_rqst_dt") = ComGetNowInfo();
		        	
					CellValue2(row, prefixs[0]+"bkg_ref_no")                    = bkg_ref_no;           
					CellValue2(row, prefixs[0]+"cgo_opr_cd")					= cgo_opr_cd;           
					CellValue2(row, prefixs[0]+"pol_cd")						= pol_cd;               
					CellValue2(row, prefixs[0]+"pol_clpt_ind_seq")				= pol_clpt_ind_seq;
					CellValue2(row, prefixs[0]+"eta_dt")						= eta_dt;     
					CellValue2(row, prefixs[0]+"pod_cd")						= pod_cd;               
					CellValue2(row, prefixs[0]+"pod_clpt_ind_seq")				= pod_clpt_ind_seq;      
					CellValue2(row, prefixs[0]+"spcl_cntr_seq")					= spcl_cntr_seq;         
					CellValue2(row, prefixs[0]+"spcl_cgo_seq")					= spcl_cgo_seq;          
					CellValue2(row, prefixs[0]+"cntr_tpsz_cd")					= cntr_tpsz_cd;          
					CellValue2(row, prefixs[0]+"imdg_un_no")					= imdg_un_no;            
					CellValue2(row, prefixs[0]+"imdg_un_no_seq")				= imdg_un_no_seq;        
					CellValue2(row, prefixs[0]+"imdg_clss_cd")					= imdg_clss_cd;          
					CellValue2(row, prefixs[0]+"imdg_subs_rsk_lbl_cd")			= imdg_subs_rsk_lbl_cd;  
					CellValue2(row, prefixs[0]+"out_n1st_imdg_pck_qty")			= out_n1st_imdg_pck_qty; 
					CellValue2(row, prefixs[0]+"out_n1st_imdg_pck_cd")			= out_n1st_imdg_pck_cd;  
					CellValue2(row, prefixs[0]+"imdg_pck_grp_cd")				= imdg_pck_grp_cd;       
					CellValue2(row, prefixs[0]+"imdg_expt_qty_flg")				= imdg_expt_qty_flg;     
					CellValue2(row, prefixs[0]+"flsh_pnt_cdo_temp")				= flsh_pnt_cdo_temp;     
					CellValue2(row, prefixs[0]+"grs_wgt")						= grs_wgt;               
					CellValue2(row, prefixs[0]+"net_wgt")						= net_wgt;               
					CellValue2(row, prefixs[0]+"psa_no")						= psa_no;                
					CellValue2(row, prefixs[0]+"cgo_rqst_dt")					= cgo_rqst_dt;           
		        	
		        	CellValue2(row, prefixs[0]+"auth_sts_cd") = "R";
		        	CellValue2(row, prefixs[0]+"apro_ref_no") = "";
		        	CellValue2(row, prefixs[0]+"auth_dt")     = "";
		        	
                	if(isNaN(lastSeqNo)) {
		        		lastSeqNo = 1;
		        	} else {
		        		lastSeqNo = parseInt(lastSeqNo) + 1;
		        	}
		        	CellValue2(row, prefixs[0]+"seqNo") = lastSeqNo;
		        	CellValue2(row, prefixs[0]+"mrn_polut_flg") = "N";
		        	CellValue2(row, prefixs[0]+"imdg_lmt_qty_flg") = "N";
		        	
		        	//POL Combo 생성
		        	if(searchPolCd(sheetDst, row, vsl_cd, skd_voy_no, skd_dir_cd)) {    			
 	    				CellValue2(row, prefixs[0]+"pol_cd") = pol_cd + pol_clpt_ind_seq;
 	    			}
 	    			
 	    			//POD Combo 생성
 	    			searchPodCd(sheetDst, row, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd);
 	    			CellValue2(row, prefixs[0]+"pod_cd") = pod_cd + pod_clpt_ind_seq;
 	    			
 	    			if ( imdg_subs_rsk_lbl_cd.trim() != "" && imdg_subs_rsk_lbl_cd != null ) {
	 	    			var subRiskArr = imdg_subs_rsk_lbl_cd.split("/");
	 	    			
	 	    			if ( subRiskArr.length > 0 ){
	 	    				CellValue2(row, prefixs[0]+"n1st_imdg_subs_rsk_lbl_cd") = ( subRiskArr[0] == '' ? "0" : subRiskArr[0] );
	 	    			}
	 	    			if ( subRiskArr.length > 1 ){
	 	    				CellValue2(row, prefixs[0]+"n2nd_imdg_subs_rsk_lbl_cd") = ( subRiskArr[1] == '' ? "0" : subRiskArr[1] );
	 	    			}
	 	    			if ( subRiskArr.length > 2 ){
	 	    				CellValue2(row, prefixs[0]+"n3rd_imdg_subs_rsk_lbl_cd") = ( subRiskArr[2] == '' ? "0" : subRiskArr[2] );
	 	    			}
	 	    			if ( subRiskArr.length > 3 ){
	 	    				CellValue2(row, prefixs[0]+"n4th_imdg_subs_rsk_lbl_cd") = ( subRiskArr[3] == '' ? "0" : subRiskArr[3] );
	 	    			}
		        	}
 	    			
 	    			//alert("5");
 	    			//IMDG UN NO SEQ Combo 생성
 	    			imdg_un_no = CellValue(row, prefixs[0]+"imdg_un_no");
 	    			CellValue2(row, prefixs[0]+"ibflag") = "R";
 	    			searchImdgUnNoSeq ( sheetDst, row, imdg_un_no );
 	    			
 	    			setAuthStat(sheetDst, row);
// 	    			rqstSeq1 = CellValue(row, prefixs[0]+"spcl_cgo_rqst_seq");
// 	    			if(rqstSeq1 != rqstSeq2) seqNo++;
// 	    			
// 	    			CellValue2(row, prefixs[0]+"seqNo") = seqNo;
// 	    			
// 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			CellValue2(row, prefixs[0]+"ibflag")      = "I";
		        	
	     		}
     		}
     	}
     	
     	quitWaitImg(1);
     	sheetOrg.RemoveAll();
     	
     	
    }
     
    
    /**
     * Sheet2 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    var lockKey = true;
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.Enable = true;
    	ComBtnsEnable(true);
    	ComBtnEnable("btn_t2add");
    	ComBtnEnable("btn_t2insert");
    	ComBtnEnable("btn_t2copy");
    	ComBtnEnable("btn_t2delete");
    	ComBtnEnable("btn_mail");
    	ComBtnEnable("btn_t2downExcel");
    	
     	//조회된 건이 있을 경우에만 수행
     	if(sheetObj.RowCount != 0) {
     		lockKey = false;
 	    	var pol_cd, pod_cd, vsl_cd, skd_voy_no, skd_dir_cd, sts_cd;
 	    	with (sheetObj) {  
 	    		var seqNo = 0;
 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
 	    		
 	    		dupChkList = new Array();
 	    		var dupCt      = 0;
 	    		//for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
 	    		for (var checkRow = LastRow; checkRow >= HeaderRows; checkRow--) {
 	    			pol_cd = CellValue(checkRow, prefixs[1]+"pol_cd");
 	    			pod_cd = CellValue(checkRow, prefixs[1]+"pod_cd");
 	    			
 	    			vsl_cd = CellValue(checkRow, prefixs[1]+"vsl_cd");
 	    			skd_voy_no = CellValue(checkRow, prefixs[1]+"skd_voy_no");
 	    			skd_dir_cd = CellValue(checkRow, prefixs[1]+"skd_dir_cd");
	    				    			
 	    			//POL Combo 생성
 	    			if(searchPolCd(sheetObj, checkRow, vsl_cd, skd_voy_no, skd_dir_cd)) {    			
 	    				CellValue2(checkRow, prefixs[1]+"pol_cd") = pol_cd;
 	    			}
 	    			
 	    			//POD Combo 생성
 	    			searchPodCd(sheetObj, checkRow, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd);
 	    			CellValue2(checkRow, prefixs[1]+"pod_cd") = pod_cd;
 	    			
 	    			var sts_cd = parseFloat(CellValue(checkRow, prefixs[1]+"sts_ct"));
 	    			var auth_sts_cd = CellValue(checkRow, prefixs[1]+"auth_sts_cd");
 	    			
 	    			CellValue2(checkRow, prefixs[1]+"org_auth_sts_cd") = auth_sts_cd;
 	    			
 	    			if(auth_sts_cd == 'Y' || auth_sts_cd == 'N') { 	    				
 	    				for ( var checkCell = 0; checkCell <= LastCol; checkCell++) {
 	    					//2012.01.06 2) 'Y'인 경우도 선택하여 삭제가능하도록 del_chk 제외
 	    					//if(checkCell != SaveNameCol(prefixs[1]+"del_chk")) CellEditable(checkRow, checkCell) = false;
 	    					CellEditable(checkRow, checkCell) = false;
 	    					if(auth_sts_cd == 'Y' && checkCell == SaveNameCol(prefixs[1]+"del_chk")){
 	    						CellEditable(checkRow, checkCell) = true;
 	    					}
 	    				}
 	    				//RowHidden(checkRow) = true;	//Total Count와 Select Row 의 문제로 인하여 RowDelete로 대체
 	    			} else if(sts_cd < 0 && sts_cd != -999) {
 	    				for ( var checkCell = 0; checkCell < SaveNameCol(prefixs[1]+"del_chk"); checkCell++) {
 	    					if(SaveNameCol(prefixs[1]+"auth_sts_cd") != checkCell) CellEditable(checkRow, checkCell) = false;
 	    				}
 	    			}
 	    			CellEditable(checkRow, prefixs[1]+"cgo_rqst_dt") = false;
 	    			
 	    			setAuthStat(sheetObj, checkRow);
 	    			
 	    			rqstSeq1 = CellValue(checkRow, prefixs[1]+"spcl_cgo_rqst_seq");
 	    			if(rqstSeq1 != rqstSeq2) seqNo++;
 	    				
 	    			CellValue2(checkRow, prefixs[1]+"seqNo") = seqNo;
 	    			
 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			RowStatus(checkRow) = "R";
 	    			
 	    			if(RowHidden(checkRow)) {
 	    				var dupChkItems = new Array();
 	    				dupChkItems[0] = CellValue(checkRow, prefixs[1]+"cgo_opr_cd");
 	    				dupChkItems[0] = dupChkItems[0]+CellValue(checkRow, prefixs[1]+"bkg_ref_no");
 	    				dupChkItems[0] = dupChkItems[0]+CellValue(checkRow, prefixs[1]+"vsl_cd");
 	    				dupChkItems[0] = dupChkItems[0]+CellValue(checkRow, prefixs[1]+"skd_voy_no");
 	    				dupChkItems[0] = dupChkItems[0]+CellValue(checkRow, prefixs[1]+"skd_dir_cd");
 	    				dupChkItems[0] = dupChkItems[0]+CellValue(checkRow, prefixs[1]+"pol_cd");
 	    				dupChkItems[0] = dupChkItems[0]+CellValue(checkRow, prefixs[1]+"pod_cd");
 	    				dupChkItems[1] = CellText(checkRow, prefixs[1]+"spcl_cntr_seq");
 	    				
 	    				dupChkList[dupCt++] = dupChkItems;
 	    				RowDelete(checkRow, false);
 	    			}
 	    		}
 	    		
 	    		for (var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) { 	   
 	    			CellValue(checkRow, prefixs[1]+"seqNo") = parseInt(seqNo)+1-parseInt(CellValue(checkRow, prefixs[1]+"seqNo"));
 	    			RowStatus(checkRow) = "R";
 	    		}
 	    	}
 	    	lockKey = true;
 	    	
 	    	ComBtnEnable("btn_mail");
     	} else {
     		dupChkList = null;
     		
     		ComBtnDisable("btn_mail");
     	}
     	
     	quitWaitImg(1);
    }
    
    /**
     * t1sheet1 OnSelectMenu Event 처리
     * param : sheetObj ==> 시트오브젝트, sAction
     * 
     */
    function t1sheet1_OnSelectMenu(sheetObj, sAction){
   	 	var sColStr = sheetObj.GetSelectionCols("|");

   	 	//자바 스크립트 배열로 만들기
   	 	var arr = sColStr.split("|");

   	 	with(sheetObj) {
	    	switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				if (arr[i] != SaveNameCol(prefixs[0]+"seq")
    						&& arr[i] != SaveNameCol(prefixs[0]+"vsl_cd") 
	        				&& arr[i] != SaveNameCol(prefixs[0]+"skd_voy_no") 
	        				&& arr[i] != SaveNameCol(prefixs[0]+"skd_dir_cd") 
	        				&& arr[i] != SaveNameCol(prefixs[0]+"slan_cd")
	        				&& arr[i] != SaveNameCol(prefixs[0]+"apro_ref_no")) 
	    					ColHidden(arr[i]) = false;
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol; idx++) {
	        			if (idx != SaveNameCol(prefixs[0]+"seq") 
	        				&& idx != SaveNameCol(prefixs[0]+"vsl_cd") 
	        				&& idx != SaveNameCol(prefixs[0]+"skd_voy_no") 
	        				&& idx != SaveNameCol(prefixs[0]+"skd_dir_cd") 
	        				&& idx != SaveNameCol(prefixs[0]+"slan_cd") 
	        				&& idx != SaveNameCol(prefixs[0]+"apro_ref_no")
	        				&& idx <= SaveNameCol(prefixs[0]+"auth_dt")) {
	        				ColHidden(idx) = false;
	        			}
	        		}
	        		break;
	    	}
   	 	}    	 
    }
    
 	function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
 		with(sheetObj) {
	 		MouseToolTipText="";
	 		var Row = MouseRow;
	 		var Col = MouseCol;
	 		if (Row >= 2 && Col == SaveNameCol(prefixs[0]+"imdg_un_no") ) {
	 			if ( CellValue ( Row, prefixs[0]+"imdg_un_no" ) != '' && CellValue ( Row, prefixs[0]+"imdg_un_no_seq") != '') {
		 			MouseToolTipText = CellValue(Row, prefixs[0]+"prp_shp_nm" );
		 			ToolTipOption="balloon:true;width:320";
		 			MousePointer = "Hand";
	 			}
	 		}
 		}
 	}
  	
    
    /**
     * t2sheet1 OnSelectMenu Event 처리
     * param : sheetObj ==> 시트오브젝트, sAction
     * 
     */
    function t2sheet1_OnSelectMenu(sheetObj, sAction){
   	 	var sColStr = sheetObj.GetSelectionCols("|");

   	 	//자바 스크립트 배열로 만들기
   	 	var arr = sColStr.split("|");

   	 	with(sheetObj) {
	    	switch(sAction) {
	    		case "컬럼 삭제" :
	    			for (i=0; i<arr.length; i++) {
	    				ColHidden(arr[i]) = true;
	    			}
	        		break;
	    		case "컬럼 삭제 취소" :
	    			for (i=0; i<arr.length; i++) {
	    				if (arr[i] != SaveNameCol(prefixs[1]+"spcl_cgo_rqst_seq") 
	    					&& arr[i] != SaveNameCol(prefixs[1]+"vsl_cd") 
	    					&& arr[i] != SaveNameCol(prefixs[1]+"skd_voy_no") 
	    					&& arr[i] != SaveNameCol(prefixs[1]+"skd_dir_cd") 
	    					&& arr[i] != SaveNameCol(prefixs[1]+"slan_cd") 
	    					&& arr[i] != SaveNameCol(prefixs[1]+"crr_cd") 
	    					&& arr[i] != SaveNameCol(prefixs[1]+"seq")
	    					&& arr[i] != SaveNameCol(prefixs[1]+"apro_ref_no")) 
	    					ColHidden(arr[i]) = false;
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol; idx++) {
	        			if (idx != SaveNameCol(prefixs[1]+"spcl_cgo_rqst_seq") 
        					&& idx != SaveNameCol(prefixs[1]+"vsl_cd") 
	    					&& idx != SaveNameCol(prefixs[1]+"skd_voy_no") 
	    					&& idx != SaveNameCol(prefixs[1]+"skd_dir_cd") 
	    					&& idx != SaveNameCol(prefixs[1]+"slan_cd") 
	        				&& idx != SaveNameCol(prefixs[1]+"crr_cd") 
	        				&& idx != SaveNameCol(prefixs[1]+"seq") 
	        				&& idx != SaveNameCol(prefixs[1]+"apro_ref_no")
	        				&& idx <= SaveNameCol(prefixs[1]+"auth_dt")) {
	        				ColHidden(idx) = false;
	        			}
	        		}
	        		break;
	    	}
   	 	}    	 
    }
    
    /**
     * t1sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 NewRow ==> NewRow, 선택한 NewCol ==> NewCol
     * 
     */
    function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	with(sheetObj) {
	    	for(var i=HeaderRows; i<=LastRow; i++) {
	    		if(RowStatus(i) != 'I') RowBackColor(i)  = RgbColor(255, 255, 255);
	    		else RowBackColor(i) = RgbColor(192,192,192);
	    	}
	     	if(NewRow > 1) RowBackColor(NewRow) = RgbColor(231, 250, 246);
	     	
	     	if(RowCount != 0) ComBtnEnable("btn_details");
    	}
    }
    
    /**
     * t2sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 NewRow ==> NewRow, 선택한 NewCol ==> NewCol
     * 
     */
    function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	 with(sheetObj) {    		
 	    	for(var i=HeaderRows; i<=LastRow; i++) {
 	    		RowBackColor(i)  = RgbColor(255, 255, 255);
 	    	}
 	     	if(NewRow > 1) RowBackColor(NewRow)  = RgbColor(231, 250, 246);
 	     	
 	     	if(RowStatus(NewRow) == 'I') {
 	     		ComBtnDisable("btn_mail");
 	     	} else {
 	     		ComBtnEnable("btn_mail");
 	     	}
     	}
    }
    
     /**
      * t1sheet1 OnKeyUp Event 처리
      * param : sheetObj ==> 시트오브젝트, 
      * row ==> 선택전 Row, col ==> 선택전 Col, 
      * keyCode ==> NewRow, shift ==> NewCol
      * 
      */
      /*
     function t1sheet1_OnKeyDown ( sheetObj, row, col, keyCode, shift) {
	 	 with(sheetObj) {  
	 		 switch ( keyCode ) {
	 			  case 86:
	 				 if ( shift == 2 ) {
	 					 var dta = window.clipboardData.getData ( "Text" );
	 					 Paste2Column ( dta, "\t", "\r\n", "", "", SelectRow, 0 );
	 					 //alert ( "Ctrl+V" + dta );
	 				 }
	 				 break;
 		 	 }
 		 }
     } 
     */
     
      
     
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Received event from sheet of UI
    //////////////////////////////////////////////////////////////////////////////////////////         
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Initialize 
    //////////////////////////////////////////////////////////////////////////////////////////  
    
    // 업무 자바스크립트 OnKeyPress 이벤트 Catch
    function initControl() {
        // Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
        axon_event.addListenerForm 	 ('blur',     'obj_blur',       form);
        axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
        axon_event.addListener       ('keydown',  'ComKeyEnter',   'form');
        axon_event.addListenerForm   ('change',   'obj_change', 	form);
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

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        ComSetObjValue(document.form.tabSelectedIdx, "0");
        
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        rso_cd = document.form.u_rso.value ;
        //alert ( rso_cd );
        document.form.rgn_shp_opr_cd.Code = rso_cd;
        

    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
            	with (sheetObj) {

                    //높이 설정
                    style.height = 380;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);                   

                    var HeadTitle1 = "No.|VVD CD|VVD CD|VVD CD|Lane|BKG\nRef. No.|BKG\nCOMP|POL|POL";
                    HeadTitle1      += "|ETA|POD|POD||Sel.|APVL|APVL\nRef. No.|Sequence|Sequence|TPSZ";
                    HeadTitle1      += "|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|Segregation\nGroup|PKG Q\'ty/Type|PKG Q\'ty/Type|MP|PG|LQ|EQ|FP(℃)|Weight (kg)|Weight (kg)|Weight (kg)|PSA|RQST\nDT|APVL\nDT|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
                    

                    var HeadTitle2 = "No.| | | |Lane|BKG\nRef. No.|BKG\nCOMP|POL|POL";
                    HeadTitle2     += "|ETA|POD|POD||Sel.|APVL|APVL\nRef. No.|CNTR Q'ty|CGO|TPSZ";
                    HeadTitle2     += "|UN No.|UN No.Seq|Class|Sub\nrisks|Segregation\nGroup|PKG Q\'ty|PKG Type|MP|PG|LQ|EQ|FP(℃)|Gross|Net||PSA|RQST\nDT|APVL\nDT|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);
                    
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                  

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,     prefixs[0]+"seqNo");					
					
					InitDataProperty(0, cnt++ , dtHidden,      	35,    daCenter,  true,     prefixs[0]+"vsl_cd",     				false,          "",      dfNone,     0, false, false );
					InitDataProperty(0, cnt++ , dtHidden,      	35,    daCenter,  true,     prefixs[0]+"skd_voy_no",     			false,          "",      dfNone,     0, false, false );		
					InitDataProperty(0, cnt++ , dtHidden,      	17,    daCenter,  true,     prefixs[0]+"skd_dir_cd",     			false,          "",      dfNone,     0, false, false );
					InitDataProperty(0, cnt++ , dtHidden,      	35,    daCenter,  true,     prefixs[0]+"slan_cd",     			    false,          "",      dfNone,     0, false, false );
					
					InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,  true,     prefixs[0]+"bkg_ref_no",     			true,           "",      dfNone,     0, false, true, 30  );
					InitDataProperty(0, cnt++ , dtPopupEdit,    40,    daCenter,  true,     prefixs[0]+"cgo_opr_cd",    			true,           "",      dfNone,     0, true,  true, 3  );
					InitDataProperty(0, cnt++ , dtComboEdit,    55,    daCenter,  true,     prefixs[0]+"pol_cd",     				true,           "",      dfNone,     0, true,  true, 5  );							
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     prefixs[0]+"pol_clpt_ind_seq",          false,          "",      dfNone ,    0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     prefixs[0]+"eta_dt",     				false,          "",      dfDateYmd,  0, false, false, -1,  false, true, "", true, "IUD", true); // for paste insertedit true
					InitDataProperty(0, cnt++ , dtComboEdit,    55,    daCenter,  true,     prefixs[0]+"pod_cd",     				true,           "",      dfNone,     0, true,  true, 5  );							
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     prefixs[0]+"pod_clpt_ind_seq",          false,          "",      dfNone ,    0, true,  true, 2  );
					
					InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,	prefixs[0]+"seq",                       false,          prefixs[0]+"spcl_cgo_seq");
					InitDataProperty(0, cnt++ , dtCheckBox,     30,    daCenter,  true,     prefixs[0]+"del_chk");
					InitDataProperty(0, cnt++ , dtComboEdit,   	40,    daCenter,  true,     prefixs[0]+"auth_sts_cd",     			false,          "",      dfNone,      0, true,  true  );					
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     prefixs[0]+"apro_ref_no",     			false,          "",      dfNone,      0, false, false  ); 
					InitDataProperty(0, cnt++ , dtData,      	75,    daCenter,  true,     prefixs[0]+"spcl_cntr_seq",     		true,           "",      dfNone,      0, true,  true, 4  );
					InitDataProperty(0, cnt++ , dtData,      	45,    daCenter,  true,     prefixs[0]+"spcl_cgo_seq",    			true,           "",      dfNone,      0, true,  true, 12  );
					InitDataProperty(0, cnt++ , dtComboEdit,   	50,    daCenter,  true,     prefixs[0]+"cntr_tpsz_cd",     			true,           "",      dfNone,      0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,     prefixs[0]+"imdg_un_no",     			true,           "",      dfNone,      0, true,  true, 4  );
					InitDataProperty(0, cnt++ , dtComboEdit,   	30,    daCenter,  true,     prefixs[0]+"imdg_un_no_seq",     		true,           "",      dfNone,      0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     prefixs[0]+"imdg_clss_cd",     			false,          "",      dfNone,      0, false, false  ); 
					                                                                            
					InitDataProperty(0, cnt++ , dtData,      	75,    daCenter,  true,     prefixs[0]+"imdg_subs_rsk_lbl_cd", 		false,          "",      dfNone,      0, false, false ); 
					InitDataProperty(0, cnt++ , dtData,      	100,   daLeft,	  true,     prefixs[0]+"imdg_segr_grp_no", 			false,          "",      dfNone,      0, true, 	true, 100 );					
					InitDataProperty(0, cnt++ , dtHidden,      	45,    daRight,   true,     prefixs[0]+"out_n1st_imdg_pck_qty",     false,          "",      dfNone,      0, true,  true, 12  );
					InitDataProperty(0, cnt++ , dtHidden,      	45,    daCenter,  true,     prefixs[0]+"out_n1st_imdg_pck_cd",      false,          "",      dfNone,      0, true,  true, 5  );
					
					InitDataProperty(0, cnt++ , dtCombo,      	30,    daCenter,  true,     prefixs[0]+"mrn_polut_flg",     		false,          "",      dfNone,      0, true,  true );
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     prefixs[0]+"imdg_pck_grp_cd",     		false,          "",      dfNone,      0, false, false ); 
					InitDataProperty(0, cnt++ , dtCombo,      	30,    daCenter,  true,     prefixs[0]+"imdg_lmt_qty_flg",     		false,          "",      dfNone,      0, true,  true );
					InitDataProperty(0, cnt++ , dtCombo,      	30,    daCenter,  true,     prefixs[0]+"imdg_expt_qty_flg",    		false,          "",      dfNone,      0, true,  true ); 						
					InitDataProperty(0, cnt++ , dtData,      	45,    daRight,   true,     prefixs[0]+"flsh_pnt_cdo_temp", 	    false,          "",      dfNullFloat, 2, true,  true, 7 ); 
                                                                                                                    
					InitDataProperty(0, cnt++ , dtHidden,      	70,    daRight,   true,     prefixs[0]+"grs_wgt",     			  	false,          "",      dfNullFloat, 3, true,  true, 18);
					InitDataProperty(0, cnt++ , dtData,      	70,    daRight,   true,     prefixs[0]+"net_wgt",     				false,          "",      dfNullFloat, 3, true,  true, 18);
					InitDataProperty(0, cnt++ , dtHidden,      	70,    daRight,   true,     prefixs[0]+"grs_capa_qty", 				false,          "",      dfNullFloat, 3, false, false, 18);
					InitDataProperty(0, cnt++ , dtHidden,      	30,    daCenter,  true,     prefixs[0]+"psa_no",     				false,          "",      dfNone,      0, true,  true, 12 );
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     prefixs[0]+"cgo_rqst_dt",     			false,          "",      dfDateYmd,   0, false, false ); 
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     prefixs[0]+"auth_dt",     				false,          "",      dfNone,      0, false, false );
					
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,     prefixs[0]+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     prefixs[0]+"spcl_cgo_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"crr_cd");
					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"cntr_ref_no");
//					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"slan_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"wgt_ut_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"wgt_ut_cd2");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"prp_shp_nm");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"hzd_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"n1st_imdg_subs_rsk_lbl_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"n2nd_imdg_subs_rsk_lbl_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"n3rd_imdg_subs_rsk_lbl_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"n4th_imdg_subs_rsk_lbl_cd");
					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"dcgo_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"emer_cntc_phn_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"emer_cntc_pson_nm");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"certi_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"diff_rmk");
					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"out_n1st_imdg_pck_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"out_n2nd_imdg_pck_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"out_n2nd_imdg_pck_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"out_n2nd_imdg_pck_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"in_n1st_imdg_pck_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"in_n1st_imdg_pck_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"in_n1st_imdg_pck_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"in_n2nd_imdg_pck_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"in_n2nd_imdg_pck_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"in_n2nd_imdg_pck_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"intmd_n1st_imdg_pck_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"intmd_n1st_imdg_pck_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"intmd_n1st_imdg_pck_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"intmd_n2nd_imdg_pck_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"intmd_n2nd_imdg_pck_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"intmd_n2nd_imdg_pck_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"max_in_pck_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"max_in_pck_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"hcdg_pck_rstr_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"hcdg_intmd_bc_rstr_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"hcdg_tnk_rstr_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_lmt_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_expt_qty_cd");
					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"ems_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"ctrl_temp_ctnt");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"emer_rspn_gid_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"emer_rspn_gid_chr_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"emer_temp_ctnt");
					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"cnee_dtl_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"net_explo_wgt");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"rada_skd_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"rada_amt");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"rada_ut_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"rada_trsp_no");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"spcl_cgo_cate_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"auth_ofc_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"auth_usr_id");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_co_grp_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"meas_qty");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"meas_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"pck_qty" ); //, 	            false,          "",      dfNullFloat, 3, true,  true, 12  );
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"pck_tp_cd" ); //, 		        false,          "",      dfNone,      0, true,  true, 2  );
					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"clod_flg");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"spcl_stwg_rqst_desc");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"cgo_lcl_flg");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_lmt_qty_meas_ut_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_comp_grp_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"hcdg_flg");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_subs_rsk_lbl_rmk");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"imdg_spcl_provi_no");					
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"rgn_shp_opr_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[0]+"email_info");

					InitDataValid(0, prefixs[0]+"cgo_opr_cd",              vtEngUpOnly );
                    InitDataValid(0, prefixs[0]+"pol_cd",                  vtEngUpOther, "0123456789" );
                    
                    InitDataValid(0, prefixs[0]+"pod_cd",                  vtEngUpOther, "0123456789" );
                    
                    InitDataValid(0, prefixs[0]+"cntr_tpsz_cd",            vtEngUpOther, "0123456789" );
                    
                    InitDataValid(0, prefixs[0]+"imdg_un_no",              vtNumericOnly);
                    InitDataValid(0, prefixs[0]+"imdg_un_no_seq",          vtNumericOnly);
                    InitDataValid(0, prefixs[0]+"out_n1st_imdg_pck_qty",   vtNumericOnly);
                    InitDataValid(0, prefixs[0]+"out_n1st_imdg_pck_cd",    vtEngUpOther, "0123456789" );
                    InitDataValid(0, prefixs[0]+"psa_no",                  vtEngUpOther, "0123456789" );
                    InitDataValid(0, prefixs[0]+"imdg_segr_grp_no", 	   vtEngOther, 	 "0123456789");
       			
                    HeadRowHeight = 20;
					
					SetMergeCell(0, 1, 2, 3);
					SetMergeCell(0, 7, 2, 2);	    //POL
                    SetMergeCell(0, 10, 2, 2);	//POD
					SetMergeCell(0, 19, 2, 2);
					SetMergeCell(0, 24, 2, 2);
					
					EditableColorDiff = false;
					MultiSelection    = true;
					
					//SelectionMode     = smSelectionFree;
					//ClipPasteMode     = 1;

                    InitDataCombo(0,   prefixs[0]+"auth_sts_cd", "R|Y|Y(All)|N", "R|Y|A|N");
                    InitDataCombo(0,   prefixs[0]+"mrn_polut_flg", "Y|N", "Y|N");
                    InitDataCombo(0,   prefixs[0]+"imdg_lmt_qty_flg", "Y|N", "Y|N");
                    InitDataCombo(0,   prefixs[0]+"imdg_expt_qty_flg", "Y|N", "Y|N");
					
					ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
                break;

            case 2:      //t2sheet1 init
                with (sheetObj) {

                    //높이 설정
                    style.height = 380;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "No.||VVD CD|VVD CD|VVD CD|Lane||BKG\nRef. No.|BKG\nCOMP|POL|POL";
                    HeadTitle1      += "|ETA|POD|POD||Sel.|APVL|APVL\nRef. No.|Seq.\n(CNTR Q'ty)|TPSZ|Commodity";
                    HeadTitle1      += "|Over All(cm)|Over All(cm)|Over All(cm)|Over Dimension(cm)|Over Dimension(cm)|Over Dimension(cm)|Over Dimension(cm)|Over Dimension(cm)|Gross\nWeight(kg)|Void\n(FEU)|RQST\nDT|APVL\nDT|||||";

                    var HeadTitle2 = "No.|| | | |Lane||BKG\nRef. No.|BKG\nCOMP|POL|POL";
                    HeadTitle2     += "|ETA|POD|POD||Sel.|APVL|APVL\nRef. No.|Seq.\n(CNTR Q'ty)|TPSZ|Commodity";
                    HeadTitle2     += "|L|W|H|FWD|AFT|Left|Right|Height|Gross\nWeight(kg)|Void\n(FEU)|RQST\nDT|APVL\nDT|||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 19, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    cnt = 0;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,     prefixs[1]+"seqNo");	
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     prefixs[1]+"spcl_cgo_rqst_seq");
                    InitDataProperty(0, cnt++ , dtHidden,      	35,    daCenter,  true,     prefixs[1]+"vsl_cd",     			true,           "",      dfNone, 			0,    false,      true,	4, false, false);
					InitDataProperty(0, cnt++ , dtHidden,      	35,    daCenter,  true,     prefixs[1]+"skd_voy_no",     		true,           "",      dfNone, 			0,    false,      true,	4, false, false);
					InitDataProperty(0, cnt++ , dtHidden,       35,    daCenter,  true,     prefixs[1]+"skd_dir_cd",     		true,           "",      dfNone, 			0,    false,      true,	1, false, false);
					InitDataProperty(0, cnt++ , dtHidden,      	35,    daCenter,  true,     prefixs[1]+"slan_cd",     			false,          "",      dfNone, 			0,    false,      false,3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,      	0,     daCenter,  true,     prefixs[1]+"crr_cd");
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     prefixs[1]+"bkg_ref_no",     		true,           "",      dfNone, 			0,    false,      true,	30, false, false);
					
					InitDataProperty(0, cnt++ , dtPopupEdit,    55,    daLeft,    true,     prefixs[1]+"cgo_opr_cd",     	    true,           "",      dfNone, 			0,    true,       true,	4, false, false);
					InitDataProperty(0, cnt++ , dtComboEdit,    55,    daCenter,  true,     prefixs[1]+"pol_cd",     			true,           "",      dfNone, 			0,    true,       true,	5, false, false);
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     prefixs[1]+"pol_clpt_ind_seq",      false,          "",      dfNone ,    		0, 	  true,  	  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     prefixs[1]+"eta_dt",     			false,          "",      dfNone, 			0,    false,      false,-1, false, false);
                    InitDataProperty(0, cnt++ , dtComboEdit,    55,    daCenter,  true,     prefixs[1]+"pod_cd",     			true,           "",      dfNone, 			0,    true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     prefixs[1]+"pod_clpt_ind_seq",      false,          "",      dfNone ,    		0, 	  true,  	  true, 2  );
                    
                    InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,	prefixs[1]+"seq",                   false,          prefixs[1]+"spcl_cntr_seq");
                    InitDataProperty(0, cnt++ , dtCheckBox,    	30,    daCenter,  true,     prefixs[1]+"del_chk");
                    InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenter,  true,     prefixs[1]+"auth_sts_cd",     		false,          "",      dfNone );
                    InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     prefixs[1]+"apro_ref_no",     		false,          "",      dfNone, 	        0,    false,      false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	85,    daCenter,  true,     prefixs[1]+"spcl_cntr_seq",    	    true,           "",      dfNullInteger, 	0,    false,      true,4, false, false);
                    InitDataProperty(0, cnt++ , dtComboEdit,    55,    daCenter,  true,     prefixs[1]+"cntr_tpsz_cd",     		true,           "",      dfNone, 			0,    true,       true,	4, false, false);
                    InitDataProperty(0, cnt++ , dtData,     	80,    daLeft,    true,     prefixs[1]+"cmdt_desc",     		false,          "",      dfNone, 			0,    true,       true,	4000, false, false);
                                                                                            
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"ttl_dim_len",     		false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"ttl_dim_wdt",     		false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"ttl_dim_hgt",     		false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"fwrd_ovr_dim_len",		false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"bkwd_ovr_dim_len",     	false,          "",      dfNullInteger, 		0,     true,       true,	7, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"lf_sd_ovr_dim_len",    	false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"rt_sd_ovr_dim_len",		false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,     prefixs[1]+"hgt_ovr_dim_len",     	false,          "",      dfNullInteger, 		0,     true,       true,	5, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	85,    daRight,   true,     prefixs[1]+"grs_wgt",     			true,           "",      dfNullFloat, 			3,     true,       true,	18, false, false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daRight,   true,     prefixs[1]+"void_slt_qty",     		false,          "",      dfNullFloat, 			1,     true,       true,	9, false, false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,    80,    daLeft,    true,     prefixs[1]+"cgo_rqst_dt",     		false,          "",      dfDateYmd );
                    InitDataProperty(0, cnt++ , dtPopupEdit,    80,    daLeft,    true,     prefixs[1]+"auth_dt",     			false,          "",      dfNone );
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,     prefixs[1]+"ibflag");					
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     prefixs[1]+"spcl_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     prefixs[1]+"sts_ct");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     prefixs[1]+"org_auth_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     prefixs[1]+"email_info");
                    
                    InitDataValid(0, prefixs[1]+"vsl_cd",     vtEngUpOnly);
                    InitDataValid(0, prefixs[1]+"skd_voy_no", vtNumericOnly);
                    InitDataValid(0, prefixs[1]+"skd_dir_cd", vtEngUpOnly);
                    
                    InitDataValid(0, prefixs[1]+"cgo_opr_cd", vtEngUpOnly);
                    
                    InitDataValid(0, prefixs[1]+"pol_cd",     vtEngUpOther, "0123456789" );
                    InitDataValid(0, prefixs[1]+"pol_cd",     vtEngUpOther, "0123456789" );
                    
                    SetMergeCell(0, 9, 1, 2);	//POL
                    SetMergeCell(0, 12, 1, 2);	//POD
                    
                    HeadRowHeight = 20;
                    SetMergeCell(0, 2, 2, 3);

					ImageList(0) = "img/btns_calendar.gif";

                    PopupButtonImage(0, prefixs[1]+"cgo_rqst_dt") = 0;
                    PopupButtonImage(0, prefixs[1]+"auth_dt") = 0;		
                    
                    EditableColorDiff = false;

                    InitDataCombo(0,   prefixs[1]+"auth_sts_cd", "R|Y|N", "R|Y|N");

					ShowButtonImage = 1;
					
					ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
                break;
            case 3:      // t0sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    var HeadTitle = "flg|vsl_opr_tp|bkg_ref_no|spcl_cgo_rqst_seq|vsl_cd|skd_voy_no|skd_dir_cd|slan_cd|rgn_shp_opr_cd|pol_cd|pod_cd|eta_dt|dg_flg|awk_flg";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"ibflag");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"vsl_opr_tp");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"bkg_ref_no");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"spcl_cgo_rqst_seq");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"vsl_cd");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"skd_voy_no");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"skd_dir_cd");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"slan_cd");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"rgn_shp_opr_cd");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"pol_cd");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"pod_cd");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"eta_dt");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"dg_flg");
                    InitDataProperty(0, cnt++, dtData, 10, daCenter, false, prefixs[2]+"awk_flg");
			   }
			   break;
            case 4:      //t3sheet1 init
            	with (sheetObj) {

                    //높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);                   

                    var HeadTitle1 = "No.|BKG\nRef. No.|BKG\nCOMP|POL|POL";
                    HeadTitle1      += "|ETA|POD|POD|Sel.|APVL|APVL\nRef. No.|Sequence|Sequence|TPSZ";
                    HeadTitle1      += "|UN No.\n/Seq.|UN No.\n/Seq.|Class|Sub\nrisks|PKG Q\'ty/Type|PKG Q\'ty/Type|MP|PG|LQ|EQ|FP(℃)|Weight (kg)|Weight (kg)|PSA|RQST\nDT|APVL\nDT";
                    

                    var HeadTitle2 = "No.|BKG\nRef. No.|BKG\nCOMP|POL|POL";
                    HeadTitle2     += "|ETA|POD|POD|Sel.|APVL|APVL\nRef. No.|CNTR|CGO|TPSZ";
                    HeadTitle2     += "|UN No.|UN No.Seq|Class|Sub\nrisks|PKG Q\'ty|PKG Type|MP|PG|LQ|EQ|FP(℃)|Gross|Net|PSA|RQST\nDT|APVL\nDT";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,     "seqNo");					
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     "bkg_ref_no",     			true,           "",      dfNone,     0, false, true, 30  );
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,     "cgo_opr_cd",    			true,           "",      dfNone,     0, true,  true, 3  );
					InitDataProperty(0, cnt++ , dtData,         55,    daCenter,  true,     "pol_cd",     				true,           "",      dfNone,     0, true,  true, 5  );							
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     "pol_clpt_ind_seq",         false,          "",      dfNone ,    0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     "eta_dt",     				false,          "",      dfDateYmd,  0, false, false, -1,  false, true, "", true, "IUD", true);
					InitDataProperty(0, cnt++ , dtData,         55,    daCenter,  true,     "pod_cd",     				true,           "",      dfNone,     0, true,  true, 5  );							
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     "pod_clpt_ind_seq",         false,          "",      dfNone ,    0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,     "del_chk");
					InitDataProperty(0, cnt++ , dtData,   	    40,    daCenter,  true,     "auth_sts_cd",     			false,          "",      dfNone,      0, true,  true  );					
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     "apro_ref_no",     			false,          "",      dfNone,      0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,     "spcl_cntr_seq",     		true,           "",      dfNone,      0, true,  true  );
					InitDataProperty(0, cnt++ , dtData,      	45,    daCenter,  true,     "spcl_cgo_seq",    			true,           "",      dfNone,      0, true,  true  );
					InitDataProperty(0, cnt++ , dtData,   	    50,    daCenter,  true,     "cntr_tpsz_cd",     		true,           "",      dfNone,      0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,     "imdg_un_no",     			true,           "",      dfNone,      0, true,  true, 4  );
					InitDataProperty(0, cnt++ , dtData,   	    30,    daCenter,  true,     "imdg_un_no_seq",     		true,           "",      dfNone,      0, true,  true, 2  );
					InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "imdg_clss_cd",     		false,          "",      dfNone,      0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	75,    daCenter,  true,     "imdg_subs_rsk_lbl_cd", 	false,          "",      dfNone,      0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	45,    daRight,   true,     "out_n1st_imdg_pck_qty",    false,          "",      dfNone,      0, true,  true, 12  );
					InitDataProperty(0, cnt++ , dtData,      	45,    daCenter,  true,     "out_n1st_imdg_pck_cd",     false,          "",      dfNone,      0, true,  true, 5  );
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "mrn_polut_flg",     		false,          "",      dfNone,      0, true,  true );
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "imdg_pck_grp_cd",     		false,          "",      dfNone,      0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "imdg_lmt_qty_flg",     	false,          "",      dfNone,      0, true,  true );
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "imdg_expt_qty_flg",    	false,          "",      dfNone,      0, false, false );						
					InitDataProperty(0, cnt++ , dtData,      	45,    daRight,   true,     "flsh_pnt_cdo_temp", 	    false,          "",      dfNone,      0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	70,    daRight,   true,     "grs_wgt",     			  	false,          "",      dfNullFloat, 3, true,  true, 18);
					InitDataProperty(0, cnt++ , dtData,      	70,    daRight,   true,     "net_wgt",     				false,          "",      dfNullFloat, 3, true,  true, 18);
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "psa_no",     				false,          "",      dfNone,      0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     "cgo_rqst_dt",     			false,          "",      dfDateYmd,   0, false, false );
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     "auth_dt",     				false,          "",      dfDateYmd,   0, false, false );
										
                }
                break;

			   
        }
    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "DG" , -1 );
                    InsertTab( cnt++ , "Awkward" , -1 );

                }
             break;

         }
    }
    
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	 switch(comboObj.id) {
   	  		case "rgn_shp_opr_cd":  
   	  			with(comboObj) {
   	  				SetColAlign("center|left");
   	  				SetColWidth("50|150");
   	  				SetTitle("Code|Description");
   	  				DropHeight = 200;
  	         	}
   	  			break;  
   	  	}
    }
     
    /**
     * Tab1 초기화
     */
    function resetTab1(sheetObj) {
    	sheetObj.Enable = false;
     	ComBtnDisable("btn_details");
     	ComBtnDisable("btn_t1add");
     	ComBtnDisable("btn_t1copy");
     	ComBtnDisable("btn_t1delete");
     	ComBtnDisable("btn_t1downExcel");
     	ComBtnDisable("btn_t1loadExcel");
     	
    }
     
    /**
     * Tab2 초기화
     */
    function resetTab2(sheetObj) {
    	sheetObj.Enable = false;
    	ComBtnDisable("btn_t2add");
    	ComBtnDisable("btn_t2insert");
    	ComBtnDisable("btn_t2copy");
    	ComBtnDisable("btn_t2delete");
    	ComBtnDisable("btn_mail");
    	ComBtnDisable("btn_t2downExcel");
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Initialize 
    //////////////////////////////////////////////////////////////////////////////////////////     
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Set&Getter 
    ////////////////////////////////////////////////////////////////////////////////////////// 

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
    
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Vessel Name 셋팅
     */
    function setVslEngNm(formObj, sXml) { 	 
    	var vsl_eng_nm = ComScgXml2Array(sXml, "vsl_eng_nm");
    	var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd");
    	var vsl_slan_nm = ComScgXml2Array(sXml, "vsl_slan_nm");
    	var crr_cd = ComScgXml2Array(sXml, "vsl_opr_tp_cd");
    	
 	   	if(vsl_eng_nm == null) {
 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    
 		    ComSetObjValue(formObj.vsl_eng_nm, "");
 		    ComSetObjValue(formObj.skd_dir_cd, "");
 		    ComSetObjValue(formObj.skd_voy_no, "");
 		    ComSetObjValue(formObj.vsl_cd, "");
 		    ComSetObjValue(formObj.crr_cd, "");
 		    ComSetObjValue(formObj.slan_cd, "");
 		    ComSetObjValue(formObj.slan_nm, "");
 		    
 		    ComSetFocus(formObj.vsl_cd);
 	   	} else {
 	   		ComSetObjValue(formObj.vsl_eng_nm, vsl_eng_nm);
 	   		
 	   		ComSetObjValue(formObj.crr_cd, crr_cd);
 	   		ComSetObjValue(formObj.slan_cd, vsl_slan_cd);
 	   		ComSetObjValue(formObj.slan_nm, vsl_slan_nm);
 	   		
 	   		ComSetFocus(formObj.btn_retrive);
 	   	}
    }
    
    /**
     * Vessel Lane 셋팅
     */
    function setVslLane(sheetObj, sXml, Row) { 	
    	var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd");
    	var crr_cd = ComScgXml2Array(sXml, "vsl_opr_tp_cd");    	
    	
 	   	if(vsl_slan_cd == null) {
 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   		
 	   		sheetObj.CellValue2(Row, prefixs[1]+"skd_dir_cd") = "";
 	   		sheetObj.CellValue2(Row, prefixs[1]+"skd_voy_no") = "";
 	   		sheetObj.CellValue2(Row, prefixs[1]+"vsl_cd") = "";
 	   		
 	   		sheetObj.CellValue2(Row, prefixs[1]+"slan_cd") = "";
 	   		sheetObj.CellValue2(Row, prefixs[1]+"crr_cd") = "";
 		    
 	   		sheetObj.SelectCell(Row, prefixs[1]+"vsl_cd");
 	   	} else {
 	   		sheetObj.CellValue2(Row, prefixs[1]+"slan_cd") = vsl_slan_cd;
 	   		sheetObj.CellValue2(Row, prefixs[1]+"crr_cd") = crr_cd;
 	   	}
    }
    
    /**
  	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(rtnObjs) {
  		var formObj = document.form;
  		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
					ComSetObjValue(formObj.vsl_eng_nm, rtnDatas[2]);
					
					ComSetFocus(formObj.skd_voy_no);
				}
			}
    	}
  	} 
  	
    /**
  	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(obj) {
  		var formObj = document.form;
  		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
				}
			}
    	}
  	}
  	
  	/**
  	 * (Sheet용)VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setSheetCallBackVSL(rtnObjs, Row, Col, sheetNo) {
  		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObjects[sheetNo].CellValue2(Row, prefixs[1]+"vsl_cd") = rtnDatas[1];
				}
			}
    	}
  	} 
  	
    /**
  	 * (Sheet용)VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} obj
  	 */
  	function setSheetCallBackVVD(obj, Row, Col, sheetNo) {
  		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObjects[sheetNo].CellValue2(Row, prefixs[1]+"skd_voy_no") = rtnDatas[2];
					sheetObjects[sheetNo].CellValue2(Row, prefixs[1]+"skd_dir_cd") = rtnDatas[3];
					
					searchVVDRelInfo(rtnDatas[1], rtnDatas[2], rtnDatas[3], "t2Sheet1", Row);	//Vessell Lane 조회
				}
			}
    	}
  	}
  	
  	/**
  	 * (Sheet용)Carrier Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} obj
  	 */
    function setSheetCallBackOPR(obj, Row, Col, sheetNo) {
 		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObjects[sheetNo].CellValue2(Row, prefixs[sheetNo]+"cgo_opr_cd") = rtnDatas[3];
					
					//수정일 경우 Merge Cell Sync
					setSyncValMerge(sheetObjects[sheetNo], Row, Col, rtnDatas[3]);
				}
			}
 		}
    }
    
    /**
  	 * (Sheet용)POL Combo 구성<br>
  	 * @param sXml
  	 */
    function setPolCombo(sheetObj, Row, sXml) {
    	//alert ( "setPolCombo" );
    	var arrCombo = ComXml2ComboString(sXml, "loc_cd", "loc_nm");
    	
    	var idx = 0;    	
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
    	if(arrCombo != null && arrCombo.length > 0) {
    		var loc_cds        = ComScgXml2Array(sXml, "loc_cd");
    		var clptIndSeqs    = ComScgXml2Array(sXml, "clpt_ind_seq");
    		var turnPortIndCds = ComScgXml2Array(sXml, "turn_port_ind_cd");
    		var skdCngStsCd    = ComScgXml2Array(sXml, "skd_cng_sts_cd");
    		var polCdCombo = new Array();
    		var polTxCombo = new Array();
    		
    		var newPolIdx = 0;
    		for(var arrIdx=0; arrIdx<loc_cds.length; arrIdx++) {
    			if(loc_cds[arrIdx] != null && loc_cds[arrIdx] != '') {
	    			if(turnPortIndCds[arrIdx] != 'D' && turnPortIndCds[arrIdx] != 'V' && turnPortIndCds[arrIdx] != 'F') {
	    				if(skdCngStsCd[arrIdx] != 'S') {
	    					polCdCombo[newPolIdx] = loc_cds[arrIdx]+""+clptIndSeqs[arrIdx];
	    					if ( idx == 0 )
	    						polTxCombo[newPolIdx++] = loc_cds[arrIdx]+"\t"+clptIndSeqs[arrIdx];
	    					else
	    						polTxCombo[newPolIdx++] = loc_cds[arrIdx]+"\t"+clptIndSeqs[arrIdx];
	    				} else {
	    					polCdCombo[newPolIdx] = " ";
	    					polTxCombo[newPolIdx++] = " ";
	    				}
	    			}
    			}
    		}
    		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[idx]+"pol_cd"), "| |"+polTxCombo.join("|"), "| |"+polCdCombo.join("|"), 0);
    	} else {
    		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[idx]+"pol_cd"), "", "", 0);
    		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[idx]+"pod_cd"), "", "", 0);
    		
    		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[idx]+"pol_cd")) = "";
    		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[idx]+"pod_cd")) = "";
    		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[idx]+"eta_dt")) = "";
    	}
    	//sXml = "";
    	return true;
    }
  	 
  	/**
   	 * (Sheet용)POD Combo 구성<br>
   	 * @param sXml
   	 */
    function setPodCombo(sheetObj, Row, sXml, polCd) {
    	
     	var arrCombo = ComXml2ComboString(sXml, "loc_cd", "loc_nm");
     	
     	var idx = 0;     	
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
     	if(arrCombo != null && arrCombo.length > 0 && polCd != "") {
     		var loc_cds     = ComScgXml2Array(sXml, "loc_cd");
     		var clptIndSeqs = ComScgXml2Array(sXml, "clpt_ind_seq");
     		var clptSeqs    = ComScgXml2Array(sXml, "clpt_seq");
     		var skdCngStsCd = ComScgXml2Array(sXml, "skd_cng_sts_cd");
     		
     		var podCdCombo = new Array();
     		var podTxCombo = new Array();
     		
     		var polClptSeq = "0";
     		var newPodIdx = 0;
     		for(var arrIdx1=0; arrIdx1<loc_cds.length; arrIdx1++) {
     			if(loc_cds[arrIdx1]+""+clptIndSeqs[arrIdx1] == polCd) polClptSeq = clptSeqs[arrIdx1];
     		}
     		for(var arrIdx2=0; arrIdx2<loc_cds.length; arrIdx2++) {
     			if(loc_cds[arrIdx2] != null && loc_cds[arrIdx2] != '') {
     				if(parseInt(clptSeqs[arrIdx2]) > parseInt(polClptSeq)) {
     					if(skdCngStsCd[arrIdx2] != 'S') {
     						podCdCombo[newPodIdx] = loc_cds[arrIdx2]+""+clptIndSeqs[arrIdx2];
     						if ( idx == 0 )
     							podTxCombo[newPodIdx++] = loc_cds[arrIdx2]+"\t"+clptIndSeqs[arrIdx2];
     						else 
     							podTxCombo[newPodIdx++] = loc_cds[arrIdx2]+"\t"+clptIndSeqs[arrIdx2];
     					} else {
     						podCdCombo[newPodIdx] = " ";
     						podTxCombo[newPodIdx++] = " ";
	    				}
 	    			}
     			}
     		}
     		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[idx]+"pod_cd"), "| |"+podTxCombo.join("|"), "| |"+podCdCombo.join("|"), 0);
     	} else {
     		sheetObj.CellComboItem(Row, sheetObj.SaveNameCol(prefixs[idx]+"pod_cd"), "", "", 0);     		
     		sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[idx]+"pod_cd")) = "";
     	}
     	//sXml = "";
    }
    
    /**
  	 * (Sheet용)ETA 셋팅<br>
  	 * @param sXml
  	 */
    function setETADt(sheetObj, Row, sXml) {
    	var etaDt = ComScgXml2Array(sXml, "vps_eta_dt");
    	
     	var idx = 0;     	
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
    	sheetObj.CellValue2(Row, sheetObj.SaveNameCol(prefixs[idx]+"eta_dt")) = etaDt;
    	
    	//수정일 경우 Merge Cell Sync
		setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[idx]+"eta_dt"), etaDt);
    }
    
    /**
  	 * (Sheet용)TPSZ Combo 구성<br>
  	 * @param sXml
  	 */
    function setTPSZCombo(sheetObj, sXml) {
    	var arrCombo = ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
    	
     	var idx = 0;     	
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObj.InitDataCombo(0, prefixs[idx]+"cntr_tpsz_cd", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");
    }

    /**
  	 * (Sheet용)IMDG UN NO Seq Combo 구성<br>
  	 * @param sXml
  	 */
    function setImdgUnNoSeqCombo(sheetObj, Row, sXml) {
    	var arrCombo = ComXml2ComboString(sXml, "imdg_un_no_seq", "imdg_un_no_seq");
    	
     	var idx = 0;     	
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
    	if(arrCombo != null && arrCombo.length > 0) {
			sheetObj.CellComboItem(Row, prefixs[idx]+"imdg_un_no_seq", "| |"+arrCombo[0], "| |"+arrCombo[1], 0);
		}
		
		if ( sheetObj.CellValue(Row, prefixs[idx]+"ibflag" )  != "R" ) {
			sheetObj.CellValue2(Row, prefixs[idx]+"imdg_un_no_seq" ) = " ";
			sheetObj.CellValue2(Row, prefixs[idx]+"imdg_pck_grp_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"imdg_clss_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"imdg_subs_rsk_lbl_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"n4th_imdg_subs_rsk_lbl_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"n3rd_imdg_subs_rsk_lbl_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"n2nd_imdg_subs_rsk_lbl_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"n1st_imdg_subs_rsk_lbl_cd" ) = "";
			sheetObj.CellValue2(Row, prefixs[idx]+"prp_shp_nm" ) = "";
			
		}
		
    }
  	
    
  	/**
   	 * Aproval Combo 색상지정
   	 */
  	function setAuthStat(sheetObj, Row) {
    	with(sheetObj) {    		    		
    		var sheetIdx = 0;    		
    		if(id == 't2sheet1') sheetIdx = 1;

    		var authStsCd = CellValue(Row, prefixs[sheetIdx]+"auth_sts_cd");
    		
    		var authStsColor = RgbColor(255, 134, 43);
    		CellFont("FontBold", Row, prefixs[sheetIdx]+"auth_sts_cd") = true;
			switch(authStsCd) {
				case "Y":
					authStsColor = RgbColor(77, 150, 75);
					break;					
				case "N":
					authStsColor = RgbColor(255, 0, 0);
					break;					
				case "P":
					authStsColor = RgbColor(38, 99, 224);
					break;
			}
			CellFontColor(Row, prefixs[sheetIdx]+"auth_sts_cd") = authStsColor;
    	}    	
    }
  	
  	/**
   	 * Application Details Setter
   	 */
  	var detailXml;
  	function setAppDetlObj(sheetObj, row) {
  		//선택된 행이 없거나 단순 추가된 행일 경우
  		if(sheetObj == null || sheetObj.CellValue(row, prefixs[0]+"cgo_opr_cd") == '') {
  			detailXml = null;
  		} else {
  			detailXml = makeSearchXml(sheetObj, row);
  		}
  	}
  	
  	/**
   	 * Application Details Getter
   	 */
  	function getAppDetlObj() {
  		return detailXml;
  	}
   	 
   	/**
	 * Synchronize with close merge cell 
	 */
   	function setSyncValMerge(sheetObj, Row, Col, Value) {
   		//alert("setSyncValMerge");
		sheetObj.Redraw = false;
		
     	var idx = 0;     	
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
		
		with(sheetObj) {
			var status = RowStatus(Row);
    		var selFlg;
    		if(status == 'U') {
    			//ComOpenWait(true, false);	//화면 깜박임 발생으로 삭제처리
		    	for(var selIdx=Row+1; selIdx<=LastRow; selIdx++) {
		    		selFlg = false;
		    		if(CellValue(Row, prefixs[idx]+"bkg_ref_no") == CellValue(selIdx, prefixs[idx]+"bkg_ref_no") 
		    		   && CellValue(Row, prefixs[idx]+"spcl_cgo_rqst_seq") == CellValue(selIdx, prefixs[idx]+"spcl_cgo_rqst_seq") 
		    		   && (RowStatus(selIdx) == 'U' || RowStatus(selIdx) == 'R')) {
	    				selFlg = true; 
	    			} else if(RowStatus(selIdx) != 'I' && RowStatus(selIdx) != 'D') {
	    				selIdx = LastRow;
	    			}
		    		if(selFlg) {
		    			CellValue2(selIdx, Col) = Value;
		    			if(Col == SaveNameCol(prefixs[idx]+"pol_cd")) {
		    				searchPodCd(sheetObj, selIdx, CellValue(selIdx, prefixs[idx]+"vsl_cd"), CellValue(selIdx, prefixs[idx]+"skd_voy_no"), CellValue(selIdx, prefixs[idx]+"skd_dir_cd"), Value);
		    			}		    			
		    		}
		    	}
		    	for(var selIdx=Row-1; selIdx>=HeaderRows; selIdx--) {
		    		selFlg = false;
		    		if(CellValue(Row, prefixs[idx]+"bkg_ref_no") == CellValue(selIdx, prefixs[idx]+"bkg_ref_no") 
				       && CellValue(Row, prefixs[idx]+"spcl_cgo_rqst_seq") == CellValue(selIdx, prefixs[idx]+"spcl_cgo_rqst_seq") 
				       && (RowStatus(selIdx) == 'U' || RowStatus(selIdx) == 'R')) {
	    				selFlg = true; 
	    			} else if(RowStatus(selIdx) != 'I' && RowStatus(selIdx) != 'D') {
	    				selIdx = HeaderRows;
	    			}
		    		if(selFlg) {
		    			CellValue2(selIdx, Col) = Value;
		    			if(Col == SaveNameCol(prefixs[idx]+"pol_cd")) {
		    				searchPodCd(sheetObj, selIdx, CellValue(selIdx, prefixs[idx]+"vsl_cd"), CellValue(selIdx, prefixs[idx]+"skd_voy_no"), CellValue(selIdx, prefixs[idx]+"skd_dir_cd"), Value);
		    			}
		    		}
		    	}
		    	//ComOpenWait(false);
    		}
    	}
		sheetObj.Redraw = true;   
		
		return true;
   	}
	 
	/**
   	 * Application Details Getter
   	 */
  	function setRqstSeq(sheetObj) {
  		var ibflag, aproNo, aproStatus, rqstSeq;
    	var sVal1;
    	var sVal2;
    	var idx = 0;
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
		for(var rowIdx1=sheetObj.HeaderRows; rowIdx1<=sheetObj.LastRow; rowIdx1++) {
    		ibflag = sheetObj.RowStatus(rowIdx1);	
    		
    		sVal1  = sheetObj.CellValue(rowIdx1, prefixs[idx]+"cgo_opr_cd");
    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"bkg_ref_no");
    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"vsl_cd");
    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"skd_voy_no");
    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"skd_dir_cd");
    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"pol_cd");
    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"pod_cd");
    		
			if(ibflag != 'D' && ibflag == 'I'  && sVal1 != '') {				
	    		for(var rowIdx2=sheetObj.HeaderRows; rowIdx2<=sheetObj.LastRow; rowIdx2++) {
	    			if(rowIdx1 != rowIdx2) {
		    			ibflag  = sheetObj.RowStatus(rowIdx2);	
		    			aproNo  = sheetObj.CellValue(rowIdx2, prefixs[idx]+"apro_ref_no");
		    			aproStatus = sheetObj.CellValue(rowIdx2, prefixs[idx]+"org_auth_sts_cd");
		    			rqstSeq = sheetObj.CellValue(rowIdx2, prefixs[idx]+"spcl_cntr_seq");
		    			
		    			sVal2   = sheetObj.CellValue(rowIdx2, prefixs[idx]+"cgo_opr_cd");
			    		sVal2  += sheetObj.CellValue(rowIdx2, prefixs[idx]+"bkg_ref_no");
		    			sVal2  += sheetObj.CellValue(rowIdx2, prefixs[idx]+"vsl_cd");
		    			sVal2  += sheetObj.CellValue(rowIdx2, prefixs[idx]+"skd_voy_no");
		    			sVal2  += sheetObj.CellValue(rowIdx2, prefixs[idx]+"skd_dir_cd");
		    			sVal2  += sheetObj.CellValue(rowIdx2, prefixs[idx]+"pol_cd");
		    			sVal2  += sheetObj.CellValue(rowIdx2, prefixs[idx]+"pod_cd");
		    			
						if(ibflag != 'D' && ((ibflag == 'R' || ibflag == 'U') && aproStatus == 'R') && sVal2 != '') {
			    			if(sVal1 == sVal2) {
			    				sheetObj.CellText(rowIdx1, prefixs[idx]+"spcl_cgo_rqst_seq") = sheetObj.CellValue(rowIdx2, prefixs[idx]+"spcl_cgo_rqst_seq");
			    			}
			    		}
	    			}
				}
			}
    	}
		
		return true;
  	}
   	 
   	/**
	 * Http Param Getter
	 */
    function getSaveParam(sheetObj, formObj, tabIdx) {
     	var dgFlg = "Y", awkFlg = "Y";
 		
 		if(tabIdx == '0') {
 			
// 			var iRowStr = sheetObj.FindStatusRow("I");					
// 			var iRows = iRowStr.split(";");
// 			for (idx=0; idx<iRows.length-1; idx++){
// 				sheetObj.RowDelete(iRows[idx], false);
// 			}
// 			
// 			var rowStatus;
// 			for (idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
// 				rowStatus = sheetObj.RowStatus(idx);
// 			    if(rowStatus == 'U') {
// 			    	sheetObj.CellValue2(idx, prefixs[0]+"del_chk")= 0;
// 			    	sheetObj.RowStatus(idx) = 'R';
// 			    }
// 			}
 			
 			awkFlg = "N";
 		} else {
 			dgFlg = "N"
 		}
 		
 		var prefix = prefixs[parseInt(tabIdx)];
 		
// 		var sortCols = new Array();
// 		sortCols[0] = prefix+"vsl_cd";
// 		sortCols[1] = prefix+"skd_voy_no";
// 		sortCols[2] = prefix+"skd_dir_cd";
// 		sortCols[3] = prefix+"cgo_opr_cd";
// 		sortCols[4] = prefix+"pol_cd";
// 		sortCols[5] = prefix+"pod_cd";
// 		sortCols[6] = prefix+"bkg_ref_no";
// 		sortCols[7] = prefix+"spcl_cgo_rqst_seq";
// 		sortCols[8] = prefix+"spcl_cntr_seq";
// 		sortCols[9] = prefix+"spcl_cgo_seq";
// 		
// 		var sortDirs = new Array();
// 		sortDirs[0] = "ASC";
// 		sortDirs[1] = "ASC";
// 		sortDirs[2] = "ASC";
// 		sortDirs[3] = "ASC";
// 		sortDirs[4] = "ASC";
// 		sortDirs[5] = "ASC";
// 		sortDirs[6] = "ASC";
// 		sortDirs[7] = "ASC";
// 		sortDirs[8] = "ASC";
// 		sortDirs[9] = "ASC";
 		
 		//sheetObj.ColumnSort(sortCols.join("|"),"ASC",sortDirs.join("|"),true);
 		
// 		var sParam = ComGetSaveString(sheetObj, false, false, -1);
// 		if(sParam == "") return ''; 
// 		
// 		if(tabIdx == '1') {
// 		
 			var rslt = validateForm(sheetObj,formObj,IBSAVE);
 			if(!rslt) {
 				return '';
 			}
 			
 			sParam = ComGetSaveString(sheetObj, false, false, -1);
 			if(sParam == '') return '';
// 		}
 		
 		var paramPrefix = new Array(prefix, prefix, "file_");
 		sParam += "&"+FormQueryString(formObj)+"&dg_flg="+ dgFlg +"&awk_flg="+awkFlg +"&" + ComGetPrefixParam(paramPrefix);
 		
 		return sParam;
    }
	 
	/**
	 * Result of modified data Setter
	 */
    function setResultPop(formObj, sheetObj) {
		if(sheetObj != null && formObj[0] != "I") {
	    	var pSheetObj = sheetObjects[0];
	    	var selNo = pSheetObj.CellValue(pSheetObj.SelectRow, prefixs[0]+"seqNo");
	    	var startRow = -1;    
	    	
	    	pSheetObj.Redraw = false; 
	    	var delList1 = new Array();
	    	var delCt    = 0;
	    	var addYn    = true;
	    	for(var pRow=pSheetObj.LastRow; pRow>=pSheetObj.HeaderRows; pRow--) {
	    		var sameNo = pSheetObj.CellValue(pRow, prefixs[0]+"seqNo");
	    		
	    		if(selNo == sameNo) {
	    			var delList2 = new Array();
	    			delList2[0] = pSheetObj.CellValue(pRow, prefixs[0]+"spcl_cntr_seq");
	    			delList2[1] = pSheetObj.CellValue(pRow, prefixs[0]+"spcl_cgo_seq");
	    			delList2[2] = pSheetObj.CellValue(pRow, prefixs[0]+"auth_sts_cd");
	    			delList1[delCt++] = delList2;
	    			pSheetObj.RowDelete(pRow, false);
	    			startRow = pRow-1;
	    		}
	    	}
	    	
	    	for(var cRow=sheetObj.HeaderRows; cRow<=sheetObj.LastRow; cRow++) {
	    			
    			addYn = true;
//				전부 표시 되도록 아래 로직을 제거 2011.03.23    			
//    			if(sheetObj.CellValue(cRow, "auth_sts_cd") == "Y" || sheetObj.CellValue(cRow, "auth_sts_cd") == "N") {	    
//    				addYn = false;
//	    			for(var i=0; i<delList1.length; i++) {
//	    				//요청상태에서 Confirm 상태로 변경된 Cargo의 경우에만 Display한다.
//	    				if(delList1[i][2]=='R' && delList1[i][0]==sheetObj.CellValue(cRow, "spcl_cntr_seq") && delList1[i][1]==sheetObj.CellValue(cRow, "spcl_cgo_seq")) 
//	    					addYn = true;
//	    			}
//    			}
	    			
	    		if(addYn) {
		    		if(cRow == sheetObj.HeaderRows) pSheetObj.DataInsert(startRow);
		    		else pSheetObj.DataInsert();
		    		
		    		for(var cCol=0; cCol<=pSheetObj.LastCol; cCol++) {
		    			var colName = pSheetObj.ColSaveName(cCol).replace(prefixs[0],'');	    			
		    			
		    			if(colName == 'imdg_subs_rsk_lbl_cd') {
		    				var n1stSubs = sheetObj.CellValue(cRow, "n1st_imdg_subs_rsk_lbl_cd");
		    				var n2ndSubs = sheetObj.CellValue(cRow, "n2nd_imdg_subs_rsk_lbl_cd");
		    				var n3rdSubs = sheetObj.CellValue(cRow, "n3rd_imdg_subs_rsk_lbl_cd");
		    				var n4thSubs = sheetObj.CellValue(cRow, "n4th_imdg_subs_rsk_lbl_cd");
		    				
		    				if(n1stSubs != '' && n2ndSubs != '') n1stSubs = n1stSubs + "/" + n2ndSubs; 
		    				else n1stSubs = n1stSubs + n2ndSubs; 
		    				
		    				if(n1stSubs != '' && n3rdSubs != '') n1stSubs = n1stSubs + "/" + n3rdSubs; 
		    				else n1stSubs = n1stSubs + n3rdSubs; 
		    				
		    				if(n1stSubs != '' && n4thSubs != '') n1stSubs = n1stSubs + "/" + n4thSubs; 
		    				else n1stSubs = n1stSubs + n4thSubs; 
		    				
		    				pSheetObj.CellValue2(pSheetObj.SelectRow, cCol) = n1stSubs;
		    			} else {
		    				pSheetObj.CellValue2(pSheetObj.SelectRow, cCol) = sheetObj.CellValue(cRow, colName);
		    			}
		    		}
		    		
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"seqNo")             = selNo;
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"spcl_cgo_rqst_seq") = formObj[1];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"vsl_cd")            = formObj[2];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"skd_voy_no")        = formObj[3];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"skd_dir_cd")        = formObj[4];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"slan_cd")           = formObj[5];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"bkg_ref_no")        = formObj[6];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"cgo_opr_cd")        = formObj[7];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"pol_cd")            = formObj[8].substring(0,6);
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"pol_clpt_ind_seq")  = formObj[8].substring(5,6);
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"eta_dt")            = formObj[9];
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"pod_cd")            = formObj[10].substring(0,6);
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"pod_clpt_ind_seq")  = formObj[10].substring(5,6);
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"crr_cd")            = formObj[11];
		    		
		    		pSheetObj.CellValue2(pSheetObj.SelectRow, prefixs[0]+"seq") = sheetObj.CellValue(cRow, "spcl_cgo_seq");
		    		
		    		setAuthStat(pSheetObj, pSheetObj.SelectRow);	
		    		
		    		pSheetObj.RowStatus(pSheetObj.SelectRow) = "R";	    	
	    		}
	    	}
	    	
	    	var totRowCt = pSheetObj.RowCount("R") + pSheetObj.RowCount("I") + pSheetObj.RowCount("U");
	    	if(totRowCt == 0) ComBtnDisable("btn_details"); 
	    	
	    	for(var pRow=pSheetObj.LastRow; pRow>=pSheetObj.HeaderRows; pRow--) {
    			var auth_sts_cd = pSheetObj.CellValue(pRow, prefixs[0]+"auth_sts_cd");
    			if(auth_sts_cd == 'Y' || auth_sts_cd == 'N' ){ 
    				pSheetObj.RowEditable(pRow) = false;
    			} else {
    				pSheetObj.RowEditable(pRow) = true;
    			}	
    			//pSheetObj.CellEditable(pRow, prefixs[0]+"auth_sts_cd"					) = true;
	    	}
	    	
	    	pSheetObj.Redraw = true; 
		}
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Set&Getter 
    //////////////////////////////////////////////////////////////////////////////////////////     

    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Do action indoors
    ////////////////////////////////////////////////////////////////////////////////////////// 
  	
  	/**
  	 * Dangerous CGO Application Details for Partner Lines (Pop-Up)<br>
  	 */
  	function doPopDetails(sheetObj, Row) {
  		if(Row == -1 || sheetObj.RowCount == 0) {
  			ComShowCodeMessage("SCG50018");	//'Please use after Retrieve.'
  			return;
  		} else {
  			//초기화
  			setAppDetlObj(null, Row);
  			
  			var rgn_shp_opr_cd = sheetObj.CellValue(Row, prefixs[0]+"rgn_shp_opr_cd");
		  	if(rgn_shp_opr_cd == '') rgn_shp_opr_cd = document.all.rgn_shp_opr_cd.Code;
  			
		  	var sParam = Array();		  	
		  	sParam[0] = "rgn_shp_opr_cd="+rgn_shp_opr_cd;
		  	if(Row != -1 && sheetObj.TotalRows != 0) {
				var paramNm = "";
				for(var col=1; col<=sheetObj.LastCol; col++){
					paramNm = sheetObj.ColSaveName(col);
					paramNm = paramNm.substring(9, paramNm.length);
					sParam[col] = paramNm+"="+sheetObj.CellValue(Row, col);
				} 
				
				//Copy일 경우 해당 Row 정보 저장				
			  	if(sheetObj.CellValue(Row, prefixs[0]+"spcl_cgo_rqst_seq") == '') {
			  		setAppDetlObj(sheetObj, Row);
			  	}
		  	} else {
		  		sParam[1] = "vsl_cd="+ComGetObjValue(document.form.vsl_cd);
		  		sParam[2] = "skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
		  		sParam[3] = "skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
		  		sParam[4] = "crr_cd="+ComGetObjValue(document.form.crr_cd);
		  		sParam[5] = "slan_cd="+ComGetObjValue(document.form.slan_cd);
		  	}
		  	ComOpenWindowCenter("VOP_SCG_1022.do?mode=edit&"+sParam.join("&"), "winEditDtl", "1060", "555", true);
		  	
  		}
  	}
  	
  	function doPopUpAprn(sheetObj, Row, tab) {
  		
  		var param   = sheetObj.CellValue(Row, prefixs[0]+"email_info");
  		var param1  = sheetObj.CellValue(Row, prefixs[1]+"email_info");
  		
  		if(tab == "sheet1" && param != "") {
  			 ComOpenWindowCenter("VOP_SCG_2022.do?email_info=" + param, "winEditDtl", "400", "400", true);	 }
  		else if( tab == "sheet2" && param1 != "")
  			{ ComOpenWindowCenter("VOP_SCG_2022.do?email_info=" + param1, "winEditDtl", "400", "400", true); }	
  	}
  	
  	/**
  	 * Extract only booking information from cago information<br>
  	 */
  	function doMakeBookInfo(sheetObj) {
  		for(var rowIdx1=sheetObj.HeaderRows; rowIdx1<sheetObj.LastRow; rowIdx1++) {
  			
  		}
  	}
  	 
  	/**
     * Make Search XML of Application Details using copy
     */
    function makeSearchXml(sheetObj, row) {
    	var colOrder = "";
    	var colValue = "";

     	colValue += "<TR><![CDATA[";
        for (ic = 0; ic<= sheetObj.LastCol; ic++) {
        	var sName  = sheetObj.ColSaveName(ic);
        	sName = sName.substring(9, sName.length);
        	var sValue = String(sheetObj.CellValue(row, ic));
        	
        	colOrder += sName + "|";
        	colValue += sValue + "||";
        }
        colValue += "]]></TR>\n";
        
        var rowXml = "<?xml version='1.0'?>\n<SHEET>\n<DATA COLORDER='"+colOrder+"' COLSEPARATOR='||' TOTAL='1'>\n";
     	rowXml += colValue + "</DATA>\n</SHEET>";

 	    return rowXml;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Do action indoors
    ////////////////////////////////////////////////////////////////////////////////////////// 
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Do action outdoors
    ////////////////////////////////////////////////////////////////////////////////////////// 

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        		
        		//2012.01.06 1) Tab 별 조회 가능하도록 수정
        		var tabIdx = tabObjects[0].SelectedIndex;
    			formObj.f_cmd.value = SEARCH;
    			
    			if(tabIdx == 0) var param = FormQueryString(formObj) + "&scg_flg=DG1";
    			else var param = FormQueryString(formObj) + "&scg_flg=AWK";
    			
    			var sXml = sheetObj.GetSearchXml("VOP_SCG_0022GS.do", param +"&" + ComGetPrefixParam(prefixs[tabIdx]));
    			
    			loadCt = 0;
     			sheetObjects[tabIdx].Redraw = false; 
     			sheetObjects[tabIdx].LoadSearchXml(sXml);
     			sheetObjects[tabIdx].Redraw = true; 
     			
//     			var arrXml = sXml.split("|$$|");
//     			
//     			tabIdx = tabObjects[0].SelectedIndex;
//     			
//     			loadCt = 0;
//     			//ComOpenWait(true, true);
//
//				sheetObjects[0].Redraw = false; 
//				sheetObjects[1].Redraw = false;   
//				
//				if(tabIdx == 0) {
//					for(var i=0; i<arrXml.length; i++) {
//						tabObjects[0].SelectedIndex = i;
//				    	
//						sheetObjects[i].LoadSearchXml(arrXml[i]); 
//					}
//					tabObjects[0].SelectedIndex = tabIdx;
//				} else {
//					for(var i=arrXml.length-1; i>=0; i--) {
//						tabObjects[0].SelectedIndex = i;
//						
//						sheetObjects[i].LoadSearchXml(arrXml[i]); 
//					}
//					tabObjects[0].SelectedIndex = tabIdx;
//				}
//				
//				
//				sheetObjects[0].Redraw = true; 
//				sheetObjects[1].Redraw = true;   

	     		break;
	     	
        	case SEARCH01:      //재조회	    		
				formObj.f_cmd.value = SEARCH;
	 			var sXml = sheetObj.GetSearchXml("VOP_SCG_0022GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefixs));
	 			var arrXml = sXml.split("|$$|");
	 			
	 			sheetObj.Redraw = false;  
	 			sheetObj.LoadSearchXml(arrXml[0]); 
	 			sheetObj.Redraw = true; 
	
	     		break;

			case IBSAVE:        //저장				
				formObj.f_cmd.value = MULTI;
				var tabIdx = ComGetObjValue(formObj.tabSelectedIdx);
				var sParam1 = getSaveParam(sheetObj, formObj, tabIdx);
				
				if(tabIdx == '0') {
					tabIdx = '1';
				} else {
					tabIdx = '0';
				}
				
				var sheetObj2 = sheetObjects[parseInt(tabIdx)];
				
				var sParam2 = getSaveParam(sheetObj2, formObj, tabIdx);	
				
				if(sheetObj.IsDataModified && sParam1 == '') sParam2 = "";
				if(sheetObj2.IsDataModified && sParam2 == '') sParam1 = "";
				
				if((sParam1+sParam2).length > 0) {					
	        		if(!ComShowCodeConfirm('SCG50001', 'data')) return;	//'Do you want to save {?msg1}?'
				} else {
					return;
				}
				
				var sXml1 = "", sXml2 = "";
				var rslt1 = "", rslt2 = "";
				
				if(sParam1.length > 0) {
					sXml1 = sheetObj.GetSaveXml("VOP_SCG_0022GS.do", sParam1);
					rslt1 = ComGetEtcData(sXml1, "rslt");
				}
				if(sParam2.length > 0) {
					sXml2 = sheetObj2.GetSaveXml("VOP_SCG_0022GS.do", sParam2);
					rslt2 = ComGetEtcData(sXml2, "rslt");
				}
				
				if(sXml2.length > 0) {
					if(rslt2 == '0') ComShowMessage(ComScgGetMessageFromXml(sXml2));
					else sheetObj2.LoadSaveXml(sXml2);
				} else if(sXml1.length > 0) {
					if(rslt1 == '0') ComShowMessage(ComScgGetMessageFromXml(sXml1));
					else sheetObj.LoadSaveXml(sXml1);
				}
				
				if(rslt1 == '1' || rslt2 == '1') {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					
				} else {					
					//doActionIBSheet(sheetObjects[0],formObj,SEARCH01);					
					//tabObjects[0].SelectedIndex = 1;
				}
				
				break;
				
        }
    }
    
    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj, comboNo) {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
        sheetObj.ShowDebugMsg = false;
        
        switch(comboNo) {
	  		case 1:    
	  			formObj.f_cmd.value = SEARCH01;
	  			
	  			sheetObj.WaitImageVisible = false;
        		var sXml = sheetObj.GetSearchXml("VOP_SCG_0034GS.do", FormQueryString(formObj));
        		sheetObj.WaitImageVisible = true;
        		
        		ComXml2ComboItem(sXml, formObj.rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
        		
        		//var initSelTxt = comboObj.FindIndex("ASR", 0);
        		//comboObj.Text = initSelTxt;
        		
        		ComSetFocus(formObj.rgn_shp_opr_cd);
        		
        		formObj.rgn_shp_opr_cd.Code = formObj.u_rso.value;
        		
	  			break;  
        }
    }
    
    /**
     * Vessel Name 조회
     */
    function searchVVDRelInfo(vsl_cd, skd_voy_no, skd_dir_cd, wFrom, Row) {
    	
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	var sParam = Array();
	  	sParam[0] = "vsl_cd="+vsl_cd;
	  	sParam[1] = "skd_voy_no="+skd_voy_no;
	  	sParam[2] = "skd_dir_cd="+skd_dir_cd;
	  	sParam[3] = "f_cmd="+SEARCH05;
	  	
	  	sheetObj.WaitImageVisible = false;
    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
    	sheetObj.WaitImageVisible = true;
    	
    	if(wFrom == 'form') {
	 	   	//Vessel Name 셋팅
	 	    setVslEngNm(formObj, sXml);
    	} else if(wFrom == 't2Sheet1') {
    		//Vessel Lane 셋팅
    		setVslLane(sheetObj, sXml, Row);
    		
    		//POL Combo 생성
    		portXml = "";
    		searchPolCd(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd);
    	} 
    }
    
    /**
     * Cargo Operator 조회
     */
    function searchCarrierInfo(sheetObj, Row, cgoOprCd) {  
    	var formObj  = document.form;
    	
    	var idx = 0;
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
    	formObj.f_cmd.value = SEARCH01;
    	
    	sheetObj.WaitImageVisible = false;
 	   	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", "crr_cd="+cgoOprCd+"&"+FormQueryString(formObj)); 	 
 	    sheetObj.WaitImageVisible = true;
 	    
 	   	var crrData = ComScgXml2Array(sXml, "crr_cd");
   	
	   	if(crrData == null) {
		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
		    sheetObj.SelectCell(Row, prefixs[idx]+"cgo_opr_cd", true, "");
	   	}
	   	
	   	setSyncValMerge(sheetObj, Row, sheetObj.SaveNameCol(prefixs[idx]+"cgo_opr_cd"), sheetObj.CellValue(Row, prefixs[idx]+"cgo_opr_cd"));
    }
    
    /**
     * POL 목록 조회
     */
    var portXml = "";
    function searchPolCd(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd) {  
    	if ( g_sheet_id != sheetObj.id || g_vsl_cd != vsl_cd || g_skd_voy_no != skd_voy_no || g_skd_dir_cd != skd_dir_cd || portXml == '' ) {
    		var sParam = Array();
	    	sParam[0] = "vsl_cd="+vsl_cd;
		  	sParam[1] = "skd_voy_no="+skd_voy_no;
		  	sParam[2] = "skd_dir_cd="+skd_dir_cd;
		  	sParam[3] = "f_cmd="+SEARCH10;
	    	
		  	sheetObj.WaitImageVisible = false;
		  	
		  	portXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&"));
		  	g_sheet_id = sheetObj.id;
		  	g_vsl_cd = vsl_cd;
		  	g_skd_voy_no = skd_voy_no;
		  	g_skd_dir_cd = skd_dir_cd;
		  	sheetObj.WaitImageVisible = true;
    	}
			
		return setPolCombo(sheetObj, Row, portXml);
    }
     
    /**
     * POD 목록 조회
     */
    function searchPodCd(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd, pol_cd) {  
     	
     	if ( g_vsl_cd != vsl_cd || g_skd_voy_no != skd_voy_no || g_skd_dir_cd != skd_dir_cd || portXml == '' ) {
	 	   	var sParam = Array();
	 	  	sParam[0] = "vsl_cd="+vsl_cd;
	 	  	sParam[1] = "skd_voy_no="+skd_voy_no;
	 	  	sParam[2] = "skd_dir_cd="+skd_dir_cd;
	 	  	sParam[3] = "f_cmd="+SEARCH10;
	     	
	 	  	if(pol_cd != '') {
		 	  	sheetObj.WaitImageVisible = false;
		 	  	portXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
		 	  	sheetObj.WaitImageVisible = true;
	 	  	}
	 		
		  	g_vsl_cd = vsl_cd;
		  	g_skd_voy_no = skd_voy_no;
		  	g_skd_dir_cd = skd_dir_cd;
    	}
 		setPodCombo(sheetObj, Row, portXml, pol_cd);
    }

    /**
     * IMDG_UN_NO_SEQ 목록 조회
     */
    function searchImdgUnNoSeq(sheetObj, Row, imdg_un_no) {  
     	
    	var sParam = Array();
    	var imdgSeqXml = "";
    
    	idx = 0;
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
 	  	sParam[0] = "imdg_un_no="+imdg_un_no;
 	  	sParam[1] = "f_cmd="+SEARCH07;
     	
 	  	if(imdg_un_no != '') {
	 	  	sheetObj.WaitImageVisible = false;
	 	  	imdgSeqXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", sParam.join("&")); 
	 	  	sheetObj.WaitImageVisible = true;
 	  	} else return; 
 	  	
 	  	if(ComGetTotalRows ( imdgSeqXml ) == 0) {
		    ComShowCodeMessage("SCG50010", 'IMDG UN No.');	//'{?msg1} is invalid.'
		    sheetObj.CellValue2(Row, prefixs[idx]+"imdg_un_no_seq") = "";
		    sheetObj.CellComboItem(Row, prefixs[idx]+"imdg_un_no_seq", "| |", "| |", 0);
		    sheetObj.SelectCell(Row, prefixs[idx]+"imdg_un_no", true, "");
		    return;
	   	}
 		setImdgUnNoSeqCombo(sheetObj, Row, imdgSeqXml );
    }
    
    /**
     * IMDG_UN_NO, IMDG_UN_NO_SEQ 별 CLASS, SUB. RISK, PG 조회
     */
    function searchClassSubRiskPG(sheetObj, Row, imdg_un_no, imdg_un_no_seq) {  
     	
    	var sParam = Array();
    	var imdgInfoXml = "";
    	
    	idx = 0;
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
    	sParam[0] = "imdg_un_no="+imdg_un_no;
 	  	sParam[1] = "imdg_un_no_seq="+imdg_un_no_seq;
 	  	sParam[2] = "f_cmd="+SEARCH08;
     	
 	  	if(imdg_un_no != '' && imdg_un_no_seq != '' && imdg_un_no != ' ' && imdg_un_no_seq != ' ' ) {
	 	  	sheetObj.WaitImageVisible = false;
	 	  	imdgInfoXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", sParam.join("&")); 
	 	  	sheetObj.WaitImageVisible = true;
 	  	} else return;
 	  	
 	  	if(ComGetTotalRows ( imdgInfoXml ) == 0) {
		    ComShowCodeMessage("SCG50010", 'IMDG UN NO Seq');	//'{?msg1} is invalid.'
		    sheetObj.SelectCell(Row, prefixs[idx]+"imdg_un_no_seq", true, "");
		    return;
	   	}
 		
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"n1st_imdg_subs_rsk_lbl_cd" ) = getXmlData ( imdgInfoXml, 0, "n1st_imdg_subs_rsk_lbl_cd");
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"n2nd_imdg_subs_rsk_lbl_cd" ) = getXmlData ( imdgInfoXml, 0, "n2nd_imdg_subs_rsk_lbl_cd"); 
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"n3rd_imdg_subs_rsk_lbl_cd" ) = getXmlData ( imdgInfoXml, 0, "n3rd_imdg_subs_rsk_lbl_cd");
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"n4th_imdg_subs_rsk_lbl_cd" ) = getXmlData ( imdgInfoXml, 0, "n4th_imdg_subs_rsk_lbl_cd"); 
	   	
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"imdg_subs_rsk_lbl_cd" )      = getXmlData ( imdgInfoXml, 0, "imdg_subs_rsk_lbl_cd"); 
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"imdg_clss_cd" )              = getXmlData ( imdgInfoXml, 0, "imdg_clss_cd"); 
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"imdg_pck_grp_cd" )           = getXmlData ( imdgInfoXml, 0, "imdg_pck_grp_cd"); 
	   	sheetObj.CellValue2 ( Row, prefixs[idx]+"prp_shp_nm" )           	  = getXmlData ( imdgInfoXml, 0, "prp_shp_nm"); 
	   	
	   	chkProhibition ( sheetObj, Row );
    }
    
    /**
     * ETA 조회
     */
    function searchETADt(sheetObj, Row, vsl_cd, skd_voy_no, skd_dir_cd, loc_cd, clpt_ind_seq) {  
    	
    	var sParam = Array();
    	sParam[0] = "vsl_cd="+vsl_cd;
	  	sParam[1] = "skd_voy_no="+skd_voy_no;
	  	sParam[2] = "skd_dir_cd="+skd_dir_cd;
	  	sParam[3] = "loc_cd="+loc_cd.substring(0,5);	
	  	sParam[4] = "clpt_ind_seq="+clpt_ind_seq;
	  	sParam[5] = "f_cmd="+SEARCH10;
    	
	  	sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
		sheetObj.WaitImageVisible = true;
		
		setETADt(sheetObj, Row, sXml);
    }
    
    /**
     * TP/SZ 목록 조회
     */
    function searchTPSZ(sheetObj) {  
    	var formObj  = document.form;
    	formObj.f_cmd.value = SEARCH06;
    	
    	sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		
		setTPSZCombo(sheetObj, sXml);
    }
     
    /**
     * 조회
     */
    function searchList() {  
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    }
     
    /**
     * 요청 메일 보내기
     */
    function sendReqMail(sheetObj, Row, formObj) {
    	if(Row == -1) {
  			//ComShowCodeMessage("SCG50018");	//'Please use after Retrieve.'
  			return;
  		} else {  		  	
		  	var crr_cd                 = sheetObj.CellValue(Row, prefixs[1]+"crr_cd");
		  	var bkg_ref_no             = sheetObj.CellValue(Row, prefixs[1]+"bkg_ref_no");
		  	var spcl_cgo_rqst_seq      = sheetObj.CellValue(Row, prefixs[1]+"spcl_cgo_rqst_seq");
		  	var rgn_shp_opr_cd         = document.all.rgn_shp_opr_cd.Code;
		  	var scg_flg                = "AK";
		  	var send_type              = "P0";
		  	var user_id                = ComGetObjValue(formObj.user_id);
		  	
		  	mailObj.crr_cd = crr_cd;
		  	mailObj.bkg_ref_no = bkg_ref_no;
		  	mailObj.spcl_cgo_rqst_seq = spcl_cgo_rqst_seq;
		  	mailObj.rgn_shp_opr_cd = rgn_shp_opr_cd;
		  	mailObj.scg_flg = scg_flg;
		  	mailObj.send_type = send_type;
		  	mailObj.user_id = user_id;
		  	
		  	ComScgSendMail(sheetObj, formObj, mailObj);
  		}
    }
     
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
      	var formObj  = document.form;
      	var sheetObj = sheetObjects[1];
      	
      	var sParam = Array();
  	  	sParam[0] = "crr_cd="+obj.value;
  	  	sParam[3] = "f_cmd="+SEARCH01;

  	  	if(sParam.join("").length > 18) {  
  	  		sheetObj.WaitImageVisible = false;
  	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
  	    	sheetObj.WaitImageVisible = true;
  	
  	    	var crrData = ComScgXml2Array(sXml, "crr_cd");
  	      	
  		   	if(crrData == null) {
  			    ComShowCodeMessage("SCG50010",'Data');	//'{?msg1} is invalid.'
  			    
  			    ComSetObjValue(obj, ""); 	
 	 		    ComSetFocus(obj);
  		   	} 
  	  	} else {  	  		
  	  		ComChkObjValid(obj, true);
  	  	}
    }
     
    /**
     * Carrier Validation
     */
    var loadCt = 0;
    function quitWaitImg(val) {
    	loadCt += val;
    	if(loadCt == 2) {
    		//ComOpenWait(false);
    	} 
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Do action outdoors
    //////////////////////////////////////////////////////////////////////////////////////////     

    
    //////////////////////////////////////////////////////////////////////////////////////////
    //S// Validate
    //////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * 화면 입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
    	
    	var idx = 0;
    	if ( sheetObj.id == "t2sheet1" ) idx = 1;
    	
    	switch(sAction) {

	    	case IBSEARCH:
	    		//Check requirement of Irregulars Type
	    		if (comboObjects[0].Code == "") {
	    			ComShowCodeMessage('SCG50011','RSO');
	    			formObj.rgn_shp_opr_cd.focus();
	    			return;
	    		}
		    	
	    		//폼 개체 안에 모든 컨트롤의 Validation을 확인
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
		    	
	    		break;
	    	case IBSAVE:	
	    		var ibflag, aproNo, aproStatus;
	    		var cntrSeq1, cntrSeq2;
		    	var sVal1;
		    	var sVal2;
		    	var dupChk = 0;
		    	for(var rowIdx1=sheetObj.HeaderRows; rowIdx1<=sheetObj.LastRow; rowIdx1++) {
		    		ibflag = sheetObj.RowStatus(rowIdx1);			
		    		sVal1  = sheetObj.CellValue(rowIdx1, prefixs[idx]+"cgo_opr_cd");
		    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"bkg_ref_no");
		    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"vsl_cd");
		    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"skd_voy_no");
		    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"skd_dir_cd");
		    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"pol_cd");
		    		sVal1 += sheetObj.CellValue(rowIdx1, prefixs[idx]+"pod_cd");
		    		cntrSeq1 = sheetObj.CellText(rowIdx1, prefixs[idx]+"spcl_cntr_seq");
		    		cgoSeq1  = sheetObj.CellText(rowIdx1, prefixs[idx]+"spcl_cgo_seq"); // CGO Seq 까지 같으면 중복으로 인식 되도록 추가  2011.04.21
//		    		alert(rowIdx1+":"+sVal1);
//		    		alert(rowIdx1+":"+cntrSeq1+":"+cgoSeq1+":"+ibflag);
					if(ibflag != 'D' && ibflag == 'I'  && sVal1 != '') {				
			    		for(var rowIdx2=sheetObj.HeaderRows; rowIdx2<=sheetObj.LastRow; rowIdx2++) {
			    			if(rowIdx2 != rowIdx1) {
				    			ibflag = sheetObj.RowStatus(rowIdx2);	
				    			aproNo = sheetObj.CellValue(rowIdx2, prefixs[idx]+"apro_ref_no");
				    			aproStatus = sheetObj.CellValue(rowIdx2, prefixs[idx]+"org_auth_sts_cd");
				    			
				    			sVal2  = sheetObj.CellValue(rowIdx2, prefixs[idx]+"cgo_opr_cd");
					    		sVal2 += sheetObj.CellValue(rowIdx2, prefixs[idx]+"bkg_ref_no");
				    			sVal2 += sheetObj.CellValue(rowIdx2, prefixs[idx]+"vsl_cd");
				    			sVal2 += sheetObj.CellValue(rowIdx2, prefixs[idx]+"skd_voy_no");
				    			sVal2 += sheetObj.CellValue(rowIdx2, prefixs[idx]+"skd_dir_cd");
				    			sVal2 += sheetObj.CellValue(rowIdx2, prefixs[idx]+"pol_cd");
				    			sVal2 += sheetObj.CellValue(rowIdx2, prefixs[idx]+"pod_cd");
				    			cntrSeq2 = sheetObj.CellText(rowIdx2, prefixs[idx]+"spcl_cntr_seq");
				    			cgoSeq2  = sheetObj.CellText(rowIdx2, prefixs[idx]+"spcl_cgo_seq"); // CGO Seq 까지 같으면 중복으로 인식 되도록 추가  2011.04.21
				    			
				    			if(ibflag != 'D' && sVal2 != '') {
//				    				alert(rowIdx1+"("+rowIdx2+"):"+sVal2);
//						    		alert(rowIdx1+"("+rowIdx2+"):"+cntrSeq2+":"+cgoSeq2);
				    				if(sVal1 == sVal2) {
				    					if(cntrSeq1 == cntrSeq2 && cgoSeq1 == cgoSeq2 ) {
					    					ComShowCodeMessage('SCG50005','Data');   //'{?msg1} is duplicated.'
					    					sheetObj.SelectCell(rowIdx1, prefixs[idx]+"spcl_cntr_seq");
						    				return false;
				    					} else {
				    						dupChk++;
				    					}
				    				} 
				    			}
			    			}
						}
			    		//Confirm 된 Cargo 목록에서 중복된 Seq 를 체크한다.
			    		for(var dupIdx=0; dupChkList != null && dupIdx<dupChkList.length; dupIdx++) {
			    			if(sVal1 == dupChkList[dupIdx][0]) {
		    					if(cntrSeq1 == dupChkList[dupIdx][1]) {
			    					ComShowCodeMessage('SCG50005','Data');   //'{?msg1} is duplicated as same {?msg2}'
			    					sheetObj.SelectCell(rowIdx1, prefixs[idx]+"spcl_cntr_seq");
				    				return false;
		    					} else {
		    						dupChk++;
		    					}
		    				} 
			    		}
					}
		    	}
			    if(dupChk > 0) setRqstSeq(sheetObj);
		    	
		    	break;
	    	case IBCLEAR:
	    		if(sheetObj.IsDataModified) {
	    			if(ComShowCodeConfirm('SCG50003')) {	//'Data was changed. Do you want to save it?'
	    				doActionIBSheet(sheetObj,formObj,IBSAVE);
	    				return false;
	    			}
	    		}
	    		break;
		}
	
	    return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
    //E// Validate
    //////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	 * IBMultiCombo의 item으로 insert 해준다.<br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
	 * @return 없음.
	  * @author 박성수
	  * @version 2009.04.22
	 */
	
	function getXmlData(xmlStr, rowNum, colInd ) {
		
		if (xmlStr == null || xmlStr == "" ) {
			return;
		}
		if (rowNum == null || colInd == "" || colInd == null ) {
			return;
		}
	
		try {
			
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);
	
			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
	
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
			
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");
	
			if (rowNum + 1 > total) {
				return;
			}
			
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
						
			if ( ComIsNumber(colInd) ){
				if ( colInd + 1 > colArr.length )
				return;
			}
			else {
				var colIdx = -1;
				for (var i = 0; i < colArr.length; i++) {
					if (colArr[i] == colInd) {
						colIdx = i;
						break;
					}
				}
				if ( colIdx < 0 ) {
					return;
				}
			}
			for (var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1 || i < rowNum ) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				
				var item = "";
				var ind = 0;
				for (var j = 1; j < colArr.length; j++) {
					if (j == colIdx) {
						item = arrData[j];
						ind = 1;
						break;
					}
				}
				if ( ind == 1) break;
			}
			return item;
	
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}
    
	/**
	 * IBSheet 에서 선택된 기준 Row 를 기준으로 Spcl_Cntr_Seq, Spcl_Cgo_Seq 의 최대값을 찾아온다. <br>
	 * 
     * @param sheetObj  IBSheet Object
     * @param row     	sheetObj의 선택된 Row
     * @param level    	1 : Spcl_Cntr_seq max ( bkg_ref_no 기준 ),
     *                  2 : Spcl_Cgo_seq  max ( bkg_ref_no, spcl_cntr_seq 기준 )
     * @return max sequence.
	 * @author 송호진
	 * @version 2011.04.13
	 */
	
	function getMaxCntrCgoSeq ( sheetObj, row, level ) {
		 
		with ( sheetObj ) {

			var bkg_ref_no = CellValue ( row, prefixs[0]+"bkg_ref_no" );
			var cntr_seq   = CellValue ( row, prefixs[0]+"spcl_cntr_seq" );
			var new_seq    = 0;
			
			for (var idx = HeaderRows; RowCount > 0 && idx <= LastRow; idx++) {
		        if ( idx == row ) continue;
				if ( level == 1 ) {
					if ( CellValue ( idx, prefixs[0]+"bkg_ref_no" ) == bkg_ref_no ) {
						if ( parseInt ( CellValue ( idx, prefixs[0]+"spcl_cntr_seq" ) ) > new_seq ) {
							new_seq = parseInt ( CellValue ( idx, prefixs[0]+"spcl_cntr_seq" ) );
						}
					}
				} else if ( level == 2 ) {
					if ( CellValue ( idx, prefixs[0]+"bkg_ref_no" ) == bkg_ref_no && CellValue ( idx, prefixs[0]+"spcl_cntr_seq" ) == cntr_seq ) {
						if ( parseInt ( CellValue ( idx, prefixs[0]+"spcl_cgo_seq" ) ) > new_seq ) {
							new_seq = parseInt ( CellValue ( idx, prefixs[0]+"spcl_cgo_seq" ) );
						}
					}
				}
			}
		}
		return new_seq + 1;
	}

	function DelChkOnlyEnable ( sheetObj, row, flag ) {
		with ( sheetObj ) {
			CellEditable(row, prefixs[0]+"bkg_ref_no"					) = flag;
			CellEditable(row, prefixs[0]+"cgo_opr_cd"					) = flag;
			CellEditable(row, prefixs[0]+"pol_cd"						) = flag;
			CellEditable(row, prefixs[0]+"pol_clpt_ind_seq"				) = flag;
			CellEditable(row, prefixs[0]+"pod_cd"						) = flag;
			CellEditable(row, prefixs[0]+"pod_clpt_ind_seq"				) = flag;
			CellEditable(row, prefixs[0]+"del_chk"						) = true;
			CellEditable(row, prefixs[0]+"auth_sts_cd"					) = flag;
			CellEditable(row, prefixs[0]+"spcl_cntr_seq"				) = flag;
			CellEditable(row, prefixs[0]+"spcl_cgo_seq"					) = flag;
			CellEditable(row, prefixs[0]+"cntr_tpsz_cd"					) = flag;
			CellEditable(row, prefixs[0]+"imdg_un_no"					) = flag;
			CellEditable(row, prefixs[0]+"imdg_un_no_seq"				) = flag;
			CellEditable(row, prefixs[0]+"out_n1st_imdg_pck_qty"		) = flag;
			CellEditable(row, prefixs[0]+"out_n1st_imdg_pck_cd"			) = flag;
			CellEditable(row, prefixs[0]+"mrn_polut_flg"				) = flag;
			CellEditable(row, prefixs[0]+"imdg_lmt_qty_flg"				) = flag;
			CellEditable(row, prefixs[0]+"imdg_expt_qty_flg"			) = flag;
			CellEditable(row, prefixs[0]+"flsh_pnt_cdo_temp"			) = flag;
			CellEditable(row, prefixs[0]+"grs_wgt"						) = flag;
			CellEditable(row, prefixs[0]+"net_wgt"						) = flag;
			CellEditable(row, prefixs[0]+"psa_no"						) = flag;
		}
	}

    /**
    * Vessel Operator's Prohibition Checking
    */
   function chkProhibition( sheetObj, row ) {
   		var formObj  = document.form;
   		var prefix_length = prefixs[0].length;
		
		var sParam = "";
		if(sheetObj.RowStatus(row) != 'D') {
			for(var j=0; j<=sheetObj.LastCol; j++) {
				if ( sheetObj.ColSaveName(j).substring(prefix_length) == "crr_cd" ) {
					sParam += "crr_cd=" +sheetObj.CellValue(row, prefixs[0]+"cgo_opr_cd")+"&";
				} else {
					sParam += sheetObj.ColSaveName(j).substring(prefix_length)+"="+sheetObj.CellValue(row, j)+"&";
				}
			}
		}
		
		sParam += "rgn_shp_opr_cd="+ComGetObjValue(formObj.rgn_shp_opr_cd);
		sParam += "&bkg_no="+sheetObj.CellValue(row, prefixs[0]+"bkg_ref_no");
		sParam += "&f_cmd="+SEARCH02;
		
		var resXml = sheetObj.GetSearchXml ( "VOP_SCG_0069GS.do", sParam );
		var arrXml = resXml.split("|$$|");
		
		//alert ( resXml );
		if ( ComGetTotalRows ( arrXml[1]) > 0 ) {
			ComShowMessage ( "Prohibition!!!" );
		}
		//return sParam;
   }

	
/* 개발자 작업  끝 */