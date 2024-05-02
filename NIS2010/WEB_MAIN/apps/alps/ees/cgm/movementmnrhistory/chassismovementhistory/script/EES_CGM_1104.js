/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1104.js
*@FileTitle : 특정 조회조건의 Chassis Movement 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.23 최민회
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
     * @class ees_cgm_1104 : ees_cgm_1104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1104() {
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
 var comboObjects = new Array();
 var comboCnt = 0;
 var appendCondParam = null;
 
 var appendPageNo = 1;
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
             case "ComOpenPopupWithTarget":
             	var tmp = formObject.location.value;
             	if(tmp == "R")
             	{
             		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
             	}else if(tmp == "L")
             	{
             		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
             	}else if(tmp == "S")
             	{
             		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
             	}
       			
       			break;
 				case "btn_retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;

 				case "btn_new":
 					objectClear();
               	    sheetObject1.RemoveAll();
 					break;

 				case "btn_downexcel":
 					sheetObject1.SpeedDown2Excel(-1);
 					break;
 				case "btn_master":
 					doActionPageMove(sheetObject1,formObject,srcName);
 					
 					break;
 				case "btn_mvmt":
 					doActionPageMove(sheetObject1,formObject,srcName);
 					break;
                case "btn_more":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
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
      * Step 단계별로 화면 이동 
      */
     function doActionPageMove(sheetObj, formObj, btnName){
         formObj.f_cmd.value = "";
         formObj.method = "POST";
         formObj.target = "";
         
         // MultCombo 일경우 submit()으로 넘기면 데이터를 정상적으로 넘길수 었기 때문에 아래와 같이 GET 방식으로 데이터를 넘긴다        
         if(formObj.eq_no.value==""){
        	 ComShowCodeMessage("CGM10012");
         } else {
        	 if (btnName == "btn_mvmt"){
//        		 formObj.action = "EES_CGM_1105.do?pgmNo=EES_CGM_1105";
//            	 formObj.submit();
 		  		var pgmNo = 'EES_CGM_1105';
		  		var pgmUrl = '/hanjin/EES_CGM_1105.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value+"&to_day=" +document.form.chss_mvmt_dt.value;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
             } else if (btnName == "btn_master"){
 		  		var pgmNo = 'EES_CGM_1003';
		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value ;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
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
       * 기본 오브젝트 초기화 
       */
      function objectClear(){
 	       	var formObj = document.form;
 	       	var sheetObject  = sheetObjects[0];
 	       
 	        formObj.eq_tpsz_cd.text = "ALL";
 	        formObj.agmt_lstm_cd.text = "ALL";
 	        
// 	        formObj.aciac_div_cd.text = "ALL";
 	        formObj.Include.checked = false;
 	        formObj.reset();
 	        formObj.location.value = "S";
	        formObj.chss_pool_cd.text = "Include Pool Chassis";
 	        formObj.aciac_div_cd.value = "A";
 	        ComBtnDisable("btn_more");
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
             
             
             comboObjects[comboCnt++] = document.agmt_lstm_cd;
             comboObjects[comboCnt++] = document.eq_tpsz_cd;
             comboObjects[comboCnt++] = document.chss_pool_cd;
             comboObjects[comboCnt++] = document.chss_mvmt_sts_cd;
             for(var k=0;k<comboObjects.length;k++){
       	        initCombo(comboObjects[k]);
      	     }  
             
//             for(var k=0;k<comboObjects.length;k++){
//       	        initCombo(comboObjects[k]);
//      	     }  
//          // POOl
//           	
//           	for(var k=0;k<comboObjects.length;k++){
//       	        initCombo(comboObjects[k]);
//      	    }
         }


     }
      
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.WaitImageVisible = false;
      	 
         formObj = document.form;
         // axon event 등록
         axon_event.addListener('change', 'obj_change' , 'location');  
         
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
         
     	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//         
         // axon event 등록
         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//         axon_event.addListener('change', 'obj_change' , 'scc_cd'  ); 
         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
//         axon_event.addListener('focusout', 'obj_focusout' , 'scc_cd'    ); 
         formObj.location.value = "S";
         formObj.aciac_div_cd.value = "A";
         initControl(sheetObjects[0]);   
         
		 sheetObj.WaitImageVisible = true; 
    }
    
      /**
      * Form의 Conrol 를 초기화 시킨다. <br>
      * @param  {object} sheetObj	필수
      * @return 없음
      * @author 최민회
      * @version 2009.05.20
      */
     function initControl(sheetObj){
     	// Form 객체 선언
     	  formObj = document.form;
         // axon event 등록
     	 
      // Lease Term Combo Control에  초기값을  설정한다.
         formObj.agmt_lstm_cd.text ='ALL';
         formObj.eq_tpsz_cd.text ='ALL';
         formObj.chss_pool_cd.text = 'Include Pool Chassis';
         // button Disable
         ComBtnDisable("btn_more");
       
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

             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 402;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 9, 1000);
                     document.form.pagerows.value = 1000;

					 var HeadTitle = "|Seq.|Chassis No.|TP/SZ|Term|Yard|Status|MVMT|Movement Date|Staying Days|Container No.|M.G.Set No.|B/L No.|Booking No.|Trucker|Trucker Description|Shipper|Shipper Description|Consignee|Consignee Description|UPDATE USER ID|";
					 var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 	 InitDataProperty(0, cnt++ , dtHiddenStatus,	45,		daCenter,			false,	"hdnStatus");
                     InitDataProperty(0, cnt++ , dtDataSeq,	 30,	daCenter, false, "Seq");                                                 
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter, false, "eq_no",            false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	50,     daCenter, false, "eq_tpsz_cd",	     false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	50,     daCenter, false, "agmt_lstm_cd",     false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	90,     daCenter, false, "crnt_yd_cd",       false, "", dfNone, 0, false, false);
                     
                     InitDataProperty(0, cnt++ , dtData,	90,     daCenter, false, "aciac_div_cd",     false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	60, 	daCenter, false, "chss_mvmt_sts_cd", false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	110,	daCenter, false, "chss_mvmt_dt",     false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	90,	    daCenter, false, "days",             false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	80,	    daCenter, false, "chss_no",          false, "", dfNone,	0, false, false);
                     
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter, false, "mg_set_no",	     false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter, false, "bl_no",	         false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter, false, "booking",	         false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	70, 	daCenter, false, "vndr_seq",	     false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	150,	daLeft,	  false, "vndr_abbr_nm",     false, "", dfNone,	0, false, false);
                     
                     InitDataProperty(0, cnt++ , dtData,	70,	    daCenter, false, "conignee1",	     false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	150,	daLeft,	  false, "cust_nm",	         false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	70, 	daCenter, false, "conignee",	     false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	150,	daLeft,	  false, "consigne",	     false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter, false, "upd_usr_id",       false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter, false, "ttl_knt",       false, "", dfNone,	0, false, false);

	
						//InitUserFormat2(0, "MovementDate", "####-##-## ##:##", "-|:" );
	
