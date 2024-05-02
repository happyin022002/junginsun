/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1132.js
*@FileTitle : C.OFC & C.REP PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : JSY
*@LastVersion : 1.0
* 2011.10.11 JSY
* 1.0 Creation
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
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
     * @class ESM_BKG_1132 : ESM_BKG_1132 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1132() {
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
    		         var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    							case "btn_Retrieve":
    								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);								
    							break; 
    							
    							case "btn_Select":
    								comPopupSend(sheetObject, formObject);	
    							break;

    							case "btn_Close":
    								window.close();
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
    	var formObject = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sXml = ComGetObjValue(formObject.sXml);
        if(sXml != null && sXml != '' ) {
        	
        	sheetObjects[0].loadSearchXml(sXml);
        } else {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }

//  	 function sheet1_OnLoadFinish(sheetObj) {   
// 		sheetObj.WaitImageVisible = false;   
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		
//		initControl();
// 		sheetObj.WaitImageVisible = true;   
// 	 }        
      	 
	function initControl() {
   	 	var formObject = document.form;
   	
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
                        style.height = 150;
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
                        InitColumnInfo(4, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "|C.OFC|C.REP|C.REP Name";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtRadioCheck,	0,    	daCenter,  		false,  		"chk");
                        InitDataProperty(0, cnt++ , dtData,		 	50,   	daCenter,    	false,     	"cust_sls_ofc_cd", 	false,    "",      dfNone, 		0,     false,    false);      
    					InitDataProperty(0, cnt++ , dtData,      		50,  	daLeft,    	false,     	"cust_srep_cd", 			false,    "",      dfNone, 		0,     false,    false);
                        InitDataProperty(0, cnt++ , dtData, 		 	100,   	daLeft,	  	false,     	"srep_nm",     	false,    "",      dfNone, 		0,     false,    false);



                   }
                    break;


            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
				case IBSEARCH:      //조회
					formObj.f_cmd.value = SEARCH;
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_BKG_1132GS.do" , FormQueryString(formObj));
					ComOpenWait(false); 
				break;
            }
        }

    	//double click -> select
        function sheet1_OnDblClick(sheetObj , row, col) {  
       	 	var formObj = document.form;
       	 	sheetObj.CellValue2(row,"chk") = "1";
       	 	comPopupSend(sheetObj, formObj);
        }     

        /**
        * 화면정보를 Main에 전달한다.
        */     
		function comPopupSend(sheetObj, formObj){
			var calllFunc = formObj.calllFunc.value;
			var rArray = getCheckedRowsByName(sheetObj,"chk");
       	    if(rArray == null) {
				ComShowCodeMessage("COM12114", "row");
				return;
			}else{
	 			eval('window.dialogArguments.'+calllFunc)(rArray);
	 			window.close();
			}
		}     

	/* 개발자 작업  끝 */