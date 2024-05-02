/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1099.js
*@FileTitle : Integrated Customer Data Update Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 곽영범
*@LastVersion : 1.0
* 2010.07.28 곽영범
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
     * @class ESM_BKG_1099 : ESM_BKG_1099 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1099() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
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
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
            case "btn_Retrieve":
            	
            	if (formObj.ofc_cd.value != "") {
            		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);   
            	} else {
            		//msgs['COM12200'] = "Mandatory field is missing. Please enter {?msg1}.";  //COM130403-> db메세지 코드와 상이함
            		ComShowCodeMessage("COM12200","Office");
            	}
            	
            	break;                      
            case "btn_Save":
            	            	
            	if ((formObj.ofc_cd.value != "") && (formObj.auto_upd_flg.value != sheetObj.CellValue(1, "auto_upd_flg"))) {
            		
                	doActionIBSheet(sheetObjects[0],formObj,MULTI);
                	
                	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);   
                	
//                	ComShowCodeMessage("BKG00102");
            	} else {
            		
            		ComShowCodeMessage("BKG00233");
            	}
            	
                break;                      

            case "btn_Close":
            	
            	if (sheetObj.CellValue(1, "auto_upd_flg") == "" && formObj.auto_upd_flg.value == "Y") {
            		window.close();
            		break;
            	}
            		
            	if (formObj.auto_upd_flg.value != sheetObj.CellValue(1, "auto_upd_flg")) {
            		if(ComShowCodeConfirm("BKG00168")) {
            			doActionIBSheet(sheetObjects[0],formObj,MULTI);
            			window.close();
            		} else {
            			window.close();
            		}
            	} else {
            		window.close();
            	}

                break;
                
            
            } // end switch
        } catch(e) {
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
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     */
    function loadPage() {
        //initControl();

		for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );

				initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
    	 
         if (document.form.ofc_cd.value != "") {
         	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         	
         }

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
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 2, 100);

                     var HeadTitle = "|ofc_cd|auto_upd_flg|upd_usr_id|upd_locl_dt" ;
 					var headCount = ComCountHeadTitle(HeadTitle);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,			"ibflag");
 					InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,			true,			"ofc_cd",		    false,			"",      dfNone,	0,		false,		false);
 					InitDataProperty(0, cnt++ , dtData,			30,    	daCenter,   	true,   		"auto_upd_flg",		false,			"",      dfNone,	0,		false,		false);
 					InitDataProperty(0, cnt++ , dtData,			40,    	daLeft ,    	true,   		"upd_usr_id",		false,			"",      dfNone,	0,		false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	70,	    daCenter  ,	    true,        	"upd_locl_dt",		false,	        "",      dfNone,	0,      false,      false);
 					
 					ShowButtonImage = 1;

 					WaitImageVisible=false;

             }
                 break;
                  
         }
     }
     


    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
	         //조회
	     	 case IBSEARCH:
	     		formObj.f_cmd.value = SEARCH;
	     		//if(!validateForm(sheetObj,formObj,sAction)) return;
	
	     		sheetObj.DoSearch("ESM_BKG_1099GS.do", FormQueryString(formObj));
	     		
	     		if(sheetObj.RowCount > 0) {
		     		if(sheetObj.CellValue(1, "auto_upd_flg") == "Y") {
		     			formObj.auto_upd_flg.value = "Y";
		     		} else {
		     			formObj.auto_upd_flg.value = "N";
		     		}
		     		upd_usr_id.innerHTML = sheetObj.CellValue(1, "upd_usr_id") + " / " + sheetObj.CellValue(1, "upd_locl_dt")
		     		
	     		} else {
	     			formObj.auto_upd_flg.value = "Y";
	     			upd_usr_id.innerHTML = ""
	     		}
	     		break;
	     		

	     	case MULTI:
	     		
	     		if(!validateForm(sheetObj,formObj,sAction)) return;

	     		formObj.f_cmd.value = MULTI;
	     		var params = FormQueryString(formObj)
	     		//alert(params);
	     		var sXml = sheetObj.GetSaveXml("ESM_BKG_1099GS.do", FormQueryString(formObj));

	     		sheetObj.LoadSaveXml(sXml);
	     		break;	     		
	     		
         }
     }
        

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(formObj,sAction){
      	switch(sAction) {
     	case IBSEARCH:
  	    	//if (!ComChkValid(formObj)) return false;
  	    	break;
        }
         	
        return true;
    }

    
    /* 개발자 작업  끝 */