//						CountPosition = 0;
	
				}
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
                 if(formObj.Include.checked== true) {    
                	 formObj.np.value='Y';
                 } else {
                	 formObj.np.value='N';
                 }
                 
                formObj.f_cmd.value = SEARCH;
  			 	appendCondParam = FormQueryString(formObj);
//  			 	 sheetObj.Redraw = false;
  			 	 if(!validateForm(sheetObj,formObj,sAction)) return;
	        	
  			 	 sheetObj.WaitImageVisible=false;
 			 	 ComOpenWait(true);
                 //chungpa 2010011 popup안뜨는 문제점. sheetObj.DoSearch4Post("EES_CGM_1104GS.do", appendCondParam);
 			     var sXml = sheetObj.GetSearchXml("EES_CGM_1104GS.do", appendCondParam);
 			     sheetObj.LoadSearchXml(sXml);
 			 	 ComOpenWait(false);
 			 	 
                 for(i=1; i<sheetObj.rowCount+1; i++){
          			if(sheetObj.CellValue(i, "aciac_div_cd") == "In-active"){
          				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
          			}
          	     }
                 var ttl_knt = 0;
                 var pngcnt = 0;
                 if(sheetObj.rowCount>0){
                	 ttl_knt = sheetObj.CellValue(1, "ttl_knt");
                	 formObj.ttl_knt.value =  ComAddComma2(sheetObj.CellValue(1, "ttl_knt"), "#,###");  
                 }
                 //formObj.pngcnt.value = "1,000";
                 formObj.eq_no.value = "";
                 formObj.chss_mvmt_dt.value = "";
                 appendPageNo = 1;
                 pngcnt = ComReplaceStr(formObj.pngcnt.value,",","")
                 if (pngcnt < ttl_knt) {
                     appendPageNo = appendPageNo + 1;
                     ComBtnEnable("btn_more");
                 } else {
                     ComBtnDisable("btn_more");
                 }
                 
                 break;
            case IBSEARCHAPPEND:    //Append 조회
	            
	 
