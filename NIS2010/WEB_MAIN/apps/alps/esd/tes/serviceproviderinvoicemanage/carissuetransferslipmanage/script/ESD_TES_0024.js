/***
 * 
 * 2009-02-24 : CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 송민정 요청 )
 * 2014.07.10  김영신 [CHM-201430993] Files 버튼 추가 및 활성화 기능 
 * 2014.09.29  김영신 [CHM-201432136] Files 버튼 제거, Approval Step 사용안함
 */
	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;

	var comboObjects = new Array();
	var comboCnt = 0 ; 

	var approvalFlg = "";
	var asaNoCurrCodeArr = "";
	var asaNoCurrCode = "";

	var edi_inv_yn = false;
	
	var tmp_pre_curr_cd = "";

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	var time_out = false;
	function chkTimeOut(){
	   time_out = false;
	}
	
	/** 
	 * 날짜 체크
	 * 
	 * @param	{object} obj	오브젝트
	 * @return
	 */
	function validateDateObj(obj){
		if (obj.readOnly==true){return false;}
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value,'-')){
			ComShowMessage(ComGetMsg('TES23011')); // ComShowMessage('날짜 형식이 잘못되었습니다.');//ComShowMessage(ComGetMsg('TES23011'));
			obj.focus();
			return false;
		}
		return true;
	}
	
	/**
	 * 날짜 체크2
	 * 
	 * @param {object} obj	오브젝트
	 * @return
	 */
	function validateDateObj2(obj){//alert("start validateDateObj2");
		if (obj.readOnly==true){return false;}
		obj.value = obj.value.trim();
		if (obj.value==null || obj.value.trim()==''){return false;}
		if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value,'-')){
			ComShowMessage(ComGetMsg('TES23011')); // ComShowMessage('날짜 형식이 잘못되었습니다.');
			obj.focus();
			return false;
		}
		var formObj = document.form;

		/*****************************************************************************************
			payment_due_dt가 입력가능한 경우는 gen_pay_term_cd가 영문대문자 'O'로 시작하는 경우가 아닌 경우 뿐이며, 
			MAX_ISS_DT 이전 날짜나 100이상날짜도 허용하지 않는다.
		*****************************************************************************************/
		if (formObj.max_iss_dt.value!=null && formObj.max_iss_dt.value.trim()!='' && 
			formObj.payment_due_dt.value!=null && formObj.payment_due_dt.value.trim()!=''){
			if (ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value) < 0){
				formObj.payment_due_dt.value = formObj.max_iss_dt.value;
			}			
			if (ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value) > 100){
				formObj.payment_due_dt.value = ComGetDateAdd(formObj.max_iss_dt.value,"D", 100);
			}
			formObj.gen_pay_term_cd.value	= ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
			formObj.gen_pay_term_desc.value = ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
		}
