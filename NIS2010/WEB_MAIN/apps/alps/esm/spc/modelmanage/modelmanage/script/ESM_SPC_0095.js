/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0095.js
*@FileTitle : Import Modelship
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.22 진마리아
* 1.0 Creation
* 2013.01.22 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.07.01 [선처리] ALPS ERROR LOG 관련, SMP IMPORT시 EXCEL UPLOAD 기능으로 인해 CUSTOMER SEQUENCE에 문자열이 들어가면 에러처리
* 2013.09.04 [Trouble Shooting] 현재 유효한 PRI의 정보와 차이 나는 경우 빨간 글씨로 표시
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
* 2015/01.29 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (Import 팝업 Acct.add시 계약번호 Valid 및 MVC, C.OFC 가져옴)
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
     * @class ESM_SPC_0095 : ESM_SPC_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0095() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var dupDataColor = null;
    var errDataColor = null;

    var disableColor = null;
    var enableColor = null;
    
    var allSave = "N";
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
        /*******************************************************/
    	var formObject = document.form;

       	try {
       		var srcName = window.event.srcElement.getAttribute("name");

       		switch(srcName) {
	       		case "btn_retrieve":
	       			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	       			break;
	       			
       			case "btn_add":
       				var row = sheetObjects[0].DataInsert(-1);
       				sheetObjects[0].CellValue(row, "cust_ctrl_cd")="";
       				break;

       			case "btn_save":
       				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
       				break;
       				
       			case "btn_upload":
       				if(formObject.pop_yn.value!="Y" && formObject.trade.Code == ""){ //비수기용에는 trade가 조회 필수
       					ComShowMessage("Please choose a Trade.");
       					formObject.trade.focus();
       					break;
       		 		}
       				
       				sheetObjects[0].LoadExcel(true, 1, "", 1, -1, "", false);
       				allSave = "Y";
       				
       				if(formObject.pop_yn.value == "N") {
       					validateUpload(sheetObjects[0],formObject);       					
       				}
       				break;
       				
       			case "btn_downexcel":
       				//data down
       				sheetObjects[0].Down2Excel(-1, false, false, true, "", "", false, false, "", false, "del_chk");
       				break;
       				
       			case "btn_template_down":
       				if(formObject.pop_yn.value!="Y" && formObject.trade.Code == ""){ //비수기용에는 trade가 조회 필수
       					ComShowMessage("Please choose a Trade.");
       					formObject.trade.focus();
       					break;
       		 		}
       				var codeCombo = sheetObjects[0].GetComboInfo(0,"cust_ctrl_cd","Code");
   					var arrCode = codeCombo.split("|");
   					
   					for(var i=0; i<arrCode.length; i++){
   						var row = sheetObjects[1].DataInsert(-1);
   						sheetObjects[1].CellValue(row, "cust_ctrl_cd") = arrCode[i];
   					}
   					//template down
   					sheetObjects[1].SpeedDown2Excel(-1);
   					sheetObjects[1].RemoveAll();
       				break;

       			case "btn_close":
       				window.returnValue = formObject.ver_seq.value;
       				self.close();
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
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        initSheetCombo_custCtrlCd(sheetObjects[0]);

        var formObj = document.form;
        if(formObj.pop_yn.value=="N"){
        	SpcSearchOptionTrade("trade", false);
        }else{
        	handlingSheetByTrade(formObj.trade.value);
        	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        	if(formObj.only_read.value=="Y"){
        		ComBtnDisable("btn_add");
        		ComBtnDisable("btn_save");
        		ComBtnDisable("btn_upload");
        	}
        }
        
        dupDataColor = sheetObjects[0].RgbColor(204, 255, 253);//blue
        errDataColor = sheetObjects[0].RgbColor(255, 255, 128);//yellow
        disableColor = sheetObjects[0].RgbColor(239, 240, 243);//grey
        enableColor = sheetObjects[0].RgbColor(255, 255, 255);//white
        //        setCategoryCode();
        
    }

    function initControl() {
		axon_event.addListenerForm('change', 'obj_change', document.form);
	}
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    
                    style.height = 450;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false, false)
                  
                    var HeadTitle = "|Del|Seq|Account\n(Group)|Account\n(Group)|Account\n(Individual)|Account\n(Individual)|SC#|RFA#|";
                    
                    if(document.form.pop_yn.value=="Y" && (document.form.trade.value == "TPS" || document.form.trade.value == "AES" || document.form.trade.value=="IAS") ){
                    	HeadTitle = HeadTitle + "MVC WK\n(TEU)|Yield\nGroup|C.OFC";
                    }else{
                    	HeadTitle = HeadTitle + "Yield\nGroup|C.OFC";
                    }
                    
                    if(document.form.pop_yn.value=="Y"){
                    	HeadTitle = HeadTitle + "|PIC|SC-YN|RFA-YN|SC_RFA_FLG";
                    } else{
                    	HeadTitle = HeadTitle + "|SUB TRD|SUB TRD 1|SUB TRD 2|SUB TRD 3|SUB TRD 4|SUB TRD 5|SC-YN|RFA-YN|SC_RFA_FLG";
                    }
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	60,	daCenter,	false,		"ibflag");
                    InitDataProperty(0, cnt++ , dtDelCheck,	50,		daCenter,	false,		"del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,		60,		daCenter,	false,		"seq",   			false,	"",			dfNone,			0,		false,  false);
    				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,		"cust_grp_id",		false,	"",			dfNone,			0,		false,  true, 20);
    				InitDataProperty(0, cnt++ , dtData,		160,	daLeft,		false,		"cust_grp_nm",		false,	"",			dfNone,			0,		false,  false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"cust_cd",			false,	"",			dfNone,			0,		false,  true, 8);
    				InitDataProperty(0, cnt++ , dtData,		160,	daLeft,		false,		"cust_lgl_eng_nm",	false,	"",			dfNone,			0,		false,  false);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"sc_no",			true,	"",			dfNone,			0,		false,  true, 20);
    				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"rfa_no",			false,	"",			dfNone,			0,		false,  true, 20);
    				if(document.form.pop_yn.value=="Y" && (document.form.trade.value == "TPS" || document.form.trade.value=="AES" || document.form.trade.value=="IAS") ){
    					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,		"wk_mqc_qty",		false,	"",			dfNullFloat,	1,		true,  true, 18);
    				}
    				InitDataProperty(0, cnt++ , dtCombo,	60,		daCenter,	false,		"cust_ctrl_cd",		true,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,		"ctrt_ofc_cd",		false,	"",			dfNone,			0,		false,  false);
    				if(document.form.pop_yn.value=="Y"){
    					InitDataProperty(0, cnt++ , dtData,		   80,		daLeft,		false,		"acct_pic_nm",	false,	"",			dfNone,	   	0,		true,  true, 100);
    				} else {
    					InitDataProperty(0, cnt++ , dtHidden,  		     80,	daCenter,   true,	 "sub_trd_cd",		false,			"",		  dfNone,		0,	   true,	  true);
    					InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_1",     	true,           "",       dfNone,       0,     true,      true,		2);
    					InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_2",     	false,          "",       dfNone,       0,     true,      true,		2);
    					InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_3",     	false,          "",       dfNone,       0,     true,      true,		2);
    					InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_4",     	false,          "",       dfNone,       0,     true,      true,		2);
    					InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_5",     	false,          "",       dfNone,       0,     true,      true,		2);    					
    				}
    				InitDataProperty(0, cnt++ , dtHidden		,    30,    daCenter,   true,    "crnt_sc_yn",     	false,          "",       dfNone,       0,     false,      false);    					
    				InitDataProperty(0, cnt++ , dtHidden		,    30,    daCenter,   true,    "crnt_rfa_yn",    	false,          "",       dfNone,       0,     false,      false);    					
    				InitDataProperty(0, cnt++ , dtHidden		,    30,    daCenter,   true,    "sc_rfa_flg",    	false,          "",       dfNone,       0,     false,      false);    					
    				
    				InitDataValid(0, "cust_grp_id", vtEngUpOther, "0123456789-");
    				InitDataValid(0, "cust_cd"    , vtEngUpOther, "0123456789");
    				InitDataValid(0, "sc_no"      , vtEngUpOther, "0123456789");
    				InitDataValid(0, "rfa_no"     , vtEngUpOther, "0123456789");
    				
