/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0091.js
*@FileTitle : W/O 발행화면 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 최 선
*@LastVersion : 1.9
* 2006.11.21 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.01.09 양봉준 1.1 [N200901090011] W/O Issue 화면 보완요청(09.02.03)
* 2009.03.09 양봉준 1.2 [N200903090081] Zip code 필수 입력 항목으로 변경 요청(09.03.17)
* 2009.04.31 양봉준 1.3 [CHM-200900431] Customer Code 입력가능요청(09.08.24) 
* 2010.10.08 최 선 1.4  [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.02.08 이재위 1.5 [CHM-201108673-01] [TRS] Work Order Issue(ESD_TRS_0091) : W/O Preview per B/L 기능 개발
* 2011.02.10 민정호 1.6 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 2011.05.06 손은주 1.7 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.06.13 손은주 1.8 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계):Merge Cell 수정
* 2011.06.15 최 선   1.9 [][TRS] TRS-TPB I/F 미실행 오류 조치
* 2011.07.14 김영철 2.0 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.11.02 민정호 2.1 [CHM-201114318] [TRS] 선택된 Row 표현 구분방식 변경 + D7 (AK) SPC cargo 표현로직 제거 요청 
* 2011.10.31 이수진 2.2 [CHM-201113210] [TRS] Feeder Term 표기 칼럼 추가 요청 - Null 값 처리
* 2011.12.22 민정호 2.3 [CHM-201115196] [TRS] W/O ISSUE시 S/O History에 agmt no 정보를 남길 수 있도록 기능 수정
* 2011.12.29 유선오 2.4 [CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.03.27 금병주 2.5 [CHM-201114903] [TRS] Split 01-[구주 TRO] Special Cargo Sequence매칭 관련 validation 및 팝업
* 2012.05.08 김종호 2.6 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
* 2012.07.20 김종호 2.7 [CHM-201219248] [TRS] W/O preview 화면에서 최종 confirm 시 로그인ofc와 S/O지역코드를 비교하기 위한 로직 추가
* 2012.12.11 이재위 2.8 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건
* 2015.06.23 9014787 [CHM-201535923] W/O Inquiry 개선2
=========================================================*/ 


/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0091 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0091() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var wo_radio_check = '0';
var prefix = 'surcharge_';
//var prefix4 = '';
var processFlag = false;

var spot_bid_vndr_cnt = 3;

String.prototype.trim = function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

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

			case 'btn_reset':
				if(processFlag) return;
				formObject.reset();
				resetSearchCondition(formObject);
				break;

			case "btn_retrieve":
				if(processFlag) return;
				sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btng_rowadd":
				if(processFlag) return;
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;

			case "btng_downexcel":
				if(processFlag) return;
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none"){
					document.all.MiniLayer.style.display = "none";
					sheetObject.style.height = sheetObject.GetSheetHeight(19);
				}else {
					document.all.MiniLayer.style.display = "";
					sheetObject.style.height = sheetObject.GetSheetHeight(13);
				}
				break;

			case "btng_provider":
				if(processFlag) return;
				rep_OnPopupClick();
				break;

			case 'btns_calendar':
				if(processFlag) return;
				getCalendar();
				break;

			case "btns_wo_no":
				if(processFlag) return;
				if(!formObject.wo_radio[1].checked){
					return;
				}
				rep_Multiful_inquiry(srcName);
				break;
			
			case "btns_tvvd_no":
			case "btns_fvvd_no":
			case "btns_bkg_no":
			case "btns_bl_no":
			case "btns_eq_no":
			case "btns_so_no":
			case "btns_mty_rfrn_no":
			case "btns_spot_bid_no":
				if(processFlag) return;
				rep_Multiful_inquiry(srcName);
				break;

			case 'btng_currnegosave':
				if(processFlag) return;
		    	if(sheetObject.RowCount < 1){
		    		ComShowCodeMessage('TRS90390');
		    		return;
		    	}	
				modifyCurrNego(sheetObject);
	  			   
				break;
				
			case 'btng_wopreview':
				if(processFlag) return;
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var arrRow = checkList.split("|");
				   if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}	
					

			   
				/* 1.126 N200903090081 Zip code 필수 입력 항목으로 변경 요청" +
				  "		*/
				  for (idx=0; idx<arrRow.length-1; idx++){ 
					 
					  var loc = sheetObject.CellValue( arrRow[idx] , "fm_loc_value" );   	
					  var zip = sheetObject.CellValue( arrRow[idx] , "dor_pst_cd" );
					  var cost_mod = sheetObject.CellValue( arrRow[idx] , "trsp_cost_dtl_mod_nm" );   		       
					  var trsp_mod = sheetObject.CellValue( arrRow[idx] , "trsp_crr_mod_nm" );
					  var po_cfm_flg = sheetObject.CellValue( arrRow[idx] , "po_cfm_flg" );
					  
					  // PO CFM FLG
					  /*if (po_cfm_flg == 'N') {
						  ComShowMessage("Agreement confirmation is needed.");
						  return false ;	
					  }*/
					      			    	
					  if(cost_mod == 'DOOR' && trsp_mod == 'TD'){
						  if( loc.substring(0,2) == 'US' && (zip =="" ||!ComIsNumber(zip)||zip.length != 5)){
							  ComShowMessage("ZIP code should be a 5-figure number.");
							  sheetObject.SelectCell(arrRow[idx], "dor_pst_cd" );
						      return false ;	
						  }
					  }
					  
					  // Spot Bid S/P
					  if(document.form.wo_radio[0].checked == true && sheetObject.CellValue( arrRow[idx] , "spot_bid_win_vndr_seq" ) == ""){
						  //ComShowMessage("SPOT BID S/P Select PLZ");
						  ComShowCodeMessage('TRS90708');
						  return false;
					  }

					  // Spot Bid 는 Reissue 비허용 Cancel 허용
					  if(document.form.wo_radio[1].checked == true/* && sheetObject.CellValue(arrRow[idx], 'cancel_check') != '1'*/){
						  // 현재 W/O 번호를 받아서
						  var wo_cd_src = sheetObject.CellValue(arrRow[idx], 'trsp_wo_ofc_cty_cd')+sheetObject.CellValue(arrRow[idx], 'trsp_wo_seq');
						  // 전체 ROW 를 돌면서 같은 W/O 번호로 CANCEL 건이 있는지 확인한다.
						  var wo_cancel_flg = "N";
						  for(var i=2;i<sheetObject.RowCount+2; i++){
							  wo_cd_tgt = sheetObject.CellValue(i, 'trsp_wo_ofc_cty_cd')+sheetObject.CellValue(i, 'trsp_wo_seq');
							  if(wo_cd_src == wo_cd_tgt && sheetObject.CellValue(i, 'cancel_check') == '1')
								  wo_cancel_flg = "Y";
						  }
						  
						  // 해당 W/O CANCEL 건이 하나도 없을경우 Spot Bid 는 Reissue 비허용
						  if(wo_cancel_flg == "N"){
							  ComShowMessage("Spot Bid Not Reissued");
							  return false;							  
						  }
					  }
					  
				  	}
			  
	           if(document.form.wo_radio[0].checked){
				    var trsp_so_no = "";
					for(idx=0; idx<arrRow.length-1; idx++){ 
						trsp_so_no += sheetObject.CellValue(arrRow[idx], 'trsp_so_ofc_cty_cd')+sheetObject.CellValue(arrRow[idx], 'trsp_so_seq')+",";
					}		 
						
					formObject.trsp_so_no.value = trsp_so_no; // S/O의 Office 코드를 검증하기 위해 추가
							
					formObject.f_cmd.value = SEARCH07;   
					var sXml = sheetObject.GetSearchXml("ESD_TRS_0091GS.do", FormQueryString(formObject));
					var checkSoNo = ComGetEtcData(sXml,'checkSoNo');
					
		           if(checkSoNo != 'N'){	
			    	   ComShowCodeMessage('TRS00411',checkSoNo);	    	  
			    	   return false;	       
			       } 
	           }
	           document.form.wo_prv_grp_bl_flg.value = "N";  	    	
   	    	   doActionIBSheet(sheetObject1,formObject,IBSAVE);	  
  				break;
				
			case 'btng_wopreviewperbl':
				if(processFlag) return;
				var checkList = sheetObject.FindCheckedRow('ibcheck');
            	var arrRow = checkList.split("|");
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}			
	            for (idx=0; idx<arrRow.length-1; idx++){ 
			        var loc = sheetObject.CellValue( arrRow[idx] , "fm_loc_value" );   	
	   		        var zip = sheetObject.CellValue( arrRow[idx] , "dor_pst_cd" );
	   		        var cost_mod = sheetObject.CellValue( arrRow[idx] , "trsp_cost_dtl_mod_nm" );   		       
	   		        var trsp_mod = sheetObject.CellValue( arrRow[idx] , "trsp_crr_mod_nm" );
	   		        var po_cfm_flg = sheetObject.CellValue( arrRow[idx] , "po_cfm_flg" );
	 		       
	   		        /*if (po_cfm_flg == 'N') {
	   		        	ComShowMessage("Agreement confirmation is needed.");
	   		        	return false ;	
	   		        }*/
	   		        
	                if(cost_mod == 'DOOR' && trsp_mod == 'TD'){
	    		        if( loc.substring(0,2) == 'US' && (zip =="" ||!ComIsNumber(zip)||zip.length != 5)){
	    		    	    ComShowMessage("ZIP code should be a 5-figure number.");
	                        sheetObject.SelectCell(arrRow[idx], "dor_pst_cd" );
				            return false ;	
			            }
				    }
	                
	                // Spot Bid S/P
	                if(document.woForm.issued.value == "N" && sheetObject.CellValue( arrRow[idx] , "spot_bid_win_vndr_seq" ) == ""){
	                	//ComShowMessage("SPOT BID S/P Select PLZ");
	                	ComShowCodeMessage('TRS90708');
	                	return false;
	                }
					  
	            }
				
			    var trsp_so_no = "";
				for(idx=0; idx<arrRow.length-1; idx++){ 
					trsp_so_no += sheetObject.CellValue(arrRow[idx], 'trsp_so_ofc_cty_cd')+sheetObject.CellValue(arrRow[idx], 'trsp_so_seq')+",";
				}
	            formObject.trsp_so_no.value = trsp_so_no; // S/O의 Office 코드를 검증하기 위해 추가
	            	
	            document.form.wo_prv_grp_bl_flg.value = "Y";
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;

			case 'btng_soinquiry':
				if(processFlag) return;
				popSoInquiry(sheetObject,formObject);
				break;

			case 'btng_frustrate':
				if(processFlag) return;
				setFrustrate(sheetObject);
				break;

			case 'btng_spselect':
				if(processFlag) return;
				popSpselect(sheetObject);
				break;
			
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			
			case "btns_vianode": //ViaNode Popup창
				openHireYardPopup('getViaNode');
			break;
			
			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			
			case "btns_dorloc": //DoorLocation Popup창
				openHireYardPopup('getDorLoc');
			break;

			case "btns_tvvd_s_no":
				if(processFlag) return;
				openTVVDPopup();
				break;

			case "btns_fvvd_s_no":
				if(processFlag) return;
				openFVVDPopup();
				break;

			case "btng_surchargeapply":
				if(processFlag) return;
				popSurchargeInputInquiry(sheetObject, '', '', 'multiple', 'WO');
				break;

			case "btng_apptdeliexcelimport":		
		    	if(sheetObjects[0].RowCount < 1){
		    		ComShowCodeMessage('TRS90390');
		    		return;
		    	}				
				openApptDeliExcelImportPopup(sheetObjects[0],formObject);				
				break;
			
		case "btng_apptdelisave":				
		    	if(sheetObjects[0].RowCount < 1){
		    		ComShowCodeMessage('TRS90390');
		    		return;
		    	}			
				setAppDeli(sheetObject);
				break;

			case "btng_bundling":
				openBundlingPopup(sheetObject,formObject);				
				break;
			
			case "btng_morecandidate":
				if(processFlag) return;
				multi_moreCandidate(sheetObject);
				break;
			case 'btng_ratereapply':
				getRateReApply(sheetObject, formObject);
				break;
				
			case "btng_morecntcandidate":
				setMoreCntCandidate(sheetObject);
			break;	
			
			case 'btns_duedt':
				//if(document.form.mode_param.value == 'search' || confirm_flag) return;
				var cal = new ComCalendar();
				cal.select(formObject.fmdate, 'yyyyMMdd');
				break;
			
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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

	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		ComConfigSheetTrs(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	if(init_searchStr != undefined && init_searchStr != ''){
		document.form.f_cmd.value = SEARCH01;
		sheetObjects[0].DoSearch4Post("ESD_TRS_0091GS.do", init_searchStr+'&'+TrsFrmQryString(document.form));
	}
	
	gubunApptDeli(cnt_cd);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var checkFlag = true;
	var selCheckFlag = true;
	if(document.form.wo_radio[0].checked){
		checkFlag = false;
		selCheckFlag = true;
	}else{
		checkFlag = true;
		selCheckFlag = false;
	}
	switch(sheetNo) {
	   case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(12);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msHeaderOnly;
				MergeSheet = msHeaderOnly;
				
				
			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(174+(spot_bid_vndr_cnt*6), 7, 0, true);//165

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
				
				var HeadTitle1_dynamic = "";
				var HeadTitle2_dynamic = "";
				for(var i=1; i<=spot_bid_vndr_cnt;i++){
					HeadTitle1_dynamic += "|Bid "+i+"|Bid "+i+"|Bid "+i+"|Bid "+i+"|Bid "+i+"|Bid "+i+"";
					HeadTitle2_dynamic += "||S/P Code|S/P Name|Currency|Rate|Rate(USD)";
				}

				var HeadTitle1 = "|Issue\ncancel|Cancel\nReason|Detain|B-\nNumber\nIssue|EQ No.|TP/SZ"+
					"|CB\nSEQ|Bundle Kind|BKG\nCargo\nType|Cost\nMode|Trans\nMode|S/O Type"+
					"|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Distance|Distance"+
					"|Door Information|Door Information|Door Information|Door Information"+
					"|Door Information|Door Information|Door Information"+
					"|Multi\nStop"+
					"|Estimated Time\n(From Departure)|Estimated Time\n(From Departure)|Estimated Time\n(To Arrival)"+
					"|Estimated Time\n(To Arrival)|Estimated Time\n(Door Arrival)|Estimated Time\n(Door Arrival)"+
					"|COP No|A/G SEQ|A/G Code"+
					"|BKG No|BL No|TRO Information|TRO Information|TRO Information|TRO Information"+
					"|TRO Information|TRO Information|TRO Information|TRO Information"+
				    "|BKG QTY|Weight(KGS)|Weight(LBS)|BKG CGO SPE|T.VVD|Lane|In VVD|Out VVD"+
					"|Shipper|Consignee|Notify"+
					"|MTY Reference No|S/O No|S/O\nCreation\nUser Name|S/O\nCreation\nTime"+
					"|W/O No|W/O\nCreation\nUser Name|W/O\nIssue\nTime"+
					"|Distance\n(Km)|Distance\n(Mile)"+
					"|Default\nS/P|CNT|CNT|CNT|Customer\nCode|S/P\nCode|S/P\nName|HAZMAT\n(DG)|Over\nweight|W/O\nEDI|Reject\nHistory|AGMT\nConfirmation|AGMT\nType|One Way/\nRound Trip"+
					"|Bid No.|Due Date"+
					"|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate|Guidline rate"+
					"|Bid Winner|Bid Winner|Bid Winner|Bid Winner|Bid Winner"+
					HeadTitle1_dynamic+
					"|More Bidder"+
					"|More\nCandidates|Feeder Term|Feeder Term|3rd Party"+
					"|Internal\nRemark|Remark\n(Special Instruction)|W/O Instruction|MTY R/R|Frustrate|Appointment Time|Appointment Time|Delivery Time|Delivery Time"+
					"|Bundling Flg|GP ID|GP Seq.";

				var HeadTitle2 = "|Issue\ncancel|Cancel\nReason|Detain|B-\nNumber\nIssue|EQ No.|TP/SZ"+
					"|CB\nSEQ|Bundle Kind|BKG\nCargo\nType|Cost\nMode|Trans\nMode|S/O Type"+
					"|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Km|R.Link"+
					"|Actual\nCustomer|Factory\nName|Zip\nCode|Address"+
					"|TEL|FAX|PIC"+
					"|Multi\nStop"+
					"|Estimated Time\n(From Departure)|Estimated Time\n(From Departure)|Estimated Time\n(To Arrival)"+
					"|Estimated Time\n(To Arrival)|Estimated Time\n(Door Arrival)|Estimated Time\n(Door Arrival)"+
					"|COP No|A/G SEQ|A/G Code"+
					"|BKG No|BL No|SEQ|CNFM|Office|User ID"+
					"|Time|Time|Revenue\nCurrency|Revenue\nAmount"+
					"|BKG QTY|Weight(KGS)|Weight(LBS)|BKG CGO SPE|T.VVD|Lane|In VVD|Out VVD"+
					"|Shipper|Consignee|Notify"+
					"|MTY Reference No|S/O No|S/O\nCreation\nUser Name|S/O\nCreation\nTime"+
					"|W/O No|W/O\nCreation\nUser Name|W/O\nIssue\nTime"+
					"|Distance\n(Km)|Distance\n(Mile)"+
					"|Default\nS/P|Flag|Contract No|Count|Customer\nCode|S/P\nCode|S/P\nName|HAZMAT\n(DG)|Over\nweight|W/O\nEDI|Reject\nHistory|AGMT\nConfirmation|AGMT\nType|One Way/\nRound Trip"+
					"|Bid No.|Due Date"+
					"|Currency||Basic|Negotiated||Fuel|Vat|Toll Fee|Additional|Total|Total(USD)"+
					"|S/P Code|S/P Name|Currency|Rate|Rate(USD)"+
					HeadTitle2_dynamic+
					"|More Bidder"+
					"|More\nCandidates|Receiving|Delivery|3rd Party"+
					"|Internal\nRemark|Remark\n(Special Instruction)|W/O Instruction|MTY R/R|Frustrate|Appointment\nTime|Appointment\nTime|Delivery\nTime|Delivery\nTime"+
					"|Bundling\nFlg|GP ID|GP Seq.";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				HeadRowHeight = 30;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,  30,	daCenter,  true,    "ibcheck");
				InitDataProperty(0, cnt++ , dtCheckBox,  60,	daCenter,  true,	"cancel_check",			false,		"",		dfNone,		0,	checkFlag,	checkFlag);
				InitDataProperty(0, cnt++ , dtCombo,    100,    daCenter,  true,    "trsp_rjct_rsn_cd",		false,		"",		dfNone,		0,	checkFlag,	checkFlag,	4, false, true);
				InitDataProperty(0, cnt++ , dtCheckBox,  65,	daCenter,  true,	"dtn_use_flg",			false,		"",		dfNone,		0,	true,		true,		5, false, true);
				InitDataProperty(0, cnt++ , dtCheckBox,  65,	daCenter,  true,	"wo_bl_no_iss_flg",		false,		"",		dfNone,		0,	true,		true,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      88,	daCenter,  true,    "eq_no",				false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,    "eq_tpsz_cd",			false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "trsp_so_cmb_seq",		false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "trsp_so_cmb_tp_nm",	false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "cgo_tp_nm",			false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "trsp_cost_dtl_mod_nm",	false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,	daCenter,  true,    "trsp_crr_mod_nm",		false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,	daCenter,  true,    "trsp_so_tp_nm",		false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "fm_loc_value",			false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "fm_yard_value",		false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "via_loc_value",		false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "via_yard_value",		false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "to_loc_value",			false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "to_yard_value",		false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "dor_loc_value",		false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  true,    "dor_yard_value",		false,		"",		dfNone,		0,	false,		false,		4, false, true);
				
				//2012.06.01 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData,  	 50, 	 daRight,  true, 	"ttl_dist", 			false, 		"",  dfInteger, 	0, 	false, 		false);
				InitDataProperty(0, cnt++, dtData,  	 50, 	daCenter,  true, 	"lnk_dist_div_cd", 		false, 		"", 	dfNone, 	0, 	false, 		false);
				
				InitDataProperty(0, cnt++ , dtData,     80,    daCenter,   true,    "act_cust_cd",	        false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,		100,    daLeft,    true,	"fctry_nm",				false,		"",		dfNone,		0,	false,		false,	  100, false, true);
				InitDataProperty(0, cnt++ , dtData,		 50,    daCenter,  true,	"dor_pst_cd",			false,		"",		dfNone,		0,	true,		true,	   10, false, true);
				InitDataProperty(0, cnt++ , dtData,		 70,    daLeft,    true,	"dor_de_addr",			false,		"",		dfNone,		0,	false,		false,		4, false, true);
				InitDataProperty(0, cnt++ , dtData,		 70,    daCenter,  true,	"cntc_pson_phn_no",		false,		"",		dfNone,		0,	false,		false,	   20, false, true);
				InitDataProperty(0, cnt++ , dtData,		 70,    daCenter,  true,	"cntc_pson_fax_no",		false,		"",		dfNone,		0,	false,		false,	   20, false, true);
				InitDataProperty(0, cnt++ , dtData,		100,    daLeft,    true,	"cntc_pson_nm",			false,		"",		dfNone,		0,	false,		false,	  100, false, true);
				InitDataProperty(0, cnt++ , dtPopup,     60,    daCenter,  true,    "mlt_stop_de_flg",		false,		"",		dfNone,		0,	false,		false,		5, false, true);
				
				InitDataProperty(0, cnt++ , dtData,		 80,    daCenter,  true,    "n1st_nod_pln_dt",      false,		"",		dfDateYmd,	0,	false,		false,	    8, false, true);
				InitDataProperty(0, cnt++ , dtData,		 60,    daCenter,  true,    "n1st_nod_pln_tm",      false,		"",		dfTimeHms,	0,	false,		false,	    6, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "lst_nod_pln_dt",		false,		"",		dfDateYmd,	0,	false,		false,	    8, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "lst_nod_pln_tm",		false,		"",		dfTimeHms,	0,	false,		false,	    6, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "dor_nod_pln_dt",		false,		"",		dfDateYmd,	0,	false,		false,	    8, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "dor_nod_pln_tm",		false,		"",		dfTimeHms,	0,	false,		false,	    6, false, true);
				
				InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  true,    "cop_no",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,	"cost_act_grp_seq",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,	"cost_act_grp_cd",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				
				InitDataProperty(0, cnt++ , dtData,      93,    daCenter,  true,    "bkg_no",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      93,    daCenter,  true,    "bl_no",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,	"tro_seq",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "tro_cnfm",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "tro_cfm_ofc_cd",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "tro_cfm_usr_id",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "tro_cfm_upd_dt",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "tro_cfm_upd_tm",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "rev_curr_cd",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,		 70,    daCenter,  true,    "revenue",				false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				
				InitDataProperty(0, cnt++ , dtData,     120,    daCenter,  true,	"bkg_qty",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,   true,    "cntr_kgs_wgt",			false,		"",		dfFloat,	4,	false,		false,	    9, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,   true,    "cntr_lbs_wgt",			false,		"",		dfFloat,	4,	false,		false,	    9, false, true);
				InitDataProperty(0, cnt++ , dtPopup,     80,    daCenter,  true,    "spcl_cgo_cntr_tp_cd",	false,		"",		dfNone,		0,	false,		false,		4, false, true);
				
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "t_vvd",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "lane",					false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "ib_vvd_cd",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,    "ob_vvd_cd",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daLeft,    true,    "shpr_cust_nm",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daLeft,    true,    "cnee_cust_nm",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daLeft,    true,    "ntfy_cust_nm",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daCenter,  true,    "ref_id",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  true,    "trsp_so_ofc_cty_cd_seq",false,		 "",	dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     100,    daLeft,    true,    "so_cre_nm",			false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     123,    daCenter,  true,    "so_cre_dt",			false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "trsp_wo_ofc_cty_cd_seq",false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     100,    daLeft,    true,    "wo_cre_nm",			false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daCenter,  true,    "wo_issue_dt",			false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "distance",				false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "distance_uom",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "trsp_dflt_vndr_flg",	false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,    "po_sp_type" ,			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				
				InitDataProperty(0, cnt++ , dtHidden, 	 70, 	daCenter,  	true, 	"ctrt_no", 				false, 		"", 	dfNone, 	0,  false, 		false, 		11);
				InitDataProperty(0, cnt++ , dtPopup,  	 50,  	daRight,   	true, 	"ctrt_cnt", 			false, 		"", 	dfNone, 	0,  false, 		false, 		5);
				
				InitDataProperty(0, cnt++ , dtData,	  	 80,	daCenter,  	true,	"cust_cnt_cd_seq",		false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  	true,   "vndr_seq",				false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     100,    daLeft,    	true,   "vndr_nm",				false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     60,     daCenter,   true,   "hzd_mtrl_flg",			false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtData,     60,     daCenter,   true,   "ovwt_tri_axl_flg",		false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "wo_edi_use_flg",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);

				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "wo_rjct_indct",		false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "po_cfm_flg",			false,		"",		dfNone,		0,	false,		false,	    4, false, true);
				
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "po_trsp_agmt_rt_tp_nm",false,		"",		dfNone,		0,	false,		false,	    5, false, true);
				InitDataProperty(0, cnt++ , dtCombo,    110,    daCenter,  	true,   "po_way_type",			false,		"",		dfNone,		0,	false,		false,	    5, false, true);

				InitDataProperty(0, cnt++ , dtData,      120,   daCenter,  	true,   "spot_bid_no",			false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      140,   daCenter,  	true,   "spot_bid_due_dt",		false,		"",		dfNone,	0,	false,		false,		14,false, true);

				InitDataProperty(0, cnt++ , dtCombo,     80,    daCenter,  	true,   "po_local_curr_cd",		false,		"",		dfNone,		0,	false,		false,		3, false, true);
				InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  	true,   "org_curr_cd",			false,		"",		dfNone,		0,	true,		true,		3, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "po_basic_rt",			false,		"",		dfFloat,	2,	false,		false,		13,false, true);
				InitDataProperty(0, cnt++ , dtHidden,    80,    daRight,  	true,   "nego_amt",				false,		"",		dfFloat,	2,	true,		true,		13,false, true);
				InitDataProperty(0, cnt++ , dtHidden,    80,    daRight,  	true,   "org_nego_amt",			false,		"",		dfFloat,	2,	true,		true,		13,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "po_fuel_scg_rt",		false,		"",		dfFloat,	2,	false,		false,	    13,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "po_vat_scg_rt",		false,		"",		dfFloat,	2,	false,		false,	    13,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,   	true,   "toll_fee_amt",			false,		"",		dfFloat,	2,	false,		false,		13,false, true);
				InitDataProperty(0, cnt++ , dtHidden,    80,    daRight,  	true,   "etc_add_amt",			false,		"",		dfFloat,	2,	true,		true,		13,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "po_local_curr_tot_amt",false,		"|po_basic_rt|+|po_fuel_scg_rt|+|po_vat_scg_rt|+|toll_fee_amt|",	dfFloat,     2,     false,       false,          14, false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "po_usd_curr_tot_amt",	false,		"",		dfFloat,	2,	false,		false,		14,false, true);

				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "spot_bid_win_vndr_seq",false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daLeft,  	true,   "spot_bid_win_vndr_nm",	false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "spot_bid_win_curr_cd",	false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "spot_bid_win_amt",	    false,		"",		dfFloat,2,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "spot_bid_win_usd_amt",	false,		"",		dfFloat,2,	false,		false,		14,false, true);
				
			for(var i=1; i<=spot_bid_vndr_cnt;i++){
				InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  	true,   "spot_bid_vndr_sel_"+i,	false,		"",		dfNone,	0,	false,		false,		 0,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "spot_bid_vndr_seq_"+i,	false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daLeft,  	true,   "spot_bid_vndr_nm_"+i,	false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "spot_bid_curr_cd_"+i,	false,		"",		dfNone,	0,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daRight,  	true,   "spot_bid_amt_"+i,	    false,		"",		dfFloat,2,	false,		false,		14,false, true);
				InitDataProperty(0, cnt++ , dtHidden,    80,    daRight,  	true,   "spot_bid_usd_amt_"+i,	false,		"",		dfFloat,2,	false,		false,		14,false, true);
			}
				//InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  	true,   "spot_bid_vndr_cnt",	false,		"",		dfNone,		0,	false,false,4,false, true);
				InitDataProperty(0, cnt++ , dtPopup,     80,    daCenter,  	true,   "spot_bid_vndr_cnt",		false,		"",		dfNone,		0,	true,		false,		5, false, true);
				
				InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  	true,   "more_candidates",		false,		"",		dfNone,		0,	selCheckFlag,selCheckFlag,4,false, true);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "po_wtr_rcv_term_cd",	false,		"",		dfNone,	    0,	false,		false,		14,false, true); //2011.10.17 이수진 추가
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  	true,   "po_wtr_de_term_cd",	false,		"",		dfNone,	    0,	false,		false,		14,false, true);	

				InitDataProperty(0, cnt++ , dtPopup,     70,    daCenter,  	true,   "n3pty_bil_flg",		false,		"",		dfNone,		0,	false,		false,		5, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daLeft,  	true,   "inter_rmk",			false,		"",		dfNone,		0,	true,		false,	 1000, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daLeft,  	true,   "spcl_instr_rmk",		false,		"",		dfNone,		0,	false,		false,	 1000, false, true);
				InitDataProperty(0, cnt++ , dtData,     120,    daLeft,  	true,   "wo_rmk",				false,		"",		dfNone,		0,	false,		false,	 1000, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  	true,   "mty_rr_flg",			false,		"",		dfNone,		0,	false,		false,		1, false, true);
				InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  	true,   "trsp_frst_flg",		false,		"",		dfNone,		0,	false,		false,		1, false, true);
				InitDataProperty(0, cnt++ , dtData,     75,     daCenter,  	true,   "appo_time_dt",			false,		"",		dfDateYmd,	0,	false,		false,		5, false, true);	
				InitDataProperty(0, cnt++ , dtData,     65,     daCenter,  	true,   "appo_time_hms",		false,		"",		dfTimeHms,	0,	false,		false,		5, false, true);			
				InitDataProperty(0, cnt++ , dtData,     75,     daCenter,  	true,   "deli_time_dt",			false,		"",		dfDateYmd,	0,	false,		false,		5, false, true);	
				InitDataProperty(0, cnt++ , dtData,     65,     daCenter,  	true,   "deli_time_hms",		false,		"",		dfTimeHms,	0,	false,		false,		5, false, true);			
				
				InitDataProperty(0, cnt++ , dtHidden,	50,  	daCenter,	true,   "bundling_flg");		
				InitDataProperty(0, cnt++ , dtData,    120,     daCenter,  	true,    "mcntr_bdl_grp_seq",	false,		"",		dfNone,		0,	false,		false,		5, false, true);	
				InitDataProperty(0, cnt++ , dtData,     80,     daCenter,  	true,    "mcntr_bdl_seq",		false,		"",		dfNone,		0,	false,		false,		5, false, true);
				
				InitDataProperty(0, cnt++ , dtStatus,     0,    daCenter,   true,    "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_so_seq");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_so_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_wo_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_wo_seq");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_cost_dtl_mod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "trsp_crr_mod_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "cgo_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "surcharge_key");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "trsp_so_cmb_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "trsp_bnd_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "po_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "po_cust_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "bundling_no");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "cre_ofc_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "cmdt_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "po_trsp_agmt_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "po_trsp_agmt_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "po_trsp_agmt_rt_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "po_cust_nomi_trkr_flg");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "preset_vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,   true,	 "bkg_tro_no");
				InitDataProperty(0, cnt++ , dtCheckBox,   0,	daCenter,   true,	 "rejected_check");
				InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,   true,	 "cntr_wgt");
				InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,   true,	 "wgt_meas_ut_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_ofc_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_desc");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_cust_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "n3pty_bzc_curr_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "curr_cd");		
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "apnt_dt");		
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "de_dt");				
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "fm_nod_cd");		
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "to_nod_cd");
				//conti_cd 항목 추가 2012.04.04 kbj
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "conti_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "po_agmt_rt_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,  	daCenter,	false,   "po_agmt_upd_dt");
				InitDataProperty(0, cnt++ , dtHidden,	  50,  	daCenter,	false,   "agmt_mor_cnddt_aply_flg");
				InitDataProperty(0, cnt++ , dtHidden,	  50,  	daCenter,	false,   "sc_no"); 
				InitDataProperty(0, cnt++ , dtHidden,	  50,  	daCenter,	false,   "rfa_no"); 

				//InitDataProperty(0, cnt++,  dtData,	 	 100,   daCenter,  true,    "sht_seq_no");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,   true,    "cre_dt",			false,		"",		dfNone,		0,	false,		false,	    15, false, true);
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "wy_tp_cd");   //-- new
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "cust_nomi_trkr_flg");   //-- new
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "rail_ssvc_tp_cd");   //-- new
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "wtr_de_term");   //-- new
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "cust_cnt_cd");   //-- new
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "via_nod_cd");   //-- new
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "dor_nod_cd");   //-- new not yet Vo
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,   true,	 "spot_bid_vndr_info");   //-- new not yet Vo
				
				ColHidden('ibflag')							= true;
				ColHidden('surcharge_key')					= true;
				ColHidden('rejected_check')					= true;
				InitDataCombo(0, 'trsp_rjct_rsn_cd', "Rate Increase by S/P|Power Shortage by S/P|RQST By BKG|TRS Own Reason",  "I|R|B|O");    //	 -- default값으로 TRS Own Reason 설정요구 09.01.19						
				//InitDataCombo(0, 'po_way_type', " |"+po_way_typeText, " |"+po_way_typeCode);
				InitDataCombo(0, 'po_way_type', " |One Way(CY rate)|Round Trip(DR rate)", " |ONE|RND");
				InitDataCombo(0, 'po_local_curr_cd', po_local_curr_cdText, po_local_curr_cdCode);
				ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
