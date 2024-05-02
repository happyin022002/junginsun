/***
 * 
 * 2009-02-24 : CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 송민정 요청 )
 * 2014.09.29 김영신 [CHM-201432136] Files, Edit Approval Step, View Approval Step 버튼 제거 
 */

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;

	document.onclick = processButtonClick;
	
	/**
     * 검색시
     * 	
     * @return
     */
	function retrieve(){
		
		var formObject = document.form;
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	}
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 *  
	 * @return
	 */
    function processButtonClick(){

         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];

         
         /*******************************************************/
         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					retrieve();
					break;

				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					try	{
						tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
					} catch(e){}
					document.form.fm_eff_dt.focus();
					break;
				/*
				case "btng_editapprovalstep"://alert("start btng_editapprovalstep");
					if (sheetObjects[0].RowCount > 0 && sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')=='Approval Requested') 
					{
//						var param = '?mode=csr&csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')+'&classId=COM_ENS_0T2';
//						ComOpenPopup('/hanjin/COM_ENS_0T2.do'+param, 835, 550, '', 'none', true);	
						
						with(document.form){
							var v_ofc_cd = ofc_cd.value;
							var param = '?mode=save&ofc_cd='+v_ofc_cd+'&csr_no='+sheetObject.CellValue(sheetObject.SelectRow,'csr_no')+'&sub_sys_cd=TES'+'&classId=COM_ENS_0T1&target_obj_nm=apro_step';
								ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
						}
					}
					break;
				*/
				case "btng_csrformat":
					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TES25006'));//ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TES21908'));//ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}
					sheetObject1.RemoveAll(); 
					sheetObject2.RemoveAll();
					doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
					break;

				case "btng_invoicelistinquiry":
					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TES25006'));//ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TES21908'));//ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}

					var url = 'ESD_TES_0101.screen';
					url = url + '?csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')+'&cost_ofc_cd='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'cost_ofc_cd')
					window.showModalDialog(url, window, "dialogWidth:940px; dialogHeight:450px; help:no; status:no; resizable:yes;");
					break;

				case "btng_csrcancel"://alert("start btng_csrcancel");
					// session의 ofc_cd와 입력란의 ofc_cd가 동일한지 확인하는 부분...
					if (OFC_CD==undefined || OFC_CD==null || OFC_CD.trim()==''){
						ComShowMessage('No Inv OFC data is found in the session');
						return false;
					}
					if (formObject.ofc_cd.value==undefined || formObject.ofc_cd.value==null || formObject.ofc_cd.value.trim()==''){
						ComShowMessage('No Invoice Office data');
						return false;
					}
					if (OFC_CD != formObject.ofc_cd.value){
						//ComShowMessage("Inv OFC data retrieved don't match Inv OFC data in the session");
						//ComShowMessage("login Inv OFC is not authorized");
						ComShowMessage("No authority to cancel CSR - Invoice office mismatch!");
						return false;
					}

					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TES25006')); //ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						//ComShowMessage('선택된 row가 없습니다.');
						ComShowMessage(ComGetMsg('TES21908'));
						return false;
					}
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'aft_act_flg')=='N' || sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'aft_act_flg')=='X') {
						return false;
					}
					/*
					var if_flg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_flg');
					var rcv_err_flg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rcv_err_flg');
					var tml_inv_sts_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'tml_inv_sts_cd');
					var tml_inv_rjct_sts_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'tml_inv_rjct_sts_cd');
					if (if_flg=='E'){ //'I/F Error' -> 바로 수정하기
						doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					} else if (rcv_err_flg=='E' || (tml_inv_sts_cd=='A' && tml_inv_rjct_sts_cd=='RJ')){ //'A/P Rejected' or 'Disapproved' -> popup창으로 이동
						var url = 'ESD_TES_0025.screen';
						url = url + '?csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
						url = url + '&vndr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'vndr_no');
						url = url + '&inv_desc='+encodeURI(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'inv_desc'));
						url = url + '&no_of_inv='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'no_of_inv');
						url = url + '&csr_curr_cd='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_curr_cd');
						url = url + '&csr_amt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_amt');					
						url = url + '&attr_ctnt2='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'attr_ctnt2');
						url = url + '&iss_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'iss_dt');
						url = url + '&rcv_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rcv_dt');
						url = url + '&vndr_term_nm='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'vndr_term_nm');
						url = url + '&due_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'due_dt');
						window.showModalDialog(url, window, "dialogWidth:940px; dialogHeight:500px; help:no; status:no; resizable:yes;");
					}
					*/

					/* GROUP BY  문제로 일단 IF_STATUS 문구로 상태를 확인합당... DB query에서 I/F STS.값을 변경하면 반드시 맞게 수정해야한다. 꼭~ */
					/* 2008-09-02 : 전차장 요청 - Approval Requested상태의 CSR도 cancel 처리 가능하게 한다.  */
                    //  2. GW 결재인 경우 Requesting Approval 상태만 CSR cancel 
					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status');
					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
					
					if(ComShowConfirm(ComGetMsg('TES21055'))){
						if (sheetObjects[0].RowCount > 0 && (ifStatus=='Requesting Approval' || (ifStatus=='Approval Requested' && tpCd=='AL'))) {
							/** 
								Approval Requested상태의 CSR은 바로 수정한다 - AP I/F를 아직 안한 상태이므로 cancel시 공통의 결재자 정보도 없애야 한다. 
							**/
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);	
						} else {
							/** 
								Approval Requested상태의 CSR 수정가능 이전 logic  - AP I/F를 이미 한 상태이므로 cancel시 공통의 결재자 정보를 신경쓰지 않아도 된다.
							**/
							if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')=='I/F Error' ) { 
								/* 'I/F Error' -> popup없이 바로 수정하기 */
								doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
							} else if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')=='A/P Rejected' || sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')=='Disapproved') {
								/* 'A/P Rejected' or 'Disapproved' -> popup창으로 이동 */
								var url = 'ESD_TES_0025.screen';
								url = url + '?csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no');
								url = url + '&vndr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'vndr_no');
								url = url + '&inv_desc='+encodeURI(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'inv_desc'));
								url = url + '&no_of_inv='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'no_of_inv');
								url = url + '&csr_curr_cd='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_curr_cd');
								url = url + '&csr_amt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_amt');					
								url = url + '&attr_ctnt2='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'attr_ctnt2');
								url = url + '&iss_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'iss_dt');
								url = url + '&rcv_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rcv_dt');
								url = url + '&vndr_term_nm='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'vndr_term_nm');
								url = url + '&due_dt='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'due_dt');
								window.showModalDialog(url, window, "dialogWidth:940px; dialogHeight:500px; help:no; status:no; resizable:yes;");
							}
						}
					}
					break;
				
				case "btng_viewapprovalstep":
					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TES25006')); //ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TES21908')); //ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}
					
                	var apro_rqst_no = sheetObject.CellValue(sheetObjects[0].SelectRow, "apro_rqst_no");
					if (apro_rqst_no==undefined || apro_rqst_no==null || apro_rqst_no.trim()==''){
						//ComShowMessage(ComGetMsg('TES40041','Approval Request No')); //ComShowMessage('가 누락되었습니다.');
						return false;
					}

					var param = "?apro_rqst_no="+apro_rqst_no+"&btn_flag=N";
					ComOpenPopup("COM_CSR_0020.do" + param, 615, 280, "", "1,0,1,1,1", true);
					break;
				
				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.select(formObject.fm_eff_dt, 'yyyy-MM-dd');
					break;

				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.to_eff_dt, 'yyyy-MM-dd');
					break;

				case "btng_print":
					/* 2008-11-18 : 부산의 요청에 의해 Excel로 download 기능 추가 */
					sheetObjects[0].SpeedDown2Excel(true);
					break;
				/*	
				case "btng_files":
					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TES25006')); //ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TES21908')); //ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
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
						ComShowMessage(ComGetMsg('TES25006'));//ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TES21908'));//ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
						return false;
					}
					
					var ifStatus = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status');
					var tpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_apro_tp_cd');
					
					/* [CHM-201539621]Split01-결재시스템 선택 가능토록 화면 수정 (2016.01.12) - 변경된 APRO_TYPE 저장  */	
					if (sheetObjects[0].RowCount > 0){
						if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'ibflag')=='U'){
							var param = "f_cmd="+MULTI+"&csr_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')+"&apro_tp_cd="+tpCd;
    		    			var sXml = sheetObjects[0].GetSaveXml("COM_CSR_0016GS.do", param);
		    			}
		    		}

					if(ifStatus=='Requesting Approval' && tpCd=='GW') {
						doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC02);
					} else if(ifStatus=='Requesting Approval' && tpCd=='AL') {
						if(formObject.apro_step.value==undefined || formObject.apro_step.value==null || formObject.apro_step.value.trim()==''){
							ComShowMessage(ComGetMsg('TES25020'));
							return false;
						} else {
							doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC03);
						}						
					} else{
						return false;
					}

					break;
										
				case "btng_search":
					
					var v_ofc_cd = ""; //2013.01.29 CSR Approval Step 결재선 변경 기능 추가(양양선 부장 요청)

					if(document.form.ofc_tp[0].checked){
						v_ofc_cd = document.form.cost_ofc_cd.value;
					}else if (document.form.ofc_tp[1].checked){
						v_ofc_cd = document.form.ofc_cd.value;
					}

					var v_sub_sys_cd = "TES";               //예) TRS, TES
					var v_apro_step = document.form.apro_step.value;
					var param = "?mode=set&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";            

					ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);		
					break;
					
				case "btng_agreement":

					if (sheetObjects[0].RowCount <= 0){
						ComShowMessage(ComGetMsg('TES25006'));//ComShowMessage('조회된 data가 없습니다.');
						return false;
					}
					if (sheetObjects[0].SelectRow==undefined || sheetObjects[0].SelectRow==null || sheetObjects[0].SelectRow==0){
						ComShowMessage(ComGetMsg('TES21908'));//ComShowMessage('선택된 row가 없습니다.');
						return false;
					}
					
					if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==undefined || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')==null || 
						sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').trim()==''){
						ComShowMessage(ComGetMsg('TES40048')); //ComShowMessage('선택된 row에 CSR No.가 없습니다.');
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
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * 
     * @param {ibsheet} sheet_obj	ibsheet object
     * @return
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     * 
     * @return
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
/*
		if (READONLY_YN!=null && READONLY_YN.trim()=='Y') {
			// Invoice Office를 입력가능하고, data는 읽기만 가능하게 변경...
			document.form.ofc_cd.readOnly = false;
			document.all.item("btng_csrcancel_yn")[0].style.display = "none";
			document.all.item("btng_csrcancel_yn")[1].style.display = "inline";
		} else {
			document.form.ofc_cd.readOnly = true;
			document.all.item("btng_csrcancel_yn")[0].style.display = "inline";
			document.all.item("btng_csrcancel_yn")[1].style.display = "none";
		}
*/
		tes_setBackColorAllTextTypeReadonly(document.form);
		
		//CSR 생성후 화면 이동시에는 'Requesting Approval'를 선택 
		if(ifStatus!='' && ifStatus!=null && ifStatus=='RA') {
			document.form.if_status.options[1].selected = true;
		}

		try	{
			tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
		} catch(e){}
		
		document.form.fm_eff_dt.focus();
		
		
	}
    
    /** 
     * 날짜 검사
     * 
     * @return
     */
	function setPeriodFromTo(){
		/* from 한달전 ~ to 오늘 */
		var formObj = document.form;
		var to_dt = new String(formObj.DB_DATE.value).substring(0,8);
		var fr_dt;
		if (to_dt!=undefined && to_dt!=null && to_dt.trim()!='' && to_dt.length==8 && !isNaN(to_dt)){
			//fr_dt = tes_getDiffDate(to_dt, -30, 'D');
			fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
			if (fr_dt!=undefined && fr_dt!=null && fr_dt.trim()!='' && fr_dt.length==8){
				if (fr_dt.substring(6,8) > ComGetLastDay(parseInt(fr_dt.substring(0,4), 10),parseInt(fr_dt.substring(4,6), 10))){
					fr_dt = fr_dt.substring(0,6) + ComGetLastDay(parseInt(fr_dt.substring(0,4), 10),parseInt(fr_dt.substring(4,6), 10));
				}
				formObj.fm_eff_dt.value = fr_dt.substring(0,4)+'-'+fr_dt.substring(4,6)+'-'+fr_dt.substring(6,8);
				formObj.to_eff_dt.value = to_dt.substring(0,4)+'-'+to_dt.substring(4,6)+'-'+to_dt.substring(6,8);
			}
		}
		if (formObj.fm_eff_dt.value!=null && formObj.to_eff_dt.value!=null){
			// LEA에서 조회를 위해 넘어올 경우 READONLY_YN의 값을 받아 자동 조회를 실행한다..
			if (READONLY_YN!=undefined && READONLY_YN!=null && READONLY_YN=='Y'){
				retrieve();
			}
		}

		if(formObj.search_csr_no.value != '') {
			retrieve();
		}
	}
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {int}		sheetNo		sheet number
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
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
					 InitColumnInfo(31, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|No of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|ASA No.|USD Amount|GW\nContract|Contract|Files|Apro Type|Create User" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
					InitDataProperty(0, cnt++ , dtData,	150, daCenter,			false,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daCenter,			false,    "vndr_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData, 150, daLeft,			false,    "inv_desc",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	110, daLeft,			false,    "if_status",				false,			"",			dfNone,			0,			false,			false	);
					
					InitDataProperty(0, cnt++ , dtData,	90,	daCenter,		    false,    "if_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	90, daLeft,			    false,    "if_err_rsn",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	40, daCenter,			false,    "no_of_inv",				false,			"",			dfNone,			0,			false,			false	);					
					InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "csr_curr_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daRight,			false,    "csr_amt",				false,			"",			dfFloat,			2,			false,			false	);

					InitDataProperty(0, cnt++ , dtData,	80,	daLeft,		    	false,    "due_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80,	daLeft,		    	false,    "pay_grp_lu_cd",				false,			"",			dfDateYmd,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,			false,    "attr_ctnt2",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	80, daRight,			false,    "csr_usd_amt",				false,			"",			dfFloat,			0,			false,			false	); //Hidden으로 수정 2017-04-17
					InitDataProperty(0, cnt++ , dtPopup,60, daCenter,			false,    "agmt_doc_cfm_cd",	false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtPopup,60, daCenter,			false,    "agmt_file_cfm_cd",	false,			"",			dfNone,			0,			true,			true	);
					InitDataProperty(0, cnt++ , dtPopup,50, daCenter,			false,    "file_upld_flg",		false,			"",			dfNone,			0,			true,			true	);
					
					InitDataProperty(0, cnt++ , dtCombo,80, daCenter,			false,    "csr_apro_tp_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	80, daCenter,			false,    "cre_usr_id",			false,			"",			dfNone,			0,			false,			false	);  		
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "iss_dt",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "rcv_dt",				false,			"",			dfNone,			0,			false,			false	);

					InitDataProperty(0, cnt++ , dtHidden,	50, daLeft,			false,    "vndr_term_nm",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "aft_act_flg",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "if_flg",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "rcv_err_flg",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "tml_inv_sts_cd",				false,			"",			dfNone,			0,			false,			false	);

					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "tml_inv_rjct_sts_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "apro_rqst_no",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "cost_ofc_cd",				false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "acct_xch_rt_yrmon",			false,			"",			dfNone,			0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	30, daLeft,			false,    "cn_ofc_chk",			false,			"",			dfNone,			0,			false,			false	);
					
					InitDataCombo(0, "csr_apro_tp_cd", "G/W|ALPS", "GW|AL");
					PopupImage  =  "/hanjin/img/btns_search.gif";  
                    ShowButtonImage = 2; 
             	}
                break;

            case 2:      //sheet1 init
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
					InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_amt",			false,			"",			dfNone,				0,			false,			false	);
					
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

            case 3:      //sheet1 init
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
                    InitColumnInfo(8, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;

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

               }
                break;                                
                 
        }
    }

    /** Sheet관련 프로세스 처리
     * @param {ibsheet} sheetObj	ibsheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
                
                // CHM-201641992 CSR IF Inquiry에서 Office Default Setting변경 (Optional) - 2016-06-10
                if ( ComIsNull(formObj.dt_status.value) && ComIsNull(formObj.search_csr_no.value) ) {
                	ComShowMessage("Please Seleted by Date Or Input CSR No.");
                	return false;
                } 
                
			    formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch4Post("ESD_TES_0100GS.do", tesFrmQryStr(formObj));
			    break;

           case IBSAVE:        //저장
				if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				formObj.f_cmd.value = MULTI;
				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
				var sXml = sheetObj.GetSaveXml("ESD_TES_0100GS.do", tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(sXml,true);
                break;

           case IBSEARCH_ASYNC01:        //cancel
				if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				formObj.f_cmd.value = SEARCH01;
				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
				formObj.csr_tp_cd.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_apro_tp_cd');
				
				var sXml = sheetObj.GetSaveXml("ESD_TES_0100GS.do", tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(sXml,true);
                break;
            
           case IBSEARCH_ASYNC02:	//결재 요청(GW)
        	   	if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
        	   	formObj.f_cmd.value = MULTI10;
   				formObj.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
   				var param = "?inv_sub_sys_cd=TES";

   				var sXml = sheetObj.GetSearchXml("COM_CSR_00081GS.do"+param, FormQueryString(formObj),"",true);   			
   				var gwUrl = ComGetEtcData(sXml , "GW_URL");

   				if (ComIsNull(gwUrl)) {
   					ComShowMessage(ComGetMsg('TES21017'));
   					return;
   				}
   					
   				ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
   	   				
   	   			//ComShowMessage(ComGetMsg('TES25021'));  //Approval Request has been completed.
   	   			retrieve();
   				
   				break;	
   				
           case IBSEARCH_ASYNC03:        //결재요청(ALPS)
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
				var param = "?inv_sub_sys_cd=TES";

				var sXml = sheetObj.GetSaveXml("COM_CSR_00081GS.do"+param, FormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml,true);
				
				retrieve();
               break;
        	   
		}
    }

    /** Sheet관련 프로세스 처리
    * @param {ibsheet} sheetObj		ibsheet object
    * @param {form} 	formObj		form object
    * @param {String}	sAction		action value
    */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
				// 0024에서 구현한 내용을 사용합니다.
               	formObj.f_cmd.value = SEARCH03;                   
				formObj.csr_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no'); //이미 csr_no가 존재하는지 위에서 검사
				var searchXml = sheetObjects[2].GetSearchXml("ESD_TES_0024PreView.do", tesFrmQryStr(formObj));
				var arrXml = searchXml.split("|$$|");

				sheetObjects[1].LoadSearchXml(arrXml[0]); 
				sheetObjects[2].LoadSearchXml(arrXml[1]); 

				searchXml=null; arrXml[0]=null; arrXml[1]=null;
                break; 
        }
    }
    
	/**
     * ALPS approval step 정보 가져오기
     *  -> ALPS approval step를 가져오는 부분에 대해서 sheet1_OnChange에 반영했지만 이후 sheet1_OnClick에도 반영해서 공통화 해야함 
     * @param
     * @return
     */
	function getAlpsAproStepInfo(){
		//Apro Step 정보를 AproUtil에서 조회한다.
		var formObj = document.form;
    	var cost_ofc_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cost_ofc_cd");
    	
		formObj.f_cmd.value = SEARCH10;
		formObj.cost_ofc_cd.value = cost_ofc_cd;
		var param = "inv_sub_sys_cd=TES";

        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_00081GS.do?"+param , FormQueryString(form)); 

        var apro_seq_key = ComGetEtcData(sXml,"apro_seq_key");
        var cost_apro_step = ComGetEtcData(sXml,"cost_apro_step");
        var login_apro_step = ComGetEtcData(sXml,"login_apro_step");
        
        formObj.aproSeqKey.value = apro_seq_key;
        formObj.cost_apro_step.value = cost_apro_step;
        formObj.login_apro_step.value = login_apro_step;
        formObj.apro_step.value = login_apro_step;
	}

    /**
     * Sheet관련 프로세스 처리
     * 
     * @param {ibsheet} sheet1	ibsheet ojbect
     * @param {String}  ErrMsg	err message     
     * @return
     */
	function sheet1_OnSearchEnd(sheet1, ErrMsg){//alert("start sheet1_OnSearchEnd");
    	 
		if (sheet1.RowCount > 0){	
			for (var i=1; i<=sheet1.RowCount; i++){
				if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
					sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
				}	
				
				/* [CHM-201539621]Split01-결재시스템 선택 가능토록 화면 수정 (2016.01.12  CSR 결재 유형 변경 오피스 확인 로직) */	
			    if(sheet1.CellValue(i,'cn_ofc_chk') == 'Y'){
			    	sheet1.CellEditable(i, 'csr_apro_tp_cd') = true;
			    	sheet1.InitCellProperty(i,'csr_apro_tp_cd', dtCombo);
			    	sheet1.CellComboItem(i, 'csr_apro_tp_cd', 'ALPS|G/W', 'AL|GW'); 
			    }
			}			
		}
		
		//sheet1.SelectHighLight = false;
		
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
		/* [CHM-201539621]Split01-결재시스템 선택 가능토록 화면 수정 (2016.01.12  CSR 결재 유형 변경 오피스 확인 로직) */	
		if(sheet1.CellValue(Row, 'csr_apro_tp_cd') == 'GW'){
			document.all.btng_apro_step.style.visibility = "hidden"; 
		}else{
//			document.all.btng_apro_step.style.visibility = "visible";
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
		
		if(sheet1.RowCount > 0) {
			if(sheet1.CellValue(Row,"if_status")=="Requesting Approval" && sheet1.CellValue(Row, "csr_apro_tp_cd")=="AL") {
							
				document.all.btng_apro_step.style.visibility = "visible"; 
				
				var cost_ofc_cd = (sheet1.CellValue(Row,"cost_ofc_cd"));
				
				//2013.01.29 Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
				if(cost_ofc_cd == formObj.ofc_cd.value) { 
					ComEnableObject(formObj.ofc_tp[0], false);
					ComEnableObject(formObj.ofc_tp[1], false);			
				}else{
					ComEnableObject(formObj.ofc_tp[0], true);
					ComEnableObject(formObj.ofc_tp[1], true);			
				}
				
				//Apro Step 정보를 AproUtil에서 조회한다.
//				formObj.f_cmd.value = SEARCH10;
//				formObj.cost_ofc_cd.value = cost_ofc_cd;
//				var param = "inv_sub_sys_cd=TES";
//
//		        var sXml = sheetObjects[0].GetSearchXml("COM_CSR_00081GS.do?"+param , FormQueryString(form)); 
//
//		        var apro_seq_key = ComGetEtcData(sXml,"apro_seq_key");
//		        var cost_apro_step = ComGetEtcData(sXml,"cost_apro_step");
//		        var login_apro_step = ComGetEtcData(sXml,"login_apro_step");
//		        
//		        formObj.aproSeqKey.value = apro_seq_key;
//		        formObj.cost_apro_step.value = cost_apro_step;
//		        formObj.login_apro_step.value = login_apro_step;
//		        formObj.apro_step.value = login_apro_step;
				
				getAlpsAproStepInfo(); //요걸루 통일 2016-01-20

			} else {	//GW 결재 Requesting Approval
				document.all.btng_apro_step.style.visibility = "hidden"; 
			}
		}
	}
	
	/**
	 * Cost Office, Log-in Office Radio 버튼 클릭시 Approval Step 변경(2013.01.29)
	 */
	function ofcChange(){
		var formObj = document.form;

		var apro_step = "";
		if(formObj.ofc_tp[0].checked){
			apro_step = formObj.cost_apro_step.value;
		}else if (formObj.ofc_tp[1].checked){
			apro_step = formObj.login_apro_step.value;
		}
		formObj.apro_step.value = apro_step;
	}
	
	
	/**
	 * Sheet관련 프로세스 처리
	 * 
     * @param {ibsheet} sheet1	ibsheet ojbect
     * @param {String}  ErrMsg	err message    
	 * @return
	 */
	function sheet1_OnSaveEnd(sheet1, ErrMsg){
		if (sheet1.RowCount > 0){	
			for (var i=1; i<=sheet1.RowCount; i++){
				if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
					sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
				}
				
				/* [CHM-201539621]Split01-결재시스템 선택 가능토록 화면 수정 (2016.01.12  CSR 결재 유형 변경 오피스 확인 로직) */	
			    if(sheet1.CellValue(i,'cn_ofc_chk') == 'Y'){
			    	sheet1.CellEditable(i, 'csr_apro_tp_cd') = true;
			    	sheet1.InitCellProperty(i,'csr_apro_tp_cd', dtCombo);
			    	sheet1.CellComboItem(i, 'csr_apro_tp_cd', 'ALPS|G/W', 'AL|GW'); 
			    }
			}
		}
	}
	
	/**
	 * Sheet popup 
	 * 
     * @param {ibsheet} sheet1	ibsheet ojbect
     * @param {String}  row,col    
	 * @return
	 */
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
	
	/**
	 * Sheet관련 프로세스 처리
	 * 
     * @param {ibsheet} sheetObj	ibsheet ojbect
     * @param {String}  errMsg		err message    
	 * @return
	 */
    function sheet3_OnSearchEnd(sheetObj,errMsg){//alert("sheet3_OnSearchEnd");
	//function test(sheetObj,errMsg){
     	//var srcName = window.event.srcElement.getAttribute("name"); 	
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        
//      var previewFlg      	= "";
//		var pre_csr_no			= sheetObj.EtcData("pre_csr_no");			
//		var pre_office			= sheetObj.EtcData("pre_office");				
//		var pre_prpd_dy			= sheetObj.EtcData("pre_prpd_dy");			
//		var pre_pay_to			= sheetObj.EtcData("pre_pay_to");				
//		var pre_csr_type		= sheetObj.EtcData("pre_csr_type");		
//		var pre_desc			= sheetObj.EtcData("pre_desc");					
//		var pre_pay_group		= sheetObj.EtcData("pre_pay_group");		
//		var pre_evi_tp			= sheetObj.EtcData("pre_evi_tp");				
//		var pre_due_date		= sheetObj.EtcData("pre_due_date");
//		var pre_asa_no			= sheetObj.EtcData("pre_asa_no");		
//		var pre_inv_dt			= sheetObj.EtcData("pre_inv_dt");				
//		var pre_curr_cd			= sheetObj.EtcData("pre_curr_cd");			
//		var pre_amt				= sheetObj.EtcData("pre_amt");
//		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
//		var chk_addr1			= sheetObj.EtcData("chk_addr1");
//		var chk_addr2			= sheetObj.EtcData("chk_addr2");
//		var chk_addr3			= sheetObj.EtcData("chk_addr3");
//		var chk_cty_nm			= sheetObj.EtcData("chk_cty_nm");
//		var chk_ste_cd			= sheetObj.EtcData("chk_ste_cd");
//		var chk_zip_cd			= sheetObj.EtcData("chk_zip_cd");
//		var chk_cnt_cd			= sheetObj.EtcData("chk_cnt_cd");
//		var pre_evi_tp_count	= "";
//		var pre_title			= pre_title  = "CONSULTATION SLIP";
//		
//		var pre_evi_tp;
        

		/*  'Approval Requested'이거나 'Disapproved'인 경우에는 print화면의 'APPRD BY'란을 채우지 않는다.  */
		var v_apro_step = '';

		if (sheetObjects[0].RowCount > 0 && 
			(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')!='Approval Requested' && sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_status')!='Disapproved')) 
		{
//			v_apro_step = sheetObjects[2].EtcData("apro_step");
			v_apro_step = sheetObjects[1].CellValue(1,"apro_step");
		}

        var previewFlg      	= "";
		var pre_csr_no			= sheetObjects[1].CellValue(1,"pre_csr_no");
		var pre_office			= sheetObjects[1].CellValue(1,"pre_office");
		var pre_prpd_dy			= sheetObjects[1].CellValue(1,"pre_prpd_dy");
		var pre_pay_to			= sheetObjects[1].CellValue(1,"pre_pay_to");
		var pre_csr_type		= sheetObjects[1].CellValue(1,"pre_csr_type");
		var pre_desc			= sheetObjects[1].CellValue(1,"pre_desc");
		var pre_pay_group		= sheetObjects[1].CellValue(1,"pre_pay_group");
		var pre_evi_tp			= sheetObjects[1].CellValue(1,"pre_evi_tp");
		var pre_due_date		= sheetObjects[1].CellValue(1,"pre_due_date");
		var pre_asa_no			= sheetObjects[1].CellValue(1,"pre_asa_no");
		var pre_inv_dt			= sheetObjects[1].CellValue(1,"pre_inv_dt");
		var pre_curr_cd			= sheetObjects[1].CellValue(1,"pre_curr_cd");
		var pre_amt				= sheetObjects[1].CellValue(1,"pre_amt");
		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
		var chk_addr1			= sheetObjects[1].CellValue(1,"chk_addr1");
		var chk_addr2			= sheetObjects[1].CellValue(1,"chk_addr2");
		var chk_addr3			= sheetObjects[1].CellValue(1,"chk_addr3");
		var chk_cty_nm			= sheetObjects[1].CellValue(1,"chk_cty_nm");
		var chk_ste_cd			= sheetObjects[1].CellValue(1,"chk_ste_cd");
		var chk_zip_cd			= sheetObjects[1].CellValue(1,"chk_zip_cd");
		var chk_cnt_cd			= sheetObjects[1].CellValue(1,"chk_cnt_cd");
		var pre_evi_tp_count	= "";
		var pre_title			= pre_title  = "CONSULTATION SLIP";

		if(cnt_cd =="KR"){
			pre_evi_tp_count ="1";
//			pre_evi_tp  = pre_evi_tp;	
			
		}else{
			var sRow = sheetObjects[0].FindCheckedRow(1);
			var arrRow = sRow.split("|");		
			pre_evi_tp_count =arrRow.length-1;
			pre_evi_tp_count = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'no_of_inv');
			pre_evi_tp = pre_evi_tp+"/"+pre_evi_tp_count;						
		}
		if(cnt_cd =="KR" || cnt_cd =="JP"){
			pre_amt = tes_chkAmtFmt(pre_amt,pre_curr_cd);
		}else{
			pre_amt = tes_chkAmtFmt(pre_amt);
		}

        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
         	previewFlg = "krjp";
        }

		sheetObjects[1].RemoveAll();   
		sheetObjects[1].DataInsert(-1);     
  
        sheetObjects[1].CellValue(1,"pre_csr_no") 	= pre_csr_no;
        sheetObjects[1].CellValue(1,"pre_office") 	= sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'cost_ofc_cd');
        sheetObjects[1].CellValue(1,"pre_prpd_dy") 	= pre_prpd_dy; 
        sheetObjects[1].CellValue(1,"pre_pay_to") 	= pre_pay_to;
        sheetObjects[1].CellValue(1,"pre_csr_type")	= pre_csr_type;
        sheetObjects[1].CellValue(1,"pre_desc") 		= pre_desc;
        sheetObjects[1].CellValue(1,"pre_pay_group")	= pre_pay_group; 
        sheetObjects[1].CellValue(1,"pre_evi_tp") 	= pre_evi_tp;
        sheetObjects[1].CellValue(1,"pre_due_date")	= pre_due_date;
        sheetObjects[1].CellValue(1,"pre_asa_no") 	= pre_asa_no; 
        sheetObjects[1].CellValue(1,"pre_inv_dt") 	= pre_inv_dt; 
        sheetObjects[1].CellValue(1,"pre_curr_cd") 	= pre_curr_cd; 
        sheetObjects[1].CellValue(1,"pre_amt") 		= pre_amt;
        sheetObjects[1].CellValue(1,"pre_title") 		= pre_title;  
		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
        sheetObjects[1].CellValue(1,"chk_addr1") 		= chk_addr1;  
        sheetObjects[1].CellValue(1,"chk_addr2") 		= chk_addr2;  
        sheetObjects[1].CellValue(1,"chk_addr3") 		= chk_addr3;  
        sheetObjects[1].CellValue(1,"chk_cty_nm") 	= chk_cty_nm;  
        sheetObjects[1].CellValue(1,"chk_ste_cd") 	= chk_ste_cd;  
        sheetObjects[1].CellValue(1,"chk_zip_cd") 	= chk_zip_cd;  
        sheetObjects[1].CellValue(1,"chk_cnt_cd") 	= chk_cnt_cd;  


