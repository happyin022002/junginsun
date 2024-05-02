/*
=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BCM_CMS_0312.jsp
*@FileTitle : Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2018-01-19
*@LastModifier : jklim 
*@LastVersion : 1.0
* 2018-01-19 jklim 
* 1.0 최초 생성
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
		       MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
		       OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    function BCM_CMS_0312() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl; 
    	this.doActionIBSheet 		= doActionIBSheet;
		this.obj_keypress_loc       = obj_keypress_loc;
		this.obj_keyup              = obj_keyup;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initTab                = initTab;
    	this.tab3_OnChange          = tab3_OnChange;
    }

// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var appRqstNo;
var grpIndivDiv;

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

        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_New":
    	            sheetObject.RemoveAll();
    	            sheetObjects[1].RemoveAll();
    	            formObject.reset();
        	        break;
        	        
                case "btn_Close":
    	            self.close();
        	        break;

        	    case "btn_OK":
                    comPopupOK();
        	        break;
        	        
        	    case "btn_com_ens_071": // office pop-up
     				var param="";
     	    		param=param + "&" + "ofc_cd=" + form.ofc_cd.value;
     	    		ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
     				break;
     				
         		case "rqst_date":
        			var cal = new ComCalendarFromTo();
        			cal.select(document.form.rqst_fm_dt, document.form.rqst_to_dt,'yyyy-MM-dd');
        			break;
        			
         		case "btn_Approve":
         			doActionIBSheet(sheetObject,formObject,MULTI01);
         			break;
         			
         		case "btn_Reject":
         			doActionIBSheet(sheetObject,formObject,MULTI02);
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

    function initControl() {
    	var formObject = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
        axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    
 // 업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress_loc() {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
	       case "float":
	           //숫자+"."입력하기
	           ComKeyOnlyNumber(event.srcElement, ".");
	           break;
	       case "eng":
	           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	           ComKeyOnlyAlphabet();
	           break;
	       case "engdn":
	           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	           ComKeyOnlyAlphabet('lower');
	           break;
	       case "engup":
	           //영문 대문자만 입력하기
	           ComKeyOnlyAlphabet('upper');
	           break;
	       case "int":
	           //숫자만입력하기(정수,날짜,시간)
	           ComKeyOnlyNumber(event.srcElement);
	           break;
	       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
	       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
	     			event.keyCode = keyValue + 65 - 97;
	     		}
	           break;
	       case "tel":
		        // 숫자+"-"입력하기
		        ComKeyOnlyNumber(event.srcElement, "-"); 
		        break;
           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
	    	   break;
	    }
	}
    
  //업무 자바스크립트 OnKeyPress 이벤트 처리
    function keypressFormat() {
    	obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	    switch(obj.name) {
  	        case "cust_grp_id":
  	        	//ComKeyOnlyAlphabet('upper');
  	        	break;
  	        case "cust_grp_nm":
//  	        	ComKeyOnlyAlphabet('upper','32');
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
        ComBtnDisable("btn_Approve");
    	ComBtnDisable("btn_Reject");
    	
    	document.form.rqst_fm_dt.value = ComGetDateAdd(null, "d", -30, "-");
        document.form.rqst_to_dt.value = ComGetNowInfo();
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
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 2, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    
                    var HeadTitle = "|Rqst No.|G/I|Name|Request DT|Sales Office|Sales Rep|Location code|Customer Code|Status";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    	"radio",   				false,          "",       dfNone,	    0,     true,       true);
                    //InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    	"checkbox",   			false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    	"rqst_no", 				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    	"grp_indiv_div",		false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     200,    daLeft  ,  false,    	"cust_lgl_eng_nm", 		false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter  ,  false,    	"rqst_dt", 				false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"ofc_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"srep_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"loc_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"cust_cd",   			false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       0,    daCenter,  false,   	"delt_flg",     				false,          "",       dfNone,   	0,     false,       true);
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
               }
               break;
            case 2:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
            	style.height = 220;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 5000);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(7, 2, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)
                
                
                var HeadTitle = "Seq.|Cust. Code|Customer Name|Address|Location|Tax Payer ID|S.OFC" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    	"seq",     				false,          "",       dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    	"cust_cnt_cd", 				false,          "",       dfNone,       0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,     200,    daLeft  ,  false,    	"cust_lgl_eng_nm", 				false,          "",       dfNone,       0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,     200,    daLeft,  false,    	 	"bzet_addr",   			false,          "",       dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"loc_cd",   			false,          "",       dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,     0,    daCenter,  false,    	 	"cust_rgst_no",   			false,          "",       dfNone,   	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,      75,    daCenter,  false,    	"ofc_cd",  				false,          "",       dfNone,       0,     false,       true);
                
                CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
               }
                break;

        }
    }



    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.zz
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                	
                	ComSetObjValue(formObj.rjct_rsn_cd,"");
                	formObj.rjct_rsn_rmk.value = "";
                	sheetObjects[1].RemoveAll();
                	
                	formObj.f_cmd.value = SEARCH;
                    selectVal = FormQueryString(formObj);
//                    sheetObj.UseZipFile = true;
                    var sXml = sheetObj.GetSearchXml("BCM_CMS_0310GS.do", selectVal);
                    sheetObj.LoadSearchXml(sXml);
                    
                    for (var i=sheetObj.HeaderRows;i<sheetObj.Rows;i++) {
	     				sheetObjects[0].CellFontColor(i, 0) = sheetObjects[0].RgbColor(0, 0, 255);
	     				sheetObjects[0].CellFontColor(i, 7) = sheetObjects[0].RgbColor(0, 0, 255);
     				}
                    
                    sheetObj.SelectCell(0,0,false);
                    ComBtnDisable("btn_Approve");
         	    	ComBtnDisable("btn_Reject");
//                     sheetObj.ShowDebugMsg = false;
//                     sheetObj.DoSearch("COM_ENS_041GS.do?UseZipFile=true", selectVal);
                }else{
                	return true;
                }
           
                break;
                
           case MULTI01: // approve
        	   if (validateForm(sheetObj, formObj, sAction)) {
	       			formObj.f_cmd.value=MULTI01;
	             	    
	       			var sParam = "f_cmd=181&" + "&rqst_no="+appRqstNo + "&grp_indiv_div="+grpIndivDiv;
	       			
	       			ComOpenWait(true); //대기이미지 표시
	
	       			var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0312GS.do", sParam);
	       			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
	       			
	       			ComOpenWait(false); //대기이미지 숨김
	
	       			if(sav == "S"  ){
	       				ComShowCodeMessage("COM130102", "Data");
	        			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	        		}else{
	        			ComShowCodeMessage("COM130103", "Data");
	        		}
	       		}	
        	    break;
        	   
		   case MULTI02: // reject
			   if (validateForm(sheetObj, formObj, sAction)) {
				   formObj.f_cmd.value=MULTI02;
				   
				   var sParam = "f_cmd=182&" + "&rqst_no="+appRqstNo + "&rjct_rsn_rmk="+formObj.rjct_rsn_rmk.value + "&rjct_rsn_cd="+ComGetObjValue(formObj.rjct_rsn_cd);
	       			
	       			ComOpenWait(true); //대기이미지 표시
	
	       			var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0312GS.do", sParam);
	       			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
	       			
	       			ComOpenWait(false); //대기이미지 숨김
	
	       			if(sav == "S"  ){
	       				ComShowCodeMessage("COM130102", "Data");
	        			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	        		}else{
	        			ComShowCodeMessage("COM130103", "Data");
	        		}
			   }
			   break;
                
           case IBSEARCHAPPEND:  // 페이징 조회
           
                formObj.f_cmd.value = SEARCH;         
                sheetObj.DoSearch4Post("BCM_CMS_0310GS.do", selectVal, "iPage=" + PageNo, true);  
                break;

        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
    	case MULTI02:
    		if(ComGetObjValue(formObj.rjct_rsn_cd) == "" || ComGetObjValue(formObj.rjct_rsn_cd) == null){
    			ComShowCodeMessage("CCD00001", "Reject Reason Code");
    			document.form.rjct_rsn_cd.focus();
    			return false;
    		}
    		break;
           
        }

        return true;
    }
    
	function setCallBack0B3(aryPopupData) {
		var form=document.form;
		form.ofc_cd.value=aryPopupData[0][3];
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.ColFontUnderline("rqst_no") = true;
		sheetObj.ColFontUnderline("cust_cd") = true;
	}

    
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var formObj=document.form;
    	if ( col == 8 ) {
			var param = "";
			var chkCustCd = sheetObj.CellValue(row, "cust_cd");
			var chkgrpIndivDiv = sheetObj.CellValue(row, "grp_indiv_div");
			
			
			if ( chkCustCd != "" && chkgrpIndivDiv == 'I' ) {	
	    		param=param + "&" + "cust_cd=" + chkCustCd + "&cnt_cd="+chkCustCd.substring(0,2) + "&cust_seq="+chkCustCd.substring(2,8);
	    		ComOpenWindowCenter("/hanjin/BCM_CMS_0302.do?"+param, "BCM_CMS_0302", 1024, 600, true, "yes");
			} else if ( chkCustCd != "" && chkgrpIndivDiv == 'G' ){
				param=param + "&" + "cust_grp_id=" + chkCustCd;
	    		ComOpenWindowCenter("/hanjin/BCM_CMS_0306.do?"+param, "BCM_CMS_0306", 1024, 600, true, "yes");
			}

		} else {

			var param = "";
			var rqstNo = sheetObj.CellValue(row, "rqst_no");
			if ( rqstNo != "" ) {	
	    		param=param + "&" + "rqst_no=" + rqstNo;
	    		ComOpenWindowCenter("/hanjin/BCM_CMS_0309.do?"+param, "BCM_CMS_0309", 1024, 600, true, "yes");
			}
		}
    }
    
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	var formObj=document.form;
    	var locCd = sheetObj.CellValue(row, "loc_cd");
    	var custNm = sheetObj.CellValue(row, "cust_lgl_eng_nm");
    	var deltFlg = sheetObj.CellValue(row, "delt_flg");
    	
    	if ( col == 0 && deltFlg == 'Requested') {
	    	formObj.f_cmd.value = SEARCH;
	        var selectVal = "f_cmd=2&match_rule=I&cust_nm="+custNm+"&loc_cd="+locCd;
	        var sXml = sheetObj.GetSearchXml("BCM_CMS_0304GS.do", selectVal);
	        sheetObjects[1].LoadSearchXml(sXml);
	        
	        appRqstNo = sheetObj.CellValue(row, "rqst_no");
	        grpIndivDiv = sheetObj.CellValue(row, "grp_indiv_div"); 
	        ComBtnEnable("btn_Approve");
	    	ComBtnEnable("btn_Reject");
    	} else if ( col == 0 ) {
    		ComBtnDisable("btn_Approve");
	    	ComBtnDisable("btn_Reject");
    	}
    	/*if ( col == 7 ) {
			var param = "";
			var chkCustCd = sheetObj.CellValue(row, "cust_cd");
			var chkgrpIndivDiv = sheetObj.CellValue(row, "grp_indiv_div");
			
			
			if ( chkCustCd != "" && chkgrpIndivDiv == 'I' ) {	
	    		param=param + "&" + "cust_cd=" + chkCustCd + "&cnt_cd="+chkCustCd.substring(0,2) + "&cust_seq="+chkCustCd.substring(2,8);
	    		ComOpenWindowCenter("/hanjin/BCM_CMS_0302.do?"+param, "BCM_CMS_0302", 1024, 600, true, "yes");
			} else if ( chkCustCd != "" && chkgrpIndivDiv == 'G' ){
				param=param + "&" + "cust_grp_id=" + chkCustCd;
	    		ComOpenWindowCenter("/hanjin/BCM_CMS_0306.do?"+param, "BCM_CMS_0306", 1024, 600, true, "yes");
			}

		} else {

			var param = "";
			var rqstNo = sheetObj.CellValue(row, "rqst_no");
			if ( rqstNo != "" ) {	
	    		param=param + "&" + "rqst_no=" + rqstNo;
	    		ComOpenWindowCenter("/hanjin/BCM_CMS_0309.do?"+param, "BCM_CMS_0309", 1024, 600, true, "yes");
			}
		}*/
    }