//				IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), docObjects[0], false);

				SetMergeCell(0,13,2,2);
				SetMergeCell(0,15,2,2);				
				SetMergeCell(0,17,2,2);
				SetMergeCell(0,19,2,2);
				
//				SetMergeCell(0,29,2,2);
//				SetMergeCell(0,31,2,2);
//				SetMergeCell(0,33,2,2);				
//				SetMergeCell(0,92,2,2);
//				SetMergeCell(0,94,2,2);	
				
				SetMergeCell(0,31,2,2);
				SetMergeCell(0,33,2,2);
				SetMergeCell(0,35,2,2);

				SetMergeCell(0,112+(spot_bid_vndr_cnt*6),2,2);
				SetMergeCell(0,114+(spot_bid_vndr_cnt*6),2,2);
			}
			break;

		case 2: //surcharge sheet
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = 0;

//				style.height = GetSheetHeight(12);
//				//전체 너비 설정
//				SheetWidth = hiddenTable1.clientWidth;
        
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(80, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "ibflag|ibcheck|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|trsp_step_tp_cd" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,30,daCenter,	false,	prefix+"ibflag");
				InitDataProperty(0, cnt++,dtCheckBox,30,daCenter,	false,	prefix+"ibcheck");
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'unique_cd'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'trsp_so_seq'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'lgs_cost_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'lgs_cost_full_nm'       ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_step_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'scg_amt'                ,false,"",dfNone,0,true,true);
//				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'chss_mgst_tpsz_cd'      ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_no'			    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incur_dt'      			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        ,false,"",dfNone,0,true,true);

				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_hndl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'rf_mgst_usg_flg'		,false,"",dfNone,0,true,true);

				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'           ,false,"",dfNone,0,true,true);
				
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'grs_wgt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'wo_grs_wgt_meas_ut_cd'  ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'tri_axl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'ovr_wgt_otr_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'ovr_wgt_rmk'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              ,false,"",dfNone,0,true,true);
				//InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'ob_bkg_no_split'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'wt_hrs'		            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'otr_rmk'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'inv_scg_amt'			,false,"",dfNone,0,true,true);
