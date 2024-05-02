/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0023.js
*@FileTitle : SPCL CGO Approved Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
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
     * @class vop_scg_0023 : vop_scg_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0023() {
    	this.processButtonClick		= processButtonClick;
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
    var tabCnt     = 0 ;
    var beforetab  = 1;
    var nexttab    = -1;
    var searchTab  = -1;

    var sheetObjects = new Array();
    var sheetCnt     = 0;
    
    var comboObjects = new Array();
	var comboCnt     = 0;
	
	var map1_ct      = 0;
	var sheet1RowCt  = 0;
    var searchEndBlk = true;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        
        var tabObj   	= tabObjects[0];

        /*******************************************************/
        var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrive":
                	doActionIBSheet(sheetObjects[getIdx()],formObj,IBSEARCH,'BTN');
                	
                    break;

                case "btn_new":
                	if(!validateForm(sheetObjects[getIdx()],formObj,IBCLEAR,'BTN')) return;
                	
                	ComResetAll();
                	
                	ComSetFocus(formObj.rgn_shp_opr_cd);
                	
                	ComAddSeparator(document.form.from_eta_dt);
                    ComAddSeparator(document.form.to_eta_dt);
                    
                    btnEnabled(sheetObjects[getIdx()], false);
                    searchTab = -1;
                	
                    break;
                    
                case "btn_Save":
                	doActionIBSheet(sheetObjects[getIdx()],formObj,IBSAVE,'BTN');
                	
                	break;
                    
                case "btn_t1appl0":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].SelectRow);
                    break;
                case "btn_t1appl1":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].SelectRow);
                    break;
                case "btn_t1appl2":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].SelectRow);
                    break;
                case "btn_t1appl3":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].SelectRow);
                    break;
                case "btn_t1appl4":
                	doPopDetails(sheetObjects[getIdx()], sheetObjects[getIdx()].SelectRow);
                    break;

                case "btn_t1downExcel0":
                    var paramObj = new Object();
                    paramObj.title = "[DG]SPCL CGO Approved Details";
                    var url = ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    sheetObjects[getIdx()].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
                	
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[DG]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel1":
                    var paramObj = new Object();
                    paramObj.title = "[Awkward]SPCL CGO Approved Details";
                    var url = ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    sheetObjects[getIdx()].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[Awkward]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel2":
                    var paramObj = new Object();
                    paramObj.title = "[Break Bulk]SPCL CGO Approved Details";
                    var url = ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    sheetObjects[getIdx()].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[Break Bulk]SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel3":
                    var paramObj = new Object();
                    paramObj.title = "[45']SPCL CGO Approved Details";
                    var url = ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    sheetObjects[getIdx()].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[45']SPCL CGO Approved Details",false,"");                	
                    break;
                case "btn_t1downExcel4":
                    var paramObj = new Object();
                    paramObj.title = "[Reefer]SPCL CGO Approved Details";
                    var url = ComScgGetPgmTitle(sheetObjects[getIdx()], paramObj);  
                    sheetObjects[getIdx()].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
//                	sheetObjects[getIdx()].SpeedDown2Excel(-1,false,false,"","",false,false,"[Reefer]SPCL CGO Approved Details",false,"");                	
                    break;
                    
                case "btn_SlanCd":
	 				onPopupClick(srcName, "Lane");
	 				break;
	 				
                case "btn_VVDpop":
	 				onPopupClick(srcName, "VVD");
	 				break;
	 				
                case "btn_Pol":
	 				onPopupClick(srcName, "POL");
	 				break;
	 				
                case "btn_Pod":
	 				onPopupClick(srcName, "POD");
	 				break;
	 				
                case "btn_Carrier":
	 				onPopupClick(srcName, "Carrier");
	 				break;
	 				
                case "btn_UNNo":
	 				onPopupClick(srcName, "UNNo");
	 				break;
	 				
                case "btn_Calendar":
                	var cal = new ComCalendarFromTo();                	
                	cal.select(formObj.from_eta_dt, formObj.to_eta_dt, 'yyyy-MM-dd');
                	
                	//var calFormObj = document.getElementById(cal.divName+"IFrame").contentWindow.document;
                	
                	//calFormObj.getElementById("from").value = ComGetObjValue(formObj.from_eta_dt);
                	//calFormObj.getElementById("to").value = ComGetObjValue(formObj.to_eta_dt);
	                
	 				break;
                case "btn_t1mail1": case "btn_t1mail3":
                	sendReqMail(sheetObjects[getIdx()], sheetObjects[getIdx()].selectRow, formObj);
                	
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
     * 요청 메일 보내기
     */
    function sendReqMail(sheetObj, Row, formObj) {      	
    	if(Row == -1) {
  			//ComShowCodeMessage("SCG50018");	//'Please use after Retrieve.'
  			return;
  		} else {  		  	
		  	var crr_cd                 = sheetObj.CellValue(Row, "crr_cd");
		  	var bkg_ref_no             = sheetObj.CellValue(Row, "bkg_ref_no");
		  	var spcl_cgo_rqst_seq      = sheetObj.CellValue(Row, "spcl_cgo_rqst_seq");
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++) {

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
			
        }

        for(k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
        }
        
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        
        ComAddSeparator(document.form.from_eta_dt);
        ComAddSeparator(document.form.to_eta_dt);
    }
     
    /**
     * 버튼 비/활성화
     */
    function btnEnabled(sheetObj, what) {
    	var sheetNo = getIdx();
    	with(sheetObj) {    		
	      	Enable = what;
	      	if(what) {
	      		if(RowCount != 0) {
		      		ComBtnEnable("btn_t1appl"+sheetNo);
		      		ComBtnEnable("btn_t1downExcel"+sheetNo);
		      		ComBtnEnable("btn_t1mail"+sheetNo);
	      		}
	      	} else {
	      		ComBtnDisable("btn_t1appl"+sheetNo);
		      	ComBtnDisable("btn_t1downExcel"+sheetNo);
		      	ComBtnDisable("btn_t1mail"+sheetNo);
	      	}
    	}
    }
    
    /**
     * t1sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t1sheet1_OnLoadFinish(sheetObj) {	
    	 btnEnabled(sheetObj, false);
    	 
    	 doActionIBCombo(comboObjects[0],1);
    	 doActionIBCombo(comboObjects[1],2);
    }
    
   /**
    * t2sheet1 OnLoadFinish Event 처리
    * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
    * 
    */
   function t2sheet1_OnLoadFinish(sheetObj) {	
   		btnEnabled(sheetObj, false);
   }  
   
   /**
    * t3sheet1 OnLoadFinish Event 처리
    * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
    * 
    */
   function t3sheet1_OnLoadFinish(sheetObj) {	
   	 	btnEnabled(sheetObj, false);
   }  
   
   /**
    * t4sheet1 OnLoadFinish Event 처리
    * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
    * 
    */
   function t4sheet1_OnLoadFinish(sheetObj) {	
   	 	btnEnabled(sheetObj, false);
   } 
   
   /**
    * t5sheet1 OnLoadFinish Event 처리
    * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
    * 
    */
   function t5sheet1_OnLoadFinish(sheetObj) {	
   	 	btnEnabled(sheetObj, false);
   }  
     
    /**
     * t1sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	if(searchEndBlk) {
	    	//MPA1 초기화
	    	map1_ct = 0;
	    	sheet1RowCt = 0;
	    	sheetObj.FrozenCols = 12;
	    	sheetObj.MergeSheet = msPrevColumnMerge + msHeaderOnly;
			
	    	//조회된 건이 있을 경우에만 수행
	  		with (sheetObj) {	
	 			if(RowCount != 0) {	
	 				ColumnSort("cgo_opr_cd|bkg_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
	 				
	 				btnEnabled(sheetObj, true);
	 				var seqNo = 0;
	 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
	 	    		var net_wgt_sum, psa_no, flsh_pnt_cdo_temp, mpa1_yn;
	  				for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
	  					//자사일 경우 BKG COMP 고정 셋팅
	  					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') CellValue2(checkRow, "cgo_opr_cd") = "SML";
	  					
	  					setAuthStat(sheetObj, checkRow);
	  					if(CellValue(checkRow, "cgo_opr_cd") == 'SML' && CellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
	  						//CellEditable(checkRow, "apro_ref_no") = true;
	  					if(CellValue(checkRow, "cgo_opr_cd") != 'SML')
	  						CellEditable(checkRow, "spcl_cgo_auth_cd") = true;
	  					
	  					CellValue2(checkRow, "bkg_ref_no") = CellValue(checkRow, "bkg_no");
	  					CellValue2(checkRow, "auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
	  					CellValue2(checkRow, "org_auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
	  					
	  					//MPA1 여부 확정
	  					net_wgt_sum       = CellValue(checkRow, "net_wgt_sum");
	  					psa_no            = CellValue(checkRow, "psa_no");
	  					flsh_pnt_cdo_temp = CellValue(checkRow, "flsh_pnt_cdo_temp");
	  					if(net_wgt_sum == "-1") {
	  						mpa1_yn = "N";
	  					} else {
	  						if(psa_no == '1' || (flsh_pnt_cdo_temp != '' && parseInt(flsh_pnt_cdo_temp,10) < -25)) {
	  							mpa1_yn = "Y";
	  							map1_ct++;
	  						} else mpa1_yn = "N";
	  					}  					
	  					CellValue2(checkRow, "mpa1_yn") = mpa1_yn;
	  					
	  					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
	  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
	  					} else {
	  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
	  					}
	  					
	  					if(rqstSeq1 != rqstSeq2) seqNo++;
	  					
	  					CellValue2(checkRow, "seqNum") = seqNo;
	 	    			
	 	    			rqstSeq2 = rqstSeq1;
	 	    			
	 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
	 	    				if(CellValue(checkRow, checkCol) == '') CellValue2(checkRow, checkCol) = ' ';
	 	    			}
	  					
	  					RowStatus(checkRow) = 'R';
	  				} 
	  				
	  				sheet1RowCt = RowCount;	  					  				
	  				//MPA1 Filtering
	  				filterMpa1List(sheetObj, document.form, sheet1RowCt, 'search');
	  				SumText(0, "seqNum") = "TOTAL";
	  			} else {
	  				btnEnabled(sheetObj, false);
	  				CountFormat = "[SELECTDATAROW / ROWCOUNT]";
	  			}
	  		}
    	}
    }
     
    /**
     * t2sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      	//조회된 건이 있을 경우에만 수행
		with (sheetObj) {		
 			if(RowCount != 0) {   
 				ColumnSort("cgo_opr_cd|bkg_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
 				
 				btnEnabled(sheetObj, true);
 				var seqNo = 0;
 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
				for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
					//자사일 경우 BKG COMP 고정 셋팅
					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') CellValue2(checkRow, "cgo_opr_cd") = "SML";
					
					setAuthStat(sheetObj, checkRow);
					if(CellValue(checkRow, "cgo_opr_cd") == 'SML' && CellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
						//CellEditable(checkRow, "apro_ref_no") = true;
					if(CellValue(checkRow, "cgo_opr_cd") != 'SML')
						CellEditable(checkRow, "spcl_cgo_auth_cd") = true;
					
					CellValue2(checkRow, "bkg_ref_no") = CellValue(checkRow, "bkg_no");
					CellValue2(checkRow, "auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
					CellValue2(checkRow, "org_auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
					if(CellValue(checkRow, "spcl_cntr_seq") == '') CellValue2(checkRow, "spcl_cntr_seq") = CellValue(checkRow, "awk_cgo_seq");
					
					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
					
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					CellValue2(checkRow, "seqNum") = seqNo;
 	    			
 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(CellValue(checkRow, checkCol) == '') CellValue2(checkRow, checkCol) = ' ';
 	    			}
					
					RowStatus(checkRow) = 'R';
				} 
				
				if(CellValue(HeaderRows+1, "cgo_opr_cd") != 'SML') {
					ComBtnDisable("btn_t1appl1");
					ComBtnEnable("btn_t1mail1");
				} else {
					ComBtnEnable("btn_t1appl1");
					ComBtnDisable("btn_t1mail1");
				}
			} else {
  				btnEnabled(sheetObj, false);
  			}
		}
    }
    
    /**
     * t3sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      	//조회된 건이 있을 경우에만 수행
		with (sheetObj) {		
 			if(RowCount != 0) {	
 				ColumnSort("cgo_opr_cd|bkg_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
 				
 				btnEnabled(sheetObj, true);
 				var seqNo = 0;
 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
				for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
					//자사일 경우 BKG COMP 고정 셋팅
					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') CellValue2(checkRow, "cgo_opr_cd") = "SML";
					
					setAuthStat(sheetObj, checkRow);
					if(CellValue(checkRow, "cgo_opr_cd") == 'SML' && CellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
						//CellEditable(checkRow, "apro_ref_no") = true;
					if(CellValue(checkRow, "cgo_opr_cd") != 'SML')
						CellEditable(checkRow, "spcl_cgo_auth_cd") = true;
					
					CellValue2(checkRow, "spcl_cntr_seq") = CellValue(checkRow, "bb_cgo_seq");
					CellValue2(checkRow, "auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
					CellValue2(checkRow, "org_auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
					
					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
					
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					CellValue2(checkRow, "seqNum") = seqNo;
 	    			
 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(CellValue(checkRow, checkCol) == '') CellValue2(checkRow, checkCol) = ' ';
 	    			}
					
					RowStatus(checkRow) = 'R';
				} 
			} else {
  				btnEnabled(sheetObj, false);
  			}
		}
    }
    
    /**
     * t4sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      	//조회된 건이 있을 경우에만 수행
		with (sheetObj) {		
 			if(RowCount != 0) {  
 				ColumnSort("cgo_opr_cd|bkg_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");
 				
 				btnEnabled(sheetObj, true);
 				var seqNo = 0;
 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
				for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
					//자사일 경우 BKG COMP 고정 셋팅
					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') CellValue2(checkRow, "cgo_opr_cd") = "SML";
					
					setAuthStat(sheetObj, checkRow);
					//45인 경우 무조건 Aproval No. Key In
 					//변경 2010.01.25 서동호부장님 요청 승인일경우만 수정 할 수있다
					if (CellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
						//CellEditable(checkRow, "apro_ref_no") = true;
						
					if(CellValue(checkRow, "cgo_opr_cd") != 'SML')
						CellEditable(checkRow, "spcl_cgo_auth_cd") = true;
					
					CellValue2(checkRow, "bkg_ref_no") = CellValue(checkRow, "bkg_no");
					CellValue2(checkRow, "auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
					CellValue2(checkRow, "org_auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
					if(CellValue(checkRow, "spcl_cntr_seq") == '') CellValue2(checkRow, "spcl_cntr_seq") = sheetObj.CellValue(checkRow, "awk_cgo_seq");
					
					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
					
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					CellValue2(checkRow, "seqNum") = seqNo;
 	    			
 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(CellValue(checkRow, checkCol) == '') CellValue2(checkRow, checkCol) = ' ';
 	    			}
					
					RowStatus(checkRow) = 'R';
				} 
				
				if(CellValue(HeaderRows+1, "cgo_opr_cd") != 'SML') {
					ComBtnDisable("btn_t1appl3");
					ComBtnEnable("btn_t1mail3");
				} else {
					ComBtnEnable("btn_t1appl3");
					ComBtnDisable("btn_t1mail3");
				}
			} else {
  				btnEnabled(sheetObj, false);
  			}
		}
    }
     
    /**
     * t5sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
       	//조회된 건이 있을 경우에만 수행
 		with (sheetObj) {		
 			if(RowCount != 0) {  
 				ColumnSort("cgo_opr_cd|bkg_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd","ASC");	
 				
 				btnEnabled(sheetObj, true);
 				var seqNo = 0;
 	    		var rqstSeq1 = -1, rqstSeq2 = -1;
 				for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
 					//자사일 경우 BKG COMP 고정 셋팅
 					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') CellValue2(checkRow, "cgo_opr_cd") = "SML";
 					
 					setAuthStat(sheetObj, checkRow);
 					//Reefer 인 경우 무조건 Aproval No. Key In 
 					//변경 2010.01.25 서동호부장님 요청 승인일경우만 수정 할 수있다
					if (CellValue(checkRow, "spcl_cgo_auth_cd") == "Y")
						//CellEditable(checkRow, "apro_ref_no") = true;
 					
 					if(CellValue(checkRow, "cgo_opr_cd") != 'SML')
 						CellEditable(checkRow, "spcl_cgo_auth_cd") = true;
 					
 					CellValue2(checkRow, "spcl_cntr_seq") = CellValue(checkRow, "rc_seq");
 					CellValue2(checkRow, "auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
 					CellValue2(checkRow, "org_auth_sts_cd") = CellValue(checkRow, "spcl_cgo_auth_cd");
 					
 					if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
 					
  					if(rqstSeq1 != rqstSeq2) seqNo++;
  					CellValue2(checkRow, "seqNum") = seqNo;
 	    			
 	    			rqstSeq2 = rqstSeq1;
 	    			
 	    			for(var checkCol=0; checkCol<SaveNameCol("seqNo"); checkCol++) {
 	    				if(CellValue(checkRow, checkCol) == '') CellValue2(checkRow, checkCol) = ' ';
 	    			}
 					
 					RowStatus(checkRow) = 'R';
 				} 
 			} else {
  				btnEnabled(sheetObj, false);
  			}
 		}
    }    
    
    /**
     * t1sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t1sheet1_OnClick(sheetObj, Row, Col, Val) {
    	with(sheetObj) {
    		if(SaveNameCol("spcl_cgo_auth_cd") == Col && CellEditable(Row, Col)) {
    			var auth_cd = CellValue(Row, "org_auth_sts_cd");  			
		 		InitDataCombo(0, "spcl_cgo_auth_cd", auth_cd+"|R", auth_cd+"|R");
    		}
	 		if(SaveNameCol("apro_ref_no") == Col && CellValue(Row, "cgo_opr_cd") == 'SML' && CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	 		}else if(SaveNameCol("apro_ref_no") == Col && (CellValue(Row, "cgo_opr_cd") != 'SML' && CellText(Row, "apro_ref_no") != "" )) {
	 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 80, 50);	 			
	 		}
	 		
    	}
    }
    
    /**
     * t1sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	with(sheetObj) { 
    		if(SaveNameCol("spcl_cgo_auth_cd") == Col) {
    			setAuthStat(sheetObj, Row);
    			CellValue2(Row, "auth_sts_cd") = Value;
	    		if(CellValue(Row, "spcl_cgo_auth_cd") != 'R') {		    		
	    			RowStatus(Row) = 'R';
	    		}
    		}
    	}
    }
     
    /**
     * t2sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet1_OnClick(sheetObj, Row, Col, Val) {
     	with(sheetObj) {
     		if(SaveNameCol("spcl_cgo_auth_cd") == Col && CellEditable(Row, Col)) {
     			var auth_cd = CellValue(Row, "org_auth_sts_cd");  			
 		 		InitDataCombo(0, "spcl_cgo_auth_cd", auth_cd+"|R", auth_cd+"|R");
     		}
	 		if(SaveNameCol("apro_ref_no") == Col && CellValue(Row, "cgo_opr_cd") == 'SML' && CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	 		}else if(SaveNameCol("apro_ref_no") == Col && (CellValue(Row, "cgo_opr_cd") != 'SML' && CellText(Row, "apro_ref_no") != "" )) {
	 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 80, 50);
	 		}
     	}
    }
     
    /**
     * t2sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
     	with(sheetObj) { 
     		if(SaveNameCol("spcl_cgo_auth_cd") == Col) {
     			setAuthStat(sheetObj, Row);
     			CellValue2(Row, "auth_sts_cd") = Value;
 	    		if(CellValue(Row, "spcl_cgo_auth_cd") != 'R') {		    		
 	    			RowStatus(Row) = 'R';
 	    		}
     		}
     	}
    }
    
    /**
     * t3sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t3sheet1_OnClick(sheetObj, Row, Col, Val) {
      	with(sheetObj) {
      		if(SaveNameCol("spcl_cgo_auth_cd") == Col && CellEditable(Row, Col)) {
      			var auth_cd = CellValue(Row, "org_auth_sts_cd");  			
  		 		InitDataCombo(0, "spcl_cgo_auth_cd", auth_cd+"|R", auth_cd+"|R");
      		}
	 		if(SaveNameCol("apro_ref_no") == Col && CellValue(Row, "cgo_opr_cd") == 'SML' && CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	 		}else if(SaveNameCol("apro_ref_no") == Col && (CellValue(Row, "cgo_opr_cd") != 'SML' && CellText(Row, "apro_ref_no") != "" )) {
	 			ComShowMemoPad(sheetObj, Row, Col, true, 200, 80, 50);
	 		}
      	}
    }
      
    /**
     * t3sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
      	with(sheetObj) { 
      		if(SaveNameCol("spcl_cgo_auth_cd") == Col) {
      			setAuthStat(sheetObj, Row);
      			CellValue2(Row, "auth_sts_cd") = Value;
  	    		if(CellValue(Row, "spcl_cgo_auth_cd") != 'R') {		    		
  	    			RowStatus(Row) = 'R';
  	    		}
      		}
      	}
    }
    
    /**
     * t4sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t4sheet1_OnClick(sheetObj, Row, Col, Val) {
       	with(sheetObj) {
       		if(SaveNameCol("spcl_cgo_auth_cd") == Col && CellEditable(Row, Col)) {
       			var auth_cd = CellValue(Row, "org_auth_sts_cd");  			
   		 		InitDataCombo(0, "spcl_cgo_auth_cd", auth_cd+"|R", auth_cd+"|R");
       		}
	 		if(SaveNameCol("apro_ref_no") == Col && CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	 		}
       	}
    }
       
    /**
     * t4sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t4sheet1_OnChange(sheetObj, Row, Col, Value) {
       	with(sheetObj) { 
       		if(SaveNameCol("spcl_cgo_auth_cd") == Col) {
       			setAuthStat(sheetObj, Row);
       			CellValue2(Row, "auth_sts_cd") = Value;
   	    		if(CellValue(Row, "spcl_cgo_auth_cd") != 'R') {		    		
   	    			RowStatus(Row) = 'R';
   	    		}
       		}
       	}
    }
     
    /**
     * t5sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t5sheet1_OnClick(sheetObj, Row, Col, Val) {
       	with(sheetObj) {
       		if(SaveNameCol("spcl_cgo_auth_cd") == Col && CellEditable(Row, Col)) {
       			var auth_cd = CellValue(Row, "org_auth_sts_cd");  			
   		 		InitDataCombo(0, "spcl_cgo_auth_cd", auth_cd+"|R", auth_cd+"|R");
       		}
	 		if(SaveNameCol("apro_ref_no") == Col && CellText(Row, "spcl_cgo_auth_cd") == "Y") {
	 			ComShowMemoPad(sheetObj, Row, Col, false, 200, 80, 50);
	 		}
       	}
    }
       
    /**
     * t5sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t5sheet1_OnChange(sheetObj, Row, Col, Value) {
       	with(sheetObj) { 
       		if(SaveNameCol("spcl_cgo_auth_cd") == Col) {
       			setAuthStat(sheetObj, Row);
       			CellValue2(Row, "auth_sts_cd") = Value;
   	    		if(CellValue(Row, "spcl_cgo_auth_cd") != 'R') {		    		
   	    			RowStatus(Row) = 'R';
   	    		}
       		}
       	}
    }
     
    /**
     * t1sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     */
 	function t1sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
    		if(!CellEditable(Row, Col)) doPopDetails(sheetObj, Row);		
    	}
 		return;
 	}
 	
 	/**
     * t2sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     */
 	function t2sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		if(!CellEditable(Row, Col)) doPopDetails(sheetObj, Row);		
      	}
 		return;
 	}
 	
 	/**
     * t3sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     */
 	function t3sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		if(!CellEditable(Row, Col)) doPopDetails(sheetObj, Row);		
      	}
 		return;
 	}
 	
 	/**
     * t4sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     */
 	function t4sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		if(!CellEditable(Row, Col)) doPopDetails(sheetObj, Row);		
      	}
 		return;
 	}
 	
 	/**
     * t5sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     */
 	function t5sheet1_OnDblClick(sheetObj,Row,Col,Value){	
    	with(sheetObj) {
      		if(!CellEditable(Row, Col)) doPopDetails(sheetObj, Row);		
      	}
 		return;
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
	    				if (arr[i] != SaveNameCol("seqNo") && parseInt(arr[i]) <= parseInt(SaveNameCol("auth_dt"))) ColHidden(arr[i]) = false;
	    			}
	        		break;
	        	case "전체 삭제 취소" :
	        		for(var idx=0; idx<=LastCol; idx++) {
	        			if (idx != SaveNameCol("seqNo") && idx <= SaveNameCol("auth_dt")) {
	        				ColHidden(idx) = false;
	        			}
	        		}
	        		break;
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
 	    				if (arr[i] != SaveNameCol("seqNo") && parseInt(arr[i]) <= parseInt(SaveNameCol("auth_dt"))) ColHidden(arr[i]) = false;
 	    			}
 	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx != SaveNameCol("seqNo") && idx <= SaveNameCol("auth_dt")) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
 	    	}
 	 	}    	 
    }
    
    /**
     * t3sheet1 OnSelectMenu Event 처리
     * param : sheetObj ==> 시트오브젝트, sAction
     * 
     */
    function t3sheet1_OnSelectMenu(sheetObj, sAction){
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
 	    				if (arr[i] != SaveNameCol("seqNo") && parseInt(arr[i]) <= parseInt(SaveNameCol("auth_dt"))) ColHidden(arr[i]) = false;
 	    			}
 	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx != SaveNameCol("seqNo") && idx <= SaveNameCol("auth_dt")) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
 	    	}
 	 	}    	 
    }
    
    /**
     * t4sheet1 OnSelectMenu Event 처리
     * param : sheetObj ==> 시트오브젝트, sAction
     * 
     */
    function t4sheet1_OnSelectMenu(sheetObj, sAction){
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
 	    				if (arr[i] != SaveNameCol("seqNo") && parseInt(arr[i]) <= parseInt(SaveNameCol("auth_dt"))) ColHidden(arr[i]) = false;
 	    			}
 	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx != SaveNameCol("seqNo") && idx <= SaveNameCol("auth_dt")) {
 	        				ColHidden(idx) = false;
 	        			}
 	        		}
 	        		break;
 	    	}
 	 	}    	 
    }
    
    /**
     * t5sheet1 OnSelectMenu Event 처리
     * param : sheetObj ==> 시트오브젝트, sAction
     * 
     */
    function t5sheet1_OnSelectMenu(sheetObj, sAction){
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
 	    				if (arr[i] != SaveNameCol("seqNo") && parseInt(arr[i]) <= parseInt(SaveNameCol("auth_dt"))) ColHidden(arr[i]) = false;
 	    			}
 	        		break;
 	        	case "전체 삭제 취소" :
 	        		for(var idx=0; idx<=LastCol; idx++) {
 	        			if (idx != SaveNameCol("seqNo") && idx <= SaveNameCol("auth_dt")) {
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
    	var t1Mpa1Yn = document.form.t1Mpa1.checked;
    	var t1Mpa1SelCt = 0;
    	with(sheetObj) {
 	    	for(var i=HeaderRows; i<=LastRow-1; i++) {   //except total row
 	    		RowBackColor(i)  = RgbColor(255, 255, 255);
 	    		
 	    		if(t1Mpa1Yn && !RowHidden(i) && NewRow>=i) {
 	    			t1Mpa1SelCt++
 	    		}
 	    	}
 	     	if(NewRow > 1) RowBackColor(NewRow)  = RgbColor(231, 250, 246);
 	     	
 	     	if (t1Mpa1Yn) {
 	     		CountFormat = "["+t1Mpa1SelCt+" / "+map1_ct+"]";
 	     	}
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
 	     	
 	     	if(CellValue(NewRow, "cgo_opr_cd") != 'SML') {
 	     		ComBtnDisable("btn_t1appl1");
 	     		ComBtnEnable("btn_t1mail1");
 	     	} else {
 	     		ComBtnEnable("btn_t1appl1");
 	     		ComBtnDisable("btn_t1mail1");
 	     	}
     	}
    }
    
    /**
     * t3sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 NewRow ==> NewRow, 선택한 NewCol ==> NewCol
     * 
     */
    function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	with(sheetObj) {
 	    	for(var i=HeaderRows; i<=LastRow; i++) {
 	    		RowBackColor(i)  = RgbColor(255, 255, 255);
 	    	}
 	     	if(NewRow > 1) RowBackColor(NewRow)  = RgbColor(231, 250, 246);
     	}
    }
    
    /**
     * t4sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 NewRow ==> NewRow, 선택한 NewCol ==> NewCol
     * 
     */
    function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	with(sheetObj) {
 	    	for(var i=HeaderRows; i<=LastRow; i++) {
 	    		RowBackColor(i)  = RgbColor(255, 255, 255);
 	    	}
 	     	if(NewRow > 1) RowBackColor(NewRow)  = RgbColor(231, 250, 246);
 	     	
 	     	if(CellValue(NewRow, "cgo_opr_cd") != 'SML') {
 	     		ComBtnDisable("btn_t1appl3");
 	     		ComBtnEnable("btn_t1mail3");
 	     	} else {
 	     		ComBtnEnable("btn_t1appl3"); 	     		
 	     		ComBtnDisable("btn_t1mail3");
 	     	}
     	}
    }
    
    /**
     * t5sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 NewRow ==> NewRow, 선택한 NewCol ==> NewCol
     * 
     */
    function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	with(sheetObj) {
 	    	for(var i=HeaderRows; i<=LastRow; i++) {
 	    		RowBackColor(i)  = RgbColor(255, 255, 255);
 	    	}
 	     	if(NewRow > 1) RowBackColor(NewRow)  = RgbColor(231, 250, 246);
     	}
    }
     
    /**
     * Combo 선택시 이벤트 관련
     * 포커스 이동
     */
    function rgn_shp_opr_cd_OnChange(comboObj , Index_Code, Text) {
         if(Text != '') ComSetFocus(document.form.auth_flg[0]);
    }     
    
    function setAuthStat(sheetObj, Row) {
    	with(sheetObj) { 
    		var authStsCd = CellValue(Row, "spcl_cgo_auth_cd");
    		
    		var authStsColor = RgbColor(255, 134, 43);
    		CellFont("FontBold", Row, "spcl_cgo_auth_cd") = true;
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
			CellFontColor(Row, "spcl_cgo_auth_cd") = authStsColor;
    	}    	
    }
    
    /**
  	 * Dangerous CGO Application Details for Partner Lines (Pop-Up)<br>
  	 */
  	function doPopDetails(sheetObj, Row) {
  		if(Row == -1 || sheetObj.TotalRows == 0) {
  			ComShowCodeMessage("SCG50018");	//'Please use after Retrieve.'
  		} else {
  			var rgn_shp_opr_cd = sheetObj.CellValue(Row, "rgn_shp_opr_cd");
		  	if(rgn_shp_opr_cd == '') rgn_shp_opr_cd = document.all.rgn_shp_opr_cd.Code;
  			
		  	var sParam = Array();
		  	sParam[0] = "rgn_shp_opr_cd="+rgn_shp_opr_cd;
		  	
		  	var paramNm = "";
			for(var col=1; col<=sheetObj.LastCol; col++){
				paramNm = sheetObj.ColSaveName(col);
				sParam[col] = paramNm+"="+sheetObj.CellValue(Row, col);
			} 
			
			var bkg_company = sheetObj.CellValue(Row, "cgo_opr_cd");
			var tabIdx = getIdx();
			if(tabIdx == 0) {
				if(bkg_company != 'SML') {
					ComOpenWindowCenter("VOP_SCG_1022.do?mode=view&"+sParam.join("&"), "winViewDtl", "1060", "545", true);
				} else {
					var scg_flg = "SCG_DG";
					
					ComOpenPopup("VOP_SCG_0015.do?type=P&scg_flg="+scg_flg+"&bkg_no="+sheetObj.CellText(sheetObj.SelectRow, "bkg_no")
							                   +"&vvd_cd="+sheetObj.CellText(sheetObj.SelectRow, "vsl_cd")
							                              +sheetObj.CellText(sheetObj.SelectRow, "skd_voy_no")
							                              +sheetObj.CellText(sheetObj.SelectRow, "skd_dir_cd")
							                   +"&dg_cntr_seq="+sheetObj.CellText(sheetObj.SelectRow, "spcl_cntr_seq")
							                   +"&cntr_cgo_seq="+sheetObj.CellText(sheetObj.SelectRow, "spcl_cgo_seq")
							                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.CellText(sheetObj.SelectRow, "spcl_cgo_apro_rqst_seq")
							     , 1023, 650, "", '0,0', true, false, sheetObj.SelectRow, 0, tabIdx, "VOP_SCG_0015");
					
				}
			} else if(tabIdx == 1 || tabIdx == 3) {
				if(bkg_company == 'SML') {
					var scg_flg = "SCG_AWK";
					if(tabIdx == 3) scg_flg = "SCG_45";
					
					ComOpenPopup("VOP_SCG_0016.do?type=P&scg_flg="+scg_flg+"&bkg_no="+sheetObj.CellText(sheetObj.SelectRow, "bkg_no")
							                   +"&vvd_cd="+sheetObj.CellText(sheetObj.SelectRow, "vsl_cd")
							                              +sheetObj.CellText(sheetObj.SelectRow, "skd_voy_no")
							                              +sheetObj.CellText(sheetObj.SelectRow, "skd_dir_cd")
							                   +"&awk_cgo_seq="+sheetObj.CellText(sheetObj.SelectRow, "awk_cgo_seq")
							                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.CellText(sheetObj.SelectRow, "spcl_cgo_apro_rqst_seq")
							     , 1023, 650, "", '0,0', true, false, sheetObj.SelectRow, 0, tabIdx, "VOP_SCG_0016");
					
				}
			} else if(tabIdx == 2) {				
				ComOpenPopup("VOP_SCG_0017.do?type=P&scg_flg=SCG_BB&bkg_no="+sheetObj.CellText(sheetObj.SelectRow, "bkg_no")
						                   +"&vvd_cd="+sheetObj.CellText(sheetObj.SelectRow, "vsl_cd")
						                              +sheetObj.CellText(sheetObj.SelectRow, "skd_voy_no")
						                              +sheetObj.CellText(sheetObj.SelectRow, "skd_dir_cd")
						                   +"&bb_cgo_seq="+sheetObj.CellText(sheetObj.SelectRow, "bb_cgo_seq")
						                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.CellText(sheetObj.SelectRow, "spcl_cgo_apro_rqst_seq")
						     , 1023, 660, "", '0,0', true, false, sheetObj.SelectRow, 0, tabIdx, "VOP_SCG_0017");
			} else if(tabIdx == 4) {				
				ComOpenPopup("VOP_SCG_0018.do?type=P&scg_flg=SCG_RF&bkg_no="+sheetObj.CellText(sheetObj.SelectRow, "bkg_no")
						                   +"&vvd_cd="+sheetObj.CellText(sheetObj.SelectRow, "vsl_cd")
						                              +sheetObj.CellText(sheetObj.SelectRow, "skd_voy_no")
						                              +sheetObj.CellText(sheetObj.SelectRow, "skd_dir_cd")
						                   +"&rc_seq="+sheetObj.CellText(sheetObj.SelectRow, "rc_seq")
						                   +"&spcl_cgo_apro_rqst_seq="+sheetObj.CellText(sheetObj.SelectRow, "spcl_cgo_apro_rqst_seq")
						     , 1023, 593, "", '0,0', true, false, sheetObj.SelectRow, 0, tabIdx, "VOP_SCG_0018");
			}
  		}
  	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "t1sheet1":      
                with (sheetObj) {

                    // 높이 설정
                    style.height = 319;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 50);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL|RJT\nCD";
                    HeadTitle1    += "|APVL\nRef. No.|Sequence|Sequence|TPSZ|TP|UN No.\n/Seq.| |Class";
                    HeadTitle1    += "|Sub\nrisks|Segregation\nGroup|MP|PG|LQ|EQ|FP\n(℃)|Weight|Weight|Weight|PSA|Net Exp.\nWeight(KG)|RQST DT|APVL DT||||||||||||||||||||||";

                    var HeadTitle2 = "No.|Lane| | | |POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL|RJT\nCD";
                    HeadTitle2    += "|APVL\nRef. No.|CNTR|CGO|TPSZ|TP| | |Class";
                    HeadTitle2    += "|Sub\nrisks|Segregation\nGroup|MP|PG|LQ|EQ|FP\n(℃)|Gross|Net|UOM|PSA|Net Exp.\nWeight(KG)|RQST DT|APVL DT||||||||||||||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 12, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,     "seqNum",     				false,          "",      dfNone ,      0,      false,     false);
                    
					InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "slan_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,     "vsl_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,     "skd_voy_no",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	17,    daCenter,  true,     "skd_dir_cd",     			false,          "",      dfNone ,      0,      false,     false);

					InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,     "por_cd",                   false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	47,    daCenter,  true,     "pol_cd",                   false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     "pol_clpt_ind_seq",         false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	47,    daCenter,  true,     "pod_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     "pod_clpt_ind_seq",     	false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,     "del_cd",     				false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "cgo_opr_cd",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	105,   daCenter,  true,     "bkg_no",     			    false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	40,    daCenter,  true,     "bkg_sts_cd",     	        false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,	"seqNo",                    false,          "spcl_cgo_seq");
					InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenter,  true,     "spcl_cgo_auth_cd",     	false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,     "spcl_cgo_auth_rjct_cd",    false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,  true,     "apro_ref_no",     			false,          "",      dfNone ,      0,      false,     false, 50);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "spcl_cntr_seq",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "spcl_cgo_seq",     		false,          "",      dfNone ,      0,      false,     false);

                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "cntr_tpsz_cd",     		false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,     "dg_tp",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  false,    "imdg_un_no",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	25,    daCenter,  false,    "imdg_un_no_seq",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "imdg_clss_cd",     		false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	75,    daCenter,  true,     "imdg_subs_rsk_lbl_cd",     false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	90,    daLeft,    true,     "imdg_segr_grp_no",     	false,          "",      dfNone ,      0,      false,     false);					
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "mrn_polut_flg",     		false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "imdg_pck_grp_cd",     		false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "imdg_lmt_qty_flg",     	false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,  true,     "imdg_expt_qty_flg",     	false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	35,    daRight,   true,     "flsh_pnt_cdo_temp",        false,          "",      dfNone ,      0,      false,     false);
                   
                    InitDataProperty(0, cnt++ , dtAutoSum,      70,    daRight,   true,     "grs_wgt",     				false,          "",      dfNullFloat , 3,      false,     false);
                    InitDataProperty(0, cnt++ , dtAutoSum,      70,    daRight,   true,     "net_wgt",     				false,          "",      dfNullFloat , 3,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,     "wgt_ut_cd",     	    	false,          "",      dfNone ,      0,      false,     false);
    				InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "psa_no",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtAutoSum,      75,    daRight,   true,     "net_explo_wgt",     		false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     "rqst_dt",     			    false,          "",      dfDateYmd ,   0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	70,    daCenter,  true,     "auth_dt",     				false,          "",      dfDateYmd ,   0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "crr_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "net_wgt_sum");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "mpa1_yn");
					
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,     "ibflag");
					
					//자사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_apro_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "vsl_pre_pst_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "vsl_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_seq");
					//자사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_cate_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "dcgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "rc_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "bb_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "awk_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "rgn_shp_opr_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_no");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_rmk");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "pod_yd_cd");
					
					//타사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "bkg_ref_no");
					//타사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "auth_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "org_auth_sts_cd");
					
         			//MassOfSearch 	  = true;
         			//ScrollTrack       = false;
                    HeadRowHeight     = 20;
                    RequestTimeOut    = 300;
                    //EditableColorDiff = false;
                    MultiSelection    = true;
                    
                    InitDataCombo(0,   "spcl_cgo_auth_cd", "R|Y|N", "R|Y|N");
                    InitDataValid(0,   "apro_ref_no", vtEngUpOther, "1234567890");
                    
                    SetMergeCell(0, 2, 2, 3);	//VVD CD
                    SetMergeCell(0, 6, 2, 2);	//POL
                    SetMergeCell(0, 8, 2, 2);	//POD
                    SetMergeCell(0, 22, 2, 2);	//UN No.
                    
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
                    //ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";

                }
                break;
            case "t2sheet1":    
                with (sheetObj) {

                    // 높이 설정
                    style.height = 340;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1  = "No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle1     += "|RJT\nCD|APVL\nRef. No.|CNTR\nSeq.|TPSZ|Over All (cm)|Over All (cm)|Over All (cm)|Over Dimension (cm)|Over Dimension (cm)";
                    HeadTitle1     += "|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\nExtd|Gross\nWeight|Gross\nWeight|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||||";

                    var HeadTitle2  = "No.|Lane| | | |POR| | |POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle2     += "|RJT\nCD|APVL\nRef. No.|CNTR\nSeq.|TPSZ|L|W|H|FWD|AFT";
                    HeadTitle2     += "|Left|Right|Height|Post\nExtd|Weight|UOM|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 12, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,    "seqNum",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "slan_cd",     				false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "vsl_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "skd_voy_no",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	17,    daCenter,  true,    "skd_dir_cd",     			false,          "",      dfNone ,      0,      false,     false);

					InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "por_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pol_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pol_clpt_ind_seq",          false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pod_cd",     			    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pod_clpt_ind_seq",     	    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "del_cd",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "cgo_opr_cd",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "bkg_no",     			    false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	40,    daCenter,  true,    "bkg_sts_cd",     	        false,          "",      dfNone ,      0,      false,     false);
                    
					InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,   "seqNo",                     false,          "spcl_cntr_seq");
					InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenter,  true,    "spcl_cgo_auth_cd",     		false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,    "spcl_cgo_auth_rjct_cd",     false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,  true,    "apro_ref_no",     			false,          "",      dfNone ,      0,      false,     false, 50);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "spcl_cntr_seq",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,     	40,    daCenter,  true,    "cntr_tpsz_cd",     		    false,          "",      dfNone ,      0,      false,     false);

                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,    "ttl_dim_len",     		    false,          "",      dfNumber ,    0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,    "ttl_dim_wdt",     		    false,          "",      dfNumber ,    0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daRight,   true,    "ttl_dim_hgt",     		    false,          "",      dfNumber ,    0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtData,      	40,    daRight,   true,    "fwrd_ovr_dim_len",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daRight,   true,    "bkwd_ovr_dim_len",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daRight,   true,    "lf_sd_ovr_dim_len",         false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daRight,   true,    "rt_sd_ovr_dim_len",     	false,          "",      dfNone ,      0,      false,     false);                    
                    InitDataProperty(0, cnt++ , dtData,      	45,    daRight,   true,    "hgt_ovr_dim_len",     		false,          "",      dfNone ,      0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "post_extd",     		    false,          "",      dfNone ,      0,      false,     false);                    
                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "grs_wgt",     		        false,          "",      dfNullFloat , 3,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,    "wgt_ut_cd",     	    	false,          "",      dfNone ,      0,      false,     false);
        			InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,    "void_slt_qty",     		    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daLeft,    true,    "cmdt_desc",     		    false,          "",      dfNone ,      0,      false,     false);
                   
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "rqst_dt",     			    false,          "",      dfDateYmd ,   0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "auth_dt",     				false,          "",      dfDateYmd ,   0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "crr_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_seq");
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,    "ibflag");
                    
                    //자사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_apro_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "vsl_pre_pst_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "vsl_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_auth_seq");
					//자사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_cate_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "dcgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "rc_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "bb_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "awk_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "rgn_shp_opr_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_auth_no");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_auth_rmk");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "pod_yd_cd");
					
					//타사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "bkg_ref_no");
					//타사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "auth_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "org_auth_sts_cd");
					
         			//MassOfSearch 	  = true;
         			//ScrollTrack       = false;
                    HeadRowHeight     = 20;
                    RequestTimeOut    = 300;
                    //EditableColorDiff = false;
                    MultiSelection    = true;
                    
                    SetMergeCell(0, 2, 2, 3);	//VVD CD
                    SetMergeCell(0, 6, 2, 2);	//POL
                    SetMergeCell(0, 8, 2, 2);	//POD
                    
                    InitDataCombo(0,   "spcl_cgo_auth_cd", "R|Y|N", "R|Y|N");
                    InitDataValid(0,   "apro_ref_no", vtEngUpOther, "1234567890");
                    
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
                    //ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";

                }
                break;

            case "t3sheet1":    
                with (sheetObj) {

                	// 높이 설정
                    style.height = 340;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1  = "No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle1     += "|RJT\nCD|APVL\nRef. No.|CGO\nSeq.|Length\n(cm)|Width\n(cm)|Height\n(cm)";
                    HeadTitle1     += "|Gross\nWeight|Gross\nWeight|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||";

                    var HeadTitle2  = "No.|Lane| | | |POR| | |POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle2     += "|RJT\nCD|APVL\nRef. No.|CGO\nSeq.|Length\n(cm)|Width\n(cm)|Height\n(cm)";
                    HeadTitle2     += "|Weight|UOM|Void\n(FEU)|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 12, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,    "seqNum",     		        false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "slan_cd",     				false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "vsl_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "skd_voy_no",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	17,    daCenter,  true,    "skd_dir_cd",     			false,          "",      dfNone ,      0,      false,     false);

					InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "por_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pol_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pol_clpt_ind_seq",          false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pod_cd",     			    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pod_clpt_ind_seq",     	    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "del_cd",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "cgo_opr_cd",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "bkg_no",     			    false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	40,    daCenter,  true,    "bkg_sts_cd",     	        false,          "",      dfNone ,      0,      false,     false);
                    
					InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,   "seqNo",                     false,          "spcl_cntr_seq");
					InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenter,  true,    "spcl_cgo_auth_cd",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,    "spcl_cgo_auth_rjct_cd",     false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,  true,    "apro_ref_no",     			false,          "",      dfNone ,      0,      false,     false, 50);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "spcl_cntr_seq",     		false,          "",      dfNone ,      0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "dim_len",     		        false,          "",      dfNumber ,    0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "dim_wdt",     		        false,          "",      dfNumber ,    0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "dim_hgt",     		        false,          "",      dfNumber ,    0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "grs_wgt",     		        false,          "",      dfNullFloat , 3,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,    "wgt_ut_cd",     	    	false,          "",      dfNone ,      0,      false,     false);
        			InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,    "void_slt_qty",     		    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daLeft,    true,    "cmdt_desc",     		    false,          "",      dfNone ,      0,      false,     false);
                   
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "rqst_dt",     			    false,          "",      dfDateYmd ,   0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "auth_dt",     				false,          "",      dfDateYmd ,   0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "crr_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_seq");
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,    "ibflag");
                    
                    //자사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_apro_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "vsl_pre_pst_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "vsl_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_seq");
					//자사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_cate_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "dcgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "rc_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "bb_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "awk_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "rgn_shp_opr_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_no");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_rmk");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "pod_yd_cd");
					
					//승인상태 원복용
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "auth_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "org_auth_sts_cd");
					
         			//MassOfSearch 	  = true;
         			//ScrollTrack       = false;
                    HeadRowHeight     = 20;
                    RequestTimeOut    = 300;
                    //EditableColorDiff = false;
                    MultiSelection    = true;
                    
                    SetMergeCell(0, 2, 2, 3);
                    SetMergeCell(0, 6, 2, 2);
                    SetMergeCell(0, 8, 2, 2);
                    
                    InitDataCombo(0,   "spcl_cgo_auth_cd", "R|Y|N", "R|Y|N");
                    InitDataValid(0,   "apro_ref_no", vtEngUpOther, "1234567890");
                    
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
                    //ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
					
                }
                break;

            case "t4sheet1":    
                with (sheetObj) {

                	// 높이 설정
                    style.height = 340;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1  = "No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle1     += "|RJT\nCD|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
                    HeadTitle1     += "|Gross\nWeight|Gross\nWeight|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||||";

                    var HeadTitle2  = "No.|Lane| | | |POR| | |POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle2     += "|RJT\nCD|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
                    HeadTitle2     += "|Weight|UOM|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 12, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,    "seqNum",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "slan_cd",     				false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "vsl_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "skd_voy_no",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	17,    daCenter,  true,    "skd_dir_cd",     			false,          "",      dfNone ,      0,      false,     false);

					InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "por_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pol_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pol_clpt_ind_seq",          false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pod_cd",     			    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pod_clpt_ind_seq",     	    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "del_cd",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "cgo_opr_cd",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "bkg_no",     			    false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	40,    daCenter,  true,    "bkg_sts_cd",     	        false,          "",      dfNone ,      0,      false,     false);
                    
					InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,   "seqNo",                     false,          "spcl_cntr_seq");
					InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenter,  true,    "spcl_cgo_auth_cd",     		false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,    "spcl_cgo_auth_rjct_cd",     false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,  true,    "apro_ref_no",     			false,          "",      dfNone ,      0,      false,     false, 50);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "spcl_cntr_seq",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,     	40,    daCenter,  true,    "cntr_tpsz_cd",     		    false,          "",      dfNone ,      0,      false,     false);

                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "grs_wgt",     		        false,          "",      dfNullFloat , 3,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,    "wgt_ut_cd",     	    	false,          "",      dfNone ,      0,      false,     false);
        			InitDataProperty(0, cnt++ , dtData,      	80,    daLeft,    true,    "cmdt_desc",     		    false,          "",      dfNone ,      0,      false,     false);
                   
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "rqst_dt",     			    false,          "",      dfDateYmd ,   0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "auth_dt",     				false,          "",      dfDateYmd ,   0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "crr_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_seq");
                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,    "ibflag");
                    
                    //자사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_apro_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "vsl_pre_pst_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "vsl_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_auth_seq");
					//자사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_cate_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "dcgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "rc_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "bb_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "awk_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "rgn_shp_opr_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_auth_no");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_auth_rmk");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "pod_yd_cd");
					
					//타사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "spcl_cgo_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "bkg_ref_no");
					//타사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "auth_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,    "org_auth_sts_cd");
					
         			//MassOfSearch 	  = true;
         			//ScrollTrack       = false;
                    HeadRowHeight     = 20;
                    RequestTimeOut    = 300;
                    //EditableColorDiff = false;
                    MultiSelection    = true;
                    
                    SetMergeCell(0, 2, 2, 3);	//VVD CD
                    SetMergeCell(0, 6, 2, 2);	//POL
                    SetMergeCell(0, 8, 2, 2);	//POD
                    
                    InitDataCombo(0,   "spcl_cgo_auth_cd", "R|Y|N", "R|Y|N");
                    InitDataValid(0,   "apro_ref_no", vtEngUpOther, "1234567890");
                    
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
                    //ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
					
                }
                break;

            case "t5sheet1":    
                with (sheetObj) {

                	// 높이 설정
                    style.height = 340;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1  = "No.|Lane|VVD CD|VVD CD|VVD CD|POR|POL|POL|POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle1     += "|RJT\nCD|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
                    HeadTitle1     += "|Gross\nWeight|Gross\nWeight|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||";

                    var HeadTitle2  = "No.|Lane| | | |POR| | |POD|POD|DEL|BKG\nCOMP|BKG\nRef. No.|BKG\nSTS||APVL";
                    HeadTitle2     += "|RJT\nCD|APVL\nRef. No.|CNTR\nSeq.|TPSZ";
                    HeadTitle2     += "|Weight|UOM|Commodity|RQST\nDT|APVL\nDT|||||||||||||||||||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 12, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,    "seqNum",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "slan_cd",     				false,          "",      dfNone ,      0,      false,     false);
					
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "vsl_cd",     				false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,    "skd_voy_no",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	17,    daCenter,  true,    "skd_dir_cd",     			false,          "",      dfNone ,      0,      false,     false);

					InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "por_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pol_cd",                    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pol_clpt_ind_seq",          false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "pod_cd",     			    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	20,    daCenter,  true,    "pod_clpt_ind_seq",     	    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	42,    daCenter,  true,    "del_cd",     				false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "cgo_opr_cd",     			false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "bkg_no",     			    false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	40,    daCenter,  true,    "bkg_sts_cd",     	        false,          "",      dfNone ,      0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,		0,	   daCenter,  false,   "seqNo",                     false,          "spcl_cntr_seq");
					InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenter,  true,    "spcl_cgo_auth_cd",     		false,          "",      dfNone ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  true,    "spcl_cgo_auth_rjct_cd",     false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	110,   daCenter,  true,    "apro_ref_no",     			false,          "",      dfNone ,      0,      false,     false, 50);
                    
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,    "spcl_cntr_seq",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,     	40 ,   daCenter,  true,    "cntr_tpsz_cd",     		    false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	75,    daRight,   true,    "grs_wgt",     		        false,          "",      dfNullFloat , 3,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,         30,    daCenter,  true,    "wgt_ut_cd",     	    	false,          "",      dfNone ,      0,      false,     false);
        			InitDataProperty(0, cnt++ , dtData,      	80,    daLeft,    true,    "cmdt_desc",     		    false,          "",      dfNone ,      0,      false,     false);
                   
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "rqst_dt",     			    false,          "",      dfDateYmd ,   0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,  true,    "auth_dt",     				false,          "",      dfDateYmd ,   0,      false,     false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "crr_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_seq");
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daCenter,  true,     "ibflag");
                    
                    //자사 키
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_apro_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "vsl_pre_pst_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "vsl_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_seq");
					//자사 키외
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_cate_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "dcgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "rc_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "bb_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "awk_cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "rgn_shp_opr_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_no");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "spcl_cgo_auth_rmk");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "pol_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "pod_yd_cd");
					
					//승인상태 원복용
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "auth_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,       0,     daCenter,  true,     "org_auth_sts_cd");
					
         			//MassOfSearch 	  = true;
         			//ScrollTrack       = false;
                    HeadRowHeight     = 20;
                    RequestTimeOut    = 300;
                    //EditableColorDiff = false;
                    MultiSelection    = true;
                    
                    SetMergeCell(0, 2, 2, 3);
                    SetMergeCell(0, 6, 2, 2);
                    SetMergeCell(0, 8, 2, 2);
                    
                    InitDataCombo(0,   "spcl_cgo_auth_cd", "R|Y|N", "R|Y|N");
                    InitDataValid(0,   "apro_ref_no", vtEngUpOther, "1234567890");
                    
    	 			//2010.02.02 서동호부장님 요청으로 인한 주석처리
                    //ActionMenu = "컬럼 삭제|-|컬럼 삭제 취소|-|전체 삭제 취소";
                }
                break;

        }
    }
     
    // 이벤트 Catch Listener
    function initControl() {
         // Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
         axon_event.addListenerFormat ('focus',    'obj_focus',      form);
         axon_event.addListenerFormat ('blur',     'obj_focusout',   form);
         axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
         axon_event.addListener       ('keydown',  'ComKeyEnter',   'form');
         axon_event.addListenerForm   ('change',   'obj_change', 	 form);
         axon_event.addListenerForm   ('click',    'obj_click', 	 form); 
    }
    
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_focus() {
    	switch(event.srcElement.name){ 
	    	case "from_eta_dt":	case "to_eta_dt":	
	    		ComClearSeparator(event.srcElement);
	        	break;
    	}
    }
    
    // 업무 자바스크립트 OnFocusOut 이벤트 처리
    function obj_focusout() {
    	pastEventNum = 0;
    	var formObj = document.form;
    	with(event.srcElement) {
	    	switch(name) { 
		    	case "slan_cd1":
		    		searchLaneCheck();						//Lane Check
		        	break;
		    	case "skd_dir_cd":	
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
		    			searchVVDCheck();						//VVD Check
		    		}
		        	break;
		    	case "pol_cd": case "pod_cd":	 
		    		searchPortCheck(event.srcElement);		//Port Check
		        	break;
		    	case "cgo_opr_cd":	
		    		searchCarrierCheck(event.srcElement);	//Carrier Check
		        	break;
		    	case "imdg_un_no":	
		    		searchUNNoCheck(event.srcElement);		//UN No. Check
		        	break;
		    	case "imdg_un_no_seq":	
		    		searchUNNoCheck(event.srcElement);		//UN No. Seq. Check
		        	break;
		    	case "from_eta_dt":	
		    		ComAddSeparator(event.srcElement);
		    		break;
		    	case "to_eta_dt":
		    		//조회기간 제약
		    		if (ComAddSeparator(event.srcElement)) {
			    		if (ComGetObjValue(formObj.from_eta_dt) != '' && ComGetObjValue(formObj.to_eta_dt) != '') {
	    		        	if(ComGetDaysBetween(ComGetObjValue(formObj.from_eta_dt), ComGetObjValue(formObj.to_eta_dt)) > 31) {
    		        			ComShowCodeMessage('SCG50032', 'month');
    		        			value = "";
    		        			ComSetFocus(event.srcElement);
	    		        	}else{
						    	formObj.from_eta_dt.className = "input1";
						    	formObj.to_eta_dt.className = "input1";
						    	formObj.vsl_cd.className = "input";
						    	formObj.skd_voy_no.className = "input";
						    	formObj.skd_dir_cd.className = "input";
	    		        	}
			    		}
			    		
		    		}		    		
		        	break;
	    	}
	    }
    } 
    
    // 업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "slan_cd1":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	    	case "vsl_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "pol_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "pod_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "cgo_opr_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "booking_no":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "apro_ref_no":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "imdg_un_no":	
	    	        	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "imdg_un_no_seq":	
	    	        	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "prp_shp_nm":	
	    	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|58|59|60|61|62|63|64|91|92|93|94|95|96|123|124|125|126');
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
		        	break;
		    	case "skd_voy_no":		
	    			ComSetObjValue(formObj.skd_dir_cd, "");
	    			
	    			//ComSetObjValue(formObj.vsl_eng_nm, "");
		        	break;
		    	case "skd_dir_cd":	    			
	    			//ComSetObjValue(formObj.vsl_eng_nm, "");
		        	break;
	    	}
    	}
    }
    
    // 업무 자바스크립트 OnClick 이벤트 처리
    function obj_click() {
   	 	var formObj = document.form; 	 		
   	 	switch(event.srcElement.name){
   	 		case "t1Mpa1":
   	 			if(sheet1RowCt>0) filterMpa1List(sheetObjects[getIdx()], formObj, 'click');
   	 			break;
   	 	}
    }
    
    //Only MPA1 처리
    function filterMpa1List(sheetObj, formObj, sheet1RowCt, source) {
    	with(sheetObj) {
    		if(source == 'click') Redraw = false;
    		
    		var seqNo = 0;
    		var rqstSeq1 = -1, rqstSeq2 = -1;
    		var rowState, firstRow;
	    	if (formObj.t1Mpa1.checked) {
	    		for ( var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
	    			if(CellValue(checkRow, "mpa1_yn") == 'N') RowHidden(checkRow) = true;
	    			else {
	    				if(rqstSeq2 == -1) firstRow = checkRow;
	    				
	    				rowState = RowStatus(checkRow);
	    				
	    				if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
	  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
	  					} else {
	  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
	  					}
	    				
	    				if(rqstSeq1 != rqstSeq2) seqNo++;	  					
	  					CellValue2(checkRow, "seqNum") = seqNo;	 	    			
	 	    			rqstSeq2 = rqstSeq1;

	 	    			if(rowState == 'R') RowStatus(checkRow) = 'R';
	    			}
	    		}
	    		
	    		if(map1_ct == 0) {
	    			if(sheet1RowCt != 0) {
		    			DataInsert(-1,0);
		    			for ( var mCol = 0; mCol <= SaveNameCol("flsh_pnt_cdo_temp"); mCol++) {
		    				if(mCol == SaveNameCol("seqNo")) {
		    					InitCellProperty(SelectRow, mCol, dtNull, daNull, ColSaveName(mCol), "", dfNull , -1, -1);
		    				}
		    				CellValue2(SelectRow, mCol) = MessageText("NoData");
		    			}		    			
		    			FrozenCols = 0;
		    			MergeSheet = msAll;
		    			RowMerge(SelectRow) = true; 
		    			RowStatus(SelectRow) = 'R';
	    			}
	    			
	    			CountFormat = "[0 / 0]";
	    			btnEnabled(sheetObj, false);
	    		} else {
	    			if(CellValue(LastRow, 1) == MessageText("NoData")) {
	    				RowDelete(LastRow, false);
	    				FrozenCols = 12;
	    				MergeSheet = msPrevColumnMerge + msHeaderOnly;
    				}
	    			
	    			CountFormat = "[1 / "+map1_ct+"]";
	    			SelectCell(firstRow, "seqNum");
	    			btnEnabled(sheetObj, true);
	    		}
	    	} else {
	    		for (var checkRow = HeaderRows; checkRow <= LastRow; checkRow++) {
	    			RowHidden(checkRow) = false;
	    			
	    			rowState = RowStatus(checkRow);
	    			
	    			if(CellValue(checkRow, "spcl_cgo_apro_rqst_seq") != '') {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_apro_rqst_seq")+""+CellValue(checkRow, "bkg_no")+""+CellValue(checkRow, "vsl_cd")+""+CellValue(checkRow, "skd_voy_no")+""+CellValue(checkRow, "skd_dir_cd");
  					} else {
  						rqstSeq1 = CellValue(checkRow, "spcl_cgo_rqst_seq");
  					}
	    			
	    			if(rqstSeq1 != rqstSeq2) seqNo++;	  					
  					CellValue2(checkRow, "seqNum") = seqNo;	 	    			
 	    			rqstSeq2 = rqstSeq1;

 	    			if(rowState == 'R') RowStatus(checkRow) = 'R';
	    		}
	    		if(SearchRows == 0) {
	    			CountFormat = "[0 / 0]";
	    			btnEnabled(sheetObj, false);
	    		} else {
	    			if(map1_ct == 0) {
	    				if(CellValue(LastRow, 1) == MessageText("NoData")) {
		    				RowDelete(LastRow, false);
		    				FrozenCols = 12;
		    				MergeSheet = msPrevColumnMerge + msHeaderOnly;
	    				}
	    			}
	    			
	    			CountFormat = "[SELECTDATAROW / ROWCOUNT]";
	    			btnEnabled(sheetObj, true);
	    		}
	    	}
	    	if(source == 'click') Redraw = true;
    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,source) {
        sheetObj.ShowDebugMsg = false; 
        
        var tabStr = "";
   		if(getIdx() == 0) {
   			tabStr = "DG";
   		} else if(getIdx() == 1) {
   			tabStr = "AWK";
   		} else if(getIdx() == 2) {
   			tabStr = "BB";
   		} else if(getIdx() == 3) {
   			tabStr = "45";
   		} else if(getIdx() == 4) {
   			tabStr = "RF";
   		}
   		
   		ComSetObjValue(formObj.scg_flg, "SCG_"+tabStr);
        
        switch(sAction) {
        
           	case IBSEARCH:      //조회
           
           		if(!validateForm(sheetObj,formObj,sAction,source)) return;   
           	
           		sheetObj.RemoveAll();
           		
           		ComClearSeparator(formObj.from_eta_dt);
           		ComClearSeparator(formObj.to_eta_dt);
           		
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0023GS.do", FormQueryString(formObj));
				
				ComAddSeparator(formObj.from_eta_dt);
				ComAddSeparator(formObj.to_eta_dt);
				
				var arrXml = sXml.split("|$$|");
				
				sheetObj.Redraw = false;
				var xmlStr = "";
				
				//OnSearchEnd Event 중복수행방지
				if(arrXml.length>1) {
					searchEndBlk = false;
				} else {
					searchEndBlk = true;
				}
				
				sheetObj.InitDataCombo(0,"spcl_cgo_auth_cd", "R|Y|N", "R|Y|N");
				for(var i=0; i<arrXml.length; i++) {
					xmlStr = arrXml[i];
					
					//OnSearchEnd Event 중복수행방지
					if(i == 1) searchEndBlk = true; 
					
					//자사 --> 타사
					xmlStr = ComReplaceStr(xmlStr, "booking_no",   "bkg_no");
					xmlStr = ComReplaceStr(xmlStr, "dg_cntr_seq",  "spcl_cntr_seq");
					xmlStr = ComReplaceStr(xmlStr, "cntr_cgo_seq", "spcl_cgo_seq");
					
					xmlStr = ComReplaceStr(xmlStr, "ovr_fwrd_len",     "fwrd_ovr_dim_len");
					xmlStr = ComReplaceStr(xmlStr, "ovr_bkwd_len",     "bkwd_ovr_dim_len");
					xmlStr = ComReplaceStr(xmlStr, "ovr_lf_len",       "lf_sd_ovr_dim_len");
					xmlStr = ComReplaceStr(xmlStr, "ovr_rt_len",       "rt_sd_ovr_dim_len");
					xmlStr = ComReplaceStr(xmlStr, "ovr_hgt",          "hgt_ovr_dim_len");
					xmlStr = ComReplaceStr(xmlStr, "ovr_void_slt_qty", "void_slt_qty");
					xmlStr = ComReplaceStr(xmlStr, "cmdt_nm",          "cmdt_desc");
					
					//타사 --> 자사
					xmlStr = ComReplaceStr(xmlStr, "bkg_ref_no",  "bkg_no");
					xmlStr = ComReplaceStr(xmlStr, "cgo_rqst_dt", "rqst_dt");
					xmlStr = ComReplaceStr(xmlStr, "auth_sts_cd", "spcl_cgo_auth_cd");
					
					sheetObj.LoadSearchXml(xmlStr, true); 
				}
				if(sheetObj.RowCount == 0) {
					sheetObj.LoadSearchXml(arrXml[0]);
				} 	

				sheetObj.Redraw = true; 
				
				if(source == 'BTN') searchTab = getIdx();
				else if(source == 'SAVTAB') tabObjects[0].SelectedIndex = nexttab;
				
				break;

           case IBSAVE:        //저장
           		var sParam = ComGetSaveString(sheetObj);
				if (sParam == "") return;
			
	            if(validateForm(sheetObj,formObj,sAction,source)) {
	    			formObj.f_cmd.value = MULTI;
	    			
	    			sParam  = "";
	    			sParam += ComSetPrifix(sheetObj.GetSaveString(), "sheet_"); 
	    			
	    			sParam += "&" + FormQueryString(formObj);
	
	    			var sXml = sheetObj.GetSaveXml("VOP_SCG_0023GS.do", sParam); 
	    			sheetObj.LoadSaveXml(sXml);
	    			
	    			doActionIBSheet(sheetObj,formObj,IBSEARCH,'SAV'+source);
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
        		
	  			break;  
	  		case 2:    
	  			formObj.f_cmd.value = SEARCH02;
	  			
	  			sheetObj.WaitImageVisible = false;
        		var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
        		sheetObj.WaitImageVisible = true;
        		
        		ComXml2ComboItem(sXml, formObj.imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
        		
        		var count = document.all.imdg_clss_cd.GetCount();
        		if(count <= 10) {
            		document.all.imdg_clss_cd.DropHeight = 19*count;
            		document.all.imdg_clss_cd.SetColWidth("52");
           		} else {
           			document.all.imdg_clss_cd.DropHeight = 19*10;
           		}
        		
        		ComSetFocus(formObj.imdg_clss_cd);
        		
	  			break;  
        }
    }
    
    /**
     * Sheet 확인
     */
    function getIdx() {
    	return tabObjects[0].SelectedIndex;
    }
     
    /**
     * Lane Check
     */
    function searchLaneCheck() {
     	var formObj  = document.form;
     	var sheetObj = sheetObjects[getIdx()];
     	
     	var slan_cd1 = ComGetObjValue(formObj.slan_cd1);
     	
     	if(slan_cd1 != '') {
	     	var sParam = Array();
	 	  	sParam[0] = "vsl_slan_cd="+slan_cd1;
	 	  	sParam[3] = "f_cmd="+SEARCH02;
	 	  	
	 	  	sheetObj.WaitImageVisible = false;
	     	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
	     	sheetObj.WaitImageVisible = true;
	
	     	var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd");
	     	
	  	   	if(vsl_slan_cd == null) {
	  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	  		    
	  		    ComSetFocus(formObj.slan_cd1);
	  		    formObj.slan_cd1.select();
	  	   	}
     	}
    }
    
    /**
     * Vessel Name 조회
     */
    function searchVVDCheck() {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[getIdx()];
    	
    	var sParam = Array();
	  	sParam[0] = "vsl_cd="+ComGetObjValue(formObj.vsl_cd);
	  	sParam[1] = "skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2] = "skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3] = "f_cmd="+SEARCH05;
	  	
	  	if(sParam.join("").length > 38) {
	  		sheetObj.WaitImageVisible = false;
	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
	    	sheetObj.WaitImageVisible = true;
	
	    	var vsl_eng_nm = ComScgXml2Array(sXml, "vsl_eng_nm");
	    	
	 	   	if(vsl_eng_nm == null) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    
	 		    ComSetObjValue(formObj.vsl_eng_nm, "");
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	} else {
		    	formObj.vsl_cd.className = "input1";
		    	formObj.skd_voy_no.className = "input1";
		    	formObj.skd_dir_cd.className = "input1";
		    	formObj.from_eta_dt.className = "input";
		    	formObj.to_eta_dt.className = "input";
	 	   		ComSetObjValue(formObj.vsl_eng_nm, vsl_eng_nm);
	 	   		
	 	   		ComSetFocus(formObj.btn_retrive);
	 	   	}
	  	}
    }
     
    /**
     * Port Validation
     */
    function searchPortCheck(obj) {
     	var formObj  = document.form;
     	var sheetObj = sheetObjects[getIdx()];
     	
     	var sParam = Array();
 	  	sParam[0] = "port_cd="+obj.value;
 	  	sParam[3] = "f_cmd="+SEARCH09;

 	  	if(sParam.join("").length > 17) {
 	  		sheetObj.WaitImageVisible = false;
 	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
 	    	sheetObj.WaitImageVisible = true;
 	
 	    	var port_cd_nm = ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm  
 	    	
 	 	   	if(port_cd_nm == '') {
 	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	 		    
 	 		    ComSetObjValue(obj, ""); 	 		    
 	 		    ComSetFocus(obj);
 	 	   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
     	var formObj  = document.form;
     	var sheetObj = sheetObjects[getIdx()];
     	
     	var sParam = Array();
 	  	sParam[0] = "crr_cd="+obj.value;
 	  	sParam[3] = "f_cmd="+SEARCH01;

 	  	if(sParam.join("").length > 17) {
 	  		sheetObj.WaitImageVisible = false;
 	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
 	    	sheetObj.WaitImageVisible = true;
 	
 	    	var crrData = ComScgXml2Array(sXml, "crr_cd");
 	      	
 		   	if(crrData == null) {
 			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 			    
 			    ComSetObjValue(obj, ""); 	 		    
	 		    ComSetFocus(obj);
 		   	} else {
 	 	   		ComSetNextFocus(obj);
 	 	   	}
 	  	}
    }
    
    /**
     * UN No. Validation
     */
    function searchUNNoCheck(obj) {
    	if(obj.value == '') return;
    	 
     	var formObj  = document.form;
     	var sheetObj = sheetObjects[getIdx()];
     	
     	switch(obj.name) {
     		case "imdg_un_no":
     			formObj.f_cmd.value = SEARCH01;
     			break;
     		
     		case "imdg_un_no_seq":
     			formObj.f_cmd.value = SEARCH05; 	
     			break;
     	}
     	
     	var imdgUnNo = formObj.imdg_un_no.value;
     	
     	if(imdgUnNo != '') {
	     	var param =  FormQueryString(formObj) ;
	     	
	     	sheetObj.WaitImageVisible = false;
	        var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
	        sheetObj.WaitImageVisible = true;
	        
	     	var sTotal = ComScgGetTotalValue(sXml);
	     	
	     	if( sTotal == "0"){
	     		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	     		
	     		ComSetObjValue(obj, ""); 	 		    
	 		    ComSetFocus(obj);
	        } else {
	        	if(obj.name == 'imdg_un_no_seq') {
	        		var imdg_clss_cd = ComScgXml2Array(sXml, "imdg_clss_cd");
	        		formObj.imdg_clss_cd.Text2 = imdg_clss_cd;    	
	        	}
	 	   		ComSetNextFocus(obj);
	 	   	}
     	} else {
			ComShowCodeMessage("SCG50007", "UN No.");	//'Please input {?msg1}.'
			obj.value = "";
			ComSetFocus(formObj.imdg_un_no);
		}
    }

    /**
     * UN No. Pop Call Back
     */
    function callBackUNNo(aryPopupData) {
    	var formObj  = document.form;
    	ComSetObjValue(formObj.imdg_un_no,     aryPopupData[0][2]); 
    	ComSetObjValue(formObj.imdg_un_no_seq, aryPopupData[0][3]);
    	
    	formObj.imdg_clss_cd.Text2 = aryPopupData[0][4];    	
    }
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++] = tab_obj;
    }
     
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
                    InsertTab( cnt++ , "Break-Bulk" , -1 );
                    InsertTab( cnt++ , "45'" , -1 );
                    InsertTab( cnt++ , "Reefer" , -1 );

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
	  		case "imdg_clss_cd":  
	  			with(comboObj) {	
	  				Enable = true;
	  			}
	  			break;  
	  	}
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
    	 
    	if(sheetObjects[beforetab].IsDataModified) {
    		if (ComShowCodeConfirm("SCG50003")) {	//'Data was changed. Do you want to save it?'	
    			nexttab = nItem;
    			tabObj.SelectedIndex = beforetab;
    			
    			doActionIBSheet(sheetObjects[beforetab],document.form,IBSAVE,'TAB');
    			
    			return;
    		}
    	}

    	var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	
    	for(var i=0; i<objs.length; i++) {
    		if(i != nItem) objs[i].style.display = "none";
    	}

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    	
    	var searchFlg = false;
    	for(var i=0; i<sheetCnt; i++) {
    		if (searchTab != -1 && searchTab != i && beforetab == i) searchFlg = true;
    	}
	   	
	   	if(searchFlg) doActionIBSheet(sheetObjects[beforetab],document.form,IBSEARCH,'TAB');
	   	else {
	   		if(sheetObjects[nItem].RowCount == 0) btnEnabled(sheetObjects[nItem], false);
	   	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction,source) {
    	 switch(sAction) {

	    	case IBSEARCH:
	    		//Check requirement of Irregulars Type
	    		 if (comboObjects[0].Code == "") {
					 ComShowCodeMessage('SCG50011','RSO');
	    			 formObj.rgn_shp_opr_cd.focus();
	    			 return;
	    		 }
//		    	if(ComGetObjValue(document.all.rgn_shp_opr_cd) == '') {
//		    		ComAlertFocus(document.all.rgn_shp_opr_cd, "'RSO' " +Msg_Required);
//		    		
//		    		return;
//		    	}
		    	
			  	var strVvdCd = ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd);
			  	
		    	if(strVvdCd == '' && ComGetObjValue(formObj.from_eta_dt) == '' && ComGetObjValue(formObj.to_eta_dt) == '') {
					 ComShowCodeMessage('SCG50007','VVD CD or POL ETA');
	    			 formObj.vsl_cd.focus();
		    		
		    		return;
		    	}
	    		//폼 개체 안에 모든 컨트롤의 Validation을 확인
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
	    				    	
	    		break;
	    	case IBSAVE:	
	    		
	    		//'저장하시겠습니까?'
	    		if(source != 'TAB'){
	    			if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
	    		}
		    	
		    	break;
	    	case IBCLEAR:
	    		if(sheetObj.IsDataModified) {
	    			if(ComShowCodeConfirm('SCG50003')) {	//'Data was changed. Do you want to save it?'
	    				doActionIBSheet(sheetObj,formObj,IBSAVE,'BTN');
	    				return false;
	    			}
	    		}
	    		break;
		}
	
	    return true;
    }
    
    /**
     * 조회조건에서 팝업을 클릭시
     */
    function onPopupClick(srcName, srcType){
    	if (srcType == "Lane") {
   		 	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 426, 475, "sheet1_vsl_slan_cd:slan_cd1", "0,0", true);
   	 	} else if (srcType == "VVD") {
   	 		//VVD 선택팝업 열기					
			var vsl_cd = ComGetObjValue(document.form.vsl_cd);
        	var sUrl = "";
        	
        	if(vsl_cd == ""){
        		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
        		ComOpenPopupWithTarget(sUrl, 463, 500, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", "0,0", true);
        	}else{
        		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopupWithTarget(sUrl, 335, 420, "skd_voy_no:skd_voy_no|skd_dir_cd:skd_dir_cd", "0,0", true);
        	}
   	 	} else if (srcType == "POL" || srcType == "POD") {
   	 		if (srcType == "POL") {
   	 			var port_cd = ComGetObjValue(document.form.pol_cd);
   	 		}else{
   	 			var port_cd = ComGetObjValue(document.form.pod_cd);   	 			
   	 		}
   	 		ComOpenPopupWithTarget('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 428, 520, "loc_cd:"+srcType.toLowerCase()+"_cd", "0,0,1,1", true);
   	 	} else if (srcType == "Carrier") {
	 		ComOpenPopupWithTarget('/hanjin/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 450, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
   	 	} else if (srcType == "UNNo") {
   	 		var imdg_un_no = ComGetObjValue(document.form.imdg_un_no);
   	 		var imdg_un_no_seq = ComGetObjValue(document.form.imdg_un_no_seq);
   	 		ComOpenPopup("/hanjin/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 420, "callBackUNNo", "0,0,1,1,1,1,1,1,1,1", true, false);
   	 	}
    }

	/* 개발자 작업  끝 */