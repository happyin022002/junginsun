/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_SCE_0120.js
*@FileTitle : Actual Mapping History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE :  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined..
     * @author 
     */

    /**
     * @extends 
     * @class ESD_SCE_0120 :  business script for ESD_SCE_0120
     */
    function ESD_SCE_0120() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
  
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    /* Event handler processing by button name */
    function processButtonClick(){
    	 var sheetObj = sheetObjects[0];
    	 var formObj  = document.form;

    	try{
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {

    			case "btn_retrieve":
    				if(validateForm(sheetObj, formObj, IBSEARCH)){
    					doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				}
    				break;

    			case "btn_new":
    				sheetObj.RemoveAll();
    				formObj.reset();
    				break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
    				break;

    			case "btn_save" :
    			    if(validateForm(sheetObj, formObj, IBSAVE)){
    			         doActionIBSheet(sheetObj,formObj,IBSAVE);
    			    }
    				break;

    			// CLM踰꾪듉異붽� &&&
    	  		case "btn_clm":
    			     if(validateCLM(sheetObj,formObj,"LINKCLM")){
    			 	       goESD_SCE_044(sheetObj) ;
    			     }
    				break;
     
    			case "btn_send" :
    				//openESD_SCE_102(sheetObj, formObj);
    				openESD_SCE_102_NEW(sheetObj, formObj);
    				break;

    			case "btn_copdetail" :
    			     if(validateETC(sheetObj,formObj,"LINKCOP")){
    			 	       goESD_SCE_006(sheetObj);
    			     }
    				break;

    			case "btn_act_calendar":
    				//cal = new calendarPopupFromTo();
    				//cal.displayType = "date";
    				//cal.select(formObj.act_fm_dt, 'act_fm_dt',formObj.act_to_dt, 'act_to_dt', 'yyyy-MM-dd');
    				var cal = new ComCalendarFromTo();
    				cal.displayType = "date";
    				cal.select(formObj.act_fm_dt, formObj.act_to_dt, 'yyyy-MM-dd');
    				break ;

    			case "btn_occur_calendar":
    				//cal = new calendarPopupFromTo();
    				//cal.displayType = "date";
    				//cal.select(formObj.occur_fm_dt, 'occur_fm_dt',formObj.occur_to_dt, 'occur_to_dt', 'yyyy-MM-dd');
    				var cal = new ComCalendarFromTo();
    				cal.displayType = "date";
    				cal.select(formObj.occur_fm_dt, formObj.occur_to_dt, 'yyyy-MM-dd');
    				break ;

    			case "btn_occu_loc" :
    				window.open( '/opuscntr/ESD_SCE_0104.do',"scPopup","top=100, left=50, width=800,height=480") ;
    				break;
    			case "btn_scpopup" :
    				window.open('/opuscntr/ESD_SCE_0105.do',"scPopup","top=200, left=200, width=500,height=450") ;
    				break;

    			case "btn_occr_ofc" :

					var selofc_cd = formObj.cre_ofc_cd.value;
					//selofc_cd="LE";
					ComOpenWindow('ESD_SCE_0910.screen?sel_ofc_cd='+selofc_cd, 'ESD_SCE_0910', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				break;


    			case "btn_confirm" :
    			      if(validateForm(sheetObj, formObj, IBSEARCH_ASYNC01)){
    			         doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
    			      }
    				break;

    		}
    	}catch(e){
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
    		} else {
    			ComShowMessage(e);
    		}
    	}

    }

    function getSCNO( so_no) {
    	document.getElementById ("sc_no").value =so_no;
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {

    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	 ComSetUIItem(sheetObjects[0], document.form, "SCE", "ESD_SCE_0120");
        //document.all['h_expt_tp'].selectedIndex = document.form.expt_tp_selected_idx.value;

        //fun_getExptTP();
    }

       /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var  xs3 = document.form.iCheckRow.value;


    	switch(sheetNo) {
    		case 1:	  //IBSheet1 init
    			with (sheetObj) {

                    	var aryRows;
    					if (xs3.length > 0){
    						aryRows = xs3.split("|");
    					}else{
    						aryRows = new Array();
    					}


    				//setting width
    				SheetWidth = mainTable.clientWidth;

    				//setting Host information[HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//Merge kind[, Default msNone]
    				MergeSheet = msHeaderOnly;

    				//Edit kind[, Default false]
    				Editable = true;

    				//setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
    				InitRowInfo( 1, 1,  9, document.form.row_size.value);

    				//setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(20, 5, 0, true);

    				// setting function handling header
    				InitHeadMode(true, true, true, true, false,false)

    				var HeadTitle = "SEQ|Actual Type|Mappimg|Actual Date|Event Code|VVD|BKG No.|CNTR No.|COP|Actaul Code|Location|Planned|Estimated|Gap Time|Master COP|Actual Received Date|Mapping Date|Retry Mapping|Update Date|Update ID" ;

    				//setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				
    				InitDataProperty(0, cnt++ , dtSeq,	     30,	daCenter,  true,	"r_seq",			    false,		  "",	   dfNone,   		0,		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	   	100,	daCenter,  true,	"r_act_rcv_tp_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"r_act_umch_tp_cd",				false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	  100,	daCenter,  true,	"r_act_dt",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		300,	daCenter,  true,	"r_act_sts_mapg_cd",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,	  0,	daCenter,  true,	"r_vvd",	false,		  "",	   dfNone,   	0,	 		false,	   false);

    				InitDataProperty(0, cnt++ , dtData,		200,	daCenter,  true,	"r_bkg_no",	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"r_cntr_no",    		false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"r_cop_no",	        false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"r_act_cd",	        	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"r_nod_cd",	         	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"r_pln_dt",	            false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"r_estm_dt",				false,		  "",	   dfNone,   	0,	 		false,	   false);

    				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"r_act_gap_desc",				false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		150,	daCenter,  true,	"r_mst_cop_no",			false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"r_act_dat_rcv_dt",		false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"r_umch_chk_dt",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		150,	daCenter,  true,	"r_dup_flg",	        false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		150,	daCenter,  true,	"r_upd_dt",	        false,		  "",	   dfNone,   	0,	 		false,	   false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"r_upd_usr_id",			false,		  "",	   dfNone,   	0,	 		false,	   false);

    				style.height = GetSheetHeight(12) ;
    				DataLinkMouse = true;


    		   }
    			break;

    	}
    }

    function sheet1_OnDblClick(sheetObj, row, col, value) {
    	var newForm = "" ;

    	if( sheetObj.ColSaveName(col) == "r_cop_no") {

    		newForm += "<form name='form1' method='post'>" ;
    		newForm += "  <input type='hidden' name='bkg_no'      value='" + sheetObj.CellValue(row, "r_bkg_no") + "'>" ;
    		newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(row, "r_bkg_no_split") + "'>" ;
    		newForm += "  <input type='hidden' name='cop_no' value='" + sheetObj.CellValue(row, "r_cop_no") + "'>" ;
    		newForm += "  <input type='hidden' name='bl_no' value='" + sheetObj.CellValue(row, "r_bl_no") + "'>" ;
    		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(row, "r_cntr_no") + "'>" ;
    		newForm += "  <input type='hidden' name='vvd'      value='" + sheetObj.CellValue(row, "r_vvd") + "'>" ;
    		newForm += "  <input type='hidden' name='por'      value='" + sheetObj.CellValue(row, "r_por") + "'>" ;
    		newForm += "  <input type='hidden' name='pol'      value='" + sheetObj.CellValue(row, "r_pol") + "'>" ;
    		newForm += "  <input type='hidden' name='pod'      value='" + sheetObj.CellValue(row, "r_pod") + "'>" ;
    		newForm += "  <input type='hidden' name='del'      value='" + sheetObj.CellValue(row, "r_del") + "'>" ;
    		newForm += "</form>" ;

    		document.all.new_form.innerHTML = newForm ;

    		var formObj = document.form1 ;

    		var newWin  = window.open("","cop_detail", "width=810,height=400," + getCenterXY(704, 166));
    		formObj.action = "/opuscntr/ESD_SCE_0101.do" ;
    		formObj.target = "cop_detail" ;
    		formObj.submit() ;
    		newWin.focus() ;
    	} else if( sheetObj.ColSaveName(col) == "r_cop_expt_no")
    	{
    		newForm  = "<form name='form1' method='post'>" ;
    		newForm += "  <input type='hidden' name='cop_expt_no'	value='" + sheetObj.CellValue(row, "r_cop_expt_no") + "'>" ;
    		newForm += "  <input type='hidden' name='cop_no'		 value='" + sheetObj.CellValue(row, "r_cop_no") + "'>" ;
    		newForm += "  <input type='hidden' name='cntr_no'		value='" + sheetObj.CellValue(row, "r_cntr_no") + "'>" ;
    		newForm += "  <input type='hidden' name='cop_expt_tp_cd' value='" + sheetObj.CellValue(row, "r_cop_expt_tp_cd") + "'>" ;
    		newForm += "</form>";

    		document.all.new_form.innerHTML = newForm ;

    		var formObj = document.form1 ;

    		formObj.action = "ESD_SCE_0012.do";

    		formObj.submit() ;

    	}
    }

      // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false ;
    	switch(sAction) {
    	   case IBSEARCH:
    			formObj.f_cmd.value = SEARCHLIST ;
    			formObj.target	  = "_self" ;
    	
    			sheetObj.DoSearch4Post("ESD_SCE_0120GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam("r_"));
    			
    			break;

    	   case IBDOWNEXCEL:
    			  sheetObj.Down2Excel(-1, false, false, true);
    			  break;

    	   case IBSAVE:
                    formObj.f_cmd.value = MULTI;
                    sheetObj.DoAllSave("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
                    formObj.expt_rsn.value = "" ;
                    formObj.expt_rsn_cd.value = "" ;
                    formObj.f_cmd.value = SEARCHLIST;
                    sheetObj.DoSearch4Post("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
    	          break;

           case IBSEARCH_ASYNC01:
                    formObj.f_cmd.value = MULTI01;
                    sheetObj.DoAllSave("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
                    formObj.f_cmd.value = SEARCHLIST;
                    sheetObj.DoSearch4Post("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
                break;

    	}
    }


    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        var result = true;

    	if(sAction == IBSEARCH) {

    		if(ComIsEmpty(formObj.act_fm_dt) || ComIsEmpty(formObj.act_to_dt)){
        		ComShowMessage('Please input Receive Date') ;
                formObj.act_to_dt.focus() ;
            	result = false ;
        	}

        	// BKG Date
    		else if(!chkBkgDates(formObj)){
//        	alert("chkBkgDates");
    			result = false ;
        	// BKG No
    		}else if(!ComIsEmpty(formObj.bkg_no) ){
//        	alert("chk bkg No");
    		
        	    if(formObj.bkg_no.value.length<11 && !chkLenth(formObj.bkg_no, 11, "BKG No")){
        	    	 result = false ;
        	    }
        	}
        	// BL No
        	else if(!ComIsEmpty(formObj.bl_no)){
//        	alert("chk bl");
        	    if(formObj.bl_no.value.length<12 && !chkLenth(formObj.bl_no, 12, "B/L No")){
        	    	result = false ;
        	    }
        	}
//        	// Container No
//        	else if(!ComIsEmpty(formObj.cntr_no)){
//        	    if(formObj.cntr_no.value.length<11 && !chkLenth(formObj.cntr_no, 11, "Container No.")){
//            		result = false ;
//        	    }
//        	}
//        	// COP No.
//        	else if(!ComIsEmpty(formObj.cop_no)){
//        	    if(formObj.cop_no.value.length<14 && !chkLenth(formObj.cop_no, 14, "COP No.")){
//            		result = false ;
//        	    }
//        	}
//        	// Exception No.
//        	else if(!ComIsEmpty(formObj.expt_no)){
//        	    if(formObj.expt_no.value.length<14 && !chkLenth(formObj.expt_no, 14, "Exception No.")){
//            		result = false ;
//        	    }
//        	}
        	// vvd Saarch
        	else if(!ComIsEmpty(formObj.vvd)){
//        	alert("chk vvd");
        	    if(formObj.vvd.value.length<9 && !chkLenth(formObj.vvd, 9, "VVD")){
//        	alert("chk vvd1");
        	    	result = false ;
//        	    }else if(formObj.vvd.value.length>9 && ComIsEmpty(formObj.cust_cnt_seq)){
//        	//alert("chk vvd2");
//            		ComShowMessage('Please input Customer') ;
//                    formObj.cust_cnt_seq.focus() ;
//        	        result = false ;
        	    }
        	// POR Multi-check box &&&
        	}else  if(!ComIsEmpty(formObj.por_cd) && formObj.por_cd.length < 0){
//        	alert("chk por");
    	       result = false ;
        	// POL Multi-check box &&&
    	    }else  if(!ComIsEmpty(formObj.pol_cd) && formObj.pol_cd.length < 0){
//        	alert("chk pol");
    	        result = false ;
        	// POD Multi-check box &&&
    	    }else  if(!ComIsEmpty(formObj.pod_cd) && formObj.pod_cd.length < 0){
//        	alert("chk pod");
    	        result = false ;
        	// DED Multi-check box	 &&&
    	    }else  if(!ComIsEmpty(formObj.del_cd) && formObj.del_cd.length < 0){
//        	alert("chk del");
    	        result = false ;
    	    }
    		// Occurred DT
    		else if(!chkOccDates(formObj)){
//        	alert("chkOccDates");
    			result = false ;
    		}
//        	alert("validateForm end:"+result);

    	}else if(sAction == IBSAVE) {
//    		    alert("IBSAVE");
                if(sheetObj.CheckedRows("r_chk")>0){
                    //alert("chk_row:"+sheetObj.CheckedRows("r_chk")+"::"+sheetObj.TotalRows);

                        var chkcnt = sheetObj.CheckedRows(0);
            	    	for(var a = 0 ; a < chkcnt ; a++){
            	    		chkrow = sheetObj.FindCheckedRow(0).split('|')[a];
            	    		//alert("chkrow:"+chkrow);
            	    		if(((formObj.expt_rsn_cd.value=="99") && sheetObj.CellValue(chkrow,"r_remark")=="")
            	    		  ||(sheetObj.CellValue(i,"r_cop_expt_rsn")=="Others" && sheetObj.CellValue(i,"r_remark")=="")){
                            		ComShowMessage('Please Input Remark for Exception Reason Insert of Others') ;
                                    sheetObj.FocusEditMode = 0;
                                    a = chkcnt ;
                                    result = false ;
            	    		}

//            	    		if(a == 0){
//            	    			coldesc1 = sheetObject.CellValue(chkrow, "coldesc1");
//            	    			//coldesc2 = sheetObject.CellValue(chkrow, "coldesc2");
//            	    		}else{
//            	    			coldesc1 = coldesc1 + ',' + sheetObject.CellValue(chkrow, "coldesc1");
//            	    			//coldesc2 = coldesc2 + ',' + sheetObject.CellValue(chkrow, "coldesc2");
//            	    		}
            	    	}


//                }else if(ComIsEmpty(formObj.expt_rsn_cd)){
//            		ComShowMessage('Please select Exception Reason Insert') ;
//                    formObj.expt_rsn.focus() ;
//                	result = false ;
    		    }else if(sheetObj.CheckedRows("r_chk")<=0){
//    		        alert("n CheckedRows");
            		ComShowMessage('Please check the CheckBox') ;
                	result = false ;
    		    }

    	}else if(sAction == IBSEARCH_ASYNC01) {
//    		    alert("IBSEARCH_ASYNC01");
    		    if(sheetObj.CheckedRows("r_chk")<=0){
//    		        alert("n CheckedRows");
            		ComShowMessage('Please check the CheckBox') ;
                	result = false ;
    		    }

    	}



    	return result;
    }

    function validateETC(sheetObj,formObj,sAction){
        var result = true;
        if(sAction == "LINKCOP") {
            if(sheetObj.CheckedRows("r_chk")>1){
//    		        alert("n CheckedRows");
            		ComShowMessage('Please check Only One Row') ;
                	result = false ;
            }
        }

    	return result;
    }
    // CLM Button Add &&&
    function validateCLM(sheetObj,formObj,sAction){
        var result = true;
        if(sAction == "LINKCLM") {
            if(sheetObj.CheckedRows("r_chk")<1){
            		ComShowMessage('Please check Only One Row') ;
                	result = false ;
            }else if(sheetObj.CheckedRows("r_chk")>1){
                    ComShowMessage('Please check Only One Row') ;
                    sheetObj.CheckAll("r_chk")=0;
                	result = false ;
            }
        }

    	return result;
    }

    function isInputField(formObj){
    	var result    = false ;
    	var fieldType = null ;

    	for(i=0; i<formObj.length; i++){
    		fieldType = formObj[i].type

    		if((fieldType=="checkbox" || fieldType=="radio")){
    			if(formObj[i].checked){
    			    alert("checkbox");
    				result = true ;
    				break ;
    			}
    		}
    		else if(fieldType!="hidden" && !formObj[i].readOnly && formObj[i].value!='O'){
    		    //h_expt_tp  h_expt_tp_dtl
    		    //alert(formObj[i].name);
    			if(!ComIsEmpty(formObj[i])){  
    				if(formObj[i].name=='Delay_time' || formObj[i].name=='expt_cfm'){
    					result = false ;
    				}else{
    			    	//alert("hidden:"+formObj[i].value+" name:"+formObj[i].name+" i:"+i);
    					result = true ;
    				}
    				break ;
    			}
    		}
//    		else if(formObj.expt_rsn_inq_cd.value!=""){
//    		    result = true ;
//    		    break ;
//    		}

    	}

    	if(!result){ 
    		ComShowMessage(ComGetMsg('SCE90016')) ; 
            formObj.act_fm_dt.focus() ;
    	}

    	return result ;
    }

    function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    	var formObj = document.form ;
    	selectVal = SceFrmQryString(formObj);
    	sheetObj.DoSearch4Post("ESD_SCE_0120GS.do", selectVal, "i_page=" + PageNo, true);
    }

    function chkVVD(formObj, isEmptyVVD){
    	var result   = true ;
    	var emptyVVd = isEmptyVVD!=null ? isEmptyVVD : ComIsEmpty(formObj.vvd) ;

    	if(!emptyVVd){
    		if(ComIsEmpty(formObj.por_cd) && ComIsEmpty(formObj.org_nod_cd) &&
    				ComIsEmpty(formObj.dest_nod_cd) && ComIsEmpty(formObj.del_cd)){
    			ComShowMessage(ComGetMsg('SCE90001'));
    			formObj.por_cd.focus() ;
    			result = false ;
    		}
    	}

    	return result ;
    }

    function chkRouters(formObj, ComIsEmptyRouters){
    	var result	   = true ;
    	var emptyRouters = ComIsEmptyRouters!=null ? ComIsEmptyRouters :
    					   ComIsEmpty(formObj.por_cd) && ComIsEmpty(formObj.pol_cd) &&
    					   ComIsEmpty(formObj.pod_cd) && ComIsEmpty(formObj.del_cd) ?
    					   true : false ;

    	if(!emptyRouters){
    		if(ComIsEmpty(formObj.vvd)){
    			ComShowMessage(ComGetMsg('SCE90033', 'POR, POL, POD, DEL', 'VVD'));
    			formObj.vvd.focus() ;
    			result = false ;
    		}else{
    		    if(!ComIsEmpty(formObj.por_cd) && !chkLenth(formObj.por_cd, 5, "POR")){
    		        result = false ;
    		    }else  if(!ComIsEmpty(formObj.pol_cd) && !chkLenth(formObj.pol_cd, 5, "POL")){
    		        result = false ;
    		    }else  if(!ComIsEmpty(formObj.pod_cd) && !chkLenth(formObj.pod_cd, 5, "POD")){
    		        result = false ;
    		    }else  if(!ComIsEmpty(formObj.del_cd) && !chkLenth(formObj.del_cd, 5, "DEL")){
    		        result = false ;
    		    }
    		}
    	}

    	return result ;
    }

    function chkVVDRouters(formObj, ComIsEmptyVVD, ComIsEmptyRouters){
    	var result	   = true ;
    	var emptyVVD	 = ComIsEmptyVVD!=null ? ComIsEmptyVVD : ComIsEmpty(formObj.vvd) ;
    	var emptyRouters = ComIsEmptyRouters!=null ? ComIsEmptyRouters :
    					   ComIsEmpty(formObj.por_cd) && ComIsEmpty(formObj.org_nod_cd) &&
    					   ComIsEmpty(formObj.dest_nod_cd) && ComIsEmpty(formObj.del_cd) ?
    					   true : false ;

    	if(!emptyVVD){
    		result = chkVVD(formObj, emptyVVD) ;
    	}
    	else if(!emptyRouters){
    		result = chkRouters(formObj, emptyRouters) ;
    	}

    	return result ;
    }




    function getCenterXY(w, h){

    	var height = screen.availHeight ;
    	var width = screen.availWidth ;

    	var leftpos = width/2 - w/2;
    	var toppos = height/2 - h/2;
    	if(leftpos<0) leftpos=0;
    	if(toppos<0) toppos=0;

    	return "left=" + leftpos + ", top=" + toppos ;
    }

    function sheet1_OnAfterColumnMove(sheetObj, col, newPos){
    	var newColName = sheetObj.ColSaveName(newPos) ;
    	switch (newColName) {
    		case "r_bkg_no":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_bkg_no_split", newPos, false);
    			break;
    		case "r_cust_cnt_seq1":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_cust_lgl_eng_nm1", newPos, false);
    			break;
    		case "r_cust_cnt_seq2":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_cust_lgl_eng_nm2", newPos, false);
    			break;
    		case "r_cust_cnt_seq3":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_cust_lgl_eng_nm3", newPos, false);
    			break;
    		default:
    			break;

    	}

    }

    function chkLenth(obj, len, msg) {
    	var result = true ;

    	if(ComGetLenByByte(obj.value)!==len){
    		ComShowMessage(ComGetMsg('SCE90026', msg, len));
            obj.focus() ;
            result = false ;
    	}

    	return result ;
    }

    function chkOccDates(formObj, isEmptyBKGDates){
    	var result        = true ;
    	var emptyBKGDates = isEmptyBKGDates!=null ? isEmptyBKGDates :
    		ComIsEmpty(formObj.occur_fm_dt)&&ComIsEmpty(formObj.occur_to_dt) ;

    	if(!emptyBKGDates){
    		if(!ComIsDate(formObj.occur_fm_dt)){
    	        ComShowMessage(ComGetMsg('SCE90003','Occurred Date')) ;
    	        formObj.occur_fm_dt.focus() ;
    	        result = false ;
    	    }
    	    else if(!ComIsDate(formObj.occur_to_dt)){
    	        ComShowMessage(ComGetMsg('SCE90003','Occurred Date')) ;
    	        formObj.occur_to_dt.focus() ;
    	        result = false ;
    	    }else{
        	    var dt1=formObj.occur_fm_dt.value;
        	    var num1=dt1.replace(/-/g,"");
        	    var dt2=formObj.occur_to_dt.value;
        	    var num2=dt2.replace(/-/g,"");

    	        if(num1>num2){
        	        ComShowMessage(ComGetMsg('SCE90036','Occurred Date')) ;
        	        formObj.occur_fm_dt.focus() ;
        	        result = false ;
    	        }
    	    }
    	}

        return result ;
    }

    function chkBkgDates(formObj, isEmptyBKGDates){
    	var result        = true ;
    	var emptyBKGDates = isEmptyBKGDates!=null ? isEmptyBKGDates :
    						ComIsEmpty(formObj.act_fm_dt)&&ComIsEmpty(formObj.act_to_dt) ;

    	if(!emptyBKGDates){
    		if(!ComIsDate(formObj.act_fm_dt)){
    	        ComShowMessage(ComGetMsg('SCE90003','BKG Date')) ;
    	        formObj.act_fm_dt.focus() ;
    	        result = false ;
    	    }
    	    else if(!ComIsDate(formObj.act_to_dt)){
    	        ComShowMessage(ComGetMsg('SCE90003','BKG Date')) ;
    	        formObj.act_to_dt.focus() ;
    	        result = false ;
    	    }else{
        	    var dt1=formObj.act_fm_dt.value;
        	    var num1=dt1.replace(/-/g,"");
        	    var dt2=formObj.act_to_dt.value;
        	    var num2=dt2.replace(/-/g,"");

    	        if(num1>num2){
        	        ComShowMessage(ComGetMsg('SCE90036','BKG Date')) ;
        	        formObj.act_fm_dt.focus() ;
        	        result = false ;
    	        }
    	    }
    	}

        return result ;
    }

    function comboChange(){

    }


    function onEnterKey(textname) {
    	if (event.keyCode == 13) {
    		var formObj = document.form;
    		if( validateForm(formObj) ) {
    			formObj.f_cmd.value = "" ;
    	//		formObj.target = "_self" ;
    	//		formObj.action = "ESD_SCE_002.do" ;
    	//		formObj.submit() ;
    		}
    	}
    }

    function CheckDigit(obj){
        var rtnval = cntrCheckDigit(obj);
        obj.value  = rtnval;
    }

    // Container No. Set of CheckDigit.
    function CheckDigitSplit( obj, bitTarget, valueTarget){
    	var cntrNo = obj.value;
    	if (cntrNo.length < 10){
    		document.getElementById(bitTarget).value = '';
    		document.getElementById(valueTarget).value = cntrNo;
    		return;
    	}
    	chkField(obj, 'eng_num', true, 10)
    	var sum = 0;
     	cntrNo = cntrNo.toUpperCase();

    	for(var i=0;i<10;i++){
    		sum = sum + productValue( cntrNo.charAt(i),i);
    	}
    	var mod = sum % 11;

    	if (mod == 10) mod =0;

    	if( isNaN(mod)){
    		document.getElementById(bitTarget).value = '';
    		document.getElementById(valueTarget).value = obj.value;
    	}else{
    		document.getElementById(bitTarget).value = mod;
    		document.getElementById(valueTarget).value = obj.value + mod;
    	}
    }

     function openESD_SCE_006(sheetObj) {
    //alert("openESD_SCE_006 start");
    	var chkCnt = sheetObj.CheckedRows("r_chk") ;
//    	alert(chkCnt);

    	if( chkCnt==0 ) {
    		ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
    		return false ;
    	}

    	var chkRows = sheetObj.FindCheckedRow("r_chk") ;
    	var arrChkRows = chkRows.split("|") ;
    	var newForm = "" ;

//    	alert("chkRows:"+chkRows+"arrChkRows:"+arrChkRows+"="+arrChkRows[0]);
//    	alert(sheetObj.CellValue(arrChkRows[0], "r_cop_no"));
    //alert(sheetObj.CellValue(arrChkRows[0], "r_bkg_no"));
    //alert(sheetObj.CellValue(arrChkRows[0], "r_bkg_no_split"));
    //alert(sheetObj.CellValue(arrChkRows[0], "r_cntr_no"));

    	var newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(arrChkRows[0], "r_cop_no") + "'>" ;
    	newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[0], "r_bkg_no") + "'>" ;
    	newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[0], "r_bkg_no_split") + "'>" ;
    	var cntr_no = sheetObj.CellValue(arrChkRows[0], "r_cntr_no");
    	if ( cntr_no.length <=0)
    		cntr_no="COMU0000000";
    	newForm += "  <input type='hidden' name='cntr_no'      value='" + cntr_no + "'>" ;
    	newForm += "</form>";
//    	alert("newForm:"+newForm);
    	document.all.new_form.innerHTML = newForm ;
    	//alert(newForm);
    	//document.all.new_form.innerHTML = newForm ;
//    	alert("1");

    	var formObj = document.form1;
//    	alert("2");
    	formObj.action = "/opuscntr/ESD_SCE_0006.do";
//    	alert("3");
    	formObj.submit() ;
//    	alert("4");
    	/*document.all["tdStatus"].innerHTML = document.all["mailStatusCodeHTML"].innerHTML;
        	formObj.f_cmd.value = COMMAND01;
            formObj.target = "iframe_rdsend";
            formObj.action = "monitorRdSendCommon.do?"+selectVal;
            formObj.submit();
    */
    }

    function getSelectedValue ( loc_cd) {
    	document.getElementById("occr_nod_cd").value = loc_cd;
    }

    function openColumnList(){
    	var formObject = document.form;

    	window.open ("/opuscntr/ESD_SCE_0077.do" , "list", "scrollbars=no,fullscreen=no,width=800,height=450");

    }

  
    function rtn_rcc_code(strval) {
    	document.form.rcc_cd.value = strval;

    }

     function rtn_lcc_code(strval) {
    	document.form.lcc_cd.value = strval;
    }

    function rtn_ecc_code(strval) {
    	document.form.ecc_cd.value = strval;
    }

     function rtn_scc_code(strval) {
    	document.form.scc_cd.value = strval;
    }

    function rtn_pod_code(strval) {
    	document.form.pod_cd.value = strval;
    }

    function rtn_office_code(obj) {
    	document.form.cre_ofc_cd.value = obj;
    }

    function fun_chkOffice() {  
	var doc_office = document.form.chk_office;
	//var prm_office = doSepRemove(document.form.occr_ofc.value.toUpperCase(), " "); //input text
	var prm_office = doSepRemove(document.form.cre_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.cre_ofc_cd.value = "";
		ComShowMessage("Please input the 'Occurred Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {

		var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH11+"&sel_ofc_cd="+prm_office;

		//alert(url);
		
		createHttpRequest();

		request.open("GET", url, false);

		request.onreadystatechange = subCntorlOffice;

		request.send(null);
	} else {
		document.form.cre_ofc_cd.value = prm_office;
	}
}

     var request = null;
    function createHttpRequest() {
    	try{
    		request = new XMLHttpRequest();
    	} catch(trymicrosoft) {
    		try{
    			request = new ActiveXObject("Msxml2.XMLHTTP");
    		} catch(othermicosoft) {
    			try{
    				request = new ActiveXObject("Microsoft.XMLHTTP");
    			} catch(failed) {
    				request = null;
    			}
    		}
    	}
    	if( request == null ) {
    		ComShowMessage("Erroe Request XMLHttp");
    	}
    }

     function subCntorlOffice() {
    if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			//var rowXml = docXml.getElementsByTagName("TR")[0];
			var subXml = null;
			var text_ofc = "";
			
			//alert(docXml.getElementsByTagName("TR").length);
			//alert(rowXml.firstChild.nodeValue.replace('��,''));
			
			//var aaa = ComReplaceStr(rowXml.firstChild.nodeValue, "�쒋삛", "");
			//alert(docXml.xml);
			
			//for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
			//	subXml = docXml.getElementsByTagName("sub-office")[n];
			//	text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			//}
			
			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "�쒋삛", "");
				//alert(val);
				text_ofc = text_ofc+val+",";
			}
			
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}else{
				document.form.cre_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
			}
		}

	}

    }

    function keyAction() {
        var formObj = document.form ;

    	//if(event.keyCode == 13){
    		//alert('keyAction');
    		/*
    		if(ComIsEmpty(formObj.cntr_no)){
    		    ComShowMessage(ComGetMsg('COM12114', 'CNTR No')) ;
    		    formObj.cntr_no.focus() ;
    		    return ;
    		}
    		else if(!chkLen(formObj.cntr_no, 11)){
              	ComShowMessage(ComGetMsg('SCE90026', 'CNTR No', 11)) ;
                formObj.cntr_no.focus() ;
              	return false ;
            }
            */
//            if(chkLen(formObj.cntr_no, 11)){
//        		formObj.cop_no.value = "" ;
//        		formObj.target = "_self" ;
//        		formObj.f_cmd.value  = SEARCHLIST;
//        		formObj.action       = "ESD_SCE_006.do" ;
//        		formObj.submit();
//            }
    	//}
    }

    function CheckDigit(obj){
        var rtnval = cntrCheckDigit(obj);
        obj.value  = rtnval;
    }

    function openAddPaste(dist){
    	window.open ("ESD_SCE_0064.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=400,height=390");
    }

     function openexptrsnPopUp(dist){
        //alert("openexptrsnPopUp:"+dist);
        var addpara;
        if(dist=="expt_rsn_inq"){
            addpara = '&rsncd='+document.form.expt_rsn_inq_cd.value;
        }
        if(dist=="expt_rsn"){
            addpara = '&insrtcd='+document.form.expt_rsn_cd.value;
        }
        //alert("addpara:"+addpara);
    	window.open ("ESD_SCE_0108.do?dist="+dist+addpara, "list", "scrollbars=no,fullscreen=no,width=770,height=320");
    }

    function addValueNo(dist, multi_value){
    	var multis = multi_value.split('\n');
    	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
    		if(multis[i] != ''){
    			if(i == 0){
    				multi_value = multis[i];
    			}else{
    				multi_value = multi_value + ',' + multis[i];
    			}
       		}
    	}
    	if(multi_value != ''){
//        		if(document.getElementById(dist).value != ''){
//        			document.getElementById(dist).value = document.getElementById(dist).value + ',' + multi_value;
//        		}else{
    			document.getElementById(dist).value = multi_value;
//        		}
    	}
    }

    function openESD_SCE_102_NEW( sheetObj, formObj) {
    	var chkcnt = sheetObj.CheckedRows(0);

    	if( chkcnt < 1) {
    		ComShowMessage('Please select at least one.');
    		return false;
    	}

    	var sRow = sheetObj.FindCheckedRow("r_chk");
    	var arrRow = sRow.split("|");
    	var szResult ="";

    	for ( idx =0; idx < arrRow.length -1 ; idx++) {
    		if(szResult.length > 0) szResult = szResult + ",";

    		szResult = szResult + sheetObj.CellValue( arrRow[idx], "r_cop_expt_no");

    	}

    	formObj.f_cmd.value = COMMAND01 ;

    	var newForm = "" ;

    	newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='send_val' value='" + szResult + "'>" ;
    	newForm += "</form>";

    	document.all.new_form.innerHTML = newForm ;
    	var formObj = document.form1 ;
    	var newWin  = window.open("","mailPopup", "width=480,height=300");
    	formObj.action = "/opuscntr/ESD_SCE_0102.do" ;
    	formObj.target = "mailPopup" ;
    	formObj.submit() ;

    }
     function openESD_SCE_102(sheetObj, formObj){

    	var chkcnt = sheetObj.CheckedRows(0);
//    	alert("chkcnt"+chkcnt);

    	if(chkcnt < 1){
    		ComShowMessage('Please select at least one.');

    		return false;
    	}

    	var sRow = sheetObj.FindCheckedRow("r_chk");

    	var arrRow = sRow.split("|");

    	var szResult = "" ;

      	for (idx=0; idx<arrRow.length-1; idx++){

      		szResult = szResult + sheetObj.CellValue( arrRow[idx], "r_cop_expt_no")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_bkg_no")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_bkg_no_split")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_bl_no")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cop_no")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cntr_no")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cop_expt_tp_nm")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cop_expt_tp_dtl_nm")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cop_expt_sts")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cop_expt_rsn")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_shipper")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_consignee")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_notify")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_vvd")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_act_cd1_nm")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_act_cd2_nm")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_por")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_pol")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_pod")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_del")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_occr_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_occr_ofc_cd")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_occr_loc_cd")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_rslv_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_dly_tm")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_fm_act_cd")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_fm_estm_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_fm_act_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_fm_upd_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_to_act_cd")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_to_estm_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_to_act_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_to_upd_dt")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cfm_flg")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cfm_id")+"|"+
    		sheetObj.CellValue( arrRow[idx], "r_cfm_dt");

    		if( idx < arrRow.length-2) {
    		szResult = szResult +";";
    		}
      	}
