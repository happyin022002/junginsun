/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0113.js
*@FileTitle : Hanger Bar Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.01.28 박정민
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
     * @class ees_mnr_0113 : ees_mnr_0113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0113() {
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

var initLoader = 0;

var regionalHQ = "";
var nowLoad = 0;

// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)
var strMnrOfficeLevel="";

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
				case "btn_save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				case "btn_year_month":
                    var cal = new ComCalendar();
                    cal.setDisplayType('month');
                    cal.select(formObject.month, 'yyyy-MM');
                    break;
				case "check_show_all":
					showAllOffice();
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	

		MnrOfficeLevel(currOfcCd,rhqOfcCd);
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
				//MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
				//SetColWidth("100|150");
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
                    style.height = 420;
                    
                    SheetWidth = mainTable.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    MergeSheet = msHeaderOnly;
                    Editable = true;

                    var HeadTitle1 = "|LVL|H/Q Office|Office|INVT_YRMON|INTG_CD_VAL_CTNT|Bar Type|Inventory|Inventory|Delivered\nQTY|O/B\nVolume|Repo\nOut|Collected|Collected|Updated\nDate|Updated\nPIC|Remark(s)";
                    var HeadTitle2 = "|LVL|H/Q Office|Office|INVT_YRMON|INTG_CD_VAL_CTNT|Bar Type|First Month|End Month|Delivered\nQTY|O/B\nVolume|Repo\nOut|Sound / \nRepairable|Disposal|Updated\nDate|Updated\nPIC|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);		
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 10, 100);		
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 7, 0, true);									
                    InitHeadMode(true, true, true, true, false,false);
					
                    InitHeadRow(0, HeadTitle1, true);	
                    InitHeadRow(1, HeadTitle2, true);
																
                    //   dtComboEdit [ROW, COL,  DATATYPE,               WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     	40,	    daCenter,	false,	    "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,				80,	    daCenter,	true,		"lvl",					true,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					80,	    daCenter,	true,		"ar_hd_qtr_ofc_cd",		true,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,	    daCenter,	true,		"ofc_cd",				true,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				80,	    daCenter,	true,		"invt_yrmon",			true,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				80,	    daCenter,	true,		"intg_cd_val_ctnt",		true,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,	    daCenter,	true,		"intg_cd_val_dp_desc",	true,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				    90,		daRight,	true,	    "fst_mon",				false,	"",		dfInteger,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				    90,		daRight,	true,	    "lst_mon",				false,	"",		dfInteger,	        0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				    70,		daRight,	true,	    "de_hngr_qty",			false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				    70,		daRight,	true,	    "ob_hngr_qty",			false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				    70,		daRight,	true,	    "repo_out_hngr_qty",	false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				    80,		daRight,	true,	    "rpr_hngr_qty",			false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				    80,		daRight,	true,	    "disp_hngr_qty",		false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					80,	    daCenter,	true,		"upd_dt",				false,	"",		dfUserFormat2,		0,			false,		false);										
					InitDataProperty(0, cnt++ , dtData,					80,	    daCenter,	true,		"upd_usr_id",			false,	"",		dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					250,    daCenter,	true,		"invt_rmk",				false,	"",		dfNone,				0,			false,		false);

                    InitUserFormat2(0, "upd_dt", "####-##-##", "-|:" );

					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);

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

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
			formObj.ar_hd_qtr_ofc_cd.value = ""; 
		}else{
			formObj.ar_hd_qtr_ofc_cd.value = comboObj.Code; 
		}
	}
	
	
	/**  
	 * sheet1 Change 이벤트      
	 * @param  {String}    row   row
	 * @param  {String}    col   텍스트
	 * @param  {String}    value 텍스트
	 */  
	function sheet1_OnChange(sheetObj, row, col, value){
		var saveName = sheetObj.ColSaveName(col);
		
		var editableColName = "|de_hngr_qty|ob_hngr_qty|repo_out_hngr_qty|rpr_hngr_qty|disp_hngr_qty|";
		if(editableColName.indexOf(saveName) > -1){

			var value = parseInt(value);
			
			if(value < 0){	
				ComShowCodeMessage("MNR00224");		
				sheetObj.SelectCell(row, col, true);
				sheetObj.CellValue2(row, col) = "0";
				return false;  
			}	

			
			var firstMonth = parseInt(sheetObj.CellValue(row, "fst_mon"));
			var deliveredQty = parseInt(sheetObj.CellValue(row, "de_hngr_qty"));
			var collectedVolume = parseInt(sheetObj.CellValue(row, "rpr_hngr_qty")); 
			var outBoundVolume = parseInt(sheetObj.CellValue(row, "ob_hngr_qty"));
			var repoOut = parseInt(sheetObj.CellValue(row, "repo_out_hngr_qty"));
			
			// 2015.02.06 공식변경 Collected 항목중 Disposal을 넣었지만 Disposal은 제외 by 최연실과장 
			sheetObj.CellValue2(row, "lst_mon") = firstMonth + (deliveredQty + collectedVolume) - (outBoundVolume + repoOut);
		}
	}  

   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @param errMsg
    * @return
    */
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	var formObj  = document.form;
    	// 이번달 이전달 변수 "|YYYY-MM|YYYY-MM(-1)|"
    	var editableMonth = "|" + ComGetDateAdd(null, "D", "0", "-").substring(0,7) + "|" + ComGetDateAdd(null, "M", "-1", "-").substring(0,7) + "|";
    	// editableMonth 과 조회조건 비교 하여 수정 가능여부 확인
    	var isEditable = editableMonth.indexOf(formObj.month.value) > -1;
    	
    	// 본사(장비팀)는 모든 영역에서 수정가능
    	if( strMnrOfficeLevel == "L1" ){
    		isEditable = true;
    	}

    	// 2015년 이전데이터는 수정할수 없음
    	if(formObj.month.value.length > 4){
    		// 이번달
    		var toMonth = parseInt(ComGetDateAdd(null, "D", "0", "").substring(0,6));
    		// 1년전 년월
    		var beforeOneYear = parseInt(ComGetDateAdd(null, "D", "0", "").substring(0,6)) - 100;
    		// 1년전 데이터는 업데이트 할수 없음
    		var isOneYearEdit = beforeOneYear > parseInt(ComReplaceStr(formObj.month.value, "-", "")) ? false : true;

    		// 2015년 이전 또는 미래인경우 또는 1년 이전 데이터 수정불가
    		if(parseInt(formObj.month.value.substring(0,4)) < 2015 || parseInt(formObj.month.value.replace("-", "")) > toMonth || isOneYearEdit == false){
    			isEditable = false;
    		}
    	}
    	
    	var editableOffice = "";
    	var firstMonth = "";
    	var endMonth = "";
		if(sheetObjects[0].RowCount>0){
	         var checked = formObj.check_show_all.checked;
	    	 for(i=sheetObjects[0].LastRow; i > 1 ; i--){
				  sheetObj.RowStatus(i) ="R";
				  
				  // first month 값이 0 인경우 row hidden
				  firstMonth = sheetObj.CellValue(i, "fst_mon");
				  endMonth = sheetObj.CellValue(i, "lst_mon");
				  if(!checked && (firstMonth == "" || firstMonth == "0") && (endMonth == "" || endMonth == "0")){
					  sheetObj.RowHidden(i) = true;
				  }

				  // 수정가능한 상태(이번달, 이전달) 데이터인 경우
				  if(isEditable){
					  // 내 office정보와 sheet의 정보를 비교 로그인 유저가 본사인 경우 모두 수정
					  if( strMnrOfficeLevel == "L1" ){
						  sheetObj.CellEditable(i, "de_hngr_qty") = true;
						  sheetObj.CellEditable(i, "ob_hngr_qty") = true;
						  sheetObj.CellEditable(i, "repo_out_hngr_qty") = true;
						  sheetObj.CellEditable(i, "rpr_hngr_qty") = true;
						  sheetObj.CellEditable(i, "disp_hngr_qty") = true;
						  sheetObj.CellEditable(i, "invt_rmk") = true;
					  }
				  }
			 }
		}
     }

   /**
    * 저장후에 로딩메시지
    * @param sheetObj
    * @param ErrMsg
    * @return
    */   
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	  	  if (ErrMsg == "") { 
	  		  ComShowCodeMessage("MNR00023");  
			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
	  	  } else { 
	  		  ComShowCodeMessage("MNR00008",ErrMsg);  
	  	  }       
	}
	

	function sheet1_OnClick(sheetObj,Row, Col, Value){
//    	if(nowLoad == 0){
//		   	if(sheetObj.ColSaveName(Col) == "ofc_cd"){
//				if(strMnrOfficeLevel=="L1"){
//					cellSetItems(sheetObj, Row, "ofc_cd", sheetObj.CellValue(Row, "ar_hd_qtr_ofc_cd"));
//				} else if(strMnrOfficeLevel=="L2"){
//					cellSetItems(sheetObj, Row, "ofc_cd", sheetObj.CellValue(Row, "ar_hd_qtr_ofc_cd"));
//				} else if(strMnrOfficeLevel=="L3"){
//					sheetObj.CellValue2(Row, "ofc_cd") = currOfcCd;
//				}
//			}
//    	}
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
		        		sheetObj.DoSearch4Post("EES_MNR_0113GS.do",FormQueryString(formObj));	
					}  
				}	
                break;
			case IBCLEAR:        //초기화
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				if(initLoader == 0){
	
					//콤보 초기화 
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();       
					}   

				    regionalHQ = "";
					
					//공통콤보 정보를 가져온다.  
					var sCondition = new Array (
						new Array("MdmOrganization","RHQ","ASIA")  //Regional HQ
					);			                                       
					var comboList = MnrComSearchCombo(sheetObj,sCondition);

					//콤보 설정
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";

								if(i==0){ //Regional HQ
									formObj.combo1.InsertItem(j, comboList[i][j] ,tempText[0]);
									regionalHQ = regionalHQ + tempText[0] + "|";
								}								
							}
						}
					}
					formObj.combo1.InsertItem(0, "ALL" ,"A" );
					formObj.combo1.Code2 = "A";

					initLoader = 1;
				} else {		// 최초 로드 이외의 clear
					formObj.combo1.Code2 = "A";
					formObj.month.value = ComGetDateAdd(null, "D", "0", "-").substring(0,7);
				}
				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  

				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
                break;
				
			case IBSAVE:      // 입력
			 	if(!validateForm(sheetObj,formObj,sAction)){
 		   			return;
 	   			}
				formObj.f_cmd.value = MULTI;    
				
				var sParam = ComGetSaveString(sheetObj);
			    if (sParam == ""){

			    	return;
			    }
			    sParam += "&" + FormQueryString(formObj);
			    
				if(!ComShowCodeConfirm("MNR00160")){
					return;					
				}

				var sXml = sheetObj.GetSaveXml("EES_MNR_0113GS.do", sParam);
				
				sheetObj.LoadSaveXml(sXml);
					         
				break;
			case IBDOWNEXCEL:
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
			if(sAction==IBSAVE) {
				if (!ComChkValid(formObj)){
					return false;
				}
			}
        }
		return true;
	}
	
	
	/**
    * operation office 필드의 combo필드의 데이터를 입력한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */	
	function cellSetItems(sheetObj, Row, Col, Value){
		var sCondition = new Array (      
			new Array("MdmOrganization","SEARCH",Value) 
		)                                
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 

		if(comboList[0] != null){      
			sheetComboText = "";
			sheetComboCode = "";
			for(var j = 0; j < comboList[0].length;j++){  
		   		var tempText = comboList[0][j].split("|");  
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
			}         
			sheetObjects[0].CellComboItem(Row, Col, sheetComboCode, sheetComboCode, 0);
	 	}else{
	 		 ComShowCodeMessage("MNR00010", "Regional H/Q Office"); 
	 		 sheetObjects[0].SelectCell(Row, "ar_hd_qtr_ofc_cd");
		}	 
	}
	
	function showAllOffice(){
		var formObj  = document.form;       
        var sheetObj = sheetObjects[0];
        var checked = formObj.check_show_all.checked;
        var firstMonth = "";
        var endMonth = "";
        
        if(sheetObj.RowCount == 0){
        	return;
        }
        
        for(i=sheetObj.LastRow; i > 1 ; i--){
            if(checked){
            	sheetObj.RowHidden(i) = false;
            } else {
            	firstMonth = sheetObj.CellValue(i, "fst_mon");
			    endMonth = sheetObj.CellValue(i, "lst_mon");

            	if((firstMonth == "" || firstMonth == "0") && (endMonth == "" || endMonth == "0")){
            		sheetObj.RowHidden(i) = true;
            	}
            }
        }
	}
	/* 개발자 작업  끝 */