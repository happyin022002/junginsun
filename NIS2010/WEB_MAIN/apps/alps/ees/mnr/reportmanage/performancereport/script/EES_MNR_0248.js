/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0248.js
*@FileTitle : M&R PFMC by Estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.03
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2011.02.10 김영오
* 1.0 Creation
* 2011.03.03 [W/O AMT, Labor Cost, Material Cost, G.TTL] 항목에 천자리 표시하고, 소수점을 .00으로 처리
* 2013.01.03 [CHM-201222154-01] ALPS MNR-Repair-Repair Inquiry화면에서 multi 조회 요청 건
=========================================================*/

 	/**
     * @extends	 
     * @class ees_mnr_0248 : ees_mnr_0248 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */	
    function ees_mnr_0248() {
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
			case "cre_dt_cal":
				var cal = new ComCalendarFromTo();
				cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
				break;
			case "btn_loc_cd": 	
				var eq_knd_cd = "";	 
				if(formObject.eq_type.Code != 'A'){
					eq_knd_cd = formObject.eq_type.Code;	 			
				}						  
				break;								
	        case "eq_no_multi":           
                rep_Multiful_inquiry("eq_list");	        
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
       	   		//MultiSeparator = "|"; 
		        //SetColWidth("50|150");      
			   	//DropHeight = 160;  
				//UseAutoComplete = true;
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
	    	}      
        	break;

        case 8: 
           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
       	   		SetColAlign("left|left");        
				//SetColWidth("100|150");
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
			
        case 10: 
           	with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				SetColAlign("left");
				SetColWidth("210");  
				DropHeight = 200;
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
                  style.height =  367;
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
				  
     			  var HeadTitle = "|Seq.|ACCT Code|W/O No|W/O Currency|W/O AMT"+
				  "|W/O Date|Vendor Code|Vendor Name|RHQ|Office"+
				  "|EQ No|TP/SZ|Term|Manufacturer Code|Manufacturer Name"+
				  "|Manufacturer Date|Rf Unit Maker Code|Rf Unit Maker Name|Repair Yard|Component Code"+
				  "|Component Name|Repair Code|Repair Name|Division Code|Division Name"+
				  "|Location Code|Location Name|Damage Code|Damage Name"+
				  "|currency|Man_Hour|Qty/Size|Labor Cost|Material Cost|G.TTL|Verify Result";
				  
				  var headCount = ComCountHeadTitle(HeadTitle);	 	
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true); 	
			     	 										
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)
					
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle, true);
										
                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"hdnStatus");
                  InitDataProperty(0, cnt++ , dtSeq,       	    40,     daCenter,  	true,  	"seq",     				false,  "",    	 dfNone     );	                  
				  InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,	"acct_cd",				false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			90,	    daCenter,	false,	"wo_no",				false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	false,	"wo_currency",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtAutoSum,		70,	    daRight,	false,	"wo_amt",				false,	"",      dfFloat	, 2,	false, false);
				  
				  InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,	"wo_date",				false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"vndr_seq",				false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		false,	"vndr_seq_nm",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"rhq_nm",				false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,	"ofc_cd",				false,	"",      dfNone     );
				  
				  InitDataProperty(0, cnt++ , dtData,			90,	    daCenter,	false,	"eq_no",				false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			50,	    daCenter,	false,	"eq_tpsz_cd",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	false,	"term",					false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"eq_mkr_seq",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"eq_mkr_nm",			false,	"",      dfNone     );
				  
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"manu_dt",				false,	"",      dfNone     );				  				  
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"eq_rf_mkr_seq",		false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"eq_rf_mkr_nm",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	false,	"repair_yard",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"eq_cmpo_cd",			false,	"",      dfNone     );
				  
				  InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"eq_cmpo_nm",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"eq_rpr_cd",			false,	"",      dfNone     );				  
				  InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		false,	"eq_rpr_nm",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"trf_div_cd",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"trf_div_nm",			false,	"",      dfNone     );
				    
				  InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"eq_loc_cd",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"eq_loc_nm",			false,	"",      dfNone     );				  
				  InitDataProperty(0, cnt++ , dtCombo,			100,	daCenter,	false,	"eq_dmg_cd",			false,	"",      dfNone     );
				  InitDataProperty(0, cnt++ , dtCombo,			100,	daLeft,		false,	"eq_dmg_nm",			false,	"",      dfNone,			0,		true,		true);
				  InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"currency",				false,	"",      dfNone     );
				  
				  InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	"rpr_lbr_hrs",			false,	"",      dfNone     );//man_hour
				  InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	"qty_size",				false,	"",      dfNone     );				  
				  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"lbr_cost_amt",			false,	"",      dfNullFloat	, 2,	false, false);
				  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"mtrl_cost_amt",		false,	"",      dfNullFloat	, 2,	false, false);
				  InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	false,	"e_total_amt",			false,	"",      dfNullFloat	, 2,	false, false);
				  
				  InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		false,	"verify_result",		false,	"",      dfNone     );
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
				if (sheetObj.id == "sheet1"){
					if(formObj.check_usd_only.checked){  
						formObj.curr_cd.value = "Y";    	
					} else {	
						formObj.curr_cd.value = "N";    
					}   									
					
					ComOpenWait(true,true);    
					formObj.f_cmd.value = COMMAND01; 
					sheetObj.WaitImageVisible = false;	
						
					var sXml = sheetObj.GetSearchXml("EES_MNR_0248GS.do", FormQueryString(formObj));
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobkey");	
					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 10000;	
						timer1 = setInterval(getBackEndJobStatus, 3000);
					}
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
				new Array("MdmOrganization","RHQ","FALSE"),
				new Array("MnrGenCd","CD00083", "COMMON"),	//Account Code	
				new Array("MnrGenCd","CD00084", "COMMON"),	//EQ Term
				new Array("MnrGenCd","CD00080", "COMMON"), 	//Demage
				new Array("MnrGenCd","CD00004", "COMMON") 	//Verify Result
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
			
			//Account Code 세팅        
			formObj.acct_cd.InsertItem(0,"ALL","A");		  
			if(comboList[3] != null){	    
				for(var j = 0; j < comboList[3].length;j++){  
					var tempText = comboList[3][j].split("|");  
					formObj.acct_cd.InsertItem(j + 1,comboList[3][j] ,tempText[0]);
				} 					      
			}	
						
			//EQ Term	 
			formObj.lstm_cd.InsertItem(0,"ALL","A");			
			if(comboList[4] != null){		       
				for(var j = 0; j < comboList[4].length;j++){	 
					var tempText = comboList[4][j].split("|"); 	 
					formObj.lstm_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}     	    
			}	
			
			//Verify Result	 
			formObj.verify_result.InsertItem(0,"ALL","A");			
			if(comboList[6] != null){		       
				for(var j = 0; j < comboList[6].length;j++){	 
					var tempText = comboList[6][j].split("|"); 	 
					formObj.verify_result.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}     	    
			}
			
			//Manufacturer, RF Unit Maker
			formObj.f_cmd.value = SEARCH01;
			var xmlStr = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
		    var chk = xmlStr.indexOf("ERROR");
			if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
			    sheetObj.LoadSearchXml(xmlStr);
			    return;
		    }
			var sStr = ComGetEtcData(xmlStr, "comboList");
			var arrStr = sStr.split("@");
			MakeComboObject(formObj.mftr_vndr_seq, arrStr, 1, 0);  
			MakeComboObject(formObj.unit_vndr_seq, arrStr, 1, 0);  
			
			//기본값 세팅 	
	 		formObj.report_period_type.Code = "WI";    		
	 		formObj.eq_type.Code = "A";		
	 		formObj.acct_cd.Code = "A";		
	 		formObj.lstm_cd.Code = "A";
	 		formObj.rhq.Code = "A";	
			formObj.manu_vndr_seq.Code = "A";
			formObj.unit_vndr_seq.Code = "A"; 			
		  	
	 		formObj.tp_sz_cd.Enable = false;
			formObj.check_usd_only.checked=false;

			formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
			MnrSetFromDate(formObj.fm_dt);			  
			formObj.to_dt.value = ComGetNowInfo();
			
			formObj.from_date.value = ""; 
			formObj.to_date.value = "";
			formObj.vndr_lgl_eng_nm.value = "";
			formObj.eq_list.value = "";

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
			ComShowCodeMessage("MNR00057","MNR PFMC by Eq No");	
		}				
		
		//W/O AMT, Labor Cost , Material Cost , G.TTL null인경우 "0"으로  셋팅
		if(sheetObj.RowCount>0){
    		for(i=sheetObj.LastRow; i > 0 ; i--){
		 		if(sheetObj.CellValue(i,  "wo_amt")=="")	{
					sheetObj.CellValue2(i,  "wo_amt") = "0";
				}
		 		if(sheetObj.CellValue(i,  "lbr_cost_amt")=="")	{
					sheetObj.CellValue2(i,  "lbr_cost_amt") = "0";
				}
		 		if(sheetObj.CellValue(i,  "mtrl_cost_amt")=="")	{
					sheetObj.CellValue2(i,  "mtrl_cost_amt") = "0";
				}
		 		if((sheetObj.CellValue(i,  "lbr_cost_amt")=="0")&&(sheetObj.CellValue(i,  "mtrl_cost_amt")=="0"))	{
					sheetObj.CellValue2(i,  "e_total_amt") = "0";
				}
			}
		}
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
	  	 
    //멀티콤보 클릭 이벤트
	function verify_result_OnCheckClick(comboObj, index, code) { 
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
		  switch(sAction) {
			  case IBSEARCH: 
				    var inputDateBet = ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value);
					if(formObj.eq_list.value != ""){
						if(inputDateBet > 1095){  
							ComShowCodeMessage("MNR00383");   	   
							formObj.fm_dt.value = ComGetDateAdd(formObj.to_dt.value, "D", -1095);
							return false;
						}
					}else{
						//input date 30일 넘지 않게 2012-03-22
						if(inputDateBet > 30){  
							ComShowCodeMessage("MNR00335");   	   
							formObj.fm_dt.value = ComGetDateAdd(formObj.to_dt.value, "D", -30);
							return false;
						}
					}
				 	break; 		
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
		var sXml = sheetObj.GetSearchXml("EES_MNR_0248GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");

		if (jobState == "3") {
			getBackEndJobLoadFile();			
			clearInterval(timer1);			
			ComOpenWait(false);
		} else if (jobState == "4") {
			ComShowCodeMessage("MNR00344");
			clearInterval(timer1);	
			ComOpenWait(false);
		} else if (jobState == "5") {
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
		sheetObj.DoSearch4Post("EES_MNR_0248GS.do",FormQueryString(formObj));	
		ComOpenWait(false);	
		sheetObj.WaitImageVisible = true;
	}	
	
	/**
 	 * 콤보 오브젝트 생성(Manufacturer, RF Unit Maker)
 	 */
 	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
 		var formObj  = document.form;
		formObj.manu_vndr_seq.RemoveAll();
		formObj.manu_vndr_seq.InsertItem(0,"ALL","A");
 		formObj.manu_vndr_seq.SetColAlign("left|center");
		formObj.unit_vndr_seq.RemoveAll();
		formObj.unit_vndr_seq.InsertItem(0,"ALL","A");
 		formObj.unit_vndr_seq.SetColAlign("left|center");
		
 		for (var i=0; i<arrStr.length; i++) {
 			var arrCode = arrStr[i].split("|");
 			formObj.manu_vndr_seq.InsertItem(i+1, arrCode[txtCol] + '|' + arrCode[codeCol], arrCode[codeCol]);
			formObj.unit_vndr_seq.InsertItem(i+1, arrCode[txtCol] + '|' + arrCode[codeCol], arrCode[codeCol]);
 		}
 	}  
	
	/* 개발자 작업  끝 */  