/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0021.js
*@FileTitle  : Restrictions
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var SEARCH_METHOD="";
    var classChkAry = "";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() {         
    	var sheetObject1=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[1] , formObject, IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[1] , formObject, IBRESET);
					break;
				case "srch_imdg_un_no":
					var imdg_un_no=formObject.imdg_un_no.value;
					var imdg_un_no_seq=formObject.imdg_un_no_seq.value;
    	 	    	ComOpenPopup('/opuscntr/VOP_SCG_3005.do?imdg_un_no='+imdg_un_no + '&imdg_un_no_seq=' + imdg_un_no_seq,940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
					break;
				case "srch_irregulars_list":
					var imdg_un_no=formObject.imdg_un_no.value;
    	 	    	if(document.getElementById('srch_irregulars_list').style.color != 'red') imdg_un_no="";
    	 	    	ComOpenWindowCenter("VOP_SCG_0012Pop.do?pgmNo=VOP_SCG_0012&pop_mode=Y&f_cmd=&imdg_un_no="+imdg_un_no, "winIrrList", "1150", "600", true);
					break;
				case "btn_Close":
					ComClosePopup(); 
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
    	 sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl(); 
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Handling Sheet2 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
 	function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObj,document.form,IBCLEAR);  
    	 ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
    	 ComSetObjValue(document.form.imdg_un_no_seq, preConds.imdg_un_no_seq);
    	 ComSetObjValue(document.form.imdg_clss_cd, preConds.imdg_clss_cd);
    	 searchUnNo(sheetObj, document.form);
    	 ComSetObjValue(document.form.pol_port_cd, preConds.pol_port_cd);
    	 ComSetObjValue(document.form.pod_port_cd, preConds.pod_port_cd);
    	 ComSetObjValue(document.form.slan_cd, preConds.slan_cd);
    	 ComSetObjValue(document.form.bkg_no, preConds.bkg_no);
    	 ComSetObjValue(document.form.vsl_cd, preConds.vsl_cd);
    	 ComSetObjValue(document.form.skd_voy_no, preConds.skd_voy_no);
    	 ComSetObjValue(document.form.skd_dir_cd, preConds.skd_dir_cd);
    	 //retrieve
      	 doActionIBSheet(sheetObj , document.form, IBSEARCH);
      	 //retrieve Irregular List
      	 searchIrrForUnNo(preConds.imdg_un_no);
 	}
    // event Catch Listener
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm('keyup', 'obj_keyup', form );
  	    axon_event.addListenerForm('blur', 'obj_blur', form); 
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
        switch(sheetNo) { 
	     	case 1:
	     	    with(sheetObj){
		          var HeadTitle1="|Type|Port Code|Required|Explanation";
	
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
	
		          var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd5",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd6",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd7",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd8",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd8",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
		                 ];
		           		 
		          InitColumns(cols);
		          SetEditable(0);
		          SetCountPosition(0);
		          SetRowHidden(0, 1);
		          //SelectHighLight=false;
		          SetShowButtonImage(1);
		          SetSheetWidth(540);
		          SetSheetHeight(120);
	          	}
	     		break; 
            case 2:      //t2sheet1 init
                with(sheetObj){
            	      var HeadTitle1="||Type|Port Code|Required|Explanation";

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status",              KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"" },	//@@
            	             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"port_type",           KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1, ComboText:"POL|POD|Transit", ComboCode:"1|2|3" },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"port_cd",             KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_cmptn_auth_cd",  KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:1,   SaveName:"txt_desc",            KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 } ];
            	       
            	      InitColumns(cols);
            	      SetEditable(0);
            	      //SelectHighLight=false;
            	      SetShowButtonImage(1);
            	      SetDataLinkMouse("port_cd",1);
