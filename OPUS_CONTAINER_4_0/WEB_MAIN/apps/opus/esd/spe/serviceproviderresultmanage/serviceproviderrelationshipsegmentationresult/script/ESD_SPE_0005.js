/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0005.js
*@FileTitle : SRS Analysis Result
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
     * @class ESD_SPE_0005 : business script for ESD_SPE_0005 
     */
    function ESD_SPE_0005() {
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

            	    case "btn_sp":
    					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 450, 'getVendor', '1,0,1,1,1,1,1,1');
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
                        InitRowInfo( 2, 1, 9, 100);

                        //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(13, 0, 0, true);

                       // Setting function handling header
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle  = "|Seq.|EG Name|S/P Name|SI Result|SI Result|RA Result|RA Result|SRS Group||||" ;
                        var HeadTitle1 = "|Seq.|EG Name|S/P Name|Point|Group|Point|Group|SRS Group||||" ;


                        //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  true,    "ibflag");
    					InitDataProperty(0, cnt++ , dtSeq		,   	 30,    daCenter,  true,    ""					,	  false,          "",      dfNone,      0,     true ,       true );
                        InitDataProperty(0, cnt++ , dtData	,       	 100,    daCenter,  true,    "eg_name"       ,        false	,          "",       dfNone 		,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtData	,       	 230,    daLeft,  true,    "sp_name"       ,        false	,          "",       dfNone 		,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtData	,       	 90,    daCenter,  true,    "modi_si_scre"  ,        false	,          "",       dfNullFloat,     	1,     false,      false);
						InitDataProperty(0, cnt++ , dtData	,       	 90,    daCenter,  true,    "si_grp_nm"     ,        false	,          "",     dfNone			,     	0,     false,      false);			
						InitDataProperty(0, cnt++ , dtData	,       	 90,    daCenter,  true,    "modi_ra_scre"  ,        false	,          "",       dfNullFloat,     	1,     false,      false);
						InitDataProperty(0, cnt++ , dtData	,       	 120,    daCenter,  true,    "ra_grp_nm"     ,        false	,          "",     dfNone			,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtData	,       	 90,    daCenter,  true,    "srs_grp_nm"    ,        false	,          "",       dfNone 		,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,       	 5,    	daCenter,  true,    "eg_rhq_cd"    	,        false	,          "",       dfNone 		,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,       	 5,    	daCenter,  true,    "eg_cty_cd"    	,        false	,          "",       dfNone 		,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,       	 5,    	daCenter,  true,    "svc_cate_cd"  	,        false	,          "",       dfNone 		,     	0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,       	 5,    	daCenter,  true,    "eg_id2"    	,        false	,          "",       dfNone 		,     	0,     false,      false);																														
    										                                                                                                                                                            
                        RangeBackColor(1,3, 1,7) = RgbColor(222, 251, 248);   // ENIS                                                                                               
                                                                                                                                                                                    
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
                    var param = speFormString(formObj,'f_cmd,f_eg_id,f_ev_yr,f_eg_rhq_cd,f_eg_cty_cd,f_svc_cate_cd,f_vndr_seq,f_vndr_abbr_nm');
                	var searchXml = sheetObj.GetSearchXml("ESD_SPE_0005GS.do", param);                                                                            
    				 if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);                                                                                                    
                    break;                                                                                                                                                          
                                                                                                                                                                                    
            }                                                                                                                                                                       
        }                                                                                                                                                                           
                                                                                                                                                                                    
       /**                                                                                                                                                                          
         * Handling the process for the input validation                                                                                                                                                
         */                                                                                                                                                                         
        function validateForm(sheetObj,formObj,sAction){                                                                                                                            
            with(formObj){                                                                                                                                                          
//                if (!isNumber(iPage)) {                                                                                                                                           
//                                                                                                                                                                                  
//                    return false;                                                                                                                                                 
//                }                                                                                                                                                                 
            }                                                                                                                                                                       
                                                                                                                                                                                    
            return true;                                                                                                                                                            
        }                                                                                                                                                                           
                                                                                                                                                                                    
    	/**                                                                                                                                                                           
    	 * Calling this function in case of closing the popup                                                                                                                                                       
    	 *                                                                                                                                                                            
    	 */                                                                                                                                                                           
    	function getVendor(rArray){                                                                                                                                                   
    		var cArray = rArray[0];                                                                                                                                                     
    		document.all.f_vndr_seq.value = cArray[2];                                                                                                                                  
    		document.all.f_vndr_abbr_nm.value = cArray[4];                                                                                                                              
    	}                                                                                                                                                                             
    	                                                                                                                                                                              
    	                                                                                                                                                                              
       /**                                                                                                                                                                          
         * Checking the validation of the searching condition                                                                                                                                                    
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
    		formObject.f_eg_id.value = sheetObj.CellValue(2,'eg_id2');
    		formObject.f_eg_rhq_cd.value = sheetObj.CellValue(2,'eg_rhq_cd');
    		formObject.f_eg_cty_cd.value = sheetObj.CellValue(2,'eg_cty_cd');
    		formObject.f_svc_cate_cd.value = sheetObj.CellValue(2,'svc_cate_cd');
    	}

