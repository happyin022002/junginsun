/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4004.js
*@FileTitle : Manual Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.30 이성훈
* 1.0 Creation
* 2011.03.11 김태균 [CHM-201109336-01] [DMT] Manual Invoice 오입력 Currency 수정 요청
* 2011.10.19 황효근 [CHM-201114001-01] [DMT] DMT Invoice의 e-mail 전송 본문을 Portugal언어로 전환 요청
* 2011.11.09 권   민 [CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발
* 2012.03.05 김현화 [] VLCSC Outbound 인 경우는 Tax rate 적용할수 없도록 함.
* 2012.05.24 김현화 [CHM-201217803] 인도용 DMT Invoice format 구성 - GST 적용.
* 2013.01.21 임창빈 [CHM-201322503] Manaul INV시 Inv Currency 누락관련 보완요청.
*            Charge Currency 만 입력하고 저장하게 되면 Invoice No.를 생성하던 것을
*            Invoice Currency 가 동시에 입력될 경우 Invoice No.를 생성하도록 로직을 변경한다.
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
     * @class DEM/DET Adjustment Request - After Booking Request 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4004() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;	
	
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	//Action 정의
	var IBSEARCH_INIT			= 100;
	var IBSEARCH_CHG_CURR 		= 101;
	var IBSEARCH_CHECK_BKGNO 	= 102;
	var IBSEARCH_BKG_CHG 		= 103;
	var IBSEARCH_CHECK_CNTRNO 	= 104;
	var IBSEARCH_CALLPORT 		= 105;
	var IBSEARCH_EX_RATE 		= 106;
	var IBSEARCH_ARIF 			= 107;
	var IBSEARCH_LOC 			= 119;
	var IBSEARCH_CHECK_VVD 		= 110;
	var IBSEARCH_SEND_FAX 		= 111;
	var IBSEARCH_SEND_EMAIL		= 112;
	var IBSEARCH_CHECK_SHEETSET	= 113;
	var IBSEARCH_PAYER_EMLFAX	= 114;
	var IBSEARCH_SHEET_OPT		= 115;
	var IBSEARCH_DYS_BETWEEN    = 116;
	
	//업무전역변수
	var ROWMARK 				= "|";
	var FIELDMARK 				= "=";
	
	var SYS_AREA_GRP_ID 		= "sys_area_grp_id";
	var CNTR_NO 				= "cntr_no";
	var CNTR_CYC_NO				= "cntr_cyc_no";
	var DMDT_TRF_CD				= "dmdt_trf_cd";
	var DMDT_CHG_LOC_DIV_CD		= "dmdt_chg_loc_div_cd";
	var CHG_SEQ 				= "chg_seq";
	var CNTR_TPSZ_CD 			= "cntr_tpsz_cd";
	var FM_MVMT_DT 				= "fm_mvmt_dt";
	var TO_MVMT_DT 				= "to_mvmt_dt";
	var FT_CMNC_DT 				= "ft_cmnc_dt";
	var FT_END_DT 				= "ft_end_dt";
	var FT_DYS 					= "ft_dys";
	var PAYER_CD 				= "act_payr_cust_cd";
	var PAYER_NM 				= "act_payr_cust_nm";
	var TRUCKER_CD 				= "vndr_seq";
	var TRUCKER_NM 				= "vndr_nm";
	var FT_OVR_DYS 				= "ft_ovr_dys";
	var FT_UND_DYS 				= "ft_und_dys";
	var BZC_CURR_CD 			= "bzc_curr_cd";
	var INV_RT_AMT 				= "inv_rt_amt";
	var RT_OVR_DYS 				= "rt_ovr_dys";
	var RT_OVR_CHG_AMT 			= "rt_ovr_chg_amt";
	var INV_NO 					= "dmdt_inv_no";
	var CRE_OFC_CD 				= "cre_ofc_cd";
	var INV_DTL_SEQ 			= "inv_dtl_seq";
	var INV_RT_SEQ 				= "inv_rt_seq";
	var DEL_FLAG 				= "del_flag";
	var IBSHEET_HEIGHT 			= 82;
		
	var currDtlSeq				= "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {

				case "btn_AddCharge":
					if (ComIsBtnEnable(srcName)) 
						doActionAddCharge();
					break;

				case "btn_CopyCharge":
					if (ComIsBtnEnable(srcName)) 
						doActionCopyCharge();
					break;
			
				case "btn_DelCharge":
					if (ComIsBtnEnable(srcName)) 
						doActionDelCharge();
					break;

				case "btn_InqMVMT":
					if (ComIsBtnEnable(srcName)) 
						doProcessPopup(srcName);
					break;

	            case "btn_payer_cd":
	            	if (isCanOpenPopupWin(srcName))
	            		doProcessPopup(srcName);
					break;
						
	            case "btn_trucker_cd":
	            	if (isCanOpenPopupWin(srcName))
	            		doProcessPopup(srcName);
	            	break;
	            	
 				case "btn_set":
 					if (ComIsBtnEnable(srcName)) 
 						doProcessPopup(srcName);
 					break;
 					
 				case "btn_option":
 					if (ComIsBtnEnable(srcName))
 						doProcessPopup(srcName);
 					break;
 					
				case "btn_sendinghistory":
					if (ComIsBtnEnable(srcName))
						doProcessPopup(srcName);
					break;
					
				case "btn_cremark":
					if (ComIsBtnEnable(srcName))
						showRemarkMessage(srcName);
					break;
					
				case "btn_hremark":
					if (ComIsBtnEnable(srcName))
						showRemarkMessage(srcName);
					break;

				case "btn_display":
					if (ComIsBtnEnable(srcName)) 
						doActionDisplayData();
					break;					
					
				case "btn_new":
					if (ComIsBtnEnable(srcName)) 
						doActionNew();
					break;

				case "btn_Minimize":
					if (ComIsBtnEnable(srcName)) 
						doActionMinimize();
					break;
					
				case "btn_save":
					if (ComIsBtnEnable(srcName)) { 
		        		//버튼권한 추가(2010.04.08)
		        		if(ComGetObjValue(formObj.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Save");
		        			return;
		        		}
						//심천지역 Invoice 일 경우 경고창을 띄우고 종료한다.
						if (ComGetObjValue(formObj.suth_chn_iss_flg) == "Y") {
							ComShowCodeMessage("DMT01108", "save");
							return;
						}
						doActionSave();
					}
					break;

				case "btn_cancel":
					if (ComIsBtnEnable(srcName)) { 
		        		//버튼권한 추가(2010.04.08)
		        		if(ComGetObjValue(formObj.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Cancel");
		        			return;
		        		}
						//심천지역 Invoice 일 경우 경고창을 띄우고 종료한다.
						if (ComGetObjValue(formObj.suth_chn_iss_flg) == "Y") {
							ComShowCodeMessage("DMT01108", "cancel");
							return;
						}
						doProcessPopup(srcName);
					}
					break;

				case "btn_preview":
					if (ComIsBtnEnable(srcName)) {
						//Sheet Set 이 없으면 alert 메시지 처리
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						//Preview, Print 할때 PayerCode가 없으면 alert 메시지 처리
						if (ComGetObjValue(formObj.payer_cd) == "") {
							ComShowCodeMessage("DMT02002");
							return;
						}
						doProcessPopup(srcName);
					}
					break;
					
				case "btn_print":
					if(ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}
						//Preview, Print 할때 PayerCode가 없으면 alert 메시지 처리
						if (ComGetObjValue(formObj.payer_cd) == "") {
							ComShowCodeMessage("DMT02002");
							return;
						}
						initRdConfig(rdObjects[0]);
						rdOpen(rdObjects[0], formObj);
					}
					break;
					
				case "btn_fax":
					if (ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}						
						doActionFax();
						doProcessPopup(srcName);
					}
					break;

				case "btn_email":
					if (ComIsBtnEnable(srcName)) {
						if (ComGetObjValue(formObj.has_sheetset) != "Y") {
							ComShowCodeMessage("DMT01096");
							return;
						}						
						doActionEmail();
						doProcessPopup(srcName);
					}
					break;
					
				case "btn_arif":
					if(ComIsBtnEnable(srcName)){
		        		//버튼권한 추가(2010.04.08)
		        		if(ComGetObjValue(formObj.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "A/R I/F");
		        			return;
		        		}
						doActionARIF();
					}
					break;

				case "btn_payer":
					if(ComIsBtnEnable(srcName))
						doProcessPopup(srcName);
					break;
					
				case "btn_Close":
					doActionClose();

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
  	 * IBCombo Object를 배열로 등록
  	 * param : combo_obj ==> 콤보오브젝트
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */ 
  	function setComboObject(combo_obj) {  
  
  		comboObjects[comboCnt++] = combo_obj;  
  	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj 	= document.form;
       	var sheetObj 	= sheetObjects[0];

	   	// 팝업으로 호출시에 타이틀 표시 처리
       	var isPopup = isPopupWindow();

        if (isPopup) {
	        var spanObj = document.getElementById("title2");
	       	spanObj.innerText = " Manual Invoice Creation & Issue";
	       	
	       	//팝업으로 호출시 팝업에 해당되는 메뉴 버튼들을 보여준다.
	       	btnCloseLayer.style.display	 = "inline";	       	
	   	}
        
        for (i=0; i<sheetObjects.length; i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        //1.HTML 컨트롤 이벤트 초기화
		initAxonControl();
		
        //2.IBMultiCombo 를 초기화 한다. 
	    for (var k = 0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k], k+1);
	    }

        var invIssCd = isPopup ? "2" : "1";	// Invoice 생성여부 ( 1 : before, 2 : after )
        ComSetObjValue(formObj.invoice_issue, invIssCd);

  		//3.페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
		// Invoice Creation & Issue - Booking 초기 정보 조회
		DMTComDoActionIBSheet(sheetObj, formObj, IBSEARCH_INIT);
	
        //4.화면을 초기화 상태로 설정한다.
        doActionNew();
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
                     style.height = 102;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 10, 100);

 					 var HeadTitle1  = "|Seq.|CNTR No.|T/S|From DT|To DT|F/T CMNC|F/T End|F/D";
                     var headCount = ComCountHeadTitle(HeadTitle1) + 9;

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
		 		     InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,		daCenter,	true,	"ibflag");
			 		 InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,	true,	"Seq");
			 		 InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	CNTR_NO,			true,	"",		dfEngUpKey,		0,	true,	true,	14);
			 		 InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	CNTR_TPSZ_CD,		false,	"",		dfEngUpKey,		0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtData, 			90,		daCenter,	true,	FM_MVMT_DT,			true,	"",		dfDateYmd,		0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtPopupEditFormat, 90,		daCenter,	true,	TO_MVMT_DT,			true,	"",		dfDateYmd,		0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtData, 			70,		daCenter,	true,	FT_CMNC_DT,			false,	"",		dfDateYmd,		0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtPopupEditFormat, 90,		daCenter,	true,	FT_END_DT,			false,	"",		dfDateYmd,		0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtData,  			50,		daCenter,	true,	FT_DYS,				true,	"",		dfNullInteger,	0,	true,	true,	2);
			 		 InitDataProperty(0, cnt++ , dtHidden,		   100,		daCenter,	true,	BZC_CURR_CD,		false,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	INV_NO,				true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	CRE_OFC_CD,			true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	INV_DTL_SEQ,		true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	SYS_AREA_GRP_ID,	true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	CNTR_CYC_NO,		true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	DMDT_TRF_CD,		true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	DMDT_CHG_LOC_DIV_CD,true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		 0,		daCenter,	true,	CHG_SEQ,			true,	"",		dfNone,			0,	true,	true);
			 		
			 		 PopupImage = "img/btns_calendar.gif";
		 		     ShowButtonImage = 2;
		 		     CountPosition = 0;						   
		 		 }
                 break;

             case 2:      // sheet2 init
                 with (sheetObj) {
                      // 높이 설정
                     style.height = 82;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 10, 100);

 					 var HeadTitle1  = "|From|Up To|Rate|Over|Billable AMT";
 					 var headCount = ComCountHeadTitle(HeadTitle1) + 6;

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false, false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	FT_OVR_DYS,			false,	"",		dfNullInteger,	0,	false,	false,	2);
 					 InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	FT_UND_DYS,			false,	"",		dfNullInteger,	0,	true,	true,	2);
 					 InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	INV_RT_AMT,			true,	"",		dfNullFloat,	2,	true,	true);
 					 InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	RT_OVR_DYS,			false,	"",		dfNone,			0,	true,	true);
 					 InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	RT_OVR_CHG_AMT,		false,	"",		dfNullFloat,	2,	false,	false);
 					 InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	true,	BZC_CURR_CD,		false,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		0,		daCenter,	true,	INV_NO,				true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		0,		daCenter,	true,	CRE_OFC_CD,			true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		0,		daCenter,	true,	INV_DTL_SEQ,		true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		0,		daCenter,	true,	INV_RT_SEQ,			true,	"",		dfNone,			0,	true,	true);
			 		 InitDataProperty(0, cnt++ , dtHidden,  		0,		daCenter,	true,	DEL_FLAG,			true,	"",		dfNone,			0,	true,	true);
 					CountPosition = 0;
				 }
                 break;
                 
             case 3:
             	with (sheetObj) {
                     // 높이 설정
                     style.height = 102;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 2, 100);

                     var HeadTitle = "";
 					 var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

 					CountPosition = 0;
                 }
                 break;                 
         }
    }
	
    function initAxonControl() {
   		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때    	 
  		axon_event.addListener('mouseover', 'obj_mouseover', 	'txt_Remark',	'btn_cremark',	'btn_hremark', 'tdInclCNTRDetail', 'btn_display');	// onMouseover 이벤트
  		axon_event.addListener('mouseout', 	'obj_mouseout', 	'txt_Remark',	'btn_cremark',	'btn_hremark', 'tdInclCNTRDetail', 'btn_display');	// onMouseout 이벤트
  		axon_event.addListener('keydown', 	'ComKeyEnter', 		'form');
  		axon_event.addListener('change',	'obj_change', 'bkgNo','blNo','vvd_cd','por_cd','pol_cd','pod_cd','del_cd','custRef','ida_cgst_amt','ida_sgst_amt','ida_igst_amt','ida_ugst_amt');
  		  	
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
    }
    
  	/**
 	 * BKG No. 나 B/L No. 입력시 B/L No. 나 BKG No. 를 조회하는 함수
 	 */	 	
	function obj_change() {
 		var obj = event.srcElement;
		var formObj = document.form;
		var sheetCHGObj = sheetObjects[0];
		
		
		with(formObj) {
			switch(obj.name) {
				case "bkgNo":
					if (ComTrim(ComGetObjValue(bkgNo)) == "") {
						ComSetObjValue(blNo, "");
					}
					else if (ComTrim(ComGetObjValue(bkgNo)).length < 6) {
						ComShowCodeMessage("DMT00171", "BKG No. length!");
						ComSetObjValue(bkgNo, "");
						ComSetObjValue(blNo, "");
						ComSetFocus(bkgNo);
					}
					else {
						//1-1.BKG No. 또는 B/L No. 입력시 B/L No. 나 BKG No. 를 조회한다.
						ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.bkgNo));
						ComSetObjValue(formObj.bl_no, "");
						doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_CHECK_BKGNO);
					}				
					break;
					
				case "blNo":
					if (ComTrim(ComGetObjValue(blNo)) == "") {
						ComSetObjValue(bkgNo, "");
					}
					else if (ComTrim(ComGetObjValue(blNo)).length < 6) {
						ComShowCodeMessage("DMT00171", "B/L No. length");
						ComSetObjValue(bkgNo, "");
						ComSetObjValue(blNo, "");
						ComSetFocus(blNo);
					}				
					else {
						//1-1.BKG No. 또는 B/L No. 입력시 B/L No. 나 BKG No. 를 조회한다.
						ComSetObjValue(formObj.bkg_no, "");
						ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.blNo));					
						doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_CHECK_BKGNO);
					}				
					break;
					
				case "vvd_cd":
					//VVD CD 입력값 체크
					if (ComGetObjValue(formObj.vvd_cd) != "" && ComGetObjValue(formObj.vvd_cd).length != 9) {
						ComShowCodeMessage("DMT00165", "VVD CD");
						ComClearObject(formObj.vvd_cd);
						ComSetFocus(formObj.vvd_cd);
					}				
					break;
					
				case "por_cd":
					//POR 입력값 체크
					if (ComGetObjValue(formObj.por_cd) != "" && ComGetObjValue(formObj.por_cd).length != 5) {
						ComShowCodeMessage("DMT00165", "Location");
						ComClearObject(formObj.por_cd);
						ComSetFocus(formObj.por_cd);
					}				
					break;
					
				case "pol_cd":
					//POL 입력값 체크
					if (ComGetObjValue(formObj.pol_cd) != "" && ComGetObjValue(formObj.pol_cd).length != 5) {
						ComShowCodeMessage("DMT00165", "Location");
						ComClearObject(formObj.pol_cd);
						ComSetFocus(formObj.pol_cd);
					}				
					break;	

				case "pod_cd":
					//POD 입력값 체크 
					if (ComGetObjValue(formObj.pod_cd) != "" && ComGetObjValue(formObj.pod_cd).length != 5) {
						ComShowCodeMessage("DMT00165", "Location");
						ComClearObject(formObj.pod_cd);
						ComSetFocus(formObj.pod_cd);
					}				
					break;

				case "del_cd":
					//DEL 입력값 체크
					if (ComGetObjValue(formObj.del_cd) != "" && ComGetObjValue(formObj.del_cd).length != 5) {
						ComShowCodeMessage("DMT00165", "Location");
						ComClearObject(formObj.del_cd);
						ComSetFocus(formObj.del_cd);
					}				
					break;

				case "custRef":
					//Cust. Ref 입력값 체크
					if ( ComGetLenByByte(formObj.custRef) > 20 ) {
						ComShowCodeMessage('COM12142', "Cust. Ref", '20');
						ComSetFocus(formObj.custRef);
					}				
					break;	

				case "ida_cgst_amt":
				case "ida_sgst_amt":
				case "ida_igst_amt":
				case "ida_ugst_amt":
					DmtComCalcInvAmtByCngTaxAmt(obj);		
					break;		
			}
		}
	}	
	
    //포커스가 나갈 때
    function obj_blur() {
    	var obj 	= event.srcElement;
    	var formObj = document.form;

    	//입력Validation 확인하기 + 마스크구분자 넣기
    	switch(obj.name) {
	    	case "payer_cd":
	    		DmtComDoActionText(sheetObjects[0], formObj, obj, SEARCH20);
	    		break;

	    	case "trucker_cd":
	    		DmtComDoActionText(sheetObjects[0], formObj, obj, SEARCHLIST04);
	    		break;
	    		
	    	case "tot_amt":
	    	case "dc_amt":
	    	case "inv_chg_amt":
	    		//2011.03.10. kimtk. invoiceCurrency default no select
	    		if(!obj.readOnly){
	    			if (ComGetObjValue(formObj.inv_curr_cd) == "") {
	            		ComShowCodeMessage("DMT03028", "INV Cur.");
	            		ComClearObject(obj);
	            		ComSetFocus(formObj.inv_curr_cd);
	            		return;
	            	}
	    		}
	    		//==============================================================================================================
	    		// 아래 DmtComCalcInvAmtByTaxAmt 함수에서 어떤 계산방식으로 처리할지를 구분해주는 구분자 값을 설정해줍니다.
	    		DmtComCalcInvAmtByTaxAmt();
	    		//==============================================================================================================
    			break;
    	}
    }      
     
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		var formObj = document.form;
		
		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
 		    	// 영문대+숫자+예외문자
          		DmtComKeyOnlyAlphabet('uppernum', ',');
 		        break;
          	case "int":
     	        //숫자 만입력하기
     	        ComKeyOnlyNumber(event.srcElement);
     	        break;
        	case "float":
        		ComKeyOnlyNumber(event.srcElement, ".");
        		break;
        	case "float2":
        		ComKeyOnlyNumber(event.srcElement, ".-");        		
        		break;     	        
          	default:
 	         	// 숫자만입력하기(정수,날짜,시간)
 	            ComKeyOnlyNumber(event.srcElement);
		}
	}
	
     // (버튼 말풍선  보여줌)
 	function obj_mouseover() {
  		var msg = '';
 		var x = event.x+document.body.scrollLeft;
 		var y = event.y+document.body.scrollTop;
 		var skn = document.all("topdeck").style;

      	switch(event.srcElement.id){
 	  		case 'txt_Remark':
 	  			msg = 'Invoice Remark will be included in the Invoice Sheet';
 	  			x = x;
 	  			y = y-20;
 	  			skn.left = x;
 	  			skn.top  = y+20;
 	  			break;
 	  		
 	  		case 'btn_cremark':
 	  			msg = 'Invoice Cancel Remark';
 	  			x = x-20;
 	  			y = y-20;
 	  			skn.left = x;
 	  			skn.top  = y+20;
 	  			break;
 	  			
 	  		case 'btn_hremark':
 	  			msg = 'Invoice Hold Remark';
 	  			x = x-20;
 	  			y = y-20;
 	  			skn.left = x;
 	  			skn.top  = y+20;
 	  			break;
 	  			
 	  		case 'btn_display':
	  			msg = 'BKG Data and Charge in Deleted or Error status will be displayed';
	  			x = x-20;
	  			y = y-20;
	  			skn.left = x;
	  			skn.top  = y+20;
	  			break;
	  			
 	  		case 'tdInclCNTRDetail':
 	  			msg = 'If No, CNTR Detail cannot be input and print/fax/e-mail will be blocked';
 	  			x = x-20;
 	  			y = y-60;
 	  			skn.left = x;
 	  			skn.top  = y+20;
 	  			break; 	  			
      	}
 		
 		var bak = 'lightyellow';
 		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
    	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		document.all("topdeck").innerHTML = content;
 		skn.visibility = 'visible';
     }
     
     // (버튼 말풍선 숨김)
 	function obj_mouseout() {
 		var skn = document.all("topdeck").style;
 		skn.visibility = 'hidden';
 	}
     
 	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObj = document.form

  	    //Tariff, Attention 의 초기상태를 비활성화로 설정한다.(모든 컨트롤들의 초기상태는 비활성화다.)
  	    comboObj.Enable = false;
  	    
  	    switch(comboNo) {
  	    	//Tariff Type
  	    	case 1:
  	    		with(comboObj) {
  					MultiSelect = false; 
  					SetColAlign("left|left");        
  					SetColWidth("55|330");
  					DropHeight = 160;
  	    		}
  	    		break;
  	    		
  		    //Attention
	    	case 2:
	    		with (comboObj) {
					MultiSelect = false;
					UseCode = true;
					SetColAlign("left|left|left|left");
					DropHeight = 160;
	    		}
	    		break;
  	     } 
  	}
  	 
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        var cboTariff 		= comboObjects[0];
        var cboAttention 	= comboObjects[1];
        
		var sheetCHGObj 	= sheetObjects[0];
		var sheetRTObj 		= sheetObjects[1];
		
        switch(sAction) {
        
        	case IBSEARCH:      //조회
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH);
				ComSetObjValue(formObj.dmdt_inv_no, ComGetObjValue(formObj.invoiceNo));

				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible 	 = false;
				sheetCHGObj.WaitImageVisible = false;
				sheetRTObj.WaitImageVisible  = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));

				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var arrXml = sXml.split("|$$|");
	            
	            //3-1.Booking 정보를 추출한다.
	            cboTariff.Text = setDataFormat(ComGetEtcData(arrXml[0], "DMDT_TRF_CD"));
	            with(formObj) {
	            	ComSetObjValue(issueDate, 		setDataFormat(ComGetEtcData(arrXml[0], "ISSUE_DT")));
	            	ComSetObjValue(issueOfcCd, 		setDataFormat(ComGetEtcData(arrXml[0], "ISSUE_OFC")));
	            	ComSetObjValue(issueName, 		setDataFormat(ComGetEtcData(arrXml[0], "ISSUE_NM")));
	            	ComSetObjValue(dmdt_inv_sts_cd, setDataFormat(ComGetEtcData(arrXml[0], "DMDT_INV_STS_CD")));
	            	ComSetObjValue(status, 			setDataFormat(ComGetEtcData(arrXml[0], "DMDT_INV_STS_DESC")));
	            	ComSetObjValue(dmdt_ar_if_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "ARIF")));
	            	ComSetObjValue(arIfDate, 		setDataFormat(ComGetEtcData(arrXml[0], "ARIF_DT")));
	            	ComSetObjValue(arIfOfc, 		setDataFormat(ComGetEtcData(arrXml[0], "ARIF_OFC")));
	            	ComSetObjValue(arIfName, 		setDataFormat(ComGetEtcData(arrXml[0], "ARIF_NM")));
	            	ComSetObjValue(arIfId,			setDataFormat(ComGetEtcData(arrXml[0], "ARIF_ID")));
	            	ComSetObjValue(rhq_ofc_cd,		setDataFormat(ComGetEtcData(arrXml[0], "RHQ_OFC_CD")));
	            	
	            	//Credit Note
	            	ComSetObjValue(creditNote, 		setDataFormat(ComGetEtcData(arrXml[0], "CR_INV_NO")));
	            	if (ComGetObjValue(dmdt_inv_sts_cd) == "C") {
	            		creditNoteCaption.innerHTML = "Reference";
	            	}
	            	else {
	            		creditNoteCaption.innerHTML = "Credit Note";
	            	}
	            	
	            	if (ComGetObjValue(dmdt_inv_sts_cd) == "C" || ComGetObjValue(dmdt_inv_sts_cd) == "X") {
	            		var crArIfCd = setDataFormat(ComGetEtcData(arrXml[0], "CR_AR_IF_CD"));
            			ComSetObjValue(creditNoteArIf, 	"(A/R:" + crArIfCd + ")");	  	            	
	            	}
	            	
	            	ComSetObjValue(bkgNo, 			setDataFormat(ComGetEtcData(arrXml[0], "BKG_NO")));
	            	ComSetObjValue(blNo, 			setDataFormat(ComGetEtcData(arrXml[0], "BL_NO")));
	            	ComSetObjValue(incCntrDtail, 	setDataFormat(ComGetEtcData(arrXml[0], "INC_CNTR_DTL")));
	            	ComSetObjValue(vvd_cd, 			setDataFormat(ComGetEtcData(arrXml[0], "VVD_CD")));
	            	ComSetObjValue(por_cd, 			setDataFormat(ComGetEtcData(arrXml[0], "POR_CD")));
	            	ComSetObjValue(pol_cd, 			setDataFormat(ComGetEtcData(arrXml[0], "POL_CD")));
	            	ComSetObjValue(pod_cd, 			setDataFormat(ComGetEtcData(arrXml[0], "POD_CD")));
	            	ComSetObjValue(del_cd, 			setDataFormat(ComGetEtcData(arrXml[0], "DEL_CD")));
	            	
	            	//R/D
	            	ComSetObjValue(rcvTermCd, 		setDataFormat(ComGetEtcData(arrXml[0], "RCV_TERM_CD")));
	            	ComSetObjValue(deTermCd, 		setDataFormat(ComGetEtcData(arrXml[0], "DE_TERM_CD")));
	            	
	            	//BKG Cust.
	            	ComSetObjValue(bkg_cust_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_CD")));
	            	ComSetObjValue(bkg_cust_nm,		setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_NM")));
	            	//A/R Cust.
	            	ComSetObjValue(act_cust_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_CD")));
	            	ComSetObjValue(act_cust_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_NM")));
	            	//Payer.
	            	ComSetObjValue(payer_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_CD")));
	            	ComSetObjValue(payer_nm, 		setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM")));
	            	ComSetObjValue(act_payr_cust_nm2, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM2")));	// E-mail Send용 Customer Name
	            	//Attention
	            	ComSetObjValue(dmdt_payr_cntc_pnt_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "DMDT_PAYR_CNTC_PNT_NM")));
	            	ComSetObjValue(cust_cntc_pnt_seq, 		setDataFormat(ComGetEtcData(arrXml[0], "CUST_CNTC_PNT_SEQ")));
	            	//Trucker
	            	ComSetObjValue(trucker_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "VNDR_SEQ")));
	            	ComSetObjValue(trucker_nm, 		setDataFormat(ComGetEtcData(arrXml[0], "VNDR_NM")));
	            	
	            	//Incl.CNTR Detail 이 'N' 일 경우에는 DUE DATE 와 CREDIT TERM 은 보여주지 않는다.
	            	//Due Date, Credit Term
	            	// incCntrDtail 과 무관하게 모두 조회 ( 2011.11.14 )
            		ComSetObjValue(dueDate, 	setDataFormat(ComGetEtcData(arrXml[0], "DUE_DATE")));
            		ComSetObjValue(creditTerm, 	setDataFormat(ComGetEtcData(arrXml[0], "CR_TERM_DYS")));

	            	//Notice
	            	ComSetObjValue(notice, 		setDataFormat(ComGetEtcData(arrXml[0], "NOTICE")));
	            	//Cust. Ref.
	            	ComSetObjValue(custRef, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_REF_NO")));
	            	//Invoice Remark(s)
	            	ComSetObjValue(inv_rmk1, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_RMK1")));
	            	ComSetObjValue(inv_rmk2, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_RMK2")));
	            	//Charge Currency
	            	var chgCurrCd = setDataFormat(ComGetEtcData(arrXml[0], "CHG_CURR_CD"));
	            	if (chgCurrCd != "") {
	            		chgCurrCd += FIELDMARK + chgCurrCd;
	            		addComboItem(formObj.chg_curr_cd, chgCurrCd, true);
	            	}
	            	//Invoice Currency
	            	var invCurrCd = setDataFormat(ComGetEtcData(arrXml[0], "INV_CURR_CD"))
	            	
	            	if (invCurrCd != "") {
	            		invCurrCd += FIELDMARK + invCurrCd;
	            		ComClearCombo(formObj.inv_curr_cd);
	            		addComboItem(formObj.inv_curr_cd, invCurrCd, true);
	            	}
	            	//CNTR Q’ty
					ComSetObjValue(cntrQty, 		setDataFormat(ComGetEtcData(arrXml[0], "BKG_CNTR_QTY"), "AMT"));        	
	            	//Ex. Rate
	            	ComSetObjValue(inv_xch_rt, 		setDataFormat(ComGetEtcData(arrXml[0], "INV_XCH_RT"), "EX_RATE"));
	            	//Total AMT
	            	ComSetObjValue(tot_amt, 		setDataFormat(ComGetEtcData(arrXml[0], "BIL_AMT"), "AMT"));
	            	//Billing AMT
	            	ComSetObjValue(inv_chg_amt, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_CHG_AMT"), "AMT"));
	            	//Tax Rate
	            	ComSetObjValue(inv_tax_rto, 	setDataFormat(ComGetEtcData(arrXml[0], "TAX_RTO")));
	            	ComSetObjValue(tax_rto_dis, 	setDataFormat(ComGetEtcData(arrXml[0], "TAX_RTO")));
	            	//Office Tax Ratio
	            	ComSetObjValue(tax_rto, 		setDataFormat(ComGetEtcData(arrXml[0], "DFLT_TAX_RTO")));
	            	//Tax AMT
	            	ComSetObjValue(tax_amt, 		setDataFormat(ComGetEtcData(arrXml[0], "TAX_AMT")));
	            	//Payable AMT
	            	ComSetObjValue(inv_amt, 		setDataFormat(ComGetEtcData(arrXml[0], "INV_AMT"), "AMT"));  
	            	//Manual Invoice Reason
	            	ComSetObjValue(reason, 			setDataFormat(ComGetEtcData(arrXml[0], "DMDT_MNL_INV_RSN_CD")));
	            	//Manual Invoice Remark(s)
	            	ComSetObjValue(remark, 			setDataFormat(ComGetEtcData(arrXml[0], "MNL_INV_RMK")));
	            	
	            	//C.REMARK, H.REMARK
	            	ComSetObjValue(dmdt_cxl_rsn_cd, setDataFormat(ComGetEtcData(arrXml[0], "DMDT_CXL_RSN_CD")));
	            	ComSetObjValue(dmdt_cxl_rsn_nm, setDataFormat(ComGetEtcData(arrXml[0], "DMDT_CXL_RSN_NM")));
	            	ComSetObjValue(cxl_rmk, 		setDataFormat(ComGetEtcData(arrXml[0], "CXL_RMK")));
	            	ComSetObjValue(inv_hld_rsn_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_HLD_RSN_CD")));
	            	ComSetObjValue(inv_hld_rsn_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_HLD_RSN_NM")));
	            	ComSetObjValue(inv_hld_rmk, 	setDataFormat(ComGetEtcData(arrXml[0], "INV_HLD_RMK")));
	            	ComSetObjValue(upd_dt, 			setDataFormat(ComGetEtcData(arrXml[0], "UPD_DT")));
	            	ComSetObjValue(upd_ofc_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "UPD_OFC_CD")));
	            	ComSetObjValue(upd_usr_id, 		setDataFormat(ComGetEtcData(arrXml[0], "UPD_USR_ID")));
	            	ComSetObjValue(upd_usr_nm, 		setDataFormat(ComGetEtcData(arrXml[0], "UPD_USR_NM")));
	            	
	            	//Invoice 구분값(Y : 심천(SZPSC), N:그 외)
	            	ComSetObjValue(suth_chn_iss_flg,setDataFormat(ComGetEtcData(arrXml[0], "SUTH_CHN_ISS_FLG")));
	            	
	            	//Preview 가  나타날 위치정보
	            	ComSetObjValue(bil_to_loc_div_cd, setDataFormat(ComGetEtcData(arrXml[0], "BIL_TO_LOC_DIV_CD")));
	            	
	            	//Sheet Option Tax Ratio 와 Invoice 에 저장된 Tax Ratio 가 다를 경우에는 Uncheck 한다.
	            	if (ComGetObjValue(formObj.tax_rto_dis) != ComGetObjValue(formObj.tax_rto)) {
	            		formObj.chk_tax.checked = false;
	            	}
	            	else {
	            		formObj.chk_tax.checked = true;
	            	}

	            	//Charge Currency 설정
	            	ComClearCombo(chg_curr_cd);
	            	addComboItem(chg_curr_cd, setDataFormat(ComGetEtcData(arrXml[0], "CHG_CURR_CD")), true);
	            	
	            	//Payer 에서 Country 비교를 위해서 사용하는 정보
	            	ComSetObjValue(cre_cnt_cd,       setDataFormat(ComGetEtcData(arrXml[0], "CRE_CNT_CD")));

	            	ComSetObjValue(inv_new_rpt_flg,  setDataFormat(ComGetEtcData(arrXml[0], "INV_NEW_RPT_FLG")));
	            	
	            	ComSetObjValue(colDate,           setDataFormat(ComGetEtcData(arrXml[0], "COL_DATE")));
	            	
	            	ComSetObjValue(col_charge,        setDataFormat(ComGetEtcData(arrXml[0], "COL_CHARGE")));		
	            	ComSetObjValue(col_tax,           setDataFormat(ComGetEtcData(arrXml[0], "COL_TAX")));			

	            	// 신규 필드 추가함.
	            	ComSetObjValue(inv_col_charge, 	  setDataFormat(ComGetEtcData(arrXml[0], "INV_COL_CHARGE")));	// 납부금액 - INVOICE CURRENCY 로 환산된 금액
	            	ComSetObjValue(inv_col_tax, 	  setDataFormat(ComGetEtcData(arrXml[0], "INV_COL_TAX")));		// 납부세금 - INVOICE CURRENCY 로 환산된 금액
	            	ComSetObjValue(chg_col_charge, 	  setDataFormat(ComGetEtcData(arrXml[0], "CHG_COL_CHARGE")));	// 납부금액 - CHARGE CURRENCY 로 환산된 금액
	            	ComSetObjValue(chg_col_tax, 	  setDataFormat(ComGetEtcData(arrXml[0], "CHG_COL_TAX")));		// 납부세금 - CHARGE CURRENCY 로 환산된 금액
	            	ComSetObjValue(inv_uncol_amt, 	  setDataFormat(ComGetEtcData(arrXml[0], "INV_UNCOL_AMT")));	// 미수금   - INVOICE CURRENCY 로 환산된 금액
	            	ComSetObjValue(chg_uncol_amt, 	  setDataFormat(ComGetEtcData(arrXml[0], "CHG_UNCOL_AMT")));	// 미수금   - CHARGE CURRENCY 로 환산된 금액
	            	
	            	ComSetObjValue(vt_collected,      setDataFormat(ComGetEtcData(arrXml[0], "VT_COLLECTED")));
	            	ComSetObjValue(ots_clt_flg,       setDataFormat(ComGetEtcData(arrXml[0], "OTS_CLT_FLG")));
	            	ComSetObjValue(col_over_day,      setDataFormat(ComGetEtcData(arrXml[0], "COL_OVER_DAY")));
	            	ComSetObjValue(ida_locl_tax,      setDataFormat(ComGetEtcData(arrXml[0], "IDA_LOCL_TAX")));
	            	ComSetObjValue(ida_n2nd_locl_tax, setDataFormat(ComGetEtcData(arrXml[0], "IDA_N2ND_LOCL_TAX")));
	            	ComSetObjValue(ida_cgst_amt, 	  setDataFormat(ComGetEtcData(arrXml[0], "IDA_CGST_AMT")));
	            	ComSetObjValue(ida_sgst_amt, 	  setDataFormat(ComGetEtcData(arrXml[0], "IDA_SGST_AMT")));
	            	ComSetObjValue(ida_igst_amt, 	  setDataFormat(ComGetEtcData(arrXml[0], "IDA_IGST_AMT")));
	            	ComSetObjValue(ida_ugst_amt, 	  setDataFormat(ComGetEtcData(arrXml[0], "IDA_UGST_AMT")));
	            	ComSetObjValue(ida_tax_appl_tm,   setDataFormat(ComGetEtcData(arrXml[0], "IDA_TAX_APPL_TM")));	// Invoice 생성일자 기준으로 인도세법 변경 전/후를 구분해 줌
	            }
	            
	            //3-2.Charge 정보를 매핑시킨다.
            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetCHGObj.LoadSearchXml(arrXml[0]);//Charge
            	
	            //3-3.Rate Detail 정보를 매핑시킨다.
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) {
					
					sheetRTObj.LoadSearchXml(arrXml[1]);//Rate Detail
					
            		//조회된 Charge Currency (DMT_CHG_CALC) 를 화면의 Charge Currency 에 매핑시켜준다.
            		var chgCurrCd = sheetCHGObj.CellValue(sheetCHGObj.HeaderRows, BZC_CURR_CD);
            		ComSetObjValue(formObj.chg_curr_cd, chgCurrCd);
				}

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3-4.조회결과에 Charge 정보가 있고 그 Charge 에 소속된 Rate Detail 정보가 있으면 보여준다. 그렇지 않다면 신규 Rate Detail Row 를 생성해준다.
				if (sheetCHGObj.RowCount > 0) {
					if (fetchRateRowCountOfCharge() > 0) {
						displaySelectedRateDetail();
					}
					else {
						doActionAddRate();
					}
					
					//Billable AMT 값은 DB에서 조회된 값이므로 (Rate * Over) 로 계산된상태이기 때문에 인자로 true 를 넘겨준다.
					calcBillableAmount(true, "Retrieve");
				}
				else if (ComGetObjValue(formObj.incCntrDtail) == "N") {
					//D/C by AMT or % 값을 구한다.
					//==============================================================================================================
					// 아래 DmtComCalcInvAmtByTaxAmt 함수에서 어떤 계산방식으로 처리할지를 구분해주는 구분자 값을 설정해줍니다.
					DmtComCalcInvAmtByTaxAmt();
					//==============================================================================================================
				}

				//3-5.Charge 가 조회되면 CNTR Q'ty 를 갱신해준다.
				ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());				
				
            	// [ 인도세법 변경 후 관련 추가 로직 ]======================================================================
        		// 1. OFC 가 인도지역일 경우 인도 Tax 관련 항목을 보여줍니다.
        		DmtComDisplayIdaTax();
        		// 2. 조회결과에 Payer 정보가 존재하는 경우, Payer 에 대한 Tax Rate 및 GST 정보를 조회합니다.
        		DmtComSearchIdaTaxRtoByPayer();	        		
        		// 3. 조회한 결과 정보로 Tax Ratio 항목의 값과 상태를 초기화 시켜줍니다.
        		DmtComInitTaxRto();
        		// 4. 금액필드에 데이터를 금액형식으로 표현해 줍니다.
        		DmtComDisplayCurrency();
        		//===========================================================================================================

				//3-6.화면 컴포넌트(입력, 버튼)의 상태를 제어합니다.
				controlScreen('');
				break;
				
        	
        	//BKG No. 또는 B/L No. 입력시 BKG No., B/L No. 를 조회해서 입력해준다.
         	case IBSEARCH_CHECK_BKGNO:
         		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, COMMAND02);
         		
         		//2.조회조건으로 조회실행
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//********************************************************************************
         		
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
         		
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var bkgNo = setDataFormat(ComGetEtcData(sXml, "BKG_NO"));
				var blNo  = setDataFormat(ComGetEtcData(sXml, "BL_NO"));
				
         		if (bkgNo != "") ComSetObjValue(formObj.bkgNo, bkgNo);
         		if (bkgNo != "") ComSetObjValue(formObj.blNo, blNo);

				break;
				

         	case IBSEARCH_CHECK_CNTRNO:
         		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, SEARCH02);
         		with(sheetObj) {
         			ComSetObjValue(formObj.cntr_no, CellValue(SelectRow, CNTR_NO));
         		}         		
         		
         		//2.조회조건으로 조회실행
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
         		ComSetObjValue(formObj.result, 	ComGetEtcData(sXml, "VALIDATE"));				
         		ComSetObjValue(formObj.result2, ComGetEtcData(sXml, "TPSZ_CD"));
         		
         		break;
         		
         		
			//Data Display 버튼 클릭시 Booking 정보와 Charge 정보를 조회해서 입력해준다.
         	case IBSEARCH_BKG_CHG:
         		
         		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, 			SEARCH01);
       			ComSetObjValue(formObj.bkg_no, 			ComGetObjValue(formObj.bkgNo));
       			ComSetObjValue(formObj.bl_no, 			ComGetObjValue(formObj.blNo));
       			ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.Text);
       			ComSetObjValue(formObj.mnl_inv_snd_flg, ComGetObjValue(formObj.incCntrDtail));
       			
				//2.조회조건으로 조회실행
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible 	 = false;
         		sheetCHGObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));
	
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var arrXml = sXml.split("|$$|");
         		
	            //3-1.Booking 정보를 추출한다.
	            with(formObj) {
	            	ComSetObjValue(vvd_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "VVD_CD")));
	            	ComSetObjValue(por_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "POR_CD")));
	            	ComSetObjValue(pol_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "POL_CD")));
	            	ComSetObjValue(pod_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "POD_CD")));
	            	ComSetObjValue(del_cd, 		setDataFormat(ComGetEtcData(arrXml[0], "DEL_CD")));
	            	//R/D
	            	ComSetObjValue(rcvTermCd, 	setDataFormat(ComGetEtcData(arrXml[0], "RCV_TERM_CD")));
	            	ComSetObjValue(deTermCd, 	setDataFormat(ComGetEtcData(arrXml[0], "DE_TERM_CD")));
	            	//BKG Cust.
	            	ComSetObjValue(bkg_cust_cd, setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_CD")));
	            	ComSetObjValue(bkg_cust_nm, setDataFormat(ComGetEtcData(arrXml[0], "BKG_CUST_NM")));
	            	//A/R Cust.
	            	ComSetObjValue(act_cust_cd, setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_CD")));
	            	ComSetObjValue(act_cust_nm, setDataFormat(ComGetEtcData(arrXml[0], "ACT_CUST_NM")));
	            	//Payer.
	            	ComSetObjValue(payer_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_CD")));
	            	ComSetObjValue(payer_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM")));
	            	ComSetObjValue(act_payr_cust_nm2, 	setDataFormat(ComGetEtcData(arrXml[0], "ACT_PAYR_CUST_NM2")));
	            	//Trucker.
	            	ComSetObjValue(trucker_cd, 	setDataFormat(ComGetEtcData(arrXml[0], "VNDR_SEQ")));
	            	ComSetObjValue(trucker_nm, 	setDataFormat(ComGetEtcData(arrXml[0], "VNDR_NM")));
	            	//Due Date, Credit Term
	            	ComSetObjValue(dueDate, 	setDataFormat(ComGetEtcData(arrXml[0], "DUE_DATE")));
	            	ComSetObjValue(creditTerm,	setDataFormat(ComGetEtcData(arrXml[0], "CR_TERM_DYS")));
	            	//Tax Rate / AMT
	            	ComSetObjValue(tax_rto,		setDataFormat(ComGetEtcData(arrXml[0], "TAX_RTO")));
	            	//S/C No.
	            	ComSetObjValue(sc_no, 		setDataFormat(ComGetEtcData(arrXml[0], "SC_NO")));
	            	//RFA No.
	            	ComSetObjValue(rfa_no, 		setDataFormat(ComGetEtcData(arrXml[0], "RFA_NO")));
	            }

	            // Payer 정보를 설정합니다. ( US, CA 로직 적용 Payer Code 적용 )
	            DmtComSetPayer();

	            //3-2.Charge 정보를 매핑시킨다.
	            sheetCHGObj.RemoveAll();
	            sheetRTObj.RemoveAll();
	            if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) {
	            	sheetCHGObj.LoadSearchXml(arrXml[0]);//Charge

            		//Charge Cur. 을 설정해준다. ====================================================================================================
	            	// incCntrDtail 과 무관하게 모두 조회 ( 2011.11.14 )
	            	//if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
		            	if (sheetCHGObj.RowCount > 0) {
							//조회된 Charge 정보의 Status 를 입력상태로 변경해 준다.
							changeChargeRowStatus("I");
							//조회된 Charge 정보에 순차적으로 Sequence 를 설정해 준다.
							setInvoiceDetailSeq();
							//자동으로 Rate Row 를 추가해준다.
				    		doActionAddRate();
							//Charge 가 조회되면 CNTR Q'ty 를 갱신해준다.
							ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
		            	}
	            	//}
	            	//============================================================================================================================
	            }

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************

            	//Incl.CNTR Detail 이 'Y' 인 경우 Charge Currency 를 조회한다.
				// incCntrDtail 과 무관하게 모두 조회 ( 2011.11.14 )
				//if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
            		searchChargeCurrency();
            		
            		if (ComGetObjValue(formObj.use_rt_curr) != "Y") {
	            		//조회된 Charge Currency (DMT_CHG_CALC) 를 화면의 Charge Currency 에 매핑시켜준다.
	            		var chgCurrCd = sheetCHGObj.CellValue(sheetCHGObj.HeaderRows, BZC_CURR_CD);
	            		if (chgCurrCd != "") {
	            			ComSetObjValue(formObj.chg_curr_cd, chgCurrCd);
	            		}
	            		else {
	            			formObj.chg_curr_cd.selectedIndex = -1;
	            		}
            		}
            	//}

	            //Charge Currency 가 있다면 Ex. Rate 를 구한다. 
	            if (ComGetObjValue(formObj.chg_curr_cd) != "") {
	            	searchExRate();
	            }

	            /************************************************/
	            if( !payCdValidation () ) return;
	            /************************************************/

 	            break;

	            

	        //VVD 가 유효한지 조회
         	case IBSEARCH_CHECK_VVD:
         		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, SEARCH05);
         		
         		//2.조회조건으로 조회실행
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
         		ComSetObjValue(formObj.result, 	ComGetEtcData(sXml, "IS_VVD"));				
         		break; 
	         		
	         		
	        //Calling Port Check
         	case IBSEARCH_CALLPORT:
         		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, SEARCH03);
         		
				//2.조회조건으로 조회실행
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
         		var result = ComGetEtcData(sXml, "IS_CALLPORT");
         		ComSetObjValue(formObj.result, result);
				
         		break;
         		

    		//Currency Code 를 조회한다.(Local Currency + Rate Currency)
	    	case IBSEARCH_CHG_CURR:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.bkg_no, 			ComGetObjValue(formObj.bkgNo));
				ComSetObjValue(formObj.dmdt_trf_cd,		cboTariff.Text);
				ComSetObjValue(formObj.f_cmd, 			SEARCH07);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var cboItems = ComGetEtcData(sXml, "CHG_CURR_CD");
				
				//3-1.Charge Currency 에 Currency 목록 생성
				//    기존 Currency 항목들을 모두 제거해준다.
				ComClearCombo(formObj.chg_curr_cd);
				//    조회된 Currency 항목들을 모두 추가해준다.
				addComboItem(formObj.chg_curr_cd, cboItems, true);
            	//2011.03.10. kimtk. chargeCurrency default no select
            	formObj.chg_curr_cd.selectedIndex = -1;
				
				break;
				
				
         	case IBSEARCH_EX_RATE:      //조회
	     		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.vvd_cd, 			ComGetObjValue(formObj.vvd_cd));
         		ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.Text);
         		ComSetObjValue(formObj.chg_curr_cd, 	ComGetObjValue(formObj.chg_curr_cd));
         		ComSetObjValue(formObj.inv_curr_cd, 	ComGetObjValue(formObj.inv_curr_cd));
	     		ComSetObjValue(formObj.f_cmd, 			SEARCH04);
	     		
				//2.조회조건으로 조회실행
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				ComSetObjValue(formObj.inv_xch_rt, setDataFormat(ComGetEtcData(sXml, "EX_RATE"), "EX_RATE"));
         		break;
         	

         	case IBSEARCH_SEND_EMAIL:
         		//1.SEND FAX 하기전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, SEARCH06);
         		
         		//2.FAX 전송
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
         		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
         		
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
         		//3.결과처리
        		ComShowMessage(dmtGetMsgText(sXml));
         		break;
         		
         		
         	//저장
			case IBSAVE:
         		//1. 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		if (ComTrim(ComGetObjValue(formObj.invoice_issue)) == "1") {
         			//[Invoice Issue 전] 저장
         			ComSetObjValue(formObj.f_cmd, MULTI);
         		}
         		else {
         			//[Invoice Issue 후] 저장
         			ComSetObjValue(formObj.f_cmd, MULTI01);
         		}
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				var sParam2 = sheetObjects[1].GetSaveString();

				//Booking 정보 요청매개변수 설정
				var cboTariff = comboObjects[0];
				with(formObj) {
					ComSetObjValue(bkg_no, 				ComGetObjValue(bkgNo));
					ComSetObjValue(bl_no, 				ComGetObjValue(blNo));
					ComSetObjValue(dmdt_trf_cd, 		cboTariff.Text);
					ComSetObjValue(mnl_inv_snd_flg, 	ComGetObjValue(incCntrDtail));
					ComSetObjValue(vvd_cd, 				ComGetObjValue(vvd_cd));
					ComSetObjValue(rcv_term_cd, 		ComGetObjValue(rcvTermCd));
					ComSetObjValue(de_term_cd, 			ComGetObjValue(deTermCd));
					//Payer
					var payerCustCd = ComGetObjValue(payer_cd);
					if (payerCustCd.length == 6) {
						ComSetObjValue(act_payr_cnt_cd, "00");
						ComSetObjValue(act_payr_seq, 	payerCustCd);
						ComSetObjValue(cust_cnt_cd, 	"00");
						ComSetObjValue(cust_seq, 		payerCustCd);						
					}
					else if (payerCustCd.length == 8) {
						ComSetObjValue(act_payr_cnt_cd, payerCustCd.substring(0, 2));
						ComSetObjValue(act_payr_seq, 	payerCustCd.substring(2));
						ComSetObjValue(cust_cnt_cd, 	payerCustCd.substring(0, 2));
						ComSetObjValue(cust_seq, 		payerCustCd.substring(2));		
					}
					//Invoice Remark(s)
					ComSetObjValue(inv_rmk1, 			ComGetObjValue(inv_rmk1));
					ComSetObjValue(inv_rmk2, 			ComGetObjValue(inv_rmk2));
					//Charge Currency
					ComSetObjValue(chg_curr_cd, 		ComGetObjValue(chg_curr_cd));
					//Attention
					ComSetObjValue(dmdt_payr_cntc_pnt_nm, 	cboAttention.Text);
					//Trucker
					ComSetObjValue(vndr_seq, 			ComGetObjValue(trucker_cd));
					//Notice
					ComSetObjValue(ntc_knt_cd, 			ComGetObjValue(notice));
					//Cust. Ref
					ComSetObjValue(inv_ref_no, 			ComGetObjValue(custRef));	
					//Invoice Currency
					ComSetObjValue(inv_curr_cd, 		ComGetObjValue(inv_curr_cd));
					//Total AMT (Inc.Cntr Detail 선택여부에 따라서 가져오는 값이 다르다.)	2015.03.23				
					ComSetObjValue(bil_amt,             getBillAmtByIncCntrDtail());
					//Ex. Rate
					ComSetObjValue(inv_xch_rt, 			ComGetUnMaskedValue(ComGetObjValue(inv_xch_rt),	"float"));
					//CNTR Q’ty
					ComSetObjValue(bkg_cntr_qty, 		ComGetUnMaskedValue(ComGetObjValue(cntrQty), "float"));					
					//Billing AMT
					ComSetObjValue(inv_chg_amt, 		ComGetUnMaskedValue(ComGetObjValue(inv_chg_amt), "float"));
					//Tax Ratio
					ComSetObjValue(tax_rto, 			ComGetUnMaskedValue(ComGetObjValue(tax_rto_dis), "float"));
					//Tax AMT
					ComSetObjValue(tax_amt, 			ComGetUnMaskedValue(ComGetObjValue(tax_amt), "float"));
					//Payable AMT
					ComSetObjValue(inv_amt, 			ComGetUnMaskedValue(ComGetObjValue(inv_amt), "float"));
					//Manual Invoice Reason					
					ComSetObjValue(dmdt_mnl_inv_rsn_cd, ComGetObjValue(reason));
					//Manual Invoice Remark
					ComSetObjValue(mnl_inv_rmk, 		ComGetObjValue(remark));
				}
				
				//Charge Grid 정보 요청매개변수 설정				
				if (sheetObjects[0].IsDataModified == true) {
					sParam1 = ComSetPrifix(sParam1, "subCharge");
					sParam = sParam1 + "&";
				}
				//Rate Detail Grid 정보 요청매개변수 설정
				if (sheetObjects[1].IsDataModified == true) {
					sParam2 = ComSetPrifix(sParam2, "subRate");
					sParam = sParam + sParam2;
				}
				
				// 3자리 콤마 제거
				DmtComRemoveCurrency();
				
				sParam += "&" + FormQueryString(formObj);
         		
         		//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				var sXml = sheetObj.GetSearchXml("EES_DMT_4004GS.do", sParam);
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				sheetObj.LoadSaveXml(sXml);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var successYn = ComGetEtcData(sXml, "SUCCESS_YN");
				ComSetObjValue(formObj.auto_ar_inf_yn, ComGetEtcData(sXml, "AUTO_AR_INF_YN"));
				
				//4.저장후 저장버튼 처리
				if (successYn == "Y") {
					if (ComGetObjValue(formObj.invoice_issue) == "1") {
						ComSetObjValue(formObj.invoiceNo, sheetObj.EtcData("INVOICE_NO"));
					}
					
					// 4.1) [ 발행된 invoice 정보 조회 전 설정 ]
					ComSetObjValue(formObj.invoice_issue, "2");	
			    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
					ComSetObjValue(formObj.inv_amt_calc_tp, "R");
					
					// 4.2) [ 발행된 invoice 정보 조회 ]
					//4.저장후 재조회
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					
					// 4.3) [ 발행된 invoice 정보 조회 후 설정값 원복 ]
			    	// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
					ComSetObjValue(formObj.inv_amt_calc_tp, "");
				}
				
				break;
                
                
        	case IBSEARCH_ARIF:
	     		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
	     		ComSetObjValue(formObj.f_cmd, COMMAND01);
	     		
	     		ComSetObjValue(formObj.dmdt_inv_no, ComGetObjValue(formObj.invoiceNo));
				ComSetObjValue(formObj.cre_ofc_cd, ComGetObjValue(formObj.issueOfcCd));
				
				//성공시 INVOICE 조회 버튼 처리
         		//*********************************************************************************
         		ComOpenWait(true);
         		sheetObj.WaitImageVisible = false;
         		//*********************************************************************************
         		
				var sXml = sheetObj.GetSaveXml("EES_DMT_4004GS.do", FormQueryString(formObj));
				
				//3.조회후 결과처리
				sheetObj.LoadSaveXml(sXml);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				ComSetObjValue(formObj.result, ComGetEtcData(sXml, "SUCCESS_YN"));//SUCCESS_YN
				
				// 4.1) [ 발행된 invoice 정보 조회 전 설정 ]
		    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
				ComSetObjValue(formObj.inv_amt_calc_tp, "R");
				
				// 4.2) [ 발행된 invoice 정보 조회 ]
				//4.저장후 재조회
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				
				// 4.3) [ 발행된 invoice 정보 조회 후 설정값 원복 ]
		    	// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
				ComSetObjValue(formObj.inv_amt_calc_tp, "");
				
        		break;                 

        }
    }

	//콤보관련 데이터를 조회하는 함수
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
		var cboTariff		= comboObjects[0];
		
	    sheetObj.ShowDebugMsg 		= false;
		sheetObj.WaitImageVisible 	= false;
		
	    switch(sAction) {
	    
	    	//Location 을 조회한다.
	    	case IBSEARCH_LOC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
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
				var locCd = setDataFormat(ComGetEtcData(sXml, "LOC_CD"));

				ComSetObjValue(formObj.result, locCd != "" ? "Y" : "N");
				break;
				
				
			//SHEET SET 이 존재하는지 조회
			case IBSEARCH_CHECK_SHEETSET:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				ComSetObjValue(formObj.dmdt_sh_tp_cd, 	"I");
				ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.Text);
				
				//ofc_cd 라는 변수는 사용자로그인 OFC CD 로 사용하기 때문에, 사용후 원복 해줘야 한다.
				var tmpOfcCd	=	ComGetObjValue(formObj.ofc_cd);
				ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.issueOfcCd));
				
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
				ComSetObjValue(formObj.has_sheetset, 	ComGetEtcData(sXml, "RESULT"));
				ComSetObjValue(formObj.ofc_cd, 			tmpOfcCd);
				
				break;

				
			//PAYER 별 EMAIL, FAX No. 정보를 조회
			case IBSEARCH_PAYER_EMLFAX:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.issueOfcCd));
				ComSetObjValue(formObj.dmdt_trf_cd, 	cboTariff.Text);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.payr_faxnos, 	setDataFormat(ComGetEtcData(sXml, "FAX_NO")));
				ComSetObjValue(formObj.payr_emailnos, 	setDataFormat(ComGetEtcData(sXml, "EMAIL_NO")));
				break;
				
				
			//SHEET OPTION 조회
			case IBSEARCH_SHEET_OPT:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				ComSetObjValue(formObj.ofc_cd, 			ComGetObjValue(formObj.issueOfcCd));
				
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
				ComSetObjValue(formObj.bil_to_loc_div_cd, 	ComGetEtcData(sXml, "BIL_TO_LOC_DIV_CD"));
				break;					
				

			//From Date, To Date 사이의 차이 일 수를 조회한다.
	    	case IBSEARCH_DYS_BETWEEN:	
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			sComboAction);
				
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
				ComSetObjValue(formObj.ovr_dys, 	ComGetEtcData(sXml, "OVR_DYS"));
				break;	    		
	    }
	    
		sheetObj.WaitImageVisible = true;
	}
	
   /**
    * 콤보필드에 데이터를 추가해준다.
    */	
	function addMultiComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}
	}
   /**
    * 콤보필드에 데이터를 추가해준다.
    */	
	function addComboItem(comboObj,comboDatas,isOnlyCode,isReverse) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems = comboDatas.split(ROWMARK);	
	    	for (var i = 0 ; i < comboItems.length ; i++) {
	    		comboItem = comboItems[i].split(FIELDMARK);
	    		//ComboItem[0]: Code, [1]: Description
   				val = comboItem[0];
				txt = isOnlyCode ? comboItem[0] : comboItem[1];
				// Combo 박스에 Description 이 나타나도록 설정해주는 변수
				if (isReverse) {
					ComAddComboItem(comboObj,txt,val);
				}
				else {
					ComAddComboItem(comboObj,val,txt);
				}
	    	}
		}   		
	}    
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//          if (!isNumber(formObj.iPage)) {
//              return false;
//          }
        }

        return true;
    }



	/**
	 * TariffType Combo Change 이벤트 처리
	 * Tariff Type 이 변경되면 Charge Currency 정보를 재조회한다. 
	 */
	function cboTariff_OnChange(cboObj, Index_Code, Text) {

		//searchChargeCurrency();
	}
	
	/**
	 * Attention Combo Change 이벤트 처리
	 * Attention 의 선택이 변경되면 변경되어진 Attention 의 Tel., Fax, E-mail 정보를 설정해준다. 
	 */
	function cboAttention_OnChange(cboObj, Index_Code, Text) {
		 
		 DmtComSetAttention();
	}

	//팝업버튼 Click 이벤트 처리
	function sheet1_OnPopupClick(sheetObj,Row,Col) {

		var cal = new ComCalendarGrid("myCal");
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case TO_MVMT_DT :
				case FT_END_DT  :
					cal.setEndFunction("resetOverDay");
					break;
			}
		}
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
    
   /**
	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (currDtlSeq == CellValue(row, INV_DTL_SEQ)) {
					SelectRow = row;
					break;
				}
			}
		}
	}	
	
   /**
	* Charge Row 가 선택될 때 해당 Rate Row 정보를 보여준다.
	*/	
	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj = document.form;
		var sheetRTObj = sheetObjects[1];
		
	
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		with(sheetObj) {
			if (OldRow >= HeaderRows && OldRow != NewRow) {

				//----------------------------------------------
				currDtlSeq = CellValue(SelectRow, INV_DTL_SEQ);
				//----------------------------------------------

				if (RowStatus(NewRow) != "D") {
					displaySelectedRateDetail();
					
					//1.Charge Row 를 Add 할 경우 자동으로 그 다음 Row 가 선택되면서 OnSelectCell 이 메소드가 호출된다.
					//  Row Add 를 위해서 DataInsert(-1) 메소드 호출즉시 OnSelectCell 이 메소드가 호출된다.
					//  따라서, 이 경우에는 CNTR_NO 로 체크를 해준다.
					//2.다음 Charge Row 가 선택될  경우 Rate Detail Row 가 없다면 새로 만들어줘야 한다.
					//3.1 번의 경우는 Row Add 를 시키면 안되고, 2 번의 경우에는 Row Add 를 해줘야 한다. 
					if (CellValue(NewRow, CNTR_NO) != "" && fetchRateRowCountOfCharge() == 0) {
						if (ComGetObjValue(formObj.dmdt_inv_sts_cd) != "X")
							doActionAddRate();
					}
				}
			}
		}
	}
	
	/**
	 * Charge Sheet 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		
		with(sheetObj) {
			switch(ColSaveName(Col)) {
		
				case CNTR_NO:
					if (ComTrim(CellValue(Row, Col)) != "")
						checkContainerNo();
					else
						CellValue2(Row, CNTR_TPSZ_CD) = "";
					break;

				
				case FM_MVMT_DT :
					//1.신규 입력시에만 F/T CMNC 날짜는 From Date 와 동일한 날짜가 Default 이며 수정 가능
					if (Value != "") {
						if (RowStatus(Row) == "I") {
							CellValue2(Row, FT_CMNC_DT) = Value;
						}
					}
					
					//2.F/T CMNC 날짜는 From DT 와 동일하거나 그 다음날 이어야 함.
//					F/T CMNC가 주말이 낀 경우에 3일 차이 날 수 있으므로 Validatio 로직 제거 - 삭제 여부 검토 예정(요청자 : Chris Yoon 2010-01-22)					
//					var ftCmncDT = CellValue(Row, FT_CMNC_DT);
//					if (ftCmncDT != "" && Value != "") {
//						var intervalDT = retrieveDaysBetween(Value, ftCmncDT);
//						if (intervalDT < 0 || intervalDT > 1) {
//							ComShowCodeMessage("DMT00172");
//							CellValue2(Row, Col) = "";
//						}
//					}
					
					//3.TO_MVMT_DT 는 FM_MVMT_DT 와 같거나 커야 한다.
					checkFromDTBetweenToDT(FM_MVMT_DT);
					break
					

				case TO_MVMT_DT:
					//1.Over Day 는 To Data 에서 F/T End 날짜를 뺀 일수를 계산하기 때문에 Over Day 계산을 위해서 아래 함수를 호출한다.
					//2.resetOverday 함수에서는 먼저 TO_MVMT_DT 의 입력값이 유효한지를 먼저 체크한 후 Over Day 계산을 수행한다.
					//3.아래 함수는 TO_MVMT_DT 달력 클릭시 자동으로 호출되는 공통함수이다.
					resetOverDay();
					break;
					
				
				case FT_CMNC_DT:
					//1.F/T CMNC 날짜는 From DT 와 동일하거나 그 다음날 이어야 함.
//					F/T CMNC가 주말이 낀 경우에 3일 차이 날 수 있으므로 Validatio 로직 제거 - 삭제 여부 검토 예정(요청자 : Chris Yoon 2010-01-22)						
//					var ftFmDT = CellValue(Row, FM_MVMT_DT);
//					if (ftFmDT != "" && Value != "") {
//						var intervalDT = retrieveDaysBetween(ftFmDT, Value);
//						if (intervalDT < 0 || intervalDT > 1) {
//							ComShowCodeMessage("DMT00172");
//							CellValue2(Row, Col) = "";
//						}
//					}
					
					//2.F/T End 날짜는 F/T CMNC 날짜와 같거나 커야함.
					checkFTEndDTBetweenFTCmncDT(FT_CMNC_DT);
					
					//3.F/T End 날짜와 F/T CMNC 날짜의 차이 + 1 이 F/D 와 같거나 커야 함. 
					//  F/T 보다 작을 경우에 Alert 창 띄우며 막음.
					if (!compareFTDate()) {
						ComShowCodeMessage("DMT00171", "F/T End date.");
						CellValue2(Row, Col) = "";
					}
					break;
					
				
				case FT_END_DT:
					//1.Over Day 는 To Data 에서 F/T End 날짜를 뺀 일수를 계산하기 때문에 Over Day 계산을 위해서 아래 함수를 호출한다.
					//2.resetOverday 함수에서는 먼저 TO_MVMT_DT 의 입력값이 유효한지를 먼저 체크한 후 Over Day 계산을 수행한다.
					//3.아래 함수는 TO_MVMT_DT 달력 클릭시 자동으로 호출되는 공통함수이다.
					resetOverDay();
					break;
					
				
				case FT_DYS:
					//입력한 F/D 가 F/T End 날짜와 F/T CMNC 날짜의 차이 +1 과 같거나 작어야 함
					if (!compareFTDate()) {
						ComShowCodeMessage("DMT00171", "F/D.");
						CellValue2(Row, Col) = "";
					}	
					var ftMvDT = CellValue(Row, FM_MVMT_DT);
					var toMvDT = CellValue(Row, TO_MVMT_DT);

                    if (ftMvDT != "" && toMvDT != "" ) {
                    	resetOverDay();
                    }
					break;
			}
		}
	}
	
	/**
	 * Charge Sheet 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case FT_UND_DYS:
					resetOverDay();
					//Up To 가 변경되면 Billable AMT 를 재계산한다.
					calcBillableAmount(false);
					break;
					
				case INV_RT_AMT:
					//Rate 가 변경되면 Billable AMT 를 재계산한다.
					calcBillableAmount(false);
					break; 
				case RT_OVR_DYS:
					//날짜 가 변경되면  Billable AMT 를 재계산한다.
					calcBillableAmount(false);
					break;	
			}
			//2011.03.10. kimtk. ChargeCurrency 와 InvoiceCurrency 는 반드시 존재해야만 한다.
        	if (ComGetObjValue(formObj.chg_curr_cd) == "") {
        		ComShowCodeMessage("DMT03028", "Charge Cur.");
        		ComSetFocus(formObj.chg_curr_cd);
        	}
		    else if (ComGetObjValue(formObj.inv_curr_cd) == "") {
        		ComShowCodeMessage("DMT03028", "INV Cur.");
        		ComSetFocus(formObj.inv_curr_cd);
        	}
		}
	}
	
	function setRpt() {
  		var formObj = document.form;
  		if ( formObj.inv_new_rpt.checked == true )
  			formObj.inv_new_rpt_flg.value = "Y";
  		else
  			formObj.inv_new_rpt_flg.value = "N";
	}
	
   /**
    * Retrieve 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	    
    function doActionRetrieve() {
    	var formObj 		= document.form;
    	var cboAttention 	= comboObjects[1];
    	var sheetCHGObj 	= sheetObjects[0];

    	//조회 전 Validation Check
		var invNo = ComTrim(ComGetObjValue(formObj.invoiceNo));
		
		//1.Invoice No 가 입력되었는지 Validation 하여 미입력인 경우 오류처리한다.
		if (invNo == "") {
 			ComShowCodeMessage("DMT03028", "Invoice No.");
 			ComSetFocus(formObj.invoiceNo);
 			return;    			
		}
		//2.Invoice No 의 세번째 Alphabet 이 'R' 또는 'T' 일 경우 DMT03057 를 보여주고 오류처리한다.
		else if (invNo.substring(2, 3) == "R" || invNo.substring(2, 3) == "T") {
 			ComShowCodeMessage("DMT03057", "Invoice No.");
 			ComSetFocus(formObj.invoiceNo);
 			return;      			
		}

    	// 발행한 invoice 정보일 경우, 금액계산을 실행하지 않고, 조회된 결과를 그대로 보여주도록 옵션값을 설정한다.
		ComSetObjValue(formObj.inv_amt_calc_tp, "R");   
    	// 발행한 invoice 정보를 조회합니다.
    	doActionIBSheet(sheetCHGObj, formObj, IBSEARCH);
    	// 조회가 끝나면 정상적으로 Tax Amount, Invoice Amount 계산이 수행될 수 있도록 옵션값을 초기화 시켜준다.
		ComSetObjValue(formObj.inv_amt_calc_tp, "");
		//-------------------------------------------------------------------------
		currDtlSeq = sheetCHGObj.CellValue(sheetCHGObj.SelectRow, INV_DTL_SEQ);
		//-------------------------------------------------------------------------

    	//Preview, FaxSend, EmailSend 클릭시 DB 에 저장된 PayerCode를 보내기 위해서 임시저장한다. ========================
    	ComSetObjValue(formObj.org_payer_cd, ComGetObjValue(formObj.payer_cd));
    	//==========================================================================================================

     	//조회된 결과에 Payer 정보가 존재할 경우 Attention 정보를 조회한다.
     	//if (ComTrim(ComGetObjValue(formObj.payer_cd)) != "" && ComGetObjValue(formObj.incCntrDtail) == "Y") {
    	// incCntrDtail 값과 무관하게 모두 조회 ( 2011.11.14 )
    	if (ComTrim(ComGetObjValue(formObj.payer_cd)) != "") {
     		//Invoice 이후 일 경우에 ofc_cd 는 issue office 이다.
     		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.issueOfcCd));

     		// Payer 의 Attention 정보를 초기화해 줍니다.
     		DmtComInitPayerAttention();
     		
     		//Preview 클릭시 DB 에 저장된 Attention 정보를 보내기 위해서 임시저장한다.====================================
     		ComSetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm, 	ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm));
     		ComSetObjValue(formObj.org_payr_cntc_pnt_eml, 		ComGetObjValue(formObj.payr_cntc_pnt_eml));
     		ComSetObjValue(formObj.org_payr_cntc_pnt_phn_no, 	ComGetObjValue(formObj.payr_cntc_pnt_phn_no));
     		ComSetObjValue(formObj.org_payr_cntc_pnt_fax_no, 	ComGetObjValue(formObj.payr_cntc_pnt_fax_no));
     		//======================================================================================================
     	}

		//Sending History, Preview, INV Print, Fax Send, Email Send, Payer Info
     	if (ComGetObjValue(formObj.dmdt_inv_sts_cd) != "") {

	        //PayerCode 가 없을 경우 이메일, 팩스 전체 가져오는 sc 호출 하지 말것. 
			if (ComGetObjValue(formObj.payer_cd) != "") {
				//Payer 별 EMAIL, FAX No.를 조회한다.
				doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_PAYER_EMLFAX, COMMAND02);
			}
	        
			//Sheet Set 있는지 없는지 조회한다.
			//Sheet Set가 없을 경우에는 Preview, Print, Fax send, Email send를 버튼 클릭시 Alert MSG을 띄워 막고자 합니다
			doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_CHECK_SHEETSET, COMMAND13);			
     	}
    }
    
    /**
     * Data Display 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */	    
     function doActionDisplayData() {
     	var formObj 		= document.form;
     	var cboTariff 		= comboObjects[0];
     	var cboAttention 	= comboObjects[1];
     	var sheetCHGObj 	= sheetObjects[0];

     	//조회 전 Validation Check
     	with(formObj) {
     		if (ComTrim(ComGetObjValue(bkgNo)) == "") {
     			ComShowCodeMessage("DMT03028", "BKG No");
     			ComSetFocus(bkgNo);
     			return;
     		}
     		else if (ComTrim(ComGetObjValue(blNo)) == "") {
     			ComShowCodeMessage("DMT03028", "B/L No");
     			ComSetFocus(blNo);
     			return;     			
     		} 
     		else if (ComTrim(cboTariff.Text) == "") {
     			ComShowCodeMessage("DMT03028", "Tariff Type");
     			return;     			
     		} 
     		else if (ComTrim(ComGetObjValue(incCntrDtail)) == "") {
     			ComShowCodeMessage("DMT03028", "Incl. CNTR Detail");
     			ComSetFocus(incCntrDtail);
     			return;     			
     		}      		
     	}
     	
     	//hidden 으로 지정된 필드중 Display 액션실행에 영향을 주는 필드의 속성값을 초기화시킨다.
     	ComSetObjValue(formObj.dmdt_inv_sts_cd, "");

     	//BKG, Charge 정보를 조회한다.
     	ComSetObjValue(formObj.use_rt_curr, "Y");	//Local Currency 가 아닌 Rate Currency 가 선택되도록 설정해 준다.
     	doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_BKG_CHG);
     	ComSetObjValue(formObj.use_rt_curr, "N");	//Local Currency 가 선택되도록 재설정해 준다.
		//-------------------------------------------------------------------------
		currDtlSeq = sheetCHGObj.CellValue(sheetCHGObj.SelectRow, INV_DTL_SEQ);
		//-------------------------------------------------------------------------
		
		// 조회결과에 Payer 정보가 존재하는 경우, Payer 에 대한 Tax Rate 및 GST 정보를 조회합니다.
		DmtComSearchIdaTaxRtoByPayer();
		
		// 조회한 결과 정보로 Tax Ratio 항목의 값과 상태를 초기화 시켜줍니다.
		DmtComInitTaxRto();
		
		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();
     		
    	if (ComGetObjValue(formObj.usr_cnt_cd) == "MY") {
    		ComSetObjValue(formObj.inv_new_rpt_flg, "Y");
    		formObj.inv_new_rpt.checked = true;
    	} 
    	else {
    		ComSetObjValue(formObj.inv_new_rpt_flg, "N");
    		formObj.inv_new_rpt.checked = false;
    	}
    	
    	// 입력항목 상태 제어
    	controlScreen('display');
     }
    
    /**
     * New 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */	    
    function doActionNew() {
        var formObj 	= document.form;
        
        //1.팝업화면으로 들어왔을 때 초기화
        if (isPopupWindow()) {
        	//1-1.인자로 받은 Invoice No. 로 조회를 수행한다.
        	doActionRetrieve();
        	
        	//2-2.Data Display 버튼을 비활성화 시킨다.
        	ComBtnDisable("btn_display");
        }
        //2.메인화면으로 들어왔을 때 초기화
        else {
            //2-1.화면을 초기화한다.
        	controlScreen("init");
    		
    		//2-2.BKG No. 에 포커스를 준다.
    		ComSetFocus(formObj.bkgNo);
    		
    		//2011.03.10. kimtk. chargeCurrency default no select
    		formObj.inv_curr_cd.selectedIndex = -1;
        }
    }
    
   /**
    * Minimize 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	    
    function doActionMinimize() {
    	var sheetCHGObj = sheetObjects[0];
    	var sheetRTObj 	= sheetObjects[1];
    	var addHeight   = 0;
    	
		if (conditionLayer.style.display == 'block') {
			conditionLayer.style.display = 'none';
			addHeight = 127;
		}
		else {
			conditionLayer.style.display = 'block';
		}
		sheetCHGObj.style.height = IBSHEET_HEIGHT + addHeight;
		sheetRTObj.style.height  = IBSHEET_HEIGHT + addHeight;
    }
     
   /**
    * Save 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	    
    function doActionSave() {
        var formObj 		= document.form;
        var cboTariff 		= comboObjects[0];
        var cboAttention 	= comboObjects[1];
        var sheetCHGObj 	= sheetObjects[0];
        var sheetRTObj 		= sheetObjects[1];
        
        //.필수입력항목체크
        //BKG No.
        if (ComTrim(ComGetObjValue(formObj.bkgNo)) == "") {
        	ComShowCodeMessage("DMT03028", "BKG No");
        	ComSetFocus(formObj.bkgNo);
        	return;
        }
        //B/L No.
        else if (ComTrim(ComGetObjValue(formObj.blNo)) == "") {
        	ComShowCodeMessage("DMT03028", "B/L No");
        	ComSetFocus(formObj.bkgNo);
        	return;        	
        }
        //Tariff Type
        else if (ComTrim(cboTariff.Text) == "") {
        	ComShowCodeMessage("DMT03028", "Tariff Type");
        	return;           	
        }
        //Incl. CNTR Detail
        else if (ComTrim(ComGetObjValue(formObj.incCntrDtail)) == "") {
        	ComShowCodeMessage("DMT03028", "Incl. CNTR Detail");
        	ComSetFocus(formObj.incCntrDtail);
        	return;          	
        }

        //.POR/POL/POD/DEL 필수항목 체크
        if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
        	if (cboTariff.Text.substring(2, 3) == "O") {
        		if (ComTrim(ComGetObjValue(formObj.por_cd)) == "") {
        			ComShowCodeMessage("DMT03028", "POR");
        			ComSetFocus(formObj.por_cd);
        			return;
        		}
        		else if (ComTrim(ComGetObjValue(formObj.pol_cd)) == "") {
        			ComShowCodeMessage("DMT03028", "POL");
        			ComSetFocus(formObj.pol_cd);
        			return;
        		}
        	}
        	else if (cboTariff.Text.substring(2, 3) == "I") {
        		if (ComTrim(ComGetObjValue(formObj.pod_cd)) == "") {
        			ComShowCodeMessage("DMT03028", "POD");
        			ComSetFocus(formObj.pod_cd);
        			return;
        		}
        		else if (ComTrim(ComGetObjValue(formObj.del_cd)) == "") {
        			ComShowCodeMessage("DMT03028", "DEL");
        			ComSetFocus(formObj.del_cd);
        			return;
        		}        		
        	}
        }
        else if (ComGetObjValue(formObj.incCntrDtail) == "N") {
        	if (cboTariff.Text.substring(2, 3) == "O") {
        		if (ComTrim(ComGetObjValue(formObj.pol_cd)) == "") {
        			ComShowCodeMessage("DMT03028", "POL");
        			ComSetFocus(formObj.pol_cd);
        			return;
        		}
        	}
        	else if (cboTariff.Text.substring(2, 3) == "I") {
        		if (ComTrim(ComGetObjValue(formObj.pod_cd)) == "") {
        			ComShowCodeMessage("DMT03028", "POD");
        			ComSetFocus(formObj.pod_cd);
        			return;
        		}
        	}
        }

    	//[보완사항]==============================================================================================
    	//Incl. CNTR Detail이 No일 때, Save 버튼 누르면
    	//1) Incl. CNTR Detail 유무와 상관없이
    	//2) 공통항차 CFDR이면 OK
    	//3) 공통항차 CFDR이 아닐 경우 POR/POL/POD/DEL가 모두 입력되어있으면 OK, 아니면
    	//   "Please enter POR/POL/POD/DEL route or use common VVD CFDRYYMME" alert창 띄우며 막음   
    	//======================================================================================================
    	var vvd_cd = ComTrim(ComGetObjValue(formObj.vvd_cd));
    	if (vvd_cd.substring(0, 4) != "CFDR") {
    		if (	ComTrim(ComGetObjValue(formObj.por_cd)) == "" 
    			|| 	ComTrim(ComGetObjValue(formObj.pol_cd)) == ""
    			|| 	ComTrim(ComGetObjValue(formObj.pod_cd)) == "" 
    			|| 	ComTrim(ComGetObjValue(formObj.pod_cd)) == "") {
    			
    			ComShowCodeMessage("DMT01146", "POR/POL/POD/DEL");
    			return;
    		}
    	}
    	
        //.VVD CD 체크
        if (!validateCallPort()) {
        	ComClearObject(formObj.vvd_cd);
        	ComSetFocus(formObj.vvd_cd);
        	return;
        }
        
        //.Payer Validate =============================================================================================
		if (ComTrim(ComGetObjValue(formObj.payer_cd)) == "") {
			ComAlertFocus(formObj.payer_cd, ComGetMsg("DMT01052"));
			return false;
		}
		//=============================================================================================================
		
        //.CNTR No. 중복 여부 확인 및 중복될 경우 Alert 창 띄우며 막음
   		with(sheetCHGObj) {
 	  		var dupRows = ColValueDupRows(CNTR_NO);
 	  		if (dupRows != "") {
 	  			if (!ComShowCodeConfirm("DMT01124", "CNTR No")) return;
 			}
   		}

        //.A/R I/F 가 된 경우에는 Alert 창 띄우며 막음
        if (ComGetObjValue(formObj.dmdt_ar_if_cd) == "Y") {
        	ComShowCodeMessage("DMT03022");
        	return;
        }
        //Incl. CNTR Detail 이 'Y' 일 경우 ChargeCurrency 와 Charge 는 반드시 존재해야만 한다.
        if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
        	if (ComGetObjValue(formObj.chg_curr_cd) == "") {
        		ComShowCodeMessage("DMT03028", "Charge Cur.");
        		ComSetFocus(formObj.chg_curr_cd);
        		return;
        	}
        	else if (fetchRateRowCountOfCharge() == 0) {
        		ComShowCodeMessage("DMT03028", "Charge");
        		return;
        	}
        }
        
        if ( ComGetLenByByte(formObj.custRef) > 20 ) {
			//Cust.Ref 입력값 체크
			ComShowCodeMessage('COM12142', "Cust. Ref", '20');
			ComSetFocus(formObj.custRef);
			return;
		}
        
		//2011.03.10. kimtk.ChargeCurrency 와 InvoiceCurrency 는 반드시 존재해야만 한다.
    	if (ComGetObjValue(formObj.inv_curr_cd) == "") {
    		ComShowCodeMessage("DMT03028", "INV Cur.");
    		ComSetFocus(formObj.inv_curr_cd);
    		return;
    	}

        //.Charge 의 필수입력항목 체크
        with(sheetCHGObj) {
        	for (var row = HeaderRows ; row <= LastRow ; row++) {
        		if (RowStatus(row) != "D") {
        			if (ComTrim(CellValue(row, CNTR_NO)) == "") {
                		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "CNTR No");
                		return;
        			}
        			else if (ComTrim(CellValue(row, FM_MVMT_DT)) == "") {
                		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "From DT");
                		return;        				
        			}
        			else if (ComTrim(CellValue(row, TO_MVMT_DT)) == "") {
                		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "To DT");
                		return;        				
        			}
// 2012.04.19 김현화[CHM-201217219] FT_CMNC_DT , FT_END_DT 가 없어도 처리되도록 변경함.      			
//        			else if (ComTrim(CellValue(row, FT_CMNC_DT)) == "") {
//                		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "F/T CMNC");
//                		return;        				
//        			}
//        			else if (ComTrim(CellValue(row, FT_END_DT)) == "") {
//                		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "F/T End");
//                		return;        				
//        			}  
        			else if (ComTrim(CellValue(row, FT_DYS)) == "") {
                		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "F/D");
                		return;        				
        			}

        			//.Rate 의 필수입력항목 체크
        			var invNo 	= CellValue(row, INV_NO);
        			var ofcCd 	= CellValue(row, CRE_OFC_CD);
        			var dtlSeq 	= CellValue(row, INV_DTL_SEQ);

        			for (var subRow = sheetRTObj.HeaderRows ; subRow <= sheetRTObj.LastRow ; subRow++) {
        				
        				if (	sheetRTObj.RowStatus(subRow) != "D" 
        					&&	invNo 	== sheetRTObj.CellValue(subRow, INV_NO)
        					&&	ofcCd 	== sheetRTObj.CellValue(subRow, CRE_OFC_CD)
        					&&	dtlSeq 	== sheetRTObj.CellValue(subRow, INV_DTL_SEQ)	) {
        					
        					if (sheetRTObj.CellValue(subRow, INV_RT_AMT) == "") {
                        		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Rate");
                        		return;         						
        					}
        				}
        			}
        		}
        	}
        }

        //Attention
        ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, cboAttention.Text);

        //Total AMT(Incl.CNTR Detail 이 No이면 직접 입력 가능 /필수입력 (11번이 Yes이면 비활성화))
        if (ComGetObjValue(formObj.incCntrDtail) == "N") {
        	var tmpTotalAmt = ComTrim(ComGetObjValue(formObj.tot_amt));
        	
        	if (tmpTotalAmt == "" || ComParseInt(tmpTotalAmt) == 0) {
        		ComShowCodeMessage("DMT03028", "Total AMT");
        		ComSetFocus(formObj.tot_amt);
        		return;
        	}else{
        		
	        	if (ComGetObjValue(formObj.inv_curr_cd) == "") {
	        		ComShowCodeMessage("DMT03028", "INV Cur.");
	        		ComSetFocus(formObj.inv_curr_cd);
	        		return;
	        	}
        	}
        }

        //[1/25] Billing AMT가 0 보다 작을 경우 "Billing Amount should be larger than 0" 라는 4002 에러 문구 참조하여 같이 사용
        if (parseFloat(ComGetObjValue(formObj.inv_chg_amt)) <= 0) {
        	ComShowCodeMessage("DMT01128", "Billing Amount", "0");
        	return;
        }

        //.Reason 필수항목 체크
        if (ComTrim(ComGetObjValue(formObj.reason)) == "") {
        	ComAlertFocus(formObj.reason, ComGetMsg("DMT03028", "Reason"));
        	return;
        }

        //.Reason 이 Other(s) 인 경우에 Remark 미입력시 Alert 창 띄우며 막음
        if (ComGetObjValue(formObj.reason) == "OTH") {
        	if (ComTrim(ComGetObjValue(formObj.remark)) == "") {
        		ComAlertFocus(formObj.remark, ComGetMsg("DMT01038"));
        		return;
        	}
        	//입력된 Remark 가 10 자 보다 작을 경우
        	else if (ComTrim(ComGetObjValue(formObj.remark)).length < 10) {
        		ComAlertFocus(formObj.remark, ComGetMsg("DMT01038"));
        		return;        		
        	}
        }
        
        //Rate Detail 의 모든 데이터에 Charge Currency 를 설정해준다.
        setChargeCurrencyInRT();

        //Issue Office의 Sheet Option Tax Rate와 상이하며 0이 아닐 경우, 
        //“Discrepancy found in Tax Rate between Invoice and Sheet Option. Are you sure to save?”
        if (ComTrim(ComGetObjValue(formObj.invoiceNo)) != "") {
			//INVOICE TAX_RTO와 OFFICE별 TAX_RTO가 다를 경우 메시지 처리함
			if (	parseInt(ComGetObjValue(formObj.tax_rto_dis)) > 0  
				&&	ComGetObjValue(formObj.tax_rto_dis) != ComGetObjValue(formObj.tax_rto)) {

				if (!ComShowCodeConfirm("DMT00184")) return;
			}
        }
        
        //.Invoice No. 가 존재하면 [Invoice Issue 후] 로직을 태우고, 존재하지 않으면 [Invoice Issue 전] 로직을 태운다.
        doActionIBSheet(sheetCHGObj, formObj, IBSAVE);
    }

    /**
     * Row Add(Charge) 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */	     
    function doActionAddCharge() {
    	var formObj = document.form;
    	var sheetCHGObj = sheetObjects[0];

    	with(sheetCHGObj) {

    		if (RowCount > 0) {
    			var invNo = CellValue(HeaderRows, INV_NO);
    			var ofcCd = CellValue(HeaderRows, CRE_OFC_CD);
    		}
    		//Grid 에 Row 추가함.
    		DataInsert(-1);

    		//Charge Row 가 추가될 경우 키값을 설정해준다.
    		if (invNo != "") CellValue2(LastRow, INV_NO) = invNo;
   			if (ofcCd != "") CellValue2(LastRow, CRE_OFC_CD) = ofcCd;
    		CellValue2(LastRow, INV_DTL_SEQ) = fetchNextSeq(sheetCHGObj);
    		
    		//Charge Row 가 추가되면 자동으로 Rate Row 도 추가해준다.
   			doActionAddRate();
    		
    		//선택된 Charge 의 Rate 정보를 보여준다.
    		displaySelectedRateDetail();
    	}
		//Charge 가 추가되면 CNTR Q'ty 를 갱신해준다.
		ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
    }

    /**
     * Charge Row 가 추가될 경우 자동으로 Rate Row 를 추가하도록 동작을 정의하는 함수
     */	     
    function doActionAddRate() {
    	var sheetCHGObj = sheetObjects[0];
     	var sheetRTObj = sheetObjects[1];

     	//새로 생성된 Rate 에 키값을 입력하기 위해서 그 부모인 Charge 데이터로부터 추출한다.
     	with(sheetCHGObj) {
			var invNo = CellValue(SelectRow, INV_NO);
			var ofcCd = CellValue(SelectRow, CRE_OFC_CD);
			var dtlSeq = CellValue(SelectRow, INV_DTL_SEQ);
     	}
     	
     	var ftOvrDys = fetchRTFromVal();
     	with(sheetRTObj) {

     		//Grid 에 Row 추가함.
     		DataInsert(-1);

     		//Charge Row 가 추가될 경우 키값을 설정해준다.
     		CellValue2(LastRow, INV_NO) = invNo;
    		CellValue2(LastRow, CRE_OFC_CD) = ofcCd;
    		CellValue2(LastRow, INV_DTL_SEQ) = dtlSeq;
     		CellValue2(LastRow, INV_RT_SEQ) = fetchNextSeq(sheetRTObj);
     		
     		//From 컬럼의 값을 자동으로 설정해준다.
     		CellValue2(LastRow, FT_OVR_DYS) = ftOvrDys;
     	}
 		//선택한 Charge Row 에 To DT 와 F/T End 가 입력되었다면 그 차이를 구해서 Rate Row 의 Over 컬럼에 설정해준다.
 		resetOverDay();
    }
     
   /**
    * Row Copy(Charge) 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	     
    function doActionCopyCharge() {
    	var formObj = document.form;
    	var sheetCHGObj = sheetObjects[0];
		
    	var srcRow = sheetCHGObj.SelectRow
		var newRow = sheetCHGObj.DataCopy();
		sheetCHGObj.RowStatus(newRow) = "I";

		//Charge 가 추가되면 CNTR Q'ty 를 갱신해준다.
		ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());	

		//Copy 된 Charge Row 에 키값을 설정해준다.
		sheetCHGObj.CellValue2(newRow, INV_DTL_SEQ) = fetchNextSeq(sheetCHGObj);

		//자동으로 Rate Row 도 Copy 해 준다.
		doActionCopyRate(srcRow, newRow);
		
		//선택된 Charge 의 Rate 정보를 보여준다.
		displaySelectedRateDetail();
		
		//Row 가 Copy 후 Billable AMT 계산을 수행한다.
		calcBillableAmount(true);
    }
   
   /**
    * Charge Row 가 Copy 될 경우 하위 Rate 항목도 Copy 해주는 함수
    */	     
	function doActionCopyRate(srcRow, newRow) {
		var sheetCHGObj = sheetObjects[0];
    	var sheetRTObj = sheetObjects[1];

    	//원본 Charge 의 Rate Detail 을 찾아서 복사해준다.
     	with(sheetCHGObj) {
			var srcInvNo  = CellValue(srcRow, INV_NO);
			var srcOfcCd  = CellValue(srcRow, CRE_OFC_CD);
			var srcDtlSeq = CellValue(srcRow, INV_DTL_SEQ);
			var newInvNo  = CellValue(newRow, INV_NO);
			var newOfcCd  = CellValue(newRow, CRE_OFC_CD);
			var newDtlSeq = CellValue(newRow, INV_DTL_SEQ);
     	}
     	
     	with(sheetRTObj) {
     		//Row 를 추가할 때 마다 LastRow 가 증가하기 때문에 무한 반복될 수 있다.
     		//따라서, Row 를 복사하기 전 LastRow 값을 임의 변수에 저장하고 그 값을 사용한다.
     		var endRow = LastRow;

     		for (var row = HeaderRows ; row <= endRow ; row++) {
     			if (	RowStatus(row) != "D" 
     				&&	srcInvNo  == CellValue(row, INV_NO)
     				&&	srcOfcCd  == CellValue(row, CRE_OFC_CD)
     				&&	srcDtlSeq == CellValue(row, INV_DTL_SEQ)	) {
     				
     	     		//Grid 에 Row 추가함.
     	     		DataInsert(-1);

     	     		//Charge Row 가 추가될 경우 키값과 복사될 데이터를 입력해준다.
     	     		CellValue2(LastRow, INV_NO) 		= newInvNo;
     	    		CellValue2(LastRow, CRE_OFC_CD) 	= newOfcCd;
     	    		CellValue2(LastRow, INV_DTL_SEQ)	= newDtlSeq;
     	     		CellValue2(LastRow, INV_RT_SEQ) 	= fetchNextSeq(sheetRTObj);
     	     		
     	     		CellValue2(LastRow, FT_OVR_DYS) 	= CellValue(row, FT_OVR_DYS);
     	     		CellValue2(LastRow, FT_UND_DYS) 	= CellValue(row, FT_UND_DYS);
     	     		CellValue2(LastRow, INV_RT_AMT) 	= CellValue(row, INV_RT_AMT);
     	     		CellValue2(LastRow, RT_OVR_DYS) 	= CellValue(row, RT_OVR_DYS);
     	     		CellValue2(LastRow, RT_OVR_CHG_AMT) = CellValue(row, RT_OVR_CHG_AMT);
     	     		CellValue2(LastRow, BZC_CURR_CD) 	= CellValue(row, BZC_CURR_CD);
     			}
     		}
     	}
   }
    
   /**
    * Delete(Charge) 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	     
    function doActionDelCharge() {
    	var formObj = document.form;
    	var sheetCHGObj = sheetObjects[0];
    	
		with(sheetCHGObj) {

			if (SelectRow >= HeaderRows) {
				
				//Charge 의 하위 목록인 Rate Adjustment 정보를 삭제한다.
				doActionDelRate();
				
				//선택된 Charge 정보를 삭제한다.
				if (RowStatus(SelectRow) == 'I') {
					RowDelete(SelectRow, false);
				}
				else {
					RowStatus(SelectRow) = 'D';
					RowHidden(SelectRow) = true;
				}
				
				//삭제된 후 자동선택된 Charge Row 정보에 해당되는 Rate Detail Row 정보를 보여준다.
				displaySelectedRateDetail();
				if (RowCount > 0 && fetchRateRowCountOfCharge() == 0) {
					doActionAddRate();
				}				
			}
		}
		//Charge 가 삭제되면 CNTR Q'ty 를 갱신해준다.
		ComSetObjValue(formObj.cntrQty, fetchChargeRowCount());
		
		//삭제 후 Billable AMT 계산을 수행한다.
		calcBillableAmount(true);
    }
   
   /**
    * Delete(Charge) 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	     
   function doActionDelRate() {
		var sheetCHGObj = sheetObjects[0];
		var sheetRTObj = sheetObjects[1];
		
		//Charge 와 Rate 의 관계를 연결시켜주는 Key 값을 추출한다.
		with(sheetCHGObj) {
			var invNo 	= CellValue(SelectRow, INV_NO);
			var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
			var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
		}

		with(sheetRTObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (	invNo 	== CellValue(row, INV_NO)
					&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
					&& 	ofcCd 	== CellValue(row, CRE_OFC_CD)		) {
	
					if (RowStatus(row) == 'I') {
						RowDelete(row, false);
					}
					else {
						RowStatus(row) = 'D';
						RowHidden(row) = true;
					}
				}
			}
		}
    }

   /**
    * FAX SEND 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */	
    function doActionFax() {
    	var formObj 	= document.form;
    	var sheetObj	= sheetObjects[2];

		//fax no가 존재하지 않으면
//		if(ComGetObjValue(formObj.payr_faxnos) == "") {
//			ComShowCodeMessage("DMT01090");
//			return;
//		}

		var mrd_file	= "";
//		var sndr_id		= "";	//id
//		var sndr_name	= "";	//
//		var sndr_email	= "";	//
//		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
//		var rcvr_email	= "";	//
//		var msg1		= "";

		//MRD 파일
		var temp_LR 			= ComGetObjValue(formObj.bil_to_loc_div_cd);
		var temp_incCntrDtail	= ComGetObjValue(formObj.incCntrDtail);
		var rhq	= ComGetObjValue(formObj.rhq_ofc_cd);
		var ofc_cd	= ComGetObjValue(formObj.issueOfcCd);
		var cre_cnt_cd = ComGetObjValue(formObj.cre_cnt_cd);
		var inv_new_rpt_flg = ComGetObjValue(formObj.inv_new_rpt_flg);
		/*
		if (temp_LR == "" || temp_LR == "L") {
			mrd_file = "EES_DMT_4901.mrd";		//L
		}
		else if (temp_LR == "R") {
			mrd_file = "EES_DMT_4902.mrd";		//R
		}
		*/
		
		if (temp_LR == "") {
			if (temp_incCntrDtail == "N") {
				
				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
				if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
  				    mrd_file = "EES_DMT_4918.mrd";
 			    }
				else {
 				    mrd_file = "EES_DMT_4908.mrd";
 			    } 
 			    */
				mrd_file = "EES_DMT_4908.mrd";
			}
			else {
				//if(rhq =="HAMRU"){
	    		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
	    		if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
				  mrd_file = "EES_DMT_4910.mrd";		
				}
	    		else {
	    			
	    			 /* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					 if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
						 mrd_file = "EES_DMT_4916.mrd";
     		 		 }
					 else {
     		 			 mrd_file = "EES_DMT_4901.mrd";  	//L
     		 		 }
     		 		 */
	    			mrd_file = "EES_DMT_4901.mrd";  	//L
				}
			}
 		} 
		else if (temp_LR == "L") {
 			if (temp_incCntrDtail == "N") {
 				
 				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
 				if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
  				    mrd_file = "EES_DMT_4918.mrd";
 			    }
 				else {
 				    mrd_file = "EES_DMT_4908.mrd";
 			    }
 			    */
 				mrd_file = "EES_DMT_4908.mrd";
			}
 			else {
				//if(rhq =="HAMRU"){
		    	// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					  mrd_file = "EES_DMT_4910.mrd";		
				}
				else {
					
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					 if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
						 mrd_file = "EES_DMT_4916.mrd";
     		 		 }
					 else {
     		 			 mrd_file = "EES_DMT_4901.mrd";  //L
     		 		 }
     		 		 */
					mrd_file = "EES_DMT_4901.mrd";  //L
				} 
			}
 		}
		else if (temp_LR == "R") {
 			if (temp_incCntrDtail == "N"){
 				
 				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
 				if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
 					mrd_file = "EES_DMT_4919.mrd";
    			}
 				else {
    				mrd_file = "EES_DMT_4909.mrd";
    			}
    			*/
 				mrd_file = "EES_DMT_4909.mrd";
			}
 			else {
				//if(rhq =="HAMRU"){
		    	// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					 mrd_file = "EES_DMT_4911.mrd";		
				}
				else {
					
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
       				 	 mrd_file = "EES_DMT_4917.mrd";
            		}
					else {	
      				     mrd_file = "EES_DMT_4902.mrd";		//R
      			    }
      			    */
					mrd_file = "EES_DMT_4902.mrd";		//R
				}
			}
 		}

