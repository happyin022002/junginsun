/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0652.js
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.04 김병규
* 1.0 Creation
* 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
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
     * @class esm_bkg_0652 : esm_bkg_0652 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0652() {
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1]; 
        var sheetObject3 = sheetObjects[2];		         
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)){
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						sheetObject3.RemoveAll();
						doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					}
				break;
				
				case "btn_Add":
					sheetObject3.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가 
				break;
				
				case "btn_Delete":
					ComRowHideDelete(sheetObject3,"chk");
				break;
				
				case "btn_Save":
					if(validateForm(sheetObject3,formObject,IBSAVE)){
						doActionIBSheet(sheetObject3, formObject, IBSAVE);
					}
				break;

				case "btn_Select":
					if(validateSelect(sheetObject1, sheetObject3, formObject)){
						var rArray = getLocalCheckedRows(sheetObject1);
						comPopupSend(sheetObject1, sheetObject2, sheetObject3, formObject);	
					}
				break; 							
				
				case "btn_Close":
					window.close();
				break;						
				
				case "btn_DownExcel":
					sheetObject3.Down2Excel(-1);
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");     			
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
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);            
        }        
 		if(document.form.bkgCustTpCd.value=="S"){
 			sheetObjects[0].ColHidden("frt_fwrd_fmc_no") = true;
 		} else if(document.form.bkgCustTpCd.value=="F"){
 			sheetObjects[2].ColHidden("fwrd_cnt_cd") = true; 
 		}
 		
 		var formObj = document.form;
 		if(document.form.cust_cnt_cd.value !="US"){
 			formObj.area_cd.className = "input2";
 			formObj.area_cd.readOnly = true;
 		}else{
 			formObj.area_cd.className = "input";
 			formObj.area_cd.readOnly = false;
 		}
 		if(document.form.ui_id.value == "ESM_BKG_0079_05"){
 			sheetObjects[2].style.height = 0;
 			BkgEnableObject(formObj.cust_cnt_cd, false);
 			BkgEnableObject(formObj.cust_seq, false);
 			BkgEnableObject(formObj.cust_nm, false);
 			BkgEnableObject(formObj.include, false);
 			BkgEnableObject(formObj.no_use, false);
 			BkgEnableObject(formObj.bklst, false);
 			BkgEnableObject(formObj.ofc_cd, false);
 			BkgEnableObject(formObj.cty_nm, false);
 			BkgEnableObject(formObj.ste_cd, false);
 			BkgEnableObject(formObj.zip_cd, false);
 			BkgEnableObject(formObj.area_cd, false);
 		}
    }

   	function initControl() {
   	 	var formObject = document.form;   	
        axon_event.addListenerFormat('keypress', 'bkg0652_keypress', formObject); //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('change'				, 'cust_cnt_cd_OnChange'	, form);
        axon_event.addListenerForm('change'				,'bklst_OnChange', form);
        
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 180;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Status|Type|Code|Name|S.OFC|City|Location code|State|Customer Address|Zip Code|TEL|FMC|||||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   		30,    	daCenter,  		false,     "ibflag");              
	                InitDataProperty(0, cnt++ , dtRadioCheck,			40,     daCenter,    	false,     "chk");
					InitDataProperty(0, cnt++ , dtData,					70,     daCenter,    	false,     "pb",				   	false,    "",      dfNone, 		0,     false,		false);
