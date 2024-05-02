/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0733.js
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
    function esm_bkg_0733() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	//this.sheet1_OnClick         = sheet1_OnClick;
    	//this.sheet1_OnKeyUp         = sheet1_OnKeyUp;
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
            		doActionIBSheet(sheetObjects[0],document.form,IBSAVE);

            	break;				

            	case "btn_downexcel":
            		doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
            	break;
				
            	case "btn_add":
					sheetObject1.DataInsert(-1);
				break;
				
				case "btn_del":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;	
									
				case "btn_close":
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

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	ComSetFocus(formObject.loc_cd);
 
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
    }
    
    /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 */
    function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
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
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}        

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
    			var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 342;
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

    				var HeadTitle1 = "|Sel|SML Code|MF Code";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix = 'sheet1_';
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		prefix + "ibflag");
    				InitDataProperty(0, cnt++ , dtCheckBox,		70,		daCenter,		false,		prefix + "Chk",					false,		"",		dfNone,					0,		true,		true);
    				InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		false,		prefix + "loc_cd",				false,		"",		dfNone,					0,		true,		true, 5);
    				InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		false,		prefix + "un_loc_id",			false,		"",		dfNone,					0,		true,		true, 5);
    				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,		false,		prefix + "oloc_cd",				false,		"",		dfNone,					0,		true,		true, 5);
    				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,		false,		prefix + "oun_loc_id",			false,		"",		dfNone,					0,		true,		true, 5);
    				
    				InitDataValid(0, prefix +"loc_cd", vtEngUpOther, "0123456789");
    				InitDataValid(0, prefix +"un_loc_id", vtEngUpOther, "0123456789");
    	    				
    				CountPosition = 0;

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
					sheetObj.DoSearch("ESM_BKG_0733GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
        		}
			break;
			
			case IBSAVE:        //저장
				
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value = MULTI;
				    if (! sheetObj.IsDataModified ){
				    	ComShowCodeMessage('BKG00233');
	    	        	return;
	    	        }
				    
				    var sParam = ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0733GS.do", sParam);
	    	        sheetObj.LoadSaveXml(SaveXml);
				}    
    	    break;
			
			case IBDELETE:      // 삭제
				var checked = 0;
				for (var i = 1 ; i <= sheetObj.RowCount ; i++){
					if( sheetObj.CellValue(i,1) == '1' ){
						checked = 1;
						if (sheetObj.CellValue(i,0) != "I"){
							if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.RowHidden( i ) = true;
								sheetObj.RowStatus( i ) = "D";
							}
						}else{
							if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.RowStatus( i ) = "D";
								i--;
							}
						}
					}	
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			
			break;
			case IBDOWNEXCEL:
				if( sheetObj.RowCount > 0 )
					sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true, "sheet1_Chk");
				else
					ComShowCodeMessage('BKG00389');
				
			break;
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			//if( ComChkLen(formObj.loc_cd.value, 5) != "2"  ){
	 			if( formObj.loc_cd.value == "" && formObj.un_loc_id.value == "" ){
	 			
	/*	 			if( formObj.loc_cd.value == ""  ){
		 				ComShowCodeMessage('BKG00887', 'SML Code');
		 				formObj.loc_cd.focus();
		 				return false;
		 			}
		 			if( formObj.un_loc_id.value == ""  ){
		 				ComShowCodeMessage('BKG00887', 'MF Code');
		 				formObj.un_loc_id.focus();
		 				return false;
		 			}*/
	 			}
	 							
	 			return true;
	 		break;
	 		case IBSAVE: // 저장
	 			
	 			//if ( ComShowCodeConfirm('BKG00386') == false ) return false;
	 			
	 			return true;
	 		break;
	 		case IBDELETE: // 저장
	 			
	 			if (formObj.port_cd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00266');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 							
	 			return true;
	 		break;
     	}
     }

     /**
      * addrow시   데이터 타입설정
      */    
     function addRowEdit(sheetObj,formObj){
   
    	 //var Row = sheetObj.SelectRow;
    	 //sheetObj.CellValue2(Row,1) = "1";
    	 //sheetObj.CellEditable(Row, 5) = false;
     }		
     
	/* 개발자 작업  끝 */    