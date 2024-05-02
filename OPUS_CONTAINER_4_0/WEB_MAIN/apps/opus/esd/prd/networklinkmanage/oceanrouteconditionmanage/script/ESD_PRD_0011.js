/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0011.js
*@FileTitle : Calling Terminal Matrix by Lane/Carrier
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     			OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_PRD_0011 : business script for ESD_PRD_0011
     */
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var validateData="";
var retValidate=0;
var invalid_tab='';
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var formObject=document.form;
         var dispaly ;
         var classId ;
         var param ;
         var chkStr ;
    	try {
    		var srcName=ComGetEvent("name");
              if(srcName != null && !ComIsEmpty(srcName)) {
                 btnDis=eval("document.getElementById('" + srcName + "').disabled");
                  if (btnDis) return;
              }
            /****************************
             handling enterKey
            *****************************/
            var srcObj=ComGetEvent("nodeName");
            var keyObj=window.event.keyCode;
            /****************************/              
            switch(srcName) {
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;
        	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;
        	    case "btn_downexcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
	        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					}
        	        break;
        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	    case "btng_rowcopy":
      	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;
        	    case "btn_port":
                    dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	        classId="COM_ENS_051";
        		    param='?classId='+classId+'&loc_cd='+formObject.i_port_cd.value;
        		    chkStr=dispaly.substring(0,3)
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 470, 'getPortLoc', dispaly, true);
                    } else {
                         ComShowMessage(ComGetMsg('PRD90063'));
                         return;
                    }
        	        break;
        	    case "btn_tml":
                    var loc_cd_val=formObject.i_tml_cd.value;
                    dispaly="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    classId="COM_ENS_061";
            	    param='?node_cd='+loc_cd_val+'&classId='+classId;
            	    chkStr=dispaly.substring(0,3)          
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', dispaly, true);
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
        	        break;       
        	    case "btn_slan":
                    var slan_cd_val=formObject.i_vsl_slan_cd.value;
                    dispaly="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    classId="COM_ENS_081";
            	    param='?&lane_cd='+slan_cd_val+'&classId='+classId;
            	    chkStr=dispaly.substring(0,3);         
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLane', dispaly, true);
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
        	        break;
        	    case "btn_crr":
                    dispaly="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    classId="COM_ENS_0N1"; //ESD_PRD_0030
                    param='?classId='+classId+'&func=getCarrierCd&display='+dispaly+'&crr_cd='+formObject.i_crr_cd.value;
            	    chkStr=dispaly.substring(0,3);          
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                          myWin=ComOpenWindowCenter('COM_ENS_0N1.do'+param, 'compop', 770,500, true);
        	              ///myWin.focus();
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
        	        break;         	        
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); 
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_port_cd', 'i_vsl_slan_cd', 'i_crr_cd','i_tml_cd');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'i_port_cd', 'i_vsl_slan_cd', 'i_tml_cd');
		axon_event.addListenerForm('change', 'form_onChange' , form);
    }
    
 	function form_onChange(evt,el) {
	  	var formObj=document.form;
	  	var xml="";
	  	var srcName;
	  	var srcValue;
	  	if (el) {
	  		srcName=el.getAttribute("name");
	  		srcValue=el.getAttribute("value");
	  	} else {
	  		srcName=ComGetEvent("name");
	  		srcValue=ComGetEvent("value");
	  	}
	  	var srcMaxLength=ComGetEvent("maxlength");
	  	var objVal=eval('document.form.'+srcName+'.value');
	    var keyObj=ComGetEvent("keycode");
	  	if(keyObj ==undefined) keyObj =0;
		if(srcName == "i_port_cd" && srcMaxLength == objVal.length){
	  		inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
		}else if(srcName == "i_vsl_slan_cd"){
			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH10');
		}else if(srcName == "i_tml_cd"){
			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH05');
		}
 	}
   function prd011_obj_deactivate() {
	   var keyObj=window.event.keyCode;
	   var srcName=ComGetEvent("name");
	   var srcMaxLength=ComGetEvent("maxlength");
	   var objVal=eval('document.form.'+srcName+'.value');
	   validateData=objVal.toUpperCase();
	   
		if(srcName == "i_port_cd" && srcMaxLength == objVal.length){
			doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		}else if(srcName == "i_vsl_slan_cd"){
			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH10');
		}else if(srcName == "i_tml_cd"){
			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH05');
		}
   }
   /**
    * handling tab event
    * @return
    */  
   function prdComKeyDown(){
	   var keyObj=window.event.keyCode;
    	if(keyObj == 9){
    		var srcName=ComGetEvent("name");
    		if(srcName == "i_port_cd"){
  	  			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
    		}else if(srcName == "i_vsl_slan_cd"){
    			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH10');
    		}else if(srcName == "i_tml_cd"){
    			inputChkUpper(window.event.srcElement,keyObj , 'SEARCH05');
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
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
            	      var HeadTitle="Del.|STS|No.|Port Code|Lane Code|BD|Carrier|TMNL Code|Terminal Name|Creation DT|Update DT|User ID" ;

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
            	             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tml_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
            	             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"yd_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	       
            	      InitColumns(cols);

            	      SetEditable(1);
                  	SetColProperty("skd_dir_cd", {ComboText:"E|W|N|S", ComboCode:"E|W|N|S"} );
                  	SetColProperty(0 ,"tml_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	        resizeSheet();
        	      }
                break;
        }
    }

    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
	    sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      
                if(!validateForm(sheetObj,formObj,sAction)) return;
                if(!validatePort(formObj.i_port_cd.value) ) {
                	return;
                }
                formObj.f_cmd.value=SEARCHLIST;
                sheetObj.DoSearch("ESD_PRD_0011GS.do", PrdFQString(formObj) , {Sync:2});
                break;
            case IBSAVE:        
              if(!validateForm(sheetObj,formObj,sAction)) return;
                formObj.f_cmd.value=MULTI;
                sheetObj.SetDataAutoTrim(1);
                sheetObj.DoSave("ESD_PRD_0011GS.do", PrdFQString(formObj));
                sheetObj.SetDataAutoTrim(0);
                break;
           case IBINSERT:      
                if(!validateForm(sheetObj,formObj,sAction)) return;
                var Row=sheetObj.DataInsert();
                sheetObj.SetCellValue(Row, "port_cd",formObj.i_port_cd.value,0);
                sheetObj.SetCellValue(Row, "vsl_slan_cd","FDR",0);
                sheetObj.SetCellValue(Row, "crr_cd","FDR",0);
                break;
           case IBCOPYROW:        
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL:        
        	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });        	   
              break;
           case SEARCH01:
              formObj.f_cmd.value=SEARCH01; 
              uid="ESD_PRD_0011";
              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
	        	if(retValidate < 1) {
	        		document.form.i_port_cd.value='';
	        		document.form.i_port_cd.select();    	        
	                document.form.i_port_cd.focus();
	                return false ;
	        	}else {
	        	    document.form.i_vsl_slan_cd.focus();  
	        	}
              break;
           case SEARCH05:
              formObj.f_cmd.value=SEARCH05;
              uid="ESD_PRD_0011";
              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
              break;   
           case SEARCH10:
              formObj.f_cmd.value=SEARCH10;
              uid="ESD_PRD_0011";
              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
              break;  
           case SEARCH11:
              formObj.f_cmd.value=SEARCH11;
              uid="ESD_PRD_0011";
              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
                if(retValidate < 1) {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"tml_cd","",0);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"yd_nm","",0);
                    sheetObj.SelectCell(sheetObj.GetSelectRow(),"tml_cd");
                }              
              break;    
           case SEARCH04:
               formObj.f_cmd.value=SEARCH04;
               uid="ESD_PRD_0011";
               sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
               retValidate=ComGetEtcData(sXml, "rowCount");
               if (retValidate > 0) {
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "yd_nm",ComGetEtcData(sXml, "comData1"),0);
               }else{
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "tml_cd","",0);
                   sheetObj.SetCellValue(sheetObj.GetSelectRow(), "yd_nm","",0);
                   sheetObj.SelectCell(sheetObj.GetSelectRow(),"tml_cd");
               }
               break;              
        }
    }
