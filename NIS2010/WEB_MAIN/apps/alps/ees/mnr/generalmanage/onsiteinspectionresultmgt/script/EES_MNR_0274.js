/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0274.js
*@FileTitle : Onsite Inspection Result Item Management
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
     * @class ees_mnr_0274 : ees_mnr_0274 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0274() {
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
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
								break;
						case "btn_DownExcel":
							sheetObject1.Down2Excel(-1);
							break;
						/*case "btn_LoadExcel":
							sheetObject1.LoadExcel(-1, 1, "", -1, -1, "", false);
							break;*/
						case "btn_RowAdd": 
							rowAdd();
								break;
						/*case "btn_RowDel":
							rowDel();
								break;*/
						
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

        var formObj = document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);   
    }

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj) {
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
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Del|Seq|||Survey Question|";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //dtAutoSumEx 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , 	dtHiddenStatus,	  0,	daCenter,	true,	 "ibflag");
                    InitDataProperty(0, cnt++ , 		dtDelCheck,	 40,	daCenter, 	true,	 "del_flg",			false,		"",			dfNone);
                    InitDataProperty(0, cnt++ , 		dtDataSeq,	 40,	daCenter, 	true,	 "seq",				false,		"",			dfNone);
                    InitDataProperty(0, cnt++ , 		dtHidden,	 40,	daCenter, 	true,	 "ev_itm_ord_no",	false,		"",			dfNone);
                    InitDataProperty(0, cnt++ , 		dtHidden,	 40,	daCenter, 	true,	 "ev_itm_seq",	false,		"",			dfNone);
					InitDataProperty(0, cnt++ , 		dtData,	     70,	daLeft,		true,	 "ev_itm_nm",		false,		"",			dfNone);					
					  
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
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
	    var formObj = document.form;
		obj = event.srcElement;       
	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        

	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
			              
	} 
	
	/**
	 * HTML Control의 change 이벤트 <br>
	 **/  
	function obj_change(){     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
	    } 
	}       
	



	/* ********* Event Functions ************* */ 

 	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
          case IBSEARCH:      //조회
        	  if(validateForm(sheetObj,formObj,sAction)){
	               formObj.f_cmd.value = SEARCH;

	    		    sheetObj.DoSearch("EES_MNR_0274GS.do", FormQueryString(formObj));
        	  }    
              break;
          case IBSAVE:        //저장
        	  if(validateForm(sheetObj,formObj,sAction)){
		            formObj.f_cmd.value = MULTI;
		            
					sheetObj.DoAllSave("EES_MNR_0274GS.do", FormQueryString(formObj));
        	    }
        	  doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
				
				break;  
	 	    case IBSAVE: // 저장
					  
			    break;  
	 	    case IBDELETE: // 삭제
	 	    	
			    break; 
   	    }
   	    return true;    
    }
    
    function rowAdd(){
    	sheetObjects[0].DataInsert();
    }
    
    /*function rowDel(){
    	for(var i = 2; i < sheetObjects[0].Rows; i++){
    		if(sheetObjects[0].CellValue(i,1) == '1'){
    			sheetObjects[0].RowDelete(i, false);
    		}
//    		alert(sheetObjects[0].CellValue(i,1) + " " + sheetObjects[0].CellValue(i,5));
//    		if(sheetObjects[0].CellValue(i,1) == '1'){
//    			alert(3);
//    			sheetObjects[0].RowDelete(i);		
//    		}
    	}
    	
    	
    }*/