/*
		var tml_inv_sts_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'tml_inv_sts_cd');
		var tml_inv_rjct_sts_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'tml_inv_rjct_sts_cd');
		var if_flg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'if_flg');
		if (sheetObjects[0].RowCount > 0){ 
			if ( if_flg!=undefined && if_flg!=null && if_flg!='' &&
				!((tml_inv_sts_cd!=null && tml_inv_sts_cd=='A') && (tml_inv_rjct_sts_cd!=null && tml_inv_rjct_sts_cd=='RJ')) ) 
			{
				v_apro_step = sheetObjects[2].EtcData("apro_step");
			}
		}
*/

		sheetObjects[1].CellValue(1,"apro_step") 		= v_apro_step;  
		window.open('ESD_TES_0080.do?previewFlg='+previewFlg, 'nonpop', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0'); 

    }				    


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {ibsheet} sheetObj	ibsheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
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
     * 유효셩 검사
     * 
     * @param {object} obj object	
     * @return
     */    
	function validateDateObj(obj){
		if (obj.readOnly==true){return false;}
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value,'-')){
			ComShowMessage(ComGetMsg('TES23011')); //ComShowMessage('날짜 형식이 잘못되었습니다.');
			obj.focus();
			return false;
		}
		var formObj = document.form;
		if (formObj.fm_eff_dt.value!=null && formObj.fm_eff_dt.value.trim()!='' && 
			formObj.to_eff_dt.value!=null && formObj.to_eff_dt.value.trim()!='' && 
			!isValFmTo(formObj.fm_eff_dt.value, formObj.to_eff_dt.value)){
			ComShowMessage(ComGetMsg('TES24012')); //ComShowMessage('시작일이 마지막일보다 작아야 합니다.');
			return false;
		}
		return true;
	}
	
	/**
	 * from, to 날짜 유효성 검사
	 * 
	 * @param {String} fmDt
	 * @param {String} toDt
	 * @return
	 */
	function isValFmTo(fmDt, toDt){
		if (fmDt==undefined || fmDt==null || fmDt.trim()=='' || toDt==undefined || toDt==null || toDt.trim()==''){
			return false;
		}
		var str_fmDt = fmDt.replace(/-/gi,'');
		var str_toDt = toDt.replace(/-/gi,'');
		if (isNaN(str_fmDt) || isNaN(str_toDt) || str_fmDt.trim().length!=8 || str_toDt.trim().length!=8) {
			return false;
		}
		if (parseInt(str_toDt,10) - parseInt(str_fmDt,10) <= 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 날짜 포맷 검사
	 * 
	 * @param {String} prd_dt
	 * @return
	 */
	function checkPeriodFormat(prd_dt){
		var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!tes_checkFormat2(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
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
     	
		if(tpCd=='GW') {
			tabStatus = "1|0|1";
		} else {
			tabStatus = "1|1|1";
		}
     	
     	if(ifStatus=="Requesting Approval") {
			readOnly = "N";
		} else {
			readOnly = "Y";
		}	

     	var url = "/hanjin/COM_CSR_0023.do?csr_no="+v_csr_no+"&tabStatus="+tabStatus+"&readOnly="+readOnly;
     	ComOpenPopup(url, 1020, 580, '', 'none', true); 
     	
     	retrieve();			
     }

