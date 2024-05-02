/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_0088.js
*@FileTitle  : Land Inventory 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var head_cntr_tpsz_cd="";
    var headTitle="";
    var tot_cnmv_sts_cd="";
    var tot_lstm_cd="";
    var comboObjects=new Array();
    var comboCnt=0 ;
    var IBSEARCH01=29;
    var IBSEARCH02=30;
    var IBSEARCH03=31;
    var IBSEARCH04=32;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
   	function processButtonClick(){
//	    var sheetObject1=sheetObjects[0];
//	    var sheetObject2=sheetObjects[1];
//	    var sheetObject3=sheetObjects[2];	        
//	    var sheetObject4=sheetObjects[3];
	    /*******************************************************/
	    var formObject=document.form;
		try {
	   		var srcName=ComGetEvent("name");
	   		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
			case "btn_New":		// initializing
				comboObjects[0].SetSelectCode("");
				comboObjects[1].SetSelectCode("");
				comboObjects[2].SetSelectCode("");
				formObject.loc_type_code.value="1";
				formObject.loc_cd.value="";
				loc_type_code_onchange();
				formObject.full_flg.value='';
				formObject.dmg_flg.value='';
				formObject.soc_cd.value='1';
				formObject.cntr_hngr_rck_cd.checked=false;
				formObject.disp_flg.checked=false;
				formObject.d2_payld_flg.checked=false;
				formObject.cntr_no.value='';
				t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				
				tabObjects[0].SetSelectedIndex(0);
				
				sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
	    		sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
	    		sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
				break;
			case "btn_loc_cd":	//popup retrieving Location
    	        var cnt_cd="";
    	        var loc_cd="";
	            cnt_cd=formObject.loc_type_code.value;
	            loc_cd=formObject.loc_cd.value;
	            if ( formObject.loc_type_code.value != '1' && formObject.loc_type_code.value != '2') {	
        			var loc_code="";
        			if ( form.loc_type_code.value == "3" ) {
        				loc_code="rcc_cd";
        			} else if ( form.loc_type_code.value == "4" ) {
        				loc_code="lcc_cd";
        			} else if ( form.loc_type_code.value == "5" ) {
        				loc_code="lcc_cd";
        			} else if ( form.loc_type_code.value == "6" ) {
        				loc_code="ecc_cd";
        			} else if ( form.loc_type_code.value == "7" ) {
        				loc_code="scc_cd";
        			} else if ( form.loc_type_code.value == "8" ) { 
        				loc_code="rcc_cd";
        			}
					var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);
	            }
				break;
			case "btn_DownExcel":	//DOWN EXCEL
				if ( beforetab == 0 ) {	  //retrieving first tab
					doActionIBSheet(t1sheet1,formObject,IBDOWNEXCEL);
				} else if ( beforetab == 1 ) {	//retrieving second tab
					doActionIBSheet(t2sheet1,formObject,IBDOWNEXCEL);
				} else if ( beforetab == 2 ) {	//retrieving third tab
					doActionIBSheet(t3sheet1,formObject,IBDOWNEXCEL);
				}
				break;
			case "btn_Retrieve":
				
	        	document.form.cntr_tpsz_cd.value=comboObjects[1].GetSelectCode();
	        	document.form.cnmv_sts_cd.value=comboObjects[2].GetSelectCode();        	
				
				if ( beforetab == 0 ) {	  //retrieving first tab
					doActionIBSheet(t1sheet1,document.form,IBSEARCH02);
				} else if ( beforetab == 1 ) {	//retrieving second tab
					doActionIBSheet(t2sheet1,document.form,IBSEARCH);
				} else if ( beforetab == 2 ) {	//retrieving third tab
					//doActionIBSheet(sheetObject3,document.form,IBSEARCH03);
					doActionIBSheet(t3sheet1,document.form,IBSEARCH03);
				}
				break;
			case "btn_Print":		//Print
				if ( beforetab == 0 ) {	  //printing first tab
					setSheetPrintCopyObject(t1sheet1,2);
				} else if ( beforetab == 1 ) {	//printing second tab
					setSheetPrintCopyObject(t2sheet1,1);
				} else if ( beforetab == 2 ) {	//printing third tab
					setSheetPrintCopyObject(t3sheet1,3);
				}
				break;
           } // end switch
   		} catch(e) {
   			if( e == "[object Error]") {
   				ComShowMessage(OBJECT_ERROR);
   			} else {
   				ComShowMessage(e.message);
   			}
   		}
   	}
    /**
     * filtering to print for sheet1
     * in case of level = 1
     */
    function setSheetPrintCopyObject(sheetObj,cnt){
    	if ( sheetObj.RowCount()!= 0 ) {
			var formObject=document.form;
			if ( formObject.loc_type_code.value == "1" ) {
				str_loc_nm="RCC";
 			} else if ( formObject.loc_type_code.value == "2" ) {
 				str_loc_nm="Country";
 			} else if ( formObject.loc_type_code.value == "3" ) {
 				str_loc_nm="LCC";
 			} else if ( formObject.loc_type_code.value == "4" ) {
 				str_loc_nm="ECC";
 			} else if ( formObject.loc_type_code.value == "5" ) {
 				str_loc_nm="SCC";
 			} else if ( formObject.loc_type_code.value == "6" ) {
 				str_loc_nm="SCC";
 			} else if ( formObject.loc_type_code.value == "7" ) {
 				str_loc_nm="Yard";
 			}
			var HeadTitle="";
			if (cnt == 1) {
				HeadTitle=str_loc_nm+"|Total|"+head_cntr_tpsz_cd;
			} else if ( cnt ==2 ) {
				HeadTitle=str_loc_nm+"|MVMT|"+head_cntr_tpsz_cd;
			} else if ( cnt ==3 ) {
				HeadTitle=str_loc_nm+"|Term|"+head_cntr_tpsz_cd;
			}
            headTitle=HeadTitle;
	    	if (cnt == 1) {
		   		sheetObjects[3].RemoveAll();
	            sheetObjects[3].RenderSheet(0);
	            initSheet(sheetObjects[3],4,HeadTitle);
	            sheetObjects[3].RenderSheet(1);
		    	for ( var i=0; i<=sheetObj.LastRow(); i++) {
		    		var level=sheetObj.GetCellValue(i, "lvl0");
		    		if ( formObject.loc_type_code.value=='2') {
		    			level='0';
		    		} else {
		    			level='1';
		    		}
		    		if ( sheetObj.GetCellValue(i, "lvl0") == level || sheetObj.GetCellValue(i, "loc_cd").toUpperCase() =='TOTAL' ) {
		    			var Row=sheetObjects[3].DataInsert();
		    			for ( var j=0; j<HeadTitle.split("|").length; j++ ) {
		    				sheetObjects[3].SetCellValue(Row,j,sheetObj.GetCellValue(i, j),0);
		    			}
		    		}
		    	}
	    	}
			ComOpenPopupWithTarget('/opuscntr/EES_CIM_0908_POP.do', 775, 750, "", "0,1,1,1,1,1,1", true);
		} else {
			ComShowMessage(msgs["CIM30008"]);	//No data found
			return;
		}
    }
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setSheetObject(sheet_obj){
      sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering initial event 
     */
    function initControl() {
		axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');		//Location by 변경시 이벤트 처리
    	axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', '');						//cntr_no keyup 이벤트 처리
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd', '');						//LOC_CD keyup 이벤트 처리
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리
    }
    /**
     * Period FM  beforeactivate - handling event
     * Period FM  beforeactivate - deleting
     */    
 	function obj_activate() {
 		ComClearSeparator(ComGetEvent());
 	}
     /**
 	* Period to  beforedeactivate handling event
 	* Period to  beforedeactivate YYYY-MM handling format
 	*/	
 	function obj_deactivate() {
 		ComAddSeparator(ComGetEvent());
 	}
    /**
     * TP/SZ  registering click event
     */
    function combo_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    /**
     * MVMT Status  registering click event
     */
    function combo_cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		comboObj.SetItemCheck(0,0);
    	}
    }    
    /**
     * Lease Term  registering click event
     */
    function lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		comboObj.SetItemCheck(0,0);
    	}
    } 
	/**
	 * Location  blur handling event
	 * validating code
	 */	
	function obj_blur() {
		switch (ComGetEvent("name")) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH04);
				}
				break;
		}
	}
    /**
     * list for key evnet
     */
