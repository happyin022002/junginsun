/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0495.js
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.02 최영희
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.09.14 변종건 [CHM-201005873-01]	 T/S List by 1st VSL & 2nd VSL 엑셀 다운 폼 수정 요청 (Location Full Name 추가)
* 2011.09.30 전성진 []	Summary Open 조건 추가 - VVD 없을 경우 안열리게 함(튜닝)
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
     * @class esm_bkg_0495 : esm_bkg_0495 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0495() {
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

var comboObjects = new Array();
var comboCnt = 0;

var sheetObjects = new Array();
var rdObjects = new Array();
var rdCnt = 0;
var sheetCnt = 0;
var prefix1="t1sheet1_";
var prefix2="t2sheet1_";
var prefix3="t3sheet1_";
var iterator = "|$$|";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
 
          var rdObject = rdObjects[0];
         /*******************************************************/
         var formObject = document.form;
         var param="";
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
				
            	case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						if ( beforetab == 0 ) {	  //첫번째탭에서 조회
							sheetObjects[1].RemoveAll();
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
						} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
							 sheetObjects[0].RemoveAll();
							doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
						}   
					}
                	break;

            	case "btn_New":
					initForm();
				    ComClearObject(formObject.vps_etd_dt);
					ComClearObject(formObject.dur_from);
					ComClearObject(formObject.dur_to);
                	break; 

            	case "btn_DownExcel":
					if ( beforetab == 0 ) {	  //첫번째탭에서 조회
						doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
					}  
                	break;
                                     
            	case "btn_Print":
					if ( (beforetab == 0 && sheetObjects[0].Rows ==0)||(beforetab == 1 && sheetObjects[1].Rows ==0) ) {	  //첫번째탭에서 조회
						ComShowCodeMessage("BKG00155");
					}else{   
						if ( beforetab == 0 ) {	  
							if (CheckGrid(sheetObjects[0],prefix1)){ 
								param=RdParam(sheetObjects[0],prefix1);
								rdOpen(rdObjects[0], document.form,param );
							} 
						}else if ( beforetab == 1 ) {
							if (CheckGrid(sheetObjects[1],prefix2)){
								param = RdParam(sheetObjects[1],prefix2);
								rdOpen(rdObjects[0], document.form,param);
							}
						}
					}
                	break; 
                 
            	case "btn_Fax":
					if (ComIsEmpty(formObject.faxmail)){
						return false;
					}
					if (ComIsEmailAddr(formObject.faxmail)||!ComIsContainsCharsOnly(formObject.faxmail,"1234567890-")){
						ComSetFocus(formObject.faxmail);
						ComShowCodeMessage("BKG00246");
						return false;
					}
					if ( (beforetab == 0 && sheetObjects[0].Rows ==0)||(beforetab == 1 && sheetObjects[1].Rows ==0) ) {	  //첫번째탭에서 조회
						ComShowCodeMessage("BKG00155");
					}else{  
						if ( beforetab == 0 ) {	   
							if (CheckGrid(sheetObjects[0],prefix1)){
								 formObject.arrblno.value=CheckBlNo(sheetObjects[0],prefix1); 
								 formObject.param.value= RdParam(sheetObjects[0],prefix1);
								 var iCheckRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
								var arrRow = iCheckRow.split("|");
                                 formObject.rdtitle.value = sheetObjects[0].CellValue(arrRow[0],prefix1+"vs_nm")+" T/S Loading List"; 
								 doActionIBSheet(sheetObjects[0],formObject,COMMAND02);
							}
						} else if ( beforetab == 1 ) {
							 if (CheckGrid(sheetObjects[1],prefix2)){
								 formObject.arrblno.value=CheckBlNo(sheetObjects[1],prefix2);
								 formObject.param.value= RdParam(sheetObjects[1],prefix2);
								 var iCheckRow = sheetObjects[1].FindCheckedRow(prefix2+"chk");
								 var arrRow = iCheckRow.split("|");
                                 formObject.rdtitle.value = sheetObjects[1].CellValue(arrRow[0],prefix2+"vs_nm")+" T/S Loading List"; 
								 doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
							 }
						} 
					}
					
					break;

            	case "btn_EMail": 
					if (ComIsEmpty(formObject.faxmail)){
						return false;
					}
					if (!ComIsEmailAddr(formObject.faxmail)){
						ComSetFocus(formObject.faxmail);
						ComShowCodeMessage("BKG00245");
						return false;
					}
					if ( (beforetab == 0 && sheetObjects[0].Rows ==0)||(beforetab == 1 && sheetObjects[1].Rows ==0) ) {	  //첫번째탭에서 조회
						ComShowCodeMessage("BKG00155");
					}else{ 
						if ( beforetab == 0 ) {
							if (CheckGrid(sheetObjects[0],prefix1)){
								formObject.arrblno.value=CheckBlNo(sheetObjects[0],prefix1); 
								formObject.param.value= RdParam(sheetObjects[0],prefix1);
								var iCheckRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
								var arrRow = iCheckRow.split("|");
                                //formObject.rdtitle.value = sheetObjects[0].CellValue(arrRow[0],prefix1+"vs_nm")+"T/S Loading List"; 
								doActionIBSheet(sheetObjects[0],formObject,COMMAND03);
							}
						} else if ( beforetab == 1 ) {
							if (CheckGrid(sheetObjects[1],prefix2)){
								formObject.arrblno.value=CheckBlNo(sheetObjects[1],prefix2);
								formObject.param.value= RdParam(sheetObjects[1],prefix2);
								var iCheckRow = sheetObjects[1].FindCheckedRow(prefix2+"chk");
								var arrRow = iCheckRow.split("|");
                                //formObject.rdtitle.value = sheetObjects[1].CellValue(arrRow[0],prefix2+"vs_nm")+"T/S Loading List"; 
								doActionIBSheet(sheetObjects[1],formObject,COMMAND03);
							}
						} 
					}
					
					break;
								
				case "btn_CheckAll":
					ComSetDisplay("btn_CheckAll",false);
					ComSetDisplay("btn_UnCheckAll",true);
					if ( beforetab == 0 ) {	  //첫번째탭에서 조회					     
						CellCheckAll(sheetObjects[0],true,prefix1+"chk");
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						CellCheckAll(sheetObjects[1],true,prefix2+"chk");
					}  
					break;  
				case "btn_UnCheckAll":
					ComSetDisplay("btn_CheckAll",true);
					ComSetDisplay("btn_UnCheckAll",false);
					if ( beforetab == 0 ) {	  //첫번째탭에서 조회
						CellCheckAll(sheetObjects[0],false,prefix1+"chk"); 
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회. 
						CellCheckAll(sheetObjects[1],false,prefix2+"chk");
					}  
					break;  
				case "btn_calendar":
				    var cal = new ComCalendar();
					cal.select(formObject.vps_etd_dt, 'yyyy-MM-dd');
				    break;
				
				case "btn_Ts_Summary": 
					var param="?loc_cd="+formObject.loc_cd.value+"&loc_yd_cd="+formObject.loc_yd_cd.value;
				    param+="&search_kind_cd="+ComGetObjValue(formObject.search_kind_cd)+"&disc_load_cd="+ComGetObjValue(formObject.disc_load_cd); 
					param+="&vps_etd_dt="+ComGetObjValue(formObject.vps_etd_dt)+"&vvd="+ComGetObjValue(formObject.vvd);
					param+="&pol_cd="+ComGetObjValue(formObject.pol_cd)+"&pod_cd="+ComGetObjValue(formObject.pod_cd);
					param+="&dur_from="+ComGetObjValue(formObject.dur_from)+"&dur_to="+ComGetObjValue(formObject.dur_to);
					param+="&op_cd="+ComGetObjValue(formObject.op_cd)+"&special="+ComGetObjValue(formObject.special);
					param+="&pgmNo=ESM_BKG_0925";					
					if(ComIsEmpty(formObject.loc_cd)){
						ComShowCodeMessage("BKG00757"); 
					}else if (((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComIsEmpty(formObject.vps_etd_dt))
						|| (ComGetObjValue(formObject.search_kind_cd)=="D" && (ComIsEmpty(formObject.dur_from)||ComIsEmpty(formObject.dur_to)))
						|| !formObject.search_kind_cd[0].checked && !formObject.search_kind_cd[1].checked && !formObject.search_kind_cd[2].checked){
						ComShowCodeMessage("BKG00758");
					}else if(ComGetObjText(formObject.vvdList) =="" ) {
						ComSetFocus(formObject.vvdList);
						ComShowCodeMessage("BKG00104","VVD"); 
            		}else{
						ComOpenWindowCenter("/hanjin/ESM_BKG_0925.do"+param, "myWin", 600,420, true);
					}
					break;
				
				case "btn_Duration":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.dur_from, formObject.dur_to,'yyyy-MM-dd');
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     */
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
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

				//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		
		initRdConfig(rdObjects[0]);
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		 for(var j=0; j<comboObjects.length; j++){
			initCombo(comboObjects[j]);
		}   
        
		 axon_event.addListenerFormat('keypress','bkg0495_keypress',document.form);   
		 axon_event.addListenerForm('Click', 'bkg0495_Click', document.form);
		 axon_event.addListenerForm('blur', 'bkg0495_blur', document.form);
		 axon_event.addListenerForm('beforedeactivate', 'bkg0495_obj_deactivate',  document.form); //- 포커스 나갈때
	     axon_event.addListenerFormat('beforeactivate',   'bkg0495_obj_activate',    document.form); //- 포커스 들어갈때
		 initForm();
		 
		 //doActionIBSheet(sheetObjects[0],document.form,COMMAND05);
		 
    }

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function t1sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,COMMAND05);   
		sheetObj.WaitImageVisible = true;   
	}    

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 350;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);


                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(false, false, false, true, false,false)

                    var HeadTitle = "|CHK|RMK|OOP|LANE|First VSL|ETB|LANE|ETD|Terminal|Next VSL|B/L No.|Container No.|TP|Seal No.|Origin Yard|POL|POD|POD|DEL|Weight|BS|Special|Auth Result|Load|Commodity|1|2|3|4|5|6|Cntr. Vol|20FT|40FT|POL|POD|DEL";

                    var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,	true,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix1+"chk",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix1+"rmk",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix1+"op_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			35,		daCenter,	false,		prefix1+"firstlane",		false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix1+"firstvvd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,	false,		prefix1+"firstetb",			false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,			35,		daCenter,	false,		prefix1+"nextlane",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,	false,		prefix1+"nextetd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,	false,		prefix1+"terminal",			false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix1+"nextvvd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		false,		prefix1+"bl_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		false,		prefix1+"cntr_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		prefix1+"cntr_tpsz_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				95,		daCenter,	false,		prefix1+"cntr_seal_No",		false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		prefix1+"org_yd_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	false,		prefix1+"pol_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				65,		daCenter,	false,		prefix1+"pod_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				25,		daCenter,	false,		prefix1+"pod_nod_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	false,		prefix1+"del_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	false,		prefix1+"wgt",				false,		"",	dfNumber,	0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daRight,	false,		prefix1+"bs_cd",			false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				130,	daCenter,	false,		prefix1+"special",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	false,		prefix1+"auth",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	false,		prefix1+"stwg_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daLeft,		false,		prefix1+"cmdt_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"ts_rmk",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"bkg_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"vs_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"tot_20",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"tot_40",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"tot_wgt",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daRight,	false,		prefix1+"cntr_vol",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"teu",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix1+"feu",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		prefix1+"pol_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		prefix1+"pod_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		prefix1+"del_nm",			false,		"",	dfNone,		0,		false,		true);
					
					 
					
					ShowButtonImage = 2;
						
               }
                break;

				case 2:      //t2sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 350;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false)

                    var HeadTitle = "|CHK|RMK|OOP|LANE|First VSL|ETB|LANE|ETD|Terminal|Next VSL|B/L No.|Container No.|TP|Seal No.|Origin Yard|POL|POD|POD|DEL|Weight|BS|Special|Auth Result|Load|Commodity|1|2|3|4|5|6|Cntr. Vol|20FT|40FT|POL|POD|DEL";
										
										var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,	true,		prefix2+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix2+"chk",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix2+"rmk",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix2+"op_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			35,		daCenter,	false,		prefix2+"firstlane",			false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix2+"firstvvd",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,	false,		prefix2+"firstetb",				false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,			35,		daCenter,	false,		prefix2+"nextlane",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,	false,		prefix2+"nextetd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,	false,		prefix2+"terminal",			false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix2+"nextvvd",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		false,		prefix2+"bl_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		false,		prefix2+"cntr_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		prefix2+"cntr_tpsz_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				95,		daCenter,	false,		prefix2+"cntr_seal_No",		false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		prefix2+"org_yd_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	false,		prefix2+"pol_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				65,		daCenter,	false,		prefix2+"pod_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				25,		daCenter,	false,		prefix2+"pod_nod_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	false,		prefix2+"del_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	false,		prefix2+"wgt",				false,		"",	dfNumber,	0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,		daRight,	false,		prefix2+"bs_cd",				false,		"",	dfNone,	0,		false,		true);

					InitDataProperty(0, cnt++ , dtData,				130,	daRight,	false,		prefix2+"special",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	false,		prefix2+"auth",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	false,		prefix2+"stwg_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daLeft,		false,		prefix2+"cmdt_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"ts_rmk",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"bkg_no",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"vs_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"tot_20",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"tot_40",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"tot_wgt",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daRight,	false,		prefix2+"cntr_vol",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"teu",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix2+"feu",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		prefix2+"pol_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		prefix2+"pod_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			90,		daCenter,	false,		prefix2+"del_nm",			false,		"",	dfNone,		0,		false,		true);
					
					 
					
					ShowButtonImage = 2;
						
               }
                break;
                
				case 3:      //t3sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 350;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false)

                    var HeadTitle = "|CHK|RMK|OOP|LANE|First VSL|ETB|LANE|ETD|Terminal|Next VSL|B/L No.|Container No.|TP|Seal No.|Origin Yard|POL|POD|POD|DEL|Weight|BS|Special|Auth Result|Load|Commodity|1|2|3|4|5|6|Cntr. Vol|20FT|40FT|POL|POD|DEL";
										
					var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	    40,		daCenter,	true,		prefix3+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix3+"chk",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix3+"rmk",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix3+"op_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix3+"firstlane",		false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix3+"firstvvd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix3+"firstetb",			false,		"",	dfNone,		0,		false,		true);
				
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		prefix3+"nextlane",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix3+"nextetd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix3+"terminal",			false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	false,		prefix3+"nextvvd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		false,		prefix3+"bl_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,		false,		prefix3+"cntr_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	false,		prefix3+"cntr_tpsz_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				95,		daCenter,	false,		prefix3+"cntr_seal_No",		false,		"",	dfNone,		0,		false,		true);
					
					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,		prefix3+"org_yd_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	false,		prefix3+"pol_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				65,		daCenter,	false,		prefix3+"pod_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				25,		daCenter,	false,		prefix3+"pod_nod_cd",		false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	false,		prefix3+"del_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	false,		prefix3+"wgt",				false,		"",	dfNumber,	0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,		daRight,	false,		prefix3+"bs_cd",			false,		"",	dfNone,		0,		false,		true);

					InitDataProperty(0, cnt++ , dtData,				130,	daRight,	false,		prefix3+"special",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	false,		prefix3+"auth",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	false,		prefix3+"stwg_cd",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daLeft,		false,		prefix3+"cmdt_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix3+"ts_rmk",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix3+"bkg_no",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix3+"vs_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix3+"tot_20",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix3+"tot_40",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			80,	    daCenter,	false,		prefix3+"tot_wgt",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daRight,	false,		prefix3+"cntr_vol",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	false,		prefix3+"teu",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	false,		prefix3+"feu",				false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		prefix3+"pol_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		prefix3+"pod_nm",			false,		"",	dfNone,		0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daCenter,	false,		prefix3+"del_nm",			false,		"",	dfNone,		0,		false,		true);
					 
					
					ShowButtonImage = 2;
						
               }
                break;

        }
    }
     