//				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_chss_mgst_tpsz_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'inv_chss_no'			    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incur_dt'      			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fne_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fumg_cost_tp_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_mgst_tpsz_cd'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_knt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_stop_loc_nod_cd'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_hndl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'inv_grs_wgt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'inv_grs_wgt_meas_ut_cd'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_tri_axl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 40,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'		,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'			,false,"",dfNone,0,true,true);
				//InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'n3pty_bil_flg'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_cnt_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_seq'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_vndr_seq'         ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_ofc_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_amt'              ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_desc'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_curr_cd'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_agmt_bfr_extd_flg' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_ofc_cd'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_usr_id'             ,false,"",dfNone,0,true,true);
		   
		   }
		   break;
		   
		case 3: //wo issued so no sheet
				with (sheetObj) {
				// 높이 설정
				style.height = 0;
//				//전체 너비 설정
				SheetWidth = 0;
        
//				style.height = GetSheetHeight(13);
//				//전체 너비 설정
//				SheetWidth = hiddenTable2.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(2, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "OFC_CD|SO_SEQ" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(1, HeadTitle, false, false);
				HeadRowHeight = 30;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false, 'trsp_so_ofc_cty_cd'     ,false,"",dfNone,0,false,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false, 'trsp_so_seq'            ,false,"",dfNone,0,false,true);

		   }
		   break;			   
		 case 4:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				cnt = 0;
				style.height = 0;
				SheetWidth =0;
				//전체 너비 설정
//				SheetWidth = hiddenTable3.clientWidth;
			
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;
			
			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;
			
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);
			
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(29, 0, 0, true);
			
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);
			
				var HeadTitle = "|trsp_so_ofc_cty_cd_seq|po_trsp_agmt_ofc_cty_cd|po_trsp_agmt_seq|po_trsp_agmt_rt_tp_cd|po_way_type" +
						        "|po_trsp_agmt_rt_tp_nm|po_sp_type|po_cust_nomi_trkr_flg|po_cust_cnt_cd|po_cust_seq|po_cust_cnt_cd_seq" +
						        "|po_local_curr_cd|po_wtr_rcv_term_cd|po_wtr_de_term_cd|po_basic_rt|po_fuel_scg_rt|po_over_wgt_scg_rt" +
						        "|po_local_curr_tot_amt|po_usd_curr_tot_amt|po_rtn_cd|po_rtn_msg|po_vat_scg_rt|po_scg1_rt|toll_fee_amt|po_scg3_rt" +
						        "|po_cfm_flg|po_agmt_rt_seq|po_agmt_upd_dt";
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
			
				//데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus, 150,	 daCenter,	 false,	   "ibflag"					);
			                                                                       
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "trsp_so_ofc_cty_cd_seq"	);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_trsp_agmt_ofc_cty_cd");
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_trsp_agmt_seq"		);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_trsp_agmt_rt_tp_cd"	);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_way_type"			);
				                                                                   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_trsp_agmt_rt_tp_nm"	);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_sp_type"				);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_cust_nomi_trkr_flg"	);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_cust_cnt_cd"			);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_cust_seq"			);
				                                                                   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_cust_cnt_cd_seq"		);  
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_local_curr_cd"		);
				InitDataProperty(0, cnt++ , dtData,   130,   daCenter,    false,   "po_wtr_rcv_term_cd"		);     
				InitDataProperty(0, cnt++ , dtData,   130,   daCenter,    false,   "po_wtr_de_term_cd"		);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_basic_rt"			);
				                                                                   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_fuel_scg_rt"			);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_over_wgt_scg_rt"		);  
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_local_curr_tot_amt"	);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_usd_curr_tot_amt"	);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_rtn_cd"				);  
                                                                                   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_rtn_msg"				);  
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_vat_scg_rt"			);
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_scg1_rt"				);   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "toll_fee_amt"			);   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_scg3_rt"				);
				                                                                   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_cfm_flg"				);   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_agmt_rt_seq"			);   
				InitDataProperty(0, cnt++,  dtData,	  130,    daCenter,   false,   "po_agmt_upd_dt"			);   
			   }
			   break;
		   
	}
}

function sheet_OnPopupClick (sheetObj , row , col )
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{
		case('more_candidates'):

			if ( sheetObj.CellValue(row, 'mcntr_bdl_grp_seq') != null && sheetObj.CellValue(row, 'mcntr_bdl_grp_seq') != "" ){
				if ( sheetObj.CellValue(row, 'mcntr_bdl_seq') != "1" ){
					break;
				}
			}
		
			var url = '?targetRow='+row;
			url += '&trsp_so_ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
			url += '&trsp_so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
			url += '&ctrl_ofc_cd='+sheetObj.CellValue(row, 'cre_ofc_cd');
			url += '&vndr_seq='+sheetObj.CellValue(row, 'preset_vndr_seq');
			url += '&basis_dt='+sheetObj.CellValue(row, 'so_cre_dt');
			url += '&eq_knd_cd='+sheetObj.CellValue(row, 'eq_knd_cd');
			url += '&eq_tp_sz_cd='+sheetObj.CellValue(row, 'eq_tpsz_cd');
			url += '&cmb_tp_cd='+sheetObj.CellValue(row, 'trsp_so_cmb_tp_cd');
			url += '&cgo_tp_cd='+sheetObj.CellValue(row, 'cgo_tp_cd');
			url += '&bound_cd='+sheetObj.CellValue(row, 'trsp_bnd_cd');
			url += '&crr_mod_cd='+sheetObj.CellValue(row, 'trsp_crr_mod_cd');
			url += '&cost_mod_cd='+sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd');
			url += '&cust_cnt_cd='+sheetObj.CellValue(row, 'po_cust_cnt_cd');
			url += '&cust_seq='+sheetObj.CellValue(row, 'po_cust_seq');
			url += '&cmdt_cd='+sheetObj.CellValue(row, 'cmdt_cd');
			url += '&from_nod_cd='+sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
			url += '&via_nod_cd='+sheetObj.CellValue(row, 'via_loc_value')+sheetObj.CellValue(row, 'via_yard_value');
			url += '&door_nod_cd='+sheetObj.CellValue(row, 'dor_loc_value')+sheetObj.CellValue(row, 'dor_yard_value');
			url += '&to_nod_cd='+sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
			url += '&bundle_cnt='+sheetObj.CellValue(row, 'bundling_no');
			url += '&wgt_uom='+sheetObj.CellValue(row, 'wgt_meas_ut_cd');
			url += '&wgt_qty='+sheetObj.CellValue(row, 'cntr_wgt');
			url += '&dist_km='+sheetObj.CellValue(row, 'distance');
			url += '&dist_mile='+sheetObj.CellValue(row, 'distance_uom');
			url += '&agmt_ofc_cty_cd='+sheetObj.CellValue(row, 'agmt_ofc_cty_cd');
			url += '&agmt_seq='+sheetObj.CellValue(row, 'agmt_seq');
			url += '&way_type='+sheetObj.CellValue(row, 'po_way_type');

//			window.open('ESD_TRS_0921.do'+url ,'','toolbar=no,scrollbars=no,width=1000,height=460');
            ComOpenWindow('ESD_TRS_0921.do'+url, 'ESD_TRS_0921', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:1000px;dialogHeight:500px', true);

			break;

		case('n3pty_bil_flg'):
			pop3rdPartyBilling(sheetObj, row, col, 'modify');
		break;

		case('etc_add_amt'):
			popSurchargeInputInquiry(sheetObj, row, col, 'modify', 'WO');
		break;


		case('mlt_stop_de_flg'):
			var myOption = "dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
			var lvbkg = sheetObj.CellValue(row, "bkg_no");
			var lvbl = sheetObj.CellValue(row, "bl_no");
			var lveq = sheetObj.CellValue(row, "eq_no");
			var lvts = sheetObj.CellValue(row, "eq_tpsz_cd");
			var lvtro = sheetObj.CellValue(row, "tro_seq");

			if(lvbkg != '' && lvbl != '' && lveq != '' && lvts != '' && sheetObj.CellValue(row, 'mlt_stop_de_flg') == 'Y') {
				var url = "ESD_TRS_0933.do?bkgnumber="+lvbkg+"&blnumber="+lvbl+"&cntrnumber="+lveq+"&tpsznumber="+lvts+"&troseqnumber="+lvtro;
				window.showModalDialog(url, window, myOption);
			}
		break;

		case('spcl_cgo_cntr_tp_cd'):
			//special cargo 팝업 변경 2012.03.27 kbj
			var myOption = "dialogWidth:800px; dialogHeight:407px; help:no; status:no; resizable:no; scroll=no; ";
			var lvbkg = sheetObj.CellValue(row, "bkg_no");
			var lveqno = sheetObj.CellValue(row, "eq_no");
			var lvtro_seq = sheetObj.CellValue(row, "tro_seq");
			var lvui_conti_cd = sheetObj.CellValue(row, "conti_cd");
			if(lvui_conti_cd != 'E'){
				lvui_conti_cd = '';
			}
			if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'DG' ) {
				var url = "ESD_TRS_0938.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'BB' ) {
				var url = "ESD_TRS_0937.do?bkg_no="+lvbkg;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'AK' ) {
				var url = "ESD_TRS_0936.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'RF' ) {
				var url = "ESD_TRS_0935.do?bkg_no="+lvbkg+"&cntr_no="+lveqno+"&tro_seq="+lvtro_seq+"&ui_conti_cd="+lvui_conti_cd;
				window.showModalDialog(url, window, myOption);
			} else if( sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd") == 'HG' ) {
				var url = "ESD_TRS_0932.do?bkg_no="+lvbkg;
				window.showModalDialog(url, window, myOption);
			}
		break;
		
		case('ctrt_cnt'):
			var myOption = "dialogWidth:450px; dialogHeight:360px; help:no; status:no; resizable:no; scroll=no; ";
			var url = "";
		    var sc_no  		 = sheetObj.CellValue(row,"sc_no");
		    var rfa_no 		 = sheetObj.CellValue(row,"rfa_no");
		    var vndr_seq 	 = sheetObj.CellValue(row,"vndr_seq");
		    var trsp_bnd_cd  = sheetObj.CellValue(row,"trsp_bnd_cd");
		    var fm_nod_cd    = sheetObj.CellValue(row,"fm_loc_value");
		    var fm_nod_yard  = sheetObj.CellValue(row,"fm_yard_value");
		    var to_nod_cd    = sheetObj.CellValue(row,"to_loc_value");
		    var to_nod_yard  = sheetObj.CellValue(row,"to_yard_value");
		    var dor_nod_cd   = sheetObj.CellValue(row,"dor_loc_value");
		    var dor_nod_yard = sheetObj.CellValue(row,"dor_yard_value");
		    var ctrl_ofc_cd  = sheetObj.CellValue(row,"cre_ofc_cd");
		    var vndr_seq     = sheetObj.CellValue(row,"vndr_seq");
			if(sheetObj.CellValue(row,"ctrt_cnt") !="0"){
				url="ESD_TRS_0980.do"
				   +"?sc_no="+sc_no
				   +"&rfa_no="+rfa_no
				   +"&trsp_bnd_cd="+trsp_bnd_cd
				   +"&ctrl_ofc_cd="+ctrl_ofc_cd
				   +"&fm_nod_cd="+fm_nod_cd
				   +"&fm_nod_yard="+fm_nod_yard
				   +"&to_nod_cd="+to_nod_cd
				   +"&to_nod_yard="+fm_nod_yard
				   +"&dor_nod_cd="+dor_nod_cd
				   +"&dor_nod_yard="+dor_nod_yard
				   +"&chk_row="+row+"|"
				   +"&vndr_seq="+vndr_seq
				   +"&scrn_mode=G"
				   ;
				window.showModalDialog(url, window, myOption);
//				myWin = window.open(url, "CNT", myOption);
//				myWin.focus();
			}
		break;
		case('spot_bid_vndr_cnt'):

			if(sheetObj.CellValue(row, 'spot_bid_vndr_cnt') > spot_bid_vndr_cnt || sheetObj.CellValue(row, 'spot_bid_vndr_cnt') == "Y"){

				var url = '?targetRow='+row;
				/*url += '&trsp_so_ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
				url += '&trsp_so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
				url += '&ctrl_ofc_cd='+sheetObj.CellValue(row, 'cre_ofc_cd');
				url += '&vndr_seq='+sheetObj.CellValue(row, 'preset_vndr_seq');
				url += '&basis_dt='+sheetObj.CellValue(row, 'so_cre_dt');
				url += '&eq_knd_cd='+sheetObj.CellValue(row, 'eq_knd_cd');
				url += '&eq_tp_sz_cd='+sheetObj.CellValue(row, 'eq_tpsz_cd');
				url += '&cmb_tp_cd='+sheetObj.CellValue(row, 'trsp_so_cmb_tp_cd');
				url += '&cgo_tp_cd='+sheetObj.CellValue(row, 'cgo_tp_cd');
				url += '&bound_cd='+sheetObj.CellValue(row, 'trsp_bnd_cd');
				url += '&crr_mod_cd='+sheetObj.CellValue(row, 'trsp_crr_mod_cd');
				url += '&cost_mod_cd='+sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd');
				url += '&cust_cnt_cd='+sheetObj.CellValue(row, 'po_cust_cnt_cd');
				url += '&cust_seq='+sheetObj.CellValue(row, 'po_cust_seq');
				url += '&cmdt_cd='+sheetObj.CellValue(row, 'cmdt_cd');
				url += '&from_nod_cd='+sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
				url += '&via_nod_cd='+sheetObj.CellValue(row, 'via_loc_value')+sheetObj.CellValue(row, 'via_yard_value');
				url += '&door_nod_cd='+sheetObj.CellValue(row, 'dor_loc_value')+sheetObj.CellValue(row, 'dor_yard_value');
				url += '&to_nod_cd='+sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
				url += '&bundle_cnt='+sheetObj.CellValue(row, 'bundling_no');
				url += '&wgt_uom='+sheetObj.CellValue(row, 'wgt_meas_ut_cd');
				url += '&wgt_qty='+sheetObj.CellValue(row, 'cntr_wgt');
				url += '&dist_km='+sheetObj.CellValue(row, 'distance');
				url += '&dist_mile='+sheetObj.CellValue(row, 'distance_uom');
				url += '&agmt_ofc_cty_cd='+sheetObj.CellValue(row, 'agmt_ofc_cty_cd');
				url += '&agmt_seq='+sheetObj.CellValue(row, 'agmt_seq');
				url += '&way_type='+sheetObj.CellValue(row, 'po_way_type');*/
				url += '&spot_bid_no='+sheetObj.CellValue(row, 'spot_bid_no');
				url += '&spot_bid_win_vndr_seq='+sheetObj.CellValue(row, 'spot_bid_win_vndr_seq');
				url += '&spot_bid_sel_row='+row;

	            ComOpenWindow('ESD_TRS_0945.screen'+url, 'ESD_TRS_0945', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:600px;dialogHeight:400px', true);
	            
	    		// Modal 창이 닫힌후 WIN_VNDR_SEQ 값을 찾아서 체크선택 혹은 해제
    			for(var z=1; z<=spot_bid_vndr_cnt; z++){
    				if(sheetObj.CellValue(row,'spot_bid_win_vndr_seq') == sheetObj.CellValue(row,'spot_bid_vndr_seq_'+z)){
    					sheetObj.CellValue2(row,'spot_bid_vndr_sel_'+z) = 1;
    				}else{
    					sheetObj.CellValue2(row,'spot_bid_vndr_sel_'+z) = 0;
    				}
    			}
			}

			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:      //조회
		
			if(formObj.fmdate.value == '' || formObj.todate.value == ''){
				if(formObj.tvvd_no.value == '' && formObj.fvvd_no.value == ''
					&& formObj.bkg_no.value == '' && formObj.bl_no.value == ''
					&& formObj.eq_no.value == '' && formObj.so_no.value == ''
					&& formObj.wo_no.value == '' && formObj.mty_rfrn_no.value == '' && formObj.spot_bid_no.value == ''){
					ComShowCodeMessage("TRS90124");
					return false;
				}
			}

			//날짜 Validation 추가 2013.11.13 조인영
			var frmdate_trim = ComTrimAll(ComTrimAll(formObj.fmdate.value, " "), "-");
			if( frmdate_trim != "" ) { //날짜 체크하는 부분
				if( !ComIsDate(frmdate_trim) ) {
					ComShowCodeMessage("TRS90070");
					formObj.fmdate.focus();
					return false;
				}
			}
			var todate_trim = ComTrimAll(ComTrimAll(formObj.todate.value, " "), "-");
			if( todate_trim != "" ) { //날짜 체크하는 부분
				if( !ComIsDate(todate_trim) ) {
					ComShowCodeMessage("TRS90070");
					formObj.todate.focus();
					return false;
				}
			}
			var days_between = ComGetDaysBetween(formObj.fmdate , formObj.todate) ;  // 조회 기간
	   		if( days_between   < 0) {
				ComShowCodeMessage("TRS90118");
				formObj.fmdate.focus();
				return false;
			}
			if ( days_between > 30 ) {
				ComShowMessage(" Possible inquiry period is limited to 1 month.");
				return false;
			}
			
			formObj.f_cmd.value = SEARCH;
			processFlag = true;
			formObj.wo_radio[0].disabled = true;
			formObj.wo_radio[1].disabled = true; 
			sheetObj.DoSearch4Post("ESD_TRS_0091GS.do", TrsFrmQryString(formObj));
			processFlag = false;
			formObj.wo_radio[0].disabled = false;
			formObj.wo_radio[1].disabled = false;
			break;

		case IBSAVE:        //저장
			
			processFlag = true;
			if(!validateForm(sheetObjects[0],formObj,sAction)) {
				processFlag = false;
				return false;
			}

			document.woForm.reset();

//			addSurchargeData();
			
			if(sheetObj.RowCount > 0) {
				formObj.f_cmd.value = ADD;
				var surchargeQuery = sheetObj.GetSaveString(true, false);
				sheetObj.DoSearch4Post('ESD_TRS_0918GS.do', surchargeQuery+'&'+TrsFrmQryString(formObj));
				
			}else{
				gotoPreview(sheetObjects[0],formObj);
			}				
			processFlag = false;
			break;
			
		case IBDOWNEXCEL:	//엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;

		case IBINSERT:      // 입력
			sheetObj.DataInsert();
			break;
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');

		if(formObj.f_cmd.value == MULTI01){
			for(var i=0; i<checkArray.length-1; i++)	{
				sheetObj.CellValue2(checkArray[i], 'trsp_frst_flg')='Y';
			}
			ComShowCodeMessage('COM12156', 'Frustrate');
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	
	if( errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH || formObj.f_cmd.value == SEARCH01) {
			for(var i =2; i<sheetObj.RowCount+2; i++){
				if(sheetObj.CellValue(i, 'po_local_curr_cd') == 'JPY' || sheetObj.CellValue(i, 'po_local_curr_cd') == 'KRW' || sheetObj.CellValue(i, 'po_local_curr_cd') == 'TWD'){
					setDecimalType(sheetObj, i);
				}else{
					setFloatingType(sheetObj, i);
				}
				
				if(sheetObj.CellValue(i,'trsp_bnd_cd') == 'I'){
					//sheetObj.CellEditable(i,'appo_time_dt') = true;
					//sheetObj.CellEditable(i,'appo_time_hms') = true;
					//sheetObj.CellEditable(i,'deli_time_dt') = true;
					//sheetObj.CellEditable(i,'deli_time_hms') = true;					
				}else{
					//sheetObj.CellEditable(i,'appo_time_dt') = false;
					//sheetObj.CellEditable(i,'appo_time_hms') = false;
					//sheetObj.CellEditable(i,'deli_time_dt') = false;
					//sheetObj.CellEditable(i,'deli_time_hms') = false;					
				}

				// Spot Bid Vndr
				var spot_bid_vndr_info_list = sheetObj.CellValue(i, 'spot_bid_vndr_info');
				if( !(spot_bid_vndr_info_list == null || spot_bid_vndr_info_list == "") ){
					var spot_bid_vndr_info_lists = spot_bid_vndr_info_list.split("##");
					for(var z=1; z<=spot_bid_vndr_cnt; z++){
						if(spot_bid_vndr_info_lists.length >= z){
							var spot_bid_vndr_info = spot_bid_vndr_info_lists[z-1].split("^^");
							if(document.form.wo_radio[0].checked == true) sheetObj.CellEditable(i,'spot_bid_vndr_sel_'+z) = true;
							sheetObj.CellValue(i,'spot_bid_vndr_seq_'+z) 	= spot_bid_vndr_info[0];
							sheetObj.CellValue(i,'spot_bid_vndr_nm_'+z)  	= spot_bid_vndr_info[1];
							sheetObj.CellValue(i,'spot_bid_curr_cd_'+z)  	= spot_bid_vndr_info[2];
							sheetObj.CellValue(i,'spot_bid_amt_'+z)      	= spot_bid_vndr_info[3];
							sheetObj.CellValue(i,'spot_bid_usd_amt_'+z)     = spot_bid_vndr_info[4];
						}
					}
				}
				
				// More Bidder
				if(sheetObj.CellValue(i, 'spot_bid_vndr_cnt') > spot_bid_vndr_cnt){
					sheetObj.CellValue(i, 'spot_bid_vndr_cnt') = "Y";
				}else{
					sheetObj.CellValue(i, 'spot_bid_vndr_cnt') = "N";
				}

				if(!document.form.wo_radio[0].checked == true){
					sheetObj.CellEditable(i, 'spot_bid_vndr_cnt') = false;
				}
			}
			
			var scgXml = sheetObj.EtcData("scgXml");
			if( scgXml == undefined || ComTrim(scgXml) == ''){
				sheetObjects[1].RemoveAll();
				return;
			}
			scgXml = scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
			scgXml = scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
			sheetObjects[1].LoadSearchXml(scgXml);
//			setUniqueCd(sheetObj, sheetObjects[1]);
			sheetObj.RemoveEtcData();
		}
	}
}

function setUniqueCd(main_sheetObj, scg_sheetObj){

	var uni_cd = null;
	var idx = -1;
	var before_uni_cd = null;

	for(var i=1; i<scg_sheetObj.RowCount+1; i++){
		uni_cd = scg_sheetObj.CellValue(i, prefix+'trsp_so_seq');
		
		if( before_uni_cd != uni_cd || idx == -1 ){
			idx = main_sheetObj.FindText('trsp_so_seq', uni_cd);
		}

		if(idx != -1){
			scg_sheetObj.CellValue2(i, prefix+'unique_cd') = main_sheetObj.CellValue(idx, 'surcharge_key');
		}
		before_uni_cd = uni_cd;
	}

}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		var formObj = document.form;
		if(formObj.f_cmd.value == ADD){
			document.woForm.scg_grp_seq.value = sheetObj.EtcData('scg_grp_seq');
			gotoPreview(sheetObjects[0],formObj);
		}
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction) {
	
	var surcharge_sheetObj = sheetObjects[1];

	switch(sAction) {
			case IBSAVE:
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');

				for(var i=0; i<checkArray.length-1; i++)
				{
					/*if(sheetObj.CellValue(checkArray[i], 'vndr_seq') == undefined || ComTrim(sheetObj.CellValue(checkArray[i], 'vndr_seq')) == ''){
						ComShowCodeMessage('TRS90099');
						sheetObj.SelectCell(checkArray[i], 'vndr_seq');
						return false;
					}else *//*if(sheetObj.CellValue(checkArray[i], 'po_local_curr_cd') == undefined || ComTrim(sheetObj.CellValue(checkArray[i], 'po_local_curr_cd')) == ''){
						ComShowCodeMessage('TRS90228');
						sheetObj.SelectCell(checkArray[i], 'po_local_curr_cd');
						return false;
					}*//*else if(sheetObj.CellValue(checkArray[i], 'po_local_curr_tot_amt') == undefined || ComTrim(sheetObj.CellValue(checkArray[i], 'po_local_curr_tot_amt')) == '0'){
						ComShowCodeMessage('TRS90222');
						sheetObj.SelectCell(checkArray[i], 'po_local_curr_tot_amt');
						return false;
					}*//*else*/ if(sheetObj.CellValue(checkArray[i], 'cancel_check') == '1' &&
								sheetObj.CellValue(checkArray[i], 'trsp_frst_flg') == 'Y' &&
								!confirm(ComGetMsg('TRS90231'))) {
						sheetObj.SelectCell(checkArray[i], 'trsp_frst_flg');
						return false;
					}else if(sheetObj.CellValue(checkArray[i], 'cancel_check') == '1' &&
								sheetObj.CellValue(checkArray[i], 'trsp_rjct_rsn_cd') == ''){
						ComShowCodeMessage('TRS90232');
						sheetObj.SelectCell(checkArray[i], 'trsp_rjct_rsn_cd');
						return false;
					}
					/* Surcharge Validation 기능 로직 이상으로 주석처리함 2009.01.15	*/
//					   else if(sheetObj.CellValue(checkArray[i], 'etc_add_amt') != '' ||
//								Number(sheetObj.CellValue(checkArray[i], 'etc_add_amt')) != 0 ) {
//						var unique_cd = sheetObj.CellValue(checkArray[i], 'surcharge_key');
//						var sum = 0;
//						for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
//						{
//							
//							if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd)
//								sum += Number(surcharge_sheetObj.CellValue(a, prefix+'scg_amt'));
//						}
//
//						if(sum != Number(deleteComma(sheetObj.CellValue(checkArray[i], 'etc_add_amt')))){
//							ComShowCodeMessage('COM12114', 'Additional Etc Amount'
//							+' (S/O No:'+sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd')
//							+sheetObj.CellValue(checkArray[i], 'trsp_so_seq')
//							+')'	
//							));
//							
//
//							sheetObj.CellValue(checkArray[i], 'etc_add_amt') = 0;
//							for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
//							{
//								if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
//							}
//							searchLocalCurr2UsdCurr(sheetObj, formObj, checkArray[i]);
//							return false;
//						}
//					}
				}
			break;
	}
	return true;
}