//    				InitDataCombo(0, "cust_ctrl_cd", "A|B", "A|B");

    				EditableColorDiff = true;
    				SelectHighLight = false;
               }
            break;

            case 2:      //template
            with (sheetObj) {
            	// 높이 설정
            	style.height = 0;
            	
            	//전체 너비 설정
            	SheetWidth = mainTable.clientWidth;
            	
            	//Host정보 설정[필수][HostIp, Port, PagePath]
            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            	
            	//전체Merge 종류 [선택, Default msNone]
            	MergeSheet = msHeaderOnly;
            	
            	//전체Edit 허용 여부 [선택, Default false]
            	Editable = true;
            	
            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	InitRowInfo( 1, 1, 9, 100);
            	
            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, false, false, true, false, false)
            	
            	var HeadTitle = "Account\n(Individual)|SC#|RFA#|Yield\nGroup";
            	if(document.form.pop_yn.value=="Y"){
                	HeadTitle = HeadTitle + "|PIC";
                }else{
                	HeadTitle = HeadTitle + "|SUB TRD 1|SUB TRD 2|SUB TRD 3|SUB TRD 4|SUB TRD 5";                	
                }
            	
            	var headCount = ComCountHeadTitle(HeadTitle);
            	
            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 0, 0, false);
            	
            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle, true);
            	
            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//            	InitDataProperty(0, cnt++ , dtSeq,		60,		daCenter,	false,		"seq",   			false,	"",			dfNone,			0,		false,  false);
            	InitDataProperty(0, cnt++ , dtData,		150,		daCenter,	false,		"cust_cd",			false,	"",			dfNone,			0,		true,  true);
            	InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"sc_no",			false,	"",			dfNone,			0,		true,  true);
            	InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,		"rfa_no",			false,	"",			dfNone,			0,		true,  true, 20);
            	InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,		"cust_ctrl_cd",		false,	"",			dfNone,			0,		true,  true);
            	if(document.form.pop_yn.value=="Y"){
					InitDataProperty(0, cnt++ , dtData,		80,	   daLeft,		false,		"acct_pic_nm",	false,	"",			dfNone,			0,		true,  true);
				} else {
					InitDataProperty(0, cnt++ , dtData		,    80,    daCenter,   true,    "sub_trd_1",     	true,           "",       dfNone,       0,     true,      true,		2);
					InitDataProperty(0, cnt++ , dtData		,    80,    daCenter,   true,    "sub_trd_2",     	false,          "",       dfNone,       0,     true,      true,		2);
					InitDataProperty(0, cnt++ , dtData		,    80,    daCenter,   true,    "sub_trd_3",     	false,          "",       dfNone,       0,     true,      true,		2);
					InitDataProperty(0, cnt++ , dtData		,    80,    daCenter,   true,    "sub_trd_4",     	false,          "",       dfNone,       0,     true,      true,		2);
					InitDataProperty(0, cnt++ , dtData		,    80,    daCenter,   true,    "sub_trd_5",     	false,          "",       dfNone,       0,     true,      true,		2);
				}
            	
