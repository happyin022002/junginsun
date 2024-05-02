/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0161.js 
*@FileTitle : Disposal Invoice Issue & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation  
* --------------------------------------------------------
* History
* 2012.03.06 신혜정 [선처리] [Row Del] 버튼 비활성 처리
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
* 2012.07.12 신혜정 [CHM-201218398] Invoice Cancel/Delete 시 본부/지점 담당자 처리 불가 기능 요청
                    1. 로그인office 코드가 본사 일때만, For canceled 항목 보이게. 나머지는 안보이게.
                    2. 'For~' 체크, 언체크시, 메세지 띄우고, 화면 전체 reloading.
                    3. 'For~' 체크시,
                       - KIND=Invoice Correction 셋팅. disabled.
                       - INV Date = null 처리. disabled.
                       - Buyer Type = ALL 처리.disabled.
                       - INV NO. 필수처리.(필수항목 색상)
                       - [Retrieve]조회시, ISS_OFC_CD = 'SELOPB' 해당 조건 제외 처리.
                       - Invoice Info 조회시, [Save]버튼 활성되는 경우, 비활성으로 셋팅.
                                        [Confirm]버튼 활성되는 경우, 비활성으로 셋팅.         
                    4. 'For~' 언체크시, 기존 화면 셋팅 원복.	
