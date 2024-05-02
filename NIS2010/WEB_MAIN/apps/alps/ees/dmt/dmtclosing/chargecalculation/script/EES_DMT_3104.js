/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3104.js
*@FileTitle : Exemption Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.16 황효근
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
     * @class EES_DMT_3104 : EES_DMT_3104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3104() {
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

 var uploadObjects = new Array();
 var uploadCnt = 0;
 
 var IBSAVE_FILEUPLOAD      = 201;
 var IBSEARCH_DETAIL        = 202;
 var IBSEARCH_ATTACHED_FILE = 203;
 var IBSEARCH_SPECRSN       = 204;
 var IBSEARCH_HISTORY       = 205;

 var IBSEARCH_DELTPATH      = 206;

 var IBDELREQCANCEL 	    = 96;
 var IBDELSAVE 			    = 97;
 
 var IBSEARCH_BKGVVD		= 300;
 var IBSEARCH_LOC 			= 119;
 var IBSEARCH_CUST          = 120
 
 var FILE_SELECT_CANCEL     = "USER_CANCEL";
 var FILE_NM 			    = "file_nm";
 var FILE_SIZE			    = "file_size";
 var FILE_PATH 			    = "file_path";
 var FILE_SAV_ID 		    = "file_sav_id";
 var UPD_DT                 = "upd_dt";
 var PREFIX 			    = "sheet3_";
 var URL_FILE_DOWNLOAD 	    = "/hanjin/FileDownload";
 
 var REASON_DETAIL_START    = 1;
 var REASON_DETAIL_END      = 9;
 
 var gObjId = "";	// Button Click 이벤트 발생시 해당 Callback 함수로 발생된 폼컨트롤의 id 를 전달하기 위해서 사용함.
 var doInitFlg = "Y";
 
 var oldRow = 0;
 var fileFlg = "N";
 
 var spec_rsn_cd = "";
 var spec_rsn_cd_row = 0;
 var spec_rsn_cd_col = "";
 
 var saveFlag = "Y";
 var vvd_flg = "N";
 var curr_flg = "N";
 var cust_flg = "N";
 
 var dtType = "";
 
 var chgDeltStsCd = "";
 
 var colName = "";
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj1 = sheetObjects[2];
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		if (srcName == null) return;
     		
     		switch(srcName) {
     			case "btn_upload":
     				doActionFileUpload();
     			break;

     			case "btn_file_delete":
     				doActionFileDelete();
         		break;
         			
				case "btn_request":
					doActionRequest();
				break;
	
				case "btn_close":
					window.close();
				break;
				
				case "btn_row_add":
					if (ComIsBtnEnable("btn_row_add")) 
						doActionRowAdd();					
					break
					
				case "btn_row_delete":
					if (ComIsBtnEnable("btn_row_delete")) 
						doActionRowDelete();
					break

 				case "btn_ReqCancel":
 					doActionIBSheet(sheetObjects[1],formObj,IBDELREQCANCEL);
 					break;
 					
				case "btn_approval":
					doActionApproval();
					break;

				case "btn_reject":
					doActionReject();
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
      * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
      * @param {ibupload} uploadObj    IBUpload Object
      **/
     function setUploadObject(upload_obj) {
     	uploadObjects[uploadCnt++] = upload_obj;
     }
     
	/**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
	function loadPage() {
		
    	for (var i=0; i<sheetObjects.length; i++) {
    		ComConfigSheet (sheetObjects[i] );
		    initSheet(sheetObjects[i],i+1);
		    ComEndConfigSheet(sheetObjects[i]);
    	}

		// UPLOAD 환경 설정
		for (var i=0; i<uploadObjects.length; i++) {
			// 기본 환경 설정
			ComConfigUpload(uploadObjects[i], "/hanjin/EES_DMT_3104GS.do");
			//2016.08.09 파일 업로드 5MB 용량 제한을 위해 추가
			//uploadObjects[i].SetLimit(100, 5000, 5000); 
		}
		uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
		
	    //Axon 이벤트 처리
	    initAxonControl();
	    
	    clearDetailReason();
	    
	}
	
	function initAxonControl() { 
	    //Axon 이벤트 처리1. 이벤트catch 
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
  	}
	
//	function initControl() {
//  		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
//  	}
       
  	//업무 자바스크립트 OnKeyPress 이벤트 처리
   	function obj_keypress() {
       	 switch(event.srcElement.dataformat){
        	case "engup":
	    	// 영문 소문자를 제외한 모든 문자
        		DmtComKeyOnlyAlphabet('upperall');
	        break;
       	 }
  	}
      

	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
  		var formObj = document.form;

	    doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_DELTPATH);		//로그인 사용자의 승인권한단계 조회
	    
 		// Delete Reason List 조회
 		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH); 		

 		if (ComGetObjValue(formObj.save_flg) == "A" ) {
	 		for(var i=sheetObjects[0].TopRow; i < sheetObjects[0].Rows; i++) {
	 			sheetObjects[0].CellEditable(i,"chk") = false;
	 		}
 		}
 		
	    //Approval for Charge Deletion 에서 호출한 경우
	    if (ComGetObjValue(formObj.prnt_mnu_id) == "EES_DMT_3014") {
	    	doInitFlg = "N";
	    	// 1. Charge 삭제요청시 입력한 Specific Reason 을 조회한다.
	    	doActionRetrieveSpecificReason();

	    	// 2. 파일첨부내용을 조회한다.
	    	doActionRetrieveAttachedFile();

	    	// 3.HISTORY 조회
	    	doActionRetrieveHistory();

		    checkComment();

	    	doInitFlg = "Y";	    	

			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				sheetObjects[1].RowStatus(i) = "R";
			}
	    }
	    else {
	    	doInit();
		    checkComment();
	    }	    

 		initBtnByAuth();
	}
	
	// Charge 삭제요청시 입력한 Specific Reason 을 조회한다.
	function doActionRetrieveSpecificReason() {
		
 		// Retrieve 실행
 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_SPECRSN);
	}
	
	// Charge 삭제요청시 첨부한 파일내역을 조회한다.
	function doActionRetrieveAttachedFile() {

 		// Retrieve 실행
 		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ATTACHED_FILE);
	}
	
	// Charge 삭제요청시 첨부한 파일내역을 조회한다.
	function doActionRetrieveHistory() {

 		// Retrieve 실행
 		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_HISTORY);
	}
	
	function doInit() {
 		var formObj = document.form;
 		var opener = window.dialogArguments;
 		var opnSheetObj = opener.document.form.sheet1;
 		var sheetObj = sheetObjects[1];
		var opnFormObj = opener.document.form;

 		
 		///////2016.08.03 rsnCd = "SLICEN" 추가와 함께 
		// 로직 명료화를 위해 변경 및 주석처리////////////////////////////////////////////////////////////////////////////
 		
// 		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
// 		//2011.11.29 OFC 추가
// 		//2016.07.27 Consignee, Notify 추가
// 		var sXml = ComMakeSearchXml(opnSheetObj, false, "chk", "svr_id|cntr_no|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bkg_no|ofc_cd|cntr_tpsz_cd|chg_type|fm_mvmt_dt|to_mvmt_dt|ft_cmnc_dt|ft_end_dt|bil_amt|org_chg_amt|fm_mvmt_sts_cd|to_mvmt_sts_cd|ofc_cd|fm_mvmt_yd_cd|to_mvmt_yd_cd|ofc_rhq_cd|fx_ft_ovr_dys|bkg_rcv_term_cd|bkg_de_term_cd|ch|ft_dys|bzc_trf_curr_cd|sc_no|rfa_no|cnee_cd|cnee_nm|ntfy_cd|ntfy_nm");
//
// 		//sheet2로 조회XML 로드하기
// 		sheetObj.LoadSearchXml(sXml, true);
// 		 		
// 		if (sheetObj.SearchRows == 0 ) {
// 			// by CNTR 화면에서 호출됨 
// 			var row = sheetObj.DataInsert(-1);
// 			var opnFormObj = opener.document.form;
// 			
// 			sheetObj.CellValue2(row, "svr_id")				= ComGetObjValue(opnFormObj.svr_id);
// 			sheetObj.CellValue2(row, "cntr_no") 			= ComGetObjValue(opnFormObj.cntr_no);
// 			sheetObj.CellValue2(row, "cntr_cyc_no")			= ComGetObjValue(opnFormObj.cntr_cyc_no);
// 			sheetObj.CellValue2(row, "dmdt_trf_cd")			= ComGetObjValue(opnFormObj.dmdt_trf_cd);
// 			sheetObj.CellValue2(row, "dmdt_chg_loc_div_cd")	= ComGetObjValue(opnFormObj.dmdt_chg_loc_div_cd);
// 			sheetObj.CellValue2(row, "chg_seq")				= ComGetObjValue(opnFormObj.chg_seq);
// 			sheetObj.CellValue2(row, "bkg_no")				= ComGetObjValue(opnFormObj.bkg_no);
// 			sheetObj.CellValue2(row, "ofc_cd")				= ComGetObjValue(opnFormObj.ofc_cd);
// 			sheetObj.CellValue2(row, "cntr_tpsz_cd")		= ComGetObjValue(opnFormObj.cntr_tpsz_cd);
// 			sheetObj.CellValue2(row, "chg_type")			= ComGetObjValue(opnFormObj.chg_type);
//
// 			sheetObj.CellValue2(row, "fm_mvmt_dt")			= ComGetObjValue(opnFormObj.fm_mvmt_dt);
// 			sheetObj.CellValue2(row, "to_mvmt_dt")			= ComGetObjValue(opnFormObj.to_mvmt_dt);
// 			sheetObj.CellValue2(row, "ft_cmnc_dt")			= ComGetObjValue(opnFormObj.ft_cmnc_dt);
// 			sheetObj.CellValue2(row, "ft_end_dt")			= ComGetObjValue(opnFormObj.ft_end_dt);
// 			sheetObj.CellValue2(row, "bil_amt")				= ComGetObjValue(opnFormObj.bil_amt);
// 			sheetObj.CellValue2(row, "org_chg_amt")			= ComGetObjValue(opnFormObj.org_chg_amt);
// 			sheetObj.CellValue2(row, "fm_mvmt_sts_cd")		= ComGetObjValue(opnFormObj.fm_mvmt_sts_cd);
// 			sheetObj.CellValue2(row, "to_mvmt_sts_cd")		= ComGetObjValue(opnFormObj.to_mvmt_sts_cd);
// 			sheetObj.CellValue2(row, "ofc_cd")				= ComGetObjValue(opnFormObj.ofc_cd);
// 			sheetObj.CellValue2(row, "fm_mvmt_yd_cd")		= ComGetObjValue(opnFormObj.fm_mvmt_yd_cd);
// 			sheetObj.CellValue2(row, "to_mvmt_yd_cd")		= ComGetObjValue(opnFormObj.to_mvmt_yd_cd);
// 			sheetObj.CellValue2(row, "ofc_rhq_cd")			= ComGetObjValue(opnFormObj.ofc_rhq_cd); 	
// 			sheetObj.CellValue2(row, "fx_ft_ovr_dys")		= ComGetObjValue(opnFormObj.fx_ft_ovr_dys); 	 			
// 			sheetObj.CellValue2(row, "bkg_rcv_term_cd")		= ComGetObjValue(opnFormObj.bkg_rcv_term_cd); 	 			
// 			sheetObj.CellValue2(row, "bkg_de_term_cd")		= ComGetObjValue(opnFormObj.bkg_de_term_cd); 	 			
// 			sheetObj.CellValue2(row, "ch")					= ComGetObjValue(opnFormObj.ch);	 			
// 			sheetObj.CellValue2(row, "ft_dys")				= ComGetObjValue(opnFormObj.ft_dys);	 			
// 			sheetObj.CellValue2(row, "bzc_trf_curr_cd")		= ComGetObjValue(opnFormObj.bzc_trf_curr_cd);	 			
// 			sheetObj.CellValue2(row, "sc_no")				= ComGetObjValue(opnFormObj.sc_no);	 			
// 			sheetObj.CellValue2(row, "rfa_no")				= ComGetObjValue(opnFormObj.rfa_no);	 			
// 			 			
// 			// 2016.07.27 Consignee, Notify 추가 
// 			sheetObj.CellValue2(row, "cnee_cd")				= ComGetObjValue(opnFormObj.cnee_cd);	 			
// 			sheetObj.CellValue2(row, "cnee_nm")				= ComGetObjValue(opnFormObj.cnee_nm);
// 			
// 			sheetObj.CellValue2(row, "ntfy_cd")				= ComGetObjValue(opnFormObj.ntfy_cd);
// 			sheetObj.CellValue2(row, "ntfy_nm")				= ComGetObjValue(opnFormObj.ntfy_nm);
//
// 		} else{
//			var opnFormObj = opener.document.form;
// 			
//			// Charge Calculation by Booking 의 경우 SC No, RFA No, Consignee, Notify 정보가
//			// IBSheet가 아닌 Form Input Object 안에 저장되기 때문에 ComMakeSearchXml를 통해 해당 데이터를 가져오지 못함 
//			// 따라서, 별도로 Form Input Object의 데이터를 가져오는 작업 필요
//			
// 			if ( ComGetObjValue(opnFormObj.ui_id) == "EES_DMT_3002" ){
//
// 				for (var i=sheetObj.TopRow; i < sheetObj.Rows; i++) {
// 					sheetObj.CellValue2(i, "sc_no")					= ComGetObjValue(opnFormObj.sc_no);	
// 					sheetObj.CellValue2(i, "rfa_no")				= ComGetObjValue(opnFormObj.rfa_no);	
//
// 					sheetObj.CellValue2(i, "cnee_cd")				= ComGetObjValue(opnFormObj.cnee_cd);	 			
// 					sheetObj.CellValue2(i, "cnee_nm")				= ComGetObjValue(opnFormObj.cnee_nm);
//
// 					sheetObj.CellValue2(i, "ntfy_cd")				= ComGetObjValue(opnFormObj.ntfy_cd);
// 					sheetObj.CellValue2(i, "ntfy_nm")				= ComGetObjValue(opnFormObj.ntfy_nm);
// 				}
// 			}
// 		}
 		
 		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		// by OFC,VVD 화면에서 호출
		var uiId = ComGetObjValue(opnFormObj.ui_id);
 		if (uiId == "EES_DMT_3001") {
 			
 			//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
 			//2011.11.29 OFC 추가
 			//2016.07.27 Consignee, Notify 추가
 			var sXml = ComMakeSearchXml(opnSheetObj, false, "chk", "svr_id|cntr_no|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bkg_no|ofc_cd|cntr_tpsz_cd|chg_type|fm_mvmt_dt|to_mvmt_dt|ft_cmnc_dt|ft_end_dt|bil_amt|org_chg_amt|fm_mvmt_sts_cd|to_mvmt_sts_cd|ofc_cd|fm_mvmt_yd_cd|to_mvmt_yd_cd|ofc_rhq_cd|fx_ft_ovr_dys|bkg_rcv_term_cd|bkg_de_term_cd|ch|ft_dys|bzc_trf_curr_cd|sc_no|rfa_no|cnee_cd|cnee_nm|ntfy_cd|ntfy_nm");

 			//sheet2로 조회XML 로드하기
 			sheetObj.LoadSearchXml(sXml, true);

 		// by BKG 화면에서 호출 			
 		} 
 		else if (uiId == "EES_DMT_3002") {

 			
 			var sXml = ComMakeSearchXml(opnSheetObj, false, "chk", "svr_id|cntr_no|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bkg_no|ofc_cd|cntr_tpsz_cd|chg_type|fm_mvmt_dt|to_mvmt_dt|ft_cmnc_dt|ft_end_dt|bil_amt|org_chg_amt|fm_mvmt_sts_cd|to_mvmt_sts_cd|ofc_cd|fm_mvmt_yd_cd|to_mvmt_yd_cd|ofc_rhq_cd|fx_ft_ovr_dys|bkg_rcv_term_cd|bkg_de_term_cd|ch|ft_dys|bzc_trf_curr_cd|sc_no|rfa_no|cnee_cd|cnee_nm|ntfy_cd|ntfy_nm");

 			//sheet2로 조회XML 로드하기
 			sheetObj.LoadSearchXml(sXml, true);
 			
 			// Charge Calculation by Booking 의 경우 SC No, RFA No, Consignee, Notify 정보가
 			// IBSheet가 아닌 Form Input Object 안에 저장되기 때문에 ComMakeSearchXml를 통해 해당 데이터를 가져오지 못함 
 			// 따라서, 별도로 Form Input Object의 데이터를 가져오는 작업 필요

			for (var i=sheetObj.TopRow; i < sheetObj.Rows; i++) {
				sheetObj.CellValue2(i, "sc_no")	  = ComGetObjValue(opnFormObj.sc_no);	
				sheetObj.CellValue2(i, "rfa_no")  = ComGetObjValue(opnFormObj.rfa_no);	

				sheetObj.CellValue2(i, "cnee_cd") = ComGetObjValue(opnFormObj.cnee_cd);	 			
				sheetObj.CellValue2(i, "cnee_nm") = ComGetObjValue(opnFormObj.cnee_nm);

				sheetObj.CellValue2(i, "ntfy_cd") = ComGetObjValue(opnFormObj.ntfy_cd);
				sheetObj.CellValue2(i, "ntfy_nm") = ComGetObjValue(opnFormObj.ntfy_nm);
			}
 			
 		  // by CNTR 화면에서 호출 
 		  } 
 		else if (uiId == "EES_DMT_3003") {
 			var row = sheetObj.DataInsert(-1);

 			sheetObj.CellValue2(row, "svr_id")				= ComGetObjValue(opnFormObj.svr_id);
 			sheetObj.CellValue2(row, "cntr_no") 			= ComGetObjValue(opnFormObj.cntr_no);
 			sheetObj.CellValue2(row, "cntr_cyc_no")			= ComGetObjValue(opnFormObj.cntr_cyc_no);
 			sheetObj.CellValue2(row, "dmdt_trf_cd")			= ComGetObjValue(opnFormObj.dmdt_trf_cd);
 			sheetObj.CellValue2(row, "dmdt_chg_loc_div_cd")	= ComGetObjValue(opnFormObj.dmdt_chg_loc_div_cd);
 			sheetObj.CellValue2(row, "chg_seq")				= ComGetObjValue(opnFormObj.chg_seq);
 			sheetObj.CellValue2(row, "bkg_no")				= ComGetObjValue(opnFormObj.bkg_no);
 			sheetObj.CellValue2(row, "ofc_cd")				= ComGetObjValue(opnFormObj.ofc_cd);
 			sheetObj.CellValue2(row, "cntr_tpsz_cd")		= ComGetObjValue(opnFormObj.cntr_tpsz_cd);
 			sheetObj.CellValue2(row, "chg_type")			= ComGetObjValue(opnFormObj.chg_type);

 			sheetObj.CellValue2(row, "fm_mvmt_dt")			= ComGetObjValue(opnFormObj.fm_mvmt_dt);
 			sheetObj.CellValue2(row, "to_mvmt_dt")			= ComGetObjValue(opnFormObj.to_mvmt_dt);
 			sheetObj.CellValue2(row, "ft_cmnc_dt")			= ComGetObjValue(opnFormObj.ft_cmnc_dt);
 			sheetObj.CellValue2(row, "ft_end_dt")			= ComGetObjValue(opnFormObj.ft_end_dt);
 			sheetObj.CellValue2(row, "bil_amt")				= ComGetObjValue(opnFormObj.bil_amt);
 			sheetObj.CellValue2(row, "org_chg_amt")			= ComGetObjValue(opnFormObj.org_chg_amt);
 			sheetObj.CellValue2(row, "fm_mvmt_sts_cd")		= ComGetObjValue(opnFormObj.fm_mvmt_sts_cd);
 			sheetObj.CellValue2(row, "to_mvmt_sts_cd")		= ComGetObjValue(opnFormObj.to_mvmt_sts_cd);
 			sheetObj.CellValue2(row, "ofc_cd")				= ComGetObjValue(opnFormObj.ofc_cd);
 			sheetObj.CellValue2(row, "fm_mvmt_yd_cd")		= ComGetObjValue(opnFormObj.fm_mvmt_yd_cd);
 			sheetObj.CellValue2(row, "to_mvmt_yd_cd")		= ComGetObjValue(opnFormObj.to_mvmt_yd_cd);
 			sheetObj.CellValue2(row, "ofc_rhq_cd")			= ComGetObjValue(opnFormObj.ofc_rhq_cd); 	
 			sheetObj.CellValue2(row, "fx_ft_ovr_dys")		= ComGetObjValue(opnFormObj.fx_ft_ovr_dys); 	 			
 			sheetObj.CellValue2(row, "bkg_rcv_term_cd")		= ComGetObjValue(opnFormObj.bkg_rcv_term_cd); 	 			
 			sheetObj.CellValue2(row, "bkg_de_term_cd")		= ComGetObjValue(opnFormObj.bkg_de_term_cd); 	 			
 			sheetObj.CellValue2(row, "ch")					= ComGetObjValue(opnFormObj.ch);	 			
 			sheetObj.CellValue2(row, "ft_dys")				= ComGetObjValue(opnFormObj.ft_dys);	 			
 			sheetObj.CellValue2(row, "bzc_trf_curr_cd")		= ComGetObjValue(opnFormObj.bzc_trf_curr_cd);	 			
 			sheetObj.CellValue2(row, "sc_no")				= ComGetObjValue(opnFormObj.sc_no);	 			
 			sheetObj.CellValue2(row, "rfa_no")				= ComGetObjValue(opnFormObj.rfa_no);	 			

 			// 2016.07.27 Consignee, Notify 추가 
 			sheetObj.CellValue2(row, "cnee_cd")				= ComGetObjValue(opnFormObj.cnee_cd);	 			
 			sheetObj.CellValue2(row, "cnee_nm")				= ComGetObjValue(opnFormObj.cnee_nm);

 			sheetObj.CellValue2(row, "ntfy_cd")				= ComGetObjValue(opnFormObj.ntfy_cd);
 			sheetObj.CellValue2(row, "ntfy_nm")				= ComGetObjValue(opnFormObj.ntfy_nm);
 		}

 		for (var i=sheetObj.TopRow; i < sheetObj.Rows; i++) {
 			sheetObj.RowStatus(i) = "I";
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
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 130;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 10, 100);

                     var HeadTitle1 = "|Seq.|Sel.|Reason|Specific Reason|Rsn. Code";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	false,	"chk",				false,	"",	dfNone, 0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    	   190,		daLeft,		true,	"rsn_desc",			false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,    	   390,		daLeft,		false,	"spec_rsn_desc",	false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,   	    45,		daCenter,	false,	"spec_rsn_cd",		false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"rsn_cd",			false,	"",	dfNone, 0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	 0,		daLeft,		false,	"file_atch_mdt_yn",	false,	"",	dfNone,	0,	false,  false);

 					CountPosition = 0;
             	 }
                 break;

             case 2:      // sheet2 init(hidden)
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 120;
               
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(64, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "||CNTR NBR|TPSZ|BKG NBR|DMT type|G/B|Over|From DT|To DT|F/T CMNC|F/TEnd|Billable AMT|1|2|3|4|5|6|7|8|9|Attachment|";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		20,		daCenter,	false,	"chk",					false,	"",	dfNone, 0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"cntr_no",				false,	"", dfEngUpKey,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cntr_tpsz_cd",			false,	"", dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	90,		daCenter,	true,	"bkg_no",				false,	"",	dfEngUpKey, 0,	false,  false);
					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	"dmdt_trf_cd",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	true,	"chg_type",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,	true,	"fx_ft_ovr_dys",		false,	"",	dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"fm_mvmt_dt",			false,  "",	dfDateYmd,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"to_mvmt_dt",			false,  "",	dfDateYmd,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"ft_cmnc_dt",			false,  "",	dfDateYmd,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"ft_end_dt",			false,  "",	dfDateYmd,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtData,	  	   100,		daRight,	true,	"bil_amt",				false,  "",	dfNullFloat,	2,	false,  false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_1_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_2_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_3_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_4_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_5_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_6_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_7_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_8_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_9_type",		false,  "",	dfNone,	0,	true,  true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_10_type",		false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,     	0,		daCenter,	true,	"ofc_cd",				false,	"",	dfNone, 0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"svr_id",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"cntr_cyc_no",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"dmdt_chg_loc_div_cd",	false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"chg_seq",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_1",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_2",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_3",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_4",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_5",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_6",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_7",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_8",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_9",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"dmdt_chg_delt_spec_rsn_cd",			false,  "",	dfNone,	0,	false,  false);	
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"delt_rmk",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"sts_cd",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"chg_delt_spec_rsn_rmk",false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"inact_rqst_no",		false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"inact_apro_no",		false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"delt_spec_rsn_rmk_seq",false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"delt_seq",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"chg_delt_sts_cd",		false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,       0,		daCenter,	true,	"chg_delt_usr_yn",    	false,	"",	dfNone, 0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daRight,	true,	"org_chg_amt",			false,	"",	dfNullFloat,	2,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	40,		daCenter,	true,	"fm_mvmt_sts_cd",		false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	40,		daCenter,	true,	"to_mvmt_sts_cd",		false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	80,		daCenter,	true,	"fm_mvmt_yd_cd",		false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	70,		daCenter,	true,	"to_mvmt_yd_cd",		false,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"ofc_rhq_cd",			false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"bkg_rcv_term_cd",		false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"bkg_de_term_cd",		false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"ch",					false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"bzc_trf_curr_cd",		false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"ft_dys",				false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"sc_no",				false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"rfa_no",				false,	"",	dfNone,	0,	false,  false);
					
					// 2016.07.27 Consignee, Notify 추가
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"cnee_cd",				false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"cnee_nm",				false,	"",	dfNone,	0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"ntfy_cd",				false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	80, 	daCenter,	true,	"ntfy_nm",				false,	"",	dfNone,	0,	false,  false);
					
					//bkg_de_term_cd
										
					FrozenCols = 3;
					
					InitDataCombo(0,"dmdt_trf_cd"," |DTOC|DMOF|CTOC|DMIF|DTIC|CTIC"," |DTOC|DMOF|CTOC|DMIF|DTIC|CTIC");
					InitDataCombo(0,"chg_type"," |G|B"," |G|B");
             }
               break;
               
             case 3:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 80;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

             		// 전체Edit 허용 여부 [선택, Default false]
             		Editable = true;

             		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             		InitRowInfo(1, 1, 3, 100);

             		var HeadTitle = "|Sel.|File Name|File Size";
             		
             		var headCount = ComCountHeadTitle(HeadTitle) + 2;
             		
             		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             		InitColumnInfo(headCount, 0, 0, true);

             		// 해더에서 처리할 수 있는 각종 기능을 설정한다
             		InitHeadMode(true, true, true, true, false, false)

             		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             		InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             		InitDataProperty(0, cnt++, dtHiddenStatus, 	  0, 	daCenter, true, 	PREFIX + "ibflag");
             		InitDataProperty(0, cnt++, dtCheckBox, 		 40, 	daCenter, true, 	PREFIX + "del_chk", 	false, "", dfNone, 0, true, true);
             		InitDataProperty(0, cnt++, dtPopup, 		400,   	  daLeft, false, 	PREFIX + FILE_NM, 		false, "", dfNone, 0, false, false);
             		InitDataProperty(0, cnt++, dtData, 			 50, 	daCenter, false, 	PREFIX + FILE_SIZE, 	false, "", dfNone, 0, false, false);
             		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	PREFIX + FILE_PATH);
             		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	PREFIX + FILE_SAV_ID);
                 }
                 break;                 

             case 4:
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 80;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 7, 100);

 					var HeadTitle1 = "|Seq.|Status|Date|Office|Name";
                     var headCount = ComCountHeadTitle(HeadTitle1) + 1;

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq, 	  		30,		daCenter,		false,		"Seq");
 					InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,		false,		"inact_sts_desc",			false,	"",		dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,   		80,		daCenter,		false,		"inact_dt",			false,	"",		dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,		false,		"inact_ofc_cd",		false,	"",		dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,   		100,	daLeft,			false,		"inact_usr_nm",		false,	"",		dfNone,		0,	false,	false);
 					InitDataProperty(0, cnt++ , dtHidden,  		0,		daLeft,			false,		"inact_rmk",			false,	"",		dfNone,		0,	false,	false);
 					
 					CountPosition = 0;
 			}
 			break;
         } // switch end
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
            	ComSetObjValue(formObj.f_cmd, SEARCH);
 				sheetObj.DoSearch("EES_DMT_3104GS.do", FormQueryString(formObj));
 			break;

            case IBSEARCH_DETAIL:      //조회
            	ComSetObjValue(formObj.f_cmd, SEARCH01);
            	var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", FormQueryString(formObj));
            	
            	var nDtlRsnMdtRows = 0;
				//4.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
            	for (var i=REASON_DETAIL_START; i<=REASON_DETAIL_END; i++) {
            		
            		var prefix = "detail_" + i;

            		var rsnFieldName   = prefix + "_rsn_field_name";
            		var rsnFieldType   = prefix + "_rsn_field_type";
            		var rsnFieldSize   = prefix + "_rsn_field_size";
            		var rsnFieldFormat = prefix + "_rsn_field_format";
            		var rsnFieldItem   = prefix + "_rsn_field_item";
            		var rsnFieldCond   = prefix + "_rsn_field_cond";
            		var rsnFieldPopup  = prefix + "_rsn_field_popup";
            		var rsnFieldValue  = prefix + "_rsn_field_value";

					var fieldName   = ComGetEtcData(sXml, rsnFieldName);
					var fieldType   = ComGetEtcData(sXml, rsnFieldType);
					var fieldSize   = ComGetEtcData(sXml, rsnFieldSize);
					var fieldFormat = ComGetEtcData(sXml, rsnFieldFormat);
					var fieldItem   = ComGetEtcData(sXml, rsnFieldItem);
					var fieldCond   = ComGetEtcData(sXml, rsnFieldCond);
					var fieldPopup  = ComGetEtcData(sXml, rsnFieldPopup);
					var fieldValue  = ComGetEtcData(sXml, rsnFieldValue);

					if (typeof(fieldName) != 'undefined') {
						nDtlRsnMdtRows++;

						ComSetObjValue(eval("formObj.h_" + rsnFieldName),   fieldName);
						ComSetObjValue(eval("formObj.h_" + rsnFieldType),   fieldType);
						ComSetObjValue(eval("formObj.h_" + rsnFieldSize),   fieldSize);
						ComSetObjValue(eval("formObj.h_" + rsnFieldFormat), fieldFormat);
						ComSetObjValue(eval("formObj.h_" + rsnFieldItem),   fieldItem);
						ComSetObjValue(eval("formObj.h_" + rsnFieldCond),   fieldCond);
						ComSetObjValue(eval("formObj.h_" + rsnFieldPopup),  fieldPopup);
						ComSetObjValue(eval("formObj.h_" + rsnFieldValue),  fieldValue);
					}
					else {
						ComSetObjValue(eval("formObj.h_" + rsnFieldName),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldType),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldSize),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldFormat), "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldItem),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldCond),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldPopup),  "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldValue),  "");
					}
            	}
            	ComSetObjValue(formObj.h_detail_rsn_mandatory_rows, nDtlRsnMdtRows);
 			break; 			
 			
            case IBSAVE:        //저장
    			// 1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			var sParam = ComGetSaveString(sheetObj);
    			if (sParam == "") return;
    			sParam += "&" + ComGetSaveString(sheetObjects[2]);
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PREFIX) +  "&file_flg=" + fileFlg;
				
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
	        	// 2.저장조건으로 저장실행
	        	var sXml = sheetObj.GetSaveXml("EES_DMT_3104GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);	        	

        		// 3.저장 성공시 후처리
				ComOpenWait(false);
				if (saveFlag == "Y") {
					var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					var rqstNo = ComGetEtcData(sXml, "RQST_NO");

					formObj.inact_rqst_no.value = rqstNo;
					formObj.inact_sts_cd.value = "Request";
					ComShowCodeMessage("DMT00007");
					doActionOpenerRetrieve();
				}
       		break;
       		
            case IBSAVE_FILEUPLOAD:
    			// 1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			var sParam = ComGetSaveString(sheetObj);
    			if (sParam == "") return;
    			sParam += "&" + ComGetSaveString(sheetObjects[2]);
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PREFIX) +  "&file_flg=" + fileFlg;
				
    			ComOpenWait(true, true); // 키보드나 마우스를 대기상태 & 대기이미지
    			
//				// 2.저장조건으로 저장실행
//				var uploadObj = uploadObjects[0];
//				uploadObj.ExtendParam = sParam; // param값 추가
////				
//				uploadObj.ParamDecoding = true;
//				var sXml = uploadObj.DoUpload(true);
//				sheetObj.LoadSaveXml(sXml);
    			
    			
	        	// 2.저장조건으로 저장실행 - 2016.08.08 : IBUPLOAD로 File Save를 우선 완료하는 로직으로 변경 
	        	var sXml = sheetObj.GetSaveXml("EES_DMT_3104GS.do", sParam);
	        	sheetObj.LoadSaveXml(sXml);	  
						
        		// 3.저장 성공시 후처리
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				var rqstNo = ComGetEtcData(sXml, "RQST_NO");
				ComOpenWait(false);
							
				if (result == "S") {
					formObj.inact_rqst_no.value = rqstNo;
					formObj.inact_sts_cd.value = "Request";
					ComShowCodeMessage("DMT00007");
					doActionOpenerRetrieve();
				}
            break;
            
            case IBSEARCH_ATTACHED_FILE:
	 			// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
	 			ComSetObjValue(formObj.f_cmd, SEARCH);	 			

            	formObj.svr_id.value 				= sheetObjects[1].CellValue(1,"svr_id");
            	formObj.sys_area_grp_id.value 		= sheetObjects[1].CellValue(1,"svr_id");
            	formObj.cntr_no.value 				= sheetObjects[1].CellValue(1,"cntr_no");
            	formObj.cntr_cyc_no.value 			= sheetObjects[1].CellValue(1,"cntr_cyc_no");
            	formObj.dmdt_trf_cd.value 			= sheetObjects[1].CellValue(1,"dmdt_trf_cd");
            	formObj.dmdt_chg_loc_div_cd.value 	= sheetObjects[1].CellValue(1,"dmdt_chg_loc_div_cd");
            	formObj.chg_seq2.value 				= sheetObjects[1].CellValue(1,"chg_seq");
            	formObj.chg_ofc_cd.value 			= sheetObjects[1].CellValue(1,"ofc_cd");
            	formObj.delt_seq.value 				= sheetObjects[1].CellValue(1,"delt_seq");

	 			var param = FormQueryString(formObj) + "&chg_seq=" + ComGetObjValue(formObj.chg_seq2) + "&" + ComGetPrefixParam(PREFIX);
	 			// 2.조회조건으로 조회실행
	 			var sXml = sheetObj.GetSearchXml("EES_DMT_7019GS.do", param);
	 			
	 			// 3.조회결과 바인딩
	 			sheetObj.LoadSearchXml(sXml);
	 			
	 			// 4.값 존재시 처리
	 			if (sheetObj.RowCount > 0) {
	 				//size 변경하기 
	 				for (var row = 1; row <= sheetObj.LastRow; row++) {
	 					var size = getSize(sheetObj.CellValue(row, PREFIX + FILE_SIZE));
	 					sheetObj.CellValue(row, PREFIX + FILE_SIZE) = size;
	 				}
	 			}
            break; 
            
            case IBSEARCH_SPECRSN:

         		ComSetObjValue(formObj.f_cmd, SEARCH02);
            	
            	var param = FormQueryString(formObj) + "&chg_seq=" + ComGetObjValue(formObj.chg_seq2);
 				sheetObj.DoSearch("EES_DMT_3104GS.do", param);     
 				
 				fileFlg = "N";

            break;
            
            case IBSEARCH_HISTORY:

            	ComSetObjValue(formObj.f_cmd, SEARCH03);
            	
            	formObj.svr_id.value 				= sheetObjects[1].CellValue(1,"svr_id");
            	formObj.sys_area_grp_id.value 		= sheetObjects[1].CellValue(1,"svr_id");
            	formObj.cntr_no.value 				= sheetObjects[1].CellValue(1,"cntr_no");
            	formObj.cntr_cyc_no.value 			= sheetObjects[1].CellValue(1,"cntr_cyc_no");
            	formObj.dmdt_trf_cd.value 			= sheetObjects[1].CellValue(1,"dmdt_trf_cd");
            	formObj.dmdt_chg_loc_div_cd.value 	= sheetObjects[1].CellValue(1,"dmdt_chg_loc_div_cd");
            	formObj.chg_seq2.value 				= sheetObjects[1].CellValue(1,"chg_seq");
            	formObj.chg_ofc_cd.value 			= sheetObjects[1].CellValue(1,"ofc_cd");
            	formObj.delt_seq.value 				= sheetObjects[1].CellValue(1,"delt_seq");
            	
            	var param = FormQueryString(formObj) + "&chg_seq=" + ComGetObjValue(formObj.chg_seq2);
 				sheetObj.DoSearch("EES_DMT_3104GS.do", param);

            break;

  			case IBDELREQCANCEL:	// Deletion Cancel 에서 기능개선으로 Delete Request Cancel 로 변경됨. 2015.02.14
 				 if (!validateForm(sheetObj,formObj,sAction)) return;

 				 // 서버로 전달할 매개변수 세팅
 				 ComSetObjValue(formObj.f_cmd, MULTI01);
 					 
 	 			sheetObj.WaitImageVisible=false;
 	     		ComOpenWait(true);
 	     		
 	     		var sParam = ComGetSaveString(sheetObj);
 	     		sParam += "&" + FormQueryString(formObj);
 	     		
 	     		sheetObj.DoSave("EES_DMT_3104GS.do", FormQueryString(formObj),"chk");
 				ComOpenWait(false);
 				
 				if (saveFlag == "Y") {
					formObj.inact_sts_cd.value = "Cancel";	
					ComShowCodeMessage("DMT00007");
					doActionOpenerRetrieve();
				}
 	            break;
 	            
  			 case IBDELSAVE:        //저장 (Approval, Reject)
           		// 입력값에 대한 Validation Check
           		if (!validateForm(sheetObj, formObj, sAction)) return;
           		
           		setChgDeltStsCd(chgDeltStsCd);
           		
          	   //1. 저장조건 설정          		
           		ComSetObjValue(formObj.f_cmd, MULTI02);

 		       	//2.저장실행
 				//*********************************************************************************
 				ComOpenWait(true);
 				sheetObj.WaitImageVisible = false;
 				//*********************************************************************************		

    			var sParam = ComGetSaveString(sheetObj);
    			if (sParam == "") return;
    			sParam += "&" + ComGetSaveString(sheetObjects[2]);
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PREFIX) +  "&file_flg=" + fileFlg;
				
	        	var sXml = sheetObj.GetSaveXml("EES_DMT_3104GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);

 				var apvlNo = ComGetEtcData(sXml, "APVL_NO");
 				var stsCd = ComGetEtcData(sXml, "STS_CD");		
 				
 				//*********************************************************************************
 				ComOpenWait(false);
 				//*********************************************************************************
				if (saveFlag == "Y") {
	 				formObj.inact_apro_no.value = apvlNo;
					formObj.inact_sts_cd.value = stsCd;	
					ComShowCodeMessage("DMT00007");
					doActionOpenerRetrieve();
				}
 		     break; 		     

	         case IBSEARCH_DELTPATH:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, SEARCH04); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj));
	        	 
	        	 //3.조회후 결과처리
	        	 ComSetObjValue(formObj.chg_delt_path_cd, ComGetEtcData(sXml, "CHG_DELT_PATH_CD"));
	         break;	     

	         case IBSEARCH_BKGVVD:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, SEARCH04); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", FormQueryString(formObj));

	        	 //3.조회후 결과처리
	        	 if (vvd_flg == "Y"){
	        		 var dmdt_inv_flg = ComGetEtcData(sXml, "VVD_FLG");
	        		 if ( dmdt_inv_flg == "N" ){
	        			 ComShowCodeMessage('DMT03028', "VVD");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
	        		 }
	        	 } else
	        	 if (curr_flg == "Y"){
	        		 var curr_cd = ComGetEtcData(sXml, "CURR_CD");
	        		 if ( curr_cd == "E" ){
	        			 ComShowCodeMessage('DMT03028', "Curr.");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
	        		 }
	        	 } 
	        	 else if (spec_rsn_cd == "ERNBSD"){
	        		 var rd_term_cd = ComGetEtcData(sXml, "RD_TERM_CD");
	        		 if ( ComTrim(rd_term_cd) == "" || ComTrim(rd_term_cd) == "E" ){
	        			 ComShowCodeMessage('DMT03028', "BKG No.");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
	        		 }
	        	 } 
	        	 else if (spec_rsn_cd == "SMRSWC"){
	        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = ComGetEtcData(sXml, "VVD_CD");
	        	 } else if (spec_rsn_cd == "SMRVST"){
	        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = ComGetEtcData(sXml, "RD_TERM_CD");
	        	 } else if ( spec_rsn_cd == "ERCEDI" || spec_rsn_cd == "ERCDCA" || spec_rsn_cd == "SLINIK" || spec_rsn_cd == "SLIHPP" ){
	        		 var dmdt_inv_flg = ComGetEtcData(sXml, "DMDT_INV_FLG");
	        		 if ( dmdt_inv_flg == "N" ){
	        			 alert("Invoice was already Cancelled");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
	        		 } else if ( dmdt_inv_flg == "E" ){
	        			 ComShowCodeMessage('DMT00165', "INV No.");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
	        		 }
	        	 } else if ( spec_rsn_cd == "SLIBCD" ){
	        		 var dmdt_inv_flg = ComGetEtcData(sXml, "DMDT_INV_FLG");
	        		 if ( dmdt_inv_flg == "N" ){
	        			 alert("Invoice was already Cancelled");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_6_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_7_type") = "";
	        		 } else if ( dmdt_inv_flg == "E" ){
	        			 ComShowCodeMessage('DMT00165', "INV No.");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_6_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_7_type") = "";
	        		 } else {
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_6_type") = ComGetEtcData(sXml, "INV_CURR_CD");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_7_type") = ComGetEtcData(sXml, "INV_CHG_AMT");
	        		 }
	        	 } else if ( spec_rsn_cd == "SOCDP" ){
	        		 var soc_flg = ComGetEtcData(sXml, "SOC_FLG");
	        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = ComGetEtcData(sXml, "SOC_FLG");
	        		 sheetObj.CellEditable(spec_rsn_cd_row, "detail_1_type") = false;
	        	 } else if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") == "CBDBBT" ){
	        		 var ots_sts_nm = ComGetEtcData(sXml, "OTS_STS_NM");
	        		 if ( ots_sts_nm != "Closed" ) {
		        		 alert("TPB STATUS IS NOT CLOSED");
//						 clearDetailReason();
		        		 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = "";
	        		 } else {
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = ComGetEtcData(sXml, "OTS_STS_NM");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = ComGetEtcData(sXml, "OTS_CURR_CD");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = ComGetEtcData(sXml, "OTS_INV_AMT");
	        		 }
	        	 } else if ( spec_rsn_cd == "WTMIC" ){
	        		 var dmdt_inv_flg = ComGetEtcData(sXml, "DMDT_INV_FLG");
	        		 if ( dmdt_inv_flg == "N" ){
	        			 alert("Invoice was already Cancelled");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_5_type") = "";
	        		 } else if ( dmdt_inv_flg == "E" ){
	        			 ComShowCodeMessage('DMT00165', "INV No.");
	        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_5_type") = "";
	        		 } else {
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = ComGetEtcData(sXml, "INV_PAY_CD");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = ComGetEtcData(sXml, "INV_PAY_NM");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = ComGetEtcData(sXml, "INV_CURR_CD");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_5_type") = ComGetEtcData(sXml, "INV_CHG_AMT");
	        		 }
	        	 } else if ( spec_rsn_cd == "SLISIA" ){
	        		 var dmdt_inv_flg = ComGetEtcData(sXml, "DMDT_INV_FLG");
	        		 if ( dmdt_inv_flg == "N" ){
	        			 alert("Invoice was already Cancelled");
	        			 if ( dtType == "detail_1_type"){
	        				 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = "";
		        		 } else if ( dtType == "detail_5_type"){
	        				 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_6_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_7_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_8_type") = "";
		        		 } 
	        		 } else if ( dmdt_inv_flg == "E" ){
	        			 ComShowCodeMessage('DMT00165', "INV No.");
	        			 if ( dtType == "detail_1_type"){
	        				 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = "";
		        		 }  else if ( dtType == "detail_5_type"){
	        				 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_6_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_7_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_8_type") = "";
		        		 } 
	        		 } else {
		        		 if ( dtType == "detail_1_type"){
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = ComGetEtcData(sXml, "INV_PAY_CD");
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = ComGetEtcData(sXml, "INV_CURR_CD");
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = ComGetEtcData(sXml, "INV_CHG_AMT");
		        		 } else if ( dtType == "detail_5_type"){
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_6_type") = ComGetEtcData(sXml, "INV_PAY_CD");
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_7_type") = ComGetEtcData(sXml, "INV_CURR_CD");
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_8_type") = ComGetEtcData(sXml, "INV_CHG_AMT");
		        		 }
	        		 }
	        	 } else if ( spec_rsn_cd == "CBDAOB" ){
	        		 if ( ComGetEtcData(sXml, "AR_CURR_CD") != "E"){
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = ComGetEtcData(sXml, "AR_CHG_CD");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = ComGetEtcData(sXml, "AR_CURR_CD");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = ComGetEtcData(sXml, "AR_CHG_AMT");
	        		 } else {
	        			 alert("DMR / DTC / CDD was not manifested on this BL.");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = 0;
	        		 }
	        	 }
	        	 else if (spec_rsn_cd == "LPIEGI"){
	        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = ComGetEtcData(sXml, "VVD_CD");
	        	 }  else if ( sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") == "SLIWCE" && colName == 'detail_4_type' ){
	        		 var ots_sts_nm = ComGetEtcData(sXml, "OTS_STS_NM");
	        		 if ( ots_sts_nm != "Closed" ) {
		        		 alert("TPB STATUS IS NOT CLOSED");
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_4_type") = "";
	        		 }
	        	 }
	        	 
	        	 if( spec_rsn_cd == "LPIEPH" ){
	        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = ComGetEtcData(sXml, "SVC_SCP_CD");
	        		 sheetObj.CellEditable(spec_rsn_cd_row, "detail_3_type") = false;
	        	 }
	        	 
	        	 if( ( spec_rsn_cd == "SLIWCE" && colName != 'detail_4_type' ) || spec_rsn_cd == "SLIWCR" ){
	        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = ComGetEtcData(sXml, "MTY_PKUP_YD_CD");
	        	 }
	        	 
	     		if( spec_rsn_cd == "SLISPA" ){
	     			
	        		 sheetObj.CellEditable(spec_rsn_cd_row, "detail_1_type") = false;
	        		 sheetObj.CellEditable(spec_rsn_cd_row, "detail_2_type") = false;
	        		 sheetObj.CellEditable(spec_rsn_cd_row, "detail_3_type") = false;
	        		 
	        		 if ( spec_rsn_cd_col != "detail_4_type" ){
		        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_1_type") = ComGetEtcData(sXml, "CTRT_NO");
		        		 if ( ComGetEtcData(sXml, "CTRT_CUST_CD") != "E"){
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = ComGetEtcData(sXml, "CTRT_CUST_CD");
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = ComGetEtcData(sXml, "CTRT_CUST_NM");
		        		 } else {
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_2_type") = "";
			        		 sheetObj.CellValue2(spec_rsn_cd_row, "detail_3_type") = "";
		        		 }
	        		 } else
	        		 if ( spec_rsn_cd_col == "detail_4_type" ){
		        		 var dmdt_inv_flg = ComGetEtcData(sXml, "DMDT_INV_FLG");
		        		 if ( dmdt_inv_flg == "N" ){
		        			 alert("Invoice was already Cancelled");
		        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 } else if ( dmdt_inv_flg == "E" ){
		        			 ComShowCodeMessage('DMT00165', "INV No.");
		        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        		 }
	        		 }
	        	 }
	        	 
	         break;
	         

	    	//Location 을 조회한다.
	    	case IBSEARCH_LOC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, COMMAND07);

				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var locCd = ComGetEtcData(sXml, "LOC_CD");
				
        		 if ( locCd == "" ){
        			 ComShowCodeMessage('DMT03028', "Prot Code");
        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
        		 }
				break;

	    	//Location 을 조회한다.
	    	case IBSEARCH_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.

				sheetObj.ShowDebugMsg = false;
		        sheetObj.WaitImageVisible = false;
		        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));

		        if(cust_len == 0){
		        	ComSetObjValue(formObj.s_cust_gubun, "");
		            ComSetObjValue(formObj.s_cust_cd, "");
		            sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		        	return;
		        }
		       
		        if(cust_len > 2) {
					var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
					//2자리가 영문자이면 CUSTOMER 조회
					if(ComIsAlphabet(char_chk)) {
						ComSetObjValue(formObj.s_cust_gubun, "2");
					//아니면 VENDOR 조회
					}else{
						ComSetObjValue(formObj.s_cust_gubun, "1");
					}
				}else{
					ComShowCodeMessage("DMT00165", "Payer");
					ComSetObjValue(formObj.s_cust_gubun, "");
		            ComSetObjValue(formObj.s_cust_cd, "");
		            sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
					return;
				}

				ComSetObjValue(formObj.f_cmd, SEARCH20);

		        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		        var custCd = ComGetEtcData(sXml, "PAYER_CODE");
		        var custNm = ComGetEtcData(sXml, "PAYER_NM");
		        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
		        
		        if(custNm == null || custNm == "" || custNm == undefined) {
		            document.form.s_cust_gubun.value = "";
		            document.form.s_cust_cd.value = "";
		            sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
		            ComShowCodeMessage("DMT00165", "Payer");
		        } else {
		        	sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = custCd;
		        	switch(spec_rsn_cd) {
			        	case "SLINIK":
			        	case "SLIHPP":
			        		sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col+1) = custNm;
			        		break;
		        	}
		        }
		        sheetObj.WaitImageVisible = true;
		        
				break;
         }
     }

    // 저장 성공시 후처리
	function doActionOpenerRetrieve() {
		var opener = window.dialogArguments;
		if ( document.form.tab_cd.value == 'P')
			opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		else if ( document.form.tab_cd.value == 'S')
			opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, IBSEARCH);
		else if ( document.form.tab_cd.value == 'A')
			opener.doActionIBSheet(opener.sheetObjects[2], opener.document.form, IBSEARCH);

		self.close();
	}
	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj) {
        	 switch(sAction) {
		         case IBSAVE:
		        	var sheetObj1 = sheetObjects[0];
		        	var sheetObj2 = sheetObjects[1];
		        	var user_ofc = formObj.upd_ofc_cd.value;
		        	
		        	// 아래 Reason Code의 경우 detail 없는 경우에도 Pass
		        	if(sheetObj2.ColHidden("detail_1_type") 
		        			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") != "LPIUDI"
		        			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") != "LPIUDC"
		        			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") != "SLIVUC" 
		        			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") != "SLICRM" // 2016.09.05 Wonki Eo 추가
		        			//&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") != "ERGHCR" // 2016.09.05 Wonki Eo 추가
		        			//==============================================================================================================
		        			// CSR #2839 [DMT] USLGB DMIF 일괄 Inactivation 처리를 위한 Specifir Reason Code 생성 요청에 따른 조건 생략!!
	        				//==============================================================================================================
		        			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd") != "LPINCU"
		        			//==============================================================================================================
		        	){
		        		ComShowCodeMessage('DMT02002', "Item");
						return false;
		        	}

					var rsnCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd");

		        	// Login User ofc와 charge ofc 다를때 Request 못하도록 함. 2011.11.29 Kim HyunHwa 
		    		for (var i=1; i <= sheetObj2.Rowcount; i++) {

						var chg_ofc = sheetObj2.CellValue(i, "ofc_cd");
						if (chg_ofc != user_ofc) {
							ComShowCodeMessage('DMT01157');
							return false;		
						}

						if (!sheetObj2.ColHidden("detail_1_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_1_type")) == ""){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_1_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}
						}
						if (!sheetObj2.ColHidden("detail_2_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_2_type")) == ""){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_2_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_3_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_3_type")) == ""){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_3_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_4_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_4_type")) == "" && rsnCd != "SLICEN"  && rsnCd != "SLISPA"){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_4_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_5_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_5_type")) == "" && rsnCd != "SLISIA" && rsnCd != "SLICEN" ){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_5_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_6_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_6_type")) == "" && rsnCd != "SLISIA" && rsnCd != "SLICEN" ){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_6_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_7_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_7_type")) == "" && rsnCd != "SLISIA" && rsnCd != "SLICEN" ){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_7_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_8_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_8_type")) == "" && rsnCd != "SLISIA" && rsnCd != "SLICEN" ){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_8_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}
						if (!sheetObj2.ColHidden("detail_9_type")){
							if (ComTrim(sheetObj2.CellValue(i,"detail_9_type")) == "" ){
								ComShowCodeMessage('DMT01064', sheetObj2.CellText(0,"detail_9_type"), sheetObj2.CellValue(i,"cntr_no"));
								return false;		
							}							
						}

						 switch(rsnCd) {
						 	case "SLIDTO":
						 		if ( sheetObjects[1].CellValue(i,'ofc_rhq_cd') != "HAMRU" ){
									ComShowCodeMessage('DMT05014','Office(HAMRU)');
									return false;
								}
						 		if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
									ComShowCodeMessage('DMT05014','OP, MT');
									return false;
								}
						 		break;
						 	case "DMGOMC":
						 	case "SLIOMC":
						 		if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
									ComShowCodeMessage('DMT05014','OP, MT');
									return false;
								}
						 		break;
						 	case "CREFXT":
								if ( sheetObjects[1].CellValue(i,'ofc_cd') != "FXTSC" ){
									ComShowCodeMessage('DMT05014','Office(FXTSC)');
									return false;
								} else if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC" ){
									ComShowCodeMessage('DMT05014','DTIC');
									return false;
								}
						 		break;
						 	case "WTMIC":
									if ( sheetObjects[1].CellValue(i,'fm_mvmt_yd_cd').substring(0,2) != "DZ" && sheetObjects[1].CellValue(i,'to_mvmt_yd_cd').substring(0,2) != "DZ" ){
										alert("PLEASE RECHEK YARD CODE");
										return false;
									}
						 		break;
						 		
						 	case "CBDBBT":
									if(!(sheetObjects[1].CellValue(i,'ofc_cd') == "FXTSC"||sheetObjects[1].CellValue(i,'ofc_cd') == "GOASC" )){
										ComShowCodeMessage('DMT00165','Office(FXTSC, GOASC)');
										return false;
									}
									if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
										ComShowCodeMessage('DMT00165','OP, MT');
										return false;
									}
									if ( sheetObjects[1].CellValue(i,'detail_2_type') != "Closed" ) {
						        		 alert("TPB STATUS IS NOT CLOSED");
										return false;										
									}									
								break;
								
						 	case "CRESTT":
									if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC" ){
										ComShowCodeMessage('DMT00165','CTIC, DTIC');
										return false;	
									}
								break;
						 	case "SOCDP":
								if ( sheetObjects[1].CellValue(i,'detail_1_type') != "Yes" ){
									ComShowCodeMessage('DMT01184','Soc Flag');
									return false;										
								}
						 		break;
						 	case "SMRVST":
								if ( !(sheetObjects[1].CellValue(i,'detail_1_type') == "D" && sheetObjects[1].CellValue(i,'detail_2_type') == "Yes") ){
									ComShowCodeMessage('DMT01184','DOOR and H/T');
									return false;										
								}
						 		break;
						 		
						 	case "LPIIEK":
								if( sheetObjects[1].CellValue(i,'ofc_cd') != "MBABA" && sheetObjects[1].CellValue(i,'ofc_cd') != "DARBA" ){
									ComShowCodeMessage('DMT00165','Office(MBABA, DARBA)');
									return false;
								}								
								break;
								
						 	case "LPIUDC":
						 		if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTOC"){
									ComShowCodeMessage('DMT00165',sheetObjects[1].CellValue(i,'dmdt_trf_cd'));
									return false;	
								}
						 		if(!(sheetObjects[1].CellValue(i,'ofc_cd') != "SLCBA")){
						 			ComShowCodeMessage('DMT00165','Office(' + sheetObjects[1].CellValue(i,'ofc_cd') + ')');
						 			return false;
						 		}								
						 		break;
						 		
						 	case "SLIFSD":
						 		// CHECK CTRT CUSTOMER
								var sc_no = sheetObjects[1].CellValue(i, 'sc_no');
					        	ComSetObjValue(formObj.f_cmd, SEARCH20);
					        	var param = FormQueryString(formObj) + "&sc_no=" + sc_no;
					        	var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", param);
					        	if(ComGetEtcData(sXml, "cust_yn") == 'N') {
					        		ComShowCodeMessage('DMT00165','SC No. or Customer');
						 			return false;
					        	}
						 		// CHECK Invoice Cancel Status 						 		
						 		var inv_no = sheetObjects[1].CellValue(i, 'detail_3_type');
					        	ComSetObjValue(formObj.f_cmd, SEARCH21);
					        	var param = FormQueryString(formObj) + "&inv_no=" + inv_no;
					        	var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", param);
					        	var cancel_flg = ComGetEtcData(sXml, "CANCEL_FLG");
					        	if(cancel_flg == 'Y') {
					        		ComShowCodeMessage('DMT01189');
						 			return false;
					        	} else if (cancel_flg == 'X') {
					        		ComShowCodeMessage('DMT00165','Manual Invoice No.');
						 			return false;
					        	}
					        	
					        	break;
					        	
					        // 2016.08.02 추가 	
						 	case "SLICEN":
						 		// Approved Free Time
						 								 		
						 		// CHECK Invoice Cancel Status 						 		
						 		var inv_no = sheetObjects[1].CellValue(i, 'detail_4_type');
						 		
						 		// MANUAL_INV_NO 가 입력되지 않은 경우도 Request 가능하며
						 		// 만약 입력 될 경우 Validation Check 하도록 수정
						 		// 2016.08.09 Eidted
						 		if(inv_no != ''){
						        	ComSetObjValue(formObj.f_cmd, SEARCH21);
						        	var param = FormQueryString(formObj) + "&inv_no=" + inv_no;
						        	var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", param);
						        	var cancel_flg = ComGetEtcData(sXml, "CANCEL_FLG");
						        	if(cancel_flg == 'Y') {
						        		ComShowCodeMessage('DMT01189');
							 			return false;
						        	} else if (cancel_flg == 'X') {
						        		ComShowCodeMessage('DMT00165','Manual Invoice No.');
							 			return false;
						        	}			     	      
						 		}
						 		
					        	break;
					        	
						 	case "SLIKRG":

					        	if(sheetObjects[1].CellValue(i, 'detail_1_type') == '') {					
									sheetObjects[1].CellValue(i, 'detail_1_type') = sheetObjects[1].CellValue(i, 'sc_no');
								}

								ComSetObjValue(formObj.temp_bkg_no,  sheetObjects[1].CellValue(i,'bkg_no') );
								ComSetObjValue(formObj.temp_cntr_no,  sheetObjects[1].CellValue(i,'cntr_no') );
								ComSetObjValue(formObj.temp_cntr_cyc_no,  sheetObjects[1].CellValue(i,'cntr_cyc_no') );
								// OC Date 조회 로직 실행
								ComSetObjValue(formObj.f_cmd, SEARCH22);
					        	// 조회조건으로 조회실행 
								var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", FormQueryString(formObj));
								var oc_dt = ComGetEtcData(sXml, "OC_DT") ; 

								// DTIC or CTIC 일 경우만 가능
								if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC"){
									ComShowCodeMessage('DMT00165','DTIC, CTIC');
									clearDetailReason();
									return false;	
								// SC No = "AEN110754" 일 경우만 가능
								}else if ( sheetObjects[1].CellValue(i,'detail_1_type') != "AEN110754"){
									ComShowCodeMessage('DMT00165','SC No(AEN110754)');
									clearDetailReason();
									return false;
									
//								     * 두 날짜 사이의 기간이 유효한지 체크한다. <br>
//								     *     ret = ComChkPeriod("20080909", "20080908") // 결과 = 0
//								     *     ret = ComChkPeriod("20080909", "20080909") // 결과 = 2
//								     *     ret = ComChkPeriod("20080909", "20080910") // 결과 = 1
//								     *     ret = ComChkPeriod("20080909", "2008")     // 결과 = -1
//								     *     if(ComChkPeriod("20080911", "20080910") < 1) alert("기간이 정확하지 않습니다.")

								}
								
								// OC Date가 2016.03.18 이전인 경우만 가능
								else if ( ComChkPeriod ( oc_dt , '20160318' ) < 1 ){
									ComShowCodeMessage('DMT00165','OC Date( ~ 2016.03.18)');
									clearDetailReason();
									return false;
								}
								
								// RHQ Office Code = 'NYCRA'인 경우만 가능
								else if ( sheetObjects[1].CellValue(i,'ofc_rhq_cd') != "NYCRA"){
									ComShowCodeMessage('DMT00165','RHQ Office(NYCRA)');
									clearDetailReason();
									return false;	
								}
								
								break;
					        	
					        	
						 	case "SLICRM":
						 	
						 // 2016.09.02 SLICRM Validation조건 추가
								
						 		// DMT_OFC_CD = 'SELSC' 인 경우만 가능
								if ( sheetObjects[1].CellValue(i,'ofc_cd') != "SELSC"){
									ComShowCodeMessage('DMT00165','Office(SELSC)');
									clearDetailReason();
									return false;	
								// DEM DET Tariff Type이 DMIF , CTIC 인 경우만 가능	
								}else if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DMIF" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC"){
									ComShowCodeMessage('DMT00165','DMIF, CTIC');
									clearDetailReason();
									return false;
								// Over day 가 1일인 경우만 가능	
								}else if ( sheetObjects[1].CellValue(i,'fx_ft_ovr_dys') != "1" ){
									ComShowCodeMessage('DMT00165','Over Day : 1 Day');
									clearDetailReason();
									return false;	
								}
						
					 			break;
						 	
						 	case "ERGHCR":
					    		// 2016.09.02 ERGHCR Validation조건 추가
					    									    				
					    				// From Movement Date > 2016.08.30 인 경우만 Inactivation reason 추가

								if ( ComChkPeriod ( '20160830', sheetObjects[1].CellValue(i,'fm_mvmt_dt') ) < 1 ) {				
									if ( ComChkPeriod ( '20160901', sheetObjects[1].CellValue(i,'to_mvmt_dt') ) < 1 ){
				    					ComShowCodeMessage('DMT00165','From Date( 2016.08.30 ~ ) or To Date( 2016.09.01 ~ )');
				    					clearDetailReason();
				    					return false;
									}
								}
					    		
					        break;		 
						 }
						
						for (var j=i+1; j <= sheetObj2.Rowcount; j++) {
							if (sheetObj2.CellValue(i, "bkg_no") == sheetObj2.CellValue(j, "bkg_no") 
							&& sheetObj2.CellValue(i, "cntr_no") == sheetObj2.CellValue(j, "cntr_no")
							&& sheetObj2.CellValue(i, "dmdt_trf_cd") == sheetObj2.CellValue(j, "dmdt_trf_cd")
							&& sheetObj2.CellValue(i, "chg_type") == sheetObj2.CellValue(j, "chg_type")
							&& sheetObj2.CellValue(i, "chg_seq") == sheetObj2.CellValue(j, "chg_seq")							
							   ){
								ComShowCodeMessage('DMT01065', sheetObj2.CellValue(i, "cntr_no"));
								return false;		
							}
						}
           		   }

		        	var chkRow = sheetObj1.FindCheckedRow("chk");
					if (chkRow == "") {
						ComShowCodeMessage('DMT01049');
						return false;
					}

					// Charge Deletion Specific Reason 의 각 단계별 입력값에 대한 필수입력체크를 실행한다.
					if (!checkChgDeltSpecRsnRmk()) return false;
					
				  	/**
				  	 * Comment 에 대한 필수입력 체크를 수행하는 함수
				  	 */	 
					with(formObj) {
			 	 		if (!chkComment.checked) {
			 	 			ComShowCodeMessage("DMT00151");
			 	 			ComSetFocus(chkComment);
			 	 			return false;				
			 	 		}
			 	 		else if (ComTrim(ComGetObjValue(corr_rmk)) == "") {
			 	 			ComShowCodeMessage("DMT02002", "Comment");
			 	 			ComSetFocus(corr_rmk);
			 	 			return false;				
			 	 		}
			 	 		else if (ComChkLenByByte(ComGetObjValue(corr_rmk), 1000) == 0) {
			 	 			ComShowCodeMessage("DMT00104", "Comment", "1000");
			 	 			ComSetFocus(corr_rmk);
			 	 			return false;				
			 	 		}
			 	 		
			 	 		chkRow = chkRow.split("|")[0];

						var corrRmk = ComGetObjValue(corr_rmk);
						if (corrRmk != '')
							corrRmk = ComTrim(corrRmk);
						
						var chgDelRsnDesc = sheetObj1.CellValue(chkRow, "spec_rsn_desc");
						if (corrRmk != '')
							corrRmk = chgDelRsnDesc + " : " + corrRmk;
						else
							corrRmk = chgDelRsnDesc;

						ComSetObjValue(corr_rmk, corrRmk);
						ComSetObjValue(dmdt_chg_delt_rsn_cd,      sheetObj1.CellValue(chkRow, "rsn_cd"));
						ComSetObjValue(dmdt_chg_delt_spec_rsn_cd, sheetObj1.CellValue(chkRow, "spec_rsn_cd"));
			      	}		
					
					if (ComGetObjValue(formObj.prnt_mnu_id) != "EES_DMT_3014") {
						for(var i=sheetObj.TopRow; i < sheetObj.Rows; i++) {
							sheetObj.RowStatus(i) = "U";
						}
					}
					
				break;
				

	             case IBDELREQCANCEL:
	            	 
		        	var sheetObj1 = sheetObjects[0];
		        	var sheetObj2 = sheetObjects[1];
		        	var sheetObj3 = sheetObjects[3];
		        	var user_ofc = formObj.upd_ofc_cd.value;

//		        	if (ComGetObjValue(formObj.save_flg) == "RA") {
//		        		for(var i=sheetObj1.TopRow; i < sheetObj1.Rows; i++) {
//			        		if( sheetObj1.RowStatus(i) != "R" ){
//				 	 			ComShowCodeMessage("DMT00136");
//				 	 			return false;	
//			        		}
//		        		}
//		        		for(var i=sheetObj2.TopRow; i < sheetObj2.Rows; i++) {
//			        		if( sheetObj2.RowStatus(i) != "R" ){
//				 	 			ComShowCodeMessage("DMT00136");
//				 	 			return false;
//			        		}
//		        		}
//		        		for(var i=sheetObj3.TopRow; i < sheetObj3.Rows; i++) {
//			        		if( sheetObj3.RowStatus(i) != "R" ){
//				 	 			ComShowCodeMessage("DMT00136");
//				 	 			return false;	
//			        		}
//		        		}
//					}

				  	/**
				  	 * Comment 에 대한 필수입력 체크를 수행하는 함수
				  	 */	 
					with(formObj) {
			 	 		if (!chkComment.checked) {
			 	 			ComShowCodeMessage("DMT00151");
			 	 			ComSetFocus(chkComment);
			 	 			return false;				
			 	 		}
			 	 		else if (ComTrim(ComGetObjValue(corr_rmk)) == "") {
			 	 			ComShowCodeMessage("DMT02002", "Comment");
			 	 			ComSetFocus(corr_rmk);
			 	 			return false;				
			 	 		}
			 	 		else if (ComChkLenByByte(ComGetObjValue(corr_rmk), 1000) == 0) {
			 	 			ComShowCodeMessage("DMT00104", "Comment", "1000");
			 	 			ComSetFocus(corr_rmk);
			 	 			return false;				
			 	 		}
			 	 		
			 	 		var chkRow = sheetObj1.FindCheckedRow("chk");
			 	 		chkRow = chkRow.split("|")[0];

						var corrRmk = ComGetObjValue(corr_rmk);
						if (corrRmk != '')
							corrRmk = ComTrim(corrRmk);
						
						var chgDelRsnDesc = sheetObj1.CellValue(chkRow, "spec_rsn_desc");
						if (corrRmk != '')
							corrRmk = chgDelRsnDesc + " : " + corrRmk;
						else
							corrRmk = chgDelRsnDesc;

						ComSetObjValue(corr_rmk, corrRmk);
						ComSetObjValue(dmdt_chg_delt_rsn_cd,      sheetObj1.CellValue(chkRow, "rsn_cd"));
						ComSetObjValue(dmdt_chg_delt_spec_rsn_cd, sheetObj1.CellValue(chkRow, "spec_rsn_cd"));
			      	}	
					
             		if(!ComShowCodeConfirm('DMT01171', "inactivation request"))
             			return false;

		        	sheetObj2.CheckAll("chk") = 1;
             		
             		break;
             		

	             case IBDELSAVE:
	            	 
		        	var sheetObj1 = sheetObjects[0];
		        	var sheetObj2 = sheetObjects[1];
		        	var sheetObj3 = sheetObjects[2];
		        	var user_ofc = formObj.upd_ofc_cd.value;
		        	
//		        	if (ComGetObjValue(formObj.save_flg) == "RA") {
//		        		for(var i=sheetObj1.TopRow; i < sheetObj1.Rows; i++) {
//			        		if( sheetObj1.RowStatus(i) != "R" ){
//				 	 			ComShowCodeMessage("DMT00136");
//				 	 			return false;	
//			        		}
//		        		}
//		        		for(var i=sheetObj2.TopRow; i < sheetObj2.Rows; i++) {
//			        		if( sheetObj2.RowStatus(i) != "R" ){
//				 	 			ComShowCodeMessage("DMT00136");
//				 	 			return false;	
//			        		}
//		        		}
//		        		for(var i=sheetObj3.TopRow; i < sheetObj3.Rows; i++) {
//			        		if( sheetObj3.RowStatus(i) != "R" ){
//				 	 			ComShowCodeMessage("DMT00136");
//				 	 			return false;	
//			        		}
//		        		}
//					}
		        	
				  	/**
				  	 * Comment 에 대한 필수입력 체크를 수행하는 함수
				  	 */	 
					with(formObj) {
			 	 		if (!chkComment.checked) {
			 	 			ComShowCodeMessage("DMT00151");
			 	 			ComSetFocus(chkComment);
			 	 			return false;				
			 	 		}
			 	 		else if (ComTrim(ComGetObjValue(corr_rmk)) == "") {
			 	 			ComShowCodeMessage("DMT02002", "Comment");
			 	 			ComSetFocus(corr_rmk);
			 	 			return false;				
			 	 		}
			 	 		else if (ComChkLenByByte(ComGetObjValue(corr_rmk), 1000) == 0) {
			 	 			ComShowCodeMessage("DMT00104", "Comment", "1000");
			 	 			ComSetFocus(corr_rmk);
			 	 			return false;				
			 	 		}
			 	 		
			 	 		var chkRow = sheetObj1.FindCheckedRow("chk");
			 	 		chkRow = chkRow.split("|")[0];

						var corrRmk = ComGetObjValue(corr_rmk);
						if (corrRmk != '')
							corrRmk = ComTrim(corrRmk);
						
						var chgDelRsnDesc = sheetObj1.CellValue(chkRow, "spec_rsn_desc");
						if (corrRmk != '')
							corrRmk = chgDelRsnDesc + " : " + corrRmk;
						else
							corrRmk = chgDelRsnDesc;

						ComSetObjValue(corr_rmk, corrRmk);
						ComSetObjValue(dmdt_chg_delt_rsn_cd,      sheetObj1.CellValue(chkRow, "rsn_cd"));
						ComSetObjValue(dmdt_chg_delt_spec_rsn_cd, sheetObj1.CellValue(chkRow, "spec_rsn_cd"));
			      	}	

		        	sheetObjects[1].CheckAll("chk") = 1;
		        	
             		break;
        	 } // switch end
         } // with end
        	 
         return true;
     }
     
     
     /**
      * Charge Deletion Speicific Reason 별로 입력해야될 필수 Delpth 를 반환해준다. 
      * 단, 조건에 따라 입력될 Depth 가 다를경우, 입력된 조건값에 맞는 Depth 를 반환해준다.
      */      
     function getReasonDetailEndRow() {
    	 var formObj = document.form;
    	 
    	 var nRsnDtlEndRow = parseInt(ComGetObjValue(formObj.h_detail_rsn_mandatory_rows));
    	 
    	 for (var i=REASON_DETAIL_START; i<=nRsnDtlEndRow; i++) {
    		 var prefix = "detail_" + i;
    		 
    		 var fieldCond = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_cond"));	// 조건데이터
    		 if (fieldCond != "") {
    			 var fieldValue = ComGetObjValue(eval("formObj." + prefix));					// 사용자가 선택한 입력값
    			 if (fieldValue != "") {
    				 var arrFieldCond = fieldCond.split("|");					
    				 for (var j=0; j<arrFieldCond.length; j++) {
    					 var arrFieldValue = arrFieldCond[j].split("=");
    					// 사용자가 선택한 값과 동일한 조건데이터를 찾아서 조건데이터에 지정된 Depth 를 반환해준다.
    					 if (fieldValue == arrFieldValue[0]) {		
    						 return parseInt(arrFieldValue[1]);
    					 }
    				 }
    			 }
    		 }
    	 }
    	 
    	 return nRsnDtlEndRow;
     }
     
     /**
      * Charge Deletion Speicific Reason 에 단계별로 입력된 Remark 를 서버로 전송하기 위해 일련의 문자열로 변환해준다.
      */     
     function checkChgDeltSpecRsnRmk() {
    	 var formObj = document.form;
    	 var sheetObj0 = sheetObjects[0];
    	 var sheetObj1 = sheetObjects[1];
    	 var sheetObj2 = sheetObjects[2];
    	 var chkRow = sheetObj0.FindCheckedRow("chk");
    	 if (chkRow != "") {
    		 chkRow = chkRow.split("|")[0];
    		 if (sheetObj0.CellValue(chkRow, "file_atch_mdt_yn") == "Y") {
    			 
    			 if (sheetObj2.RowCount == 0) {
    				 ComShowCodeMessage("DMT00102", "Attached File");
    				 return false;
    			 }
    		 }
    	 }
    	 
//    	 if ( sheetObj.ColHidden("detail_1_type") == false){
//    		 
//    	 }
//     	for (var i=1; i<=REASON_DETAIL_END; i++) {
//     	
//     		var prefix = "detail_" + i;
//        	
//			var fieldName   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_name"));
//			var fieldType   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_type"));
//			var fieldSize   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_size"));
//			var fieldFormat = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_format"));
//			var fieldItem   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_item"));
//			var fieldCond   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_cond"));
//			var fieldPopup  = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_popup"));
//			var fieldValue  = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_value"));
//			
//			var detailType  = "";
//
//			if (fieldName != "") {
//
//				for (var j=1;j<sheetObj1.rowcount+1; j++) {
//					if ( sheetObj1.CellValue(j,prefix+"_type") ==  "" ){
//			    		ComShowCodeMessage("DMT05014", fieldName);
//			    		return false;
//					}
//				}
//			}
// 	    	
//     	}
 		
    	 
    	 return true;
     }
     
     /**
      * 파일을 업로드해준다.
      */
     function doActionFileUpload() {
    	 var sheetObj = sheetObjects[2];
    	 var upObj = uploadObjects[0]; // Eidt Point

    	 var fileName = sheetObj.OpenFileDialog("");
 		
 		// 파일대화상자에서 선택한 파일이 없을 경우 종료
 		if (fileName.indexOf(FILE_SELECT_CANCEL) != -1) {
 			return;
 		}
 		
    	ComOpenWait(true); // Eidt Point

 		// 행이 없는 경우..
		var Row = sheetObj.DataInsert(-1, 0);// File Add인 경우 New Row 생성

		
		sheetObj.CellValue2(Row, "ibflag") = "I";

 		if (fileName.indexOf("\\") != -1) {
 			
 			sheetObj.CellValue2(Row, PREFIX + FILE_PATH) = fileName; // File Path
 			
 	     	// 업로드파일이 존재할 경우, 파일업로드 객체에 파일정보를 추가해준다.
 	     	// FileUpload 버튼 클릭시 미리 FileObj에 추가하도록 조치 및 doActionRequest에서의 해당 작업 비활성화
 			appendFileToUploadObjects(); //
			
 			var fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
 			sheetObj.CellValue2(Row, PREFIX + FILE_NM) = fileName; // File Name
 			
 			upObj.ExtendParam = "f_cmd=" + COMMAND01;
 			
			var sXml = upObj.DoUpload(true);
			
			var fileSaveId = ComGetEtcData(sXml, "fileSaveId"); // File Save Id

			// 비정상적인 작동에 의해 File Save Id가 반환되지 않을경우 에러메시지 발생
			if ( !ComIsNull ( fileSaveId ) ){
 				sheetObj.CellValue2(Row, PREFIX + FILE_SAV_ID) = fileSaveId;
			} else{
				sheetObj.rowDelete(Row, false);
	        	ComShowCodeMessage('DMT00003', 'File. ');
	        	ComOpenWait(false);
				return;
			}
 		} 		
 		
    	ComOpenWait(false);
		
		fileFlg = "Y";
		
    	////////////////////////////////////////////////////////////////////
// 		if (fileName.indexOf("\\") != -1) {
// 			sheetObj.CellValue2(Row, PREFIX + FILE_PATH) = fileName;
// 			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
// 			sheetObj.CellValue2(Row, PREFIX + FILE_NM) = fileName;
// 		}    	 
//
//		fileFlg = "Y";
		//////////////////////////////////////////////////////////////////
     	
    	
     }
     
     /**
      * 파일을 삭제해준다. <br>
      */
	function doActionFileDelete() {
		var sheetObj = sheetObjects[2];
		
		if (sheetObj.FindCheckedRow(PREFIX + "del_chk") != "") {
//			if (!confirm("Are you sure to delete?")) { 
//				return;
//			}			  
//			ComRowHideDelete(sheetObj, PREFIX + "del_chk");
//			//doActionIBSheet(sheetObj, document.form, IBSAVE);
			
			//SaveName이 "pass_yn"인 행에서만 체크된 행의 번호를 읽어온다.
			var sRow = sheetObj.FindCheckedRow(PREFIX + "del_chk");

			//가져온 행을 배열로 반든다.
			var arrRow = sRow.split("|");
			for (idx=0; idx<arrRow.length-1; idx++){ 
//				alert(arrRow[idx]); 
				sheetObj.RowDelete(arrRow[idx]);
			}

			
			fileFlg = "Y";
		} 
		else {
			alert("No Selected Row");
			//ComShowCodeMessage("BKG00249");// "No Selected Row";
		}
	}     
    
     /**
      * 입력된 정보를 저장한다. <br>
      */     
	function doActionRequest() {
    	var formObj   = document.form;
    	var sheetObj  = sheetObjects[1];
     	var uploadObj = uploadObjects[0];
      	   	
     	if (!validateForm(sheetObj, formObj, IBSAVE)) return;   
     	
     	// 업로드파일이 존재할 경우, 파일업로드 객체에 파일정보를 추가해준다.
     	// FileUpload 버튼 클릭시 미리 FileObj에 추가하도록 조치
     	
     	// appendFileToUploadObjects(); // Eidt Point
    	
    	 var chg_delt_spec_rsn_rmk = "";
    	 var rmk = "";
    	 for (var j=1;j<sheetObj.rowcount+1; j++) {
    		chg_delt_spec_rsn_rmk = "";
    		for (var i=1;i<10; i++){
    			rmk = "";
    			rmk = sheetObj.CellValue(j,"detail_"+i+"_type");
				if (rmk.length != "") {
	    			 if (chg_delt_spec_rsn_rmk != "") chg_delt_spec_rsn_rmk += "|";
	    			 chg_delt_spec_rsn_rmk += rmk;
	    		 }
    		}
    		sheetObj.CellValue2(j,"chg_delt_spec_rsn_rmk") = chg_delt_spec_rsn_rmk;
    		sheetObj.CellValue2(j,"delt_rmk") = formObj.corr_rmk.value;
 		}
    	// 데이터처리를 위한 Action Command 설정
     	ComSetObjValue(formObj.f_cmd, MULTI);
     	     	
    	if (uploadObj.LocalFiles == "") {
	    	doActionIBSheet(sheetObj, formObj, IBSAVE);
    	}
    	else {
	    	doActionIBSheet(sheetObj, formObj, IBSAVE_FILEUPLOAD);
    	}
    }
     
     /**
      * 업로드파일이 존재할 경우, 파일업로드 객체에 파일정보를 추가해준다. <br>
      */
     function appendFileToUploadObjects() {
    	var formObj   = document.form;
     	var sheetObj  = sheetObjects[2];
     	var uploadObj = uploadObjects[0];
     	
     	uploadObj.Files = ""; // -먼저기존파일을 모두 지운후 추가함

     	var arrRow = sheetObj.FindStatusRow("I").split(";");
     	for (i=0; i<arrRow.length-1; i++) {
     		//IBUpload에 파일 추가하기
     		uploadObj.AddFile(sheetObj.CellValue(arrRow[i], PREFIX + FILE_PATH));
     		
     	}
     }     
     
     //########################################################< CHARGE SPECIFIC REASON 기능 추가 - START >############################################################################
     /**
      * Sheet1 에 Click 이벤트 발생시 호출되는 함수
      */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {

    	var formObj   = document.form;
    	
    	var rowOld = oldRow;
    	
		if ( oldRow == Row ) return;	
		if (sheetObj.ColSaveName(Col) != "chk") return;

		displayInactivationDetailReason(sheetObj, Row);
		
		spec_rsn_cd = sheetObj.CellValue(Row, "spec_rsn_cd");

		if( sheetObj.CellValue(Row, "spec_rsn_cd") == "SMRSWC" ||sheetObj.CellValue(Row, "spec_rsn_cd") == "SMRVST" 
			||sheetObj.CellValue(Row, "spec_rsn_cd") == "SOCDP" || sheetObj.CellValue(Row, "spec_rsn_cd") == "LPIEGI" ){
			
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				spec_rsn_cd_row = i;
				ComSetObjValue(formObj.bkg_no, sheetObjects[1].CellValue(i,'bkg_no')); 
				ComSetObjValue(formObj.io_bnd_cd, sheetObjects[1].CellValue(i,'dmdt_trf_cd').substr(2,1)); 
				ComSetObjValue(formObj.cntr_no, sheetObjects[1].CellValue(i,'cntr_no')); 
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
				spec_rsn_cd_row = 0;
			}
			
		} else if( sheetObj.CellValue(Row, "spec_rsn_cd") == "SLIOMC" || sheetObj.CellValue(Row, "spec_rsn_cd") == "DMGOMC" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
					ComShowCodeMessage('DMT00165','OP, MT');
					clearDetailReason();
					return ;
				}				
			}
		} else if( sheetObj.CellValue(Row, "spec_rsn_cd") == "SLIDTO" || sheetObj.CellValue(Row, "spec_rsn_cd") == "CREFXT" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if ( sheetObj.CellValue(Row, "spec_rsn_cd") == "SLIDTO" ){
					if(sheetObjects[1].CellValue(i,'ofc_rhq_cd') != "HAMRU"){
						ComShowCodeMessage('DMT00171','Office(HAMRU)');
						clearDetailReason();
						return false;
					} 
					else if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
						ComShowCodeMessage('DMT00165','OP, MT');
						clearDetailReason();
						return false;
					} else {
						sheetObjects[1].CellValue2(i,'detail_1_type') = sheetObjects[1].CellValue(i,'ofc_cd');
					}
				} 
				else if ( sheetObj.CellValue(Row, "spec_rsn_cd") == "CREFXT" ){
					if(sheetObjects[1].CellValue(i,'ofc_cd') != "FXTSC"){
						alert('DMT OFC IS NOT FIXTSC');
						clearDetailReason();
						return false;
					}
					if(sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC"){
						ComShowCodeMessage('DMT00165','DTIC');
						clearDetailReason();
						return false;
					}
				}
				
			}
		} else if( sheetObj.CellValue(Row, "spec_rsn_cd") == "CBDBBT" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(!(sheetObjects[1].CellValue(i,'ofc_cd') == "FXTSC"||sheetObjects[1].CellValue(i,'ofc_cd') == "GOASC" )){
					ComShowCodeMessage('DMT00165','Office(FXTSC, GOASC)');
					clearDetailReason();
					return false;
				}
				if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
					ComShowCodeMessage('DMT00165','OP, MT');
					clearDetailReason();
					return false;
				}
			}
		} else if( sheetObj.CellValue(Row, "spec_rsn_cd") == "CRESTT" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC" ){
					ComShowCodeMessage('DMT00165','CTIC, DTIC');
					clearDetailReason();
					return false;
				}
			}
		}
		
		if( sheetObj.CellValue(Row, "spec_rsn_cd") == "SLIVUC" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if( sheetObjects[1].CellValue(i,'ofc_cd') != "CCSBA" ){
					ComShowCodeMessage('DMT01185','CCSBA');
					clearDetailReason();
					return false;
				}
				if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC" ){
					ComShowCodeMessage('DMT00165','CTIC');
					clearDetailReason();
					return false;
				}
			}
		}
		
		if( sheetObj.CellValue(Row, "spec_rsn_cd") == "LPIEGI" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(!(sheetObjects[1].CellValue(i,'ofc_rhq_cd') == "SHARC" )){
					ComShowCodeMessage('DMT01185','SHARC');
					clearDetailReason();
					return false;
				}
			}
		}

		if( sheetObj.CellValue(Row, "spec_rsn_cd") == "LPIEPH" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(!(sheetObjects[1].CellValue(i,'ofc_cd') == "HKGSC" )){
					ComShowCodeMessage('DMT01185','HKGSC');
					clearDetailReason();
					return false;
				}
				spec_rsn_cd_row = i;
				ComSetObjValue(formObj.bkg_no, sheetObjects[1].CellValue(i,'bkg_no')); 
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
				spec_rsn_cd_row = 0;
			}
		}
		
		if( sheetObj.CellValue(Row, "spec_rsn_cd") == "LPIUDI" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(!(sheetObjects[1].CellValue(i,'ofc_cd') == "JKTSC" )){
					ComShowCodeMessage('DMT01185','JKTSC');
					clearDetailReason();
					return false;
				}
				
				if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTOC" ){
					ComShowCodeMessage('DMT00165', 'DTOC');
					clearDetailReason();
					return false;
				}
				
				if(sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') == "OP" && sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') == "MT" ){
					ComShowCodeMessage('DMT00165','OP, MT');
					clearDetailReason();
					return false;
				}
			}
		}

		if( sheetObj.CellValue(Row, "spec_rsn_cd") == "SLIWCE" || sheetObj.CellValue(Row, "spec_rsn_cd") == "SLIWCR" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(!(sheetObjects[1].CellValue(i,'ofc_rhq_cd') == "HAMRU" )){
					ComShowCodeMessage('DMT01185','HAMRU');
					clearDetailReason();
					return false;
				}
//				if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTOC" ){
//					ComShowCodeMessage('DMT05014','DTOC');
//					clearDetailReason();
//					return false;
//				}
				if ( sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OP" || sheetObjects[1].CellValue(i,'to_mvmt_sts_cd') != "MT" ){
					ComShowCodeMessage('DMT00165','OP, MT');
					clearDetailReason();
					return false;
				} 
				sheetObjects[1].CellValue2(i,'detail_2_type') =  sheetObjects[1].CellValue(i,'fm_mvmt_yd_cd');
				sheetObjects[1].CellValue2(i,'detail_3_type') =  sheetObjects[1].CellValue(i,'to_mvmt_yd_cd');

				spec_rsn_cd_row = i;
				ComSetObjValue(formObj.bkg_no, sheetObjects[1].CellValue(i,'bkg_no')); 
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
				spec_rsn_cd_row = 0;
				
			}
		}
		
		var rsn_cd = sheetObj.CellValue(Row, "spec_rsn_cd");
		if(rsn_cd == "LPICCD" || rsn_cd == "LPICCY" || rsn_cd == "LPINCD" || rsn_cd == "LPINCY"){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
//				alert('CNTR No : ' + sheetObjects[1].CellValue(i, 'cntr_no') + ' / RowHidden' + sheetObjects[1].RowHidden(i));
				if(sheetObjects[1].RowHidden(i)) 
					continue;
					
				var trf_cd = sheetObjects[1].CellValue(i,'dmdt_trf_cd');
				var flag = false;
				
				if( trf_cd != "DMIF" ){
					if( rsn_cd == "LPICCD" || rsn_cd == "LPINCD" ) {
						if(trf_cd != "DMOF" ){
							flag = true;
						}
					} else {
						flag = true;
					}
				}
				
				if(flag) {
					ComShowCodeMessage('DMT00165', trf_cd);	
					clearDetailReason();
					return false;
				}
								
				if( (trf_cd == 'DMIF' && sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "IC") 
						|| (trf_cd == 'DMOF' && sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd') != "OC") ){
					ComShowCodeMessage('DMT00165', 'FM', sheetObjects[1].CellValue(i,'fm_mvmt_sts_cd'));						
					clearDetailReason();
					return false;
				}
				
				var fmCntCd = sheetObjects[1].CellValue(i,'fm_mvmt_yd_cd').substr(0,2);
				if ( fmCntCd != "DE" && fmCntCd != "AT" ){
					ComShowCodeMessage('DMT00165', "Country(" + fmCntCd + ")");
					clearDetailReason();
					return false;
				}
				
				var rcvTermCd = sheetObjects[1].CellValue(i,'bkg_rcv_term_cd');
				var deTermCd = sheetObjects[1].CellValue(i,'bkg_de_term_cd');				
				
				if( trf_cd == 'DMIF' ){
					if( rsn_cd == "LPICCD" || rsn_cd == "LPINCD" ) {
						if(sheetObjects[1].CellValue(i,'bkg_de_term_cd') != 'D') {
							flag = true;
						}
					} else {
						if(sheetObjects[1].CellValue(i,'bkg_de_term_cd') != 'Y') {
							flag = true;
						}
					}
					if( flag ) {
						ComShowCodeMessage('DMT00165', "BKG Delivery term : " + sheetObjects[1].CellValue(i,'bkg_de_term_cd'));						
						clearDetailReason();
						return false;
					}
				} else {	//DMOF
					if ( sheetObjects[1].CellValue(i,'bkg_rcv_term_cd') != 'D' ) {
						ComShowCodeMessage('DMT00165', "BKG Receiveing term : " + sheetObjects[1].CellValue(i,'bkg_rcv_term_cd'));						
						clearDetailReason();
						return false;
					}
				}
				
				var ch = sheetObjects[1].CellValue(i,'ch');
				
				if( (rsn_cd == "LPICCY" || rsn_cd == "LPINCY") && ch != 'C' ) {
					ComShowCodeMessage('DMT00165', "CH", ch);						
					clearDetailReason();
					return false;
				}
				if(sheetObjects[1].RowHidden(i)) 
					continue;
				if(formObj.save_flg.value != 'D' && formObj.save_flg.value != 'A') {
					// Detail Reason 처리를 위한 추가 조회 실행
//					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
					ComSetObjValue(formObj.bkg_no, sheetObjects[1].CellValue(i,'bkg_no')); 
					ComSetObjValue(formObj.io_bnd_cd, sheetObjects[1].CellValue(i,'dmdt_trf_cd').substr(2,1)); 
					ComSetObjValue(formObj.cntr_no, sheetObjects[1].CellValue(i,'cntr_no')); 
					ComSetObjValue(formObj.curr_cd, sheetObjects[1].CellValue(i,'bzc_trf_curr_cd'));
					ComSetObjValue(formObj.f_cmd, SEARCH04);
		        	 //2.조회조건으로 조회실행 
					var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", FormQueryString(formObj));
					if( (rsn_cd == "LPICCD" || rsn_cd == "LPICCY") && ComGetEtcData(sXml, "CHG_CD") != 'SRC' ) {
						alert('SRC Charge is not manifested.');
						clearDetailReason();
						return false;
					}
					
					// Validation 완료 후 처리 로직
					sheetObjects[1].CellValue(i, 'detail_1_type') = sheetObjects[1].CellValue(i, 'fm_mvmt_sts_cd');
					sheetObjects[1].CellEditable(i, "detail_1_type") = false;
					sheetObjects[1].CellValue(i, 'detail_2_type') = sheetObjects[1].CellValue(i, 'fm_mvmt_yd_cd');
					sheetObjects[1].CellEditable(i, "detail_2_type") = false;
					sheetObjects[1].CellValue(i, 'detail_3_type') = ((rsn_cd == "LPICCD" || rsn_cd == "LPINCD") && trf_cd == 'DMOF') ? rcvTermCd : deTermCd;
					sheetObjects[1].CellEditable(i, "detail_3_type") = false;
					
					if(rsn_cd == "LPICCD") {
						sheetObjects[1].CellValue(i, 'detail_4_type') = sheetObjects[1].CellValue(i, 'ft_dys');
						sheetObjects[1].CellEditable(i, "detail_4_type") = false;
						sheetObjects[1].CellValue(i, 'detail_6_type') = sheetObjects[1].CellValue(i, 'bzc_trf_curr_cd');
						sheetObjects[1].CellEditable(i, "detail_6_type") = false;
						if(ComGetEtcData(sXml, "CHG_CD") != 'E') {
							sheetObjects[1].CellValue(i, "detail_5_type") = ComGetEtcData(sXml, "CHG_CD");
							sheetObjects[1].CellValue(i, "detail_7_type") = ComGetEtcData(sXml, "CHG_AMT");
						} else {
							sheetObjects[1].CellValue(i, "detail_5_type") = 'SRC';
							sheetObjects[1].CellValue(i, "detail_7_type") = 0;
						}
						sheetObjects[1].CellAlign(i, 'detail_5_type') = daCenter;
						sheetObjects[1].CellEditable(i, "detail_5_type") = false;
			    		sheetObjects[1].CellEditable(i, "detail_7_type") = false;
			    							
					} else if (rsn_cd == "LPICCY") {
						sheetObjects[1].CellValue(i, 'detail_4_type') = sheetObjects[1].CellValue(i, 'ch');
						sheetObjects[1].CellAlign(i, 'detail_4_type') = daCenter;
						sheetObjects[1].CellEditable(i, "detail_4_type") = false;
						sheetObjects[1].CellValue(i, 'detail_5_type') = sheetObjects[1].CellValue(i, 'ft_dys');
						sheetObjects[1].CellEditable(i, "detail_5_type") = false;					
						sheetObjects[1].CellValue(i, 'detail_6_type') = sheetObjects[1].CellValue(i, 'CHG_CD');
						sheetObjects[1].CellEditable(i, "detail_6_type") = false;					
						sheetObjects[1].CellValue(i, 'detail_7_type') = sheetObjects[1].CellValue(i, 'bzc_trf_curr_cd');
						sheetObjects[1].CellEditable(i, "detail_7_type") = false;
						sheetObjects[1].CellValue(i, 'detail_8_type') = sheetObjects[1].CellValue(i, 'CHG_AMT');
						sheetObjects[1].CellEditable(i, "detail_8_type") = false;
						if(ComGetEtcData(sXml, "CHG_CD") != 'E') {
							sheetObjects[1].CellValue(i, "detail_6_type") = ComGetEtcData(sXml, "CHG_CD");
							sheetObjects[1].CellValue(i, "detail_8_type") = ComGetEtcData(sXml, "CHG_AMT");
						} else {
							sheetObjects[1].CellValue(i, "detail_6_type") = 'SRC';
							sheetObjects[1].CellValue(i, "detail_8_type") = 0;
						}
						sheetObjects[1].CellAlign(i, 'detail_6_type') = daCenter;
						sheetObjects[1].CellEditable(i, "detail_6_type") = false;
			    		sheetObjects[1].CellEditable(i, "detail_8_type") = false;
			    													
					} else if (rsn_cd == "LPINCD") {
						sheetObjects[1].CellValue(i, 'detail_4_type') = sheetObjects[1].CellValue(i, 'ft_dys');
						sheetObjects[1].CellEditable(i, "detail_4_type") = false;
						
					} else {	//LPINCY
						sheetObjects[1].CellValue(i, 'detail_4_type') = sheetObjects[1].CellValue(i, 'ch');
						sheetObjects[1].CellAlign(i, 'detail_4_type') = daCenter;
						sheetObjects[1].CellEditable(i, "detail_4_type") = false;
						sheetObjects[1].CellValue(i, 'detail_5_type') = sheetObjects[1].CellValue(i, 'ft_dys');
						sheetObjects[1].CellEditable(i, "detail_5_type") = false;
					}
				}
				
			}
			
		}

		if(rsn_cd == "LPIIEK"){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(sheetObjects[1].RowHidden(i)) continue;
				
				if(sheetObjects[1].CellValue(i,'ofc_cd') != "MBABA" && sheetObjects[1].CellValue(i,'ofc_cd') != "DARBA"){
					ComShowCodeMessage('DMT00171','Office(MBABA, DARBA)');
					clearDetailReason();
					return false;
				} 
				
				sheetObjects[1].CellValue(i, 'detail_3_type') = sheetObjects[1].CellValue(i, 'ft_dys');
				sheetObjects[1].CellEditable(i, "detail_3_type") = false;		
			}
		}
		
		if(rsn_cd == "SLIFSD"){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
				if(sheetObjects[1].RowHidden(i)) continue;
				if (sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC"){
		 			ComShowCodeMessage('DMT00165', sheetObjects[1].CellValue(i,'dmdt_trf_cd'));
		 			return false;	
		 		}

				if(sheetObjects[1].CellValue(i, 'detail_1_type') == '') {					
					sheetObjects[1].CellValue(i, 'detail_1_type') = sheetObjects[1].CellValue(i, 'sc_no');
				}
				sheetObjects[1].CellEditable(i, 'detail_1_type') = false;
				sheetObjects[1].CellValue(i, 'detail_2_type') = 'US067219';
				sheetObjects[1].CellEditable(i, 'detail_2_type') = false;
			}
		}	
		
		// 2016.07.29 SLICEN Validation조건 추가
		if( rsn_cd == "SLICEN" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
					
				if(sheetObjects[1].RowHidden(i)) continue;
				
				if(sheetObjects[1].CellValue(i, 'detail_1_type') == '') {					
					sheetObjects[1].CellValue(i, 'detail_1_type') = sheetObjects[1].CellValue(i, 'cnee_cd');
				}
				
				if (sheetObjects[1].CellValue(i, 'detail_2_type') == '') {
					sheetObjects[1].CellValue(i, 'detail_2_type') = sheetObjects[1].CellValue(i, 'ntfy_cd');
				}
				
				if ( sheetObjects[1].CellValue(i,'ofc_cd') != "SELSC"){
					ComShowCodeMessage('DMT00165','Office(SELSC)');
					clearDetailReason();
					return false;	
				}else if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DMIF" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC"){
					ComShowCodeMessage('DMT00165','DMIF, DTIC');
					clearDetailReason();
					return false;	
				}else if ( sheetObjects[1].CellValue(i,'detail_1_type') != "KR038479" && sheetObjects[1].CellValue(i,'detail_2_type') != "KR038479" 
						&& sheetObjects[1].CellValue(i,'detail_1_type') != "KR007970" && sheetObjects[1].CellValue(i,'detail_2_type') != "KR007970"  ){
					ComShowCodeMessage('DMT00165','Consignee Code, Notify Code(KR038479, KR007970)');
					clearDetailReason();
					return false;	
				}
			}

		}
		
		// 2016.08.22 SLIKRG Validation조건 추가
		if( rsn_cd == "SLIKRG" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
								
				if(sheetObjects[1].RowHidden(i)) continue;
							
				if(sheetObjects[1].CellValue(i, 'detail_1_type') == '') {					
					sheetObjects[1].CellValue(i, 'detail_1_type') = sheetObjects[1].CellValue(i, 'sc_no');
				}

				ComSetObjValue(formObj.temp_bkg_no,  sheetObjects[1].CellValue(i,'bkg_no') );
				ComSetObjValue(formObj.temp_cntr_no,  sheetObjects[1].CellValue(i,'cntr_no') );
				ComSetObjValue(formObj.temp_cntr_cyc_no,  sheetObjects[1].CellValue(i,'cntr_cyc_no') );
				// OC Date 조회 로직 실행
				ComSetObjValue(formObj.f_cmd, SEARCH22);
	        	// 조회조건으로 조회실행 
				var sXml = sheetObj.GetSearchXml("EES_DMT_3104GS.do", FormQueryString(formObj));
				var oc_dt = ComGetEtcData(sXml, "OC_DT") ; 

				// DTIC or CTIC 일 경우만 가능
				if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DTIC" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC"){
					ComShowCodeMessage('DMT00165','DTIC, CTIC');
					clearDetailReason();
					return false;	
				// SC No = "AEN110754" 일 경우만 가능
				}else if ( sheetObjects[1].CellValue(i,'detail_1_type') != "AEN110754"){
					ComShowCodeMessage('DMT00165','SC No(AEN110754)');
					clearDetailReason();
					return false;
					
//				     * 두 날짜 사이의 기간이 유효한지 체크한다. <br>
//				     *     ret = ComChkPeriod("20080909", "20080908") // 결과 = 0
//				     *     ret = ComChkPeriod("20080909", "20080909") // 결과 = 2
//				     *     ret = ComChkPeriod("20080909", "20080910") // 결과 = 1
//				     *     ret = ComChkPeriod("20080909", "2008")     // 결과 = -1
//				     *     if(ComChkPeriod("20080911", "20080910") < 1) alert("기간이 정확하지 않습니다.")


				}
				
				// OC Date가 2016.03.18 이전인 경우만 가능
				else if ( ComChkPeriod ( oc_dt , '20160318' ) < 1 ){
					ComShowCodeMessage('DMT00165','OC Date( ~ 2016.03.18)');
					clearDetailReason();
					return false;
				}
				
				// RHQ Office Code = 'NYCRA'인 경우만 가능
				else if ( sheetObjects[1].CellValue(i,'ofc_rhq_cd') != "NYCRA"){
					ComShowCodeMessage('DMT00165','RHQ Office(NYCRA)');
					clearDetailReason();
					return false;	
				}
				
				
			}

		} // End SLIKRG
		
		// 2016.09.02 SLICRM Validation조건 추가
		if( rsn_cd == "SLICRM" ){
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
					
				if(sheetObjects[1].RowHidden(i)) continue;
				
				if ( sheetObjects[1].CellValue(i,'ofc_cd') != "SELSC"){
					ComShowCodeMessage('DMT00165','Office(SELSC)');
					clearDetailReason();
					return false;	
				}else if ( sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "DMIF" && sheetObjects[1].CellValue(i,'dmdt_trf_cd') != "CTIC"){
					ComShowCodeMessage('DMT00165','DMIF, CTIC');
					clearDetailReason();
					return false;	
				}else if ( sheetObjects[1].CellValue(i,'fx_ft_ovr_dys') != "1" ){
					ComShowCodeMessage('DMT00165','Over Day : 1 Day');
					clearDetailReason();
					return false;	
				}
			}

		} // End SLICRM
		
		// 2016.09.02 ERGHCR Validation조건 추가
		if( rsn_cd == "ERGHCR" ){
			
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
					
				if(sheetObjects[1].RowHidden(i)) continue;
								
				// From Movement Date > 2016.08.30 인 경우만 Inactivation reason 추가

				if ( ComChkPeriod ( '20160830', sheetObjects[1].CellValue(i,'fm_mvmt_dt') ) < 1 ) {				
					if ( ComChkPeriod ( '20160901', sheetObjects[1].CellValue(i,'to_mvmt_dt') ) < 1 ){
    					ComShowCodeMessage('DMT00165','From Date( 2016.08.30 ~ ) or To Date( 2016.09.01 ~ )');
    					clearDetailReason();
    					return false;
					}
				}
			}

		} // End ERGHCR
		

		// 2016.09.02 SLISPA Validation조건 추가
		if( rsn_cd == "SLISPA" ){
			
			for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
					
				if(sheetObjects[1].RowHidden(i)) continue;
				spec_rsn_cd_row = i;
				ComSetObjValue(formObj.bkg_no, sheetObjects[1].CellValue(i,'bkg_no')); 
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
				spec_rsn_cd_row = 0;
			}

		} // End SLISPA
		spec_rsn_cd = "";
	}
	
	//팝업버튼 Click 이벤트 처리
	function sheet2_OnPopupClick(sheetObj, row,col){
		var col_nm = sheetObj.ColSaveName(col);

		if (sheetObj.ColSaveName(col) == "detail_1_type" || 
			sheetObj.ColSaveName(col) == "detail_2_type" ||
			sheetObj.ColSaveName(col) == "detail_3_type" ||
			sheetObj.ColSaveName(col) == "detail_4_type" ||
			sheetObj.ColSaveName(col) == "detail_5_type" ||
			sheetObj.ColSaveName(col) == "detail_6_type" ||
			sheetObj.ColSaveName(col) == "detail_7_type" ||
			sheetObj.ColSaveName(col) == "detail_8_type" ||
			sheetObj.ColSaveName(col) == "detail_9_type"   ) {

			gObjId = col_nm;
			
			if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "cust_cd" ){
				ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
			} else if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "curr_cd" ){
				ComOpenPopup("COM_ENS_N13.do", 500, 450, "getCurrCd", "1,0,1,1,1,1,1", true);
			} else if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "chg_cd" ){
				var param = "?chg_cd=" + sheetObj.CellValue(row,col);
				ComOpenPopup("ESM_BKG_0975.do" + param, 650, 610, "getChgCd", "0,0", true);
			} else if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "port" ){
				ComOpenPopup("ESM_BKG_0083.do", 1000, 450, "getPort", "1,0,1,1,1,1,1", true);
			} else if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "vvd" ){
				var param = "";
		  	    param += "vvd_cd="+sheetObj.CellValue(row,col);
				ComOpenPopup("/hanjin/COM_ENS_0B2.do?"+param , 780, 465, "getVvd", "1,0,1,1,1,1,1", true);
			}
		}
	}
	
    /**
     * Specific Reason 선택시, 해당 Detail 내역을 화면에 그려준다.
     */	
	function displayInactivationDetailReason(sheetObj, Row) {
		
		var formObj = document.form;

		oldRow =  Row;
		
		// Detail 내역을 조회하기 위해 매개변수를 설정한다.
		ComSetObjValue(formObj.spec_rsn_cd, sheetObj.CellValue(Row, "spec_rsn_cd"));

		// 선택한 삭제상세코드에 설정된 단계별 Remark 를 조회한다.
		doActionIBSheet(sheetObj, formObj, IBSEARCH_DETAIL);

		//=====================================< display Reason Detail >=======================================
		// Reason Detail 항목을 화면에 보여주기 전에, 이전 설정된 Reason Detail 항목을 지워준다.
		clearDetailReason();

		// Reason Detail 항목을 화면에 생성해준다.
    	displayDetailReason(formObj, REASON_DETAIL_START, REASON_DETAIL_END);

	    //Axon 이벤트 처리 호출(새로 만들어진 Form Object 에 이벤트를 적용하기 위해서는 호출해야 됨)
	    initAxonControl();    	

//	    // 화면에 동적으로 생성한 폼컨트롤에 대해서 이벤트를 추가해준다.
//	    setEventProcess();
	    
		// 선택한 삭제상세코드에 설정된 첨부파일 필수여부를 보여준다.
//	    var dtlRow = parseInt(ComGetObjValue(formObj.h_detail_rsn_mandatory_rows)) + 1;
//		displayDetailReasonAttach(dtlRow, Row);
		//====================================================================================================		
	}
	
	
	// Specific Reason 코드값에 따라서 입력해야될 Detail Depth 의 시작 Depth 을 반환한다.
    function getRsnDtlStRow(rdoObjName) {
    	
    	var rsnCurrRow = -1;
    	
    	if (rdoObjName.indexOf("_") != -1) {
    		var arrRsnRow = rdoObjName.split("_");
    		
    		rsnCurrRow = parseInt(arrRsnRow[1]) + 1;
    	}
    	
    	return rsnCurrRow;
    }
    
	// Specific Reason 코드값에 따라서 입력해야될 Detail Depth 목록을 지워준다.
    function clearDetailReason() {
    	
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.ColHidden("detail_1_type") = true;    	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_1_type",dtData,daCenter,"detail_1_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_1_type") = 80;    	

    	sheetObj.ColHidden("detail_2_type") = true;    	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_2_type",dtData,daCenter,"detail_2_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_2_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_3_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_3_type",dtData,daCenter,"detail_3_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_3_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_4_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_4_type",dtData,daCenter,"detail_4_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_4_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_5_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_5_type",dtData,daCenter,"detail_5_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_5_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_6_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_6_type",dtData,daCenter,"detail_6_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_6_type") = 80;    	

    	sheetObj.ColHidden("detail_7_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_7_type",dtData,daCenter,"detail_7_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_7_type") = 80;  

    	sheetObj.ColHidden("detail_8_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_8_type",dtData,daCenter,"detail_8_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_8_type") = 80;  

    	sheetObj.ColHidden("detail_9_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_9_type",dtData,daCenter,"detail_9_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_9_type") = 80;  
    	
    	sheetObj.ColHidden("detail_10_type") = true;    	
    	
    	if ( doInitFlg == "Y" ){
	    	for (var j=1;j<sheetObj.rowcount+1; j++) {
	        	sheetObj.CellValue2(j,"detail_1_type") = "";
	        	sheetObj.CellValue2(j,"detail_2_type") = "";
	        	sheetObj.CellValue2(j,"detail_3_type") = "";
	        	sheetObj.CellValue2(j,"detail_4_type") = "";
	        	sheetObj.CellValue2(j,"detail_5_type") = "";
	        	sheetObj.CellValue2(j,"detail_6_type") = "";
	        	sheetObj.CellValue2(j,"detail_7_type") = "";
	        	sheetObj.CellValue2(j,"detail_8_type") = "";
	        	sheetObj.CellValue2(j,"detail_9_type") = "";
	        	sheetObj.CellValue2(j,"detail_10_type") = "";
	    	}
    	}

    }
    
