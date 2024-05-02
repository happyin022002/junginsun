/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0272.js
*@FileTitle : Onsite Inspection Result Detail Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
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
     * @class ees_mnr_0272 : ees_mnr_0272 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0272() {
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

var uploadObjects = new Array();
var uploadCnt = 0;

//파일Seq저장변수 (추가될때 )
var uploadFileSeq = "";  

//audit Result History콤보 변경조회후 S/Provider,Yard,audit Date 변경안되게
var noClick = "";

//Service Provider를 Column에 표시하기 위한 변수
var SPNAME =""

//조회 클릭시 상태를 저장
var retrieveClick = 0;


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

						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
								break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
								break;
						case "btn_Close":
							self.close();
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
	    
		
		if(document.form.t2Flg.value == 1){
			vndr_seq_confirm();
		} else{
			document.form.vndr_seq.value = document.form.vndrSeq1.value;
			document.form.vndr_lgl_eng_nm.value = document.form.vndrNm1.value;
			document.form.yd_cd.value = document.form.yd_cd1.value;
			document.form.fld_insp_dt.value = document.form.fld_insp_dt1.value;
			vndr_seq_confirm();
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
		}
		
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");  		
    }

	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files = "";
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
	      	   	 
        	   SetColAlign("left|left");        
		       SetColWidth("80|100");      
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
                    style.height = 382;
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

                    var HeadTitle1 = "|Check List for (" + SPNAME +"): " + "|Verify Result|Verify Result|Verify Result|Action";
                	var HeadTitle2 = "|Check List for (" + SPNAME +"): " + "|Good|Normal|Poor|Action";
                    
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //dtAutoSumEx 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,                 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty2(0, cnt++ , 	dtHiddenStatus,	 "width=0; data-align=daCenter; col-merge=true; save-name=ibflag");
                    InitDataProperty2(0, cnt++ , 		dtData,	     "width=800; data-align=daLeft; col-merge=true; save-name=ev_itm_nm; update-edit=false");
                    InitDataProperty2(0, cnt++ , 		dtData, 	 "width=70; data-align=daCenter; col-merge=true; save-name=rslt_gd_flg; update-edit=false");
                    InitDataProperty2(0, cnt++ , 		dtData, 	 "width=70; data-align=daCenter; col-merge=true; save-name=rslt_norm_flg; update-edit=false");
                    InitDataProperty2(0, cnt++ , 		dtData, 	 "width=70; data-align=daCenter; col-merge=true; save-name=rslt_bad_flg; update-edit=false");
                    InitDataProperty2(0, cnt++ , 		dtData, 	 "width=200; data-align=daCenter; col-merge=true; save-name=fld_aud_rmk; update-edit=false");
                    InitDataProperty2(0, cnt++ , 		dtHidden, 	 "width=200; data-align=daCenter; col-merge=true; save-name=ev_itm_ord_no; update-edit=true");
                    InitDataProperty2(0, cnt++ , 		dtHidden, 	 "width=200; data-align=daCenter; col-merge=true; save-name=vndr_nm; update-edit=true");
                    InitDataProperty2(0, cnt++ , 		dtHidden, 	 "width=200; data-align=daCenter; col-merge=true; save-name=sheet_brnc_insp_flg; update-edit=true");
                    InitDataProperty2(0, cnt++ , 		dtHidden, 	 "width=200; data-align=daCenter; col-merge=true; save-name=sheet_hdbrn_insp_flg; update-edit=true");
					  
