/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0006.js
*@FileTitle : Expense Report by Rev.Month
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.07
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.07 전재홍
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
     * @class ESD_LEA_0006 : ESD_LEA_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0006() {
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

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
            	        sheetObject.RemoveAll();
            	        if(
            	          ((12*(formObject.frm_rev_yrmon_to.value.substr(0,4) - formObject.frm_rev_yrmon_from.value.substr(0,4))
                	       		+ (formObject.frm_rev_yrmon_to.value.substr(5,2) - formObject.frm_rev_yrmon_from.value.substr(5,2))+1)<13)
                	      )
            	        {
            	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	        }
            	        else{
            	        	ComShowMessage(ComGetMsg("LEA90028","12"));
            	        }
        	            break;

            	    case "btng_downexcel":
    									//lea_form2sheet(formObject,sheetObject1);
    									//조회조건도 Excel로 넘겨주기위해 각각의 Sheet로 넘김.
    									//sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    									//sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
        	            //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
            	        break;
            	        
                    case "btns_calendar1":
           	         	var cal = new ComCalendar();
           	         	cal.setDisplayType('month');
           	         	cal.select(formObject.frm_rev_yrmon_from, 'yyyy-MM');
           	         	break;

                    case "btns_calendar2":
           	         	var cal = new ComCalendar();
           	         	cal.setDisplayType('month');
           	         	cal.select(formObject.frm_rev_yrmon_to, 'yyyy-MM');
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
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
             var sheetObject = sheetObjects[0];
             var formObject = document.form;
             sheetObject.RemoveAll();
             doActionIBSheet(sheetObject,formObject,COMMAND01); // Office별 권한 채크를 위해 생성
             doActionIBSheet(sheetObject,formObject,COMMAND02); // 로그인 Office별 Search Rhq Office
             statusLoad();
             if(formObject.winopen_div.value == "POP"){
   	    	  doActionIBSheet(sheetObject,formObject,IBSEARCH);
             }
        }

       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;
                        
                     // 높이 설정
    					style.height = 360;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(15, 2, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, true, true, false,false)

                        var HeadTitle  = "STS|Exe.\nMonth|Rev.\nMonth|RHQ|Cost Type Ⅰ|sub_cost_tp_cd|Cost Type Ⅱ|Estimated\nCost|Actual Cost(Invoice)|Actual Cost(Invoice)|Accrual\nCost|Confirmed\nCost|Cost Diff||" ;
                        var HeadTitle1 = "STS|Exe.\nMonth|Rev.\nMonth|RHQ|Cost Type Ⅰ|sub_cost_tp_cd|Cost Type Ⅱ|Estimated\nCost|Cost|Ratio(%)|Accrual\nCost|Confirmed\nCost|Cost Diff||" ;
                        
                        //헤더 툴팁
                        var sTipEstCo = "Cost estimated at COA from the BKG creation stage";
                        var sTipActCo = "Actually invoiced amount of A/P interfaced CSR";
                        var sTipAcclCo = "To be invoiced amount in estimation";
                        var sTipCfnCo = "Finalized cost consisting of 'Actual Cost' plus 'Accrual Cost'";
                        var sTipCoDf = "Difference between 'Confirmed Cost' and 'Estimated Cost'";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, 		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtHiddenStatus , 30,    daCenter,  true,    "ibflag");
						InitDataProperty(0, cnt++ , dtHidden ,       70,    daCenter,  true ,    "exe_yrmon"          ,        false,          "",       dfDateYm 		,   	0,     false,        false);
						InitDataProperty(0, cnt++ , dtData   ,       80,    daCenter,  true ,    "rev_yrmon"          ,        false,          "",       dfDateYm 		,   	0,     false,        false);
						InitDataProperty(0, cnt++ , dtData   ,       80,    daCenter,  true ,    "rhq_cd"          ,        false,          "",       dfDateYm 		,   	0,     false,        false);
						InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  true ,    "mn_cost_tp_cd"      ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  true ,    "sub_cost_tp_cd"     ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtData   ,      250,    daLeft,  true ,    "sub_cost_tp_nm"     ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "estm_cost_amt"      ,        false,          "",       dfFloat	,  		2,     false,        false		,	-1	,	false	,	true			,	sTipEstCo);                                              
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  false,    "act_cost_amt"   ,        false,          "",       dfFloat	,  		2,     false,        false		,	-1	,	false	,	true			,	sTipActCo);                                              
						InitDataProperty(0, cnt++ , dtData   ,       90,    daRight ,  false,    "act_cost_ratio"     ,        false,          "",       dfFloat	,  		1,     false,        false		,	-1	,	false	,	true			,	sTipActCo);       
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "adj_accl_cost_amt"      ,        false,          "",       dfFloat	,  		2,     false,        false	,	-1	,	false	,	true			,	sTipAcclCo);                                              
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "cfm_cost_amt" ,        false,          "",       dfFloat	,  		2,     false,        false 				,	-1	,	false	,	true			,	sTipCfnCo);           
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "dif_cost_amt"      ,        false,          "",       dfFloat	,  		2,     false,        false			,	-1	,	false	,	true			,	sTipCoDf); 
						InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "mnl_inp_flg"        ,        false,          "",       dfNone   		,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtHidden ,      150,    daCenter,  false,    "erp_if_flg"         ,        false,          "",       dfNone   		,   	0,     false,        false);                                              

					ImageList(0) = "/hanjin/img/button/btng_minus.gif";
					ImageList(1) = "/hanjin/img/button/btng_plus.gif";
