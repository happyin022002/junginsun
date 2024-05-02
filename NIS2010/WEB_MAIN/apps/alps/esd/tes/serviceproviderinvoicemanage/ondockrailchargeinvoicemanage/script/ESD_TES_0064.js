/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0064.js
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
* 2009-06-08 [N200906080150]     : INV TTL Amount 에러 조치 요청
* 2011-03-11 [CHM-201109193-01]  : iss_dt, rcv_dt 현재 office 날짜 이후로 입력 불가
* 2011.06.10 [CHM-201111056-01] Split 03-Split 07-ALPS Error 처리 요청
* 2011.08.17 박정일 [E-mail요청] [TES] special character, characterSet problem
* 2012.04.05 오요한 [CHM-201217076] [TES]On-Dock Rail Charge 관련 BND별 rate 적용 및 Agrement의 Mode 선택 제한
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;

var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0 ;
var save_conf_01 = false;
var retrieve_conf_01 = false;
var recalc_val = "Y";
var lgs_cost_cd_combo = '';
var whld_tax_readonly_mode = true;

var CNTR_TPSZ_CD;
var ON_A_LGS_COST_CD;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */ 
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    /*******************************************************/
    var sheetObject 	 = sheetObjects[0];
    var sheetObject1 	 = sheetObjects[1];
    var sheetObject2 	 = sheetObjects[2];
    var sheetObject_main = sheetObjects[3];
    var formObj = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        
        switch(srcName) {
           
		case "btn_pre_inquiry_cond":
			var url_str = 'ESD_TES_0013.do';
			url_str += '?pgmNo=ESD_TES_0013';
			url_str += '&pre_cond_inv_no='+document.form.pre_cond_inv_no.value;
			url_str += '&pre_cond_inv_date_type='+document.form.pre_cond_inv_date_type.value;
			url_str += '&pre_cond_fm_prd_dt='+document.form.pre_cond_fm_prd_dt.value;
			url_str += '&pre_cond_to_prd_dt='+document.form.pre_cond_to_prd_dt.value;
			url_str += '&pre_cond_yd_cd='+document.form.pre_cond_yd_cd.value;
			url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
			url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
			url_str += '&pre_cond_inv_ofc_cd='+document.form.pre_cond_inv_ofc_cd.value;
			url_str += '&pre_cond_tml_inv_sts_cd='+document.form.pre_cond_tml_inv_sts_cd.value;
			url_str += '&pre_cond_csr_no='+document.form.pre_cond_csr_no.value;
			url_str += '&pre_cond_csr_status='+document.form.pre_cond_csr_status.value;
			url_str += '&pre_cond_tml_inv_rjct_sts_cd='+document.form.pre_cond_tml_inv_rjct_sts_cd.value;
			location.href = url_str;
		break;
		
           case "btn_retrieve":
        	   	 tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                 retrieveEvent(sheetObject_main, formObj);
                 break;
               
           case "btn_new":
                 sheetObjects[0].RemoveAll();
                 sheetObjects[1].RemoveAll();
                 sheetObjects[2].RemoveAll();
                 sheetObjects[3].RemoveAll();
                    
                 formObj.reset();
                 setInitComponent("N");
                 tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd');
                 tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                 
                 break;
                 
          case "btn_copy":
                 var tmp_vndr_seq = formObj.vndr_seq.value;
                 var tmp_yd_cd = formObj.yd_cd.value;
                 var tmp_iss_dt = formObj.iss_dt.value;
                 var tmp_rcv_dt = formObj.rcv_dt.value;
                 sheetObjects[0].RemoveAll();
                 sheetObjects[1].RemoveAll();
                 sheetObjects[2].RemoveAll();
                 sheetObjects[3].RemoveAll();
                 formObj.reset();
                 formObj.vndr_seq.value = tmp_vndr_seq;
                 formObj.yd_cd.value = tmp_yd_cd;
                 formObj.iss_dt.value = tmp_iss_dt;
                 formObj.rcv_dt.value = tmp_rcv_dt;
                 validateVndrSeq();
                 validateYardCode();
                 setInitComponent("N");
                 tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                 break;

          case "btn_save":
	            if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
	                 ComShowMessage("Rejected Invoice !!");
	                 return false;
	            }
				if (formObj.tml_inv_sts_cd		.value == "C") {
					 ComShowMessage("Confirmed Invoice !!");
					 return false;
				}
				if (formObj.curr_cd.Code == null || formObj.curr_cd.Code.trim() == '') {
	    			ComShowMessage(ComGetMsg('TES40039')); // ComShowMessage('so header의 currency code가 선택되지 않았습니다.');
	    			return false;
	    		}
				if(ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0){
	                 ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
	                 return false;
	            }
				
			   if (!isValIssSys(formObj.iss_dt)){ 	
				   return false;
			   } 
			   
			   if (!isValIssSys(formObj.rcv_dt)){ 	
				   return false;
			   }
				   
				invHeaderSave(sheetObject_main,formObj);
				retrieveEvent(sheetObject_main, formObj);  //2007.02.20 주석처리 하려다 만다;
                break;
                
		  //Vender Serch Event
		  case "btn_vndr":
                if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd		.value == "C") {
				    ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
				var classId = "COM_ENS_0C1";
				var param = '?classId='+classId;
				var chkStr = dispaly.substring(0,3)

				// radio PopUp
				if(chkStr == "1,0") {
					ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getVender', dispaly);
				} else {
					ComShowMessage(ComGetMsg('TES21003')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
					return;
				}
				break;

	       case "btn_cost_ofc":
	        	if(formObj.cost_ofc_cd.readOnly){
	        	   	ComShowMessage(ComGetMsg('TES23007','Yard Code')); //ComShowMessage("Yard Code를 먼저 입력되어야합니다.");
	        	   	return false;
	        	}
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if (formObj.cost_ofc_cd.readOnly) { return false;	}

				var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
				var classId = "COM_ENS_071";
				var param = '?classId='+classId;
				var chkStr = dispaly.substring(0,3);

				// radio PopUp
				if(chkStr == "1,0") {
					ComOpenPopup('/hanjin/COM_ENS_071.do' + param,  770,  450, 'getOfcCd', dispaly, true);
				} else {
					ComShowMessage(ComGetMsg('TES21003')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
					return;
				}
				break;
				
		  case "btn_yard":
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					 ComShowMessage("Rejected Invoice !!");
					 return false;
				}
				if (formObj.tml_inv_sts_cd		.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
				var classId = "COM_ENS_061";
				var param = '?classId='+classId;
				var chkStr = dispaly.substring(0,3);
									
				// radio PopUp
				if(chkStr == "1,0") {
					ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 480, 'getYard', dispaly, true);
				} else {
					ComShowMessage(ComGetMsg('TES21003')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
					return;
				}
				break;
				
		  case "btns_calendar1":
			    var cal = new ComCalendar();
			    cal.select(formObj.iss_dt, 'yyyy-MM-dd');
			    break;

		  case "btns_calendar2":
			    var cal = new ComCalendar();
			    cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
			    break;

		  case "btns_remarks":
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if (formObj.hld_flg.checked == true) {
					ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk', 'popup_remarks', 300, 140, true);

				}
				break;

          case "btng_fileimport1":
                if (!save_conf_01){
					ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage("해당 Terminal Invoice Header가 저장되지 않았습니다.");
					return false;
				}
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd		.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}

				if(!fnChkEmptyObj(formObj.vndr_seq)) return;
  			    if(!fnChkEmptyObj(formObj.yd_cd)) return;
				if(!fnChkEmptyObj(formObj.rcv_dt)) return;
				if(formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
					formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
					return false;
				
                if(sheetObject.RowCount > 0 || sheetObject1.RowCount > 0 ){
				    var confirm_value = confirm(ComGetMsg('TES22006'));//"기존 Coincidence, Discrepancy Tab의 모든 Container List Data를 삭제하시겠습니까? "
				    if(!confirm_value) return false;
				    if(deleteContanerList()) gridSave();

				}
				window.showModalDialog('ESD_TES_9130.screen', window, "dialogWidth:520px; dialogHeight:440px; help:no; status:no; resizable:yes;");
                t1sheet1_OnLoadFinish(sheetObject);
                t2sheet1_OnLoadFinish(sheetObject1);

                break;
                  
          case "btng_save1":
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if(CheckCNTRListMandatoryCol() == false){
					return false;
				}
				gridSave();
                break;

		  case "t1btng_clear":
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if(formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
					formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
					return false;
							  
				if(sheetObject.RowCount > 0 || sheetObject1.RowCount > 0 ){
					var confirm_value = confirm(ComGetMsg('TES22006'));//"기존 Coincidence, Discrepancy Tab의 모든 Container List Data를 삭제하시겠습니까? "
					if(!confirm_value) return false;
					if(deleteContanerList()) gridSave();
				}
				break;
				
          case "btng_todiscrepancy1":
				if (!save_conf_01){
					ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage("해당 Terminal Invoice Header가 저장되지 않았습니다.");
		  			return false;
				}
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd		.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if (sheetObject.RowCount < 1){
					ComShowMessage(ComGetMsg('TES21008')); //ComShowMessage("변환할 데이터가 없습니다.");
		  			return false;
				}
				if (sheetObject.CheckedRows("chk") < 1){
					ComShowMessage(ComGetMsg('TES21009')); //ComShowMessage("선택된 데이터가 없습니다.");
		  			return false;
				}
				
				//toDiscreption(sheetObject,sheetObject1);
				modifyContainerVerifyStatus(sheetObject, sheetObject1, 'DC', 'Y');
            
				break;

          case "t1btng_downexcel":
                doActionIBSheet1(sheetObject,formObj,IBDOWNEXCEL);
                break;
         
          case "btng_costcalc1":
				if (!save_conf_01){
					ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage("해당 Terminal Invoice Header가 저장되지 않았습니다.");
					return false;
				}
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd		.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if(!validMandatoryItemContainerList(sheetObjects[0])){
					return false;
				}

				var sheets = new Array();
				sheets[0] = sheetObjects[0];
				if (tes_isModified2(sheets)){
					ComShowMessage(ComGetMsg('TES21011')); //ComShowMessage('변경된  Container List data가 있습니다. 먼저 Container List Data를 저장하세요.');
					recalc_val = "N";
					return false;
				}

                if(sheetObjects[0].RowCount > 0 && (sheetObjects[2].RowCount == 0 || recalc_val == "N" )) //Coincidence List Data가 있고 CostCalcList데이터가 없을때

					formObj.cost_calc_mode.value = "N";
					formObj.tab1.selectedIndex = 2;
					sheetObjects[2].RemoveAll();
					doActionIBSheet3(sheetObjects[2],formObj,IBSEARCH);
					t3sheet1_OnLoadFinish(sheetObjects[2]);

                   	recalc_val = "Y";
                break;
                    
		  case "t2btng_clear":
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if(formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
					formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
					return false;
				
                if(sheetObject.RowCount > 0 || sheetObject1.RowCount > 0 ){
					var confirm_value = confirm(ComGetMsg('TES22006'));//"기존 Coincidence, Discrepancy Tab의 모든 Container List Data를 삭제하시겠습니까? "
					if(!confirm_value) return false;
					if(deleteContanerList()) gridSave();
				}
				break;
									
          case "t2btng_coincidence":
				if (!save_conf_01){
					ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage("해당 Terminal Invoice Header가 저장되지 않았습니다.");
					return false;
				}
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if (sheetObject1.RowCount < 1){
					ComShowMessage(ComGetMsg('TES21012')); //ComShowMessage("계산 할 데이터가 없습니다.");
		  			return false;
				}
				if (sheetObject1.CheckedRows("chk") < 1){
					ComShowMessage(ComGetMsg('TES21009')); //ComShowMessage("선택된 데이터가 없습니다.");
		  			return false;
				}

				//toCoincidence(sheetObject1,sheetObject);
				
				modifyContainerVerifyStatus(sheetObject1, sheetObject, 'CO', 'Y');
				
				break;
                    
          case "t2btng_chkdgit":
          	if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
          		ComShowMessage('Rejected Invoice !!');
          		return false;
          	}
          	if (formObj.tml_inv_sts_cd.value == 'C') {
          		ComShowMessage('Confirmed Invoice !!');
          		return false;
          	}
          	
  			if (sheetObject1.RowCount > 0) {
  				doActionIBSheet2(sheetObject1,formObj,IBSEARCH_ASYNC01);
  			}
              
          	break;
          	
          case "t2btng_reject":
				if (!save_conf_01){
					ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage("해당 Terminal Invoice Header가 저장되지 않았습니다.");
		  			return false;
				}
				if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
				}
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				if (sheetObject1.RowCount < 1){
					ComShowMessage(ComGetMsg('TES21012')); //ComShowMessage("계산 할 데이터가 없습니다.");
		  			return false;
				}

				ComOpenWindowCenter('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 'popup_reject', 300, 200, true);
                break;

		   case "t2btng_print":
				var fromObj = new Array();
				var rdObj  	= new Array();
				var parmObj = new Array();
			    fromObj[0] = formObj;                            			// Form Data를 RD 로 보내기 위해 배열로담는다
	            if ( sheetObjects[1].RowCount < 1 ) // RD 로 보낼 sheet 에 데이타가 없으면 Error
			   {
			        ComShowMessage(ComGetMsg('TES21013')); //ComShowMessage("Not Exist Discrepancy Container List Data!");
			        return;
			   }

               // RD 로 보내기 위한 설정
			            parmObj[0] = "1";
			            parmObj[1] = "";
			            parmObj[2] = "N";
			            parmObj[3] = RD_path+"apps/alps/esd/tes/serviceproviderinvoicemanage/ondockrailchargeinvoicemanage/report/ESD_TES_8060.mrd";     // RD 화면
//			            parmObj[3] = "http://localhost:7001/hanjin/apps/alps/esd/tes/serviceproviderinvoicemanage/ondockrailchargeinvoicemanage/report/ESD_TES_806.mrd";     // RD 화면
			            parmObj[4] = rdObj;
			            parmObj[5] = fromObj;
			            rdObjModaless(RdReport , parmObj , 1000 ,700);
						break;
			            

         case "t2btng_downexcel":
               doActionIBSheet2(sheetObject1,formObj,IBDOWNEXCEL);
               break;

         case "t3btng_costCal":
		     var param = "?yd_cd="+formObj.yd_cd.value +"&vndr_seq="+formObj.vndr_seq.value+"&vndr_seq_nm="+formObj.vndr_seq_nm.value+"&prgm_id=ESD_TES_0064&cost_cd_inv_tp_cd=ON&min_wrk_dt="+formObj.min_wrk_dt.value+"&max_wrk_dt="+formObj.max_wrk_dt.value;

		   //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
		    ComOpenPopup("ESD_TES_9001.do" + param,   820,    670,     "setCostCode2",  "1,0,1,1,1,1,1", true,   false,    null, null,  null,     'Cost Calculation','no');
		    break;	
     	
         case "t3btng_clear":
			   if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
		       }
			   if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
			   }
			   if(formObj.vndr_seq.value == null || formObj.vndr_seq.value == "" ||
					formObj.yd_cd.value == null || formObj.yd_cd.value == "" || formObj.is_valid_yd_cd.value != 'Y')
					return false;
				
               if(sheetObject.RowCount > 0 || sheetObject1.RowCount > 0 || sheetObject2.RowCount > 0 ){
					var confirm_value = confirm(ComGetMsg('TES22006'));//"기존 Coincidence, Discrepancy Tab의 모든 Container List Data를 삭제하시겠습니까? "
					if(!confirm_value) return false;
					if(deleteContanerList()) gridSave();
			   }
			   break;

		 case "t3btng_rowadd":
			   if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					 ComShowMessage("Rejected Invoice !!");
					 return false;
			   }
			   if (formObj.tml_inv_sts_cd.value == "C") {
					 ComShowMessage("Confirmed Invoice !!");
					 return false;
			   }
			   costCalcRowAdd(sheetObject2);
			   break;
					        	
		 case "t3btng_rowdel":
			   if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
					ComShowMessage("Rejected Invoice !!");
					return false;
			   }
				if (formObj.tml_inv_sts_cd.value == "C") {
					ComShowMessage("Confirmed Invoice !!");
					return false;
				}
				costCalcRowDel(sheetObject2);
				break;

         case "btng_save3":
				  if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd		.value == "C") {
						ComShowMessage("Confirmed Invoice !!");
						return false;
					}

					for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
						
						var costCd = sheetObject2.CellValue(i,'lgs_cost_cd');
						var calRmk = sheetObject2.CellValue(i,'calc_rmk').trim();
						
						if(sheetObject2.CellValue(i,'calc_tp_cd') == 'M' && sheetObject2.CellValue(i,'lgs_cost_cd') == ''){
				            ComShowMessage(ComGetMsg('TES40018')); //ComShowMessage('Manual Input된 Row에 Cost Code가 입력되지 않았습니다.');
				            return false;
				        }
						
//						if(CostCdValidForCalcRemark('ON',costCd,calRmk) == false){
//							 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
//							 return false;
//						 }
						
						 //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
						 // A인 경우는 4개의 Invoice에서 모두 필수 이면서 10자이상 입력, ON 화면에서 Y인 경우는 Remark값이 필수 
						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'A' && calRmk.length < 10) {
							 ComShowMessage(ComGetMsg('TES10128'));
							 return false;
						 }
						 
						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
							 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
							 return false;
						 }
						
//   						 if(sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'calc_vol_qty')==null || sheetObject2.CellValue(i,'calc_vol_qty')==0)){
//							 if(sheetObject2.CellValue(i,'rvis_vol_qty')==null || sheetObject2.CellValue(i,'rvis_vol_qty')==0){
//								 ComShowMessage("Plz, input Calculated Vol or Revised Vol. Zero or Null does not allow.");
//								 return false;
//							 }
//						 }
		                    
//						 if( sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'ctrt_rt')==null || sheetObject2.CellValue(i,'ctrt_rt')==0.00)){
//							 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//							 return false;
//						 }									 
						 
				    }
			
					gridSave();
										
                    break;
                case "btng_totalamount3":
    				var url_str = "ESD_TES_9060Popup.screen?tml_inv_tp_cd="+document.form.tml_inv_tp_cd.value+"&tml_so_ofc_cty_cd="+document.form.tml_so_ofc_cty_cd.value
    							+"&tml_so_seq="+document.form.tml_so_seq.value;
    				window.showModalDialog(url_str, window, "dialogWidth:510px; dialogHeight:400px; help:no; status:no; resizable:yes;");
    				break;
                case "btng_confirm3":
					if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == "C") {
						ComShowMessage("Confirmed Invoice !!");
						return false;
					}
					if(recalc_val != "Y"){
						ComShowMessage(ComGetMsg('TES22012')); //ComShowMessage(' 변경된 Container List data에 대해 다시 Cost Calculation한후 Confirm 하십시오. ');
						return false;
					}
					if(sheetObject2.RowCount==0){
					    ComShowMessage(ComGetMsg('TES21015')); //ComShowMessage('Cost Calculation을 수행하지 않았습니다. Cost Calculation후 Confirm 하십시오.');
					    return false;
					}
					if(formObj.ttl_inv_amt.value != formObj.tot_inv_amt.value){
						ComShowMessage(ComGetMsg('TES21016')); //ComShowMessage("INV AMT 와 Calcurated AMT 값이 일치하지않습니다.");
						return false;
					}
					
					if(ida_ofc_cd == 'Y'){
						if(formObj.ida_cgst_amt.value != formObj.tot_cgst_amt.value) {
							ComShowMessage(ComGetMsg('TES21056')); //ComShowMessage("CGST AMT and calculated CGST AMT do not match."); 
							return false;
						}
						if(formObj.ida_sgst_amt.value != formObj.tot_sgst_amt.value) {
						   	ComShowMessage(ComGetMsg('TES21057')); //ComShowMessage("SGST AMT and calculated SGST AMT do not match."); 
							return false;
						}
						if(formObj.ida_igst_amt.value != formObj.tot_igst_amt.value) {
							ComShowMessage(ComGetMsg('TES21058')); //ComShowMessage("IGST AMT and calculated IGST AMT do not match."); 
							return false;
						}
						if(formObj.ida_ugst_amt.value != formObj.tot_ugst_amt.value) {
							ComShowMessage(ComGetMsg('TES21059')); //ComShowMessage("UGST AMT and calculated UGST AMT do not match."); 
							return false;
						}
					}
					
					if(ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0){
                        ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
                        return false;
                    }

				    if (!isValIssSys(formObj.iss_dt)){ 	
					    return false;
				    } 
				   
				    if (!isValIssSys(formObj.rcv_dt)){ 	
					    return false;
				    }
					   
					for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
				        if(sheetObject2.CellValue(i,'calc_tp_cd') == 'M' && sheetObject2.CellValue(i,'lgs_cost_cd') == ''){
				            ComShowMessage(ComGetMsg('TES40018')); //ComShowMessage('Manual Input된 Row에 Cost Code가 입력되지 않았습니다.');
				            return false;
				        }

				        if((sheetObject2.CellValue(i,'curr_cd') != formObj.curr_cd.Code) && (sheetObject2.CellValue(i,'inv_xch_rt')==0)
				           && (sheetObject2.CellValue(i,'calc_tp_cd') == 'A')){
				            ComShowMessage('There is no exchange rate at the suitable column.');
				            return false;
				        }
				        
