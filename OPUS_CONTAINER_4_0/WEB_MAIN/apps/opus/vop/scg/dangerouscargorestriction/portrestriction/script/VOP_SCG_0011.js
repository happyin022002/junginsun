/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0011.js
 *@FileTitle : Port & VSL OPR's Restriction En-route
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
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
 var comboObjects=new Array();
 var comboCnt=0; 
 var SEARCH_METHOD="";
 var classChkAry = "";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
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
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
      /**
      * register IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
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
         initControl();         
		 doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBCLEAR);        
		 pod_port_rotn_seq.SetSelectIndex(0);
		 pol_port_rotn_seq.SetSelectIndex(0);
		 slan_cd.SetSelectIndex(0);
		 resizeSheet();
     }
      /**
       * retrieving Irregular List for Un No.
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
      * 
      * @return
      */
      function initControl() {
    	 var formObj=document.form;
//    	 axon_event.addListener ('keydown', 	'ComKeyEnter', 	'form');
     	 axon_event.addListenerForm('keyup',   'obj_keyup',     form );
   	     axon_event.addListenerForm('blur',  	  'obj_blur'      ,form); 
//       axon_event.addListenerForm('beforedeactivate', 'obj_blur_deact',form); 
         axon_event.addListener    ('click',   'img_click',   	"srch_imdg_un_no");
         axon_event.addListener    ('click',   'img_click',   	"srch_pol_port_cd");
         axon_event.addListener    ('click',   'img_click',   	"srch_pod_port_cd");
         axon_event.addListener    ('click',   'img_click',   	"srch_irregulars_list");     
         // Initializing IBMultiCombo
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }         
      }   
      /**
       * Initializing Combo
       * Setting Combo items.
       */
      function initCombo(comboObj, comboNo) {  
	 	    switch(comboObj.id) {
	 	        case "slan_cd":
	 	            with(comboObj) {
	 	            	SetTitle("Code|CodeName");	 	            	
	 	            	SetColAlign(0, "center");
	 	            	SetColAlign(1, "left");
	 	            	SetColWidth(0, "50");
	 	            	SetColWidth(1, "400");
	 	            	SetDropHeight(200);
	 	            	SetMultiSelect(0);
	 	            	SetUseAutoComplete(1);
//no support[check again]CLT 	                    ValidChar(2,1);
	                    SetMaxLength(3);
	 	            }
	 	            break;	
		        case "pol_port_rotn_seq":
		            with(comboObj) {
		        		SetColWidth(0, "40");
		            	SetDropHeight(190);
		            	SetMultiSelect(0);
		            	SetMaxSelect(1);
		            	SetUseAutoComplete(0);
		        		SetEnable(0);
		            }
		            break;
		        case "pod_port_rotn_seq":
		            with(comboObj) {
		        		SetColWidth(0, "40");
		            	SetDropHeight(190);
		            	SetMultiSelect(0);
		            	SetMaxSelect(1);
		            	SetUseAutoComplete(0);
		        		SetEnable(0);
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
         var cnt=0;
         switch(sheetNo){ 
		     case 1:      //t2sheet1 init
		     with (sheetObj) {
		    	 var HeadTitle1="|Type|Port Code|Required|Explanation";

		    	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

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
		    	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd8",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		    	  
		    	 InitColumns(cols);
		    	 SetSheetWidth(520);
		    	 SetSheetHeight(120);
		    	 SetEditable(0);
		    	 SetCountPosition(0);
		    	 SetRowHidden(0, 1);
		    	 SetShowButtonImage(2);
		     }
		     break; 
             case 2:      //t2sheet1 init
                with (sheetObj) {
            	 var HeadTitle1="|Type|Port Code|Required|Explanation";

            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status",              KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"port_type",           KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1, ComboText:"POL|POD|Transit", ComboCode:"1|2|3"},
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"port_cd",             KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_cmptn_auth_cd",  KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:1,   SaveName:"txt_desc",            KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:1,   InsertEdit:1 } ];
            	  
            	 InitColumns(cols);
            	 SetSheetHeight(235);
            	 SetEditable(0);
            	 SetShowButtonImage(2);
            	 SetDataLinkMouse("port_cd",1);
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
//	             formObj.f_cmd.value = SEARCH02;
//	             var param      =  FormQueryString(formObj)+"&vsl_slan_cd=" ;
//	             var sXml       =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);		
//	             ComXml2ComboItem(sXml, slan_cd, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
                 clearComboObj();
		         formObj.imdg_un_no.focus();
		         formObj.imdg_un_no.select();
	             break;         
            case IBSEARCH:      //retrieve
                 if(!validateForm(sheetObj,formObj,sAction)){
                     return;
                 }
				 formObj.f_cmd.value=SEARCH01;
				 var param=FormQueryString(formObj);
 				 var sXml=sheetObj.GetSearchData("VOP_SCG_0011GS.do", param);
				 var aXml=sXml.split("|$$|")
				// sheetObjects[0].LoadSearchXml( aXml[0] );
				 sheetObjects[1].LoadSearchData(aXml[1],{Sync:1} );
				 sheetObj.SetColFontUnderline("port_cd",1);
				 fnCarrierSearchEnd( aXml[0] );
				 SEARCH_METHOD=ComGetEtcData(aXml[0], "SEARCH_METHOD"); //{class, unno}
                 break;
 			case IBRESET:      // NEW button
                 fnBtnNew();
                 clearComboObj();
                 formObj.imdg_un_no.focus();
 			     break;
 			case IBSEARCH_ASYNC01:  //axon_event checkPort
				    if(!validateForm(sheetObj,formObj,sAction) ){ 
					    return;
					}
		            formObj.f_cmd.value=SEARCH09;
		            var param="f_cmd="+formObj.f_cmd.value+"&port_cd="+pObj.value ;
 		            var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
		            var port_cd_nm=ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm              
		            var Msg=ComScgGetMessageFromXml(sXml );
		            if( Msg  != ""){
 				    	 if( pObj.name == "pol_port_cd"){
 		                 	 ComShowCodeMessage("SCG50010", 'Data'); 	
					         formObj.pol_port_cd.value='';	 		                 	 
					         formObj.pol_port_cd.focus();			    		 
				    	 }else if( pObj.name == "pod_port_cd"){
 		                 	 ComShowCodeMessage("SCG50010", 'Data'); 					    		 
					         formObj.pod_port_cd.value='';				    		 
					         formObj.pod_port_cd.focus();			    		 
 				    	 } 
		            }else{
				    	 if( pObj.name == "pol_port_cd"){
					         formObj.pod_port_cd.focus();			    		 
				    	 }else if( pObj.name == "pod_port_cd"){ 
                             doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC04);
				    	 }
		            }
		       break;
			case IBSEARCH_ASYNC02:  //axon_event prp_shp_nm 
			     if(!validateForm(sheetObj,formObj,sAction)){ 
				    return;
				 }
	             formObj.f_cmd.value=SEARCH05;
	             var param   =FormQueryString(formObj)+"&imdg_un_no_hld_flg=Y" ;//imdg_un_no_hld_flg: to get IrrList 
 	             var sXml    =sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
	             var prp_shp_nm=ComGetEtcData(sXml,"prp_shp_nm"  );   //prp_shp_nm  
	             var imdg_clss_cd_desc=ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
	             var imdg_clss_cd=ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd  		                 
//                 var irregular_reg_yn            =  ComGetEtcData(sXml,"irregular_reg_yn");   //irregular_reg_yn
                 var sTotal=ComScgGetTotalValue(sXml);
//                 document.getElementById('srch_irregulars_list').style.color = "#737373";

                 if( sTotal == "0"){
                 	 ComShowCodeMessage("SCG50010", 'Data');
			         formObj.imdg_un_no_seq.value='';
			         formObj.prp_shp_nm.value='';			         
                     formObj.imdg_clss_cd.value="";                  
                     formObj.imdg_clss_cd_desc.value="";  
			         formObj.imdg_un_no_seq.focus();
	             }else{
//	                 if(irregular_reg_yn == "Y"){
//	                     document.getElementById('srch_irregulars_list').style.color = "red";
//	                 }else{
//	                     document.getElementById('srch_irregulars_list').style.color = "#737373";	                    
//	                 }
	                 formObj.prp_shp_nm.value=prp_shp_nm;   
	                 formObj.imdg_clss_cd_desc.value=imdg_clss_cd_desc;
	                 formObj.imdg_clss_cd.value=imdg_clss_cd;
			        // formObj.pol_port_cd.focus();	            	 
	             }
	             break;
			case IBSEARCH_ASYNC03:  //CheckUnNumber
                 formObj.f_cmd.value=SEARCH01;
                 var param=FormQueryString(formObj) ;
                  var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                 var sTotal=ComScgGetTotalValue(sXml);
                 if( sTotal == "0"){
              	     ComShowCodeMessage("SCG50010", 'Data');
              	     formObj.imdg_un_no.value="";
              	     formObj.imdg_un_no.focus();
                 }else{  
            	     formObj.f_cmd.value=SEARCH05;
		             var param   =FormQueryString(formObj)+"&imdg_un_no_hld_flg=Y" ;//imdg_un_no_hld_flg: to get IrrList 
 		             var sXml    =sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
		             var irregular_reg_yn=ComGetEtcData(sXml,"irregular_reg_yn");   //irregular_reg_yn
	                 if(irregular_reg_yn == "Y"){
	                     document.getElementById('srch_irregulars_list').style.color="red";
	                 }else{
	                     document.getElementById('srch_irregulars_list').style.color="#737373";	                    
	                 }
	                 formObj.imdg_un_no_seq.focus();
                 }
                 break;		 
	         case IBSEARCH_ASYNC04:      //retrieve Target Lane 
                 formObj.f_cmd.value=SEARCH11;
                 var param=FormQueryString(formObj);
                  var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
                 ComXml2ComboItem(sXml, slan_cd, "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
                 var sTotal=ComScgGetTotalValue(sXml);
//                 slan_cd.Focus;
                 //}                 
                 break;                   
	         case IBSEARCH_ASYNC05:    //retrieve Port Clpt Seq 
	        	 formObj.f_cmd.value=SEARCH02;
	 			var formParams="";
	 			var polXml="";
	 			var podXml="";
	     		formParams="f_cmd="+ComGetObjValue(formObj.f_cmd)+"&slan_cd="+ComGetObjValue(slan_cd)+"&pol_port_cd="+ComGetObjValue(formObj.pol_port_cd);         		
 	     		var polXml=sheetObj.GetSearchData("VOP_SCG_0011GS.do", formParams);
	     		if(ComScgGetTotalValue(polXml) > 0) {
    	  			comboObjects[0].SetEnable(1);
		     		ComXml2ComboItem(polXml, pol_port_rotn_seq, "clpt_seq", "clpt_seq");	     			
    	  			comboObjects[0].SetSelectIndex(0);
	     		}
	     		formParams="f_cmd="+ComGetObjValue(formObj.f_cmd)+"&slan_cd="+ComGetObjValue(slan_cd)+"&pod_port_cd="+ComGetObjValue(formObj.pod_port_cd);         		
 	     		var podXml=sheetObj.GetSearchData("VOP_SCG_0011GS.do", formParams);
	     		if(ComScgGetTotalValue(podXml) > 0) {
    	  			comboObjects[1].SetEnable(1);
		     		ComXml2ComboItem(podXml, pod_port_rotn_seq, "clpt_seq", "clpt_seq");
    	  			comboObjects[1].SetSelectIndex(0);
	     		}
	     		break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
		 switch (sAction) {
		          case  IBSEARCH:
		        	  if( !ComChkRequired(formObj) ){
	                      return false;
	                  }
		        	  if(slan_cd.GetSelectText()== ""){
	 		    	     ComShowCodeMessage('SCG01001', 'Target Lane');   
			    	     slan_cd.Focus;
			    	     return false;     
		        	  }        	        	  
		        	  if( formObj.pol_port_cd.value.length != 5){
		        		  ComShowCodeMessage('SCG50006', 'POL', '5');
		        		  formObj.pol_port_cd.focus();
		        		  return false;   
		        	  }		        	  
		        	  if( formObj.pod_port_cd.value.length != 5){
		        		  ComShowCodeMessage('SCG50006', 'POD', '5');
		        		  formObj.pod_port_cd.focus();
		        		  return false;   
		        	  }
		        	  break;
		 }
         return true;
     }
    /************************************User_event*************************************************/ 	
    /**
     * Retrieving Unno, seq, ClassCd by Unno Help Popup.
     * @param  {Array} aryPopupData	compulsory	 Array Object
     * @param  {Int} row				optional selected Row
     * @param  {Int} col				optional selected Column
     * @param  {Int} sheetIdx		optional Sheet Index
     * @return none
     */  
     function setUnnoAndClassCd(aryPopupData){ 
        	with(document.form){
        		imdg_clss_cd.value=aryPopupData[0][4]; 
        		imdg_clss_cd_desc.value=aryPopupData[0][5];    
        		imdg_un_no.value=aryPopupData[0][2];      
        		imdg_un_no_seq.value=aryPopupData[0][3];          		
        		prp_shp_nm.value=aryPopupData[0][6]; 
        		
        		imdg_un_no_seq_onChange();
 	       }
     }
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
     /**
      * Handling NEW button. 
      * @return
      */
     function fnBtnNew(){
    	  var formObj=document.form;
    	  fnNewGrid();
    	  formObj.imdg_un_no.value='';	         
     	  formObj.imdg_un_no_seq.value='';	
      	  formObj.prp_shp_nm.value='';		
      	  formObj.imdg_clss_cd.value=""; 	            	
      	  formObj.imdg_clss_cd_desc.value=""; 	
      	  formObj.pod_port_cd.value="";
      	  formObj.pol_port_cd.value="";
      	  slan_cd.SetSelectText("",false);
      	  slan_cd.RemoveAll();
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
     function fnNewGrid(){
         for(var i=0;i<sheetObjects.length;i++){
             var cnt=sheetObjects[i].RowCount();
             for(var j=1;j<= cnt;j++ ){
                 sheetObjects[i].RowDelete(1, false);
             }
         }
     }
    /************************************Sheet_event*************************************************/ 	     
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
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
             var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
             var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0;  	
 			 var iWidth=1026;
 			 var iHeight=660;             
 			 var sFeatures="scroll:no;status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos+ ";scroll-y:no";
 			 ComOpenWindow(sUrl,"VOP_SCG_0010",sFeatures, true);
 		}
 	}
//  	function sheet2_OnClick(sheetObj,Row,Col,Value){
//        var formObj=document.form;
// 		if( sheetObj.ColSaveName(Col) == "port_cd" ){
//            var  imdg_clss_cd=formObj.imdg_clss_cd.value;
//            var  imdg_clss_cd_desc=formObj.imdg_clss_cd_desc.value;
//            var  imdg_un_no=formObj.imdg_un_no.value;
//            var  imdg_un_no_seq=formObj.imdg_un_no_seq.value;
//            var  prp_shp_nm=formObj.prp_shp_nm.value; 
//            var sUrl="/opuscntr/VOP_SCG_0006Pop.do?pgmNo=VOP_SCG_0006&pop_mode=Y&pPort_cd="+Value;
//            var  param="&pCrr_cd="+Value;
//            param          += "&pImdg_clss_cd="+imdg_clss_cd;
//            param          += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
//            param          += "&pImdg_un_no="+imdg_un_no;
//            param          += "&pImdg_un_no_seq="+imdg_un_no_seq;    
//            param          += "&pPrp_shp_nm="+prp_shp_nm;
//            sUrl += param;
////             var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
////             var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0; 			
// 			 var iWidth=1040;
// 			 var iHeight=950;
//// 			 var sFeatures="status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos;
// 			var sFeatures="status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px";//+"px;dialogLeft:" + leftpos + ";dialogTop:"+0;
// 			ComOpenWindow(sUrl, sUrl, sFeatures, true);		 
// 		}
// 	}
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
	            param += "&pSearchMethod="+SEARCH_METHOD
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
     * Handling Lane Code OnChange
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
    function slan_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange (comboObj, code, text) {
        clearComboObj();
        var formObj=document.form; 
    	doActionIBSheet(sheetObjects[1] , formObj, IBSEARCH_ASYNC05);
    } 	

    function slan_cd_OnKeyDown(comboObj, KeyCode, Shift){
        var formObj=document.form;
        //slan_cd.className = "input2_1";
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    }
    /************************************Axon_event*************************************************/
      /**
       * HandlingForm Object  blur event
       * @param  void
       * @return void
       */     
       function obj_blur (){
 	  	    var obj=ComGetEvent();
 	  	    var formObj=document.form;
 	  	    switch (ComGetEvent("name")){
                case 'imdg_un_no':
                    if( !ComChkObjValid( formObj.imdg_un_no) ){
                        return;
                    }else{
                        doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);                         
                    }
                    break;
 	            case 'imdg_un_no_seq':
                      if( !ComChkObjValid( formObj.imdg_un_no_seq) ){
                          return;
 	 	              }else{
                          doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02); 	 	                  
 	 	              }
 	                  break;
 	            case 'pol_port_cd':
 	                 if( !ComChkObjValid( formObj.pol_port_cd) ){
     		    	     return;
                      } 
	                  break; 
// 	            case 'pod_port_cd':
//                      if( !ComChkObjValid( formObj.pod_port_cd) ){
//                        obj.focus();
//                        obj.select();
//                          return;
//                      }
//	                  break; 	            
// 	  	        }
 	  	    }
       }
       
       function imdg_un_no_seq_onChange (){
    	   doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC02);
       }
       
       function obj_blur_deact (){
           var obj=ComGetEvent();
           var formObj=document.form;
           switch(ComGetEvent("name")){
               case 'pod_port_cd':
                     if( !ComChkObjValid( formObj.pod_port_cd) ){
                         return;
                     }
                     break;                
           }
      }        
       /**
        * Handling Form obj_keyup event
        * @param  void
        * @return void
        */         
       function obj_keyup(){
	  	    var obj=ComGetEvent();	  	  
 	  	    var formObj=document.form;
 	  	    switch (ComGetEvent("name")){
 	            case 'imdg_un_no':
 	     	          if( formObj.imdg_un_no.value.length == 4 ){
 	     	              formObj.imdg_un_no_seq.focus();
 	 	              }else{
                          fnNewGrid();                          
                          formObj.imdg_un_no_seq.value='';    
                          formObj.prp_shp_nm.value='';        
                          formObj.imdg_clss_cd.value="";                  
                          formObj.imdg_clss_cd_desc.value="";     
                          formObj.pol_port_cd.value="";
                          formObj.pod_port_cd.value="";
                          slan_cd.SetSelectText("",false);
                          document.getElementById('srch_irregulars_list').style.color="#737373";                                
 	 	              }
 	                  break;   
 	            case 'imdg_un_no_seq':
//                        fnNewGrid();                          
//                        formObj.prp_shp_nm.value='';        
//                        formObj.imdg_clss_cd.value="";                  
//                        formObj.imdg_clss_cd_desc.value="";     
//                        formObj.pol_port_cd.value="";
//                        formObj.pod_port_cd.value="";
//                        slan_cd.SetSelectText("",false);
	                  break;  
 	            case 'pol_port_cd':
	     	          if( obj.value != "" && obj.value.length == 5 ){    
	     	        	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, 0, obj);
	 	              }else{
                          fnNewGrid();                          
                          formObj.pod_port_cd.value="";
                          slan_cd.SetSelectText("",false);
	 	              }
	                  break;
 	            case 'pod_port_cd':
	     	          if( obj.value != "" && obj.value.length == 5 ){     
	     	        	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, 0, obj);
                      }else{
                          fnNewGrid();                          
                          slan_cd.SetSelectText("",false);
                      }
	                  break;	                  
 	  	    } 	            
       }
       
   	/*
   	 * =====================================================================
   	 * Pop Up Data
   	 * =====================================================================
   	 */
   	/**
   	 * Handling data from Port Code Help (Pop-Up)
   	 * @param rtnObjs
   	 * @return
   	 */
   	function returnPortHelp1(rtnObjs){
   		var formObj=document.form;
   		var sheetObj=null;
   		if(rtnObjs){
   			var rtnDatas=rtnObjs;
   			if(rtnDatas){
   				if(rtnDatas.length > 0){
   					formObj.pol_port_cd.value=rtnDatas;
   					clearAllFormData(formObj, "POL");
   				}
   			}
   		}
   	}
   	function returnPortHelp2(rtnObjs){
   		var formObj=document.form;
   		var sheetObj=null;
   		if(rtnObjs){
   			var rtnDatas=rtnObjs;
   			if(rtnDatas){
   				if(rtnDatas.length > 0){
   					formObj.pod_port_cd.value=rtnDatas;
   					clearAllFormData(formObj, "POD");
   				}
   			}
   		}
   	}
   	
	/**
	 * Deleting Data of Form Object
	 * @param formObj
	 * @return
	 */
	function clearAllFormData(formObj, flag){
		/*var eleObjs=formObj.elements;
		var len=eleObjs.length;
		for(var i=0; i<len; i++){
			if(flag != null && flag != undefined && flag != ""){
				if(eleObjs[i].name == "pol_port_cd" ||
 				   eleObjs[i].name == "pod_port_cd"){
					//pass
				}else{
					ComClearObject(eleObjs[i]);
				}
			}else{
				ComClearObject(eleObjs[i]);
			}
		}*/
		//Delay Reason Combo Remove...
		/*for(var i=0; i<comboObjects.length; i++){
			comboObjects[i].RemoveAll();
		}*/
		//Delay Reason Editable Setting.
		//delayReasonControl(formObj, false);
		if(flag == "POL"){
			document.form.pol_port_cd.focus();
		}else if(flag == "POD"){
			document.form.pod_port_cd.focus();
		}
	}
   	
    /**
     * @param  {Array} aryPopupData compulsory   Array Object
     * @return none
     */   
     /*function setPodPortCd(aryPopupData){
         with(document.form){
             pod_port_cd.value=aryPopupData[0][2];
             doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC04);               
         }
     } */
     
    /**
     * Handling image Button click event
     * @param  void
     * @return void
     */
    function img_click(){
	    var obj=ComGetEvent();
        var formObj=document.form;
   	    if(obj.name == "srch_pol_port_cd"){
//            var port_cd=document.form.pol_port_cd.value; 
//    	     ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 900, 520, "loc_cd:pol_port_cd", "0,0", true);   
 			sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+port_cd;
    		ComOpenPopup(sUrl, 800, 520, "returnPortHelp1", "0,0", true);
   	    }
   	    if(obj.name == "srch_pod_port_cd"){
            var port_cd=document.form.pod_port_cd.value; 
//          ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 427, 495, "loc_cd:pod_port_cd", "0,0", true);
//          ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 800, 520, "setPodPortCd", "0,0", true);
			sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+port_cd;
    		ComOpenPopup(sUrl, 800, 520, "returnPortHelp2", "0,0", true);
  	    }
  	    if(obj.name == "srch_imdg_un_no"){ 
  	    	 var imdg_un_no=formObj.imdg_un_no.value;
  	    	 ComOpenPopup('/opuscntr/VOP_SCG_3005.do?imdg_un_no='+imdg_un_no,960, 520, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
	    }
  	    if(obj.name == "srch_irregulars_list"){ 
	    	 var imdg_un_no=formObj.imdg_un_no.value;
             if( !ComChkObjValid( formObj.imdg_un_no ) ){
                 return;
             }
             if(document.getElementById('srch_irregulars_list').style.color != 'red') imdg_un_no="";
	    	 var scg_0012=ComOpenPopup('/opuscntr/VOP_SCG_0012Pop.do?pgmNo=VOP_SCG_0012&pop_mode=Y&f_cmd=&imdg_un_no='+imdg_un_no, 1150, 600, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
	    }
    }
    function clearComboObj() {
    	comboObjects[0].RemoveAll();
    	comboObjects[1].RemoveAll();
    	comboObjects[0].SetEnable(0);
    	comboObjects[1].SetEnable(0);
    }