// handling pop up open
    function sheet1_OnPopupClick(sheetObj, row, col){
		var lane_cd ;
		var param ;
        if ( sheetObj.ColSaveName(col) == "vsl_slan_cd"   )
        {
        	lane_cd=sheetObj.GetCellValue(row, col);
            param='?&lane_cd='+lane_cd;
            ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 550, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,true, row, col);
        } else if ( sheetObj.ColSaveName(col) == "crr_cd" )
        {
        	lane_cd=sheetObj.GetCellValue(row, col);
            param='?&lane_cd='+lane_cd;
            ComOpenPopup('/opuscntr/COM_ENS_0N1.do' + param, 800, 550, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,true,row, col);
        } else if ( sheetObj.ColSaveName(col) == "tml_cd" )
        {
        	var tml_cd=sheetObj.GetCellValue(row, col);
            param='?&node_cd='+tml_cd;
            ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getPop2Grid', "1,0,1,1,1,1,1,1,1,1,1,1", true,true,row, col);
        } 
    }
    function getPop2Grid(rowArray, row, col) {
        var sheetObj=sheetObjects[0];
    	var colArray=rowArray[0];
        if (sheetObj.ColSaveName(col) == "vsl_slan_cd")
    	{
        	sheetObj.SetCellValue(row, "vsl_slan_cd",colArray[3],0);
    	} else if (sheetObj.ColSaveName(col) == "crr_cd")
    	{
        	sheetObj.SetCellValue(row, "crr_cd",colArray[3],0);
    	} else if (sheetObj.ColSaveName(col) == "tml_cd")
    	{
        	sheetObj.SetCellValue(row, "tml_cd",colArray[3],0);
        	sheetObj.SetCellValue(row, "yd_nm",colArray[4],0);
    	}
    	sheet1_OnChange(sheetObj,row,col,colArray[3])
    }
    function getPortLoc(rowArray) {
    	var colArray=rowArray[0];
    	document.all.i_port_cd.value=colArray[3];
    }
