/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0123.js
*@FileTitle  : Filing List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/



   	/* 개발자 작업	*/
    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheetMain;
    var sheetExcel;
    var sheetHead;
    var arrXml;
    var SearCondition = null;
    
    //  업무전역변수
    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function loadPage() {
        var form=document.form;	
        sheetMain=sheetObjects[0];
        sheetExcel=sheetObjects[1];
        sheetHead=sheetObjects[2];
        sheetCnt=sheetObjects.length ;
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
        axon_event.addListenerForm('click', 'obj_click', document.form);
	   	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
		// 당일 날짜로 default setting
		gCurrDate=ComGetDateAdd(null, "D", 0)
	    //form.exec_dt.value = gCurrDate;
	    form.fr_file_dt.value=gCurrDate;
	    form.to_file_dt.value=gCurrDate;
	    disableSheetLoadingImage();
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    }
     /**
      * OnKeyDown event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param 없음
      * @return 없음
      * @author 강효진
      * @version 2010.04.26
      */       
     function obj_keydown(){
        //enter key조회
        var eleName=event.srcElement.name;
        if (eleName == "fr_file_dt" || eleName == "to_file_dt"){
            var keyValue=null;
            if(event == undefined || event == null) {
         	   keyValue=13;
            }else{
         	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            }
            if (keyValue == 13){
         	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        } 

     }
     
     
     /**
     * Object 's Onclick Event Handler <br>
     * Checking validtaion by object's dataformat  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.09.04
     */
    function obj_click(){
    	var form=document.form;
        var obj=event.srcElement;

        switch(ComGetEvent("name")){
            case "inq_tp_rdo":
            	setParam(document.form);
            	break;
        }
    }
     
     /** 
      * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
      * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음  
      * @return 없음
      * @see #
      * @author 강효진
      * @version 2010.04.23
      */ 
     function obj_deactivate() {
         var form=document.form;
         var formObj=event.srcElement;
         ComChkObjValid(formObj);
     }
    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetMain) {

            	var HeadTitle = "|File Date|Seq.|BKG Source|BKG No." +
		        "|Carrier|SCRA No.|Contractor|Shipper|Consignee|Foreign Trade\nCompany|Operation\nAgent|Service\nLane" +
		        "|Wayport|POL|Departure\nTransit Port|Destination\nTransit Port|POD|Transportation\nTerm|Cntr\nType|Commodity|Cntr\nSize|Cntr\nVolume 1|Cntr\nVolume 2" +
				"|Base\nRate" +
				"|AGREEMENT\nEFFECTIVE TIME|AGREEMENT\nEXPIRY DATE|REMARK";

                var headCount=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"Status" },
                             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bat_exe_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_src_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"carrier",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_hld_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"bkg_shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"bkg_cnee_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fore_tra_comp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"oper_agt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"way_port",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dept_tsit_port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_tsit_port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trans_term",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sz",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"oft_rt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"remark",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }

                ];

            	
            	InitColumns(cols);

            	SetColHidden( "bat_exe_dt" ,1);
            	SetColHidden( "bkg_src_tp_cd" ,1);
            	SetColHidden( "bkg_no" ,1);
            	

            	resizeSheet();

            	
                }
                break;
            case "sheet2":
                with (sheetExcel) {

            	var HeadTitle = "|File Date|Seq.|BKG Source|BKG No." +
		        "|Carrier|SCRA No.|Contractor|Shipper|Consignee|Foreign Trade\nCompany|Operation\nAgent|Service\nLane" +
		        "|Wayport|POL|Departure\nTransit Port|Destination\nTransit Port|POD|Transportation\nTerm|Cntr\nType|Commodity|Cntr\nSize|Cntr\nVolume 1|Cntr\nVolume 2" +
				"|Base\nRate" +
				"|AGREEMENT\nEFFECTIVE TIME|AGREEMENT\nEXPIRY DATE|REMARK";
			
                
                var headCount=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"Status" },
                             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bat_exe_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_src_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"carrier",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_hld_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"bkg_shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"bkg_cnee_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fore_tra_comp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"oper_agt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"way_port",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dept_tsit_port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_tsit_port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trans_term",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sz",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"oft_rt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"remark",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }

                ];
            	
            	InitColumns(cols);

                SetColHidden( "bat_exe_dt" ,1);
                SetColHidden( "bkg_src_tp_cd" ,1);
                SetColHidden( "bkg_no" ,1);

                SetSheetHeight(450);
                
                }
                break;

            case "sheet3":
                with (sheetHead) {

            	var HeadTitle = "CHG_NM|CHG_TY|SEQ";
			
                
                var headCount=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                
                InitHeaders(headers, info);

                var cols = [ 
                             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"chg_lst",       KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"chg_ty",        KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"ind",           KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 }

                ];
            	
            	InitColumns(cols);
                SetSheetHeight(450);
                
                }
                break;                
                
        }
    }
    
    function rebindSheet(sheetObj, headerSheetObj) {
    		

            with (sheetObj) {

		        	var HeadTitle = "|File Date|Seq.|BKG Source|BKG No." +
			        "|Carrier|SCRA No.|Contractor|Shipper|Consignee|Foreign Trade\nCompany|Operation\nAgent|Service\nLane" +
			        "|Wayport|POL|Departure\nTransit Port|Destination\nTransit Port|POD|Transportation\nTerm|Cntr\nType|Commodity|Cntr\nSize|Cntr\nVolume 1|Cntr\nVolume 2" +
					"|Base\nRate";
		        	
		        	var comRowIdx = sheet3.FindText("chg_ty", "COM", 0, 2);
		        	if(comRowIdx >= 0) {
		        		HeadTitle += "|"+headerSheetObj.GetCellValue(comRowIdx, "chg_lst").replace("'","");
		        	}
		        	
		        	for(var i=1; i <= headerSheetObj.RowCount();i++){
		        		
		        		var tmp = headerSheetObj.GetCellValue(i, "chg_ty");
		        		if(tmp != "COM") {
		        			HeadTitle += "|"+headerSheetObj.GetCellValue(i, "chg_lst").replace("'","");
		        		}
		        	}
		        	
		        	HeadTitle = HeadTitle + "|AGREEMENT\nEFFECTIVE TIME|AGREEMENT\nEXPIRY DATE|REMARK";
		
		            var headCount=ComCountHeadTitle(HeadTitle);
		
		            SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            
		            InitHeaders(headers, info);
		
		            var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"Status" },
		                         {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bat_exe_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_src_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"carrier",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_hld_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"bkg_shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"bkg_cnee_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fore_tra_comp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"oper_agt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"way_port",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dept_tsit_port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_tsit_port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
		                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trans_term",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_tp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sz",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"oft_rt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         
		
		            ];
		            
		            
		            //2015.05.07 just display the origin database data
		            cols.push( {Type:"Text", Hidden:0, Width:80, Align:"Right", ColMerge:0, SaveName:"com", KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 } );
		            for(var j=1; j <= headerSheetObj.RowCount();j++){
		            	var colName = headerSheetObj.GetCellValue(j, "chg_ty").toLowerCase();
		            	var lstName = colName.substr(colName.length-3, 3);
		            	if(lstName != "com") {
		            		cols.push( {Type:"Text", Hidden:0, Width:50, Align:"Right", ColMerge:0, SaveName:colName, KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 } );
		            	}
		            	
		        	}
		            
		            cols.push({Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		            cols.push({Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"remark",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 });
		        	
		        	InitColumns(cols);
		
		        	SetColHidden( "bat_exe_dt" ,1);
		        	SetColHidden( "bkg_src_tp_cd" ,1);
		        	SetColHidden( "bkg_no" ,1);
		        	
		        	resizeSheet();

        	

            }
            
            disableSheetLoadingImage();
    }
    
    
    
    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick=processButtonClick;
    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function processButtonClick(){
        var form=document.form;
        var rdoDateObj=form.rdoDate;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetMain, form, IBSEARCH);
                    break;
                case "btn_Downexcel":
                    doActionIBSheet(sheetMain, form, IBDOWNEXCEL);
                    break;
       		    case "btns_calendar": //To 달력버튼
       		    	var cal=new ComCalendarFromTo();
                    cal.select(form.fr_file_dt, form.to_file_dt, 'yyyy-MM-dd');
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */
    
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetMain.ShowDebugMsg(false);
        switch(sAction) {
        
	        case IBSEARCH_ASYNC01: 
	            
	            formObj.f_cmd.value=COMMAND01;
	            setParam(formObj);
	            var sXml  = sheetMain.GetSearchData("ESM_PRI_0123GS.do", FormQueryString(formObj) );
	            if(sXml != null && sXml.length > 0) {
	            	sheetHead.LoadSearchData(sXml);
	            }
	
	            break;
            
            case IBSEARCH: //조회
            	//ComOpenWait(true);
            	//setTimeout(function() {ComOpenWait(true);}, 10);

            	//set the condition for SEARCH
                makeSearchCondition();
            	
                formObj.f_cmd.value=SEARCH;
                setParam(formObj);
                var sXml  = sheetMain.GetSearchData("ESM_PRI_0123GS.do", FormQueryString(formObj) );
                arrXml= sXml.split("|$$|");
                if(arrXml[0] != null && arrXml[0].length > 0) {
                	sheetHead.LoadSearchData(arrXml[0]);
                }

                break;
            
            case IBDOWNEXCEL:      //download excel
            	if ( sheet1.RowCount()<= 0) return;
            	
            	doDownExcel(sheet1);

	           	break; 
	           	
	           	
            
        }
    }
    

    
	function setParam(formObj){
		formObj.inq_tp_cd.value=ComGetObjValue ( formObj.inq_tp_rdo );		
	}
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	 function validateForm(sheetObj,formObj,sAction){
		  var frFileDt=form.fr_file_dt;
		  var toFileDt=form.to_file_dt;
		  var execDt=form.exec_dt;
		  switch (sAction) {
		      case IBSEARCH: //조회
			      //Filing Date 입력했는지 mandatory validation
			      if(formObj.fr_file_dt.value == "") {
			    	  ComShowCodeMessage("PRI00335", frFileDt.caption);
			    	  ComSetFocus(frFileDt);
			    	  return false;
			      }
			      if(formObj.to_file_dt.value == "") {
			    	  ComShowCodeMessage("PRI00335", toFileDt.caption);
			    	  ComSetFocus(toFileDt);
			    	  return false;
			      }
			      // from date가 to date보다 큰지 validation
			      if(!ComChkObjValid(frFileDt)) { return false; }
			      if(!ComChkObjValid(toFileDt)) { return false; }			      		
			      break;
		  }
		 return true;
	 }
 	/**
      * OnSearchEnd 시 발생한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} ErrMsg    
      * @return 없음
      * @author 이승준
      * @version 2009.06.10
      */
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
  		
  		ComOpenWait(false);
  		
  		var formObj=document.form;
  		if ( formObj.inq_tp_cd.value == "2") {
  			sheetObj.SetColHidden( "bkg_src_tp_cd" ,0);
  			sheetObj.SetColHidden( "bkg_no" ,0);
  		} else {
  			sheetObj.SetColHidden( "bkg_src_tp_cd" ,1);
  			sheetObj.SetColHidden( "bkg_no" ,1);
  		}
  		if ( ComGetDaysBetween ( formObj.fr_file_dt.value, formObj.to_file_dt.value ) >= 1 ) {
  			sheetObj.SetColHidden( "bat_exe_dt" ,0);
  		} else {
  			sheetObj.SetColHidden( "bat_exe_dt" ,1);
  		} 	
  		
  		//2015.05.12 display null to 0
  		//the data in database is null and col type is text type
  		//(display origin database data -> customer request)
  		//so there is no way to display null to 0 
  		//that is the reason why change null to 0
  		//db에 값 그대로(소수점 포멧 지정불가 및 넘버값과 text값을 동일 컬럼 위치에서 pivot하므로 to_char로 함)
  		//to_char경우 포멧지정이 가능하나, 소수 2, 3자리가 그대로 보여야 하므로 일정한 포멧지정 불가
  		//따라서, 화면에서 밖에 처리 할 수 밖에 없음
  		//2015.05.12 화면에서 포멧지정가능하나 획일화 되어 그리드에서 포멧지정 불가  null인 부분을 강제 0 처리
  		//2015.05.28 1보다 작은 소수점은 to_char시에 .55와 같이 나옮 -> 이를 화면에서 수동 예외 처리함
  		var rowCnt = sheetObj.RowCount();
  		for(var i=1; i <= rowCnt;i++) {
  			for(var j=1; j < sheetHead.RowCount();j++){
  	        	var colName = sheetHead.GetCellValue(j, "chg_ty").toLowerCase();
  	        	var lstName = colName.substr(colName.length-3, 3);
  	        	var sVal = sheetObj.GetCellValue(i, lstName);
  	        	
  	        	if(lstName != "cur" && lstName != "exe" && (sVal == null || sVal == "")) {
  	        		sheetObj.SetCellValue(i, lstName, "0");
  	        	} else if(lstName != "cur" && lstName != "exe" && sVal != null && sVal != "") {
  	        		var tVal = sVal.substring(0,1);
  	        		if(tVal == ".") {
  	        			sheetObj.SetCellValue(i, lstName, "0"+sVal);
  	        		}
  	        	}
  	        	
  	    	}
  			
  		}
  		
  		
        
  	}
  	
  	function sheet3_OnSearchEnd(sheetObj, ErrMsg)  {
	      if(sheetObj.RowCount() > 0) {
	    	  
	    	  
	    	//----------------------------------------------------------
	      	//Excel용 sheet초기화 설정 및 데이터 로딩
	      	//reset으로 인해 참조번지수가 달라지는 것을 방지
	      	sheet2 = sheet2.Reset();
	      	ComConfigSheet(sheet2); 
	      	rebindSheet(sheet2, sheetHead);
	        ComEndConfigSheet(sheet2);
	        sheetObjects[1] = sheet2;
	        //-----------------------------------------------------------

	        //-----------------------------------------------------------
	        //Main Sheet초기화
	    	//reset으로 인해 참조번지수가 달라지는 것을 방지
	    	sheet1 = sheet1.Reset();
	    	ComConfigSheet(sheet1); 
	    	rebindSheet(sheet1, sheetObj);
	        ComEndConfigSheet(sheet1);
	        sheetObjects[0] = sheet1;
	        
	        //pivot후 생기는 컬럼명에 '때문에 이를 위한 제거 및 복원처리
	        var sXml = arrXml[1].replace("'>","^>").replace(/'/g,"").replace("TOTAL=","TOTAL='").replace("^>","'>").replace("COLORDER=","COLORDER='").replace("COLSEPARATOR=☜☞","' COLSEPARATOR='☜☞'");

	        sheetObjects[0].LoadSearchData(sXml);
	        //-----------------------------------------------------------

	      }
  	}
  	
  	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
  	
  	function doDownExcel(sheetObj) {
  		var formObj=document.form;
  		
  		if(!isChangeSearchCondition()){   		
  			//var msg = "Search option was changed, please click 'Retrieve' button again.";
  			ComShowCodeMessage("PRI02020");
  			sheetObj.RemoveAll();
  			sheetObj.SetEtcData("TOTAL", 0);
  			sheet1_OnSearchEnd(sheetObj);
  			return;
  		}
  		
  		
  		var lstTotal = sheetObjects[0].RowCount();
        if(sheetObjects[0].RowCount() > 0 && lstTotal <= 35000){
        	
        	var colName = "";
        	var colTitle = "";
        	var colCnt = sheetObjects[0].LastCol();
        	for(var i = 0; i <=colCnt; i++){
	    		var isColHidden = sheetObjects[0].GetColHidden(i);


	    		if(isColHidden == 0 && (i != colCnt)){
	    			colName += sheetObjects[0].ColSaveName(0, i) + "|";
	    			colTitle += sheetObjects[0].GetCellValue(0, i) + "|";
	    		}
	    		if(i == colCnt ){
	    			colName += sheetObjects[0].ColSaveName(0, i);
	    			colTitle += sheetObjects[0].GetCellValue(0, i) + "|";
	    		}
        	}

        	formObj.col_nm.value = colName;
        	formObj.col_title.value = colTitle.replace(/\n/gi," ");
        	formObj.f_cmd.value=SEARCH01;
			formObj.target="_top";
            formObj.action="ESM_PRI_0123DL.do?"+FormQueryString(formObj);
            formObj.submit();
            sheetObj.RemoveEtcData(); // Delete ETC data
        	
        } else if(sheetObjects[0].RowCount() > 1 && lstTotal > 35000){
        	ComShowCodeMessage("PRI02021");
        }
        
        formObj.col_nm.value = "";
    	formObj.col_title.value = "";

  	
  	}
  	
  	/**
  	 * set the condition for search <br>
  	 * @version 2016.04.21
  	 */  
  	function makeSearchCondition(){
  		
  		var formObj = document.form;

  		var sDate = formObj.fr_file_dt.value;
  		var eDate = formObj.to_file_dt.value;
  		var type = formObj.inq_tp_cd.value;

  		SearCondition = new Object();
  		SearCondition.S_DT = sDate;
  		SearCondition.E_DT = eDate;
  		SearCondition.TYPE = type;

  	}
  	
  	function isChangeSearchCondition(){
  		
  		var result = true;
  		var formObj = document.form;
  		
  		var sDate = formObj.fr_file_dt.value;
  		var eDate = formObj.to_file_dt.value;
  		var type = formObj.inq_tp_cd.value;
  	
  		if(sDate != SearCondition.S_DT) return false;
  		if(eDate != SearCondition.E_DT) return false;
  		if(type != SearCondition.TYPE) return false;

  		return result;
  		
  	}
  	
  	function disableSheetLoadingImage(){
  		sheetObjects[0].SetWaitImageVisible(0);
	    sheetObjects[1].SetWaitImageVisible(0);
	    sheetObjects[2].SetWaitImageVisible(0);
  	}
  	
  	
	/* 개발자 작업  끝 */