/*
		if (formObj.max_iss_dt.value!=null && formObj.max_iss_dt.value.trim()!='' && 
			formObj.payment_due_dt.value!=null && formObj.payment_due_dt.value.trim()!='' && 
			!isValIssDueDt()){
			ComShowMessage('Issue date이 payment due date보다 작거나 같아야 합니다.'); //ComShowMessage('Issue date must be earlier than payment due date.');
			return false;
		}
*/
		return true;
	}
	
	/**
	 * issu date 유효성 검사
	 * 
	 * @return
	 */
	function isValIssDueDt(){
		var str_issDt = document.form.max_iss_dt.value.replace(/-/gi,'');
		var str_dueDt = document.form.payment_due_dt.value.replace(/-/gi,'');
		if (isNaN(str_issDt) || isNaN(str_dueDt) || str_issDt.trim().length!=8 || str_dueDt.trim().length!=8) {
			return false;
		}
		if (parseInt(str_issDt,10) - parseInt(str_dueDt,10) > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 날짜 형식 체크
	 * 
	 * @param {String} prd_dt	날짜 값	
	 * @return
	 */
	function checkPeriodFormat(prd_dt){
		var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!tes_checkFormat2(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {
				/* 2012-04-17: 장병용부장님께서 김기영부장님이 해놓았던 PDF PRINT(paging기능)화면을 맘에 안들어하셔서 일단은 막아놓습니다. 나중에 또 쓸지도 흐흐  */
//				case "btn_EDIinvoiceviewPaging":
//						var url_str = 'ESD_TES_1002Popup.screen';
//						url_str += '?tml_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_ofc_cty_cd');
//						url_str += '&tml_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_seq');
//						url_str += '&vndr_seq='+document.form.vndr_seq.value;
//						url_str += '&inv_no='+sheetObject.CellValue(sheetObject.SelectRow,'inv_no');
//						window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
//						break;
				
			/* 2012-04-17: 장병용부장님께서 (INVOICE단위별) PDF VIEW 화면으로 대체합니다.  */
				case "btn_EDIinvoiceview":
					var url_str = 'ESD_TES_1001Popup.screen';
					url_str += '?tml_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_ofc_cty_cd');
					url_str += '&tml_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_seq');
					window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
					break;				  
				
				case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;

				case "btn_new":
						sheetObject.RemoveAll();
						formObject.reset();
						break;

				case "btng_detail":
						ComShowMessage("btng_detail button Click!!");
						break;

				case "btns_calendar1":
						var cal = new ComCalendar();
						cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
						break;
				/*
				case "btng_search":
						//var v_ofc_cd = formObject.cost_ofc_cd.value;
						//var v_ofc_cd = formObject.ofc_cd.value; //김부장님 요청으로 inv_ofc_cd를 기준으로 조회한당. 
						
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
				*/	
				case "btns_calendar2":
						var cal = new ComCalendar();
						cal.select(formObject.pm_due_dt, 'pm_due_dt', 'yyyy-MM-dd');
						break;						
					
				case "btng_evidence":
						//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
						if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
							if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
								ComShowMessage(ComGetMsg('TES40025','ASA No.'));
								return false;
							}							
						}

						if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){ 
								ComShowMessage(ComGetMsg('TES25001'));
								return false; 
						}	
				
						//if(document.form.eviInputFlg.value!="Y"){
						if(approvalFlg==""){						
								if(formObject.evi_gb.value=="1"){
										//noRtnPopup('ESD_TES_0078.do', 'width=775,height=580,menubar=0,status=0,scrollbars=0,resizable=0');  
										window.showModalDialog("ESD_TES_0078.do", window, "dialogWidth:810px; dialogHeight:610px; help:no; status:no; resizable:no;");
								}else if(formObject.evi_gb.value=="2"){
										//noRtnPopup('ESD_TES_0079.do', 'width=775,height=535,menubar=0,status=0,scrollbars=0,resizable=0');   
										window.showModalDialog("ESD_TES_0079.do", window, "dialogWidth:820px; dialogHeight:590px; help:no; status:no; resizable:no;");
								}else if(formObject.evi_gb.value=="3"){
										ComShowMessage(ComGetMsg('TES25019')); 						
								}else{ 
										ComShowMessage(ComGetMsg('TES25002'));
								}  
						}
						//}else{
						//		ComShowMessage("이미 저장된 증빙 입력항목사항이 있습니다. 새로운 CSR No를 발행받아서 입력하세요.");
						//}
						break;					

				case "btng_preview":				
						//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
						if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
							if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
								ComShowMessage(ComGetMsg('TES40025','ASA No.'));
								return false;
							}							
						}
					
						/*
						if (formObject.iss_dt.value!=null && formObject.iss_dt.value.trim()!='' && 
							formObject.payment_due_dt.value!=null && formObject.payment_due_dt.value.trim()!='' && 
							!isValIssDueDt()){
							ComShowMessage('Issue date이 payment due date보다 작거나 같아야 합니다.'); //ComShowMessage('Issue date must be earlier than payment due date.');
							return false;
						}
						*/
						
						if(approvalFlg==""){
								if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){ 
										ComShowMessage(ComGetMsg('TES25001'));
										return false; 
								}
								
								/*
								if(formObject.apro_step.value==""){ 
										ComShowMessage(ComGetMsg('TES25020'));
										return false; 
								}*/  												
						
								//if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
								if(cnt_cd == "KR"){
										if(formObject.evi_gb.value == ""){
												ComShowMessage(ComGetMsg('TES25002'));
												return false; 
										}else{
												if(formObject.evi_gb.value!="3"){
														if(document.form.eviInputFlg.value == "" && document.form.s_eviInputFlg.value == ""){
																ComShowMessage(ComGetMsg('TES25003'));
																return false; 
														}
												}					
										}
								} 					
		
								var csr_amt=0;		
								for(var i=0;i<sheetObject.RowCount;i++){
										if(sheetObject.CellValue(i+1,1)==1){										
												csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_total_amt")*100)+parseFloat(csr_amt);
										}								
								}
								formObject.csr_amt.value=(csr_amt/100);
														
								sheetObject1.RemoveAll(); 
								sheetObject2.RemoveAll();
								doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
				
						}
						
						//noRtnPopup('ESD_TES_0080.do', 'width=775,height=370,menubar=0,status=0,scrollbars=0,resizable=0');  
						break;

				case "btng_print":
						//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
						if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
							if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
								ComShowMessage(ComGetMsg('TES40025','ASA No.'));
								return false;
							}							
						}
							
						var fromObj = new Array();
						var rdObj  	= new Array();
						var parmObj = new Array();
						fromObj[0] = formObject;                            // RD 로 보내기 위해 배열로담는다
						rdObj[0] = sheetObjects[0];     												// Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다          

						// RD 로 보내기 위한 설정
						parmObj[0] = "1";
						parmObj[1] = "";
						parmObj[2] = "N";
						parmObj[3] = RD_path+"apps/alps/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0024Print.mrd";     // RD 화면
						parmObj[4] = rdObj;
						parmObj[5] = fromObj;
						rdObjModaless(RdReport , parmObj , 1000 ,700);
                    					
						break;

				case "btng_approvalrequest":
						if (time_out){
							return;
						}
						//ASA No. mode로 넘어온 경우 반드시 ASA No.를 선택해야 button시 동작하도록 합니다.
						if (formObject.asanogb.value!=undefined && formObject.asanogb.value!=null && formObject.asanogb.value=="ASA"){
							if (comboObjects[0].Code==undefined || comboObjects[0].Code==null || comboObjects[0].Code==''){
								ComShowMessage(ComGetMsg('TES40025','ASA No.'));
								return false;
							}							
						}
						
						if(approvalFlg==""){								
								/*
								if(formObject.apro_step.value==""){ 
										ComShowMessage(ComGetMsg('TES25020'));										
										return false; 
								}*/           
		             
								if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){ 
										ComShowMessage(ComGetMsg('TES25001'));										
										return false; 
								}
		
								if(cnt_cd=="KR"){
										if(formObject.evi_gb.value == ""){
												ComShowMessage(ComGetMsg('TES25002'));												
												return false; 
										}else{
												if(formObject.evi_gb.value!="3"){
														if(document.form.eviInputFlg.value == "Y" || document.form.s_eviInputFlg.value == "Y"){
														}else{
																ComShowMessage(ComGetMsg('TES25003'));																
																return false; 
														}
												}						
										}
								} 								
								
								ComOpenWait(true);

								var csr_amt=0;		
								for(var i=0;i<sheetObject.RowCount;i++){
										if(sheetObject.CellValue(i+1,1)==1){										
												csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_total_amt")*100)+parseFloat(csr_amt);
										}								
								}
								formObject.csr_amt.value=(csr_amt/100);  	

								eviData();  					
		
								doActionIBSheet1(sheetObject,formObject,IBSAVE);
								
								time_out = true;
								window.setTimeout('chkTimeOut()',3000);
								
								ComOpenWait(false);							
						}			
																		
						break;
						
				case "btng_main":	    			
	    			
	    			var url_str = 'ESD_TES_0023.do';
					url_str += '?pgmNo=ESD_TES_0023';
					url_str += '&pre_cond_inv_ofc_cd='+document.form.pre_cond_inv_ofc_cd.value;
					url_str += '&pre_cond_inv_cfm_dt='+document.form.pre_cond_inv_cfm_dt.value;
					url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
					url_str += '&pre_cond_vndr_seq_name='+document.form.pre_cond_vndr_seq_name.value;
					
					location.href = url_str;
					
					break; 
				/*	
				case "btn_files": //files button 추가
					
					FilesPopup();		        
					
					break;
				*/	
					
      	} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025'));
    		} else {
    			ComShowMessage(e);
    		}
			time_out = true;
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet} sheet_obj	ibsheet object
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
			ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }  
             
		if(document.form.asanogb.value=="A/P" && cnt_cd=="KR"){			  
		  document.all.item("srLayer")[1].style.display = "inline";
		  document.all.item("srLayer")[0].style.display = "none";
		  document.all.item("srLayer")[2].style.display = "none";		
		  document.all.item("btLayer")[1].style.display = "inline";
		  document.all.item("btLayer")[0].style.display = "none";			      						
		}else if(document.form.asanogb.value=="ASA" && cnt_cd=="KR"){
		  document.all.item("srLayer")[1].style.display = "none";
		  document.all.item("srLayer")[0].style.display = "none";
		  document.all.item("srLayer")[2].style.display = "inline";	
		  document.all.item("btLayer")[1].style.display = "inline";
		  document.all.item("btLayer")[0].style.display = "none";			      							
		}else if(document.form.asanogb.value=="ASA" && cnt_cd!="KR"){
		  document.all.item("srLayer")[1].style.display = "none";
		  document.all.item("srLayer")[0].style.display = "inline";
		  document.all.item("srLayer")[2].style.display = "none";	
		  document.all.item("btLayer")[1].style.display = "none";
		  document.all.item("btLayer")[0].style.display = "inline";						
		}else if(document.form.asanogb.value=="A/P" && cnt_cd!="KR"){
		  document.all.item("srLayer")[1].style.display = "none";
		  document.all.item("srLayer")[0].style.display = "none";
		  document.all.item("srLayer")[2].style.display = "none";	
		  document.all.item("btLayer")[1].style.display = "none";
		  document.all.item("btLayer")[0].style.display = "inline";								
		}		         
		
		for(p=0;p< comboObjects.length;p++){
			initCombo (comboObjects[p],p+1, '');
		}				
		
		ComEnableObject(document.form.cost_ofc_cd, false);
		//disableObject(document.form.inv_cfm_dt, false); 
		ComEnableObject(document.form.vndr_seq, false);
		ComEnableObject(document.form.vndr_seq_name, false);
		ComEnableObject(document.form.cnt_inv, false);
		ComEnableObject(document.form.curr_cd, false);         
		ComEnableObject(document.form.total_amt, false);
		ComEnableObject(document.form.max_iss_dt, false);
		ComEnableObject(document.form.max_rcv_dt, false);
		ComEnableObject(document.form.gen_pay_term_desc, false);
		//ComEnableObject(document.form.apro_step, false);	
		ComEnableObject(document.form.csr_no, false);	
		
		var tmp_gen_pay_term_cd = document.form.gen_pay_term_cd.value;
		if (tmp_gen_pay_term_cd!=null && tmp_gen_pay_term_cd.trim()!='' && tmp_gen_pay_term_cd.substring(0,1)=='O')
		{
			//국내지역은 PAYMENT_DUE_DT를 수정불가한다.
			ComEnableObject(document.form.payment_due_dt,false);	
		}

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
		
		//2013.01.29 Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
		/*
		if(document.form.cost_ofc_cd.value == document.form.ofc_cd.value) { 
			ComEnableObject(document.form.ofc_tp[0], false);
			ComEnableObject(document.form.ofc_tp[1], false);			
		}else{
			ComEnableObject(document.form.ofc_tp[0], true);
			ComEnableObject(document.form.ofc_tp[1], true);			
		}*/
		
		//csr_no이 없는 초기 화면은 file 버튼 비활성화
    	//if(document.form.csr_no.value.length == 0 || document.form.csr_no.value == "") {
    	//	ComBtnDisable("btn_files");
    	//}
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param {ibsheet} sheetObj 	==> 시트오브젝트, 
     * @param {int} 	sheetNo 	==> 시트오브젝트 태그의 아이디에 붙인 일련번호
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
                    InitColumnInfo(16, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "SEQ||Invoice No.|Net Amount|Tax Amount|W.H.T|Total Amount|Issue Date|Receive Date|Confirm Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++ , dtSeq,	 					30,		daCenter,		false,    "",										false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtCheckBox, 			50,		daCenter,		false,    "chk",										false,			"",			dfNone,					0,			true,			true	);
					InitDataProperty(0, cnt++ , dtData,	 					200,	daLeft,			false,    "inv_no",							false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 					150,	daRight,		false,    "ttl_inv_amt",				false,			"",			dfFloat,				2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 					100,	daRight,		false,    "vat_amt",						false,			"",			dfFloat,				2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 					100,	daRight,		false,    "whld_tax_amt",				false,			"",			dfFloat,				2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 					80,		daRight,		false,    "inv_total_amt",			false,			"",			dfFloat,				2,			false,			false	);
					InitDataProperty(0, cnt++ , dtData,	 					80,		daRight,		false,    "iss_dt",							false,			"",			dfNone,					0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 					80,		daRight,		false,    "rcv_dt",							false,			"",			dfNone,					0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtData,	 					80,		daRight,		false,    "inv_cfm_dt",					false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_so_ofc_cty_cd",	false,			"",			dfNone,					0,			false,			false	); 
					InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_so_seq",					false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "vndr_seq",						false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	1,		daRight,		false,    "ibflag",							false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daRight,		false,    "edi_flg",							false,			"",			dfNone,					0,			false,			false	);
					InitDataProperty(0, cnt++ , dtHidden,	 	1,		daRight,		false,    "file_chk",							false,			"",			dfNone,					0,			false,			false	);
					
					SavingImage = "";
					WaitImageVisible = false;
						
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
                    InitColumnInfo(23, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;

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

										//InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "apro_step",				false,			"",			dfNone,				0,			false,			false	);
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


    /**
     * Sheet관련 프로세스 처리
     * 
	 * @param {ibsheet} sheetObj 	시트오브젝트
     * @param {form}	formObj		폼 오브젝트
     * @param {String}	sAction     액션 값
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {//alert("start doActionIBSheet() sAction"+sAction);     		
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

					case IBSEARCH:      //조회				
							formObj.f_cmd.value = SEARCHLIST01;
							sheetObj.DoSearch4Post("ESD_TES_0024GS.do", tesFrmQryStr(formObj));
					break; 
					
					case IBCOPYROW:        //행 복사
							sheetObj.DataCopy();
					break;        

        }
    }
     
    /**
     * Sheet관련 프로세스 처리
     * 
	 * @param {ibsheet} sheetObj 	시트오브젝트
     * @param {form}	formObj		폼 오브젝트
     * @param {String}	sAction     액션 값
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {//alert("start doActionIBSheet1");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

               	formObj.f_cmd.value = SEARCH01;                  
								var param = sheetObjects[0].GetSaveString(false,true,1);
								var sXml  = sheetObjects[2].GetSearchXml("ESD_TES_0024PreView.do", param+'&'+tesFrmQryStr(formObj),"",true);
								
								sheetObjects[2].LoadSearchXml(sXml);            
								sXml=null; 								
                break; 
                
           case IBSAVE:      //저장
            
								var sRow = sheetObj.FindCheckedRow(1);
								var arrRow = sRow.split("|");									
								
								formObj.inv_knt.value = arrRow.length-1;
		
								formObj.f_cmd.value = MULTI01;
                   
								var param = sheetObjects[0].GetSaveString(false,true,1);
								var sXml = sheetObjects[0].GetSearchXml("ESD_TES_0024GS.do", param+'&'+tesFrmQryStr(formObj),"",true);
								sheetObjects[0].LoadSaveXml(sXml); 										
                break;                            
        }
    }     


	 /**
     * MInimize 클릭시 이벤트 관련
     * @param {String} nItem	
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
	    	    objs.style.display = "none";
	          sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
						sheetObjects[0].focus();
						sheetObjects[0].ViewRows  =20; 
				}
	    	else
	    	{
	    	    objs.style.display = "inline";
	    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
						sheetObjects[0].focus();
						sheetObjects[0].ViewRows  =10;
	    	}
    }
    
     /**
      * 숫자 체크
      * 
      * @param {Object} obj		object	
      * @return
      */
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}
	
	/**
	 * 숫자체크 
	 * 
	 * @param {Object} obj		object
	 * @return
	 */
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj,"-")){
			obj.value = '';
		}
	}		
	
	/** 날짜체크
	 * 
	 * @param {Object} obj		object
	 * @return
	 */
	function isDate1(obj){
		//숫자만..
		if (!ComIsDate(obj)){
			obj.value = '';
 
				//ComShowMessage("잘못된 날짜 입력입니다. 다시 입력하세요.");
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
				document.all.item("EDILayer01")[0].style.display = "inline";
				document.all.item("EDILayer01")[1].style.display = "inline";
			} else {
				document.all.item("EDILayer01")[0].style.display = "none";
				document.all.item("EDILayer01")[1].style.display = "none";
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
				document.all.item("EDILayer01")[0].style.display = "inline";
				document.all.item("EDILayer01")[1].style.display = "inline";
			} else {
				document.all.item("EDILayer01")[0].style.display = "none";
				document.all.item("EDILayer01")[1].style.display = "none";
			}
		} catch (e){
		}		
    }	 
	 
	/** 
	 * 
     * @param {ibSheet}		sheetObj		ibsheet object
     * @param {int}			row				sheet date row값
     * @param {int}			col				sheet date col값
     * @param {String}		value			sheet 값
	 * @return
	 */
    function sheet1_OnChange(sheetObj , row , col, value)
    {//alert("start sheet1_OnChange");

		var sName = sheetObj.ColSaveName(col);
		if (sName == "chk") {
			resetEviData();
		}

		setInfo(sheetObj);
    } 
   
   /**
    * 
    * @param {ibSheet}	sheetObj		ibsheet object
    * @param {String} 	ErrMsg			err message
    * @return
    */ 
   function sheet1_OnSaveEnd(sheetObj, errMsg){//alert("start sheet1_OnSaveEnd");
		if (errMsg != "") return false;     
		var csr_no = sheetObj.EtcData("csrNo");
		document.form.csr_no.value = csr_no;
		sheetObj.RemoveEtcData ();               

		var chkRow = sheetObj.FindCheckedRow ("chk");
		var arrRow = chkRow.split("|");
		for (idx=0; idx<arrRow.length-1; idx++){
			//sheetObj.CellEditable(arrRow[idx] , "chk") = false;
			sheetObj.RowHidden(arrRow[idx]) = true; //2012.11.02 Approval Req. 후에 해당 Row에 대한 check box 비활성화 말고  Hidden 처리 하는것으로 정미화 과장 요청에 의해 바꿈
//			sheetObj.CellValue2(arrRow[idx] , "chk") = 0;
		}         
		
		var previewFlg      	= "";

		if(tmp_pre_curr_cd=="KRW" || tmp_pre_curr_cd=="JPY"){
     		previewFlg = "krjp";
        }
         
        deleteCheck();
        ComShowMessage(ComGetMsg('TES25032'));  
        
        //btn_files 버튼 활성화, files 화면 팝업
		//ComBtnEnableRed("btn_files");
		//FilesPopup();
        
        /* [CHM-201539621]Split01-결재시스템 선택 가능토록 화면 수정 (2016.01.12  CSR 결재 유형 변경 오피스 확인 로직) */	
        /* 2017-04-07 GW 결재가 없으므로 해당 로직이 필요 없슴 */
//	    var aproTpParam = "f_cmd="+SEARCH03+"&csr_no="+csr_no;
//	    var sXml = sheetObjects[0].GetSearchXml("COM_CSR_0002GS.do", aproTpParam);
//	    var chkOfc = ComGetEtcData(sXml,"CN_OFC_CHK");
	    
//	    if(chkOfc == "Y"){
//			ComOpenPopup('/hanjin/COM_CSR_0016.do?csr_no='+csr_no, 300, 150, '', 'none', true);
//	    }
	    
        //Approval Step지정을 하겠습니까? Yes면 CSR조회 화면으로 , No면 CSR을 계속 생성하도록 현재 화면
//		if(ComShowConfirm(ComGetMsg('TES25033'))) {
//			location.href = 'ESD_TES_0100.do?if_status=RA&CSR_NO='+ csr_no;
//	    }

		/*  'Approval Request'가 성공하면 일단 증빙 data는 다 초기화하고 다시 증빙을 하게 해야 한데이...  */
		//document.form.eviInputFlg.value = '';
		resetEviData();

		 if ( myWin != null){
             if(!myWin.closed){
                    sheetObjects[1].CellValue(1,"pre_csr_no") 	= csr_no;	
                    //var apro_step_arr = document.form.apro_step.value.split("-");                    
//                    sheetObjects[1].CellValue(1,"apro_step") = apro_step_arr[0]; //2007-05-06  CSR DETAIL에서는 무조건 APRO_STEP을 보이지 않은다.
                    myWin = null;                     
                    //sheetObjects[0].RemoveAll();
					if (errMsg==null || errMsg.trim()==''){
						noRtnPopup('ESD_TES_0080.do?previewFlg='+previewFlg+'&previewFlgYN=Y', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');                      
					}
             }
         }//else{         
          	//sheetObjects[0].RemoveAll();
          	//deleteCheck();
        		//ComShowMessage(ComGetMsg('TES25021'));
        		
         //}
		
		
		
    }
	
    /**
     * sheet3 검색후 타는 이벤트
     * 
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {String}	errMsg		err message
     * @return
     */
    function sheet3_OnSearchEnd(sheetObj,errMsg){//alert("start sheet3_OnSearchEnd");
		var srcName 		= window.event.srcElement.getAttribute("name"); 
        var previewFlg      = "";
		var pre_csr_no			= sheetObj.EtcData("pre_csr_no");
		var pre_office			= sheetObj.EtcData("pre_office");				
		var pre_prpd_dy			= sheetObj.EtcData("pre_prpd_dy");			
		var pre_pay_to			= sheetObj.EtcData("pre_pay_to");				
		var pre_csr_type		= sheetObj.EtcData("pre_csr_type");		
		var pre_desc			= sheetObj.EtcData("pre_desc");					
		var pre_pay_group		= sheetObj.EtcData("pre_pay_group");		
		var pre_evi_tp			= sheetObj.EtcData("pre_evi_tp");				
		var pre_due_date		= sheetObj.EtcData("pre_due_date");
		if(document.form.asa_no.value != "" || comboObjects[0].Code != ""){			
				var pre_asa_no			= comboObjects[0].Code;		
		}else{
				var pre_asa_no			= sheetObj.EtcData("pre_asa_no");		
		}		
		var pre_inv_dt			= sheetObj.EtcData("pre_inv_dt");				
		var pre_curr_cd			= sheetObj.EtcData("pre_curr_cd");			
		var pre_amt				= sheetObj.EtcData("pre_amt");
		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
		var chk_addr1	    	= sheetObj.EtcData("chk_addr1");
		var chk_addr2	    	= sheetObj.EtcData("chk_addr2");
		var chk_addr3	    	= sheetObj.EtcData("chk_addr3");
		var chk_cty_nm	    	= sheetObj.EtcData("chk_cty_nm");
		var chk_ste_cd	    	= sheetObj.EtcData("chk_ste_cd");
		var chk_zip_cd	    	= sheetObj.EtcData("chk_zip_cd");
		var chk_cnt_cd	    	= sheetObj.EtcData("chk_cnt_cd");
		var pre_evi_tp_count    = "";
		var pre_title			= "";

		pre_due_date  =  document.form.payment_due_dt.value;
		
		if(pre_amt==0 || comboObjects[0].Code != ""){
				pre_title  = "TRANSFER SLIP";
		}else{
				pre_title  = "CONSULTATION SLIP";
		}
		
		var pre_evi_tp
		
		if(cnt_cd =="KR"){
				pre_evi_tp_count ="1";
				pre_evi_tp  = pre_evi_tp;						
		}else{
				var sRow = sheetObjects[0].FindCheckedRow(1);
				var arrRow = sRow.split("|");		
				pre_evi_tp_count =arrRow.length-1;
				
				pre_evi_tp = pre_evi_tp+"/"+pre_evi_tp_count;						
		}	
		
		if(cnt_cd =="KR" || cnt_cd =="JP" || pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
				pre_amt = pre_amt;
		}else{
				pre_amt = tes_chkAmtFmt(pre_amt);
		}
		
		//2009.12.10 pch approval request후 krjp rd로 보내기 위해
		tmp_pre_curr_cd = pre_curr_cd;
		
        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
         		previewFlg = "krjp";
        }					
		sheetObjects[1].RemoveAll();   

		sheetObjects[1].DataInsert(-1);     
        
        if(srcName=="btng_preview"){
         		pre_csr_no  = "";
        } 
        sheetObjects[1].CellValue(1,"pre_csr_no") 	= pre_csr_no;
        sheetObjects[1].CellValue(1,"pre_office") 	= document.form.cost_ofc_cd.value;
        sheetObjects[1].CellValue(1,"pre_prpd_dy") 	= pre_prpd_dy; 
        sheetObjects[1].CellValue(1,"pre_pay_to") 	= pre_pay_to;
        sheetObjects[1].CellValue(1,"pre_csr_type")   = pre_csr_type;
        sheetObjects[1].CellValue(1,"pre_desc") 		= pre_desc;
        sheetObjects[1].CellValue(1,"pre_pay_group")  = pre_pay_group; 
        sheetObjects[1].CellValue(1,"pre_evi_tp") 	= pre_evi_tp;
        sheetObjects[1].CellValue(1,"pre_due_date")   = pre_due_date;
        sheetObjects[1].CellValue(1,"pre_asa_no") 	= pre_asa_no; 
        sheetObjects[1].CellValue(1,"pre_inv_dt") 	= pre_inv_dt; 
        sheetObjects[1].CellValue(1,"pre_curr_cd") 	= pre_curr_cd; 
        sheetObjects[1].CellValue(1,"pre_amt") 	    = pre_amt;
        sheetObjects[1].CellValue(1,"pre_title") 		= pre_title;  
		// CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
        sheetObjects[1].CellValue(1,"chk_addr1")    	= chk_addr1;  
        sheetObjects[1].CellValue(1,"chk_addr2")    	= chk_addr2;  
        sheetObjects[1].CellValue(1,"chk_addr3")    	= chk_addr3;  
        sheetObjects[1].CellValue(1,"chk_cty_nm")    	= chk_cty_nm;  
        sheetObjects[1].CellValue(1,"chk_ste_cd")    	= chk_ste_cd;  
        sheetObjects[1].CellValue(1,"chk_zip_cd")    	= chk_zip_cd;  
        sheetObjects[1].CellValue(1,"chk_cnt_cd")    	= chk_cnt_cd;  
        /**
        for(var i = 0;i<sheetObjects[2].Rowcount;i++){
         		sheetObjects[2].CellValue(i+1,"pre_debit") = tes_chkAmtFmt(sheetObjects[2].CellValue(i+1,"pre_debit"));
         		sheetObjects[2].CellValue(i+1,"pre_credit") = tes_chkAmtFmt(sheetObjects[2].CellValue(i+1,"pre_credit"));         		
        }      
        **/

		if (errMsg==null || errMsg.trim()==''){
			noRtnPopup('ESD_TES_0080.do?previewFlg='+previewFlg+'&previewFlgYN=Y','width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');
//			window.open('ESD_TES_0080.do?previewFlg='+previewFlg+'&previewFlgYN=Y','myWin','width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');            
		}
    }				    
	
    /**
     * sheet1 검색후 타는 이벤트
     * 
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {String}	errMsg		err message
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj,errMsg){//alert("start sheet1_OnSearchEnd");
        var asaNoString = sheetObj.EtcData("asaNoString");
        var csrNo = sheetObj.EtcData("csrNo");
        var apOfcCd = sheetObj.EtcData("apOfcCd"); 

        asaNoCurrCodeArr = sheetObj.EtcData("asaCurrCdstring").split("|"); 
        
        document.form.csr_no.value 		= csrNo;
        document.form.ap_ofc_cd.value 	= apOfcCd;
                 				
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, asaNoString);
        }

		/* eBilling - 원본 invoice를 조회 하는 button 보이기 여부 파악 */
		sheetObj.SelectCell(sheetObj.SelectRow, sheetObj.SelectCol);
		for (var i=1; i<=sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i,'edi_flg')=='Y' && sheetObj.CellValue(i,'file_chk')=='Y') {
				edi_inv_yn = true;
				break;
			}
		}
		
		/* 2012-04-17: 장병용부장님께서 김기영부장님이 해놓았던 PDF PRINT(paging기능)화면을 맘에 안들어하셔서 일단은 막아놓습니다. 나중에 또 쓸지도 흐흐  */