/**
 * Location : in case of single selection of radio button on pop up
 */
    function getNode(rowArray, row, col) {
        var sheetObj=sheetObjects[1];
    	var colArray=rowArray[0];
    	document.all.i_tml_cd.value=colArray[3];
    }
    function getLane(rowArray) {
    	var colArray=rowArray[0];
    	document.all.i_vsl_slan_cd.value=colArray[3];
    	validateData=document.all.i_vsl_slan_cd.value;
        doActionIBSheet(sheetObjects[0],document.form,SEARCH10);    
        if(retValidate < 1 ) {
            document.all.i_vsl_slan_cd.focus();
        }
    }
    function getCarrierCd(rowArray) {
    	var colArray=rowArray[0];
    	document.all.i_crr_cd.value=colArray[3];
    }
  	// checking validation for port code
    function validatePort(port) {
        validateData=port.toUpperCase();
        document.form.i_port_cd.value=port.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	if(retValidate < 1) {
    		return false;
    	} else{
    		return true;
    	}
    }
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        if(sheetObj.ColSaveName(Col)=="tml_cd"){
        	if( Value.substr(0,5) != sheetObj.GetCellValue(Row,"port_cd")  ) {
        		ComShowMessage(ComGetMsg('PRD90059'));
        		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"tml_cd","",0);
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),"yd_nm","",0);
                sheetObj.SelectCell(sheetObj.GetSelectRow(),"tml_cd");
        		return;
        	}
        	validateData=sheetObj.GetCellValue(Row,"tml_cd");
            doActionIBSheet(sheetObj,document.form, SEARCH04);
        }
    }
  	//checking validation for tml code
    function validateTml(tml) {
        validateData=tml.toUpperCase();
        document.form.i_tml_cd.value=tml.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH05);
    	if(retValidate < 1) {
        	document.form.i_tml_cd.value="";
        	document.form.i_tml_cd.focus();
    	}
    }    
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if( formObj.i_port_cd.value.length != 5 ) {
             ComShowMessage(ComGetMsg('PRD90007'));
             formObj.i_port_cd.focus();;
             return false;
        } 
        return true;
    }

    function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
		 ComOpenWait(false);
    }
