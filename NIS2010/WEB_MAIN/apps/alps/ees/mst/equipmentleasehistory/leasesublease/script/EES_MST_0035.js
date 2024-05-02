/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0035.js
*@FileTitle : Container Check Digit and Container Checking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
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
     * @class ees_mst_0035 : ees_mst_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0035() {
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
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
					case "btn_retrieve":
						formObject.cntr_no.value = "";

						for (var i = 1; i <= sheetObject1.RowCount; i++){
							if (formObject.cntr_no.value == ""){
								formObject.cntr_no.value = sheetObject1.CellValue(i,0);
							} else {
								formObject.cntr_no.value = formObject.cntr_no.value + "," + sheetObject1.CellValue(i,0);
							}
						}
						if (sheetObject1.RowCount > 0){
						   doActionIBSheet(sheetObject1,document.form,IBSEARCH);
						} else {
		            		ComShowCodeMessage("MST00001","Row");
		            		return;							
						}
					break;
					
					case "btn_new":
						sheetObject1.RemoveAll();
						sheetObject1.DataInsert();
						sheetObject1.SelectCell(1, 0);						
					break; 
					
					case "btn_loadexcel":
						//sheetObject1.RemoveAll();						
						var aa = sheetObject1.LoadExcel(0,1,"","-1","-1","",false);

						formObject.cntr_no.value = "";
						for (var i = 1; i <= sheetObject1.RowCount; i++){
							if (formObject.cntr_no.value == ""){
								formObject.cntr_no.value = sheetObject1.CellValue(i,0);
							} else {
								formObject.cntr_no.value = formObject.cntr_no.value + "," + sheetObject1.CellValue(i,0);
							}
						}
						if (sheetObject1.RowCount > 0){
						   doActionIBSheet(sheetObject1,document.form,IBSEARCH);
						} else {
		            		ComShowCodeMessage("MST00001","Row");
		            		return;							
						}						
						
						
					break; 
					
					case "btn_downexcel":
						sheetObject1.SpeedDown2Excel();
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
 		 sheetObjects[0].DataInsert();
 		 sheetObjects[0].SelectCell(1, 0);
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
                     style.height = 460;
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

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(35, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle = "CNTR No.|Check Digit|RGST CNTR No.|Full CNTR No.|TP/SZ|Term|Movement|Yard|MVMT Date|Status|AMGT No.|Lessor|D/V|M/Date|BKG No|POL|POR|POD|DEL|ETD DT|ETA DT|VVD|User|F/M|DMG|HRT|HBT|HBQ|DP|IM|LS|UC|PF|R/D Term|S/C No|";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData, 		 		 120,   daCenter,  false,     "cntr_no",     	 true,           "",      dfNone, 			0,     true,       true,	10);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "chk_dgt",     	 false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 120,   daCenter,  false,     "rgst_cntr_no",  	 false,          "",      dfNone, 			0,     false,       false,	11);
                     InitDataProperty(0, cnt++ , dtData, 		 		 120,   daCenter,  false,     "full_cntr_no",  	 false,          "",      dfNone, 			0,     false,       false,	11);
                     InitDataProperty(0, cnt++ , dtData, 		 		 75,   	daCenter,  false,     "cntr_tpsz_cd",    false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "lstm_cd",     	 false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 75,   	daCenter,  false,     "cnmv_sts_cd",     false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "crnt_yd_cd",      false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "cnmv_date",       false,          "",      dfNone, 			0,     false,       false,	2);                     
                     InitDataProperty(0, cnt++ , dtData, 		 		 75,   	daCenter,  false,     "cntr_sts_cd",     false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "agmt_no",     	 false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 150,  	daLeft,    false,     "vndr_abbr_nm",    false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,  	daCenter,  false,     "dv_val",          false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,  	daCenter,  false,     "mft_dt",          false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 85,   	daCenter,  false,     "bkg_no",  		 false,          "",      dfNone, 			0,     false,       false,	12);
                     InitDataProperty(0, cnt++ , dtData, 		 		 65,   	daCenter,  false,     "pol_cd",  	 	 false,          "",      dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData, 		 		 65,   	daCenter,  false,     "por_cd", 		 false,          "",      dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData, 		 		 65,   	daCenter,  false,     "pod_cd", 		 false,          "",      dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData, 		 		 65,   	daCenter,  false,     "del_cd",  		 false,          "",      dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "etd_dt", 		 false,          "",      dfNone, 			0,     false,       false,	10);
                     InitDataProperty(0, cnt++ , dtData, 		 		 80,   	daCenter,  false,     "eta_dt",  		 false,          "",      dfNone, 			0,     false,       false,	10);
                     InitDataProperty(0, cnt++ , dtData, 		 		 75,   	daCenter,  false,     "vvd",  			 false,          "",      dfNone, 			0,     false,       false,	9);
                     InitDataProperty(0, cnt++ , dtData, 		 		 75,   	daCenter,  false,     "cntr_use_co_cd",  false,          "",      dfNone, 			0,     false,       false,	2);
                     
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "full_flg",          false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "dmg_flg",           false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "cntr_hngr_rck_cd",  false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "mnr_hngr_bar_tp_cd",false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "cntr_hngr_bar_atch_knt",  false,    "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "disp_flg",          false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "imdt_ext_flg",      false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "ls_flg",            false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "uc_flg",            false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 40,   	daCenter,  false,     "plst_flr_flg",      false,          "",      dfNone, 			0,     false,       false,	2);      
                     
                     InitDataProperty(0, cnt++ , dtData, 		 		 150,   daLeft,    false,     "rd_term",  	   	   false,          "",      dfNone, 			0,     false,       false,	2);
                     InitDataProperty(0, cnt++ , dtData, 		 		 150,   daLeft,    false,     "sc_no",  		   false,          "",      dfNone, 			0,     false,       false,	2);
                     
                     
                     InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); //대문자만                      
                }
                 break; 
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
			    sheetObj.WaitImageVisible=false;
			    ComOpenWait(true);
			    formObj.f_cmd.value = SEARCH;
				var xml = "";
 				xml = sheetObj.GetSearchXml("EES_MST_0035GS.do", FormQueryString(formObj));
		 		sheetObj.LoadSearchXml(xml);
		 		ComOpenWait(false);
			break;
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
     
     function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	 var sName = SheetObj.ColSaveName(Col);
         if (sName == "cntr_no"){
        	 var celltxt  = SheetObj.EditValue;
        	 var celltxt1 = SheetObj.CellValue(Row, 0);
        	 if (celltxt == "" && celltxt1 != ""){
        		 celltxt = celltxt1;
        	 }
         	 if(celltxt.length == 10 || KeyCode == 13){
         		 SheetObj.CellValue2(Row,0) = celltxt;
                 var formObject = document.form;         		 
				 formObject.cntr_no.value = "";
				 for (var i = 1; i <= SheetObj.RowCount; i++){
					if (formObject.cntr_no.value == ""){
						formObject.cntr_no.value = SheetObj.CellValue(i,0);
				    } else {
							formObject.cntr_no.value = formObject.cntr_no.value + "," + SheetObj.CellValue(i,0);
					}
				 }
				 if (SheetObj.RowCount > 0){
				    doActionIBSheet(SheetObj,formObject,IBSEARCH);
				 } else {
	            	ComShowCodeMessage("MST00001", "Row");
	            	return;							
				 }         		 
        	 }
         }
     }
         
	/* 개발자 작업  끝 */