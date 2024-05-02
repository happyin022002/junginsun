	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName   : EES_CGM_1089.js
	*@FileTitle  : General Inventory (General Inventory Graphic)
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/06/11
	=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	   	/* developer job	*/
	    // common global variables
	    var tabObjects=new Array();
	    var tabCnt=0 ;
	    var beforetab=1;
	    var sheetObjects=new Array();
	    var sheetCnt=0;
	    var rdObjects=new Array();
	    var rdCnt=0;
	    var comboObjects=new Array();
	    var comboCnt=0;
	    var IBSEARCH02=30;
	    var searchFlg = "";
	    var oldCntrTypeSize = "";
	    var sCntrTypeSize = "";
	    
	    // Event handler processing by button click event */
	    document.onclick=processButtonClick;
	    /**
	     * Event handler processing by button name <br>
	     * @param
	     * @return 
	     * @author 
	     * @version
	     */ 
	    function processButtonClick(){
	    	/***** use additional sheet var in case of more than 2 tap each sheet *****/
	        var sheetObject1=sheetObjects[0];
	        var sheetObject2=sheetObjects[1];
	        /*******************************************************/
	        var formObject=document.form;
	         var rdObject=rdObjects[0];
	        try {
	        	var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
	            switch(srcName) {
	            	case "btn_retrieve":
	            		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
	            			document.getElementById('chartLayer').style.display="";
	            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	            			rdOpen(); 
	            		}
	////            		formObject.crnt_loc_cd.focus(); 
	                    break;
	                case "btn_new":
	                	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	                	initControl();
	                    break;
	                case "btn_downexcel":
	                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
	                    break;
	                case "btn_print":
		               	 if(formObject.doc_type[0].checked){
	       					if( sheetObjects[0].rowcount==0 ) {
	     						errMsg='No data found.';
	     						ComShowMessage(msgs["CGM10012"]);
	     						return;
	     					}
	     					formObject.f_cmd.value=IBSEARCH02;
	     					formObject.head_eq_tpsz_cd.value = sCntrTypeSize;
	     					ComOpenPopupWithTarget('/opuscntr/EES_CGM_1090.do', 775, 700, "", "0,1,1,1,1,1,1", true);
	                	 }
	                	 else if (formObject.doc_type[1].checked)
	                	 {
	                		//rdObject.autoadjust=true;
	                		//rdObject.ZoomRatio=100;
	                		//rdObject.HideToolBar();
	                		//rdObject.HideStatusBar();
	                		//rdObject.ViewShowMode(0);
	                		//rdObject.SetBackgroundColor(255,255,255);
	                		//rdObject.SetPageLineColor(255,255,255);
	                		 viewer.print({isServerSide:true});
	                	 }
	                    break;
	                case "btns_crnt_loc_cd":	// Location Popup
		                var tmp=formObject.combo_location.value;
		            	if(tmp == "RCC"){
		            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
		            	} else if(tmp == "LCC") {
		            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
		            	} else if(tmp == "SCC") {
		            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
		            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
		            	}
	                	break;
	                case "btns_crnt_yd_cd":		// Yard
	                	//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
	                	ComOpenPopup('/opuscntr/COM_ENS_061.do', 800, 545, "callBackYard", "0,1,1,1,1,1,1", true, false);
	                	break;
	                case "btns_vndr":
	                	ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 545, "callBackVendor", "0,1,1,1,1,1", true, false);
	                	break;
	            } // end switch
	        }catch(e) {
	        	if( e == "[object Error]") {
	         		ComShowMessage(OBJECT_ERROR);
	         	} else {
	         		ComShowMessage(e.message);
	         	}
	        }
	    }
	    /**
	     * registering IBSheet Object as list <br>
	     * @param  {object} sheet_obj	
	     * @return 
	     * @author 
	     * @version
	     */
	    function setSheetObject(sheet_obj){
	    	sheetObjects[sheetCnt++]=sheet_obj;
	    }
	    /**
	     * initializing sheet <br>
	     * implementing onLoad event handler in body tag <br>
	     * @param  
	     * @return 
	     * @author 
	     * @version
	     */
	    function loadPage() {
	    	var formObj=document.form;
	    	
	    	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);

	    	for(i=0;i<sheetObjects.length;i++){
	    		//
	            ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i],i+1);
	            //
	            ComEndConfigSheet(sheetObjects[i]);
	        }
	    	sheet1_OnLoadFinish(sheet1);
	    }
	     /**
	      * sheet setting and init in case of load finish <br>
	      * @param  
	      * @return 
	      * @author 
	      * @version
	      */     
	    function sheet1_OnLoadFinish(sheetObj) {
	        sheetObj.SetWaitImageVisible(0);
	     	// axon event regist
	////        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	   //     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	   //     axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
	     	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
	     	axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
	     	axon_event.addListener('click', 'doc_type_change', 'doc_type');
	////     	axon_event.addListener('keyup', 'enterFire', 'crnt_loc_cd');
	////     	axon_event.addListener('keyup', 'enterFire', 'crnt_yd_cd');
	     	axon_event.addListenerForm('keyup', 'obj_keyup', form);         
	     	// Multi Combo reset 
	     	comboObjects[comboCnt++]=combo_location; 
	     	comboObjects[comboCnt++]=aciac_div_cd;
	     	comboObjects[comboCnt++]=chss_pool_cd;
	     	comboObjects[comboCnt++]=group1;
	     	comboObjects[comboCnt++]=group2;
	     	comboObjects[comboCnt++]=group3;    	
	     	comboObjects[comboCnt++]=eq_tpsz_cd;
	     	comboObjects[comboCnt++]=agmt_lstm_cd;
	     	comboObjects[comboCnt++]=chss_mvmt_sts_cd;
	       	for(var k=0;k<comboObjects.length;k++){
	   	        initCombo(comboObjects[k]);
	  	    }  
	       	// Active St. MultiCombo value reset
	       	var arrActive=new Array();
	       	arrActive[0]="A|Active";
	       	arrActive[1]="I|In-active";
	       	makeComboObject(aciac_div_cd, arrActive, 1, 0, 0);
	       	//Group MultiCombo value reset
	       	var arrGroup=new Array();
	       	arrGroup[0]="1|LCC[Location]";
	       	arrGroup[1]="2|Office";
	       	arrGroup[2]="3|SCC[Location]";
	       	arrGroup[3]="4|Yard";
	       	arrGroup[4]="5|Lease term";
	       	arrGroup[5]="6|Lessor";
	       	arrGroup[6]="7|Mvmt Status";
	       	makeComboObject(group1, arrGroup, 1, 0, 1);
	       	/*
	       	// Location MultiCombo value setting
	     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	     	// CP MultiCombo value setting
	     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	     	// Type Size MultiCombo value setting
	     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	     	// Lease Term MultiCombo value setting
	     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
	     	// Movement Status MultiCombo value setting
	     	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
	     	*/
	       	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	     	initControl();
	        sheetObj.SetWaitImageVisible(1);
/*	        if(chss_pool_cd.GetSelectText()!= ''){
	        	sheetObj.ShowSubSum([{StdCol:"group1", SumCols:"4|5|6|7|8|9|10|11|12|13|14", Sort:1, ShowCumulate:0, CaptionCol:"group1", CaptionText:"Sub Total"}]);
            }
*/	     }
	    /**
	     * printpage open
	     * printpage open
	     * print page open
	     */
		function rdOpen(){		
			var sXml="";		
			var i=0;
			var j=0;
	        var sheetObject=sheetObjects[0];
	        //RDOBJECTreset
//	        rdObjects[0].AutoAdjust=2; 
//	        rdObjects[0].ApplyLicense("0.0.0.0");
	        //rdObjects[0].ZoomRatio = 90;
	        //rdObjects[0].HideStatusBar();
	        //rdObjects[0].HideToolBar();
	        
//	        rdObjects[0].ViewShowMode(1);
//	        rdObjects[0].SetBackgroundColor(255,255,255);
//	        rdObjects[0].SetPageLineColor(255,255,255);
	        
//	        rdObjects[0].ViewShowMode(0);
//	        rdObjects[0].SetBackgroundColor(128,128,128);
//	        rdObjects[0].SetPageLineColor(128,128,128);
	        
	        //fromObj = document.form
	        //rdObj = sheetObject
			sXml="<?xml version='1.0' encoding='UTF-8'?>";
			sXml += "<ETC>";
			sXml += "<SHEET1>";
			sXml += "<DATA>";
			sXml += "<TR>";
			sXml += "<TD>01</TD>";
			sXml += "<TD>50</TD>";
			sXml += "<TD>20</TD>";
			sXml += "</TR>";
	     	sXml += "</DATA>";
			sXml += "</SHEET1>";
			sXml += "<SHEET2>";
			sXml += "<DATA>";
			sXml += "<TR>";
			sXml += "<TD>01</TD>";
			sXml += "<TD>50</TD>";
			sXml += "<TD>20</TD>";
			sXml += "</TR>";
			sXml += "</DATA>";
			sXml += "</SHEET2>";
			sXml += "<SHEET3>";
			sXml += "<DATA>";
			if(sheetObject.RowCount()== 0)
			{
				sXml += "<TR>";
				sXml += "<TD></TD>";
				sXml += "<TD></TD>";
				sXml += "</TR>";
			}
			else
			{
				for(var i=1; i <= sheetObject.RowCount(); i++){
					if(sheetObject.GetCellValue(i,"group1") == "Sub Total")
					{
					}else if(sheetObject.GetCellValue(i,"group1") == "")
					{
					}else{
						sXml += "<TR>";
						var xAx="<TD>["+sheetObject.GetCellValue(i, "group1")
						+"|"+sheetObject.GetCellValue(i, "group2")
						+"|"+sheetObject.GetCellValue(i, "group3")
							 +"]</TD>";
						sXml += xAx;
						sXml += "<TD>"+sheetObject.GetCellValue(i, "total")+"</TD>";
						sXml += "</TR>";
					}
				}
			}
			sXml += "</DATA>";
			sXml += "</SHEET3>";
			sXml += "<SHEET4>";
			sXml += "<DATA>";
			sXml += "<TR>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "<TD></TD>";
			sXml += "</TR>";
			sXml += "</DATA>";
			sXml += "</SHEET4>";
			sXml += "</ETC>";
			viewer.setRData(sXml);
			viewer.openFile(RD_path+'apps/opus/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_1122.mrd',RDServer, {timeout:1800});
			//rdObjects[0].FileOpen('http://localhost:9001/opuscntr/apps/opus/ees/cgm/chassismgsetmgt/chassismgsetinventory/report/EES_CGM_1122.mrd',RDServer);
			
//			var formObj=document.form;
//	    	document.getElementById('chartLayer').style.display="none";
//	    	document.getElementById('sheetLayer').style.display="none";
//	    	if(formObj.doc_type[0].checked==true)
//	    	{
//	    		document.getElementById('sheetLayer').style.display="";
//	    	}else {
//	    		document.getElementById('chartLayer').style.display="";
//	    	}
		}
	    /**
	     * init control of form <br>
	     * @param  
	     * @return 
	     * @author 
	     * @version
	     */
	    function initControl(){
	    	 var formObj=document.form;
	    	 var sheetObj=sheetObjects[0];
	    	 // Form Object reset
	    	 with(formObj){
	    		 crnt_loc_cd.value="";
	    		 crnt_yd_cd.value="";
	    		 staying_days.value="";
	    		 vndr_seq.value="";
	    		 include_np.checked=false;
	    	 }
	    	 // MultiCombo reset
	    	 for(var i=0; i<comboObjects.length; i++){
	    		 comboObjects[i].SetSelectText("",false);
	    	 }
	    	 // Sheet Object reset
	    	 sheetObj.RemoveAll();
	    	 sheetObj.SetColHidden("group1",1);
	    	 sheetObj.SetColHidden("group2",1);
	    	 sheetObj.SetColHidden("group3",1);
	    	 // setting
	    	 comboObjects[0].SetSelectIndex(0);
	    	 comboObjects[1].SetSelectIndex(0);
	    	 comboObjects[2].SetSelectIndex(0);
	    	 formObj.staying_days.value="0";
	    	 comboObjects[3].SetSelectIndex(1);
	    	 comboObjects[4].SetSelectIndex(2);
	    	 comboObjects[5].SetSelectIndex(2);
	    	 //rd object reset
	    	 rdOpen();
//	    	 
//	    	 document.getElementById('chartLayer').style.display="none";
	    }
	     /**
	      * setting sheet initial values and header <br>
	      * adding case as numbers of counting sheets <br>
	      * @param  {object} sheetObj		 Sheet Object
	      * @param  {int} sheetNo
	      * @return 
	      * @author 
	      * @version
	      */
	    function initSheet(sheetObj,sheetNo) {
	    	var cnt=0;
	    	var sheetID=sheetObj.id;
	        switch(sheetID) {
	        	case "sheet1":
	        	    with(sheetObj){
			              var HeadTitle="Seq.||||Total";
			              
							//making data as list for changing column
							oldCntrTypeSize = sCntrTypeSize;
							var arrCntrTypeSize = "";
							if(oldCntrTypeSize != ""){
								arrCntrTypeSize = oldCntrTypeSize.split("|");
							}
							
							//handling header title by changing column
							if (sCntrTypeSize != "") {
								HeadTitle += "|" + oldCntrTypeSize;
							}
			              
			              
			              var headCount=ComCountHeadTitle(HeadTitle);
			            //  var totalVal="|5|+|6|+|7|+|8|+|9|+|10|+|11|+|12|+|13|+|14|";
			              
		                    var totalVal = "";
		                    var z = 1;
		                    var sumCount = 5;
		                    var sumNmVal = "";
							for ( var i = 0; i < arrCntrTypeSize.length; i++) {
								if (arrCntrTypeSize.length > 1) {
									if(i == arrCntrTypeSize.length - 1){
										totalVal += "|eq_tpsz_cd" + z+"|";
										sumNmVal += "|"+sumCount;
									}else if(i == 0){
										totalVal += "|eq_tpsz_cd" + z+"|+";
										sumNmVal += sumCount;
									}else{
										totalVal += "|eq_tpsz_cd" + z+"|+";
										sumNmVal += "|"+sumCount;
										
									}
									z++;
									sumCount++;
								}
							}

			
			              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );
			
			              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			
			              var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"group1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"group2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"group3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"total",           KeyField:0,   CalcLogic:totalVal,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];

	 	 	              
						  var sCount = "";
						  var x = 1;
		                  var sumCount = 4;
	                      var sumNmVal = "";
						  
	 	 	              for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
						 	  if (arrCntrTypeSize.length > 1) {
						 		  sCount = "eq_tpsz_cd" + x;
						 		  if(i != arrCntrTypeSize.length){
					 			  	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						 		  
					 			  	x++;
						 	  	  }
						 	  
						 		  if(i == arrCntrTypeSize.length - 1){
								  	sumNmVal += "|"+sumCount;
								  }else if(i == 0){
								  	sumNmVal += sumCount;
								  }else{
								    sumNmVal += "|"+sumCount;
								  }
								  sumCount++;

						 	  }
						  }
	 	 	              cols.push({Type:"Text",   Hidden:1, Width:1,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	
			              InitColumns(cols);
			              sheetObj.ShowSubSum([{StdCol:"group1", SumCols:sumNmVal, Sort:1, ShowCumulate:0, CaptionCol:"group1", CaptionText:"Sub Total"}]);
			              SetEditable(1);
			              SetEditableColorDiff(0);
			              resizeSheet();
	                	}
	                break;
	        }
	    }
	    
	    function resizeSheet(){
	    	ComResizeSheet( sheetObjects[0] );
	    }
	    /**
	     * handling process for Sheet <br>
	     * @param  {object} sheetObj		 Sheet Object
	     * @param  {object} formObj	 Form Object
	     * @param  {String} sAction	 Action Type
	     * @return 
	     * @author 
	     * @version
	     */
	    function doActionIBSheet(sheetObj,formObj,sAction) {
	    	sheetObj.ShowDebugMsg(false);
	        switch(sAction) {
		        case IBSEARCH:      //retrieve
			        // Form Object value setting
			    	formObj.f_cmd.value=SEARCH;
			 		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
			 		if(formObj.include_np.checked){
			 			formObj.include_np.value="Y";
			 		} else {
			 			formObj.include_np.value="";
			 		}
			 		
			 		if(!ComIsEmpty(combo_location.GetSelectText())) {
			 			formObj.location.value = combo_location.GetSelectText();
			 		}
			 		
			 		sheetObj.SetWaitImageVisible(0);
//			 		ComOpenWait(true);
			 		// retrieve
			 		var sXml=sheetObj.GetSearchData("EES_CGM_1089GS.do" , FormQueryString(formObj));
			 		sheetObj.LoadSearchData(sXml,{Sync:1} );
//			 		ComOpenWait(false);
			        break;
	        	case IBSEARCH_ASYNC01:	// Location Combo retrieve
			       	formObj.f_cmd.value=SEARCH;
			       	formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting (Location)
			       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			   		var sStr=ComGetEtcData(sXml,"comboList");    			
			   		var arrStr=sStr.split("@");
			   		// combo control, result string, Text Index, Code Index
			  		makeComboObject(combo_location, arrStr, 1, 1, 0);
			       	break;
	        	case IBSEARCH_ASYNC02:	// Yard  Validation check 
				   	formObj.f_cmd.value=COMMAND01;
				   	formObj.yd_cd.value=formObj.crnt_yd_cd.value;
				   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
				   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
				   	if(sCheckResult == COM_VALIDATION_FALSE){
				   		ComShowCodeMessage('CGM10009','Yard');
				   		formObj.crnt_yd_cd.value="";
	////			   		formObj.crnt_yd_cd.focus();
				   	}
				   	break;
	        	case IBSEARCH_ASYNC03:	// CP Combo retrieve
	        		formObj.f_cmd.value=SEARCH02;
	        		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	        		ss=ComCgmXml2ComboString(sXml, "TOTAL");
	        		var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
	        		//IBSHEET GRID outer combo
	        		makeCPMultiCombo(chss_pool_cd, cols, 0, 0);
	         	  	break;   
	        	case IBSEARCH_ASYNC04:	// Type Size Combo retrieve
	        		formObj.f_cmd.value=SEARCH04;
	        		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
	        		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
					var sStr=ComGetEtcData(sXml,"comboList");
					var arrStr=sStr.split("@");
			  		makeComboObject(eq_tpsz_cd, arrStr, 0, 0, 0);
			  		//comboObjects[6].DeleteItem(1);
			       	break;  
	        	case IBSEARCH_ASYNC05:	// Term Code Combo retrieve
			       	formObj.f_cmd.value=SEARCH;
			       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
			       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			   		var sStr=ComGetEtcData(sXml,"comboList");    			
			   		var arrStr=sStr.split("@");
			  		makeComboObject(agmt_lstm_cd, arrStr, 0, 0, 0);
			  		comboObjects[7].DeleteItem(0);
			       	break;
	        	case IBSEARCH_ASYNC06:	// Movement Status Combo retrieve
		        	formObj.f_cmd.value=SEARCH13;
		        	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
					var cols=ComCgmXml2ComboString(sXml, "code1", "code1");
		     	  	ComCgmMakeMultiCombo(form.chss_mvmt_sts_cd, cols[0], cols[1], 0);
		     	  	break;
	        	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
		        	formObj.f_cmd.value = SEARCH21;
	        		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
					var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
					sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
					
					//getting changing column information from server
					oldCntrTypeSize = sCntrTypeSize;
					
					break;
		  	    case IBSEARCH_ASYNC08:
			       	//formObj.f_cmd.value = SEARCH;
			       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
			   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
			    	formObj.f_cmd.value=SEARCH17;
			    	var location=formObj.combo_location.value;
			    	if(location == "RCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value="RCC";
			    		formObj.eq_orz_cht_rcc_cd.value=formObj.crnt_loc_cd.value;
			    	}else if(location == "LCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value="LCC";
			    		formObj.eq_orz_cht_lcc_cd.value=formObj.crnt_loc_cd.value;
			    	}else if(location == "SCC")
			    	{
			    		formObj.eq_orz_cht_chktype.value="SCC";
			    		formObj.eq_orz_cht_scc_cd.value=formObj.crnt_loc_cd.value;
			    	}else
			    	{
			    		formObj.eq_orz_cht_chktype.value="";
			    		formObj.eq_orz_cht_scc_cd.value="";
			    	}
			    	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			   		// data count
			        var dataCount=ComGetTotalRows(sXml);
			        if(dataCount==0){
			        	ComShowCodeMessage('CGM10009','location cd');
				   		formObj.crnt_loc_cd.value="";
			        }
			        formObj.crnt_loc_cd.focus(); 
			  	    break;		     	  	
	        	case IBDOWNEXCEL:        //down excel
	        		if(sheetObj.RowCount() < 1){//no data
	        			ComShowCodeMessage("COM132501");
	        		}else{
	        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	        		}
					break;
	        	case IBRESET:
	        		var idx=0
	        		var sXml2=document.form2.sXml.value;
	        		var arrXml=sXml2.split("|$$|");
	        		//Location
	        		if ( arrXml[idx] == null ) {return;}
	        		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	        	    var arrStr1=new Array();
	        		for ( var i=0; i < vArrayListData.length; i++) {
	        		    vListData=vArrayListData[i];
	        		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
	        		}
	        		// combo control, result string, Text Index, Code Index
			  		makeComboObject(combo_location, arrStr1, 1, 1, 0);       
	        		idx++;        		
			  		//Co-Op Pool
	        		if ( arrXml[idx] == null ) {return;}
	        		var cols1=ComCgmXml2ComboString(arrXml[idx], "code1", "desc1");
	        		//IBSHEET GRID outer combo
	        		makeCPMultiCombo(chss_pool_cd, cols1, 0, 0);
	        		idx++;
	        		//Type/Size
	        		if ( arrXml[idx] == null ) {return;}
	        		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	        	    var arrStr2=new Array();
	        		for ( var i=0; i < vArrayListData.length; i++) {
	        		    vListData=vArrayListData[i];
	        		    arrStr2[i]=vListData["code1"] + "|" + vListData["desc1"];
	        		}
	        		makeComboObject(eq_tpsz_cd, arrStr2, 0, 0, 0);
			  		idx++;
	        		//Lease Term
	        		if ( arrXml[idx] == null ) {return;}
	        		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	        	    var arrStr3=new Array();
	        		for ( var i=0; i < vArrayListData.length; i++) {
	        		    vListData=vArrayListData[i];
	        		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
	        		}
			  		makeComboObject(agmt_lstm_cd, arrStr3, 0, 0, 0);
			  		comboObjects[7].DeleteItem(comboObjects[7].FindItem("NP", 0, 1));
			  		idx++;
			  		//MVMT Status
	        		if ( arrXml[idx] == null ) {return;}
					var cols2=ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
		     	  	ComCgmMakeMultiCombo(chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
		     	  	idx++;
	        		break;
	        }
	    }
	    /**
	     * handling process for input validation <br>
	     * @param  {object} sheetObj		 Sheet Object
	     * @param  {object} formObj	 Form Object
	     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
	     * @return {boolean}			false => validation check error, true => validation check succes
	     * @author 
	     * @version
	     */ 
	    function validateForm(sheetObj,formObj,sAction){
	    	with(formObj){
	    		switch(sAction){
	    			case IBSEARCH:
	    				if(crnt_loc_cd.value == ''){
	    					ComShowCodeMessage('CGM10004','Location');
	////    					crnt_loc_cd.focus();
	    					return false;
	    				} else {
	    					if(crnt_loc_cd.value.length != 5) 
	    					{
	    						ComShowCodeMessage('CGM10044','Location(5)');
	////    						crnt_loc_cd.focus();
	    						return false;
	    					}else
	    					{
	    						return true;
	    					}
	    				}
	    				break;
	    		}
	    	}
	    }
	    function callBackLocation(aryPopupData, row, col, sheetIdx){
	        var formObj=document.form;
	        var location=combo_location.GetSelectText();
	        var crntLocCd="";
	        var i=0;
	        for(i=0; i < aryPopupData.length; i++){
	        	if(location == 'RCC'){
	        		crntLocCd=crntLocCd + aryPopupData[i][11];
	        	} else if(location == 'LCC'){
	        		crntLocCd=crntLocCd + aryPopupData[i][10];
	        	} else if(location == 'SCC'){
	        		crntLocCd=crntLocCd + aryPopupData[i][8];
	        	}
	        	if(i < aryPopupData.length - 1){
	        		crntLocCd=crntLocCd + ",";
	         	}
	        }
	        formObj.crnt_loc_cd.value=crntLocCd;
	    }	 
	    function callBackYard(aryPopupData, row, col, sheetIdx){
	        var formObj=document.form;
	        var crntYdCd="";
	        var i=0;
	        for(i=0; i < aryPopupData.length; i++){
	        	crntYdCd=crntYdCd + aryPopupData[i][3];
	        	if(i < aryPopupData.length - 1){
	        		crntYdCd=crntYdCd + ",";
	         	}
	        }
	        formObj.crnt_yd_cd.value=crntYdCd;
	        //chungpa 20091015 check yard
	        checkGroup2Yard();
	    }
	    function callBackVendor(aryPopupData, row, col, sheetIdx){
	       	var formObj=document.form;
	        var vndrSeq="";
	        var i=0;
	        for(i=0; i < aryPopupData.length; i++){
	        	vndrSeq=vndrSeq + aryPopupData[i][2];
	        	if(i < aryPopupData.length - 1){
	        		vndrSeq=vndrSeq + ",";
	        	}
	        }
	        formObj.vndr_seq.value=vndrSeq;
	    }	
	     function sheet1_OnChangeSum(sheetObj, Row)
	     {
	     }
	    /**
	     * Sheet1  OnSearchEnd event handling <br>
	     * @param  {object} sheetObj		 Sheet Object
	     * @param  {string} ErrMsg		 String
	     * @return 
	     * @version
	     */ 
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	    {
	    	with(sheetObj)
	    	{
	    		SetSumText(0, "Seq","");
	     		SetSumText(0, "group1","Grand Total");
	     		SetCellAlign(0, "group1","Center");
	    	}
	    }
	  /**
	   * Sheet1 OnMouseDown event handling <br>
	   * @param  {Integer} Button	 Integer
	   * @param  {integer} Shift	 Integer
	   * @param  {Integer} X	 Integer
	   * @param  {integer} Y	 Integer
	   * @return 
	   * @author 
	   * @version 2009.09.23
	   */ 
/*	   function sheet1_OnMouseDown (Button, Shift, X, Y){
	  	 var sheetObj=sheetObjects[0];
	  	 var formObj=document.form;
	  	 if(sheetObj.RowCount() + 1 == sheetObj.MouseRow())
	  	 {
	  		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
	  		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
	  		 //alert(groupValue1);
	  		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
	  	 }
	   }    */ 
	    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	    	var eqKndCd=EQ_KND_CD_CHASSIS;
	    	var location=comboObjects[0].GetSelectCode();
	    	var crntLocCd=document.form.crnt_loc_cd.value;
	    	var crntYdCd=document.form.crnt_yd_cd.value;
	    	var aciacDivCd=comboObjects[1].GetSelectCode();
	    	var chssPoolCd=comboObjects[2].GetSelectCode();
	    	var includeNp="";
	    	if(document.form.include_np.checked){
	    		includeNp="Y";
	    	}
	    	var stayingDays=document.form.staying_days.value;
	    	var group1=comboObjects[3].GetSelectCode();
	    	var group2=comboObjects[4].GetSelectCode();
	    	var group3=comboObjects[5].GetSelectCode();
			var groupValue1=sheetObj.GetCellValue(Row, "group1");
			var groupValue2=sheetObj.GetCellValue(Row, "group2");
			var groupValue3=sheetObj.GetCellValue(Row, "group3");
		  	var s2_group1="";
		  	var s2_group1_val="";
		  	var s2_group2="";
		  	var s2_group2_val="";
		  	var s2_group3="";
		  	var s2_group3_val="";
		  	var s3_gtotal="";
		  	if(groupValue1.substring(0,9) == "Sub Total")
		  	{
			  	s2_group1=group1;
			  	s2_group1_val=sheetObj.GetCellValue(Row-1, "group1");
			  	s2_group2=group2;
			  	s2_group2_val=sheetObj.GetCellValue(Row-1, "group2");
			  	//alert("chungpa s2_group1_val:"+s2_group2_val + "   s2_group2:" + s2_group2);
			  	//alert("chungpa Row:"+ Row);
			  	if(Row>=3) 
			  	{
			  		for(var i=Row-1; i>=0; i--) 
			  		{
			  			if(sheetObj.GetCellValue(i,"group1")== "Sub Total")
			  			{
			  				break; 
			  			}
			  			if(s2_group2_val != sheetObj.GetCellValue(i,"group2"))
			  			{
			  				s2_group2="";
			  				break;
			  			}
			  		}
			  	}
			  	s2_group3=group3;
			  	s2_group3_val=sheetObj.GetCellValue(Row-1, "group3");
			  	if(Row>=3) 
			  	{
			  		for(var i=Row-1; i>=0; i--) 
			  		{
			  			if(sheetObj.GetCellValue(i,"group1")== "Sub Total")
			  			{
			  				break; 
			  			}
			  			if(s2_group3_val != sheetObj.GetCellValue(i,"group3"))
			  			{
			  				s2_group3="";
			  				break;
			  			}
			  		}
			  	}
			  	//alert("chungpa SG1>>"+s2_group1+": SG2>>"+s2_group2+ ": SG3>>"+ s2_group3);
			  	//return;
			  	s3_gtotal="";
			  	groupValue1="SubSum"; 
		  	}else if(groupValue1 == "Grand Total"){
		  		s3_gtotal="GTOTAL";
		  	}else{
		  		s2_group1="";
		  		s2_group1_val="";
		  		s2_group2="";
		  		s2_group2_val="";
		  		s2_group3="";
		  		s2_group3_val="";
		  	}
	    	var agmtLstmCd=comboObjects[7].GetSelectText();
	    	
	    	var vndrSeq="";
	    	if(document.form.vndr_seq.value == "" || document.form.vndr_seq.value == null){
	    		vndrSeq=sheetObj.GetCellValue(Row, "vndr_seq");
	    	}
	    	else{
	    		vndrSeq=document.form.vndr_seq.value;
	    	}
	    	
	    	var chssMvmtStsCd=comboObjects[8].GetSelectText();
	    	var eqTpszCd=eq_tpsz_cd.GetSelectText();
	    	var s2EqTpszCd="";
	    	var colSaveName=sheetObj.ColSaveName(Col);
	    	
	    	var k = 1;
			oldCntrTypeSize = sCntrTypeSize;
			var arrCntrTypeSize = oldCntrTypeSize.split("|");

			for ( var i = 0; i < arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
					var gubun = "eq_tpsz_cd" + k;
					if(colSaveName == gubun){
						s2EqTpszCd = arrCntrTypeSize[i];
						break;
					}
					k++;
				}
			}
	    	
	    	var param="?program_id=1089";
	    	param=param + "&eq_knd_cd=" + eqKndCd;
	    	param=param + "&location=" + location;
	    	param=param + "&crnt_loc_cd=" + crntLocCd;
	    	param=param + "&crnt_yd_cd=" + crntYdCd;
	    	param=param + "&aciac_div_cd=" + aciacDivCd;
	    	param=param + "&chss_pool_cd=" + chssPoolCd;
	    	param=param + "&include_np=" + includeNp;
	    	param=param + "&staying_days=" + stayingDays;
	    	param=param + "&eq_tpsz_cd=" + eqTpszCd;
	    	param=param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
	    	param=param + "&group1=" + group1;
	    	param=param + "&group2=" + group2;
	    	param=param + "&group3=" + group3;
	    	param=param + "&group_value1=" + groupValue1;
	    	param=param + "&group_value2=" + groupValue2;
	    	param=param + "&group_value3=" + groupValue3;
	    	param=param + "&agmt_lstm_cd=" + agmtLstmCd;
	    	param=param + "&vndr_seq=" + vndrSeq;
	    	param=param + "&chss_mvmt_sts_cd=" + chssMvmtStsCd;
		  	param=param + "&s2_group1=" + s2_group1;
		  	param=param + "&s2_group1_val=" + s2_group1_val;
		  	param=param + "&s2_group2=" + s2_group2;
		  	param=param + "&s2_group2_val=" + s2_group2_val;
		  	param=param + "&s2_group3=" + s2_group3;
		  	param=param + "&s2_group3_val=" + s2_group3_val;
		  	param=param + "&s3_gtotal=" + s3_gtotal;
	    	//var seq = sheetObj.cellValue(Row, "Seq");
	    	if(Col > 3)// && seq != '')
	        {
		    	ComOpenPopup('/opuscntr/EES_CGM_1091.do' + param, 910, 570, "", "1,0", true, false);
	        }else
	        {
	            ComShowCodeMessage('CGM10016');
	        }
	    }
	    /**
	     * Location Multi-Combo OnChange event handling <br>
	     * @param  {object} ComboObj		 Sheet Object
	     * @param  {int} 	Index_Code	
	     * @param  {string} Text		
	     * @return 
	     * @version
	     */ 
	    function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	    	document.form.crnt_loc_cd.value="";
	    	if(combo_location.GetSelectText()== "SCC")
	    	{
	    		comboObjects[3].SetSelectIndex(3);
	    		comboObjects[4].SetSelectIndex(1);
	    	}else
	    	{
	    		comboObjects[3].SetSelectIndex(1);
	    		comboObjects[4].SetSelectIndex(2);
	    		comboObjects[5].SetSelectIndex(2);
	    	}
	    	
	    	document.form.combo_location_text.value = newCode;
	    	document.form.location.value = newCode;
	   	}
	    
	    function combo_location_OnBlur() {
	    	combo_location.value = combo_location.GetSelectCode();
	    }
	    
	    function aciac_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    	aciac_div_cd.value = aciac_div_cd.GetText(parseInt(aciac_div_cd.GetSelectIndex()), 0);
	    }
	    
	    function aciac_div_cd_OnBlur() {
	    	aciac_div_cd.value = aciac_div_cd.GetText(parseInt(aciac_div_cd.GetSelectIndex()), 0);
	    }
	    
	    function chss_pool_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    	chss_pool_cd.value = chss_pool_cd.GetText(parseInt(chss_pool_cd.GetSelectIndex()), 0);
	    }
	    
	    function chss_pool_cd_OnBlur() {
	    	chss_pool_cd.value = chss_pool_cd.GetText(parseInt(chss_pool_cd.GetSelectIndex()), 0);
	    }
	    
	    /**
	     * Group1 Multi-Combo OnChange event handling <br>
	     * @param  {object} ComboObj		 Sheet Object
	     * @param  {int} 	Index_Code	
	     * @param  {string} Text		
	     * @return 
	     * @version
	     */ 
	    function group1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