//		                   						 if(sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'calc_vol_qty')==null || sheetObject2.CellValue(i,'calc_vol_qty')==0)){
//		                							 if(sheetObject2.CellValue(i,'rvis_vol_qty')==null || sheetObject2.CellValue(i,'rvis_vol_qty')==0){
//		                								 ComShowMessage("Plz, input Calculated Vol or Revised Vol. Zero or Null does not allow.");
//		                								 return false;
//		                							 }
//		                						 }
	                    
//		                						 if( sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'ctrt_rt')==null || sheetObject2.CellValue(i,'ctrt_rt')==0.00)){
//		                							 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//		                							 return false;
//		                						 }	
				         
				         //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
   						 // A인 경우는 4개의 Invoice에서 모두 필수 이면서 10자이상 입력, ON 화면에서 Y인 경우는 Remark값이 필수 
   						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'A' && sheetObject2.CellValue(i,'calc_rmk').length < 10) {
   							 ComShowMessage(ComGetMsg('TES10128'));
   							 return false;
   						 }
   						 
   						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'Y' && sheetObject2.CellValue(i,'calc_rmk').length == 0) {
   							 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
   							 return false;
   						 }
       						 
				    }
					//setForm2HdSheet(sheetObject_main);
					//sheetObject_main.CellValue(1,"tml_inv_sts_cd") = "C";
					//sheetObject_main.RowStatus(1) = "U";
					formObj.tml_inv_sts_cd.value = "C";
					if (sheetObjects[2].RowCount > 0) {
						doActionIBSheet3(sheetObjects[2],formObj,IBSAVE);
					}
					invHeaderSave(sheetObject_main,formObj);
					//Confirm 후 해당 Invoice는 Confirm된 Invoice 입니다. 수정하시겠습니까? 하는 메세지가 뜬다.
					//위 메세지 창이 뜨지 않도록 하기위해 retrieveEvent함수를 막았고, INV_STATUS를 'CF'로 수정한다.
                            formObj.tml_inv_sts_nm.value = "CF";
                            for (var e = 0; e < formObj.elements.length; e++) {
                                 var el = formObj.elements[e];
                                 ComEnableObject(el, false);
                             }
                             ComEnableManyObjects(true, formObj.vndr_seq, formObj.inv_no);
                 		     sheetObjects[0].Editable = false;
                             sheetObjects[1].Editable = false;
                             sheetObjects[2].Editable = false;
                             ComShowMessage(ComGetMsg('TES40010')); //ComShowMessage('Confirm 되었습니다.');
                             tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));

                             break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

/**
 * 문자열을 구분자 "|" 로 배열을 반환
 * @param {string}	strEleNums	
 * @return
 */
function setEleNums(strEleNums){
	var eleNums = new Array();
	eleNums = strEleNums.split("|");
	return eleNums;	
} 

/**
 * Coincidence, Discrepancy 탭간 이동
 * @param {ibsheet} fromSheet	sheet object 
 * @param {ibsheet}	toSheet		sheet object
 * @param {String}	cntr_status	
 * @param {String}	modi_flg	
 * 
 * (cntr_status : 'CO'/'DC'
 *  modi_flg    : 'Y'/''   )
 */
function modifyContainerVerifyStatus(fromSheet, toSheet, cntr_status, modi_flg){
	var needDigit = false;
	
    for(var i=fromSheet.HeaderRows; i<fromSheet.HeaderRows+fromSheet.RowCount; i++){
        if(fromSheet.CellValue(i, 'chk') == '1'){
            fromSheet.CellValue(i,'vrfy_rslt_ind_cd') = cntr_status;
            fromSheet.CellValue(i,'modi_flg') = modi_flg;
            
			if( fromSheet.CellValue(i, 'cntr_no').length <= 10){
				needDigit = true;
			} 
        }
    }
    
	if(needDigit){
		alert("Wrong Container NO exists, Please click CHK Dgit before verify process.");
		return false;
	}
	
    var queryStr = '';
    queryStr = fromSheet.GetSaveString(false, false, 'chk');
//    tes_copy_rows_to(fromSheet, toSheet, 'chk', queryStr, true);
    tes_copy_rows_to2(toSheet, queryStr, true);
	
    for(var i=fromSheet.RowCount; i>=fromSheet.HeaderRows; i--){
        if(fromSheet.CellValue(i, 'chk') == '1'){
            fromSheet.RowDelete(i, false);
        }
    }
}

/** 엔터 체크 
 * 
 * @param funcNm
 * @return
 */
function enterCheck(funcNm){
    var formObj = document.form;
	if (funcNm==undefined || funcNm==null || funcNm.trim()==''){return false;}
	if (event.keyCode == 13){retrieveEvent(sheetObjects[3], formObj);}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {ibsheet}	sheet_obj	sheet object
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
   sheetObjectsMap[sheet_obj.id]= sheet_obj;
}

/** 
 * common code 세팅
 * 
 * @return
 */
function setCommonCode(){
	var formObj = document.form;
	var tmp = '';
	if (formObj.tmp_common_code.value!=undefined && formObj.tmp_common_code.value!=null && formObj.tmp_common_code.value.trim()!=''){
		tmp = formObj.tmp_common_code.value.split('--');
		if (tmp.length > 0){
			for (var i=0; i<tmp.length; i++){
				tmp[i] = (tmp[i]!=undefined&&tmp[i]!=null?tmp[i]:'');
			}
			CNTR_TPSZ_CD		= tmp[0];
			ON_A_LGS_COST_CD	= tmp[2];
		}
	}
	for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
	}

	var sheetObject_main = sheetObjects[3];
    if(!ComIsNull(formObj.inv_no_tmp.value)){
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        retrieveEvent(sheetObject_main, formObj);
    }
}



/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for(i=0;i< comboObjects.length;i++){
        initCombo (comboObjects[i],i+1);
    }

    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    for(i=0;i<tabObjects.length;i++){
        initTab(tabObjects[i],i+1);
    }

    try	{
    	//login user의 default office와 로그인한 office가 같은지 체크 
    	if(document.form.pre_cond_inv_no.value == ''){
    		tes_getInputValue('chk_ofc_cd', SEARCH25, '', 'checkLoginOfc');  
    	}
        tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd', 'setCalcColFormat');
    } catch(e){}
    
    //India Info Display
	if(ida_ofc_cd == 'Y'){
		document.all.IndiaLayer01.style.display = "inline";
		document.all.IndiaLayer02.style.display = "inline";
		
	} else {
		document.all.IndiaLayer01.style.display = "none";
		document.all.IndiaLayer02.style.display = "none";
		
	}
}

/**
 * 
 * @return
 */
function setWhldTaxAmtMode(){
	var formObj = document.form;
	var tmp = '';
	tmp = formObj.whld_tax_amt_mode.value;
	if (tmp!=undefined && tmp!=null && tmp.trim()=='Y'){
		whld_tax_readonly_mode = false;
	} else {
		whld_tax_readonly_mode = true;
	}
}

/**
 * 
 * @return
 */
function setCalcColFormat(){
	resetSheetDataProperty(comboObjects[0].Code);
	
    try	{
		tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');
		tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
	} catch(e){}
	
    setInitComponent("N");
    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
    
    save_conf_01 = false;

	var formObj = document.form;
    //formObj.vndr_seq.focus();
}

 /**
 * IBCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}


  /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initCombo (comboObj, comboNo, combo_val, def_val,tpszCodeValue) {
        var cnt  = 0 ;
        var tpszCodeArray = (tpszCodeValue != null)? tpszCodeValue.split("|") :"";
        switch(comboNo) {
            case 1:
               with (comboObj) {
								SetColAlign("center");
								SetColWidth("90");
								DropHeight=150;

								var tmp = '';
								if (combo_val!=null){tmp = combo_val.split('|');}
								for (var i=0; tmp!=null && i<tmp.length; i++){
									InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
								}
								if (def_val!=undefined && def_val!=null && def_val.trim()!=''){
									Code = def_val;
								} else {
									Code = '';
								}
    	       }
            break;
           case 3:
               //comboObj.RemoveAll();
               with (comboObj) {
			    	       SetColAlign("left");
			    	       SetColWidth("40")

			    	       for(i=0 ;i<tpszCodeArray.length;i++){
			                valueArray = tpszCodeArray[i].split("--");
			               InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
			               }
			    	    }
           break;

         }
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
function initSheet(sheetObj,sheetNo) {

	sheetObj.UseUtf8 = true;
    var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(37, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|STS||Seq.|PAGE|modi_flg|VVD|CNTR No.|Type/Size|F/M|I/O|DG|Working Date|"
                    							+ "bkg_no|bkg_no_split|CLM Date|Rail Billing  \nDate|Verify \n Result|dscr_ind_nm|Remark|dscr_rsn|"
                    							+ "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|vrfy_rslt_ind_cd|atb_dt|vndr_seq|"
                    							+ "vsl_cd|skd_voy_no|skd_dir_cd|finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd|dscr_dtl_ind_cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "ibflag"			     ,	   false,          "",      dfNone,      0,     false,       true );
                    InitDataProperty(0, cnt++ , dtHidden  ,      30,    daCenter,  false,    "sts"			     	 ,	   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,  false,    "chk"					 ,	   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtSeq	  ,      30,    daCenter,  false,    ""				         ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,      30,    daCenter,  false,    "page"				     ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "modi_flg"				 ,     false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData    ,      80,    daCenter,  false,    "vvd_no"				 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "cntr_no"				 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,      70,    daCenter,  false,    "cntr_tpsz_cd"			 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtCombo   ,      35,    daCenter,  false,    "cntr_sty_cd"			 ,     false,          "",      dfNone,      0,     true,       true);
				    InitDataProperty(0, cnt++ , dtData    ,      30,    daCenter,  false,     "io_bnd_cd"     	     ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtCombo   ,      35,    daCenter,  false,     "dcgo_clss_cd" 	     ,     false,          "",      dfNone,      0,     true,       true);
				    InitDataProperty(0, cnt++ , dtData    ,      80,    daCenter,  false,     "wrk_dt"     	         ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,     "bkg_no" 	     	     ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,     "bkg_no_split" 	     ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtData    ,      80,    daCenter,  false,     "clm_dt"     	 	     ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtData    ,      80,    daCenter,  false,     "rail_bil_dt"  	     ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtData    ,      50,    daCenter,  false,    "dscr_ind_cd"			 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "dscr_ind_nm"			 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "cntr_rmk"				 ,     false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "dscr_rsn"				 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "tml_so_ofc_cty_cd"     ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "tml_so_seq"            ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "tml_so_cntr_list_seq"  ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vrfy_rslt_ind_cd"      ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "atb_dt"				 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vndr_seq"				 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vsl_cd"				 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "skd_voy_no"			 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "skd_dir_cd"			 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "finc_vsl_cd"  ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "finc_skd_voy_no"		 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "finc_skd_dir_cd"		 ,     false,          "",      dfNone,      0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "dscr_dtl_ind_cd"		 ,     false,          "",      dfNone,      0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no"		 		 ,     false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no_tp"	 		 ,     false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no_chk"	 		 ,     false,          "",      dfNone,      0,     false,       false);

					InitDataCombo(0 , "cntr_sty_cd"		, cntr_sty_cdCode		, cntr_sty_cdCode);
					InitDataCombo(0 , "dcgo_clss_cd"	, dcgo_clss_cdCode	, dcgo_clss_cdCode);

									  style.height = GetSheetHeight(16) ;
               }
                break;
            case 2:     //sheet2 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(37, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|STS||Seq.|PAGE|modi_flg|dscr_ind_cd|Dscr Ind Nm|CNTR No.|Type /\nSize|F/M|DG|Working Date|"
                    							+ "bkg_no|bkg_no_split|CLM Date|Rail Billing Date|Remark|IO|dscr_rsn|"
                    							+ "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|vrfy_rslt_ind_cd|atb_dt|vvd_no|vndr_seq|"
                    							+ "vsl_cd|skd_voy_no|skd_dir_cd|finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "ibflag"			     		 ,		 false,          "",      dfNone,      0,     false ,       true );
                    InitDataProperty(0, cnt++ , dtHidden  ,      30,    daCenter,  false,    "sts"			     		   ,		 false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,  false,    "chk"								 ,		 false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtSeq			,      30,    daCenter,  false,    ""										 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden	,      30,    daCenter,  false,    "page"								 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "modi_flg"				 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "dscr_ind_cd"				 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  true ,    "dscr_ind_nm"				 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "cntr_no"						 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo    ,      50,    daCenter,  false,    "cntr_tpsz_cd"				 ,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo    ,      35,    daCenter,  false,    "cntr_sty_cd"			   ,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo   ,      35,    daCenter,  false,    "dcgo_clss_cd" 	     ,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "wrk_dt"     	       ,     false,          "",       dfDateYmd,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "bkg_no" 	     	     ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "bkg_no_split" 	     ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "clm_dt"     	 	     ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "rail_bil_dt"  	     ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    ,     100,    daCenter,  false,    "cntr_rmk"						 ,     false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtHidden  ,      30,    daCenter,  false,     "io_bnd_cd"     	     ,     			false,          "",      dfNone,      0,    false,      false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "dscr_rsn"						 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "tml_so_ofc_cty_cd"   ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "tml_so_seq"          ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "tml_so_cntr_list_seq",     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vrfy_rslt_ind_cd"    ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "atb_dt"							 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vvd_no"							 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vndr_seq"						 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "vsl_cd"						 	 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "skd_voy_no"					 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "skd_dir_cd"					 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "finc_vsl_cd",     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "finc_skd_voy_no"		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "finc_skd_dir_cd"		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  ,     100,    daCenter,  false,    "dscr_dtl_ind_cd"		 ,     false,          "",      dfNone,      0,     false,       false);

					InitDataCombo(0 , "dcgo_clss_cd"	, dcgo_clss_cdCode	, dcgo_clss_cdCode);

                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no"		 		 ,     false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no_tp"	 		 ,     false,          "",      dfNone,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no_chk"	 		 ,     false,          "",      dfNone,      0,     false,       false);



                    InitDataCombo(0 , "cntr_tpsz_cd" , CNTR_TPSZ_CD, CNTR_TPSZ_CD);
                    InitDataCombo(0 , "cntr_sty_cd"		, cntr_sty_cdCode		, cntr_sty_cdCode);
                    style.height = GetSheetHeight(17) ;

								}
                break;

            case 3:     //sheet3 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                   MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(ida_ofc_cd == 'Y'){
        				InitRowInfo(2, 1, 5, 100);
        			} else {
        				InitRowInfo(1, 1, 5, 100);
        			}

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(65, 12, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "STS|PAGE|tml_so_ofc_cty_cd|tml_so_seq|tml_so_dtl_seq|calc_cost_grp_cd|Calcuration Type|vsl_cd|skd_voy_no|skd_dir_cd|vvd_no|"
                    							+ "Cost Code|HSN/SAC|Goods/\nServices|Type /\n Size|Applied \nDate|DG|fm_tr_vol_val|to_tr_vol_val|Vol.Tier|acct_cd|CalculatedVol.|Revised Vol.|"
                    							+ "UOM|Rate|AGMT\nCurr.|Exch.Rate|Amount|Amount2|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|semi|3rd Party|IO|atb_dt|cntr_no|dcgo_ind_cd|stay_dys|free_dys|ovr_dys|"
                    							+ "fp_calc_prd_cd|wrk_dt|stk_vol_qty|fp_teu_qty|inv_vol_qty|diff_vol_qty|ovr_vol_qty|calc_amt|"
                    							+ "finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd|lgs_cost_cd2|cntr_tpsz_cd2|tml_agmt_ofc_cty_cd|tml_agmt_seq"
                    							+ "|tml_agmt_ver_no|curr_chk|rmk_chk_flg";

                    if(ida_ofc_cd == 'Y'){
                    	var HeadTitle1 = "STS|PAGE|tml_so_ofc_cty_cd|tml_so_seq|tml_so_dtl_seq|calc_cost_grp_cd|Calcuration Type|vsl_cd|skd_voy_no|skd_dir_cd|vvd_no|"
							+ "Cost Code|HSN/SAC|Goods/\nServices|Type /\n Size|Applied \nDate|DG|fm_tr_vol_val|to_tr_vol_val|Vol.Tier|acct_cd|CalculatedVol.|Revised Vol.|"
							+ "UOM|Rate|AGMT\nCurr.|Exch.Rate|Amount|Amount2|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|semi|3rd Party|IO|atb_dt|cntr_no|dcgo_ind_cd|stay_dys|free_dys|ovr_dys|"
							+ "fp_calc_prd_cd|wrk_dt|stk_vol_qty|fp_teu_qty|inv_vol_qty|diff_vol_qty|ovr_vol_qty|calc_amt|"
							+ "finc_vsl_finc_vsl_cd|finc_skd_voy_no|finc_skd_dir_cd|lgs_cost_cd2|cntr_tpsz_cd2|tml_agmt_ofc_cty_cd|tml_agmt_seq"
							+ "|tml_agmt_ver_no|curr_chk|rmk_chk_flg";
                    }
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    if(ida_ofc_cd == 'Y'){
        				InitHeadRow(1, HeadTitle1, true);
        			}
										//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,    30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "page"				    ,       false,          "",      dfNone,     0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_so_ofc_cty_cd"    ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_so_seq"           ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_so_dtl_seq"       ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "calc_cost_grp_cd"     ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo ,   120,    daCenter,  true,     "calc_tp_cd"           ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "vsl_cd"               ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "skd_voy_no"           ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "skd_dir_cd"           ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "vvd_no"           	,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo ,    80,    daCenter,  true,    "lgs_cost_cd"          ,       false,          "",       dfNone,    0,     false,       false);

					if(ida_ofc_cd == 'Y'){
		            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
		            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
		            } else {
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
		            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
		            }
					
					InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "cntr_tpsz_cd"         ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "tml_wrk_dy_cd"       	,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "dcgo_ind_cd"          ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "fm_tr_vol_val"        ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "to_tr_vol_val"        ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  false,    "tier"        			,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  false,    "acct_cd"              ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData  ,    80,    daCenter,  true,    "calc_vol_qty"         ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopup ,    80,    daCenter,  true,    "rvis_vol_qty"         ,       false,          "",       dfNone, 0,     true ,       true );

					InitDataProperty(0, cnt++ , dtCombo ,    40,    daCenter,  true,    "vol_tr_ut_cd"         ,       false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtData  ,    80,    daCenter,  true,    "ctrt_rt"              ,       false,          "",       dfFloat,   2,     true,       true);
					InitDataProperty(0, cnt++ , dtData  ,    80,    daCenter,  true,    "curr_cd"              ,       false,          "",       dfNone ,   0,     false,       false);
					InitDataProperty(0, cnt++ , dtData  ,    80,    daCenter,  true,    "inv_xch_rt"           ,       false,          "",       dfFloat,   5,     false,       false, 15);
					InitDataProperty(0, cnt++ , dtData  ,    80,    daCenter,  true,    "inv_amt"              ,       false,          "",       dfFloat,   2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  false,    "calc_amt"             ,       false,          "",       dfFloat,   2,     false,       false);
					
					if(ida_ofc_cd == 'Y'){
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_cgst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_sgst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_igst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_ugst_rto", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
		                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_gst_rto" , false, "", dfFloat, 2, false, true);
		                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_gst_amt" , false, "", dfFloat, 2, false, true);
		            } else {
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_amt", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_rto", false, "", dfFloat, 2, false, false);
		                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_amt", false, "", dfFloat, 2, false, false);  
		            }	
					
					InitDataProperty(0, cnt++ , dtData  ,   100,    daCenter,  true,    "calc_rmk"             ,       false,          "",       dfNone,    0,     true ,       true);
					InitDataProperty(0, cnt++ , dtHidden,    20,    daCenter,  false,    "semi_auto_calc_flg"   ,       false,          "",       dfNone ,   0,     true,        true);
					InitDataProperty(0, cnt++ , dtPopup ,    80,    daCenter,  true,    "n3pty_flg"            ,       false,          "",       dfNone,    0,     true ,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "io_bnd_cd"     	    ,     	false,          "",       dfNone,    0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "atb_dt"               ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "cntr_no"              ,       false,          "",       dfNone,    0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "stay_dys"             ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "free_dys"             ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "ovr_dys"              ,       false,          "",       dfNone,    0,     false,       true);
//					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_wrk_dy_cd"        ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "fp_calc_prd_cd"       ,       false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "wrk_dt"               ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "stk_vol_qty"          ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "fp_teu_qty"           ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "inv_vol_qty"          ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "diff_vol_qty"         ,       false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "ovr_vol_qty"          ,       false,          "",       dfNone,    0,     false,       true);
//					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "inv_amt"             ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "finc_vsl_finc_vsl_cd" ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "finc_skd_voy_no"      ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "finc_skd_dir_cd"      ,       false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  false,    "lgs_cost_cd2"          ,       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++ , dtHidden,    40,    daCenter,  false,    "cntr_tpsz_cd2"         ,       false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_agmt_ofc_cty_cd"   ,       false,          "",       dfNone,    0,     false,       true);                    
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_agmt_seq"      	 ,       false,          "",       dfNone,    0,     false,       true);                    
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_agmt_ver_no"       ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "curr_chk"      		 ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "rmk_chk_flg"      	 ,       false,          "",       dfNone,    0,     false,       true);


					InitDataCombo(0 , "calc_tp_cd"	, "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
					InitDataCombo(0 , "tml_wrk_dy_cd"	, tml_wrk_dy_cdCode, tml_wrk_dy_cdCode);
					InitDataCombo(0 , "dcgo_ind_cd" , dcgo_clss_cdCode, dcgo_clss_cdCode);
                    InitDataCombo(0 , "vol_tr_ut_cd", vol_tr_ut_cdCode, vol_tr_ut_cdCode);
                    InitDataCombo(0 , "lgs_cost_cd", ON_A_LGS_COST_CD, ON_A_LGS_COST_CD);
                    InitDataCombo(0 , "cntr_tpsz_cd" , CNTR_TPSZ_CD, CNTR_TPSZ_CD);
                    if(ida_ofc_cd == 'Y'){
                    	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
                    }
                    style.height = GetSheetHeight(17) ;
				}
                break;
             case 4:      //main_hidden init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 100, 2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(43, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
                    								+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
                    								+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|whld_inv_amt|inv_rjct_rmk|rtro_tml_inv_flg|ap_rvs_cng_flg|"
                    								+"dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCdtHiddenStatusDATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus  ,   30  ,    daCenter, false,    "ibflag"			     ,		 false,          "",      dfNone,      0,     false ,       true );
					InitDataProperty(0, cnt++ , dtData    ,      30,   daCenter,  false,    "sts"			     		   ,		 false,        "",      dfNone,      0,     false ,       true );
                    InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "tml_so_ofc_cty_cd"  ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "tml_so_seq"         ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "inv_ofc_cd"         ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "cost_ofc_cd"        ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       300  ,    daLeft,  false,    "inv_no"             ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "vndr_seq"           ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "yd_cd"              ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "yd_nm"              ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30   ,    daLeft,  false,    "curr_cd"            ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "ttl_inv_amt"        ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "vat_amt"            ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "ttl_calc_amt"       ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "fm_prd_dt"  	       ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "hld_flg"            ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "hld_rmk"            ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "to_prd_dt"          ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_tp_cd"      ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_cost_grp_cd"    ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_calc_ind_cd"    ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "sto_dys_ind_cd"     ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "iss_dt"             ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "rcv_dt"             ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "eff_dt"             ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "pay_due_dt"         ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "pay_flg"            ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_sts_cd"     ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_sts_nm"     ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_inv_rjct_sts_cd",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "inv_cfm_dt"         ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_agmt_ofc_cty_cd",     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_agmt_seq"       ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "tml_agmt_ver_no"    ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "whld_tax_amt"       ,     false,          "",       dfNone,         0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,       30  ,    daLeft,  false,    "inv_rjct_rmk"       ,     false,          "",       dfNone,         0,     true,      true);
					//2010.10.15 rtro_tml_inv_flg 추가
					InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "rtro_tml_inv_flg"   ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ap_rvs_cng_flg"     ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dbt_note_no", false, "", dfNone, 0, true, true);
        			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
        			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
        			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
        			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
        			
                    style.Height = GetSheetHeight(1) ;
					}
                break;
           
           
           case 5:      //hidden_sheets4_etc init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "etcData";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,    500,    daCenter,  true,    "etc_data",	 false,          "",       dfNone,    0,     true,       true);

					style.height = GetSheetHeight(3) ;
               }
                break;

        }
    }

// Sheet관련 프로세스 처리
/**
 * ibsheet1 
 * @param {ibsheet}	sheet_obj 	sheet object
 * @param {form}	formObj		from object
 * @param {String}	sAction		action value
 */