function setWOIssue(selObj)
{
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	if(selObj.name == 'wo_radio'){
		if(sheetObj.RowCount>0 && wo_radio_check == '0' && formObj.wo_radio[1].checked)
		{
			if(confirm(ComGetMsg('TRS90230')))
			{
				sheetObj.RemoveAll();
				wo_radio_check = '1';
			}else{
				formObj.wo_radio[0].checked = true;
				wo_radio_check = '0';
				return;
			}
		}else if(sheetObj.RowCount>0 && wo_radio_check == '1' && formObj.wo_radio[0].checked)
		{
			if(confirm(ComGetMsg('TRS90230')))
			{
				sheetObj.RemoveAll();
				wo_radio_check = '0';
			}else{
				formObj.wo_radio[1].checked = true;
				wo_radio_check = '1';
				return;
			}
		}

		if(wo_radio_check == '0' && formObj.wo_radio[1].checked)
		{
			sheetObj.RemoveAll();
			wo_radio_check = '1';
			initSheet(sheetObj,1);
		}else if(wo_radio_check == '1' && formObj.wo_radio[0].checked){
			sheetObj.RemoveAll();
			wo_radio_check = '0';
			initSheet(sheetObj,1);
		}

		/*if(formObj.wo_radio[0].checked && formObj.dt_radio[3].checked) {
			formObj.dt_radio[2].checked = true;
		}*/

		initSheet(sheetObj,1);
	}

	if(selObj.value == 'N'){
		//formObj.dt_radio[3].disabled = true;
		formObj.wo_no.value = '';
		formObj.wo_no.readOnly = true;
		//formObj.cnt_flg.disabled = false;
		//document.all.Bundling.style.display = "";	
		//document.all.Currnego.style.display = "none";	
	    //document.all.SpSelect.style.display = "";
	}else if(selObj.value == 'Y'){
		//formObj.dt_radio[3].disabled = false;
		formObj.wo_no.readOnly = false;
		//formObj.cnt_flg.value = "";
		//formObj.cnt_flg.disabled = true;
		//document.all.Bundling.style.display = "none";	
		//document.all.Currnego.style.display = "";
		//document.all.SpSelect.style.display = "none";	
	}
	
	gubunApptDeli(cnt_cd);
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick()
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

function getCalendar(){
	var cal2 = new ComCalendarFromTo();
	cal2.displayType = "date";
	cal2.select(document.form.fmdate,document.form.todate,'yyyyMMdd');
}

/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	var obj = eval('document.form.'+x1.substring(x1.indexOf('btns_')+5));
	obj.value = rowArray;
	if(obj.name == 'eq_no') {
		checkDigit(obj);
	}
}

/**
 * sheet의 OnChange 이벤트 정의
 */
function sheet_OnChange(sheetObj, row, col, value)
{
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	var std = 1;
	var wo_cd_src = '';
	var wo_cd_tgt = '';
	
	switch(colName)
	{
		case('ibcheck'):
			
			if(document.form.wo_radio[1].checked){
				wo_cd_src = sheetObj.CellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.CellValue(row, 'trsp_wo_seq');
				for(var i=2;i<sheetObj.RowCount+2; i++){
					wo_cd_tgt = sheetObj.CellValue(i, 'trsp_wo_ofc_cty_cd')+sheetObj.CellValue(i, 'trsp_wo_seq');
					if(wo_cd_src == wo_cd_tgt) sheetObj.CellValue2(i, col) = value;
				}
			}else{
				wo_cd_src = ComTrim(sheetObj.CellValue(row, 'trsp_so_cmb_seq'));
				if(wo_cd_src.length > 0){
					for(var i=2;i<sheetObj.RowCount+2; i++){
						wo_cd_tgt = sheetObj.CellValue(i, 'trsp_so_cmb_seq');
						if(wo_cd_src == wo_cd_tgt) sheetObj.CellValue2(i, col) = value;
					}
				}
			}

			if( sheetObj.CellValue(row, 'mcntr_bdl_grp_seq') != "" && sheetObj.CellValue(row, 'mcntr_bdl_grp_seq') != null ){
				for(var j=2;j<sheetObj.RowCount+2; j++){
					if ( sheetObj.CellValue(row, 'mcntr_bdl_grp_seq') == sheetObj.CellValue(j, 'mcntr_bdl_grp_seq')) {
						sheetObj.CellValue2(j, col) = value;
					}
				}
			}
			break;

		case('cancel_check'):

			if(sheetObj.CellValue(row, 'cancel_check') == 1){
				sheetObj.CellValue2(row,  'trsp_rjct_rsn_cd') = 'O';
//				break;
			}
			if(sheetObj.CellValue(row, 'mty_rr_flg') == 'Y'){
				ComShowCodeMessage('TRS90354');
				sheetObj.CellValue2(row,  'cancel_check') = 0;
				sheetObj.CellValue2(row,  'trsp_rjct_rsn_cd') = '';
				break;
			}
				
			wo_cd_src = ComTrim(sheetObj.CellValue(row, 'trsp_so_cmb_seq'));
			for(var i=2;i<sheetObj.RowCount+2; i++)
			{
				wo_cd_tgt = sheetObj.CellValue(i, 'trsp_so_cmb_seq');
				if(row==i || (wo_cd_src != '' && wo_cd_src == wo_cd_tgt)){
					if(value == 0 && sheetObj.CellValue(i, 'rejected_check')==1){
						sheetObj.CellValue2(i,  'rejected_check') = value;
					}

					if(value == 0){
						sheetObj.CellValue2(i,  'trsp_rjct_rsn_cd') = '';
					}
					sheetObj.CellValue2(i,  'cancel_check') = value;
				}
			}
			break;

		case('trsp_rjct_rsn_cd'):
			if(value != '' && sheetObj.CellValue(row, 'cancel_check') == 0){
				sheetObj.CellValue2(row, 'trsp_rjct_rsn_cd') = '';
				sheetObj.SelectCell(row, 'cancel_check');
				ComShowCodeMessage('TRS90221');
			}else if(value == 'R'){
				sheetObj.CellValue2(row, 'rejected_check') = '1';
			}else{
				sheetObj.CellValue2(row, 'rejected_check') = '0';
			}

//			if(value == 'B') ComShowCodeMessage('TRS90342');
			if(value == 'B') ComShowCodeMessage('TRS90400');
			break;

		case('po_local_curr_cd'):
			if(value == 'JPY' || value == 'KRW' || value == 'TWD') {
				setDecimalType(sheetObj, row);
			}else{
				setFloatingType(sheetObj, row);
			}
			searchLocalCurr2UsdCurr(sheetObj, formObj, row);
			break;

		case('nego_amt'):

			searchLocalCurr2UsdCurr(sheetObj, formObj, row);
		    valueDuplicate(colName, row, 'on');

			break;
		case('etc_add_amt'):
			if(value== '' || Number(value)==0){
				var surcharge_sheetObj = sheetObjects[1];
				// unique_cd가 정상적으로 넘어오지 않아서 trsp_so_seq로 대체해서 사용하는 걸로 파악되므로
				var unique_cd = sheetObj.CellValue(row, 'trsp_so_seq');

				// 이전에 세팅됐던 값은 지워버린다.
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
				}
				sheetObj.CellValue(row, 'n3pty_bil_flg')='';
			}else{
				var surcharge_sheetObj = sheetObjects[1];
				var unique_cd = sheetObj.CellValue(row, 'trsp_so_seq');
				var sum = 0;
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd)
						sum += Number(surcharge_sheetObj.CellValue(a, prefix+'scg_amt'));
				}

				if(sum != Number(deleteComma(value))){
					ComShowCodeMessage('COM12114', 'Additional Etc Amount');
					sheetObj.CellValue2(row, 'etc_add_amt') = 0;
					for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
					{
						if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
					}
				}
			}
			searchLocalCurr2UsdCurr(sheetObj, formObj, row);
			break;

		case('n3pty_bil_flg'):
			if(value== ''){
				var surcharge_sheetObj = sheetObjects[1];
				var unique_cd = sheetObj.CellValue(row, 'surcharge_key');
				// 이전에 세팅됐던 값은 지워버린다.
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd){
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_bil_flg')	= '';
						surcharge_sheetObj.CellValue2(a, prefix+'cust_cnt_cd')		= '';
						surcharge_sheetObj.CellValue2(a, prefix+'cust_cnt_cd')		= '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_vndr_seq')	= '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_ofc_cd')	= '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_amt')		= '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_desc')		= '';
					}
				}
			}
			break;
	}
	
	// Bid Group Check
	if(colName.match("spot_bid_vndr_sel_")){
		// 체크가 이루어지면 기존 체크는해제 하고 선택된 내용을 Bid Winner Cell 에 값을 입력한다.
		for(var z=1; z<=spot_bid_vndr_cnt; z++){

			// 지금선택된 Cell이라면 삭제 하지 않는다.
			if(!colName.match(z)){
				sheetObj.CellValue2(row,'spot_bid_vndr_sel_'+z) = 0;
			}else{
				// Bid Winner Cell 에 값 입력
				if(value == 1){
					sheetObj.CellValue(row,'spot_bid_win_vndr_seq') 	= sheetObj.CellValue(row,'spot_bid_vndr_seq_'+z);
					sheetObj.CellValue(row,'spot_bid_win_vndr_nm')  	= sheetObj.CellValue(row,'spot_bid_vndr_nm_'+z);
					sheetObj.CellValue(row,'spot_bid_win_curr_cd')  	= sheetObj.CellValue(row,'spot_bid_curr_cd_'+z);
					sheetObj.CellValue(row,'spot_bid_win_amt')      	= sheetObj.CellValue(row,'spot_bid_amt_'+z);
					sheetObj.CellValue(row,'spot_bid_win_usd_amt')      = sheetObj.CellValue(row,'spot_bid_usd_amt_'+z);
				}else{
					sheetObj.CellValue(row,'spot_bid_win_vndr_seq') 	= "";
					sheetObj.CellValue(row,'spot_bid_win_vndr_nm')  	= "";
					sheetObj.CellValue(row,'spot_bid_win_curr_cd')  	= "";
					sheetObj.CellValue(row,'spot_bid_win_amt')      	= "";
					sheetObj.CellValue(row,'spot_bid_win_usd_amt')      = "";
				}
			}
		}
	}
}