//      	alert(szResult);
    	formObj.f_cmd.value = COMMAND01 ;
    //alert("1");
//    	var row = sheetObj.SelectRow  ;
//    	var bkgNo      = sheetObj.CellValue(row, "r_bkg_no") ;
//    	var bkgNoSplit = sheetObj.CellValue(row, "r_bkg_no_split") ;
//    	var copno = sheetObj.CellValue(row, "cop_no") ;

    	var newForm = "" ;

    	newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='send_val' value='" + szResult + "'>" ;
    	newForm += "</form>";
    //alert("2");
    	document.all.new_form.innerHTML = newForm ;
    //alert("3");
    	var formObj = document.form1 ;
    //alert("4");
//    	var formObj = newForm ;
    	var newWin  = window.open("","mailPopup", "width=480,height=300");
    //alert("5");
    	formObj.action = "/opuscntr/ESD_SCE_0102.do" ;
    //alert("6");
    	formObj.target = "mailPopup" ;
    //alert("7");
    	formObj.submit() ;
    //alert("8");
    }



    function addColDesc(coldesc1, chkcnt, iCheckRow){
//        alert("coldesc1:"+coldesc1+"chkcnt:"+chkcnt+"iCheckRow:"+iCheckRow);
    	if(coldesc1 != ''){
            document.getElementById('coldesc1').value = coldesc1;
    	}
    	if(chkcnt != ''){
            document.getElementById('chkcnt').value = chkcnt;
    	}
    	if(iCheckRow != ''){
            document.getElementById('iCheckRow').value = iCheckRow;
    	}

    	for(i=0;i<sheetObjects.length;i++){

    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    }

    function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    	var formObj = document.form ;
    //alert("PageNo:"+PageNo+" OnePageRow:"+OnePageRow+" RowCount:"+sheetObj.RowCount+" totcnt:"+eval(formObj.totcnt.value));
        if (sheetObj.RowCount >= OnePageRow && sheetObj.TotalRows > sheetObj.RowCount){
        //if (sheetObj.RowCount >= OnePageRow){
        	selectVal = SceFrmQryString(formObj)+"&" + ComGetPrefixParam("r_");
    		formObj.f_cmd.value = SEARCHLIST ;
    		PageNo = Math.ceil(sheetObj.SearchRows/3000)+1;
        //alert("sheetObj.SearchRows"+sheetObj.SearchRows+"TotalRows :"+sheetObj.TotalRows +"sheetObj.RowCount:"+sheetObj.RowCount+"PageNo:"+PageNo+"OnePageRow:"+OnePageRow);
        	sheetObj.DoSearch4Post("ESD_SCE_0120GS.do", selectVal, "i_page=" + PageNo, true);
//    			sheetObj.DoSearch4Post("ESD_SCE_111GS.do", SceFrmQryString(formObj));

        }
    }


    function fun_getExptTP() {

    		var url = "ESD_SCE_0120GS.do?f_cmd="+SEARCH12;
    		createHttpRequest();
    		request.open("GET", url, true);

    		request.onreadystatechange = subExptTp;

    		request.send(null);

    }

    function subExptTp() {

    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) {
    			var docXml = request.responseXML;
    			
    			var dataXml = docXml.getElementsByTagName("DATA");
    			var rowXml = docXml.getElementsByTagName("TR");
    			
    			//if(rowXml==undefined){
    				
    			//var d_row = dataXml[0].getAttribute("COLORDER").split("|");
    			
    			//var d_row = dataXml[0].getAttribute("COLORDER");
    			
    			if(dataXml[0].getAttribute("COLORDER") != undefined){
    				d_row = dataXml[0].getAttribute("COLORDER").split("|");
    			}
    			
    			//alert(d_row.length)
    			
    			var codeXml = null;
    			var nameXml = null;

    			var text_effS = "";
    			var text_effM = "";
    			var text_effE = "";

    			text_effS = "<select style=\"width:150;\" name=\"i_exptdtl_type\" >";
    			
    					
    			if( rowXml.length > 0 ){

    				for( var i = 0; i < rowXml.length; i++ ) {

    			
    					var c_row = rowXml[i].childNodes[0].nodeValue.split("�쒋삛");
    					//alert(c_row.length);
    					
    					var c_text="";
    					
    					for( var j = 0; j < d_row.length; j++ ) {
    						if(d_row[j]=="expt_cd_nm"){
    							c_text =c_row[j]; 
    						}
    					}
    				
    					if( i == 0){
    						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
    						text_effM = text_effM + "<OPTION value=\"" + c_text + "\" >"+c_text+"</OPTION>";
    					}else{
    						text_effM = text_effM + "<OPTION value=\"" + c_text + "\" >"+c_text+"</OPTION>";
    					}
    				}
    			}

    			text_effE = "</SELECT>";

    			if( text_effM.length < 1 ) {
    				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
    			}

    			document.form.all.ExptDTLTPDiv.innerHTML = text_effS+text_effM+text_effE;
    		}

    	}

    }


      
    function subExptDTLTp() {


    	if( request.readyState == 4 ) {
    		if( request.status == 200 ) {
    			var docXml = request.responseXML;
    			
    			var dataXml = docXml.getElementsByTagName("DATA");
    			var rowXml = docXml.getElementsByTagName("TR");
    			
    			if(dataXml[0].getAttribute("COLORDER") != undefined){
    				var d_row = dataXml[0].getAttribute("COLORDER").split("|");
    			}
    			//alert(d_row.length)
    			
    			var codeXml = null;
    			var nameXml = null;

    			var text_effS = "";
    			var text_effM = "";
    			var text_effE = "";

    			text_effS = "<select style=\"width:150;\" name=\"i_exptdtl_type\" >";
    	
    					
    			if( rowXml.length > 0 ){

    				for( var i = 0; i < rowXml.length; i++ ) {

    			
    					var c_row = rowXml[i].childNodes[0].nodeValue.split("�쒋삛");
    					//alert(c_row.length);
    					
    					var c_text="";
    					
    					for( var j = 0; j < d_row.length; j++ ) {
    						if(d_row[j]=="expt_cd_nm"){
    							c_text =c_row[j]; 
    						}
    					}
    				
    					if( i == 0){
    						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
    						text_effM = text_effM + "<OPTION value=\"" + c_text + "\" >"+c_text+"</OPTION>";
    					}else{
    						text_effM = text_effM + "<OPTION value=\"" + c_text + "\" >"+c_text+"</OPTION>";
    					}
    				}
    			}

    			text_effE = "</SELECT>";

    			if( text_effM.length < 1 ) {
    				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
    			}

    			document.form.all.ExptDTLTPDiv.innerHTML = text_effS+text_effM+text_effE;
    		}
    	}

    }    

    function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    {
         if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act_cd") || sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act_cd")){
    //alert("alert(OnMouseMove);");

                 
//                sheetObj.MousePointer = "Default";  
                  sheetObj.MousePointer = "Hand";     
                  var sText="";
                  if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act_cd")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd1_nm");
                  else if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act_cd")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd2_nm");
               	  //sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
                  //�띿꽑�꾩�留�留뚮뱾湲�
              	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
         }

    }
    
    
      function goESD_SCE_044(sheetObj){
    	var row = sheetObj.SelectRow  ;
    //alert("SCE_044:"+row);
    	if(row==0){
      		ComShowMessage(ComComGetMsg('SCE90018'));
      		return ;
      	}

        var cntrNO      = sheetObj.CellValue(row, "r_cntr_no") ;

      	newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='cntr_no' value='" + cntrNO + "'>" ;
        newForm += "</form>"
    //alert("newForm:"+newForm);
        document.all.new_form.innerHTML = newForm ;

        var formObj = document.form1 ;
//        var newWin  = window.open("","clm_win", "width=771,height=525," + getCenterXY(755, 500));
        var newWin  = window.open("","clm_win", "width="+screen.width+",height=525," + getCenterXY(screen.width, 500));
        formObj.action = "/opuscntr/ESD_SCE_0044.do" ;
        formObj.target = "clm_win" ;
        formObj.submit() ;

    	    //newWin.focus() ;

    }
      
      
      
    function goESD_SCE_006(sheetObj) {
    //alert("openESD_SCE_006 start");
    	var chkCnt = sheetObj.CheckedRows("r_chk") ;
//    	alert(chkCnt);

    	if( chkCnt==0 ) {
    		ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
    		return false ;
    	}

    	var chkRows = sheetObj.FindCheckedRow("r_chk") ;
    	var arrChkRows = chkRows.split("|") ;
    	var newForm = "" ;

//    	alert("chkRows:"+chkRows+"arrChkRows:"+arrChkRows+"="+arrChkRows[0]);
//    	alert(sheetObj.CellValue(arrChkRows[0], "r_cop_no"));
    //alert(sheetObj.CellValue(arrChkRows[0], "r_bkg_no"));
    //alert(sheetObj.CellValue(arrChkRows[0], "r_bkg_no_split"));
    //alert(sheetObj.CellValue(arrChkRows[0], "r_cntr_no"));

    	var newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(arrChkRows[0], "r_cop_no") + "'>" ;
    	newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[0], "r_bkg_no") + "'>" ;
    	newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[0], "r_bkg_no_split") + "'>" ;
    	var cntr_no = sheetObj.CellValue(arrChkRows[0], "r_cntr_no");
    	if ( cntr_no.length <=0)
    		cntr_no="COMU0000000";
    	newForm += "  <input type='hidden' name='cntr_no'      value='" + cntr_no + "'>" ;
    	newForm += "</form>";
