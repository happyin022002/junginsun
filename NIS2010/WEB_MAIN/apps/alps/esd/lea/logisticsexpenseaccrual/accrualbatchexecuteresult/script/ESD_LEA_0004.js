/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0004.js
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
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
     * @class ESD_LEA_0004 : ESD_LEA_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0004() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* ???????? ?? ???? ?????? ?? */
    document.onclick = processButtonClick;

    /* ?? ???? ???? ????? ?????? ?????? */
        function processButtonClick(){
             /***** ?? ??? 2? ??? ??? ?? ???? ???? ??? *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
            	    	sheetObject.RemoveAll();
           
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	            
    									break;

            	    case "btng_detailbycontainer":
    			            if ( sheetObject.RowCount < 1 ) 
    			            {
    			              	//ComShowMessage("No data found.");
    			              	ComShowMessage(ComGetMsg("LEA90008"));
    			                return false;
    			            }
    			            if ( sheetObject.SelectRow < 0 ) 
    			            {
    			              	//ComShowMessage("Nothing Selected.");
    			              	ComShowMessage(ComGetMsg("LEA90003"));
    			                return false;
    			            }
    									var url_str = "ESD_LEA_0005.do";
											url_str += "?exe_yrmon="		+formObject.frm_exe_yrmon.value;
											url_str += "&rev_yrmon="		+formObject.frm_rev_yrmon.value;
											url_str += "&acct_cd="		    +formObject.frm_acct_cd.value;
											url_str += "&rev_vvd_no="		+sheetObject.CellValue(sheetObject.SelectRow, "rev_vvd_no");
											url_str += "&bkg_no="		  	+sheetObject.CellValue(sheetObject.SelectRow, "bkg_no").substr(0,13);
											url_str += "&open_div=POP";
    											
    									window.showModalDialog(url_str, window, "dialogWidth:1010px; dialogHeight:480px; help:no; status:no; resizable:yes;");
    									//ComOpenWindow(url_str, "By Container", "statebar=no, width=1000, height=460");
            	        break;

            	    case "btng_downexcel":
            	    
    						//lea_form2sheet(formObject,sheetObject1);
//                sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//    						sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);

       	            //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
            	        break;

            	    case "btns_acct_search":
    									window.showModalDialog('ESD_LEA_0901.do', window, "dialogWidth:800px; dialogHeight:480px; help:no; status:no; resizable:yes;");
            	    					
            	        break;
            	        
            	    case "btns_rev_vvd_search":
    									var url_str = "ESD_LEA_0902.do";
											url_str += "?exe_yrmon="	+formObject.frm_exe_yrmon.value;
											url_str += "&rev_yrmon="	+formObject.frm_rev_yrmon.value;
									        window.showModalDialog(url_str, window, "dialogWidth:600px; dialogHeight:480px; help:no; status:no; resizable:yes;");
											//ComOpenWindow(url_str, "RevVVD", "statebar = no , width= 600 , height=500");
											
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
         * IBSheet Object? ??? ??
         * ?? ?? ???? ????? ??? ?? ? ??? ?? ????? ??? ? ??
         * ??? ?? ??? ??
         */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;


        }

        /**
         * Sheet ?? ?? ? ???
         * body ??? onLoad ?????? ??
         * ??? ?????? ??? ?? ????? ?? ??? ????
         */
        function loadPage() {
             var sheetObj = sheetObjects[0];
             var formObj = document.form;

            for(i=0;i<sheetObjects.length;i++){

            //khlee-?? ?? ?? ?? ?? ??
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-??? ?? ?? ?? ??
                ComEndConfigSheet(sheetObjects[i]);
            }
            if(formObj.winopen_div.value == "POP")
    					doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				
    				
        }

       /**
         * ?? ?????, ?? ??
         * param : sheetObj ==> ??????, sheetNo ==> ?????? ??? ???? ?? ????
         * ??? ??? ?? ?? ??? case? ???? ?? ?????? ????
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //?? ?? ??
                        SheetWidth = mainTable.clientWidth;
                        
                     // 높이 설정
    					style.height = 400;

                        //Host?? ??[??][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //??Merge ?? [??, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //??Edit ?? ?? [??, Default false]
                        Editable = true;

                        //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(11, 2, 0, true);

                       // ???? ??? ? ?? ?? ??? ????
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "SEQ|Exe.Month|Rev.Month|Rev.VVD|BKG#|Estimated\nCost|Actual Cost|Accrual Cost|Confirmed\nCost|Cost Diff|Cost Diff" ;
                        var HeadTitle1 = "SEQ|Exe.Month|Rev.Month|Rev.VVD|BKG#|Estimated\nCost|Actual Cost|Accrual Cost|Confirmed\nCost|Amount|%" ;

                        //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtSeq    ,       30,    daCenter,  true,    "",        false,          "",       dfNone,   	0,     true,        true);
                        InitDataProperty(0, cnt++ , dtHidden ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden ,      100,    daCenter,  true,    "rev_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,       90,    daCenter,  true,    "rev_vvd_no"        ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,       90,    daCenter,  true,    "bkg_no"            ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "estm_cost_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "act_cost_amt"      ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "accl_cost_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "confirmed_cost_amt",        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight,   true,    "cost_diff_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,       70,    daRight,   true,    "cost_diff_per"     ,        false,          "",       dfFloat,  	1,     false,       false);

                        RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);   // ENIS
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        //style.height = GetSheetHeight(13) ;
                   }
                    break;
                case 2:      //IBSheet1 init
                    with (sheetObj) {
                        //?? ?? ??
                        SheetWidth = mainTable.clientWidth;

                        //Host?? ??[??][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //??Merge ?? [??, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //??Edit ?? ?? [??, Default false]
                        Editable = true;

                        //?????[??][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //??????[??][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(7, 0, 0, true);

                       // ???? ??? ? ?? ?? ??? ????
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle  = "Exe.Month|Rev.Month|Account Code|Rev.VVD|BKG#|Cost Diff. Filtering|Cost Diff. Filtering" ;
                        var HeadTitle1 = "Exe.Month|Rev.Month|Account Code|Rev.VVD|BKG#|Amount|percent" ;

                        //?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //?????    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "acct_cd"           ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_vvd_no"        ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "bkg_no"            ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "cost_diff_amt"     ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "cost_diff_per"     ,        false,          "",       dfNone ,     	0,     false,       false);

                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        style.height = GetSheetHeight(13) ;
                   }
                    break;

            }
        }

      // Sheet?? ???? ??
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

               case IBSEARCH:      //??
                   //if(!validateForm(sheetObj,formObj,sAction)) return false;
                   
    					    	formObj.f_cmd.value = SEARCH;
    							  //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0004GS.do", FormQueryString(formObj));
    							  
    							  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0004GS.do", leaFormQueryString(formObj));
    							  
    						    //ComShowMessage(searchXml);
    						    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
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
    	 * ?? Sheet OnSearchEnd Event??? ???? ??.
    	 *
    	 */
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    	   sheetObj.SumText(0,0) = "";
    	   sheetObj.SumText(0,3) = "Grand Total" ;
    	  // sheetObj.SumBackColor  	= sheetObj.RgbColor(153,153,255);
    		 sheetObj.SumFontBold 		= true;
    		 

      		if(sheetObj.SumValue(0,"estm_cost_amt") == 0)
    				sheetObj.SumValue(0,"cost_diff_per") = 0;
    			else
    				sheetObj.SumValue(0,"cost_diff_per") = sheetObj.SumValue(0,"cost_diff_amt")/ sheetObj.SumValue(0,"estm_cost_amt")*100;

    	}

    	/**
    	 * ?? Sheet OnScroll Event??? ???? ??.
    	 *
    	 */
    	 function sheet1_OnScroll(sheet1, oldTopRow, oldLeftCol, newTopRow, newLeftCol){
    	 	 if (oldTopRow != newTopRow ) {
    	 	 		sheet1.SelectRow = newTopRow;
    	 	 }
    	 	
    	}
    	/**
    	 * ?? Sheet change Event??? ???? ??.
    	 *
    	 */
    	function sheet1_OnDblClick(sheet1,row, col){
         var formObject = document.form;
    		if(!lea_com_isSubSumRow(sheet1, row)){
    			
    			var url_str = "ESD_LEA_0005.do";
    					url_str += "?exe_yrmon="		+formObject.frm_exe_yrmon.value;
    					url_str += "&rev_yrmon="		+formObject.frm_rev_yrmon.value;
    					url_str += "&acct_cd="		    +formObject.frm_acct_cd.value;
    					url_str += "&rev_vvd_no="		+sheet1.CellValue(row, "rev_vvd_no");
    					url_str += "&bkg_no="		  	+sheet1.CellValue(row, "bkg_no").substr(0,13);
    					url_str += "&open_div=POP";
    			window.showModalDialog(url_str, window, "dialogWidth:1110px; dialogHeight:600px; help:no; status:no; resizable:yes;");
    					//ComOpenWindow(url_str, "By Container", "statebar = no , width= 1100 , height=600");
    		}
    	}
       /**
         * ?? ????? ?? ????? ???? ??
         */
         
        function validateForm(sheetObj,formObj,sAction){
    				if(!lea_comm_validChkForm(formObj)) return false;
    	  		if((formObj.frm_acct_cd.value == "" || formObj.frm_acct_cd.value == null || formObj.frm_acct_cd.value == "ALL" ) &&
    	  		   (formObj.frm_vvd_no .value == "" || formObj.frm_vvd_no .value == null || formObj.frm_vvd_no .value == "ALL" ) &&
    	  		   (formObj.frm_bkg_no .value == "" || formObj.frm_bkg_no .value == null) ){
    	     		 
    	     		 ComShowMessage(ComGetMsg("LEA90004","Acc. Code","Rev. VVD ","BKG No."));
    	  		   //	ComShowMessage("Please enter  Acc. Code or Rev. VVD or BKG No. ");
    	  		   	return false;
    	  		}
            return true;
        }
       /**
         * EnterKey Event ?? ???? ??
         */
    		function lea_enterRetrieve(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
    			  sheetObject.RemoveAll();
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			
    		}
    		
       /**
         * Form Data?Sheet? Copy ???? ??
         */
    		function lea_form2sheet(formObj,sheetObj){
    			
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "exe_yrmon" ) = formObj.frm_exe_yrmon.value;
    			sheetObj.CellValue(Row , "rev_yrmon" ) = formObj.frm_rev_yrmon.value;
    			sheetObj.CellValue(Row , "acct_cd"   ) = formObj.frm_acct_cd  .value;
    			sheetObj.CellValue(Row , "rev_vvd_no") = formObj.frm_vvd_no   .value;
    			sheetObj.CellValue(Row , "bkg_no"    ) = formObj.frm_bkg_no   .value;
    			if(getRadioValue(formObj.frm_diff_div) == "A")
    				sheetObj.CellValue(Row , "cost_diff_amt") = formObj.frm_cost_diff_amt.value;
    			else
    				sheetObj.CellValue(Row , "cost_diff_per") = formObj.frm_cost_diff_per.value;
    		}
    		
    		
       /**
         * ??? Radio ?? ??
         */
    		function lea_selectRadio(obj1,obj2){
    			if(obj1.name == "frm_cost_diff_amt"){
    				document.form.frm_diff_div[0].checked = true; 
    				obj2.value = 0;
    			}else{
    				document.form.frm_diff_div[1].checked = true; 
    				obj2.value = 0;
    			}
    		}

	/* 개발자 작업  끝 */