/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0157.js	 	
*@FileTitle : Disposal Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08	
*@LastModifier : 박명신	
*@LastVersion : 1.0 
* 2009.07.01 박명신     
* 1.0 Creation  	
* --------------------------------------------------------
* History 	
* 2011.03.03 김영오  Start Date/End Date Logic, 제목 수정 기존 YYYY-MM-DD에서 뒤에 시분초 까지 보여지도록 수정	
* 2012.04.03 신혜정 [CHM-201217047] SaleType 이 Contract 일 경우에 Pick Up Period 입력 가능하게 수정     
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
     * @class EES_MNR_0157 : EES_MNR_0157 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0157() {
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

//쉬트  
var sheetObjects = new Array();
var sheetCnt = 0;

//파일업로드를 사용하기 위한 
var uploadObjects = new Array();
var uploadCnt = 0;

//콤보 객체   
var comboObjects = new Array();
var comboCnt = 0; 

//파일Seq저장변수 (추가될때) 
var uploadFileSeq = "";     

//TS 타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
var uTpSz = new Array();    
var gTpSz = new Array();  
var zTpSz = new Array();  

//조회여부 (조회후 삭제 가능)
var selCheck = false;

//콤보 디폴트값 
var eqKnddefCode = "";
var dispTpdefCode = "";
var appOfcdefCode = "";

//메세지용 
var actionType = "";

//이전값 기억
var preEqKndCd = ""; 
var preCurrCd = "";  
var preDispTpCd = ""; 

//IBCLEAR 일때
var isNowInit = false;  

//To DAY DEFAULT SYSTEM DATE	
var toDay = ""; 	

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
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);  
					break;
							 
					case "btn_New":     
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;	 	
						
					case "btn_Delete":  
						doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
					break;
						
					case "btn_Reject":   
						doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
						
					case "btn_Approval": 
						doActionIBSheet(sheetObjects[0],formObject,IBBATCH); 
					break; 		 
							  
					case "btn_RowAdd": 
						doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
					break; 
						
					case "btn_RowDelete":   
						doActionIBSheet(sheetObjects[0],formObject,IBCOPYROW);
					break; 	 
						
					case "btn_Excel":
						 sheetObjects[3].SpeedDown2Excel(-1);    
						 if(sheetObjects[4].RowCount > 0) {
							sheetObjects[4].Down2Excel(-1, true);
						 }
					break;	
							
					case "btn_Inquiry":	 		    
						if(tabObjects[0].SelectedIndex == 0){
							if(MnrNullToBlank(formObject.rqst_ofc_cd.value) == ''){
								ComShowCodeMessage("MNR00248");    	
							} else {
								ComOpenPopup('/hanjin/EES_MNR_0158.do?mnr_disp_trf_tp_cd=' + formObject.disp_tp_cd.Code + '&cost_ofc_cd=' + formObject.rqst_ofc_cd.value, 900, 440, 'setPopData_DSPC', '0,1,1,1,1,1,1,1', false, false, 1, 1, 3);	
							}
						}									
					break;   
					
					case "btn_buyerPopUp":
						
						var selectedBuyer = "";
						for(var i = 1; i < sheetObjects[2].Rows; i++){
							if(selectedBuyer != ""){
								selectedBuyer = selectedBuyer + "|"; 
							}
							selectedBuyer = selectedBuyer + sheetObjects[2].CellValue(i, "mnr_prnr_id")
						}
						document.form.selected_buyer.value = selectedBuyer;
						
//						ComOpenPopup('/hanjin/EES_MNR_0097.do', 800, 460, 'setEES_MNR_0097', '1,0', true);
						if(document.form.rqst_ofc_cd.value != ""){
							ComOpenPopup('/hanjin/EES_MNR_0167.do?disp_no=' + formObject.disp_no.value + '&rqst_ofc_cd=' + formObject.rqst_ofc_cd.value + '&disp_tp_cd=' + formObject.disp_tp_cd.Code, 900, 480, 'setBuyerList', '1,0', true);
						} else {
							ComShowCodeMessage("MNR00036","Disposal");
						}
//						ComOpenWindow2('/hanjin/EES_MNR_0162.do?disp_no=' + formObject.disp_no.value + '&rqst_ofc_cd=' + formObject.rqst_ofc_cd.value + '&disp_tp_cd=' + formObject.disp_tp_cd.Code, "Buyer Inquiry Pop up");
					break;
									 		 
					case "btn_biding_period":	
						//bidding 
						if(formObject.disp_tp_cd.Code == "B"){
							var cal = new ComCalendarFromTo();  	       
							cal.select(formObject.disp_st_dt,  formObject.disp_end_dt, 'yyyy-MM-dd hh:mm:ss');
						} 
					break; 
					
					case "btn_pickup_period":
							var cal = new ComCalendarFromTo();  	       
							cal.select(formObject.disp_pkup_st_dt,  formObject.disp_pkup_end_dt,  'yyyy-MM-dd'); 
					break;  
					  
					case "btn_postdt": //달력버튼
				    	//bidding 
						if(formObject.disp_tp_cd.Code == "B"){
							var cal = new ComCalendar();   
				    		cal.select(formObject.disp_bultn_dt, 'yyyy-MM-dd');
				    	}
					break; 
						 
					case "btn_FileAdd":   
						file_Insert(sheetObjects[5]);
					break;
									 	 
					case "btn_FileDelete": 
						file_Remove(sheetObjects[5]);         
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();   
		   
        for(i = 0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k = 0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        } 
		for(k = 0;k < comboObjects.length;k++){ 
            initCombo(comboObjects[k],k + 1);   
        } 	
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
			case "sheet1": 
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				} 	 
				 
            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 142;
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
						  	
					var HeadTitle1 = "|S|Disposal No.|Sale Type|EQ Type|Q'ty|Currency|Total Amount|Buyer Sel|Posting DT|Creation DT|Status"
					var headCount = ComCountHeadTitle(HeadTitle1);  
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 11, 0, 0, true);           
					 				
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
									
                    //데이터속성    [ROW, COL,      DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,	50,     daCenter,  	false,  "ibflag");
					InitDataProperty(0, cnt++,  dtSeq,    		30,     daCenter,   true,   "Seq"); 
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"disp_no",			false,		"",		dfNone,			0,		false,		false);

