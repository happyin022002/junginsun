/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0034.js
*@FileTitle : COD Reject Reason Code Creation
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
     * @class vop_opf_0034 : vop_opf_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0034() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_RowAdd":
//					if(!validateForm(sheetObject1,formObject)){
//						return false;
//					}
					var row = sheetObject1.DataInsert(-1);
					sheetObject1.CellText(row, "delt_flg") = "N";
					sheetObject1.SelectCell(row,"cod_rjct_cd",true);
					break;
					
				case "btn_RowInsert":
//					if(!validateForm(sheetObject1,formObject)){
//						return false;
//					}
					var row = sheetObject1.DataInsert();
					sheetObject1.CellText(row, "delt_flg") = "N";
					sheetObject1.SelectCell(row,"cod_rjct_cd",true);
					break;
					
				case "btn_RowCopy":
					sheetObject1.DataCopy();
//					if(!validateForm(sheetObject1,formObject)){
//						return false;
//					}
					break;

				case "btn_RowDelete":
					ComRowHideDelete(sheetObject1,"del_chk");
//					var row = sheetObject1.SelectRow;
//					//sheetObject1.RowDelete(row);
//					sheetObject1.RowHidden(row) = true;
//					sheetObject1.RowStatus(row) = "D";
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_close":
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
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                        style.height = 480;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);
                        
                        var HeadTitle = "|Sel.|No.|Code|Description|";
    					var headCount = ComCountHeadTitle(HeadTitle);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	true,	"del_chk");
                        InitDataProperty(0, cnt++ , dtDataSeq,		50,	daCenter,	true,	"seq");
                        InitDataProperty(0, cnt++ , dtData,		65,		daCenter,	true,	"cod_rjct_cd", 	true,	"",		dfEngUpKey,	0,	false,	true, 3);
                        InitDataProperty(0, cnt++ , dtData,		85,		daLeft,		true,	"cod_rjct_desc",true,	"",		dfEngDnKey,	0,	true,	true, 50);
                        InitDataProperty(0, cnt++ , dtHidden,	30,		daLeft,		true,	"delt_flg",  	false,	"",		dfNone,		0,	true,	true);
                        
                        InitDataValid(0, "cod_rjct_cd", vtEngUpOnly);
					}
                    break;
                    
            }
        }

        function doActionIBSheet(sheetObj,formObj,sAction) {
        	sheetObj.ShowDebugMsg = false;
    	    switch(sAction) {
    	    
    	      case IBSEARCH:      //조회
    	        formObj.f_cmd.value = SEARCH;
    	        sheetObj.DoSearch("VOP_OPF_0034GS.do", FormQueryString(formObj));
    	        break;
    	        
    	      case IBSAVE:        //저장
    	    	  if(!validateForm(sheetObj,formObj,sAction)){
    	    		  return false;
    	    	  }
    	        formObj.f_cmd.value = MULTI;
    	        sheetObj.DoSave("VOP_OPF_0034GS.do", FormQueryString(formObj), -1, false);
    	        break;
     	         
    	    }
    	}
        
        /**
         * Code Data Validation Check.
         */
        function sheet1_OnChange(sheetObj, row, col, value){
        	
        	if(sheetObj.ColSaveName(col)=="cod_rjct_cd"){
        		if(value.length!=3){
            		//ComShowMessage("Data Length 3");
            		ComShowCodeMessage("OPF50007", "Code","3");
            		sheetObj.SelectCell(row,col,true);
            		return false;
            	}
//            	else{
//            		for(i=1; i < (sheetObj.RowCount); i++){
//        				if(sheetObj.CellValue(row,col)==sheetObj.CellValue(i,col)){
//        					ComShowMessage("Data already Exist.");
//        					sheetObj.SelectCell(row,col,true,"");
//        					return false;
//        				}
//            		}
//            	}
        	}
        	
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	if(sheetObj.RowCount>0){
            		// Reject Reason Code 중복 Data 체크.
            		for(i=1; i< (sheetObj.RowCount+1); i++){
            			
            			if(sheetObj.CellValue(i,"cod_rjct_cd").length!=3){
                    		ComShowCodeMessage("OPF50007", "Code","3");
                    		sheetObj.SelectCell(i,"cod_rjct_cd",true);
                    		return false;
                    	}
            			
            			for(j=i+1; j< (sheetObj.RowCount+1); j++){
            				//alert(sheetObj.CellValue(i,"cod_rjct_cd")+"||"+sheetObj.CellValue(j,"cod_rjct_cd"))
	            			if(sheetObj.CellValue(i,"cod_rjct_cd") != null 
	            					&& sheetObj.CellValue(i,"cod_rjct_cd") != "" 
	            					&& sheetObj.CellValue(i,"cod_rjct_cd")==sheetObj.CellValue(j,"cod_rjct_cd"))
	            			{
	            				//ComShowMessage("Reject Reason Code is already exist.");
	            				ComShowCodeMessage("OPF50005", "Data");
	            				
	            				if(sheetObj.RowStatus(i)=="I"){
	            					sheetObj.SelectCell(i,"cod_rjct_cd",true);
	            				}else{
	            					sheetObj.SelectCell(j,"cod_rjct_cd",true);
	            				}
			    				return false;
	            			}
            			}
            		}
            		
            	}
            }

            return true;
        }

	/* 개발자 작업  끝 */