//            	InitDataCombo(0, "cust_ctrl_cd", "A|B", "A|B");
            }
            break;
        } 
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				
    				var param = SpcFormString(formObj,"f_cmd,trade,cost_yrwk,ver_seq,pop_yn");
    				
    				var rtnXml = sheetObj.GetSearchXml("ESM_SPC_0095GS.do", param);
    				
    				sheetObj.LoadSearchXml(rtnXml);
    				
    				if(formObj.pop_yn.value=="N"){
    					initSheetCombo_subtrade(sheetObj);
    				}
    				
    				sheetObj.ReDraw=true;
    			}
            break;

    		case IBSAVE:
    			if (validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value = MULTI;

    				//pic만 수정한 경우, rowStatus를 R로 가져감(history에 남기지 않기 때문)
    				if(formObj.pop_yn.value=="Y"){
    					setStatus(sheetObj);
    				}

    				var saveStr = ComGetSaveString(sheetObj, true, true);

    				if(saveStr == "") return;
    				
    				sheetObj.ReDraw=false;
    				var sXml = sheetObj.GetSaveXml("ESM_SPC_0095GS.do", saveStr +"&"+FormQueryString(formObj)+"&all_save="+allSave);
    				sheetObj.ReDraw=true;
    				
    				var errList = ComGetEtcData(sXml, "err_data");
    				
    				if(formObj.pop_yn.value=="Y"){
    					var newVer = ComGetEtcData(sXml, "new_ver");
    					if(newVer!=undefined){
    						if(formObj.ver_seq.value != newVer){
    							ComShowMessage("New version '"+newVer+"' is created.")
    							formObj.ver_seq.value = newVer;
    						}
    					}
    				}

    				if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
	    				if(errList != ""){
	    					
	    					if ( ComGetObjValue(formObj.trade) == "AES" || ComGetObjValue(formObj.trade) == "IAS" ) {
	    						ComShowMessage(getMsg("SPC90145"));
	    					} else {
	    						ComShowMessage(getMsg("SPC90138"));
	    					} 
	    					
	    					var errAry = errList.split("|");

	    					for(var i=0; i<errAry.length; i++){
	    						sheetObj.RowBackColor(sheetObj.HeaderRows+Number(errAry[i])-1) = errDataColor;
	    					}
	    					for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    							if(sheetObj.RowBackColor(i)!=errDataColor){
    								sheetObj.RowStatus(i) = "R";
    							}else{
    								sheetObj.RowStatus(i) = "I";
    							}
	    					}
	    					
	    					sheetObj.SelectCell(sheetObj.HeaderRows+Number(errAry[0]), "ibflag");
	    					
    					}else{
    						ComShowCodeMessage("COM130102", "Data");
    						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    					}
