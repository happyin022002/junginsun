/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ees_mnr_0273.js
*@FileTitle : Onsite Inspection Result Creation
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
     * @class ees_mnr_0273 : ees_mnr_0273 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0273() {
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
	var SPNAME ="";
	var YDNAME ="";
	var INSPDATE ="";
			
	
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
						case "btn_Save":
							if (ComShowCodeConfirm("MNR00160")){
								doActionIBSheet(sheetObject1,formObject,IBSAVE);	
							}
								break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBCLEAR);
								break;
						case "btn_Delete":
							doActionIBSheet(sheetObject1,formObject,IBDELETE);
								break;
						case "btn_vndr":
						    if(noClick!="Y"){
								ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
							}
							break;
						case "btn_yd":
							if(noClick!="Y"){
								ComOpenPopup('/hanjin/COM_ENS_061.do', 766, 460, 'getCOM_ENS_061', "1,0,1,1,1,1,1,1,1,1,1,1", true);
							}
							break;
						case "calendar":
							if(noClick!="Y"){
		                    	var cal = new ComCalendar();
		                    	cal.select(form.fld_insp_dt, 'yyyy-MM-dd');
		                    	
							}
		                    break;
						case "btn_RowAdd": 
							sheet_DataInsert(sheetObject2);
								break;
						case "btn_RowDel":
							rowRemove(sheetObject2);
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
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do");
		
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDel");
		
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

                    var HeadTitle1 = "|Check List for (Vendor: " + SPNAME + ", Yard Code: " + YDNAME + ", Inspection Date: " + "|Verify Result|Verify Result|Verify Result|Action";
                	var HeadTitle2 = "|Check List for (Vendor: " + SPNAME + ", Yard Code: " + YDNAME + ", Inspection Date: " + "|Good|Normal|Poor|Action";
                    
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

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
                    InitDataProperty2(0, cnt++ , 		dtData, 	 "width=200; data-align=daLeft; col-merge=true; save-name=fld_aud_rmk; update-edit=true");
                    InitDataProperty2(0, cnt++ , 		dtHidden, 	 "width=200; data-align=daCenter; col-merge=true; save-name=ev_itm_ord_no; update-edit=true");
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
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 	"del_chk")
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
	    var formObj = document.form;
		obj = event.srcElement;       
		if(obj.name == "fld_insp_dt"){    
			formObj.aud_rslt_his.Code = formObj.fld_insp_dt.value; 
		}  
	    ComChkObjValid(event.srcElement);
	    
		switch(obj.name) {      
		case "vndr_seq":
			if(document.form.vndr_seq.value == ""){
				document.form.vndr_lgl_eng_nm.value = "";
			}
		   	break;  
	} 
	    
	    
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
	    			formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");
	        		vndr_seq_confirm();
				   	break;  
	    		case "yd_cd":         
					yd_cd_confirm();
				   	break;   
			}       
	    } 
	}       
	 
