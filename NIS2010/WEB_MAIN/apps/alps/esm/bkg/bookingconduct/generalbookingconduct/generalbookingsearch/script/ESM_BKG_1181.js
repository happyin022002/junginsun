/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1181.js
*@FileTitle : Fumigation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.15
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
     * @class ui_bkg_1181 : ui_bkg_1181 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_bkg_1181() {
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
        var parentObject ;
		if(!opener){
			parentObject = window.dialogArguments.document.form;
		}else{
			try {
				parentObject = opener.document.form;
			}catch(e) {
				ComShowCodeMessage("COM12111");
			}
		}

        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {    							
				case "btn_Save": 		
					validateForm(formObject);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }        	
        var formObject = document.form;
        var parentObject ;
        
		if(!opener){	
				parentObject = window.dialogArguments.document.form;
		}else{	
			try {
				parentObject = opener.document.form;
			}catch(e) {
				ComShowCodeMessage("COM12111");
			}	   
		}     
        
        formObject.fumg_loc_cd.value       = parentObject.fumg_loc_cd.value;
        formObject.fumg_cntc_phn_no.value  = parentObject.fumg_cntc_phn_no.value;
        formObject.fumg_cntc_pson_nm.value = parentObject.fumg_cntc_pson_nm.value;
        formObject.fumg_diff_rmk.value     = parentObject.fumg_diff_rmk.value;
		
    	initControl();
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
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   	30,    	daCenter,  		false,     "ibflag");              
	                InitDataProperty(0, cnt++ , dtRadioCheck,		35,     daCenter,    	false,     "chk");
               }
               break;
        }
    }        
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj) {

		var sXml = sheetObj.getSearchXml("ESM_Booking_UtilGS.do" , "f_cmd="+SEARCHLIST17+"&input_text="+ComGetObjValue(formObj.fumg_loc_cd));

		if(ComGetEtcData(sXml,"output_text").length > 0){
            var formObject = document.form;

			var fumgLocCd      = ComGetObjValue(formObject.fumg_loc_cd);
			var fumgCntcPhnNo  = ComGetObjValue(formObject.fumg_cntc_phn_no);
			var fumgCntcPsonNm = ComGetObjValue(formObject.fumg_cntc_pson_nm);
			var fumgDiffRmk    = ComGetObjValue(formObject.fumg_diff_rmk);
			
			var calllFunc = formObject.calllFunc.value;
			if(calllFunc != ''){			
				 if(!opener){
					 eval('window.dialogArguments.'+calllFunc)(new Array(fumgLocCd, fumgCntcPhnNo, fumgCntcPsonNm, fumgDiffRmk));
				 }else{	 
					 try {
						 eval('opener.'+calllFunc)(new Array(fumgLocCd, fumgCntcPhnNo, fumgCntcPsonNm, fumgDiffRmk));
					 }catch(e) {
					 }	   
				 }     				
				
			}         			
			window.close();  
		} else {
			ComShowCodeMessage("BKG00061",ComGetObjValue(formObj.fumg_loc_cd));
		}
    }
    
    
    

    function initControl() {
    	var formObject = document.form;
    	//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    	axon_event.addListenerForm('keyup','obj_keyup', formObject);
    }
    
    // Remark의 글자수 제한
    function  obj_keyup(){
    	
    	switch (event.srcElement.name) {
 			case "fumg_diff_rmk":			
 				var frm = document.form.fumg_diff_rmk.value.length;
 				if(frm > 1000){
 					ComShowCodeMessage("BKG01137", "1000");
 					document.form.fumg_diff_rmk.value = document.form.fumg_diff_rmk.value.substring(0, 1000);    		
 				}
 				break;
    	}	
    }
    

     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObject){
		var fumgLocCd      = ComGetObjValue(formObject.fumg_loc_cd);
		var fumgCntcPhnNo  = ComGetObjValue(formObject.fumg_cntc_phn_no);
		var fumgCntcPsonNm = ComGetObjValue(formObject.fumg_cntc_pson_nm);
		var fumgDiffRmk    = ComGetObjValue(formObject.fumg_diff_rmk);
		
    	if(ComIsNull(ComGetObjValue(formObject.fumg_loc_cd))){
			var calllFunc = ComGetObjValue(formObject.calllFunc);
    		
			if(!opener)
				eval('window.dialogArguments.'+calllFunc)(new Array(fumgLocCd, fumgCntcPhnNo, fumgCntcPsonNm, fumgDiffRmk));
			try {
				 eval('opener.'+calllFunc)(new Array(fumgLocCd, fumgCntcPhnNo, fumgCntcPsonNm, fumgDiffRmk));
			}catch(e) {
			}	    
			window.close();      		
    	}else{
        	if(formObject.fumg_loc_cd.value.length > 5){
        		ComShowCodeMessage("COM12173","Location","5");
        	}else if(formObject.fumg_cntc_phn_no.value.length > 20){
        		ComShowCodeMessage("COM12173","Tel","20");
        	}else if(formObject.fumg_cntc_pson_nm.value.length > 30){
        		ComShowCodeMessage("COM12173","Contact Point","30");
        	}else if(formObject.fumg_diff_rmk.value.length > 500){
        		ComShowCodeMessage("COM12173","Remark","500");
        	}else{
        		doActionIBSheet(sheetObjects[0], formObject);
        	}    		
    	}
    }

	/* 개발자 작업  끝 */