/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0008.js
*@FileTitle : CSR Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.16 함대성
* 1.0 Creation
* 2015.05.13 심성윤 [CHM-201535807] PSO 별도 파일 추가 탭 기능 개발
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
     * @class COM_CSR_0008 : COM_CSR_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function COM_CSR_0008() {
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

    /***
     *
     * 2009-02-24 : CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 송민정 요청 )
     */

    	// 공통전역변수
    	var sheetObjects = new Array();
    	var sheetCnt = 0;
    	var Mincount = 0;

    	document.onclick = processButtonClick;

    	function retrieve(){
    		
    		var formObject = document.form;
    		doActionIBSheet(sheetObjects[0],formObject, IBSEARCH);
    	}

        function processButtonClick(){

             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];
             var sheetObject2 = sheetObjects[2];

             /*******************************************************/
             var formObject = document.form;

        	 try {
        		var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btng_retrieve":
    					retrieve();
    					break;

    				case "btng_new":
    					sheetObject.RemoveAll();
    					formObject.reset();
    					try	{
    						//csr_getInputValue('DB_DATE', COMMAND05, '', 'setPeriodFromTo');
    			    		//권한 로케이션 정보에 따라 날짜가져오기
    			    		var formObj  = document.form;
    			    		var sheetObj = sheetObjects[0];

    			    		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
    			    		setPeriodFromTo();
    			    		document.form.fm_eff_dt.focus();
    					} catch(e){}
    					document.form.fm_eff_dt.focus();
    					break;

    				case "btng_editapprovalstep":
    					if (sheetObject.RowCount > 0 && sheetObject.CellValue(sheetObject.SelectRow,'if_status')=='Approval Requested')
    					{
    						with(document.form){
	    						var v_ofc_cd = ofc_cd.value;
	    						var v_sub_sys_cd = inv_sub_sys_cd.value;
	    						var v_apro_step  = apro_step.value;
	    						//alert(v_apro_step);
	    						var param = "?mode=save&ofc_cd="+v_ofc_cd+"&csr_no="+sheetObject.CellValue(sheetObject.SelectRow,"csr_no")+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&classId=COM_ENS_0T1&target_obj_nm=apro_step";
	    	                    
	    	                    //"?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
	    						
	    						ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 915, 522, '', 'none', true);
    						}
    					}else{
        					//showErrMessage(getMsg('CSR23028'));
    					}
    					break;
    					
    				case "btng_csrformat":
    					if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006'));//showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908'));//showErrMessage('선택된 row가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
    					doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
    					break;

    				case "btng_invoicelistinquiry":
    					if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006'));//showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908'));//showErrMessage('선택된 row가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}

    					var csrNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
    					var costOfcCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'cost_ofc_cd');
    					var currCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_curr_cd');
    					var invSubSysCd = document.form.inv_sub_sys_cd.value;
						window.showModalDialog("/hanjin/COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd, window, "dialogWidth:820px; dialogHeight:500px; help:no; status:no; scroll:no; resizable:no;");
    					break;
 
    				case "btng_csrcancel":
    					// session의 ofc_cd와 입력란의 ofc_cd가 동일한지 확인하는 부분...
    					if (ofc_cd==undefined || ofc_cd==null || ofc_cd.trim()==''){
    						showErrMessage('No Inv OFC data is found in the session');
    						return false;
    					}
    					if (formObject.ofc_cd.value==undefined || formObject.ofc_cd.value==null || formObject.ofc_cd.value.trim()==''){
    						showErrMessage('No Invoice Office data');
    						return false;
    					}
    					if (ofc_cd != formObject.ofc_cd.value){
    						//showErrMessage("Inv OFC data retrieved don't match Inv OFC data in the session");
    						//showErrMessage("login Inv OFC is not authorized");
    						showErrMessage("No authority to cancel CSR - Invoice office mismatch!");
    						return false;
    					}
    					if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006')); //showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908'));
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}
    					//if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'aft_act_flg')=='N' || sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'aft_act_flg')=='X' ) {
    					//	return false;
    					//}
    					
    					/* GROUP BY  문제로 일단 IF_STATUS 문구로 상태를 확인합당... DB query에서 I/F STS.값을 변경하면 반드시 맞게 수정해야한다. 꼭~ */
    					/* 2008-09-02 : 전차장 요청 - Approval Requested상태의 CSR도 cancel 처리 가능하게 한다.  */

                        // 2. GW 결재인 경우 Requesting Approval 상태만 CSR cancel 
    					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status');
    					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
    					
    					if (sheetObjects[0].RowCount > 0 && (ifStatus=='Requesting Approval' || (ifStatus=='Approval Requested' && tpCd=='AL'))) {
    						/**
    							Approval Requested상태의 CSR은 바로 수정한다 - AP I/F를 아직 안한 상태이므로 cancel시 공통의 결재자 정보도 없애야 한다. _> (공통의 결재자 정보 제거하는 로직 없던데..? 그외 로직하나는 필요한지 ..?)
    						**/
    						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
    					} else { 
    						/**
    							Approval Requested상태의 CSR 수정가능 이전 logic  - AP I/F를 이미 한 상태이므로 cancel시 공통의 결재자 정보를 신경쓰지 않아도 된다.
    						**/
    						if (ifStatus=='I/F Error') {
    							/* 'I/F Error' -> popup없이 바로 수정하기 */
    							doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
    						} else if (ifStatus=='A/P Rejected' || ifStatus=='Disapproved') {
    							/* 'A/P Rejected' or 'Disapproved' -> popup창으로 이동 */
    							var ifStatusVar = (ifStatus =='Disapproved' ? "R" : "J");
    							var param = '?';
    							param = param + 'csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
    							param = param + '&vndr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'vndr_no');
    							param = param + '&inv_desc='+encodeURI(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'inv_desc'));
    							param = param + '&no_of_inv='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'no_of_inv');
    							param = param + '&csr_curr_cd='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_curr_cd');
    							param = param + '&csr_amt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_amt');
    							param = param + '&attr_ctnt2='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'attr_ctnt2');
    							param = param + '&iss_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'iss_dt');
    							param = param + '&rcv_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rcv_dt');
    							param = param + '&vndr_term_nm='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'vndr_term_nm');
    							param = param + '&due_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'due_dt');
    							param = param + '&if_status='+ifStatusVar;
    							//window.showModalDialog(url, window, "dialogWidth:940px; dialogHeight:500px; help:no; status:no; resizable:yes;");
    							window.showModalDialog("/hanjin/COM_CSR_0014.do"+param, window, "dialogWidth:940px; dialogHeight:510px; help:no; status:no; resizable:yes; scroll:no");
    						}
    					}
    					
    					if (ifStatus=='Canceled'||ifStatus=='I/F Success'||ifStatus=='Paid'||ifStatus=='Sending') { 
    						//showErrMessage(getMsg('CSR23028'));
    						return false;
    					}
    					break;

    				case "btng_viewapprovalstep":
    					if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006')); //showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908')); //showErrMessage('선택된 row가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}
    					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
                    	var apro_rqst_no = sheetObject.CellValue(sheetObjects[0].SelectRow, "apro_rqst_no");
                    	
                    	if(tpCd != 'GW'){
                    		if (apro_rqst_no==undefined || apro_rqst_no==null || apro_rqst_no.trim()==''){
        						//showErrMessage(getMsg('CSR40041','Approval Request No')); //showErrMessage('가 누락되었습니다.');
        						return false;
        					}
        					
        					var param = "?apro_rqst_no="+apro_rqst_no+"&btn_flag=N";
        					ComOpenPopup("COM_CSR_0020.do" + param, 615, 280, "", "1,0,1,1,1", true);
                    		
                    	}
    					break;
					
    				case "btng_print":
    					/* 2008-11-18 : 부산의 요청에 의해 Excel로 download 기능 추가 */
    					sheetObjects[0].Down2Excel();
    					break;
    					
    				//달력
    	 			case "btns_Calendar2" :		// Agreement Date (To Date)
    	 				var cal = new ComCalendarFromTo();
    	 				cal.select(formObject.fm_eff_dt,  formObject.to_eff_dt,  'yyyy-MM-dd');
     	    			break;   
     	    		
     	    		//Files
     	    		/* button remove 2014.09.24
    	 			case "btng_files":
    	 				if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006')); //showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908'));
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}
    					
    					var csr_no = sheetObject.CellValue(sheetObjects[0].SelectRow, "csr_no");	
    	 				var url = "";
    	 				
    	 				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')=='Approval Requested') {
    	 					url = "/hanjin/COM_CSR_0021.do?csr_no="+csr_no;
    	 				} else {
    	 					url = "/hanjin/COM_CSR_0022.do?csr_no="+csr_no;
    	 				}
    	 				
    	 				var height = screen.height; 
    	            	var width = screen.width;
    	    	                          
    	            	var w = 800;
    	                var h = 370;
    	                var leftpos = width/2 - w/2; 
    	            	var toppos = height/2 - h/2; 
    	            	if(leftpos<0) leftpos=0;
    	            	if(toppos<0) toppos=0;
    					
    	                window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
    	                
    	 				break;
						*/
    	 			case "btng_approvalrequest":
    	 				if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006'));//showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908'));//showErrMessage('선택된 row가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}
    					
    					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status');
    					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
    					
    					/*Approval Type 변경 시 저장 로직 우선... SY SHIM*/
    					if (sheetObjects[0].RowCount > 0){
    		    				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'ibflag')=='U'){
    		    					document.form.csr_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
        		    				var csrNo = document.form.csr_no.value;
        		    		    	var param = "f_cmd="+MULTI+"&csr_no="+csrNo+"&apro_tp_cd="+tpCd;
        		    			    var sXml = sheetObjects[0].GetSaveXml("COM_CSR_0016GS.do", param);;
    		    				}
    		    		}
    					/*---------------------------------------------------------------------------------*/
    					
    					if(ifStatus=='Requesting Approval' && tpCd=='GW') {
    						doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC03);
    					} else if(ifStatus=='Requesting Approval' && tpCd=='AL') {
    						if(formObject.apro_step.value==undefined || formObject.apro_step.value==null || formObject.apro_step.value.trim()==''){
    							showErrMessage(getMsg('CSR25020'));
    							return false;
    						} else {
    							doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC04);
    						}
    					} else{
    						return false;
    					}
    	 				
    	 				break;
    	 				
    	    		case "apro_route_btn":
	            	    var v_ofc_cd = "";
	            	    var v_sub_sys_cd = document.form.inv_sub_sys_cd.value;
	            	    var v_apro_step  = document.form.apro_step.value;
	    				if(document.form.ofc_tp[0].checked){
	    					v_ofc_cd = document.form.cost_ofc_cd.value;
	    				}else if (document.form.ofc_tp[1].checked){
	    					v_ofc_cd = document.form.inv_ofc_cd.value;
	    				}
	                    var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
	                    
	      				ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 915, 522, '', 'none', true);

    	                break;
    	                
    	    		case "btng_agreement":
    	    			
    	    			if (sheetObjects[0].RowCount <= 0){
    						showErrMessage(getMsg('CSR25006')); //showErrMessage('조회된 data가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
    						showErrMessage(getMsg('CSR21908')); //showErrMessage('선택된 row가 없습니다.');
    						return false;
    					}
    					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null ||
    						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
    						showErrMessage(getMsg('CSR40048')); //showErrMessage('선택된 row에 CSR No.가 없습니다.');
    						return false;
    					}
    					var v_csr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
    					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status');
    					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
    					
    					openPopupAgmtFiles(v_csr_no, ifStatus, tpCd);
    	                
    	    			break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			showErrMessage(getMsg('CSR23028')); //ComShowMessage(OBJECT_ERROR);
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
        function setSheetObject(sheet_obj) {
        	sheetObjects[sheetCnt++] = sheet_obj;
        }

        function loadPage() {

            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
         	
            formObj = document.form;
            axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
            axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
            axon_event.addListenerFormat('beforeactivate',	 'obj_activate',	formObj);
         	
    /*
    		if (readonly_yn!=null && readonly_yn.trim()=='Y') {
    			// Invoice Office를 입력가능하고, data는 읽기만 가능하게 변경...
    			document.form.ofc_cd.readOnly = false;
    			document.all.item("btng_csrcancel_yn")[0].style.display = "none";
    			document.all.item("btng_csrcancel_yn")[1].style.display = "inline";
    		} else {
    			document.form.ofc_cd.readOnly = true;
    			document.all.item("btng_csrcancel_yn")[0].style.display = "inline";
    			document.all.item("btng_csrcancel_yn")[1].style.display = "none";
    		}
     
    		try	{
    			//csr_getInputValue('DB_DATE', COMMAND05, '', 'setPeriodFromTo');
    		} catch(e){}
    */
    		csr_setBackColorAllTextTypeReadonly(document.form);
	
    		//권한 로케이션 정보에 따라 날짜가져오기
    		var formObj  = document.form;
    		var sheetObj = sheetObjects[0];

    		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
    		setPeriodFromTo();
    		document.form.fm_eff_dt.focus();
    		
    		//CSR 생성후 화면 이동시에는 'Requesting Approval'를 선택 
    		if(ifStatus!='' && ifStatus!=null && ifStatus=='RA') {
    			document.form.if_status.options[1].selected = true;
    		}

    		if(document.form.search_csr_no.value != ''){
    			retrieve();
    		}   	
    		
    		if(document.form.inv_sub_sys_cd.value == "CNI"){
    			ComBtnDisable("btng_agreement");
    		} 
    		
    	}

    	function setPeriodFromTo(){
    		/* from 한달전 ~ to 오늘 */
    		var formObj = document.form;
    		var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
    		var fr_dt;
    		if (to_dt!=undefined && to_dt!=null && to_dt.trim()!='' && to_dt.length==8 && !isNaN(to_dt)){
    			//fr_dt = csr_getDiffDate(to_dt, -30, 'D');
    			fr_dt = csr_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
    			if (fr_dt!=undefined && fr_dt!=null && fr_dt.trim()!='' && fr_dt.length==8){
    				if (fr_dt.substring(6,8) > getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6))){
    					fr_dt = fr_dt.substring(0,6) + getEndDay(fr_dt.substring(0,4),fr_dt.substring(4,6));
    				}
    				formObj.fm_eff_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
    				formObj.to_eff_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
    			}
    		}
    		if (formObj.fm_eff_dt.value!=null && formObj.to_eff_dt.value!=null){
    			// LEA에서 조회를 위해 넘어올 경우 readonly_yn의 값을 받아 자동 조회를 실행한다..
    			if (readonly_yn!=undefined && readonly_yn!=null && readonly_yn=='Y'){
    				retrieve();
    			}
    		}
    	}

        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                 case 1:      //sheet1 init
                    with (sheetObj) {
    	                // 높이 설정
                        style.height = 370;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
                        
                        MultiSelection = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					 InitColumnInfo(31, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

    					var HeadTitle1 = "|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error\nReason|No. of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|ASA No.|USD Amount|GW\nContract|Contract|Files|Apro Type|Create User" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        sheetObj.FrozenCols = 2;
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
    					InitDataProperty(0, cnt++ , dtData,	150, daCenter,			false,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "vndr_no",			false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData, 150, daLeft,			false,    "inv_desc",			false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	120, daLeft,			false,    "if_status",			false,			"",			dfNone,			0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,		    false,    "if_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	60, daLeft,			    false,    "if_err_rsn",			false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	50, daCenter,			false,    "no_of_inv",			false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "csr_curr_cd",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	80, daRight,			false,    "csr_amt",			false,			"",			dfFloat,			2,			false,			false	);

    					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,		    false,    "due_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	120,daLeft,		    	false,    "pay_grp_lu_cd",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	80, daLeft,				false,    "attr_ctnt2",			false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	80, daRight,			false,    "csr_usd_amt",		false,			"",			dfFloat,		0,			false,			false	); //Hidden으로 수정 2017-04-17

    					InitDataProperty(0, cnt++ , dtPopup,60, daCenter,			false,    "agmt_doc_cfm_cd",	false,			"",			dfNone,			0,			true,			true	);
    					InitDataProperty(0, cnt++ , dtPopup,60, daCenter,			false,    "agmt_file_cfm_cd",	false,			"",			dfNone,			0,			true,			true	);
    					InitDataProperty(0, cnt++ , dtPopup,50, daCenter,			false,    "file_upld_flg",		false,			"",			dfNone,			0,			true,			true	);
    					InitDataProperty(0, cnt++ , dtCombo,80, daCenter,			false,    "csr_apro_tp_cd",		false,			"",			dfNone,			0,			false,			false	);  	
    					InitDataProperty(0, cnt++ , dtData,	80, daCenter,			false,    "cre_usr_id",			false,			"",			dfNone,			0,			false,			false	);  
    					
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "iss_dt",				false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "rcv_dt",				false,			"",			dfNone,			0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "vndr_term_nm",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "aft_act_flg",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "if_flg",				false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "rcv_err_flg",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "tml_inv_sts_cd",		false,			"",			dfNone,			0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "tml_inv_rjct_sts_cd",false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "apro_rqst_no",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "cost_ofc_cd",		false,			"",			dfNone,			0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "acct_xch_rt_yrmon",	false,			"",			dfNone,			0,			false,			false	);
    					
    					InitDataProperty(0, cnt++ , dtHidden,	80, daLeft,			false,    "chk_gw_2_al",		false,			"",			dfNone,			0,			false,			false	);
                     	
    					InitDataCombo(0, "csr_apro_tp_cd", "G/W|ALPS", "GW|AL");
    					PopupImage  =  "/hanjin/img/btns_search.gif";  
                        ShowButtonImage = 2; 
                 	}
                    break;

                case 2:      //sheet2 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = GetSheetHeight(13);
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
                        InitColumnInfo(24, 1, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;
    					var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|apro_step|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daLeft,			false,    "pre_csr_no",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_office",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_prpd_dy",			false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_to",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_csr_type",			false,			"",			dfNone,				0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_desc",					false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_group",		false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_evi_tp",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_due_date",			false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_asa_no",				false,			"",			dfNone,				0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_inv_dt",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_curr_cd",			false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_amt",					false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_curr_cd",	false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_amt",					false,			"",			dfNone,				0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "apro_step",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_title",				false,			"",			dfNone,				0,			false,			false	);
    		            // CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr1",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr2",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr3",				false,			"",			dfNone,				0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_cty_nm",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_ste_cd",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_zip_cd",				false,			"",			dfNone,				0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_cnt_cd",				false,			"",			dfNone,				0,			false,			false	);

                   }
                    break;

                case 3:      //sheet3 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = GetSheetHeight(13);
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
                        InitColumnInfo(10, 1, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|debit2|credit2" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "pre_chart_of_account",		false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData, 			80,			daCenter,		false,    "pre_account_name",				false,			"",			dfNone,					0,			true,			true	);
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daLeft,			false,    "pre_gl_date",						false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_city",								false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_inv_no",							false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_desc",								false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_debit",							false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_credit",							false,			"",			dfNone,					0,			false,			false	);

    					InitDataProperty(0, cnt++ , dtHidden,	 		0,			daRight,		false,    "pre_debit2",							false,			"",			dfNone,					0,			false,			false	);
    					InitDataProperty(0, cnt++ , dtHidden,	 		0,			daRight,		false,    "pre_credit2",						false,			"",			dfNone,					0,			false,			false	);
                   }
                    break;

            }
        }

        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
               case IBSEARCH:      //조회
                    if (!validateForm(sheetObj,formObj,sAction)){
    			        return false;
    			    }
	    			formObj.f_cmd.value = SEARCHLIST;
	    			sheetObj.DoSearch("COM_CSR_0008GS.do", FormQueryString(formObj));
                    break;
                    
               case IBSAVE:        //저장
    				if (!validateForm(sheetObj,formObj,sAction)){
    			        return false;
    			    }
    				formObj.f_cmd.value = MULTI;
    				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');

    				var sXml = sheetObj.GetSaveXml("COM_CSR_00081GS.do", FormQueryString(formObj));
    				sheetObj.LoadSaveXml(sXml,true);
                    break;

               case IBSEARCH_ASYNC01:        //cancel
    				if (!validateForm(sheetObj,formObj,sAction)){
    			        return false;
    			    }
    				formObj.f_cmd.value = SEARCH01;
    				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
    				formObj.csr_apro_tp_cd.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_apro_tp_cd');				

        			var sXml = sheetObj.GetSaveXml("COM_CSR_00081GS.do", FormQueryString(formObj));
        			//sheetObj.LoadSearchXml(sXml);
        			retrieve();
                    break;

	       		case IBSEARCH_ASYNC02:	//권한 로케이션 날짜 조회
	    			var sXml = csr_getInputValue(sheetObj,formObj.ofc_cd.value);

	    			//if(ComGetEtcData(sXml, "ofc_cd") != 'null'){
	    				ComSetObjValue(formObj.DB_DATE, ComGetEtcData(sXml, "curr_date"));
	    			//}
	    			break;
	    		
	       		case IBSEARCH_ASYNC03:	//결재 요청(GW)

	    			formObj.f_cmd.value = MULTI10;
	    			formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');

	    			var sXml = sheetObj.GetSearchXml("COM_CSR_00081GS.do", FormQueryString(formObj),"",true);
	    			
	    			var gwUrl = ComGetEtcData(sXml , "GW_URL");
	    			
	    			if (ComIsNull(gwUrl)) {
	    				ComShowMessage(ComGetMsg('CSR25006'));
	    				return;
	    			}
	    			
	    			ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
		    			
		    		retrieve(); 			
	    			
	    			break;	
	    			
	       		case IBSEARCH_ASYNC04:  //결재 요청(AL)
    				if (!validateForm(sheetObj,formObj,sAction)){
    			        return false;
    			    }
    				formObj.f_cmd.value = MULTI11;
    				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
    				
    				//CSR Create 화면에서 사용하는 input name과 동일하게 변수명을 설정해야 Apro Step 정보 생성시 값이 저장된다.
    				formObj.vndr_seq.value = sheetObj.CellValue(sheetObj.SelectRow,'vndr_no');
    				formObj.inv_knt.value = sheetObj.CellValue(sheetObj.SelectRow,'no_of_inv');
    				formObj.curr_cd.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_curr_cd');   
    				formObj.total_amt.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_amt');
    				formObj.max_iss_dt.value = sheetObj.CellValue(sheetObj.SelectRow,'iss_dt');
    				formObj.max_rcv_dt.value = sheetObj.CellValue(sheetObj.SelectRow,'rcv_dt');
    				formObj.payment_due_dt.value = sheetObj.CellValue(sheetObj.SelectRow,'due_dt');

        			var sXml = sheetObj.GetSaveXml("COM_CSR_00081GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveXml(sXml); //공통모듈 Err메시지 출력 CHM-201535042 심성윤
        			retrieve();
                    break;
	    		
    		}
        }

        function doActionIBSheet1(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
               case IBSEARCH:      //조회
	   			formObj.f_cmd.value = SEARCH02;
	   			formObj.csr_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no'); //이미 csr_no가 존재하는지 위에서 검사
	   			var sXml = sheetObjects[2].GetSearchXml("COM_CSR_00081GS.do", FormQueryString(formObj),"",true);

	   			var arrXml = sXml.split("|$$|");
	   			sheetObjects[1].LoadSearchXml(arrXml[0]);	//플릿폼
	   			sheetObjects[2].LoadSearchXml(arrXml[1]);	//리스트

	           break;
            }
        }
        
        /**
         * PDT 화면에서 호출하여 사용 -> PDT 화면 사용 안함
         */
        /*
        function doPaymentSlip() {
        	var formObj = document.form;
   			formObj.f_cmd.value = SEARCH02;
   			//formObj.csr_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no'); //이미 csr_no가 존재하는지 위에서 검사
   			formObj.csr_no.value = parent.document.form.csr_no.value;
   			var sXml = sheetObjects[2].GetSearchXml("COM_CSR_00081GS.do", FormQueryString(formObj),"",true);

   			var arrXml = sXml.split("|$$|");
   			sheetObjects[1].LoadSearchXml(arrXml[0]);	//플릿폼
   			sheetObjects[2].LoadSearchXml(arrXml[1]);	//리스트

        }*/

    	/**
         * ALPS approval step 정보 가져오기
         *  -> ALPS approval step를 가져오는 부분에 대해서 sheet1_OnChange에 반영했지만 이후 sheet1_OnClick에도 반영해서 공통화 해야함 
         * @param
         * @return
         */
    	function getAlpsAproStepInfo(){
	    	var cost_ofc_cd = (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_ofc_cd"));
	    	//Apro Step 정보를 AproUtil에서 조회한다.
	    	document.form.f_cmd.value = SEARCH10;
	    	document.form.cost_ofc_cd.value = cost_ofc_cd;

	        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_00081GS.do" , FormQueryString(form)); 

	        var apro_seq_key = ComGetEtcData(sXml,"apro_seq_key");
	        var cost_apro_seq_key = ComGetEtcData(sXml,"cost_apro_seq_key");
	        var login_apro_seq_key = ComGetEtcData(sXml,"login_apro_seq_key");
	        
	        var cost_apro_step = ComGetEtcData(sXml,"cost_apro_step");
	        var login_apro_step = ComGetEtcData(sXml,"login_apro_step");

	        document.form.aproSeqKey.value = apro_seq_key;
	        document.form.cost_aproSeqKey.value = cost_apro_seq_key;
	        document.form.login_aproSeqKey.value = login_apro_seq_key;
	        
	        document.form.cost_apro_step.value = cost_apro_step;
	        document.form.login_apro_step.value = login_apro_step;
	        document.form.apro_step.value = login_apro_step;
    	}
        
    	function sheet1_OnSearchEnd(sheet1, ErrMsg){
    		if (sheet1.RowCount > 0){
    			for (var i=1; i<=sheet1.RowCount; i++){
    				if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
    					sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
    				}
    				
    				/*결재 유형 변경 콤보 유무 제공  SY SHIM*/
//    				document.form.csr_no.value = sheet1.CellValue(i,'csr_no');
//    				var csrNo = document.form.csr_no.value;
//    				document.form.f_cmd.value = SEARCH03;
//    			    var sXml = sheet1.GetSearchXml("COM_CSR_0002GS.do", FormQueryString(document.form)+"&csr_no="+csrNo);
//    			    var chkOfc = ComGetEtcData(sXml,"CN_OFC_CHK");
//    			    sheet1.CellValue(i,'chk_gw_2_al') = chkOfc;
    			    if(sheet1.CellValue(i,'chk_gw_2_al') == 'Y'){
    			    	sheet1.CellEditable(i, 'csr_apro_tp_cd') = true;
    			    	sheet1.InitCellProperty(i,'csr_apro_tp_cd', dtCombo);
    			    	sheet1.CellComboItem(i, 'csr_apro_tp_cd', 'ALPS|G/W', 'AL|GW'); 
    			    }
    			}
    		}
    		//sheet1.CellValue(1,'if_status') = 'A/P Rejected';	//A/P Rejected 팝업 건건이 인보이스 취소 테스트 하기위해 임시로
    		//화면 조회후 처음에는 Apro Step을 보여주지 않는다.  2014.11.04 
    		document.all.btng_apro_step.style.visibility = "hidden"; 
    		document.form.apro_step.value = "";
    	}
    	
    	/**
         * Sheet관련 프로세스 처리
         * 
         * @param {ibsheet} sheet1	ibsheet ojbect
         * @param {String}  Row, Col      
         * @return
         */
    	function sheet1_OnChange(sheet1, Row, Col){
    		/*결재 유형 변경시 이벤트  SY SHIM*/
    		if(sheet1.CellValue(Row, 'csr_apro_tp_cd') == 'GW'){
    			document.all.btng_apro_step.style.visibility = "hidden"; 
        		//document.form.apro_step.value = "";
    		}else{
    			if(sheet1.CellValue(Row,"if_status")=="Requesting Approval" && sheet1.CellValue(Row,"csr_apro_tp_cd")=="AL") {
    				document.all.btng_apro_step.style.visibility = "visible";
    		    	// Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
    		    	if(document.form.cost_ofc_cd.value ==document.form.inv_ofc_cd.value) {
    		    		ComEnableObject(document.form.ofc_tp[0], false);
    		    		ComEnableObject(document.form.ofc_tp[1], false);
    		    	}else{
    		    		ComEnableObject(document.form.ofc_tp[0], true);
    		    		ComEnableObject(document.form.ofc_tp[1], true);
    		    	}
    		    	if (document.form.apro_step.value==null || document.form.apro_step.value==''){
    		    		getAlpsAproStepInfo();	
    		    	}
    			}
    		}
    	}
    	
    	/**
         * Sheet관련 프로세스 처리
         * 
         * @param {ibsheet} sheet1	ibsheet ojbect
         * @param {String}  Row, Col      
         * @return
         */
    	function sheet1_OnClick(sheet1, Row, Col) {
    		var formObj = document.form;
    		
    		if(sheet1.RowCount > 0){
    			if(sheet1.CellValue(Row,"if_status")=="Requesting Approval" && sheet1.CellValue(Row,"csr_apro_tp_cd")=="AL") {
    				
    				document.all.btng_apro_step.style.visibility = "visible"; 
    				
    		    	// Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
    		    	if(document.form.cost_ofc_cd.value ==document.form.inv_ofc_cd.value) {
    		    		ComEnableObject(document.form.ofc_tp[0], false);
    		    		ComEnableObject(document.form.ofc_tp[1], false);
    		    	}else{
    		    		ComEnableObject(document.form.ofc_tp[0], true);
    		    		ComEnableObject(document.form.ofc_tp[1], true);
    		    	}
    		    	
//    		    	var cost_ofc_cd = (sheet1.CellValue(Row,"cost_ofc_cd"));
//    		    	//Apro Step 정보를 AproUtil에서 조회한다.
//					formObj.f_cmd.value = SEARCH10;
//					formObj.cost_ofc_cd.value = cost_ofc_cd;
//
//			        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_00081GS.do" , FormQueryString(form)); 
//
//			        var apro_seq_key = ComGetEtcData(sXml,"apro_seq_key");
//			        var cost_apro_seq_key = ComGetEtcData(sXml,"cost_apro_seq_key");
//			        var login_apro_seq_key = ComGetEtcData(sXml,"login_apro_seq_key");
//			        
//			        var cost_apro_step = ComGetEtcData(sXml,"cost_apro_step");
//			        var login_apro_step = ComGetEtcData(sXml,"login_apro_step");
//
//			        formObj.aproSeqKey.value = apro_seq_key;
//			        formObj.cost_aproSeqKey.value = cost_apro_seq_key;
//			        formObj.login_aproSeqKey.value = login_apro_seq_key;
//			        
//			        formObj.cost_apro_step.value = cost_apro_step;
//			        formObj.login_apro_step.value = login_apro_step;
//			        formObj.apro_step.value = login_apro_step;
    				
			        getAlpsAproStepInfo(); //요걸루 통일
			        
    			} else {	//GW 결재 Requesting Approval
    				document.all.btng_apro_step.style.visibility = "hidden";	//Apro Step 안보임
    			}   			
    		}
    	}
    	
    	function sheet1_OnSaveEnd(sheet1, ErrMsg){
    		if (sheet1.RowCount > 0){
    			for (var i=1; i<=sheet1.RowCount; i++){
    				if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
    					sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
    				}
    			    if(sheet1.CellValue(i,'chk_gw_2_al') == 'Y'){
    			    	sheet1.CellEditable(i, 'csr_apro_tp_cd') = true;
    			    	sheet1.InitCellProperty(i,'csr_apro_tp_cd', dtCombo);
    			    	sheet1.CellComboItem(i, 'csr_apro_tp_cd', 'ALPS|G/W', 'AL|GW'); 
    			    }    				
    			}
    		}
    	}
    	
    	function sheet1_OnPopupClick(sheet1, Row, Col) {
    		var colName = sheet1.ColSaveName(Col);

    	   	if (colName == "agmt_doc_cfm_cd" || colName == "agmt_file_cfm_cd" || colName == "file_upld_flg") {
    	   		if (sheet1.RowCount > 0){
    	   			var v_csr_no = sheet1.CellValue(Row, "csr_no");
    	   			var ifStatus = sheet1.CellValue(Row, "if_status");
					var tpCd = sheet1.CellValue(Row, "csr_apro_tp_cd");
					
					openPopupAgmtFiles(v_csr_no, ifStatus, tpCd);
    	   		}
    	   	}
    	}
    	
        function sheet3_OnSearchEnd(sheetObj,errMsg){
         	//var srcName = window.event.srcElement.getAttribute("name");
            if(errMsg!=null){
                showErrMessage(errMsg);
            }
            var previewFlg    = "";
            var pre_csr_no    = sheetObjects[1].CellValue(1,"pre_csr_no") 	 ;
            var pre_prpd_dy   = sheetObjects[1].CellValue(1,"pre_prpd_dy")  ;
            var pre_pay_to    = sheetObjects[1].CellValue(1,"pre_pay_to") 	 ;
            var pre_csr_type  = sheetObjects[1].CellValue(1,"pre_csr_type") ;
            var pre_desc      = sheetObjects[1].CellValue(1,"pre_desc") 		 ;
            var pre_pay_group = sheetObjects[1].CellValue(1,"pre_pay_group");
            var pre_evi_tp    = sheetObjects[1].CellValue(1,"pre_evi_tp") 	 ;
            var pre_due_date  = sheetObjects[1].CellValue(1,"pre_due_date") ;
            var pre_asa_no    = sheetObjects[1].CellValue(1,"pre_asa_no") 	 ;
            var pre_inv_dt    = sheetObjects[1].CellValue(1,"pre_inv_dt") 	 ;
            var pre_curr_cd   = sheetObjects[1].CellValue(1,"pre_curr_cd")  ;
            var pre_amt       = sheetObjects[1].CellValue(1,"pre_amt") 		 ;
            var pre_pay_curr_cd   = sheetObjects[1].CellValue(1,"pre_pay_curr_cd")  ;
            var pre_pay_amt       = sheetObjects[1].CellValue(1,"pre_pay_amt") 		 ;
            var pre_title     = sheetObjects[1].CellValue(1,"pre_title") 	 ;
            var apro_step	  = sheetObjects[1].CellValue(1,"apro_step") 	 ;
            
            // CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)                       
            var chk_addr1     = sheetObjects[1].CellValue(1,"chk_addr1") 	 ;
            var chk_addr2     = sheetObjects[1].CellValue(1,"chk_addr2") 	 ;
            var chk_addr3     = sheetObjects[1].CellValue(1,"chk_addr3") 	 ;
            var chk_cty_nm    = sheetObjects[1].CellValue(1,"chk_cty_nm") 	 ;
            var chk_ste_cd    = sheetObjects[1].CellValue(1,"chk_ste_cd") 	 ;
            var chk_zip_cd    = sheetObjects[1].CellValue(1,"chk_zip_cd") 	 ;
            var chk_cnt_cd    = sheetObjects[1].CellValue(1,"chk_cnt_cd") 	 ;
            //var ofc_cd        = document.form.ofc_cd.value;
            var ofc_cd		  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'cost_ofc_cd');
            
    		var pre_evi_tp_count	= "";
    		var pre_title	  = "CONSULTATION SLIP";

    		var pre_evi_tp;
    		if(cnt_cd =="KR"){
    			pre_evi_tp_count ="1";
    			pre_evi_tp  = pre_evi_tp;
    		}else{
    			var sRow = sheetObjects[0].FindCheckedRow(1);
    			var arrRow = sRow.split("|");
    			pre_evi_tp_count =arrRow.length-1;
    			pre_evi_tp_count = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'no_of_inv');
    			pre_evi_tp = pre_evi_tp+"/"+pre_evi_tp_count;
    		} 

            if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
             	previewFlg = "krjp";
             	pre_amt = csr_chkAmtFmt(pre_amt,pre_curr_cd);
             	pre_pay_amt = csr_chkAmtFmt(pre_pay_amt,pre_curr_cd);
            }else{
            	pre_amt = csr_chkAmtFmt(pre_amt);
            	pre_pay_amt = csr_chkAmtFmt(pre_pay_amt);
            }
            
            //다시 셋팅 
            sheetObjects[1].RemoveAll();
    		sheetObjects[1].DataInsert(-1);

            sheetObjects[1].CellValue(1,"pre_csr_no") 	= pre_csr_no   ;
            sheetObjects[1].CellValue(1,"pre_prpd_dy")  = pre_prpd_dy  ;
            sheetObjects[1].CellValue(1,"pre_pay_to") 	= pre_pay_to   ;
            sheetObjects[1].CellValue(1,"pre_csr_type") = pre_csr_type ;
            sheetObjects[1].CellValue(1,"pre_desc") 	= pre_desc     ;
            sheetObjects[1].CellValue(1,"pre_pay_group")= pre_pay_group;
            sheetObjects[1].CellValue(1,"pre_evi_tp") 	= pre_evi_tp   ;
            sheetObjects[1].CellValue(1,"pre_due_date") = pre_due_date ;
            sheetObjects[1].CellValue(1,"pre_asa_no") 	= pre_asa_no   ;
            sheetObjects[1].CellValue(1,"pre_inv_dt") 	= pre_inv_dt   ;
            sheetObjects[1].CellValue(1,"pre_curr_cd")  = pre_curr_cd  ;
            sheetObjects[1].CellValue(1,"pre_amt") 		= ComReplaceStr(pre_amt,",","");
            sheetObjects[1].CellValue(1,"pre_pay_curr_cd")  = pre_pay_curr_cd  ;
            sheetObjects[1].CellValue(1,"pre_pay_amt") 	= ComReplaceStr(pre_pay_amt,",","");
            sheetObjects[1].CellValue(1,"pre_title") 	= pre_title    ;
            sheetObjects[1].CellValue(1,"apro_step") 	= apro_step    ;
            sheetObjects[1].CellValue(1,"pre_office") 	= ofc_cd;

            sheetObjects[1].CellValue(1,"chk_addr1") 	= chk_addr1    ;
            sheetObjects[1].CellValue(1,"chk_addr2") 	= chk_addr2    ;
            sheetObjects[1].CellValue(1,"chk_addr3") 	= chk_addr3    ;
            sheetObjects[1].CellValue(1,"chk_cty_nm") 	= chk_cty_nm   ;
            sheetObjects[1].CellValue(1,"chk_ste_cd") 	= chk_ste_cd   ;
            sheetObjects[1].CellValue(1,"chk_zip_cd") 	= chk_zip_cd   ;
            sheetObjects[1].CellValue(1,"chk_cnt_cd") 	= chk_cnt_cd   ;
    		
    		//  'Approval Requested'이거나 'Disapproved'인 경우에는 print화면의 'APPRD BY'란을 채우지 않는다.  
    		var v_apro_step = '';

    		if (sheetObjects[0].RowCount > 0 &&
    			(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')!='Approval Requested' && sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')!='Disapproved'))
    		{
    			//
    		}else{
    			//sheetObjects[1].CellValue(1,"apro_step") 		=  "";
    		}
    		
    		window.showModalDialog("/hanjin/COM_CSR_0006.do?previewFlg="+previewFlg+"&previewFlgYN=N", window, "dialogWidth:775px; dialogHeight:750px; help:no; status:no; scroll:no; resizable:no;");
    		//ComOpenPopup('/hanjin/COM_CSR_0006.do?previewFlg='+previewFlg+'&previewFlgYN=N', 775, 700, "", "0,1,1,1,1,1");
        }
         
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
//                    return false;
//                }
            }

            return true;
        }
            
      	/** 
         * Object 의 Keypress 이벤트에 대한 처리  <br>
         * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */ 
        function obj_keypress(){
       	 obj = event.srcElement;
       	 if(obj.dataformat == null) return;
       	 	
       	 window.defaultStatus = obj.dataformat;
       	 switch(obj.dataformat) {
       	 	case "ymd":
       	 		ComKeyOnlyNumber(obj);
       	        break;
       	    case "eng":
       	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    case "engup":
       	        if(obj.name=="eq_no") ComKeyOnlyAlphabet('uppernum')
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    
       	 }
        } 
        
        /** 
         * Object 의 deactivate 이벤트에 대한 처리  <br>
         * @param  없음
         * @return 없음
         * @author 최민회
         * @version 2009.05.20
         */
        function obj_deactivate(){
       	 var formObj = document.form;
       	 obj = event.srcElement;
         
       	 if(obj.name=="fm_eff_dt"  ){
           			
       		 with(formObj){
    	        			
       			 var creDtFr = ComReplaceStr(fm_eff_dt.value,"-","");
    	        }
    	        	
    	        ComChkObjValid(event.srcElement);
           }
         	if(obj.name=="to_eff_dt"  ){
    			
      		 with(formObj){
    	        			
      			 var creDtFr = ComReplaceStr(to_eff_dt.value,"-","");
    	        }
    	        	
    	        ComChkObjValid(event.srcElement);
          }
           	
        }
         
         /**
          * AXON 이벤트 처리
          */
         function obj_activate(){
             ComClearSeparator(event.srcElement);
         }
         
         /**
          * 2013.02.12 조인영 [CHM-201322900]
          * Cost Office, Log-in Office Radio 버튼 클릭시 Approval Step 변경
          */
         function ofcChange(){
         	var formObj = document.form;

         	var apro_step = "";
         	var aproSeqKey = "";
         	if(formObj.ofc_tp[0].checked){
         		apro_step = formObj.cost_apro_step.value;
         		aproSeqKey = formObj.cost_aproSeqKey.value;
         	}else if (formObj.ofc_tp[1].checked){
         		apro_step = formObj.login_apro_step.value;
         		aproSeqKey = formObj.login_aproSeqKey.value;
         	}
         	formObj.apro_step.value = apro_step;
         	formObj.aproSeqKey.value = aproSeqKey;
         }
         
     	/**
     	 * Agreement File popup
     	 * 
     	 * @param v_csr_no
     	 * @param ifStatus
     	 * @param tpCd
     	 */
         function openPopupAgmtFiles(v_csr_no, ifStatus, tpCd){         	
         	var tabStatus = "";
         	var readOnly = "";
         	var invSubSysCd = "";
         	
         	invSubSysCd = document.form.inv_sub_sys_cd.value;
         	//alert(invSubSysCd);
         	if(invSubSysCd == "PSO") {
				tabStatus = "0|1|1";
			} else {
				if(tpCd=='GW') {
					tabStatus = "1|0|1";
				} else {
					tabStatus = "1|1|1";
				}
			}	
         	
         	if(ifStatus=="Requesting Approval") {			
				readOnly = "N";
			} else {
				readOnly = "Y";
			}	
         	//[CHM-201535807] invSubSysCd값을 0023으로 넘겨줌
         	var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus="+tabStatus+"&readOnly="+readOnly+"&invSubSysCd="+invSubSysCd;
         	
            ComOpenPopup(url, 1020, 580, '', 'none', true); 
            
            retrieve(); 					
         }
	/* 개발자 작업  끝 */

        /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