//					InitDataProperty(0, cnt++ , dtData, 		 		80,    daCenter,	    false,     "r_bklst",   			false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      			55,     daCenter,    	false,     "cust_div_flag", 		false,    "",      dfNone, 		0,     false,		false);
			 		InitDataProperty(0, cnt++ , dtData,      			70,     daLeft,    		false,     "customer_code",     	false,    "",      dfNone, 		0,     false,		false,		8);
                    InitDataProperty(0, cnt++ , dtData, 		 		225,   	daLeft,    	 	false,     "cust_lgl_eng_nm",   	false,    "",      dfNone, 		0,     false,		false,		35);
                    InitDataProperty(0, cnt++ , dtData,      			55,     daCenter,	   	false,     "ofc_cd",      			false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 		 		70,     daCenter,	     	false,     "cty_nm",   			false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData,     			150,    daCenter,  false,    	 	"location_code",   			false,          "",       dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData, 		 		70,     daCenter,	     	false,     "ste_cd",   			false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 		 		300,    daLeft,	     	false,     "bzet_addr",   			false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 		 		70,     daCenter,	     	false,     "zip_cd",   			false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 		 		50,    daCenter,	     	false,     "phn_no",   			false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      			55,     daCenter,    	false,     "frt_fwrd_fmc_no", 		false,    "",      dfNone, 		0,     false,		false);
					
					

					InitDataProperty(0, cnt++ , dtHidden,	   			30,    	daCenter,  		false,     "cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     "cust_seq");
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     "delt_flg");  
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     "ar_ofc");  
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     "srep_nm");  
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     "cust_rlse_ctrl_rmk"); 
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     "no_use_rsn");         
					
               	}
                break;

            case "sheet2":      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 180;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone] 
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|S.OFC|S.REP|S.REP Name";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   	30,    daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtData,      		40,    daCenter,    false,     	"ofc_cd",       false,    "",      dfNone, 		0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      		50,    daCenter,    false,     	"srep_cd",   	false,    "",      dfNone, 		0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      		150,   daLeft,      false,     	"srep_nm",   	false,    "",      dfNone, 		0,     true,		true);
                }
                break;
                  
            case "sheet3":      //sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Part|Contact Person|Tel|Mobile|Fax|E-mail|FWDR Code|Remark(s)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   	30,    	daCenter,  		false,   	"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,		40,     daCenter,    	false,     	"chk",     				false,    "",      dfNone, 		0,     true,		true);
					InitDataProperty(0, cnt++ , dtCombo,     		50,     daLeft,   	 	false,     	"bkg_cntc_pson_tp_cd", 	false,    "",      dfNone, 		0,     true,		true);
					InitDataProperty(0, cnt++ , dtData, 		 	150,   	daLeft,    		false,     	"cntc_pson_nm",  		false,    "",      dfNone, 		0,     true,		true,		100);
					InitDataProperty(0, cnt++ , dtData,      		190,    daLeft,    		false,     	"phn_no",   	 		false, 	  "",      dfNone, 		0,     true,		true,		50);                                                              	                                                                                   
					InitDataProperty(0, cnt++ , dtData,      		190,    daLeft,    		false,     	"cntc_pson_mphn_no", 	false,    "",      dfNone, 		0,     true,		true,		50);
                    InitDataProperty(0, cnt++ , dtData,      		190,    daLeft,	   		false,     	"fax_no",     	 		false,    "",      dfNone, 		0,     true,		true,		50);
					InitDataProperty(0, cnt++ , dtData, 		 	165,    daLeft,	   		false,     	"cntc_eml",   			false,    "",      dfNone, 		0,     true,		true,		200);
                    InitDataProperty(0, cnt++ , dtData,      		75,     daCenter,	   	false,     	"fwrd_cnt_cd",     		false,    "", 	   dfNone, 		0,     true,		true,		8);
					InitDataProperty(0, cnt++ , dtData, 		 	100,    daLeft,		   	false,     	"diff_rmk",   			false,    "",      dfNone, 		0,     true,		true,		50);
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  		false,      "cntc_pson_seq");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  		false,      "cust_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  		false,      "cust_seq");

					InitDataValid(0,  "fwrd_cnt_cd",			vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
					InitDataCombo(0,  "bkg_cntc_pson_tp_cd", " |A - All|B - BKG|S - S/I", " |AL|BK|SI");
            	}
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0652GS.do" , FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
	 		
