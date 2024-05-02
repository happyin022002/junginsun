/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0248.jsp
*@FileTitle : MNR SOL Invoice File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2015.02.25Jun Kato
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
//   /**
//     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
//     * @author 한진해운
//     */

    /**
     * @extends 
     * @class EES_MNR_0248 : business script for EES_MNR_0248.
     */
var opener;
     
    function EES_MNR_0248() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.keypressFormat			= keypressFormat;
		this.doActionIBSheet 		= doActionIBSheet;
    }
    
   	/* 개발자 작업	*/

  	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
    var sXml_1 = "";
    var okFlag = "";
    
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_downExcel":
					doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
					break;  
				case "btn_downExcel1":
					sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1});
					break;
				case "btn_ok":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC06);
					
					break;  
				case "btn_close":
					doActionIBSheet(sheetObject1, formObject, "doClose");
					break;
				case "btn_loadExcel":
					doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
                    break;
				case "btn_verify":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC05);
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
    * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
    * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
    * @param {ibsheet} sheet_obj    IBSheet Object
    **/
   function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++] = sheet_obj;
   }
       
    /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
    function loadPage() {
    	opener = window.dialogArguments;
    	if (!opener)
    		opener = parent;
    	for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
    	initControl();
    	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
    
     
    function initControl() {
       	var formObject = document.form;
       	axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
       	ComBtnDisable('btn_ok');
       	ComBtnDisable('btn_verify');

    }
          
    /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
		var sheetid=sheetObj.id;
        switch(sheetid) {
             case "sheet1":
            	    with(sheetObj){
                
            	 var HeadTitle="||Seq|Currency|Vendor|Invoice\nTotal|Invoice\nVAT|Withholding\nTAX|Invoice\nNumber|Received\nDate|Invoice\nDate|Office|Errors|";
            	 var headCount=ComCountHeadTitle(HeadTitle);
               (headCount + 2, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ 
                           {Type:"Status",    Hidden:1,  Width:10,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                           {Type:"Text",      Hidden:1,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"mnr_rcv_ord_inv_tmp_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Seq",       Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"tmp_seq"},
                           {Type:"Text",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              				 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",            				 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:80,    Align:"Right",   ColMerge:0,   SaveName:"inv_amt",           					 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"vat_amt",          					 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"inv_whld_tax_amt",        			 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               				 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"PopupEdit",      Hidden:0,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",               				 KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Date",      Hidden:0,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",             			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",           				 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:270,   Align:"Left",    ColMerge:0,   SaveName:"vrfy_rslt_desc",          			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
                           {Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"dummy",       	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           ];
               
               
               InitColumns(cols);
               SetSheetHeight(200);
               SetCountPosition(4);
                     }
				break;
			case "sheet2":
			    with(sheetObj){
		       
//				var HeadTitle1="|Seq|Equipment\nType|Equipment\nNumber|Status|QTY|Currency|Cost\nAmount|Activity\nDate|Vessel|Voyage|Service|Port|Facility|Tariff\nItem|Vendor|Invoice\nTotal|Invoice\nVAT|Withholding\nTax|Invoice\nNumber|Received\nDate|Invoice\nDate|Office|External\nReference|Error|MNR_VRFY_TP_CD";
				var HeadTitle1="|Seq|Equipment Type|Equipment Number|Tp/Sz|Status|QTY|Currency|Cost Amount|Activity Date|VVD|Facility|Tariff Item|Vendor|Error||Invoice Total|Invoice VAT|Withholding Tax|Invoice Number|Received Date|Invoice Date|Office|External Reference|MNR_VRFY_TP_CD";
				var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount+7, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];

		      InitHeaders(headers, info);

		      var cols = [ 
		                  	 {Type:"Status",    Hidden:1,  Width:10,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:30,    Align:"Center",  ColMerge:0,   SaveName:"jb_ordr_seq" ,         KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",           	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,   Align:"Left",    ColMerge:0,   SaveName:"eq_no",               	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",    ColMerge:0,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",    ColMerge:0,   SaveName:"eq_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"rpr_qty",         		KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"cost_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",           PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpr_rslt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,    Align:"Center",    ColMerge:0,   SaveName:"vvd",               	KeyField:0,   CalcLogic:"",   Format:"",           		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },   
//				             {Type:"Text",      Hidden:0,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"port",                 KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_cd_all",          KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:210,   Align:"Left",    ColMerge:0,   SaveName:"vrfy_rslt_desc",       KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTip:1 },
				             {Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"dummy",       	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",      	  	PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",           PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"inv_whld_tax_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",           PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:1,  Width:80,    Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:1,  Width:75,    Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"ord_dtl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",       	  		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 
		                     {Type:"Text",      Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"mnr_vrfy_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",       	  		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"cost_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"cost_dtl_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",           		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		                     ];
		      

		      InitColumns(cols);
		      SetCountPosition(4);
		      SetSheetHeight(200);
//		      SetVisible(0);
		            }


				break;
				
			case "sheet3":
                with (sheetObj) {
//				var HeadTitle1="Seq|Equipment\nType|Equipment\nNumber|Status|QTY|Currency|Cost\nAmount|Activity\nDate|Vessel|Voyage|Service|Port|Facility|Tariff\nItem|Vendor|Invoice\nTotal|Invoice\nVAT|Withholding\nTax|Invoice\nNumber|Received\nDate|Invoice\nDate|Office|External\nReference|Error";
				var HeadTitle1="Seq|Equipment Number|Status|QTY|Currency|Cost Amount|Activity Date|VVD|Facility|Tariff Item|Vendor|Invoice Total|Invoice VAT|Withholding Tax|Invoice Number|Received Date|Invoice Date|Office|External Reference|Error";
				var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount+7, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];

		      InitHeaders(headers, info);

		      var cols = [ 
				             {Type:"Text",     Hidden:0,  Width:30,    Align:"Center",  ColMerge:0,   SaveName:"jb_ordr_seq" ,         				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				             {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",           				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:"eq_no",               				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:"eq_sts_cd",               		      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:80,    Align:"Left",    ColMerge:0,   SaveName:"rpr_qty",         					  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:80,    Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",    Hidden:0,  Width:40,    Align:"Right",   ColMerge:0,   SaveName:"cost_amt",                            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rslt_dt",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"vvd",                          	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"skd_voy_no",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"service",                          	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"port",                          	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:60,    Align:"Right",   ColMerge:0,   SaveName:"yd_cd",                               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Left",    ColMerge:0,   SaveName:"cost_cd",                             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",     Hidden:0,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",             				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",    Hidden:0,  Width:80,    Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              				  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",    Hidden:0,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"vat_amt",                             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",    Hidden:0,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"inv_whld_tax_amt",                    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",     Hidden:0,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",     Hidden:0,  Width:80,    Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",     Hidden:0,  Width:75,    Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",     Hidden:0,  Width:70,    Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",           	          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",     Hidden:0,  Width:70,    Align:"Right",   ColMerge:0,   SaveName:"ord_dtl_rmk",            			  KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",     Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"vrfy_rslt_desc",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 ];

		      InitColumns(cols);
//		      SetCountPosition(0);
		      SetSheetHeight(400);
		      SetVisible(0);
				}
                break;
        }
    }
    

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
    case IBCLEAR:      // Initializing
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			ComBtnDisable('btn_ok');
			ComBtnDisable('btn_verify');
			ComBtnDisable('btn_downExcel1');
			okFlag = "";
			formObj.upd_tp.value = "E";
		
			break;
    
	case IBDOWNEXCEL:
		sheetObjects[2].RemoveAll();
		var Row=sheetObjects[2].DataInsert(-1);
		var Row1=sheetObjects[2].DataInsert(-1);
		var Row2=sheetObjects[2].DataInsert(-1);
		
		
		sheetObjects[2].SetCellValue(Row,"jb_ordr_seq","HEADER");
		sheetObjects[2].SetCellValue(Row,"curr_cd","SGD");
		sheetObjects[2].SetCellValue(Row,"vndr_seq","100001");
		sheetObjects[2].SetCellValue(Row,"inv_amt","0");
		sheetObjects[2].SetCellValue(Row,"vat_amt","0");
		sheetObjects[2].SetCellValue(Row,"inv_whld_tax_amt","0");
		sheetObjects[2].SetCellValue(Row,"inv_no","XXXXX");
		sheetObjects[2].SetCellValue(Row,"rcv_dt","2015-01-01");
		sheetObjects[2].SetCellValue(Row,"inv_cfm_dt","2015-01-01");
		sheetObjects[2].SetCellValue(Row,"cost_ofc_cd","SINBB");
		sheetObjects[2].SetRowBackColor(Row, "#FFFF00");
		
		sheetObjects[2].SetCellValue(Row1,"jb_ordr_seq","1");
		sheetObjects[2].SetCellValue(Row1,"eq_no","NYKU0000000");
		sheetObjects[2].SetCellValue(Row1,"eq_sts_cd","E");
		sheetObjects[2].SetCellValue(Row1,"rpr_qty","1");
		sheetObjects[2].SetCellValue(Row1,"curr_cd","SGD");
		sheetObjects[2].SetCellValue(Row1,"cost_amt","0");
		sheetObjects[2].SetCellValue(Row1,"rpr_rslt_dt","2015-01-01");
		sheetObjects[2].SetCellValue(Row1,"yd_cd","SGSIN04");
		sheetObjects[2].SetCellValue(Row1,"cost_cd","MRDRRCNR");
		sheetObjects[2].SetCellValue(Row1,"vndr_seq","100001");
//		sheetObjects[2].SetCellValue(Row1,"inv_no","XXXXX");
		sheetObjects[2].SetRowBackColor(Row1, "#FFFF00");
		
		sheetObjects[2].SetCellValue(Row2,"eq_no","Please delete the sample data when you input your data");
		
		sheetObjects[2].Down2Excel({SheetDesign:1});
		sheetObjects[2].RemoveAll();
		
    	break;
    
    //Load Excel
	case IBLOADEXCEL:
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		okFlag = "";
		ComBtnDisable('btn_ok');
		ComBtnDisable('btn_verify');
		ComBtnDisable('btn_downExcel1');
//		sheetObjects[1].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:'3'});
//		sheetObjects[1].LoadExcel({ Mode:"HeaderMatch", FileExt:"csv"});
		if(formObj.upd_tp[0].checked){
			sheetObjects[1].LoadExcel({ Mode:"HeaderMatch" });
		}else if(formObj.upd_tp[1].checked){
			sheetObjects[1].LoadText({ Mode:"HeaderMatch" , FileExt:"csv", Deli:","});
		}
//		sheetObjects[1].LoadExcel({ Mode:"HeaderMatch" });
		break;
    	
    //Close
    case "doClose":
		ComClosePopup(); 
		break;
		
    case IBSEARCH_ASYNC05:
    	if(validateForm(sheetObj,formObj,sAction)){
//    		ComOpenWait(true,true);
    		formObj.f_cmd.value = MULTI;
    		
    		ComOpenWait(true);
			sheetObj.SetWaitImageVisible(0);

    		var sParam1 = sheetObjects[0].GetSaveString(1, 1, "ibflag", "HDR_");
    		var sParam2 = sheetObjects[1].GetSaveString(1, 1, "jb_ordr_seq", "DTL_");
    		
//    		sParam2 = sParam2.replace(/%20/g, "");
    		
    		var sParam = sParam1 +"&"+ sParam2;
        	var sXml=sheetObj.GetSaveData("EES_MNR_0248GS.do", FormQueryString(formObj) +"&"+ sParam);

        	var arrXml=sXml.split("|$$|");
    		for(var i=0; i < arrXml.length; i++){
    			//not to count double in count position 
    			sheetObjects[i].RemoveAll();
    			
    			sheetObjects[i].LoadSaveData(arrXml[i],{Sync:1} );
    		}
    		var length1 = 0;
    		var length2 = 0;
    		var btnCtrl = true;
    		var wrngCtrl = true;
    		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
    			var vrfy = true;
    			var vrfy_wrng = true;
    			//To change color on the row which has error code
    			if(sheetObjects[0].GetCellValue(i,"vrfy_rslt_desc").trim() != "Success"){
    				vrfy = false;
    				btnCtrl = false;
    	    	}
    			
    			var hdr_inv = sheetObjects[0].GetCellValue(i,"inv_no").trim();
    			
    				for(var y=sheetObjects[1].HeaderRows(); y<=sheetObjects[1].LastRow(); y++) {
    					if (hdr_inv ==sheetObjects[1].GetCellValue(y,"inv_no").trim() ){
    						
    						//To change color on the row which has error code
    						if(sheetObjects[1].GetCellValue(y,"mnr_vrfy_tp_cd").trim().substring(0,1) == "E"){
    							sheetObjects[1].SetRowBackColor(y,"#F7E5FF");
    							vrfy = false;
    							btnCtrl = false;
    						}else if (sheetObjects[1].GetCellValue(y,"mnr_vrfy_tp_cd").trim().substring(0,1) == "W"){
    			    		   		sheetObjects[1].SetRowBackColor(y,"#FFFF99");
    			    		   		var vrfy_wrng = false;
//    			    		   		btnCtrl = false;
    						}
    			        }
    					var tmpLength2 = parseInt(sheetObjects[1].GetCellValue(y, "vrfy_rslt_desc").length);
    					if(length2 == 0){
    						length2 = tmpLength2;
    					}else{
    						if(tmpLength2 > length2){
    							length2 = tmpLength2;
    						}
    					}
    				}
    			
    			if(!vrfy){
    				sheetObjects[0].SetRowBackColor(i,"#F7E5FF");
    			}else if(!vrfy_wrng){
    				wrngCtrl = false;
    				sheetObjects[0].SetRowBackColor(i,"#FFFF99");
    			}
    			
    			var tmpLength1 = parseInt(sheetObjects[0].GetCellValue(i, "vrfy_rslt_desc").length);
				if(length1 == 0){
					length1 = tmpLength1;
				}else{
					if(tmpLength1 > length1){
						length1 = tmpLength1;
					}
				}
    		}
    		
    		length1 = 70+ length1*5;
    		length2 = 70+ length2*5;
    		if(length1>270)
    			sheetObjects[0].SetColProperty(0, "vrfy_rslt_desc", {Width:length1});
    		if(length2>210)
    			sheetObjects[1].SetColProperty(0, "vrfy_rslt_desc", {Width:length2});
//    		ComOpenWait(false,true);
    		
    		
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
    		if(btnCtrl){
    			if(!wrngCtrl){
    				ComShowCodeMessage("MNR00389");
    				sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1});
    				ComBtnEnable('btn_downExcel1');
    			}
    			ComBtnEnable('btn_ok');
    		}
    		
    	}
    	
    	break;
		
    	case IBSEARCH_ASYNC06:
    		formObj.f_cmd.value = MULTI01;
    		okFlag = "Y";
    		if(!ComShowCodeConfirm("MNR00275", "invoice", "save")){
    			return;
    		}
    		
    		ComOpenWait(true);
			sheetObj.SetWaitImageVisible(0);
			
    		var sParam1 = sheetObjects[0].GetSaveString(1, 1, "ibflag", "HDR_");
    		var sParam2 = sheetObjects[1].GetSaveString(1, 1, "jb_ordr_seq", "DTL_");
    		var sParam = sParam1 +"&"+ sParam2;
        	var sXml=sheetObj.GetSaveData("EES_MNR_0248GS.do", FormQueryString(formObj) +"&"+ sParam);
        	var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
			if (backendJobKey.length > 0) {
				ComSetObjValue(formObj.backendjob_key, backendJobKey);
				sheetObj.SetWaitTimeOut(10000);
				timer1=setInterval(getBackEndJobStatus, 3000);
			}
			
//        	var arrXml=sXml.split("|$$|");
////    		for(var i=0; i < arrXmllength; i++){
////    			sheetObjects[i].LoadSaveData(arrXml[i],{Sync:1} );
////    		}
////        	sheetObjects[2].LoadSaveData(sXml,{Sync:1} );
//    		if (ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S") {
//        		for(var i=0; i < arrXml.length; i++){
//        			sheetObjects[i].RemoveAll();
//        			sheetObjects[i].LoadSaveData(arrXml[i],{Sync:1} );
//        		}
//        		var vrfy = true;
//        		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++){
//        			if(sheetObjects[0].GetCellValue(i, "vrfy_rslt_desc") != "Success"){
//        				sheetObjects[0].SetRowBackColor(i,"#FFFF99");
//        				vrfy = false;
//        			}
//        			for(var j=sheetObjects[1].HeaderRows(); j<=sheetObjects[1].LastRow(); j++){
//            			if(sheetObjects[1].GetCellValue(j, "vrfy_rslt_desc") != "Success"){
//            				sheetObjects[1].SetRowBackColor(j,"#FFFF99");
//            			}
//            		}
//        		}
//
//        		if(!vrfy){
//        			ComShowCodeMessage("MNR00381");
//        			ComDisEnable("btn_ok");
//        			ComDisEnable("btn_verify");
//        		}else{
//        			ComShowCodeMessage("MNR00086");
//    				opener.setPopData_InvCrr(sheetObjects[0].GetCellValue(1, "inv_no"));
//    				ComClosePopup(); 
//        		}
//			}
//			else {
////				ComShowCodeMessage("MNR00001");
//				sheet2.LoadSaveData(arrXml[0]);
//			}
    		
    	break;
        }
    }    
    
    /**
     * Add Key format event for each data type.
     * ComKeyOnlyAlphabet() comes from CoFormControl.js
     */
    
    function keypressFormat() {
       	obj = event.srcElement;
     	    switch(obj.onKeyPress) {
     	        case "uppernum":
     	        	ComKeyOnlyAlphabet("uppernum","/");
     	            break;
     	    }
    }
    
    function sheet2_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
//    	if(result) {
		var inv_no = "";
    		for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
	 			
    			if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq").toUpperCase() == "HEADER"){
	 				
    				if(!ComIsDate(sheetObjects[1].GetCellValue(i,"inv_cfm_dt"))){
    					var errInvNo = sheetObjects[1].GetCellValue(i,"inv_no");
    					sheetObjects[0].RemoveAll();
    	    			sheetObjects[1].RemoveAll();
    	    			ComShowMessage("[Inv No: "+errInvNo+"] "+ComGetMsg("MNR00015"));
    	    			return;
    				}
	 				row = sheetObjects[0].DataInsert(-1);
	 				inv_no = sheetObjects[1].GetCellValue(i,"inv_no").toUpperCase();
	 				sheetObjects[1].SetCellValue(i,"inv_no", inv_no, 0);
	 				sheetObjects[0].SetCellValue(row, "curr_cd",sheetObjects[1].GetCellValue(i,"curr_cd"));
	 				sheetObjects[0].SetCellValue(row, "vndr_seq",sheetObjects[1].GetCellValue(i,"vndr_seq"));
	 				sheetObjects[0].SetCellValue(row, "inv_amt",sheetObjects[1].GetCellValue(i,"inv_amt"));
	 				sheetObjects[0].SetCellValue(row, "vat_amt",sheetObjects[1].GetCellValue(i,"vat_amt"));
	 				sheetObjects[0].SetCellValue(row, "inv_whld_tax_amt",sheetObjects[1].GetCellValue(i,"inv_whld_tax_amt"));
	 				sheetObjects[0].SetCellValue(row, "inv_no",inv_no);
	 				sheetObjects[0].SetCellValue(row, "rcv_dt",sheetObjects[1].GetCellValue(i,"rcv_dt"));
	 				sheetObjects[0].SetCellValue(row, "inv_cfm_dt",sheetObjects[1].GetCellValue(i,"inv_cfm_dt"));
	 				sheetObjects[0].SetCellValue(row, "cost_ofc_cd",sheetObjects[1].GetCellValue(i,"cost_ofc_cd"));
	 				sheetObjects[0].SetCellValue(row, "vrfy_rslt_desc",sheetObjects[1].GetCellValue(i,"vrfy_rslt_desc"));
	 				sheetObjects[1].RowDelete(i,0);
	 			}
    			
    			if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq").toUpperCase() != "HEADER"){
	 				if(sheetObjects[1].GetCellValue(i, "jb_ordr_seq")!=""){
		 				if(!ComIsDate(sheetObjects[1].GetCellValue(i,"rpr_rslt_dt"))){
	    					var errEqNo = sheetObjects[1].GetCellValue(i,"eq_no");
	    					sheetObjects[0].RemoveAll();
	    	    			sheetObjects[1].RemoveAll();
	    	    			ComShowMessage("[EQ No: "+errEqNo+"] "+ComGetMsg("MNR00015"));
	    	    			return;
	    				}
	 				}
	 			}
    			
    			if(sheetObjects[1].GetCellValue(i, "jb_ordr_seq")!=""){
    				sheetObjects[1].SetCellValue(i, "inv_no", inv_no);
    				sheetObjects[1].SetCellValue(i, "cost_cd", sheetObjects[1].GetCellValue(i, "cost_cd_all"));
    			}

    			if(sheetObjects[1].GetCellValue(i,"inv_no").trim() == sheetObjects[0].GetCellValue(1,"inv_no").trim()){
    	    		if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq")!="HEADER"){
    	    			sheetObjects[1].SetRowHidden(i,0);
    	    		}
    	    	}else{
    	    		sheetObjects[1].SetRowHidden(i,1);
    	    	}
    		}
    		
    		var dupRow = sheetObjects[0].ColValueDup("inv_no", 1, 0)
    		if( dupRow != -1 ){
    			var dupInvNo = sheetObjects[0].GetCellValue(dupRow, "inv_no");
    			sheetObjects[0].RemoveAll();
    			sheetObjects[1].RemoveAll();
    			ComShowCodeMessage("MNR00006", "[Invoice No : " + dupInvNo + "]");
    			return;
    		}
    	sheetObjects[0].SetDataAutoTrim(1);
		sheetObjects[1].SetDataAutoTrim(1);	
    	sheetObjects[0].SelectCell(1,1);
    	ComBtnEnable('btn_verify');
    }
    
    function sheet2_OnLoadText(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
//    	if(result) {
		var inv_no = "";
    		for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
	 			
    			if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq").toUpperCase() == "HEADER"){
	 				
    				if(!ComIsDate(sheetObjects[1].GetCellValue(i,"inv_cfm_dt"))){
    					var errInvNo = sheetObjects[1].GetCellValue(i,"inv_no");
    					sheetObjects[0].RemoveAll();
    	    			sheetObjects[1].RemoveAll();
    	    			ComShowMessage("[Inv No: "+errInvNo+"] "+ComGetMsg("MNR00015"));
    	    			return;
    				}
	 				row = sheetObjects[0].DataInsert(-1);
	 				inv_no = sheetObjects[1].GetCellValue(i,"inv_no").toUpperCase();
	 				sheetObjects[1].SetCellValue(i,"inv_no", inv_no, 0);
	 				sheetObjects[0].SetCellValue(row, "curr_cd",sheetObjects[1].GetCellValue(i,"curr_cd"));
	 				sheetObjects[0].SetCellValue(row, "vndr_seq",sheetObjects[1].GetCellValue(i,"vndr_seq"));
	 				sheetObjects[0].SetCellValue(row, "inv_amt",sheetObjects[1].GetCellValue(i,"inv_amt"));
	 				sheetObjects[0].SetCellValue(row, "vat_amt",sheetObjects[1].GetCellValue(i,"vat_amt"));
	 				sheetObjects[0].SetCellValue(row, "inv_whld_tax_amt",sheetObjects[1].GetCellValue(i,"inv_whld_tax_amt"));
	 				sheetObjects[0].SetCellValue(row, "inv_no",inv_no);
	 				sheetObjects[0].SetCellValue(row, "rcv_dt",sheetObjects[1].GetCellValue(i,"rcv_dt"));
	 				sheetObjects[0].SetCellValue(row, "inv_cfm_dt",sheetObjects[1].GetCellValue(i,"inv_cfm_dt"));
	 				sheetObjects[0].SetCellValue(row, "cost_ofc_cd",sheetObjects[1].GetCellValue(i,"cost_ofc_cd"));
	 				sheetObjects[0].SetCellValue(row, "vrfy_rslt_desc",sheetObjects[1].GetCellValue(i,"vrfy_rslt_desc"));
	 				sheetObjects[1].RowDelete(i,0);
	 			}
    			
    			if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq").toUpperCase() != "HEADER"){
	 				if(sheetObjects[1].GetCellValue(i, "jb_ordr_seq")!=""){
		 				if(!ComIsDate(sheetObjects[1].GetCellValue(i,"rpr_rslt_dt"))){
	    					var errEqNo = sheetObjects[1].GetCellValue(i,"eq_no");
	    					sheetObjects[0].RemoveAll();
	    	    			sheetObjects[1].RemoveAll();
	    	    			ComShowMessage("[EQ No: "+errEqNo+"] "+ComGetMsg("MNR00015"));
	    	    			return;
	    				}
	 				}
	 			}
    			
    			if(sheetObjects[1].GetCellValue(i, "jb_ordr_seq")!=""){
    				sheetObjects[1].SetCellValue(i, "inv_no", inv_no);
    				sheetObjects[1].SetCellValue(i, "cost_cd", sheetObjects[1].GetCellValue(i, "cost_cd_all"));
    			}
	 			
	 			
	 			if(sheetObjects[1].GetCellValue(i,"inv_no").trim() == sheetObjects[0].GetCellValue(1,"inv_no").trim()){
    	    		if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq")!="HEADER"){
    	    			sheetObjects[1].SetRowHidden(i,0);
    	    		}
    	    	}else{
    	    		sheetObjects[1].SetRowHidden(i,1);
    	    	}
    		}
    		
    		var dupRow = sheetObjects[0].ColValueDup("inv_no", 1, 0)
    		if( dupRow != -1 ){
    			var dupInvNo = sheetObjects[0].GetCellValue(dupRow, "inv_no");
    			sheetObjects[0].RemoveAll();
    			sheetObjects[1].RemoveAll();
    			ComShowCodeMessage("MNR00006", "[Invoice No : " + dupInvNo + "]");
    			return;
    		}
    	
    		sheetObjects[0].SetDataAutoTrim(1);
    		sheetObjects[1].SetDataAutoTrim(1);	
    	sheetObjects[0].SelectCell(1,1);
    	ComBtnEnable('btn_verify');
    }

    function sheet1_OnClick(sheetObj, Row, Col, Value) {

    	var selectedStdNo = sheetObjects[0].GetCellValue(Row,"inv_no").trim();
       
//        for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
//    	   sheetObjects[1].SetRowHidden(i,1);
//        }
    	sheetObjects[1].RenderSheet(0);
        for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
	    	if(sheetObjects[1].GetCellValue(i,"inv_no").trim() == selectedStdNo){
	    		if(sheetObjects[1].GetCellValue(i,"jb_ordr_seq")!="HEADER"){
	    			sheetObjects[1].SetRowHidden(i,0);
	    			
	    		}
	    	}
	    	else{
	    		sheetObjects[1].SetRowHidden(i,1);
	    	}
	    }
        sheetObjects[1].RenderSheet(1);
    }
    
