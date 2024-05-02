/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0937.js
*@FileTitle : Cargo Release Order의 Office Default From Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.07.02 안진응
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
     * @class esm_bkg_0937 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0937() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

	// 공통전역변수
		
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
		
	var sheet1 = 0;
	var sheet2 = 1;
	var sheet3 = 2;

	var IBSENDFAX = "IBSENDFAX";
	var IBSENDEMAIL = "IBSENDEMAIL";
	var IBRELEASE = "IBRELEASE";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[sheet2];
        var sheetObject2 = sheetObjects[sheet3];
        /*******************************************************/

//        try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":					
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;

				case "btn_Save":
					if (beforetab == 0) {
						doActionIBSheet(sheetObject1,document.form,IBINSERT);
					} else {
						doActionIBSheet(sheetObject2,document.form,IBINSERT);
					}
				break;
					
				case "btn_Mail_Send":					
					
					doActionIBSheet(sheetObject1,document.form,IBSENDEMAIL);                    
				break;

				case "btn_Fax_Send":					
					doActionIBSheet(sheetObject1,document.form,IBSENDFAX);                    
				break;

				case "btn_Close":
					var isChange = fnIsChange();
					
					if (isChange == true) {
						if(!ComShowCodeConfirm('BKG40068')){
			                return false;
			            }
					}

					window.close();
					break;
            } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
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
 		
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        initControl();

        if (document.form.do_no.value != '') {
        	doActionIBSheet(sheetObjects[sheet2],document.form,IBSEARCH);
        }
        ComSetFocus(document.form.do_no);
    }

     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }


     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {

                     var cnt  = 0 ;
                     InsertTab( cnt++ , "D/O Receiver" , -1 );
                     InsertTab( cnt++ , "Trucker" , -1 );
                 }
              break;

          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {


         var objs = document.all.item("tabLayer");

         objs[nItem].style.display = "Inline";
         objs[beforetab].style.display = "none";

         //--------------- 요기가 중요 --------------------------//
         objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab= nItem;
         
         if (beforetab == 0) {
        	 document.getElementById("div_multi_cntr").style.visibility="hidden";
        	 document.getElementById("multi_cntr_no").style.visibility="hidden";

        	 if (sheetObjects[sheet2].RowCount > 0) {
	        	 ComBtnEnable("btn_Mail_Send");
	        	 ComBtnEnable("btn_Fax_Send");		//12월 9일 RD 파일 오류로 인해서 버튼 Disable 처리함
        	 }
         } else {
        	 document.getElementById("div_multi_cntr").style.visibility="visible";
        	 document.getElementById("multi_cntr_no").style.visibility="visible";

        	 ComBtnDisable("btn_Mail_Send");
        	 ComBtnDisable("btn_Fax_Send");
         }
     }     
     
	/**
	 * 화면의 Control의 초기값과 이벤트를 설정한다.
	 */
    function initControl() {
    	var formObject = document.form;
    	// Multi Container No에 대한 처리를 어찌해야 할런지 확인 필요
    	
    	axon_event.addListenerForm  ('blur',     'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress', 'obj_keypress',    form); //- 키보드 입력할때
        axon_event.addListener  ('change'  , 'office_change', 'office');			//- Office 입력 후 From~To 비교
        
        ComBtnDisable("btn_Save");
    	ComBtnDisable("btn_Mail_Send");
    	ComBtnDisable("btn_Fax_Send");
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
		
		            var HeadTitle1 = "ibflag|cntr_no";
		            var headCount = ComCountHeadTitle(HeadTitle1);
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 4, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, false, false, true, false,false)
		
		                                 
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		
		            var prefix="sheet1_";
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter,    true,  	  prefix + "ibflag"); 					  
				    InitDataProperty(0, cnt++ , dtData,   	   125,    daCenter,    true,     prefix + "cntr_no",      false,    "",      dfNone, 			0,     false,		false);
		        }
	        	break;

        case "sheet2":      //sheet2 init
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

                    var HeadTitle1 = "ibflag|rcvr_cnee_nm|rcvr_eml|rcvr_fax_no|rcvr_phn_no|do_no|do_no_split|bkg_no";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false)

                                         
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix="sheet2_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter,    true,  	  prefix + "ibflag"); 					  
 				    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "rcvr_cnee_nm",      false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "rcvr_eml",        false,    "",      dfNone, 			0,     false,		false);
  					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "rcvr_fax_no",     false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
 					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "rcvr_phn_no",     false,    "",      dfNone, 			0,     false,		false);
 				    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "do_no",      	  false,    "",      dfNone, 			0,     false,		false);
 				    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "do_no_split",  	  false,    "",      dfNone, 			0,     false,		false);
 				    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "bkg_no",      	  false,    "",      dfNone, 			0,     false,		false);
                }
                break;
            case "sheet3":      //sheet3 init
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

                var HeadTitle1 = "ibflag|trkr_nm|trkr_phn_no|trkr_mvmt_ref_no|trkr_mty_rtn_yd_cd|cntr_no|bkg_no|rlse_seq";
                var headCount = ComCountHeadTitle(HeadTitle1);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 4, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, true, false,false)
                                     
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                var prefix="sheet3_";

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	     0,    daCenter,    true,  	  prefix + "ibflag"); 					  
			    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "trkr_nm",      	     false,    "",      dfNone, 			0,     false,		false);
				InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "trkr_phn_no",        false,    "",      dfNone, 			0,     false,		false);
				InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "trkr_mvmt_ref_no",   false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
				InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "trkr_mty_rtn_yd_cd", false,    "",      dfNone, 			0,     false,		false);
			    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "cntr_no",      	     false,    "",      dfNone, 			0,     false,		false);
			    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "bkg_no",      	     false,    "",      dfNone, 			0,     false,		false);
			    InitDataProperty(0, cnt++ , dtData,      	   125,    daCenter,    true,     prefix + "rlse_seq",     	     false,    "",      dfNone, 			0,     false,		false);
            }
            break;
        }
    }      

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
	            ComOpenWait(true);
	            sheetObjects[sheet1].WaitImageVisible = false;
	            formObj.f_cmd.value = SEARCH;
	            
	            var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_"); //prefix 문자열 배열
	            var sXml = sheetObj.GetSearchXml("ESM_BKG_0937GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	            
	            var arrXml = sXml.split("|$$|");
	
	            for(var idx = 0; idx < arrXml.length; idx++){
	                
	                sheetObjects[idx].Redraw = false;
	                if(idx > 0) {
	                    sheetObjects[idx].WaitImageVisible = false;
	                }
	                
	                sheetObjects[idx].LoadSearchXml(arrXml[idx]);
	                sheetObjects[idx].Redraw = true;
	            }
	            
	            sheetObjects[sheet1].WaitImageVisible = true;
	            
				
				break;

			case IBINSERT:      // 입력
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				var sParam1 = "";
				var arrPre = "";
				if (beforetab == 0) {
					formObj.f_cmd.value = MULTI;
					copyFormTosheet2();
	                sParam1 = sheetObjects[sheet2].GetSaveString();

	                //그리드의 변경 여부 체크
	                if(! sheetObjects[sheet2].IsDataModified){
	                    ComShowCodeMessage('BKG00743');
	                    return false;
	                }
				
	                arrPre = "sheet2_";
				} else {
					formObj.f_cmd.value = MULTI03;
					copyFormTosheet3();
	                sParam1 = sheetObjects[sheet3].GetSaveString();

	                //그리드의 변경 여부 체크
	                if(! sheetObjects[sheet3].IsDataModified){
	                    ComShowCodeMessage('BKG00743');
	                    return false;
	                }
	                
	                arrPre = "sheet3_";
				}

                if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
                    return false;
                }

                var aryPrefix = new Array(arrPre);    //prefix 문자열 배열
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0937GS.do", sparam);

               	sheetObj.LoadSaveXml(sXml);

               	sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용

                break;
			case IBSENDEMAIL:
				if(!validateForm(sheetObj,formObj,sAction)) return false;

				formObj.f_cmd.value = MULTI01;

            	copyFormTosheet2();
            	
                var sParam1 = sheetObjects[sheet2].GetSaveString();

                if( !ComShowCodeConfirm('BKG40098', document.form.rcvr_cnee_nm.value) ){
                    return false;
                }

                var aryPrefix = new Array("sheet2_");    //prefix 문자열 배열
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0937GS.do", sparam);

                sheetObjects[sheet2].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용

                break;
			case IBSENDFAX:
				if(!validateForm(sheetObj,formObj,sAction)) return false;

				formObj.f_cmd.value = MULTI02;

            	copyFormTosheet2();
            	
                var sParam1 = sheetObjects[sheet2].GetSaveString();

                if( !ComShowCodeConfirm('BKG40099', document.form.rcvr_cnee_nm.value) ){
                    return false;
                }

                var aryPrefix = new Array("sheet2_");    //prefix 문자열 배열
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0937GS.do", sparam);

                sheetObjects[sheet2].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용

                break;
        }
    }     
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
   		switch(sAction) {       	 
		case IBSEARCH:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }

    		break;
    	
		case IBINSERT:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }

            // DO No가 10보다 작은 경우 오류 처리한다. (12보다 큰 경우는 화면에서 입력되지 않음)
            if (ComChkLen(document.form.do_no.value, 10) == 1) {
            	ComShowCodeMessage('BKG01058', document.form.do_no.value);
                formObj.do_no.focus();
                return false;
            }

            if (beforetab == 1) {            
	            // Multi Container No가 존재하지 않는 경우 오류처리한다.
	            if (document.form.multi_cntr_no.value == '') {
	            	alert("Multi Container No가 존재하지 않습니다.");
	                formObj.multi_cntr_no.focus();
	                return false;
	            }
	            
//                if(ComIsEmpty(formObj.trkr_mty_rtn_yd_cd.value) == false){
//		            if (ComChkLen(formObj.trkr_mty_rtn_yd_cd.value, 7) == 2) {
//		            	ComShowCodeMessage('BKG00715', "Empty Return Yard");
//		                formObj.trkr_mty_rtn_yd_cd.focus();
//		                return false;
//		            }
//                }
            } else {
                if(ComIsEmpty(formObj.rcvr_eml.value) == false){
                    if(ComIsEmailAddr(formObj.rcvr_eml.value) != true){
                    	ComShowCodeMessage('BKG40021', formObj.rcvr_eml.value);
                        formObj.rcvr_eml.focus();
                        return false;
                    }
                }
            }
            
            break;
		case IBSENDEMAIL:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }

            // DO No가 10보다 작은 경우 오류 처리한다. (12보다 큰 경우는 화면에서 입력되지 않음)
            if (ComChkLen(document.form.do_no.value, 10) == 1) {
            	ComShowCodeMessage('BKG01058', document.form.do_no.value);
                formObj.do_no.focus();
                return false;
            }
            
            if(ComIsEmpty(formObj.rcvr_eml.value)){
                ComShowCodeMessage('BKG40021', formObj.rcvr_eml.value);
                formObj.rcvr_eml.focus();
                return false;
            }

            if(ComIsEmailAddr(formObj.rcvr_eml.value) != true){
            	ComShowCodeMessage('BKG40021', formObj.rcvr_eml.value);
                formObj.rcvr_eml.focus();
                return false;
            }
            
            break;
		case IBSENDFAX:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }

            // DO No가 10보다 작은 경우 오류 처리한다. (12보다 큰 경우는 화면에서 입력되지 않음)
            if (ComChkLen(document.form.do_no.value, 10) == 1) {
            	ComShowCodeMessage('BKG01058', document.form.do_no.value);
                formObj.do_no.focus();
                return false;
            }
            
            if(ComIsEmpty(formObj.rcvr_fax_no.value)){
                ComShowCodeMessage('BKG40020', formObj.rcvr_fax_no.value);
                formObj.rcvr_fax_no.focus();
                return false;
            }
            
			break;
   		}
		
    	return true;
   	}

         
    /**
     * 업무 자바스크립트 Blur 이벤트 처리
     */
    function obj_deactivate(){
    	//입력Validation 확인 및 마스킹 처리
        ComChkObjValid(event.srcElement);
    }

    /**
     * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
            case "float":
            	//숫자+"."입력하기
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "eng":
                //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
                //ComKeyOnlyAlphabet();
                ComKeyOnlyAlphabet('uppernum');
                break;
            case "engdn":
                //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
                ComKeyOnlyAlphabet('lower');
                break;
            case "engup":
                //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                ComKeyOnlyAlphabet('upper');
                break;
            case "num":
            	ComKeyOnlyAlphabet('num', "45");
            default:	
                //숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
            }
    }
         
         
    /**
    * 화면의 값을 초기화한다.
    */
    function initsheet2() {
		var formObject = document.form;
		  
		formObject.rcvr_cnee_nm.value = '';
		formObject.rcvr_eml.value = '';
		formObject.rcvr_fax_no.value = '';
		formObject.rcvr_phn_no.value = '';
    }

    /**
    * 화면의 값을 초기화한다.
    */
    function initsheet3() {
		var formObject = document.form;

		formObject.trkr_nm.value = '';
		formObject.trkr_phn_no.value = '';
		formObject.trkr_mvmt_ref_no.value = '';
		formObject.trkr_mty_rtn_yd_cd.value = '';
    
    }

   /**
    * sheet1의 조회가 완료된 시점에 값을 설정한다.
    */
   function sheet1_OnSearchEnd(sheetObj, ErrMsg){
       var prefix = "sheet1_";
       var formObject = document.form;
       
       if (ErrMsg == "") {
           if(sheetObj.RowCount > 0){
        	   addSel(sheetObj);
           } else {
        	   ClearSel(sheetObj);
           }
       }
    }

   function addSel(sheetObj) {

       var sel = document.form.multi_cntr_no;

       var prefix="sheet1_";
       
       for (i=sel.length-1; i>=0; i--){
           sel.options[i] = null
       }
       
       var unit   = "";
       var amount = "";

       for (j=1; j<=sheetObj.RowCount; j++){
           cntrNo = sheetObj.CellValue(j, prefix+"cntr_no");
           if(! ComIsEmpty(cntrNo)){
        	   document.form['multi_cntr_no'][j-1] = new Option(cntrNo, cntrNo);
           }
       }
   }
   
   //tot_ots_amt 항목에 0을 셋팅한다.
   function ClearSel() {

       var sel = document.form.multi_cntr_no;
       
       for (i=sel.length-1; i>=0; i--){
           sel.options[i] = null
       }
   }    
    /**
     * sheet2의 조회가 완료된 시점에 값을 설정한다.
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        var prefix = "sheet2_";
        var formObject = document.form;
        
        if (ErrMsg == "") {
            
        	ComOpenWait(false);
        	
        	if(sheetObj.RowCount > 0){
            	formObject.rcvr_cnee_nm.value = sheetObj.CellValue(1, prefix + "rcvr_cnee_nm");
        		formObject.rcvr_eml.value = sheetObj.CellValue(1, prefix + "rcvr_eml");
        		formObject.rcvr_fax_no.value = sheetObj.CellValue(1, prefix + "rcvr_fax_no");
        		formObject.rcvr_phn_no.value = sheetObj.CellValue(1, prefix + "rcvr_phn_no");

        		ComBtnEnable("btn_Save");
        		if (beforetab == 0) { 
	            	ComBtnEnable("btn_Mail_Send");
	            	ComBtnEnable("btn_Fax_Send");
        		} else {
                	ComBtnDisable("btn_Mail_Send");
                	ComBtnDisable("btn_Fax_Send");        			
        		}
            } else {
            	ComBtnDisable("btn_Save");
            	ComBtnDisable("btn_Mail_Send");
            	ComBtnDisable("btn_Fax_Send");
            }
        } else {
        	initsheet2();
        }
     }

     /**
      * sheet2를 저장하고 나서 처리할 사항
      */
     function sheet2_OnSaveEnd(sheetObj, ErrMsg){

         if (ErrMsg == "") {
    	    doActionIBSheet(sheetObjects[sheet2],document.form,IBSEARCH);
//    		ComBkgSaveCompleted();  //서버메세지 처리
         }
     }              
     
      /**
       * sheet3를 저장하고 나서 처리할 사항
       */
      function sheet3_OnSaveEnd(sheetObj, ErrMsg){

          if (ErrMsg == "") {
     	    doActionIBSheet(sheetObjects[sheet3],document.form,IBSEARCH);
//     		ComBkgSaveCompleted();  //서버메세지 처리
          }
      }
      
     /**
      * 화면에 입력한 값을 sheet2에 Copy한다.
      */
     function copyFormTosheet2() {
 	     var rowCnt = sheetObjects[sheet2].RowCount;
 	     var prefix="sheet2_";
 	  
 	     if (rowCnt > 0) {		//기존 자료가 존재하는 경우
//           2010.04.09 수정 지침에 따라서 수정(안진응)
// 		     sheetObjects[sheet2].CellValue2(rowCnt,prefix + "ibflag") = "U"; 	
 	     	 sheetObjects[sheet2].RowStatus(rowCnt) = "U";
 	     } else {				//신규 입력인 경우
 		     rowCnt = sheetObjects[sheet2].DataInsert(-1);
//       2010.04.09 수정 지침에 따라서 수정(안진응)
// 	  	     sheetObjects[sheet2].CellValue2(rowCnt,prefix + "ibflag") = "I";
 	  	     sheetObjects[sheet2].RowStatus(rowCnt) = "I";
 	     }
 	     
 	     // Do 번호가 12자리인 경우
 	     if (ComChkLen(document.form.do_no.value, 12) == 2) {
 	    	 sheetObjects[sheet2].CellValue2(rowCnt,prefix + "do_no") = document.form.do_no.value.substring(0, 10);
 	    	 sheetObjects[sheet2].CellValue2(rowCnt,prefix + "do_no_split") = document.form.do_no.value.substring(10); 	    	 
 	     } else {
 	    	 sheetObjects[sheet2].CellValue2(rowCnt,prefix + "do_no") = document.form.do_no.value;
 	    	 sheetObjects[sheet2].CellValue2(rowCnt,prefix + "do_no_split") = '00';
 	     }
 	  
 	     sheetObjects[sheet2].CellValue2(rowCnt,prefix + "rcvr_cnee_nm") = document.form.rcvr_cnee_nm.value;
 	     sheetObjects[sheet2].CellValue2(rowCnt,prefix + "rcvr_eml") = document.form.rcvr_eml.value;
 	     sheetObjects[sheet2].CellValue2(rowCnt,prefix + "rcvr_fax_no") = document.form.rcvr_fax_no.value;
 	     sheetObjects[sheet2].CellValue2(rowCnt,prefix + "rcvr_phn_no") = document.form.rcvr_phn_no.value;
     }

      /**
       * 화면에 입력한 Trucker값을 sheet3에 Copy한다.
       */
    function copyFormTosheet3() {
  	    var rowCnt = sheetObjects[sheet3].RowCount;
      	var prefix = "sheet3_";
    	var formObject = document.form;
    	var sheetObj = sheetObjects[sheet3];
  	    var cntr_no = document.form.multi_cntr_no.value;
  	  
     	for (j=1; j<=sheetObj.RowCount; j++){

    		if (sheetObj.CellValue(j, prefix+"cntr_no") == cntr_no) {
//              2010.04.09 수정 지침에 따라서 수정(안진응)
//      		    sheetObjects[sheet3].CellValue2(j,prefix + "ibflag") = "U";
      		    sheetObjects[sheet3].RowStatus(j) = "U";
      	  	    sheetObjects[sheet3].CellValue2(j,prefix + "trkr_nm") = document.form.trkr_nm.value;
      	  	    sheetObjects[sheet3].CellValue2(j,prefix + "trkr_phn_no") = document.form.trkr_phn_no.value;
      	  	    sheetObjects[sheet3].CellValue2(j,prefix + "trkr_mvmt_ref_no") = document.form.trkr_mvmt_ref_no.value;
      	  	    sheetObjects[sheet3].CellValue2(j,prefix + "trkr_mty_rtn_yd_cd") = document.form.trkr_mty_rtn_yd_cd.value;
            }
        }
      }

      /**
       * sheet3의 조회가 완료된 시점에 값을 설정한다.
       */
      function sheet3_OnSearchEnd(sheetObj, ErrMsg){
          var prefix = "sheet3_";
          var formObject = document.form;
          var cntr_no = null;
          
          if (ErrMsg == "") {
              if(sheetObj.RowCount > 0){
            	  cntr_no = formObject.multi_cntr_no.value;
            	  
            	  fnMoveTrucker(cntr_no);
            	  
              }
          } else {
          	initsheet3();
          }
       }
      
    function fnMoveTrucker(cntr_no) {
    	var prefix = "sheet3_";
    	var formObject = document.form;
    	var sheetObj = sheetObjects[sheet3];
    	
    	for (j=1; j<=sheetObj.RowCount; j++){

    		if (sheetObj.CellValue(j, prefix+"cntr_no") == cntr_no) {
            	formObject.trkr_nm.value = sheetObj.CellValue(j, prefix+"trkr_nm");
        		formObject.trkr_phn_no.value = sheetObj.CellValue(j, prefix+"trkr_phn_no");
        		formObject.trkr_mvmt_ref_no.value = sheetObj.CellValue(j, prefix+"trkr_mvmt_ref_no");
        		formObject.trkr_mty_rtn_yd_cd.value = sheetObj.CellValue(j, prefix+"trkr_mty_rtn_yd_cd");
            }
    		
        }    	  
    }
    
    function fnIsChange() {
    	
    	var prefix2 = "sheet2_";
    	var prefix3 = "sheet3_";
    	
    	if (beforetab == 0) {
        	if (sheetObjects[sheet2].RowCount == 0) {
        		return false;
        	}

        	if (fncDiff(sheetObjects[sheet2].CellValue(1,prefix2 + "rcvr_cnee_nm"), document.form.rcvr_cnee_nm.value) == true) {
        		return true;
        	}
        	if (fncDiff(sheetObjects[sheet2].CellValue(1,prefix2 + "rcvr_eml"), document.form.rcvr_eml.value) == true) {
        		return true;
        	}
        	if (fncDiff(sheetObjects[sheet2].CellValue(1,prefix2 + "rcvr_fax_no"), document.form.rcvr_fax_no.value) == true) {
        		return true;
        	}
        	if (fncDiff(sheetObjects[sheet2].CellValue(1,prefix2 + "rcvr_phn_no"), document.form.rcvr_phn_no.value) == true) {
        		return true;
        	}
        	
    	} else {
        	if (sheetObjects[sheet3].RowCount == 0) {
        		return false;
        	}
        	
        	var cntr_no = document.form.multi_cntr_no.value;
        	
        	for (j=1; j<=sheetObjects[sheet3].RowCount; j++){

        		if (sheetObjects[sheet3].CellValue(j, prefix3+"cntr_no") == cntr_no) {
    		    	if (fncDiff(sheetObjects[sheet3].CellValue(j,prefix3 + "trkr_nm"), document.form.trkr_nm.value) == true) {
    		    		return true;
    		    	}
    		    	if (fncDiff(sheetObjects[sheet3].CellValue(j,prefix3 + "trkr_phn_no"), document.form.trkr_phn_no.value) == true) {
    		    		return true;
    		    	}
    		    	if (fncDiff(sheetObjects[sheet3].CellValue(j,prefix3 + "trkr_mvmt_ref_no"), document.form.trkr_mvmt_ref_no.value) == true) {
    		    		return true;
    		    	}
    		    	if (fncDiff(sheetObjects[sheet3].CellValue(j,prefix3 + "trkr_mty_rtn_yd_cd"), document.form.trkr_mty_rtn_yd_cd.value) == true) {
    		    		return true;
    		    	}
        		}
        	}    		
    	}
    	
    	return false;
    }
    
    /**
     * 두개의 문자열 비교
     * 동일 ; 리턴 true
     * @param orgStr
     * @param newStr
     * @return
     */    
    function fncDiff(orgStr,newStr){
    	orgStr = orgStr.replace(eval("/\\r\\n/gi"), "").trim();
    	newStr = newStr.replace(eval("/\\r\\n/gi"), "").trim();


    	
    	if(orgStr != newStr){
//        	alert("["+orgStr+"]" + "\n["+newStr+"]");
    		return true;
    	}else{
    		return false;
    	}
    }    
    /* 개발자 작업  끝 */