//		//SEND
//		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
//		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
//		sndr_email	= ComGetObjValue(formObj.session_email);
//		
//		//RCV
//		var arr_faxnos 	= ComGetObjValue(formObj.payr_faxnos).split(";");
//		var re_faxnos	= "";
//		
//		for (var i = 0 ; i < arr_faxnos.length ; i++) {
//			re_faxnos	+= ComGetObjValue(formObj.payerCd) + ";" + arr_faxnos[i];
//			msg1		+= arr_faxnos[i] + "\n\t";
//		}
//		if (!ComShowCodeConfirm("DMT01092", msg1))	return;

		var dmdtInvNo 	= ComGetObjValue(formObj.invoiceNo);
		var blNo 		= ComGetObjValue(formObj.blNo); 
		var payerCd		= ComGetObjValue(formObj.org_payer_cd);
		
    	//MASTER DATA 조회
		var ma_param = "jspno=4004"
			 + "&invoice_no=" + dmdtInvNo
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
			 + "&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd);
		
		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
		sheetObj.LoadSearchXml(sXml);
		ComEtcDataToForm(formObj, sheetObj);
		
		//rd_fxeml_rd_param
		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4004&invoice_no="+dmdtInvNo+"&cre_ofc_cd="+ComGetObjValue(formObj.issueOfcCd)+"]"		//jspno, invoice_no
					;
		
		// 2011.10.19 수정
		var emlTitle;
   		var emlTemplt;
   		
   		if(ComGetObjValue(formObj.session_ofc_cd) != 'SAOSC') {
//   			emlTitle = "Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ") " + ComGetObjValue(formObj.act_payr_cust_nm2);
   			emlTitle = "Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ")";
   			emlTemplt = "EES_DMT_INVOICE_001.html";
   		} else {
   			emlTitle = "Fatura de Demurrage No: " + dmdtInvNo + " (Conhecimento de Embarque: SMLM" + blNo + ")";
   			emlTemplt = "EES_DMT_INVOICE_002.html";
   		}
		
		ComSetObjValue(formObj.invno,					dmdtInvNo);
		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
		ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
		ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
		ComSetObjValue(formObj.rd_fxeml_title,			emlTitle);
		ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
		ComSetObjValue(formObj.rd_fxeml_fax_no,			ComGetObjValue(formObj.payr_faxnos));			//rcvr_fax_no
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_add,	"");			//sndr_email
		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	"");	//rcvr_email	//mjchang@hanjin.com
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	"");
		ComSetObjValue(formObj.rd_fxeml_eml_templt,		emlTemplt);
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo + "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm2));
		ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
		ComSetObjValue(formObj.payc,					payerCd);
		ComSetObjValue(formObj.invno,					dmdtInvNo);

		//FAX 를 전송한다.
		//doActionIBSheet(sheetObj,formObj,IBSEARCH_SEND_FAX);
   }
    
    /**
     * EMAIL SEND 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */	
     function doActionEmail() {
    	var formObj 	= document.form;
    	var sheetObj	= sheetObjects[2];

// 		//Email no가 존재하지 않으면
// 		if(ComGetObjValue(formObj.payr_emailnos) == "") {
// 			ComShowCodeMessage("DMT01091");
// 			return;
// 		}
 		
 		var mrd_file	= "";
// 		var sndr_id		= "";	//id
// 		var sndr_name	= "";	//
// 		var sndr_email	= "";	//
// 		var rcvr_fax_no	= "";	//id;fax_no||id;fax_no
// 		var rcvr_email	= "";	//
// 		var msg1		= "";
 		
 		//MRD 파일
 		var temp_LR 			= ComGetObjValue(formObj.bil_to_loc_div_cd);
 		var temp_incCntrDtail	= ComGetObjValue(formObj.incCntrDtail);
 		var rhq	                = ComGetObjValue(formObj.rhq_ofc_cd); //2011.12.26 추가
 		var ofc_cd              = ComGetObjValue(formObj.issueOfcCd) //2012.01.11
		var cre_cnt_cd 			= ComGetObjValue(formObj.cre_cnt_cd);
		var inv_new_rpt_flg 	= ComGetObjValue(formObj.inv_new_rpt_flg);
 		/*
 		if (temp_LR == "" || temp_LR == "L") {
 			mrd_file = "EES_DMT_4901.mrd";		//L
 		}
 		else if(temp_LR == "R") {
 			mrd_file = "EES_DMT_4902.mrd";		//R
 		}
 		*/

 		if (temp_LR == "") {
			if (temp_incCntrDtail == "N") {
				
				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
				if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
  				   mrd_file = "EES_DMT_4918.mrd";
 			    }
				else {
 				     mrd_file = "EES_DMT_4908.mrd";
 			    } 
 			    */
				mrd_file = "EES_DMT_4908.mrd";
			}
			else {
				//if(rhq =="HAMRU"){
				// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC"){
					  mrd_file = "EES_DMT_4910.mrd";		
				}
				else {
					
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					 if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
        				 mrd_file = "EES_DMT_4916.mrd";
       		 		 }
					 else {
        			     mrd_file = "EES_DMT_4901.mrd";  //L
       		 		 }
       		 		 */
					mrd_file = "EES_DMT_4901.mrd";  //L
				}
			}
 		}
 		else if (temp_LR == "L") {
 			if (temp_incCntrDtail == "N") {
 				
 				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
 				if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
  				   mrd_file = "EES_DMT_4918.mrd";
 			    }
 				else {
 				     mrd_file = "EES_DMT_4908.mrd";
 			    }
 			    */
 				mrd_file = "EES_DMT_4908.mrd";
			}
 			else {
				//if(rhq =="HAMRU"){
				// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					  mrd_file = "EES_DMT_4910.mrd";		
				}
				else {
					
	 				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)					
					if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
						mrd_file = "EES_DMT_4916.mrd";
      		 		}
					else {
      		 			mrd_file = "EES_DMT_4901.mrd";  //L
      		 		}
      		 		*/
					mrd_file = "EES_DMT_4901.mrd";  //L
				}	 
			}
 		}
 		else if (temp_LR == "R") {
 			if (temp_incCntrDtail == "N") {
 				
 				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)	
 				if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y"){
				    mrd_file = "EES_DMT_4919.mrd";
			    }
 				else {
			    	mrd_file = "EES_DMT_4909.mrd";
			    }
			    */
 				mrd_file = "EES_DMT_4909.mrd";
			}
 			else {
				//if(rhq =="HAMRU"){
				// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					 mrd_file = "EES_DMT_4911.mrd";		
				}
				else {
					
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
        				mrd_file = "EES_DMT_4917.mrd";
             		}
					else {	
       				    mrd_file = "EES_DMT_4902.mrd";		//R
       			    }
       			    */
					mrd_file = "EES_DMT_4902.mrd";		//R
				}	 
			}
 		}
 		