function sheet_OnDblClick(sheetObj ,row,col) {
	
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	switch(colName)
	{
		case('nego_amt'):

			searchLocalCurr2UsdCurr(sheetObj, formObj, row);
		    valueDuplicate(colName, row, 'db');

		break;
	}
	
}


function searchLocalCurr2UsdCurr(sheetObj, formObj, row){
//	if(sheetObj == ''){
//		 sheetObj = sheetObjects[0];
//	}
	sheetObj.RemoveEtcData();
	if(sheetObj.CellValue(row, 'po_local_curr_cd') == '') return; 
	var url = 'LOCAL_TOT_AMT='+sheetObj.CellValue(row, 'po_local_curr_tot_amt');
	url += '&CURR_CD='+sheetObj.CellValue(row, 'po_local_curr_cd');
	formObj.f_cmd.value = SEARCH03;
	sheetObj.DoSearch4Post("ESD_TRS_0091GS.do", url+'&'+TrsFrmQryString(formObj), '', true);
	if(sheetObj.EtcData('amt_usd') != undefined && sheetObj.EtcData('amt_usd') != ''){
		sheetObj.CellValue2(row, 'po_usd_curr_tot_amt') = sheetObj.EtcData('amt_usd');
	}
}


function valueDuplicate(col, row, action){

			var formObj2 = document.negoForm;
			var nego_sheetObj= sheetObjects[0];		
			var nego_amt = formObj2.nego_amt.value;
			var insert_nego = nego_sheetObj.CellValue(row,col);

		if(action == 'db'){		
			   nego_sheetObj.CellValue(row,col) = nego_amt;		
		} else if(action == 'on'){	
				formObj2.nego_amt.value = nego_sheetObj.CellValue(row,col);
		}	
}
		



/**
 * 조회조건 reset
 */
function setDecimalType(sheetObj, row){
	sheetObj.InitCellProperty(row, 'po_basic_rt', dtNull, daNull, 'po_basic_rt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'po_fuel_scg_rt', dtNull, daNull, 'po_fuel_scg_rt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'po_vat_scg_rt', dtNull, daNull, 'po_vat_scg_rt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'po_local_curr_tot_amt', dtNull, daNull, 'po_local_curr_tot_amt', '|po_basic_rt|+|po_fuel_scg_rt|+|po_vat_scg_rt|+|toll_fee_amt|', dfInteger, 0);

	sheetObj.CellValue2(row, 'po_basic_rt')				= chkAmtPos_JPY(sheetObj.CellValue(row, 'po_basic_rt'));
	sheetObj.CellValue2(row, 'nego_amt')				= chkAmtPos_JPY(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'po_fuel_scg_rt')			= chkAmtPos_JPY(sheetObj.CellValue(row, 'po_fuel_scg_rt'));
	sheetObj.CellValue2(row, 'po_vat_scg_rt')			= chkAmtPos_JPY(sheetObj.CellValue(row, 'po_vat_scg_rt'));
	sheetObj.CellValue2(row, 'etc_add_amt')				= chkAmtPos_JPY(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'toll_fee_amt')			= chkAmtPos_JPY(sheetObj.CellValue(row, 'toll_fee_amt'));
	sheetObj.CellValue2(row, 'po_local_curr_tot_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'po_local_curr_tot_amt'));

	var surcharge_sheetObj = sheetObjects[1];
	var sur_key = sheetObj.CellValue(row, 'surcharge_key');

	for(var i=1; i<surcharge_sheetObj.RowCount+1; i++){
		if(sur_key == surcharge_sheetObj.CellValue(i, prefix+'unique_cd')){
			
			surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt', dtNull, daNull, prefix+'scg_amt', '', dfInteger, 0);
			surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt', dtNull, daNull, prefix+'n3pty_amt', '', dfInteger, 0);
			
			surcharge_sheetObj.CellValue2(i, prefix+'scg_amt')		= chkAmtPos_JPY(surcharge_sheetObj.CellValue(i, prefix+'scg_amt'));
			surcharge_sheetObj.CellValue2(i, prefix+'n3pty_amt')	= chkAmtPos_JPY(surcharge_sheetObj.CellValue(i, prefix+'n3pty_amt'));
			
		}
	}
}

/**
 * 조회조건 reset
 */
function setFloatingType(sheetObj, row){
	sheetObj.InitCellProperty(row, 'po_basic_rt', dtNull, daNull, 'po_basic_rt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'po_fuel_scg_rt', dtNull, daNull, 'po_fuel_scg_rt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'po_vat_scg_rt', dtNull, daNull, 'po_vat_scg_rt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'toll_fee_amt', dtNull, daNull, 'toll_fee_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'po_local_curr_tot_amt', dtNull, daNull, 'po_local_curr_tot_amt', '|po_basic_rt|+|po_fuel_scg_rt|+|po_vat_scg_rt|+|toll_fee_amt|', dfFloat, 2);

	sheetObj.CellValue2(row, 'po_basic_rt')				= chkAmtPos(sheetObj.CellValue(row, 'po_basic_rt'));
	sheetObj.CellValue2(row, 'nego_amt')				= chkAmtPos(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'po_fuel_scg_rt')			= chkAmtPos(sheetObj.CellValue(row, 'po_fuel_scg_rt'));
	sheetObj.CellValue2(row, 'po_vat_scg_rt')			= chkAmtPos(sheetObj.CellValue(row, 'po_vat_scg_rt'));
	sheetObj.CellValue2(row, 'etc_add_amt')				= chkAmtPos(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'toll_fee_amt')			= chkAmtPos(sheetObj.CellValue(row, 'toll_fee_amt'));
	sheetObj.CellValue2(row, 'po_local_curr_tot_amt')	= chkAmtPos(sheetObj.CellValue(row, 'po_local_curr_tot_amt'));

	var surcharge_sheetObj = sheetObjects[1];
	var sur_key = sheetObj.CellValue(row, 'surcharge_key');

	for(var i=1; i<surcharge_sheetObj.RowCount+1; i++){
		if(sur_key == surcharge_sheetObj.CellValue(i, prefix+'unique_cd')){
			
			surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt', dtNull, daNull, prefix+'scg_amt', '', dfFloat, 2);
			surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt', dtNull, daNull, prefix+'n3pty_amt', '', dfFloat, 2);
			
			surcharge_sheetObj.CellValue2(i, prefix+'scg_amt')		= chkAmtPos(surcharge_sheetObj.CellValue(i, prefix+'scg_amt'));
			surcharge_sheetObj.CellValue2(i, prefix+'n3pty_amt')	= chkAmtPos(surcharge_sheetObj.CellValue(i, prefix+'n3pty_amt'));
			
		}
	}
}


/**
 * 조회조건 reset
 */
function resetSearchCondition(formObj)
{
	//formObj.dt_radio[2].checked = true;
	formObj.fmdate.value = beforeOneMonth;
	formObj.todate.value = today;
	formObj.combo_svc_provider.value = '';
	formObj.svc_provider.value='';
	formObj.wo_no.value = '';
	formObj.trs_cost_md_cd.options[0].selected = true;
	formObj.trs_md_cd.options[0].selected = true;
	formObj.trs_bnd_cd.options[0].selected = true;
}

/*
* 1.125 N200901090011 W/O Issue 화면 보완요청
* /
/**
 * Work Order Preview로 이동
 */
function gotoPreview(sheetObj,formOb)
{
	var cty_cd = '';
	var seq_no = '';
	var cancel_check = '';
	var dtn_use_flg = '';
	var wo_bl_no_iss_flg = '';
	var vndr_seq = '';
	var po_local_curr_cd = '';
	var po_basic_rt = '';
	var nego_amt = '';
	var etc_add_amt = '';
	var toll_fee_amt = '';
	var po_fuel_scg_rt = '';
	var po_vat_scg_rt = '';
	var n3pty_bil_flg = '';
	var po_usd_curr_tot_amt = '';
	
	// GuideLine Rate
	var gline_vndr_seq = '';
	var gline_po_local_curr_cd = '';
	var gline_po_basic_rt = '';
	var gline_nego_amt = '';
	var gline_etc_add_amt = '';
	var gline_toll_fee_amt = '';
	var gline_po_fuel_scg_rt = '';
	var gline_po_vat_scg_rt = '';
	var gline_po_usd_curr_tot_amt = '';
	// GuideLine Rate
	
	var scg_grp_se = '';     
	var	cust_cnt_cd = '';    
	var	cust_seq = '';      
	var	cust_nomi_trkr_flg = '';
	var	trsp_agmt_rt_tp_cd = '';
	var	trsp_agmt_wy_tp_cd = '';
	var	trsp_frst_flg = '';
	var	trsp_rjct_rsn_cd = '';
	var	trsp_dflt_vndr_flg = '';

	var	n1st_nod_pln_dt = '';
	var	lst_nod_pln_dt = '';
	var	dor_nod_pln_dt = '';
	var	inter_rmk = '';
	var	spcl_instr_rmk = '';

	var	FORM_FCTRY_NM = '';
	var	FORM_DOR_PST_CD = '';
	var	FORM_CNTC_PSON_PHN_NO = '';
	var	FORM_CNTC_PSON_FAX_NO = '';
	var	FORM_CNTC_PSON_NM = '';
	
	var	n3pty_cust_cnt_cd = '';
	var	n3pty_cust_seq = '';
	var	n3pty_desc = '';
	var	n3pty_vndr_seq = '';
	var	n3pty_ofc_cd = '';
	var	n3pty_bil_bzc_amt = '';
	var	n3pty_bil_tp_cd = '';
	var	n3pty_curr_cd = '';
	
	var	wtr_rcv_term_cd = '';
	var	wtr_de_term_cd = '';
	var po_trsp_agmt_ofc_cty_cd = '';
	var po_trsp_agmt_seq = '';
	
	var po_cfm_flg = '';
	var po_agmt_rt_seq = '';
	var po_agmt_upd_dt = '';
	
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');

	for(var i=0; i<checkArray.length-1; i++)
	{
		if(i!=0){
			cty_cd += ',';
			seq_no += ',';
			cancel_check += ',';
			dtn_use_flg += ','; 
			wo_bl_no_iss_flg += ',';
			vndr_seq += ',';
			po_local_curr_cd += ',';
			po_basic_rt += ',';
			nego_amt += ',';
			etc_add_amt += ',';
			po_fuel_scg_rt += ',';
			po_vat_scg_rt += ',';
			toll_fee_amt += ',';
			n3pty_bil_flg += ',';
			po_usd_curr_tot_amt += ',';
			
			gline_vndr_seq				+= ',';
			gline_po_local_curr_cd		+= ',';
			gline_po_basic_rt			+= ',';
			gline_nego_amt				+= ',';
			gline_etc_add_amt			+= ',';
			gline_po_fuel_scg_rt		+= ',';
			gline_po_vat_scg_rt			+= ',';
			gline_toll_fee_amt			+= ',';
			gline_po_usd_curr_tot_amt	+= ',';
			
			cust_cnt_cd += ',';  
			cust_seq += ',';     
			cust_nomi_trkr_flg += ',';
			trsp_agmt_rt_tp_cd += ',';
			trsp_agmt_wy_tp_cd += ',';
			trsp_frst_flg += ',';
			trsp_rjct_rsn_cd += ',';
			trsp_dflt_vndr_flg += ',';

			n1st_nod_pln_dt += ',';
			lst_nod_pln_dt += ',';
			dor_nod_pln_dt += ',';
			inter_rmk += ',';
			spcl_instr_rmk += ',';

			FORM_FCTRY_NM += ',';
			FORM_DOR_PST_CD += ',';
			FORM_CNTC_PSON_PHN_NO += ',';
			FORM_CNTC_PSON_FAX_NO += ',';
			FORM_CNTC_PSON_NM += ',';
			
    	    n3pty_cust_cnt_cd += ',';
			n3pty_cust_seq += ',';
			n3pty_desc += ',';
			n3pty_vndr_seq += ',';
			n3pty_ofc_cd += ',';
			n3pty_bil_bzc_amt += ',';
			n3pty_bil_tp_cd += ',';
			n3pty_curr_cd += ',';
			
			wtr_rcv_term_cd += ',';
			wtr_de_term_cd += ',';
			
			po_trsp_agmt_ofc_cty_cd += ',';
			po_trsp_agmt_seq += ',';	
			po_cfm_flg += ',';
			po_agmt_rt_seq += ',';
			po_agmt_upd_dt += ',';
		}
		
		cty_cd				+= sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
		seq_no				+= sheetObj.CellValue(checkArray[i], 'trsp_so_seq');
		cancel_check		+= sheetObj.CellValue(checkArray[i], 'cancel_check');
		dtn_use_flg			+= sheetObj.CellValue(checkArray[i], 'dtn_use_flg');
		wo_bl_no_iss_flg	+= sheetObj.CellValue(checkArray[i], 'wo_bl_no_iss_flg');
		
		// Spot Bid Start
		//vndr_seq			+= sheetObj.CellValue(checkArray[i], 'vndr_seq');
		//po_local_curr_cd	+= getSpace(sheetObj.CellValue(checkArray[i], 'po_local_curr_cd'));
		//po_basic_rt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_basic_rt'),",");
		//nego_amt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'nego_amt'),",");
		//etc_add_amt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'etc_add_amt'),",");
		//po_fuel_scg_rt		+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_fuel_scg_rt'),",");
		//po_vat_scg_rt		+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_vat_scg_rt'),",");
		//toll_fee_amt		+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'toll_fee_amt'),",");
		//n3pty_bil_flg		+= (sheetObj.CellValue(checkArray[i], 'n3pty_bil_flg')=='Y'?'Y':'N');
		//po_usd_curr_tot_amt += ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_usd_curr_tot_amt'),",");

		vndr_seq			+= sheetObj.CellValue(checkArray[i], 'spot_bid_win_vndr_seq');
		po_local_curr_cd	+= getSpace(sheetObj.CellValue(checkArray[i], 'spot_bid_win_curr_cd'));
		po_basic_rt			+= ComTrimAll('0',",");
		nego_amt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'spot_bid_win_amt'),",");
		etc_add_amt			+= ComTrimAll('0',",");
		po_fuel_scg_rt		+= ComTrimAll('0',",");
		po_vat_scg_rt		+= ComTrimAll('0',",");
		toll_fee_amt		+= ComTrimAll('0',",");
		n3pty_bil_flg		+= (sheetObj.CellValue(checkArray[i], 'n3pty_bil_flg')=='Y'?'Y':'N');
		po_usd_curr_tot_amt += ComTrimAll(sheetObj.CellValue(checkArray[i], 'spot_bid_win_usd_amt'),",");

		// Spot Bid End po_usd_curr_tot_amt

		// GuideLine Rate Start
		gline_vndr_seq			+= getSpace(sheetObj.CellValue(checkArray[i], 'vndr_seq'));
		gline_po_local_curr_cd	+= getSpace(sheetObj.CellValue(checkArray[i], 'po_local_curr_cd'));
		gline_po_basic_rt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_basic_rt'),",");
		gline_nego_amt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'nego_amt'),",");
		gline_etc_add_amt			+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'etc_add_amt'),",");
		gline_po_fuel_scg_rt		+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_fuel_scg_rt'),",");
		gline_po_vat_scg_rt		+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_vat_scg_rt'),",");
		gline_toll_fee_amt		+= ComTrimAll(sheetObj.CellValue(checkArray[i], 'toll_fee_amt'),",");
		//gline_n3pty_bil_flg		+= (sheetObj.CellValue(checkArray[i], 'n3pty_bil_flg')=='Y'?'Y':'N');
		gline_po_usd_curr_tot_amt += ComTrimAll(sheetObj.CellValue(checkArray[i], 'po_usd_curr_tot_amt'),",");
		// GuideLine Rate End

		cust_cnt_cd			+= getSpace(sheetObj.CellValue(checkArray[i], 'po_cust_cnt_cd'));
		cust_seq			+= getSpace(sheetObj.CellValue(checkArray[i], 'po_cust_seq'));
		cust_nomi_trkr_flg	+= (sheetObj.CellValue(checkArray[i], 'po_cust_nomi_trkr_flg')=='Y'?'Y':'N');
		trsp_agmt_rt_tp_cd	+= getSpace(sheetObj.CellValue(checkArray[i], 'po_trsp_agmt_rt_tp_cd'));
		trsp_agmt_wy_tp_cd	+= getSpace(sheetObj.CellValue(checkArray[i], 'po_way_type'));

		trsp_frst_flg		+= (sheetObj.CellValue(checkArray[i], 'trsp_frst_flg')=='Y'?'Y':'N');
		trsp_rjct_rsn_cd	+= getSpace(sheetObj.CellValue(checkArray[i], 'trsp_rjct_rsn_cd'));
		trsp_dflt_vndr_flg	+= (sheetObj.CellValue(checkArray[i], 'trsp_dflt_vndr_flg')=='Y'?'Y':'N');

		n1st_nod_pln_dt		+= getSpace(sheetObj.CellValue(checkArray[i], 'n1st_nod_pln_dt')
							+  sheetObj.CellValue(checkArray[i], 'n1st_nod_pln_tm'));
		lst_nod_pln_dt		+= getSpace(sheetObj.CellValue(checkArray[i], 'lst_nod_pln_dt')
							+  sheetObj.CellValue(checkArray[i], 'lst_nod_pln_tm'));
		dor_nod_pln_dt		+= getSpace(sheetObj.CellValue(checkArray[i], 'dor_nod_pln_dt')
							+  sheetObj.CellValue(checkArray[i], 'dor_nod_pln_tm'));

		inter_rmk			+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'inter_rmk')));
		spcl_instr_rmk		+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'spcl_instr_rmk')));

		FORM_FCTRY_NM       += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'fctry_nm')));
		FORM_DOR_PST_CD     += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'dor_pst_cd')));
		FORM_CNTC_PSON_PHN_NO+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'cntc_pson_phn_no')));
		FORM_CNTC_PSON_FAX_NO+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'cntc_pson_fax_no')));
		FORM_CNTC_PSON_NM    += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'cntc_pson_nm')));
		
		n3pty_cust_cnt_cd   += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_cust_cnt_cd')));
		n3pty_cust_seq    	+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_cust_seq')));
		n3pty_desc    			+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_desc')));
		n3pty_vndr_seq    	+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_vndr_seq')));
		n3pty_ofc_cd    		+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_ofc_cd')));
		n3pty_bil_bzc_amt   += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_amt')));
		n3pty_bil_tp_cd     += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_tp_cd')));
		n3pty_curr_cd     += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'n3pty_bzc_curr_cd')));
		
		wtr_rcv_term_cd    += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'po_wtr_rcv_term_cd')));		
		wtr_de_term_cd     += getSpaceCode(sheetObj.CellValue(checkArray[i], 'po_wtr_de_term_cd'));
		
		po_trsp_agmt_ofc_cty_cd		+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'po_trsp_agmt_ofc_cty_cd')));
		po_trsp_agmt_seq			+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'po_trsp_agmt_seq')));
		po_cfm_flg   += getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'po_cfm_flg')));
		po_agmt_rt_seq			+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'po_agmt_rt_seq')));
		po_agmt_upd_dt			+= getSpaceCode(toHtml(sheetObj.CellValue(checkArray[i], 'po_agmt_upd_dt')));
	}

   if(document.form.wo_radio[0].checked) document.woForm.issued.value = 'N';
	else document.woForm.issued.value				= 'Y';
	document.woForm.pgmNo.value		                = 'ESD_TRS_0024';
	document.woForm.trsp_so_ofc_cty_cd.value		= cty_cd;
	document.woForm.trsp_so_seq.value				= seq_no;
	document.woForm.wo_cancel_flag.value			= cancel_check;
	document.woForm.dtn_use_flg.value				= dtn_use_flg;
	document.woForm.wo_bl_no_iss_flg.value			= wo_bl_no_iss_flg;
	document.woForm.vndr_seq.value					= vndr_seq;
	document.woForm.po_local_curr_cd.value			= po_local_curr_cd;
	document.woForm.po_basic_rt.value				= po_basic_rt;
	document.woForm.nego_amt.value					= nego_amt;
	document.woForm.etc_add_amt.value				= etc_add_amt;
	document.woForm.po_fuel_scg_rt.value			= po_fuel_scg_rt;
	document.woForm.po_vat_scg_rt.value				= po_vat_scg_rt;
	document.woForm.toll_fee_amt.value				= toll_fee_amt;
	document.woForm.n3pty_bil_flg.value				= n3pty_bil_flg;
	document.woForm.po_usd_curr_tot_amt.value		= po_usd_curr_tot_amt;

	document.woForm.gline_vndr_seq.value			= gline_vndr_seq;
	document.woForm.gline_po_local_curr_cd.value	= gline_po_local_curr_cd;
	document.woForm.gline_po_basic_rt.value			= gline_po_basic_rt;
	document.woForm.gline_nego_amt.value			= gline_nego_amt;
	document.woForm.gline_etc_add_amt.value			= gline_etc_add_amt;
	document.woForm.gline_po_fuel_scg_rt.value		= gline_po_fuel_scg_rt;
	document.woForm.gline_po_vat_scg_rt.value		= gline_po_vat_scg_rt;
	document.woForm.gline_toll_fee_amt.value		= gline_toll_fee_amt;
	document.woForm.gline_po_usd_curr_tot_amt.value	= gline_po_usd_curr_tot_amt;

	document.woForm.cust_cnt_cd.value				= cust_cnt_cd;
	document.woForm.cust_seq.value					= cust_seq;
	document.woForm.cust_nomi_trkr_flg.value		= cust_nomi_trkr_flg;
	document.woForm.trsp_agmt_rt_tp_cd.value		= trsp_agmt_rt_tp_cd;
	document.woForm.trsp_agmt_wy_tp_cd.value		= trsp_agmt_wy_tp_cd;

	document.woForm.trsp_frst_flg.value				= trsp_frst_flg;
	document.woForm.trsp_rjct_rsn_cd.value			= trsp_rjct_rsn_cd;
	document.woForm.trsp_dflt_vndr_flg.value		= trsp_dflt_vndr_flg;

	document.woForm.n1st_nod_pln_dt.value			= n1st_nod_pln_dt;
	document.woForm.lst_nod_pln_dt.value			= lst_nod_pln_dt;
	document.woForm.dor_nod_pln_dt.value			= dor_nod_pln_dt;
	document.woForm.inter_rmk.value					= inter_rmk;
	document.woForm.spcl_instr_rmk.value			= spcl_instr_rmk;

	document.woForm.FORM_FCTRY_NM.value				= FORM_FCTRY_NM;
	document.woForm.FORM_DOR_PST_CD.value			= FORM_DOR_PST_CD;
	document.woForm.FORM_CNTC_PSON_PHN_NO.value		= FORM_CNTC_PSON_PHN_NO;
	document.woForm.FORM_CNTC_PSON_FAX_NO.value		= FORM_CNTC_PSON_FAX_NO;
	document.woForm.FORM_CNTC_PSON_NM.value			= FORM_CNTC_PSON_NM;
	
    document.woForm.n3pty_cust_cnt_cd.value			= n3pty_cust_cnt_cd;
	document.woForm.n3pty_cust_seq.value			= n3pty_cust_seq;
	document.woForm.n3pty_desc.value				= n3pty_desc;
	document.woForm.n3pty_vndr_seq.value			= n3pty_vndr_seq;
	document.woForm.n3pty_ofc_cd.value				= n3pty_ofc_cd;
	document.woForm.n3pty_bil_bzc_amt.value			= n3pty_bil_bzc_amt;
	document.woForm.n3pty_bil_tp_cd.value			= n3pty_bil_tp_cd;
	document.woForm.n3pty_curr_cd.value				= n3pty_curr_cd;

	document.woForm.wo_prv_grp_bl_flg.value			= document.form.wo_prv_grp_bl_flg.value;
	
	document.woForm.wtr_rcv_term_cd.value			= wtr_rcv_term_cd;
	document.woForm.wtr_de_term_cd.value   		    = wtr_de_term_cd;
	
	document.woForm.po_trsp_agmt_ofc_cty_cd.value	= po_trsp_agmt_ofc_cty_cd;
	document.woForm.po_trsp_agmt_seq.value			= po_trsp_agmt_seq;

	document.woForm.trsp_so_no.value = document.form.trsp_so_no.value;
	// W/O 컨펌 시 S/O와 ofc코드가 일치하는지 확인하기 위해 전송
	document.woForm.po_cfm_flg.value = po_cfm_flg;
	document.woForm.po_agmt_rt_seq.value = po_agmt_rt_seq;
	document.woForm.po_agmt_upd_dt.value = po_agmt_upd_dt;
    var myOption = "width=1030,height=800,menubar=0,status=0,scrollbars=yes,resizable=1";
    var myWin = window.open("about:blank", "gotoPreview", myOption);
    document.woForm.target = "gotoPreview";
	document.woForm.action = 'ESD_TRS_0024.screen';
    document.woForm.submit();        
    myWin.focus();
}

