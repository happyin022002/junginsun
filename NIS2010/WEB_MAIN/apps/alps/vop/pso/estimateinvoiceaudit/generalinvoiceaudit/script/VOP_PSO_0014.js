/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0014.js
*@FileTitle : Port charge Invoice Creation ( Invoice > Port charge Invoice Creation )
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.08.28 김진일
* 1.0 Creation
* 2010.08.23 이준범 OPMS Ticket ID : CHM-201005473-01
* Comment: Tariff에 "IN" 혹은 "OUT"의 Condition이 있을때 사용 하도록 되어 있는데
*          Condition이 없더라도 사용하고 있어 해당 칼럼을 Account를 선택시 해당 account로
*          등록된 Tariff을 읽어서 Condition에 IN/OUT이 있을때만 해당 칼럼을 활성화하도록 
*          로직 수정
*          checkIoChk() 신규 생성
* 2010.10.26 CHM-201006691 이석준
*            1.	Amount가 (+) 값인데, Credit을 체크할 경우, 메시지를 띄워주고 Adjustment Cost 값을 공란으로 변경. 
*            2.	Credit이 체크된 상태에서 입력된 Adjustment Cost값이 (+)인 경우, 메시지를 띄워주고 Adjustment Cost 값을 공란으로 변경.
*            3. credit 이 check후 다시 unchecked되었을때 formula값 복원
* 2010.11.24 이석준 CHM-201007129-01 Inovoice 데이타는 Deleted Vendor로 생성되지 않도록 함.
* 2011.01.18 진마리아 CHM-201007407-01 account가 511791일 때 remark 5자 필수입력
* 2011.10.14 진마리아 CHM-201114111-01 선처리CSR VAT, W/T에 마이너스 금액 입력 가능
* 2012.01.10 진마리아 선처리(SRM-201222935) 미 Confirm된 Invoice List Notice 메시지 alert
* 2012.02.16 진마리아 CHM-201216004-01 위 csr 관련, 미 confirm된 invoice가 없으면  alert하지 않도록 수정
* 2012.03.05 진마리아 CHM-201216583-01 Port Charge Invoice Creation 로직 변경 - 스케줄 존재 여부 점검 로직 추가 / KRPUS 스케줄에 대해 'Actual SKD 존재 체크' 로직 제외
* 2012.11.19 이혜민   CHM-201221185-01 [PSO] 항비 입력시 skip port 에 대한 pop up 메시지 추가 요청
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
* 2013.01.24 SKY    CHM-201322525 [PSO) Invoice creation 중복 account code 체크 로직
* 2013.04.17 SKY     [CHM-201324034] port Charge Invoice Creation화면에서  Invoice No. 마지막 자리 공백 입력 안 되도록 수정
* 2014.05.30 박다은 [CHM-201430063] Invoice Issued date alc Received date 입력 오류 방지을 위한 로직 변경 개발 요청 
* 2014.05.30 박다은 [CHM-201430328] [PSO] Port Charge invoice Creation 기능 개선
* 2014.08.05 이성훈 CHM-201430972 	[PSO] Invoice내 Exchanage Rate 칼럼 추가
* 2015.02.23 김기원 CHM-201534260 remark 한글 입력 가능하게 변경
=============================================================*/
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
     * @class VOP_PSO_0014 : VOP_PSO_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0014() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;9
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    //공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var vndrLglEngNm = {};//Vendor 의 영문명을 갖고 있는 변수 
    var vndrEngNm = {};// vendor.vndr_eng_nm
    var tmnlName = {};//TerminalName 정보를 갖고 있는 변수 
    var costOfc  = {};//CostOffice의 정보를 갖고 있는 변수 
    var currCdList = {};
    var VALIDVVD = 0;//현재 설정된 VVD가 Valid 한지 체크 하는 flag vvd  = 00000111 = 4+2+1 = 7인경우 valid
    var currCd = "";//login 유저의 CurrencyCD
    var isRClick = false;//Retrieve 했는지 확인 플라그 
    var trxnStats = new Array();//Calculation Button 을 클릭 했을 경우 원래의 TRxn상태를 저장한다.
    var g_isExist = false;
    var g_isTonExist = false; // 여러개의 row를 입력시 처음에 tonnage를 입력하고 다음 row에 그 외 account를 입력하면 expiry date 칼럼이 없어지는 것 막기 위함
    var g_isEnterKey = false;
    var g_DefaulDataRowHeight = 20;
    var g_ioExist = "N"; // io구분자를 해당 사항있을 경우만 보여주기 위해 flag
    
    var root = null; //TPB popup open시 combo change의 경우와 팝업 클릭의 경우를 구분하는 문자
    var popupCnt = 0;
    var popupCnt2 = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한  *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		var srcObj = window.event.srcElement;

	        switch (srcName) {
	        	case "btn_Confirm":
	        		//CRUD데이터가 없어도. 강제로 . Child Update하도록 
					//
					if(sheetObjects[0].RowCount > 0 ){
						sheetObjects[1].RowStatus(1) = "U";
					}
					formObject.updateflag.value = isRClick;
					
	        		formObject.iss_cty_cd.value = sheetObjects[0].CellValue(1, "sheet1_iss_cty_cd");
	        		formObject.so_seq.value = sheetObjects[0].CellValue(1, "sheet1_so_seq");
	        		formObject.cost_ofc_cd.value = formObject.cost_ofc.value; 
	        		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
	        		g_isTonExist   = false;
	        		break;
		        case "btns_calendar_s":
		        	var cal = new ComCalendar();
		        	cal.setDisplayType('date');
//		        	cal.setEndFunction("returnIssDt");
		        	cal.select(formObject.iss_dt, 'yyyy-MM-dd');
		        	break;
		        case "btns_calendar_r":
		        	var cal = new ComCalendar();
		        	cal.setDisplayType('date');
//		        	cal.setEndFunction("returnIssDt");
		        	cal.select(formObject.rcv_dt, 'yyyy-MM-dd');
		        	break;
		        case "btns_calendar_e":
		        	var cal = new ComCalendar();
		        	cal.setDisplayType('date');
		        	cal.select(formObject.eff_dt, 'yyyy-MM-dd');
		        	break;
		        case "btns_search"://S/P Code Button 
		        	ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setServiceProviderInfo', '0,0', true, true);
		        	break;
		        case "btn_search_cost_ofc"://Cost Office 

					var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
					var classId = "COM_ENS_071";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)
	
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_071.do' + param,  770,  450, 'getOfcCd', dispaly, true);
					} else {
						//ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
			        
			        break;
				case "btn_Retrieve":
					g_isTonExist   = false;
					sheetObject1.Editable = true;
					//=================================================================================================
					//요청사항 : INV No.에 해당되는 조회결과가 없는 경우라도, TTL INV. Amt 에 입력된 값은 유지한다.
					//요청일시 : 2014.08.19, 처리일시 : 2014.08.19
					//=================================================================================================
					//formObject.inv_amt.value = "";
					//=================================================================================================
					ComSetObjValue(formObject.vat, "");
					
					doActionIBSheet(sheetObject1, document.form, IBSEARCH);
					
					var dspNm = eval("tmnlName._"+formObject.yd_cd.value);
			    	dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
			    	formObject.tmnl_nm.value = dspNm;
			    	var ofcNm = eval("costOfc._"+formObject.yd_cd.value);
			    	ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
			    	
			    	g_ioExist = "N";
			    	sheetObject1.ColHidden("sheet1_io") = false; // 2015.05.14
			    
			    	if(formObject.curr_cd.value != sheetObject1.CellValue(1, "sheet1_trf_curr_cd")){
			    	    sheetObject1.ColHidden("sheet1_mnl_inp_xch_rt") = false; // 2016.01.25
			    	}
			    	
			    	///formObject.cost_ofc.value = ofcNm;
			    	///formObject.cost_ofc.value = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cost_ofc_cd");
			    	
			    	f_SetCostOfc();	//[2010.04.29:jmh]
			    	
			    	f_ExistsTonnage();
			    	
			    	//for (var i=sheetObject1.HeaderRows ; i<sheetObject1.RowCount+sheetObject1.HeaderRows; i++) {
			    	//	alert(i);
			    	//	fnSetEnableExpireDate(i);
			    	//}
			    	
			    	//User의 CUrrency CD설정 
			    	/*============================================================================================
			    	에러 사항 수정. 2014.08.12 
			    	1. Terminal Code 입력 이후 Invoice No. 입력하면 해당 터미널 code가 처음 것으로 변경됨
			    	   따라서 유저가 입력한 값 그대로 존재하도록 로직 수정 필요
			    	 ==============================================================================================				    	
			    	var currCdVal = eval("currCdList._"+formObject.yd_cd.value);
			    	currCdVal = (typeof currCdVal === "undefined") ? "" : currCdVal;
			    	formObject.curr_cd.value = currCdVal;
					//============================================================================================*/
		    	
					isRClick = true;
					break;
					
				case "btn_New":
					ComBtnEnable("btn_Save");
					ComBtnDisable("btn_Confirm");
					ComBtnDisable("btn_Delete");
					ComBtnEnable("btn_RowAdd");
					ComBtnEnable("btn_RowDelete");
					ComBtnEnable("btn_Calculation");
					document.getElementById("btn_del").innerHTML = "Delete";
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject1.Editable = true;
					var dspNm = eval("tmnlName._"+formObject.yd_cd.value);
			    	dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
			    	formObject.tmnl_nm.value = dspNm;
			    	var ofcNm = eval("costOfc._"+formObject.yd_cd.value);
			    	ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
			    	formObject.cost_ofc.value = ofcNm;
			    	
			    	g_ioExist = "N";
			    	
			    	sheetObject1.ColHidden("sheet1_io") = false; // 2015.05.14
			    	sheetObject1.ColHidden("sheet1_mnl_inp_xch_rt") = true; // 2015.05.14
			    	
			    	//User의 CUrrency CD설정 
			    	/*============================================================================================
			    	에러 사항 수정. 2014.08.12 
			    	1. Terminal Code 입력 이후 Invoice No. 입력하면 해당 터미널 code가 처음 것으로 변경됨
			    	   따라서 유저가 입력한 값 그대로 존재하도록 로직 수정 필요
			    	 ==============================================================================================				    	
			    	var currCdVal = eval("currCdList._"+formObject.yd_cd.value);
			    	currCdVal = (typeof currCdVal === "undefined") ? "" : currCdVal;
			    	formObject.curr_cd.value = currCdVal;
			    	//formObject.curr_cd.value = currCd;
					//============================================================================================*/
			    	
			    	//iss_dt 를 현재 날짜로 만든다.
					setToday(document.form.iss_dt, 'ymd');
					setToday(document.form.rcv_dt, 'ymd');
					sheetObject1.ColHidden("sheet1_cost_calc_eff_fm_dt") = true; //expire fm dt hidden
					sheetObject1.ColHidden("sheet1_cost_calc_eff_to_dt") = true; //expire to dt hidden
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
					isRClick = false;
					break;
					
				case "btn_Save":
					if(!checkServiceProvider()) return;
					if(!checkInvoiceAmount()) return;
					if(!checkIoChk()) return;
					
					formObject.updateflag.value = isRClick;//해당 데이터가 실제 Update 인지 설정
					//CRUD데이터가 없어도. 강제로 . Child Update하도록 
					
					var trxCnt = sheetObjects[0].RowCount("I")*1+sheetObjects[0].RowCount("U")*1+sheetObjects[0].RowCount("D")*1 
					//if(trxCnt == 0){
					//	return;
					//} 
					//else{//모두 Update로 처리 	
						for(var i=sheetObject1.HeaderRows ; i<=sheetObject1.RowCount; i++){
							if(sheetObject1.CellValue(i, "sheet1_ibflag") == ""||sheetObject1.CellValue(i, "sheet1_ibflag") == "R"){
								sheetObject1.RowStatus(i) = "U";
							}
						}
					//}
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					g_isTonExist   = false; //저장후 자동 조회되면서 기존 true로 계속되어 있어서 초기화
					var inv_no = document.form.inv_no.value;
					
					document.form.inv_no.value = inv_no.replace(/\s*$/, "");
	
				break;
					
				case "btn_RowAdd":
					if (!validateForm(sheetObject1,document.form,IBSEARCH)) return;//Inv_no가 있는지 체크 
					sheetObject1.DataInsert(-1);
					//CellFocus 를 앞으로 이동한다. 
					//sheetObject1.SelectCell(sheetObject1.SelectRow, "sheet1_vsl_cd");//3);
					//[2010.02.08:jmh]
					sheetObject1.SelectCell(sheetObject1.SelectRow, "sheet1_vvd");//3);
					VALIDVVD = 0;//flag clear .
					//save 시 사용할 hidden key 값을 설정한다. retrieve 시에도 이 값을 되도록 select list 에 가져와야 된다.
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_vndr_seq") = formObject.spcode.value;
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_yd_cd")    = formObject.yd_cd.value;
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_usr_id")   = formObject.usr_id.value;
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_inv_no")   = formObject.inv_no.value;
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_n3pty_bil_if_flg") = "N";
					//cLEAR
					formObject.vvdband.value      = "";
					formObject.atd.value          = ""; 
					formObject.calc_amt_vvd.value = "";
				break;
					
				case "btn_RowDelete":
					
					for (var i=sheetObject1.LastRow; i>=sheetObject1.HeaderRows; i--) { 
						if (sheetObject1.CellValue(i, "sheet1_del_chk") == 1) {
							sheetObject1.RowDelete(i, false);							
						}
					} 
					
					//ComRowHideDelete(sheetObject1, "sheet1_del_chk");			//[jmh]
					if (sheetObject1.RowCount("D") == sheetObject1.RowCount) {
						sheetObject1.RemoveAll();
						formObject.vvdband.value = "";
						formObject.atd.value = ""; 
						formObject.calc_amt_vvd.value = "";
						formObject.calc_amt_ttl.value = "";
					}
					
					setCalcAmtVvd();
				break;
					
				case "btn_Delete":
					formObject.isdelete.value = 'Y';
					g_isTonExist   = false;
					formObject.iss_cty_cd.value = sheetObjects[0].CellValue(1, "sheet1_iss_cty_cd");
	        		formObject.so_seq.value = sheetObjects[0].CellValue(1, "sheet1_so_seq");
	        		formObject.cost_ofc_cd.value = formObject.cost_ofc.value; 
					//sheet 의 cud 를 모두 delete 로 변경 한다.
					for(var i=0; i<sheetObject1.RowCount; i++)
						sheetObject1.RowStatus(i+1) = "D";
					//설정된 정보의 내용으로 데이터를 삭제 한다.
					doActionIBSheet(sheetObject1, document.form, IBDELETE);
				break;
					
				case "btn_Calculation":
					var exec = 0;
					//trxnStats
					
					for (var i=sheetObject1.HeaderRows ; i<sheetObject1.RowCount+sheetObject1.HeaderRows; i++) {
						trxnStats[i] = sheetObject1.CellValue(i, "sheet1_ibflag");
						//trxnStats[i] = sheetObject1.RowStatus(i);
						if (sheetObject1.CellValue(i, "sheet1_del_chk") == 0) {//flag 강제로 클리어
							sheetObject1.RowStatus(i) = "I";
						}
						
						if (sheetObject1.CellValue(i, "sheet1_del_chk") == 1) {
							exec++;
						}
					} 
					
					if (exec == 0) {
						return;
					}	
					
					//--> 재계산 로직을 돌린다. 
					doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC07);
					for (var i=sheetObject1.HeaderRows ; i<sheetObject1.RowCount+sheetObject1.HeaderRows; i++) {
						sheetObject1.RowStatus(i) = trxnStats[i];
					}
				break;
				
				case "cbx_night":     
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_night") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_holiday":   
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_holiday") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_boat":      
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_boat") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_tugrope":   
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_tugrope") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_buoy":      
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_buoy") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_sanitation":
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_sanitation") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_barge":     
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_barge") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_inspection":
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_inspection") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_newservice":
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_newservice") = srcObj.checked == true ? "Y":"N"  ;
				break;
				
				case "cbx_copilot":
					sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_copilot") = srcObj.checked == true ? "Y":"N"  ;
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
     * 청구된 Invoice Amount가 grid amount의 합 + VAT인가 를 확인  
     * @modified : (Invoice Amt) = (Grid Amt) + (V.A.T.)
     *             TTL_LOCL_AMT == LOCL_NET_AMT
     */
    function checkInvoiceAmount(){
    	
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 var invAmt = formObj.inv_amt.value == '' ? 0 : formObj.inv_amt.value.replace(/,/g, '')*1;
    	 var chkamt = sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")*1 + (formObj.vat.value.replace(/,/g, '') == '' ? 0 : formObj.vat.value.replace(/,/g, '')*1);
    	
    	 if(sheetObj.RowCount == 0) return false; 

    	 //>>[2010.04.06:jmh]
		 if(formObj.vat.value == ""){
			formObj.vat.value = 0;
		 }		
		 if(formObj.whld_tax.value == ""){
			formObj.whld_tax.value = 0;
		 }
    	 
    	 var netAmt = sheetObj.RowCount > 0 ? sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount") : 0;	//Grid
    	 	 netAmt = Number(netAmt);
    	 var vatAmt = formObj.vat.value == '' ? 0 : formObj.vat.value.replace(/,/g, '');					//V.A.T.
    	 	 vatAmt = Number(vatAmt);
    	 var wtAmt  = formObj.whld_tax.value == '' ? 0 : formObj.whld_tax.value.replace(/,/g, '');			//Withholding Tax
    	     wtAmt  = Number(wtAmt);
    	 //return false;
    	 
    	 var ttlLoclAmt = 0;
    	 var netLoclAmt = 0;
    	 var ddtLoclAmt = 0;
    	 for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
    		 var amount = Number(sheetObj.CellValue(i, "sheet1_amount"));
    		 if(amount > 0){
    			 netLoclAmt += amount;
    		 } else{
    			 ddtLoclAmt += amount;
    		 }
    	 }
    	 formObj.ttl_loc_amt.value = netAmt;	//invAmt - vatAmt;
    	 formObj.net_amt.value = netAmt;
    	 formObj.ddt_amt.value = ddtLoclAmt * -1;
    	 
    	 
