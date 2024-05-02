/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0121.js
*@FileTitle : MNR PFMC by Estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.10.08 민정호
* 1.0 Creation
*=====================================================
* 2013.05.30 조경완 [CHM-201324809-01] [MNR-자체개선] M&R > Guideline & PFMC > General Performance > PFMC by Estimate 수행시 ALPS OLTP Rule에 따라 Timeout SQL 발생 방지를 위한 BackEndJob 으로의 기능 전환
=========================================================*/
// 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0;       
 
//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
 var uTpSz = new Array();    
 var gTpSz = new Array();  
 var zTpSz = new Array();  

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;
	
	try {	
 		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_Retrieve":		
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
			case "btn_New":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
	            break; 		            
		    case "btn_DownExcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	            break;
			case "btn_calendar": 
				var cal = new ComCalendarFromTo();		
				cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');       						
				break;	  	 
			case "btn_loc_cd": 	
				var eq_knd_cd = "";	 
				if(formObject.eq_type.Code != 'A'){
					eq_knd_cd = formObject.eq_type.Code;	 			
				} 		
											  
				break;								
				
			case "btn_provider_popup":
			    ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
				break;					
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	initControl(); 	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}	
						
    //IBMultiCombo초기화 	
    for(var k=0;k<comboObjects.length;k++){ 
        initCombo(comboObjects[k],k + 1);  
    }	
		
	//타입사이즈는 처음 한번만 가져온다.		
	setTpSzArray(sheetObjects[0]);  
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);		
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
        case 1: 
           	with (comboObj) { 
          	    MultiSeparator = "|";
				SetTitle("Period|Amount");		
				SetColAlign("left|left");			        
				SetColWidth("100|100");					     
				DropHeight = 160;						         
				UseAutoComplete = true;
  		    }          
        	break; 
			
        case 2: 
           	with (comboObj) { 
           		MultiSelect = true;
       	   		SetColAlign("left");        
		       	SetColWidth("80");      
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
			
        case 3: 
           	with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				SetColAlign("left");
				SetColWidth("230");  
				DropHeight = 200;
  		    }          
        	break;
			     	        	
        case 4: 
           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
       	   		SetColAlign("left|left");        
				//SetColWidth("100|150");     
			   	DropHeight = 160;         
				UseAutoComplete = true;
	    	}      
        	break;
			    
        case 5: 
           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
       	   		SetColAlign("left|left");        
				//SetColWidth("100|150");
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
			
        case 6: 
           	with (comboObj) { 
	           	SetColAlign("left|left");        
		       	SetColWidth("50|150");      
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;   
			
        case 7: 
           	with (comboObj) { 
       	   		SetColAlign("left|left");        
		       	SetColWidth("50|150");      
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
     } 
}     
 

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

     var cnt = 0;
	 var sheetID = sheetObj.id;

      switch(sheetID) {

          case "sheet1":
              with (sheetObj) {

                  // 높이 설정
                  style.height =  382;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msNone;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = false;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 1, 3, 100);
											
     			  var HeadTitle = "|Seq.|RHQ|Item|Month|Account\nCode|Office|S/P Code|S/P Name|TP/SZ|Curr|Success|Success\nAMT|Success(L)|Success(L)\nAMT|Off-hire|Off-hire\nAMT|Standard Tariff\nNot Found|Standard Tariff\nNot Found AMT|Material Tariff\nNot Found|Material Tariff\nNot Found AMT|Man-Hour\nUnmatched|Man-Hour\nUnmatched AMT|Rate\nUnmatched|Rate\nUnmatched AMT|Material\nUnmatched|Material\nUnmatched AMT|Volume Type\nError|Volume Type\nError AMT|Location\nError|Location\nError AMT|Component\nError|Component\nError AMT|Repair\nError|Repair\nError AMT|Damage\nError|Damage\nError AMT|Agreement\nNot Found|Agreement\nNot Found AMT|Repair\nQTY|Estimate\nQTY|Reject\nQTY|Reject\nAMT|Counter\nOffer QTY|Counter\nOffer AMT|Total\nAMT|Average AMT\n(Total/Repair)";
					
				  var headCount = ComCountHeadTitle(HeadTitle);	 	
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true); 	
			     	 										
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)
					
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle, true);
										
                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"hdnStatus");
                  InitDataProperty(0, cnt++ , dtSeq,       	    40,     daCenter,  	true,  	"seq",     	false,  "",    	 dfNone     );	                  
				  InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,	"rhq",		false,	"",      dfNone     );
                  InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	false,	"mnr_inp_tp_cd_nm",	false,	"",      dfNone     );
                  InitDataProperty(0, cnt++ , dtData,			60,	    daCenter,	false,	"month",	false,	"",      dfNone     );
                  InitDataProperty(0, cnt++ , dtData,			60,	    daCenter,	false,	"acct_cd",	false,	"",      dfNone     );
                  InitDataProperty(0, cnt++ , dtData,			50,	    daCenter,	false,	"ofc_cd",	false,	"",      dfNone     );
                  InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,	"sp_cd",	false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		false,	"sp_nm",	false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"tpsz",		false,	"",      dfNone	    );   
				  InitDataProperty(0, cnt++ , dtData,			45,	    daCenter,	false,	"curr",		false,	"",      dfNone   	);
				  InitDataProperty(0, cnt++ , dtAutoSum,		65,		daRight,	false,	"ss_cnt",	false,	"",      dfNullInteger   );
				  InitDataProperty(0, cnt++ , dtAutoSum,		65,		daRight,	false,	"ss_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	false,	"sl_cnt",	false,	"",      dfNullInteger   );                                                               	
				  InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	false,	"sl_amt",	false,	"",      dfNullFloat,		2);                                                               	
                  InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,	"of_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	false,	"of_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		105,	daRight,	false,	"ns_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		105,	daRight,	false,	"ns_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		105,	daRight,	false,	"nt_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		105,	daRight,	false,	"nt_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	false,	"uh_cnt",	false,	"",      dfNullInteger   );
				  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"uh_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	false,	"ur_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"ur_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	false,	"um_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"um_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	false,	"vt_cnt",	false,	"",      dfNullInteger   );	   
				  InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	false,	"vt_amt",	false,	"",      dfNullFloat,		2);   
				  InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	false,	"le_cnt",	false,	"",      dfNullInteger   );	                  	
				  InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	false,	"le_amt",	false,	"",      dfNullFloat,		2);                 	
                  InitDataProperty(0, cnt++ , dtAutoSum,		85,		daRight,	false,	"ce_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		85,		daRight,	false,	"ce_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		65,		daRight,	false,	"re_cnt",	false,	"",      dfNullInteger   );
				  InitDataProperty(0, cnt++ , dtAutoSum,		65,		daRight,	false,	"re_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	false,	"de_cnt",	false,	"",      dfNullInteger   );
				  InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	false,	"de_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		85,		daRight,	false,	"na_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	false,	"na_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	false,	"dtl_cnt",	false,	"",      dfNullInteger   );
				  InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	false,	"est_qty",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		60,	    daRight,	false,	"hj_cnt",	false,	"",      dfNullInteger   );
                  InitDataProperty(0, cnt++ , dtAutoSum,		75,	    daRight,	false,	"hj_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		75,	    daRight,	false,	"ho_cnt",	false,	"",      dfNullInteger   );
				  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"ho_amt",	false,	"",      dfNullFloat,		2);
                  InitDataProperty(0, cnt++ , dtAutoSum,		80,	    daRight,	false,	"t_amt",	false,	"",      dfNullFloat,		2);
				  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"t_avg",	false,	"",      dfNullFloat,		2);
                									 	            
                  CountPosition = 0;	
					}
              break;
      }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = COMMAND01;     	