//            	      SetSheetHeight(235);
            	      resizeSheet();
               }
               break;
        }
    }
    
    function resizeSheet(){
   	         ComResizeSheet(sheetObjects[1]);
   }
  	// Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction, cRow, pObj) {
  		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBCLEAR:      //initialize
             	formObj.imdg_un_no.focus();
             	formObj.imdg_un_no.select();
             	break;         
         	case IBSEARCH:      //retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                    return;
                }
                ComOpenWait(true);
			 	formObj.f_cmd.value=SEARCH01;
			 	var param=FormQueryString(formObj);
 			 	var sXml=sheetObj.GetSearchData("VOP_SCG_0011GS.do", param);
 			 	var aXml=sXml.split("|$$|");
			 	sXml=sheetObj.GetSearchData("VOP_SCG_0021GS.do", param);
			 	sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
			 	sheetObj.SetColFontUnderline("port_cd",1);
			 	fnCarrierSearchEnd( aXml[0] );
			 	SEARCH_METHOD=ComGetEtcData(aXml[0], "SEARCH_METHOD"); //{class, unno}
                break;
			case IBRESET:      // NEW button
                fnBtnNew();
				formObj.imdg_un_no.focus(); 
				break;
			case IBSEARCH_ASYNC02:  //axon_event prp_shp_nm 
				if(!validateForm(sheetObj,formObj,sAction)){ 
				    return;
				}
	            formObj.f_cmd.value=SEARCH05;
	            var param   =FormQueryString(formObj) ;
 	            var sXml    =sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
	            var prp_shp_nm=ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
	            var imdg_clss_cd_desc=ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
	            var imdg_clss_cd=ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd  		                 
	            var sTotal=ComScgGetTotalValue(sXml);
	            if( sTotal == "0"){
	             	 ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			         formObj.imdg_un_no_seq.value='';
			         formObj.prp_shp_nm.value='';			         
			         formObj.imdg_un_no_seq.focus();
	            }else{
	                 formObj.prp_shp_nm.value=prp_shp_nm;   
	                 formObj.imdg_clss_cd_desc.value=imdg_clss_cd_desc;
	                 formObj.imdg_clss_cd.value=imdg_clss_cd;
	            }
             	break;
			case IBSEARCH_ASYNC03:  //CheckUnNumber
                formObj.f_cmd.value=SEARCH01;
                var param=FormQueryString(formObj) ;
                 var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                var sTotal= ComScgGetTotalValue(sXml);
                if( sTotal == "0"){
             	    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
             	    formObj.imdg_un_no.value="";
             	    formObj.imdg_un_no.focus();
                }else{
           	     	formObj.imdg_un_no_seq.focus();
	           	    var isChk=false;
	          	    if(unData != null && unData.length > 0) {
	         	 	    for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
	         	 	    	if(formObj.imdg_un_no.value == unData[arrIdx]) isChk=true;
	         	 	    }
	          	    } 
	          	    if(isChk) document.getElementById('srch_irregulars_list').style.color="red";
	          	    else document.getElementById('srch_irregulars_list').style.color="#737373";
                }
                break;		             
        }
    }
  	function searchUnNo(sheetObj, formObj) {
  		formObj.f_cmd.value=SEARCH05;
     	var param   =FormQueryString(formObj) ;
      	var sXml    =sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
     	var prp_shp_nm=ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
     	var imdg_clss_cd_desc=ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
     	var imdg_clss_cd=ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd  		                 
     	formObj.prp_shp_nm.value=prp_shp_nm;   
     	formObj.imdg_clss_cd_desc.value=imdg_clss_cd_desc;
     	formObj.imdg_clss_cd.value=imdg_clss_cd;
     	var  Msg=ComScgGetMessageFromXml(sXml );
     	if( Msg != ""){
        	ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
        	formObj.imdg_un_no_seq.value='';
        	formObj.prp_shp_nm.value='';			         
        	formObj.imdg_un_no_seq.focus();
        	return false;
     	}
     	return true;
  	}
  	/**
     * Retrieve Irregular List for Un No.
     */
    var unData;
    function searchIrrForUnNo(imdg_un_no) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	formObj.f_cmd.value=SEARCH07;
    	sheetObj.SetWaitImageVisible(0);
  	   	var sXml=sheetObj.GetSearchData("VOP_SCG_0012GS.do", FormQueryString(formObj));
 	   	sheetObj.SetWaitImageVisible(1);
 	    unData=ComScgXml2Array(sXml, "imdg_un_no");
 	    var isChk=false;
 	    if(unData != null && unData.length > 0) {
	 	    for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
	 	    	if(imdg_un_no == unData[arrIdx]) isChk=true;
	 	    }
 	    } 
 	    if(isChk) document.getElementById('srch_irregulars_list').style.color="red";
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
       	 	switch ( sAction ) {
       	 		case  IBSEARCH:
	       	 		if( !ComChkRequired(formObj) ){
	                    return false;
	                }    	        	  
       	        	break;
       	 	}
        }
        return true;
    }
    /************************************User_event*************************************************/ 	
    /**
     * Retrieving Unno, seq, ClassCd by Unno Help Popup.
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				optional selected Row
     * @param  {Int} col				optional selected Column
     * @param  {Int} sheetIdx		optional Sheet Index
     * @return 없음
     */  
    function setUnnoAndClassCd(aryPopupData) { 
       	with(document.form) {
       		imdg_clss_cd.value=aryPopupData[0][4]; 
       		imdg_clss_cd_desc.value=aryPopupData[0][5];    
       		imdg_un_no.value=aryPopupData[0][2];      
       		imdg_un_no_seq.value=aryPopupData[0][3];          		
       		prp_shp_nm.value=aryPopupData[0][6]; 
	    }
    }
    /**
     *  Handling after retrieving Carrier.
     *  
     */
    /**
     *  Handling after retrieving Carrier.
     *  
     */
    function fnCarrierSearchEnd( sXml ){
        if( sXml == ""){
        	return;
        }
        var total=eval( ComScgGetTotalValue(sXml) );
        var rowNum=1;
        if( total > 0){
        	sheetObjects[0].RemoveAll();
        	sheetObjects[0].DataInsert(-1);
        }
        /*var j=-1;
        for(var i=1;i<=total;i++){
//            var value=ComScgGetRowValue(sXml, i, "vsl_opr_tp_cd");   
        	var vAry = ComScgXml2Array(sXml, "vsl_opr_tp_cd");
        	
            if ( j < sheetObjects[0].LastCol()){
                j++;
            }else{
            	j=0;
            	sheetObjects[0].DataInsert(-1);
            	rowNum++;             	
            }
//            sheetObjects[0].SetCellValue(rowNum, j,value,0);
            sheetObjects[0].SetCellValue(rowNum, i,vAry[v]);
            
            sheetObjects[0].SetDataLinkMouse(j,1);
            sheetObjects[0].SetColFontUnderline(j,1);
        }*/
        
        var j=-1;
        var vAry = ComScgXml2Array(sXml, "vsl_opr_tp_cd");
        var vAry2 = ComScgXml2Array(sXml, "imdg_clss_cd");

        if(vAry != undefined){
            var totalAry = new Array();
            classChkAry = new Array();
            var l = 0;
            for(var k=0; k < vAry.length; k++){
            	//if(k%2==1){
            		totalAry[l] = vAry[k];
            		classChkAry[l] = vAry2[k];
            		l++;
            	//}
            }
            
            for(var i=0; i< totalAry.length; i++){
//                var value=ComScgGetRowValue(sXml, i, "vsl_opr_tp_cd");   
    	         if ( j < sheetObjects[0].LastCol() ){
    		         j++;
    		     }else{
    			     j=0;
    			     sheetObjects[0].DataInsert(-1);            	
    			     rowNum++;
    		     }
           	 
           	 sheetObjects[0].SetCellValue(rowNum, j, ""+totalAry[i]);
           	 sheetObjects[0].SetDataLinkMouse(j, true);
           	 sheetObjects[0].SetColFontUnderline(j, true);
           	  
           	 //sheetObjects[0].SetMouseToolTipText(j, clssTotalAry[i]);
            }
            
            /*var j = -1;
            var totalStr = "AAA,BBB,CCC";
            var totalAry = totalStr.split(",");
            for(var i=0; i< totalAry.length; i++){
           	 
    	         if ( j < sheetObjects[0].LastCol() ){
    		         j++;
    		     }else{
    			     j=0;
    			     sheetObjects[0].DataInsert(-1);            	
    			     rowNum++;
    		     }
           	 
           	 sheetObjects[0].SetCellValue(rowNum, j, totalAry[i]);
           	 sheetObjects[0].SetDataLinkMouse(j, true);
           	 sheetObjects[0].SetColFontUnderline(j, true);
            }*/
            
            for(var i=sheetObjects[1].HeaderRows();i<=sheetObjects[1].RowCount();i++){
            	if ( sheetObjects[1].GetCellValue( i, "imdg_cmptn_auth_cd")   == "Prohibition"  ){
                     sheetObjects[1].SetCellFontColor( i, "imdg_cmptn_auth_cd","#FF0000");
               }
            }        	
        }

    }  
    /*function fnCarrierSearchEnd( sXml ) {
    	 if( sXml == ""){
         	return;
         }
         var total=eval( ComScgGetTotalValue(sXml) );
         var rowNum=1;
         if( total > 0){
         	sheetObjects[0].RemoveAll();
         	sheetObjects[0].DataInsert(-1);
         }
         var j=-1;
         for(var i=1;i<=total;i++){
             var value=ComScgGetRowValue(sXml, i, "vsl_opr_tp_cd");    
             if ( j < sheetObjects[0].LastCol()){
                 j++;
             }else{
             	j=0;
             	sheetObjects[0].DataInsert(-1);
             	rowNum++;             	
             }
             sheetObjects[0].SetCellValue(rowNum, j,value,0);
             sheetObjects[0].SetDataLinkMouse(j,1);
             sheetObjects[0].SetColFontUnderline(j,1);
         }
         for(var i=sheetObjects[1].HeaderRows();i<=sheetObjects[1].RowCount();i++){
        	 if ( sheetObjects[1].GetCellValue( i, "imdg_cmptn_auth_cd")   == "Prohibition"  ){
        		 sheetObjects[1].SetCellFontColor( i, "imdg_cmptn_auth_cd","#FF0000");
            }
         }
    }*/
    /**
     * Handling NEW button. 
     * @return
     */
    function fnBtnNew() {
   	  	var formObj=document.form;
   	  	fnNewGrid();
   	  	formObj.imdg_un_no.value='';	         
   	  	formObj.imdg_un_no_seq.value='';	
   	  	formObj.prp_shp_nm.value='';		
   	  	formObj.imdg_clss_cd.value=""; 	            	
   	  	formObj.imdg_clss_cd_desc.value=""; 
   	  	document.getElementById('srch_irregulars_list').style.color="#737373";
    }
    /**
     * 
     * <pre>
     *    Grid data clear
     * </pre>
     *
     * @param   
     * @return
     * @author
     */
    function fnNewGrid() {
        for(var i=0;i<sheetObjects.length;i++){
            var cnt=sheetObjects[i].RowCount();
            for(var j=1;j<= cnt;j++ ) {
                sheetObjects[i].RowDelete(1, false);
            }
        }
    }
    /************************************Sheet_event*************************************************/ 	     
 	function sheet1_OnClick(sheetObj,Row,Col,Value) {
 		var formObj=document.form;
 		if( Value != ""){
			var  imdg_clss_cd=formObj.imdg_clss_cd.value;
			var  imdg_clss_cd_desc=formObj.imdg_clss_cd_desc.value;
			var  imdg_un_no=formObj.imdg_un_no.value;
			var  imdg_un_no_seq=formObj.imdg_un_no_seq.value;
			var  prp_shp_nm=formObj.prp_shp_nm.value; 
 			var  sUrl="/opuscntr/VOP_SCG_0010Pop.do?pgmNo=VOP_SCG_0010";
 			
 			var idx = parseInt(((Row - 1) * 8) + Col);
 			
 			if(classChkAry[idx][0].indexOf("X") >= 0){
 				SEARCH_METHOD = "unno";
 			}else{
 				SEARCH_METHOD = "class"; 
 				imdg_un_no = "";
 				imdg_un_no_seq = "";
 				prp_shp_nm = "";
 			 }
 			 var  param="&pCrr_cd="+Value;
 			 param          += "&pImdg_clss_cd="+imdg_clss_cd;
 			 param          += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
 			 param          += "&pImdg_un_no="+imdg_un_no;
 			 param          += "&pImdg_un_no_seq="+imdg_un_no_seq;    
             param          += "&pPrp_shp_nm="+prp_shp_nm;
             param          += "&pSearchMethod="+SEARCH_METHOD
             param          += "&pop_mode=Y";
             sUrl += param;
//             var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
//             var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0;  	
// 			 var iWidth=1050;
// 			 var iHeight=705;             
// 			 var sFeatures="scroll:no;status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos;
// 			 ComOpenWindow(sUrl,"VOP_SCG_0010",sFeatures, false);
 			 ComOpenPopup(sUrl, 1050, 660, "VOP_SCG_0021", "0,0,1,1,1,1,1", true);
// 			ComOpenPopup(sUrl + param, iWidth, iHeight, "", "1,0,1,1,1", true);
 		}
	}
 	function sheet2_OnClick(sheetObj,Row,Col,Value) {
 		var formObj=document.form;
 		if( sheetObj.ColSaveName(Col) == "port_cd" ){
            var  imdg_clss_cd=formObj.imdg_clss_cd.value;
            var  imdg_clss_cd_desc=formObj.imdg_clss_cd_desc.value;
            var  imdg_un_no=formObj.imdg_un_no.value;
            var  imdg_un_no_seq=formObj.imdg_un_no_seq.value;
            var  prp_shp_nm=formObj.prp_shp_nm.value; 
            var sUrl="/opuscntr/VOP_SCG_0006Pop.do?pop_mode=Y&pgmNo=VOP_SCG_0006&pPort_cd="+Value;
            var  param="&pCrr_cd="+Value;
	            param += "&pImdg_clss_cd="+imdg_clss_cd;
	            param += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
	            param += "&pImdg_un_no="+imdg_un_no;
	            param += "&pImdg_un_no_seq="+imdg_un_no_seq;    
	            param += "&pPrp_shp_nm="+prp_shp_nm;
            sUrl += param;
             var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
             var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0; 			
 			 var iWidth=1040;
 			 var iHeight=950;
 			 var sFeatures="status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos;
 			ComOpenWindow(sUrl,"VOP_SCG_0006",sFeatures, false);
// 			ComOpenWindow(sUrl, sUrl, sFeatures, true);		 
// 			ComOpenPopup(sUrl + param, iWidth, iHeight, "", "1,0,1,1,1", true);
 		}
	} 
    /**
     * Handling Form Object  blur event
     * @param  void
     * @return void
     */     
    function obj_blur () {
    	var obj=ComGetEvent();
	  	var formObj=document.form;
	  	switch(ComGetEvent("name")) {
	  		case 'imdg_un_no':
	  			if(obj.value != '') {
		  			if(!ComChkObjValid(formObj.imdg_un_no) ){
		  				return;
			        }else{
			            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);                         
			        }
	  			}
		        break;
		    case 'imdg_un_no_seq':
		    	if(obj.value != '') {
			        if( !ComChkObjValid( formObj.imdg_un_no_seq) ){
		                return;
			        }else{
		                doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02); 	 	                  
			        }
		    	}
	            break;         
	  	  }
    }  
    /**
     * Handling Form obj_keyup event
     * @param  void
     * @return void
     */ 
    function obj_keyup() {
    	 var obj=ComGetEvent();	  	  
	  	 var formObj=document.form;
	  	 switch(ComGetEvent("name")) {
	  	 	case 'imdg_un_no':
	        	if( formObj.imdg_un_no.value.length == 4 ){
	        		formObj.imdg_un_no_seq.focus();
	        	}else{
	        		fnNewGrid();                          
	        		formObj.imdg_un_no_seq.value='';    
	        		formObj.prp_shp_nm.value='';        
	        		formObj.imdg_clss_cd.value="";                  
	        		formObj.imdg_clss_cd_desc.value="";                 
	        	}
	        	break;   
	  	 	case 'imdg_un_no_seq':
	  	 		fnNewGrid();                          
	  	 		formObj.prp_shp_nm.value='';        
	  	 		formObj.imdg_clss_cd.value="";                  
	  	 		formObj.imdg_clss_cd_desc.value=""; 
	  	 		break;                 
	  	}             
    }

    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }

    function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }