/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0043.js
*@FileTitle : AVG-hire by Own-VSL (PA)
*Open Issues :
*@LastModifyDate : 2014-12-03
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2014-12-03 Je Ryang Yoo
*  1.0 최초 생성
=========================================================
* History                                                        
* 2015.08.24 손진환 [CHM-201537399] AVG-hire by Own-VSL (PA) Month Copy 기능 추가 생성 요청
* 2015.10.14 김성욱 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0043 : ESM_MAS_0043 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0043() {
    this.processButtonClick    = processButtonClick   ;
    this.setYrWk               = setYrWk              ;
    this.setYrMon              = setYrMon             ;
    this.fnYearWeekSet         = fnYearWeekSet        ;
    this.ComAddSeparator_Local = ComAddSeparator_Local;
    this.setPeriod             = setPeriod            ;
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd   ;
    this.sheet2_OnSearchEnd    = sheet2_OnSearchEnd   ;
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateForm          = validateForm         ;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
//var tab_no = 0;
//var tab_no2 = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var tabItem = 0;
var loadPageCnt = 0;
var loadingMode = false;

var flagPopCreation = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];
        var sheetObject4 = sheetObjects[4];
        var sheetObject5 = sheetObjects[5];
        var sheetObject6 = sheetObjects[6];
        var sheetObject7 = sheetObjects[7];
        var sheetObject8 = sheetObjects[8];
        var sheetObject9 = sheetObjects[9];
        
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Retrieve":
                	if (tabItem == 0) {
                		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        			} else if (tabItem == 1){        				
        				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
        			} else if (tabItem == 2){        				
        				doActionIBSheet(sheetObjects[2], formObject, IBSEARCH);
        			} else if (tabItem == 3){        				
        				doActionIBSheet(sheetObjects[3], formObject, IBSEARCH);
        			} else if (tabItem == 4){        				
        				doActionIBSheet(sheetObjects[4], formObject, IBSEARCH);
        			} else if (tabItem == 5){        				
        				doActionIBSheet(sheetObjects[5], formObject, IBSEARCH);
        			} else if (tabItem == 6){        				
        				doActionIBSheet(sheetObjects[6], formObject, IBSEARCH);
        			} else if (tabItem == 7){        				
        				doActionIBSheet(sheetObjects[7], formObject, IBSEARCH);
        			} else if (tabItem == 8){        				
        				doActionIBSheet(sheetObjects[8], formObject, IBSEARCH);
        			} else if (tabItem == 9){        				
        				doActionIBSheet(sheetObjects[9], formObject, IBSEARCH);
        			}
                    break;

                case "btn_Downexcel":
                	if (tabItem == 0) {
                		doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 1){        				
        				doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 2){        				
        				doActionIBSheet(sheetObjects[2], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 3){        				
        				doActionIBSheet(sheetObjects[3], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 4){        				
        				doActionIBSheet(sheetObjects[4], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 5){        				
        				doActionIBSheet(sheetObjects[5], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 6){        				
        				doActionIBSheet(sheetObjects[6], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 7){        				
        				doActionIBSheet(sheetObjects[7], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 8){        				
        				doActionIBSheet(sheetObjects[8], formObject, IBDOWNEXCEL);
        			} else if (tabItem == 9){        				
        				doActionIBSheet(sheetObjects[9], formObject, IBDOWNEXCEL);
        			}
                    break;

                case "btn_Save":
                	if (tabItem == 0) {
                		doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
        			} else if (tabItem == 1){        				
        				doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
        			} else if (tabItem == 2){        				
        				doActionIBSheet(sheetObjects[2], formObject, IBSAVE);
        			} else if (tabItem == 3){        				
        				doActionIBSheet(sheetObjects[3], formObject, IBSAVE);
        			} else if (tabItem == 4){        				
        				doActionIBSheet(sheetObjects[4], formObject, IBSAVE);
        			} else if (tabItem == 5){        				
        				doActionIBSheet(sheetObjects[5], formObject, IBSAVE);
        			} else if (tabItem == 6){        				
        				doActionIBSheet(sheetObjects[6], formObject, IBSAVE);
        			} else if (tabItem == 7){        				
        				doActionIBSheet(sheetObjects[7], formObject, IBSAVE);
        			} else if (tabItem == 8){        				
        				doActionIBSheet(sheetObjects[8], formObject, IBSAVE);
        			}
                    break;

//                case "btn_rowadd":
//                    doActionIBSheet(sheetObject,formObject,IBINSERT);
//                    break;
//    			case "btn_Loadexcel":
//    				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
//    				break;	 
//    			case "btn_Month_Copy":		//팝업창(Month Copy)
//	  	            var display = "0,1";
//	  	            ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0043", 250, 200, "AVG hire by Own VSL", display, true, false);
//	  	            break;	
	  	            
    			case "f_yrtype": // 조회영역 라디오버튼 클릭시 시트 헤더 히든처리 부분 관리
    				for(i=0;i<sheetObjects.length;i++){
    		   			if ( formObject.f_yrtype[0].checked ) {    		    		
    		   	   			sheetObjects[i].ColHidden("cost_yrmon") = false;
    		   	   			sheetObjects[i].ColHidden("cost_wk") = true;
    		   	   			ComBtnDisable("btn_Costmodification");
    		   	    	} else if ( formObject.f_yrtype[1].checked ) {    		    		
    		   	    		sheetObjects[i].ColHidden("cost_yrmon") = false;
    		   	    		sheetObjects[i].ColHidden("cost_wk") = false;    		   	    		    		   	    		
    		   	    		ComBtnEnable("btn_Costmodification");    		   	    		
    		   	    	}
    		        }    		    	
                    break;	
    			case "btn_Costmodification": // MAS 사선고정비 메뉴얼 비용 수정
    				if ( formObject.f_yrtype[1].checked ) {    					
    					f_yearweek = formObject.f_yearweek.value;
    					f_yearweek = f_yearweek.replace(/-/g,"");    					
    					
    					var param =  "f_yearweek="+f_yearweek
        	            + "&stnd_cost_cd="+formObject.tab_item.value;
    					
    					ComOpenPopup("ESM_MAS_0311.do?"+param, 900, 520, 'getMAS_ENS_311', '0,1,1,1,1,1', false);    					
		   	    	}    				
                    break; 
                    
    		     case "btn_Creation":    		    	 
    		    	if (tabItem == 0) {
                 		doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
         			} else if (tabItem == 1){        				
         				doActionIBSheet(sheetObjects[1], formObject, IBCREATE);
         			} else if (tabItem == 2){        				
         				doActionIBSheet(sheetObjects[2], formObject, IBCREATE);
         			} else if (tabItem == 3){        				
         				doActionIBSheet(sheetObjects[3], formObject, IBCREATE);
         			} else if (tabItem == 4){        				
         				doActionIBSheet(sheetObjects[4], formObject, IBCREATE);
         			} else if (tabItem == 5){        				
         				doActionIBSheet(sheetObjects[5], formObject, IBCREATE);
         			} else if (tabItem == 6){        				
         				doActionIBSheet(sheetObjects[6], formObject, IBCREATE);
         			} else if (tabItem == 7){        				
         				doActionIBSheet(sheetObjects[7], formObject, IBCREATE);
         			} else if (tabItem == 8){        				
         				doActionIBSheet(sheetObjects[8], formObject, IBCREATE);
         			}
    		        break;

    		     case "btn_Loadexcel":
    		    	 if (tabItem == 0) {
                  		doActionIBSheet(sheetObjects[0], formObject, IBLOADEXCEL);
          			} else if (tabItem == 1){        				
          				doActionIBSheet(sheetObjects[1], formObject, IBLOADEXCEL);
          			} else if (tabItem == 2){        				
          				doActionIBSheet(sheetObjects[2], formObject, IBLOADEXCEL);
          			} else if (tabItem == 3){        				
          				doActionIBSheet(sheetObjects[3], formObject, IBLOADEXCEL);
          			} else if (tabItem == 4){        				
          				doActionIBSheet(sheetObjects[4], formObject, IBLOADEXCEL);
          			} else if (tabItem == 5){        				
          				doActionIBSheet(sheetObjects[5], formObject, IBLOADEXCEL);
          			} else if (tabItem == 6){        				
          				doActionIBSheet(sheetObjects[6], formObject, IBLOADEXCEL);
          			} else if (tabItem == 7){        				
          				doActionIBSheet(sheetObjects[7], formObject, IBLOADEXCEL);
          			} else if (tabItem == 8){        				
          				doActionIBSheet(sheetObjects[8], formObject, IBLOADEXCEL);
          			}
     				break;
     				
    		     case "btn_Month_Copy":		//팝업창(Month Copy)
       	            var display = "0,1";
       	            ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0043", 250, 200, "AVG Hire by Own-VSL", display, true, false);
       	            break;	
       	            
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111","",""));
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013','25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */
    function setYrWk(fYear, prevWeek){
        var formObj = document.form;
        with(formObj){
            var nowYear = fYear;
            f_yearweek.value = nowYear+prevWeek;
            //isValidYYYYWW(f_yearweek,true,'-',true);
            if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            f_yearweek.select();
            // 기간 표시
            setPeriod(f_yearweek);
        }
        fnYearWeekSet(document.getElementById("f_yearweek"));
    }

    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */
    function setYrMon(){
        var formObj = document.form;        
        with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm");
            if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
            var nowYrMon = nowYear + nowMon;
            f_yearweek.value = nowYrMon;
            //isValidYYYYMM(f_yearweek,true,'-',true);
            if(!ComAddSeparator(f_yearweek)) return false;
            f_yearweek.select();            
            // 기간 표시
            setPeriod(f_yearweek);            
        }
        fnYearWeekSet(document.getElementById("f_yearweek"));
        
    }

    function fnYearWeekSet(obj){
        if ( document.form.f_yrtype[0].checked ) {
            obj.value = ComGetMaskedValue(obj.value,"ym");
        } else {
            obj.value = ComGetMaskedValue(obj.value,"yw");
        }
        setPeriod(obj);
    }

    function ComAddSeparator_Local(obj, sFormat) {
        try {
            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
		var formObj = document.form;
		if ( formObj.f_yrtype[0].checked ) {
			//sheetObjects[0].ColHidden("cost_wk") = true;
		}
		ComMasSetPeriod2(obj);
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
	function loadPage(header, headerNM) {		
		loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}

		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}		
		loadingMode = false;	
		
		ComBtnDisable("btn_Costmodification");
	}

	/**
	 * 멀티콤보 항목을 설정한다.
	 */
 	function initCombo(comboObj, comboId) {
 		with (comboObj) {
 			DropHeight = 300;
 			Index = 0;
 			MaxLength = 4;
 			ValidChar(2,1);
 			
 			switch(comboObj.id) {			
				case "select1":
					DropHeight = 300;
					ValidChar(2, 1);	//영문대문자+숫자
					MaxLength = 4;
					Index = 0;
					break;
	
				case "f_dur":
					for(var i=1; i<=12; i++)
						InsertItem(i-1,  i, i);
					DropHeight = 300;
					MaxLength = 2;
					Index = 2;
					break;				
			} 			
 		}
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
   	 * IBTab Object를 배열로 등록
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   	 * 배열은 소스 상단에 정의
   	 */
   	function setTabObject(tab_obj) {
   		tabObjects[tabCnt++] = tab_obj;

   	}
	
	/**
   	 * Tab 기본 설정
   	 * 탭의 항목을 설정한다.
   	 */
   	function initTab(tabObj, tabNo) {
   		switch (tabNo) {
   		case 1:
   			with (tabObj) {
   	            var cnt  = 0 ;
   	            InsertTab( cnt++ , "Crew Expense" , -1 );
   	            InsertTab( cnt++ , "Insurance" , -1 );
   	            InsertTab( cnt++ , "Store supply Exp" , -1 );
   	            InsertTab( cnt++ , "Lubricant Exp" , -1 );
   	            InsertTab( cnt++ , "Vessel M&R" , -1 );
   	            InsertTab( cnt++ , "Depreciations" , -1 );
   	            InsertTab( cnt++ , "Telecom Exp" , -1 );
   	            InsertTab( cnt++ , "Other Operation Exp" , -1 );
   	            InsertTab( cnt++ , "Vessel Interest" , -1 );
   	            InsertTab( cnt++ , "Total" , -1 );
   			}
   			break;

   		}
   	}
   	
   	/**
   	 * Tab 변경시 이벤트 관련
   	 * 선택한 탭의 정보를 조회.
   	 */
   	function tab1_OnChange(tabObj, nItem) {
   		var objs = document.all.item("tabLayer");

   		objs[nItem].style.display = "Inline";
   		objs[beforetab].style.display = "none";

   		tabItem = nItem;

   		document.form.tab_item.value = tabItem;
   		
   		var formObject = document.form;
   		
   		formObject.f_yrtype[1].disabled = false;
   		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Creation");
		ComBtnEnable("btn_Loadexcel");
   		if (tabItem == 0) {
			formObject.tab_item.value = "54100000";
		} else if (tabItem == 1){        				
			formObject.tab_item.value = "54250000";
		} else if (tabItem == 2){        				
			formObject.tab_item.value = "54200000";
		} else if (tabItem == 3){        				
			formObject.tab_item.value = "54300000";
		} else if (tabItem == 4){        				
			formObject.tab_item.value = "54150000";
		} else if (tabItem == 5){        				
			formObject.tab_item.value = "54450000";
		} else if (tabItem == 6){        				
			formObject.tab_item.value = "54180000";
		} else if (tabItem == 7){        				
			formObject.tab_item.value = "54550000";
		} else if (tabItem == 8){        				
			formObject.tab_item.value = "72100000";
		} else if (tabItem == 9){
			formObject.f_yrtype[1].disabled = true;
			if (formObject.f_yrtype[1].checked) {
				formObject.f_yrtype[0].checked = true;
				setYrMon();
			}
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Creation");
			ComBtnDisable("btn_Loadexcel");
			formObject.tab_item.value = "";
		}
   			

   		// --------------- 요기가 중요 --------------------------//
   		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
   		// ------------------------------------------------------//
   		beforetab = nItem;  
   		
   		for(i=0;i<sheetObjects.length;i++){
   			if ( formObject.f_yrtype[0].checked ) {    		    		
   	   			sheetObjects[i].ColHidden("cost_yrmon") = false;
   	   			sheetObjects[i].ColHidden("cost_wk") = true;
   	    	} else if ( formObject.f_yrtype[1].checked ) {    		    		
   	    		sheetObjects[i].ColHidden("cost_yrmon") = false;
   	    		sheetObjects[i].ColHidden("cost_wk") = false;
   	    	}
        }
   		
   	    //if(loadPageCnt == 0) return;   	    
   	    //document.getElementById("btn_Retrieve").fireEvent("onclick");
   	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo, header, headerNM) {
        var cnt = 0;
        var aryCD = "";
        var aryNo = "";
        var colNo = 0;

        aryCD = header.split("|");
        aryNo = aryCD.length;

        switch(sheetNo) {
            case 1:      //sheet1 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 2:      //sheet2 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 3:      //sheet3 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 4:      //sheet4 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 5:      //sheet5 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 6:      //sheet6 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 7:      //sheet7 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 8:      //sheet8 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;

            case 9:      //sheet9 init
            	colNo = 15;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "STS|YYYY-MM|Week|VSL Code|VSL Class|Cost Period|VSL Cost|Common Cost|TTL Cost|H/B|Add H/B|Final H/B|Remark||";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var tot = "";
                    for(j=0; j<aryNo; j++){
                         tot += "|t"+aryCD[j]+"|";
                         if(j != aryNo-1)tot += "+";
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,   30,     daCenter,  false,   "ibflag");										//STS
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  true);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     40,     daCenter,  false,   "cost_wk",      	false,    "",   dfNone,       0,  false,  true); //Week
                    InitDataProperty(0, cnt++,  dtData,     60,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  true); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     60,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  true); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daCenter,  false,   "eff_fm_to_yrmon",	false,    "",   dfNone,  	  0,  false,  true); //Cost Perid
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "vsl_amt",			false,    "",   dfFloatOrg,   2,  true,   true); //VSL Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "com_dtrb_amt",		false,    "",   dfFloatOrg,   2,  true,   true); //Common Cost
                    InitDataProperty(0, cnt++,  dtData,     140,    daRight,   false,   "ttl_cost",			false,    "",   dfFloatOrg,   2,  false,  true); //TTL Cost
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "hb_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //H/B
                    InitDataProperty(0, cnt++,  dtData,     70,     daRight,   false,   "addhb_cost",		false,    "",   dfFloatOrg,   2,  true,   true); //Add H/B
                    InitDataProperty(0, cnt++,  dtData,     120,    daRight,   false,   "fin_cost",			false,    "",   dfFloatOrg,   2,  true,   true); //Final H/B
                    InitDataProperty(0, cnt++,  dtData,     90,     daRight,   false,   "own_vsl_rmk",		false,    "",   dfNone,       0,  true,   true); //Remark                    
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "eff_fm_yrmon",		false,    "",   dfNone,  	  0,  false,  false); //Target Source 비용 취합 기준 Year Month
                    InitDataProperty(0, cnt++,  dtHidden,   90,     daRight,   false,   "stnd_cost_cd",     false,    "",   dfNone,  	  0,  false,  false); //Cost Code 
//                    for(j=0; j<aryNo; j++) {
//                        InitDataProperty(0,cnt++,dtAutoSum,130,daRight,false,"t"+aryCD[j],   false,      "",         dfNullInteger,  0,      true,       true);
//                    }
//
//                    InitDataProperty(0, cnt++,  dtAutoSum,  60,     daRight,        false,      "",             false,      tot,        dfNullInteger,  0,      false,      true);
//                    InitDataProperty(0, cnt++,  dtData,     50,     daLeft,         false,      "own_vsl_rmk",  false,      "",         dfEngKey,           0,      true,       true);
//                    InitDataValid(0, "cost_wk", vtNumericOnly);
//                    InitDataValid(0, "vsl_cd", vtEngUpOnly);
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;
                
            case 10:      //sheet10 init
            	colNo = 13;  // colNo = aryNo + 7;
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;                                  //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);      //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                                           //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                                     //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);                                          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colNo, 0, 0, true);                                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "YYYY-MM|VSL Code|VSL Class|Total|Crew Expense|Insurance|Store supply Exp|Lubricant Exp|Vessel M&R|Depreciations|Telecom Exp|Other Operation Exp|Vessel Interest";
                    InitHeadRow(0, HeadTitle, true);                                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtData,     80,     daCenter,  false,   "cost_yrmon",       false,    "",   dfNone,       0,  false,  false);	//YYYY-MM	
                    InitDataProperty(0, cnt++,  dtData,     80,     daCenter,  false,   "vsl_cd",       	false,    "",   dfNone,       0,  false,  false); //VSL Code
                    InitDataProperty(0, cnt++,  dtData,     80,     daRight,   false,   "vsl_clss_capa",	false,    "",   dfInteger,    0,  false,  false); //VSL Class
                    InitDataProperty(0, cnt++,  dtData,     110,    daRight,  false,   "ttl_amt",	false,    "",   dfFloatOrg,  	  2,  false,  false); //Total
                    InitDataProperty(0, cnt++,  dtData,     110,     daRight,   false,   "cre_amt",			false,    "",   dfFloatOrg,   2,  false,   false); //Crew Expense
                    InitDataProperty(0, cnt++,  dtData,     110,    daRight,   false,   "ins_amt",		false,    "",   dfFloatOrg,   2,  false,   false); //Insurance
                    InitDataProperty(0, cnt++,  dtData,     110,    daRight,   false,   "sto_amt",			false,    "",   dfFloatOrg,   2,  false,  false); //Store supply Exp
                    InitDataProperty(0, cnt++,  dtData,     110,    daRight,   false,   "lub_amt",			false,    "",   dfFloatOrg,   2,  false,   false); //Lubricant Exp
                    InitDataProperty(0, cnt++,  dtData,     110,     daRight,   false,   "mnr_amt",		false,    "",   dfFloatOrg,   2,  false,   false); //Vessel M&R
                    InitDataProperty(0, cnt++,  dtData,     110,    daRight,   false,   "dep_amt",			false,    "",   dfFloatOrg,   2,  false,   false); //Depreciations
                    InitDataProperty(0, cnt++,  dtData,     110,     daRight,   false,   "tel_amt",		false,    "",   dfFloatOrg,       2,  false,   false); //Telecom Exp
                    InitDataProperty(0, cnt++,  dtData,	   140,     daRight,   false,   "otr_amt",		false,    "",   dfFloatOrg,  	  2,  false,  false); //Other Operation Exp
                    InitDataProperty(0, cnt++,  dtData,     110,     daRight,   false,   "vsl_amt",     false,    "",   dfFloatOrg,  	  2,  false,  false); //Vessel Interest
                    CountPosition  = 0 ;
                    sheetObj.style.height = 390; // style.height = GetSheetHeight(20) ;
                }
                break;
                
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
     *
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
//        sheetObj.SumText(0,0) = "";
//        sheetObj.SumText(0,1) = "TOTAL";
//
//        // YYYY-MM 선택시 WEEK정보가 보이지 않도록 변경 2010.03.11
//        var formObj = document.form;
//        if ( formObj.f_yrtype[0].checked ) {
//            sheetObjects[0].ColHidden("cost_wk") = true;
//            sheetObjects[1].ColHidden("week") = true;
//        }else if ( formObj.f_yrtype[1].checked ) {
//        	sheetObjects[0].ColHidden("cost_wk") = false;
//        	sheetObjects[1].ColHidden("week") = true;
//        }
    }

    /**
     *
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,2) = "Average";
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //var sheetObj2 = sheetObjects[1];
        sheetObj.ShowDebugMsg = false;
                
        switch(sAction) {
	        case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0043GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					for (i=0;i<sheetObjects.length;i++) {
						ComConfigSheet(sheetObjects[i]);
						initSheet(sheetObjects[i],i+1, ComGetEtcData(arrXml[0],"headerCD"), ComGetEtcData(arrXml[0],"headerNM"));
						ComEndConfigSheet(sheetObjects[i]);
					}
					//ComSetObjValue(formObj.f_header, ComGetEtcData(arrXml[0],"headerCD"));
					ComXml2ComboItem(arrXml[0], formObj.f_selvessel, "code", "name");
					formObj.f_yrtype[1].onclick = function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"), ComGetEtcData(arrXml[0],"prevWeek"))};
				}
		
		        setYrMon();  // 월/주 입력 창에 금월 셋팅
		        ComSetObjValue(formObj.f_syearmonth, ComGetDateAdd(null, "M", -2).substr(0,7)); //  Start Month		
				
		        ComOpenWait(false);
				break;	

            case IBSEARCH:      //조회
                ComAddSeparator_Local(formObj.f_yearweek, "-");
                if(validateForm(sheetObj,formObj,sAction)){
                	// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCHLIST01;                    
                    //addDash(formObj.f_yearweek,4);

                    /*if ( formObj.f_yrtype[0].checked ) {
                        formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"ym");
                    } else {
                        formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"yw");
                    }*/