// 		//SEND
// 		sndr_id 	= ComGetObjValue(formObj.session_usr_id);
// 		sndr_name	= ComGetObjValue(formObj.session_usr_nm);
// 		sndr_email	= ComGetObjValue(formObj.session_email);
// 		
// 		//RCV
//		rcvr_email		= ComGetObjValue(formObj.payr_emailnos);
//		var arr_emails	= ComGetObjValue(formObj.payr_emailnos).split(";");
// 		
// 		for(var i=0 ; i < arr_emails.length; i++) {
// 			msg1		+= arr_emails[i] +"\n\t";
// 		}
// 		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
 		
		var dmdtInvNo 	= ComGetObjValue(formObj.invoiceNo);
		var blNo 		= ComGetObjValue(formObj.blNo); 		
		var payerCd		= ComGetObjValue(formObj.org_payer_cd);
		
    	//MASTER DATA 조회
		var ma_param = "jspno=4004"
			 + "&invoice_no=" + dmdtInvNo
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
			 + "&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd);
		
		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	ma_param);
		//var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do",	"jspno=4004&invoice_no="+dmdtInvNo+"&f_cmd="+SEARCH01);
		sheetObj.LoadSearchXml(sXml);
		ComEtcDataToForm(formObj, sheetObj);
		
		//rd_fxeml_rd_param
		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4004&invoice_no="+dmdtInvNo+"&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)+"]"		//jspno, invoice_no
					;
		
		// 2011.10.19 수정
		var emlTitle;
   		var emlTemplt;
   		
   		if(ComGetObjValue(formObj.session_ofc_cd) != 'SAOSC') {
//   			emlTitle = "Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ") " + ComGetObjValue(formObj.act_payr_cust_nm2);
   			emlTitle = "Invoice Number: " + dmdtInvNo + " (B/L No.: SMLM" + blNo + ")";
   			emlTemplt = "EES_DMT_INVOICE_001.html";
   		} else { 
   			emlTitle = "Fatura de Demurrage No: " + dmdtInvNo + " (Conhecimento de Embarque: SMLM" + blNo + ")";
   			emlTemplt = "EES_DMT_INVOICE_002.html";
   		} 
		
		ComSetObjValue(formObj.rd_fxeml_sys_cd,			"DMT");
		ComSetObjValue(formObj.rd_fxeml_file_name,		mrd_file);
		ComSetObjValue(formObj.rd_fxeml_bat_flg,		"N");
		ComSetObjValue(formObj.rd_fxeml_title,			emlTitle);
		ComSetObjValue(formObj.rd_fxeml_rd_param,		rdParm);
		ComSetObjValue(formObj.rd_fxeml_fax_no,			"");			//rcvr_fax_no
		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	"SM Line");					//sndr_id
		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	"SM Line");				//sndr_name
		ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	ComGetObjValue(formObj.invoiceNo));
		ComSetObjValue(formObj.rd_fxeml_eml_templt,		emlTemplt);
		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,"inv_no;" + dmdtInvNo + "|bl_no;" + blNo+ "|payer_nm;" + ComGetObjValue(formObj.act_payr_cust_nm2));
		ComSetObjValue(formObj.rd_fxeml_doc_tp,			"I");	//  I : Invoice D : Demend G : GroupDemand O : OTS
		ComSetObjValue(formObj.payc,					payerCd);
		ComSetObjValue(formObj.invno,					dmdtInvNo);
		
 		//EMAIL 를 전송한다.
