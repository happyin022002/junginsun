/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_6002.js
*@FileTitle : Current Collection Status by Office – Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.22 황효근
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
     * @class EES_DMT_6002 : EES_DMT_6002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_6002() {
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


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		  var sheetObj = sheetObjects[0];
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
    	  
    	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                     style.height = GetSheetHeight(18); //125;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 7, 100);
                     
                     var HeadTitle1 = "|Seq.|Year|Month|RHQ|Office|Tariff|STS|A/R|CNTR No.|T/S|From YD|To YD|Fm|To|F/T|Over|From DT|To DT|F/Time CMNC|F/Time End|Cur.|Incurred AMT|CMDT EXPT AMT|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Invoiced AMT|Collected Cur|Collected AMT|Uncollected Cur|Uncollected AMT|BKG No.|B/L No.|VVD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|Contract Office|Customer Name|INV No.|ISS DT|INV OTS DAY|G/B";
                     //var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(56, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtSeq,	 		 35,	daCenter,	true,	"seq",      		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,	true,	"year",				false,  "",		dfNone,			0,	false,  true); 
                     InitDataProperty(0, cnt++ , dtData,		 45,	daCenter,	true,	"month",			false,  "",		dfNone,			0,	false,  true); 
                     InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,	true,	"ofc_rhq_cd",		false,  "",		dfNone,			0,	false,  true);                     
                     InitDataProperty(0, cnt++ , dtData,		 50,    daCenter,   true,	"ofc_cd",   		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"dmdt_trf_cd",   	false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 35,	daCenter,	true,	"dmdt_chg_sts_cd",  false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 35,	daCenter,	true,	"dmdt_ar_if_cd",    false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 80,	daCenter,	true,	"cntr_no",   		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData, 		 35,	daCenter,	true,	"cntr_tpsz_cd",     false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 70,	daCenter,	true,	"fm_mvmt_yd_cd", 	false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData, 		 70,	daCenter,	true,	"to_mvmt_yd_cd",   	false,	"",		dfNone,			0,	false,	true);

                     InitDataProperty(0, cnt++ , dtData,   		 35,	daCenter,	true,	"fm_mvmt_sts_cd",   false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 35,	daCenter,	true,	"to_mvmt_sts_cd",   false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 35,	daCenter,	true,	"ft_dys",       	false,	"",		dfInteger,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 40,	daCenter,	true,	"fx_ft_ovr_dys",   	false,	"",		dfInteger,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 75,	daCenter,	true,	"fm_mvmt_dt", 		false,	"",		dfDateYmd,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 75,	daCenter,	true,	"to_mvmt_dt",   	false,	"",		dfDateYmd,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 85,	daCenter,	true,	"ft_cmnc_dt",   	false,	"",		dfDateYmd,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 75,	daCenter,	true,	"ft_end_dt",    	false,	"",		dfDateYmd,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 40,	daCenter,	true,	"bzc_trf_curr_cd",  false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 90,	daRight,	true,	"org_chg_amt", 		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 100,	daRight,	true,	"cmdt_expt_amt", 	false,	"",		dfNullFloat,	2,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtData,   		 90,	daRight,	true,	"expt_amt",			false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 60,	daRight,	true,	"aft_expt_dc_amt",  false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 80,	daRight,	true,	"bil_amt", 			false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 60,	daCenter,	true,	"inv_curr_cd",   	false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 90,	daRight,	true,	"inv_chg_amt", 		false,	"",		dfNullFloat,	2,	false,	true);

                     InitDataProperty(0, cnt++ , dtData,   		 100,	daCenter,	true,	"coll_curr_cd", 	false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 100,	daRight,	true,	"coll_amt", 		false,	"",		dfNullFloat,	2,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 100,	daCenter,	true,	"uncoll_curr_cd", 	false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 100,	daRight,	true,	"uncoll_amt", 		false,	"",		dfNullFloat,	2,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtData,   		 95,	daCenter,	true,	"bkg_no",    		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 95,	daCenter,	true,	"bl_no",     		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 80,	daCenter,	true,	"vvd_cd",      		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"lane",     		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"por_cd",      		false,	"",		dfNone,			0,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"pol_cd",      		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"pod_cd",      		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 50,	daCenter,	true,	"del_cd",      		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 40,	daCenter,	true,	"bkg_rcv_term_cd",  false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 40,	daCenter,	true,	"bkg_de_term_cd",   false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 70,	daCenter,	true,	"sc_no",     		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 95,	daCenter,	true,	"rfa_no",    		false,	"",		dfNone,			0,	false,	true);

                     //==================================================================
                     // 변경일자 : 2017.7.24  
                     // 변경내용 : RFA No. 다음에 Contract Office, Customer Name 탭 추가
                     // 변경사유 : CSR #1613 [DMT] Report 메뉴 내 조회 기능 개선 요청
                     //================================================================== 
                     InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,	true,	"ctrt_ofc_cd", 		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		180,	daLeft,		true,	"cust_nm",    		false,	"",		dfNone,			0,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtData,   		 90,	daCenter,	true,	"dmdt_inv_no",    	false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 90,	daCenter,	true,	"iss_dt",    		false,	"",		dfDateYmd,		0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		 85,	daCenter,	true,	"inv_ots_day", 		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,	true,	"chg_type",       	false,	"",		dfNone,			0,	false,	true);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"svr_id",			false,  "",		dfNone,			0,	false,  false);
                     InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"cntr_cyc_no",		false,  "",		dfNone,			0,	false,  false);
                     InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"dmdt_chg_sts_cd",	false,  "",		dfNone,			0,	false,  false);
                     InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"dmdt_chg_loc_div_cd",false,"",		dfNone,			0,	false,  false);
                     InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"chg_seq",			false,  "",		dfNone,			0,	false,  false);
                     
                     // 좌측 틀고정 컬럼 설정
 					 FrozenCols = SaveNameCol("cntr_tpsz_cd");
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
				sheetObj.DoSearch("EES_DMT_6002GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				
				var cntrQty = sheetObj.EtcData("cntr_qty");
				ComSetObjValue(formObj.cntr_qty, ComAddComma2(cntrQty, "#,###"));
				
				// 페이지 접근 권한정보
				var rolePermit	= sheetObj.EtcData("ROLE_PERMIT");
				var roleAuth	= sheetObj.EtcData("ROLE_AUTH");
				ComSetObjValue(formObj.role_permit, rolePermit);
				ComSetObjValue(formObj.role_auth,	roleAuth);
				
				break;
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