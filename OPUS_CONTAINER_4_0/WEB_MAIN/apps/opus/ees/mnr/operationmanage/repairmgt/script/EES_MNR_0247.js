/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0247.js
*@FileTitle : MNR EDI Invoice Parking Lot
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : Jun Kato
*@LastVersion : 1.0
* 2014.12.24Jun Kato
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
     * @class EES_MNR_0247 : business script for EES_MNR_0247.
     */
     
    function EES_MNR_0247() {
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
	            case "btn_Retrieve":
	            	// To check if the mandatory field is not empty.
	            	if (formObject.cre_fr_dt.value != '' && formObject.cre_to_dt.value != '' ){
	            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	            	
	            	
	            	//To get the first row in the first column and input to a hidden object in formObject
	            	formObject.cell_value.value=sheetObject1.GetCellValue(1,"mnr_rcv_ord_inv_tmp_seq");
	            	sheetObject1.SetCellValue(1, "Sel1", 1);
	            	if(sheetObject1.GetCellValue(1, "vrfy_rslt_desc") == "Etc Error"){
	                	ComBtnDisable('btn_Save');
	                	ComBtnDisable('btn_Confirm');
	                }else{
	                	ComBtnEnable('btn_Save');
	                	ComBtnEnable('btn_Confirm');
	                }
	            	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
	            	
	        		}else{
	        			ComShowCodeMessage('MNR00172',"Received Period");
	        		}
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Save":
	        		
	        		// To check if there are any records which are newly added or updated
	        		if ((sheetObject1.RowCount("D") > 0)||(sheetObject2.RowCount("") != sheetObject2.RowCount("R"))){
	        			doActionIBSheet(sheetObject1,formObject,IBSAVE);
	        		}else{
	        			ComShowCodeMessage("MNR00287", "Changed Data");
	        		}

	        		
	        		break;
	        						
				case "btn_rowdel":
					if(sheetObject1.FindCheckedRow("Sel") == ""){
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObject1, "Sel");						
					
						for(i=1;i<=sheetObject2.GetTotalRows();i++){
							sheetObject2.SetCellValue(i,0,"D");
							sheetObject2.SetRowHidden(i, 1);
						}

					}
					
					break;
					
				case "btn_Confirm":
					doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC05);