//	// Specific Reason 코드값에 따라서 입력해야될 Detail Depth 목록을 화면에 그려준다.
    function displayDetailReason(formObj, nRsnDtlStRow, nRsnDtlEndRow) {

    	var sheetObj = sheetObjects[1];
    	
    	if (nRsnDtlStRow  < REASON_DETAIL_START) return;
    	if (nRsnDtlEndRow > REASON_DETAIL_END)   return;

		//4.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
    	for (var i=nRsnDtlStRow; i<=REASON_DETAIL_END; i++) {
    	
    		var prefix = "detail_" + i;

    		if (i > nRsnDtlEndRow) {
//				eval(prefix + "_name").innerHTML = "";
//				eval(prefix + "_type").innerHTML = "";    			
    		}
	    	else {
				var fieldName   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_name"));
				var fieldType   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_type"));
				var fieldSize   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_size"));
				var fieldFormat = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_format"));
				var fieldItem   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_item"));
				var fieldCond   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_cond"));
				var fieldPopup  = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_popup"));
				var fieldValue  = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_value"));
				
				var detailType  = "";
				
				if (fieldName != "") {
					
					sheetObj.ColHidden(prefix+"_type") = false;
					sheetObj.CellText(0,prefix+"_type") = fieldName;
					
					if (fieldType == "radio") {
						if (fieldItem.indexOf("|") != -1) {
							for (var j=1;j<sheetObj.rowcount+1; j++) {
								sheetObj.InitCellProperty(j,prefix+"_type",dtCombo,daCenter,prefix+"_type","",dtNull);
								if ( fieldName == "Delivery Term"){
									sheetObj.CellEditable(j,prefix+"_type") = false;
								} else {
									sheetObj.CellEditable(j,prefix+"_type") = true;
								}
							}
							sheetObj.InitDataCombo(0,prefix+"_type",fieldItem,fieldItem);
						}
					}
					else if (fieldType == "textarea") {
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtData, daLeft, prefix+"_type","",dtNull,-1,fieldSize);
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if (fieldFormat == "ymd") {
						
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtData, daCenter,prefix+"_type","",dfDateYmd);						
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if (fieldPopup == "cust_cd"||fieldPopup == "vvd"||fieldPopup == "port"||fieldPopup == "curr_cd") {
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtPopupEdit, daCenter,prefix+"_type","",dfEngUpKey,-1,fieldSize);
							sheetObj.CellValue2(j,"popup_code_"+i) = fieldPopup;
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if ( fieldFormat == "engup"){
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtData, daCenter,prefix+"_type","",dfEngUpKey,-1,fieldSize);
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if ( fieldFormat == "int"){
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type", dtData, daRight,prefix+"_type","",dfNullInteger,-1,fieldSize);
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}						
					} else {
						sheetObj.InitCellProperty(j,prefix+"_type",dtData, daCenter,prefix+"_type","",dtNull,-1,fieldSize);
						sheetObj.CellEditable(j,prefix+"_type") = true;
					}
					
					if ( fieldSize > 15 ){
						sheetObj.ColWidth(prefix+"_type") = 250;
					} else if ( fieldSize > 10 ){
						sheetObj.ColWidth(prefix+"_type") = 180;
					} else {
						sheetObj.ColWidth(prefix+"_type") = 120;
					}
				}
	    	}
    	}
		
    	sheetObj.ColHidden("detail_10_type") = false;    
    	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.CellValue2(j,"detail_10_type") =  sheetObjects[0].CellValue(oldRow, "file_atch_mdt_yn");
    		sheetObj.CellValue2(j,"dmdt_chg_delt_spec_rsn_cd") = sheetObjects[0].CellValue(oldRow, "spec_rsn_cd");
    		
    		if(sheetObjects[0].CellValue(oldRow, "spec_rsn_cd") == "SLIBCD" ){
    			sheetObj.CellValue2(j,"detail_2_type") = sheetObj.CellValue(j,"org_chg_amt");
    		}
    		
