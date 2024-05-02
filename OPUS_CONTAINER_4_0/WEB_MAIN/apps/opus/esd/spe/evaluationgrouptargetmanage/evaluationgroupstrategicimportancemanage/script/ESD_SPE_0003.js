/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0003.js
*@FileTitle : SI Analysis Result
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
     * @class ESD_SPE_0003 : business script for ESD_SPE_0003 
     */
    function ESD_SPE_0003() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
 // The common global variables

 var sheetObjects = new Array();
 var sheetCnt = 0;

 /* Event handler processing by button click event */
 document.onclick = processButtonClick;

 /* Event handler processing by button name */
     function processButtonClick(){
          var sheetObject = sheetObjects[0];

          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

         	    case "btn_retrieve":
     	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					break;

         	    case "btn_apply":
         	        break;

         	    case "btng_delete":
         	        break;

 				case "btn_save":
 					doActionIBSheet(sheetObject,formObject,IBSAVE);
 					break;

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }

     /**
      * Registering IBSheet Object as list
      * Adding process for list in case of needing batch processing with other items
      * Defining list on the top of source
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
     }

      
    /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets 
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //IBSheet1 init
                 with (sheetObj) {
                     //Setting width
                     SheetWidth = mainTable.clientWidth;

                     //Setting the Host information[Required][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //Kind of merge [Optional, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //Edit kind [Optional, Default false]
                     Editable = true;

                     //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 9, 100);

                     //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(17, 0, 0, true);

                    // Setting function handling header
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "DEL|||EG ID||||||EG Name||Business Importance\n(X-Axis)|Difficulties of Switching\n(Y-Axis)|||SI Group|" ;

                     //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,      30,    daCenter,  false,    "chk"		   ,	    false  ,          "",        dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtHidden	,    30,    daCenter,  true,    "temp_ibflag");
					InitDataProperty(0, cnt++ , dtData	,        90,    daCenter,  true,    "eg_id2"	   ,        false	,          "",       dfNone 		,     	0,     false,      false);			
					InitDataProperty(0, cnt++ , dtHidden,        90,    daCenter,  true,    "eg_id"		   ,        false	,          "",       dfNone 		,     	0,     false,      false);			
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  true,    "eg_id_seq"    ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  true,    "eg_rhq_cd"    ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  true,    "eg_cty_cd"    ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  true,    "svc_cate_cd"  ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtData	,      	110,    daCenter,  true,    "eg_nm"        ,        false	,          "",       dfNone 		,     	0,     false,      false);     
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  true,    "ev_yr"        ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtData	,      	150,    daRight ,  true,    "bi_scre"      ,        false   ,          "",       dfNullFloat	,     	1,     true ,       true, 2);     	
					InitDataProperty(0, cnt++ , dtData	,      	150,    daRight ,  true,    "ds_scre"      ,        false   ,          "",       dfNullFloat	,     	1,     true ,       true, 2);     	
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daRight ,  true,    "si_scre"      ,        false   ,          "",       dfNullFloat	,     	1,     false,      false, 2);     	
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  true,    "si_grp_cd"    ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtData	,      	120,    daCenter,  true,    "si_grp_nm"    ,        false	,          "",       dfNone 		,     	0,     false,      false);     	
					InitDataProperty(0, cnt++ , dtHidden,      	120,    daCenter,  true,    "vndr_seq"     ,        false	,          "",       dfNone 		,     	0,     false,      false);     	

                     style.height = 270;
                }
                 break;

         }
     }

   // Handling the process about the sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //retrieving
  	            if(validateForm(sheetObj,formObj,sAction))
 	             	if(!spe_checkRequiredField(formObj)) return;
	            	formObj.f_cmd.value = SEARCH;
	            var param = speFormString(formObj,'f_cmd,f_eg_id,ev_yr,f_eg_rhq_cd,f_eg_cty_cd,f_svc_cate_cd,f_mapping_div');	
				var searchXml = sheetObj.GetSearchXml("ESD_SPE_0003GS.do", param);
				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
				break;
	             
			 case IBSAVE:		//saving
				formObj.f_cmd.value = MULTI;			    
		        var param = sheetObj.GetSaveString(true);
		        var param1 =speFormString(formObj,'f_cmd');
			    var savexml = sheetObj.GetSaveXml("ESD_SPE_0003GS.do", param+'&'+ param1);
				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
					break;                

         }
     }

    /**
      * Handling the process for the input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(iPage)) {
 //
//                 return false;
//             }
         } 

         return true;
     }
     
     /**
      * Calling this function in case of changing the cell value in sheet
      **/
 	  function sheet1_OnChange(sheet1, row, col){
 			if (sheet1.ColSaveName(col) == "bi_scre"){
 				  if(!validateValue(sheet1, row, col)){
 				  	ComShowCodeMessage("SPE10003","1.0","4.0");
 				  	 sheet1.CellValue2(row, col) = 0.0;
 				  	 return false;
 				  }
 					calcSIGrpCD(sheet1, row);
 			}else if (sheet1.ColSaveName(col) == "ds_scre"){
 				  if(!validateValue(sheet1, row, col)){
 				  	 ComShowCodeMessage("SPE10003","1.0","4.0");
 				  	 sheet1.CellValue2(row, col) = 0.0;
 				  	 return false;
 				  }
 					calcSIGrpCD(sheet1, row);
 			}

 	 }
 	
    /**
      * Validating the range of the inputted value
      */
 	 function validateValue(sheetObj, row, col){
 	 		if(1.0 <= sheetObj.CellValue(row, col) && sheetObj.CellValue(row, col) <= 4.0)
 	 			return true;
 	 		else
 	 			return false;
 	}
    /**
      * Calculating Si Grp CD
      */
     function calcSIGrpCD(sheetObj, row){
     	var bi_scre_cd = "";
     	var ds_scre_cd = "";
     	
     	if(1.0 <= sheetObj.CellValue(row, "bi_scre") && sheetObj.CellValue(row, "bi_scre") < 2.5)
     			bi_scre_cd = "L";
     	else if(2.5 <= sheetObj.CellValue(row, "bi_scre") && sheetObj.CellValue(row, "bi_scre") <= 4.0)
     			bi_scre_cd = "H";
     	
     	if(1.0 <= sheetObj.CellValue(row, "ds_scre")  && sheetObj.CellValue(row, "ds_scre") < 2.5)
     			ds_scre_cd = "L";
     	else if(2.5 <= sheetObj.CellValue(row, "ds_scre")  && sheetObj.CellValue(row, "ds_scre") <= 4.0)
     			ds_scre_cd = "H";
     			
     			
     	if(bi_scre_cd == "L" && ds_scre_cd == "L"){
     		sheetObj.CellValue(row, "si_grp_cd") = "RT";
     		sheetObj.CellValue(row, "si_grp_nm") = "Routine";
     	}else if(bi_scre_cd == "L" && ds_scre_cd == "H"){
     		sheetObj.CellValue(row, "si_grp_cd") = "BN";
     		sheetObj.CellValue(row, "si_grp_nm") = "Bottleneck";
     		
     	}else if(bi_scre_cd == "H" && ds_scre_cd == "L"){
     		sheetObj.CellValue(row, "si_grp_cd") = "LV";
     		sheetObj.CellValue(row, "si_grp_nm") = "Leverage";
     		
     	}else if(bi_scre_cd == "H" && ds_scre_cd == "H"){
     		sheetObj.CellValue(row, "si_grp_cd") = "CR";
     		sheetObj.CellValue(row, "si_grp_nm") = "Critical";
     		
     	}
      	
     	if(sheetObj.CellValue(row, "temp_ibflag") == "I"){
     		if(sheetObj.CellValue(row, "si_grp_cd") != ""){
     			sheetObj.RowStatus(row) = "I";
     		}else{
     			sheetObj.RowStatus(row) = "R";
     		}
     	}
     	
     }
     
    /**
      * Validating the searching condition
      */
      function spe_checkRequiredField(formObj){    	  
       	if(formObj.f_eg_id.value == ""){
        		if(formObj.f_eg_rhq_cd.value == "" || formObj.f_eg_cty_cd.value == "" || formObj.f_svc_cate_cd.value == ""){
        			    ComShowCodeMessage("SPE10004","EG ID, EG Choicer(Level 1,Level 2,Level 3)");
       				return false;
       			}
       	}
       	return true;
       }

     function sheet1_OnSearchEnd(sheetObj,ErrMsg){
 		var formObject = document.form;
 		formObject.f_eg_id.value = sheetObj.CellValue(1,'eg_id2');
 		formObject.f_eg_rhq_cd.value = sheetObj.CellValue(1,'eg_rhq_cd');
 		formObject.f_eg_cty_cd.value = sheetObj.CellValue(1,'eg_cty_cd');
 		formObject.f_svc_cate_cd.value = sheetObj.CellValue(1,'svc_cate_cd');
 	}

