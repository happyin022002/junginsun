/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1018.js
*@FileTitle : MTY BKG Creation
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.13 신용찬
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
     * @class EES_EQR_1018 : EES_EQR_1018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1018() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0 ;

    //RD-TEST
    var rdObjects = new Array();
    var rdCnt = 0;
    var parmObj = new Array();
    var frmObj = new Array();

    //var consTpszArr = null;  	// tpsz type 전체 sheet에 영향을 줌.
    var oldValue    = null;  	// cell 이 가지고 있던 정보를 잠시 저장합니다.(매우 중요)
    var linkPageNum = null;  	// 051에서 링크로 넘어오는 경우 어떤 tab이 선택인지 구분(매우 중요)

    //var tabObjects = new Array();
    
    var allTpszCnt = null;	// TP/SZ가 ALL일때의 카운트

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick() {
            // 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용
        	       	
            var sheetObject  = sheetObjects[0];
            var formObject = document.form;           

        	try {
        		
        		var srcName = window.event.srcElement.getAttribute("name");

                // 버튼이 disable 인지 확인한다.
    			if(!ComIsBtnEnable(srcName) ) return;

                switch(srcName) {

                    case "btn_new":

                        formObject.reset();
                        
                        // RADIO 기본값 선택
                        document.form.divflag[0].checked = true; // radio 원위치
                        formObject.vvdname.className    		= "input";
                        formObject.fromdate.className     = "input1";
                        formObject.todate.className       = "input1";
            			if(formObject.divdate.value=="F"){
            				formObject.fromlocation.className = "input1";
            				formObject.tolocation.className   = "input";
            			}else{
            				formObject.fromlocation.className = "input";
            				formObject.tolocation.className   = "input1";
            			}
            			
    					// Item 초기화
    					comboObjects[0].RemoveAll();
    					initCombo (comboObjects[0],1);    					 					
    					
                        // tpsz 초기화       					
                        comboObjects[1].Code = consTpsz;
    		            // tpsz all setting (매우중요)
    		        	document.form.tpszall.value = consTpsz;                          
            			
            			// GRID 삭제
                        sheetObject.RemoveAll();

                        break;

            	    case "btn_retrieve":
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	        break;

                    case "btn_save":
        	            doActionIBSheet( sheetObject, formObject,IBSAVE);

                        break;

              	    case "btn_downexcel":

              	    	if(sheetObject.RowCount > 0) doActionIBSheet(sheetObject, formObject,IBDOWNEXCEL);
              	    	else                         ComShowCodeMessage("EQR90039");

            	        break;

            		case "btns_calendarfm":

            			var cal = new ComCalendarFromTo();
            			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

            			break;
            			
            		case "btns_calendarto":

            			var cal = new ComCalendarFromTo();
            			cal.select(formObject.fromdate, formObject.todate, 'yyyy-MM-dd');

            			break;            			

                  	case "frloc_btn":
                    	var display 	  = "0,1,1,1,1,1";
                    	var targetObjList = "loc_dpth_cd:fromstatus|loc_cd:fromlocation";
      				    var param 		  = "?depth=4&classId=COM_ENS_0O1";

      				    ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
      				    break;

                  	case "toloc_btn":

                    	var display 	  = "0,1,1,1,1,1";
                    	var targetObjList = "loc_dpth_cd:tostatus|loc_cd:tolocation";
      				    var param 		  = "?depth=4&classId=COM_ENS_0O1";

      				    ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
    					break;

                    case "btn_print":
                    	if(sheetObjects[0].RowCount('') > 0){
                        	sheetObjects[0].Down2Print(true, 2, 'Repo Plan - T.VVD & D.VVD');
                    	}

                    	if(sheetObjects[0].RowCount('') == 0)
                    	{
                      		//ComShowMessage('Print 할 Data가 없습니다.');
                      		ComShowCodeMessage("EQR90095");
                    	}

                  		break;
                  		
                    case "t1btng_rowaddnoplan":
                        doActionIBSheet_1(sheetObject,formObject,IBINSERT);
                        break;
                        
                    case "t1btng_rowadd":
                        doActionIBSheet(sheetObject,formObject,IBINSERT);
                        break;

                    case "t1btng_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;

                    case "t1btng_repobkg":
                        doActionIBSheet_1(sheetObject,formObject,IBSAVE);
                        break;

                    case "t1btng_vdsplit":
                    	openMtyBkgSplit(sheetObject,formObject);
                        break;
                        
                    case "t1btng_vdsplitmulti":
                    	openMtyBkgSplitMulti(sheetObject,formObject);
                        break;                           
                        
                    case "t1btng_gobkgupdate":
                    	openMtyBkgUpdate(sheetObject,formObject);
                        break;                     
                            

                } // end switch

        	}catch(e) {

        		if( e == "[object Error]") {

        			//ComShowMessage(OBJECT_ERROR);
        			ComShowCodeMessage("EQR90004");
        		} else {
        			ComShowMessage(e);
        		}
        	}


        }

    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
        
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
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
         * IBCombo Object를 배열로 등록
        * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }

        /**
         * Sheet 기본 설정 및 초기화
         *  태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	allTpszCnt = consTpsz.split(',').length;	// TP/SZ가 ALL일때의 카운트
        	
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i]);  //khlee-시작 환경 설정 함수 이름 변경
                initSheet(sheetObjects[i],i+1, comboObjects[1].Text);
                ComEndConfigSheet(sheetObjects[i]);            //khlee-마지막 환경 설정 함수 추가
            }

    		// combo setting은 초기에 한번만 한다.(중요)

			// multi combo box setting
        	for(p=0; p< comboObjects.length; p++) {
            	initCombo(comboObjects[p], p+1);
        	}
        	
            // tpsz all setting (매우중요)
        	document.form.tpszall.value = consTpsz;            	
        	
        	// 초기조회시 type size 수정금지
        	document.form.tpsztype.disabled = true;
            
			initControl();    
			classToggle();	// 라디오 선택값에 따라 필수값 조정
        }


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj, sheetNo, tpszValue) {

            var cnt = 0;

            switch(sheetNo) {

               case 1:      //t1sheet1 init
    				with (sheetObj) {

                        var HeadTitle0 = "Del.|STS|STS|Item|Div.|BKG No.|Lane|VVD|ROB|POL|POL|POD|POD|CNTR Info|";
                        var HeadTitle1 = "Del.|STS|STS|Item|Div.|BKG No.|Lane|VVD|ROB|Loc.|ETD|Loc.|ETB|CNTR Info|";

    					if((tpszValue!='' && tpszValue!=null)) consTpszArr = tpszValue.split(',');

                        HeadTitle0 = HeadTitle0 + "Total Vol|";
                        HeadTitle1 = HeadTitle1 + "Total Vol|";

                        for(i=0; i<consTpszArr.length; i++) {
                            HeadTitle0 = HeadTitle0 + "Vol.|";
                            HeadTitle1 = HeadTitle1 + consTpszArr[i]+"|";
                        }
                        
                        HeadTitle0 = HeadTitle0 + "Purpose|Reason|Reason Remark|User Office|User Name|Update Date|";
                        HeadTitle1 = HeadTitle1 + "Purpose|Reason|Reason Remark|User Office|User Name|Update Date|";                        

    					//var columnCount = 20 + eval(consTpszArr.length*1) + 12;   // 12-HIDDEN
    					//var columnCount = 20 + eval(consTpszArr.length*1) + 13;   // 13-HIDDEN
    					var columnCount = 21 + eval(consTpszArr.length*1) + 13;   // 13-HIDDEN

    					// ROW 갯수 결정
                        style.height = GetSheetHeight(18) ;  

                       //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 1, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(columnCount, 5, 0, true);

                    	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    	InitHeadMode(false, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, 		  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtDelCheck      ,     30,  daCenter,  true,    "check");
                        InitDataProperty(0, cnt++ , dtHiddenStatus,     30,  daCenter,  true,    "ibflag");
//                        InitDataProperty(0, cnt++ , dtStatus,     30,  daCenter,  true,    "ibflag");                        
                        InitDataProperty(0, cnt++ , dtData,       30,  daCenter,    true,     "bkg_sts_cd", false,     "",       dfNone,   	    0,     false,      false,       8);

                        InitDataProperty(0, cnt++ , dtCombo,      60,  daLeft  ,  true,     "trsp_mod_cd",  true,      "",       dfNone,        0,     false,      true,       1);
                        InitDataProperty(0, cnt++ , dtData,       80,  daLeft,    true,     "div",    		true,      "",       dfNone,   	    0,     false,      false,       8);
                        
                        InitDataProperty(0, cnt++ , dtData,       90,  daLeft  ,  true,     "mty_bkg_no",   false,     "",       dfNone,        0,     false,      true,      13);
                        
                        InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,     "vsl_lane_cd",  true,      "",       dfEngUpKey,    0,     false,      true,       3,          3);
                        InitDataProperty(0, cnt++ , dtData,       70,  daLeft  ,  true,     "vvd",    		true,      "",       dfEngUpKey,    0,     false,      true,       9,          9);
                        InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,     "mty_rob_flg",  false,     "",       dfNone,        0,     true,      true,       9,          9);

                        InitDataProperty(0, cnt++ , dtData,       65, daLeft  ,  false,     "fm_yd_cd",    	true,      "",       dfEngUpKey,    0,     false,      true,       7,         7);
                        InitDataProperty(0, cnt++ , dtData,      110,  daLeft  ,  false,    "fm_etd_dt",    true,      "",       dfUserFormat,  0,     false,      false,      8);
                        InitDataProperty(0, cnt++ , dtData,       65, daLeft  ,  false,     "to_yd_cd",    	true,      "",       dfEngUpKey,    0,     false,      true,       7,         7);
                        InitDataProperty(0, cnt++ , dtData,      110,  daLeft  ,  false,    "to_eta_dt",    true,      "",       dfUserFormat,  0,     false,      false,       8);

                        InitDataProperty(0, cnt++ , dtImage,      70,  daCenter,  true,     "cntr_img",     false,     "",       dfNone,        0,     true,      false,      9);
                        
						var totalStr = ""; // total_vol 계산 대상이 되는 column
						for(var i=0; i<consTpszArr.length-1 ; i++) {
                            totalStr += "|qty_"+consTpszArr[i]+"|+";
                        }
						totalStr += "|qty_"+consTpszArr[consTpszArr.length-1]+"|+";
						
                        InitDataProperty(0, cnt++ , dtData,       70,  daRight ,  true,     "total_vol",    false,     totalStr,       dfInteger,     0,    false,     false,      11);
                        
                        for(var i=0; i<consTpszArr.length ; i++) {
                        	InitDataProperty(0, cnt++ , dtData,    60,  daRight,  false, "qty_"+consTpszArr[i],  false,  "",       dfInteger,     0,     true,       true,       6);
                        }
                        

                        InitDataProperty(0, cnt++ , dtCombo,      90,  daLeft  ,  true,    "eq_repo_purp_cd",true,     "",       dfNone,        0,     true,      true,      15);
                        InitDataProperty(0, cnt++ , dtCombo,      90,  daLeft,    true, "repo_pln_fb_rsn_cd",false,     "",       dfNone,        0,     true,      true,       2);
                        InitDataProperty(0, cnt++ , dtData,      150,  daLeft,    true,    "repo_pln_fb_rmk",false,     "",       dfNone,        0,    true,      true);

                        InitDataProperty(0, cnt++ , dtData,      70,   daLeft  ,  true,    "upd_ofc",    	false,      "",       dfNone,  		0,     false,      false,      8);
                        InitDataProperty(0, cnt++ , dtData,      110,  daLeft  ,  true,    "upd_name",    	false,      "",       dfNone,  		0,     false,      false,      8);
                        InitDataProperty(0, cnt++ , dtData,      110,  daLeft  ,  true,    "upd_dt",      	false,      "",       dfUserFormat,  0,     false,      false,      8);

    					// ---------- Hidden Area[START] -------------------------
                        // ---------- PK [START]         ------------------------- 
//                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "trsp_mod_cd",  	false,     "",       dfNone,   	    0,     true,       true,       4);
//                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "vsl_lane_cd",  		false,     "",       dfNone,   	    0,     true,       true,       4);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "vsl_cd",	   	false,     "",       dfNone,   	    0,     true,       true,       4);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "skd_voy_cd", false,     "",       dfNone,   	    0,     true,       true,       4);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "skd_dir_cd", false,   "",       dfNone,   	    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "bkg_exe_seq",false,   "",       dfNone,   	    0,     true,       true);
                        // ---------- PK [END]           -------------------------
                        // ---------- OTHER [START]      ------------------------- 
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "mty_bkg_flg",	 false,     "",       dfNone,   	  0,      true,      true,       4);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "mty_bkg_split_flg",	 false,     "",       dfNone,   	  0,      true,      true,       4);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "order_seq",	 false,     "",       dfNone,   	  0,      true,      true,       4);
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "vl_vd_div",	 false,     "",       dfNone,   	  0,      true,      true,       4);
                    
//                        InitDataProperty(0, cnt++ , dtData,       40,  daLeft,    false,    "fm_clpt_seq",   false,     "",       dfNone,   	  0,      true,      true,       4);
//                        InitDataProperty(0, cnt++ , dtData,       40,  daLeft,    false,    "to_clpt_seq",   false,     "",       dfNone,   	  0,      true,      true,       4);
                        // ORG_TO_LOC_CD
                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "org_to_loc_cd",   false,     "",       dfNone,   	  0,      true,      true,       4);

                        InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "pol_clpt_ind_seq",false,     "",       dfNone,         0,      true,      true,       6); // bkg에 넘겨줄  pol_clpt_ind_seq
						InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "pod_clpt_ind_seq",false,     "",       dfNone,         0,      true,      true,       6); // bkg에 넘겨줄  pod_clpt_ind_seq

                        // ---------- OTHER [END]        ------------------------- 
						
						InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "row_tp_flag",   false,     "",       dfNone,         0,      true,      true,       6); // 임시로 row type 을 가짐 
						InitDataProperty(0, cnt++ , dtHidden,       40,  daLeft,    false,    "mty_bkg_flag",  false,     "",       dfNone,         0,      true,      true,       6); // 임시로 row type 을 가짐 


						// ---------- Hidden Area[END]   -------------------------                        


                        InitDataCombo (0 , "repo_pln_fb_rsn_cd",  reason_sheetText, reason_sheetCode);
                        InitDataCombo (0 , "trsp_mod_cd",         "Trunk|Feeder",   "V|W");
                        InitDataCombo (0 , "eq_repo_purp_cd" ,    purposeText,purposeCode);

                        //cntr_img 이미지 셋팅
                        ImageList(0) = "/hanjin/img/button/btns_cntr.gif";  // data 0 일때 이미지 표현, CNTR NO존재
                        ImageList(1)=  "/hanjin/img/button/btns_cntr_c.gif";// data 1 일때 이미지 표현, CNTR NO존재안함

    					sheetObj.InitUserFormat(0, "fm_etd_dt", "####-##-## ##:##:##", "-|:" );
    					sheetObj.InitUserFormat(0, "to_eta_dt", "####-##-## ##:##:##", "-|:" );

                        CellBackColor(1,5) = RgbColor(222,251,248);

                        for(var i=6; i < 13; i++) {
                            CellBackColor(1,i) = CellBackColor(1,5);
                        }

                        for(var i=14; i < 53; i++) {
                            CellBackColor(1,i) = CellBackColor(1,5);
                        }

                        HeadRowHeight  = 10;
                        sheetObj.ShowButtonImage = 3; // Edit 가능할때 콤보와 팝업 이미지 표시

                    }
                    break;

            }
        }

       /**
         * Combo 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initCombo (comboObj, comboNo) {
            var cnt  = 0 ;

            switch(comboNo) {

    			// Item
                case 1:
                   	with (comboObj) {
                   		DropHeight = 2 * 20;
                   		
                   		itemText = "Trunk|Feeder";
                   		itemCode = "V|W";
                   		
      					var menuname = itemText.split('|');
      					var menucode = itemCode.split('|');

                   		MultiSelect = true;
                   		MaxSelect =  menuname.length;
                   		MultiSeparator = ",";

            			for(i=0; i<menuname.length; i++) {
             				InsertItem(cnt++, menuname[i], menucode[i]);
          				}
						
						comboObj.Code = 'V,W'; // defalt 로  모두 선택
        	    	}
                   break;
                   
//                case 2:
//                   	with (comboObj) {
//                   		DropHeight = 3 * 20;
//                   		
//                   		divText = "Plan|BKG(VL)|BKG(VD)";
//                   		divCode = "P|L|D";
//                   		
//      					var divname = divText.split('|');
//      					var divcode = divCode.split('|');
//
//                   		MultiSelect = true;
//                   		MaxSelect =  divname.length;
//                   		MultiSeparator = ",";
//
//            			for(i=0; i<divname.length; i++) {
//             				InsertItem(cnt++, divname[i], divcode[i]);
//          				}
//						
//						comboObj.Code = 'P,L,D'; // defalt 로  모두 선택
//        	    	}
//                   break;                   

    			// Type Size
                case 2:
                   	with (comboObj) {

                   		DropHeight = 12 * 20;

      					var menuname = tpszallText.split('|');
      					var menucode = tpszallCode.split('|');

                   		MultiSelect = true;
                   		MaxSelect = menuname.length;
                   		MultiSeparator = ",";

    					for(i=0; i<menuname.length; i++) {
                    		InsertItem(cnt++, menuname[i], menucode[i]);
                   		}
        	    	}
                   break;
             }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
                   if(validateForm(sheetObj,formObj,sAction,1)) {
                     	//동적으로 보여주기 위해서 IBSHEET 레이아웃 초기화 하고 다시 보여준다.                	                  	   

                		sheetObj.WaitImageVisible  = true ;

                    	formObj.f_cmd.value = SEARCHLIST;
                    	
                    	sheetObj.DoSearch("EES_EQR_1018GS.do", eqrFormQryStr(formObj));
                     	sheetObj.Visible = true;
                     	sheetObj.ExtendLastCol = false;

                    }
                    break;

                case IBSAVE:        //저장

    				if(validateForm(sheetObj,formObj,sAction,2)) {
          				var sRow = sheetObj.FindStatusRow("I|U");
          				var arRow = sRow.split(";");
    					
                 		formObj.f_cmd.value = MULTI;
                 		sheetObj.DoSave("EES_EQR_1018GS.do", eqrFormQryStr(formObj));

    				}
                    break;

               case IBINSERT:
               		if(sheetObj.RowCount > 0) {
               			var selRow = sheetObj.SelectRow;   // 선택된 ROW
               			
               			// Plan 인 경우만 복사됨.
               			if(sheetObj.CellValue(selRow, "order_seq")==1) 
               			{
                    		var Row = sheetObj.DataInsert(selRow);

                    			sheetObj.CellValue2(Row, "div")         = "REPO BKG(VL)"; // REPO BKG 로 셋팅
                    			sheetObj.CellValue2(Row, "vsl_lane_cd") = sheetObj.CellValue(selRow, "vsl_lane_cd");  // lane copy
                    			sheetObj.CellValue2(Row, "vvd")   	    = sheetObj.CellValue(selRow, "vvd");  		// vvd copy
                    			sheetObj.CellValue2(Row, "mty_rob_flg") = "0";  		// MTY ROB FLAG                    			
                                sheetObj.InitCellProperty(Row, "mty_rob_flg", dtCheckBox);
                                
                    			sheetObj.CellValue2(Row, "fm_yd_cd")    = sheetObj.CellValue(selRow, "fm_yd_cd");  // from loc 정보 복사
                    			sheetObj.CellValue2(Row, "to_yd_cd")    = sheetObj.CellValue(selRow, "to_yd_cd");  // to loc 정보 복사
                    			sheetObj.CellValue2(Row, "fm_etd_dt")   = sheetObj.CellValue(selRow, "fm_etd_dt"); // from etd 정보 복사
                    			sheetObj.CellValue2(Row, "to_eta_dt")   = sheetObj.CellValue(selRow, "to_eta_dt"); // to   eta 정보 복사

                    			sheetObj.CellValue2(Row, 'trsp_mod_cd') = sheetObj.CellValue(selRow, 'trsp_mod_cd');  	// item 정보 복사

                    			sheetObj.CellValue2(Row, 'eq_repo_purp_cd')   = "";     // Purpose 은 선택안된 상태로 셋팅
                    			sheetObj.CellValue2(Row, 'repo_pln_fb_rsn_cd')= "";     // Reason 은 선택안된 상태로 셋팅
    				    		//sheetObj.CellEditable(Row, 'repo_pln_fb_rmk') = false;   // Reason Remark는 수정안되는 상태로 셋팅
    				    		sheetObj.CellEditable(Row, 'mty_bkg_no')      = false;   // BKG NO는 수정안되는 상태로 셋팅

    				    		sheetObj.CellValue2(Row, "cntr_img")  = "9";    // cntr image 초기화

    				    		sheetObj.CellValue2(Row, "order_seq") = "2";    // REPO BKG Row로 셋팅
    				    		sheetObj.CellValue2(Row, "vl_vd_div") = "1";    // VL로 셋팅

                    			// 수정불가 조정
    				    		sheetObj.CellEditable(Row, 'vsl_lane_cd')	= false;  // LANE 수정안되는 상태로 셋팅
    				    		sheetObj.CellEditable(Row, 'vvd')        	= false;  // VVD 수정안되는 상태로 셋팅
    				    		sheetObj.CellEditable(Row, 'trsp_mod_cd')   = false;  // TRSP MODE CODE 수정안되는 상태로 셋팅

    							// ------ FM LOC YARD 검색 [START] -----------
                				var f_cmd    = SEARCH12;
                				var vsl      = sheetObj.CellValue(Row, "vvd");
                				var from_ecc = sheetObj.CellValue(Row, "fm_yd_cd");                				

                                sheetObj.DoRowSearch("EES_LOCYARDINITIAL.do" ,"row="+Row+"&colname=fm_yd_cd&vsl="+vsl+"&ecc="+from_ecc+"&item=V&f_cmd="+f_cmd, false);
                                // ------ FM LOC YARD 검색  [END] -----------

    							// ------ TO LOC YARD 검색 [START] -----------
                				var f_cmd = SEARCH12; 
                				var vsl    = sheetObj.CellValue(Row, "vvd");
                				var to_ecc = sheetObj.CellValue(Row, "to_yd_cd");

                				sheetObj.DoRowSearch("EES_LOCYARDINITIAL.do" ,"row="+Row+"&colname=to_yd_cd&vsl="+vsl+"&ecc="+to_ecc+"&item=V&f_cmd="+f_cmd+"&tmp=Y");
    							// ------ TO LOC YARD 검색  [END] -----------
								
								// row_tp_flag 에 row type 기재
                                sheetObj.CellValue2(Row, "row_tp_flag") = "PLAN";
                    	}else {
                    		//ComShowMessage("Plan Row를 선택해 주세요");
        					ComShowCodeMessage("EQR90040");
                    	}
                	}

                    break;

                case IBDOWNEXCEL:
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
            }
        }

      	// REPO BKG 버튼 클릭시 프로세스, NO PLAN ADD  처리
        function doActionIBSheet_1(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

                case IBSAVE:
                	var selRow    = sheetObj.SelectRow;   // 선택된 ROW
                	var bkg_no    = sheetObj.CellValue(selRow, "mty_bkg_no"); // BKG NO
                	var ibflag    = sheetObj.CellValue(selRow, "ibflag");     // IBFLAG
                	var vl_vd_div = sheetObj.CellValue(selRow, "vl_vd_div");  // VL VD 구분(1,2)
                	
    				// INSERT 와 BKG CREATE 를 동시에 진행하지 못함 (UPDATE 는 허용)
    				if(ibflag=="I") {
    					//ComShowMessage("Please save inserted data first");
    					ComShowCodeMessage("EQR01124");
    					return false;
    				}   
    				
                	// REPO BKG(VL) 을 선택하지 않으면 BKG CRE 진행 안됨.
    				if((vl_vd_div==0 || vl_vd_div==2) || vl_vd_div==null) {
    					//ComShowMessage("Please select REPO BKG(VL) Row.");
    					ComShowCodeMessage("EQR01123");
    					return false;
    				}     				
    				
    				// BKG NO 가 존재하면 BKG CRE 진행 안됨.
    				if(bkg_no!="" && bkg_no!=null) {
    					//ComShowMessage("Selected data is already exist Repo BKG No.");
    					ComShowCodeMessage("EQR01122");
    					return false;
    				} 
    				
      				if(ComShowConfirm(ComGetMsg("EQR90053"))) {  // confirm("선택된 Repo BKG 실행하시겠습니까?")
      				    if(validateForm(sheetObj,formObj,sAction,2)) {       // SAVE 버튼 VALIDATION 처리				    				
      				    	
      				    	sheetObj.CellValue2(selRow, "ibflag") = "U";     // IBFLAG를 U로 변경하여 BKG NO 생성
      				    	sheetObj.CellValue2(selRow, "mty_bkg_flag") = "T";     // bkg_no_flag = "T" 로 변경
                			// insert row를 기억
                			document.form.position_row1.value = selRow;
                			
                 			formObj.f_cmd.value = MULTI01;
                 			sheetObj.DoSave("EES_EQR_1018GS.do", eqrFormQryStr(formObj));
      				    }
      				}
      				
      				sheetObj.CellValue2(selRow, "mty_bkg_flag") = "";     // bkg_no_flag = "" 로 변경
      				
                    break;
                
                // NO PLAN ADD    
                case IBINSERT:
                	var Row = sheetObj.DataInsert(0);

                    sheetObj.CellValue2(Row, "div")         = "REPO BKG(VL)"; // REPO BKG 로 셋팅
                    sheetObj.CellValue2(Row, 'trsp_mod_cd') = "";  	// 선택안된 상태로 셋팅

                    sheetObj.CellValue2(Row, 'eq_repo_purp_cd')   = "";     // Purpose 은 선택안된 상태로 셋팅
                    sheetObj.CellValue2(Row, 'repo_pln_fb_rsn_cd')= "";     // Reason 은 선택안된 상태로 셋팅
    				//sheetObj.CellEditable(Row, 'repo_pln_fb_rmk') = false;   // Reason Remark는 수정안되는 상태로 셋팅
    				sheetObj.CellEditable(Row, 'mty_bkg_no')      = false;   // BKG NO는 수정안되는 상태로 셋팅

        			sheetObj.CellValue2(Row, "mty_rob_flg") = "0";  		// MTY ROB FLAG 
                    sheetObj.InitCellProperty(Row, "mty_rob_flg", dtCheckBox);

    				sheetObj.CellValue2(Row, "cntr_img")  = "9";    // cntr image 초기화

    				sheetObj.CellValue2(Row, "order_seq")   = "2";    // REPO BKG Row로 셋팅
    				sheetObj.CellValue2(Row, "vl_vd_div") = "1";    // VL로 셋팅

                    // 수정불가 조정
    				sheetObj.CellEditable(Row, 'vsl_lane_cd')	= false;  // LANE 수정안되는 상태로 셋팅
//    				sheetObj.CellEditable(Row, 'vvd')        	= false;  // VVD 수정안되는 상태로 셋팅
					
					// row_tp_flag 에 row type 기재
                    sheetObj.CellValue2(Row, "row_tp_flag") = "NOPLAN";
					
                    sheetObj.InitCellProperty(Row, "fm_yd_cd", dtCombo);
                    sheetObj.InitCellProperty(Row, "to_yd_cd", dtCombo);

                    break;                    

            }
        }

      	// 조회후 소개 계산
        function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//    		ComEtcDataToForm(document.form, sheetObj);
//
//            divnameToggle(); // divname 선택에 따라 row 를 show/hidden 함
        }

    	// SHEET1 ONCHANGE EVENT 발생
        function t1sheet1_OnChange(sheetObj, Row, Col, Val) {

        	var colName = sheetObj.ColSaveName(Col);
        	
			// [ LOC YARD COMBO BOX ]
    		if(colName=="fm_yd_cd" || colName=="to_yd_cd") {  // LOC YARD COMBO BOX
                var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
                var searchword = sheetObj.CellValue(Row, colName);
				
                if (sheetObj.CellValue(Row, "row_tp_flag") == "NOPLAN") { // No Plan 으로 추가된 Row 일 때
					if(idx != -1){ // 선택한게 있을 때
					    if (colName == "fm_yd_cd") {
					    	// FM YD 셋팅
					    					    	
					    	// ETD DATE 셋팅
					        sheetObj.CellValue2(Row,"fm_etd_dt") = sheetObj.CellValue(Row, "fm_yd_cd").split("%%")[1]; 
					        // POL CLPT_IND_SEQ 셋팅(BKG 넘겨줄 데이터)
					        sheetObj.CellValue2(Row,"pol_clpt_ind_seq") = sheetObj.CellValue(Row, "fm_yd_cd").split("%%")[3]; 
					        
					        // to_etd 의 seq 가 작거나 같을 경우, TO 값 지우기
					        if(sheetObj.CellValue(Row,"to_yd_cd")!="" && sheetObj.CellValue(Row,"fm_yd_cd")!=""
					          && sheetObj.CellValue(Row,"fm_yd_cd").split("%%")[2]*1 >= sheetObj.CellValue(Row,"to_yd_cd").split("%%")[2]*1){
					            // ToYdCd, ToEtaDt 지우기
							    ComShowCodeMessage("EQR01125"); // 'ETB must be later than ETD.'; 
					            sheetObj.CellValue2(Row,"to_yd_cd") = "";
					            sheetObj.CellValue2(Row,"to_eta_dt") = "";
					            sheetObj.CellValue2(Row,"pol_clpt_ind_seq") = "";
					        }  
					    }else if (colName == "to_yd_cd") {
					        sheetObj.CellValue2(Row,"to_eta_dt") = sheetObj.CellValue(Row, "to_yd_cd").split("%%")[1];  

					        // POL CLPT_IND_SEQ 셋팅(BKG 넘겨줄 데이터)
					        sheetObj.CellValue2(Row,"pod_clpt_ind_seq") = sheetObj.CellValue(Row, "to_yd_cd").split("%%")[3]; 
					        
					        // to_etd 의 seq 가 작거나 같을 경우, TO 값 지우고, 메시지 보이기
					        if(sheetObj.CellValue(Row,"to_yd_cd")!="" && sheetObj.CellValue(Row,"fm_yd_cd")!=""
					            && sheetObj.CellValue(Row,"fm_yd_cd").split("%%")[2]*1 >= sheetObj.CellValue(Row,"to_yd_cd").split("%%")[2]*1){
					            // ToYdCd, ToEtaDt 지우기
					            ComShowCodeMessage("EQR01125"); // 'ETB must be later than ETD.';  
					            sheetObj.CellValue2(Row,"to_yd_cd") = "";
					            sheetObj.CellValue2(Row,"to_eta_dt") = "";
					            sheetObj.CellValue2(Row,"pod_clpt_ind_seq") = "";
					        }  
					    }
					}else{ // 선택한게 없을 때
					    if (colName == "fm_yd_cd") {
					        sheetObj.CellValue2(Row,"fm_etd_dt") = "";
					    }else if (colName == "to_yd_cd"){
					        sheetObj.CellValue2(Row,"to_eta_dt") = "";
					    }
					}
				
				}else{ // 그 외 VL Add
	       			if(idx == -1 && searchword != "") { // 선택 없을 경우 , 검토 필요
	            		// searchword.length >= 5 && searchword.substr(0,5)==ecc 이어야만 YARD 검색가능
	        			var basic_ecc = "";
	        			if      (colName == "fm_yd_cd" && sheetObj.CellValue(Row, "fm_yd_cd").length >= 5)  basic_ecc = sheetObj.CellValue(Row, "fm_yd_cd").substring(0,5);
						else if (colName == "to_yd_cd" && sheetObj.CellValue(Row, "to_yd_cd").length >= 5)  basic_ecc = sheetObj.CellValue(Row, "to_yd_cd").substring(0,5);
						
	        		    if(searchword.length == 7) {
	                		var f_cmd = SEARCH02;
	               			sheetObj.InitCellProperty(Row, colName, dtData); // CELL TYPE을 DTDATA으로 변경
	        		    	sheetObj.CellValue2(Row, colName) = "";

	        		    	var str = sheetObj.GetSearchXml("EES_LOCYARDEXIST_COMMON.do" ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
	        		    	sheetObj.LoadSearchXml(str, false, -1, true);
	        		    	
	       			    }else if(searchword.length >= 5 && searchword.substr(0,5)==basic_ecc) {
	               			var f_cmd = SEARCHLIST20;
	               		
	               			sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
	               			sheetObj.CellValue2(Row, colName) = "";
	               		}else {
	               		    ComShowCodeMessage("EQR90171", basic_ecc);
	               			sheetObj.CellValue2(Row, colName) = "";
	               		}        		            		    
	       			}
				}
       		}
			
			// VL Add(No Plan) 에서 Item 변경시, VVD 초기화 
            if (colName == "trsp_mod_cd" && sheetObj.CellValue(Row, "row_tp_flag") == "NOPLAN") {
                sheetObj.CellValue(Row,"vvd") = "";
			}
         	// VVD 입력시 존재여부 검색 (ADD ROW)
        	if(colName=="vvd" && sheetObj.CellValue(Row,"order_seq")=="2") {
        		var formObj = document.form;
        		var searchword = sheetObj.CellValue(Row, colName);

                var vvd_length = searchword.length;

       			    if(searchword!="") {
						if (sheetObj.CellValue(Row, "row_tp_flag") == "NOPLAN") { // No Plan 으로 추가된 Row 일 때
						    if(sheetObj.CellValue(Row, "trsp_mod_cd")==""){
								//Select Item First.
								ComShowCodeMessage("EQR01102","Item first"); // Please select {?msg1}.
								sheetObj.CellValue2(Row,"vsl_lane_cd") = "";
								sheetObj.CellValue2(Row,"vvd") = "";
								sheetObj.SelectCell(Row, "trsp_mod_cd");
								return false;
							}
	            		    if(vvd_length != 9) { 
	            			   //Please enter ' + msg1 + ' digits long data.
	              			   ComShowCodeMessage("EQR90078","9");//9 자리로 입력하세요.
	
	              			   sheetObj.CellValue(Row,"vsl_lane_cd") = "";
	              			   
							   sheetObj.CellComboItem(Row, "fm_yd_cd", "|","|");	              			 	              			 
	                           sheetObj.CellComboItem(Row, "to_yd_cd", "|","|");
	              			   sheetObj.CellValue(Row,"fm_etd_dt") = "";
	               			   sheetObj.CellValue(Row,"to_eta_dt") = "";
	//              			   sheetObj.CellEditable(Row,"fm_etd_dt") = true;
	//              			   sheetObj.CellEditable(Row,"to_eta_dt") = true;
	
	             			   sheetObj.CellValue(Row,"vvd") = "";
	              			   sheetObj.SelectCell(Row,"vvd");
	              			   
	            		   }else {
	            			   ComOpenWait(true); 
	
	            			   var f_cmd = SEARCH01;
	            			   var sXml = sheetObj.GetSearchXml("EES_EQR_1018GS4.do", "f_cmd="+f_cmd + "&vvd="+searchword+"&trsp_mod_cd="+sheetObj.CellValue(Row,"trsp_mod_cd"));
	                           sheetObj.ShowMsgMode = true;
	                           var arrXml = sXml.split("|$$|");
	                           var slnaCd = ComGetEtcData(arrXml[0], "slan_cd");
	                           if(slnaCd != "" && slnaCd != undefined){
									sheetObj.CellValue2(Row, "vsl_lane_cd") = slnaCd;

									var frYdCdArr = ComXml2ComboString(arrXml[0], "fm_yd_cd", "fm_etd_dt");
									var toYdCdArr = ComXml2ComboString(arrXml[1], "to_yd_cd", "to_etb_dt");
	
									if(ComGetTotalRows(arrXml[0]) > 0){
									    sheetObj.CellComboItem(Row, "fm_yd_cd", "|" + frYdCdArr[0], "|"+frYdCdArr[1]);
									}else{
										sheetObj.CellComboItem(Row, "fm_yd_cd", "|","|");
									}
									sheetObj.CellValue2(Row, "fm_yd_cd") = "";
	                                sheetObj.CellValue2(Row, "fm_etd_dt") = "";
									
									if (ComGetTotalRows(arrXml[1]) > 0) {
										sheetObj.CellComboItem(Row, "to_yd_cd", "|" + toYdCdArr[0], "|"+toYdCdArr[1]);
									}else{
	                                    sheetObj.CellComboItem(Row, "to_yd_cd", "|","|");
	                                }
								    sheetObj.CellValue2(Row, "to_yd_cd") = "";
								    sheetObj.CellValue2(Row, "to_eta_dt") = "";
									
									ComOpenWait(false);
	                           }else{
							   	    sheetObj.CellValue2(Row, "vsl_lane_cd") = "";
									sheetObj.CellComboItem(Row, "fm_yd_cd", "|","|");
									sheetObj.CellComboItem(Row, "to_yd_cd", "|","|");
									sheetObj.CellValue2(Row, "fm_yd_cd") = "";   
									sheetObj.CellValue2(Row, "to_yd_cd") = "";  
									sheetObj.CellValue2(Row, "fm_etd_dt") = "";
                                    sheetObj.CellValue2(Row, "to_eta_dt") = "";
	                                ComOpenWait(false);
	                                ComShowCodeMessage("EQR90001","accurate vvd code");
	                                sheetObj.SelectCell(Row, Col);
	                           }
	        		      	}
						}
       			    }else{
						if (sheetObj.CellValue(Row, "row_tp_flag") == "NOPLAN") { // No Plan 으로 추가된 Row 일 때
						    sheetObj.CellValue2(Row, "vsl_lane_cd") = "";
                            sheetObj.CellComboItem(Row, "fm_yd_cd", "|","|");
                            sheetObj.CellComboItem(Row, "to_yd_cd", "|","|");
                            sheetObj.CellValue2(Row, "fm_yd_cd") = "";   
                            sheetObj.CellValue2(Row, "to_yd_cd") = "";  
							sheetObj.CellValue2(Row, "fm_etd_dt") = "";
                            sheetObj.CellValue2(Row, "to_eta_dt") = "";
						}
					}

        	}

    		// MTY Repo BKG 체크박스 체크
    		if(sheetObj.ColSaveName(Col) == "t1_repo_mty_bkg_flg") {
    			// MTY Repo BKG 체크된 다른 row를 검색
          		var sRow = sheetObj.FindStatusRow("U");
          		var arRow = sRow.split(";");
    			var cntr_all = "";
    			
    			/*
    			 * CSR ID : CHM-200901821
    			 * 2009/12/14 부터 MTY MULTI BKG 기능을 정지 - 계은영 수석 CSR
    			 * ADDED BY SHIN YONGCHAN - 20091209
    			 */
    			var bkg_count = 0;

          		if(sRow!="" && sRow!=null) {
          			for(var i=0; i<arRow.length-1; i++) {
          				if(sheetObj.CellValue(arRow[i], "t1_repo_mty_bkg_flg")=="1" ) {
    						bkg_count++;
          				}
          			}
          		}

          		if(bkg_count > 1) {
          		    //'VD Add는 한번에 1회만 가능합니다.'
          			ComShowCodeMessage("EQR90152", "MTY Repo BKG"); // 1개 이상의 MTY REPO BKG을 선택할 수 없음.
          			sheetObj.CellValue2(Row, "t1_repo_mty_bkg_flg")=0;
          			return false;
          		}
          		// CSR ID : CHM-200901821   추가 소스 END
          		
          		if(sRow!="" && sRow!=null && sheetObj.CellValue(Row, "t1_repo_mty_bkg_flg")==1 && arRow.length>1) { // 1개만 체크된 경우는 확인 안함
    				var year_week = sheetObj.CellValue(Row, "t1_pln_yrwk");             // week
    				var load_loc  = sheetObj.CellValue(Row, "t1_sort").substring(0,5);  // from yard 가 소속된 ecc
    				var vvd       = sheetObj.CellValue(Row, "vvd");                  // vvd
    				var co_cd     = sheetObj.CellValue(Row, "t1_co_cd");                // company

          			for(var i=0; i<arRow.length-1; i++) {
          				if(sheetObj.CellValue(arRow[i], "t1_repo_mty_bkg_flg")==1) {  // BKG CHECK BOX 체크된 ROW
          					if(year_week==sheetObj.CellValue(arRow[i], "t1_pln_yrwk")            &&
          					   load_loc ==sheetObj.CellValue(arRow[i], "t1_sort").substring(0,5) &&
          					   vvd      ==sheetObj.CellValue(arRow[i], "vvd")                 &&
          					   co_cd    ==sheetObj.CellValue(arRow[i], "t1_co_cd")
          					) {
    							sheetObj.CellValue(Row, 't1_repobkg_flag') = "T";  // repobkg 수정상태로 변경해줍니다.
          					}else {
          						//ComShowMessage("이미 선택된 MTY Repo BKG과 Load LOC, VVD 정보가 다릅니다.");
          						ComShowCodeMessage("EQR90121");
          						sheetObj.CellValue2(Row, "t1_repo_mty_bkg_flg")=0;
          						break;
          					}
          				}
          			}
          		}

          		if(sheetObj.CellValue(Row, "t1_repo_mty_bkg_flg")==0) {
          			sheetObj.CellValue2(Row, 't1_repobkg_flag') = "F";
          		}

    		}

    		// SPLIT BOOKING NO SELECT BOX 부킹정보 선택시
    		if(sheetObj.ColSaveName(Col) == "mty_bkg_no") {
    			// 해당 BOOKING의 정보를 조회해서 화면해서 디스플레이 합니다.
    			// code[0] : booking no
    			// code[1] : company code
    			// code[2] : from yard
    			// code[3] : etd
    			// code[4] : eta

    			// ------ 해당 BOOKING의 EXECUTE 기본정보 검색 [START] -----------
                var bkg_no = sheetObj.CellValue(Row,"mty_bkg_no");
                var f_cmd = SEARCH02;

    			if(bkg_no!=null && bkg_no!="") {
//                	sheetObj.DoRowSearch("EES_EQR_1018GS2.do" ,"row="+Row+"&search_bkgno="+bkg_no+"&f_cmd="+f_cmd);
                	sheetObj.DoRowSearch("EES_EQR_1018GS2.do" ,"row="+Row+"&search_bkgno="+bkg_no+"&tpsztype="+consTpsz+"&f_cmd="+f_cmd);
                }
    			// ------ 해당 BOOKING의 EXECUTE 기본정보 검색 [END] -----------


    		}

        }

        // vol 계산시 필요한 과거값 임시기억 기능(매우중요)
        function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {

            // cell 이 가지고 있던 정보를 잠시 저장합니다.(매우 중요)
    		if(sheetObj.ColSaveName(NewCol).substring(0,6) == "qty_") {
    		    oldValue = sheetObj.CellValue(NewRow, NewCol);

    		}

        }

    	// SHEET1 ONCLICK EVENT
        function t1sheet1_OnClick(sheetObj, Row, Col, Val) {
    		//if(sheetObj.ColSaveName(Col).substring(0,6) == "qty_") oldValue = Val;  // cell 이 가지고 있던 정보를 잠시 저장합니다.(매우 중요)

        	// insert 했던 row를 del하는 경우
    		if(sheetObj.RowStatus(Row)=="I" && sheetObj.ColSaveName(Col) == "check") {

    		    sheetObj.CellValue(Row, "t1_cntrno") = ""; // CNTR 초기화

    			for(var i=0; i<consTpszArr.length ; i++) {
    			    oldValue = sheetObj.CellValue(Row, "qty_"+consTpszArr[i]); // old value setting
    				sheetObj.CellValue(Row, "qty_"+consTpszArr[i]) = "0";      // '0' 으로 변경
    			}
    		}

        	// ----------- cntr image 클릭 ----------------------
        	if(sheetObj.ColSaveName(Col) == "cntr_img") {  // 'cntr input' image cell을 클릭
        	    if(sheetObj.CellValue(Row,"order_seq")=="2" && sheetObj.CellValue(Row,"mty_bkg_no")!="") { // BKG 존재하는 vl/vd 일때만 오픈

          				oldValue = 0; // oldvalue 초기화

        	    		// 1051 호출 - BOOKING 의 Container List 조회
      					var url = "EES_EQR_1051.do"
      							+ "?bkgno="+sheetObj.CellValue(Row,"mty_bkg_no")
      							+ "&vvd="+sheetObj.CellValue(Row,"vvd")
      							+ "&polcd="+sheetObj.CellValue(Row,"fm_yd_cd")
      							+ "&podcd="+sheetObj.CellValue(Row,"to_yd_cd")      							
      		       	        	;
      					var styleInfo = "dialogLeft:0px; dialogTop:0px; dialogWidth:800px; dialogHeight:570px; scroll:no; status:no";
      					var modal     = window.showModalDialog(url, self, styleInfo);
      				
        	    }
        	}
        	
        	// ----------- ROB 클릭 ----------------------
        	if(sheetObj.ColSaveName(Col) == "mty_rob_flg") {  // 'ROB' cell을 클릭
        		// BKG 존재하고 ROB 체크인 경우만 오픈
        	    if(sheetObj.CellValue(Row,"order_seq")=="2" && sheetObj.CellValue(Row,"mty_bkg_no")!="" && sheetObj.CellValue(Row,"mty_rob_flg")=="1") { 
    	    		
        	    	// 1050 호출 - ROB BKG VVD DETAIL 팝업 
  					var url = "EES_EQR_1050.do"
  							+ "?bkg_no="+sheetObj.CellValue(Row,"mty_bkg_no")
  		       	        	;
  					//var styleInfo = "dialogLeft:0px; dialogTop:0px; dialogWidth:800px; dialogHeight:570px; scroll:no; status:no";
  					//var modal     = window.showModalDialog(url, self, styleInfo);
  					ComOpenWindowCenter(url,'EesEqr1050', '645', '330', true);

      				
        	    }
        	}        	
        }
        
    	/*
    	* ToolTip
    	*/
    	function t1sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){
			Row = sheetObj.MouseRow;
			sheetObj.ToolTipOption="balloon:true;width:300;backcolor:#FFFFA5;forecolor:#450693;icon:0;title:To Yard";
			
    		if (sheetObj.MouseCol==sheetObj.SaveNameCol("to_yd_cd")){
    			var check = "N";
    			
    			if ( sheetObj.CellText(Row,"t1_sortnum") == "1"
    				&& sheetObj.CellText(Row,"t1_num") == "1"
    				&& sheetObj.CellText(Row,"t1_past_repo_pln_flg") == "Y" ) {
    				check = "Y";
    			}
    			if (check == "Y"){
	    			sText = sheetObj.CellText(Row,"t1_to_yard");
	    			
	    			sheetObj.MousePointer = "Hand";    			
	    			sheetObj.MouseToolTipText = sText;
    			} else {
    				sheetObj.MousePointer = "Default";
        			if (sheetObj.MouseToolTipText != "") { 
        				sheetObj.MouseToolTipText = "";
        			} 
    			}
    		} else {
    			sheetObj.MousePointer = "Default";
    			if (sheetObj.MouseToolTipText != "") { 
    				sheetObj.MouseToolTipText = "";
    			} 
    		}
    	}
        
    	// SHEET1 ONCLICK EVENT
        function t1sheet1_OnDblClick(sheetObj, Row, Col, Val) {
        	var colName = sheetObj.ColSaveName(Col);

        	// 더블클릭하여, 콤보내용을 Edit한 경우...
        	// OnChange 이벤트를 발생시키기 위해, 아래와 같이 Cell내용을 초기화한다.
        	var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
        	if((colName == "fm_yd_cd" || colName == "to_yd_cd") && sheetObj.CellEditable(Row, colName) && idx!=-1) {
        		sheetObj.CellValue2 = "";
        	}
        }

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         * tabNum : tab 구분에 사용됩니다.(1,2,3,4,5)
         */
        function validateForm(sheetObj,formObj,sAction,tabNum){
     		var formObj = document.form;

            with(formObj){

                // btn_retrieve
                if(sAction == 0) {
                	// Period 혹은 VVD 는 반드시 입력 체크(문동선 작업)
                	// Period 에서 from --> From Region 필수 선택
                	// Period 에서 To   --> To Region 필수 선택
					if(formObj.vvdname.className  == "input1" && formObj.vvdname.value == ""){
                        ComShowCodeMessage("EQR01110","VVD"); // 'Please input {?msg1}.'
						return false;
                    }
                    if(formObj.fromdate.className == "input1" && formObj.fromdate.value == ""){
                        ComShowCodeMessage("EQR01110","From Date"); // 'Please input {?msg1}.'
                        return false;
                    }
                    if(formObj.todate.className == "input1" && formObj.todate.value == ""){
                        ComShowCodeMessage("EQR01110","To Date"); // 'Please input {?msg1}.'
                        return false;
                    }
					if(ComGetDaysBetween(formObj.fromdate.value, formObj.todate.value) > 31){
                        ComShowCodeMessage("EQR01018","31 days"); // 'Max Period is {?msg1}.'
                        return false;
                    }
					if(ComGetDaysBetween(formObj.fromdate.value, formObj.todate.value) < 0){
                        ComShowCodeMessage("EQR01118"); // 'From date must be earlier than To date.'
                        return false;
                    }
                    if(formObj.fromlocation.className == "input1" && formObj.fromlocation.value == ""){
                        ComShowCodeMessage("EQR01110","From LOC"); // 'Please input {?msg1}.'
                        return false;
                    }
                    if(formObj.tolocation.className == "input1" && formObj.tolocation.value == ""){
                        ComShowCodeMessage("EQR01110","To LOC"); // 'Please input {?msg1}.'
                        return false;
                    }
                    // ITEMNAME 선택을 하나도 안하면 조회 불가
                    if(formObj.itemname.Code == "" || formObj.itemname.Code == null) {
                        ComShowCodeMessage("EQR01102","Item"); // 'Please select {?msg1}.'
                        return false;                    	
                    }
            	}else if(sAction == 2) {   // save
    				// Add Row 된 항목중에서 Total Vol=0 은 입력을 허락하지 않는다.
    				// Plan은 제외
          			var sRow = sheetObj.FindStatusRow("I|U");
          			var arRow = sRow.split(";");
    				var cntr_all = "";

          			if(sRow!="" && sRow!=null) {
          				for(var i=0; i<arRow.length-1; i++) {
//          					// PURPOSE 필수선택 아니면 메세지
//          					if(sheetObj.CellValue(arRow[i], "total_vol")== "") {
//          						
//          					}
//   				   		   sheetObj.CellValue(arRow[i], "t1_repo_pln_fb_rsn_cd")=="" &&
//  				   		   sheetObj.CellValue(arRow[i], "t1_sortnum")=="2"
//  						) {
//  							//ComShowMessage("LINE "+(arRow[i]-1)+ "Reason  정보를 선택해 주세요 ! ");
//              				ComShowCodeMessage("EQR90126", (arRow[i]-1), "Reason");
//              				sheetObj.SelectCell(arRow[i], "t1_repo_pln_fb_rsn_cd");  // REASON 위치로 포커스 이동          					
          					
          					
          					// Execution 라인에 대해서만 TOTAL=0 여부를 확인
          					if(sheetObj.CellValue(arRow[i], "total_vol")== "0"           &&
          					   sheetObj.CellValue(arRow[i], "order_seq")!= "1"
          					) {
          						//ComShowMessage("Row "+(eval(arRow[i])-1)+" Total Vol = 0 상태입니다. 입력,수정 불가능합니다. ");
        						ComShowCodeMessage("EQR01130", eval(arRow[i])-1);
          						return false;
          					}
          				}
          			}
            	}
            }

            return true;
        }

    	// Location 단위를 셋팅을 한다.
      	function frLocChange(key) {
        	var gubun = key;
          	if(gubun =="") {
          		document.form.fromlocation.value ="";
          		document.form.fromlocation.disabled = true;
          	}else {
          		document.form.fromlocation.value ="" ;
          		document.form.fromlocation.disabled = false;
          	}
        }

    	// Location 단위를 셋팅을 한다.
      	function toLocChange(key) {
        	var gubun = key;
          	if(gubun =="") {
          		document.form.tolocation.value ="";
          		document.form.tolocation.disabled = true;
          	}else {
          		document.form.tolocation.value ="" ;
          		document.form.tolocation.disabled = false;
          	}
        }

    	// 멀티 콤보박스 선택셋팅 (DB 부분 셋팅을 해야 할것임)
    	function tpszChange(key){

            switch (key)
            {
                case "":
                    comboObjects[1].Code = consTpsz;
                	break;
                case "D":
                    comboObjects[1].Code = consTpszDry;
                	break;
                case "R":
                    comboObjects[1].Code = consTpszRfr;
                	break;
                case "O":
                    comboObjects[1].Code = consTpszOt;
                	break;
                case "F":
                    comboObjects[1].Code = consTpszFr;
                	break;
            }
    	}

        // 저장후 메세지 표현
        function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
        	if(errMsg=='') ComShowCodeMessage("EQR90106");//저장이 완료

        	// insert row 의 경우 저장후 조회시 row근처로 이동
        	if(document.form.position_row1.value != 1) {
            	var row = eval(document.form.position_row1.value) + eval(8);

            	sheetObj.SelectCell(row, "bkg_sts_cd");

            	// color 변경
            	sheetObj.RowBackColor(document.form.position_row1.value) = sheetObj.RgbColor(247, 251, 89);  // 노란색

            }

            // 초기화
            document.form.position_row1.value  = 1;

        }

        /*
         * user 권한별 행동제약을 모두 통제합니다.
         * sheetObj
         * action    : 행동구분(VL ADD, BOOKING, COMBINED EXE....)
         * direction : from, to
         * tab_div   : TAB 1, 2, 3, 4, 5
         * selRow    : row
         *
         * INLAND(tab_div = 2) 일때는 from, to 중에 한군데만 맞으면 작업 가능
         */
        function userAreaCheck(sheetObj, action, direction, tab_div, selRow) {
            var rccName = null;
            var lccName = null;

            var user_level    =  document.form.user_level.value;
            var user_location =  document.form.user_modify_location.value;
            var cell_location_rcc =  null;
            var cell_location_lcc =  null;

            var directionmes = null;

            // from, to 에 따라 변수 이름 셋팅.
            if(direction=="from") {
               rccName = "t"+tab_div+"_fm_rcc";
               lccName = "t"+tab_div+"_fm_lcc";

               directionmes = "From";

            }else {
               rccName = "t"+tab_div+"_to_rcc";
               lccName = "t"+tab_div+"_to_lcc";

               directionmes = "To";

            }

            // row의 rcc, lcc 정보
            cell_location_rcc = sheetObj.CellValue(selRow, rccName);
            cell_location_lcc = sheetObj.CellValue(selRow, lccName);

            //ComShowMessage("cell_location_rcc : " + cell_location_rcc);

            // user level = 2 는 rcc 기준으로 확인
            // user level = 5 는 lcc 기준으로 확인
            if(tab_div=="2") {  // inland(FROM, TO 중 한개만 일치해도 작업 허용)
                if(	(user_level =="2" && (user_location==sheetObj.CellValue(selRow, "t2_fm_rcc") || user_location==sheetObj.CellValue(selRow, "t2_to_rcc"))) ||
    			    (user_level =="5" && (user_location==sheetObj.CellValue(selRow, "t2_fm_lcc") || user_location==sheetObj.CellValue(selRow, "t2_to_lcc"))) ||
    			    user_level =="1"
                ) {
                    return true;

                }else {
                    if(action != "CNTR") {  // cntr popup 은 메세지가 없습니다.
                        if(user_level=="5") {
        			        //ComShowMessage("작업가능지역을 벗어났습니다. "+action+" 불가능합니다. \n\n "+action+" 는 당신의 "+directionmes+" Location 작업 영역인 LCC : '"+user_location+"' 에 한해서만 가능합니다. ");
        			        // You can take a necessary action under '+msg1+' '+msg2+'('+msg3+'). '
        			        ComShowCodeMessage("EQR90160", "", "LCC", user_location);
                        }else if(user_level=="2") {
        			        //ComShowMessage("작업가능지역을 벗어났습니다. "+action+" 불가능합니다. \n\n "+action+" 는 당신의 "+directionmes+" Location 작업 영역인 RCC : '"+user_location+"' 에 한해서만 가능합니다. ");
        			        // You can take a necessary action under '+msg1+' '+msg2+'('+msg3+'). '
        			        ComShowCodeMessage("EQR90160", "", "RCC", user_location);
                        }
                    }

                    return false;
                }

            }else {  // tab 1, 3, 4 ( VESSEL, ON-OFF, SHUTTLE)
                if(	(user_level =="2" && user_location == cell_location_rcc) ||
    			    (user_level =="5" && user_location == cell_location_lcc) ||
    			    user_level =="1"
                ) {
                    return true;

                }else {
                    if(action != "CNTR") {  // cntr popup 은 메세지가 없습니다.
                        if(user_level=="5") {
        			        //ComShowMessage("작업가능지역을 벗어났습니다. "+action+" 불가능합니다. \n\n "+action+" 는 당신의 "+directionmes+" Location 작업 영역인 LCC : '"+user_location+"' 에 한해서만 가능합니다. ");
        			        // You can take a necessary action under '+msg1+' '+msg2+'('+msg3+'). '
        			        ComShowCodeMessage("EQR90160", directionmes, "LCC", user_location);
                        }else if(user_level=="2") {
        			        //ComShowMessage("작업가능지역을 벗어났습니다. "+action+" 불가능합니다. \n\n "+action+" 는 당신의 "+directionmes+" Location 작업 영역인 RCC : '"+user_location+"' 에 한해서만 가능합니다. ");
        			        // You can take a necessary action under '+msg1+' '+msg2+'('+msg3+'). '
        			        ComShowCodeMessage("EQR90160", directionmes, "RCC", user_location);
                        }
                    }

                    return false;
                }
            }
        }

        /*
         * ON KEYUP에서만 작동됨.
         * 카피후 복사로 입력하는 행위를 제한.(허용할 경우 데이터 정량확인이 안됨)
         */
        function copyLogicControl(sheetObj, row, col) {
            var colName = sheetObj.ColSaveName(col);
            //alert("value : " +sheetObj.CellValue(row, colName));
            sheetObj.CellValue2(row, colName) = "";  // 데이터 제거
        }

      	/*
      		Ecc Internal에서 Yard Code를 7자리 입력시 yard code check 하는 로직(공통)
      	*/
    	function checkYardCode_iframe(row, search_ecc, yard_col, ecc_col, yard_code, ecc_code) {

    	    if(yard_code=="") {
    	        //ComShowMessage("Please input yard code under 'USNYC' ECC.");
    	        ComShowCodeMessage("EQR90171", search_ecc);
    	        
    	        sheetObjects[3].CellValue(row, yard_col) = '';   // ecc internal yard cell value변경
    	        sheetObjects[3].CellValue(row, ecc_col)  = '';   // ecc internal ecc cell value변경
    	        sheetObjects[3].SelectCell(row, yard_col);
    	    }else {
    	        sheetObjects[3].CellValue(row, yard_col) = yard_code;  // ecc internal yard cell value변경
    	        sheetObjects[3].CellValue(row, ecc_col)  = ecc_code;   // ecc internal ecc cell value변경

    	    }

    	    document.form.target = "";

    	}

  
    function tpsztype_OnChange(){
        setGridHidden(form.tpsztype.Text);
    }
    
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd){
        var sheetObj = sheetObjects[0]; 
        var arr_tpsz = tpsz_cd.split(",");

        for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
            for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                if(consTpszArr[i] == arr_tpsz[j]){
                    sheetObj.ColHidden("qty_"+consTpszArr[i])   = false;
                    break;
                }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                    sheetObj.ColHidden("qty_"+consTpszArr[i])   = true;
                }
            }       
        }  
    }
	
    function classToggle(){
		var formObj = document.form;
		if(document.form.divflag[0].checked == true){ // Period 가 선택
			formObj.vvdname.className    = "input";
            formObj.fromdate.className     = "input1";
            formObj.todate.className       = "input1";
			if(formObj.divdate.value=="F"){
				formObj.fromlocation.className = "input1";
                formObj.tolocation.className   = "input";
			}else{
				formObj.fromlocation.className = "input";
                formObj.tolocation.className   = "input1";
			}
		}else{ // VVD 가 선택 
		    formObj.vvdname.className          = "input1";
			formObj.fromdate.className     = "input";
			formObj.todate.className       = "input";
		    formObj.fromlocation.className = "input";
			formObj.tolocation.className   = "input";
		} 
	}	
	
   /**
    * Onbeforedeactivate  event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 
    * @version 
    */   
    function obj_deactivate() {
        var formObj = document.form;
        var eleName = event.srcElement.name;

        switch(eleName){
            
            case "fromdate":
            case "todate":
                if(eleName == "fromdate") {  
                    var tdate = formObj.fromdate.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
                    if (tdate.length >= 8) {                                                                                                                                                                                                                                                                                                                                                                                                                                           
                        formObj.fromdate.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);
                    }              
					if(!ComIsDate(formObj.fromdate.value)){ // 날짜 형식이 아니면
					    ComShowCodeMessage("EQR01111","From Date"); //'{?msg1} :  Date format is wrong';   
						formObj.fromdate.value = "";
					}                                                                                                                                                                                                                                                                                                                              
                }else if(eleName == "todate"){
                    var tdate = formObj.todate.value;                                                                                                                                                                                                                                                                                                                                                                                                                                  
                    if (tdate.length >= 8) {  
						formObj.todate.value = tdate.substring(0, 4) + "-" + tdate.substring(4, 6) + "-" + tdate.substring(6, 8);
                    }
					if(!ComIsDate(formObj.todate.value)){ // 날짜 형식이 아니면
					    ComShowCodeMessage("EQR01111","To Date"); //'{?msg1} :  Date format is wrong';
                        formObj.todate.value = "";
                    }
                }
                break; 
        }
        
    }    
    /**
    * OnBeforeActivate   event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author
    * @version 2009.04.17
    */   
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);

        switch(srcName){
            case "fromdate":
            case "todate":
                if(srcName == "fromdate") {                                                                                                                                                                                                                                                                                                                                                                                                                                               
                    formObj.fromdate.value = formObj.fromdate.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
                } else if(srcName == "todate") {                                                                                                                                                                                                                                                                                                                                                                                                                                        
                    formObj.todate.value = formObj.todate.value.replace(RegExp(/-/ig), "");                                                                                                                                                                                                                                                                                                                                                                                             
                }
                break; 
        }
    }	
    
	// SHEET1 ONCLICK EVENT
    function openMtyBkgUpdate(sheetObj, formObj) {
    	var bkgno = "";
    	var bkgdiv= "";
    	var selRow= "";

    	if(sheetObj.RowCount > 0) {
    		selRow = sheetObj.SelectRow;   // 선택된 ROW   
    		if(selRow != null) {
    			bkgno = sheetObj.CellValue(selRow, "mty_bkg_no");  // lane copy
    			bkgdiv= sheetObj.CellValue(selRow, "vl_vd_div");  // lane copy
    		}
    	}
    	
    	ComOpenWindowCenter("/hanjin/ESM_BKG_9424.do?mainPage=false&pgmNo=ESM_BKG_9424&bkgno="+bkgno+"&bkgdiv="+bkgdiv, "ESM_BKG_9424", 1024, 650, true, "yes");


    }    
    
	// Empty Bkg Split Open
    function openMtyBkgSplit(sheetObj, formObj) {
    	var Row = sheetObj.SelectRow;   // 선택된 ROW   

    	
    	if(sheetObj.CellValue(Row,"vl_vd_div")==1 || sheetObj.CellValue(Row,"vl_vd_div")==3 ) { // VL 선택
    		// VL BKG NO 존재하는지 여부
    		if(sheetObj.CellValue(Row,"mty_bkg_no")=="") {
    			// Vd Split must have bkg no., 
    			ComShowCodeMessage("EQR01127");
    			return false;
    		}
    		
    		// FEEDER 선택한 경우
    		if(sheetObj.CellValue(Row,"trsp_mod_cd")=="W") {
    			// Please select Trunk Item., 
    			ComShowCodeMessage("EQR01128");
    			return false;
    		}    		
    	}else { // VL 선택하지 않은 경우
    		// Please select REPO BKG(VL) Row., 
    		ComShowCodeMessage("EQR01123");
    		return false;    		
    	}    	    	
    	
		// 1052 호출
		var url = "EES_EQR_1052.do"
				+ "?f_cmd=-1"   // DEFAULT 호출 
				+ "&flag=S"   		                                 // SINGLE VD BKG SPLIT 	
				+ "&flag_rob="+sheetObj.CellValue(Row,"mty_rob_flg") // ROB FLAG
				+ "&vvd="+sheetObj.CellValue(Row,"vvd")   		     // vvd code
				+ "&bkg_no="+sheetObj.CellValue(Row,"mty_bkg_no")    // mty booking no
				+ "&pol_cd="+sheetObj.CellValue(Row,"fm_yd_cd")      // pol_cd			
 		       	;

		var styleInfo = "dialogLeft:0px; dialogTop:0px; dialogWidth:1060px; dialogHeight:535px;scroll:no;status:no";
		var modal     = window.showModalDialog(url, self, styleInfo);
    }        
    
	// Empty Bkg Split Open - Multi Bkg
    function openMtyBkgSplitMulti(sheetObj, formObj) {    	
    	
		// 1052 호출
		var url = "EES_EQR_1052.do"
				+ "?f_cmd=-1"   // DEFAULT 호출 
				+ "&flag=M"     // MULTI VD BKG SPLIT 					
 		       	;

		var styleInfo = "dialogLeft:0px; dialogTop:0px; dialogWidth:1060px; dialogHeight:535px;scroll:no;status:no";
		var modal     = window.showModalDialog(url, self, styleInfo);
    }    
    
	// Data Selection 기능(ALL, PLAN, REPO BKG)
    function dataSelectionPlanBKG(gubun){
	    var sheetObject = sheetObjects[0];
	    var totalRow = sheetObject.RowCount + 2;

	    // ALL
	    if (gubun =='1'){
	        for (i =0; i < totalRow; i++){
	            if (sheetObject.RowHidden(i)){
	            	sheetObject.RowHidden(i)= false;
	            }
	        }
	    // Plan
	    }else if (gubun == '2'){
	        for (i =0; i < totalRow; i++){
	            if(sheetObject.CellValue(i, "order_seq") == 2) {
	                sheetObject.RowHidden(i)= true;
	            }else {
	                sheetObject.RowHidden(i)= false;
	            }
	        }
	    //REPO BKG
	    }else if (gubun == '3'){
	        for (i =0; i < totalRow; i++){
	             if (sheetObject.CellValue(i, "order_seq") == 1){
	                 sheetObject.RowHidden(i)= true;
	            }else {
	                 sheetObject.RowHidden(i)= false;
	            } // if 끝
	        } //for 끝
	    //  Execution & W/O issue
	    }

	}    
    
  	/*
	vvd Code를 검색하는 로직(공통)
    */
    function checkVvdExist_iframe(division, row, vvd_col, slan_col, vvd_code, slan_code, vsl_dt, vvd_check) {
    
        if(division=="etd") {
            if(vvd_check=="FALSE") {
    
    	        // T.VVD를 잘못입력하는 경우 아래의 메세지로 VVD 재입력을 유도
                // ComShowMessage("Please input Eexecution data for VVD in T.VVD/D.VVD screen !");
                ComShowCodeMessage("EQR90173");
    
                sheetObjects[1].CellValue(row, vvd_col)   = '';   // vvd cell value변경
                sheetObjects[1].CellValue(row, slan_col)  = '';   // lane cell value변경
                sheetObjects[1].SelectCell(row, vvd_col);
     	        sheetObjects[1].CellEditable(row, "t2_fm_etd_dt") = true;
     	        
            }else {
                if(vvd_code=="" || vvd_code==null) {
                    //ComShowMessage("Please input accurate vvd code.");
                    ComShowCodeMessage("EQR90001", "accurate vvd code");
    
                    sheetObjects[1].CellValue(row, vvd_col)   = '';   // vvd cell value변경
                    sheetObjects[1].CellValue(row, slan_col)  = '';   // lane cell value변경
                    sheetObjects[1].SelectCell(row, vvd_col);
    
      	        }else {
      	            sheetObjects[1].CellValue(row, vvd_col)   = vvd_code;   // vvd cell value변경
       	            sheetObjects[1].CellValue(row, slan_col)  = slan_code;   // lane cell value변경
    
    //	            if(vsl_dt=="null" || vsl_dt=="") {
    //  	                sheetObjects[1].CellValue(row, "t2_fm_etd_dt")   = "";
    // 	                sheetObjects[1].CellEditable(row, "t2_fm_etd_dt") = true;
    //  	            }else {
    //   	                sheetObjects[1].CellEditable(row, "t2_fm_etd_dt") = false;
    //  	                sheetObjects[1].CellValue(row, "t2_fm_etd_dt")   = vsl_dt;
    //   	            }
      	        }
            }
        }else { // eta 검색시점
            if(vsl_dt=="" || vsl_dt=="null") {
                sheetObjects[1].SelectCell(row, "t2_to_eta_dt");
                sheetObjects[1].CellEditable(row, "t2_to_eta_dt") = true;
            }else {
                sheetObjects[1].CellEditable(row, "t2_to_eta_dt") = false;
                sheetObjects[1].CellValue(row, "t2_to_eta_dt")= vsl_dt;  // to_eta_dt 변경
    
    
            }
    
        }
    
        document.form.target = "";
    
    }
    
    /*
	SPLIT BKG 결과를 조회 (1052 에서 호출)
    */
    function searchSplitResult() {
        var sheetObject = sheetObjects[0];
        var formObject  = document.form;  	
        
        classToggle();	// 라디오 선택값에 따라 필수값 조정
        
        doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }    
    
    
	/* 개발자 작업  끝 */