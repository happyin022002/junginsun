/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0012.jsp
*@FileTitle  : OceanLink Information Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     			OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_PRD_0012 : business script for ESD_PRD_0012
     */
var sheetObjects=new Array();
var sheetCnt=0;
var validateData="";
var validateLane="";
var retValidate=0;
document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
         var dispaly ;
         var classId ;
         var param ;
         var chkStr ;
    	try {
    		var srcName=ComGetEvent("name");
              if(srcName != null && !ComIsEmpty(srcName)) {
                  var btnDis=eval("document.getElementById('" + srcName + "').disabled");
                  if (btnDis) return;
              }
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
        	    case "btng_constraint":
        	    	document.location.href="ESD_PRD_0024.do?f_cmd="+SEARCH02+"&fromNd="+sheetObject.GetCellValue(sheetObject.GetSelectRow(), "polprot" ) +"&toNd="+sheetObject.GetCellValue(sheetObject.GetSelectRow(), "podprot" )+"&link_flg=Y&pgmNo=ESD_PRD_0024&parentPgmNo=ESD_PRD_M001&main_page=true";
        	        break;
				/************* ********************** *****************/
        	    case "btn_lane_cd":
                    var slan_cd_val=formObject.vsl_lane_cd.value;
                    dispaly="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
                    classId="COM_ENS_081";
            	    param='?&lane_cd='+slan_cd_val+'&classId='+classId;
            	    chkStr=dispaly.substring(0,3);         
                    // Radio PopUp  
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 500, 'getLane', dispaly);
                    } else {
                       ComShowMessage(ComGetMsg('PRD90063'));
                       return;
                    }
        	        break;        	    
        	    case "btn_pol_cd":
    	            selectPort('POL');
        	        break;
        	    case "btn_pod_cd":
    	            selectPort('POD');
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
        for( var i=0;i<sheetObjects.length;i++ ){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		axon_event.addListener('keydown', 'PrdComKeyEnter' , 'vsl_lane_cd', 'fm_port_cd', 'to_port_cd');
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
	  	var keyObj=ComGetEvent("keycode");
	  	if(keyObj ==undefined) keyObj =0;
 		var srcName=ComGetEvent("name");
 		if(srcName == "vsl_lane_cd"){
	  			inputChkUpper(ComGetEvent(),keyObj , 'SEARCH07');
 		}else if(srcName == "fm_port_cd"){
 			inputChkUpper(ComGetEvent(),keyObj , 'SEARCH02');
 		}else if(srcName == "to_port_cd"){
 			inputChkUpper(ComGetEvent(),keyObj , 'SEARCH02');
 		}
 	}
 	
 	
    /**
    * handling tab event
    * 
    */
    function prdComKeyDown(){
    	var keyObj=ComGetEvent("keycode");
     	if(keyObj == 9){
     		var srcName=ComGetEvent("name");
     		if(srcName == "vsl_lane_cd"){
   	  			inputChkUpper(ComGetEvent(),keyObj , 'SEARCH07');
     		}else if(srcName == "fm_port_cd"){
     			inputChkUpper(ComGetEvent(),keyObj , 'SEARCH02');
     		}else if(srcName == "to_port_cd"){
     			inputChkUpper(ComGetEvent(),keyObj , 'SEARCH02');
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
            	      var HeadTitle="No.|STS|Del.|CHK|SEQ|Lane|Direction|POL|POL|POL|POD|POD|POD|T/Time\n(Day/Hour)|||Source|Remarks" ;
            	      var HeadTitle1="No.|STS|Del.|CHK|SEQ|Lane|Direction|PORT|ETB|ETD|PORT|ETB|ETD|T/Time\n(Day/Hour)|||Source|Remarks" ;

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ 
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:10,   Align:"Right",   ColMerge:1,   SaveName:"rseq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lanecd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,   EditLen:3},
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dircd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"polprot",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,   EditLen:5},
            	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"poletb",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"poletd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"podprot",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,   EditLen:5},
            	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"podetb",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"podetd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fmt_tztm_hrs",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tsIndCd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ocn_lnk_mnl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"source",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"lnk_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
            	       
            	      	InitColumns(cols);

            	      	SetEditable(1);
						SetColProperty("fmt_tztm_hrs", {AcceptKeys:"N", Format:"##D##H"} );
						SetCellBackColor(1,"polprot","#7E7E7E");
						SetCellBackColor(1,"poletb",GetCellBackColor(1,"polprot"));
						SetCellBackColor(1,"poletd",GetCellBackColor(1,"polprot"));
						SetCellBackColor(1,"podprot",GetCellBackColor(1,"polprot"));
						SetCellBackColor(1,"podetb",GetCellBackColor(1,"polprot"));
						SetCellBackColor(1,"podetd",GetCellBackColor(1,"polprot"));
						SetWaitImageVisible(0);
						SetColProperty(0 ,"poletb", {ComboText:day_cdText, ComboCode:day_cdCode} );
						SetColProperty(0 ,"poletd", {ComboText:day_cdText, ComboCode:day_cdCode} );
						SetColProperty(0 ,"podetb", {ComboText:day_cdText, ComboCode:day_cdCode} );
						SetColProperty(0 ,"podetd", {ComboText:day_cdText, ComboCode:day_cdCode} );
						SetColProperty(0 ,"dircd",  {ComboText:dir_cdText, ComboCode:dir_cdCode} );
						SetColProperty(0 ,"lanecd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
						SetColProperty(0 ,"polprot" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
						SetColProperty(0 ,"podprot" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
						ComResizeSheet(sheetObj);
            	      }


                break;
        }
    }

    
    /**
    * handling of Sheet process
    */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
        switch(sAction) {
           case IBSEARCH:
             if(!validateForm(sheetObj,formObj,sAction)) {return;}
             	ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_PRD_0012GS.do", PrdFQString(formObj) , {Sync:2});
             ComOpenWait(false);
				break;
            case IBSAVE:
	        	ComOpenWait(true);
	            if(!validateForm(sheetObj,formObj,sAction)) {
	            	ComOpenWait(false);
	                return;
	            }
	            formObj.f_cmd.value=MODIFY;//MULTI;
	            
	            var qryStr=PrdFQString(formObj);
	            var saveString=sheetObj.GetSaveString(false);
	         
	            if (saveString == null || saveString == '') { 
	                ComShowCodeMessage("COM130503"); 
	                ComOpenWait(false);
	                return; 
	            }   
	            var re=new RegExp("ibflag=D", "g");
	            var result=re.test(saveString);
	            if(result && !ComShowCodeConfirm("PRD90128")){ 
	            	ComOpenWait(false);
	            	return; 
	            }
	            // ending when there is problem in creating Back End Job
	            var sXml=sheetObj.GetSearchData("ESD_PRD_0012GS.do" , qryStr + "&" + saveString  );
	            if (sXml == "") {
	                ComShowCodeMessage("PRD90127");
	                ComOpenWait(false); 
	                return;
	            } else {
	                var re2=new RegExp("ERROR", "g");
	                var result2=re2.test(sXml);
	                if (result2) {
	                	sheetObj.LoadSaveData(sXml);
	                    ComOpenWait(false);
	                    return;
	                }
	            }
	            var sKey=ComGetEtcData(sXml, "back_end_job_key");
	            var sQryStr="f_cmd=" + SEARCH01 
	                         + "&delt_flg=" + formObj.delt_flg[formObj.delt_flg.selectedIndex].value
	                         + "&vsl_lane_cd=" + formObj.vsl_lane_cd.value 
	                         + "&fm_port_cd=" + formObj.fm_port_cd.value 
	                         + "&to_port_cd=" + formObj.to_port_cd.value
	                         + "&skd_dir_cd=" + formObj.skd_dir_cd.value;
	            intervalId=setInterval("doActionSaveResult (sheetObjects[0], '"
	                         + sQryStr
	                         + "&back_end_job_key=" + sKey
	                         + "');"
	                         , 5000);
	         
                break;
            case IBINSERT:
            if(!validateForm(sheetObj,formObj,sAction)) {return;}
            ComOpenWait(true);
                 sheetObj.DataInsert();
            ComOpenWait(false);
                break;
           case IBCOPYROW:        
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL:        
        	   ComOpenWait(true);
        	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
        	   ComOpenWait(false);
        	   break;
           case SEARCH02:
        	ComOpenWait(true);
              formObj.f_cmd.value=SEARCH02;
              uid="ESD_PRD_0012";
              sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
              ComShowMessage(ComResultMessage(sXml));
            ComOpenWait(false);
              break; 
           case SEARCH07:
        	  ComOpenWait(true);
              formObj.f_cmd.value=SEARCH07;
              uid="ESD_PRD_0012";
              sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
              ComShowMessage(ComResultMessage(sXml));
              ComOpenWait(false);
              break;  
           case SEARCH09:
        	ComOpenWait(true);
              formObj.f_cmd.value=SEARCH09;
              uid="ESD_PRD_0012";
              sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml,"rowCount");
              validateLane=ComGetEtcData(sXml,"comData1");
              ComShowMessage(ComResultMessage(sXml));
            ComOpenWait(false);
              break;                             
        }
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
         switch(sAction) {
         case IBSAVE:
              var duprows = sheetObj.ColValueDupRows("lanecd|polprot|podprot|dircd");
              if (duprows != undefined && duprows != '') {
                  var dupArr=duprows.split(",");
					ComShowCodeMessage("COM131302", ["HQ Link '" + sheetObj.GetCellValue(dupArr[0],"polprot")
					+ "-(" + sheetObj.GetCellValue(dupArr[0],"lanecd")
					+ ")-" + sheetObj.GetCellValue(dupArr[0],"podprot") + "'"]);
                  return false;
              }
              break;
         }
        return true;
    }
	/******************************************************************************/
     /**
      * onChange event of select box
      * 
      */     
	function changeDirection() {
		var frm=document.form;
		var val=frm.select1[frm.select1.selectedIndex].value;
		frm.skd_dir_cd.value=(val==0) ? "" : val;
	}
    /**
    *  handling parameters from COM_ENS_081(pop up)
    * 
    */
    function getLane(rowArray) {
    	var colArray=rowArray[0];
    	document.all.vsl_lane_cd.value=colArray[3];
    }
    /**
    * Location Validation 
    * 
    */
    function validateLocation(loc, num) {
    	if (num ==1) {
        	document.form.fm_port_cd.value=loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.to_port_cd.value=loc.toUpperCase();
    	}        
        validateData=loc.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form, SEARCH02);
    	if(retValidate < 1) { //if row count is lesser than 1 
        	if (num ==1) {
            	document.form.fm_port_cd.focus();
        	}else {
        	    document.form.to_port_cd.focus();
        	}
    	}else {
        	if (num ==1) {
            	document.form.to_port_cd.focus();
        	}
    	}
    	return false;
    }  
	var portInd='';
    /**
    * calling pop up of 'pol' and 'pod' 
    * 
    */
	function selectPort(pt){
	    var frm=document.form;
		var param='?loc_port_ind=1';
		portInd=pt;
		if(portInd == 'POL'){
			 param=param+'&loc_cd='+frm.fm_port_cd.value ;
		}
		if(portInd == 'POD'){
		     param=param+'&loc_cd='+frm.to_port_cd.value ;
		}		
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 500, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
    /**
    * handling parameters from COM_ENS_051(pop up)
    */	
	function getCOM_ENS_051(rArray) {
		var cArray=rArray [0];
		var frm=document.form;
		if(portInd == 'POL'){
			 frm.fm_port_cd.value=cArray[3];
		}
		if(portInd == 'POD'){
			 frm.to_port_cd.value=cArray[3];
		}
	}	
    /**
    * sheet1 onChange event
    */
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        var sName=sheetObj.ColSaveName(Col);
        if (sName == "dircd" || sName == "poletb" || sName == "poletd"|| sName == "podetb"|| sName == "podetd" || sName == "fmt_tztm_hrs"|| sName == "lnk_rmk") {
              sheetObj.SetCellValue(Row,"chk",1,0);
        }
        if(sName == "polprot" ||sName == "podprot" ){
            validateData=Value;
            doActionIBSheet(sheetObj,document.form, SEARCH02);
            if(retValidate < 1) {
                if(sName == "polprot") {
                   sheetObj.SetCellValue(Row,"polprot","",0);
                   sheetObj.SelectCell(Row,"polprot");
                } else if (sName == "podprot") {
                   sheetObj.SetCellValue(Row,"podprot","",0);
                   sheetObj.SelectCell(Row,"podprot");
                }
            }
        }
        // checking if FDR is
        if(sName=="lanecd") {
            validateData=Value;
            validateLane="";
            doActionIBSheet(sheetObj,document.form, SEARCH09); 
            if(validateLane == 'O') { // in case of fdr 
                   ComShowMessage(ComGetMsg('PRD90098'));
                   sheetObj.SetCellValue(Row,"lanecd","",0);
                   sheetObj.SelectCell(Row,"lanecd");
            } 
            if(retValidate < 1){
            	sheetObj.SetCellValue(Row,"lanecd","",0);
            	sheetObj.SelectCell(Row,"lanecd");
            }
        }
        if(sName == "fmt_tztm_hrs"){
        	if(Value.length < 4) {
        		sheetObj.SetCellValue(Row,Col, "", 0);
        		sheetObj.SelectCell(Row, Col);
        		return false;
        	} else {
        		var day = Value.substr(0, 2);
        		var hour = Value.substr(2, 2);
        		if(hour > 23) {
        			ComShowMessage(ComGetMsg('PRD90015'));
        			sheetObj.SetCellValue(Row,Col,"",0);
        			sheetObj.SelectCell(Row, Col);
        			return false;
        		}
        		if(parseInt(Value) > 9923  ){
            		ComShowMessage(ComGetMsg('PRD90099'));
            		sheetObj.SetCellValue(Row,Col,"",0);
            		sheetObj.SelectCell(Row, Col);
            		return false;
            	}
        	}
        }
		if (sheetObj.ColSaveName(Col) == "del" && sheetObj.GetCellValue(Row, "del") =='1') {
			if( sheetObj.GetCellValue(Row, "source") =="Auto Creation" ){
                ComShowMessage(ComGetMsg('PRD90126'));
                sheetObj.SetCellValue(Row, "del",'0',0);//이렇게 해야 체크가 풀린다.
            }
        }
		if (sheetObj.ColSaveName(Col) == "del" && sheetObj.GetCellValue(Row, "source") =='Manual Deletion' && Value == '1') {
            sheetObj.SetCellValue(Row, "del",'1',0);
        }
		
    }    
     /**
      * Sub Function of DoActionIBSheet<br>
      * handling result and monitoring of Backend job<br>
      * <br>
      * <b>Example : </b>
      *
      * <pre>
      * </pre>
      *
      * @param {Object}
      *            sheetObj mandatory, Object
      * @param {String}
      *            queryString mandatory, HTML String
      * @return {void}
      */
     function doActionSaveResult(sheetObj, queryString) {
    	 var sXml=sheetObj.GetSearchData("ESD_PRD_0012GS.do" , queryString);
         var sJbStsFlg="";
         if (sXml == "") {
             // 'While {?msg1}, network problem or system shutdown occurred'
             clearInterval(intervalId);
             ComShowCodeMessage("PRD90129", ["saving HQ Link"]);
              ComOpenWait(false);
             return;
         }
         // ending waiting status when error occurs
         var txState=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
         if (txState == "F") {
             clearInterval(intervalId);
             ComShowCodeMessage("COM12151", ["HQ Link"]);
             ComOpenWait(false);
             return;
         }
         sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
         if (sJbStsFlg == "3" || sJbStsFlg == "4") {
             clearInterval(intervalId);
             ComOpenWait(false);
             if (sJbStsFlg == "3") {
                 sheetObj.RemoveAll();
                 sheetObj.LoadSearchData(sXml,{Sync:1} );
                 ComShowCodeMessage("COM130102", ["HQ Link"]);
             } else if (sJbStsFlg == "4") {
                 ComShowCodeMessage("PRD90127");
                 return;
             }
         }
     }
