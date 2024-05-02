/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S301.js	 	
*@FileTitle : My Bidding List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03 	
*@LastModifier : 김완규	
*@LastVersion : 1.0 
* 2009.12.03 김완규     
* 1.0 Creation
* 2011.07.11 김종옥 [선처리] 두번째 입찰은 + 25 단위로 가능하도록 하는 기능 삭제처리(이유목 수석 요청)
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
     * @class EES_MNR_S301 : EES_MNR_S301 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_S301() {
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

//메세지용 
var actionType = "";	

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
				//조회(Header)
				case "btn_Retrieve":   
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);  
					break;

				//초기화
				case "btn_New":     
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR,1);
					break;	 	

				//Location 팝업
				case "location_country_cd_popup":
					var locationType = formObject.location_type.Code;
					if(locationType=='L') {
						ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 540, 'setCOM_ENS_051', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					} else if(locationType=='C') {
						ComOpenPopup('/hanjin/COM_ENS_0M1.do', 570, 470, 'setCOM_ENS_0M1', "1,0,1,1,1,1,1", true);
					}
					break; 
			
				//조회(Detail)
				case "btn_BiddingDetail":
					doActionIBSheet(sheetObjects[1],formObject,IBROWSEARCH);
					setSelectTab();													//탭설정
					getFileAttachment(sheetObjects[1],sheetObjects[1].SelectRow);	//파일 리스트 조회
					getBiddingRemarks(sheetObjects[1],sheetObjects[1].SelectRow);	//Bidding Remarks 조회
					//버튼 Edit 설정
					var biddingStatus = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bidding_status");
					setBtnEdit(biddingStatus);			
					break;	
		
				//Excel
				case "btn_DownExcel": 
					sheetObjects[1].SpeedDown2Excel(-1); 
					break;

				//Submit
				case "btn_Submit": 
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);		
					break; 		 
		
				//Cancel
				case "btn_Cancel":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
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
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,0);
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
     * @param uploadObj
     * @return
     */
    function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param sheet_obj
	 * @return
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
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
	 * @param tabObj
	 * @param tabNo
	 * @return
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
     * 파일업로드 항목 설정
     * @param uploadObj
     * @param uploadNo
     * @return
     */
    function initUpload(uploadObj, uploadNo) {
		   uploadObj.Files = ""; 
	}	

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param sheetObj
     * @param sheetNo
     * @return
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
                    style.height = 124;
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
						
					var HeadTitle1 = "|Seq|Bidding No|Sale\nType|Posting Date|Opening Time|Closing Time|Time Left|Pick-Up Period|Bidding\nStatus|Curr|EQ Info|EQ Info|My Offer|My Offer"
					var HeadTitle2 = "|Seq|Bidding No|Sale\nType|Posting Date|Opening Time|Closing Time|Time Left|Pick-Up Period|Bidding\nStatus|Curr|QTY|Total  Price|QTY|Total Amount";
					var headCount = ComCountHeadTitle(HeadTitle1);
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 2, 0, 0, true);           
							
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
									
                    //데이터속성    [ROW, COL,      DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,	50,     daCenter,  	false,	"ibflag");
					InitDataProperty(0, cnt++,  dtSeq,    		30,     daCenter,   true,   "Seq"); 
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"disp_no",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		    35,		daLeft,		true,	"disp_ut_tp_nm",	false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80, 	daCenter,	true,	"disp_bultn_dt",	false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"disp_st_dt",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"disp_end_dt",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"left_time",		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	"disp_pkup_period",	false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	"bidding_status",	false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	"curr_cd",			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daRight,	false,	"disp_qty",			false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"disp_ut_prc",		false,	"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   		35,		daRight,  	false,  "part_disp_qty",    false,  "",     dfNullInteger,  0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,   		70,		daRight,  	false,  "part_ut_amt",     	false,  "",     dfNullInteger,  0,  false,  false);
					//hidden
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daRight,  	false,  "mnr_disp_rmk");
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daRight,  	false,  "file_seq");
					
					CountPosition = 0;
					
					HeadRowHeight = 21;
                }				
                break;  	
			
			case "sheet3":
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
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix +"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	prefix +"seq")
					InitDataProperty(0, cnt++ , dtPopup,      	200,	daCenter,  	false,  prefix +"org_file_nm",  false,	"", dfNone,	0,	false,	false,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,  prefix +"file_dw",   	false,  "", dfNone, 0,  false,	false);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix +"file_path_nm",	false,  "", dfNone, 0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,  prefix +"file_path",   	false,  "", dfNone, 0,  false,  false);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,	prefix +"file_seq",   	false,  "", dfNone, 0,  false,  false);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	prefix +"file_dtl_seq",	false,	"",	dfNone,	0,	false,	false);
	 				
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
 
					var HeadTitle1 = "|Sel|Seq|EQ No|TP/SZ|Manu|Location|Material|Reefer\nUnit Maker|Reefer\nUnit Model|Result|Ranking|Bids Cnt\nMAX 3|Starting\nPrice|My Offer|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 12, 0, 0, true); 
 					
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
					 	 	 
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
					
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,     daCenter,  	false,	"ibflag");  
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk"); 		 
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  "seq",     				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90, 	daCenter,	false,	"eq_no",				false,	"",	dfNone,		0,	false,	false);			//EQ No
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		false,	"eq_tpsz_nm",			false,	"",	dfNone,		0,	false,	false); 		//TS
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"manu_year",			false,	"",	dfNone,		0,	false,	false);			//Manu
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"disp_yd_cd",			false,	"",	dfNone,		0,	false,	false);			//Location
					InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		false,	"mtrl_nm",				false,	"",	dfNone,		0,	false,	false);			//Material
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		false,	"mkr_nm",				false,	"",	dfNone,		0,	false,	false);			//Unit Maker
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		false,	"mdl_nm",				false,	"",	dfNone,		0,	false,	false);			//Unit Model
					InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		false,	"mnr_disp_cfm_sts_nm",	false,	"",	dfNone,		0,	false,	false);			//Result
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"rnk",					false,	"",	dfNone,		0,	false,	false);			//Rank
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"vndr_bid_knt",		    false,	"",	dfNone,		0,	false,	false);			//입찰 횟수
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"disp_ut_prc",			false,	"",	dfFloat,	2,	false,	false);			//Starting Price
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"part_ut_amt",			false,	"",	dfInteger,	0,	true,	true,	18);	//My Offer	
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"mnr_disp_dtl_rmk",		false,	"",	dfNone,		0,	false,	false);			//Remark(s)
					//Hidden
					//2010-01-22: 현업삭제요청에 의해 Hidden 처리함. 
					InitDataProperty(0, cnt++ , dtHidden,		130,	daLeft,		false,	"disp_rsn_cd",			false,	"",	dfNone,		0,	false,	false);	//Sale Category
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	false,	"disp_rlse_no",			false,	"",	dfNone,		0,	false,	false);	//Release No
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		false,	"inv_sts_nm",			false,	"",	dfNone,		0,	false,	false);	//Invoice Status
					//2010-01-22: 현업삭제요청에 의해 Hidden 처리함.
					InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	"eq_tpsz_cd",			false,	"",	dfNone,		0,	false,	false); //TS
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daLeft,  	false,  "disp_yd_nm");	 	
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daLeft,  	false,  "file_seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"part_disp_qty")
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "disp_no");	 	
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"disp_dtl_seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"mnr_prnr_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"mnr_prnr_seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"tmp_part_ut_amt");
					
					CountPosition = 0;     
					     						 	
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
																	
					var HeadTitle1 = "|Sel|Seq|TP/SZ|Q'ty|Location|Result|Ranking|Bids Cnt\nMAX 3|Starting\nPirce|My Offer\n(Qty)|Unit Price|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 10, 0, 0, true);  
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다. 
					InitHeadMode(true, true, true, true, false,false);
								
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 
 						
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,     daCenter,  	false,	"ibflag");  
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	"del_chk"); 		 
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  "seq",     				false,	"",	dfNone     );
					InitDataProperty(0, cnt++ , dtData,			150, 	daLeft,		false,	"eq_tpsz_nm",			false,	"",	dfNone,		0,	false,	false);			//TS
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,	"disp_qty",		 		false,	"",	dfInteger,	0,	false,	false);			//Q'TY
					InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"disp_yd_cd",			false,	"",	dfNone,		0,	false,	false );		//Location
					InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		false,	"mnr_disp_cfm_sts_nm",	false,	"",	dfNone,		0,	false,	false);			//Result	
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"rnk",					false,	"",	dfNone,		0,	false,	false);			//Rank
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"vndr_bid_knt",			false,	"",	dfNone,		0,	false,	false);			//입찰 횟수
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"disp_ut_prc",			false,	"",	dfFloat,	2,	false,	false);			//Starting Price
					InitDataProperty(0, cnt++ , dtData,			55,		daRight,	false,	"part_disp_qty",		false,	"",	dfInteger,	0,	true,	true,	6);		//My Offer(Qty)
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"part_ut_amt",			false,	"",	dfInteger,	0,	true,	true,	18);	//My Offer(Amt)
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"mnr_disp_dtl_rmk",		false,	"",	dfNone,		0,	false,	false);			//Remark(s)
					//Hidden
					//2010-01-22: 현업삭제요청에 의해 Hidden 처리함. 
					InitDataProperty(0,	cnt++,	dtHidden,		120,	daCenter,	false,	"disp_rlse_no",			false,	"",	dfNone,		0,	false,	false );  	//Release No
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		false,	"inv_sts_nm",			false,	"",	dfNone,		0,	false,	false);		//Invoice Status
					//2010-01-22: 현업삭제요청에 의해 Hidden 처리함. 
					InitDataProperty(0, cnt++ , dtHidden,		45, 	daCenter,	false,	"eq_tpsz_cd",			false,	"",	dfNone,		0,	false,	false);		//TS
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daLeft,  	false,  "disp_yd_nm");	
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daLeft,  	false, 	"file_seq");	 	
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "disp_no");	 	
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"disp_dtl_seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"mnr_prnr_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"mnr_prnr_seq");
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	"tmp_part_ut_amt");  
					  		 								 
					PopupImage  =  "/hanjin/img/btns_search.gif";  
					ShowButtonImage = 2;   
					CountPosition = 0;	
					
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
	
	/**
     * Sheet관련 프로세스 처리
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @param sActionIdx
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	// 초기화 
        	case IBCLEAR:      
				MnrWaitControl(true);
				sheetObj.WaitImageVisible=false;

				uploadFileSeq = "";    
				actionType = "";
				
				//해당 아이디에 해당하는 OFC 정보를 가져온다.
				//세션에 안들어옴
				var sppOfcCd = MnrGetSPPPartnerOFC(sheetObjects[0],spPtalId);
				ofcCd = sppOfcCd; 
								
				//모든 항목 초기화
				formObj.reset();
				
				formObj.ofc_cd.value = 	sppOfcCd;
				
				//쉬트 초기화		
				for(var i = 1; i < sheetObjects.length;i++){ 
					sheetObjects[i].RemoveAll();   	
				}    	   										
				
				//탭 설정
				setSelectTab();
				
				//최초 로딩시에만 콤보조회 설정
				if(sActionIdx==0) {
					//콤보 초기화  
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].Code = "-1"; 
						comboObjects[i].RemoveAll(); 	
					}  
					//콤보 조회(Result, Bidding Status)  
					var sCondition = new Array (
						new Array("MnrGenCd","SELHO","CUSTOM9") ,  	//EQ Type
						new Array("MnrGenCd","CD00078", "COMMON"), 	//Sale Type
						new Array("MnrGenCd","CD00079", "COMMON"), 	//Location or Country
						new Array("MnrGenCd","CD00075", "COMMON"),  //bidding_status
						new Array("MnrGenCd","CD00038", "COMMON")	//Sale Category
					)	 	  
					var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
					//콤보 설정(Result, Bidding Status, Sale Category) 
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							//Display[CODE_NAME]:eq_knd_cd,bidding_status 
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//eq_knd_cd 
								if(i==0) {
									formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
								//bidding_status
								} else if(i==1){
									formObj.disp_ut_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
								//location_type
								} else if(i==2){
									formObj.location_type.InsertItem(j, tempText[1] ,tempText[0]);
								}
							}
							//bidding_status
							if(i==3) {
								sheetObjects[1].InitDataCombo (0, "bidding_status", sheetComboText, sheetComboCode ,sheetComboCode); 
							//Sale Category
							} else if(i==4){
								sheetObjects[2].InitDataCombo (0, "disp_rsn_cd", sheetComboText, sheetComboCode ,sheetComboCode); 
							}
						}
					}
					formObj.eq_knd_cd.InsertItem(0,"ALL","ALL");
					formObj.disp_ut_tp_cd.InsertItem(0,"ALL","ALL");
					formObj.location_type.InsertItem(0,"ALL","ALL");
				}

				//초기값 설정 
				ComSetObjValue(formObj.eq_knd_cd,"ALL");		//EQ Type
				ComSetObjValue(formObj.disp_ut_tp_cd,"ALL");	//Sale Type
				ComSetObjValue(formObj.location_type,"ALL");	//Location Type
				
				sheetObj.WaitImageVisible=true;	
				MnrWaitControl(false);  	
				break;        

			//조회
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)){
					//디테일 쉬트 초기화		
					for(var i = 2; i < sheetObjects.length;i++){ 
						sheetObjects[i].RemoveAll();   	
					}    	   										

					//헤더 리스트 조회   
					formObj.f_cmd.value = SEARCH;    
				    sParam = FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_S301GS.do", sParam);
				    sheetObjects[1].LoadSearchXml(sXml);    	
				}	 	 	
				break;	

			//상세 조회 
			case IBROWSEARCH:          
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.selected_disp_no.value = sheetObj.CellValue(sheetObj.SelectRow, "disp_no");
					formObj.f_cmd.value = SEARCH01;         
					sParam = FormQueryString(formObj);      
					var sXml = sheetObj.GetSaveXml("EES_MNR_S301GS.do", sParam);
					var arrXml = sXml.split("|$$|");       

					for(var i = 0; i < arrXml.length; i++){   
						sheetObjects[i + 2].LoadSearchXml(arrXml[i]);
					}	 
				}        
               break; 		
			
            //저장
			case IBSAVE:
              if(validateForm(sheetObj,formObj,sAction)){
					//Closing Time 체크
					formObj.f_cmd.value = SEARCH04;
			        var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("EES_MNR_S301GS.do", sParam);
					var vBiddingStatus = ComGetEtcData(sXml,"biddingStatus");

					if(vBiddingStatus == "O"){
	            	    actionType = "IBSAVE";
	            	  	formObj.f_cmd.value = MULTI;
	            	  	var sParam1 = sheetObjects[2].GetSaveString(true, true);
						//멘덴토리 체크         
						if(sParam1 == "" && sheetObjects[2].IsDataModified){  
							return; 		
						}   
						sParam1 = ComSetPrifix(sParam1,"biddingDtl_"); 
	            	  	var sParam2 = sheetObjects[3].GetSaveString(true, true); 
						//멘덴토리 체크         
						if(sParam2 == "" && sheetObjects[3].IsDataModified){  
							return; 		
						}   
						sParam2 = ComSetPrifix(sParam2,"biddingDtl_"); 
							
						var sParam = sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj); 
	            	  	var sXml = sheetObjects[0].GetSaveXml("EES_MNR_S301GS.do", sParam); 
	            	  	sheetObjects[1].LoadSaveXml(sXml);
							
	            	  	if(MnrComGetErrMsg(sXml) == null){
							var dispNo = ComGetEtcData(sXml, "disp_no");				
							 
							var targetRow = 0;
							with(sheetObjects[1]){ 
								for(var j=sheetObjects[1].HeaderRows; j<=sheetObjects[1].LastRow; j++){     
									if(CellValue(j,"disp_no") == dispNo){
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
					}else{
						var formObject = document.form;
						ComShowCodeMessage("MNR00364");
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR,1);
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					}
				} 	
				break; 

			//삭제
			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)){
					//상태값 재설정
					for(var i=2; i<=3; i++) {
						for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
							var delChk = sheetObjects[i].CellValue(j, "del_chk");
							if(delChk==1) {
								sheetObjects[i].RowStatus(j) = "D";
							} else {
								sheetObjects[i].RowStatus(j) = "R";
							}
						}
					}
					actionType = "IBDELETE"; 
				 	formObj.f_cmd.value = REMOVE01;      	     
				 	
				 	var sParam1 = sheetObjects[2].GetSaveString(true, true);
				 	sParam1 = ComSetPrifix(sParam1,"biddingDtl_");
				 	var sParam2 = sheetObjects[3].GetSaveString(true, true);
				 	sParam2 = ComSetPrifix(sParam2,"biddingDtl_"); 
				 	var sParam = sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj); 
            	  	var sXml = sheetObjects[0].GetSaveXml("EES_MNR_S301GS.do", sParam); 
            	  	sheetObjects[1].LoadSaveXml(sXml);
				 	
            	  	if(MnrComGetErrMsg(sXml) == null){
						var dispNo = ComGetEtcData(sXml, "disp_no");				
						 
						var targetRow = 0;
						with(sheetObjects[1]){ 
							for(var j=sheetObjects[1].HeaderRows; j<=sheetObjects[1].LastRow; j++){     
								if(CellValue(j,"disp_no") == dispNo){
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
				 }   
				break;
				
			//체크조회(Location)
			case IBSEARCH_ASYNC01:
				if ( validateForm(sheetObj, formObj, sAction) ) {  
					var locationCountryCdObj	= formObj.location_country_cd;
					var locationCountryCd 		= locationCountryCdObj.value;
							
					var retArray = MnrGeneralCodeCheck(sheetObj,"MLOC",locationCountryCd);      
					
					if(retArray == null){        
						ComShowCodeMessage("MNR00165",locationCountryCd,"MLOC");       				
						ComSetObjValue(locationCountryCdObj, "");  	    
						ComSetFocus(locationCountryCdObj);                   
					}   	 
				}	
				break;  
				
			//체크조회(Country)
			case IBSEARCH_ASYNC02:
				if ( validateForm(sheetObj, formObj, sAction) ) {  
					var locationCountryCdObj	= formObj.location_country_cd;
					var locationCountryCd 		= locationCountryCdObj.value;
					
					var retArray = MnrGeneralCodeCheck(sheetObj,"CNT",locationCountryCd);      
					
					if(retArray == null){        
						ComShowCodeMessage("MNR00165",locationCountryCd,"CNT");       				
						ComSetObjValue(locationCountryCdObj, "");  	    
						ComSetFocus(locationCountryCdObj);                   
					}   	 
				}		
				break;  
        }				
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){            	        
	    	switch(sAction) {
				//조회     
				case IBSEARCH:
					//Dataformat
					if (!ComChkValid(formObj)) {return false;}
					break;
					
				//상세조회     
				case IBROWSEARCH:  
					if(sheetObjects[1].RowCount < 1){
						ComShowCodeMessage("MNR00248","Disposal ");  
						return false;   
					}	
					break;   	
	    	
				//저장 
				case IBSAVE: 
					var eqListCnt 	= parseFloat(sheetObjects[2].RowCount);
					var bulkListCnt	= parseFloat(sheetObjects[3].RowCount);
					if(eqListCnt + bulkListCnt < 1) { return false;}
					
					if (!ComChkValid(formObj)) return false;

					//EQ List 
					if(eqListCnt > 0) {
						for(var i=sheetObjects[2].HeaderRows; i<=sheetObjects[2].LastRow; i++) {
							var startPrice 	= parseFloat(sheetObjects[2].CellValue(i, "disp_ut_prc"));
							var myOffer		= parseFloat(sheetObjects[2].CellValue(i, "part_ut_amt"));
							var bidsCnt		= parseFloat(sheetObjects[2].CellValue(i, "vndr_bid_knt"));
							var preMyOffer	= parseFloat(sheetObjects[2].CellValue(i, "tmp_part_ut_amt"));
							//0은 입찰 안한걸루 간주	
							if(myOffer != 0 && startPrice > myOffer) {
								//MyOffer 가  StartPrice 보다 커야 합니다. 
								ComShowCodeMessage("MNR00173"); 
								sheetObjects[2].SelectCell(i,"part_ut_amt");
								return false;		
							}	
							
							if(bidsCnt > 3 && myOffer != preMyOffer) {
								//3회 이상 입찰 불가능 
								ComShowCodeMessage("MNR00350");  
								sheetObjects[2].SelectCell(i,"part_ut_amt");
								return false;
							}
						}
					}
					
					//Bulk Sale Setting
					if(bulkListCnt > 0) {
						for(var i=sheetObjects[3].HeaderRows; i<=sheetObjects[3].LastRow; i++) {
							var qty			= parseFloat(sheetObjects[3].CellValue(i, "disp_qty"));			//Q'ty
							var myOfferQty	= parseFloat(sheetObjects[3].CellValue(i, "part_disp_qty"));	//My Offer(Qty)
							var startPrice 	= parseFloat(sheetObjects[3].CellValue(i, "disp_ut_prc"));		//Starting Price
							var myOfferAmt	= parseFloat(sheetObjects[3].CellValue(i, "part_ut_amt"));		//My Offer(Amt)
							var bidsCnt		= parseFloat(sheetObjects[3].CellValue(i, "vndr_bid_knt"));     //입찰 횟수
							var preMyOffer	= parseFloat(sheetObjects[3].CellValue(i, "tmp_part_ut_amt"));
							
							//Qty
							if(qty < myOfferQty) {
								ComShowCodeMessage("MNR00166");
								sheetObjects[3].SelectCell(i,"part_disp_qty"); //value1 가 value2 보다 작아야 합니다.
								return false;
							}
							if(myOfferQty > 0) {
								//Price
								if(startPrice > myOfferAmt) {
									//value1 가 value2 보다 커야 합니다. 
									ComShowCodeMessage("MNR00173"); 
									sheetObjects[3].SelectCell(i,"part_ut_amt");
									return false;
								}
							} else {
								sheetObjects[3].CellValue(i, "part_ut_amt") = 0;
							}
							
							if(bidsCnt > 3 && myOffer != preMyOffer) {	
								//3회 이상 입찰 불가능	
								ComShowCodeMessage("MNR00350");
								sheetObjects[3].SelectCell(i,"part_ut_amt");
								return false;
							}	
						}
					}
					break;
					
				case IBDELETE:
					var eqListCnt 	= sheetObjects[2].RowCount;
					var bulkListCnt	= sheetObjects[3].RowCount;
					if(eqListCnt + bulkListCnt < 1) { return false;}
					
					var eqListChkCnt 	= sheetObjects[2].CheckedRows("del_chk");
					var bulkListChkCnt	= sheetObjects[3].CheckedRows("del_chk");
					if(eqListChkCnt + bulkListChkCnt < 1) {
						//삭제할 대상을 선택해달라는 메시지 표시
						ComShowCodeMessage("MNR00150"); 
						return false;
					}
							
					if (!ComShowCodeConfirm("MNR00275","Bidding Detail Offer","Delete")){return false;}  
					break; 	 		  
			}		 
		}	
        return true; 
    }	
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * @param tabObj
	 * @param nItem
	 * @return
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
	 * Location 콤보박스 변경시 Location input box 의 형식을 설정한다.
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
    function location_type_OnChange(comboObj,Index_Code, Text){
    	var formObj = document.form;
    	if(Index_Code=='ALL') {
    		//Location Cd input box 설정
			formObj.location_country_cd.readOnly 	= true;		
			formObj.location_country_cd.className	= "input2";	
			formObj.location_country_cd.removeAttribute("required");
    	} else {
    		//input box 설정
    		formObj.location_country_cd.readOnly 	= false;	
    		formObj.location_country_cd.className	= "input1";	
    		formObj.location_country_cd.setAttribute("required","");
    		formObj.location_country_cd.focus();
    		if(Index_Code=='L') {
    			formObj.location_country_cd.maxLength = "5";
    		} else if(Index_Code=='C') {
    			formObj.location_country_cd.maxLength = "2";
    		}
    	}
    	formObj.location_country_cd.value = "";
    }
	
	/**
	 * 상세중 EQ List 의 조회완료시 풍선말 설정
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function t1_sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount<1) {return;}
		setToolTipText(sheetObj);
	}
	
    /**
     * 상세중 Bulk List 의 조회완료시 풍선말 설정
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
	function t2_sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount<1) {return;}
		setToolTipText(sheetObj);
	}

	/**
	 * 상세중 Bulk List 의 MyOffer(Qty) 에 0 을 입력하면 MyOffer(Amt) 에도 0 을 입력한다. 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function t2_sheet1_OnChange(sheetObj, Row, Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
			if(colname=="part_disp_qty") { //MyOffer(Qty)
				if(Value == 0) {
					sheetObj.CellValue(Row, "part_ut_amt") = 0; //MyOffer(Amt)
				}
			}
		}
	}

	/**
	 * 저장후 메세지 처리
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") {      
			if(actionType == "IBSAVE"){ 
				ComShowCodeMessage("MNR00009","Bidding Detail List");
			} else {
				ComShowCodeMessage("MNR00020"); 	
			} 				 				   
		} 	
	}

	/**
	 * 헤더 리스트 조회완료시 탭,저장버튼 설정
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		setSelectTab();		//탭설정
		setBtnEdit('O');	//저장버튼설정
	}

	/**
	 * 헤더 리스트 더블클릭시 상세조회 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet2_OnDblClick(sheetObj,Row,Col) {				
		var formObj = document.form; 
		with(sheetObj){ 
			//해당 쉬트 초기화    
			sheetObjects[2].RemoveAll();   
			sheetObjects[3].RemoveAll();  
			sheetObjects[4].RemoveAll();
			
			//디테일 조회   	 
			doActionIBSheet(sheetObjects[1],formObj,IBROWSEARCH); 
			
			//탭선택
			setSelectTab();

			//파일 리스트 조회   
			getFileAttachment(sheetObj,Row);
			
			//Remark 조회
			getBiddingRemarks(sheetObj,Row);
			
			//버튼 설정(Submit, Cancel)
			var biddingStatus = sheetObj.CellValue(Row, "bidding_status");
			setBtnEdit(biddingStatus);
		} 
    }
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/  
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
   		   
        if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
			
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  
    
/* ********* User Functions ************* */
    /**
     * 상세조회시 헤더의 Bidding Remark(s) 를 하단에 보여준다.
     * @param sheetObj
     * @param Row
     * @return
     */
    function getBiddingRemarks(sheetObj, Row) {
		var biddingRemarks = sheetObj.CellValue(Row, "mnr_disp_rmk");
	    document.form.mnr_disp_rmk.value = biddingRemarks;
	}
	
	/**
	 * 상세조회시 File Attachment 를 조회하여 보여준다.
	 * @param sheetObj
	 * @param Row
	 * @return
	 */
	function getFileAttachment(sheetObj,Row) {
		var fileSeq = sheetObj.CellValue(Row,"file_seq");
		uploadFileSeq = fileSeq;
		if(fileSeq != "" && fileSeq != null){
			var fileXml = SearchFileUpload(sheetObjects[4],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[4].LoadSearchXml(fileXml);		
			}	
		}	      
			
	}
	
	/**
	 * 조회후 상세 Location 컬럼에 풍선말 설정
	 * @param sheetObj
	 * @return
	 */
	function setToolTipText(sheetObj) {
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
			sheetObj.ToolTipText(i, "disp_yd_cd") = sheetObj.CellValue(i, "disp_yd_nm");
			var bidsCnt	= parseFloat(sheetObj.CellValue(i, "vndr_bid_knt"));	
			if(bidsCnt >= 3){	
				sheetObj.CellEditable(i, "part_ut_amt") = false;		
			}	
		}
	}
	
	/**
	 * 저장버튼의 및 수정컬럼 Edit 설정
	 * @param {String} biddingStatus 
	 * @return
	 */
    function setBtnEdit(biddingStatus){
    	if(biddingStatus=='C') {
    		//버튼
    		ComBtnDisable("btn_Submit");
    		ComBtnDisable("btn_Cancel");
    		//컬럼
    		for(i=2; i<=3; i++) {
	    		for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
	    			if(i==3) {
	    				sheetObjects[i].CellEditable(j, "part_disp_qty")= false;  	//My Offer(Qty)
	    			}
	    			sheetObjects[i].CellEditable(j, "part_ut_amt")		= false;	//My Offer(Amt)
	    			sheetObjects[i].CellEditable(j, "mnr_disp_dtl_rmk")	= false;	//Remark(s)
	    		}
    		}
    	} else {
    		//버튼
    		ComBtnEnable("btn_Submit");
    		ComBtnEnable("btn_Cancel");
    		//컬럼
    		for(i=2; i<=3; i++) {
	    		for(var j=sheetObjects[i].HeaderRows; j<=sheetObjects[i].LastRow; j++) {
	    			if(i==3) {
	    				sheetObjects[i].CellEditable(j, "part_disp_qty")= true;	//My Offer(Qty)
	    			}
	    			sheetObjects[i].CellEditable(j, "part_ut_amt")		= true;	//My Offer(Amt)
	    			sheetObjects[i].CellEditable(j, "mnr_disp_dtl_rmk")	= true;	//Remark(s)
	    				
					var bidsCnt	= parseFloat(sheetObjects[i].CellValue(j, "vndr_bid_knt"));		
					if(bidsCnt >= 3){											
						sheetObjects[i].CellEditable(j, "part_ut_amt") = false;		
					}	
	    		}
    		}
    	}
    }
    
    /**
     * 조회후 탭의 Edit 상태 설정
     */
	function setSelectTab() {
		var eqListCnt 	= parseFloat(sheetObjects[2].RowCount);
		var bulkListCnt	= parseFloat(sheetObjects[3].RowCount);
		if(eqListCnt > 0) {
			tabObjects[0].TabEnable(0) = true;
			tabObjects[0].TabEnable(1) = false;
			tabObjects[0].SelectedIndex = 0;
		} else if (bulkListCnt > 0) {
			tabObjects[0].TabEnable(0) = false;
			tabObjects[0].TabEnable(1) = true;
			tabObjects[0].SelectedIndex = 1;
		} else {
			tabObjects[0].TabEnable(0) = true;
			tabObjects[0].TabEnable(1) = true;
			tabObjects[0].SelectedIndex = 0;
		}
	}
    
	/**
	* COM_ENS_0M1(Country) Pop-up Return Value 처리 부분<br>
	* @param {arry} returnedValues Pop-up 화면의 Return value array
	* @param Row 대상Object가 IBSheet일 경우 해당 Row index
	* @param Col 대상Object가 IBSheet일 경우 해당 Col index
	*/
	function setCOM_ENS_0M1(aryPopupData, Row, Col) {
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.location_country_cd, aryPopupData[0][3]);
		}
	}
	
	/**
	 * COM_ENS_051 Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */ 
	function setCOM_ENS_051(aryPopupData, Row, Col) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.location_country_cd, aryPopupData[0][10]);
		}
	}
	
	/**
     * Axon 이벤트 설정
     * @return
     */
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 	//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	    axon_event.addListenerFormat('change',	 'obj_change',		formObject);	//- 변경될때
	}             

	/**
	 * Axon 이벤트 처리(blur)
	 * @return
	 */
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	
	/**
	 * Axon 이벤트 처리(focus)
	 * @return
	 */
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
					
	/**
	 * Axon 이벤트 처리(keypress)
	 * @return
	 */
	function obj_keypress(){   
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
					 			              
	    switch(obj.dataformat) {   
	        case "engup":
        		ComKeyOnlyAlphabet('uppernum');            
	            break; 
	    }         
	}	

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change(){ 
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
				case "location_country_cd":
					var locationType = formObj.location_type.Code;
					if(locationType=="L") {
						doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01); 
					} else if (locationType=="C") {
						doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02); 
					}
				   	break;
			}       
	    } 
	} 
/* 개발자 작업  끝 */