var sheetObjects = new Array();
var sheetCnt = 0;

/**
     * @fileoverview .
     * @author 
     */

    /**
     * @extends 
     * @class ESD_SCE_0011 : business script for ESD_SCE_0011 
     */
    function ESD_SCE_0011() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    
    /**
         * registering IBTab Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++] = tab_obj;
        }

        /**
         * registering Combo Object as list
         */    
    	function setComboObject(combo_obj){
    		comboObjects[comboCnt++] = combo_obj;
    	}
    	
        /**
         * initializing Tab
         * setting Tab items.
         */
        function initTab(tabObj , tabNo) {

             switch(tabNo) {
                 case 1:
                    with (tabObj) {

                        var cnt  = 0 ;
                        InsertTab( cnt++ , "Particular I" , -1 );
                        InsertTab( cnt++ , "Particular II" , -1 );
                        InsertTab( cnt++ , "Dock Plan" , -1 );
                    }
               		break;
             }
        }


        /**
         * Event when clicking Tab
         * activating selected tab items.
         */
        function tab1_OnChange(tabObj , nItem)
        {
            var objs = document.all.item("tabLayer");
            var formObject = document.form;

    	    objs[nItem].style.display = "Inline";
    	    objs[beforetab].style.display = "none";

    	    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	    beforetab= nItem;
    	    
            switch(nItem) {
        		case 0:
        			comboObjects[0].RemoveAll();
        			comboObjects[0].Enable = false;
        			break;
        		case 1:
        			comboObjects[0].RemoveAll();
        			comboObjects[0].Enable = false;
        			break;
        		case 2:
        			comboObjects[0].RemoveAll();
        			comboObjects[0].Enable = true;
        			initCombo(comboObjects[0], 1);          		
        			break;
            }
    	    
        }


          
        
/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	 var sheetObj = sheetObjects[0];
	 var formObj  = document.form;
//	try{
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

			// CLM button Add &&&
	  		case "btn_clm":
			     if(validateCLM(sheetObj,formObj,"LINKCLM")){
			 	       goESD_SCE_0044(sheetObj) ;
			     }
				break;

			case "btn_send" :
				//openESD_SCE_0102(sheetObj, formObj);
				openESD_SCE_0102_NEW(sheetObj, formObj);
				break;

			case "btn_copdetail" :
			     if(validateETC(sheetObj,formObj,"LINKCOP")){
			 	       goESD_SCE_0006(sheetObj);
			     }
				break;

			case "btn_bkg_calendar":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_fm_dt, 'bkg_fm_dt',formObj.bkg_to_dt, 'bkg_to_dt', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.bkg_fm_dt, formObj.bkg_to_dt, 'yyyy-MM-dd');
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
//				window.open( 'ESD_SCE_0104.do',"scPopup","top=100, left=50, width=800,height=450") ;
				var newWin = window.showModalDialog("ESD_SCE_0104.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:450px");
				break;
			case "btn_scpopup" :
//				window.open('ESD_SCE_0105.do',"scPopup","top=200, left=200, width=500,height=420") ;
				var newWin = window.showModalDialog("ESD_SCE_0105.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:420px");
				break;

			case "btn_occr_ofc" :

					var selofc_cd = formObj.occr_ofc.value;
					//selofc_cd="LE";
//					ComOpenWindow('ESD_SCE_0910.screen?sel_ofc_cd='+selofc_cd, 'ESD_SCE_0910', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
					var newWin = window.showModalDialog("ESD_SCE_0910.do?sel_ofc_cd="+selofc_cd, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:410px;dialogHeight:400px");
				break;

			case "btn_confirm" :
			      if(validateForm(sheetObj, formObj, IBSEARCH_ASYNC01)){
			         doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
			      }
				break;

		}
//	}catch(e){
//		if( e == "[object Error]") {
//			ComShowMessage(ComGetMsg('COM12111')) ;
//		} else {
//			ComShowMessage(e);
//		}
//	}

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
		//ComConfigSheet(sheetObjects[i]);
		var formObject = document.form;
		var RptInfoCtnt = formObject.RptInfoCtnt.value;
		if(RptInfoCtnt > 0){
			var chkcnt = 0;
			for(var i = 1; i < RptInfoCtnt.length ; i++){
				var RptInfoCtnt2 = RptInfoCtnt.substring(i, i+1);
				if(RptInfoCtnt2 == "1"){
					chkcnt++;
				}
			}
			chkcnt=chkcnt+1;
		   	var chkrow = 0;
		   	var coldesc1="";
		   	var strcoldesc = "Exception No.,BKG No,Container No.,B/L No.,COP No.,Exception Type,Exception Type Detail,Exception Status,Exception Reason,Shipper,Consignee,Notify,VVD,POR,POL,POD,DEL,Occurred Date/Time,Occurred Office,Occurred Node,Resolved Date,Delay Time,Activity,Estimated Date/Time,Actual Date/Time,Updated Date/Time,Activity,Estimated Date/Time,Actual Date/Time,Updated Date/Time,Activity,Estimated Date/Time,Actual Date/Time,Updated Date/Time,Confirm,Confirm ID,Confirm Date,Remark";    //return Exception Inquiry
		   	for(var a = 0 ; a < RptInfoCtnt.length ; a++){
		   	var RptInfoCtnt2 = RptInfoCtnt.substring(a, a+1);
		   		if(RptInfoCtnt2 == "1"){
		   			coldesc1 = coldesc1 + ',' +strcoldesc.split(',')[a];
				}
		   	}
		   	var iCheckRow = '';
		   	for(var a = 0 ; a < RptInfoCtnt.length ; a++){
		   	var RptInfoCtnt2 = RptInfoCtnt.substring(a, a+1);
		   		if(RptInfoCtnt2 == "1"){
		   			iCheckRow = iCheckRow + '|' +formObject.iCheckRow.value.split('|')[a];
				}
		   	}
			iCheckRow = iCheckRow + '|'
			//alert("coldesc1:"+coldesc1+" \n chkcnt:"+chkcnt+" \n iCheckRow:"+iCheckRow);

			addColDesc(coldesc1, chkcnt, iCheckRow);
		}else{
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//ComEndConfigSheet(sheetObjects[i]);
	}


    //document.all['h_expt_tp'].selectedIndex = document.form.expt_tp_selected_idx.value;

    fun_getExptTP();
    
    initControl();

}

