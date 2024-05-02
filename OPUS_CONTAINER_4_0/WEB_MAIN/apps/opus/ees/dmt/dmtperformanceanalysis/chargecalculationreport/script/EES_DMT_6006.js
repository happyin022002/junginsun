/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0110.js
*@FileTitle  : Summary Report by Customer - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author
     */
   	/* 개발자 작업	*/
 // 공통전역변수
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		switch(srcName) {
	     		case "btn_ByBKG":
				case "btn_ByCNTR":
					doProcessPopup(srcName);
					break;
				case "btn_DownExcel":
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	
		var opener=window.dialogArguments;
		if (!opener) opener=parent; 		
  		var opnSheetObj=opener.sheetObjects[0];
  		var opnFormObj=opener.document.form;  		
  		with(opnSheetObj) {
	 		var chkRow=GetSelectRow();
			var scNo=GetCellValue(chkRow, "sc_no");
			var rfaNo=GetCellValue(chkRow, "rfa_no");

			ComSetObjValue(formObj.sc_no,		scNo);
			ComSetObjValue(formObj.rfa_no,		rfaNo);
			ComSetObjValue(formObj.cust_cd,		GetCellValue(chkRow, "cust_cd"));
			ComSetObjValue(formObj.cust_nm,		GetCellValue(chkRow, "cust_nm"));
			ComSetObjValue(formObj.ctrt_ofc,	GetCellValue(chkRow, "ctrt_ofc"));
			ComSetObjValue(formObj.dmdt_trf_cd, GetCellValue(chkRow, "trf_cd"));
			ComSetObjValue(formObj.ofc_cd,		GetCellValue(chkRow, "dmdt_ofc"));
			ComSetObjValue(formObj.cvr_cd,		GetCellValue(chkRow, "cvr_cd"));
			ComSetObjValue(formObj.por_cd,		GetCellValue(chkRow, "por_cd"));
			ComSetObjValue(formObj.pol_cd,		GetCellValue(chkRow, "pol_cd"));
			ComSetObjValue(formObj.pod_cd,		GetCellValue(chkRow, "pod_cd"));
			ComSetObjValue(formObj.del_cd,		GetCellValue(chkRow, "del_cd"));
			if(scNo != '')
				sheetObj.SetColHidden("rfa_no",1);
			else
				sheetObj.SetColHidden("sc_no",1);
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
    	  var cnt=0;
    	  var sheetID=sheetObj.id;
    	  switch(sheetID) {
             case "sheet1":
            	    with(sheetObj){
                
               var HeadTitle1="|Seq.|S/C No.|RFA No.|Customer|Customer|Actual Customer|Actual Customer|CTRT OFC|Tariff|STS|CNTR No.|T/S|DMT OFC"
               + "|From YD|To YD|Fm|To|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT"
               + "|INV Cur.|Invoiced AMT|A/R|BKG No.|B/L No.|VVD|Lane|POR|POL|POD|DEL|R|D|INV No.|ISS DT|G/B";

               
               SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );
               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Seq",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acust_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"expt_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"inv_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_ar_if_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:39,   Align:"Center",  ColMerge:0,   SaveName:"chg_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ofc_rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);
               SetEditable(1);
               SetEllipsis(1);
               SetSheetHeight(420);
               }


                 break;
         }
     }
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
 			case IBSEARCH:      //조회
	 			sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 	        	formObj.f_cmd.value=SEARCH;
 	        	sheetObj.DoSearch("EES_DMT_6006GS.do", FormQueryString(formObj) );
 				ComOpenWait(false);
 				break;
		}
	}
	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg) {
    	var formObj=document.form;
    	// General Charge 갯수 (chg_seq = 1, chg_type = 'G')
    	var cntrQty;
    	var rows=ComFindAll(sheetObj, "chg_type", "G") + '';
    	if(rows.indexOf('|') != -1) {
    		var arrRows=rows.split('|');
	    	cntrQty=arrRows.length;
    	} else {
    		cntrQty=1;
    	}
    	with(sheetObj) {
    		//cntrQty = EtcData("cntr_qty");
			ComSetObjValue(formObj.cntr_qty, ComAddComma2(cntrQty, "#,###"));
			var custCd=ComGetObjValue(formObj.cust_cd);
			var custNm=ComGetObjValue(formObj.cust_nm);
			var ctrtOfc=ComGetObjValue(formObj.ctrt_ofc);
    		for(var i=GetTopRow(); i <= LastRow(); i++) {
    			SetCellValue(i, "cust_cd",custCd);
    			SetCellValue(i, "cust_nm",custNm);
    			SetCellValue(i, "ctrt_ofc",ctrtOfc);
    		}
    		// 페이지 접근 권한정보
			var rolePermit=EtcData("ROLE_PERMIT");
			var roleAuth=EtcData("ROLE_AUTH");
			ComSetObjValue(formObj.role_permit, rolePermit);
			ComSetObjValue(formObj.role_auth,	roleAuth);
    	}
 	}
 	/*
 	 * 각 공통팝업창 호출 함수 
 	 */
  	function doProcessPopup(srcName) {
 		var sheetObj=sheetObjects[0];
 		var formObj=document.form;
 		var sUrl='';
 		var sWidth='';
 		var sHeight='';
 		with(sheetObj) {
 	  		switch(srcName) {
 	 	  		case 'btn_ByBKG':
 	 	  			var chkRow=GetSelectRow();
					var bkgNo=GetCellValue(chkRow , "bkg_no");
					var blNo=GetCellValue(chkRow , "bl_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
 		  			var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
 		  			if (ComGetObjValue(formObj.role_permit) == 'Y') {
		  				// Calculation 화면
		  				sUrl='EES_DMT_3002P.do' + paramVal;
		  			} 
 		  			else {
		  				// Inquiry 화면
		  				sUrl='EES_DMT_3005P.do' + paramVal;
		  			}
 		  			sWidth='1280';
	          		sHeight='700';
 	  			break;
 	  			
 	  			case 'btn_ByCNTR':
 	  				var chkRow=GetSelectRow();
					var svrId=GetCellValue(chkRow , "svr_id");
					var cntrNo=GetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetCellValue(chkRow , "chg_seq");
 		  			var paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
 		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
 		  			
 		  			if (ComGetObjValue(formObj.role_permit) == 'Y'
 		  				&& GetCellValue(chkRow , "ofc_rhq_cd") == ComGetObjValue(formObj.usr_rhq_ofc_cd)) {
			  			// Calculation 화면
			  			sUrl='EES_DMT_3003P.do' + paramVal;
	 		  			sWidth='1150';
		          		sHeight='700';			  			
		  			} 
 		  			else {
		  				// Inquiry 화면
		  				sUrl='EES_DMT_3006P.do' + paramVal;
	 		  			sWidth='1120';
		          		sHeight='656';		  				
		  			}
 	  			break;
 	  		} // switch end
 		} // with end
 		var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  		ComOpenPopup(sUrl, sWidth, sHeight, "callbackProc", "0,1", true);
 	} 
  	
    /**
     * 팝업화면 종료시 호출되는 함수
     */  	
  	function callbackProc(rtnVal) {
  		// 삭제하면 스크립트 오류 발생됩니다.
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