function doActionIBSheet1(sheetObj,formObj,sAction) {//alert("start doActionIBSheet1");
     sheetObj.ShowDebugMsg = false;

     switch(sAction) {
         case IBSEARCH:
			formObj.f_cmd.value = SEARCH01;
			formObj.vrfy_rslt_ind_cd.value = "CO";
			var searchXml = sheetObj.GetSearchXml("ESD_TES_0064GS.do", tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
			if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
			break;

         case IBSAVE:        //저장
  			formObj.f_cmd.value =  MULTI;
			var param = sheetObj.GetSaveString()+"&"+sheetObjects[1].GetSaveString();
			var savexml = sheetObj.GetSaveXml("ESD_TES_0064GS.do", param+'&'+tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
			if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
	         break;

         case IBINSERT:
                var Row = sheetObj.DataInsert();
                break;

         case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;
     }
}

	/**
	 * Sheet관련 프로세스 처리
	 * 
	 * @param {ibsheet}	sheet_obj 	sheet object
	 * @param {form}	formObj		from object
	 * @param {String}	sAction		action value
	 */  
    function doActionIBSheet2(sheetObj,formObj,sAction) {//alert("start doActionIBSheet2");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:
				    	formObj.f_cmd.value = SEARCH01;
				    	formObj.vrfy_rslt_ind_cd.value = "DC";
						  var searchXml = sheetObj.GetSearchXml("ESD_TES_0064GS.do", tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
					    //ComShowMessage(searchXml);
					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
						  break;

            case IBSAVE:        //저장

                break;

           case IBINSERT:
                var sRow = sheetObj.DataInsert();
				sheetObj.CellValue2(sRow,"a") = sheetObj.CellValue(sRow-1,"a");
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;
                
        	case IBSEARCH_ASYNC01:
                formObj.f_cmd.value = SEARCH11;
                var param = sheetObj.GetSaveString(true,false);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0064GS.do", param+'&'+tesFrmQryStr(formObj),"",true);
                sheetObj.RemoveAll();
        		if (searchXml!=null && searchXml!='') sheetObj.LoadSearchXml(searchXml);
        		break;		                      
        }
    }

// Sheet관련 프로세스 처리
/**
 * @param {ibsheet}	sheet_obj 	sheet object
 * @param {form}	formObj		from object
 * @param {String}	sAction		action value
 */
function doActionIBSheet3(sheetObj,formObj,sAction) {//alert("start doActionIBSheet3");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:
                formObj.f_cmd.value = SEARCH02;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0064GS.do", tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
                if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSAVE:        //저장
                formObj.f_cmd.value =  MULTI01;
                var param = sheetObj.GetSaveString() ;
                var savexml = sheetObj.GetSaveXml("ESD_TES_0064GS.do", param+'&'+tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
                if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
                break;

            case IBDELETE:       // TES_TML_SO_DTL, TES_TML_SO_RVIS_LIST, TES_N3RD_PTY_IF 데이타 삭제
                formObj.f_cmd.value = REMOVE01;
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0064GS.do", tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
                sheetObj.LoadSaveXml(saveXml, true);

                break;

        }
}
    
/**
  * Sheet관련 프로세스 처리
  * @param {ibsheet}	sheet_obj 	sheet object
  * @param {form}	formObj		from object
  * @param {String}	sAction		action value
 */
function doActionIBSheet_main(sheetObj,formObj,sAction) {//alert("start doActionIBSheet_main");
     sheetObj.ShowDebugMsg = false;

     switch(sAction) {

        case IBSEARCH:
			 formObj.f_cmd.value = SEARCH;
			 var searchXml = sheetObj.GetSearchXml("ESD_TES_0064GS.do", tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
 		     if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
			 break;
			 
        case IBSAVE:        //저장
             if(formObj.tml_so_seq.value == null || formObj.tml_so_seq.value ==""){
			       formObj.f_cmd.value = ADD;
             }else{
			       formObj.f_cmd.value = MODIFY;
             }
		         
			 var param = sheetObj.GetSaveString();
		     var savexml = sheetObj.GetSaveXml("ESD_TES_0064GS.do", param+'&'+tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
			 sheetObj.LoadSaveXml(savexml,true);
			 break;

	 }
}
    

/**
 * hidden_sheets4_etc 관련 프로세스처리
 * @param {ibsheet}	sheet_obj 	sheet object
 * @param {form}	formObj		from object
 * @param {String}	sAction		action value
*/
function doActionIBSheet_hidden_sheets4_etc(sheetObj,formObj,sAction) {
  	sheetObj.ShowDebugMsg = false;
    switch(sAction) {
		 case IBSEARCH_ASYNC01:      //조회
	           	
			 formObj.f_cmd.value = SEARCH10;
			 var searchXml = sheetObj.GetSearchXml("ESD_TES_0064GS.do", tesFrmQryStr(formObj,'calcOnDockComboItems|tmp_common_code|cntrTpszComboItems'));
			 if(searchXml != ""){
			      sheetObj.LoadSearchXml(searchXml,true);
			 }

			 break;
    }
}


    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {tabObject}	tab_obj		tab object
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


/** 
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 * @param {tabObject}	tabObj		tab object
 * @param {tabNo}		tabNo		tab number
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++ , "Coincidence" , -1 );
                InsertTab( cnt++ , "Discrepancy" , -1 );
                InsertTab( cnt++ , "Cost Calculation" , -1 );
            }
         break;

     }
}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * @param {tabObject}	tabObj		tab object
     * @param {String}		nItem		item     
     */
    function tab1_OnChange(tabObj , nItem)
    {
		var formObj = document.form;
		var objs 	= document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;

 	}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
   function tab1_OnClick(tabObj , tabNo)
    {
    	var formObj = document.form;
			if(save_conf_01){
				//ComShowMessage("tab1_OnClick nItem:"+tabNo);

				switch(tabNo) {

				}
			}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

/**
* Component 초기화 함수
* Component의 활성여부를 초기화한다.
* @param {String}	sFlag		flag Value
*/
function setInitComponent(sFlag) {
  	var formObj = document.form;
   	var flag_value = false;
  	if(sFlag == "Y"){
  	   flag_value = true;
  	} else {
  	   flag_value = false;
  	}

	for (var e = 0; e < formObj.elements.length; e++) {
    	var el = formObj.elements[e];
    	ComEnableObject(el, false);
    }

	if(sFlag == "Y"){ //2010.10.15 rtro_tml_inv_flg 추가
  		ComEnableManyObjects(true, formObj.yd_cd, formObj.cost_ofc_cd,
  									formObj.ttl_inv_amt, formObj.iss_dt, 
  									formObj.vat_amt, formObj.rcv_dt, 
  									formObj.hld_flg, formObj.err_inv_no, 
  									formObj.rtro_tml_inv_flg,
  									formObj.rowsadd 
  									);
  		if(whld_tax_readonly_mode == false){
  			ComEnableObject(formObj.whld_tax_amt, false);
		}
  		
  		if(conti_cd=="E" || ida_ofc_cd == 'Y') ComEnableObject(formObj.ap_rvs_cng_flg, true);
  		
  		if(ida_ofc_cd == 'Y'){
     	   ComEnableManyObjects(true, formObj.dbt_note_no, formObj.ida_cgst_amt, formObj.ida_sgst_amt, formObj.ida_igst_amt, formObj.ida_ugst_amt);
        }
  	}
  	
  	ComEnableManyObjects(true, formObj.vndr_seq, formObj.inv_no);
  	formObj.cost_ofc_cd	.readOnly = true;

  	tabObjects[0].Enable   = flag_value;
  	sheetObjects[0].Editable = flag_value;
  	sheetObjects[1].Editable = flag_value;
  	sheetObjects[2].Editable = flag_value;
}

	/**
     * Search시 필수요소 체크함수
     * retrieve시 필수조건항목을 체크한다.
     * @param {form}	formObj		form object
     */

	function fnChkSearchForm(formObj){
		if(!fnChkEmptyObj(formObj.vndr_seq)) return false;
		if(!fnChkEmptyObj(formObj.inv_no)) return false;
		
		return true;
	}


/**
 * 단일 Object Validation
 *
 * @param  obj    - validation할 object
 * 예 : fnChkEmptyObj(obj)
 * 해당 object에 desc= ""를 기술해놓는다.
 */
 	function fnChkEmptyObj(obj){
		if (obj.type == "text" || obj.type == "textarea" ||
		    obj.type == "password" || obj.type == "file" ) {
		  if (obj.value == null || obj.value == '') {
		    ComShowMessage(ComGetMsg('TES21026',obj.desc)); //값이 입력되지 않았습니다.
		    obj.focus();
		    return false;
		  }
		}

		else if (obj.type.indexOf('select') != -1) {
		  if (obj.selectedIndex == -1) {
		    ComShowMessage(ComGetMsg('TES21027',obj.desc));  //값이 선택되지 않았습니다.
			  obj.focus();
		    return false;
		  }
		}
		else if (obj.type == 'radio') {
		  var group = formObj[obj.name];
		  var checked = false;
		  if (!group.length)
		    checked = obj.checked;
		  else
		    for (var r = 0; r < group.length; r++)
		      if ((checked = group[r].checked))
		        break;
		  if (!checked) {
		    ComShowMessage(ComGetMsg('TES21027'),obj.desc);  //값이 선택되지 않았습니다.
		    obj.focus();
		    return false;
		  }
		}
		else if (obj.type == 'checkbox') {
		  var group = formObj[obj.name];
		  if (group.length) {
		    var checked = false;
		    for (var r = 0; r < group.length; r++)
		      if ((checked = group[r].checked))
		        break;
		    if (!checked) {
		      ComShowMessage(ComGetMsg('TES21027',obj.desc));  //값이 선택되지 않았습니다.
		      obj.focus();
		      return false;
		    }
		  }
		}

		return true;
	}

/**
 * 필수입력 Form Validation
 *
 * @param : obj    - validation할 object
 * 예 : validChkForm(formObj)
 *      해당 object에 valid="1"  desc= ""를 기술해놓는다.
 */
	function validChkForm(formObj){
		for (var e = 0; e < formObj.elements.length; e++) {
    var el = formObj.elements[e];
    	if(el.valid == '1'){
    		if(!fnChkEmptyObj(el)) return false;
		  }
  	}

  	return true;
	}

    /**
     * Object값의 Number여부 확인함수
     * Object값의 Number여부를 확인한다.
     * @param {object}	obj		object	 
     */

	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}

    /**
     * Object값의 Alpabat,Number여부 확인함수
     * Object값의  Alpabat,Number여부를 확인한다.
     * @param {object}	obj		object
     */
	function isApNum(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,"n")){
			obj.value = '';
		}
	}

	/* 설명 : Yard값을 Popup에서 가져오는 함수
	 * 사용 :
	 * @param {String}	rowArray	row 배열	 
	 */
	function getYard(rowArray) {
		var colArray = rowArray[0];
		document.all.yd_cd.value = colArray[3];
		document.all.yd_nm.value = colArray[4];
		document.all.yd_cd_hidden.value = colArray[3];

		if (colArray[3]!=undefined && colArray[3]!=null && colArray[3].trim()!='')
		{
			//checkValidYardCode()에서 yd_cd가 있다면 MDM_YARD의 OFC_CD를 가져와서 넣어준다.
			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
			checkYdCd(colArray[3]);
		}

		//document.all.cost_ofc_cd .class 		= "noinput1";
		document.all.cost_ofc_cd	.readOnly = false;
	}

	/* 설명 : CostOfc를 Edit가능하게하는 함수
	 * 사용 :
	 */
	function setCostOfcReadOnlyFalse(){
		var formObj = document.form;
		formObj.cost_ofc_cd.readOnly = false;
		if (formObj.cost_ofc_cd.value!=null && formObj.cost_ofc_cd.value.trim()!=''){
			formObj.cost_ofc_hidden.value = formObj.cost_ofc_cd.value;
		}
//		ComShowMessage(formObj.cost_ofc_hidden.value);
	}

	/* 설명 : CostOfc Validation하는 함수
	 * 사용 :
	 */
//	function checkValidCostOfc(){
//		var formObj = document.form;
//		if (formObj.is_valid_cost_ofc.value!=null && formObj.is_valid_cost_ofc.value=='Y'){
//			formObj.cost_ofc_hidden.value = formObj.cost_ofc_cd.value;
//		} else {
//			formObj.cost_ofc_hidden.value = '';
//			ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
//			formObj.cost_ofc_cd.value = '';
//		}
//	}

	/**
	 * 	cost ofc code valid 검사
	 */ 
	function checkValidCostOfc(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_cost_ofc_cd.value!=undefined && formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value.trim()!=''){
			tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_cost_ofc_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value == 'Y'){
					if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
						if (tmp[1].trim()!='Y'){
							ComShowMessage(ComGetMsg('TES21036')); //ComShowMessage('CostOFC와 불일치하는 Yard Code입니다.');
							//formObj.yd_cd.focus();
						}
					} else {
						ComShowMessage(ComGetMsg('TES21037')); //ComShowMessage('CostOFC의 해당 Yard Code를 확인하는중 오류가 발생했습니다.');
						return false;
					}
				} else {
					formObj.is_valid_cost_ofc_cd.value = '';
					ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
					return false;
				}
			} else {
				formObj.is_valid_cost_ofc_cd.value = '';
				ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
				return false;
			}
		} else {
			formObj.is_valid_cost_ofc_cd.value = '';
			ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
			return false;
		}
	}

	/* 설명 : OfcCd값을 Popup에서 가져오는 함수
	 * 사용 :
	 * @param {String}	rowArray	row 배열	  	 
	 */
	function getOfcCd(rowArray) {
		var colArray = rowArray[0];
		document.all.cost_ofc_cd.value = (colArray[3]!=undefined&&colArray[3]!=null?colArray[3]:'');
	}


	/* 설명 : YardCode Validation 함수
	 * 사용 :
	 */
	function checkValidYardCode(){
		var formObj = document.form;
		var tmp_yd_cd_hidden;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('--');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd						.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value !=null && formObj.is_valid_yd_cd.value == 'Y'){
					//ComShowMessage('yd_cd_hidden:' + formObj.yd_cd_hidden.value + '\nyd_cd:' + formObj.yd_cd.value);
					if (formObj.yd_cd.value!=null && formObj.yd_cd.value.trim()!='' && formObj.yd_cd_hidden.value!=formObj.yd_cd.value)
					{
						if (sheetObjects[3].RowCount > 0 &&
								formObj.yd_cd.value.trim()!=sheetObjects[3].CellValue(1,'yd_cd').trim() &&
							(sheetObjects[0].RowCount > 0 || sheetObjects[2].RowCount > 0))
						{
							if (!confirm(ComGetMsg('TES40027')))    //'Yard Code가 변경되었습니다. \n\n Coincidence, Discrepancy, Cost Calc. Tab의 모든 Data를 삭제할까요?'greement에 등록된 currency code인
							{
								formObj.yd_cd.value = formObj.yd_cd_hidden.value;
								return false;
							} else {
								//ComShowMessage('sheet들 다 지우고, yd, cost_ofc, calcStorageComboItems 수정하기');
								if(deleteContanerList()) gridSave();
							}
						}
					}

					tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
					formObj.yd_cd_hidden						.value	= formObj.yd_cd.value;
					formObj.yd_nm										.value	= (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.yd_chr_cd								.value	= (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
					formObj.yd_fcty_tp_mrn_tml_flg	.value	= (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
					formObj.yd_fcty_tp_cy_flg				.value	= (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
					formObj.yd_fcty_tp_cfs_flg			.value	= (tmp[6]!=undefined&&tmp[6]!=null?tmp[6]:'');
					formObj.yd_fcty_tp_rail_rmp_flg	.value	= (tmp[7]!=undefined&&tmp[7]!=null?tmp[7]:'');
					formObj.yd_oshp_cd							.value	= (tmp[8]!=undefined&&tmp[8]!=null?tmp[8]:'');
					formObj.calcOnDockComboItems  	.value	= (tmp[10]!=undefined&&tmp[10]!=null?tmp[10]:'');
					formObj.calcOnDockComboItemsDesc.value	= (tmp[15]!=undefined&&tmp[15]!=null?tmp[15]:'');

					if((formObj.tml_so_ofc_cty_cd.value == '' && formObj.tml_so_seq.value == '')
                     ||formObj.yd_cd.value != tmp_yd_cd_hidden
                     ||formObj.cost_ofc_hidden.value != formObj.cost_ofc_cd.value)
                    {
                        tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse');
                    }else{
                        setCostOfcReadOnlyFalse();
                    }

					if (sheetObjects[2].RowCount > 0)	{
						setCalcOnDocklManualCostCode(sheetObjects[2]);
					}

				} else {
					ComShowMessage(ComGetMsg('TES21039')); //ComShowMessage('유효하지 않은 YardCode입니다.');
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden	.value = '';
					formObj.yd_nm					.value = '';
					//formObj.yd_cd					.value = '';
					formObj.yd_cd					.focus();
				}
			} else {
				ComShowMessage(ComGetMsg('TES21039')); //ComShowMessage('유효하지 않은 YardCode입니다.');
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden	.value = '';
				formObj.yd_nm					.value = '';
				//formObj.yd_cd					.value = '';
				formObj.yd_cd					.focus();
			}
		} else {
			ComShowMessage(ComGetMsg('TES21039')); //ComShowMessage('유효하지 않은 YardCode입니다.');
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden	.value = '';
			formObj.yd_nm					.value = '';
			//formObj.yd_cd					.value = '';
			formObj.yd_cd					.focus();

		}
	}

	/* 설명  : VndrCode Validation 함수
	 * 사용  :
	 */
	function checkValidVndrCode(){
		//ComShowMessage("checkValidVndrCode");
		var formObj = document.form;
		var tmp = '';
//		ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_nm.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.ida_gst_rgst_ste.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.ida_gst_rgst_no.value = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
					formObj.ida_ste_cd.value = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
					formObj.ida_ste_nm.value = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq					.focus();
				}
			} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq					.focus();
			}
		} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.focus();
		}
	}

	/* 설명 : Grid에서 Vender Pop으로 값을 가져오는 함수
	 * 사용 :
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		//ComShowMessage(colArray);
		document.all.vndr_seq.value = colArray[2];
		document.all.vndr_seq_nm.value = colArray[4];
		
		var idaGstRgstSte = colArray[10];
		if(idaGstRgstSte == 'R'){
			document.all.ida_gst_rgst_ste.value = "Registered";
		} else if(idaGstRgstSte == 'U') {
			document.all.ida_gst_rgst_ste.value = "Unregistered";
		} else if(idaGstRgstSte == 'C') {
			document.all.ida_gst_rgst_ste.value = "Composite";
		}
		
		document.all.ida_gst_rgst_no.value=colArray[11];
		document.all.ida_ste_cd.value=colArray[12];
		document.all.ida_ste_nm.value=colArray[13];
	}
/*
	function deleteComma(src){
		//ComShowMessage("deleteComma");
		// comma를 제거
		var src = String(src);
		if (src==null || trim(src)==''){
			return '';
		}
		return src.replace(/,/gi,'');
	}
*/
	/**
	 * comma를 3자리마다 끼워넣기하는 함수
	 * @param {String} src		문자열	
	 */
	function addComma2(src){
		// comma를 3자리마다 끼워넣기
		var src = new String(src);
		if (src==null || trim(src)==''){
			return '';
		}
		var re = /(-?\d+)(\d{3})/;
		while (re.test(src)) {
			src = src.replace(re, "$1,$2");
		}
		return  src;
	}

	/**
	 * 입력값이 숫자인지 Validation하는 함수
	 *
	 */
	function checkNumber(){
    var objEv = event.srcElement;
    var numPattern = /([^0-9])/;
    numPattern = objEv.value.match(numPattern);
    if(numPattern != null){
        ComShowMessage(ComGetMsg('TES21041')); //ComShowMessage("숫자만 입력해 주세요!");
        objEv.value="";
        objEv.focus();
        return false;
    }
	}


	/**
	 * Reject 버튼에대한  함수
	 *
	 */