//		if (edi_inv_yn){
//			document.all.EDILayerPaging.style.display = "inline";
//		} else {
//			document.all.EDILayerPaging.style.display = "none";
//		}
		
    }
	 
	function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		if( KeyCode == 13 ){
			var rowArr = sheetObj.GetSelectionRows("/").split("/");
			for( var idx = 0; idx < rowArr.length; idx++ ){
				sheetObj.CellValue2( rowArr[idx], "chk") = "1";
			}
		}
		
		setInfo(sheetObj);
	}
	
	//[CHM-201641544]날짜에 대쉬(-) 금액에 콤마(,) 추가 - 2016.05.12
	function setInfo(sheetObj){
		var chkRow = sheetObj.FindCheckedRow (1);
        var arrRow = chkRow.split("|");
        var chkRowCount =0 ;
        var maxIss = 0;
        var maxRcv = 0 ;
        var total_amt = 0;
        var vat_amt  = 0;
        for (idx=0; idx<arrRow.length-1; idx++)
        {
        	var issDt = ComReplaceStr(sheetObj.Cellvalue( arrRow[idx] , "iss_dt"),"-");
        	var rcvDt = ComReplaceStr(sheetObj.Cellvalue( arrRow[idx] , "rcv_dt"),"-");
        	
			if( maxIss < issDt )
			{
				maxIss = issDt;
			}
			  
			if( maxRcv < rcvDt )
			{
				maxRcv = rcvDt;
			}
  
			total_amt = parseFloat(sheetObj.CellValue( arrRow[idx],"inv_total_amt")*100)+parseFloat(total_amt)*100;
			vat_amt = parseFloat(sheetObj.CellValue( arrRow[idx],"vat_amt")*100)+parseFloat(vat_amt)*100;
			total_amt = total_amt/100;
			vat_amt = vat_amt/100 ;
			chkRowCount++;
        }
        
        if ( maxIss == "0")  maxIss ="";
        if ( maxRcv == "0")  maxRcv ="";
        if ( chkRowCount == "0")  chkRowCount ="";

        document.form.max_iss_dt.value = ComGetDateAdd(maxIss,"D", 0);
        document.form.max_rcv_dt.value = ComGetDateAdd(maxRcv,"D", 0);
        document.form.total_amt.value = ComAddComma(total_amt);		
        ComChkObjValid(document.form.max_iss_dt);
        ComChkObjValid(document.form.max_rcv_dt);
        document.form.cnt_inv.value = chkRowCount;         
				
		if(total_amt >= 0){
				document.form.csr_tp_cd.value = "S"
		}else{ 
				document.form.csr_tp_cd.value = "C"
		}					            

		if ( maxIss != "" && ComIsNumber(document.form.gen_pay_term_cd))
        {
            document.form.payment_due_dt.value = ComGetDateAdd(maxIss,"D", parseInt(document.form.gen_pay_term_cd.value));
        } else {
            document.form.payment_due_dt.value = "";
			/*
			var tmp_gen_term_cd_val = document.form.gen_pay_term_cd.value.substring(1,3);
			if (!isNaN(tmp_gen_term_cd_val)){
				document.form.payment_due_dt.value = getAddDate(maxIss, parseInt(tmp_gen_term_cd_val));
			}
			*/
        }
		
		

		if(document.form.asanogb.value=="A/P" && cnt_cd=="KR"){			  
			if ( vat_amt > 0)
			{
			   document.form.evi_gb1.options[0].selected = true ;
			   ComEnableObject(document.form.evi_gb1, false);
			   eviGbSelect(1);
			} else {
			   document.form.evi_gb1.options[0].selected = true ;
			   ComEnableObject(document.form.evi_gb1, true);				   
			   eviGbSelect(1);						    
			}
		} else if(document.form.asanogb.value=="ASA" && cnt_cd=="KR"){
			if ( vat_amt > 0)   
			{
			   document.form.evi_gb2.options[0].selected = true ;
			   ComEnableObject(document.form.evi_gb2, false);	
			   eviGbSelect(2);
			} else {
			   document.form.evi_gb2.options[0].selected = true ;
			   ComEnableObject(document.form.evi_gb2, true);						   
			   eviGbSelect(2);
			}
		}
	}
    
    /**
     * Combo의 항목을 설정한다.
     * @param {comoObj}	comboObj		combo Object
     * @param {int}		comboNo 		combo no
     * @param {String}	asaNoString 	asa number value
     */
    function initCombo (comboObj, comboNo, asaNoString){
        var cnt  = 0 ;
        var asaNoArray = asaNoString.split("|");	

         switch(comboNo){
            case 1:             
            	comboObj.RemoveAll();  
            	 
               with (comboObj){                	
			    	       SetColAlign("left");
			    	       SetColWidth("60");			    	       
			             InsertItem(cnt++, '', ''); 
			    	       for(i=0 ;i<asaNoArray.length;i++){             
			               InsertItem(cnt++, asaNoArray[i], asaNoArray[i]);
			             } 	
			    	    }
               break;                                                  
       		}
    }     
    
    /**
     * setComboObject
     * @param {combo object} combo_obj	combo object
     * @return
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    } 		
    
    /**
     * 
     * @param {combo object} 	comObj	combo object
     * @param {int} 			index	순서
     * @param {String} 			text	값
     * @return
     */
    function asa_no_OnChange(comObj,index,text)
    {
       asaNoCurrCode = "";	
       document.form.asa_no.value = comObj.Code;
       asaNoCurrCode =  asaNoCurrCodeArr[comObj.index-1];       
    } 
    
    /**
     *  approvalrequest
     */
    function approvalrequest(){//alert("start approvalrequest");     		
     		var sheetObject = sheetObjects[0];
     		var formObject = document.form; 
     			/*
				if(formObject.apro_step.value==""){ 
						ComShowMessage(ComGetMsg('TES25020'));						
						return false; 
				}*/            
         
				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){ 
						ComShowMessage(ComGetMsg('TES25001')); 						
						return false; 
				}
				
				//if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
				//if(formObject.asanogb.value=="A/P"){
				if(cnt_cd=="KR"){
						if(formObject.evi_gb.value == ""){
								ComShowMessage(ComGetMsg('TES25002'));								
								return false; 
						}else{
								if(formObject.evi_gb.value!="3"){
										if(document.form.eviInputFlg.value == "" && document.form.s_eviInputFlg.value == ""){
												ComShowMessage(ComGetMsg('TES25003'));												
												return false; 
										}
								}						
						}
				} 								
				ComOpenWait(true);
				
				var csr_amt=0;		
				for(var i=0;i<sheetObject.RowCount;i++){
						if(sheetObject.CellValue(i+1,1)==1){										
								csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_total_amt")*100)+parseFloat(csr_amt);
						}								
				}
				formObject.csr_amt.value=(csr_amt/100);
				
				eviData();  						

				doActionIBSheet1(sheetObject,formObject,IBSAVE); 
				
				ComOpenWait(false);						
    }             
	
	/**
	 * 
	 * @param {int}	evi_gb	증빙값
	 * @return
	 */
 	function eviGbSelect(evi_gb){//alert("start eviGbSelect");
	 		if(evi_gb==1){
	 				document.form.evi_gb.value=document.form.evi_gb1.value;
	 		}else if(evi_gb==2){
					document.form.evi_gb.value=document.form.evi_gb2.value;
	 		}		 		
	 		
	 		/**
	 		if(document.form.evi_ctnt1.value!="" && evi_gb ==1){
	 			var gb = confirm("증빙구분을 변경하면 이미 저장되어 있는 정보가 삭제 됩니다.\n\n증빙구분을 변경하시겠습니까?");
	 		}
	 		
	 		if(gb){
					document.form.tax_naid_flg.value      = "";
					document.form.finance_flg.value       = "";
					document.form.fa_flg.value            = "";
					document.form.tax_type.value          = "";
					document.form.tax_nsl_flg.value       = "";
					                                 
					document.form.evi_inv_dt.value        = "";
					document.form.evi_comp_no.value       = "";
					document.form.evi_total_net_amt.value = "";
					document.form.evi_tax_no2.value       = "";
					document.form.evi_total_tax_amt.value = "";
					document.form.evi_ctnt1.value         = "";
					document.form.evi_ctnt2.value         = "";
					document.form.evi_ctnt3.value         = "";
					document.form.evi_ctnt4.value         = "";
					document.form.evi_ctnt5.value         = "";
					document.form.evi_ctnt6.value         = "";
					document.form.evi_ctnt7.value         = "";
					document.form.evi_ctnt8.value         = "";
					document.form.evi_ctnt9.value         = "";
					document.form.evi_ctnt10.value        = "";
					document.form.evi_ctnt11.value        = "";
					document.form.evi_ctnt12.value        = "";
					document.form.evi_tax_no.value        = "";
					document.form.evi_tax_code.value		 	= "";
			}else{					 
					return false;
			}	
			**/	 		                                     
	}
	
	/**
	 * 증빙값 세팅
	 * 
	 * @return
	 */ 
 	function eviData(){
 		if(	document.form.evi_gb.value==2){
 		
					document.form.tax_naid_flg.value      = document.form.s_tax_naid_flg.value;     
					document.form.finance_flg.value       = document.form.s_finance_flg.value ;     
					document.form.fa_flg.value            = document.form.s_fa_flg.value;          
					document.form.tax_type.value          = document.form.s_tax_type.value;       
					document.form.tax_nsl_flg.value       = document.form.s_tax_nsl_flg.value;      
					                                                                           
					document.form.evi_inv_dt.value        = document.form.s_evi_inv_dt.value;       
					document.form.evi_comp_no.value       = document.form.s_evi_comp_no.value;      
					document.form.evi_total_net_amt.value = document.form.s_evi_total_net_amt.value;
					document.form.evi_tax_no2.value       = document.form.s_evi_tax_no2.value;     
					document.form.evi_total_tax_amt.value = document.form.s_evi_total_tax_amt.value;
					document.form.evi_ctnt1.value         = document.form.s_evi_ctnt1.value;        
					document.form.evi_ctnt2.value         = document.form.s_evi_ctnt2.value;        
					document.form.evi_ctnt3.value         = document.form.s_evi_ctnt3.value;        
					document.form.evi_ctnt4.value         = document.form.s_evi_ctnt4.value;        
					document.form.evi_ctnt5.value         = document.form.s_evi_ctnt5.value;        
					document.form.evi_ctnt6.value         = document.form.s_evi_ctnt6.value;        
					document.form.evi_ctnt7.value         = document.form.s_evi_ctnt7.value;        
					document.form.evi_ctnt8.value         = document.form.s_evi_ctnt8.value;        
					document.form.evi_ctnt9.value         = document.form.s_evi_ctnt9.value;        
					document.form.evi_ctnt10.value        = document.form.s_evi_ctnt10.value;       
					document.form.evi_ctnt11.value        = document.form.s_evi_ctnt11.value;       
					document.form.evi_ctnt12.value        = document.form.s_evi_ctnt12.value;      
					document.form.evi_tax_no.value        = document.form.s_evi_tax_no.value;       
					document.form.evi_tax_code.value	  = document.form.s_evi_tax_code.value;			 		
 		
 		}
	}		
	
	 /**
	  * 증빙값 초기화
	  * 
	  * @return
	  */
	function resetEviData(){//alert("start resetEviData");
		document.form.eviInputFlg.value = '';

		document.form.tax_naid_flg.value      = '';
		document.form.finance_flg.value       = ''; 
		document.form.fa_flg.value            = ''; 
		document.form.tax_type.value          = ''; 
		document.form.tax_nsl_flg.value       = ''; 

		document.form.s_tax_naid_flg.value    = '';      
		document.form.s_finance_flg.value	  = '';         
		document.form.s_fa_flg.value		  = '';               
		document.form.s_tax_type.value		  = '';      
		document.form.s_tax_nsl_flg.value     = '';    

		for (var i = 0; i < document.form.elements.length; i++){
			try {
				if ((document.form.elements[i].name.length >= 4 && document.form.elements[i].name.substring(0,4) == 'evi_') || 
					(document.form.elements[i].name.length >= 6 && document.form.elements[i].name.substring(0,6) == 's_evi_'))
				{
					document.form.elements[i].value = '';
				}
			}
			catch (e){
				ComShowMessage(e); //여길 그냥 통과해야 한다..
			}
		}
		
		document.form.attr_ctnt8.value     = '';
		
		
/*
			document.form.evi_inv_dt.value        = 
			document.form.evi_comp_no.value       = 
			document.form.evi_total_net_amt.value = 
			document.form.evi_tax_no2.value       = 
			document.form.evi_total_tax_amt.value = 
			document.form.evi_ctnt1.value         = 
			document.form.evi_ctnt2.value         = 
			document.form.evi_ctnt3.value         = 
			document.form.evi_ctnt4.value         = 
			document.form.evi_ctnt5.value         = 
			document.form.evi_ctnt6.value         = 
			document.form.evi_ctnt7.value         = 
			document.form.evi_ctnt8.value         = 
			document.form.evi_ctnt9.value         = 
			document.form.evi_ctnt10.value        = 
			document.form.evi_ctnt11.value        = 
			document.form.evi_ctnt12.value        = 
			document.form.evi_tax_no.value        = 
			document.form.evi_tax_code.value
														
			document.form.s_evi_inv_dt.value;           
			document.form.s_evi_comp_no.value;          
			document.form.s_evi_total_net_amt.value;    
			document.form.s_evi_tax_no2.value;          
			document.form.s_evi_total_tax_amt.value;    
			document.form.s_evi_ctnt1.value;            
			document.form.s_evi_ctnt2.value;            
			document.form.s_evi_ctnt3.value;            
			document.form.s_evi_ctnt4.value;            
			document.form.s_evi_ctnt5.value;            
			document.form.s_evi_ctnt6.value;            
			document.form.s_evi_ctnt7.value;            
			document.form.s_evi_ctnt8.value;            
			document.form.s_evi_ctnt9.value;            
			document.form.s_evi_ctnt10.value;           
			document.form.s_evi_ctnt11.value;           
			document.form.s_evi_ctnt12.value;           
			document.form.s_evi_tax_no.value;           
*/			
		}

	/**
	 * 삭제 체크
	 *  
	 * @return
	 */	
	function deleteCheck(){//alert("start deleteCheck");
		  var k = 0; 
			
	 	  for(var i=0;i<sheetObjects[0].RowCount;i++){ 	 	   		
	 				if(sheetObjects[0].CellValue(i+1,1)==1){
	 						sheetObjects[0].RowDelete(i+1, false);
	 						k++;
	 						i = i-k;
	 				}
	 	  }
	 	  
	 	  if(sheetObjects[0].RowCount==0){
	 	  		approvalFlg  = "Y";	
	 	  }
	}
	 
	 /*
	  * 단지 팝업창을 열고자 할때 사용하는 함수이다.
	  *
	  * 사용예>
	  *  rtnObjPopup(Url, Option);
	  *  noRtnPopup("test.popup.PopTest1.do", "width=310,height=350,menubar=0,status=0,scrollbars=0,resizable=0");
	  * @param String 코드구분
	  *  :
	  */
	 function noRtnPopup(myUrl, myOption) {
	     //아래 윈도우명을 통일하였기 때문에 noRtnPopup팝업은 한명의 사용자당 하나씩만 사용하게 됨, 변경시 적용할것
	 	myWin = window.open(myUrl, "noRtnPopup", myOption);
	     //myWin.moveTo(0,0);
	 	myWin.focus();
	 }
	 
	  /*
	   * Cost Office, Log-in Office Radio 버튼 클릭시 Approval Step 변경(2013.01.29)
	   * 2014.09.29  김영신 [CHM-201432136] Approval Step 사용안함
	   */
	 /*
	 function ofcChange(){
			var formObj = document.form;

			var apro_step = "";
			if(formObj.ofc_tp[0].checked){
				apro_step = formObj.cost_apro_step.value;
			}else if (formObj.ofc_tp[1].checked){
				apro_step = formObj.login_apro_step.value;
			}
			formObj.apro_step.value = apro_step;
	 }*/
	 
	/**
	 * 버튼의 스타일을 red색의 Enable 상태로 한다.  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    ComBtnEnable("btn_add") //btn_add 버튼을 red색으로 Enable
	 * </pre>
	 * @param {string} name   필수, 버튼 name 문자열
	 * @returns 없슴
	 */
 	function ComBtnEnableRed(name) {

		var tds = document.getElementsByTagName("td"); 
		for ( var i = 0; i < tds.length; i++) { 
			var td = tds[i];
			if (td.className.length > 0 && td.name == "no_"+name) {
				if (td.className.indexOf('_1') > 0)
					td.className = td.className.replace(/_1/i, "_3");
				td.name=name; 
			}
		}
 	}
 	
 	
 	/**
	 * Files management 화면을 popup 한다. <br>
	 * 
	 * @returns 없슴
	 * @see #FilesOpen
	 */
 	function FilesPopup() {
 		var height = screen.height; 
    	var width = screen.width;
                          
    	var w = 800;
        var h = 500;
        var leftpos = width/2 - w/2; 
    	var toppos = height/2 - h/2; 
    	if(leftpos<0) leftpos=0;
    	if(toppos<0) toppos=0;
		
        var url = "/hanjin/COM_CSR_0021.do?csr_no="+document.form.csr_no.value;
        window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
        //ComOpenPopup(url, w, h, "", "1,0,1,1,1", true);
 	}
	 	 
    


