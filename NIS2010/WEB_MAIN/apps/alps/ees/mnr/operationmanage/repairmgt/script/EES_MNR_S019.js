/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S019.js
*@FileTitle : SPP Repair Estimate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박명신
*@LastVersion : 1.0    
* 2009.07.01 박명신 
* 1.0 Creation      
* -------------------------------------------------------
* History
* 2011.05.02 박명신 [선처리] Equipment Management > M&R > Repair > Estimate 첨부 파일 사라지는 현상 수정
* 2011.07.13 김종옥 [CHM-201112217-01] SPP에서도 MNR에서, Repair Estimate Creation/WO Creation and Auditting 시 , Varify Result 결과에 point 요청
* 2011.12.27 신혜정 [CHM-201115280] Reefer Uint Maker 필드 추가  
* 2012.11.09 조경완 [ICM-201200829] 환경변수 설정
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
* 2015.09.14 이율규 [CHM-201537843] MNR Estimate 생성 시 조회 조건 변경 로직 수정(검색조건 추가: Request DT // 트랜잭션 후 자동 조회 기능 삭제(Save, Request)
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
     * @class EES_MNR_S019 : EES_MNR_S019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_S019() {
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

var DLCSheets = new Array();
var DLCSheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0; 
	
//메세지를 구분하기 위한  IBSAVE/IBBATCH
var saveType = ""; 

//sp_name 콤보의 실제 데이타  객체  	
var sp_name = new spNameList();     	
 
//sp_name 콤보의 이전 값을 기억하기 위한
var preSpNameCode = "";  	
//조회여부 (조회후 삭제 가능)
var selCheck = false;

//Repair Work Type 콤보 코드  
var rwTypedefCode = "";   

//파일업로드를 사용하기 위한 
var uploadObjects = new Array();
var uploadCnt = 0;

//파일Seq저장변수 (추가될때 )
var uploadFileSeq = "";   

//onchange event 탈지 여부  
var enableOnChange = true;     

//t1sheet1 이벤트 
var dummyEvent = false; 

var sheetComboList = new Array();    

//로케이션 팝업 클릭된 로우를 찾기 위해서
var t1sheet1ClickRow = 0; 

//벨리데이션을 수행할것인지 플레그 멀티 confirm 추가 
var isValidNeed = true;       

var chkEqNo = "";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
         
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) { 
				case "btn_period" :  
					var cal = new ComCalendarFromTo();  	       
					cal.select(formObject.req_st_dt,  formObject.req_end_dt,  'yyyy-MM-dd'); 
					break;
				case "btn_Retrieve":  
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH); 
					break;
					
				case "btn_New": 
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR); 
					break;
					
				case "btn_Delete":	 
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCHAPPEND);   
					break;  	
						
				case "btn_Save":
					if(formObject.apro_ofc_cd.value == "MEXBA"){
						ComShowCodeMessage("MNR00357");		
						break; 
					}
					doActionIBSheet(sheetObjects[2],formObject,IBSAVE); 	
					break; 
					
				case "btn_Request":	 	  
					doActionIBSheet(sheetObjects[2],formObject,IBCREATE);  	
					break;	   
				
				case "btn_Print":
					if(!selCheck){		  
						ComShowCodeMessage("MNR00243");  	
					} else {
						var eqno = ComGetObjValue(formObject.rqst_eq_no);
						var seq = ComGetObjValue(formObject.rpr_rqst_seq);  
						var verNo = ComGetObjValue(formObject.rpr_rqst_ver_no);
									
						var rdParam = '/rv rqst_eq_no[' + eqno + '] rpr_rqst_seq[' + seq + '] rpr_rqst_ver_no[' + verNo + '] is_tpb[N]';
						formObject.com_mrdArguments.value =	rdParam;
						formObject.com_mrdBodyTitle.value = "Repair Estimate";
						ComOpenRDPopup();		
					}		
					break;
				
				case "btn_RowDel": 	 
					doActionIBSheet(sheetObjects[2],formObject,IBDELETE);  
					break;
					
				case "btn_RowAdd":	  
					doActionIBSheet(sheetObjects[2],formObject,IBINSERT);    
					break;
					
				case "btn_DownExcel": 
					sheetObjects[2].SpeedDown2Excel(-1);  
					break;
			
				case "btn_FileAdd":  
					file_Insert(sheetObjects[10]);
					break;
					
				case "btn_FileDel": 
					file_Remove(sheetObjects[10]);       
					break; 
				
			 	case "btns_calendar":         
                	var cal = new ComCalendar();      
                	cal.select(formObject.eq_dmg_dt, 'yyyy-MM-dd');
                	break;		
				//야드 팝업 	
				case "btns_popup":                 
                    ComOpenPopup('/hanjin/COM_ENS_061.do', 766, 450, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;	
				//EQ_INFO DETAIL정보 	 	
				case "btn_detail": 
					if(formObject.rqst_eq_no.value != ""){ 			 		   
						 ComOpenWindowCenter("EES_MNR_0191.do?eq_no=" + formObject.rqst_eq_no.value + "&mnr_wo_tp_cd=EST", "EES_MNR_0191", 901, 495, true);	   			       				   
					}
                    break;	
				case "rpr_offh_flg_temp":	
						doActionIBSheet(sheetObjects[2], formObject , IBSEARCH_ASYNC02);	
					break;	
				case "btn_calc":				
						doActionIBSheet(sheetObjects[2], formObject , IBBATCH);	
					break;
				case "btn_Acep_Pop":
					if(formObject.rqst_eq_no.value != ""){
						var popParam = "";
						popParam = popParam + "?rqst_eq_no=" + formObject.rqst_eq_no.value;
						popParam = popParam + "&rpr_rqst_seq=" + formObject.rpr_rqst_seq.value;
						popParam = popParam + "&mnr_wo_tp_cd=" + "EST";
						
						ComOpenWindowCenter("EES_MNR_0061.do" + popParam, "EES_MNR_0061", 1020, 700, true);
					}
					break;
				case "btn_Upload":					
					ComOpenWindowCenter("/hanjin/EES_MNR_0243.do?req_ui=EES_MNR_S019", "EES_MNR_0243", 850, 500, true);
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
     * sp_name 콤보 사용을 위한 객체배열 
     */
	function spNameList(){
		this.items = [];		
	}
	
	/**
     * sp_name 콤보 사용을 위한 객체 
     */ 
	function itemEntity(vndr_seq,vndr_nm,agmt_no,agmt_ver_no,eff_dt,exp_dt,trf_no,agmt_ref_no,eq_knd_cd,curr_cd,trsm_mod_cd,edi_id,mnr_meas_ut_nm){
		this.vndr_seq           = vndr_seq;         
		this.vndr_nm	        = vndr_nm;	        
		this.agmt_no            = agmt_no;         
		this.eff_dt	        	= eff_dt;	        
		this.exp_dt             = exp_dt;          
		this.agmt_ref_no		= agmt_ref_no;      
		this.trf_no             = trf_no;          
		this.agmt_ver_no        = agmt_ver_no;     
		this.eq_knd_cd	        = eq_knd_cd;	
		this.curr_cd            = curr_cd;         
		this.trsm_mod_cd		= trsm_mod_cd;  
		this.edi_id				= edi_id;   
		this.mnr_meas_ut_nm     = mnr_meas_ut_nm; 
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
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	*/
	function setUploadObject(uploadObj){
		
	   uploadObjects[uploadCnt++] = uploadObj;
	}
		
	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = "";
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {  
		MnrWaitControl(true);  
		initControl();  
		
		//0번은 히든 데이타 조회용
		//2012.11.09 조경완 [ICM-201200829] 환경변수 설정
	    ComConfigSheet(sheetObjects[0]);
		initSheet(sheetObjects[0],1);
		ComEndConfigSheet(sheetObjects[0]);

		DLCSheetCnt = 0; 
        for(i = 1;i < sheetObjects.length;i++){ 
    			//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i]); 
						
				initSheet(sheetObjects[i],i + 1);
				//khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);     
            		 	   		
				if(sheetObjects[i].id.substring(0,2) == "t2" && sheetObjects[i].id != "t2_sheet8"){       
					DLCSheets[DLCSheetCnt++] = sheetObjects[i];  	
				} 	
        }		 		
						 
		for(k = 0;k < tabObjects.length;k++){
			initTab(tabObjects[k],k + 1); 
		}
			   		
		for(k = 0;k < comboObjects.length;k++){ 
            initCombo(comboObjects[k],k + 1);   
        } 
					
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS_THUMBNAIL.do");  		  		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		formObj.req_st_dt.value = ComGetDateAdd(ComGetNowInfo(), "D", -90);
		formObj.req_end_dt.value = ComGetNowInfo();
		
		ComBtnDisable("btn_Acep_Pop");
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
				   	   SetTitle("AGMT No|AGMT Office|EQ TYPE|Effective Date|Reference No|Tariff No"); 
				       SetColAlign("center|center|left|center|left|left");   
					   SetColWidth("90|90|70|155|140|150");		 	                                                   
					   DropHeight = 160;                  
			       }  	 
	           break;   
			       			 	
			   default :   
		           with (comboObj) { 
			       }   	   
	           break;	 	
	     } 		
	} 
	
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo){	 
		switch(tabNo) { 	
				case 1:
					with (tabObj) { 
						var cnt  = 0 ;
						InsertTab( cnt++ , "Repair Info." , -1 ); 
						InsertTab( cnt++ , "Image Info." , -1 );    
					}   
					break;  

		}  
		var formObj = document.form; 
		 				   
		if(formObj.eq_knd_cd.Code == 'U'){       
			var div1 = document.all.item("t2_selection1");	 	
			var div2 = document.all.item("t2_selection2");
			div1.style.display = "inline";     		
			div2.style.display = "inline";        
		} else {
			var div1 = document.all.item("t2_selection1");	 	
			var div2 = document.all.item("t2_selection2");
			div1.style.display = "none";     		
			div2.style.display = "none";                    		 
		}    
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
					style.height = 162; 
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
								
					var HeadTitle1 = "|Sel|Seq.|Status|EQ Type|EQ No.|TP/SZ|Input|S/P|Estimate No.|Office|T/Amount|Status DT|Request DT|Sold Flag";
												
					var headCount = ComCountHeadTitle(HeadTitle1);									
					 			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount + 18, 6, 0, true);     	
										
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
					InitHeadRow(0, HeadTitle1, true);		 
								
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,	dtHiddenStatus,	 50,    daCenter,  	false,  "ibflag");
					InitDataProperty(0, cnt++,  dtCheckBox,		 40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++,  dtSeq,    		 30, 	daCenter,   true,   "Seq");    
					InitDataProperty(0,	cnt++,	dtCombo,		113,	daLeft,		true,	"rpr_sts_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,		 60,	daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 80,	daCenter,	true,	"rqst_eq_no",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 40,	daCenter,	true,	"eq_tpsz_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,		 60,	daLeft,		true,	"mnr_inp_tp_cd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			120,	daLeft,		true,	"vndr_nm",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	true,	"rqst_ref_no",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 50,	daCenter,	true,	"cost_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 80,	daRight,	true,	"total_amt",		false,	"",	dfNullFloat,		2,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 60,	daCenter,	true,	"upd_dt",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 60,	daCenter,	true,	"rqst_dt",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			 60,	daCenter,	true,	"sold_eq",			false,	"",	dfNone,		0,	false,	false);
					//HIDDEN DATA					
					//VERNER 용 
					InitDataProperty(0, cnt++ , dtHidden,   	  0,	daCenter,  	false,  "vndr_seq",        false,           "",      dfNone,    0,     false,       false);
										
					//AGMT 용	 	
					InitDataProperty(0, cnt++ , dtHidden,		  0,	daCenter,  	false,  "agmt_ofc_cty_cd",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "agmt_seq",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "agmt_ver_no",        false,           "",      dfNone,    0,     false,       false);
										
					//기타 히든데이타 용 	
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "rpr_yd_cd",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "eq_dmg_dt",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "rpr_offh_flg",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "mnr_rpr_rmk",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "vrfy_rslt_rmk",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "file_seq",        	false,           "",      dfNone,    0,     	  false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "apro_ofc_cd",        false,           "",      dfNone,    0,     false,       false);
											
					//MNR_RPR_RQST_HDR	키값  rqst_eq_no	rpr_rqst_seq  rpr_rqst_ver_no	
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "rpr_rqst_seq",        false,           "",      dfNone,    0,       false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "rpr_rqst_ver_no",        false,           "",      dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "rpr_dtl_sts_cd",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0,	cnt++,	dtHidden,		  0,	daLeft,		true,	"rpr_wrk_tp_cd",			false,	"",	dfNone,		0,				 false,	false);
					
					//AUDITING 용 
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "auto_amt",        false,           "",      dfNone,    0,        false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "appoval_amt",        false,           "",      dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		  0,	daCenter,  	false,  "uppr_ofc_cd",        false,           "",      dfNone,    0,     false,       false);										  																																					
					 											 				 			
    				ColFontColor("TP") = RgbColor(255,0,0);
											 	 
					MultiSelection = false;		 	
					//SELECT 로우 배경색          
					SelectionMode = smSelectionRow;   
					SelectHighLight = true;           
					SelectFontBold = false;           
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					CountPosition = 0;  	  
				} 			
				break;
				  
			case "t1sheet1":      // sheet1 init
                with (sheetObj) {
					// 높이 설정
					//style.height = 182;
                	style.height = 242;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
							
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 100);
						
					var HeadTitle1 = "|Sel|Seq.|Mandatory Code|Mandatory Code|Mandatory Code|Mandatory Code|Option|Volume|Volume|Volume|Labor|Labor|Labor|Material|Amount|Verify Result|Lessor Account|TPB Request|TPB Labor|TPB Labor|TPB Labor|TPB Material|TPB Amount";
					var HeadTitle2 = "|Sel|Seq.|Location|Component|Damage|Repair|Division|Type|QTY|Size/Square|Hour|Rate|Cost|Material|Amount|Verify Result|Lessor Account|TPB Request|Hour|Rate|Cost|TPB Material|TPB Amount";
												
					var headCount = ComCountHeadTitle(HeadTitle1);									
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount + 12, 0, 0, true);    
													
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) 
					 						
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);	
					InitHeadRow(1, HeadTitle2, true);	  
																		
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	"ibflag");	
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,		true,	"del_chk");		
					InitDataProperty(0, cnt++ , dtDataSeq,	 	30,		daCenter,		true,	"Seq");			
					InitDataProperty(0,	cnt++,	dtPopupEdit,	80,		daCenter,		true,	"eq_loc_cd",		true,	"",	dfNone,		0,	true,	true ,4 ,true );  
					InitDataProperty(0, cnt++ , dtComboEdit,	85,		daCenter,		true,	"eq_cmpo_cd",		true,	"",	dfNone,			0,	true,	true,	3,	true);
	                InitDataProperty(0,	cnt++,	dtComboEdit,	70,		daCenter,		true,	"eq_dmg_cd",		true,	"",	dfNone,		0,	true,	true,	2,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,	70,		daCenter,		true,	"eq_rpr_cd",		true,	"",	dfNone,			0,	true,	true,	2,	true);
	                InitDataProperty(0, cnt++ , dtCombo,  		80,		daCenter,		true,	"trf_div_cd",		false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,  		50,		daLeft,			true,	"vol_tp_cd",		true,	"",	dfNone, 		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,  		40,		daRight,		true,	"rpr_qty",			false,	"",	dfNullInteger, 	0,	true,	true,	6,	false);
	                InitDataProperty(0, cnt++ , dtData,  		85, 	daRight,		true,	"rpr_sz_no",		false,	"",	dfNullInteger, 	0,	true,	true,	10,	false);
											
					InitDataProperty(0, cnt++ , dtAutoSum,  	50,		daRight,		true,	"rpr_lbr_hrs",		false,	"",	dfNullFloat, 		2,	true,	true,	6,	false); 
					InitDataProperty(0,	cnt++,	dtData,			50,		daRight,		true,	"rpr_lbr_rt",		false,	"",	dfNullFloat,		2,	true,	true, 	7,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"lbr_cost_amt",		false,	"Round(|rpr_lbr_hrs|*|rpr_lbr_rt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		70,		daRight,		true,	"mtrl_cost_amt",	false,	"",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		60,		daRight,		true,	"mnr_wrk_amt",		false,	"Round(|lbr_cost_amt|+|mtrl_cost_amt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtCombo,		140,	daLeft,			true,	"mnr_vrfy_tp_cd",				false,	"",	dfNone,			0,	false,	false);																
					InitDataProperty(0,	cnt++,	dtCheckBox,		110,	daCenter,		true,	"mnr_lr_acct_flg",	false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtCheckBox,		90,		daCenter,		true,	"n3pty_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"n3pty_bil_lbr_hrs",false,	"",	dfNullFloat,		2,	true,	true,	6,	false); 
					InitDataProperty(0,	cnt++,	dtData,		50,		daRight,		true,	"n3pty_bil_lbr_rt",	false,	"",	dfNullFloat,		2,	true,	true, 	7,	false);	
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"n3pty_lbr_cost_amt",false,	"Round(|n3pty_bil_lbr_hrs|*|n3pty_bil_lbr_rt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		80,		daRight,		true,	"n3pty_bil_mtrl_cost_amt",		false,	"",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		80,		daRight,		true,	"n3pty_bil_amt",				false,	"Round(|n3pty_lbr_cost_amt|+|n3pty_bil_mtrl_cost_amt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
								  		
					//********* hiddent value				 	
					//basic 데이타 저장용	  
					//타리프 hour basic
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daRight,		true,	"rpr_lbr_bzc_hrs",			false,	"",	dfFloat,		2,	false,	false);
					//어그리먼트 rate basic
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daRight,		true,	"rpr_lbr_bzc_rt",			false,	"",	dfFloat,		2,	false,	false);
					//둘이 곱한거 basic
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daRight,		true,	"mnr_lbr_bzc_amt",			false,	"",	dfFloat,		2,	false,	false);
					//타리프 material basic
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"lbr_mtrl_bzc_amt",			false,	"",	dfFloat,		2,	false,	false);
					//전체 더한거 basic
					InitDataProperty(0,	cnt++,	dtHidden,		60,		daRight,		true,	"mnr_agmt_amt",				false,	"",	dfFloat,		2,	false,	false);
																	
					//data verify 용	 
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_loc_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_cmpo_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_dmg_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_rpr_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					
					//어그리먼트 조회용			 
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"cost_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"cost_dtl_cd",		false,	"",	dfNone,		0,	true,	true);
					
					//Desc. 용 	
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"rpr_dtl_rmk",		false,	"",	dfNone,		0,	true,	true);  

					ColFontColor("Component") = RgbColor(255,0,0);        	
									
					//데이터 Validation
					InitDataValid(0,  "eq_loc_cd", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789"); 
					InitDataValid(0,  "eq_rpr_cd", vtEngUpOther,"0123456789");   
										
					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true;           
					
					//추가 요청 사항  EDI 데이타를 위해서 콤보에 매치되지 않는데이타도 보여줘야 된다.
					InitComboNoMatchText(true);  
					 		 
					PopupImage  =  "/hanjin/img/btns_search.gif";  
					ShowButtonImage = 2; 	 
					CountPosition = 0;
										
					MessageText("Sum") = ""; 
				}	
				break;
							
            case "t2_sheet1": 
            case "t2_sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 102; 
                    // 전체 너비 설정
                    SheetWidth = 120; //mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 4, 10, 100);

		    		var HeadTitle1 = "";
		    		if(sheetObj.id == 't2_sheet1')
		    			HeadTitle1 = "|1|2|3|4";
		    		else
		    			HeadTitle1 = "|4|3|2|1";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 1, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"Status");
					var RowText = "H|T|B|G";
					var RowVals = RowText.split("|");
					var widthVals = new Array(21,21,21,21);
					var ColVals = HeadTitle1.split("|"); 
					
					for(var i = 0; i < 4 ; i++){
						InitDataProperty(i, 0 , dtData,		22,		daCenter,	false,	"Left");
						for(var j = 1 ; j < 5 ; j++){
							InitDataProperty(i,	j,	dtCheckBox,		widthVals[j - 1],	daCenter,	true,	"DLC");
				    		if(sheetObj.id == 't2_sheet1')
				    			ToolTipText(i + 1,j) = "D"+RowVals[i]+ColVals[j];
				    		else
				    			ToolTipText(i + 1,j) = "F"+RowVals[i]+ColVals[j];
							
						}
						//RowHeight(i + 1) = widthVals[i];
					}	
						
					CountPosition = 0;
					ScrollBar = 0;
					InitHeadColumn("Left", RowText, daCenter);
					
					MultiSelection = true;	
					SelectionMode = smSelectionCol;	     
					SelectHighLight = false;
			  	}
				break;  
            case "t2_sheet3":
            case "t2_sheet4":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 102;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 4, 10, 100);
					
		    		var HeadTitle1 = "";
		    		if(sheetObj.id == 't2_sheet3')
		    			HeadTitle1 = "|0|9|8|7|6|5|4|3|2|1";
		    		else
		    			HeadTitle1 = "|1|2|3|4|5|6|7|8|9|0";
                    var headCount = ComCountHeadTitle(HeadTitle1);


                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 1, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var RowText = "H|T|B|G";
					var RowVals = RowText.split("|");
					var widthVals = new Array(20,30,30,20);
					var ColVals = HeadTitle1.split("|");
					
					for(var i = 0; i < 4 ; i++){
						InitDataProperty(i, 0 , dtData,		20,		daCenter,	false,	"Left");
						for(var j = 1 ; j < 11 ; j++){
							InitDataProperty(i,	j,	dtCheckBox,		20,	daCenter,		true,	"DLC");
				    		if(sheetObj.id == 't2_sheet3')
				    			ToolTipText(i + 1,j) = "L"+RowVals[i]+ColVals[j];
				    		else
				    			ToolTipText(i + 1,j) = "R"+RowVals[i]+ColVals[j];
						}
						//RowHeight(i + 1) = widthVals[i];
					}
					CountPosition = 0;
					ScrollBar = 0;
					InitHeadColumn("Left", RowText, daCenter);
					
					MultiSelection = true;	
					SelectionMode = smSelectionCol;
					SelectHighLight = false;
			  	}
				break;
            case "t2_sheet5":
            case "t2_sheet6":
            case "t2_sheet7":
                with (sheetObj) {	
                    // 높이 설정
                    style.height = 63; 
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 2, 10, 100);

		    		var HeadTitle1 = "|1|2|3|4|5|6|7|8|9|0";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 1, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				    //InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"Status");
				 	var RowText = "L|R";
					var RowVals = RowText.split("|");
					var ColVals = HeadTitle1.split("|");
							
					for(var i = 0; i < 2 ; i++){
						InitDataProperty(i, 0 , dtData,		20,		daCenter,	false,	"Left");
						for(var j = 1 ; j < 11 ; j++){
							InitDataProperty(i,	j,	dtCheckBox,		20,	daCenter,	true,	"DLC");
							if(sheetObj.id == 't2_sheet5')
								ToolTipText(i + 1,j) = "T"+RowVals[i]+ColVals[j];
							else if(sheetObj.id == 't2_sheet6')
								ToolTipText(i + 1,j) = "B"+RowVals[i]+ColVals[j];
							else 
								ToolTipText(i + 1,j) = "U"+RowVals[i]+ColVals[j];
						}
					}
					
					CountPosition = 0;
					ScrollBar = 0;
					InitHeadColumn("Left", RowText, daCenter);
					MultiSelection = true;	
					SelectionMode = smSelectionCol;
					SelectHighLight = false;
				}	    
					break;
				//파일 업로드   		
			    case "t2_sheet8" :
					with(sheetObj) {
						// 높이 설정
						var prefix = "";   
						
//						style.height = 62;
//						// 전체 너비 설정
////						SheetWidth = mainTable.clientWidth;
//						SheetWidth = 280;
						
						style.height = 262; 
						// 전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
								
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;	
							
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 10, 100);
							
						var HeadTitle1 = "|Photo Attachment|Photo Attachment|Photo Attachment";
						var HeadTitle2 = "|Seq.|File|Download";
									
						var headCount = ComCountHeadTitle(HeadTitle1);									
							
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(8, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true); 
						InitHeadRow(1, HeadTitle2, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	 prefix +	"ibflag");
						InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 prefix +	"del_chk")
						InitDataProperty(0, cnt++ , dtPopup,      	170,    daCenter,  false,   prefix + "org_file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
						InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  false,   prefix + "file_dw",   false,          "",      dfNone,      0,     false,		true);
						InitDataProperty(0, cnt++ , dtHidden,     	0,    daCenter,  false,   prefix + "file_path_nm",   	false,          "",      dfNone,      0,     true,      true);
						InitDataProperty(0, cnt++ , dtHidden,     	0,    daCenter,  false,   prefix + "file_path",   	false,          "",      dfNone,      0,     true,      true);
						InitDataProperty(0, cnt++ , dtHidden,     	0,    daCenter,  false,   prefix + "file_seq",   		false,          "",      dfNone,      0,     true,      true);										
						InitDataProperty(0, cnt++ , dtHidden,	 	0,		daLeft,		true,  prefix +	"file_dtl_seq",	   false,		"",		 dfNone,		0,			false,		false);
		 						
						CountPosition = 0;
						
	                    ImageList(0)= "/hanjin/img/ico_attach.gif";
	                    
						ShowButtonImage = 1;    
					}
					break;  
        }
    }
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false; 
        switch(sAction) {  
			 case IBSEARCH:      //목록조회   rqst_type  
                 if(validateForm(sheetObj,formObj,sAction)){    
				 	if(sheetObj.id =="sheet2"){	    
						var f_query = '';         
						f_query += 'f_cmd' + '=' + SEARCH + '&'; 
						f_query += 'cost_ofc_cd=' +  formObj.cost_ofc_cd.value  + '&'; 
						f_query += 'vndr_seq=' +  formObj.vndr_seq.value  + '&';
						f_query += 'rqst_type=' +  formObj.rqst_type.value  + '&';
						f_query += 'req_st_dt=' +  formObj.req_st_dt.value  + '&';
						f_query += 'req_end_dt=' +  formObj.req_end_dt.value;   
         				sheetObj.DoSearch4Post("EES_MNR_S019GS.do",f_query); 
					}	 			   	   		   
				  }         
                break; 	
					
			case IBROWSEARCH:      //건당 상세 조회    
                 if(validateForm(sheetObj,formObj,sAction)){ 
					 	formObj.f_cmd.value = SEARCH01;         
																										          
					    sParam = FormQueryString(formObj);     
					    var sXml = sheetObj.GetSaveXml("EES_MNR_S019GS.do", sParam);
						sheetObj.Redraw = false;
					    sheetObjects[2].LoadSearchXml(sXml); 
						var arrResult = MnrXmlToArray(sXml); 
						sheetObjects[2].SumText(0,"eq_loc_cd") = "TOTAL"; 
						setCommonSheetEdit(sheetObjects[2],arrResult);  
						sheetObj.Redraw = true;			 	 
											
						//값이 모자른 부분은 조회해온데서 가져온다.	  
						ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml, "rqst_dt"));
						ComSetObjValue(formObj.eq_dmg_dt, ComGetEtcData(sXml, "eq_dmg_dt"));
						ComSetObjValue(formObj.rqst_usr_nm, ComGetEtcData(sXml, "rqst_usr_nm"));
						ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml, "rqst_usr_id"));
						formObj.mnr_desc.value = "";
						    					
						//추가요청 추가분	 	
						var n3CheckFlag = false;
						for(var j = 2; j <= sheetObj.LastRow - 1;j++){    
							if(sheetObj.CellValue(j,"n3pty_flg") == "1"){
								n3CheckFlag = true; 					
							}	 	  	 						
						}					
						if(n3CheckFlag){	 	   
							document.form.n3pty_flg.value = "Y";    	
						} else {	  	
							document.form.n3pty_flg.value = "N";  
						} 
				  }        
                break; 		
			
			case IBSEARCHAPPEND:      //삭제 로직   
                 if(validateForm(sheetObj,formObj,sAction)){ 
				 		saveType = "REMOVE";   
					 	formObj.f_cmd.value = REMOVE;  
																							          
					    sParam = FormQueryString(formObj);      
					    var sXml = sheetObj.GetSaveXml("EES_MNR_S019GS.do", sParam);
					    sheetObjects[1].LoadSaveXml(sXml);   
								
											 
						//IBCLEAR와 동일한 역활   	
						MnrWaitControl(true);   
						selCheck = false;   
						//폼 초기화 
						setEqInfoClear();
						
						//eq_dmg_dt에 값이 있다면 초기화 하지 않는다.
						var tempEqDmgDt = MnrNullToBlank(ComGetObjValue(formObj.eq_dmg_dt));

						//차후에 하나씩 개별로  
						formObj.reset();    
						//다시 세팅되어야 할 값들            
						//formObj.rqst_type.value = "rqst_cre";
						MnrFormSetReadOnly(formObj,false,"rqst_eq_no"); 
						
						//eq_dmg_dt
						if(tempEqDmgDt == ''){    
							formObj.eq_dmg_dt.value = ComGetNowInfo("ymd");	
						} else { 
							formObj.eq_dmg_dt.value = tempEqDmgDt;	  
						}
							
						//rqst_dt    Input Date
						formObj.rqst_dt.value = ComGetNowInfo("ymd");  				
							
				 		formObj.req_st_dt.value = ComGetDateAdd(ComGetNowInfo(), "D", -90);
						formObj.req_end_dt.value = ComGetNowInfo();
						
						//초기화 하지 않으므로 값 다시 세팅 
						setComboValue();
							
						formObj.sp_name.enable = true;    
						formObj.eq_knd_cd.enable = false;      
						formObj.trsm_mod_cd.enable = false;  
									  
						//쉬트 초기화	 	  	
						sheetObjects[2].RemoveAll();     
						sheetObjects[2].SumText(0,"eq_loc_cd") = "TOTAL";
						MnrWaitControl(false);
				  }   		     
                break;		 
								
			case IBSAVE:        //저장
	              if(validateForm(sheetObj,formObj,sAction)){
				  		saveType = "IBSAVE";   
						formObj.f_cmd.value = MODIFY; 
						if(uploadFileSeq != undefined){
							formObj.file_seq.value = uploadFileSeq; 	
						}
 																			          
						var sParam = sheetObj.GetSaveString(true, true); 
						//멘덴토리 체크        
						if(sParam == "" && sheetObj.IsDataModified){ 
							return; 		
						} 
						sParam = ComSetPrifix(sParam,"rqstDtl_");      
									
					    sParam += "&" + FormQueryString(formObj); 
					    var sXml = sheetObj.GetSaveXml("EES_MNR_S019GS.do", sParam);
					 	   
					    
					    //2015.09.14 이율규 [CHM-201537843]MNR Estimate 생성 시 조회 조건 변경 로직 수정 - start
					    
//					    if(sXml.indexOf("<ERROR>") == -1){
//					    	ComShowCodeMessage("MNR00023");
//					    	
//					    	for(var i = 0; i < sheetObjects[1].Rows; i++){
//					    		if(sheetObjects[1].CellValue(i, "rqst_dt") == formObj.rqst_dt.value && sheetObjects[1].CellValue(i, "rqst_eq_no") == formObj.rqst_eq_no.value){
//					    			sheetObjects[1].CellValue(i, "rpr_sts_cd") = "SS";
//					    		}
//					    	}
//					    }else{
//					    	ComShowCodeMessage(sXml);
//					    }
					    
						sheetObjects[1].LoadSaveXml(sXml);  
						if(MnrComGetErrMsg(sXml) == null){
							var rqstEqNo = ComGetEtcData(sXml, "rqst_eq_no");				
							var rprRqstSeq = ComGetEtcData(sXml, "rpr_rqst_seq");				
							var rprRqstVerNo = ComGetEtcData(sXml, "rpr_rqst_ver_no");				
							
							var targetRow = 0;
							with(sheetObjects[1]){ 
								for(var j = 1; j <= LastRow;j++){    
									if(CellValue(j,"rqst_eq_no") == rqstEqNo && CellValue(j,"rpr_rqst_seq") == rprRqstSeq && CellValue(j,"rpr_rqst_ver_no") == rprRqstVerNo){
										targetRow = j;  
									}	
								}
							}
														
							//마치 선택된것 처럼 		
							if(targetRow != 0){ 
								sheetObjects[1].SelectCell(targetRow,1); 
								sheet2_OnDblClick(sheetObjects[1],targetRow,1);	
							} 
						}
					    
					  //2015.09.14 이율규 [CHM-201537843]MNR Estimate 생성 시 조회 조건 변경 로직 수정 - end
				  }
                break;
					
			case IBCREATE:        //Request     
	              if(validateForm(sheetObj,formObj,sAction)){
				  		saveType = "REQUEST";    
						formObj.f_cmd.value = COMMAND02;     
											 															          
						var sParam = 'f_cmd' + '=' + COMMAND02 + '&';  
								     
						sParam += sheetObjects[1].GetSaveString(false, false, "del_chk");
					 		 
					    var sXml = sheetObj.GetSaveXml("EES_MNR_S019GS.do", sParam);
					     		 	 		 	  	
					    //2015.09.14 이율규 [CHM-201537843]MNR Estimate 생성 시 조회 조건 변경 로직 수정 - start
					    
//					    if(sXml.indexOf("<ERROR>") == -1){
//					    	ComShowCodeMessage("MNR00055");
//					    	
//					    	for(var i = 0; i < sheetObjects[1].Rows; i++){
//					    		if(sheetObjects[1].CellValue(i, "del_chk") == 1){
//					    			sheetObjects[1].CellValue(i, "del_chk") = 0;
//					    			sheetObjects[1].RowHidden(i) = true;
//					    		}
//					    	}
//					    }else{
//					    	ComShowCodeMessage(sXml);
//					    }
					     		 	 		 	  	
						sheetObjects[1].LoadSaveXml(sXml); // 자동 재 조회 기능 제거  
											
						//IBCLEAR와 동일한 역활   	
						MnrWaitControl(true);   
						selCheck = false;   
						//폼 초기화 
						setEqInfoClear();
						 	
						//eq_dmg_dt에 값이 있다면 초기화 하지 않는다.
						var tempEqDmgDt = MnrNullToBlank(ComGetObjValue(formObj.eq_dmg_dt)); 
						 	
						//차후에 하나씩 개별로  
						formObj.reset();    
						//다시 세팅되어야 할 값들            
						MnrFormSetReadOnly(formObj,false,"rqst_eq_no"); 
								
						//eq_dmg_dt
						if(tempEqDmgDt == ''){    
							formObj.eq_dmg_dt.value = ComGetNowInfo("ymd");	
						} else { 
							formObj.eq_dmg_dt.value = tempEqDmgDt;	  
						}
								
						//rqst_dt    Input Date
						formObj.rqst_dt.value = ComGetNowInfo("ymd");  		
						
						formObj.req_st_dt.value = ComGetDateAdd(ComGetNowInfo(), "D", -90);
						formObj.req_end_dt.value = ComGetNowInfo();
							
						//초기화 하지 않으므로 값 다시 세팅 
						setComboValue(); 
						 	
						formObj.sp_name.enable = true;    
						formObj.eq_knd_cd.enable = false;      
						formObj.trsm_mod_cd.enable = false;  
									  
						//쉬트 초기화	 	  	
						sheetObjects[2].RemoveAll();
						sheetObjects[10].RemoveAll();  
						sheetObjects[2].SumText(0,"eq_loc_cd") = "TOTAL";
						MnrWaitControl(false);
					    
						uploadFileSeq = "";
						document.form.file_seq_tmp.value = "";
					  //2015.09.14 이율규 [CHM-201537843]MNR Estimate 생성 시 조회 조건 변경 로직 수정 - end
				  }
                break;
				
			 case IBBATCH:        //calc
              if(validateForm(sheetObj,formObj,sAction)){
			  	 	saveType = "IBBATCH";
					formObj.f_cmd.value = COMMAND01; 
																          
					var sParam = sheetObj.GetSaveString(true, true); 
					//멘덴토리 체크	        
					if(sParam == "" && sheetObj.IsDataModified){ 
						return;	
					} 	
					sParam = ComSetPrifix(sParam,"rqstDtl_");
				    sParam += "&" + FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0019GS.do", sParam);
				    
					sheetObj.Redraw = false;
					sheetObj.LoadSaveXml(sXml);		 	
																						
					//Off-hire 체크시   mnr_lr_acct_flg 이거만 다시 세팅   
					//mnr_vrfy_tp_cd ==> OF  			
					if(formObj.rpr_offh_flg.value == 'Y'){ 
						for(var j = 2; j <= sheetObj.LastRow - 1;j++){    
							sheetObj.CellEditable(j, "mnr_lr_acct_flg") = true; 
							sheetObj.CellValue(j, "mnr_vrfy_tp_cd") = "OF";										
						}				
					} else {			
						for(var j = 2; j <= sheetObj.LastRow - 1;j++){    
							sheetObj.CellEditable(j, "mnr_lr_acct_flg") = false;						
						}	 	 
					}  	
					
					if(sheetObj.RowCount >= 1) { 
						sheetObj.SelectCell(2,1);     
					}
							 	 
					var arrResult = MnrXmlToArray(sXml); 
					setCommonSheetEdit(sheetObj,arrResult); 
					sheetObj.SumText(0,"eq_loc_cd") = "TOTAL";
					sheetObj.Redraw = true;
						
					//한개만 잇나 없나 확인  
					if(MnrNullToBlank(ComGetEtcData(sXml,"RQST_EQ_NO")) != ''){
						//있다면 팝업호출 
						var rqstEqNo = MnrNullToBlank(ComGetEtcData(sXml,"RQST_EQ_NO"));    
						var rprRqstSeq = MnrNullToBlank(ComGetEtcData(sXml,"RPR_RQST_SEQ"));
						var rprRqstVerNo = MnrNullToBlank(ComGetEtcData(sXml,"RPR_RQST_VER_NO"));    
						var eqKndCd = MnrNullToBlank(ComGetEtcData(sXml,"EQ_KND_CD")); 
						var recentRprTpCd = MnrNullToBlank(ComGetEtcData(sXml,"RECENT_RPR_TP_CD")); 
															
						ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&recent_rpr_tp_cd="+recentRprTpCd, 1024, 768, '', '0,0', false);
					}  	
					
			  }
                break;
				
			 case IBINSERT:		
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row = sheetObj.DataInsert(-1);		 
					//set Value Init
					sheetObj.CellValue2(Row, "eq_cmpo_cd")	= "";  //Component
					sheetObj.CellValue2(Row, "eq_dmg_cd")	= "";  //DMG
					sheetObj.CellValue2(Row, "eq_rpr_cd") 	= "";  //Repair
					sheetObj.CellValue2(Row, "trf_div_cd") 	= " ";  //Div
					sheetObj.CellValue2(Row, "mnr_vrfy_tp_cd") 	= "";  //Result
					//set Focus 				
					sheetObj.SumText(0,"eq_loc_cd") = "TOTAL"; 
					//Editable					
					setInitSheetEdit(sheetObj,Row); 		          		
					sheetObj.SelectCell(Row, 1); 	
				}		
                break;
					
			 case IBDELETE:	
			 		MnrRowDelete(sheetObj,  "del_chk"); 	
			 	break;			
							
			 case IBCLEAR:      //초기화       
			 	MnrWaitControl(true);   
			 	//초기화 되어야 할 변수 
				selCheck = false;   
				uploadFileSeq = "";
				document.form.file_seq_tmp.value = "";
				//폼 초기화     
				setEqInfoClear(); 
				
				//eq_dmg_dt에 값이 있다면 초기화 하지 않는다.
				var tempEqDmgDt = MnrNullToBlank(ComGetObjValue(formObj.eq_dmg_dt)); 
				
				//차후에 하나씩 개별로
				formObj.reset();
				  
				//다시 세팅되어야 할 값들            
				MnrFormSetReadOnly(formObj,false,"rqst_eq_no");
				//쉬트 초기화		
				sheetObjects[2].RemoveAll(); 
				sheetObjects[10].RemoveAll();   
				sheetObjects[2].SumText(0,"eq_loc_cd") = "TOTAL";
							
				for(var i = 0; i < comboObjects.length;i++){ 
					if(i != 0 && i != 3){
						comboObjects[i].Code = "-1"; 
						comboObjects[i].RemoveAll(); 	
					}
				} 	
				formObj.sp_name.enable = true;  
				formObj.eq_knd_cd.enable = false;     
				formObj.trsm_mod_cd.enable = false;     
					
				//공통콤보 정보를 가져온다.   
				var sCondition = new Array (
					new Array("MnrGenCd","CD00016", "COMMON"),
					new Array("MnrGenCd","CD00018", "COMMON"),
					new Array("MnrGenCd","","CUSTOM9"),
					//sheetObjects[1] HDR LIST 쉬트 콤보 설정
					new Array("MnrGenCd","CD00008", "COMMON"),	
					new Array("MnrGenCd","CD00019", "COMMON"),	
					new Array("MnrGenCd","CD00002", "COMMON"), 
					//sheetObjects[2] DTL LIST 쉬트 콤보 설정
					new Array("MnrCedexOthCd","RPR","COMMON"), 	//Repair
					new Array("MnrCedexOthCd","DMG","COMMON"), 	//Demage			
					new Array("MnrGenCd","CD00013", "COMMON"),	//Type	
					new Array("MnrGenCd","CD00004", "COMMON"),	//Error code	
					new Array("MnrEqCmpoCd","3","COMMON") 		//Component
				)     		
				 
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
				
				//1	TRSM_MOD_CD	
				if(comboList[0] != null){	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.trsm_mod_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}			    
				}		  	 
				formObj.trsm_mod_cd.Code = ""; 	  
				 
				//2	REPAIR WORK TYPE CODE	 
				if(formObj.rpr_wrk_tp_cd.GetCount() == 0){ 
					if(comboList[1] != null){   	         
						for(var j = 0; j < comboList[1].length;j++){ 
							var tempText = comboList[1][j].split("|");  
							formObj.rpr_wrk_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
							if(j == 0){ 		      	     
								rwTypedefCode = tempText[0];            
							}   	          
						}	 	 	
						formObj.rpr_wrk_tp_cd.Code = rwTypedefCode;    
			        }	
				} 
				
				//3	EQ_TYPE	
				if(comboList[2] != null){	       
					for(var j = 0; j < comboList[2].length;j++){ 
						var tempText = comboList[2][j].split("|");  
						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}			    
				} 		  	 
				formObj.eq_knd_cd.Code = "";  
				
				//sheet1,sheet2  콤보 세팅 
				var sheetComboCode = "";
				var sheetComboText = ""; 
				var sheetComboCodeText = ""; 
				//DEF 값 저장을 위해 
				var sheetComboDefault = new Array();    	
				
				var comboSaveNames = new Array();
				//sheet1
				comboSaveNames[0] = "rpr_sts_cd";
				comboSaveNames[1] = "mnr_inp_tp_cd";  
				comboSaveNames[2] = "eq_knd_cd";
				//sheet2
				comboSaveNames[3] = "eq_rpr_cd";   
				comboSaveNames[4] = "eq_dmg_cd";    
				comboSaveNames[5] = "vol_tp_cd";  	 
				comboSaveNames[6] = "mnr_vrfy_tp_cd";
				comboSaveNames[7] = "eq_cmpo_cd"; 
				
				for(var i = 3; i < comboList.length;i++){
					//sheet2는 전역 변수에 담아둠
					if(i >= 6){
						sheetComboList[i - 6] = comboList[i];
					}    
					         
					if(comboList[i] != null){
						sheetComboText = ""; 
						sheetComboCode = "";
						sheetComboCodeText = "";    
						 	 	  
				 		for(var j = 0; j < comboList[i].length;j++){	 
							var tempText = comboList[i][j].split("|");   
							sheetComboCode +=  tempText[0] + "|";    
							sheetComboText +=  tempText[1] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j == 0){    	     
								sheetComboDefault[i - 3] = tempText[0];           	
							}											  
						}   			    		
						 
						sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
				     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  
				        sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText); 
						   
						if(comboSaveNames[i - 3] == "rpr_sts_cd"){        		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);	
						} else if(comboSaveNames[i - 3] == "mnr_inp_tp_cd"){   		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);	
						} else if(comboSaveNames[i - 3] == "eq_knd_cd"){   		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);	
						} else if(comboSaveNames[i - 3] == "vol_tp_cd"){  		
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);	
						} else if(comboSaveNames[i - 3] == "mnr_vrfy_tp_cd"){ 	
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);	
						} else if(comboSaveNames[i - 3] == "eq_rpr_cd"){	
							//sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "eq_dmg_cd"){	
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i - 3]);
						} else if(comboSaveNames[i - 3] == "eq_cmpo_cd"){	
							//sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 3], sheetComboCodeText, sheetComboCode ,sheetComboDefault[i - 3]);
						}    
					}	      
				}
					 
				//0 trsm_mod_cd|1 vndr_seq|2 agmt_ref_no|3 eq_type_name|4 agmt_ofc_cty_cd|5 agmt_dt|6 agmt_seq|7 agmt_rmk|8 vndr_nm|9 agmt_no|10 agmt_type_tpsz|11 pagerows|12 agmt_ver_no|13 eff_dt|14 curr_cd|15 exp_dt|16 ibflag|17 cre_dt|18 upd_usr_id|19 delt_flg|20 agmt_prifix|21 pay_term_dys|22 edi_id|23 cre_usr_id|24 agmt_lst_ver_flg|25 trf_no|26 isversionup|27 agmt_display_type|28 eq_knd_cd|29 mnr_meas_ut_nm|30 agmt_ofc_cd|31 upd_dt
				//Service Provider Combo   
				//값이 없을때만 조회 
				if(formObj.sp_name.GetCount() == 0){ 
					formObj.sp_name.Code = "-1"; 
					formObj.sp_name.RemoveAll();	 		 
					     
					var sXml = MnrEstAGMTHdrCombo(sheetObj,formObj.cost_ofc_cd.value);
					var arrResult = MnrXmlToArray(sXml); 
					var tempStr = ""; 
					var j = 0; 
					if(arrResult != null){ 	 
						for(var i = 0; i < arrResult.length;i ++){ 
							tempStr = arrResult[i][1];        
							if(tempStr == ComLpad(formObj.vndr_seq.value,6,0)){
								sp_name.items.push(  
									new itemEntity(arrResult[i][1],arrResult[i][8],arrResult[i][9],arrResult[i][12],arrResult[i][13],arrResult[i][15],arrResult[i][25],arrResult[i][2],arrResult[i][28],arrResult[i][14],arrResult[i][0],arrResult[i][22],arrResult[i][29])
								);
								var tempComboText = arrResult[i][9] + "|" + arrResult[i][30] + "|" + arrResult[i][3] + "|" + arrResult[i][13] + " ~ " + arrResult[i][15] + "|" + arrResult[i][2] + "|" + " " + arrResult[i][25];
								formObj.sp_name.InsertItem(j, tempComboText ,String(j)); 
								j++;
							}	
						}       	   				 				 						
					} else {        		 			
						ComShowCodeMessage("MNR00056");         
					}  	  		
					formObj.sp_name.Code = "";	
					preSpNameCode = "";
				} else {
					var formObj  = document.form; 
					if(formObj.sp_name.Code != ""){ 
						var selectedIndex = formObj.sp_name.Code;   
						formObj.trf_no.value = sp_name.items[selectedIndex].trf_no;	
						formObj.curr_cd.value = sp_name.items[selectedIndex].curr_cd;
						formObj.edi_id.value = sp_name.items[selectedIndex].edi_id;
						formObj.eq_knd_cd.Code = sp_name.items[selectedIndex].eq_knd_cd;   
						formObj.trsm_mod_cd.Code = sp_name.items[selectedIndex].trsm_mod_cd;  
						formObj.vndr_seq.value = sp_name.items[selectedIndex].vndr_seq;
						formObj.mnr_meas_ut_nm.value = sp_name.items[selectedIndex].mnr_meas_ut_nm; 
						      														
						var agmtNo = sp_name.items[selectedIndex].agmt_no;
						formObj.agmt_ofc_cty_cd.value = agmtNo.substring(0,3);
						formObj.agmt_seq.value =  parseInt(agmtNo.substring(3,agmtNo.length),10); 
						formObj.agmt_ver_no.value = sp_name.items[selectedIndex].agmt_ver_no;	
						preSpNameCode = formObj.sp_name.Code;   
					}
				} 
				 				
				//EQ_DMG_DT 
				if(tempEqDmgDt == ''){    
					formObj.eq_dmg_dt.value = ComGetNowInfo("ymd");	
				} else { 
					formObj.eq_dmg_dt.value = tempEqDmgDt;	  
				}
						
				//RQST_DT    Input Date
				formObj.rqst_dt.value = ComGetNowInfo("ymd");  
				
				formObj.req_st_dt.value = ComGetDateAdd(ComGetNowInfo(), "D", -90);
				formObj.req_end_dt.value = ComGetNowInfo();
				
				setDLC(sheetObjects[2]);     
				MnrWaitControl(false);                    
				break;
				 							
				case IBSEARCH_ASYNC01:	//조회(Eq No. 입력시 벨리데이션 )
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//EQ_TYPE을 먼저 체크 
					if(formObj.eq_knd_cd.Code == ""){	
						ComShowCodeMessage("MNR00198",checkEqn,"EQ No."); 
						ComSetObjValue(formObj.rqst_eq_no, "");     
						formObj.eq_knd_cd.focus();
						return;	   	 
					} else { 	
						var checkEqn = formObj.rqst_eq_no.value;		 
						var retArray = MnrGeneralCodeCheck(sheetObj,"ESTEQN",checkEqn + "," + formObj.eq_knd_cd.Code);      
						    					
						if(retArray == null){ 	          
							ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");          				
							ComSetObjValue(formObj.rqst_eq_no, ""); 
							setEqInfoClear(); 	    
							ComSetFocus(formObj.rqst_eq_no); 	   
							return; 	     	          
						} else {		    
							//맞는 EQ_NUMBER Equipment Information 를 표시한다.
							setEqInfo(sheetObj,formObj.eq_knd_cd.Code,formObj.rqst_eq_no.value,ComGetNowInfo("ymd"),true);	 
							   						 					
							//WarrantyAlert  
							if(formObj.eq_knd_cd.Code == "U"){  			
								var sXml = MnrWarrantyAlertInfo(sheetObj,formObj.rqst_eq_no.value);  
								if(!MnrIsEmptyXml(sXml)){        
									ComOpenWindowCenter("EES_MNR_0213.do?eq_no=" + formObj.rqst_eq_no.value, "EES_MNR_0213", 499, 258, true);	
									document.getElementById("Warranty").innerHTML = "Y"; 	
								} else { 
									document.getElementById("Warranty").innerHTML = "N"; 
								}   				
							}	  	  
							return; 	   
						}  	
					}
				}		
				break;	 
						
				case IBSEARCH_ASYNC02:	//off-hire 변동시 
					var endPoint = sheetObj.LastRow - 1; 	
					for(var Row = 2; Row <= endPoint;Row++){	 
						//mnr_lr_acct_flg 세팅 					
						if(formObj.rpr_offh_flg_temp.checked == true){		
							formObj.rpr_offh_flg.value = "Y";  			
							setInitSheetEdit(sheetObj,Row);	 	  		
							//입력 가능한 값은 모두 초기화 한다.					  
							sheetObj.CellValue2(Row ,"rpr_lbr_hrs") = "";     
							sheetObj.CellValue2(Row ,"rpr_lbr_rt") = "";   
							sheetObj.CellValue2(Row ,"lbr_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"mtrl_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"mnr_wrk_amt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_flg") = "0";  
							sheetObj.CellValue2(Row ,"n3pty_bil_lbr_hrs") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_bil_lbr_rt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_lbr_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_bil_mtrl_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_bil_amt") = ""; 
							sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = ""; 								
						} else {														
							formObj.rpr_offh_flg.value = "N";	
							setInitSheetEdit(sheetObj,Row);	 		
							//입력 가능한 값은 모두 초기화 한다.			  
							sheetObj.CellValue2(Row ,"rpr_lbr_hrs") = "";     
							sheetObj.CellValue2(Row ,"rpr_lbr_rt") = "";   
							sheetObj.CellValue2(Row ,"lbr_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"mtrl_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"mnr_wrk_amt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_flg") = "0";  
							sheetObj.CellValue2(Row ,"n3pty_bil_lbr_hrs") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_bil_lbr_rt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_lbr_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_bil_mtrl_cost_amt") = ""; 
							sheetObj.CellValue2(Row ,"n3pty_bil_amt") = ""; 
							sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = ""; 		
						}	 					 		
					}	  									
				break;	
				
				case IBSEARCH_ASYNC03:	//조회(YARD 입력시 벨리데이션 )
				if ( validateForm(sheetObj, formObj, sAction) ) {  
						var checkYard = formObj.rpr_yd_cd.value; 
								
						retArray = MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);      
						if(retArray == null){        
							ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
							ComSetObjValue(formObj.rpr_yd_cd, "");  	    
							ComSetFocus(formObj.rpr_yd_cd);                   
						} else {    
							return;    
						}   	 
				}		
				break;
				
				case IBSEARCH_ASYNC04:	
					var sParam = 'f_cmd' + '=' + COMMAND04 + '&';  
					sParam += sheetObjects[1].GetSaveString(false, false, "del_chk");
					 		 
					var sXml = sheetObj.GetSaveXml("EES_MNR_S019GS.do", sParam);
					
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
     * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {없음}
     **/
	function file_Insert(sheetObj){ 
		//**** 주의 헤더 겟수에 따라 수정하라  CellValue(2,"file_seq");  
		uploadFileSeq = document.form.file_seq_tmp.value;  
		
		if(uploadFileSeq == undefined){ 	 
			uploadFileSeq = "";	
		}
					
		for(var j = 2; j <= sheetObj.LastRow;j++){ 
			if (sheetObj.CellValue(j,"org_file_nm") == ""){
					ComShowMessage(ComGetMsg('MNR00024'));
					sheetObj.SelectCell(j,"org_file_nm");  
					return;      
			} 	
		} 
		var row = sheetObj.DataInsert(-1); 
	}
	
	function file_Remove(sheetObj) { 		  
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);	         	 		
		} else {			      
			ComShowCodeMessage("MNR00150");   	   
		}	 
	}	
		
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리	
     */
    function validateForm(sheetObj,formObj,sAction){
        if(isValidNeed == true){    
			with(formObj){           	        
	        	switch(sAction) {  	
					case IBROWSEARCH: 
						if (!ComChkValid(formObj)) return false;
					 	break;	
						
					//삭제 	
					case IBSEARCHAPPEND:  
						setComboValue();  
						if(!selCheck){  
							ComShowCodeMessage("MNR00054");	
							return false;	  	
						}	
						
						//Service Provider 가 선택되지 않았다면 
						if(formObj.sp_name.Code == ""){
							ComShowCodeMessage("MNR00036","Service Provider ");	
							formObj.sp_name.focus();    
							return false; 	  
						}		
							
						if (!ComChkValid(formObj)) return false;
						
						//삭제  의사 확인
						if (!ComShowCodeConfirm("MNR00026")){return false;}     
						break;	
						       
					case IBCREATE:	//request 
						var soldEqList = "";
						for(var i = 0; i < sheetObjects[1].Rows; i++){
							if(sheetObjects[1].CellValue(i, "sold_eq") == "SOLD EQ" && sheetObjects[1].CellValue(i, "del_chk") != 0){
								sheetObjects[1].CellValue(i, "del_chk") = 0;
								soldEqList += "\n" +sheetObjects[1].CellValue(i, "rqst_eq_no"); 
							}
						}
						
						if(soldEqList != ""){
							ComShowCodeMessage("MNR00417",soldEqList);
						}
						
						if(sheetObjects[1].FindCheckedRow("del_chk") == ""){
 							ComShowCodeMessage("MNR00036","Request");
							return false;
 						}
						
						doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC04);
	
						if(chkEqNo != "" && chkEqNo != null){
							ComShowCodeMessage("MNR00389",chkEqNo);
							return false;
						}
					
						//REQUEST 저장  의사 확인  
						if (!ComShowCodeConfirm("MNR00275","Estimate","Request")){return false;}     
						break;	 
						
					case IBSAVE:    //저장
						setComboValue(); 
						//Service Provider 가 선택되지 않았다면  
						if(formObj.sp_name.Code == ""){
							ComShowCodeMessage("MNR00036","Service Provider "); 	
							formObj.sp_name.focus();    
							return false;  
						}	
							
						//Repair Status 가 선택되지 않았다면 
						if(formObj.rpr_wrk_tp_cd.Code == ""){
							ComShowCodeMessage("MNR00036","Repair Status ");	
							formObj.rpr_wrk_tp_cd.focus();    
							return false;   
						}
						
						//중복 데이타 체크 	
						/*
						var Row = sheetObj.ColValueDup("eq_loc_cd|eq_cmpo_cd|eq_rpr_cd|trf_div_cd|vol_tp_cd|rpr_qty|rpr_sz_no");
						if(sheetObj.IsDataModified){	
							if(Row > 0){ 	 
								ComShowCodeMessage("MNR00006",(Row - 1) + " row ");
								sheetObj.SelectCell(Row, 1, true);        
								return false; 
							}			
						}
						*/
							
						//각 시트의 VolumnType별 Q'ty,Size/Square체크
						if(sheetObj.RowCount >= 1) {  
							for(var j = 2; j <= sheetObj.LastRow - 1; j++) { 
							    var volTpCd		= sheetObj.CellValue(j, "vol_tp_cd");	//Type
							    var rprQty 		= sheetObj.CellValue(j, "rpr_qty");		//Q'ty
							    var rprSzNo 	= sheetObj.CellValue(j, "rpr_sz_no");	//Size/Square
														  
								//Q'ty
								if(volTpCd == 'Q') {	 	
									if(rprQty < 1){
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Q'ty");
										sheetObj.SelectCell(j, "rpr_qty", true);  
										return false;
									}
								} 
								//Size/Square
								else {		
									if(rprSzNo < 1){	
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Size/Square");
										sheetObj.SelectCell(j, "rpr_sz_no", true);   
										return false;
									}	
								}
								
								var n3ptyFlg = sheetObj.CellValue(j, "n3pty_flg");  
								var n3mcost = sheetObj.CellValue(j, "n3pty_bil_mtrl_cost_amt");
								var n3rt = sheetObj.CellValue(j, "n3pty_bil_lbr_rt");
								var n3hrs = sheetObj.CellValue(j, "n3pty_bil_lbr_hrs");
								
								if(n3ptyFlg == "1"){
									if(n3mcost == ""){
										ComShowCodeMessage("MNR00003"); 
										sheetObj.SelectCell(j, "n3pty_bil_mtrl_cost_amt", true);        
										return false; 			
									} else if(n3rt == ""){
										ComShowCodeMessage("MNR00003"); 
										sheetObj.SelectCell(j, "n3pty_bil_lbr_rt", true);        
										return false; 
									} else if(n3hrs == ""){
										ComShowCodeMessage("MNR00003"); 
										sheetObj.SelectCell(j, "n3pty_bil_lbr_hrs", true);          
										return false; 
									}    
								} 
							}
						} else { 	
							ComShowCodeMessage("MNR00207");
							return false;   
						}	
										
						if(sheetObjects[2].IsDataModified){     			
							ComShowCodeMessage("MNR00333");	
							return false;	
						}
					         	  
						//폼중 필수 입력값이 다 제대로 들어갔는지       
						if (!ComChkValid(formObj)) return false;
                        
						//TPB Amount 체크
						if(!checkTpbAmount()) return false;
						
						for(var i = 2; i < sheetObjects[10].Rows; i++){
							if(sheetObjects[10].CellValue(i, "file_dw").match("Uploading...")){
								ComShowCodeMessage("MNR00410")
								return false;
							}
						}
						
						//저장  의사 확인
						if (!ComShowCodeConfirm("MNR00160","Estimate")){return false;}     
						break;	
							
					case IBBATCH:
						//Service Provider 가 선택되지 않았다면 
						if(formObj.sp_name.Code == ""){
							ComShowCodeMessage("MNR00036","Service Provider ");	
							formObj.sp_name.focus();    
							return false;  
						}
						  
						//중복 데이타 체크 	
						/*	
						var Row = sheetObj.ColValueDup("eq_loc_cd|eq_cmpo_cd|eq_rpr_cd|trf_div_cd|vol_tp_cd|rpr_qty|rpr_sz_no");
						if(sheetObj.IsDataModified){	
							if(Row > 0){ 	
								ComShowCodeMessage("MNR00006",(Row - 1) + " row ");
								sheetObj.SelectCell(Row, 1, true);        
								return false; 
							}		
						}	
						*/	
																
						//각 시트의 VolumnType별 Q'ty,Size/Square체크
						if(sheetObj.RowCount >= 1) { 
							for(var j = 2; j <= sheetObj.LastRow - 1; j++) { 
							    var volTpCd		= sheetObj.CellValue(j, "vol_tp_cd");	//Type
							    var rprQty 		= sheetObj.CellValue(j, "rpr_qty");		//Q'ty
							    var rprSzNo 	= sheetObj.CellValue(j, "rpr_sz_no");	//Size/Square
								//Q'ty
								if(volTpCd == 'Q') {	 	
									if(rprQty < 1){
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Q'ty");
										sheetObj.SelectCell(j, "rpr_qty", true);  
										return false;
									}
								} 
								//Size/Square
								else {		 
									if(rprSzNo < 1){	
										ComShowCodeMessage("MNR00175",(j - 1) + " row\'s Size/Square");
										sheetObj.SelectCell(j, "rpr_sz_no", true);   
										return false;
									} 		
								}
							} 	
						} else { 	
							ComShowCodeMessage("MNR00207");
							return false;   
						}	
						
						//폼중 필수 입력값이 다 제대로 들어갔는지	       
						if (!ComChkValid(formObj)) return false;
						break;
					case IBINSERT: 
						if(MnrNullToBlank(ComGetObjValue(formObj.rqst_eq_no)) == ''){
							ComShowCodeMessage("MNR00226"); 
							return false;   
						}	
						break;	
				} 
			}
		}
		return true;
    }
	
	//건당 상세 조회 이벤트  		
	function sheet2_OnDblClick(sheetObj,Row,Col) 
    {				
		var formObj = document.form;
		formObj.file_seq_tmp.value = "";
		with(sheetObj){
			//좌측 어그리먼트 넘버 세팅	  
			formObj.sp_name.enable = false;   		
			 		
			var agmtNo = CellValue(Row,"agmt_ofc_cty_cd") + ComLpad(CellValue(Row,"agmt_seq"), 6, "0"); 
			var agmtVerNo = CellValue(Row,"agmt_ver_no"); 
							
			for(var i = 0;i < sp_name.items.length; i++){
				if(sp_name.items[i].agmt_no == agmtNo){ 
					if(sp_name.items[i].agmt_ver_no != agmtVerNo){
						ComShowCodeMessage("MNR00218");				
					}				 
					formObj.sp_name.Code = String(i); 	   
					break;			
				}	
    		} 	
			  																 
			//헤더 정보를 세팅한다.
			//히든용 키값 세팅
			formObj.rpr_rqst_seq.value = CellValue(Row,"rpr_rqst_seq");	
			formObj.rpr_rqst_ver_no.value = CellValue(Row,"rpr_rqst_ver_no");	
			formObj.rpr_sts_cd.value = CellValue(Row,"rpr_sts_cd");     
			formObj.apro_ofc_cd.value = CellValue(Row,"apro_ofc_cd");       
							   			
			MnrFormSetReadOnly(formObj,true,"rqst_eq_no"); 
			ComSetObjValue(formObj.rqst_eq_no, CellValue(Row,"rqst_eq_no"));      
			ComSetObjValue(formObj.rqst_ref_no, CellValue(Row,"rqst_ref_no"));
			ComSetObjValue(formObj.rpr_yd_cd, CellValue(Row,"rpr_yd_cd"));
			ComSetObjValue(formObj.rpr_dtl_sts_cd, CellValue(Row,"rpr_dtl_sts_cd")); 
			ComSetObjValue(formObj.mnr_inp_tp_cd, CellValue(Row,"mnr_inp_tp_cd"));
			//Repair Status       	
			formObj.rpr_wrk_tp_cd.Code = CellValue(Row,"rpr_wrk_tp_cd");   
			ComSetObjValue(formObj.rpr_wrk_tp_cd, CellValue(Row,"rpr_wrk_tp_cd"));  
			ComSetObjValue(formObj.eq_dmg_dt, CellValue(Row,"eq_dmg_dt"));   
				
			if(CellValue(Row,"rpr_offh_flg") == 'Y'){	 
				formObj.rpr_offh_flg.value = 'Y'; 	
				formObj.rpr_offh_flg_temp.checked = true; 	
			} else {		
				formObj.rpr_offh_flg.value = 'N';
				formObj.rpr_offh_flg_temp.checked = false; 
			}
			ComSetObjValue(formObj.mnr_rpr_rmk, CellValue(Row,"mnr_rpr_rmk"));
			ComSetObjValue(formObj.vrfy_rslt_rmk, CellValue(Row,"vrfy_rslt_rmk"));
			//APPROVAL check 용	   
			ComSetObjValue(formObj.auto_amt, CellValue(Row,"auto_amt"));
			ComSetObjValue(formObj.appoval_amt, CellValue(Row,"appoval_amt"));
			ComSetObjValue(formObj.uppr_ofc_cd, CellValue(Row,"uppr_ofc_cd")); 
			      																
			//맞는 EQ_NUMBER Equipment Information 를 표시한다.
			setEqInfo(sheetObj,formObj.eq_knd_cd.Code,formObj.rqst_eq_no.value,ComGetNowInfo("ymd"),false);	 
			    						 					
			//WarrantyAlert  
			if(formObj.eq_knd_cd.Code == "U"){       			
				var sXml = MnrWarrantyAlertInfo(sheetObj,formObj.rqst_eq_no.value);  
				if(!MnrIsEmptyXml(sXml)){         
					ComOpenWindowCenter("EES_MNR_0213.do?eq_no=" + formObj.rqst_eq_no.value, "EES_MNR_0213", 499, 258, true);	
					document.getElementById("Warranty").innerHTML = "Y"; 	
				} else { 	
					document.getElementById("Warranty").innerHTML = "N"; 
				} 		   				
			} 			
				 
			//현재 조회상태 
			selCheck = true;
			tabObjects[0].SelectedIndex = 0;     					
			
			//해당 쉬트 초기화 
			sheetObjects[2].RemoveAll();
			sheetObjects[10].RemoveAll();  
			
			//파일 리스트 조회 
			var fileSeq = CellValue(Row,"file_seq");
			formObj.file_seq_tmp.value = CellValue(Row,"file_seq");
			
			if(fileSeq != "" && fileSeq != null){ 
				var fileXml = SearchFileUpload(sheetObjects[10],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[10].LoadSearchXml(fileXml);
					// 2011.05.02 박명신 [선처리] Equipment Management > M&R > Repair > Estimate 첨부 파일 사라지는 현상 수정
					uploadFileSeq = fileSeq;
				}	
			} else {
				uploadFileSeq = "";
			}      
    							
			//디테일 조회 	 
			doActionIBSheet(sheetObjects[2],formObj,IBROWSEARCH);
			
			//ACEP CHK List 버튼 활성화 여부
			if( formObj.rpr_rqst_seq.value != "" ){
				ComBtnEnable("btn_Acep_Pop");
			} else{
				ComBtnDisable("btn_Acep_Pop");
			}
			
			return;
		} 
    }  	
		
	//************************* EVENT SECTION ************************//
	
	//Agmt 콤보에 따라 입력되야 하는 값들을 정리한다. 
	function setComboValue(){
		var formObj = document.form; 
		var selectedIndex = formObj.sp_name.Code;   
		if(selectedIndex != ""){
			formObj.trf_no.value = sp_name.items[selectedIndex].trf_no;	
			formObj.curr_cd.value = sp_name.items[selectedIndex].curr_cd;
			formObj.edi_id.value = sp_name.items[selectedIndex].edi_id;
			formObj.mnr_meas_ut_nm.value = sp_name.items[selectedIndex].mnr_meas_ut_nm;
			formObj.eq_knd_cd.Code = sp_name.items[selectedIndex].eq_knd_cd;       
			formObj.trsm_mod_cd.Code = sp_name.items[selectedIndex].trsm_mod_cd;  
				
			formObj.vndr_seq.value = sp_name.items[selectedIndex].vndr_seq;
			var agmtNo = sp_name.items[selectedIndex].agmt_no;
			formObj.agmt_ofc_cty_cd.value = agmtNo.substring(0,3);
			formObj.agmt_seq.value =  parseInt(agmtNo.substring(3,agmtNo.length),10); 
			formObj.agmt_ver_no.value = sp_name.items[selectedIndex].agmt_ver_no;	
		} else { 
			formObj.trf_no.value = "";	
			formObj.curr_cd.value = "";
			formObj.edi_id.value = "";
			formObj.eq_knd_cd.Code = ""; 
			formObj.trsm_mod_cd.Code = ""; 
  			formObj.vndr_seq.value = "";  
			formObj.agmt_ofc_cty_cd.value = "";
			formObj.agmt_seq.value =  "";
			formObj.agmt_ver_no.value = ""; 
			formObj.mnr_meas_ut_nm.value = "";	   	
		} 	
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */ 	
	function tab1_OnChange(tabObj , nItem){
		formObj = document.form; 
		if(formObj.eq_knd_cd.Code == "U"){
			<!-- 탭간 값연동 (S) -->
			//값이 없는 놈들은 모두 삭제한다.	 
			var sp = sheetObjects[2].LastRow - 1; 
			for(var j = sp; j > 1;j--){       
				if(sheetObjects[2].CellValue(j,"eq_loc_cd") == ""){ 
					sheetObjects[2].RowDelete(j, false);  	//완전 삭제	
				} else {
					if(nItem == 0) {
						sheetObjects[2].CellValue2(j,"del_chk") = "1";
					}	
				}				 						
			}
						
			if(nItem == 0) {
				var tDmgLocCds = ComGetObjValue(form.damageLocationCode).split("/");
					
				for(var i = 0;i < tDmgLocCds.length;i++){
					var serchRow = sheetObjects[2].FindText("eq_loc_cd",tDmgLocCds[i]);
					//없으면 추가 잇는건 그대로 
					if(serchRow == -1){		
						var Row = sheetObjects[2].DataInsert(-1);		 
									 															
						//set Value Init	 
						sheetObjects[2].CellValue(Row, "eq_loc_cd")	= tDmgLocCds[i];  //Component
						sheetObjects[2].CellValue2(Row, "eq_cmpo_cd")	= "";  //Component
						sheetObjects[2].CellValue2(Row, "eq_dmg_cd")	= "";  //DMG
						sheetObjects[2].CellValue2(Row, "eq_rpr_cd") 	= "";  //Repair
						sheetObjects[2].CellValue2(Row, "trf_div_cd") 	= " ";  //Div
						sheetObjects[2].CellValue2(Row, "mnr_vrfy_tp_cd") 	= "";  //Result
						//set Focus				
						sheetObjects[2].SumText(0,"eq_loc_cd") = "TOTAL"; 
						//Editable					
						setInitSheetEdit(sheetObjects[2],Row);   		          		
						verifyCheck = false;   				
					} else {	  
						for(var j = 2;j < sheetObjects[2].LastRow;j++ ){
							if(sheetObjects[2].CellValue(j,"eq_loc_cd") == tDmgLocCds[i])
							{									
								sheetObjects[2].CellValue2(j,"del_chk") = "0";
							}			
						}
					}			 	
				}		 	
				MnrRowDelete(sheetObjects[2],"del_chk");    
			} else {
				var tDmgLocCd = "";	
				for(var i = 2;i < sheetObjects[2].LastRow;i++ ){
					var checkCompCd = sheetObjects[2].CellValue(i,"eq_loc_cd");
					tDmgLocCd += checkCompCd + "/"; 	
				}	
					
				tDmgLocCd = MnrDelLastDelim(tDmgLocCd);
							
				ComSetObjValue(form.damageLocationCode, tDmgLocCd);
				//기존거 다 리므부  	
				for(i = 0;i < DLCSheets.length;i++){	     
					for(j = 1;j <= DLCSheets[i].LastRow;j++){
						for(k = 1;k <= DLCSheets[i].LastCol;k++){
							DLCSheets[i].CellValue2(j,k) = "0";			
							DLCSheets[i].CellBackColor(j,k) = DLCSheets[i].RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
						}     		
					}	
				}				
				setDLC();   
			}	
			<!-- 탭간 값연동 (E) -->        	
		}  
							
		var objs = document.all.item("tabLayer");
			
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}
	
	function sheet2_OnClick(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "del_chk"){
			if(sheetObj.CellValue(Row, "sold_eq") == "SOLD EQ"){
				ComShowCodeMessage("MNR00416");
			}	
		}
	}
	
	function t1sheet1_OnClick(sheetObj,Row, Col, Value) {
		var formObj = document.form;
		formObj.mnr_desc.value = sheetObj.CellValue(Row ,"rpr_dtl_rmk");   
	}	
	
	function t1sheet1_OnChange(sheetObj,Row, Col, Value){
		if(!dummyEvent){  	
			var retArray =  null; 			     
			var checkLoc = sheetObj.CellValue(Row ,Col);      
			   
			if(sheetObj.ColSaveName(Col)  == "eq_loc_cd"){            
				var checkLoc = sheetObj.CellValue(Row ,Col); 	
														                   
			    retArray = MnrGeneralCodeCheck(sheetObj,"LOC",checkLoc);      
				if(retArray == null){					        
					ComShowCodeMessage("MNR00165",checkLoc,"LOC");         				
					sheetObj.CellValue2(Row ,Col) = "";      
					sheetObj.SelectCell(Row ,Col);			                        
				} 
					 
				//추가 요청  로우 스테이트를 변경한다.  
				if(sheetObj.RowStatus(Row) != "R"){
					sheetObj.RowStatus(Row) = "I";		
				}
			} else if(sheetObj.ColSaveName(Col)  == "eq_cmpo_cd"){
				var checkCompCd =  sheetObj.CellValue(Row,"eq_cmpo_cd");
				var checkRprCd =   sheetObj.CellValue(Row,"eq_rpr_cd");   
				var isPossible = false;    
				
				var sCode = sheetObj.GetComboInfo(Row,"eq_cmpo_cd", "Code");
				var arrCode = sCode.split("|");	
							
				for(var i = 0;i < arrCode.length;i ++){
					if(arrCode[i] == checkCompCd){
						isPossible = true;	
					} 	
				}				
				var formObject = document.form;	
					  
				if(!isPossible){
					ComShowCodeMessage("MNR00010","Component Code");
					sheetObj.CellValue2(Row ,Col) = "";      
					sheetObj.SelectCell(Row ,Col);  
				} else {
					//******************** Component 바뀌면  RPR 코드 다시 조회해 온다. **************
					//2010-08-12 09:05:17  목요일 추가 
												
					var sCondition = new Array (	  		    
			 			new Array("MnrRprCd",checkCompCd,"COMMON")		
			 		)				
																			
					var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
					var sheetComboCode = "";
					var sheetComboText = ""; 
					var sheetComboCodeText = ""; 
						
			 		var comboSaveNames = new Array();	
							
					for(var i = 0; i < comboList.length;i++){
					 	if(comboList[i] != null){
							sheetComboText = ""; 
							sheetComboCode = "";
							sheetComboCodeText = "";
													   	
					 		for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");    
								sheetComboCode +=  tempText[0] + "|";    
								sheetComboText +=  tempText[1] + "|";
								sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							}	
																								
							sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
					     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  
					        sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText);
												
							dummyEvent = true; 	  	 		   	       
							sheetObjects[2].CellComboItem (Row, "eq_rpr_cd", sheetComboCodeText, sheetComboCode);
							dummyEvent = false;
						}   	 
				 	}	
						
					sheetObj.CellValue2(Row ,"eq_rpr_cd") = ""; 
					//DIV 코드도 초기화 한다.
					dummyEvent = true;		   	 		   	       
					sheetObj.CellComboItem (Row, "trf_div_cd", " \t |", " |"); 		
					dummyEvent = false; 
					//******************** Component 바뀌면 RPR 코드 다시 조회해 온다. END ************* 
					
					setDescripton(sheetObj,Row);       
					//차후에 로직에 따라 수정 서버단도 수정해야됨! checkpoint 
					if(ComGetObjValue(formObject.eq_tpsz_cd) != "" && checkCompCd != ""){
						//if(sheetObj.RowStatus(Row) != "R"){
							var costCd = MnrGetCostCd(sheetObjects[0],formObject.eq_knd_cd.Code,formObject.eq_tpsz_cd.value,checkCompCd);	
							sheetObj.CellValue2(Row,"cost_cd") = costCd;
							sheetObj.CellValue2(Row,"cost_dtl_cd") = "NR";  
						//}	  
					}					
				}
				//추가 요청  로우 스테이트를 변경한다.  
				if(sheetObj.RowStatus(Row) != "R"){
					sheetObj.RowStatus(Row) = "I";		
				}    
			} else if(sheetObj.ColSaveName(Col)  == "vol_tp_cd"){
				if(sheetObj.CellValue(Row,"vol_tp_cd") == "Q"){
					sheetObj.CellEditable(Row, "rpr_qty") = true;	
					sheetObj.CellEditable(Row, "rpr_sz_no") = false;
					sheetObj.CellValue2(Row ,"rpr_sz_no") = "";     
				} else {
					sheetObj.CellEditable(Row, "rpr_qty") = false;	
					sheetObj.CellValue2(Row ,"rpr_qty") = "";    
					sheetObj.CellEditable(Row, "rpr_sz_no") = true;
				}	
				//추가 요청  로우 스테이트를 변경한다.  
				if(sheetObj.RowStatus(Row) != "R"){
					sheetObj.RowStatus(Row) = "I";		
				}  
			} else if(sheetObj.ColSaveName(Col) == "n3pty_flg"){
				var formObject = document.form;
				if(sheetObj.CellValue(Row,"n3pty_flg") == "1"){ 
					sheetObj.CellEditable(Row, "n3pty_bil_lbr_hrs") = true; 
					sheetObj.CellEditable(Row, "n3pty_bil_lbr_rt") = true;	
					sheetObj.CellEditable(Row, "n3pty_bil_mtrl_cost_amt") = true;	
										
					sheetObj.CellValue2(Row,"n3pty_bil_lbr_hrs") = sheetObj.CellValue(Row,"rpr_lbr_hrs"); 
					sheetObj.CellValue2(Row,"n3pty_bil_lbr_rt") = sheetObj.CellValue(Row,"rpr_lbr_rt"); 
					sheetObj.CellValue2(Row,"n3pty_lbr_cost_amt") = sheetObj.CellValue(Row,"lbr_cost_amt"); 
					sheetObj.CellValue2(Row,"n3pty_bil_mtrl_cost_amt") = sheetObj.CellValue(Row,"mtrl_cost_amt"); 
					sheetObj.CellValue2(Row,"n3pty_bil_amt") = sheetObj.CellValue(Row,"mnr_wrk_amt"); 
					//추가 요청 추가분	 
					formObject.n3pty_flg.value = "Y";  
					
				} else {						
					sheetObj.CellEditable(Row, "n3pty_bil_lbr_hrs") = false;
					sheetObj.CellEditable(Row, "n3pty_bil_lbr_rt") = false;	
					sheetObj.CellEditable(Row, "n3pty_bil_mtrl_cost_amt") = false;	
													
					sheetObj.CellValue2(Row,"n3pty_bil_lbr_hrs") = ""; 
					sheetObj.CellValue2(Row,"n3pty_bil_lbr_rt") = ""; 
					sheetObj.CellValue2(Row,"n3pty_lbr_cost_amt") = ""; 
					sheetObj.CellValue2(Row,"n3pty_bil_mtrl_cost_amt") = ""; 
					sheetObj.CellValue2(Row,"n3pty_bil_amt") = "";  
					//추가요청 추가분 
					var n3CheckFlag = false;
					for(var j = 2; j <= sheetObj.LastRow - 1;j++){    
						if(sheetObj.CellValue(j,"n3pty_flg") == "1"){
							n3CheckFlag = true;					
						} 	  						
					}
					if(n3CheckFlag){  
						formObject.n3pty_flg.value = "Y";   	
					} else {  
						formObject.n3pty_flg.value = "N";  
					}
				}
			} else if(sheetObj.ColSaveName(Col) == "eq_rpr_cd" || sheetObj.ColSaveName(Col) == "eq_dmg_cd"){
				var ErrMsgTarget = "";	
				var isPossible = false;	
				if(sheetObj.ColSaveName(Col) == "eq_rpr_cd"){
					ErrMsgTarget = "Repair Code";
					
					var repairCd =  sheetObj.CellValue(Row,"eq_rpr_cd");
					var sCode = sheetObj.GetComboInfo(Row,"eq_rpr_cd", "Code");
					var arrCode = sCode.split("|");		
								
					for(var i = 0;i < arrCode.length;i ++){
						if(arrCode[i] == repairCd){
							isPossible = true; 	
						} 	
					}
				} else if(sheetObj.ColSaveName(Col) == "eq_dmg_cd"){
					ErrMsgTarget = "Demage Code";
							
					for(var i = 0;i < sheetComboList[1].length;i++){
						var tempText = sheetComboList[1][i].split("|");       
												
						if(tempText[0] == sheetObj.CellValue(Row,Col)){
							isPossible = true;	 	
						}			
					}		
				}				
											
				if(!isPossible){ 
					ComShowCodeMessage("MNR00010",ErrMsgTarget);
					sheetObj.CellValue2(Row ,Col) = "";      
					sheetObj.SelectCell(Row ,Col);  
				} else { 
					//RPR일 경우에만  
					if(sheetObj.ColSaveName(Col) == "eq_rpr_cd"){ 
						setDescripton(sheetObj,Row);
						 
						var checkCompCd =  sheetObj.CellValue(Row,"eq_cmpo_cd");
						var checkRprCd =   sheetObj.CellValue(Row,"eq_rpr_cd");
						//COMP 코드가 있다면 DIV 코드 세팅  
						if(checkCompCd != ""){    
							var cosCdPrifix = sheetObj.CellValue(Row,"cost_cd");
							if(cosCdPrifix.length > 3){
								cosCdPrifix = cosCdPrifix.substring(0,3);   
							} 	 	 					
         					
							var compRprJoinStr = ComTrimAll(checkCompCd) + ComTrimAll(checkRprCd);	
							var sCondition = new Array (         
							 	new Array("MnrDivCd",compRprJoinStr + ',' +  cosCdPrifix,"COMMON1")
							)	   	 	       
							var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);      
							 							         
							var lbComboText = "";       
							var lbComboCode = "";    
							
							if(comboList[0] != null){     
								for(var j = 0; j < comboList[0].length;j++){ 
									var tempText = comboList[0][j].split("|");  
										 	
									lbComboText +=  tempText[0] + "\t" + tempText[1] + "|";
									lbComboCode +=  tempText[0] + "|";
								}
							} 
							dummyEvent = true;   	 		   	       
							sheetObj.CellComboItem (Row, "trf_div_cd", lbComboText, lbComboCode); 		
							dummyEvent = false;  
							sheetObj.CellValue2(Row ,"trf_div_cd") = " ";    
						}   			
					}
				}	
					
				//추가 요청  로우 스테이트를 변경한다.  
				if(sheetObj.RowStatus(Row) != "R"){
					sheetObj.RowStatus(Row) = "I";		
				}    
			} else if(sheetObj.ColSaveName(Col) == "trf_div_cd"){
				setDescripton(sheetObj,Row);      
				//추가 요청  로우 스테이트를 변경한다.          
				if(sheetObj.RowStatus(Row) != "R"){
					sheetObj.RowStatus(Row) = "I";		
				}	 	  
			} else if(sheetObj.ColSaveName(Col) == "del_chk"){
				MnrCheckRowColChange(sheetObj,sheetObj.CellValue(Row,"del_chk"),Row);
			
			//임의로 변경한 SS건에 대한  벨리데이션을 한다. 
			} else if(sheetObj.ColSaveName(Col) == "rpr_lbr_hrs"){ 
				if(sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "UH"){
					getReVerifySuccItem(sheetObj,Row);			
				} 
			} else if(sheetObj.ColSaveName(Col) == "rpr_lbr_rt"){ 
				if(sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "UR"){
					getReVerifySuccItem(sheetObj,Row);		
				} 
			} else if(sheetObj.ColSaveName(Col) == "mtrl_cost_amt"){  
				if(sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "SS" || sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "SL" || sheetObj.CellValue(Row ,"mnr_vrfy_tp_cd") == "UM"){
					getReVerifySuccItem(sheetObj,Row);				
				}			 
			}	
				
			//쉬트 변경 여부를 바꾼다. 
			var t = sheetObj.ColSaveName(Col);
			if(t == "eq_dmg_cd" || t == "rpr_qty" || t == "rpr_sz_no"){
				//추가 요청  로우 스테이트를 변경한다.  
				if(sheetObj.RowStatus(Row) != "R"){
					sheetObj.RowStatus(Row) = "I";		
				}		       					
			}	 
			 	  		
			if(t != "eq_loc_cd" && t != "eq_cmpo_cd" && t != "eq_dmg_cd" && t != "eq_rpr_cd" && t != "vol_tp_cd" && t != "rpr_qty" && t != "rpr_sz_no"){
				if(sheetObj.RowStatus(Row) != "I"){  
					sheetObj.RowStatus(Row) = "R";
				}		 							
			} 	
															  	  	
			if(t == "eq_loc_cd" || t == "eq_cmpo_cd" || t == "eq_dmg_cd" || t == "eq_rpr_cd" || t == "vol_tp_cd" || t == "rpr_qty" || t == "rpr_sz_no"){
				if(sheetObj.RowStatus(Row) != "R" && enableOnChange == true){  
					setInitSheetEdit(sheetObj,Row);   
					//입력 가능한 값은 모두 초기화 한다.  
					sheetObj.CellValue2(Row ,"rpr_lbr_hrs") = "";     
					sheetObj.CellValue2(Row ,"rpr_lbr_rt") = "";   
					sheetObj.CellValue2(Row ,"lbr_cost_amt") = ""; 
					sheetObj.CellValue2(Row ,"mtrl_cost_amt") = ""; 
					sheetObj.CellValue2(Row ,"mnr_wrk_amt") = ""; 
					sheetObj.CellValue2(Row ,"n3pty_flg") = "0";  
					sheetObj.CellValue2(Row ,"n3pty_bil_lbr_hrs") = ""; 
					sheetObj.CellValue2(Row ,"n3pty_bil_lbr_rt") = ""; 
					sheetObj.CellValue2(Row ,"n3pty_lbr_cost_amt") = ""; 
					sheetObj.CellValue2(Row ,"n3pty_bil_mtrl_cost_amt") = ""; 
					sheetObj.CellValue2(Row ,"n3pty_bil_amt") = ""; 
					sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = "";  
				}				          	
			}	
		}			
	}
	
	function getReVerifySuccItem(sheetObj,Row){
		var current = parseFloat(sheetObj.CellValue(Row ,"rpr_lbr_hrs"));   
		var asis =  parseFloat(sheetObj.CellValue(Row ,"rpr_lbr_bzc_hrs"));  
		var current1 = parseFloat(sheetObj.CellValue(Row ,"rpr_lbr_rt"));
		var asis1 =  parseFloat(sheetObj.CellValue(Row ,"rpr_lbr_bzc_rt"));  	  
		var current2 = parseFloat(sheetObj.CellValue(Row ,"mtrl_cost_amt"));  
		var asis2 =  parseFloat(sheetObj.CellValue(Row ,"lbr_mtrl_bzc_amt")); 
		if(current > asis){	       
			sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = "UH"; 
			sheetObj.CellFontColor(Row,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(255,0,0);
		} else if(current1 > asis1){
			sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = "UR"; 
			sheetObj.CellFontColor(Row,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(255,0,0);
		} else if(current2 > asis2){
			sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = "UM"; 
			sheetObj.CellFontColor(Row,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(255,0,0);
		} else if(current < asis || current1 < asis1 || current2 < asis2){
			sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = "SL";
			sheetObj.CellFontColor(Row,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(0,0,255);
		} else {
			sheetObj.CellValue2(Row ,"mnr_vrfy_tp_cd") = "SS";    
			sheetObj.CellFontColor(Row,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(0,0,255);
		}			 
	}		 	
						
	function t1sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj = document.form;
		if (sheetObj.ColSaveName(Col) != "eq_loc_cd") return;		
			
		//클릭된 로우를 찾기 위해서
		t1sheet1ClickRow = Row; 																				 
		ComOpenPopup('EES_MNR_0193.do?rec_eq_knd_cd=' + formObj.eq_knd_cd.Code, 896, 498, 'setEES_MNR_0193', '1,0,1,1,1,1,1,1,1,1,1,1'); 
    }			 
		
	function t2_sheet1_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = "";  
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
							
		if(Value == 1){ 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		} 		
    }
	
	function t2_sheet2_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = ""; 
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
						
		if(Value == 1){ 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}
    }
	function t2_sheet3_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = ""; 
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
						
		if(Value == 1){ 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}
    }
	function t2_sheet4_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = ""; 
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
						
		if(Value == 1){ 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}
    }
	function t2_sheet5_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = ""; 
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
						
		if(Value == 1){ 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}
    }
	function t2_sheet6_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = ""; 
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
						
		if(Value == 1){ 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}
    }
	function t2_sheet7_OnChange(sheetObj, Row, Col, Value)
    {
		var dlcStr = ""; 
        for(i = 0;i < DLCSheets.length;i++){ 
    		dlcStr += getDLC(DLCSheets[i]);  
    	}
    	dlcStr = dlcStr.substring(1,dlcStr.length)
		ComSetObjValue(form.damageLocationCode, dlcStr);
		 							
		if(Value == 1){		 	 		
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);		
		} else {	
			sheetObj.CellBackColor(Row,Col) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}
    }
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function t2_sheet8_OnPopupClick(sheetObj,Row,Col){

	    var upObj = uploadObjects[0];         
		var prefix = "";			
	 	var fileName = sheetObj.OpenFileDialog("파일선택");
	 	var zipFlg = "N"; // 첨부파일이 zip 파일일 경우 Y, 아닐 경우 N(초기값: N)
				
		var badFile = false;
		if(fileName.indexOf("\\") == -1) {  
			badFile = true;		
		} else {
			var relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1); 
			var fileType = 	relativePath.substr(relativePath.lastIndexOf(".") + 1);
			fileType = fileType.toUpperCase();
			//BMP, TIFF, JPG, PNG, ZIP
			if(fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG" && fileType != "PNG" && fileType != "ZIP"){
				badFile = true;
			} else if(fileType == "ZIP"){
				zipFlg = "Y"; // 첨부파일이 ZIP인 경우 zipFlg를 Y로 변경
			}
		}
			  
	 	if(!badFile) {  
	 		sheetObj.CellValue2(Row, prefix+ "org_file_nm")= fileName;     			
	 		upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
	    	var ret = upObj.AddFile(fileName);     			     			
	    	fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
	 		sheetObj.CellValue2(Row, Col)= fileName;		 
	 		sheetObj.InitCellProperty(Row, Col+1, dtData);
			sheetObj.CellValue2(Row, prefix+ "file_dw")= 'Uploading...';
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
	 		sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code				
	 		sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
	 		sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
				
	 		if(zipFlg == "Y"){ //첨부파일이 ZIP일 경우 와 아닌 경우를 분기하여 각각에 맞는 HTMLACTION으로 연결
	 			ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS_THUMBNAIL_ZIP.do");	
	 		} else {
	 			ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS_THUMBNAIL.do");
	 		}
	 		 
	 		
			upObj.ExtendParam = sParam;
			 
			var sXml = upObj.DoUpload(true);
				     		
			
			if(sXml.indexOf("<SHEET>") != 1){
				if(sXml.indexOf("<ERROR>") == 1 && sXml.match(msgs['MNR00409'])){
					ComShowCodeMessage("MNR00406");
				} else{
					ComShowCodeMessage("MNR00405");
				}
					
				sheetObj.RowDelete(Row, false);  	//문제가 있는 파일일 경우 row를 삭제
			} else {
				uploadFileSeq = ComGetEtcData(sXml,"seqValue");
				document.form.file_seq_tmp.value = ComGetEtcData(sXml,"seqValue");
				//mySheet.WaitImageVisible = false;

				if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
					var fileXml = SearchFileUpload(sheetObjects[10],uploadFileSeq);
					sheetObjects[10].LoadSearchXml(fileXml);   				
				}	
			}	  
	 	} else {
			ComShowCodeMessage("MNR00217");     	 
		}
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/  
	function t2_sheet8_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
   		   
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
			
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  

	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 
			if(saveType == "REMOVE"){
				ComShowCodeMessage("MNR00020");
			} else if(saveType == "REQUEST") {
				ComShowCodeMessage("MNR00055");					 
			} else {
				ComShowCodeMessage("MNR00023"); 	
			} 		   
		} else {
			//삭제후  메세지       
			if(saveType == "REMOVE"){
				//ComShowCodeMessage("MNR00027",ErrMsg); 
			//REQUEST  	
			} else if(saveType == "REQUEST") {
				//ComShowCodeMessage("MNR00008",ErrMsg); 		 
			//저장후 메세지	
			} else {
				//ComShowCodeMessage("MNR00008",ErrMsg);   
			}				
		} 		      
	}

	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){ 
		for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow ; i++){
			//[CHM-201111303-01] Verify 후, Verify Result결과에 대하여 RgbColor 추가
			var mnrVrfyTpCd = sheetObj.CellValue(i,  "mnr_vrfy_tp_cd");
			var volTpCd = sheetObj.CellValue(i,  "vol_tp_cd");
			
			if(mnrVrfyTpCd == "SS" || mnrVrfyTpCd=="SL"){
				sheetObj.CellFontColor(i,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(0,0,255);
			} else {
				sheetObj.CellFontColor(i,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(255,0,0);
			}
			
			if(mnrVrfyTpCd == "UH"){
				sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "VT"){
				sheetObj.CellBackColor(i,"vol_tp_cd") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "UR"){
				sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "UM"){
				sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "SL"){
				sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#fff000");
				sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#fff000");
				sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "NC"){
				sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "NR"){
				sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "ND"){
				sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#fff000");					
			}else if(mnrVrfyTpCd == "LC"){
				sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "LR"){
				sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "LD"){
				sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#fff000");
			}else  if(mnrVrfyTpCd == "LZ"){
				sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
			}else if(mnrVrfyTpCd == "NZ"){
				if(volTpCd == "Q"){
					sheetObj.CellBackColor(i,"rpr_qty") = sheetObj.WebColor("#fff000");
				}else{
					sheetObj.CellBackColor(i,"rpr_sz_no") = sheetObj.WebColor("#fff000");
				}
			}
		}
	}
	
	//버티파이후 메세지 표시  	
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 		   
				ComShowCodeMessage("MNR00334");
				for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow ; i++){
					
					var mnrVrfyTpCd = sheetObj.CellValue(i,  "mnr_vrfy_tp_cd");
					var volTpCd = sheetObj.CellValue(i,  "vol_tp_cd");
					
					if(mnrVrfyTpCd == "SS" || mnrVrfyTpCd=="SL"){
						sheetObj.CellFontColor(i,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(0,0,255);
					} else {
						sheetObj.CellFontColor(i,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(255,0,0);
					}
					
					//CellBackColor 초기화
					sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"vol_tp_cd") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"rpr_qty") = sheetObj.WebColor("#ffffff");
					sheetObj.CellBackColor(i,"rpr_sz_no") = sheetObj.WebColor("#ffffff");
					
					//[CHM-201111303-01] Verify 후, Verify Result결과에 대하여 RgbColor 추가
					if(mnrVrfyTpCd == "UH"){
						sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "VT"){
						sheetObj.CellBackColor(i,"vol_tp_cd") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "UR"){
						sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "UM"){
						sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "SL"){
						sheetObj.CellBackColor(i,"rpr_lbr_hrs") = sheetObj.WebColor("#fff000");
						sheetObj.CellBackColor(i,"rpr_lbr_rt") = sheetObj.WebColor("#fff000");
						sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "NC"){
						sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "NR"){
						sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "ND"){
						sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#fff000");					
					}else if(mnrVrfyTpCd == "LC"){
						sheetObj.CellBackColor(i,"eq_cmpo_cd") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "LR"){
						sheetObj.CellBackColor(i,"eq_rpr_cd") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "LD"){
						sheetObj.CellBackColor(i,"trf_div_cd") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "LZ"){
						sheetObj.CellBackColor(i,"mtrl_cost_amt") = sheetObj.WebColor("#fff000");
					}else if(mnrVrfyTpCd == "NZ"){
						if(volTpCd == "Q"){
							sheetObj.CellBackColor(i,"rpr_qty") = sheetObj.WebColor("#fff000");
						}else{
							sheetObj.CellBackColor(i,"rpr_sz_no") = sheetObj.WebColor("#fff000");
						}
					}				
				}
		} else { 
				//ComShowCodeMessage("MNR00159",ErrMsg);
		}			       
	}
	
	function sp_name_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		var selectedIndex = comboObj.Code; 
		
		if(comboObj.enable == true && formObj.rqst_eq_no.value != ""){
			if (!ComShowCodeConfirm("MNR00232")){
				//The changed data is found. Are you sure to proceed ? 
				//취소 버튼 
				comboObj.Code2 = preSpNameCode; 
			} else {
				//확인 버튼  
				preSpNameCode = comboObj.Code;    
				ComSetObjValue(formObj.rqst_eq_no,"");
				ComSetObjValue(formObj.rqst_ref_no,"");
				ComSetObjValue(formObj.mnr_desc,"");
				ComSetObjValue(formObj.mnr_rpr_rmk,"");
								
				setEqInfoClear(); 
				sheetObjects[2].RemoveAll();     
				sheetObjects[2].SumText(0,"eq_loc_cd") = "TOTAL";
			}			   
		}
		 
		if(selectedIndex != ""){
			formObj.trf_no.value = sp_name.items[selectedIndex].trf_no;	
			formObj.curr_cd.value = sp_name.items[selectedIndex].curr_cd;
			formObj.edi_id.value = sp_name.items[selectedIndex].edi_id;
			formObj.eq_knd_cd.Code = sp_name.items[selectedIndex].eq_knd_cd;   
			formObj.trsm_mod_cd.Code = sp_name.items[selectedIndex].trsm_mod_cd;  
			formObj.vndr_seq.value = sp_name.items[selectedIndex].vndr_seq;
			formObj.mnr_meas_ut_nm.value = sp_name.items[selectedIndex].mnr_meas_ut_nm;
			 	 													
			var agmtNo = sp_name.items[selectedIndex].agmt_no;
			formObj.agmt_ofc_cty_cd.value = agmtNo.substring(0,3);
			formObj.agmt_seq.value =  parseInt(agmtNo.substring(3,agmtNo.length),10); 
			formObj.agmt_ver_no.value = sp_name.items[selectedIndex].agmt_ver_no;
			  
			var eff_dt = sp_name.items[selectedIndex].eff_dt;       
			var exp_dt = sp_name.items[selectedIndex].exp_dt;  	    
			var today_dt = ComGetNowInfo(); 
					  		
			if(ComGetDaysBetween(today_dt,exp_dt) < 0 || ComGetDaysBetween(eff_dt,today_dt) < 0){
				ComShowCodeMessage("MNR00241");
				MnrFormSetReadOnly(formObj,true,"rqst_eq_no");
			} else{
				MnrFormSetReadOnly(formObj,false,"rqst_eq_no");
			}
		} else {	
			formObj.trf_no.value = "";	
			formObj.curr_cd.value = "";
			formObj.edi_id.value = "";
			formObj.eq_knd_cd.Code = ""; 
			formObj.trsm_mod_cd.Code = "";
			formObj.vndr_seq.value = "";    
			formObj.mnr_meas_ut_nm.value = "";   
																	
			formObj.agmt_ofc_cty_cd.value = "";
			formObj.agmt_seq.value =  "";
			formObj.agmt_ver_no.value = "";   
		}    
	}  		 
	  
	//콤보 이벤트 					
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){ 
		if(comboObj.Code == 'U'){      
			var div1 = document.all.item("t2_selection1");	 	
			var div2 = document.all.item("t2_selection2");
			div1.style.display = "inline";  		
			div2.style.display = "inline";   
		} else {     
			var div1 = document.all.item("t2_selection1");	 	
			var div2 = document.all.item("t2_selection2");
			div1.style.display = "none";  		
			div2.style.display = "none";    		 
		} 
					
		//******************** EQ Type 바뀌면 Component 코드 다시 조회해 온다. **************
		//2010-08-12 09:05:17  목요일 추가 
		var sCondition = new Array (	      
 			new Array("MnrEqCmpoCdByEqType","3",formObj.eq_knd_cd.Code)	
 		)			
								
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		var sheetComboCode = "";
		var sheetComboText = ""; 
		var sheetComboCodeText = ""; 
 		var sheetComboDefault = "";
			
 		var comboSaveNames = new Array();	
				
		for(var i = 0; i < comboList.length;i++){
		 	if(comboList[i] != null){
				sheetComboText = ""; 
				sheetComboCode = "";
				sheetComboCodeText = "";
										   	
		 		for(var j = 0; j < comboList[i].length;j++){ 
					var tempText = comboList[i][j].split("|");    
					sheetComboCode +=  tempText[0] + "|";    
					sheetComboText +=  tempText[1] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					/*			
					if(j ==0){			
						sheetComboDefault = tempText[0];      	
					}	
					*/											 	 
				}	
														
				sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
		     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  
		        sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText); 	
																									
				sheetObjects[2].InitDataCombo (0, "eq_cmpo_cd", sheetComboCodeText, sheetComboCode ,sheetComboDefault);
			}    
	 	}
		//******************** EQ Type 바뀌면 Component 코드 다시 조회해 온다.END *************       
	}  
					
	//************************* EVENT SECTION ************************//
    function setDLC()
    {		 
	    //DLCs = BL10,ABNN
    	var DLCs = ComGetObjValue(form.damageLocationCode).split("/");
    	var SheetChar = "DFLRTBU";  
        for(i = 0;i < DLCs.length;i++){  
			if(SheetChar.indexOf(DLCs[i].charAt(0)) != -1){
				checkDLC(DLCSheets[SheetChar.indexOf(DLCs[i].charAt(0))], DLCs[i]);
			}			
    	}  	
    }
 				   
    function checkDLC(sheetObj, DLC)
    {
    	with(sheetObj){
    		for(var i = 1 ; i <= LastRow ;i++){
    			for(var j = 1 ; j <= LastCol ;j++){
					if(ToolTipText(i,j).substring(0,3) == DLC.substring(0,3)){
						if(DLC.charAt(3) == 'N'){
							CellValue2(i,j) = "1"; 
							sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
						} else {
							var len = Math.abs(parseInt(DLC.charAt(3)) - parseInt(DLC.charAt(2)));
							if(ToolTipText(i,j).substring(0,1) == "L" || ToolTipText(i,j).substring(0,1) == "F"){
								if(DLC.substring(3,4) == "0"){ 
									var lflen = (10 - parseInt(DLC.charAt(2)));     
									for(var k = 0; k <= lflen ; k++){	   
										CellValue2(i,1 + k) = "1";		     
										sheetObj.CellBackColor(i,1 + k) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
									}				     			 		
								} else 	{ 
									for(var k = 0; k <= len ; k++){  	 
										CellValue2(i,j - k) = "1";	 	  
										sheetObj.CellBackColor(i,j - k) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
									}     	
								}  
							} else {
								if(DLC.substring(3,4) == "0"){ 
									var lflen = (10 - parseInt(DLC.charAt(2)));     	
									for(var k = 0; k <= lflen ; k++){		   
										CellValue2(i,j + k) = "1";     
										sheetObj.CellBackColor(i,j + k) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
									}     
								} else {
									for(var k = 0; k <= len ; k++){ 
										CellValue2(i,j + k) = "1";   
										sheetObj.CellBackColor(i,j + k) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
									} 		
								}
							}
						}
					}	
    			}
    		}
    	}
    }

    function getDLC(sheetObj)
    {
    	var DLC = "";
    	var startPoint = 0;
    	var endPoint = 0;
    	var cont = true;
    	with(sheetObj){
    		for(var i = 1 ; i <= LastRow ;i++){
    			startPoint  = 0; 
    			for(var j = 1 ; j <= LastCol ;j++){
    				startPoint  = 0; 
					if(CellValue(i,j) == '1'){
						if(CellValue(i,j + 1) == '1'){
							startPoint = j;
							do {
					          endPoint = j;
					          j++;
					        } while (CellValue(i,j) == '1' && j <= LastCol);
																									
							if(ToolTipText(i,j - 1).substring(0,1) == "L" || ToolTipText(i,j - 1).substring(0,1) == "F"){ 
								DLC += "/"+ToolTipText(i,j - 1).substring(0,2) + ToolTipText(i,endPoint).substring(2,3) + ToolTipText(i,startPoint).substring(2,3);	
							} else { 	 
								DLC += "/"+ToolTipText(i,j - 1).substring(0,2) + ToolTipText(i,startPoint).substring(2,3) + ToolTipText(i,endPoint).substring(2,3);	
							}  
						}else{
							DLC += "/"+ToolTipText(i,j) + "N";
						}
					}
						
    			}
    			
    		}
    	}	
    	return DLC;
    }

    function contCheck(sheetObj, Row, Col)
    {
    	var point = "";
    	with(sheetObj){
    		for(var i = 1 ; i <= LastRow ;i++){
    			var firstFlag  = 0; 
    			for(var j = 1 ; j <= LastCol ;j++){
					if(CellValue(i,j) == '1'){
						if(CellValue(i,j + 1) == '1'){
								
						}else{
							point += "|"+ToolTipText(i,j)+"N";
						}
					}
						
    			}
    		} 
    	}
    }
		
	function setInitSheetEdit(sheetObj,Row){
		var formObj = document.form;
		//vol_tp_cd 코드에 따른 세팅 
		if(sheetObj.CellValue(Row,"vol_tp_cd") == "Q"){
			sheetObj.CellEditable(Row, "rpr_qty") = true;	
			sheetObj.CellEditable(Row, "rpr_sz_no") = false;
			sheetObj.CellValue2(Row,"rpr_sz_no") = ""; 
		} else {
			sheetObj.CellEditable(Row, "rpr_qty") = false;	
			sheetObj.CellValue2(Row,"rpr_qty") = "";  
			sheetObj.CellEditable(Row, "rpr_sz_no") = true;
		}
		
		sheetObj.CellEditable(Row, "rpr_lbr_hrs") = false;
		sheetObj.CellEditable(Row, "rpr_lbr_rt") = false;
		sheetObj.CellEditable(Row, "lbr_cost_amt") = false;
		sheetObj.CellEditable(Row, "mtrl_cost_amt") = false;	
		sheetObj.CellEditable(Row, "mnr_wrk_amt") = false;
		
		//mnr_lr_acct_flg 세팅 
		if(formObj.rpr_offh_flg_temp.checked == true){
			sheetObj.CellEditable(Row, "mnr_lr_acct_flg") = true;
			formObj.rpr_offh_flg.value = "Y";						
		} else {
			sheetObj.CellEditable(Row, "mnr_lr_acct_flg") = false;
			formObj.rpr_offh_flg.value = "N";	
		} 
																
		//TPB 세팅 		 	
		sheetObj.CellEditable(Row, "n3pty_flg") = false;        
		sheetObj.CellEditable(Row, "n3pty_bil_lbr_hrs") = false;
		sheetObj.CellEditable(Row, "n3pty_bil_lbr_rt") = false;	
		sheetObj.CellEditable(Row, "n3pty_bil_mtrl_cost_amt") = false; 	
	}	
	
	function setCommonSheetEdit(sheetObj,arrResult){ 
		enableOnChange = false;  
		var formObj = document.form;    	
		for(var i = 2; i <= sheetObj.LastRow - 1;i++){    
			if(sheetObj.CellValue(i,"vol_tp_cd") == "Q"){
				sheetObj.CellEditable(i, "rpr_qty") = true;	
				sheetObj.CellEditable(i, "rpr_sz_no") = false;
				sheetObj.CellValue2(i,"rpr_sz_no") = ""; 
			} else {
				sheetObj.CellEditable(i, "rpr_qty") = false;
				sheetObj.CellValue2(i,"rpr_qty") = ""; 	
				sheetObj.CellEditable(i, "rpr_sz_no") = true;
			}
			//mnr_lr_acct_flg 세팅 
			if(formObj.rpr_offh_flg_temp.checked == true){
				sheetObj.CellEditable(i, "mnr_lr_acct_flg") = true;
				formObj.rpr_offh_flg.value = "Y";						
			} else {
				sheetObj.CellEditable(i, "mnr_lr_acct_flg") = false;
				formObj.rpr_offh_flg.value = "N";	
			} 
			if(sheetObj.CellValue(i,"n3pty_flg") == "1"){
				sheetObj.CellEditable(i, "n3pty_bil_lbr_hrs") = true;
				sheetObj.CellEditable(i, "n3pty_bil_lbr_rt") = true;	
				sheetObj.CellEditable(i, "n3pty_bil_mtrl_cost_amt") = true; 	
			} else {
				sheetObj.CellEditable(i, "n3pty_bil_lbr_hrs") = false;
				sheetObj.CellEditable(i, "n3pty_bil_lbr_rt") = false;	
				sheetObj.CellEditable(i, "n3pty_bil_mtrl_cost_amt") = false; 
			}			
			 			
			//Comp 코드값 다시 세팅 	
			sheetObj.CellValue2(i,"eq_cmpo_cd") = arrResult[i - 2][39];
												
			//RPR 콤보  세팅 
			var checkCompCd =  sheetObj.CellValue(i,"eq_cmpo_cd");
								
			//******************** Component 바뀌면  RPR 코드 다시 조회해 온다. **************
			var sCondition = new Array (		  		    
	 			new Array("MnrRprCd",checkCompCd,"COMMON")		
	 		)				
																												
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
			var sheetComboCode = "";
			var sheetComboText = ""; 
			var sheetComboCodeText = ""; 
					
	 		var comboSaveNames = new Array();	
						
		 	if(comboList[0] != null){	
				sheetComboText = ""; 
				sheetComboCode = "";
				sheetComboCodeText = "";
												   	
		 		for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|");    
					sheetComboCode +=  tempText[0] + "|";    
					sheetComboText +=  tempText[1] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				}	
																					
				sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
		     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  
		        sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText);
									
				dummyEvent = true; 	  	 		   	       
				sheetObjects[2].CellComboItem (i, "eq_rpr_cd", sheetComboCodeText, sheetComboCode);
				dummyEvent = false;						
			}			 	  	 
			//RPR 코드값 다시 세팅		 		
			sheetObj.CellValue2(i,"eq_rpr_cd") = arrResult[i - 2][22]; 	
			//******************** Component 바뀌면 RPR 코드 다시 조회해 온다. END *************
																
			//Div 콤보 세팅 	
			var checkRprCd =   sheetObj.CellValue(i,"eq_rpr_cd"); 
			//COMP 코드가 있다면 DIV 코드 세팅		     
			if(checkCompCd != ""){     
				var cosCdPrifix = sheetObj.CellValue(i,"cost_cd");
				if(cosCdPrifix.length > 3){  
					cosCdPrifix = cosCdPrifix.substring(0,3);   
				}	  
				    
				var compRprJoinStr = ComTrimAll(checkCompCd) + ComTrimAll(checkRprCd);	
				var sCondition = new Array (         
				 	new Array("MnrDivCd",compRprJoinStr + ',' +  cosCdPrifix,"COMMON1")
				)	  	 	       
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);      
																		         
				var lbComboText = "";    
				var lbComboCode = ""; 
				//TS형 콤보타입      
				if(comboList[0] != null){      
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
									 	
						lbComboText +=  tempText[0] + "\t" + tempText[1] + "|";
						lbComboCode +=  tempText[0] + "|";
					}	 		 		     
				} 	
				lbComboCode = MnrDelLastDelim(lbComboCode);   
				lbComboText = MnrDelLastDelim(lbComboText);     
				
				dummyEvent = true;						   	     	  		   	       
				sheetObj.CellComboItem (i, "trf_div_cd", lbComboText, lbComboCode); 
				dummyEvent = false;	
			}		 
			//DIV 값 다시 세팅		
			sheetObj.CellValue2(i,"trf_div_cd") = arrResult[i - 2][42]; 
			sheetObj.RowStatus(i) =  "R";			
		}				 
		enableOnChange = true;  	
	}
				
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate,isYardDisplay){
		var formObj = document.form; 
		var sCostType = "";
		if(formObj.eq_knd_cd.Code == "U"){
			sCostType = "MRDRRC"; 	
		} else if(formObj.eq_knd_cd.Code == "G"){ 
			sCostType = "MRGSRC";		
		} else {
			sCostType = "MRZSRC";   
		}	   	 	
		var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml); 
		
		// rfUnitMaker 조회
		var tXml = getRfUnitMaker(sheetObj, sEqNo);	
		var rfUnitMaker = ComGetEtcData(tXml,"rf_unit_maker");
		var disposal = ComGetEtcData(tXml,"disposal");		
		
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){   
			//rpr_dt (rpr_type = retArr[0][30]이  EST일때만  
			var tagObj = document.getElementById("Repair");  
			if(MnrNullToBlank(retArr[0][30]) == 'EST'){
				tagObj.innerHTML = retArr[0][32];    	
			}        
			//imm_ext   
			tagObj = document.getElementById("ImmExit");  
			tagObj.innerHTML = retArr[0][0];  
			//off_hire
			tagObj = document.getElementById("OffHire");  
			tagObj.innerHTML = retArr[0][12];     
 
			//DPP&nbsp
			tagObj = document.getElementById("DPP");  
			if(retArr[0][35] != null && retArr[0][35] != ""){
				tagObj.innerHTML = ComAddCommaRun(retArr[0][35]);            
			} else {   	
				tagObj.innerHTML = retArr[0][35];      	
			} 
			//DvValue
			tagObj = document.getElementById("DvValue");    
			if(retArr[0][10] != null && retArr[0][10] != ""){
				tagObj.innerHTML = ComAddCommaRun(retArr[0][10]);            
			} else {   	
				tagObj.innerHTML = retArr[0][10];      	
			} 	 
			//manu_dt  		 
			tagObj = document.getElementById("ManuDt");   
			tagObj.innerHTML = retArr[0][7];         
			//eq_tpsz_cd	 
			tagObj = document.getElementById("TpSz");  
			tagObj.innerHTML = retArr[0][31]; 
			formObj.eq_tpsz_cd.value = retArr[0][31];            
			//lstm_cd  	  
			tagObj = document.getElementById("Term");   
			tagObj.innerHTML = retArr[0][19];            
			//lessor_nm
			tagObj = document.getElementById("Lessor");   
			tagObj.innerHTML = retArr[0][16];        
			//Warranty 
			tagObj = document.getElementById("Warranty");  
			tagObj.innerHTML = '';  
			//crnt_yd_cd 
			if(isYardDisplay == true){
				ComSetObjValue(formObj.rpr_yd_cd,retArr[0][18]);
			}
			document.getElementById("RfUnitMaker").innerHTML = rfUnitMaker;			
			document.getElementById("Disposal").innerHTML = disposal;
		} else {	  
			document.getElementById("Repair").innerHTML = "";   
			document.getElementById("ImmExit").innerHTML = "";  
			document.getElementById("OffHire").innerHTML = "";   
			document.getElementById("Disposal").innerHTML = "";  
			document.getElementById("DPP").innerHTML = "";  
			document.getElementById("DvValue").innerHTML = "";  
			document.getElementById("ManuDt").innerHTML = "";  
			document.getElementById("TpSz").innerHTML = "";  
			document.getElementById("Term").innerHTML = "";  
			document.getElementById("Lessor").innerHTML = "";  
			document.getElementById("Warranty").innerHTML = "";   
			document.getElementById("Repair").innerHTML = "";  
			if(isYardDisplay == true){ 
				ComSetObjValue(formObj.rpr_yd_cd,"");  
			}
			document.getElementById("RfUnitMaker").innerHTML = "";			
		}
	}	
			
  /**
   * rf unit maker 정보 가져오기
   * @param sheetObj
   * @param sEqNo
   * @returns rf_unit_maker 코드
   */
	function getRfUnitMaker(sheetObj, sEqNo){
		var f_query = '';
		//쿼리 스트링 조합시작
		f_query += 'f_cmd=' + SEARCH20 + '&';
		f_query += 'eq_no=' + sEqNo;
		
		var sXml = sheetObj.GetSearchXml("MNR_COMGS.do","" ,f_query,true);
		return sXml;

	}		
	
	function setEqInfoClear(){
			var formObj = document.form;
			document.getElementById("Repair").innerHTML = "";   
			document.getElementById("ImmExit").innerHTML = "";  
			document.getElementById("OffHire").innerHTML = "";   
			document.getElementById("Disposal").innerHTML = "";  
			document.getElementById("DPP").innerHTML = "";  
			document.getElementById("DvValue").innerHTML = "";  
			document.getElementById("ManuDt").innerHTML = "";  
			document.getElementById("TpSz").innerHTML = "";  
			document.getElementById("Term").innerHTML = "";  
			document.getElementById("Lessor").innerHTML = "";  
			document.getElementById("Warranty").innerHTML = "";   
			document.getElementById("Repair").innerHTML = ""; 
			ComSetObjValue(formObj.rpr_yd_cd,"");       
			document.getElementById("RfUnitMaker").innerHTML = "";
	}
			
	/**
	 * EES_MNR_0193 Popup의 값을 받은 함수        
	 */	
	function setEES_MNR_0193(aryPopupData){
		var tagetSheet = sheetObjects[2]; 
					   			
		for(var i = 0; i < aryPopupData.length;i++){
			tagetSheet.CellValue2(t1sheet1ClickRow,"eq_loc_cd") = aryPopupData[i];  
		}	
				
		setInitSheetEdit(tagetSheet,t1sheet1ClickRow); 
		tagetSheet.SelectCell(t1sheet1ClickRow,1);      				
		tagetSheet.SumText(0,"eq_loc_cd") = "TOTAL";     
	} 
	 
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form;	 	
		        
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")       
    	 	formObj.rpr_yd_cd.value = aryPopupData[0][3];                                  
    }
	
	function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
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
				case "rpr_yd_cd":  
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03); 
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
				ComKeyOnlyNumber(obj);
				break;   
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
				if(obj.name == "rqst_ref_no"){
					ComKeyOnlyAlphabet('uppernum',"45"); 
				} else {
					ComKeyOnlyAlphabet('uppernum'); 
				}      			         
	            break; 
	    }         
	}
	
	/** 
	 * Description 설정
	 * Component,Repair,Div 시트콤보 변경시 Description을 조합하여 자동부여
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 */
	function setDescripton(sheetObj,Row) {   
		var formObj = document.form;
		var componentCode 	= sheetObj.CellValue(Row,"eq_cmpo_cd"); 
		var componentDesc	= getDescription(componentCode,4); 
		var divCode 		= sheetObj.CellValue(Row,"trf_div_cd");
		var divDescs 		= sheetObj.GetComboInfo(Row,"trf_div_cd","Text");   
		//div Desc 를 구하기 위한 
		var arrDivDesc = divDescs.split("|");       	 	
		var idx = sheetObj.GetComboInfo(Row,"trf_div_cd", "SelectedIndex");  
		var divDesc = MnrNullToBlank(arrDivDesc[idx]);
		if(divDesc != ""){
			var arrDiv = divDesc.split("\t");  
			divDesc = arrDiv[1];       
		}
		var repairCode 		= sheetObj.CellValue(Row,"eq_rpr_cd"); 
		var repairDesc 		= getDescription(repairCode,0);  
		var temp = "["+componentCode+"]"+componentDesc +" - ["+repairCode+"]"+ repairDesc+" - ["+divCode+"]" + divDesc;     
		sheetObj.CellValue2(Row ,"rpr_dtl_rmk") = temp;  
		formObj.mnr_desc.value = temp;                     
	} 
				
	/** 
	 * 시트 콤보박스의 코드에 해당하는 값을 반환
	 * Component,Repair의 코드명을 구한다.
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	콤보서열
	 * @return  {String}    tempDesc    CodeName
	 */
	function getDescription(Value,comboSeq){
		var tempDesc = "";   
 		for(var j = 0; j < sheetComboList[comboSeq].length;j++){ 
			var tempText = sheetComboList[comboSeq][j].split("|");
			if(tempText[0]==Value) {
				tempDesc = tempText[1];
				return tempDesc; 
			}   
		}
		return tempDesc; 
	}

	/**
	 * TPB Request 체크시 TPB Amount 는 0 이상이어야 한다.
	 * @return {Boolean}
	 */
	function checkTpbAmount() {
		for(var i=sheetObjects[2].HeaderRows; i<sheetObjects[2].LastRow; i++) {
			var n3ptyFlg = sheetObjects[2].CellValue(i,"n3pty_flg"); //TPB Request
			if(n3ptyFlg == "1") {
				var n3ptyBilAmt = sheetObjects[2].CellValue(i,"n3pty_bil_amt"); //TPB Amount
				if(n3ptyBilAmt <= 0) {
					ComShowCodeMessage("MNR00329"); //Third Party Amount must be greater than 0(Zero).
					sheetObjects[2].SelectCell(i, "n3pty_bil_amt", true);
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * EDI Estimate Upload 팝업화면에서 호출될 함수
	 */
	function callbackUploadConfirm(vComplexPK) {
        var formObject = document.form;		
		doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	}

	/* 개발자 작업  끝 */