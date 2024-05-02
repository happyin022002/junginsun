/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0080.js
*@FileTitle  : Terminal invoice CSR Creation -Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
var comboObjects=new Array();
var comboCnt=0 ; 
//var rdObjects=new Array(); //2016.07.05 HTML5 RD 주석처리
//var rdCnt=0;               //2016.07.05 HTML5 RD 주석처리
var approvalFlg="";

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
         //var rdObject=rdObjects[0]; //2016.07.05 HTML5 RD 주석처리
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_close":
					ComClosePopupModal(); 
					
	        break;
				case "btng_print":	
				    viewer.print({isServerSide:true});
					//rdObject.PrintDialog(); //2016.07.05 HTML5 RD 주석처리
					break;
				case "btng_approvalrequest":					
					if(approvalFlg==""){
						var opener_obj;
						opener_obj=window.dialogArguments;
						if (!opener_obj)  opener_obj=window.opener;  //이 코드 추가할것
						if (!opener_obj) opener_obj=parent; //이 코드 추가할것
						
						opener_obj.approvalrequest();
					}
					
					approvalFlg="Y";
//					setTimeout("window.focust()" , 1000);

					//window.close();
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
     * @param {ibsheet} sheet_obj	ibsheet object
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
		if (previewFlgYN!=undefined && previewFlgYN=='Y'){
			document.all.item("btng_approvalrequest_yn")[0].style.display="inline";
			document.all.item("btng_approvalrequest_yn")[1].style.display="none";
		} else {
			document.all.item("btng_approvalrequest_yn")[0].style.display="none";
			document.all.item("btng_approvalrequest_yn")[1].style.display="inline";
			
//			ComShowMessage(ComGetMsg('TES25021')); 
		}
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
       	resizeSheet();
       	rdOpen();	
    }
    
   /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj 	==> 
     * @param {int}		sheetNo 	==>  
     * adding case as numbers of counting sheets
     * 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	                var HeadTitle="Seq.||Invoice No.|Net Amount|Tax Amount|Total Amount" ;
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"ttl_inv_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"vat_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Status",    Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                InitColumns(cols);
	                SetEditable(1);
//	                SetSheetHeight(ComGetSheetHeight(sheetObj,13));   
	                
                }
                break;


        }
    }
    
    /**
     *  auto resize
     */
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
    
    
    
  // handling sheet process
	/**
	 * @param {ibsheet} sheetObj 	
     * @param {form}	formObj		
     * @param {String}	sAction     
	 */  
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
               	formObj.f_cmd.value=SEARCHLIST;                  
               	sheetObj.DoSearch("ESD_TES_0024GS.do", tesFrmQryStr(formObj) );
                break; 
           case IBCOPYROW:        //row copy
              sheetObj.DataCopy();
              break
        }
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
	 /**
     * MInimize click event
     * @param {String} nItem	
     */
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
	    	    objs.style.display="none";
//no support[check again]CLT 	    	    sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(20);
	    	    sheetObjects[0].SetSheetHeight(ComGetSheetHeight(20));
				sheetObjects[0].focus();
//no support[check again]CLT 				sheetObjects[0].ViewRows=20; 
				}
	    	else
	    	{
	    	    objs.style.display="inline";
//no support[check again]CLT 	    	    sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(10);
	    	    sheetObjects[0].SetSheetHeight(ComGetSheetHeight(10));
				sheetObjects[0].focus();
//no support[check again]CLT 				sheetObjects[0].ViewRows=10;
	    	}
    }
	function rdOpen(){//alert("start rdOpen");		
		var sXml="";		
		var i=0;
		var j=0; 
		
		//var opener_obj = window.dialogArguments;
		//if (!opener) opener_obj = window.opener;
		//if (!opener) opener_obj = parent;		
		
		var opener_obj = window.opener;
		var opener_sheet_obj1=opener_obj.sheet2;
		var opener_sheet_obj2=opener_obj.sheet3;
		var fromObj=new Array();
		var rdObj=new Array();
		fromObj[0]=document.form;                           
		rdObj[0]=opener_sheet_obj1;     
		rdObj[1]=opener_sheet_obj2;
		sXml="<?xml version='1.0' ?><SHEET>";
		sheetCnt=1;
		for(i=0;i<2;i++){
				sheetCnt=i+1;
				if(rdObj[i].RowCount()==0){
						sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
						for(j=0;j<=rdObj[i].LastCol();j++){
								sXml +="<TD></TD>";
						}
						sXml +="</TR></DATA></SHEET"+sheetCnt+">";
				}else{
						sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
				}			
		}
		sXml +="</SHEET>"; 
		if ( rdObj[0].RowCount()== "0")
		{
			ComShowMessage(ComGetMsg("TES10078"));
			return;
		}
		
        //viewer.AutoAdjust=false; //2016.07.05 HTML5 RD 지원 안함.
        //viewer.HideStatusBar(); //2016.07.05 HTML5 RD 지원 안함.
        //viewer.ViewShowMode(2); //2016.07.05 HTML5 RD 지원 안함.
        //viewer.SetBackgroundColor(255,255,255);//2016.07.05 HTML5 RD 지원 안함.
        //viewer.SetPageLineColor(255,255,255);//2016.07.05 HTML5 RD 지원 안함.
        //viewer.ApplyLicense("0.0.0.0"); //2016.07.05 HTML5 RD 지원 안함.
		viewer.zoom = 110; //ZoomRatio
		viewer.setRData(sXml); //SetRData(sXml); 
        
        if(previewFlg =="krjp"){            
            viewer.openFile(RD_path+'apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0080krjp.mrd', '', {timeout:1800});                 
        }else{
            viewer.openFile(RD_path+'apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0080.mrd', '', {timeout:1800});                     
        }
		
        //2016.07.05 HTML5 RD 주석처리
        /*
		//RD_path = "http://siy:7001/opuscntr/";
		rdObjects[0].AutoAdjust=false;
		rdObjects[0].ZoomRatio = 110;
		//rdObjects[0].HideToolBar();
		rdObjects[0].HideStatusBar();
		rdObjects[0].ViewShowMode(2);
		rdObjects[0].SetBackgroundColor(255,255,255);
		rdObjects[0].SetPageLineColor(255,255,255);
		rdObjects[0].ApplyLicense("0.0.0.0"); 
		rdObjects[0].SetRData(sXml); 
		
		if(previewFlg =="krjp"){			
				rdObjects[0].FileOpen(RD_path+'apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0080krjp.mrd', '');					
		}else{
				rdObjects[0].FileOpen(RD_path+'apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0080.mrd', ''); 					
		}*/
	}
//	// UI 표준화관련 하단 여백 설정
//	function resizeSheet() {
//		    ComResizeSheet(sheetObjects[0]);
//	}