//    	 if(vatAmt != 0 && wtAmt != 0){
//    		 //ComShowMessage("Please input only one of [VAT] and [W/T]");
//    		 ComShowCodeMessage("PSO00042");
//    		 return false;
//    	 }	 
    	 //ASCHOI
    	 if(invAmt == (netAmt + vatAmt - wtAmt).toFixed(2)){
    	 //if(invAmt == (netAmt + vatAmt).toFixed(2)){
    		 return true;
    	 } else{
    		 //ComShowMessage("Invoice Amount must be Sum of Cost Amount + VAT  or  Sum of Cost Amount - W/T");
//    		 ComShowCodeMessage("PSO00043");
    		 //ComShowMessage("Invoice Amount must be Sum of Cost Amount + VAT - W/T");
    		 ComShowCodeMessage("PSO00047");
    		 ComSetFocus(formObj.inv_amt);
    		 return false;
    	 }
    	 //<<[2010.04.06:jmh]
    	 
    	 /*[2010.04.06:jmh] close
    	 if(invAmt != chkamt){
    		 ComShowMessage("Invoice Amount must be equal to sum of amount plus V.A.T");
    		 ComSetFocus(formObj.inv_amt);
    		 return false;
    	 } else{ 
    		 return true;
    	 } 
    	 */	 
    }
    /**
     * issue date 에 달력으로 값이 설정 될 때 effective date 를 조회한다. 
     * @param 
     * @return
     */
    function returnIssDt(){
//    	document.form.rcv_dt.value = document.form.iss_dt.value; 
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
    	ComChkObjValid(form.rcv_dt);
//    	ComChkObjValid(form.eff_dt);
    }
    
    /**
     * S/P Code의 Input Text에 Popup에서 설정한 S/P Code 및 S/P Name 를 셋팅한다.
     * @param aryPopupData
     * @param row
     * @param col
     * @param sheetIdx
     * @return
     */
    function setServiceProviderInfo(aryPopupData, row, col, sheetIdx) {
    	
		var formObj = document.form;
		formObj.spcode.value = aryPopupData[0][1];
		formObj.spname.value = aryPopupData[0][2];
		formObj.spdeleted.value = aryPopupData[0][3];
		
		checkServiceProvider();
		
		//Focus를 Inv.NO로 이동 
		ComSetFocus(formObj.inv_no);
		
		f_ExistsInvNo();
		
		
		//Invoice creation 화면내 currency는 S/P에 등록된 Currency로 default 설정.
		fnSetCurrencyBySP();
     }
    
    /*
     * CHM-201007129-01
     */
    /*
     * S/P 삭제여부 검사
     */
    function checkServiceProvider(){
    	var formObj = document.form;
    	
		// 지워진 S/P인 경우 Invoice 생성 할 수 없다.
		if("Y"==formObj.spdeleted.value){
			// PSO00036 : Please input {?msg1}.
			ComShowCodeMessage("PSO00036", "the correct S/P Code.\n'[" + formObj.spcode.value + "]"+ formObj.spname.value + "' is DELETED");
			return false;
		}
		
		return true; // Add 2010.12.15
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

        for (i=0; i<sheetObjects.length; i++) {

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);

		//컴포넌트 초기화 상태설정(서버호출과 무관함)
		initDoActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
        //Sheet Object 2에 데이터를 Insert 
//        sheetObjects[1].DataInsert(-1);
//        sheetObjects[1].CellValue(1, 1) = "Value";
		document.form.spcode.focus();
    }

    /**
     * Control 초기화 함수 
     * @return
     */
    function initControl(){
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, 'spcode');
    	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); 
    	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);
    	axon_event.addListenerForm  ('change', 'obj_change', form);
    	axon_event.addListener		('keydown', 'obj_keydown', 'form');
    	axon_event.addListenerForm  ('click', 'obj_click', form);
    	axon_event.addListenerForm  ('paste', 'obj_paste', form);
    	axon_event.addListenerForm  ('drop', 'obj_drop', form);
    	axon_event.addListenerForm  ('blur', 'obj_blur', form);
    	
    	ComBtnDisable("btn_Confirm");
		ComBtnDisable("btn_Delete");
		//iss_dt 를 현재 날짜로 만든다.
		setToday(document.form.iss_dt, 'ymd');
		setToday(document.form.rcv_dt, 'ymd');
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
    }
    /**
     * EnterKey처리 
     * @return
     */
    function obj_keydown(){
    	if (event.keyCode == 13) {
    		g_isEnterKey = true;
    	}
        ComKeyEnter();
    }
    function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
	}
    function obj_activate() {
    	ComClearSeparator(event.srcElement);
	}
    /**
     * change 이벤트 함수
     * @return
     */
    function obj_change(){
  		var formObject = document.form;
  	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
  	    var sheetObject = sheetObjects[0];
  	    var sheetObj2   = sheetObjects[1];
  	    /*******************************************************/
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			
  	        switch(srcName) {
  	            case "spcode"://해당 vndr_seq 가 user 의 default Setting 에 있는지 확인
 	  	          	var dspNm = eval("vndrEngNm._"+formObject.spcode.value);
	  	          	if(typeof dspNm === "undefined"){
	  	          		ComShowMessage("There is no provider code in Default Setting.");
	  	          		formObject.spcode.value = "";
	  	          		formObject.spname.value = "";
	  	          		ComSetFocus(formObject.spcode);
	  	          		//Service Provider 의 입력정보가 유효하지 않을 경우 Currency 는 Clear 해준다.
	  	          		ComSetObjValue(formObject.curr_cd, "");	  	          		
	  	          	} else{	
	  	          		
	  	          		formObject.spname.value = dspNm;
	  	          		formObject.spdeleted.value = eval("vndrEngNm._"+formObject.spcode.value+"_DEL");
	  	          		checkServiceProvider();
	  	          		
	  	          		ComSetFocus(formObject.inv_no);
	  	          		sheetObject.RemoveAll();
	  	          		//sheetObject[1].RemoveAll();	//[jmh]
	  	          		sheetObject.Editable = true;
	  	          		isRClick = false;//전역 변수 클리어 
	  	          		//SHEET2 CLEAR
		  	          	sheetObj2.CellValue2(1, "sheet2_arrtp") = "";
		  	    		sheetObj2.CellValue2(1, "sheet2_deptp") = "";
		  	    		//sheetObj2.CellValue2(1, "sheet2_arrnt") = "";
		  	    		//sheetObj2.CellValue2(1, "sheet2_depnt") = "";
		  	    		sheetObj2.CellValue2(1, "sheet2_arrtuh") = "";
		  	    		sheetObj2.CellValue2(1, "sheet2_deptuh") = "";
		  	    		sheetObj2.CellValue2(1, "sheet2_arrlh") = "";
		  	    		sheetObj2.CellValue2(1, "sheet2_deplh") = "";
		  	    		sheetObj2.CellValue2(1, "sheet2_usdhrs") = "";
	  	          	}
	  	            f_ExistsTonnage();// cost_calc_eff_fm_dt , cost_calc_eff_to_dt가 존재하면 화면에 display되도록 하기 위함.
	  	          	f_ExistsInvNo(); // cost_calc_eff_fm_dt , cost_calc_eff_to_dt가 존재하면 화면에 display되도록 하기 위함
		  	  		//Invoice creation 화면내 currency는 S/P에 등록된 Currency로 default 설정.
	  	          	fnSetCurrencyBySP();
  	          	break;
  	            	
  	            case "inv_no":
  	            	f_ExistsTonnage();// cost_calc_eff_fm_dt , cost_calc_eff_to_dt가 존재하면 화면에 display되도록 하기 위함
  	            	f_ExistsInvNo(); 
  	           break;
          		
  	            case "yd_cd":
  	            	ComBtnEnable("btn_Save");
					ComBtnDisable("btn_Confirm");
					ComBtnDisable("btn_Delete");
					formObject.vvdband.value = "";
					formObject.atd.value = "";
					sheetObject.RemoveAll();
					sheetObjects[1].RemoveAll();
  	            	//checkbox클리어 
  	            	formObject.cbx_night.checked = false;          
  	            	formObject.cbx_holiday.checked = false;
  	            	formObject.cbx_boat.checked = false;
  	            	formObject.cbx_tugrope.checked = false;
  	            	formObject.cbx_buoy.checked = false;
  	            	formObject.cbx_sanitation.checked = false;
  	            	formObject.cbx_barge.checked = false;
  	            	formObject.cbx_inspection.checked = false;
  	            	formObject.cbx_newservice.checked = false;
  	            	formObject.cbx_copilot.checked = false;
  	            	
  	            	sheetObject.ColHidden("sheet1_cost_calc_eff_fm_dt") = true; //expire fm dt hidden
  	            	sheetObject.ColHidden("sheet1_cost_calc_eff_to_dt") = true; //expire to dt hidden
  	            	
					sheetObject.Editable = true;
					var dspNm = eval("tmnlName._"+formObject.yd_cd.value);
			    	dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
			    	formObject.tmnl_nm.value = dspNm;
			    	var ofcNm = eval("costOfc._"+formObject.yd_cd.value);
			    	ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
			    	formObject.cost_ofc.value = ofcNm;
			    	
			    	//User의 CUrrency CD설정 
			    	/*============================================================================================
			    	에러 사항 수정. 2014.08.12 
			    	1. Terminal Code 입력 이후 Invoice No. 입력하면 해당 터미널 code가 처음 것으로 변경됨
			    	   따라서 유저가 입력한 값 그대로 존재하도록 로직 수정 필요
			    	 ==============================================================================================				    	
			    	var currCdVal = eval("currCdList._"+formObject.yd_cd.value);
			    	currCdVal = (typeof currCdVal === "undefined") ? "" : currCdVal;
			    	formObject.curr_cd.value = currCdVal;
			    	//formObject.curr_cd.value = currCd;
			    	//============================================================================================*/
			    	
			    	//iss_dt 를 현재 날짜로 만든다.
					setToday(document.form.iss_dt, 'ymd');
					setToday(document.form.rcv_dt, 'ymd');
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
					isRClick = false;
					//SHEET2 CLEAR
	  	          	sheetObj2.CellValue2(1, "sheet2_arrtp") = "";
	  	    		sheetObj2.CellValue2(1, "sheet2_deptp") = "";
	  	    		//sheetObj2.CellValue2(1, "sheet2_arrnt") = "";
	  	    		//sheetObj2.CellValue2(1, "sheet2_depnt") = "";
	  	    		sheetObj2.CellValue2(1, "sheet2_arrtuh") = "";
	  	    		sheetObj2.CellValue2(1, "sheet2_deptuh") = "";
	  	    		sheetObj2.CellValue2(1, "sheet2_arrlh") = "";
	  	    		sheetObj2.CellValue2(1, "sheet2_deplh") = "";
	  	    		sheetObj2.CellValue2(1, "sheet2_usdhrs") = "";
            	break;
  	            	
  	            case "curr_cd":		//[2010.04.15:jmh] add	
            	break;
  	            
  	            default :
  	            	if(srcName == "trns_slp" && srcName != "curr_cd" && srcName.indexOf("cbx")==-1){    
  	            		// Currency CD는 변경 될 수 있어서 제외 checkbox도 대상에서 제외
  	            		// Tranfer Slip check도 제외 
  	            		isRClick = false;//전역 변수 클리어 
  	            	}
  	            	if(g_isEnterKey)
  	            		g_isEnterKey = false;
            	break;
  	        } // end switch isRmkModFlg
  		}catch(e) {
  			if( e == "[object Error]") {
  				ComShowCodeMessage('VSK00011');
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
    /**
     * keypress 함수
     * @return
     */
    function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	        	// CHM-201114111-01
	        	ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "float_plus":
	        	ComKeyOnlyNumber(obj);
	        	break;
	        case "eng":
	            ComKeyOnlyAlphabet(); break;
	        case "engup":
	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
	            else ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
	            else ComKeyOnlyAlphabet('lower');
	            break;
	    }
	    

	}
     
    //[2010.02.18:jmh] 
	function obj_click(){
		var formObj = document.form;
		obj = event.srcElement;      	
		
		if(obj.name == "credit_memo"){
			if(formObj.credit_memo.checked){
				//Sheet
				for(i=sheetObjects[0].HeaderRows; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
					sheetObjects[0].CellValue2(i, "sheet1_tariff_cost") = "";
					sheetObjects[0].CellValue2(i, "sheet1_foml1") = "";
					sheetObjects[0].CellValue2(i, "sheet1_foml2") = "";
				}
				//Calculation Button
				ComBtnDisable("btn_Calculation");
			} else{
				//Calculation Button
				ComBtnEnable("btn_Calculation");				
			}
		}	
	}    
    
    function obj_paste(){
    	var eleObj = event.srcElement;
    	var formObj = document.form;
    	
    	switch (eleObj.name) {
    		case "inv_no":
    			var clipboard = window.clipboardData.getData('Text');	//ClipBoard
    			if(clipboard.length > 20){
    				ComShowCodeMessage("PSO00045", "Invoice No.", "20");
    				return;
    			}
    		break;		
    	}
    }     

    //Drag & Drop으로 값을 입력하는 것은 배제함
    function obj_drop(){
    	event.returnValue = false;
    }
    
    //숫자 Validation
	function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
		switch(obj.name) {
			case "inv_amt":	//
				//f_ValidateCipherByCurrency(obj, false);		//(obj, deletion)
			break;
		}
	}
    
    /**
     * UI Blink 방지를 위한 처리 
     * @param sheetObj
     * @return
     */
	function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;    	
		
    	sheetObj.WaitImageVisible = false;

	    initControl();
	    
	    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	    
	    f_SetTrnsSlp();	//[2010.02.25:jmh] Transfer Slip Checkbox 활성화
	    
	    f_SetTitleInControls();	//Invoice No. setTitle
	    
	    sheetObj.WaitImageVisible = true; 
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

      var cnt = 0;
	  var sheetid = sheetObj.id;
      switch(sheetid) {

      	case "sheet1":
			with (sheetObj) {
					// 높이 설정
					style.height = 227;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					//var HeadTitle1 = "|Sel.|Seq.|VVD|VVD|VVD|Account\nCode|Cost\nCode|I/O|Code Description|Tariff Cost|Adjustment\nCost|Amount|Formula|Formula Value|Remark(s)|vndrSeq|ydCd|psoChgStsCd|usrId|InvNo|issCtyCd|soSeq|soDtlSeq|atd|ttlLocAmt|ttlTaxAmt|currCd|effDt|validvvd|night|holiday|boat|tugrope|buoy|sanitation|barge|inspection|newservice|copilot|arrtp|deptp|arrnt|depnt|arrtuh|deptuh|arrlh|deplh|usdhrs|psoTrnsSlpCtnt|issDt|acptDt|ydChgNo|ydChgVerSeq";
					//[2010.02.08:jmh]
					var HeadTitle1 = "||Seq.|VVD|VVD|VVD|VVD|Acct CD|Cost CD|Expiry From|Expiry To|I/O|Code Description|EX-Rate|Tariff Cost|ADJ. Cost|INV.AMT|Credit|TPB|TPB|Formula|Expression|type|rmk|n3rdVndrSeq|Remark(s)|Remark(s)|vndrSeq|ydCd|psoChgStsCd|usrId|InvNo|issCtyCd|soSeq|soDtlSeq|atd|invLoclAmt|ttlLocAmt|ttlTaxAmt|whldTaxAmt|currCd|effDt|validvvd|costOfc|night|holiday|boat|tugrope|buoy|sanitation|barge|inspection|newservice|copilot|arrtp|deptp|arrnt|depnt|arrtuh|deptuh|arrlh|deplh|usdhrs|bafrt|psoTrnsSlpCtnt|issDt|acptDt|ydChgNo|ydChgVerSeq|sameCurrCdYn|";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
					InitHeadMode(false, false, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					var prefix = "sheet1_";
					//데이터속성    	[  ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		prefix+"ibflag");
            		InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,		"Seq");
					//[2010.02.08:jmh]
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"vvd",				true,		"",		dfNone,			0,		true,		true,	9, true);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	true,		prefix+"vsl_cd",			false,		"",		dfEngUpKey,		0,		false,		false, 		4);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	true,		prefix+"skd_voy_no",		false,		"",		dfNone,			0,		false,		false,		4);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	true,		prefix+"skd_dir_cd",		false,		"",		dfEngUpKey,		0,		false,		false,		1);
					InitDataProperty(0, cnt++ , dtCombo,		65,		daCenter,	true,		prefix+"acct_cd",			true,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix+"cost_cd",			true,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEditFormat,      90,		    daCenter,	true,		prefix+"cost_calc_eff_fm_dt",  			false,	"",			dfDateYmd ,		0,		true,  true);
					InitDataProperty(0, cnt++ , dtPopupEditFormat,		90,			daCenter,	true,		prefix+"cost_calc_eff_to_dt",  			false,	"",			dfDateYmd,		0,		true,  true);
					InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,		prefix+"io",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,  	   140,	    daLeft,		true,		prefix+"lgs_cost_full_nm",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,  	    60,		daRight,	true,		prefix+"mnl_inp_xch_rt",	false,		"",		dfNullFloat,    3,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"tariff_cost",		false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	80,		daRight,	true,		prefix+"adjcost",			false,		"",		dfNullFloat,	3,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,		prefix+"amount",			false,		"|sheet1_tariff_cost|+|sheet1_adjcost|"/*jmh*/,		dfNullFloat,	2,		true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"credit",			false,		"",		dfNone,			0,		true,		true,	-1,	false,	true,	"",	false);
					InitDataProperty(0, cnt++ , dtCombo,		20,		daCenter,	true,		prefix+"n3pty_bil_if_flg",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopup,		20,		daCenter,	true,		prefix+"n3pty_bil_popup",	false,		"",		dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,			120,		daLeft,		true,		prefix+"foml1",				false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,		daLeft,		true,		prefix+"foml2",				false,		"",		dfNone,			0,		false,		false);