function rjctInv() { //reject한다
	var formObj = document.form;

	formObj.tml_inv_rjct_sts_cd.value = 'RJ';
	invHeaderSave(sheetObjects[3],formObj);
	retrieveEvent(sheetObjects[3], formObj);
	
}


	/**
	 * Invoice No입력시 해당 Invoice Data를 조회하는 함수
	 *
	 */
	function onKeyInvNoEnvent(){
		 var formObj = document.form;
		retrieveEvent(sheetObjects[3],formObj);
	}


	/**
	 * 입력된 CostOFC값을 Validation하는 함수
	 *
	 */
	function validateCostOFC() {
		var formObj = document.form;
		if (formObj.cost_ofc_cd.readOnly==false){
			if ((formObj.cost_ofc_hidden.value==null || formObj.cost_ofc_hidden.value.trim()=='') || formObj.cost_ofc_cd.value!=formObj.cost_ofc_hidden.value)
			{
				tes_getInputValue('is_valid_cost_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidCostOfc');
			}
		}
	}

	/**
	 * 입력된 YardCode값을 Validation하는 함수
	 *
	 */
	function validateYardCode() {
		var formObj = document.form;
		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim()=='')
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			return false;
		}
		if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim())
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
			checkYdCd(document.form.yd_cd.value);
		}
	}

	/**
	 * 입력된 vndr_seq값을 Validation하는 함수
	 *
	 */
	function validateVndrSeq() {
		var formObj = document.form;
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()=='')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}




	/**
	 * 입력된 수에 소수점 아래를 len만큼 채워주는 함수(OBJECT).
	 * @param {object}	obj		object
	 * @param {int}		len		length
	 */
  function addDot(obj,len){
  		var tem_val = 0;
  		var strLen = 0;
  	  tem_val = obj.value;
 			obj.value = (tem_val==0?"0.00":tem_val);
			if(obj.value.indexOf(".") == -1)	strLen = 0;
			else															strLen = tes_getStrLen(obj.value.substr(obj.value.indexOf(".")+1,tes_getStrLen(obj.value)));
			if(strLen > len){
				obj.value = obj.value.substr(0, obj.value.indexOf(".")+len+1);
			}

  }

	/**
	 * 입력된 수에 소수점 아래를 len만큼 채워주는 함수.
	 * @param {object}	obj		object
	 * @param {int}		len		length
	 */
    function addDot2(src,len){
  	var tem_val = 0;
  	  tem_val = src;
 			src = (tem_val==0?"0.00":tem_val);
			if(src.indexOf(".") == -1)	src += ".";
			var strLen = tes_getStrLen(src.substr(src.indexOf(".")+1,tes_getStrLen(src)));
			if(strLen < len){
				for(var i=0; i< (len-strLen); i++){
					src += "0";
				}
			}else if(strLen > len){
				src = src.substr(0, src.indexOf(".")+len+1);
			}
			return src;
  }

/*
* Header Data 저장하는 함수
* @param {ibsheet}	sheetObject_main	ib sheet
* @param {form}		formObj				form object
*/
function invHeaderSave(sheetObject_main,formObj){//alert("start invHeaderSave");
     validChkForm(formObj);
	 setForm2HdSheet(sheetObject_main);
	 doActionIBSheet_main(sheetObject_main,formObj,IBSAVE);
	 onSaveEnd(sheetObject_main);
}

  /*
   * Sheet Save 끝난후 발생하는 Event처리 함수
   * @param {ibsheet}	sheetObj
   */
  function onSaveEnd(sheetObj) {
		if (sheetObj.RowCount == 1){
			setHdSheet2Form(sheetObj);
		} else if (sheetObj.RowCount > 1){
			ComShowMessage(ComGetMsg('TES21032')); //ComShowMessage('[ERR] 복수개의 header data가 조회되었습니다.');
			return;
		} else {
			//setHeaderKeyValueReadonly('N');
			///setSheetsEnable(0, false, false, false, false, false);
			ComShowMessage(ComGetMsg('TES21034')); //ComShowMessage('저장된 data가 없습니다.');
			return;
		}
	}


	/**
	 * 해당 Sheet Click Event발생시 실행하는 함수.
	 *
	 */
	function t1sheet1_OnClick(t1sheet1, row, col){
			var formObj = document.form;
			formObj.temp_val.value = "";

			if(t1sheet1.ColSaveName(col) == "cntr_sty_cd"){
				formObj.temp_val.value = t1sheet1.CellValue(row, "cntr_sty_cd");
			}else if (t1sheet1.ColSaveName(col) == "dcgo_clss_cd"){  //cjlick 여부만 확인
				formObj.temp_val.value = "Y";
			}
			
			if(t1sheet1.ColSaveName(col) == "chk" && t1sheet1.CellValue(row,'dscr_ind_cd')!='CO' && t1sheet1.CellEditable(row, "chk")==false){
				t1sheet1.CellEditable(row, "chk")  = true;
				if(t1sheet1.CellValue(row,"chk")==1){
					t1sheet1.CellValue2(row,"chk")=0;
				}else{
					t1sheet1.CellValue2(row,"chk")=1;
				}
			}
	}

/**
* vvd_no별 Auto Calculated List를 Clear하는 함수.
*
*/
function clearCalcList(){
	 var formObj = document.form;
	 var confirm_value = false;
	 if(formObj.temp_val.value.length > 0){ //onClick 이벤트 발생으로 인한 onChange임을 확인
		  confirm_value = confirm(ComGetMsg('TES23070')); //"TES23070Clacuration List의  Auto Calculated Cost Data가 Clear됩니다.수정하겠습니까? ");
			  if(confirm_value){
				  for(var i=sheetObjects[2].HeaderRows;i < sheetObjects[2].HeaderRows + sheetObjects[2].RowCount; i++){
					  if(sheetObjects[2].CellValue(i, "calc_tp_cd") == "A" ){
						  
							sheetObjects[2].RowStatus(i) = "D";
						   	i--;

				       }
			      }
		     }

	 }
	 return confirm_value;

}

	/**
	 * 해당 Sheet에서 Change Event발생시 동작하는 함수.
	 *
	 */
	var change_count = 0;
	function t1sheet1_OnChange(t1sheet1, row, col){
			var formObj = document.form;
			if(formObj.temp_val.value.length > 0){ //onClick 이벤트 발생으로 인한 onChange임을 확인
				change_count++;
			}
			//수정시 Clacuration List 데이터 Clear Logic
			if(change_count == 1){
					clearCalcList();
					recalc_val == "N";
			}

			if (t1sheet1.ColSaveName(col) == "cntr_sty_cd"){

			}else if (t1sheet1.ColSaveName(col) == "dcgo_clss_cd"){

			}

	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function t1sheet1_OnLoadFinish(sheetObj){
		 var formObj		 = document.form;
	 	var max_wrk_dt = "";
	 	var min_wrk_dt = "";

		max_wrk_dt = sheetObj.CellValue(sheetObj.HeaderRows, "wrk_dt") ;
	 	min_wrk_dt = sheetObj.CellValue(sheetObj.HeaderRows, "wrk_dt") ;

	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
	 		if(max_wrk_dt < sheetObj.CellValue(i, "wrk_dt"))  max_wrk_dt =sheetObj.CellValue(i, "wrk_dt");
	 		if(min_wrk_dt > sheetObj.CellValue(i, "wrk_dt"))  min_wrk_dt =sheetObj.CellValue(i, "wrk_dt");

			if(sheetObj.CellValue(i, "modi_flg") == "Y"){
				sheetObj.CellEditable(i, "chk")  = true;

			}
			if(formObj.tml_inv_sts_cd.value == "R" && (formObj.tml_inv_rjct_sts_cd.value == "NL" || formObj.tml_inv_rjct_sts_cd.value == "RL")){
				sheetObj.CellEditable(i,"cntr_sty_cd"		  ) = true;
				sheetObj.CellEditable(i,"dcgo_clss_cd"		) = true;
			}

			if(sheetObj.CellValue(i,"dscr_dtl_ind_cd") == "F"){
				sheetObj.CellBackColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
				sheetObj.CellFontColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
			}else if(sheetObj.CellValue(i,"dscr_dtl_ind_cd") == "T"){
				sheetObj.CellBackColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
				sheetObj.CellFontColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
			}

			if(sheetObj.CellValue(i,'dscr_ind_cd')=='CO'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Coincidence';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='HO'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'SML List only';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='HD'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'SML List double';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='NH'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Not in SML source';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='DB'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Double billing';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='DD'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Discrepancy by detail data';
			}


		}
		document.form.max_wrk_dt.value  = max_wrk_dt;
	 	document.form.min_wrk_dt.value  = min_wrk_dt;
		sumaryContainerList(sheetObj);
		validateYardCode();
	 }

	/**
	 * 해당 Sheet에서 LoadFinish Event발생시 동작하는 함수.
	 *
	 */
	function t2sheet1_OnLoadFinish(sheetObj){
		 var formObj		 = document.form;

	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
			if(formObj.tml_inv_sts_cd.value == "R" && (formObj.tml_inv_rjct_sts_cd.value == "NL" || formObj.tml_inv_rjct_sts_cd.value == "RL")){
				//sheetObj.CellEditable(i,"cntr_sty_cd"		  ) = true;
				sheetObj.CellEditable(i,"dcgo_clss_cd"		) = true;
			}

			if(sheetObj.CellValue(i,"dscr_dtl_ind_cd") == "F"){
				sheetObj.CellBackColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
				sheetObj.CellFontColor(i, "cntr_sty_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
			}else if(sheetObj.CellValue(i,"dscr_dtl_ind_cd") == "T"){
				sheetObj.CellBackColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 255, 102); //노란색 바탕
				sheetObj.CellFontColor(i, "cntr_tpsz_cd") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
			}

			// 미주지역에서(YARD 시작 2자리가 US 임 경우)는 HD, DB는 COINCIDENCE로 옮기기 못하도록 수정
			// COL 용성욱 차장 요청사항        - 2008.03.02 BY JJ KIM
			// 2017.06.29 옮길수 있도록 주석처리 
//			if(document.form.yd_cd.value.substring(0,2) == 'US' && (sheetObj.CellValue(i,'dscr_ind_cd') == 'HD'||sheetObj.CellValue(i,'dscr_ind_cd') == 'DB')){
//			    sheetObj.CellEditable(i, 'chk')  = false;
//			}





		}
	}
	/**
	 * 해당 Sheet에서 LoadFinish Event발생시 동작하는 함수.
	 *
	 */
	function t3sheet1_OnLoadFinish(sheetObj){
		 var formObj = document.form;
	 	var tot_amt		 = 0;
		if (sheetObj.RowCount > 0){
			setCalcOnDocklManualCostCode(sheetObj,'Y');
		 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){

				if (sheetObj.CellValue(i,'calc_tp_cd') == 'M' || sheetObj.CellValue(i,'calc_tp_cd') == 'S'){
		 			sheetObj.InitCellProperty(i, "rvis_vol_qty", dtData);
				}else{
                    //AutoCalc 부분에서만 Wrk_dt를 사용하므로. calc_tp_cd가 M이 아닌 경우에 한해 max/min wrk_dt를 구하도록 수정. 2007.02.14
//    		 		if(max_wrk_dt < sheetObj.CellValue(i, "wrk_dt"))  max_wrk_dt =sheetObj.CellValue(i, "wrk_dt");
//    		 		if(min_wrk_dt > sheetObj.CellValue(i, "wrk_dt"))  min_wrk_dt =sheetObj.CellValue(i, "wrk_dt");
				}


		 		if(sheetObj.CellValue(i, "tml_so_dtl_seq") == "0"){
		 		 	sheetObj.RowStatus(i) = "I";
		 		}else{
		 			sheetObj.RowStatus(i) = "R";

				}

				if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='WD'){
    			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Week day';
    			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='SA'){
    			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Saturday';
    			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='SU'){
    			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Sunday';
    			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='HO'){
    			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Holiday';
    			}

    			if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='C'){
    			    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Container';
    			}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='T'){
    			    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'TEU';
    			 // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
    			}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='B'){
    			    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'BOX';
    			}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='M'){
    			    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Move';
    			}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='G'){
    			    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Gang/Hour';
    			} else if (sheetObj.CellValue(i, 'vol_tr_ut_cd') == 'W' ) {
    				sheetObj.ToolTipText(i, 'vol_tr_ut_cd') = 'Metric Ton';
    			}
			}
				calcurationTotalAmt(sheetObj,formObj);

		}

	}

		/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function t1sheet1_OnSearchEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}

	}
	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function t2sheet1_OnSearchEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
		
		if(document.form.f_cmd.value==SEARCH11){
			retrieveEvent(sheetObjects[3],document.form);
		}	

	}	

		/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function t3sheet1_OnSearchEnd(sheetObj,errMsg){//alert("start t3sheet1_OnSearchEnd");
	    var formObj = document.form;
		var tmp_cnt = 0;

	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		  sheetObj.CellComboItem(i, 'cntr_tpsz_cd' , document.form.cntrTpszComboItems		.value,  document.form.cntrTpszComboItems			.value);
			sheetObj.CellValue2(i,"lgs_cost_cd"		) = sheetObj.CellValue(i,"lgs_cost_cd2"		);
			sheetObj.CellValue2(i,"cntr_tpsz_cd"	) = sheetObj.CellValue(i,"cntr_tpsz_cd2"	);

			if(sheetObj.CellValue(i,'calc_tp_cd')=='M'){
			  	setShtCellsEditable(sheetObj,i,"lgs_cost_cd|cntr_tpsz_cd|tml_wrk_dy_cd|dcgo_ind_cd|rvis_vol_qty|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt",'Y');
			}
			
			if(sheetObj.CellValue(i,'calc_tp_cd')=='S'){
//			  	setShtCellsEditable(sheetObj,i,"lgs_cost_cd|cntr_tpsz_cd|tml_wrk_dy_cd|dcgo_ind_cd|rvis_vol_qty|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt",'Y');
				setShtCellsEditable(sheetObj, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y', "EXCEPTION");
				setShtCellsEditable(sheetObj, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");     
			}

			//SO Header의 Currency와 AGMT상의 Currency가 다른경우 Exchange Rate 입력 활성화
            if(formObj.curr_cd.Code != sheetObj.CellValue(i,'curr_cd') && sheetObj.CellValue(i,'curr_cd')!=''){
                setShtCellsEditable(sheetObj,i,'inv_xch_rt','Y','EXCEPTION');
            }
		}

	 	calcurationTotalGstAmt(sheetObj,formObj);
	}

		/**
	 * Cost Calculation에서 필요한 Combo Code를 setting하는 함수
	 *
	 */
	function setCalcOnDocklManualCostCode(sheet,INIT){
		var formObj = document.form;
		for (var i=sheet.HeaderRows; i<sheet.HeaderRows + sheet.RowCount; i++){

			if (sheet.CellValue(i,'calc_tp_cd') == 'M' || sheet.CellValue(i,'calc_tp_cd') == 'S'){
				org_sts = sheet.RowStatus(i);
				sheet.CellComboItem(i, 'lgs_cost_cd'	, formObj.calcOnDockComboItemsDesc.value, formObj.calcOnDockComboItems.value);
				sheet.CellComboItem(i, 'cntr_tpsz_cd'	, formObj.cntrTpszComboItems		.value, formObj.cntrTpszComboItems		.value);
				sheet.CellValue2(i,'lgs_cost_cd') = sheet.CellValue(i,'lgs_cost_cd2');
				sheet.CellValue2(i,'cntr_tpsz_cd') = sheet.CellValue(i,'cntr_tpsz_cd2');
				sheet.RowStatus(i) = org_sts;
			}
		}
	}


	/**
	 * 
	 * @param sheetObj
	 * @return
	 */ 
	function isOnDockInvoice(sheetObj){
        if (sheetObj.RowCount == 1){
            if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "TM"){
                ComShowMessage(ComGetMsg('TES22026')); //ComShowMessage("Marine Terminal Invoice와 중복됩니다.");
                setInitComponent("N");
                return false;
            }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "OF"){
                ComShowMessage(ComGetMsg('TES21030')); //ComShowMessage("Off Dock Cy Invoice와 중복됩니다.");
                setInitComponent("N");
                return false;
            }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "ST"){
                ComShowMessage(ComGetMsg('TES21031')); //ComShowMessage("Marine Terminal Storage Invoice와 중복됩니다.");
                setInitComponent("N");
                return false;
            }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "ON"){
                return true;
    		}
        }
    }