//	function obj_keypress() {
//		var formObject=document.form;
//		switch (event.srcElement.name) {
//			case "loc_cd":
//				ComKeyOnlyAlphabet('uppernum');// upper, numbers only
//				break;
//		}
//	}
    /**
    * handling event LOC_CD keyup
    * upper in case of LOC_CD keyup
    */
    function loc_cd_onkeyUp() {
        var formObject=document.form;
        if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        if ( formObject.loc_type_code.value == '2' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",2);
	        	    formObject.loc_cd.value=formObject.loc_cd.value.substring(0,2).toUpperCase();
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
	     	   if ( formObject.loc_cd.value.length == 5 ) {
	    		   ComSetFocus(document.form.focus_loc_cd);
	    	   }
	        }
        }
   }
    /**
    * handling event in case or changing Location by
    * deactivating input column in case of selecting option ALL (by RCC)
    * activating the others
    */
    function loc_type_code_onchange() {
        var formObject=document.form;
        if ( formObject.loc_type_code.value == '1' || formObject.loc_type_code.value == '2') {
            formObject.loc_cd.readOnly=true;
            formObject.loc_cd.className="input2";
            formObject.loc_cd.value="";
        } else {
            formObject.loc_cd.readOnly=false;
            formObject.loc_cd.className="input1";
        }
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }
    /**
    * handling event for cntr_no keyup 
    * upper in case of cntr_no keyup
    */
    function cntr_no_onkeyUp() {
       var formObject=document.form;
        formObject.cntr_no.value=formObject.cntr_no.value.toUpperCase();
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        initControl();
        t1sheet1_OnLoadFinish(sheetObjects[0]);
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
    }
    //creating MVMT Status 
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        //MVMT Status
        var arr_cnmv_sts_cd=cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm=cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd=arr_cnmv_sts_cd;
        with (combo_cnmv_sts_cd) {
        	SetMultiSelect(1);
            SetMultiSeparator(",");
            SetDropHeight(320);
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }    
    function t1sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    }    
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
    * seting Tab initial items
    */
    function initCombo (comboObj, comboNo) {
    }
    /**
     * setting value from Location by loc_cd popup
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        formObject.loc_cd.value=aryPopupData[0][3] 
    }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
    function initSheet(sheetObj,sheetNo,headTitle) {
        var cnt=0;
        switch(sheetNo) {
      
        case 1:      //t1sheet1 init
        	with(sheetObj){
		        	if (headTitle==null || headTitle =="") {
		        		headTitle="RCC|MVMT|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4";
		        	}
		        	var headCnt=headTitle.split("|").length;
		        	if ( SheetWidth>975 ) {
		        	}
		        	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:2, Page:20} );
		
		        	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		        	var headers = [ { Text:headTitle, Align:"Center"} ];
		        	InitHeaders(headers, info);
		
		        	var cols = [ {Type:"Text",   Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              for(var i=1 ; i <= headCnt - 3 ; i++){
	            	  cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	              }
	              cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
	              InitColumns(cols);
	              SetCountPosition(0);
	              //SetSheetHeight(350);
	              ComResizeSheet(sheetObj);
	              SetEditable(0);
                 }
            break;
        case 2:      //t2sheet1 init
            with(sheetObj){
        	if (headTitle==null || headTitle =="") {
        		headTitle="RCC|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4";
        	}
        	
        	var headCnt=headTitle.split("|").length;
        	var headTitles=headTitle.split("|");

        	SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:2, Page:20 } );

        	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
        	var headers = [ { Text:headTitle, Align:"Center"} ];
        	InitHeaders(headers, info);

          var cols = [ {Type:"Text",   Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   TreeCol:1 ,  LevelSaveName:"sLevel" },
                       {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                for(var i=1 ; i <= headCnt - 2 ; i++){
                	cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                }
                cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"lvl0",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
     
                InitColumns(cols);
                SetCountPosition(0);
                SetSheetHeight(410);
                //resizeSheet();
                SetEditable(0);
               // InitTreeInfo(0, "sLevel", "#0000FFNAN");
          }


            break;
        case 3:      //t3sheet1 init
            with(sheetObj){
          
        	if (headTitle==null || headTitle =="") {
        		headTitle="RCC|Term|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4";
        	}
        	var headCnt=headTitle.split("|").length;
        	if ( SheetWidth>975 ) {
        	}

        	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:2, Page:20} );

        	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
        	var headers = [ { Text:headTitle, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"Text",   Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"division",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                  	for(var i=1 ; i <= headCnt -3 ; i++){
                  		cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                  	}
                  	cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
                  	InitColumns(cols);
                  	SetCountPosition(0);
                  	SetSheetHeight(410);
                  	//resizeSheet();
                  	SetEditable(0);
                  }


            break;    
        case 4:      //t4sheet1 init
            with(sheetObj){
            
        	if (headTitle==null || headTitle =="") {
        		headTitle="RCC|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|R7|P2|P4|T2|T4";
        	}
        	var headCnt=headTitle.split("|").length;
        	var headTitles=headTitle.split("|");

        	SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

        	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
        	var headers = [ { Text:headTitle, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                  for(var i=1 ; i <= headCnt - 2 ; i++){
                	  cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                  }
 
                  InitColumns(cols);
                  SetCountPosition(0);
                  SetSheetHeight(410);
                  //resizeSheet();
                  SetEditable(0);
         }


            break;           
       }
    }
 // Sheet의 높이 자동으로 변경

    // handling process for Sheet
    function doActionIBSheet(sheetObj, formObj, sAction, cnmv_sts_cd , cnmv_sts_nm) {
//       sheetObj.ShowDebugMsg = false;
       switch(sAction) {
         case IBSEARCH:      
        	if(!validateForm(sheetObj,formObj,sAction)) return;
        	
//        	document.form.cntr_tpsz_cd.value=comboObjects[1].GetSelectCode();
//        	document.form.cnmv_sts_cd.value=comboObjects[2].GetSelectCode();        	
        	sheetObj.SetWaitImageVisible(0);
        	setHeaderValue(sheetObj,2);	//setting title header 
        	sheetObj.RemoveAll();
        	//sheetObj.Redraw = false;
        	sheetObj.SetWaitImageVisible(0);
        	ComOpenWait(true);         	
        	
        	if(document.form.loc_type_code.value == "1") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
        	} else  if(document.form.loc_type_code.value == "2") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "Country");
        		sheetObjects[1].SetCellText(0, "loc_cd", "Country");
        		sheetObjects[2].SetCellText(0, "loc_cd", "Country");
        	} else  if(document.form.loc_type_code.value == "3") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "LCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "LCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "LCC");
        	} else  if(document.form.loc_type_code.value == "4") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "ECC");
        	} else  if(document.form.loc_type_code.value == "5") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "SCC");
        	} else  if(document.form.loc_type_code.value == "6") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "SCC");
        	} else  if(document.form.loc_type_code.value == "7") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "Yard");
        		sheetObjects[1].SetCellText(0, "loc_cd", "Yard");
        		sheetObjects[2].SetCellText(0, "loc_cd", "Yard");
        	} else  if(document.form.loc_type_code.value == "8") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "ECC");
        	} 
        	
        	formObj.f_cmd.value=SEARCH; 
        	sheetObj.DoSearch("EES_CIM_0008GS.do",FormQueryString(formObj) );
            //ComOpenWait(false);
            break;
         case IBSEARCH01:     
             sheetObj.SetWaitImageVisible(0);
             form.f_cmd.value=SEARCH01;
             var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do" , FormQueryString(form));
             //retrieving TP/SZ
             var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   
             head_cntr_tpsz_cd=cntr_tpsz_cd;
             document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd; 
             var strCntrTpszCd=cntr_tpsz_cd.split("|");
             with (combo_cntr_tpsz_cd) {
            	 SetMultiSelect(1);
                 SetMultiSeparator(",");
                 SetDropHeight(330);
            	 InsertItem(0 , 'ALL','');
            	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    	        	 InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
            	 }
             }                     
 			 if ( form.loc_type_code.value == "1" ) {
 				 str_loc_nm="RCC";
 			 } else if ( form.loc_type_code.value == "2" ) {
 				 str_loc_nm="Country";
 			 } else if ( form.loc_type_code.value == "3" ) {
 				 str_loc_nm="LCC";
 			 } else if ( form.loc_type_code.value == "4" ) {
 				 str_loc_nm="ECC";
 			 } else if ( form.loc_type_code.value == "5" ) {
 				 str_loc_nm="SCC";
 			 } else if ( form.loc_type_code.value == "6" ) {
 				 str_loc_nm="SCC";
 			 } else if ( form.loc_type_code.value == "7" ) {
 				 str_loc_nm="Yard";
 			 }
             var HeadTitle=str_loc_nm+"|Total|"+head_cntr_tpsz_cd;
             var HeadTitle2=str_loc_nm+"|MVMT|Total|"+head_cntr_tpsz_cd;
             var HeadTitle3=str_loc_nm+"|Term|Total|"+head_cntr_tpsz_cd;
             //sheetObj.Redraw = false;
             sheetObj.RemoveAll();
             sheetObj = sheetObj.Reset();
             
             if(sheetObj.id == "t1sheet1") {
				sheetObjects[0] = sheetObj;
			}
			if(sheetObj.id == "t2sheet1") {
				sheetObjects[1] = sheetObj;
			}
             
             initSheet(sheetObjects[1], 2, HeadTitle);
             initSheet(sheetObjects[2], 3, HeadTitle3);
             initSheet(sheetObjects[0], 1, HeadTitle2);
             //sheetObj.Redraw = true;                    
             //Lease Term
             var sLeaseTermNm=ComGetEtcData(sXml,"lease_term_nm");
             var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
             var arrLeaseTermNm=sLeaseTermNm.split("|");
             var arrLeaseTermCd=sLeaseTermCd.split("|");
             tot_lstm_cd=arrLeaseTermCd;
             with (lstm_cd) {
            	 SetMultiSelect(1);
                 SetMultiSeparator(",");
                 SetDropHeight(320);
            	 InsertItem(0 , 'ALL','');
            	 for ( var i=1; i<=arrLeaseTermCd.length; i++) {
    	        	 InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
            	 }
             }                     
             break;
         case IBSEARCH02:   
         	if(!validateForm(sheetObj,formObj,sAction)) return;
         	//sheetObj.RemoveAll();
         	setHeaderValue(sheetObj,1);	//setting title header         	
          //sheetObj.Redraw = false;            
        	sheetObj.SetWaitImageVisible(0);
        	ComOpenWait(true);         	
            formObj.view_flg.value="MVMT";
            formObj.f_cmd.value=SEARCH02;
            
            if(document.form.loc_type_code.value == "1") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
        	} else  if(document.form.loc_type_code.value == "2") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "Country");
        		sheetObjects[1].SetCellText(0, "loc_cd", "Country");
        		sheetObjects[2].SetCellText(0, "loc_cd", "Country");
        	} else  if(document.form.loc_type_code.value == "3") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "LCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "LCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "LCC");
        	} else  if(document.form.loc_type_code.value == "4") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "ECC");
        	} else  if(document.form.loc_type_code.value == "5") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "SCC");
        	} else  if(document.form.loc_type_code.value == "6") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "SCC");
        	} else  if(document.form.loc_type_code.value == "7") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "Yard");
        		sheetObjects[1].SetCellText(0, "loc_cd", "Yard");
        		sheetObjects[2].SetCellText(0, "loc_cd", "Yard");
        	} else  if(document.form.loc_type_code.value == "8") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "ECC");
        	} 
            
            sheetObj.DoSearch("EES_CIM_0008GS.do",FormQueryString(formObj) );
            //ComOpenWait(false);
            break;
         case IBSEARCH03:      
         	if(!validateForm(sheetObj,formObj,sAction)) return;
         	setHeaderValue(sheetObj,3);	//setting title header
         	//sheetObj.Redraw = false;
        	sheetObj.SetWaitImageVisible(0);
        	ComOpenWait(true);         	
            formObj.view_flg.value="LEASE";
            formObj.f_cmd.value=SEARCH03;
            
            if(document.form.loc_type_code.value == "1") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
        	} else  if(document.form.loc_type_code.value == "2") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "Country");
        		sheetObjects[1].SetCellText(0, "loc_cd", "Country");
        		sheetObjects[2].SetCellText(0, "loc_cd", "Country");
        	} else  if(document.form.loc_type_code.value == "3") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "LCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "LCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "LCC");
        	} else  if(document.form.loc_type_code.value == "4") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "ECC");
        	} else  if(document.form.loc_type_code.value == "5") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "SCC");
        	} else  if(document.form.loc_type_code.value == "6") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "SCC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "SCC");
        	} else  if(document.form.loc_type_code.value == "7") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "Yard");
        		sheetObjects[1].SetCellText(0, "loc_cd", "Yard");
        		sheetObjects[2].SetCellText(0, "loc_cd", "Yard");
        	} else  if(document.form.loc_type_code.value == "8") {
    			sheetObjects[0].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[1].SetCellText(0, "loc_cd", "ECC");
        		sheetObjects[2].SetCellText(0, "loc_cd", "ECC");
        	} 
            
            sheetObj.DoSearch("EES_CIM_0008GS.do",FormQueryString(formObj) );
            //ComOpenWait(false);
            break;
		case IBSEARCH04: //location focusOut
			var inquiryLevel="";
			if ( formObj.loc_type_code.value == 1 ) {
				inquiryLevel="R";
			} else if ( formObj.loc_type_code.value == 2 ) {
				inquiryLevel="C";
			} else if  ( formObj.loc_type_code.value == 3 ) {
				inquiryLevel="R";
			} else if  ( formObj.loc_type_code.value == 4 ) {
				inquiryLevel="L";
			} else if  ( formObj.loc_type_code.value == 5 ) {
				inquiryLevel="L";
			} else if  ( formObj.loc_type_code.value == 6 ) {
				inquiryLevel="E";
			} else if  ( formObj.loc_type_code.value == 7 ) {
				inquiryLevel="S";
			}
			formObj.inquiryLevel.value=inquiryLevel;
			formObj.location.value=formObj.loc_cd.value;
			formObj.f_cmd.value=SEARCH04;
			if (formObj.loc_cd.value == "") {
				return false;
			}
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do",FormQueryString(formObj));
			var sCheck=ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				if (document.form.loc_cd.value != "") {
					ComShowCodeMessage("CIM29013");
					document.form.loc_cd.value="";
					ComSetFocus(document.form.loc_cd);
					return false;
				} else {
					return true;
				}
			} else {
				ComSetFocus(lstm_cd);
			}
			break;        
          case IBDOWNEXCEL:    
//        	  sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
        	  sheetObj.Down2Excel({ SheetDesign:1, HiddenColumn:1,  DownTreeHide : true });
             break;
       }
    }
    /**
     * setting title header
     */    
    function setHeaderValue(sheetObj,cnt) {
    	var str_loc_nm="";
		if ( document.form.loc_type_code.value == "1" ) {
			str_loc_nm="RCC";
		} else if ( document.form.loc_type_code.value == "2" ) {
			str_loc_nm="Country";
		} else if ( document.form.loc_type_code.value == "3" ) {
			str_loc_nm="LCC";
		} else if ( document.form.loc_type_code.value == "4" ) {
			str_loc_nm="ECC";
		} else if ( document.form.loc_type_code.value == "5" ) {
			str_loc_nm="SCC";
		} else if ( document.form.loc_type_code.value == "6" ) {
			str_loc_nm="SCC";
		} else if ( document.form.loc_type_code.value == "7" ) {
			str_loc_nm="Yard";
		}
        var HeadTitle=str_loc_nm+"|Total|"+head_cntr_tpsz_cd;
        var HeadTitle2=str_loc_nm+"|MVMT|Total|"+head_cntr_tpsz_cd;
        var HeadTitle3=str_loc_nm+"|Term|Total|"+head_cntr_tpsz_cd;
//        if ( cnt ==2 ) {
//            initSheet(sheetObj,cnt,HeadTitle);
//        } else if ( cnt ==1 ) {
//            initSheet(sheetObj,cnt,HeadTitle2);
//        } else if ( cnt ==3 ) {
//            initSheet(sheetObj,cnt,HeadTitle3);
//        }
    }
     /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setTabObject(tab_obj){
    	tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
               with (tabObj) {
                   var cnt=0 ;
					InsertItem( "By MVMT" , "");
					InsertItem( "By Location" , "");
					InsertItem( "By Lease Term" , "");
               }
            break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
    * event when clicking Tab
    * activating selected tab
    */
    function tab1_OnChange(tabObj , nItem)
    {
       var objs=document.all.item("tabLayer");
       objs[nItem].style.display="Inline";
       for(var i = 0; i<objs.length; i++){
	       if(i != nItem){
	        objs[i].style.display="none";
	        objs[i].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       }
	      }
       resizeSheet();
       beforetab=nItem;
    }
    /**
     * setting parameters for print
     */
    function setPrintParmValues() {
	   	document.form.prt_loc_type_code.value=document.getElementById("loc_type_code").options[document.getElementById("loc_type_code").selectedIndex].text;
	   	document.form.prt_loc_cd.value=document.form.loc_cd.value;
	   	document.form.prt_cntr_tpsz_cd.value=comboObjects[1].GetSelectCode();
	   	document.form.cntr_tpsz_cd.value=comboObjects[1].GetSelectCode();
	   	document.form.prt_full_flg.value=document.form.full_flg.value;
	   	if ( document.form.cntr_hngr_rck_cd.checked ) {
		   	document.form.prt_cntr_hngr_rck_cd.value="Y"; 
	   	} else {
		   	document.form.prt_cntr_hngr_rck_cd.value=""; 
	   	}
	   	if ( document.form.disp_flg.checked ) {
		   	document.form.prt_disp_flg.value="Y"; 
	   	} else {
		   	document.form.prt_disp_flg.value=""; 
	   	}
	   	if ( document.form.d2_payld_flg.checked ) {
		   	document.form.prt_d2_payld_flg.value="Y"; 
	   	} else {
		   	document.form.prt_d2_payld_flg.value=""; 
	   	}
	   	document.form.prt_cnmv_sts_cd.value=comboObjects[2].GetSelectCode();
	   	document.form.cnmv_sts_cd.value=comboObjects[2].GetSelectCode();
	   	document.form.prt_dmg_flg.value=document.form.dmg_flg.value; 
	   	document.form.prt_cntr_no.value=document.form.cntr_no.value; 
	   	//document.form.prt_cntr_use_co_cd.value = document.form.tem_cntr_use_co_cd.value; 
	   	document.form.prt_lstm_cd.value=comboObjects[0].GetSelectCode();
	   	document.form.prt_soc_cd.value=document.form.soc_cd.value;
    }
    /**
     * end of retrieving Tab 2
     * calling event after retrieving Tab 2
     */
    function t2sheet1_OnSearchEnd(sheetObj, msg){
    	ComOpenWait(false);
     	for(var i=1; i<=sheetObj.LastRow(); i++){
     		if(sheetObj.GetCellValue(i,0).toUpperCase() == 'TOTAL'){
     			sheetObj.SetRowBackColor(i,"#C0C0C0");
     		}
     	}
     	if ( sheetObj.RowCount()!= 0 ) {
 	    	HeadTitleCnt=head_cntr_tpsz_cd.split("|").length+2
 		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
 		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-2, j),0);
 			}
 	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
 	    	//sheetObj.RowDelete(sheetObj.LastRow()-1, false);
     	}
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
     	//sheetObj.Redraw = true;