//							InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		prefix+"cond1",				false,		"",		dfNone,			0,		true,		true);
//							InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,		prefix+"cond2",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,		prefix+"n3pty_bil_tp_cd",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,		prefix+"if_rmk",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,		prefix+"n3pty_vndr_seq",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,		prefix+"remark",			false,		"",		dfHanKey,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopup,		20,		daLeft,		true,		prefix+"remark_popup",		false,		"",		dfNone,			0,		true,		true);
					
					//From Here Hidden
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"vndr_seq",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"yd_cd",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"pso_chg_sts_cd",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"usr_id",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"inv_no",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"iss_cty_cd",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"so_seq",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"so_dtl_seq",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"atd",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"inv_locl_amt",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"ttl_locl_amt",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"locl_tax_amt",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"locl_whld_tax_amt",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"curr_cd",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"eff_dt",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"validvvd",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"cost_ofc_cd",		false,		"",		dfNone,			0,		true,		true);
					
					//Manual Input관련 
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"night",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"holiday",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"boat",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"tugrope",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"buoy",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"sanitation",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"barge",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"inspection",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"newservice",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"copilot",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"arrtp",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"deptp",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"arrnt",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"depnt",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"arrtuh",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"deptuh",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"arrlh",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"deplh",				false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"usdhrs",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"baf_rt",		  	false,		"",		dfNullFloat,	2,		true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"pso_trns_slp_ctnt",	false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"iss_dt",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"acpt_dt",			false,		"",		dfNone,			0,		true,		true);
					
					//--> 2010.01.27 add 
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"yd_chg_no",			false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"yd_chg_ver_seq",	false,		"",		dfNone,			0,		true,		true);
					// 2010.08.23 이준범 Hidden 컬럼추가
					InitDataProperty(0, cnt++ , dtHidden,	    50,		daCenter,	true,		prefix+"io_chk",			false,		"",		dfNone,			0,		true,		true);
					// 2014.07.25 이성훈 Hidden 컬럼추가
					InitDataProperty(0, cnt++ , dtHidden,	    50,		daCenter,	true,		prefix+"trf_curr_cd",		false,		"",		dfNone,			0,		true,		true);					
				    //<<------- end 
					
					

					//[2010.02.08:jmh]
					InitDataValid(0, prefix+"vvd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix+"vsl_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix+"skd_voy_no", vtNumericOnly);
					InitDataValid(0, prefix+"skd_dir_cd", vtEngUpOnly);
					//InitDataValid(0, prefix+"remark", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
					
					
//							InitDataCombo(0, prefix+"acct_cd", "511711|5541111", "511711|5541111");
					InitDataCombo(0, prefix+"io", 	   " |IN|OUT", "INOUT|IN|OUT");
//							InitDataCombo(0, prefix+"cond1", " |Night|Holiday", " |Night|Holiday");
//							InitDataCombo(0, prefix+"cond2", " |Y|N|", " |Y|N|");
					InitDataCombo(0, prefix+"n3pty_bil_if_flg", "Y|N|", "Y|N|");

					ShowButtonImage = 2;
//							ImageList(0) = "img/btns_search.gif";
				}
	    break;
	      	
      	case "sheet2":
			with (sheetObj) {
				// 높이 설정
				style.height = 43;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				//var HeadTitle1 = "Object||Arr.TP|Dep.TP|Arr.NT|Dep.NT|Arr.TUH|Dep.TUH|Arr.LH|Dep.LH|Used.Hr|Condition|Remark(s)|";
				var HeadTitle1 = "Object||Arr.TP|Dep.TP|Arr.TUH|Dep.TUH|Arr.LH|Dep.LH|Used.Hr|Condition|Remark(s)|";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 1, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
				InitHeadMode(true, false, false, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				var prefix = "sheet2_"
					//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  			KEYFIELD, 	CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			107,	daCenter,	true,		"object",			false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"Status");                   		                        	
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"arrtp",		false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Arrival Tug Power");
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"deptp",		false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Departure Tug Power");
					//InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,		prefix+"arrnt",		false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Arrival Number of Tug");
					//InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,		prefix+"depnt",		false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Departure Number of Tug");
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"arrtuh",	false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Arrival Tug Used Hour");
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"deptuh",	false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Departure Tug Used Hour");
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"arrlh",		false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Arrival Line Handling Hour");
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"deplh",		false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Departure Line Handling Hour");
					InitDataProperty(0, cnt++ , dtData,			115,		daCenter,	true,		prefix+"usdhrs",	false,		"",			dfNullFloat,	2,			true,		true, 		6,			false,	false, 		"Used Hour");
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,		prefix+"Condition2",false,		"",			dfNullInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"Remark",	false,		"",			dfNullInteger,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");
				
//						InitDataCombo(0, "Condition1", "Night|Holiday", "Night|Holiday");
//						InitDataCombo(0, "Condition2", "|||", "|||");
				
				//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
			    InitHeadColumn(0, "Value", daCenter);
//					    InitHeadColumn("col2", "시    가|종    가|시 간 외|합계|시간외|총합계");
			    
			    CountPosition = 0;
				
			}
		break;
			
		case "sheet3":	//Dummy Sheet
			with (sheetObj) {
				// 높이 설정
				style.height = 100;
		
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
		
				var HeadTitle1 = "M|F";
				var headCount = ComCountHeadTitle(HeadTitle1);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
				InitHeadMode(false, false, true, true, false, false);
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "sheet3_";
		
				//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag"		);
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"uk",			false,		"",			dfNumber,	4,		true,  		true, 		14);	//Unique, Hidden
		
				CountPosition = 2;
				ShowButtonImage = 1;
		
			}
		break;			
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction ) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];

		var saveObjs = new Array(2);
		saveObjs[0] = sheetObject1;
		saveObjs[1] = sheetObject2;
		
		sheetObject1.WaitImageVisible=false;
		sheetObject2.WaitImageVisible=false;
		
        switch(sAction) {

          case IBSEARCH:      //조회
           		if(!validateForm(sheetObj, formObj, sAction)) return;
           		
           		//서버호출 전 실행해야될 전처리작업 정의
           		initDoActionIBSheet(sheetObj, formObj, sAction);
           		
           		if ( sheetObj.id == "sheet1"){
           			ComOpenWait(true);
           			formObj.f_cmd.value = SEARCH;//2번으로 
           			formObj.vndr_seq.value = formObj.spcode.value;//vndr_seq설정
        			sheetObj.DoSearch("VOP_PSO_0014GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
        			var stsCd = sheetObj.CellValue(1, "sheet1_pso_chg_sts_cd");
        			if(typeof stsCd == "string"){
        				formObj.pso_chg_sts_cd.value = stsCd; 
        				if(stsCd==="A"){//Complete 상태의 경우 Save // Confirm Button 비활성화 
        					ComBtnDisable("btn_Save");
        					ComBtnDisable("btn_Confirm");
        					ComBtnDisable("btn_RowAdd");
        					ComBtnDisable("btn_RowDelete");
        					ComBtnDisable("btn_Calculation");
        					ComBtnEnable("btn_Delete");
        					sheetObj.Editable = false;
        					document.getElementById("btn_del").innerHTML = "Confirm Cancel";
        				}
        				else{
        					if(sheetObj.RowCount !== 0)
        						ComBtnEnable("btn_Save");
        					ComBtnEnable("btn_Confirm");
        					ComBtnEnable("btn_Delete");
        					ComBtnEnable("btn_RowAdd");
        					ComBtnEnable("btn_RowDelete");
        					ComBtnEnable("btn_Calculation");
        					document.getElementById("btn_del").innerHTML = "Delete";
        				}
        			}
        			
        			if(sheetObj.RowCount === 0){//조회 데이터가 없는 경우
        				//sheetObj.ColHidden("sheet1_cost_calc_eff_fm_dt") = true;
        				//sheetObj.ColHidden("sheet1_cost_calc_eff_to_dt") = true;
        			  if(!g_isExist)
        					ComBtnEnable("btn_Save");
        				ComBtnDisable("btn_Confirm");
    					ComBtnDisable("btn_Delete");
        			}
        			else{
        				formObj.vvdband.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_cd") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_voy_no") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_dir_cd");
        	    		formObj.atd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_atd"); 
//        				formObj.inv_amt.value = sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount");
//        				formObj.calc_amt_vvd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_amount");
        	    		setCalcAmtVvd();
        				formObj.calc_amt_ttl.value = Number(sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")).toFixed(2);
        				formObj.yd_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_yd_cd");

        				
        				//formObj.inv_amt.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_ttl_locl_amt");	//
        				formObj.inv_amt.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_inv_locl_amt");	//xxx
        				formObj.vat.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_locl_tax_amt");		//VAT
        				formObj.whld_tax.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_locl_whld_tax_amt");		//Withholding Tax
        				formObj.curr_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_curr_cd");
//        				formObj.eff_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_eff_dt");
        				
        				formObj.trnsf_slp.checked = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_pso_trns_slp_ctnt") == "AR" ? true : false ;
        				
        				formObj.iss_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_iss_dt");
        				formObj.rcv_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_acpt_dt");
        				
        				
        				ComChkObjValid(form.inv_amt);
        		    	ComChkObjValid(form.vat);
        		    	ComChkObjValid(form.iss_dt);
        		    	ComChkObjValid(form.rcv_dt);
        		    	
        		    	ComChkObjValid(formObj.calc_amt_vvd);
        		    	ComChkObjValid(formObj.calc_amt_ttl);
        		    	
        		    	if(formObj.curr_cd.value != sheetObj.CellValue(1, "sheet1_trf_curr_cd")){
        		    		sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = false; // 2016.01.25
    			    	}
        		    	
        		    	formObj.cost_ofc.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_cost_ofc_cd");
        		    	
        		    	var tFlag = f_ExistsTonnage();
        		    	
        		    	if(tFlag == 'Y')  {
        		        	for (var i=sheetObject1.HeaderRows ; i<sheetObject1.RowCount+sheetObject1.HeaderRows; i++) {
    			    		     fnSetEnableExpireDate(i);
    			        	}
        		    	}
        		 
        			}
        			ComOpenWait(false);
           		}
			break;
				
			case IBSAVE:        //저장
		        if(!validateForm(sheetObj,formObj,sAction)) {
		            return false;
		        }//end if
	    		formObj.f_cmd.value = MULTI;

	    		//formObj.ttl_loc_amt.value = formObj.inv_amt.value;	//[2010.04.07:jmh]Total SO Local Amount

	          	var SaveStr = ComGetSaveString(saveObjs); // 배열입니다.
				if(SaveStr == undefined || SaveStr.length <= 0 ) return;
				
				//return false;
				ComOpenWait(true);
				var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열	
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);
				var data = ComGetEtcData(sXml,"Exception");

				if(data == null || data==""){
				  
				  if( typeof (sXml) == "undefined" ) return;
				  
				  var errCode = ComGetEtcData(sXml, "ERRCODE");//서버에 ERR코드가 있으면 
					
					if(errCode == null || errCode==""){
						if(sXml.indexOf("<ERROR>")==-1){//다른쪽에 에러가 없으면 
			              	ComBtnEnable("btn_Confirm");
			              	ComBtnEnable("btn_Delete");
							doActionIBSheet(sheetObject1, document.form, IBSEARCH);
		  					isRClick = true;
						}
					}
				}
				sheetObject1.LoadSaveXml(sXml);
          	break;
	          	
			case IBDELETE:        //Delete or Cancel
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
//				sheetObj.ShowMsgMode = true;
				ComOpenWait(true);
				formObj.f_cmd.value = REMOVE;
//				sheetObj.ShowMsgMode = false;
				var retVal = sheetObj.DoSave("VOP_PSO_0014GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
				if(retVal != false){
//					ComBtnDisable("btn_Confirm");
//					ComBtnDisable("btn_Delete");
//					formObj.vvdband.value = "";
//					formObj.atd.value = ""; 
//					formObj.calc_amt_vvd.value = "";

					//[2010.02.18:jmh]
					var stsCd = formObj.pso_chg_sts_cd.value; 
					if(stsCd==="A"){	//Confirm Cancel시 업데이트후 재조회
						document.getElementById("btn_del").innerHTML = "Delete";
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						sheetObject1.Editable = true;
						isRClick = true;
						
					} else{
						
						ComBtnEnable("btn_Save");
						ComBtnDisable("btn_Confirm");
						ComBtnDisable("btn_Delete");
						ComBtnEnable("btn_RowAdd");
						ComBtnEnable("btn_RowDelete");
						ComBtnEnable("btn_Calculation");
						formObj.reset();
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						sheetObject1.Editable = true;
						var dspNm = eval("tmnlName._"+formObj.yd_cd.value);
						dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
						formObj.tmnl_nm.value = dspNm;
						var ofcNm = eval("costOfc._"+formObj.yd_cd.value);
						ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
						formObj.cost_ofc.value = ofcNm;
						
						//User의 CUrrency CD설정 
						/*============================================================================================
						에러 사항 수정. 2014.08.12 
						1. Terminal Code 입력 이후 Invoice No. 입력하면 해당 터미널 code가 처음 것으로 변경됨
						   따라서 유저가 입력한 값 그대로 존재하도록 로직 수정 필요
						 ==============================================================================================						
						var currCdVal = eval("currCdList._"+formObj.yd_cd.value);
						currCdVal = (typeof currCdVal === "undefined") ? "" : currCdVal;
						formObj.curr_cd.value = currCdVal;
						//formObj.curr_cd.value = currCd;
						//============================================================================================*/
						
						//iss_dt 를 현재 날짜로 만든다.
						setToday(document.form.iss_dt, 'ymd');
						setToday(document.form.rcv_dt, 'ymd');
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
						isRClick = false;
					}
					
				}
			break;
				
			case IBSEARCH_ASYNC01://WindowOpen시 초기 데이터 쿼리
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = COMMAND01;//
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				var comboData = ComGetEtcData(sXml, "ACCTCOSTCDLIST");
				var comboItems1= "";
				var comboItems2= "";
				var comboItems3= "";
				var comboItems4 ="";
				
				if(comboData.length > 0 ){
					
					comboItems = comboData.split("|");
					for (var i = 0 ; i < comboItems.length ; i++) {
						
						var comboItem = comboItems[i].split("");
						if( i == 0 ){
							comboItems1 = comboItem[0]+"\t"+comboItem[3];
							comboItems4 = comboItem[0];
							comboItems2 = comboItem[1]; 
							comboItems3 = comboItem[2]; 
//							eval("vndrLglEngNm._init = \""+comboItem[2]+"\""); 
						} else {
							comboItems1 = comboItems1 + "|" +comboItem[0]+"\t"+comboItem[3];
							comboItems4 = comboItems4 + "|" +comboItem[0];
							comboItems2 = comboItems2 + "|" +comboItem[1]; 
							comboItems3 = comboItems3 + "|" +comboItem[2]; 
						}
						eval("vndrLglEngNm._"+comboItem[0]+" = \""+comboItem[2]+"\"");
						eval("vndrLglEngNm._"+comboItem[1]+" = \""+comboItem[2]+"\"");					
					}  
				}
				
				sheetObj.InitDataCombo(0, "sheet1_acct_cd", " |"+comboItems1, " |"+comboItems2, "", "", 0);
				sheetObj.InitDataCombo(0, "sheet1_cost_cd", " |"+comboItems2, " |"+comboItems4);
//				sheetObj.InitDataCombo(0, "sheet1_lgs_cost_full_nm", comboItems3, comboItems2);
				
				var ydCdData = ComGetEtcData(sXml, "YDCDLIST");
				if(ydCdData.length > 0 ){
					var selYdCd = document.getElementById("sel_yd_cd");
					ydCdItems = ydCdData.split("|");
					for(var i=0; i < ydCdItems.length; i++){
						var ydCdItem = ydCdItems[i].split("");
						option = document.createElement("option");
			            option.value = ydCdItem[0];
			            option.appendChild(document.createTextNode(ydCdItem[0]));
			            if(i==0)
			            	option.selected = "selected";
			            ydCdItem[1] = ydCdItem[1].replace(/"/gi, "\\\"");	//[2010.03.29:jmh] Terminal명에 큰따옴표(")가 있어서 문제됨. 
			            eval("tmnlName._"+ydCdItem[0]+" = \""+ydCdItem[1]+"\"");
			            eval("costOfc._"+ydCdItem[0]+" = \""+ydCdItem[2]+"\"");
			            eval("currCdList._"+ydCdItem[0]+" = \""+ydCdItem[3]+"\"");//CURR_CD LIST
			            selYdCd.appendChild(option);
			            formObj.tmnl_nm.value = eval("tmnlName._"+selYdCd.value); 
			            formObj.cost_ofc.value = eval("costOfc._"+selYdCd.value); 
			            currCd = eval("currCdList._"+selYdCd.value); 
					}
				}
				
				var CurrencyData = ComGetEtcData(sXml, "CURRENCYLIST");
				if(CurrencyData.length > 0 ){
					var selCurrency = document.getElementById("sel_curr_cd");
					CurrencyItems = CurrencyData.split("|");
					for(var i=0; i < CurrencyItems.length; i++){
						var CurrencyItem = CurrencyItems[i].split("");
						option = document.createElement("option");
						option.value = CurrencyItem[0];
						option.appendChild(document.createTextNode(CurrencyItem[0]));
						option.title = CurrencyItem[1];
						option.decimal_point = CurrencyItem[3];			//[2010.04.15:jmh]
						if(currCd === CurrencyItem[0]){//Terminal CD의 Curr CD설정
							option.selected = "selected";
							currCd = CurrencyItem[0];
						}
						selCurrency.appendChild(option);
					}
				}
				
				var vendorData = ComGetEtcData(sXml, "VENDORLIST");
				if(vendorData.length > 0 ){
					vendorItems = vendorData.split("|");
					for(var i=0; i < vendorItems.length; i++){
						var vendorItem = vendorItems[i].split("");
						 eval("vndrEngNm._"+vendorItem[0]+" = \""+vendorItem[1]+"\""); 
						 eval("vndrEngNm._"+vendorItem[0]+"_DEL = \""+vendorItem[2]+"\"");
					}
				}
				
			break;		
				
			case IBSEARCH_ASYNC02: //Confirm Button Click처리 
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}			
			//>>[2010.04.06:jmh]
				if(!checkInvoiceAmount()) return; 

				//formObj.f_cmd.value = COMMAND02;//[2010.05.11:jmh]
				formObj.f_cmd.value = MULTI02;//[2010.05.11:jmh]

			  	var SaveStr = ComGetSaveString(saveObjs, true, true); // 배열입니다.
			  	sheetObj.ShowMsgMode = false; 
			  	
				if(SaveStr.length <= 0 ) return;
				ComOpenWait(true);
				var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열	
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));				
				ComOpenWait(false);
				var exceptionData = ComGetEtcData(sXml, "Exception");

				if(exceptionData != null ){
					if(exceptionData.length > 0){
						ComBtnEnable("btn_Confirm");
						ComBtnEnable("btn_Save");
					}
					else{//성공하면 Button을 Disable시킨다.
						if(sXml.indexOf("<ERROR>")==-1){//다른쪽에 에러가 없으면 
//							ComBtnDisable("btn_Confirm");
//							ComBtnDisable("btn_Save");
//							formObj.pso_chg_sts_cd.value = "A";
//							document.getElementById("btn_del").innerHTML = "Confirm Cancel";
							doActionIBSheet(sheetObject1, document.form, IBSEARCH);
						}
					}
				}
				else{//성공하면 Button을 Disable시킨다.
					var errCode = ComGetEtcData(sXml, "ERRCODE");//서버에 ERR코드가 있으면 
					if(errCode == null || errCode==""){
						if(sXml.indexOf("<ERROR>")==-1){//다른쪽에 에러가 없으면 
//							ComBtnDisable("btn_Confirm");
//							ComBtnDisable("btn_Save");
//							formObj.pso_chg_sts_cd.value = "A";
							doActionIBSheet(sheetObject1, document.form, IBSEARCH);
						}
					}
				}
				sheetObjects[2].LoadSaveXml(sXml);
				sheetObj.ShowMsgMode = true;
			break;
				
			case IBSEARCH_ASYNC03: //VVD Level Check 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND03;//
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				ComOpenWait(false);
				var vvdLeveChek = ComGetEtcData(sXml, "VALIDVVD");
				return vvdLeveChek;
			break;
				
			case IBSEARCH_ASYNC04: //grid 에서 유저가 입력한 VVD가 VSK_VSL_PORT_SKD에 존재하는가 확인
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND04;//
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				ComOpenWait(false);
				var arr = new Array();
				var skdFlag = ComGetEtcData(sXml, "SKDEXIST");
				var flag = ComGetEtcData(sXml, "ISEXIST");
				var turnPortIndCd = ComGetEtcData(sXml, "TURNPORTINDCD");
				if(turnPortIndCd==="D" || turnPortIndCd=== "V"){
					arr[0] = turnPortIndCd;
					ComShowMessage("This is Virtual Port. Please Input VVD Again.");
					return arr;
				}
				if(skdFlag === "N"){
					arr[0] = skdFlag;
					ComShowMessage("Schedule doesn't exist.");
					return arr;
				}else{
					//Checking Yard Skip
	    			var skdCngStsCd = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC09);
	    			arr[0] = flag;
	    			arr[1] = skdCngStsCd;

					if(flag === "N"){
						var tmnl_cd = formObj.yd_cd.value;
						ComShowMessage("Not created Actual SKD at [" + tmnl_cd + "] or The Carrier code is not SML.");
					}
				}
				
				return arr;
			break;
				
			case IBSEARCH_ASYNC05://자동 Calculation 의 로직을 돌린다.
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				sheetObj.CellValue(sheetObj.SelectRow,"sheet1_cost_calc_eff_fm_dt") = "";
				sheetObj.CellValue(sheetObj.SelectRow,"sheet1_cost_calc_eff_to_dt") = "";
				formObj.f_cmd.value = COMMAND05;//
				formObj.rowIdx.value = sheetObj.SelectRow;//현재 선택된 Row 의 인덱스
				//-----------> 메뉴얼 값 Parameter
				formObj.night.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_night");
				formObj.holiday.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_holiday");
				formObj.boat.value 			= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_boat");
				formObj.tugrope.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_tugrope");
				formObj.buoy.value 			= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_buoy");
				formObj.sanitation.value 	= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_sanitation");
				formObj.barge.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_barge");
				formObj.inspection.value 	= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_inspection");
				formObj.newservice.value 	= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_newservice");
				formObj.copilot.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_copilot");
				formObj.arrtp.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_arrtp");
				formObj.deptp.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_deptp");
				formObj.arrnt.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_arrnt");
				formObj.depnt.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_depnt");
				formObj.arrtuh.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_arrtuh");
				formObj.deptuh.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_deptuh");
				formObj.arrlh.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_arrlh");
				formObj.deplh.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_deplh");
				formObj.usdhrs.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_usdhrs");
				formObj.baf_rt.value 		= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_baf_rt");
				
				fnSetEnableExpireDate(sheetObj.SelectRow);
				
				//메뉴얼 값 설정<<------------ 
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");

				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
			
				sheetObjects[2].LoadSearchXml(sXml); 
			
				//f_DataRowHeight(sheetObj.SelectRow);	//해당Row DataRowHeight 늘이기
				f_DataRowHeight(0);	//해당Row DataRowHeight 늘이기
				ComOpenWait(false);
				var calcInfo = ComGetEtcData(sXml, "CALCINFO");
			
				return calcInfo;
			break;
			
			case IBSEARCH_ASYNC06://Issue Date를 입력시 Effective Date 를 조회한다.
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = COMMAND06;//
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				var effDt = ComGetEtcData(sXml, "EFFDT");
//				formObj.eff_dt.value = effDt;
			break;
			
			case IBSEARCH_ASYNC07://Checked Rows의 Calculation 로직을 돌린다.
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND07;//
				//var SaveStr = ComGetSaveString(saveObjs);	//[2010.05.20:jmh]
				var SaveStr = ComGetSaveString(saveObjs, true, true);
				if(SaveStr.length <= 0 ){
					ComOpenWait(false);
					return;
				}
				var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);
				sheetObject1.LoadSaveXml(sXml);
				f_DataRowHeight(0);	//모든 DataRowHeight 늘이기
				setCalcAmtVvd();
    			formObj.calc_amt_ttl.value = Number(sheetObject1.CellValue(sheetObject1.RowCount+1, "sheet1_amount")).toFixed(2);
    			ComChkObjValid(formObj.calc_amt_vvd);
		    	ComChkObjValid(formObj.calc_amt_ttl);
		    	
		    	for(i=sheetObject1.HeaderRows;i<sheetObject1.LastRow;i++) {
		    		if(sheetObject1.cellValue(i,"sheet1_io_chk")=="Y" || sheetObject1.CellValue(i, "sheet1_io") !=  "INOUT") {
			    		sheetObject1.CellEditable(i,"sheet1_io") = true;
			    		sheetObject1.CellComboItem(i, "sheet1_io", "IN|OUT", "IN|OUT");
			    	} else {
			    		sheetObject1.CellEditable(i,"sheet1_io") = false;
			    		sheetObject1.CellComboItem(i, "sheet1_io", " |IN|OUT", "INOUT|IN|OUT");
			    	}
		    	}
			break;
			
			case IBSEARCH_ASYNC08://입력된 Inv_no가 존재하는 지 체크한다. 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = COMMAND08;//
				var SaveStr = ComGetSaveString(saveObjs); // 배열입니다.