/* initControl() */
        function initControl() {
        	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
        	axon_event.addListenerFormat('keyup', 'obj_blur', form);
        }
        
        function clearCustName(obj){
        	if(obj.value == "") form.cust_nm.value="";
        }
        
        /** 
         * @param  
         * @return 
         * @author 
         * @version 
         */ 
        function obj_keypress(){
         	obj = event.srcElement;
         	if(obj.dataformat == null) return;
         	 	
         	window.defaultStatus = obj.dataformat;
         	 
         	switch(obj.dataformat) {
         	    case "engup":
         	        ComKeyOnlyAlphabet('upper');
         	        break;
         	}
        }    
        
        /** 
         * @param  
         * @return 
         * @author 
         * @version 
         */ 
        function obj_keyup(){
        	
        	var formObj = document.form;
         	obj = event.srcElement;
         	
         	if(obj.dataformat == null) return;
         	 	
         	window.defaultStatus = obj.dataformat;
         	 
         	switch(obj.dataformat) {
         	    case "engup":
         	        if(document.form.vsl_cd.value.length == 4 ){
         	        	//loc_cd_onchange();
        	    		formObj.f_cmd.value = SEARCH02;
        	    		var sXml = sheetObjects[2].GetSearchXml("VOP_OPF_0003GS.do", SceFrmQryString(formObj));
        	    		var sVslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
        	    		if(sVslEngNm=="null" || sVslEngNm==null || sVslEngNm==""){
        	    			formObj.vsl_eng_nm.value = "";
        	    		}else{
        	    			formObj.vsl_eng_nm.value = sVslEngNm;
        	    		}
         	        }
         	        break;
         	}
        }   
        
        
   /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var  xs1 = document.form.coldesc1.value;
	var  xs3 = document.form.iCheckRow.value;
	var  xs4 = document.form.chkcnt.value;

	var sheetID = sheetObj.id;
	
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {

                	var aryRows;
					if (xs3.length > 0){
						//alert(xs3);
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
				InitRowInfo( 2, 1,  9, document.form.pagerows.value);

				//setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(42, 5, 0, true);

				// setting function handling header
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " |SEQ|Ibflag|Exception No.|BKG No.|Container No.|B/L No.|COP No.|Exception Type|Exception Type|Exception Type Detail|Exception Type Detail|Exception Status|Exception Reason|Shipper|Consignee|Notify|VVD|POR|POL|POD|DEL|Occurred Date/Time|Occurred Office|Occurred Node|Resolved Date|Delay Time|From|From|From|From|To|To|To|To|Confirm|Confirm ID|Confirm Date|Remark" ;
				var HeadTitle2 = " |SEQ|Ibflag|Exception No.|BKG No.|Container No.|B/L No.|COP No.|Exception Type|Exception Type|Exception Type Detail|Exception Type Detail|Exception Status|Exception Reason|Shipper|Consignee|Notify|VVD|POR|POL|POD|DEL|Occurred Date/Time|Occurred Office|Occurred Node|Resolved Date|Delay Time|Activity|Estimated Date/Time|Actual Date/Time|Updated Date/Time|Activity|Estimated Date/Time|Actual Date/Time|Updated Date/Time|Confirm|Confirm ID|Confirm Date|Remark" ;

                //DataRowMerge(0) = true;
                //DataRowMerge(1) = true;

				//setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle2, true);

				//Data attributes	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,  20,	daCenter,  true,		"chk",				false,		  "",	   dfNone,   	0,	 		true ,	   true);
				InitDataProperty(0, cnt++ , dtStatus,     0,	daCenter,  true,		"ibflag",			    false,		  "",	   dfNone,   	0,			true,	   true);
				InitDataProperty(0, cnt++ , dtSeq,	     30,	daCenter,  true,	"seq",			    false,		  "",	   dfNone,   		0,		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"cop_expt_no",		false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	100,	daCenter,  true,	"bkg_no",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				//InitDataProperty(0, cnt++ , dtData,	   	 20,	daCenter,  true,	"bkg_no_split",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"cntr_no",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"bl_no",				false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   	120,	daCenter,  true,	"cop_no",				false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,  true,		"cop_expt_tp_cd",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		200,	daCenter,  true,	"cop_expt_tp_nm",		false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,  true,		"cop_expt_tp_dtl_cd",	false,		  "",	   dfNone,   	0,	 		false,	   false);

				InitDataProperty(0, cnt++ , dtData,		300,	daCenter,  true,	"cop_expt_tp_dtl_nm",	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"cop_expt_sts_nm",	    false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		200,	daCenter,  true,	"cop_expt_rsn_cd",	    false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"shipper",    		false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"consginee",	        false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"notify",	        	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"vvd",            	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"por_cd",	         	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"pol_cd",	            false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"pod_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);

				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"del_cd",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		150,	daCenter,  true,	"occr_dt",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"cre_ofc_cd",		false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"occr_loc_cd",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		150,	daCenter,  true,	"rsolv_dt",	        false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		150,	daCenter,  true,	"dly_tm",				false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"fm_act_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"fm_estm_dt",			false,		  "",	   dfNone,      0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"fm_act_dt",			false,		  "",	   dfNone,      0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"fm_upd_dt",	   	    false,		  "",	   dfNone,   	0,	 		false,	   false);

				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,  true,	"to_act_cd",			false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"to_estm_dt",			false,		  "",	   dfNone,      0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"to_act_dt",			false,		  "",	   dfNone,      0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"to_upd_dt",		    false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"cop_expt_cfm_flg",			false,		  "",	   dfNone,      0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"cop_expt_cfm_usr_id",	    		false,		  "",	   dfNone,      0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  true,	"cfm_dt",  		    false,		  "",	   dfNone,   	0,	 		false,	   false);

                InitDataProperty(0, cnt++ , dtData,     300,    daCenter,  true,   "remark",             false,        "",      dfNone,     	0,          true,      true);

                InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "act_cd1_nm",         false,        "",      dfNone,     	0,          false,     false);
                InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,   "act_cd2_nm",         false,        "",      dfNone,     	0,          false,     false);
                InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,  true,	"expt_rsn",	        false,		  "",	   dfNone,   	0,	 		false,	   false);

                for(var k = 1; k < 39 ; k++){
//                    if (k==9 || k==11){	
//                    }else{
                        ColHidden(k)=true;
//                    }
                }
                
                

				for( var k = 0; k < aryRows.length ; k++){
//					if(aryRows[k]=='2') alert("cop_expt_no");
				    //1	2	Exception No.
    				if (aryRows[k] == '1') {
    					//ColHidden(2)=false;
    					ColHidden(3)=false;
    				}	
    				//2	3	BKG No
                    //2	4	BKG No
    				if (aryRows[k] == '2'){
    				     //ColHidden(3)=false;
    				     ColHidden(4)=false;
    				}
    				//3	5	B/L No.
    				if (aryRows[k] == '3') ColHidden(5)=false;
    				//4	6	COP No.
    				if (aryRows[k] == '4') ColHidden(6)=false;
    				//5	7	Container No.
    				if (aryRows[k] == '5') {ColHidden(7)=false;}//alert(sheetObj.ColSaveName(7));}
    				//6	8	Exception Type
                    //6	9	Exception Type
    				if (aryRows[k] == '6'){
    				    ColHidden(9)=false;
    				}
    				//7	10	Exception Type Detail
                    //7	11	Exception Type Detail
    				if (aryRows[k] == '7'){
    				    ColHidden(11)=false;
    				}
    				//8	12	Exception Status
    				if (aryRows[k] == '8') ColHidden(12)=false;
    				//9	13	Exception Reason
    				if (aryRows[k] == '9') ColHidden(13)=false;
    				//10	14	Shipper
    				if (aryRows[k] == '10') ColHidden(14)=false;

                    //11	15	Consignee
    				if (aryRows[k] == '11') ColHidden(15)=false;
    				//12	16	Notify
    				if (aryRows[k] == '12') ColHidden(16)=false;
    				//13	17	VVD
    				if (aryRows[k] == '13') ColHidden(17)=false;
    				//14	18	POR
    				if (aryRows[k] == '14') ColHidden(18)=false;
    				//15	19	POL
    				if (aryRows[k] == '15') ColHidden(19)=false;
    				//16	20	POD
    				if (aryRows[k] == '16') ColHidden(20)=false;
    				//17	21	DEL
    				if (aryRows[k] == '17') ColHidden(21)=false;
    				//18	22	Occurred Date/Time
    				if (aryRows[k] == '18') ColHidden(22)=false;
    				//19	23	Occurred Office
    				if (aryRows[k] == '19') ColHidden(23)=false;
    				//20	24	Occurred Location
    				if (aryRows[k] == '20') ColHidden(24)=false;
                    //21	25	Resolved Date
    				if (aryRows[k] == '21') ColHidden(25)=false;
    				//22	26	Delay Time
    				if (aryRows[k] == '22') ColHidden(26)=false;
    				//23	27	Activity
    				if (aryRows[k] == '23') ColHidden(27)=false;
    				//24	28	Estimated Date/Time
    				if (aryRows[k] == '24') ColHidden(28)=false;
    				//25	29	Actual Date/Time
    				if (aryRows[k] == '25') ColHidden(29)=false;
    				//26	30	Updated Date/Time
    				if (aryRows[k] == '26') ColHidden(30)=false;
    				//27	31	Activity
    				if (aryRows[k] == '27') ColHidden(31)=false;
    				//28	32	Estimated Date/Time
    				if (aryRows[k] == '28') ColHidden(32)=false;
    				//29	33	Actual Date/Time
    				if (aryRows[k] == '29') ColHidden(33)=false;
    				//30	34	Updated Date/Time
    				if (aryRows[k] == '30') ColHidden(34)=false;
                    //31	35	Confirm
    				if (aryRows[k] == '31') ColHidden(35)=false;
    				//32	36	Confirm ID
    				if (aryRows[k] == '32') ColHidden(36)=false;
    				//33	37	Confirm Date
    				if (aryRows[k] == '33') ColHidden(37)=false;
    				//34	38	Confirm Date
    				if (aryRows[k] == '34') ColHidden(38)=false;

				}

				style.height = GetSheetHeight(12) ;
				DataLinkMouse = true;


		   }
			break;

	}
}

