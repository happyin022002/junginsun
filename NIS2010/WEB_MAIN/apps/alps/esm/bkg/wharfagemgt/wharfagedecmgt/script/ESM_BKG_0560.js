/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0560.js
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
    function esm_bkg_0560() {
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
            		doActionIBSheet(sheetObject1,document.form,IBSAVE);

            	break;				

            	case "btn_downexcel":
            		doActionIBSheet(sheetObject1,document.form,IBDOWNEXCEL);
            	break;
				
            	case "btn_add":
					sheetObject1.DataInsert(-1);
				break;
				
				case "btn_del":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
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
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress',         'obj_keypress',    formObject); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
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
	        case "engupnum":
	        	//숫자+"영문대분자"입력하기
          	    ComKeyOnlyAlphabet('uppernum'); 
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
		var sheetID = sheetObj.id;
		
		switch(sheetID) {
		    case "sheet1":      //sheet1 init
		        with (sheetObj) {
		
		            // 높이 설정
		            style.height = 420;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(2, 1, 2, 100);
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(15, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
										var HeadTitle1 = "||Sel.|CNTR/BULK|PORT|Bound|D/C|Effective Date|Effective Date|Amount|Amount|Amount|Rate|Rate|Rate";
										var HeadTitle2 = "||Sel.|CNTR/BULK|PORT|Bound|D/C|Start Date|End Date|20'|40'|45'|20'|40'|45'";
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);
		            var prefix = 'sheet1_'; 
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,        	30,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,        		30,		daCenter,		true,		prefix + "port_seq", 			false,			"",      dfInteger,		0,		true,		true, 22);
					InitDataProperty(0, cnt++ , dtCheckBox,			    40,		daCenter,		true,		prefix + "Chk");
					InitDataProperty(0, cnt++ , dtCombo,				120,	daCenter,		true,		prefix + "cntr_blk_div_cd",		false,			"",      dfNone,		0,		false,		true, 4);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		prefix + "port_cd",				false,			"",      dfNone,		0,		false,		true, 5);
					InitDataProperty(0, cnt++ , dtCombo,				60,		daCenter,		true,		prefix + "io_bnd_cd",			false,			"",      dfNone,		0,		false,		true, 2);
		                                                                                                                    
					InitDataProperty(0, cnt++ , dtCombo,				70,		daCenter,		true,		prefix + "dc_rto_no",			false,			"",      dfNone,		0,		false,		true, 4);
					
					InitDataProperty(0, cnt++ , dtData, 		 		70,   	daCenter,    	true,       prefix + "eff_fm_dt", 			false,    		"",      dfDateYmd,		0,     true,		true);			
					InitDataProperty(0, cnt++ , dtData, 		 		70,   	daCenter,    	true,       prefix + "eff_to_dt", 			false,    		"",      dfDateYmd,		0,     true,		true);			
					
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,		prefix + "teu_prc",				false,			"",      dfInteger,		0,		true,		true, 22);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,		prefix + "feu_prc",				false,			"",      dfInteger,		0,		true,		true, 22);
					InitDataProperty(0, cnt++ , dtData,					75,		daCenter,		true,		prefix + "hc_prc",				false,			"",      dfInteger,		0,		true,		true, 22);
					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,		prefix + "teu_amt_rt",			false,			"",      dfFloat,		2,		true,		true, 8);

					InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,		prefix + "feu_amt_rt",			false,			"",      dfFloat,		2,		true,		true, 8);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,		prefix + "hc_amt_rt",			false,			"",      dfFloat,		2,		true,		true, 8);
		
					
					InitDataCombo(0, prefix + "cntr_blk_div_cd", "CNTR|BULK", "C|B");		
					InitDataCombo(0, prefix + "io_bnd_cd", "II|OO", "I|O");		
					InitDataCombo(0, prefix + "dc_rto_no", "0%|20%|30%|50%|70%|80%|100%|", "0|1|7|2|8|3|4");		
		
					InitDataValid(0, prefix +"port_cd", vtEngUpOther, "0123456789");
					//InitDataValid(0, prefix +"port_cd", vtEngUpOther);
					//InitDataValid(0, prefix +"port_cd", vtNumericOther, ".");
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
					sheetObj.DoSearch("ESM_BKG_0560GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
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
	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0560GS.do", sParam);
	    	        sheetObj.LoadSaveXml(SaveXml);
				}    
    	    break;
			
			case IBDELETE:      // 삭제
				var checked = 0;
				for (var i = 2 ; i <= sheetObj.RowCount +1 ; i++){
					if( sheetObj.CellValue(i,2) == '1' ){
						checked = 1;
						if (sheetObj.CellValue(i,0) != "I"){
							if( sheetObj.CellValue(i,2) == '1' ){
								sheetObj.RowHidden( i ) = true;
								sheetObj.RowStatus( i ) = "D";
							}
						}else{
							if( sheetObj.CellValue(i,2) == '1' ){
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
					sheetObjects[0].Down2Excel(-1, false, false, true, "", "", false, false, "", true, "sheet1_Chk");
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
	 			if (formObj.port_cd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 							
	 			return true;
	 		break;
	 		case IBSAVE: // 저장
	 			
	 			for(var i=2; i<=sheetObj.RowCount + 1 ; i++){
	 				
	 				if( sheetObj.CellValue(i,0) == 'I' || sheetObj.CellValue(i,0) == 'U'){
	 					
		 				if( formObj.port_cd.value == ''){
	 						ComShowCodeMessage('BKG00104');
	 		 				return false;
	 					} 
	 					if(sheetObj.CellValue(i,4) == '' ){
	 						ComShowCodeMessage('COM130201', 'Port Code');
	 		 				return false;
	 					} 
	 					if(sheetObj.CellValue(i,7) == '' ){
	 						ComShowCodeMessage('COM130201', 'Start Date');
	 						return false;
	 					} 
	 					if(sheetObj.CellValue(i,8) == '' ){
	 						ComShowCodeMessage('COM130201', 'End Date');
	 						return false;
	 					} 		 				
	 					if( sheetObj.CellValue(i,7) >= sheetObj.CellValue(i,8)){
	 						ComShowCodeMessage('COM12133', "End Date", "Start Date", "larger");
	 						return false;
	 					} 
	 				}
	 				
	 			}
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
    
     
	/* 개발자 작업  끝 */    