//	/**
//	 * HTML Control의 Check Box OnClick 이벤트 <br>
//	 **/   
//	function insp_flg_onChange(chkBox){
//		switch(chkBox) {
//		case "brnc_insp_flg":
//			if(sheetObjects[0].Cellvalue(3,"sheet_brnc_insp_flg") == "Y"){
//				sheetObjects[0].Cellvalue(3,"sheet_brnc_insp_flg") = "N";
//			} else {
//				sheetObjects[0].Cellvalue(3,"sheet_brnc_insp_flg") = "Y";	
//			}
//			
//			break;
//		case "hdbrn_insp_flg":
//			if(sheetObjects[0].Cellvalue(3,"sheet_hdbrn_insp_flg") == "Y"){
//				sheetObjects[0].Cellvalue(3,"sheet_hdbrn_insp_flg") = "N";
//			} else {
//				sheetObjects[0].Cellvalue(3,"sheet_hdbrn_insp_flg") = "Y";	
//			}
//			break;
//		}
//	}
	
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





	/* ********* Event Functions ************* */ 
	/**  
	 * sheet1 SaveEnd 이벤트      
	 * @param {IBSheet}  sheetObj 콤보오브젝트  
	 * @param  {String}    ErrMsg   에러메시지 
	 */  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if(retrieveClick=='2'){
			if (ErrMsg == "") { 
				ComShowCodeMessage("MNR00020",'');   
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);  
			} 
		}else{
			if (ErrMsg == "") { 
				ComShowCodeMessage("MNR00023",'');   
			} else if(ErrMsg.indexOf("MNR00185")<=0){
				ComShowCodeMessage("MNR00008",ErrMsg);  
			}
		}
		
	}

	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnClick(sheetObj,Row,Col,Value){
		if(sheetObj.ColSaveName(Col)!= "fld_aud_rmk" && sheetObj.ColSaveName(Col)!= "ev_itm_nm"){
			if(sheetObj.CellValue(Row, 1).length > 1){
				if(sheetObj.CellValue(Row, Col) == ""){
					sheetObj.CellValue(Row, Col) = "O";
				}else{
					sheetObj.CellValue(Row, Col) = "";
				}	
			}	
		}
		return;
	}
   

	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     **/
	function sheet2_OnPopupClick(sheetObj,Row,Col){

	    var upObj = uploadObjects[0];     
	 	var fileName = sheetObj.OpenFileDialog("파일선택");
	 	if(fileName.indexOf("\\") !=-1) {
	 		sheetObj.CellValue2(Row, "org_file_nm")= fileName;     			
	 		upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
	    	var ret = upObj.AddFile(fileName);     			     			
	    	fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
	 		sheetObj.CellValue2(Row, Col)= fileName;		 		
			sheetObj.CellValue2(Row, "file_dw")= '1';
	 		var file_seq = sheetObj.CellValue(Row, "file_seq");
			var file_dtl_seq = sheetObj.CellValue(Row, "file_dtl_seq");
			if(file_dtl_seq=="") file_dtl_seq=Row;
			var ibflag='U';
			if(file_seq=="" || uploadFileSeq!="") ibflag='I'; // 최초 저장시 및 저장된 파일 없을때 ibflag을 I로 Setting			
			if(file_seq!="" && uploadFileSeq!="") ibflag='U';

			if(uploadFileSeq != "") {
				file_seq = uploadFileSeq;
			}	     		
			
	 		var sParam = "f_cmd="+COMMAND01;
	 		sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code				
	 		sParam+= "&file_seq=" + file_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // 기존에 존재 File Sequence
	 		sParam+= "&org_file_nm=" + fileName; // Fileupload 파일명
	 		sParam+= "&ibflag=" + ibflag;        // I : 최초 File Upload U : File 변경   		
			upObj.ExtendParam = sParam;

			var sXml = upObj.DoUpload(true);
			if(sXml.indexOf("<ERROR>") != -1 || sXml.indexOf("<UPLOADEND>") != -1 || sXml == ""){
				ComShowMessage(ComGetMsg('MNR00405'));
				sheetObj.CellValue(Row, "del_chk") = 'Y';
				rowRemove(sheetObj);
			}else{
				uploadFileSeq = ComGetEtcData(sXml,"seqValue");
				if(uploadFileSeq != "" && uploadFileSeq != undefined){ 
					var fileXml = SearchFileUpload(sheetObjects[1],uploadFileSeq);
					sheetObjects[1].LoadSearchXml(fileXml);   				
				}
				document.form.file_seq.value = sheetObj.CellValue(Row, "file_seq");
			}
		}
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
	
	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function aud_rslt_his_OnChange(comboObj,Index_Code, Text){
		var sheetObject1 = sheetObjects[0];
		var comboValue = Index_Code.split('|');
		var formObj = document.form;
		if(typeof comboValue != "undefined" && comboValue != "") {
      	   formObj.yd_cd.value = comboValue[0];
      	   formObj.fld_insp_dt.value = comboValue[1];
        }
		noClick = "Y";
		fieldEnableYN();
		
		//Retrive 기능
		
		doActionIBSheet(sheetObject1,formObj,IBSEARCH);
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
				
				SPNAME = formObj.vndr_lgl_eng_nm.value;
				YDNAME = formObj.yd_cd.value;
				INSPDATE = formObj.fld_insp_dt.value;
				
				formObj.vndr_seq_for_save.value = formObj.vndr_seq.value;
				formObj.yd_cd_for_save.value = formObj.yd_cd.value;
				formObj.fld_insp_dt_for_save.value = formObj.fld_insp_dt.value;
				formObj.vndr_lgl_eng_nm_for_save.value = SPNAME;
				
				
				
				var HeadTitle3 = "|Check List for (Vendor: " + SPNAME + ", Yard Code: " + YDNAME + ", Inspection Date: " + INSPDATE + "): " + "|Verify Result|Verify Result|Verify Result|Action";
            	var HeadTitle4 = "|Check List for (Vendor: " + SPNAME + ", Yard Code: " + YDNAME + ", Inspection Date: " + INSPDATE + "): " + "|Good|Normal|Poor|Action";
				
				sheetObj.InitHeadRow(0, HeadTitle3, true);
				sheetObj.InitHeadRow(1, HeadTitle4, true);
				
				
				for(var i = 2; i < sheetObj.Rows; i++){
					if(sheetObj.CellValue(i,"ev_itm_nm").indexOf("*") != 0){
						sheetObj.CellFont("FontBold", i, "ev_itm_nm") = true;
					}else{
						sheetObj.CellValue(i,"ev_itm_nm") = " " + sheetObj.CellValue(i,"ev_itm_nm");
					}
					
					if(sheetObj.CellValue(i,"ev_itm_nm").length <= 1){
						sheetObj.RowEditable(i) = false;
					}
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,255);
				}
				sheetObjects[0].Redraw = true;
				document.form.file_seq.value = sheetObjects[1].CellValue(1, "file_seq");
				
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_RowDel");
				
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
          case IBSAVE:        //저장
        	  if(validateForm(sheetObj,formObj,sAction)){
        		  document.form.file_seq.value = sheetObjects[1].CellValue(1, "file_seq");
		            formObj.f_cmd.value = MULTI;  
	                //2.IBSheet 데이터 QueryString으로 묶기
					var sParam = ComGetSaveString(sheetObjects);
//					if (sParam == "") return;
	                //3.Form 데이터 QueryString으로 묶기
					sParam += "&" + FormQueryString(formObj);

					//4. 서버에 request전달하고, reponse 받기
					
//					sheetObj.DoSave("EES_MNR_0273GS.do", sParam); 
					sheetObj.DoAllSave("EES_MNR_0273GS.do", sParam); 
					
 					audit_result_history_search();
					
					noClick = "";
					fieldEnableYN();
        	    }  
	            break;
          case IBCLEAR:      // new  
        	  	MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
        	    formObj.reset();
        	  
        	    form.fld_insp_dt.value = ComGetNowInfo();
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
				//====================================================================
				//공통코드 호출 시작
				//====================================================================
				 var arrXml = MnrComSearchGrid(sheetObjects[0],"com_code_search_ind");				 
				 sheetObjects[0].Redraw = false;
				 sheetObjects[0].LoadSearchXml(arrXml[0]);
				 //end
				
				SPNAME = "";
				YDNAME = "";
				INSPDATE = "";
				 
				var HeadTitle3 = "|Check List for (Vendor: " + SPNAME + ", Yard Code: " + YDNAME + ", Inspection Date: " + INSPDATE + "): " + "|Verify Result|Verify Result|Verify Result|Action";
            	var HeadTitle4 = "|Check List for (Vendor: " + SPNAME + ", Yard Code: " + YDNAME + ", Inspection Date: " + INSPDATE + "): " + "|Good|Normal|Poor|Action";
				
				sheetObj.InitHeadRow(0, HeadTitle3, true);
				sheetObj.InitHeadRow(1, HeadTitle4, true);
				   

				 
				 form.fld_insp_dt.value = ComGetNowInfo();
				 
				 sheetObjects[0].Redraw = true;
				 noClick = "";
				 uploadFileSeq = "";
				 formObj.key_value.value = "";
				 fieldEnableYN();
				MnrWaitControl(false);
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowDel");
               break;
          case IBDELETE:      // 삭제
        	  if(validateForm(sheetObj,formObj,sAction)){
	        	    formObj.f_cmd.value = REMOVE;
	        	    retrieveClick = 2;
	        	    var sParam = ComGetSaveString(sheetObjects);
				    // if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					//4. 서버에 request전달하고, reponse 받기
					var sXml = sheetObj.GetSaveXml("EES_MNR_0273GS.do", sParam);
						
					sheetObjects[0].LoadSaveXml(sXml);
					sheetObjects[1].LoadSaveXml(sXml);								 
        	   }
        	//clear 
        	formObj.reset();
        	form.fld_insp_dt.value = ComGetNowInfo();
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
			 //====================================================================
			 //공통코드 호출 시작
			 //====================================================================
			 var arrXml = MnrComSearchGrid(sheetObjects[0],"com_code_search_ind");				 
			 sheetObjects[0].LoadSearchXml(arrXml[0]);
			 //end  
			     
			 noClick = "";
			 fieldEnableYN();
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
    	        } else if(formObj.yd_cd.value == "") {
    	        	ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00003'));
    	        	return;
    	        }
				break;  
	 	    case IBSAVE: // 저장
				if(retrieveClick=='0' && (formObj.vndr_seq.value == "" || formObj.vndr_seq.value == null)) {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00003', 'S/Provider'));
					return;
				} else if(retrieveClick=='0' && formObj.fld_insp_dt.value == "") {
					ComAlertFocus(formObj.fld_insp_dt, ComGetMsg('MNR00003', 'Inspection Date'));
					return;
				}else if(formObj.yd_cd.value == "") {
					ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00003', 'Yard'));
					return;
				}else if(formObj.file_seq.value == "" || formObj.file_seq.value == "undefined"){
					ComShowMessage(ComGetMsg('MNR00403'));
					return;
				}else if(!sheetObjects[0].FindStatusRow("I|U") && sheetObjects[1].FindStatusRow("I|U")){
					ComShowMessage(ComGetMsg('MNR00167'));
					return;
				}else if(formObj.yd_cd.value != null || formObj.yd_cd.value != ""){
					 var aaa = formObj.yd_cd.value;  
					 var bbb = formObj.vndr_seq.value;
					 
				    for (var idx = 1; idx <= sheetObj.RowCount; idx++){   
				        if(sheetObj.CellValue(idx,"del_chk") == '1'){  
				        	sheetObj.CellValue2(idx,"yd_cd") = aaa;       
				        	sheetObj.CellValue2(idx,"vndr_seq") = bbb;            
							sheetObj.CellValue2(idx,"fld_insp_dt")= form.fld_insp_dt.value;
				        }                 
				    }	
				}
				
				if(formObj.brnc_insp_flg.checked == false && formObj.hdbrn_insp_flg.checked == false) {
					ComShowMessage(ComGetMsg('MNR00412'));
					return;
				}
				
			    break;  
	 	    case IBDELETE: // 삭제
	 	    	if(!ComShowCodeConfirm("MNR00026")){return false;} //저장의사 확인
				if(retrieveClick=='0' && formObj.vndr_seq.value == "") {
					ComAlertFocus(formObj.vndr_seq, ComGetMsg('MNR00027'));
					return;
				}else if(retrieveClick=='0' && formObj.fld_insp_dt.value == "") {
					ComAlertFocus(formObj.fld_insp_dt, ComGetMsg('MNR00027'));
					return;
				}else if(retrieveClick=='0' && formObj.yd_cd.value == "") {
					ComAlertFocus(formObj.yd_cd, ComGetMsg('MNR00027'));
					return;
				}else{
					var sRow = sheetObj.FindStatusRow("R");
			        var arrRow = sRow.split(";");
			        for (idx=0; idx<(arrRow.length - 1); idx++){ 
			            var row = arrRow[idx];
						sheetObj.RowStatus(row)= "D";
			        }	
				}
			    break; 
	
   	    }
   	    return true;    
    }
 
	//audit Result History콤보 변경조회만  S/Provider,Yard,audit Date 변경안되게 처리
	function fieldEnableYN(){
		var formObj = document.form;
		if(noClick=="Y"){
			MnrFormSetReadOnly(formObj,true,"vndr_seq|fld_insp_dt|yd_cd");   
		}else{
			MnrFormSetReadOnly(formObj,false,"vndr_seq|fld_insp_dt|yd_cd");   
		}
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
	
				audit_result_history_search();    
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
	
	function rowRemove(sheetObj) {
		if(sheetObjects[1].Rows == "2"){
			if(sheetObj.CellValue(1, "file_dw") == "-1"){
				RemoveFileUpload(sheetObj);	
			}else{
				ComShowMessage(ComGetMsg('MNR00404'));
			}
		}else{
			if(sheetObj.FindCheckedRow("del_chk") != ""){
				if(sheetObj.CheckedRows("del_chk") != sheetObj.Rows-1){
					RemoveFileUpload(sheetObj);	
				}else{
					ComShowMessage(ComGetMsg('MNR00404'));
				}
			} else {    
				ComShowCodeMessage("MNR00150");   	   
			}	
		}
		
	}
	/**
	 * COM_ENS_061 의 값을 받은 함수      
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
   	 var formObj = document.form; 
		        
	   if(aryPopupData[0][3] != null && aryPopupData[0][3] != ""){
		   formObj.yd_cd.value = aryPopupData[0][3];
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
	   	 
		audit_result_history_search();

    }

	/**
	 * audit_result_history 조회 <br>
	 **/
	function audit_result_history_search() {  
		var formObj = document.form;
      	//콤보데이타 초기화
	    for(var i = 0; i < comboObjects.length;i++){ 
	 		 comboObjects[i].RemoveAll();	
	   	}    
	   	//콤보데이타 조회 
		var sCondition = new Array (   
			new Array("MnrOnsiteInspectionResultHistory",ComLpad(formObj.vndr_seq.value, 6, "0")+formObj.insp_ofc_cd.value,"COMMON")
		)                   
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
 		if(comboList[0] != null){
 			for(var j = 0; j < comboList[0].length;j++){ 
 				formObj.aud_rslt_his.InsertItem(j, comboList[0][j] ,comboList[0][j] );
 			}  
 		} 
 		formObj.aud_rslt_his.Code2 = "";    

	}		

    /**
     * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @param {String} 	flag   		Row Add/Row Ins의 구분값
     * @return {없음}
     **/
	function sheet_DataInsert(sheetObj){
		
		uploadFileSeq = sheetObj.CellValue(1,"file_seq");
		if(uploadFileSeq==undefined){
			uploadFileSeq="";
		}

		var row = sheetObj.SelectRow;
		var col = sheetObj.SelectCol;
		
		for(i=1;i<=sheetObj.RowCount;i++){
			if (sheetObj.CellValue(i,"org_file_nm")==""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(i,"org_file_nm");
				return;
			}
		}

		var row =sheetObj.DataInsert(-1);
	}