//    function sheet2_OnClick(sheetObj, Row, Col, Value) {
//    	if(sheetObj.ColSaveName(Col) == "vrfy_rslt_desc"){
//    		ComShowMemoPad(sheetObj, Row, Col, true, 300, 200);
//    	}
//    }
	
    
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;
		
		if (ErrMsg == "" || ErrMsg == undefined) {
			sheet1_OnClick(sheetObject1, 1, 3, "");
			if(okFlag != "Y"){
				ComShowCodeMessage("MNR00158");
			}
		} else {
//			ComShowCodeMessage("MNR00008",ErrMsg);
			
		}
	}
	
//	function solDateChk(datestr){
//		var val = ComTrimAll(datestr, "/");
//		if(val.length != 6){
//			return false;
//		}
//		
//		var sMonth = val.substring(0,2);
//		var sDay = val.substring(2,4);
//		
//		if(!ComIsMonth(sMonth) || !ComIsDay2(sDay)){
//			return false;
//		}
//		
//		return true;
//	}
	
//	function dateFormat(datestr){
//		var val = ComTrimAll(datestr, "/");
//		
//		var sMonth = val.substring(0,2);
//		var sDay = val.substring(2,4);
//		var sYear = "20"+val.substring(4,6);
//		
//		return sYear + sMonth + sDay;
//	}
	
	function dateFormat(datestr){
		var val = datestr.replace(/\/|\-|\./g,"");;
		return val;
	}
	
	function validateForm(sheetObj,formObj,sAction){
		if(sAction==IBSEARCH_ASYNC05) {
			
			for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
				if(sheetObjects[0].GetCellValue(i,"rcv_dt") == "" || !ComIsDate(sheetObjects[0].GetCellValue(i,"rcv_dt"))){
					var errInvNo = sheetObjects[0].GetCellValue(i,"inv_no");
	    			ComShowMessage("[Inv No: "+errInvNo+"] Received "+ComGetMsg("MNR00015"));
	    			return false;
				}
				
				var rcvDt=dateFormat(sheetObj.GetCellValue(i, "rcv_dt"));
				var issDt=dateFormat(sheetObj.GetCellValue(i, "inv_cfm_dt"));
				var toDay=ComGetNowInfo().replace(/-/g,"");
				if(issDt > toDay){
					ComShowMessage("[Inv No: "+sheetObj.GetCellValue(i, "inv_no")+"] "+ComGetMsg("MNR00233"));
					return false;
				}
				if(issDt > rcvDt){
					ComShowMessage("[Inv No: "+sheetObj.GetCellValue(i, "inv_no")+"] "+ComGetMsg("MNR00234"));
					return false;
				}
				if(rcvDt > toDay){
					ComShowMessage("[Inv No: "+sheetObj.GetCellValue(i, "inv_no")+"] "+ComGetMsg("MNR00235"));
					return false;
				}
			}
			
		}
		return true;
	}
	
	/**
     * Event handling of popup-click of sheet2
     * @param sheetObj
     * @return
     */
 	function sheet1_OnPopupClick(sheetObj, Row,Col){
 		if (sheetObj.ColSaveName(Col) != "rcv_dt") return;
 		var cal=new ComCalendarGrid();
 		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
 	}
	
 	/**
	 * checking BackEndJob until Status='3'.
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=MULTI02;
		var sXml=sheetObj.GetSearchData("EES_MNR_0248GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			ComShowCodeMessage("MNR00086");
			opener.setPopData_InvCrr(sheetObjects[0].GetCellValue(1, "inv_no"));
			ComClosePopup(); 
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("MNR00344");
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("MNR00345");
			ComOpenWait(false);
			clearInterval(timer1);
		}
	}
	
	/* 개발자 작업  끝 */