/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0034.js
*@FileTitle  : EQ Availability
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
	/**
     * @extends 
     * @class ees_cim_0034 :  define business script for ees_cim_0034
     */
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
    var tot_cntr_tpsz_cd="";
    var headCount=0;
    // Event handler processing by button click event */
	document.onclick=processButtonClick;
	var IBSEARCH01=29;	 
	var IBSEARCH02=30;	 
	var Mincount1=0 ;
	var Mincount2=0 ; 
	var HeadTitle1="";
	// Event handler processing by button name */
	function processButtonClick(){
    	var shtCnt=0;
    	var sheetObject=sheetObjects[shtCnt++];
    	/*******************************************************/
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
 				switch(srcName) {
					case "btn_Retrieve":
						/*sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();*/
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_new":		// initializing retrive opiton
						formObject.reset();
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						comboObjects[1].SetSelectCode('');
						ComSetFocus(document.form.loc_cd);
						comboObjects[1].SetSelectCode("D2,D4,D5,D7");
						
						sheetObjects[0].SetCellText(0, "scc_cd", "SCC");
			    		sheetObjects[0].SetCellText(1, "scc_cd", "SCC");
			    		
			    		sheetObjects[1].SetCellText(0, "yd_cd", "YARD");
			    		sheetObjects[1].SetCellText(1, "yd_cd", "YARD");
			    		
			    		for(i=0;i<sheetObjects.length;i++){
			        		ComConfigSheet (sheetObjects[i] );
			        		initSheet(sheetObjects[i],i+1);
			        		ComEndConfigSheet(sheetObjects[i]);
			        	}
			    		
			    		setHeaderValue(sheetObjects[0]);
						break;
					case "btn_loc_cd":	// popup for retrieving location
		    	        var cnt_cd="";
		    	        var loc_cd="";
			            cnt_cd=formObject.loc_type_code.value;
			            loc_cd=formObject.loc_cd.value;
			            if ( formObject.loc_type_code.value != '' ) {	
							if ( formObject.loc_type_code.value == 'S' ) {	//SCC
								var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
								ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
							}else if ( formObject.loc_type_code.value == 'E' ) {	//ECC
									var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
									ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
							}else if ( formObject.loc_type_code.value == 'L' ) {	//ECC
								var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
								ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
							}else if ( formObject.loc_type_code.value == 'R' ) {	//ECC
								var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
								ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 470, "rcc_cd:loc_cd", "0,1,1,1,1,1", true);
			           		} else {	//YARD
								var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
								ComOpenPopup("/opuscntr/COM_ENS_061.do",780, 476, "popupFinish", "1,0", true);
			           		}
			            }
						break;
	                case "btn_minimize1":	//minimizing sheet 1
	                    Mincount1=(Mincount1+1)%2 ;
	                    MinimizeSheet1(Mincount1);
	                    break;
	                case "btn_minimize2":	//minimizing sheet 2
	                    Mincount2=(Mincount2+1)%2 ;
	                    MinimizeSheet2(Mincount2);
	                    break;
	                case "past_Br":		//calling popup Past BR Information
	                	if(sheetObjects[0].RowCount()> 0){
	                		var loc_cd=sheetObjects[0].GetCellValue(2, "scc_cd");
		                	var cntr_tpsz_cd_val1=document.form.param_cntr_tpsz_cd_val1.value;
		                	var cntr_tpsz_cd_val2=document.form.param_cntr_tpsz_cd_val2.value;
		                	var cntr_tpsz_cd_val3=document.form.param_cntr_tpsz_cd_val3.value;
		                	var cntr_tpsz_cd_val4=document.form.param_cntr_tpsz_cd_val4.value;
							var param="?loc_cd="			  +loc_cd
										+"&cntr_tpsz_cd_val1="+cntr_tpsz_cd_val1
										+"&cntr_tpsz_cd_val2="+cntr_tpsz_cd_val2
										+"&cntr_tpsz_cd_val3="+cntr_tpsz_cd_val3
										+"&cntr_tpsz_cd_val4="+cntr_tpsz_cd_val4
										;
							ComOpenPopup("/opuscntr/EES_CIM_0052.do"+param,900, 615, "", "1,0", true);
	                	}
	                    break;
	 		        case "btn_downexcel":	//downloading excel
	 		        	if(sheetObjects[0].RowCount()> 0){
	 		        		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	 		        	}
	 		        	else {
	 		        		ComShowCodeMessage("COM132501");
	 		        	}
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
     * Event when clicking Tab
     * activating selected tab items
     */
    function MinimizeSheet1(nItem)
    {
        var objs=document.all.item("showMin");
        var showsheet1=document.all.item("showsheet1");
        var showsheet2=document.all.item("showsheet2");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[0].SetSheetHeight(410);
    	    showsheet1.style.display="block";
    	    showsheet2.style.display="none";
    	    $('#btn_minimize1').removeClass('btn_up').addClass('btn_down');
    	}
    	else
    	{
    	    objs.style.display="block";
    	    sheetObjects[0].SetSheetHeight(292);
    	    showsheet1.style.display="block";
    	    showsheet2.style.display="block";
    	    $('#btn_minimize1').removeClass('btn_down').addClass('btn_up');
    	}
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function MinimizeSheet2(nItem)
    {
        var objs=document.all.item("showMin");
        var showsheet1=document.all.item("showsheet1");
        var showsheet2=document.all.item("showsheet2");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[1].SetSheetHeight(410);
    	    showsheet1.style.display="none";
    	    showsheet2.style.display="block";
    	    $('#btn_minimize2').removeClass('btn_up').addClass('btn_down');
    	}
    	else
    	{
    	    objs.style.display="block";
    	    sheetObjects[1].SetSheetHeight(292);
    	    showsheet1.style.display="block";
    	    showsheet2.style.display="block";
    	    $('#btn_minimize2').removeClass('btn_down').addClass('btn_up');
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	for(k=0;k<tabObjects.length;k++){
    		initTab(tabObjects[k],k+1);
    	}
    	for(p=0;p< comboObjects.length;p++){
    		initCombo (comboObjects[p],p+1);
    	}
    	
    	with (rstr_usg_lbl) {
		 	SetDropHeight(150);
		}   		 
		         
		 comboObjects[0].RemoveAll();
	        
		 comboObjects[0].SetItemCheck(0,1);
		 comboObjects[0].SetEnable(1);
		 
		
    	initControl();
    	load_Finish(sheetObjects[0]);
    	setHeaderValue(sheetObjects[0]);
    }
    
    
    /**
     * handling process after ending sheet1 retrieve
     */
     function load_Finish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //Period,HEAD,TPSZ �곗씠��媛�졇�ㅺ린
    	ComSetFocus(document.form.loc_cd);
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
	* initializing Tab
	* setting Tab items
	*/
    function initCombo (comboObj, comboNo) {
    	with (comboObj) {
		}
    }
    
    
    /**
     * registering initial event 
     */
	function initControl() {
		axon_event.addListener('change', 'cntr_tpsz_cd_change', 'cntr_tpsz_cd');			//handling event in case of changing TP/SZ
		axon_event.addListener('change', 'ru_lable_type_OnChange', 'ru_lable_type', '');
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');	//handling event Location
	}
	
	
	/**
     * registering TP/SZ clicking event
     */
	function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				formObj.cntr_tpsz_cd_val1.value = "";
				formObj.cntr_tpsz_cd_val2.value = "";
				formObj.cntr_tpsz_cd_val3.value = "";
				formObj.cntr_tpsz_cd_val4.value = "";
    		}
    	} else {
    		var checkedCnt = 0;
    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    			var bChk=comboObj.GetItemCheck(i);
    			if (bChk) {
    				checkedCnt = checkedCnt + 1;
    				
        			if (checkedCnt > 4) {
        				comboObj.SetItemCheck(i,0);
        			} else {
        				comboObj.SetItemCheck(0,0);
        				cntr_tpsz_cd_change();
        			}
    			}
    		}
    	}
    }
	
	
    /**
     * handling event in case of changing loc_type_code
     */   
    function loc_type_code_onchange() {
        var formObject=document.form;
		if  ( formObject.loc_type_code.value == 'Y' ) {
			document.getElementById("loc_cd").setAttribute("maxLength",7);
		} else {
			document.getElementById("loc_cd").setAttribute("maxLength",5);
		}
		
        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);		
    }   
    
    
	/**
	 * handling eventLocation  blur
	 * validating Location code
	 */	
	function obj_blur() {
		switch (ComGetEvent("name")) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
				}
				break;
			case "cntr_tpsz_cd_val1":
				if ( document.form.cntr_tpsz_cd_val1.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val1);
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val1);
					ComSetFocus(document.form.cntr_tpsz_cd_val1);
					document.form.cntr_tpsz_cd_val1.select();
					return false;
				}
				comboObjects[1].SetSelectCode(document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value);
				break;
			case "cntr_tpsz_cd_val2":
				if ( document.form.cntr_tpsz_cd_val2.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val2);
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val2);
					ComSetFocus(document.form.cntr_tpsz_cd_val2);
					document.form.cntr_tpsz_cd_val2.select();
					return false;
				}
				comboObjects[1].SetSelectCode(document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value);
				break;
			case "cntr_tpsz_cd_val3":
				if ( document.form.cntr_tpsz_cd_val3.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val3);
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val3);
					ComSetFocus(document.form.cntr_tpsz_cd_val3);
					document.form.cntr_tpsz_cd_val3.select();
					return false;
				}
				comboObjects[1].SetSelectCode(document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value);
				break;
			case "cntr_tpsz_cd_val4":
				if ( document.form.cntr_tpsz_cd_val4.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val4);
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val4);
					ComSetFocus(document.form.cntr_tpsz_cd_val14);
					document.form.cntr_tpsz_cd_val4.select();
					return false;
				}
				comboObjects[1].SetSelectCode(document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value);
				break;
		}
	}
   
    /**
    * handling Period FM  beforeactivate event
    */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	
    /**
    * handling event in case of changing TP/SZ
    */   
    function cntr_tpsz_cd_change() {
    	var cntr_tpsz_cd=comboObjects[1].GetSelectCode();
    	var arrTpszs=cntr_tpsz_cd.split(",");
    	for ( var i=0; i<4; i++ ) {
    		if ( i<arrTpszs.length ) {
    			eval("document.form.cntr_tpsz_cd_val"+(i+1)).value=arrTpszs[i];
    		} else {
    			eval("document.form.cntr_tpsz_cd_val"+(i+1)).value="";
    		}
    	}
    }   	
    
    
    /**
     * handling LOC_CD keyup event
     */
     function loc_cd_onkeyUp() {
        var formObject=document.form;
        if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	        formObject.loc_cd.value=formObject.loc_cd.value.toUpperCase();
	        if ( formObject.loc_type_code.value == 'R' || formObject.loc_type_code.value == 'E' || formObject.loc_type_code.value == 'L' || formObject.loc_type_code.value == 'S') {
	        	document.getElementById("loc_cd").setAttribute("maxlength",5);
	 		   	formObject.loc_cd.value=formObject.loc_cd.value.substring(0,5).toUpperCase();
	 		   	if ( formObject.loc_cd.value.length == 5 ) {
	 		   		ComSetFocus(document.form.cntr_tpsz_cd);
	 		   	}
	        } else {
	        	document.getElementById("loc_cd").setAttribute("maxlength",7);
	 		   	if ( formObject.loc_cd.value.length == 7 ) {
	 		   		ComSetFocus(document.form.cntr_tpsz_cd);
	 		   	}
	        }
        }        
     }
     
     
    /**
     * handling LOC_CD keyup event
     */
    function cntr_tpsz_cd_onkeyUp() {
       var formObject=document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       formObject.cntr_tpsz_cd_val1.value=formObject.cntr_tpsz_cd_val1.value.toUpperCase();
	       formObject.cntr_tpsz_cd_val2.value=formObject.cntr_tpsz_cd_val2.value.toUpperCase();
	       formObject.cntr_tpsz_cd_val3.value=formObject.cntr_tpsz_cd_val3.value.toUpperCase();
	       formObject.cntr_tpsz_cd_val4.value=formObject.cntr_tpsz_cd_val4.value.toUpperCase();
       }
    }
    
    
    /**
     * validating TP/SZ
     */
   function chkTpSz(tpsz) {
	   var chkFlag=false; 
	   var arrTpsz=tot_cntr_tpsz_cd.split("|");
	   for ( var i=0; i<arrTpsz.length; i++ ) {
		   if ( arrTpsz[i] == tpsz.value  ) {
			   chkFlag=true;
			   break;
		   }
	   }	   
	   if ( !chkFlag ) {
		   ComShowCodeMessage("CIM30013", "TP/SZ");    //not available tp/sz
		   ComClearObject(tpsz);
		   ComSetFocus(tpsz);
		   tpsz.select();
	   }
	   return;
   }
   
   
    /**
     * handling TP/SZ1 keyup event
     */
    function cntr_tpsz_cd1_onkeyUp() {
       var formObject=document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val1.value.length ==2 ) {
	           ComSetFocus(formObject.cntr_tpsz_cd_val2); 
	       }
       }
    }
    
    
    /**
     * handling TP/SZ2 keyup event
     */
    function cntr_tpsz_cd2_onkeyUp() {
       var formObject=document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val2.value.length ==2 ) {
	           ComSetFocus(formObject.cntr_tpsz_cd_val3); 
	       }
       }
    }
    
    
    /**
     * handling TP/SZ3 keyup event
     */
    function cntr_tpsz_cd3_onkeyUp() {
       var formObject=document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val3.value.length ==2 ) {
	           ComSetFocus(formObject.cntr_tpsz_cd_val4); 
	       }
       }
    }    
    
    
    /**
     * handling TP/SZ3 keyup event
     */
    function cntr_tpsz_cd4_onkeyUp() {
       var formObject=document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val4.value.length ==2 ) {
	           ComSetFocus(formObject.fm_fcast_dt); 
	       }
       }
    }  
    
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo,colCnt,HeadTitle1,HeadTitle2) {
		var cnt=0;
        var shtID=sheetObj.id;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	            	if (HeadTitle1==null || HeadTitle1 =="") {
		            	HeadTitle1="|SCC|DATE|D2|D2|D2|D2|D2|D2|D2|D2|D2|D2|D4|D4|D4|D4|D4|D4|D4|D4|D4|D4|D5|D5|D5|D5|D5|D5|D5|D5|D5|D5|D7|D7|D7|D7|D7|D7|D7|D7|D7|D7";
		            	HeadTitle2="|SCC|DATE|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON";
		            	colCnt=4;
	            	}
	            	headCount = ComCountHeadTitle(HeadTitle1);
	            	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0 ,ToolTip:true  } );
	            	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"},
	            	                { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_level",  KeyField:0,   CalcLogic:"",   Format:"" },
	            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
	            	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"fcast_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd" } ];	            	                   
                    for(var i=1 ; i <= 4 ; i++){
	                    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ea"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"br"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pup"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ro"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ofh"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"sn"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ig"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rtn"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ri"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"onh"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" });
                    }
                    InitColumns(cols);
                    SetEditable(0);
                    sheetObjects[0].RenderSheet(0);
            		sheetObjects[1].RenderSheet(0);
                    for ( var i=2; i<headCount; i++ ) {
                    	if ( headCount < i+11 ) {
                    		sheetObjects[0].SetColHidden(i,1);
                    		sheetObjects[1].SetColHidden(i,1);
                    	} else {
                    		sheetObjects[0].SetColHidden(i,0);
                    		sheetObjects[1].SetColHidden(i,0);
                    	}
                    }
                    sheetObjects[0].RenderSheet(1);
            		sheetObjects[1].RenderSheet(1);
                    ShowToolTip(1);
                    SetCountPosition(0); 
                    SetSheetHeight(300);
                }
                break;
            case 2:      //sheet2 init
                with (sheetObj) {
	            	if (HeadTitle1==null || HeadTitle1 =="") {
		            	HeadTitle1="|Yard|DATE|D2|D2|D2|D2|D2|D2|D2|D2|D2|D2|D4|D4|D4|D4|D4|D4|D4|D4|D4|D4|D5|D5|D5|D5|D5|D5|D5|D5|D5|D5|D7|D7|D7|D7|D7|D7|D7|D7|D7|D7";
		            	HeadTitle2="|Yard|DATE|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON";
		            	colCnt=4;
	            	}
	            	headCount=ComCountHeadTitle(HeadTitle1);
	            	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20, DataRowMerge:0 } );
	            	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"},
	            	                { Text:HeadTitle2, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_level",  KeyField:0,   CalcLogic:"",   Format:"" },
	            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	            	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"fcast_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd" } ];
                    for(var i=1 ; i <= colCnt ; i++){
	                    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ea"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"br"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pup"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ro"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ofh"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"sn"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ig"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rtn"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ri"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"onh"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" });
                    }
                    InitColumns(cols);
                    SetEditable(0);
            		sheetObjects[0].RenderSheet(0);
            		sheetObjects[1].RenderSheet(0);
                    for ( var i=2; i<headCount; i++ ) {
                    	if ( headCount < i+11 ) {
                    		sheetObjects[0].SetColHidden(i,1);
                    		sheetObjects[1].SetColHidden(i,1);
                    	} else {
                    		sheetObjects[0].SetColHidden(i,0);
                    		sheetObjects[1].SetColHidden(i,0);
                    	}
                    }
            		sheetObjects[0].RenderSheet(1);
            		sheetObjects[1].RenderSheet(1);
                    SetCountPosition(0); 
                    SetSheetHeight(300);
                }
                break;
                
            case 3:      //sheet2 init
                with (sheetObj) {
	            	var HeadTitle3="|SCC|DATE|Size Type|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON";
		            var colCnt3=1;
	            	var headCount3=ComCountHeadTitle(HeadTitle3);
	            	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:0, Page:20, DataRowMerge:0 } );
	            	var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	var headers = [ { Text:HeadTitle3, Align:"Center"}];
	            	InitHeaders(headers, info);
	            	var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_level",  KeyField:0,   CalcLogic:"",   Format:"" },
	            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	            	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"fcast_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd" },
	            	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"tp_cd",   KeyField:0,   CalcLogic:"",   Format:"" } ];
                    for(var i=1 ; i <= colCnt3 ; i++){
	                    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ea"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"br"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pup"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ro"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ofh"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"sn"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ig"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rtn"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ri"+i,  KeyField:0,   CalcLogic:"",   Format:"Integer" },
					             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"onh"+i, KeyField:0,   CalcLogic:"",   Format:"Integer" });
                    }
                    InitColumns(cols);
                    SetEditable(0);
                    SetCountPosition(0); 
                    SetSheetHeight(300);
                    SetVisible(0);
                }
                break;
                
            
         }
     }
	
	
	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;  
		switch(sAction) {
			case IBSEARCH:      //retrive				
				if(!validateForm(sheetObj,formObj,sAction)) return;	
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(1);
				
    			formObj.f_cmd.value=SEARCH;
    			//sheetObjects[0].RenderSheet(0);
    			//sheetObjects[1].RenderSheet(0);
				setHeaderValue(sheetObj);	
            	//ComEndConfigSheet(sheetObjects[0]);	
            	//ComEndConfigSheet(sheetObjects[1]);
            	
            	if(document.form.loc_type_code.value == "R") {
        			sheetObjects[0].SetCellText(0, "scc_cd", "RCC");
        			sheetObjects[0].SetCellText(1, "scc_cd", "RCC");
            		
            		sheetObjects[1].SetCellText(0, "yd_cd", "LCC");
            		sheetObjects[1].SetCellText(1, "yd_cd", "LCC");
            		
            	} else if(document.form.loc_type_code.value == "L") {
            		sheetObjects[0].SetCellText(0, "scc_cd", "LCC");
            		sheetObjects[0].SetCellText(1, "scc_cd", "LCC");
            		
            		sheetObjects[1].SetCellText(0, "yd_cd", "ECC");
            		sheetObjects[1].SetCellText(1, "yd_cd", "ECC");
            		
            	} else if(document.form.loc_type_code.value == "E") {
            		sheetObjects[0].SetCellText(0, "scc_cd", "ECC");
            		sheetObjects[0].SetCellText(1, "scc_cd", "ECC");
            		
            		sheetObjects[1].SetCellText(0, "yd_cd", "SCC");
            		sheetObjects[1].SetCellText(1, "yd_cd", "SCC");
            	
            	} else if(document.form.loc_type_code.value == "S") {
            		sheetObjects[0].SetCellText(0, "scc_cd", "SCC");
            		sheetObjects[0].SetCellText(1, "scc_cd", "SCC");
            		
            		sheetObjects[1].SetCellText(0, "yd_cd", "Yard");
            		sheetObjects[1].SetCellText(1, "yd_cd", "Yard");
            	} else if(document.form.loc_type_code.value == "Y") {
            		sheetObjects[0].SetCellText(0, "scc_cd", "Yard");
            		sheetObjects[0].SetCellText(1, "scc_cd", "Yard");
            		
            		sheetObjects[1].SetCellText(0, "yd_cd", "Yard");
            		sheetObjects[1].SetCellText(1, "yd_cd", "Yard");
            	}
            	
            	var param = "";
            	param ="&s_type=01";
            	var sXml=sheetObj.GetSearchData("EES_CIM_0034GS.do" , FormQueryString(formObj)+param); 
            	sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
            	
            	param ="&s_type=02";
            	var sXml=sheetObj.GetSearchData("EES_CIM_0034GS.do" , FormQueryString(formObj)+param); 
            	sheetObjects[1].LoadSearchData(sXml,{Sync:0} );            	
            	
            	formObj.f_cmd.value=SEARCH03;
            	var sXml=sheetObj.GetSearchData("EES_CIM_0034GS.do" , FormQueryString(formObj)+param); 
            	sheetObjects[2].LoadSearchData(sXml,{Sync:0} );   
                break;
    		case IBSEARCH01:     
    			sheetObj.SetWaitImageVisible(0);
    			form.f_cmd.value=SEARCH01;
     			var sXml=sheetObj.GetSearchData("EES_CIM_0034GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	 
    			tot_cntr_tpsz_cd=cntr_tpsz_cd;
    			var strCntrTpszCd=cntr_tpsz_cd.split("|");
    			// initializing multi combo
    			comboObjects[1].SetMultiSelect(1);
    			comboObjects[1].SetMultiSeparator(",");
    			//comboObjects[1].SetMaxSelect(4);
    			comboObjects[1].SetMaxSelect(5);
    			comboObjects[1].SetDropHeight(360);
    			comboObjects[1].InsertItem(0 , 'Uncheck','');
				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
					comboObjects[1].InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
				}    				
    	        comboObjects[1].SetSelectCode("D2,D4,D5,D7");
    			break;
			case IBSEARCH02: //location focusOut
				var flag=false;
				var inquiryLevel="";
				if ( formObj.loc_type_code.value == "S" ) {
					inquiryLevel="S";
				} else if ( formObj.loc_type_code.value == "E" ) {
					inquiryLevel="E";
				} else if ( formObj.loc_type_code.value == "R" ) {
					inquiryLevel="R";
				} else if ( formObj.loc_type_code.value == "L" ) {
					inquiryLevel="L";
				} else if ( formObj.loc_type_code.value == "Y" ) {
					inquiryLevel="Y";
				} 
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					flag=false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_0034GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM29013");
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						document.form.loc_cd.select()
						flag=false;
					} else {
						ComSetFocus(document.form.loc_cd);
						flag=true;
					}
				} else {
					ComSetFocus(document.form.cntr_tpsz_cd_val1);
				}
				return flag;
				break;	    			
			case IBDOWNEXCEL:      // downloading excel
				ComOpenWait(true);
				sheetObjects[2].Down2ExcelBuffer(true);
				
     			sheetObjects[0].Down2Excel({FileName:"Excel", DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1,DownRows:"Visible"  });
     			
	            if(sheetObjects[1].RowCount()> 0){
 	            	sheetObjects[1].Down2Excel({FileName:"Excel", DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1,DownRows:"Visible" });
    	        }
	            
	            if(sheetObjects[2].RowCount()> 0){
 	            	sheetObjects[2].Down2Excel({FileName:"Excel", DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1,DownRows:"Visible" });
    	        }
	            
	            sheetObjects[2].Down2ExcelBuffer(false);
    			break;
		}
	}
	
	function sheet3_OnDownFinish(sheetObj, downloadType, result){
		ComOpenWait(false);
	}
	/**
	 * setting title header
	 */    
	function setHeaderValue(sheetObj) {
		var arrTpsz=new Array(4);
		var headerValue="";
		arrTpsz[0]=document.form.cntr_tpsz_cd_val1.value;
		arrTpsz[1]=document.form.cntr_tpsz_cd_val2.value;
		arrTpsz[2]=document.form.cntr_tpsz_cd_val3.value;
		arrTpsz[3]=document.form.cntr_tpsz_cd_val4.value;
		
		
		
		var strHeader=tot_cntr_tpsz_cd.split("|");
		for ( var i=0; i<strHeader.length; i++ ) {
			for ( var j=0; j<arrTpsz.length; j++) {
				if ( arrTpsz[j] !='' && strHeader[i] == arrTpsz[j] ) {
					headerValue=headerValue+strHeader[i]+"|";
				}
			}
		}
		var strHeader=headerValue.split("|");
		var totHeader1="|SCC|DATE|";
		for ( var i=0; i<strHeader.length; i++ ) {
			if ( strHeader[i] != '' ) {
				for ( var j=0; j<=9; j++ ) {
					totHeader1=totHeader1+strHeader[i]+"|";	
					}
			}
		}
		HeadTitle1=totHeader1.substring(0,(totHeader1.length)-1);
		sheetObjects[0].RenderSheet(0);
		sheetObjects[1].RenderSheet(0);
		
		
		for ( var i=2; i<headCount; i++ ) {
			if(i==3 || i==13 || i==23 || i==33) {
				sheetObjects[0].SetColWidth(i,60);
				sheetObjects[1].SetColWidth(i,60);
			}else{
				sheetObjects[0].SetColWidth(i,40);
				sheetObjects[1].SetColWidth(i,40);
			}
			if ( ComCountHeadTitle(totHeader1) < i+2 ) {
				sheetObjects[0].SetColHidden(i,1);
				sheetObjects[1].SetColHidden(i,1);
			} else {
				sheetObjects[0].SetColHidden(i,0);
				sheetObjects[1].SetColHidden(i,0);
			}
		}
		
		sheetObjects[0].RenderSheet(1);
		sheetObjects[1].RenderSheet(1);
		for ( var i=2; i<ComCountHeadTitle(HeadTitle1); i++ ) {
			sheetObjects[0].SetCellValue(0,i,HeadTitle1.split("|")[i],0);
			sheetObjects[1].SetCellValue(0,i,HeadTitle1.split("|")[i],0);
		}
		
		sheetObjects[0].SetColWidth("scc_cd",60);
		sheetObjects[0].SetColWidth("fcast_dt",75);
		sheetObjects[1].SetColWidth("yd_cd",60);
		sheetObjects[1].SetColWidth("fcast_dt",75);
		sheetObjects[0].SheetWidth=ComCountHeadTitle(totHeader1)*45;
		if ( sheetObjects[0].SheetWidth>975 ) {
			sheetObjects[0].SheetWidth=974;
		}
		sheetObjects[1].SheetWidth=ComCountHeadTitle(totHeader1)*45;
		if ( sheetObjects[1].SheetWidth>975 ) {
			sheetObjects[1].SheetWidth=974;
		}
	}
    /**
     * setting selected value from Location by loc_cd popup
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject=sheetObjects[0];
       var formObject=document.form;
       formObject.loc_cd.value=aryPopupData[0][3];
       ComSetFocus(formObject.cntr_tpsz_cd_val1);        
       if ( formObject.loc_type_code.value == 'Y' ) {
		   document.getElementById("loc_cd").setAttribute("minlength",7);
       } else {
    	   document.getElementById("loc_cd").setAttribute("minlength",5);
       }
    }
    /**
     * chanaging sheet color
     * chanaging color by sheet col
     */
    function sheetSetBackColor(sheetObj){
	sheetObj.SetColBackColor(3,sheetObj.GetCellBackColor(1,3));
	sheetObj.SetColBackColor(13,sheetObj.GetCellBackColor(1,3));
	sheetObj.SetColBackColor(23,sheetObj.GetCellBackColor(1,3));
	sheetObj.SetColBackColor(33,sheetObj.GetCellBackColor(1,3));
    }
    /**
    * end of revrieving Tab1
    * calling event after Tab1 retrieving end
    */
    function sheet1_OnSearchEnd(sheetObj, msg){
    	/*for(var i=0; i<=sheetObj.LastRow(); i++){
    		if(sheetObj.GetCellValue(i,0) == 'YARD'){
    			sheetObj.SetRowHidden(i,1);
    		}
     		sheetObj.SetCellFont("FontBold", i,"ea1",1);
     		sheetObj.SetCellFont("FontBold", i,"ea2",1);
     		sheetObj.SetCellFont("FontBold", i,"ea3",1);
     		sheetObj.SetCellFont("FontBold", i,"ea4",1);
    		if ( i !=0 && i !=1  ) {
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea1"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea1","#FF0000");
       			}
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea2"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea2","#FF0000");
       			}
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea3"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea3","#FF0000");
       			}
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea4"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea4","#FF0000");
       			}
    		}
    	}
    	*/
    	
    	
    	
    	document.form.fm_fcast_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(2,"fcast_dt"),'ymd');
    	document.form.to_fcast_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(sheetObj.LastRow(),"fcast_dt"),'ymd');
    	document.form.param_loc_type_code.value=document.form.loc_type_code.value;
    	document.form.param_loc_cd.value=document.form.loc_cd.value;
    	document.form.param_cntr_tpsz_cd_val1.value=document.form.cntr_tpsz_cd_val1.value;
    	document.form.param_cntr_tpsz_cd_val2.value=document.form.cntr_tpsz_cd_val2.value;
    	document.form.param_cntr_tpsz_cd_val3.value=document.form.cntr_tpsz_cd_val3.value;
    	document.form.param_cntr_tpsz_cd_val4.value=document.form.cntr_tpsz_cd_val4.value;
    	//sheetSetBackColor(sheetObj);     	
    	//sheetObj.RenderSheet(1);
    	ComOpenWait(false);
    	sheetObj.SetWaitImageVisible(0);
    }
    /**
     * event in case of clicking sheet
     * setting color for selected row and col
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }
    /**
     * event in case of clicking cell <br>
     */
    function sheet1_OnMouseDown(Button, Shift, X, Y) {
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	if ( sheetObj.MouseRow()== 1) {
    		sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
    	}
    }
    /**
     * event in case of double clicking  <br>
     * calling BKG information in case of double clicking row
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	if ( Row == 0  ) return;
    	var colSaveName=sheetObj.ColSaveName(Col);
    	if( sheetObj.RowCount()> 0 ){
	    	if ( colSaveName == "ro1" || colSaveName == "ro2" || colSaveName == "ro3" || colSaveName == "ro4" || colSaveName == "ri1" || colSaveName == "ri2" || colSaveName == "ri3" || colSaveName == "ri4") {
		    	var cntr_tpsz_cd=eval("document.form.param_cntr_tpsz_cd_val"+( colSaveName.substring(2,3))).value;
		    	var fcast_dt="";
		    	var io_bnd_cd=colSaveName.substring(1,2).toUpperCase();	//I,O
		    	if ( Row != 1) {
		    		fcast_dt=sheetObj.GetCellValue(Row,"fcast_dt");
		    	}
	        	var loc_type_code=document.form.param_loc_type_code.value;
	        		var loc_cd=sheetObj.GetCellValue(2, "scc_cd");
				var param="loc_type_code="+loc_type_code
							+"&loc_cd="		 +loc_cd
							+"&fcast_dt="	 +fcast_dt
							+"&io_bnd_cd="	 +io_bnd_cd
							;
				ComOpenPopup("/opuscntr/EES_CIM_0039.do?"+param,900, 698, "", "1,0", true);
	    	} else { 
		    	var fcast_dt="";
		    	var loc_cd=sheetObj.GetCellValue(2, "scc_cd");
            	var cntr_tpsz_cd="";
		    	if ( Row != 1) {
		    		fcast_dt=sheetObj.GetCellValue(Row,"fcast_dt");
		    	}
            	if ( colSaveName == "br1" || colSaveName == "pup1" || colSaveName == "ig1" || colSaveName == "rtn1" || colSaveName == "ofh1" || colSaveName == "onh1" ) {
            		cntr_tpsz_cd=document.form.param_cntr_tpsz_cd_val1.value;
            	} else if ( colSaveName == "br2" || colSaveName == "pup2" || colSaveName == "ig2" || colSaveName == "rtn2" || colSaveName == "ofh2" || colSaveName == "onh2" ) {
            		cntr_tpsz_cd=document.form.param_cntr_tpsz_cd_val2.value;
            	} else if ( colSaveName == "br3" || colSaveName == "pup3" || colSaveName == "ig3" || colSaveName == "rtn3" || colSaveName == "ofh3" || colSaveName == "onh3" ) {
            		cntr_tpsz_cd=document.form.param_cntr_tpsz_cd_val3.value;
            	} else if ( colSaveName == "br4" || colSaveName == "pup4" || colSaveName == "ig4" || colSaveName == "rtn4" || colSaveName == "ofh4" || colSaveName == "onh4" ) {
            		cntr_tpsz_cd=document.form.param_cntr_tpsz_cd_val4.value;
            	}
            	var loc_type_code=document.form.loc_type_code.value;
				var param="?loc_cd="		 +loc_cd
							+"&loc_type_code="+loc_type_code
							+"&cntr_tpsz_cd="+cntr_tpsz_cd
							+"&fcast_dt="	 +fcast_dt;
				
	    		if ( colSaveName == "br1" || colSaveName == "br2" || colSaveName == "br3" || colSaveName == "br4" ) {				//BR Detail
//					ComOpenPopup("/opuscntr/EES_CIM_0046.do"+param,900, 570, "", "1,0,1,1,1,1,1,1", true);
	    			ComOpenPopup("/opuscntr/EES_CIM_0046.do"+param,900, 570, "", "none", true);
		    	} else if ( colSaveName == "pup1" || colSaveName == "pup2" || colSaveName == "pup3" || colSaveName == "pup4" ) {	//PUP(Picked Up) Information
					ComOpenPopup("/opuscntr/EES_CIM_0047.do"+param,900, 570, "", "none", true);				
		    	} else if ( colSaveName == "ofh1" || colSaveName == "ofh2" || colSaveName == "ofh3" || colSaveName == "ofh4" ) {	//OFF Detail
					ComOpenPopup("/opuscntr/EES_CIM_0048.do"+param,700, 570, "", "none", true);				
		    	} else if ( colSaveName == "ig1" || colSaveName == "ig2" || colSaveName == "ig3" || colSaveName == "ig4" ) {		//IG Detail
					ComOpenPopup("/opuscntr/EES_CIM_0049.do"+param,900, 570, "", "none", true);				
		    	} else if ( colSaveName == "rtn1" || colSaveName == "rtn2" || colSaveName == "rtn3" || colSaveName == "rtn4" ) {	//RTN Detail
					ComOpenPopup("/opuscntr/EES_CIM_0050.do"+param,900, 570, "", "none", true);				
		    	} else if ( colSaveName == "onh1" || colSaveName == "onh2" || colSaveName == "onh3" || colSaveName == "onh4" ) {	//ON Detail
					ComOpenPopup("/opuscntr/EES_CIM_0051.do"+param,810, 570, "", "none", true);				
		    	}
	    	}
    	}
    }
    /**
     * end of retrieving Tab1
     * calling evnet after retrieving Tab1
     */
    function sheet2_OnSearchEnd(sheetObj, msg) {
    	/*for(var i=0; i<=sheetObj.LastRow(); i++){
    		if(sheetObj.GetCellValue(i,0) == 'SCC'){
    			sheetObj.SetRowHidden(i,1);
    		}
     		sheetObj.SetCellFont("FontBold", i,"ea1",1);
     		sheetObj.SetCellFont("FontBold", i,"ea2",1);
     		sheetObj.SetCellFont("FontBold", i,"ea3",1);
     		sheetObj.SetCellFont("FontBold", i,"ea4",1);
    		if ( i !=0 && i !=1  ) {
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea1"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea1","#FF0000");
       			}
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea2"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea2","#FF0000");
       			}
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea3"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea3","#FF0000");
       			}
    			if ( eval(ComReplaceStr(sheetObj.GetCellValue(i,"ea4"),",","")) < 0 ) {
        				sheetObj.SetCellFontColor(i,"ea4","#FF0000");
       			}
    		}
    	}*/
    	//sheetSetBackColor(sheetObj);
    	//sheetObj.RenderSheet(1);
    	ComOpenWait(false);
    }
     /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){            
        	var formObject=document.form;
        	
        	if (formObject.loc_cd.value == "") {
        		if (formObject.loc_cd.value == "") {
        			ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
        	  		formObject.loc_cd.focus();
        	  		return false;
        		}    	  		
    	  		if (!ComChkValid(formObj)) return false;
	    	  	return true;
	    	  	
        	}else{
        		if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//validating Location
                	return false;
                } else {
    	       	 	var arrTpsz=new Array(4);
    	       	 	arrTpsz[0]=document.form.cntr_tpsz_cd_val1.value;
    	       	 	arrTpsz[1]=document.form.cntr_tpsz_cd_val2.value;
    	       	 	arrTpsz[2]=document.form.cntr_tpsz_cd_val3.value;
    	       	 	arrTpsz[3]=document.form.cntr_tpsz_cd_val4.value;
    	       	 	for ( var i=0; i<arrTpsz.length; i++) {
    	       	 		if (arrTpsz[i] !='') {
    	       	 			for ( var j=0; j<arrTpsz.length; j++) {
    	       	 				if (i == j ) continue;
    	       	 				if ( arrTpsz[i] == arrTpsz[j] ) {
    	       	 					ComShowCodeMessage("CIM30006", "TP/SZ");    //duplicated TP/SZ
    	       	 					ComSetFocus(eval("document.form.cntr_tpsz_cd_val"+(j+1)));
    			    				return false;
    	       	 				}
    	       	 			}
    	       	 		}
    	       	 	}      	     
    	       	 	if ( document.form.cntr_tpsz_cd_val1.value == '' && document.form.cntr_tpsz_cd_val2.value == '' && document.form.cntr_tpsz_cd_val3.value == '' && document.form.cntr_tpsz_cd_val4.value == '' ) {
    	       	 		ComShowMessage(msgs["CIM30005"]);	//mandatory items - tp or sz
//    	       	 		formObj.cntr_tpsz_cd_val1.focus();
    	       	 		return false;
    	       	 	}
                }
                if (!ComChkValid(formObj)) return false;
        	}            
        }
        return true;
    }
     /**
      * handling process for input validation
      */
     function chkDumTpSz() {
  	     var arrTpsz=new Array(4);
 		 arrTpsz[0]=document.form.cntr_tpsz_cd_val1.value;
		 arrTpsz[1]=document.form.cntr_tpsz_cd_val2.value;
		 arrTpsz[2]=document.form.cntr_tpsz_cd_val3.value;
		 arrTpsz[3]=document.form.cntr_tpsz_cd_val4.value;
		 for ( var i=0; i<arrTpsz.length; i++) {
			 if ( arrTpsz[i] !='') {
    			 for ( var j=0; j<arrTpsz.length; j++) {
    				 if (i == j ) continue;
	    			 if ( arrTpsz[i] == arrTpsz[j] ) {
	    				ComShowCodeMessage("CIM30006", "TP/SZ");    //duplicated TP/SZ
	    				ComClearObject(eval("document.form.cntr_tpsz_cd_val"+(j+1)));
	    				ComSetFocus(eval("document.form.cntr_tpsz_cd_val"+(j+1)));
	    				return false;
	    			 }
    			 }
			 }
		 }      	     
     }
     function sheet1_OnMouseMove( sheetObj, Button, Shift, X, Y) {
    	 Row=sheetObj.MouseRow();
    	 Col=sheetObj.MouseCol();
         var colSaveName=sheetObj.ColSaveName(Col);
         var sText="";
         var mouseFlag=false;
         if ( colSaveName == "ea1" || colSaveName == "ea2" || colSaveName == "ea3" || colSaveName == "ea4" ) {
        	 sText="Est. MT Vol. Avail EQ=SN + Supply(IG,RTN,RI,ON) - Demand(BR,PUP,RO,OFF)";
         } else if ( colSaveName == "br1" || colSaveName == "br2" || colSaveName == "br3" || colSaveName == "br4" ) {
        	 mouseFlag=true;
        	 sText="Booking Reserved.  Based on MTY Pick-up Vol & Date. BKG vol, not yet picked up";
         } else if ( colSaveName == "pup1" || colSaveName == "pup2" || colSaveName == "pup3" || colSaveName == "pup4" ) {
        	 mouseFlag=true;
        	 sText="Picked-up Vol today.";
         } else if ( colSaveName == "ro1" || colSaveName == "ro2" || colSaveName == "ro3" || colSaveName == "ro4" ) {
        	 mouseFlag=true;
        	 sText="MTY Reposition-Out Exec. Plans. Based on ETD";
         } else if ( colSaveName == "ofh1" || colSaveName == "ofh2" || colSaveName == "ofh3" || colSaveName == "ofh4" ) {
        	 mouseFlag=true;
        	 sText="Off-hire(LSO,SBO,TLL,LST,SCR,DON,MUO)";	
         } else if ( colSaveName == "sn1" || colSaveName == "sn2" || colSaveName == "sn3" || colSaveName == "sn4" ) {
        	 sText="Sound MT vol, snapshot at 00:00 today";
         } else if ( colSaveName == "ig1" || colSaveName == "ig2" || colSaveName == "ig3" || colSaveName == "ig4" ) {
        	 mouseFlag=true;
        	 sText="Est. I/B MTY Generation vol after Full Delivery. IG date=Est. Full Delivery Date in COP + ID~MT Turn Time";
         } else if ( colSaveName == "rtn1" || colSaveName == "rtn2" || colSaveName == "rtn3" || colSaveName == "rtn4" ) {
        	 mouseFlag=true;
        	 sText="MTY Return vol today.";
         } else if ( colSaveName == "ri1" || colSaveName == "ri2" || colSaveName == "ri3" || colSaveName == "ri4" ) {
        	 mouseFlag=true;
        	 sText="MTY Reposition-In Exec. Plans. Based on ETB/ETA";
         } else if ( colSaveName == "onh1" || colSaveName == "onh2" || colSaveName == "onh3" || colSaveName == "onh4" ) {
        	 mouseFlag=true;
        	 sText="OW&On-hire(LSI,SBI,MUI,FND)";
         } else {
        	 sText="";
         }
         if ( Row == 1) {
//        sheetObj.MouseToolTipText=sText;
        	 sheetObj.SetToolTipText(Row,Col,sText);
         } else {
//        sheetObj.MouseToolTipText="";
        	 sheetObj.SetToolTipText(Row,Col,'');
         }
         if ( mouseFlag && Row > 0 && sheetObj.RowCount()> 0) {
    		 sheetObj.SetMousePointer("Hand");// changing mouse cursor as finger type
         }         
     }         
     
     
     
     /**
      * in case of onChange combo event    
      */
     function ru_lable_type_OnChange(){
     	var formObj = document.form;
     	
 		var lblVal = formObj.ru_lable_type.value;
 		comboOnChange(lblVal);
     }
     
     /**
      * handling in case of onChange combo event 
      * @param comboObj
      * @param Index_Code
      * @param Text
      * @return
      */   
     function comboOnChange(lblVal){ 	
     	var formObj=document.form;
     	comboObjects[0].RemoveAll();
     	//sheetObjects[1].WaitImageVisible=false;
         form.f_cmd.value=SEARCH02;
         var ruLabelType=lblVal;
     	var param="&ru_label_type="+ruLabelType;
     	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
     	var chk=sXml.indexOf("ERROR");
     	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
     		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
     		 return;
     	}	             
     	 
     	var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
         var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
          
         if(strRstrUsgTblNm.length >= 1) {
         	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
         		 var arrCode=strRstrUsgTblNm[i].split("|");
         		 if(arrCode[0] != "") {
         		 comboObjects[0].InsertItem(i+1, arrCode[0], arrCode[0]);
         		 }
         	}	
         }
         comboObjects[0].SetItemCheck(0,1);
         comboObjects[0].SetEnable(1);
     }
