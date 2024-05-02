/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0170.js
*@FileTitle : Reefer Unit Warranty Period
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05 
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.05 박명신 
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
     * @class EES_MNR_0170 : EES_MNR_0170 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0170() { 
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

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;


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
						doActionIBSheet(sheetObject1,document.form,IBSEARCH); 
					break;
					
					case "btn_new": 
						doActionIBSheet(sheetObject1,document.form,IBCLEAR); 
					break;
					
					case "btn_save": 
						doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;  
					       
					case "btn_RowDel":    
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;      
					
					case "btn_RowAdd":      
						doActionIBSheet(sheetObject1, formObject, IBINSERT);   
					break;      
					  	
					case "btn_downexcel":
						sheetObject1.SpeedDown2Excel(-1);        
					break;  
							 		 
					case "dpc_yr_cal1": 
						var cal = new ComCalendar(); 
						cal.setDisplayType('year');
						cal.select(formObject.fm_lot_pln_yr, 'yyyy');
					break;	   
									
					case "dpc_yr_cal2": 
						var cal = new ComCalendar(); 
						cal.setDisplayType('year');
						cal.select(formObject.to_lot_pln_yr, 'yyyy');
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true); 
		initControl();     
        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);

            ComEndConfigSheet(sheetObjects[i]);
        }   
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
                    // 높이 설정
                    style.height = 422;
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
					    
					var HeadTitle1 = "|Sel.|Seq.|Range|Range|Range|Range|TP/SZ|Maker|Unit Model|MFG|Q'ty|Warranty Period|Warranty Period|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);   

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 2, 0, 0, true);       
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);        
 					 	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);   
   					     	
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 		30,    	daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,       		40,    	daCenter,  	false,   	"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,					40,		daCenter,	true,		"S"); 	          
					InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,		"lot_eq_pfx_cd",			true,	"",		dfNone,				0,			false,		true,	4,true);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		"fm_ser_no",				true,	"",		dfNone,				0,			false,		true,	6,true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		true,		"ser_frefix",				false,	"",		dfNone,				0,			false,		false);  
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		"to_ser_no",				true,	"",		dfNone,				0,			false,		true,	6,true);       
					InitDataProperty(0, cnt++ , dtCombo,				50,		daCenter,	true,		"eq_tpsz_cd",				true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,				100,	daLeft,		true,		"eq_mkr_nm",				true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					200,	daLeft,		true,		"eq_mdl_nm",				true,	"",		dfNone,				0,			true,		true, 200);
					          	   
					InitDataProperty(0, cnt++ , dtData,					55,		daCenter,	true,		"mft_yr",					true,	"",		dfNone,				0,			true,		true,   4,  true);
					InitDataProperty(0, cnt++ , dtHidden,					60,		daRight,	true,		"eq_qty",					false,	"|to_ser_no| * 10  - |fm_ser_no| * 10 + 1",		dfNullInteger,		0,			false,		false,		6,		false,		true,		"",		true,		"IUD",		true);  
					InitDataProperty(0, cnt++ , dtPopupEditFormat,		100,	daCenter,	true,		"fm_warr_dt",				true,	"",		dfDateYmd,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtPopupEditFormat,		100,	daCenter,	true,		"to_warr_dt",				true,	"",		dfDateYmd,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					80,		daLeft,		true,		"warr_rmk",					false,	"",		dfNone,				0,			true,		true, 4000);
					                
					InitDataProperty(0, cnt++ , dtHidden,				80,		daLeft,		true,		"eq_knd_cd",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,				80,		daLeft,		true,		"mnr_grp_tp_cd",			false,	"",		dfNone,				0,			true,		true);
				                           	           
					InitDataValid(0,  "fm_ser_no", vtNumericOnly);        		   
					InitDataValid(0,  "to_ser_no", vtNumericOnly);         		   
					InitDataValid(0,  "mft_yr", vtNumericOnly);             		   
					InitDataValid(0,  "lot_eq_pfx_cd", vtEngUpOnly);                    		   
                 	InitDataValid(0,  "eq_mdl_nm", vtEngUpOther,"0123456789!@#$%^&*()_+-=\][}{:;/.,?><~\"\'");             
					PopupImage  =  "/hanjin/img/btns_calendar.gif";
            		ShowButtonImage = 2;              
					                           
					MultiSelection = false;
					//SELECT 로우 배경색         
					SelectionMode = smSelectionRow;   
					SelectHighLight = true;           
					SelectFontBold = false;            
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);    
					CountPosition =  0;         	 
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
							formObj.f_cmd.value = SEARCH;    
							sheetObj.DoSearch4Post("EES_MNR_0170GS.do", FormQueryString(formObj));
						}    
					break; 
 					
					case IBSAVE:        //저장
          				if(validateForm(sheetObj,formObj,sAction)){
							//저장의사 확인  
							if(ComShowCodeConfirm("MNR00160","")){
								formObj.f_cmd.value = MULTI;                   
								sheetObj.DoSave("EES_MNR_0170GS.do", FormQueryString(formObj),-1,false);
							}  
						}      
					break;   	
					     
					case IBCLEAR:      // 입력
						MnrWaitControl(true);
                    	sheetObj.WaitImageVisible = false;
						formObj.reset();   
						sheetObj.RemoveAll();       
						//공통함수에 적정한 타입을 찾을수 없어 직접 작성 
						var sDate = new Date();    
						formObj.fm_lot_pln_yr.value  = 	sDate.getYear() - 10;       
						formObj.to_lot_pln_yr.value  = 	sDate.getYear(); 
						  
						//쉬트 콤보데이타 조회	
						var sCondition = new Array ( 
						 	new Array("MnrGenCd","CD00009", "COMMON"),
							new Array("EqTpSz","U","COMMON")
						)                    
						           
						//쉬트 콤보데이타에 값을 세팅함   				 			
						var sheetComboText = "";  
						var sheetComboCode = ""; 
						//var sheetComboCodeText = "";	 
						var sheetComboDefault = new Array();  
						 
						//쉬트 콤보 SAVE_NAME				
						var comboSaveNames = new Array(); 	 
						comboSaveNames[0] = "eq_mkr_nm";    
						comboSaveNames[1] = "eq_tpsz_cd";    
								      
						var sheetComboList = MnrComSearchCombo(sheetObj,sCondition); 
							
						for(var i = 0; i < sheetComboList.length;i++){
						 	if(sheetComboList[i] != null){	
								//쉬트콤보별 초기화
								sheetComboText = "";
								sheetComboCode = "";
								//sheetComboCodeText = "";	
												   
						 		for(var j = 0; j < sheetComboList[i].length;j++){	 
									var tempText = sheetComboList[i][j].split("|");       
										 
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									//sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
									if(j == 0){       
										sheetComboDefault[i] = tempText[0];         	
									}  									  
								}			    		
							        	  	  																			
					   	     	sheetComboText = MnrDelLastDelim(sheetComboText);   
						        sheetComboCode = MnrDelLastDelim(sheetComboCode);
						        //sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText); 
											
								if(comboSaveNames[i] == "eq_mkr_nm"){	
									sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault[i]);					
								} else {
									sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboCode, sheetComboCode ,sheetComboDefault[i]);	
								}
							}  	    
						}	          
						sheetObj.WaitImageVisible = true;
                    	MnrWaitControl(false);		 
						break;	
					 	
					case IBDELETE:      //삭제 
						if(sheetObj.FindCheckedRow("del_chk") != ""){
							ComRowHideDelete(sheetObj,"del_chk");   	
						} else {
							ComShowCodeMessage("MNR00150");        
						} 	  
					break;   
						     
					case IBINSERT:      // 입력      
						var sDate = new Date();      
						var Row = sheetObj.DataInsert(-1);    
						         
						sheetObj.CellValue2(Row, "lot_eq_pfx_cd") = "SMCU";
						sheetObj.CellValue2(Row, "ser_frefix") = "-";       
						sheetObj.CellValue2(Row, "mft_yr") = sDate.getYear();              
						sheetObj.CellValue2(Row, "eq_knd_cd") = "U";          
						sheetObj.CellValue2(Row, "mnr_grp_tp_cd") = "RPR";              
					break;     
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) {       
				if (!ComChkValid(formObj)) return false;        
			}   else if(sAction==IBSAVE){    
				//변경할 건수가 있는경우   
				if(sheetObj.IsDataModified == false){
					return false;	
				} 
				for(var i = 1; i <= sheetObj.RowCount; i++){
					if(sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U"){
						//둘다 입력된 경우는 fm_warr_dt 보다 to_warr_dt가 커야 된다.
						if(sheetObj.CellValue(i, "fm_warr_dt") != "" && sheetObj.CellValue(i, "to_warr_dt") != ""){
							if(sheetObj.CellValue(i, "fm_warr_dt") > sheetObj.CellValue(i, "to_warr_dt")){
								ComShowCodeMessage("MNR00166");
								sheetObj.SelectCell(i, "fm_warr_dt");      
								return false;        
							}	 	
						}  
						     	
				 		//둘다 입력된 경우는 fm_ser_no 보다 to_ser_no가 커야 된다.
						if(sheetObj.CellValue(i, "fm_ser_no") != "" && sheetObj.CellValue(i, "to_ser_no") != ""){
							if(sheetObj.CellValue(i, "fm_ser_no") > sheetObj.CellValue(i, "to_ser_no")){  
								ComShowCodeMessage("MNR00173");    
								sheetObj.SelectCell(i, "fm_ser_no");              
								return false;        
							}	    	 
						}      	 
						           
						if(sheetObj.CellValue(i, "eq_qty").replace(/,/g,"") > 999999){    
							ComShowCodeMessage("MNR00166");       	
							sheetObj.SelectCell(i, "to_ser_no");                          
							return false;        	               		
						}      
				   }
				     
					//데이타 중복체크       
			   		var Row = sheetObj.ColValueDup("lot_eq_pfx_cd|fm_ser_no|to_ser_no");
					if(Row > 0){             
						ComShowCodeMessage("MNR00006"," sheet of "  + Row + " row "); 
						sheetObj.SelectCell(Row, "fm_ser_no", true);       
						return false;          
					} 	
			   }   
			}   
        }    
        return true;
    }   
     
	function sheet1_OnKeyDown(sheetObj,Row,Col,KeyCode,Shift){
		if(KeyCode == 9){   
			if(Col == 4){   
				sheetObj.SelectCell(Row,Col + 1);  	 	  
			} 
		}
	}
	        
	//저장후 결과메세지 표시  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {  
			ComShowCodeMessage("MNR00023",'');   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
	} 
	 
	function sheet1_OnPopupClick(sheetObj, row,col){
        if (!(sheetObj.ColSaveName(col) == "fm_warr_dt" || sheetObj.ColSaveName(col) == "to_warr_dt")) return;
        var cal = new ComCalendarGrid();             
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');        
    }  
	 
	function initControl() {   
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	}                 
		   
	//Axon 이벤트 처리2. 이벤트처리함수  
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement);  		 
	}   
	 
	function obj_activate(){         
	    ComClearSeparator(event.srcElement);
	}      
	     
	function obj_keypress(){    
	    obj = event.srcElement;  
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	        
	    switch(obj.dataformat) { 
	       	case "yyyy":             
	         	ComKeyOnlyNumber(obj); 
	            break;     
	    }       
	} 
/* 개발자 작업  끝 */