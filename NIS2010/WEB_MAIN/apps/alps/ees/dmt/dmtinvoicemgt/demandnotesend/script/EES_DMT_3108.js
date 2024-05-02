/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3108.js
*@FileTitle : Demand Note Issue by Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.25 최성환
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
     * @class EES_DMT_3108 : EES_DMT_3108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_3108() {
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
	//공통전역변수
    var rdObjects = new Array();
    var rdCnt = 0;
    
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	var ROWMARK = "|";
	var FIELDMARK = "=";
	
	//Action 정의
	var IBSEARCH_INIT = 100;		
	var IBSEARCH02    = 51;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
		var sheetObject1 = sheetObjects[0];
          
		/*******************************************************/
		/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	            case "btn_payer_cd":
	         		openPopup('s_cust_cd');
					break;
				
	            case "btn_set":
	            	if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
					break; 
				
            	case "btn_option":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
            		break;
            		
            	case "btn_sendinghistory":
            		if(ComIsBtnEnable(srcName)) {
            			openPopupWindow(sheetObject1, formObject, srcName);
            		}
            		break;            		
					
            	case "btn_preview":
					if(ComIsBtnEnable(srcName)) {
						//Data 가 없을 때 
						if(sheetObject1.RowCount == 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						
						//Payer Code, INV Cur. 정보가 없을 경우 “Pls update Payer code first!” Alert창 띄우며 막음
						var payerCd = ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							//Sheet Set 데이타가 없을 경우
							if (!validateSheetSetForGroup()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
							ComOpenPopupWithTarget('/hanjin/EES_DMT_3007.do', 920, 740, "", "0,1,1,1,1,1,1", true);
						}
					}
					break;
					
				case "btn_print":
					if(ComIsBtnEnable(srcName)) {
						//Data 가 없을 때 
						if(sheetObject1.RowCount == 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						
						//Payer Code, INV Cur. 정보가 없을 경우 “Pls update Payer code first!” Alert창 띄우며 막음
						var payerCd = ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							//Sheet Set 데이타가 없을 경우
							if (!validateSheetSetForGroup()) {
								ComShowCodeMessage('DMT01096');
								return false;
							}
		 					//ComOpenWait Start
		 					sheetObject1.WaitImageVisible=false;
		 		        	ComOpenWait(true);
							//init RD config
							initRdConfig(rdObjects[0]);
							rdOpen();
							
							//ComOpenWait End
							ComOpenWait(false);
						}
					}
					break;
					
				case "btn_fax":
					if(ComIsBtnEnable(srcName)) {
						//Data 가 없을 때 
						if(sheetObject1.RowCount == 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						
						//Sheet Set 데이타가 없을 경우
						if (!validateSheetSetForGroup()) {
							ComShowCodeMessage('DMT01096');
							return false;
						}
						
						sendFaxEmail("fax");
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;
					
				case "btn_email":
					if(ComIsBtnEnable(srcName)) {
						//Data 가 없을 때 
						if(sheetObject1.RowCount == 0){
							ComShowCodeMessage('DMT00164');
							return false;
						}
						
						//Sheet Set 데이타가 없을 경우
						if (!validateSheetSetForGroup()) {
							ComShowCodeMessage('DMT01096');
							return false;
						}
						sendFaxEmail("email");
						openPopupWindow(sheetObject1, formObject, srcName);
					}
					break;																														

				case "btn_payerfaxemail":
					if(ComIsBtnEnable(srcName)) {
						//Payer Code, INV Cur. 정보가 없을 경우 “Pls update Payer code first!” Alert창 띄우며 막음
						var payerCd = ComGetObjValue(formObject.payer_cd);
						if(payerCd == ''){
							ComShowCodeMessage('DMT00182');
							ComSetFocus(formObject.payer_cd);
							return;
						} else {
							openPopupWindow(sheetObject1, formObject, srcName);
						}
					}
					break; 
					
				case "btn_close":
					window.close();
					break;
					
				case "btn_down_excel":
					//Data 가 없을 때 
					if(sheetObject1.RowCount == 0){
						ComShowCodeMessage('DMT00164');
						return false;
					}
					
					sheetObject1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'check_box');
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
	 * Sheet Set 데이터여부를 판단한다. 데이터가 없을 경우 RD처리를 하지 않는다. 
	 */
	function validateSheetSetForGroup(){
		var formObj = document.form;
		var opnSheetObj = document.sheet1;
		var sheetObj = sheetObjects[1];  // Group 호출 시 사용.
		makeDataByGroup(formObj, opnSheetObj, sheetObj);
		
		// Group Sheet Set 확인 - 전체가 없으면  alert MSG
   	  	if(  ComGetObjValue(formObj.ofc_add01) == ''
    		  && ComGetObjValue(formObj.ofc_add02) == '' 
    		  && ComGetObjValue(formObj.ofc_add03) == '' 
    		  && ComGetObjValue(formObj.header01) == '' 
    		  && ComGetObjValue(formObj.header02) == '' 
    		  && ComGetObjValue(formObj.header03) == '' 
    		  && ComGetObjValue(formObj.header04) == '' 
    		  && ComGetObjValue(formObj.header05) == '' 
    		  && ComGetObjValue(formObj.header06) == '' 
    		  && ComGetObjValue(formObj.header07) == '' 
    		  && ComGetObjValue(formObj.header08) == '' 
    		  && ComGetObjValue(formObj.header09) == '' 
    		  && ComGetObjValue(formObj.header10) == '' ){
    		 //ComShowCodeMessage('DMT01096');  
    		 return false;
   	  	} 
   	  	return true;
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
	
	/**
     * call rd report
     * @param rdObject
     * @return
     */
	function rdOpen(){
    	 var formObj = document.form;
//    	 var opener = window.dialogArguments;
//    	 var opnSheetObj = opener.document.sheet1;
    	 var opnSheetObj = document.sheet1;
    	 var sheetObj = sheetObjects[1];  // Group 호출 시 사용.
//    	 var sheetObj2 = sheetObjects[1]; // Booking 호출시 사용.

    	 previewByGroup(formObj, opnSheetObj, sheetObj);
	}   		
    /**
     * preview By Demand Group 
     */  
	function previewByGroup(formObj, opnSheetObj, sheetObj){
		 //데이터 정의 
    	makeDataByGroup(formObj, opnSheetObj, sheetObj);
		 //rd에게 넘기는 파람값 셋팅.(preview/fax/email 같이 사용.)
    	 //faxEmailByGroup(formObj, opnSheetObj, sheetObj);
    	//부모화면에서 다수의 bkg_no를 get방식으로 받지 않고 자식 창에서 직접 부모를 호출하여 가져온다.
		var bkgNos 		= "";
    	var cntrNos 	= "";
  		var chkRows 	= opnSheetObj.FindCheckedRow(1).split("|");
  		var usr_cnt_cd  = ComGetObjValue(formObj.usr_cnt_cd);
  		for(var i=0; i < chkRows.length-1; i++) {
  			bkgNos  += ','+opnSheetObj.CellValue(chkRows[i], "bkg_no");
  			cntrNos += ','+opnSheetObj.CellValue(chkRows[i], "cntr_no");
  		}
  		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
  		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
  		//rd_fxeml_rd_param 셋팅 rd report 표현 할 때 사용.
  		var rdRaram = " /rp  [" + ComGetObjValue(formObj.ofc_cd) 								+"]" +
  		 				  " [" + ComGetObjValue(formObj.dmdt_trf_cd) 							+"]" +
  		 				  " [" + ComReplaceStr(ComGetObjValue(formObj.dmdt_chg_sts_cd), "R", "L") 	+"]" +
  		 				  " [" + ComGetObjValue(formObj.bkg_no) 								+"]" +
  		 				  " [" + ComGetObjValue(formObj.cntr_no) 								+"]" +
  		 				" [" + ComGetObjValue(formObj.ofc_add01)					+"]" +	
  		 				" [" + ComGetObjValue(formObj.ofc_add02) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.ofc_add03) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.print_date) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_nm)			 			+"]" +
  		 				" [" + ComGetObjValue(formObj.address01) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address04) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm) 		+"]" +
  		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_phn_no) 		+"]" +
  		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_fax_no) 		+"]" +
  		 				" [" + ComGetObjValue(formObj.hjs_ref) 						+"]" +
  		 				" [" + ComGetObjValue(formObj.payer_cd) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_vat) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header01) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header02) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header03) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header04) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header05) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header06) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header07) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header08) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header09) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.header10) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.dmdt_trf_cd) 					+"]" +
  		 				" [(" + ComGetObjValue(formObj.dmdt_trf_nm) 				+")]" +
  		 				" [" + ComGetObjValue(formObj.inv_chg_amt) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.tax_rto_dis) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.tot_tax_amt) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.tot_payable_amt) 				+"]" +
  		 				" [" + ComGetObjValue(formObj.inv_curr_cd) 					+"]" +
  		 				" [" + ComGetObjValue(formObj.bil_to_loc_div_cd) 			+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_ref_prn_flg) 			+"]" +
  		 				" [" + ComGetObjValue(formObj.phn_fax_prn_flg) 				+"]" +
  		 				" [" + ComGetObjValue(formObj.cust_vat_prn_flg) 			+"]" +
  		 				" [" + ComGetObjValue(formObj.tax_amt_prn_flg) 				+"]" +
  		 				" [" + ComGetObjValue(formObj.dc_amt_prn_flg) 				+"]" +
  		 				" [*** " + ComGetObjValue(formObj.title) 					+" ***]" +
  		 				" [" + ComGetObjValue(formObj.rd_ida_expn_tax_rt)	+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_ida_expn_tax)		+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_ida_edu_tax_rt)	+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_ida_edu_tax)			+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_ida_high_edu_tax_rt)	+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_ida_high_edu_tax)		+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_tax_rgst_no)			+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_svc_cate_rmk)			+"]" +
  		 				" [" + ComGetObjValue(formObj.rd_pmnt_acct_no)			+"]" +
  		 				" /rv TAX_NM[" + ComGetObjValue(formObj.tax_nm)				+"]" 
  		 			   ;
  		 //ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdRaram);
  		 ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServerBAT + rdRaram);
    	 var rdParm = ComGetObjValue(formObj.rd_fxeml_rd_param);
