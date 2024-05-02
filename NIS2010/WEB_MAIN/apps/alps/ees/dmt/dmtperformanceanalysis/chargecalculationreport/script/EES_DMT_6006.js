/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6006.js
*@FileTitle : Summary Report by Customer - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.01 황효근
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
     * @class EES_DMT_6006 : EES_DMT_6006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6006() {
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

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj = sheetObjects[0];
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
	     		case "btn_ByBKG":
				case "btn_ByCNTR":
					doProcessPopup(srcName);
					break;
				
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk');
					break;
				
				case "btn_Close":
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
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

    	 for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
    	 }
    	 
    	 doInit();
     }
      
      
     // 화면 오픈시 초기화 처리 
     function doInit() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
  		var opener = window.dialogArguments;
  		var opnSheetObj = opener.sheetObjects[0];
  		var opnFormObj = opener.document.form;
  		
  		with(opnSheetObj) {
	 		var chkRow = SelectRow;
	 		var scNo = CellValue(chkRow, "sc_no");
	 		var rfaNo = CellValue(chkRow, "rfa_no");
			
			ComSetObjValue(formObj.sc_no,		scNo);
			ComSetObjValue(formObj.rfa_no,		rfaNo);
			ComSetObjValue(formObj.cust_cd,		CellValue(chkRow, "cust_cd"));
			ComSetObjValue(formObj.cust_nm,		CellValue(chkRow, "cust_nm"));
			ComSetObjValue(formObj.ctrt_ofc,	CellValue(chkRow, "ctrt_ofc"));
			ComSetObjValue(formObj.dmdt_trf_cd, CellValue(chkRow, "trf_cd"));
			ComSetObjValue(formObj.ofc_cd,		CellValue(chkRow, "dmdt_ofc"));
			ComSetObjValue(formObj.cvr_cd,		CellValue(chkRow, "cvr_cd"));
			ComSetObjValue(formObj.por_cd,		CellValue(chkRow, "por_cd"));
			ComSetObjValue(formObj.pol_cd,		CellValue(chkRow, "pol_cd"));
			ComSetObjValue(formObj.pod_cd,		CellValue(chkRow, "pod_cd"));
			ComSetObjValue(formObj.del_cd,		CellValue(chkRow, "del_cd"));
			
			if(scNo != '')
				sheetObj.ColHidden("rfa_no") = true;
			else
				sheetObj.ColHidden("sc_no") = true;
  		}
  		
  		ComSetObjValue(formObj.start_dt,	ComGetObjValue(opnFormObj.start_dt));
		ComSetObjValue(formObj.end_dt,		ComGetObjValue(opnFormObj.end_dt));
		
    	doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }


   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

    	  var cnt = 0;
    	  var sheetID = sheetObj.id;

    	  switch(sheetID) {

             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 400;
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
                     
                     var HeadTitle1 = "|Seq.|S/C No.|RFA No.|Customer|Customer|Actual Customer|Actual Customer|CTRT OFC|Tariff|STS|CNTR No.|T/S|DMT OFC"
                    	 			+ "|From YD|To YD|Fm|To|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT"
                    	 			+ "|INV Cur.|Invoiced AMT|A/R|BKG No.|B/L No.|VVD|Lane|POR|POL|POD|DEL|R|D|INV No.|ISS DT|G/B";
                     //var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(51, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++, dtSeq,    		35, daCenter,	true,   "seq");
                     InitDataProperty(0, cnt++, dtData,			70,	daCenter,	false,	"sc_no",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daCenter,	false,	"rfa_no",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		60,	daCenter,	false,	"cust_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		100,daCenter,	false,	"cust_nm",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		60,	daCenter,	false,	"acust_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		100,daCenter,	false,	"acust_nm",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		70,	daCenter,	false,	"ctrt_ofc",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		50,	daCenter,	false,	"dmdt_trf_cd",		false,	"",	dfNone,		0,	false,	true);
                     
                     InitDataProperty(0, cnt++, dtData,   		30,	daCenter,	false,	"dmdt_chg_sts_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daCenter,	false,	"cntr_no",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		30,	daCenter,	false,	"cntr_tpsz_cd",		false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		60,	daCenter,	false,	"ofc_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"fm_mvmt_yd_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"to_mvmt_yd_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		30,	daCenter,	false,	"fm_mvmt_sts_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		30,	daCenter,	false,	"to_mvmt_sts_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		30,	daCenter,	false,	"ft_dys",			false,	"",	dfInteger,	0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		40,	daCenter,	false,	"fx_ft_ovr_dys",	false,	"",	dfInteger,	0,	false,	true);
                     
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"fm_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"to_mvmt_dt",		false,	"",	dfDateYmd,	0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"ft_cmnc_dt",		false,	"",	dfDateYmd,	0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"ft_end_dt",		false,	"",	dfDateYmd,	0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		50,	daCenter,	false,	"bzc_trf_curr_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daRight,	false,	"org_chg_amt",		false,	"",	dfNullFloat,2,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		110,daRight,	false,	"expt_amt",			false,	"",	dfNullFloat,2,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daRight,	false,	"aft_expt_dc_amt",	false,	"",	dfNullFloat,2,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daRight,	false,	"bil_amt",			false,	"",	dfNullFloat,2,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daCenter,	false,	"inv_curr_cd",		false,	"",	dfNone,		0,	false,	true);
                     
                     InitDataProperty(0, cnt++, dtData,   		90,	daRight,	false,	"inv_chg_amt",		false,	"",	dfNullFloat,2,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		30,	daCenter,	false,	"dmdt_ar_if_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daCenter,	false,	"bkg_no",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		90,	daCenter,	false,	"bl_no",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"vvd_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		50,	daCenter,	false,	"lane",				false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		70,	daCenter,	false,	"por_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		70,	daCenter,	false,	"pol_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		70,	daCenter,	false,	"pod_cd",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		70,	daCenter,	false,	"del_cd",			false,	"",	dfNone,		0,	false,	true);
                     
                     InitDataProperty(0, cnt++, dtData,   		20,	daCenter,	false,	"bkg_rcv_term_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		20,	daCenter,	false,	"bkg_de_term_cd",	false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		70,	daCenter,	false,	"dmdt_inv_no",		false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		80,	daCenter,	false,	"iss_dt",			false,	"",	dfDateYmd,	0,	false,	true);
                     InitDataProperty(0, cnt++, dtData,   		39,	daCenter,	false,	"chg_type",			false,	"",	dfNone,		0,	false,	true);
                     InitDataProperty(0, cnt++, dtHidden,		 0,	daCenter,	false,	"svr_id",			false,  "",	dfNone,		0,	false,  false);
                     InitDataProperty(0, cnt++, dtHidden,		 0,	daCenter,	false,	"cntr_cyc_no",		false,  "",	dfNone,		0,	false,  false);
                     InitDataProperty(0, cnt++, dtHidden,		 0,	daCenter,	false,	"dmdt_chg_sts_cd",	false,  "",	dfNone,		0,	false,  false);
                     InitDataProperty(0, cnt++, dtHidden,		 0,	daCenter,	false,	"dmdt_chg_loc_div_cd",false,"",	dfNone,		0,	false,  false);
                     InitDataProperty(0, cnt++, dtHidden,		 0,	daCenter,	false,	"chg_seq",			false,  "",	dfNone,		0,	false,  false);
                     
                     InitDataProperty(0, cnt++, dtHidden,		 0,	daCenter,	false,	"ofc_rhq_cd",		false,  "",	dfNone,		0,	false,  false);

                     // 좌측 틀고정 컬럼 설정
                     FrozenCols = SaveNameCol("cust_cd");
                     
                     CountPosition = 2;
                     Ellipsis = true;
                }
                 break;
         }
     }

      
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
 			case IBSEARCH:      //조회
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
 	        	formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("EES_DMT_6006GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
 				break;
		}
	}
	
	
	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	
    	// General Charge 갯수 (chg_seq = 1, chg_type = 'G')
    	var cntrQty;
    	var rows = ComFindAll(sheetObj, "chg_type", "G") + '';
    	
    	if(rows.indexOf('|') != -1) {
    		var arrRows = rows.split('|');
	    	cntrQty = arrRows.length;
    	} else {
    		cntrQty = 1;
    	}
    	
    	with(sheetObj) {
    		//cntrQty = EtcData("cntr_qty");
			ComSetObjValue(formObj.cntr_qty, ComAddComma2(cntrQty, "#,###"));
    		
			var custCd = ComGetObjValue(formObj.cust_cd);
			var custNm = ComGetObjValue(formObj.cust_nm);
			var ctrtOfc = ComGetObjValue(formObj.ctrt_ofc);
				
    		for(var i=TopRow; i <= LastRow; i++) {
    			CellValue(i, "cust_cd") = custCd;
    			CellValue(i, "cust_nm") = custNm;
    			CellValue(i, "ctrt_ofc") = ctrtOfc;
    		}
    		
    		// 페이지 접근 권한정보
			var rolePermit	= EtcData("ROLE_PERMIT");
			var roleAuth	= EtcData("ROLE_AUTH");
			ComSetObjValue(formObj.role_permit, rolePermit);
			ComSetObjValue(formObj.role_auth,	roleAuth);
    	}
 	}

   
 	/*
 	 * 각 공통팝업창 호출 함수 
 	 */
  	function doProcessPopup(srcName) {
     		
 		var sheetObj = sheetObjects[0];
 		var formObj	= document.form;
 		var sUrl	= '';
 		var sWidth	= '';
 		var sHeight	= '';
 		
 		with(sheetObj) {
 	  		switch(srcName) {
 	 	  		case 'btn_ByBKG':
 	 	  			var chkRow 		= SelectRow;
 	 	  			
 		  			var bkgNo		= CellValue(chkRow , "bkg_no");
 		  			var blNo		= CellValue(chkRow , "bl_no");
 		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
 		  			var chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
 		  			var paramVal	= "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
 		  			
 		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl	= 'EES_DMT_3002P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl	= 'EES_DMT_3005P.do' + paramVal;
		  			}
 		  			sWidth	= '1010';
	          		sHeight	= '680';
 	  				break;
 	  			
 	  			case 'btn_ByCNTR':
 	  				var chkRow 		= SelectRow;
 		  			
 		  			var svrId		= CellValue(chkRow , "svr_id");
 		  			var cntrNo		= CellValue(chkRow , "cntr_no");
 		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
 		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
 		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
 		  			var chgSeq		= CellValue(chkRow , "chg_seq");
 		  			var paramVal	= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
 		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
 		  			
 		  			if( ComGetObjValue(formObj.role_permit) == 'Y'
 		  						&& CellValue(chkRow , "ofc_rhq_cd") == ComGetObjValue(formObj.usr_rhq_ofc_cd) ) {
			  			// Calculation 화면
			  			sUrl	= 'EES_DMT_3003P.do' + paramVal;
		  			} else {
		  				// Inquiry 화면
		  				sUrl	= 'EES_DMT_3006P.do' + paramVal;
		  			}
 		  			
 		  			sWidth	= '1010';
	          		sHeight	= '680';
 	  				break;
 	  		} // switch end
 		} // with end
 		
 		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
 	} 

  	

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 
         }

         return true;
     }
    

	/* 개발자 작업  끝 */