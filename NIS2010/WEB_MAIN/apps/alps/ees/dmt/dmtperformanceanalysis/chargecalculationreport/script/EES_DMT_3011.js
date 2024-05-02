/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3011.js
*@FileTitle : Deleted Charge Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.17 황효근
* 1.0 Creation
* 2011.08.11 김경섭[CHM-201112592-01][DMT]Deleted Charge Report by Office 화면 보완 3010 > 3011조회시 Office 다중조회 가능토록함.
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
     * @class EES_DMT_3011 : EES_DMT_3011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3011() {
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
               
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                     style.height = 420;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default, msNone;]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle = "|Seq.|Office|Inactivated Reason|Inactivated Specific Reason|Tariff|Status|CNTR No.|T/S|From YD|To YD|Fm|To|F/T|Over|From Date|To Date|F/Time CMNC|F/Time End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|BKG No.|B/L No.|VVD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|G/B|SOC|L/I|C/H|O/T|R/O|Payer|Payer|Shipper|Shipper|Consignee|Consignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer|Service Provider|Service Provider|Inactive DT|Inactive OFC|Inactive Name|Inactive Remark(s)";
                     //var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(64, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,		45,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"ofc_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		180,	daLeft,		false,	"delt_rsn_desc",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		180,	daLeft,		false,	"delt_spec_rsn_desc",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"dmdt_trf_cd",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	false,	"status",		    false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cntr_no",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"cntr_tpsz_cd",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"fm_mvmt_yd_cd",	false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"to_mvmt_yd_cd",	false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"fm_mvmt_sts_cd",	false,	"",		dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"to_mvmt_sts_cd",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"ft_dys",			false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"fx_ft_ovr_dys",	false,	"",		dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"fm_mvmt_dt", 		false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"to_mvmt_dt",		false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"ft_cmnc_dt",		false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"ft_end_dt",		false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"bzc_trf_curr_cd",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"org_chg_amt",		false,	"",		dfNullFloat,2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"sc_rfa_expt_amt",	false,	"",		dfNullFloat,2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"aft_expt_dc_amt",	false,	"",		dfNullFloat,2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"bil_amt",			false,	"",		dfNullFloat,2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"bkg_no",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"bl_no",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"vvd_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"lane",				false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"por_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"pol_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"pod_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"del_cd",			false,	"",		dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"bkg_rcv_term_cd",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"bkg_de_term_cd",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"sc_no",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	"rfa_no",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"chg_type",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"soc_flg",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"li",				false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"ch",				false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"ofc_trns_flg",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"roll_ovr",			false,	"",		dfNone,		0,	false,	false, -1, false, true, "Roll Over due to Customs or Customer Request");
					
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"payer_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		false,	"payer_nm",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"shipper_cd",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		false,	"shipper_nm",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"cnee_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		false,	"cnee_nm",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"ntfy_cd",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		false,	"ntfy_nm",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"ar_act_cd",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		false,	"ar_act_nm",		false,	"",		dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"svc_provdr_cd",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		false,	"svc_provdr_nm",	false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"del_dt",			false,	"",		dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"del_ofc",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		false,	"del_usr_nm",		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		false,	"corr_rmk",			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"svr_id",			false,  "",		dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"cntr_cyc_no",		false,  "",		dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"dmdt_chg_sts_cd",	false,  "",		dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"dmdt_chg_loc_div_cd",false,"",		dfNone,		0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"chg_seq",			false,  "",		dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"ofc_rhq_cd",		false,  "",		dfNone,		0,	false,  false);
					
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol("dmdt_trf_cd");
					
					ToolTipOption="balloon:true;width:50;";
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
            	formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_DMT_3011GS.do", FormQueryString(formObj));
				
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
   
   
	// Grid 특정 컬럼에 대해서 말풍선 기능 추가
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
  		with(sheetObj){
  			Row = MouseRow;
  			Col = MouseCol;
  			if (Row > 0) {
  				var ttText='';
  				var colSaveNm = ColSaveName(Col);
  				if(colSaveNm == 'corr_rmk') {	//해당 Cell 전체내용을 보여줌
  					var ttText = CellValue(Row, colSaveNm);
  					
  					if(ComGetLenByByte(ttText) > 30)
  						MouseToolTipText = ttText;
  				} else
  					MouseToolTipText = '';
  			}
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
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }
    

	/* 개발자 작업  끝 */