//	  			 	 if(!validateForm(sheetObj,formObj,sAction)) return;
		 	     sheetObj.WaitImageVisible=false;
	 	         ComOpenWait(true);
                 sheetObj.DoSearch4Post("EES_CGM_1104GS.do",  CondParam,"&i_page=" + appendPageNo, true);
                 for(i=1; i<sheetObj.rowCount+1; i++){
          			if(sheetObj.CellValue(i, "aciac_div_cd") == "In-active"){
          				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
          			}
          	     }
                 var ttl_knt = 0;
                 var pngcnt = 0;
                 pngcnt  = ComReplaceStr(formObj.pngcnt.value,",","")
                 ttl_knt = ComReplaceStr(formObj.ttl_knt.value,",","")
                 if (pngcnt < ttl_knt) {
                     // APPEND 검색을 위한 페이지번호 setting
                     appendPageNo = appendPageNo + 1;
                     ComBtnEnable("btn_more");
                 } else {
                     ComBtnDisable("btn_more");
                 }
                 formObj.eq_no.value = "";
                 formObj.chss_mvmt_dt.value = "";
                 ComOpenWait(false);
            break;
          case IBSEARCH_ASYNC02:	// Term Code Combo 조회
	       	formObj.f_cmd.value = SEARCH;
	       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	   			    			
	   		var sStr = ComGetEtcData(sXml,"comboList");    			
	   		var arrStr = sStr.split("@");
	   			
	   		// combo control, 결과 문자열, Text Index, Code Index
	  			MakeComboObject2(formObj.agmt_lstm_cd, arrStr, 0, 0);
	       	break;
          case IBSEARCH_ASYNC03:	// Term Code Combo 조회
	       	formObj.f_cmd.value = SEARCH;
	       	formObj.intg_cd_id.value = COM_CD_TYPE_CD01940;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	   		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	   			    			
	   		var sStr = ComGetEtcData(sXml,"comboList");    			
	   		var arrStr = sStr.split("@");
	   			
	   		// combo control, 결과 문자열, Text Index, Code Index
	  			MakeComboObject2(formObj.eq_tpsz_cd, arrStr, 0, 0);
	       	break;
          case IBSEARCH_ASYNC04:	
       		
        		formObj.f_cmd.value = SEARCH02;
        		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
        		ss = ComCgmXml2ComboString(sXml, "TOTAL");
        		var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
        		//IBSHEET GRID 밖에 있는 콤보
        		makeCPMultiCombo(formObj.chss_pool_cd, cols, 0, 0);
         	  	break;
          case IBSEARCH_ASYNC05:	// Term Code Combo 조회
	       	formObj.f_cmd.value = SEARCH;
	       	formObj.loc_cd.value = formObj.scc_cd.value;		//   ( location)
	   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	   			    			
	   	// 데이터 건수
	        var dataCount = ComGetTotalRows(sXml);
	        if(dataCount==0){
	        	ComShowCodeMessage('CGM10009','location cd');
		   		formObj.scc_cd.value = "";
		   		formObj.scc_cd.focus();
	        }
	       	break;
   	    case IBSEARCH_ASYNC08:
 	    	formObj.f_cmd.value = SEARCH17;
 	    	var location = formObj.location.value;
 	    	
 	    	if(location == "R")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "RCC";
 	    		formObj.eq_orz_cht_rcc_cd.value = formObj.scc_cd.value;
 	    	}else if(location == "L")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "LCC";
 	    		formObj.eq_orz_cht_lcc_cd.value = formObj.scc_cd.value;
 	    	}else if(location == "S")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "SCC";
 	    		formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;
 	    	}else
 	    	{
 	    		formObj.eq_orz_cht_chktype.value = "";
 	    		formObj.eq_orz_cht_scc_cd.value = "";
 	    	}
 	 		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
 	   		// 데이터 건수
 	        var dataCount = ComGetTotalRows(sXml);
 	        if(dataCount==0){
 	        	ComShowCodeMessage('CGM10009','location cd');
 		   		formObj.scc_cd.value = "";
 		   		formObj.scc_cd.focus();
 	        }
 	  	    break;	
	   	 case IBRESET:
	 		var idx = 0
	 		var sXml2 = document.form2.sXml.value;
	 		var arrXml = sXml2.split("|$$|");
	
	 		//agmt_lstm_cd
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject2(formObj.agmt_lstm_cd, arrStr1, 0, 0);     
	 		idx++;       
	 		
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject2(formObj.eq_tpsz_cd, arrStr1, 0, 0);     
	 		idx++;       
	
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
	 		makeCPMultiCombo2(formObj.chss_pool_cd, arrStr1, 1, 0);     
	 		idx++;      
	 		
	 		if ( arrXml[idx] == null ) {return;}
			var cols2 = ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
     	  	ComCgmMakeMultiCombo(form.chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
     	  	idx++;
	 		idx++;      
//		  	
	  	  	
	 		break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             if (formObj.scc_cd.value=="") {
            	 if(formObj.Include.checked == false)
            	 {
            		 if(formObj.chss_pool_cd.text =='Include Pool Chassis' 
            		 || formObj.chss_pool_cd.text =='Exclude Pool Chassis' 
            		 || formObj.chss_pool_cd.text =='Only Pool Chassis'){
            			 ComShowCodeMessage('CGM10004','scc_cd');
                		 formObj.scc_cd.focus();
                		 return false; 
            		 }
            		 
            	 }
            	 
            	 
                 
             }
             if(formObj.scc_cd.value!="" && formObj.scc_cd.value.length !=5){
	 			ComShowCodeMessage('CGM10044','Location (5)');
 				scc_cd.focus();
 				
 				return false;
     		}
         }

         return true;
     }

         
         /** 
          * Combo Object 초기화  <br>
          * @param  {object} comboObj	필수 Combo Object
          * @return 없음
          * @author 최민회
          * @version 2009.05.25
          */ 
         function initCombo(comboObj) {
          	switch(comboObj.id) {
       	       case "agmt_lstm_cd":
       	           var cnt=0;
       	           with(comboObj) {
       	            	Code = "";
       	            	Text = "";
       	            	DropHeight = 100;
       	            	MultiSelect = false;
       	            	MaxSelect = 1;	    
       	            	UseCode = true;
       	            	Enable = true;
       	            	comboObj.UseAutoComplete = true;
       	            }
       	            break;
//       	       case "location":
//       	           var cnt=0;
//       	           with(comboObj) {
//       	            	Code = "";
//       	            	Text = "";
//       	            	DropHeight = 100;
//       	            	MultiSelect = false;
//       	            	MaxSelect = 1;	    
//       	            	UseCode = true;
//       	            	Enable = true;
//       	            }
//       	            break;
       	    case "eq_tpsz_cd":
    	           var cnt=0;
    	           with(comboObj) {
    	            	Code = "";
    	            	Text = "";
    	            	DropHeight = 100;
    	            	MultiSelect = false;
    	            	MaxSelect = 1;	    
    	            	UseCode = true;
    	            	Enable = true;
    	            	comboObj.UseAutoComplete = true;
    	            }
    	            break;
       	 case "chss_pool_cd":
	           var cnt=0;
	           with(comboObj) {
	            	Code = "";
	            	Text = "";
	            	DropHeight = 100;
	            	MultiSelect = false;
	            	MaxSelect = 1;	    
	            	UseCode = true;
	            	Enable = true;
	            	comboObj.UseAutoComplete = true;
	            }
	            break;
     	case "chss_mvmt_sts_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code = "";
  	            Text = "";
  	            DropHeight = 150;
  	            MultiSelect = true;
  	            MaxSelect = 100;	    
  	            UseCode = true;
  	            Enable = true;
	            
        	ValidChar(2,3);         // 영어 대문자, 숫자포함+특수(',')
            IMEMode = 0;            // 영문
            MaxLength = 20;         // 100자까지 입력
  	        }
  	        
  	        break;
       	    }
       	} 
        
         
         /** 
          * Combo Object 에 값을 추가하는 처리 <br>
          * @param  {object} cmbObj	필수 Combo Object
          * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
          * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
          * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
          * @return 없음
          * @author 최민회
          * @version 2009.05.20
          */ 
         function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
         	cmbObj.RemoveAll();
         	for (var i = 0; i < arrStr.length;i++ ) {
         		var arrCode = arrStr[i].split("|");
         		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
              	}
         	cmbObj.Index2 = "" ;
         }
          /** 
           * Combo Object 에 값을 추가하는 처리 <br>
           * @param  {object} cmbObj	필수 Combo Object
           * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
           * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
           * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
           * @return 없음
           * @author 최민회
           * @version 2009.05.20
           */ 
          function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
          	cmbObj.RemoveAll();
          	cmbObj.InsertItem(0,"ALL","");
          	for (var i = 0; i < arrStr.length;i++ ) {
          		var arrCode = arrStr[i].split("|");
          		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
          	}
          	cmbObj.Index2 = "" ;
          }
          
          /** 
           * IBSHEET GRID 밖에 콤보 추가(POOL COMBO)
           */ 
          function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
          	cmbObj.RemoveAll();