//					InitDataProperty(0, cnt++ , dtCombo,		80, 	daLeft,		false,	"disp_tp_cd",	    false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    80, 	daLeft,		false,	"re_disp_tp_nm",    false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,	"eq_knd_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,	"disp_qty",			false,		"",		dfInteger,		0,		false,		false);
					//InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,	"curr_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    60,		daCenter,	false,	"re_curr_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,	"disp_st_prc",		false,		"",		dfFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"buyer_cnt",		false,		"",		dfInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"disp_bultn_dt",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	"rqst_dt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		50,	daLeft,		false,	"disp_sts_cd",		false,		"",		dfNone,			0,		false,		false);
									
					//히든 데이타  
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_st_dt",      false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_end_dt",     false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_pkup_st_dt", false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_pkup_end_dt",false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_eml_flg",    false,      "",     dfNone,    		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "apro_ofc_cd",     false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "re_apro_ofc_cd",     false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "file_seq",     	false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rqst_ofc_cd",     	false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rqst_usr_id",     	false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_disp_rmk",     	false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,		0, 	    daCenter,	false,	 "re_disp_tp_cd",   false,		"",		dfNone,			0,	   false,	   false);
											 						
					CountPosition = 0;	  
			}				
			break;  	
				
			case "sheet3": 
                with (sheetObj) { 
                    // 높이 설정
                    style.height = 122;  
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
 
					var HeadTitle1 = "|Sel|Seq|Buyer Code|Buyer Name|Buyer Type"; 

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다.
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
 							 
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,    daCenter,  	false,  "ibflag"); 
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk");		  
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  "Seq",     		false,          "",    	dfNone     );
					InitDataProperty(0, cnt++ , dtData,			70, 	daLeft,		false,	"mnr_prnr_id",	    false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			135,	daLeft,	    false,  "vndr_lgl_eng_nm",		 	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,	daLeft,		false,		"mnr_prnr_knd_cd",		false,		"",			dfNone,			0,		false,		false);
				          			
					//키값 히든용 
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_no",        false,      "",     dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "ofc_cd",        false,      "",     dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_prnr_eml",        false,      "",     dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "part_amt",        false,      "",     dfNone,    			0,     true,       true);
					//mnr_prnr_id = mnr_prnr_cnt_cd + mnr_prnr_seq
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_prnr_cnt_cd",        false,      "",     dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_prnr_seq",     false,      "",     dfNone,    			0,     true,       true);
					CountPosition = 0;  
				    	 
					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true; 
			}
			break;  	
			
			case "sheet4":
                with (sheetObj) {
					var prefix = "";   
						
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					// 높이 설정
					style.height = 62;     
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					 		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;	
						
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 13, 100);  
						
					var HeadTitle1 = "|Seq.|File|Download";
								
					var headCount = ComCountHeadTitle(HeadTitle1);									
						
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
					 
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false); 
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);  
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	 prefix +	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,	 prefix +	"del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	200,    daCenter,  false,   prefix + "org_file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  false,   prefix + "file_dw",   false,          "",      dfNone,      0,     false,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    daCenter,  false,   prefix + "file_path_nm",   	false,          "",      dfNone,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    daCenter,  false,   prefix + "file_path",   	false,          "",      dfNone,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    daCenter,  false,   prefix + "file_seq",   		false,          "",      dfNone,      0,     true,      true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  prefix +	"file_dtl_seq",	   false,		"",		 dfNone,		0,			false,		false);
	 				
					CountPosition = 0;           
					 
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1; 
			}
			break;  	

			case "t1_sheet1": 
                with (sheetObj) {
                    // 높이 설정  
                    style.height = 122;     
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
 						
					var HeadTitle1 = "|Sel|Seq.|EQ No.|TP/SZ|Term|MVNT|Yard|Material|Maker Name|Unit Model|U.Price|MNR Cost(USD)|Sale Category|Price Verify Result|Remark(s)";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(19, 0, 0, true); 	

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다.
					InitHeadMode(true, true, true, true, false,false);
						 	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
						
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,     daCenter,  	false,  	"ibflag");  
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"del_chk"); 		 
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  	"Seq",     			false,      "",    		dfNone     );
					InitDataProperty(0, cnt++ , dtData,			100, 	daLeft,		false,		"eq_no",			true,		"",			dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,		"eq_tpsz_cd",		false,		"",			dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"lstm_cd",			false,		"",			dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"mvmt_cd",			false,		"",			dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"disp_yd_cd",		true,		"",			dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,		"mtrl_nm",			false,		"",			dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,		"mkr_nm",			false,		"",			dfNone,		0,	false,	false);  
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,		"mdl_nm",			false,		"",			dfNone,		0,	false,	false); 
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		"disp_ut_prc",		true,		"",			dfFloat,	2,	true,	true,	13);		
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		"rpr_cost_amt",		false,		"",			dfNullFloat,2,	false,	false);		
					InitDataProperty(0, cnt++ , dtCombo,		150,	daLeft,		false,		"disp_rsn_cd",		false,		"",			dfNone,		0,	true,	true);		
					InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		false,		"disp_vrfy_tp_cd",	false,		"",			dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"mnr_disp_dtl_rmk",	false,		"",			dfNone,		0,	true,	true,	4000);	
					//키값 히든용    	   
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"disp_ut_tp_cd",    false,      "",     	dfNone,    	0,  true,   true);	 	
					InitDataProperty(0, cnt++ , dtHidden,		0,		daRight,	false,		"disp_qty",		 	true,		"",			dfInteger,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daRight,	false,		"disp_trf_ut_prc",		true,		"",			dfFloat,	0,	true,	true);
									 		  			  		 				
					CountPosition = 0;    
														 	
					//데이터 Validation			 
					InitDataValid(0,  "eq_no", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "disp_yd_cd", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "mdl_nm", vtEngUpOther,"0123456789!@#$%^&*()_+-=\][}{:;/.,?><~\"\'"); 
						
					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true; 
			}	
			break;    
			case "t2_sheet1":  
                with (sheetObj) {
                    // 높이 설정		
                    style.height = 122; 
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
 	
					var HeadTitle1 = "|Sel|Seq.|TP/SZ|Q'ty|Location|U.Pirce|Price Verify Result|Remark(s)";
						
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다. 
					InitHeadMode(true, true, true, true, false,false);
								
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 
 						
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,     daCenter,  	false,  	"ibflag");  
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		"del_chk"); 		 
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  	"Seq",     			false,      "",    		dfNone     );
					InitDataProperty(0, cnt++ , dtCombo,		60, 	daCenter,	false,		"eq_tpsz_cd",		true,		"",			dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		"disp_qty",		 	true,		"",			dfInteger,	0,	true,	true,	6);
					//location 은 야드에 저장   
					InitDataProperty(0,	cnt++,	dtPopupEdit,	80,		daCenter,	false,		"disp_yd_cd",		true,		"",			dfNone,		0,	true,	true );  
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		"disp_ut_prc",		true,		"",			dfFloat,	2,	true,	true,	13);		
					InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		false,		"disp_vrfy_tp_cd",	false,		"",			dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"mnr_disp_dtl_rmk",	false,		"",			dfNone,		0,	true,	true,	4000);		
					//키값 히든용 	  
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"disp_ut_tp_cd",    false,      "",     	dfNone,    	0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daRight,	false,		"disp_trf_ut_prc",		true,		"",			dfFloat,	0,	true,	true); 
					InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		false,		"disp_rsn_cd",		false,		"",			dfNone,		0,	true,	true); 
					  		 								 
					PopupImage  =  "/hanjin/img/btns_search.gif";  
					ShowButtonImage = 2;   
					CountPosition = 0;	
						
					//데이터 Validation 
					InitDataValid(0,  "disp_yd_cd", vtEngUpOther,"0123456789");  
					
					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true;  
			}				
			break;  
			
        }
    }

 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){ 
					//헤더 리스트 조회   
					formObj.f_cmd.value = SEARCH;    
				    sParam = FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0157GS.do", sParam);
				    sheetObjects[1].LoadSearchXml(sXml);    	
				}	 	 	
				break;	
 					
			case IBINSERT:      // 행입력
				var sheetObj;
				var dispUtTpCd = "";	
				if(tabObjects[0].SelectedIndex == 0){
					sheetObj = sheetObjects[3];	
					dispUtTpCd = "E";
				} else {	
					sheetObj = sheetObjects[4]; 	
					dispUtTpCd = "Q";	
					//Bidding 일때 TPSZ 한개만 선택가능 
					if(formObj.disp_tp_cd.Code == "B" && sheetObj.RowCount > 0){
						ComShowCodeMessage("MNR00317");        
						return;   		
					}   	
				}				
						 						  
			    var Row = sheetObj.DataInsert(-1);  	 
				sheetObj.CellValue2(Row,"disp_ut_tp_cd") = dispUtTpCd;  
				sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; 
				
				if(tabObjects[0].SelectedIndex == 0){ 
					sheetObj.CellValue2(Row,"disp_qty") = "1";  
					sheetObj.CellValue2(Row,"mkr_nm") = "";    
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "";   
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = ""; 
					sheetObj.CellEditable(Row, "disp_yd_cd") = false;       
				} else {
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "";    
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = ""; 
					sheetObj.CellValue2(Row,"disp_rsn_cd") = "C";     
					sheetObj.SelectCell(Row,"eq_tpsz_cd"); 
				}	 
                break;
			
			case IBCOPYROW:     // 행삭제 
				var sheetObj;
				if(tabObjects[0].SelectedIndex == 0){
					sheetObj = sheetObjects[3];	
				} else {
					sheetObj = sheetObjects[4]; 			
				}  
				 	
				MnrRowDelete(sheetObj,  "del_chk"); 
				reSetQtyAndPrice();
				break; 
		
			case IBSAVE:        //REJECT
              if(validateForm(sheetObj,formObj,sAction)){ 
					actionType = "IBSAVE";
					formObj.f_cmd.value = MODIFY;
					formObj.disp_sts_cd.Code = "HJ";    
									
					if(uploadFileSeq != undefined){ 	
						formObj.file_seq.value = uploadFileSeq;	 	
					}   	
				    				 	 													          
					var sParam1 = sheetObjects[3].GetSaveString(true, true);     
					//멘덴토리 체크         
					if(sParam1 == "" && sheetObjects[3].IsDataModified){  
						return; 		
					}   
					sParam1 = ComSetPrifix(sParam1,"rqstDtl_");      
						    	    
					var sParam2 = sheetObjects[4].GetSaveString(true, true);    
					//멘덴토리 체크         
					if(sParam2 == "" && sheetObjects[4].IsDataModified){  
						return; 		
					}  	
					sParam2 = ComSetPrifix(sParam2,"rqstDtl_");         
								 
					var sParam3 = sheetObjects[2].GetSaveString(false, true, "del_chk");      
					//멘덴토리 체크         
					if(sParam3 == "" && sheetObjects[2].IsDataModified){  
						return; 	 		
					}    
					sParam3= ComSetPrifix(sParam3,"rqstPart_");     
					
					if (!ComShowCodeConfirm("MNR00252")){return;}  			 								 
				    var sParam = sParam1 + "&" + sParam2 + "&" + sParam3 + "&" +FormQueryString(formObj); 
				    var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0157GS.do", sParam); 
											      	    
					sheetObjects[1].LoadSaveXml(sXml); 
					if(MnrComGetErrMsg(sXml) != null){
						sheetObjects[1].RemoveAll();
					}	
					
					MnrWaitControl(true);
					//IBCLEAR START 
					isNowInit = true;  
					uploadFileSeq = "";     
					selCheck = false;   
					actionType = "";
					      
					//차후에 하나씩 개별로  
					formObj.reset();  
					
					//쉬트 초기화		
					for(var i = 2; i < sheetObjects.length;i++){ 
						sheetObjects[i].RemoveAll();   	
					}    	   										
				    	 
					//공통콤보 정보를 가져온다.     
					//eq_knd_cd 세팅  EQ_TYPE            
					formObj.eq_knd_cd.Code = eqKnddefCode;    
					formObj.disp_tp_cd.Code = dispTpdefCode;
					formObj.curr_cd.Code = "USD";  		 
					formObj.disp_sts_cd.Code = "";  
					formObj.disp_sts_cd.enable = false;   
					formObj.disp_eml_flg_temp.checked = false;  
							 	
					//초기값 설정 
					ComSetObjValue(formObj.apro_ofc_cd,"");      
					ComSetObjValue(formObj.rqst_dt,"");     
					ComSetObjValue(formObj.disp_no,"");    
					ComSetObjValue(formObj.disp_qty,"0");       
					ComSetObjValue(formObj.disp_st_prc,"0");  
					 
					isNowInit = false;
					//IBCLEAR END	
					MnrWaitControl(false);           
				} 	
				break; 
						 
			case IBBATCH:        //APPROVAL  
              if(validateForm(sheetObj,formObj,sAction)){ 
			  		actionType = "IBBATCH"; 
					formObj.f_cmd.value = MODIFY;
					 
					if(formObj.disp_tp_cd.Code == "C"){
						formObj.disp_sts_cd.Code = "HC";  	
					} else { 
						formObj.disp_sts_cd.Code = "HA";      
					}  
					 	
					if(uploadFileSeq != undefined){ 	
						formObj.file_seq.value = uploadFileSeq;	 	
					}   	
				    				 	 													          
					var sParam1 = sheetObjects[3].GetSaveString(true, true);     
					//멘덴토리 체크         
					if(sParam1 == "" && sheetObjects[3].IsDataModified){  
						return; 		
					}   
					sParam1 = ComSetPrifix(sParam1,"rqstDtl_");      
						    	    
					var sParam2 = sheetObjects[4].GetSaveString(true, true);    
					//멘덴토리 체크         
					if(sParam2 == "" && sheetObjects[4].IsDataModified){  
						return; 		
					}  	
					sParam2 = ComSetPrifix(sParam2,"rqstDtl_");         
								 
					var sParam3 = sheetObjects[2].GetSaveString(false, true, "del_chk");      
					//멘덴토리 체크         
					if(sParam3 == "" && sheetObjects[2].IsDataModified){  
						return; 	 		
					}    
					sParam3 = ComSetPrifix(sParam3,"rqstPart_");     
					 	
					if (!ComShowCodeConfirm("MNR00253")){return;}     			 								 
				    var sParam = sParam1 + "&" + sParam2 + "&" + sParam3 + "&" +FormQueryString(formObj); 
				    var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0157GS.do", sParam); 
					 						      	    
					sheetObjects[1].LoadSaveXml(sXml); 
					if(MnrComGetErrMsg(sXml) != null){
						sheetObjects[1].RemoveAll();
					}	
					 
					MnrWaitControl(true);
					//IBCLEAR START 
					isNowInit = true;  
					uploadFileSeq = "";     
					selCheck = false;   
					actionType = "";
					      
					//차후에 하나씩 개별로  
					formObj.reset();  
					
					//쉬트 초기화		
					for(var i = 2; i < sheetObjects.length;i++){ 
						sheetObjects[i].RemoveAll();   	
					}    	   										
				    	 
					//공통콤보 정보를 가져온다.     
					//eq_knd_cd 세팅  EQ_TYPE            
					formObj.eq_knd_cd.Code = eqKnddefCode;    
					formObj.disp_tp_cd.Code = dispTpdefCode;
					formObj.curr_cd.Code = "USD";  		 
					formObj.disp_sts_cd.Code = "";  
					formObj.disp_sts_cd.enable = false;   
					formObj.disp_eml_flg_temp.checked = false;  
					  	
					//초기값 설정 
					ComSetObjValue(formObj.apro_ofc_cd,"");     
					ComSetObjValue(formObj.rqst_dt,"");     
					ComSetObjValue(formObj.disp_no,"");    
					ComSetObjValue(formObj.disp_qty,"0");       
					ComSetObjValue(formObj.disp_st_prc,"0");  
					    
					isNowInit = false; 
					//IBCLEAR END	
					MnrWaitControl(false);               
				} 	
				break; 	 
					 
			case IBROWSEARCH:      //건당 상세 조회     
                 if(validateForm(sheetObj,formObj,sAction)){ 
					 	formObj.f_cmd.value = SEARCH01;         
					    sParam = FormQueryString(formObj);      
					    var sXml = sheetObj.GetSaveXml("EES_MNR_0157GS.do", sParam);
					   	var arrXml = sXml.split("|$$|");       
									                  
						for(var i = 0; i < arrXml.length; i++){   
							sheetObjects[i + 2].LoadSearchXml(arrXml[i]);
						} 	  
						
						//하이라이트 표시 
						for(var x = 1 ; x <= sheetObjects[2].RowCount;x++){  
							MnrCheckRowColChange(sheetObjects[2],sheetObjects[2].CellValue(x,"del_chk"),x); 				
						} 
						   
						for(var x = 1 ; x <= sheetObjects[3].RowCount;x++){
							//1. Repair Cost를 'Sale Category'옆에 추가해주세요. 2. Manual 입력이며 Damage인 경우에 입력가능합니다
							var checkRsnCd = MnrNullToBlank(sheetObjects[3].CellValue(x,"disp_rsn_cd"));  
							if(checkRsnCd == 'C'){
								sheetObjects[3].CellValue2(x,"rpr_cost_amt") = "";			 	
								sheetObjects[3].CellEditable(x, "rpr_cost_amt") = false; 
							} else {	
								sheetObjects[3].CellEditable(x, "rpr_cost_amt") = true;
							}			  	
						}
							
						if(sheetObjects[3].RowCount > 0){
							tabObjects[0].SelectedIndex = 0; 		
						} else {	
							tabObjects[0].SelectedIndex = 1;  
						}					  
				  }        
                break; 		
			
			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)){ 
						actionType = "IBDELETE"; 
					 	formObj.f_cmd.value = REMOVE01;       	     
						sParam = FormQueryString(formObj);       
					   	 	
						var sXml = sheetObj.GetSaveXml("EES_MNR_0157GS.do", sParam);
						sheetObjects[1].RemoveAll(); 	
						sheetObjects[1].LoadSaveXml(sXml); 	 
						if(MnrComGetErrMsg(sXml) != null){	
							sheetObjects[1].RemoveAll();
						}	
					 		 
						MnrWaitControl(true);
						//IBCLEAR START 
						isNowInit = true;  
						uploadFileSeq = "";     
						selCheck = false;   
						actionType = "";
						      
						//차후에 하나씩 개별로  
						formObj.reset();  
						 
						//쉬트 초기화		
						for(var i = 2; i < sheetObjects.length;i++){ 
							sheetObjects[i].RemoveAll();   	
						}    	   										
					    	 
						//공통콤보 정보를 가져온다.     
						//eq_knd_cd 세팅  EQ_TYPE            
						formObj.eq_knd_cd.Code = eqKnddefCode;    
						formObj.disp_tp_cd.Code = dispTpdefCode;
						formObj.curr_cd.Code = "USD";  		 
						formObj.disp_sts_cd.Code = "";  
						formObj.disp_sts_cd.enable = false;   
						formObj.disp_eml_flg_temp.checked = false;   
							  	
						//초기값 설정 
						ComSetObjValue(formObj.apro_ofc_cd,"");      
						ComSetObjValue(formObj.rqst_dt,"");     
						ComSetObjValue(formObj.disp_no,"");    
						ComSetObjValue(formObj.disp_qty,"0");       
						ComSetObjValue(formObj.disp_st_prc,"0");  
						    
						isNowInit = false; 
						//IBCLEAR END	
						MnrWaitControl(false);	  
				 }   
				break;
									
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				isNowInit = true;  
				sheetObj.WaitImageVisible=false;
				
				//EQ_TYPE별 타입사이를 조회해서 각 배열에 담는다.  
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
				
				//OFC별 로칼 데이트를 가져온다.
				toDay = MnrGetLocalDate(sheetObjects[0],ofcCd);					
						   
				//전역 변수 초기화		
				uploadFileSeq = "";	 	   
				selCheck = false;   	
				actionType = "";
				  
				//폼 초기화 
				formObj.reset();   
				
				//쉬트 초기화		
				for(var i = 2; i < sheetObjects.length;i++){ 
					sheetObjects[i].RemoveAll();   	
				}    	   										
				 
				//콤보 초기화  
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].Code = "-1"; 
					comboObjects[i].RemoveAll(); 	
				}  
										  
				//공통콤보 정보를 가져온다.    
				var sCondition = new Array ( 
					//폼 콤보  
					new Array("MnrGenCd","CD00035", "COMMON"),  //IN_DISP_TP_CD,DISP_TP_CD
					new Array("MdmCurrency","","COMMON"),       //CUR_CD
					new Array("MnrGenCd","CD00029", "COMMON"),  //DISP_STS_CD
					new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9"),
					//sheetObjects[1] 콤보
					new Array("MnrGenCd","CD00035", "COMMON"),	//DISP_TP_CD
					new Array("MnrGenCd","CD00002", "COMMON"),	//EQ_KND_CD
					new Array("MdmCurrency","","COMMON"),       //CURR_CD
					new Array("MnrGenCd","CD00029", "COMMON"),  //DISP_STS_CD
					//sheetObjects[2] 콤보
					new Array("MnrGenCd","CD00034", "COMMON"),	//BYER TYPE
					//sheetObjects[3] 콤보
					new Array("MnrGenCd","CD00038", "COMMON"),	//DISP_RSN_CD	
					new Array("MnrGenCd","CD00087", "COMMON"),  //MKR_NM
					new Array("MnrGenCd","CD00080", "COMMON")   //disp_vrfy_tp_cd
				)	
				  	 		 	  
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
				//IN_DISP_TP_CD,DISP_TP_CD 세팅	 
				formObj.in_disp_tp_cd.InsertItem(0,"ALL","ALL");
				if(comboList[0] != null){	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						if(j == 0){
							dispTpdefCode = tempText[0]; 
						}     	
						formObj.in_disp_tp_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
						formObj.disp_tp_cd.InsertItem(j , tempText[1] ,tempText[0]);
					}     	    
				}     
				formObj.in_disp_tp_cd.Code ="ALL"; 
				formObj.disp_tp_cd.Code = dispTpdefCode; 
				  
				//CURRENCY 세팅          
				if(comboList[1] != null){       
					for(var j = 0; j < comboList[1].length;j++){  
						var tempText = comboList[1][j].split("|");   
						formObj.curr_cd.InsertItem(j,tempText[0] ,tempText[0]);
					}     
				}   	   		  
				formObj.curr_cd.Code = "USD";
				
				//DISP_STS_CD 세팅          
				if(comboList[2] != null){       
					for(var j = 0; j < comboList[2].length;j++){  
						var tempText = comboList[2][j].split("|");   
						formObj.disp_sts_cd.InsertItem(j,tempText[1] ,tempText[0]);
					} 	  
				} 		   		 
				formObj.disp_sts_cd.Code = "HS";  
				formObj.disp_sts_cd.enable = false;   
				
				//EQ_KND_CD 세팅
				if(comboList[3] != null){ 	       
					for(var j = 0; j < comboList[3].length;j++){ 
						var tempText = comboList[3][j].split("|");  
						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){ 
							eqKnddefCode = tempText[0];
						}  	
					}    			    
				}     	 	  	 
				formObj.eq_knd_cd.Code = eqKnddefCode;
			
				//쉬트 콤보 세팅    
				var sheetComboCode = "";
				var sheetComboText = ""; 
				var sheetComboCodeText = ""; 
				//DEF 값 저장을 위해 
				var sheetComboDefault = new Array();    	
				var comboSaveNames = new Array();
				//------ sheetObjects[1]
				comboSaveNames[0] = "disp_tp_cd";
				comboSaveNames[1] = "eq_knd_cd";  
				comboSaveNames[2] = "curr_cd"; 
				comboSaveNames[3] = "disp_sts_cd";
				//------ sheetObjects[2]
				comboSaveNames[4] = "mnr_prnr_knd_cd";   
				//------ sheetObjects[3]
				comboSaveNames[5] = "disp_rsn_cd";
				comboSaveNames[6] = "mkr_nm";  
				comboSaveNames[7] = "disp_vrfy_tp_cd";     
							   
				for(var i = 4; i < comboList.length;i++){
					if(comboList[i] != null){  
						sheetComboText = "";  
						sheetComboCode = "";
						//sheetComboCodeText = "";     
						 	 	  
				 		for(var j = 0; j < comboList[i].length;j++){	 
							var tempText = comboList[i][j].split("|");   
							sheetComboCode +=  tempText[0] + "|";    
							sheetComboText +=  tempText[1] + "|";
							//sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j == 0){     	     
								sheetComboDefault[i - 4] = tempText[0];             	
							}   											  
						} 	  			    		
										  	  
						sheetComboCode 		= 	 MnrDelLastDelim(sheetComboCode); 																				
				     	sheetComboText 		= 	 MnrDelLastDelim(sheetComboText);  
				        //sheetComboCodeText 	= 	 MnrDelLastDelim(sheetComboCodeText); 
							   
						if(comboSaveNames[i - 4] == "disp_tp_cd"){        		
							// combo 제거, 2014-04-28, 신용찬
							//sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);							
						} else if(comboSaveNames[i - 4] == "eq_knd_cd"){   		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);	
						} else if(comboSaveNames[i - 4] == "curr_cd"){    		
							//sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboCode, sheetComboCode ,sheetComboDefault[i - 4]);	
						} else if(comboSaveNames[i - 4] == "disp_sts_cd"){  		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);	
						} else if(comboSaveNames[i - 4] == "mnr_prnr_knd_cd"){ 	
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);	
						} else if(comboSaveNames[i - 4] == "disp_rsn_cd"){	
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "mkr_nm"){	
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						} else if(comboSaveNames[i - 4] == "disp_vrfy_tp_cd"){	
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
							sheetObjects[4].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault[i - 4]);
						}       
					}	      
				}	
				 					  
				//폼 초기값 설정 
				ComSetObjValue(formObj.apro_ofc_cd,"");          
				ComSetObjValue(formObj.rqst_dt,"");         
				ComSetObjValue(formObj.disp_qty,"0");        
				ComSetObjValue(formObj.disp_st_prc,"0");
				formObj.disp_eml_flg_temp.checked = false;     
				  		
				sheetObj.WaitImageVisible=true;	
				isNowInit = false;   
				MnrWaitControl(false);  	
				break;			
        }				
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
					BaseColor = "243,242,248"; 
                    InsertTab( cnt++ , "Unit Sale" , -1 );       
                    InsertTab( cnt++ , "Bulk Sale" , -1 ); 
                }
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){            	        
	    	switch(sAction) {   	
				//REJECT 
				case IBSAVE:   
					var Row = sheetObjects[3].ColValueDup("eq_no");
					if(Row > 0){         		          
						ComShowCodeMessage("MNR00006","EQ No ");
						sheetObjects[3].CellValue2(Row,"eq_no") = "";
						sheetObjects[3].CellValue2(Row,"eq_tpsz_cd") = ""; 	  
						sheetObjects[3].CellValue2(Row,"lstm_cd") = "";  		
						sheetObjects[3].CellValue2(Row,"mvmt_cd") = "";  	
						sheetObjects[3].CellValue2(Row,"disp_yd_cd") = "";  
						sheetObjects[3].CellValue2(Row,"mtrl_nm") = "";  
						sheetObjects[3].CellValue2(Row,"mkr_nm") = ""; 
						sheetObjects[3].CellValue2(Row,"mdl_nm") = ""; 
						sheetObjects[3].CellValue2(Row,"disp_ut_prc") = "0.00";
						sheetObjects[3].CellValue2(Row,"disp_vrfy_tp_cd") = "";   
						sheetObjects[3].CellValue2(Row,"disp_trf_ut_prc") = ""; 
						sheetObjects[3].CellValue2(Row,"rpr_cost_amt") = ""; 
						sheetObjects[3].SelectCell(Row,"eq_no");					
						return false;									              
					}
					
					if(sheetObjects[3].RowCount > 0 && sheetObjects[4].RowCount > 0){
						ComShowCodeMessage("MNR00274");        	
						return false;    
					}  
					
					if(!selCheck){ 
						ComShowCodeMessage("MNR00251");      
						return false; 
					}
					
					if(disp_eml_flg_temp.checked == true){
						formObj.disp_eml_flg.value = "Y";  
					} else {
						formObj.disp_eml_flg.value = "N"; 
					}
					
					if (!ComChkValid(formObj)) return false;
					
					//price와 qty는 0보다 커다 한다.
					for(var x = 1 ; x <= sheetObjects[3].RowCount;x++){  			
						if(parseFloat(sheetObjects[3].CellValue(x,"disp_ut_prc")) == 0){
							ComShowCodeMessage("MNR00245","Disposal ");    
							sheetObjects[3].SelectCell(x,"disp_ut_prc"); 
							return false;   
						} 	
					}  	
					for(var x = 1 ; x <= sheetObjects[4].RowCount;x++){ 			
						if(parseFloat(sheetObjects[4].CellValue(x,"disp_ut_prc")) == 0){
							ComShowCodeMessage("MNR00245","Disposal ");   
							sheetObjects[4].SelectCell(x,"disp_ut_prc");  
							return false;
						}	
						
						if(parseInt(sheetObjects[4].CellValue(x,"disp_qty")) == 0){
							ComShowCodeMessage("MNR00224","Disposal ");    
							sheetObjects[4].SelectCell(x,"disp_qty"); 
							return false;
						}   
					}     
					  
					//Buyer Selection 은 한개이상
					if(sheetObjects[2].FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00246","Buyer");
						return false;
					}
					//price와 qty는 두개합쳐 한개이상  
					if((sheetObjects[3].RowCount + sheetObjects[4].RowCount) < 1){
						ComShowCodeMessage("MNR00247","Detail");
						return false; 
					} 
					break;  
				//APPROVAL   		  
				case IBBATCH:     
					var Row = sheetObjects[3].ColValueDup("eq_no");
					if(Row > 0){         		          
						ComShowCodeMessage("MNR00006","EQ No ");
						sheetObjects[3].CellValue2(Row,"eq_no") = "";
						sheetObjects[3].CellValue2(Row,"eq_tpsz_cd") = ""; 	  
						sheetObjects[3].CellValue2(Row,"lstm_cd") = "";  		
						sheetObjects[3].CellValue2(Row,"mvmt_cd") = "";  	
						sheetObjects[3].CellValue2(Row,"disp_yd_cd") = "";  
						sheetObjects[3].CellValue2(Row,"mtrl_nm") = "";  
						sheetObjects[3].CellValue2(Row,"mkr_nm") = ""; 
						sheetObjects[3].CellValue2(Row,"mdl_nm") = ""; 
						sheetObjects[3].CellValue2(Row,"disp_ut_prc") = "0.00";
						sheetObjects[3].CellValue2(Row,"disp_vrfy_tp_cd") = "";   
						sheetObjects[3].CellValue2(Row,"disp_trf_ut_prc") = ""; 
						sheetObjects[3].CellValue2(Row,"rpr_cost_amt") = ""; 
						sheetObjects[3].SelectCell(Row,"eq_no");					
						return false;									              
					}
					  
					if(sheetObjects[3].RowCount > 0 && sheetObjects[4].RowCount > 0){
						ComShowCodeMessage("MNR00274");        	
						return false;    
					}    
					
					if(!selCheck){ 
						ComShowCodeMessage("MNR00250");   
						return false; 
					}
					
					if(disp_eml_flg_temp.checked == true){
						formObj.disp_eml_flg.value = "Y";  
					} else {
						formObj.disp_eml_flg.value = "N"; 
					}
					
					if (!ComChkValid(formObj)) return false;
					
					//price와 qty는 0보다 커다 한다.
					for(var x = 1 ; x <= sheetObjects[3].RowCount;x++){  			
						if(parseFloat(sheetObjects[3].CellValue(x,"disp_ut_prc")) == 0){
							ComShowCodeMessage("MNR00245","Disposal ");    
							sheetObjects[3].SelectCell(x,"disp_ut_prc"); 
							return false;   
						}	
					}  	
					for(var x = 1 ; x <= sheetObjects[4].RowCount;x++){ 			
						if(parseFloat(sheetObjects[4].CellValue(x,"disp_ut_prc")) == 0){
							ComShowCodeMessage("MNR00245","Disposal ");   
							sheetObjects[4].SelectCell(x,"disp_ut_prc");  
							return false;
						}	
						
						if(parseInt(sheetObjects[4].CellValue(x,"disp_qty")) == 0){
							ComShowCodeMessage("MNR00224","Disposal ");    
							sheetObjects[4].SelectCell(x,"disp_qty"); 
							return false;
						}   
					}  
					  
					//Buyer Selection 은 한개이상
					if(sheetObjects[2].FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00246","Buyer");
						return false;
					}
					//price와 qty는 두개합쳐 한개이상  
					if((sheetObjects[3].RowCount + sheetObjects[4].RowCount) < 1){
						ComShowCodeMessage("MNR00247","Detail");
						return false; 		
					}	
					break; 	
					 	
				//상세조회    
				case IBROWSEARCH:  	
					if(MnrNullToBlank(disp_no.value) == "" || MnrNullToBlank(disp_no.value) == "NEW"){
						ComShowCodeMessage("MNR00248","Disposal ");  
						return false;  		 
					}			
					break; 	  	
								
				case IBDELETE:
					if(!selCheck){
						ComShowCodeMessage("MNR00132");  
						return false; 
					}	
								
					if (!ComShowCodeConfirm("MNR00275","Disposal","Delete")){return false;}  
					break; 	 		  
			}		 
		}	
        return true; 
    }	
			
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 
			if(actionType == "IBSAVE"){ 
				ComShowCodeMessage("MNR00137");
			} else if(actionType == "IBBATCH") {
				ComShowCodeMessage("MNR00138"); 					 
			} else {	
				ComShowCodeMessage("MNR00020"); 	
			} 				 				   
		} 	
	}

	/********************************SHEET EVENT *******************************/
	function sheet2_OnDblClick(sheetObj,Row,Col) 
    {				
		var formObj = document.form; 
		with(sheetObj){ 
			//헤더 정보를 세팅한다. 
			isNowInit = true;    

			// logic 결함 수정, 신용찬, 2014-04-28
			//formObj.disp_tp_cd.Code = CellValue(Row,"disp_tp_cd");
			formObj.disp_tp_cd.Code = CellValue(Row,"re_disp_tp_cd");			
			   	
			formObj.disp_no.value = CellValue(Row,"disp_no");  	
			formObj.eq_knd_cd.Code = CellValue(Row,"eq_knd_cd");     
			formObj.disp_qty.value = ComAddComma2(CellValue(Row,"disp_qty"), "#,###");       
			formObj.disp_st_prc.value = ComAddComma2(CellValue(Row,"disp_st_prc"), "#,###");       
			formObj.disp_bultn_dt.value = CellValue(Row,"disp_bultn_dt");        
			formObj.rqst_ofc_cd.value = CellValue(Row,"rqst_ofc_cd");    
			formObj.rqst_usr_id.value = CellValue(Row,"rqst_usr_id");   
			formObj.rqst_dt.value = CellValue(Row,"rqst_dt");        
			formObj.disp_sts_cd.Code = CellValue(Row,"disp_sts_cd");       
			formObj.disp_st_dt.value = CellValue(Row,"disp_st_dt");       
			formObj.disp_end_dt.value = CellValue(Row,"disp_end_dt");       
			formObj.disp_pkup_st_dt.value = CellValue(Row,"disp_pkup_st_dt");       
			formObj.disp_pkup_end_dt.value = CellValue(Row,"disp_pkup_end_dt"); 
			
			// logic 결함 수정, 신용찬, 2015-06-16			
//			formObj.apro_ofc_cd.value = CellValue(Row,"apro_ofc_cd");         
//			formObj.curr_cd.Code = CellValue(Row,"curr_cd"); 
			formObj.apro_ofc_cd.value = CellValue(Row,"re_apro_ofc_cd");
			formObj.curr_cd.Code = CellValue(Row,"re_curr_cd");			
			
			formObj.mnr_disp_rmk.value = CellValue(Row,"mnr_disp_rmk");
			 
			if(formObj.disp_sts_cd.Code=="HA")
			{
				formObj.curr_cd.Enable=false;
			}else{
				formObj.curr_cd.Enable=true;
			}
							
			if(CellValue(Row,"disp_eml_flg") == 'Y'){ 	 
				formObj.disp_eml_flg.value = 'Y'; 	
				formObj.disp_eml_flg_temp.checked = true; 	
			} else {		
				formObj.disp_eml_flg.value = 'N'; 
				formObj.disp_eml_flg_temp.checked = false; 
			}
			isNowInit = false;         
			//현제 조회상태 
			selCheck = true;
			tabObjects[0].SelectedIndex = 0;	     					
							
			//해당 쉬트 초기화    
			sheetObjects[2].RemoveAll();   
			sheetObjects[3].RemoveAll();  
			sheetObjects[4].RemoveAll();    
			sheetObjects[5].RemoveAll();     
						 
			//파일 리스트 조회    
			var fileSeq = CellValue(Row,"file_seq");  
			uploadFileSeq = fileSeq;
			if(fileSeq != "" && fileSeq != null){ 
				var fileXml = SearchFileUpload(sheetObjects[5],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[5].LoadSearchXml(fileXml);		
				} 	
			}	      
    		  											
			//디테일 조회   	 
			doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);     
			return;        
		} 
    }  
			 
	function sheet3_OnChange(sheetObj,Row, Col, Value)	{
		var formObj = document.form;  
		if(sheetObj.ColSaveName(Col) == "del_chk"){
			//contract 일때는 1개만 선택가능  
			if(formObj.disp_tp_cd.Code == "C"){
				var sRow = sheetObj.FindCheckedRow("del_chk");
				if(sRow != ""){
					var arrRow = sRow.split("|"); 
					if(arrRow.length > 2){  
						//Buyer Selection 은 무조건 초기화 
						initBuyerSelection();      
						//다시 선택  
						sheetObj.CellValue2(Row,"del_chk") = "1";      
					}   	
				}  		
			}
			MnrCheckRowColChange(sheetObj,sheetObj.CellValue(Row,"del_chk"),Row);	
		} 		
	}
			
	function t1_sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj = document.form;   
		if (sheetObj.ColSaveName(Col) == "eq_no"){
			var checkEqn = sheetObj.CellValue(Row,Col);
			var checkEqType = formObj.eq_knd_cd.Code;       
			var dispNo = formObj.disp_no.value;            
			var retArray = MnrGeneralCodeCheck(sheetObjects[0],"DSPEQN",checkEqn + "," + checkEqType + "," + dispNo);
			    
			if(retArray == null || retArray[0] == null){    	          
				ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");          				
				sheetObj.CellValue2(Row,Col) = "";	    
				sheetObj.CellValue2(Row,"eq_tpsz_cd") = "";    
				sheetObj.CellValue2(Row,"lstm_cd") = ""; 
				sheetObj.CellValue2(Row,"mvmt_cd") = "";  
				sheetObj.CellValue2(Row,"disp_yd_cd") = "";  
				sheetObj.CellValue2(Row,"mtrl_nm") = "";   
				sheetObj.CellValue2(Row,"mkr_nm") = "";  
				sheetObj.CellValue2(Row,"mdl_nm") = "";      
				sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";   
				sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "";   
				sheetObj.CellValue2(Row,"disp_trf_ut_prc") = "";   
				sheetObj.CellValue2(Row,"rpr_cost_amt") = "";   
				sheetObj.CellEditable(Row, "disp_yd_cd") = false; 
				sheetObj.SelectCell(Row,Col);     	   
			} else { 
				var tempText = retArray[0].split("|"); 
				if(tempText[1] != 'OK'){     
					ComShowCodeMessage("MNR00302",tempText[0]);  
					sheetObj.CellValue2(Row,Col) = ""; 	     
					sheetObj.CellValue2(Row,"eq_tpsz_cd") = "";    
					sheetObj.CellValue2(Row,"lstm_cd") = ""; 
					sheetObj.CellValue2(Row,"mvmt_cd") = "";  
					sheetObj.CellValue2(Row,"disp_yd_cd") = "";  
					sheetObj.CellValue2(Row,"mtrl_nm") = "";   
					sheetObj.CellValue2(Row,"mkr_nm") = "";    
					sheetObj.CellValue2(Row,"mdl_nm") = "";        
					sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";   
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "";     
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = "";      
					sheetObj.CellValue2(Row,"rpr_cost_amt") = ""; 
					sheetObj.CellEditable(Row, "disp_yd_cd") = false;      
					sheetObj.SelectCell(Row,Col);															     			
				} else {   
					sheetObj.CellEditable(Row, "disp_yd_cd") = true; 
					setEqInfo(sheetObj,formObj.eq_knd_cd.Code,sheetObj.CellValue(Row,Col),ComGetNowInfo("ymd"),Row,Col); 	  
					if(sheetObjects[3].CellEditable(Row, "mkr_nm")){   
						sheetObj.SelectCell(Row,"mkr_nm");     	
					} else {     
						sheetObj.SelectCell(Row,"disp_ut_prc");	 
					}  	
				}  
			}        	
			reSetQtyAndPrice();   
		} else if(sheetObj.ColSaveName(Col) == "del_chk"){
			MnrCheckRowColChange(sheetObj,sheetObj.CellValue(Row,"del_chk"),Row);	
		} else if(sheetObj.ColSaveName(Col) == "disp_ut_prc"){ 
			//EQ Number가 있으면 
			if(sheetObj.CellValue(Row,"eq_no") != ""){
				//NOT Damage
				if(sheetObj.CellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.CellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.CellValue(Row,"disp_trf_ut_prc") == ""){
						sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT"; 	
					} else {  
						var trfUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_trf_ut_prc")); 
						var dispUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_ut_prc"));
 
						//Disposal Tariff 보다 높거나 같으면 'Success'로 표현 바랍니다.	
						if(dispUtPrc >= trfUtPrc){ 
							sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS";				
						} else {  
							sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "UP";
						}   	
					} 
				//Damage	
				} else {
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "DA"; 			
				} 			
			}     
			reSetQtyAndPrice();   
		} else if(sheetObj.ColSaveName(Col) == "disp_rsn_cd"){  
			//EQ Number가 있으면 	
			if(sheetObj.CellValue(Row,"eq_no") != ""){
				//NOT Damage 
				if(sheetObj.CellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.CellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.CellValue(Row,"disp_trf_ut_prc") == ""){
						sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT"; 	
					} else {  
						var trfUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_trf_ut_prc")); 
						var dispUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_ut_prc"));
							 
						//Disposal Tariff 보다 높거나 같으면 'Success'로 표현 바랍니다.	
						if(dispUtPrc >= trfUtPrc){  
							sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS";				
						} else {    
							sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "UP";
						}	 			 	
					}	
					sheetObj.CellValue2(Row,"rpr_cost_amt") = "";		
					//1. Repair Cost를 'Sale Category'옆에 추가해주세요. 2. Manual 입력이며 Damage인 경우에 입력가능합니다.
					sheetObj.CellEditable(Row, "rpr_cost_amt") = false;
				//Damage	
				} else {
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "DA"; 			
					//1. Repair Cost를 'Sale Category'옆에 추가해주세요. 2. Manual 입력이며 Damage인 경우에 입력가능합니다.
					sheetObj.CellEditable(Row, "rpr_cost_amt") = true; 			
				}	
			}		
		} else if(sheetObj.ColSaveName(Col) == "disp_yd_cd"){  
			var checkYard = sheetObj.CellValue(Row,"disp_yd_cd"); 
			retArray = MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);      
			if(retArray == null){			        
				ComShowCodeMessage("MNR00165",checkYard,"YARD");       				
				sheetObj.CellValue2(Row,"disp_yd_cd") = "";	
				sheetObj.SelectCell(Row,"disp_yd_cd");	           
			} else {											    
				//unit price 가져오기			  
				var price = MnrGetDISPEQUnitPrice(sheetObjects[0],formObj.curr_cd.Code,sheetObj.CellValue(Row,"eq_tpsz_cd"),sheetObj.CellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
				if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){     		  
					sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";     
					//Not Found Tariff 		
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT";      
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = "0";    
				}  else {		 	 	  
					sheetObj.CellValue2(Row,"disp_ut_prc") = price;  	
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = price;   
											
					//NOT Damage 
					if(sheetObj.CellValue(Row,"disp_rsn_cd") == "C"){
						if(sheetObj.CellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.CellValue(Row,"disp_trf_ut_prc") == ""){
							sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT"; 	
						} else {  
							sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS";				
						}	 		
						sheetObj.CellValue2(Row,"rpr_cost_amt") = "";		
						//1. Repair Cost를 'Sale Category'옆에 추가해주세요. 2. Manual 입력이며 Damage인 경우에 입력가능합니다.
						sheetObj.CellEditable(Row, "rpr_cost_amt") = false;
					//Damage	
					} else {
						sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "DA"; 
						//1. Repair Cost를 'Sale Category'옆에 추가해주세요. 2. Manual 입력이며 Damage인 경우에 입력가능합니다.
						sheetObj.CellEditable(Row, "rpr_cost_amt") = true; 			
					}
				} 			   
				return; 	   
			} 
		}		 			 	
	}	
		
	function t2_sheet1_OnChange(sheetObj,Row, Col, Value) {
		var formObj = document.form; 
		if(sheetObj.ColSaveName(Col) == "del_chk"){
			MnrCheckRowColChange(sheetObj,sheetObj.CellValue(Row,"del_chk"),Row);	
		} else if(sheetObj.ColSaveName(Col) == "disp_yd_cd"){
			 
			var checkMdmLoc = sheetObj.CellValue(Row,Col); 
			retArray = MnrGeneralCodeCheck(sheetObjects[0],"MLOC",checkMdmLoc);      
			if(retArray == null){             
				ComShowCodeMessage("MNR00165",checkMdmLoc,"Location");       				
				sheetObj.CellValue2(Row ,Col) = ""; 
				sheetObj.SelectCell(Row ,Col);                  
			} else {	  	
				//unit price 가져오기 
				var price = MnrGetDISPEQUnitPrice(sheetObjects[0],formObj.curr_cd.Code,sheetObj.CellValue(Row,"eq_tpsz_cd"),sheetObj.CellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
				if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){     		  
					sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";     
					//Not Found Tariff  		
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT";       
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = "0";     
				}  else {  		 	 	  
					sheetObj.CellValue2(Row,"disp_ut_prc") = price;  	
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS"; 
					sheetObj.CellValue2(Row,"disp_trf_ut_prc") = price;   
				}
				reSetQtyAndPrice();        			  	
				return;	    
			}     			
		} else if(sheetObj.ColSaveName(Col) == "disp_ut_prc"){ 
			if(sheetObj.CellValue(Row,"disp_trf_ut_prc") == "0" || sheetObj.CellValue(Row,"disp_trf_ut_prc") == ""){
				sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT";  	
			} else {  
				var trfUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_trf_ut_prc")); 
				var dispUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_ut_prc"));
					   	 		     		 
				//Disposal Tariff 보다 높거나 같으면 'Success'로 표현 바랍니다.	
				if(dispUtPrc >= trfUtPrc){ 	 
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS";				
				} else {   
					sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "UP";
				} 	   	
			}  
			reSetQtyAndPrice();       
		} else if(sheetObj.ColSaveName(Col) == "disp_qty"){ 
			reSetQtyAndPrice();   
		} else if(sheetObj.ColSaveName(Col) == "eq_tpsz_cd"){ 
			//unit price 가져오기 
			var price = MnrGetDISPEQUnitPrice(sheetObjects[0],formObj.curr_cd.Code,sheetObj.CellValue(Row,"eq_tpsz_cd"),sheetObj.CellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
			if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){     		  
				sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";     
				//Not Found Tariff 		
				sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT";       
				sheetObj.CellValue2(Row,"disp_trf_ut_prc") = "0";     
			}  else {		 	 	  
				sheetObj.CellValue2(Row,"disp_ut_prc") = price;  	
				sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS"; 
				sheetObj.CellValue2(Row,"disp_trf_ut_prc") = price;   
			}           		
			reSetQtyAndPrice(); 	 	  
		}		 		  	
	}
	 
	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t2_sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName = sheetObj.ColSaveName(Col);
		switch (sName) {    
			case "disp_yd_cd":  
				ComOpenPopup('/hanjin/COM_ENS_051.do', 700, 460, 'setPopData_Loc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 4);
				break; 
	 	}   
	}	
	
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet4_OnPopupClick(sheetObj,Row,Col){
	    var upObj = uploadObjects[0];         
		var prefix = "";			
	 	var fileName = sheetObj.OpenFileDialog("파일선택");
			
		var badFile = false;
		if(fileName.indexOf("\\") == -1) {  
			badFile = true;		
		} else {
			var relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1); 
			var fileType = 	relativePath.substr(relativePath.lastIndexOf(".") + 1);
			fileType = fileType.toUpperCase();
			//GIF, BMP, TIFF, JPG ,XLS ,DOC, XLSX 	    
			if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG" && fileType != "XLS" && fileType != "DOC" && fileType != "XLSX"){
				badFile = true;	   	
			}		 
		}
			  
	 	if(!badFile) {  
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
	 		sParam+= "&mnr_grp_tp_cd=DSP";       // MNR Work Group Type Code				
	 		sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
	 		sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
						
			upObj.ExtendParam = sParam;
			 
			var sXml = upObj.DoUpload(true); 
				     		
			uploadFileSeq = ComGetEtcData(sXml,"seqValue"); 
							
			if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
				var fileXml = SearchFileUpload(sheetObjects[5],uploadFileSeq);
				sheetObjects[5].LoadSearchXml(fileXml);   				
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
	function sheet4_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
   		   
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
			
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  
		 
	function reSetQtyAndPrice(){
		//QTY Price 다시 구함  
		var formObj = document.form;      	
		var sheetQtySum = 0;
		var sheet3PriceSum = 0; 
		var sheet4PriceSum = 0;   
		for(var x = 1 ; x <= sheetObjects[3].RowCount;x++){ 
			if(sheetObjects[3].CellValue(x,"eq_no") != ""){
				sheetQtySum++;     
				sheet3PriceSum += parseFloat(sheetObjects[3].CellValue(x,"disp_ut_prc"));
			}    	 		
		}     
		 	    
		for(var x = 1 ; x <= sheetObjects[4].RowCount;x++){ 			
			sheetQtySum += parseInt(sheetObjects[4].CellValue(x,"disp_qty"),10);
			var price = parseFloat(sheetObjects[4].CellValue(x,"disp_ut_prc"));
			var qty = parseFloat(sheetObjects[4].CellValue(x,"disp_qty"));   
			var sum = price * qty; 		
			sheet4PriceSum += sum;    
		}   
		 
		formObj.disp_st_prc.value = ComAddComma2((sheet3PriceSum + sheet4PriceSum), "#,###");       
		formObj.disp_qty.value = ComAddComma2(sheetQtySum, "#,###");      	
	}
		 
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate,Row,Col){
		var formObj = document.form;
		var sCostType = "";
		if(sEqType == "U"){ 
			sCostType = "MRDRRC"; 	
		} else if(sEqType == "G"){
			sCostType = "MRGSRC";		
		} else { 
			sCostType = "MRZSRC";    
		}	   	 	 
		var sXml = MnrComEqGenInfoSearch(sheetObjects[0],sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml);   
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt|33 total_loss_date|34 rpr_cost_amt  
		if(retArr != null){  
			//TpSz			 
			sheetObj.CellValue2(Row,"eq_tpsz_cd") = retArr[0][31];  
			//Term 	   
			sheetObj.CellValue2(Row,"lstm_cd") = retArr[0][19];  
			//mvmt_cd 
			sheetObj.CellValue2(Row,"mvmt_cd") = retArr[0][13];  
			//current Yard      
			sheetObj.CellValue2(Row,"disp_yd_cd") = retArr[0][18];  
			//Material  
			sheetObj.CellValue2(Row,"mtrl_nm") = retArr[0][29];  
			//Maker Name  
			sheetObj.CellValue2(Row,"mkr_nm") = retArr[0][8];  
			//Unit Model   
			sheetObj.CellValue2(Row,"mdl_nm") = retArr[0][1]; 
			//RPR_COST_AMT			
			sheetObj.CellValue2(Row,"rpr_cost_amt") = "";	//retArr[0][34];
			 											
			sheetObjects[3].CellValue2(Row,"rpr_cost_amt") = "";
																								
			var checkRsnCd = MnrNullToBlank(sheetObjects[3].CellValue(Row,"disp_rsn_cd"));  
			
			if(checkRsnCd == 'C'){																
				sheetObjects[3].CellEditable(Row, "rpr_cost_amt") = false; 
			} else {				
				sheetObjects[3].CellEditable(Row, "rpr_cost_amt") = true;
			}							               
		} else { 	  
			ComShowCodeMessage("MNR00318"); 	   
			sheetObj.CellValue2(Row,"eq_no") = "";
			sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; 	  
			sheetObj.CellValue2(Row,"lstm_cd") = ""; 		
			sheetObj.CellValue2(Row,"mvmt_cd") = "";  	
			sheetObj.CellValue2(Row,"disp_yd_cd") = ""; 
			sheetObj.CellValue2(Row,"mtrl_nm") = ""; 
			sheetObj.CellValue2(Row,"mkr_nm") = ""; 
			sheetObj.CellValue2(Row,"mdl_nm") = "";
			sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "";   
			sheetObj.CellValue2(Row,"disp_trf_ut_prc") = ""; 
			sheetObj.CellValue2(Row,"rpr_cost_amt") = ""; 
			return;   
		}	
			  
		//unit price 가져오기           
		var price = MnrGetDISPEQUnitPrice(sheetObjects[0],formObj.curr_cd.Code,sheetObj.CellValue(Row,"eq_tpsz_cd"),sheetObj.CellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
		if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){       
			sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";  
			//Not Found Tariff    
			sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "NT";   
			sheetObj.CellValue2(Row,"disp_trf_ut_prc") = "0";    
		}  else {        
			sheetObj.CellValue2(Row,"disp_ut_prc") = price; 
			sheetObj.CellValue2(Row,"disp_vrfy_tp_cd") = "SS"; 
			sheetObj.CellValue2(Row,"disp_trf_ut_prc") = price;   
		}	  
	} 
	       	
	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */ 
	function setPopData_Loc(aryPopupData, Row, Col, sheetIdx) {
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);
				switch(sName) {
					case "disp_yd_cd":   
						CellValue2(Row,Col) = aryPopupData[0][10];
					break;
				}
			}
		}
	}
			
	/**
	 * EES_MNR_158 팝업 결과 받는함수 <br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */ 
	function setPopData_DSPC(aryPopupData, Row, Col, sheetIdx) {
		var formObj = document.form;   
		var tempRowCnt = 0; 
		var firstInsRow = 0;
		if ( aryPopupData.length > 0 ) {		
			with(sheetObjects[3]) {  
				for(var i = 0; i < aryPopupData.length; i++){
					if(FindText("eq_no",aryPopupData[i][4]) == -1){
						var Row = DataInsert(-1); 
						if(tempRowCnt == 0){
							firstInsRow = Row;    
						}
						CellValue2(Row,"disp_ut_tp_cd") = "E";  			
						CellValue2(Row,"disp_qty") = "1"; 				 	
						CellValue2(Row,"eq_no") = aryPopupData[i][4];            	 
						CellValue2(Row,"eq_tpsz_cd") = aryPopupData[i][5];            	 
						CellValue2(Row,"lstm_cd") = aryPopupData[i][6];           	 
						CellValue2(Row,"mvmt_cd") = aryPopupData[i][7];            	 
						CellValue2(Row,"disp_yd_cd") = aryPopupData[i][8];	 
						CellValue2(Row,"mtrl_nm") = aryPopupData[i][12];	 
						CellValue2(Row,"mkr_nm") = aryPopupData[i][13];	 
						CellValue2(Row,"mdl_nm") = aryPopupData[i][14];  
						CellValue2(Row,"rpr_cost_amt") = ""; //aryPopupData[i][20]; 
																
						//unit price 가져오기		  
						var price = MnrGetDISPEQUnitPrice(sheetObjects[0],formObj.curr_cd.Code,aryPopupData[i][5],aryPopupData[i][8],formObj.rqst_dt.value);
						if(MnrNullToBlank(price) == "0" || MnrNullToBlank(price) == ""){     		  
							CellValue2(Row,"disp_ut_prc") = "0.00";     
							//Not Found Tariff 		
							CellValue2(Row,"disp_vrfy_tp_cd") = "NT";      
							CellValue2(Row,"disp_trf_ut_prc") = "0";    
						}  else {		 	 	  
							CellValue2(Row,"disp_ut_prc") = price;  	
							CellValue2(Row,"disp_vrfy_tp_cd") = "SS";
							CellValue2(Row,"disp_trf_ut_prc") = price;  
						}		
							 
						tempRowCnt++; 
					}    			 	
				} 
			}	
		}	
	}	
			
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){
		var totDTLRowCnt = sheetObjects[3].RowCount + sheetObjects[4].RowCount;
		 
		if(!isNowInit && totDTLRowCnt > 0){  
			if (!ComShowCodeConfirm("MNR00249")){
				comboObj.Code2 = preEqKndCd;           
				return;
			}   	 	
			sheetObjects[3].RemoveAll();	
			sheetObjects[4].RemoveAll();
		}	
			     				 
		var tpSzComboStr = ""; 
		if(comboObj.Code == "U"){ 
			tpSzComboStr = ComGetAryJoin(uTpSz,"|");
		} else if(comboObj.Code == "G"){ 
			tpSzComboStr = ComGetAryJoin(gTpSz,"|");
		} else {
			tpSzComboStr = ComGetAryJoin(zTpSz,"|");
		}
		sheetObjects[3].InitDataCombo (0, "eq_tpsz_cd", tpSzComboStr, tpSzComboStr ,"");		
		sheetObjects[4].InitDataCombo (0, "eq_tpsz_cd", tpSzComboStr, tpSzComboStr ,"");		
		preEqKndCd = comboObj.Code;   
	} 
		 
	function curr_cd_OnChange(comboObj,Index_Code, Text){ 
		var totDTLRowCnt = sheetObjects[3].RowCount + sheetObjects[4].RowCount;
		
		if(!isNowInit && totDTLRowCnt > 0){ 	  		
			if (!ComShowCodeConfirm("MNR00249")){
				comboObj.Code2 = preCurrCd;           
				return;	 
			}  	 	
			sheetObjects[3].RemoveAll(); 	
			sheetObjects[4].RemoveAll(); 
		}   
		preCurrCd = comboObj.Code;    
	} 
		
	function disp_tp_cd_OnChange(comboObj,Index_Code, Text){ 
		//**** 초기화 경고 메세지후 값을 바꾼다. START	
		var totDTLRowCnt = sheetObjects[3].RowCount + sheetObjects[4].RowCount;
	
		if(!isNowInit && totDTLRowCnt > 0){  
			if (!ComShowCodeConfirm("MNR00249")){    
				comboObj.Code2 = preDispTpCd;             
				return; 	  
			} 	 	 	
			sheetObjects[3].RemoveAll();   	
			sheetObjects[4].RemoveAll();
		}
		preDispTpCd = comboObj.Code;   	  
		//**** 초기화 경고 메세지후 값을 바꾼다. END
		
		var formObj  = document.form;  
						   	 			 	
		//bidding 
		if(comboObj.Code == "B"){	 
			MnrFormSetReadOnly(formObj,false,"disp_st_dt|disp_end_dt|disp_bultn_dt|disp_pkup_st_dt|disp_pkup_end_dt");
			ComSetObjValue(formObj.disp_bultn_dt,toDay); 
			ComSetObjValue(formObj.disp_st_dt,toDay);
			ComSetObjValue(formObj.disp_end_dt,ComGetDateAdd(ComGetNowInfo("ymd"), "D", 3));	
			ComSetObjValue(formObj.disp_pkup_st_dt,ComGetDateAdd(ComGetNowInfo("ymd"), "D", 4));   
			ComSetObjValue(formObj.disp_pkup_end_dt,ComGetDateAdd(ComGetNowInfo("ymd"), "D", 11));   
		} else {		  	
			// Contract
			MnrFormSetReadOnly(formObj,true,"disp_st_dt|disp_end_dt|disp_bultn_dt");
			ComSetObjValue(formObj.disp_bultn_dt,"");
			ComSetObjValue(formObj.disp_st_dt,"");		
			ComSetObjValue(formObj.disp_end_dt,""); 	
			ComSetObjValue(formObj.disp_pkup_st_dt,ComGetDateAdd(toDay, "D", 1)); // Pick Up Period
			ComSetObjValue(formObj.disp_pkup_end_dt,ComGetDateAdd(toDay, "D", 8));					
		}
		//Buyer Selection 은 무조건 초기화 
		initBuyerSelection(); 
	}  
	
	
	 /**
     * Buyer Selection을 무조건 초기화 
     * 선택한 탭의 요소가 활성화 된다. 
     */
	function initBuyerSelection(){ 
		//Buyer Selection 은 무조건 초기화  
		var checkVal = "";
		if(form.disp_tp_cd.Code == "B"){
			checkVal = "1";
		} else {
			checkVal = "0";   
		}
		for(var x = 1 ; x <= sheetObjects[2].RowCount;x++){  
			sheetObjects[2].CellValue2(x,"del_chk") = checkVal;   
			MnrCheckRowColChange(sheetObjects[2],sheetObjects[2].CellValue(x,"del_chk"),x); 				
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
     * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {없음} 
     **/
	function file_Insert(sheetObj){ 
		//**** 주의 헤더 겟수에 따라 수정하라  CellValue(1,"file_seq");  
		uploadFileSeq = sheetObj.CellValue(1,"file_seq");
								 
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
     	 		
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
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
	    		case "disp_eml_flg_temp":     
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
				ComKeyOnlyAlphabet('uppernum');            
	            break; 
	    }         
	}
	
    function setBuyerList(mnr_prnr_id, vndr_lgl_eng_nm, mnr_prnr_knd_cd, mnr_prnr_cnt_cd, mnr_prnr_seq){
    	var rowIndex = sheetObjects[2].DataInsert(-1);
    	sheetObjects[2].CellValue(rowIndex, "mnr_prnr_id")		= mnr_prnr_id;
    	sheetObjects[2].CellValue(rowIndex, "vndr_lgl_eng_nm") 	= vndr_lgl_eng_nm;
    	sheetObjects[2].CellValue(rowIndex, "mnr_prnr_knd_cd") 	= mnr_prnr_knd_cd;
    	sheetObjects[2].CellValue(rowIndex, "mnr_prnr_cnt_cd") 	= mnr_prnr_cnt_cd;
    	sheetObjects[2].CellValue(rowIndex, "mnr_prnr_seq") 	= mnr_prnr_seq;
    	sheetObjects[2].CellValue(rowIndex, "del_chk") 			= 1;
    	
    }
	

    
/* 개발자 작업  끝 */