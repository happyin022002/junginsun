/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0125.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0125() {
    	this.processButtonClick		= processButtonClick;
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
            				
                case "btn_retrieve":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				
                case "btn_save": 
            		doActionIBSheet(sheetObject1,document.form,MULTI);
            		doActionIBSheet(sheetObject1,document.form,IBSEARCH);
            	break;
            		
                case "btn_downexcel":
                	sheetObject1.Down2Excel(-1);
				break;
									
				case "btn_close":
					window.close();
					opener.runShortcut("retrieve");
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

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
    	formObject.vvd.focus();
    }

    

    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
//    
    }
    
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 300;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle1 = "|Sel.|Diff|Trans Mode|B/L No";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     50,   		daCenter,   	true,       "Chk");
					InitDataProperty(0, cnt++ , dtCombo,		100,			daCenter,	    false,		"diff",					false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,			daCenter,		false,		"cstms_decl_tp_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,		daCenter,		false,		"bl_no",				false,			"",      dfNone,			0,		false,		false);
					InitDataCombo(0, "diff","All|Match|Only BKG|Only WHF","A|M|B|W");			
               }
                break;
        }
    }
    
    
    
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
        		if( validateForm(sheetObj,formObj,sAction) ){
					
					formObj.f_cmd.value = SEARCH;   
					sheetObj.DoSearch("ESM_BKG_0129GS.do",FormQueryString(formObj));
					
        		}
        		
			break;
			
        	case MULTI:        //저장
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value = MULTI;
				    if (! sheetObjects[0].IsDataModified ){
				    	ComShowCodeMessage('BKG00233');
	    	        	return;
	    	        }
					ComOpenWait(true);
				    var sParam = ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj);
//	    	        alert(sParam);
//	    	        ComOpenWait(false);
//	    	        return;
	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0129GS.do", sParam);
	    	        sheetObj.LoadSaveXml(SaveXml);
	    	        ComOpenWait(false);
				}    
    	    break;
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if ( formObj.vvd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				return false;
	 			}
	 			
	 			if ( formObj.port_cd.value == "") 
	 			{
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				return false;
	 			}
	 			
	 			if ( formObj.mrn_no.value == "") 
	 			{
	 				ComShowCodeMessage('BKG00887', 'MRN NO');
	 				return false;
	 			}
	 			if ( formObj.whf_bnd_cd.value == "") 
	 			{
	 				ComShowCodeMessage('BKG00887', 'BND');
	 				return false;
	 			}
	 							
	 			return true;
	 		break;
	 		case MULTI: // 저장
	 			return true;
	 		break;
	 		
     	}
     }

     
	/* 개발자 작업  끝 */    