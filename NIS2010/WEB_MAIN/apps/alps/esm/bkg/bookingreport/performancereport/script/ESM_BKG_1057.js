/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1057.js
*@FileTitle : Freight & Charge List by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.09.12 김태경
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
     * @class ESM_BKG_1057 : ESM_BKG_1057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1057() {
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
 var rdObjects = new Array();
 var rdCnt = 0;    

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var tabItem 	= 0; 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject1 = sheetObjects[0];
 		         var sheetObject2 = sheetObjects[1];
 		         var Rdviewer = rdObjects[0];
 		         var objs = document.all.item("tabLayer");
 		         var tab1Status = objs[1].style.display;
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
             switch(srcName) {

 							case "btn_retrieve":
 								//  Actual VVD 는 Grid로 조회 안됨
 										if(formObject.vvd_chk[1].checked == true){
 											
 											 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 											 
 										}else{
										
 											/* Grid 항목만 조회 */
 											if(tabItem == 0){
 												
 												doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
 	 											 
 				 				  		    	var sheetObj= sheetObjects[0];
 				 				  		  		
 				 				  		  		var formObj = document.form;
 				 				  		     	
 				 				  		     	var vsl_cd = formObj.vvd_cd.value.substring(0,4);
 				 				  		     	var skd_voy_no = formObj.vvd_cd.value.substring(4,8);
 				 				  		     	var skd_dir_cd = formObj.vvd_cd.value.substring(8);
 				 				  		     	
 											}
 											/* report 항목만 조회 */
 											else{
 
				 				  		    	var sheetObj= sheetObjects[0];
				 				  		  		
				 				  		  		var formObj = document.form;
				 				  		     	
				 				  		     	var vsl_cd = formObj.vvd_cd.value.substring(0,4);
				 				  		     	var skd_voy_no = formObj.vvd_cd.value.substring(4,8);
				 				  		     	var skd_dir_cd = formObj.vvd_cd.value.substring(8);
				 				  		     	
				 				  		     	var rdPath = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
				 				  		     	
				 				  		     	 
				 				  		     	var option = "";
				 				  		     	var where = "";
				 				  		     	
					 				  		    if(ComIsNull(ComTrim(formObj.vvd_cd))){
					 				  		    	ComShowCodeMessage('BKG00161');
					 				  		    	formObj.vvd_cd.focus();
					 				  		    	return false; 		
					 			    			}
				 				  		     	
				 				  		     	
				 				  		     	if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
				 				  		     	
				 				  		     	option = "OPTION[VVD-" + formObj.vvd_cd.value + "/POL-" + formObj.pol_cd.value;
				 				  		     	
				 				  		     	where = " vsl_cd"+"["+ vsl_cd +"] "+"skd_voy_no"+"["+skd_voy_no+"] "+"skd_dir_cd"+"["+ skd_dir_cd +"] "
				 				  		    	
				 				  		     	
				 				  		     	if (formObj.pol_cd.value !=""){
				 				  		     		option = option + "/POL_-" + formObj.pol_cd.value;
				 				  		     		where = where + "pol_cd" +"["+ formObj.pol_cd.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "pol_cd[] ";
				 				  		     	}
				 				  		     	    	
				 				  		     	if (formObj.pod_cd.value !=""){
				 				  		     		option = option + "/POD_-" + formObj.pod_cd.value;
				 				  		     		where = where + "POD_CD" +"["+  formObj.pod_cd.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "pod_cd[] ";
				 				  		     	}
				 				  		     	if (formObj.por_cd.value !=""){
				 				  		     		option = option + "/POR_-" + formObj.por_cd.value;
				 				  		     		where = where + "POR_CD" +"["+ formObj.por_cd.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "por_cd[] ";
				 				  		     	}
				 				  		     	
				 				  		     	if (formObj.del_cd.value !=""){
				 				  		     		option = option +"/DEL_-" + formObj.del_cd.value;
				 				  		     		where = where + "DEL_CD" +"["+ formObj.del_cd.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "del_cd[] ";
				 				  		     	}
				 				  		     	if (formObj.sls_ofc.value !=""){
				 				  		     		option = option + "BKG_OFC-" + formObj.sls_ofc.value;
				 				  		     		where = where + "OB_SLS_OFC_CD" +"["+ formObj.sls_ofc.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "ob_sls_ofc_cd[] ";
				 				  		     	}
				 				  		     	if (formObj.bkg_ofc.value !=""){
				 				  		     		option = option + "Sales_OFC-" + formObj.bkg_ofc.value;
				 				  		     		where = where + "BKG_OFC_CD" +"["+formObj.bkg_ofc.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "bkg_ofc_cd[] ";
				 				  		     	}
				 				  		     	if (formObj.trd_cd.value !=""){
				 				  		     		option = option + "Trade-" + formObj.trd_cd.value;
				 				  		     		where = where + "REV_DIR_CD" +"["+formObj.trd_cd.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "rev_dir_cd[] ";
				 				  		     	}
				 				  		     	if (formObj.sc_no.value !=""){
				 				  		     		option = option + "SC_NO-" + formObj.sc_no.value;
				 				  		     		where = where + "SC_NO" +"["+formObj.sc_no.value+"] " ;
				 				  		     	}else{
				 				  		     		where = where + "sc_no[] ";
				 				  		     	}

				 				  		    	if (formObj.fr_dt.value !="" ){
				 				  		    		if (ComGetObjValue(formObj.dt_chk) == "B"){
				 				  		    			where = where + "add_from"+"[]";
				 				  		    			where = where + "add_where"+"[ AND BK.BKG_CRE_DT BETWEEN TO_DATE(REPLACE('"+formObj.fr_dt.value+"','-',''),'YYYYMMDD') AND TO_DATE(REPLACE('"+formObj.to_dt.value+"','-',''),'YYYYMMDD')+0.99999]";
				 				  		    		}else {
				 				  		    			where = where + "add_from"+"[, BKG_BL_DOC BBD ]";
				 				  		    			where = where + "add_where"+"[ AND BBD.BL_OBRD_DT BETWEEN TO_DATE(REPLACE('"+formObj.fr_dt.value+"','-',''),'YYYYMMDD') AND TO_DATE(REPLACE('"+formObj.to_dt.value+"','-',''),'YYYYMMDD')+0.99999 AND BK.BKG_NO = BBD.BKG_NO] ";
				 				  		    		}
				 				  		    	}else{
				 				  		    		where = where + "add_from"+"[]";
				 				  		    		where = where + "add_where"+"[]";
				 				  		    	}
				 				  		     	
	//			 				  		     	formObj.com_mrdArguments.value 	= "/rv " + where;
	//			 				  		     	formObj.com_mrdTitle.value = "Freight &amp; Charge List by VVD";
	//			 				  		     	formObj.com_mrdBodyTitle.value = "<span style='color:red'>Freight &amp; Charge List by VVD</span>";
				 				  		     	
				 				  				var Rdviewer = rdObjects[0];
	//			 				  				var xmldata = "<?xml version=\"1.0\" encoding=\"euc-kr\"?><root><startdate>20080101</startdate><enddate>20081231</enddate><today>20090113</today><table1>	<a>		<a1>100 </a1>		<a2> 200</a2>		<a3>300 </a3>		<a4>400 </a4>		<a5>500 </a5>	</a></table1></root>";
				 				  				var mrdpath = RD_path + "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
				 				  				Rdviewer.AutoAdjust = true;
				 				  				Rdviewer.ViewShowMode(0);
				 				  				Rdviewer.setbackgroundcolor(128, 128, 128);
				 				  				Rdviewer.SetPageLineColor(128, 128, 128);
				 				  				Rdviewer.SetNoDataDialogInfo(0, "", ""); // 데이터 없음 메시지 창 숨김
				 				  				Rdviewer.FileOpen(mrdpath, RDServer + "/rv " + where);
 											}
 										}
// 				  		    	 }
 								 
 							break; 

 							case "btn_new":
 								ComResetAll();
 							break;
 							
 							case "btn_excel":
 								if(tabItem == 1){
 										Rdviewer.SetSaveExcelOption(1); // 1-엑셀파일로 저장시 형태유지함, 2- 형태유지 안함
 										Rdviewer.SetSaveDialog("", "", 2); // 파일저장 대화상자 초기값 설정: 위치, 파일이름, 파일형식
 										var ret = Rdviewer.SaveAsDialog(); // 파일저장 대화상자 띄워서 현재문서 저장함
 								}else{
 								doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL); 
 								//sheetObject2.Down2Excel();
 								/* Header 머지 부분을 삭제하고 Excel을 피벗할수 있도록 수정하여 ExcelDown 한다 2010.04.28 김태경 */
 								for (var i = sheetObjects[1].LastRow; i >= sheetObjects[1].HeaderRows; i--){
 									if(ComIsEmpty(sheetObjects[1].CellValue(i,"pod_cd"))){
 										sheetObjects[1].RowDelete(i,false);
 										}
 								}
 								sheetObjects[1].SpeedDown2Excel(-1);
 								}
 							break;
 							
 							case "btn_print":
 								if (tabItem == 1){
	 								if (tab1Status == "inline") {
	 									Rdviewer.PrintDialog(); // 인쇄 대화상자 띄움
	
	 								} else {
	 									return false;
	 								}
 								}
 								break;
 								 //go_Print();
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
       * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
       * 상단에 정의
       */
       function setTabObject(tab_obj) {
    		tabObjects[tabCnt++] = tab_obj;
    	}

      /**
       * Tab 기본 설정 탭의 항목을 설정한다.
       */
       function initTab(tabObj, tabNo) {
    		switch (tabNo) {
    		case 1:
    			with (tabObj) {
    				var cnt = 0;
    				InsertTab(cnt++, "Grid", -1);
    				InsertTab(cnt++, "Report", -1);
    			}
    			break
    		}
    	}
       function tab1_OnChange(tabObj, nItem) {
          	var objs = document.all.item("tabLayer");
          	var formObj = document.form;
          	objs[nItem].style.display = "Inline";
          	objs[beforetab].style.display = "none";

          	// --------------- 요기가 중요 --------------------------//
          	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
          	// ------------------------------------------------------//
           tabItem = nItem;

           if(formObj.vvd_chk[1].checked == true ){
        	   objs[0].style.display = "Inline";
               objs[1].style.display = "none";
           }else if (formObj.vvd_chk[0].chekced == true){
        	   //아무 작업 하지 않음
           }
          	// tab Index는 0 부터 시작 함
          	// 첫번째 tab = "청구서" 인 경우 수정 된 내용을 업데이트 해준다
          	// ??? sheet1_OnAfterEdit는 없애도 될 듯 하다. 좀 지켜 보자. ^^
          	beforetab = nItem;
          }

       /**
        * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
        * 추가한다
        */
        function loadPage() {
        	// TAB 생성
        	for (k = 0; k < tabObjects.length; k++) {
        		initTab(tabObjects[k], k + 1);
        	}

        	// IBSHEET 생성
        	for (i = 0; i < sheetObjects.length; i++) {
        		ComConfigSheet(sheetObjects[i]);
        		initSheet(sheetObjects[i], i + 1);
        		ComEndConfigSheet(sheetObjects[i]);
        	}
        	initControl();
        }

        function sheet1_OnLoadFinish(sheetObj) {
//        	rdOpen(rdObjects[0], document.form, sheetObj, "");
        }

    function rdOpen(rdObject, formObject, sheetObjects, paraArry) {
    	var Rdviewer = rdObject;
    	
    	Rdviewer.AutoAdjust = true;
    	Rdviewer.ViewShowMode(0);
    	Rdviewer.setbackgroundcolor(128, 128, 128);
    	Rdviewer.SetPageLineColor(128, 128, 128);
    	Rdviewer.SetNoDataDialogInfo(0, "", ""); // 데이터 없음 메시지 창 숨김

    	
    	// 열고자 하는 RD 파일을 지정한다.
    	var strPath = RD_path + "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
    	var rdParam = "/rdata []";
    	//var RDServer   = "/rfn [http://203.246.130.165:7110/RDServer/rdagent.jsp] /rsn [jdbc/NIS2010] /ruseurlmoniker [0]";  //RDServer RDAgnet url

    	
    	Rdviewer.FileOpen(strPath, RDServer + rdParam);
    }

      function initControl() {
    	  /* KEY PRESS 입력 받아 변환 */
    	  //** Date 구분자 **/
    	  DATE_SEPARATOR = "-";
       	
    	  var formObject = document.form;
    	  	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
    	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
    	    axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
         
      }
      
      /*********************** KEY EVENT START ********************/       
      function bkg_keypress(){
    	  switch(event.srcElement.dataformat){
    	  		case "engup" :
    	  		//영문 대문자
    	  			ComKeyOnlyAlphabet('upper');
    	  		break;
    	  		case "engupnum" :
    	  		//숫자+영문대문자 입력하기
    	  			ComKeyOnlyAlphabet('uppernum');
    	  		break;
    	  		case "num" :
    	  		//숫자 입력하기 
    	  			ComKeyOnlyAlphabet(event.scrElement);
    	  		break;
    	  		default:
    	  }
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
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 4, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(21, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Seq.|CHG TP|Rated As|Rate|Per|CUR|Amount|P/C|Pay OFC.|S/C No.|RFA No.|Tariff No.|Shipper Name|Consignee Name|Customs Description|CMDT|Commodity Description|REP CMDT|REP Commodity Description";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtData,	30,		daCenter,	false,		"seq");     
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"chg_tp",     false,	"",      dfNone,	0,		true,		true);
						                                                                                 
						InitDataProperty(0, cnt++ , dtData,	70,		daRight,	false,		"rated_as",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daRight,	false,		"rate",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"per",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"cur",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	90,		daRight,	false,		"amount",     false,	"",      dfNone,	0,		true,		true);
	                                                                                  
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"pc",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"pay_ofc",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"sc_no",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"rfa_no",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"tariff_no",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	110,		daLeft	,	false,		"shpr_nm",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	110,		daLeft	,	false,		"cnee_nm",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	150,		daLeft	,	false,		"cust_desc",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"cmdt",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	150,		daLeft	,	false,		"cmdt_desc",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	90,		daLeft	,	false,		"rep_cmdt_cd",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	155,		daLeft,	false,		"rep_cmdt",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"rt_aply_dt",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtHiddenStatus,	100,		daCenter,	false,		"bkg_no",     false,	"",      dfNone,	0,		true,		true);
						
						CountPosition = 0;
             	}
                 break;
                 case "sheet2":      //sheet2 init
	             with (sheetObj) {
	
                	    // 높이 설정
                     style.height = 0;
                     //전체 너비 설정
                     SheetWidth = 0;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 4, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(30, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Seq.|BKG No|Trade|POR|POL|POD|DEL|RD|DT|APPLY_Date|CHG TP|Rated As|Rate|Per|CUR|Amount|P/C|Pay OFC.|S/C No.|RFA No.|Tariff No.|Shipper Name|Consignee Name|Customs Description|CMDT|Commodity Description|REP CMDT|REP Commodity Description";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
	
	                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     	InitDataProperty(0, cnt++ , dtData,	30,		daCenter,	false,		"seq");     
                     	
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"bkg_no",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"rev_dir_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"por_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"pol_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"pod_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"del_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"rcv_term_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"de_term_cd",     false,	"",      dfNone,	0,		true,		true);
                     	InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"rt_aply_dt",     false,	"",      dfNone,	0,		true,		true);
                     	
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"chg_tp",     false,	"",      dfNone,	0,		true,		true);
						                                                                                 
						InitDataProperty(0, cnt++ , dtData,	70,		daRight,	false,		"rated_as",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daRight,	false,		"rate",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"per",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"cur",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	90,		daRight,	false,		"amount",     false,	"",      dfNone,	0,		true,		true);
	                                                                                  
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"pc",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"pay_ofc",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"sc_no",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"rfa_no",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"tariff_no",  	false,	"",      dfNone,	0,		true,		true);

						InitDataProperty(0, cnt++ , dtData,	110,		daLeft	,	false,		"shpr_nm",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	110,		daLeft	,	false,		"cnee_nm",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	150,		daLeft	,	false,		"cust_desc",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,		"cmdt",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	150,		daLeft	,	false,		"cmdt_desc",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	70,		daCenter	,	false,		"rep_cmdt_cd",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,	130,		daCenter,	false,		"rep_cmdt",     false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"rt_aply_dt",  	false,	"",      dfNone,	0,		true,		true);
						InitDataProperty(0, cnt++ , dtHiddenStatus,	100,		daCenter,	false,		"bkg_no",     false,	"",      dfNone,	0,		true,		true);
						
	         	}
	             break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false; 

         switch(sAction) {
 					case IBSEARCH:      //조회
 						if(!validateForm(sheetObj,formObj,sAction)) return;	
 							formObj.f_cmd.value = SEARCH;
 							formObj.spl_flg.value = "S";
 							sheetObj.WaitImageVisible=false;
 							ComOpenWait(true); // 대기창 보임

							var sXml = sheetObj.GetSearchXml("ESM_BKG_1057GS.do",FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");
							/*for ( var inx = 0; inx < arrXml.length; inx++) {
								sheetObjects[inx].LoadSearchXml(arrXml[inx]);
							}*/
							sheetObjects[0].LoadSearchXml(arrXml[0]);
// 								formObj.f_cmd.value = SEARCH;
// 								sheetObj.DoSearch("ESM_BKG_1057GS.do",FormQueryString(formObj));
 					break;
 					
 					case IBDOWNEXCEL:      //조회
 						if(!validateForm(sheetObj,formObj,IBSEARCH)) return;	
 							formObj.f_cmd.value = SEARCH;
 							formObj.spl_flg.value = "F";
 							sheetObj.WaitImageVisible=false;
 							ComOpenWait(true); // 대기창 보임

							var sXml = sheetObj.GetSearchXml("ESM_BKG_1057GS.do",FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");

							sheetObjects[1].LoadSearchXml(arrXml[0]);

 					break;
 					

         }
         ComOpenWait(false); // 대기창 보임
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
          var formObj = document.form;
    	  switch(sAction){
    	  case IBSEARCH:
    		  if(((formObj.vvd_chk[0].checked == true) || (formObj.vvd_chk[1].checked == true)) && ComIsNull(ComTrim(formObj.fr_dt)) ) {
    			  if(ComIsNull(ComTrim(formObj.vvd_cd))){
		    		ComShowCodeMessage('BKG00161');
		    		formObj.vvd_cd.focus();
		    		return false; 		
    			  }else if((formObj.vvd_chk[1].checked == true) && (ComIsNull(ComTrim(formObj.pol_cd)) && ComIsNull(ComTrim(formObj.pod_cd)))){
		    		ComShowCodeMessage('BKG00231');
		    		formObj.pol_cd.focus();
		    		return false;
    			  }  	  
    		  } else {
    				if(ComIsNull(ComTrim(formObj.fr_dt))){
    					ComShowCodeMessage("BKG00499");
    					formObj.fr_dt.focus();
    					return false;
    				}
    				if(ComIsNull(ComTrim(formObj.to_dt))){
    					ComShowCodeMessage("BKG00499");
    					formObj.to_dt.focus();
    					return false;
    				}
    			 	
    				if (!ComIsNull(ComTrim(formObj.fr_dt))
    			  			&& !ComIsNull(ComTrim(formObj.to_dt))
    			  			&& ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 7){
    			   		 
    						ComShowCodeMessage("BKG50472");//Can't Input Date Over 31 days!
    						formObj.fr_dt.focus();
    						return false;
    					}
    				
					if(ComIsNull(ComTrim(formObj.pol_cd)) && ComIsNull(ComTrim(formObj.vvd_cd))){
				    	ComShowCodeMessage('BKG00829');
				    	formObj.pol_cd.focus();
				    	return false;
		  			}     				
    		  }
    	
    	  }
    	  return true;
     } 
      
    function setSchKey(val){ //Mandantory 항목 표시
    	var formObj = document.form;
    	
    	if(val =='T'){
    		if(val == 'Z'){
    			tab1_OnChange(tabObjects,tabItem);
    		}
    		
    		formObj.pol_cd.required = true;
    		formObj.pol_cd.className = "input";
    		formObj.pod_cd.required = true;
    		formObj.pod_cd.className = "input"; 
    		formObj.vvd_cd.required = false;
    		formObj.vvd_cd.className = "input1"; 
    		formObj.fr_dt.required = true;
    		formObj.fr_dt.className = "input"; 
    		formObj.to_dt.required = true;
    		formObj.to_dt.className = "input"; 
    		document.all.item("lbTvvd").style.display = "block";
			document.all.item("lbAvvd").style.display = "none";
    		
    	}else if(val =='A'){
    		tab1_OnChange(tabObjects,tabItem);
    		formObj.pol_cd.required = false;
    		formObj.pol_cd.className ="input1";
    		formObj.pod_cd.required = false;
    		formObj.pod_cd.className ="input1";
    		formObj.vvd_cd.required = false;
    		formObj.vvd_cd.className = "input1";
    		formObj.fr_dt.required = true;
    		formObj.fr_dt.className = "input"; 
    		formObj.to_dt.required = true;
    		formObj.to_dt.className = "input"; 
			document.all.item("lbTvvd").style.display = "none";
			document.all.item("lbAvvd").style.display = "block";
    		
    	}else if(val =='B'){
    		//tab1_OnChange(tabObjects,tabItem);
    		formObj.pol_cd.required = false;
    		formObj.pol_cd.className = "input1";
    		formObj.pod_cd.required = true;
    		formObj.pod_cd.className = "input"; 
    		formObj.vvd_cd.required = true;
    		formObj.vvd_cd.className = "input"; 
    		formObj.fr_dt.required = false;
    		formObj.fr_dt.className = "input1"; 
    		formObj.to_dt.required = false;
    		formObj.to_dt.className = "input1"; 
    		document.all.item("lbBkg").style.display = "block";
			document.all.item("lbOnboard").style.display = "none";
			
    	}else if(val =='O'){
    		//tab1_OnChange(tabObjects,tabItem);
    		formObj.pol_cd.required = false;
    		formObj.pol_cd.className = "input1";
    		formObj.pod_cd.required = true;
    		formObj.pod_cd.className = "input"; 
    		formObj.vvd_cd.required = true;
    		formObj.vvd_cd.className = "input"; 
    		formObj.fr_dt.required = false;
    		formObj.fr_dt.className = "input1"; 
    		formObj.to_dt.required = false;
    		formObj.to_dt.className = "input1"; 	
    		document.all.item("lbBkg").style.display = "none";
			document.all.item("lbOnboard").style.display = "block";
    	}
    	
    }
//    function changeTab(nItem){ 
//   	 
//    	
//   	 tabObjects[0].SelectedIndex = nItem;
//   	 
//    }
    //PRINT >>> Call RD
    function go_Print(){ 
    
 		var sheetObj= sheetObjects[0];
 		
 		var formObj = document.form;
    	
    	var vsl_cd = formObj.vvd_cd.value.substring(0,4);
    	var skd_voy_no = formObj.vvd_cd.value.substring(4,8);
    	var skd_dir_cd = formObj.vvd_cd.value.substring(8);
    	
    	var rdPath = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
    	
    	 
    	var option = "";
    	var where = "";
    	
    	
    	if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
    	
    	option = "OPTION[VVD-" + formObj.vvd_cd.value + "/POL-" + formObj.pol_cd.value;
    	
    	where = " vsl_cd"+"["+ vsl_cd +"] "+"skd_voy_no"+"["+skd_voy_no+"] "+"skd_dir_cd"+"["+ skd_dir_cd +"] "
   	
    	
    	if (formObj.pol_cd.value !=""){
    		option = option + "/POL_-" + formObj.pol_cd.value;
    		where = where + "pol_cd" +"["+ formObj.pol_cd.value+"] " ;
    	}else{
    		where = where + "pol_cd[] ";
    	}
    	    	
    	if (formObj.pod_cd.value !=""){
    		option = option + "/POD_-" + formObj.pod_cd.value;
    		where = where + "POD_CD" +"["+  formObj.pod_cd.value+"] " ;
    	}else{
    		where = where + "pod_cd[] ";
    	}
    	if (formObj.por_cd.value !=""){
    		option = option + "/POR_-" + formObj.por_cd.value;
    		where = where + "POR_CD" +"["+ formObj.por_cd.value+"] " ;
    	}else{
    		where = where + "por_cd[] ";
    	}
    	
    	if (formObj.del_cd.value !=""){
    		option = option +"/DEL_-" + formObj.del_cd.value;
    		where = where + "DEL_CD" +"["+ formObj.del_cd.value+"] " ;
    	}else{
    		where = where + "del_cd[] ";
    	}
    	if (formObj.sls_ofc.value !=""){
    		option = option + "BKG_OFC-" + formObj.sls_ofc.value;
    		where = where + "OB_SLS_OFC_CD" +"["+ formObj.sls_ofc.value+"] " ;
    	}else{
    		where = where + "ob_sls_ofc_cd[] ";
    	}
    	if (formObj.bkg_ofc.value !=""){
    		option = option + "Sales_OFC-" + formObj.bkg_ofc.value;
    		where = where + "BKG_OFC_CD" +"["+formObj.bkg_ofc.value+"] " ;
    	}else{
    		where = where + "bkg_ofc_cd[] ";
    	}
    	if (formObj.trd_cd.value !=""){
    		option = option + "Trade-" + formObj.trd_cd.value;
    		where = where + "REV_DIR_CD" +"["+formObj.trd_cd.value+"] " ;
    	}else{
    		where = where + "rev_dir_cd[] ";
    	}
    	if (formObj.fr_dt.value !="" ){
    		if (ComGetObjValue(formObj.dt_chk) == "B"){
    			where = where + "add_from"+"[]";
    			where = where + "add_where"+"[ AND BK.BKG_CRE_DT BETWEEN TO_DATE(REPLACE('"+formObj.fr_dt.value+"','-',''),'YYYYMMDD') AND TO_DATE(REPLACE('"+formObj.to_dt.value+"','-',''),'YYYYMMDD')+0.99999]";
    		}else {
    			where = where + "add_from"+"[, BKG_BL_DOC BBD ]";
    			where = where + "add_where"+"[ AND BBD.BL_OBRD_DT BETWEEN TO_DATE(REPLACE('"+formObj.fr_dt.value+"','-',''),'YYYYMMDD') AND TO_DATE(REPLACE('"+formObj.to_dt.value+"','-',''),'YYYYMMDD')+0.99999 AND BK.BKG_NO = BBD.BKG_NO] ";
    		}
    	}else{
    		where = where + "add_from"+"[]";
    		where = where + "add_where"+"[]";
    	}
//    	option = option + "]";
//    	where = where + "]";

//    	alert("/rv " + where);
    	formObj.com_mrdPath.value = rdPath;
//    	/rv vsl_cd[CBRI] skd_voy_no[0035] skd_dir_cd[E] pol_cd[CNHKG] pod_cd[USLGB] por_cd[] del_cd[] ob_sls_ofc_cd[] bkg_ofc_cd[] rev_dir_cd[]

    	formObj.com_mrdArguments.value 	= "/rv " + where;
    	formObj.com_mrdTitle.value = "Freight &amp; Charge List by VVD";
    	formObj.com_mrdBodyTitle.value = "<span style='color:red'>Freight &amp; Charge List by VVD</span>";

    	
    	ComOpenRDPopup();
    }
    
	/**
	* from,to 기간 선택 달력 띄우기
	*/
	function callDatePop(val){
		var cal = new ComCalendarFromTo();
		if (val == 'BKG_DATE'){
		cal.select(form.fr_dt,  form.to_dt,  'yyyy-MM-dd');
		}
		
	}    
 
     /* 2010.02.02 version 1.0 */
	/* 개발자 작업  끝 */