//                    var xmlEtc = sheetObj.GetSearchXml("ESM_MAS_0043GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
//                    sheetObj.LoadSearchXml(xmlEtc);
                    //alert(masFormQueryString(formObj));
                    sheetObj.DoSearch("ESM_MAS_0043GS.do", masFormQueryString(formObj));

                    /*var xml1 = sheetObj.EtcData("xml1");
                    var xml2 = sheetObj.EtcData("xml2");
                    sheetObj.RemoveEtcData();

                    sheetObj.LoadSearchXml(xml1);
                    sheetObj2.LoadSearchXml(xml2);*/
                    ComOpenWait(false);
                }
                break;


            case IBSAVE: //저장          
            	formObj.f_yearweek.value = formObj.f_yearweek.value.replace("-","");
            	
                if(validateForm(sheetObj,formObj,sAction)){
                	sheetObj.Redraw = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = MULTI01;                    
                    sheetObj.DoSave("ESM_MAS_0043GS.do", FormQueryString(formObj), -1, true);
                    doActionIBSheet(sheetObj,formObj,IBSEARCH); // 저장 후 재조회
                    ComOpenWait(false);
                    sheetObj.Redraw = true;
                }
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
            	var sheetObj = "";            	
            	if (tabItem == 0) {
            		sheetObj = sheetObjects[0];
    			} else if (tabItem == 1){
    				sheetObj = sheetObjects[1];
    			} else if (tabItem == 2){
    				sheetObj = sheetObjects[2];
    			} else if (tabItem == 3){
    				sheetObj = sheetObjects[3];
    			} else if (tabItem == 4){
    				sheetObj = sheetObjects[4];
    			} else if (tabItem == 5){
    				sheetObj = sheetObjects[5];
    			} else if (tabItem == 6){
    				sheetObj = sheetObjects[6];
    			} else if (tabItem == 7){
    				sheetObj = sheetObjects[7];
    			} else if (tabItem == 8){
    				sheetObj = sheetObjects[8];
    			} else if (tabItem == 9){
    				sheetObj = sheetObjects[9];
    			}
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;
				
           case IBINSERT:
                sheetObj.DataInsert();
                sheetObj.InitCellProperty(sheetObj.LastRow, "vsl_cd", dtCheckBox, daCenter, "vsl_cd", "");
                break;
               
           case IBLOADEXCEL:   // 엑셀로드
        	    var sheetObj = "";           	
	           	if (tabItem == 0) {
	           		sheetObj = sheetObjects[0];
	   			} else if (tabItem == 1){
	   				sheetObj = sheetObjects[1];
	   			} else if (tabItem == 2){
	   				sheetObj = sheetObjects[2];
	   			} else if (tabItem == 3){
	   				sheetObj = sheetObjects[3];
	   			} else if (tabItem == 4){
	   				sheetObj = sheetObjects[4];
	   			} else if (tabItem == 5){
	   				sheetObj = sheetObjects[5];
	   			} else if (tabItem == 6){
	   				sheetObj = sheetObjects[6];
	   			} else if (tabItem == 7){
	   				sheetObj = sheetObjects[7];
	   			} else if (tabItem == 8){
	   				sheetObj = sheetObjects[8];
	   			}
				ComAddSeparator_Local(formObj.f_yearweek, "-");
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.RemoveAll()
					//  sheetObj2.RemoveAll()
					sheetObj.LoadExcel(-1, 1, "", -1, -1, "",false);
                 
	  				//Data Load이후에 Sheet내에 YYYY-MM의 값을 조회 조건의 연월 값으로 다시 Setting한다  				
	                for (var i=1;i<=sheetObj.rowcount;i++){
	              	   sheetObj.CellValue(i,1) = formObj.f_yearweek.value;
	                }
	                //YYYY-MM,VSL CODE,VSL CLASS값에 중복이 있는지 조회한다.
				}				
				break;
				
           case IBCREATE:
        	   	ComAddSeparator_Local(formObj.f_yearweek, "-");
        	   	ComAddSeparator_Local(formObj.f_syearmonth, "-");
        	   	
	           	if(!validateForm(sheetObj,formObj,sAction)) {
	               	return false;
	            }	
	           	if(flagPopCreation == "Y"){	           		
	           		
	           	} else if(flagPopCreation == "") {
	           		if (!ComShowCodeConfirm("MAS10020")) {
		           		return false;
		           	}
	           	} else {
	           		if (!ComShowCodeConfirm("MAS10020")) {
		           		return false;
		           	}
	           	}	           	           	
                ComOpenWait(true);
                sheetObj.Redraw = false;                
                formObj.f_cmd.value = COMMAND01;                
                //alert(FormQueryString(formObj));                
                sheetObj.DoSearch("ESM_MAS_0043GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                                 
                sheetObj.Redraw = true;  
                flagPopCreation = "";
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(f_yearweek.value == "") {
                if(f_yrtype[0].checked){
                    // [COM12114] : YYYY-MM 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : YYYY-WW 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }
            }
            
            if(f_yearweek.value.replace("-","").length != 6) {            
                if(f_yrtype[0].checked){
                    // [COM12114] : YYYY-MM 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : YYYY-WW 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }
            }
            //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
            if(f_yrtype[0].checked == true){
               //if(!isValidYYYYMM(f_yearweek, false, '-', false)) return false;
               //if(ComIsDate(f_yearweek)) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "ym")) return false;
            }else{
               //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
              //if(ComIsDate(f_yearweek, "yw")) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            }
//            
            /*if (sAction == IBLOADEXCEL ){
            	if(!f_yrtype[0].checked){ // Month option에서만 LoadExcel할 수 있다.
            		ComShowMessage(ComGetMsg("MAS10003","Load Excel","YYYY-MM"));
            		return false;            		
            	}
            }*/
        }

        return true;
    }
    
    function sheet1_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[0].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[0].CellValue(row,"com_dtrb_amt");
	        sheetObjects[0].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[0].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[0].CellValue(row,"addhb_cost");
	        sheetObjects[0].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet2_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[1].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[1].CellValue(row,"com_dtrb_amt");
	        sheetObjects[1].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[1].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[1].CellValue(row,"addhb_cost");
	        sheetObjects[1].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet3_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[2].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[2].CellValue(row,"com_dtrb_amt");
	        sheetObjects[2].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[2].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[2].CellValue(row,"addhb_cost");
	        sheetObjects[2].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet4_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[3].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[3].CellValue(row,"com_dtrb_amt");
	        sheetObjects[3].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[3].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[3].CellValue(row,"addhb_cost");
	        sheetObjects[3].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet5_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[4].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[4].CellValue(row,"com_dtrb_amt");
	        sheetObjects[4].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
	    }
		if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[4].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[4].CellValue(row,"addhb_cost");
	        sheetObjects[4].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet6_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	        var vsl_amt = sheetObjects[5].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[5].CellValue(row,"com_dtrb_amt");
	        sheetObjects[5].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[5].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[5].CellValue(row,"addhb_cost");
	        sheetObjects[5].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet7_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[6].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[6].CellValue(row,"com_dtrb_amt");
	        sheetObjects[6].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[6].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[6].CellValue(row,"addhb_cost");
	        sheetObjects[6].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet8_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[7].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[7].CellValue(row,"com_dtrb_amt");
	        sheetObjects[7].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	}
    	if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[7].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[7].CellValue(row,"addhb_cost");
	        sheetObjects[7].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    function sheet9_OnChange(sheetObj, row, col, value){
    	if( col == 6 || col == 7 ) {
	    	var vsl_amt = sheetObjects[8].CellValue(row,"vsl_amt");
	        var com_dtrb_amt = sheetObjects[8].CellValue(row,"com_dtrb_amt");
	        sheetObjects[8].CellValue2(row,"ttl_cost") = parseFloat(vsl_amt) + parseFloat(com_dtrb_amt);
    	 }
		if( col == 9 || col == 10 ) {
	        var hb_cost = sheetObjects[8].CellValue(row,"hb_cost");
	        var addhb_cost = sheetObjects[8].CellValue(row,"addhb_cost");
	        sheetObjects[8].CellValue2(row,"fin_cost") = parseFloat(hb_cost) + parseFloat(addhb_cost);
    	}
    }
    
		
    function getMAS_ENS_311(flagCrSv) {
    	if(flagCrSv == "Y"){
    		var formObject = document.form;
    		flagPopCreation = "Y";
            if (tabItem == 0) {
         		doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
    		} else if (tabItem == 1){        				
    			doActionIBSheet(sheetObjects[1], formObject, IBCREATE);
    		} else if (tabItem == 2){        				
    			doActionIBSheet(sheetObjects[2], formObject, IBCREATE);
    		} else if (tabItem == 3){        				
    			doActionIBSheet(sheetObjects[3], formObject, IBCREATE);
    		} else if (tabItem == 4){        				
    			doActionIBSheet(sheetObjects[4], formObject, IBCREATE);
    		} else if (tabItem == 5){        				
    			doActionIBSheet(sheetObjects[5], formObject, IBCREATE);
    		} else if (tabItem == 6){        				
    			doActionIBSheet(sheetObjects[6], formObject, IBCREATE);
    		} else if (tabItem == 7){        				
    			doActionIBSheet(sheetObjects[7], formObject, IBCREATE);
    		} else if (tabItem == 8){        				
    			doActionIBSheet(sheetObjects[8], formObject, IBCREATE);
    		}
    	} else {
    		
    	}   	
    	flagPopCreation = "";
	}
    
    