/**
* Sheet조회가 끝낫을때  공통처리하는 함수
*
*/
function main_hidden_OnSearchEnd(sheetObj){//alert("main_hidden_OnSearchEnd ===========");
	var formObj = document.form;
	retrieve_conf_01 = true;
	if (sheetObj.RowCount == 1){
		if(isOnDockInvoice(sheetObj)==false){
			return false;
		}

        if(formObj.inv_ofc_cd.value == '' || formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value == undefined){
		     ComShowMessage('No Inv OFC data is found in the session');
		     return false;
		}
		    
		if(formObj.inv_ofc_cd.value != sheetObj.CellValue(1,'inv_ofc_cd')){
		     ComShowMessage("No authority to correct/delete the invoice - Invoice office mismatch!");
		     return false;
		}

        save_conf_01 = true; //상위 기본 정보 저장이 확인된 경우만 활성화
		//검색된 sheet의 data로 form을 채운다.
		setHdSheet2Form(sheetObj);
		
        if(document.form.tml_so_ofc_cty_cd.value != null || document.form.tml_so_ofc_cty_cd.value != "" ||
		   document.form.tml_so_seq.value != null || document.form.tml_so_seq.value != "" ||
			(document.form.tml_inv_rjct_sts_cd.value != "RJ" && document.form.tml_inv_sts_cd.value != "R")||   // Received & Rejected
			 document.form.tml_inv_sts_cd.value != "A"  || document.form.tml_inv_sts_cd.value != "P"){
			    
			     if(sheetObj.CellValue(1, 'tml_inv_sts_cd') == "C"){
					 var confirm_value = confirm(ComGetMsg('TES22029'));//" Confirmed Invoice 입니다. 수정하시겠습니까?"
					 if(confirm_value){
						 if(document.form.tml_inv_rjct_sts_cd.value == "RJ"){
							 document.form.tml_inv_rjct_sts_cd.value = "RL";
						 }
						document.form.tml_inv_sts_cd.value = "R";
						invHeaderSave(sheetObj,document.form);
						sheetObj.RemoveAll();
						doActionIBSheet_main(sheetObj, formObj, IBSEARCH);
						setInitComponent("Y");
						sheetObjects[0].Editable = true;
                        sheetObjects[1].Editable = true;
                        sheetObjects[2].Editable = true;
					 }else{
						 setInitComponent("N");
						 return false;
					 }
				}else{
					 setInitComponent("Y");
					 sheetObjects[0].Editable = true;
                     sheetObjects[1].Editable = true;
                     sheetObjects[2].Editable = true;
				}																												// AP Interfased

			}else {
				alert(1);
				setInitComponent("Y");
				sheetObjects[0].Editable = true;
                sheetObjects[1].Editable = true;
                sheetObjects[2].Editable = true;
                ComEnableManyObjects(false, formObj.vndr_seq, formObj.inv_no);
				 return false;
			}


			if (document.form.yd_cd.value!=null && document.form.yd_cd.value.trim()!=''){
				// <주> setHdSheet2Form()가 반드시 먼저 실행이 되어서 main_hidden의 결과가 form에 다 반영되어야 yd_cd를 가지고 조회가 가능 한다.
				tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
				checkYdCd(document.form.yd_cd.value);
			}

            doActionIBSheet_hidden_sheets4_etc(sheetObjects[4], formObj, IBSEARCH_ASYNC01);
            var tpszCodeValue = sheetObjects[4].EtcData("tpszCode");
            var costCodeValue = sheetObjects[4].EtcData("costCode");
              
            for(p=1;p< comboObjects.length;p++){
              	initCombo (comboObjects[p],p+1, "","", tpszCodeValue);
            }
            
            sheetEtcDataToForm(document.form, sheetObjects[4]);

            //COIN - 조회
			doActionIBSheet1(sheetObjects[0],formObj,IBSEARCH);
			t1sheet1_OnLoadFinish(sheetObjects[0]);
			//DSCP - 조회
			doActionIBSheet2(sheetObjects[1],formObj,IBSEARCH);
			t2sheet1_OnLoadFinish(sheetObjects[1]);
			
			sheetObjects[2].RemoveAll();

			formObj.cost_calc_mode.value = "R";
			
			//CostCalc(On-Dock) - 조회
			doActionIBSheet3(sheetObjects[2],formObj,IBSEARCH);
            t3sheet1_OnLoadFinish(sheetObjects[2]);
            
//            agreement의 currency code와 so header의 currency code를 비교 확인하기
//            validateAgmtSts();
//			validateAgmtCurrCD();


			/**
			 * 	2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
			 *  Invoice 조회 화면에서 이동해 왔을 경우 바로 다시 Invoice 조회 화면으로 돌아위한 button활성화 (2009-10-15)
			 */
			 try {
				 for (var i = 0; i < formObj.elements.length; i++){
					 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
					     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
					 {
						 with (formObj) {
							 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
								 document.all.PreInquiryCondLayer01.style.display = "inline";
								 break;
							 }
						 }
					 }
				 }
			 } catch(e){}
			 
			 tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));

			 
	 } else if (sheetObj.RowCount > 1) {
		  ComShowMessage(ComGetMsg('TES21032')); //ComShowMessage('[ERR] 복수개의 header data가 조회되었습니다.');
		  return;
	 } else if(formObj.is_dup_inv_no.value == 'Y'){ 
			ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No is duplicated in ERP(A/P). \n\nPlz, change to another Invoice No.');
	        setInitComponent("N");
			return false;
	 } else {
		  var confirm_value = ComShowConfirm(ComGetMsg('TES40031'));//해당 data가 없습니다. 해당 Inv No로 새로 생성하겠습니까?'
		  if(confirm_value){
				setInitComponent("Y");
				sheetObjects[0].Editable = true;
                sheetObjects[1].Editable = true;
                sheetObjects[2].Editable = true;
                formObj.yd_cd.focus();
		  }else{
				setInitComponent("N");
				return;
		  }
	 }
	
	 return true;

}


/*
* Etc Sheet Data Form으로 Copy하는 함수
*/
function sheetEtcDataToForm(formObj,sheetObj ){
  	formObj.cntrTpszComboItems.value = sheetObj.EtcData("tpszCode");
}


/*
* Form Data를 Sheet로 Copy하는 함수
*/
function setForm2HdSheet(sheetObj){
	var formObj = document.form;
	if (sheetObj.RowCount == 0){
		//Add row
		sheetObj.DataInsert(0);
	} else if (sheetObj.RowCount == 1){
		//이미 data가 존재하는 경우입당.  form 설정 - 정상
		sheetObj.RowStatus(1) = "U";
	} else {
		ComShowMessage('ERR');
		return false;
	}

    sheetObj.CellValue(1, 'tml_so_ofc_cty_cd'  )= 						 formObj.tml_so_ofc_cty_cd.value;
	sheetObj.CellValue(1, 'tml_so_seq'         )= 						 formObj.tml_so_seq.value;
	sheetObj.CellValue(1, 'tml_inv_tp_cd'      )= 						 formObj.tml_inv_tp_cd.value;
	sheetObj.CellValue(1, 'inv_ofc_cd'         )= 						 formObj.inv_ofc_cd.value;
	sheetObj.CellValue(1, 'cost_ofc_cd'        )= 						 formObj.cost_ofc_cd.value;
	sheetObj.CellValue(1, 'inv_no'             )= 						 formObj.inv_no.value;
	sheetObj.CellValue(1, 'vndr_seq'           )= 						 formObj.vndr_seq.value;
	sheetObj.CellValue(1, 'yd_cd'              )= 						 formObj.yd_cd.value;
	sheetObj.CellValue(1, 'curr_cd'            )= 						 formObj.curr_cd.Code;
	sheetObj.CellValue(1, 'ttl_inv_amt'        )=  ComTrimAll(formObj.ttl_inv_amt.value, ",");
	sheetObj.CellValue(1, 'vat_amt'            )=  ComTrimAll(formObj.vat_amt.value, ",");
	sheetObj.CellValue(1, 'whld_tax_amt'       )=  ComTrimAll(formObj.whld_tax_amt.value, ",");
	sheetObj.CellValue(1, 'iss_dt'             )= 						 formObj.iss_dt.value;
	sheetObj.CellValue(1, 'rcv_dt'             )= 						 formObj.rcv_dt.value;
	sheetObj.CellValue(1, 'tml_inv_sts_cd'	   )= 						 formObj.tml_inv_sts_cd.value;
	sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd')= 						 formObj.tml_inv_rjct_sts_cd.value;
	sheetObj.CellValue(1, 'hld_rmk'            )= 						 formObj.hld_rmk.value;
	sheetObj.CellValue(1, 'inv_rjct_rmk'       )= 						 formObj.inv_rjct_rmk.value;

	if (formObj.hld_flg.checked == true) {
		sheetObj.CellValue(1, 'hld_flg') ='Y';
	} else {
		sheetObj.CellValue(1, 'hld_flg') ='';
	}

    //2010.10.15 rtro_tml_inv_flg 추가
    if (formObj.rtro_tml_inv_flg.checked == true) {
    	sheetObj.CellValue(1, 'rtro_tml_inv_flg')= 'Y';
    } else {
    	sheetObj.CellValue(1, 'rtro_tml_inv_flg')= '';
    }
    
    
    if (formObj.ap_rvs_cng_flg.checked == true) {
    	sheetObj.CellValue(1, 'ap_rvs_cng_flg')= 'Y';
    } else {
    	sheetObj.CellValue(1, 'ap_rvs_cng_flg')= '';
    }
    
    sheetObj.CellValue(1,'dbt_note_no') = formObj.dbt_note_no.value;
    sheetObj.CellValue(1,'ida_cgst_amt') = formObj.ida_cgst_amt.value;
    sheetObj.CellValue(1,'ida_sgst_amt') = formObj.ida_sgst_amt.value;
    sheetObj.CellValue(1,'ida_igst_amt') = formObj.ida_igst_amt.value;
    sheetObj.CellValue(1,'ida_ugst_amt') = formObj.ida_ugst_amt.value;
}

/*
* Header Sheet Data Form으로 Copy하는 함수
*/
function setHdSheet2Form(sheetObj) {
 	 var formObj = document.form;
	 if (sheetObj.RowCount == 1) {
		 formObj.tml_so_ofc_cty_cd.value	= 				 sheetObj.CellValue(1, 'tml_so_ofc_cty_cd'  );
		 formObj.tml_so_seq.value			= 				 sheetObj.CellValue(1, 'tml_so_seq'         );
		 formObj.cost_ofc_cd.value 			= 				 sheetObj.CellValue(1, 'cost_ofc_cd'        );
		 formObj.cost_ofc_hidden.value		= 				 sheetObj.CellValue(1, 'cost_ofc_cd'        );
		 formObj.inv_no.value			    = 				 sheetObj.CellValue(1, 'inv_no'             );
		 formObj.vndr_seq.value			    = 				 sheetObj.CellValue(1, 'vndr_seq'           );
		 formObj.yd_cd.value 			    = 				 sheetObj.CellValue(1, 'yd_cd'              );
		 formObj.yd_cd_hidden.value 		= 				 sheetObj.CellValue(1, 'yd_cd'              );
		 formObj.yd_nm.value 			    = 				 sheetObj.CellValue(1, 'yd_nm'              );
		 formObj.curr_cd.Code 			    = 				 sheetObj.CellValue(1, 'curr_cd'            );
		 formObj.ttl_inv_amt.value			=   tes_chkAmtFmt(sheetObj.CellValue(1, 'ttl_inv_amt'),sheetObj.CellValue(1,'curr_cd'));
		 formObj.vat_amt.value			    =   tes_chkAmtFmt(sheetObj.CellValue(1, 'vat_amt'    ),sheetObj.CellValue(1,'curr_cd'));
		 formObj.hld_rmk.value			    = 				 sheetObj.CellValue(1, 'hld_rmk'            );
		 formObj.iss_dt.value			    = 				 sheetObj.CellValue(1, 'iss_dt'             );
		 formObj.rcv_dt.value			    = 				 sheetObj.CellValue(1, 'rcv_dt'             );
		 formObj.tml_inv_rjct_sts_cd.value  =                sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd');
					
		 if(sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd') == 'NL'){
			 formObj.tml_inv_rjct_sts_nm.value = 'Normal';
		 }else if(sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ'){
			 formObj.tml_inv_rjct_sts_nm.value = 'Reject';
		 }else if(sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd') == 'RL'){
			 formObj.tml_inv_rjct_sts_nm.value = 'Reject Lifted';
		 }

		//India GST Amount
        formObj.dbt_note_no.value			= sheetObj.CellValue(1, 'dbt_note_no' );
        formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_cgst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_sgst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_igst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_ugst_amt' ),sheetObj.CellValue(1,'curr_cd'));
	        
		 formObj.tml_inv_sts_cd.value		= 				 sheetObj.CellValue(1, 'tml_inv_sts_cd'		 );
		 formObj.whld_tax_amt.value			= 				 tes_chkAmtFmt(sheetObj.CellValue(1, 'whld_tax_amt'),sheetObj.CellValue(1,'curr_cd'));
		 formObj.tml_inv_sts_nm.value		= 				 sheetObj.CellValue(1, 'tml_inv_sts_nm'		 );
         // 주석처리 ( 2009-06-08 )
//		 formObj.total_amt.value   			=   tes_chkAmtFmt((Number(sheetObj.CellValue(1, 'ttl_inv_amt' ))
//                                                             + Number(sheetObj.CellValue(1, 'vat_amt'     ))
//                                                             - Number(sheetObj.CellValue(1, 'whld_tax_amt'))), formObj.curr_cd.Code);
         // 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
		 formObj.total_amt.value   			=   tes_chkAmtFmt( tes_round( ( Number(sheetObj.CellValue(1, 'ttl_inv_amt' ))
                                                             + Number(sheetObj.CellValue(1, 'vat_amt'     ))
                                                             - Number(sheetObj.CellValue(1, 'whld_tax_amt'))), 2 ), formObj.curr_cd.Code);

       if (sheetObj.CellValue(1, 'hld_flg')=='Y') {
			formObj.hld_flg.checked = true;
	   } else {
			formObj.hld_flg.checked = false;
	   }
       
       //2010.10.15 rtro_tml_inv_flg 추가
       if (sheetObj.CellValue(1, 'rtro_tml_inv_flg')=='Y') {
       	formObj.rtro_tml_inv_flg.checked = true;
       } else {
       	formObj.rtro_tml_inv_flg.checked = false;
       }
       
       if (sheetObj.CellValue(1, 'ap_rvs_cng_flg')=='Y') {
          	formObj.ap_rvs_cng_flg.checked = true;
          } else {
          	formObj.ap_rvs_cng_flg.checked = false;
       }
       
	}

}

// btn_retrieve Event에 대한 함수
function retrieveEvent(sheetObj, formObj) {//alert("start retrieveEvent");

	if (!fnChkSearchForm(formObj)) return false;
	
    sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
    
    //main hidden sheet - 기본정보조회
	doActionIBSheet_main(sheetObj, formObj, IBSEARCH);
	return true;
}

	/**
	 * Discrepancy List를 Coincidency List롤 넘기는 함수
	 *
	 */
 	function toCoincidence(fromSheetObj,toSheetObj){
		//ComShowMessage("toCoincidence");
		var formObj 	= document.form;
		var orgStatus = "";
		for(var i=fromSheetObj.HeaderRows ; i<fromSheetObj.HeaderRows + fromSheetObj.RowCount; i++){
			orgStatus = fromSheetObj.RowStatus(i);
			if(fromSheetObj.CellValue(i, "chk")){
				var Row = toSheetObj.DataInsert(-1);
				toSheetObj.CellEditable(Row,"chk") = true; // toDiscreption을 위한 check활성
				toSheetObj.CellValue(Row,"page"      	 			   )  = fromSheetObj.CellValue(i, "page"						 		 );
				toSheetObj.CellValue(Row,"sts"				 		 		 )  = "I";
				toSheetObj.CellValue(Row,"modi_flg"				 		 )  = "Y";
				toSheetObj.CellValue(Row,"cntr_no"				 		 )  = fromSheetObj.CellValue(i, "cntr_no"							 );
				toSheetObj.CellValue(Row,"cntr_tpsz_cd"				 )  = fromSheetObj.CellValue(i, "cntr_tpsz_cd"				 );
				toSheetObj.CellValue(Row,"cntr_sty_cd"			   )  = fromSheetObj.CellValue(i, "cntr_sty_cd"			     );
//				toSheetObj.CellValue(Row,"io_bnd_cd"			 		 )  = fromSheetObj.CellValue(i, "io_bnd_cd"			 		   );
				toSheetObj.CellValue(Row,"wrk_dt"     		     )  = fromSheetObj.CellValue(i, "wrk_dt"     	 	       );
				toSheetObj.CellValue(Row,"bkg_no" 	    	     )  = fromSheetObj.CellValue(i, "bkg_no" 	     	       );
				toSheetObj.CellValue(Row,"bkg_no_split" 	     )  = fromSheetObj.CellValue(i, "bkg_no_split" 	       );
				toSheetObj.CellValue(Row,"dcgo_clss_cd" 	     )  = fromSheetObj.CellValue(i, "dcgo_clss_cd" 	       );
				toSheetObj.CellValue(Row,"clm_dt"     		     )  = fromSheetObj.CellValue(i, "clm_dt"     	 	       );
				toSheetObj.CellValue(Row,"rail_bil_dt"  	     )  = fromSheetObj.CellValue(i, "rail_bil_dt"  	       );
				toSheetObj.CellValue(Row,"dscr_rsn"						 )  = fromSheetObj.CellValue(i, "dscr_rsn"						 );
				toSheetObj.CellValue(Row,"cntr_rmk"						 )  = fromSheetObj.CellValue(i, "cntr_rmk"						 );
				toSheetObj.CellValue(Row,"dscr_ind_cd"				 )  = fromSheetObj.CellValue(i, "dscr_ind_cd"					 );
				toSheetObj.CellValue(Row,"dscr_ind_nm"				 )  = fromSheetObj.CellValue(i, "dscr_ind_nm"					 );
				toSheetObj.CellValue(Row,"tml_so_ofc_cty_cd"   )  = fromSheetObj.CellValue(i, "tml_so_ofc_cty_cd"    );
				toSheetObj.CellValue(Row,"tml_so_seq"          )  = fromSheetObj.CellValue(i, "tml_so_seq"           );
				toSheetObj.CellValue(Row,"vrfy_rslt_ind_cd"    )  = "CO";
				toSheetObj.CellValue(Row,"vsl_cd"						   )  = fromSheetObj.CellValue(i, "vsl_cd"  	   				 );
				toSheetObj.CellValue(Row,"skd_voy_no"				   )  = fromSheetObj.CellValue(i, "skd_voy_no"  	   		 );
				toSheetObj.CellValue(Row,"skd_dir_cd"				   )  = fromSheetObj.CellValue(i, "skd_dir_cd"  	   		 );
				toSheetObj.CellValue(Row,"atb_dt"							 )  = fromSheetObj.CellValue(i, "atb_dt"							 );
				toSheetObj.CellValue(Row,"vvd_no"							 )  = fromSheetObj.CellValue(i, "vvd_no"							 );
				toSheetObj.CellValue(Row,"vndr_seq"						 )  = fromSheetObj.CellValue(i, "vndr_seq"						 );


		    fromSheetObj.RowHidden(i) = true;
			  fromSheetObj.RowStatus(i) = "D";
			  if(orgStatus == "I")	i--;
			}
		}
		formObj.tab1.selectedIndex = 0;
		sumaryContainerList(toSheetObj);

	}