//				if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
//				if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
				if (arrXml.length > 0){
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					sheetObjects[0].CellValue(1,"chk") = 1;
				}
				break;
			
			case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI;
				var sParam = FormQueryString(formObj);
				// Sheet1의 CustomerCode를 가져온다.
				var chkCustCd;
				var chkCustSeq;
				var sheet1 = sheetObjects[0];
				var sheet3 = sheetObjects[2];
				
		      	for (var ir=sheet1.HeaderRows; ir<=sheet1.LastRow; ir++) {
		     		if(sheet1.CellValue(ir,"chk") == "1"){
		     			chkCustCd = sheet1.CellValue(ir,"cust_cnt_cd");
		     			chkCustSeq = sheet1.CellValue(ir,"cust_seq");
		     			break;
		     		}
		 	    } 		    				
		      	
		      	for (var i3=sheet3.HeaderRows; i3<=sheet3.LastRow; i3++) {
		     		if(sheet3.CellValue(i3,"ibflag") == "I"){
		     			sheet3.CellValue(i3,"cust_cnt_cd") = chkCustCd;
		     			sheet3.CellValue(i3,"cust_seq") = chkCustSeq;
		     		}
		 	    } 		    					      	
				sheetObj.DoSave("ESM_BKG_0652GS.do?detail_cust_cnt_cd=" + chkCustCd + "&detail_cust_seq=" + chkCustSeq , FormQueryString(formObj));
				break;
			
			case IBINSERT:      // 입력
				break;
        }
    }
         
    // Part Validation
	function validateSelect(sheetObj1, sheetObj3, formObject){
    	// Customer delt_flg = 'Y' 인 경우 Select 안되게 한다.(20090812) 
    	for ( i = 1 ; i < sheetObj1.Rows ; i++ ){
    		if(sheetObj1.CellValue(i, "chk") == "1" && sheetObj1.CellValue(i, "delt_flg") == "Y"){     
    			ComShowCodeMessage("BKG00353",sheetObj1.CellValue(i, "cust_cnt_cd"),sheetObj1.CellValue(i, "cust_seq"));
    			return false;
    		}
    		// Status가 'NO USE' 인 경우 에러.
    		if(sheetObj1.CellValue(i, "chk") == "1" && sheetObj1.CellValue(i, "pb") == "No Use"){     
    			ComShowCodeMessage("BKG02004",sheetObj1.CellValue(i, "cust_cnt_cd")+sheetObj1.CellValue(i, "cust_seq"),sheetObj1.CellValue(i, "no_use_rsn") );
    			return false;
    		}
    		// 20091214 - BLACK인 경우 추가
        	if(sheetObj1.CellValue(i, "chk") == "1" && sheetObj1.CellValue(i, "pb") == "Financial Risk"){
    			ComShowCodeMessage("BKG00055",sheetObj1.CellValue(i, "cust_rlse_ctrl_rmk"),sheetObj1.CellValue(i, "ar_ofc"),sheetObj1.CellValue(i, "srep_nm"));
//        			return false;        		
        	}
        	// 20150224 Exceeding Credit Limit 추가
        	if(sheetObj1.CellValue(i, "chk") == "1" && sheetObj1.CellValue(i, "pb") == "Exceeding Credit Limit"){
    			ComShowCodeMessage("BKG08344","Exceeding Credit Limit",sheetObj1.CellValue(i, "ar_ofc"),sheetObj1.CellValue(i, "srep_nm"));
        	}
    	}
    	
		var isFlag = true;
	    for ( i = 1 ; i < sheetObj3.Rows ; i++ ){
	    	if(isFlag){
	    		if(sheetObj3.CellValue(i, "chk") == "1"){     
	    			for(j = 1 ; j < sheetObj3.Rows ; j++){
	    				if(sheetObj3.CellValue(j, "chk") == "1" && i != j){            				 
	    					// 01. 다른 Row에 All 선택되어있으면 선택불가
	    					if(sheetObj3.CellValue(j, "bkg_cntc_pson_tp_cd") == "AL"){
	    						isFlag = false;
	    						break;
	    					}	        	
	    					// 02. 다른 Row와 동일한 Part 선택 불가
	    					if(sheetObj3.CellValue(j, "bkg_cntc_pson_tp_cd") == sheetObj3.CellValue(i, "bkg_cntc_pson_tp_cd")){
	    						isFlag = false;
	    						break;	        			 
	    					}
	    					// 03. All 선택시 다른 Row에 Part가 선택되어있으면 선택 불가
	    					if(sheetObj3.CellValue(i, "bkg_cntc_pson_tp_cd") == "AL" && sheetObj3.CellValue(j, "bkg_cntc_pson_tp_cd") != ""){
	    						isFlag = false;
	    						break;	        			 	        			 
	    					}        				 
	    				}
	    			}
	    		}        		 
	    	}else{
	    		break;
	    	}
	    }    
	    if(!isFlag){
	    	ComShowCodeMessage("BKG01022");
	    }	    
    	// Status가 'BLACK' 인 경우 메시지.		    
//        	if(sheetObj1.CellValue(i, "pb") == "BLACK"){
//    			ComShowCodeMessage("BKG00055");
//        	}		    
	    return isFlag;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		 switch (sAction) {
		 	case IBSEARCH: // 조회
		 		if (ComChkLen(formObj.cust_cnt_cd,2) != 2 || !ComIsAlphabet(formObj.cust_cnt_cd)) {
		 			ComShowCodeMessage("BKG00186");
					formObj.cust_cnt_cd.focus();
					return false;
		 		}else if(ComIsNull(formObj.cust_seq.value) && formObj.cust_nm.value.length < 2){
		 			ComShowCodeMessage("BKG95046", "Customer Code No. or Name");
		 			formObj.cust_seq.focus();
		 			return false;
				}else{
					formObj.cust_cnt_cd.value = formObj.cust_cnt_cd.value.toUpperCase();
				}
		 		if(!ComIsNull(formObj.cust_seq)){
			 		if(!ComIsNumber(formObj.cust_seq)){
			 			ComShowCodeMessage("BKG00340");
						formObj.cust_seq.focus();
						return false;
			 		}
		 		}
		 		
		 		 //space나 특수문자만 조회할 경우 막음
		        if(!ComIsNull(formObj.cust_nm.value)){
		          	if(ComTrimAll(formObj.cust_nm.value, "~","`","!","@","#","$","%","^","*","&","(",")","-","_","=","|","+","<",">", ",",".","'",":",";","?","/"," ").length <= 0 ||ComTrimAll(formObj.cust_nm.value).length <= 0){
		          		ComShowCodeMessage("BKG43048");
		          		 formObj.cust_nm.focus();
		                 return false;
		          	}
		         }
				break;
				
		 	case IBSAVE:
		 		var sheet3 = sheetObjects[2];			
		 		for (var i=sheet3.HeaderRows; i<=sheet3.LastRow; i++) {
		 			if(sheet3.CellValue(i, "cntc_pson_nm").length>100){
		 			 	ComShowCodeMessage("BKG04012", "Contact Person", "100");
		 				return false;
		 			}
		 			if(sheet3.CellValue(i, "phn_no").length>50){
		 			 	ComShowCodeMessage("BKG04012", "Tel No", "50");
		 				return false;		 				
		 			}
		 			if(sheet3.CellValue(i, "cntc_pson_mphn_no").length>50){
		 			 	ComShowCodeMessage("BKG04012", "Mobile No", "50");
		 				return false;		 				
		 			}		 			
		 			if(sheet3.CellValue(i, "fax_no").length>50){
		 			 	ComShowCodeMessage("BKG04012", "Fax No", "50");
		 				return false;		 				
		 			}		 			
		 			if(sheet3.CellValue(i, "cntc_eml").length>151){
		 			 	ComShowCodeMessage("BKG04012", "Email address", "150");
		 				return false;		 				
		 			}
		 		}
		 		break;
		}
		return true;
    }    

   	/**
   	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
   	 **/                
   	function bkg0652_keypress(){
   	    switch(event.srcElement.dataformat){
   	    	case "engup":
   	    		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
   	    		ComKeyOnlyAlphabet('upper');
   		        break;
   		        
   	        case "int":
   	            //숫자 입력하기
   	        	ComKeyOnlyNumber(event.srcElement);
   	            break;
   	            
   	        default:
   	    }
   	}

  	function sheet1_OnLoadFinish(sheetObj) {   
 		sheetObj.WaitImageVisible = false;   
 		var formObj = document.form;
        if(formObj.cust_cnt_cd.value.length == 2 && (formObj.cust_seq.value.length > 0 || formObj.cust_nm.value.length > 2)){
	 		if(!ComIsNull(formObj.cust_seq)){
		 		if(!ComIsNumber(formObj.cust_seq)){
		 			ComShowCodeMessage("BKG00340");
					formObj.cust_seq.focus();
		 		} else {
		  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 		}
	 		}
        }         
        initControl();
 		sheetObj.WaitImageVisible = true;
 	}          

     /**
      * sheet1 OnClick후 이벤트 
      * sheet1의  정보로 sheet2,sheet3의 정보리스트 취득
      * @param {ibsheet} sheet 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnDblClick(sheet , row, col) {  
     	var formObj = document.form; 

     	var chkCustCd = sheet.CellValue(row,"cust_cnt_cd");
     	var chkCustSeq = sheet.CellValue(row,"cust_seq");    
     	sheet.CellValue(row,"chk") = 1;     	
 		formObj.f_cmd.value = SEARCH02;
   		var sXml = sheet.GetSearchXml("ESM_BKG_0652GS.do?detail_cust_cnt_cd=" + chkCustCd + "&detail_cust_seq=" + chkCustSeq , FormQueryString(formObj));

   		var arrXml = sXml.split("|$$|");
  		
   		if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);
   		if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);

 		if(sheet.CellValue(row,"delt_flg") == "Y"){
 			sheet.CellFontColor(row,col) = sheet.RgbColor(255,0,0);
 		} 		    	
    }     
     
    // Delete Flag 가 'Y'이면 붉은색으로 표시.
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	var delt_flg;

    	for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++) {
    		if(sheetObj.CellValue(ir,"delt_flg") == "Y"){
    	    	for (var ic=3; ic<=8; ic++) {
    	    		sheetObj.CellFontColor(ir,ic) = sheetObj.RgbColor(255,0,0);
    	    	}     			
    		}
	    } 		
    }

    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var formObj = document.form;
    	if(sheetObj.ColSaveName(Col) == "chk"){
    		if(Value=="1"){        		
            	var chkCustCd = sheetObj.CellValue(Row,"cust_cnt_cd");
            	var chkCustSeq = sheetObj.CellValue(Row,"cust_seq");
            	
        		formObj.f_cmd.value = SEARCH02;
          		var sXml = sheetObj.GetSearchXml("ESM_BKG_0652GS.do?detail_cust_cnt_cd=" + sheetObj.CellValue(Row,"cust_cnt_cd") 
          					+ "&detail_cust_seq=" + sheetObj.CellValue(Row,"cust_seq"), FormQueryString(formObj));

          		var arrXml = sXml.split("|$$|");
       	 		
          		if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);
          		if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);	
          		
          		
          		for ( i = 1 ; i < sheetObjects[1].Rows ; i++ ){
          			if( sheetObjects[1].CellValue(i,"ofc_cd")==ComGetObjValue(formObj.sofc_cd)&&sheetObjects[1].CellValue(i,"srep_cd")==ComGetObjValue(formObj.srep_cd)){
          				sheetObjects[1].SelectCell(i,1);
          			}
          		}
    		}    		
    	}
    }
        
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김병규
     * @version 2009.05.17
     */ 	
 	function sheet3_OnSaveEnd(sheetObj, ErrMsg)  {
 		if (ErrMsg == "") {
			ComBkgSaveCompleted();			
		}
	}     
     
	//double click -> select
    function sheet3_OnDblClick(sheetObj , row, col) {  
    	if(sheetObj.ColSaveName(col)=="chk"){        		
       	 	var formObj = document.form;
       	 	sheetObj.CellValue2(row,"chk") = "1";
			comPopupSend(sheetObjects[0], sheetObjects[1], sheetObjects[2], formObj);
    	}
    }     
         
    /**
     * 화면정보를 Main에 전달한다.
     */     
	function comPopupSend(sheetObj1, sheetObj2, sheetObj3, formObj){
		 var calllFunc = formObj.calllFunc.value;
		 var bkgCustTpCd = formObj.bkgCustTpCd.value;
		 var rArray1 = null;
		 var rArray2 = null;
		 rArray1 = getLocalCheckedRows(sheetObj1);
		 if(sheetObj3.RowCount("R") > 0){
			 rArray2 = getLocalCheckedRows(sheetObj3);
		 }
		 var lOfc = sheetObj2.CellValue(sheetObj2.SelectRow,"ofc_cd");
		 var lRep = sheetObj2.CellValue(sheetObj2.SelectRow,"srep_cd");
		 eval('window.dialogArguments.'+calllFunc)(bkgCustTpCd, rArray1, rArray2, lOfc, lRep);
		 window.close();
	}     	
    
    function getLocalCheckedRows(sheetObj,colName) {
   		var checkRows;
   		var colsCnt = sheetObj.LastCol + 1;
   		var rows = sheetObj.Rows;
   		
   		var rArray = null; // 행데이터를 담고 있는 배열
   		var cArray = null; // 열데이터를 담고 있는 배열
   		
   		checkRows = sheetObj.CheckedRows('chk');
   		
   		if(checkRows == 0) {  			
   			return null;
   		} else {
   			var idx = 0;
   	  		rArray = new Array(checkRows);
   	  		
   			for(var i = 0; i < rows; i++) {
   				if(sheetObj.CellValue(i, "chk") == 1) {					
   		  			cArray = null;
   		  			
   		  			// 특정 컬럼명이 지정된 경우
   		  			if(colName != null && colName != "") {
   		  				cArray = sheetObj.CellValue(i, colName);
   		  			} else {
   		  				cArray = new Array(colsCnt);
   		  				
   			  			for(var j=0; j<cArray.length; j++) {
   	                    	cArray[j] = sheetObj.CellValue(i, j);
   	                    }
   	                }
   	                rArray[idx++] = cArray;
   	     		}
   	  		}
   	  	}
   	  	return rArray;
   	}       
    
    /**
     * DEL 콤보 Change 이벤트 발생 처리<br>
     * DEL CD 를 DEL 선택한 코드값으로 변경한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function cust_cnt_cd_OnChange() {
    	var formObj = document.form;
    	if(formObj.cust_cnt_cd.value !="US"){
    		document.form.area_cd.className = "input2";
			document.form.area_cd.readOnly = true;
    	}else{
    		document.form.area_cd.className = "input";
			document.form.area_cd.readOnly = false;
    	}
    }

     /**
     * DEL 콤보 Change 이벤트 발생 처리<br>
     * DEL CD 를 DEL 선택한 코드값으로 변경한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function bklst_OnChange() {
    	var formObj = document.form;
    	if(!formObj.bklst.checked){
    		document.form.bklst.value = "0";
			//document.form.area_cd.readOnly = true;
    	}
    	else{
    		document.form.bklst.value = "on";
			//document.form.area_cd.readOnly = false;
    	}
    }
    
/* 개발자 작업  끝 */