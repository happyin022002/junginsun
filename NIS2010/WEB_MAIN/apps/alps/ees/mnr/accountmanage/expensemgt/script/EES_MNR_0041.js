/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0041.js 
*@FileTitle : MNR Invoice Creation & Correction 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
* History
* 10만불 비용지급 결재 3차 Invoice File Attatch 기능 추가 : 2014-11-12
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * 
     * @author 한진해운  
     */ 
											
    /**
     * @extends  
     * @class EES_MNR_0041 : EES_MNR_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0041() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;    

//파일업로드를 사용하기 위한 Array 변수 선언
var uploadObjects = new Array();
var uploadCnt = 0;

var initLoader = 0;

//save=1, delete=2, confirm=3, Web Invoice Reject=4 , AP cancel=5
var saveType = "";

var invInfoClearYN = "";

var invNo=""
var PrefixSheet2 = "sheet2_";
var saveRet="";

var currPrcsKnt ="0";

var saveEndYN = "";

var chkVerifyConv = "";

//CD00089 + CD00090 합치면 미주
var isAmerican = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {
				case "btn_AllNew": 
					doActionIBSheet(sheetObjects[3],document.form,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[4],document.form,IBSAVE);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[4],document.form,IBDELETE);
					break;				
				case "btn_Confirm":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC05);
					break;	
				case "btn_Cancel":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC08);
					break;					
				case "btn_Return":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC06);
					break;
				case "btn_Retrieve":
					var idx = comboObjects[0].Index;
					doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
					break;
				case "btn_New":
					setInvoiceListClear();
					break;
				case "btn_t1_Clear": 	   
					doActionIBSheet(sheetObjects[3],document.form,IBRESET); 
					break;
				case "btn_t2_Clear": 	 
					doActionIBSheet(sheetObjects[3],document.form,IBRESET); 
					break; 
				case "btn_t3_Clear":   
					doActionIBSheet(sheetObjects[3],document.form,IBRESET); 
					break; 
                case "btn_t1_DetailRetrieve":
					tabObjects[0].SelectedIndex =0;
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC02);
					break;

                case "btn_t2_DetailRetrieve":
					tabObjects[0].SelectedIndex =0;
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
					break;
										
                case "btn_t3_DetailRetrieve":
					tabObjects[0].SelectedIndex =1;
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC04);
					break;
		
                case "btn_Store":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC07);
					break;

                case "btn_Del":
					if(beforetab=="0"){
						MnrRowDelete(form.sheet1, "Check"); 
					}else{
						MnrRowDelete(form.sheet2, PrefixSheet2+"Check"); 
					}
	                break;

				case "btn_Convert": 
					doActionIBSheet(sheetObjects[6],document.form,IBSEARCH_ASYNC09);
					break;   
					
				case "btn_RepairDetail":
					var woType="";
					var eqNo="";
					var rpr_rqst_seq="";
					var rpr_rqst_ver_no="";
					var eq_knd_cd="";
					var reqStr="";
					var mnrOrdOfcCtyCd= "";    
					var mnrOrdSeq = "";
					var costOfcCd = "";

					if(beforetab=="0"){
						woType = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"mnr_wo_tp_cd")
						eqNo = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"eq_no")
						rpr_rqst_seq = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"rpr_rqst_seq")
						rpr_rqst_ver_no = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"rpr_rqst_ver_no")
						eq_knd_cd = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"eq_tpsz_cd")
						mnrOrdOfcCtyCd= sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"mnr_ord_ofc_cty_cd");    
						mnrOrdSeq = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"mnr_ord_seq");
						costOfcCd = sheetObjects[3].CellValue(sheetObjects[3].SelectRow,"cost_ofc_cd");
					}else{
						woType = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"mnr_wo_tp_cd")
						eqNo = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"eq_no")
						rpr_rqst_seq = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"rpr_rqst_seq")
						rpr_rqst_ver_no = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"rpr_rqst_ver_no")
						eq_knd_cd = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"eq_tpsz_cd")
						mnrOrdOfcCtyCd= sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"mnr_ord_ofc_cty_cd");
						mnrOrdSeq = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"mnr_ord_seq");
						costOfcCd = sheetObjects[4].CellValue(sheetObjects[4].SelectRow,PrefixSheet2+"cost_ofc_cd");
					}

					if(woType == 'EST'){ 
						if(MnrNullToBlank(eqNo) != ''){
							ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+eqNo+"&rpr_rqst_seq="+rpr_rqst_seq+"&rpr_rqst_ver_no="+rpr_rqst_ver_no+"&eq_knd_cd=" + eq_knd_cd, 1024, 768, '', '0,0', false);   		
						}   			
					}else if(woType == 'SPL'){ 
						if(MnrNullToBlank(mnrOrdOfcCtyCd) != ''&& MnrNullToBlank(mnrOrdSeq) != ''){
							ComOpenPopup('/hanjin/EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 690, '', '0,0', true);   
						}   
					}else if(woType == 'EXT'){ 
						if(MnrNullToBlank(mnrOrdOfcCtyCd) != ''&& MnrNullToBlank(mnrOrdSeq) != ''){
							ComOpenPopup('/hanjin/EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 550, '', '0,0', true);   
						}   
						
					}else if(woType == 'RFS'){ 
						if(MnrNullToBlank(mnrOrdOfcCtyCd) != ''&& MnrNullToBlank(mnrOrdSeq) != ''){
							ComOpenPopup('/hanjin/EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 500, '', '0,0', true);   
						}   
					}						
					break;
					
				case "btn_DownExcel":
					if(beforetab=="0"){
						form.sheet1.SpeedDown2Excel(-1);
					}else{
						form.sheet2.SpeedDown2Excel(-1);
					}
					break;
								
				case "btn_LoadExcel":
					var reqStr=""
					reqStr = "vndr_seq=" + form.ord_vndr_seq.value;
					reqStr += "&wo_ofc_cd=" + form.wo_ofc_cd.Code;
					ComOpenPopup('/hanjin/EES_MNR_0143.do?'+reqStr, 810, 550, 'getEES_MNR_0143', '1,0,1,1,1,1,1,1,1,1,1,1', false); 
					break;
				
				case "btn_rcv_dt": 
					var cal = new ComCalendar();       
					cal.setEndFunction("chkCurrXchRt");
 					cal.select(form.rcv_dt, 'yyyy-MM-dd'); 
					break;    

				case "btn_eff_dt": 
					var cal = new ComCalendar();       
 					cal.select(form.eff_dt, 'yyyy-MM-dd'); 
					break;   
					
				case "btn_isu_dt": 
					var cal = new ComCalendar();  
					cal.setEndFunction("chkIssDt");         
 					cal.select(form.iss_dt, 'yyyy-MM-dd');
					break;    

				case "btn_t1_calendar": 
					var cal = new ComCalendarFromTo();       
 					cal.select(form.t1_from_dt,  form.t1_to_dt,  'yyyy-MM-dd'); 
					break;    

				case "btn_t2_calendar": 
					var cal = new ComCalendarFromTo();       
 					cal.select(form.t2_from_dt,  form.t2_to_dt,  'yyyy-MM-dd'); 
					break;   
					
				case "btn_t3_calendar": 
					var cal = new ComCalendarFromTo();       
 					cal.select(form.t3_from_dt,  form.t3_to_dt,  'yyyy-MM-dd'); 
					break;   
											
		        case "btn_t1_req_multy":           
                    rep_Multiful_inquiry("t1_mnr_ord_seq");   
					break;
											
		        case "btn_t2_req_multy":           
                    rep_Multiful_inquiry("t2_mnr_ord_seq");   
					break;
											
		        case "btn_t3_req_multy":           
                    rep_Multiful_inquiry("t3_mnr_ord_seq");   
					break;
					
				case "btn_t1_provider_popup":
				    ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;					

				case "btn_t2_provider_popup":
				    ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;		
					
				case "btn_t3_provider_popup": 
				    ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;			

				case "btn_vndr":        
					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Pay_Sp', '1,0,1,1,1,1,1,1', true);
					break;   
														
				case "btn_File_Add":
					file_Insert(sheetObjects[7]);
					break;

				case "btn_File_Del":
					file_Remove(sheetObjects[7]); 
					break;
				case "btn_audit_detail":		// 2015.10.29 CHM-201538638에 의한 추가
					auditDetailPopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	initControl()
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}
  	    for(k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }			
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS_GCA.do");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrBtnRename("btn_Calcle","btn_New_All","AP Cancel");		
  	    ComBtnDisable('btn_audit_detail');
    }

	/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
					BaseColor = "255,255,255";
                    InsertTab( cnt++ , "Invoice Detail List" , -1 );
                    InsertTab( cnt++ , "Verified List" , -1 );
					InsertTab( cnt++ , "Invoice Summary" , -1 );
                }
                tabObjects[0].TabBackColor(2) = "#FF3C49";
                break;
        }
    }
	
    /**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
  		var cnt  = 0 ;
  	    var formObject = document.form
  	   
  	    switch(comboNo) {  
  	    	case 1: 
  	            with (comboObj) { 
  			        SetColAlign("left");        
  			        //SetColWidth("75")   
					UseAutoComplete = true;
  		        }
  	            break;
	        case 2: 
	           	with (comboObj) { 
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
			   	DropHeight = 160;  
				UseAutoComplete = true;
		    	}      
	        	break; 				
  	    	case 3: 
  	            with (comboObj) { 
  			        SetColAlign("left");        
  		        }
  	            break;		
  	    	case 4: 
  	            with (comboObj) { 
					MultiSeparator = "|";
					SetTitle("Code|Name");
	       	   		SetColAlign("left|left");       
					SetColWidth("70|160")     
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

        var cnt = 0;
		var sheetid = sheetObj.id;
        switch(sheetid) {
             case "t1sheet1":
                with (sheetObj) {

                   // 높이 설정
                    style.height = 182;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel|Seq.|W/O Office|S/P|INV Type|INV No.|Creation DT|SML AMT|V.A.T|Sales\nTax|W.H.T|Invoice\nTotal|Status|Country Code|ECN UT|REG. Flg|RGST No.|State Code|State Name|File Seq."
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtRadioCheck, 	40,		daCenter,  	false,     "sel",	   			false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   false,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "iss_ofc_cd",	    false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "vndr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		60,		daLeft,  	false,     "wo_type",			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		65,		daLeft,   	false,     "wo_no",    			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		75,		daLeft,   	false,     "cre_dt",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight,   	false,     "mnr_wrk_amt", 		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "vat_amt",  			false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "sls_tax_amt",  		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "whld_tax_amt", 	 	false,          "",      dfFloat,      	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight, 	false,     "ttl_amt", 			false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daLeft, 	false,     "mnr_inv_sts_nm", 	false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "cnt_cd",			false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_spcl_ecn_zn_ut_flg",	false,	"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_gst_rgst_no_flg",		false,	"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "ida_gst_rgst_no",	false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_ste_cd",		false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "ida_ste_nm",		false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "file_seq",			false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		0,		daLeft, 	false,     "dp_prcs_knt", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_term_dys", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "curr_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "vndr_seq", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_inv_seq", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_sts_cd", 	false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "iss_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "cfm_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "eff_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	false,     "rcv_dt",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_rmk", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_prnr_seq", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_vndr_lgl_eng_nm",false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "env_chg_tax",		false,          "",      dfNone,    	0,     false,       false);
					

					CountPosition = 0;
				}
				break;

             case "t2sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 182;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel|Seq.|W/O Office|S/P|W/O Type|W/O No.|W/O AMT|Creation DT|V.A.T|Sales\nTax|W.H.T|Invoice\nTotal|Country Code|ECN UT|REG. Flg|RGST No.|State Code|State Name|File Seq."
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox, 	40,		daCenter,  	false,     "sel",	   			false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   false,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "cost_ofc_cd",	    false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "vndr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		65,		daLeft,  	false,     "wo_type",			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		65,		daLeft,   	false,     "wo_no",    			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		65,		daRight,   	false,     "mnr_wrk_amt", 		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		75,		daCenter,   false,     "cre_dt",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "vat",  				false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "sls_tax_amt",  		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "wht", 	 			false,          "",      dfFloat,      	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daRight, 	false,     "ttl_amt", 			false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "cnt_cd",			false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_spcl_ecn_zn_ut_flg",	false,	"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_gst_rgst_no_flg",		false,	"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "ida_gst_rgst_no",	false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_ste_cd",		false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "ida_ste_nm",		false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,	   "file_seq",			false,			"",		 dfNone,		0,	   false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		0,		daLeft, 	false,     "dp_prcs_knt", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_term_dys", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "curr_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "vndr_seq", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "env_chg_tax",		false,          "",      dfNone,    	0,     false,       false);
					
					CountPosition = 0;
				}
				break;

             case "t3sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 182;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel|Seq.|INV Office|S/P|INV Type|INV No.|Creation DT|SML AMT|V.A.T|Sales\nTax|W.H.T|Invoice\nTotal|Status|Country Code|ECN UT|REG. Flg|RGST No.|State Code|State Name|File Seq."
					
					var headCount = ComCountHeadTitle(HeadTitle);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtRadioCheck, 	40,		daCenter,  	false,     "sel",	   			false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   false,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		80,		daCenter,  	false,     "iss_ofc_cd",	    false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "vndr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		60,		daLeft,  	false,     "wo_type",			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		65,		daCenter,   false,     "wo_no",    			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		75,		daCenter,   false,     "cre_dt",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daRight,   	false,     "mnr_wrk_amt", 		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "vat_amt",  			false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "sls_tax_amt",  		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daRight,   	false,     "whld_tax_amt", 	 	false,          "",      dfFloat,      	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight, 	false,     "ttl_amt", 			false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daLeft, 	false,     "mnr_inv_sts_nm", 	false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "cnt_cd",			false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_spcl_ecn_zn_ut_flg",	false,	"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_gst_rgst_no_flg",		false,	"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "ida_gst_rgst_no",	false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	false,     "ida_ste_cd",		false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		false,     "ida_ste_nm",		false,			"",		 dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       60,		daRight,	false,	   "file_seq",			false,	        "",		 dfNone,		0,	   false,	    false);
					InitDataProperty(0, cnt++ , dtHidden,  		0,		daRight, 	false,     "dp_prcs_knt", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_term_dys", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "curr_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "vndr_seq", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_inv_seq", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_sts_cd", 	false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "iss_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "cfm_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "eff_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	false,     "rcv_dt",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_rmk", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "inv_rgst_no", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_prnr_seq", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "pay_vndr_lgl_eng_nm", 		false,  "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "env_chg_tax",		false,          "",      dfNone,    	0,     false,       false);
					
					CountPosition = 0;
				}
				break;
								
			case "sheet1":
                with (sheetObj) {

                     // 높이 설정
                    style.height = 180;
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

					var HeadTitle1 = "|Sel|Seq.|W/O\nType|HSN/SAC|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|System Verify\nResult";
					var HeadTitle2 = "|Sel|Seq.|W/O\nType|HSN/SAC|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|Rate|AMT|Rate|AMT|Rate|AMT|Rate|AMT|Rate|AMT|System Verify\nResult";
								
					var headCount = ComCountHeadTitle(HeadTitle1);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 9 , 0, 0, true);
									
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   true,     "ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox, 	40,		daCenter,  	true,     "Check",				true,          "",      dfNone,      	0,     true,       	true);
                    InitDataProperty(0, cnt++ , dtSeq,	 		50,		daCenter,   true,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		70,		daCenter,  	true,     "mnr_wo_tp",			false,          "",      dfNone,      	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,    		70,		daCenter,  	true,     "ida_sac_cd",			false,          "",      dfNone,      	0,     false,       false,	6);
                    InitDataProperty(0, cnt++ , dtData,   		80,		daLeft,  	true,     "wo_no",				false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,   		80,		daLeft,  	true,     "rqst_ref_no",		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,  	true,     "eq_no",  	  		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daCenter,   true,     "eq_tpsz_cd",  		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daLeft,   	true,     "cost_cd", 			false,          "",      dfNone,  	  	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,  	true,     "cost_dtl_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter,  	true,     "yd_cd",				false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daCenter, 	true,     "wo_dt", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		100,	daCenter, 	true,     "rpr_rslt_dt", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,   	true,     "mnr_expn_dtl_nm",	false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daRight,   	true,     "rpr_qty", 			false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft ,   	true,     "inv_no", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		50,		daLeft ,   	true,     "curr_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,  	70,		daRight,   	true,     "cost_amt", 			false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		50,		daCenter ,  true,     "inv_curr_cd", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,  	70,		daRight,   	true,     "inv_amt", 			false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_cgst_rto", 		false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_cgst_amt", 		false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_sgst_rto", 		false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_sgst_amt", 		false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_igst_rto", 		false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_igst_amt", 		false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_ugst_rto", 		false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_ugst_amt", 		false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_gst_rto", 		false,         	"|ida_cgst_rto| + |ida_sgst_rto| + |ida_igst_rto| + |ida_ugst_rto|",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		70,		daRight,   	true,     "ida_gst_amt", 		false,         	"|ida_cgst_amt| + |ida_sgst_amt| + |ida_igst_amt| + |ida_ugst_amt|",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,  		60,		daLeft,   	true,     "mnr_vrfy_tp_cd", 	false,          "",      dfNone, 	 	0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_ord_ofc_cty_cd", false,      	"",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_ord_seq", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "ord_dtl_seq", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_wo_tp_cd", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "rpr_rqst_seq", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "rpr_rqst_ver_no", 	false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "eq_knd_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "cost_ofc_cd", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "dp_prcs_knt", 		false,          "",      dfNone, 	 	0,     false,       false);
									
					CountPosition = 0;
					
				}
				break;

			case "sheet2":
                 with (sheetObj) {

                     // 높이 설정
                    style.height = 180;
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
						
					var HeadTitle1 = "|Del|Seq.|W/O\nType|HSN/SAC|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|System Verify\nResult";
					var HeadTitle2 = "|Del|Seq.|W/O\nType|HSN/SAC|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|Rate|AMT|Rate|AMT|Rate|AMT|Rate|AMT|Rate|AMT|System Verify\nResult";
										
					var headCount = ComCountHeadTitle(HeadTitle1);
						
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,     PrefixSheet2+"ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox, 		40,		daCenter,  	true,     PrefixSheet2+"Check",					false,          "",      dfNone,      	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,	 			50,		daCenter,   true,     PrefixSheet2+"Seq");
	                InitDataProperty(0, cnt++ , dtData,    			70,		daCenter,  	true,     PrefixSheet2+"mnr_wo_tp",				false,          "",      dfNone,      	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,    			70,		daCenter,  	true,     PrefixSheet2+"ida_sac_cd",			false,          "",      dfNone,      	0,     true,       	true,	6);
                    InitDataProperty(0, cnt++ , dtData,   			80,		daLeft,  	true,     PrefixSheet2+"wo_no",					false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,   			80,		daLeft,  	true,     PrefixSheet2+"rqst_ref_no",			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			80,		daCenter,  	true,     PrefixSheet2+"eq_no",  	  			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			40,		daCenter,   true,     PrefixSheet2+"eq_tpsz_cd",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			60,		daLeft,   	true,     PrefixSheet2+"cost_cd", 				false,          "",      dfNone,  	  	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			70,		daLeft,  	true,     PrefixSheet2+"cost_dtl_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			60,		daCenter,  	true,     PrefixSheet2+"yd_cd",					false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			70,		daCenter, 	true,     PrefixSheet2+"wo_dt", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopupEditFormat,	100,    daCenter,  	true,     PrefixSheet2+"rpr_rslt_dt",     		false,          "",      dfDateYmd,		0,	   false,		false);         
					InitDataProperty(0, cnt++ , dtData,  			70,		daLeft,   	true,     PrefixSheet2+"mnr_expn_dtl_nm",		false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			60,		daRight,   	true,     PrefixSheet2+"rpr_qty", 				false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			70,		daLeft ,   	true,     PrefixSheet2+"inv_no", 				false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			50,		daCenter ,  true,     PrefixSheet2+"curr_cd", 				false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,  		70,		daRight,   	true,     PrefixSheet2+"cost_amt", 				false,          "",      dfFloat, 	 	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  			50,		daLeft ,   	true,     PrefixSheet2+"inv_curr_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,  		70,		daRight,   	true,     PrefixSheet2+"inv_amt", 				false,          "",      dfFloat, 	 	2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_cgst_rto", 			false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_cgst_amt", 			false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_sgst_rto", 			false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_sgst_amt", 			false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_igst_rto", 			false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_igst_amt", 			false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_ugst_rto", 			false,         	"",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_ugst_amt", 			false,         	"",      dfFloat, 		2,     true,       	true);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_gst_rto", 			false,         	"|sheet2_ida_cgst_rto| + |sheet2_ida_sgst_rto| + |sheet2_ida_igst_rto| + |sheet2_ida_ugst_rto|",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daRight,   	true,     PrefixSheet2+"ida_gst_amt", 			false,         	"|sheet2_ida_cgst_amt| + |sheet2_ida_sgst_amt| + |sheet2_ida_igst_amt| + |sheet2_ida_ugst_amt|",      dfFloat, 		2,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,  			60,		daLeft,   	true,     PrefixSheet2+"mnr_vrfy_tp_cd", 		false,          "",      dfNone, 	 	0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"mnr_ord_ofc_cty_cd", 	false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"mnr_ord_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"ord_dtl_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"mnr_wo_tp_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"rpr_rqst_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"rpr_rqst_ver_no", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"eq_knd_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"cost_ofc_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  			60,		daLeft,   	true,     PrefixSheet2+"dp_prcs_knt", 			false,          "",      dfNone, 	 	0,     false,       false);
					
					PopupImage  =  "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 1;   
			
					CountPosition = 0;

				}
				break;

			case "sheet3":
                 with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|W/O No.|Gamnt"
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다.	
                    InitHeadMode(true, true, false, true, false,false)	

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtData,  		65,		daLeft,   	false,     "wo_no",    	false,          "",      dfNone,      	0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,  		65,		daLeft,   	false,     "g_amnt",    false,          "",      dfNone,      	0,     false,       false);
																
					CountPosition = 0;

				}
				break;

			case "sheet4":
                 with (sheetObj) {

                    // 높이 설정  
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;  

                    //전체Edit 허용 여부 [선택, Default false] 
                    Editable = true;             
  
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100); 

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);        
						 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
					   
                    var HeadTitle = "|Seq.|W/O Amt|W/O Curr|INV Curr|Inv Amt|Point";
 									 	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true); 
    											                
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	false,   "ibflag"); 
					InitDataProperty(0, cnt++ , dtDataSeq,    		40,    	daCenter,  	true,    "Seq",     		false,          "",      dfNone);
					InitDataProperty(0, cnt++ , dtData,      		90,    	daCenter,  	false,   "inp_msg1",     	false,          "",      dfNone,		0,			true,		true);      
                    InitDataProperty(0, cnt++ , dtData,      		100,    daCenter,  	false,   "inp_msg2",     	false,        	"",      dfNone,		0,			true,		true); 
                    InitDataProperty(0, cnt++ , dtData,      		170,    daCenter,  	false,   "inp_msg3",     	false,       	"",      dfNone,		0,			true,		true);    
                    InitDataProperty(0, cnt++ , dtData,      		65,    	daLeft,     false,   "inp_msg4",     	false,        	"",      dfNone,		0,			true,		true);               
               		InitDataProperty(0, cnt++ , dtData,      		65,    	daLeft,     false,   "inp_msg5",     	false,        	"",      dfNone,		0,			true,		true);   
			   
					//SELECT 로우 배경색                  
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false;     
					MultiSelection = true;                                    
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음            
					SelectHighLight = false;           
					//선택시 볼드 사용하지 않음             
					CountPosition = 0;        

				}
				break;				
				
			case "sheetFile":	// File sheet init
				with(sheetObj) {
					// 높이 설정
					var prefix = "";
					
					style.height = 150; // sheet2 height 180
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					var HeadTitle1 = "|Seq.|File|Download|file_path_nm|file_path|file_seq|file_dtl_seq";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true); 
//					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,                   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0,	cnt++,	dtDummyCheck,	50,		daCenter,	false,		prefix + "del_chk")
					InitDataProperty(0,	cnt++,	dtPopup,		600,	daCenter,	false,		prefix + "org_file_nm",		true,		"",			dfNone,		0,			false,		true,		50);
					InitDataProperty(0,	cnt++,	dtImage,		100,		daCenter,	false,		prefix + "file_dw",			false,		"",			dfNone,		0,			false,		true);
					InitDataProperty(0,	cnt++,	dtHidden,			160,		daCenter,	false,		prefix + "file_path_nm",	false,		"",			dfNone,		0,			true,		true);
					InitDataProperty(0,	cnt++,	dtHidden,			160,		daCenter,	false,		prefix + "file_path",		false,		"",			dfNone,		0,			true,		true);
					InitDataProperty(0,	cnt++,	dtHidden,			160,		daCenter,	false,		prefix + "file_seq",		false,		"",			dfNone,		0,			true,		true);
					InitDataProperty(0,	cnt++,	dtHidden,			160,		daCenter,		true,		prefix + "file_dtl_seq",	false,		"",			dfNone,		0,			false,		false);
					
					CountPosition = 0;
					
					ImageList(0)= "/hanjin/img/ico_attach.gif";
					ShowButtonImage = 1;
				}
				break;
		}
        }
	
	/**
	 * IBUpload Object를 초기화
	 * @param uploadObj
	 * @param uploadNo
	 * @return
	 */
	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
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
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}

    /** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
	}  
	
	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}	

   /**
    * t3sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
    function t3sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount>0){
			//Delete가 아니고 저장후   재조회	
			if(saveType!="" && saveEndYN=="Y"){
				sheetObjects[2].CellValue2(1,"sel")="1";		
				tabObjects[0].SelectedIndex =1;				
				saveRet="Y";		
				doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC04);	
			}		
			saveEndYN=="";			
		}
    }    
	
   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {

		if(sheetObj.RowCount>0){
			var formObj = document.form;
			sheetObj.Redraw = false;
			sheetObj.RedrawSum = false;
			
			
	    	for(i=sheetObj.LastRow - 1; i > 1 ; i--){
				if(sheetObj.CellValue(i,  "mnr_vrfy_tp_cd")!="SS"){
					sheetObj.CellEditable(i, "Check") = false;
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
				}
//				if(sheetObj.CellValue(i,"mnr_wo_tp_cd") != "EST"){
//					sheetObj.CellValue2(i,"rpr_rslt_dt") = sheetObj.CellValue(i,"wo_dt")
//				}

				sheetObj.CellValue2(i,"inv_curr_cd") = formObj.curr_cd.value;
			}
		
			sheetObj.Redraw = true;
			sheetObj.RedrawSum = true;
			
			//Load Excel 처리시
			if(formObj.pay_inv_seq.value==""){			
				var cnt=0;
				var gAmt=0;
				var invAmt=0;	
				for(i=sheetObjects[5].LastRow; i > 0 ; i--){
					cnt = 0;
					gAmt = 0;
					invAmt = 0;
					gAmt=gAmt + parseFloat(sheetObjects[5].CellValue(i,  "g_amnt"));
					for(j=sheetObj.LastRow; j > 1 ; j--){
						if(sheetObj.CellValue(j,  "wo_no")==sheetObjects[5].CellValue(i,  "wo_no")){
							cnt=cnt + 1;
						}
					}
					for(j=sheetObj.LastRow; j > 1 ; j--){
						if(sheetObj.CellValue(j,  "wo_no")==sheetObjects[5].CellValue(i,  "wo_no")){
							sheetObj.CellValue(j,  "inv_amt")=sheetObjects[5].CellValue(i,  "g_amnt")/cnt;
							invAmt = invAmt + parseFloat(sheetObj.CellValue(j,  "inv_amt"));
						}
					}
					if((gAmt*100)/100 > (invAmt*100)/100){
						sheetObj.CellValue(sheetObj.LastRow - 1,  "inv_amt")=sheetObj.CellValue(sheetObj.LastRow - 1,  "inv_amt") - (gAmt - invAmt);
					}else{
						sheetObj.CellValue(sheetObj.LastRow - 1,  "inv_amt")=sheetObj.CellValue(sheetObj.LastRow - 1,  "inv_amt") - (invAmt - gAmt);
					}

				}
			}
		}
    }
	
   /**
    * sheet2에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount>0){
			var formObj = document.form;
				
			sheetObj.Redraw = false;
			sheetObj.RedrawSum = false;
			for(i=2; i<sheetObj.RowCount + 2; i++){
				if(sheetObj.CellValue(i,  PrefixSheet2+"mnr_vrfy_tp_cd")!="SS"){
					sheetObj.CellEditable(i, PrefixSheet2+"Check") = false;
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
				}
				sheetObj.CellValue2(i,PrefixSheet2+"inv_curr_cd") = formObj.curr_cd.value;
			}
			
			sheetObj.Redraw = true;
			sheetObj.RedrawSum = true;
			
			calcGamount();
		}
    }
	
   /**
    * 저장후에 로딩메시지 save=1, delete=2, confirm=3, Web Invoice Reject=4 , AP cancel=5
    * @param sheetObj
    * @param ErrMsg
    * @return
    */   
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") { 
			if(saveType=="1"){
				ComShowCodeMessage("MNR00085"); 
			}else if(saveType=="2"){
				ComShowCodeMessage("MNR00090","Invoice "); 
				doActionIBSheet(sheetObjects[3],document.form,IBCLEAR);
			}else if(saveType=="3"){
				ComShowCodeMessage("MNR00086"); 
				ComBtnDisable('btn_Save');
				ComBtnDisable('btn_Delete');
				MnrBtnRename("btn_Confirm","btn_Cancel","AP Cancel");	
				ComBtnEnable("btn_cancel")		
			}else if(saveType=="4"){
				ComShowCodeMessage("MNR00094"); 
			}else if(saveType=="5"){
				ComShowCodeMessage("MNR00300"); 
				 
				ComBtnEnable('btn_Save');
				ComBtnEnable('btn_Delete');
				ComBtnEnable('btn_Confirm');
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");	
			}		

			saveEndYN="Y";
			comboObjects[0].Code = "CO";
			var idx = comboObjects[0].Index;
			document.form.mnr_inv_sts_cd.value="";
			
			doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
		} else { 
	  		ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
	}

   /**
    * sheet2에서 PopupClick이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
	function sheet2_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != PrefixSheet2+"rpr_rslt_dt") return;
		var cal = new ComCalendarGrid();
		cal.setEndFunction("setRowBackColorChange");
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}


	
   /**
    * sheet2에서 Change이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
	function sheet2_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
		var errFlg = "";
		
		if( colName == PrefixSheet2 + "rpr_rslt_dt" ){
			setRowBackColorChange();
		} else if( colName == PrefixSheet2 + "ida_sac_cd" && Value != "" ){
			errFlg = MnrChkSacCdValid(sheetObjects[0], Value);
			chkSacCdValid(errFlg, sheetObj, Row, colName, Value);
		} else if( colName == PrefixSheet2 + "inv_amt" || colName == PrefixSheet2 + "ida_cgst_amt" || colName == PrefixSheet2 + "ida_sgst_amt" || colName == PrefixSheet2 + "ida_igst_amt" || colName == PrefixSheet2 + "ida_ugst_amt" ){
			calcGamount();
		}			  
	}
	
	function chkSacCdValid(errFlg, sheetObj, Row, colName, ida_sac_cd){
		var formObj = document.form;
		
    	if( errFlg == "N" ){
    		var idaGstRto = MnrGetIdaGstRto(sheetObj, formObj.agmt_ofc_cd.value, formObj.mnr_prnr_seq.value, ida_sac_cd);
			setIdaGstRto(idaGstRto, Row);
    	} else {
    		ComShowCodeMessage("MNR00421");
    		sheetObj.CellValue2(Row, colName) = "";
    	}
    }
	
	function setIdaGstRto(strIdaGstRto, Row){
//		ex) strIdaGstRto : 998719|0|0|18|0#
		var idaCgstRto = 0;
		var idaSgstRto = 0;
		var idaIgstRto = 0;
		var idaUgstRto = 0;
		var idaCgstAmt = 0.0;
		var idaSgstAmt = 0.0;
		var idaIgstAmt = 0.0;
		var idaGgstAmt = 0.0;
		var arrIdaGstRto = strIdaGstRto.replace(/#/g,"").split("|");
		
		if( arrIdaGstRto.length == 5 ){
			idaCgstRto = parseFloat(arrIdaGstRto[1]);
			idaSgstRto = parseFloat(arrIdaGstRto[2]);
			idaIgstRto = parseFloat(arrIdaGstRto[3]);
			idaUgstRto = parseFloat(arrIdaGstRto[4]);
		}
		
		var invAmt = parseFloat(sheetObjects[4].CellValue(Row, PrefixSheet2+"inv_amt"));
		
		idaCgstAmt = Math.round(parseFloat(invAmt * idaCgstRto / 100) * 1000) / 1000;
		idaSgstAmt = Math.round(parseFloat(invAmt * idaSgstRto / 100) * 1000) / 1000;
		idaIgstAmt = Math.round(parseFloat(invAmt * idaIgstRto / 100) * 1000) / 1000;
		idaUgstAmt = Math.round(parseFloat(invAmt * idaUgstRto / 100) * 1000) / 1000;
		
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_cgst_rto") = idaCgstRto;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_sgst_rto") = idaSgstRto;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_igst_rto") = idaIgstRto;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_ugst_rto") = idaUgstRto;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_cgst_amt") = idaCgstAmt;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_sgst_amt") = idaSgstAmt;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_igst_amt") = idaIgstAmt;
		sheetObjects[4].CellValue2(Row, PrefixSheet2+"ida_ugst_amt") = idaUgstAmt;
		
		calcGamount();
		
	}

    function sheet4_OnSaveEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount>0){
			var formObj = document.form;
	    	for(i=sheetObj.LastRow; i > 0 ; i--){
				currPrcsKnt =sheetObj.CellValue(i,  "inp_msg5")
				
				currPrcsSet(currPrcsKnt);
				
				sheetObjects[4].CellValue2(i + 1,  PrefixSheet2+"inv_amt") = sheetObj.CellValue(i,  "inp_msg4");
			}
			formObj.curr_cd.value = formObj.target_curr_cd.Code;
		}	
	}	
			
	 /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

	/**  
	 * combo1 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		var kind = comboObj.Index;
		changeKind(kind);
		sheetObjects[7].RemoveAll();
		
		// eas audit detail 버튼은 Invoice Correction에서만 활성화됨
		if(kind=="0" || kind=="1"){
			ComBtnEnable('btn_Store');
		}else{
			ComBtnDisable('btn_Store');
		}
		
		if (kind=="0") {
			tabObjects[0].TabEnable(2) = false;
		} else {
			tabObjects[0].TabEnable(2) = true;
		}
	}   	

	/**  
	 * target_curr_cd Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function target_curr_cd_OnChange(comboObj,Index_Code, Text){ 
		chkCurrXchRt();
	} 
	
	/**  
	 * India Tax 이벤트      
	 */  
	function india_tax_style(){
		var cntCd = document.form.cnt_cd.value;
		var sbcTax = document.form.env_chg_tax.value;
		
		// Invoice Office Code가 BOMSC, DELSO, CCUSO, AEVSO, LDHSO, COKSO, VPMKS, MAASO일 경우 SBC tax를 활성화
		if( cntCd == "IN" && parseFloat(sbcTax) > 0 ){
			document.all.sbcTax.style.display = "";
			document.all.idaGstTax.style.display = "none";
			document.all.idaGstInfo.style.display = "none";
			document.getElementById("vatTax").innerHTML = "V.A.Tax";
			MnrFormSetReadOnly(document.form,false,"vat_amt");	
//			document.form.vat_amt.disabled = false;
			
			sheetObjects[3].ColHidden("ida_sac_cd") = true;
			sheetObjects[3].ColHidden("ida_cgst_rto") = true;
			sheetObjects[3].ColHidden("ida_cgst_amt") = true;
			sheetObjects[3].ColHidden("ida_sgst_rto") = true;
			sheetObjects[3].ColHidden("ida_sgst_amt") = true;
			sheetObjects[3].ColHidden("ida_igst_rto") = true;
			sheetObjects[3].ColHidden("ida_igst_amt") = true;
			sheetObjects[3].ColHidden("ida_ugst_rto") = true;
			sheetObjects[3].ColHidden("ida_ugst_amt") = true;
			sheetObjects[3].ColHidden("ida_gst_rto") = true;
			sheetObjects[3].ColHidden("ida_gst_amt") = true;
			
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sac_cd") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_cgst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_cgst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sgst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sgst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_igst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_igst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_ugst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_ugst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_gst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_gst_amt") = true;
			sheetObjects[4].InitDataProperty(0, 4 , dtData,    		70,		daCenter,  	true,     PrefixSheet2+"ida_sac_cd",	false,		"",      dfNone,    0,     true,    true,	6);
		} else if( cntCd == "IN" ){		//GST 적용 ( CGST, SGST, IGST, UGST )
			document.all.sbcTax.style.display = "none";
			document.form.env_chg_tax.value = "0.00";
			document.form.ida_cgst_amt.value="0.00";
			document.form.ida_sgst_amt.value="0.00";
			document.form.ida_igst_amt.value="0.00";
			document.form.ida_ugst_amt.value="0.00";
			
			document.all.idaGstTax.style.display = "";
			document.all.idaGstInfo.style.display = "";
			document.getElementById("vatTax").innerHTML = "GST Amount";
			MnrFormSetReadOnly(document.form,true,"vat_amt");
//			document.form.vat_amt.disabled = true;
			
			sheetObjects[3].ColHidden("ida_sac_cd") = false;
			sheetObjects[3].ColHidden("ida_cgst_rto") = false;
			sheetObjects[3].ColHidden("ida_cgst_amt") = false;
			sheetObjects[3].ColHidden("ida_sgst_rto") = false;
			sheetObjects[3].ColHidden("ida_sgst_amt") = false;
			sheetObjects[3].ColHidden("ida_igst_rto") = false;
			sheetObjects[3].ColHidden("ida_igst_amt") = false;
			sheetObjects[3].ColHidden("ida_ugst_rto") = false;
			sheetObjects[3].ColHidden("ida_ugst_amt") = false;
			sheetObjects[3].ColHidden("ida_gst_rto") = false;
			sheetObjects[3].ColHidden("ida_gst_amt") = false;
			
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sac_cd") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_cgst_rto") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_cgst_amt") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sgst_rto") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sgst_amt") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_igst_rto") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_igst_amt") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_ugst_rto") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_ugst_amt") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_gst_rto") = false;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_gst_amt") = false;
			
			//India GST Tax 에서 SAC Code는 필수이므로 필수 체크 및 각 GST Amount의 총 합계를 표한하기 위한 소스
			sheetObjects[3].InitDataProperty(0, 22, dtAutoSumEx,  	70,		daRight,   	true,     "ida_cgst_amt", 						false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[3].InitDataProperty(0, 24, dtAutoSumEx,  	70,		daRight,   	true,     "ida_sgst_amt", 						false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[3].InitDataProperty(0, 26, dtAutoSumEx,  	70,		daRight,   	true,     "ida_igst_amt", 						false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[3].InitDataProperty(0, 28, dtAutoSumEx,  	70,		daRight,   	true,     "ida_ugst_amt", 						false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[3].InitDataProperty(0, 30, dtAutoSumEx,  	70,		daRight,   	true,     "ida_gst_amt", 						false,  "|ida_cgst_amt| + |ida_sgst_amt| + |ida_igst_amt| + |ida_ugst_amt|",      dfFloat, 		2,     false,       false);
			sheetObjects[4].InitDataProperty(0,  4, dtData,    		70,		daCenter,  	true,     PrefixSheet2+"ida_sac_cd",			true,	"",      dfNone,    0,     true,    true,	6);
			sheetObjects[4].InitDataProperty(0, 22, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"ida_cgst_amt", 			false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[4].InitDataProperty(0, 24, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"ida_sgst_amt", 			false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[4].InitDataProperty(0, 26, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"ida_igst_amt", 			false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[4].InitDataProperty(0, 28, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"ida_ugst_amt", 			false,  "",      dfFloat, 		2,     true,       	true);
			sheetObjects[4].InitDataProperty(0, 30, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"ida_gst_amt", 			false,  "|sheet2_ida_cgst_amt| + |sheet2_ida_sgst_amt| + |sheet2_ida_igst_amt| + |sheet2_ida_ugst_amt|",      dfFloat, 		2,     false,       false);
		} else {
			document.all.sbcTax.style.display = "none";
			document.form.env_chg_tax.value = "0.00"; // 인도 오피스가 아닌 경우 0으로 초기화
			
			document.all.idaGstTax.style.display = "none";
			document.all.idaGstInfo.style.display = "none";
			document.getElementById("vatTax").innerHTML = "V.A.Tax";
			MnrFormSetReadOnly(document.form,false,"vat_amt");
			
			
			sheetObjects[3].ColHidden("ida_sac_cd") = true;
			sheetObjects[3].ColHidden("ida_cgst_rto") = true;
			sheetObjects[3].ColHidden("ida_cgst_amt") = true;
			sheetObjects[3].ColHidden("ida_sgst_rto") = true;
			sheetObjects[3].ColHidden("ida_sgst_amt") = true;
			sheetObjects[3].ColHidden("ida_igst_rto") = true;
			sheetObjects[3].ColHidden("ida_igst_amt") = true;
			sheetObjects[3].ColHidden("ida_ugst_rto") = true;
			sheetObjects[3].ColHidden("ida_ugst_amt") = true;
			sheetObjects[3].ColHidden("ida_gst_rto") = true;
			sheetObjects[3].ColHidden("ida_gst_amt") = true;
			
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sac_cd") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_cgst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_cgst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sgst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_sgst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_igst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_igst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_ugst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_ugst_amt") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_gst_rto") = true;
			sheetObjects[4].ColHidden(PrefixSheet2+"ida_gst_amt") = true;
			sheetObjects[4].InitDataProperty(0, 4 , dtData,    		70,		daCenter,  	true,     PrefixSheet2+"ida_sac_cd",	false,		"",      dfNone,    0,     true,    true,	6);
		}
	} 
	
  	/**
     * Sheet관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
				
        switch(sAction) {

          	case IBSEARCH:      //조회
	          	if(validateForm(sheetObj,formObj,sAction)){

					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();	
					
					setInvoiceListValue();

					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("EES_MNR_0041GS.do",FormQueryString(formObj));
				}		
                break;

          	case IBSEARCH_ASYNC02:      //Web Import detail 조회
				if(formObj.pay_inv_seq.value != ""){
					if(ComShowCodeConfirm("MNR00230")){
						invInfoClearYN="Y"
						setInvoiceInfomationClear();
					}else{
						invInfoClearYN="N"
					}
				}           	
	          	if(validateForm(sheetObj,formObj,sAction)){          	
	          		ComSetObjValue(formObj.list_kind,"WI");
	          		
					sheetObjects[3].RemoveAll();   
					setInvoiceListValue();
					
					if(invInfoClearYN!="N"){

						for(var i = 1; i <= sheetObjects[0].RowCount; i++){  
							if(sheetObjects[0].CellValue(i,"sel") == 1){
								//currency별  소수점 가져오기
								currPrcsKnt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"dp_prcs_knt");
								currPrcsSet(currPrcsKnt);
																
								formObj.combo2.Code = sheetObjects[0].CellValue(i,"mnr_inv_sts_cd");		

								ComSetObjValue(formObj.ord_vndr_seq, sheetObjects[0].CellValue(i,"vndr_seq"));
								ComSetObjValue(formObj.ord_vndr_seq_nm, sheetObjects[0].CellValue(i,"vndr_lgl_eng_nm"));
								
								ComSetObjValue(formObj.mnr_prnr_seq, sheetObjects[0].CellValue(i,"mnr_prnr_seq"));
								ComSetObjValue(formObj.vndr_nm, sheetObjects[0].CellValue(i,"pay_vndr_lgl_eng_nm"));
								
								ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
								ComSetObjValue(formObj.cnt_cd, sheetObjects[0].CellValue(i,"cnt_cd"));
								ComSetObjValue(formObj.gen_pay_term_cd, sheetObjects[0].CellValue(i,"pay_term_dys"));
								ComSetObjValue(formObj.curr_cd, sheetObjects[0].CellValue(i,"curr_cd"));
								formObj.target_curr_cd.Code2 = formObj.curr_cd.value;
																		
								ComSetObjValue(formObj.inv_no, sheetObjects[0].CellValue(i,"wo_no"));
								ComSetObjValue(formObj.inv_status, sheetObjects[0].CellValue(i,"mnr_inv_sts_nm"));
								ComSetObjValue(formObj.rcv_dt, sheetObjects[0].CellValue(i,"rcv_dt"));
								ComSetObjValue(formObj.iss_dt, sheetObjects[0].CellValue(i,"iss_dt"));
																
								ComSetObjValue(formObj.mnr_inv_rmk, sheetObjects[0].CellValue(i,"mnr_inv_rmk"));
								ComSetObjValue(formObj.pay_inv_seq, sheetObjects[0].CellValue(i,"pay_inv_seq"));
								ComSetObjValue(formObj.mnr_inv_sts_cd, sheetObjects[0].CellValue(i,"mnr_inv_sts_cd"));
								ComSetObjValue(formObj.bzc_amt, sheetObjects[0].CellValue(i,"mnr_wrk_amt"));
								ComSetObjValue(formObj.vat_amt, sheetObjects[0].CellValue(i,"vat_amt"));
								ComSetObjValue(formObj.sls_tax_amt, sheetObjects[0].CellValue(i,"sls_tax_amt"));
								ComSetObjValue(formObj.whld_tax_amt, sheetObjects[0].CellValue(i,"whld_tax_amt"));
								ComSetObjValue(formObj.ttl_amt, sheetObjects[0].CellValue(i,"ttl_amt"));
								break;		
							}
						}
						
						india_tax_style();
						
						formObj.f_cmd.value = SEARCH01;
						var sParam = ComGetSaveString(sheetObjects[0]);
						sParam += "&" + FormQueryString(formObj);			
						
						var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", sParam);
						sheetObj.LoadSearchXml(sXml);
					
					}						
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save');
						ComBtnDisable('btn_Delete');
						ComBtnDisable('btn_Confirm');
						ComBtnDisable('btn_File_Add');
						ComBtnDisable('btn_File_Del');
					}else{
						ComBtnEnable('btn_Save');
						ComBtnEnable('btn_Delete');
						ComBtnEnable('btn_Confirm');
						ComBtnEnable('btn_File_Add');
						ComBtnEnable('btn_File_Del');
					}	 
					if(comboObjects[0].Index=="0"){
						ComBtnEnable('btn_Return')
					}else{
						ComBtnDisable('btn_Return')
					}			
					
					formObj.file_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"file_seq");
					var fileSeq = formObj.file_seq.value;
					if (!ComIsEmpty(fileSeq)) {
						var fileXml = SearchFileUpload(sheetObjects[7],fileSeq);
						sheetObjects[7].LoadSearchXml(fileXml);
					} else {
						sheetObjects[7].RemoveAll();
					}
				}		
          		break;

          	case IBSEARCH_ASYNC03:      //Work Order Detail조회
          	
	          	if(validateForm(sheetObj,formObj,sAction)){
	          		ComSetObjValue(formObj.list_kind,"MI");
	          		
					sheetObjects[3].RemoveAll();      
					setInvoiceListValue();      	
					
					if(invInfoClearYN!="N"){
						
						
						for(var i = 1; i <= sheetObjects[1].RowCount; i++){  
							if(sheetObjects[1].CellValue(i,"sel") == 1){ 
								//currency별  소수점 가져오기
								currPrcsKnt = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"dp_prcs_knt");
								currPrcsSet(currPrcsKnt);

								//공통콤보 정보를 가져온다.  
								var sCondition = new Array (
									new Array("PrntVndrSeq",sheetObjects[1].CellValue(i,"vndr_seq"), "COMMON")  
								);   
								
								var comboList = MnrComSearchCombo(sheetObj,sCondition);
				
								//콤보 설정
								for(var k = 0; k < comboList.length;k++){
									if(comboList[k] != null){
										//쉬트콤보별 초기화
										for(var j = 0; j < comboList[k].length;j++){ 
											var tempText = comboList[k][j].split("|");
											if(k==0) {
												formObj.mnr_prnr_seq.value=tempText[0];
												formObj.vndr_nm.value=tempText[1];
											}								
										}
									}
								}
													
								ComSetObjValue(formObj.ord_vndr_seq, sheetObjects[1].CellValue(i,"vndr_seq"));
								ComSetObjValue(formObj.ord_vndr_seq_nm, sheetObjects[1].CellValue(i,"vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
								ComSetObjValue(formObj.cnt_cd, sheetObjects[1].CellValue(i,"cnt_cd"));
								ComSetObjValue(formObj.gen_pay_term_cd, sheetObjects[1].CellValue(i,"pay_term_dys"));
								ComSetObjValue(formObj.ida_gst_rgst_no, sheetObjects[1].CellValue(i,"ida_gst_rgst_no"));
								ComSetObjValue(formObj.ida_ste_cd, sheetObjects[1].CellValue(i,"ida_ste_cd"));
								ComSetObjValue(formObj.ida_ste_nm, sheetObjects[1].CellValue(i,"ida_ste_nm"));
								
								india_tax_style();
								
								if(formObj.pay_inv_seq.value==""){
									ComSetObjValue(formObj.curr_cd, sheetObjects[1].CellValue(i,"curr_cd"));
									formObj.target_curr_cd.Code2 = formObj.curr_cd.value;
								}
								
								if(formObj.target_curr_cd.Code != formObj.curr_cd.value){
									formObj.target_curr_cd.Code2 = formObj.curr_cd.value;
								}
								
								break;		
							}		
						}	
						formObj.f_cmd.value = SEARCH01;				
						var sParam = ComGetSaveString(sheetObjects[1]);
						sParam += "&" + FormQueryString(formObj);	

						var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", sParam);
						sheetObj.LoadSearchXml(sXml);
					}			

					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save');
						ComBtnDisable('btn_Delete');
						ComBtnDisable('btn_Confirm');
						ComBtnDisable('btn_File_Add');
						ComBtnDisable('btn_File_Del');
					}else{
						ComBtnEnable('btn_Save');
						ComBtnEnable('btn_Delete');
						ComBtnEnable('btn_Confirm');
						ComBtnEnable('btn_File_Add');
						ComBtnEnable('btn_File_Del');
					}	 
					if(comboObjects[0].Index=="0"){
						ComBtnEnable('btn_Return')
					}else{
						ComBtnDisable('btn_Return')
					}
					
					formObj.file_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"file_seq");
					var fileSeq = formObj.file_seq.value;
					if (!ComIsEmpty(fileSeq)) {
						var fileXml = SearchFileUpload(sheetObjects[7],fileSeq);
						sheetObjects[7].LoadSearchXml(fileXml);
					} else {
						sheetObjects[7].RemoveAll();
					}
				}	
          		break;

          	case IBSEARCH_ASYNC04:      //Invoice Detail조회
          	    // Save 후 자동 처리되도록 수정
         		if(saveRet=="Y") {
					invInfoClearYN="Y"
					setInvoiceInfomationClear();					
				} else {
					if(formObj.pay_inv_seq.value != ""){					
						if(ComShowCodeConfirm("MNR00230")){
							invInfoClearYN="Y"
							setInvoiceInfomationClear();
						}else{
							invInfoClearYN="N"
						}
					}              	
				}
				saveRet=="N";
	          	if(validateForm(sheetObj,formObj,sAction)){
	          		ComSetObjValue(formObj.list_kind,"CO");
      	
					sheetObjects[3].RemoveAll();
					if(invInfoClearYN!="N"){
						sheetObjects[4].RemoveAll();
					}				
					setInvoiceListValue();
					formObj.f_cmd.value = SEARCH01;				
					var sParam = ComGetSaveString(sheetObjects[2]);	
					sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);
					if(invInfoClearYN!="N"){

						for(var i = 1; i <= sheetObjects[2].RowCount; i++){  
							if(sheetObjects[2].CellValue(i,"sel") == 1){ 

								//currency별  소수점 가져오기		  
								currPrcsKnt = sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"dp_prcs_knt");
								currPrcsSet(currPrcsKnt);
								
								formObj.combo2.Code = sheetObjects[2].CellValue(i,"mnr_inv_sts_cd");

								ComSetObjValue(formObj.ord_vndr_seq, sheetObjects[2].CellValue(i,"vndr_seq"));
								ComSetObjValue(formObj.ord_vndr_seq_nm, sheetObjects[2].CellValue(i,"vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.mnr_prnr_seq, sheetObjects[2].CellValue(i,"mnr_prnr_seq"));
								ComSetObjValue(formObj.vndr_nm, sheetObjects[2].CellValue(i,"pay_vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
								ComSetObjValue(formObj.cnt_cd, sheetObjects[2].CellValue(i,"cnt_cd"));
								ComSetObjValue(formObj.gen_pay_term_cd, sheetObjects[2].CellValue(i,"pay_term_dys"));
								ComSetObjValue(formObj.curr_cd, sheetObjects[2].CellValue(i,"curr_cd"));
								formObj.target_curr_cd.Code2 = formObj.curr_cd.value;
								ComSetObjValue(formObj.inv_no, sheetObjects[2].CellValue(i,"wo_no"));
								ComSetObjValue(formObj.inv_status, sheetObjects[2].CellValue(i,"mnr_inv_sts_nm"));
								ComSetObjValue(formObj.rcv_dt, sheetObjects[2].CellValue(i,"rcv_dt"));
								ComSetObjValue(formObj.iss_dt, sheetObjects[2].CellValue(i,"iss_dt"));
								ComSetObjValue(formObj.mnr_inv_rmk, sheetObjects[2].CellValue(i,"mnr_inv_rmk"));
								ComSetObjValue(formObj.pay_inv_seq, sheetObjects[2].CellValue(i,"pay_inv_seq"));
								ComSetObjValue(formObj.mnr_inv_sts_cd, sheetObjects[2].CellValue(i,"mnr_inv_sts_cd"));
								ComSetObjValue(formObj.inv_rgst_no, sheetObjects[2].CellValue(i,"inv_rgst_no"));
//								ComSetObjValue(formObj.env_chg_tax, sheetObjects[2].CellValue(i,"env_chg_tax"));
								ComSetObjValue(formObj.ida_gst_rgst_no, sheetObjects[2].CellValue(i,"ida_gst_rgst_no"));
								ComSetObjValue(formObj.ida_ste_cd, sheetObjects[2].CellValue(i,"ida_ste_cd"));
								ComSetObjValue(formObj.ida_ste_nm, sheetObjects[2].CellValue(i,"ida_ste_nm"));
								
								ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(sheetObjects[2].CellValue(i,"sls_tax_amt"), "#,###.00"));
								ComSetObjValue(formObj.bzc_amt, ComAddComma2(sheetObjects[2].CellValue(i,"mnr_wrk_amt"), "#,###.00"));
								ComSetObjValue(formObj.vat_amt, ComAddComma2(sheetObjects[2].CellValue(i,"vat_amt"), "#,###.00"));
								ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(sheetObjects[2].CellValue(i,"whld_tax_amt"), "#,###.00"));							
								ComSetObjValue(formObj.ttl_amt, ComAddComma2(sheetObjects[2].CellValue(i,"ttl_amt"), "#,###.00"));
								ComSetObjValue(formObj.env_chg_tax, ComAddComma2(sheetObjects[2].CellValue(i,"env_chg_tax"), "#,###.00"));
									
								india_tax_style();
								break;	
							}
						}   
						var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", sParam);
						sheetObj.LoadSearchXml(sXml);
						
						
						// Invoice Correctiion의 경우 Detail을 눌렀을 경우 EAS Audit 결과를 볼수 있음
						// N/A는 심사대상이 아닌경우(Simple, Estimate)만 대상
						formObj.eas_audit_desc.value = ComGetEtcData(sXml, "eas_audit_desc");
						if(formObj.eas_audit_desc.value != "" && formObj.eas_audit_desc.value != "N/A"){
							ComBtnEnable("btn_audit_detail");
						}
					}
					
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save');
						ComBtnDisable('btn_Delete');
						MnrBtnRename("btn_Confirm","btn_Cancel","AP Cancel");	
						ComBtnEnable("btn_cancel");
						ComBtnDisable('btn_File_Add');
						ComBtnDisable('btn_File_Del');
					}else{
						ComBtnEnable('btn_Save');
						ComBtnEnable('btn_Delete');
						ComBtnEnable('btn_Confirm');
						ComBtnEnable('btn_File_Add');
						ComBtnEnable('btn_File_Del');
					}	 
					if(comboObjects[0].Index=="0"){
						ComBtnEnable('btn_Return')
					}else{	
						ComBtnDisable('btn_Return')
					}	
					
					formObj.file_seq.value = sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"file_seq");
					var fileSeq = formObj.file_seq.value;
					if (!ComIsEmpty(fileSeq)) {
						var fileXml = SearchFileUpload(sheetObjects[7],fileSeq);
						sheetObjects[7].LoadSearchXml(fileXml);
					} else {
						sheetObjects[7].RemoveAll();
					}
				}		
          		break;
														
	 		case IBSAVE:        // Save
	          	if(validateForm(sheetObj,formObj,sAction)){
					saveType = "1";					
					formObj.mnr_inv_sts_cd.value="HS";
					formObj.mnr_grp_tp_cd.value="RPR";
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObj);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);

					var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", sParam);

					if(MnrComGetErrMsg(sXml) == null){
						var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
						if(State == "S"){
							ComSetObjValue(formObj.pay_inv_seq, ComGetEtcData(sXml, "pay_inv_seq"));  
							formObj.combo2.Code = formObj.mnr_inv_sts_cd.value;	
						}
					}
					sheetObj.LoadSaveXml(sXml); 
					
					if(formObj.eas_audit_desc.value == "Candidate EAC"){ // Candidate EAC일 경우 REMARK를 무조건 입력할 수 있도록 안내창과 포커스를 부여
						ComShowCodeMessage("MNR00420");
						formObj.mnr_inv_rmk.focus();
					}
				}	
                break;

          	case IBSEARCH_ASYNC05:      //Confirm
	          	if(validateForm(sheetObj,formObj,sAction)){	
					 //Confirm 의사 확인   
					if(!ComShowCodeConfirm("MNR00330","Confirm")){return false;}
					saveType = "3";							   
					formObj.mnr_inv_sts_cd.value="HC";
					formObj.mnr_grp_tp_cd.value="RPR";
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);					

					var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
						if(State == "S"){
							ComSetObjValue(formObj.pay_inv_seq, ComGetEtcData(sXml, "pay_inv_seq"));  
							formObj.combo2.Code = formObj.mnr_inv_sts_cd.value;						
						}
					}
					sheetObj.LoadSaveXml(sXml); 
					
				}
          		break;
				
			case IBSEARCH_ASYNC06:      //Reject
	          	if(validateForm(sheetObj,formObj,sAction)){		
					if(!ComShowCodeConfirm("MNR00092")){return;}							
					saveType = "4";
					formObj.mnr_inv_sts_cd.value="HJ";
					formObj.f_cmd.value = MULTI;
					
					var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", FormQueryString(formObj));
					formObj.combo2.Code = formObj.mnr_inv_sts_cd.value;
					sheetObj.LoadSaveXml(sXml); 
				}	
				break;
				
			case IBSEARCH_ASYNC07:      //Store
				if(validateForm(sheetObj,formObj,sAction)){
					tabObjects[0].SelectedIndex =1;
					
					formObj.sheet2.Redraw    = false;
					formObj.sheet2.RedrawSum = false;
					
					var sXml = MnrGetDataSearchXml(formObj.sheet1, formObj.sheet2);
					formObj.sheet2.LoadSearchXml(sXml);

					MnrRowDelete(form.sheet1, "Check");
			
					//ComSheet2SheetCheck(formObj.sheet1, formObj.sheet2, "Check");
					//formObj.sheet2.ColumnSort(PrefixSheet2+"Seq", "ASC")
					for(var i = 2; i <= (formObj.sheet2.RowCount + 1); i++){
					    if(formObj.sheet2.CellValue(i,PrefixSheet2+"mnr_wo_tp_cd") == "EST"){
							formObj.sheet2.CellEditable(i,PrefixSheet2+"rpr_rslt_dt") = true
						}
					}
					formObj.sheet2.Redraw    = true;
					formObj.sheet2.RedrawSum = true;	
							
					if(sheetObjects[6].RowCount>0){
						chkVerifyConv = "Y";
						doActionIBSheet(sheetObjects[6],document.form,IBSEARCH_ASYNC09);
					}				
					calcGamount(1);
				}	
				break;
				
			case IBDELETE:        //삭제
				if(validateForm(sheetObj,formObj,sAction)){
					//삭제 의사 확인    
					if(!ComShowCodeConfirm("MNR00088")){return false;}
					ComOpenWait(true);   					
					saveType = "2";
					formObj.f_cmd.value = REMOVE;
					
					var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveXml(sXml); 
					
					// File Sequence Initialize
					formObj.file_seq.value = "";
					
					ComOpenWait(false); 
				}	
				break;

			case IBSEARCH_ASYNC08:        //AP calcel
				if(validateForm(sheetObj,formObj,sAction)){
					//calcel 의사 확인    
					if(!ComShowCodeConfirm("MNR00299")){return false;}
					saveType = "5";
					formObj.f_cmd.value = REMOVE;
					formObj.mnr_inv_sts_cd.value="HS";
					
					var sXml = sheetObj.GetSaveXml("EES_MNR_0041GS.do", FormQueryString(formObj));
					formObj.combo2.Code = formObj.mnr_inv_sts_cd.value;
					sheetObj.LoadSaveXml(sXml); 
				}	
				break;

			case IBSEARCH_ASYNC09:        //환율변경
				if(validateForm(sheetObj,formObj,sAction)){	
					if(formObj.conv_dp_prcs_knt.value!=""){	
						currPrcsKnt = formObj.conv_dp_prcs_knt.value
					}
					currPrcsSet(currPrcsKnt);
					
					var currRt = parseFloat(formObj.curr_rt.value.replace(/,/g,""));
					var orgAmt = 0;
					
					if(currPrcsKnt=="0"){
						//V.A.Tax,W.H.Tax,Invoice Total 는 원래 값에서 변경		
						orgAmt = parseFloat(formObj.vat_amt.value.replace(/,/g,""));
						var vatAmt = parseFloat(orgAmt / currRt).toFixed(0);	
						formObj.vat_amt.value = vatAmt;
						formObj.vat_amt.value = ComAddComma2(formObj.vat_amt.value, "#,###");
						
						orgAmt = parseFloat(formObj.whld_tax_amt.value.replace(/,/g,""));
						var whldTaxAmt = parseFloat(orgAmt / currRt).toFixed(0);
						formObj.whld_tax_amt.value = whldTaxAmt;
						formObj.whld_tax_amt.value = ComAddComma2(formObj.whld_tax_amt.value, "#,###");
						
						orgAmt = parseFloat(formObj.ttl_amt.value.replace(/,/g,""));
						var ttlAmt = parseFloat(orgAmt / currRt).toFixed(0);
						formObj.ttl_amt.value = ttlAmt;	
						formObj.ttl_amt.value = ComAddComma2(formObj.ttl_amt.value, "#,###");
						
						orgAmt = parseFloat(formObj.sls_tax_amt.value.replace(/,/g,""));
						var slsTaxAmt = parseFloat(orgAmt / currRt).toFixed(0);
						formObj.sls_tax_amt.value = slsTaxAmt;	
						formObj.sls_tax_amt.value = ComAddComma2(formObj.sls_tax_amt.value, "#,###");
					}else{
						//V.A.Tax,W.H.Tax,Invoice Total 는 원래 값에서 변경 				 	
						orgAmt = parseFloat(formObj.vat_amt.value.replace(/,/g,""));
						var vatAmt = parseFloat(orgAmt / currRt).toFixed(2);	
						formObj.vat_amt.value = vatAmt;	
						formObj.vat_amt.value = ComAddComma2(formObj.vat_amt.value, "#,###.00");
						
						orgAmt = parseFloat(formObj.whld_tax_amt.value.replace(/,/g,""));
						var whldTaxAmt = parseFloat(orgAmt / currRt).toFixed(2);
						formObj.whld_tax_amt.value = whldTaxAmt;	
						formObj.whld_tax_amt.value = ComAddComma2(formObj.whld_tax_amt.value, "#,###.00");
							
						orgAmt = parseFloat(formObj.ttl_amt.value.replace(/,/g,""));
						var ttlAmt = parseFloat(orgAmt / currRt).toFixed(2);
						formObj.ttl_amt.value = ttlAmt;	
						formObj.ttl_amt.value = ComAddComma2(formObj.ttl_amt.value, "#,###.00");
						
						orgAmt = parseFloat(formObj.sls_tax_amt.value.replace(/,/g,""));
						var slsTaxAmt = parseFloat(orgAmt / currRt).toFixed(2);
						formObj.sls_tax_amt.value = slsTaxAmt; 	 
						formObj.sls_tax_amt.value = ComAddComma2(formObj.sls_tax_amt.value, "#,###.00");
					}			
					
					sheetObjects[3].Redraw = false;
					sheetObjects[4].Redraw = false;
					sheetObjects[3].RedrawSum = false;
					sheetObjects[4].RedrawSum = false;

					for(var i = 2; i <= (sheetObjects[3].RowCount + 1); i++){ 
						orgAmt = parseFloat(sheetObjects[3].CellValue(i,"inv_amt"));
						var invAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[3].CellValue(i,"ida_cgst_amt"));
						var idaCgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[3].CellValue(i,"ida_sgst_amt"));
						var idaSgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[3].CellValue(i,"ida_igst_amt"));
						var idaIgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[3].CellValue(i,"ida_ugst_amt"));
						var idaUgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						sheetObjects[3].CellValue2(i,"inv_amt") = invAmt;
						sheetObjects[3].CellValue2(i,"inv_curr_cd") = formObj.target_curr_cd.Code;
						sheetObjects[3].CellValue2(i,"ida_cgst_amt") = idaCgstAmt;
						sheetObjects[3].CellValue2(i,"ida_sgst_amt") = idaSgstAmt;
						sheetObjects[3].CellValue2(i,"ida_igst_amt") = idaIgstAmt;
						sheetObjects[3].CellValue2(i,"ida_ugst_amt") = idaUgstAmt;
					}         
						      									
					for(var i = 2; i <= (sheetObjects[4].RowCount + 1); i++){ 
						orgAmt = parseFloat(sheetObjects[4].CellValue(i,PrefixSheet2+"inv_amt"));
						var invAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[4].CellValue(i,PrefixSheet2+"ida_cgst_amt"));
						var idaCgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[4].CellValue(i,PrefixSheet2+"ida_sgst_amt"));
						var idaSgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[4].CellValue(i,PrefixSheet2+"ida_igst_amt"));
						var idaIgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						orgAmt = parseFloat(sheetObjects[4].CellValue(i,PrefixSheet2+"ida_ugst_amt"));
						var idaUgstAmt = parseFloat(orgAmt / currRt).toFixed(2);
						
						sheetObjects[4].CellValue2(i,PrefixSheet2+"inv_amt") = invAmt;
						sheetObjects[4].CellValue2(i,PrefixSheet2+"inv_curr_cd") = formObj.target_curr_cd.Code;
						sheetObjects[4].CellValue2(i,PrefixSheet2+"ida_cgst_amt") = idaCgstAmt;
						sheetObjects[4].CellValue2(i,PrefixSheet2+"ida_sgst_amt") = idaSgstAmt;
						sheetObjects[4].CellValue2(i,PrefixSheet2+"ida_igst_amt") = idaIgstAmt;
						sheetObjects[4].CellValue2(i,PrefixSheet2+"ida_ugst_amt") = idaUgstAmt;
					}			 
					
					sheetObjects[3].Redraw = true;
					sheetObjects[4].Redraw = true;
					sheetObjects[3].RedrawSum = true;
					sheetObjects[4].RedrawSum = true;
																													
					formObj.curr_cd.value = formObj.target_curr_cd.Code;
					formObj.curr_rt.value =	1;	 					
															
					//INV AMT  ,G.Amount는  sheet SumValue를 이용해  다시 구한다. 								
					//2010.09.20  박명신  [CHM-201006139-01] bzcAmt 는 inv_amt +  slsTaxAmt 		
					calcGamount(); 	     	
										
				}		
                break;
					
			case IBCLEAR:      // 초기화
			
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				
				if(initLoader == 0){
					//공통콤보 정보를 가져온다.  
					var sCondition = new Array (	
						new Array("MnrGenCd","CD00026", "COMMON"),	//Repair Invoice Search Type  
						new Array("MnrGenCd","CD00027", "COMMON"),	//Repair Invoice Status Code
						new Array("MnrGenCd","CD00004", "COMMON"),	//System Verification Result Code 
						new Array("MdmOrganization","RPRINV",currOfcCd),	
						new Array("MdmCurrency","","COMMON")	
					);   
						
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
	
					//콤보 설정	
					for(var i = 0; i < comboList.length;i++){	
						if(comboList[i] != null){	
							//쉬트콤보별 초기화
							sheetComboText = "";	
							sheetComboCode = "";	
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Repair Invoice Search Type  
								if(i==0) {
									comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 1){      
										comboObjects[0].Code = tempText[0]; 
									}  								
								//Repair Invoice Status Code
								} else if(i==1){
									formObj.combo2.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										formObj.combo2.InsertItem(0, "NEW" ,"NEW");
										formObj.combo2.Code = "NEW"; 
										formObj.combo2.Enable = false;
									}  								
								}else if(i==3){
									formObj.wo_ofc_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								}else if(i==4){
									formObj.target_curr_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								}
							}
							//System Verification Result Code
							if(i==2) {
								sheetObjects[3].InitDataCombo(0, "mnr_vrfy_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
								sheetObjects[4].InitDataCombo(0, PrefixSheet2+"mnr_vrfy_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
							} 	
							if(i==3) {
								if(comboList[i].length == 1){  
									formObj.wo_ofc_cd.Code = tempText[0];
								}else{
									formObj.wo_ofc_cd.Code = currOfcCd;
								}			
							}
						}
					}
				}
				initLoader = 1;	
				
				setInvoiceListClear();
				setInvoiceInfomationClear();
				/**
				 * 2010.09.24 박명신 [CHM-201006139-01] CD00089 OFC 면 sale_tax를 입력 가능하게 
				 * 									    CD00090 둘다 입력가능  
				 *  								    나머지 오피스 vat_tax만 입력가능  <BR>	
				 */
				setInvoiceTaxOpt();  	   		
				sheetObjects[4].ColHidden(PrefixSheet2+"inv_no") = true;
				
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");	
				ComBtnDisable('btn_Return');
				sbcTax.style.display = "none";
				break;
				
			case IBRESET:      // 부분 초기화   Invoice List 를 제외한 초기화  			
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
									
				//setInvoiceListClear();
				setInvoiceInfomationClear();	
				/**
				 * 2010.09.24 박명신 [CHM-201006139-01] CD00089 OFC 면 sale_tax를 입력 가능하게 
				 * 									    CD00090 둘다 입력가능  
				 *  								    나머지 오피스 vat_tax만 입력가능  <BR>	
				 */
				setInvoiceTaxOpt();  	   		
				sheetObjects[4].ColHidden(PrefixSheet2+"inv_no") = true;
				
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");	
				ComBtnDisable('btn_Return');
				break;
        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) { //Retrive
			    var cboCode = formObj.combo1.Code;
				if(cboCode=="WI"){
					if(ComGetDaysBetween(formObj.t1_from_dt.value, formObj.t1_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","Req. Date","3Months")
						return false; 
					}
				}else if (cboCode=="MI"){
					if(ComGetDaysBetween(formObj.t2_from_dt.value, formObj.t2_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","W/O Date","3Months")
						return false; 
					}
					var arrWoNo = formObj.t2_mnr_ord_seq.value.split(",");
					if(arrWoNo!=""){
						for(i=0;i<arrWoNo.length;i++){
							if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
								ComShowCodeMessage("MNR00010","W/O No");
								return false;
							}
						}
					}			
				}else if(cboCode=="CO"){
					if(ComGetDaysBetween(formObj.t3_from_dt.value, formObj.t3_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","INV Date","3Months")
						return false; 
					}
				}
			}else if(sAction==IBSEARCH_ASYNC03) { //Work Order Detail조회
				//[CHM-201112736-01] Invoice List에서 1000건 이상 체크후 Detail Retrieve 시 W/O can not choice over 1000 메세지 출력.
				var updateCnt = sheetObjects[1].RowCount("U");
				if(updateCnt == 0 ){
					ComShowCodeMessage("MNR00038");
					return false; 
				}else if(updateCnt > 1000){
					ComShowCodeMessage("MNR00365");
					return false; 
				}
			
				var vend_seq="";
				for(var i = 1; i <= sheetObjects[1].RowCount; i++){  
					if(sheetObjects[1].CellValue(i,"sel") == 1){ 
						vend_seq = sheetObjects[1].CellValue(i,"vndr_seq");
						break;
					}
				}

				for(var i = 1; i <= sheetObjects[1].RowCount; i++){  
					if(sheetObjects[1].CellValue(i,"sel") == 1){ 
						if(vend_seq!=sheetObjects[1].CellValue(i,"vndr_seq")){
							ComShowCodeMessage("MNR00098",vend_seq,sheetObjects[1].CellValue(i,"vndr_seq"));
							return false;
						}
						if(formObj.ord_vndr_seq.value!="" && formObj.ord_vndr_seq.value!=sheetObjects[1].CellValue(i,"vndr_seq")){
							ComShowCodeMessage("MNR00098",formObj.ord_vndr_seq.value,sheetObjects[1].CellValue(i,"vndr_seq"));
							return false;
						}
					}
				}
			}else if(sAction==IBSEARCH_ASYNC04) { //Invoice Detail조회
				if (invInfoClearYN!='N'){  
					var selChk="";
					for(var i = 1; i <= sheetObjects[2].RowCount; i++){  
						if(sheetObjects[2].CellValue(i,"sel") == 1){ 
							selChk = "Y";
							break;
						}
					}   
					if(selChk==""){
						ComShowCodeMessage("MNR00038");
						return false; 
					}
				}	   					
			}else if(sAction==IBSAVE) {//save
				
				// No Rows On "Verified List Sheet"
				if(sheetObjects[4].RowCount<1){
					// msgs['MNR00281'] = 'Please carry out Verify first.';
					ComShowCodeMessage("MNR00281");
					return false;     
				}
				var	tot = 0;
				for(var i = 2; i <= (sheetObjects[4].RowCount + 1); i++){  
					tot +=  eval(sheetObjects[4].CellValue(i, PrefixSheet2+"inv_amt")); 
					sheetObjects[4].RowStatus(i)= "I";
					
				    if(sheetObjects[4].CellValue(i,PrefixSheet2+"mnr_wo_tp_cd") == "EST" && sheetObjects[4].CellValue(i,PrefixSheet2+"rpr_rslt_dt") == ""){
						ComShowCodeMessage("MNR00295");
						return false;
					}
				}
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00172","Invoice No ");
					ComSetFocus(formObj.inv_no); 
					return false;     
				}
				if(formObj.mnr_prnr_seq.value==""){
					ComShowCodeMessage("MNR00036","Pay S/P ");
					return false;     
				}				
				if(formObj.rcv_dt.value==""){
					ComShowCodeMessage("MNR00172","Receive DT ");
					ComSetFocus(formObj.rcv_dt); 
					return false;     
				}
				if(formObj.iss_dt.value==""){
					ComShowCodeMessage("MNR00172","Issue DT ");
					ComSetFocus(formObj.iss_dt); 
					return false;     
				}
				if(formObj.bzc_amt.value==""){
					ComShowCodeMessage("MNR00172","INV AMT ");
					ComSetFocus(formObj.bzc_amt); 
					return false;     
				}	
				if(formObj.sls_tax_amt.value==""){
					ComShowCodeMessage("MNR00172","SALES TAX AMT ");
					ComSetFocus(formObj.sls_tax_amt); 
					return false;      
				}	
				if(formObj.vat_amt.value==""){
					ComShowCodeMessage("MNR00172","V.A.Tax ");
					ComSetFocus(formObj.vat_amt); 
					return false;     
				}
				if(formObj.whld_tax_amt.value==""){
					ComShowCodeMessage("MNR00172","W.H.Tax ");
					ComSetFocus(formObj.whld_tax_amt); 
					return false;     
				}		
			
				var rcvDt = formObj.rcv_dt.value.replace(/-/g,""); 
				var issDt = formObj.iss_dt.value.replace(/-/g,"");
				var toDay = ComGetNowInfo().replace(/-/g,""); 
							
				if(issDt > toDay){		
					ComShowCodeMessage("MNR00233");
					return false;	
				}
				if(issDt > rcvDt){ 	
					ComShowCodeMessage("MNR00234");
					return false;
				}		
				if(rcvDt > toDay){       
					ComShowCodeMessage("MNR00235");
					return false;
				}
				
				//값 벨리데이션  	
				var ttlAmt = "0";	 
				var calAmt = "0";
				
				if( currPrcsKnt=="0" ){				
					var bzcAmt 	   = parseFloat(formObj.bzc_amt.value.replace(/,/g,"")).toFixed(0);
					var slsTaxAmt  = parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")).toFixed(0);
					var vatAmt 	   = parseFloat(formObj.vat_amt.value.replace(/,/g,"")).toFixed(0);
					var whldTaxAmt = parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")).toFixed(0);
								
					calAmt = parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)).toFixed(0); 
					ttlAmt = parseFloat(formObj.ttl_amt.value.replace(/,/g,"")).toFixed(0);
				}else{	 	       						
					var bzcAmt 	 = parseFloat(formObj.bzc_amt.value.replace(/,/g,"")).toFixed(2);
					var slsTaxAmt  = parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")).toFixed(2);
					var vatAmt 	 = parseFloat(formObj.vat_amt.value.replace(/,/g,"")).toFixed(2);
					var whldTaxAmt = parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")).toFixed(2);
										
					calAmt = parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)).toFixed(2);  
					ttlAmt = parseFloat(formObj.ttl_amt.value.replace(/,/g,"")).toFixed(2);    
				}   							 					
											
				if( calAmt != ttlAmt ){	 			 
					ComShowCodeMessage("MNR00280");				
					ComSetFocus(formObj.ttl_amt); 
					return false;     
				}
				
				// 10만불 - 3차 : Invoice Summary Tab이 Save시 필수 이도록
				if(sheetObjects[7].RowCount < 1) {
					//msgs['MNR00201'] = '{?msg1} is mandatory. Please enter {?msg1}.';
					ComShowCodeMessage("MNR00201", ComReplaceStr(tabObjects[0].TabText(2),"/","_"));
					tabObjects[0].SelectedIndex = 2;
					return false;
				}
				
			}
			else if(sAction==IBSEARCH_ASYNC05) {//Confirm
				if(formObj.eas_audit_desc.value == "Candidate EAC" && formObj.mnr_inv_rmk.value == ""){ // Candidate EAC일 경우 REMARK확인
					ComShowCodeMessage("MNR00420");
					formObj.mnr_inv_rmk.focus();
					return false;     
				}
				
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00172","Invoice Data ");
					return false;     
				}	
				if(sheetObjects[4].RowCount<1){
					ComShowCodeMessage("MNR00281");
					return false;     
				}	
													
				for(var i = 2; i <= (sheetObjects[4].RowCount + 1); i++){ 
				    sheetObjects[4].RowStatus(i) = "I"; 
				    if(sheetObjects[4].CellValue(i,PrefixSheet2+"mnr_wo_tp_cd") == "EST" && sheetObjects[4].CellValue(i,PrefixSheet2+"rpr_rslt_dt") == ""){
						ComShowCodeMessage("MNR00172","Result Date ");
						return false;
					}							
				}	
				
				if(formObj.mnr_prnr_seq.value==""){
					ComShowCodeMessage("MNR00036","Pay S/P ");
					return false;     
				}	
									
				var rcvDt = formObj.rcv_dt.value.replace(/-/g,""); 
				var issDt = formObj.iss_dt.value.replace(/-/g,"");
				var toDay = ComGetNowInfo().replace(/-/g,""); 
					
				if(issDt > toDay){		
					ComShowCodeMessage("MNR00233");
					return false;	
				}
				if(issDt > rcvDt){	
					ComShowCodeMessage("MNR00234");
					return false;
				}		
				if(rcvDt > toDay){      
					ComShowCodeMessage("MNR00235");
					return false;
				}
				
				//값 벨리데이션  	
				var ttlAmt = "0";	 
				var calAmt = "0"; 	 							
				if(currPrcsKnt=="0"){				
					var bzcAmt 	   = parseFloat(formObj.bzc_amt.value.replace(/,/g,"")).toFixed(0);
					var slsTaxAmt  = parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")).toFixed(0);
					var vatAmt 	   = parseFloat(formObj.vat_amt.value.replace(/,/g,"")).toFixed(0);
					var whldTaxAmt = parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")).toFixed(0);
								
					calAmt = parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)).toFixed(0); 
					ttlAmt = parseFloat(formObj.ttl_amt.value.replace(/,/g,"")).toFixed(0);
				}else{	 	       						
					var bzcAmt 	 = parseFloat(formObj.bzc_amt.value.replace(/,/g,"")).toFixed(2);
					var slsTaxAmt  = parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")).toFixed(2);
					var vatAmt 	 = parseFloat(formObj.vat_amt.value.replace(/,/g,"")).toFixed(2);
					var whldTaxAmt = parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")).toFixed(2);
								
					calAmt = parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)).toFixed(2);  
					ttlAmt = parseFloat(formObj.ttl_amt.value.replace(/,/g,"")).toFixed(2);    
				}						 					
															 																																
				if(calAmt != ttlAmt ){
					ComShowCodeMessage("MNR00280");				
					ComSetFocus(formObj.ttl_amt); 
					return false; 		    
				}
				
				// 10만불 - 3차 : Invoice Summary Tab이 Save시 필수 이도록
				if(sheetObjects[7].RowCount < 1) {
					//msgs['MNR00201'] = '{?msg1} is mandatory. Please enter {?msg1}.';
					ComShowCodeMessage("MNR00201", ComReplaceStr(tabObjects[0].TabText(2),"/","_"));
					tabObjects[0].SelectedIndex = 2;
					return false;
				}
				
			}
			else if(sAction==IBSEARCH_ASYNC06) {//Reject
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00172","Invoice Data ");
					return false;     
				}	
				
				var rcvDt = formObj.rcv_dt.value.replace(/-/g,""); 
				var issDt = formObj.iss_dt.value.replace(/-/g,"");
				var toDay = ComGetNowInfo().replace(/-/g,""); 
					
				if(issDt > toDay){  		
					ComShowCodeMessage("MNR00233");
					return false;	
				}
				if(issDt > rcvDt){	
					ComShowCodeMessage("MNR00234");
					return false;
				}		
				if(rcvDt > toDay){      
					ComShowCodeMessage("MNR00235");
					return false;
				}			
			}								
			else if(sAction==IBDELETE) {
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00089");
					return false;     
				}	
			}	
			else if(sAction==IBSEARCH_ASYNC07) {  //Stroe
				var chk=""
				for(var i = 2; i <= (sheetObjects[3].RowCount + 1); i++){  
					if(sheetObjects[3].CellValue(i,"Check")==1){
						chk = "Y"
					}
				}
				if (chk==""){
					ComShowCodeMessage("MNR00097");
					return false;
				}
				
				var isDupWo = false;	
				var DupWo = "";
					
				for(var i = 2; i <= (sheetObjects[3].RowCount + 1); i++){
					for(var j = 2; j <= (sheetObjects[4].RowCount + 1); j++){
						if(sheetObjects[3].CellValue(i,"Check") == 1){
							if(sheetObjects[3].CellValue(i,"wo_no") ==  sheetObjects[4].CellValue(j,PrefixSheet2+"wo_no") && sheetObjects[3].CellValue(i,"ord_dtl_seq")==  sheetObjects[4].CellValue(j,PrefixSheet2+"ord_dtl_seq")){
								isDupWo = true;
								if(DupWo == ""){
									DupWo = sheetObjects[3].CellValue(i,"wo_no");
								} else {		
									DupWo = DupWo + "," + sheetObjects[3].CellValue(i,"wo_no"); 
								}			
							}	
							if(sheetObjects[3].CellValue(i,"inv_curr_cd") !=  sheetObjects[4].CellValue(j,PrefixSheet2+"inv_curr_cd")){
								ComShowCodeMessage("MNR00025", "INV Curr ");
								return false;
							}							
						}
					}
				}
									
				if(isDupWo){						
					ComShowCodeMessage("MNR00178","Verified List ","W/O no",DupWo); 
					return false;
				}	
			}	
			else if(sAction==IBSEARCH_ASYNC09) {  //환율변경
				if(chkVerifyConv==""){

					if(sheetObjects[4].RowCount<1){
						ComShowCodeMessage("MNR00281");
						return false;     
					}	
					if(formObj.rcv_dt.value==""){
						ComShowCodeMessage("MNR00172","Receive DT ");
						ComSetFocus(formObj.rcv_dt); 
						return false;
					}

					if(formObj.iss_dt.value==""){
						ComShowCodeMessage("MNR00172","Issue DT ");
						ComSetFocus(formObj.iss_dt);
						return false;     
					}
									
					var rcvDt = formObj.rcv_dt.value.replace(/-/g,""); 
					var issDt = formObj.iss_dt.value.replace(/-/g,"");
					var toDay = ComGetNowInfo().replace(/-/g,""); 
						
					if(issDt > toDay){		
						ComShowCodeMessage("MNR00233");
						return false;	
					}
					if(issDt > rcvDt){	
						ComShowCodeMessage("MNR00234");
						return false;
					}		
					if(rcvDt > toDay){      
						ComShowCodeMessage("MNR00235");
						return false;	
					}		
					
					if(formObj.curr_rt.value =="" || formObj.curr_rt.value =="0" || formObj.curr_rt.value =="0.00"){
						ComShowCodeMessage("MNR00175", "EX.Rate");
						return false;
					}		

					for(var j = 2; j <= (sheetObjects[4].RowCount + 1); j++){
						if(sheetObjects[4].CellValue(j,PrefixSheet2+"inv_curr_cd")!=formObj.curr_cd.value){
							ComShowCodeMessage("MNR00025", "INV Curr ");
							return false;
						}							
					}
														
					if(sheetObjects[4].RowCount>0){
						if(!ComShowCodeConfirm("MNR00328",formObj.curr_cd.value,formObj.target_curr_cd.Code)){return false;}
					}
				}
			}	
        }
        return true;
    }


		/**
     * Select 선택시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function changeKind(nItem)
    {
        var objs = document.all.item("selectLayer");
		for (var i = 0; i < objs.length; i ++){
			if (i != nItem) {
				objs[i].style.display = "none";
			}else{
				objs[nItem].style.display = "Inline";
			}	
		}	
		var obj = document.all.item("selectComboLayer");
		if(nItem=="2"){
			obj.style.display = "none";
		}else{
			obj.style.display = "Inline";
		}

		
    }

	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getMnr_Multi(rowArray,ret_val) {
		
		var formObj = document.form;  
		var tempText = ""; 
		//초기화   
		eval("document.form." + ret_val + ".value = '';"); 
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ',';    
		}      
		//마지막에 ,를 없애기 위함      
		if (tempText != "")       
	        tempText = tempText.substr(0, tempText.length - 1);   	
		     
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
	}      
	
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;   
   			
		if ( aryPopupData.length > 0 ) {
			
			var idx = formObj.combo1.Index;
			if(idx=="0"){
				formObj.t1_vndr_seq.value = aryPopupData[0][2];
				formObj.t1_vndr_lgl_eng_nm.value  = aryPopupData[0][4];
			}else if(idx=="1"){
				formObj.t2_vndr_seq.value = aryPopupData[0][2];
				formObj.t2_vndr_lgl_eng_nm.value  = aryPopupData[0][4];
			}else{
				formObj.t3_vndr_seq.value = aryPopupData[0][2];
				formObj.t3_vndr_lgl_eng_nm.value  = aryPopupData[0][4];
			}
		}
	}	

	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */
	function setPopData_Pay_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;   
   			
		if ( aryPopupData.length > 0 ) {
			formObj.mnr_prnr_seq.value 		= aryPopupData[0][2];
			formObj.vndr_nm.value  			= aryPopupData[0][4];
			formObj.ida_gst_rgst_no.value  	= aryPopupData[0][11];
			formObj.ida_ste_cd.value  		= aryPopupData[0][12];
			formObj.ida_ste_nm.value  		= aryPopupData[0][13];
			
			//India Tax의 경우 Detail 항목의 GST Rate 및 Amount 세팅
			if( idaGstTax.style.display == "" ){
				var strIdaSacCd = "";
				var searchCnt = 0;
				
				//Verified List 그리드의 중복되지 않는 SAC Code List( SAC Code는 종류별로 한 개씩만 List화 ) 
				for( var idx = 2; idx < sheetObjects[4].RowCount + 2; idx++ ){
					searchCnt = strIdaSacCd.search(sheetObjects[4].CellValue(idx, PrefixSheet2+"ida_sac_cd"));
					if( searchCnt < 0 ){
						strIdaSacCd = strIdaSacCd + sheetObjects[4].CellValue(idx, PrefixSheet2+"ida_sac_cd") + "|";
					}
				}
				
				//SAC Code List String을 배열로 지정하여 각 SAC Code에 해당하는 Row를 2차 배열에 지정
				var arrSearchIdaSacCd = new Array();
				arrSearchIdaSacCd[0] = new Array();
				var arrFindRow = new Array();
				var arrIdaSacCd = strIdaSacCd.split("|");
				var idaGstRto = "";
				
				//SAC Code 종류만큼 반복문 수행
				for( var idx = 0; idx < arrIdaSacCd.length - 1; idx++ ){
					
					arrSearchIdaSacCd[idx] = new Array();	//2차 배열 선언
					idaGstRto = idaGstRto + MnrGetIdaGstRto(sheetObjects[0], formObj.agmt_ofc_cd.value, formObj.mnr_prnr_seq.value, arrIdaSacCd[idx]);
					
					//SAC Code 일치하는 Row를 찾기 위해 반복문 수행
					var findRow = 2;
					var jdx = 0;
					do{
						findRow = sheetObjects[4].FindText(PrefixSheet2+"ida_sac_cd", arrIdaSacCd[idx], findRow, true);
						if( findRow >= 0 ){
							arrSearchIdaSacCd[idx][jdx] = findRow;
							jdx++;
							findRow++;
						}
				    } while( findRow >= 0 );
					
					//SAC Code와 일치하는 모든 Row에 대해서 Rate 및 Amount 적용
					var idaGstRto = MnrGetIdaGstRto(sheetObjects[0], formObj.agmt_ofc_cd.value, formObj.mnr_prnr_seq.value, arrIdaSacCd[idx]);
					for( jdx = 0; jdx < arrSearchIdaSacCd[idx].length; jdx++ ){
						setIdaGstRto(idaGstRto, arrSearchIdaSacCd[idx][jdx]);
					}
					
				}
			}
		}
	}	
		
	/**  
	 * vndr_seq 존재여부 체크     
	 */  
	function vndr_seq_confirm(obj){
		var formObj = document.form;

		if(obj.value != "" && Number(obj.value)){ 
			//서비스 프로바이더 조회 
			var sCondition = new Array (new Array("MdmVendor",obj.value,"COMMON"))   
			                         
			//조회 값이 있다면 세팅
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
			if(comboList[0] != null){
				var tempText = comboList[0][0].split("|"); 
				if(obj.name=="t1_vndr_seq"){
					formObj.t1_vndr_lgl_eng_nm.value  = tempText[1];
				}else if(obj.name=="t2_vndr_seq"){
					formObj.t2_vndr_lgl_eng_nm.value  = tempText[1];
				}else if(obj.name=="t3_vndr_seq"){
					formObj.t3_vndr_lgl_eng_nm.value  = tempText[1];
				}else if(obj.name=="mnr_prnr_seq"){
					formObj.vndr_nm.value  = tempText[1];
				}
				
			} else {       
				ComShowCodeMessage("MNR00005", "Service Provider");              

				if(obj.name=="t1_vndr_seq"){
					ComSetObjValue(formObj.t1_vndr_lgl_eng_nm, ""); 
					ComSetObjValue(formObj.t1_vndr_seq, "");
					ComSetFocus(formObj.t1_vndr_seq);
				}else if(obj.name=="t2_vndr_seq"){
					ComSetObjValue(formObj.t2_vndr_lgl_eng_nm, ""); 
					ComSetObjValue(formObj.t2_vndr_seq, "");
					ComSetFocus(formObj.t2_vndr_seq);
				}else if(obj.name=="t3_vndr_seq"){
					ComSetObjValue(formObj.t3_vndr_lgl_eng_nm, ""); 
					ComSetObjValue(formObj.t3_vndr_seq, "");
					ComSetFocus(formObj.t3_vndr_seq);
				}else if(obj.name=="mnr_prnr_seq"){
					ComSetObjValue(formObj.vndr_nm, ""); 
					ComSetObjValue(formObj.mnr_prnr_seq, "");
					ComSetFocus(formObj.mnr_prnr_seq);
				}
			}   
		} else {
			ComShowCodeMessage("MNR00005", "Service Provider");
			
			if(obj.name=="t1_vndr_seq"){
				ComSetObjValue(formObj.t1_vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.t1_vndr_seq, "");
				ComSetFocus(formObj.t1_vndr_seq);
			}else if(obj.name=="t2_vndr_seq"){
				ComSetObjValue(formObj.t2_vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.t2_vndr_seq, "");
				ComSetFocus(formObj.t2_vndr_seq);
			}else if(obj.name=="t3_vndr_seq"){
				ComSetObjValue(formObj.t3_vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.t3_vndr_seq, "");
				ComSetFocus(formObj.t3_vndr_seq);
			}else if(obj.name=="mnr_prnr_seq"){
				ComSetObjValue(formObj.vndr_nm, ""); 
				ComSetObjValue(formObj.mnr_prnr_seq, "");
				ComSetFocus(formObj.mnr_prnr_seq);
			}
		}
	}

	function setInvoiceListValue() {
		
		var formObj = document.form;
		var kind = formObj.combo1.Code;
		
		if(kind=="WI"){
			ComSetObjValue(formObj.from_dt, formObj.t1_from_dt.value); 
			ComSetObjValue(formObj.to_dt, formObj.t1_to_dt.value); 
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t1_mnr_ord_seq.value); 
			ComSetObjValue(formObj.vndr_seq, formObj.t1_vndr_seq.value); 
		}else if(kind=="MI"){
			ComSetObjValue(formObj.from_dt, formObj.t2_from_dt.value); 
			ComSetObjValue(formObj.to_dt, formObj.t2_to_dt.value); 
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t2_mnr_ord_seq.value); 
			ComSetObjValue(formObj.vndr_seq, formObj.t2_vndr_seq.value); 
		}else if(kind=="CO"){
			ComSetObjValue(formObj.from_dt, formObj.t3_from_dt.value); 
			ComSetObjValue(formObj.to_dt, formObj.t3_to_dt.value); 
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t3_mnr_ord_seq.value); 
			ComSetObjValue(formObj.vndr_seq, formObj.t3_vndr_seq.value); 
		}
		ComSetObjValue(formObj.inv_sch_type_code, formObj.combo1.Code); 
	}	
	
	function setInvoiceListClear() {
		
		var formObj = document.form;
		
		formObj.t1_from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t1_to_dt.value = ComGetNowInfo();
		formObj.t2_from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t2_to_dt.value = ComGetNowInfo();
		formObj.t3_from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t3_to_dt.value = ComGetNowInfo();
				
		ComClearManyObjects(
		     formObj.t1_mnr_ord_seq
			,formObj.t2_mnr_ord_seq
			,formObj.t3_mnr_ord_seq
			,formObj.t1_vndr_seq
			,formObj.t1_vndr_lgl_eng_nm
			,formObj.t2_vndr_seq
			,formObj.t2_vndr_lgl_eng_nm
			,formObj.t3_vndr_seq
			,formObj.t3_vndr_lgl_eng_nm
			,formObj.eas_audit_desc)
				
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[7].RemoveAll();
		
		formObj.combo1.Code = "MI"; 
		formObj.wo_ofc_cd.Code = currOfcCd;
		
		saveEndYN="";
		saveType="";
		invInfoClearYN="";
	}
	
	function setInvoiceInfomationClear() {
		
		var formObj = document.form;

		ComClearManyObjects(
		     formObj.inv_no
			,formObj.rcv_dt
			,formObj.iss_dt
			,formObj.ord_vndr_seq
			,formObj.ord_vndr_seq_nm
			,formObj.mnr_prnr_seq
			,formObj.vndr_nm
			,formObj.agmt_ofc_cd
			,formObj.curr_cd
			,formObj.gen_pay_term_cd
			,formObj.mnr_inv_rmk
			,formObj.sls_tax_amt	
			,formObj.bzc_amt
			,formObj.vat_amt
			,formObj.ttl_amt
			,formObj.whld_tax_amt
			,formObj.curr_rt									
//			,formObj.env_chg_tax	
		);
			
		formObj.combo2.Code = "NEW";
		formObj.target_curr_cd.Code2 = "";		
		formObj.inv_status.value = "NEW"
		formObj.pay_inv_seq.value="";
		formObj.mnr_inv_sts_cd.value="";
		formObj.inv_rgst_no.value="";
		formObj.cnt_cd.value="";
		formObj.conv_dp_prcs_knt.value="";
		formObj.list_kind.value="";

		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		sheetObjects[5].RemoveAll();		
		sheetObjects[6].RemoveAll();
	}
	
	function calcGamount(init) {
		var formObj = document.form;
		if(currPrcsKnt=="0"){
			
			//India Tax 로직
			var idaGstAmt = 0;
			if(sbcTax.style.display == "" ){
				if(init == 1 ){// verify 버튼 클릭 시에만 SBC Tax = SML Amount * 0.005로 자동 계산
					formObj.env_chg_tax.value = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"inv_amt")) * 0.005; // SML Amount에 0.005를 곱하여 SBC Tax를 계산
					ComAddComma2(formObj.env_chg_tax.value, "#,###.00");
					formObj.env_chg_tax.value = parseFloat(formObj.env_chg_tax.value.replace(/,/g,"")).toFixed(2);
				}
			} else if( idaGstTax.style.display == "" ){
				var idaCgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_cgst_amt"));
				var idaSgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_sgst_amt"));
				var idaIgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_igst_amt"));
				var idaUgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_ugst_amt"));
				idaGstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_gst_amt"))
				
				formObj.ida_cgst_amt.value = idaCgstAmt;
				formObj.ida_sgst_amt.value = idaSgstAmt;
				formObj.ida_igst_amt.value = idaIgstAmt;
				formObj.ida_ugst_amt.value = idaUgstAmt;
				formObj.vat_amt.value = idaGstAmt;
				
				formObj.ida_cgst_amt.value = ComAddComma2(formObj.ida_cgst_amt.value, "#,###.00");
				formObj.ida_sgst_amt.value = ComAddComma2(formObj.ida_sgst_amt.value, "#,###.00");
				formObj.ida_igst_amt.value = ComAddComma2(formObj.ida_igst_amt.value, "#,###.00");
				formObj.ida_ugst_amt.value = ComAddComma2(formObj.ida_ugst_amt.value, "#,###.00");
			} else {
				formObj.env_chg_tax.value = "0.00"; // 활성화되지 않았을 경우 0으로 초기화
			}
											
			var envChgTax = formObj.env_chg_tax.value.replace(/,/g,"");
			formObj.env_chg_tax.value = ComAddComma2(formObj.env_chg_tax.value, "#,###")
			if(envChgTax=="")	envChgTax = "0";
			
			
			//General VAT Tax 로직
			if(formObj.vat_amt.value.length >= 15){	
				formObj.vat_amt.value = formObj.vat_amt.value.substr(0,15)
			}	
							
			vat = formObj.vat_amt.value.replace(/,/g,"");
			formObj.vat_amt.value = ComAddComma2(formObj.vat_amt.value, "#,###")
			if(vat=="") vat = "0";
									
			if(formObj.whld_tax_amt.value.length>=15){
				formObj.whld_tax_amt.value = formObj.whld_tax_amt.value.substr(0,15)
			}	
											
			wht = formObj.whld_tax_amt.value.replace(/,/g,"");
			formObj.whld_tax_amt.value = ComAddComma2(formObj.whld_tax_amt.value, "#,###")
			if(wht=="")	wht = "0";
			
			if(formObj.sls_tax_amt.value.length>=15){
				formObj.sls_tax_amt.value = formObj.sls_tax_amt.value.substr(0,15)
			}	
											
			sta = formObj.sls_tax_amt.value.replace(/,/g,"");
			formObj.sls_tax_amt.value = ComAddComma2(formObj.sls_tax_amt.value, "#,###")
			if(sta=="")	sta = "0"; 
			
			if(formObj.env_chg_tax.value.length>=15){
				formObj.env_chg_tax.value = formObj.env_chg_tax.value.substr(0,15)
			}	
			
			var amt = parseFloat(parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"inv_amt")) + parseFloat(sta) + parseFloat(envChgTax)).toFixed(0);
			formObj.bzc_amt.value = ComAddComma2(amt, "#,###");
			
			//추가 요건 미주를 제외한 오피스는 자동계산 한다. 		
			if(!isAmerican){
				formObj.ttl_amt.value = Math.round((parseFloat(amt) + parseFloat(vat) - parseFloat(wht))*1000)/1000;
				formObj.ttl_amt.value = ComAddComma2(formObj.ttl_amt.value, "#,###")
			}			
		
		}else{
			//India Tax 로직
			var idaGstAmt = 0;
			if( sbcTax.style.display == "" ){
				if(init == 1 ){ // verify 버튼 클릭 시에만 SBC Tax = SML Amount * 0.005로 자동 계산 
					formObj.env_chg_tax.value = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"inv_amt")) * 0.005; // SML Amount에 0.005를 곱하여 SBC Tax를 계산
					ComAddComma2(formObj.env_chg_tax.value, "#,###.00");
					formObj.env_chg_tax.value = parseFloat(formObj.env_chg_tax.value.replace(/,/g,"")).toFixed(2);	
				}
			} else if( idaGstTax.style.display == "" ){
				var idaCgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_cgst_amt"));
				var idaSgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_sgst_amt"));
				var idaIgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_igst_amt"));
				var idaUgstAmt = parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"ida_ugst_amt"));
				idaGstAmt = idaCgstAmt + idaSgstAmt + idaIgstAmt + idaUgstAmt;
				
				formObj.ida_cgst_amt.value = idaCgstAmt;
				formObj.ida_sgst_amt.value = idaSgstAmt;
				formObj.ida_igst_amt.value = idaIgstAmt;
				formObj.ida_ugst_amt.value = idaUgstAmt;
				formObj.vat_amt.value = idaGstAmt;
				
				formObj.ida_cgst_amt.value = ComAddComma2(formObj.ida_cgst_amt.value, "#,###.00");
				formObj.ida_sgst_amt.value = ComAddComma2(formObj.ida_sgst_amt.value, "#,###.00");
				formObj.ida_igst_amt.value = ComAddComma2(formObj.ida_igst_amt.value, "#,###.00");
				formObj.ida_ugst_amt.value = ComAddComma2(formObj.ida_ugst_amt.value, "#,###.00");
			} else {
				formObj.env_chg_tax.value = "0.00"; // 활성화되지 않았을 경우 0으로 초기화
				formObj.ida_cgst_amt.value = "0.00";
				formObj.ida_sgst_amt.value = "0.00";
				formObj.ida_igst_amt.value = "0.00";
				formObj.ida_ugst_amt.value = "0.00";
			}
			
			var envChgTax = formObj.env_chg_tax.value.replace(/,/g,"");
			formObj.env_chg_tax.value = ComAddComma2(formObj.env_chg_tax.value, "#,###.00")
			
			
			//General VAT Tax 로직
			val = formObj.vat_amt.value.split(".")  
			val1 = val[0];
			val2 = val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.vat_amt.value = val1.substr(0,15) + "." + val2
			}		
								
			vat = formObj.vat_amt.value.replace(/,/g,"");
			formObj.vat_amt.value = ComAddComma2(formObj.vat_amt.value, "#,###.00")
			if(vat=="") vat = "0.00";

			val = formObj.whld_tax_amt.value.split(".")
			val1 = val[0];
			val2 = val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.whld_tax_amt.value = val1.substr(0,15) + "." + val2
			}	
												
			wht = formObj.whld_tax_amt.value.replace(/,/g,"");
			formObj.whld_tax_amt.value = ComAddComma2(formObj.whld_tax_amt.value, "#,###.00")
			if(wht=="")	wht = "0.00";	
						
			val = formObj.sls_tax_amt.value.split(".")
			val1 = val[0];
			val2 = val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.sls_tax_amt.value = val1.substr(0,15) + "." + val2
			}
			
			sta = formObj.sls_tax_amt.value.replace(/,/g,""); 
			formObj.sls_tax_amt.value = ComAddComma2(formObj.sls_tax_amt.value, "#,###.00")
			if(sta=="")	sta = "0.00";		
			
			if(wht=="")	wht = "0.00";	
			
			val = formObj.env_chg_tax.value.split(".")
			val1 = val[0];
			val2 = val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.env_chg_tax.value = val1.substr(0,15) + "." + val2
			}	
			
			var amt = parseFloat(parseFloat(sheetObjects[4].SumValue(0,PrefixSheet2+"inv_amt")) + parseFloat(sta) + parseFloat(envChgTax)).toFixed(2);
			formObj.bzc_amt.value = ComAddComma2(amt, "#,###.00");
			
			//추가 요건 미주를 제외한 오피스는 자동계산 한다. 		
			if(!isAmerican){
				formObj.ttl_amt.value = Math.round((parseFloat(amt) + parseFloat(vat) - parseFloat(wht))*1000)/1000;
				formObj.ttl_amt.value = ComAddComma2(formObj.ttl_amt.value, "#,###.00");
			} 
		}	
	}	
	
	/**
	 * 2010.09.24 박명신 [CHM-201006139-01] CD00089 OFC 면 sale_tax를 입력 가능하게 
	 * 									    CD00090 둘다 입력가능  
	 *  								    나머지 오피스 vat_tax만 입력가능  <BR>	
	 */
	function setInvoiceTaxOpt() {						
		//미주 오피스를 조회 
		var sCondition = new Array (	
			//SALE TAX 만 오픈 
			new Array("MnrGenCd","CD00089", "COMMON"),
			//SALE TAX ,VAT 둘다 오픈 
			new Array("MnrGenCd","CD00090", "COMMON")		
		); 
												
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition)
		var isAmeOfc = false;		
													
		for(var j = 0; j < comboList[0].length;j++){ 	
			var tempText = comboList[0][j].split("|");
				
			if(currOfcCd == tempText[0]){	
				isAmeOfc = true;  
				isAmerican = true;		
				break;		 	 		
			}					
		}				
								
		//권한 설정 CD00089 OFC 면 sale_tax 입력가능  vat 입력 X
		var formObj = document.form;				
		if(isAmeOfc){
			MnrFormSetReadOnly(formObj,true,"vat_amt");						
			MnrFormSetReadOnly(formObj,false,"sls_tax_amt");									  		
		} else {													
			MnrFormSetReadOnly(formObj,false,"vat_amt");			 	
			MnrFormSetReadOnly(formObj,true,"sls_tax_amt");			 	
		}
						
		var isBothOfc = false;			
																			
		for(var j = 0; j < comboList[1].length;j++){ 	
			var tempText = comboList[1][j].split("|");
				
			if(currOfcCd == tempText[0]){		
				isBothOfc = true;  
				isAmerican = true; 		
				break;		 	 		
			}						
		}				
										
		//권한 설정 CD00090 OFC 면 sale_tax,vat 둘다 입력가능
		var formObj = document.form;								
		if(isBothOfc){								
			MnrFormSetReadOnly(formObj,false,"vat_amt");												
			MnrFormSetReadOnly(formObj,false,"sls_tax_amt");										
		}			 					
	}
	
	
	/**
	 * getEES_MNR_143 의 값을 받은 함수  
	 * @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE 	  	
	 * @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	 */
	
	function getEES_MNR_0143(rArray,ret_val){
    	var formObj = document.form;    
		var firstSelect = 0;    
		comboValue = ret_val[0];    

		if(formObj.ord_vndr_seq.value!="" && formObj.ord_vndr_seq.value!=ret_val[0]){
			ComShowCodeMessage("MNR00098",formObj.ord_vndr_seq.value,ret_val[0]);
			return false;
		}
								
		for(var i = 0;i <  rArray.length;i++){    
			var Row = sheetObjects[5].DataInsert(-1);  
			if(i == 0)  
				firstSelect = Row;    
			sheetObjects[5].CellValue2(Row,"wo_no") = rArray[i][0]; 
			sheetObjects[5].CellValue2(Row,"g_amnt") = rArray[i][2]; 	
 		}           

		formObj.f_cmd.value = SEARCH01;
		sheetObjects[3].RemoveAll();

		if(formObj.pay_inv_seq.value==""){
				ComSetObjValue(formObj.ord_vndr_seq, ret_val[0]);
				ComSetObjValue(formObj.ord_vndr_seq_nm, ret_val[1]);
				ComSetObjValue(formObj.mnr_prnr_seq, ret_val[0]);
				ComSetObjValue(formObj.vndr_nm, ret_val[1]);		
				ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
				india_tax_style();
				ComSetObjValue(formObj.gen_pay_term_cd, ret_val[2]);
				ComSetObjValue(formObj.curr_cd, ret_val[3]);
		        formObj.target_curr_cd.Code2=formObj.curr_cd.value
		}			

		if(formObj.target_curr_cd.Code != formObj.curr_cd.value){
			formObj.target_curr_cd.Code2 = formObj.curr_cd.value;
		}
								
		comboObjects[0].Code = "MI";
		ComSetObjValue(formObj.inv_sch_type_code, formObj.combo1.Code); 		
		tabObjects[0].SelectedIndex =0;	
				
		var sParam = ComGetSaveString(sheetObjects[5]);
		if (sParam == "") return;
		sParam += "&" + FormQueryString(formObj);
		
		var sXml = sheetObjects[3].GetSaveXml("EES_MNR_0041GS.do", sParam);
		
		//currency별  소수점 가져오기	
		currPrcsKnt = ComGetEtcData(sXml, "dp_prcs_knt");
		currPrcsSet(currPrcsKnt);
							
		sheetObjects[3].LoadSearchXml(sXml); 
		sheetObjects[5].RemoveAll();		
    }   
	
	
	function setRowBackColorChange(){
		var Row = form.sheet2.SelectRow;
		if(form.sheet2.CellValue(Row,  PrefixSheet2+"rpr_rslt_dt")==""){
			form.sheet2.RowBackColor(Row) = form.sheet2.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
		}else{
			form.sheet2.RowBackColor(Row) = form.sheet2.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB); 
		}	
	}
	
	function chkCurrXchRt(){
		var formObj = document.form;

		if(formObj.rcv_dt.value==""){
			ComShowCodeMessage("MNR00172","Receive DT ");
			ComSetFocus(formObj.rcv_dt); 
			return false;
		}
		
		var rcvDt = formObj.rcv_dt.value.replace(/-/g,""); 
		var toDay = ComGetNowInfo().replace(/-/g,"");       
		                          
		if(rcvDt > toDay){                  
			ComShowCodeMessage("MNR00235");
			formObj.rcv_dt.value = "";
			return false;
		}
		if(formObj.target_curr_cd.Code != formObj.curr_cd.value){	
		    var retVal="";
			 
			formObj.curr_rt.dataformat = "float";
			retVal = MnrGetCurrXchRt(sheetObjects[0],formObj.rcv_dt.value.replace(/-/g,"").substr(0,6),formObj.target_curr_cd.Code,formObj.curr_cd.value);
			retVal = retVal.split(",");
			formObj.curr_rt.value = retVal[0];
			formObj.conv_dp_prcs_knt.value = retVal[1];
			
			ComSetObjValue(formObj.curr_rt, ComAddComma2(formObj.curr_rt.value, "#,###.00"));
		}else{			
			formObj.curr_rt.value = "1";
		}
	}
	
	function chkIssDt(){
		var formObj = document.form;
		
		var issDt = formObj.iss_dt.value.replace(/-/g,"");
		var toDay = ComGetNowInfo().replace(/-/g,""); 
		 																
		if(issDt > toDay){ 
			ComShowCodeMessage("MNR00233");
			formObj.iss_dt.value = "";
			return false;		
		} 
	}	
	
    function MnrGetDataSearchXml(sheet_obj, sheet2_obj)  {

      var rowXml = "";
      var allXml = "<?xml version='1.0'  ?>\n<SHEET>\n  <DATA TOTAL='"+ (sheet2_obj.TotalRows+sheet_obj.TotalRows) +"'>\n";
	  var chk="";

      for (ir = 2; ir <= sheet_obj.LastRow - 1; ir++) {
        rowXml = "    <TR>";
		chk="";
        for (ic = 0; ic<= sheet_obj.LastCol; ic++) {
		
          //셀의 값을 변수에 저장한다.
          var sValue = String(sheet_obj.CellValue(ir,ic));
	
		  if(ic==1 && sValue=="1"){
			sValue = "0";
			chk="Y";
          }
          //특수문자(&, <, >)가 포함된 경우만 CDATA로 감싼다
          if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
            sValue = "<![CDATA[" + sValue + "]]>";
          }
          //XML을 만든다.
          rowXml += "<TD>" + sValue + "</TD>";
        }
        rowXml += "</TR>\n";
		
		if(chk=="Y"){
	 		allXml += rowXml;
		}	
      }

      for (ir = 2; ir <= sheet2_obj.LastRow - 1; ir++) {
        rowXml = "    <TR>";
        for (ic = 0; ic<= sheet2_obj.LastCol; ic++) {
		
          //셀의 값을 변수에 저장한다.
          var sValue = String(sheet2_obj.CellValue(ir,ic));
	
		  if(ic==1 && sValue=="1"){ 
			sValue = "0";
          }
          //특수문자(&, <, >)가 포함된 경우만 CDATA로 감싼다
          if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
            sValue = "<![CDATA[" + sValue + "]]>";
          }
          //XML을 만든다.	
          rowXml += "<TD>" + sValue + "</TD>";
        }
        rowXml += "</TR>\n";
	 	allXml += rowXml;
      }
	  
      allXml += "  </DATA>\n</SHEET>";

      return allXml;
    }	
	
	
	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	form); //- 변경될때.
	}   
		 
	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
 	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){    
	    ComClearSeparator(event.srcElement);
		
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {       
	    		case "ttl_amt":   
	    		case "vat_amt":    
	    		case "sls_tax_amt":    
	    		case "whld_tax_amt":    
	    		case "env_chg_tax":
					ComSetFocus(obj);    
					break; 
			}	
		}				  
	}	        
	
	function obj_change(){     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "t1_vndr_seq":   
	        		vndr_seq_confirm(formObj.t1_vndr_seq);  
				   	break;  
	    		case "t2_vndr_seq":   
	        		vndr_seq_confirm(formObj.t2_vndr_seq);  
				   	break;  
	    		case "t3_vndr_seq":   
	        		vndr_seq_confirm(formObj.t3_vndr_seq);  
				   	break;  	
	    		case "mnr_prnr_seq":   
	        		vndr_seq_confirm(formObj.mnr_prnr_seq);  
				   	break;  										
	    		case "bzc_amt":
	        		calcGamount();
				   	break; 
	    		case "vat_amt":   
	        		calcGamount();
				   	break;
	    		case "whld_tax_amt":   
	        		calcGamount();
				   	break;		
	    		case "sls_tax_amt":   
	        		calcGamount();
				   	break;			
	    		case "env_chg_tax":
		    		calcGamount();
				   	break;
	    		case "rcv_dt":   
					MnrChkDateValid(formObj.rcv_dt,"Receive DT");
					chkCurrXchRt();							
				   	break; 	
	    		case "iss_dt":       
					MnrChkDateValid(formObj.iss_dt,"Issue DT");
					var issDt = formObj.iss_dt.value.replace(/-/g,"");
					var toDay = ComGetNowInfo().replace(/-/g,""); 
																				
					if(issDt > toDay){ 
						ComShowCodeMessage("MNR00233");
						formObj.iss_dt.value = "";
						return false;		
					}
				   	break;	
			}       
	    } else {
			switch(obj.name) {	   	   
	    		case "t1_vndr_seq":		    
					ComSetObjValue(formObj.t1_vndr_lgl_eng_nm,"")
				   	break;   	
	    		case "t2_vndr_seq":    
					ComSetObjValue(formObj.t2_vndr_lgl_eng_nm,"")
				   	break;   	
	    		case "t3_vndr_seq": 	   
					ComSetObjValue(formObj.t3_vndr_lgl_eng_nm,"")
				   	break;   	
	    		case "mnr_prnr_seq": 	   
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;   						
			}  		
		} 
	}    
	
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
			              
	    switch(obj.dataformat) {  
	        case "ymd":   
	        case "int":    
	            if(obj.name=="bzc_amt" || obj.name=="vat_amt" || obj.name=="sls_tax_amt" || obj.name=="whld_tax_amt" || obj.name=="ttl_amt" || obj.name=="env_chg_tax" || obj.name=="ida_cgst_amt" || obj.name=="ida_sgst_amt" || obj.name=="ida_igst_amt" || obj.name=="ida_ugst_amt"){ 
					ComKeyOnlyNumber(obj, "-"); 
				} else {									
					ComKeyOnlyNumber(obj); 		
				}						   	
	            break;     
	        case "float":    
	            if(obj.name=="bzc_amt" || obj.name=="vat_amt" || obj.name=="sls_tax_amt" || obj.name=="whld_tax_amt" || obj.name=="ttl_amt" || obj.name=="env_chg_tax" || obj.name=="ida_cgst_amt" || obj.name=="ida_sgst_amt" || obj.name=="ida_igst_amt" || obj.name=="ida_ugst_amt"){ 
					ComKeyOnlyNumber(obj, "-."); 
				} else {		
					ComKeyOnlyNumber(obj, ".");
				}					   				
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup": 
	            if(obj.name=="t1_vndr_seq"){ 
					ComKeyOnlyNumber(obj);     
				}else if(obj.name=="t2_vndr_seq"){
					ComKeyOnlyNumber(obj);					
				}else if(obj.name=="t3_vndr_seq"){
					ComKeyOnlyNumber(obj);			
				}else if(obj.name=="mnr_prnr_seq"){
					ComKeyOnlyNumber(obj);								
				}else if(obj.name=="inv_no"){
					ComKeyOnlyAlphabet('uppernum','45');	
				}else if(obj.name=="t1_mnr_ord_seq"){
					ComKeyOnlyAlphabet('uppernum','44|45');	
				}else if(obj.name=="t2_mnr_ord_seq"){
					ComKeyOnlyAlphabet('uppernum','44');	
				}else if(obj.name=="t3_mnr_ord_seq"){
					ComKeyOnlyAlphabet('uppernum','44|45');	
				}else{
					ComKeyOnlyAlphabet('uppernum');	
				}  	
	        break;	  
	    }
	} 	
	
	/**
	 * IBSheet의 file upload 할 Row를 추가한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/
	function file_Insert(sheetObj){ 
		MnrWaitControl(true);
		
		uploadFileSeq = sheetObj.CellValue(1,"file_seq");
		
		if(uploadFileSeq == undefined){ 	 
			uploadFileSeq = "";	
		}
	
		var row =sheetObj.DataInsert(-1); 
		sheetFile_OnPopupClick(sheetObj,row,2);
	}
	
	/**
	 * IBSheet의 file upload 할 Row를 삭제한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/
	function file_Remove(sheetObj) {
		var delChkRow = sheetObj.FindCheckedRow("del_chk");
		var delChkRowCnt = delChkRow.split("|").length - 1;
		
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			if (delChkRowCnt == sheetObj.RowCount) {
				document.form.file_seq.value="0";
			}
			
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/  
	function sheetFile_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";

		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
	
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
	
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}
	
	/**
	 * 파일 선택하기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function sheetFile_OnPopupClick(sheetObj,Row,Col){
		var formObj = document.form;
		var upObj = uploadObjects[0];
		var prefix = "";
		
		var fileName = sheetObj.OpenFileDialog("파일선택");
		if(fileName.indexOf("\\") !=-1) { 
			sheetObj.CellValue2(Row, prefix+ "org_file_nm")= fileName;
			upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
			var ret = upObj.AddFile(fileName);
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, Col)= fileName;
			sheetObj.CellValue2(Row, prefix+ "file_dw")= '1';
			var file_seq = sheetObj.CellValue(Row, prefix+ "file_seq");
			var file_dtl_seq = sheetObj.CellValue(Row, prefix+ "file_dtl_seq");
			if(file_dtl_seq=="") file_dtl_seq=Row;
			var ibflag='U';
			if(file_seq == "" || uploadFileSeq != "") ibflag='I'; // 최초 저장시 및 저장된 파일 없을때 ibflag을 I로 Setting
			if(file_seq != "" && uploadFileSeq != "") ibflag='U';
	
			if(uploadFileSeq != "") {
				file_seq = uploadFileSeq;
			}
	
			var sParam = "f_cmd="+COMMAND01;
			sParam+= "&mnr_grp_tp_cd=INV";       // MNR Work Group Type Code
			sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
			sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
			sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경
	
			upObj.ExtendParam = sParam;
	
			var sXml = upObj.DoUpload(true);
	
			uploadFileSeq = ComGetEtcData(sXml,"seqValue");
			if(uploadFileSeq != "" && uploadFileSeq != undefined){
				var fileXml = SearchFileUpload(sheetObj,uploadFileSeq);
				sheetObj.LoadSearchXml(fileXml);
				var strFileSeq = formObj.file_seq.value;
	
				if(strFileSeq == "0" || strFileSeq == "") {
					formObj.file_seq.value=uploadFileSeq;
					MnrWaitControl(false);
				}else{
					MnrWaitControl(false);
				}
			}else{
				MnrWaitControl(false);
			}
	
		}else{
			sheetObj.RowDelete(sheetObj.SelectRow,false);
			MnrWaitControl(false);
		}
	}
	
	/**
	 * 해당 Invoice에 대한 Audit Detail 화면 연계
	 */
	function auditDetailPopup(){
		
		if(document.form.eas_audit_desc.value != ""){
	    	var sParam = Array();
	    	var formObject = document.form;
	    	
			sParam[0] = "s_inv_no="+formObject.inv_no.value;
			sParam[1] = "s_vndr_seq="+formObject.mnr_prnr_seq.value;
			sParam[2] = "s_subsys_no=MNR";
			sParam[3] = "s_vndr_nm="+encodeURIComponent(formObject.vndr_nm.value);
			sParam[4] = "s_mnr_inv_sts_cd="+formObject.mnr_inv_sts_cd.value;
			
	        ComOpenWindowCenter("ESD_EAS_0361.do?"+sParam.join("&"), "setEAC_IF", "1030", "535", true, "no");
			
			return;
		}
		
	}
	
	function currPrcsSet(currPrcsKnt){
		var formObj = document.form;
		
		if( currPrcsKnt=="0" ){
			sheetObjects[3].InitDataProperty(0, 18, dtAutoSumEx,  	70,		daRight,   	true,     "cost_amt", 					false,         	"",      dfInteger, 	0,     false,       false);
			sheetObjects[3].InitDataProperty(0, 20, dtAutoSumEx,  	70,		daRight,   	true,     "inv_amt", 					true,         	"",      dfInteger, 	0,     true,       true, 17);
			sheetObjects[4].InitDataProperty(0, 18, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"cost_amt", 		false,         	"",      dfInteger, 	0,     false,       false);
			sheetObjects[4].InitDataProperty(0, 20, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"inv_amt", 		true,         	"",      dfInteger, 	0,     true,       true, 17);
			
			formObj.sls_tax_amt.dataformat = "int";
			formObj.bzc_amt.dataformat = "int";
			formObj.vat_amt.dataformat = "int";
			formObj.ttl_amt.dataformat = "int";
			formObj.whld_tax_amt.dataformat = "int";
			formObj.env_chg_tax.dataformat = "int";
			formObj.ida_cgst_amt.dataformat = "int";
			formObj.ida_sgst_amt.dataformat = "int";
			formObj.ida_igst_amt.dataformat = "int";
			formObj.ida_ugst_amt.dataformat = "int";
			
			formObj.sls_tax_amt.maxLength = 15;
			formObj.bzc_amt.maxLength = 15;
			formObj.vat_amt.maxLength = 15;
			formObj.ttl_amt.maxLength = 15;
			formObj.whld_tax_amt.maxLength = 15;
			formObj.env_chg_tax.maxLength = 15;
			formObj.ida_cgst_amt.maxLength = 15;
			formObj.ida_sgst_amt.maxLength = 15;
			formObj.ida_igst_amt.maxLength = 15;
			formObj.ida_ugst_amt.maxLength = 15;
			
			formObj.sls_tax_amt.value="0";
			formObj.bzc_amt.value="0";
			formObj.vat_amt.value="0";
			formObj.ttl_amt.value="0";
			formObj.whld_tax_amt.value="0";
			formObj.env_chg_tax.value="0";
			formObj.ida_cgst_amt.value="0";
			formObj.ida_sgst_amt.value="0";
			formObj.ida_igst_amt.value="0";
			formObj.ida_ugst_amt.value="0";
		} else{
			sheetObjects[3].InitDataProperty(0, 18, dtAutoSumEx,  	70,		daRight,   	true,     "cost_amt", 					false,         	"",      dfFloat, 	2,     false,       false);
			sheetObjects[3].InitDataProperty(0, 20, dtAutoSumEx,  	70,		daRight,   	true,     "inv_amt", 					true,         	"",      dfFloat, 	2,     true,       true, 17);
			sheetObjects[4].InitDataProperty(0, 18, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"cost_amt", 		false,         	"",      dfFloat, 	2,     false,       false);
			sheetObjects[4].InitDataProperty(0, 20, dtAutoSumEx,  	70,		daRight,   	true,     PrefixSheet2+"inv_amt", 		true,         	"",      dfFloat, 	2,     true,       true, 17);
			
			formObj.sls_tax_amt.dataformat = "float";
			formObj.bzc_amt.dataformat = "float";
			formObj.vat_amt.dataformat = "float";
			formObj.ttl_amt.dataformat = "float";
			formObj.whld_tax_amt.dataformat = "float";
			formObj.env_chg_tax.dataformat = "float";
			formObj.ida_cgst_amt.dataformat = "float";
			formObj.ida_sgst_amt.dataformat = "float";
			formObj.ida_igst_amt.dataformat = "float";
			formObj.ida_ugst_amt.dataformat = "float";

			formObj.sls_tax_amt.maxLength = 18;	
			formObj.bzc_amt.maxLength = 18;	
			formObj.vat_amt.maxLength = 18;
			formObj.ttl_amt.maxLength = 18;
			formObj.whld_tax_amt.maxLength = 18;
			formObj.env_chg_tax.maxLength = 18;
			formObj.ida_cgst_amt.maxLength = 18;
			formObj.ida_sgst_amt.maxLength = 18;
			formObj.ida_igst_amt.maxLength = 18;
			formObj.ida_ugst_amt.maxLength = 18;
			
			formObj.sls_tax_amt.value="0.00";
			formObj.bzc_amt.value="0.00";
			formObj.vat_amt.value="0.00";
			formObj.ttl_amt.value="0.00";
			formObj.whld_tax_amt.value="0.00";
			formObj.env_chg_tax.value="0.00";
			formObj.ida_cgst_amt.value="0.00";
			formObj.ida_sgst_amt.value="0.00";
			formObj.ida_igst_amt.value="0.00";
			formObj.ida_ugst_amt.value="0.00";
		}
	}
	
	/**
	 * auditDetailPopup에 대한 callback
	 */
	function setEAC_IF(){
		return;
	}