/**
* Coincidence List를 Discrepancy List롤 넘기는 함수
*
*/
function toDiscreption(fromSheetObj,toSheetObj){
	var formObj = document.form;
	var orgStatus = "";

	for(var i=fromSheetObj.HeaderRows ; i<fromSheetObj.HeaderRows + fromSheetObj.RowCount; i++){
		orgStatus = fromSheetObj.RowStatus(i);
		if(fromSheetObj.CellValue(i, "chk")){
			var Row = toSheetObj.DataInsert(-1);

				toSheetObj.CellEditable(Row,"chk") = true; // toDiscreption을 위한 check활성
				toSheetObj.CellValue(Row,"page"      	 			   )  = fromSheetObj.CellValue(i, "page"						 		 );
				toSheetObj.CellValue(Row,"sts"				 		 		 )  = "I";
				toSheetObj.CellValue(Row,"modi_flg"				 		 )  = "";
				toSheetObj.CellValue(Row,"cntr_no"				 		 )  = fromSheetObj.CellValue(i, "cntr_no"							 );
				toSheetObj.CellValue(Row,"cntr_tpsz_cd"				 )  = fromSheetObj.CellValue(i, "cntr_tpsz_cd"				 );
				toSheetObj.CellValue(Row,"cntr_sty_cd"			   )  = fromSheetObj.CellValue(i, "cntr_sty_cd"			     );
				toSheetObj.CellValue(Row,"wrk_dt"     		     )  = fromSheetObj.CellValue(i, "wrk_dt"     	 	       );
				toSheetObj.CellValue(Row,"bkg_no" 	    	     )  = fromSheetObj.CellValue(i, "bkg_no" 	     	       );
				toSheetObj.CellValue(Row,"bkg_no_split" 	     )  = fromSheetObj.CellValue(i, "bkg_no_split" 	       );
				toSheetObj.CellValue(Row,"dcgo_clss_cd" 	     )  = fromSheetObj.CellValue(i, "dcgo_clss_cd" 	       );
				toSheetObj.CellValue(Row,"clm_dt"     		     )  = fromSheetObj.CellValue(i, "clm_dt"     	 	       );
				toSheetObj.CellValue(Row,"rail_bil_dt"  	     )  = fromSheetObj.CellValue(i, "rail_bil_dt"  	       );
				toSheetObj.CellValue(Row,"dscr_rsn"						 )  = fromSheetObj.CellValue(i, "dscr_rsn"						 );
				toSheetObj.CellValue(Row,"cntr_rmk"						 )  = fromSheetObj.CellValue(i, "cntr_rmk"						 );
				toSheetObj.CellValue(Row,"dscr_ind_cd"				 )  = fromSheetObj.CellValue(i, "dscr_ind_cd"					 );
				toSheetObj.CellValue(Row,"dscr_ind_nm"				 )  = fromSheetObj.CellValue(i, "dscr_ind_nm"					 );
				toSheetObj.CellValue(Row,"tml_so_ofc_cty_cd"   )  = fromSheetObj.CellValue(i, "tml_so_ofc_cty_cd"    );
				toSheetObj.CellValue(Row,"tml_so_seq"          )  = fromSheetObj.CellValue(i, "tml_so_seq"           );
				toSheetObj.CellValue(Row,"vrfy_rslt_ind_cd"    )  = "DC";
				toSheetObj.CellValue(Row,"vsl_cd"						   )  = fromSheetObj.CellValue(i, "vsl_cd"  	   				 );
				toSheetObj.CellValue(Row,"skd_voy_no"				   )  = fromSheetObj.CellValue(i, "skd_voy_no"  	   		 );
				toSheetObj.CellValue(Row,"skd_dir_cd"				   )  = fromSheetObj.CellValue(i, "skd_dir_cd"  	   		 );
				toSheetObj.CellValue(Row,"atb_dt"							 )  = fromSheetObj.CellValue(i, "atb_dt"							 );
				toSheetObj.CellValue(Row,"vvd_no"							 )  = fromSheetObj.CellValue(i, "vvd_no"							 );
				toSheetObj.CellValue(Row,"vndr_seq"						 )  = fromSheetObj.CellValue(i, "vndr_seq"						 );

				fromSheetObj.RowHidden(i) = true;
			    fromSheetObj.RowStatus(i) = "D";
			    if(orgStatus == "I")	i--;
		}

	}
		formObj.tab1.selectedIndex = 1;
}


/**
*Grid Data를 저장하는 함수
*
*/
function gridSave(){//alert("start gridSave");
	var formObj = document.form;
	var sheetObject 						= sheetObjects[0];
	var sheetObject1 						= sheetObjects[1];
	var sheetObject2 						= sheetObjects[2];
	var sheetObject_main 					= sheetObjects[3];
	var tab_index = formObj.tab1.selectedIndex;

	if (!save_conf_01){
		ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage("해당 Terminal Invoice Header가 저장되지 않았습니다.");
 		return false;
	}
	if (sheetObject.RowCount > 0 || sheetObject1.RowCount > 0) {
		doActionIBSheet1(sheetObject,formObj,IBSAVE);
	}
	if (sheetObject2.RowCount > 0) {
		doActionIBSheet3(sheetObjects[2],formObj,IBSAVE);
	}
	retrieveEvent(sheetObject_main, formObj);

}


	/**
	 * Coincidence Container List Summary하는 함수
	 *
	 */
	 function sumaryContainerList(sheetObject){
			var formObj = document.form;
//			ComShowMessage("sumaryContainerList	:	"+sheetObject.RowCount);
			var cntTot     = 0;
			var cntSizeD2  = 0;  	    
			var cntSizeD4  = 0;         
			var cntSizeD5  = 0;         
			var cntSizeD7  = 0;         
			var cntSizeD8  = 0;         
			var cntSizeD9  = 0;         
			var cntSizeDW  = 0;         
			var cntSizeDX  = 0;         
			var cntSizeR2  = 0;         
			var cntSizeR4  = 0;         
			var cntSizeR5  = 0;         
			var cntSizeR7  = 0;     
			var cntSizeR8  = 0;   
			var cntSizeR9  = 0;         
			var cntSizeF2  = 0;	    
			var cntSizeF4  = 0;         
			var cntSizeF5  = 0;
			var cntSizeO2  = 0;
			var cntSizeO4  = 0;
			var cntSizeO5  = 0;
			var cntSizeO7  = 0;
			var cntSizeS2  = 0;
			var cntSizeS4  = 0;
			var cntSizeT2  = 0;
			var cntSizeT4  = 0;
			var cntSizeA2  = 0;
			var cntSizeA4  = 0;
			var cntSizeA5  = 0;
			var cntSizeP2  = 0;
			var cntSizeP4  = 0;
			//var cntSizeZ2  = 0;
			//var cntSizeZ4  = 0;
			var cntSizeC2  = 0;
			var cntSizeC4  = 0;
			var cntFull    = 0;
			var cntEmpty   = 0;
			var cntTs      = 0;
			var cntSameTs  = 0;

			for(var i=sheetObject.HeaderRows ; i<sheetObject.HeaderRows + sheetObject.RowCount; i++){
					cntTot++;
					if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D2") 	 cntSizeD2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D4") cntSizeD4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D5") cntSizeD5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D7") cntSizeD7++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D8") cntSizeD8++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D9") cntSizeD9++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DW") cntSizeDW++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DX") cntSizeDX++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R2") cntSizeR2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R4") cntSizeR4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R5") cntSizeR5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R7") cntSizeR7++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R8") cntSizeR8++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R9") cntSizeR9++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F2") cntSizeF2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F4") cntSizeF4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F5") cntSizeF5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O2") cntSizeO2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O4") cntSizeO4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O5") cntSizeO5++;	
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O7") cntSizeO7++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S2") cntSizeS2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S4") cntSizeS4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T2") cntSizeT2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T4") cntSizeT4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A2") cntSizeA2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A4") cntSizeA4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A5") cntSizeA5++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P2") cntSizeP2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P4") cntSizeP4++;
				  //else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z2") cntSizeZ2++;
				  //else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z4") cntSizeZ4++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "C2") cntSizeC2++;
				  else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "C4") cntSizeC4++;

				  if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "F") 		 cntFull++;
				  else if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "M") cntEmpty++;


			}

			formObj.size_d2		 .value = 	ComAddComma(cntSizeD2);		
			formObj.size_d4       .value =  ComAddComma(cntSizeD4);
			formObj.size_d5       .value =  ComAddComma(cntSizeD5);
			formObj.size_d7       .value =  ComAddComma(cntSizeD7);
			formObj.size_d8       .value =  ComAddComma(cntSizeD8);
			formObj.size_d9       .value =  ComAddComma(cntSizeD9);
			formObj.size_dw       .value =  ComAddComma(cntSizeDW);
			formObj.size_dx       .value =  ComAddComma(cntSizeDX);
			formObj.size_r2       .value =  ComAddComma(cntSizeR2);
			formObj.size_r4       .value =  ComAddComma(cntSizeR4);
			formObj.size_r5       .value =  ComAddComma(cntSizeR5);
			formObj.size_r7       .value =  ComAddComma(cntSizeR7);
			formObj.size_r8       .value =  ComAddComma(cntSizeR8);
			formObj.size_r9       .value =  ComAddComma(cntSizeR9);
			formObj.size_f2       .value =  ComAddComma(cntSizeF2);
			formObj.size_f4       .value =  ComAddComma(cntSizeF4);
			formObj.size_f5       .value =  ComAddComma(cntSizeF5);
			formObj.size_o2       .value =  ComAddComma(cntSizeO2);
			formObj.size_o4       .value =  ComAddComma(cntSizeO4);
			formObj.size_o5       .value =  ComAddComma(cntSizeO5);
			formObj.size_o7       .value =  ComAddComma(cntSizeO7);
			formObj.size_s2       .value =  ComAddComma(cntSizeS2);
			formObj.size_s4       .value =  ComAddComma(cntSizeS4);
			formObj.size_t2       .value =  ComAddComma(cntSizeT2);
			formObj.size_t4       .value =  ComAddComma(cntSizeT4);
			formObj.size_a2       .value =  ComAddComma(cntSizeA2);
			formObj.size_a4       .value =  ComAddComma(cntSizeA4);
			formObj.size_a5       .value =  ComAddComma(cntSizeA5);
			formObj.size_p2       .value =  ComAddComma(cntSizeP2);
			formObj.size_p4       .value =  ComAddComma(cntSizeP4);
			//formObj.size_z2       .value =  ComAddComma(cntSizeZ2);
			//formObj.size_z4       .value =  ComAddComma(cntSizeZ4);
			formObj.size_c2       .value =  ComAddComma(cntSizeC2);
			formObj.size_c4       .value =  ComAddComma(cntSizeC4);
			
			formObj.container_tot .value =  ComAddComma(cntTot);
			formObj.full          .value =  ComAddComma(cntFull);
			formObj.empty         .value =  ComAddComma(cntEmpty);
    }


/**
* VVD NO별 ContainerList를 삭제하는 함수
*
*/
function deleteContanerList(){//alert("start deleteContanerList");

 		var formObj= document.form;
 		var orgStatus = "";
 		var deleteRows_value = false;

		for(var i=sheetObjects[0].HeaderRows;i < sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
			orgStatus = sheetObjects[0].RowStatus(i);
			sheetObjects[0].RowStatus(i) = "D";
			if(orgStatus == "I") i--;
			deleteRows_value = true;
		}
		orgStatus = "";
		for(var i=sheetObjects[1].HeaderRows;i < sheetObjects[1].HeaderRows + sheetObjects[1].RowCount; i++){
			orgStatus = sheetObjects[1].RowStatus(i);
			sheetObjects[1].RowStatus(i) = "D";
			if(orgStatus == "I") i--;
			deleteRows_value = true;
		}
		orgStatus = "";
		for(var i=sheetObjects[2].HeaderRows;i < sheetObjects[2].HeaderRows + sheetObjects[2].RowCount; i++){
			orgStatus = sheetObjects[2].RowStatus(i);
			if(sheetObjects[2].CellValue(i, "calc_tp_cd") != "M" && sheetObjects[2].CellValue(i, "calc_tp_cd") != "S"){		// Auto Calc일경우만 삭제.
				sheetObjects[2].RowStatus(i) = "D";
				if(orgStatus == "I") i--;
				deleteRows_value = true;
			}
		}
		
    return deleteRows_value;
}


	/**
	 * 해당 Sheet change Event발생시 실행하는 함수.
	 *
	 */
 function t3sheet1_OnChange(sheetObj, row, col){
		var formObj = document.form;
		//ComShowMessage(sheetObj.ColSaveName(col));
		if (sheetObj.ColSaveName(col) == "rvis_vol_qty")
		{
			 sheetObj.CellValue(row,"inv_amt") = sheetObj.CellValue(row,"rvis_vol_qty") * sheetObj.CellValue(row,"ctrt_rt")* sheetObj.CellValue(row,"inv_xch_rt");
		}else if (sheetObj.ColSaveName(col) == "ctrt_rt"){
			 sheetObj.CellValue(row,"inv_amt") = sheetObj.CellValue(row,"rvis_vol_qty") * sheetObj.CellValue(row,"ctrt_rt")* sheetObj.CellValue(row,"inv_xch_rt");
		}else if (sheetObj.ColSaveName(col) == "inv_amt"){
	 		calcurationTotalAmt(sheetObj,formObj);
	 		
	 		//금액이 변경되면 India GST 금액도 변경
	 		sheetObj.CellValue(row,'ida_cgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_cgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_sgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_sgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_igst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_igst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_ugst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_ugst_rto'))/100,2);
        	
        	sheetObj.CellValue(row,'ida_gst_rto') = parseFloat(sheetObj.CellValue(row,'ida_cgst_rto')) 
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_sgst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_igst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_ugst_rto'));
        	sheetObj.CellValue(row,'ida_gst_amt') = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
        											+ parseFloat(sheetObj.CellValue(row,'ida_sgst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_igst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
	 		
	 		calcurationTotalGstAmt(sheetObj,formObj);
	 		
		}else if(sheetObj.ColSaveName(col) == 'inv_xch_rt'){
            if(sheetObj.CellValue(row,'inv_xch_rt')==0){
                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'calc_amt');
                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'rvis_vol_qty') *  sheetObj.CellValue(row, 'ctrt_rt');
                }
            }else {
                sheetObj.CellValue(row,'inv_xch_rt') = Math.abs(sheetObj.CellValue(row,'inv_xch_rt'));
                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'inv_xch_rt') * sheetObj.CellValue(row,'calc_amt');
                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'rvis_vol_qty') *  sheetObj.CellValue(row, 'ctrt_rt') *  sheetObj.CellValue(row, 'inv_xch_rt');
                }
            }
        }else if(sheetObj.ColSaveName(col) == 'calc_vol_qty'){
            if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
                sheetObj.CellValue(row,'rvis_vol_qty') = sheetObj.CellValue(row,'calc_vol_qty');
            }
        }else if(sheetObj.ColSaveName(col) == 'lgs_cost_cd'){
        	//[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
            if(sheetObj.CellValue(row,'lgs_cost_cd') != '' && sheetObj.CellValue(row,'lgs_cost_cd') != null){
            	checkValidForRemark(sheetObj.CellValue(row,'lgs_cost_cd'), row, '2');
            }  
        }else if(sheetObj.ColSaveName(col) == 'ida_sac_cd'){//India GST
        	checkValidSacCd(sheetObj.CellValue(row,'ida_sac_cd'), row);  	
        }else if(sheetObj.ColSaveName(col) == 'ida_cgst_rto' || sheetObj.ColSaveName(col) == 'ida_sgst_rto' 
        	|| sheetObj.ColSaveName(col) == 'ida_igst_rto' || sheetObj.ColSaveName(col) == 'ida_ugst_rto'){
    	
        	sheetObj.CellValue(row,'ida_cgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_cgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_sgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_sgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_igst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_igst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_ugst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_ugst_rto'))/100,2);
        	
        	sheetObj.CellValue(row,'ida_gst_rto') = parseFloat(sheetObj.CellValue(row,'ida_cgst_rto')) 
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_sgst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_igst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_ugst_rto'));
        	sheetObj.CellValue(row,'ida_gst_amt') = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
        											+ parseFloat(sheetObj.CellValue(row,'ida_sgst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_igst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
   			
   			calcurationTotalGstAmt(sheetObj,formObj);	
   		}else if(sheetObj.ColSaveName(col) == 'ida_cgst_amt' || sheetObj.ColSaveName(col) == 'ida_sgst_amt'
					|| sheetObj.ColSaveName(col) == 'ida_igst_amt' || sheetObj.ColSaveName(col) == 'ida_ugst_amt'){
        	sheetObj.CellValue(row,'ida_gst_amt') = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
													+ parseFloat(sheetObj.CellValue(row,'ida_sgst_amt'))
													+ parseFloat(sheetObj.CellValue(row,'ida_igst_amt'))
													+ parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
        	calcurationTotalGstAmt(sheetObj,formObj);
        }
	}
 
	function checkValidSacCd(idaSacCd, row){
	 	document.form.ida_sac_cd.value = idaSacCd;
	    document.form.ida_row.value = row;
	    	
	    tes_getInputValue('valid_ida_sac_cd', SEARCH27, 'ida_sac_cd', 'getSacCd');   
	 }
	 
	 function getSacCd(){
	 	if(document.form.valid_ida_sac_cd.value == 'Y'){
	 		tes_getInputValue('ida_gst_rto', SEARCH26, 'cost_ofc_cd|vndr_seq|ida_sac_cd', 'getIdaGstRto'); 
	 	} else {
	 		ComShowMessage(ComGetMsg('TES21060'));	//ComShowMessage('This Service Accounting Code is not valid code. Please check it again.');
	 		return false;
	 	}
	 }
	 
	 function getIdaGstRto() {
	 	var formObj = document.form;
	 	var idaRow = formObj.ida_row.value;
	 	if(formObj.ida_gst_rto.value != null && formObj.ida_gst_rto.value != '') {
	 		var tmpInfo = formObj.ida_gst_rto.value;
	 		var tmp = tmpInfo.split("|");
	 		
	 		sheetObjects[2].CellValue(idaRow, 'ida_cgst_rto') = tmp[0];
	 		sheetObjects[2].CellValue(idaRow, 'ida_sgst_rto') = tmp[1];
	 		sheetObjects[2].CellValue(idaRow, 'ida_igst_rto') = tmp[2];
	 		sheetObjects[2].CellValue(idaRow, 'ida_ugst_rto') = tmp[3];
	 	}
	 }

	/**
	 * Cost Calc List의 TotalAmount를 Sum하는 함수.
	 *
	 */

	function calcurationTotalAmt(sheetObj,formObj){
			  var tot_amt = 0;
				for(var i=sheetObj.HeaderRows;i <sheetObj.HeaderRows + sheetObj.RowCount; i++){
					if(sheetObj.RowStatus(i) != "D")
						tot_amt = Math.round(tot_amt*100)/100 + Math.round(sheetObj.CellValue(i,"inv_amt")*100)/100;
			  }
			  formObj.tot_inv_amt.value = tes_chkAmtFmt(Math.round(tot_amt*100)/100, document.form.curr_cd.Code);
	}
	
	function calcurationTotalGstAmt(sheetObj,formObj){
		var tot_cgst_amt = 0;
		var tot_sgst_amt = 0;
		var tot_igst_amt = 0;
		var tot_ugst_amt = 0;
		  
		for(var i=sheetObj.HeaderRows;i <sheetObj.HeaderRows + sheetObj.RowCount; i++){
			if(sheetObj.RowStatus(i) != "D"){
				tot_cgst_amt = parseFloat(tot_cgst_amt) + parseFloat(sheetObj.CellValue(i,"ida_cgst_amt"));
				tot_sgst_amt = parseFloat(tot_sgst_amt) + parseFloat(sheetObj.CellValue(i,"ida_sgst_amt"));
				tot_igst_amt = parseFloat(tot_igst_amt) + parseFloat(sheetObj.CellValue(i,"ida_igst_amt"));
				tot_ugst_amt = parseFloat(tot_ugst_amt) + parseFloat(sheetObj.CellValue(i,"ida_ugst_amt"));
			}	
		}
			
		formObj.tot_cgst_amt.value = tes_chkAmtFmt(tot_cgst_amt, formObj.curr_cd.Code);
		formObj.tot_sgst_amt.value = tes_chkAmtFmt(tot_sgst_amt, formObj.curr_cd.Code);
		formObj.tot_igst_amt.value = tes_chkAmtFmt(tot_igst_amt, formObj.curr_cd.Code);
		formObj.tot_ugst_amt.value = tes_chkAmtFmt(tot_ugst_amt, formObj.curr_cd.Code);
	}


