/*=========================================================
*@FileName : esm_bkg_s002.js
*@FileTitle : State Master Data(India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.03
*@LastModifier : 임진영
*@LastVersion : 1.0
=========================================================*/
    /**
     * @extends 
     * @class esm_bkg_s002 : esm_bkg_s002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_s002() {
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
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
					case "btn_save":
			            if(sheetObjects[0].IsDataModified == true){//수정여부에 따라
			                if(validateForm(sheetObjects[0],formObject,IBSAVE)){
			                	doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			                }
			            }else{
			                ComShowCodeMessage("BKG00233");
			                return;
			            }
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
        	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        	axon_event.addListenerForm('keypress', 'objKeyPress', form);
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
                        style.height = 480;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false);

                        var HeadTitle1 = "|Seq.|State Code|India State Code|State Name|State/Union TErritory";

                        var headCount = ComCountHeadTitle(HeadTitle1);
                        
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                    	
                        //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                        InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,	"Seq");
 						InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	true,	"ste_cd", 			false,			"",		 dfNone,			0,		false,	    true,  50);                    
 						InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,	"ind_ste_cd",		true,			"",      dfNone,			0,		true,		true,	50);
						InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,	"ste_nm",			false,			"",      dfNone,			0,		false,		true,	50);
						InitDataProperty(0, cnt++ , dtCombo,		200,	daCenter,	true,	"ind_terr_div_cd",	true,			"",      dfNone,			0,		true,		true,  50);
						
						InitDataCombo(0, "ind_terr_div_cd", "State|UT", "S|U");
						InitDataValid(0, "ind_ste_cd", vtNumericOnly );
						WaitImageVisible = false;
                   }
                    break;

            }
        }

		
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
	           case IBSEARCH:      //조회
		          if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH;
		        	  sheetObj.WaitImageVisible = false;
		        	  ComOpenWait(true);
		        	  sheetObj.DoSearch("ESM_BKG_S002GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
		        	  ComOpenWait(false);
		          }	
	               	break;
	
	           case IBSAVE:        //저장

		            if (!ComShowConfirm(ComGetMsg("BKG00824")))
		                return; // Are you sure to save the changes?
			    	if(!validateForm(sheetObj,formObj,sAction)){
			    		return;
			    	}
		    	    ComOpenWait(true);
			    	formObj.f_cmd.value = MULTI;
			    	sheetObj.DoSave("ESM_BKG_S002GS.do", FormQueryString(formObj), -1, false);
			    	ComOpenWait(false);
			    	break;
					
					
					
	           
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	with(sheetObj){
       	     
        	}

        	return true;
        }
        
        function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
            if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) != "S") {
                // 저장시 에러났을 경우 삭제된 Row 를 원래대로 보여줌
                var sRow = sheetObj.FindStatusRow("D");
                var arRow = sRow.split(";");
                for (var i = 0, n = arRow.length-1 ; i < n ; i++) {
                    sheetObj.RowHidden(arRow[i]) = false;
                    sheetObj.RowStatus(arRow[i]) = "R";
                }
            }
            
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        
        /**
         * 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
         * <br>
         * <b>Example : </b>
         *
         * <pre>
         * </pre>
         *
         * @param {void}
         * @return void
         * @author Park Mangeon
         * @version 2009.10.01
         */
        function objKeyPress() {
            var objName = event.srcElement.name;
            var formObj = document.form;
            switch(objName) {
        	    case "ind_ste_cd":
        		    ComKeyOnlyNumber(event.srcElement);
        		    break;

            }
        }
        
        
	/* 개발자 작업  끝 */