function sheet1_OnDblClick(sheetObj, row, col, value) {
	var newForm = "" ;

	if( sheetObj.ColSaveName(col) == "cop_no") {

		newForm += "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='bkg_no'      value='" + sheetObj.CellValue(row, "bkg_no") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(row, "bkg_no_split") + "'>" ;
		newForm += "  <input type='hidden' name='cop_no' value='" + sheetObj.CellValue(row, "cop_no") + "'>" ;
		newForm += "  <input type='hidden' name='bl_no' value='" + sheetObj.CellValue(row, "bl_no") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(row, "cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='vvd'      value='" + sheetObj.CellValue(row, "vvd") + "'>" ;
		newForm += "  <input type='hidden' name='por'      value='" + sheetObj.CellValue(row, "por") + "'>" ;
		newForm += "  <input type='hidden' name='pol'      value='" + sheetObj.CellValue(row, "pol") + "'>" ;
		newForm += "  <input type='hidden' name='pod'      value='" + sheetObj.CellValue(row, "pod") + "'>" ;
		newForm += "  <input type='hidden' name='del'      value='" + sheetObj.CellValue(row, "del") + "'>" ;
		newForm += "</form>" ;

		document.all.new_form.innerHTML = newForm ;

		var formObj = document.form1 ;
		var paramUrl = "pgmNo=ESD_SCE_0101&cop_no="+sheetObj.CellValue(row, "cop_no")+"&bkg_no="+sheetObj.CellValue(row, "bkg_no")
						+"&bkg_no_split="+sheetObj.CellValue(row, "bkg_no_split")+"&bl_no="+sheetObj.CellValue(row, "bl_no")
						+"&cntr_no="+sheetObj.CellValue(row, "cntr_no")+"&vvd="+sheetObj.CellValue(row, "vvd")+"&por="+sheetObj.CellValue(row, "por_cd")
						+"&pol="+sheetObj.CellValue(row, "pol_cd")+"&pod="+sheetObj.CellValue(row, "pod_cd")+"&del="+sheetObj.CellValue(row, "del_cd");
        var newWin = window.showModalDialog("ESD_SCE_0101.do?"+paramUrl, "bkg_info_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:400px");
//		var newWin  = window.open("","cop_detail", "width=810,height=400," + getCenterXY(810, 400));
//		//ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'setValFromOfcPop', display) ;
//		formObj.action = "ESD_SCE_0101.do" ;
//		formObj.target = "cop_detail" ;
//		formObj.submit() ;
//		newWin.focus() ;
	} else if( sheetObj.ColSaveName(col) == "cop_expt_no")
	{
		newForm  = "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='f_cmd'>" ;
		newForm += "  <input type='hidden' name='cop_expt_no'	value='" + sheetObj.CellValue(row, "cop_expt_no") + "'>" ;
		newForm += "  <input type='hidden' name='cop_no'		 value='" + sheetObj.CellValue(row, "cop_no") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'		value='" + sheetObj.CellValue(row, "cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='cop_expt_tp_cd' value='" + sheetObj.CellValue(row, "cop_expt_tp_cd") + "'>" ;
		newForm += "  <input type='hidden' name='pgmNo'	value='ESD_SCE_0012'>" ;
		newForm += "</form>";
		
		document.all.new_form.innerHTML = newForm ;

		var formObj = document.form1 ;

		formObj.action = "ESD_SCE_0012.do";
		formObj.f_cmd.value = SEARCHLIST;
		formObj.submit() ;

	}
}

  // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false ;

	switch(sAction) {
	   case IBSEARCH:
			formObj.f_cmd.value = SEARCH01 ;
			formObj.target	  = "_self" ;
			sheetObj.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOSUM,NOSEQ";
			//sheetObj.DoSearch4Fx("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
			sheetObj.DoSearch4Fx("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
			break;

	   case IBDOWNEXCEL:
			  sheetObj.Down2Excel(-1, false, false, true);
			  break;

	   case IBSAVE:
                formObj.f_cmd.value = MULTI;
                
                 //var chkcnt = sheetObj.CheckedRows(0);
        	    //	for(var a = 0 ; a < chkcnt ; a++){
        	    //		chkrow = sheetObj.FindCheckedRow(0).split('|')[a];
                //		alert(sheetObj.CellValue(chkrow, "ibflag"));
            	//	}
            //alert(SceFrmQryString(formObj));
                //sheetObj.DoAllSave("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
                sheetObj.DoAllSave("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
                formObj.expt_rsn.value = "" ;
                formObj.expt_rsn_cd.value = "" ;
                formObj.f_cmd.value = SEARCH01;
                //sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
                sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
	          break;

       case IBSEARCH_ASYNC01:
                formObj.f_cmd.value = MULTI01;
                //sheetObj.DoAllSave("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
                sheetObj.DoAllSave("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
                formObj.f_cmd.value = SEARCH01;
//                sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
                sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", SceFrmQryString(formObj));
            break;

	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    var result = true;

	if(sAction == IBSEARCH) {

    	if(!isInputField(formObj)){
    		result = false ;
    	}
    	// BKG Date
    	else if(!ComIsEmpty(formObj.bkg_fm_dt) && ComIsEmpty(formObj.bkg_to_dt)){
    		ComShowMessage('Please input To BKG Date') ;
            formObj.bkg_to_dt.focus() ;
        	result = false ;
    	}
    	// BKG Date
    	else if(ComIsEmpty(formObj.bkg_fm_dt) && !ComIsEmpty(formObj.bkg_to_dt)){
//    	    alert("chk bkg date");
        	ComShowMessage('Please input From BKG Date') ;
            formObj.bkg_fm_dt.focus() ;
        	result = false ;
    	}
    	// BKG Date
		else if(!chkBkgDates(formObj)){
//    	alert("chkBkgDates");
			result = false ;
    	// BKG No
		}else if(!ComIsEmpty(formObj.bkg_no) ){
//    	alert("chk bkg No");
    	    if(formObj.bkg_no.value.length<11 && !chkLenth(formObj.bkg_no, 11, "BKG No")){
        		result = false ;
    	    }
    	}

    	// Container No
    	else if(!ComIsEmpty(formObj.cntr_no)){

    	    if(formObj.cntr_no.value.length<11 && !chkLenth(formObj.cntr_no, 11, "Container No.")){
        		result = false ;
    	    }
    	}
    	// COP No.
    	else if(!ComIsEmpty(formObj.cop_no)){
//    	alert("chk COP No.");
    	    if(formObj.cop_no.value.length<14 && !chkLenth(formObj.cop_no, 14, "COP No.")){
        		result = false ;
    	    }
    	}
    	// Exception No.
    	else if(!ComIsEmpty(formObj.expt_no)){
//    	alert("chk Exception No.");
    	    if(formObj.expt_no.value.length<14 && !chkLenth(formObj.expt_no, 14, "Exception No.")){
        		result = false ;
    	    }
    	}
    	// vvd 검색
    	else if(!ComIsEmpty(formObj.vvd)){
    	    if(formObj.vvd.value.length<9 && !chkLenth(formObj.vvd, 9, "VVD")){
        		result = false ;
//    	    }else if(formObj.vvd.value.length>9 && ComIsEmpty(formObj.cust_cnt_seq)){
//    	//alert("chk vvd2");
//        		ComShowMessage('Please input Customer') ;
//                formObj.cust_cnt_seq.focus() ;
//    	        result = false ;
    	    }
    	}else  if(!ComIsEmpty(formObj.por_cd) && formObj.por_cd.length < 0){
//    	alert("chk por");
	        result = false ;

	    }else  if(!ComIsEmpty(formObj.pol_cd) && formObj.pol_cd.length < 0){
//    	alert("chk pol");
	        result = false ;
    	// POD 멀티체크박스 &&&
	    }else  if(!ComIsEmpty(formObj.pod_cd) && formObj.pod_cd.length < 0){
//    	alert("chk pod");
	        result = false ;
    	// DED 멀티체크박스	 &&&
	    }else  if(!ComIsEmpty(formObj.del_cd) && formObj.del_cd.length < 0){
//    	alert("chk del");
	        result = false ;
	    }
		// Occurred DT
		else if(!chkOccDates(formObj)){
//    	alert("chkOccDates");
			result = false ;
		}
//    	alert("validateForm end:"+result);

	}else if(sAction == IBSAVE || sAction == IBSEARCH_ASYNC01) {
            if(sheetObj.CheckedRows("chk")>0){
                //alert("chk_row:"+sheetObj.CheckedRows("chk")+"::"+sheetObj.TotalRows);

                    var chkcnt = sheetObj.CheckedRows(0);
        	    	for(var a = 0 ; a < chkcnt ; a++){
        	    		chkrow = sheetObj.FindCheckedRow(0).split('|')[a];
        	    		//alert("chkrow:"+chkrow);
        	    		if(((formObj.expt_rsn_cd.value=="99") && sheetObj.CellValue(chkrow,"remark")=="") // reason 이 Others 인 경우 remark 가 없을 때
        	    		  ||(sheetObj.CellValue(i,"cop_expt_rsn")=="Others" && sheetObj.CellValue(i,"remark")=="")){
                        		ComShowMessage('Please Input Remark for Exception Reason Insert of Others') ;
                                sheetObj.FocusEditMode = 0;
                                a = chkcnt ;
                                result = false ;
        	    		}

//        	    		if(a == 0){
//        	    			coldesc1 = sheetObject.CellValue(chkrow, "coldesc1");
//        	    			//coldesc2 = sheetObject.CellValue(chkrow, "coldesc2");
//        	    		}else{
//        	    			coldesc1 = coldesc1 + ',' + sheetObject.CellValue(chkrow, "coldesc1");
//        	    			//coldesc2 = coldesc2 + ',' + sheetObject.CellValue(chkrow, "coldesc2");
//        	    		}
        	    	}


            }else if(ComIsEmpty(formObj.expt_rsn_cd)){
//		        alert("rsn ComIsEmpty");
        		ComShowMessage('Please select Exception Reason Insert') ;
                formObj.expt_rsn.focus() ;
            	result = false ;
		    }else if(sheetObj.CheckedRows("chk")<=0){
//		        alert("n CheckedRows");
        		ComShowMessage('Please check the CheckBox') ;
            	result = false ;
		    }

// else if(sAction == IBSEARCH_ASYNC01) {
//		    alert("IBSEARCH_ASYNC01");
//		    if(sheetObj.CheckedRows("chk")<=0){
//		        alert("n CheckedRows");
//       		ComShowMessage('Please check the CheckBox') ;
//            	result = false ;
//		    }

	}



	return result;
}

function validateETC(sheetObj,formObj,sAction){
    var result = true;
    if(sAction == "LINKCOP") {
        if(sheetObj.CheckedRows("chk")>1){
//		        alert("n CheckedRows");
        		ComShowMessage('Please check Only One Row') ;
            	result = false ;
        }
    }

	return result;
}

function validateCLM(sheetObj,formObj,sAction){
    var result = true;
    if(sAction == "LINKCLM") {
        if(sheetObj.CheckedRows("chk")<1){
        		ComShowMessage('Please check Only One Row') ;
            	result = false ;
        }else if(sheetObj.CheckedRows("chk")>1){
                ComShowMessage('Please check Only One Row') ;
                sheetObj.CheckAll("chk")=0;
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
//			    alert("checkbox");
				result = true ;
				break ;
			}
		}
		else if(fieldType!="hidden" && !formObj[i].readOnly && formObj[i].value!='O'){
		    //h_expt_tp  h_expt_tp_dtl
			if(!ComIsEmpty(formObj[i])){
				if(formObj[i].name=='delay_time' || formObj[i].name=='expt_cfm'){
					result = false ;
				}else{
			    	//alert("hidden:"+formObj[i].value+" name:"+formObj[i].name+" i:"+i);
					result = true ;
				}
				break ;
			}
		}
		else if(formObj.expt_rsn_inq_cd.value!=""){
		    result = true ;
		    break ;
		}

	}

	if(!result){
		ComShowMessage(ComGetMsg('SCE90016')) ;
        formObj.bkg_fm_dt.focus() ;
	}

	return result ;
}

//function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
//	var formObj = document.form ;
//	selectVal = SceFrmQryString(formObj);
//	sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", selectVal, "cur_page=" + PageNo, true);
//}

function chkVVD(formObj, ComIsEmptyVVD){
	var result   = true ;
	var emptyVVd = ComIsEmptyVVD!=null ? ComIsEmptyVVD : ComIsEmpty(formObj.vvd) ;

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
		case "bkg_no":
			if (col > newPos){
				 newPos = newPos+1;
			}

  			sheetObj.MoveColumnPos("bkg_no_split", newPos, false);
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

	if(ComGetLenByByte(obj.value)!=len){
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus() ;
        result = false ;
	}

	return result ;
}

function chkOccDates(formObj, ComIsEmptyBKGDates){
	var result        = true ;
	var emptyBKGDates = ComIsEmptyBKGDates!=null ? ComIsEmptyBKGDates :
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

function chkBkgDates(formObj, ComIsEmptyBKGDates){
	var result        = true ;
	var emptyBKGDates = ComIsEmptyBKGDates!=null ? ComIsEmptyBKGDates :
						ComIsEmpty(formObj.bkg_fm_dt)&&ComIsEmpty(formObj.bkg_to_dt) ;

	if(!emptyBKGDates){
		if(!ComIsDate(formObj.bkg_fm_dt)){
	        ComShowMessage(ComGetMsg('SCE90003','BKG Date')) ;
	        formObj.bkg_fm_dt.focus() ;
	        result = false ;
	    }
	    else if(!ComIsDate(formObj.bkg_to_dt)){
	        ComShowMessage(ComGetMsg('SCE90003','BKG Date')) ;
	        formObj.bkg_to_dt.focus() ;
	        result = false ;
	    }else{
    	    var dt1=formObj.bkg_fm_dt.value;
    	    var num1=dt1.replace(/-/g,"");
    	    var dt2=formObj.bkg_to_dt.value;
    	    var num2=dt2.replace(/-/g,"");

	        if(num1>num2){
    	        ComShowMessage(ComGetMsg('SCE90036','BKG Date')) ;
    	        formObj.bkg_fm_dt.focus() ;
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
    var rtnval = ComGetCntrNoFull(obj);
    obj.value  = rtnval;
}


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


function openESD_SCE_0006(sheetObj) {
//alert("openESD_SCE_0006 start");
	var chkCnt = sheetObj.CheckedRows("chk") ;
//	alert(chkCnt);

	if( chkCnt==0 ) {
		ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
		return false ;
	}

	var chkRows = sheetObj.FindCheckedRow("chk") ;
	var arrChkRows = chkRows.split("|") ;
	var newForm = "" ;

//	alert("chkRows:"+chkRows+"arrChkRows:"+arrChkRows+"="+arrChkRows[0]);
//	alert(sheetObj.CellValue(arrChkRows[0], "cop_no"));
//alert(sheetObj.CellValue(arrChkRows[0], "bkg_no"));
//alert(sheetObj.CellValue(arrChkRows[0], "bkg_no_split"));
//alert(sheetObj.CellValue(arrChkRows[0], "cntr_no"));

	var newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(arrChkRows[0], "cop_no") + "'>" ;
	newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[0], "bkg_no") + "'>" ;
	newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[0], "bkg_no_split") + "'>" ;
	var cntr_no = sheetObj.CellValue(arrChkRows[0], "cntr_no");
	if ( cntr_no.length <=0)
		cntr_no="COMU0000000";
	newForm += "  <input type='hidden' name='cntr_no'      value='" + cntr_no + "'>" ;
	newForm += "</form>";
//	alert("newForm:"+newForm);
	document.all.new_form.innerHTML = newForm ;
	//alert(newForm);
	//document.all.new_form.innerHTML = newForm ;
//	alert("1");

	var formObj = document.form1;
//	alert("2");
	formObj.action = "ESD_SCE_0006.do";
//	alert("3");
	formObj.submit() ;
//	alert("4");
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
//	window.open ("ESD_SCE_0077.do" , "list", "scrollbars=no,fullscreen=no,width=800,height=350");
	var newWin = window.showModalDialog("ESD_SCE_0077.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:350px");

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
	document.form.occr_ofc.value = obj;
}


function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.occr_ofc.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.occr_ofc.value = "";
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
		document.form.occr_ofc.value = prm_office;
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
			//alert(rowXml.firstChild.nodeValue.replace('☜',''));
			
			//var aaa = ComReplaceStr(rowXml.firstChild.nodeValue, "☜☞", "");
			//alert(docXml.xml);
			
			//for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
			//	subXml = docXml.getElementsByTagName("sub-office")[n];
			//	text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			//}
			
			for( var n = 0; n < docXml.getElementsByTagName("TR").length; n++ ) {
				var row = docXml.getElementsByTagName("TR")[n].firstChild.nodeValue;
				var val = ComReplaceStr(row, "☜☞", "");
				//alert(val);
				text_ofc = text_ofc+val+",";
			}
			
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}else{
				document.form.occr_ofc.value = text_ofc.substring(0, text_ofc.length-1);
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
//        if(chkLen(formObj.cntr_no, 11)){
//    		formObj.cop_no.value = "" ;
//    		formObj.target = "_self" ;
//    		formObj.f_cmd.value  = SEARCHLIST;
//    		formObj.action       = "ESD_SCE_0006.do" ;
//    		formObj.submit();
//        }
	//}
}

function CheckDigit(obj){
    var rtnval = ComGetCntrNoFull(obj);
    obj.value  = rtnval;
}


function openAddPaste(dist){
//	window.open ("ESD_SCE_0064.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=400,height=390");
	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
}

// Exception Reason popup &&&
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
//	window.open ("ESD_SCE_0108.do?dist="+dist+addpara, "list", "scrollbars=no,fullscreen=no,width=800,height=260");
    var newWin = window.showModalDialog("ESD_SCE_0108.do?dist="+dist+addpara, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:260px");
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
//    		if(document.getElementById(dist).value != ''){
//    			document.getElementById(dist).value = document.getElementById(dist).value + ',' + multi_value;
//    		}else{
			document.getElementById(dist).value = multi_value;
//    		}
	}
}

function openESD_SCE_0102_NEW( sheetObj, formObj) {
	var chkcnt = sheetObj.CheckedRows(0);

	if( chkcnt < 1) {
		ComShowMessage('Please select at least one.');
		return false;
	}

	var sRow = sheetObj.FindCheckedRow("chk");
	var arrRow = sRow.split("|");
	var szResult ="";
	var szBkgNo ="";
	var szBkgNoSplit ="";

	for ( idx =0; idx < arrRow.length -1 ; idx++) {
		if(szResult.length > 0) szResult = szResult + ",";

		szResult = szResult + sheetObj.CellValue( arrRow[idx], "cop_expt_no");
	}
	for ( idx =0; idx < arrRow.length -1; idx++) {
		if(szBkgNo.length > 0) szBkgNo = szBkgNo +",";

		szBkgNo = szBkgNo + sheetObj.CellValue( arrRow[idx], "bkg_no");
	}
	
//	for ( idx =0; idx < arrRow.length -1 ; idx++) {
//		if(szBkgNoSplit.length > 0) szBkgNoSplit = szBkgNoSplit + ",";
//
//		szBkgNoSplit = szBkgNoSplit + sheetObj.CellValue( arrRow[idx], "bkg_no_split");
//	}

	formObj.f_cmd.value = COMMAND01 ;
	var newForm = "" ;

	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='send_val' value='" + szResult + "'>" ;
	newForm += "  <input type='hidden' name='szBkgNo' value=" + szBkgNo + ">" ;
//	newForm += "  <input type='hidden' name='szBkgNoSplit' value='" + szBkgNoSplit + "'>" ;
	newForm += "</form>";

	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1 ;
	var paramUrl = "pgmNo=ESD_SCE_0102&send_val="+szResult+"&szBkgNo="+szBkgNo+"&f_cmd=SEARCH10";
//	alert(paramUrl);
//	var paramUrl = "pgmNo=ESD_SCE_0102&send_val="+szResult+"&szBkgNo="+szBkgNo+"&szBkgNoSplit="+szBkgNoSplit;
    var newWin = window.showModalDialog("ESD_SCE_0102.do?"+paramUrl, "mailPopup", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:400px");
//	var newWin  = window.open("","mailPopup", "width=500,height=400");
//	formObj.action = "ESD_SCE_0102.do" ;
//	formObj.target = "mailPopup" ;
//	formObj.submit() ;

}

function openESD_SCE_0102(sheetObj, formObj){

	var chkcnt = sheetObj.CheckedRows(0);
//	alert("chkcnt"+chkcnt);

	if(chkcnt < 1){
		ComShowMessage('Please select at least one.');

		return false;
	}

	var sRow = sheetObj.FindCheckedRow("chk");

	var arrRow = sRow.split("|");

	var szResult = "" ;

  	for (idx=0; idx<arrRow.length-1; idx++){

  		szResult = szResult + sheetObj.CellValue( arrRow[idx], "r_cop_expt_no")+"|"+
		sheetObj.CellValue( arrRow[idx], "bkg_no")+"|"+
		sheetObj.CellValue( arrRow[idx], "bkg_no_split")+"|"+
		sheetObj.CellValue( arrRow[idx], "r_bl_no")+"|"+
		sheetObj.CellValue( arrRow[idx], "cop_no")+"|"+
		sheetObj.CellValue( arrRow[idx], "cntr_no")+"|"+
		sheetObj.CellValue( arrRow[idx], "r_cop_expt_tp_nm")+"|"+
		sheetObj.CellValue( arrRow[idx], "r_cop_expt_tp_dtl_nm")+"|"+
		sheetObj.CellValue( arrRow[idx], "r_cop_expt_sts")+"|"+
		sheetObj.CellValue( arrRow[idx], "cop_expt_rsn")+"|"+
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
//  	alert(szResult);
	formObj.f_cmd.value = COMMAND01 ;
//alert("1");
//	var row = sheetObj.SelectRow  ;
//	var bkgNo      = sheetObj.CellValue(row, "bkg_no") ;
//	var bkgNoSplit = sheetObj.CellValue(row, "bkg_no_split") ;
//	var copno = sheetObj.CellValue(row, "cop_no") ;

	var newForm = "" ;

	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='send_val' value='" + szResult + "'>" ;
	newForm += "</form>";
//alert("2");
	document.all.new_form.innerHTML = newForm ;
//alert("3");
	var formObj = document.form1 ;
//alert("4");
//	var formObj = newForm ;
	var newWin  = window.open("","mailPopup", "width=480,height=300");
//alert("5");
	formObj.action = "ESD_SCE_0102.do" ;
//alert("6");
	formObj.target = "mailPopup" ;
//alert("7");
	formObj.submit() ;
//alert("8");
}



function addColDesc(coldesc1, chkcnt, iCheckRow){
//    alert("coldesc1:"+coldesc1+"chkcnt:"+chkcnt+"iCheckRow:"+iCheckRow);
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

	//khlee-?? ?? ?? ?? ?? ??
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-??? ?? ?? ?? ??
		ComEndConfigSheet(sheetObjects[i]);
	}

}
function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
    if (sheetObj.RowCount >= OnePageRow && sheetObj.TotalRows > sheetObj.RowCount){
    //if (sheetObj.RowCount >= OnePageRow){
    	selectVal = SceFrmQryString(formObj);
    	formObj.f_cmd.value = SEARCH01;
		PageNo = Math.ceil(sheetObj.SearchRows/OnePageRow)+1;
		//formObj.page.value = Math.ceil(sheetObj.SearchRows/OnePageRow)+1;
		
		//alert(formObj.page.value);
		//document.write(SceFrmQryString(formObj));
		//selectVal = SceFrmQryString(formObj);
    //alert("sheetObj.SearchRows"+sheetObj.SearchRows+"TotalRows :"+sheetObj.TotalRows +"sheetObj.RowCount:"+sheetObj.RowCount+"PageNo:"+PageNo+"OnePageRow:"+OnePageRow);
    	sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", selectVal, "page=" + PageNo, true);
			//sheetObj.DoSearch4Post("ESD_SCE_0011GS.do", selectVal, "", true);

    }
}



function fun_getExptTP() {

		var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH12;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subExptTp;

		request.send(null);

}



/*
function subExptTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("ExptTP");
			var cdxml = docXml.getElementsByTagName("sub-code");
			var nmxml = docXml.getElementsByTagName("sub-name");
			
			alert(docXml.xml);
			
			//alert(docXml.getElementsByTagName("ExptTP").length);
			
//alert(docXml.getElementsByTagName("ExptTP")[0].firstChild.nodeValue);
			
			//alert(docXml.getElementsByTagName("ETC-DATA").xml);
			
			var codeXml = null;
			var nameXml = null;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			text_effS = "<select style=\"width:150;\" name=\"i_expt_type\" onChange=\"fun_getExptDTLTP();\">";
			
			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

					codeXml = cdxml[i].childNodes[0].nodeValue;
					nameXml = nmxml[i].childNodes[0].nodeValue;

					if( i == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}
				}
			}

			text_effE = "</SELECT>";

			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}

			document.form.all.ExptTPDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}
*/

function subExptTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			
			var dataXml = docXml.getElementsByTagName("DATA");
			var rowXml = docXml.getElementsByTagName("TR");
			
			
			var d_row = dataXml[0].getAttribute("COLORDER").split("|");
			
			//alert(d_row.length)
			
			var codeXml = null;
			var nameXml = null;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			text_effS = "<select style=\"width:150;\" name=\"i_expt_type\" onChange=\"fun_getExptDTLTP();\">";
			
					
			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

			
					var c_row = rowXml[i].childNodes[0].nodeValue.split("☜☞");
					//alert(c_row.length);
					
					var c_code="";
					var c_text="";
					
					for( var j = 0; j < d_row.length; j++ ) {
						if(d_row[j]=="expt_cd"){
							c_code =c_row[j]; 
						}
						if(d_row[j]=="expt_cd_nm"){
							c_text =c_row[j]; 
						}
					}
				
					if( i == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + c_code + "\" >"+c_text+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + c_code + "\" >"+c_text+"</OPTION>";
					}
				}
			}

			text_effE = "</SELECT>";

			if( text_effM.length < 1 ) {
				text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
			}

			document.form.all.ExptTPDiv.innerHTML = text_effS+text_effM+text_effE;
		}

	}

}