* 2013.02.15 조경완  [CHM-201322898-01] ALPS-MNR-Disposal-Invoice Issue 화면에서 중복 현상 발생 건에 대한 수정 요청 
* 2013.07.05 조경완  [CHM-201325280-01] ALPS MNR-Disposal-Invoice 이중 Interface 건 검토/Data 수정 및 로직 검토
* 2013.07.23  조경완  [CHM-201325777-01] ALPS-MNR-Disposal-Invoice Issuetl, Invoice Issue 및 Due Date 로직 변경 요청
* 2013.08.23 조경완 [CHM-201326149-01] ALPS - MNR-Disposal-Invoice Issue 화면 일부 수정 요청
* 2015.07.13 이율규 [CHM-201536623] REQUEST OFFICE가 PKGSC 한 적용되는 RD 추가              	                      	   
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
     * @class EES_MNR_0161 : EES_MNR_0161 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0161() {
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

var initLoader = 0;

//save=1, delete=2, confirm=3, Web Invoice Reject=4 
var saveType = "";

var invInfoClearYN = "";

var invNo=""

var PrefixSheet2 = "sheet2_";
var saveRet="";

var saveEndYN = "";
var currPrcsKnt ="0";

var invDtCheckFlg = true; 

var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
		 var sheetObject3 = sheetObjects[2];
		 var sheetObject4 = sheetObjects[3];
			
         /*******************************************************/
         var formObject = document.form;
         var del_check = false;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {
				case "btn_New_All":
					doActionIBSheet(sheetObjects[2],document.form,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[3],document.form,IBSAVE);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[3],document.form,IBDELETE);
					break;				
				case "btn_Confirm":
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC01);
					break;	
				case "btn_Cancel":
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC04);
					break;	
				case "btn_Preview":
					var rdParam = '/rv inv_no[' + formObject.input_inv_no.value + '] user_nm[' + self_usr_nm + ']';
					
					if(formObject.iss_ofc_cd.value.indexOf("PKGSC", 0) == 0){
						formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0185_PKG.mrd";
					} else{
						formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0185.mrd";
					}
					
					formObject.com_mrdArguments.value =	rdParam;	
					formObject.com_mrdBodyTitle.value = "Disposal Invoice";	
					var sFeatures = "resizable=yes,width=800,height=600"
					ComOpenRDPopup(sFeatures);
					break;	
					
				case "btn_Retrieve":
					var idx = formObject.combo_kind.Index;
					doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
					break;
				case "btn_New":
					setInvoiceListClear('N');
					break;
					
                case "btn_t1_DetailRetrieve":
					tabObjects[0].SelectedIndex =0;
					doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC02);
					break;

                case "btn_t2_DetailRetrieve":
					tabObjects[0].SelectedIndex =1;
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
					//chg_cal_inv_dt_OnChange();
					break;

                case "btn_Store":
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC05);
					break;

                case "btn_Del":
					if(beforetab=="0"){
						//[2011-05-19 KIM JONG OCK] Invoice Detail List 그리드에 Sold Date가 있는지 체크
						for(var i=1; i<=sheetObject3.RowCount; i++){
							if( sheetObject3.CellValue(i, "Check") == 1 && ComTrim(sheetObject3.CellValue(i, "disp_sold_dt")) != ""  ){						
								del_check = true;
							} 
						}
						
						if(del_check){
							ComShowCodeMessage("MNR00361");
							break;
						}


						MnrRowDelete(form.sheet1, "Check"); 

					}else{
						//[2011-05-19 KIM JONG OCK] Verified List 그리드에 Sold Date가 있는지 체크
						for(var i=1; i<=sheetObject4.RowCount; i++){
							if( sheetObject4.CellValue(i, PrefixSheet2+"Check") == 1 && ComTrim(sheetObject4.CellValue(i, PrefixSheet2+"disp_sold_dt")) != ""  ){
								del_check = true;
							} 
						}
						
						if(del_check){
							ComShowCodeMessage("MNR00361");
							break;
						}

						MnrRowDelete(form.sheet2, PrefixSheet2+"Check"); 
						//[2011-03-30 kjo] INV AMT 자동게산 추가 
						formObject.amt.value = sheetObjects[3].SumValue(0,"sheet2_inv_amt");
						chkCurrXchRt();						
					}
	                break;

				case "btn_DownExcel":
					if(beforetab=="0"){
						form.sheet1.SpeedDown2Excel(-1);
					}else{
						form.sheet2.SpeedDown2Excel(-1);
					}
					break;
								
				case "btn_inv_dt":
					var cal = new ComCalendar(); 	     	 
					cal.setEndFunction("chg_cal_inv_dt_OnChange");	
					cal.select(form.inv_dt, 'yyyy-MM-dd'); 
					break;	    

				case "btn_due_dt": 
					var cal = new ComCalendar();       
 					cal.select(form.inv_due_dt, 'yyyy-MM-dd'); 
					break;    
					
				case "btn_t1_calendar": 
					var cal = new ComCalendarFromTo();       
 					cal.select(form.t1_from_dt,  form.t1_to_dt,  'yyyy-MM-dd'); 
					break;    

				case "btn_t2_calendar":					
					if(formObject.for_cel_del.checked == false){ // For Cel/Del.체크시 버튼 클릭 안됨.
						var cal = new ComCalendarFromTo();       
	 					cal.select(form.t2_from_dt,  form.t2_to_dt,  'yyyy-MM-dd');	
					}					
 					break;   
					
		        case "btn_t1_req_multy":           
                    rep_Multiful_inquiry("t1_mnr_ord_seq");   
					break;
											
		        case "btn_t2_req_multy":           
                    rep_Multiful_inquiry("t2_mnr_ord_seq");   
					break;
											
				case "btn_t1_provider_popup":
				    ComOpenPopup('/hanjin/COM_ENS_041.do', 780, 520, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;					

				case "btn_t2_provider_popup":
				    ComOpenPopup('/hanjin/COM_ENS_041.do', 780, 520, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;		
					
				case "for_cel_del":
					// For Cel/Del. 체크시 이벤트
					doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC06);
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
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		// For Cel/Del. 초기화
		initForCelDel();
				 
    }

    /**
     * For Cel/Del. 셋팅 초기화
     */
    function initForCelDel(){
    	
		// 로그인 Office 가 본사 일때만 For Cel/Del 항목 보이게.
		if( strMnrOfficeLevel == "L1" ){
			document.getElementById("spnForCel").style.display = "block";			
		}else{
			document.getElementById("spnForCel").style.display = "none";
		}
		document.getElementById("for_cel_del").checked = false;
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
                }
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
  			        SetColAlign("left");        
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

					var HeadTitle = "|Sel|Seq.|Buyer Name|Buyer Type|Disposal No.|App Date|Q'ty|Currency|Amount"
								
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 13, 0, 0, true); 

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);	
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox, 	40,		daCenter,  	false,     "sel",	   				false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   false,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		120,	daLeft,  	false,     "mnr_prnr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    		80,		daCenter,  	false,     "mnr_prnr_knd_nm",		false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,  		120,	daLeft,   	false,     "disp_no",    			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daLeft,   	false,     "apro_dt",  				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daRight,   	false,     "disp_qty", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter, 	false,     "curr_cd", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,   		50,		daRight,  	false,     "part_amt",				false,          "",      dfFloat,      	2,     false,       false);


					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "bank_nm", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "bank_acct_no", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_bil_to_nm", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_sts_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "inv_due_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "eff_dt", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_rmk", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "buyer_cd", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "dp_prcs_knt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_prnr_cnt_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_prnr_seq", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_prnr_tp_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "chg_curr_cd", 			false,          "",      dfNone,    	0,     false,       false);
					
					CountPosition = 0;
					
					MultiSelection = true;	
					SelectionMode = smSelectionCol;      
					SelectHighLight = false;
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

					var HeadTitle = "|Sel|Seq.|Buyer Name|Buyer Type|Invoic No.|Inv Amt|V.A.T|W.H.T|G.Amount|G.AMT(VAT Only)|Status"
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);	

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtRadioCheck, 	40,		daCenter,  	false,     "sel",	   				false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   false,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "mnr_prnr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    		80,		daCenter,  	false,     "mnr_prnr_knd_nm",		false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,  		65,		daLeft,   	false,     "inv_no",    			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daRight,   	false,     "inv_amt", 				false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		50,		daRight,   	false,     "vat",  					false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		50,		daRight,   	false,     "wht", 	 				false,          "",      dfFloat,      	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight, 	false,     "ttl_amt", 				false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		100,	daRight, 	false,     "g_vat_curr_amt", 		false,          "",      dfNullFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daLeft, 	false,     "mnr_inv_sts_nm", 		false,          "",      dfNone,    	0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "disp_no", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "bank_nm", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "curr_cd", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "bank_acct_no", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_bil_to_nm", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_sts_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "inv_due_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "inv_dt", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_rmk", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "buyer_cd", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "iss_ofc_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "rcv_inv_seq", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_inv_ref_no", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "dp_prcs_knt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "mnr_prnr_tp_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "chg_curr_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "vat_xch_rt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "chg_xch_rt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daRight, 	false,     "vat_dp_prcs_knt", 		false,          "",      dfNone,    	0,     false,       false);
											
					CountPosition = 0;
					
					//SELECT 로우 배경색                  
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false;     
					MultiSelection = true;	
					SelectionMode = smSelectionCol;	     
					//선택시 하이라이트사용하지 않음            
					SelectHighLight = false;  
					
				}
				break;

			case "sheet1":
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
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel|seq.|Buyer|Disposal No.|Type|Release No|EQ No.|Qty|TP/SZ|Cur|Amount|Sold Yard|Sold Date|Remark(s)|System Verify Result";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   true,     "ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox, 	40,		daCenter,  	true,     "Check",					true,          "",      dfNone,      	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,	 		50,		daCenter,   true,     "Seq");
					InitDataProperty(0, cnt++ , dtData,    		90,		daLeft,  	true,     "mnr_prnr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,    		100,	daLeft,  	true,     "disp_no",				false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,  	true,     "disp_tp_nm",				false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,  	true,     "disp_rlse_no",  	  		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,   	true,     "eq_no",  				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight,    true,     "disp_qty",  				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter,   true,     "eq_tpsz_cd", 			false,          "",      dfNone,  	  	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		50,		daCenter,  	true,     "curr_cd", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,  	60,		daRight,  	true,     "inv_amt",				true,          	"",      dfFloat,      	2,     true,       	true);
					InitDataProperty(0, cnt++ , dtData,  		70,		daCenter, 	true,     "disp_yd_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,     true,     "disp_sold_dt",			false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		110,	daLeft,   	true,     "mnr_disp_dtl_rmk", 		false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,  		70,		daLeft ,    true,     "mnr_vrfy_tp_cd", 		false,          "",      dfNone, 	 	0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,  		70,		daLeft ,    true,     "rcv_inv_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_ord_ofc_cty_cd", 	false,      	"",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_ord_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "disp_dtl_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_wo_tp_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "rpr_rqst_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "rpr_rqst_ver_no", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "eq_tpsz_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					
					CountPosition = 0;

				}
				break;

			case "sheet2":
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
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel|seq.|Buyer|Disposal No.|Type|Release No.|EQ No.|Qty|TP/SZ|Cur|Amount|Sold Yard|Sold Date|Remark(s)|System Verify Result";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   true,     PrefixSheet2+"ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox, 	40,		daCenter,  	true,     PrefixSheet2+"Check",					true,          "",      dfNone,      	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,	 		50,		daCenter,   true,     PrefixSheet2+"Seq");
					InitDataProperty(0, cnt++ , dtData,    		90,		daLeft,  	true,     PrefixSheet2+"mnr_prnr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,    		100,	daLeft,  	true,     PrefixSheet2+"disp_no",				false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,  	true,     PrefixSheet2+"disp_tp_nm",			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,  	true,     PrefixSheet2+"disp_rlse_no",  	  	false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,   	true,     PrefixSheet2+"eq_no",  				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight,    true,     PrefixSheet2+"disp_qty",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter,   true,     PrefixSheet2+"eq_tpsz_cd", 			false,          "",      dfNone,  	  	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		50,		daCenter,  	true,     PrefixSheet2+"curr_cd", 				false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,  	60,		daRight,  	true,     PrefixSheet2+"inv_amt",				false,          "",      dfFloat,      	2,     true,       	true);
					InitDataProperty(0, cnt++ , dtData,  		70,		daCenter, 	true,     PrefixSheet2+"disp_yd_cd", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,     true,     PrefixSheet2+"disp_sold_dt",			false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		110,	daLeft,   	true,     PrefixSheet2+"mnr_disp_dtl_rmk", 		false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,  		70,		daLeft ,    true,     PrefixSheet2+"mnr_vrfy_tp_cd", 		false,          "",      dfNone, 	 	0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,  		70,		daLeft ,   true,      PrefixSheet2+"rcv_inv_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"mnr_ord_ofc_cty_cd", 	false,      	"",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"mnr_ord_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"disp_dtl_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"mnr_wo_tp_cd", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"rpr_rqst_seq", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"rpr_rqst_ver_no", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     PrefixSheet2+"eq_tpsz_cd", 			false,          "",      dfNone, 	 	0,     false,       false);

					CountPosition = 0;

				}
				break;
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
    * t2sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
    function t2sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount>0){
			//Delete가 아니고 저장후   재조회	
			if(saveType!="" && saveEndYN=="Y"){
				sheetObjects[1].CellValue2(1,"sel")="1";		
				tabObjects[0].SelectedIndex =1;				
				saveRet="Y";		
				doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);		
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
	    	for(i=sheetObj.LastRow - 1; i > 0 ; i--){
				if(sheetObj.CellValue(i,  "mnr_vrfy_tp_cd")!="SS"){
					sheetObj.CellEditable(i, "Check") = false;
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
				}
			}
		}
    }

   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount>0){
	    	for(i=sheetObj.LastRow - 1; i > 0 ; i--){
				if(sheetObj.CellValue(i,  PrefixSheet2+"mnr_vrfy_tp_cd")!="SS"){
					sheetObj.CellEditable(i, PrefixSheet2+"Check") = false;
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
				}
			}
		}
    }
	
	/**
    * sheet2에서 Change이벤트를 처리한다.
    * @param sheetObj
    * @return
    */
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		var formObj = document.form;
		
		if(sheetObj.ColSaveName(Col)  == PrefixSheet2 + "inv_amt"){ 	
			formObj.amt.value = sheetObj.SumValue(0,"sheet2_inv_amt");
			chkCurrXchRt();			            				
		}			  
	}	
			
	/**  
	 * Calendar INV DT를 위한 작업
	 */  
	function chg_cal_inv_dt_OnChange(){  
		var formObj = document.form;
						
		if(formObj.inv_dt.value != ""){
			var retVal = "";		
			retVal = MnrGetCurrXchRt2(sheetObjects[0],formObj.inv_dt.value.replace(/-/g,"").substr(0,6),formObj.curr_cd.value,formObj.chg_curr_cd.Code,"1");
			retVal = retVal.split(",");
			formObj.conv_dp_prcs_knt.value = retVal[1];
			formObj.chg_xch_rt.value = retVal[0];			 
																					
			//조회 해온 환률로 dp_prcs 변경		
			if(formObj.conv_dp_prcs_knt.value == "0"){	
				formObj.vat.dataformat = "int";		
				formObj.g_vat_curr_amt.dataformat = "int";
									
				formObj.vat.maxLength = 15;			
				formObj.g_vat_curr_amt.maxLength = 15;	
			} else {
				formObj.vat.dataformat = "float";
				formObj.g_vat_curr_amt.dataformat = "float";
								
				formObj.vat.maxLength = 18;										
				formObj.g_vat_curr_amt.maxLength = 18;		
			}		
							
			if(formObj.chg_curr_cd.Code != formObj.curr_cd.value){	
			    //Default 로 조회 해온 값으로 깔아줌
				MnrFormSetReadOnly(formObj,false,"chg_xch_rt");
			} else {										 	
				//EX.rate 1로 고정				
				formObj.chg_xch_rt.value = "1"; 	
				MnrFormSetReadOnly(formObj,true,"chg_xch_rt");	
											
				//amount "" 로 고정 
				formObj.g_vat_curr_amt.value = "";	 
			}									
			
			chkCurrXchRt();	
		}
	} 
	
   /**
    * 저장후에 로딩메시지
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
				ComBtnEnable('btn_Confirm')
				MnrBtnRename("btn_Confirm","btn_Cancel","Cancel");	
			}else if(saveType=="4"){
				ComShowCodeMessage("MNR00094"); 
			}else if(saveType=="5"){ //calcel
				ComShowCodeMessage("MNR00300"); 
				ComBtnDisable('btn_Save');					
				ComBtnDisable('btn_Delete');
				ComBtnDisable('btn_Confirm');
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");				 
			}		
			
			saveEndYN="Y";
			document.form.combo_kind.Code = "CO";
			var idx = document.form.combo_kind.Index;
			doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
		
		} else { 
	  		ComShowCodeMessage("MNR00008",ErrMsg);  
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
	 * combo_kind Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo_kind_OnChange(comboObj,Index_Code, Text){ 
		var kind = comboObj.Index;
		changeKind(kind);

		if(kind=="0" || kind=="1"){
			ComBtnEnable('btn_Store');
		}else{
			ComBtnDisable('btn_Store');
		}
	} 
	
	/**  
	 * chg_curr_cd Blur 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function chg_curr_cd_OnBlur(comboObj,Index_Code, Text){
		chg_curr_cd_OnChange(comboObj,Index_Code, Text);
	}
	/**  
	 * chg_curr_cd Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function chg_curr_cd_OnChange(comboObj,Index_Code, Text){
		var formObj = document.form;
		
		if(invDtCheckFlg){
			if(formObj.inv_dt.value==""){
				ComShowCodeMessage("MNR00172","Invoice DT ");
				comboObj.code2 = "";
				ComSetFocus(formObj.inv_dt); 
				return false;	
			}	
					
			if(formObj.inv_dt.value.replace(/-/g,"") > ComGetNowInfo().replace(/-/g,"")){
				ComShowCodeMessage("MNR00235");
				formObj.inv_dt.value = "";
				return false;
			}						
		}								
			
		var retVal = "";			
																					 		
		retVal = MnrGetCurrXchRt2(sheetObjects[0],formObj.inv_dt.value.replace(/-/g,"").substr(0,6),formObj.curr_cd.value,formObj.chg_curr_cd.Code,"1");
		retVal = retVal.split(",");
		formObj.conv_dp_prcs_knt.value = retVal[1];
		formObj.chg_xch_rt.value = retVal[0];
													
		//조회 해온 환률로 dp_prcs 변경		
		if(formObj.conv_dp_prcs_knt.value == "0"){	
			formObj.vat.dataformat = "int";		
			formObj.g_vat_curr_amt.dataformat = "int";
								
			formObj.vat.maxLength = 15;			
			formObj.g_vat_curr_amt.maxLength = 15;	
		} else {
			formObj.vat.dataformat = "float";
			formObj.g_vat_curr_amt.dataformat = "float";
							
			formObj.vat.maxLength = 18;										
			formObj.g_vat_curr_amt.maxLength = 18;		
		}		
						
		if(formObj.chg_curr_cd.Code != formObj.curr_cd.value){	
		    //Default 로 조회 해온 값으로 깔아줌
			MnrFormSetReadOnly(formObj,false,"chg_xch_rt");
		} else {										 	
			//EX.rate 1로 고정				
			formObj.chg_xch_rt.value = "1"; 	
			MnrFormSetReadOnly(formObj,true,"chg_xch_rt");	
										
			//amount "" 로 고정 
			formObj.g_vat_curr_amt.value = "";	 
		}									
																		
		if(comboObj.Code == "KRW"){  
			formObj.vat_xch_rt.value = "0.1"; 
		} else { 			
			formObj.vat_xch_rt.value = "0"; 
		}						 		
					
		chkCurrXchRt();	 
	} 
	
  	/**
     * Sheet관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          	case IBSEARCH:      //조회
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();

					setInvoiceListValue();
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("EES_MNR_0161GS.do",FormQueryString(formObj));
				}		
                break;
				
	 		case IBSEARCH_ASYNC02:  //Disposal Detail Retrieve
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll(); 
					setInvoiceInfomationClear();
					setInvoiceListValue();
					
					formObj.f_cmd.value = SEARCH01;
					var sParam = ComGetSaveString(sheetObjects[0]);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);
					if(invInfoClearYN!="N"){
						var sXml = sheetObj.GetSaveXml("EES_MNR_0161GS.do", sParam);
								
						for(var i = 1; i <= sheetObjects[0].RowCount; i++){  
							if(sheetObjects[0].CellValue(i,"sel") == 1){ 
							
								currPrcsKnt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"dp_prcs_knt");

								if(currPrcsKnt=="0"){
									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 				true,         	"",      dfInteger, 	0,     true,       true, 17);
									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 	true,         	"",      dfInteger, 	0,     true,       true, 17);
								}else{
									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 				true,         	"",      dfFloat, 	2,     true,       true, 17);
									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 	true,         	"",      dfFloat, 	2,     true,       true, 17);
								}	
													
								//회사 운영방침에 의거 AR상에서 JKTBA는 더이상 사용하지 않으며, 
              					//모든 AR 인보이스는 JKTSC로 변경하여 사용해야한다는 수입관리팀 요청이 있었음		
								if(ComTrimAll(currOfcCd) == 'JKTBA'){													
									 ComSetObjValue(formObj.iss_ofc_cd, 'JKTSC');	
								} else {			
									 ComSetObjValue(formObj.iss_ofc_cd, currOfcCd);
								}																		
																													   
								ComSetObjValue(formObj.curr_cd, sheetObjects[0].CellValue(i,"curr_cd"));
								ComSetObjValue(formObj.bank_nm, sheetObjects[0].CellValue(i,"bank_nm"));
								ComSetObjValue(formObj.bank_acct_no, sheetObjects[0].CellValue(i,"bank_acct_no"));
								ComSetObjValue(formObj.mnr_bil_to_nm, sheetObjects[0].CellValue(i,"mnr_bil_to_nm"));
								ComSetObjValue(formObj.buyer_cd, sheetObjects[0].CellValue(i,"buyer_cd"));
								ComSetObjValue(formObj.buyer_nm, sheetObjects[0].CellValue(i,"mnr_prnr_lgl_eng_nm"));
								ComSetObjValue(formObj.buyer_type, sheetObjects[0].CellValue(i,"mnr_prnr_knd_nm"));
								ComSetObjValue(formObj.mnr_prnr_tp_cd, sheetObjects[0].CellValue(i,"mnr_prnr_tp_cd"));
								
								ComSetObjValue(formObj.inv_dt, ComGetNowInfo("ymd"));
								ComSetObjValue(formObj.inv_due_dt, ComGetDateAdd(ComGetNowInfo("ymd"), "D", 15));
								
								if(currPrcsKnt=="0"){
									formObj.amt.dataformat = "int";
									formObj.wht.dataformat = "int";
									formObj.g_amt.dataformat = "int";

									formObj.amt.maxLength = 15;
									formObj.wht.maxLength = 15;
									formObj.g_amt.maxLength = 15;
								}else{		
									formObj.amt.dataformat = "float";
									formObj.wht.dataformat = "float";
									formObj.g_amt.dataformat = "float";
									
									formObj.amt.maxLength = 18;
									formObj.wht.maxLength = 18;
									formObj.g_amt.maxLength = 18;									
								}									
								break;
							}
						}
						sheetObj.LoadSearchXml(sXml); 
					}						
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save')
						ComBtnDisable('btn_Delete')
						ComBtnDisable('btn_Confirm')
					}else{
						ComBtnEnable('btn_Save')
						ComBtnEnable('btn_Delete')
						ComBtnEnable('btn_Confirm')
					}
					// INV OFFICE가 PKGSC인 경우에만 실행되는 메소드(Tax Rate 0.06, EX.Rate의 화폐단위 MYR)
					initialization_for_PKGSC();
				}		
	          	
                break;
				
	 		case IBSEARCH_ASYNC03:  //Invoice Detail Retrieve
          	    // Save 후 자동 처리되도록 수정
         		if(saveRet=="Y") {
					invInfoClearYN="Y"
					setInvoiceInfomationClear();	
				}else{
					if(formObj.rcv_inv_seq.value != ""){
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

					sheetObjects[2].RemoveAll();
					if(invInfoClearYN!="N"){
						sheetObjects[3].RemoveAll();
					}

					setInvoiceListValue();
					formObj.f_cmd.value = SEARCH01;
					
					var sParam = ComGetSaveString(sheetObjects[1]);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);
					
					if(invInfoClearYN!="N"){
						for(var i = 1; i <= sheetObjects[1].RowCount; i++){  
							if(sheetObjects[1].CellValue(i,"sel") == 1){ 
								document.form.combo_status.Code = sheetObjects[1].CellValue(i,"mnr_inv_sts_cd");
															
								ComSetObjValue(formObj.curr_cd, sheetObjects[1].CellValue(i,"curr_cd"));
								ComSetObjValue(formObj.bank_nm, sheetObjects[1].CellValue(i,"bank_nm"));
								ComSetObjValue(formObj.bank_acct_no, sheetObjects[1].CellValue(i,"bank_acct_no"));
								ComSetObjValue(formObj.mnr_bil_to_nm, sheetObjects[1].CellValue(i,"mnr_bil_to_nm"));
								ComSetObjValue(formObj.buyer_cd, sheetObjects[1].CellValue(i,"buyer_cd"));
								ComSetObjValue(formObj.buyer_nm, sheetObjects[1].CellValue(i,"mnr_prnr_lgl_eng_nm"));
								ComSetObjValue(formObj.buyer_type, sheetObjects[1].CellValue(i,"mnr_prnr_knd_nm"));
								ComSetObjValue(formObj.mnr_prnr_tp_cd, sheetObjects[1].CellValue(i,"mnr_prnr_tp_cd"));
																						
								ComSetObjValue(formObj.input_inv_no, sheetObjects[1].CellValue(i,"inv_no"));

								if(sheetObjects[1].CellValue(i,"mnr_inv_sts_cd")!= "HC"){
									ComSetObjValue(formObj.inv_dt, ComGetNowInfo("ymd"));
									ComSetObjValue(formObj.inv_due_dt, ComGetDateAdd(ComGetNowInfo("ymd"), "D", 15));
								}else{
									ComSetObjValue(formObj.inv_dt, sheetObjects[1].CellValue(i,"inv_dt"));
									ComSetObjValue(formObj.inv_due_dt, sheetObjects[1].CellValue(i,"inv_due_dt"));
								}
								ComSetObjValue(formObj.mnr_inv_rmk, sheetObjects[1].CellValue(i,"mnr_inv_rmk"));
								ComSetObjValue(formObj.vat_xch_rt, ComAddComma2(sheetObjects[1].CellValue(i,"vat_xch_rt"), "#,###.00"));
																																	
								//회사 운영방침에 의거 AR상에서 JKTBA는 더이상 사용하지 않으며, 
								//모든 AR 인보이스는 JKTSC로 변경하여 사용해야한다는 수입관리팀 요청이 있었음
								var tempStr = sheetObjects[1].CellValue(i,"iss_ofc_cd");  
								if(ComTrimAll(tempStr)  == 'JKTBA'){									
									 ComSetObjValue(formObj.iss_ofc_cd, 'JKTSC');					
								} else {																			
									 ComSetObjValue(formObj.iss_ofc_cd, sheetObjects[1].CellValue(i,"iss_ofc_cd"));
								}															
								ComSetObjValue(formObj.rcv_inv_seq, sheetObjects[1].CellValue(i,"rcv_inv_seq"));
								ComSetObjValue(formObj.mnr_inv_sts_cd, sheetObjects[1].CellValue(i,"mnr_inv_sts_cd"));
								ComSetObjValue(formObj.ref_no, sheetObjects[1].CellValue(i,"mnr_inv_ref_no"));
								
								currPrcsKnt = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"dp_prcs_knt");

								if(currPrcsKnt=="0"){
									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 			true,         	"",      dfInteger, 	0,     true,       true, 17);
									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 			true,         	"",      dfInteger, 	0,     true,       true, 17);

									formObj.amt.dataformat = "int";
									formObj.wht.dataformat = "int";
									formObj.g_amt.dataformat = "int";

									formObj.amt.maxLength = 15;
									formObj.wht.maxLength = 15;
									formObj.g_amt.maxLength = 15;
																		
									ComSetObjValue(formObj.amt, ComAddComma2(sheetObjects[1].CellValue(i,"inv_amt"), "#,###"));
									ComSetObjValue(formObj.wht, ComAddComma2(sheetObjects[1].CellValue(i,"wht"), "#,###"));							
									ComSetObjValue(formObj.g_amt, ComAddComma2(sheetObjects[1].CellValue(i,"ttl_amt"), "#,###"));
								} else {
									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 			true,         	"",      dfFloat, 	2,     true,       true, 17);
									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 			true,         	"",      dfFloat, 	2,     true,       true, 17);

									formObj.amt.dataformat = "float";
									formObj.wht.dataformat = "float";
									formObj.g_amt.dataformat = "float";

									formObj.amt.maxLength = 18;
									formObj.wht.maxLength = 18;
									formObj.g_amt.maxLength = 18;
																		
									ComSetObjValue(formObj.amt, ComAddComma2(sheetObjects[1].CellValue(i,"inv_amt"), "#,###.00"));
									ComSetObjValue(formObj.wht, ComAddComma2(sheetObjects[1].CellValue(i,"wht"), "#,###.00"));							
									ComSetObjValue(formObj.g_amt, ComAddComma2(sheetObjects[1].CellValue(i,"ttl_amt"), "#,###.00"));
								}	
									
								var vatCurrPrcsKnt = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"vat_dp_prcs_knt");
								formObj.conv_dp_prcs_knt.value = vatCurrPrcsKnt;				
											
								if(vatCurrPrcsKnt=="0"){	
									formObj.vat.dataformat = "int";
									formObj.vat.maxLength = 15;		
									ComSetObjValue(formObj.vat, ComAddComma2(sheetObjects[1].CellValue(i,"vat"), "#,###"));
										
									formObj.g_vat_curr_amt.dataformat = "int";
									formObj.g_vat_curr_amt.maxLength = 15;		
									if(sheetObjects[1].CellValue(i,"g_vat_curr_amt") != ""){
										ComSetObjValue(formObj.g_vat_curr_amt, ComAddComma2(sheetObjects[1].CellValue(i,"g_vat_curr_amt"), "#,###"));
									}
								} else {	
									formObj.vat.dataformat = "float";	
									formObj.vat.maxLength = 18;	
									ComSetObjValue(formObj.vat, ComAddComma2(sheetObjects[1].CellValue(i,"vat"), "#,###.00"));
										
									formObj.g_vat_curr_amt.dataformat = "float";				
									formObj.g_vat_curr_amt.maxLength = 18;	
									if(sheetObjects[1].CellValue(i,"g_vat_curr_amt") != ""){
										ComSetObjValue(formObj.g_vat_curr_amt, ComAddComma2(sheetObjects[1].CellValue(i,"g_vat_curr_amt"), "#,###.00"));
									}		
								}						
															
								//VAT CURR 관련 세팅			
								formObj.chg_curr_cd.Code2 = sheetObjects[1].CellValue(i,"chg_curr_cd");
								ComSetObjValue(formObj.chg_xch_rt, ComAddComma2(sheetObjects[1].CellValue(i,"chg_xch_rt"), "#,###.00"));
									
								if(formObj.chg_curr_cd.Code != formObj.curr_cd.value){	
									MnrFormSetReadOnly(formObj,false,"chg_xch_rt");
								} else {										 	
									MnrFormSetReadOnly(formObj,true,"chg_xch_rt");	
								}
								
								break;
							}	
						}				
						
						var sXml = sheetObj.GetSearchXml("EES_MNR_0161GS.do", sParam);
						sheetObj.LoadSearchXml(sXml); 					
					}				
								
					if(formObj.mnr_inv_sts_cd.value=="HC"){			
						if(formObj.for_cel_del.checked){	
							ComBtnDisable('btn_Save');
							ComBtnDisable('btn_Delete');
							ComBtnEnable('btn_Confirm');
							MnrBtnRename("btn_Confirm","btn_Cancel","Cancel");	
							ComBtnEnable('btn_Cancel');
														
						}else{
							ComBtnDisable('btn_Save');	
							ComBtnDisable('btn_Delete');
							ComBtnEnable('btn_Confirm');
							MnrBtnRename("btn_Confirm","btn_Cancel","Cancel");
							ComBtnDisable('btn_Cancel');	
						}
						
					}else{
						if(formObj.for_cel_del.checked){
							// For Cel/Del. 체크시, 
							ComBtnDisable('btn_Save');

							ComBtnEnable('btn_Confirm');
							ComBtnEnable('btn_Cancel');
							MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
							ComBtnDisable('btn_Confirm');

						}else{		
							ComBtnEnable('btn_Save');               

							ComBtnEnable('btn_Confirm');    
							ComBtnEnable('btn_Cancel');    
							MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
						}						
						ComBtnEnable('btn_Delete')
					}			 
				}						
                break;

			case IBSEARCH_ASYNC05:      //Store
	          	if(validateForm(sheetObj,formObj,sAction)){
					tabObjects[0].SelectedIndex =1;
					ComSheet2SheetCheck(form.sheet1, form.sheet2, "Check");
					form.sheet2.ColumnSort(PrefixSheet2+"Seq", "ASC");
					formObj.amt.value = form.sheet2.SumValue(0,"sheet2_inv_amt"); 
					invDtCheckFlg = false; 
					formObj.chg_curr_cd.Code = sheetObjects[0].CellValue(1,"chg_curr_cd");	
					invDtCheckFlg = true;	
					chkCurrXchRt();
					
					// INV OFFICE가 PKGSC인 경우에만 실행되는 메소드(Tax Rate 0.06, EX.Rate의 화폐단위 MYR)
					initialization_for_PKGSC();
				}	
				break;

	 		case IBSAVE:        // Save
	          	if(validateForm(sheetObj,formObj,sAction)){
					saveType = "1";					
					formObj.mnr_inv_sts_cd.value="HS";
					formObj.mnr_grp_tp_cd.value="DSP";
					//formObj.f_cmd.value = MULTI;
					formObj.f_cmd.value = MULTI02; // SAVE 로직에 존재하는 AP/AR 로직을 제거후 사용(2014-10-10, 신용찬)
					
					var sParam = ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);

					var sXml = sheetObj.GetSaveXml("EES_MNR_0161GS.do", sParam);
					
					if(MnrComGetErrMsg(sXml) == null){
						var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
						if(State == "S"){
							ComSetObjValue(formObj.rcv_inv_seq, ComGetEtcData(sXml, "rcv_inv_seq"));  
							ComSetObjValue(formObj.input_inv_no, ComGetEtcData(sXml, "input_inv_no"));  
							 			
							document.form.combo_status.Code = formObj.mnr_inv_sts_cd.value;								
						}	
					}				
					sheetObj.LoadSaveXml(sXml); 
				}	
                break;

	 		case IBSEARCH_ASYNC01:        //Confirm
	          	if(validateForm(sheetObj,formObj,sAction)){
					//Confirm 의사 확인     
					if(!ComShowCodeConfirm("MNR00197")){return false;}  
					
					// invoice no 체크 로직(Confirm 여부 체크) 
					formObj.mnr_inv_sts_cd.value="HC"; //Confirm(HC), Cancel(HS)
					formObj.f_cmd.value = COMMAND01;
					
					var sParam = ComGetSaveString(sheetObjects[3], true, true);
					if(sParam == "") return;
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PrefixSheet2);
					
					var sXml = sheetObjects[3].GetSaveXml("EES_MNR_0161GS.do", sParam);
					
					if(MnrComGetErrMsg(sXml) == null){
						var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					
						if(state == "S"){
							if(ComGetEtcData(sXml, "gubun") == "X"){
								ComShowCodeMessage("MNR00370"); // 'Already Invoice Confirmed'
								return false;
							}else if(ComGetEtcData(sXml, "gubun") == "N"){
								ComShowCodeMessage("MNR00390"); // 'Already Invoice Confirmed'
								return false;
							}
						}
					}					
					
					saveType = "3";
					formObj.mnr_inv_sts_cd.value="HC"; //Confirm,Cancel
					formObj.mnr_grp_tp_cd.value="DSP";
					formObj.f_cmd.value = MULTI;  // SAVE + AR/AP 처리
					
					var sParam = ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj)+"&"+ ComGetPrefixParam(PrefixSheet2);

					var sXml = sheetObj.GetSaveXml("EES_MNR_0161GS.do", sParam);  //// SAVE + AR/AP 처리
					var errStr = MnrComGetErrMsg(sXml);	
					if(errStr == null){
						var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
						if(State == "S"){
							ComSetObjValue(formObj.rcv_inv_seq, ComGetEtcData(sXml, "rcv_inv_seq"));  
							ComSetObjValue(formObj.input_inv_no, ComGetEtcData(sXml, "input_inv_no"));  
							document.form.combo_status.Code = formObj.mnr_inv_sts_cd.value;
						}		
						sheetObj.LoadSaveXml(sXml);
					}else if(errStr.indexOf("faSendBasic")!= -1){
						ComShowCodeMessage("MNR00386");
						saveType = "6";
						sheet2_OnSaveEnd(sheetObj, "");
					}else{
						ComShowCodeMessage("MNR00387");
						saveType = "6";
						sheet2_OnSaveEnd(sheetObj, "");
					}
				}		 		
                break;

	 		case IBSEARCH_ASYNC04:        //Cancel
	          	if(validateForm(sheetObj,formObj,sAction)){
					//Confirm 의사 확인      
					if(!ComShowCodeConfirm("MNR00299")){return false;} 
					
					// invoice no 체크 로직(Cancel 여부 체크) 
					formObj.mnr_inv_sts_cd.value="HS"; //Confirm(HC), Cancel(HS)
					formObj.f_cmd.value = COMMAND01;
					
					var sParam = ComGetSaveString(sheetObjects[3], true, true);
					if(sParam == "") return;
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PrefixSheet2);
					
					var sXml = sheetObjects[3].GetSaveXml("EES_MNR_0161GS.do", sParam);
					
					if(MnrComGetErrMsg(sXml) == null){
						var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
						if(state == "S"){
							if(ComGetEtcData(sXml, "gubun") == "X"){
								ComShowCodeMessage("MNR00371"); // 'Already Invoice Canceled'
								return false;
							}
						}
					}						
					
					saveType = "5";
					formObj.mnr_inv_sts_cd.value="HC";  //Confirm,Cancel
					formObj.cancel_yn.value="Y";
					formObj.f_cmd.value = MULTI;
					
					var sParam = ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj)+"&"+ ComGetPrefixParam(PrefixSheet2);

					var sXml = sheetObj.GetSaveXml("EES_MNR_0161GS.do", sParam);
					var errStr = MnrComGetErrMsg(sXml);	
					if(MnrComGetErrMsg(sXml) == null){
						var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
						if(State == "S"){
							ComSetObjValue(formObj.rcv_inv_seq, ComGetEtcData(sXml, "rcv_inv_seq"));  
							ComSetObjValue(formObj.input_inv_no, ComGetEtcData(sXml, "input_inv_no"));  
						
							document.form.combo_status.Code = "HS";	
						}	
						sheetObj.LoadSaveXml(sXml); 
					}else if(errStr.indexOf("faSendBasic")!= -1){
						ComShowCodeMessage("MNR00386");
						saveType = "6";
						sheet2_OnSaveEnd(sheetObj, "");
					}else{
						ComShowCodeMessage("MNR00387");
						saveType = "6";
						sheet2_OnSaveEnd(sheetObj, "");
					}	
					
					
				}		 		
                break;

	 		case IBDELETE:        //삭제
	          	if(validateForm(sheetObj,formObj,sAction)){
					//삭제 의사 확인     
					if(!ComShowCodeConfirm("MNR00088")){return false;}  
					saveType = "2";
					formObj.f_cmd.value = REMOVE;
					
					var sParam = ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);					

					var sXml = sheetObj.GetSaveXml("EES_MNR_0161GS.do", sParam);
					sheetObj.LoadSaveXml(sXml); 
				}	
                break;
				
			case IBCLEAR:      // 초기화
			
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				
				if(initLoader == 0){
					
					//Office Level 조회  및 전역변수(strMnrOfficeLevel)에 세팅
					MnrOfficeLevel(currOfcCd,rhqOfcCd);
		
					//공통콤보 정보를 가져온다.  
					var sCondition = new Array (
						new Array("MnrGenCd","CD00046", "COMMON"),	//Disposal Invoice Search Type 
						new Array("MnrGenCd","CD00027", "COMMON"),	//Repair Invoice Status Code
						new Array("MnrGenCd","CD00004", "COMMON"),	//System Verification Result Code 
						new Array("MdmCurrency","","COMMON"),
						new Array("MnrGenCd","CD00034", "COMMON")
					);   
					
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
	
					//콤보 설정(Eq Kind,Agreement Office) 
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Disposal Invoice Search Type 
								if(i==0) {
									document.form.combo_kind.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 1){      
										document.form.combo_kind.Code = tempText[0]; 
									}  								
								//Repair Invoice Status Code
								} else if(i==1){
									document.form.combo_status.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										document.form.combo_status.InsertItem(0, "NEW" ,"NEW");
										document.form.combo_status.Code = "NEW"; 
										document.form.combo_status.Enable = false;
									}  								
								}else if(i==3){
									formObj.chg_curr_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								}else if(i==4){
									formObj.combo_buyer_type.InsertItem(j, tempText[1] ,tempText[0]);
								}							
							}
							//System Verification Result Code
							if(i==2) {
								sheetObjects[2].InitDataCombo(0, "mnr_vrfy_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
								sheetObjects[3].InitDataCombo(0, PrefixSheet2+"mnr_vrfy_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
							} 					
						}
					}
					formObj.combo_buyer_type.InsertItem(0, "ALL", "ALL"); // Buyer Type 'ALL' 추가	
				}

				if(strMnrOfficeLevel=="L1"){
					formObj.combo_buyer_type.Code2 = "G";
				}else if(strMnrOfficeLevel=="L2"){
					formObj.combo_buyer_type.Code2 = "R";
				}else{
					formObj.combo_buyer_type.Code2 = "L";
				}
				document.form.combo_buyer_type.Enable = false;
					
				initLoader = 1;	
				
				setInvoiceListClear('N');
				setInvoiceInfomationClear();

				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);					
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
				
				ComBtnDisable('btn_Del'); // [Row Del] 버튼 비활성 처리
				break;
				
	 		case IBSEARCH_ASYNC06:        // For Cel/Del.
	          	if(validateForm(sheetObj,formObj,sAction)){
	          		setInvoiceListClear('C');
				}	
                break;
                
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) { //Retrive
			    var cboCode = formObj.combo_kind.Code;
				/*
				if(cboCode=="MI"){
					if(ComGetDaysBetween(formObj.t1_from_dt.value, formObj.t1_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","App Date","3Months")
						return false; 
					}
				}else if (cboCode=="CO"){
					if(ComGetDaysBetween(formObj.t2_from_dt.value, formObj.t2_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","INV Date","3Months")
						return false; 
					}
				} 
				*/
			    // For Cel/Del. 체크시. INV No. 필수 처리
			    if(formObj.for_cel_del.checked){
			    	if(formObj.t2_mnr_ord_seq.value == ""){
						ComShowCodeMessage("MNR00375","Service Provider ");	
						formObj.t2_mnr_ord_seq.focus();    
						return false;  
			    	}
			    }
			    			    
			}else if(sAction==IBSEARCH_ASYNC02) { //Disposal Detail Retrieve
				var buyerCd="";
				var selChk="";
				var currCd = "";
				
				for(var i = 1; i <= sheetObjects[0].RowCount; i++){  
					if(sheetObjects[0].CellValue(i,"sel") == 1){ 
						selChk = "Y";
						buyerCd = sheetObjects[0].CellValue(i,"buyer_cd");
						currCd  = sheetObjects[0].CellValue(i,"curr_cd");	
						break;	
					}
				}
						
				if(selChk==""){
					ComShowCodeMessage("MNR00038");
					return false; 
				}					
				for(var i = 1; i <= sheetObjects[0].RowCount; i++){  
					if(sheetObjects[0].CellValue(i,"sel") == 1){ 
						if(buyerCd!=sheetObjects[0].CellValue(i,"buyer_cd")){
							ComShowCodeMessage("MNR00098",buyerCd,sheetObjects[0].CellValue(i,"buyer_cd"));
							return false;
						}
						if(formObj.buyer_cd.value!="" && formObj.buyer_cd.value!=sheetObjects[0].CellValue(i,"buyer_cd")){
							ComShowCodeMessage("MNR00098",formObj.buyer_cd.value,sheetObjects[0].CellValue(i,"buyer_cd"));
							return false;
						}
						if(currCd!=sheetObjects[0].CellValue(i,"curr_cd")){
							ComShowCodeMessage("MNR00098",currCd,sheetObjects[0].CellValue(i,"curr_cd"));
							return false;			
						}
						if(formObj.curr_cd.value!="" && formObj.curr_cd.value!=sheetObjects[0].CellValue(i,"curr_cd")){
							ComShowCodeMessage("MNR00098",formObj.curr_cd.value,sheetObjects[0].CellValue(i,"curr_cd"));
							return false;	
						}	
					}
				}
			}else if(sAction==IBSEARCH_ASYNC03) { //Invoice Detail Retrieve
				var selChk="";
				for(var i = 1; i <= sheetObjects[1].RowCount; i++){  
					if(sheetObjects[1].CellValue(i,"sel") == 1){ 
						selChk = "Y";
						break;
					}
				}
				if(selChk==""){
					ComShowCodeMessage("MNR00038");
					return false; 
				}	
			}else if(sAction==IBSEARCH_ASYNC05) {  //Store
				var chk=""
				for(var i = 1; i <= (sheetObjects[2].RowCount + 1); i++){  
				    if(sheetObjects[2].CellValue(i,"inv_amt") <= 0 && sheetObjects[2].CellValue(i,"Check")==1){
						ComShowCodeMessage("MNR00175","Invoice Amount ");
						return false;
					}	
					
					if(sheetObjects[2].CellValue(i,"Check")==1){
						chk = "Y"
					}
				}
				if (chk==""){
					ComShowCodeMessage("MNR00097");
					return false;
				} 
			}else if(sAction==IBSAVE) {

				if(sheetObjects[3].RowCount<1){
					ComShowCodeMessage("MNR00281");
					return false;     
				}
				var	tot = 0;				
				for(var i = 1; i <= (sheetObjects[3].RowCount); i++){  
				    tot +=  eval(sheetObjects[3].CellValue(i, PrefixSheet2+"inv_amt")); 
				   if(sheetObjects[3].CellValue(i,PrefixSheet2+"inv_amt") <= 0){
						ComShowCodeMessage("MNR00175","Invoice Amount ");
						return false;
					}	
				}

				if(tot < 1){
					ComShowCodeMessage("MNR00175","Invoice Amount ");
					return false;
				}	
								
				if(formObj.inv_dt.value==""){
					ComShowCodeMessage("MNR00172","Invoice DT ");
					ComSetFocus(formObj.inv_dt); 
					return false;     
				}
				if(formObj.inv_due_dt.value==""){
					ComShowCodeMessage("MNR00172","Due DT ");
					ComSetFocus(formObj.inv_due_dt); 
					return false;     
				}
				if(formObj.amt.value==""){
					ComShowCodeMessage("MNR00172","INV AMT ");
					ComSetFocus(formObj.amt); 
					return false;     
				}
				if(formObj.vat.value==""){
					ComShowCodeMessage("MNR00172","V.A.Tax ");
					ComSetFocus(formObj.vat); 
					return false;     
				}
				if(formObj.wht.value==""){
					ComShowCodeMessage("MNR00172","W.H.Tax ");
					ComSetFocus(formObj.wht); 
					return false;     
				}
	
			}
			else if(sAction==IBSEARCH_ASYNC01) {  //Confirm
				if(sheetObjects[3].RowCount<1){
					ComShowCodeMessage("MNR00281");
					return false;     
				}
				var	tot = 0;				
				for(var i = 1; i <= (sheetObjects[3].RowCount); i++){  
				    tot +=  sheetObjects[3].CellValue(i, PrefixSheet2+"inv_amt")*100; //parseFloat로 더할시 결과가  3998.0000000023 로 나오는 경우가 있어서
				   if(sheetObjects[3].CellValue(i,PrefixSheet2+"inv_amt") <= 0){
						ComShowCodeMessage("MNR00175","Invoice Amount ");
						return false;
					}	
				}

				if(parseFloat(formObj.amt.value.replace(/,/g,""))!=tot/100){
					ComShowCodeMessage("MNR00280");
					ComSetFocus(formObj.amt); 
					return false;     
				}
				if(tot < 1){
					ComShowCodeMessage("MNR00175","Invoice Amount ");
					return false;
				}	
				if(formObj.inv_dt.value==""){
					ComShowCodeMessage("MNR00172","Invoice DT ");
					ComSetFocus(formObj.inv_dt); 
					return false;     
				}
				if(formObj.inv_due_dt.value==""){
					ComShowCodeMessage("MNR00172","Due DT ");
					ComSetFocus(formObj.inv_due_dt); 
					return false;     
				}
				if(formObj.amt.value==""){
					ComShowCodeMessage("MNR00172","INV AMT ");
					ComSetFocus(formObj.amt); 
					return false;     
				}
				if(formObj.vat.value==""){
					ComShowCodeMessage("MNR00172","V.A.Tax ");
					ComSetFocus(formObj.vat); 
					return false;     
				}
				if(formObj.wht.value==""){
					ComShowCodeMessage("MNR00172","W.H.Tax ");
					ComSetFocus(formObj.wht); 
					return false;     
				}
			}	
			else if(sAction==IBSEARCH_ASYNC04) {  //Cancel
				if(sheetObjects[3].RowCount<1){
					ComShowCodeMessage("MNR00281");
					return false;     
				}
			}				
			else if(sAction==IBDELETE) {
				if(formObj.input_inv_no.value==""){
					ComShowCodeMessage("MNR00089");
					return false;     
				}

				//[2011-05-19 KIM JONG OCK] Invoice Detail List 그리드에 Sold Date가 있는지 체크
				if(sheetObjects[2].RowCount > 0){
					if( sheetObjects[3].FindText("disp_sold_dt", "-", 0, 2) > -1 ){
						ComShowCodeMessage("MNR00361");
						return false;
					}
				}
				
				//[2011-05-19 KIM JONG OCK] Verified List 그리드에 Sold Date가 있는지 체크
				if(sheetObjects[3].RowCount > 0){
					if( sheetObjects[3].FindText(PrefixSheet2+"disp_sold_dt", "-", 0, 2) > -1 ){
						ComShowCodeMessage("MNR00361");
						return false;
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
			
			var idx = formObj.combo_kind.Index;
			if(idx=="0"){
				formObj.t1_mnr_prnr_cnt_cd.value = aryPopupData[0][3].substring(0,2);
				formObj.t1_mnr_prnr_seq.value = aryPopupData[0][3].substring(2);
				formObj.t1_mnr_prnr_cnt_nm.value = aryPopupData[0][4];
			}else if(idx=="1"){
				formObj.t2_mnr_prnr_cnt_cd.value = aryPopupData[0][3].substring(0,2);
				formObj.t2_mnr_prnr_seq.value = aryPopupData[0][3].substring(2);
				formObj.t2_mnr_prnr_cnt_nm.value = aryPopupData[0][4];
			}
		}
	}	
	
	function setInvoiceListValue() {
		
		var formObj = document.form;
		var idx = formObj.combo_kind.Index;
		
		if(idx=="0"){
			ComSetObjValue(formObj.from_dt, formObj.t1_from_dt.value); 
			ComSetObjValue(formObj.to_dt, formObj.t1_to_dt.value); 
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t1_mnr_ord_seq.value); 
			ComSetObjValue(formObj.vndr_seq, formObj.t1_mnr_prnr_cnt_cd.value + formObj.t1_mnr_prnr_seq.value); 
		}else if(idx=="1"){
			ComSetObjValue(formObj.from_dt, formObj.t2_from_dt.value); 
			ComSetObjValue(formObj.to_dt, formObj.t2_to_dt.value); 
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t2_mnr_ord_seq.value); 
			ComSetObjValue(formObj.vndr_seq, formObj.t2_mnr_prnr_cnt_cd.value + formObj.t2_mnr_prnr_seq.value);
		}
		ComSetObjValue(formObj.inv_sch_type_code, formObj.combo_kind.Code); 
		formObj.mnr_prnr_knd_cd.value = formObj.combo_buyer_type.Code;
	}	
	
	/**
	 * [New] 기능
	 */
	function setInvoiceListClear(flag) {

		var formObj = document.form;
		
		formObj.t1_from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t1_to_dt.value = ComGetNowInfo();
		formObj.t2_from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t2_to_dt.value = ComGetNowInfo();

		ComClearManyObjects(
		     formObj.t1_mnr_ord_seq
			,formObj.t2_mnr_ord_seq
			,formObj.t1_mnr_prnr_cnt_cd
			,formObj.t1_mnr_prnr_seq
	     	,formObj.t1_mnr_prnr_cnt_nm
			,formObj.t2_mnr_prnr_cnt_cd
			,formObj.t2_mnr_prnr_seq
	     	,formObj.t2_mnr_prnr_cnt_nm			
		)
				
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();

		document.form.combo_kind.Code = "MI"; 
		
		saveEndYN="";
		saveType="";
		invInfoClearYN="";

		if(flag == "N"){
			formObj.for_cel_del.checked = false;
		}
		
		// For Cel/Del. 체크시
  		if(formObj.for_cel_del.checked){
  			
  			// KIND=Invoice Correction 셋팅. disabled
  			formObj.combo_kind.Code = "CO"; // MI(Disposal No), CO(Invoice Correction)
  			formObj.combo_kind.Enable = false; // KIND 콤보 비활성
  			
  			// INV Date = null 처리. disabled
  			formObj.t2_from_dt.value = "";
  			formObj.t2_to_dt.value = "";
  			formObj.t2_from_dt.readOnly = true;
  			formObj.t2_to_dt.readOnly = true;
  			formObj.t2_from_dt.className = "input2";
  			formObj.t2_to_dt.className = "input2";
  			
  			// Buyer Type = ALL 처리.disabled
  			formObj.combo_buyer_type.Code = "ALL";    
  			// INV NO. 필수처리.(필수항목 색상)
  			formObj.t2_mnr_ord_seq.className = "input1";
  		}else{
  			// For Cel/Del. 체크해제시, 기존 화면 원복.(reload)
  			// For Cel/Del. 초기화
  			initForCelDel();

  			formObj.combo_kind.Enable = true;
  			formObj.t2_from_dt.readOnly = false;
  			formObj.t2_to_dt.readOnly = false;
  			formObj.t2_from_dt.className = "input";
  			formObj.t2_to_dt.className = "input";
  					
			if(strMnrOfficeLevel=="L1"){
				formObj.combo_buyer_type.Code2 = "G";
			}else if(strMnrOfficeLevel=="L2"){
				formObj.combo_buyer_type.Code2 = "R";
			}else{
				formObj.combo_buyer_type.Code2 = "L";
			}  			
  			formObj.t2_mnr_ord_seq.className = "input"; // INV No. 필수 해제
  		}    			
		
	}
	
	function setInvoiceInfomationClear() {
		
		var formObj = document.form;

		ComClearManyObjects(
		     formObj.input_inv_no
			,formObj.inv_dt
			,formObj.inv_due_dt
			,formObj.curr_cd
			,formObj.iss_ofc_cd
			,formObj.ref_no
			,formObj.buyer_cd
			,formObj.buyer_nm
			,formObj.buyer_type
			,formObj.mnr_grp_tp_cd			
			,formObj.mnr_prnr_tp_cd			
			,formObj.bank_nm
			,formObj.bank_acct_no
			,formObj.mnr_bil_to_nm
			,formObj.amt
			,formObj.vat
			,formObj.wht
			,formObj.g_amt
			,formObj.mnr_inv_rmk
			,formObj.g_vat_curr_amt
			,formObj.vat_xch_rt
		)
			
		document.form.combo_status.Code = "NEW"	
		document.form.chg_curr_cd.Code2 = -1;	
		
		formObj.rcv_inv_seq.value="";
		formObj.mnr_inv_sts_cd.value="";	
		formObj.cancel_yn.value="";
		formObj.chg_xch_rt.value="";  
		formObj.g_vat_curr_amt.value="";  
		
		
		formObj.amt.value="0.00";
		formObj.vat.value="0.00";
		formObj.g_amt.value="0.00";		
		formObj.wht.value="0.00";
		formObj.vat_xch_rt.value="0.00";
		
		
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
	}	
	
	function setCustomerName(tabIdx){
		MnrWaitControl(true);
		sheetObjects[0].Enable=false;
		var formObj=document.form;
		if(tabIdx="t1"){
			var CustCd=formObj.t1_mnr_prnr_cnt_cd.value;
			var CustSeq=formObj.t1_mnr_prnr_seq.value;
		}else{
			var CustCd=formObj.t2_mnr_prnr_cnt_cd.value;
			var CustSeq=formObj.t2_mnr_prnr_seq.value;
		}

		if(CustCd =="" || CustSeq =="" )
		{
			sheetObjects[0].Enable=true;
			MnrWaitControl(false);
			return;
		
		}
		var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],CustCd,CustSeq);
		var arrResult = MnrXmlToArray(sXml);	

		if(arrResult != null){	 	     
			for(var i = 0; i < arrResult.length;i ++){
       			if(tabIdx="t1"){
					formObj.t1_mnr_prnr_seq.value  =arrResult[i][4];
	         		formObj.t1_mnr_prnr_cnt_nm.value  =arrResult[i][10];
	         		formObj.t1_mnr_prnr_cnt_nm.title=arrResult[i][10];
				}else{
					formObj.t2_mnr_prnr_seq.value  =arrResult[i][4];
	         		formObj.t2_mnr_prnr_cnt_nm.value  =arrResult[i][10];
	         		formObj.t2_mnr_prnr_cnt_nm.title=arrResult[i][10];
				}
				break;
			}	
		}else{
			ComShowCodeMessage("MNR00121");
   			if(tabIdx="t1"){
				formObj.t1_mnr_prnr_cnt_cd.value="";
				formObj.t1_mnr_prnr_seq.value="";
	     		formObj.t1_mnr_prnr_cnt_nm.value  ="";
	     		formObj.t1_mnr_prnr_cnt_nm.title ="";
	     		ComSetFocus(formObj.t1_mnr_prnr_cnt_cd);
			}else{
				formObj.t2_mnr_prnr_cnt_cd.value="";
				formObj.t2_mnr_prnr_seq.value="";
	     		formObj.t2_mnr_prnr_cnt_nm.value  ="";
	     		formObj.t2_mnr_prnr_cnt_nm.title ="";
	     		ComSetFocus(formObj.t2_mnr_prnr_cnt_cd);
			}				
		}
		sheetObjects[0].Enable=true;
		MnrWaitControl(false);
	}
	
	function chkCurrXchRt(){		
		var formObj = document.form;   
										
		var invTotAmt = ""; 	
		var whtTaxAmt = "";
		var vatXchRt = "";
		var chgXchRt= "";				
		
		var val = formObj.vat_xch_rt.value.split(".");  
		var val1 = val[0];			
		var val2 = val[1];	
		if(val2 == undefined) val2 = "0";
		if(val1.length >= 15){
			formObj.vat_xch_rt.value = val1.substr(0,15) + "." + val2
		}
		vatXchRt = formObj.vat_xch_rt.value.replace(/,/g,"");
		formObj.vat_xch_rt.value = ComAddComma2(formObj.vat_xch_rt.value , "#,###.00")
		if(vatXchRt=="") vatXchRt = "0.00";
						
		if(formObj.chg_curr_cd.Code != "" && formObj.chg_xch_rt.value == ""){ 
			formObj.chg_xch_rt.value = "0.00";
		} 				
		val = formObj.chg_xch_rt.value.split(".")
		val1 = val[0];
		val2 = val[1];
		if(val2 == undefined) val2 = "0";
		if(val1.length >= 15){
			formObj.chg_xch_rt.value = val1.substr(0,15) + "." + val2
		}
		chgXchRt = formObj.chg_xch_rt.value.replace(/,/g,"");
		formObj.chg_xch_rt.value = ComAddComma2(formObj.chg_xch_rt.value, "#,###.00");
							
		if(currPrcsKnt=="0"){		
			if(formObj.amt.value.length >= 15){	
				formObj.amt.value = formObj.amt.value.substr(0,15)
			}	
			invTotAmt = formObj.amt.value.replace(/,/g,"");
			formObj.amt.value = ComAddComma2(formObj.amt.value , "#,###")
			if(invTotAmt == "") invTotAmt = "0";	
					
			if(formObj.wht.value.length >= 15){	
				formObj.wht.value = formObj.wht.value.substr(0,15)
			}
			whtTaxAmt = formObj.wht.value.replace(/,/g,""); 	
			formObj.wht.value = ComAddComma2(formObj.wht.value, "#,###")	
			if(whtTaxAmt == "")	whtTaxAmt = "0";	 	
							
			if(formObj.curr_cd.value == formObj.chg_curr_cd.Code){	
			//같으면 Invoice + vat	 
				formObj.g_amt.value = parseFloat(parseFloat(invTotAmt) + (parseFloat(invTotAmt) * parseFloat(vatXchRt))).toFixed(0);  
			} else {		
			//다르면 Invoice 금액만		 		
				formObj.g_amt.value = parseFloat(invTotAmt).toFixed(0); 	 		
			}		
			formObj.g_amt.value = ComAddComma2(formObj.g_amt.value, "#,###");
							
		} else { 	
			var val = formObj.amt.value.split(".");  
			var val1 = val[0];			
			var val2 = val[1];	
			if(val2 == undefined) val2 = "0";
			if(val1.length >= 15){
				formObj.amt.value = val1.substr(0,15) + "." + val2
			}
			invTotAmt = formObj.amt.value.replace(/,/g,"");
			formObj.amt.value = ComAddComma2(formObj.amt.value , "#,###.00")
			if(invTotAmt=="") invTotAmt = "0.00";
							
			val = formObj.wht.value.split(".")
			val1 = val[0];
			val2 = val[1];
			if(val2 == undefined) val2 = "0";
			if(val1.length >= 15){
				formObj.wht.value = val1.substr(0,15) + "." + val2
			}
			whtTaxAmt = formObj.wht.value.replace(/,/g,"");
			formObj.wht.value = ComAddComma2(formObj.wht.value, "#,###.00")
			if(whtTaxAmt == "")	whtTaxAmt = "0.00";	
								
			if(formObj.curr_cd.value == formObj.chg_curr_cd.Code){	
			//같으면 Invoice + vat 
				formObj.g_amt.value = parseFloat(parseFloat(invTotAmt) + (parseFloat(invTotAmt) * parseFloat(vatXchRt))).toFixed(2);  
			} else {			
			//다르면 Invoice 금액만	
				formObj.g_amt.value = parseFloat(invTotAmt).toFixed(2);	
			}			
			formObj.g_amt.value = ComAddComma2(formObj.g_amt.value, "#,###.00");
		}						
														
		//조회 해온 환률로 dp_prcs 변경				
		if(formObj.conv_dp_prcs_knt.value == "0"){	
			formObj.vat.value = parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))).toFixed(0);
			formObj.g_vat_curr_amt.value = parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))).toFixed(0);		 
			formObj.vat.value = ComAddComma2(formObj.vat.value, "#,###");	
			formObj.g_vat_curr_amt.value = ComAddComma2(formObj.g_vat_curr_amt.value, "#,###");
		} else {
			formObj.vat.value = parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))).toFixed(2);
			formObj.g_vat_curr_amt.value = parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))).toFixed(2);
			formObj.vat.value = ComAddComma2(formObj.vat.value, "#,###.00");
			formObj.g_vat_curr_amt.value = ComAddComma2(formObj.g_vat_curr_amt.value, "#,###.00");
		}			
				
		//inv curr과 vat curr이 같을 경우 g_vat_curr_amt 를 보여주지 않는다.
		if(formObj.chg_curr_cd.Code == formObj.curr_cd.value){		
			formObj.g_vat_curr_amt.value = "";		   
		}									
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
	    		case "vat_xch_rt":   
	    		case "chg_xch_rt":   
	    		case "wht":		   
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
	    		case "t1_mnr_prnr_seq":   
					setCustomerName('t1');
				   	break;  
	    		case "t2_mnr_prnr_seq":   
	        		setCustomerName('t2');
				   	break;  
	    		case "vat_xch_rt":
					chkCurrXchRt();	
				   	break; 
	    		case "chg_xch_rt":   
					chkCurrXchRt();	
				   	break; 
	    		case "wht":   
					chkCurrXchRt();	
				   	break; 				
	    		case "inv_dt":   
					MnrChkDateValid(formObj.inv_dt,"Invoice DT");
					
					var prevChgCurrCd = formObj.chg_curr_cd.Code;
					if(prevChgCurrCd != ""){
						formObj.chg_curr_cd.Code2 = -1;
						formObj.chg_curr_cd.Code = prevChgCurrCd;
					}						
					chkCurrXchRt();
				   	break; 	
	    		case "inv_due_dt":   
					MnrChkDateValid(formObj.inv_due_dt,"Due DT");
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
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":   
	            ComKeyOnlyNumber(obj, ".");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup": 
	         	if(obj.name == "t1_mnr_ord_seq" || obj.name == "t2_mnr_ord_seq" ){ 
					ComKeyOnlyAlphabet('uppernum','45|44'); 
				}else if(obj.name=="t1_mnr_prnr_cnt_cd" || obj.name=="t2_mnr_prnr_cnt_cd"){
					ComKeyOnlyAlphabet('upper');	
				}else if(obj.name == "mnr_inv_rmk"){
					ComKeyOnlyAlphabet('uppernum','32|45|40|41');
				}else {				   
					ComKeyOnlyAlphabet('uppernum','45');	
				}        

	        break;	  
	    }
	} 
	/**
	 * INV OFFICE가 PKGSC인 경우에만 실행되는 메소드(Tax Rate 0.06, EX.Rate의 화폐단위 MYR) <br>
	 **/    
	function initialization_for_PKGSC(){
		if(document.form.iss_ofc_cd.value == "PKGSC"){
			document.form.vat_xch_rt.value = 0.06;
			document.form.chg_curr_cd.Code = "MYR";
			
			document.form.vat_xch_rt.readOnly = true;
			document.form.chg_xch_rt.readOnly = true;
			document.form.chg_curr_cd.readOnly = true;
//			document.form.chg_curr_cd.Enable = false;
			chkCurrXchRt();

		} else{
			document.form.vat_xch_rt.readOnly = false;
			document.form.chg_xch_rt.readOnly = false;
			document.form.chg_curr_cd.readOnly = false;
//			document.form.chg_curr_cd.Enable = true;
		}
	}
		  