//    		// 2016.07.27 Wonki Eo Edit
//    		if(sheetObjects[0].CellValue(oldRow, "spec_rsn_cd") == "SLICEN" ){
//    			sheetObj.CellValue2(j,"detail_1_type") = sheetObj.CellValue(j,"cnee_cd");
//    			sheetObj.CellValue2(j,"detail_2_type") = sheetObj.CellValue(j,"ntfy_cd");
//    		}
//    		
//    		// 2016.08.22 Wonki Eo Edit
//    		if(sheetObjects[0].CellValue(oldRow, "spec_rsn_cd") == "SLIKRG" ){
//    			sheetObj.CellValue2(j,"detail_1_type") = sheetObj.CellValue(j,"sc_no");
//    		}
		}
    	
    	formObj.dmdt_chg_delt_spec_rsn_cd.value = sheetObjects[0].CellValue(oldRow, "spec_rsn_cd");    	
    	
		for(var i=sheetObjects[0].TopRow; i < sheetObjects[0].Rows; i++) {
			sheetObjects[0].RowStatus(i) = "R";
		}
		for(var i=sheetObjects[1].TopRow; i < sheetObjects[1].Rows; i++) {
			sheetObjects[1].RowStatus(i) = "R";
		}
    }
//    
//	// Reason Detail 항목을 화면에 생성해준다.
//    function displayDetailReasonAttach(dtlRow, chkRow) {
//    	var sheetObj = sheetObjects[0];
//    	
//    	var prefix = "detail_" + dtlRow;
//    	
//    	// 첨부파일 필수여부를 보여준다.
//    	eval(prefix + "_name").innerHTML = "Attachment mandatory";
//    	eval(prefix + "_type").innerHTML = sheetObj.CellValue(chkRow, "file_atch_mdt_yn");
//    }

    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */    
    function getCustCd(aryPopupData) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[1];
  		var rsnCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd");
  		
  		with(sheetObj) {
  			CellValue(SelectRow, gObjId) = aryPopupData[0][3];
  			if ( rsnCd == "SLINIK" || rsnCd == "SLIHPP" ){
  				CellValue(SelectRow, "detail_2_type") = aryPopupData[0][4];
  			}
  		}
  		gObjId = "";
    }
    
    /*
  	 * charge Code 값을 해당 필드에 설정 
  	 */    
    function getChgCd(aryPopupData) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[1];

  		with(sheetObj) {
  			CellValue(SelectRow, gObjId) = aryPopupData[0][1];
  		}
  		gObjId = "";
    }
    
    /*
  	 * Curr Code 값을 해당 필드에 설정 
  	 */    
    function getCurrCd(aryPopupData) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[1];

  		with(sheetObj) {
  			CellValue(SelectRow, gObjId) = aryPopupData[0][3];
  		}
  		gObjId = "";
    }   
    
    /*
  	 * Port Code 값을 해당 필드에 설정 
  	 */    
    function getPort(locTp, tab, rArray) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[1];

  		with(sheetObj) {
  			CellValue(SelectRow, gObjId) = rArray[0][2];
  		}
  		gObjId = "";
    }   
       
    /*
  	 * vvd Code값을 해당 필드에 설정 
  	 */    
    function getVvd(rArray) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[1];

  		with(sheetObj) {
  			CellValue(SelectRow, gObjId) = rArray[0][7];
  		}
  		gObjId = "";
    } 
    /*
  	 * 조건에 따라서 Detail Depth 가 변경되어야 할 경우 사용되는 함수
  	 */     
    function condition(rdoObj) {

		// 선택조건이 있고, 조건에 따라서 보여줄 Detail 의 Level 이 변경되어야 하는 경우.
		displaySpecificReasonByCondition(rdoObj.name, rdoObj.value);
    }  
    
 	/**
 	 * 객체를 받아 객체의 이름을 리턴한다.
 	 */
 	function getSrcElementName(formElement) {
 	    var elementName = formElement.name;
 	    if (elementName == "")
 	        elementName = formElement.id;
 	    return elementName;
 	}	
 	