//	    				sheetObj.LoadSaveXml(sXml);
	    				allSave = "N";
    				}else{
    					var resultMsg = ComSpcGetMessageFromXml(sXml);
    					
    					if(resultMsg != ""){
    						ComShowMessage(resultMsg);
    					}
    				}
    			}
    		break;
    	}
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
	 	case IBSEARCH:
	 		if(formObj.pop_yn.value=="Y" && (formObj.cost_yrwk.value=="" || formObj.ver_seq.value=="" || formObj.trade.value=="")){
	 			ComShowCodeMessage("COM130406", "Account List");
	 			return false;
	 		}
	 		
	 		if(formObj.pop_yn.value!="Y" && formObj.trade.Code == ""){ //비수기용에는 trade가 조회 필수
	 			ComShowMessage("Please choose a Trade.");
	 			formObj.trade.focus();
	 			return false;
	 		}
	 		break;
	 		
	 	case IBSAVE:
	 		if(sheetObj.RowCount==0){
	 			return false;
	 		}
	 		//본래 색으로 되돌림
	 		setOrgBackColor(sheetObj);
	 		
	 		if((formObj.pop_yn.value=="N" && formObj.trade.Code != "TPS") || (formObj.pop_yn.value=="Y" && formObj.trade.value != "TPS")){ //TPS 제외한 경우, individual customer 가 필수
	 			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	 				if(sheetObj.CellValue(i, "cust_cd")==""){
		 				ComShowMessage("In case of not TPS, Individual Account Code is a mandatory item.");
		 				sheetObj.SelectCell(i, "cust_cd");
		 				return false;
		 			}
	 			}
	 		}
	 		
	 		if ( formObj.trade.Code == "AES" || formObj.trade.value == "AES" || formObj.trade.Code == "IAS" || formObj.trade.value == "IAS" ) {
	 			sheetObj.SpaceDupCheck = true;
 				var rtn = sheetObj.ColValueDupRows("cust_cd|cust_ctrl_cd|rfa_no", false, true);
 				
 				if(rtn!=""){
	 				var rtnAry1 = rtn.split("|");
	 				for(var i=0; i<rtnAry1.length; i++){
	 					if(rtnAry1[i].indexOf(",")>=0){
	 						var rtnAry2 = rtnAry1[i].split(",");
	 						for(var j=0; j<rtnAry2.length; j++){
	 							sheetObj.RowBackColor(rtnAry2[j]) = dupDataColor;
	 						}
	 						sheetObj.SelectCell(rtnAry2[0], "ibflag");
	 					}else{
	 						sheetObj.RowBackColor(rtnAry1[i]) = dupDataColor;
	 						sheetObj.SelectCell(rtnAry1[0], "ibflag");
	 					}
	 				}
	 				ComShowMessage(getMsg("SPC90135"));
	 				return false;
	 			}
	 		} else if((formObj.pop_yn.value=="N" && formObj.trade.Code != "TPS") || (formObj.pop_yn.value=="Y" && formObj.trade.value != "TPS")){//TPS 제외 Individual Customer로 중복체크
	 			sheetObj.SpaceDupCheck = true;
 				var rtn = sheetObj.ColValueDupRows("cust_cd", false, true);
 				
 				if(rtn!=""){
	 				var rtnAry1 = rtn.split("|");
	 				for(var i=0; i<rtnAry1.length; i++){
	 					if(rtnAry1[i].indexOf(",")>=0){
	 						var rtnAry2 = rtnAry1[i].split(",");
	 						for(var j=0; j<rtnAry2.length; j++){
	 							sheetObj.RowBackColor(rtnAry2[j]) = dupDataColor;
	 						}
	 						sheetObj.SelectCell(rtnAry2[0], "ibflag");
	 					}else{
	 						sheetObj.RowBackColor(rtnAry1[i]) = dupDataColor;
	 						sheetObj.SelectCell(rtnAry1[0], "ibflag");
	 					}
	 				}
	 				ComShowMessage(getMsg("SPC90135"));
	 				return false;
	 			}
	 		}else{ //TPS는 SC로 중복체크
	 			//중복체크
	 			sheetObj.SpaceDupCheck = true;
	 			var rtn = sheetObj.ColValueDupRows("sc_no", false, true);
	 			
	 			if(rtn!=""){
	 				var rtnAry1 = rtn.split("|");
	 				for(var i=0; i<rtnAry1.length; i++){
	 					if(rtnAry1[i].indexOf(",")>=0){
	 						var rtnAry2 = rtnAry1[i].split(",");
	 						for(var j=0; j<rtnAry2.length; j++){
	 							sheetObj.RowBackColor(rtnAry2[j]) = dupDataColor;
	 						}
	 						sheetObj.SelectCell(rtnAry2[0], "ibflag");
	 					}else{
	 						sheetObj.RowBackColor(rtnAry1[i]) = dupDataColor;
	 						sheetObj.SelectCell(rtnAry1[0], "ibflag");
	 					}
	 				}
	 				ComShowMessage(getMsg("SPC90135"));
	 				return false;
	 			}
	 		}
	 		
	 		if(allSave != "Y"){
	 			// Edit 가능한 cust_ctrl_cd, sub_trd_cd 의 정보가 조회시의 값과 동일하면 ibflag 를 R 로 변경
		 		var sRow         = sheetObj.FindStatusRow("I|U");
	    		var sArr         = sRow.split(";");
	    		var cust_ctrl_cd = "";
	    		var sub_trd_cd   = "";
	    		
	    		for(var i=0; i < sArr.length - 1; i++) {
	    			cust_ctrl_cd = sheetObj.CellSearchValue(sArr[i], "cust_ctrl_cd");
	    			sub_trd_cd   = sheetObj.CellSearchValue(sArr[i], "sub_trd_cd");

	    			if(cust_ctrl_cd == sheetObj.CellValue(sArr[i], "cust_ctrl_cd") && sub_trd_cd == sheetObj.CellValue(sArr[i], "sub_trd_cd")) {
	    				sheetObj.CellValue2(sArr[i], "ibflag") = "R"; 
	    			}
	    		}
	 		}
	 		
	 		break;
		}
    	return true;
    }
    
    function trade_OnChange(comObj, value, text ){
    	sheetObjects[0].RemoveAll();
    	handlingSheetByTrade(value);
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
    function setOrgBackColor(sheetObj){
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
 			if(sheetObj.RowBackColor(i)==dupDataColor || sheetObj.RowBackColor(i)==errDataColor){
 				sheetObj.CellBackColor(i, "del_chk") = enableColor;
 				sheetObj.CellBackColor(i, "seq") = disableColor;
 				sheetObj.CellBackColor(i, "cust_grp_id") = disableColor;
 				sheetObj.CellBackColor(i, "cust_grp_nm") = disableColor;
 				sheetObj.CellBackColor(i, "cust_cd") = disableColor;
 				sheetObj.CellBackColor(i, "cust_lgl_eng_nm") = disableColor;
 				sheetObj.CellBackColor(i, "sc_no") = disableColor;
 				sheetObj.CellBackColor(i, "rfa_no") = disableColor;
 				if(document.form.pop_yn.value=="Y" && (document.form.trade.value == "TPS" || document.form.trade.value == "AES" || document.form.trade.value == "IAS") ){
 					sheetObj.CellBackColor(i, "wk_mqc_qty") = enableColor;
 				}
 				sheetObj.CellBackColor(i, "cust_ctrl_cd") = enableColor;
 			}
 		}
    }
    
    function handlingSheetByTrade(trade){
    	var sheetObj1 = sheetObjects[0];
    	var sheetObj2 = sheetObjects[1];
    	
    	if ( trade == "TPS" ) {
    		sheetObj1.ColHidden("sc_no") = false;
    		sheetObj2.ColHidden("sc_no") = false;
    		sheetObj1.InitDataProperty(0, sheetObj1.SaveNameCol("sc_no"), dtData, 80, daCenter,	false, "sc_no", true, "", dfNone, 0, false,  true, 20);//필수
    		
    		sheetObj1.ColHidden("rfa_no") = true;
    		sheetObj2.ColHidden("rfa_no") = true;
    	} else if ( trade == "AES" || trade == "IAS") {
    		sheetObj1.ColHidden("sc_no") = true;
    		sheetObj2.ColHidden("sc_no") = true;
    		sheetObj1.InitDataProperty(0, sheetObj1.SaveNameCol("sc_no"), dtData, 80, daCenter,	false, "sc_no", false, "", dfNone, 0, false,  true, 20);//안필수
    		
    		sheetObj1.ColHidden("rfa_no") = false;
    		sheetObj2.ColHidden("rfa_no") = false;
    	} else {
    		sheetObj1.ColHidden("sc_no") = true;
    		sheetObj2.ColHidden("sc_no") = true;
    		sheetObj1.InitDataProperty(0, sheetObj1.SaveNameCol("sc_no"), dtData, 80, daCenter,	false, "sc_no", false, "", dfNone, 0, false,  true, 20);//안필수
    		
    		sheetObj1.ColHidden("rfa_no") = true;
    		sheetObj2.ColHidden("rfa_no") = true;
    	}
    }
    
    function setStatus(sheetObj){
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    		if(sheetObj.RowStatus(i) == "U"){
    			if(sheetObj.CellValue(i, "wk_mqc_qty")==sheetObj.CellSearchValue(i, "wk_mqc_qty") 
    					&& sheetObj.CellValue(i, "cust_ctrl_cd")==sheetObj.CellSearchValue(i, "cust_ctrl_cd") ){
    				sheetObj.RowStatus(i) = "R";
    			}
    		}
    	}
    }
    
    /**
     * Sheet1 의 정보 변경시 
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     */
    function sheet1_OnChange(sheetObj, row, col, value){
    	var formObj = document.form;
    	var sName = sheetObj.ColSaveName(col);
    	switch(sName){
	    	case "sub_trd_1":
	    	case "sub_trd_2":
	    	case "sub_trd_3":
	    	case "sub_trd_4":
	    	case "sub_trd_5":
	    		var text = getSheetComboText(sheetObj, row, col, 1);
	    		sheetObj.CellValue2(row, col) = text;
	    		
	    		if(text == "ALL") {
	    			var sCode   = sheetObj.GetComboInfo(row, col, "Code");
	    			var arrCode = sCode.split("|");
	    			
	    			// Sub Trade 1 ~ 5 까지
	    			for(var i=1; i < 6; i++) {
	    				// arrCode 에서 최초의 NULL 제외 : - 1
	    				if(i < arrCode.length - 1) {
	    					// arrCode 에서 ALL 때문에 : + 1
	    					sheetObj.CellValue2(row, "sub_trd_" + i) = arrCode[i+1];
	    				} else {
	    					sheetObj.CellText(row, "sub_trd_" + i) = " ";
	    				}
	    			}
	    		}
	    		
	    		// Sub Trade 중복 제거 로직
				var chk  = "true";
		    	var arr1 = new Array();
		    	var arr2 = new Array();
		    	arr1[0] = ComTrim(sheetObj.CellValue(row, "sub_trd_1"));
		    	arr1[1] = ComTrim(sheetObj.CellValue(row, "sub_trd_2"));
		    	arr1[2] = ComTrim(sheetObj.CellValue(row, "sub_trd_3"));
		    	arr1[3] = ComTrim(sheetObj.CellValue(row, "sub_trd_4"));
		    	arr1[4] = ComTrim(sheetObj.CellValue(row, "sub_trd_5"));
		    	
		    	for(var i=0; i < arr1.length; i++) {
		    		for(var j=0; j < arr2.length; j++) {
		    			if(arr1[i] == arr2[j]) chk = "false";
		    		}
		    		        		
		    		if(arr1[i] != "" && chk == "true") arr2[arr2.length] = arr1[i];
		    		
		    		chk = "true";
		    	}
		    	
		    	sheetObj.CellValue2(row, "sub_trd_cd") = arr2;
	    		break;
	    	
	    	//sc_no 나 rfa_no 입력시 유효성 체크 및 해당하는 MVC, C.OFC를 가져옴.
	    	case "sc_no":
	    	case "rfa_no":
	    	case "cust_cd":	
	    		var sc_no 	= sheetObj.CellValue(row, "sc_no");
	    		var rfa_no 	= sheetObj.CellValue(row, "rfa_no");
	    		//sc_no 나 rfa_no 입력시
	    		if(sc_no != "" || rfa_no != ""){
					formObj.f_cmd.value = SEARCHLIST01;
    				var param = "f_cmd="		+ ComGetObjValue(formObj.f_cmd)
    						  +	"&cost_yrwk="   + ComGetObjValue(formObj.cost_yrwk)
	          		 		  + "&ver_seq="     + ComGetObjValue(formObj.ver_seq)
	          		 		  + "&trade="       + ComGetObjValue(formObj.trade)
	          		 		  + "&sc_no="       + sheetObj.CellValue(row, "sc_no")
    		 		  		  + "&rfa_no=" 		+ sheetObj.CellValue(row, "rfa_no");
		    		
    				var sXml = sheetObj.GetSearchXml("ESM_SPC_0095GS.do", param);
    				
    				var acctData = ComGetEtcData(sXml, "acctData");
    				
    				//유효하지 않은 계약번호
    				if(acctData == null || acctData == ""){
    					ComShowMessage(getMsg("SPC90306", sc_no+rfa_no)); //'Contract No (' + msg1 + ') is invalid.'
    					sheetObj.CellValue2(row, "cust_cd") 	= "";
    					sheetObj.CellValue2(row, "cust_grp_id") = "";
						sheetObj.CellValue2(row, "sc_no")   	= "";
						sheetObj.CellValue2(row, "rfa_no")  	= "";
						sheetObj.CellValue2(row, "wk_mqc_qty")  = "";
						sheetObj.CellValue2(row, "ctrt_ofc_cd") = "";
					//유효한 계약번호일 경우 찾아온 데이터 시트에 입력	
    				}else{
    					var acctDataAry = acctData.split("|");
    					for(var i=0; i<acctDataAry.length; i++){
    						sheetObj.CellValue(row, "cust_cd") 	   = acctDataAry[0];
    						sheetObj.CellValue(row, "cust_grp_id") = acctDataAry[1];
    						sheetObj.CellValue(row, "wk_mqc_qty")  = acctDataAry[2];
    						sheetObj.CellValue(row, "ctrt_ofc_cd") = acctDataAry[3];
    					}
    				}
    			//sc_no 나 rfa_no 지웠을 경우
	    		}else{
					sheetObj.CellValue2(row, "sc_no")       = "";
					sheetObj.CellValue2(row, "rfa_no")  	= "";
					sheetObj.CellValue2(row, "cust_grp_id") = "";
					sheetObj.CellValue2(row, "wk_mqc_qty")  = "";
					sheetObj.CellValue2(row, "ctrt_ofc_cd") = "";
	    		}
	    		break;
    	}
    }
    
    /**
     * 조회 시점에 유효한 계약아 아닐 경우 빨간색으로 글씨를 적어준다.
     * (PRI 계약을 확인하고 Flag를 리턴한것)
     * 
     * @param sheetObj
     * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
    	var trd_cd = formObj.trade.value;
    	
    	if(trd_cd == "TPS" || trd_cd == "AES" || trd_cd == "IAS"){
    		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    			if ( trd_cd == "TPS" && sheetObj.CellValue(i, "crnt_sc_yn") == "N" ){
    				sheetObj.RowFontColor(i) = sheetObj.RgbColor(237,28,36);
    			}
    			if ( (trd_cd == "AES" || trd_cd == "IAS") && !( sheetObj.CellValue(i, "crnt_rfa_yn") == "Y" || sheetObj.CellValue(i, "crnt_sc_yn") == "Y" ) ){
    				sheetObj.RowFontColor(i) = sheetObj.RgbColor(237,28,36);
    			}
    		}
    	}
    }
    
    /**
     * Up Load 값의 유효성 체크
     */
    function validateUpload(sheetObj,formObj) {
    	var txet;
    	var col;
    	
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			col = sheetObj.SaveNameCol("sub_trd_5"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_5") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_4"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_4") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_3"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_3") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_2"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_2") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_1"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_1") = text;
    		
    		sheet1_OnChange(sheetObj, i, col, text);
    	}
    }
    
    /**
	 * 화면 loading 시 Sheet 의 Combo 세팅
	 */
	function initSheetCombo_subtrade(sheetObj, ErrMsg){
		var formObj = document.form;
		var trade;
				
		var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true&trdCd=" + formObj.trade.Code);
        
        var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
        
        arrData[0] = " |ALL|" + arrData[0];
        arrData[1] = "\t \t|\tALL\t|" + arrData[1];
        
    	sheetObj.InitDataCombo(0, "sub_trd_1", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_2", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_3", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_4", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_5", arrData[1], arrData[0], "", "", 1);
	}
	
	/**
	 * TRADE, SEASON 에 해당하는 CUSTOMER GROUP을 셋팅한다.
	 */
	function initSheetCombo_custCtrlCd(sheetObj){
		var formObj = document.form;
		var arrData;
		
		if(formObj.pop_yn.value=="Y"){
			var param = "trd_cd=" + formObj.trade.value + "&cost_yrwk=" + formObj.cost_yrwk.value;
			var rtn = getCodeXmlList("CustGrp", param);
			arrData = SpcXml2ComboItem(rtn, "code", "code|text");
		}else{
			arrData = ['A|B', 'A	Control|B	Protection'];
		}
		
		var cdDesc = arrData[1].replace(/\t/gi, " : ");
		var cdDescArr = cdDesc.split("|");
		var cdDescTxt;
		for(var i=0; i<cdDescArr.length; i++){
			if(i==0){
				cdDescTxt = cdDescArr[i];
			}else{
				cdDescTxt = cdDescTxt + "\n   " + cdDescArr[i];
			}
		}
		document.getElementById("ctrl_cd_desc").innerText = "* " + cdDescTxt;
		
		sheetObj.InitDataCombo(0, "cust_ctrl_cd", arrData[1], arrData[0]);
	}
	 
	 /**
	  *  sXml에서 MESSAGE 내용을 추출 
	  * @param sXml
	  * @return Sring MESSAGE
	  * @author jkc
	  */
	 function ComSpcGetMessageFromXml(sXml){
	     if ( sXml == null  || sXml == "" ) return;

	     try {
	         var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
	         xmlDoc.loadXML(sXml);

	         var xmlRoot = xmlDoc.documentElement;
	         if(xmlRoot == null) return;

	         var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
	       
	         if(msgNode == null) return "";

	         return msgNode.firstChild.nodeValue;
	     } catch(err) { ComFuncErrMsg(err.message); }
	 } 
	/* 개발자 작업  끝 */