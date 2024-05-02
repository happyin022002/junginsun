// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ; 

var approvalFlg = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject 	= sheetObjects[0];
         var sheetObject1 	= sheetObjects[1];
         var sheetObject2 	= sheetObjects[2];        

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {

		  	    case "btn_retrieve":
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
		  	        break;

				case "btn_EDIinvoiceview":
					var url_str = 'ESD_TES_1001Popup.screen';
					url_str += '?tml_so_ofc_cty_cd='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_ofc_cty_cd');
					url_str += '&tml_so_seq='+sheetObject.CellValue(sheetObject.SelectRow,'tml_so_seq');
//					alert(url_str);
					window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
					break;
  	        
				case "btn_new":
			          sheetObject.RemoveAll();
			          formObject.reset();
		        break;

				case "btng_detail":
						var sRow = sheetObject.FindCheckedRow(1);
						var arrRow = sRow.split("|");	
						
						if(arrRow.length<2){
								ComShowMessage(ComGetMsg('TES25001'));
								return false;
						}else{
								var inv_no 						= sheetObject.CellValue(arrRow[0],"inv_no");
								var vndr_seq 					= sheetObject.CellValue(arrRow[0],"vndr_seq");
								var tml_so_ofc_cty_cd 			= sheetObject.CellValue(arrRow[0],"tml_so_ofc_cty_cd");
								var tml_so_seq  				= sheetObject.CellValue(arrRow[0],"tml_so_seq");						
								
								var moveUrlFlg = sheetObject.CellValue(arrRow[0],"tml_inv_tp_cd");	
								var moveUrl = "";
								var flag = "Y";
								var moveUrlParam = "&inv_no="+inv_no+"&vndr_seq="+vndr_seq+"&tml_so_ofc_cty_cd="+tml_so_ofc_cty_cd+"&tml_so_seq="+tml_so_seq+"&flag="+flag;	
								
								switch(moveUrlFlg) {
										case "TM":
												moveUrl  = "ESD_TES_0017.do?pgmNo=ESD_TES_0017&sysCommUiTitle=Marine Terminal Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;
										
										case "ON":
												moveUrl  = "ESD_TES_0068.do?pgmNo=ESD_TES_0068&sysCommUiTitle=On-Dock Rail Charge Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;	
										
										case "OF":
												moveUrl  = "ESD_TES_0018.do?pgmNo=ESD_TES_0018&sysCommUiTitle=Off-Dock CY Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;	
										
										case "ST":
												moveUrl  = "ESD_TES_0019.do?pgmNo=ESD_TES_0019&sysCommUiTitle=Marine Terminal Storage Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;																										
								}	
								
								//location.href=moveUrl+moveUrlParam;
								noRtnPopup(moveUrl+moveUrlParam, 'width=950,height=580,menubar=0,status=0,scrollbars=1,resizable=1')
						}
						break;

				case "btns_calendar1":
						var cal = new ComCalendar();
						cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
						break;

				case "btng_search":
            var v_apro_step = document.form.apro_step.value;
            var param = "?mode=set&apro_step="+v_apro_step+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
    
            ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);		
            /**			
	          var v_ofc_cd = formObject.cost_ofc_cd.value;     //예) SELHO, PUSHO
	          var v_sub_sys_cd = "TES";               //예) TRS, TES
	          var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1";
	          comPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
	          **/
						break;
						
				case "btns_calendar2":
						var cal = new ComCalendar();
						cal.select(formObject.pm_due_dt, 'pm_due_dt', 'yyyy-MM-dd');
						break;						
					
				case "btng_evidence":
						if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){ 
								ComShowMessage(ComGetMsg('TES25001'));
								return false; 
						}				
				
						//if(document.form.eviInputFlg.value!="Y"){						
								if(formObject.evi_gb.value=="1"){
										//noRtnPopup('ESD_TES_078.do', 'width=775,height=580,menubar=0,status=0,scrollbars=0,resizable=0');  
										window.showModalDialog("ESD_TES_0078.do", window, "dialogWidth:790px; dialogHeight:620px; help:no; status:no; resizable:no;");
								}else if(formObject.evi_gb.value=="2"){ 
										//noRtnPopup('ESD_TES_079.do', 'width=775,height=535,menubar=0,status=0,scrollbars=0,resizable=0');   
										window.showModalDialog("ESD_TES_0079.do", window, "dialogWidth:790px; dialogHeight:590px; help:no; status:no; resizable:no;");
								}else if(formObject.evi_gb.value=="3"){ 						
								}else{ 
										//ComShowMessage("증빙구분을 선택하세요.");
								} 
						//}else{
						//		ComShowMessage("이미 저장된 증빙 입력항목사항이 있습니다. 새로운 CSR No를 발행받아서 입력하세요.");
						//}
						break;					

				case "btng_preview":
				
						/**
						var csr_amt=0;		
						for(var i=0;i<sheetObject.RowCount;i++){
								if(sheetObject.CellValue(i+1,1)==1){										
										csr_amt = parseFloat(sheetObject.CellValue(i+1,"inv_total_amt")*100)+parseFloat(csr_amt);
								}								
						}
						formObject.csr_amt.value=(csr_amt/100);
						**/
						
						var sRow = sheetObject.FindCheckedRow(1);
						var arrRow = sRow.split("|");						
						
						if(arrRow.length<2){
								ComShowMessage(ComGetMsg('TES25001'));
								return false;
						}else{
							sheetObject1.RemoveAll(); 
							sheetObject2.RemoveAll();
							doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
						}

						//noRtnPopup('ESD_TES_080.do', 'width=775,height=370,menubar=0,status=0,scrollbars=0,resizable=0');  
						break;

				case "btng_print":						
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
												if(document.form.eviInputFlg.value != "Y"){
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
						
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						approvalFlg = "Y";
						break;
      	} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025'));
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
    	self.resizeTo(1010,560); 
    	 
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }    
        /**     

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
				**/
				ComEnableObject(document.form.cost_ofc_cd, false);
				ComEnableObject(document.form.inv_cfm_dt, false); 
				ComEnableObject(document.form.vndr_seq, false);
				ComEnableObject(document.form.vndr_seq_name, false);
				ComEnableObject(document.form.cnt_inv, false);
				ComEnableObject(document.form.curr_cd, false);         
				ComEnableObject(document.form.total_amt, false);
				ComEnableObject(document.form.csr_no, false);	
				
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
				/**
				if(document.form.total_amt.value >= 0){
						document.form.csr_tp_cd.value = "S"
				}else{ 
						document.form.csr_tp_cd.value = "C"
				}		
				**/							
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
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

                    //마우스를 이용하여 데이터 영역을 블록으로 다중 선택 여부 설정  
                    //MultiSelection = false;
                    
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.||Invoice No.|Net Amount|Tax Amount|W.H.T|Total Amount" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

										InitDataProperty(0, cnt++ , dtSeq,	 					30,		daCenter,		false,    "",										false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtRadioCheck,			50,		daCenter,		false,    "",										false,			"",			dfNone,					0,			true,			true	);
										InitDataProperty(0, cnt++ , dtData,	 					200,	daLeft,			false,    "inv_no",							false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					150,	daRight,		false,    "ttl_inv_amt",				false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					150,	daRight,		false,    "vat_amt",						false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					150,	daRight,		false,    "whld_tax_amt",				false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 					80,		daRight,		false,    "inv_total_amt",			false,			"",			dfFloat,				2,			false,			false	);
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_so_ofc_cty_cd",	false,			"",			dfNone,					2,			false,			false	); 
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_so_seq",					false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "vndr_seq",						false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "tml_inv_tp_cd",			false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "edi_flg",							false,			"",			dfNone,					0,			false,			false	);
										InitDataProperty(0, cnt++ , dtHidden,	 				1,		daRight,		false,    "file_chk",							false,			"",			dfNone,					0,			false,			false	);

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
                    InitColumnInfo(18, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;

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
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_city",								false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_inv_no",							false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_desc",								false,			"",			dfNone,					2,			false,			false	);
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_debit",							false,			"",			dfNone,					2,			false,			false	); 
										InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_credit",							false,			"",			dfNone,					2,			false,			false	);										


               }
                break; 
                
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회

               	formObj.f_cmd.value = SEARCH02;                  
                sheetObj.DoSearch4Post("ESD_TES_0026GS.do", tesFrmQryStr(formObj));
                break; 
                
            case IBSAVE:        //저장                
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESD_TES_0024GS.do", tesFrmQryStr(formObj),-1,false);               
                break;
                
           case IBCOPYROW:        //행 복사
              sheetObj.DataCopy();
              break

        }
    }
     
  // Sheet관련 프로세스 처리
    function doActionIBSheet1(sheetObj,formObj,sAction) {//alert("start doActionIBSheet1");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
               	formObj.f_cmd.value = SEARCH03;                  
               	
				var param = sheetObjects[0].GetSaveString(false,false);
				var sXml = sheetObjects[2].GetSearchXml("ESD_TES_0024PreView.do", param+'&'+tesFrmQryStr(formObj));
//				sheetObjects[2].LoadSearchXml(sXml); 								
	            
				
				var arrXml = sXml.split("|$$|");

				sheetObjects[1].LoadSearchXml(arrXml[0]); 
				sheetObjects[2].LoadSearchXml(arrXml[1]); 				
                //sheetObj.DoSearch4Post("ESD_TES_024PreView.do", tesFrmQryStr(formObj));                       
                break;          
        }
    }     

	  /**
     * MInimize 클릭시 이벤트 관련
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
	     * 숫자체크
	     * @param {Object}	obj		object	
	     * @return	
	     */
		function isNum(obj){
			//숫자만..
			if (!ComIsNumber(obj)){
				obj.value = '';
			}
		}
		
		/**
		 * - 삭제
		 * @param {Object}	obj		object	
		 * @return
		 */
		function isNum1(obj){
			//숫자만..
			if (!ComIsNumber(obj,"-")){
				obj.value = '';
			}
		}		
		
		/**
		 * 날짜 체크
		 * 
		 * @param {Object}	obj		object	
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
	 * 
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */	
    function sheet3_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        
