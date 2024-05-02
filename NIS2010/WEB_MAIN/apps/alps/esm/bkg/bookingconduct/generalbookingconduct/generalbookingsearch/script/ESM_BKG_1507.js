/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1507.js
*@FileTitle : Allocation Stand by Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13 
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.01.13 문동선
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
     * @class ESM_BKG_1507 : ESM_BKG_1507 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1507() {
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
 
 var old_aloc_sts_cd = "";
 var save_flg = "N";

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             	 case "btn_ok":
             		 doActionIBSheet(sheetObject,formObject,MODIFY);
             		 break;
                 case "btn_Close":
                	 formObject.standby_ntc_flg.checked == false;
                	 manualCaseCheck();
                     window.close();
                     break;
                     
                   
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");     
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
     }

  	 function sheet1_OnLoadFinish(sheetObj) {  
  		if(ComGetObjValue(document.form.popup_msg_flg) != "Y"){
  			ComShowCodeMessage("BKG08285");
  		} 
  		
 		sheetObj.WaitImageVisible = false;   
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		sheetObj.WaitImageVisible = true;   
 		ComSetFocus(document.form.btn_ok);
 	 }   
  	 
  	 
  	 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                     style.height = 123;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(15, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle1 = "Seq.|VVD|Lane|POL/POD|Current L. OFC BKG Status vs. Allocation" 
                     					+"|Current L. OFC BKG Status vs. Allocation|Current L. OFC BKG Status vs. Allocation|Current L. OFC BKG Status vs. Allocation|Current L. OFC BKG Status vs. Allocation"
                    	 				+"|Overall Truck VVD BKG Status|Overall Truck VVD BKG Status|Overall Truck VVD BKG Status" 
                    	 				+"|rhq_ratio|aloc_svc_cd|other_remark";
                     var HeadTitle2 = "Seq.|VVD|Lane|POL/POD|L.RHQ|L.OFC|L.OFC\nAlloc.|BKG Vol.|vs.\nL.OFC\nAlloc.|L.RHQ\nVol.|BKG Vol.|vs.\nL.RHQ\nAlloc.|aloc_svc_cd|other_remark";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,      			40,    	daCenter,  true,      "item",       		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			80,   	daCenter,  true,      "vvd",     			false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			40,    	daCenter,  true,      "trnk_slan_cd",     	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			90,    	daCenter,  true,      "type",     	        false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			55,    	daCenter,  false,     "l_rhq",       		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			55,    	daCenter,  false,     "ob_sls_ofc_cd",     	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "l_ofc_alloc",       	false,          "",      dfNullInteger ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "bkg_lofc_vol",      	false,          "",      dfNullInteger ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "ofc_ratio",   		false,          "",      dfNone ,       	0,     false,     false);//
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "l_rhq_alloc",       	false,          "",      dfNullInteger ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "bkg_lrhq_vol",      	false,          "",      dfNullInteger ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			40,    	daCenter,  false,     "rhq_ratio",     		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,     			60,    	daCenter,  false,     "aloc_svc_cd",     	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,     			60,    	daCenter,  false,     "aloc_lod_qty_rto",   false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		0,    	daCenter,  false,     "other_remark",       false,          "",      dfNone ,       	0,     false,     false);
                     
                     SelectHighLight = false;
 					 CountPosition = 0;                     
                }
                 break;

              case 2:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 73;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(9, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle1 = "Seq.|VVD|Lane" 
                     				+ "|Current BKG Status vs. Allocation|Current BKG Status vs. Allocation|Current BKG Status vs. Allocation|Current BKG Status vs. Allocation"
                     				+ "|aloc_lod_qty|other_remark";
                     var HeadTitle2 = "Seq.|VVD|Lane|L.RHQ|L.RHQ\nAlloc.|BKG Vol.|vs. L.RHQ\nAlloc.|aloc_lod_qty|other_remark";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  true,     "vvd_seq",       		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			120,    daCenter,  true,     "vvd",       			false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  true,     "slan_cd",       		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "l_rhq",       		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "aloc_lod_qty",       false,          "",      dfNullInteger ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "teu_ttl",       		false,          "",      dfNullInteger ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "ts_ratio",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,     			0,    	daCenter,  false,     "aloc_lod_qty_rto",   false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		0,    	daCenter,  false,     "other_remark",       false,          "",      dfNone ,       	0,     false,     false);

                     //InitUserFormat(0, "ts_ratio", "AAAAA%", "%" );
                     SelectHighLight = false;
 					 CountPosition = 0;                     
                }
                 break;


               case 3:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 62;
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
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     var HeadTitle = "Type|POR|POL|POD|DEL|T/S PORT|Other";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtData,      			60,    	daCenter,  false,     "type",       		false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "por_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "pol_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "pod_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "del_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "ts_port_flag",       false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtCombo,      			40,    	daCenter,  false,     "other_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,     			60,    	daCenter,  false,     "por_remark",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		60,    	daCenter,  false,     "pol_remark",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		60,    	daCenter,  false,     "pod_remark",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		60,    	daCenter,  false,     "del_remark",       	false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		60,    	daCenter,  false,     "aloc_lod_qty",       false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		60,    	daCenter,  false,     "ts_port_remark",     false,          "",      dfNone ,       	0,     false,     false);
                     InitDataProperty(0, cnt++ , dtHidden,      		60,    	daCenter,  false,     "other_remark",       false,          "",      dfNone ,       	0,     false,     false);

                     InitComboNoMatchText(true);//Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
                     InitDataCombo(0, "por_flag", "N|Restricted", "N|Y");
                     InitDataCombo(0, "pol_flag", "N|Restricted", "N|Y");
                     InitDataCombo(0, "pod_flag", "N|Restricted", "N|Y");
                     InitDataCombo(0, "del_flag", "N|Restricted", "N|Y");
                     InitDataCombo(0, "ts_port_flag", "N|Restricted", "N|Y");
                     InitDataCombo(0, "other_flag", "N|Restricted", "N|Y");
                     
                     SelectHighLight = false;
 					 CountPosition = 0;                     
                }
                 break;
                 
           case 4:      //t1sheet1 init
               with (sheetObj) {

                   // 높이 설정
                   style.height = 42;
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
                   InitColumnInfo(14, 0, 0, true);

                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                   InitHeadMode(true, true, false, true, false,false);

                   var HeadTitle = "Cust. Code|S/C No.|Cust. Name|Trunk VVD|T/S VVD|EQ|Commodity|Other";

                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   InitHeadRow(0, HeadTitle, true);

                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   InitDataProperty(0, cnt++ , dtData,      			100,    	daCenter,  false,     "cust_cd",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtData,      			100,    	daCenter,  false,     "sc_no",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtData,      			180,    	daCenter,  false,     "cust_nm",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtCombo,      			80,    	daCenter,  false,     "trunk_vvd_flag",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "ts_vvd_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtCombo,      			60,    	daCenter,  false,     "eq_flag",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtCombo,      			80,    	daCenter,  false,     "commodity_flag",       	false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtCombo,      			40,    	daCenter,  false,     "other_flag",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtHidden,      			60,    	daCenter,  false,     "trunk_vvd_remark",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtHidden,      			60,    	daCenter,  false,     "ts_vvd_remark",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtHidden,      			60,    	daCenter,  false,     "eq_remark",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtHidden,      			60,    	daCenter,  false,     "commodity_remark",       	false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtHidden,      			60,    	daCenter,  false,     "other_remark",       		false,          "",      dfNone ,       	0,     false,     false);
                   InitDataProperty(0, cnt++ , dtHidden,      			60,    	daCenter,  false,     "bkg_aloc_tp_cd",       	false,          "",      dfNone ,       	0,     false,     false);
                   
                   InitComboNoMatchText(true);//Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
                   InitDataCombo(0, "trunk_vvd_flag", "N|Restricted", "N|Y");
                   InitDataCombo(0, "ts_vvd_flag", "N|Restricted", "N|Y");
                   InitDataCombo(0, "eq_flag", "N|Restricted", "N|Y");
                   InitDataCombo(0, "commodity_flag", "N|Restricted", "N|Y");
                   InitDataCombo(0, "other_flag", "N|Restricted", "N|Y");
                   
                   SelectHighLight = false;
                   CountPosition = 0;                     
                  }
                   break; 
         }
     }

   // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) 
         {
            case IBSEARCH: //조회
            	if(validateForm(formObj, IBSEARCH)){
	            	var param = "f_cmd=" + SEARCH + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
	            	var sXml = sheetObj.GetSearchXml("ESM_BKG_1507GS.do", param);  
	            	
	            	var arrXml = sXml.split("|$$|");  
	    			for(var i = 0 ; i < arrXml.length ; i++){
	    				sheetObjects[i].LoadSearchXml(arrXml[i]);
	    			}  
	    			
	    			ComSetObjValue(formObj.aloc_sts_cd,    ComGetEtcData(arrXml[0], "ALOC_STS_CD"));
	    			ComSetObjValue(formObj.aloc_svc_cd,    ComGetEtcData(arrXml[0], "ALOC_SVC_CD"));
	    			ComSetObjValue(formObj.bkg_aloc_tp_cd, ComGetEtcData(arrXml[0], "BKG_ALOC_TP_CD"));
	    			
	    			if(ComGetObjValue(formObj.aloc_svc_cd) == "A"){
	    				formObj.aloc_sts_cd[0].disabled = true;
		    			formObj.aloc_sts_cd[1].disabled = true;
	    			}else{
	    				if(ComGetObjValue(formObj.aloc_sts_cd)!='' && ComGetObjValue(formObj.aloc_sts_cd)!=null){
		            		old_aloc_sts_cd = ComGetObjValue(formObj.aloc_sts_cd);
		            	}else{
		            		ComSetObjValue(formObj.aloc_sts_cd, "S");
		            	}
	    			}
            	}
                break;
                
            case MODIFY: //저장 
            	save_flg = "Y";
            	if(validateForm(formObj, MODIFY)){
            		sheetObj.WaitImageVisible = false;   
                	ComOpenWait(true);
                	
                	if(ComGetObjValue(formObj.aloc_sts_cd) == "F"){
                		ComSetObjValue(formObj.aloc_svc_cd,"");
                		ComSetObjValue(formObj.bkg_aloc_tp_cd,"");
                	}
            		
            		var param = "?f_cmd=" + MODIFY01 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) +
            					"&aloc_sts_cd=" + ComGetObjValue(formObj.aloc_sts_cd) + 
            					"&aloc_svc_cd=" + ComGetObjValue(formObj.aloc_svc_cd) +
            					"&bkg_aloc_tp_cd=" + ComGetObjValue(formObj.bkg_aloc_tp_cd) +
            					"&before_aloc_sts_cd=" + ComGetObjValue(formObj.before_aloc_sts_cd) +
            					//(0229_01 용)
            					"&auto_notification=" + ComGetObjValue(formObj.auto_notification) + 
            					"&doc_tp_cd=" + ComGetObjValue(formObj.doc_tp_cd) +
            					"&bkg_cntc_pson_eml=" + ComGetObjValue(formObj.bkg_cntc_pson_eml) +
            					"&si_cntc_pson_eml=" + ComGetObjValue(formObj.si_cntc_pson_eml) +
            					//RecieptNotice안나가게
            					"&receipt_ntc_flg=N";
            		
            		if(formObj.standby_ntc_flg.checked == true){
            			param = param + "&standby_ntc_flg=Y";
            		}else{
            			param = param + "&standby_ntc_flg=N";
            		}
            		
            		var sXml = sheetObj.GetSaveXml("ESM_BKG_0102GS.do" + param);
            		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
                		ComShowCodeMessage("BKG00166");// "Data Saved Successfully!!"
                		
                		if(ComGetEtcData(sXml, "firm_msg_flg") == "Y"){
    						ComShowCodeMessage("BKG08300");
    					}
                		
                		window.close();
                	}else{
                		ComShowCodeMessage("BKG00167");// "Data Save Action Failed!!"
                	}
            		
                	ComOpenWait(false);
                	sheetObj.WaitImageVisible = false;
            	}
            	window.close();
            	break;
         }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리(Save) 
     */
    function validateForm(formObj, sAction){
    	var bkgNo = formObj.bkg_no.value;
        switch(sAction) {
    		case IBSEARCH: 
	    		if((ComGetObjValue(formObj.bkg_no) == 'undefined')|| bkgNo==null || bkgNo.length==0){
	    			ComShowCodeMessage("BKG00463");//"BKG no does not exist for retrival."
	    			return false;
	    		}
	    		return true;
	    		break;
    		case MODIFY:
    			if((ComGetObjValue(formObj.bkg_no) == 'undefined')|| bkgNo==null || bkgNo.length==0){
	    			ComShowCodeMessage("BKG00651","BKG No.");//"{?msg1} is invalid."
	    			return false;
	    		}
//    			if(ComGetObjValue(formObj.aloc_svc_cd)=="A"){
//    				// 저장 안함
//    				return false;
//    			}
    			if(ComGetObjValue(formObj.aloc_sts_cd)==""){
    				ComShowCodeMessage("BKG00651","Allocation Status");//"{?msg1} is invalid."
	    			return false;
	    		}
    			if(	ComGetObjValue(formObj.aloc_pop_flg)=="Y" 
    	    		&& ComGetObjValue(formObj.before_aloc_sts_cd)!="S"
    	    		&& old_aloc_sts_cd=="S"	){
    				return true;
    			}
    			if(old_aloc_sts_cd != "" && old_aloc_sts_cd == ComGetObjValue(formObj.aloc_sts_cd)){
    				// 조회 값과 같으면 저장 안함
    				return false;
    			}
    			return true;
    			break;
        }
    }
	    		
	    		
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	 if(sheetObj.RowCount("R")>0){
 			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
 				if(sheetObj.CellValue(i,"aloc_lod_qty_rto") != ""
 						&& sheetObj.CellValue(i,"aloc_lod_qty_rto")*1 < sheetObj.CellValue(i,"ofc_ratio")*1){
 					sheetObj.CellFontColor(i, "ofc_ratio") = sheetObj.RgbColor(255,0,0);
 				}
 				if(sheetObj.CellValue(i,"aloc_lod_qty_rto") != ""
 						&& sheetObj.CellValue(i,"aloc_lod_qty_rto")*1 < sheetObj.CellValue(i,"rhq_ratio")*1){
 					sheetObj.CellFontColor(i, "rhq_ratio") = sheetObj.RgbColor(255,0,0);
 				}
// 				if(sheetObj.CellValue(i,"l_ofc_alloc") == "0"){
// 					sheetObj.CellFontColor(i, "l_ofc_alloc") = sheetObj.RgbColor(255,0,0);
// 				}
// 				if(sheetObj.CellValue(i,"l_rhq_alloc") == "0"){
// 					sheetObj.CellFontColor(i, "l_rhq_alloc") = sheetObj.RgbColor(255,0,0);
// 				}
 				if(sheetObj.CellValue(i, "ofc_ratio")!=""){
 					sheetObj.CellValue(i, "ofc_ratio") = sheetObj.CellValue(i, "ofc_ratio")+"%";
 				}
 				if(sheetObj.CellValue(i, "rhq_ratio")!=""){
 					sheetObj.CellValue(i, "rhq_ratio") = sheetObj.CellValue(i, "rhq_ratio")+"%";
 				}
 				if(sheetObj.CellValue(i, "type")!="ALL"){
 					if(sheetObj.CellValue(i,"other_remark").length == 5) {
 						if (sheetObj.CellValue(i, "type")=="Multi POL"){
 							sheetObj.CellValue(i,"type") = sheetObj.CellValue(i,"other_remark")+"/     ";
 						} else if (sheetObj.CellValue(i, "type")=="Multi POD"){
 							sheetObj.CellValue(i,"type") = "     /"+sheetObj.CellValue(i,"other_remark");
 						}
 						
 					} else {
 	 					sheetObj.ToolTipText(i,"type")   = sheetObj.CellValue(i,"other_remark");
 	 					sheetObj.CellFontColor(i, "type") = sheetObj.RgbColor(0,0,255);
 					}
 				}
 			}
 		}
 	} 
     
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	 if(sheetObj.RowCount("R")>0){
 			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
 				if(sheetObj.CellValue(i,"ts_ratio")*1 > sheetObj.CellValue(i,"aloc_lod_qty_rto")*1){
 					sheetObj.CellFontColor(i, "ts_ratio") = sheetObj.RgbColor(255,0,0);
 					sheetObj.ToolTipText(i,"ts_ratio")   = sheetObj.CellValue(i,"other_remark");
 				}
 				if(sheetObj.CellValue(i, "ts_ratio")!=""){
 					sheetObj.CellValue(i, "ts_ratio") = sheetObj.CellValue(i, "ts_ratio")+"%";
 				}
 			}
 		}
 	}      
     
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount("R")>0){
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				sheetObj.ToolTipText(i,"por_flag")     = sheetObj.CellValue(i,"por_remark");
				sheetObj.ToolTipText(i,"pol_flag")     = sheetObj.CellValue(i,"pol_remark");
				sheetObj.ToolTipText(i,"pod_flag")     = sheetObj.CellValue(i,"pod_remark");
				sheetObj.ToolTipText(i,"del_flag")     = sheetObj.CellValue(i,"del_remark");
				sheetObj.ToolTipText(i,"ts_port_flag") = sheetObj.CellValue(i,"ts_port_remark");
				sheetObj.ToolTipText(i,"other_flag")   = sheetObj.CellValue(i,"other_remark");
				
				if(sheetObj.CellValue(i,"por_flag")=='Y')
					sheetObj.CellFontColor(i, "por_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"pol_flag")=='Y')
					sheetObj.CellFontColor(i, "pol_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"pod_flag")=='Y')
					sheetObj.CellFontColor(i, "pod_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"del_flag")=='Y')
					sheetObj.CellFontColor(i, "del_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"ts_port_flag")=='Y')
					sheetObj.CellFontColor(i, "ts_port_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"other_flag")=='Y')
					sheetObj.CellFontColor(i, "other_flag") = sheetObj.RgbColor(255,0,0);
			}
		}
	}
	
	function sheet4_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount("R")>0){
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				sheetObj.ToolTipText(i,"trunk_vvd_flag") = sheetObj.CellValue(i,"trunk_vvd_remark");
				sheetObj.ToolTipText(i,"ts_vvd_flag")    = sheetObj.CellValue(i,"ts_vvd_remark");
				sheetObj.ToolTipText(i,"eq_flag")        = sheetObj.CellValue(i,"eq_remark");
				sheetObj.ToolTipText(i,"commodity_flag") = sheetObj.CellValue(i,"commodity_remark");
				sheetObj.ToolTipText(i,"other_flag")     = sheetObj.CellValue(i,"other_remark");
				
				if(sheetObj.CellValue(i,"trunk_vvd_flag")=='Y')
					sheetObj.CellFontColor(i, "trunk_vvd_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"ts_vvd_flag")=='Y')
					sheetObj.CellFontColor(i, "ts_vvd_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"eq_flag")=='Y')
					sheetObj.CellFontColor(i, "eq_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"commodity_flag")=='Y')
					sheetObj.CellFontColor(i, "commodity_flag") = sheetObj.RgbColor(255,0,0);
				if(sheetObj.CellValue(i,"other_flag")=='Y')
					sheetObj.CellFontColor(i, "other_flag") = sheetObj.RgbColor(255,0,0);
			}
		}
	}
	
	function manualCaseCheck(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		if(ComGetObjValue(formObject.aloc_pop_flg)=="Y" 
    		&& ComGetObjValue(formObject.before_aloc_sts_cd)!="S"
    		&& old_aloc_sts_cd=="S"	
    		&& save_flg == "N"){
    		ComSetObjValue(formObject.aloc_sts_cd,"S");
    		doActionIBSheet(sheetObject,formObject,MODIFY);
    	} 
	}

	/* 개발자 작업  끝 */