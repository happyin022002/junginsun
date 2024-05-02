/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0192.js 
*@FileTitle : Repair Estimate Creation Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.01 박명신  
* 1.0 Creation  
* -------------------------------------------------------
* History
* 2011.06.28 김종옥 [CHM-201111809-01] ALPS MNR-> Repair-Estimate Creation 시, Verify 후, Verify Result결과에 대하여 Point 주는 기능 요청
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
     * @class EES_MNR_0192 : EES_MNR_0192 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */ 
    function EES_MNR_0192() {
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

var combo1;

//조회여부 (조회후 삭제 가능)
var selCheck = false;

//콤포턴트 코드를 위한   
var retCompArray = new Array();

//파일업로드를 사용하기 위한 
var uploadObjects = new Array();
var uploadCnt = 0;
	
//파일Seq저장변수 (추가될때 )
var uploadFileSeq = "";	   

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
				case "btn_close":      
                    self.close();   
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
					doActionIBSheet(sheetObjects[1],formObject,IBSAVE); 	
					break; 
					
				case "btn_Request":	 	  
					doActionIBSheet(sheetObjects[1],formObject,IBCREATE);  	
					break;	   
				
				case "btn_RowDel": 	 
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);  
					break;
					
				case "btn_RowAdd":	  
					doActionIBSheet(sheetObjects[1],formObject,IBINSERT);    
					break;   
					
				case "btn_DownExcel":  
					sheetObjects[1].SpeedDown2Excel(-1);   
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
		initControl();    
		  
		//0번은 히든 데이타 조회용
		initSheet(sheetObjects[0],1);      	
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
		        
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 	 
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);       
		doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);   
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
						InsertTab( cnt++ , "Repair Info." , -1 );
						InsertTab( cnt++ , "Image Info." , -1 );
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
        switch(sheetObj.id) {      
        	case "sheet1": 
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				} 	  
				break;     
				   
			case "t1sheet1":      // sheet1 init
                with (sheetObj) {
					// 높이 설정 
					//style.height = 180; 
                	style.height = 260;
					// 전체 너비 설정 
					SheetWidth = mainTable.clientWidth;
							
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;	
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false; 
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 100);
								
					var HeadTitle1 = "|Sel|Seq.|Mandatory Code|Mandatory Code|Mandatory Code|Mandatory Code|Option|Volume|Volume|Volume|Labor|Labor|Labor|Material|Amount|Amount(USD)|Verify Result|Tariff Labor|Tariff Labor|Tariff Labor|Tariff\nMaterial|Tariff\nAmount|Lessor Account|TPB Request|TPB Labor|TPB Labor|TPB Labor|TPB Material|TPB Amount";
					var HeadTitle2 = "|Sel|Seq.|Location|Component|Damage|Repair|Division|Type|QTY|Size/Square|Hour|Rate|Cost|Material|Amount|Amount(USD)|Verify Result|Hour|Rate|Cost|Tariff\nMaterial|Tariff\nAmount|Lessor Account|TPB Request|Hour|Rate|Cost|TPB Material|TPB Amount";
										
					var headCount = ComCountHeadTitle(HeadTitle1);									
						
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount + 7, 0, 0, true); 
												
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) 
					 						
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);	
					InitHeadRow(1, HeadTitle2, true);	  
													
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	"ibflag");	
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,		true,	"del_chk");		
					InitDataProperty(0, cnt++ , dtDataSeq,	 	30,		daCenter,		true,	"Seq");			
					InitDataProperty(0,	cnt++,	dtPopupEdit,	80,		daCenter,		true,	"eq_loc_cd",				true,	"",	dfNone,		0,	true,	true ,4 ,true );  
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,		true,	"eq_cmpo_cd",				true,	"",	dfNone,			0,	true,	true,	3,	true);
	                InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,		true,	"eq_dmg_cd",				true,	"",	dfNone,		0,	true,	true,	2,	true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,	"eq_rpr_cd",				true,	"",	dfNone,			0,	true,	true,	2,	true);
	                InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,		true,	"trf_div_cd",				false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,  		50,		daLeft,			true,	"vol_tp_cd",				true,	"",	dfNone, 		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,  		40,		daRight,		true,	"rpr_qty",					false,	"",	dfNullInteger, 	0,	true,	true,	6,	false);
	                InitDataProperty(0, cnt++ , dtData,  		85, 	daRight,		true,	"rpr_sz_no",				false,	"",	dfNullInteger, 	0,	true,	true,	10,	false);
										
					InitDataProperty(0, cnt++ , dtAutoSum,  	50,		daRight,		true,	"rpr_lbr_hrs",				false,	"",	dfNullFloat, 		2,	true,	true,	6,	false); 
					InitDataProperty(0,	cnt++,	dtData,			50,		daRight,		true,	"rpr_lbr_rt",				false,	"",	dfNullFloat,		2,	true,	true, 	7,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"lbr_cost_amt",				false,	"Round(|rpr_lbr_hrs|*|rpr_lbr_rt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		70,		daRight,		true,	"mtrl_cost_amt",			false,	"",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		60,		daRight,		true,	"mnr_wrk_amt",				false,	"Round(|lbr_cost_amt|+|mtrl_cost_amt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		90,		daRight,		true,	"mnr_wrk_usd_amt",			false,	"",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtCombo,		140,	daLeft,			true,	"mnr_vrfy_tp_cd",			false,	"",	dfNone,			0,	false,	false); 																
					 														
					//basic 데이타 저장용	  
					//타리프 hour basic
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"rpr_lbr_bzc_hrs",			false,	"",	dfNullFloat,		2,	false,	false);
					//어그리먼트 rate basic
					InitDataProperty(0,	cnt++,	dtData,			50,		daRight,		true,	"rpr_lbr_bzc_rt",			false,	"",	dfNullFloat,		2,	false,	false);
					//둘이 곱한거 basic
					InitDataProperty(0,	cnt++,	dtAutoSum,  	50,		daRight,		true,	"mnr_lbr_bzc_amt",			false,	"Round(|rpr_lbr_bzc_hrs|*|rpr_lbr_bzc_rt|,2)",				dfNullFloat,		2,	false,	false, 	13,	false);
					//타리프 material basic
					InitDataProperty(0,	cnt++,	dtAutoSum,		70,		daRight,		true,	"lbr_mtrl_bzc_amt",			false,	"",	dfNullFloat,		2,	false,	false);
					//전체 더한거 basic				
					InitDataProperty(0,	cnt++,	dtAutoSum,		60,		daRight,		true,	"mnr_agmt_amt",				false,	"Round(|mnr_lbr_bzc_amt|+|lbr_mtrl_bzc_amt|,2)",			dfNullFloat,		2,	true,	true, 	13,	false);
						
					InitDataProperty(0,	cnt++,	dtCheckBox,		110,	daCenter,		true,	"mnr_lr_acct_flg",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtCheckBox,		90,		daCenter,		true,	"n3pty_flg",				false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"n3pty_bil_lbr_hrs",		false,	"",	dfNullFloat,		2,	true,	true,	6,	false); 
					InitDataProperty(0,	cnt++,	dtData,			50,		daRight,		true,	"n3pty_bil_lbr_rt",			false,	"",	dfNullFloat,		2,	true,	true, 	7,	false);	
					InitDataProperty(0,	cnt++,	dtAutoSum,		50,		daRight,		true,	"n3pty_lbr_cost_amt",		false,	"Round(|n3pty_bil_lbr_hrs|*|n3pty_bil_lbr_rt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		80,		daRight,		true,	"n3pty_bil_mtrl_cost_amt",	false,	"",	dfNullFloat,		2,	true,	true, 	13,	false);
					InitDataProperty(0,	cnt++,	dtAutoSum,		80,		daRight,		true,	"n3pty_bil_amt",			false,	"Round(|n3pty_lbr_cost_amt|+|n3pty_bil_mtrl_cost_amt|,2)",	dfNullFloat,		2,	true,	true, 	13,	false);
					 							 																																			
					//data verify 용	 
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_loc_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_cmpo_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_dmg_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"eq_rpr_cd_chk_flg",		false,	"",	dfNone,		0,	true,	true);
					
					//어그리먼트 조회용			 
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"cost_cd",					false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"cost_dtl_cd",				false,	"",	dfNone,		0,	true,	true);
							  																																					
					//Desc. 용 	
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daRight,		true,	"rpr_dtl_rmk",				false,	"",	dfNone,		0,	true,	true);
							  																																					
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
                    Editable = false;

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
                    Editable = false;

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
					var widthVals = new Array(20,20,20,20);
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
						RowHeight(i + 1) = widthVals[i];
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
                    Editable = false;

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
								
						style.height = 260;			 
						// 전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						  		
						//전체Edit 허용 여부 [선택, Default false]
						Editable = false;  	 
						   	
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 10, 100);
						     	 
						var HeadTitle1 = "|Photo Attachment|Photo Attachment|Photo Attachment";
						var HeadTitle2 = "|Seq|File|Download";
						 			
						var headCount = ComCountHeadTitle(HeadTitle1);									
							
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(8, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true); 
						InitHeadRow(1, HeadTitle2, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 prefix +	"ibflag");
						InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 prefix +	"del_chk")
						InitDataProperty(0, cnt++ , dtPopup,      	180,    daCenter,  false,   prefix + "org_file_nm",     	true,           "",      dfNone,      0,     false,		true,	50);
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
        }
    }
	
	// Sheet관련 프로세스 처리	
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false; 
        switch(sAction) {  
			case IBROWSEARCH:      //건당 상세 조회    
                 if(validateForm(sheetObj,formObj,sAction)){ 
				 		//EQ 디테일 정보 표시 
						setEqInfo(sheetObj,formObj.eq_knd_cd.value,formObj.rqst_eq_no.value,ComGetNowInfo("ymd"));	 		
											
						//조회시작 
					 	formObj.f_cmd.value = SEARCH01; 	         
																											          
					    sParam = FormQueryString(formObj); 	     
					    var sXml = sheetObj.GetSaveXml("EES_MNR_0192GS.do", sParam); 
												    	
					    sheetObjects[1].LoadSearchXml(sXml);	    
						sheetObjects[1].SumText(0,"eq_loc_cd") = "TOTAL";
								
						//상단 폼값 채움  
						ComSetObjValue(formObj.rpr_rqst_seq, ComGetEtcData(sXml, "rpr_rqst_seq"));  	 
						ComSetObjValue(formObj.rpr_rqst_ver_no, ComGetEtcData(sXml, "rpr_rqst_ver_no"));  	 
						ComSetObjValue(formObj.rpr_sts_cd, ComGetEtcData(sXml, "rpr_sts_cd"));  	 
						ComSetObjValue(formObj.rqst_ref_no, ComGetEtcData(sXml, "rqst_ref_no"));  	 
						ComSetObjValue(formObj.rpr_yd_cd, ComGetEtcData(sXml, "rpr_yd_cd"));  	 
						ComSetObjValue(formObj.eq_dmg_dt, ComGetEtcData(sXml, "eq_dmg_dt"));  	 
						ComSetObjValue(formObj.rqst_usr_nm, ComGetEtcData(sXml, "rqst_usr_nm"));   	 
						ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml, "rqst_usr_id"));   	 
						ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml, "rqst_dt"));    	 
						ComSetObjValue(formObj.mnr_rpr_rmk, ComGetEtcData(sXml, "mnr_rpr_rmk"));        	 
						
						//************** 2010-05-19 추가 *******************/
						ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));	 			       	 
						ComSetObjValue(formObj.cost_ofc_cd, ComGetEtcData(sXml, "cost_ofc_cd"));        	 
						//Service Provider Name을 조회
						if(formObj.vndr_seq.value != "" && Number(formObj.vndr_seq.value)){
							var sCondition = new Array (  
								new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
							)                  	           
							//조회 값이 있다면 세팅		
							var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
							if(comboList[0] != null){	 	 
								var tempText = comboList[0][0].split("|");  
								formObj.vndr_nm.value  = tempText[1];   
							}					 								
						}		
						//************** 2010-05-19 추가 *******************/
			          		     												
						formObj.rpr_wrk_tp_cd.Code = ComGetEtcData(sXml, "rpr_wrk_tp_cd");       	 
						if(ComGetEtcData(sXml, "rpr_offh_flg") == 'Y'){	  
							formObj.rpr_offh_flg.value = 'Y';   	
							formObj.rpr_offh_flg_temp.checked = true; 	
						} else {		
							formObj.rpr_offh_flg.value = 'N';
							formObj.rpr_offh_flg_temp.checked = false; 
						}
						 		
						//파일 리스트 조회  
						var fileSeq = ComGetEtcData(sXml, "file_seq");   
						if(fileSeq != "" && fileSeq != null){  
							var fileXml = SearchFileUpload(sheetObjects[2],fileSeq);
							if(!MnrIsEmptyXml(fileXml)){        
								sheetObjects[9].LoadSearchXml(fileXml);	
							} 	
						}	 	 
				  }		  		      
                break;  		
			 											
			 case IBCLEAR:      //초기화	 
			 	ComBtnDisable("btn_calc"); 
			 	ComBtnDisable("btn_RowAdd"); 
			 	ComBtnDisable("btn_RowDel");  
			 		
			    //NOTICE 용 추가 	(3개월 6개월)
				var recentRprTpCd = ComGetObjValue(formObj.recent_rpr_tp_cd);
				if(recentRprTpCd == '3'){
					ComSetObjValue(formObj.notice,ComGetMsg("MNR00258"));
				} else if(recentRprTpCd == '6'){
					ComSetObjValue(formObj.notice,ComGetMsg("MNR00259"));
				} else {
					ComSetObjValue(formObj.notice,"");
				}
										
				uploadFileSeq = "";  
							    
				//폼 초기화       
				setEqInfoClear();
				//차후에 하나씩 개별로   
				MnrFormSetReadOnly(formObj,true,"rqst_eq_no|rqst_ref_no|rpr_yd_cd|eq_dmg_dt"); 
						 				
				//쉬트 초기화			 	  	
				sheetObjects[1].RemoveAll();     
				sheetObjects[1].SumText(0,"eq_loc_cd") = "TOTAL"; 		
					
				//콤보 초기화 	 		
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].Code = "-1";	
					comboObjects[i].RemoveAll();	 	       
				} 	
												 
				formObj.rpr_wrk_tp_cd.enable = false;	 
				
				//콤보데이타에 값을 세팅함	
				sCondition = new Array (		  
					//Multil Combo
					new Array("MnrGenCd","CD00018", "COMMON"),
					//Sheet  Combo 
					new Array("MnrGenCd","CD00013", "COMMON"),	//Type	
					new Array("MnrGenCd","CD00004", "COMMON")	//Error code	
				)	 		  	           	
																							
				comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
							
				//Repair Work Type Code	
				if(comboList[0] != null){ 	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.rpr_wrk_tp_cd.InsertItem(0, tempText[1] ,tempText[0]);
					}		    
				}  	
								 			
				var sheetComboText = "";   
				var sheetComboCode = ""; 	 
				var sheetComboDefault = new Array();  
					
				var comboSaveNames = new Array();	
				comboSaveNames[0] = "vol_tp_cd";  	 
				comboSaveNames[1] = "mnr_vrfy_tp_cd";	  	 
																		
				for(var i = 1; i < comboList.length;i++){ 
				 	if(comboList[i] != null){
						sheetComboText = ""; 
						sheetComboCode = "";		
								   
				 		for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");    
							 
							sheetComboText +=  tempText[1] + "|";  
							sheetComboCode +=  tempText[0] + "|";  
							if(j == 0){
								sheetComboDefault[i - 1] = tempText[0];           	
							} 		   
						}		
										
						sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
				     	sheetComboText = 	MnrDelLastDelim(sheetComboText);  	
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 1], sheetComboText, sheetComboCode ,sheetComboDefault[i - 1]); 
					}			      
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
				case IBROWSEARCH:  
					if (!ComChkValid(formObj)){
						return false;	
					} else {
						return true;  
					}   
				 	break;    
			}			 	
		}	
        return true;	
    }		
						
	//************************* EVENT SECTION ************************//
	function t1sheet1_OnLoadFinish(sheetObj) {  
			
	}		
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */ 	
	function tab1_OnChange(tabObj , nItem){ 
		if(ComGetObjValue(form.eq_knd_cd) == "U"){  
			<!-- 탭간 값연동 (S) -->
			//값이 없는 놈들은 모두 삭제한다.	    
			var tDmgLocCd = "";    	
			for(var i = 2;i < sheetObjects[1].LastRow;i++ ){
				var checkCompCd = sheetObjects[1].CellValue(i,"eq_loc_cd");
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
				ComShowCodeMessage("MNR00027",ErrMsg); 
			//REQUEST  	
			} else if(saveType == "REQUEST") {
				ComShowCodeMessage("MNR00008",ErrMsg); 		 
			//저장후 메세지	
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);   
			}				
		} 		      
	}

	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){ 
		for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow ; i++){
			
			//[CHM-201111809-01] Verify 후, Verify Result결과에 대하여 RgbColor 추가
			var mnrVrfyTpCd = sheetObj.CellValue(i,  "mnr_vrfy_tp_cd");
			var volTpCd = sheetObj.CellValue(i,  "vol_tp_cd");
			
			if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
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
	}
	
	//버티파이후 메세지 표시  	
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 		   
			for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow ; i++){
				var mnrVrfyTpCd = sheetObj.CellValue(i,  "mnr_vrfy_tp_cd");
				if(mnrVrfyTpCd=="SS" || mnrVrfyTpCd=="SL"){
					sheetObj.CellFontColor(i,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(0,0,255);
				} else {
					sheetObj.CellFontColor(i,"mnr_vrfy_tp_cd") = sheetObj.RgbColor(255,0,0);
				}
			}
			ComShowCodeMessage("MNR00334");	  	 
		} else { 
				ComShowCodeMessage("MNR00159",ErrMsg);
		}				       
	}	
							
	//************************* EVENT SECTION ************************//
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate,isYardDisplay){
		var formObj = document.form; 
		var sCostType = "";
		if(formObj.eq_knd_cd.value == "U"){
			sCostType = "MRDRRC"; 	
		} else if(formObj.eq_knd_cd.value == "G"){ 
			sCostType = "MRGSRC";		
		} else { 
			sCostType = "MRZSRC";	        	 
		}			  					   	 	
		var sXml = MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml); 
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
			//dsp_flag 
			tagObj = document.getElementById("Disposal");  
			tagObj.innerHTML = retArr[0][14];    
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
		}
	}	
		 
	
	function setEqInfoClear(){
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
	}	
				
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form;	 	
		 		        
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")       
    	 	formObj.rpr_yd_cd.value = aryPopupData[0][3];                                  
    }	
		
	//DESC 표시    
	function t1sheet1_OnClick(sheetObj,Row, Col, Value) {
		var formObj = document.form; 					
			  			
		formObj.mnr_desc.value = sheetObj.CellValue(Row ,"rpr_dtl_rmk"); 
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
				ComKeyOnlyAlphabet('uppernum');           
	            break; 
	    }         
	}
	
	/* 개발자 작업  끝 */