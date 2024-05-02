/**=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0013.js
*@FileTitle : Marine Terminal Invoice
*Open Issues :
*Change history :  
*@LastModifyDate : 2009.08.17
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.01.08 
* 1.0 최초 생성
* 2009-08-17 : [CHM-200900760] NEW button기능에 tes_removeTESCommonALLIframes()추가
* 2009-08-27 : [PJM-200900072] INVOICE 목록에 VVD항목 추가 및 INV_NO merge 처리
* 								INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
=========================================================*/

/**
 * @fileoverview Invoice Summary 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */
/**
 * @extends Tes
 * @class ESD_TES_0013 : Invoice Summary 화면에서 사용하는 업무 스크립트를 정의한다.
 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var pre_ret_cond_val = '';

	/**
	 * 글입력시 max length 체크해서 false 리턴함
	 * @param {object}	obj		input object
	 * @return 
	 */
	function chkInput(obj) {
	//	showErrMessage('strleng: '+getStrLen(obj.value));
		if (obj.maxLength < ComGetLenByByte(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}

	/** 
	 * 숫자인지 체크함
	 * @param {object}	obj		input object
	 * @return
	*/	
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
	
	/**
	 * 숫자인지 체크함, 숫자값에 대시를 넣어준다
	 * @param {object}	obj		input object
	 * @return
	 */
	function isNum1(obj){
			//숫자만..
			if (!ComIsNumber(obj,"-")){
				obj.value = '';
			}
		}

	/**
	 * 영문과 숫자인지 체크함
	 * @param {object}	obj		input object
	 * @return
	 */	
	function isApNum(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,"n")){
			obj.value = '';
		}
	}

	/**
	 * 영문인지 체크함
	 * @param {object}	obj		input object
	 * @return
	 */	
    function isAlpha(obj) {
        if(!ComIsAlphabet(obj)) {
           obj.value = "";
        }

    }

	/**
	 * 한글 및 영문 길이 체크
	 * @param {string}	scr		체크할 문자
	 * @return
	 */		 
    function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}

	 
	/**
	 * 조회
	 * @return
	*/
	function retrieve(){
		if ((document.form.inv_no.value!=undefined && document.form.inv_no.value!=null && document.form.inv_no.value.trim()!='') ||
			(document.form.csr_no.value!=undefined && document.form.csr_no.value!=null && document.form.csr_no.value.trim()!=''))
		{
			// 바로 조회 처리
		} else {
			if (document.form.inv_date_type.value==undefined || document.form.inv_date_type.value==null || document.form.inv_date_type.value.trim()=='')
			{
				ComShowMessage('Please select one of \'Inv.No.\', \'CSR No.\' or \'Inv. Date\' type');
				return false;
			}
			if(!ComIsNull(document.form.inv_date_type.value)){
				if(ComIsNull(document.form.fm_prd_dt.value)){
					ComShowMessage(ComGetMsg('TES21903')); //showErrMessage("조회조건 : 시작 날짜를 입력하세요.");
					document.form.fm_prd_dt.focus();
					return false;
				}
				if(ComIsNull(document.form.to_prd_dt.value)){
					ComShowMessage(ComGetMsg('TES21904')); //showErrMessage("조회조건 : 마지막 날짜를 입력하세요.");
					document.form.to_prd_dt.focus();
					return false;
				}
				
				chkPeriod();
			}
			if (!((document.form.yd_cd.value!=undefined && document.form.yd_cd.value!=null && document.form.yd_cd.value.trim()!='') ||
				  (document.form.vndr_seq.value!=undefined && document.form.vndr_seq.value!=null && document.form.vndr_seq.value.trim()!='') ||
				  (document.form.cost_ofc_cd.value!=undefined && document.form.cost_ofc_cd.value!=null && document.form.cost_ofc_cd.value.trim()!='') ||
				  (document.form.inv_ofc_cd.value!=undefined && document.form.inv_ofc_cd.value!=null && document.form.inv_ofc_cd.value.trim()!=''))) 
			{
				ComShowMessage('Please enter one of \'Yard Code\', \'S/P Code\', \'Cost OFC\' or \'INV OFC\'.');
				return false;
			}
		}
		
//			if (ComIsNull(formObject.yd_cd.value)){
//			  	ComShowMessage(ComGetMsg(('TES21901')); //showErrMessage("야드값을 입력하세요.");
//			  	return false;
//			}
//			if (!ComChkLen(formObject.yd_cd, 7)){
//			  	showErrMessage(getMsg('TES21902')); //showErrMessage("정확한 야드 정보를 입력하세요.");
//			  	return false;
//			}
		/** 2013.02.27 log-in office가 특정 Inv(FDRCIV201301~FDRCIV201312)가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 **/
		/** 그룹사 조직 코드 변경 HAMUOG->HAMRUO, SELCOT->SELOPA (2015-08-03) **/
		if ((document.form.cre_ofc_cd.value == "HAMRUO") || (document.form.cre_ofc_cd.value == "SELOPA")) {
			 document.form.cre_ofc_cd.value = "HAMSEL";			
		}
		
		document.all.EDILayer01.style.display = "none";
		
		if (document.form.hld_flg.checked == true) {
			document.form.hld_flg.value = 'Y';
		} else {
			document.form.hld_flg.value = 'N';
		}

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

		if (sheetObjects[0].RowCount>0){
			document.form.tml_inv_tp_cd.value = sheetObjects[0].cellvalue(1,'tml_inv_tp_cd');
		} else {
			ComShowMessage(ComGetMsg('TES21905')); //showErrMessage("No Data Found");
		}
	}


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * @return
 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
             switch(srcName) {
				case "btn_EDIinvoiceview":
					
					var url_str = 'ESD_TES_1001Popup.screen';
					var tml_inv_sts_cd = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_sts_cd');
					if (tml_inv_sts_cd == 'ER'){ // EDI 전송된 invoice
						if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_rjct_sts_cd')=='AJ'){
							ComShowMessage('Auto Rejected EDI Received Invoice.');
							return false;
						}
						url_str += '?tml_edi_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_edi_so_ofc_cty_cd');
						url_str += '&tml_edi_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_edi_so_seq');
//						alert('ER: '+url_str);
					} else {
						if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_rjct_sts_cd')=='RJ'){
							ComShowMessage('Auto Rejected EDI Received Invoice.');
							return false;
						}
						url_str += '?tml_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_ofc_cty_cd');
						url_str += '&tml_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_seq');
//						alert('NO ER: '+url_str);
					}
//					var url_str = 'ESD_TES_1001Popup.screen';
//					url_str += '?tml_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_ofc_cty_cd');
//					url_str += '&tml_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_seq');
					//url_str += '&fm_cre_mode=Y';
