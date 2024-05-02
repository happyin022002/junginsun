/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1084.js
*@FileTitle : TPB Issue Popup
*Open Issues :
*Change history :
*@LastModifyDate : 20
*@LastModifier : KIM TAE KYOUNG
*@LastVersion : 1.0
* 2010.02.12 KIM TAE KYOUNG
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
     * @class ESM_BKG_1068 : ESM_BKG_1068 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1068() {
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
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "btn_GotoTPB":
            	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01);
                break;

            case "btn_Close":
                window.close();
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

        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    }

     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObj,document.form,IBSEARCH);
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 82;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|Sel.|Seq.|Bkg No.|CNTR No.|CNTR No.|CGO|S/O|MVMT|Incurred Charges|TPB No.";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter, true,  "ibflag");                    
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,   daCenter, true,  "chk");
                    InitDataProperty(0, cnt++ , dtSeq,          40,   daCenter, true,  "seq");
                    InitDataProperty(0, cnt++ , dtHidden,       90,   daCenter, false, "bkg_no");
                    InitDataProperty(0, cnt++ , dtData,         90,  daCenter, true,  "cntr_no",       false,    "",   dfNone,        0,    false,    true);
                    InitDataProperty(0, cnt++ , dtData,         30,   daCenter, true,  "cntr_tpsz_cd",  false,    "",   dfNone,        0,    false,    true);
                    InitDataProperty(0, cnt++ , dtData,         40,   daCenter, true,  "cgo",         false,    "",   dfNone,        0,    false,    true);
                    InitDataProperty(0, cnt++ , dtData,         40,   daCenter, true,  "so_nm",         false,    "",   dfNone,        0,    false,    true);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter, true,  "cnmv_sts_cd",   false,    "",   dfNone,        0,    false,    true);
                    InitDataProperty(0, cnt++ , dtData,         140,  daCenter, true,  "if_amt", false,    "",   dfNullInteger, 0,    true,     true);
                    InitDataProperty(0, cnt++ , dtData,         90,   daCenter, true,  "tpb_no",  false,    "",   dfNone,        0,    false,    true);
                    
                    CountPosition = 0;
                
                }
                
            break;

        }
    }


    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        case IBSEARCH:      //조회
            if(validateForm(sheetObj,formObj,sAction) == false) break;
        
	        formObj.f_cmd.value = SEARCH;
	        sheetObj.DoSearch("ESM_BKG_1084GS.do", FormQueryString(formObj));
            
            break;
            
            
        
        case IBSEARCH_ASYNC01:        
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
        	
     	    if (sheetObj.RowCount == 0) {
    		    ComShowCodeMessage("BKG00109"); 
    	        break;
    	    }

     	    var iCheckRow = sheetObj.CheckedRows("chk");
       	    if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00249");
        		break;
        	}
     	    
        	var param = "";
        	var p_cnt           = 0;
        	var p_bkg_no        = formObj.bkg_no.value;
        	var p_bl_no         = formObj.bl_no.value;
        	var p_trd_party_val = formObj.cust_cd.value;
        	var p_curr_cd       = "USD";
        	var p_eq_no         = "";
        	var p_if_amt        = "";
        	var p_eq_tpsz_cd    = "";
        	
        	
        	for(var i=0; i<sheetObj.RowCount; i++) {
            	if(sheetObj.CellValue(i+1, "chk") == "1") {
            		p_cnt++;
            		
            		if (p_cnt > 1) p_eq_no += "|$|"; 
            		p_eq_no += sheetObj.CellValue(i+1, "cntr_no");
            		
            		if (p_cnt > 1) p_eq_tpsz_cd += "|$|"; 
            		p_eq_tpsz_cd += sheetObj.CellValue(i+1, "cntr_tpsz_cd");

            		if (p_cnt > 1) p_if_amt += "|$|"; 
            		p_if_amt += sheetObj.CellValue(i+1, "if_amt");
            	}
        	}
        	
        	param = "p_bkg_no="        + p_bkg_no        + "&" +
        	        "p_eq_no="         + p_eq_no         + "&" +
        	        "p_if_amt="        + p_if_amt        + "&" +
        	        "p_eq_tpsz_cd="    + p_eq_tpsz_cd    + "&" +
        	        "p_bl_no="         + p_bl_no         + "&" +
//        	        "p_trd_party_val=" + p_trd_party_val + "&" +
        	        "p_curr_cd=USD";
//        	var rtnValue = ComOpenPopupWithTarget('/hanjin/ESD_TPB_0103.do?pgmNo=ESD_TPB_0103&' + param, 1200, 485, "", "none", true); 
        	var pgmNo = "ESD_TPB_0103";
			var pgmUrl = "/hanjin/ESD_TPB_0103.do?";
			var parentPgmNo = pgmNo.substring(0, 8) + 'M001';   
			var src = "&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo +"&" + param;
			var sFeatures = "status=no, width=1024, height=768, resizable=yes, scrollbars=yes";   
//			var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);
			ComOpenWindowCenter("alpsMain.screen?parentPgmNo=" + parentPgmNo + src,"ESD_TPB_0103",1024,768,true,"scrollbars=no,resizeable=no")
        	/*if (rtnValue != null) {
        		
        		var arrList = rtnValue.split("|$|");

            	if (arrList != null && arrList.length > 0) {
                	
            		var idx = 0;

                	for(var i=0; i<sheetObj.RowCount; i++) {
                    	if (idx == arrList.length) break;

                    	if(sheetObj.CellValue(i+1, "chk") == "1") {
                    		sheetObj.CellValue(i+1, "n3pty_bil_no") = arrList[idx++];
                    	}
                	}
                	
                    formObj.f_cmd.value = MULTI;
                    
                    var sParam = FormQueryString(formObj);
                    var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
                    if (sParamSheet != "") {
                        sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                    }

                    sheetObj.DoSave("ESM_BKG_1068GS.do", sParam, -1, false);                	
            	}
        	}*/
        	
        	break;
        
        }
    }

    
    // 검색 완료 이벤트 처리
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//    	with (sheetObj) {
//        	for (var i=0; i<RowCount; i++) {
//        		if (CellValue(i+1, "n3pty_bil_yn") == "Y") {
//        			RowEditable(i+1) = false;
//        		}
//        	}
//    	}
    }    
    
    // Save 완료 이벤트 처리
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
            
          	case IBSEARCH:
       	    	if (!ComChkValid(formObj)) return false;
       	    	break;
       	    	
            
            case IBSEARCH_ASYNC01:
            	
            	for(var i=0; i<RowCount; i++) {
                	if(CellValue(i+1, "chk") == "1") {
                		if (CellValue(i+1, "if_amt") == "") {
                			ComShowCodeMessage("BKG40088");
                			return false;
                		}
                	}
            	}
            	
            	break;
            }
        }
         
        return true;
    }    
    

	/* 개발자 작업  끝 */