//					InitDataValid(0,    prefix + "max_pnt_no",   vtNumericOnly);
//					InitDataValid(0,    prefix + "pnt_no", vtNumericOther, "."); 
					MultiSelection = false;   
					SelectionMode = smSelectionRow;     
					SelectHighLight = true;            
					SelectFontBold = false;          
					CountPosition = 0;  
                }
         		  break;
		         		
            
            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 82;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Attach Inspection Detail|Download Attachment";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	 	"seq")
					InitDataProperty(0, cnt++ , dtPopup,      	180,    daCenter,  	false,   	"org_file_nm",     true,           "",      dfNone,    0,     	false,		true,	50);
					InitDataProperty(0, cnt++ , dtImage,      	60,   	daCenter,  	false,   	"file_dw",   		false,          "",      dfNone,    0,     	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   	"file_path_nm",   	false,          "",      dfNone,    0,     	true,      	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   	"file_path",   	false,          "",      dfNone,    0,     	true,      	true);
					InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   	"file_seq",   		false,          "",      dfNone,    0,     	true,      	true);										
					InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,  		"file_dtl_seq",	false,			"",		 dfNone,	0,		false,		false);
	 					
					CountPosition = 0;
					
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1;
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

	 //페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++] = uploadObj;
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
		if(obj.name == "fld_insp_dt"){    
		    var formObject = document.form;
			formObject.combo1.Code = document.form.fld_insp_dt.value; 
		}  
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
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;  
	    		case "yd_cd":         
					yd_cd_confirm();
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
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
				}else{
					ComKeyOnlyAlphabet('uppernum');	
				}  			
	            break;	  
	    }
	} 
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		var sheetObject1 = sheetObjects[0];
		var comboValue = Index_Code.split('|');
		var formObj = document.form;
		if(typeof comboValue != "undefined" && comboValue != "") {
      	   formObj.yd_cd.value = comboValue[0].substring(0,7);
      	   if(comboValue[0].substring(8,14) != ""){
      		 formObj.vndr_seq.value = comboValue[0].substring(8,14);   
      	   }
      	   formObj.fld_insp_dt.value = comboValue[1];
        }
		noClick = "Y";
		fieldEnableYN();
		
		//Retrive 기능
		doActionIBSheet(sheetObject1,formObj,IBSEARCH);
	}  
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
      
        if (sheetObj.ColSaveName(Col)!="file_dw" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, "file_path_nm") == "") return;

		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "file_path_nm");
		return;
	}
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
          case IBSEARCH:      //조회
        	  if(validateForm(sheetObj,formObj,sAction)){
        		formObj.f_cmd.value = SEARCH;
 	               
        		var sXml = sheetObj.GetSearchXml("EES_MNR_0273GS.do" , FormQueryString(formObj));
				
        		var arrXml = sXml.split("|$$|"); 
        		sheetObjects[0].Redraw = false;
        		if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
				// main grid의 header에 SERVICE PROVIDER를 출력하기 위한 HeadRow의 re-initiallization
				
				formObj.vndr_lgl_eng_nm.value = sheetObj.CellValue(3, "vndr_nm");
				
				SPNAME = formObj.vndr_lgl_eng_nm.value;
				
				var HeadTitle3 = "|Check List for (" + SPNAME +"): " + "|Verify Result|Verify Result|Verify Result|Action";
            	var HeadTitle4 = "|Check List for (" + SPNAME +"): " + "|Good|Normal|Poor|Action";
				
				sheetObj.InitHeadRow(0, HeadTitle3, true);
				sheetObj.InitHeadRow(1, HeadTitle4, true);
				
				
				for(var i = 2; i < sheetObj.Rows; i++){
					if(sheetObj.CellValue(i,"ev_itm_nm").length <= 1){
						sheetObj.RowEditable(i) = false;
					}
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,255);
				}
				sheetObjects[0].Redraw = true;

				
				if(sheetObjects[0].Cellvalue(3,"sheet_brnc_insp_flg") == "Y"){
					formObj.brnc_insp_flg.checked = true;	
				} else{
					formObj.brnc_insp_flg.checked = false;
				}
				
				if(sheetObjects[0].Cellvalue(3,"sheet_hdbrn_insp_flg") == "Y"){
					formObj.hdbrn_insp_flg.checked = true;	
				} else{
					formObj.hdbrn_insp_flg.checked = false;
				}
				
        	  }    
              break;
         }
         sheetObj.ShowDebugMsg = false;
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의)      */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	 	    case IBSEARCH: // 조회
				if(formObj.vndr_seq.value == "" || formObj.vndr_seq.value == null) {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00003'));
					return;
				} else if(formObj.fld_insp_dt.value == "") {
					ComAlertFocus(formObj.fld_insp_dt, ComGetMsg('MNR00003'));
					return;
				}
				break;  
   	    }
   	    return true;    
    }
 
 	//audit Result History콤보 변경조회만  S/Provider,Yard,audit Date 변경안되게 처리
	function fieldEnableYN(){
		var formObj = document.form;
		if(noClick=="Y"){
			MnrFormSetReadOnly(formObj,true,"vndr_seq|fld_insp_dt|yd_cd|brnc_insp_flg|hdbrn_insp_flg");   
		}else{
			MnrFormSetReadOnly(formObj,false,"vndr_seq|fld_insp_dt|yd_cd|brnc_insp_flg|hdbrn_insp_flg");   
		}
	}

	/**  
	 * vndr_seq 존재여부 체크     
	 */  
	function vndr_seq_confirm(){
		var formObj = document.form;
		
		if (formObj.t2Flg.value == 1){
			var sCondition = new Array (
					new Array("MnrOnsiteInspectionResultHistory",formObj.insp_yr.value+ComLpad(formObj.insp_wk.value, 2, "0")+formObj.insp_ofc_cd.value+formObj.vndr_seq.value,"COMMON1")
				)
			
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
	 		if(comboList[0] != null){
	 			for(var j = 0; j < comboList[0].length;j++){
	 				formObj.combo1.InsertItem(j, comboList[0][j] ,comboList[0][j] );
	 			}  
	 		} 
		} else if (formObj.vndr_seq.value != "" && noClick!="Y" && Number(formObj.vndr_seq.value)) {
			 var sCondition = new Array (   
					 new Array("MnrOnsiteInspectionResultHistory",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.insp_ofc_cd.value,"COMMON")
				)
			
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
	 		if(comboList[0] != null){
	 			for(var j = 0; j < comboList[0].length;j++){ 
	 				formObj.combo1.InsertItem(j, comboList[0][j] ,comboList[0][j] );
	 			}  
	 		} 
		} else {
			ComShowCodeMessage("MNR00005", "Service Provider");              
			ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
			ComSetObjValue(formObj.vndr_seq, "");
			ComSetFocus(formObj.vndr_seq);
		}
	}

	/**  
	 * yd_cd 존재여부 체크     
	 */  
	function yd_cd_confirm(){
		var formObj = document.form;
		if(formObj.yd_cd.value != "" && noClick!="Y"){ 
			var retArray = MnrGeneralCodeCheck(sheetObjects[0],"YARD",formObj.yd_cd.value);      
			if(retArray == null){    
				ComShowCodeMessage("MNR00165",formObj.yd_cd.value); 
				formObj.yd_cd.value = "";
				formObj.yd_cd.focus();
			}else{
				return;
			}
		}  
	}
	   