//					alert(url_str);
					window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
					break;
             
        	    case "btn_retrieve":        	    	
        	    	retrieve();
        	        break;

        	    case "btn_new":
        	    	try {
						tes_removeTESCommonALLIframes();
						pre_ret_cond_val = '';
					} catch (e){
					}
					document.all.EDILayer01.style.display = "none";
    	            formObject.reset();
    	            sheetObject.RemoveAll();
    	            tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
        	        break;

                case "btns_calendar1":
        	         var cal = new ComCalendar();
            		 cal.select(formObject.fm_prd_dt, 'yyyy-MM-dd');
        	        break;

        	    case "btns_calendar2":
        	         var cal = new ComCalendar();
            		 cal.select(formObject.to_prd_dt,  'yyyy-MM-dd');
        	        break;

          	    case "btn_yard":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_061";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3)
                     // radio PopUp
                     if(chkStr == "1,0") {
                    	 ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 470, 'getYard', dispaly);
                      } else {
                    	  ComShowCodeMessage('TES21906'); //showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                           return;
                      }
          	        break;

          	    case "btn_vndr":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
          	       	var classId = "COM_ENS_0C1";

          		   		var param = '?classId='+classId;

          		   		var chkStr = dispaly.substring(0,3)

                         // radio PopUp
                         if(chkStr == "1,0") {
                             ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
                        } else {
                        	ComShowCodeMessage('TES21906'); //showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                             return;
                        }
          	        break;
          	    case "btn_cost_ofc_cd" :
          	    	var formObject = document.form;
        			var cmdt_cd_val ="";   //향후 사용가능 예정변수
        			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
        			var cmdt_desc_val ="";   //향후 사용가능 예정변수
        			var classId ="getCOM_ENS_ofc";
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
        			ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getCostOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
        			break;
        	    	
          	    	//Expense/Volume Summary의 Cost office 팝업과 동일 (ESD_TES_0014.js)