/**
 * 선택된 SO에 해당되는 SO Inquiry를 팝업창으로 띄운다.
 */
function popSoInquiry(sheetObj, formObj){

	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}

	var cnt = 0;
	var cty_cd = '';
	var seq_no = '';

	for(var i=2; i<sheetObj.RowCount+2; i++)
	{
		if(cnt!=0){
			cty_cd += ',';
			seq_no += ',';
		}
		
		cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
		seq_no += sheetObj.CellValue(i, 'trsp_so_seq');
		cnt++;
	}

	document.soForm.trsp_so_ofc_cty_cd.value = cty_cd;
	document.soForm.trsp_so_seq.value = seq_no;

//	var myOption = "width=500,height=385,menubar=0,status=0,scrollbars=0,resizable=0";
//	myWin = window.open('', "popSoInquiry", myOption);
	document.soForm.target = popSoInquiry;
	document.soForm.submit();

}


/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col, mode, step_cd)
{

    var checkList = null;
	var checkArray = null;
	var surcharge_sheetObj = sheetObjects[1];
	var agmt_flg = "N";
			
	checkList = sheetObj.FindCheckedRow('ibcheck');
	checkArray = checkList.split('|');			
	if(mode == 'multiple'){
		if( checkArray == '') {
			ComShowCodeMessage('TRS90036');
			return false;
		}else{
			row = checkArray[0];
		}
	}
	
	// 동일한 Cargo Type 일 경우에만 해당 Surcharge를 선택할수 있도록 Validation 추가
	var oldCgoTpCd=null;
	for (idx = 0; idx < checkArray.length - 1; idx++) {
		var newCgoTpCd = sheetObj.CellValue( checkArray[idx] , "cgo_tp_cd" ); 	
		if (idx!=0 && oldCgoTpCd != newCgoTpCd) {
			ComShowCodeMessage('TRS90501');
			return false;
		}
		oldCgoTpCd=newCgoTpCd;
		
		if(sheetObj.CellValue( checkArray[idx] , "toll_fee_amt" )!=0){
			agmt_flg ="Y";
		} 	
	}
	
	var formObj = document.scgForm;
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=1,resizable=0";

	var myWin = window.open('', "popSurchargeInputInquiry", myOption);
	myWin.focus();
	
	formObj.unique_cd.value			= sheetObj.CellValue(row, 'surcharge_key');
	formObj.open_mode.value			= mode;
	formObj.step_cd.value			= step_cd;
	formObj.main_row.value			= row;
	formObj.sheet_arr_no.value		= '1';
	formObj.ofc_cty_cd.value		= sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	formObj.so_seq.value			= sheetObj.CellValue(row, 'trsp_so_seq');
	formObj.cgo_tp_cd.value			= sheetObj.CellValue(row, 'cgo_tp_cd');
	formObj.curr_cd.value			= sheetObj.CellValue(row, 'po_local_curr_cd');

	if(agmt_flg !="Y"){
		if(sheetObj.CellValue(row, 'toll_fee_amt') != 0){
			agmt_flg = "Y";	
		}else{
			agmt_flg = "N";
		}
	}
	formObj.agmt_flg.value			= agmt_flg;
	
	formObj.action					= 'ESD_TRS_0918.screen';
	formObj.target					= 'popSurchargeInputInquiry';

	if(mode == 'multiple'){
		formObj.multi_ofc_cty_cd.value	= getSoOfcCdArray(sheetObj, checkArray);
		formObj.multi_so_seq.value		= getSoSeqArray(sheetObj, checkArray);
		formObj.multi_cgo_tp_cd.value	= getCgoTpCdArray(sheetObj, checkArray);
		formObj.check_row.value			= getRowArray(sheetObj, checkArray);
	}
	formObj.submit();
//	searchLocalCurr2UsdCurr('', formObj2, row);
}

function getSoOfcCdArray(sheetObj, checkArray){

	var returnStr = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		returnStr += sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
	}

	return returnStr;
}

function getSoSeqArray(sheetObj, checkArray){

	var returnStr = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		returnStr += sheetObj.CellValue(checkArray[i], 'trsp_so_seq');
	}

	return returnStr;
}

function getCgoTpCdArray(sheetObj, checkArray){

	var returnStr = '';
	var cgo_tp_cd = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		cgo_tp_cd = sheetObj.CellValue(checkArray[i], 'cgo_tp_cd');
		if (cgo_tp_cd == 'F') cgo_tp_cd = 'C';
		else cgo_tp_cd = 'M';
		returnStr += cgo_tp_cd
		
	}

	return returnStr;
}

function getRowArray(sheetObj, checkArray){

	var returnStr = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		returnStr += checkArray[i];
	}

	return returnStr;
}

/**
 * Surcharge Input Inquiry popup
 **/
function pop3rdPartyBilling(sheetObj, row, col, mode)
{
	var myOption = "width=615,height=330,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0954.screen';
//	url += '?unique_cd='+sheetObj.CellValue(row, 'surcharge_key'); - surcharge_key 값이 안들어옴. so_seq와 일치하므로 일단 대체 . 954.js 와 같이 확인 필요
	url += '?unique_cd='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&open_mode='+mode;
	url += '&step_cd=WO';
	url += '&main_row='+row;
	url += '&trsp_so_ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&trsp_so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=1';
	url += '&bkg_no='+sheetObj.CellValue(row, 'bkg_no');
	url += '&eq_no='+sheetObj.CellValue(row, 'eq_no');
	url += '&wo_no='+sheetObj.CellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.CellValue(row, 'trsp_wo_seq');
	url += '&curr_cd='+sheetObj.CellValue(row, 'po_local_curr_cd');
	myWin = window.open(url, "pop3rdPartyBilling", myOption);
	myWin.focus();
}

/**
 * MoreCandidate popup으로부터 data 전송받기
 **/
function setMoreCandidate(winObj)
{

	winObj.close();
}

/**
 * NULL값제거
 **/
function getSpace(src)
{
	if (src == undefined || src == '') return ' ';
	return src;
}

/**
 * NULL값제거
 **/
function getSpaceCode(src)
{
	if (src == undefined || src == '') return '@null;';
	return src;
}

/**
 * Frustrate Flag 설정
 **/
function setFrustrate(sheetObj)
{
	var formObj = document.form;
	if (formObj.wo_radio.value == 'N'){
		ComShowCodeMessage('TRS90311');
		return;
	}
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');
	for(var i=0; i<checkArray.length-1; i++)
	{
		if(sheetObj.CellValue(checkArray[i], 'trsp_so_tp_cd')!='Y'){
			ComShowCodeMessage('TRS90310');
			return;
		}
	}

	document.form.f_cmd.value = MULTI01;
	sheetObj.DoSave("ESD_TRS_0091GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSpselect(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	
	for(var i=0; i<checkArray.length-1; i++)
	{
		if(sheetObj.CellValue(checkArray[i], 'trsp_so_tp_cd') == 'S'){
			sheetObj.CellValue2(checkArray[i], 'ibcheck') = '0';
		}
	}
	
	var radio = 'N';
	if (document.form.wo_radio[1].checked) radio = 'Y';
	
	var checkList = null;
	var checkArray = null;
	checkList = sheetObj.FindCheckedRow('ibcheck');
	checkArray = checkList.split('|');
	if( checkArray == '') {
		showErrMessage(getMsg('TRS90036'));
		return false;
	}else{
		row = checkArray[0];
	}
	
// * 1.130 CHM-200900431 Customer Code 입력가능요청(09.08.24)	
	var myOption = "width=650,height=280,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0961.screen';
	url += '?wo_radio='+radio;
	url += '&cust_cnt_cd_seq='+sheetObj.CellValue(row, 'cust_cnt_cd_seq');
	myWin = window.open(url, "popSpselect", myOption);
	myWin.focus();
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'wo_no':
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;

			case 'search_fm_loc':
			case 'search_via_loc':
			case 'search_to_loc':
			case 'search_door_loc':
				getComboList(obj);
				break;

			case 'tvvd_no':
			case 'fvvd_no':
			case 'bkg_no':
			case 'bl_no':
			case 'eq_no':
			case 'so_no':
			case 'wo_no':
			case 'mty_rfrn_no':
				obj.value = obj.value.toUpperCase();
				break;
		}
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	
	var yard_obj = null;
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
	var locValue = obj.value;

	if(obj.name == 'search_fm_loc'){
		yard_obj = document.search_fm_yard;
	}else if(obj.name == 'search_via_loc'){
		yard_obj = document.search_via_yard;
	}else if(obj.name == 'search_to_loc'){
		yard_obj = document.search_to_yard;
	}else if(obj.name == 'search_door_loc'){
		yard_obj = document.search_door_yard;
	}
	
	if(obj.name == 'search_door_loc') {
		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}else{
		getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}
	
}

//'포커스주기
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

function removeBar(str) {
    var value = "";
    for ( var i = 0; i < str.length; i++ ) {
    var ch = str.charAt(i);
    if ( ch != '-' ) value = value + ch;
    }
    return value;
}


/**
 * main sheet에서 저장될 Fuel surcharge를 surcharge sheet에 추가한다.
 **/
