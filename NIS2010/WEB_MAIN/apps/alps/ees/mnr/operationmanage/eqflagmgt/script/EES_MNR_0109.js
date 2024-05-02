/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0109.js
*@FileTitle : Hanger Rack/Bar Installation/Uninstallation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.07.20 함형석
* 1.0 Creation	
* 
* History
* 2013.11.27 이혜민   CHM-201327727-01 Hanger Bar Installation/Removal Manual 입력 시마다 Remark 항시 자동으로 생성되도록 수정
=========================================================*/
/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
				
	/** 
	 * @extends 
	 * @class EES_MNR_0109 : EES_MNR_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0109() {
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
/* ********* General Functions ************* */	
	// 공통전역변수
	var tabObjects = new Array();
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;    
	
	var comboValue = "";  
			
	//TS타입일 경우 타입사이즈 배열  eq_type 별 3가지 모두 틀림 
	var uTpSz = new Array();    
	var gTpSz = new Array();  
	var zTpSz = new Array();  
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheet2 = sheetObjects[0];
		var sheet1 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			
            switch(srcName) {	
				case "btn_retrieve":
					doActionIBSheet(sheet1,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheet2,formObject,IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheet1, formObject, IBSAVE);
					break;
		        case "btns_popup":                 
                    ComOpenPopup('/hanjin/COM_ENS_061.do', 766, 450, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;    							
		        case "btns_req_multy2":           
                    rep_Multiful_inquiry("eq_no");         
                    break;	     
		        case "btns_req_multy":           
                    rep_Multiful_inquiry("eq_tpsz_cd");      
					break;
				case "btn_t1LoadExcel":
					doActionIBSheet(sheet1, formObject, IBLOADEXCEL);
					break;					
				case "btn_downexcel":
					doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
					break;
		        case "eq_no_multi":           
                    rep_Multiful_inquiry("eq_list");	        
                    break;
				case "btns_search":	//Form Location. 조회 팝업
					if(formObject.p_loc_tp.Code != "ALL"){		
						openPopup("1");							
					}	
 					break;
				case IBDOWNEXCEL:
				    sheet1.SpeedDown2Excel(-1);
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
		MnrWaitControl(true);
		initControl(); 
						   
		initSheet(sheetObjects[0],"sheet2");		   
		ComConfigSheet (sheetObjects[1]);
		initSheet(sheetObjects[1],"sheet1");
		ComEndConfigSheet(sheetObjects[1]);
				   
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1); 
	    }	

		//타입사이즈는 처음 한번만 가져온다.
		setTpSzArray(sheetObjects[0]);	
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);		
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
	 * 멀티 콤보형식 초기화 
	 * @return
	 */
	function initCombo(comboObj, comboNo) {
		var formObject = document.form
		switch(comboNo) {
			case 3:	 
			    with (comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("130");  
					DropHeight = 200;
					ValidChar(2,3);   
			    } 			   
	        	break;
	    }
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetType) {
		var cnt = 0;
		switch(sheetType) {
		case "sheet1":      		// sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 380;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
																			
				var HeadTitle1 = "|Seq.|EQ No.|TP/SZ|MVMT|Yard|Flag|Hanger Rack\nType|Tariff Type|Tariff\nDesc|Hanger Bar\nType|Installation\nBar Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Remark(s)|Recently Worked\nInfomation|Inventory apply\nOffice";
				var HeadTitle2 = "|Seq.|EQ No.|TP/SZ|MVMT|Yard|Flag|Hanger Rack\nType|Tariff Type|Tariff\nDesc|Hanger Bar\nType|Installation\nBar Qty|Sound|Repairable|Missing|disposal|Remark(s)|Recently Worked\nInfomation|Inventory apply\nOffice";
																																									
				var headCount = ComCountHeadTitle(HeadTitle1) + 6;
																										
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 10, 100);	
									
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true); 
									
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]dtSeq
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
												
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,     40,	    daCenter,	 false,	"ibflag");
				InitDataProperty(0, cnt++ , dtSeq,              30,     daCenter,    true,  "Seq"); 
				InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	 true,	"eq_no",						false,	"",		dfNone,			2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				50,	    daCenter,	 true,	"eq_tpsz_cd",					false,	"",		dfNone,			2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	 true,	"mvmt_cd",						false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	 true,	"mnr_hngr_flg_yd_cd",			false,	"",		dfNone,	    	2,			false,		false);
				InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,	 true,	"mnr_hngr_flg",					false,	"",		dfNone,	        2,			true,		true);
				InitDataProperty(0, cnt++ , dtCombo,			160,	daLeft,	 	 true,	"mnr_hngr_rck_cd",				false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,			140,	daLeft,	     true,	"mnr_hngr_trf_cd",				false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				130,	daLeft,	   	 true,	"mnr_hngr_trf_otr_desc",		false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,			100,	daLeft,	     true,	"mnr_hngr_bar_tp_cd",			false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				100,	daRight,	 true,	"hngr_bar_atch_knt",			false,	"",		dfInteger,		2,			false,		false, 6);
				InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"act_invt_qty",					false,	"",		dfInteger,	    2,			false,		false, 6);
				InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"mnr_hngr_dmg_qty",				false,	"",		dfInteger,	    2,			false,		false, 6);
				InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"mnr_lost_hngr_qty",			false,	"",		dfInteger,	    2,			false,		false, 6);
				InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"mnr_disp_hngr_qty",			false,	"",		dfInteger,	    2,			false,		false, 6);
				InitDataProperty(0, cnt++ , dtData,				100,	daLeft,	     true,	"mnr_sts_rmk",					false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				110,	daLeft,	     true,	"wo_no",						false,	"",		dfNone,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				80,		daLeft,	     true,	"cre_ofc_cd",					false,	"",		dfNone,	        2,			false,		false);
								
				//Hidden Col 
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"eq_knd_cd",					false,	"",		dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"mnr_ord_ofc_cty_cd",			false,	"",		dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"mnr_ord_seq",					false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"ofc_cd",						false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"mnr_sts_flg",					false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"copy_row_num",					false,	"",		dfNone,			0,  		false,		false);
																																																								
				PopupImage  =  "/hanjin/img/btns_search.gif";	 	 
				ShowButtonImage = 2;		 	 
									
				SelectionMode   = smSelectionRow;
				SelectHighLight = true;            
				SelectFontBold  = false;          
				SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
				
				CountPosition = 2;
			}
			break;	
					
		case "sheet2": 	
            with (sheetObj) {
				// 높이 설정
				style.height = 0;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;	
																			
				InitRowInfo(2, 1, 10, 100);	
				InitColumnInfo(12, 0, 0, false); 			
				InitHeadMode(false, false, false, false, false,false);
				InitHeadRow(0, "", false , true);						   	
					
				InitDataProperty(0, cnt++ , dtHiddenStatus,     40,	    daCenter,	 false,	"ibflag");																			
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"recent_hngr_bar_atch_knt",	    	false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,    false,	"mnr_sts_flg",	        		false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_hngr_rck_cd",			false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_hngr_bar_tp_cd",		false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_hngr_trf_cd",			false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_hngr_trf_otr_desc",		false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_act_invt_qty",			false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_hngr_dmg_qty",			false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_lost_hngr_qty",		false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_disp_hngr_qty",		false,	"",		dfNone,			0,  		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"tmp_mnr_sts_rmk",			false,	"",		dfNone,			0,  		false,		false);		
			}  	
			break;	
		}
	}
	
	/**
     * Sheet 관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
		case IBCLEAR:        //초기화
			MnrWaitControl(true);
		    sheetObj.WaitImageVisible = false;
			
			//쉬트 초기화   
			for(i = 0;i < sheetObjects.length;i++){  	 
				sheetObjects[i].RemoveAll();    
	        } 
			
			//콤보 초기화	  
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].Code = "-1"; 
				comboObjects[i].RemoveAll();	 	       
			}	 
							
			//콤보 값 세팅			
			var sCondition = new Array (		 		 
				//MULTICOMBO  
				new Array("MnrGenCd","CD00061", "COMMON"),   //Location By
				new Array("MnrGenCd","","CUSTOM9"),		     //EQ_TYPE
				new Array("MnrGenCd","CD00093", "COMMON"),   //Search Bound Type	
				//MULTICOMBO  + SHEETCOMBO 
				new Array("MnrGenCd","CD00092", "COMMON"),   //Tariff Type
				new Array("MnrGenCd","CD00021", "COMMON"),   //Hanger Rack Type 
				new Array("MnrGenCd","CD00022", "COMMON"),   //Hanger Bar Type
				new Array("MnrGenCd","CD00023", "COMMON")    //Amend Type	
			)						 			
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
															
			//*** Location By		
			var comboDefValue = ""; 	
			if(comboList[0] != null){ 
				formObj.p_loc_tp.InsertItem(0, 'ALL' ,'ALL'); 	       
				for(var j = 1; j < comboList[0].length + 1;j++){	 
					var tempText = comboList[0][j - 1].split("|");  
					formObj.p_loc_tp.InsertItem(j, tempText[1] ,tempText[0]);
				}     			  	    
			}  		
			formObj.p_loc_tp.Code = "ALL";
											
			//*** EQ_TYPE			
			if(comboList[1] != null){		
				for(var j = 0; j < comboList[1].length;j++){	  	 
					var tempText = comboList[1][j].split("|"); 	  
					formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}						    
			}	 		
			formObj.eq_knd_cd.Code = 'U';
			
			//*** Search Bound Type	
			if(comboList[2] != null){ 
				formObj.bound_tp_cd.InsertItem(0, 'ALL' ,'ALL'); 	       
				for(var j = 1; j < comboList[2].length + 1;j++){
					var tempText = comboList[2][j - 1].split("|");  
					formObj.bound_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}	     			  	    
			} 	 			
			formObj.bound_tp_cd.Code = "ALL";
			
			//*** Tariff Type	
			if(comboList[3] != null){ 
				formObj.mnr_hngr_trf_cd.InsertItem(0, 'ALL' ,'ALL'); 	       
				for(var j = 1; j < comboList[3].length + 1;j++){
					var tempText = comboList[3][j - 1].split("|"); 
					formObj.mnr_hngr_trf_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}     			  	    
			}  		
			formObj.mnr_hngr_trf_cd.Code = "ALL";
					
			//*** Hanger Rack Type	
			if(comboList[4] != null){ 
				formObj.mnr_hngr_rck_cd.InsertItem(0, 'ALL' ,'ALL'); 	       
				for(var j = 1; j < comboList[4].length + 1;j++){
					var tempText = comboList[4][j - 1].split("|");  
					formObj.mnr_hngr_rck_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}	     			  	    
			} 	 		
			formObj.mnr_hngr_rck_cd.Code = "ALL";	
			
			//*** Hanger Bar Type	
			if(comboList[5] != null){ 
				formObj.mnr_hngr_bar_tp_cd.InsertItem(0, 'ALL' ,'ALL'); 	       
				for(var j = 1; j < comboList[5].length + 1;j++){
					var tempText = comboList[5][j - 1].split("|");  
					formObj.mnr_hngr_bar_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}		     			  	    
			}	 		
			formObj.mnr_hngr_bar_tp_cd.Code = "ALL";	
										
			var sheetComboText = "";  
			var sheetComboCode = "";
			var sheetComboDefault = new Array();
			var comboSaveNames = new Array(); 
			comboSaveNames[0] = "mnr_hngr_trf_cd";	
			comboSaveNames[1] = "mnr_hngr_rck_cd";
			comboSaveNames[2] = "mnr_hngr_bar_tp_cd";	 	
				      
			for(var i = 3; i < comboList.length;i++){ 
			 	if(comboList[i] != null){ 
					sheetComboText = ""; 
					sheetComboCode = "";	
					sheetComboDefault = ""; 
			 		for(var j = 0; j < comboList[i].length;j++){
						var tempText = comboList[i][j].split("|");    
						if(comboSaveNames[i - 3] == "mnr_hngr_rck_cd" && tempText[0] == "A"){
							sheetComboDefault[i - 3] = "R";
							continue;
						}	
												 
						sheetComboText +=  tempText[1] + "|";  
						sheetComboCode +=  tempText[0] + "|";  
						if(j == 0){	
							sheetComboDefault[i - 3] = tempText[0];          	
						}
					}						
					sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
			     	sheetComboText = 	MnrDelLastDelim(sheetComboText); 
												
					sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]); 
				}				      
			}
			//폼 기본값 세팅 
			formObj.eq_list.value="";
			
			sheetObj.WaitImageVisible = true;
			MnrWaitControl(false); 
            break;

		case IBSEARCH:      //조회  
			if(validateForm(sheetObj,formObj,sAction)){
				var formObj = document.form;
				formObj.mnr_flg_tp_cd.value = coMnrFlgHangerTypeCd;
				formObj.f_cmd.value = SEARCH; 
											
				sheetObj.Redraw = false;	
				sheetObj.DoSearch4Post("EES_MNR_0109GS.do",FormQueryString(formObj));	
				sheetObj.Redraw = true;			
			}			
			break;

		case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)){
			   	formObj.mnr_flg_tp_cd.value = coMnrFlgHangerTypeCd;
				formObj.f_cmd.value = MULTI;	   
									
				var sParam = sheetObj.GetSaveString(false, false);	
				sParam = ComSetPrifix(sParam,"sheet1_");
					
				//ComDebug(sParam);				  	 	 	 	 	  
				//멘덴토리 체크				
		    	if(sParam == "" && sheetObj.IsDataModified){
					return;	
				}
				
				if(!sheetObj.IsDataModified){
					return;	
				}			
										
				sParam += "&" + FormQueryString(formObj);		
				var sXml = sheetObj.GetSaveXml("EES_MNR_0109GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				
			}	
			break;

		//Load Excel
		case IBLOADEXCEL:
			if(validateForm(sheetObj,formObj,sAction)) {				
			    ComOpenPopup('/hanjin/EES_MNR_0255.do', 1020, 650, 'setEES_MNR_255', '1,0,1,1,1,1,1,1,1,1,1,1', false);
				searchType = 1;
			}   
			break;			
			
		case IBDOWNEXCEL:
		    sheetObj.SpeedDown2Excel(-1);   
			break;	
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){	
		if(sAction==IBSAVE) {			
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				if(sheetObj.RowStatus(i)=="U"){
					if(sheetObjects[1].CellValue(i,  "mnr_hngr_rck_cd") == ""){
						ComShowCodeMessage("MNR00003","Hanger Rack Type");
						sheetObj.SelectCell(i, "mnr_hngr_rck_cd",true);
						return false;			
					}	
						
					if(sheetObjects[1].CellValue(i,  "mnr_hngr_bar_tp_cd") == ""){
						ComShowCodeMessage("MNR00003","Hanger Bar Type");
						sheetObj.SelectCell(i, "mnr_hngr_bar_tp_cd",true);
						return false;	
					}	
					
					if(sheetObjects[1].CellValue(i,  "mnr_hngr_trf_cd") == ""){
						ComShowCodeMessage("MNR00003","Mnr_Hngr_Trf_Cd");	
						sheetObj.SelectCell(i, "mnr_hngr_trf_cd",true);		
						return false;	
					}	
					
					if (sheetObj.CellValue(i,"mnr_hngr_flg") =="0") {	//제거인 경우에만 체크
						//install qty 체크
						var hngrBarAtchKnt = parseInt(sheetObj.CellValue(i,"hngr_bar_atch_knt")); 
						var actInvtQty = parseInt(sheetObj.CellValue(i,"act_invt_qty"));
						var mnrHngrDmgQty = parseInt(sheetObj.CellValue(i,"mnr_hngr_dmg_qty"));
						var mnrLostHngrQty = parseInt(sheetObj.CellValue(i,"mnr_lost_hngr_qty"));
						var mnrDispHngrQty = parseInt(sheetObj.CellValue(i,"mnr_disp_hngr_qty"));	
												
						if(hngrBarAtchKnt != (actInvtQty + mnrHngrDmgQty + mnrLostHngrQty + mnrDispHngrQty)){
							ComShowCodeMessage("MNR00356");					
							sheetObj.SelectCell(i, "act_invt_qty",true);			 
							return false;	
						}	
					} else {	
						if (sheetObj.CellValue(i,"hngr_bar_atch_knt") == "0") {
							ComShowCodeMessage("MNR00359");					
							sheetObj.SelectCell(i, "hngr_bar_atch_knt",true);				 
							return false;
						}			
					}	
				}
			}		
			return true;		
		} else if(sAction==IBSEARCH) {	
			if(formObj.eq_list.value == ""){	
				if(formObj.p_loc_cd.value == "" || formObj.eq_tpsz_cd.Code == ""){
					ComShowCodeMessage("MNR00360");		
					return false;
				}
			}	
			return true;
		}			
		//Load Excel
		else if (sAction==IBLOADEXCEL) {
			//Tariff상태값 체크
			if(!checkTariffStatus()) {return false;}
			return true;
		}					
	}

	/**
	 * Tariff 상태값을 체크하여 확정인 경우 false를 
	 * 그외의 경우는 true를 리턴한다.
	 * @return  {Boolean}    true/false
	 */
	function checkTariffStatus() {	//alert("checkTariffStatus");
/*		var mnrTrfStsCd = document.form.mnr_trf_sts_cd.value; //mnr_trf_sts_cd
		if(mnrTrfStsCd=="HA"){
			ComShowCodeMessage("MNR00190","Tariff");
			return false;
		}*/
		return true;
	}    
    	
	/********** Event Functions Start ************* */	
	/**  
	 * eq_knd_cd 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function eq_knd_cd_OnChange(comboObj,Index_Code, Text){ 
		var formObj = document.form; 
		var comboValue = comboObj.Code; 		   
			 			
		formObj.eq_tpsz_cd.RemoveAll();
		
		var selTpSz = new Array();
				
		formObj.eq_tpsz_cd.Enable = true;
			
		if(comboValue == "U"){		
			selTpSz = uTpSz;  	
		} else if(comboValue == "G"){
			selTpSz = gTpSz; 
		} else {
			selTpSz = zTpSz;	   
		}     	
		//디폴트로 올삽입		  
		//formObj.eq_tpsz_cd.InsertItem(0,"ALL","ALL");  		
		for(var i = 0;i < (selTpSz.length);i++){	           
			formObj.eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i],"^"," - ") , selTpSz[i]); 			
		}			
	} 	
	
	/**  
	 * p_loc_tp 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text
	 */  
	function p_loc_tp_OnChange(comboObj,Index_Code, Text){ 
		var formObj = document.form;		 
				 			
		formObj.p_loc_cd.value = "";	
		if(Text == "ALL") {		
			MnrFormSetReadOnly(formObj,true,"p_loc_cd");
		} else {	
			MnrFormSetReadOnly(formObj,false,"p_loc_cd");
			ComSetFocus(formObj.p_loc_cd);			 			
		}		
	} 
		
	//eq_tpsz_cd 멀티콤보 클릭 이벤트
	function eq_tpsz_cd_OnCheckClick(comboObj, index, code) { 
		//MnrAllChkMultiCombo(comboObj,index);  		  
	} 
	
	/**  
	 * eq_tpsz_cd 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function combo_eq_tpsz_cd_OnChange(comboObj,Index_Code, Text){
		formObj = document.form;  
		formObj.eq_tpsz_cd.value = comboObj.Code;      			 
	} 
			
	function sheet1_OnBeforeEdit(sheetObj,Row,Col) {
		if(sheetObjects[1].CellValue(Row, "copy_row_num") == ""){
			var CopyRow = sheetObjects[0].DataInsert(-1);		 	
			sheetObjects[1].CellValue2(Row, "copy_row_num")	= CopyRow;  //Copy Row	 
			//데이타 카피						
			sheetObjects[0].CellValue2(CopyRow, "recent_hngr_bar_atch_knt")	= sheetObjects[1].CellValue(Row,  "hngr_bar_atch_knt");
			sheetObjects[0].CellValue2(CopyRow, "mnr_sts_flg")				= sheetObjects[1].CellValue(Row,  "mnr_hngr_flg");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_rck_cd") 		= sheetObjects[1].CellValue(Row,  "mnr_hngr_rck_cd");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_bar_tp_cd") 	= sheetObjects[1].CellValue(Row,  "mnr_hngr_bar_tp_cd");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_trf_cd") 		= sheetObjects[1].CellValue(Row,  "mnr_hngr_trf_cd");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_trf_otr_desc")= sheetObjects[1].CellValue(Row,  "mnr_hngr_trf_otr_desc");
			sheetObjects[0].CellValue2(CopyRow, "tmp_act_invt_qty") 		= sheetObjects[1].CellValue(Row,  "act_invt_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_dmg_qty") 	= sheetObjects[1].CellValue(Row,  "mnr_hngr_dmg_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_lost_hngr_qty") 	= sheetObjects[1].CellValue(Row,  "mnr_lost_hngr_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_disp_hngr_qty") 	= sheetObjects[1].CellValue(Row,  "mnr_disp_hngr_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_sts_rmk") 			= sheetObjects[1].CellValue(Row,  "mnr_sts_rmk");     						
		}	
	}	
			
	function sheet1_OnBeforeCheck(sheetObj,Row,Col) {	
		if(sheetObjects[1].CellValue(Row, "copy_row_num") == ""){
			var CopyRow = sheetObjects[0].DataInsert(-1);		 	
			sheetObjects[1].CellValue2(Row, "copy_row_num")	= CopyRow;  //Copy Row	 
			//데이타 카피						
			sheetObjects[0].CellValue2(CopyRow, "recent_hngr_bar_atch_knt")	= sheetObjects[1].CellValue(Row,  "hngr_bar_atch_knt");
			sheetObjects[0].CellValue2(CopyRow, "mnr_sts_flg")				= sheetObjects[1].CellValue(Row,  "mnr_hngr_flg");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_rck_cd") 		= sheetObjects[1].CellValue(Row,  "mnr_hngr_rck_cd");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_bar_tp_cd") 	= sheetObjects[1].CellValue(Row,  "mnr_hngr_bar_tp_cd");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_trf_cd") 		= sheetObjects[1].CellValue(Row,  "mnr_hngr_trf_cd");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_trf_otr_desc")= sheetObjects[1].CellValue(Row,  "mnr_hngr_trf_otr_desc");
			sheetObjects[0].CellValue2(CopyRow, "tmp_act_invt_qty") 		= sheetObjects[1].CellValue(Row,  "act_invt_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_hngr_dmg_qty") 	= sheetObjects[1].CellValue(Row,  "mnr_hngr_dmg_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_lost_hngr_qty") 	= sheetObjects[1].CellValue(Row,  "mnr_lost_hngr_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_disp_hngr_qty") 	= sheetObjects[1].CellValue(Row,  "mnr_disp_hngr_qty");
			sheetObjects[0].CellValue2(CopyRow, "tmp_mnr_sts_rmk") 			= sheetObjects[1].CellValue(Row,  "mnr_sts_rmk");     						
		}	
	}	
					
   /**
    * sheet1에서 클릭이벤트를 처리한다.	
    * @param sheetObj	
    * @param Row
    * @param Col
    * @param Value	
    * @return  		
    */	
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		//카피용 시트  조회시 화면죽음 ...
		var copysheetObj = sheetObjects[0];   
		//카피한 키 		
		var copyRow = sheetObj.CellValue(Row,"copy_row_num");
		
		if (sheetObj.ColSaveName(Col) == "mnr_hngr_flg"){
			//설치 제거 액션 발생시 일단 오피스는 초기화
			sheetObj.CellValue2(Row,  "cre_ofc_cd") = currOfcCd;
			
			//flag 체크한경우 => 설치 
			if(Value == "1"){				
				//원래 설치 였는데 다시 원복한 경우					  	
				if(copysheetObj.CellValue(copyRow,  "mnr_sts_flg") == "1"){
					//조회 했던 상태로 모두 원복			
					sheetObj.CellValue2(Row,  "mnr_hngr_rck_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_bar_tp_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_bar_tp_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_trf_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_otr_desc") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_trf_otr_desc");																			
					sheetObj.CellValue2(Row,  "hngr_bar_atch_knt") = copysheetObj.CellValue(copyRow,  "recent_hngr_bar_atch_knt");		
					sheetObj.CellValue2(Row,  "act_invt_qty") = copysheetObj.CellValue(copyRow,  "tmp_act_invt_qty");	
					sheetObj.CellValue2(Row,  "mnr_hngr_dmg_qty") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_dmg_qty");
					sheetObj.CellValue2(Row,  "mnr_lost_hngr_qty") = copysheetObj.CellValue(copyRow,  "tmp_mnr_lost_hngr_qty");
					sheetObj.CellValue2(Row,  "mnr_disp_hngr_qty") = copysheetObj.CellValue(copyRow,  "tmp_mnr_disp_hngr_qty");
					sheetObj.CellValue2(Row,  "mnr_sts_rmk") = copysheetObj.CellValue(copyRow,  "tmp_mnr_sts_rmk");		
					
					if(copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd") == "O"){
						sheetObj.CellEditable(Row, "mnr_hngr_rck_cd") = 	false;
						sheetObj.CellEditable(Row, "mnr_hngr_bar_tp_cd") = 	false;
					} else {
						sheetObj.CellEditable(Row, "mnr_hngr_rck_cd") = 	true;
						sheetObj.CellEditable(Row, "mnr_hngr_bar_tp_cd") = 	true;
					}
					sheetObj.CellEditable(Row, "mnr_hngr_trf_cd") = 	true;
					if(copysheetObj.CellValue(copyRow,  "mnr_hngr_trf_cd") == "OT"){
						sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = true;
					} else {
						sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = false;
					}
					sheetObj.CellEditable(Row, "hngr_bar_atch_knt") = 	true;	
					sheetObj.CellEditable(Row, "act_invt_qty") = false; 	
					sheetObj.CellEditable(Row, "mnr_hngr_dmg_qty") = false; 
					sheetObj.CellEditable(Row, "mnr_lost_hngr_qty") = false; 
					sheetObj.CellEditable(Row, "mnr_disp_hngr_qty") = false;
//					sheetObj.CellEditable(Row, "mnr_sts_rmk") = true;		
					sheetObj.RowStatus(Row) = "R";						
				//진자 설치 하는 케이스
				} else {	
					if(copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd") == "O"){	
						sheetObj.CellEditable(Row, "mnr_hngr_rck_cd") = 	false;	
						sheetObj.CellEditable(Row, "mnr_hngr_bar_tp_cd") = 	false;	
					} else {		
						sheetObj.CellEditable(Row, "mnr_hngr_rck_cd") = 	true;
						sheetObj.CellEditable(Row, "mnr_hngr_bar_tp_cd") = 	true;
					}		
																			
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_cd") = "CB";
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_otr_desc") = "";								
					sheetObj.CellEditable(Row, "mnr_hngr_trf_cd") = 	true;	
					sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = false;	
							
					sheetObj.CellValue2(Row,  "hngr_bar_atch_knt") = "0";	
					sheetObj.CellValue2(Row,  "act_invt_qty") = "0";
					sheetObj.CellValue2(Row,  "mnr_hngr_dmg_qty") = "0";
					sheetObj.CellValue2(Row,  "mnr_lost_hngr_qty") = "0";
					sheetObj.CellValue2(Row,  "mnr_disp_hngr_qty") = "0";
					
					sheetObj.CellEditable(Row, "hngr_bar_atch_knt") = 	true;			
					sheetObj.CellEditable(Row, "act_invt_qty") = false; 
					sheetObj.CellEditable(Row, "mnr_hngr_dmg_qty") = false; 
					sheetObj.CellEditable(Row, "mnr_lost_hngr_qty") = false; 
					sheetObj.CellEditable(Row, "mnr_disp_hngr_qty") = false;
//					sheetObj.CellEditable(Row, "mnr_sts_rmk") = true;		
				}	 		
			//flag 체크안한경우 => 제거	
			}else if(Value == "0") {		 	  	 
				//원래 제거  였는데 다시 원복한 경우	  		
				if(copysheetObj.CellValue(copyRow,  "mnr_sts_flg") == "0"){
					//조회 했던 상태로 모두 원복			
					sheetObj.CellValue2(Row,  "mnr_hngr_rck_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_bar_tp_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_bar_tp_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_trf_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_otr_desc") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_trf_otr_desc");																			
					sheetObj.CellValue2(Row,  "hngr_bar_atch_knt") = copysheetObj.CellValue(copyRow,  "recent_hngr_bar_atch_knt");		
					sheetObj.CellValue2(Row,  "act_invt_qty") = copysheetObj.CellValue(copyRow,  "tmp_act_invt_qty");	
					sheetObj.CellValue2(Row,  "mnr_hngr_dmg_qty") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_dmg_qty");
					sheetObj.CellValue2(Row,  "mnr_lost_hngr_qty") = copysheetObj.CellValue(copyRow,  "tmp_mnr_lost_hngr_qty");
					sheetObj.CellValue2(Row,  "mnr_disp_hngr_qty") = copysheetObj.CellValue(copyRow,  "tmp_mnr_disp_hngr_qty");
					sheetObj.CellValue2(Row,  "mnr_sts_rmk") = copysheetObj.CellValue(copyRow,  "tmp_mnr_sts_rmk");
					sheetObj.CellEditable(Row, "mnr_hngr_rck_cd") 	= 	false;
					sheetObj.CellEditable(Row, "mnr_hngr_bar_tp_cd") = 	false;
					sheetObj.CellEditable(Row, "mnr_hngr_trf_cd") 	= 	false;
					sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = false;
					sheetObj.CellEditable(Row, "hngr_bar_atch_knt") = 	false;
															
					if(copysheetObj.CellValue(copyRow,  "recent_hngr_bar_atch_knt") != "0"){	
						sheetObj.CellEditable(Row, "act_invt_qty") 		= true; 		
						sheetObj.CellEditable(Row, "mnr_hngr_dmg_qty")  = true; 
						sheetObj.CellEditable(Row, "mnr_lost_hngr_qty") = true; 
						sheetObj.CellEditable(Row, "mnr_disp_hngr_qty") = true;	
//						sheetObj.CellEditable(Row, "mnr_sts_rmk") = true;		
					} else {	
						sheetObj.CellEditable(Row, "act_invt_qty") 		= false; 	
						sheetObj.CellEditable(Row, "mnr_hngr_dmg_qty")  = false; 
						sheetObj.CellEditable(Row, "mnr_lost_hngr_qty") = false; 
						sheetObj.CellEditable(Row, "mnr_disp_hngr_qty") = false;
//						sheetObj.CellEditable(Row, "mnr_sts_rmk") = false;
					}	
					sheetObj.RowStatus(Row) = "R";		
				//진자 제거 하는 경우							
				} else {
					sheetObj.CellValue2(Row,  "mnr_hngr_rck_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_bar_tp_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_bar_tp_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_trf_cd");
					sheetObj.CellValue2(Row,  "mnr_hngr_trf_otr_desc") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_trf_otr_desc");																			
					sheetObj.CellValue2(Row,  "hngr_bar_atch_knt") = copysheetObj.CellValue(copyRow,  "recent_hngr_bar_atch_knt");			
					sheetObj.CellValue2(Row,  "act_invt_qty") = "0";							
					sheetObj.CellValue2(Row,  "mnr_hngr_dmg_qty") = "0";				
					sheetObj.CellValue2(Row,  "mnr_lost_hngr_qty") = "0";				
					sheetObj.CellValue2(Row,  "mnr_disp_hngr_qty") = "0";
											
					sheetObj.CellEditable(Row, "mnr_hngr_rck_cd") = 	false;	
					sheetObj.CellEditable(Row, "mnr_hngr_bar_tp_cd") = 	false;		
					sheetObj.CellEditable(Row, "mnr_hngr_trf_cd") 	= 	false;						
					sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = false;
					sheetObj.CellEditable(Row, "hngr_bar_atch_knt") = 	false;				
					sheetObj.CellEditable(Row, "act_invt_qty") = true;					 		
					sheetObj.CellEditable(Row, "mnr_hngr_dmg_qty") = true;	 
					sheetObj.CellEditable(Row, "mnr_lost_hngr_qty") = true; 
					sheetObj.CellEditable(Row, "mnr_disp_hngr_qty") = true;		
//					sheetObj.CellEditable(Row, "mnr_sts_rmk") = true;										
				}		
			}
		} else if(sheetObj.ColSaveName(Col) == "mnr_hngr_rck_cd"){
			if(sheetObj.CellValue(Row,  "mnr_hngr_rck_cd") == "O" && copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd") != "O"){
				ComShowCodeMessage("MNR00331");									
				sheetObj.CellValue2(Row,  "mnr_hngr_rck_cd") = copysheetObj.CellValue(copyRow,  "tmp_mnr_hngr_rck_cd");
			}	
		} else if(sheetObj.ColSaveName(Col) == "mnr_hngr_trf_cd"){			
			if(Value == "OT"){		
				sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = true;
			} else {
				sheetObj.CellEditable(Row, "mnr_hngr_trf_otr_desc") = false;	
				sheetObj.CellValue2(Row,"mnr_hngr_trf_otr_desc") = "";	
			}		
		} else if(sheetObj.ColSaveName(Col) == "hngr_bar_atch_knt" || sheetObj.ColSaveName(Col) == "act_invt_qty"
				|| sheetObj.ColSaveName(Col) == "mnr_hngr_dmg_qty" || sheetObj.ColSaveName(Col) == "mnr_lost_hngr_qty"
				|| sheetObj.ColSaveName(Col) == "mnr_disp_hngr_qty"	|| sheetObj.ColSaveName(Col) == "mnr_hngr_bar_tp_cd"){
										
				if(copysheetObj.CellValue(copyRow,  "mnr_sts_flg") ==  sheetObj.CellValue(Row,  "mnr_hngr_flg")){	
					sheetObj.CellValue2(Row,"cre_ofc_cd") = sheetObj.CellValue(Row,"ofc_cd");
				}			
		}	
	}
		
	/**
	 * 저장후 결과메세지 표시
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	//저장  버튼 클릭시 발생시킬 메세지 
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {			 	            
          ComShowCodeMessage("MNR00023",ErrMsg);
		  
		  doActionIBSheet(sheetObj,document.form,IBSEARCH);	
					 
      	} else {  
          ComShowCodeMessage("MNR00008",ErrMsg);            	
		}   
	}	
	
	/* ********* User Functions Start ************* */
	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getMnr_Multi(rowArray,ret_val) {
alert("rowArray - "+rowArray); alert("ret_val - "+ret_val);		
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
	 * EQ Type별 tp/sz 콤보 셋팅문자열 생성
     * @param	{IBSheet}	sheetObj
	 */  
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
     * Pop-up Open 부분<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;	
				
    	if ( type == "1" ) {	
    		switch(formObj.p_loc_tp.Code) {	
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;	
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;	
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;	
    			default : 	//do nothing
    		}
    	} 
    	return;
    }
		
	/* ********* User Functions End ************* */	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {       
		//Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
		axon_event.addListenerForm  ('blur',     	'obj_deactivate', 	formObject); 	//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    	'obj_activate',		formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',	'obj_keypress', 	formObject);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 	'obj_change',		formObject); 	//- 변경될때.
		axon_event.addListener('change',	 		'obj_change1',		'ord_hdr_rmk');	//- 변경될때.
	}             
	
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
	function obj_deactivate(){      
		ComChkObjValid(event.srcElement); 
	} 

	/**
     * HTML Control의 onfocus이벤트에서 Validation을 체크한다. <br>
     **/
	function obj_activate(){   
		ComClearSeparator(event.srcElement);
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
				//do nothing  		   
			}       
	    } 
	}  
	
	//Axon 이벤트 처리. keypress이벤트처리함수   	        
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
	         	if(obj.name == "eq_list"){  
					ComKeyOnlyAlphabet('uppernum','44'); 
				} else {				   
					ComKeyOnlyAlphabet('uppernum');	
				}    
	            break; 
	    }         
	}
	
	/**
	 * load excel 팝업에서 저장처리 후, 호출
	 */
	function setAterLoadExcel(){
		// Retrieve
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
	
/* 개발자 작업  끝 */