//          	    	var formObject = document.form;
//          	    	var url_str;
//                    url_str = 'ESD_TES_9300Pop.screen'
//                    url_str = url_str + '?ofc_cd='+(formObject.cost_ofc_cd.value==""?ofc_cd:formObject.cost_ofc_cd.value);
//                    url_str = url_str + '&param_nm=cost_ofc_cd'
//                    window.showModalDialog(url_str,  window, "dialogWidth:425px; dialogHeight:440px; help:no; status:no; resizable:yes;");
//          	        break;
          	    	
          	   case "btn_inv_ofc_cd" :
          		   var formObject = document.form;
        			var cmdt_cd_val ="";   //향후 사용가능 예정변수
        			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
        			var cmdt_desc_val ="";   //향후 사용가능 예정변수
        			var classId ="getCOM_ENS_ofc";
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
        			ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 450, 'getInvOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
          	        break;

                case "btng_print":
                    if(sheetObject.RowCount<1){
                    	ComShowCodeMessage('TES21905'); //showErrMessage('조회된 Data가 없습니다.');
                        return false
                    }else{
                        printInvoiceSummary();
                    }

        	        break;

        	    case "btng_toinvcorrection":
        	        var inv_no = sheetObject.CellValue(sheetObject.SelectRow,'inv_no');
					var vndr_seq = sheetObject.CellValue(sheetObject.SelectRow,'vndr_seq');
					var tml_inv_tp_cd = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_tp_cd');
					var tml_inv_sts_cd = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_sts_cd');
					var formObj = document.form;

					if(inv_no==null || vndr_seq==null){
						ComShowCodeMessage('TES21907'); //showErrMessage("NO Row Selected");
					}

					if(checkValidOFC(sheetObject.CellValue(sheetObject.SelectRow,'inv_ofc_cd')) == false){
					    return false;
					}

                    //DB에 저장된 값이 아니라,, 화면에 보이는 값으로 검사해야..-_-ㅋ
					if(tml_inv_sts_cd == 'AR'){
						ComShowCodeMessage('TES21507','Approval Requested Invoice!');
					    return false;
					}else if(tml_inv_sts_cd == 'AP'){
						ComShowCodeMessage('TES21507','AP Interfaced Invoice!');
					    return false;
					}else if(tml_inv_sts_cd == 'PD'){
						ComShowCodeMessage('TES21507','Paid Invoice !');
					    return false;
					}

					if(sheetObject.CellValue(sheetObject.SelectRow, 'inv_ofc_del_flg') == 'Y'){
						ComShowMessage('The Invoice Office Code was deleted by MDM. Please contact with MDM.');
					    return false;
					}else if(sheetObject.CellValue(sheetObject.SelectRow, 'cost_ofc_del_flg') == 'Y'){
						ComShowMessage('The Cost Office Code was deleted by MDM. Please contact with MDM.');
					    return false;
					}else if(sheetObject.CellValue(sheetObject.SelectRow, 'yc_del_flg') == 'Y'){
						ComShowMessage('The Yard Code was deleted by MDM. Please contact with MDM.');
					    return false;
					}else if(sheetObject.CellValue(sheetObject.SelectRow, 'vndr_del_flg') == 'Y'){
						ComShowMessage('The S/P Code was deleted by MDM. Please contact with MDM.');
					    return false;
					}

					/** eBilling으로 추가 **/
					if(tml_inv_sts_cd == 'ER'){ // --> EDI로 정상적으로 수신된 invoice
						/** 2008-12-12 : AJ는 전환하지 않는다. **/
						if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_rjct_sts_cd')=='AJ'){
							ComShowMessage('Auto Rejected EDI Received Invoice.');
							return false;
						}
						document.form.tml_edi_so_ofc_cty_cd.value = sheetObject.CellValue(sheetObject.SelectRow,'tml_edi_so_ofc_cty_cd');
					    document.form.tml_edi_so_seq.value = sheetObject.CellValue(sheetObject.SelectRow,'tml_edi_so_seq');
						document.form.tml_inv_tp_cd.value = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_tp_cd');
						document.form.sndr_id.value = sheetObject.CellValue(sheetObject.SelectRow,'sndr_id');
						document.form.tml_inv_edi_seq.value = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_edi_seq');
						document.form.edi_rcv_rule_mn_seq.value = sheetObject.CellValue(sheetObject.SelectRow,'edi_rcv_rule_mn_seq');
						
		                var tmp_org_vndr_seq = '';
		                var tmp_org_inv_no = '';
		                tmp_org_vndr_seq = document.form.vndr_seq.value;
		                
		                document.form.vndr_seq.value = sheetObject.CellValue(sheetObject.SelectRow,'vndr_seq');
		                tmp_org_inv_no = document.form.inv_no.value;
		                document.form.inv_no.value = sheetObject.CellValue(sheetObject.SelectRow,'inv_no');
						doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
						/**
						 * <중> EDI Invoice의 정규 Invoice로의 전환시에는 
						 *  vndr_seq와 inv_no의 이전값으로 재설정
						 *  해당 invoice 생성화면으로 이동은 onSaveEnd에서 처리한다.
						 *  --> 구형 eBilling과 신형 eBilling 처리의 구분은 Invoice SC단에서 분기한다.
						 *  요기서 break......
						 */
	            		break;
					}
					if(tml_inv_tp_cd == 'TM' || tml_inv_tp_cd.substring(0,1)=='M'){
						location.href = "ESD_TES_0001.do?pgmNo=ESD_TES_0001&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=Marine Terminal Invoice Creaion %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
					}else if(tml_inv_tp_cd =='ON'){
					    location.href = "ESD_TES_0064.do?pgmNo=ESD_TES_0064&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=On-Dock Rail Charge Invoice Creation %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
					}else if(tml_inv_tp_cd =='OF'){
					    location.href = "ESD_TES_0004.do?pgmNo=ESD_TES_0004&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=Off Dock CY Invoice Creation %26 Correction&sysCommUiNavigation=TML S/O > Invoice > Invoice Creation';
					}else if(tml_inv_tp_cd =='ST' || tml_inv_tp_cd.substring(0,1)=='S'){
					    location.href = "ESD_TES_0009.do?pgmNo=ESD_TES_0009&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=Marine Terminal Storage Invoice Creation %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
					}
					
        	        break;

        	    case "btng_cntrlist":
					var inv_no = sheetObject.CellValue(sheetObject.SelectRow,'inv_no');
					var vndr_seq = sheetObject.CellValue(sheetObject.SelectRow,'vndr_seq');
					var tml_inv_tp_cd = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_tp_cd');

					if(inv_no==null || vndr_seq==null){
						ComShowMessage("NO Row Selected");
					}

					if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_sts_cd')=='ER'){
						ComShowMessage('EDI Received Invoice.');
					    return false;
					} else if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_rjct_sts_cd')=='AJ'){
						ComShowMessage('Auto Rejected EDI Received Invoice.');
					    return false;
					}
					
 		   	    	// AGMT/INV 권한 제어
 		   	    	document.form.no_ofc_cd.value = sheetObjects[0].CellValue(sheetObject.SelectRow, "inv_ofc_cd");
 		   	    	document.form.no_yd_cd.value  = sheetObjects[0].CellValue(sheetObject.SelectRow, "yd_cd");
 		   	    	
 		   	        /**2013.02.26 log-in office가 HAMUOG, SELCOT에서만 조회되도록 하드코딩 추가...1년 후 삭제 예정 **/
 		   	    	/** cre_ofc_cd가 HAMSEL로 되어 CNTR List가 조회안되는 문제 발생되어 원래 Office를 갖도록 수정함. 삭제 예정 **/
 		   	        /** cre_ofc_cd2에서 로그인 오피스 체크하는 걸로 수정함. 삭제 예정 **/
 		   	    	/** 그룹사 조직 코드 변경 HAMUOG->HAMRUO, SELCOT->SELOPA (2015-08-03) **/
 		   	    	if ((document.form.cre_ofc_cd.value == "HAMSEL") && (document.form.cre_ofc_cd2.value == "HAMRUO")) {
 		   	    		document.form.cre_ofc_cd.value = "HAMRUO";
 		   	    	} else if ((document.form.cre_ofc_cd.value == "HAMSEL") && (document.form.cre_ofc_cd2.value == "SELOPA")) {
 		   	    		document.form.cre_ofc_cd.value = "SELOPA";
 		   	    	}
 		   	    	
 		   	    	tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'goCntrList');

        	        break;

        	    case "btng_rejectlift" :
        	        if(checkValidOFC(sheetObject.CellValue(sheetObject.SelectRow,'inv_ofc_cd')) == false){
					    return false;
					}

					if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_sts_cd')=='ER'){
						ComShowMessage('EDI Received Invoice.');
					    return false;
					} else if(sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_rjct_sts_cd')=='AJ'){
						ComShowMessage('Auto Rejected EDI Received Invoice.');
					    return false;
					}

        	        if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_rjct_sts_cd") != 'RJ'){
        	        	ComShowMessage(ComGetMsg('TES40020')); //showErrMessage('Rejected invoice가 아닙니다.');
        	            return false;
        	        }
        	        if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'AP'){
        	        	ComShowMessage('AP Interfaced!');
        	            return false;
        	        }else if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'PD'){
        	        	ComShowMessage('Payed Invoice!');
        	            return false;
        	        }else if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'AR'){
        	        	ComShowMessage('AR Interfaced!');
        	            return false;
        	        }
        	        sheetObject.CellValue(sheetObject.SelectRow,"tml_inv_rjct_sts_cd") = 'RL';
        	        doActionIBSheet(sheetObject, formObject, IBSAVE);
        	        break;

        	    case "btng_delete" :
        	        
        	    	if(checkValidOFC(sheetObject.CellValue(sheetObject.SelectRow,'inv_ofc_cd')) == false){
					    return false;
					}        	        
        	        if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'AR'){
        	        	ComShowCodeMessage('TES40034','AR Interfaced.'); //showErrMessage('AR Interfaced. 삭제할 수 없습니다.');
        	            return false;
        	        }else if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'AP'){
        	        	ComShowCodeMessage('TES40034','AP Interfaced.'); //showErrMessage('AP Interfaced. 삭제할 수 없습니다.');
        	            return false;
        	        }else if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'PD'){
        	        	ComShowCodeMessage('TES40034','Payed Status.'); //showErrMessage('Payed Status. 삭제할 수 없습니다.');
        	            return false;
        	        }        	        
        	        if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_rjct_sts_cd") == 'RJ'){
        	        	ComShowCodeMessage('TES40034','Rejected invoice.'); //showErrMessage('Rejected invoice. 삭제할 수 없습니다.');
        	            return false;
        	        }
        	        sheetObject.RowStatus(sheetObject.SelectRow) = 'U';

        	        if(ComShowConfirm(ComGetMsg('TES21055'))){
	        	        if(sheetObject.CellValue(sheetObject.SelectRow, "tml_inv_sts_cd") == 'ER'){
	        	            formObject.tml_edi_so_ofc_cty_cd.value = sheetObject.CellValue(sheetObject.SelectRow, "tml_edi_so_ofc_cty_cd");
	        	            formObject.tml_edi_so_seq.value = sheetObject.CellValue(sheetObject.SelectRow, "tml_edi_so_seq");
	        	            doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
	        	        }else{
	        	            doActionIBSheet(sheetObject, formObject, IBDELETE);
	        	        }
	    	            sheetObject.RowDelete(sheetObject.SelectRow,false);
        	        }

					break;

        	    case "btng_downexcel":
    	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //showErrMessage("지금은 사용하실 수가 없습니다");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * pre_cond 조건 가져오기
     * @return 
     */
    function getPreviousRetreiveCondition(){
    	var retval = '';
    	if (document.form.inv_no.value!=null && document.form.inv_no.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_inv_no="+encodeURIComponent(document.form.inv_no.value);
    	}
    	if (document.form.inv_date_type!=undefined && document.form.inv_date_type.value!=null && document.form.inv_date_type.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_inv_date_type="+document.form.inv_date_type.value;
    	}
    	if (document.form.fm_prd_dt!=undefined && document.form.fm_prd_dt.value!=null && document.form.fm_prd_dt.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_fm_prd_dt="+document.form.fm_prd_dt.value;
    	}
    	if (document.form.to_prd_dt!=undefined && document.form.to_prd_dt.value!=null && document.form.to_prd_dt.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_to_prd_dt="+document.form.to_prd_dt.value;
    	}
    	if (document.form.yd_cd!=undefined && document.form.yd_cd.value!=null && document.form.yd_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_yd_cd="+document.form.yd_cd.value;
    	}
    	if (document.form.vndr_seq!=undefined && document.form.vndr_seq.value!=null && document.form.vndr_seq.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_vndr_seq="+document.form.vndr_seq.value;
    	}
    	if (document.form.cost_ofc_cd!=undefined && document.form.cost_ofc_cd.value!=null && document.form.cost_ofc_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_cost_ofc_cd="+document.form.cost_ofc_cd.value;
    	}
    	if (document.form.inv_ofc_cd!=undefined && document.form.inv_ofc_cd.value!=null && document.form.inv_ofc_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_inv_ofc_cd="+document.form.inv_ofc_cd.value;
    	}
    	if (document.form.tml_inv_sts_cd!=undefined && document.form.tml_inv_sts_cd.value!=null && document.form.tml_inv_sts_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_tml_inv_sts_cd="+document.form.tml_inv_sts_cd.value;
    	}
    	if (document.form.csr_no!=undefined && document.form.csr_no.value!=null && document.form.csr_no.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_csr_no="+document.form.csr_no.value;
    	}
    	if (document.form.csr_status!=undefined && document.form.csr_status.value!=null && document.form.csr_status.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_csr_status="+document.form.csr_status.value;
    	}
    	if (document.form.tml_inv_rjct_sts_cd!=undefined && document.form.tml_inv_rjct_sts_cd.value!=null && document.form.tml_inv_rjct_sts_cd.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_tml_inv_rjct_sts_cd="+document.form.tml_inv_rjct_sts_cd.value;
    	}
    	
    	return retval;
    }
    
     /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(ibsheet) sheet IBSheet Object
     * @return
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     * @return
     */
    function loadPage() {
    	 
    	 for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);    		 
    	 }
    	 
 		/**
 		 * 	2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
 		 *  Invoice 조회 화면에서 이동해 왔을 경우 바로 다시 Invoice 조회 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위한 값들. (2009-10-15)
 		 */
 		 try {
 			 pre_ret_cond_val = '';
 			 var retrieve_tf = false;
 			 var formObj = document.form;
 			 for (var i = 0; i < formObj.elements.length; i++){
 				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
 				     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
 				 {
 					 with (formObj) {
 						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
 							 eval(elements[i].name.substring('pre_cond_'.length,elements[i].name.length)).value = eval(elements[i].name).value;
 							 if (!retrieve_tf) {retrieve_tf = true;}
 						 }
 					 }
 				 }
 			 }
 			 validateYardCode();
 			 validateVNDRCode();
 			 if (retrieve_tf) {retrieve();}
 		 } catch(e){}    	 
 		 
    	 try {
    		 if (!(document.form.fm_prd_dt.value!=null && document.form.fm_prd_dt.value.trim()!='' && 
    			   document.form.to_prd_dt.value!=null && document.form.to_prd_dt.value.trim()!=''))
    		 {
    			 tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
    		 }
    	 } catch(e){}
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param (ibsheet) sheet 		IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     * @return
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
        case 1:      //sheet1 init
           with (sheetObj) {
               // 높이 설정
               style.height = 300;

               //전체 너비 설정
               SheetWidth = mainTable.clientWidth;

               //Host정보 설정[필수][HostIp, Port, PagePath]
               if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

               //전체Merge 종류 [선택, Default msNone]
               MergeSheet = msHeaderOnly;

               //마우스를 이용하여 데이터 영역을 블록으로 다중 선택 여부 설정  
               MultiSelection = false;
               
              //전체Edit 허용 여부 [선택, Default false]
               Editable = false;
               // CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)
               // INV RCV DT/ 2) INV ISS DT / 3) INV UPDT DT /4) INV CNFM DT /4) CSR RQST DT /5) CSR I/F DT
               //CSR No, CSR ST 추가(2006.12.15, 2007.01.29 메일 참고)
               var HeadTitle0 = " |SO OFC|SO SEQ|CSR\nNo.|CSR\nST|INV\nType|Tml INV TP Cd|Inv. No.|VVD|Inv\nST|REJ.|CRED\nDT|CRED\nUser ID|Inv. OFC||Cost OFC||Yard CD||CURR|INV RCV DT|INV ISS DT|INV UPDT DT|INV CNFM DT|CSR RQST DT|CSR I/F DT|P.\nD/Date|P.ST|Hold|Vendor||VAT AMT|WHT AMT|INV. AMT|Calculation Method (AMT)|Calculation Method (AMT)|Calculation Method (AMT)|RJCT RMK|EDI|Retroactive";
               var HeadTitle1 = " |SO OFC|SO SEQ|CSR\nNo.|CSR\nST|INV\nType|Tml INV TP Cd|Inv. No.|VVD|Inv\nST|REJ.|CRED\nDT|CRED\nUser ID|Inv. OFC||Cost OFC||Yard CD||CURR|INV RCV DT|INV ISS DT|INV UPDT DT|INV CNFM DT|CSR RQST DT|CSR I/F DT|P.\nD/Date|P.ST|Hold|Vendor||VAT AMT|WHT AMT|INV. AMT|Auto Calculated|Semi-updated|Manual Input|RJCT RMK|EDI|Retroactive";
               
               //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
               InitRowInfo( 2, 1, 9, 100);

               //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
               InitColumnInfo(46, 8, 0, true);
//               InitColumnInfo(ComCountHeadTitle(HeadTitle0), 8, 0, true);

               // 해더에서 처리할 수 있는 각종 기능([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
               InitHeadMode(true, true, false, true, false,false);


               //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
               InitHeadRow(0, HeadTitle0, true);
               InitHeadRow(1, HeadTitle1, true);

               //데이터속성     [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD,CALCULOGIC,DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
               InitDataProperty(0, cnt++, dtHiddenStatus,30,    daCenter,  true,    "ibflag");
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "tml_so_ofc_cty_cd",    false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "tml_so_seq",           false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,       130,    daCenter,  true,    "csr_no",               false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,       120,    daCenter,  true,    "csr_status",           false,          "",       dfNone,    0,     false,       false);

               InitDataProperty(0, cnt++, dtData,        50,    daCenter,  true,    "inv_tp_cd",            false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "tml_inv_tp_cd",        false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        150,    daCenter,  true,   "inv_no",               false,          "",       dfNone,    0,     false,       false);
