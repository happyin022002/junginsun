/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0317.js
*@FileTitle  : TRO-T1 and Revenue Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0317 : esm_bkg_0317 
     */
    function esm_bkg_0317() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.obj_keyup_loc=obj_keyup_loc;
    	this.obj_click=obj_click;
    	this.setChangeDisbled_rt_flg=setChangeDisbled_rt_flg; 
    }
   	/* developer's work*/
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
            	case "btn_save": 
            		if(!validateForm(sheetObject1, formObject, "btn_Select")) return;
            		// save-> charge code validation 
            		var formObj=document.form;  
    				var chg_cd=formObj.add_rev_chg_cd.value;
    				if (chg_cd.length > 0) {
    					var param=param + "&f_cmd=" + SEARCHLIST16 + "&input_text=" + chg_cd;
     					var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
    					var output_text=ComGetEtcData(sXml, "output_text");
    					if ('Y' != output_text) {
    						ComShowMessage(ComGetMsg("BKG00970", chg_cd ));
    						//sheetObj.CellValue(Row, prefix2 + "exist_chg_cd")='N';
    						return ;
    					}else{
    						//sheetObj.CellValue(Row, prefix2 + "exist_chg_cd")='';
    					}
    				}           		
            		pre_comPopupOK();
                	break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
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
        axon_event.addListenerForm  ('click',    'obj_click',      form); 
        initControl();
    }
    function initControl() {
    	var formObj=document.form;
    	//if (formObj.cxl_flg.checked) {
    	if (formObj.cxl_flg.checked || formObj.cfm_flg.value == "Y") {
    		//frustrated (in case of existing both cxl and cfm ) it can be saved after confirm
    		//setDisabled_all();   		
    		//return;
    	}
    	setChangeDisbled_rt_flg();    	
    	formObj.cstms_clr_no.focus(); 
    	if (formObj.term.value != "D") {
    		//  it can be selected 'Yes' in all case (originally, it is not used , in case of Door) 
    		//ComEnableManyObjects(false, formObj.all_in_rt_cd[0]);
    	}
    }
    function obj_click() {
		var formObj=document.form;        
		with(formObj) {
			switch(event.srcElement.name){
	            case "all_in_rt_cd":
	            	if (term.value != "D" && all_in_rt_cd[0].checked) {
	            		ComShowCodeMessage("BKG02029");
	            		all_in_rt_cd[1].checked=true;
	            		return;
	            	} 
	            	setChangeDisbled_rt_flg(); 
	            	break;
			}
		}
    }
    function setDisabled_all() {
    	var formObj=document.form; 
    	with(formObj) {
    		//1) data : disabled
    		ComEnableManyObjects(false, t1_doc_flg[0], t1_doc_flg[1], cstms_clr_no, 
    				                    all_in_rt_cd[0], all_in_rt_cd[1], all_in_rt_cd[2], 
    				                    curr_cd, trns_rev_amt,non_trns_rev_amt,add_rev_amt, add_rev_chg_cd, 
    				                    vat_flg[0], vat_flg[1]);
    		//2) save button : disabled
    		ComEnableManyTd(false, "btn_save");
    	}
    }
    function setChangeDisbled_rt_flg() {
    	var formObj=document.form;    	
    	with(formObj) {   
    		if (all_in_rt_cd[2].checked == true) {
    			// manifested 'Additional' case
	        	if (formObj.curr_cd.value == "") {
	        		formObj.curr_cd.value="EUR";
	        	}
    			ComEnableManyObjects(true, add_rev_amt, add_rev_chg_cd);
	    		if (hlg_tp_cd.value == "C") {
	    		    //ComClassNameManyObjects_loc("input1", curr_cd, trns_rev_amt,non_trns_rev_amt);
	    		}
	    	} else if (all_in_rt_cd[2].checked == false){
    			// manifested 'Additional' case
	        	if (formObj.curr_cd.value == "") {
	        		formObj.curr_cd.value="EUR";
	        	}
    			ComEnableManyObjects(false, add_rev_amt, add_rev_chg_cd);
	    		if (hlg_tp_cd.value == "C") {
	    		    //ComClassNameManyObjects_loc("input1", curr_cd, trns_rev_amt,non_trns_rev_amt);
	    		}
	    	}
    		if (all_in_rt_cd[0].checked == true) {
    			// manifested 'Yes' case
	    		//curr_cd.value      = "";
	    		//trns_rev_amt.value = "";
	    		vat_flg.value="N";
	        	if (formObj.curr_cd.value == "") {
	        		formObj.curr_cd.value="EUR";
	        	}
	    		//ComEnableManyObjects(false, curr_cd, trns_rev_amt, vat_flg[0], vat_flg[1]);
	    		//ComEnableManyObjects(false, curr_cd, trns_rev_amt,non_trns_rev_amt);
	    		ComEnableManyObjects(true, curr_cd ,trns_rev_amt, vat_flg[0], vat_flg[1]);
	    		ComEnableManyObjects(false, non_trns_rev_amt);
	    		//non_trns_rev_amt.value = "";
	    		if (hlg_tp_cd.value == "C") {
	    		    ComClassNameManyObjects_loc("input1", curr_cd, trns_rev_amt);
	    		}
	    		if(all_in_rt_cd[2].checked == true){
	    			ComEnableManyObjects(true, add_rev_amt, add_rev_chg_cd);
	    		}else if(all_in_rt_cd[2].checked == false){
	    			ComEnableManyObjects(false, add_rev_amt, add_rev_chg_cd);
	    		}
	    	}else if (all_in_rt_cd[1].checked == true){
	    		// manifested 'No' case
	        	if (formObj.curr_cd.value == "") {
	        		formObj.curr_cd.value="EUR";
	        	}
	    		//ComEnableManyObjects(true, curr_cd, trns_rev_amt, vat_flg[0], vat_flg[1]);
	    		ComEnableManyObjects(true, curr_cd, non_trns_rev_amt);
	    		ComEnableManyObjects(false, trns_rev_amt);
	    		//trns_rev_amt.value = "";
	    		if (hlg_tp_cd.value == "C") {
	    		    ComClassNameManyObjects_loc("input1", curr_cd, non_trns_rev_amt);
	    		}
	    		if(all_in_rt_cd[2].checked == true){
	    			ComEnableManyObjects(true, add_rev_amt, add_rev_chg_cd);
	    		}else if(all_in_rt_cd[2].checked == false){
	    			ComEnableManyObjects(false, add_rev_amt, add_rev_chg_cd);
	    		}
	    	}
    		var boundCd=formObj.io_bnd_cd.value;
    		if (boundCd == "I") {
    			ComEnableManyObjects(true,  vat_flg[0], vat_flg[1]);
    		} else {
    			ComEnableManyObjects(false, vat_flg[0], vat_flg[1]);
    		}
    	}
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "h1sheet1":      //hidden sheet1
			    with(sheetObj){
		      var HeadTitle="||||||||||||";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Radio",     Hidden:0, Width:21,   Align:"Center",  ColMerge:0,   SaveName:"radio",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y", FalseValue:"N" },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:61,   Align:"Left",    ColMerge:0,   SaveName:"t1_doc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"cstms_clr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"all_in_rt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"trns_rev_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"non_trns_rev_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"add_rev_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"add_rev_chg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vat_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetVisible(0);
		        }
			    break; 			
			}
	}
    // handling of Sheet 
    function doActionIBSheet(sheetObj,formObj,sAction) {    	
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //search
	          	formObj.f_cmd.value=SEARCH;
           	    sheetObj.DoSearch("ESM_BKG_0317GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){    	        	
        with(formObj){
        	if ("btn_Select" == sAction){ 	
        		if (hlg_tp_cd.value == "C" && !checkMandatory()) {
					return false;
				}
        	}
        }
        return true;
    }
    /*
     * checkMandatory
     */ 
    function checkMandatory() {
    	var formObj=document.form;
    	if (!formObj.all_in_rt_cd[0].checked) {
        	//01. Currency
        	if (formObj.curr_cd.value.trim() == "") {
        		ComShowCodeMessage("COM12200", "Currency");
        		formObj.curr_cd.focus();
        		return false;
        	} 
        	// Manifested Revenue-> optional
        	//02.Manifested Revenue
        	//var strTrnsRevAmt = formObj.trns_rev_amt.value.trim();
        	//if (strTrnsRevAmt == "" || strTrnsRevAmt == ".00") {
        	//	ComShowCodeMessage("COM12200", "Manifested Revenue");
        	//	formObj.trns_rev_amt.focus();
        	//	return false;
        	//}
        	//02. Non-Manifested Revenue
        	var strNonTrnsRevAmt=formObj.non_trns_rev_amt.value.trim();
        	if (strNonTrnsRevAmt == "" || strNonTrnsRevAmt == ".00") {
        		ComShowCodeMessage("COM12200", "Non-Manifested Revenue");
        		formObj.non_trns_rev_amt.focus();
        		return false;
        	}        	
    	}
        return true;
    }
    /** 
     * forwarding value to  opener screen
     */ 
    function pre_comPopupOK() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
        sheetObj.RemoveAll();                //initializing grid
        var nRow=sheetObj.DataInsert(-1);  //adding new row
        with (formObj) {
	        var t_trns_rev_amt=delComma_loc(document.form.trns_rev_amt, 0, 9, 2); 
	        var t_non_trns_rev_amt=delComma_loc(document.form.non_trns_rev_amt, 0, 9, 2);
	        var t_add_rev_amt=delComma_loc(document.form.add_rev_amt, 0, 9, 2);
	        var t_bkg_no=bkg_no.value;
	        var t_cstms_clr_no=cstms_clr_no.value;
	        var t_add_rev_chg_cd=add_rev_chg_cd.value;	
	        var t_curr_cd=curr_cd.value;	        
	        var t_cxl_flg=(cxl_flg.checked)? "Y" : "N"; 
	        var t_t1_doc_flg="";
	        if (t1_doc_flg[0].checked) {
	        	t_t1_doc_flg="Y";
	        } else {
	        	t_t1_doc_flg="N";
	        }
	        var t_all_in_rt_cd="";
	        if (all_in_rt_cd[0].checked  == true && all_in_rt_cd[2].checked == false) {
	        	t_all_in_rt_cd="Y";
	        } else if (all_in_rt_cd[1].checked == true && all_in_rt_cd[2].checked == false) {
	        	t_all_in_rt_cd="N";
	        } else if (all_in_rt_cd[0].checked  == true && all_in_rt_cd[2].checked == true) {
	        	t_all_in_rt_cd="A";
	        } else if (all_in_rt_cd[1].checked  == true && all_in_rt_cd[2].checked == true) {
	        	t_all_in_rt_cd="B";
	        }
	        var t_vat_flg="";
	        if (vat_flg[0].checked) {
	        	t_vat_flg="Y";
	        } else {
	        	t_vat_flg="N";
	        }
	        sheetObj.SetCellValue(nRow, "bkg_no",t_bkg_no,0);
	 		sheetObj.SetCellValue(nRow, "t1_doc_flg",t_t1_doc_flg,0);
	 		sheetObj.SetCellValue(nRow, "cstms_clr_no",t_cstms_clr_no,0);
	 		sheetObj.SetCellValue(nRow, "all_in_rt_cd",t_all_in_rt_cd,0);
	 		sheetObj.SetCellValue(nRow, "curr_cd",t_curr_cd,0);
	 		sheetObj.SetCellValue(nRow, "trns_rev_amt",t_trns_rev_amt,0);
	 		sheetObj.SetCellValue(nRow, "vat_flg",t_vat_flg,0);
	 		sheetObj.SetCellValue(nRow, "cxl_flg",t_cxl_flg,0);
	 		sheetObj.SetCellValue(nRow, "radio","Y",0);
	 		sheetObj.SetCellValue(nRow, "non_trns_rev_amt",t_non_trns_rev_amt,0);
	 		sheetObj.SetCellValue(nRow, "add_rev_amt",t_add_rev_amt,0);
	 		sheetObj.SetCellValue(nRow, "add_rev_chg_cd",t_add_rev_chg_cd,0);
        }
    	comPopupOK();
    }
    //#################(Util/Etc)############################
    /*
     *  deleting comma
     * @author :
     */    
     function delComma_loc(objTxt) {
         var comma=/,/gi;
         var temp=objTxt.value;
         temp=temp.replace(comma, '');
         return temp;
     }
     /*
     *  inserting comma
     * pCnt     :  point(except comma)
     * nAccount :  point
     * @author : 
     */
    //function changeComma_loc(objTxt, term1, pCnt, nAccount)
    function changeComma_loc(txtVal, term1, pCnt, nAccount)
    {
        var strResult="";    	  
		var comma=/,/gi;   
		//var temp  = objTxt.value;
		var temp=txtVal;
		temp=temp.replace(comma, '');
		temp=temp.replace('-', '');
		if(temp.indexOf('.') != -1)  //in case of point
		{
		    var jum_up=temp.substring(0, temp.indexOf('.'));
		    if (jum_up.length > pCnt) {
			    jum_up=jum_up.substring(0, pCnt);
		    }
		    var jum_down=temp.substring(temp.indexOf('.')+1, temp.length);
		    if (jum_down.length > nAccount) {
			    jum_down=jum_down.substring(0, nAccount);
		    }
		    jum_up=parseInt(jum_up)+'';
		    if(jum_up == 'NaN') jum_up='';
		    if (term1 == 0) {
		    	//objTxt.value = Comma_Input(jum_up)+"."+jum_down;
		    	strResult=Comma_Input(jum_up)+"."+jum_down;
		    } else { 
		    	//objTxt.value = jum_up+'.'+jum_down;
		    	strResult=jum_up+'.'+jum_down;
		    }
		}else {
		    temp=parseInt(temp)+'';
		    if (temp.length > pCnt) {
			    temp=temp.substring(0, pCnt);
		    }        
		    if(temp == 'NaN') temp='';
		    if (term1 == 0) {
		    	//objTxt.value = Comma_Input(temp);
		    	strResult=Comma_Input(temp);
		    } else {
		    	//objTxt.value = temp;
		    	strResult=temp;
		    }
		}
		return strResult;
    }
    /*
     *  inserting comma
     * @author :
     */
    function Comma_Input(txtNumber)
    {
    	var v=txtNumber;
    	var vlen=v.length;
    	var c=1;       
    	var tmp=new Array();
    	var comma=','; 
    	var pas="";
    	for ( i=vlen ; i>-1; i-- ) { 
    		c++;
    		if ( ( c%3 == 0 ) && ( i != vlen - 1) ) {
    			tmp[i]=v.charAt(i) + comma; 
    		} else {
    			tmp[i]=v.charAt(i);
    		}
    	}
    	for ( i=0; i<tmp.length; i++ ) {
    		pas=pas + tmp[i];
    	}
    	return pas;
    }        
    function ComClassNameManyObjects_loc(p_className, objs) {
        try {
            var args=arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) {
                	args[i].className=p_className;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
 	/**
	 * TD button,   handling Enable/Disable 
	 */
    function ComEnableManyTd(bEnable, objs) {
	    try {
	        var args=arguments;
	        if (args.length < 2) return;
	        for(var i=1; i<args.length; i++) {
	 	    	if (bEnable == true) {
		    		ComBtnEnable(args[i]);
		    	} else {
		    		ComBtnDisable(args[i]);
		    	} 
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
    }	
	/* the end of developer's work */
