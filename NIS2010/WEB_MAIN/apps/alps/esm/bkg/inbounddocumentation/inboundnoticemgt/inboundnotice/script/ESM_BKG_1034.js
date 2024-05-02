/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1034.js
*@FileTitle : Pick-up Notice Template(Manual Send)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.24 박미옥
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
     * @class esm_bkg_1034 : esm_bkg_1034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1034() {
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
    
    var SH_STUP = 0;
    var SH_EV1_FOM = 1;
    var SH_EV2_FOM = 2;
    var SH_EV3_FOM = 3;
    
    var orgObj = new Object();
    var isRetrieved = false;
    
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
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;

            case "btn_Save":
            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;

            case "btn_Delete":
            	doActionIBSheet(sheetObject1,formObject,IBDELETE);
                break;

            case "btn_PickupNotice":
            	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1066.do?pgmNo=ESM_BKG_1066', 1024, 700, "", "none", true);
                break;
                
            case "btn_Reset":
            	doActionIBSheet(sheetObject1,formObject,IBRESET);
            	break;

            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
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
         for (var i=0;i<sheetObjects.length;i++) {
             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i]);
             
             initSheet(sheetObjects[i],i+1);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        initControl();
        
        initForm();
        
        if (document.form.ofc_cd.value != "") {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        
        document.form.ofc_cd.focus();
    }

     
     /**
      * Form 데이터 초기화 작업. 화면 Open 또는 데이터 삭제 후 초기값을 설정한다.
      * 
      * @return 없슴
      * @author 박미옥
      * @version 2009.07.09
      */
    function initForm() {   	 

        isRetrieved  = false;

    	// Form 데이터 Space 및 디폴트 값으로 초기화
 		with(document.form) {
            frm_pkup_ntc_seq.value         = "";
            frm_pkup_ntc_snd_tp_cd.value   = "";
            frm_ofc_cd.value               = ofc_cd.value;
            frm_del_cd.value               = "*";
            frm_auto_ntc_flg.value         = "Y"; // Auto
            frm_each_foc_ntc_flg.value     = "Y"; // Each Y Send(3times)
            frm_trkr_ntc_flg.value         = "N"; // No
            frm_eclz_obl_cpy_flg.value     = "N";
            frm_foc_clr_rmk_stup_flg.value = "Y";
            frm_hd_tit_ctnt.value          = "";
                    
            frm_t1_pkup_ntc_seq.value      = "";
            frm_t1_pkup_ntc_fom_cd.value   = "";
            frm_t1_eclz_obl_cpy_flg.value  = "N";
            frm_t1_btm_rmk.value           = "";
            
            frm_t2_pkup_ntc_seq.value      = "";
            frm_t2_pkup_ntc_fom_cd.value   = "";
            frm_t2_eclz_obl_cpy_flg.value  = "N";
            frm_t2_btm_rmk.value           = "";

            frm_t3_pkup_ntc_seq.value      = "";
            frm_t3_pkup_ntc_fom_cd.value   = "";
            frm_t3_eclz_obl_cpy_flg.value  = "N";
            frm_t3_btm_rmk.value           = "";
 		}

 		// Sheet 데이터 모두 삭제로 초기화
        for (var i=0;i<sheetObjects.length;i++) {
        	sheetObjects[i].RemoveAll();
        }
     }
     
    
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     */
    function initControl() {
         axon_event.addListenerFormat("keypress","obj_KeyPress", form);
      	 axon_event.addListener("keydown","obj_keydown1", "ofc_cd");
      	 axon_event.addListener("keydown","obj_keydown2", "frm_hd_tit_ctnt", "frm_t1_btm_rmk", "frm_t2_btm_rmk", "frm_t3_btm_rmk");
    }    
    
    
    /**
     * Key Down 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_keydown1() {
         ComKeyEnter("search");
    }

    
    /**
     * Key Down 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_keydown2() {
         switch(event.srcElement.name) {
         case "frm_hd_tit_ctnt":
        	    if (checkMaxLine(event.srcElement, 2) == false) {
        	   	    if(event.keyCode == 13) { 	  
        	   		    event.returnValue = false;
        	   	    }
        	    }
         	break;
         case "frm_t1_btm_rmk":
         case "frm_t2_btm_rmk":
         case "frm_t3_btm_rmk":
        	    if (checkMaxLine(event.srcElement, 18) == false) {
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
                }
                break;

        }
    }

    /**
    * Tab 클릭시 이벤트 관련 <br>
    * 선택한 탭의 요소가 활성화 된다. <br>
    * 
    * @param {object} tabObj 필수, Tab 컨트롤
    * @param {int}    nItem  필수, Tab 오브젝트 일련번호
    * @return 없슴
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
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {

        var sheetID = sheetObj.id;        
        var cnt = 0;
        
        switch(sheetID) {
        
        // Setup Information
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
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                InitHeadMode(false, false, false, false, false, false);
                
                var HeadTitle1 = "|Seq|Send Type Code|Office Code|DEL|Auto|FOC|Trucker|OBL Copy|Remart Setup|Content";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,       60,   daLeft,    false,    "ibflag");
                InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "pkup_ntc_seq",        false);
                InitDataProperty(0, cnt++ , dtData,         40,   daLeft,    false,    "pkup_ntc_snd_tp_cd",  true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "ofc_cd",              true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "del_cd",              true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "auto_ntc_flg",        true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "each_foc_ntc_flg",    true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "trkr_ntc_flg",        true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "eclz_obl_cpy_flg",    true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "foc_clr_rmk_stup_flg",true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "hd_tit_ctnt",         false,     "",       dfNone,         0,      false,       false,     500);               
                
                CountPosition = 0;
        	}
        	
        	break;
        	
        // Word Information
        case "t1sheet1":
        case "t2sheet1":
        case "t3sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 1, 1);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(8, 0, 0, false);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, false, false, false)
                
                var HeadTitle1 = "||||Seq|Form Code|Enclose O_B/L Copy|Bottom Remark";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,  COLMERGE, SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,        60,   daCenter,   false,  "ibflag");

                InitDataProperty(0, cnt++ , dtData,          50,   daCenter,   false,  "pkup_ntc_snd_tp_cd", true);
                InitDataProperty(0, cnt++ , dtData,          50,   daCenter,   false,  "ofc_cd",             true);
                InitDataProperty(0, cnt++ , dtData,          50,   daCenter,   false,  "del_cd",             true);
                
                InitDataProperty(0, cnt++ , dtData,          40,   daCenter,   false,  "pkup_ntc_seq",       false);
                InitDataProperty(0, cnt++ , dtData,         150,   daLeft,     false,  "pkup_ntc_fom_cd",    true);
                InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   false,  "eclz_obl_cpy_flg",   true);
                InitDataProperty(0, cnt++ , dtData,           0,   daLeft,     false,  "btm_rmk",            false,     "",       dfNone,         0,      false,       false,     500);
                
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
        
        case IBRESET:
        	resetFormData();
        	break;
        
        	
        	
        // 조회
        case IBSEARCH:
            if (validateForm(sheetObj,formObj,sAction) == false) break; 

            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;
            var sXml = sheetObj.GetSearchXml("ESM_BKG_1034GS.do", FormQueryString(formObj));
            
            var arrXml = sXml.split("|$$|");
			var State = ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
				// 조회조건 저장
	         	setSearchKeyword();
	        }

            sheetObjects[SH_STUP].LoadSearchXml(arrXml[0]); // Setup
            sheetObjects[SH_EV1_FOM].LoadSearchXml(arrXml[1]); // Event #1
            sheetObjects[SH_EV2_FOM].LoadSearchXml(arrXml[2]); // Event #2
            sheetObjects[SH_EV3_FOM].LoadSearchXml(arrXml[3]); // Event #3
                       
            if (ComGetTotalRows(arrXml[0]) == 0) {
            	resetFormData();
            }

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
    		
    		setStatusFlag(sheetObjects);
    		
            formObj.f_cmd.value = MULTI;
            var sParam = FormQueryString(formObj);
            var sParamSheet1 = sheetObjects[SH_STUP].GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            var sParamSheet2 = sheetObjects[SH_EV1_FOM].GetSaveString();
            if (sParamSheet2 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
            }
            var sParamSheet3 = sheetObjects[SH_EV2_FOM].GetSaveString();
            if (sParamSheet3 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet3, "sheet2_");
            }
            var sParamSheet4 = sheetObjects[SH_EV3_FOM].GetSaveString();
            if (sParamSheet4 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet4, "sheet2_");
            }

            var sXml = sheetObj.GetSaveXml("ESM_BKG_1034GS.do", sParam);
			sheetObjects[SH_STUP].LoadSaveXml(sXml);
            
			sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용.
			sheetObjects[SH_EV1_FOM].LoadSaveXml(sXml);
			sheetObjects[SH_EV2_FOM].LoadSaveXml(sXml);
			sheetObjects[SH_EV3_FOM].LoadSaveXml(sXml);
			
			ComOpenWait(false);

			
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgSaveCompleted();
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
						
            break;
            
            
            
        case IBDELETE:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}

        	if (isChangedSearchKeyword() == false) {
        		ComShowCodeMessage("BKG01072"); 
	    	    resetSearchKeyword();
	    	    break;
        	}

    		if (ComShowCodeConfirm("BKG00535") == false) {
    			break;
    		}

        	ComOpenWait(true);

        	formObj.f_cmd.value = MULTI01;
        	var sParam = FormQueryString(formObj) +        	
        	             "&pkup_ntc_seq=" + sheetObjects[SH_STUP].CellValue(1, "pkup_ntc_seq");
        	
        	var sXml = sheetObj.GetSaveXml("ESM_BKG_0411GS.do", sParam);
			sheetObjects[SH_STUP].LoadSaveXml(sXml);
			
			ComOpenWait(false);
			
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgDeleteCompleted();
				initForm();
			}

			break;
            
         }
    }
    
    
    /**
     * Form 을 초기화 한다. <br>
     * 
     * @return 없슴
     */
    function resetFormData()  {
    	with(document.form) {
    		for (var i=0; i<frm_eclz_obl_cpy_flg.length; i++) {
    		    if (frm_eclz_obl_cpy_flg[i].value == "N") {
    		        frm_eclz_obl_cpy_flg[i].checked = true;
    		        break;
    		    }
    		}

            for (var i=0; i<frm_foc_clr_rmk_stup_flg.length; i++) {
                if (frm_foc_clr_rmk_stup_flg[i].value == "Y") {
                    frm_foc_clr_rmk_stup_flg[i].checked = true;
                    break;
                }
            }
            
            frm_hd_tit_ctnt.value = "";
    		frm_t1_btm_rmk.value = "";
    		frm_t2_btm_rmk.value = "";
    		frm_t3_btm_rmk.value = "";
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
			if (sheetObjects[SH_STUP].RowCount == 0) {
    			sheetObjects[SH_STUP].DataInsert(0);
    			
    			sheetObjects[SH_STUP].CellValue(1,"pkup_ntc_seq")         = "";
    			sheetObjects[SH_STUP].CellValue(1,"pkup_ntc_snd_tp_cd")   = "M";
    			sheetObjects[SH_STUP].CellValue(1,"ofc_cd")               = ofc_cd.value;
    			sheetObjects[SH_STUP].CellValue(1,"del_cd")               = "*";
    			sheetObjects[SH_STUP].CellValue(1,"auto_ntc_flg")         = "Y";
    			sheetObjects[SH_STUP].CellValue(1,"each_foc_ntc_flg")     = "Y";
    			sheetObjects[SH_STUP].CellValue(1,"trkr_ntc_flg")         = "N";
    			sheetObjects[SH_STUP].CellValue(1,"eclz_obl_cpy_flg")     = "N";
    			sheetObjects[SH_STUP].CellValue(1,"foc_clr_rmk_stup_flg") = "Y";
    			sheetObjects[SH_STUP].CellValue(1,"hd_tit_ctnt")          = "";
    		}

			IBS_CopyRowToForm(sheetObjects[SH_STUP], formObj, 1, prefix);

    		
			var fom_cd = "";
			for (var i=1; i<=3; i++) {
	        	
	  			if (i==1) {
	  				prefix = "frm_t1_";
	  				fom_cd = "EV1";
	  			} else if (i==2) {
	  				prefix = "frm_t2_";
	  				fom_cd = "EV2";
	  			} else if (i==3) {
	  				prefix = "frm_t3_";
	  				fom_cd = "EV3";
	  			}
	  			
	    		if (sheetObjects[i].RowCount == 0) {
	    			sheetObjects[i].DataInsert(0);
	        		
	    			sheetObjects[i].CellValue(1,"pkup_ntc_snd_tp_cd") = "M";
	    			sheetObjects[i].CellValue(1,"ofc_cd")             = ofc_cd.value;
	    			sheetObjects[i].CellValue(1,"del_cd")             = "*";
	    			
	    			sheetObjects[i].CellValue(1, "pkup_ntc_seq")      = sheetObjects[SH_STUP].CellValue(1, "pkup_ntc_seq");
	    			sheetObjects[i].CellValue(1, "pkup_ntc_fom_cd")   = fom_cd;
	    			sheetObjects[i].CellValue(1, "eclz_obl_cpy_flg")  = "N";
	    			sheetObjects[i].CellValue(1, "btm_rmk")           = "";
	    		}    		

	        	IBS_CopyRowToForm(sheetObjects[i], formObj, 1, prefix); 
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
    
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_STUP], 1, "frm_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_EV1_FOM], 1, "frm_t1_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_EV2_FOM], 1, "frm_t2_");    
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_EV3_FOM], 1, "frm_t3_");    
    }
    
    
    /**
     * Sheet 의 Status를 U로 변경 <br>
     * 
     * @param {array} sheets 쉬트 배열 필수
     * @return 없슴
     */
    function setStatusFlag(sheets){
        for (var i=0;i<sheets.length;i++) {
        	for (var j=0;j<sheets[i].RowCount;j++) {
        		if(sheets[i].RowStatus(j+1) == "R") {
        			sheets[i].RowStatus(j+1) = "U";
        		}
        	}
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
    	
    	return true;
    }

    
    /**
     * 조회조건 변경여부를 체크하기 위하여 조회 조건 값을 저장해 둔다.<br>
     *
     * @return 없슴
     */
    function setSearchKeyword() {
    	var formObj = document.form;
    	
    	orgObj.ofc_cd = formObj.ofc_cd.value;
    	
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
    }    
    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj,formObj,sAction) {
  	
      with(formObj) {
      	switch(sAction) {
      	case IBSEARCH:
  	    	// 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
  	    	var objVal = formObj.ofc_cd.value;
  	    	if (objVal.length < 5 || objVal.length > 6) {
  	    		ComShowCodeMessage("BKG00881");
  	    		return false;
  	    	}

  	    	break;
  	    	
  	    	
      	case IBSAVE:
  	    	if (!ComChkValid(formObj)) return false;

	    	if (checkMaxLine(formObj.frm_hd_tit_ctnt, 2) == false) {
	    		ComShowCodeMessage("BKG04012", formObj.frm_hd_tit_ctnt.getAttribute("caption"), "2");
	    		formObj.frm_hd_tit_ctnt.focus();
	    		return false;
	    	}

	    	if (checkMaxLine(formObj.frm_t1_btm_rmk, 18) == false) {
	    		ComShowCodeMessage("BKG04012", formObj.frm_t1_btm_rmk.getAttribute("caption"), "18");
	    		tabObjects[0].selectedIndex = 0;    	  
	    		formObj.frm_t1_btm_rmk.focus();
	    		return false;
	    	}

	    	if (checkMaxLine(formObj.frm_t2_btm_rmk, 18) == false) {
	    		ComShowCodeMessage("BKG04012", formObj.frm_t2_btm_rmk.getAttribute("caption"), "18");
	    		tabObjects[1].selectedIndex = 0;    	  
	    		formObj.frm_t2_btm_rmk.focus();
	    		return false;
	    	}

	    	if (checkMaxLine(formObj.frm_t3_btm_rmk, 18) == false) {
	    		ComShowCodeMessage("BKG04012", formObj.frm_t3_btm_rmk.getAttribute("caption"), "18");
	    		tabObjects[2].selectedIndex = 0;    	  
	    		formObj.frm_t3_btm_rmk.focus();
	    		return false;
	    	}

	    	break;
      	}
      }

      return true;
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
      * @return 없음 <br>
      */
     function checkMaxLine(obj, maxLine) {
        var ln = getLine(obj);

        if (event.keyCode == 13) {
            if (ln >= maxLine) {
            	return false;
            }
        } else {
            if (ln > maxLine) {
            	return false;
            }
        }

        return true;
    }   
     
     
    /**
     * obj 객체값의 라인 개수를 반환한다.<br>
     * 객체의 최대 라인수를 제한하기 위해 이용된다.<br>
     * 
     * @param {object} obj 필수,대상 HTML태그(Object)
     * @return int. 라인 개수
     * @author 박미옥
     * @version 2009.07.09
     */
    function getLine(obj) {
        var str_len = obj.value;
        line = str_len.split("\r\n");
        return line.length;
    }
       
	/* 개발자 작업  끝 */