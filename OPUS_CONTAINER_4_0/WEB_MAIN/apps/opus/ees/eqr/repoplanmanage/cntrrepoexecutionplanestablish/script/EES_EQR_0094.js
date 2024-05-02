/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_EQR_0094.js
*@FileTitle  : Inventory Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
    var cntrchk=0 ; 
    var sheetStatus="complete";
    var bChkResult=true;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    var targetSheet="";
    var targetRow="";
    var cntrno="";
    var tpszno="";
    var schType = "";
    var strCntrdel = "";
    var excelYN = "";
    var excelCount = 0;
    /* Event handler processing by button name */
        function processButtonClick(){
             var sheetObject=sheetObjects[0];       
             var formObject=document.form;
            try {
                var srcName=ComGetEvent("name");
                if(ComGetBtnDisable(srcName)) return false;
                if(formObject.view.value=="true" ) {
                    return;
                }
                switch(srcName) {
                    case "btn_retrieve":
                        var formObject=document.form;
                        schType = "Y";
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
    				/*
                    case "btn_save":
                        showErrMessage("btn_save Button Click!!");
                        break;
    				*/
                    case "btn_loadexcel":
                    		doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                        break;
            	    case "btng_rowadd":
        	            doActionIBSheet(sheetObject,formObject,IBINSERT);    	           
            	        break;
            	    case "btng_delete":
            	    	doActionIBSheet(sheetObject,formObject,IBDELETE);
            	        break;
                    case "btn_new":
                        sheetObject.RemoveAll();
        	            formObject.reset();
        	            tpszChange("");
        	            //displayType();
        	            loadPage("btnNew");
            	        break; 
                    case "btn_rulabel_cd":	//RU Label 조회 팝업
						var par_rulabel_type = form.hid_rulabel_type.value;
						var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
						var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
						var loc_code="";
						ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
						break;
            	    case "loc_btn":
                        var display="0,1,1,1,1,1";
                    	var targetObjList="loc_cd:locList|loc_dpth_cd:loctype";
      				    var param="?depth=4&classId=COM_ENS_0O1";
      				    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 500, 425, targetObjList, display, true);
      				    break; 
    			    case "yard_btn":                    			    
                        var display="0,1,1,1,1,1,1,1,1,1,1,1";
                        var classId="COM_ENS_061";
                        var param='?mode=yard&mode_only=Y&classId='+classId;
                        ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 470, 'setYard', display, true);
                        break;
    			    case "btn_apply":
    			    	goOpenWindow();
    			    	break;
                } // end switch
            }catch(e) {
                if( e == "[object Error]") {
                    ComShowCodeMessage("EQR90004");
                } else {
                    ComShowMessage(e.message);
                }
            }
        }
        function setYard(rowArray) {
            document.form.yard.value="";
         	var gubun=',';
        	for(var i=0; i<rowArray.length; i++)
        	{
        		if(i == rowArray.length-1) gubun='';
        		colArray=rowArray[i];
              	document.form.yard.value += colArray[3] + gubun;
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
         * registering IBCombo Object as list
        * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++]=combo_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage(sType) {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            for(p=0;p< comboObjects.length;p++){
                initCombo (comboObjects[p],p+1);
            }
            document.form.locList.disabled=false; // modify Haeng-Ji, Lee
            document.form.TPSZS.disabled=true;
         /*   
    		// When Pop-up is opened, MVNT Status is setted by MT
    		comboObjects[0].SetSelectText("MT");
         */   
            //TPSZ initializing.
            tpszChange('');
            var sheetObject=sheetObjects[0];               
            var formObject=document.form;
     		var opener=window.dialogArguments;
    		//showErrMessage(opener.document.form.cntrno.value);
     		if(!opener) opener=parent;
    		formObject.cntrno.value=opener.document.form.cntrno.value;
    		formObject.cntr_all.value=opener.document.form.cntrno_all.value;
    		
    		var targetSheet=formObject.targetSheet.value;
			var targetRow=formObject.targetRow.value;
			
    		if(formObject.cntrno.value=="" ) {
    		    if(formObject.ref_id.value!="" ){     
    		       formObject.ref_check.value=formObject.ref_id.value;
    		       strCntrdel = opener.settingCntrDelValue(targetSheet, targetRow);       		       
    		       
    		       doActionIBSheet(sheetObject,formObject,IBSEARCH,"Loading",strCntrdel);
                    if(sheetObject.RowCount()<1){
                        ComBtnEnable("btn_retrieve");
                        formObject.ref_check.value="";
                        cntrchk=0 ; 
                    } else {
                        cntrchk=sheetObject.RowCount(); 
                    }       
                    
                    if(sType == "btnNew")  ComBtnEnable("btn_retrieve");                     
                    if(strCntrdel == "Y") ComBtnDisable("btn_retrieve");
                }else{
                    if(sType == "btnNew") ComBtnEnable("btn_retrieve"); 
                }
    		    
    		}else{
    		    formObject.cntr_no_list.value=formObject.cntrno.value;  
    			formObject.f_cmd.value=SEARCHLIST05;       		
         	    sheetObjects[0].DoSearch("EES_EQR_0094GS.do", eqrFormQryStr(formObject) );
        	    ComBtnDisable("btn_retrieve"); 
         	   if(formObject.cntrno.value == "xxx") {
         		  ComBtnEnable("btn_retrieve"); 
         	   }
    		}
    		
    		if(sheetObject.RowCount()> 0){
    		   sheetObject.CheckAll("check",1,1);
    		}
    		
    		if(formObject.view.value=="true" ) {
    		  ComBtnDisable("btn_retrieve");
    		  ComBtnDisable("btng_rowadd");
    		  ComBtnDisable("btng_delete");
    		  ComBtnDisable("btn_apply");
    		  ComBtnDisable("btn_loadexcel");
    		  ComBtnDisable("btn_new");
    		} 

       }
      /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){   
           // var srcName = window.event.srcElement.getAttribute("name"); 
            with(formObj){
                if(sAction == 0) {
                   
                	if(document.form.ref_id.value != ""){
                        return true;
                    }
                	
                    if(!checkLocItem(formObj, 'loctype', 'locList')) {
                        return false;
                    }
                   
                    if(!checkTpszCombo(2)) {      
                        return false;
                    }      
                    
                    
                } 
            }
            return true;
        }
        function loadPage_1(tpsz) {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1,tpsz);
                ComEndConfigSheet(sheetObjects[i]);
            }
            document.form.locList.disabled=false;
            document.form.TPSZS.disabled=false;
        }
       /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){
		                 var HeadTitle0="Sel.|STS|CNTR No.|T/S|Term|MVMNT|LSR|RU Label Type|RU Label Value|Curr|DM|HR|HB|RB|DP|PF|IM|MA|HM" ;		
		                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );		
		                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                 var headers = [ { Text:HeadTitle0, Align:"Center"} ];
		                 InitHeaders(headers, info);		
		                 var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"check" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_tp",         KeyField:0,   CalcLogic:"",   Format:"" ,            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_use_co_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rfub_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"disp_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"plst_flr_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rf_tp_cd_c",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rf_tp_cd_h",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                  
		                 InitColumns(cols);		
		                 SetEditable(1);
		                 SetCellBackColor(1,7,"#555555");
		                 SetCellBackColor(1,8,GetCellBackColor(1,7));
		                 SetCellBackColor(1,9,GetCellBackColor(1,7));
		                 SetCellBackColor(1,10,GetCellBackColor(1,7));
		                 SetSheetHeight(320);
		                 SetColProperty("cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                      }
                    break;
            }
        }
       /**
         * initializing Tab
         * setting Tab items
         */
        function initCombo (comboObj, comboNo) {
            var cnt=0 ;
            switch(comboNo) {
                case 1:
                   with (comboObj) {
                   SetDropHeight(12 * 18);
    //
                   var menuname=moveText.split('|'); 
    			         var menucode=moveCode.split('|'); 
                   SetMultiSelect(1);
                   SetMaxSelect(menuname.length );
                   Multiseparator=",";
        		   for(i=0; i<menuname.length; i++) {
         				InsertItem(cnt++, menuname[i], menucode[i]);                      		
        		   }
                   //Code = "01";
        	    }
                   break;
                case 2:
                   with (comboObj) {
                   SetDropHeight(12 * 18);
                   SetMultiSelect(1);
                   var menuname=leaseText.split('|'); 
    				       var menucode=leaseCode.split('|'); 
                   SetMaxSelect(menuname.length );
                   Multiseparator=",";
        			 for(i=0; i<menuname.length; i++) {
         				InsertItem(cnt++, menuname[i], menucode[i]);                      		
        			 }
                  // Code = "01";
        	    }
                   break;
                case 3:
                   with (comboObj) {
                   	SetDropHeight(12 * 18);
                   	SetMultiSelect(1);
                   	SetMaxSelect(consTpszArr.length );
                   	Multiseparator=",";
    				        for(i=0; i<consTpszArr.length; i++) {
                    	InsertItem(cnt ++, consTpszArr[i], consTpszArr[i]);                      		
                   	}  
        	    }
                   break;
             }
        }
      	/**
         * Event when clicking Tab
         * activating selected tab items
         */
         var beforesheet=0 ;
        function ChangSheet(nItem)
        {
            var objs=document.all.item("tabLayer");
            objs[nItem].style.display="Inline";
            objs[beforesheet].style.display="none";
            //--------------- Important --------------------------//
            objs[beforesheet].style.zIndex=objs[nItem].style.zIndex -1 ;
            //------------------------------------------------------//
            beforesheet=nItem;
        }
      // handling process for Sheet
        function doActionIBSheet(sheetObj,formObj,sAction,sType,sCntrdel) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               case IBSEARCH:      //retrieve
                    if(validateForm(sheetObj,formObj,sAction)) {
                    	
                    	if(sType != "Loading") {
	                    	 if(!checkLocItem(formObj, 'loctype', 'locList')) {
	                             return false;
	                         }
	                        
	                         if(!checkTpszCombo(2)) {      
	                             return false;
	                         }      
                    	}
                        //no support[check again]CLT sheetObj.SpeedOption="NOFIT,NOSUM,NOSEQ,NOCALC,NOROWHEIGHT,NOTRIM,NOCOMBO";
                    	if(sCntrdel != "Y") {
                    		sheetObj.SetWaitTimeOut(300);// retrieve시간 연장
                    		formObj.f_cmd.value=SEARCHLIST;
                    		sheetObj.DoSearch("EES_EQR_0094GS.do", eqrFormQryStr(formObj) );
                    	}
                    }
                    break;
               case IBINSERT:      // inserting
                    var row=sheetObj.DataInsert();
                    sheetObj.SetCellValue(row,"check","0");
                    break;
               case IBDELETE:
       			var checkList=sheetObj.FindCheckedRow('check');
       			if(checkList == ''){
       				ComShowCodeMessage('COM12176');  
       				return false;
       			} 
       			
       			var hRow=sheetObj.HeaderRows();
       			for (var row=hRow; row <= sheetObj.RowCount(); row++) {
       				
       				if (sheetObj.GetCellValue(row, 'check') == 1) {
       					sheetObj.RowDelete(row,false);
       					row--;
       				}
       			}    
       			
       			break;
               case IBCOPYROW:        //copying row
                  sheetObj.DataCopy();
                  break;
               case IBLOADEXCEL:        //uploading excel
                  if(validateForm(sheetObj,formObj,sAction))
                      var formObject=document.form;
                      var i=0;
                      var j=0;
                      var cntr_no_list="";
                      if(cntrchk == 0 ) {
                    	  sheetObj.LoadExcel({ Append:true,Mode:"HeaderMatch"});
                    	  //sheetObj.LoadExcel();
        			  }else{
                         sheetObj.LoadExcel({ Mode:"HeaderSkip"});
        			  }
                  break;
            }
        }
        
        function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
        	if(isExceedMaxRow(msg))return;

        	var formObj=document.form;
        	//if(cntrchk == 0 ) {
        	var cntr_no_list = "";
        		formObj.f_cmd.value=SEARCHLIST03;
				for(var i=0; i<sheetObj.RowCount()+1; i++) {
					cntr_no_list += sheetObj.GetCellValue(i,"cntr_no") + ((i == sheetObj.RowCount() ) ? "" : ",");
				}
				formObj.cntr_no_list.value=cntr_no_list;
				if(cntr_no_list!=""){
					ComOpenWait(true);
				    setTimeout( function () {
				    	excelYN = "Y";
				    	excelCount = sheetObj.RowCount();
				    	sheetObj.DoSearch("EES_EQR_0094GS.do", eqrFormQryStr(formObj) , {Sync:1});
				    	
					ComOpenWait(false);
				    } , 100);
				}				
        	/*}else{
        		formObj.f_cmd.value=SEARCHLIST03;
                for( i=0; i<sheetObj.RowCount()+1; i++) {
               	  	cntr_no_list += sheetObj.GetCellValue(i,"cntr_no") + ((i == sheetObj.RowCount() ) ? "" : ",");
       	      	}
       	      	formObject.cntr_no_list.value=cntr_no_list;
       	      	if(cntr_no_list!=""){
       	      		for( j=47;j>cntrchk;j--) {   
       	      			sheetObj.RowDelete(j, false);
                    }
        	        sheetObj.DoSearch("EES_EQR_0094GS.do", eqrFormQryStr(formObj),{Append:true} );
               }				
        	}*/
        } 
        
        
    	function displayType(){
    		with(document.form)
    		{		
    			   if(loctype.value == '') {
    			       locList.disabled=true;
    			       locList.value='';
    			   } else {
    			       locList.disabled=false;
    			   }
    		}
    	}      
    	function tpszChange(key){ 
    		comboObjects[2].SetSelectCode(-1);
            switch (key)
            {
                case "":
                    comboObjects[2].SetSelectCode(consTpsz);
                	break;
                case "D":
                    comboObjects[2].SetSelectCode(consTpszDry);
                	break;
                case "S":
                    comboObjects[2].SetSelectCode(consTpszSpc);
                	break;
                case "R":
                    comboObjects[2].SetSelectCode(consTpszZrb);
                	break;
                /*case "R":
                    comboObjects[2].SetSelectCode(consTpszRfr);
                	break;
                case "O":
                    comboObjects[2].SetSelectCode(consTpszOt);
                	break;
                case "F":
                    comboObjects[2].SetSelectCode(consTpszFr);
                	break;*/
            }
        }
    	
    	//sheet check delete
    	function sheet1_OnClick(sheetObj, Row, Col, Val) {
    		if(sheetObj.ColSaveName(Col) == "check") {
    			for(var i=1; i<sheetObj.RowCount()+1; i++) {    				
    				if(sheetObj.GetCellValue(i, "cntr_no") == "") {    	       				
	       				if (sheetObj.GetCellValue(i, 'check') == 1 && sheetObj.GetCellValue(i, "cntr_no") =="") {
	       					sheetObj.RowDelete(i,false);
	       					row--;
	       				}
    				}
    			}
    		}
    	}
    	
    	
        //sheet modifying  Valid check
        function sheet1_OnChange(sheetObj , Row, Col, Val){
        	bChkResult=true;
        	sheetStatus="processing";        		
            //CNTR_NO
            if(Col == sheetObj.SaveNameCol("cntr_no")){
                 var formObject=document.form;
                 //no support[check again]CLT var seachword=sheetObj.EditText;
                 var cntr_no=sheetObj.GetCellValue(Row,"cntr_no");
                 var targetRow=null;
    			 while(true) {
    				targetRow=sheetObj.FindText("cntr_no", Val, targetRow+1);  // ROW retreive
    				if(targetRow == -1 ) {  										            
    				  break;
    				}else {
    				   if(targetRow != Row) {
    				   		bChkResult=false;
        					ComShowCodeMessage("EQR90091",  targetRow,Val); 
        					sheetObjects[0].SetCellValue(Row, "cntr_no","");
        					sheetObjects[0].SetCellValue(Row, "check","");
        					cntr_no="";
    				   }
    				//	break;
    				}		
    			 } 
    			 
    			 
                 if(cntr_no !="") { 
                     //var colname = sheetObj.ColSaveName(Col); 
                     var colname='cntr_tpsz_cd'     
                     var f_cmd=SEARCHLIST01;
                     var repoplan_id=document.form.repoplan_id.value;
                     formObject.cntr_no_list.value=cntr_no;
                     sheetObj.DoRowSearch2("EES_EQR_0094GS1.do","row=" + Row 
                                            + "&repoplan_id=" + repoplan_id + "&f_cmd=" + f_cmd 
                                            + "&fm_ecc="+ document.form.fm_ecc.value		                
                          		            + "&to_ecc="+ document.form.to_ecc.value	       
                          		            + "&pln_yrwk="+ document.form.pln_yrwk.value
                          		            + "&cntr_no="+ cntr_no   
                          		            + "&trsp_mode="+ document.form.trsp_mode.value , false);
                     if(sheetObjects[0].GetCellValue(Row, "cntr_no") ==""){
        				bChkResult=false;
        				ComShowCodeMessage("EQR90092",cntr_no); 
//                  
                     }
        		  }	   		
              }
              sheetStatus="complete"
        }      	
    	/* closing window
    	*/
    	function closeWindow() {
    		ComClosePopup(); 
    	}
    		/* closing window
    	*/
    	function closeWindowForApply() {
    		if(sheetStatus == "processing") { 
    			setTimeout("closeWindowForApply()", 500);
      		}	else {
      			if(bChkResult)
      				ComClosePopup(); 
      		}
    	}
    	/* - opening target window
    	*/		
    	function goOpenWindow() {
    		var formObject=document.form;
    		var opener=window.dialogArguments; 
    		if(!opener) opener=parent;
    		var sheetObj=sheetObjects[0];
    		if(sheetObjects[0].RowCount()==0) {
    			ComShowCodeMessage("EQR90063",16);
    			return false;
    		}else {				
    			targetSheet=formObject.targetSheet.value;
    			targetRow=formObject.targetRow.value;
    			cntrno="";
    			tpszno="";
    			formObject.cntr_all.value=opener.document.form.cntrno_all.value;	
    			var cntrarr="";
    			var cntrlist="";
    			var t_Row=null;
    			cntrarr=formObject.cntr_all.value; 
    			var arCntr=cntrarr.split(",");
    			var cntrno_list="";
    			var sheet_no=document.form.targetSheet.value;
    			
    			if(sheetObjects[0].GetCellValue(0,"check") == "Del") {
    				
    				
    				if(cntrarr!="" && sheet_no!= "4" ) {
	        			for (var j=0; j<arCntr.length-1; j++) {
	        				while(true) {
	            				t_Row=sheetObj.FindText("cntr_no", arCntr[j], t_Row+1);  // ROW retreive
	            				if(t_Row == -1 ) {  										            
	            				  break;
	            				}else {	
	            					if (sheetObjects[0].GetCellValue(t_Row, "check")=="0") {
	                					ComShowCodeMessage("EQR90093",arCntr[j]); 
	                					return false;                              
	            				    }
	            				//	break;
	            				}		
	            			 }  				
	        			}	// for - end 
	    			} // if - end 
	    			// cntr no, tpsz no		
	    			var cntr_cnt=0; 
	    			for(var i=1; i<sheetObjects[0].RowCount()+1; i++) {
	    			    //if(sheetObjects[0].CellValue(i, "check")!="1"){
	    				if(sheetObjects[0].GetCellValue(i, "check")=="0"){
	    					if(sheetObjects[0].GetCellValue(i, "cntr_no") == ""){
	        				    ComShowCodeMessage("EQR90181","Container No.",i);
	        				    return false;
	        				}
	    					if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == ""){
	    						ComShowCodeMessage("EQR90182",sheetObjects[0].GetCellValue(i, "cntr_no"));
	        				    return false;
	        				}
	    					cntrno += sheetObjects[0].GetCellValue(i, "cntr_no")      + ((i == sheetObjects[0].RowCount() ) ? "" : ",");
	    					tpszno += sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") + ((i == sheetObjects[0].RowCount() ) ? "" : ",");
	    					if(sheetObjects[0].GetCellValue(i, "ibflag")=="I"){
	    						cntrno_list += sheetObjects[0].GetCellValue(i, "cntr_no")  + ((i == sheetObjects[0].RowCount() ) ? "" : ",");
	        			    }
	        			    cntr_cnt++; 
	    			    }
	    			}
	    			
	    			if(cntr_cnt ==0) {
	    				//ComShowCodeMessage("EQR90063",16);
	    				//return false;
	    			}
	    			
					opener.settingValue(cntrno, tpszno, targetSheet, targetRow);				
					closeWindowForApply();
    				
    			} else {
	    			if(cntrarr!="" && sheet_no!= "4" ) {
	        			for (var j=0; j<arCntr.length-1; j++) {
	        				while(true) {
	            				t_Row=sheetObj.FindText("cntr_no", arCntr[j], t_Row+1);  // ROW retreive
	            				if(t_Row == -1 ) {  										            
	            				  break;
	            				}else {	
	            					if (sheetObjects[0].GetCellValue(t_Row, "check")=="1") {
	                					ComShowCodeMessage("EQR90093",arCntr[j]); 
	                					return false;                              
	            				    }
	            				//	break;
	            				}		
	            			 }  				
	        			}	// for - end 
	    			} // if - end 
	    			// cntr no, tpsz no		
	    			var cntr_cnt=0; 
	    			for(var i=1; i<sheetObjects[0].RowCount()+1; i++) {
	    			    //if(sheetObjects[0].CellValue(i, "check")!="1"){
	    				if(sheetObjects[0].GetCellValue(i, "check")=="1"){
	    					if(sheetObjects[0].GetCellValue(i, "cntr_no") == ""){
	        				    ComShowCodeMessage("EQR90181","Container No.",i);
	        				    return false;
	        				}
	    					if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == ""){
	    						ComShowCodeMessage("EQR90182",sheetObjects[0].GetCellValue(i, "cntr_no"));
	        				    return false;
	        				}
	    					cntrno += sheetObjects[0].GetCellValue(i, "cntr_no")      + ((i == sheetObjects[0].RowCount() ) ? "" : ",");
	    					tpszno += sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") + ((i == sheetObjects[0].RowCount() ) ? "" : ",");
	    					if(sheetObjects[0].GetCellValue(i, "ibflag")=="I"){
	    						cntrno_list += sheetObjects[0].GetCellValue(i, "cntr_no")  + ((i == sheetObjects[0].RowCount() ) ? "" : ",");
	        			    }
	        			    cntr_cnt++; 
	    			    }
	    			}
	    			if(cntr_cnt ==0) {
	    				//ComShowCodeMessage("EQR90063",16);
	    				//return false;
	    			}
	    			
					opener.settingValue(cntrno, tpszno, targetSheet, targetRow);				
					closeWindowForApply();
	     		}	
    		}
    	}		
    	
        function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        	var formObject=document.form;
    		ComEtcDataToForm(document.form, sheetObj); 
    		if(sheetObj.RowCount()>0){
    			if(formObject.cntrno.value != "") {
    				if(formObject.cntrno.value == "xxx") {
    					sheetObj.SetCellValue(0,"check","Sel");
    				}else{
    					sheetObj.SetCellValue(0,"check","Del");
    				}
    			}
    		   
     		   
    		   ComBtnDisable("btn_retrieve");
				if(document.form.cntrno.value!="" ) {
					sheetObj.CheckAll("check", "0");
					if(formObject.cntrno.value == "xxx") {
						ComBtnEnable("btn_retrieve");
					}
				}else{
					if(schType != "Y") {
						sheetObj.SetCellValue(0,"check","Del");
					}else{
						if(document.form.cntrno.value =="") {
							ComBtnEnable("btn_retrieve");
						}
					}
				}
            }
    		
    		if(excelYN == "Y") {
    			if(excelCount != sheetObj.RowCount()) {
    				var diffCntrVol = excelCount - sheetObj.RowCount();
    				ComShowCodeMessage("EQR70016", diffCntrVol); 
    			}
    			excelYN = "";
    		} else {
    			excelYN = "";
    		}
        }	
        function setValue() {
            if(!opener) {
    			opener=window.dialogArguments;
    		}
        	opener.settingValue(cntrno, tpszno, targetSheet, targetRow);    				
        	ComClosePopup(); 
        }
        
        /**
         * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
         * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
         * @returns string <br>
         */
        function ComToHtml2(obj){
            try {
                //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
                var str = getArgValue(obj);

                str = str.replace(/&/gi, "@amp;");
                return str;
            } catch(err) { ComFuncErrMsg(err.message); }
        } 