//				if(SaveStr.length <= 0 ) return;
				var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		      //2014.12.15 ALERT 내용 변경
				var rtVal = ComGetEtcData(sXml, "ISINVOEXIST");
	
//				sheetObject1.LoadSaveXml(sXml);
				return rtVal;
//				formObj.calc_amt_vvd.value = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_amount");
//				formObj.calc_amt_ttl.value = sheetObject1.CellValue(sheetObject1.RowCount+1, "sheet1_amount");
//				ComChkObjValid(formObj.calc_amt_vvd);
//		    	ComChkObjValid(formObj.calc_amt_ttl);
			break;
			//각 페이지의 Sheet 이벤트 처리 함수를 실행하는 전역 변수
				
			case IBSEARCH_ASYNC09: //유저가 입력한 VVD의 Yard가 스킵인지 확인
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND09;//
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				ComOpenWait(false);
				var skdCngStsCd = ComGetEtcData(sXml, "SKIPYARD");
			    var yard = formObj.yd_cd.value;
				var vvd_cd = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_vvd");
				if(skdCngStsCd=="N"){
					ComShowMessage("This Yard ["+yard+"]" +" is Skipped in ["+vvd_cd+"]."+"\n"+"Please Check Vessel Schedule First.");
					
				}
				return skdCngStsCd;
			break;
				
			case IBSEARCH_ASYNC10: //Double Pay Check : VVD/VENDOR/COST_CD/COST_OFC/YD_CD를 체크해서 동일 Invoice 가 있는지 체크
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND10;//
				
				formObj.vndr_seq.value = formObj.spcode.value;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				ComOpenWait(false);
				var checkInv = ComGetEtcData(sXml, "CHECKINV");
				if(checkInv!=""){
					ComShowMessage("Same account code and S/P already exist on invoice no. ["+checkInv+"]" +"  . Pls check again to avoid double payment.");
				}
				return  checkInv;
			break;
			
			case IBSEARCH_ASYNC11: // Service Provider 에 등록된 Currency 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND11;
				
				formObj.vndr_seq.value = formObj.spcode.value;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				ComOpenWait(false);
				return ComGetEtcData(sXml, "CURR_CD");
			break;
			
			case IBSEARCH_ASYNC12: // tonnage expiry date 존재여부 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = COMMAND12;//
				var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do",  FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var rtVal = ComGetEtcData(sXml, "ISTONNAGE");
				return rtVal;
			break;
			
			case IBSEARCH_ASYNC13: // tug NO. 사용 계정인지 체크 2015-06-18 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = COMMAND13;//
				var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do",  FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var rtVal = ComGetEtcData(sXml, "ADDINFO");
				return rtVal;
		
			case IBSEARCH_ASYNC14: // BAF . 사용 계정인지 체크 2015-12-18 
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = COMMAND14;//
				var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
				var sXml = sheetObject1.GetSaveXml("VOP_PSO_0014GS.do",  FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var rtVal = ComGetEtcData(sXml, "BAF");
				return rtVal;
				
			break;
				
			case SEARCH01:
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				var data = ComGetEtcData(sXml,"inv_info");
				var invInfo = data.split("");
				if(invInfo!=""){
					var rslt = null;
					rslt = "Not confirmed below Invocie List:\n\nINV.No         S/P No.     VVD     Account CD\n======================================\n";
					for(var i=0; i<invInfo.length; i++){
						rslt = rslt+invInfo[i];
						if(i<invInfo.length-1){
							rslt = rslt+"\n";
						}
					}
					
					ComShowMessage(rslt);
				}
			break;
				
			case SEARCH02: // [CHM-201430328] [PSO] Port Charge invoice Creation 기능 개선 - 입력 VVD 에 해당하는 ATD 를 조회한다.
				formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0014GS.do", sParam);
				var atdData = ComGetEtcData(sXml, "ATD");
				formObj.atd.value = atdData;
    			sheetObj.CellValue(sheetObj.SelectRow, "sheet1_atd") = atdData;				
			break;
        }
    }

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction){
        		case IBSEARCH:
		        	if(spcode.value == ""){
		        		ComShowCodeMessage("PSO00003", "S/P Code");
		        		ComSetFocus(spcode);
		        		return false;
		        	}
		        	else if(inv_no.value == ""){
		        		ComShowCodeMessage("PSO00003", "INV No.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	else if(inv_no.value.trim().length < 3 ){
		        		ComShowMessage("INV No.'s lenght must be greater than 3.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	break;
		        	
        		case IBSEARCH_ASYNC02:	//Confirm
        		case IBSAVE:			//Save
        			
        			var invCurrCd = ComGetObjValue(formObj.curr_cd);	// Invoice Currency
        			var sheetObj  = sheetObjects[0];
        			
	        		for (var i=sheetObj.HeaderRows ; i<=sheetObj.LastRow; i++) {
	        			
	        			//Remark validate
		        		if (sheetObj.CellText(i, "sheet1_acct_cd") == "511791") {
		        			var rmk = ComTrimAll(sheetObj.CellValue(i, "sheet1_remark"));
		        			if(ComChkLen(rmk,5) == 1 || ComChkLen(rmk,5) == -1){
		        				ComShowMessage("More than 5 letters are required in Remark(s) fields when account code is 511791.");
		        				sheetObj.SelectCell(i, "sheet1_remark");
		        				return false;
		        			}
		        		}
		        		
		        		if (sheetObj.CellValue(i,"sheet1_vvd") != "" &&sheetObj.CellValue(i,"sheet1_adjcost") != "" && sheetObj.CellValue(i,"sheet1_remark") == "") {  //2015.06.11 
	        			    ComShowMessage("Remark is required input");
	        			    sheetObj.SelectCell(i, "sheet1_remark");
	        				return false;
	        	     	}
		        		
		        		if (sheetObj.CellText(i, "sheet1_acct_cd") == "511751" &&yd_cd.value.substr(0,5) != "CNHKG"&& ( yd_cd.value.substr(0,2) =="JP" || yd_cd.value.substr(0,2) =="IT" ||yd_cd.value.substr(0,2) =="CN" ) ) { 
		        		 if (sheetObj.CellText(i, "sheet1_cost_calc_eff_fm_dt") == "" || sheetObj.CellText(i, "sheet1_cost_calc_eff_to_dt") == "" ) {
		        			    ComShowMessage("Expiry Date is required input")
		        			    sheetObj.SelectCell(i, "sheet1_cost_calc_eff_fm_dt");
		        				return false;
		        			}
		        		 else {
		        		    if(sheetObj.CellText(i, "sheet1_cost_calc_eff_fm_dt") >= sheetObj.CellText(i, "sheet1_cost_calc_eff_to_dt"))	 
		        		    	{ ComShowMessage("Pls, check Expiry Date")
		        		    	  sheetObj.SelectCell(i, "sheet1_cost_calc_eff_fm_dt");
		        		    	  return false;
		        		    	 
		        		    	} 
		        		 }
		        			 
		        		}
		       
		        		//Exchange Rate validat (Invoice Currency와 Tariff Currency가 다른경우에는 Exchange Rate 필수입력)
		        		if (sAction == IBSAVE) {
		        			if (sheetObj.CellValue(i, "trf_curr_cd") != invCurrCd && sheetObj.CellValue(i, "mnl_inp_xch_rt") == "") {
		        				ComShowMessage("Exchange rate is required input");
		        				sheetObj.SelectCell(i, "mnl_inp_xch_rt");
		        				return false;
		        			}
		        		}
		        	}
        		
        		case IBDELETE:			//Delete or Cancel
        			if(spcode.value == ""){
		        		ComShowCodeMessage("PSO00003", "S/P Code");
		        		ComSetFocus(spcode);
		        		return false;
		        	}
		        	else if(inv_no.value == ""){
		        		ComShowCodeMessage("PSO00003", "INV No.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	else if(sel_yd_cd.value == ""){
		        		ComShowCodeMessage("PSO00003", "Terminal");
		        		ComSetFocus(sel_yd_cd);
		        		return false;
		        	}
		        	else if(inv_no.value.trim().length < 3 ){
		        		ComShowMessage("INV No.'s length must be greater than 3.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	//else if(inv_amt.value == "" || inv_amt.value == "0" || inv_amt.value == "0.00" || inv_amt.value == "0.0"){
		        	else if(inv_amt.value == ""){
		        		ComShowMessage("Invoice Amount must be greater than 0.");
		        		ComSetFocus(inv_amt);
		        		return false;
		        	}	
		        	else if(cost_ofc.value == ""){
		        		ComShowCodeMessage("PSO00003", "Cost Office");
		        		ComSetFocus(cost_ofc);
		        		return false;	
		        	}	
		        	else if(iss_dt.value == ""){
		        		ComShowCodeMessage("PSO00003", "Issue Date");
		        		ComSetFocus(iss_dt);
		        		return false;	
		        	}	
		        	else if(rcv_dt.value == ""){
		        		ComShowCodeMessage("PSO00003", "Receive Date");
		        		ComSetFocus(rcv_dt);
		        		return false;	
		        	}
		        	
		        	break;
        	}
        }

        return true;
    }
    
    /**
     * sheet1의 편집모드가 완료 될때 발생 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnAfterEdit(sheetObj, Row,Col){
//		var formObj = document.form ;
//		formObj.vsl_cd.value = sheetObj.CellValue(Row, "sheet1_vsl_cd");
//		formObj.skd_voy_no.value = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
//		formObj.skd_dir_cd.value = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
//    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
    }

    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var formObj = document.form ;
    	//>>[2010.02.08:jmh]
  
    	var colName = sheetObj.ColSaveName(Col);
  

    	if (colName == "sheet1_vvd") {
    		
    		// VVD 에 입력값이 9자리인 경우 
    		if (sheetObj.CellValue(Row, Col).length == 9) {
    			var sheet1_vvd = sheetObj.CellValue(Row, "sheet1_vvd");
    			popupCnt = 0;
    			popupCnt2 = 0;
    			formObj.vsl_cd.value     = sheet1_vvd.substr(0, 4);
    			formObj.skd_voy_no.value = sheet1_vvd.substr(4, 4);
    			formObj.skd_dir_cd.value = sheet1_vvd.substr(8, 1);    
    			
		    	var arr = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
		    	var flag = arr[0];
		    	var skdCngStsCd = arr[1];

		    	// flag, skdCngStsCd 값에 따른 로직처리 - 시작
		    	if (flag === "N" && skdCngStsCd === "S") {
	    			sheetObj.CellValue2(Row, "sheet1_vsl_cd") = "";
	    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no") = "";
	    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") = "";
	    			sheetObj.CellValue2(Row, "sheet1_vvd") = "";
		    	
		    		switch (colName) {//ValidaAJDU...tion Flag Clear 
			    		case "sheet1_vsl_cd":
			    			VALIDVVD = (VALIDVVD&4) === 4 ?  VALIDVVD - 4 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_voy_no":
			    			VALIDVVD = (VALIDVVD&2) === 2 ?  VALIDVVD - 2 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_dir_cd":
			    			VALIDVVD = (VALIDVVD&1) === 1 ?  VALIDVVD - 1 : VALIDVVD;
			    			break;
			    		default: break;	
		    		}
		    		
					sheetObj.CellValue2(Row, "sheet1_acct_cd") 		  = " ";
					sheetObj.CellValue2(Row, "sheet1_cost_cd") 		  = " ";
					sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
					sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_adjcost") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_amount") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_io") 			  = "";
		    		sheetObj.CellValue2(Row, "sheet1_vvd") 			  = "";
	    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";	 		    		
		    		sheetObj.SelectCell(Row, "sheet1_vvd");
		    		formObj.vvdband.value = "";
		    		return false;
		    		
		    	}
		    	else if (flag === "N" || skdCngStsCd === "S") {
		    		sheetObj.CellValue2(Row, "sheet1_vsl_cd") = "";
	    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no") = "";
	    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") = "";
	    			sheetObj.CellValue2(Row, "sheet1_vvd") = "";
		    	
		    		switch (colName){//Validation Flag Clear 
			    		case "sheet1_vsl_cd":
			    			VALIDVVD = (VALIDVVD&4) === 4 ?  VALIDVVD - 4 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_voy_no":
			    			VALIDVVD = (VALIDVVD&2) === 2 ?  VALIDVVD - 2 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_dir_cd":
			    			VALIDVVD = (VALIDVVD&1) === 1 ?  VALIDVVD - 1 : VALIDVVD;
			    			break;
			    		default: break;	
		    		}
					sheetObj.CellValue2(Row, "sheet1_acct_cd") 		  = " ";
					sheetObj.CellValue2(Row, "sheet1_cost_cd") 		  = " ";
					sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
					sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_adjcost") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_amount") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_io") 			  = "";
		    		sheetObj.CellValue2(Row, "sheet1_vvd") 			  = "";
	    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";	 			    		
		    		sheetObj.SelectCell(Row, "sheet1_vvd");
		    		formObj.vvdband.value = "";
		    		return false;
		    	 
		    	}
		    	else {
	    			sheetObj.CellValue2(Row, "sheet1_vsl_cd")     = sheet1_vvd.substr(0, 4);
	    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no") = sheet1_vvd.substr(4, 4);
	    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") = sheet1_vvd.substr(8, 1);
		    		
//			    	doActionIBSheet(sheetObjects[0],formObj,SEARCH02); // 선택된 Row 의 ATD 정보를 조회한다.
		    	
			    	if (flag === "D"|| flag=== "V") {//Turning Port이면 
			    		//sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") = "";;//skd_dir_cd만 클리어 
			    		//sheetObj.SelectCell(Row, "sheet1_skd_dir_cd");
			    		//>>[2010.02.08:jmh]
			    		sheetObj.CellValue2(Row, "sheet1_vvd") 		  = "";
				    	sheetObj.CellValue2(Row, "sheet1_vsl_cd") 	  = "";
				    	sheetObj.CellValue2(Row, "sheet1_skd_voy_no") = "";
				    	sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") = "";
				    	sheetObj.SelectCell(Row, "sheet1_vvd");
				    	formObj.vvdband.value = "";
				    	//<<[2010.02.08:jmh]
			    	} 
			    	else {	//valid pass 
			    		switch (colName) {
				    		case "sheet1_vsl_cd":
				    			VALIDVVD = (VALIDVVD&4) === 4 ?  VALIDVVD : VALIDVVD + 4;
				    			//기존의 VVD가 변경 되었으므로 초기화 처리 필요 
				    			sheetObj.CellValue2(Row, "sheet1_acct_cd") 		  = " ";
				    			sheetObj.CellValue2(Row, "sheet1_cost_cd") 		  = " ";
				    			sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
				    			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
				    			sheetObj.CellValue2(Row, "sheet1_adjcost") 		  = "";
				    			sheetObj.CellValue2(Row, "sheet1_amount") 		  = "";
				    			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";
				    			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
				    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no")	  ="";
				    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd")	  ="";
				    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
				    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";	 				    			
				    			break;
				    		case "sheet1_skd_voy_no":
				    			VALIDVVD = (VALIDVVD&2) === 2 ?  VALIDVVD : VALIDVVD + 2;
				    			break;
				    		case "sheet1_skd_dir_cd":
				    			VALIDVVD = (VALIDVVD&1) === 1 ?  VALIDVVD : VALIDVVD + 1;
				    			break;
				    		default: break;	
			    		}
			    		formObj.vvdband.value = sheet1_vvd;
			    	}
		    	} // flag, skdCngStsCd 값에 따른 로직처리 - 끝
    		} 
    		// VVD 에 입력값이 9자리가 아닌경우 
    		else {
    			
    			sheetObj.CellValue2(Row, "sheet1_vsl_cd") 		= "";
    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no") 	= "";
    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") 	= "";
    			sheetObj.CellValue2(Row, "sheet1_vvd") 			= "";
    		
    			VALIDVVD = (VALIDVVD&4) === 4 ?  VALIDVVD : VALIDVVD + 4;
    			//기존의 VVD가 변경 되었으므로 초기화 처리 필요 
    			sheetObj.CellValue2(Row, "sheet1_acct_cd") 		  = " ";
    			sheetObj.CellValue2(Row, "sheet1_cost_cd") 		  = " ";
    			sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
    			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
    			sheetObj.CellValue2(Row, "sheet1_adjcost") 		  = "";
    			sheetObj.CellValue2(Row, "sheet1_amount") 		  = "";
    			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";
    			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no")	  ="";
    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd")	  ="";
    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";	 
    			formObj.vvdband.value = "";
    		}
    		
    		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
    	}
    		
    	
    	//[2010.02.08:jmh] +1/*jmh*/ 
    	// I/O 에 값이 변경된 경우
    	if (colName == "sheet1_io"/*jmh*/ 
    			&& (VALIDVVD == 7 || sheetObj.CellValue(sheetObj.SelectRow,"sheet1_validvvd") == "") 
    			&& !formObj.credit_memo.checked/*jmh*/) {//In/out이 변할때도 Calc 
             
			if (sheetObj.CellValue(Row, "sheet1_vsl_cd") == "") {
				ComShowCodeMessage("PSO00003", "VSL_CD");
				//[2010.02.08:jmh]
				sheetObjects[0].SelectCell(Row,"sheet1_vvd");
			}
			else if(sheetObj.CellValue(Row, "sheet1_skd_voy_no") == ""){
				ComShowCodeMessage("PSO00003", "SKD_VOY_NO");
				//[2010.02.08:jmh]
				sheetObjects[0].SelectCell(Row,"sheet1_vvd");
			}
			else if(sheetObj.CellValue(Row, "sheet1_skd_dir_cd") == ""){
				ComShowCodeMessage("PSO00003", "SKD_DIR_CD");
				//[2010.02.08:jmh]
				sheetObjects[0].SelectCell(Row,"sheet1_vvd");
			}
			else {
				
        		formObj.vsl_cd.value 		 = sheetObj.CellValue(Row, "sheet1_vsl_cd");
        		formObj.skd_voy_no.value 	 = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
        		formObj.skd_dir_cd.value 	 = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
        		formObj.cost_cd.value 		 = sheetObj.CellValue(Row, "sheet1_acct_cd");
        		formObj.acct_cd.value 		 = sheetObj.CellText(Row, "sheet1_acct_cd");
        		formObj.io_flag.value 		 = sheetObj.CellText(Row, "sheet1_io");
        		formObj.mnl_inp_xch_rt.value = sheetObj.CellText(Row, "sheet1_mnl_inp_xch_rt");
        		
        		var isValidVvd = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);			
    				
    			//>>[2010.02.24:jmh]	
    			var credit = sheetObjects[0].CellValue(Row, "sheet1_credit");
    			var data = "NO_CALCULATION";
    			if (credit != "1") {	//Credit Unchecked!
    				data = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);		//Calculation	//[2010.02.24:jmh] Kim
    			}   
    
    			//<<[2010.02.24:jmh]
    			var ioCondChk = "N";
    			if (data == "NO_TARIFF_FOUND") {
    				ComShowCodeMessage("PSO00030");
    				//이전 값 클리어 
    				sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";	 
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = "";	 
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = "";
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = "";
	    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";
    			} 
    			else if (data == "NO_CALCULATION") {
    				sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
        			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
        			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";	 
        			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = "";	 
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = "";	  
	    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";	    			
    			} 
    			else {
	    			var calcData = data.split("");
	    			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = calcData[0];
	    			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = calcData[1];
	    			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = calcData[2];
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = calcData[3];	 
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = calcData[4];
	    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = calcData[7];
	    			ioCondChk = calcData[5];
	    			
	    			// Tariff Currency 와 Invoice Currency 가 다를 경우, Exchange Rate 컬럼을 추가해준다.
	    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") = calcData[6];
	    		
	    			//if(sheetObj.CellValue(Row, "sheet1_mnl_inp_xch_rt") != "") {
	    			//	  ComShowMessage("Please check Exchange Rate at first, If is in correct, Please change it.");
	    			//	}
	    			
	    			if (fnSetEnableExchangeRate(Row) && sheetObj.ColHidden("sheet1_mnl_inp_xch_rt")) {
	    				sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = false;
	    			}	    			
    			}
    			//
    			formObj.vvdband.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_cd") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_voy_no") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_dir_cd");

//    			formObj.calc_amt_vvd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_amount");
        		setCalcAmtVvd();
    			formObj.calc_amt_ttl.value = Number(sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")).toFixed(2);
    			
    			ComChkObjValid(formObj.calc_amt_vvd);
		    	ComChkObjValid(formObj.calc_amt_ttl);
		    	//2010.08.23 이준범
		    	if (ioCondChk == "Y") {
		    		sheetObj.CellEditable(Row,"sheet1_io") = true;
		    		sheetObj.CellValue2(Row, "sheet1_io_chk") = "Y";
		    	} 
		    	else {
		    		sheetObj.CellEditable(Row,"sheet1_io") = false;
		    		sheetObj.CellValue2(Row, "sheet1_io_chk") = "N"; 
		    		
		    	}		    	
			}
    	}
    
    	//adjust amt가 변경 될때 마다. Form의 값을 Update해야 된다. 
    	//2010.10.26 CHM-201006691  이석준 Credit이 체크된 상태에서 입력된 Adjustment Cost값이 (+)인 경우, 메시지를 띄워주고 Adjustment Cost 값을 공란으로 변경.
    	if (colName == "sheet1_adjcost") {
    		formObj.vvdband.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_cd") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_voy_no") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_dir_cd");
    		
    		var adj_amt  = Number(sheetObj.CellValue(Row,"sheet1_adjcost")); 
    		var cre_ind  = sheetObj.CellValue(Row,"sheet1_credit"); 
    		
    		if (adj_amt >0 && cre_ind =="1") {
    			ComShowCodeMessage("PSO01004");
    			sheetObj.CellValue2(Row,"sheet1_adjcost") ="";
    		}
    		setCalcAmtVvd();
			formObj.calc_amt_ttl.value = Number(sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")).toFixed(2);//"sheet1_tariff_cost"); //2009.11.24 . 
			
			ComChkObjValid(formObj.calc_amt_vvd);
	    	ComChkObjValid(formObj.calc_amt_ttl);
    	}
    	
        if (sheetObj.CellValue(Row, "sheet1_vsl_cd") != "" || sheetObj.CellValue(Row, "sheet1_skd_voy_no") != "" || sheetObj.CellValue(Row, "sheet1_skd_dir_cd") != "") {
	    	switch(colName) {
	    		case "sheet1_vsl_cd":
	    			formObj.vsl_cd.value = sheetObj.CellValue(Row, "sheet1_vsl_cd");
	    			formObj.skd_voy_no.value = "";
	    			formObj.skd_dir_cd.value = "";
	    			break;
	    		case "sheet1_skd_voy_no":
	    			formObj.vsl_cd.value = sheetObj.CellValue(Row, "sheet1_vsl_cd");
	    			formObj.skd_voy_no.value = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
	    			formObj.skd_dir_cd.value = "";
	    			break;
	    		case "sheet1_skd_dir_cd":
	    			formObj.vsl_cd.value = sheetObj.CellValue(Row, "sheet1_vsl_cd");
	    			formObj.skd_voy_no.value = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
	    			formObj.skd_dir_cd.value = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
	    			break;
	    		default:
	    			formObj.vsl_cd.value = sheetObj.CellValue(Row, "sheet1_vsl_cd");
	    			formObj.skd_voy_no.value = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
	    			formObj.skd_dir_cd.value = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
	    			break;
	    	}
	    	
	    	if (colName == "sheet1_vsl_cd" || colName == "sheet1_skd_voy_no" || colName == "sheet1_skd_dir_cd") {
	    		if (Value === "") {
	    			switch (colName){//Validation Flag Clear 
			    		case "sheet1_vsl_cd":
			    			VALIDVVD = (VALIDVVD&4) === 4 ?  VALIDVVD - 4 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_voy_no":
			    			VALIDVVD = (VALIDVVD&2) === 2 ?  VALIDVVD - 2 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_dir_cd":
			    			VALIDVVD = (VALIDVVD&1) === 1 ?  VALIDVVD - 1 : VALIDVVD;
			    			break;
			    		default: break;	
	    			}
	    			sheetObj.CellValue2(Row, "sheet1_acct_cd") = " ";
	    			sheetObj.CellValue2(Row, "sheet1_cost_cd") = " ";
	    			sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
	    			sheetObj.CellValue2(Row, "sheet1_tariff_cost") = "";
	    			sheetObj.CellValue2(Row, "sheet1_adjcost") = "";
	    			sheetObj.CellValue2(Row, "sheet1_amount") = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml1") = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml2") = "";
	    			sheetObj.CellValue2(Row, "sheet1_vvd") = "";
	    			sheetObj.SelectCell(Row, "sheet1_vvd");
		    		return false;
	    		}
	    		
	    		// Grid 입력 VVD Validation 
		    	var flag = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
		    	if (flag === "N") {
		    		switch (colName){//Validation Flag Clear 
			    		case "sheet1_vsl_cd":
			    			VALIDVVD = (VALIDVVD&4) == 4 ?  VALIDVVD - 4 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_voy_no":
			    			VALIDVVD = (VALIDVVD&2) == 2 ?  VALIDVVD - 2 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_dir_cd":
			    			VALIDVVD = (VALIDVVD&1) == 1 ?  VALIDVVD - 1 : VALIDVVD;
			    			break;
			    		default: break;	
		    		}
					sheetObj.CellValue2(Row, "sheet1_acct_cd") = " ";
					sheetObj.CellValue2(Row, "sheet1_cost_cd") = " ";
					sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
					sheetObj.CellValue2(Row, "sheet1_tariff_cost") = "";
	    			sheetObj.CellValue2(Row, "sheet1_adjcost") = "";
	    			sheetObj.CellValue2(Row, "sheet1_amount") = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml1") = "";
	    			sheetObj.CellValue2(Row, "sheet1_foml2") = "";
		    		sheetObj.CellValue2(Row, "sheet1_vvd") = "";
		    		sheetObj.SelectCell(Row, "sheet1_vvd");
		    		return false;
		    	}
		    	else if (flag == "D"|| flag == "V"){//Turning Port이면 
		    		sheetObj.CellValue2(Row, "sheet1_skd_dir_cd") = "";;//skd_dir_cd만 클리어 
		    		//[2010.02.08:jmh]
		    		sheetObj.SelectCell(Row, "sheet1_vvd");
		    	}
		    	else{//valid pass 
		    		switch (colName) {
			    		case "sheet1_vsl_cd":
			    			VALIDVVD = (VALIDVVD&4) == 4 ?  VALIDVVD : VALIDVVD + 4;
			    			//기존의 VVD가 변경 되었으므로 초기화 처리 필요 
			    			sheetObj.CellValue2(Row, "sheet1_acct_cd") = " ";
			    			sheetObj.CellValue2(Row, "sheet1_cost_cd") = " ";
			    			sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
			    			sheetObj.CellValue2(Row, "sheet1_tariff_cost") = "";
			    			sheetObj.CellValue2(Row, "sheet1_adjcost") = "";
			    			sheetObj.CellValue2(Row, "sheet1_amount") = "";
			    			sheetObj.CellValue2(Row, "sheet1_foml1") = "";
			    			sheetObj.CellValue2(Row, "sheet1_foml2") = "";
			    			sheetObj.CellValue2(Row, "sheet1_skd_voy_no")="";
			    			sheetObj.CellValue2(Row, "sheet1_skd_dir_cd")="";
			    			break;
			    		case "sheet1_skd_voy_no":
			    			VALIDVVD = (VALIDVVD&2) == 2 ?  VALIDVVD : VALIDVVD + 2;
			    			break;
			    		case "sheet1_skd_dir_cd":
			    			VALIDVVD = (VALIDVVD&1) == 1 ?  VALIDVVD : VALIDVVD + 1;
			    			break;
			    		default: 
			    			break;	
		    		}
		    	}
	    	}
        }
        else {
        	if (colName == "sheet1_vsl_cd" || colName == "sheet1_skd_voy_no" || colName == "sheet1_skd_dir_cd") {//&& sheetObj.CellValue(Row, "sheet1_vsl_cd") !== "CNTC")
        		//[2010.02.08:jmh]
        		sheetObjects[0].SelectCell(Row,"sheet1_vvd");
        	}	
        }
        //if(sheetObj.CellValue(Row, "sheet1_vsl_cd") !== "CNTC"){
        
        switch (colName){//Select List 처리 
        	case "sheet1_credit" :	//Credit
        		var credit = sheetObj.CellValue(Row, "sheet1_credit");
        		if (credit == "1") {
    				sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
        			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
        			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";	 
        			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = "";	 
	    			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = "";
	    			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
	    			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";	    			
	        		setCalcAmtVvd();	//calc_amt_vvd (선택된 Row의 동일 VVD의 Amount) 
	    			formObj.calc_amt_ttl.value = Number(sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")).toFixed(2);	//calc_amt_ttl
	    			ComChkObjValid(formObj.calc_amt_vvd);
	    	    	ComChkObjValid(formObj.calc_amt_ttl);
        		} 
        		else {
        			var acct_cd = sheetObj.CellValue(Row,"sheet1_acct_cd");
        			sheetObj.CellValue2(Row,"sheet1_acct_cd") = "";
        			sheetObj.CellValue(Row,"sheet1_acct_cd")  = acct_cd;
        		}
        	break;	
	        
	        case "sheet1_acct_cd":	//ACCT_CD

           	    doActionCalc(sheetObj, formObj, colName, Row, Value);
	        	
           	    if(sheetObj.CellValue(Row, "sheet1_acct_cd") != ''){
	        		//[2015-06-18] 
		        	var addinfo = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC13);
		        
		        	if(addinfo == "Y") {
		            	popupCnt = popupCnt + 1 ;
		            	var param  = "vvd=" + sheetObj.CellValue(Row, "sheet1_vvd");
		            	param += "&yd_cd=" + sheetObj.CellValue(Row, "sheet1_yd_cd");
		            	param += "&io=" + sheetObj.CellValue(Row, "sheet1_io");
		            	param += "&yd_chg_no=" + sheetObj.CellValue(Row, "sheet1_yd_chg_no");
		            	param += "&yd_chg_ver_seq=" + sheetObj.CellValue(Row, "sheet1_yd_chg_ver_seq");
		                ComOpenPopup("VOP_PSO_0217.do?" + param, 600, 230, "setAddinfo",'0,0' ,true, true);	
		            }
		            else { popupCnt = 0; }
		        	
		        	var bafinfo = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC14);
		        	if(bafinfo == "Y") {
		            	popupCnt2 = popupCnt2 + 1 ;
		            	var param  = "yd_cd=" + sheetObj.CellValue(Row, "sheet1_yd_cd");
		            	param += "&vndr_seq=" + sheetObj.CellValue(Row, "sheet1_vndr_seq");
		            	param += "&lgs_cost_cd=" + sheetObj.CellValue(Row, "sheet1_acct_cd");
		                ComOpenPopup("VOP_PSO_0218.do?" + param, 500, 230, "setBAFinfo",'0,0' ,true, true);	
		              }
		        	 else { popupCnt2 = 0; }
	        	}
	        break;
	        	 
	        case "sheet1_io":
	       
	        	  if(sheetObj.CellValue(Row, "sheet1_acct_cd") != ''){
			          var addinfo = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC13); 
			   
			          if(popupCnt == "1" && addinfo == "Y" ) {     	  
			            	var param  = "vvd=" + sheetObj.CellValue(Row, "sheet1_vvd");
			            	param += "&yd_cd=" + sheetObj.CellValue(Row, "sheet1_yd_cd");
			            	param += "&io=" + sheetObj.CellValue(Row, "sheet1_io");
			            	param += "&yd_chg_no=" + sheetObj.CellValue(Row, "sheet1_yd_chg_no");
			            	param += "&yd_chg_ver_seq=" + sheetObj.CellValue(Row, "sheet1_yd_chg_ver_seq");
			                ComOpenPopup("VOP_PSO_0217.do?" + param, 500, 230, "setAddinfo",'0,0' ,true, true);	
			         
			          }
			          
			          var bafinfo = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC14);
			          if(popupCnt2 == "1" && bafinfo == "Y" ) {     	  
			        	  var param  = "yd_cd=" + sheetObj.CellValue(Row, "sheet1_yd_cd");
			            	  param += "&vndr_seq=" + sheetObj.CellValue(Row, "sheet1_vndr_seq");
			            	  param += "&lgs_cost_cd=" + sheetObj.CellValue(Row, "sheet1_acct_cd");
			                  ComOpenPopup("VOP_PSO_0218.do?" + param, 500, 230, "setBAFinfo",'0,0' ,true, true);	
			         
			          }
	        	}
	          break;
	          
	        case "sheet1_cost_cd":	//COST_CD
        		doActionCalc(sheetObj, formObj, colName, Row, Value);
	        break;
	        
	        case "sheet1_mnl_inp_xch_rt":	//Exchange Rate
        		doActionCalc(sheetObj, formObj, colName, Row, Value);
	        break;
	        
	        case "sheet1_n3pty_bil_if_flg":
	        	if (Value=="Y") {
	        		root = "change";
        			openTpbPopup(sheetObj, Row, root);
	        	}
	        	else {
	        		sheetObj.CellValue2(Row, "sheet1_n3pty_bil_tp_cd") = "";
	        		sheetObj.CellValue2(Row, "sheet1_if_rmk") = "";
	        		sheetObj.CellValue2(Row, "sheet1_n3pty_vndr_seq") = "";
	        	}
	        	break;
	        	
	        default: break;
	   }//End of switch(Col)
       // }
    }


    
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	var formObj = document.form;
    	if(sheetObj.RowCount > 0 ){
    		formObj.vvdband.value = sheetObj.CellValue(Row, "sheet1_vsl_cd") + sheetObj.CellValue(Row, "sheet1_skd_voy_no") + sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
    		formObj.atd.value = sheetObj.CellValue(Row, "sheet1_atd"); 
    		setCalcAmtVvd();
    		
    		ComChkObjValid(formObj.calc_amt_vvd);
//	    	ComChkObjValid(formObj.calc_amt_ttl);
    	}
