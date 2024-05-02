/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0026.jsp
*@FileTitle  : Terminal invoice CSR Creation - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
var comboObjects=new Array();
var comboCnt=0 ; 
var approvalFlg="";
var parmObj=new Array();
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var sheetObject2=sheetObjects[2];        
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
  	    case "btn_retrieve":
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	        break;
				case "btn_new":
			          sheetObject.RemoveAll();
			          formObject.reset();
		        break;
				case "btng_detail":
						var sRow=sheetObject.FindCheckedRow(1);
						var arrRow=sRow.split("|");						
						if(arrRow.length<1){
								ComShowMessage(ComGetMsg('TES25001'));
								return false;
						}else{
							var inv_no=sheetObject.GetCellValue(arrRow[0],"inv_no");
							var vndr_seq=sheetObject.GetCellValue(arrRow[0],"vndr_seq");
							var tml_so_ofc_cty_cd=sheetObject.GetCellValue(arrRow[0],"tml_so_ofc_cty_cd");
							var tml_so_seq=sheetObject.GetCellValue(arrRow[0],"tml_so_seq");
							var moveUrlFlg=sheetObject.GetCellValue(arrRow[0],"tml_inv_tp_cd");
								var moveUrl="";
								var moveUrlParam="&inv_no="+inv_no+"&vndr_seq="+vndr_seq+"&tml_so_ofc_cty_cd="+tml_so_ofc_cty_cd+"&tml_so_seq="+tml_so_seq;	
								switch(moveUrlFlg) {
										case "TM":
												moveUrl="ESD_TES_0017.do?pgmNo=ESD_TES_0017&parentPgmNo=ESD_TES_M001&sysCommUiTitle=Marine Terminal Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;
										case "ON":
												moveUrl="ESD_TES_0068.do?pgmNo=ESD_TES_0068&parentPgmNo=ESD_TES_M001&sysCommUiTitle=On-Dock Rail Charge Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;	
										case "OF":
												moveUrl="ESD_TES_0018.do?pgmNo=ESD_TES_0018&parentPgmNo=ESD_TES_M001&sysCommUiTitle=Off-Dock CY Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;	
										case "ST":
												moveUrl="ESD_TES_0019.do?pgmNo=ESD_TES_0019&parentPgmNo=ESD_TES_M001&sysCommUiTitle=Marine Terminal Storage Container List&sysCommUiNavigation=Service Delivery > TML S/O > Invoice > Container List Inquiry";
										break;																										
								}	
								//location.href=moveUrl+moveUrlParam;
								noRtnPopup(moveUrl+moveUrlParam, 'width=950,height=580,menubar=0,status=0,scrollbars=1,resizable=1')
						}
						break;
				case "btns_calendar1":
						var cal=new ComCalendar();
						cal.select(formObject.sdate,  'yyyy-MM-dd');
						break;
				case "btng_search":
            var v_apro_step=document.form.apro_step.value;
            var param="?mode=set&apro_step="+v_apro_step+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
            ComOpenPopup('/opuscntr/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);		
            /**			
	          var v_ofc_cd=formObject.cost_ofc_cd.value;    
	          var v_sub_sys_cd="TES";               
	          var param="?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1";
	          comPopup('/opuscntr/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
	          **/
						break;
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.pm_due_dt, 'yyyy-MM-dd');
					break;				
				case "btng_evidence":
						if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || 

								Object.FindCheckedRow(1) == undefined){
								ComShowMessage(ComGetMsg('TES25001'));
								return false; 
						}				
						//if(document.form.eviInputFlg.value!="Y"){						
								if(formObject.evi_gb.value=="1"){
										//noRtnPopup('ESD_TES_078.do', 'width=775,height=580,menubar=0,status=0,scrollbars=0,resizable=0');  
										 ComOpenWindow("ESD_TES_0078.do",  window,  "dialogWidth:790px; dialogHeight:620px; help:no; status:no; resizable:no;" , true);
								}else if(formObject.evi_gb.value=="2"){ 
										//noRtnPopup('ESD_TES_079.do', 'width=775,height=535,menubar=0,status=0,scrollbars=0,resizable=0');   
										 ComOpenWindow("ESD_TES_0079.do",  window,  "dialogWidth:790px; dialogHeight:590px; help:no; status:no; resizable:no;" , true);
								}else if(formObject.evi_gb.value=="3"){ 						
								}else{ 
								} 
						//}else{
						//}
						break;					
				case "btng_preview":
						/**
						var csr_amt=0;		
						for(var i=0;i<sheetObject.RowCount();i++){
if(sheetObject.GetCellValue(i+1,1)==1){
csr_amt=parseFloat(sheetObject.GetCellValue(i+1,"inv_total_amt")*100)+parseFloat(csr_amt);
								}								
						}
						formObject.csr_amt.value=(csr_amt/100);
						**/
						var sRow=sheetObject.FindCheckedRow(1);
						var arrRow=sRow.split("|");						
						if(arrRow.length<1){
								ComShowMessage(ComGetMsg('TES25001'));
								return false;
						}else{
							sheetObject1.RemoveAll();
							sheetObject2.RemoveAll();
							doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
						}
						//noRtnPopup('ESD_TES_080.do', 'width=775,height=370,menubar=0,status=0,scrollbars=0,resizable=0');  
						break;
				case "btng_print":						
						var fromObj=new Array();
						var rdObj=new Array();
						
			            fromObj[0]=formObject;
			            rdObj[0]=sheetObjects[0];          
			            parmObj[0]="1";
			            parmObj[1]="";
			            parmObj[2]="N";
			            parmObj[3]=RD_path+"apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0024Print.mrd";     // RD 화면
			            parmObj[4]=rdObj;
			            parmObj[5]=fromObj;
			            rdObjModaless(RdReport , parmObj , 1000 ,700);						
						break;
				case "btng_approvalrequest":
						if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
								ComShowMessage(ComGetMsg('TES25001'));
								return false; 
						}
						//if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
						//if(formObject.asanogb.value=="A/P"){
						if(cnt_cd=="KR"){
								if(formObject.evi_gb.value == ""){
										ComShowMessage(ComGetMsg('TES25002'));
										return false; 
								}else{
										if(formObject.evi_gb.value!="3"){
												if(document.form.eviInputFlg.value != "Y"){
														ComShowMessage(ComGetMsg('TES25003'));
														return false; 
												}
										}						
								}
						} 								
						var csr_amt=0;		
						for(var i=0;i<sheetObject.RowCount();i++){
							if(sheetObject.GetCellValue(i+1,1)==1){
								csr_amt=parseFloat(sheetObject.GetCellValue(i+1,"inv_total_amt")*100)+parseFloat(csr_amt);
								}								
						}
						formObject.csr_amt.value=(csr_amt/100); 
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						approvalFlg="Y";
						break;
      	} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21025'));
    		} else {
    			ComShowMessage(e.message);
    		}
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
    	self.resizeTo(1010,560); 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }    
        /**     
			  if(document.form.asanogb.value=="A/P" && cnt_cd=="KR"){			  
			      document.all.item("srLayer")[1].style.display="inline";
			      document.all.item("srLayer")[0].style.display="none";
			      document.all.item("srLayer")[2].style.display="none";		
			      document.all.item("btLayer")[1].style.display="inline";
			      document.all.item("btLayer")[0].style.display="none";			      						
				}else if(document.form.asanogb.value=="ASA" && cnt_cd=="KR"){
			      document.all.item("srLayer")[1].style.display="none";
			      document.all.item("srLayer")[0].style.display="none";
			      document.all.item("srLayer")[2].style.display="inline";	
			      document.all.item("btLayer")[1].style.display="inline";
			      document.all.item("btLayer")[0].style.display="none";			      							
				}else if(document.form.asanogb.value=="ASA" && cnt_cd!="KR"){
			      document.all.item("srLayer")[1].style.display="none";
			      document.all.item("srLayer")[0].style.display="inline";
			      document.all.item("srLayer")[2].style.display="none";	
			      document.all.item("btLayer")[1].style.display="none";
			      document.all.item("btLayer")[0].style.display="inline";						
				}else if(document.form.asanogb.value=="A/P" && cnt_cd!="KR"){
			      document.all.item("srLayer")[1].style.display="none";
			      document.all.item("srLayer")[0].style.display="none";
			      document.all.item("srLayer")[2].style.display="none";	
			      document.all.item("btLayer")[1].style.display="none";
			      document.all.item("btLayer")[0].style.display="inline";								
				}		         
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, '');
        }				
				**/
				ComEnableObject(document.form.cost_ofc_cd, false);
				ComEnableObject(document.form.inv_cfm_dt, false); 
				ComEnableObject(document.form.vndr_seq, false);
				ComEnableObject(document.form.vndr_seq_name, false);
				ComEnableObject(document.form.cnt_inv, false);
				ComEnableObject(document.form.curr_cd, false);         
				ComEnableObject(document.form.total_amt, false);
				ComEnableObject(document.form.csr_no, false);	
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
				/**
				if(document.form.total_amt.value >= 0){
						document.form.csr_tp_cd.value="S"
				}else{ 
						document.form.csr_tp_cd.value="C"
				}		
				**/							
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                var HeadTitle="Seq.||Invoice No.|Net Amount|Tax Amount|W.H.T|Total Amount" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"ttl_inv_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"vat_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_total_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_inv_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(ComGetSheetHeight(sheetObj,13)); 
                      }
                break;


            case 2:      //sheet1 init
                with (sheetObj) {
                var HeadTitle="csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"pre_csr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_office",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_prpd_dy",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_to",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_csr_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_group",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_evi_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_due_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_asa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"apro_step",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_title",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(ComGetSheetHeight(sheetObj,13)); 
                      }
                break;


            case 3:      //sheet1 init
                with (sheetObj) {
                var HeadTitle="char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_chart_of_account",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_account_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pre_gl_date",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_city",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_debit",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_credit",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(ComGetSheetHeight(sheetObj,13)); 
               }
                break; 
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
               	formObj.f_cmd.value=SEARCH02;                  
               	sheetObj.DoSearch("ESD_TES_0026GS.do", tesFrmQryStr(formObj) );
                break; 
            case IBSAVE:        //Save                
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESD_TES_0024GS.do", tesFrmQryStr(formObj),-1,false);
                break;
           case IBCOPYROW:        
              sheetObj.DataCopy();
              break
        }
    }
  // handling sheet process
    function doActionIBSheet1(sheetObj,formObj,sAction) {//alert("start doActionIBSheet1");
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
               	formObj.f_cmd.value=SEARCH03;                  
				var param=sheetObjects[0].GetSaveString(false,false);
				var sXml=sheetObjects[2].GetSearchData("ESD_TES_0024PreView.do", param+'&'+tesFrmQryStr(formObj));
//				sheetObjects[2].LoadSearchXml(sXml); 								
				var arrXml=sXml.split("|$$|");
				sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
                //sheetObj.DoSearch4Post("ESD_TES_024PreView.do", tesFrmQryStr(formObj));                       
                break;          
        }
    }     
	  /**
     * MInimize click event
     */
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
	    	    objs.style.display="none";