var arrSXml ;

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = sheetObj.id+"_"; 
        switch(sAction) {

           case IBSEARCH:      //조회  
				formObj.f_cmd.value = SEARCH;
           		if (ComIsEmpty(formObj.vvd)) {
           			ComSetObjValue(formObj.vvd,formObj.vvdList.Text);
           		}
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0495GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix)); 
					sheetObj.Redraw = false;   
					sheetObj.LoadSearchXml(sXml); 
					sheetObj.Redraw = true; 
					ComSetObjValue(formObj.chkport,ComGetObjValue(formObj.loc_cd));
					setRmkBackColor(sheetObj,arrPreFix);
					
					arrSXml = sXml.split(iterator);
					

                break;
	
			case IBDOWNEXCEL:      // 엑셀다운  
				var cnt = 0;
				if(beforetab == 0 ){
					sheetObjects[2].LoadSearchXml(ComReplaceStr(arrSXml[0], prefix1, prefix3));
				}else{
					sheetObjects[2].LoadSearchXml(ComReplaceStr(arrSXml[0], prefix2, prefix3));
				}
				var rowSkip="";
				for(var i=1;i<sheetObjects[2].Rows;i++){
					if (typeof(sheetObjects[2].CellValue(i,prefix3+"chk").length) !="undefined"){
						if (i==sheetObjects[2].Rows-1){
							rowSkip+=i;
						}else{
							rowSkip+=i+"|";
						}
					}
				}
				sheetObjects[2].MoveColumnPos(prefix3+"op_cd"            ,1 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"firstlane"        ,2 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"firstvvd"         ,3 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"firstetb"         ,4 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"org_yd_cd"        ,5 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"nextlane"         ,6 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"nextvvd"          ,7 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"nextetd"          ,8 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"terminal"         ,9 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"bl_no"        	,10 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"cntr_no"         ,11 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"cntr_tpsz_cd"    ,12 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"cntr_seal_No"    ,13 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"pol_cd"          ,14 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"pol_nm"          ,15 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"pod_cd"          ,16 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"pod_nod_cd"      ,17 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"pod_nm"          ,18 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"del_cd"          ,19 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"del_nm"          ,20 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"wgt"             ,21 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"bs_cd"           ,22 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"special"         ,23 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"auth"            ,24 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"stwg_cd"         ,25 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"cmdt_nm"         ,26 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"cntr_vol"        ,27 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"teu"             ,28 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"feu"             ,29 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"chk"             ,30 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"rmk"             ,31 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"ts_rmk"          ,32 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"bkg_no"          ,33 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"vs_nm"           ,34 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"tot_20"          ,35 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"tot_40"          ,36 ,false);
				sheetObjects[2].MoveColumnPos(prefix3+"tot_wgt"         ,37 ,false);
				sheetObjects[2].SpeedDown2Excel(-1,false,false,"","",false,false,"",false,prefix3+"chk|"+prefix3+"rmk|",rowSkip);

				break;
			
			case COMMAND01:			//VVD Combo
				formObj.f_cmd.value = COMMAND01; 
				var sXml =sheetObj.GetSearchXml("ESM_BKG_0495GS.do", FormQueryString(formObj));
				ComBkgXml2ComboItem(sXml,formObj.vvdList,"val", "name");
				//var arrVal= ComXml2ComboString(sXml, "val", "name");  
				//ComboList(arrVal);
				break;

			case COMMAND02:			//Fax
				formObj.f_cmd.value = COMMAND02; 
				var sXml =sheetObj.GetSearchXml("ESM_BKG_0495GS.do", FormQueryString(formObj));
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				if(State == "S"){
					ComShowCodeMessage("BKG00496");
				}else{
					ComShowMessage(ComResultMessage(sXml));
				}
				break;
			
			case COMMAND03:			//Mail
				formObj.f_cmd.value = COMMAND03; 
				var sXml =sheetObj.GetSearchXml("ESM_BKG_0495GS.do", FormQueryString(formObj));
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				if(State == "S"){
					ComShowCodeMessage("BKG00497");
				}else{
					ComShowMessage(ComResultMessage(sXml));
				}
				break;
			case COMMAND05:			//Relay Port
				formObj.f_cmd.value = COMMAND05; 
				var params = FormQueryString(formObj);  
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0495GS.do", params);
				ComSetObjValue(formObj.loc_cd,ComGetEtcData(sXml,"relayPort")); 
				 
				//formObj.relay_port.value=ComGetEtcData(sXml,"relayPort");
            	// formObj.baseRelayPort.value=ComGetEtcData(sXml,"relayPort");

				 
				break;
        }
    }




    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
	
	/*
	* MultiCombo 설정
	*/
	function initCombo(comboObj) {
         	comboObj.MultiSelect = false;
         	comboObj.UseCode = true;
			comboObj.BackColor= "#CCFFFD";
         	comboObj.LineColor = "#CCFFFD";
         	comboObj.SetColAlign("left|left");
         	comboObj.MultiSeparator = "|";	
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
                    InsertTab( cnt++ , "Discharging" , -1 );
                    InsertTab( cnt++ , "Loading" , -1 );
                    
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
	    	/*
	 			if(nItem==0 &&tabLoad[0]!=1)
					frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
				else if(nItem==1 &&tabLoad[1]!=1)
					frameLayer1.document.location = 'tab3.jsp?frame=Tab2';    	
	    	*/ 
	    	//--------------- 요기가 중요 --------------------------//
	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	//------------------------------------------------------//
	    	beforetab= nItem; 
			if (beforetab ==0){
				document.form.search_kind_cd[0].checked=true;
				setSearchKindCd(document.form);
				 
				document.form.disc_load_cd.value="D"; 
				CellCheckAll(sheetObjects[0],false,prefix1+"chk"); 
			}else if (beforetab ==1){
				document.form.search_kind_cd[1].checked=true;
				setSearchKindCd(document.form);
				
				document.form.disc_load_cd.value="L";
				CellCheckAll(sheetObjects[1],false,prefix2+"chk"); 
			}
			//sheetObjects[0].RemoveAll();
			//sheetObjects[1].RemoveAll();
			ComSetDisplay("btn_CheckAll",true);
			ComSetDisplay("btn_UnCheckAll",false); 
    }
	
	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
        var formObj = document.form;
        
        formObj.tot_20_1.value =  ComAddComma(sheetObj.CellValue(sheetObj.LastRow, "t1sheet1_tot_20"));
        formObj.tot_40_1.value =  ComAddComma(sheetObj.CellValue(sheetObj.LastRow, "t1sheet1_tot_40"));
        formObj.tot_weight_1.value =  ComAddComma(sheetObj.CellValue(sheetObj.LastRow, "t1sheet1_tot_wgt"));
    } 
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
        var formObj = document.form;

        formObj.tot_20_2.value =  ComAddComma(sheetObj.CellValue(sheetObj.LastRow, "t2sheet1_tot_20"));
        formObj.tot_40_2.value =  ComAddComma(sheetObj.CellValue(sheetObj.LastRow, "t2sheet1_tot_40"));
        formObj.tot_weight_2.value =  ComAddComma(sheetObj.CellValue(sheetObj.LastRow, "t2sheet1_tot_wgt"));
    } 


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
	    		case IBSEARCH: {
					if(ComGetObjText(vvdList) == ""){
						vvd.value=""; 
						chkvvd.value="";
					}
					ComSetDisplay("btn_CheckAll",true);
					ComSetDisplay("btn_UnCheckAll",false);
					if(ComIsEmpty(loc_cd)){ 
						ComShowCodeMessage("BKG00757"); 
						return false;
					}else if ( !ComIsEmpty(vps_etd_dt) && ComGetObjText(vvdList) ==""  ){
						ComSetFocus(vvdList);
						ComShowCodeMessage("BKG00104","VVD"); 
						return false;						
					}else if (ComGetObjValue(search_kind_cd)=="D") {
						if (ComIsEmpty(dur_from)||ComIsEmpty(dur_to)) {
							if(ComIsEmpty(dur_from)) {
								ComSetFocus(dur_from);
							} else {
								ComSetFocus(dur_to);
							}
							ComShowCodeMessage("BKG00758"); 
							return false;
						} else if (ComGetDaysBetween(dur_from.value, dur_to.value) > 30) {
							ComShowCodeMessage("BKG00756", "Duration", "30Days");
							dur_from.focus();
							return false;
						}
					}else if ( (ComGetObjValue(search_kind_cd)!="D" && ComIsEmpty(vps_etd_dt))  ){
						ComSetFocus(vps_etd_dt);
						ComShowCodeMessage("BKG00758"); 
						return false;
					//}else if (ComChkLen(vvd,9)!=2){
						//ComShowCodeMessage("BKG00051",vvd.value);
					}
					break;
				}
        	}
        }
        return true;
    }
     
    function t1sheet1_OnChange(sheetObj,Row,Col,Value){ 
		CheckSame(sheetObj,Row,Col,Value,prefix1+"chk",prefix1+"bl_no");
	} 
	
	 function t1sheet2_OnChange(sheetObj,Row,Col,Value){ 
		CheckSame(sheetObj,Row,Col,Value,prefix2+"chk",prefix2+"bl_no");
	} 

	function t1sheet1_OnDblClick(sheetObj, Row,Col){
		with(sheetObj)
		{
			var formObject = document.form;
			var sName = ColSaveName(Col);
			if(sName == prefix1+"rmk"){
				var param="?bkg_no="+CellValue(Row,prefix1+"bkg_no");
					param+="&relay_port="+ComGetObjValue(formObject.loc_cd);
					param+="&pgmNo=ESM_BKG_0903";	
					ComOpenWindowCenter("/hanjin/ESM_BKG_0903.do"+param, "myWin", 500,278, true); 
			}

		}
	}

	function t2sheet1_OnDblClick(sheetObj, Row,Col){
		with(sheetObj)
		{
			var formObject = document.form;
			var sName = ColSaveName(Col);
			
			if(sName == prefix2+"rmk"){
				var param="?bkg_no="+CellValue(Row,prefix2+"bkg_no");
					param+="&relay_port="+ComGetObjValue(formObject.loc_cd);
					param+="&pgmNo=ESM_BKG_0903";	
				var obj=ComOpenWindowCenter("/hanjin/ESM_BKG_0903.do"+param, "myWin", 500,278, true); 
				if(obj=="T") { 
					CheckSame(sheetObj,Row,Col,1,prefix2+"rmk",prefix2+"bl_no");
					sheetObj.RowBackColor(Row)=sheetObj.RgbColor(204, 255, 252);
				}
			}

		}
	}
	
	/*
	 * KeyPress Event 처리
	 */
    function bkg0495_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
	}
	
	/*
	* Change Event처리
	*/
	function bkg0495_blur(){
		obj = event.srcElement; 
		var formObject = document.form; 
	    switch(obj.name){ 
	        case "vps_etd_dt": 	        	
				if ((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComIsEmpty(formObject.vps_etd_dt)){
					//ComShowCodeMessage("BKG00758");
					//ComSetFocus(formObject.loc_cd);
				}else if ((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComChkLen(ComTrim(formObject.loc_cd),5)==2){
					doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
				} 
	            break;
			case "loc_cd":
				if (((ComGetObjValue(formObject.search_kind_cd)=="E" || ComGetObjValue(formObject.search_kind_cd)=="A") && ComIsEmpty(formObject.vps_etd_dt))||ComChkLen(ComTrim(formObject.loc_cd),5)!=2){
					//ComShowCodeMessage("BKG00461");
					//ComSetFocus(formObject.loc_cd);
				}else if (ComChkLen(ComTrim(formObject.loc_cd),5)==2){
					doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
				} 
				break;
			case "loc_yd_cd": 
				if (!ComIsEmpty(formObject.loc_yd_cd)&&ComChkLen(ComTrim(formObject.loc_yd_cd),2)!=2){
					ComShowCodeMessage("BKG00269",ComGetObjValue(formObject.loc_yd_cd));
					ComSetFocus(formObject.loc_yd_cd);
				}  
				break; 
	    }
	}
	
   /*
   * 멀티콤보 onChange이벤트
   */
   function vvdList_OnChange(comboObj,value,text) {
 	 var form = document.form;
	  form.vvd.value=text; 
	  form.chkvvd.value=text; 
   }

  

	/*
	* Click Event처리
	*/
	function bkg0495_Click(){
		obj = event.srcElement; 
		var formObject = document.form; 
		 if (obj.name =="search_kind_cd"){
		 	if (ComGetObjValue(formObject.search_kind_cd) =="A"){
				 	document.tab1.SelectedIndex = 0;
			 	}else if (ComGetObjValue(formObject.search_kind_cd) =="E"){
				 	document.tab1.SelectedIndex = 1;
			 	}
			 	setSearchKindCd(formObject);
	    }
	    
	}
	
	
function setSearchKindCd(formObject){
			  //ComEnableObject(formObject.vvd,true);
			 if (ComGetObjValue(formObject.search_kind_cd) =="E" || ComGetObjValue(formObject.search_kind_cd) =="A"){

				if (ComGetObjValue(formObject.search_kind_cd) =="E"){
					ComSetObjValue(formObject.vps_dt_flag,"E");
				}else{
					ComSetObjValue(formObject.vps_dt_flag,"A");
				}
				
				ComClearObject(formObject.dur_from);
				ComClearObject(formObject.dur_to);
				if (ComIsEmpty(formObject.vps_etd_dt)){
					//ComShowCodeMessage("BKG00758");
					//ComSetFocus(formObject.vps_etd_dt);
				}else if (ComChkLen(ComTrim(formObject.loc_cd),5)!=2){
					ComShowCodeMessage("BKG00461");
					ComSetFocus(formObject.loc_cd);
				}else if (!ComIsEmpty(formObject.loc_yd_cd)&&ComChkLen(ComTrim(formObject.loc_yd_cd),1)!=2){
					ComShowCodeMessage("BKG00269");
					ComSetFocus(formObject.loc_yd_cd);
				}else{
					doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
				}
			 }else{
				 formObject.vvdList.RemoveAll();  
				 ComClearObject(formObject.vps_dt_flag);
				 ComClearObject(formObject.vps_etd_dt);
				 //ComEnableObject(formObject.vvd,false);
			 } 				
 }	

	/*
	* VVD 조회 데이터로 콤보박스생성
	*/
    function ComboList(arrVal){
		 if(typeof(arrVal)=="undefined") return;
		 var objCbo = document.getElementById("vvdList");
		 ComClearCombo(objCbo);		 
		 var arr_value = arrVal[0].split("|"); 
		 if (arr_value.length >0)
		 {
			 var opt = document.createElement("option"); 
			 var arr_text = "";   
			 opt.setAttribute("value", "");  
			 opt.innerHTML=arr_text;  
			 objCbo.appendChild(opt);
			 for(var i = 0; i <= arr_value.length-1; i++) {
				opt = document.createElement("option"); 
				arr_text = arr_value[i];   
				opt.setAttribute("value", arr_text);  
				opt.innerHTML=arr_text;  
				objCbo.appendChild(opt);

			 }
		 }else{
			 //var opt = document.createElement("option"); 
			 //var arr_text = "All";   
			 //opt.setAttribute("value", arr_text);  
			 //opt.innerHTML=arr_text;  
			 //objCbo.appendChild(opt);
		 }
	}
     
	/*
	 * Location 정보를 가져오는 함수
	 */
	function getCOM_ENS_061(rowArray){
		var formObject = document.form;
		var colArray = rowArray[0]; 
		formObject.loc_cd.value= colArray[3].substring(0,5);
        formObject.loc_yd_cd.value = colArray[3].substring(5); 
	}
	
	/*
	* Form 초기화 
	*/
	function initForm(){
		var formObject = document.form;
		 formObject.vps_etd_dt.value=ComGetNowInfo();
		 //formObject.dur_from.value=ComGetNowInfo();
		 //formObject.dur_to.value=ComGetNowInfo();
		 //ComClearObject(formObject.loc_cd);
		 ComClearObject(formObject.loc_yd_cd);
		 ComClearObject(formObject.search_kind_cd[0]);
		 ComClearObject(formObject.search_kind_cd[1]);
		 ComClearObject(formObject.search_kind_cd[2]);
		 ComSetObjValue(formObject.vps_dt_flag,"A");
		 formObject.vvdList.RemoveAll();
		 formObject.vvdList.Text="";
		 formObject.vvd.value="";
		 ComClearObject(formObject.op_cd);
		 ComClearObject(formObject.faxmail);
		 sheetObjects[0].RemoveAll();
		 sheetObjects[1].RemoveAll();
		 ComSetDisplay("btn_CheckAll",true);
		 ComSetDisplay("btn_UnCheckAll",false);
		 formObject.special[7].checked=true;
		 formObject.search_kind_cd[0].checked=true
	}

	/*
	*Rd 설정
	*/
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	function CheckGrid(sheetObject,prefix){
		var iCheckRow = sheetObject.FindCheckedRow(prefix + "chk"); 
		if (iCheckRow <= 1) {
			ComShowCodeMessage("BKG00249");
			return false;
		}
		return true;
	}
	/*
	* Rd 파라함수
	*/
	function RdParam(sheetObject,prefix) { 
		var strResult = ""; 
		var inStr ="";
		//var title ="0";
		var vsNM ="";
		var tabflag="";
		var iCheckRow = sheetObject.FindCheckedRow(prefix + "chk"); 
		var arrRow = iCheckRow.split("|"); 
		for (idx=0; idx<arrRow.length-1; idx++) {			
			if(sheetObject.CellValue(arrRow[idx],prefix+"chk")==1){ 
				if (idx>0){
					inStr = inStr + ",'"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no")+"'";
				}else{
					inStr = "bl_no['"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no")+"'";
				}
			}
		}
		inStr = inStr + "]";
		
		if (document.form.disc_load_cd.value=="D"){
			tabflag="disc_load_cd['D'] ";
		}else{
			tabflag="disc_load_cd[] ";
		}
		 
		var strParam=tabflag;
		 
		if (ComIsNull(document.form.chkvvd)){
			strParam+="vvd[] ";
		}else{
			strParam+="vvd['"+ComGetObjValue(document.form.chkvvd)+"'] ";
		}
	 
		if (ComIsNull(document.form.chkport)){
			strParam+="port[] ";
		}else{
			strParam+="port['"+ComGetObjValue(document.form.chkport)+"'] ";
		}
		if (ComIsNull(document.form.loc_yd_cd)){
			strParam+="loc_cd[] ";
		}else{
			strParam+="loc_cd['"+ComGetObjValue(document.form.loc_yd_cd)+"'] ";
		}
		strParam+=inStr;
//		strResult= rdParamSet(strParam);
		strResult = strParam;
		//ComDebug(strResult);
		//strResult= rdParamSet("'"+tabflag+"'"+"~"+"'"+ComGetObjValue(document.form.vvd)+"'"+"~"+"'"+ComGetObjValue(document.form.loc_cd)+"'"+"~"+"'"+ComGetObjValue(document.form.loc_yd_cd)+"'"+"~"+inStr);		 
		 
		return strResult; 
	}
    
	/*
	* Rd 오픈
	*/
	function rdOpen(rdObject, formObject, param){
		var Rdviewer = rdObject;
		// /rp [" + param + "] /riprnmargin /rprncenteropt [1] /rwait
		//var rdParam = "/rp [" + param + "] /riprnmargin /rwait";
		var rdParam = "/rv " + param + " /riprnmargin /rwait";

		// 열고자 하는 RD 파일을 지정한다.
		var strPath = RD_path+"apps/alps/esm/bkg/transshipmentmgt/transshipmentmgt/report/ESM_BKG_0877.mrd";

		//ComDebug(rdParam + "\n\n" + strPath);
		Rdviewer.FileOpen(strPath, RDServer + rdParam); 
		Rdviewer.CMPrint();

	}

	/*
	* Bl/NO 체크값
	*/
	function CheckBlNo(sheetObj,prefix){
		var inStr="";
		var blnoTmp="";
		for(i=0;i<sheetObj.Rows;i++){ 
			if(sheetObj.CellValue(i,prefix+"chk")==1){ 
				if(blnoTmp !=sheetObj.CellValue(i,prefix+"bl_no")){
					inStr+=sheetObj.CellValue(i,prefix+"bl_no")+"|";
					blnoTmp = sheetObj.CellValue(i,prefix+"bl_no");
				}
				
			}
		}
		return inStr;
	}
	
	/*
	 * Activate Event 처리
	 */
	function bkg0495_obj_activate(){
		
			var formObject = document.form; 
    	//입력Validation 확인하기
    	switch(event.srcElement.name){

	    	case "vps_etd_dt":
	    		ComClearObject(form.dur_from);
	    		ComClearObject(form.dur_to);
	    		
					if (ComGetObjValue(formObject.search_kind_cd) =="D"){
						document.form.search_kind_cd[0].checked=true;
						document.tab1.SelectedIndex = 0;
					 	setSearchKindCd(formObject);
			 		}
			 			    		
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "dur_from":
	    		if (ComGetObjValue(formObject.search_kind_cd) !="D"){
						document.form.search_kind_cd[2].checked=true;
			 		}
			 		
	    		ComClearObject(form.vps_etd_dt);
	    		ComClearSeparator(event.srcElement);
    			break; 
			case "dur_to":
					if (ComGetObjValue(formObject.search_kind_cd) !="D"){
						document.form.search_kind_cd[2].checked=true;
			 		}
			 		
	    		ComClearObject(form.vps_etd_dt);
	    		ComClearSeparator(event.srcElement);
    			break; 
    		default:
    			break;
    			 
    	}
    }
	
	/*
	 * Deactivate Event 처리
	 */
    function bkg0495_obj_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "vps_etd_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "dur_from":
	    		ComAddSeparator(event.srcElement);
    			break; 
			case "dur_to":
	    		ComAddSeparator(event.srcElement);
    			break; 
    		default:
    			break; 
    	}
    }
    
	/*
	* Remark값이 있는 셀 색상설정
	*/
	function setRmkBackColor(sheetObj,prefix){		
		var sRow=sheetObj.FindCheckedRow(prefix+"rmk");
		if(sRow.length==0) return;
		var arrRow = sRow.split("|");  
		for(var idx=0;idx<arrRow.length-1;idx++){  
			if (sheetObj.CellValue(arrRow[idx],prefix+"rmk")==1){ 
				sheetObj.RowBackColor(arrRow[idx])=sheetObj.RgbColor(204, 255, 252);
			} 
		}
	} 
    
	/*
	* CheckBox 와 DataType같이 있을때 전체체크박스 선택 
	*/
	/*function CellCheckAll(sheetObj,flag,prefix){  
		for(i=0;i<sheetObj.Rows;i++){ 
			if(typeof(sheetObj.CellValue(i,prefix+"chk").length) =="undefined" 
				&& typeof(sheetObj.CellValue(i,prefix+"rmk").length) =="undefined"){
				if (flag){
					sheetObj.CellValue(i,prefix+"chk")=1; 
				}else{
					sheetObj.CellValue(i,prefix+"chk")=0;
				}	 
			}
		}
	}*/
	/* 개발자 작업  끝 */