//    	alert("newForm:"+newForm);
    	document.all.new_form.innerHTML = newForm ;
    	//alert(newForm);
    	//document.all.new_form.innerHTML = newForm ;
//    	alert("1");

    	var formObj = document.form1;
//    	alert("2");
    	var newWin  = window.open("","copdetail_win","width="+1100+",height=525," + getCenterXY(300, 500));
    	formObj.action = "/opuscntr/ESD_SCE_0006.do";
//    	alert("3");
        formObj.target = "copdetail_win" ;
    	formObj.submit() ;
//    	alert("4");
    	/*document.all["tdStatus"].innerHTML = document.all["mailStatusCodeHTML"].innerHTML;
        	formObj.f_cmd.value = COMMAND01;
            formObj.target = "iframe_rdsend";
            formObj.action = "monitorRdSendCommon.do?"+selectVal;
            formObj.submit();
    */
    }

    function addEdiStsNo(por_cd){
        	if(por_cd != ''){
//        		if(document.getElementById('vvd').value != ''){
//        			document.getElementById('vvd').value = document.getElementById('vvd').value + ',' + vvds;
//        		}else{
        			document.getElementById('por_cd').value = por_cd;
//        		}
        	}
        }

    /**
     *  LOC(ROR/POL/POD/EDL) pop-up Open &&&
     *
     * @param multi multi check 
     * @param custCd Customer Code
     * @param custNm Customer Name
     * @param ofcCd Sales Office
     * @param custSgmt Segmentation
     * 2008.6.24 LOC(ROR/POL/POD/EDL)pop-up add
     */
    function openLocPopUp(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
                        locState, locEqOfc, locPortInd, sysCode){
    	var param   = "" ;
    	var display = getCommPopDisplay(multi) ;

    	param  = "?classId=" + getCommPopClassId() ;
    	param += getURLParam(multi, "conti_cd",     contiCd) ;
    	param += getURLParam(multi, "sconti_cd",    scontiCd) ;
    	param += getURLParam(multi, "cnt_cd",       cntCd) ;
    	param += getURLParam(multi, "loc_state",    locState) ;
    	param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
    	param += getURLParam(multi, "loc_cd",       locCd) ;
    	param += getURLParam(multi, "loc_desc",     locDesc) ;
    	param += getURLParam(multi, "loc_port_ind", locPortInd) ;

    	ComOpenPopup('/opuscntr/ESD_SCE_0109.do' + param, 800, 500, 'setValFromLocPop', display) ;
    	contiCdFld    = contiCd ;
    	scontiCdFld   = scontiCd ;
    	cntCdFld      = cntCd ;
    	locStateFld   = locState ;
    	locEqOfcFld   = locEqOfc ;
    	locCdFld      = locCd ;
    	locDescFld    = locDesc ;
    	locPortIndFld = locPortInd ;
    	sysCodeFld    = sysCode ;
    	multiChkYN    = multi
    }

    // (RCC/LCC/ECC/SCC) pop-up Open  &&&
    function openRccPopUp(multi, dist){
    	window.open ("ESD_SCE_0110.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=800,height=410");
    }

     function rtn_ExptRsn_code(strval) {
        //alert("rtn_ExptRsn_code:"+strval);
    	document.form.expt_rsn_inq_cd.value = "";
    	document.form.expt_rsn_inq.value = "";

        if(strval!="CLR"){
        var arrstr0 = strval.split(",");

    for( var k = 0; k < arrstr0.length ; k++){
         var arrstr = arrstr0[k].split(";");
             if(document.form.expt_rsn_inq_cd.value==""){
            	document.form.expt_rsn_inq_cd.value = arrstr[0];
            	document.form.expt_rsn_inq.value = arrstr[1];
             }else{
            	document.form.expt_rsn_inq_cd.value = document.form.expt_rsn_inq_cd.value + "," + arrstr[0];
            	document.form.expt_rsn_inq.value = document.form.expt_rsn_inq.value + "," + arrstr[1];
             }
         }
    }

         //alert("expt_rsn_inq:"+document.form.expt_rsn_inq.value+ "  cd:"+document.form.expt_rsn_inq_cd.value);

//        var arrstr = strval.split(";");
//        //alert("arrstr[0]:"+arrstr[0]+" arrstr[1]:"+arrstr[1]);
//    	//document.form.expt_rsn_inq.value = strval;
//    	document.form.expt_rsn_inq_cd.value = arrstr[0];
//    	document.form.expt_rsn_inq.value = arrstr[1];
    	//alert("cd:"+document.form.expt_rsn_inq_cd.value+" vl:"+document.form.expt_rsn_inq.value);
    }
    function rtn_ExptRsnIns_code(strval) {
        //alert("rtn_ExptRsnIns_code:"+strval);
        var arrstr = strval.split(";");
        //alert("Ins:"+strval.split(";",2));
    	document.form.expt_rsn_cd.value = arrstr[0];
    	document.form.expt_rsn.value = arrstr[1];
        //alert("rtn_ExptRsnIns_code:"+arrstr[0]+"::"+arrstr[1]);
    }
    function rtn_vvd_code(strval) {
    	document.form.vvd.value = strval;
    }

    function rtn_pol_code(strval) {
    	document.form.pol_cd.value = strval;
    }

	