//					CellImage(0, "mn_cost_tp_cd") = 0;
                        RangeBackColor(1, 6, 1, 8) = RgbColor(222, 251, 248);   // ENIS
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
                        //style.height = GetSheetHeight(13) ;
                   }
                    break;
                case 2:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(3, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle   = "Exe.\nYear-Month|Rev.Year-Month|Rev.Year-Month";
                        var HeadTitle1  = "Exe.\nYear-Month|From|To";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    										InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "exe_yrmon"				,        false,          "",       dfDateYm 	,   	0,     true ,        true  ); 																															
    										InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon_from"  ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
    										InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon_to"    ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
                                                               
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                         style.height = GetSheetHeight(13) ;
                   }
                     break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
                   if(validateForm(sheetObj,formObj,sAction)){
    					    	formObj.f_cmd.value = SEARCH;
    							  //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0006GS.do", FormQueryString(formObj));
    							  
    							  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0006GS.do", leaFormQueryString(formObj));
    							  
    							  
    						    //ComShowMessage(searchXml);
    						    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
            		}
    				break;
    				
               case COMMAND01:
            	   if(validateForm(sheetObj,formObj,sAction)){
				    	formObj.f_cmd.value = COMMAND01;
						  //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0006GS.do", FormQueryString(formObj));
						  
						  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0006GS.do", leaFormQueryString(formObj));
						  
						  var ofcType = ComGetEtcData(searchXml, "OFC_TP_CD"); // HT, HQ, OTH
	 				      formObj.ofc_type.value = ofcType;
						  
					    //ComShowMessage(searchXml);
					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
					    

   		}
			break;
			
               case COMMAND02:
            	   if(validateForm(sheetObj,formObj,sAction)){
				    	formObj.f_cmd.value = COMMAND02;
						  
						  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0014GS.do", leaFormQueryString(formObj));
						  
						  var accRhqOfcCd = ComGetEtcData(searchXml, "Account_Rhq_Offiice");
  						  formObj.acct_rhq_ofc_cd.value = accRhqOfcCd;
						  

						  if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
          	   		}
          	   		break;
			
                    
    					case IBDOWNEXCEL:        // excel down
    		
    						//if(validateForm(sheetObj,formObj,sAction))
    						/*
    							mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
                                     [WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 
                */
    						sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    						break;

            }
        }

       /**
         * 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트
         */
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
//    		 sheetObj.SubSumBackColor = sheetObj.RgbColor(255,153,255);
    	   sheetObj.ShowSubSum( "rev_yrmon"   , "7|8|9|10|11|12", -1, false, false , 1 ,"1=%s;2=Monthly Total");
    	   sheetObj.SumText(0,0) = "";
    	   sheetObj.SumText(0,1) = "Grand Total" ;
    	//   sheetObj.SumBackColor  	= sheetObj.RgbColor(153,153,255);
    		 sheetObj.SumFontBold 		= true;

          var subSumRows = sheetObj.FindSubSumRow("rev_yrmon");
          var arrRow = subSumRows.split("|");
      		for (var i=0; i<arrRow.length-1; i++){ 
      			if(sheetObj.CellValue(arrRow[i],"estm_cost_amt") == 0){
      				sheetObj.CellValue(arrRow[i],"act_cost_ratio") = 0;
      			}else{
      				sheetObj.CellValue(arrRow[i],"act_cost_ratio") = sheetObj.CellValue(arrRow[i],"pst_act_cost_amt")/ sheetObj.CellValue(arrRow[i],"estm_cost_amt")*100;
      			 }
      		}

      		if(sheetObj.SumValue(0,"estm_cost_amt") == 0)
    				sheetObj.SumValue(0,"act_cost_ratio") = 0;
    			else
    				sheetObj.SumValue(0,"act_cost_ratio") = sheetObj.SumValue(0,"pst_act_cost_amt")/ sheetObj.SumValue(0,"estm_cost_amt")*100;

    	}
    	