function fun_getExptDTLTP() {

		var expt_type = document.form.i_expt_type.value;

		var url = "ESD_SCE_0011GS.do?f_cmd="+SEARCH13+"&i_expt_type="+expt_type;
		createHttpRequest();
		request.open("GET", url, true);

		request.onreadystatechange = subExptDTLTp;

		request.send(null);

}



/*
function subExptDTLTp() {

	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("ExptDTLTP");
			var cdxml = docXml.getElementsByTagName("sub-code");
			var nmxml = docXml.getElementsByTagName("sub-name");

			var codeXml = null;
			var nameXml = null;

			var text_effS = "";
			var text_effM = "";
			var text_effE = "";

			text_effS = "<select style=\"width:150;\" name=\"i_exptdtl_type\" >";

			if( rowXml.length > 0 ){

				for( var i = 0; i < rowXml.length; i++ ) {

					codeXml = cdxml[i].childNodes[0].nodeValue;
					nameXml = nmxml[i].childNodes[0].nodeValue;

					if( i == 0){
						text_effM = "<OPTION value=\"\" selected >ALL</OPTION>";
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
					}else{
						text_effM = text_effM + "<OPTION value=\"" + codeXml + "\" >"+nameXml+"</OPTION>";
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
*/

function subExptDTLTp() {

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

			
					var c_row = rowXml[i].childNodes[0].nodeValue.split("☜☞");
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


//            sheetObj.MousePointer = "Default";  
              sheetObj.MousePointer = "Hand";     
              var sText="";
              if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_fm_act_cd")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd1_nm");
              else if(sheetObj.MouseCol == sheetObj.SaveNameCol("r_to_act_cd")) sText = sheetObj.CellText(sheetObj.MouseRow,"r_act_cd2_nm");
           	  //sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
              //풍선도움말 만들기
          	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
     }

}

