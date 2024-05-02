/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0003.js
*@FileTitle : Segregation Table (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.27 이도형
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
     * @class vop_scg_0003 : vop_scg_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0003() {
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

    var tabLoad = new Array();
    tabLoad[0]= 0;
    tabLoad[1]= 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var formObject = document.form;          
    	/*******************************************************/

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

     			case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;

				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;

				case "btn_t1RowAdd":
					if (ComIsBtnEnable("btn_t1RowAdd")) sheetObjects[0].DataInsert(-1);
					break;
				
				case "btn_t1RowInsert":
					if (ComIsBtnEnable("btn_t1RowInsert")) sheetObjects[0].DataInsert();
					break; 
				
				case "btn_t1RowCopy":
					if (ComIsBtnEnable("btn_t1RowCopy")) sheetObjects[0].DataCopy();
					break;
					
				case "btn_t1RowDelete":
					if (ComIsBtnEnable("btn_t1RowDelete")) ComRowHideDelete(sheetObjects[0], "del_chk");
					break;	
 					
     			case "btn_t2RowAdd":
     				if (ComIsBtnEnable("btn_t2RowAdd")) sheetObjects[1].DataInsert(-1);
					break;
				
				case "btn_t2RowInsert":
					if (ComIsBtnEnable("btn_t2RowInsert")) sheetObjects[1].DataInsert();
					break; 
				
				case "btn_t2RowCopy":
					if (ComIsBtnEnable("btn_t2RowCopy")) sheetObjects[1].DataCopy();
					break;
					
				case "btn_t2RowDelete":
					if (ComIsBtnEnable("btn_t2RowDelete")) ComRowHideDelete(sheetObjects[1], "del_chk");
					break;	
				
				case "btns_Numbers&Symbols":
					ComOpenWindowCenter("VOP_SCG_1003_01.do", "VOP_SCG_1003_01", 705, 345, true);
					break;

				case "btns_PermittedMixedStowageOfClass1":
					ComOpenWindowCenter("VOP_SCG_1003_02.do", "VOP_SCG_1003_02", 705, 390, true);
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

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
     }

     function t1sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         
         //Segregation Table의 Matrix가 Fixed된 상태임으로 현재는 Disable시킨다. 
         ComBtnDisable('btn_t1RowAdd');
         ComBtnDisable('btn_t1RowInsert');
         ComBtnDisable('btn_t1RowCopy');
         ComBtnDisable('btn_t1RowDelete');
         ComBtnDisable('btn_t2RowAdd');
         ComBtnDisable('btn_t2RowInsert');
         ComBtnDisable('btn_t2RowCopy');
         ComBtnDisable('btn_t2RowDelete');
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
    	 			style.height = 440;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
         			Editable = true;

         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 1, 1, 20, 100);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(23, 0, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(false, false, false, true, false,false)

         			var HeadTitle = "|Sel.|Class|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9";

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
    	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,		daCenter,   true,   "del_chk",			false,  "",      dfNone,      		0,     true,       true);
         			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"row_imdg_clss_cd",	true,	"",      dfNone, 			0,     false,      true,	3);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_11",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_12",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_15",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_13",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_16",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_14",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_21",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_22",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_23",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_3",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_41",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_42",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_43",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_51",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_52",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_61",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_62",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_7",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_8",     	false,  "",      dfNone, 			0,     true,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	false,	"clss_cd_9",     	false,  "",      dfNone, 			0,     true,       true,	1);
 						
         			InitDataValid(0, 3, vtNumericOther, "X*");
					InitDataValid(0, 4, vtNumericOther, "X*");
					InitDataValid(0, 5, vtNumericOther, "X*");
					InitDataValid(0, 6, vtNumericOther, "X*");
					InitDataValid(0, 7, vtNumericOther, "X*");
					InitDataValid(0, 8, vtNumericOther, "X*");
					InitDataValid(0, 9, vtNumericOther, "X*");
					InitDataValid(0, 10, vtNumericOther, "X*");
					InitDataValid(0, 11, vtNumericOther, "X*");
					InitDataValid(0, 12, vtNumericOther, "X*");
					InitDataValid(0, 13, vtNumericOther, "X*");
					InitDataValid(0, 14, vtNumericOther, "X*");
					InitDataValid(0, 15, vtNumericOther, "X*");
					InitDataValid(0, 16, vtNumericOther, "X*");
					InitDataValid(0, 17, vtNumericOther, "X*");
					InitDataValid(0, 18, vtNumericOther, "X*");
					InitDataValid(0, 19, vtNumericOther, "X*");
					InitDataValid(0, 20, vtNumericOther, "X*");
					InitDataValid(0, 21, vtNumericOther, "X*");
					InitDataValid(0, 22, vtNumericOther, "X*");
					
					//CountPosition = 0;
                }
                 break;


         	case 2:      //t2sheet1 init
         		with (sheetObj) {
         			// 높이 설정
         			style.height = 410;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msNone;

         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = true;

         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 1, 1, 3, 100);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(16, 0, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(false, false, false, true, false,false)

         			var HeadTitle = "|Sel.|Compatibility\ngrorp|A|B|C|D|E|F|G|H|J|K|L|N|S";

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
    	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,		daCenter,   true,   "del_chk",				false,  "",      dfNone,      		0,     true,       true);
         			InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,	"row_imdg_comp_grp_cd",	true,	"",      dfNone, 			0,     false,      true,	1);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_a",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_b",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_c",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_d",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_e",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_f",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_g",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_h",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_j",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_k",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_l",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_n",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			64,		daCenter,	false,	"segr_cd_s",     		false,  "",      dfNone, 			0,     true,       true,	2);
         			
         			InitDataValid(0, 3, vtNumericOther, "X");
					InitDataValid(0, 4, vtNumericOther, "X");
					InitDataValid(0, 5, vtNumericOther, "X");
					InitDataValid(0, 6, vtNumericOther, "X");
					InitDataValid(0, 7, vtNumericOther, "X");
					InitDataValid(0, 8, vtNumericOther, "X");
					InitDataValid(0, 9, vtNumericOther, "X");
					InitDataValid(0, 10, vtNumericOther, "X");
					InitDataValid(0, 11, vtNumericOther, "X");
					InitDataValid(0, 12, vtNumericOther, "X");
					InitDataValid(0, 13, vtNumericOther, "X");
					InitDataValid(0, 14, vtNumericOther, "X");
					InitDataValid(0, 15, vtNumericOther, "X");
 						
					//CountPosition = 0;
                }
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBSEARCH:      //조회

         		if(validateForm(sheetObj,formObj,sAction)) {

     				formObj.f_cmd.value = SEARCH;
	    			var sXml = sheetObj.GetSearchXml("VOP_SCG_0003GS.do", FormQueryString(formObj));    			
	    			var arrXml = sXml.split("|$$|");
    			
	    			for(var inx=0; inx<arrXml.length; inx++){
	    				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
	    			}
         		}
         		break;

 			 case IBSAVE:        //저장
               if(validateForm(sheetObj,formObj,sAction)) {
            	   //if(!ComShowCodeConfirm('SCG50001', 'data')) return;            		
            	   formObj.f_cmd.value = MULTI;
            	   var sParam = ComGetSaveString(sheetObjects);
            	   if (sParam == "") return;
            	   sParam += "&" + FormQueryString(formObj);
            	   sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_"); 
            	   sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_"); 
            	   var sXml = sheetObj.GetSaveXml("VOP_SCG_0003GS.do", sParam); 
            	   sheetObj.LoadSaveXml(sXml);
               }
               break;

 			 case IBROWSEARCH:
 				 if (sheetObj.id == "t1sheet1") {
 	 				formObj.f_cmd.value = SEARCH;				
 					var sXml = sheetObj.GetSearchXml("VOP_SCG_0046GS.do" , FormQueryString(formObj)+"&imdg_segr_tp_cd=C"+"&imdg_segr_cd="+sheetObj.EditValue);				
 	    		    var arrData = ComScgXml2Array(sXml, "imdg_segr_cd");
 	    		    if (arrData != null && arrData.length > 0) {
 					}else{
 						ComShowCodeMessage('SCG50010', 'Data');
 					    sheetObj.SelectCell(Row, Col, true, "");
  						return false;
 					} 					 
 				 }else
 				 if (sheetObj.id == "t2sheet1") {
  	 				formObj.f_cmd.value = SEARCH;
  	 				var segrCd = "";
  	 				if (sheetObj.EditValue.length > 1 && sheetObj.EditValue.substring(0,1) == "X"){
  	 					segrCd = sheetObj.EditValue.substring(1,2);
  	 				}else{
  	 					segrCd = sheetObj.EditValue;
  	 				}
  					var sXml = sheetObj.GetSearchXml("VOP_SCG_0046GS.do" , FormQueryString(formObj)+"&imdg_segr_tp_cd=P"+"&imdg_segr_cd="+segrCd);				
  	    		    var arrData = ComScgXml2Array(sXml, "imdg_segr_cd");
  	    		    if (arrData != null && arrData.length > 0) {
  					}else{
  						ComShowCodeMessage('SCG50010', 'Data');
 					    sheetObj.SelectCell(Row, Col, true, "");
  						return false;
  					} 					 
  				 }
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

     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "Between Various Classes" , -1 );
                     InsertTab( cnt++ , "Within Class 1" , -1 );
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
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE){
    		 var msg1 = "";
    		 var msg2 = "";
    		 for (var ir=1; ir<=sheetObjects[0].LastRow-1; ir++){
   				if(sheetObjects[0].CellValue(ir,"ibflag") != "R") {
   					msg1 += sheetObjects[0].CellValue(ir,"row_imdg_clss_cd")+", ";
   				}
    		 }
    		 
    		 if (msg1 != "") {
    			 msg1 = msg1.substring(0,msg1.length-2);
    			 if(ComShowCodeConfirm('SCG50014')) {
    				 return true;
    			 }else{
    				 return false;
    			 }
    		 }

    		 for (var ir=1; ir<=sheetObjects[1].LastRow-1; ir++){
    				if(sheetObjects[1].CellValue(ir,"ibflag") != "R") {
    					msg2 += sheetObjects[1].CellValue(ir,"row_imdg_comp_grp_cd")+", ";
    				}
     		 }

    		 if (msg2 != "") {
     			 msg2 = msg2.substring(0,msg2.length-2);
     			 if(ComShowCodeConfirm('SCG50014')) {
     				 return true;
    			 }else{
    				 return false;
     			 }
     		 }
    	 }
    	 return true;
     }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function t1sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	 if (Col != 1) {
    		 if (sheetObj.EditValue != "" && KeyCode != 229) {
    			 doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
    		 }
    	 }
     }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function t2sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	 if (Col != 1) {
    		 if (sheetObj.EditValue != "" && sheetObj.EditValue != "X" && KeyCode != 229) {
    			 doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
    		 }
    	 }
     }
     
     /* 개발자 작업  끝 */