//					doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC05);
					break;
					
				case "btn_calendar": 
					var cal=new ComCalendarFromTo();       
						cal.select(form.cre_fr_dt,  form.cre_to_dt,  'yyyy-MM-dd'); 
					break;  
					
					//in case of multi input data 1
				case "eq_no_multi1":
					rep_Multiful_inquiry("rqst_eq_no");
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
                
               var HeadTitle="||Sel|Del|Currency|Vendor|Vendor Name|Invoice\nTotal|Invoice\nVAT|Withholding\nTAX|Invoice\nNumber|Received\nDate|Invoice\nDate|Office|Remarks|Errors";
               var headCount=ComCountHeadTitle(HeadTitle);
               (headCount + 2, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ 
                      {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mnr_rcv_ord_inv_tmp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Sel1",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Sel",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",  ColMerge:0,   SaveName:"vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"vat_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:0,   SaveName:"ord_hdr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:0,   SaveName:"vrfy_rslt_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      
                      ];
               
               
               InitColumns(cols);
               SetSheetHeight(200);
               SetCountPosition(4);   
               SetColProperty(0, "inv_no", {AcceptKeys:"E|[0123456789 -_/]" , InputCaseSensitive:1});
                     }
				break;
			case "sheet2":
			    with(sheetObj){
		       
		      var HeadTitle1="|InvSeq|Seq.|Equipment\nType|Equipment\nNumber|QTY|Currency|Cost\nAmount|Activity\nDate|Facility|Tariff\nItem|Vendor|Vendor Name|Remarks|Errors|JobOrder";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount+7, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];

		      InitHeaders(headers, info);

		      var cols = [ 
		             {Type:"Status",   Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",     Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mnr_rcv_ord_inv_tmp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },     
		             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mnr_rcv_ord_inv_tmp_dtl_seq" ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",    Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",           				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",     Hidden:0,  Width:150,   Align:"Left",    ColMerge:1,   SaveName:"eq_no",               				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Right",    ColMerge:1,   SaveName:"rpr_qty",         					  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_amt",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rpr_rslt_dt",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",   ColMerge:1,   SaveName:"yd_cd",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",    ColMerge:1,   SaveName:"cost_cd_all",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",   ColMerge:1,   SaveName:"vndr_seq",             				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:200,   Align:"Left",   ColMerge:1,   SaveName:"vndr_nm",             				  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",   ColMerge:1,   SaveName:"ord_dtl_rmk",            			  KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:300,  Align:"Left",   ColMerge:1,   SaveName:"vrfy_rslt_desc",            			  KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"rqst_ref_no",            			  KeyField:0,   CalcLogic:"",   Format:"",       	  PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:1,  Width:70,   Align:"Center",    ColMerge:1,   SaveName:"cost_cd",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		             ];
		      

		      InitColumns(cols);
		      SetCountPosition(4);
		      SetSheetHeight(300);
		      SetColProperty(0,"eq_knd_cd", {ComboText:"CONTAINER|CHASSIS|GENSET", ComboCode:"U|Z|G"} );
		            }


				break;
				
			case "sheet3":
                with (sheetObj) {
                    SetVisible(false);
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
        case IBSEARCH:      //조회
			if (sheetObj==sheetObjects[0]){
				formObj.f_cmd.value = SEARCH;
			}else{
				formObj.f_cmd.value = SEARCH01;
			}
			var sXml = sheetObj.GetSearchData("EES_MNR_0247GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml, {Sync:1});
			break;
			case IBCLEAR:      // Initializing
				formObj.cre_fr_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
				formObj.cre_to_dt.value=ComGetNowInfo("ymd");
				formObj.inv_no.value='';
				formObj.rqst_eq_no.value='';
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
		        ComBtnEnable('btn_Save');
		        ComBtnEnable('btn_Confirm');
				break;
				
			case IBSAVE:        //저장
				//저장처리
//				if (sheetObj==sheetObjects[0]){
//					formObj.f_cmd.value = MULTI;
//				}else{
//					formObj.f_cmd.value = MULTI01;
//				}
				formObj.f_cmd.value = MULTI;
				var sParam1 = sheetObjects[0].GetSaveString(0, 1, "ibflag", "HDR_");
				var sParam2 = sheetObjects[1].GetSaveString(0, 1, "ibflag", "DTL_");
				
				var sParam = sParam1 +"&"+ sParam2;
//				sheetObj.DoSave("EES_MNR_0247GS.do", FormQueryString(formObj) +"&"+ sParam );
				var sXml=sheetObj.GetSaveData("EES_MNR_0247GS.do", FormQueryString(formObj) +"&"+ sParam);
				
				var backendJobCnt = ComGetEtcData(sXml, "result");
		    	if(backendJobCnt == "X"){
		    		ComShowCodeMessage("MNR00390");
		    		return false;
		    	}else{
		    		sheetObj.LoadSaveData(sXml);
		    	}
				break;
				
			case IBSEARCH_ASYNC05:
//				if (sheetObj==sheetObjects[0]){
//					formObj.f_cmd.value = MULTI02;
//				}else{
//					formObj.f_cmd.value = MULTI03;
//				}
				formObj.f_cmd.value = MULTI01;
				var check = false;
				for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
		 			if(sheetObjects[0].GetCellValue(i, "Sel1") == 1){
		 				check = true;
		 			}
		 		}
				
				if(!check){
					ComShowCodeMessage("MNR00036", "at least one");
					return;
				}
				
				if(sheetObjects[1].RowCount("") != sheetObjects[1].RowCount("R")){
					if(!ComShowCodeConfirm("MNR00372")){
						return;
					}
				}else{
					if(!ComShowCodeConfirm("MNR00197")){
						return;
					}
				}
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				var sParam1 = sheetObjects[0].GetSaveString(0, 1, "Sel1", "HDR_");
				var sParam2 = sheetObjects[1].GetSaveString(0, 1, "ibflag", "DTL_");
				
				var sParam = sParam1 +"&"+ sParam2;
		    	var sXml=sheetObj.GetSaveData("EES_MNR_0247GS.do", FormQueryString(formObj) +"&"+ sParam);
//				sXml_1 = sXml;
//		    	sheetObj.LoadSaveData(sXml);
		    	var backendJobCnt = ComGetEtcData(sXml, "result");
		    	if(backendJobCnt == "X"){
		    		ComShowCodeMessage("MNR00390");
		    		ComOpenWait(false);
					sheetObj.SetWaitImageVisible(1);
		    		return false;
		    	}else{
		    		var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.SetWaitTimeOut(10000);
						timer1=setInterval(getBackEndJobStatus, 3000);
					}
		    	}

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
    

    function sheet1_OnClick(sheetObj, Row, Col, Value) {

    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
        var formObject = document.form;
        var selectedStdNo = sheetObject1.GetCellValue(Row,"mnr_rcv_ord_inv_tmp_seq")
        
        //If user clicks same row twice, detail information will not be searched.(user can edit in main information)
        if(formObject.cell_value.value != selectedStdNo){
        	if (sheetObject2.RowCount("") == sheetObject2.RowCount("R")){
        		//to get mnr_rcv_ord_inv_tmp_seq
        		formObject.cell_value.value=selectedStdNo;
        		sheetObj.SetCellValue(Row, "Sel1", 1);
            	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
        	}else{
        		if(ComShowCodeConfirm("MNR00232")){
        			formObject.cell_value.value=selectedStdNo;
        			sheetObj.SetCellValue(Row, "Sel1", 1);
                	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
				}
        	}
        	
        }
        
        if(sheetObject1.GetCellValue(Row, "vrfy_rslt_desc") == "Etc Error"){
        	ComBtnDisable('btn_Save');
        	ComBtnDisable('btn_Confirm');
        }else{
        	ComBtnEnable('btn_Save');
        	ComBtnEnable('btn_Confirm');
        }
    }
	
    /**
	 * Processing the returned data of rep_Multiful_inquiry
	 * @param	{Array}		rowArray	Retruned array
	 * @param	{String}	return_val	Retruned form element name
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;
 		var tempText="";
 		//Initializing
		eval("document.form." + return_val + ".value='';");
 		for(var i=0; i < rowArray.length; i++) {
 			tempText +=  rowArray[i] + ',';
 		}
 		//Removing last comma
		tempText=MnrDelLastDelim(tempText);
 		eval("document.form." + return_val + ".value='" + tempText + "';");
 	}
    
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;
		
		if (ErrMsg == "" || ErrMsg == undefined) {
			ComShowCodeMessage("MNR00023");
			
	        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
        	formObject.cell_value.value=sheetObject1.GetCellValue(1,"mnr_rcv_ord_inv_tmp_seq");
        	sheetObject1.SetCellValue(1, "Sel1", 1);
        	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
        	
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
			
		}
	}
	
	function sheet3_OnSaveEnd(sheetObj,ErrMsg){
		var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var formObject = document.form;
		
		if (ErrMsg == "" || ErrMsg == undefined) {
			if(ComGetTotalRows(sXml_1) != 0){
				ComShowCodeMessage("MNR00373");
				var selectedRow = sheetObject1.GetSelectRow();
		        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
//	        	formObject.cell_value.value=sheetObject1.GetCellValue(1,"mnr_rcv_ord_inv_tmp_seq");
	        	sheetObject1.SetCellValue(selectedRow, "Sel1", 1);
	        	sheetObject1.SetSelectRow(selectedRow);
	        	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
	        	
			}else{
				ComShowCodeMessage("MNR00086");
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	        	formObject.cell_value.value=sheetObject1.GetCellValue(1,"mnr_rcv_ord_inv_tmp_seq");
	        	sheetObject1.SetCellValue(1, "Sel1", 1);
	        	doActionIBSheet(sheetObject2,formObject,IBSEARCH);
			}
			
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
			
		}
	}
	
	/**
	 * checking BackEndJob until Status='3'.
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        
		formObj.f_cmd.value=MULTI02;
		var sXml=sheetObj.GetSearchData("EES_MNR_0248GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			formObj.f_cmd.value = SEARCH02;
			var sParam1 = sheetObj.GetSaveString(0, 1, "Sel1", "HDR_");
			var sXml = sheetObj.GetSearchData("EES_MNR_0247GS.do", FormQueryString(formObj)+sParam1);
			
			if(ComGetTotalRows(sXml) != 0){
				ComShowCodeMessage("MNR00373");
				var selectedRow = sheetObj.GetSelectRow();
		        doActionIBSheet(sheetObj,formObj,IBSEARCH);
//	        	formObject.cell_value.value=sheetObject1.GetCellValue(1,"mnr_rcv_ord_inv_tmp_seq");
	        	sheetObj.SetCellValue(selectedRow, "Sel1", 1);
	        	sheetObj.SetSelectRow(selectedRow);
	        	doActionIBSheet(sheetObj1,formObj,IBSEARCH);
	        	
			}else{
				ComShowCodeMessage("MNR00086");
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
	        	formObj.cell_value.value=sheetObj.GetCellValue(1,"mnr_rcv_ord_inv_tmp_seq");
	        	sheetObj.SetCellValue(1, "Sel1", 1);
	        	doActionIBSheet(sheetObj1,formObj,IBSEARCH);
			}
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