function addSurchargeData()
{
	var mainSheetObj = sheetObjects[0];
	var surchargeSheetObj = sheetObjects[1];
	var checkList = mainSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var temp_lgs_cost_cd = '';
	var temp1_lgs_cost_cd = '';
	var trsp_agmt_bfr_extd_flg = '';
	
	for(var a=surchargeSheetObj.RowCount; a>0 ;a--){
		temp_lgs_cost_cd = surchargeSheetObj.CellValue(a, prefix+'lgs_cost_cd');
		trsp_agmt_bfr_extd_flg = surchargeSheetObj.CellValue(a, prefix+'trsp_agmt_bfr_extd_flg');

		if( temp_lgs_cost_cd.length == 6 ){
			temp1_lgs_cost_cd = temp_lgs_cost_cd.substring(2,6);
			temp_lgs_cost_cd = temp_lgs_cost_cd.substring(2,4);
			if( temp1_lgs_cost_cd == 'OTAX') surchargeSheetObj.RowDelete(a, false);
			else if( temp1_lgs_cost_cd == 'TLAL'&& trsp_agmt_bfr_extd_flg == 'Y') surchargeSheetObj.RowDelete(a, false);
			else if( temp_lgs_cost_cd == 'FU') surchargeSheetObj.RowDelete(a, false);
		}else{
			temp_lgs_cost_cd = temp_lgs_cost_cd.substring(2,4);
			if( temp_lgs_cost_cd == 'FU') surchargeSheetObj.RowDelete(a, false);
		}
	}

	for(var k=0; k<checkArray.length-1; k++){
		var main_row = checkArray[k];
		var fuelSurcharge = mainSheetObj.CellValue(main_row, 'po_fuel_scg_rt');
		var vatSurcharge = mainSheetObj.CellValue(main_row, 'po_vat_scg_rt');
		var tollFeeSurcharge = mainSheetObj.CellValue(main_row, 'toll_fee_amt');
		var cgo_tp_cd = mainSheetObj.CellValue(main_row, 'cgo_tp_cd');
		if (cgo_tp_cd == 'F') cgo_tp_cd = 'C';
		else cgo_tp_cd = 'M';

		if(Number(fuelSurcharge) != 0){
			var surcharge_row = surchargeSheetObj.DataInsert(-1);
			var trans_md = mainSheetObj.CellValue(main_row, 'trsp_crr_mod_cd');
			
			//trans mode 는 6개의 코드만 사용한다.
			if(trans_md == 'RW') trans_md = 'WR';
			else if(trans_md == 'TW') trans_md = 'WT';
			else if(trans_md == 'TR') trans_md = 'RT';

			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_ofc_cty_cd') = mainSheetObj.CellValue(main_row, 'trsp_so_ofc_cty_cd');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_seq') = mainSheetObj.CellValue(main_row, 'trsp_so_seq');

			surchargeSheetObj.CellValue2(surcharge_row, prefix+'unique_cd') = mainSheetObj.CellValue(main_row, 'surcharge_key');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'lgs_cost_cd') = 'S'+cgo_tp_cd+'FU'+trans_md;
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'scg_amt') = mainSheetObj.CellValue(main_row, 'po_fuel_scg_rt');
		}
		
		if(Number(vatSurcharge) != 0){
			var surcharge_row = surchargeSheetObj.DataInsert(-1);
			
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_ofc_cty_cd') = mainSheetObj.CellValue(main_row, 'trsp_so_ofc_cty_cd');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_seq') = mainSheetObj.CellValue(main_row, 'trsp_so_seq');

			surchargeSheetObj.CellValue2(surcharge_row, prefix+'unique_cd') = mainSheetObj.CellValue(main_row, 'surcharge_key');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'lgs_cost_cd') = 'S'+cgo_tp_cd+'OTAX';
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'scg_amt') = mainSheetObj.CellValue(main_row, 'po_vat_scg_rt');
		}
		
		if(Number(tollFeeSurcharge) != 0){
			var surcharge_row = surchargeSheetObj.DataInsert(-1);
			
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_ofc_cty_cd') = mainSheetObj.CellValue(main_row, 'trsp_so_ofc_cty_cd');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_so_seq') = mainSheetObj.CellValue(main_row, 'trsp_so_seq');

			surchargeSheetObj.CellValue2(surcharge_row, prefix+'unique_cd') = mainSheetObj.CellValue(main_row, 'surcharge_key');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'lgs_cost_cd') = 'S'+cgo_tp_cd+'TLAL';
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'scg_amt') = mainSheetObj.CellValue(main_row, 'toll_fee_amt');
			surchargeSheetObj.CellValue2(surcharge_row, prefix+'trsp_agmt_bfr_extd_flg') = "Y";
		}
	}
}

/**
* 공통 Node popup
*/
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v6 = ""; //mode구분
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}
	
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* From Node 팝업에 대한 리턴값
*/
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
* Via Node 팝업에 대한 리턴값
*/
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(document.search_via_yard, sheetObjects[0], formObject, lvLoc);
	document.search_via_yard.CODE = lvYard;
}

/**
* To Node 팝업에 대한 리턴값
*/
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
* Door Location 팝업에 대한 리턴값
*/
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
		
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}


/**
 * 공통 Trunk VVD popup
 */
 function openTVVDPopup() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_TVVD";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

function getCOM_ENS_TVVD(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.tvvd_no.value = colArray[7] + gubun;
}

/**
 * 공통 Trunk VVD popup
 */
 function openFVVDPopup() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_FVVD";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

function getCOM_ENS_FVVD(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.fvvd_no.value = colArray[7] + gubun;
}

function checkDigit(obj){
	var formObj = document.form;
	if (obj == undefined){
		obj = formObj.eq_no;
	}

	if(formObj.eq_radio[0].checked){
		obj.value = multiCntrChkDgt(obj.value);
	}
}


function sheet_OnSelectMenu(sheetObj, MenuString){

	 switch(MenuString){
		case('Header Setting Save'):
			IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Reset'):
			IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;

		case('Header Setting Delete'):
			IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
	 }
}


/**
 * TPL_ETS_024 에서 Confirm후(OnSaveEnd) 호출 되는 함수로 
 * TRS_TRSP_WRK_ORD_PRV_TMP의 wo_prv_grp_seq, wo_iss_no값을 받아 
 * TRS_TRSP_WRK_ORD_PRV_TMP에서 trsp_so_ofc_cty_cd,trsp_so_seq 값을 select해서
 * sheetObjects에 해당 값이 있을경우 grid에서 삭제해준다.
 * 
 * @param wo_prv_grp_seq TRS_TRSP_WRK_ORD_PRV_TMP의 컬럼값
 * @param wo_iss_no TRS_TRSP_WRK_ORD_PRV_TMP의 컬럼값
 */


function processConfirmedWOData(wo_prv_grp_seq,wo_iss_no){
//    var objs = new Array();
//    objs[0] =  sheetObjects[0];
    //common.js에 있는 함수로
    //이 함수의 로직을 모두 포함 하고 있다.  
    document.form.wo_prv_grp_seq.value =  wo_prv_grp_seq;
    document.form.wo_iss_no.value =  wo_iss_no    ;
       
    removeConfirmedWOData(wo_prv_grp_seq,wo_iss_no);  
   }

/**
 * TRS_TRSP_WRK_ORD_PRV_TMP의 wo_prv_grp_seq, wo_iss_no값을 받아 
 * TRS_TRSP_WRK_ORD_PRV_TMP에서 trsp_so_ofc_cty_cd,trsp_so_seq 값을 select해서
 * sheetObjects에 해당 값이 있을경우 grid에서 삭제해준다.
 * 
 * @param sheetObj 삭제하고자 하는 sheet들로  Array 행태로 사용한다.
 * @param ofc_colName sheetObj에 정의 된 trsp_so_ofc_cty_cd의 이름(특별히 이름을 안 바꿨다면 trsp_so_ofc_cty_cd이 될것이다.
 * @param seq_colName sheetObj에 정의 된 trsp_so_seq의 이름(특별히 이름을 안 바꿨다면 trsp_so_seq이 될것이다.
 **/


function removeConfirmedWOData(wo_prv_grp_seq,wo_iss_no){

 	var formObj = document.form;
	 var sheetObj= sheetObjects[2];
 	 var sheetObj0 = sheetObjects[0];
     var selRow = 0;

 	if(document.form.wo_radio[0].checked){
 		var woradio = 0
 	}else{
 		 var woradio =1
 	}

 		formObj.f_cmd.value = SEARCH06;		
        sheetObj.DoSearch4Post("ESD_TRS_0091GS.do", TrsFrmQryString(formObj));

 var delcnt = sheetObj.RowCount;

    for(var i=0 ; i < delcnt ; i++){

       var  ofc = sheetObj.CellValue(i+1,'trsp_so_ofc_cty_cd');
       var  seq = sheetObj.CellValue(i+1, 'trsp_so_seq');
         selRow = sheetObj0.FindText('trsp_so_seq',seq,0);
         if( selRow >=0 ){ 
       	
         	 if(woradio == '1' && sheetObj0.CellValue(selRow, 'cancel_check') == '0' ){}else{ 
          sheetObj0.RowDelete(selRow,false);  
         	 }
          }
       }
}// end function


/**
 * Appt./Deli. Excel Import popup
 */
 function openApptDeliExcelImportPopup(sheetObj, formObj) {
    var myOption = "width=730,height=400,menubar=0,status=0,scrollbars=yes,resizable=1";
    var myWin = window.open("about:blank", "gotoApptDeliExcelImportPopup", myOption);
    document.woForm.target = "gotoApptDeliExcelImportPopup";
	document.woForm.action = 'ESD_TRS_0044.screen';
    document.woForm.submit();       
    myWin.focus();  	
}

/**
* Bundling popup
*/
function openBundlingPopup(sheetObj, formObj) {

	var myOption = "dialogWidth:800px; dialogHeight:470px; help:no; status:no; resizable:no; scroll=no; ";
//	var myOption = "dialogWidth:1000px; dialogHeight:1000px; help:no; status:no; resizable:no; scroll=no; ";
	var url = 'ESD_TRS_0963.do';
	url += '?mainSheetArrayNo=0';
	window.showModalDialog(url, window, myOption);
}

/**
 * 
 * @param cnt_cd
 * @return
 * 
 * 미주지역 - Appt./Deli. Excel Import, Appt./Deli. Save 버튼 보임
 * 미주이외지역 - Appt./Deli. Excel Import, Appt./Deli. Save 버튼 숨김
 */
function gubunApptDeli(cnt_cd){	
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
		
	if(cnt_cd == 'US'){	// 미주지역
		if(formObj.wo_radio[1].checked){
			//document.all.ApptDeliImportLayer.style.display = "";	
			//document.all.ApptDeliSaveLayer.style.display = "";		
		}else{
			//document.all.ApptDeliImportLayer.style.display = "none";		
			//document.all.ApptDeliSaveLayer.style.display = "none";						
		}
	}else{				// 미주이외지역
		//document.all.ApptDeliImportLayer.style.display = "none";
		//document.all.ApptDeliSaveLayer.style.display = "none";	
	}
}


function setAppDeli(sheetObj){	
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');
	
	document.form.f_cmd.value = MULTI02;

	for(var i=0; i<checkArray.length-1; i++)
	{	
		sheetObj.CellValue(checkArray[i],'curr_cd') = getSpace(sheetObj.CellValue(checkArray[i],'po_local_curr_cd')); 
	    sheetObj.CellValue(checkArray[i],'apnt_dt') = getSpace(sheetObj.CellValue(checkArray[i],'appo_time_dt'))+" "+getSpace(sheetObj.CellValue(checkArray[i],'appo_time_hms'));
		sheetObj.CellValue(checkArray[i],'de_dt') =	getSpace(sheetObj.CellValue(checkArray[i],'deli_time_dt'))+" "+getSpace(sheetObj.CellValue(checkArray[i],'deli_time_hms'));
		sheetObj.CellValue(checkArray[i],'fm_nod_cd') =	getSpace(sheetObj.CellValue(checkArray[i],'fm_loc_value'))+getSpace(sheetObj.CellValue(checkArray[i],'fm_yard_value'));
		sheetObj.CellValue(checkArray[i],'to_nod_cd') =	getSpace(sheetObj.CellValue(checkArray[i],'to_loc_value'))+getSpace(sheetObj.CellValue(checkArray[i],'to_yard_value'));				
	}

	sheetObj.DoSave("ESD_TRS_0091GS.do", TrsFrmQryString(document.form), 'ibcheck', false);	
}