//        var previewFlg 			= "";
//        var pre_title   		= "";
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
//		var apro_step			= sheetObj.EtcData("apro_step");
		
        var previewFlg 			= "";
        var pre_title   		= "";
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
		var apro_step			= sheetObjects[1].CellValue(1,"apro_step");
		
		var pre_evi_tp_count	= "";
		
		if(cnt_cd =="KR" || pre_evi_tp == "세금계산서" || pre_evi_tp == "계산서" || pre_evi_tp == "기타" ){
				pre_evi_tp_count ="1";
		}else{
				var sRow = sheetObjects[0].FindCheckedRow(1);
				var arrRow = sRow.split("|");		
				pre_evi_tp_count =arrRow.length-1;
		}	
		
		if(pre_amt==0 || pre_amt=="0" || pre_amt=="0.00"){
				pre_title  = "TRANSFER SLIP";
		}else{
				pre_title  = "CONSULTATION SLIP";
		}				
		
		sheetObjects[1].RemoveAll();

		sheetObjects[1].DataInsert(-1);
         
        sheetObjects[1].CellValue(1,"pre_csr_no") 	= pre_csr_no;
        sheetObjects[1].CellValue(1,"pre_office") 	= document.form.cost_ofc_cd.value;
        sheetObjects[1].CellValue(1,"pre_prpd_dy") 	= pre_prpd_dy; 
        sheetObjects[1].CellValue(1,"pre_pay_to") 	= pre_pay_to;
        sheetObjects[1].CellValue(1,"pre_csr_type") = pre_csr_type;
        sheetObjects[1].CellValue(1,"pre_desc") 	= pre_desc;
        sheetObjects[1].CellValue(1,"pre_pay_group")= pre_pay_group; 
        sheetObjects[1].CellValue(1,"pre_evi_tp") 	= pre_evi_tp+"/"+pre_evi_tp_count;
        sheetObjects[1].CellValue(1,"pre_due_date") = pre_due_date;
        sheetObjects[1].CellValue(1,"pre_asa_no") 	= pre_asa_no; 
        sheetObjects[1].CellValue(1,"pre_inv_dt") 	= pre_inv_dt; 
        sheetObjects[1].CellValue(1,"pre_curr_cd") 	= pre_curr_cd; 
        sheetObjects[1].CellValue(1,"pre_amt") 		= pre_amt;
        sheetObjects[1].CellValue(1,"apro_step") 	= apro_step;  
        sheetObjects[1].CellValue(1,"pre_title") 	= pre_title;
         
        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
         		previewFlg = "krjp";
        }
        
        noRtnPopup('ESD_TES_0080.do?previewFlg='+previewFlg, 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0'); 
    }				    

	   /**
	    * onclick event처리
	    * @param sheetObj
	    * @return
	    */
		function sheet1_OnClick(sheetObj){
			try {
		    	if (sheetObj.CellValue(sheetObj.SelectRow,'edi_flg') == 'Y' && sheetObj.CellValue(sheetObj.SelectRow,'file_chk') == 'Y') {
					document.all.item("EDILayer01").style.display = "inline";
				} else {
					document.all.item("EDILayer01").style.display = "none";
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
					document.all.item("EDILayer01").style.display = "inline";
				} else {
					document.all.item("EDILayer01").style.display = "none";
				}
			} catch (e){
			}		
	    }	 
	 
    function sheet1_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }
        
        var cost_ofc_cd 		= sheetObj.EtcData("cost_ofc_cd");
        var vndr_seq 			= sheetObj.EtcData("vndr_seq"); 
        var vndr_seq_name 		= sheetObj.EtcData("vndr_seq_name");         
        var curr_cd 			= sheetObj.EtcData("curr_cd");
        var hdr_total_amt 		= sheetObj.EtcData("hdr_total_amt");
        var payment_due_dt 		= sheetObj.EtcData("payment_due_dt");
         
        document.form.cost_ofc_cd.value = cost_ofc_cd;
        document.form.vndr_seq.value = vndr_seq;
        document.form.vndr_seq_name.value = vndr_seq_name; 
        document.form.curr_cd.value = curr_cd;
        document.form.total_amt.value = hdr_total_amt;
        document.form.payment_due_dt.value = payment_due_dt;
        document.form.cnt_inv.value = sheetObjects[0].RowCount;
         
        
        /**         				
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, asaNoString);
        } 
         **/
    }
        
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

    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    } 		
    
    function asa_no_OnChange(comObj,index,text)
    {
       document.form.asa_no.value = comObj.Code;     
    } 
    
    function approvalrequest(){
     		var sheetObject = sheetObjects[0];
     		var formObject = document.form;     	
     	
				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){ 
						ComShowMessage(ComGetMsg('TES25001'));
						return false; 
				}
				
				//if(cnt_cd=="KR"){
				//if(formObject.asanogb.value=="A/P"){				
				if(cnt_cd=="KR"){
						if(formObject.evi_gb.value == ""){
								ComShowMessage(ComGetMsg('TES25002'));
								return false; 
						}else{
								if(formObject.evi_gb.value!="3"){
										if(document.form.eviInputFlg.value != "Y"){
												ComShowMessage(ComGetMsg('TES25003'));
												return false; 
										}
								}
						}
				} 		
															
				doActionIBSheet(sheetObject,formObject,IBSAVE);   
    }             
    
 	function eviGbSelect(evi_gb){
	 		if(evi_gb==1){
	 				document.form.evi_gb.value=document.form.evi_gb1.value;
	 		}else if(evi_gb==2){
				document.form.evi_gb.value=document.form.evi_gb2.value;
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