//	    	document.form.group1_text.value = group1.GetText(parseInt(group1.GetSelectIndex()), 0);
	    	//Group MultiCombo value reset
	      	var arrGroup=new Array();
	    	var sheetObj=sheetObjects[0];
	      	if(comboObj.GetSelectCode()== 1){
	      		arrGroup[0]="2|Office";
	          	arrGroup[1]="3|SCC[Location]";
	          	arrGroup[2]="4|Yard";
	          	arrGroup[3]="5|Lease term";
	          	arrGroup[4]="6|Lessor";
	          	arrGroup[5]="7|Mvmt Status";
	      	} else if(comboObj.GetSelectCode()== 2){
	          	arrGroup[0]="3|SCC[Location]";
	          	arrGroup[1]="4|Yard";
	          	arrGroup[2]="5|Lease term";
	          	arrGroup[3]="6|Lessor";
	          	arrGroup[4]="7|Mvmt Status";
	      	} else if(comboObj.GetSelectCode()== 3){
	          	arrGroup[0]="4|Yard";
	          	arrGroup[1]="5|Lease term";
	          	arrGroup[2]="6|Lessor";
	          	arrGroup[3]="7|Mvmt Status";
	      	} else if(comboObj.GetSelectCode()== 4){
	          	arrGroup[0]="5|Lease term";
	          	arrGroup[1]="6|Lessor";
	          	arrGroup[2]="7|Mvmt Status";
	      	}
	      	// Group2 MultiCombo value reset
	      	makeComboObject(group2, arrGroup, 1, 0, 1);
	      	// Group3 MultiCombo Clear
	      	comboObjects[5].RemoveAll();
	      	// Sheet Object title value setting
	      	sheetObj.RemoveAll();
	      	sheetObj.SetCellValue(0,"group1", comboObj.GetSelectText());
	      	sheetObj.SetCellValue(0,"group2", "");
	      	sheetObj.SetCellValue(0,"group3", "");
	      	if(sheetObj.GetCellValue(0,"group1") == ""){
	      		sheetObj.SetColHidden("group1",1);
	      	} else {
	      		sheetObj.SetColHidden("group1",0);
	      	}
	      	sheetObj.SetColHidden("group2",1);
	  		sheetObj.SetColHidden("group3",1);
	  		checkGroup2Yard();
	    }
	    
	    function group1_OnBlur() {
//	    	document.form.group1_text.value = group1.GetText(parseInt(group1.GetSelectIndex()), 0);
	    }
	    /**
	     * Group2 Multi-Combo OnChange event handling <br>
	     * @param  {object} ComboObj		 Sheet Object
	     * @param  {int} 	Index_Code	
	     * @param  {string} Text		
	     * @return 
	     * @version
	     */ 
	    function group2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
