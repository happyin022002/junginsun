/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0252.js
*@FileTitle : EDI Estimate Group Auditing
*Open Issues :     
*Change history :  
*@LastModifyDate : 2011.05.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.05.09 김영오		   		
* 1.0 Creation
* -----------------------------------------------------------------------------
* History	 	   
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
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
     * @class EES_MNR_0252 : EES_MNR_0252 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0252() {
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
// 공통전역변수   
var tabObjects = new Array(); 
var tabCnt = 0 ;  
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0; 

var chkEqNo = "";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];


         /*******************************************************/
         var formObject = document.form;
			
    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");
			
            switch(srcName) {	
					
                case "btn_retrive":  
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                    break; 
					
		        case "btn_New":
                    doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
                    break; 
						
		        case "btn_Reject": 	
                    doActionIBSheet(sheetObjects[1],formObject,IBCREATE);
                    break;
						
		        case "btn_Approval": 
                    doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
                    break;
					
		        case "btn_Detail":	
					if(sheetObjects[1].RowCount == 0){ 
						ComShowCodeMessage("MNR00309");			
					} else { 
						if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no")) != ''){
							//있다면 팝업호출 
							var rqstEqNo = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no");    
							var rprRqstSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_seq");
							var rprRqstVerNo = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_ver_no");    
							var eqKndCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"eq_knd_cd"); 
														
							ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
						}	 
					}
                    break;	
							
		        case "btn_downExcel":	   
                    sheetObjects[1].SpeedDown2Excel(-1); 
                    break;	
					
				case "btns_calendar":	 
					var cal = new ComCalendarFromTo();	       
						cal.select(form.fm_rqst_dt,  form.to_rqst_dt,  'yyyy-MM-dd'); 
					break; 	
				//멀티입력
				case "eq_no_multi":  
				    rep_Multiful_inquiry("rqst_eq_no");
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
		MnrWaitControl(true);
		initControl();   
        for(i=0;i<sheetObjects.length;i++){
	
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }   
					
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
		
        var cnt = 0;

        switch(sheetObj.id) {
			case "sheet1":  
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}		 
				
            case "sheet2":      // sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 410;    
                    //전체 너비 설정 
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
						
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
					
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100); 
	
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(28, 6, 0, true); 
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);  
					  				
                    var HeadTitle = "|Sel.|Seq.|EQ Type|Service Provider|EQ No.|T/S|Estimate No|Request Date|Total\nAmout|Total\nAmount(USD)|System Verify\nResult|AGMT No.|Ref.No|Tariff No.";
                    HeadTitle      += "|AGMT Office|Damage\nFlagging|Imm\nExit|Off-\nhire|Estimate\nStatus|Remark(s)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
                    InitHeadRow(0, HeadTitle, true); 
							  			 
                    //데이터속성    [ROW, COL,  DATATYPE,   		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,	0,      daCenter,  	false,   "ibflag"); 
					InitDataProperty(0, cnt++,  dtCheckBox,		40,		daCenter,	true,	 "del_chk");		 
                    InitDataProperty(0, cnt++,  dtSeq,       	30,    	daCenter,  	false,   "Seq",     		false,      "",    	dfNone     );
                    InitDataProperty(0,	cnt++,	dtCombo,	 	60,		daCenter,  	false,	 "eq_knd_cd",		false,		"",		dfNone,			0,	false,	false);
                    InitDataProperty(0,	cnt++,	dtData,		 	140, 	daLeft,	   	false,	 "vndr_nm",			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	 "rqst_eq_no",		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			40,		daCenter,	false,	 "eq_tpsz_cd",		false,		"",		dfNone,			0,	false,	false);
                    InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	 "rqst_ref_no",		false,		"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++,  dtData,     	85,    	daCenter,  	false,   "rqst_dt",     	false,      "",     dfDateYmd,		0,	false,	false);    
                    InitDataProperty(0,	cnt++,	dtData,			70,		daRight,	false,	 "total_amt",		false,		"",		dfNullFloat,	2,	false,	false);
                    InitDataProperty(0,	cnt++,	dtData,			90,		daRight,	false,	 "total_usd_amt",	false,		"",		dfNullFloat,	2,	false,	false);
                    InitDataProperty(0,	cnt++,	dtCombo,	 	140,	daLeft,    	false,	 "mnr_vrfy_tp_cd",	false,		"",		dfNone,			0,	false,	false);	
				    InitDataProperty(0, cnt++,  dtData,      	100,    daCenter, 	false,   "agmt_no",     	false,      "",     dfNone,			0,	false,	false);   
				    InitDataProperty(0, cnt++,  dtData,      	100,    daLeft, 	false,   "agmt_ref_no",    	false,      "",     dfNone,			0,	false,	false);   
  					InitDataProperty(0, cnt++,  dtData,      	110,    daCenter, 	false,   "trf_no",      	false,      "",     dfNone,			0,	false,	false);   
                    InitDataProperty(0, cnt++,  dtData,      	80,    	daCenter,  	false,   "agmt_ofc_cd",     false,      "",     dfNone,			0,	false,	false);	
                    InitDataProperty(0, cnt++,  dtData,      	60,    	daCenter,  	false,   "dmg_flag",        false,      "",     dfNone,			0,	false,	false);	
                    InitDataProperty(0, cnt++,  dtData,      	60,    	daCenter,  	false,   "imm_ext",         false,      "",     dfNone,			0,	false,	false);	
                    InitDataProperty(0, cnt++,  dtData,      	40,    	daCenter,  	false,   "rpr_offh_flg",    false,      "",     dfNone,			0,	false,	false);	
                    InitDataProperty(0,	cnt++,	dtCombo,	 	113,	daLeft,   	false,	 "rpr_sts_cd",		false,		"",		dfNone,			0,	false,	false);	
                    InitDataProperty(0, cnt++,  dtData,      	100,    daLeft,   	false,   "mnr_rpr_rmk",     false,  	"",     dfNone,			0,	true,	true, 4000);	
					InitDataProperty(0, cnt++,  dtHidden,   	0,		daCenter,   false,   "agmt_ofc_cty_cd", false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++,  dtHidden,   	0,		daCenter,  	false,   "agmt_seq",        false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++,  dtHidden,   	0,		daCenter,  	false,   "agmt_ver_no",     false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++,  dtHidden,   	0,		daCenter,   false,   "vndr_seq",        false,      "",     dfNone,    		0,  true,   true);
					//MNR_RPR_RQST_HDR	키값  rqst_eq_no	rpr_rqst_seq  rpr_rqst_ver_no	
					InitDataProperty(0, cnt++,  dtHidden,   	0,		daCenter,  	false,   "rpr_rqst_seq",    false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++,  dtHidden,   	0,		daCenter,  	false,   "rpr_rqst_ver_no", false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0,	cnt++,	dtHidden,		0,		daCenter,	false,	 "dup_chk",			false,	    "",	    dfNone,		    0,	true,	true);

            }	
                break;
        }		
    }
	
  // Sheet관련 프로세스 처리 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
				
          case IBSEARCH:      //목록조회   is_edi
                 if(validateForm(sheetObj,formObj,sAction)){    
						formObj.f_cmd.value = SEARCH;  
						var sParam = FormQueryString(formObj);
							
         				sheetObj.DoSearch4Post("EES_MNR_0252GS.do",sParam); 
				  } 	        
                break; 	

			 case IBCREATE:        //Reject
	              if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value = COMMAND03; 	   
																							          
						var sParam = sheetObjects[1].GetSaveString(false, true,"del_chk"); 
						sParam = ComSetPrifix(sParam,"sheet2"); 
							 
					    sParam += "&" + FormQueryString(formObj);	 	  
					    var sXml = sheetObj.GetSaveXml("EES_MNR_0252GS.do", sParam);
												 	  	
						sheetObjects[1].LoadSaveXml(sXml);  
				  }			
				 break;	  
					 
			case IBSAVE:        //Approval	    
	             if(validateForm(sheetObj,formObj,sAction)){ 
						formObj.f_cmd.value = COMMAND04;   	 
						
						// 15일내 동일vendor, 동일장비 approval 여부 확인
						for( i=1; i < sheetObj.RowCount+1; i++) {							
							if(sheetObj.CellValue(i, "del_chk")=="1") { //sel 선택된 경우
								if( sheetObj.CellValue(i, "dup_chk") == "T") { // 중복이 보이는 경우
									if (!ComShowCodeConfirm("MNR00402",sheetObj.CellValue(i, "rqst_eq_no"))){ // approval 할지 confirm
										return false; 			
									} 					
								}
							}
						}
						
						var sParam = sheetObjects[1].GetSaveString(false, true,"del_chk"); 
						sParam = ComSetPrifix(sParam,"sheet2"); 
							 	
					    sParam += "&" + FormQueryString(formObj);	 	  
					    var sXml = sheetObj.GetSaveXml("EES_MNR_0252GS.do", sParam);
											 	  	
						sheetObjects[1].LoadSaveXml(sXml); 
				  }		
				 break;	
				
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				//START
				sheetObj.WaitImageVisible=false;
				
				formObj.reset();
				
				//콤보 초기화	  
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].Code = "-1";
					comboObjects[i].RemoveAll();	 	       
				}	 
				
				//쉬트 초기화 	
				sheetObjects[1].RemoveAll();       
					
				formObj.fm_rqst_dt.value  = 	ComGetDateAdd(ComGetNowInfo("ymd"), "M", -3); 	         
				formObj.to_rqst_dt.value  = 	ComGetNowInfo("ymd"); 	
				
				//쉬트 콤보 세팅 
				var sCondition = new Array (	 
					new Array("MnrGenCd",selfOfcCd,"CUSTOM9"), 
					new Array("MnrGenCd","CD00008", "COMMON"),	
					new Array("MnrGenCd","CD00002", "COMMON"),
					new Array("MnrGenCd","CD00004", "COMMON")	    
				)			 	
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
				
				//폼 콤보 EQ_TYPE	
				comboObjects[0].InsertItem(0, 'ALL' ,'ALL'); 
				if(comboList[0] != null){	    
					for(var j = 1; j < comboList[0].length + 1;j++){ 
						var tempText = comboList[0][j - 1].split("|");  
						comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
					} 				    
				}		 		  	 
				comboObjects[0].Code = 'ALL';
								
				//sheetObjects[1] 쉬트 콤보 설정      			
				var sheetComboText = "";  
				var sheetComboCode = "";
				var sheetComboDefault = "";
						
				var comboSaveNames = new Array();
				comboSaveNames[0] = "rpr_sts_cd";
				comboSaveNames[1] = "eq_knd_cd";
				comboSaveNames[2] = "mnr_vrfy_tp_cd";          
					      
				for(var i = 1; i < comboList.length;i++){
				 	if(comboList[i] != null){
						sheetComboText = ""; 
						sheetComboCode = "";
						sheetComboDefault = ""; 
						   
				 		for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");    
							 
							sheetComboText +=  tempText[1] + "|";  
							sheetComboCode +=  tempText[0] + "|";  
							if(j == 0){
								sheetComboDefault = tempText[0]; 	       	
							}  	   
						}			
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 1], sheetComboText, sheetComboCode ,sheetComboDefault); 
					}   		      
				}    
				 		
				//END 
				sheetObj.WaitImageVisible=true; 
				MnrWaitControl(false);  
                break;
                
			case IBSEARCH_ASYNC04:	//조회(YARD 입력시 벨리데이션 )
				formObj.f_cmd.value = COMMAND05;
				var sParam = sheetObjects[1].GetSaveString(false, true,"del_chk"); 
				sParam = ComSetPrifix(sParam,"sheet2"); 
				sParam += "&" + FormQueryString(formObj);	 	  
				
				var sXml = sheetObj.GetSaveXml("EES_MNR_0022GS.do", sParam);
				
				if(MnrComGetErrMsg(sXml) == null){
					chkEqNo = ComGetEtcData(sXml, "RQST_EQ_NO");				
				}else{
					ComShowCodeMessage("MNR00001");
					return false;
				}
				break;
        }
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
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    var formObject = document.form
		 		    
	    switch(comboNo) {      
			   default :   
		           with (comboObj) { 
				       //SetColAlign("left");	         
					   //DropHeight = 160;		     
			       }   	   
	           break;	 	
	     } 		
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
					
                }
             break;
         }	
    }
			
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") {  
			ComShowCodeMessage("MNR00023"); 		   
		} else {		 	
			//ComShowCodeMessage("MNR00008",ErrMsg);  		
		}  	 		      
	}
			
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");
		
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){ 	       
        	switch(sAction) { 	 
				case IBROWSEARCH:
					if (!ComChkValid(formObj)) return false;
				 	break;	
						            
				case IBCREATE: 	  //Reject
					var sRow = sheetObj.FindCheckedRow("del_chk");
					if (sRow == ""){
						ComShowCodeMessage("MNR00038","Reject ");	
						return false;
					} 
					
					doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC04);

					if(chkEqNo != "" && chkEqNo != null){
						ComShowCodeMessage("MNR00389",chkEqNo);
						return false;
					}
					
					//REJECT 저장  의사 확인   	
					if (!ComShowCodeConfirm("MNR00275","Estimate","Reject")){return false;}     
					break;	
					
				case IBSAVE:     		//Approval 
					var sRow = sheetObj.FindCheckedRow("del_chk");
					if (sRow == ""){
						ComShowCodeMessage("MNR00038","Approval ");	
						return false;
					} 
					
					doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC04);

					if(chkEqNo != "" && chkEqNo != null){
						ComShowCodeMessage("MNR00389",chkEqNo);
						return false;
					}
					
					if (!ComShowCodeConfirm("MNR00275","Estimate","Approval")){return false;}	
					break; 	 	
			}   
		}
        return true;
    }
	
	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj = document.form;	 
 		var tempText = "";      
 		//초기화     
		eval("document.form." + return_val + ".value = '';"); 
 
 		for(var i=0; i < rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함      
		tempText = MnrDelLastDelim(tempText);		
 			     
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	} 
	
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj = document.form;       
		if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"rqst_eq_no")) != ''){ 
			//있다면 팝업호출
			var rqstEqNo = sheetObjects[1].CellValue(Row,"rqst_eq_no");    
			var rprRqstSeq = sheetObjects[1].CellValue(Row,"rpr_rqst_seq");
			var rprRqstVerNo = sheetObjects[1].CellValue(Row,"rpr_rqst_ver_no");     
			var eqKndCd = sheetObjects[1].CellValue(Row,"eq_knd_cd");  
			 														
			ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
		} 	      	
	} 	
		 
	//콤보 이벤트 					
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		formObj.eq_knd_cd.value = comboObj.Code; 
	}   
	
	function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		//axon_event.addListenerFormat('change',	 'obj_change',		formObject); 			//- 변경될때.
	}             
		   	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
		
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "rqst_eq_no":   
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;   
			}       
	    } else {
			switch(obj.name) {     
	    		case "rqst_eq_no":    
					setEqInfoClear(); 
				   	break;   	
			}  		
		}
	}    
	        
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
	            ComKeyOnlyNumber(obj, "-.");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup":   
				if(obj.name == "rqst_eq_no"){
					ComKeyOnlyAlphabet('uppernum','44');
				} else { 
					ComKeyOnlyAlphabet('uppernum');	
				}      
	            break; 
	    }         
	}
	/* 개발자 작업  끝 */