function goESD_SCE_0044(sheetObj){
	var row = sheetObj.SelectRow  ;
//alert("SCE_044:"+row);
	if(row==0){
  		ComShowMessage(ComGetMsg('SCE90018'));
  		return ;
  	}

    var cntrNO      = sheetObj.CellValue(row, "cntr_no") ;

  	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cntr_no' value='" + cntrNO + "'>" ;
    newForm += "</form>"
//alert("newForm:"+newForm);
    document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
    var paramUrl = "cntr_no="+cntrNO;
    var newWin = window.showModalDialog("ESD_SCE_0044.do?"+paramUrl, "clm_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px");
//    var newWin  = window.open("","clm_win", "width=771,height=525," + getCenterXY(755, 500));
//    var newWin  = window.open("","clm_win", "width="+800+",height=525," + getCenterXY(screen.width, 500));
//    formObj.action = "ESD_SCE_0044.do" ;
//    formObj.target = "clm_win" ;
//    formObj.submit() ;

	    //newWin.focus() ;

}

function goESD_SCE_0006(sheetObj) {
//alert("openESD_SCE_0006 start");
	var chkCnt = sheetObj.CheckedRows("chk") ;
//	alert(chkCnt);

	if( chkCnt==0 ) {
		ComShowMessage(ComGetMsg('COM12113', 'COP')) ;
		return false ;
	}

	var chkRows = sheetObj.FindCheckedRow("chk") ;
	var arrChkRows = chkRows.split("|") ;
	var newForm = "" ;

	var newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(arrChkRows[0], "cop_no") + "'>" ;
	newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[0], "bkg_no") + "'>" ;
