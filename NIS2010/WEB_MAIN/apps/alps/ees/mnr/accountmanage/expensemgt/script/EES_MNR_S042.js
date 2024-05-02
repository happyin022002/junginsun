/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S042.js 
*@FileTitle : SPP Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation  
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
     * @class EES_MNR_S042 : EES_MNR_S042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_S042() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;    

var initLoader = 0;

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

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
					
                case "btn_DetailRetrieve":
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH,1);
					break;

				case "btn_DownExcel":
					form.sheet1.SpeedDown2Excel(-1);
					break;

				case "btn_calendar": 
					var cal = new ComCalendarFromTo();   
					cal.setDiffDomain(true);
 					cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd'); 
					break;    

		        case "btn_inv_no_multy":           
                    rep_Multiful_inquiry("inv_no");   
					break;
											
		        case "btn_wo_no_multy":           
                    rep_Multiful_inquiry("inv_wo_no");   
					break;
											
		        case "btn_csr_no_multy":           
                    rep_Multiful_inquiry("csr_no");   
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
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
  	    for(k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }			

		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);		
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

             case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 142;
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

					var HeadTitle = "|sel|Seq|pay_inv_seq|INV No.|INV OFC|S/P Code|S/P Name|INV Status|Receive DT|Eff Dt|Issue DT|CURR|G.Amount|V.A.Tax|W.H.Tax|CSR No.|INV Remark";
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   false,     "ibflag");
	                InitDataProperty(0, cnt++ , dtHidden, 		40,		daCenter,  	true,     "Check",				false,          "",      dfNone,      	0,     true,       true);
                    
					InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   false,     "Seq");
					InitDataProperty(0, cnt++ , dtHidden,    	80,		daLeft,  	false,     "pay_inv_seq",		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,    		80,		daLeft,  	false,     "wo_no",				false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,  	false,     "iss_ofc_cd",		false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,   	70,		daCenter,  	false,     "vndr_seq",			false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    	80,		daLeft,  	false,     "vndr_lgl_eng_nm",	false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		80,		daLeft,  	false,     "mnr_inv_sts_nm",	false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,   false,     "rcv_dt",    		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		75,		daCenter,   false,     "eff_dt",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		75,		daCenter,   false,     "iss_dt", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter,   false,     "curr_cd",  			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daRight,   	false,     "ttl_amt", 	 		false,          "",      dfFloat,      	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight, 	false,     "vat_amt", 			false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight, 	false,     "whld_tax_amt", 		false,          "",      dfFloat,    	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daLeft, 	false,     "csr_no", 			false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daLeft, 	false,     "mnr_inv_rmk", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		80,		daLeft, 	false,     "dp_prcs_knt", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		80,		daLeft, 	false,     "pay_inv_seq", 		false,          "",      dfNone,    	0,     false,       false);

					CountPosition = 0;
				}
				break;

			case "sheet2":
                 with (sheetObj) {

                     // 높이 설정
                    style.height = 210;
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

					var HeadTitle1 = "|Seq|W/O\nType|W/O\nNo.|Estimate\nNo.|EQ No.|TS|Cost\nType|Cost Detail\nType|Repair\nYard|Repair\nDate|Extra\nItem|Extra\nQty|INV NO|Invoice\nAmount|System Verify\nResult";
					var HeadTitle2 = "|Seq|W/O\nType|W/O\nNo.|Estimate\nNo.|EQ No.|TS|Cost\nType|Cost Detail\nType|Repair\nYard|Repair\nDate|Extra\nItem|Extra\nQty|INV NO|Invoice\nAmount|System Verify\nResult";
							
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,   true,     "ibflag");
	                InitDataProperty(0, cnt++ , dtSeq,	 		30,		daCenter,   true,     "Seq");
	                InitDataProperty(0, cnt++ , dtData,    		70,		daCenter,  	true,     "mnr_wo_tp",			false,          "",      dfNone,      	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   		80,		daLeft,  	true,     "wo_no",				false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,   		80,		daLeft,  	true,     "rqst_ref_no",		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,  	true,     "eq_no",  	  		false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		40,		daCenter,   true,     "eq_tpsz_cd",  		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daLeft,   	true,     "cost_cd", 			false,          "",      dfNone,  	  	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,  	true,     "cost_dtl_cd", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daCenter,  	true,     "yd_cd",				false,          "",      dfNone,      	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daCenter, 	true,     "rpr_rslt_dt", 		false,          "",      dfNone,    	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft,   	true,     "mnr_expn_dtl_nm",	false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		60,		daRight,   	true,     "rpr_qty", 			false,          "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daLeft ,   	true,     "inv_no", 			false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,  		70,		daRight,   	true,     "inv_amt", 			false,          "",      dfFloat, 	 	2,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,  		60,		daLeft,   	true,     "mnr_vrfy_tp_cd", 	false,          "",      dfNone, 	 	0,     false,       false);

					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_ord_ofc_cty_cd", false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_ord_seq", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "ord_dtl_seq", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "mnr_wo_tp_cd", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "rpr_rqst_seq", 		false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "rpr_rqst_ver_no", 	false,          "",      dfNone, 	 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		60,		daLeft,   	true,     "eq_tpsz_cd", 		false,          "",      dfNone, 	 	0,     false,       false);

					CountPosition = 0;
				}
				break;

        }
    }

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
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
	        	ComKeyOnlyAlphabet('uppernum');   
	        break;	  
	    }
	} 	

	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH,1);
	}
	
	/**  
	 * combo1 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		form.input_date_type_code.value=Index_Code;
	}   	

	/**  
	 * combo3 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo3_OnChange(comboObj,Index_Code, Text){ 
		form.mnr_inv_sts_cd.value=Index_Code;
	}

  	/**
     * Sheet관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     * @param	{Number}	sheetIdx	sheetIdx
     */
    function doActionIBSheet(sheetObj,formObj,sAction, sheetIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          	case IBSEARCH:      //조회
	          	if(validateForm(sheetObj,formObj,sAction, sheetIdx)){

					sheetObjects[1].RemoveAll();
									
					formObj.inv_sch_type_code.value="CO";
					if ( sheetIdx == "1"){
						
						//currency별  소수점 가져오기		  
						var currPrcsKnt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"dp_prcs_knt");
						if(currPrcsKnt=="0"){
							sheetObjects[1].InitDataProperty(0, 13 , dtData,  	70,		daRight,   	true,     "inv_amt", 			false,         	"",      dfInteger, 	0,     false,       false);
						}else{
							sheetObjects[1].InitDataProperty(0, 13 , dtData,  	70,		daRight,   	true,     "inv_amt", 			false,         	"",      dfFloat, 	2,     false,       false);
						}
						
						sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)= "U";
						
						formObj.f_cmd.value = SEARCH01;
						var sParam = ComGetSaveString(sheetObjects[0]);
						if (sParam == "") return;
				    	sParam += "&" + FormQueryString(formObj);
						var sXml = sheetObj.GetSaveXml("EES_MNR_S042GS.do", sParam);
						sheetObj.LoadSearchXml(sXml); 

						sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)= "";
					}else{
						formObj.input_type_code.value="W";
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch4Post("EES_MNR_S042GS.do",FormQueryString(formObj));
					}	
				}		
                break;

			case IBCLEAR:      // 초기화
			
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;

				if(initLoader == 0){
					formObj.vndr_seq.value= ComLpad(formObj.vndr_seq.value,6,"0");
					
					//공통콤보 정보를 가져온다.  
					var sCondition = new Array (
						new Array("MnrGenCd","CD00040", "COMMON"),	//MNR Input Date Type Code 
						new Array("MnrGenCd","CD00027", "COMMON"),	//Repair Invoice Status Code
						new Array("MnrGenCd","CD00004", "COMMON")	//System Verification Result Code 
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
								//MNR Input Date Type Code
								if(i==0) {
									formObj.combo1.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										formObj.combo1.Code = tempText[0]; 
									}	
								//Repair Invoice Status Code
								} else if(i==1){
									formObj.combo3.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										formObj.combo3.InsertItem(0, "ALL" ,"");
									}  								
								}
							}
							//System Verification Result Code
							if(i==2) {
								sheetObjects[1].InitDataCombo(0, "mnr_vrfy_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
							} 					
						}
					}
				}
	
				initLoader = 1;	
				
				formObj.from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "m", -3);
				formObj.to_dt.value = ComGetNowInfo();
		
				comboObjects[1].index = 0;
				formObj.inv_no.value = '';
				formObj.inv_wo_no.value = '';
				formObj.csr_no.value = '';
				
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();

				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
				break;
        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, sheetIdx){
        with(formObj){
			if(sAction==IBSEARCH) {
				var arrWoNo = formObj.inv_wo_no.value.split(",");
				if(arrWoNo!=""){
					for(i=0;i<arrWoNo.length;i++){
						if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
							ComShowCodeMessage("MNR00010","W/O No");
							return false;
						}
					}
				}
			}				
        }
        return true;
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