//       /**
//         * 마우스가 눌러졌을때 발생하는 이벤트
//         */
//    	function sheet1_OnMouseDown(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
//    	{ 
//    	   if((sheetObj.MouseRow  == 1 || sheetObj.MouseRow  == 0) && sheetObj.MouseCol == 4){
//    				if(sheetObj.CellImage(0, "mn_cost_tp_cd") == 0){
//        			sheetObj.CellImage(0, "mn_cost_tp_cd") = 1;
//        			document.form.frm_retrieveDiv.value = 1;
//        			doActionIBSheet(sheetObj,document.form,IBSEARCH);
//        		}else{
//        			sheetObj.CellImage(0, "mn_cost_tp_cd") = 0;
//        			document.form.frm_retrieveDiv.value = 0;
//        			doActionIBSheet(sheetObj,document.form,IBSEARCH);
//        		}
//    	  
//    /*	   	  1. sheetObj.CellImage(0, "mn_cost_tp_cd") 값이 index가 return 되지않고 무조건 -1로 return되는 버그때문에 작성된 소스임.
//                 삭제할부분.
//    	    var retrieveDiv = document.form.frm_retrieveDiv.value;
//    			   if(document.form.frm_retrieveDiv.value == "0"){
//    	       			sheetObj.RemoveAll();
//        					doActionIBSheet(sheetObj,document.form,IBSEARCH);
//    		    			sheetObj.CellImage(0, "mn_cost_tp_cd") = 1;
//    		    			retrieveDiv = "1";
//    				  }else{
//    	       			sheetObj.RemoveAll();
//        					doActionIBSheet(sheetObj,document.form,IBSEARCH);
//    			    		sheetObj.CellImage(0, "mn_cost_tp_cd") = 0;
//    			    		retrieveDiv = "0";
//    				  }
//    				   document.form.frm_retrieveDiv.value = retrieveDiv;
//    */
//    	   }
//    	   
//    	}

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	var rtn = true;
            with(formObj){

        		if( formObj.f_cost_type_f.checked == false && formObj.f_cost_type_m.checked == false && formObj.f_cost_type_c.checked == false &&
        				formObj.f_cost_type_fv.checked == false && formObj.f_cost_type_ev.checked == false) {
        			ComShowMessage(ComGetMsg("COM12113", "Check Box"));
       				rtn = false;
        		
        		}
        		else {
        			rtn = true;
        		}
            }
            return rtn;
        }

       /**
         * EnterKey Event 조회 프로세스 처리
         */
    		function lea_enterRetrieve(){
          var sheetObject = sheetObjects[0];
          var formObject = document.form;
    			/*
    				if(sheetObject.CellImage(0, "mn_cost_tp_cd") == 0){
        			sheetObject.CellImage(0, "mn_cost_tp_cd") = 1;
        			formObject.frm_retrieveDiv.value = 1;
        			doActionIBSheet(sheetObject,formObject,IBSEARCH);
        		}else{
        		*/
//        			sheetObject.CellImage(0, "mn_cost_tp_cd") = 0;
        			formObject.frm_retrieveDiv.value = 0;
        			doActionIBSheet(sheetObject,formObject,IBSEARCH);
        		//}

    		}
       /**
         * Form Data를Sheet로 Copy 프로세스 처리
         */
    		function lea_form2sheet(formObj,sheetObj){
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "exe_yrmon" 			) = formObj.frm_exe_yrmon		 .value;
    			sheetObj.CellValue(Row , "rev_yrmon_from" ) = formObj.frm_rev_yrmon_from.value;
    			sheetObj.CellValue(Row , "rev_yrmon_to"   ) = formObj.frm_rev_yrmon_to  .value;
    		}
    	/*
    	 * Cost Type check 값을 Cookie에 Set 프로세스
    	*/
    	function lea_setCookieAcclType(){
//    			setCookie("form_lea_cost_type_m",(document.form.f_cost_type_m.checked == true ?"1":"0"));
//    			setCookie("form_lea_cost_type_f",(document.form.f_cost_type_f.checked == true ?"1":"0"));

         document.form.f_cost_type_m.value = (document.form.f_cost_type_m.checked == true ?"1":"0");
         document.form.f_cost_type_f.value = (document.form.f_cost_type_f.checked == true ?"1":"0");
    	}
    	
    	/*
    	 * frm_rev_yrmon_to 값을 setting.
    	*/
    	function lea_setRevToYymm(obj1,obj2){
    		if (event.keyCode == 13){
    			lea_com_setRevToYymm(obj1,obj2)
    		}
    	}
    	
    	/*
    	 * Cost Type check 값을 Cookie에 Set 프로세스
    	*/
    	function lea_setCookieAcclType(){
//    		setCookie("form_lea_cost_type_m",(document.form.f_cost_type_m.checked == true ?"1":"0"));
//    		setCookie("form_lea_cost_type_f",(document.form.f_cost_type_f.checked == true ?"1":"0"));
    		document.form.f_cost_type_m.value = (document.form.f_cost_type_m.checked == true ?"1":"0");
    		document.form.f_cost_type_f.value = (document.form.f_cost_type_f.checked == true ?"1":"0");
    		document.form.f_cost_type_fv.value = (document.form.f_cost_type_fv.checked == true ?"1":"0");
    		document.form.f_cost_type_ev.value = (document.form.f_cost_type_ev.checked == true ?"1":"0");
    		document.form.f_cost_type_c.value = (document.form.f_cost_type_c.checked == true ?"1":"0");

    	}

//        function checkOption(arg){
//      	  var formObj = document.form;
//      	  
//  		  if(arg == 'full' || arg == 'empty' || arg == 'chassis'){
//  			  formObj.f_cost_type_v.checked = false;
//  		  }else if(arg == 'vol'){
//  			  formObj.f_cost_type_f.checked = false;
//  			  formObj.f_cost_type_m.checked = false;
//  			  formObj.f_cost_type_c.checked = false;
//  		  }
//  	}
        
        function statusLoad(sheetObj,p_state){
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
        	formObj.f_rhq_cd.value = formObj.acct_rhq_ofc_cd.value;
        	var ofcType = formObj.ofc_type.value;
        	
        	if(ofcType == 'HT') { // 본사 OFC
        		formObj.f_rhq_cd.disabled = false;
        	} else {
        		formObj.f_rhq_cd.disabled = true;
        	}
        }
	/* 개발자 작업  끝 */