// 		doActionIBSheet(sheetObj,formObj,IBSEARCH_SEND_EMAIL);
    }
     
    /**
     * A/R I/F 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */	
    function doActionARIF() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    
    	//if ((ComGetObjValue(formObj.session_cnt_cd) != "US") && (ComGetObjValue(formObj.session_cnt_cd) != "CA")) {
		if((ComGetObjValue(formObj.usr_cnt_cd) != "US") && (ComGetObjValue(formObj.usr_cnt_cd) != "CA")) {
    		if (ComGetObjValue(formObj.payer_cd).length <= 6) {
    			ComShowCodeMessage("DMT00185");
    			return;
    		}
    	}    	
    	
    	if (!ComShowCodeConfirm("DMT03026")) return; 
		if (!payCdValidation()){
			return;
		}
    	
    	doActionIBSheet(sheetObj,formObj,IBSEARCH_ARIF);
    }

    /**
     * Close 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */
    function doActionClose() {
    	
		window.close();
		window.returnValue = "Y";
    }
    
   /**
	* ROW Add or Copy 시 다음 Sequence 를 구하는 함수
	*/		
	function fetchNextSeq(sheetObj) {
		var currSeq = 0;
		var nextSeq = 0;

		with(sheetObj) {
			var col = (id == "sheet1") ? INV_DTL_SEQ : INV_RT_SEQ;
			
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				currSeq = ComParseInt(CellValue(row, col));
				nextSeq = currSeq > nextSeq ? currSeq : nextSeq;
			}
		}
		return nextSeq + 1;
	} 
	
   /**
	* Rate Row 가 생성될 때, 자동으로 From 컬럼의 값을 구해주는 함수 
	*/	
    function fetchRTFromVal() {
		var sheetCHGObj = sheetObjects[0];
		var sheetRTObj 	= sheetObjects[1];
		
		var fromVal = 0;
		
		//Charge 와 Rate 의 관계를 연결시켜주는 Key 값을 추출한다.
		with(sheetCHGObj) {
			var invNo 	= CellValue(SelectRow, INV_NO);
			var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
			var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
		}

		with(sheetRTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&	invNo 	== CellValue(row, INV_NO)
					&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
					&& 	ofcCd 	== CellValue(row, CRE_OFC_CD)	) {
	
					fromVal = ComParseInt(CellValue(row, FT_UND_DYS));
				}
			}
		}
		return fromVal + 1;
    }
    
   /**
	* 선택된 Charge 가 가지는 Rate Detail 의 총 항목수를 구하는 함수
	*/	
    function fetchRateRowCountOfCharge() {
		var sheetCHGObj = sheetObjects[0];
		var sheetRTObj 	= sheetObjects[1];
		
		var totalCount = 0;
		
		//Charge 와 Rate 의 관계를 연결시켜주는 Key 값을 추출한다.
		with(sheetCHGObj) {
			var invNo 	= CellValue(SelectRow, INV_NO);
			var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
			var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
		}

		with(sheetRTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&	invNo 	== CellValue(row, INV_NO)
					&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
					&& 	ofcCd	== CellValue(row, CRE_OFC_CD)	) {
					totalCount++;
				}
			}
		}
		return totalCount;
    }

   /**
	* 선택된 Charge 가 가지는 Rate Detail 의 첫번째 항목의 Row 를 반환하는 함수
	*/	
    function fetchRateFirstRowOfCharge() {
		var sheetCHGObj = sheetObjects[0];
		var sheetRTObj  = sheetObjects[1];
		
		var firtRow = 0;
		
		//Charge 와 Rate 의 관계를 연결시켜주는 Key 값을 추출한다.
		with(sheetCHGObj) {
			var invNo 	= CellValue(SelectRow, INV_NO);
			var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
			var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
		}

		with(sheetRTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&	invNo 	== CellValue(row, INV_NO)
					&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
					&& 	ofcCd	== CellValue(row, CRE_OFC_CD)	) {
	
					firstRow = row;
					break;
				}
			}
		}
		return firstRow;
    }
    
   /**
	* 삭제되지 않은 Charge 의 항목수를 구하는 함수
	*/	
    function fetchChargeRowCount() {
		var sheetCHGObj = sheetObjects[0];
		
		var totalCount = 0;

		with(sheetCHGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D") {
					totalCount++;
				}
			}
		}
		return totalCount;
    }
    
   /**
	* Charge Sheet 의 CNTR No. 컬럼에 입력된 데이터에 대한 유효성과 중복성을 체크하는 함수 
	*/
    function checkContainerNo() {
    	var formObj = document.form;
    	var sheetCHGObj = sheetObjects[0];
    	
    	doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_CHECK_CNTRNO);
    	
    	if (ComGetObjValue(formObj.result) == "Y") {
   			sheetCHGObj.CellValue2(sheetCHGObj.SelectRow, CNTR_TPSZ_CD) = ComGetObjValue(formObj.result2);
    	}
    	else {
    		ComShowCodeMessage("DMT00171", "CNTR No.!");
    		sheetCHGObj.CellValue2(sheetCHGObj.SelectRow, CNTR_NO) = "";
    	}
    }
	
    /**
     * TO DT 나 F/T End 가 변경될 때마다 Over Day 를 새로 구하고, 그 결과를 Rate Detail 에 반영시킨다.
     */
    function resetOverDay() {
	    var sheetCHGObj = sheetObjects[0];
	    var sheetRTObj = sheetObjects[1];
	    var ftOverDays = 0;
	    
	    //1.To DT 나 F/T End Calender 를 클릭시 공통적으로 호출되는 함수로써 아래 기능을 수행한다.==================== 
	    //1-1.TO_MVMT_DT 는 FM_MVMT_DT 와 같거나 커야 한다.
	    if (!checkFromDTBetweenToDT(TO_MVMT_DT)) return;

	    //1-2.F/T End 날짜는 F/T CMNC 날짜와 같거나 커야함.
	    if (!checkFTEndDTBetweenFTCmncDT(FT_END_DT)) {
	    	//F/T End Date 가 To DT 와 같거나 클 경우에는 Rate Detail 의 Over 가 1 미만이기 때문에 1 개의 항목만 남기고 모두 삭제한다.
	    	initRateDetail();
			//날짜가 변경되면  Billable AMT 를 재계산한다.
			calcBillableAmount(false);
			return;
	    }

	    //1-3.F/T End 날짜와 F/T CMNC 날짜의 차이 + 1 이 F/D 와 같거나 커야 함.
	    if (!checkFTEndDT()) return;
	    //====================================================================================================
	    
	    with(sheetCHGObj) {
			var invNo 	= CellValue(SelectRow, INV_NO);
			var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
			var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
			
	    	var ftToDT 	= CellValue(SelectRow, TO_MVMT_DT);
			var ftEndDT = CellValue(SelectRow, FT_END_DT);
			var frMvDT 	= CellValue(SelectRow, FM_MVMT_DT);
	    	var ftDays  = CellValue(SelectRow, FT_DYS);
	    	
	    }
        if(ftEndDT == ""&& ftDays != ""){
        	ftEndDT = ComGetDateAdd(frMvDT, "D", ComParseInt(ftDays), "");
        	
        }

	    if (ftToDT != "" && ftEndDT != "") {
	    	ftOverDays = retrieveDaysBetween(ftEndDT, ftToDT);
			if (ftOverDays < 0) {
				ComShowCodeMessage("DMT01089", "To Date", "F/T End Date");
				sheetCHGObj.CellValue2(sheetCHGObj.SelectRow, FT_END_DT) = "";
				ftOverDays = 0;
			}
	    }
		else {
			ftOverDays = 0;
		}
	    
	    var isRowDelete = false;
	    var prevUpTo = 0;
	    
	    if (ftOverDays > 0) {
	    	with(sheetRTObj) {
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					if (	RowStatus(row) != "D"
						&&	invNo 	== CellValue(row, INV_NO)
						&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
						&& 	ofcCd 	== CellValue(row, CRE_OFC_CD)	) {
				
						if (!isRowDelete) {
							
							//UpTo 컬럼의 값이 지워졌다면 Over 컬럼에 나머지 날짜들을 모두 설정해주고, 그 이하 Row 는 삭제한다.
							if (CellValue(row, FT_UND_DYS) == "") {
								CellValue2(row, RT_OVR_DYS) = ftOverDays;
								ftOverDays = 0;
							}
							//UpTo 컬럼의 입력값은 From 보다 커야 한다.	작다면 UpTo 컬럼의 값은 삭제되며 Over 컬럼에 나머지 날짜들을 모두 설정해주고, 그 이하 Row 는 삭제한다.				
							else if (ComParseInt(CellValue(row, FT_UND_DYS)) < ComParseInt(CellValue(row, FT_OVR_DYS))) {
								ComShowCodeMessage("COM12133", "'From'", "'Up To'", "earlier");
								CellValue2(row, FT_UND_DYS) = "";
								CellValue2(row, RT_OVR_DYS) = ftOverDays;
								ftOverDays = 0;								
							}
							
							//이전 Row 의 UpTo 가 변경되면 현재 Row 의 From 도 변경된다.
							if (prevUpTo > 0) {
								CellValue2(row, FT_OVR_DYS) = prevUpTo + 1;
							}

							var intervalDays = ComParseInt(CellValue(row, FT_UND_DYS)) - ComParseInt(CellValue(row, FT_OVR_DYS)) + 1;
							
							if (ftOverDays == 0) {
								//이후 데이터는 모두 삭제
								isRowDelete = true;								
							}
							else if (ftOverDays > intervalDays) {
								CellValue2(row, RT_OVR_DYS) = intervalDays;
								ftOverDays -= intervalDays;
								//현재 Row 의 UpTo 가 변경될 경우 다음 Row 의 From 값을 구하기 위해서 변수에 저장한다. 
								prevUpTo = ComParseInt(CellValue(row, FT_UND_DYS));
							}
							else if (ftOverDays <= intervalDays) {
								CellValue2(row, RT_OVR_DYS) = ftOverDays;
								ftOverDays = 0;			
								//이후 데이터는 모두 삭제
								isRowDelete = true;
							}
						}
						else {
							if (RowStatus(row) == 'I') {
								//현재  삭제가 아니라, 처리완료 후 따로 삭제하기 위해서 표시해둠.
								//현 프로세스는 ROW 를 순차적으로 처리해야 되기 때문에, 삭제시 문제가 발생될 수 있음. 삭제는 후순위부터 처리하도록 해야함
								CellValue2(row, DEL_FLAG) = "Y";
							}
							else {
								RowStatus(row) = 'D';
								RowHidden(row) = true;
							}							
						}
					}
				}

				if (ftOverDays > 0) {
					doActionAddRate();
					CellValue2(LastRow, RT_OVR_DYS) = ftOverDays;
				}
				//위에서 DEL_FLAG 로 'Y' 설정된 모든 Rate 항목을 삭제한다.
				doActionDelRateByDelMark();
	    	}
	    }
	    else {
	    	//F/T End Date 가 To DT 와 같거나 클 경우에는 Rate Detail 의 Over 가 1 미만이기 때문에 1 개의 항목만 남기고 모두 삭제한다.
	    	initRateDetail();
	    }
		//날짜가 변경되면  Billable AMT 를 재계산한다.
		calcBillableAmount(false);
    }
    
    /**
     * F/T End 날짜와 F/T CMNC 날짜의 차이 + 1 이 F/D 와 같거나 큰지를 체크해주는 함수
     */		 
 	function compareFTDate() {
 	    var sheetCHGObj = sheetObjects[0];

 	    with(sheetCHGObj) {
 			var ftEndDT 	= CellValue(SelectRow, FT_END_DT);
 			var ftCmncDT 	= CellValue(SelectRow, FT_CMNC_DT);
 			var ftDT 		= CellValue(SelectRow, FT_DYS);

 			if (ftEndDT != "" && ftCmncDT != "") {
 				var intervalDT = ComParseInt(retrieveDaysBetween(ftCmncDT, ftEndDT)) + 1;
 				if (ftDT != "") {
 					if (intervalDT < ftDT) {
 						return false;
 					}
 				}
 			}
 	    }
 	    return true;
 	}
 	
 	/**
 	 * F/T End Calender 가 팝업된 후 닫힐 때 호출되는 함수로써 F/T DT 관련 체크로직을 수행한다.
 	 */		
    function checkFTEndDT() {
     	var sheetCHGObj = sheetObjects[0];
     
     	//F/T End 날짜와 F/T CMNC 날짜의 차이 + 1 이 F/D 와 같거나 커야 함.
 		if (!compareFTDate()) {
 			ComShowCodeMessage("DMT00171", "F/T End date.");
 			sheetCHGObj.CellValue2(sheetCHGObj.SelectRow, FT_END_DT) = "";
 			return false;
 		}
 		return true;
    }
 	 
    /**
     * TO_MVMT_DT 는 FM_MVMT_DT 와 같거나 커야 한다. 그럴 경우 true 반환, 그렇지 않으면 false 반환하는 함수
     */
	function checkFromDTBetweenToDT(COL) {
		var sheetCHGObj = sheetObjects[0];
		
		with(sheetCHGObj) {
			var fmMvmtDT = CellValue(SelectRow, FM_MVMT_DT);
			var toMvmtDT = CellValue(SelectRow, TO_MVMT_DT);
		}
		
		if (fmMvmtDT != "" && toMvmtDT != "") {
			var intervalDT = retrieveDaysBetween(fmMvmtDT, toMvmtDT);
			if (intervalDT < 0) {
				ComShowCodeMessage("DMT01020");
				sheetCHGObj.CellValue2(sheetCHGObj.SelectRow, COL) = "";
				return false;
			}
		}
		return true;
	}

    /**
     * F/T End 날짜는 F/T CMNC 날짜와 같거나 커야 한다. 그럴 경우 true 반환, 그렇지 않으면 false 반환하는 함수
 	 */
    function checkFTEndDTBetweenFTCmncDT(COL) {
 		var sheetCHGObj = sheetObjects[0];
 		
 		with(sheetCHGObj) {
 			var ftCmncDT = CellValue(SelectRow, FT_CMNC_DT);
 			var ftEndDT  = CellValue(SelectRow, FT_END_DT);
 		}
 		
 		if (ftCmncDT != "" && ftEndDT != "") {
 			var intervalDT = retrieveDaysBetween(ftCmncDT, ftEndDT);
 			if (intervalDT < 0) {
 				ComShowCodeMessage("DMT01031", "F/T End", "F/T CMNC");
 				sheetCHGObj.CellValue2(sheetCHGObj.SelectRow, COL) = "";
 				return false;
 			}
 		}
 		return true;
 	}
 	
   /**
  	* Del 표시된 Row 를 삭제해주는 함수
  	*/	 	 
 	function doActionDelRateByDelMark() {
 		var sheetRTObj = sheetObjects[1];
 		
 		with(sheetRTObj) {
 			for (var row = LastRow ; row >= HeaderRows ; row--) {
 				if (CellValue(row, DEL_FLAG) == "Y") {
 					RowDelete(row, false);
 				}
 			}
 		}
 	}
 	
   /**
  	* Incl. CNTR Detail 의 선택값에 따라서 Charge 와 Rate Grid 를 활성화 / 비활성화 시켜주는 함수
  	*/	 	 
    function changeChargeRate() {
    	var formObj = document.form;
    	var sheetCHGObj = sheetObjects[0];
    	var sheetRTObj = sheetObjects[1];
 		
    	if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
    		
    		//Charge Cur. 활성화
    		with(formObj) {
    			chg_curr_cd.selectedIndex = 0;
    			ComEnableManyObjects(true, chg_curr_cd);
    			chg_curr_cd.className = "input1";
    		}    		

    		//버튼 활성화
    		enableBtnCharge(true);
    	}
    	else {
    		//존재하는 Charge, Rate Detail 데이터를 모두 삭제해준다.
    		// incCntrDtail 과 무관하게 모두 조회 ( 2011.11.14 )
    		//clearGrid(sheetCHGObj);
    		//clearGrid(sheetRTObj);
    		
    		//Charge 가 전부 삭제되면 CNTR Q'ty 를 Empty 로 갱신해준다.
    		ComSetObjValue(formObj.cntrQty, "");
    		
    		//Charge Cur. 비활성화
    		with(formObj) {
    			chg_curr_cd.selectedIndex = -1;
    			ComEnableManyObjects(false, chg_curr_cd);
    			chg_curr_cd.className = "input2";
    		}
    		
    		//버튼 비활성화
    		enableBtnCharge(false);
    		
    	}
 	}
    
   /**
	* 주어진 SheetObject 의 모든 데이터를 지워준다. 
	*/	
	function clearGrid(sheetObj) {

		with(sheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowStatus(row) == 'I') {
					RowDelete(row, false);
				}			
				else {
					RowStatus(row) = "D";
					RowHidden(row) = true;
				}
			}
		}
	}    
 
   /**
	* 매개변수에 따라서 Charge Action Button 들의 상태를 활성화 / 비활성화 시켜주는 함수
	*/	
	function enableBtnCharge(flg) {
		
		if (flg) {
			ComBtnEnable("btn_AddCharge");
			ComBtnEnable("btn_CopyCharge");
			ComBtnEnable("btn_DelCharge");
			ComBtnEnable("btn_InqMVMT");
		}
		else {
			ComBtnDisable("btn_AddCharge");
			ComBtnDisable("btn_CopyCharge");
			ComBtnDisable("btn_DelCharge");
			ComBtnDisable("btn_InqMVMT");			
		}
	}
	
   /**
	* 선택되어진 Charge 의 Rate Detail 항목을 보여준다.
	*/	
	function displaySelectedRateDetail() {
		var sheetCHGObj = sheetObjects[0];
		var sheetRTObj = sheetObjects[1];
		
		with(sheetCHGObj) {
			var invNo 	= CellValue(SelectRow, INV_NO);
			var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
			var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
		}
		
		with(sheetRTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&	invNo 	== CellValue(row, INV_NO)
					&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
					&& 	ofcCd 	== CellValue(row, CRE_OFC_CD)	) {		
					RowHidden(row) = false;
				}
				else {
					RowHidden(row) = true;
				}
			}
		}
	}
	
   /**
	* Data Display 버튼을 클릭해서 조회된 Charge 정보를 입력상태로 변경해주는 함수
	*/		
	function changeChargeRowStatus(sts) {
		var sheetCHGObj = sheetObjects[0];
		
		with(sheetCHGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				RowStatus(row) = sts;
			}
		}		
	}
 
   /**
	* Data Display 버튼을 클릭해서 조회된 Charge 정보에 순차적으로 sequence 를 설정해주는 함수
	*/		
	function setInvoiceDetailSeq() {
		var sheetCHGObj = sheetObjects[0];
		
		var invDtlSeq = 0;
		
		with(sheetCHGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellValue2(row, INV_DTL_SEQ) = ++invDtlSeq;
			}
		}		
	}
	
   /**
	* Billable AMT 를 계산하는 함수
	*/	 
	function calcBillableAmount(isCalculated, caller) {
		var formObj = document.form;
		var sheetCHGObj = sheetObjects[0];
		var sheetRTObj = sheetObjects[1];
		var billableAmt = 0;

		with(sheetCHGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D") {
					
					var invNo 	= CellValue(row, INV_NO);
					var dtlSeq 	= CellValue(row, INV_DTL_SEQ);
					var ofcCd 	= CellValue(row, CRE_OFC_CD);
				
					for (var subRow = sheetRTObj.HeaderRows ; subRow <= sheetRTObj.LastRow ; subRow++) {
						if (	sheetRTObj.RowStatus(subRow) != "D"
							&&	invNo 	== sheetRTObj.CellValue(subRow, INV_NO)
							&&	dtlSeq 	== sheetRTObj.CellValue(subRow, INV_DTL_SEQ)
							&& 	ofcCd 	== sheetRTObj.CellValue(subRow, CRE_OFC_CD)	) {		

							if (	sheetRTObj.CellValue(subRow, INV_RT_AMT) != "" 
								&& 	sheetRTObj.CellValue(subRow, RT_OVR_DYS) != ""	) {
								
								if (!isCalculated) {
									sheetRTObj.CellValue2(subRow, RT_OVR_CHG_AMT) 
										= parseFloat(sheetRTObj.CellValue(subRow, INV_RT_AMT)) * parseFloat(sheetRTObj.CellValue(subRow, RT_OVR_DYS));
								}
								
								billableAmt += parseFloat(sheetRTObj.CellValue(subRow, RT_OVR_CHG_AMT));
							}
						}
					}
				}
			}
		}
		
		billableAmt = ComRound(billableAmt, 2);
		billableAmt = billableAmt + "";
		ComSetObjValue(formObj.mn_bil_amt, setDataFormat(billableAmt, "AMT"));
			
		//Ex.Rate, Total AMT, Billing AMT, Payable AMT 를 구한다.
		//==============================================================================================================
		DmtComCalcInvAmtByTaxAmt();
		//==============================================================================================================		
	}
 
  	/**
 	 * 각 공통팝업창 호출 함수 
 	 */
 	function doProcessPopup(caller) {
 		var formObj 		= document.form;
 		var cboTariff 		= comboObjects[0];
 		var cboAttention 	= comboObjects[1];
 		var sheetCHGObj 	= sheetObjects[0];
 		var paramVal, sUrl, sWidth, sHeight;

 		//Sheet Set, Sheet Option 에서 사용되는 매개변수
 		var invIssue = ComGetObjValue(formObj.invoiceNo) != "" ? 2 : 1;
 		
 		with(sheetCHGObj) {
	  		switch(caller) {

	  			case "btn_InqMVMT":
	  				if (fetchChargeRowCount() > 0) {
	  					var cntrNo = CellValue(SelectRow, CNTR_NO);
	  					var cntrTpSzCd = CellValue(SelectRow, CNTR_TPSZ_CD);
	  					
	  					if (cntrNo != "" && cntrTpSzCd != "") {
	  						paramVal = "?p_cntrno=" + cntrNo + "&ctnr_tpsz_cd=" + cntrTpSzCd;
	  						ComOpenPopup('EES_CTM_0408.do' + paramVal, 1036, 610, "getInqMVMT", "1,0,1,1,1,1,1", true);
	  					}
	  				}
					return;
					break;
			
	  			case "btn_payer_cd":	
	  				ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
	  				return;
					break;
					
	  			case "btn_trucker_cd":
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 450, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				return;
	  				break;
  				
  				case "btn_set":
  					paramVal = "?issoff=" 		+ ComGetObjValue(formObj.issueOfcCd)
							+ "&tftp2=" 		+ cboTariff.Text
							+ "&sheetp=I"
							+ "&invoice_issue=" + invIssue
							+ "&jspno=EES_DMT_4004";
  					
					sUrl	= "EES_DMT_4101.do" + paramVal;
					sWidth	= "725";
          			sHeight	= "780";  					
  					break;
  					
				case "btn_option":
					paramVal = "?issoff=" 		+ ComGetObjValue(formObj.issueOfcCd)
							+ "&jspno=EES_DMT_4004"
							+ "&invoice_issue=" + invIssue
							+ "&tftp=" 			+ cboTariff.Text;
								
					sUrl	= "EES_DMT_4103.do" + paramVal;
					sWidth	= "625";
          			sHeight	= "650";
          			break;  				

				case "btn_cancel":
          			if (ComGetObjValue(formObj.issueOfcCd) == ComGetObjValue(formObj.session_ofc_cd)) {
          				if (ComShowCodeConfirm('DMT03025')) {
          					paramVal = "?dmdt_inv_no=" 	+ ComGetObjValue(formObj.invoiceNo)
          							+ "&cre_ofc_cd=" 	+ ComGetObjValue(formObj.issueOfcCd)
          							+ "&dmdt_trf_cd=" 	+ cboTariff.Text
          					        + "&cre_cnt_cd="+ComGetObjValue(formObj.cre_cnt_cd);
          					        
          						sUrl	= "EES_DMT_4106.do" + paramVal;
          						sWidth	= "420";
          	          			sHeight	= "450";
          				}
          				else
          					return;
          			}
      				else {
      					ComShowCodeMessage('DMT03024', ComGetObjValue(formObj.issueOfcCd), ComGetObjValue(formObj.session_ofc_cd));
      					return;
      				}
          			break;
          			
				case "btn_sendinghistory":
					paramVal = "?jspno=EES_DMT_4004"
							+ "&invoice=" + ComGetObjValue(formObj.invoiceNo)
							+ "&selectOpt=1";
						
					sUrl	= "EES_DMT_7006_P.do" + paramVal;
					sWidth	= "1036";
		  			sHeight	= "690";					
					break;
          			
				case "btn_preview":
					paramVal = "?payr_cntc_pnt_phn_no=" + ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
							+ "&payr_cntc_pnt_fax_no=" 	+ ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
							+ "&payr_cntc_pnt_eml=" 	+ ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
//							+ "&dmdt_payr_cntc_pnt_nm=" + ComGetObjValue(formObj.org_dmdt_payr_cntc_pnt_nm)
							+ "&invoice_no=" 			+ ComGetObjValue(formObj.invoiceNo)
							+ "&invoice_LR=" 			+ ComGetObjValue(formObj.bil_to_loc_div_cd)
							+ "&cre_ofc_cd=" 			+ ComGetObjValue(formObj.issueOfcCd)
							+ "&payer_cd=" 				+ ComGetObjValue(formObj.org_payer_cd)
							+ "&bkg_no=" 				+ ComGetObjValue(formObj.bkgNo)
							+ "&bl_no=" 				+ ComGetObjValue(formObj.blNo)
							+ "&pod_cd=" 				+ ComGetObjValue(formObj.pod_cd)
							+ "&dmdt_trf_cd="			+ cboTariff.Text
							+ "&inc_cntr_dtail="		+ ComGetObjValue(formObj.incCntrDtail)
							+ "&rhq_ofc_cd="            + ComGetObjValue(formObj.rhq_ofc_cd)
							+ "&usr_cnt_cd="            + ComGetObjValue(formObj.usr_cnt_cd)
							+ "&cre_cnt_cd="            + ComGetObjValue(formObj.cre_cnt_cd)
							+ "&inv_new_rpt_flg="       + ComGetObjValue(formObj.inv_new_rpt_flg)
							+ "&cond_ida_sac_cd="       + ComGetObjValue(formObj.ida_sac_cd)
							+ "&jspno=4004";

					sUrl	= "EES_DMT_4003.do" + paramVal;
					sWidth	= "950";
		  			sHeight	= "735";						
					break;
					
				case "btn_payer":
					if (ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					
					if (ComGetObjValue(formObj.status) == "") {
						ofc_cd = ComGetObjValue(formObj.session_ofc_cd);
					}
					else {
						ofc_cd = ComGetObjValue(formObj.issueOfcCd);
					}
					
					paramVal = "?s_ofc_cd=" + ofc_cd
							+ "&s_cust_cd=" + ComGetObjValue(formObj.payer_cd)
							+ "&s_bkg_no=" 	+ ComGetObjValue(formObj.bkgNo)
							+ "&s_pod_cd=" 	+ ComGetObjValue(formObj.pod_cd)
							+ "&jspno=EES_DMT_4004"
							+ "&attn=" 		+ ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
							+ "&telno=" 	+ ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
							+ "&faxno=" 	+ ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
							+ "&email=" 	+ ComGetObjValue(formObj.payr_cntc_pnt_eml);	
					
					sUrl	= "EES_DMT_4104.do" + paramVal;
					sWidth	= "825";
		  			sHeight	= "620";					
					break;
				case "btn_fax":
					if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd = "";
					if(invIssue == "1") {
						return;
					}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
						ofc_cd = ComGetObjValue(formObj.issueOfcCd);
					}

					sUrl = "EES_DMT_4107.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj.bkgNo)
						+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
						+"&jspno=4004"
						+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
						;
					sWidth	= "500";
		  			sHeight	= "300";					
					break;
				case "btn_email":
					if(ComGetObjValue(formObj.org_payer_cd) == null || ComGetObjValue(formObj.org_payer_cd) == "") {
						ComShowCodeMessage("DMT00182");
						return;
					}
					var ofc_cd = "";
					if(invIssue == "1") {
						return;
					}else{	//ComGetObjValue(formObj.invoice_issue) == "2"
						ofc_cd = ComGetObjValue(formObj.issueOfcCd);
					}

					sUrl = "EES_DMT_4108.do"
						+"?s_ofc_cd="+ofc_cd
						+"&s_cust_cd="+ComGetObjValue(formObj.org_payer_cd)
						+"&s_bkg_no="+ComGetObjValue(formObj.bkgNo)
						+"&s_pod_cd="+ComGetObjValue(formObj.pod_cd)
						+"&jspno=4004"
						+"&telno="+ComGetObjValue(formObj.org_payr_cntc_pnt_phn_no)
						+"&faxno="+ComGetObjValue(formObj.org_payr_cntc_pnt_fax_no)
						+"&email="+ComGetObjValue(formObj.org_payr_cntc_pnt_eml)
						+"&cntc_seq="+ComGetObjValue(formObj.cust_cntc_pnt_seq)
						;
					sWidth	= "500";
		  			sHeight	= "300";					
					break;
	  				
	  		} // switch-end
 		} // with-end

  		if (sUrl.indexOf(".do") != -1) {
  			var sWinName = ComReplaceStr(sUrl, ".do", "");
  			
  			//PopUp 화면이 종료된  후 각 기능별로 추가적인 작업을 수행한다. ######################################################
  			if (caller == "btn_set") {
  				ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, 'yes');
  				
				//Sheet Set 있는지 없는지 조회한다.
				//Sheet Set가 없을 경우에는 Preview, Print, Fax send, Email send를 버튼 클릭시 Alert MSG을 띄워 막고자 합니다
				doActionIBCommon(sheetCHGObj, formObj, IBSEARCH_CHECK_SHEETSET, COMMAND13);
  			}
  			else {
  				var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  				
  				if (caller == "btn_cancel" && returnValue == "Y") {
  					doActionRetrieve();
  				}
  			}
  			//###########################################################################################################		
  		} 
 	}
 	
   	/**
  	 * SheetOption 팝업화면에서 변경시 자동변경 처리하는 로직임(Due Date, Credit Term, Tax Rate)
  	 */
  	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
  		var formObj 		= document.form;
 		var sheetCHGObj 	= sheetObjects[0];
 		
		if(cr_term_dys == "0" && is_dt_prn_flg == "2") {
			is_dt_prn_flg = "N";
		} else{
			is_dt_prn_flg = "Y";
		}
		
  		if (cr_term_dys != null && cr_term_dys != "") {

  			//Incl.CNTR Detail 이 'N' 일 경우에는 Due Date, Credit Term 은 안 보여준다.
  			if (ComGetObjValue(formObj.incCntrDtail) == "N") {
  				// incCntrDtail 과 무관하게 모두 조회 ( 2011.11.14 )
  				//ComClearObject(formObj.dueDate);
				//ComClearObject(formObj.creditTerm);
  			}
  			//Invoice Issue 이전
  			else if (!isPopupWindow()) {
  				if (cr_term_dys == "0") {
  					if (is_dt_prn_flg == "Y"){
  						//현재일자
  						ComSetObjValue(formObj.dueDate, ComGetObjValue(formObj.ofc_curr_date));
  						//날짜 하이픈 처리
  						ComSetObjValue(formObj.dueDate, ComGetMaskedValue(ComGetObjValue(formObj.dueDate), "ymd"));
  						//0
  						ComSetObjValue(formObj.creditTerm, "0");
  					} 
  					else if(is_dt_prn_flg == "N") {
  						ComSetObjValue(formObj.dueDate, "********");
  						ComClearObject(formObj.creditTerm);
  					}
  				} 
  				else if (parseInt(cr_term_dys) > 0) {
  					//현재일자
  					ComSetObjValue(formObj.dueDate, ComGetObjValue(formObj.ofc_curr_date));
  					//날짜 하이픈 처리
  					ComSetObjValue(formObj.dueDate, ComGetMaskedValue(ComGetObjValue(formObj.dueDate), "ymd"));
  					ComSetObjValue(formObj.creditTerm, cr_term_dys);
  				}
  			}
  			//Invoice Issue 이후
  			else if (isPopupWindow()) {
  				if (cr_term_dys == "0") {
  					if (is_dt_prn_flg == "Y") {
  						//Invoice 일자
  						ComSetObjValue(formObj.dueDate, ComGetObjValue(formObj.issueDate));
  						//0
  						ComSetObjValue(formObj.creditTerm, "0");
  					}
  					else if(is_dt_prn_flg == "N") {
  						ComSetObjValue(formObj.dueDate, "********");
  						ComSetObjValue(formObj.creditTerm, "");
  					}
  				}
  				else {
  					//Invoice 일자 + cr_term_dys
  					var cal_due_date = ComGetDateAdd(ComGetObjValue(formObj.issueDate), "D", parseInt(cr_term_dys)); 
  					ComSetObjValue(formObj.dueDate, cal_due_date);
  					ComSetObjValue(formObj.creditTerm, cr_term_dys);
  				}
  			}
  		}
  		
  		if (tax_rto == null || tax_rto == "") {
  			tax_rto = "0";
  		}
  		
  		//tax_rto
  		ComSetObjValue(formObj.tax_rto, tax_rto);
  		
  		if (formObj.chk_tax.checked) {
  			ComSetObjValue(formObj.tax_rto_dis, ComGetObjValue(formObj.tax_rto));
  			
  			//Tax Rate 가 변경되었기 때문에 재계산을 수행한다.
  			//==============================================================================================================
  			// 아래 DmtComCalcInvAmtByTaxAmt 함수에서 어떤 계산방식으로 처리할지를 구분해주는 구분자 값을 설정해줍니다.
  			DmtComCalcInvAmtByTaxAmt();
  			//==============================================================================================================
  		}
  		
		//sheetOption 팝업 닫은뒤 sheetOption 조회 하는 거 공통으로 만들었어요.
		doActionIBCommon(sheetCHGObj,formObj,IBSEARCH_SHEET_OPT,COMMAND14);
  	}
  	
   /**
    * EES_CTM_0408 팝업에서 선택한 값을 해당 필드에 설정 
  	*/ 	 
 	function getInqMVMT() {
    	var formObj = document.form;
    	
 	}
 	
    /**
 	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
 	 */
    function getCustCd(aryPopupData) {
    	var formObj 		= document.form;
    
    	formObj.payer_cd.value = aryPopupData[0][3];
    	formObj.payer_nm.value = aryPopupData[0][4];

		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();
    	
    	// Payer 정보가 변경되면 Payer 에 해당되는 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
    	DmtComSearchIdaTaxRtoByPayer();	    	
    }
    
	/**
     * Service Provider Inquiry 공통팝업 호출
 	 */
	function getSvcProvdr(aryPopupData) {
		var formObj = document.form;
 	        
 	    ComSetObjValue(formObj.trucker_cd, aryPopupData[0][2]);	
 	    ComSetObjValue(formObj.trucker_nm, aryPopupData[0][4]);
	}

   /**
	* Charge Currency 정보를 재조회한다. 
	*/	
	function searchChargeCurrency() {
		var formObj 	= document.form;
		var sheetCHGObj = sheetObjects[0];

		//Incl.CNTR Detail 이 'N' 일 경우에는 Charge Currency 가 존재하지 않는다.
		// incCntrDtail 과 무관하게 모두 조회 ( 2011.11.14 )
		//if (ComGetObjValue(formObj.incCntrDtail) == "N") return;
		
		//조회할 Country 정보를 설정한다.
		var cntCd = getCountryCodeByTariff();
		if (cntCd == "exit") return;
		
		//Local Currency + Rate Currency 를 조회한다
		ComSetObjValue(formObj.cnt_cd, cntCd);
		doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_CHG_CURR)

		if (ComGetObjValue(formObj.cnt_cd) != "") {
			//Ex. Rate 를 구한다.
			searchExRate();
		}
		else {
			//Charge Currency 선택을 Empty 로 만든다.
			formObj.chg_curr_cd.selectedIndex = -1;
			//Ex. Rate 를 Empty 로 만든다.
			ComClearObject(formObj.inv_xch_rt);
		}
		
		//계산을 수행한다.
		//==============================================================================================================
		// 아래 DmtComCalcInvAmtByTaxAmt 함수에서 어떤 계산방식으로 처리할지를 구분해주는 구분자 값을 설정해줍니다.
		DmtComCalcInvAmtByTaxAmt();		
		//==============================================================================================================
	}

   /**
	* Ex. Rate 를 조회하는 함수 
	*/	
	function searchExRate() {
		var formObj 	= document.form;
		var sheetCHGObj = sheetObjects[0];
		
		//1.Charge Currency 와 Invoice Currency 가 동일할 경우 Ex Rate 조회를 태우지 않고 1.00000% 로 설정한다.
		if (ComGetObjValue(formObj.chg_curr_cd) == ComGetObjValue(formObj.inv_curr_cd) || ComGetObjValue(formObj.incCntrDtail) == "N") {
			ComSetObjValue(formObj.inv_xch_rt, setDataFormat("1", "EX_RATE"));
		}
		//2.Charge Currency 와 Invoice Currency 가 다를 경우 Ex Rate 조회를 태운다.
		else {
			doActionIBSheet(sheetCHGObj, formObj, IBSEARCH_EX_RATE);	
		}
	}
	
 	/**
 	 * Tariff Type 에 따라 Currency 정보를 조회하기 위한 필수값인 Country Code 를 반환하는 함수 
 	 */
 	function getCountryCodeByTariff() {
 		var formObj 	= document.form;
 		var cboTariff 	= comboObjects[0];
 		var obj 		= event.srcElement;

 		var podCd 		= ComTrim(ComGetObjValue(formObj.pod_cd));
 		var delCd 		= ComTrim(ComGetObjValue(formObj.del_cd));
 		var polCd 		= ComTrim(ComGetObjValue(formObj.pol_cd));
 		var porCd 		= ComTrim(ComGetObjValue(formObj.por_cd));
 		var eventSrcName = obj.name;
 		
 		var cntCd = "";
		switch(cboTariff.Text) {
		case "DMIF":
				if (obj.name == "btn_display") eventSrcName = "pod_cd";
				
				if (eventSrcName == "pod_cd" && podCd.length == 5)
					cntCd = podCd.substring(0, 2);
				else
					cntCd = "exit";
				
				break;
			
		case "DTIC":
		case "CTIC":
				if (obj.name == "btn_display") eventSrcName = "del_cd";
				
				if (eventSrcName == "del_cd" && delCd.length == 5)
					cntCd = delCd.substring(0, 2);
				else
					cntCd = "exit";
				
				break;			            					
			
		case "DMOF":
				if (obj.name == "btn_display") eventSrcName = "pol_cd";
				
				if (eventSrcName == "pol_cd" && polCd.length == 5)
					cntCd = polCd.substring(0, 2);
				else
					cntCd = "exit";
				
				break;
			
		case "DTOC":
		case "CTOC":
				if (obj.name == "btn_display") eventSrcName = "por_cd";
				
				if (eventSrcName == "por_cd" && porCd.length == 5)
					cntCd = porCd.substring(0, 2);
				else
					cntCd = "exit";
				
				break;
		}

		return cntCd;
 	}

  	/**
 	 * 4004 화면이 팝업으로 띄워졌는지를 알려주는 함수
 	 */
 	function isPopupWindow() {
 	    var formObj = document.form;

 		if (ComGetObjValue(formObj.caller) != "" && ComGetObjValue(formObj.invoiceNo) != "") {
 			return true;
 		}
 		return false;  		
    }
 	
   /**
   	* Calling Port 체크를 위한 필수항목들이 모두 입력되었는지를 체크해주는 함수
    */  	 
 	function isCanCheckCallingPort() {
 		var formObj = document.form;
 		var cboTariff = comboObjects[0];
 		
		 //CALLING PORT 체크
 		if (ComGetObjValue(formObj.vvd_cd) != "") {
 			
 			var ioBnd = cboTariff.Text.substring(2, 3);
 			if (ioBnd == "O" && ComGetObjValue(formObj.pol_cd) != "")
 				return true;
 			else if (ioBnd == "I" && ComGetObjValue(formObj.pod_cd) != "")
 				return true;
    	}
 		return false;
 	}
 	
   /**
   	* Payer, Trucker 의 팝업을 띄울 수 있는지 체크해주는 함수
    */  	 
 	function isCanOpenPopupWin(srcName) {
 		var formObj = document.form;
 		
   		var isCan = !eval("formObj."+srcName).disabled;
   		
   		return isCan;
 	}
 	
   	/**
  	 * VVD CD, TARIFF, POL, POD 가 입력될 경우 유효한 Call Port 인지 조회를 수행하는 함수 
  	 */ 	
 	function validateCallPort() {
 		var formObj = document.form;
 		var cboTariff = comboObjects[0];
 		var sheetCHGObj = sheetObjects[0];
 		
        //.VVD CD 체크
        // VVD CD와 Calling port 체크 필요: Tariff Type 이 DMOF, DTOC, CTOC일 경우 POL 이, Tariff Type이 DMIF, DTIC,CTIC 일 경우
        // POD 가 해당 VVD CD 의 Calling Port 여야 함.
        var vvd_cd = ComTrim(ComGetObjValue(formObj.vvd_cd));
        var polCd = ComTrim(ComGetObjValue(formObj.pol_cd));
        var podCd = ComTrim(ComGetObjValue(formObj.pod_cd));
        var trfCd = ComTrim(cboTariff.Text);
        
        var vslCd 	 = vvd_cd.substring(0, 4);
        var skdVoyNo = vvd_cd.substring(4, 8);
        var skdDirCd = vvd_cd.substring(8);
        
        if (vslCd != "CFDR" || skdDirCd != "E") {
    		ComSetObjValue(formObj.vsl_cd, 		vslCd);
    		ComSetObjValue(formObj.skd_voy_no, 	skdVoyNo);
    		ComSetObjValue(formObj.skd_dir_cd, 	skdDirCd);

    		if (trfCd.substring(2, 3) == "O") {
        		ComSetObjValue(formObj.vps_port_cd, polCd);
        	}
        	else if (cboTariff.Text.substring(2, 3) == "I") {
        		ComSetObjValue(formObj.vps_port_cd, podCd);
        	}
        	
        	doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_CALLPORT);
        	
        	if (ComGetObjValue(formObj.result) == "N") {
        		ComShowCodeMessage("DMT00175");
        		return false;
        	}
        }
        return true;
 	}
 	
   /**
  	* 입력한 VVD CD 가 존재하는 VVD CD 인지 확인해주는 함수
  	*/  	
  	function validateVVD() {
  		var formObj = document.form;
  		var sheetCHGObj = sheetObjects[0];
  		
  		var vvd_cd = ComTrim(ComGetObjValue(formObj.vvd_cd));
		ComSetObjValue(formObj.vsl_cd, 		vvd_cd.substring(0, 4));
		ComSetObjValue(formObj.skd_voy_no, 	vvd_cd.substring(4, 8));
		ComSetObjValue(formObj.skd_dir_cd, 	vvd_cd.substring(8));
  		
		if(ComGetObjValue(formObj.vsl_cd) != "CFDR") {
			//유효한 VVD 인지 조회를 수행한다.
			doActionIBSheet(sheetCHGObj,formObj,IBSEARCH_CHECK_VVD);
		}else{
			//체크를 하지 않는다.
			ComSetObjValue(formObj.result, "Y");
		}
  		//조회된 결과를 반환한다.
  		if (ComGetObjValue(formObj.result) == "Y") return true;
  		
  		return false;
  	}
  	
   	/**
 	 * POR, POL, POD, DEL 컬럼이 필수항목이 되었을 경우 배경색을 변경해주는 함수
 	 */ 	
	function setFieldMandatoryColor() {
		var formObj = document.form;
		var cboTariff = comboObjects[0];

	    //1.POR/POL/POD/DEL Incl. CNTR Detail 이 Yes이면서 Tariff Type이 DMOF, DTOC, CTOC일 때, POR, POL이 필수입력	
	    //2.POR/POL/POD/DEL Incl. CNTR Detail 이 Yes이면서 Tariff Type이 DMIF, DTIC, CTIC일 때, POD, DEL가 필수입력
		with(formObj) {
			if (ComGetObjValue(incCntrDtail) == "Y") {
				if (cboTariff.Text.substring(2, 3) == "I") {
					por_cd.className = "input";
					pol_cd.className = "input";
					pod_cd.className = "input1";
					del_cd.className = "input1";					
				}
				else {
					por_cd.className = "input1";
					pol_cd.className = "input1";
					pod_cd.className = "input";
					del_cd.className = "input";					
				}
			}
			else {
				if (cboTariff.Text.substring(2, 3) == "I") {
					por_cd.className = "input";
					pol_cd.className = "input";
					pod_cd.className = "input1";
					del_cd.className = "input";					
				}
				else {
					por_cd.className = "input";
					pol_cd.className = "input1";
					pod_cd.className = "input";
					del_cd.className = "input";					
				}
			}
		}
	}
    
   /**
    * Charge Grid 의 모든 데이터와 버튼을 비활성화 시킨다.
    */
    function enableChargeGrid(flg) {
        var sheetCHGObj = sheetObjects[0];

        sheetCHGObj.Editable = flg;
    }
    
   /**
    * Rate Grid 의 모든 데이터와 버튼을 비활성화 시킨다.
    */
   function enableRateGrid(flg) {
       var sheetRTObj = sheetObjects[1];
       
       sheetRTObj.Editable = flg;
   }
    
  /**
   * Rate Detail 의 모든 데이터에 현재 설정한 Charge Currency 를 설정해준다.
   */
   function setChargeCurrencyInRT() {
	   var formObj = document.form;
       var sheetRTObj = sheetObjects[1];
       
       var chargeCur = ComGetObjValue(formObj.chg_curr_cd);
       
       with(sheetRTObj) {
    	   for (var row = HeaderRows ; row <= LastRow ; row++) {
    		   CellValue2(row, BZC_CURR_CD) = chargeCur;
    	   }
       }
    }

   /**
    * init RD
    * index : Index of toolbar items to be disabled. 0-Save a  file, 1-Print, 2-Find, 3-Creating a table of contents, 
    * 4-Zoom-in the screen, 5-Zoom-out the screen, 12-Stop printing, 13-View in Microsoft Excel, 14-View in Hangul, 
    * 15-View in pdf, 16-View in Microsoft PowerPoint, 17-View in Microsoft Word.
    * @param rdObject
    * @return
    */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;
		Rdviewer.AutoAdjust = true;
		Rdviewer.HideStatusbar();
		Rdviewer.ViewShowMode(0);
		Rdviewer.SetPageLineColor(255,255,255);
			
		Rdviewer.DisableToolbar (0);
		Rdviewer.DisableToolbar (13);
		Rdviewer.DisableToolbar (14);
		Rdviewer.DisableToolbar (15);
		Rdviewer.DisableToolbar (16);
		Rdviewer.DisableToolbar (17);
	} 
	
	//RD 오픈
    function rdOpen(rdObject,formObj ){
    	var sheetObj = sheetObjects[2];
    	var Rdviewer = rdObject ;

    	//var path = formObj.mrd.value;		//mrd_path
    	var path 				= "";
    	var invoice_LR 			= ComGetObjValue(formObj.bil_to_loc_div_cd);
    	var temp_incCntrDtail	= ComGetObjValue(formObj.incCntrDtail);
    	var rhq             	= ComGetObjValue(formObj.rhq_ofc_cd); // 2011.12.16 추가
    	var ofc_cd              = ComGetObjValue(formObj.issueOfcCd) //2012.01.11
    	var cre_cnt_cd          = ComGetObjValue(formObj.cre_cnt_cd);
    	var inv_new_rpt_flg     = ComGetObjValue(formObj.inv_new_rpt_flg);
    	
    	/*
		if(invoice_LR == "") {
			path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "L") {
			path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
		}else if(invoice_LR == "R") {
			path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
		}
		*/
    	
    	if (invoice_LR == "") {
			if (temp_incCntrDtail == "N") {
				if (cre_cnt_cd == "IN") {
	        		// india office 전용 2012.05.18	
	        	   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
				}
				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
					path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4918.mrd";
				}
				*/
				else {
				   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
				}   
			}
			else {
				//if(rhq =="HAMRU"){
    			// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11	
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4910.mrd";	
				}
				else {
					if (cre_cnt_cd == "IN") {
		        		// india office 전용 2012.05.18	
		        	   path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
					}
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
						path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4916.mrd";
					}
					*/
					else {   
					   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
					}
				}
			}
		}
    	else if (invoice_LR == "L") {
			if (temp_incCntrDtail == "N") {
				if (cre_cnt_cd == "IN") {
	        		// india office 전용 2012.05.18	
	        	   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
				}
				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
					path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4918.mrd";
				}
				*/
				else {
				   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
				} 
			}
			else {
				//if(rhq =="HAMRU"){
    			// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
					path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4910.mrd";	
				}
				else {
					if (cre_cnt_cd == "IN") {
		        		// india office 전용 2012.05.18	
		        	   path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";
					}
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
						path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4916.mrd";
					}
					*/
					else {
					   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
					}   
				}	
			}
		} else if(invoice_LR == "R") {
			if (temp_incCntrDtail == "N") {
				if (cre_cnt_cd == "IN") {
	        		// india office 전용 2012.05.18	
	        	    path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4915.mrd";
				}
				/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
				else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
					path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4919.mrd";
				}
				*/
				else {
				    path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
				}   
			}
			else {
				//if(rhq =="HAMRU"){
	    		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
				if (ofc_cd == "ANRSO" ||ofc_cd == "HAMSC"||ofc_cd == "LEHSC"||ofc_cd == "PRGSC"||ofc_cd == "RTMSC") {
	                path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4911.mrd";	
				}
				else {
					if (cre_cnt_cd == "IN") {
		        		// india office 전용 2012.05.18	
		        	   path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4913.mrd";
					}
					/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
					else if (cre_cnt_cd == "MY" && inv_new_rpt_flg == "Y") {
						path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4917.mrd";
					}
					*/
					else {
					    path = "apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
					}   
				}	
			}
		}
    	
		var ma_param = "jspno=4004"
			 + "&invoice_no=" + ComGetObjValue(formObj.invoiceNo)
			 + "&f_cmd=" + SEARCH01
			 + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd)
			 + "&cond_ida_sac_cd=" + ComGetObjValue(formObj.ida_sac_cd)
			 + "&payer_cd=" + ComGetObjValue(formObj.payer_cd);
		
    	//MASTER DATA 조회
		var sXml =  sheetObj.GetSearchXml("EES_DMT_4003GS.do", ma_param);
		sheetObj.LoadSearchXml(sXml);
		ComEtcDataToForm(formObj, sheetObj);

		//RD 호출
		var rdParm =  "/ruseurlmoniker [0]" + " /rfn [" + RDServerIP + "/EES_DMT_4003_RD.do] "		//DETAIL DATA 조회
					+ " /rv " + rvParmByInvoice(formObj)
					+ " /rpost [jspno=4004&invoice_no=" + ComGetObjValue(formObj.invoiceNo) + "&cre_ofc_cd=" + ComGetObjValue(formObj.issueOfcCd) + "]"		//jspno, invoice_no
					;

		Rdviewer.FileOpen(RD_path+path, rdParm);
		Rdviewer.PrintDialog();
    }  
	
    /**
     * rv By Invoice 
     */ 
    function rvParmByInvoice(formObj){
    	/////////////////////////////////////////////////////////////////////////////////////
		//Address1,Address2,Address3,Address4 쪼개기
		var payrAddrs = ComGetObjValue(formObj.rd_payr_addr);
		var rd_payr_addr01 = "";
		var rd_payr_addr02 = "";
		var rd_payr_addr03 = "";
		var rd_payr_addr04 = "";
		
        var paryInfoAddr = payrAddrs.split("\n");
        var paryInfoAddrCnt = paryInfoAddr.length;
        
        if ( paryInfoAddrCnt >= 1 ) {
        	rd_payr_addr01 = paryInfoAddr[0];
        } else {
        	rd_payr_addr01 = "";
        }
        if ( paryInfoAddrCnt >= 2 ) {
        	rd_payr_addr02 = paryInfoAddr[1];
        } else {
        	rd_payr_addr02 = "";
        }
        if ( paryInfoAddrCnt >= 3 ) {
        	rd_payr_addr03 = paryInfoAddr[2];
        } else {
        	rd_payr_addr03 = "";
        }
        if ( paryInfoAddrCnt >= 4 ) {
        	rd_payr_addr04 = paryInfoAddr[3];
        } else {
        	rd_payr_addr04 = "";
        }
        
        /////////////////////////////////////////////////////////////////////////////////////    	
    	
    	var	rvRaram =" RD_SH_ADDR1[" + ComGetObjValue(formObj.rd_sh_addr1) +"]" +
					" RD_SH_ADDR2[" + ComGetObjValue(formObj.rd_sh_addr2) +"]" +
					" RD_SH_ADDR3[" + ComGetObjValue(formObj.rd_sh_addr3) +"]" +
					" RD_INVOICE_TITLE[" + ComGetObjValue(formObj.rd_invoice_title) +"]" +
					" RD_CANCEL_NOTE[" + ComGetObjValue(formObj.rd_cancel_note) +"]" +
					" RD_CUST_NM[" + ComGetObjValue(formObj.rd_cust_nm) +"]" +
					" RD_PAYR_ADDR01[" + rd_payr_addr01 +"]" +
					" RD_PAYR_ADDR02[" + rd_payr_addr02 +"]" +
					" RD_PAYR_ADDR03[" + rd_payr_addr03 +"]" +
					" RD_PAYR_ADDR04[" + rd_payr_addr04 +"]" +
					" RD_ATTN_NM[" + ComGetObjValue(formObj.rd_attn_nm) +"]" +
					" RD_PHN_NO[" + ComGetObjValue(formObj.rd_phn_no) +"]" +
					" RD_FAX_NO[" + ComGetObjValue(formObj.rd_fax_no) +"]" +
					" RD_DMDT_INV_NO[" + ComGetObjValue(formObj.rd_dmdt_inv_no) +"]" +
					" RD_ISSUE_DAY[" + ComGetObjValue(formObj.rd_issue_day) +"]" +
					" RD_DUE_DATE[" + ComGetObjValue(formObj.rd_due_date) +"]" +
					" RD_DUE_DAY[" + ComGetObjValue(formObj.rd_due_day) +"]" +
					" RD_NTC_KNT_CD[" + ComGetObjValue(formObj.rd_ntc_knt_cd) +"]" +
					" RD_CRE_USR_NM[" + ComGetObjValue(formObj.rd_cre_usr_nm) +"]" +
					" RD_CUST_CD[" + ComGetObjValue(formObj.rd_cust_cd) +"]" +
					" RD_INV_REF_NO[" + ComGetObjValue(formObj.rd_inv_ref_no) +"]" +
					" RD_CUST_VAT_NO[" + ComGetObjValue(formObj.rd_cust_vat_no) +"]" +
					" RD_SH_HD_N1ST_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n1st_msg) +"]" +
					" RD_SH_HD_N2ND_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n2nd_msg) +"]" +
					" RD_SH_HD_N3RD_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n3rd_msg) +"]" +
					" RD_SH_HD_N4TH_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n4th_msg) +"]" +
					" RD_SH_HD_N5TH_MSG[" + ComGetObjValue(formObj.rd_sh_hd_n5th_msg) +"]" +
					" RD_VVD_CD[" + ComGetObjValue(formObj.rd_vvd_cd) +"]" +
					" RD_VSL_ENG_NM[" + ComGetObjValue(formObj.rd_vsl_eng_nm) +"]" +
					" RD_ARR[" + ComGetObjValue(formObj.rd_arr) +"]" +
					" RD_DEP[" + ComGetObjValue(formObj.rd_dep) +"]" +
					" RD_BL_NO[" + ComGetObjValue(formObj.rd_bl_no) +"]" +
					" RD_BKG_NO[" + ComGetObjValue(formObj.rd_bkg_no) +"]" +
					" RD_CMDT_NM[" + ComGetObjValue(formObj.rd_cmdt_nm) +"]" +
					" RD_DMDT_TRF_CD[" + ComGetObjValue(formObj.rd_dmdt_trf_cd) +"]" +
					" RD_DMDT_TRF_NM[" + ComGetObjValue(formObj.rd_dmdt_trf_nm) +"]" +
					" RD_BKG_RCV_TERM_NM[" + ComGetObjValue(formObj.rd_bkg_rcv_term_nm) +"]" +
					" RD_BKG_DEL_TERM_NM[" + ComGetObjValue(formObj.rd_bkg_del_term_nm) +"]" +
					" RD_POD[" + ComGetObjValue(formObj.rd_pod) +"]" +
					" RD_POD_NM[" + ComGetObjValue(formObj.rd_pod_nm) +"]" +
					" RD_DEL[" + ComGetObjValue(formObj.rd_del) +"]" +
					" RD_DEL_NM[" + ComGetObjValue(formObj.rd_del_nm) +"]" +
					" RD_TRUCKER_NM[" + ComGetObjValue(formObj.rd_trucker_nm) +"]" +
					" RD_ORG_CHG_AMT[" + ComGetObjValue(formObj.rd_org_chg_amt) +"]" +
					" RD_ORG_CURR_CD[" + ComGetObjValue(formObj.rd_org_curr_cd) +"]" +
					" RD_INV_XCH_RT[" + ComGetObjValue(formObj.rd_inv_xch_rt) +"]" +
					" RD_TOT_AMT[" + ComGetObjValue(formObj.rd_tot_amt) +"]" +
					" RD_INV_CURR_CD[" + ComGetObjValue(formObj.rd_inv_curr_cd) +"]" +
					" RD_DC_AMT[" + ComGetObjValue(formObj.rd_dc_amt) +"]" +
					" RD_INV_CHG_AMT[" + ComGetObjValue(formObj.rd_inv_chg_amt) +"]" +
					" RD_TAX_RTO[" + ComGetObjValue(formObj.rd_tax_rto) +"]" +
					" RD_TAX_AMT[" + ComGetObjValue(formObj.rd_tax_amt) +"]" +
					" RD_INV_AMT[" + ComGetObjValue(formObj.rd_inv_amt) +"]" +
					" RD_INV_RMK1[" + ComGetObjValue(formObj.rd_inv_rmk1) +"]" +
					" RD_INV_RMK2[" + ComGetObjValue(formObj.rd_inv_rmk2) +"]" +
					" RD_SH_RMK1[" + ComGetObjValue(formObj.rd_sh_rmk1) +"]" +
					" RD_SH_RMK2[" + ComGetObjValue(formObj.rd_sh_rmk2) +"]" +
					" RD_SH_RMK3[" + ComGetObjValue(formObj.rd_sh_rmk3) +"]" +
					" RD_SH_RMK4[" + ComGetObjValue(formObj.rd_sh_rmk4) +"]" +
					" RD_SH_RMK5[" + ComGetObjValue(formObj.rd_sh_rmk5) +"]" +
					" RD_SH_RMK6[" + ComGetObjValue(formObj.rd_sh_rmk6) +"]" +
					" RD_SH_RMK7[" + ComGetObjValue(formObj.rd_sh_rmk7) +"]" +
					" RD_SH_RMK8[" + ComGetObjValue(formObj.rd_sh_rmk8) +"]" +
					" RD_SH_RMK9[" + ComGetObjValue(formObj.rd_sh_rmk9) +"]" +
					" RD_SH_RMK10[" + ComGetObjValue(formObj.rd_sh_rmk10) +"]" +
					" RD_SH_RMK11[" + ComGetObjValue(formObj.rd_sh_rmk11) +"]" +
					" RD_SH_RMK12[" + ComGetObjValue(formObj.rd_sh_rmk12) +"]" +
					" RD_SH_RMK13[" + ComGetObjValue(formObj.rd_sh_rmk13) +"]" +
					" RD_SH_RMK14[" + ComGetObjValue(formObj.rd_sh_rmk14) +"]" +
					" RD_TAX_AMT_PRN_FLG[" + ComGetObjValue(formObj.rd_tax_amt_prn_flg) +"]" +
					" RD_PHN_FAX_PRN_FLG[" + ComGetObjValue(formObj.rd_phn_fax_prn_flg) +"]" +
					" RD_CUST_VAT_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_vat_prn_flg) +"]" +
					" RD_DC_AMT_FLG[" + ComGetObjValue(formObj.rd_dc_amt_flg) +"]" +
					" RD_CUST_REF_PRN_FLG[" + ComGetObjValue(formObj.rd_cust_ref_prn_flg) +"]"+
					" RD_DAYS_DISP[" + ComGetObjValue(formObj.rd_days_disp) +"]" +
					" RD_DMDT_INV_STS_CD[" + ComGetObjValue(formObj.rd_dmdt_inv_sts_cd) +"]" +
					" RD_CRE_CNT_CD[" + ComGetObjValue(formObj.rd_cre_cnt_cd) +"]" +
					" RD_TAX_RGST_NO["          + ComGetObjValue(formObj.rd_tax_rgst_no)          + "]" +
					" RD_SVC_CATE_RMK["         + ComGetObjValue(formObj.rd_svc_cate_rmk)         + "]" +
					" RD_PMNT_ACCT_NO["         + ComGetObjValue(formObj.rd_pmnt_acct_no)         + "]" +
					" RD_IDA_EXPN_TAX_RT["      + ComGetObjValue(formObj.rd_ida_expn_tax_rt)      + "]" +
					" RD_IDA_EXPN_TAX["         + ComGetObjValue(formObj.rd_ida_expn_tax)         + "]" +
					" RD_IDA_EDU_TAX_RT["       + ComGetObjValue(formObj.rd_ida_edu_tax_rt)       + "]" +
					" RD_IDA_EDU_TAX["          + ComGetObjValue(formObj.rd_ida_edu_tax)          + "]" +
					" RD_IDA_HIGH_EDU_TAX_RT["  + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)  + "]" +
					" RD_IDA_HIGH_EDU_TAX["     + ComGetObjValue(formObj.rd_ida_high_edu_tax)     + "]" +
					// SBC ( Swacha Bharat Cess )
					" RD_IDA_LOCL_TAX_RT["      + ComGetObjValue(formObj.rd_ida_locl_tax_rt)      + "]" +
					" RD_IDA_LOCL_TAX["         + ComGetObjValue(formObj.rd_ida_locl_tax)         + "]" +
					// KCC ( Krishi Kalyan Cess )
					" RD_IDA_N2ND_LOCL_TAX_RT[" + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax_rt) + "]" +
					" RD_IDA_N2ND_LOCL_TAX["    + ComGetObjValue(formObj.rd_ida_n2nd_locl_tax)    + "]" +
					" RD_IDA_TAX_APPL_TM["      + ComGetObjValue(formObj.rd_ida_tax_appl_tm)      + "]" + 
					" RD_IDA_CGST_RTO["         + ComGetObjValue(formObj.rd_ida_cgst_rto)         + "]" + 
					" RD_IDA_CGST_AMT["         + ComGetObjValue(formObj.rd_ida_cgst_amt)         + "]" + 
					" RD_IDA_SGST_RTO["         + ComGetObjValue(formObj.rd_ida_sgst_rto)         + "]" + 
					" RD_IDA_SGST_AMT["         + ComGetObjValue(formObj.rd_ida_sgst_amt)         + "]" + 
					" RD_IDA_IGST_RTO["         + ComGetObjValue(formObj.rd_ida_igst_rto)         + "]" + 
					" RD_IDA_IGST_AMT["         + ComGetObjValue(formObj.rd_ida_igst_amt)         + "]" + 
					" RD_IDA_UGST_RTO["         + ComGetObjValue(formObj.rd_ida_ugst_rto)         + "]" + 
					" RD_IDA_UGST_AMT["         + ComGetObjValue(formObj.rd_ida_ugst_amt)         + "]" +
					" RD_BANK_ACCT_NO["         + ComGetObjValue(formObj.rd_ida_bank_acct_no)     + "]" +
					" RD_BANK_IFSC_CD["         + ComGetObjValue(formObj.rd_ida_bank_ifsc_cd)     + "]" +
					" RD_IDA_GST_RGST_NO["      + ComGetObjValue(formObj.rd_ida_gst_rgst_no)      + "]" +
					" RD_IDA_STE_CD["           + ComGetObjValue(formObj.rd_ida_ste_cd)           + "]" +
					" RD_IDA_STE_NM["           + ComGetObjValue(formObj.rd_ida_ste_nm)           + "]" +
					" RD_IDA_SAC_CD["           + ComGetObjValue(formObj.rd_ida_sac_cd)           + "]" +
					" RD_IDA_TAX_CIN["          + ComGetObjValue(formObj.rd_ida_tax_cin)          + "]" + 
					" RD_IDA_OFC_STE_CD["       + ComGetObjValue(formObj.rd_ida_ofc_ste_cd)       + "]" +
					" RD_IDA_OFC_STE_NM["       + ComGetObjValue(formObj.rd_ida_ofc_ste_nm)       + "]";
		
    	return rvRaram;
    }       
    
   /**
    * C.Remark, H.Remark 버튼 클릭시 실행해야할 동작을 정의하는 함수
    */
    function showRemarkMessage(srcName) {
    	var formObj = document.form;

		if (srcName == "btn_cremark") {
			
			var cancel_rmk	= ComGetObjValue(formObj.cxl_rmk);		//cancel_remark
			var cancel_date	= ComGetObjValue(formObj.upd_dt);		//update_dt
			var ofc_cd 		= ComGetObjValue(formObj.upd_ofc_cd);	//update_ofc_cd
			var usr_id 		= ComGetObjValue(formObj.upd_usr_id);	//update_usr_id
			var usr_name 	= ComGetObjValue(formObj.upd_usr_nm);	//update_usr_nm
			var msg 		= cancel_rmk
							+ "\n\nCancel Date: " + cancel_date
							+ "\nOffice: " + ofc_cd
							+ "\nUser ID: " + usr_id
							+ "\nUser Name: " + usr_name;
		}
		else if (srcName == "btn_hremark") {

			var hold_rmk	= ComGetObjValue(formObj.inv_hld_rmk);	//hold_remark
			var hold_date	= ComGetObjValue(formObj.arIfDate);		//ar_if_dt
			var ofc_cd 		= ComGetObjValue(formObj.arIfOfc);		//ar_if_ofc_cd
			var usr_id 		= ComGetObjValue(formObj.arIfId);		//ar_if_usr_id
			var usr_name 	= ComGetObjValue(formObj.arIfName);		//ar_if_usr_nm
			var msg 		= hold_rmk
							+ "\n\nHold Date: " + hold_date
							+ "\nOffice: " + ofc_cd
							+ "\nUser ID: " + usr_id
							+ "\nUser Name: " + usr_name;
		}
		ComShowMessage(msg);
    }
    
    /**
     * Charge Currency 가 변경될 경우 수행해야될 동작을 정의하는 함수 
     */
    function changeChargeCurrency() {
    	var formObj 	= document.form;
    	
    	if (ComGetObjValue(formObj.chg_curr_cd) != "" && ComGetObjValue(formObj.inv_curr_cd) != "") {
    		//1.EX. RATE 를 구한다.
    		searchExRate();
    		
    		//2.계산을 수행한다.
    		//==============================================================================================================
    		// 아래 DmtComCalcInvAmtByTaxAmt 함수에서 어떤 계산방식으로 처리할지를 구분해주는 구분자 값을 설정해줍니다.
    		DmtComCalcInvAmtByTaxAmt();
    		//==============================================================================================================
    	}
    }

     /**
      * Charge Currency 가 변경될 경우 수행해야될 동작을 정의하는 함수 
      */
    function setDataFormat(sVal, sType) {

    	if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

    	if (sType != undefined) {
    		switch(sType) {
    			case "AMT":
    				sVal = ComAddComma2(sVal + "", "#,###.00");
    				break;
    				
    			case "EX_RATE":
    				sVal = parseFloat(sVal).toFixed(6);
    				break;
    		}
    	}
    	return sVal;
    }
    
  /**
   * VVD, POR, POL, POD, DEL 입력시 체크해야할 내용들을 처리하는 함수 
   */
    function checkValidation() {
    	var formObj 	= document.form;
    	var sheetObj 	= sheetObjects[0];
    	var obj 		= event.srcElement;
    	
    	//1.POR, POL, POD, DEL 이벤트 발생시 공통적으로 유효성 Location 인지를 체크한다.
    	if (obj.name == "por_cd" || obj.name == "pol_cd" || obj.name == "pod_cd" || obj.name == "del_cd") {
    		
    		//입력이 5 자리가 되어야만이 체크를 수행한다.
    		if (obj.value.length != 5) return;
    		
        	//1.조회를 위한 매개변수를 설정한다.
        	ComSetObjValue(formObj.loc_cd, obj.value);
        	
        	//2.인자로 받은 Location Code 가 적합한지를 조회한다.
        	doActionIBCommon(sheetObj,formObj,IBSEARCH_LOC,COMMAND07);
        	
        	//3.조회 결과 반환
    		if (ComGetObjValue(formObj.result) != "Y") {
    			ComShowCodeMessage("DMT00110", "Location");
    			ComClearObject(obj);
    			ComSetFocus(obj);
    			return;
    		}
    	}
    	
    	//2.VVD 이벤트 발생시 CALLING PORT 체크
    	if (obj.name == "vvd_cd" || obj.name == "pol_cd" || obj.name == "pod_cd") {

    		//입력이 9 자리가 되어야만이 체크를 수행한다.
    		if (obj.name == "vvd_cd") {
    			if (obj.value.length != 9) return;
    			
        		//입력한 VVD CD 가 유효한 값인지 체크한다.
    			if (!validateVVD()) {
    				ComShowCodeMessage("DMT00165", "VVD CD");
    				ComClearObject(obj);
    				ComSetFocus(obj);
    				return;
    			}
    		}

    		//CALLING PORT 체크
			if (isCanCheckCallingPort() && !validateCallPort()) {
				ComClearObject(obj);
				ComSetFocus(obj);
				return;
			}    		
    	}
    	
    	//VVD CD 가 변경될 경우에는 Ex. Rate 를 구하고, 계산을 수행한다.
    	if (obj.name == "vvd_cd") {
    		//3-1.Ex. Rate 를 구한다.
    		searchExRate();
    		
    		//3-2.계산을 수행한다.
    		//==============================================================================================================
    		// 아래 DmtComCalcInvAmtByTaxAmt 함수에서 어떤 계산방식으로 처리할지를 구분해주는 구분자 값을 설정해줍니다.
    		DmtComCalcInvAmtByTaxAmt();
    		//==============================================================================================================
    	}
    	//POR, POL, POD, DEL 이 변경될 경우에는 Charge Currency 를 재조회하고 난 후, Ex. Rate 를 구하고, 계산을 수행한다. 
    	else {
    		searchChargeCurrency();
    	}
    }
    
   /**
 	* Payer 정보가 Clear 될 경우 Attention 정보도 Clear 시켜주는 함수
    */	
	function clearAttention(){
		var formObj = document.form;
		var cboAttention = comboObjects[1];
		
		cboAttention.RemoveAll();
    	ComClearObject(formObj.payr_cntc_pnt_phn_no);
    	ComClearObject(formObj.payr_cntc_pnt_eml);
    	ComClearObject(formObj.payr_cntc_pnt_eml);
	}

 	/**
 	 * To DT 와 F/T End 사이의 잘못된 값이 입력될 경우(OverDay 가 1 미만이 될 경우) 
 	 * Rate Detail 의 모든 항목을 삭제하고 1 Row 만 새로 생성해주는 함수
 	 */
    function initRateDetail() {
    	var sheetCHGObj = sheetObjects[0];
    	var sheetRTObj  = sheetObjects[1];
    	
    	//1.Charge 에 포함된 Rate 항목이 1개를 초과할 경우에는 1개만 남기고 모두 삭제한다.
    	var rateRowCount = fetchRateRowCountOfCharge();
    	
    	if (rateRowCount > 1) {
	    	with(sheetCHGObj) {
				var invNo 	= CellValue(SelectRow, INV_NO);
				var dtlSeq 	= CellValue(SelectRow, INV_DTL_SEQ);
				var ofcCd 	= CellValue(SelectRow, CRE_OFC_CD);
	    	}
	    	
			with(sheetRTObj) {
				for (var row = LastRow ; row >= HeaderRows ; row--) {
					if (	RowStatus(row) != "D"
						&&	invNo 	== CellValue(row, INV_NO)
						&&	dtlSeq 	== CellValue(row, INV_DTL_SEQ)
						&& 	ofcCd 	== CellValue(row, CRE_OFC_CD)	) {		
						
						//항목이 1 개만 남았다면 삭제하지 않는다.
						if (rateRowCount > 1) {
							if (RowStatus(row) == "I") {
								RowDelete(row, false);
							}
							else {
								RowStatus(row) = "D";
								RowHidden(row) = true;	
							}
						}
						rateRowCount--;
					}
				}
			}
    	}
    	
    	//2.Over Day 를 Clear 시켜준다.
    	var rateFirstRow = fetchRateFirstRowOfCharge();
    	with(sheetRTObj) {
    		CellValue2(rateFirstRow, FT_UND_DYS) 	 = "";
    		CellValue2(rateFirstRow, RT_OVR_DYS) 	 = "";
    		CellValue2(rateFirstRow, RT_OVR_CHG_AMT) = "";
    	}
 	 }
 	 
 	/**
 	 * PayerInfo 팝업화면에서 변경시 자동변경 처리됨
 	 */
 	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
 		var formObj 		= document.form;
 		var cboAttention 	= comboObjects[1];
 		
 		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
 		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
 		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
 		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
 		
		// Payer 의 Attention 정보를 초기화해 줍니다.
		DmtComInitPayerAttention();
 	}
 	 
     function dmtGetMsgText(xmlStr){
         try {
             var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
             xmlDoc.loadXML(xmlStr);

             var xmlRoot = xmlDoc.documentElement;
             if(xmlRoot == null) return;

             var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
             if(msgNode == null) 
              return;
             else
              return msgNode.firstChild.nodeValue;
        } catch(err) { ComFuncErrMsg(err.message); }
     }
    
     
   /*
    * 화면의 모든 컨트롤들의 깜빡 거리는 현상을 해결하기 위해서 일괄적으로 모든 컨트롤들을 비활성화 시키는 함수
    */
    function disableControls() {
    	var formObj = document.form;
    	
	    with(formObj) {
	    	ComEnableManyObjects(false, invoiceNo, issueDate, issueOfcCd, issueName, status);
	    	invoiceNo.className		= "input2";
	    	issueDate.className		= "input2";
	    	issueOfcCd.className	= "input2";
	    	issueName.className		= "input2";
	    	status.className		= "input2";
	    	
	    	ComEnableManyObjects(false, vvd_cd, por_cd, pol_cd, pod_cd, del_cd, rcvTermCd, deTermCd);
	    	vvd_cd.className 		= "input2";
	    	por_cd.className 		= "input2";
	    	pol_cd.className 		= "input2";
	    	pod_cd.className 		= "input2";
	    	del_cd.className 		= "input2";
			rcvTermCd.className 	= "input2";
			deTermCd.className 		= "input2";
			
			ComEnableManyObjects(false, bkg_cust_cd, bkg_cust_nm, act_cust_cd, act_cust_nm, payer_cd, payer_nm);
			bkg_cust_cd.className 	= "input2";
			bkg_cust_nm.className 	= "input2";
			act_cust_cd.className 	= "input2";
			act_cust_nm.className 	= "input2";
			payer_cd.className 		= "input2";
			payer_nm.className 		= "input2";
			
			ComEnableManyObjects(false, payr_cntc_pnt_phn_no, payr_cntc_pnt_fax_no, payr_cntc_pnt_eml, trucker_cd, trucker_nm, dueDate, creditTerm);
			payr_cntc_pnt_phn_no.className 	= "input2";
			payr_cntc_pnt_fax_no.className 	= "input2";
			payr_cntc_pnt_eml.className 	= "input2";
			trucker_cd.className 			= "input2";
			trucker_nm.className 			= "input2";
			dueDate.className 				= "input2";
			creditTerm.className 			= "input2";
			
			ComEnableManyObjects(false, inv_rmk1, inv_rmk2);
			inv_rmk1.className = "input2";
			inv_rmk2.className = "input2";
			
	    }
    }
    
    /**
     * 두 날짜의 차이를 구하는 함수
     */    
    function retrieveDaysBetween(fromDt, toDt) {
        var formObj		= document.form;
    	var sheetObj	= sheetObjects[2];
    	
    	ComSetObjValue(formObj.from_dt, fromDt);
    	ComSetObjValue(formObj.to_dt,   toDt);
    	
    	doActionIBCommon(sheetObj, formObj, IBSEARCH_DYS_BETWEEN, COMMAND18);
    	
    	return ComGetObjValue(formObj.ovr_dys);
    }
     
    /**
     * Incl. Cntr Detail 선택여부에 따라서 Bil Amt 금액을 설정해준다.
     */       
    function getBillAmtByIncCntrDtail() {
    	var formObj = document.form;
    	var bilAmt  = 0;
    	
    	if (ComGetObjValue(formObj.incCntrDtail) == "Y") {
    		bilAmt = ComGetUnMaskedValue(ComGetObjValue(formObj.mn_bil_amt), "float");
    	}
    	else {
    		bilAmt = ComGetUnMaskedValue(ComGetObjValue(formObj.tot_amt),    "float");
    	}

    	return bilAmt;
    }    
	/**
	 * 평균값 구하기 
	 */
	function getCalcAvg(nCalcVal, nSize, nDigit){
		var nAvgVal = nCalcVal / nSize;
		nAvgVal = Math.floor(nAvgVal / Math.pow(10, nDigit)) * Math.pow(10, nDigit);	
		return DMTtrimCurrencyAmount(ComGetObjValue(document.form.inv_curr_cd),nAvgVal);
	}

	function payCdValidation (){

		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var cboTariff = comboObjects[0];

		ComSetObjValue(formObj.s_cust_cd, "");
		ComSetObjValue(formObj.s_cust_gubun, "");

		var payerCd = ComTrim(ComGetObjValue(formObj.payer_cd));
		if (payerCd == "") {
			ComClearObject(formObj.payer_nm);
			clearAttention();
			return false;
		}

		var cre_cnt_cd = ComTrim(ComGetObjValue(formObj.status)) != "" ? ComGetObjValue(formObj.cre_cnt_cd) : ComGetObjValue(formObj.usr_cnt_cd);

		//입력한 Payer 가 Vendor 일 경우
		if (ComIsNumber(payerCd)) {
			//미주 일 경우 service provider는 Detention 만 가능하게 함
			if (cre_cnt_cd == "US" && cboTariff.Text.substring(1, 2) == "T") {
				ComSetObjValue(formObj.s_cust_gubun, "1");
			}
			else {
				ComShowCodeMessage("DMT00165", "Payer");
				ComClearObject(formObj.payer_cd);
				ComClearObject(formObj.payer_nm);
				clearAttention();
				ComSetFocus(formObj.payer_cd);
				return false;
			}
			
		}
		//입력한 Payer 가 Customer 일 경우
		else if (payerCd.length > 2) {
			var cntCd = payerCd.substring(0, 2);
			if (ComIsAlphabet(cntCd)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
			}
		}
		//정상적인 Payer Code 가 아닐경우
		if (ComGetObjValue(formObj.s_cust_gubun) == "") {
			ComShowCodeMessage("DMT00165", "Payer");
			ComClearObject(formObj.payer_cd);
			ComClearObject(formObj.payer_nm);
			clearAttention();
			ComSetFocus(formObj.payer_cd);
			return false;
		}

		ComSetObjValue(formObj.s_cust_cd, payerCd);

		ComSetObjValue(formObj.f_cmd, SEARCH20);

		var sXml 	= sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		
		//해당 Payer 가 존재하지 않는다면.
		var resPayerCd = setDataFormat(ComGetEtcData(sXml, "PAYER_CODE"));
		var resPayerNm = setDataFormat(ComGetEtcData(sXml, "PAYER_NM"));

		var lgs_flg = ComGetEtcData(sXml, "LGS_FLG");
		var nmd_cust_flg = ComGetEtcData(sXml, "NMD_CUST_FLG");
		
		if (resPayerCd == "") {
			ComShowCodeMessage("DMT00165", "Payer");
			clearAttention();
			return false;
		}
		if ( lgs_flg == "N" ){
			ComShowCodeMessage("DMT01183");
			clearAttention();
			ComClearObject(formObj.payer_cd);
			ComClearObject(formObj.payer_nm);
			clearAttention();
			ComSetFocus(formObj.payer_cd);
			return false;
		}
		if ( nmd_cust_flg == "Y" ){
			ComShowCodeMessage("DMT02002", "Payer Code - Named Customer");
			clearAttention();
			ComClearObject(formObj.payer_cd);
			ComClearObject(formObj.payer_nm);
			clearAttention();
			ComSetFocus(formObj.payer_cd);
			return false;
		}
		ComSetObjValue(formObj.payer_cd, resPayerCd);
		ComSetObjValue(formObj.payer_nm, resPayerNm);

		return true;
	}
	
	/*
	 * 조회결과로 화면 버튼컴포넌트의 상태를 제어합니다.
	 */
	function controlScreen(objname) {
		var formObj = document.form;
		
		// 화면 Loading 및 New 버튼 클릭시
		if (objname == 'init') {
			// 입력데이터 삭제
			controlInputDataByInit();
			// 입력항목 제어
			controlInputByInit();
			// 버튼 제어
			controlButtonByInit();
	    	//BKG No. 에 포커스를 준다.
	    	ComSetFocus(formObj.bkgNo);			
		}
		// Data Display 버튼 클릭시
		else if (objname == 'display') {
			// 입력항목 제어
			controlInputByDisplay();
			// 버튼 제어
			controlButtonByDisplay();
		}
		// Invoice No. 로 조회실행시
		else {
			// 입력항목 제어
			controlInput();
			// 버튼 제어
			controlButton();
		}
	}
	
	function controlInputDataByInit() {
		var formObj = document.form;
		
		// 모든 Sheet 의 정보를 Clear 시킨다.
		for (i=0; i<sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}
		
		// Invoice No.
		ComClearObject(formObj.invoiceNo);
		// Issue Date
		ComClearObject(formObj.issueDate);
		// Issue OFC
		ComClearObject(formObj.issueOfcCd);
		// Issue Name
		ComClearObject(formObj.issueName);
		// Status
		ComClearObject(formObj.status);
		// A/R I/F
		ComClearObject(formObj.dmdt_ar_if_cd);
		// A/R I/F Date
		ComClearObject(formObj.arIfDate);
		// A/R I/F OFC
		ComClearObject(formObj.arIfOfc);
		// A/R I/F Name		
		ComClearObject(formObj.arIfName);
		// Credit Note No.
		ComClearObject(formObj.creditNote);
		// Credit Note A/R Y/N
		ComClearObject(formObj.creditNoteArIf);
		// BKG No.
		ComClearObject(formObj.bkgNo);
		// BL No.
		ComClearObject(formObj.blNo);
		// Tariff Type
		comboObjects[0].Text = "";
		// Incl. CNTR Detail
		ComSetObjValue(formObj.incCntrDtail, "Y");
		// VVD CD
		ComClearObject(formObj.vvd_cd);
		// POR
		ComClearObject(formObj.por_cd);
		// POL
		ComClearObject(formObj.pol_cd);
		// POD
		ComClearObject(formObj.pod_cd);
		// DEL
		ComClearObject(formObj.del_cd);
		// R/D
		formObj.rcvTermCd.selectedIndex = -1;
		formObj.deTermCd.selectedIndex 	= -1;
		// BKG Cust
		ComClearObject(formObj.bkg_cust_cd);
		ComClearObject(formObj.bkg_cust_nm);
		// A/R Cust
		ComClearObject(formObj.act_cust_cd);
		ComClearObject(formObj.act_cust_nm);
		// Payer
		ComClearObject(formObj.payer_cd);
		ComClearObject(formObj.payer_nm);		
		// Attention
		comboObjects[1].RemoveAll();
		// Tel.
		ComClearObject(formObj.payr_cntc_pnt_phn_no);
		// Fax
		ComClearObject(formObj.payr_cntc_pnt_fax_no);
		// E-mail
		ComClearObject(formObj.payr_cntc_pnt_eml);
		// Trucker
		ComClearObject(formObj.trucker_cd);
		ComClearObject(formObj.trucker_nm);
		// Invoice Remark(s)
		ComClearObject(formObj.inv_rmk1);
		ComClearObject(formObj.inv_rmk2);
		// Due Date
		ComClearObject(formObj.dueDate);
		// Credit Term
		ComClearObject(formObj.creditTerm);
		// Notice
		ComSetObjValue(formObj.notice, "");
		// INV Over Day
		ComClearObject(formObj.invoiceOverDay);
		// Cust. Ref
		ComClearObject(formObj.custRef);
		// Charge Cur.
		ComClearCombo(formObj.chg_curr_cd);
		// Billable AMT
		ComClearObject(formObj.inv_amt);
		// INV Cur.
		// Ex. Rate
		ComClearObject(formObj.inv_xch_rt);
		// CNTR Q'ty
		ComClearObject(formObj.cntrQty);
		// Total AMT
		ComClearObject(formObj.tot_amt);
		// D/C by AMT or %
		ComClearObject(formObj.dc_amt);
		// Billing AMT
		ComClearObject(formObj.inv_chg_amt);
		// Tax Rate/AMT
		formObj.chk_tax.checked = false;
		ComClearObject(formObj.tax_rto_dis);
		ComClearObject(formObj.tax_amt);
		// Payable AMT
		ComClearObject(formObj.inv_amt);
		// Reason
		formObj.reason.selectedIndex = -1;
		// Remark(s)
		ComSetObjValue(formObj.remark, "");
	}
	
	function controlInputByInit() {
		var formObj = document.form;
		
		//==============================
		// 항목 Enable 상태로 변경
		//==============================		
		var bEnable = true;
		//==============================
		
		// BKG No.
		DmtComEnableObject(formObj.bkgNo, bEnable);
		// BL No.
		DmtComEnableObject(formObj.blNo, bEnable);
		// Tariff Type
		comboObjects[0].Enable = bEnable;
		// Incl. CNTR Detail
		DmtComEnableObject(formObj.incCntrDtail, bEnable);
		
		//==============================
		// 항목 Disable 상태로 변경
		//==============================		
		var bEnable = false;
		//==============================		
		
		// Invoice No.
		DmtComEnableObject(formObj.invoiceNo, bEnable);
		// Issue Date
		DmtComEnableObject(formObj.issueDate, bEnable);
		// Issue OFC
		DmtComEnableObject(formObj.issueOfcCd, bEnable);		
		// Issue Name
		DmtComEnableObject(formObj.issueName, bEnable);
		// Status
		DmtComEnableObject(formObj.status, bEnable);
		// A/R I/F
		DmtComEnableObject(formObj.dmdt_ar_if_cd, bEnable);
		// A/R I/F Date
		DmtComEnableObject(formObj.arIfDate, bEnable);
		// A/R I/F OFC
		DmtComEnableObject(formObj.arIfOfc, bEnable);
		// A/R I/F Name		
		DmtComEnableObject(formObj.arIfName, bEnable);
		// Credit Note No.
		DmtComEnableObject(formObj.creditNote, bEnable);
		// Credit Note A/R Y/N
		DmtComEnableObject(formObj.creditNoteArIf, bEnable);
		// VVD CD
		DmtComEnableObject(formObj.vvd_cd, bEnable);
		// POR
		DmtComEnableObject(formObj.por_cd, bEnable);
		// POL
		DmtComEnableObject(formObj.pol_cd, bEnable);
		// POD
		DmtComEnableObject(formObj.pod_cd, bEnable);
		// DEL
		DmtComEnableObject(formObj.del_cd, bEnable);
		// R/D
		DmtComEnableObject(formObj.rcvTermCd, bEnable);
		DmtComEnableObject(formObj.deTermCd, bEnable);
		// BKG Cust
		DmtComEnableObject(formObj.bkg_cust_cd, bEnable);
		DmtComEnableObject(formObj.bkg_cust_nm, bEnable);
		// A/R Cust
		DmtComEnableObject(formObj.act_cust_cd, bEnable);
		DmtComEnableObject(formObj.act_cust_nm, bEnable);
		// Payer
		DmtComEnableObject(formObj.payer_cd, bEnable);
		DmtComEnableObject(formObj.payer_nm, bEnable);	
		// Attention
		comboObjects[1].Enable = bEnable;
		// Tel.
		DmtComEnableObject(formObj.payr_cntc_pnt_phn_no, bEnable);	
		// Fax
		DmtComEnableObject(formObj.payr_cntc_pnt_fax_no, bEnable);	
		// E-mail
		DmtComEnableObject(formObj.payr_cntc_pnt_eml, bEnable);	
		// Trucker
		DmtComEnableObject(formObj.trucker_cd, bEnable);	
		DmtComEnableObject(formObj.trucker_nm, bEnable);	
		// Invoice Remark(s)
		DmtComEnableObject(formObj.inv_rmk1, bEnable);	
		DmtComEnableObject(formObj.inv_rmk2, bEnable);	
		// Due Date
		DmtComEnableObject(formObj.dueDate, bEnable);	
		// Credit Term
		DmtComEnableObject(formObj.creditTerm, bEnable);
		// Notice
		DmtComEnableObject(formObj.notice, bEnable);
		// INV Over Day
		DmtComEnableObject(formObj.invoiceOverDay, bEnable);
		// Cust. Ref
		DmtComEnableObject(formObj.custRef, bEnable);
		// Charge Cur.
		DmtComEnableObject(formObj.chg_curr_cd, bEnable);
		// Billable AMT
		DmtComEnableObject(formObj.inv_amt, bEnable);
		// INV Cur.
		DmtComEnableObject(formObj.inv_curr_cd, bEnable);
		// Ex. Rate
		DmtComEnableObject(formObj.inv_xch_rt, bEnable);
		// CNTR Q'ty
		DmtComEnableObject(formObj.cntrQty, bEnable);
		// Total AMT
		DmtComEnableObject(formObj.tot_amt, bEnable);
		// D/C by AMT or %
		DmtComEnableObject(formObj.dc_amt, bEnable);
		// Billing AMT
		DmtComEnableObject(formObj.inv_chg_amt, bEnable);
		// Tax Rate/AMT
		DmtComEnableObject(formObj.chk_tax, bEnable);
		DmtComEnableObject(formObj.tax_amt, bEnable);
		// Payable AMT
		DmtComEnableObject(formObj.inv_amt, bEnable);
		// Reason
		DmtComEnableObject(formObj.reason, bEnable);
		// Remark(s)
		DmtComEnableObject(formObj.remark, bEnable);
		
		// [ CSS 설정 ] input : 선택입력, input1 : 필수입력, input2 : 비활성화, noinput : 테두리없는 선택입력, noinput2 : 테두리없는 비활성화
		formObj.bkgNo.className        = "input1";
		formObj.blNo.className         = "input1";
		formObj.incCntrDtail.className = "input1";
		
		formObj.vvd_cd.className        = "input2";
		formObj.por_cd.className        = "input2";
		formObj.pol_cd.className        = "input2";
		formObj.pod_cd.className        = "input2";
		formObj.del_cd.className        = "input2";
		formObj.rcvTermCd.className     = "input2";
		formObj.deTermCd.className      = "input2";
		formObj.payer_cd.className      = "input2";
		formObj.inv_curr_cd.className   = "input2";		
		
		formObj.inv_rmk1.className     = "noinput2";
		formObj.inv_rmk2.className     = "noinput2";
		formObj.tot_amt.className      = "noinput2";
		formObj.dc_amt.className       = "noinput2";
		formObj.inv_chg_amt.className  = "noinput2";
		formObj.tax_amt.className      = "noinput2";
		formObj.inv_amt.className      = "noinput2";
		formObj.reason.className       = "input2";
	}
	
	function controlButtonByInit() {
		
    	//Charge Grid 의 메뉴버튼 비활성화
    	enableBtnCharge(false);
    	
       	// Data Display 버튼의 초기상태 설정
    	ComBtnEnable("btn_display");
       	//Sheet Set 버튼의 초기상태 설정
    	ComBtnEnable("btn_set");
    	//Sheet Option 버튼의 초기상태 설정
    	ComBtnEnable("btn_option");
    	//Sending History 버튼의 초기상태 설정
    	ComBtnDisable("btn_sendinghistory");
    	//C.Remark 버튼의 초기상태 설정
    	ComBtnDisable("btn_cremark");
    	//H.Remark 버튼의 초기상태 설정
    	ComBtnDisable("btn_hremark");
    	//New 버튼의 초기상태 설정
    	ComBtnEnable("btn_new");
    	//Save 버튼의 초기상태 설정
    	ComBtnDisable("btn_save");
    	//Cancel 버튼의 초기상태 설정
    	ComBtnDisable("btn_cancel");
    	//Preview 버튼의 초기상태 설정
    	ComBtnDisable("btn_preview");
    	//INV Print 버튼의 초기상태 설정
    	ComBtnDisable("btn_print");
    	//Fax Send 버튼의 초기상태 설정
    	ComBtnDisable("btn_fax");
    	//E-mail Send 버튼의 초기상태 설정
    	ComBtnDisable("btn_email");
    	//Payer Ifno + Fax/Email 버튼의 초기상태 설정
    	ComBtnEnable("btn_payer");
    	//A/R I/F 버튼의 초기상태 설정
    	ComBtnDisable("btn_arif");    	
	}	
	
	/*
	 * 조회결과로 화면 입력컴포넌트의 상태를 제어합니다.
	 */	
	function controlInputByDisplay() {
		var formObj = document.form;
		
		//==============================
		// 항목 Disabled 상태로 변경
		//==============================		
		var bEnable = false;
		//==============================
		
		// BKG No.
		DmtComEnableObject(formObj.bkgNo, bEnable);
		// B/L No.
		DmtComEnableObject(formObj.blNo, bEnable);		
		// Tariff Type
		comboObjects[0].Enable = bEnable;
		// Incl.CNTR Detail
		DmtComEnableObject(formObj.incCntrDtail, bEnable);
		
		//==============================
		// 항목 Enabled 상태로 변경
		//==============================
		bEnable = true;
		//==============================
		
		// VVD CD
		DmtComEnableObject(formObj.vvd_cd, bEnable);
		// POR
		DmtComEnableObject(formObj.por_cd, bEnable);
		// POL
		DmtComEnableObject(formObj.pol_cd, bEnable);
		// POD
		DmtComEnableObject(formObj.pod_cd, bEnable);
		// DEL
		DmtComEnableObject(formObj.del_cd, bEnable);
		// R/DEL
		DmtComEnableObject(formObj.rcvTermCd, bEnable);
		DmtComEnableObject(formObj.deTermCd, bEnable);
		// Payer
		DmtComEnableObject(formObj.payer_cd,     bEnable);
		DmtComEnableObject(formObj.btn_payer_cd, bEnable);
		// Notice
		DmtComEnableObject(formObj.notice, bEnable);
		// Cust. Ref
		DmtComEnableObject(formObj.custRef, bEnable);
		// INV Cur.
		DmtComEnableObject(formObj.inv_curr_cd, bEnable);
		// Reason
		DmtComEnableObject(formObj.reason, bEnable);
		// Remark(s)
		DmtComEnableObject(formObj.remark, bEnable);
		
		var usrCntCd = ComGetObjValue(formObj.invoice_issue) == "2" ? ComGetObjValue(formObj.cre_cnt_cd) : ComGetObjValue(formObj.usr_cnt_cd);		
		if (usrCntCd != "IN") DmtComEnableObject(formObj.chk_tax, bEnable); 		

		// [ CSS 설정 ] input : 선택입력, input1 : 필수입력, input2 : 비활성화, noinput : 테두리없는 선택입력, noinput2 : 테두리없는 비활성화
		formObj.bkgNo.className        = "input2";
		formObj.blNo.className         = "input2";
		formObj.incCntrDtail.className = "input2";
		formObj.vvd_cd.className       = "input1";
		formObj.pol_cd.className       = "input1";
		formObj.pod_cd.className       = "input";
		formObj.del_cd.className       = "input";
		formObj.rcvTermCd.className    = "input";
		formObj.deTermCd.className     = "input";
		formObj.payer_cd.className     = "input1";
		formObj.inv_curr_cd.className  = "input1";
		formObj.inv_chg_amt.className  = "noinput2";
		formObj.chk_tax.className      = "noinput2";
		formObj.tax_rto_dis.className  = "noinput2";
		formObj.tax_amt.className      = "noinput2";
		formObj.inv_amt.className      = "noinput2";
		formObj.reason.className       = "input1";

		//[ Incl. CNTR Detail 선택여부에 따라 영향을 받는 항목들에 대한 설정 ]***********************************
		var incCntrDtlYn = ComGetObjValue(formObj.incCntrDtail);
		bEnable = incCntrDtlYn == "Y" ? bEnable : !bEnable;
		
		// Attention
		comboObjects[1].Enable = bEnable;
		
		// Trucker
		DmtComEnableObject(formObj.trucker_cd,     bEnable);
		DmtComEnableObject(formObj.btn_trucker_cd, bEnable);
		
		// Invoie remark
		DmtComEnableObject(formObj.inv_rmk1, bEnable);
		DmtComEnableObject(formObj.inv_rmk2, bEnable);
		
		// Charge Cur.
		DmtComEnableObject(formObj.chg_curr_cd, bEnable);	

		// Total AMT
		DmtComEnableObject(formObj.tot_amt, !bEnable);
		// D/C by AMT or %
		DmtComEnableObject(formObj.dc_amt, bEnable);
		
		// [ CSS 설정 ] input : 선택입력, input1 : 필수입력, input2 : 비활성화, noinput : 테두리없는 선택입력, noinput2 : 테두리없는 비활성화
		formObj.por_cd.className      = bEnable  ? "input1"   : "input";
		formObj.trucker_cd.className  = bEnable  ? "input"    : "input2";
		formObj.notice.className      = bEnable  ? "input"    : "input2";
		formObj.custRef.className     = bEnable  ? "input"    : "input2";
		formObj.inv_rmk1.className    = bEnable  ? "noinput"  : "noinput2"; 
		formObj.inv_rmk2.className    = bEnable  ? "noinput"  : "noinput2";
		formObj.chg_curr_cd.className = bEnable  ? "input1"   : "input2";
		formObj.tot_amt.className     = bEnable  ? "noinput2" : "noinput1";
		formObj.dc_amt.className      = bEnable  ? "noinput"  : "noinput2"; 
		//********************************************************************************************************
	}
	
	function controlButtonByDisplay() {
		var formObj = document.form;
		
		var incCntrDtlYn = ComGetObjValue(formObj.incCntrDtail);
		var bEnable = incCntrDtlYn == "Y";
		
     	// Save 버튼 활성화
     	ComBtnEnable("btn_save");
     	
     	// Display 버튼 비활성화
     	ComBtnDisable("btn_display");
     	
		// Charge 관리버튼
		enableBtnCharge(bEnable);
	}
	
	/*
	 * 조회결과로 화면 입력컴포넌트의 상태를 제어합니다.
	 */	
	function controlInput() {
		var formObj = document.form;
		
		// 입력항목 활성화 여부( Invoice 가 발행된 경우에만 호출됨 )
		var bEnable = false;

		// Tariff Type
		comboObjects[0].Enable = bEnable;
		// VVD CD
		DmtComEnableObject(formObj.vvd_cd, bEnable);
		// POR
		DmtComEnableObject(formObj.por_cd, bEnable);
		// POL
		DmtComEnableObject(formObj.pol_cd, bEnable);
		// POD
		DmtComEnableObject(formObj.pod_cd, bEnable);
		// DEL
		DmtComEnableObject(formObj.del_cd, bEnable);
		// R/DEL
		DmtComEnableObject(formObj.rcvTermCd, bEnable);
		DmtComEnableObject(formObj.deTermCd, bEnable);
		// Charge Cur.
		DmtComEnableObject(formObj.chg_curr_cd, bEnable);
		// INV Cur.
		DmtComEnableObject(formObj.inv_curr_cd, bEnable);
		// Charge Cur.
		DmtComEnableObject(formObj.chg_curr_cd, bEnable);
		// INV Cur.
		DmtComEnableObject(formObj.inv_curr_cd, bEnable);
		// D/C by AMT or %
		DmtComEnableObject(formObj.dc_amt, bEnable);
		// Tax AMT
		DmtComEnableObject(formObj.tax_amt, bEnable);
		
    	if (ComGetObjValue(formObj.inv_new_rpt_flg) == 'Y')
    		formObj.inv_new_rpt.checked = true;
    	else
    		formObj.inv_new_rpt.checked = false;

    	if (ComGetObjValue(formObj.arIfDate) != '') 
    		formObj.inv_new_rpt.disabled = true;
    	else
    		formObj.inv_new_rpt.disabled = false;
    	
		//Charge Grid 활성화/비활성화
		sheetObjects[0].Editable = bEnable;
		//Rate Detail 활성화/비활성화
		sheetObjects[1].Editable = bEnable; 
		
		// [ CSS 설정 ] input : 선택입력, input1 : 필수입력, input2 : 비활성화, noinput : 테두리없는 선택입력, noinput2 : 테두리없는 비활성화
		formObj.bkgNo.className        = "input2";
		formObj.blNo.className         = "input2";
		formObj.incCntrDtail.className = "input2";
		formObj.vvd_cd.className       = "input2";
		formObj.por_cd.className       = "input2";
		formObj.pol_cd.className       = "input2";
		formObj.pod_cd.className       = "input2";
		formObj.del_cd.className       = "input2";
		formObj.rcvTermCd.className    = "input2";
		formObj.deTermCd.className     = "input2";
		formObj.chg_curr_cd.className  = "input2";
		formObj.inv_curr_cd.className  = "input2";
		formObj.tot_amt.className      = "noinput2";
		formObj.dc_amt.className       = "noinput2";
		formObj.inv_chg_amt.className  = "noinput2";
		formObj.tax_rto_dis.className  = "noinput2";
		formObj.tax_amt.className      = "noinput2";
		formObj.inv_amt.className      = "noinput2";
		
		
		//======================================================
		// Invoice 상태에 따른 항목 상태값 변경
		//======================================================
		var invIssCd = ComGetObjValue(formObj.invoice_issue);
		var arIfCd   = ComGetObjValue(formObj.dmdt_ar_if_cd);
		var invStsCd = ComGetObjValue(formObj.dmdt_inv_sts_cd);
		
		bEnable = true;
		// Invoice 발행 후 취소된 경우
		if (invStsCd == "X") { 
			bEnable = false;
		}
		// Invoice 발행 후 A/R I/F 처리된 경우
		else if (invIssCd == "2" && arIfCd == "Y") {
			bEnable = false;
		}
		//======================================================	
		
		//payer
		DmtComEnableObject(formObj.payer_cd,      bEnable);
		DmtComEnableObject(formObj.btn_payer_cd,  bEnable);

		// Attention
		comboObjects[1].Enable = bEnable;
		
		// Trucker
		DmtComEnableObject(formObj.trucker_cd,     bEnable);
		DmtComEnableObject(formObj.btn_trucker_cd, bEnable);
		
		// Invoie remark
		DmtComEnableObject(formObj.inv_rmk1, bEnable);
		DmtComEnableObject(formObj.inv_rmk2, bEnable);
		
		// Notice
		DmtComEnableObject(formObj.notice, bEnable);
		// Cust. Ref
		DmtComEnableObject(formObj.custRef, bEnable);
		
		// Reason
		DmtComEnableObject(formObj.reason, bEnable);
		// Remark(s)
		DmtComEnableObject(formObj.remark, bEnable);
		
		// [ CSS 설정 ] input : 선택입력, input1 : 필수입력, input2 : 비활성화, noinput : 테두리없는 선택입력, noinput2 : 테두리없는 비활성화
		formObj.payer_cd.className     = bEnable ? "input1"  : "input2";
		formObj.trucker_cd.className   = bEnable ? "input"   : "input2";
		formObj.notice.className       = bEnable ? "input"   : "input2";
		formObj.custRef.className      = bEnable ? "input"   : "input2";
		formObj.inv_rmk1.className     = bEnable ? "noinput" : "noinput2";
		formObj.inv_rmk2.className     = bEnable ? "noinput" : "noinput2";
		formObj.reason.className       = bEnable ? "input1"  : "input2";
		
		// tax ( 인도 OFC 에서 발행한 Tax 는 DMT Common 모듈에서 자체적으로 관리합니다. )
		var usrCntCd = ComGetObjValue(formObj.invoice_issue) == "2" ? ComGetObjValue(formObj.cre_cnt_cd) : ComGetObjValue(formObj.usr_cnt_cd);		
		if (usrCntCd != "IN") DmtComEnableObject(formObj.chk_tax, bEnable); 
	}
	
	/*
	 * 조회결과로 화면 입력컴포넌트의 상태를 제어합니다.
	 */	
	function controlButton() {
		var formObj = document.form;
		
		var dmdtInvStsCd = ComGetObjValue(formObj.dmdt_inv_sts_cd);
		var dmdtArIfCd   = ComGetObjValue(formObj.dmdt_ar_if_cd);
		
		// Sheet Set
		ComBtnEnable("btn_set");
		// Sheet Option
		ComBtnEnable("btn_option");
		
		// C.Remark(s)
		if (dmdtInvStsCd == "X"|| dmdtInvStsCd == "C") {
			ComBtnEnable("btn_cremark");
			document.getElementById("btn_cremark").style.color = "red";
		}
		else {
			ComBtnDisable("btn_cremark");
			document.getElementById("btn_cremark").style.color = "";
		}	
		
		// H.Remark(s)
		if (dmdtArIfCd == "H") {
			ComBtnEnable("btn_hremark");
			document.getElementById("btn_hremark").style.color = "red";
		}
		else {
			ComBtnDisable("btn_hremark");
			document.getElementById("btn_hremark").style.color = "";
		}
		
		// Save
		if (dmdtInvStsCd == "C" || dmdtInvStsCd == "X" || dmdtArIfCd == "Y") {
			ComBtnDisable("btn_save");
		}
		else {
			ComBtnEnable("btn_save");
		}

		// Cancel
		if (dmdtInvStsCd == "I") {
			ComBtnEnable("btn_cancel");
		}
		else {
			ComBtnDisable("btn_cancel");
		}
		
		// Invoice 발행 전 
		if (ComGetObjValue(formObj.invoice_issue) == "1") {
			// Charge 관리버튼
			enableBtnCharge(true);
			
			// Sending History
			ComBtnDisable("btn_sendinghistory");
			// Preview
			ComBtnDisable("btn_preview");
			// INV Print
			ComBtnDisable("btn_print");
			// Fax Send
			ComBtnDisable("btn_fax");
			// Email Send
			ComBtnDisable("btn_email");			
		}
		// Invoice 발행 후
		else {
			// Charge 관리버튼
			enableBtnCharge(false);
			
			// Sending History
			ComBtnEnable("btn_sendinghistory");
			// Preview
			ComBtnEnable("btn_preview");
			// INV Print
			ComBtnEnable("btn_print");
			// Fax Send
			ComBtnEnable("btn_fax");
			// Email Send
			ComBtnEnable("btn_email");
		}
		
		// Payer Info
		ComBtnEnable("btn_payer");
		
		// A/R I/F
		if (dmdtInvStsCd == "I" && dmdtArIfCd == "N") {
			ComBtnEnable("btn_arif");
		}
		else {
			ComBtnDisable("btn_arif");
		}		
	}	
	