//	    	document.form.group2_text.value = group2.GetText(parseInt(group2.GetSelectIndex()), 0);
	    	var sheetObj=sheetObjects[0];
	    	var group1Value=comboObjects[3].GetSelectCode();
	    	var arrGroup=new Array();
	    	if(group1Value == 1){
	    		if(comboObj.GetSelectCode()== 2){
	    			arrGroup[0]="3|SCC[Location]";
	              	arrGroup[1]="4|Yard";
	              	arrGroup[2]="5|Lease term";
	              	arrGroup[3]="6|Lessor";
	              	arrGroup[4]="7|Mvmt Status";
	    		} else if(comboObj.GetSelectCode()== 3){
	    			arrGroup[0]="4|Yard";
	              	arrGroup[1]="5|Lease term";
	              	arrGroup[2]="6|Lessor";
	              	arrGroup[3]="7|Mvmt Status";
	    		} else if(comboObj.GetSelectCode()== 4){
	              	arrGroup[0]="5|Lease term";
	              	arrGroup[1]="6|Lessor";
	              	arrGroup[2]="7|Mvmt Status";
	    		}
	    	} else if(group1Value == 2){
	    		if(comboObj.GetSelectCode()== 3){
	    			arrGroup[0]="4|Yard";
	    			arrGroup[1]="5|Lease term";
	    			arrGroup[2]="6|Lessor";
	    			arrGroup[3]="7|Mvmt Status";
	    		} else if(comboObj.GetSelectCode()== 4){
	    			arrGroup[0]="5|Lease term";
	    			arrGroup[1]="6|Lessor";
	    			arrGroup[2]="7|Mvmt Status";
	    		}
	    	} else if(group1Value == 3){
	    		if(comboObj.GetSelectCode()== 4){
	    			arrGroup[0]="5|Lease term";
	    			arrGroup[1]="6|Lessor";
	    			arrGroup[2]="7|Mvmt Status";
	    		}
	    	}
	    	makeComboObject(group3, arrGroup, 1, 0, 1);
	    	// Sheet Object title value setting
	      	sheetObj.RemoveAll();
			sheetObj.SetCellValue(0,"group2", comboObj.GetSelectText());
			sheetObj.SetCellValue(0,"group3", "");
	      	sheetObj.SetColHidden("group2",0);
	      	if(sheetObj.GetCellValue(0,"group2") == ""){
	      		sheetObj.SetColHidden("group2",1);
	      	} else {
	      		sheetObj.SetColHidden("group2",0);
	      	}
	  		sheetObj.SetColHidden("group3",1);
	    }
	    
	    function group2_OnBlur() {
//	    	document.form.group2_text.value = group2.GetText(parseInt(group2.GetSelectIndex()), 0);
	    }
	    /**
	     * Group3 Multi-Combo OnChange event handling <br>
	     * @param  {object} ComboObj	mandatory	 Sheet Object
	     * @param  {int} 	Index_Code	mandatory
	     * @param  {string} Text		mandatory
	     * @return 
	     * @version
	     */ 
	    function group3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