var popupCnt 	= 0;
var popupCnt2 = 0;
var popupCnt3 = 0;
	/**
	 * 해당 Sheet의 popup Event 발생시
	 *
	 */
function t3sheet1_OnPopupClick (sheetObj, row, col){
		var formObj = document.form;
		var rvis_vol_qty = 0;
		if (sheetObj.ColSaveName(col) == "rvis_vol_qty")
		{
			if (sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="A")
			{
				var url_str = "ESD_TES_9031Pop.screen";
						url_str += "?tml_inv_tp_cd="			+formObj.tml_inv_tp_cd		.value;
						url_str += "&tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
						url_str += "&tml_so_seq="					+formObj.tml_so_seq				.value;
						url_str += "&vndr_seq="						+formObj.vndr_seq					.value;
						url_str += "&yd_cd="							+formObj.yd_cd						.value;
						url_str += "&lgs_cost_cd="				+sheetObj.CellValue(row,"lgs_cost_cd"	);
						url_str += "&cntr_tpsz_cd="				+sheetObj.CellValue(row,"cntr_tpsz_cd");
						url_str += "&dcgo_clss_cd="				+sheetObj.CellValue(row,"dcgo_ind_cd");
						url_str += "&cal_vol="						+sheetObj.CellValue(row,"calc_vol_qty");
						url_str += "&tml_wrk_dy_cd="									+sheetObj.CellValue(row,"tml_wrk_dy_cd"		);
						url_str += "&rvis_vol_qty="				+rvis_vol_qty;
					    url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
					    url_str += "&tml_so_dtl_seq="         +sheetObj.CellValue(row,"tml_so_dtl_seq");
					    url_str += "&ctrt_rt="         +sheetObj.CellValue(row,"ctrt_rt");
						url_str += "&opener_row="					+row;
				popupCnt++;
				window.showModalDialog(url_str, window, "dialogWidth:430px; dialogHeight:405px; help:no; status:no; resizable:yes;");
			}/*
			  * 숫자입력으로 변경 20061211 (인정환수석의 요청)
			  */
			 /*
			else if(sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="M")
			{
				if(sheetObj.CellValue(row,"lgs_cost_cd") == ""){
					ComShowMessage("CostCode를 선택하지않았습니다.");
				}
				var url_str = "ESD_TES_919.screen";
						url_str += "?vvd_no="				+sheetObj.CellValue(row,"vvd_no"			);
						url_str += "&yd_cd="				+formObj.yd_cd	.value;
						url_str += "&cost_cd="		  +sheetObj.CellValue(row,"lgs_cost_cd");
						url_str += "&rh_vol_qty="		+(popupCnt2<1 ? 0:sheetObj.CellValue(row,"rvis_vol_qty"));
						url_str += "&opener_row="		+row;
				popupCnt2++;
				window.showModalDialog(url_str, window, "dialogWidth:435px; dialogHeight:450px; help:no; status:no; resizable:yes;");

			}*/
		}else if (sheetObj.ColSaveName(col) == "n3pty_flg"){
			if (sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="A")
			{
			    if(sheetObj.CellValue(row,'tml_so_dtl_seq') == '' || sheetObj.CellValue(row,'tml_so_dtl_seq') == null || sheetObj.CellValue(row,'tml_so_dtl_seq') == 0){
		            ComShowMessage('You have to 3rd party Input after save calculated result.'); 
				    return false;
		        
		        }
			    // (-)금액 입력시 Popup Open을 막음(김기영부장님, 이정은 대리 요청) - 2007.11.15
    		    if(sheetObj.CellValue(row,'inv_amt')<0){
    		        ComShowMessage('Invoice amount should be bigger than 0 to insert 3rd Party.');
    		        return false;
    		    }

				if(sheetObj.CellValue(row,"lgs_cost_cd") == ""){
					ComShowMessage(ComGetMsg('TES22031')); //ComShowMessage("CostCode를 선택하지않았습니다.");
					return false;
				}
				if(sheetObj.CellValue(row,"cntr_tpsz_cd") == ""){
					ComShowMessage(ComGetMsg('TES22032')); //ComShowMessage("Type/Size를 선택하지않았습니다.");
					return false;
				}
				if(sheetObj.CellValue(row,"dcgo_ind_cd") == ""){
					ComShowMessage(ComGetMsg('TES22033')); //ComShowMessage("DG를 선택하지않았습니다.");
					return false;
				}
				if(sheetObj.CellValue(row,"rvis_vol_qty") == ""){
					ComShowMessage(ComGetMsg('TES22034')); //ComShowMessage("Revised Vol를 입력하지않았습니다.");
					return false;
				}
				var url_str = "ESD_TES_9231Pop.screen";
						url_str += "?tml_inv_tp_cd="			+formObj.tml_inv_tp_cd.value;
						url_str += "&tml_so_ofc_cty_cd="	    +formObj.tml_so_ofc_cty_cd.value;
						url_str += "&tml_so_seq="				+formObj.tml_so_seq.value;
						url_str += "&inv_ofc_cd="				+formObj.inv_ofc_cd.value;
						url_str += "&vndr_seq="					+formObj.vndr_seq.value;
						url_str += "&yd_cd="					+formObj.yd_cd.value;
						url_str += "&inv_no="					+formObj.inv_no.value;
						url_str += "&curr_cd="					+formObj.curr_cd.Code;
						url_str += "&vvd_no="					+sheetObj.CellValue(row,"vvd_no"			);
						url_str += "&calc_tp_cd="				+sheetObj.CellValue(row,"calc_tp_cd"	);
						url_str += "&lgs_cost_cd="				+sheetObj.CellValue(row,"lgs_cost_cd"	);
						url_str += "&cntr_tpsz_cd="				+sheetObj.CellValue(row,"cntr_tpsz_cd");
						url_str += "&tml_wrk_dy_cd="			+sheetObj.CellValue(row,"tml_wrk_dy_cd"					);
						url_str += "&dcgo_clss_cd="				+sheetObj.CellValue(row,"dcgo_ind_cd" );
						url_str += "&cal_vol="					+sheetObj.CellValue(row,"calc_vol_qty");
						url_str += "&fm_tr_vol_val="			+sheetObj.CellValue(row,"fm_tr_vol_val");
						url_str += "&to_tr_vol_val="			+sheetObj.CellValue(row,"to_tr_vol_val");
						url_str += "&tml_so_dtl_seq="			+sheetObj.CellValue(row,"tml_so_dtl_seq");
						url_str += "&rvis_vol_qty="				+sheetObj.CellValue(row,"rvis_vol_qty");
						url_str += "&inv_amt="					+sheetObj.CellValue(row,"inv_amt"			);
						url_str += "&ctrt_rt="				    +sheetObj.CellValue(row,"ctrt_rt");
						url_str += "&inv_xch_rt="				+sheetObj.CellValue(row,"inv_xch_rt");
						url_str += "&opener_row="				+row;
						url_str += '&sheet_idx=3';

				popupCnt3++;

				window.showModalDialog(url_str, window, "dialogWidth:820px; dialogHeight:465px; help:no; status:no; resizable:yes;");
			}
		}
  }



	/**
	 * Menual Cost Code 추가입력하는 함수
	 *
	 */
	function costCalcRowAdd(sheetObj){
		var formObj = document.form;
		//	ComShowMessage("costCalcRowAdd");
        // CHM-201640694 Cost Calculation Tab에서 Multi-Row Add기능 추가 - 2016-04-01
		for (var i = 0; i < formObj.rowsadd.value; i++) {
		
			var Row= sheetObj.DataInsert(-1);
			sheetObj.CellValue(Row,"tml_so_ofc_cty_cd"    )  = formObj.tml_so_ofc_cty_cd.value;
			sheetObj.CellValue(Row,"tml_so_seq"           )  = formObj.tml_so_seq.value;
			sheetObj.CellValue(Row,"calc_cost_grp_cd"     )  = 'ON';
	
			sheetObj.CellComboItem(Row, 'lgs_cost_cd'	, document.form.calcOnDockComboItemsDesc.value, document.form.calcOnDockComboItems.value);
			sheetObj.CellComboItem(Row, 'cntr_tpsz_cd', document.form.cntrTpszComboItems		.value, document.form.cntrTpszComboItems	.value);
	
			sheetObj.CellValue(Row,"calc_tp_cd"			) = "M";
			sheetObj.CellValue(Row,"lgs_cost_cd"		) = "";
			
			sheetObj.CellValue(Row,"cntr_tpsz_cd"		) = "";
			sheetObj.CellValue(Row,"tml_wrk_dy_cd"		) = "";
			sheetObj.CellValue(Row,"dcgo_ind_cd"		) = "";
			sheetObj.CellValue(Row,"vol_tr_ut_cd"		) = "";
			sheetObj.CellValue(Row,"inv_xch_rt"			) = "1";
			
			if(ida_ofc_cd == 'Y'){
				sheetObj.CellValue(Row,"ida_pay_tp_cd"			) = "S";
			}
	
			sheetObj.InitCellProperty(Row, "rvis_vol_qty", dtData);
			var cells = "lgs_cost_cd|cntr_tpsz_cd|tml_wrk_dy_cd|dcgo_ind_cd|rvis_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_vol_qty|calc_rmk|n3pty_flg|inv_xch_rt";
			setShtCellsEditable(sheetObj,Row,cells,'Y');
		}
	}

	/**
	* 해당 Menual Cost Code 삭제하는 함수
	*
	*/
	function costCalcRowDel(sheetObj){
		var Row =sheetObj.SelectRow;
		var orgStatus = "";
		if(sheetObj.CellValue(Row,"calc_tp_cd") == "A"){
			ComShowMessage(ComGetMsg('TES21046')); //ComShowMessage("Calcuration Type 이 Manual인경우에만 삭제가능합니다.");
			return false;
		}
	
		sheetObj.RowHidden(Row) = true;
		sheetObj.RowStatus(Row) = "D";
		
		calcurationTotalAmt(sheetObj,document.form);
		calcurationTotalGstAmt(sheetObj,document.form);	
	}

	/**
	 * Menual CostCode입력시 Editable하는 Cell을 설정하는 함수
	 *
	 */
	function setShtCellsEditable(sheetObj, rownum, colnms, to_sts, EXCEPTION) {
		// 수동입력 rowadd를 할때마다 실행..
		//setShtCellsEditable(sheetObj, 1, 'COL_NM|COL_NM2|COL_NM3', 'N')
//		ComShowMessage('setShtCellsEditable!!');
		if (rownum==null || rownum==undefined || colnms==null || colnms==undefined || to_sts==null || to_sts==undefined)
		{
			return false;
		}

		var arr_colnms = colnms.split('|');

		for (var i=0; i<arr_colnms.length; i++)
		{
			if (EXCEPTION!=undefined && EXCEPTION=='EXCEPTION')
			{
				sheetObj.CellEditable(rownum,arr_colnms[i]) = (to_sts!=null&&to_sts=='Y'?true:false);
			} else {
				if (sheetObj.CellValue(rownum,'calc_tp_cd')=='M' )
				{
					sheetObj.CellEditable(rownum,arr_colnms[i]) = (to_sts!=null&&to_sts=='Y'?true:false);
				}
			}
		}

	}




	/**
	 * 입력날짜타입을 Validation하는 함수
	 *
	 */
   function validDate(obj){
       var formObj = document.form;
      	if(obj.value != "" && !ComIsDate(obj)){
      		ComShowMessage(ComGetMsg('TES21048')); //ComShowMessage( "날짜가 잘못입력되었습니다.");
      		obj.value = "";
      		return false;
      	}
      	if(formObj.iss_dt != null && formObj.rcv_dt != null && formObj.iss_dt.value != '' && formObj.rcv_dt.value != ''){
            if(ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0){
                ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
                return false;
            }
        }

  }

	/**
	 * Container List의 Cost Calculation을 위한 Mandatory 항목 Validation하는 함수
	 *
	 */
  function validMandatoryItemContainerList(sheetObj){
  	var validValue = true;
  	var mandatoryItem = "Cntr No ";
		for(var i=sheetObj.HeaderRows;i < sheetObj.HeaderRows + sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "cntr_no"			) == "" || sheetObj.CellValue(i, "cntr_no"			) == null){
				mandatoryItem = "Cntr No ";
				validValue = false;
			}
			if(sheetObj.CellValue(i, "cntr_tpsz_cd"	) == "" || sheetObj.CellValue(i, "cntr_tpsz_cd"	) == null){
				mandatoryItem = "Type/Size ";
				validValue = false;
			}
			if(sheetObj.CellValue(i, "cntr_sty_cd"	) == "" || sheetObj.CellValue(i, "cntr_sty_cd"	) == null){
				mandatoryItem = "F/M ";
				validValue = false;
			}
			if(sheetObj.CellValue(i, "dcgo_clss_cd"	) == "" || sheetObj.CellValue(i, "dcgo_clss_cd"	) == null){
				mandatoryItem = "DG ";
				validValue = false;
			}
			if(sheetObj.CellValue(i, "wrk_dt"				) == "" || sheetObj.CellValue(i, "wrk_dt"				) == null){
				mandatoryItem = "Working Date ";
				validValue = false;
			}

		}
		if(!validValue) ComShowMessage(mandatoryItem	+	ComGetMsg('TES22037'));   //" 는 필수항목 입니다."
		return validValue;
  }





    // agreement의 currency code와 so header의 currency code를 비교 확인하기 - 시작 ++++++++++++++++++++++++++++++++++++++++++
	function validateAgmtCurrCD(){
		var formObj = document.form;
//		if (formObj.curr_cd.Code==null || formObj.curr_cd.Code.trim()==''){
//			return false;
//		}
//		if (formObj.curr_cd.Code!=main_hidden.CellValue(1,'curr_cd')){
//			return false;
//		}

		tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|max_wrk_dt|min_wrk_dt', '');

	}

	function isValidAgmtCurrCD(){
		// calc tab 계산전에 so hdr의 currency와 agreement의 currency code가 일치하는지 여부를 파악...
		var formObj = document.form;
		if (formObj.curr_cd.Code==null || formObj.curr_cd.Code.trim()==''){
			ComShowMessage(ComGetMsg('TES40039')); //ComShowMessage('so header의 currency code가 선택되지 않았습니다.');
			return false;
		}
		if (formObj.curr_cd.Code!=main_hidden.CellValue(1,'curr_cd')){
			ComShowMessage(ComGetMsg('TES40040')); //ComShowMessage('so header의 currency code가 저장되지 않았습니다.');
			return false;
		}
		if (formObj.agmtCurrCd.value==null || formObj.agmtCurrCd.value.trim()==''){
			ComShowMessage(ComGetMsg('TES40030')); //ComShowMessage('agreement의 currency code를 가져올 수 없습니다.');
			tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|max_wrk_dt|min_wrk_dt', '');
			return false;
		}
		if (formObj.agmtCurrCd.value.trim() == formObj.curr_cd.Code.trim()){
//			ComShowMessage(1);
			return true;
		} else {
			ComShowMessage(ComGetMsg('TES40028',formObj.agmtCurrCd.value,formObj.curr_cd.Code));
			//ComShowMessage('agreement에 등록된 currency code인 "'+formObj.agmtCurrCd.value+'"는 현재의 so header의 currency code인 "'+formObj.curr_cd.Code+'"와 일치하지 않습니다.');
			return false;
		}
		return false;
	}
	// agreement의 currency code와 so header의 currency code를 비교 확인하기 - 끝 ++++++++++++++++++++++++++++++++++++++++++


	// agreement의 status를 확인하기 - 시작 ++++++++++++++++++++++++++++++++++++++++++
	function validateAgmtSts(){
		tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|max_wrk_dt|min_wrk_dt', '');
	}

	function isValidAgmtSts(){
		/********
			--Cost Cal 시 Effective Date가 Inv Date(ATB or Issue Date) or To Period 에 해당하는
			--Agreement를 List Up한 후 그중 최종 버전(ST)이 'C'이면 계산을 진행하고 'P' 상태이면
			--"Agreement가 수정중입니다. Agreement 담당자에게 문의하십시오."라는 메시지를 띄우고 Rate 계산을 하지 않도록 함
			--Agreement가 존재하지 않으면, 즉, EX가 0이면 "Agreement가 존재하지 않습니다.Agreement 담당자에게 문의하십시오."
			--라는 메시지를 띄우고 Rate 계산을 하지 않도록 함
		*********/
		var formObj = document.form;
		var tmp = '';
		tmp = formObj.agmtSts.value;
		if (tmp!=undefined && tmp!=null && tmp.trim()!=''){
			tmp = tmp.split('|');
			if (tmp.length > 0){
				if (tmp[0]!=null && !isNaN(tmp[0])){
					if (parseInt(tmp[0])>0){
						if (tmp[1]!=undefined && tmp[1]!=null){
							if (tmp[1].trim()=='C'){
								// 오케바리 : 계산을 진행
								return true;
							} else if (tmp[1].trim()=='P'){
								ComShowMessage(ComGetMsg('TES40005')); //ComShowMessage('Agreement가 수정중입니다. Agreement 담당자에게 문의하십시오.');
								return false;
							} else {
								ComShowMessage(ComGetMsg('TES40003')); //ComShowMessage('Agreement status가 조회되지 않습니다.Agreement 담당자에게 문의하십시오.');
								return false;
							}
						}
					} else if (parseInt(tmp[0])==0){
						ComShowMessage(ComGetMsg('TES40005')); //ComShowMessage('Agreement가 존재하지 않습니다.Agreement 담당자에게 문의하십시오.');
						return false;
					} else {
						ComShowMessage('[ERR-Agreement_01]');
						return false;
					}
				} else {
					ComShowMessage('[ERR-Agreement_02]');
					return false;
				}
			} else {
				ComShowMessage('[ERR-Agreement_03]');
				return false;
			}
		} else {
			ComShowMessage('[ERR-Agreement_04]');
			return false;
		}
		return true;
	}
	// agreement의 status를 확인하기 - 끝 ++++++++++++++++++++++++++++++++++++++++++



	/**
	 * CNTR LIST 저장시
	 * I/O, F/M, DG, WorkingDate, IPC, Lane, T/S 가 모두 입력되어 있는지 체크한다.
	 * I/O의 경우에는 화면의 VVD 정보에 있는 IO Bound와 일치하는지도 체크한다.
	 *
	 * 추후 Trans Mode도 Mandatory Item으로 체크할 예정이다.
	 */
	function CheckCNTRListMandatoryCol(){
	    var flag = true;

	    //Coincidence, Discrepancy 모두 체크
	    for(j=0; j<1; j++){
	        for(i=sheetObjects[j].HeaderRows; i<sheetObjects[j].HeaderRows + sheetObjects[j].RowCount; i++){
	            if(sheetObjects[j].CellValue(i,'cntr_sty_cd') == ''){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'cntr_tpsz_cd') == ''){
	                flag = false;
	            }

	            if(sheetObjects[j].CellValue(i,'dcgo_clss_cd') == ''){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'wrk_dt') == ''){
	                flag = false;
	            }
	        }
	    }
	    if(flag == false){
	        ComShowMessage(ComGetMsg('TES40008')); //ComShowMessage('CNTR Type Size, F/M, DG, WorkingDate 는 필수 입력항목입니다. 확인하십시오.');
	        return false;
	    }

	    return true;

	}


	/**
	 * Currency Code 변경시
	 * 1. Cost Calculation Tab의 데이타 삭제
	 * 2. KRW, JPY가 선택되었을 경우 inv_amt, rate 등의 값의 소수점을 절삭하도록... &  세팅 변경해줌
	 */
	function curr_cd_OnChange(){//alert("start curr_cd_OnChange");
		var main_hidden = sheetObjects[3];
		var sheetObj2 = sheetObjects[2];
		var formObj = document.form;

		//alert("main_hidden.RowCount==>"+main_hidden.RowCount);
		
		if (main_hidden.RowCount==1){
		    if((main_hidden.CellValue(1,'curr_cd')!=comboObjects[0].Code) ||
		       (formObj.curr_cd_tmp.value!=undefined && formObj.curr_cd_tmp.value!=null && formObj.curr_cd_tmp.value!='' && formObj.curr_cd_tmp.value!=comboObjects[0].Code)){
		        resetInputValue();
		    }
		    if(sheetObj2.RowCount > 0){
		        if (formObj.curr_cd_tmp.value != comboObjects[0].Code){
    		        if(ComShowConfirm(ComGetMsg('TES40033'))){//'TES40033Currency가 변경되었습니다. \n\n Cost Calc. 탭의 Data를 삭제하시겠습니까?'
                        sheetObj2.RemoveAll();
                        doActionIBSheet3(sheetObj2,formObj,IBDELETE);
                        resetSheetDataProperty(comboObjects[0].Code);
    		        }else{
    		            comboObjects[0].Code = formObj.curr_cd_tmp.value;
    		        }
		        }
		    }
		    formObj.curr_cd_tmp.value = comboObjects[0].Code;
		}
	}

	function resetInputValue(){
		var formObj = document.form;
		formObj.ttl_inv_amt.value = '';
		formObj.vat_amt.value = '';
	}

	function resetSheetDataProperty(CURR_CD){
		if (CURR_CD!=undefined && tes_isNoDecimalPointCurrCD(CURR_CD)){
			sheetObjects[2].InitDataProperty(0, 24 , dtData  ,    70,    daRight ,  true,    "ctrt_rt" ,  false,  "", dfInteger,   0,     false,       false);
			sheetObjects[2].InitDataProperty(0, 27 , dtData  ,    70,    daRight ,  true,    "inv_amt" ,  false,  "", dfInteger,   0,     false,       false);
		} else {
		    sheetObjects[2].InitDataProperty(0, 24 , dtData  ,    70,    daRight ,  true,    "ctrt_rt" ,  false,  "", dfFloat,     2,     false,       false);
		    sheetObjects[2].InitDataProperty(0, 27 , dtData  ,    70,    daRight ,  true,    "inv_amt" ,  false,  "", dfFloat,     2,     false,       false);
		}
	}


	function validateErrInvNo() {
		var formObj = document.form;

		formObj.err_inv_no.value = formObj.err_inv_no.value.trim();
		if (formObj.err_inv_no.value!=null && formObj.err_inv_no.value.trim()!=''){
			tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
		}
	}

	function checkValidErrInvNo(){
		var formObj = document.form;
		//ComShowMessage('checkValidErrInvNo - is_valid_err_inv_no:'+formObj.is_valid_err_inv_no.value);
		if (formObj.is_valid_err_inv_no.value!=undefined && formObj.is_valid_err_inv_no.value!=null && formObj.is_valid_err_inv_no.value.trim()=='Y'){
		    sheetObjects[3].CellValue(1,'err_inv_no') = formObj.err_inv_no.value;
			//ComShowMessage('ERR_INV_NO 오케바리');
		} else {
			formObj.is_valid_err_inv_no.value = '';
			ComShowMessage(ComGetMsg('TES40058','ERR INV.NO')); //ComShowMessage('존재하지 않는 ERR INV.NO입니다.');
		}
	}


	function reSize(){
		var div01 = document.all.SearchLayer01.style.display ;
		var div02 = document.all.SearchLayer02.style.display ;
		var obj = event.srcElement;
		if ( div01 == "inline" ){
			obj.src = "/hanjin/img/alps/bu_prev01.gif";
			document.all.SearchLayer01.style.display = "none" ;
			document.all.SearchLayer02.style.display = "none" ;
		} else {
			obj.src = "/hanjin/img/alps/bu_next01.gif";
			document.all.SearchLayer01.style.display = "inline" ;
			document.all.SearchLayer02.style.display = "inline" ;
		}
	}


	function fileImp(){
	    //COIN - 조회
		doActionIBSheet1(sheetObjects[0],document.form,IBSEARCH);
		t1sheet1_OnLoadFinish(sheetObjects[0]);
		//DSCP - 조회
		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
		t2sheet1_OnLoadFinish(sheetObjects[1]);
	}
	
	/** 
	 * Issue DT와 User Office의 Local Sysdate와의 유효성 체크
	 * 입력받은 Issue DT가 Storage Invoice Creation화면이 loadPage될 때의 
	 * User Office의 Sysdate보다 크면 false 그렇지 않으면 true
	 * @return
	 */
	function isValIssSys(obj){
		var str_tgtDt = obj.value.replace(/-/gi,'');
		var str_sysDt = new String(db_date).substring(0,8);
		
		if (isNaN(str_tgtDt) || isNaN(str_sysDt) || str_tgtDt.trim().length!=8 || str_sysDt.trim().length!=8) {
			ComShowMessage(ComGetMsg('TES23011')); //ComShowMessage('날짜 형식이 잘못되었습니다.');
			return false;
		}
		
		if (parseInt(str_tgtDt,10) - parseInt(str_sysDt,10) > 0){
			if (obj.name == 'iss_dt'){
				ComShowMessage('Issued DT error.');
			} else if (obj.name == 'rcv_dt'){
				ComShowMessage('Received DT error.');
			}
			return false;
		}
		return true;
	}	

	/**
	 * total_amt : ttl_inv_amt + vat_amt - whld_tax_amt 값으로 user 편의를 위해 보여주는 값(readOnly)
	 */
	function set_total_amount(){
	    var formObj = document.form;
	    var ttl_inv_amt = 0;
	    var vat_amt = 0;
	    var whld_tax_amt = 0;

	    if(formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined){
	        ttl_inv_amt = ComTrimAll(formObj.ttl_inv_amt.value, ",");
	    }
	    if(formObj.vat_amt.value != '' || formObj.vat_amt != undefined){
	        vat_amt = ComTrimAll(formObj.vat_amt.value, ",");
	    }
	    if(formObj.whld_tax_amt.value != '' || formObj.vat_amt != undefined){
	        whld_tax_amt = ComTrimAll(formObj.whld_tax_amt.value, ",");
	        if(whld_tax_amt=="") whld_tax_amt = 0;
	    }
	    
	    //2008-09-19 소수점 계산 버그로 *100 /100 추가
	    //formObj.total_amt.value = tes_chkAmtFmt((Number(ttl_inv_amt) + Number(vat_amt) - Number(whld_tax_amt)), formObj.curr_cd.Code);
	    // 주석처리 ( 2009-06-08 )
//	    formObj.total_amt.value = tes_chkAmtFmt((Number(ttl_inv_amt*100) + Number(vat_amt*100) - Number(whld_tax_amt*100))/100, formObj.curr_cd.Code);
        // 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
	    formObj.total_amt.value = tes_chkAmtFmt( tes_round((Number(ttl_inv_amt) + Number(vat_amt)  - Number(whld_tax_amt)), 2 ), formObj.curr_cd.Code);
	}
	
	function set_vat_amount(){
	    var formObj = document.form;
	    var ttl_inv_amt = 0;
	    var whld_tax_amt = 0;
	    
	    var ida_cgst_amt = 0;
	    var ida_sgst_amt = 0;
	    var ida_igst_amt = 0;
	    var ida_ugst_amt = 0;

	    if(formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined){
	        ttl_inv_amt = ComTrimAll(formObj.ttl_inv_amt.value, ",");
	    }
	    if(formObj.whld_tax_amt.value != '' || formObj.whld_tax_amt != undefined){
	        whld_tax_amt = ComTrimAll(formObj.whld_tax_amt.value, ",");
	    }
	    if(formObj.ida_cgst_amt.value !== '' || formObj.ida_cgst_amt != undefined){
	    	ida_cgst_amt = ComTrimAll(formObj.ida_cgst_amt.value, ",");
	    }
	    if(formObj.ida_sgst_amt.value !== '' || formObj.ida_sgst_amt != undefined){
	    	ida_sgst_amt = ComTrimAll(formObj.ida_sgst_amt.value, ",");
	    }
	    if(formObj.ida_igst_amt.value !== '' || formObj.ida_igst_amt != undefined){
	    	ida_igst_amt = ComTrimAll(formObj.ida_igst_amt.value, ",");
	    }
	    if(formObj.ida_ugst_amt.value !== '' || formObj.ida_ugst_amt != undefined){
	    	ida_ugst_amt = ComTrimAll(formObj.ida_ugst_amt.value, ",");
	    }
	    
	    formObj.vat_amt.value = tes_chkAmtFmt( tes_round( (Number(ida_cgst_amt) + Number(ida_sgst_amt) + Number(ida_igst_amt) + Number(ida_ugst_amt)), 2 ), formObj.curr_cd.Code );
	    formObj.total_amt.value = tes_chkAmtFmt( tes_round( (Number(ttl_inv_amt) + Number(ida_cgst_amt) + Number(ida_sgst_amt) + Number(ida_igst_amt) + Number(ida_ugst_amt) - Number(whld_tax_amt)), 2 ), formObj.curr_cd.Code );
	    
	}
	
	/** 
	 * 입력받은 yard Code가 US 또는 CA가 아닐경우(Code의 앞 2글자) 탭1시트와 탭2시트의 CLM Date칼럼을 Hidden 처리한다
	 * @return
	 */
	function checkYdCd(ydCd) {
		var sheetObject 	 = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		
		if (ydCd.length < 2) return;
		
		var ydCdPrefix = ydCd.substring(0,2); 		
		
		if ( ydCdPrefix =='US' || ydCdPrefix =='CA') {
			sheetObject.ColHidden('clm_dt') = false; 
			sheetObject1.ColHidden('clm_dt') = false; 
		} else {
			sheetObject.ColHidden('clm_dt') = true; 
			sheetObject1.ColHidden('clm_dt') = true; 
		}
	}
	 
    /**
	 * 입력된 Invoice No가 기 존재하는 중복된 것이 아닌지 확인하는 함수
	 */
	function validateInvDupChk() {
		var formObj = document.form;
		if (formObj.inv_no.value==null || formObj.inv_no.value.trim()==''){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			return false;
		}
		
		if ((formObj.inv_no_hidden.value==null || formObj.inv_no_hidden.value.trim()=='') || formObj.inv_no.value.trim()!=formObj.inv_no_hidden.value.trim()){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
		}
	}	
	
	/**
	 *  Inv_no Dup Validation 함수
	 */
	function checkInvDup(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_dup_inv_no.value!=undefined && formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value.trim()!=''){
			tmp = formObj.is_dup_inv_no.value;
			if (tmp.length > 0){
				formObj.is_dup_inv_no.value = (tmp!=undefined&&tmp!=null?tmp:'');
				if (formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value == 'Y'){
					//formObj.is_dup_inv_no.value = '';
					//formObj.inv_no_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No. is duplicated. Plz, change to another Invoice No.');
				}
			}
		}
	}	 


	function setCostCode(sheetObj){
	    if (sheetObj.CheckedRows("sel") < 1) {
	        return;
	    }
	    var targetSheetObj = sheetObjectsMap['t4sheet1']; 
	    var idx;
	    for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
	    	if( !sheetObj.CellValue(i,"sel")) continue;
	    	idx = targetSheetObj.DataInsert(-1);    	
		    targetSheetObj.CellValue2(idx,"calc_tp_cd")      =  sheetObj.CellValue(i,"calc_tp_cd");       
		    targetSheetObj.CellValue2(idx,"lgs_cost_cd")     =  sheetObj.CellValue(i,"lgs_cost_cd");      
		    targetSheetObj.CellValue2(idx,"cntr_tpsz_cd")    =  sheetObj.CellValue(i,"cntr_tpsz_cd");     
		    targetSheetObj.CellValue2(idx,"io_bnd_cd")       =  sheetObj.CellValue(i,"io_bnd_cd");        
		    targetSheetObj.CellValue2(idx,"dcgo_ind_cd")     =  sheetObj.CellValue(i,"dcgo_ind_cd");      
		    targetSheetObj.CellValue2(idx,"rc_flg")          =  sheetObj.CellValue(i,"rc_flg");           
		    targetSheetObj.CellValue2(idx,"tml_wrk_dy_cd")   =  sheetObj.CellValue(i,"tml_wrk_dy_cd");    
		    targetSheetObj.CellValue2(idx,"ioc_cd")          =  sheetObj.CellValue(i,"ioc_cd");           
		    targetSheetObj.CellValue2(idx,"tml_trns_mod_cd") =  sheetObj.CellValue(i,"tml_trns_mod_cd");  
		    targetSheetObj.CellValue2(idx,"lane_cd")         =  sheetObj.CellValue(i,"lane_cd");          
		    targetSheetObj.CellValue2(idx,"tier")            =  sheetObj.CellValue(i,"tier");             
		    targetSheetObj.CellValue2(idx,"calc_vol_qty")    =  sheetObj.CellValue(i,"calc_vol_qty");     
		    targetSheetObj.CellValue2(idx,"rvis_vol_qty")    =  sheetObj.CellValue(i,"rvis_vol_qty");     
		    targetSheetObj.CellValue2(idx,"stay_dys")        =  sheetObj.CellValue(i,"stay_days");        
		    targetSheetObj.CellValue2(idx,"vol_tr_ut_cd")    =  sheetObj.CellValue(i,"vol_tr_ut_cd");     
		    targetSheetObj.CellValue2(idx,"ctrt_rt")         =  sheetObj.CellValue(i,"ctrt_rt");          
		    targetSheetObj.CellValue2(idx,"inv_amt")         =  sheetObj.CellValue(i,"inv_amt");          
		    targetSheetObj.CellValue2(idx,"curr_cd")         =  sheetObj.CellValue(i,"curr_cd");  
		    
			targetSheetObj.CellValue2(idx, "calc_cost_grp_cd") = "SD";

			setShtCellsEditable(targetSheetObj, idx, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y', "EXCEPTION");
			setShtCellsEditable(targetSheetObj, idx, 'free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");        
			

	    }
	}

	/**
	 * 
	 * @param sheetObj
	 */
	function setCostCode2(sheetObj){
		if (sheetObj.CheckedRows("sel") < 1) {
			return;
		}
		var vvd_hidden     = sheetObjects[4];
	//	    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden);
		var targetSheetObj = sheetObjectsMap['t3sheet1']; 
		var formObj = document.form;
		var idx;
		for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
			if( !sheetObj.CellValue(i,"sel")) continue;  
			idx = targetSheetObj.DataInsert(-1);

			// 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
			targetSheetObj.CellValue(idx, "tml_so_ofc_cty_cd")	= formObj.tml_so_ofc_cty_cd.value;
			targetSheetObj.CellValue(idx, "tml_so_seq")			= formObj.tml_so_seq.value;
	    		
			targetSheetObj.CellValue2(idx,"calc_tp_cd")      =  sheetObj.CellValue(i,"calc_tp_cd");       
			targetSheetObj.CellValue2(idx,"lgs_cost_cd")     =  sheetObj.CellValue(i,"lgs_cost_cd");      
			targetSheetObj.CellValue2(idx,"cntr_tpsz_cd")    =  sheetObj.CellValue(i,"cntr_tpsz_cd");     
			//		    targetSheetObj.CellValue2(idx,"io_bnd_cd")       =  io_hidden;      
	
			if((sheetObj.CellValue(i,"dcgo_ind_cd"))=='ALL'){
				sheetObj.CellValue(i,"dcgo_ind_cd")='';
				targetSheetObj.CellValue2(idx,"dcgo_ind_cd")     =  sheetObj.CellValue(i,"dcgo_ind_cd");
			}
		    
			if(sheetObj.CellValue(i,"lane_cd")=='Sam'){
				sheetObj.CellValue(i,"lane_cd")='';  
			}
			
			targetSheetObj.CellValue2(idx,"rc_flg")          =  sheetObj.CellValue(i,"rc_flg");           
			targetSheetObj.CellValue2(idx,"tml_wrk_dy_cd")   =  sheetObj.CellValue(i,"tml_wrk_dy_cd");    
			targetSheetObj.CellValue2(idx,"ioc_cd")          =  sheetObj.CellValue(i,"ioc_cd");           
			targetSheetObj.CellValue2(idx,"tml_trns_mod_cd") =  sheetObj.CellValue(i,"tml_trns_mod_cd");  
			targetSheetObj.CellValue2(idx,"lane_cd")         =  sheetObj.CellValue(i,"lane_cd");          
			targetSheetObj.CellValue2(idx,"tier")            =  sheetObj.CellValue(i,"tier");             
			targetSheetObj.CellValue2(idx,"calc_vol_qty")    =  sheetObj.CellValue(i,"calc_vol_qty");     
			targetSheetObj.CellValue2(idx,"rvis_vol_qty")    =  sheetObj.CellValue(i,"rvis_vol_qty");     
			targetSheetObj.CellValue2(idx,"stay_days")       =  sheetObj.CellValue(i,"stay_days");        
			targetSheetObj.CellValue2(idx,"vol_tr_ut_cd")    =  sheetObj.CellValue(i,"vol_tr_ut_cd");     
			targetSheetObj.CellValue2(idx,"ctrt_rt")         =  sheetObj.CellValue(i,"ctrt_rt");          
			targetSheetObj.CellValue2(idx,"inv_amt")         =  sheetObj.CellValue(i,"inv_amt");          
			targetSheetObj.CellValue2(idx,"curr_cd")         =  sheetObj.CellValue(i,"curr_cd");  
			targetSheetObj.CellValue2(idx,"tml_crr_cd")      = '';
			targetSheetObj.CellValue2(idx,'calc_cost_grp_cd') = 'TM';
			targetSheetObj.CellValue2(idx,'inv_xch_rt')       = sheetObj.CellValue(i,"inv_xch_rt");
			targetSheetObj.CellValue2(idx,'semi_auto_calc_flg') = 'Y';
			
			// 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
			targetSheetObj.CellValue2(idx, "tml_agmt_ofc_cty_cd")	= sheetObj.CellValue(i, "tml_agmt_ofc_cty_cd");      
			targetSheetObj.CellValue2(idx, "tml_agmt_seq")			= sheetObj.CellValue(i, "tml_agmt_seq");      
			targetSheetObj.CellValue2(idx, "tml_agmt_ver_no")		= sheetObj.CellValue(i, "tml_agmt_ver_no");      
			targetSheetObj.CellValue2(idx, "rmk_chk_flg")		    = sheetObj.CellValue(i, "rmk_chk_flg");      
			
			//	        targetSheetObj.CellValue2(idx,'vsl_cd')           = vvd_hidden.CellValue(vvd_row, 'vvd_vsl_cd');
			//	        targetSheetObj.CellValue2(idx,'skd_voy_no')       = vvd_hidden.CellValue(vvd_row, 'vvd_skd_voy_no');
			//	        targetSheetObj.CellValue2(idx,'skd_dir_cd')       = vvd_hidden.CellValue(vvd_row, 'vvd_skd_dir_cd');
			//	        targetSheetObj.CellValue2(idx,'atb_dt')           = vvd_hidden.CellValue(vvd_row, 'vvd_atb_dt');
			
			setShtCellsEditable(targetSheetObj,idx,'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg','Y');
		}
	}
	
	function checkLoginOfc(){	
		var formObj = document.form;
		
		if(formObj.chk_ofc_cd.value == "N"){
			if(ComShowConfirm(ComGetMsg('TES21053'))){  
				formObj.vndr_seq.focus();
				return;
			} else {
				ComShowMessage(ComGetMsg('TES21054'));
				setInitComponent('N');
				
				ComEnableObject(formObj.vndr_seq, false);
				ComEnableObject(formObj.inv_no, false);
				formObj.vndr_seq.readOnly = true;
				formObj.inv_no.readOnly = true;
				
				return false;
			}
		} else {
			formObj.vndr_seq.focus();
		}
	}
	