//	newForm += "  <input type='text' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[0], "bkg_no_split") + "'>" ;
	var cntr_no = sheetObj.CellValue(arrChkRows[0], "cntr_no");
	if ( cntr_no.length <=0)
		cntr_no="COMU0000000";
	newForm += "  <input type='hidden' name='cntr_no'      value='" + cntr_no + "'>" ;
	newForm += "  <input type='hidden' name='pgmNo'	value='ESD_SCE_0006'>" ;
	newForm += "</form>";
	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1;
//	var paramUrl = "pgmNo=ESD_SCE_0006&cop_no="+formObj.cop_no.value+"&cntr_no="+formObj.cntr_no.value+"&bkg_no="+formObj.bkg_no.value;
//	var newWin = window.showModalDialog("ESD_SCE_0006.do?"+paramUrl, "copdetail_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1100px;dialogHeight:600px");
	var newWin  = window.open("","copdetail_win","width="+1100+",height=600," + getCenterXY(300, 500));
	formObj.action = "ESD_SCE_0006.do";
    formObj.target = "copdetail_win" ;
	formObj.submit() ;
	
}


function addEdiStsNo(por_cd){
    	if(por_cd != ''){
//    		if(document.getElementById('vvd').value != ''){
//    			document.getElementById('vvd').value = document.getElementById('vvd').value + ',' + vvds;
//    		}else{
    			document.getElementById('por_cd').value = por_cd;
//    		}
    	}
    }




