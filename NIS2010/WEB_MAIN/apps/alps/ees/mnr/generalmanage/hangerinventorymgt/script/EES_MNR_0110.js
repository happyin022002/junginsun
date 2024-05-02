/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0110.js
*@FileTitle : Hanger Bar Inventory List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.15 함형석
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
     * @class ees_mnr_0110 : ees_mnr_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0110() {
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
				case "btn_Detail":
					var ofc_cd="";
					var reqStr=""
					ofc_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"ofc_cd")
					reqStr = "ofc_cd=" + ofc_cd
					if(sheetObjects[0].RowCount >0){
						ComOpenPopup('/hanjin/EES_MNR_0224.do?'+ reqStr, 1024, 500, '', "0,1,1,1,1,1", true);
					}
					break;
				case "btn_RowAdd":
					doRowAdd(sheetObject1, formObject);
					break;
				case "btn_Delete":
					if(sheetObject1.FindCheckedRow("del_chk") == ""){ 
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;             	   
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObjects[0], "del_chk");
					}
					break;					
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
	        case 2: 
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
                    style.height = 396;
                    
                    SheetWidth = mainTable.clientWidth;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    MergeSheet = msHeaderOnly;
                    Editable = true;

                    var HeadTitle1 = "|Sel|Seq.|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|G.TTL|Remark(s)|Update\nDate";
                    var HeadTitle2 = "|Sel|Seq.|Regional\nH/Q|Office|Bar Type|Inventory|Purchase Qty|Supply Qty|Sound         |Damage        |Missing    |Disposal   |G.TTL|Remark(s)|Update\nDate";
					var headCount = ComCountHeadTitle(HeadTitle1);		
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 10, 100);		
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 1, 5, 0, true);									
                    InitHeadMode(true, true, true, true, false,false);
					
                    InitHeadRow(0, HeadTitle1, true);	
                    InitHeadRow(1, HeadTitle2, true);
																
                    //   dtComboEdit [ROW, COL,  DATATYPE,               WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     	    40,	    daCenter,	false,	    "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		            40,	    daCenter,	true,		"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,                      30,     daCenter,   true,       "Seq"); 
					InitDataProperty(0, cnt++ , dtCombo,					80,	    daCenter,	true,		"ar_hd_qtr_ofc_cd",			true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,				    80,	    daCenter,	true,		"ofc_cd",			    	true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,				    80,	    daCenter,	true,		"mnr_hngr_bar_tp_cd",		true,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					    90,		daRight,	true,	    "rcvr_qty",					false,	"",		dfInteger,	        0,			true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					    90,		daRight,	true,	    "pur_qty",					false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					    90,		daRight,	true,	    "csm_qty",					false,	"",		dfInteger,	        0,			true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					    105,	daRight,	true,	    "act_invt_qty",				false,	"",		dfInteger,	        0,			true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					    80,		daRight,	true,	    "mnr_hngr_dmg_qty",			false,	"",		dfInteger,	        0,			true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					    80,		daRight,	true,	    "mnr_lost_hngr_qty",		false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					    80,		daRight,	true,	    "mnr_disp_hngr_qty",		false,	"",		dfInteger,	        0,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,					    90,		daRight,	true,	    "invt_qty",					false,	"",		dfInteger,	        0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,					    140,	daLeft,	    true,	    "invt_rmk",					false,	"",		dfNone,	        	0,			true,		true, 4000);
					InitDataProperty(0, cnt++ , dtData,					    90,		daLeft,	    true,	    "upd_dt",					false,	"",		dfNone,	        	0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,					100,	daCenter,	true,	    "col_qty",					false,	"",		dfNone,				0,  		true,		true);		
										
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

   /**
    * sheet1에서 SearchEnd이벤트를 처리한다.
    * @param sheetObj
    * @param errMsg
    * @return
    */
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(sheetObjects[0].RowCount>0){
	    	 for(i=sheetObjects[0].LastRow; i > 1 ; i--){
				  sheetObj.RowStatus(i) ="R";	    	 
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
	
   /**
    * sheet1에서 발생하는 OnChange이벤트를 처리한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
    	if(nowLoad == 0){
		   	if(sheetObj.ColSaveName(Col) == "ar_hd_qtr_ofc_cd"){
				if(strMnrOfficeLevel=="L1"){
					cellSetItems(sheetObj, Row, "ofc_cd", Value);
				}else if(strMnrOfficeLevel=="L2"){
					cellSetItems(sheetObj, Row, "ofc_cd", Value);
				}else if(strMnrOfficeLevel=="L3"){
				   	sheetObj.CellValue2(Row, "ar_hd_qtr_ofc_cd") = currOfcCd;
				   	cellSetItems(sheetObj, Row, "ofc_cd", currOfcCd);
				}					
		   	} else if(sheetObj.ColSaveName(Col) == "act_invt_qty" || sheetObj.ColSaveName(Col) == "mnr_hngr_dmg_qty"){
				//이전 합		
				var collectionQty =   parseInt(sheetObj.CellValue(Row, "col_qty"));
							
				if(sheetObj.ColSaveName(Col) == "act_invt_qty"){	
					var soundQty = parseInt(Value);					
					sheetObj.CellValue2(Row, "mnr_hngr_dmg_qty") = collectionQty - soundQty;	
				} else {		
					var dmgQty = parseInt(Value);			
					sheetObj.CellValue2(Row, "act_invt_qty") = collectionQty - dmgQty;	
				}			
									
				setGTTL(sheetObj, Row);	
		   	} else if(sheetObj.ColSaveName(Col) == "rcvr_qty"){
				setGTTL(sheetObj, Row);
			}
    	}
	}  
		

	function sheet1_OnClick(sheetObj,Row, Col, Value){
    	if(nowLoad == 0){
		   	if(sheetObj.ColSaveName(Col) == "ofc_cd"){
				if(strMnrOfficeLevel=="L1"){
					cellSetItems(sheetObj, Row, "ofc_cd", sheetObj.CellValue(Row, "ar_hd_qtr_ofc_cd"));
				} else if(strMnrOfficeLevel=="L2"){
					cellSetItems(sheetObj, Row, "ofc_cd", sheetObj.CellValue(Row, "ar_hd_qtr_ofc_cd"));
				} else if(strMnrOfficeLevel=="L3"){
					sheetObj.CellValue2(Row, "ofc_cd") = currOfcCd;
				}
			}
    	}
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
		        		sheetObj.DoSearch4Post("EES_MNR_0110GS.do",FormQueryString(formObj));	
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
						new Array("MnrGenCd","CD00022", "COMMON"),  //Hanger Bar Type 
						new Array("MdmOrganization","RHQ","FALSE"),  //Regional HQ
						new Array("MdmOrganization","SEARCH","NOTHQ")
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

								if(i==1){ //Regional HQ
									formObj.combo1.InsertItem(j, comboList[i][j] ,tempText[0]);
									regionalHQ = regionalHQ + tempText[0] + "|";
								}								
							}
							//Hanger Bar Type 
							if(i==0) {
								sheetObjects[0].InitDataCombo(0, "mnr_hngr_bar_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
							}else if(i==2){
								if(strMnrOfficeLevel=="L3"){
									sheetComboCode = 	currOfcCd ;
								}	
							 	sheetObjects[0].InitDataCombo(0, "ofc_cd", sheetComboCode, sheetComboCode, sheetComboCode);
							}					
						}
					}
					formObj.combo1.InsertItem(0, "ALL" ,"A" );

					if(strMnrOfficeLevel=="L1"){
						formObj.combo1.Code = "A";
					}else{
						formObj.combo1.Enable = false;
						formObj.combo1.Code = rhqOfcCd;
						regionalHQ = 	rhqOfcCd ;
					}	
										
					initLoader = 1;	
				}
				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  

				sheetObjects[0].InitDataCombo(0, "ar_hd_qtr_ofc_cd", regionalHQ, regionalHQ, regionalHQ.substring(0,regionalHQ.indexOf("|")) );

				if(strMnrOfficeLevel=="L3"){
					formObj.combo2.Enable = false;
					formObj.combo2.Code = currOfcCd;
					formObj.ofc_cd.value = currOfcCd;
				}else{
					formObj.combo2.Code = "A";
					formObj.ofc_cd.value = "";
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
			    if (sParam == "") return;
			    sParam += "&" + FormQueryString(formObj);

				var sXml = sheetObj.GetSaveXml("EES_MNR_0110GS.do", sParam);
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
				if (!ComChkValid(formObj))	return false;

				var Row = sheetObjects[0].ColValueDup( "ar_hd_qtr_ofc_cd|ofc_cd|mnr_hngr_bar_tp_cd");
				if(sheetObjects[0].IsDataModified){
					if(Row > 0){ 
						ComShowCodeMessage("MNR00006", (Row - 1) + " row ");
						return false;	
					}	
				}	
								
				for(var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].RowCount;i++)
				{
					if(sheetObjects[0].RowStatus(i) == "U"){
						var soundQty = parseInt(sheetObjects[0].CellValue(i, "act_invt_qty"));     
						var dmgQty =   parseInt(sheetObjects[0].CellValue(i, "mnr_hngr_dmg_qty")); 
								
						if(soundQty < 0){
							ComShowCodeMessage("MNR00224");	
							sheetObj.SelectCell(i, "act_invt_qty", true);    
							return false; 	 
						}
													
						if(dmgQty < 0){	
							ComShowCodeMessage("MNR00224");		
							sheetObj.SelectCell(i, "mnr_hngr_dmg_qty", true); 
							return false;  
						}	
					}
				}
			}
        }
		return true;
	}
	
	 /**
	 * Total 계산식 : Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
	 * @param {IBSheet}	sheetObj	
	 * @param {Number}	Row			
	 * @return
	 */
	function setGTTL(sheetObj, Row){
		//이전 보유량 
		var rcvrQty =  parseInt(sheetObj.CellValue(Row, "rcvr_qty"));
		//구매 
		var purQty =   parseInt(sheetObj.CellValue(Row, "pur_qty"));
		//소비 
		var csmQty =   parseInt(sheetObj.CellValue(Row, "csm_qty"));
		//사운드 
		var soundQty = parseInt(sheetObj.CellValue(Row, "act_invt_qty"));
		//데미지 
		var dmgQty =   parseInt(sheetObj.CellValue(Row, "mnr_hngr_dmg_qty"));
		//분실 
		var lostQty =  parseInt(sheetObj.CellValue(Row, "mnr_lost_hngr_qty"));
		//매각대상
		var dispQty =  parseInt(sheetObj.CellValue(Row, "mnr_disp_hngr_qty"));
				
		var ttlQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
		sheetObj.CellValue2(Row,  "invt_qty") = ttlQty; 
	}	
	
   /**
     * row add버튼이 클릭될경우 발생되는 이벤트 처리
     * @param sheetObj
     * @param formObj
     * @return
     */
	 function doRowAdd(sheetObj, formObj){
		    nowLoad = 1;
		    var iRow = sheetObjects[0].DataInsert(-1);

			if(strMnrOfficeLevel=="L1"){
				if( formObj.combo1.Code == "A"){
					sheetObjects[0].CellValue2(iRow,  "ar_hd_qtr_ofc_cd") = rhqOfcCd;
				}else{
					sheetObjects[0].CellValue2(iRow,  "ar_hd_qtr_ofc_cd") = formObj.combo1.Code;
				} 
				cellSetItems(sheetObjects[0], iRow, "ofc_cd", sheetObj.CellValue(iRow, "ar_hd_qtr_ofc_cd"));

			}else if(strMnrOfficeLevel=="L2"){
				if( formObj.combo1.Code == "A"){
					sheetObjects[0].CellValue2(iRow,  "ar_hd_qtr_ofc_cd") = rhqOfcCd;
				}else{
					sheetObjects[0].CellValue2(iRow,  "ar_hd_qtr_ofc_cd") = formObj.combo1.Code;
				} 
				cellSetItems(sheetObjects[0], iRow, "ofc_cd", sheetObj.CellValue(iRow, "ar_hd_qtr_ofc_cd"));
			}else if(strMnrOfficeLevel=="L3"){
				sheetObjects[0].CellValue2(iRow,  "ar_hd_qtr_ofc_cd") = rhqOfcCd;
				sheetObjects[0].CellValue2(iRow,  "ofc_cd") = currOfcCd;
			}	
					
			sheetObjects[0].SelectCell(iRow, "Seq") ;
			nowLoad = 0;
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
	/* 개발자 작업  끝 */