//    	if(Row > 0 && (Col == 13 || Col == 14) ){
//    		var popWin = document.getElementById("dvPopup");
//    		popWin.style.display = popWin.style.display == "none" ? "" : "none";
//    		popWin.style.left = CellX+20;
//   		popWin.style.top  = CellY+220;
//    		var popContent = popWin.contentWindow.document.getElementById("content");
//    		popContent.innerHTML = sheetObj.CellValue(Row, Col);
//    	}
    }
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	
    	if(OldRow != NewRow){
    		var formObj = document.form;
    		var sheetObj2 = sheetObjects[1];
    		formObj.cbx_night.checked = sheetObj.CellValue(NewRow, "sheet1_night") == "Y" ? true : false;          
    		formObj.cbx_holiday.checked = sheetObj.CellValue(NewRow, "sheet1_holiday") == "Y" ? true : false;
    		formObj.cbx_boat.checked = sheetObj.CellValue(NewRow, "sheet1_boat") == "Y" ? true : false;
    		formObj.cbx_tugrope.checked = sheetObj.CellValue(NewRow, "sheet1_tugrope") == "Y" ? true : false;
    		formObj.cbx_buoy.checked = sheetObj.CellValue(NewRow, "sheet1_buoy") == "Y" ? true : false;
    		formObj.cbx_sanitation.checked = sheetObj.CellValue(NewRow, "sheet1_sanitation") == "Y" ? true : false;
    		formObj.cbx_barge.checked = sheetObj.CellValue(NewRow, "sheet1_barge") == "Y" ? true : false;
    		formObj.cbx_inspection.checked = sheetObj.CellValue(NewRow, "sheet1_inspection") == "Y" ? true : false;
    		formObj.cbx_newservice.checked = sheetObj.CellValue(NewRow, "sheet1_newservice") == "Y" ? true : false;
    		formObj.cbx_copilot.checked = sheetObj.CellValue(NewRow, "sheet1_copilot") == "Y" ? true : false;
    		
    		sheetObj2.CellValue2(1, "sheet2_arrtp") = sheetObj.CellValue(NewRow, "sheet1_arrtp");
    		sheetObj2.CellValue2(1, "sheet2_deptp") = sheetObj.CellValue(NewRow, "sheet1_deptp");
    		//sheetObj2.CellValue2(1, "sheet2_arrnt") = sheetObj.CellValue(NewRow, "sheet1_arrnt");
    		//sheetObj2.CellValue2(1, "sheet2_depnt") = sheetObj.CellValue(NewRow, "sheet1_depnt");
    		//sheetObj2.CellValue2(1, "sheet2_arrtuh") = sheetObj.CellValue(NewRow, "sheet1_arrtuh");
    		//sheetObj2.CellValue2(1, "sheet2_deptuh") = sheetObj.CellValue(NewRow, "sheet1_deptuh");
    		sheetObj2.CellValue2(1, "sheet2_arrlh") = sheetObj.CellValue(NewRow, "sheet1_arrlh");
    		sheetObj2.CellValue2(1, "sheet2_deplh") = sheetObj.CellValue(NewRow, "sheet1_deplh");
    		sheetObj2.CellValue2(1, "sheet2_usdhrs") = sheetObj.CellValue(NewRow, "sheet1_usdhrs");
    	}
    		
		//>>[2010.02.08:jmh]
    	if(sheetObj.ColSaveName(OldCol) == "sheet1_vvd"){
    		var sheet1_vvd = sheetObj.CellValue(OldRow, OldCol);
    		if(sheet1_vvd.length == 0){
    		} else if(sheet1_vvd.length != 9){
    			if(OldRow >= sheetObj.HeaderRows){
    				sheetObj.CellValue(OldRow, OldCol) = "";
    			}
    			document.form.vvdband.value = "";
    		}
    	}
    	//<<[2010.02.08:jmh]
    	
    	
       
    	//if(sheetObj.ColSaveName(OldCol) == "sheet1_cost_calc_eff_fm_dt" || sheetObj.ColSaveName(OldCol) == "sheet1_cost_calc_eff_to_dt"){
    		
    //	}
    	
    	
    }
    
    function sheet2_OnBeforeEdit(sheetObj,Row,Col){
    	var sheetObject1 = sheetObjects[0];
    	if(sheetObject1.RowCount>0){
    		
    		return;
    	
	    	switch(Col){
	    		case 2://arrtp
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrtp", "", dfNullFloat, 1);
		    		break;
	    		case 3://deptp
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deptp", "", dfNullFloat, 1);
	    			break;
	    		//case 4://arrnt
	    		//	sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrnt", "", dfNullFloat, 1);
		    	//	break;
	    		//case 5://depnt
	    		//	sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_depnt", "", dfNullFloat, 1);
	    		//	break;
	    		case 6://arrtuh
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrtuh", "", dfNullFloat, 1);
		    		break;
	    		case 7://deptuh
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deptuh", "", dfNullFloat, 1);
		    		break;
	    		case 8://arrlh
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrlh", "", dfNullFloat, 1);
		    		break;
	    		case 9://deplh
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deplh", "", dfNullFloat, 1);
		    		break;
	    		case 10://usdhrs
	    			sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_usdhrs", "", dfNullFloat, 1);
		    		break;
	    	}
    	}
    }
    function sheet2_OnAfterEdit(sheetObj, Row, Col){
		f_SetValuesIntoSheet1(sheetObj, Row, Col);
    }	
    
    function sheet2_OnChange(sheetObj,Row,Col) {
    	 
    	f_SetValuesIntoSheet1(sheetObj, Row, Col);
    }
    
    function f_SetValuesIntoSheet1(sheetObj, Row, Col){
    	var sheetObject1 = sheetObjects[0];

    	if(sheetObject1.RowCount>0){
    		var cellVal = sheetObj.CellValue(Row, Col);
    		var dfVal = (cellVal.indexOf(".") == -1 ? dfNullInteger : dfNullFloat);    	//포멧 변경
    		var colName = sheetObj.ColSaveName(Col);
    		switch(colName){
	    		case "sheet2_arrtp"://arrtp
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrtp", "", dfVal);
		    		sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_arrtp") = cellVal;
		    		break;
	    		case "sheet2_deptp"://deptp
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deptp", "", dfVal);
	    			sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_deptp") = cellVal;
	    			break;
	    		//case "sheet2_arrnt"://arrnt  --2015-06-18막음 
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrnt", "", dfVal);
		    	//	sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_arrnt") = cellVal;
		    	//	break;
	    		//case "sheet2_depnt"://depnt
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_depnt", "", dfVal);
	    		//	sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_depnt") = cellVal;
	    			//break;
	    		//case "sheet2_arrtuh"://arrtuh --2017.06.01 주석처리
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrtuh", "", dfVal);
		    		//sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_arrtuh") = cellVal;
		    		//break;
	    		//case "sheet2_deptuh"://deptuh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deptuh", "", dfVal);
		    		//sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_deptuh") = cellVal;
		    		//break;
	    		case "sheet2_arrlh"://arrlh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrlh", "", dfVal);
		    		sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_arrlh") = cellVal;
		    		break;
	    		case "sheet2_deplh"://deplh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deplh", "", dfVal);
		    		sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_deplh") = cellVal;
		    		break;
	    		case "sheet2_usdhrs"://usdhrs
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_usdhrs", "", dfVal);
	    			sheetObject1.CellValue2(sheetObject1.SelectRow, "sheet1_usdhrs") = cellVal;
	    		break;
	    	}
    	}    	
    }
    
    
    /**
     * Terminal코드가 변경될 때 Terminal 의 이름을 설정
     * @param obj
     * @return
     */
    function displayTmnlNm(obj) {
    	var formObj = document.form;
    	var dspNm = eval("tmnlName._"+obj.value);
    	dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
    	formObj.tmnl_nm.value = dspNm;
    	var dspVal = eval("costOfc._"+obj.value);
    	dspVal = (typeof dspVal === "undefined") ? "" : dspVal;
    	formObj.cost_ofc.value = dspVal; 
    	/*============================================================================================
    	에러 사항 수정. 2014.08.12 
    	1. Terminal Code 입력 이후 Invoice No. 입력하면 해당 터미널 code가 처음 것으로 변경됨
    	   따라서 유저가 입력한 값 그대로 존재하도록 로직 수정 필요
    	 ==============================================================================================
    	var currVal = eval("currCdList._"+obj.value);
    	currVal = (typeof currVal === "undefined") ? "" : currVal;
    	formObj.curr_cd.value = currVal;
    	//============================================================================================*/
    	f_SetTrnsSlp();	//[2010.02.25:jmh] Transfer Slip Checkbox 활성화
    }
    
    /**
 	 * Account Code 컬럼에 말 풍선을 달아 입력된 Account Code 에 대한 Cost CD, Description를 표시한
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    
        with(sheetObj) {
        	
        	var tip = "";
    		if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

    			if (ColSaveName(MouseCol) == "sheet1_acct_cd") {

    				tip += CellValue(MouseRow, "sheet1_acct_cd");			// Cost CD
    				tip += " - ";
    				tip += CellValue(MouseRow, "sheet1_lgs_cost_full_nm");	// Description
    			}
    			else {
    				tip = CellText(MouseRow, MouseCol);
    			}				
    		}
    		MouseToolTipText = tip;
    	}
//        RowCount+1, 10 
        //풍선도움말 만들기
//        if(Row > 0 && Col == 13 || col == 14) ){
//	        var sText = sheetObj.CellText(Row,Col);
//	        if(sText != "")
//	        	sheetObj.MouseToolTipText = sText;
//        }
	        
	    //합계값자동iNSERT 
//	    if(Row == sheetObj.RowCount+1 && Col == 12){
//	    	document.form.inv_amt.value = sText;
//	    	ComChkObjValid(document.form.inv_amt);
//	    }

        //마우스 모양 설정하기
        //2컬럼이고 내용이 2003-06-24일때만 손모양으로 마우스 설정
//        if (Col == 2 && sText == "2003-06-24")
//            MousePointer = "Hand";
//        else
//            MousePointer = "Default";
    }
     
     
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	f_DataRowHeight(0);	//모든 DataRowHeight 늘이기
    	// 2010.08.23 이준범    	
    	if(sheetObj.RowCount > 0){
	    	for(var i=1; i<=sheetObj.RowCount; i++){
	    		var ioChk = sheetObj.CellValue(i, "sheet1_io");
		    	if(ioChk != "INOUT") {
		    		sheetObj.CellEditable(i,"sheet1_io") = true;
		    		sheetObj.CellComboItem(i, "sheet1_io", "IN|OUT", "IN|OUT");
		    	} else {
		    		sheetObj.CellEditable(i,"sheet1_io") = false;
		    		sheetObj.CellComboItem(i, "sheet1_io", " |IN|OUT", "INOUT|IN|OUT");
		    	}
	    	}
    	}
    }
     
    /**
     * AMT(VVD/TTL)의 항목중 AMT VVD의 값을 만들고 설정한다.
     * @return
     */
    function setCalcAmtVvd(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	if(sheetObj.RowCount > 0){
	    	var curVvd = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vvd"); //현재 선택된 row 의 vvd 값
	    	var curVal = 0 ;//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_amount");
//	    	//loop 돌면서 같은 vvd 값을 sum 한다. 
	    	for(var i=1; i<=sheetObj.RowCount; i++){
//	    		if(i==sheetObj.SelectRow) continue;
	    		row = sheetObj.FindText("sheet1_vvd", curVvd, i, -1); //VVD가 값은  가진 넘을 찾는다. 
	    		if(row>0){
	    			curVal += (sheetObj.CellValue(row, "sheet1_amount"))*1;
	    			i=row;
	    		}
	    	}
	        formObj.calc_amt_vvd.value = curVal.toFixed(2);		//[jmh]    
    	}
    }
     
    /* [2010.02.25:jmh]
     * Terminal이 'KR'일 경우에만 Transfer Slip을 활성화한다.
     */ 
    function f_SetTrnsSlp(){
    	var formObj = document.form;
    	var nation = formObj.yd_cd.value.substr(0, 2);

    	if(nation == "KR"){
    		formObj.trnsf_slp.disabled = false;
    	} else{
    		formObj.trnsf_slp.disabled = true;    		
    		formObj.trnsf_slp.checked = false;
    	}
    }

    