// 	/**
// 	 * Form Control(Container No) 에 이벤트를 추가한다.
// 	 */		
// 	function setEventProcess() {
//
// 	    var formObj = document.form;
// 	    var len = formObj.elements.length - 1;
// 	    var formElement = null;
// 	    var elementName = null;
// 	    
// 	    for (i = 0 ; i <= len ; i++) {
// 	        /** 전체 Element 객체중 현재 커서가 가있는 Element 를 얻어온다. */
// 	        formElement = formObj.elements[i];
// 	        elementName = getSrcElementName(formElement);
//
// 	        /**************************************************************************
// 	         *   EVENT를 선택적으로 타게 하기 위해 eventObj와 elementName을 비교하고  *
// 	         *  동일한 Element에 대해서 Event Skip                                    *
// 	         **************************************************************************/
// 	        if (arguments.length) {
// 	        	isFind = false;
// 	            for (j = 0; j <= arguments.length; j++) {
// 	                if (elementName == arguments[j]) isFind = true;
// 	            }
// 	            if (isFind == true) {
// 	                continue;
// 	            }
// 	            /** 이벤트를 설정하기 위하여 Element List를 생성한다. */
// 	            /** 이벤트는 KeyPress 와 KeyUp만 사용하도록 지정한다. */	            
// 	 	        if (elementName.indexOf("h_detail") == -1) {
// 		        	if (elementName.indexOf("detail_") == 0) {
// 		        		var fieldName = ComGetObjValue(eval("formObj.h_" + elementName + "_rsn_field_name"));
// 		        		if (fieldName.indexOf("CNTR #") == 0) {
// 		        			formElement.attachEvent("onkeyup",     function () { searchContainer(elementName); });
// 		        			formElement.attachEvent("onblur",      function () { searchContainer(elementName); });
// 		        			break;
// 		        		}
// 		        	}
// 		        }	             
// 	        }
// 	        else {
// 	            /** 이벤트를 설정하기 위하여 Element List를 생성한다. */
// 	            /** 이벤트는 KeyPress 와 KeyUp만 사용하도록 지정한다. */	        	
// 	 	        if (elementName.indexOf("h_detail") == -1) {
// 		        	if (elementName.indexOf("detail_") == 0) {
// 		        		var fieldName = ComGetObjValue(eval("formObj.h_" + elementName + "_rsn_field_name"));
// 		        		if (fieldName.indexOf("CNTR #") == 0) {
// 		        			formElement.attachEvent("onkeyup",     function () { searchContainer(elementName); });
// 		        			formElement.attachEvent("onblur",      function () { searchContainer(elementName); });
// 		        			break;
// 		        		}
// 		        	}
// 		        }	        	
// 	        }
// 	    }
// 	}