//    	 ComDebug(rdParm);
    	 //RD - Right
    	 if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
    		 if (usr_cnt_cd == 'IN') {
    		     rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3908.mrd', RDServerIP+" "+ rdParm);
    		 }else{
    			 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3904.mrd', RDServerIP+" "+ rdParm);
    		 }
    	 } 
    	 //RD - Left
    	 else {
    		 if (usr_cnt_cd == 'IN') {
    		     rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3907.mrd', RDServerIP+" "+ rdParm);
    		 }else{
    			 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/demandnotesend/report/EES_DMT_3903.mrd', RDServerIP+" "+ rdParm);
    		 }
    	 }
    	 //rd print
    	 rdObjects[0].PrintDialog();
	}
	
	/**
     * RD를 위한 데이터 호출 및 리셋 
     */    
	function makeDataByGroup(formObj, opnSheetObj, sheetObj){
		
		// payer_cd 가 6자리 vendor일 경우 00을 추가. 아래 조회 시때만 사용.
		ComSetObjValue(formObj.tmp_payer_cd, ComGetObjValue(formObj.payer_cd));
		if(ComGetObjValue(formObj.payer_cd).length == 6) {
			ComSetObjValue(formObj.payer_cd, "00" + ComGetObjValue(formObj.payer_cd));
		}

		formObj.f_cmd.value = SEARCH01;
        var sXml =  sheetObj.GetSearchXml("EES_DMT_3007GS.do",	FormQueryString(formObj));
        sheetObj.LoadSearchXml(sXml);
        //서버에서 받아온 etc 데이터를 한번에 form 에 전달.
        ComEtcDataToForm(formObj, sheetObj);
        
        // 조회 후에 payer_cd를 이전 값으로 다시  리셋.
        ComSetObjValue(formObj.payer_cd, ComGetObjValue(formObj.tmp_payer_cd));
        
        //서버에서 받아온 값 : address01 : DONGSHIN MARITIME AGENCY CO.,LTD.|SEJONG B/D 100 DANGJOO-DONG, JONGRO-GU, SEOUL, KOREA
        //"|" 을 기준으로 cust_nm 및 address01로 다시 변수에 리셋함
   	  	if (!ComIsEmpty ( ComGetObjValue(formObj.address01) )) {	
   	  		var temp = ComGetObjValue(formObj.address01).split("|");
		  	ComSetObjValue(formObj.cust_nm,		temp[0]);			
		  	ComSetObjValue(formObj.address01, 	temp[1]);	
	  	} 
   	  	else {
   	  		ComSetObjValue(formObj.cust_nm,		"");			
   	  		ComSetObjValue(formObj.address01, 	"");	   	  			
	  	}
   	  	
   	  	//주소데이터를  엔터값을 구분자로 분리처리함.  
   	  	if (!ComIsEmpty(ComGetObjValue(formObj.address01))) {
   	  		var paryInfoAddr = ComGetObjValue(formObj.address01).split("\n");
   	  		var paryInfoAddrCnt = paryInfoAddr.length;
   	  		if ( paryInfoAddrCnt >= 1 ) {
   	  			document.form.address01.value = ComReplaceStr(paryInfoAddr[0],"'"," ");
   	  		} else {
   	  			document.form.address01.value = "";
   	  		}
   	  		if ( paryInfoAddrCnt >= 2 ) {
   	  			document.form.address02.value = ComReplaceStr(paryInfoAddr[1],"'"," ");
   	  		} else {
   	  			document.form.address02.value = "";
   	  		}
   	  		if ( paryInfoAddrCnt >= 3 ) {
   	  			document.form.address03.value = ComReplaceStr(paryInfoAddr[2],"'"," ");
   	  		} else {
   	  			document.form.address03.value = "";
	        }
   	  		if ( paryInfoAddrCnt >= 4 ) {
   	  			document.form.address04.value = ComReplaceStr(paryInfoAddr[3],"'"," ");
	        } else {
	        	document.form.address04.value = "";
	        }
   	  	} 
   	  	else {
			document.form.address01.value = "";
			document.form.address02.value = "";
			document.form.address03.value = "";
			document.form.address04.value = "";
   	  	}
        //주소처리 끝.
        
        //flag 여부에 따라  RD화면에 include / exclude 함.			     	
        if (!ComIsEmpty ( ComGetObjValue(formObj.sh_num) )) {
  			temp = ComGetObjValue(formObj.sh_num).split("|");
  			ComSetObjValue(formObj.bil_to_loc_div_cd,	temp[0]);			
  			ComSetObjValue(formObj.cust_ref_prn_flg, 	temp[1]);	
  			ComSetObjValue(formObj.phn_fax_prn_flg, 	temp[2]);		
  			ComSetObjValue(formObj.cust_vat_prn_flg, 	temp[3]);		
  			ComSetObjValue(formObj.tax_amt_prn_flg,   	temp[4]);
  			ComSetObjValue(formObj.dc_amt_prn_flg,   	temp[5]);
  		} 
        else {
  			ComSetObjValue(formObj.bil_to_loc_div_cd,	"");			
  			ComSetObjValue(formObj.cust_ref_prn_flg, 	"");	
  			ComSetObjValue(formObj.phn_fax_prn_flg, 	"");		
  			ComSetObjValue(formObj.cust_vat_prn_flg, 	"");		
  			ComSetObjValue(formObj.tax_amt_prn_flg,   	"");
  			ComSetObjValue(formObj.dc_amt_prn_flg,   	"");
  		}
   	  	
	}	
	
	function faxEmailByGroup(formObj, opnSheetObj, sheetObj){
     	//부모화면에서 다수의 bkg_no를 get방식으로 받지 않고 자식 창에서 직접 부모를 호출하여 가져온다.
   	  	var bkgNos 		= "";
   	  	var cntrNos 	= "";
 		var chkRows 	= opnSheetObj.FindCheckedRow(1).split("|");
 		for (var i=0; i < chkRows.length-1; i++) {
 			bkgNos  += ','+opnSheetObj.CellValue(chkRows[i], "bkg_no");
 			cntrNos += ','+opnSheetObj.CellValue(chkRows[i], "cntr_no");
 		}
 		ComSetObjValue(formObj.bkg_no, 	bkgNos.substring(1));
 		ComSetObjValue(formObj.cntr_no, cntrNos.substring(1));
 		 
 		//rd_fxeml_rd_param 셋팅 rd report 표현 할 때 사용.
// 		var rdRaram = "/rsn [jdbc/HJSBAT] /rp  [" + ComGetObjValue(formObj.ofc_cd) 				+"]" +
 		var rdRaram = " /rp  [" + ComGetObjValue(formObj.ofc_cd) 								+"]" +
 		 				  " [" + ComGetObjValue(formObj.dmdt_trf_cd) 							+"]" +
 		 				  " [" + ComReplaceStr(ComGetObjValue(formObj.dmdt_chg_sts_cd), "R", "L") 	+"]" +
 		 				  " [" + ComGetObjValue(formObj.bkg_no) 								+"]" +
 		 				  " [" + ComGetObjValue(formObj.cntr_no) 								+"]" +
 		 				" [" + ComGetObjValue(formObj.ofc_add01)					+"]" +	
 		 				" [" + ComGetObjValue(formObj.ofc_add02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.ofc_add03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.print_date) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_nm)			 			+"]" +
 		 				" [" + ComGetObjValue(formObj.address01) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.address04) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm) 		+"]" +
 		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_phn_no) 		+"]" +
 		 				" [" + ComGetObjValue(formObj.payr_cntc_pnt_fax_no) 		+"]" +
 		 				" [" + ComGetObjValue(formObj.hjs_ref) 						+"]" +
 		 				" [" + ComGetObjValue(formObj.payer_cd) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_vat) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header01) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header02) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header03) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header04) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header05) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header06) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header07) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header08) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header09) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.header10) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.dmdt_trf_cd) 					+"]" +
 		 				" [(" + ComGetObjValue(formObj.dmdt_trf_nm) 				+")]" +
 		 				" [" + ComGetObjValue(formObj.inv_chg_amt) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.tax_rto_dis) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.tot_tax_amt) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.tot_payable_amt) 				+"]" +
 		 				" [" + ComGetObjValue(formObj.inv_curr_cd) 					+"]" +
 		 				" [" + ComGetObjValue(formObj.bil_to_loc_div_cd) 			+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_ref_prn_flg) 			+"]" +
 		 				" [" + ComGetObjValue(formObj.phn_fax_prn_flg) 				+"]" +
 		 				" [" + ComGetObjValue(formObj.cust_vat_prn_flg) 			+"]" +
 		 				" [" + ComGetObjValue(formObj.tax_amt_prn_flg) 				+"]" +
 		 				" [" + ComGetObjValue(formObj.dc_amt_prn_flg) 				+"]" +
 		 				" [*** " + ComGetObjValue(formObj.title) 					+" ***]"
 		 			   ;
