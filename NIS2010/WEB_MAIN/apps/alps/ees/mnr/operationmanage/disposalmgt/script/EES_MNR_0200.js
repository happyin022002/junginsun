/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0200.js	 	
*@FileTitle : Disposal Detail Information Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 함형석	
*@LastVersion : 1.0 
* 2009.09.28 함형석     
* 1.0 Creation  			
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
     * @class EES_MNR_0200 : EES_MNR_0200 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0200() {
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

//허용 가능 QTY PART용  
var maxEqCnt = 0; 

//IBCLEAR 일때
var isNowInit = false;  

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
 
					case "btn_New":     
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;	 	

					case "btn_Close":
						self.close();
		            break;
					
					case "btn_ResultInfo":  
						var sheetObj = "";
						if(tabObjects[0].SelectedIndex == 0){
							sheetObj = sheetObjects[5];	
						} else {
							sheetObj = sheetObjects[5]; 			
						}
						var Row = sheetObj.SelectRow; 
						var dtlSeq = sheetObj.CellValue(Row,"disp_dtl_seq");
						var newSeq = 1;
						
						if(sheetObj.RowCount > 0){
							
							for(var x = 1 ; x <= sheetObjects[5].RowCount;x++){  			
								with(sheetObjects[5]){ 
									if(CellValue(x,"disp_dtl_seq") == dtlSeq){  
										CellValue2(x,"Seq") = newSeq++;     	
										RowHidden(x) = false;    
									} else {        
										RowHidden(x) = true;   
									} 	
								    	
									CellEditable(x,"disp_cfm_qty") = false;   		
								}       
							}
						}
						maxEqCnt = sheetObj.CellValue(Row,"disp_qty");
						
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
		 var formObject = document.form;
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");
		doActionIBSheet(sheetObjects[0],formObject,IBCLEAR); 

		//파일 리스트 조회   
		var fileSeq = formObject.fileSeq.value; 
		if(fileSeq != "" && fileSeq != null){ 
			var fileXml = SearchFileUpload(sheetObjects[5],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[5].LoadSearchXml(fileXml);		
			}	
		}	
		//디테일 조회 
		doActionIBSheet(sheetObjects[0],formObject,IBROWSEARCH);
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

	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = ""; 
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
                    style.height = 0;
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
						
					var HeadTitle1 = "|S|Disposal No.|Sale\nType|EQ Type|Q'ty|Currency|Total Amount|Buyer Sel|Posting DT|Creation DT|Status"
					var headCount = ComCountHeadTitle(HeadTitle1);  
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 9, 0, 0, true);           
									
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
									
                    //데이터속성    [ROW, COL,      DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,	50,     daCenter,  	false,  "ibflag");
					InitDataProperty(0, cnt++,  dtSeq,    		30,     daCenter,   true,   "Seq"); 
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"disp_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80, 	daLeft,		false,	"disp_tp_cd",	    false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,	"eq_knd_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,	"disp_qty",			false,		"",		dfInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,	"curr_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,	"disp_st_prc",		false,		"",		dfFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"buyer_cnt",		false,		"",		dfInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"disp_bultn_dt",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"rqst_dt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		100,	daLeft,		false,	"disp_sts_cd",		false,		"",		dfNone,			0,		false,		false);
									
					//히든 데이타  
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_st_dt",      false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_end_dt",     false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_pkup_st_dt", false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_pkup_end_dt",false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_eml_flg",    false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "apro_ofc_cd",     false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "file_seq",     	false,      "",     dfNone,    		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_disp_rmk",    false,      "",     dfNone,    		0,     true,       true);
											 						
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
                   	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,    	daCenter,  	false,  "ibflag"); 
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk",					false,		"",			dfNone,				0,		false,		false);			  
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  "Seq",     					false,      "",    		dfNone     );
					InitDataProperty(0, cnt++ , dtData,			70, 	daLeft,		false,	"mnr_prnr_id",	    		false,		"",			dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			135,	daLeft,	    false,  "vndr_lgl_eng_nm",		 	false,		"",			dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,	"mnr_prnr_knd_cd",			false,		"",			dfNone,				0,		false,		false);
				          			
					//키값 히든용 
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "disp_no",        			false,      "",     	dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "ofc_cd",        			false,      "",     	dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "mnr_prnr_eml",        		false,      "",     	dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "part_amt",        			false,      "",     	dfNone,    			0,     true,       true);
					//mnr_prnr_id = mnr_prnr_cnt_cd + mnr_prnr_seq
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "mnr_prnr_cnt_cd",        	false,      "",     	dfNone,    			0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,  "mnr_prnr_seq",     		false,      "",     	dfNone,    			0,     true,       true);
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
					style.height = 80;     
					
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
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,	 prefix + "del_chk",			false,			"",		 dfNone,	0,		false,		false);		
					InitDataProperty(0, cnt++ , dtPopup,      	200,    daCenter,  	false,   prefix + "org_file_nm",     	true,           "",      dfNone,    0,     	false,		false,	50);
					InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,   prefix + "file_dw",   			false,          "",      dfNone,    0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_path_nm",   	false,          "",      dfNone,    0,     	true,      	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_path",   		false,          "",      dfNone,    0,     	true,      	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_seq",   		false,          "",      dfNone,    0,     	true,      	true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  	 prefix + "file_dtl_seq",	  	false,			"",		 dfNone,	0,		false,		false);
	 				
					CountPosition = 0;           
					 
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1; 
			}
			break;  	
			
			case "sheet5":
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
					    				
					var HeadTitle1 = "|Confirm|Seq.|Buyer Code|Buyer Name|Q'ty|U.Price|C/O Q'ty|Bidding Time|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);    
						 		
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 6, 0, 0, true);           
					     					
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);	
					  		
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 	
					         								 			
                    //데이터속성    [ROW, COL,      DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,	50,     daCenter,  	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,	"mnr_disp_cfm_sts_cd");   
					InitDataProperty(0, cnt++,  dtData,    		30,     daCenter,   true,   "disp_dtl_seq",		false,		"",		dfNone,		    0,	false,	false);   
					InitDataProperty(0, cnt++ , dtData,			70, 	daLeft,		false,	"mnr_prnr_id",	    false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	    false,  "vndr_lgl_eng_nm",  false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daRight,	false,	"disp_qty",			false,		"",		dfInteger,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"part_ut_amt",		false,		"",		dfFloat,		2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"disp_cfm_qty",		false,		"",		dfNullInteger,	0,	true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	false,  "vndr_bid_tms",  	false,		"",		dfUserFormat2,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"mnr_disp_dtl_rmk",	false,		"",		dfNone,			0,	false,	false);	
									   																	
					//히든 데이타	   
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_no",      	false,      "",     dfNone,    		0,	true,   true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_dtl_seq",    false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_prnr_cnt_cd", false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_prnr_seq",	false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_ut_tp_cd",	false,      "",     dfNone,    		0,  true,   true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "eq_tpsz_cd",		false,      "",     dfNone,    		0,  true,   true);
														  						 						
					CountPosition = 0;	 
					InitUserFormat2(0, "vndr_bid_tms", "####-##-## ##:##:## ###", "-|:" );

					//SELECT 로우 배경색	 	      
					SelectionMode = smSelectionRow;    
					SelectHighLight = false;             
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					EditableColorDiff = true; 
					 
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
 
					var HeadTitle1 = "|Sel|Seq.|EQ No.|TP/SZ|Term|Status|Yard|Material|Maker Name|Unit Model|U.Price|Sale Category|Price Verify Result|Remark";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다.
					InitHeadMode(true, true, true, true, false,false);
						 	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
					
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,     daCenter,  	false,  	"ibflag");  
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"del_chk",			false,		"",			dfNone,				0,		false,		false);		 
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  	"Seq",     			false,      "",    		dfNone     );
					InitDataProperty(0, cnt++ , dtData,			100, 	daLeft,		false,		"eq_no",			true,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,		"eq_tpsz_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"lstm_cd",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"mvmt_cd",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"disp_yd_cd",		false,		"",			dfNone,			0,		false,		false);
								
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,		"mtrl_nm",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,		"mkr_nm",			false,		"",			dfNone,			0,		false,		false);  
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,		"mdl_nm",			false,		"",			dfNone,			0,		false,		false);    
					   
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		"disp_ut_prc",		true,		"",			dfFloat,		2,		false,		false);		
					InitDataProperty(0, cnt++ , dtCombo,		150,	daLeft,		false,		"disp_rsn_cd",		false,		"",			dfNone,			0,		false,		false);		
					InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		false,		"dsp_vrfy_tp_cd",	false,		"",			dfNone,			0,		false,		false);		
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"mnr_disp_dtl_rmk",	false,		"",			dfNone,			0,		false,		false);	
					//키값 히든용   	   
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"disp_ut_tp_cd",    false,      "",     	dfNone,    		0,      true,       true);	 	
					InitDataProperty(0, cnt++ , dtHidden,		0,		daRight,	false,		"disp_qty",		 	true,		"",			dfInteger,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daRight,	false,		"trf_ut_prc",		true,		"",			dfFloat,		0,		true,		true);
					 			  		 				
					CountPosition = 0;    
										 	
					//데이터 Validation 
					InitDataValid(0,  "eq_no", vtEngUpOther,"0123456789");  
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
 	
					var HeadTitle1 = "|Sel|Seq.|TP/SZ|Q'ty|Location|U.Pirce|Remark(s)";
						
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);  
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다. 
					InitHeadMode(true, true, true, true, false,false);
								
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 
 						
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                	InitDataProperty(0, cnt++,  dtHiddenStatus,	 0,     daCenter,  	false,  	"ibflag");  
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		"del_chk",			false,		"",			dfNone,				0,		false,		false);				 
                    InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,  	"Seq",     			false,      "",    		dfNone     );
					InitDataProperty(0, cnt++ , dtCombo,		60, 	daCenter,	false,		"eq_tpsz_cd",		true,		"",			dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		"disp_qty",		 	true,		"",			dfInteger,			0,		false,		false);
					//location 은 야드에 저장   
					InitDataProperty(0,	cnt++,	dtPopupEdit,	80,		daCenter,	false,		"disp_yd_cd",		true,		"",			dfNone,				0,		false,		false );  
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		"disp_ut_prc",		true,		"",			dfFloat,			2,		false,		false);		
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"mnr_disp_dtl_rmk",	false,		"",			dfNone,				0,		false,		false);		
					//키값 히든용 	  
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   	"disp_ut_tp_cd",    false,      "",     	dfNone,    			0,     false,       false);
					  		 								 
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

	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	}  
		
	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	*/
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
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
	
	function t1_sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj = document.form;   
		if (sheetObj.ColSaveName(Col) == "eq_no"){
			var checkEqn = sheetObj.CellValue(Row,Col);
			var checkEqType = formObj.eq_knd_cd.Code; 
			var dispNo = formObj.disp_no.value;   
			var retArray = MnrGeneralCodeCheck(sheetObjects[0],"DSPEQN",checkEqn + "," + checkEqType + ","+ dispNo);
			    
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
				sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "";   
				sheetObj.CellValue2(Row,"trf_ut_prc") = "";   
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
					sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "";     
					sheetObj.CellValue2(Row,"trf_ut_prc") = "";      
					sheetObj.SelectCell(Row,Col);  		
				} else  {  
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
					if(sheetObj.CellValue(Row,"trf_ut_prc") == "0"){
						sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "NT"; 	
					} else {  
						var trfUtPrc = parseFloat(sheetObj.CellValue(Row,"trf_ut_prc")); 
						var dispUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_ut_prc"));
							 	 
						//Disposal Tariff 보다 높거나 같으면 'Success'로 표현 바랍니다.	
						if(dispUtPrc <= trfUtPrc){ 
							sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "SS";				
						} else {  
							sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "UP";
						}   	
					} 
				//Damage	
				} else {
					sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "DA"; 			
				} 			
			}     
			reSetQtyAndPrice(); 
		} else if(sheetObj.ColSaveName(Col) == "disp_rsn_cd"){  
			//EQ Number가 있으면 
			if(sheetObj.CellValue(Row,"eq_no") != ""){
				//NOT Damage 
				if(sheetObj.CellValue(Row,"disp_rsn_cd") == "C"){
					if(sheetObj.CellValue(Row,"trf_ut_prc") == "0"){
						sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "NT"; 	
					} else {  
						var trfUtPrc = parseFloat(sheetObj.CellValue(Row,"trf_ut_prc")); 
						var dispUtPrc = parseFloat(sheetObj.CellValue(Row,"disp_ut_prc"));
							 
						//Disposal Tariff 보다 높거나 같으면 'Success'로 표현 바랍니다.	
						if(dispUtPrc <= trfUtPrc){ 
							sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "SS";				
						} else {  
							sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "UP";
						}  	
					} 
				//Damage	
				} else {
					sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "DA"; 			
				}	
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
				return;	 		   
			} 		    			
		} else if(sheetObj.ColSaveName(Col) == "disp_ut_prc"){ 
			reSetQtyAndPrice();  	
		} else if(sheetObj.ColSaveName(Col) == "disp_qty"){ 
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
		
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
				 
			case IBROWSEARCH:      //건당 상세 조회     
                 if(validateForm(sheetObj,formObj,sAction)){ 
					 	formObj.f_cmd.value = SEARCH01;         
					    sParam = FormQueryString(formObj);      
					    var sXml = sheetObj.GetSaveXml("EES_MNR_0159GS.do", sParam);//EES_MNR_0159GS
					   	var arrXml = sXml.split("|$$|");       
						for(var i = 0; i < arrXml.length - 1; i++){  
							sheetObjects[i + 2].LoadSearchXml(arrXml[i]);
							sheetObjects[5].LoadSearchXml(arrXml[3]);
							
						} 
										
						if(sheetObjects[3].RowCount > 0){
							tabObjects[0].SelectedIndex = 0; 		
						} else {		
							tabObjects[0].SelectedIndex = 1;  
						} 
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
			           	 		   
				uploadFileSeq = "";    
				selCheck = false;   
				actionType = "";  
				  
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
					new Array("MnrOfcGenInfo","","DISP"),
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
					new Array("MnrGenCd","CD00080", "COMMON")   //dsp_vrfy_tp_cd
				)  	 			
																	  		 	  
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
				//IN_DISP_TP_CD,DISP_TP_CD 세팅	 
				if(comboList[0] != null){	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.disp_tp_cd.InsertItem(j , tempText[1] ,tempText[0]);
					}						     	    
				}						     
				formObj.disp_tp_cd.Code = formObj.temp1.value;     
						  
				//CURRENCY 세팅          
				if(comboList[1] != null){       
					for(var j = 0; j < comboList[1].length;j++){  
						var tempText = comboList[1][j].split("|");   
						formObj.curr_cd.InsertItem(j,tempText[0] ,tempText[0]);
					}		     
				}   	   		  
				formObj.curr_cd.Code = formObj.temp4.value; ;		
					
				//DISP_STS_CD 세팅          
				if(comboList[2] != null){       
					for(var j = 0; j < comboList[2].length;j++){  
						var tempText = comboList[2][j].split("|");   
						formObj.disp_sts_cd.InsertItem(j,tempText[1] ,tempText[0]);
					} 		  
				} 				   		 
				formObj.disp_sts_cd.Code = formObj.temp3.value; ; 	 	  
						
				//EQ_KND_CD 세팅
				if(comboList[3] != null){ 	       
					for(var j = 0; j < comboList[3].length;j++){ 
						var tempText = comboList[3][j].split("|");  
						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}			    			    
				}					     	 	  	 
				formObj.eq_knd_cd.Code = formObj.temp2.value; ;	
					    
				//************ POP UP용  ****************//
				formObj.disp_tp_cd.enable = false; 
				formObj.curr_cd.enable = false;   
				formObj.disp_sts_cd.enable = false;   
				formObj.eq_knd_cd.enable = false; 	
				//************ POP UP용  ****************//
				   
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
				comboSaveNames[7] = "dsp_vrfy_tp_cd";     
				   
				for(var i = 5; i < comboList.length;i++){
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
								sheetComboDefault[i - 5] = tempText[0];           	
							}											  
						} 	  			    		
						    	  
						sheetComboCode 		= 	 MnrDelLastDelim(sheetComboCode); 																				
				     	sheetComboText 		= 	 MnrDelLastDelim(sheetComboText);  
				        //sheetComboCodeText 	= 	 MnrDelLastDelim(sheetComboCodeText); 
						   
						if(comboSaveNames[i - 5] == "disp_tp_cd"){        		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);	
						} else if(comboSaveNames[i - 5] == "eq_knd_cd"){   		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);	
						} else if(comboSaveNames[i - 5] == "curr_cd"){    		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 5], sheetComboCode, sheetComboCode ,sheetComboDefault[i - 5]);	
						} else if(comboSaveNames[i - 5] == "disp_sts_cd"){  		
							sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);	
						} else if(comboSaveNames[i - 5] == "mnr_prnr_knd_cd"){ 	
							sheetObjects[2].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);	
						} else if(comboSaveNames[i - 5] == "disp_rsn_cd"){	
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);
						} else if(comboSaveNames[i - 5] == "mkr_nm"){	
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);
						} else if(comboSaveNames[i - 5] == "dsp_vrfy_tp_cd"){	
							sheetObjects[3].InitDataCombo (0, comboSaveNames[i - 5], sheetComboText, sheetComboCode ,sheetComboDefault[i - 5]);
						}       
					}	      
				}	
											
				var toDay = ComGetNowInfo("ymd");
													  
				//초기값 설정 
				formObj.disp_eml_flg_temp.checked = false;    
				MnrFormSetReadOnly(formObj,false,"disp_st_dt|disp_end_dt|disp_bultn_dt|disp_pkup_st_dt|disp_pkup_end_dt"); 
				//쉬트 콤보 세팅 						  						
				sheetObj.WaitImageVisible=true; 	
				isNowInit = false;   
				MnrWaitControl(false);  	 	
				break;						
        }				
    }

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){            	        
	    	switch(sAction) {  	
				//상세조회    
				case IBROWSEARCH:  
					if(MnrNullToBlank(disp_no.value) == "" || MnrNullToBlank(disp_no.value) == "NEW"){
						ComShowCodeMessage("MNR00248","Disposal ");  
						return false;  	 
					}	
					break; 	  	
			}		 
		}	
        return true; 
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
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt  
		if(retArr != null){ 
			//MVMT_CD가 XX면     
			if(retArr[0][13] == 'XX'){  
				ComShowCodeMessage("MNR00305");  
				sheetObj.CellValue2(Row,"eq_no") = "";
				sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; 	  
				sheetObj.CellValue2(Row,"lstm_cd") = "";  		
				sheetObj.CellValue2(Row,"mvmt_cd") = "";  	
				sheetObj.CellValue2(Row,"disp_yd_cd") = "";  
				sheetObj.CellValue2(Row,"mtrl_nm") = "";  
				sheetObj.CellValue2(Row,"mkr_nm") = ""; 
				sheetObj.CellValue2(Row,"mdl_nm") = ""; 
				sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "";   
				sheetObj.CellValue2(Row,"trf_ut_prc") = "0"; 
				sheetObj.SelectCell(Row,"eq_no");     
				return;     
			}    
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
			    
			//BIDDING && TPSZ가 R로 시작하는경우만 edit 가능    
			var checkTpsz = MnrNullToBlank(sheetObj.CellValue(Row,"eq_tpsz_cd"));
			if(checkTpsz != '' && checkTpsz.substring(0,1) == 'R' && formObj.disp_tp_cd.Code == "B"){
				sheetObj.CellEditable(Row, "mkr_nm") = true;  	
				sheetObj.CellEditable(Row, "mdl_nm") = true;   	
			}  else {        
				sheetObj.CellEditable(Row, "mkr_nm") = false;  	
				sheetObj.CellEditable(Row, "mdl_nm") = false;   	
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
			sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "";   
			sheetObj.CellValue2(Row,"trf_ut_prc") = "0"; 
			return;   
		}			    	
														        
		//unit price 가져오기					  
		var price = MnrGetDISPEQUnitPrice(sheetObjects[0],formObj.curr_cd.Code,sheetObj.CellValue(Row,"eq_tpsz_cd"),sheetObj.CellValue(Row,"disp_yd_cd"),formObj.rqst_dt.value);
		if(MnrNullToBlank(price) == "0"){	  		  
			sheetObj.CellValue2(Row,"disp_ut_prc") = "0.00";   
			//Not Found Tariff 
			sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "NT";   
			sheetObj.CellValue2(Row,"trf_ut_prc") = "0";    
		}  else {		 	 	  
			sheetObj.CellValue2(Row,"disp_ut_prc") = price;  	
			sheetObj.CellValue2(Row,"dsp_vrfy_tp_cd") = "SS"; 
			sheetObj.CellValue2(Row,"trf_ut_prc") = price;   
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
						CellValue2(Row,"lstm_cd") = aryPopupData[i][11];           	 
						CellValue2(Row,"mvmt_cd") = aryPopupData[i][12];            	 
						CellValue2(Row,"disp_yd_cd") = aryPopupData[i][10];	 
						CellValue2(Row,"mtrl_nm") = aryPopupData[i][6];	 
						CellValue2(Row,"mkr_nm") = aryPopupData[i][7];	 
						CellValue2(Row,"mdl_nm") = aryPopupData[i][8];  	  
						CellValue2(Row,"disp_ut_prc") = aryPopupData[i][16]; 
						tempRowCnt++;    	 
					}   				 	
				}
			}	
		}
	} 
		
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){ 
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
		var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml);  
		//0 imm_ext|1 mvmt_dt|2 dv_cur|3 rpr_yd|4 sp_name|5 flg_rmk|6 manu_dt|7 pagerows|8 dv_value|9 ibflag|10 off_hire|11 mvmt_cd|12 dsp_flag|13 hngr_flg_yd|14 lessor_nm|15 hngr_rck_cd|16 crnt_yd_cd|17 lstm_cd|18 eq_no|19 hngr_flg_dt|20 bar_atch_knt|21 status|22 bar_tp_cd|23 dmg_flag|24 cost|25 eq_type|26 rpr_type|27 eq_tpsz_cd|28 rpr_dt						
		if(retArr != null){    
			//TpSz	 
			sheetObj.CellValue2(Row,"eq_tpsz_cd") = retArr[0][31];  
			//Term 	   
			sheetObj.CellValue2(Row,"lstm_cd") = retArr[0][19];  
			//mvmt_cd 
			sheetObj.CellValue2(Row,"mvmt_cd") = retArr[0][13];  
			//current Yard      
			sheetObj.CellValue2(Row,"disp_yd_cd") = retArr[0][18];  
		} else {   	  
			sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; 	  
			sheetObj.CellValue2(Row,"lstm_cd") = ""; 		
			sheetObj.CellValue2(Row,"mvmt_cd") = "";  	
			sheetObj.CellValue2(Row,"disp_yd_cd") = ""; 
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
	
/* 개발자 작업  끝 */