// 	/**
// 	 * Container No 이벤트
// 	 * param : combo_obj ==> 콤보오브젝트
// 	 */	
//     function searchContainer(elementName) {
//     	
//        var formObj = document.form;
// 		var cntrno  = ComGetObjValue(eval("formObj." + elementName));
// 	 
// 		if (cntrno.length < 10) {
// 			ComSetObjValue(eval("formObj.check_digit_"  + elementName),  "");
// 			ComSetObjValue(eval("formObj.ctnr_tpsz_cd_" + elementName),  "");
// 			return;
// 		}
// 		 
// 		var sheetObj = sheetObjects[0];
// 		var xml = sheetObj.GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntrno);
// 		var rtnValue = ComGetEtcData(xml, "rtnValue");
// 		 
// 		if (ComIsNull(rtnValue)) {
// 			ComSetObjValue(eval("formObj.check_digit_"  + elementName),  "");
// 			ComSetObjValue(eval("formObj.ctnr_tpsz_cd_" + elementName),  "");
// 			return false;
// 	    }		 
// 		
//        var CtnrVal = rtnValue.split("|");
//        if (CtnrVal.length >= 3) {
//            ComSetObjValue(eval("formObj.check_digit_"  + elementName),  CtnrVal[0].substring(10,11));
//            ComSetObjValue(eval("formObj.ctnr_tpsz_cd_" + elementName),  CtnrVal[2]);
//        } 
//        else {
//            ComSetObjValue(eval("formObj.check_digit_"  + elementName),  "");
//            ComSetObjValue(eval("formObj.ctnr_tpsz_cd_" + elementName),  "");
//        }
//         
// 		return true;
//    }  
     
  	/**     
	 * Sheet3 조회완료 후 이벤트 발생
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			ColFontUnderline(PREFIX + FILE_NM) = true;
			DataLinkMouse(   PREFIX + FILE_NM) = true;
		}
	}
	
 	/**
 	 * Sheet3 클릭 이벤트 발생
 	 */
 	function sheet3_OnClick(sheetObj, Row, Col, Value) {

//	    //Approval for Charge Deletion 에서 호출한 경우에만 첨부된 파일이 존재하므로 파일 다운로드를 실행토록 해준다.
//	    if (ComGetObjValue(document.form.prnt_mnu_id) == "EES_DMT_3014") {
//	    	fnDownloadAtchFile(sheetObj, Row, Col);
//	    }
	    
 		// File Upload시 먼저 첨부파일 추가하도록 로직 변경 후 모든 화면에서 호출시 파일 다운로드 가능하도록 변경 (2016.08.08)
		fnDownloadAtchFile(sheetObj, Row, Col); // Edit Point
 	}     
 	
  	/**     
	 * Sheet2 조회완료 후 이벤트 발생
	 */
	function sheet2_OnSearchEnd(ErrMsg) {
		
		// 입력된 값을 조회된 결과값에 매핑시켜준다.
		bindUserSpecificReason();
	}

	/**
     * 저장후 처리
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
		 if (ErrMsg != '' && ErrMsg != 'Data was saved successfully.' ) {	// 저장 오류 발생
			 //ComShowCodeMessage('COM12151', "Tariff Type");
			 saveFlag = "N";
		 } else {
			 saveFlag = "Y";
		 }
    }
	
	
	function sheet2_OnChange(sheetObj, row, col, value) {
		 var formObj = document.form;
		 colName = sheetObj.ColSaveName(col);
		 var selectFlg = "N";
		 var rsnCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"spec_rsn_cd");
		 
		 with(sheetObj) {			 
			 			 
			 if(colName == 'cntr_no') {
		 		var xml = GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + value);
		 		var rtnValue = ComGetEtcData(xml, "rtnValue"); 
		 		
		        var CtnrVal = rtnValue.split("|");
		        if (CtnrVal.length >= 3) {
		            CellValue2(row,col) = CtnrVal[0];
		            CellValue2(row,'cntr_tpsz_cd') = CtnrVal[2];
		        } 
		        else {
		        	CellValue2(row,'cntr_tpsz_cd') = "";
		        	ComShowCodeMessage('DMT00165', 'Container No. ');
					return false;		
		        }
			 }
			 
			 if(colName == 'cntr_no' || colName == 'bkg_no' || colName == 'dmdt_trf_cd' || colName == 'chg_type') {
				 if ( CellValue(row,'cntr_no') != '' && CellValue(row,'bkg_no') != '' && CellValue(row,'dmdt_trf_cd') != ''  && CellValue(row,'chg_type') != ''  ){
					 
						var parm = "bkg_no="+CellValue(row,'bkg_no')
						         + "&cntr_no="+CellValue(row,'cntr_no')
						         + "&dmdt_trf_cd="+CellValue(row,'dmdt_trf_cd')
						         + "&chg_type="+CellValue(row,'chg_type');
						var xml = GetSearchXml ("EES_DMT_3104GS.do", "f_cmd=" + SEARCH10 + "&" + parm);
						var rtnCntrValue = ComGetEtcData(xml, "rtnValue"); 					
						
						var CtnrVal = rtnCntrValue.split("|");
						
						if ( rtnCntrValue != null && CtnrVal[10] == '0'){
						    CellValue2(row,'cntr_cyc_no') = CtnrVal[0];
						    CellValue2(row,'dmdt_chg_loc_div_cd') = CtnrVal[1];
						    CellValue2(row,'chg_seq') = CtnrVal[2];
						    CellValue2(row,'ofc_cd') = CtnrVal[3];
						    CellValue2(row,'svr_id') = CtnrVal[4];

						    CellValue2(row,'fm_mvmt_dt') = CtnrVal[5];
						    CellValue2(row,'to_mvmt_dt') = CtnrVal[6];
						    CellValue2(row,'ft_cmnc_dt') = CtnrVal[7];
						    CellValue2(row,'ft_end_dt') = CtnrVal[8];
						    CellValue2(row,'bil_amt') = CtnrVal[9];						    

						    CellValue2(row,'fm_mvmt_yd_cd') = CtnrVal[11];
						    CellValue2(row,'to_mvmt_yd_cd') = CtnrVal[12];
						    CellValue2(row,'ofc_cd') = CtnrVal[13];
						    CellValue2(row,'fm_mvmt_sts_cd') = CtnrVal[14];
						    CellValue2(row,'to_mvmt_sts_cd') = CtnrVal[15];
						    CellValue2(row,'org_chg_amt') = CtnrVal[16];

							if( rsnCd == "SMRSWC" ||rsnCd == "SMRVST" ||rsnCd == "SOCDP" ){
								spec_rsn_cd = rsnCd;
								spec_rsn_cd_row = row;
								ComSetObjValue(formObj.bkg_no, CellValue(row,'bkg_no')); 
								ComSetObjValue(formObj.io_bnd_cd, CellValue(row,'dmdt_trf_cd').substr(2,1)); 
								ComSetObjValue(formObj.cntr_no, CellValue(row,'cntr_no')); 
								doActionIBSheet(sheetObj, document.form, IBSEARCH_BKGVVD);
								spec_rsn_cd_row = 0;
								spec_rsn_cd = "";
							} else if( rsnCd == "SLIOMC" || rsnCd == "DMGOMC" ){
								if ( CellValue(row,'fm_mvmt_sts_cd') != "OP" || CellValue(row,'to_mvmt_sts_cd') != "MT" ){
									ComShowCodeMessage('DMT00165','OP, MT');
									clearDetailReason();
									return false;		
								}	
							} else if( rsnCd == "SLIDTO" || rsnCd == "CREFXT" ){

								if ( rsnCd == "SLIDTO" && CellValue(row,'ofc_rhq_cd') != "HAMRU" ){
									ComShowCodeMessage('DMT00171','Office(HAMRU)');
									clearDetailReason();
									return false;		
								} 
								else if ( rsnCd == "CREFXT" && CellValue(row,'ofc_cd') != "FXTSC" ){
									ComShowCodeMessage('DMT00165','Office(FXTSC)');
									clearDetailReason();
									return false;		
								} else if ( rsnCd == "CREFXT" && CellValue(row,'dmdt_trf_cd') != "DTIC" ){
									ComShowCodeMessage('DMT00165','DTIC');
									clearDetailReason();
									return false;		
								}
								else if ( rsnCd == "SLIDTO"){
									if ( CellValue(row,'fm_mvmt_sts_cd') != "OP" || CellValue(row,'to_mvmt_sts_cd') != "MT" ){
										ComShowCodeMessage('DMT00165','OP, MT');
										clearDetailReason();
										return false;		
									} else {
										CellValue2(row,'detail_1_type') = CellValue(row,'ofc_cd');
									}
								} 

							}
													    
						} else {
				        	ComShowCodeMessage('DMT00165', 'Booking No, Container No. ');
							CellValue2(row,'cntr_no') = '';
							CellValue2(row,'bkg_no') = '';
							return false;		
						}
				 }
			 }
		 }

		 /** Validation 및 값 세팅부분임.**/
		 var inv_flg = "N";
		 vvd_flg = "N";
		 var port_flg = "N";
		 cust_flg = "N";
		 curr_flg = "N";
		 bkg_flg = "N";
		 spec_rsn_cd_row = row;
		 spec_rsn_cd_col = col;
		 spec_rsn_cd = rsnCd;
		 switch(rsnCd) {
		 	case "SMRSCD":
		 		if(colName == 'detail_1_type') {
		 			if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		}
		 		if(colName == 'detail_2_type') {
		 			if ( value.length != 5 ){
		 				ComShowCodeMessage('DMT03028', 'Port Code');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				port_flg = "Y";
		 			}
		 		}
		 		break;
		 	case "SMRVCH":
		 		if(colName == 'detail_1_type' || colName == 'detail_2_type') {
		 			if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		}
		 		break;
		 	case "SMRSWC":
		 		if(colName == 'detail_1_type' || colName == 'detail_3_type') {
		 			if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		}
		 		break;
		 	case "SMRVSF":
		 		if(colName == 'detail_1_type' || colName == 'detail_3_type') {
		 			if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		}
		 		break;

		 	case "ERCEDI":
		 		if(colName == 'detail_4_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
		 		if(colName == 'detail_6_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
		 		break;
		 	case "ERCDCA":

		 		if(colName == 'detail_1_type') {
		 			if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		} else
		 		if(colName == 'detail_2_type') {
		 			if ( value.length != 5 ){
		 				ComShowCodeMessage('DMT03028', 'Port Code');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				port_flg = "Y";
		 			}
		 		} else
		 		if(colName == 'detail_5_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		} else
		 		if(colName == 'detail_7_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
		 		break;
		 	case "SLINIK":
		 		if(colName == 'detail_1_type') {
		 			cust_flg = "Y";
		 		} else
		 		if(colName == 'detail_3_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
		 		break;
		 	case "SLIHPP":
		 		if(colName == 'detail_1_type') {
		 			cust_flg = "Y";
		 		} else
		 		if(colName == 'detail_3_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
		 		break;
		 	case "SLIBCD":
		 		if(colName == 'detail_5_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		} else if(colName == 'detail_2_type' || colName == 'detail_3_type' || colName == 'detail_4_type') {
		 			var org_amt = sheetObj.CellValue(row,"detail_2_type");
		 			var dc_amt = sheetObj.CellValue(row,"detail_3_type");
		 			var baill_amt = eval(org_amt) - eval(dc_amt);
		 			sheetObj.CellValue2(row,"detail_4_type") = baill_amt;
		 		} else
		 		if(colName == 'detail_6_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "CBDBBT":
		 		if(colName == 'detail_1_type') {
			 		formObj.tpb_no.value = value;
			 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
			 		formObj.dmdt_inv_no.value = "";
			 		formObj.tpb_no.value = "";
		 		} else
		 		if(colName == 'detail_3_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "CREFXT":
		 		if(colName == 'detail_1_type' || colName == 'detail_2_type') {
		 			var cmncDt = sheetObj.CellValue(row,"detail_1_type");
		 			var endDt = sheetObj.CellValue(row,"detail_2_type");
		 			if (!ComIsNull(cmncDt) && !ComIsNull(endDt) ){
		 				sheetObj.CellValue2(row,"detail_3_type") = ComGetDaysBetween(cmncDt, endDt);
		 			}		 				
		 		}else
		 		if(colName == 'detail_3_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "WTMIC":
		 		if(colName == 'detail_1_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		} else
		 		if(colName == 'detail_2_type') {
		 			cust_flg = "Y";
		 		} else
		 		if(colName == 'detail_4_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "SLISIA":
		 		if(colName == 'detail_1_type') {
		 			inv_flg = "Y";
		 			dtType = colName;
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		} else
		 		if(colName == 'detail_2_type') {
		 			cust_flg = "Y";
		 		} else
		 		if(colName == 'detail_3_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		} else if(colName == 'detail_5_type') {
		 			inv_flg = "Y";
		 			dtType = colName;
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		} else
		 		if(colName == 'detail_6_type') {
		 			cust_flg = "Y";
		 		} else
		 		if(colName == 'detail_7_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "CBDAOB":
		 		if(colName == 'detail_1_type') {
					ComSetObjValue(formObj.bkg_no, value); 
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
		 		} else
		 		if(colName == 'detail_3_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "SLIDTO":
		 		if(colName == 'detail_2_type' || colName == 'detail_5_type') {
		 			curr_flg = "Y";
		 			if ( value.length != 3 ){
		 				ComShowCodeMessage('DMT03028', 'Curr.');		
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
			break;
		 	case "ERNBSD":
		 		if(colName == 'detail_1_type' || colName == 'detail_2_type') {
		 			if ( value.length != 12 ){
		 				ComShowCodeMessage('DMT03028', 'Booking No.');
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				spec_rsn_cd = rsnCd;
						spec_rsn_cd_row = row;
						ComSetObjValue(formObj.bkg_no, value); 
						ComSetObjValue(formObj.io_bnd_cd, sheetObj.CellValue(row,'dmdt_trf_cd').substring(2,3)); 
						doActionIBSheet(sheetObj, document.form, IBSEARCH_BKGVVD);
		 			}
		 		}
			break;
		 	case "LPIEGI":
		 		if(colName == 'detail_1_type') {
		 			if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		}
		 		break;
	 		case "SLIWCE":
		 		if(colName == 'detail_4_type') {
			 		formObj.tpb_no.value = value;
			 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
			 		formObj.dmdt_inv_no.value = "";
			 		formObj.tpb_no.value = "";
		 		}
		 		break;
	 		case "SLIFSD":
	 			if(colName == 'detail_3_type') {
	 				if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT00165', 'Manual INV No.');
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} 
//	 				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
	 			}
	 			break;
	 			
	 		// 2016.07.27 SLICEN 해당하는 Sheet2 Setting 추가
	 		case "SLICEN":
	 			if(colName == 'detail_3_type' ){
	 				if ( !ComIsNumber(value) ){
		 				ComShowCodeMessage('DMT00165', 'Approved Free Time');
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} 
	 			}
	 			
	 			if(colName == 'detail_4_type') {
	 				if ( value.length != 9 ){
		 				ComShowCodeMessage('DMT00165', 'Manual INV No.');
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			} 

	 			}
	 			break;
	 			
		 	case "SLISPA":
		 		if(colName == 'detail_4_type') {
		 			inv_flg = "Y";
		 			if ( value.substring(2,3) != "M" ){
		 				alert("It is not DMT Manual INV nbr.");
		 				sheetObj.CellValue2(row,col) = '';
		 				return false;
		 			}
		 		}
		 		break;
		}
		 
		if ( inv_flg == "Y" ){
	 		formObj.dmdt_inv_no.value = value;
	 		spec_rsn_cd = formObj.dmdt_chg_delt_spec_rsn_cd.value;
	 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
	 		formObj.dmdt_inv_no.value = "";
		}
		if ( vvd_flg == "Y" ){
	 		formObj.vvd_cd.value = value;
	 		spec_rsn_cd = formObj.dmdt_chg_delt_spec_rsn_cd.value;
	 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
	 		formObj.vvd_cd.value = "";
		}
		if ( port_flg == "Y" ){
	 		formObj.loc_cd.value = value;
	 		spec_rsn_cd = formObj.dmdt_chg_delt_spec_rsn_cd.value;
	 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_LOC);
	 		formObj.loc_cd.value = "";
		}
		if ( curr_flg == "Y" ){
	 		formObj.curr_cd.value = value;
	 		spec_rsn_cd = formObj.dmdt_chg_delt_spec_rsn_cd.value;
	 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_BKGVVD);
	 		formObj.curr_cd.value = "";
		}
		if ( cust_flg == "Y" ){
	 		formObj.s_cust_cd.value = value;
	 		spec_rsn_cd = formObj.dmdt_chg_delt_spec_rsn_cd.value;
	 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_CUST);
	 		formObj.s_cust_cd.value = "";
		}
		vvd_flg = "N";
		curr_flg = "N";
		cust_flg = "N";
		spec_rsn_cd_row = 0;
		spec_rsn_cd_col = "";
		spec_rsn_cd = "";
		
		colName = "";
		/****************************/
		return true;
	}

	function bindUserSpecificReason() {
		var formObj = document.form;
  		var sheetObj = sheetObjects[1];
		
		//inact_sts_cd 세팅
		ComSetObjValue(formObj.inact_sts_cd, sheetObj.CellValue(1, "sts_cd"));
		ComSetObjValue(formObj.inact_rqst_no, sheetObj.CellValue(1, "inact_rqst_no"));
		ComSetObjValue(formObj.inact_apro_no, sheetObj.CellValue(1, "inact_apro_no"));
		
		//Inactivation Reason Entry 세팅
		var deltSpecRsnCd = sheetObj.CellValue(1, "dmdt_chg_delt_spec_rsn_cd");

		//Inactivation Specific Reason View 		
		var sheetObj1     = sheetObjects[0];
		for (var i=1; i<sheetObj1.RowCount+1; i++) {
			if (sheetObj1.CellValue(i, "spec_rsn_cd") == deltSpecRsnCd) {
				sheetObj1.CellValue(i, "chk") = "1";
				sheetObj1.SelectCell(i, 0, false);

				//Sheet1 에 대해서 Click 이벤트를 발생시킨다.
//				displayInactivationDetailReason(sheetObj1, i);
				break;
			}
		}
		
		for (var i = 1; i <= sheetObj.RowCount+1; i ++) {
			// 승인권한이 있는 Deletion 요청건만 활성화 시켜서, 선택가능하도록 해준다.
			if (sheetObj.CellValue(i, "chg_delt_usr_yn") == "Y") {
				//승인권한단계를 설정한다.
				sheetObj.CellValue2(i, "chg_delt_path_cd") = ComGetObjValue(document.form.chg_delt_path_cd);
			}
	   }
		
	}

	/**
	 * Comment History 의 Row 가 선택될 때 해당 Comment 를 보여준다.
	 */	
	function sheet4_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj = document.form;
		
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			if (!formObj.chkComment.checked) {
				ComSetObjValue(formObj.corr_rmk, sheetObj.CellValue(NewRow, "inact_rmk"));
			}
		}		
	}
	/*
	 * 선택한 조건값에 따라서 보여줘야 될 Detail Level 이 변경해야될 경우 처리해주는 함수
	 */
	function displaySpecificReasonByCondition(objName, objValue) {
		var formObj   = document.form;
    	var fieldCond = ComGetObjValue(eval("formObj.h_" + objName + "_rsn_field_cond"));
    	
    	// 선택조건이 존재할 경우
    	if (fieldCond != "") {
    		var nRsnDtlEndRow = 0;

	    	if (fieldCond.indexOf("|") != -1) {
	    		var arrCond = fieldCond.split("|");
	    		for (var r=0; r<arrCond.length; r++) {
	    			if (arrCond[r].indexOf("=") != -1) {
	    				var arrSubCond = arrCond[r].split("=");
	    				if (objValue == arrSubCond[0]) {
	    					nRsnDtlEndRow = arrSubCond[1];
	    					break;
	    				}
	    			}
	    		}
	    	}
	
//	    	if (nRsnDtlEndRow != 0) {
//	    		displayDetailReason(formObj, getRsnDtlStRow(objName), nRsnDtlEndRow);
//
//	    		var dtlRow = parseInt(nRsnDtlEndRow) + 1;
//	    		var chkRow = sheetObjects[0].FindCheckedRow("chk").replace("|", "");
//	
//	    		displayDetailReasonAttach(dtlRow, chkRow);
//	    	}
    	}
	}
			
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function fnDownloadAtchFile(sheetObj, Row, Col) {
		
		if (Col != 2) return;
 
		// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if (sheetObj.CellText(Row, PREFIX + FILE_NM) == "") {
			return;
		}

		// 파일이 존재시 다운로드 받는다.
		var fileSavId = sheetObj.CellValue(Row, PREFIX + FILE_SAV_ID);
		var exist     = fnSaveFileExist(fileSavId, sheetObj);

		// 서버에 파일존재유무확인
		if (eval(exist)) {
			var param = "key=" + fileSavId;
			hiddenFrame.location.href = URL_FILE_DOWNLOAD + "?" + param;
		}
		else {
			alert("Attached File is deleted due to storage server capacity");
		}	
	} 	
	
	/**
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * param :file_id
	 * return :boolean
	 */
	function fnSaveFileExist(fileSavId, sheetObj) {
		var formObj = document.form;
		var param   = "&f_cmd=" + SEARCH26 + "&file_sav_id=" + fileSavId;
		var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", param);
		var exist   = ComGetEtcData(sXml, "is_exists");
		return exist;
	}
	
	/**
	 * 용량계산하기  <br>
	 * @param {String} 	_val 		파일용량
	 * @param {String} 	r_value    	MB/KB계산 
	 **/
	function getSize(_val) {

		var r_value = _val;
		var _value = Math.round(_val / 1024);

		if (_value > 0) {
			r_value = _value;
			_value = Math.round(_value / 1024);
			if (_value > 0) {
				_value = _value + " MB"
			} 
			else {
				_value = r_value + " KB"
			}
		} 
		else {
			_value = r_value + " Bytes"
		}
		return _value;
	}	
	

   	/**
   	 * Rate Adjustment 항목을 선택하거나 선택해제시 수행해야할 동작을 정의하는 함수
   	 */	
  	 function checkComment() {
  		var formObj 	= document.form;
 		var sheetHSTObj	= sheetObjects[3];
 		
 		with(formObj) {
 			if (chkComment.checked) {
 				ComSetObjValue(corr_rmk, "");
 			}
 			else {
 				ComSetObjValue(corr_rmk, sheetHSTObj.CellValue(sheetHSTObj.SelectRow, "inact_rmk"));
 			}
 			
			//Comment 활성화 / 비활성화+++++++++++++++++++++++++
			//ComEnableObject(formObj.comment, false);
 			corr_rmk.readOnly 	= !chkComment.checked;
			if (chkComment.checked) {
				corr_rmk.className = "textarea1";
			}
			else {
				corr_rmk.className = "textarea2";
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++
 	 	}  		
  	}
  	 
  	 function doActionRowAdd(){
  		var formObj 	= document.form;
 		var sheetObj	= sheetObjects[1];
  		
 		var rowNo = sheetObj.DataInsert(-1);
 		sheetObj.CellValue2(rowNo,"chg_type") = "G";
 		// Reason Detail 항목을 화면에 생성해준다.
    	displayDetailReason(formObj, REASON_DETAIL_START, REASON_DETAIL_END);
 		
  	 }
  	 
  	 function doActionRowDelete(){
   		var formObj 	= document.form;
  		var sheetObj	= sheetObjects[1];
  		
		if (sheetObj.FindCheckedRow("chk") != "") {
			if (!confirm("Are you sure to delete?")) { 
				return;
			}
			//ComRowHideDelete(sheetObj, "chk");

			//Row 삭제
			var sRow = sheetObj.FindCheckedRow("chk");
			var arrow = sRow.split("|");

			for (idx = arrow.length-2; idx >= 0; idx--){
				sheetObj.RowDelete(arrow[idx], false);
			}			
			
			//doActionIBSheet(sheetObj, document.form, IBSAVE);
		} 
		else {
			alert("No Selected Row");
			//ComShowCodeMessage("BKG00249");// "No Selected Row";
		}
   	 }
  	 

  	/*
  	 * Approval 버튼 클릭시 이벤트 처리
  	 */
  	function doActionApproval() {
  		var formObj = document.form;
  		
   		// DMT00135 : Do you want to {?msg1}?
   		if (!ComShowCodeConfirm("DMT00135", "Approval")) return;
    	
  		// Approval 실행
//   		setChgDeltStsCd("A");	// Approval
   		chgDeltStsCd = "A";
  		doActionIBSheet(sheetObjects[1], formObj, IBDELSAVE);
  	}
  	

 	/*
 	 * Reject 버튼 클릭시 이벤트 처리
 	 */ 	
 	function doActionReject() {
 		var formObj = document.form;
 		
  		// DMT00135 : Do you want to {?msg1}?
  		if (!ComShowCodeConfirm("DMT00135", "Reject")) return;
    	     	
// 		// Reject 실행
//  		setChgDeltStsCd("J");	// Reject
  		chgDeltStsCd = "J";
 		doActionIBSheet(sheetObjects[1], document.form, IBDELSAVE);
 	}
 	

 	/*
 	 * 조회결과에서 선택된 행에 주어진 값을 설정한다.
 	 */  	
 	function setChgDeltStsCd(chgDeltStsCd) {

 		with(sheetObjects[1]) {
	 		var chkRow = FindCheckedRow("chk");
	 		if (chkRow != "") {
	 			  //가져온 행을 배열로 반든다.
	 			  var arrRow = chkRow.split("|");
	 			  for (idx=0; idx<arrRow.length-1; idx++) { 
	 				  CellValue2(arrRow[idx], "chg_delt_sts_cd") = chgDeltStsCd;
	 			  }
	 		}
 		}
 	} 	
 	
 	/*
	 * 권한에 따른 Approval, Reject 버튼 상태제어
	 */
	function initBtnByAuth() {
		var formObj = document.form;

		if (ComGetObjValue(formObj.chg_delt_path_cd) != "" && sheetObjects[1].CellValue(1, "chg_delt_usr_yn") == "Y" ) {
	        ComBtnEnable("btn_approval");
	        ComBtnEnable("btn_reject");
		}
		else {
			ComBtnDisable("btn_approval");
			ComBtnDisable("btn_reject");
		}
	}
	
     //########################################################< CHARGE SPECIFIC REASON 기능 추가 - END >############################################################################     
	/* 개발자 작업  끝 */