function f_ExistsTonnage(){
	var formObj = document.form;
	var sheetObject = sheetObjects[0];
  	var sheetObj2   = sheetObjects[1];
  	var rtlVal = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC12);
   
    if(rtlVal == "Y"){
    	 g_isTonExist = true;
    	 sheetObject.ColHidden("sheet1_cost_calc_eff_fm_dt") = false;
    	 sheetObject.ColHidden("sheet1_cost_calc_eff_to_dt") = false;
    }
     else{
    	 sheetObject.ColHidden("sheet1_cost_calc_eff_fm_dt") = true;
    	 sheetObject.ColHidden("sheet1_cost_calc_eff_to_dt") = true;
    }
    
    return rtlVal;
	
}    
     
/*
 * Invoice No.가 모두 입력되면 존재여부체크후, 조회
 */     
function f_ExistsInvNo(){
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];
	var sheetObject = sheetObjects[0];
  	var sheetObj2   = sheetObjects[1];
	
	if(ComTrim(formObj.inv_no.value) == ""){
		return;
	}
	
	//해당 Invoice No의 존재 여부를 확인한다.
	var rtlVal = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC08);
	
	if (rtlVal != "") {
		//ComShowCodeMessage("PSO00044");		//This Inv No. already exists.
		
		csrmsg1 = rtlVal.split("*")[0];
		csrmsg2 = rtlVal.split("*")[1];
		csrmsg3 = rtlVal.split("*")[2];
		ComShowMessage("Already processed this invoice as same Invoice No and S/Provider."+"\n"+csrmsg1+"\n"+csrmsg2+"\n"+csrmsg3);
		
		g_isExist = true;
		ComBtnDisable("btn_Save");
		
		//-----------> 조회 하고 끝남. 
		sheetObject1.Editable = true;
		formObj.inv_amt.value = "";
		formObj.vat.value = "";
		if(!g_isEnterKey){
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
		} else{
			g_isEnterKey = false;
		}
		var dspNm = eval("tmnlName._"+formObj.yd_cd.value);
		dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
		formObj.tmnl_nm.value = dspNm;
		var ofcNm = eval("costOfc._"+formObj.yd_cd.value);
		ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
		formObj.cost_ofc.value = ofcNm;
		
		//formObj.cost_ofc.value = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_cost_ofc_cd");	
		f_SetCostOfc();	//[2010.04.29:jmh]
		
		isRClick = true;
		
		return;
		//<--------------- 2010.01.27 ADD.. 
	} else{
		g_isExist = false;

		//--->  추가 요구 사항 코딩 2010.02.28. add
		ComBtnEnable("btn_Save");
		ComBtnDisable("btn_Confirm");
		ComBtnDisable("btn_Delete");
		ComBtnEnable("btn_RowAdd");
		ComBtnEnable("btn_RowDelete");
		ComBtnEnable("btn_Calculation");

		//========================================================================================================
		//요청내용 : INV No. 에 데이터 존재하지 않을 경우, 조회조건필드항목들을 초기화시키지 않도록 수정요청함.
		//요청일자 : 2014.08.19, 처리일자 : 2014.08.19
		//========================================================================================================
//		var spCode = formObj.spcode.value;
//		var spName = formObj.spname.value;
//		var invNo  = formObj.inv_no.value;

//		formObj.reset();
		
//		formObj.spcode.value = spCode;
//		formObj.spname.value = spName;
//		formObj.inv_no.value = invNo;
		
//		var dspNm = eval("tmnlName._"+formObj.yd_cd.value);
//		dspNm = (typeof dspNm === "undefined") ? "" : dspNm;
//		formObj.tmnl_nm.value = dspNm;
//		var ofcNm = eval("costOfc._"+formObj.yd_cd.value);
//		ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
//		formObj.cost_ofc.value = ofcNm;

		//User의 CUrrency CD설정 
		/*============================================================================================
		에러 사항 수정. 2014.08.12 
		1. Terminal Code 입력 이후 Invoice No. 입력하면 해당 터미널 code가 처음 것으로 변경됨
		   따라서 유저가 입력한 값 그대로 존재하도록 로직 수정 필요
		 ==============================================================================================		
		var currCdVal = eval("currCdList._"+formObj.yd_cd.value);
		currCdVal = (typeof currCdVal === "undefined") ? "" : currCdVal;
		formObj.curr_cd.value = currCdVal;
		//============================================================================================*/
		
		//iss_dt 를 현재 날짜로 만든다.
//		setToday(document.form.iss_dt, 'ymd');
//		setToday(document.form.rcv_dt, 'ymd');
		//========================================================================================================
		//<<---
	}
	sheetObject.RemoveAll();	
	//sheetObjects[1].RemoveAll();	//[jmh]
	//checkbox클리어 
	formObj.cbx_night.checked = false;          
	formObj.cbx_holiday.checked = false;
	formObj.cbx_boat.checked = false;
	formObj.cbx_tugrope.checked = false;
	formObj.cbx_buoy.checked = false;
	formObj.cbx_sanitation.checked = false;
	formObj.cbx_barge.checked = false;
	formObj.cbx_inspection.checked = false;
	formObj.cbx_newservice.checked = false;
	formObj.cbx_copilot.checked = false;
	
	formObj.vvdband.value      = "";
	formObj.atd.value          = "";
	formObj.calc_amt_vvd.value = "";
	formObj.calc_amt_ttl.value = "";
	
	sheetObject.Editable = true;	//[jmh]?
	isRClick = false;//전역 변수 클리어 
	//SHEET2 CLEAR
	sheetObj2.CellValue2(1, "sheet2_arrtp") = "";
	sheetObj2.CellValue2(1, "sheet2_deptp") = "";
