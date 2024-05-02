/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EES_MNR_0263.js
 *@FileTitle : Write off Approval
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.12.10	 
 *@LastModifier : 조경완 	
 *@LastVersion : 1.0     
 * 2012.12.10 조경완   
 * 1.0 Creation    
 * ------------------------------------------------------------
 * 2013.08.07 조경완 [CHM-201326069-01] [MNR-자체개선] Write off Request 기능 보완
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
 * @class EES_MNR_0263 : EES_MNR_0263 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0263() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq = "";
	//History Seq 저장변수
	var historyMnrStsRefNo = ""; 
	var sSaveRtnXml = "";
	var nowLoad = 0;
	//메세지 표시용   
	var actionType = "";
	//현재구동여부
	var nowLoad=0;
	var idCnt = 0;
	var aproRmk = "";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	var searchFlg = "";
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];
		var sheetObject9 = sheetObjects[8];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn_period" :  
						var cal = new ComCalendarFromTo();  	       
						cal.select(formObject.in_st_dt,  formObject.in_end_dt,  'yyyy-MM-dd'); 
						break;
					case "btn_ttl_lss_dt" :  
						if(sheetObject3.RowCount >0)
						{
							var cal = new ComCalendar();  	       
							cal.select(formObject.ttl_lss_dt, 'yyyy-MM-dd'); 
						}
						break;
 					case "btn_iss_dt" :  
						if(sheetObject3.RowCount >0)
						{
							var cal = new ComCalendar();  	       
							cal.select(formObject.ttl_lss_iss_dt, 'yyyy-MM-dd'); 
						}
						break;
					case "btn_Retrieve":      	
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;	
							
					case "btn_New":    
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;     
						
					case "btn_Reject":        
						doActionIBSheet(sheetObject1,formObject,IBSAVE,2); 
						break; 

					case "btn_Confirm":    
						doActionIBSheet(sheetObject1,formObject,IBSAVE,1);
						break;

	                //멀티입력  
					case "btn_ttl_lss_no_multi":  
						rep_Multiful_inquiry("in_ttl_lss_no");  
						break;   
				
					/** (Tab) D.V Expense (S) **/
					case "btn_t1EQAdd":
						ComOpenPopup('/hanjin/EES_MNR_0097.do', 800, 460, 'setEES_MNR_0097', '1,0', true);
						break;
						
					case "btn_t1RowAdd": 
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
						break;

					case "btn_t1RowDel":
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
						break;
					/** (Tab) D.V Expense (E) **/

					/** (Tab) 3rd Party (S) **/
					case "btn_t2RowAdd":
						doActionIBSheet(sheetObject4,formObject,IBINSERT);
						break;

					case "btn_t2RowDel":
						doActionIBSheet(sheetObject4,formObject,IBDELETE);
						break;
					/** (Tab) 3rd Party (E) **/

					/** (Tab) Disposal (S) **/
					case "btn_t3RowAdd":
						doActionIBSheet(sheetObject5,formObject,IBINSERT);
						break;

					case "btn_t3RowDel":
						doActionIBSheet(sheetObject5,formObject,IBDELETE);
						break;
					/** (Tab) Disposal (E) **/

					/** (Tab) Scrapping (S) **/
					case "btn_t4RowAdd":
						doActionIBSheet(sheetObject6,formObject,IBINSERT);
						break;

					case "btn_t4RowDel":
						doActionIBSheet(sheetObject6,formObject,IBDELETE);
						break;
					/** (Tab) Scrapping (E) **/

					/** (Tab) Insurance (S) **/
					case "btn_t5RowAdd":
						doActionIBSheet(sheetObject7,formObject,IBINSERT);
						break;

					case "btn_t5RowDel":
						doActionIBSheet(sheetObject7,formObject,IBDELETE);             
						break;
					/** (Tab) Insurance (E) **/
					
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
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
    	//버튼 설정
    	MnrWaitControl(true);
    	nowLoad=1;
    	
		//Axon이벤트 초기화
		initControl();

		//IBMultiCombo 초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
    	
    	// IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i );
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBTab 초기화
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }
        
		//파일업로드 초기화
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 
		
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
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
			case 2:
	    	case 3: 
	    	case 4: 
	            with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
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
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 130; 
                    //전체 너비 설정 
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly; 

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true; 

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);
						
					var HeadTitle1 = "|Seq.|TLL No.|Write Off No.|REQ OFC|REQ DT|Status|Main Reason|Sub Reason|TLL DT|APP OFC|Recovery & Loss|Recovery & Loss|Recovery & Loss|Recovery & Loss||||||||";
					var HeadTitle2 = "|Seq.|TLL No.|Write Off No.|REQ OFC|REQ DT|Status|Main Reason|Sub Reason|TLL DT|APP OFC|EQ\nQ'ty|DV\nAMT|Collected\nAMT|AMT of TTL||||||||"; 
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
                    InitHeadRow(1, HeadTitle2, true);  
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++,  dtHiddenStatus,		 	0,      daCenter,  	false,  	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,       			30,    	daCenter,  	true,  		"Seq",     					false,  "",    	dfNone     );    
					InitDataProperty(0, cnt++ , dtData,					108,	daCenter,	true,		"ttl_lss_no",				false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	true,		"wrtf_no",					false,	"",		dfNone,			0,	false,	false);           
                    InitDataProperty(0, cnt++ , dtData,					52,		daCenter,	true,		"rqst_ofc_cd",				false,	"",		dfNone,			0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					64,		daCenter,	true,		"wrtf_rqst_dt",					false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		"ttl_lss_sts_cd",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"ttl_lss_rsn_nm",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"ttl_lss_dtl_rsn_nm",		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					64,		daCenter,	true,		"ttl_lss_dt",				false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,					52,		daCenter,	true,		"apro_ofc_cd",				false,	"",		dfNone,			0,	false,	false);
                    
					//반복부 
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"dv_eq_qty",				false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"dv_dv_val",				false,	"",		dfNullFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"wrtf_clt_amt",				false,	"",		dfNullFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,	true,		"amt_loss",					false,	"",		dfNullFloat,		2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"mnr_sts_ref_no",    				false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"ttl_lss_dtl_rsn_cd",    			false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"ttl_lss_rmk",    					false,      "",     	dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"file_seq",    						false,      "",     	dfNone,    		0,      true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"ttl_lss_cfm_dt",					false,		"",			dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"ttl_lss_cfm_id",					false,		"",			dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		"ttl_lss_rsn_cd",					false,		"",			dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		"rqst_dt",					false,		"",			dfNone,			0,		false,		false);
                    
					CountPosition = 0;

				}
                break;
					
			case "h1sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 200;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
		
					var HeadTitle1 = "|Sel|EQ Type|EQ No|TP/SZ|Term|Lessor|Yard|Invoice No|CURR|D/V\nAMT|Collected\nAMT|AMT of Loss|By Requester|||";
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
		
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	true,  	"Seq",     				false,  "", dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"eq_knd_cd",			false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,	"rqst_eq_no",			false,	"",	dfNone,			0,	false,	true,	14);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",				false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"lessor_nm",			false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"ttl_lss_yd_cd",		false,	"",	dfNone,			0,	false,	true,	7);
	                InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	"inv_no",				false,	"",	dfNone,			0,	false,	true,	20);
	                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"curr_cd",				false,	"",	dfNone,			0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"dpc_val_amt",			false,	"",	dfNullFloat,	2,	false,	true,	13);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"wrtf_clt_amt",			false,	"",	dfNullFloat,	2,	true,	true,	13);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"amt_loss",				false,	"",	dfNullFloat,	2,	false,	true,   13);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"upd_usr_id",			false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,  	false,  "ttl_lss_no");
					InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,  	false,  "ttl_lss_seq");
					InitDataProperty(0, cnt++ , dtHidden,	 	0,		daLeft,		true,  	"wrtf_no");
					
					CountPosition = 2; 
				}
				break;
	
			case "t1sheet1":
				with (sheetObj) {
					var prefix = "";
					// 높이 설정
					style.height = 162;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 13, 100);
		
					var HeadTitle1 = "|Sub Reason|Sub Reason|Sub Reason||||";
					var HeadTitle2 = "|Sel|File|DownLoad||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true); 
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	100,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
	                
					CountPosition = 0;
					
					ImageList(0)= "/hanjin/img/ico_attach.gif";
					
					ShowButtonImage = 1;    
				}
				break;
		
			case "t1sheet2": // 3rd Party
				with (sheetObj) {
					// 높이 설정
					style.height = 162;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 13, 100);

					var HeadTitle1 = "|Office|PIC|Status|Date|Remarks|||||";
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false)
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
		
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	"ofc_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"usr_nm",			false,	"",	dfNone,			0,	false,	false,	14);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"apro_sts_nm",		false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"apro_dt",			false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"apro_rmk",			false,	"",	dfNone,			0,	true,	true);
	                InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	"row_seq",   		false,  "", dfNone, 		0,  true,   true);
	                InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	"apro_usr_id",   	false,  "", dfNone, 		0,  true,   true);
	                InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	"apsts_cd",			false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	"apro_step_seq",	false,	"",	dfNone,			0,	false,	false);
	                InitDataProperty(0, cnt++ , dtHidden,		55,		daCenter,	true,	"wrtf_no",			false,	"",	dfNone,			0,	false,	false);
	                
	                CountPosition = 0;
				}
				break;
		
			case "t2sheet1": // Disposal
				with (sheetObj) {
					// 높이 설정
					style.height = 142;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 6, 100);
		
					var HeadTitle1 = "|Date|Remark(s)|Creation Office|Creation User";
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount + 3, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false)
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
		
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	"mnr_sts_dt",	false,	"",	dfDateYmd,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		true,	"mnr_sts_rmk",	false,	"",	dfNone,		0,	true,	true,	4000);
					InitDataProperty(0, cnt++ , dtData,     	100,	daCenter,	true,	"rqst_ofc_cd",	false,	"",	dfNone,  	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	    daCenter,	true,	"cre_usr_id",	false,	"",	dfNone,		0,	false,	false);
		
					//Hidden
					InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_ref_no");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_sts_dtl_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"mnr_grp_tp_cd");
		
					PopupImage = "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 2;
					CountPosition = 0;
				}
				break;
		
			case "t2sheet2":
				with (sheetObj) {
					var prefix = "";   
		
					// 높이 설정
					style.height = 142; 
					// 전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					SheetWidth = 280;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;	
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 13, 100);
		
					var HeadTitle1 = "|Evidence Attachment|Evidence Attachment|Evidence Attachment";
					var HeadTitle2 = "|Sel|File|Download";
		
					var headCount = ComCountHeadTitle(HeadTitle1);									
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true); 
					InitHeadRow(1, HeadTitle2, true);
		
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	prefix + "del_chk")
					InitDataProperty(0, cnt++ , dtPopup,      	120,	daCenter,  	false,  prefix + "org_file_nm",     true,   "",	dfNone,	0,	false,	true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix + "file_dw",   		false,  "", dfNone, 0,  false,	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,  prefix + "file_path_nm",	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix + "file_path",   	false,  "", dfNone, 0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix + "file_seq",   		false,  "", dfNone, 0,  true,   true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix + "file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
		
					CountPosition = 0;
		
					ImageList(0)= "/hanjin/img/ico_attach.gif";
		
					ShowButtonImage = 1;    
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
                    InsertTab( cnt++ , "About Write Off", -1 );
					InsertTab( cnt++ , "TTL History", -1 );
                }
                break;
         }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    }

	/**
	 * IBUpload Object 기본설정
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
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	*/
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
	}
	 
	function setPopUpParam_Sheet2_COM_ENS_071(array) {
		
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
	    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=arr[3];
		if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != ""){
			formObj.respb_ofc_cd.value=arr[3];	
			formObj.respb_ofc_nm.value=arr[4];

		}
		
	}  

	function setPopUpParam_COM_ENS_071(array) {
		
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
	
		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];
	    var Row = sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].CellValue2(Row,"respb_ofc_cd")=formObj.respb_ofc_cd.value;
		
	}   
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;	
	        	
			case "engup":
	         	if(obj.name == "in_ttl_lss_no"){ 
					ComKeyOnlyAlphabet('uppernum','45|44'); 
				} else {				   
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break; 
	    } 
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change()
	{	     
		ComChkObjValid(event.srcElement);
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{      
			case "respb_ofc_cd":   
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;  
			}       
		} 
	} 
    /**
     * 초기화 이벤트 OnLoad 가 끝나면 초기화 이벤트 실행
     * 
     * @param {Sheet}sheetObj 프로세스 처리될 시트오브젝트
     */
    function t1sheet1_OnLoadFinish(sheetObj) {
//    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }   
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");
        
        if(nItem == beforetab){
        	objs[nItem].style.display = "Inline";
        }else{
	    	objs[nItem].style.display = "Inline";
	    	objs[beforetab].style.display = "none";
        }
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;   
    	var fileSeq = document.form.file_seq.value;
		var subFileSeq = document.form.sub_file_seq.value;
		var mnrStsRefNo = document.form.mnr_sts_ref_no.value;
		var wrtfNo = document.form.wrtf_no.value;
		
		if(beforetab == 0){
			//파일 리스트 조회
			if(subFileSeq != "" && subFileSeq != null){
				var subFileXml = SearchFileUpload(sheetObjects[2],subFileSeq);
				if(!MnrIsEmptyXml(subFileXml)){
					sheetObjects[2].LoadSearchXml(subFileXml);
				}
			}
			
			//Approval Step 리스트 조회
			if(sheetObjects[3].RowCount == 0 && searchFlg == "Y"){
				if(wrtfNo != "" && wrtfNo != null){
					var sXml = MnrApprovalStepSearch(sheetObjects[3], currOfcCd, wrtfNo);
					sheetObjects[3].LoadSearchXml(sXml);
				}
			}
		
		}else if(beforetab == 1){
			//파일 리스트 조회
			if(fileSeq != "" && fileSeq != null){
	
				var fileXml = SearchFileUpload(sheetObjects[5],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[5].LoadSearchXml(fileXml);
				}
			}
			
			//History 리스트 조회
			if(mnrStsRefNo != "" && mnrStsRefNo != null){
				historyMnrStsRefNo = mnrStsRefNo;
				var sXml = MnrStatusHistorySearch(sheetObjects[4], mnrStsRefNo);
				sheetObjects[4].LoadSearchXml(sXml);
			}
		}
    }

     /**
 	 * Loss Total : DV의 Pay Amount의 합계
 	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
 	 *                        + Scrapping Cost AMT + Request AMT
 	 * Balance Total = Recovery Plan Total - Loss Tota
 	 */
 	function setCalculateTotalSum(){
 	    var calFlag=false;

 		if(sheetObjects[1].RowCount > 0)
 		{
 			calFlag=true;
 		}

 		
 		if(calFlag==true){
 		    var dvAmtTotal=0;
 		    var recoveryAmtTotal=0;
 		        								
             if(sheetObjects[1].RowCount >0)	{			
 				for(var j=sheetObjects[1].HeaderRows ;j<=sheetObjects[1].LastRow;j++){		
 					if(sheetObjects[1].CellValue(j,"ibflag")!="D" ){
 						if(sheetObjects[1].CellValue(j,"dpc_val_amt")!="") {		
 							dvAmtTotal = getFloatSumData(dvAmtTotal,sheetObjects[1].CellValue(j,"dpc_val_amt"));
 						}
 						if(sheetObjects[1].CellValue(j,"wrtf_clt_amt")!=""){
 							recoveryAmtTotal = getFloatSumData(recoveryAmtTotal,sheetObjects[1].CellValue(j,"wrtf_clt_amt"));
 						} 
 					}
 			    }
             }
          					 	  			      
             var tempStr = ComAddComma2((dvAmtTotal + ""), "#,###"); 
 			eval("document.form.dvAmtTtl.value = tempStr;");
 					
 			tempStr = ComAddComma2((recoveryAmtTotal + ""), "#,###");		 
 			eval("document.form.recveryAmtTtl.value = tempStr;");
 			
 			tempStr = ComAddComma2((getFloatSubstractData(dvAmtTotal,recoveryAmtTotal) + ""), "#,###");   	
 			eval("document.form.lossAmtTtl.value = tempStr;"); 	
 		}	
 	}
 	
 	/**
	 * parseFloat 버그로 함수로 뺌 <br>	
	 * @param a  더할값 		
	 * @param b  더할값		
	 * @return sumResult  결과값 			
	 */	 		
	function getFloatSumData(a,b){				
		var aFloat = parseFloat(a + "");										
		var bFloat = parseFloat(b + ""); 						  	
		var sumResult = parseFloat(aFloat + bFloat).toFixed(2);		   	 	   								   	  		     		
		return  parseFloat(sumResult + "");			
	}
	 
	/**
	 * parseFloat 버그로 함수로 뺌 <br>	
	 * @param a  뺄값 		
	 * @param b  뺄값		
	 * @return sumResult  결과값 			
	 */	 		
	function getFloatSubstractData(a,b){				
		var aFloat = parseFloat(a + "");										
		var bFloat = parseFloat(b + ""); 						  	
		var subResult = parseFloat(aFloat - bFloat).toFixed(2);		   	 	   								   	  		     		
		return  parseFloat(subResult + "");			
	}
	 
	/** 
	 * 조회후 Header 값 설정 및 형식 변경 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	Row		    Row
	 * @param   {String}    Col 		Col
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col){
		document.form.wrtf_no.value = sheetObj.CellValue(Row, "wrtf_no");
		document.form.mnr_sts_ref_no.value = sheetObj.CellValue(Row, "mnr_sts_ref_no");
		doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH);
	}
	 
	 /** 
	  * 조회후 Header 값 설정 및 형식 변경 
	  * @param	{IBSheet}	sheetObj	시트오브젝트
	  * @param	{String}	Row		    Row
	  * @param   {String}    Col 		Col
	  */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			sheetObjects[0].SelectCell(2,1);
			sheet1_OnDblClick(sheetObjects[0],2,1);
		}
	}
	 
	/** 
	 * Detail 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function h1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setCalculateTotalSum();
			
		var fileSeq = document.form.file_seq.value;
		var subFileSeq = document.form.sub_file_seq.value;
		var mnrStsRefNo = document.form.mnr_sts_ref_no.value;
		var wrtfNo = document.form.wrtf_no.value;
			
		if(beforetab == 0){
			searchFlg = "Y";
			
			//파일 리스트 조회
			if(subFileSeq != "" && subFileSeq != null){
				var subFileXml = SearchFileUpload(sheetObjects[2],subFileSeq);
				if(!MnrIsEmptyXml(subFileXml)){
					sheetObjects[2].LoadSearchXml(subFileXml);
				}
			}
			
			//Approval Step 리스트 조회
			var sXml = MnrApprovalStepSearch(sheetObjects[3], currOfcCd, wrtfNo);
			if(ComGetTotalRows(sXml)>0){
				sheetObjects[3].LoadSearchXml(sXml);
			}
			
		}else if(beforetab == 1){
			//파일 리스트 조회
			if(fileSeq != "" && fileSeq != null){
		
				var fileXml = SearchFileUpload(sheetObjects[5],fileSeq);
				if(!MnrIsEmptyXml(fileXml)){
					sheetObjects[5].LoadSearchXml(fileXml);
				}
			}

			//History 리스트 조회
			if(mnrStsRefNo != "" && mnrStsRefNo != null){
				historyMnrStsRefNo = mnrStsRefNo;
				var sXml = MnrStatusHistorySearch(sheetObjects[4], mnrStsRefNo);
				sheetObjects[4].LoadSearchXml(sXml);
			}
		}
		
		
			
	}
	 
	 /**
	  * 파일 선택하기 <br>
	  * @param {ibsheet} sheetObj    IBSheet Object
	  * @param {ibsheet} Row     	sheetObj의 선택된 Row
	  * @param {ibsheet} Col     	sheetObj의 선택된 Col
	  **/
	function t1sheet1_OnPopupClick(sheetObj,Row,Col){
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
			//GIF, BMP, TIFF, JPG 
			//if(fileType != "GIF" && fileType != "BMP" && fileType != "TIFF" && fileType != "TIF" && fileType != "JPG"){
			badFile = false; 	
			//} 
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
			sParam+= "&mnr_grp_tp_cd=WTF";       // MNR Work Group Type Code				
			sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
			sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
			sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
		
			upObj.ExtendParam = sParam;
		
			var sXml = upObj.DoUpload(true);
		
			uploadFileSeq = ComGetEtcData(sXml,"seqValue");
		
			if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
				var fileXml = SearchFileUpload(sheetObjects[4],uploadFileSeq);
				sheetObjects[4].LoadSearchXml(fileXml);   				
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
	function t1sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
		
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}
	
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/  
	function t2sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
		
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}
	 
	 /**
	  * 조회후 Header 값 설정 및 형식 변경 
	  * @param	{IBSheet}	sheetObj	시트오브젝트
	  * @param	{String}	ErrMsg		에러메세지
	  */
	function t1sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			for(var i = 1;i<sheetObj.RowCount+1; i++){
				if(sheetObj.CellValue(i, "apsts_cd") == "W"){
					idCnt = i;
					break;
				}
			}
			
			if(sheetObj.CellValue(idCnt, "apro_usr_id") == usrId){
				sheetObj.CellBackColor(idCnt,"apro_rmk") = sheetObj.RgbColor(153, 255, 255);
				sheetObj.CellEditable(idCnt, "apro_rmk") = true;
				aproRmk = sheetObj.CellValue(idCnt, "apro_rmk");
				for(var i = 1;i<sheetObj.RowCount+1; i++){
					if(i != idCnt){
						sheetObj.CellEditable(i, "apro_rmk") = false;
					}
				}
				
			}else{
				for(var i = 1;i<sheetObj.RowCount+1; i++){
					sheetObj.CellEditable(i, "apro_rmk") = false;
				}
			}
		}
	}

    /**
     * Sheet 관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	    					
	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    						
				formObj.reset();
											
				//초기값 설정
				if(sActionIdx!=8)
				{
					formObj.in_ttl_lss_no.value		    = ""; 
					formObj.ttl_lss_no.value		    = "";  					//TLL No
				}
				var sCondition = new Array (		 		 
					//MultiCombo  
					new Array("MnrGenCd","","CUSTOM9")
						    
				)				 			
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
												
				var comboDefValue = "";		
				//*** EQ_TYPE	
				if(comboList[0] != null){	
					formObj.eq_knd_cd.InsertItem(0, 'ALL' ,'ALL');        
					for(var j = 1; j < comboList[0].length + 1;j++){ 
						var tempText = comboList[0][j - 1].split("|");	  
						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}			    
				} 
				formObj.eq_knd_cd.Code = 'ALL'; 
				
				//초기값 설정
				formObj.wrtf_no.value		= "";					//Write Off No
				formObj.in_ttl_lss_no.value		= "";				//TLL No
				formObj.in_ttl_lss_no.readOnly 	= false;
				formObj.eq_knd_cd.Index = 0;
				formObj.in_rqst_eq_no.value 			= "";
				formObj.file_seq.value = "";
				formObj.sub_file_seq.value = "";
				
				formObj.ttl_lss_dtl_rsn_rmk.value   = "";
				formObj.dpc_clt_fald_rsn_rmk.value   = "";
				formObj.rcvr_act_his_rmk.value   = "";
				
				formObj.dvAmtTtl.value = "";
				formObj.recveryAmtTtl.value = "";
				formObj.lossAmtTtl.value = "";
				
				var toDay = ComGetNowInfo("ymd");
				
				formObj.respb_ofc_cd.readOnly=true;
				formObj.respb_ofc_cd.className="input2";
				
		  
				//초기값 설정 
				var threeBeforeMonth = ComGetDateAdd(toDay, "M", -3); 
				ComSetObjValue(formObj.in_st_dt,threeBeforeMonth); 
				ComSetObjValue(formObj.in_end_dt,toDay); 
						
				uploadFileSeq = "";
				historyMnrStsRefNo = "";
							
				
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	    		
	        	nowLoad=0;
	    		break;
	        
	    	//Header 조회
            case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction)) {
                	sheetObj.WaitImageVisible = false;
    	    		MnrWaitControl(true);
    				formObj.f_cmd.value = SEARCH;
    	    		// 모든 쉬트를 초기화
    	    		for (i = 0; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
					
    				formObj.ttl_lss_no.value = formObj.in_ttl_lss_no.value;   //TLL NO
    				formObj.user_ofc_cd.value = currOfcCd;
					var sParam = FormQueryString(formObj);  
					var sXml = sheetObj.GetSearchXml("EES_MNR_0263GS.do", sParam);
					sheetObj.LoadSearchXml(sXml);
					
					if(ComGetTotalRows(sXml)<=0){
						formObj.ttl_lss_dtl_rsn_rmk.value   = "";
						formObj.dpc_clt_fald_rsn_rmk.value   = "";
						formObj.rcvr_act_his_rmk.value   = "";
						
						formObj.dvAmtTtl.value = "";
						formObj.recveryAmtTtl.value = "";
						formObj.lossAmtTtl.value = "";
						
						formObj.wrtf_no.value		= "";
						
						uploadFileSeq = "";
						historyMnrStsRefNo = "";
						
						formObj.file_seq.value = "";
						formObj.sub_file_seq.value = "";
						formObj.mnr_sts_ref_no.value = "";
					}
					MnrWaitControl(false);
		    		sheetObj.WaitImageVisible = true;
	            }
                break;  
	    		
        	//Detail 조회
            case IBROWSEARCH:      
                if(validateForm(sheetObj,formObj,sAction)) {			
                	sheetObj.WaitImageVisible = false;
    	    		MnrWaitControl(true);
    	    		
                	formObj.f_cmd.value = SEARCH01;      
    				for (i = 1; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
					
					var sXml = sheetObj.GetSearchXml("EES_MNR_0263GS.do", FormQueryString(formObj));

					formObj.ttl_lss_dtl_rsn_rmk.value = ComGetEtcData(sXml,"ttl_lss_dtl_rsn_rmk");
					formObj.dpc_clt_fald_rsn_rmk.value = ComGetEtcData(sXml,"dpc_clt_fald_rsn_rmk");
					formObj.rcvr_act_his_rmk.value = ComGetEtcData(sXml,"rcvr_act_his_rmk");
					
					formObj.file_seq.value = ComGetEtcData(sXml,"file_seq");
					formObj.sub_file_seq.value = ComGetEtcData(sXml,"sub_file_seq");
					
					sheetObjects[1].LoadSearchXml(sXml);
					
					MnrWaitControl(false);
		    		sheetObj.WaitImageVisible = true;
		    		
	            }
                break;

            //저장
            case IBSAVE:   
            	if(nowLoad != 0) return;
    			nowLoad=1;
    			
    			MnrWaitControl(true);
    			if(validateForm(sheetObj,formObj,sAction,sActionIdx)) {
    				formObj.f_cmd.value = MULTI;

    				var sParam1 = sheetObjects[1].GetSaveString(true, true);
    				sParam1 = ComSetPrifix(sParam1,"h1sheet1_");
    				if(sParam1=="")
    				{
    					nowLoad=0;
    					MnrWaitControl(false);
    					return;
    				}

    				var sParam2 = sheetObjects[3].GetSaveString(true, true);
    				sParam2 = ComSetPrifix(sParam2,"t1sheet2_");
    				if(sParam2=="" && sheetObjects[3].RowCount > 0)
    				{
    					nowLoad=0;
    					MnrWaitControl(false);
    					return;
    				}

    				if(sActionIdx == 1){
    					formObj.work_type.value = "Approval";
    				}else if (sActionIdx == 2){
    					formObj.work_type.value = "Reject";
    				}

    				var sParam  = FormQueryString(formObj)+"&"+ sParam1 +"&"+ sParam2;

    				if (sParam == "")
    				{
    					nowLoad=0;
    					MnrWaitControl(false);
    					return;
    				}

    				sParam += "&" + FormQueryString(formObj);

    				sSaveRtnXml = sheetObjects[0].GetSaveXml("EES_MNR_0263GS.do", sParam);	//Total Loss No 를 return 받는다.
    				
    				if(ComGetEtcData(sSaveRtnXml,"TRANS_RESULT_KEY")=="S"){
    					ComShowCodeMessage("MNR00023"); 
    					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    					MnrWaitControl(false);
    				}else{
    					MnrWaitControl(false);
    					ComShowCodeMessage("MNR00382");
    					ComBtnDisable("btn_Confirm");
    					ComBtnDisable("btn_Reject");
    					ComBtnDisable("btn_Retrieve");
    				}
    			}
    			MnrWaitControl(false);
    			nowLoad=0;
    			
    			break;

            // Row 입력
			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)) {
					var Row  = sheetObj.DataInsert(-1);
						
					//Total Loss No 설정
					sheetObj.CellValue2(Row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
					//mnr_inv_tp_cd 설정
					if(sheetObj.id == 't1sheet1') {
						sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "DV";
						sheetObj.CellValue2(Row, "ttl_lss_dtl_sts_cd") = "";
					} else if (sheetObj.id == 't2sheet1') {
						sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "TP";
						sheetObj.CellValue2(Row, "ttl_lss_dtl_sts_cd") = "";
					} else if (sheetObj.id == 't3sheet1') {
						sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "DS";
					} else if (sheetObj.id == 't4sheet1') {
						sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "SC";
					} else if (sheetObj.id == 't5sheet1') {
						sheetObj.CellValue2(Row, "mnr_inv_tp_cd") = "IR";
						sheetObj.CellValue2(Row, "ttl_lss_plc_nm") = "";
					}  	 	 	
					//그리드 콤보 값 초기화
					sheetObj.CellValue2(Row, "curr_cd") = "USD";	//CURR
				}	
                break;
                
    		//Row 삭제
			case IBDELETE:	
			    if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id != "sheet3"){
						if(sheetObj.id=="t1sheet1")
						{
							var tabSheetIndex=2; //D.V Expense텝에 sheetObjects 처음 인덱스
				 			for(var i=sheetObjects[tabSheetIndex].HeaderRows; i<=sheetObjects[tabSheetIndex].LastRow; i++) 
							{
				 				if(sheetObjects[tabSheetIndex].CellValue(i,"del_chk")==1)
				 				{
				 					//D.V Expense 텝의  선택된 EQ No.
				 					var rqstEqNo=sheetObjects[tabSheetIndex].CellValue(i,"rqst_eq_no")
				 					
				 					
				 					//3rd Party,Disposal,Scrapping,Insurance 텝에서 rqstEqNo변수와 관련되거 체크
				 					for(var j=tabSheetIndex+1; j<=tabSheetIndex+4;j++)
						 			{
					 					var row=sheetObjects[j].FindText("rqst_eq_no", rqstEqNo);
					 					if(row > 0)
					 					{
						 					sheetObjects[j].CellValue(row,"del_chk")="1";
						 					ComRowHideDelete(sheetObjects[j], "del_chk");
					 					}
						 			}
				 				}
							}
				 			ComRowHideDelete(sheetObjects[tabSheetIndex], "del_chk");
						}else{
							ComRowHideDelete(sheetObj, "del_chk");
						}

					} else {		
						MnrRowDelete(sheetObj,"del_chk")
					}	
					setCalculateTotalSum();
				}    
				break;
                
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, sActionIdx){
        var formObj = document.form;   
		with(formObj){
			//행추가시	 		
			if (sAction == IBINSERT) {	
				var dvTabRowCnt = sheetObjects[2].RowCount - sheetObjects[2].RowCount("D");
				var chkTabRowCnt = sheetObj.RowCount - sheetObj.RowCount("D");
				if(dvTabRowCnt <= chkTabRowCnt){  	
					ComShowCodeMessage("MNR00339");  		
					return false;	   								
				}			  	 
			}	
			// 조회시 체크
    		else if (sAction == IBSEARCH) { 
    			// Dataformat      				
    			if (!ComChkValid(formObj)) {	
    				return false;			
    			}

    		}
			//저장(Reject,Confirm)시 
			else if(sAction == IBSAVE) { 
				if (beforetab == 1){
					tabObjects[0].SelectedIndex=1;
				}
				
				if(sheetObjects[3].CellValue(idCnt, "apro_usr_id")!=usrId){
					ComShowCodeMessage("MNR00312","Approval/Reject");
					return false;
				}
				var check = true;
				var type = "";
				var idx = 0;
				for(var i=1; i < sheetObjects[3].RowCount+1; i++){
					if(sheetObjects[3].CellValue(i, "apro_usr_id") == usrId){
						if(sheetObjects[3].CellValue(i, "apro_rmk") == ""){
							check = false;
							type = "N";
							idx = i;
							break;
						}
						if(sheetObjects[3].CellValue(i, "apro_rmk") == aproRmk){
							check = false;
							type = "Y";
							idx = i; 
							break;
						}
					}
				}
				
				if(!check){
					if(type == "N"){
						ComShowCodeMessage("MNR00003","Remarks");
						tab1_OnChange(tabObjects[0] , 0);
						sheetObjects[3].SelectCell(idx, "apro_rmk");
						return false;
					}
					else if (type == "Y"){
						ComShowCodeMessage("MNR00369");
						tab1_OnChange(tabObjects[0] , 0);
						sheetObjects[3].SelectCell(idx, "apro_rmk");
						return false;
					}
				}
				
				
				
				//(Reject/Confirm)의사 확인
				if(sActionIdx == 1) {
					if (!ComShowCodeConfirm("MNR00275","Write Off", "Confirm")){return false;}	
				} else if(sActionIdx == 2){
					if (!ComShowCodeConfirm("MNR00275","Write Off", "Reject")){return false;}	
				}
			}
        }   
        return true; 
    }
		
    
	/**
	 * EES_MNR_0195 Popup의 값을 받은 함수      
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
    	var formObj = document.form; 
			        
		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.in_ttl_lss_no.value = aryPopupData[0][4];
		}	
	} 	   	  
		
	
 	/**
	 * COM_ENS_071 의 값을 받은 함수      
	 */
	function setCOM_ENS_071(aryPopupData){
    	 var formObj = document.form;	
    	 var Row=sheetObjects[3].SelectRow;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[3].CellValue(Row, "respb_ofc_cd") 		= aryPopupData[0][3];
		 }      
    } 	 
	 
	
	/**
     * 저장시 필수 체크
     * @param	{Element}	obj	체크할 Form Element
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {  
		    ComShowCodeMessage("MNR00003");
		    return false; 
		}
		return true;
	}

	/**
	 * 저장시 그리드 존재유무
	 */
	function checkIsDetailRow(){
		var cnt = 0;
		for (var i=2; i<7; i++) {
			if(sheetObjects[i].RowCount > 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		
		return true;
	}

	/**
	 * Reject, Confirm 버튼 클릭시 저장이벤트를 강제 발생시키기 위해 
	 * 존재하는 최초의 1개의 Row상태값만을 'U'로 변경시킴
	 */
	function setRowStausByRequest(){
		for (var i = 2; i < 7; i++) { 
			//데이터가 존재하는 시트인 경우만  
			if(sheetObjects[i].RowCount > 0) {
				for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
					if(sheetObjects[i].RowStatus(j)== "R") {
					    sheetObjects[i].RowStatus(j) = "U";
						return;
					}
				}
			}
		}
	}
			
	/**	
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */  
	function getMnr_Multi(rowArray,rtn_val) { 
		var formObj = document.form;  
		var tempText = "";  	
		//초기화	    
		formObj.in_ttl_lss_no.value = ''; 	
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ','; 	  
		}      	
		//마지막에 ,를 없애기 위함     
		tempText = MnrDelLastDelim(tempText); 		 
										 	    
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + rtn_val + ".value = '" + tempText + "';"); 
	}
    
    	