//          	cmbObj.InsertItem(0, "", "");
       
          	// LOOP를 돌리기 위해 데이타 갯수를 구함 
          	if(arrStr == undefined ){
          		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
      			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
      			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
          	} else {
              	var arrCode = arrStr[0].split("|");
            	var arrCode2 = arrStr[1].split("|");
	          	
	          	for (var i = 0; i < arrCode.length;i++ ) {
	          		var arrCode3 = arrCode[i].split("|");
	          		var arrCode4 = arrCode2[i].split("|");
	          		if(i==0)
	          		{
	          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          		else
	          		{
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          		
	          	}
          	}

          	cmbObj.Index2 = "" ;
          }
          	
            /** 
             * IBSHEET GRID 밖에 콤보 추가(POOL COMBO)
             */ 
            function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
            	cmbObj.RemoveAll();
//            	cmbObj.InsertItem(0, "", "");
         
            	// LOOP를 돌리기 위해 데이타 갯수를 구함 
            	if(arrStr == undefined ){
            		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
        			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
        			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
            	} else {
                	var arrCode = arrStr[0].split("|");
	              	var arrCode2 = arrStr[1].split("|");
	//            	//ComShowMessage(arrCode2);
	              	for (var i = 0; i < arrStr.length;i++ ) {
	            		var arrCode = arrStr[i].split("|");
	            		if(i==0)
	  	          		{
	  	          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	  	          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	  	          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	  	          			cmbObj.InsertItem(i+3, arrCode[txtCol], arrCode[codeCol]);
	  	          		}
	  	          		else
	  	          		{
	  	          			cmbObj.InsertItem(i+3, arrCode[txtCol], arrCode[codeCol]);
	  	          		}
                	}
            	}
             }
         	/** 
            * Object 의 Keypress 이벤트에 대한 처리  <br>
            * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
            * @param  없음
            * @return 없음
            * @author 최민회
            * @version 2009.05.20
            */ 
           function obj_keypress(){
          	 obj = event.srcElement;
          	 if(obj.dataformat == null) return;
          	 	
          	 window.defaultStatus = obj.dataformat;
          	 switch(obj.dataformat) {
          	 	case "ymd":
          	 		ComKeyOnlyNumber(obj);
          	        break;
          	    case "eng":
          	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
          	        else ComKeyOnlyAlphabet('upper');
          	        break;
          	    case "engup":
          	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
          	        else ComKeyOnlyAlphabet('upper');
          	        break;
          	    
          	 }
          	 
          	 
           }

            function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
            	document.form.eq_no.value = sheetObj.CellValue(Row, "eq_no");
            	var chss_mvmt_dt =  sheetObj.CellValue(Row, "chss_mvmt_dt");
            	chss_mvmt_dt = ComReplaceStr(chss_mvmt_dt.substring(0,10),"-")
            	document.form.chss_mvmt_dt.value = chss_mvmt_dt;
            }
            
                   /** 
 * Object 의 focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */  