function openRccPopUp(multi, dist){
//	window.open ("ESD_SCE_0110.do?dist="+dist, "list", "scrollbars=no,fullscreen=no,width=800,height=410");
	var newWin = window.showModalDialog("ESD_SCE_0110.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:410px");
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

//    var arrstr = strval.split(";");
//    //alert("arrstr[0]:"+arrstr[0]+" arrstr[1]:"+arrstr[1]);
//	//document.form.expt_rsn_inq.value = strval;
//	document.form.expt_rsn_inq_cd.value = arrstr[0];
//	document.form.expt_rsn_inq.value = arrstr[1];
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


function openOfcPopUp(multi, dist){
	var addpara = '&txtmstofccd='+document.form.mst_ofc_cd.value;
//	window.open ("ESD_SCE_0114.do?dist="+dist+addpara, "list2", "scrollbars=no,fullscreen=no,width=800,height=410");
	//window.open ("ESD_SCE_0114.do?dist="+dist, "list2", "scrollbars=no,fullscreen=no,width=800,height=410");
	var retVal = window.showModalDialog("ESD_SCE_0114.do?dist="+dist+addpara, "list", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:410px");
	if (typeof retVal != "undefined" && retVal) {
		mst_ofc_code(retVal);
    }
}


function mst_ofc_code(strval) {
	document.form.mst_ofc_cd.value = strval;
}

function rtn_vvd_code(strval) {
	document.form.vvd.value = strval;
}

function rtn_pol_code(strval) {
	document.form.pol_cd.value = strval;
}