function modifyCurrNego(sheetObj){
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');
	// 변경여부 체크
	var chgCnt = 0;
	for (i=0; i<checkArray.length-1; i++){
		if(sheetObj.CellValue(checkArray[i], 'cancel_check') == '1'){
			ComShowCodeMessage('TRS90503');
			return false ;
		} else {
			var curr_cd = getSpace(sheetObj.CellValue(checkArray[i],'po_local_curr_cd'));   	
			var nego_amt = getSpace(sheetObj.CellValue(checkArray[i],'nego_amt'));
			var org_curr_cd = getSpace(sheetObj.CellValue(checkArray[i],'org_curr_cd'));   		       
			var org_nego_amt = getSpace(sheetObj.CellValue(checkArray[i],'org_nego_amt'));   		          		       
			if(curr_cd == org_curr_cd && nego_amt == org_nego_amt) chgCnt++;
			sheetObj.CellValue(checkArray[i],'curr_cd') = curr_cd;
		}
	}
	if(chgCnt==checkArray.length-1){
		ComShowCodeMessage('TRS90504');
		return false ;	
	}

//	document.form.wo_prv_grp_bl_flg.value = "N";
	document.form.f_cmd.value = MULTI03;
	sheetObj.DoSave("ESD_TRS_0091GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
	doActionIBSheet(sheetObj,document.form,IBSEARCH);
}
	
function multi_moreCandidate(sheetObj) {
	var ip_pass = "N";
	var url = "";
	if( document.form.wo_radio[0].checked == true ) {
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}

		var ip_trsp_so_ofc_cty_cd = "";
		var ip_trsp_so_seq = "";
		var ip_basis_dt = "";
		var ip_cmdt_cd = "";
		var ip_eq_tp_sz_cd = "";
		var ip_cgo_tp_cd = "";
		var ip_cost_mod_cd = "";
		var ip_crr_mod_cd = "";
		var ip_bound_cd = "";
		var ip_from_node_cd = "";
		var ip_via_nod_cd = "";
		var ip_door_nod_cd = "";
		var ip_to_nod_cd = "";
		var ip_ctrl_ofc_cd = "";
		var ip_vndr_seq = "";
		var ip_cust_cnt_cd = "";
		var ip_cust_seq = "";
		var ip_eq_knd_cd = "";
		var ip_cmb_tp_cd = "";
		var ip_trsp_so_tp_cd = "";
		var ip_wgt_uom = "";
		var ip_wgt_qty = "";
		var ip_bundle_cnt = "";
		var ip_mcntr_bdl_grp_seq = "";

		for(var i=0; i<checkArray.length-1; i++) {
			if(sheetObj.CellValue(checkArray[i], 'mcntr_bdl_grp_seq') != "") {
				ComShowCodeMessage('TRS90524');
				ip_pass = "N";
				break;
			} else {
				if( i == 0 ) {
					ip_trsp_so_ofc_cty_cd = sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
					ip_trsp_so_seq        = sheetObj.CellValue(checkArray[i], 'trsp_so_seq');
					ip_basis_dt           = sheetObj.CellValue(checkArray[i], 'so_cre_dt');
					ip_cmdt_cd            = sheetObj.CellValue(checkArray[i], 'cmdt_cd');
					ip_eq_tp_sz_cd        = sheetObj.CellValue(checkArray[i], 'eq_tpsz_cd');
					ip_cgo_tp_cd          = sheetObj.CellValue(checkArray[i], 'cgo_tp_cd');
					ip_cost_mod_cd        = sheetObj.CellValue(checkArray[i], 'trsp_cost_dtl_mod_cd');
					ip_crr_mod_cd         = sheetObj.CellValue(checkArray[i], 'trsp_crr_mod_cd');
					ip_bound_cd           = sheetObj.CellValue(checkArray[i], 'trsp_bnd_cd');
					ip_from_node_cd       = sheetObj.CellValue(checkArray[i], 'fm_loc_value')+sheetObj.CellValue(checkArray[i], 'fm_yard_value');
					ip_via_nod_cd         = sheetObj.CellValue(checkArray[i], 'via_loc_value')+sheetObj.CellValue(checkArray[i], 'via_yard_value');
					ip_door_nod_cd        = sheetObj.CellValue(checkArray[i], 'dor_loc_value')+sheetObj.CellValue(checkArray[i], 'dor_yard_value');
					ip_to_nod_cd          = sheetObj.CellValue(checkArray[i], 'to_loc_value')+sheetObj.CellValue(checkArray[i], 'to_yard_value');
					ip_ctrl_ofc_cd        = sheetObj.CellValue(checkArray[i], 'cre_ofc_cd');
					ip_vndr_seq           = sheetObj.CellValue(checkArray[i], 'preset_vndr_seq');
					ip_cust_cnt_cd        = sheetObj.CellValue(checkArray[i], 'po_cust_cnt_cd');
					ip_cust_seq           = sheetObj.CellValue(checkArray[i], 'po_cust_seq');
					ip_eq_knd_cd          = sheetObj.CellValue(checkArray[i], 'eq_knd_cd');
					ip_cmb_tp_cd          = sheetObj.CellValue(checkArray[i], 'trsp_so_cmb_tp_cd');
					ip_wgt_uom            = sheetObj.CellValue(checkArray[i], 'wgt_meas_ut_cd');
					ip_wgt_qty            = sheetObj.CellValue(checkArray[i], 'cntr_wgt');
					ip_bundle_cnt         = sheetObj.CellValue(checkArray[i], 'bundling_no');
					ip_trsp_so_tp_cd      = sheetObj.CellValue(checkArray[i], 'trsp_so_tp_cd');
					ip_pass = "Y";
				} else {
					if( ip_eq_tp_sz_cd != sheetObj.CellValue(checkArray[i], 'eq_tpsz_cd')
						|| ip_cgo_tp_cd != sheetObj.CellValue(checkArray[i], 'cgo_tp_cd') || ip_cost_mod_cd != sheetObj.CellValue(checkArray[i], 'trsp_cost_dtl_mod_cd')
						|| ip_crr_mod_cd != sheetObj.CellValue(checkArray[i], 'trsp_crr_mod_cd') || ip_bound_cd != sheetObj.CellValue(checkArray[i], 'trsp_bnd_cd')
						|| ip_from_node_cd != (sheetObj.CellValue(checkArray[i], 'fm_loc_value')+sheetObj.CellValue(checkArray[i], 'fm_yard_value'))
						|| ip_via_nod_cd != (sheetObj.CellValue(checkArray[i], 'via_loc_value')+sheetObj.CellValue(checkArray[i], 'via_yard_value'))
						|| ip_door_nod_cd != (sheetObj.CellValue(checkArray[i], 'dor_loc_value')+sheetObj.CellValue(checkArray[i], 'dor_yard_value'))
						|| ip_to_nod_cd != (sheetObj.CellValue(checkArray[i], 'to_loc_value')+sheetObj.CellValue(checkArray[i], 'to_yard_value'))
						|| ip_ctrl_ofc_cd != sheetObj.CellValue(checkArray[i], 'cre_ofc_cd') || ip_vndr_seq != sheetObj.CellValue(checkArray[i], 'preset_vndr_seq')
						|| ip_eq_knd_cd != sheetObj.CellValue(checkArray[i], 'eq_knd_cd') || ip_cmb_tp_cd != sheetObj.CellValue(checkArray[i], 'trsp_so_cmb_tp_cd')
						|| ip_wgt_uom != sheetObj.CellValue(checkArray[i], 'wgt_meas_ut_cd') 
						|| ip_bundle_cnt != sheetObj.CellValue(checkArray[i], 'bundling_no') || ip_trsp_so_tp_cd != sheetObj.CellValue(checkArray[i], 'trsp_so_tp_cd')
						|| ip_cust_cnt_cd != sheetObj.CellValue(checkArray[i], 'po_cust_cnt_cd') || ip_cust_seq != sheetObj.CellValue(checkArray[i], 'po_cust_seq')
					) {
						ComShowCodeMessage('TRS90524');
						ip_pass = "N";
						break;
					}
				}
			}
		} //for End
		if( ip_pass == "Y" ) {
			url = '?trsp_so_ofc_cty_cd='+ip_trsp_so_ofc_cty_cd;
			url += '&trsp_so_seq='+ip_trsp_so_seq;
			url += '&ctrl_ofc_cd='+ip_ctrl_ofc_cd;
			url += '&vndr_seq='+ip_vndr_seq;
			url += '&basis_dt='+ip_basis_dt;
			url += '&eq_knd_cd='+ip_eq_knd_cd;
			url += '&eq_tp_sz_cd='+ip_eq_tp_sz_cd;
			url += '&cmb_tp_cd='+ip_cmb_tp_cd;
			url += '&cgo_tp_cd='+ip_cgo_tp_cd;
			url += '&bound_cd='+ip_bound_cd;
			url += '&crr_mod_cd='+ip_crr_mod_cd;
			url += '&cost_mod_cd='+ip_cost_mod_cd;
			url += '&cust_cnt_cd='+ip_cust_cnt_cd;
			url += '&cust_seq='+ip_cust_seq;
			url += '&cmdt_cd='+ip_cmdt_cd;
			url += '&from_nod_cd='+ip_from_node_cd;
			url += '&via_nod_cd='+ip_via_nod_cd;
			url += '&door_nod_cd='+ip_door_nod_cd;
			url += '&to_nod_cd='+ip_to_nod_cd;
			url += '&bundle_cnt='+ip_bundle_cnt;
			url += '&wgt_uom='+ip_wgt_uom;
			url += '&wgt_qty='+ip_wgt_qty;
			url += '&single_multi_sep=M';
			ComOpenWindow('ESD_TRS_0921.do'+url, 'ESD_TRS_0921', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:1000px;dialogHeight:500px', true);
		}
	}
}

function rtnMultiESD_TRS_0921(obj) {
	sheetObj = sheetObjects[0];
	if( document.form.wo_radio[0].checked == true ) {
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');

		for(var i=0; i<checkArray.length-1; i++) {
		 //여기에 적용시킬 것..
			sheetObj.CellValue2(checkArray[i], "po_sp_type") = obj.po_sp_type;
			sheetObj.CellValue2(checkArray[i], "cust_cnt_cd_seq") = obj.cust_cnt_cd_seq;
			sheetObj.CellValue2(checkArray[i], "po_cust_cnt_cd") = obj.po_cust_cnt_cd;
			sheetObj.CellValue2(checkArray[i], "po_cust_seq") = obj.po_cust_seq;
			sheetObj.CellValue2(checkArray[i], "po_cust_nomi_trkr_flg") = obj.po_cust_nomi_trkr_flg;
			sheetObj.CellValue2(checkArray[i], "vndr_seq") = obj.vndr_seq;
			sheetObj.CellValue2(checkArray[i], "vndr_nm") = obj.vndr_nm;
			sheetObj.CellValue2(checkArray[i], "hzd_mtrl_flg") = obj.hzd_mtrl_flg;
			sheetObj.CellValue2(checkArray[i], "ovwt_tri_axl_flg") = obj.ovwt_tri_axl_flg;
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_rt_tp_nm") = obj.po_trsp_agmt_rt_tp_nm;
			sheetObj.CellValue2(checkArray[i], "po_local_curr_cd") = obj.po_local_curr_cd;
			sheetObj.CellValue2(checkArray[i], "po_basic_rt") = obj.po_basic_rt;
			sheetObj.CellValue2(checkArray[i], "po_fuel_scg_rt") = obj.po_fuel_scg_rt;
			sheetObj.CellValue2(checkArray[i], "toll_fee_amt") = obj.toll_fee_amt;
			sheetObj.CellValue2(checkArray[i], "po_vat_scg_rt") = obj.po_vat_scg_rt;
			sheetObj.CellValue2(checkArray[i], "po_local_curr_tot_amt") = obj.po_local_curr_tot_amt;
			sheetObj.CellValue2(checkArray[i], "po_usd_curr_tot_amt") = obj.po_usd_curr_tot_amt;
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_ofc_cty_cd") = obj.po_trsp_agmt_ofc_cty_cd;
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_seq") = obj.po_trsp_agmt_seq;
			sheetObj.CellValue2(checkArray[i], "po_way_type") = obj.po_way_type;
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_rt_tp_cd") = obj.po_trsp_agmt_rt_tp_cd;
			sheetObj.CellValue2(checkArray[i], "po_wtr_rcv_term_cd") = obj.po_wtr_rcv_term_cd;
			sheetObj.CellValue2(checkArray[i], "po_wtr_de_term_cd") = obj.po_wtr_de_term_cd;
			sheetObj.CellValue2(checkArray[i], "trsp_dflt_vndr_flg") = obj.trsp_dflt_vndr_flg;
			
			sheetObj.CellValue2(checkArray[i], "po_cfm_flg") = obj.po_cfm_flg;
			sheetObj.CellValue2(checkArray[i], "po_agmt_rt_seq") = obj.po_agmt_rt_seq;
			sheetObj.CellValue2(checkArray[i], "po_agmt_upd_dt") = obj.po_agmt_upd_dt;
			sheetObj.CellValue2(checkArray[i], "agmt_mor_cnddt_aply_flg") = 'Y';
			
			if (sheetObj.CellValue(checkArray[i], 'po_cfm_flg') == 'N') {			
			    sheetObj.RowFontColor(checkArray[i]) =  sheetObj.RgbColor(163, 73, 164);
			}else if (sheetObj.CellValue(checkArray[i], 'po_cfm_flg') == 'Y') {	
				sheetObj.RowFontColor(checkArray[i]) =  sheetObj.RgbColor(0,0,0);
			}
		}
	}
}

function setMoreCntCandidate(sheetObj){
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	
	if( document.form.wo_radio[0].checked == true ) {

		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
	
		var myOption = "dialogWidth:450px; dialogHeight:360px; help:no; status:no; resizable:no; scroll=no; ";
		var url = "";
	    var sc_no  		 = "";
	    var rfa_no 		 = "";
	    var vndr_seq 	 = "";
	    var trsp_bnd_cd  = "";
	    var fm_nod_cd    = "";
	    var fm_nod_yard  = "";
	    var to_nod_cd    = "";
	    var to_nod_yard  = "";
	    var dor_nod_cd   = "";
	    var dor_nod_yard = "";
	    var ctrl_ofc_cd  = "";
	    var vndr_seq     = "";
	    var chk_flg      = "Y";
	    
	    if(sheetObj.CellValue(checkArray[i],"ctrt_cnt") !="0"){
			for(var i=0; i<checkArray.length-1; i++) {
				if(sheetObj.CellValue(checkArray[0],"sc_no")== sheetObj.CellValue(checkArray[i],"sc_no")
				&& sheetObj.CellValue(checkArray[0],"rfano")== sheetObj.CellValue(checkArray[i],"rfano")
				&& sheetObj.CellValue(checkArray[0],"trsp_bnd_cd")== sheetObj.CellValue(checkArray[i],"trsp_bnd_cd")
				&& sheetObj.CellValue(checkArray[0],"fm_loc_value")== sheetObj.CellValue(checkArray[i],"fm_loc_value")
				&& sheetObj.CellValue(checkArray[0],"fm_yard_value")== sheetObj.CellValue(checkArray[i],"fm_yard_value")
				&& sheetObj.CellValue(checkArray[0],"to_loc_value")== sheetObj.CellValue(checkArray[i],"to_loc_value")
				&& sheetObj.CellValue(checkArray[0],"to_yard_value")== sheetObj.CellValue(checkArray[i],"to_yard_value")
				&& sheetObj.CellValue(checkArray[0],"dor_loc_value")== sheetObj.CellValue(checkArray[i],"dor_loc_value")
				&& sheetObj.CellValue(checkArray[0],"dor_yard_value")== sheetObj.CellValue(checkArray[i],"dor_yard_value")
				&& sheetObj.CellValue(checkArray[0],"cre_ofc_cd")== sheetObj.CellValue(checkArray[i],"cre_ofc_cd")
				  ){
				    sc_no  		 =  sheetObj.CellValue(checkArray[0],"sc_no");
				    rfa_no 		 =  sheetObj.CellValue(checkArray[0],"rfa_no");
				    trsp_bnd_cd  =  sheetObj.CellValue(checkArray[0],"trsp_bnd_cd");
				    fm_nod_cd    =  sheetObj.CellValue(checkArray[0],"fm_loc_value");
				    fm_nod_yard  =  sheetObj.CellValue(checkArray[0],"fm_yard_value");
				    to_nod_cd    =  sheetObj.CellValue(checkArray[0],"to_loc_value");
				    to_nod_yard  =  sheetObj.CellValue(checkArray[0],"to_yard_value");
				    dor_nod_cd   =  sheetObj.CellValue(checkArray[0],"dor_loc_value");
				    dor_nod_yard =  sheetObj.CellValue(checkArray[0],"dor_yard_value");
				    ctrl_ofc_cd  =  sheetObj.CellValue(checkArray[0],"cre_ofc_cd");	
				    vndr_seq     =  sheetObj.CellValue(checkArray[0],"vndr_seq");	
				}else{
					chk_flg = "N";
					break;
				}
				
			}
		}
	    
		if(chk_flg == "Y"){
			url="ESD_TRS_0980.do"
			   +"?sc_no="+sc_no
			   +"&rfa_no="+rfa_no
			   +"&trsp_bnd_cd="+trsp_bnd_cd
			   +"&ctrl_ofc_cd="+ctrl_ofc_cd
			   +"&fm_nod_cd="+fm_nod_cd
			   +"&fm_nod_yard="+fm_nod_yard
			   +"&to_nod_cd="+to_nod_cd
			   +"&to_nod_yard="+fm_nod_yard
			   +"&dor_nod_cd="+dor_nod_cd
			   +"&dor_nod_yard="+dor_nod_yard
			   +"&chk_row="+checkList
			   +"&vndr_seq="+vndr_seq
			   +"&scrn_mode=M"
			   ;
			window.showModalDialog(url, window, myOption);
	
		}else{
			ComShowCodeMessage('TRS90524');
		}
	}//if( document.form.wo_radio[0].checked == true )
}


/**
 * rate apply popup
 **/
function getRateReApply(sheetObj, formObj){
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	var checkArray = checkList.split('|');
	var rateSheetObj = sheetObjects[3];
	formObj.f_cmd.value = SEARCH08;
		
	
	var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
	rateSheetObj.removeAll();
	rateSheetObj.DoSearch("ESD_TRS_0091GS.do", queryStr+'&'+TrsFrmQryString(formObj), "", true);
	var find_row = null;
	
	
	for(var k=0; k<checkArray.length-1; k++)
	{
		find_row = rateSheetObj.FindText(  'trsp_so_ofc_cty_cd_seq', sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd_seq'));
		if(rateSheetObj.CellValue(find_row, "po_cfm_flg")=='N'){
			ComShowCodeMessage('TRS90610');
			sheetObj.SelectCell(checkArray[k], "po_cfm_flg", false);
			sheetObj.CellValue2(checkArray[k], "po_cfm_flg"			 	 ) = rateSheetObj.CellValue(find_row,                      "po_cfm_flg"				);
			return;
		}
	}
	 
	
	for(var i=0; i<checkArray.length-1; i++)
	{
			find_row = rateSheetObj.FindText(  'trsp_so_ofc_cty_cd_seq', sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd_seq'));
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_ofc_cty_cd" ) = rateSheetObj.CellValue(find_row, 					   "po_trsp_agmt_ofc_cty_cd");
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_seq"		 ) = rateSheetObj.CellValue(find_row,                      "po_trsp_agmt_seq"		);  
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_rt_tp_cd"	 ) = rateSheetObj.CellValue(find_row,                      "po_trsp_agmt_rt_tp_cd"	);  
			sheetObj.CellValue2(checkArray[i], "po_way_type"			 ) = rateSheetObj.CellValue(find_row,                      "po_way_type"			);  
			sheetObj.CellValue2(checkArray[i], "po_trsp_agmt_rt_tp_nm"	 ) = rateSheetObj.CellValue(find_row,                      "po_trsp_agmt_rt_tp_nm"	);  
			sheetObj.CellValue2(checkArray[i], "po_sp_type"			 	 ) = rateSheetObj.CellValue(find_row,                      "po_sp_type"				);
			sheetObj.CellValue2(checkArray[i], "po_cust_nomi_trkr_flg"	 ) = rateSheetObj.CellValue(find_row,                      "po_cust_nomi_trkr_flg"	);  
			sheetObj.CellValue2(checkArray[i], "po_cust_cnt_cd"		     ) = rateSheetObj.CellValue(find_row,    	               "po_cust_cnt_cd"		    );
			sheetObj.CellValue2(checkArray[i], "po_cust_seq"			 ) = rateSheetObj.CellValue(find_row,                      "po_cust_seq"			);  
	//		sheetObj.CellValue2(checkArray[i], "po_cust_cnt_cd_seq"	 	 ) = rateSheetObj.CellValue(find_row,                      "po_cust_cnt_cd_seq"		);
			
			if (rateSheetObj.CellValue(find_row, "po_local_curr_cd") != '')
	        {
				sheetObj.CellValue2(checkArray[i], "po_local_curr_cd") = rateSheetObj.CellValue(find_row, "po_local_curr_cd");  
			}else{
				sheetObj.CellValue2(checkArray[i], "po_local_curr_cd") = sheetObj.CellValue(checkArray[i], "curr_cd");  
			}
			
			if (rateSheetObj.CellValue(find_row, "po_wtr_rcv_term_cd") == '0' ||rateSheetObj.CellValue(find_row, "po_wtr_rcv_term_cd") == 'null')
			{
				sheetObj.CellValue2(checkArray[i], "po_wtr_rcv_term_cd"	 	 ) ='';
			}else{
				sheetObj.CellValue2(checkArray[i], "po_wtr_rcv_term_cd"	 	 ) =rateSheetObj.CellValue(find_row,                      "po_wtr_rcv_term_cd"		);
			}
			
			if (rateSheetObj.CellValue(find_row, "po_wtr_de_term_cd") == '0' ||rateSheetObj.CellValue(find_row, "po_wtr_de_term_cd") == 'null')
			{
				sheetObj.CellValue2(checkArray[i], "po_wtr_de_term_cd"	 	 ) ='';
			}else{
				sheetObj.CellValue2(checkArray[i], "po_wtr_de_term_cd"	 	 ) =rateSheetObj.CellValue(find_row,                      "po_wtr_de_term_cd"		);
			}
			
			sheetObj.CellValue2(checkArray[i], "po_basic_rt"			 ) = rateSheetObj.CellValue(find_row,                      "po_basic_rt"			);  
			sheetObj.CellValue2(checkArray[i], "po_fuel_scg_rt"		 	 ) = rateSheetObj.CellValue(find_row,                      "po_fuel_scg_rt"			);
			sheetObj.CellValue2(checkArray[i], "po_local_curr_tot_amt"	 ) = rateSheetObj.CellValue(find_row,                      "po_local_curr_tot_amt"	);  
			sheetObj.CellValue2(checkArray[i], "po_usd_curr_tot_amt"	 ) = rateSheetObj.CellValue(find_row,                      "po_usd_curr_tot_amt"	);  
			sheetObj.CellValue2(checkArray[i], "po_vat_scg_rt"			 ) = rateSheetObj.CellValue(find_row,                      "po_vat_scg_rt"			); 
			
			sheetObj.CellValue2(checkArray[i], "toll_fee_amt"			 ) = rateSheetObj.CellValue(find_row,                      "toll_fee_amt"			); 
			
			sheetObj.CellValue2(checkArray[i], "po_cfm_flg"			 	 ) = rateSheetObj.CellValue(find_row,                      "po_cfm_flg"				);
			sheetObj.CellValue2(checkArray[i], "po_agmt_rt_seq"			 ) = rateSheetObj.CellValue(find_row,                      "po_agmt_rt_seq"			);
			sheetObj.CellValue2(checkArray[i], "po_agmt_upd_dt"			 ) = rateSheetObj.CellValue(find_row,                      "po_agmt_upd_dt"			);
			sheetObj.CellValue2(checkArray[i], "ibcheck"			 	 ) = 0;
	}
	
	if(find_row!= -1 ){
		ComShowCodeMessage('TRS90611');
	}
}
