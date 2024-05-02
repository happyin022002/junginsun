/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0111.js
*@FileTitle : Hanger Rack/Bar History
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.08
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.07.23 함형석
* 1.0 Creation
*
* History
* 2013.11.08 이혜민 CHM-201327243-01 TYPE (Installation,Removal) 조건, Regional HQ, Office  조회 조건 추가
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
     * @class ees_mnr_0111 : ees_mnr_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */	
    function ees_mnr_0111() {
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

//Container Tp/Sz 
var uTpSz = new Array();    
 

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
				case "btn_retrieve":	
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":	
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;      
		        case "eq_no_multi":           
                    rep_Multiful_inquiry("eq_list");	        
                    break;
				case "cre_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
					break;	
				case "btns_location":	//Form Location. 조회 팝업
					if(formObject.p_loc_tp.Code != "ALL"){		
						openPopup("1");				
					}	
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
		initControl()
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		doActionIBSheet( sheetObjects[0],document.form,IBCLEAR);
		setTpSzArray(sheetObjects[0]); 

    }

    /**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form;
	    switch(comboNo) {  
	        case 1: 
	           	with (comboObj) { 
        	   		SetColAlign("left");        
			   		DropHeight = 160;  
					UseAutoComplete = true; 
		    	}	      
	        	break;	 	 
			    
			case 2:	 
			    with (comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					DropHeight = 160;
					//ValidChar(2,3);   
			    } 			   
	        	break;
					
	       case 3:	 
			   with (comboObj) { 
	   	   			SetColAlign("left");        
			   		DropHeight = 160;  
					UseAutoComplete = true;
		    	}	
	        	break; 
	       case 4:	 
			   with (comboObj) { 
	   	   			SetColAlign("left");        
			   		DropHeight = 160;  
					UseAutoComplete = true;
		    	}	
	        	break; 
	       case 5:	 
			   with (comboObj) { 
	   	   			SetColAlign("left");        
			   		DropHeight = 160;  
					UseAutoComplete = true;
		    	}	
	        	break; 
	       case 6:	 
			   with (comboObj) { 
	   	   			SetColAlign("left");        
			   		DropHeight = 160;  
					UseAutoComplete = true;
		    	}	
	        	break;  	
	       case 7:		 
			   with (comboObj) { 
	    	   		SetTitle("Office Code|Office Name");
   	   				SetColAlign("left|left"); 
   	   				DropHeight = 160; 
					UseAutoComplete = true;
		    	}				
	        	break;
	       case 8:		 
			   with (comboObj) { 
	    	   		SetTitle("Office Code|Office Name");
	    	   		SetColAlign("left|left");        
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
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
					// 높이 설정	
                    style.height = 396;
                    
					// 전체 너비 설정	
                    SheetWidth = mainTable.clientWidth;
                    
					//Host정보 설정[필수][HostIp, Port, PagePath
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                   
				   //전체Merge 종류 [선택, Default msNone]
				    MergeSheet = msHeaderOnly;
                    
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true; 	
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]		
					InitRowInfo( 2, 1, 10, 100);	
								 	
					var HeadTitle1 = "|SEQ|EQ No.|TP/SZ|MVMT|Current Yard|Type|Amend Type|Hanger Rack Type|Hanger Bar Type|Tariff Type|Tariff Desc|Current\nBar Qty|Installation\nBar Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Related W/O|Flag DT|Office|Remark";
					var HeadTitle2 = "|SEQ|EQ No.|TP/SZ|MVMT|Current Yard|Type|Amend Type|Hanger Rack Type|Hanger Bar Type|Tariff Type|Tariff Desc|Current\nBar Qty|Installation\nBar Qty|Sound|Repair|Missing|disposal|Related W/O|Flag DT|Office|Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);	
                			   
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]				
                    InitColumnInfo(headCount, 0, 0, true);					
                   
				    //해더에서 처리할 수 있는 각종 기능을 설정한다
				    InitHeadMode(true, true, true, true, false,false);
                    	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //  dtComboEdit [ROW, COL,  DATATYPE,         WIDTH,  DATAALIGN, 		COLMERGE, 	SAVENAME,  		   KEYFIELD,CALCULOGIC,DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     40,	    daCenter,	   	true,	    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,              30,     daCenter,    	true,       "Seq"); 
						
					InitDataProperty(0, cnt++ , dtData,				80,	    daLeft,	   		true,		"eq_no",				false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,	    daCenter,		true,		"eq_tpsz_cd",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	   	true,	    "mvmt_cd",				false,	"",		dfNone,	        0,			false,		false);
//					InitDataProperty(0, cnt++ , dtData,			   120,		daCenter,	   	true,	    "mnr_flg_yd_cd",		false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			   120,		daCenter,	   	true,	    "crnt_yd_cd",			false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daLeft,	   		true,	    "mnr_sts_flg",			false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			80,		daLeft,	   		true,		"mnr_flg_inp_tp_cd",	false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			120,	daLeft,	   		true,	    "mnr_hngr_rck_cd",		false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			120,	daLeft,	   		true,	    "mnr_hngr_bar_tp_cd",	false,	"",		dfNone,	    	0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			120,	daLeft,	   		true,	    "mnr_hngr_trf_cd",		false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				120,	daLeft,	   		true,	    "mnr_hngr_trf_otr_desc",false,	"",		dfNone,	        0,			false,		false);
														
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	   	true,	    "hngr_bar_ttl_qty",		false,	"",		dfInteger,	    0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	   	true,	    "hngr_bar_amd_qty",		false,	"",		dfInteger,	    0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				90,		daRight,	   	true,	    "act_invt_qty",			false,	"",		dfInteger,	    0,			false,		false);					
					InitDataProperty(0, cnt++ , dtData,				90,		daRight,	   	true,	    "mnr_hngr_dmg_qty",		false,	"",		dfInteger,	  	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	   	true,	    "mnr_lost_hngr_qty",	false,	"",		dfInteger,	    0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	   	true,	    "mnr_disp_hngr_qty",	false,	"",		dfInteger,	    0,			false,		false); 
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	   	true,	    "wo_no",				false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	   	true,	    "mnr_flg_inp_dt",		false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	   	true,	    "ofc_cd",				false,	"",		dfNone,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				200,	daLeft,	   		true,	    "mnr_flg_rmk",			false,	"",		dfNone,	        0,			false,		false);
																													
					//SELECT 로우 배경색       
					SelectionMode   = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold  = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
	
					CountPosition = 2;
			   }
         break;
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
	}
	
	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
				
            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){		
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch4Post("EES_MNR_0111GS.do",FormQueryString(formObj));	
					}  
				}	
                break;
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
					new Array("MnrGenCd","CD00023", "COMMON"),    //Amend Type
					new Array("MdmOrganization","RHQ","FALSE")  //Regional HQ
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
//				//*** EQ_TYPE			
//				if(comboList[1] != null){		
//					formObj.eq_knd_cd.InsertItem(0, 'ALL' ,'ALL');		
//					for(var j = 1; j < comboList[1].length + 1;j++){  	 
//						var tempText = comboList[1][j - 1].split("|");   
//						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
//					}						    
//				}	 		
//				formObj.eq_knd_cd.Code = 'ALL';
				
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

				//*** Regional HQ
				if(comboList[7] != null){      
					for(var j = 0; j < comboList[7].length;j++){  
				   		var tempText = comboList[7][j].split("|");  
				   		formObj.combo1.InsertItem(j,comboList[7][j] ,tempText[0]);
					}             
				 	formObj.combo1.InsertItem(0, "ALL" , "A");
					formObj.combo1.Code = "A";
				} 
				
				var sheetComboText = "";  
				var sheetComboCode = "";
				var sheetComboDefault = new Array();
										
				var comboSaveNames = new Array(); 
				comboSaveNames[0] = "mnr_hngr_trf_cd";	
				comboSaveNames[1] = "mnr_hngr_rck_cd";
				comboSaveNames[2] = "mnr_hngr_bar_tp_cd";	 	
				comboSaveNames[3] = "mnr_flg_inp_tp_cd"; 	
					      
				for(var i = 3; i < comboList.length;i++){ 
				 	if(comboList[i] != null){ 
								
						sheetComboText = ""; 
						sheetComboCode = "";	
						sheetComboDefault = ""; 
						   
				 		for(var j = 0; j < comboList[i].length;j++){	 
							var tempText = comboList[i][j].split("|");    
							 
							sheetComboText +=  tempText[1] + "|";  
							sheetComboCode +=  tempText[0] + "|";  
							if(j == 0){	
								sheetComboDefault[i - 3] = tempText[0];          	
							}
						}						
												
						sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
				     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  	
								
						sheetObjects[0].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]); 
					}				      
				}
				
					
				//폼 기본값 세팅 
				formObj.eq_list.value="";
				formObj.from_date.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1); 
				formObj.to_date.value = ComGetNowInfo();
				formObj.mnr_sts_flg.value = "A";
				setTpSzArray(sheetObjects[0]);
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false); 
                break;
								
			case IBDOWNEXCEL:
			    //sheetObj.Down2Excel(-1);   
			    sheetObj.SpeedDown2Excel(-1);   
				break;
        }
    }
	
	 /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) {
				if (!ComChkValid(formObj)) return false;
				
//				if (formObj.p_loc_cd.value == "" && formObj.eq_list.value == ""){
//					ComShowCodeMessage("MNR00215"); 
//					return false;	
//				} 	
			}
        }
		return true;
	}	
		
   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj	
    * @param errMsg
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(sheetObj.RowCount>0){
	    	 for(i=sheetObj.LastRow; i > 0 ; i--){
			 	if(sheetObj.CellValue(i,  "mnr_hngr_flg")=="1"){
					sheetObj.CellEditable(i, "mnr_hngr_rck_cd") = true;
					sheetObj.CellEditable(i, "hngr_bar_atch_knt") = true;
					sheetObj.CellEditable(i, "mnr_hngr_bar_tp_cd") = true;
					sheetObj.CellEditable(i, "mnr_hngr_flg_dt") = true;
					
					
					sheetObj.CellBackColor(i, "mnr_hngr_rck_cd") = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					sheetObj.CellBackColor(i, "hngr_bar_atch_knt") = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					sheetObj.CellBackColor(i, "mnr_hngr_bar_tp_cd") = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					sheetObj.CellBackColor(i, "mnr_hngr_flg_dt") = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
				
				
				}else{
					sheetObj.CellEditable(i, "mnr_hngr_rck_cd") = false;
					sheetObj.CellEditable(i, "hngr_bar_atch_knt") = false;
					sheetObj.CellEditable(i, "mnr_hngr_bar_tp_cd") = false;
					sheetObj.CellEditable(i, "mnr_hngr_flg_dt") = false;
					
					sheetObj.CellBackColor(i, "mnr_hngr_rck_cd") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);  
					sheetObj.CellBackColor(i, "hngr_bar_atch_knt") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);  
					sheetObj.CellBackColor(i, "mnr_hngr_bar_tp_cd") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);  
					sheetObj.CellBackColor(i, "mnr_hngr_flg_dt") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);  
				
				}
			 	if(sheetObj.CellValue(i,  "mnr_hngr_rck_cd")=="O"){
					sheetObj.CellEditable(i, "mnr_hngr_flg") = false;
					sheetObj.CellEditable(i, "mnr_hngr_rck_cd") = false;
					
					sheetObj.CellBackColor(i, "mnr_hngr_flg") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);  
					sheetObj.CellBackColor(i, "mnr_hngr_rck_cd") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);  
					
				}

				if(sheetObj.CellValue(i,  "hngr_bar_atch_knt")=="")	{
					sheetObj.CellValue2(i,  "recent_hngr_bar_atch_knt") = "0";
				}else{
					sheetObj.CellValue2(i,  "recent_hngr_bar_atch_knt") = sheetObj.CellValue(i,  "hngr_bar_atch_knt");
				}
			 sheetObj.CellValue2(i, "bar_if_chk") = 1;
			 sheetObj.CellValue2(i, "mnr_org_hngr_bar_tp_cd") = sheetObj.CellValue(i, "mnr_hngr_bar_tp_cd") ;
			 sheetObj.RowStatus(i)= "R";
	    	 }
		}	 
     }
	
   /**
    * sheet1에서 AfterEdit이벤트를 처리한다.
    * @param sheetObj	
    * @param Row	
    * @param Col
    * @return	
    */
	function sheet1_OnAfterEdit(sheetObj,Row, Col){	
		if (sheetObj.ColSaveName(Col) == "hngr_bar_atch_knt"){	
			if (sheetObj.CellValue(Row,  "hngr_bar_atch_knt")=="0"){
				ComShowCodeMessage("MNR00284");
				sheetObjects[0].CellValue2(Row,  "mnr_hngr_bar_tp_cd") = "";
			}			
		}
		if (sheetObj.ColSaveName(Col) == "mnr_hngr_rck_cd"){
			if(sheetObj.CellValue(Row,  "mnr_hngr_rck_cd")=="O"){
				ComShowCodeMessage("MNR00331");
				sheetObjects[0].CellValue2(Row,  "mnr_hngr_rck_cd") = "R";
			}	
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
	
	function setTpSzArray(sheetObj){ 
		var formObj = document.form;  
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
		if(arrXml != null){          
		    for(var i = 0; i < arrXml.length; i++){   
				if(i == 0){	       
					uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
				}		  	 
		    }
			//디폴트로 올삽입		  
			formObj.eq_tpsz_cd.InsertItem(0,"ALL","");  	
			for(var i = 1;i < uTpSz.length+1;i++){            
				formObj.eq_tpsz_cd.InsertItem(i, uTpSz[i - 1] , uTpSz[i - 1]); 	
			}
			formObj.eq_tpsz_cd.Index = 0;
		}					
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
				
	//Axon 이벤트 처리1. 이벤트catch  
	function initControl() {  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  	//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);           //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);          //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	form); 				//- 변경될때.
	}
	
	//Axon 이벤트 처리. activate이벤트처리함수   
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	} 
	
	//Axon 이벤트 처리. deactivate이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	}
		 
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
	
	function setPopUpParam_COM_ENS_071(array) {
		
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(",");
		formObj.cre_ofc_cd.value=arr[3];
		
	}
	
	   /**
	 * combo1에서 OnChange가 발생하는 경우 이벤트처리
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function comboOnChange(comboObj,Index_Code, Text){ 
		var formObj = document.form;
		formObj.combo2.removeAll();

		var sCondition = new Array (      
			new Array("MdmOrganization","SEARCH",Index_Code) 
		)                                
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 

		if(comboList[0] != null){      
			for(var j = 0; j < comboList[0].length;j++){  
		   		var tempText = comboList[0][j].split("|");  
		   		formObj.combo2.InsertItem(j,comboList[0][j] ,tempText[0]);
			}             
		 	formObj.combo2.InsertItem(0, "ALL" , "A");
			formObj.combo2.Code = "A";
		} 
	} 
	
	/**  
	 * combo1 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;       
		if(comboObj.Code=="A"){
			formObj.ar_hd_qtr_cd.value = ""; 
		}else{
			formObj.ar_hd_qtr_cd.value = comboObj.Code; 
		}
		comboOnChange(comboObj,Index_Code, Text);
	}  

	/**  
	 * combo2 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  	
	function combo2_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;     
		if(comboObj.Code=="A"){
			formObj.ofc_cd.value = ""; 
		}else{
			formObj.ofc_cd.value = comboObj.Code; 
		}
	}  
	/* 개발자 작업  끝 */