//    function obj_change(){
//    	 var formObj = document.form;
//    	 var sheetObj = sheetObjects[0]; 
//    	 obj = event.srcElement;
//    	 switch(obj.name){
// 	 
//    	   case "scc_cd":
//    	 		if(formObj.scc_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
//    	 			break;
//    	 		} 
//    	  
//    	 }   
//    }
        /**
      * YA_CD 값 체크
      * @return
      */
     function obj_keyup(){
		 var formObj = document.form;
		 var sheetObj = sheetObjects[0];
		 obj = event.srcElement;
		 switch(obj.name){
	  	 	case "scc_cd":
		 		var crntLocCd = ComTrimAll(formObj.scc_cd.value);
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 입력오류 체크 (예> ,,)
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.scc_cd.value = "";
		 				ComSetFocus(formObj.scc_cd);
		 				break;
		 			}else{
		    	 		//if(formObj.scc_cd.value != ''){
		    	 		if(formObj.scc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		    	 	}
		 		}
		 		break;		
		 }
	}
   /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.10.20
     */  
    function obj_change(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0]; 
    	 obj = event.srcElement;
    	 switch(obj.name){
    	   
    	   	case "location":
    	    	formObj.scc_cd.value = "";
    	   		break;    	   	
    	 }   
    }		 
 
     /**
      * Sheet1의 OnSearchEnd 이벤트 처리
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         if (ErrMsg == "") {
             with(sheetObj) {
                 var frmObj = document.form;
//                 var ttl_knt = ComAddComma(frmObj.ttl_knt.value );
                 frmObj.pngcnt.value = ComAddComma(SearchRows);
//                 frmObj.rtv_total.value = ComAddComma(TotalRows);
                 // 조회조건의 mvmt_edi_rslt_cd가 X가 아니면 GRAND TOTAL을 표기 (APPEND 검색 대비)
//                 alert(ttl_knt);
               
             }
         }
     }

	/* 개발자 작업  끝 */