/** (부산신항만의 요청)  : VVD 보이기 하기 **/
InitDataProperty(0, cnt++, dtData,        100,    daLeft,  true,     "vvd",               false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        30,    daCenter,  true,    "tml_inv_sts_cd",       false,          "",       dfNone,    0,     false,       false);
               
               InitDataProperty(0, cnt++, dtData,        30,    daCenter,  true,    "tml_inv_rjct_sts_cd",  false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        65,    daCenter,  true,    "cre_dt",               false,          "",       dfDateYmd, 0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        65,    daCenter,  true,    "cre_usr_id",           false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "inv_ofc_cd",           false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      60,    daCenter,  true,    "inv_ofc_del_flg",      false,          "",       dfNone,    0,     false,       false);

               InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "cost_ofc_cd",          false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      60,    daCenter,  true,    "cost_ofc_del_flg",     false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        70,    daCenter,  true,    "yd_cd",                false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      60,    daCenter,  true,    "yd_del_flg",           false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        45,    daCenter,  true,    "curr_cd",              false,          "",       dfNone,    0,     false,       false);

               InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "rcv_dt",               false,          "",       dfDateYmd, 0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "iss_dt",               false,          "",       dfDateYmd, 0,     false,       false);
               // CHM-201537539 Invoice IF Inquiry에서 조건 명칭 추가삭제변경 (조아영D 2015-08-25)
               InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "locl_upd_dt",               false,          "",       dfDateYmd, 0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "inv_cfm_dt",               false,          "",       dfDateYmd, 0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "ap_req_dt",               false,          "",       dfDateYmd, 0,     false,       false);

               InitDataProperty(0, cnt++, dtData,        80,    daCenter,  true,    "if_dt",               false,          "",       dfDateYmd, 0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        50,    daCenter,  true,    "pay_due_date",         false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        30,    daCenter,  true,    "pay_flg",              false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        35,    daCenter,  true,    "hld_flg",              false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        60,    daCenter,  true,    "vndr_seq",             false,          "",       dfNone,    0,     false,       false);
               
               InitDataProperty(0, cnt++, dtHidden,     60,    daCenter,  true,    "vndr_del_flg",         false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        60,    daRight ,  true,    "vat_amt",              false,          "",       dfFloat,   2,     false,       false);
               InitDataProperty(0, cnt++, dtData,        60,    daRight ,  true,    "whld_tax_amt",         false,          "",       dfFloat,   2,     false,       false);
               InitDataProperty(0, cnt++, dtData,        60,    daRight ,  true,    "ttl_inv_amt",          false,          "",       dfFloat,   2,     false,       false);
               InitDataProperty(0, cnt++, dtData,        110,    daRight ,  true,    "auto_calc_amt",        false,          "",       dfFloat,   2,     false,       false);
               
               InitDataProperty(0, cnt++, dtData,        100,    daRight ,  true,    "semi_auto_amt",        false,          "",       dfFloat,   2,     false,       false);
               InitDataProperty(0, cnt++, dtData,        100,    daRight ,  true,    "manual_amt",           false,          "",       dfFloat,   2,     false,       false);
               InitDataProperty(0, cnt++, dtData,        100,    daLeft,  true,     "inv_rjct_rmk",         false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        35,    daCenter,  true,    "edi_flg",              false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtData,        35,    daCenter,  true,    "rtro_tml_inv_flg",              false,          "",       dfNone,    0,     false,       false);
               
               InitDataProperty(0, cnt++, dtHidden,      35,    daCenter,  true,    "file_chk",              false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "tml_edi_so_ofc_cty_cd",false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "tml_edi_so_seq",       false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "sndr_id",       false,          "",       dfNone,    0,     false,       false);
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "tml_inv_edi_seq",       false,          "",       dfNone,    0,     false,       false);
               
               InitDataProperty(0, cnt++, dtHidden,      50,    daCenter,  true,    "edi_rcv_rule_mn_seq",       false,          "",       dfNone,    0,     false,       false);
          }
           break;
   }
}




  /**
   * Sheet 관련 프로세스 처리
   * param : sheetObj ==> 시트오브젝트, formObj ==> form, sAction ==> action 값   
   * @param(ibsheet) 	sheetObj 		IBSheet Object
   * @param(formObj) 	form			form object
   * @param(string) 	sAction			action 값
   * @return
   */  
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                 if(validateForm(sheetObj,formObj,sAction)){
                     formObj.f_cmd.value = SEARCH;
                     sheetObj.DoSearch4Post("ESD_TES_0013GS.do", tesFrmQryStr(formObj));
                 }
                 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++ ){
    	            if(sheetObj.CellValue(i,"tml_inv_rjct_sts_cd") == "RJ"){
    	                sheetObj.CellEditable(i,"chk") = true;
    	            }else{
    	                sheetObj.CellEditable(i,"chk") = false;
    	            }
    	        }
                break;

            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
                formObj.f_cmd.value = MODIFY;
                var param = sheetObj.GetSaveString();
		        var savexml = sheetObj.GetSaveXml("ESD_TES_0013GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(savexml,true);
				break;

			case IBDELETE:        //저장
                if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
                formObj.f_cmd.value = REMOVE;
                var param = sheetObj.GetSaveString();
		        var savexml = sheetObj.GetSaveXml("ESD_TES_0013GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(savexml,true);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;

			case IBSEARCH_ASYNC01:        //저장
                if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
				// ViewAdpter의 isSave 값에 대한 처리방법으로 인해 COMMAND01에서 REMOVE01로 변경. (2010-05-12)
				formObj.f_cmd.value = REMOVE01;
				var param = sheetObj.GetSaveString();
				var savexml = sheetObj.GetSaveXml("ESD_TES_0013GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(savexml,true);
				break;

			case IBSEARCH_ASYNC02:        //저장
                if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
	            formObj.f_cmd.value = MULTI02;
	            var param = sheetObj.GetSaveString();
	            var tmp_org_vndr_seq = '';
	            var tmp_org_inv_no = '';
	            //alert(param+'&'+tesFrmQryStr(formObj));
		        var savexml = sheetObj.GetSaveXml("ESD_TES_0013GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(savexml,true);
                break;
        }
    }

   /**
    * 
    * @param sheetObj
    * @return
    */
	function sheet1_OnSaveEnd(sheetObj){
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			//alert("srcName:"+srcName+"<<<<<<");
			if (srcName!=null && srcName=="btng_toinvcorrection"){
		        var inv_no = sheetObj.CellValue(sheetObj.SelectRow,'inv_no');
				var vndr_seq = sheetObj.CellValue(sheetObj.SelectRow,'vndr_seq');
				var tml_inv_tp_cd = sheetObj.CellValue(sheetObj.SelectRow,'tml_inv_tp_cd');
				if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y') {
					if(tml_inv_tp_cd == 'TM' || tml_inv_tp_cd.substring(0,1)=='M'){
						location.href = "ESD_TES_0001.do?pgmNo=ESD_TES_0001&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=Marine Terminal Invoice Creaion %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
					}else if(tml_inv_tp_cd =='ON'){
					    location.href = "ESD_TES_0064.do?pgmNo=ESD_TES_0064&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=On-Dock Rail Charge Invoice Creation %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
					}else if(tml_inv_tp_cd =='OF'){
					    location.href = "ESD_TES_0004.do?pgmNo=ESD_TES_0004&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=Off Dock CY Invoice Creation %26 Correction&sysCommUiNavigation=TML S/O > Invoice > Invoice Creation';
					}else if(tml_inv_tp_cd =='ST' || tml_inv_tp_cd.substring(0,1)=='S'){
					    location.href = "ESD_TES_0009.do?pgmNo=ESD_TES_0009&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)+'&sysCommUiTitle=Marine Terminal Storage Invoice Creation %26 Correction&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Invoice Creation';
					}
				}
			}
		} catch (e){
		}
	}
   
   /**
    * onclick event처리
    * @param sheetObj
    * @return
    */
	function sheet1_OnClick(sheetObj){
		try {
			if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y' && sheetObj.CellValue(sheetObj.SelectRow,'file_chk') == 'Y') {
				document.all.EDILayer01.style.display = "inline";
			} else {
				document.all.EDILayer01.style.display = "none";
			}
		} catch (e){
		}
	}

    /**
    * Sheet 선택 
    * 장부장님의 요청으로 click시만이 아니고 cursor를 grid상에서 keyboard로 이동할 때도 PDF file view button활성화 구현함 
    * param : sheetObj ==> 시트오브젝트
    * @param(ibsheet) 	sheetObj 		IBSheet Object
    * @return
    */  
    function sheet1_OnSelectCell(sheetObj){
		try {
			if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y' && sheetObj.CellValue(sheetObj.SelectRow,'file_chk') == 'Y') {
				document.all.EDILayer01.style.display = "inline";
			} else {
				document.all.EDILayer01.style.display = "none";
			}
		} catch (e){
		}
    }
    
    /**
     * Sheet 선택
     * param : sheetObj ==> 시트오브젝트
     * @param(ibsheet) 	sheetObj 		IBSheet Object
     * @return
     */  
    function sheet1_OnSearchEnd(sheetObj){
		if (sheetObj.RowCount > 0) {
			/**
			 * 조회 조건으로 조회가 성공적으로 된 경우만 pre_cond 조건에 넣는다.
			 */
			pre_ret_cond_val = getPreviousRetreiveCondition();
			
			try {
				if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y' && sheetObj.CellValue(sheetObj.SelectRow,'file_chk') == 'Y') {
					document.all.EDILayer01.style.display = "inline";
				} else {
					document.all.EDILayer01.style.display = "none";
				}
			} catch(e){
			}
		}
     	
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
        	if(sheetObj.CellValue(i,'inv_tp_cd')=='MR'){
                sheetObj.ToolTipText(i,'inv_tp_cd') = 'Marine Terminal';
            }else if(sheetObj.CellValue(i,'inv_tp_cd')=='ON' || sheetObj.CellValue(i,'inv_tp_cd')=='RC'){
                sheetObj.ToolTipText(i,'inv_tp_cd') = 'On-dock Rail Charge';
            }else if(sheetObj.CellValue(i,'inv_tp_cd')=='OC'){
                sheetObj.ToolTipText(i,'inv_tp_cd') = 'Off dock CY';
            }else if(sheetObj.CellValue(i,'inv_tp_cd')=='MS'){
                sheetObj.ToolTipText(i,'inv_tp_cd') = 'Marine Terminal Storage';
            }

            if(sheetObj.CellValue(i,'tml_inv_sts_cd')=='RC'){
                sheetObj.ToolTipText(i,'tml_inv_sts_cd') = 'Received';
            }else if(sheetObj.CellValue(i,'tml_inv_sts_cd')=='CF'){
                sheetObj.ToolTipText(i,'tml_inv_sts_cd') = 'Confirmed';
            }else if(sheetObj.CellValue(i,'tml_inv_sts_cd')=='AR'){
                sheetObj.ToolTipText(i,'tml_inv_sts_cd') = 'Approval Requested';
            }else if(sheetObj.CellValue(i,'tml_inv_sts_cd')=='AP'){
                sheetObj.ToolTipText(i,'tml_inv_sts_cd') = 'AP Interfaced';
            }else if(sheetObj.CellValue(i,'tml_inv_sts_cd')=='PD'){
                sheetObj.ToolTipText(i,'tml_inv_sts_cd') = 'Paid';
            }else if(sheetObj.CellValue(i,'tml_inv_sts_cd')=='ER'){
                sheetObj.ToolTipText(i,'tml_inv_sts_cd') = 'EDI Received';
            }

            if(sheetObj.CellValue(i,'tml_inv_rjct_sts_cd')=='NL'){
                sheetObj.ToolTipText(i,'tml_inv_rjct_sts_cd') = 'Normal';
            }else if(sheetObj.CellValue(i,'tml_inv_rjct_sts_cd')=='RJ'){
                sheetObj.ToolTipText(i,'tml_inv_rjct_sts_cd') = 'Rejected';
            }else if(sheetObj.CellValue(i,'tml_inv_rjct_sts_cd')=='RL'){
                sheetObj.ToolTipText(i,'tml_inv_rjct_sts_cd') = 'Reject Lifted';
            }else if(sheetObj.CellValue(i,'tml_inv_rjct_sts_cd')=='AJ'){
                sheetObj.ToolTipText(i,'tml_inv_rjct_sts_cd') = 'Auto Rejected';
            }
        }

		/** eBilling ---- B **/
        setTooltip(sheetObj,'vvd|inv_rjct_rmk');
		/** eBilling ---- E **/

    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param(ibsheet) 	sheetObj 		IBSheet Object
     * @param(formObj) 	form			form object
     * @param(string) 	sAction			action 값  
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }

    /**
     * 기간체크 함수
     * @return
     */
	function setPeriodFromTo(){
		/* from 한달전 ~ to 오늘 */
		var formObj = document.form;
		var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
		var fr_dt;
		if (to_dt!=undefined && to_dt!=null && to_dt.trim()!='' && to_dt.length==8){
			//fr_dt = tes_getDiffDate(to_dt, -30, 'D');
			fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
			if (fr_dt!=undefined && fr_dt!=null && fr_dt.trim()!='' && fr_dt.length==8){
				if (fr_dt.substring(6,8) > ComGetLastDay(parseInt(fr_dt.substring(0,4), 10),parseInt(fr_dt.substring(4,6), 10))){
					fr_dt = fr_dt.substring(0,6) + ComGetLastDay(parseInt(fr_dt.substring(0,4), 10),parseInt(fr_dt.substring(4,6), 10));
				}
				
				formObj.fm_prd_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
				formObj.to_prd_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
			}
		}
	}

    /**
     * 리포트에서 프린트할때 사용
     * @return
     */    
	function printInvoiceSummary(){
    	
	    var fromObj  = new Array();
	    var rdObj    = new Array();
	    var paramObj = new Array();
	    
	    fromObj[0] = document.form;
	    rdObj[0] = sheetObjects[0];

	    //RD로 보내기 위한 설정
	    paramObj[0] = "1";
	    paramObj[1] = "";
	    paramObj[2] = "N";
	    paramObj[3] = RD_path+"apps/alps/esd/tes/serviceproviderinvoicemanage/marineterminalinvoicemanage/report/ESD_TES_0801.mrd";
	    paramObj[4] = rdObj;
	    paramObj[5] = fromObj;
	    
	    rdObjModaless(RdReport, paramObj, 1100, 900);
	}

    /**
    * 사용자가 입력한 검색조건 날짜를 받아서 From Date가 To Date보다 크게 입력되었는지 확인한다.
    * @return
    */ 
	function chkPeriod(){
	    var formObj = document.form;
	    var is_valid=0;
	    var fromVal = formObj.fm_prd_dt.value;
	    var toVal = formObj.to_prd_dt.value;

	    if(fromVal!=null && fromVal!="" && toVal!=null && toVal!=""){
		    is_valid = ComGetDaysBetween(fromVal, toVal);
		    if(is_valid<0){
		        formObj.to_prd_dt.value = '';
		        ComAlertFocus(formObj.fm_prd_dt, "From Date is Later than To Date");
		    }
	    }
	}

	/**
	 * 사용자가 VNDR Seq를 직접 입력할 경우 해당VNDR Name을 화면에 보여준다.
	 * @param(object) obj	input object
	 * @return
	 */
	 function getVndrName(obj){
	     var formObj = document.form;
	     if(tes_getStrLen(obj.value) == 6){
	         if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()==''){
	             formObj.vndr_seq_hidden.value = '';
	             formObj.is_valid_vndr_seq.value = '';
	             return false;
	         }
	         if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim()){
	             formObj.vndr_seq_hidden.value = '';
	             formObj.is_valid_vndr_seq.value = '';
	             tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
	         }
	     }
	 }

	/**
	 *  vndr code 값의 유효성을 체크함 
	 *	@return
	 */
	 function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
