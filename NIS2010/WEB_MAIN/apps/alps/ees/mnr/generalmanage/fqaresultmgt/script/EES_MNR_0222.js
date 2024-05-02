/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0222.js
*@FileTitle : FQA Result Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.09 함형석
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
     * @class ees_mnr_0222 : ees_mnr_0222 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0222() {
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

var comboValue = "";   

//audit Result History콤보 변경조회후 S/Provider,Yard,audit Date 변경안되게
var noClick = "";

var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)

//조회 클릭시 상태를 저장
var retrieveClick = 0;
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

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "sProvider":
				    if(noClick!="Y"){
						ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
					}
					break;

				case "btn_Detail":
					var vndr_seq="";
					var yd_cd="";
					var fld_aud_dt=""
					var ofc_cd=""
					var reqStr=""
					
					vndr_seq = sheetObject1.CellValue(sheetObject1.SelectRow,"vndr_seq");
					yd_cd = sheetObject1.CellValue(sheetObject1.SelectRow,"yd_cd");
					fld_aud_dt = sheetObject1.CellValue(sheetObject1.SelectRow,"fld_aud_dt");
					ofc_cd = sheetObject1.CellValue(sheetObject1.SelectRow,"ofc_cd");
					
					reqStr = "vndr_seq=" + vndr_seq + "&yd_cd=" + yd_cd + "&fld_aud_dt=" + fld_aud_dt+ "&ofc_cd=" + ofc_cd;
					if(sheetObject1.RowCount >0){
						ComOpenPopup('/hanjin/EES_MNR_0223.do?'+ reqStr, 1024, 700, 'getInvoiceDetail', "0,1,1,1,1,1", true);
					}
					break;
										
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
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

    	initControl(); 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	

		//Office Level 조회  및 전역변수(strMnrOfficeLevel)에 세팅
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
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
				//SetColWidth("100|150"); 
			   	DropHeight = 160;  
				UseAutoComplete = true;
		    	}      
	        	break;    
	        case 2: 
	           	with (comboObj) { 
				MultiSeparator = "|";
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
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                	var prefix="sheet1_";
                    // 높이 설정
                    style.height = 382;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq|FQA Date|Office|Service Provider|Yard|Point|Audit User|Remark";
							
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //dtAutoSumEx 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,			daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,					100,		daCenter,	true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,		"fld_aud_dt",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,		"ofc_cd",			false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,		"vndr_seq",			false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daCenter,	true,		"yd_cd",			false,	"",		dfDateYmd,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daRight,	false,		"pnt_no",			false,	"",		dfNullFloat,	2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daLeft,		false,		"cre_usr_id",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					100,		daLeft,		false,		"fld_aud_rmk",		false,	"",		dfNone,			0,			true,		true);
																						


					MultiSelection = false;   
					SelectionMode = smSelectionRow;     
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
					CountPosition = 0;  
                }
         		  break;
		}		  
     }

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	form); //- 변경될때.
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
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        

	function obj_change(){     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "vndr_seq":   
	        		vndr_seq_confirm();  
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;  
			}       
	    } 
	}   
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
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
	            if(obj.name=="vndr_seq"){ 
					ComKeyOnlyNumber(obj);     
				} else {
					ComKeyOnlyAlphabet('uppernum');	
				}  
	            break;	  
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
   		if(Index_Code==""){
			comboObj.Code="A";
		}
		if(comboObj.Code=="A"){
			//formObj.ar_hd_qtr_cd.value = ""; 
		}else{
			//formObj.ar_hd_qtr_cd.value = comboObj.Code; 
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
   		if(Index_Code==""){
			comboObj.Code="A";
		}
		if(comboObj.Code=="A"){
			formObj.ofc_cd.value = ""; 
		}else{
			formObj.ofc_cd.value = comboObj.Code; 
		}
	} 
	
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
        	case IBSEARCH:      //조회
        		if(validateForm(sheetObj,formObj,sAction)){
	                formObj.f_cmd.value = SEARCH;
				    retrieveClick = 1;

	    		    var sXml = sheetObj.GetSearchXml("EES_MNR_0222GS.do" , FormQueryString(formObj));
	    		
					var arrXml = sXml.split("|$$|"); 
					if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
				    
        	  	}    
             	break;
          
          	case IBCLEAR:      // new 
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;

        	    //조회버튼 클릭 초기화 	
				retrieveClick = 0;
				//쉬트 초기화
				for(i=0;i<sheetObjects.length;i++){ 
			    	sheetObjects[i].RemoveAll();    
			    }  
				//콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
			 		comboObjects[i].RemoveAll();	
			    }    

				var sCondition = new Array (
					new Array("MdmOrganization","RHQ","FALSE")  //Regional HQ
				);   
				
				var comboList = MnrComSearchCombo(sheetObj,sCondition);

				//콤보 설정
				for(var i = 0; i < comboList.length;i++){
					if(comboList[i] != null){
						//쉬트콤보별 초기화
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");
							if(i==0){ //Regional HQ
								formObj.combo1.InsertItem(j, comboList[i][j] ,tempText[0]);
							}
						}
					}
				}
				
				formObj.combo1.InsertItem(0, "ALL" ,"A" );

				if(strMnrOfficeLevel=="L1"){
					formObj.combo1.Code = "A";
				} else {
					formObj.combo1.Enable = false;
					formObj.combo1.Code = rhqOfcCd;
				}
				noClick = "";
				formObj.vndr_seq.value="";
				formObj.vndr_lgl_eng_nm.value="";
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);

               	break;
        } 
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의)      */
    function validateForm(sheetObj,formObj,sAction){
    	var prefix = "sheet1_";
    	switch (sAction) {
	 	    case IBSEARCH: // 조회

				break;  
   	    }
   	    return true;    
    }

	/**  
	 * vndr_seq 존재여부 체크     
	 */  
	function vndr_seq_confirm(){
		var formObj = document.form;
		if(formObj.vndr_seq.value != "" && noClick!="Y" && Number(formObj.vndr_seq.value)){ 
			//서비스 프로바이더 조회 
			var sCondition = new Array ( 
			 	new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
			)                            
			//조회 값이 있다면 세팅
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
			if(comboList[0] != null){
				var tempText = comboList[0][0].split("|"); 
				formObj.vndr_lgl_eng_nm.value  = tempText[1];  
			} else {       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}   
		} else {
			ComShowCodeMessage("MNR00005", "Service Provider");              
			ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
			ComSetObjValue(formObj.vndr_seq, "");
			ComSetFocus(formObj.vndr_seq);
		}
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

			if(strMnrOfficeLevel=="L3"){
				formObj.combo2.Enable = false;
				formObj.combo2.Code = currOfcCd;
			}else {
				formObj.combo2.Code = "A";
			}				
		} 
	} 

    /**
     * getCOM_ENS_0C1 의 값을 받은 함수   
	 * @param	{String[][]}	aryPopupData	팝업화면에서 리턴받은 배열값
     */   
    function getCOM_ENS_0C1(aryPopupData, row, col, sheetIdx){
   	 
   	 var formObj = document.form;
   	 var vndrSeq = "";
   	 var vndrNm = "";
   	 var i = 0;
   	 
   	 for(i = 0; i < aryPopupData.length; i++){
   		 vndrSeq = vndrSeq + aryPopupData[i][2];
   		 
   		 if(aryPopupData.length == 1){
   			 vndrNm = vndrNm + aryPopupData[i][4];
   		 }
   		 
   		 if(i < aryPopupData.length - 1){
   			 vndrSeq = vndrSeq + ",";
   		 }
   	 }
   	 
   	 formObj.vndr_seq.value = vndrSeq;
   	 formObj.vndr_lgl_eng_nm.value = vndrNm;
   	 
    }