//	sheetObj2.CellValue2(1, "sheet2_arrnt") = "";
	//sheetObj2.CellValue2(1, "sheet2_depnt") = "";
	sheetObj2.CellValue2(1, "sheet2_arrtuh") = "";
	sheetObj2.CellValue2(1, "sheet2_deptuh") = "";
	sheetObj2.CellValue2(1, "sheet2_arrlh") = "";
	sheetObj2.CellValue2(1, "sheet2_deplh") = "";
	sheetObj2.CellValue2(1, "sheet2_usdhrs") = "";	
}


function getOfcCd(rowArray) {
	var colArray = rowArray[0];
	document.all.cost_ofc.value = (colArray[3]!=undefined&&colArray[3]!=null?colArray[3]:'');
} 

function f_SetTitleInControls(){
	var formObj = document.form;

	var msg = ComGetMsg("PSO00045", "Invoice No.", "20");
	formObj.inv_no.title = msg;							//Please input Invoice No. below 20 letters. 
	document.getElementById("td_inv_no").title = msg;	//Please input Invoice No. below 20 letters. 
}

function f_ValidateCipherByCurrency(obj, deletion){
	var formObj = document.form; 
	var val = obj.value;
	if(isNaN(Number(val)) || val.charAt(val.length-1) == "."){	//NaN 이거나 마지막 문자가 '.'인 경우 
		if(deletion){
			obj.value = "";
		}
		//obj.focus();
		return false;
	}
	
	var dp = formObj.curr_cd.options[formObj.curr_cd.options.selectedIndex].decimal_point;	//Currency의 자릿수
	
	var indexOfPeriod = val.indexOf(".");
	if(indexOfPeriod > -1){
		if(val.substr(indexOfPeriod + 1).length > dp){	//dp보다 입력된 자릿수가 크면,
			alert("Please enter a maximum " + dp + " decimal point.");
		}
	}
}

/**sheet1 DataRowHeight 늘이기
 * @param row : 해당row의 RowHeight를 늘인다. row가 0이면 모든 DataRow	 
 */
function f_DataRowHeight(row){	//f_AfterLoadOfSheet
	if(row == 0){
		for(i=sheetObjects[0].HeaderRows; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
			var regExp = /\n/gi;
			var str = ComTrim(sheetObjects[0].CellValue(i, "sheet1_foml1"), "\n");
			var result = str.match(regExp);

			if(result != undefined){	
				//1줄 : 20, 2줄 : 40, 3줄 : 60
				sheetObjects[0].RowHeight(i) = g_DefaulDataRowHeight * (result.length + 1);				
			} else{
				sheetObjects[0].RowHeight(i) = g_DefaulDataRowHeight;				
			}
		}
	} else{
		sheetObjects[0].RowHeight(row) = sheetObjects[0].RowHeight(row) + 5;
	}
}

/*[2010.04.29:jmh] 
 * Cost Office 채우기 변경 (sheet의 Cost Office 값이 없으면 Terminal에 있는 Default 값으로 채운다.)
 */
function f_SetCostOfc(){
	var formObj = document.form;
	var costOfcCdInSheet = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cost_ofc_cd");
	var ofcNm = eval("costOfc._"+formObj.yd_cd.value);
	ofcNm = (typeof ofcNm === "undefined") ? "" : ofcNm;
	
	formObj.cost_ofc.value = costOfcCdInSheet != "" ? costOfcCdInSheet : ofcNm;  
}
/* 2010.08.23 이준범 OPMS Ticket ID : CHM-201005473-01
 *            Condition에 IN/OUT이 있고, 실제 IO컬럼에 데이터가 없을때, 메세지 띄우고 focus
 */
function checkIoChk() {
	var sheetObj = sheetObjects[0];
	 for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		 //io_chk가 Y이면서 IO가 INOUT 일떄는 메세지 띄우고 포커스
		 if(sheetObj.cellValue(i,"sheet1_io_chk")=="Y" && sheetObj.cellValue(i,"sheet1_io") == "INOUT") {
			 ComShowCodeMessage("PSO00003", "IO");
			 sheetObj.SelectCell(i, "sheet1_io", true);
			 return false;
		 }
	 }
	 return true;
}
/* 2010.10.26 CHM-201006691 이석준
 *            credit check시 amount가 0보다 크면 check 안되게 변경
 */
function sheet1_OnBeforeCheck(sheetObj, Row, Col){
	var colSaveName = sheetObj.ColSaveName(Col);
	switch (colSaveName) {
		case "sheet1_credit":
			var adj_amt = Number(sheetObj.CellValue(Row, "sheet1_adjcost"))
			
			if (adj_amt > 0) {
				ComShowCodeMessage("PSO01004");
				sheetObj.AllowCheck = false;
			}
			else {
				sheetObj.AllowCheck = true;
			}
			break;
		default:
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);

	if (colName == "sheet1_n3pty_bil_popup") {	//TPB Click
		root = "popup";
		openTpbPopup(sheetObj, Row, root);		
	}
	else if (colName == "sheet1_remark_popup") {//Remark Click
	
		var param  = "yd_chg_no=" + sheetObj.CellValue(Row, "sheet1_yd_chg_no");
    	param += "&yd_chg_ver_seq=" + sheetObj.CellValue(Row, "sheet1_yd_chg_ver_seq");
    	param += "&vndr_seq=" + sheetObj.CellValue(Row, "sheet1_vndr_seq");
    	param += "&inv_no=" + document.form.inv_no.value;
	    param += "&caller=0014";
	    param += "&view_flag=DTL";
	    ComOpenPopup("VOP_PSO_0042.do?" + param, 422, 350, "setPortTrfRmk", "1,0,1,1,1,1,1", true);		
		
	}
	
	
	else if (colName == "sheet1_cost_calc_eff_fm_dt"){
		var cal = new ComCalendarGrid("myCal"); 
		CALENDAR_SELECTED_ROW = sheetObj.SelectRow;
		CALENDAR_SELECTED_VAL = sheetObj.CellValue(sheetObj.SelectRow,  "sheet1_cost_calc_eff_fm_dt");
		CALENDAR_SELECTED_VAL = ComReplaceStr(CALENDAR_SELECTED_VAL, "-", "");
		cal.setEndFunction("setExpDate");	//Callback Function
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	
	else if (colName == "sheet1_cost_calc_eff_to_dt"){
		var cal = new ComCalendarGrid("myCal"); 
		CALENDAR_SELECTED_ROW = sheetObj.SelectRow;
		CALENDAR_SELECTED_VAL = sheetObj.CellValue(sheetObj.SelectRow,  "sheet1_cost_calc_eff_to_dt");
		CALENDAR_SELECTED_VAL = ComReplaceStr(CALENDAR_SELECTED_VAL, "-", "");
		cal.setEndFunction("setExpDate");	//Callback Function
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
}




/**
 * Addinformation 정보 설정 2015-06-18
 * TUG Used Hour add 2017-06-01
 * @param rtnValue
 */
function setAddinfo(rtnValue) {
	var sheetObj  = sheetObjects[1];
	var sheetObjs  = sheetObjects[0];
	var selectRow = sheetObj.SelectRow;
	var selectRows = sheetObjs.SelectRow;
	var formObj   = document.form ;

	var inout = sheetObjs.CellValue(selectRows,"sheet1_io") ;
	
	if( inout == "IN") {
		sheetObjs.CellValue2(selectRows,"sheet1_arrnt") = rtnValue[0][3]; 
 	   	sheetObjs.CellValue2(selectRows,"sheet1_arrtuh") = rtnValue[0][5];

        doActionCalc2(sheetObjs, formObj, "sheet1_arrnt", selectRows, rtnValue[0][3]);  
        doActionCalc2(sheetObjs, formObj, "sheet1_arrtuh", selectRows, rtnValue[0][5]);  
    } else if ( inout == "OUT")  {   
	    sheetObjs.CellValue2(selectRows,"sheet1_depnt") = rtnValue[0][3];
	    sheetObjs.CellValue2(selectRows,"sheet1_deptuh") = rtnValue[0][5];

        doActionCalc2(sheetObjs, formObj, "sheet1_depnt", selectRows, rtnValue[0][3]); 
        doActionCalc2(sheetObjs, formObj, "sheet1_deptuh", selectRows, rtnValue[0][5]); 
    }
	
}

/**
 * BAF 정보 설정 2015-12-18
 * @param rtnValue
 */
function setBAFinfo(rtnValue) {
	var sheetObj  = sheetObjects[1];
	var sheetObjs  = sheetObjects[0];
	var selectRow = sheetObj.SelectRow;
	var selectRows = sheetObjs.SelectRow;
	var formObj   = document.form ;
	var colName       = "sheet1_baf_rt";

    	Value  = rtnValue[0][2];

	    sheetObjs.CellValue2(selectRows,"sheet1_baf_rt") = rtnValue[0][2];
	    colName = "sheet1_baf_rt"; 
        doActionCalc2(sheetObjs, formObj, colName, selectRows, Value); 
	
}


/**
 * Remark 팝업설정
 */
function setPortTrfRmk(rtnValue) {
	var sheetObj = sheetObjects[0];
	var selectRow = sheetObj.SelectRow;
	sheetObj.CellValue2(selectRow,"sheet1_remark") = rtnValue;
}

function openTpbPopup(sheetObj, Row, rt) {
	if(sheetObj.CellValue(Row, "sheet1_amount")=="" || sheetObj.CellValue(Row, "sheet1_vvd")==""){
		ComShowCodeMessage("COM12114", "VVD or Account")
		handlingTpbFlg(sheetObj);
		return false;
	}
	var url = "/hanjin/VOP_PSO_0216.do?vvd="
		+ sheetObj.CellValue(Row, "sheet1_vvd") + "&ifAmt="
		+ sheetObj.CellValue(Row, "sheet1_amount") + "&ifCurrCd="
		+ document.form.curr_cd.value + "&n3ptyBilTpCd="
		+ sheetObj.CellValue(Row, "sheet1_n3pty_bil_tp_cd") + "&ifRmk="
		+ sheetObj.CellValue(Row, "sheet1_if_rmk") + "&n3ptyVndrSeq="
		+ sheetObj.CellValue(Row, "sheet1_n3pty_vndr_seq");
	
	ComOpenPopup(url, 700, 250, 'setTpbType', '0,0', true, true);
}

function setTpbType(aryPopupData) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if(aryPopupData!=""){
		sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_n3pty_bil_tp_cd") = aryPopupData[0][1];
		sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_n3pty_vndr_seq") = aryPopupData[0][4];
		sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_if_rmk") = aryPopupData[0][5];
		sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_n3pty_bil_if_flg") = "Y"; //팝업을 통해 입력된 값이 있으므로, TPB 대상건 표기.
	}
}

//combo로 Y 선택시 팝업이 뜬 경우 close 되면, combo의 flg값을 N으로 다시 셋팅해준다.
function handlingTpbFlg(sheetObj){
	if(root=="change"){
		sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_n3pty_bil_if_flg") = "N";
	}
}

//[CHM-201430063] Invoice Issued date alc Received date 입력 오류 방지을 위한 로직 변경 개발 요청
function obj_blur(){

	var formObj = document.form;
	var obj = event.srcElement;      	

	with(formObj) {
		if (obj.name=="atd" || obj.name=="iss_dt" || obj.name== "rcv_dt") {

			if (formObj.yd_cd.value.substring(0,2) == "JP"||formObj.yd_cd.value.substring(0,2) == "BR"||formObj.yd_cd.value.substring(0,2) == "VN"||formObj.yd_cd.value.substring(0,5) == "KRPUS") {
				return;
			}
			
			var atDt = ComReplaceStr(atd.value.substring(0,10),"-","");
			var issDt = ComReplaceStr(iss_dt.value,"-","");
			var rcvDt = ComReplaceStr(rcv_dt.value,"-","");

			switch(obj.name) {
	
				case "iss_dt":	// Issue Date
					if(atDt != '' && issDt != ''){
						if(atDt > issDt){
							ComShowCodeMessage('PSO00046','Invoice Issued date','the ATD Date');
							iss_dt.value='';
							iss_dt.focus();
						}
					}
				break;	
				
				case "rcv_dt":	// Recieved Date
					if(issDt != '' && rcvDt != ''){
						if(issDt > rcvDt){
							ComShowCodeMessage('PSO00046','Receive Date','the Issue Date');
							rcv_dt.value='';
							rcv_dt.focus();
						}
					}
				break;
			}
		}
	}
}

//S/P Code에 등록된 Currency에 따라 Currency Default값으로 세팅해준다.
function fnSetCurrencyBySP() {
	
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	//S/P Code에 등록된 Currency 를 조회한다.
	var currCd = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC11);
	
	//조회결과를 Currency에 설정해준다.
	ComSetObjValue(formObj.curr_cd, currCd);
}

/**
 * 입력된 모든 Charge에 대해서, Invoice Currency와 Tariff Currency비교를 통한 Exchange Rate컬럼 상태변경
 * @param obj
 * @return
 */    
function changeInvCurrCd() {
	
	//입력된 모든 Charge에 대해서, Invoice Currency와 Tariff Currency비교를 통한 Exchange Rate컬럼 상태변경
	fnSetEnableExchangeRates();
	
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	var ColName  = "sheet1_mnl_inp_xch_rt";
	var flag     = "N"; // 데이터입력후 retrieve버튼을 눌러서 초기화 한 상태에서 (즉, detail데이터 없는 상태) currency변경시 메세지 못 뜨게 하려고.
	var trfCurrCd  = sheetObj.CellValue(1, "sheet1_trf_curr_cd");	//Tariff Currency
	var invCurrCd  = ComGetObjValue(formObj.curr_cd);	

	
	for (var i=1; i<=sheetObj.RowCount; i++) {
		flag = "Y";
		sheetObj.CellValue2(i, "sheet1_mnl_inp_xch_rt") = ""; //2015.05.13추가
		doActionCalc(sheetObj, formObj, ColName, i, "");
		
	}
	
	if(flag == "Y" && trfCurrCd != invCurrCd) {
		ComShowMessage("Please check Exchange Rate at first, If is in correct, Please change it.");
	}

	
}