//no support[check again]CLT 	    	    sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(20);
				sheetObjects[0].focus();
//no support[check again]CLT 				sheetObjects[0].ViewRows=20; 
				}
	    	else
	    	{
	    	    objs.style.display="inline";
//no support[check again]CLT 	    	    sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(10);
				sheetObjects[0].focus();
//no support[check again]CLT 				sheetObjects[0].ViewRows=10;
	    	}
    }
	    /**
	     * @param {Object}	obj		object	
	     * @return	
	     */
		function isNum(obj){
			if (!ComIsNumber(obj)){
				obj.value='';
			}
		}
		/**
		 * @param {Object}	obj		object	
		 * @return
		 */
		function isNum1(obj){
			if (!ComIsNumber(obj,"-")){
				obj.value='';
			}
		}		
		/**
		 * @param {Object}	obj		object	
		 * @return
		 */
		function isDate1(obj){
			if (!ComIsDate(obj)){
				obj.value='';
			}
		}		
	/**
	 * 
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */	
    function sheet3_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null&&errMsg!=0){
            ComShowMessage(errMsg);
        }
//        var previewFlg 			= "";
//        var pre_title   		= "";
//		var pre_csr_no			= sheetObj.EtcData("pre_csr_no");			
//		var pre_office			= sheetObj.EtcData("pre_office");				
//		var pre_prpd_dy			= sheetObj.EtcData("pre_prpd_dy");			
//		var pre_pay_to			= sheetObj.EtcData("pre_pay_to");				
//		var pre_csr_type		= sheetObj.EtcData("pre_csr_type");		
//		var pre_desc			= sheetObj.EtcData("pre_desc");					
//		var pre_pay_group		= sheetObj.EtcData("pre_pay_group");		
//		var pre_evi_tp			= sheetObj.EtcData("pre_evi_tp");				
//		var pre_due_date		= sheetObj.EtcData("pre_due_date");			
//		var pre_asa_no			= sheetObj.EtcData("pre_asa_no");				
//		var pre_inv_dt			= sheetObj.EtcData("pre_inv_dt");				
//		var pre_curr_cd			= sheetObj.EtcData("pre_curr_cd");			
//		var pre_amt				= sheetObj.EtcData("pre_amt");
//		var apro_step			= sheetObj.EtcData("apro_step");
        var previewFlg="";
        var pre_title="";
		var pre_csr_no=sheetObjects[1].GetCellValue(1,"pre_csr_no");
		var pre_office=sheetObjects[1].GetCellValue(1,"pre_office");
		var pre_prpd_dy=sheetObjects[1].GetCellValue(1,"pre_prpd_dy");
		var pre_pay_to=sheetObjects[1].GetCellValue(1,"pre_pay_to");
		var pre_csr_type=sheetObjects[1].GetCellValue(1,"pre_csr_type");
		var pre_desc=sheetObjects[1].GetCellValue(1,"pre_desc");
		var pre_pay_group=sheetObjects[1].GetCellValue(1,"pre_pay_group");
		var pre_evi_tp=sheetObjects[1].GetCellValue(1,"pre_evi_tp");
		var pre_due_date=sheetObjects[1].GetCellValue(1,"pre_due_date");
		var pre_asa_no=sheetObjects[1].GetCellValue(1,"pre_asa_no");
		var pre_inv_dt=sheetObjects[1].GetCellValue(1,"pre_inv_dt");
		var pre_curr_cd=sheetObjects[1].GetCellValue(1,"pre_curr_cd");
		var pre_amt=sheetObjects[1].GetCellValue(1,"pre_amt");
		var apro_step=sheetObjects[1].GetCellValue(1,"apro_step");
		var pre_evi_tp_count="";
		if(cnt_cd =="KR" || pre_evi_tp == "세금계산서" || pre_evi_tp == "계산서" || pre_evi_tp == "기타" ){
				pre_evi_tp_count="1";
		}else{
				var sRow=sheetObjects[0].FindCheckedRow(1);
				var arrRow=sRow.split("|");		
				pre_evi_tp_count=arrRow.length-1;
		}	
		if(pre_amt==0 || pre_amt=="0" || pre_amt=="0.00"){
				pre_title="TRANSFER SLIP";
		}else{
				pre_title="CONSULTATION SLIP";
		}				
		sheetObjects[1].RemoveAll();
		sheetObjects[1].DataInsert(-1);
        sheetObjects[1].SetCellValue(1,"pre_csr_no",pre_csr_no);
        sheetObjects[1].SetCellValue(1,"pre_office",document.form.cost_ofc_cd.value);
        sheetObjects[1].SetCellValue(1,"pre_prpd_dy",pre_prpd_dy);
        sheetObjects[1].SetCellValue(1,"pre_pay_to",pre_pay_to);
        sheetObjects[1].SetCellValue(1,"pre_csr_type",pre_csr_type);
        sheetObjects[1].SetCellValue(1,"pre_desc",pre_desc);
        sheetObjects[1].SetCellValue(1,"pre_pay_group",pre_pay_group);
        sheetObjects[1].SetCellValue(1,"pre_evi_tp",pre_evi_tp+"/"+pre_evi_tp_count);
        sheetObjects[1].SetCellValue(1,"pre_due_date",pre_due_date);
        sheetObjects[1].SetCellValue(1,"pre_asa_no",pre_asa_no);
        sheetObjects[1].SetCellValue(1,"pre_inv_dt",pre_inv_dt);
        sheetObjects[1].SetCellValue(1,"pre_curr_cd",pre_curr_cd);
        sheetObjects[1].SetCellValue(1,"pre_amt",pre_amt);
        sheetObjects[1].SetCellValue(1,"apro_step",apro_step);
        sheetObjects[1].SetCellValue(1,"pre_title",pre_title);
        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
         		previewFlg="krjp";
        }
        noRtnPopup('ESD_TES_0080.do?previewFlg='+previewFlg, 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0'); 
    }				    
    function sheet1_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null&&errMsg!=0){
            ComShowMessage(errMsg);
        }
        var cost_ofc_cd=sheetObj.GetEtcData("cost_ofc_cd");
        var vndr_seq=sheetObj.GetEtcData("vndr_seq");
        var vndr_seq_name=sheetObj.GetEtcData("vndr_seq_name");
        var curr_cd=sheetObj.GetEtcData("curr_cd");
        var hdr_total_amt=sheetObj.GetEtcData("hdr_total_amt");
        var payment_due_dt=sheetObj.GetEtcData("payment_due_dt");
        document.form.cost_ofc_cd.value=cost_ofc_cd;
        document.form.vndr_seq.value=vndr_seq;
        document.form.vndr_seq_name.value=vndr_seq_name; 
        document.form.curr_cd.value=curr_cd;
        document.form.total_amt.value=hdr_total_amt;
        document.form.payment_due_dt.value=payment_due_dt;
        document.form.cnt_inv.value=sheetObjects[0].RowCount();
        /**         				
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1, asaNoString);
        } 
         **/
        
    }
    function initCombo (comboObj, comboNo, asaNoString){
        var cnt=0 ;
        var asaNoArray=asaNoString.split("|");	
         switch(comboNo){
            case 1:             
            	comboObj.RemoveAll();
               with (comboObj){                	
            	   SetColAlign(0, "left");
            	   SetColWidth(0, "60");
			             InsertItem(cnt++, '', ''); 
			    	       for(i=0 ;i<asaNoArray.length;i++){             
			               InsertItem(cnt++, asaNoArray[i], asaNoArray[i]);
			             } 	
			    	    }
               break;                                                  
       		}
    }     
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    } 		
    function asa_no_OnChange(comObj,index,text)
    {
       document.form.asa_no.value=comObj.GetSelectCode();
    } 
    function approvalrequest(){
     		var sheetObject=sheetObjects[0];
     		var formObject=document.form;     	
				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
						ComShowMessage(ComGetMsg('TES25001'));
						return false; 
				}
				//if(cnt_cd=="KR"){
				//if(formObject.asanogb.value=="A/P"){				
				if(cnt_cd=="KR"){
						if(formObject.evi_gb.value == ""){
								ComShowMessage(ComGetMsg('TES25002'));
								return false; 
						}else{
								if(formObject.evi_gb.value!="3"){
										if(document.form.eviInputFlg.value != "Y"){
												ComShowMessage(ComGetMsg('TES25003'));
												return false; 
										}
								}
						}
				} 		
				doActionIBSheet(sheetObject,formObject,IBSAVE);   
    }             
 	function eviGbSelect(evi_gb){
	 		if(evi_gb==1){
	 				document.form.evi_gb.value=document.form.evi_gb1.value;
	 		}else if(evi_gb==2){
				document.form.evi_gb.value=document.form.evi_gb2.value;
	 		}
	}
	 /*
	  *  rtnObjPopup(Url, Option);
	  *  noRtnPopup("test.popup.PopTest1.do", "width=310,height=350,menubar=0,status=0,scrollbars=0,resizable=0");
	  * @param String code option
	  *  :
	  */
	 function noRtnPopup(myUrl, myOption) {
	 	myWin=window.open(myUrl, "noRtnPopup", myOption);
	     //myWin.moveTo(0,0);
	 	myWin.focus();
	 } 	 	