//	    	document.form.group3_text.value = group3.GetText(parseInt(group3.GetSelectIndex()), 0);
	    	var sheetObj=sheetObjects[0];
	    	// Sheet Object title value setting
	      	sheetObj.RemoveAll();
	      	sheetObj.SetCellValue(0,"group3", comboObj.GetSelectText());
	      	sheetObj.SetColHidden("group3",0);
	      	if(sheetObj.GetCellValue(0,"group3") == ""){
	      		sheetObj.SetColHidden("group3",1);
	      	} else {
	      		sheetObj.SetColHidden("group3",0);
	      	}
	    }
	    
	    function group3_OnBlur() {
//	    	document.form.group3_text.value = group3.GetText(parseInt(group3.GetSelectIndex()), 0);
	    }
	    
	    function eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	    	document.form.eq_tpsz_cd_text.value = newCode;
	    }
	    
	    function eq_tpsz_cd_OnBlur() {
//	    	document.form.eq_tpsz_cd_text.value = eq_tpsz_cd.GetSelectCode();
	    }
	    
	    function agmt_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	    	document.form.agmt_lstm_cd_text.value = newCode;
	    }
	    
	    function agmt_lstm_cd_OnBlur() {
//	    	document.form.agmt_lstm_cd_text.value = agmt_lstm_cd.GetSelectCode();
	    }
	    
	    function chss_mvmt_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	    	document.form.chss_mvmt_sts_cd_text.value = newCode;
	    }
	    
	    function chss_mvmt_sts_cd_OnBlur() {
//	    	document.form.chss_mvmt_sts_cd_text.value = chss_mvmt_sts_cd.GetSelectCode();
	    }
	    /** 
	     * Object activate event handling  <br>
	     * @param  
	     * @return 
	     * @author 
	     * @version 
	     */
	    function obj_activate(){
	      	ComClearSeparator(event.srcElement);
	    } 
	    /** 
	     * Object deactivate event handling  <br>
	     * @param  
	     * @return 
	     * @author 
	     * @version 
	     */
	    function obj_deactivate(){
	    	//ComChkObjValid(event.srcElement);
	    }
	    /** 
	     * Object Keypress event handling  <br>
	     * 
	     * @param  
	     * @return 
	     * @author 
	     * @version 
	     */ 
	    function obj_keypress(){
	      	obj=event.srcElement;
	      	if(obj.dataformat == null) return;
	      	window.defaultStatus=obj.dataformat;
	      	switch(obj.dataformat) {
	      	 	case "ym": case "ymd":
	      	 		ComKeyOnlyNumber(obj);
	      	 		break;
	      	 	case "int":
	      	 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
	      	 		else ComKeyOnlyNumber(obj);
	      	        break;
	      	 	case "float":
	 	            ComKeyOnlyNumber(obj, "-.");
	 	            break;    
	      	    case "eng":
	      	    	if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
	      	    	else ComKeyOnlyAlphabet(); 
	      	        break;
	      	    case "engup":
	      	        if(obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('uppernum',"44");
	      	        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
	      	        else ComKeyOnlyAlphabet('upper');
	      	        break;
	      	    case "engdn":
	      	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
	      	        else ComKeyOnlyAlphabet('lower');
	      	        break;
	      	}
	    } 
	    /** 
	     * Object change event handling  <br>
	     * @param  
	     * @return 
	     * @author 
	     * @version
	     */  
	    function obj_change(){
	    	 var formObj=document.form;
	    	 var sheetObj=sheetObjects[0]; 
	    	 obj=event.srcElement;
	    	 switch(ComGetEvent("name")){
	    	   	case "vndr_seq":
	    	   		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
	    	   		var arrVndrSeq=vndrSeq.split(",");
	    	   		for(var i=0; i < arrVndrSeq.length; i++){
	    	   		// 
	    	 			if(arrVndrSeq[i] == ''){
	    	 				ComShowCodeMessage('CGM10009','Lessor');
	    	 				formObj.vndr_seq.value="";
	    	 				ComSetFocus(formObj.vndr_seq);
	    	 				break;
	    	 			}
	    	   		}
	    	   		break;    	   	
	    	 }   
	    }
	    /** 
	     * Combo Object reset  <br>
	     * @param  {object} comboObj	Combo Object
	     * @return 
	     * @author 
	     * @version
	     */ 
	    function initCombo(comboObj) {
	    	switch(comboObj.options.id) {
		    	case "combo_location":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(100);
		  	            SetMultiSelect(0);
		  	            SetMaxSelect(1);
		  	            SetEnable(1);
		  	            SetUseAutoComplete(1);
		  	        }
		  	        break;
		    	case "aciac_div_cd":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(100);
		  	            SetMultiSelect(0);
		  	            SetMaxSelect(1);
		  	            SetEnable(1);
		  	            SetUseAutoComplete(1);
		  	        }
		  	        break;
		    	case "chss_pool_cd":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(100);
		  	            SetMultiSelect(0);
		  	            SetMaxSelect(1);
		  	            SetEnable(1);
		  	            SetUseAutoComplete(1);
		  	        }
		  	        break;
		    	case "group1":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(170);
		  	            SetMultiSelect(0);
		  	            SetMaxSelect(1);
		  	            SetEnable(1);
		  	            SetUseAutoComplete(1);
		  	        }
		  	        break;    
		    	case "group2":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(150);
		  	            SetMultiSelect(0);
		  	            SetMaxSelect(1);
		  	            SetEnable(1);
		  	            SetUseAutoComplete(1);
		  	        }
		  	        break;
		    	case "group3":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(150);
		  	            SetMultiSelect(0);
		  	            SetMaxSelect(1);
		  	            SetEnable(1);
		  	            SetUseAutoComplete(1);
		  	        }
		  	        break;
		    	case "eq_tpsz_cd":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(150);
		  	            SetMultiSelect(1);
		  	            SetMaxSelect(100);
		  	            SetEnable(1);
		  	            SetMaxLength(20);
		  	        }
		  	        break;
		    	case "agmt_lstm_cd":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(180);
		  	            SetMultiSelect(1);
		  	            SetMaxSelect(100);
		  	            SetEnable(1);
		  	            SetMaxLength(20);
		  	        }
		  	        break;
		    	case "chss_mvmt_sts_cd":
		 	 		var cnt=0;
		  	        with(comboObj) {
		  	        	SetSelectCode("");
		  	            SetSelectText("");
		  	            SetDropHeight(150);
		  	            SetMultiSelect(1);
		  	            SetMaxSelect(100);
		  	            SetEnable(1);
		  	            SetMaxLength(20);
		  	        }
		  	        break;
	    	}
	    }  
	    function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	    	cmbObj.RemoveAll();
	    	if(opt == 0) {
	    		for (var i=0; i < arrStr.length;i++ ) {
	    			var arrCode=arrStr[i].split("|");
	        		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
	            }
	    	} else if(opt == 1){
	    		cmbObj.InsertItem(0,"","");
	    		for (var i=0; i < arrStr.length;i++ ) {
	    			var arrCode=arrStr[i].split("|");
	        		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
	            }
	    	}
	    	cmbObj.SetSelectIndex("" ,false);
	    }   
	    function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
	       	cmbObj.RemoveAll();
	       	if(arrStr == undefined ){
	       		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	   			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	   			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	       	} else {
	           	var arrCode=arrStr[0].split("|");
	         	var arrCode2=arrStr[1].split("|");
		          	for (var i=0; i < arrCode.length;i++ ) {
		          		var arrCode3=arrCode[i].split("|");
		          		var arrCode4=arrCode2[i].split("|");
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
	       	cmbObj.SetSelectIndex("" ,false);
	       } 
	    function doc_type_change() {
	    	var formObj=document.form;
//	    	document.getElementById('chartLayer').style.display="none";
	    	document.getElementById('sheetLayer').style.display="none";
	    	if(formObj.doc_type[0].checked==true)
	    	{
	    		//document.getElementById('chartLayer').style.visibility = 'hidden';
	    		//document.getElementById('sheetLayer').style.visibility = 'visible';
	    		document.getElementById('sheetLayer').style.display="";
	    		$("#chartLayer").addClass("rd_hidden");
	    	}else 
	    	{
	    		//document.getElementById('sheetLayer').style.visibility = 'hidden';
	    		//document.getElementById('chartLayer').style.visibility = 'visible';
	    		document.getElementById('chartLayer').style.display="";
	    		$("#chartLayer").removeClass("rd_hidden");
//	    		if(sheetObjects[0].RowCount() > 0){
//	    			rdOpen();
//	    		}
	    	}
	    }
	   function enterFire() {
		   var formObj=document.form;
		   var sheetObj=sheetObjects[0];
		   if(event.keyCode == 13)
		   {
			   if(validateForm(sheetObj,formObj,IBSEARCH))
			   {
				   ComKeyEnter('search');
			   }
		   }
	   }        
	   function checkGroup2Yard(){
		var formObj=document.form;
		var crntYdCd=ComTrimAll(formObj.crnt_yd_cd.value);
		var arrCrntYdCd=crntYdCd.split(",");
		if(
				(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7) 	
			||  (formObj.crnt_yd_cd.value.search(',') > 0)							
		){
			if(group1.GetSelectCode()== 1){
		  		comboObjects[4].SetSelectIndex(3);//
		  		//arrGroup[0] = "2|Office";
		      	//arrGroup[1] = "3|SCC[Location]";
		      	//arrGroup[2] = "4|Yard";
		      	//arrGroup[3] = "5|Lease term";
		      	//arrGroup[4] = "6|Lessor";
		      	//arrGroup[5] = "7|Mvmt Status";
		 	} else if(group1.GetSelectCode()== 2){
		  		comboObjects[4].SetSelectIndex(2);
		      	//arrGroup[0] = "3|SCC[Location]";
		      	//arrGroup[1] = "4|Yard";
		      	//arrGroup[2] = "5|Lease term";
		      	//arrGroup[3] = "6|Lessor";
		      	//arrGroup[4] = "7|Mvmt Status";
		  	} else if(group1.GetSelectCode()== 3){
		  		comboObjects[4].SetSelectIndex(1);
		  	  	//arrGroup[0] = "4|Yard";
		      	//arrGroup[1] = "5|Lease term";
		      	//arrGroup[2] = "6|Lessor";
		      	//arrGroup[3] = "7|Mvmt Status";
		  	} else if(group1.GetSelectCode()== 4){
		      	//arrGroup[0] = "5|Lease term";
		      	//arrGroup[1] = "6|Lessor";
		      	//arrGroup[2] = "7|Mvmt Status";
		  	}		
		}else
		{
			/* 
			if(group1.GetSelectCode()== 1){
		  		comboObjects[4].SetSelectIndex(0);//
		  		//arrGroup[0] = "2|Office";
		      	//arrGroup[1] = "3|SCC[Location]";
		      	//arrGroup[2] = "4|Yard";
		      	//arrGroup[3] = "5|Lease term";
		      	//arrGroup[4] = "6|Lessor";
		      	//arrGroup[5] = "7|Mvmt Status";
		 	} else if(group1.GetSelectCode()== 2){
		 		comboObjects[4].SetSelectIndex(0);//
		      	//arrGroup[0] = "3|SCC[Location]";
		      	//arrGroup[1] = "4|Yard";
		      	//arrGroup[2] = "5|Lease term";
		      	//arrGroup[3] = "6|Lessor";
		      	//arrGroup[4] = "7|Mvmt Status";
		  	} else if(group1.GetSelectCode()== 3){
		  		comboObjects[4].SetSelectIndex(0);//
		  	  	//arrGroup[0] = "4|Yard";
		      	//arrGroup[1] = "5|Lease term";
		      	//arrGroup[2] = "6|Lessor";
		      	//arrGroup[3] = "7|Mvmt Status";
		  	} else if(group1.GetSelectCode()== 4){
		  		comboObjects[4].SetSelectIndex(0);//
		      	//arrGroup[0] = "5|Lease term";
		      	//arrGroup[1] = "6|Lessor";
		      	//arrGroup[2] = "7|Mvmt Status";
		  	}		
		  	*/	
		}
	}
	/**
	 * value check logic
	 * @author 
	 */
	function obj_keyup(){
		 var formObj=document.form;
		 var sheetObj=sheetObjects[0];
		 obj=event.srcElement;
		 switch(ComGetEvent("name")){
	 	 	case "crnt_loc_cd":
		 		var crntLocCd=ComTrimAll(formObj.crnt_loc_cd.value);
		   		var arrCrntLocCd=crntLocCd.split(",");
		   		for(var i=0; i < arrCrntLocCd.length; i++){
		   		// 
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.crnt_loc_cd.value="";
		 				ComSetFocus(formObj.crnt_loc_cd);
		 				break;
		 			}else
		 			{
		    	 		//if(formObj.crnt_loc_cd.value != ''){
		    	 		if(formObj.crnt_loc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		 			}
		   		}
		 		break; 
	 	   	case "crnt_yd_cd":
		   		var crntYdCd=ComTrimAll(formObj.crnt_yd_cd.value);
		   		if( formObj.crnt_yd_cd.value.search(',') > 0 || (formObj.crnt_yd_cd.value == '')) 
		   		{
		   			checkGroup2Yard();
		   			break;
		   		}
		   		var arrCrntYdCd=crntYdCd.split(",");
		   		for(var i=0; i < arrCrntYdCd.length; i++){
		   			// 
		 			if(arrCrntYdCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Yard');
		 				formObj.crnt_yd_cd.value="";
		 				ComSetFocus(formObj.crnt_yd_cd);
		 				break;
		 			}
		   		}
		 		//if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != ''){
		 		if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7){
		 			//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		   			checkGroup2Yard();		 			
	 	 		} 
	 	 		break;
		 }
	}               
		