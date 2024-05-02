/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0413.js
*@FileTitle : BKG/MVMT VL/VD Unmatch
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.18 우경민
* 1.0 Creation
* =========================================================
* history
* 2012.11.07 문동선 [CHM-201221016] [CTM] BKG/MVMT VL unmatched 에서 Local/TS 확인기능 보완
* 2014.03.10 박다은 [CHM-201428741]	CTM: Stowage Plan POD (BKG/MVMT VL/VD unmatch Inquiry)
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
     * @class EES_CTM_0413 : EES_CTM_0413 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0413() {
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
 
//IBMultiCombo
 var comboList;
 var comboObjects = new Array();
 var combo1 = null;
 var comboCnt = 0;
 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {


 		         case "btn_retrieve":
                     if (checkFormField())
                    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	 break;

 		         case "btn_new":
  					formObject.reset();
 					sheetObjects[0].RemoveAll();
 					sheetObjects[1].RemoveAll();
 					combo1.RemoveAll();
 					combo1.Enable = false;
 					break;

 		         case "btn_downexcel":
 		        	sheetObjects[0].SpeedDown2Excel(-1);
 		        	
 					break;

 		         case "btn_detail":
 		        	 row = sheetObjects[0].SelectRow;
 		        	 if (row < 1) return;
 		        	 cntr_no = sheetObjects[0].CellValue(row, "cntr_no");
 		        	 tpsz_cd = sheetObjects[0].CellValue(row, "cntr_tpsz_cd");
 		        	 cntrNo = cntr_no.substring(0,10);
 		        	 checkDigit = cntr_no.substring(10,11);
 		        	 sUrl = "EES_CTM_0408.do?p_cntrno=" + cntrNo + "&check_digit=" + checkDigit + "&ctnr_tpsz_cd=" + tpsz_cd;
 		        	 iWidth = "1020";
 		             iHeight = "682";
 		             bModal = false;
                     // 별도 팝업 필요
					 obj = ComOpenWindowCenter(sUrl + "&pop_mode=1", "EES_CTM_0408", iWidth, iHeight, bModal);
                     break;

 		         case "btn_downexcel2":
 		        	 sheetObjects[1].SpeedDown2Excel(-1);
 		        	 break;

 		         case "btn_detail2":
 		        	 row = sheetObjects[1].SelectRow;
 		        	 if (row < 1) return;
 		        	 cntr_no = sheetObjects[1].CellValue(row, "cntr_no");
 		        	 tpsz_cd = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");
 		        	 cntrNo = cntr_no.substring(0,10);
 		        	 checkDigit = cntr_no.substring(10,11);
 		        	 sUrl = "EES_CTM_0408.do?p_cntrno=" + cntrNo + "&check_digit=" + checkDigit + "&ctnr_tpsz_cd=" + tpsz_cd;
 		        	 iWidth = "1020";
 		             iHeight = "682";
 		             bModal = false;
                     // 별도 팝업 필요
					 obj = ComOpenWindowCenter(sUrl + "&pop_mode=1", "EES_CTM_0408", iWidth, iHeight, bModal);
 		        	 break;

 		         case "btn_unmatch":
 		        	//ComOpenWait(true);
 		        	var sxml = CtmMakeHiddenXml(sheetObjects[0], "1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat|mat_pod|mat_cntr_pod");
 		        	//ComDebug(sxml);
 		        	sheetObjects[0].LoadSearchXml(sxml);

 		        	var sxml = CtmMakeHiddenXml(sheetObjects[1], "1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|pod_cd|mat|mat_pod|mat_cntr_pod");
 		        	//ComDebug(sxml);
 		        	sheetObjects[1].LoadSearchXml(sxml);

 		             document.form.u1.className = 'Obj1';
 		        	 document.form.u2.className = 'Obj1';
		        	 document.form.m1.className = 'Obj2';
 		        	 document.form.m2.className = 'Obj2';
 		        	 document.form.l1.className = 'Obj2';
 		        	 document.form.l2.className = 'Obj2';

 		        	//ComOpenWait(false);
 		        	var div_1= ComGetObjValue(formObject.flgrslt);
          	      	var div_2 = ComGetObjValue(formObject.mv_type);
 		        	if(div_1 == 'PD' && div_2 == 'B'){
 		        		rowColorChange_unmatch();
 		        	}
					break;

 		         case "btn_match":
 		        	if (sheetObjects[0].LastRow == 0) return;
 		        	//ComOpenWait(true);
 		        	var sxml = CtmMakeHiddenXml(sheetObjects[0], "0", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat|mat_pod|mat_cntr_pod");
 		        	//ComDebug(sxml);
 		        	sheetObjects[0].LoadSearchXml(sxml);

 		        	var sxml = CtmMakeHiddenXml(sheetObjects[1], "0", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|pod_cd|mat|mat_pod|mat_cntr_pod");
 		        	//ComDebug(sxml);
 		        	sheetObjects[1].LoadSearchXml(sxml);

		        	 document.form.m1.className = 'Obj1';
 		        	 document.form.m2.className = 'Obj1';
 		        	 document.form.u1.className = 'Obj2';
 		        	 document.form.u2.className = 'Obj2';
 		        	 document.form.l1.className = 'Obj2';
 		        	 document.form.l2.className = 'Obj2';

 		        	//ComOpenWait(false);
 		        	var div_1= ComGetObjValue(formObject.flgrslt);
          	      	var div_2 = ComGetObjValue(formObject.mv_type);
 		        	if(div_1 == 'PD' && div_2 == 'B'){
 		        		rowColorChange_unmatch();
 		        	}
					break;

 		         case "btn_total":
  		        	 sheetObjects[0].Redraw = false;
 		        	 sheetObjects[1].Redraw = false;
 		        	 sheetObjects[0].ColHidden("Seq") = false;
 		        	 sheetObjects[1].ColHidden("Seq") = false;
  		        	 sheetObjects[0].ColHidden("sno") = true;
 		        	 sheetObjects[1].ColHidden("sno") = true;
  		        	var sxml = CtmMakeHiddenXml(sheetObjects[0], "-1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat|mat_pod|mat_cntr_pod");
 		        	//ComDebug(sxml);
 		        	sheetObjects[0].LoadSearchXml(sxml);

 		        	var sxml = CtmMakeHiddenXml(sheetObjects[1], "-1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|pod_cd|mat|mat_pod|mat_cntr_pod");
 		        	//ComDebug(sxml);
 		        	sheetObjects[1].LoadSearchXml(sxml);

 		        	 document.form.l1.className = 'Obj1';
 		        	 document.form.l2.className = 'Obj1';
		        	 document.form.m1.className = 'Obj2';
 		        	 document.form.m2.className = 'Obj2';
 		        	 document.form.u1.className = 'Obj2';
 		        	 document.form.u2.className = 'Obj2';
  		        	 sheetObjects[0].Redraw = true;
  		        	var div_1= ComGetObjValue(formObject.flgrslt);
          	      	var div_2 = ComGetObjValue(formObject.mv_type);
  		        	if(div_1 == 'PD' && div_2 == 'B'){
  		        	 rowColorChange_unmatch();
  		        	}
 		        	 sheetObjects[1].Redraw = true;
					 break;

                case "btn_close":
                    window.close();
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
         obj = document.form.flgrslt;
         //obj.attachEvent("onclick", eval("flgslt_click"));
         axon_event.addListener( 'click' , 'flgslt_click'   , "flgrslt" );
         axon_event.addListener( 'click' , 'mv_type_click'   , "mv_type" );
         axon_event.addListener( 'change' , 'mv_type_change' , "mv_type" );
         axon_event.addListener('blur', 'getEtaEtdTime', 'vls_cd');
         axon_event.addListener('blur', 'getEtaEtdTime', 'pol_cd');
         setEventProcess();
         
         combo1 = comboObjects[0]
         comboCnt = comboObjects.length;
      
         // IBMultiCombo초기화
         for(var j=0; j<comboObjects.length; j++){
             initCombo(comboObjects[j]);
         }
         
         combo1.Enable = false;
         
         //objs = document.form.locl_type; //[CHM-201221016]
         //objs[0].disabled = true;
         //objs[1].disabled = true;
         //objs[2].disabled = true;
         if (document.form.vls_cd.value != '')
        	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         else
        	 document.form.vls_cd.focus();

         //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
     }

	 /*
	  * 기준 칼럼의 값에 따라 XML String을 만들어서 리턴한다. Row단위로 Hide시키는것보다 빠름
	  * @param sheet_obj
	  * @param pMatch     : MATCH는 Grid값이 1이기 때문에 0을 UNMATCH는 1을 가진다 TOTAL은 -1을 가진다
	  * @saveColName      : 기준 칼럼
	  */
      function CtmMakeHiddenXml(sheet_obj, pMatch, saveColName)  {
          try {
        	  var formObj = document.form;
              var allXml = "";
              var sColSep = "•";
              var sColOrder = "";
              if (saveColName!=undefined && saveColName != null && saveColName!="") {
                  sColOrder = " COLORDER='" + saveColName + "' ";
              }

              allXml = "<?xml version='1.0'  ?>\n"
                     + "<SHEET>\n"
              allXml += "  <DATA " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
              var aryTRs = "";
              var sheetText = sheet_obj.GetRangeText(sheet_obj.HeaderRows,0,sheet_obj.LastRow,sheet_obj.LastCol,sColSep,"^");
              var aryTRs = sheetText.split("^");
                            
    	      var div_1= ComGetObjValue(formObj.flgrslt);
    	      
      	      var div_2 = ComGetObjValue(formObj.mv_type);
      	      	
      	   		if(div_1 == 'PD' && div_2 == 'B'){
      	   			for (var i in aryTRs) {
      	   				if(sheet_obj.CellValue(parseInt(i)+sheet_obj.HeaderRows, "mat_cntr_pod") == pMatch)
      	   					aryTRs[i] = "<TR HIDDEN=\"TRUE\"><![CDATA["+aryTRs[i]+"]]></TR>";
      	   				else
      	   					aryTRs[i] = "<TR><![CDATA["+aryTRs[i]+"]]></TR>";
      	   			}	
      	   		}else{
      	   			for (var i in aryTRs) {
      	   				if(sheet_obj.CellValue(parseInt(i)+sheet_obj.HeaderRows, "mat") == pMatch)
      	   					aryTRs[i] = "<TR HIDDEN=\"TRUE\"><![CDATA["+aryTRs[i]+"]]></TR>";
      	   				else
      	   					aryTRs[i] = "<TR><![CDATA["+aryTRs[i]+"]]></TR>";
      	   			}	
      	   		}
      	   	
              allXml += aryTRs.join("\n");
              allXml += "  </DATA>\n"
                     +  "</SHEET>";
              return allXml;
              
          } catch(err) { ComFuncErrMsg(err.message); }
      }

      /**
      * ETA/ETD 조회
      */
     function getEtaEtdTime() {
     	formObj = document.form;
		if (formObj.pol_cd.value == '') return;
		if (formObj.vls_cd.value == '') return;
     	strQuery  =  "f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.vls_cd.value
		if (formObj.flgrslt[0].checked) {
			strQuery  =  strQuery + "&p_pol=" + formObj.pol_cd.value;
			strQuery  =  strQuery + "&p_pod=";
		} else {
			strQuery  =  strQuery + "&p_pod=" + formObj.pol_cd.value;
			strQuery  =  strQuery + "&p_pol=";
		}
		rtnXml = sheetObjects[0].GetSearchXml("EES_CTM_0406GS.do",  strQuery );
		rtnValue = ComGetEtcData(rtnXml, "rtnStr");
		rtnStr = rtnValue.split("|");
		if (formObj.flgrslt[0].checked)
			str = rtnStr[0];
		else
			str = rtnStr[1];
		formObj.eta_etd.value = str;
     }

     /**
      * 라이오 버튼 클릭시 화면 제어
      */

     function mv_type_click() {
    	 ibj = document.form.mv_type;
		 obj = document.form.locl_type;
		 
		 assembleSheetColumn(sheetObjects[1], formObj);
		 
    	 if (ibj[0].checked == true){
    		 obj[0].checked = true;
			 obj[0].disabled = false;
			 obj[1].disabled = false;
			 obj[2].disabled = false;
    	 } else {
    		 obj[0].checked = true;
			 obj[0].disabled = true;
			 obj[1].disabled = true;
			 obj[2].disabled = true;
    	 }
     }
     
     /**
      * 라이오 버튼 클릭시 ETA/ETD 재 조회
      */
     function flgslt_click() {
    	 obj = document.form.flgrslt;
    	 for (i = 0; i <=2; i++) {
    		 if (obj[i].checked == true)
    		 {
    			 val = obj[i].value;
				 objs = document.form.mv_type;
    			 if (i == 2) {
    				 objs[0].checked = true;
    				 objs[0].disabled = true;
    				 objs[1].disabled = true;
    			 } else {
    				 objs[0].disabled = false;
    				 objs[1].disabled = false;
    			 }
//    			 objs = document.form.locl_type; // [CHM-201221016]
//    			 if (i == 0) {
//    				 objs[0].checked = true;
//    				 objs[0].disabled = true;
//    				 objs[1].disabled = true;
//    				 objs[2].disabled = true;
//
//    			 } else {
//    				 objs[0].disabled = false;
//    				 objs[1].disabled = false;
//    				 objs[2].disabled = false;
//    			 }
    		 }
    	 }
    	 getEtaEtdTime();
    	 assembleSheetColumn(sheetObjects[1], formObj);
     }
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 362;
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
                     InitColumnInfo(12, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|Seq.|Container No.|TP/SZ|F/M|STS|Org Yard|Booking No.||";


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter,  true,     "HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,       	30,    daCenter,  true,     "Seq");
                     InitDataProperty(0, cnt++ , dtHidden,    	30,    daCenter,  true,     "sno");
                     InitDataProperty(0, cnt++ , dtData,     	80,    daCenter,  true,     "cntr_no",  		false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  true,     "cntr_tpsz_cd",     false,          "",      dfNone, 	0,		false,		false);

                     InitDataProperty(0, cnt++ , dtData,      	35,    daCenter,  true,     "full_fg",     		false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,     	35,    daCenter,  true,     "mvmt_sts_cd",   	false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  true,     "org_yd_cd",   		false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,     	80,    daCenter,  true,     "bkg_no",  			false,          "",      dfNone, 	0,		false,		false);

                     InitDataProperty(0, cnt++ , dtHidden,      40,    daCenter,  true,     "mat",			  	false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      40,    daCenter,  true,     "mat_pod",			false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      40,    daCenter,  true,     "mat_cntr_pod",		false,          "",      dfNone, 	0,		false,		false);
                     
                     
                     ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;"
                     CountPosition = 0;

                }
                 break;

             case 2:      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 362;
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
                     InitColumnInfo(13, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|Seq.|Container No.|T/S|F/M|STS|Org Yard|MSG|POD||";


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  daCenter,  true,     "HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  true,     "Seq");
                     InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,     "sno");
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,     "cntr_no",  				false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  true,     "cntr_tpsz_cd",     		false,          "",      dfNone, 	0,		false,		false);

                     InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  true,     "full_fg",     			false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      35,    daCenter,  true,     "mvmt_sts_cd",   			false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  true,     "org_yd_cd",   			false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "bkg_no",			  		false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtData,      43,    daCenter,  true,     "pod_cd",			  		false,          "",      dfNone, 	0,		false,		false);

                     InitDataProperty(0, cnt++ , dtHidden,    40,    daCenter,  true,     "mat",			  		false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,    40,    daCenter,  true,     "mat_pod",			  	false,          "",      dfNone, 	0,		false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,    40,    daCenter,  true,     "mat_cntr_pod",			false,          "",      dfNone, 	0,		false,		false);
                     
 					 CountPosition = 0;
 					 sheetObjects[1].ColHidden("pod_cd") = true;
 					 ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;"

                }
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         formObj = document.form;

          switch(sAction)
         {

            case IBSEARCH:      //조회
                 if(validateForm(sheetObj,formObj,sAction)) {

	   	         	sheetObjects[0].WaitImageVisible = false;
	   	         	sheetObjects[1].WaitImageVisible = false;

	   	         	yard1 = formObj.pol_cd.value;
	   	         	yard2 = formObj.yard2.value;
	   	         	formObj.p_yard.value = yard1 + yard2;
                	sheetObjects[0].Redraw = false;
                	sheetObjects[1].Redraw = false;
                	ComOpenWait(true);
                	sheetObjects[0].ColHidden("Seq") = false;
 		        	sheetObjects[1].ColHidden("Seq") = false;
  		        	sheetObjects[0].ColHidden("sno") = true;
 		        	sheetObjects[1].ColHidden("sno") = true;
                	formObj.f_cmd.value = SEARCH;
           	   		sheetObj.DataAutoTrim = false;
          	   		xml = sheetObj.GetSearchXml("EES_CTM_0413GS.do", FormQueryString(formObj));
          	   		rtnValue = xml.split("|$$|");
          	   		sheetObjects[0].LoadSearchXml(rtnValue[0]);
          	   		sheetObjects[1].LoadSearchXml(rtnValue[1]);
          	   		var data0 = sheetObjects[0].GetRangeText(sheetObjects[0].HeaderRows, 3, sheetObjects[0].LastRow, 3);
 		            var data1 = sheetObjects[1].GetRangeText(sheetObjects[1].HeaderRows, 3, sheetObjects[1].LastRow, 3);
 		            
 		            var data2 = sheetObjects[0].GetRangeText(sheetObjects[0].HeaderRows, "mat_pod", sheetObjects[0].LastRow, "mat_pod");
 		            var data3 = sheetObjects[1].GetRangeText(sheetObjects[1].HeaderRows, "mat_pod", sheetObjects[1].LastRow, "mat_pod");
 		            
 		            var arrData0 = data0.split("^");
 		            var arrData2 = data2.split("^");
 		            
 		            var countA = 0;
 		            //var matchA = "";
 		            if (sheetObjects[0].CellValue(1,3) != '') {
	 		            for(var i = 0 in arrData0){
	 		             if(data1.indexOf(arrData0[i]) != -1){
	 		              countA ++;
	 		              sheetObjects[0].CellValue2(Number(i) + 1, "mat") = "1";
	 		              //matchA += "|"+i;
	 		             } else
	 		            	sheetObjects[0].CellValue2(Number(i) + 1, "mat") = "0";
	 		            }
	          	   		formObj.l1.value = sheetObjects[0].LastRow;
 		            } else
 		            	formObj.l1.value = 0;
 		            document.form.m1.value = countA;
 		            var arrData1 = data1.split("^");
 		            var countB = 0;
 		            //var matchB = "";
 		            if (sheetObjects[1].CellValue(1,3) != '') {
	 		            for(var i = 0 in arrData1){
	 		             if(data0.indexOf(arrData1[i]) != -1){
	 		              countB ++;
	 		              sheetObjects[1].CellValue2(Number(i) + 1, "mat") = "1";
	 		              //matchB += "|"+i;
	 		             } else
	 		            	sheetObjects[1].CellValue2(Number(i) + 1, "mat") = "0";
	 		            }
	          	   		formObj.l2.value = sheetObjects[1].LastRow;
 		            } else
 		            	formObj.l2.value = 0;
 		            document.form.m2.value = countB;
          	   		formObj.u1.value = formObj.l1.value - countA;
          	   		formObj.u2.value = formObj.l2.value - countB;

          	   		
          	   		
          	      	var div_1= ComGetObjValue(formObj.flgrslt);
          	      	var div_2 = ComGetObjValue(formObj.mv_type);
          	      	
          	   		if(div_1 == 'PD' && div_2 == 'B'){
          	   		//mat_pod 처리
 		            var arrData2 = data2.split("^");
 		            var countC = 0;
 		            
 		            if (sheetObjects[0].CellValue(1,"mat_pod") != '') {
	 		            for(var i = 0 in arrData2){
	 		             if(data3.indexOf(arrData2[i]) != -1){
	 		            	countC++; 
	 		              sheetObjects[0].CellValue2(Number(i) + 1, "mat_cntr_pod") = "1";
	 		              //matchA += "|"+i;
	 		             } else
	 		            	sheetObjects[0].CellValue2(Number(i) + 1, "mat_cntr_pod") = "0";
	 		            }
 		            }
 		            document.form.m1.value = countC;
 		            
 		            var arrData3 = data3.split("^");
 		            var countD = 0;
 		            
 		            if (sheetObjects[1].CellValue(1,"mat_pod") != '') {
	 		            for(var i = 0 in arrData3){
	 		             if(data2.indexOf(arrData3[i]) != -1){
	 		            	countD++;
	 		              sheetObjects[1].CellValue2(Number(i) + 1, "mat_cntr_pod") = "1";
	 		              //matchB += "|"+i;
	 		             } else
	 		            	sheetObjects[1].CellValue2(Number(i) + 1, "mat_cntr_pod") = "0";
	 		            }
 		            } 
 		            document.form.m2.value = countD;
          	   		formObj.u1.value = formObj.l1.value - countC;
          	   		formObj.u2.value = formObj.l2.value - countD;
          	   		}
                 }
            	 sheetObjects[0].Redraw = true;
            	 var div_1_1= ComGetObjValue(formObj.flgrslt);
       	      	 var div_2_2 = ComGetObjValue(formObj.mv_type);
            	 if(div_1_1 == 'PD' && div_2_2 == 'B'){
            		 rowColorChange_unmatch();
            	 }
            	 sheetObjects[1].Redraw = true;
	   	         ComOpenWait(false);
	   	         sheetObjects[0].WaitImageVisible = true;
	   	         sheetObjects[1].WaitImageVisible = true;
	   	         
	   	         break;
         }

     }

     /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
      function setComboObject(combo_obj){
      	comboObjects[comboCnt++] = combo_obj;
      }
      
      function setComboList(frmObj) {

    	var polCd = document.form.pol_cd.value;
    	  
  		var combo1Str = [polCd, "All"];		// S/Plan POD 조회 조건 추가
  		var combo1Val = [polCd, "All"];
  			combo1.RemoveAll();
  			for(var i=0 ; i < combo1Str.length ; i++){
  				combo1.InsertItem(i,combo1Str[i],combo1Val[i]);
  			}
  			combo1.DropHeight = 100;
  			combo1.SetColWidth("40");
  			combo1.Index = 0;

      }

      /**
       * 콤보 초기설정값
       * @param {IBMultiCombo} comboObj  comboObj
       */
      function initCombo(comboObj) {

       	comboObj.LineColor = "#ffffff";
       	comboObj.DropHeight = 120;
       }
     
      /**
       * 탭과 콤보의 조건에 따라 시트의 모양을 설정한다. <br>
       */
      function assembleSheetColumn(shtObj, formObj){
      	var div_1= ComGetObjValue(formObj.flgrslt);
      	var div_2 = ComGetObjValue(formObj.mv_type);
      	var polCd = formObj.pol_cd.value;
      	
      	with (shtObj) {
      			if(div_1 == 'PD' && div_2 == 'B'){
      				ColHidden("pod_cd") = false;
      				if(polCd != ""){
      					setComboList();
      				}
      				combo1.Enable = true;
      			}else{
      				ColHidden("pod_cd") = true;
      				combo1.RemoveAll();
      				combo1.Enable = false;
      			}
      		}
      }

      /**
       * unmatch 건에 해당하는 row 색상을 변경한다.
       * 
       */
      function rowColorChange_unmatch() {
    	  var div_1= ComGetObjValue(formObj.flgrslt);
          var div_2 = ComGetObjValue(formObj.mv_type);
    	  var lastRow = sheetObjects[0].LastRow;
    	  var lastRow1 = sheetObjects[1].LastRow;
    	  var shtObj = sheetObjects[0];
    	  var shtObj1 = sheetObjects[1];
    	  
			if(div_1 == 'PD' && div_2 == 'B'){
				for(var i = 0; i < lastRow+1; i++){
					if(shtObj.CellValue(i,"mat")=="0" && shtObj.CellValue(i,"mat_cntr_pod")=="0"){
						shtObj.RowBackColor(i) = shtObj.RgbColor(255,242,158);
						}
					else if(shtObj.CellValue(i,"mat")!="0" && shtObj.CellValue(i,"mat_cntr_pod")=="0"){
						shtObj.RowBackColor(i) = shtObj.RgbColor(255,187,0);
						}
					}
				for(var i = 0; i < lastRow1+1; i++){
					if(shtObj1.CellValue(i,"mat")!="0" && shtObj1.CellValue(i,"mat_cntr_pod")=="0"){
						shtObj1.RowBackColor(i) = shtObj1.RgbColor(255,187,0);
						}
					}
				}
      		}
 
      /**
       * unmatch 건에 해당하는 row 에 마우스를 움직이면 Text로 정보를 알려줌.
       */  
  	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y)
	{
		with(sheetObj)
		{
			var row = MouseRow;
			var col = MouseCol;
			
					if ("0" == CellValue(row, "mat"))
						MouseToolTipText = "No container exists in stowage plan";
					else if ("0" != CellValue(row, "mat") && "0" == CellValue(row, "mat_cntr_pod"))
						MouseToolTipText = "Same container with different POD";
					else
						MouseToolTipText = "";
		}
	}
  	
    /**
     * unmatch 건에 해당하는 row 에 마우스를 움직이면 Text로 정보를 알려줌.
     */  
	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y)
	{
		with(sheetObj)
		{
			var row = MouseRow;
			var col = MouseCol;
			
					if ("0" != CellValue(row, "mat") && "0" == CellValue(row, "mat_cntr_pod"))
						MouseToolTipText = "Same container with different POD";
					else
						MouseToolTipText = "";
		}
	}
      
      
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

         /**
          * 조회조건에 대한 Validation 정리
          * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
          * 배열은 소스 상단에 정의
          */
         function checkValidation(formObject)
         {
        	 return true;
         }
	/* 개발자 작업  끝 */