// 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	rdRaram);
 		ComSetObjValue(formObj.rd_fxeml_rd_param, 	RDServerBAT + rdRaram);
	}     
	
	

	function sendFaxEmail(sendType){
      	var formObj = document.form;
      	//var opener = window.dialogArguments;
 	 	var opnSheetObj = document.sheet1;
 	 	var sheetObj = sheetObjects[1];  // Group 호출 시 사용.

 		//1. 기본정보 조회.
	 	makeDataByGroup(formObj, opnSheetObj, sheetObj);
	    //2.GROUP 용 RD DATA
	 	faxEmailByGroup(formObj, opnSheetObj, sheetObj);
	 	//팩스 / 이메일 기본정보 셋팅.
	 	faxEmaiInfo(formObj, opnSheetObj, sheetObj);
	 	
	 	if(ComGetObjValue(formObj.bil_to_loc_div_cd) == 'R'){
			ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3904.mrd");
 		} 
 		//RD - Left
 		else {
    		ComSetObjValue(formObj.rd_fxeml_file_name  , 	 "EES_DMT_3903.mrd");
 		}	
  	}	
	
	function faxEmaiInfo(formObj, opnSheetObj, sheetObj){
 		//EMAIL 정보
        ComSetObjValue(formObj.rd_fxeml_sys_cd         , 	 "DMT");
 		ComSetObjValue(formObj.rd_fxeml_bat_flg        , 	 "N");
 		ComSetObjValue(formObj.rd_fxeml_title          , 	 "Demand Note (SM Line Corporation)");
 		ComSetObjValue(formObj.rd_fxeml_doc_tp		   , 	 "G");
 		ComSetObjValue(formObj.rd_fxeml_fax_no         , 	 "");
 		ComSetObjValue(formObj.rd_fxeml_fax_sndr_id    , 	 "SM Line");
 		ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm    , 	 "Demand Note");
 		ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add   , 	 "");
 		ComSetObjValue(formObj.rd_fxeml_eml_atch_file  , 	 ComGetNowInfo("ymd") + "_" + ComGetObjValue(formObj.payer_cd)); //YYYY-MM-DD_payer code (예시: 2010-02-24_KR123456)
 		ComSetObjValue(formObj.rd_fxeml_eml_templt     , 	 "EES_DMT_DEMAND_002.htmlmail"); // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
 		ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param, 	 "");
 		ComSetObjValue(formObj.invno					, 	 "DemandNot");
 		ComSetObjValue(formObj.payc						, 	 ComGetObjValue(formObj.payer_cd) );
	}
	
	///////////////////////////////////////////////////////////////////////////////
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
    	var formObj = document.form;
   	 
 		/*********************************************
          * 팝업으로 호출시 처리 Title 정의
          **********************************************/
        for (i=0; i<sheetObjects.length; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
          
        // IBMultiCombo초기화 
  	    for (var k=0; k<comboObjects.length; k++) {
  	        initCombo(comboObjects[k],k+1);
  	    }
        initAxonControl();
        
        //부모화면에서 다수의 bkg_no를 get방식으로 받지 않고 자식 창에서 직접 부모를 호출하여 가져온다.
		var formObj 	= document.form;
  	  	var opener 		= window.dialogArguments;
  	  	var opnSheetObj = opener.document.sheet1;
  	  	var bkgNos 		= "";
		var chkRows 	= opnSheetObj.FindCheckedRow(1).split("|");
		for (var i=0; i<chkRows.length-1; i++) {
			bkgNos += ','+opnSheetObj.CellValue(chkRows[i], "bkg_no");
		}
		ComSetObjValue(formObj.s_bkg_no, bkgNos.substring(1));
		// 여기까지가 부모화면에서 bkg_no 정보 가져오기.
		
		// Invoice Creation - Group 초기 정보 조회
		DMTComDoActionIBSheet(sheetObjects[1], formObj, IBSEARCH_INIT);
		
		//EES_DMT_3013에서 팝업 호출
        doInit();
        
		//팩스, 이메일 디폴트 값 셋팅 로직 추가 
		//Payer별 email, faxno를 조회한다.
		//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
    }
     
     /**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboNo) {
 	    var formObj = document.form
 	    switch(comboNo) { 
 	    	//Attention
 	    	case 1:
 	    		with (comboObj) {
					MultiSelect = false;
					SetColAlign("left|left|left|left");
					DropHeight = 160;
 	    		}
 	    		break;
 	    	
 	     } 		
 	} 	
     
   /*
    * EES_DMT_3013에서 팝업 호출
    */
	function doInit() {
    	var sheetObj = sheetObjects[0]; 
  		var formObj = document.form;
  		
  		// MAIN 리스트 조회 		
  		doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
  		
 		// Tax Ratio 항목의 값과 상태를 초기화 시켜줍니다.
 		DmtComInitTaxRto();
 		
  		//check box - all check 
  		//sheetObj.CheckAll("check_box") = 1; // 1: all check , 0: all unckeck
  		//OnChange Event가 발생하지 않음.
  		sheetObj.CheckAll2("check_box") = 1;
  		
 		//국가별 통화량 -> 요구사항에 따라 전체 리스트를 사용하지 않고 첫번째 항목만 사용.
		searchARCurrencyList();
 		
 		//total count = cntr no 총갯수
 		ComSetObjValue(formObj.cntr_qty, sheetObjects[0].TotalRows);

 		// Payer 정보에 따른 India Tax 정보를 가져오기 위해서 필요한 초기값 설정
 		for (var i=2; i<sheetObj.TotalRows+2; i++) {
 			if (sheetObj.cellValue(i, "check_box") == 1) { 		
 				ComSetObjValue(formObj.dmdt_trf_cd, sheetObj.CellValue(i, "dmdt_trf_cd"));
 				ComSetObjValue(formObj.por_cd,      sheetObj.CellValue(i, "por_cd"));
 				ComSetObjValue(formObj.del_cd,      sheetObj.CellValue(i, "del_cd"));
 				break;
 			}
 		}
 		
 		// Tax Ratio 를 Grid 데이터에 추가해 줌. ( Group Invoice 화면과 공용으로 사용하는 함수 사용에 따른 처리 )
 		for (var i=2; i<sheetObj.TotalRows+2; i++) {
 			sheetObj.CellValue2(i, "inv_tax_rto") = ComGetObjValue(formObj.tax_rto_dis);
 		}
 		
 		// Payer 정보 설정 ( 첫번째로 선택된 항목의 Customer 를 Payer 로 설정합니다. )
 		//추가 디폴트 PAYER CODE 값 셋팅
 		for (var i=2; i<sheetObj.TotalRows+2; i++) {
 			if (sheetObj.cellValue(i, "check_box") == 1) {
 				if (sheetObj.CellValue(i, "payer_cd") == "") continue;
	
				ComSetObjValue(formObj.payer_cd, sheetObj.CellValue(i, "payer_cd"));
				ComSetObjValue(formObj.payer_nm, sheetObj.CellValue(i, "payer_nm"));			
				break;
 			}
 		}
 		
 		// Payer 의 Attention 정보를 조회해서 초기화 시켜줍니다.
 		DmtComInitPayerAttention();
 		
    	// Payer 정보가 변경되면 Payer 에 해당되는 India Tax Ratio 를 조회해서 Invoice Amount 를 재계산합니다.
 		DmtComSearchIdaTaxRtoByPayer();

    	// 인도지역이고 Payer 가 존재하는 경우, 위에서 Invoice Amount 를 계산해주기 때문에 아래에서 다시 Invoice Amount 를 계산해 줄 필요가 없다.
    	if (ComGetObjValue(formObj.usr_cnt_cd) != "IN" || ComGetObjValue(formObj.payer_cd) == "") {
    		//Invoice 발행 전 일 경우에는 Tax Amount 및 Invoice Amount 을 계산해 줍니다.
    		DmtComCalcInvAmtByTaxAmt();
    	}
   	}
    
    /**
     * 체크박스 전체해제시에 알림 및 버튼 활성화 여부
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
 	function sheet1_OnChange (sheetObj, Row, Col, Value) {
		var formObj 		= document.form;
		var sName 			= sheetObj.ColSaveName(Col);
		var inv_curr_cd 	= ComGetObjValue(formObj.inv_curr_cd);
		//Total 계산하기
		var tot_bil_amt		= 0;
		var tot_tax_amt		= 0;
		var tot_payable_amt	= 0;
		//Tax AMT, Payable AMT 계산
		var inv_tax_rto 	= parseFloat(ComGetObjValue(formObj.tax_rto));
		var inv_tax_amt 	= 0;
		var inv_payable_amt = 0;
		var inv_chg_amt 	= 0;
		// 인도 관련 GST 합계.
 		var tot_ida_expn_tax = 0;
 		var tot_ida_edu_tax = 0;
 		var tot_ida_high_edu_tax = 0;
 		var usr_cnt_cd = ComGetObjValue(formObj.usr_cnt_cd);
		
		if(sName == "check_box") {	//checkbox
			// check box 선택시 재계산 시작
			if(Value == 1) {
				inv_chg_amt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float")) + parseFloat(sheetObj.CellValue(Row, "inv_amt"));	
				if (usr_cnt_cd == "IN"){
					tot_ida_expn_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_expn_tax),"float")) + parseFloat(sheetObj.CellValue(Row, "ida_expn_tax"));
					tot_ida_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_edu_tax),"float")) + parseFloat(sheetObj.CellValue(Row, "ida_edu_tax"));
					tot_ida_high_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_high_edu_tax),"float")) + parseFloat(sheetObj.CellValue(Row, "ida_high_edu_tax"));
				}
			} else if(Value == 0) {
				inv_chg_amt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float")) - parseFloat(sheetObj.CellValue(Row, "inv_amt"));
				if (usr_cnt_cd == "IN"){
					tot_ida_expn_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_expn_tax),"float")) - parseFloat(sheetObj.CellValue(Row, "ida_expn_tax"));
					tot_ida_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_edu_tax),"float")) - parseFloat(sheetObj.CellValue(Row, "ida_edu_tax"));
					tot_ida_high_edu_tax = parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.ida_high_edu_tax),"float")) - parseFloat(sheetObj.CellValue(Row, "ida_high_edu_tax"));
				}
			}
			//chk_tax_rto 선택시에만 적용.
			if(formObj.chk_tax_rto.checked){
				//2010.04.04.
	 			if(usr_cnt_cd == "VN") {	//베트남일 경우
	 				inv_tax_amt = (inv_chg_amt / (1 - inv_tax_rto * 0.01)) * (inv_tax_rto * 0.01);
	 			}else if(usr_cnt_cd == "IN") {
	 				 inv_tax_amt = tot_ida_expn_tax + tot_ida_edu_tax + tot_ida_high_edu_tax
	 			}else{	
	 				inv_tax_amt = (inv_tax_rto * 0.01) * inv_chg_amt;
	 			}
			}
			tot_bil_amt = tot_bil_amt + parseFloat(inv_chg_amt);
			tot_bil_amt	= DMTtrimCurrencyAmount(inv_curr_cd, tot_bil_amt);
			
			tot_tax_amt = tot_tax_amt + parseFloat(inv_tax_amt);
			tot_tax_amt	= DMTtrimCurrencyAmount(inv_curr_cd, tot_tax_amt);
			
			tot_payable_amt = tot_bil_amt + tot_tax_amt;
			tot_payable_amt	= DMTtrimCurrencyAmount(inv_curr_cd, tot_payable_amt);
			
			ComSetObjValue(formObj.inv_chg_amt, 	ComAddComma2(tot_bil_amt+''		,"#,###.00"));
	 		ComSetObjValue(formObj.tot_tax_amt, 	ComAddComma2(tot_tax_amt+''		,"#,###.00"));
	 		ComSetObjValue(formObj.tot_payable_amt, ComAddComma2(tot_payable_amt+''	,"#,###.00"));
	 		
	 		ComSetObjValue(formObj.ida_expn_tax, ComRound(tot_ida_expn_tax,2));
	 		ComSetObjValue(formObj.ida_edu_tax,  ComRound(tot_ida_edu_tax,2));
	 		ComSetObjValue(formObj.ida_high_edu_tax, ComRound(tot_ida_high_edu_tax,2));
	 		
			// check box 선택시 재계산 종료
			
			var iCnt = 0;
			for(var i = 2; i < sheetObj.TotalRows+2; i++) {
				if(sheetObj.CellValue(i,"check_box") == 1) {
					iCnt++;
				}
			}
			
			ComSetObjValue(formObj.cntr_qty, iCnt);
			
			//CHECK BOX를 모두 해제 했을 경우 alert & 버튼 비활성화
			if(iCnt == 0){
				ComShowCodeMessage('DMT00164');

				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(false, "btn_update", "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail", "btn_detail", "btn_down_excel");
			} else {
				DmtComEnableManyBtns(true,  "btn_set", "btn_option", "btn_close");
				DmtComEnableManyBtns(true,  "btn_update", "btn_preview", "btn_print", "btn_fax", "btn_email", "btn_payerfaxemail", "btn_detail", "btn_down_excel");
			}
		} //end of the check box
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
                    style.height = 360;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 7, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
											
                    var HeadTitle1 = " ||Seq.|BKG No.|B/L No.|STS|CNTR No.|T/S|Staying Period|Staying Period|Free Time|Free Time|rd_date1|rd_date2|rd_date3|rd_date4|F/T|Over|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex.Rate|VVD CD|Office|From YD|BKG DEL|Tariff|S/C No.|RFA No.";
						HeadTitle1 += "|Payer|Payer|Shipper|Shipper|Consignee|Consignee|Notify|Notify|A/R Actual Payer|A/R Actual Payer|Service Provider|Service Provider";
						HeadTitle1 += "|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd|loc|ida_expn_tax|ida_edu_tax|ida_high_edu_tax|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt|inv_tax_rto|inv_tax_amt|inv_payable_amt|por_cd|del_cd";											 												
												
                    var HeadTitle2 = " ||Seq.|BKG No.|B/L No.|STS|CNTR No.|T/S|From Date|To Date|F/T CMNC|F/T End|rd_date1|rd_date2|rd_date3|rd_date4|F/T|Over|Cur.|Billing AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex.Rate|VVD CD|Office|From YD|BKG DEL|Tariff|S/C No.|RFA No.";
						HeadTitle2 += "|Code|Name|Code|Name|Code|Name|Code|Name|Code|Name|Code|Name";
						HeadTitle2 += "|svrId|cntrCycNo|dmdtChgLocDivCd|dmdtInvNo|VslCd|SkdVoyNo|SkdDirCd|PolCd|PodCd|loc|ida_expn_tax|ida_edu_tax|ida_high_edu_tax|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt|inv_tax_rto|inv_tax_amt|inv_payable_amt|por_cd|del_cd"; 

                    var headCount1 = ComCountHeadTitle(HeadTitle1);
                    var headCount2 = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount1, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
                    					
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,0,	daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	true,		"check_box");
					InitDataProperty(0, cnt++ , dtSeq,	   	30,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	true,		"bkg_no",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	true,		"bl_no",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	35,		daCenter,	true,		"dmdt_chg_sts_cd",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	true,		"cntr_no",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	35,		daCenter,	true,		"cntr_tpsz_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"fm_mvmt_dt",			false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"to_mvmt_dt",			false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"ft_cmnc_dt",			false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"ft_end_dt",			false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"fm_mvmt_dt_rd",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"to_mvmt_dt_rd",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"ft_cmnc_dt_rd",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"ft_end_dt_rd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"ft_dys",				false,	"",		dfInteger,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"fx_ft_ovr_dys",		false,	"",		dfInteger,		0,	false,		false);
							
					InitDataProperty(0, cnt++ , dtData,   	50,		daCenter,	true,		"inv_curr_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daRight,	true,		"inv_amt",				false,	"",		dfNullFloat,	2,	false,		false);					
					InitDataProperty(0, cnt++ , dtData,   	50,		daCenter,	true,		"org_curr_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	90,		daRight,	true,		"org_chg_amt",			false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	90,		daRight,	true,		"expt_amt",				false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	60,		daRight,	true,		"dc_amt",				false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	90,		daRight,	true,		"bil_amt",				false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	60,		daRight,	true,		"inv_xch_rt",			false,	"",		dfNullFloat,	6,	false,		false); 
					
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	true,		"vvd_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	45,		daCenter,	true,		"ofc_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"fm_mvmt_yd_cd",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"port",					false,	"",		dfNone,			0,	false,		false);			                                                                
					InitDataProperty(0, cnt++ , dtData,   	45,		daCenter,	true,		"dmdt_trf_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"sc_no",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	90,		daCenter,	true,		"rfa_no",				false,	"",		dfNone,			0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"payer_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	55,		daCenter,	true,		"payer_nm",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"shipper_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	55,		daCenter,	true,		"shipper_nm",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"cnee_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	55,		daCenter,	true,		"cnee_nm",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"ntfy_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	55,		daCenter,	true,		"ntfy_nm",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"ar_act_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	55,		daCenter,	true,		"ar_act_nm",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	true,		"svc_provdr_cd",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	55,		daCenter,	true,		"svc_provdr_nm",		false,	"",		dfNone,			0,	false,		false);

					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"svr_id",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"cntr_cyc_no",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"dmdt_chg_loc_div_cd",	false,"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"dmdt_inv_no",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"vsl_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"skd_voy_no",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"skd_dir_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"pol_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"pod_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,		"loc",					false,	"",		dfNone,			0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_expn_tax");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_edu_tax");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_high_edu_tax");
					// Invoice Amount 를 계산하는 함수를 Group Invoice 와 공용으로 사용하면서 추가된 필드임.
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_cgst_amt");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_sgst_amt");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_igst_amt");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"ida_ugst_amt");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"inv_tax_rto");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"inv_tax_amt");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"inv_payable_amt");		
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"por_cd");
					InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,		"del_cd");

					FrozenCols = SaveNameCol("dmdt_chg_sts_cd");
					
					CountPosition = 2;
					Ellipsis = true;//문자가 범위를  초과할때 말줄임표...로 표현
            	}
            	break;
           
            case 2:
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
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

					CountPosition = 0;
                }
                break;            	
        }
    }
     
	function initAxonControl() {
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
	}     
	
    /**
    * HTML Control Foucs in
    */
	function obj_focus() {
       ComClearSeparator(event.srcElement);
	}		
	
    //포커스가 나갈 때
	function obj_blur() {
    	var formObj = document.form;
    	
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;

		switch(obj.name) {
			case "payer_cd":
				DmtComDoActionText(sheetObjects[0], formObj, obj, SEARCH20);
				break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBROWSEARCH:     // MAIN 조회
         		//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
         		setParameters(SEARCH01);
				var sXml = sheetObj.GetSearchXml("EES_DMT_3108GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);         		
         		
				ComSetObjValue(formObj.tax_rto,              ComGetEtcData(sXml, "TAX_RTO"));
				ComSetObjValue(formObj.ida_tax_appl_tm,      ComGetEtcData(sXml, "IDA_TAX_APPL_TM"));
				ComSetObjValue(formObj.ida_expn_tax_rt,      ComGetEtcData(sXml, "IDA_EXPN_TAX_RT"));
				ComSetObjValue(formObj.ida_edu_tax_rt,       ComGetEtcData(sXml, "IDA_EDU_TAX_RT"));
				ComSetObjValue(formObj.ida_high_edu_tax_rt,  ComGetEtcData(sXml, "IDA_HIGH_EDU_TAX_RT"));
				ComSetObjValue(formObj.ida_locl_tax_rt,      ComGetEtcData(sXml, "IDA_LOCL_TAX_RT"));
				ComSetObjValue(formObj.ida_n2nd_locl_tax_rt, ComGetEtcData(sXml, "IDA_N2ND_LOCL_TAX_RT"));
				
            	// India Tax 관련항목을 보여준다.
            	DmtComDisplayIdaTax();				

				ComOpenWait(false);
				
				break;
				
         	 case IBSEARCH_ASYNC05:      //조회
         	 	 //ComOpenWait Start
				 sheetObj.WaitImageVisible=false;
	        	 ComOpenWait(true);
	             
	        	 formObj.f_cmd.value = SEARCH05;
				 sheetObjects[1].DoSearch4Post( "DMTCommonFaxEmailGS.do" , FormQueryString(formObj) );
				 
				 //ComOpenWait End
				 ComOpenWait(false);
	             break;

	         case IBSEARCH_ASYNC06:      //조회
	         	 //ComOpenWait Start
			 	 sheetObj.WaitImageVisible=false;
        	     ComOpenWait(true);
	             
        	     formObj.f_cmd.value = SEARCH06;
				 sheetObjects[1].DoSearch4Post( "DMTCommonFaxEmailGS.do" , FormQueryString(formObj) );
				 
				 //ComOpenWait End
				 ComOpenWait(false);
	             break;				
         }
	}
     
	
	//save name에서 port에다  조회 후 결과값에 따라 아래 해당title로 변경 . 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
		with(sheetObj) {
			var formObj = document.form;
    		var dmdtTrfCd = formObj.dmdt_trf_cd.value;
    		if(!ComIsEmpty(dmdtTrfCd)){
    		    //tariff type code 에서 Outbound 일 경우
    			if(dmdtTrfCd.substr(2,1) == 'O'){
    				CellValue(0, "port") = "BKG POR";
        			CellValue(1, "port") = "BKG POR";
        			
    			} else {
    			//tariff type code 에서 Inbound 일 경우	
    				CellValue(0, "port") = "BKG DEL";
        			CellValue(1, "port") = "BKG DEL";
        			
    			}
    		} else {
    			//default
    			CellValue(0, "port") = "BKG POR";
    			CellValue(1, "port") = "BKG POR";
    		}
		}
	}
    

    function sheet1_OnClick(sheetObj, row, col, Value){
        if(sheetObj.ColSaveName(col) == "check_box")
        	ComSyncAllCheck(sheetObj, col, Value);
    }	
     
 	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		//Retrieve Setting
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
		
	}
	
   	//조회조건필드인 Combo 데이터 조회
	function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
 		sheetObj.ShowDebugMsg = false;
 		sheetObj.WaitImageVisible = false;

 		switch(sAction) {
 			case IBSEARCH:      // 조회
 				if (sheetObj.id == "sheet2") {

  					//3.조회후 결과처리
  					var comboDatas;
  					var comboItems;
  					
  					switch(sComboAction) {
  						//1. ATTENTION LIST
  						case SEARCHLIST03:
  							//0. ofc_cd를 세션 값으로 치환.
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
							
  		  					//1. 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
  		  					setComboParameters(sComboAction, sObj);
  		  					//2. 조회조건으로 조회실행					
  		  					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
  							
  							comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
  							//comboObjects[0].Code = "-1";
  							comboObjects[0].RemoveAll();
  							addComboItem1(sObj,comboItems);
  							
  						    //3. 조회 후 다시 변수 재정의 :chrg_ofc_cd는 charge office code를 담고 있는 temp성 변수.
	 						ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.chrg_ofc_cd))
  							break;							

  						//3-1.Currency 항목 조회
  						//currency 항목에서 첫번째 것만 가져옴..DMD_ORGANIZATION 테이블  참조.
  						case SEARCHLIST05:
  		  					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
  		  					setComboParameters(sComboAction, sObj);
  		  					//2.조회조건으로 조회실행					
  		  					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
  		  					
  							comboDatas = ComGetEtcData(sXml, sComboKey);
  							var invCurrCd = "";
  							if (comboDatas != undefined) {
  								comboItems = comboDatas.split(ROWMARK);	
  								
  						 	    for (var i = 0 ; i < comboItems.length ; i++) {
  						     		comboItem = comboItems[i].split(FIELDMARK);
  						 			if(i == 0){
  						 				invCurrCd = comboItem[0];
  						     		}
  						 		}   
  							}
  							ComSetObjValue(formObj.inv_curr_cd, invCurrCd);
	  						break;	
	  						
					    //Payer별 Email, FAX 번호를 조회한다.
						case COMMAND02:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							//2. ofc_cd를 세션 값으로 치환.
							ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.session_ofc_cd));
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
							//3.조회후 결과처리
							ComSetObjValue(formObj.payr_faxnos, 	ComGetEtcData(sXml, "FAX_NO"));
							ComSetObjValue(formObj.payr_emailnos, 	ComGetEtcData(sXml, "EMAIL_NO"));
							//4. 조회 후 다시 변수 재정의 :chrg_ofc_cd는 charge office code를 담고 있는 temp성 변수.
	 						ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.chrg_ofc_cd))
							break;
	 						
						//CNT 조회		2010.04.04.
						case COMMAND17:
							ComSetObjValue(formObj.f_cmd, COMMAND17);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							
							//3.조회후 결과처리
							ComSetObjValue(formObj.usr_cnt_cd, 	ComGetEtcData(sXml, "USR_CNT_CD"));
							break;	 						
	  						
  					} //end of the switch(sComboAction) 
  				};
                break;
 		}
 		sheetObj.WaitImageVisible = true;
	}     
     
     
	    
    function setComboParameters(sComboAction, sObj) {
    	var formObj = document.form;
    	ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.inv_curr_cd));//inv_curr_cd
    	ComSetObjValue(formObj.f_cmd, sComboAction);
    }	
    
     
     /**
      * 콤보필드에 데이터를 추가해준다.
      */	
 	function addComboItem(comboObj,comboDatas,isOnlyCode) {
 		var comboItem;
 		var comboItems;
 		var val;
 		var txt;
 		if (comboDatas != undefined) {
 			comboItems = comboDatas.split(ROWMARK);	
 	    	for (var i = 0 ; i < comboItems.length ; i++) {
     			comboItem = comboItems[i].split(FIELDMARK);
     			val = comboItem[0];
 				txt = isOnlyCode ? comboItem[0] : comboItem[1];
 				
 				ComAddComboItem(comboObj,val,txt);
     		}
 		}   		
 	}
 	/**
      * 콤보필드에 데이터를 추가해준다.
      */	
 	function addComboItem1(comboObj, comboItems) {
     	for (var i = 0 ; i < comboItems.length ; i++) {
     		var comboItem = comboItems[i].split(FIELDMARK);
 			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);		
 			//comboObj.SetColWidth("150|1|1|1");
     	}   
 	}     
     
 	/**
 	 * AR Currency 를 조회하는 함수
     */	
	function searchARCurrencyList() {
		var sheetObj = sheetObjects[1];
		var formObj = document.form;
		
		doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST05,"AR_CURRENCY");
	}
	
	//Attention 선택 이벤트
  	function combo1_OnChange(comboObj, Index_Code, Text) {
  		search_combo1(comboObj, Index_Code, Text);
  	}
  	
  	function search_combo1(comboObj, searchIndex, searchText) {
  		
 		var formObj = document.form;
		var cboAttention 	= comboObjects[0];

		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, comboObj.GetText(cboAttention.Code,0));
		ComSetObjValue(formObj.payr_cntc_pnt_phn_no, comboObj.GetText(cboAttention.Code,1));	//텍스트 컬럼 보여주기
		ComSetObjValue(formObj.payr_cntc_pnt_fax_no, comboObj.GetText(cboAttention.Code,2));	//텍스트 컬럼 보여주기
		ComSetObjValue(formObj.payr_cntc_pnt_eml, comboObj.GetText(cboAttention.Code,3));	//텍스트 컬럼 보여주기
		
		var codes = searchIndex.split("^");			//code
		if(codes != undefined || codes != "") {
			ComSetObjValue(formObj.cust_cntc_pnt_seq , codes[1]);
		}
  	}     

  	
  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
				
    		}
        }

        return true;
    }  	
      
  	/*
	 * 각 공통팝업창 호출 함수 
	 */
	function openPopup(flag, arg) {
    		
		var sheetObj = sheetObjects[0];
		var formObj	= document.form;
		var sUrl	= '';
		var sWidth	= '';
		var sHeight	= '';
		
		with(sheetObj) {
	  		switch(flag) {
	  			case 's_cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  		} // switch-end
		} // with-end
    		
	}

      /*
    	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
    	 */
      function getCustCd(aryPopupData) {
      	document.form.payer_cd.value = aryPopupData[0][3];
      	document.form.payer_nm.value = aryPopupData[0][4];

      	//Attention 
    	searchAttentionList();
		if (comboObjects[0].GetCount() > 0) {
			//Payer 가 변경되면 자동으로 Attention 정보를 조회하며, 조회된 첫번째 항목을 자동으로 선택해 준다.
			comboObjects[0].Index = 0;
		}
		
		
		//팩스, 이메일 디폴트 값 셋팅 로직 추가 
		//Payer별 email, faxno를 조회한다.
		//parameter : payer_cd, ofc_cd  -- 세션 ofc_cd , dmdt_trf_cd 
		var formObj 	= document.form;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, COMMAND02, "", "");
      }  
    	 
   	/**
   	 * EES_DMT_3109, EES_DMT_3108 팝업 호출
   	 * @param sheetObj
   	 * @param formObj
   	 * @param srcName
   	 * @return
   	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
   		if(srcName == "btn_set") {
   			var url = "EES_DMT_4101.do"
   				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
   				+"&tftp2="+ComGetObjValue(formObj.s_dmdt_trf_cd)
 				+"&sheetp=G"
 				+"&invoice_issue=1"
   				+"&jspno=EES_DMT_3108";
   			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4101", "725","780", true, "yes");
   		} else if(srcName == "btn_option") {
   			var url = "EES_DMT_4103.do"
   				+"?issoff="+ComGetObjValue(formObj.ofc_cd)
   				+"&tftp="+ComGetObjValue(formObj.s_dmdt_trf_cd)
   				+"&invoice_issue=1"
   				+"&jspno=EES_DMT_3108";
   			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4103", "625","650", true);

   		} else if(srcName == "btn_payerfaxemail") {
			var url = "EES_DMT_4104.do"
				+"?s_ofc_cd="+ComGetObjValue(formObj.session_ofc_cd)
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="//+sheetObj.CellValue(sheetObj.SelectRow, "bkg_no") //ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="//+sheetObj.CellValue(sheetObj.SelectRow, "pod_cd")
				+"&jspno=EES_DMT_3108"
				+"&attn="+ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm)
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","620", true);
		} else if(srcName == "btn_sendinghistory") {
			var url = "EES_DMT_7006_P.do"
				+"?jspno=EES_DMT_3108"
				+"&payerCd="+ComGetObjValue(formObj.payer_cd)
				+"&selectType=G"
				+"&selectOpt=2"
				;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_7006_P", "1036","690", true);
		} else if(srcName == "btn_fax") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.session_ofc_cd);

			var url = "EES_DMT_4107.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="//+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="//+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3108"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
		} else if(srcName == "btn_email") {
			if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
				ComShowCodeMessage("DMT00182");
				return;
			}
			var ofc_cd = ComGetObjValue(formObj.session_ofc_cd);

			var url = "EES_DMT_4108.do"
				+"?s_ofc_cd="+ofc_cd
				+"&s_cust_cd="+ComGetObjValue(formObj.payer_cd)
				+"&s_bkg_no="//+ComGetObjValue(formObj.bkg_no)
				+"&s_pod_cd="//+ComGetObjValue(formObj.pod_cd)
				+"&jspno=3108"
				+"&telno="+ComGetObjValue(formObj.payr_cntc_pnt_phn_no)
				+"&faxno="+ComGetObjValue(formObj.payr_cntc_pnt_fax_no)
				+"&email="+ComGetObjValue(formObj.payr_cntc_pnt_eml)
				+"&cntc_seq="//
				;
			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);
		}
   	}   
   	 
/////////////////////////////////////////////////////////////////////////////////////
  	/**
  	 * SheetOption 팝업화면에서 변경시 자동변경 처리하는 로직임(Due Date, Credit Term, Tax Rate)
  	 */
  	function getSheetOptionData(cr_term_dys, is_dt_prn_flg, tax_rto) {
  		
  		var formObj = document.form;
  		var usr_cnt_cd  = ComGetObjValue(formObj.usr_cnt_cd);
  		if(tax_rto == null || tax_rto == "") {
  			if(usr_cnt_cd =="IN"){
  				tax_rto = "";
  			}else{
  			    tax_rto = "0";
  			}
  		}
  		//tax_rto
  		ComSetObjValue(formObj.tax_rto, tax_rto);
  		//tax 계산 로직 
  		setTax();
  	}  
  	
	/**
	 * PayerInfo 팝업화면에서 변경시 자동변경 처리됨
	 */
	function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
		var formObj = document.form;
		ComSetObjValue(formObj.payr_faxnos, 			fax_nos);
		ComSetObjValue(formObj.payr_emailnos, 			email_nos);
		ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, 	cntc_pnt_nm);
		ComSetObjValue(formObj.cust_cntc_pnt_seq, 		cntc_pnt_seq);
		
		searchAttentionList();

		var setCode = ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
		
		//setting
		if(ComGetObjValue(formObj.payer_cd) == "") {
			comboObjects[0].Code = -1;
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
			ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
			ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
		}else{
			//Attention Setting
			comboObjects[0].Code = setCode;
			if(comboObjects[0].Code == ""){
				ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
				ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
				ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
				ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
			}
		}
		
	}  	
  	
	/* 개발자 작업  끝 */