//				formObj.f_cmd.value = SEARCH;
				if(formObj.check_usd_only.checked){  
					formObj.curr_cd.value = "Y";    	
				} else {	
					formObj.curr_cd.value = "N";    
				}
				ComOpenWait(true);
//				sheetObj.DoSearch("EES_MNR_0121GS.do",FormQueryString(formObj));
				var sXml = sheetObj.GetSearchXml("EES_MNR_0121GS.do", FormQueryString(formObj));
//				ComOpenWait(false);
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
//                
				if (backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.RequestTimeOut = 10000;	
					timer1 = setInterval(getBackEndJobStatus, 3000);
				}
			}
			break;

		case IBCLEAR:        //초기화
			MnrWaitControl(true);
		    sheetObj.WaitImageVisible = false;
			
			//쉬트 초기화   
			for(i=0;i<sheetObjects.length;i++){   
				sheetObjects[i].RemoveAll();    
	        }  
				
			//콤보 초기화 
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].RemoveAll();        
			}  			
			
			 
			//공통콤보 정보를 가져온다.    
			var sCondition = new Array ( 
				new Array("MnrGenCd","CD00055", "COMMON"),
				new Array("MnrGenCd","","CUSTOM9"),
				new Array("MdmOrganization","RHQ","FALSE")  		
			)
			
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
			 		
		
			//Period   
			if(comboList[0] != null){   
				for(var j = 0; j < comboList[0].length;j++){  
					var tempText = comboList[0][j].split("|");
					tempText[1] = tempText[1] + '|' + 'Estimate Amt';   
					formObj.report_period_type.InsertItem(j,tempText[1] ,tempText[0]);
				}  	   
			}  
				
			//EQ Type   
			formObj.eq_type.InsertItem(0,"ALL","A");
			if(comboList[1] != null){	       
				for(var j = 0; j < comboList[1].length;j++){ 
					var tempText = comboList[1][j].split("|");  
					formObj.eq_type.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}     	    
			}     
			
			//Regional HQ  
			formObj.rhq.InsertItem(0,"ALL","A");
			if(comboList[2] != null){	       
				for(var j = 0; j < comboList[2].length;j++){	 
					var tempText = comboList[2][j].split("|"); 	 
					formObj.rhq.InsertItem(j + 1, comboList[2][j] ,tempText[0]);
				}     	    
			}		
				
			//기본값 세팅 	
	 		formObj.report_period_type.Code = "WI";    		
	 		formObj.eq_type.Code = "A";
	 		formObj.rhq.Code = "A";	 			
		  	
	 		formObj.tp_sz_cd.Enable = false;  

			formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
			MnrSetFromDate(formObj.fm_dt);			  
			formObj.to_dt.value = ComGetNowInfo();
											
			formObj.vndr_seq.value = ""; 
			formObj.vndr_lgl_eng_nm.value = ""; 
			 
			sheetObj.WaitImageVisible = true;
			MnrWaitControl(false);  				
			break;

		case IBDOWNEXCEL:
		    sheetObj.SpeedDown2Excel(-1);   
			break;	 
				
		case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				if(Number(formObj.vndr_seq.value)){
					//서비스 프로바이더 조회     	
					var sCondition = new Array ( 	 
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
					)                             
					//조회 값이 있다면 세팅
					var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
					if(comboList[0] != null){  
						var tempText = comboList[0][0].split("|");  
						formObj.vndr_lgl_eng_nm.value  = tempText[1];   
					} else {        
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
						ComSetObjValue(formObj.vndr_seq, "");   
						ComSetFocus(formObj.vndr_seq);  
					}
				} else {        
					ComShowCodeMessage("MNR00005", "Service Provider");              
					ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
					ComSetObjValue(formObj.vndr_seq, "");   
					ComSetFocus(formObj.vndr_seq);  
				}  
			}	
			break;	
				 				
		case IBSEARCH_ASYNC02:	//조회(Loc cd 입력시)
			if ( validateForm(sheetObj, formObj, sAction) ) {   
				var checkLoc = ComGetObjValue(formObj.loc_cd);	
				 	 										                   
			    retArray = MnrGeneralCodeCheck(sheetObj,"LOC",checkLoc);      
				if(retArray == null){ 					        
					ComShowCodeMessage("MNR00165",checkLoc,"LOC");          				
					ComSetObjValue(formObj.loc_cd, "");          
					ComSetFocus(formObj.loc_cd);   			                        
				}     
			}	
			break;	
			
		case IBSEARCH_ASYNC03:	//조회(RHQ 콤보 변경시)	
			sheetObj.WaitImageVisible = false;
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				formObj.ofc_cd.RemoveAll();			 
				var sCondition = new Array ( 				 
					new Array("MdmOrganization","SEARCH",formObj.rhq.Code) 
				)	  	   	                        
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
						 
				formObj.ofc_cd.InsertItem(0,"ALL","A");			  
				if(comboList[0] != null){		    
					for(var j = 0; j < comboList[0].length;j++){  
						var tempText = comboList[0][j].split("|");  
						formObj.ofc_cd.InsertItem(j + 1,comboList[0][j] ,tempText[0]);
					}		 					      
				}					
			    formObj.ofc_cd.Code = "A";				  			  		 
			}		
			sheetObj.WaitImageVisible = true;		
			break;				 				
    }
}
  
	/**
	* 조회후 처리
	*/		
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		if (ErrMsg != "") {   
			ComShowCodeMessage("MNR00057","MNR PFMC by Estimate");	
		}				
		//소계처리					
		sheetObj.ShowSubSum("4", "11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45",-1, false, false, 0,"46=(|45| / |39|)");
			
		var aFloat = parseFloat(sheetObj.SumValue(0,"t_amt") + "");										
		var bFloat = parseFloat(sheetObj.SumValue(0,"dtl_cnt") + ""); 
		var avgFloat = 0;		
		if(bFloat != 0){				
			avgFloat = parseFloat(aFloat / bFloat).toFixed(2);
		}				 						  	
		sheetObj.SumValue(0,"t_avg") = avgFloat;
	} 	

	/**  
	 * rhq Change 이벤트		      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * 
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  	
	function rhq_OnChange(comboObj,Index_Code, Text){
		var formObj  = document.form;   		    
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
	}			  	
	 
	/**  
	 * combo_eq_type_cd Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function eq_type_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		var comboValue = comboObj.Code;		 		   
		
		formObj.tp_sz_cd.RemoveAll();
		
		var selTpSz = new Array();
		if(comboValue == "U"){
			selTpSz = uTpSz;  	
		} else if(comboValue == "G"){
			selTpSz = gTpSz; 
		} else if(comboValue == "Z"){
			selTpSz = zTpSz;   
		}  	
				
		//디폴트로 올삽입
		if(selTpSz.length == 0){
	 		formObj.tp_sz_cd.Enable = false;		//tp_sz_cd
		}else{
	 		formObj.tp_sz_cd.Enable = true;			//tp_sz_cd 	 		
			formObj.tp_sz_cd.InsertItem(0,"ALL","A");   		
			for(var i = 1;i < (selTpSz.length + 1);i++){               
				formObj.tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
			}
		}
	} 
	 
	//멀티콤보 클릭 이벤트	
	function eq_type_OnCheckClick(comboObj, index, code) { 
		MnrAllChkMultiCombo(comboObj,index);    		  
	}
	  		
	//멀티콤보 클릭 이벤트
	function tp_sz_cd_OnCheckClick(comboObj, index, code) { 
		MnrAllChkMultiCombo(comboObj,index);	 	 		  
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
		formObj.eq_list.value = ''; 	
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ','; 	  
		}      
		//마지막에 ,를 없애기 위함     
		tempText = MnrDelLastDelim(tempText);	 
		tempText = tempText.toUpperCase(); 	    
						        
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
	}      	
	
	function setTpSzArray(sheetObj){ 
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
			 
		if(arrXml != null){          
		    for(var i = 0; i < arrXml.length; i++){   
				if(i == 0){	       
					uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
				} else if(i == 1){	  
					zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");  
				} else if(i == 2){	    
					gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
				}	  	 
		    }  	 
		}				
	} 	   
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
	  with(formObj){
		if(sAction==IBSEARCH) {	  	    
//			if (!ComChkValid(formObj)) return false; 
			if(!MnrChkFromDate(formObj.fm_dt)) return false;
			if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 150){
				ComShowCodeMessage("MNR00325","Period","5Months");
				return false;
			}
		} 	  	
	  }
	  return true;
	}
	
	/**
	 * EES_MNR_0016 Popup의 값을 받은 함수        
	 */	
	function setEES_MNR_0193(aryPopupData){
		var formObject = document.form;		 

		if(aryPopupData == null) return;
		formObject.loc_cd.value = aryPopupData;	 	   
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
			formObj.vndr_seq.value = aryPopupData[0][2];
			formObj.vndr_lgl_eng_nm.value  = aryPopupData[0][4];
		}	
	}		 
			
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			      //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		form); 	  //- 변경될때.
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
	 	 
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {       
	    		case "vndr_seq":  
					formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;	   
	    		case "loc_cd":	  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;	   
			}       
	    } else {
			switch(obj.name) {      
	    		case "vndr_seq":    
					ComSetObjValue(formObj.vndr_lgl_eng_nm,"") 
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
	        	ComKeyOnlyAlphabet('uppernum');   
	        break;	  
	    }
	} 	
	 
	 /**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	 function getBackEndJobStatus() {
		 var formObj = document.form;
		 var sheetObj = sheetObjects[0];

		 formObj.f_cmd.value = COMMAND02;
		 var sXml = sheetObj.GetSearchXml("EES_MNR_0121GS.do", FormQueryString(formObj));
		 var jobState = ComGetEtcData(sXml, "jb_sts_flg");

		 if (jobState == "3" ) {
			 getBackEndJobLoadFile();
			 clearInterval(timer1);
			 ComOpenWait(false);
		 } else if (jobState == "4") {
			 ComShowCodeMessage("MNR00344");
			 clearInterval(timer1);
			 ComOpenWait(false);
		 } else if (jobState == "5" ) {
			 ComShowCodeMessage("MNR00345");
			 clearInterval(timer1);
			 ComOpenWait(false);
		 }
	 }
	 
	 /**
	  * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	  */
     function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
				
		formObj.f_cmd.value = COMMAND03;	
		sheetObj.DoSearch4Post("EES_MNR_0121GS.do",FormQueryString(formObj));	
		ComOpenWait(false);	
		sheetObj.WaitImageVisible = true;
	 }
	/* 개발자 작업  끝 */  