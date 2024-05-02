/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1090.js
*@FileTitle : Surcharge Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 20
*@LastModifier : KIM TAE KYOUNG
*@LastVersion : 1.0
* 2010.02.12 KIM TAE KYOUNG
* 1.0 Creation
* 2013.09.16 김진주 [SRM-201338939] DHF ADJUSTMENT 기능 OFFICE 추가 - CANBS, ZHOBS
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
    function ESM_BKG_1090() {
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
            case "btn_Add":
            	sheetObject1.DataInsert(-1);
            	break;
            	
            case "btn_Del":
            	//Save시 전체 삭제 후 Insert함
            	sheetObject1.RowDelete(sheetObject1.SelectRow, false);
				break;
				
            case "btn_t3Save":
            	formObject.f_cmd.value = MULTI01; 
            	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
            	break;
				
            case "btn_t4Save":
            	formObject.f_cmd.value = MULTI02; 
            	doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
            	break;
            	
            case "btn_t3New":
            	sheetObjects[0].CellValue(1,"loc_cd") = "";
            	sheetObjects[0].CellValue(1,"curr_cd") = "";
            	break;
            	
            case "btn_t4New":
            	sheetObjects[1].CellValue(1,"curr_cd") = "";
            	break;

            case "btn_t3Close":
                window.close();

            case "btn_t4Close":
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

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
	    	
     	for(k=0;k<tabObjects.length;k++){
     		initTab(tabObjects[k],k+1);
        }

		var formObj = document.form;
		var obj =  document.getElementById('ui_msg');

     	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);

		if(formObj.bkg_ofc_cd.value == "SZPSC" || formObj.bkg_ofc_cd.value == "HKGSC" || formObj.bkg_ofc_cd.value == "CANSO" || formObj.bkg_ofc_cd.value == "ZHOSO" ){
			ComBtnEnable("btn_t3Save");
			sheetObjects[0].ColHidden("curr_cd") = true;
			obj.innerHTML = '※ SZPSC, HKGSC, CANSO, ZHOSO only';
		}else if (formObj.pol_cd.value.substring(0, 2) == "CA" || formObj.pol_cd.value.substring(0, 2) == "US" ){
			ComBtnEnable("btn_t3Save");
			sheetObjects[0].ColHidden("loc_cd") = true;
			obj.innerHTML = '';
		}else{
			ComBtnDisable("btn_t3Save");
			sheetObjects[0].ColHidden("loc_cd") = true;
			sheetObjects[0].ColHidden("curr_cd") = true;
			obj.innerHTML = '';
		}
		if(formObj.svc_scp_cd.value == "TPW" ||formObj.svc_scp_cd.value == "ACW" ){
			ComBtnEnable("btn_t4Save");
		}else{
			ComBtnDisable("btn_t4Save");
		}
    }
    

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "CAF Adjustment" , -1 );
                    InsertTab( cnt++ , "WHF Exemption" ,  -1 );
                    InsertTab( cnt++ , "DHF Adjustment" , -1 );
                    InsertTab( cnt++ , "DDC Adjustment" , -1 );
                }
             break;
         }
    }

    /**
    * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     tab1_OnChange(tabObj, tabIndex)
    * </pre>
    * @param {tabObj} tabObj 필수 IBTab Object
    * @param {int} tabIndex 필수 프로세스 플래그 상수
    * @return 없음
    * @author 김병규
    * @version 2009.04.17
    */     
	function tab1_OnChange(tabObj, tabIndex) {

		
        if (beforetab != tabIndex) {
        	var objs = document.all.item("tabLayer");
        	objs[tabIndex].style.display = "inline";
        	objs[beforetab].style.display = "none";            
        }
        if(tabIndex == 0 || tabIndex == 1) loadTabPage(tabIndex);
	    beforetab = tabIndex;
	}
	  

   /**
   * Tab변경시 화면을 Frame에 로드한다.  <br>
   * <br><b>Example :</b>
   * <pre>
   *     loadTabPage(tabIndex)
   * </pre>
   * @param {tabIndex} tabIndex 필수 tab의 일련번호
   * @param {selRow} 선택된  Row
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */          
	function loadTabPage(tabIndex) {
	    var formObj  = document.form;	   
	    if (tabIndex == null || tabIndex == "") {
	    	tabIndex = tabObjects[0].SelectedIndex;
	    }
	    


	    var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
	    var isReLoading = false;
	    if(objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank"){
	    	isReLoading = true;
	    }
	    
    	var ctxName  = "/hanjin";
    	var sUrl = "";
    	var bkgNo = formObj.bkg_no.value;
	    var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
    	
	    if(isReLoading){
			switch(tabIndex) {    		
			case 0:
				sUrl = ctxName + "/ESM_BKG_0700.do?bkg_no="+bkgNo;
				objTabWindow.location.href = sUrl;
				break;
			case 1:
				sUrl = ctxName + "/ESM_BKG_0699.do?bkg_no="+bkgNo;
				objTabWindow.location.href = sUrl;
				
				break;
			}
	    }
        return true;
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
                    style.height = 60;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|Charge Code|POR/POL|Currency";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter, true,  "ibflag");         
                    InitDataProperty(0, cnt++ , dtData,			260,	daCenter, true,  "chg_cd",	false,    "",   dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++ , dtCombo,		260,	daCenter, true,  "loc_cd",	false,    "",   dfNone,        0,    true,    true);
                    InitDataProperty(0, cnt++ , dtCombo,		260,	daCenter, true,  "curr_cd",	false,    "",   dfNone,        0,    true,    true);
                    
        			InitDataCombo(0, "loc_cd", ' |CNYIT|CNHKG', ' |CNYIT|CNHKG', "");
        			InitDataCombo(0, "curr_cd", ' |USD', ' |USD', "");
                    CountPosition = 0;
                
                }
                break;
            case "sheet2":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 60;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|Charge Code|Currency";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter, true,  "ibflag");         
                    InitDataProperty(0, cnt++ , dtData,			260,	daCenter, true,  "chg_cd",	false,    "",   dfNone,        0,    false,   false);
                    InitDataProperty(0, cnt++ , dtCombo,		260,	daCenter, true,  "curr_cd",	false,    "",   dfNone,        0,    true,    true);

        			InitDataCombo(0, "curr_cd", ' |USD', ' |USD', "");
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
	        var sXml = sheetObj.GetSearchXml("ESM_BKG_1090GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].LoadSearchXml(arrXml[0]); 
			sheetObjects[1].LoadSearchXml(arrXml[1]); 
            
            break;
            
        case IBSAVE:
       		sheetObj.DoSave("ESM_BKG_1090GS.do", FormQueryString(formObj)+"&"+ComGetSaveString(sheetObj));
        	break;
        
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
            }
        }
         
        return true;
    }    
    

	/* 개발자 작업  끝 */