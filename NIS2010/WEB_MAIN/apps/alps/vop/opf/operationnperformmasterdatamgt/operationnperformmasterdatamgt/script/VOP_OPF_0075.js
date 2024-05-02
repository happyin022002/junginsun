/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0075.js
*@FileTitle : Restow Reason Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
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
     * @class vop_opf_0075 : vop_opf_0075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0075() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	//this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	//this.validateCode			= validateCode;
    	this.sheet2_OnChange		= sheet2_OnChange;
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
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
	         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		var prefix = "sheet2_"

            switch(srcName) {
				case "btn_RowAdd":
					//doActionIBSheet(sheetObject2,formObject,IBINSERT);
					var row = sheetObject2.DataInsert(-1);
					//sheetObject2.CellText(row, prefix+"rstwg_cd_tp_cd") = sheetObject1.CellText(sheetObject1.SelectRow, "sheet1_rstwg_cd_tp_cd");
					sheetObject2.CellValue(row, prefix+"delt_flg") = "N";
					sheetObject2.SelectCell(row,prefix+"rstwg_rsn_cd",true);
					break;
					
				case "btn_RowInsert":
					//doActionIBSheet(sheetObject2,formObject,"IBINSERT01");
					var row = sheetObject2.DataInsert();
					//sheetObject2.CellText(row, prefix+"rstwg_cd_tp_cd") = sheetObject1.CellText(sheetObject1.SelectRow, "sheet1_rstwg_cd_tp_cd");
					sheetObject2.CellValue(row, prefix+"delt_flg") = "N";
					sheetObject2.SelectCell(row,prefix+"rstwg_rsn_cd",true);
					break;
					
				case "btn_RowCopy":
					var row = sheetObject2.DataCopy();
					//validateCode(sheetObject2,row,2,sheetObject2.CellValue(row, prefix+"rstwg_rsn_cd"));
					break;
					
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject2,"sheet2_del_chk");
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH, sheetObject1);
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
					break;
					
				case "btn_Close":
					self.close();
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

	        //khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );

				initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			
	    	//Sheet1 Default Data Setting..
			initDefaultSheet(sheetObjects[0], document.form);
			
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH, sheetObjects[0]);
	}
    
    /**
     * Sheet1  Default Data Setting.
     * 화면을 브라우저에서 로딩시에 기본적으로 보여줄 데이터를 세팅한다.
     */
    function initDefaultSheet(sheetObj, formObj){
    	var prefix = "sheet1_";
    	sheetObj.DataInsert();
    	sheetObj.DataInsert();
    	sheetObj.CellText(1, prefix+"rstwg_cd_tp_cd") = "B";
    	sheetObj.CellText(1, prefix+"shifting_method") = "Cell to Cell restow (1 move)";
    	sheetObj.CellText(2, prefix+"rstwg_cd_tp_cd") = "Q";
    	sheetObj.CellText(2, prefix+"shifting_method") = "Via the Quay restow (2 moves)";
    	//sheetObj.SelectRow = 1;
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

                case "sheet1":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 79;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, -1, 100);
                        
                        var HeadTitle = "|Code|Shifting Method";
    					var headCount = ComCountHeadTitle(HeadTitle);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, false, false, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix="sheet1_";
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");						
						InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"rstwg_cd_tp_cd",	false,	"",  dfNone, 0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,	150,daLeft,		true,	prefix+"shifting_method",	false,	"",  dfNone, 0,	false,	false);
						
						SelectFontBold = false;
						SelectHighLight = false;
						FocusStyle = 0;
					}
                    break;
                    
                case "sheet2":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 440;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 1, 2);
                        
                        var HeadTitle = "|Sel.|No.|Code|Account and Reason|";
    					var headCount = ComCountHeadTitle(HeadTitle);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix="sheet2_";
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
						InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	true,	prefix+"del_chk");
						InitDataProperty(0, cnt++ , dtDataSeq,		50,	daCenter,	true,	prefix+"seq");
						InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"rstwg_rsn_cd",			true,	"",  dfEngUpKey,	0,	false,	true, 2);
						InitDataProperty(0, cnt++ , dtData,	150,daLeft,		true,	prefix+"rstwg_rsn_cd_full_desc",false,	"",  dfEngDnKey,	0,	true,	true, 500);
						InitDataProperty(0, cnt++ , dtHidden,50,daCenter,	true,	prefix+"delt_flg",				false,	"",  dfNone,	0,	false,	true);
						
						InitDataValid(0, prefix+"rstwg_rsn_cd", vtEngUpOnly);
					}
                    break;


            }
        }

        function doActionIBSheet(sheetObj,formObj,sAction, sheetObj1) {
        	sheetObj.ShowDebugMsg = false;
    	    switch(sAction) {
    	    
    	      case IBSEARCH:      //조회
    	        formObj.f_cmd.value = SEARCH;
    	        sheetObj.DoSearch("VOP_OPF_0075GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
    	        break;
    	        
    	      case IBSAVE:        //저장
    	        if(!validateForm(sheetObj,formObj,sAction)) {
    	            return false;
    	        }//end if
    	        formObj.f_cmd.value = MULTI;
    	        sheetObj.DoSave("VOP_OPF_0075GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"), -1, false);
    	        break;
    	    }
    	}
        
        /**
         * Code Length Check.
         */
        function sheet2_OnChange(sheetObj, row, col, value){
        	if(sheetObj.ColSaveName(col)=="sheet2_rstwg_rsn_cd"){
        		if(value.length!=2){
    	    		//ComShowMessage("Data Length 2");
    	    		ComShowCodeMessage("OPF50007", "Code","2");
    	    		sheetObj.SelectCell(row,col,true);
    	    		return false;
    	        }
        	}
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	
        	if(sheetObj.RowCount>0){
        		// Code 중복 체크.
        		for(i=1; i< (sheetObj.RowCount+1); i++){
        			for(j=i+1; j< (sheetObj.RowCount+1); j++){
        				//alert(sheetObj.CellValue(i,"sheet2_rstwg_rsn_cd")+"||"+sheetObj.CellValue(j,"sheet2_rstwg_rsn_cd"));
        				
        				if(sheetObj.CellValue(i,"sheet2_rstwg_rsn_cd").length != 2){
        					ComShowCodeMessage("OPF50007", "Code","2");
        					sheetObj.SelectCell(i,"sheet2_rstwg_rsn_cd",true);
        					return false;
        				}
        				else if(sheetObj.CellValue(i,"sheet2_rstwg_rsn_cd") != null 
            				&& sheetObj.CellValue(i,"sheet2_rstwg_rsn_cd") != "" 
            				&& sheetObj.CellValue(i,"sheet2_rstwg_rsn_cd")==sheetObj.CellValue(j,"sheet2_rstwg_rsn_cd"))
            			{
            				//ComShowMessage("Code is already exist.");
            				ComShowCodeMessage("OPF50005", "Data");
            				
            				if(sheetObj.RowStatus(i)=="I"){
            					sheetObj.SelectCell(i,"sheet2_rstwg_rsn_cd",true);
            				}else{
            					sheetObj.SelectCell(j,"sheet2_rstwg_rsn_cd",true);
            				}
            				
		    				return false;
            			}
        			}
        		}
        		
        	}
        	
            return true;
        }

	/* 개발자 작업  끝 */