//		showErrMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
				formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowCodeMessage('TES21511'); //showErrMessage('유효하지 않은 VNDR Code입니다.');
			formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					formObj.vndr_seq.focus();

		}
	}

	/**
	 *  yard 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 
	 function getYard(rowArray) {
        //showErrMessage("getYard");
    	var colArray = rowArray[0];
    	document.all.yd_cd.value = colArray[3];
    	//document.all.yd_cd_name.value = colArray[4];
     }
	 
	/**
	 *  vndr code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */
     function getVender(rowArray) {
       // showErrMessage("getVender");
    	var colArray = rowArray[0];
    	//document.all.vndr_seq.value = colArray[2].substr(2,6);
    	document.all.vndr_seq.value = colArray[6];
    	document.all.vndr_seq_name.value = colArray[4];
     }

	/**
	 *  office code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 
     function getOffice(rowArray){
        //showErrMessage("getOffice");
        var colArray = rowArray[0];
        document.all.cost_ofc_cd = colArray[3];
     }

	/**
	 *  cost code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 	 
     function getCostOfc(rowArray) {

		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			document.form.cost_ofc_cd.value = colArray[3];
		}

	 }

	/**
	 *  invoice code 값을 가져옴
	 *  @param(array}	rowArray	array object
	 *	@return
	 */	 	 
	 function getInvOfc(rowArray) {
		var formObject = document.form;

		for(var i=0; i<rowArray.length; i++)
		{
			var colArray = rowArray[0];
			document.form.inv_ofc_cd.value = colArray[3];
		}

	 }


	/**
	 *  yard code 값 null, '' 체크
	 *	@return	 
	 */	 
    function validateYardCode() {
        var formObj = document.form;
        if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == ''){
            formObj.yd_cd_hidden.value = '';
            formObj.is_valid_yd_cd.value = '';
            return false;
        }
        if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim()){
            formObj.yd_cd_hidden.value = '';
            formObj.is_valid_yd_cd.value = '';
            tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');
        }
    }

	/**
	 *  yard code 값 유효성 체크
	 *	@return
	 */	    
	function checkValidYardCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){
					formObj.yd_cd_hidden.value = formObj.yd_cd.value;

					formObj.yd_cd_deltflg.value = (tmp[9]!=undefined&&tmp[9]!=null?tmp[9]:'');

					if(formObj.yd_cd_deltflg.value=="Y"){
						ComShowMessage('Deleted Yard Code!');
					}

				} else {
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';
					formObj.yd_cd.value = '';
					ComShowMessage(ComGetMsg('TES10066'));
				}
			} else {
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				formObj.yd_cd.value = '';
				ComShowMessage(ComGetMsg('TES10066'));
			}
		} else {
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			formObj.yd_cd.value = '';
			ComShowMessage(ComGetMsg('TES10066'));
		}
	}


	/**
	 *  yard code 값 null, '' 체크
	 *	@return
	 */	 
	function validateVNDRCode() {
        var formObj = document.form;
        if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == ''){
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            return false;
        }
		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value, 6, 0);
		}
        if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim()){
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVNDRCode');
        }
    }

	/**
	 *  yard code 값 유효성 체크
	 *	@return
	 */	 	
	function checkValidVNDRCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;

					formObj.vndr_seq_deltflg.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');

					if(formObj.vndr_seq_deltflg.value=="Y"){
						ComShowMessage('Deleted S/P Code!');
					}
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					ComShowMessage(ComGetMsg('TES10067'));//msgs['TES10067'] = '유효하지 않은 VendorCode입니다.' ;
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				ComShowMessage(ComGetMsg('TES10067'));
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			ComShowMessage(ComGetMsg('TES10067'));
		}
	}

	/**
	 *  cost code 값 null, '' 체크 
	 *	@return
	 */	 	
	function validateCostOFCCode() {
        var formObj = document.form;
        if (formObj.cost_ofc_cd.value==null || formObj.cost_ofc_cd.value.trim() == ''){
            formObj.cost_ofc_cd_hidden.value = '';
            formObj.is_valid_cost_ofc_cd.value = '';
            return false;
        }
        if ((formObj.cost_ofc_cd_hidden.value==null || formObj.cost_ofc_cd_hidden.value.trim()=='') || formObj.cost_ofc_cd.value.trim()!=formObj.cost_ofc_cd_hidden.value.trim()){
            formObj.cost_ofc_cd_hidden.value = '';
            formObj.is_valid_cost_ofc_cd.value = '';
            tes_getInputValue('is_valid_cost_ofc_cd', SEARCHLIST02, 'cost_ofc_cd', 'checkValidCostOFCCode');
        }
    }

	/**
	 *  cost code 값 유효성 체크 
	 *	@return
	 */		
    function checkValidCostOFCCode(){
		var formObj = document.form;
		var tmp = '';
		
		if (formObj.is_valid_cost_ofc_cd.value!=undefined && formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value.trim()!=''){
			tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_cost_ofc_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value == 'Y'){
					formObj.cost_ofc_cd_hidden.value = formObj.cost_ofc_cd.value;


					formObj.cost_ofc_cd_deltflg.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');

					if(formObj.cost_ofc_cd_deltflg.value=="Y"){
						ComShowMessage('Deleted Office Code!');
					}

				} else {
					formObj.is_valid_cost_ofc_cd.value = '';
					formObj.cost_ofc_cd_hidden.value = '';
					formObj.cost_ofc_cd.value = '';
					ComShowCodeMessage('TES40052', 'Cost Office Code');
				}
			} else {
				formObj.is_valid_cost_ofc_cd.value = '';
				formObj.cost_ofc_cd_hidden.value = '';
				formObj.cost_ofc_cd.value = '';
				ComShowCodeMessage('TES40052', 'Cost Office Code');
			}
		} else {
			formObj.is_valid_cost_ofc_cd.value = '';
			formObj.cost_ofc_cd_hidden.value = '';
			formObj.cost_ofc_cd.value = '';
			ComShowCodeMessage('TES40052', 'Cost Office Code');
		}
	}

	/**
	 *  invoice office code 값 null, '' 체크 
	 *	@return
	 */	    
    function validateInvOFCCode() {
        var formObj = document.form;
        if (formObj.inv_ofc_cd.value==null || formObj.inv_ofc_cd.value.trim() == ''){
            formObj.inv_ofc_cd_hidden.value = '';
            formObj.is_valid_inv_ofc_cd.value = '';
            return false;
        }
        if ((formObj.inv_ofc_cd_hidden.value==null || formObj.inv_ofc_cd_hidden.value.trim()=='') || formObj.inv_ofc_cd.value.trim()!=formObj.inv_ofc_cd_hidden.value.trim()){
            formObj.inv_ofc_cd_hidden.value = '';
            formObj.is_valid_inv_ofc_cd.value = '';
            tes_getInputValue('is_valid_inv_ofc_cd', SEARCHLIST03, 'inv_ofc_cd', 'checkValidInvOFCCode');
        }
    }

	/**
	 *  invoice office 값 유효성 체크 
	 *	@return
	 */	    
	function checkValidInvOFCCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_inv_ofc_cd.value!=undefined && formObj.is_valid_inv_ofc_cd.value!=null && formObj.is_valid_inv_ofc_cd.value.trim()!=''){
			tmp = formObj.is_valid_inv_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_inv_ofc_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_inv_ofc_cd.value!=null && formObj.is_valid_inv_ofc_cd.value == 'Y'){
					formObj.inv_ofc_cd_hidden.value = formObj.inv_ofc_cd.value;

					formObj.inv_ofc_cd_deltflg.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');

					if(formObj.inv_ofc_cd_deltflg.value=="Y"){
						ComShowMessage('Deleted Office Code!');
					}

				} else {
					formObj.is_valid_inv_ofc_cd.value = '';
					formObj.inv_ofc_cd_hidden.value = '';
					formObj.inv_ofc_cd.value = '';
					ComShowCodeMessage('TES40052', 'Invoice Office Code');
				}
			} else {
				formObj.is_valid_inv_ofc_cd.value = '';
				formObj.inv_ofc_cd_hidden.value = '';
				formObj.inv_ofc_cd.value = '';
				ComShowCodeMessage('TES40052', 'Invoice Office Code');
			}
		} else {
			formObj.is_valid_inv_ofc_cd.value = '';
			formObj.inv_ofc_cd_hidden.value = '';
			formObj.inv_ofc_cd.value = '';
			ComShowCodeMessage('TES40052', 'Invoice Office Code');
			
		}
	}

	/**
	 *  office code 와 invoice office code 유효성 검사
	 *  @param(inv_ofc_cd) invice office code 
	 *	@return
	 */	 
	function checkValidOFC(inv_ofc_cd){
	    if(ofc_cd == ''){
	    	ComShowMessage('No Inv OFC data is found in the session');
	        return false;
	    }
	    if(inv_ofc_cd == undefined || inv_ofc_cd == null || inv_ofc_cd.trim() == ''){
	    	ComShowMessage("Inv OFC data does not exist at the selected invoice!");
	        return false;
	    }
	    if(ofc_cd != inv_ofc_cd){
	    	ComShowMessage(ComGetMsg('TES21050'));	
	        return false;
	    }
	    return true;
	}

	/**
	 *  enter 체크해서 처리하는 부분
	 *  @param(funcNm) function name
	 *	@return
	 */	 
	function enterCheck(funcNm){
		if (event.keyCode == 13){
			retrieve();
		}        
	}
	 
 	 /** goCntrList()
	  * 
	  * @return
	  */
	function goCntrList(){
		var sheetObject = sheetObjects[0];
		var inv_no = sheetObject.CellValue(sheetObject.SelectRow,'inv_no');
		var vndr_seq = sheetObject.CellValue(sheetObject.SelectRow,'vndr_seq');
		var tml_inv_tp_cd = sheetObject.CellValue(sheetObject.SelectRow,'tml_inv_tp_cd');
		
		if(document.form.auth_ofc_cd.value.trim()=="Y"){
			if(tml_inv_tp_cd == 'TM'){
			    location.href = "ESD_TES_0017.do?pgmNo=ESD_TES_0017&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq
			    				+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
			    				+'&sysCommUiTitle=Marine Terminal Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			}else if(tml_inv_tp_cd =='ON'){
			    location.href = "ESD_TES_0068.do?pgmNo=ESD_TES_0068&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq
			    				+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
			    				+'&sysCommUiTitle=On-Dock Rail Charge Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			}else if(tml_inv_tp_cd =='OF'){
			    location.href = "ESD_TES_0018.do?pgmNo=ESD_TES_0018&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq
			    				+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
			    				+'&sysCommUiTitle=Off-Dock CY Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			}else if(tml_inv_tp_cd =='ST'){
			    location.href = "ESD_TES_0019.do?pgmNo=ESD_TES_0019&inv_no="+encodeURIComponent(inv_no)+"&vndr_seq="+vndr_seq
			    				+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
			    				+'&sysCommUiTitle=Marine Terminal Storage Container List&sysCommUiNavigation=TML S/O > Invoice > Container List Inquiry';
			}
	    }else{
	    	ComShowMessage(ComGetMsg('TES21051'));
	    }
				
	}
	
    function getSubOffice1(){
    	if(document.form.sub_office1.checked == true){
    		if(document.form.cost_ofc_cd.value != ''){
    			document.form.ofc_cd.value = document.form.cost_ofc_cd.value;
    			tes_getInputValue('sub_ofc_cd1', SEARCHLIST15, 'ofc_cd', 'setSubOffice1');
    		} else {
    			ComShowMessage('Please enter Cost Office.');
				document.form.sub_office1.checked = false;
    		}
    	} else {
    		document.form.sub_ofc_cd1.value = '';
    		document.form.cost_ofc_cd.value = '';
    	} 
    }
    
    function setSubOffice1(){
    	if(document.form.sub_ofc_cd1.value != ''){
    		document.form.cost_ofc_cd.value = document.form.sub_ofc_cd1.value;
    	}
    }
    	
    function getSubOffice2(){
		if(document.form.sub_office2.checked == true){
			if(document.form.inv_ofc_cd.value != ''){
				document.form.ofc_cd.value = document.form.inv_ofc_cd.value;
				tes_getInputValue('sub_ofc_cd2', SEARCHLIST15, 'ofc_cd', 'setSubOffice2');
			} else {
				ComShowMessage('Please enter Invoice Office.');
				document.form.sub_office2.checked = false;
			}
		} else {
			document.form.sub_ofc_cd2.value = '';
			document.form.inv_ofc_cd.value = '';
		}  	
    }
    
    function setSubOffice2(){
    	if(document.form.sub_ofc_cd2.value != ''){
    		document.form.inv_ofc_cd.value = document.form.sub_ofc_cd2.value;
    	}
    }
    