//입력된 모든 Charge에 대해서, Invoice Currency와 Tariff Currency비교를 통한 Exchange Rate컬럼 상태변경
function fnSetEnableExchangeRates() {
	var sheetObj = sheetObjects[0];
	var count = 0;
	//Tariff Currency와 Invoice Currency가 다른경우, Exchange Rate컬럼을 활성화시켜준다.
	for (var i=1; i<=sheetObj.RowCount; i++) {
		if (fnSetEnableExchangeRate(i)) {
			count++;
		}	
	}
	
	// Exchange Rate컬럼이 1Row이상 활성화상태가 존재한다면, Exchange Rate컬럼을 Show해준다.
	if (count == 0) {
		sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = true;
	}
	else {
		if (sheetObj.ColHidden("sheet1_mnl_inp_xch_rt"))
			sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = false;
	}
}

//Invoice Currency와 Tariff Currency를 비교해서 Exchange Rate 필드의 상태를 변경해준다.
function fnSetEnableExchangeRate(Row) {
	
	var sheetObj   = sheetObjects[0];
	var formObj    = document.form;
	
	var trfCurrCd  = sheetObj.CellValue(Row, "sheet1_trf_curr_cd");	//Tariff Currency
	var invCurrCd  = ComGetObjValue(formObj.curr_cd);				//Invoice Currency

	var isEditable = false;
	
	//TariffCurrency와 Invoice Currency가 다를경우에만 Exchange Rate 입력가능및 활성화
	if (trfCurrCd != "" && invCurrCd != trfCurrCd) {
		isEditable = true;
	}
	//입력불가상태일 경우, ''로 초기화시킨다.
	else {
		sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = "";
	}
	sheetObj.CellEditable(Row, "sheet1_mnl_inp_xch_rt") = isEditable;
	
	return isEditable;
}

/**
 * 서버모듈을 호출하기 전에 실행해야된 전처리 작업
 */
function initDoActionIBSheet(sheetObj, formObj, sAction) {
	if (sheetObj.id == "sheet1") {
		switch (sAction) {
			case IBSEARCH:
				sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = true;
				sheetObj.ColHidden("sheet1_cost_calc_eff_fm_dt") = true;
				sheetObj.ColHidden("sheet1_cost_calc_eff_to_dt") = true;
			break;
		}
	}
}

// expire fm_dt, to_dt : CN, IT, JP Tonnage 배분 
function fnSetEnableExpireDate(Row) {

	var sheetObj   = sheetObjects[0];
	var ydcd       = sheetObj.CellValue(Row, "sheet1_yd_cd");	//yard_code
	var acctcd     = sheetObj.CellValue(Row, "sheet1_acct_cd");	//account code
		
	
	if(acctcd == "PTDUTN" && ydcd.substr(0,5) != "CNHKG" && (ydcd.substr(0,2) == "CN" || ydcd.substr(0,2) == "JP" || ydcd.substr(0,2) == "IT" )){
		g_isTonExist = true;
		sheetObj.ColHidden("sheet1_cost_calc_eff_fm_dt") = false;
	    sheetObj.ColHidden("sheet1_cost_calc_eff_to_dt") = false;
	    sheetObj.CellEditable(Row, "sheet1_cost_calc_eff_fm_dt") = true;
	    sheetObj.CellEditable(Row, "sheet1_cost_calc_eff_to_dt") = true;     }
	else 
	 {
		if(g_isTonExist == true){  	
			sheetObj.ColHidden("sheet1_cost_calc_eff_fm_dt") = false;
		    sheetObj.ColHidden("sheet1_cost_calc_eff_to_dt") = false;
		    sheetObj.CellEditable(Row, "sheet1_cost_calc_eff_fm_dt") = false;
		    sheetObj.CellEditable(Row, "sheet1_cost_calc_eff_to_dt") = false;
		}
		else {
		sheetObj.CellValue(Row,"sheet1_cost_calc_eff_fm_dt") = "";
		sheetObj.CellValue(Row,"sheet1_cost_calc_eff_to_dt") = "";
		sheetObj.ColHidden("sheet1_cost_calc_eff_fm_dt") = true;
	    sheetObj.ColHidden("sheet1_cost_calc_eff_to_dt") = true;
		sheetObj.CellEditable(Row, "sheet1_cost_calc_eff_fm_dt") = false;
		sheetObj.CellEditable(Row, "sheet1_cost_calc_eff_to_dt") = false;
		}
	 }
    
}

/**
 * Calculation을 실행한다.
 */
function doActionCalc(sheetObj, formObj, ColName, Row, Value) {

	var ioCondChk = "N";
    
	//Exchange Rate 변경시에는 아래 로직을 실행하지 않음.(Account Code, Cost Code 변경시 실행됨)
	if (ColName != "sheet1_mnl_inp_xch_rt") {
		if (formObj.credit_memo.checked/*jmh*/) {
			if (ColName == "sheet1_acct_cd") {
        		sheetObj.CellText(Row, "sheet1_cost_cd") = Value;
        		formObj.acct_cd.value =  sheetObj.CellText(Row, "sheet1_acct_cd");
			}
			else if (ColName == "sheet1_cost_cd") {
    			sheetObj.CellText(Row, "sheet1_acct_cd") = Value;
    			formObj.acct_cd.value =  sheetObj.CellValue(Row, "sheet1_cost_cd");
			}

		
			//sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = eval("vndrLglEngNm._"+Value);
    		formObj.vsl_cd.value 	 = sheetObj.CellValue(Row, "sheet1_vsl_cd");
    		formObj.skd_voy_no.value = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
    		formObj.skd_dir_cd.value = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
    		formObj.cost_cd.value 	 = sheetObj.CellValue(Row, "sheet1_cost_cd");
    		formObj.io_flag.value 	 = sheetObj.CellText( Row, "sheet1_io");
			return;
		}
	}


	if (VALIDVVD == 7 || sheetObj.CellValue(sheetObj.SelectRow,"sheet1_validvvd") == "") {
		formObj.vsl_cd.value 		 = sheetObj.CellValue(Row, "sheet1_vsl_cd");
		formObj.skd_voy_no.value 	 = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
		formObj.skd_dir_cd.value 	 = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
		formObj.cost_cd.value 		 = sheetObj.CellValue(Row, "sheet1_acct_cd");
		formObj.acct_cd.value 		 = sheetObj.CellText( Row, "sheet1_acct_cd");
		formObj.io_flag.value 		 = sheetObj.CellText( Row, "sheet1_io");
		formObj.mnl_inp_xch_rt.value = sheetObj.CellText( Row, "sheet1_mnl_inp_xch_rt");

		//Exchange Rate 변경시에는 아래 로직을 실행하지 않음.(Account Code, Cost Code 변경시 실행됨)
		if (ColName != "sheet1_mnl_inp_xch_rt") {
			//VVD 유효체크
			var isValidVvd = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
			
			if (ColName == "sheet1_acct_cd") {
        		sheetObj.CellText(Row, "sheet1_cost_cd") = Value;
			}
			else if (ColName == "sheet1_cost_cd") {
    			sheetObj.CellText(Row, "sheet1_acct_cd") = Value;
			}
			//sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = eval("vndrLglEngNm._"+Value);
			
			//중복사용체크
			var doublepaycheck = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		}
		//>>[2010.02.24:jmh]	
		
		var credit = sheetObjects[0].CellValue(Row, "sheet1_credit");	
		var data = "NO_CALCULATION";
		
		if (credit != "1") {	//Credit Unchecked!			
		    data = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);		//Calculation	//[2010.02.24:jmh] Kim
		}   

		//<<[2010.02.24:jmh]
		//1.Account Code, Cost Code 변경시 해당 Tariff 가 존재하지 않을 경우
		if (ColName != "sheet1_mnl_inp_xch_rt" && (data == "NO_TARIFF_FOUND" || data == "NO_CALCULATION")) {
			if (data == "NO_TARIFF_FOUND") {
				ComShowCodeMessage("PSO00030");
			}
			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";
			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = "";	 
			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = "";
			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
			sheetObj.CellValue2(Row, "sheet1_cost_calc_eff_fm_dt") = "";
			sheetObj.CellValue2(Row, "sheet1_cost_calc_eff_to_dt") = "";
		}
		//1.Account Code, Cost Code 변경시 해당 Tariff 가 존재할 경우
		//2.Exchange Rate 변경할 경우
		else {
			
			var calcData = data.split("");
			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = calcData[0];
			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = calcData[1];
			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = calcData[2];
			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = calcData[3];	 
			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = calcData[4];
			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = calcData[7]; //2015.05.13 추가
			ioCondChk = calcData[5];
		
			// Tariff Currency 와 Invoice Currency 가 다를 경우, Exchange Rate 컬럼을 추가해준다.
			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") = calcData[6];
			
			//if(sheetObj.CellValue(Row, "sheet1_mnl_inp_xch_rt") != "") {
		 	//  ComShowMessage("Please check Exchange Rate at first, If is in correct, Please change it.");
			//}
			
			if (fnSetEnableExchangeRate(Row) && sheetObj.ColHidden("sheet1_mnl_inp_xch_rt")) {
				sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = false;
			}   			
		}
		formObj.vvdband.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_cd") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_voy_no") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_dir_cd");
		 
		setCalcAmtVvd();
		formObj.calc_amt_ttl.value = Number(sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")).toFixed(2);
		
		ComChkObjValid(formObj.calc_amt_vvd);
    	ComChkObjValid(formObj.calc_amt_ttl);
    
    	if (ioCondChk == "Y") {
    	
    		sheetObj.CellEditable(Row,"sheet1_io") = true;
    		sheetObj.CellValue2(Row, "sheet1_io_chk") = "Y";
    		sheetObj.ColHidden("sheet1_io") = false; //2015.05.13
    		g_ioExist = "Y";
    		
    		var vvd_cd    = sheetObj.CellValue(Row, "sheet1_vvd");
    		var acct_cd   = Value;
    		var check_ind = true;      		    	
    	
    		for (var ii=0; ii<sheetObj.RowCount; ii++) {
    			
    			if (vvd_cd == sheetObj.CellValue(ii, "sheet1_vvd") && acct_cd == sheetObj.CellValue(ii, "sheet1_acct_cd") && ii != Row) {	
    				check_ind = false;
    				var io_cd = sheetObj.CellValue(ii, "sheet1_io");
    			
    				if (io_cd == "OUT") sheetObj.CellValue(Row, "sheet1_io") = "IN";
    				if (io_cd == "IN")  sheetObj.CellValue(Row, "sheet1_io") = "OUT";
    			}	
    		 }
    		//해당 VVD,Acct Code를 처음 입력했을때 default값 입력
    		if (check_ind) sheetObj.CellValue(Row, "sheet1_io") = "OUT";
    	} 
    	else {
    		
    		sheetObj.CellValue2(Row, "sheet1_io") = ""; 
    		sheetObj.CellEditable(Row,"sheet1_io") = false;
    		sheetObj.CellValue2(Row, "sheet1_io_chk") = "N"; 
    		sheetObj.CellComboItem(Row, "sheet1_io", " |IN|OUT", "INOUT|IN|OUT");
    		
    		if(g_ioExist == 'N') {
    		 sheetObj.ColHidden("sheet1_io") = true; //sheet1_io hidden  2015.05.13
    		}
    	}        		    	
	}
	else {
		if (sheetObj.CellValue(Row, "sheet1_vsl_cd") =="") {
			ComShowCodeMessage("PSO00003", "VSL_CD");
			//[2010.02.08:jmh]
			sheetObjects[0].SelectCell(Row,"sheet1_vvd");
		}
		else if (sheetObj.CellValue(Row, "sheet1_skd_voy_no") == "") {
			ComShowCodeMessage("PSO00003", "SKD_VOY_NO");
			//[2010.02.08:jmh]
			sheetObjects[0].SelectCell(Row,"sheet1_vvd");
		}
		else if (sheetObj.CellValue(Row, "sheet1_skd_dir_cd") == "") {
			ComShowCodeMessage("PSO00003", "SKD_DIR_CD");
			//[2010.02.08:jmh]
			sheetObjects[0].SelectCell(Row,"sheet1_vvd");
		}
		
		sheetObj.CellValue2(Row, "sheet1_acct_cd") 			= " ";
		sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = " ";
		sheetObj.CellValue2(Row, "sheet1_cost_cd") 			= " ";

		//[2010.02.08:jmh]
		sheetObjects[0].SelectCell(Row,"sheet1_vvd");
	}	
	
	
	
}




/**
 * Calculation을 실행한다.
 */
function doActionCalc2(sheetObj, formObj, ColName, Row, Value) {

	var ioCondChk = "N";
    
	
	//Exchange Rate 변경시에는 아래 로직을 실행하지 않음.(Account Code, Cost Code 변경시 실행됨)
	if (ColName != "sheet1_mnl_inp_xch_rt") {
		if (formObj.credit_memo.checked/*jmh*/) {
			if (ColName == "sheet1_acct_cd") {
        		sheetObj.CellText(Row, "sheet1_cost_cd") = Value;
        		formObj.acct_cd.value =  sheetObj.CellText(Row, "sheet1_acct_cd");
			}
			else if (ColName == "sheet1_cost_cd") {
    			sheetObj.CellText(Row, "sheet1_acct_cd") = Value;
    			formObj.acct_cd.value =  sheetObj.CellValue(Row, "sheet1_cost_cd");
			}

		alert("1");
		//	sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = eval("vndrLglEngNm._"+Value);
    		formObj.vsl_cd.value 	 = sheetObj.CellValue(Row, "sheet1_vsl_cd");
    		formObj.skd_voy_no.value = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
    		formObj.skd_dir_cd.value = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
    		formObj.cost_cd.value 	 = sheetObj.CellValue(Row, "sheet1_cost_cd");
    		formObj.io_flag.value 	 = sheetObj.CellText( Row, "sheet1_io");
			return;
		}
	}


	if (VALIDVVD == 7 || sheetObj.CellValue(sheetObj.SelectRow,"sheet1_validvvd") == "") {
		formObj.vsl_cd.value 		 = sheetObj.CellValue(Row, "sheet1_vsl_cd");
		formObj.skd_voy_no.value 	 = sheetObj.CellValue(Row, "sheet1_skd_voy_no");
		formObj.skd_dir_cd.value 	 = sheetObj.CellValue(Row, "sheet1_skd_dir_cd");
		formObj.cost_cd.value 		 = sheetObj.CellValue(Row, "sheet1_acct_cd");
		formObj.acct_cd.value 		 = sheetObj.CellText( Row, "sheet1_acct_cd");
		formObj.io_flag.value 		 = sheetObj.CellText( Row, "sheet1_io");
		formObj.mnl_inp_xch_rt.value = sheetObj.CellText( Row, "sheet1_mnl_inp_xch_rt");

		//Exchange Rate 변경시에는 아래 로직을 실행하지 않음.(Account Code, Cost Code 변경시 실행됨)
		if (ColName != "sheet1_mnl_inp_xch_rt") {
			//VVD 유효체크
			var isValidVvd = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
			if (ColName == "sheet1_acct_cd") {
				sheetObj.CellText(Row, "sheet1_cost_cd") = Value;
			}
			else if (ColName == "sheet1_cost_cd") {
				sheetObj.CellText(Row, "sheet1_acct_cd") = Value;
			}
			//sheetObj.CellValue2(Row, "sheet1_lgs_cost_full_nm") = eval("vndrLglEngNm._"+Value);
			
			//중복사용체크
			var doublepaycheck = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);

		}
		//>>[2010.02.24:jmh]	
		
		var credit = sheetObjects[0].CellValue(Row, "sheet1_credit");	
		var data = "NO_CALCULATION";
		
		if (credit != "1") {	//Credit Unchecked!
		    data = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);		//Calculation	//[2010.02.24:jmh] Kim
		}   
	
		//<<[2010.02.24:jmh]
		//1.Account Code, Cost Code 변경시 해당 Tariff 가 존재하지 않을 경우
		if (ColName != "sheet1_mnl_inp_xch_rt" && (data == "NO_TARIFF_FOUND" || data == "NO_CALCULATION")) {
			if (data == "NO_TARIFF_FOUND") {
				ComShowCodeMessage("PSO00030");
			}
			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = "";
			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = "";
			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = "";
			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = "";	 
			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = "";
			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") 	  = "";
			sheetObj.CellValue2(Row, "sheet1_cost_calc_eff_fm_dt") = "";
			sheetObj.CellValue2(Row, "sheet1_cost_calc_eff_to_dt") = "";
		}
		//1.Account Code, Cost Code 변경시 해당 Tariff 가 존재할 경우
		//2.Exchange Rate 변경할 경우
		else {
			
			var calcData = data.split("");
			sheetObj.CellValue2(Row, "sheet1_tariff_cost") 	  = calcData[0];
			sheetObj.CellValue2(Row, "sheet1_foml2") 		  = calcData[1];
			sheetObj.CellValue2(Row, "sheet1_foml1") 		  = calcData[2];
			sheetObj.CellValue2(Row, "sheet1_yd_chg_no") 	  = calcData[3];	 
			sheetObj.CellValue2(Row, "sheet1_yd_chg_ver_seq") = calcData[4];
			sheetObj.CellValue2(Row, "sheet1_mnl_inp_xch_rt") = calcData[7]; //2015.05.13 추가
			ioCondChk = calcData[5];
		
			// Tariff Currency 와 Invoice Currency 가 다를 경우, Exchange Rate 컬럼을 추가해준다.
			sheetObj.CellValue2(Row, "sheet1_trf_curr_cd") = calcData[6];
			
			//if(sheetObj.CellValue(Row, "sheet1_mnl_inp_xch_rt") != "") {
		 	//  ComShowMessage("Please check Exchange Rate at first, If is in correct, Please change it.");
			//}
			
			if (fnSetEnableExchangeRate(Row) && sheetObj.ColHidden("sheet1_mnl_inp_xch_rt")) {
				sheetObj.ColHidden("sheet1_mnl_inp_xch_rt") = false;
			}   			
		}
		formObj.vvdband.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_cd") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_voy_no") + sheetObj.CellValue(sheetObj.SelectRow, "sheet1_skd_dir_cd");
	
		setCalcAmtVvd();
		formObj.calc_amt_ttl.value = Number(sheetObj.CellValue(sheetObj.RowCount+1, "sheet1_amount")).toFixed(2);
	
		ComChkObjValid(formObj.calc_amt_vvd);
    	ComChkObjValid(formObj.calc_amt_ttl);
    
   
    	      		    	
	}
	
	
	
}