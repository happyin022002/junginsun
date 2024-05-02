/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0760.js
*@FileTitle : Hold Notice : Confirm-Hold Notice Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.09.10 박미옥
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
     * @class ESM_BKG_0760 : ESM_BKG_0760 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0760() {
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
    
    var org_pod_cd = "";
    var orgPodList;
    var orgObj = new Object();
    var isNew        = true;
    var isRetrieved  = false;
    var isAutoSelect = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "btn_Retrieve":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                break;

            case "btn_New":
            	initForm();
                break;

            case "btn_Save":
            	doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;

            case "btn_ConfirmHoldNotice":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
                break;

            case "btn_Delete":
            	doActionIBSheet(sheetObject1, formObject, IBDELETE);
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
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
    function setSheetObject(sheet_obj) {
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
        for (k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
        }
        
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }       
        
		initForm();
    	initControl();
    	
    	var sheetObj = sheetObjects[0];
    	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
    	document.form.ofc_cd.focus();
    	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
    
     
     
    /**
     * Form 데이터 초기화 작업. 화면 Open 또는 데이터 삭제 후 초기값을 설정한다.
     * 
     * @return 없슴
     */
    function initForm() {
        with(document.form) {
     		ComSetObjValue(frm_eclz_obl_flg, "N");
     		frm_addr_ctnt.value = "";
     		frm_snd_ofc_cntc_ctnt.value = "";     		
     		frm_t1_hld_rmk.value = "";
     		frm_t2_hld_rmk.value = "";
     		frm_t3_hld_rmk.value = "";
     		frm_t4_hld_rmk.value = "";
     		frm_t5_hld_rmk.value = "";
     		
 		    org_pod_cd = "";
 		    orgPodList = "";
 		    orgObj       = new Object();
 		    isNew        = true;
 		    isRetrieved  = false;
 		    isAutoSelect = false;
     	}
    }

    
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
     	axon_event.addListener("keydown","ComKeyEnter", "ofc_cd", "pod_cd");
      	axon_event.addListener("keydown","obj_keydown2", "ofc_cd", "frm_t1_hld_rmk", "frm_t2_hld_rmk", 
      			"frm_t3_hld_rmk", "frm_t4_hld_rmk", "frm_t5_hld_rmk");
      	axon_event.addListener("keyup","obj_keyup", "ofc_cd", "pod_cd");
    }

    
    /**
     * Key Up 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_keyup() {
        var sheetObject1 = sheetObjects[0];
      	var formObject = document.form;
      	
      	switch(event.srcElement.name) {
        case "ofc_cd":
            if (event.srcElement.value.length == 5) {
         	    doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
         	}
         	break;
      	case "pod_cd":
      		fncFindComboCode(event.srcElement, formObject.pod_cd_list);
      		break;
 	    }
    }     
     
    
    /**
     * Key Down 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_keydown2() {
        var formObject = document.form;

      	switch(event.srcElement.name) {
        case "ofc_cd":
         	formObject.pod_cd.value = "";
         	formObject.pod_cd_list.RemoveAll();
         	break;
        case "frm_t1_hld_rmk":
        case "frm_t2_hld_rmk":
        case "frm_t3_hld_rmk":
        case "frm_t4_hld_rmk":
        case "frm_t5_hld_rmk":
            if (checkMaxLine(event.srcElement, 20) == false) {
        	    if(event.keyCode == 13) { 	  
        	   	    event.returnValue = false;
        	   	}
        	}
        	break;
         }
    }
     
    
    /**
     * IBTab Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {object} tab_obj 필수, Tab 컨트롤
     * @return 없슴
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
     * Tab 기본 설정 <br>
     * 탭의 항목을 설정한다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    tabNo  필수, Tab 오브젝트 일련번호
     * @return 없슴
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Event#1" , -1 );
                    InsertTab( cnt++ , "Event#2" , -1 );
                    InsertTab( cnt++ , "Event#3" , -1 );
                    InsertTab( cnt++ , "Event#4" , -1 );
                    InsertTab( cnt++ , "Event#5" , -1 );
                }
             break;

         }
    }
     
    
    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {
          var cnt = 0;

          switch(sheetObj.id) {
          
          // Word Information
          case "sheet1":
          	with (sheetObj) {
          		// 높이 설정
                  style.height = 0;
                  
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;
                  
                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                  
                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 1, 1, 1);
                  
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                  InitHeadMode(false, false, false, false, false, false);
                  
                  var HeadTitle1 = "|Office|POD|Type|Send Type|OBL Copy|Content|Contact";
                  
                  var headCount = ComCountHeadTitle(HeadTitle1);
                  
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true);
          
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true);
                  
                  //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus, 0,   daCenter,  false,    "ibflag");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "ofc_cd");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "pod_cd");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "hld_ntc_tp_cd");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "auto_ntc_flg");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "eclz_obl_flg");
                  InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "addr_ctnt");
                  InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "snd_ofc_cntc_ctnt");
                  
                  CountPosition = 0;
          	}
          	
          	break;
          	
          // Detail Information
          case "sheet2":
              with (sheetObj) {
                  // 높이 설정
                  style.height = 0;
                  
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;
                  
                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                  
                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 1, 1, 1);
                  
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(false, false, false, false, false, false)
                  
                  var HeadTitle1 = "|Office|POD|Type|Form|Remark";
                  
                  var headCount = ComCountHeadTitle(HeadTitle1);
                  
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true);
          
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true);
                  
                  //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus, 0,   daCenter,  false,    "ibflag");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "ofc_cd");
                  InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "pod_cd");
                  InitDataProperty(0, cnt++ , dtData,         40,   daLeft,    false,    "hld_ntc_tp_cd");
                  InitDataProperty(0, cnt++ , dtData,         40,   daLeft,    false,    "hld_ntc_fom_cd");
                  InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "hld_rmk");
                  
                  CountPosition = 0;
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
          //sheetObj.ShowDebugMsg = false;
      	  sheetObj.WaitImageVisible = false;

          switch(sAction) {
          
          // DEL 목록 조회 및 콤보 생성
          case IBSEARCH_ASYNC01:        
          	  if (validateForm(sheetObj,formObj,sAction) == false) return; 
          	
          	  formObj.f_cmd.value = SEARCH01;
          	  var sXml = sheetObj.GetSearchXml("ESM_BKG_0511GS.do", FormQueryString(formObj));
          	  orgPodList = sXml;
          	  ComXml2ComboItem(sXml, formObj.pod_cd_list, "pod_cd", "pod_cd");
           	  if (org_pod_cd == "") {
            	  formObj.pod_cd_list.Code = "ALL";
        	  } else {
            	  formObj.pod_cd_list.Code = org_pod_cd;
        	  }
          	  org_pod_cd = "";
          	
          	  break;

          	  
          	  
          // 조회
          case IBSEARCH:
          	  if (validateForm(sheetObj,formObj,sAction) == false) return; 

          	  ComOpenWait(true);
          	
              formObj.f_cmd.value = SEARCH;
              var sXml = sheetObj.GetSearchXml("ESM_BKG_0760GS.do", FormQueryString(formObj));

              var arrXml = sXml.split("|$$|");

              sheetObjects[0].LoadSearchXml(arrXml[0]); // Word
              sheetObjects[1].LoadSearchXml(arrXml[1]); // Event#1
              
              if (ComGetTotalRows(arrXml[0]) == 0) {
              	isNew = true;
              } else isNew = false;
             	
              copyRowToForm();

              ComOpenWait(false);

              break;
          	
              
              
          // 저장
          case IBSAVE:
          	  if (isRetrieved == false) {
          		  ComShowCodeMessage("BKG00448"); 
          		  break;
          	  }
          	
          	  if(validateForm(sheetObj,formObj,sAction) == false) break;

          	  if (isChangedSearchKeyword() == false) {
          		  ComShowCodeMessage("BKG01072");
  	    	      resetSearchKeyword();
  	    	      break;
          	  }
          	
              copyFormToRow();
          	
              if (ComIsModifiedSheets(sheetObjects) == false) {
              	  ComShowCodeMessage("BKG00743");
              	  break;
          	  }

      		  if (ComShowCodeConfirm("BKG00824") == false) {
      			  break;
      		  }

      		  
      		  ComOpenWait(true);
      		
              formObj.f_cmd.value = MULTI;
              var sParam = "f_cmd=" + formObj.f_cmd.value;
              var sParamSheet1 = sheetObjects[0].GetSaveString(true);
              if (sParamSheet1 == "") {
            	  ComOpenWait(false);
            	  return;
              }
              else sParam += "&" + sParamSheet1;
              
              var sParamSheet2 = sheetObjects[1].GetSaveString(true);
              if (sParamSheet2 == "") {
            	  ComOpenWait(false);
            	  return;
              }
              else sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");

              var sXml = sheetObj.GetSaveXml("ESM_BKG_0760GS.do", sParam);

              sheetObjects[0].LoadSaveXml(sXml);
              
  			  sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용.
  			  sheetObjects[1].LoadSaveXml(sXml);
  			  
  			  ComOpenWait(false);
              
          	  break;     
          	
          	  
          	  
          	  // 삭제 
          case IBDELETE:
          	  if (isRetrieved == false) {
          		  ComShowCodeMessage("BKG00448"); 
          		  break;
          	  }
          	
          	  if(validateForm(sheetObj,formObj,sAction) == false) break;

          	  if (isChangedSearchKeyword() == false) {
          		  ComShowCodeMessage("BKG01072");
  	    	      resetSearchKeyword();
  	    	      break;
          	  }
          	
          	  if (ComShowCodeConfirm("BKG00592") == false) {
          		  break;
          	  }
          	
          	  ComOpenWait(true);
          	
          	  formObj.f_cmd.value = REMOVE;
          	  var sXml = sheetObj.GetSearchXml("ESM_BKG_0511GS.do", FormQueryString(formObj));
              sheetObjects[0].LoadSaveXml(sXml);
              
              ComOpenWait(false);
              
          	  break;
          	  
          	  
          	  
          	  // Confirm-Hold Notice Popup 호출
          case IBSEARCH_ASYNC03:
        	  ComOpenPopupWithTarget('/hanjin/ESM_BKG_0510_01.do?pgmNo=ESM_BKG_0510-01', 1020, 700, "", "none", true);
        	  break;
          }
    }
      
      
    /**
     * Sheet 데이터를 Form 으로 복사한다.<br>
     * 
     * @return 없슴
     */
    function copyRowToForm() {
     	
      	var formObj = document.form;
  		var prefix = "";
      	
      	with (formObj) {

      		// Setup Information
    		prefix = "frm_";
			var sheetObj = sheetObjects[0];
  			if (sheetObj.RowCount == 0) {  				
  				sheetObj.DataInsert(0);

      			sheetObj.CellValue(1,"ofc_cd")            = ofc_cd.value;
      			sheetObj.CellValue(1,"pod_cd")            = pod_cd.value.trim() == "" ? "ALL" : pod_cd.value;
      			sheetObj.CellValue(1,"hld_ntc_tp_cd")     = hld_ntc_tp_cd.value;
      			sheetObj.CellValue(1,"auto_ntc_flg")      = "N";
      			sheetObj.CellValue(1,"eclz_obl_flg")      = "";
      			sheetObj.CellValue(1,"addr_ctnt")         = "";
      			sheetObj.CellValue(1,"snd_ofc_cntc_ctnt") = "";
      		}

  			IBS_CopyRowToForm(sheetObj, formObj, 1, prefix);

      	
			sheetObj = sheetObjects[1];
		    if (sheetObj.RowCount == 0) { 	  				
	  			for (var i=1; i<=5; i++) {
	      			sheetObj.DataInsert(i-1);

	      			sheetObj.CellValue(i,"ofc_cd")         = ofc_cd.value;
	      			sheetObj.CellValue(i,"pod_cd")         = pod_cd.value.trim() == "" ? "ALL" : pod_cd.value;
	      			sheetObj.CellValue(i,"hld_ntc_tp_cd")  = hld_ntc_tp_cd.value;
	      			sheetObj.CellValue(i,"hld_ntc_fom_cd") = "E" + i;
	      			sheetObj.CellValue(i,"hld_rmk")        = "";
	  			}
		    }

  			for (var i=1; i<=5; i++) {
  				prefix = "frm_t" + i + "_";
  	  			IBS_CopyRowToForm(sheetObj, formObj, i, prefix);
  			}
      	}
    }
      
    
    /**
     * Form 데이터를 Sheet 로 복사한다.<br>
     * 
     * @return 없슴
     */
    function copyFormToRow() {
      	var formObj = document.form;
      
      	IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
      	
      	for (var i=1; i<=5; i++) {
          	IBS_CopyFormToRow(formObj, sheetObjects[1], i, "frm_t" + i + "_");
      	}
    }
      
  	
    /**
     * 조회 조건 변경 여부를 반환한다.<br>
     * 
     * @return boolean true: 조회조건 변경 됨, false:조회조건 변경 없슴
     */
    function isChangedSearchKeyword() {
        var formObj = document.form;

      	if (orgObj.ofc_cd  != formObj.ofc_cd.value) {
      		return false;
      	}
      	
      	if (orgObj.pod_cd  != formObj.pod_cd.value) {
      		return false;
      	}
      	
      	return true;
    }
      
      
    /**
     * POD 콤보 Change 이벤트 발생 처리<br>
     * POD CD 를 POD 선택한 코드값으로 변경한다.<br>
     * 
     * @return 없슴
     */
    function pod_cd_list_OnChange() {
      	var formObj = document.form;
      	if (!isAutoSelect) {
          	formObj.pod_cd.value = formObj.pod_cd_list.Code;
      	}
    }
      
      
    /**
     * POD 콤보 Focus 이벤트 발생 처리<br>
     * 자동 선택여부를 false 로 셋팅한다.
     * @return 없슴
     */
    function pod_cd_list_OnFocus() {
      	isAutoSelect = false;
    }
      
    
    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      	if (sheetObj.RowCount == 0) {
      		ComShowCodeMessage("BKG04016", document.form.ofc_cd.value);
      	}
        	// 조회조건 저장
       	setSearchKeyword();
    }      
      
      
      
    /**
     * Save 왼료 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
      		if (document.form.f_cmd.value == MULTI) {
      			ComShowCodeMessage("BKG00166");
          		
          		org_pod_cd = document.form.pod_cd.value;
          		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
          		doActionIBSheet(sheetObj,document.form,IBSEARCH);
      		} else if (document.form.f_cmd.value == REMOVE) {
      			ComShowCodeMessage("BKG00593");

          		document.form.pod_cd.value = "";

      		    initForm();
          		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
      		}
        }
    } 
      
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
       var objs = document.all.item("tabLayer");

       objs[nItem].style.display = "Inline";
       objs[beforetab].style.display = "none";

       //--------------- 요기가 중요 --------------------------//
       objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
       //------------------------------------------------------//
       beforetab= nItem;
    }

   
    /**
     * 조회조건 변경여부를 체크하기 위하여 조회 조건 값을 저장해 둔다.<br>
     *
     * @return 없슴
     */
    function setSearchKeyword() {
        var formObj = document.form;
      	
      	orgObj.ofc_cd = formObj.ofc_cd.value;
      	orgObj.pod_cd = formObj.pod_cd.value;
      	orgObj.pod_cd_list = orgPodList;
      	
      	isRetrieved = true;
    }
      
      
    /**
     * 데이터 저장없이 임의로 변경된 조회 조건 값을 원상 복귀한다.<br>
     *
     * @return 없슴
     */
    function resetSearchKeyword() {
      	var formObj = document.form;
      	
      	formObj.ofc_cd.value  = orgObj.ofc_cd;
      	formObj.pod_cd.value  = orgObj.pod_cd;
      	
      	ComXml2ComboItem(orgObj.pod_cd_list, formObj.pod_cd_list, "pod_cd", "pod_cd");    	
      	
      	formObj.pod_cd_list.Code = orgObj.pod_cd;
    }
      
      
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) {
          	case IBSEARCH_ASYNC01:
          		if (!ComChkObjValid(formObj.ofc_cd)) return false;
          		break;
          		
          	case IBSEARCH:
          		if (!ComChkValid(formObj)) return false;
          		break;
          		
          	case IBSAVE:
          		if (!ComChkValid(formObj)) return false;
          		
          		for (var i=1; i<=5; i++) {
          			var obj = formObj.elements("frm_t"+i+"_hld_rmk");
          			// 최대 라인수 체크
          	    	if (getLine(obj) > 20) {
          	    		ComShowCodeMessage("BKG04012", obj.getAttribute("caption"), "20");
          	    		tabObjects[0].selectedIndex = i-1; 
          	    		obj.focus();
          	    		return false;
          	    	}          			
          		}
          		
          		break;
          	}
        }

        return true;
    }

     
    /**
     * Object(POD) 값이 변경되면 콤보에 동일한 코드를 선택해준다.<br>
     * 
     * @param {object} obj      필수. POD 객체 
     * @param {object} comboObj 필수. POD Combo 객체
     * @return 없슴
     */	
   	function fncFindComboCode(obj, comboObj) {
  		var idx = -1;
  		
  		isAutoSelect = true;
  		document.form.pod_cd_list.UseCode = false;
  		for(var i=0;i<comboObj.GetCount();i++){
  			if(obj.value.trim() == comboObj.GetText(i,0).substring(0,obj.value.length)){
  				idx = i;
  				break;
  			}
  		}	
  		document.form.pod_cd_list.UseCode = true;
  		
  		if (idx > -1) comboObj.Index = idx;
  	}
  	
    /**
     * TextArea 라인 수를 제한한다.<br>
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 라인수를 제어한다. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="textarea" name="txtRmk" onKeyPress="checkMaxLine(this, 5)"&gt;
     * </pre>
     *  
     * @param {object} obj      필수,대상 HTML태그(Object)
     * @param {number} maxLine  필수,최대 Line 수
     * @return 없음
    */
    function checkMaxLine(obj, maxLine) {
        var ln = getLine(obj);

        if (ln >= maxLine) return false;
      
        return true;
    }
       
    
    /**
     * obj 객체값의 라인 개수를 반환한다.<br>
     * 객체의 최대 라인수를 제한하기 위해 이용된다.<br>
     * 
     * @param {object} obj 필수,대상 HTML태그(Object)
     * @return int. 라인 개수
     */
    function getLine(obj) {
//  	    var borderH = (obj.offsetHeight - obj.clientHeight) / 2;
//  	    var lineC = (obj.scrollHeight - borderH) / ((obj.clientHeight - borderH) / obj.rows);
//  	    return Math.round(lineC);
  	    
        var str_len = obj.value;
        line = str_len.split("\r\n");
        return line.length;

    }         

	/* 개발자 작업  끝 */