//     	t2sheet1.SetSumText(0,"TOTAL")
     	setPrintParmValues();	//setting parameters for print
     }    
    /**
     * end of retrieving Tab2
     * calling event after retrieving Tab2 
     */
    function t1sheet1_OnSearchEnd(sheetObj, msg){
    	ComOpenWait(false);
      	if ( sheetObj.RowCount()!= 0 ) {
	     	for(var i=1; i<=sheetObj.LastRow(); i++){
	     		if( sheetObj.GetCellValue(i,0) == '' ){
	     			sheetObj.SetCellValue(i,0,'Total');
	     		} else if (  sheetObj.GetCellValue(i,0) != '' && sheetObj.GetCellValue(i,1) == '' ){
	     			sheetObj.SetCellValue(i,1,'Total');
	     			sheetObj.SetRowBackColor(i,"#C9D5EB");
	     		} 
	     	}
		   	HeadTitleCnt=head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-2, j),0);
			}
	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
	     	sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
	     	sheetObj.SetCellValue(sheetObj.LastRow()-1,0,'G.Total');
	     	sheetObj.SetCellValue(sheetObj.LastRow()-1,1,'G.Total');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),0,'');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),1,'G.Total');
	    	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
	     	setPrintParmValues();	//setting parameters for print
     	}
    	//sheetObj.Redraw = true;
     }
    /**
     * end of retrieving Tab1 
     * calling event after retrieving Tab1
     */
	function t3sheet1_OnSearchEnd(sheetObj, msg){
		ComOpenWait(false);
		if ( sheetObj.RowCount()!= 0 ) {
		 	for(var i=1; i<=sheetObj.LastRow(); i++){
		 		if( sheetObj.GetCellValue(i,0) == '' ){
		 			sheetObj.SetCellValue(i,0,'Total');
		 		} else if (  sheetObj.GetCellValue(i,0) != '' && sheetObj.GetCellValue(i,1) == '' ){
		 			sheetObj.SetCellValue(i,1,'Total');
		 			sheetObj.SetRowBackColor(i,"#C9D5EB");
		 		} 
		 	}
		   	HeadTitleCnt=head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-2, j),0);
			}
			sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
		 	sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
		 	sheetObj.SetCellValue(sheetObj.LastRow()-1,0,'G.Total');
		 	sheetObj.SetCellValue(sheetObj.LastRow()-1,1,'G.Total');
			sheetObj.SetCellValue(sheetObj.LastRow(),0,'');
			sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
			sheetObj.SetCellValue(sheetObj.LastRow(),1,'G.Total');
			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
			//no support[implemented common]CLT 			sheetObj.SelectHighLight=false;
		 	setPrintParmValues();	//setting parameters for print
		}
		//sheetObj.Redraw = true;
     }
    /**
    * event when clicking Tab
    * retrieving data in selected tab
    */
    function tab1_OnClick(tabObj , nItem)
    {
       if ( nItem == 0 ) {
		   doActionIBSheet(t1sheet1,document.form,IBSEARCH02);
       } else if ( nItem == 1 ) {	//when clicking By MVMT tab
		   doActionIBSheet(t2sheet1,document.form,IBSEARCH);
       } else if ( nItem == 2 ) {	//when clicking By Lease Term 
		   doActionIBSheet(t3sheet1,document.form,IBSEARCH03); 
       }
    }
    /**
    * validating input value
    */
    function validateForm(sheetObj,formObj,sAction){
	   	with(formObj){
		  	var formObject=document.form;
		  	if ( doActionIBSheet(sheetObj, document.form, IBSEARCH04) ) {	//Location 유효성체크
		  		ComSetFocus(formObject.loc_cd);
	 	        return false;
	 	    } else {
	 	    	if(formObj.loc_type_code.value != "1" && formObj.loc_type_code.value != "2" && formObj.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	return true;
	 	    }
		}
		return true;       
    }
    /**
     * calling event when clicking cell
     * setting background color in selected row
     */
    function t1sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	
     /**
      * calling event when clicking cell
      * setting background color in selected row
      */
    function t2sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	
    /**
     * calling event when clicking cell
     * setting background color in selected row
     */
    function t3sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	    
    /*
    function combo_cntr_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	form.combo_cntr_tpsz_cd_text.value = newCode;
   }
   
   function combo_cntr_tpsz_cd_OnBlur(comboObj) {
	   form.combo_cntr_tpsz_cd_text.value = comboObj.GetSelectCode();
   }
    */
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
